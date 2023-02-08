package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Countryy;

import java.util.List;

@Entity
@Table(name = "Address")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "region_name")
    private String regionName;
    @Column(name = "home_number")
    private int homeNumber;
    private Countryy countryId;
    @OneToMany
    private List<Country> countries;
    @OneToOne(mappedBy = "address")
    private Programmer programmer;

    public Address(String regionName, int homeNumber, Countryy countryId) {
        this.regionName = regionName;
        this.homeNumber = homeNumber;
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return  "Address: " +
                "id = " + id +
                "regionName = " + regionName  +
                "homeNumber = " + homeNumber +
                "countryId = " + countryId +
                ";";
    }
}
