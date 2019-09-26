/*  Program that checks whether the INTEGER is cyclic number.
    There are three trivial cases which shows that given number is not a cyclic number:
      1) If it is a single digit
      2) if it consists of all same digits
      3) if it is a repeated cyclic number*/
package com.company;

import java.util.Scanner;

public class Main {
    private static boolean findTheNumbIsMagic(int numb) {
        int n = numb;
        int count = findDigitsCount(numb);     // finds how many digits are in the given number
        if(checkAllSame(numb)) {               // checks whether digits are not same
            return false;
        }
        if(checkRepeated(numb, count)) {       // checks whether the given number consists of repeated cyclic numbers
            return false;
        }
        while(true) {                          // checks all permutations
            int mod = n % 10;
            int div = n / 10;
            n = (int) (Math.pow(10, count - 1)) * mod + div;
            if (n == numb) {                  // if finds the original number, exits from loop
                break;
            }
            if(n % numb != 0) {               // if remnant of cyclic permuted number divided by the original number is not equal to zero it means that is not a "magic" number.
                return false;
            }
        }

        return true;

    }
    private static int findDigitsCount(int numb) {
        int count =0;
        int num = numb;
        for(; num != 0; num /= 10, ++count);
        return count;
    }
    private static boolean checkAllSame(int numb) {
        boolean allSame = true;
        int tmp =numb;
        int lastDigit = (int)(numb % 10);
        while (tmp > 0) {
            if (tmp % 10 != lastDigit) {
                allSame = false;
                break;
            }
            tmp = tmp /10;
         }
        return allSame;
    }
    private static boolean checkRepeated(int numb, int count) {
        boolean repeated =false;
        if (count % 2 == 0) {
            int div = (int) Math.pow(10, count/2);
            int lower  = numb % div;
            int higher = numb / div;
            if (lower == higher && findTheNumbIsMagic(lower)) {
                return true;
            }
        }
        return repeated;
    }
    public static void main(String[] args) {
        boolean isMagic = false;
            System.out.println("Please enter a number");
            Scanner scan = new Scanner(System.in);
            int numb = scan.nextInt();
            isMagic = findTheNumbIsMagic(numb);
            if (isMagic){
                System.out.println("It's magic!");
            }
            else {
                System.out.println("It's not magic...");
            }


    }
}
