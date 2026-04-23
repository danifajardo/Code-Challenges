import org.junit.jupiter.api.Test;

import com.kataendingstring.Kata;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataTest {
    @Test
    public void staticTests() {
        check("", "", true);
        check("", "omo", false);
        check("omo", "", true);
        check("aaa", "aa", true);
        check("aa", "aaa", false);
        check("samurai", "ai", true);
        check("sumo", "omo", false);
        check("ninja", "ja", true);
        check("sensei", "i", true);
        check("samurai", "ra", false);
        check("abc", "abcd", false);
        check("abc", "abc", true);
        check("abcabc", "bc", true);
        check("ails", "fails", false);
        check("fails", "ails", true);
        check("this", "fails", false);
        check("this", "", true);
        check(":-)", ":-(", false);
        check("!@#$%^&*() :-)", ":-)", true);
        check("abc\n", "abc", false);
    }

    private static void check(String str, String ending, boolean expected) {
      String message = String.format("str = \"%s\"\nending = \"%s\"\n", str, ending);
      boolean actual = Kata.solution(str, ending);
      assertEquals(expected, actual, message);
    }
}
