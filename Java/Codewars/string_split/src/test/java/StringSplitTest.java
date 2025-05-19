import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import com.string_split.StringSplit;

public class StringSplitTest {
    
    @Test
    public void shouldgenerateArray(){
        assertArrayEquals(new String[] {"Ho", "li", "s_"}, StringSplit.solution("Holis"));
    }
}
