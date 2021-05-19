package nhat.com.vicinema.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "seat")
@Table(name = "seat")
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String numberSeat;
    private long price;
    private SeatStatus seatStatus;
    private SeatType seatType;

    public Seat(String numberseat, long price, SeatStatus seatStatus, SeatType seatType) {
        this.numberSeat = numberseat;
        this.price = price;
        this.seatStatus = seatStatus;
        this.seatType = seatType;
    }

    @OneToMany(mappedBy = "seat")
    private List<Order> order = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
}
