package at.htl.gavric.reisebuero.entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "OFFER")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private String accomodation;

    @Digits(integer = 5,fraction = 2)
    private double price;
    private String catering;

    @OneToMany
    private List<Booking> bookings = new LinkedList<>();

    public Offer() {
    }

    public Offer(String destination, String accomodation, double price, String catering) {
        this.destination = destination;
        this.accomodation = accomodation;
        this.price = price;
        this.catering = catering;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCatering() {
        return catering;
    }

    public void setCatering(String catering) {
        this.catering = catering;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
