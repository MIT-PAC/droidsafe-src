package java.security.spec;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MGF1ParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.067 -0400", hash_original_field = "77C63DEF22F4DDAC72D34C48EA710C30", hash_generated_field = "A18231849269C88C50E2B2EBD27F62F1")

    private String mdName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.068 -0400", hash_original_method = "D3C3EAC31B08596AB735332742664A5B", hash_generated_method = "D9FAF55DDCC7A8321E256DE6BCDFF660")
    public  MGF1ParameterSpec(String mdName) {
        this.mdName = mdName;
        if(this.mdName == null)        
        {
            NullPointerException var308CD45B1CDBB975772ACEB44A32BD45_466989568 = new NullPointerException("mdName == null");
            var308CD45B1CDBB975772ACEB44A32BD45_466989568.addTaint(taint);
            throw var308CD45B1CDBB975772ACEB44A32BD45_466989568;
        } //End block
        // ---------- Original Method ----------
        //this.mdName = mdName;
        //if (this.mdName == null) {
            //throw new NullPointerException("mdName == null");
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.068 -0400", hash_original_method = "F76E00B788282743E863E8A91477E027", hash_generated_method = "7C14D71FEAD79115C050C38273FCD07E")
    public String getDigestAlgorithm() {
String var2F6B2979B47F1FF73F1CD44382C3AAC7_718402019 =         mdName;
        var2F6B2979B47F1FF73F1CD44382C3AAC7_718402019.addTaint(taint);
        return var2F6B2979B47F1FF73F1CD44382C3AAC7_718402019;
        // ---------- Original Method ----------
        //return mdName;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.068 -0400", hash_original_field = "208892F609BFEA14FBEB3E3672A3B212", hash_generated_field = "BFB08E237C9505534F2E92030BD73DDC")

    public static final MGF1ParameterSpec SHA1 =
        new MGF1ParameterSpec("SHA-1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.068 -0400", hash_original_field = "0A5AAFB5D52DD58429AEB24A3EFA1247", hash_generated_field = "D057F24800CD8427CC225CA34AE84819")

    public static final MGF1ParameterSpec SHA256 =
        new MGF1ParameterSpec("SHA-256");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.069 -0400", hash_original_field = "BCDB4D47591DD0E81874BE0BB4223083", hash_generated_field = "5A063E49D9C9031786762780E1DD8C95")

    public static final MGF1ParameterSpec SHA384 =
        new MGF1ParameterSpec("SHA-384");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.069 -0400", hash_original_field = "4D785B5032F83430EC9D9D0834380F92", hash_generated_field = "5C7C155C8D3D2252E2FDF04D3F5A55B9")

    public static final MGF1ParameterSpec SHA512 =
        new MGF1ParameterSpec("SHA-512");
}

