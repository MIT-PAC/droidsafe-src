package java.security.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class PSSParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.110 -0400", hash_original_field = "77C63DEF22F4DDAC72D34C48EA710C30", hash_generated_field = "A18231849269C88C50E2B2EBD27F62F1")

    private String mdName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.110 -0400", hash_original_field = "C55A76393D253F986DCAD6FC784E8AB0", hash_generated_field = "7037C1B56C4829059706BDC8C763F05D")

    private String mgfName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.111 -0400", hash_original_field = "4335FDFF987F287C82710A6F99AA5344", hash_generated_field = "54888600845BA61DA06DAEAE4F3D1B9B")

    private AlgorithmParameterSpec mgfSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.111 -0400", hash_original_field = "3A4430CC349D3B8A1E847B147ACBA301", hash_generated_field = "0F7BFD027DD96EC08A17C4071735F2F7")

    private int trailerField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.111 -0400", hash_original_field = "056E4139309C25B9756680DC9176AB5D", hash_generated_field = "9F16D70DF9DD07F0831E6FA13D5B763E")

    private int saltLen;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.111 -0400", hash_original_method = "DF0A0B659FB6696FF8FDF8F1667A2EB8", hash_generated_method = "089355BBEF841FCDC41C8741C7679286")
    public  PSSParameterSpec(int saltLen) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("saltLen < 0");
        } 
        this.saltLen = saltLen;
        this.mdName = "SHA-1";
        this.mgfName = "MGF1";
        this.mgfSpec = MGF1ParameterSpec.SHA1;
        this.trailerField = 1;
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.112 -0400", hash_original_method = "2EEF33BA597A16DAC82E184329E7377A", hash_generated_method = "2ED17A4868ED5B08C1FA3E80251F426A")
    public  PSSParameterSpec(String mdName, String mgfName,
            AlgorithmParameterSpec mgfSpec, int saltLen, int trailerField) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("mdName == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("mgfName == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("saltLen < 0");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("trailerField < 0");
        } 
        this.mdName = mdName;
        this.mgfName = mgfName;
        this.mgfSpec = mgfSpec;
        this.saltLen = saltLen;
        this.trailerField = trailerField;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.112 -0400", hash_original_method = "B164C3A01C2D5FB8FE5C16711A461B38", hash_generated_method = "EC1498F19B42BA02C577FA61211BC852")
    public int getSaltLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503555562 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1503555562;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.114 -0400", hash_original_method = "F76E00B788282743E863E8A91477E027", hash_generated_method = "7CDF333F78EFCB89B8285B4A9D9D78EC")
    public String getDigestAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_2072457039 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2072457039 = mdName;
        varB4EAC82CA7396A68D541C85D26508E83_2072457039.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2072457039;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.117 -0400", hash_original_method = "11682E81B271E60CD76F4E3CFB1D831D", hash_generated_method = "9D4F0151E3C5368BAB9228458B2E3D8B")
    public String getMGFAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_466000623 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_466000623 = mgfName;
        varB4EAC82CA7396A68D541C85D26508E83_466000623.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_466000623;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.119 -0400", hash_original_method = "79BC41FB5304035884EA00639B685A6D", hash_generated_method = "65195582D1EC56C105BF6552597CFDB0")
    public AlgorithmParameterSpec getMGFParameters() {
        AlgorithmParameterSpec varB4EAC82CA7396A68D541C85D26508E83_1943738111 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1943738111 = mgfSpec;
        varB4EAC82CA7396A68D541C85D26508E83_1943738111.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1943738111;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.120 -0400", hash_original_method = "61A230854EAEDDEEB7E5A3E90232200C", hash_generated_method = "6094C338D9522431A70D3B3F6DFC32AB")
    public int getTrailerField() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585043499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585043499;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.120 -0400", hash_original_field = "90102F17CA61339AE62C1DCA204BAFCE", hash_generated_field = "D0AAC5950354538CCC2B6FA63F8FA841")

    public static final PSSParameterSpec DEFAULT = new PSSParameterSpec(20);
}

