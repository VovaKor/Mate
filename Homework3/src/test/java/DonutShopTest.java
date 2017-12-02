import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DonutShopTest {
    @Test
    void testBuyDonuts() {
        CreditCard creditCard = new CreditCard();
        Tuple<List<Donut>, Payment> purchase = DonutShop.buyDonuts(5, creditCard);
        assertEquals(Donut.price * 5, purchase._2.amount);
        assertEquals(creditCard, purchase._2.creditCard);

    }

}