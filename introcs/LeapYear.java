
/*************************************************************************
 *  Compilation:  javac LeapYear.java
 *  Execution:    java LeapYear N
 *  
 *  Prints true if N corresponds to a leap year, and false otherwise.
 *  Assumes N >= 1582, corresponding to a year in the Gregorian calendar.
 *
 *  % java LeapYear 2004
 *  true
 *
 *  % java LeapYear 1900
 *  false
 *
 *  % java LeapYear 2000
 *  true
 *
 *************************************************************************/

public class LeapYear { 
    public static void main(String[] args) { 
        int year = Integer.parseInt(args[0]);
        boolean isLeapYear;

        // divisible by 4
        isLeapYear = (year % 4 == 0);

        // divisible by 4 and not 100
        isLeapYear = isLeapYear && (year % 100 != 0);

        // divisible by 4 and not 100 unless divisible by 400
        isLeapYear = isLeapYear || (year % 400 == 0);

        System.out.println(isLeapYear);
    }
}
