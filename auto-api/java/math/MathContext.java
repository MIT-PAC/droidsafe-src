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
    private int precision;
    private RoundingMode roundingMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.703 -0400", hash_original_method = "F106BE9E01EEA929163197AB20FC2E93", hash_generated_method = "06C80F2395F9074DDB6ACAEB3437154F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MathContext(int precision) {
        this(precision, RoundingMode.HALF_UP);
        dsTaint.addTaint(precision);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.704 -0400", hash_original_method = "8370E5A41DB25B2BD130B4958C97346D", hash_generated_method = "08AB2579DFB40A17983CCE90C9777E03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MathContext(int precision, RoundingMode roundingMode) {
        dsTaint.addTaint(roundingMode.dsTaint);
        dsTaint.addTaint(precision);
        checkValid();
        // ---------- Original Method ----------
        //this.precision = precision;
        //this.roundingMode = roundingMode;
        //checkValid();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.704 -0400", hash_original_method = "1D8B76B7C700FBF158167DD4C05A3C30", hash_generated_method = "1B9D8B1F0445A9B6AB5A1775BF191E0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MathContext(String s) {
        dsTaint.addTaint(s);
        int precisionLength;
        precisionLength = "precision=".length();
        int roundingModeLength;
        roundingModeLength = "roundingMode=".length();
        int spaceIndex;
        {
            boolean varE58FA2F905EE0CA86ACE28C0E63C71DD_445888076 = (!s.startsWith("precision=") || (spaceIndex = s.indexOf(' ', precisionLength)) == -1);
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
            boolean var425DCA8F61C3FB47E082B66B0E00CFF6_1383590528 = (!s.regionMatches(roundingModeStart, "roundingMode=", 0, roundingModeLength));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.704 -0400", hash_original_method = "426953F7355AB3CD325EF2685FB1287C", hash_generated_method = "0BD36FD1821A8B13EE81DA8B1CDCA012")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private IllegalArgumentException invalidMathContext(String reason, String s) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(reason);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(reason + ": " + s);
        return (IllegalArgumentException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(reason + ": " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.704 -0400", hash_original_method = "D8DAE7CCCFF0DCEAE4D1ED9221F38BDC", hash_generated_method = "903825B39069E57697F614C640BC3177")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.704 -0400", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "126284AE2405209A5A5088ACB2998A15")
    @DSModeled(DSC.SAFE)
    public int getPrecision() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return precision;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.705 -0400", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "199FFC5ACEA850A8D0AFDA188AA3711B")
    @DSModeled(DSC.SAFE)
    public RoundingMode getRoundingMode() {
        return (RoundingMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return roundingMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.705 -0400", hash_original_method = "297627CFD1856C2678820F72FEC54301", hash_generated_method = "B440FE115A59A20879CED246B209A775")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object x) {
        dsTaint.addTaint(x.dsTaint);
        boolean varA1C57D41253A71B051C179433A969961_2008211046 = (((x instanceof MathContext)
                && (((MathContext) x).getPrecision() == precision) && (((MathContext) x)
                .getRoundingMode() == roundingMode)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((x instanceof MathContext)
                //&& (((MathContext) x).getPrecision() == precision) && (((MathContext) x)
                //.getRoundingMode() == roundingMode));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.705 -0400", hash_original_method = "CDDF05FC589C0F0146B62DD26D215A30", hash_generated_method = "23AEA15CF2219EC4B69D96CBA97D68E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varE9425C9B3E2CDB58CF19322C606DEAD1_748557798 = (((precision << 3) | roundingMode.ordinal()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((precision << 3) | roundingMode.ordinal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.705 -0400", hash_original_method = "537ED30546F81713B44C66AB9FEB6470", hash_generated_method = "2E0F8E3CFB50A05BED48730DD127EDEA")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "precision=" + precision + " roundingMode=" + roundingMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.705 -0400", hash_original_method = "323BCE51E980C267DF7F7C47AD5D1D50", hash_generated_method = "E7F4B1FB298A92B47061BA8F158A5351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    private static final long serialVersionUID = 5579720004786848255L;
    public static final MathContext DECIMAL128 = new MathContext(34, RoundingMode.HALF_EVEN);
    public static final MathContext DECIMAL32 = new MathContext(7, RoundingMode.HALF_EVEN);
    public static final MathContext DECIMAL64 = new MathContext(16, RoundingMode.HALF_EVEN);
    public static final MathContext UNLIMITED = new MathContext(0, RoundingMode.HALF_UP);
}

