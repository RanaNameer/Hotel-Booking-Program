import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void setName() {
        User user = new User();
        Assertions.assertEquals(false,user.setName("omer9"));
        Assertions.assertEquals(false,user.setName("Omer qasim"));
        Assertions.assertEquals(false,user.setName(" "));
        Assertions.assertEquals(false,user.setName(""));
        Assertions.assertEquals(false,user.setName("omer%"));
        Assertions.assertEquals(true,user.setName("Omer Qasim"));
    }

    @Test
    void setBirthday() {
        User user = new User();
        Assertions.assertEquals(false,user.setBirthday("8-10-2022"));
        Assertions.assertEquals(false,user.setBirthday("018-10-2022"));
        Assertions.assertEquals(false,user.setBirthday("08-010-2022"));
        Assertions.assertEquals(false,user.setBirthday("8-1-2022"));
        Assertions.assertEquals(false,user.setBirthday("08-10-02012"));
        Assertions.assertEquals(false,user.setBirthday("33-10-2022"));
        Assertions.assertEquals(false,user.setBirthday("08-15-2022"));
        Assertions.assertEquals(false,user.setBirthday("-2-12-2022"));
        Assertions.assertEquals(false,user.setBirthday("08--3-2022"));
        Assertions.assertEquals(false,user.setBirthday("08-12-1800"));
        Assertions.assertEquals(false,user.setBirthday("08-12-2028"));
        Assertions.assertEquals(true,user.setBirthday("08-11-2000"));
    }

    @Test
    void setCnic() {
        User user = new User();
        Assertions.assertEquals(false,user.setCnic("340559807961"));
        Assertions.assertEquals(false,user.setCnic("34055980796123"));
        Assertions.assertEquals(false,user.setCnic(" "));
        Assertions.assertEquals(false,user.setCnic(""));
        Assertions.assertEquals(false,user.setCnic("34055980796A"));
        Assertions.assertEquals(true,user.setCnic("3405598079612"));
    }

    @Test
    void setPhoto() {
        User user = new User();
        Assertions.assertEquals(true,user.setPhoto("jpeg"));
        Assertions.assertEquals(true,user.setPhoto("png"));
        Assertions.assertEquals(false,user.setPhoto("jfif"));
    }

}