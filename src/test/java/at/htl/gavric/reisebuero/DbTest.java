package at.htl.gavric.reisebuero;

import at.htl.gavric.reisebuero.business.facades.BookingFacade;
import at.htl.gavric.reisebuero.business.facades.PaymentFacade;
import at.htl.gavric.reisebuero.entity.Booking;
import at.htl.gavric.reisebuero.entity.Customer;
import at.htl.gavric.reisebuero.entity.Offer;
import at.htl.gavric.reisebuero.entity.Payment;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("ALL")
public class DbTest {

    private DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    private BookingFacade bookingFacade = new BookingFacade();
    private PaymentFacade paymentFacade = new PaymentFacade();

    @Before
    public void init() {
        EntityManager em = Persistence.createEntityManagerFactory("myTestPU").createEntityManager();
        bookingFacade.setEm(em);
        paymentFacade.setEm(em);
    }

    @Test
    public void fillDbTest() {

        Customer customer1 = new Customer("Simon", "Gosejohan", 27, "nV");
        Customer customer2 = new Customer("Heinz", "Fischer", 100, "Pensionist");
        Customer customer3 = new Customer("Sasa", "Collector", 4, "Kinderermäßigung");

        Offer offer1 = new Offer("Barcelona", "Hotel 5 Stars", 700, "Full Pension");
        Offer offer2 = new Offer("Athen", "Bungalow", 200, "");
        Offer offer3 = new Offer("Rio de janeiro", "Hotel 4 Stars", 1300, "Full Pension");

        Payment payment1 = new Payment(LocalDateTime.parse("2017-11-03 17:30", dtfTime), 320);

        Booking booking1 = new Booking(
                "Blue Danube Flughafen Linz",
                "Central Barcelona Airport",
                100,
                LocalDateTime.parse("2018-02-11 09:20", dtfTime),
                LocalDateTime.parse("2018-02-17 11:43", dtfTime)
        );

        booking1.setOffer(offer1);
        booking1.setCustomer(customer1);
        payment1.setBooking(booking1);

        Payment payment20 = new Payment(LocalDateTime.parse("2018-04-01 12:10", dtfTime), 240);
        Payment payment21 = new Payment(LocalDateTime.parse("2018-05-01 19:30", dtfTime), 240);

        Booking booking2 = new Booking(
                "Blue Danube Flughafen Linz",
                "Greek Main Airport",
                230,
                LocalDateTime.parse("2018-06-11 10:30", dtfTime),
                LocalDateTime.parse("2018-06-17 12:03", dtfTime)
        );

        booking2.setOffer(offer2);
        booking2.setCustomer(customer2);
        payment20.setBooking(booking2);
        payment21.setBooking(booking2);

        Payment payment3 = new Payment(LocalDateTime.parse("2018-03-17 09:40", dtfTime), 320);

        Booking booking3 = new Booking(
                "Blue Danube Flughafen Linz",
                "Aeroporto Rio",
                0,
                LocalDateTime.parse("2018-09-01 14:50", dtfTime),
                LocalDateTime.parse("2018-09-01 19:23", dtfTime)
        );

        booking3.setOffer(offer3);
        booking3.setCustomer(customer3);
        payment3.setBooking(booking3);

        bookingFacade.getEntityManager().getTransaction().begin();
        bookingFacade.save(booking1);
        bookingFacade.save(booking2);
        bookingFacade.save(booking3);
        bookingFacade.getEntityManager().getTransaction().commit();

        paymentFacade.getEntityManager().getTransaction().begin();
        paymentFacade.save(payment1);
        paymentFacade.save(payment20);
        paymentFacade.save(payment21);
        paymentFacade.save(payment3);
        paymentFacade.getEntityManager().getTransaction().commit();

        System.out.println(bookingFacade.findAll().size());
    }

}
