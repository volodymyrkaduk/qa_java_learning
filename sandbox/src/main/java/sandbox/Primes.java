package sandbox;

/**
 * Created by vkaduk on 10.05.18.
 */
public class Primes {

    public static boolean isPrime (int n) {

        for (int i =1; i<n; i++ ) {
            if (i % n == 0) {
                return false;
            }
        }
            return true;
    }
}
