package peaksoft.repository;

import peaksoft.entity.Course;
import peaksoft.entity.Student;
import peaksoft.repository.repositoryImpl.CourseRepositoryImpl;

import java.util.List;

public interface StudentRepository {
   void saveStudent(Student student);
   List<Student> getAllStudents();
   String updateStudent(Long id,Student newStudent);
       void  deleteStudentById(Long id);
}
