package ru.stqa.pft.sundbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTest {
  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }
  @Test
  public void testNonPrime(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE -2));
  }
}
