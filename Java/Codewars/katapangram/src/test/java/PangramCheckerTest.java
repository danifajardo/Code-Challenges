import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.pangram.PangramChecker;

public class PangramCheckerTest {
    
    @Test
    public void checkTest1(){
        String sentence = "xfbien skqrpt w lvdgy azcm jhuo";
        PangramChecker pangramChecker = new PangramChecker();
        assertTrue(pangramChecker.check(sentence));
    }

    @Test
    public void checkTest2(){
        String sentence = "You shall not pass!";
        PangramChecker pangramChecker = new PangramChecker();
        assertFalse(pangramChecker.check(sentence));
    }

}
