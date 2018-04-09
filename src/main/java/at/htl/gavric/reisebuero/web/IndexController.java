package at.htl.gavric.reisebuero.web;

import at.htl.gavric.reisebuero.business.facades.BookingFacade;
import at.htl.gavric.reisebuero.business.facades.CustomerFacade;
import at.htl.gavric.reisebuero.business.facades.OfferFacade;
import at.htl.gavric.reisebuero.business.facades.PaymentFacade;
import at.htl.gavric.reisebuero.entity.Booking;
import at.htl.gavric.reisebuero.entity.Customer;
import at.htl.gavric.reisebuero.entity.Offer;
import at.htl.gavric.reisebuero.entity.Payment;
import org.primefaces.context.RequestContext;

import javax.enterprise.inject.Model;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Model
@RequestScoped
public class IndexController {

    @Inject
    private BookingFacade bookingFacade;

    @Inject
    private CustomerFacade customerFacade;

    @Inject
    private OfferFacade offerFacade;

    @Inject
    private PaymentFacade paymentFacade;

    private Booking newBooking = new Booking();
    private int newBookingCustomerId;
    private int newBookingOfferId;

    public IndexController() {
    }

    public List<Booking> getBookings(){
        return bookingFacade.findAll();
    }

    public List<Customer> getCustomers(){
        return customerFacade.findAll();
    }

    public List<Offer> getOffers(){
        return offerFacade.findAll();
    }

    public List<Payment> getPayments(){
        return paymentFacade.findAll();
    }

    public void saveBooking(){
        for(Offer offer:getOffers())
            if(offer.getId() == newBookingOfferId)
                newBooking.setOffer(offer);
        for(Customer customer:getCustomers())
            if(customer.getId()==newBookingCustomerId)
                newBooking.setCustomer(customer);
        if(newBooking.getCustomer()==null||newBooking.getOffer()==null)
            return;
        bookingFacade.update(newBooking);
        RequestContext.getCurrentInstance().update("bookingTable");

    }

    public Booking getNewBooking() {
        return newBooking;
    }

    public void setNewBooking(Booking newBooking) {
        this.newBooking = newBooking;
    }

    public int getNewBookingCustomerId() {
        return newBookingCustomerId;
    }

    public void setNewBookingCustomerId(int newBookingCustomerId) {
        this.newBookingCustomerId = newBookingCustomerId;
    }

    public int getNewBookingOfferId() {
        return newBookingOfferId;
    }

    public void setNewBookingOfferId(int newBookingOfferId) {
        this.newBookingOfferId = newBookingOfferId;
    }
}
