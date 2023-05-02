package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_gen")
    @SequenceGenerator(name = "student_gen",sequenceName = "student_seq",allocationSize = 1)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private int age;
    private String email;
    @Column(name = "create_at")
    private LocalDate createAt;
    @ManyToOne(cascade ={CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private Course course;


    public Student(String fullName, int age, String email, LocalDate createAt) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}

