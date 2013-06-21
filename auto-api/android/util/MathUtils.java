package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Random;

public final class MathUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:58.287 -0400", hash_original_method = "36B7D6354601651DD814431AA0DFA6C7", hash_generated_method = "DED0A2D08FDE4310446B2635C520DAE6")
    @DSModeled(DSC.SAFE)
    private MathUtils() {
        // ---------- Original Method ----------
    }

    
        public static float abs(float v) {
        return v > 0 ? v : -v;
    }

    
        public static int constrain(int amount, int low, int high) {
        return amount < low ? low : (amount > high ? high : amount);
    }

    
        public static float constrain(float amount, float low, float high) {
        return amount < low ? low : (amount > high ? high : amount);
    }

    
        public static float log(float a) {
        return (float) Math.log(a);
    }

    
        public static float exp(float a) {
        return (float) Math.exp(a);
    }

    
        public static float pow(float a, float b) {
        return (float) Math.pow(a, b);
    }

    
        public static float max(float a, float b) {
        return a > b ? a : b;
    }

    
        public static float max(int a, int b) {
        return a > b ? a : b;
    }

    
        public static float max(float a, float b, float c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

    
        public static float max(int a, int b, int c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

    
        public static float min(float a, float b) {
        return a < b ? a : b;
    }

    
        public static float min(int a, int b) {
        return a < b ? a : b;
    }

    
        public static float min(float a, float b, float c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }

    
        public static float min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }

    
        public static float dist(float x1, float y1, float x2, float y2) {
        final float x = (x2 - x1);
        final float y = (y2 - y1);
        return (float) Math.sqrt(x * x + y * y);
    }

    
        public static float dist(float x1, float y1, float z1, float x2, float y2, float z2) {
        final float x = (x2 - x1);
        final float y = (y2 - y1);
        final float z = (z2 - z1);
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    
        public static float mag(float a, float b) {
        return (float) Math.sqrt(a * a + b * b);
    }

    
        public static float mag(float a, float b, float c) {
        return (float) Math.sqrt(a * a + b * b + c * c);
    }

    
        public static float sq(float v) {
        return v * v;
    }

    
        public static float radians(float degrees) {
        return degrees * DEG_TO_RAD;
    }

    
        public static float degrees(float radians) {
        return radians * RAD_TO_DEG;
    }

    
        public static float acos(float value) {
        return (float) Math.acos(value);
    }

    
        public static float asin(float value) {
        return (float) Math.asin(value);
    }

    
        public static float atan(float value) {
        return (float) Math.atan(value);
    }

    
        public static float atan2(float a, float b) {
        return (float) Math.atan2(a, b);
    }

    
        public static float tan(float angle) {
        return (float) Math.tan(angle);
    }

    
        public static float lerp(float start, float stop, float amount) {
        return start + (stop - start) * amount;
    }

    
        public static float norm(float start, float stop, float value) {
        return (value - start) / (stop - start);
    }

    
        public static float map(float minStart, float minStop, float maxStart, float maxStop, float value) {
        return maxStart + (maxStart - maxStop) * ((value - minStart) / (minStop - minStart));
    }

    
        public static int random(int howbig) {
        return (int) (sRandom.nextFloat() * howbig);
    }

    
        public static int random(int howsmall, int howbig) {
        if (howsmall >= howbig) return howsmall;
        return (int) (sRandom.nextFloat() * (howbig - howsmall) + howsmall);
    }

    
        public static float random(float howbig) {
        return sRandom.nextFloat() * howbig;
    }

    
        public static float random(float howsmall, float howbig) {
        if (howsmall >= howbig) return howsmall;
        return sRandom.nextFloat() * (howbig - howsmall) + howsmall;
    }

    
        public static void randomSeed(long seed) {
        sRandom.setSeed(seed);
    }

    
    private static final Random sRandom = new Random();
    private static final float DEG_TO_RAD = 3.1415926f / 180.0f;
    private static final float RAD_TO_DEG = 180.0f / 3.1415926f;
}

