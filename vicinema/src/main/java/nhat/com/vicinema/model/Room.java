package nhat.com.vicinema.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "room")
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numberRoom;

    public Room(String numberRoom) {
        this.numberRoom = numberRoom;
    }

    @OneToMany(mappedBy = "room")
    private List<Order> order = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private List<Seat> seats = new ArrayList<>();

    public void addSeats(Seat seat) {
        seat.setSeats(this);
        seats.add(seat);
    }

}
