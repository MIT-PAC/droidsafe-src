package java.security.spec;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class PSSParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.987 -0400", hash_original_field = "77C63DEF22F4DDAC72D34C48EA710C30", hash_generated_field = "A18231849269C88C50E2B2EBD27F62F1")

    private String mdName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.987 -0400", hash_original_field = "C55A76393D253F986DCAD6FC784E8AB0", hash_generated_field = "7037C1B56C4829059706BDC8C763F05D")

    private String mgfName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.987 -0400", hash_original_field = "4335FDFF987F287C82710A6F99AA5344", hash_generated_field = "54888600845BA61DA06DAEAE4F3D1B9B")

    private AlgorithmParameterSpec mgfSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.987 -0400", hash_original_field = "3A4430CC349D3B8A1E847B147ACBA301", hash_generated_field = "0F7BFD027DD96EC08A17C4071735F2F7")

    private int trailerField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.987 -0400", hash_original_field = "056E4139309C25B9756680DC9176AB5D", hash_generated_field = "9F16D70DF9DD07F0831E6FA13D5B763E")

    private int saltLen;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.989 -0400", hash_original_method = "DF0A0B659FB6696FF8FDF8F1667A2EB8", hash_generated_method = "8D66FC5306CE8F0CF714D83231D15226")
    public  PSSParameterSpec(int saltLen) {
    if(saltLen < 0)        
        {
            IllegalArgumentException varABD20882DFEE85B25145FFD283521C15_73630137 = new IllegalArgumentException("saltLen < 0");
            varABD20882DFEE85B25145FFD283521C15_73630137.addTaint(taint);
            throw varABD20882DFEE85B25145FFD283521C15_73630137;
        } 
        this.saltLen = saltLen;
        this.mdName = "SHA-1";
        this.mgfName = "MGF1";
        this.mgfSpec = MGF1ParameterSpec.SHA1;
        this.trailerField = 1;
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.992 -0400", hash_original_method = "2EEF33BA597A16DAC82E184329E7377A", hash_generated_method = "CB274210AE4CE1A65E7C5B80216D86A9")
    public  PSSParameterSpec(String mdName, String mgfName,
            AlgorithmParameterSpec mgfSpec, int saltLen, int trailerField) {
    if(mdName == null)        
        {
            NullPointerException var308CD45B1CDBB975772ACEB44A32BD45_1783932235 = new NullPointerException("mdName == null");
            var308CD45B1CDBB975772ACEB44A32BD45_1783932235.addTaint(taint);
            throw var308CD45B1CDBB975772ACEB44A32BD45_1783932235;
        } 
    if(mgfName == null)        
        {
            NullPointerException varC2CB04552062F68274809026FD0FC39D_1620255371 = new NullPointerException("mgfName == null");
            varC2CB04552062F68274809026FD0FC39D_1620255371.addTaint(taint);
            throw varC2CB04552062F68274809026FD0FC39D_1620255371;
        } 
    if(saltLen < 0)        
        {
            IllegalArgumentException varABD20882DFEE85B25145FFD283521C15_530619831 = new IllegalArgumentException("saltLen < 0");
            varABD20882DFEE85B25145FFD283521C15_530619831.addTaint(taint);
            throw varABD20882DFEE85B25145FFD283521C15_530619831;
        } 
    if(trailerField < 0)        
        {
            IllegalArgumentException var6684FE99813ADF0B05A7EA2C1C8F032B_365878875 = new IllegalArgumentException("trailerField < 0");
            var6684FE99813ADF0B05A7EA2C1C8F032B_365878875.addTaint(taint);
            throw var6684FE99813ADF0B05A7EA2C1C8F032B_365878875;
        } 
        this.mdName = mdName;
        this.mgfName = mgfName;
        this.mgfSpec = mgfSpec;
        this.saltLen = saltLen;
        this.trailerField = trailerField;
        
        
            
        
        
            
        
        
            
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.993 -0400", hash_original_method = "B164C3A01C2D5FB8FE5C16711A461B38", hash_generated_method = "506D81554DA755C976BC4543BD9A3DC2")
    public int getSaltLength() {
        int var056E4139309C25B9756680DC9176AB5D_1168656951 = (saltLen);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188007727 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188007727;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.993 -0400", hash_original_method = "F76E00B788282743E863E8A91477E027", hash_generated_method = "D0AFFCE982B7226BEB48FFDADF469760")
    public String getDigestAlgorithm() {
String var2F6B2979B47F1FF73F1CD44382C3AAC7_2018276284 =         mdName;
        var2F6B2979B47F1FF73F1CD44382C3AAC7_2018276284.addTaint(taint);
        return var2F6B2979B47F1FF73F1CD44382C3AAC7_2018276284;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.994 -0400", hash_original_method = "11682E81B271E60CD76F4E3CFB1D831D", hash_generated_method = "B112E9813D141992CBF7588A761A25E4")
    public String getMGFAlgorithm() {
String var10E900ABFC9A9F07D66DAFF61B2B7D0A_1201767659 =         mgfName;
        var10E900ABFC9A9F07D66DAFF61B2B7D0A_1201767659.addTaint(taint);
        return var10E900ABFC9A9F07D66DAFF61B2B7D0A_1201767659;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.994 -0400", hash_original_method = "79BC41FB5304035884EA00639B685A6D", hash_generated_method = "D716A7766B7BECFD0726AD2512A21E8C")
    public AlgorithmParameterSpec getMGFParameters() {
AlgorithmParameterSpec var450A2359A3589399018B2039256375D9_1038783271 =         mgfSpec;
        var450A2359A3589399018B2039256375D9_1038783271.addTaint(taint);
        return var450A2359A3589399018B2039256375D9_1038783271;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.994 -0400", hash_original_method = "61A230854EAEDDEEB7E5A3E90232200C", hash_generated_method = "0F343CCDE1BA4B1195498CFB941BBCF9")
    public int getTrailerField() {
        int var3A4430CC349D3B8A1E847B147ACBA301_2115387423 = (trailerField);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496166719 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_496166719;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:58.995 -0400", hash_original_field = "90102F17CA61339AE62C1DCA204BAFCE", hash_generated_field = "D0AAC5950354538CCC2B6FA63F8FA841")

    public static final PSSParameterSpec DEFAULT = new PSSParameterSpec(20);
}

