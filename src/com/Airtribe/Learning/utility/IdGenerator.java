package com.Airtribe.Learning.utility;

public class IdGenerator {
    private static int counter = 0;
    public static int generateid()
    {
        counter++;
        return counter;
    }
}
