package leetcode;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PowerXraisedToN {
    public static void main(String[] args) {
        test1();
        test2();

    }

    private static void test1() {
        PowerXraisedToN powerXraisedToN = new PowerXraisedToN();
        double x = 2.00000;
        int n = 10;
        double r = powerXraisedToN.myPow(x,n);
        assert 1024.00000 == r;
    }
    private static void test2() {
        PowerXraisedToN powerXraisedToN = new PowerXraisedToN();
        double x = 2.10000;
        int n = 3;
        double r = powerXraisedToN.myPow(x,n);
        assert 9.26100 == r;
    }
    private static void test3() {
        PowerXraisedToN powerXraisedToN = new PowerXraisedToN();
        double x = 2.10000;
        int n = 3;
        double r = powerXraisedToN.myPow(x,n);
        assert 9.26100 == r;
    }

    public double myPow(double x, int n) {
     //below line worked for submission in leetcode
     //   return Double.parseDouble(String.format("%.5f",Math.pow(x,n)));


        double result = x;
          boolean negativePower =false;
          if(n ==0 || x ==1) return 1;
          if (n<0){
             n =  Math.abs(n);
              negativePower = true;
          }
        while (n>1){

                result = result * x;
            n--;
        }
        if(negativePower) {
            result = 1 / result;
        }
        return withPrecision(result);
    }
    public double withPrecision(double result){
        BigDecimal resultWithPrecision = new BigDecimal(result);
        resultWithPrecision.setScale(5, RoundingMode.DOWN );
        return resultWithPrecision.doubleValue();
    }
}
