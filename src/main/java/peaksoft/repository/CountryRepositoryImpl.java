package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.ConfigurationHibernate;
import peaksoft.entity.Country;

import java.util.List;
import java.util.Objects;

public class CountryRepositoryImpl implements CountryRepository,AutoCloseable{
    private final EntityManagerFactory entityManagerFactory = ConfigurationHibernate.getManagerFactory();
    public void close() throws Exception {
entityManagerFactory.close();
    }

    public void saveCountry(Country country) {
        try{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(country);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Country> saveAllCountry(List<Country> country) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            for (Country countries : country) {
                entityManager.persist(countries);
            }
            entityManager.getTransaction().commit();
            entityManager.close();
            return country;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }
    public List<Country> findAll() {
            try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Country> fromCountry = entityManager.createQuery("from Country ").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return fromCountry;
            } catch (HibernateException e) {
            System.out.println(e.getMessage());
            }return null;
            }

    public Country findById(Long countryId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Country singleResult = entityManager.createQuery("from Country c where c.id=:contryId", Country.class).setParameter("id", countryId).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return singleResult;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    public String deletedById(Long countryId) {
        try {
            assert entityManagerFactory != null;
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Country singleResult = entityManager.createQuery("from Country c where c.id=:countryId", Country.class).setParameter("id", countryId).getSingleResult();
            entityManager.remove(entityManager.merge(singleResult));
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully deleted by id !!!! ";
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    public void deletedAll() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete Country").executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public String updated(Country country, Long countryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country reference = entityManager.getReference(Country.class, countryId);
        reference.setCountry(country.getCountry());
        reference.setAddress(country.getAddress());
        reference.setDescription(country.getDescription());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated ";
    }

    public Country longByDescription() {
        try{
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Country singleResult = entityManager.createQuery("select description from Country c order by length(description) desc limit 1", Country.class).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return singleResult;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }return null;
        }

    public Integer getSameCountryProgrammer(String country) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            int update = entityManager.createQuery("select count(c.id) from Country c where c.country = :country", Country.class).
                    setParameter("country", country).executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
            return update;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
