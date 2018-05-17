package sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by vkaduk on 06.05.18.
 */

public class PrimesTests {

    @Test
    public void primeTrueTest () {

        Assert.assertTrue(Primes.isPrime(3));

    }

    @Test
    public void primeFalseTest () {

        Assert.assertTrue(Primes.isPrime(6));

    }
}
