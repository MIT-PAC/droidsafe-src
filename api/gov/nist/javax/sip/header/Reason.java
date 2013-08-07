package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.Utils;

import java.text.ParseException;






public class Reason extends ParametersHeader implements javax.sip.header.ReasonHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.817 -0400", hash_original_field = "7FC2BCE87197C31953A120E8CD83179B", hash_generated_field = "0D9A1057F894C5C025812C805A74752D")

    public final String TEXT = ParameterNames.TEXT;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.817 -0400", hash_original_field = "584FC6002B6AFD83571AE617919A98D6", hash_generated_field = "FB6C8196B2C2E307FFF20FE5A583FA8B")

    public final String CAUSE = ParameterNames.CAUSE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.817 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "8ECC40219F1A47A496A00A4256414BFE")

    protected String protocol;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.817 -0400", hash_original_method = "49B37C8425CF255FB1500AD2816C1ABC", hash_generated_method = "07F22BA75232C6AA162B9790FFFB6280")
    public  Reason() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.817 -0400", hash_original_method = "8E10C2A6776CBAA32EF7257A8A62ADDC", hash_generated_method = "039827E1B867A0526BBDB72E35EDD89F")
    public int getCause() {
        int varB689AF9DF45B4A4C0A6A8AA085C47E02_1929930800 = (getParameterAsInt(CAUSE));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209865017 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1209865017;
        // ---------- Original Method ----------
        //return getParameterAsInt(CAUSE);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.817 -0400", hash_original_method = "3B7AE3E82D120F32D14143BCEAA3D0F3", hash_generated_method = "68A66357C3B1FEBC6226C8217E0662B3")
    public void setCause(int cause) throws javax.sip.InvalidArgumentException {
        addTaint(cause);
        this.parameters.set("cause", Integer.valueOf(cause));
        // ---------- Original Method ----------
        //this.parameters.set("cause", Integer.valueOf(cause));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.818 -0400", hash_original_method = "70E0561C3515B6199EF81B19035663E5", hash_generated_method = "4C76BB115A08F7A5B416485065695A07")
    public void setProtocol(String protocol) throws ParseException {
        this.protocol = protocol;
        // ---------- Original Method ----------
        //this.protocol = protocol;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.818 -0400", hash_original_method = "5EF709A41590C5E9760EDEDCACA5AD40", hash_generated_method = "2B13A3CB8CE6C5D37F71936BC1E790EE")
    public String getProtocol() {
String var6B7E338C8BD363F309A7E471EADA8AA9_1024190022 =         this.protocol;
        var6B7E338C8BD363F309A7E471EADA8AA9_1024190022.addTaint(taint);
        return var6B7E338C8BD363F309A7E471EADA8AA9_1024190022;
        // ---------- Original Method ----------
        //return this.protocol;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.819 -0400", hash_original_method = "A59A90A2875E29D5E7D7A7D1C378A11A", hash_generated_method = "A01CBCF029764DD50C79419193301631")
    public void setText(String text) throws ParseException {
        addTaint(text.getTaint());
        if(text.charAt(0) != '"')        
        {
            text = Utils.getQuotedString(text);
        } //End block
        this.parameters.set("text", text);
        // ---------- Original Method ----------
        //if ( text.charAt(0) != '"' ) {
            //text = Utils.getQuotedString(text);
        //}
        //this.parameters.set("text", text);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.819 -0400", hash_original_method = "E868EA376D386565EBAAF11DC1F8D010", hash_generated_method = "FEA2CA084E0F426B7547614B415D1E84")
    public String getText() {
String varF89C3BEBADC51C1C26007C0B343E4BDB_2099741530 =         this.parameters.getParameter("text");
        varF89C3BEBADC51C1C26007C0B343E4BDB_2099741530.addTaint(taint);
        return varF89C3BEBADC51C1C26007C0B343E4BDB_2099741530;
        // ---------- Original Method ----------
        //return this.parameters.getParameter("text");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.819 -0400", hash_original_method = "58D1ADCDFA9509486623D4E556DE8E64", hash_generated_method = "D87828AA79D6EB79E096E46C441FD73D")
    public String getName() {
String var4AF16528A7526259CFEF5DF72DA3FFB0_1206488181 =         NAME;
        var4AF16528A7526259CFEF5DF72DA3FFB0_1206488181.addTaint(taint);
        return var4AF16528A7526259CFEF5DF72DA3FFB0_1206488181;
        // ---------- Original Method ----------
        //return NAME;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.820 -0400", hash_original_method = "F6A3921BF2DA3805D24A4DD375373A7E", hash_generated_method = "E302A55DD55675FFC36E8E83A5049002")
    protected String encodeBody() {
        StringBuffer s = new StringBuffer();
        s.append(protocol);
        if(parameters != null && !parameters.isEmpty())        
        s.append(SEMICOLON).append(parameters.encode());
String varDE99EC39359AC6BE0E416433FFBB9F13_1186222543 =         s.toString();
        varDE99EC39359AC6BE0E416433FFBB9F13_1186222543.addTaint(taint);
        return varDE99EC39359AC6BE0E416433FFBB9F13_1186222543;
        // ---------- Original Method ----------
        //StringBuffer s = new StringBuffer();
        //s.append(protocol);
        //if (parameters != null && !parameters.isEmpty())
            //s.append(SEMICOLON).append(parameters.encode());
        //return s.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.820 -0400", hash_original_field = "E4C9B7DC021EE557504C75FFB2D6D7D6", hash_generated_field = "7D21FB644FECBA65363EF6F0D18662A5")

    private static final long serialVersionUID = -8903376965568297388L;
}

