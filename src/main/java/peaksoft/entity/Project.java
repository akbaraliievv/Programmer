package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "projects")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "project_name")
    private String projectName;
    private String description;
    @Column(name = "date_of_start")
    private Date dateOfStart;
    @Column(name = "date_of_finish")
    private Date dateOfFinish;
    private BigDecimal price;
    @ManyToMany
    @JoinTable(name = "projects_programmers",
    joinColumns = @JoinColumn(name = "projects_id"),
            inverseJoinColumns = @JoinColumn(name = "programmers_id"))
    private List<Programmer>programmers;

    public Project(String projectName, String description, Date dateOfStart, Date dateOfFinish, BigDecimal price) {
        this.projectName = projectName;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
        this.price = price;
    }

    @Override
    public String toString() {
        return  "Project: " +
                "id = " + id +
                "projectName = " + projectName +
                "description = " + description +
                "dateOfStart = " + dateOfStart +
                "dateOfFinish = " + dateOfFinish +
                "price=" + price +
                ";";
    }
}
