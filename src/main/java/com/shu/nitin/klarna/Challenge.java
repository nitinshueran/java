package com.shu.nitin.klarna;

public class Challenge
{
    private static final String TH = "th";
    private static final  String ST = "st";
    private static final  String ND = "nd";
    private static final  String RD = "rd";

    public static void main(String[] args)
    {
       System.out.println(numberToOrdinal(220));

    }
    
    public static String numberToOrdinal( Integer number ) {
        if(number ==0)
            return number.toString();
        String[] suffixes = new String[] { TH, ST, ND, RD, TH, TH, TH, TH, TH, TH };
        switch (number % 100) {
        case 11:
        case 12:
        case 13:
            return number + TH;
        default:
            return number + suffixes[number % 10];

        }
    }

}
