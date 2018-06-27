package hackerrank.algo.sample;

import com.google.common.collect.ImmutableSet;
import hackerrank.algo.leaderboard.Solution;
import java.util.*;
import org.junit.Test;

import static hackerrank.algo.leaderboard.Solution.climbingLeaderboard;
import static hackerrank.algo.nondivisiablesubset.Solution.maxSet;
import static hackerrank.algo.nondivisiablesubset.Solution.nonDivisibleSubset;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SampleQuestionsTest {

    @Test
    public void testWaitingTimes() {
        assertEquals(1,SampleQuestions.waitingTime(new int[]{1,1,1,1},0));
        assertEquals(4,SampleQuestions.waitingTime(new int[]{1,2,5},1));
        assertEquals(12,SampleQuestions.waitingTime(new int[]{2,6,3,4,5},2));
        assertEquals(11,SampleQuestions.waitingTime(new int[]{5,5,2,3},3));
        assertEquals(11,SampleQuestions.waitingTime(new int[]{1,2,5,2,1},2));
        assertEquals(10,SampleQuestions.waitingTime(new int[]{1,1,6,1,1},2));
    }



    @Test
    public void testMaxSubset() {

        Set<Integer> set = maxSet(3, new HashSet<>(Arrays.asList(1, 7, 2, 4)));
        assertEquals(new HashSet<>(Arrays.asList(1,7,4)),set);
        Set<Integer> set1 = maxSet(3, new HashSet<>(Arrays.asList(1, 7, 2, 4,5,6,3)));
        System.out.println(set1);

        assertEquals(4,nonDivisibleSubset(3,new int[]{1,7,4,6}));

    }

    @Test
    public void testSorting() {
        List<Set<Integer>> ssList = new ArrayList<>();
        ssList.add(ImmutableSet.of(4,5));
        ssList.add(ImmutableSet.of(1,2,4));
        Collections.sort(ssList, (o1, o2) -> o2.size()-o1.size());


        for(Set<Integer> x : ssList){
            System.out.println(x);
        }
    }

    @Test
    public void testLeaderBoard() {
        int[] scores = {100,100,50,40,40,20,10};
        int[] aliceScores = {5,25,50,120};
        int[] expected = {6,4,2,1};
        assertArrayEquals(expected,climbingLeaderboard(scores,aliceScores));

    }

    @Test
    public void testPosition() {
        int[] scores = {100,50,40,20,10};
        assertEquals(5,Solution.getPosition(5,0,scores.length-1,scores));
        assertEquals(3,Solution.getPosition(25,0,scores.length-1,scores));
        assertEquals(1,Solution.getPosition(50,0,scores.length-1,scores));
        assertEquals(0,Solution.getPosition(120,0,scores.length-1,scores));
    }
}
