import org.apache.commons.httpclient.Cookie;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double add (double a, double b) {
        return a + b;
    }
    public double multiply (double a, double b) {
        return a * b;
    }

    public void longCalculation() {
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Set<Integer> extractEachNumber(int number) {
        Set<Integer> integers = new HashSet<Integer>();
        String stringNumber = String.valueOf(number);
        //System.out.println(integers +"\n" + stringNumber +"\n");


        for(int i = 0; i < stringNumber.length(); i++) {
            char c = stringNumber.charAt(i);
            if (c != '-') {
                integers.addAll(Collections.singleton(Integer.parseInt(stringNumber, i, i + 1, 10)));
            }
        }
        //System.out.println(integers);
        return integers;
    }
}
