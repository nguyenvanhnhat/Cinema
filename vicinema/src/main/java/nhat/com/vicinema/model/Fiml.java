package nhat.com.vicinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "fiml")
@Table(name = "fiml")
@NoArgsConstructor
public class Fiml {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int year;
    private FimlStatus fimlStatus;
    private FimlType fimlType;

    public Fiml(String name, int year, FimlStatus fimlStatus, FimlType fimlType) {
        this.fimlStatus = fimlStatus;
        this.fimlType = fimlType;
        this.name = name;
        this.year = year;
    }

    @OneToMany(mappedBy = "fiml")
    private List<Order> order = new ArrayList<>();

}
