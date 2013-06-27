package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public final class MathContext implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.655 -0400", hash_original_field = "E2794D8F12719281EFF5601251C8A680", hash_generated_field = "549991DA880D86C6AEB7236C4321FF98")

    private int precision;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.655 -0400", hash_original_field = "639639F04E09862FA33B2CFF1A43ED25", hash_generated_field = "11B15080BF4B303F429EBEF56C22234F")

    private RoundingMode roundingMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.656 -0400", hash_original_method = "F106BE9E01EEA929163197AB20FC2E93", hash_generated_method = "FF4603BC7D4813473BCC71C7FD0CAB96")
    public  MathContext(int precision) {
        this(precision, RoundingMode.HALF_UP);
        addTaint(precision);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.656 -0400", hash_original_method = "8370E5A41DB25B2BD130B4958C97346D", hash_generated_method = "97182812B40ACBE4BFE88F2BD06975A8")
    public  MathContext(int precision, RoundingMode roundingMode) {
        this.precision = precision;
        this.roundingMode = roundingMode;
        checkValid();
        // ---------- Original Method ----------
        //this.precision = precision;
        //this.roundingMode = roundingMode;
        //checkValid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.683 -0400", hash_original_method = "1D8B76B7C700FBF158167DD4C05A3C30", hash_generated_method = "62B8A74F6A4AD2D408B25EE9428C2BB2")
    public  MathContext(String s) {
        int precisionLength;
        precisionLength = "precision=".length();
        int roundingModeLength;
        roundingModeLength = "roundingMode=".length();
        int spaceIndex;
        {
            boolean varE58FA2F905EE0CA86ACE28C0E63C71DD_1799351992 = (!s.startsWith("precision=") || (spaceIndex = s.indexOf(' ', precisionLength)) == -1);
            {
                if (DroidSafeAndroidRuntime.control) throw invalidMathContext("Missing precision", s);
            } //End block
        } //End collapsed parenthetic
        String precisionString;
        precisionString = s.substring(precisionLength, spaceIndex);
        try 
        {
            this.precision = Integer.parseInt(precisionString);
        } //End block
        catch (NumberFormatException nfe)
        {
            if (DroidSafeAndroidRuntime.control) throw invalidMathContext("Bad precision", s);
        } //End block
        int roundingModeStart;
        roundingModeStart = spaceIndex + 1;
        {
            boolean var425DCA8F61C3FB47E082B66B0E00CFF6_1805894972 = (!s.regionMatches(roundingModeStart, "roundingMode=", 0, roundingModeLength));
            {
                if (DroidSafeAndroidRuntime.control) throw invalidMathContext("Missing rounding mode", s);
            } //End block
        } //End collapsed parenthetic
        roundingModeStart += roundingModeLength;
        this.roundingMode = RoundingMode.valueOf(s.substring(roundingModeStart));
        checkValid();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.684 -0400", hash_original_method = "426953F7355AB3CD325EF2685FB1287C", hash_generated_method = "F9F53B9C9B9F6DE23C1BDA476BD13DD7")
    private IllegalArgumentException invalidMathContext(String reason, String s) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(reason + ": " + s);
        addTaint(reason.getTaint());
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(reason + ": " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.687 -0400", hash_original_method = "D8DAE7CCCFF0DCEAE4D1ED9221F38BDC", hash_generated_method = "903825B39069E57697F614C640BC3177")
    private void checkValid() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Negative precision: " + precision);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("roundingMode == null");
        } //End block
        // ---------- Original Method ----------
        //if (precision < 0) {
            //throw new IllegalArgumentException("Negative precision: " + precision);
        //}
        //if (roundingMode == null) {
            //throw new NullPointerException("roundingMode == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.688 -0400", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "09ACAA1A46B7BC94DC3E983E0378DDB6")
    public int getPrecision() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_933885320 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_933885320;
        // ---------- Original Method ----------
        //return precision;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.688 -0400", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "AF87CD03BF542137AB9AD12CB68D9659")
    public RoundingMode getRoundingMode() {
        RoundingMode varB4EAC82CA7396A68D541C85D26508E83_1836257255 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1836257255 = roundingMode;
        varB4EAC82CA7396A68D541C85D26508E83_1836257255.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1836257255;
        // ---------- Original Method ----------
        //return roundingMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.689 -0400", hash_original_method = "297627CFD1856C2678820F72FEC54301", hash_generated_method = "403CFA0D42D7BD851136BEB48DD561DA")
    @Override
    public boolean equals(Object x) {
        boolean varA1C57D41253A71B051C179433A969961_90262086 = (((x instanceof MathContext)
                && (((MathContext) x).getPrecision() == precision) && (((MathContext) x)
                .getRoundingMode() == roundingMode)));
        addTaint(x.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_851091478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_851091478;
        // ---------- Original Method ----------
        //return ((x instanceof MathContext)
                //&& (((MathContext) x).getPrecision() == precision) && (((MathContext) x)
                //.getRoundingMode() == roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.689 -0400", hash_original_method = "CDDF05FC589C0F0146B62DD26D215A30", hash_generated_method = "AFE2908D20DEF3FCCCC6DFE316130AD8")
    @Override
    public int hashCode() {
        int varE9425C9B3E2CDB58CF19322C606DEAD1_1124101788 = (((precision << 3) | roundingMode.ordinal()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748475458 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1748475458;
        // ---------- Original Method ----------
        //return ((precision << 3) | roundingMode.ordinal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.721 -0400", hash_original_method = "537ED30546F81713B44C66AB9FEB6470", hash_generated_method = "CCA562C628319C91D18E95EDEFEAF415")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1292610601 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1292610601 = "precision=" + precision + " roundingMode=" + roundingMode;
        varB4EAC82CA7396A68D541C85D26508E83_1292610601.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1292610601;
        // ---------- Original Method ----------
        //return "precision=" + precision + " roundingMode=" + roundingMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.721 -0400", hash_original_method = "323BCE51E980C267DF7F7C47AD5D1D50", hash_generated_method = "38A9DE46F5EF59329C35ABC8611926FB")
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        try 
        {
            checkValid();
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new StreamCorruptedException(ex.getMessage());
        } //End block
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //try {
            //checkValid();
        //} catch (Exception ex) {
            //throw new StreamCorruptedException(ex.getMessage());
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.721 -0400", hash_original_field = "9AA5B3E57A5163BA4B0ABB8353A93BC0", hash_generated_field = "CF9BF6C5641BEB1E7318094FD77ED199")

    private static long serialVersionUID = 5579720004786848255L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.722 -0400", hash_original_field = "A9712D5EBF7571A586B938655C1F971F", hash_generated_field = "53D7CD734ABD47C72DC3ACC9D1BD8A94")

    public static final MathContext DECIMAL128 = new MathContext(34, RoundingMode.HALF_EVEN);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.722 -0400", hash_original_field = "41C28900FDE72FCC3950E06D51E6C77D", hash_generated_field = "1A095316CBCE3D002966EC9687CD9B47")

    public static final MathContext DECIMAL32 = new MathContext(7, RoundingMode.HALF_EVEN);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.722 -0400", hash_original_field = "8CE0E9CAAE4EAE807433D695A133ED4A", hash_generated_field = "C40CEDED9A18EAB0E8CB718E3F11A448")

    public static final MathContext DECIMAL64 = new MathContext(16, RoundingMode.HALF_EVEN);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:41.722 -0400", hash_original_field = "62438BE49805B7F090D15B7BD5BCBBCD", hash_generated_field = "BD670CA769A14674CDA6883CCDBF3384")

    public static final MathContext UNLIMITED = new MathContext(0, RoundingMode.HALF_UP);
}

