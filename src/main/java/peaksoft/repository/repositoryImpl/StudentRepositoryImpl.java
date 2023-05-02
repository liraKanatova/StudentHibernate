package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Student;
import peaksoft.repository.StudentRepository;

import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public void saveStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("successfully saved");
    }

    @Override
    public List<Student> getAllStudents() {
        entityManager.getTransaction().begin();
        List<Student> resultList = entityManager.createQuery("select s from Student s ", Student.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public String updateStudent(Long id, Student newStudent) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        student.setFullName(newStudent.getFullName());
        student.setAge(newStudent.getAge());
        student.setEmail(newStudent.getEmail());
        student.setCreateAt(newStudent.getCreateAt());
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return newStudent.getFullName()+ " updated";
    }

    @Override
    public void deleteStudentById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Student.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("deleted");


    }
}
