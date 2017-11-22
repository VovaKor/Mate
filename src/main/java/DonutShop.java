import java.util.Collections;
import java.util.List;

public class DonutShop {
    public static Tuple<Donut, Payment> buyDonut(final CreditCard creditCard) {
        Donut donut = new Donut();
        Payment payment = new Payment(creditCard, Donut.price);
        return new Tuple<>(donut, payment);
    }

    public static Tuple<List<Donut>, Payment> buyDonuts(final int quantity,
                                                        final CreditCard cCard) {
        return new Tuple<>(Collections.nCopies(quantity, new Donut()),
                new Payment(cCard, Donut.price * quantity));


    }
}
