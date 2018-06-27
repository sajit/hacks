package recursion.crossword;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CrosswordTests {

    char[][] board = {
            {'+','+','+','+','+','+','+','+','+','+'},
            {'+','+','-','+','+','+','+','+','+','+'},
            {'-','-','-','-','+','+','+','-','-','-'},
            {'+','+','-','+','+','+','+','-','+','+'},
            {'+','+','-','+','+','+','+','-','+','+'},
            {'+','+','+','+','+','+','+','-','+','+'},
            {'+','+','+','+','+','+','+','+','+','+'},
            {'+','+','+','+','+','+','+','+','+','+'},
            {'+','+','+','+','+','+','+','+','+','+'},
            {'-','-','+','+','+','+','+','+','+','+'},
    };
    @Test
    public void testBuildSlots() {

        List<Slot> slots = Solution.buildSlots(board);
        assertEquals(5,slots.size());
        for(Slot slot : slots){
            System.out.println(slot);
            System.out.println(slot.getLength());
        }
    }


    @Test
    public void testSolve() {
        List<Slot> slots = Solution.buildSlots(board);
        List<String> wordList = new LinkedList<>(Arrays.asList("dark", "oreo", "bad", "bark", "he"));
        assertTrue(Solution.solve(slots,wordList,board));

    }

    @Test
    public void testConflict1() {
        Slot slot1 = new Slot(2,0,2,3);
        assertFalse(Solution.conflicts(board,slot1,"bark"));
    }

    @Test
    public void testConflict2() {
        Slot slot1 = new Slot(2,0,2,3);
        board[2][3]='o';
        assertTrue(Solution.conflicts(board,slot1,"bark"));
        board[2][3]='-';
    }

    @Test
    public void testConflict3() {
        Slot slot1 = new Slot(2,7,5,7);
        assertFalse(Solution.conflicts(board,slot1,"bark"));
    }

    @Test
    public void testConflict4() {
        Slot slot1 = new Slot(2,7,5,7);
        board[4][7]='o';
        assertTrue(Solution.conflicts(board,slot1,"bark"));
        board[2][3]='-';
    }

    @Test
    public void testSuperDigit(){
        assertEquals(8,Solution.superDigit("9875",4));
    }

    @Test
    public void testBiggerGreater() {
        /**
         * ab
         bb
         hefg
         dhck
         dkhc
         100000
         zyyyvvvvvuttsrqqokjjheedccb
         vvvygfabrsqeitgelpxwodhdfyypoyufxnecmrtkbzbhzfbtvnffcmikqoosfzoozssonomkgmtdqfecrqtps
         chntqzcpvrhvzvpywuhxombxcsjlpsergz
         bvulomthrfugqfbaknxginokekuemgb
         phoatpygffol
         gqesmwwfyyuraiwzhdkyvtzprhxzfaocdyxryzpqyewfufkspwvpgyscviersewdcgudhjxnfximarbkgduam
         dc
         zzzzyyxxxwvvvvusssrrrrqqqqqqqppoonnnnmmmmllllkjiiigfccccbbba
         */
        assertEquals("ba",hackerrank.algo.lexo.bigger.Solution.biggerIsGreater("ab"));
        assertEquals("no answer",hackerrank.algo.lexo.bigger.Solution.biggerIsGreater("a"));
        assertEquals("no answer",hackerrank.algo.lexo.bigger.Solution.biggerIsGreater("bb"));
        assertEquals("hegf",hackerrank.algo.lexo.bigger.Solution.biggerIsGreater("hefg"));
        assertEquals("dhkc",hackerrank.algo.lexo.bigger.Solution.biggerIsGreater("dhck"));
        assertEquals("hcdk",hackerrank.algo.lexo.bigger.Solution.biggerIsGreater("dkhc"));
        assertEquals("0130235",hackerrank.algo.lexo.bigger.Solution.biggerIsGreater("0125330"));

        assertEquals("no answer",hackerrank.algo.lexo.bigger.Solution.biggerIsGreater("zyyyvvvvvuttsrqqokjjheedccb"));
        assertEquals("vvvygfabrsqeitgelpxwodhdfyypoyufxnecmrtkbzbhzfbtvnffcmikqoosfzoozssonomkgmtdqfecrqtsp",hackerrank.algo.lexo.bigger.Solution.biggerIsGreater("vvvygfabrsqeitgelpxwodhdfyypoyufxnecmrtkbzbhzfbtvnffcmikqoosfzoozssonomkgmtdqfecrqtps"));

    }

    @Test
    public void failTestCases(){
        assertEquals("lcmmabcpfhh",hackerrank.algo.lexo.bigger.Solution.biggerIsGreater("lcmmabchphf"));

    }

    @Test
    public void testCosts() {
        assertEquals(36,hackerrank.algo.lexo.bigger.Solution.cost(new int[]{10,1,10,1,10}));
        assertEquals(2,hackerrank.algo.lexo.bigger.Solution.cost(new int[]{1,2,3}));
    }

    @Test
    public void testCounts() {
        assertEquals(3,hackerrank.algo.lexo.bigger.Solution.countArray(4,3,2));
    }

    // Complete the fibonacciModified function below.
    static BigInteger fibonacciModified(int t1, int t2, int n) {
        int i=2;
        BigInteger bigt1 = BigInteger.valueOf(t1);
        BigInteger bigt2 = BigInteger.valueOf(t2);
        BigInteger ti=BigInteger.ZERO;
        while(i<n){

            ti=bigt1.add(bigt2.multiply(bigt2));
            bigt1=bigt2;
            bigt2=ti;
            i++;
        }
        return ti;
    }
}
