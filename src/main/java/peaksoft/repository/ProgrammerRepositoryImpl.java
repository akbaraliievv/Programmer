package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.ConfigurationHibernate;
import peaksoft.entity.Country;
import peaksoft.entity.Programmer;

import java.util.List;

public class ProgrammerRepositoryImpl implements ProgrammerRepository,AutoCloseable{
    private final EntityManagerFactory entityManagerFactory = ConfigurationHibernate.getManagerFactory();
    @Override
    public void close() throws Exception {
      entityManagerFactory.close();
    }

    @Override
    public void saveProgrammer(Programmer programmer) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(programmer);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Programmer> saveAll(List<Programmer> programmer) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            for (Programmer programmers:programmer) {
                entityManager.persist(programmers);}
            entityManager.getTransaction().commit();
            entityManager.close();
            return programmer;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }


    @Override
    public Programmer findById(Long programmerId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Programmer id = entityManager.createQuery("from Programmer p where p.id=:programmerId",
                    Programmer.class).setParameter("id", programmerId).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return id;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }
    @Override
    public String deletedById(Long programmerId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Programmer id = entityManager.createQuery("from Programmer p where p.id=:programmer", Programmer.class)
                    .setParameter("id", programmerId).getSingleResult();
            entityManager.remove(id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully deleted !!!";
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public void deletedAll() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete Programmer").executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String updated(Programmer programmer,Long programmerId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Programmer reference = entityManager.getReference(Programmer.class, programmerId);
            reference.setFullName(programmer.getFullName());
            reference.setEmail(programmer.getEmail());
            reference.setDateOfBirth(programmer.getDateOfBirth());
            reference.setStatus(programmer.getStatus());
            reference.setLocation(programmer.getLocation());
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully updated";
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public Country countFrom(Long countryId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Country result = entityManager.createQuery("select c.country, count (c.country)from Programmer p join Address a on p.id=a.id join Country c on a.id=c.id where c='KYRGYZSTAN' group by c.country", Country.class).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return result;
            } catch (HibernateException e) {
            System.out.println(e.getMessage());
            }return null;
    }

    @Override
    public Programmer getYoungProgrammer() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Programmer result = entityManager.createQuery("from Programmer order by dateOfBirth  limit 1", Programmer.class).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public Programmer getOldProgrammer() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Programmer result = entityManager.createQuery("from Programmer order by dateOfBirth desc limit 1", Programmer.class).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }
}
