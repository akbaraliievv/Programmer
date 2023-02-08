package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import peaksoft.enums.Countryy;

@Entity
@Table(name = "Countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Countryy country;
    private String description;
    @ManyToOne
    private Address address;

    public Country(Countryy country, String description) {
        this.country = country;
        this.description = description;
    }

    @Override
    public String toString() {
        return  "Country: " +
                "id = " + id +
                "country = " + country +
                "description = " + description +
                ";";
    }
}
