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
    private static final long serialVersionUID = 5579720004786848255L;
    public static final MathContext DECIMAL128 = new MathContext(34, RoundingMode.HALF_EVEN);
    public static final MathContext DECIMAL32 = new MathContext(7, RoundingMode.HALF_EVEN);
    public static final MathContext DECIMAL64 = new MathContext(16, RoundingMode.HALF_EVEN);
    public static final MathContext UNLIMITED = new MathContext(0, RoundingMode.HALF_UP);
    private int precision;
    private RoundingMode roundingMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.693 -0400", hash_original_method = "F106BE9E01EEA929163197AB20FC2E93", hash_generated_method = "5295B2F716B06B3B671A3F9F7CF257B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MathContext(int precision) {
        this(precision, RoundingMode.HALF_UP);
        dsTaint.addTaint(precision);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.697 -0400", hash_original_method = "8370E5A41DB25B2BD130B4958C97346D", hash_generated_method = "8A77494A76FDAB55E6DC847CFF3B5CB6")
    @DSModeled(DSC.SAFE)
    public MathContext(int precision, RoundingMode roundingMode) {
        dsTaint.addTaint(roundingMode.dsTaint);
        dsTaint.addTaint(precision);
        checkValid();
        // ---------- Original Method ----------
        //this.precision = precision;
        //this.roundingMode = roundingMode;
        //checkValid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.706 -0400", hash_original_method = "1D8B76B7C700FBF158167DD4C05A3C30", hash_generated_method = "94B09B06DC53AEB5B0C51CBFB9AC861C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MathContext(String s) {
        dsTaint.addTaint(s);
        int precisionLength;
        precisionLength = "precision=".length();
        int roundingModeLength;
        roundingModeLength = "roundingMode=".length();
        int spaceIndex;
    	spaceIndex = s.indexOf(' ', precisionLength);
        s.startsWith("precision=");
        {
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
            boolean var425DCA8F61C3FB47E082B66B0E00CFF6_1170466165 = (!s.regionMatches(roundingModeStart, "roundingMode=", 0, roundingModeLength));
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
    
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.712 -0400", hash_original_method = "426953F7355AB3CD325EF2685FB1287C", hash_generated_method = "410250CF61ED4902C63F264099651523")
    @DSModeled(DSC.SAFE)
    private IllegalArgumentException invalidMathContext(String reason, String s) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(reason);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(reason + ": " + s);
        return (IllegalArgumentException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(reason + ": " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.719 -0400", hash_original_method = "D8DAE7CCCFF0DCEAE4D1ED9221F38BDC", hash_generated_method = "CD4FAFB415BCBFFE693E844356DD5E7D")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.722 -0400", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "8E711B832A5EA23ECA3DB720B7B095A9")
    @DSModeled(DSC.SAFE)
    public int getPrecision() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return precision;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.725 -0400", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "B9BF4914BA9B54A70AB3ECD7C16403EA")
    @DSModeled(DSC.SAFE)
    public RoundingMode getRoundingMode() {
        return (RoundingMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return roundingMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.729 -0400", hash_original_method = "297627CFD1856C2678820F72FEC54301", hash_generated_method = "2DF831D6C3B9CF0047424E9C51A7AD08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object x) {
        dsTaint.addTaint(x.dsTaint);
        boolean varA1C57D41253A71B051C179433A969961_1470482165 = (((x instanceof MathContext)
                && (((MathContext) x).getPrecision() == precision) && (((MathContext) x)
                .getRoundingMode() == roundingMode)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((x instanceof MathContext)
                //&& (((MathContext) x).getPrecision() == precision) && (((MathContext) x)
                //.getRoundingMode() == roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.733 -0400", hash_original_method = "CDDF05FC589C0F0146B62DD26D215A30", hash_generated_method = "A51EB2DC3E96248ABDC07CFBFF44330E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE9425C9B3E2CDB58CF19322C606DEAD1_727944621 = (((precision << 3) | roundingMode.ordinal()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((precision << 3) | roundingMode.ordinal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.736 -0400", hash_original_method = "537ED30546F81713B44C66AB9FEB6470", hash_generated_method = "AA98E1F460C5442AC5BB2F8F5AB327A3")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "precision=" + precision + " roundingMode=" + roundingMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 10:35:53.739 -0400", hash_original_method = "323BCE51E980C267DF7F7C47AD5D1D50", hash_generated_method = "F1B8A20BAD37860335B81DF3B7027633")
    @DSModeled(DSC.SAFE)
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultReadObject();
        try 
        {
            checkValid();
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new StreamCorruptedException(ex.getMessage());
        } //End block
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //try {
            //checkValid();
        //} catch (Exception ex) {
            //throw new StreamCorruptedException(ex.getMessage());
        //}
    }

    
}


