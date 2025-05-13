import org.junit.jupiter.api.Test;
import org.validphonenumber.Kata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhoneExamplesTest {

    @Test
    public void testValidNumber(){
        String phoneNumber = "(123) 456-7890";
        assertTrue(Kata.validPhoneNumberRegex(phoneNumber));
        assertTrue(Kata.validPhoneNumberStreams(phoneNumber));
    }

    @Test
    public void testNotValidNumber(){
        assertFalse(Kata.validPhoneNumberRegex("(1111)555 2345"));
    }

}
