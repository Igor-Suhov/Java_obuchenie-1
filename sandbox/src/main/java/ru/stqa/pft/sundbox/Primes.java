package ru.stqa.pft.sundbox;

public class Primes {
  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeWhile(int n) {
    int i=2;
    while (i<n && n %  i !=0) {
      i++;
    }

    return i==n;
  }

  /*public static boolean isPrime(long n) {
    for (long i = 2; i < n; i++) ;
    if (n % i == 0) {

      return false;
    }

    return true;
  }*/


}
