package nhat.com.vicinema.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "order")
@Table(name = "order")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private OrderStatus orderStatus;
    private Long totalPrice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fiml_id")
    private Fiml fiml;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staff_id")
    private Staff staff;

    public Order(Staff staff, Room room, Fiml fiml, Seat seat, Customer customer, OrderStatus orderStatus,
            Long totalPrice) {
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.seat = seat;
        this.fiml = fiml;
        this.room = room;
        this.staff = staff;
    }
}
