package javax.crypto.spec;

// Droidsafe Imports
import java.io.Serializable;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.SecretKey;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SecretKeySpec implements SecretKey, KeySpec, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.426 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "AEF19C0A7530E140588DCBA91FF66D28")

    private byte[] key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.426 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.427 -0400", hash_original_method = "46BCBD91E8C2018C32B65BFBDD14DAE3", hash_generated_method = "ED26F1887C1EFB232B313FBF7E157331")
    public  SecretKeySpec(byte[] key, String algorithm) {
        if(key == null)        
        {
            IllegalArgumentException var961CFAFB0DC64E45A11DB330A0727C67_140981475 = new IllegalArgumentException("key == null");
            var961CFAFB0DC64E45A11DB330A0727C67_140981475.addTaint(taint);
            throw var961CFAFB0DC64E45A11DB330A0727C67_140981475;
        } //End block
        if(key.length == 0)        
        {
            IllegalArgumentException varA3F1879A000F82A666B70199929D288F_1585156304 = new IllegalArgumentException("key.length == 0");
            varA3F1879A000F82A666B70199929D288F_1585156304.addTaint(taint);
            throw varA3F1879A000F82A666B70199929D288F_1585156304;
        } //End block
        if(algorithm == null)        
        {
            IllegalArgumentException varB04CCFA97B93D3ED1EB3F4E597A5D0AE_117106053 = new IllegalArgumentException("algorithm == null");
            varB04CCFA97B93D3ED1EB3F4E597A5D0AE_117106053.addTaint(taint);
            throw varB04CCFA97B93D3ED1EB3F4E597A5D0AE_117106053;
        } //End block
        this.algorithm = algorithm;
        this.key = new byte[key.length];
        System.arraycopy(key, 0, this.key, 0, key.length);
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new IllegalArgumentException("key == null");
        //}
        //if (key.length == 0) {
            //throw new IllegalArgumentException("key.length == 0");
        //}
        //if (algorithm == null) {
            //throw new IllegalArgumentException("algorithm == null");
        //}
        //this.algorithm = algorithm;
        //this.key = new byte[key.length];
        //System.arraycopy(key, 0, this.key, 0, key.length);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.429 -0400", hash_original_method = "97539A44FE944982691962B490B5A049", hash_generated_method = "7CF95768150A60C349FFC299F7876049")
    public  SecretKeySpec(byte[] key, int offset, int len, String algorithm) {
        addTaint(offset);
        if(key == null)        
        {
            IllegalArgumentException var961CFAFB0DC64E45A11DB330A0727C67_869598996 = new IllegalArgumentException("key == null");
            var961CFAFB0DC64E45A11DB330A0727C67_869598996.addTaint(taint);
            throw var961CFAFB0DC64E45A11DB330A0727C67_869598996;
        } //End block
        if(key.length == 0)        
        {
            IllegalArgumentException varA3F1879A000F82A666B70199929D288F_922886519 = new IllegalArgumentException("key.length == 0");
            varA3F1879A000F82A666B70199929D288F_922886519.addTaint(taint);
            throw varA3F1879A000F82A666B70199929D288F_922886519;
        } //End block
        if(len < 0 || offset < 0)        
        {
            ArrayIndexOutOfBoundsException varB0D44B57D146731E07C91456440128FB_1167851666 = new ArrayIndexOutOfBoundsException("len < 0 || offset < 0");
            varB0D44B57D146731E07C91456440128FB_1167851666.addTaint(taint);
            throw varB0D44B57D146731E07C91456440128FB_1167851666;
        } //End block
        if(key.length - offset < len)        
        {
            IllegalArgumentException var4C9D46BFF501DB6E5A95F677A6BFE42A_941401922 = new IllegalArgumentException("key too short");
            var4C9D46BFF501DB6E5A95F677A6BFE42A_941401922.addTaint(taint);
            throw var4C9D46BFF501DB6E5A95F677A6BFE42A_941401922;
        } //End block
        if(algorithm == null)        
        {
            IllegalArgumentException varB04CCFA97B93D3ED1EB3F4E597A5D0AE_170182570 = new IllegalArgumentException("algorithm == null");
            varB04CCFA97B93D3ED1EB3F4E597A5D0AE_170182570.addTaint(taint);
            throw varB04CCFA97B93D3ED1EB3F4E597A5D0AE_170182570;
        } //End block
        this.algorithm = algorithm;
        this.key = new byte[len];
        System.arraycopy(key, offset, this.key, 0, len);
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new IllegalArgumentException("key == null");
        //}
        //if (key.length == 0) {
            //throw new IllegalArgumentException("key.length == 0");
        //}
        //if (len < 0 || offset < 0) {
            //throw new ArrayIndexOutOfBoundsException("len < 0 || offset < 0");
        //}
        //if (key.length - offset < len) {
            //throw new IllegalArgumentException("key too short");
        //}
        //if (algorithm == null) {
            //throw new IllegalArgumentException("algorithm == null");
        //}
        //this.algorithm = algorithm;
        //this.key = new byte[len];
        //System.arraycopy(key, offset, this.key, 0, len);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.430 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "E6237228955208E836B055701FB6EF0C")
    public String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1153937796 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_1153937796.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_1153937796;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.430 -0400", hash_original_method = "DA06499CB28B740B0D3C21B02311BB46", hash_generated_method = "EC1025BFBA228E6DE6F9849CB43A898D")
    public String getFormat() {
String var75AE4CAF1CB13EF15783F46A006C5A7F_1006321397 =         "RAW";
        var75AE4CAF1CB13EF15783F46A006C5A7F_1006321397.addTaint(taint);
        return var75AE4CAF1CB13EF15783F46A006C5A7F_1006321397;
        // ---------- Original Method ----------
        //return "RAW";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.430 -0400", hash_original_method = "3F6C1397C7B2518265F6653D66E9AC87", hash_generated_method = "C0673FF907B0E0F111D761E93EA3ABE8")
    public byte[] getEncoded() {
        byte[] result = new byte[key.length];
        System.arraycopy(key, 0, result, 0, key.length);
        byte[] varB4A88417B3D0170D754C647C30B7216A_1381180994 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_936011268 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_936011268;
        // ---------- Original Method ----------
        //byte[] result = new byte[key.length];
        //System.arraycopy(key, 0, result, 0, key.length);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.431 -0400", hash_original_method = "561BEB6A8D834A34E4D5A2503144263D", hash_generated_method = "7390866004837C61FBA8564FFA076300")
    @Override
    public int hashCode() {
        int result = algorithm.length();
for(byte element : key)
        {
            result += element;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_1211367510 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148681707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148681707;
        // ---------- Original Method ----------
        //int result = algorithm.length();
        //for (byte element : key) {
            //result += element;
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.432 -0400", hash_original_method = "7E1551F3E39A01E70E4CFF4FAB6C7AC5", hash_generated_method = "244CA1F0B43A29D2C4CACD9225EEC5DE")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_955200126 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918149516 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918149516;
        } //End block
        if(!(obj instanceof SecretKeySpec))        
        {
            boolean var68934A3E9455FA72420237EB05902327_399375910 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_30568769 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_30568769;
        } //End block
        SecretKeySpec ks = (SecretKeySpec) obj;
        boolean var5AED73F5AACCD0347305DC862E7CFDD6_308029256 = ((algorithm.equalsIgnoreCase(ks.algorithm))
            && (Arrays.equals(key, ks.key)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_482417488 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_482417488;
        // ---------- Original Method ----------
        //if (obj == this) {
            //return true;
        //}
        //if (!(obj instanceof SecretKeySpec)) {
            //return false;
        //}
        //SecretKeySpec ks = (SecretKeySpec) obj;
        //return (algorithm.equalsIgnoreCase(ks.algorithm))
            //&& (Arrays.equals(key, ks.key));
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.432 -0400", hash_original_field = "5088DB7B37FA60A2A439242D11325983", hash_generated_field = "84F6801DA315233B24EACF83A24EEC96")

    private static final long serialVersionUID = 6577238317307289933L;
}

