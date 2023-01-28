package level_5;

public class GapInPrimes {

    public long[] findFirstPrimesWithGap(int gap, long start, long end) {
        long[] twoPrimes = new long[2];
        int arrIndex = 0;
        for (long i = start; i < end; i++) {
            if (isPrime(i)) {
                twoPrimes[arrIndex++] = i;
            }
            if (twoPrimes[0] != 0 && twoPrimes[1] != 0) {
                if (twoPrimes[1] - twoPrimes[0] == gap) {
                    return twoPrimes;
                } else {
                    arrIndex = 0;
                    i = twoPrimes[1] - 1;
                    twoPrimes = new long[2];
                }
            }
        }
        return null;
    }

    public boolean isPrime(long number) {
        boolean prime = true;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                prime = false;
            }
        }
        return prime;
    }
}
