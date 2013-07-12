package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;

public class PUserDatabase extends gov.nist.javax.sip.header.ParametersHeader implements PUserDatabaseHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.074 -0400", hash_original_field = "F618483EEF4956A817EFB2CA268621CA", hash_generated_field = "86C05D139AEEDD5C16FB836B4667558E")

    private String databaseName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.074 -0400", hash_original_method = "7F14AD9E055B0EDA573715DABAF69E4A", hash_generated_method = "D92B52698CB02D38DCC6FEC6BDD40EC8")
    public  PUserDatabase(String databaseName) {
        super(NAME);
        this.databaseName = databaseName;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.074 -0400", hash_original_method = "E39FCB193BD9E02D223AAEA09A512240", hash_generated_method = "7ADBEBC1D5F5E2626F7290454A00780A")
    public  PUserDatabase() {
        super(P_USER_DATABASE);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.075 -0400", hash_original_method = "1786B1376B4CD3FEAEBCAB28A560C6C6", hash_generated_method = "3D81D0E04E157D102DF8F1AEF4E4D3A4")
    public String getDatabaseName() {
String var851A3104A174A0317C1CB008C48A1898_493213275 =         this.databaseName;
        var851A3104A174A0317C1CB008C48A1898_493213275.addTaint(taint);
        return var851A3104A174A0317C1CB008C48A1898_493213275;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.075 -0400", hash_original_method = "D51F20AACD3B656F6DA8A7AF0FAAC017", hash_generated_method = "42245F866E63A2300CEC434B1AA7AF15")
    public void setDatabaseName(String databaseName) {
    if((databaseName==null)||(databaseName.equals(" ")))        
        {
        NullPointerException varA3D75CD097E396096D0DAAE2F57C8E0F_1560426686 = new NullPointerException("Database name is null");
        varA3D75CD097E396096D0DAAE2F57C8E0F_1560426686.addTaint(taint);
        throw varA3D75CD097E396096D0DAAE2F57C8E0F_1560426686;
        }
        else
    if(!databaseName.contains("aaa://"))        
        this.databaseName = new StringBuffer().append("aaa://").append(databaseName).toString();
        else
        this.databaseName = databaseName;
        
        
            
        
            
        
            
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.076 -0400", hash_original_method = "C5A419AE4F54D4DB306D1B917A489A39", hash_generated_method = "E0A2F29B7071073CE81490309B312C43")
    protected String encodeBody() {
        StringBuffer retval = new StringBuffer();
        retval.append("<");
    if(getDatabaseName()!=null)        
        retval.append(getDatabaseName());
    if(!parameters.isEmpty())        
        retval.append(SEMICOLON + this.parameters.encode());
        retval.append(">");
String var1B324365A764C077A55854483509F4AB_407987131 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_407987131.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_407987131;
        
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.076 -0400", hash_original_method = "E720B3A09C72EF9AD917691C9271EB0A", hash_generated_method = "3BBB8EB595D4673B6968E1283B850E37")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean var3F1E40688CFCC9D3E63130371C01BF36_2061185265 = ((other instanceof PUserDatabaseHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_422947862 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_422947862;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.077 -0400", hash_original_method = "0C530D20B34B6FA1A3EDDB9B09D02FD1", hash_generated_method = "55698EE82F7160EF1A5EFE77FA5E08BC")
    public Object clone() {
        PUserDatabase retval = (PUserDatabase) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_137964154 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_137964154.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_137964154;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.078 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "D0856B54B2DC1902ECE86C67734AFA4C")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1066327932 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1066327932.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1066327932;
        
        
    }

    
}

