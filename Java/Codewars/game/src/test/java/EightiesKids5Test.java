
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.televisiongame.EightiesKids5;

public class EightiesKids5Test {

  @Test
  public void testWater(){
    assertEquals("water", EightiesKids5.bucketOf("wash"));
  }

}
