import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void setDaysToBook() {
        Hotel h1 = new Hotel();
        Assertions.assertEquals(false,h1.setDaysToBook(0));
        Assertions.assertEquals(true,h1.setDaysToBook(4));
        Assertions.assertEquals(false,h1.setDaysToBook(9));
    }

    @Test
    void setAmount() {
        Hotel h = new Hotel();
        Assertions.assertEquals(false,h.setAmount(-2));
        Assertions.assertEquals(true,h.setAmount(5000));
        Assertions.assertEquals(true,h.setAmount(12000));
        Assertions.assertEquals(false,h.setAmount(26000));
        Assertions.assertEquals(true,h.setAmount(55000));
    }
    @Test
    void setRating() {
        Hotel h = new Hotel();
        Assertions.assertEquals("yes",h.setRating("yes"));
        Assertions.assertEquals("no",h.setRating("no"));
    }
    @Test
    void giveRating() {
        Hotel h = new Hotel();
        Assertions.assertEquals(true,h.giveRating(2));
        Assertions.assertEquals(false,h.giveRating(-2));
        Assertions.assertEquals(false,h.giveRating(9));

    }

}
