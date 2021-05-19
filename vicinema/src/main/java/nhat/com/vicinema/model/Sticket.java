package nhat.com.vicinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "sticket")
@Table(name = "sticket")
public class Sticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
