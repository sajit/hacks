package concurrency;

/**
 * Created by sajit on 9/29/14.
 */
public class DistancePair {
    private final int bestDistance;
    private String knownWord;

    public DistancePair(int bestDistance) {
        this.bestDistance = bestDistance;
    }

    public DistancePair(int bestDistance, String knownWord) {
        this.bestDistance = bestDistance;
        this.knownWord = knownWord;
    }
}
