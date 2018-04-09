package at.htl.gavric.reisebuero.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String departureAirport;
    private String arrivalAirport;

    private double deposit;

    private LocalDateTime departureDate = LocalDateTime.now();
    private LocalDateTime arrivalDate = LocalDateTime.now().plusWeeks(1);

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    private Offer offer;

    public Booking() {
    }

    public Booking(String departureAirport, String arrivalAirport, double deposit, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.deposit = deposit;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setUtilArrivalDate(Date arrivalDate){
        this.arrivalDate = arrivalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    public Date getUtilArrivalDate(){
        return Date.from(arrivalDate.toInstant(ZoneOffset.UTC));
    }
    public void setUtilDepartureDate(Date departureDate){
        this.departureDate = departureDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
    public Date getUtilDepartureDate(){
        return Date.from(departureDate.toInstant(ZoneOffset.UTC));
    }
    public String getFormattedDepartureDate(){
        return departureDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public String getFormattedArrivalDate(){
        return arrivalDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
