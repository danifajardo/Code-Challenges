import org.junit.jupiter.api.Test;
import org.peacefulyard.PeacefulYard;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeacefulYardTest {

    @Test
    public void onecatInYard(){
        assertEquals(true,
                PeacefulYard.peacefulYard(new String[] {"------------", "------------", "-L----------", "------------", "------------", "------------"}, 10),
                "Test with just one cat");
    }

    @Test
    public void twoCatsInYard(){
        assertEquals(false,
                PeacefulYard.peacefulYard(new String[] {"------------", "---M--------", "------------", "------------", "-------R----", "------------"},6),
                "Test with just two cats and they are too close");
    }

    @Test
    public void threeCatsInYard(){
        assertEquals(true,
                PeacefulYard.peacefulYard(new String[] {"-----------L", "--R---------", "------------", "------------", "------------", "--M---------"},4),
                "Test with three cats but they are far enough");
    }

}
