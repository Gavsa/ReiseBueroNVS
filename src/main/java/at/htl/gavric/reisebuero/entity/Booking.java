package at.htl.gavric.reisebuero.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PAYMENT")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String airport;
    private double deposit;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private double duration;

    public Booking() {
    }

    public Booking(String airport, double deposit, LocalDate departureDate, LocalDate arrivalDate, double duration) {
        this.airport = airport;
        this.deposit = deposit;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}
