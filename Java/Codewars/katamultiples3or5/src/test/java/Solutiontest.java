import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.multiples3or5.Solution;

public class Solutiontest {

    @Test
    public void tets1(){
        Integer num = 10;
        //intance of Solution.solution
        Solution sol = new Solution();
        //assert equals 23 
        assertEquals(23, sol.solution(num));
    }

    @Test
    public void test2(){
        Integer num = 15;
        //
        Solution sol = new Solution();
        //
        assertEquals(45, sol.solution(num));
    }

}
