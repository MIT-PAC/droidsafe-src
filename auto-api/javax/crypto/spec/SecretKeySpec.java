package javax.crypto.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKey;

public class SecretKeySpec implements SecretKey, KeySpec, Serializable {
    private byte[] key;
    private String algorithm;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.002 -0400", hash_original_method = "46BCBD91E8C2018C32B65BFBDD14DAE3", hash_generated_method = "C3BA9150AA0A8295FCA81CB84D3234C0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecretKeySpec(byte[] key, String algorithm) {
        dsTaint.addTaint(key[0]);
        dsTaint.addTaint(algorithm);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key.length == 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("algorithm == null");
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.002 -0400", hash_original_method = "97539A44FE944982691962B490B5A049", hash_generated_method = "B593AADC54346733100B5251840E3090")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SecretKeySpec(byte[] key, int offset, int len, String algorithm) {
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(key[0]);
        dsTaint.addTaint(algorithm);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key.length == 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException("len < 0 || offset < 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("key too short");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("algorithm == null");
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.002 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "AB6B64DEEAE2006CFA3127C5F18A75FB")
    @DSModeled(DSC.SAFE)
    public String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.002 -0400", hash_original_method = "DA06499CB28B740B0D3C21B02311BB46", hash_generated_method = "FCCF36A7A55AD29DDCD0302FFB6B0974")
    @DSModeled(DSC.SAFE)
    public String getFormat() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "RAW";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.002 -0400", hash_original_method = "3F6C1397C7B2518265F6653D66E9AC87", hash_generated_method = "2F78319AE1588AC0E7041B5AF8F52631")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        byte[] result;
        result = new byte[key.length];
        System.arraycopy(key, 0, result, 0, key.length);
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //byte[] result = new byte[key.length];
        //System.arraycopy(key, 0, result, 0, key.length);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.004 -0400", hash_original_method = "561BEB6A8D834A34E4D5A2503144263D", hash_generated_method = "92F1A6B7F9BD4AEB0E1BA25003DE8720")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int result;
        result = algorithm.length();
        {
            byte element = key[0];
            {
                result += element;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = algorithm.length();
        //for (byte element : key) {
            //result += element;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.005 -0400", hash_original_method = "7E1551F3E39A01E70E4CFF4FAB6C7AC5", hash_generated_method = "05CA2C249163D80F48B6F7063B470EC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1871206797 = (obj == this);
        } //End collapsed parenthetic
        SecretKeySpec ks;
        ks = (SecretKeySpec) obj;
        boolean varF2E5A45CF56A7633348AC78DE027833D_1894897476 = ((algorithm.equalsIgnoreCase(ks.algorithm))
            && (Arrays.equals(key, ks.key)));
        return dsTaint.getTaintBoolean();
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

    
    private static final long serialVersionUID = 6577238317307289933L;
}

