import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.piglatin.PigLatin;

public class PigLatinTest {

    @Test
    public void correctTest(){
        //String strTest = "";
        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));
    }

    @Test
    public void incorrectTest(){
        String strTest = "";
        assertNotEquals("", PigLatin.pigIt(strTest));
    }

}
