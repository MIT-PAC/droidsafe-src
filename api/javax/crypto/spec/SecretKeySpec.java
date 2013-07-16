package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKey;

public class SecretKeySpec implements SecretKey, KeySpec, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.448 -0400", hash_original_field = "3C6E0B8A9C15224A8228B9A98CA1531D", hash_generated_field = "AEF19C0A7530E140588DCBA91FF66D28")

    private byte[] key;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.449 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.450 -0400", hash_original_method = "46BCBD91E8C2018C32B65BFBDD14DAE3", hash_generated_method = "D60779714C0B84A27BEE110B8A8B9E35")
    public  SecretKeySpec(byte[] key, String algorithm) {
    if(key == null)        
        {
            IllegalArgumentException var961CFAFB0DC64E45A11DB330A0727C67_17290557 = new IllegalArgumentException("key == null");
            var961CFAFB0DC64E45A11DB330A0727C67_17290557.addTaint(taint);
            throw var961CFAFB0DC64E45A11DB330A0727C67_17290557;
        } //End block
    if(key.length == 0)        
        {
            IllegalArgumentException varA3F1879A000F82A666B70199929D288F_1421719331 = new IllegalArgumentException("key.length == 0");
            varA3F1879A000F82A666B70199929D288F_1421719331.addTaint(taint);
            throw varA3F1879A000F82A666B70199929D288F_1421719331;
        } //End block
    if(algorithm == null)        
        {
            IllegalArgumentException varB04CCFA97B93D3ED1EB3F4E597A5D0AE_854642672 = new IllegalArgumentException("algorithm == null");
            varB04CCFA97B93D3ED1EB3F4E597A5D0AE_854642672.addTaint(taint);
            throw varB04CCFA97B93D3ED1EB3F4E597A5D0AE_854642672;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.451 -0400", hash_original_method = "97539A44FE944982691962B490B5A049", hash_generated_method = "B9C94CDC0C91CF046877CE912F66B0B4")
    public  SecretKeySpec(byte[] key, int offset, int len, String algorithm) {
        addTaint(offset);
    if(key == null)        
        {
            IllegalArgumentException var961CFAFB0DC64E45A11DB330A0727C67_596569930 = new IllegalArgumentException("key == null");
            var961CFAFB0DC64E45A11DB330A0727C67_596569930.addTaint(taint);
            throw var961CFAFB0DC64E45A11DB330A0727C67_596569930;
        } //End block
    if(key.length == 0)        
        {
            IllegalArgumentException varA3F1879A000F82A666B70199929D288F_390125918 = new IllegalArgumentException("key.length == 0");
            varA3F1879A000F82A666B70199929D288F_390125918.addTaint(taint);
            throw varA3F1879A000F82A666B70199929D288F_390125918;
        } //End block
    if(len < 0 || offset < 0)        
        {
            ArrayIndexOutOfBoundsException varB0D44B57D146731E07C91456440128FB_671005417 = new ArrayIndexOutOfBoundsException("len < 0 || offset < 0");
            varB0D44B57D146731E07C91456440128FB_671005417.addTaint(taint);
            throw varB0D44B57D146731E07C91456440128FB_671005417;
        } //End block
    if(key.length - offset < len)        
        {
            IllegalArgumentException var4C9D46BFF501DB6E5A95F677A6BFE42A_2059348213 = new IllegalArgumentException("key too short");
            var4C9D46BFF501DB6E5A95F677A6BFE42A_2059348213.addTaint(taint);
            throw var4C9D46BFF501DB6E5A95F677A6BFE42A_2059348213;
        } //End block
    if(algorithm == null)        
        {
            IllegalArgumentException varB04CCFA97B93D3ED1EB3F4E597A5D0AE_530051409 = new IllegalArgumentException("algorithm == null");
            varB04CCFA97B93D3ED1EB3F4E597A5D0AE_530051409.addTaint(taint);
            throw varB04CCFA97B93D3ED1EB3F4E597A5D0AE_530051409;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.452 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "58AFB00D637A894E6584FECEF2441A58")
    public String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_2131483653 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_2131483653.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_2131483653;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.452 -0400", hash_original_method = "DA06499CB28B740B0D3C21B02311BB46", hash_generated_method = "79E0AC49797474B68823A665F7032FE2")
    public String getFormat() {
String var75AE4CAF1CB13EF15783F46A006C5A7F_1816652193 =         "RAW";
        var75AE4CAF1CB13EF15783F46A006C5A7F_1816652193.addTaint(taint);
        return var75AE4CAF1CB13EF15783F46A006C5A7F_1816652193;
        // ---------- Original Method ----------
        //return "RAW";
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.452 -0400", hash_original_method = "3F6C1397C7B2518265F6653D66E9AC87", hash_generated_method = "387913A0D8A0EFADB8448C87620DD380")
    public byte[] getEncoded() {
        byte[] result = new byte[key.length];
        System.arraycopy(key, 0, result, 0, key.length);
        byte[] varB4A88417B3D0170D754C647C30B7216A_1909833906 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_66445597 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_66445597;
        // ---------- Original Method ----------
        //byte[] result = new byte[key.length];
        //System.arraycopy(key, 0, result, 0, key.length);
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.453 -0400", hash_original_method = "561BEB6A8D834A34E4D5A2503144263D", hash_generated_method = "4A2517803DD7519356DD0402DF852879")
    @Override
    public int hashCode() {
        int result = algorithm.length();
for(byte element : key)
        {
            result += element;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_45305492 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452490831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1452490831;
        // ---------- Original Method ----------
        //int result = algorithm.length();
        //for (byte element : key) {
            //result += element;
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.453 -0400", hash_original_method = "7E1551F3E39A01E70E4CFF4FAB6C7AC5", hash_generated_method = "41E8AB70C454E49BA3EF7E326C719444")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_579487360 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_463872256 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_463872256;
        } //End block
    if(!(obj instanceof SecretKeySpec))        
        {
            boolean var68934A3E9455FA72420237EB05902327_303402254 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1651871130 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1651871130;
        } //End block
        SecretKeySpec ks = (SecretKeySpec) obj;
        boolean var5AED73F5AACCD0347305DC862E7CFDD6_63916349 = ((algorithm.equalsIgnoreCase(ks.algorithm))
            && (Arrays.equals(key, ks.key)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1766182704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1766182704;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.454 -0400", hash_original_field = "5088DB7B37FA60A2A439242D11325983", hash_generated_field = "84F6801DA315233B24EACF83A24EEC96")

    private static final long serialVersionUID = 6577238317307289933L;
}

