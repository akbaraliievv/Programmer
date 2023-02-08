package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Status;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "Programmers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String email;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne
    private Address location;
    @ManyToMany(mappedBy = "programmers")
    private List<Project>projects;

    public Programmer(String fullName, String email, Date dateOfBirth, Status status) {
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.status = status;
    }

    @Override
    public String toString() {
        return  "Programmer: " +
                "id = " + id +
                "fullName = " + fullName +
                "email = " + email  +
                "dateOfBirth = " + dateOfBirth +
                "status = " + status +
                ";";
    }
}
