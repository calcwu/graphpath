package wucalv.experimental.graph;

/**
 * Generate an array of numbers that will always produce unique sums with any combination.
 *
 * Based on Zeckendorf's theorem, use any non-adjacent fibonacci numbers.
 *
 * User: wucalv
 * Date: 7/2/15 10:30 PM
 */
public class UniqueNumberGenerator {

    public int[] getNumbers(int count) {

        int[] data = new int[count];
        int fabN = 1, gap = 2;
        for(int i=0; i<count; i++) {
            fabN += gap;
            data[i] = fab(fabN);
        }
        return data;
    }

    private int fab(int n) {
        if(n<2) {
            return n;
        }
        return fab(n-1) + fab(n-2);
    }
}
