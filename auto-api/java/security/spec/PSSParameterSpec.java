package java.security.spec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class PSSParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.665 -0400", hash_original_field = "77C63DEF22F4DDAC72D34C48EA710C30", hash_generated_field = "A18231849269C88C50E2B2EBD27F62F1")

    private String mdName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.666 -0400", hash_original_field = "C55A76393D253F986DCAD6FC784E8AB0", hash_generated_field = "7037C1B56C4829059706BDC8C763F05D")

    private String mgfName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.666 -0400", hash_original_field = "4335FDFF987F287C82710A6F99AA5344", hash_generated_field = "54888600845BA61DA06DAEAE4F3D1B9B")

    private AlgorithmParameterSpec mgfSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.666 -0400", hash_original_field = "3A4430CC349D3B8A1E847B147ACBA301", hash_generated_field = "0F7BFD027DD96EC08A17C4071735F2F7")

    private int trailerField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.666 -0400", hash_original_field = "056E4139309C25B9756680DC9176AB5D", hash_generated_field = "9F16D70DF9DD07F0831E6FA13D5B763E")

    private int saltLen;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.674 -0400", hash_original_method = "DF0A0B659FB6696FF8FDF8F1667A2EB8", hash_generated_method = "089355BBEF841FCDC41C8741C7679286")
    public  PSSParameterSpec(int saltLen) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("saltLen < 0");
        } //End block
        this.saltLen = saltLen;
        this.mdName = "SHA-1";
        this.mgfName = "MGF1";
        this.mgfSpec = MGF1ParameterSpec.SHA1;
        this.trailerField = 1;
        // ---------- Original Method ----------
        //if (saltLen < 0) {
            //throw new IllegalArgumentException("saltLen < 0");
        //}
        //this.saltLen = saltLen;
        //this.mdName = "SHA-1";
        //this.mgfName = "MGF1";
        //this.mgfSpec = MGF1ParameterSpec.SHA1;
        //this.trailerField = 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.682 -0400", hash_original_method = "2EEF33BA597A16DAC82E184329E7377A", hash_generated_method = "2ED17A4868ED5B08C1FA3E80251F426A")
    public  PSSParameterSpec(String mdName, String mgfName,
            AlgorithmParameterSpec mgfSpec, int saltLen, int trailerField) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("mdName == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("mgfName == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("saltLen < 0");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("trailerField < 0");
        } //End block
        this.mdName = mdName;
        this.mgfName = mgfName;
        this.mgfSpec = mgfSpec;
        this.saltLen = saltLen;
        this.trailerField = trailerField;
        // ---------- Original Method ----------
        //if (mdName == null) {
            //throw new NullPointerException("mdName == null");
        //}
        //if (mgfName == null) {
            //throw new NullPointerException("mgfName == null");
        //}
        //if (saltLen < 0) {
            //throw new IllegalArgumentException("saltLen < 0");
        //}
        //if (trailerField < 0) {
            //throw new IllegalArgumentException("trailerField < 0");
        //}
        //this.mdName = mdName;
        //this.mgfName = mgfName;
        //this.mgfSpec = mgfSpec;
        //this.saltLen = saltLen;
        //this.trailerField = trailerField;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.683 -0400", hash_original_method = "B164C3A01C2D5FB8FE5C16711A461B38", hash_generated_method = "D392CA87E348F800F4B59F4DB76F0247")
    public int getSaltLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396141536 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396141536;
        // ---------- Original Method ----------
        //return saltLen;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.684 -0400", hash_original_method = "F76E00B788282743E863E8A91477E027", hash_generated_method = "3A6413A378D31FAA100A3707E83CD8F1")
    public String getDigestAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_2035828173 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2035828173 = mdName;
        varB4EAC82CA7396A68D541C85D26508E83_2035828173.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2035828173;
        // ---------- Original Method ----------
        //return mdName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.690 -0400", hash_original_method = "11682E81B271E60CD76F4E3CFB1D831D", hash_generated_method = "BEB8418959DE86AD75C8B80C75B5954A")
    public String getMGFAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_175566923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_175566923 = mgfName;
        varB4EAC82CA7396A68D541C85D26508E83_175566923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_175566923;
        // ---------- Original Method ----------
        //return mgfName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.690 -0400", hash_original_method = "79BC41FB5304035884EA00639B685A6D", hash_generated_method = "4F4D74EF7D836F13D8F1305B74BDC6E2")
    public AlgorithmParameterSpec getMGFParameters() {
        AlgorithmParameterSpec varB4EAC82CA7396A68D541C85D26508E83_1851235058 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1851235058 = mgfSpec;
        varB4EAC82CA7396A68D541C85D26508E83_1851235058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1851235058;
        // ---------- Original Method ----------
        //return mgfSpec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.690 -0400", hash_original_method = "61A230854EAEDDEEB7E5A3E90232200C", hash_generated_method = "CE2DDB83BEC0541F2E3FB3E339ACA1F3")
    public int getTrailerField() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267332814 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_267332814;
        // ---------- Original Method ----------
        //return trailerField;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.691 -0400", hash_original_field = "90102F17CA61339AE62C1DCA204BAFCE", hash_generated_field = "D0AAC5950354538CCC2B6FA63F8FA841")

    public static final PSSParameterSpec DEFAULT = new PSSParameterSpec(20);
}

