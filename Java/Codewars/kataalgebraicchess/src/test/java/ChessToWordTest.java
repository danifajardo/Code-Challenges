import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.algrebraicchess.ChessToWords;

public class ChessToWordTest {
    @Test
    public void testSimpleMove(){ //
        assertEquals("Pawn moved to e5.",
         ChessToWords.toWords("e5"),
         "for move: e5");
    }

    @Test
    public void testCapturing(){
        assertEquals("Pawn moved to e5.",
         ChessToWords.toWords("e5"),
         "for move: e5");
    }

    @Test
    public void testPromoted(){

    }

    @Test
    public void testChecks(){
        assertEquals("Knight moved to d4, check.",
        ChessToWords.toWords("Nd4+"),
        "for move: Nd4+");
    }

    @Test
    public void testEnPassant(){

    }

    @Test
    public void testConbinations(){

    }

    @Test
    public void testCastle(){
        assertEquals("A kingside castle.",
         ChessToWords.toWords("O-O"),
         "for move: king castle");
         assertEquals("A queenside castle.",
         ChessToWords.toWords("O-O-O"),
         "for move: queen castle");
    }

}
