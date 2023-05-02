package peaksoft.repository;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseRepository {
    String saveCourse(Course course);
    Course findCourseById(Long id);
    void deleteCourse(Long id);
}
