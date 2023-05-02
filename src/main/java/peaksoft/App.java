package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Student;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.StudentRepository;
import peaksoft.repository.repositoryImpl.CourseRepositoryImpl;
import peaksoft.repository.repositoryImpl.StudentRepositoryImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//       HibernateConfig.getEntityManager();
        CourseRepository courseRepository = new CourseRepositoryImpl();
//     System.out.println(courseRepository.saveCourse(new Course("java-9", "Backend", LocalDate.of(2022, 11, 3), LocalDate.of(2023, 9, 3))));
//        System.out.println(courseRepository.findCourseById(1L));
//        courseRepository.deleteCourse(1L);

        StudentRepository studentRepository = new StudentRepositoryImpl();
//       studentRepository.saveStudent(new Student(" Nuriza Muratova",18,"n@gamil.com",LocalDate.of(2022,11,4)));
//        System.out.println(studentRepository.getAllStudents());
//        System.out.println(studentRepository.updateStudent(1L, new Student("Saltanat Nimat kizy", 21, "s@gmail.com", LocalDate.of(2022, 11, 6))));
//        studentRepository.deleteStudentById(1L);
    }
}
