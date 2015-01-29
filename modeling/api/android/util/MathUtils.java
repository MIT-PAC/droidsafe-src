package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Random;

public final class MathUtils {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.229 -0500", hash_original_method = "ABF547D608D1D29A7C7DC2F34A788E93", hash_generated_method = "E7716F6898DA1C04E0533172BE7CB5FB")
    
public static float abs(float v) {
        return v > 0 ? v : -v; 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.231 -0500", hash_original_method = "5784E04F953835A210940DB3410937FF", hash_generated_method = "9143EB873830F0B1BAD50BA762E37440")
    
public static int constrain(int amount, int low, int high) {
        return amount < low ? low : (amount > high ? high : amount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.234 -0500", hash_original_method = "2D70FC5721AD2A0E5B95D9053A4ED726", hash_generated_method = "A8BA088D95C87672A50ACE99600C0089")
    
public static float constrain(float amount, float low, float high) {
        return amount < low ? low : (amount > high ? high : amount);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.236 -0500", hash_original_method = "AD4BF5A9C4445071DD377C4E85BEA9C1", hash_generated_method = "3DC281304251D04A73E2F83F6570EAD6")
    
public static float log(float a) {
        return (float) Math.log(a);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.239 -0500", hash_original_method = "76323B662F01C2CD42AEEE0F7E1BEE87", hash_generated_method = "8272C8784B2F4955B78A9E9EFD6B45BA")
    
public static float exp(float a) {
        return (float) Math.exp(a);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.241 -0500", hash_original_method = "36AE51F1D80DB88CE2F4B3F191FBB7DE", hash_generated_method = "EFB34D5CBA8DA58AE9F3789213BC145F")
    
public static float pow(float a, float b) {
        return (float) Math.pow(a, b);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.243 -0500", hash_original_method = "8D813490D0A8CBE783F40E5B75942F4D", hash_generated_method = "7180BFB612A8C667379FBEFC388ED4E0")
    
public static float max(float a, float b) {
        return a > b ? a : b;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.245 -0500", hash_original_method = "2EFC25506B6CC342F7DE7372E0A2B437", hash_generated_method = "A39217C8AEA71D423C63BE67F2AEE46C")
    
public static float max(int a, int b) {
        return a > b ? a : b;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.248 -0500", hash_original_method = "3C32F0D5F6B0145C9ED125E5AC780E76", hash_generated_method = "C09943BDB280BBFA9F94C5E5445E8936")
    
public static float max(float a, float b, float c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.251 -0500", hash_original_method = "74EB3D1DBE988A9AFD4F0736A843D91D", hash_generated_method = "BB66E04100F6EA5E74A53B09D75844E2")
    
public static float max(int a, int b, int c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.253 -0500", hash_original_method = "9FF2237EBD4DE884FB02FF5992849059", hash_generated_method = "57BFB5F23067ADA8538026865A449CFC")
    
public static float min(float a, float b) {
        return a < b ? a : b;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.255 -0500", hash_original_method = "C5090A40FF842427E1178AC2437BE567", hash_generated_method = "67CAE8B150320DBAE573C62CFF6CB11A")
    
public static float min(int a, int b) {
        return a < b ? a : b;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.258 -0500", hash_original_method = "7AEA576E40D1D5517CC60AFB2BF3F234", hash_generated_method = "DC599AF064E7151483871649A1AFDC3D")
    
public static float min(float a, float b, float c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.260 -0500", hash_original_method = "07E32A6CF35B14CE02D22A02038017CB", hash_generated_method = "C98E3A4652515C677C42BD37FA9C4B71")
    
public static float min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.262 -0500", hash_original_method = "A0BA6D747207EDD2FAC0E02246ADAA35", hash_generated_method = "0BC7F53CC04586E6C4B852FBA492645F")
    
public static float dist(float x1, float y1, float x2, float y2) {
        final float x = (x2 - x1);
        final float y = (y2 - y1);
        return (float) Math.sqrt(x * x + y * y);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.265 -0500", hash_original_method = "83EB6C45D5F5F3D9C59622A9FA51C3EC", hash_generated_method = "ECE8E72BE24DD01BB50544B946FA5B87")
    
public static float dist(float x1, float y1, float z1, float x2, float y2, float z2) {
        final float x = (x2 - x1);
        final float y = (y2 - y1);
        final float z = (z2 - z1);
        return (float) Math.sqrt(x * x + y * y + z * z);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.268 -0500", hash_original_method = "BDA3CC2EC17330DAFDA1BDA1AF8C474D", hash_generated_method = "18C00C1B47AAE2828439A9654F5F315C")
    
public static float mag(float a, float b) {
        return (float) Math.sqrt(a * a + b * b);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.270 -0500", hash_original_method = "202AB15E8579FAC52561777CB1BC4A94", hash_generated_method = "13619BEB7B04D01F65703F74174132D5")
    
public static float mag(float a, float b, float c) {
        return (float) Math.sqrt(a * a + b * b + c * c);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.272 -0500", hash_original_method = "3F075DAFD2A89B80821D689BD799E875", hash_generated_method = "61E927B1CD600C0B8D50D7E9FA60A982")
    
public static float sq(float v) {
        return v * v;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.274 -0500", hash_original_method = "9AB806A3AF2B8BF607B145E4B8B8FDDC", hash_generated_method = "7655ED846F159157AA87AE0866C11D5A")
    
public static float radians(float degrees) {
        return degrees * DEG_TO_RAD;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.276 -0500", hash_original_method = "932109462F53AF41E2CD00A40B988162", hash_generated_method = "B86BE9627EC6057C4E75041FF171877E")
    
public static float degrees(float radians) {
        return radians * RAD_TO_DEG;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.278 -0500", hash_original_method = "CB86C09B4B515C650CCA56EE3F3EE933", hash_generated_method = "1CC555D0644E55860B4BBE00F77BDCAD")
    
public static float acos(float value) {
        return (float) Math.acos(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.281 -0500", hash_original_method = "989A4FE994B644362D868299CFD77C9B", hash_generated_method = "3A9A2F6FB46AEC6A3796E3E5C6B715D8")
    
public static float asin(float value) {
        return (float) Math.asin(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.283 -0500", hash_original_method = "1F305544B87439BC467B5EA5C21D33EE", hash_generated_method = "70ADC9DDE6390754EB655E965DB828F9")
    
public static float atan(float value) {
        return (float) Math.atan(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.286 -0500", hash_original_method = "09F773246BDB7A366303B599C91B5E6A", hash_generated_method = "9898784E4963493D861A42DA83AC8B83")
    
public static float atan2(float a, float b) {
        return (float) Math.atan2(a, b);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.289 -0500", hash_original_method = "F7A22965E5048BE8ADC49C4E329E13C8", hash_generated_method = "AF70B779377982A0CCBD8808C8A3F83D")
    
public static float tan(float angle) {
        return (float) Math.tan(angle);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.291 -0500", hash_original_method = "95A3F5CDAC71AB86482CF2FF9278856E", hash_generated_method = "AE87EE55991ECEACF4B6E4858704BDCC")
    
public static float lerp(float start, float stop, float amount) {
        return start + (stop - start) * amount;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.294 -0500", hash_original_method = "05F8C1873DB9DEF96B67778F44CF777C", hash_generated_method = "4DEF4F79494F230FCCEF138424C01369")
    
public static float norm(float start, float stop, float value) {
        return (value - start) / (stop - start);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.296 -0500", hash_original_method = "16D858BE26E3B8BCD8054FBAD2155D64", hash_generated_method = "392F64AECB0F298E336BD2FC73FE2930")
    
public static float map(float minStart, float minStop, float maxStart, float maxStop, float value) {
        return maxStart + (maxStart - maxStop) * ((value - minStart) / (minStop - minStart));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.299 -0500", hash_original_method = "DC8271BEBA4518305344A95DECA9056D", hash_generated_method = "2DB3F44A7B9B3BB61AA6CD504E807A26")
    
public static int random(int howbig) {
        return (int) (sRandom.nextFloat() * howbig);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.301 -0500", hash_original_method = "3EBDC1A5DCB0B2E9795830A9E0EE5784", hash_generated_method = "D507FDF819007F124812BD19AA13428A")
    
public static int random(int howsmall, int howbig) {
        if (howsmall >= howbig) return howsmall;
        return (int) (sRandom.nextFloat() * (howbig - howsmall) + howsmall);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.303 -0500", hash_original_method = "F03A1351B55AFFDA8DD761378C105F8F", hash_generated_method = "68807B4435608C990E00D0C2118A21F2")
    
public static float random(float howbig) {
        return sRandom.nextFloat() * howbig;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.305 -0500", hash_original_method = "9A2D2A3C57B3946894B41A551B8923A9", hash_generated_method = "5B88FA45403AD0B62CF9485BA9FEF848")
    
public static float random(float howsmall, float howbig) {
        if (howsmall >= howbig) return howsmall;
        return sRandom.nextFloat() * (howbig - howsmall) + howsmall;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.308 -0500", hash_original_method = "C948B1F85797E27C69B645F6B54667F5", hash_generated_method = "EE50251C18254996AFB788E5550427FF")
    
public static void randomSeed(long seed) {
        sRandom.setSeed(seed);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.220 -0500", hash_original_field = "D519686E52BA3DE7610640DD329A43BB", hash_generated_field = "73F7BA7EAEF61866D273EABB4511EF2A")

    private static final Random sRandom = new Random();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.223 -0500", hash_original_field = "B4D6600839330457CED92F62E9B5B5A4", hash_generated_field = "C09690990462EFAA62B06D71AF5D10CF")

    private static final float DEG_TO_RAD = 3.1415926f / 180.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.225 -0500", hash_original_field = "CAD7A0CB646FE383B7BF720131D65DFE", hash_generated_field = "B1B505790A10F2616FDE5EBCC2799C4C")

    private static final float RAD_TO_DEG = 180.0f / 3.1415926f;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.227 -0500", hash_original_method = "36B7D6354601651DD814431AA0DFA6C7", hash_generated_method = "EDF6FE23D8F51F3CABF7ED6EC1CBF1DB")
    
private MathUtils() {
    }
}

