package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class MGF1ParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.973 -0400", hash_original_field = "77C63DEF22F4DDAC72D34C48EA710C30", hash_generated_field = "A18231849269C88C50E2B2EBD27F62F1")

    private String mdName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.974 -0400", hash_original_method = "D3C3EAC31B08596AB735332742664A5B", hash_generated_method = "30A79127DB255EF952524CB4078BAE21")
    public  MGF1ParameterSpec(String mdName) {
        this.mdName = mdName;
    if(this.mdName == null)        
        {
            NullPointerException var308CD45B1CDBB975772ACEB44A32BD45_1182527040 = new NullPointerException("mdName == null");
            var308CD45B1CDBB975772ACEB44A32BD45_1182527040.addTaint(taint);
            throw var308CD45B1CDBB975772ACEB44A32BD45_1182527040;
        } //End block
        // ---------- Original Method ----------
        //this.mdName = mdName;
        //if (this.mdName == null) {
            //throw new NullPointerException("mdName == null");
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.974 -0400", hash_original_method = "F76E00B788282743E863E8A91477E027", hash_generated_method = "9FE9D64349DAA8611C2E8109A8D15B7E")
    public String getDigestAlgorithm() {
String var2F6B2979B47F1FF73F1CD44382C3AAC7_1550836444 =         mdName;
        var2F6B2979B47F1FF73F1CD44382C3AAC7_1550836444.addTaint(taint);
        return var2F6B2979B47F1FF73F1CD44382C3AAC7_1550836444;
        // ---------- Original Method ----------
        //return mdName;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.974 -0400", hash_original_field = "208892F609BFEA14FBEB3E3672A3B212", hash_generated_field = "BFB08E237C9505534F2E92030BD73DDC")

    public static final MGF1ParameterSpec SHA1 =
        new MGF1ParameterSpec("SHA-1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.974 -0400", hash_original_field = "0A5AAFB5D52DD58429AEB24A3EFA1247", hash_generated_field = "D057F24800CD8427CC225CA34AE84819")

    public static final MGF1ParameterSpec SHA256 =
        new MGF1ParameterSpec("SHA-256");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.974 -0400", hash_original_field = "BCDB4D47591DD0E81874BE0BB4223083", hash_generated_field = "5A063E49D9C9031786762780E1DD8C95")

    public static final MGF1ParameterSpec SHA384 =
        new MGF1ParameterSpec("SHA-384");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.974 -0400", hash_original_field = "4D785B5032F83430EC9D9D0834380F92", hash_generated_field = "5C7C155C8D3D2252E2FDF04D3F5A55B9")

    public static final MGF1ParameterSpec SHA512 =
        new MGF1ParameterSpec("SHA-512");
}

