package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

public final class MathContext implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.279 -0400", hash_original_field = "E2794D8F12719281EFF5601251C8A680", hash_generated_field = "549991DA880D86C6AEB7236C4321FF98")

    private int precision;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.279 -0400", hash_original_field = "639639F04E09862FA33B2CFF1A43ED25", hash_generated_field = "11B15080BF4B303F429EBEF56C22234F")

    private RoundingMode roundingMode;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.279 -0400", hash_original_method = "F106BE9E01EEA929163197AB20FC2E93", hash_generated_method = "FF4603BC7D4813473BCC71C7FD0CAB96")
    public  MathContext(int precision) {
        this(precision, RoundingMode.HALF_UP);
        addTaint(precision);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.280 -0400", hash_original_method = "8370E5A41DB25B2BD130B4958C97346D", hash_generated_method = "97182812B40ACBE4BFE88F2BD06975A8")
    public  MathContext(int precision, RoundingMode roundingMode) {
        this.precision = precision;
        this.roundingMode = roundingMode;
        checkValid();
        // ---------- Original Method ----------
        //this.precision = precision;
        //this.roundingMode = roundingMode;
        //checkValid();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.301 -0400", hash_original_method = "1D8B76B7C700FBF158167DD4C05A3C30", hash_generated_method = "4E9E49586846B17DCF2165B08B3E34D6")
    public  MathContext(String s) {
        int precisionLength = "precision=".length();
        int roundingModeLength = "roundingMode=".length();
        int spaceIndex;
    if(!s.startsWith("precision=") || (spaceIndex = s.indexOf(' ', precisionLength)) == -1)        
        {
            java.lang.IllegalArgumentException varD50ED92A3DD4CE03CCA0144EC534D709_1689966341 = invalidMathContext("Missing precision", s);
            varD50ED92A3DD4CE03CCA0144EC534D709_1689966341.addTaint(taint);
            throw varD50ED92A3DD4CE03CCA0144EC534D709_1689966341;
        } //End block
        String precisionString = s.substring(precisionLength, spaceIndex);
        try 
        {
            this.precision = Integer.parseInt(precisionString);
        } //End block
        catch (NumberFormatException nfe)
        {
            java.lang.IllegalArgumentException var213634FDDAEA52C24BEAC03414F443E4_1877681719 = invalidMathContext("Bad precision", s);
            var213634FDDAEA52C24BEAC03414F443E4_1877681719.addTaint(taint);
            throw var213634FDDAEA52C24BEAC03414F443E4_1877681719;
        } //End block
        int roundingModeStart = spaceIndex + 1;
    if(!s.regionMatches(roundingModeStart, "roundingMode=", 0, roundingModeLength))        
        {
            java.lang.IllegalArgumentException var12D1A417FDA706F32B7229A707E9976E_553601511 = invalidMathContext("Missing rounding mode", s);
            var12D1A417FDA706F32B7229A707E9976E_553601511.addTaint(taint);
            throw var12D1A417FDA706F32B7229A707E9976E_553601511;
        } //End block
        roundingModeStart += roundingModeLength;
        this.roundingMode = RoundingMode.valueOf(s.substring(roundingModeStart));
        checkValid();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.302 -0400", hash_original_method = "426953F7355AB3CD325EF2685FB1287C", hash_generated_method = "7BF89FFA0647A481B39798F2F3641A5A")
    private IllegalArgumentException invalidMathContext(String reason, String s) {
        addTaint(s.getTaint());
        addTaint(reason.getTaint());
        IllegalArgumentException var1091AF25FF67E9B01DD7F575637C2C5F_2024318539 = new IllegalArgumentException(reason + ": " + s);
        var1091AF25FF67E9B01DD7F575637C2C5F_2024318539.addTaint(taint);
        throw var1091AF25FF67E9B01DD7F575637C2C5F_2024318539;
        // ---------- Original Method ----------
        //throw new IllegalArgumentException(reason + ": " + s);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.302 -0400", hash_original_method = "D8DAE7CCCFF0DCEAE4D1ED9221F38BDC", hash_generated_method = "EEBC37DC074D6510E971D3394FB7F11E")
    private void checkValid() {
    if(precision < 0)        
        {
            IllegalArgumentException var07CFDDE05BC001AAA3B368C5412ECAAF_1056835568 = new IllegalArgumentException("Negative precision: " + precision);
            var07CFDDE05BC001AAA3B368C5412ECAAF_1056835568.addTaint(taint);
            throw var07CFDDE05BC001AAA3B368C5412ECAAF_1056835568;
        } //End block
    if(roundingMode == null)        
        {
            NullPointerException varD23A7BDC7ECC6C55AA11878B739C26B1_638611960 = new NullPointerException("roundingMode == null");
            varD23A7BDC7ECC6C55AA11878B739C26B1_638611960.addTaint(taint);
            throw varD23A7BDC7ECC6C55AA11878B739C26B1_638611960;
        } //End block
        // ---------- Original Method ----------
        //if (precision < 0) {
            //throw new IllegalArgumentException("Negative precision: " + precision);
        //}
        //if (roundingMode == null) {
            //throw new NullPointerException("roundingMode == null");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.303 -0400", hash_original_method = "71BCDCF9E73C85D95AB18BEF6635FA18", hash_generated_method = "1EB236C286725216FA5EB19CCF9AC164")
    public int getPrecision() {
        int varE2794D8F12719281EFF5601251C8A680_1581266719 = (precision);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734729307 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1734729307;
        // ---------- Original Method ----------
        //return precision;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.303 -0400", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "E2F726522ECA5B545CA1CD950731AE21")
    public RoundingMode getRoundingMode() {
RoundingMode var212E4C0114CE7EB809681C4A5E5BA4B1_1917807137 =         roundingMode;
        var212E4C0114CE7EB809681C4A5E5BA4B1_1917807137.addTaint(taint);
        return var212E4C0114CE7EB809681C4A5E5BA4B1_1917807137;
        // ---------- Original Method ----------
        //return roundingMode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.304 -0400", hash_original_method = "297627CFD1856C2678820F72FEC54301", hash_generated_method = "FBD59ABF05422C6C92B3FBFB533630A0")
    @Override
    public boolean equals(Object x) {
        addTaint(x.getTaint());
        boolean varCE5057FBC89A082FC5C769BB329FBD78_496204237 = (((x instanceof MathContext)
                && (((MathContext) x).getPrecision() == precision) && (((MathContext) x)
                .getRoundingMode() == roundingMode)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1172726715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1172726715;
        // ---------- Original Method ----------
        //return ((x instanceof MathContext)
                //&& (((MathContext) x).getPrecision() == precision) && (((MathContext) x)
                //.getRoundingMode() == roundingMode));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.304 -0400", hash_original_method = "CDDF05FC589C0F0146B62DD26D215A30", hash_generated_method = "4380144ACEA0DDC79EFF988EA37111B2")
    @Override
    public int hashCode() {
        int varEE0DC23B0F7DCB6AADC58BC99EAE4644_2091332977 = (((precision << 3) | roundingMode.ordinal()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_199366892 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_199366892;
        // ---------- Original Method ----------
        //return ((precision << 3) | roundingMode.ordinal());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.304 -0400", hash_original_method = "537ED30546F81713B44C66AB9FEB6470", hash_generated_method = "3ED21B6C159C0FFB7F714A597B1A6D81")
    @Override
    public String toString() {
String var939940AE6DFAF48A015D25E5ACE18ECD_935157246 =         "precision=" + precision + " roundingMode=" + roundingMode;
        var939940AE6DFAF48A015D25E5ACE18ECD_935157246.addTaint(taint);
        return var939940AE6DFAF48A015D25E5ACE18ECD_935157246;
        // ---------- Original Method ----------
        //return "precision=" + precision + " roundingMode=" + roundingMode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.305 -0400", hash_original_method = "323BCE51E980C267DF7F7C47AD5D1D50", hash_generated_method = "829DEEEEB6A1705438C8CA3A7DA01733")
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        addTaint(s.getTaint());
        s.defaultReadObject();
        try 
        {
            checkValid();
        } //End block
        catch (Exception ex)
        {
            StreamCorruptedException varC25D93F078866AC77F9F0370ED18FB45_892683931 = new StreamCorruptedException(ex.getMessage());
            varC25D93F078866AC77F9F0370ED18FB45_892683931.addTaint(taint);
            throw varC25D93F078866AC77F9F0370ED18FB45_892683931;
        } //End block
        // ---------- Original Method ----------
        //s.defaultReadObject();
        //try {
            //checkValid();
        //} catch (Exception ex) {
            //throw new StreamCorruptedException(ex.getMessage());
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.305 -0400", hash_original_field = "9AA5B3E57A5163BA4B0ABB8353A93BC0", hash_generated_field = "AE26DFE059ADEEF6717365717079903C")

    private static final long serialVersionUID = 5579720004786848255L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.305 -0400", hash_original_field = "A9712D5EBF7571A586B938655C1F971F", hash_generated_field = "53D7CD734ABD47C72DC3ACC9D1BD8A94")

    public static final MathContext DECIMAL128 = new MathContext(34, RoundingMode.HALF_EVEN);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.305 -0400", hash_original_field = "41C28900FDE72FCC3950E06D51E6C77D", hash_generated_field = "1A095316CBCE3D002966EC9687CD9B47")

    public static final MathContext DECIMAL32 = new MathContext(7, RoundingMode.HALF_EVEN);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.305 -0400", hash_original_field = "8CE0E9CAAE4EAE807433D695A133ED4A", hash_generated_field = "C40CEDED9A18EAB0E8CB718E3F11A448")

    public static final MathContext DECIMAL64 = new MathContext(16, RoundingMode.HALF_EVEN);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.306 -0400", hash_original_field = "62438BE49805B7F090D15B7BD5BCBBCD", hash_generated_field = "BD670CA769A14674CDA6883CCDBF3384")

    public static final MathContext UNLIMITED = new MathContext(0, RoundingMode.HALF_UP);
}

