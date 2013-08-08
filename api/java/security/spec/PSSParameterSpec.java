package java.security.spec;

// Droidsafe Imports
import droidsafe.annotations.*;





public class PSSParameterSpec implements AlgorithmParameterSpec {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.087 -0400", hash_original_field = "77C63DEF22F4DDAC72D34C48EA710C30", hash_generated_field = "A18231849269C88C50E2B2EBD27F62F1")

    private String mdName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.087 -0400", hash_original_field = "C55A76393D253F986DCAD6FC784E8AB0", hash_generated_field = "7037C1B56C4829059706BDC8C763F05D")

    private String mgfName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.088 -0400", hash_original_field = "4335FDFF987F287C82710A6F99AA5344", hash_generated_field = "54888600845BA61DA06DAEAE4F3D1B9B")

    private AlgorithmParameterSpec mgfSpec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.088 -0400", hash_original_field = "3A4430CC349D3B8A1E847B147ACBA301", hash_generated_field = "0F7BFD027DD96EC08A17C4071735F2F7")

    private int trailerField;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.088 -0400", hash_original_field = "056E4139309C25B9756680DC9176AB5D", hash_generated_field = "9F16D70DF9DD07F0831E6FA13D5B763E")

    private int saltLen;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.089 -0400", hash_original_method = "DF0A0B659FB6696FF8FDF8F1667A2EB8", hash_generated_method = "08FEC0CAF10307C66602DA9D78CC2334")
    public  PSSParameterSpec(int saltLen) {
        if(saltLen < 0)        
        {
            IllegalArgumentException varABD20882DFEE85B25145FFD283521C15_1661541629 = new IllegalArgumentException("saltLen < 0");
            varABD20882DFEE85B25145FFD283521C15_1661541629.addTaint(taint);
            throw varABD20882DFEE85B25145FFD283521C15_1661541629;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.092 -0400", hash_original_method = "2EEF33BA597A16DAC82E184329E7377A", hash_generated_method = "B16A686E510EAEEC344A39F81090D76B")
    public  PSSParameterSpec(String mdName, String mgfName,
            AlgorithmParameterSpec mgfSpec, int saltLen, int trailerField) {
        if(mdName == null)        
        {
            NullPointerException var308CD45B1CDBB975772ACEB44A32BD45_294467380 = new NullPointerException("mdName == null");
            var308CD45B1CDBB975772ACEB44A32BD45_294467380.addTaint(taint);
            throw var308CD45B1CDBB975772ACEB44A32BD45_294467380;
        } //End block
        if(mgfName == null)        
        {
            NullPointerException varC2CB04552062F68274809026FD0FC39D_618636270 = new NullPointerException("mgfName == null");
            varC2CB04552062F68274809026FD0FC39D_618636270.addTaint(taint);
            throw varC2CB04552062F68274809026FD0FC39D_618636270;
        } //End block
        if(saltLen < 0)        
        {
            IllegalArgumentException varABD20882DFEE85B25145FFD283521C15_1399323948 = new IllegalArgumentException("saltLen < 0");
            varABD20882DFEE85B25145FFD283521C15_1399323948.addTaint(taint);
            throw varABD20882DFEE85B25145FFD283521C15_1399323948;
        } //End block
        if(trailerField < 0)        
        {
            IllegalArgumentException var6684FE99813ADF0B05A7EA2C1C8F032B_2079342847 = new IllegalArgumentException("trailerField < 0");
            var6684FE99813ADF0B05A7EA2C1C8F032B_2079342847.addTaint(taint);
            throw var6684FE99813ADF0B05A7EA2C1C8F032B_2079342847;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.093 -0400", hash_original_method = "B164C3A01C2D5FB8FE5C16711A461B38", hash_generated_method = "6548F7136D052C51D574E377D19487E2")
    public int getSaltLength() {
        int var056E4139309C25B9756680DC9176AB5D_1596829105 = (saltLen);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120639758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120639758;
        // ---------- Original Method ----------
        //return saltLen;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.093 -0400", hash_original_method = "F76E00B788282743E863E8A91477E027", hash_generated_method = "FA58F98284234B00A66949B81587EAEE")
    public String getDigestAlgorithm() {
String var2F6B2979B47F1FF73F1CD44382C3AAC7_1239080067 =         mdName;
        var2F6B2979B47F1FF73F1CD44382C3AAC7_1239080067.addTaint(taint);
        return var2F6B2979B47F1FF73F1CD44382C3AAC7_1239080067;
        // ---------- Original Method ----------
        //return mdName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.094 -0400", hash_original_method = "11682E81B271E60CD76F4E3CFB1D831D", hash_generated_method = "4D082ECB664AA6CA54C0734C9EFEFB3D")
    public String getMGFAlgorithm() {
String var10E900ABFC9A9F07D66DAFF61B2B7D0A_404530936 =         mgfName;
        var10E900ABFC9A9F07D66DAFF61B2B7D0A_404530936.addTaint(taint);
        return var10E900ABFC9A9F07D66DAFF61B2B7D0A_404530936;
        // ---------- Original Method ----------
        //return mgfName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.094 -0400", hash_original_method = "79BC41FB5304035884EA00639B685A6D", hash_generated_method = "4B263421C633AE97D34CEB8A4BC77641")
    public AlgorithmParameterSpec getMGFParameters() {
AlgorithmParameterSpec var450A2359A3589399018B2039256375D9_225103027 =         mgfSpec;
        var450A2359A3589399018B2039256375D9_225103027.addTaint(taint);
        return var450A2359A3589399018B2039256375D9_225103027;
        // ---------- Original Method ----------
        //return mgfSpec;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.095 -0400", hash_original_method = "61A230854EAEDDEEB7E5A3E90232200C", hash_generated_method = "2178A2B2B7B8D4B1E98D6384D4082200")
    public int getTrailerField() {
        int var3A4430CC349D3B8A1E847B147ACBA301_288112151 = (trailerField);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356004005 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1356004005;
        // ---------- Original Method ----------
        //return trailerField;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.095 -0400", hash_original_field = "90102F17CA61339AE62C1DCA204BAFCE", hash_generated_field = "D0AAC5950354538CCC2B6FA63F8FA841")

    public static final PSSParameterSpec DEFAULT = new PSSParameterSpec(20);
}

