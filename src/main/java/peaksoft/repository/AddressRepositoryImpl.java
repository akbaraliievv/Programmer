package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import peaksoft.config.ConfigurationHibernate;
import peaksoft.entity.Address;

import java.util.List;

public class AddressRepositoryImpl implements AddressRepository,AutoCloseable{
    private final EntityManagerFactory entityManagerFactory = ConfigurationHibernate.getManagerFactory();
    public void saveAddress(Address address) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(address);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Address> saveAllAddress(List<Address> address) {
            try {
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
                for (Address address1:address) {
                    entityManager.persist(address1);}
                    entityManager.getTransaction().commit();
                    entityManager.close();
                    return address;
            }catch (HibernateException e) {
                System.out.println(e.getMessage());
                return null;
            }
    }

    public String assignAddressToCountry(Long addressId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.getTransaction().commit();
            entityManager.close();
            return "";
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Address findById(Long addressId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Address address = entityManager.createQuery("from Address a where a.id=:addressId", Address.class).setParameter("id", addressId).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return address;
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }return null;
    }

    public String deletedById(Long addressId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Address> id = entityManager.createQuery("from Address a where a.id=:addressId").setParameter("id", addressId).getResultList();
            entityManager.remove(id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully deleted !!!!!";
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deletedAll() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete Address").executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public String updated(Address address, Long addressId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Address references = entityManager.getReference(Address.class, addressId);
            references.setRegionName(address.getRegionName());
            references.setHomeNumber(address.getHomeNumber());
            references.setCountryId(address.getCountryId());
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully updated !!!!";
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }
    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
