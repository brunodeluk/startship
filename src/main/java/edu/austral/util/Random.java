package edu.austral.util;

public class Random {

    public static int random(int low, int high) {
        java.util.Random r = new java.util.Random();
        return r.nextInt(high-low) + low;
    }

    public static float nextFloat() {
        java.util.Random r = new java.util.Random();
        return r.nextFloat() * 2  - 1;
    }
}
