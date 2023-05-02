package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_gen")
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", allocationSize = 1)

    private Long id;
    private String courseName;
    private String description;
    private LocalDate dateOfStart;
    private LocalDate dateOfFinish;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
  private List<Student>students;

    public Course(String courseName, String description, LocalDate dateOfStart, LocalDate dateOfFinish) {
        this.courseName = courseName;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                ", dateOfStart=" + dateOfStart +
                ", dateOfFinish=" + dateOfFinish +
                '}';
    }
}