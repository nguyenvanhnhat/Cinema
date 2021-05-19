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
@Entity(name = "staff")
@Table(name = "staff")
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String mobile;

    public Staff(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    @OneToMany(mappedBy = "staff")
    private List<Order> order = new ArrayList<>();
}
