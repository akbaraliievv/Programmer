package peaksoft.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;
import peaksoft.config.ConfigurationHibernate;
import peaksoft.entity.Project;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository,AutoCloseable{
    private final EntityManagerFactory entityManagerFactory = ConfigurationHibernate.getManagerFactory();
    @Override
    public void close() throws Exception {
     entityManagerFactory.close();
    }

    @Override
    public void saveProject(Project project) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(project);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Project> saveAll(List<Project> project) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            for (Project projects:project) {
                entityManager.persist(projects);}
            entityManager.getTransaction().commit();
            entityManager.close();
            return project;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public List<Project> findAll() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            List<Project>project = entityManager.createQuery("from Project ").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            return project;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public Project findById(Long projectId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Project result = entityManager.createQuery("from Project p where p.id=:projectId", Project.class)
                    .setParameter("id", projectId).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return result ;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public Project deletedById(Long projectId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Project result = entityManager.createQuery("from Project p where p.id=:projectId", Project.class).
                    setParameter("id", projectId).getSingleResult();
            entityManager.remove(result);
            entityManager.getTransaction().commit();
            entityManager.close();
            return null;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public List<Project> deletedAll() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("delete Project ").executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
            return null;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public String updated(Project project,Long projectId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Project reference = entityManager.getReference(Project.class, projectId);
            reference.setProjectName(project.getProjectName());
            reference.setDescription(project.getDescription());
            reference.setDateOfStart(project.getDateOfStart());
            reference.setDateOfFinish(project.getDateOfFinish());
            reference.setPrice(project.getPrice());
            reference.setProgrammers(project.getProgrammers());
            entityManager.getTransaction().commit();
            entityManager.close();
            return null;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public Project addProgrammerToProject(Project project, Long ProgrammerId) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("");
            entityManager.getTransaction().commit();
            entityManager.close();
            return null;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public Project expensiveProject(BigDecimal price) {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Project result = entityManager.createQuery("select max(price) from Project", Project.class).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return result;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }return null;
    }

    @Override
    public void shortTimeProject() {
        try {
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Project project =(Project) entityManager.createQuery(" from Project p where p.dateOfFinish-p.dateOfStart between dateOfFinish and dateOfStart ");
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println(project);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }
}
