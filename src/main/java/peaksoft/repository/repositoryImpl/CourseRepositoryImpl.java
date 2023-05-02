package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;

public class CourseRepositoryImpl implements CourseRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getCourseName()+ " is saved";
    }

    @Override
    public Course findCourseById(Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.createQuery("select c from Course c where id=:id", Course.class).setParameter("id", id).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    @Override
    public void deleteCourse(Long id) {
        entityManager.getTransaction().begin();
       entityManager.remove(entityManager.find(Course.class,id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
