package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;

public class PUserDatabase extends gov.nist.javax.sip.header.ParametersHeader implements PUserDatabaseHeader, SIPHeaderNamesIms, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.311 -0400", hash_original_field = "F618483EEF4956A817EFB2CA268621CA", hash_generated_field = "86C05D139AEEDD5C16FB836B4667558E")

    private String databaseName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.312 -0400", hash_original_method = "7F14AD9E055B0EDA573715DABAF69E4A", hash_generated_method = "D92B52698CB02D38DCC6FEC6BDD40EC8")
    public  PUserDatabase(String databaseName) {
        super(NAME);
        this.databaseName = databaseName;
        // ---------- Original Method ----------
        //this.databaseName = databaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.313 -0400", hash_original_method = "E39FCB193BD9E02D223AAEA09A512240", hash_generated_method = "7ADBEBC1D5F5E2626F7290454A00780A")
    public  PUserDatabase() {
        super(P_USER_DATABASE);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.313 -0400", hash_original_method = "1786B1376B4CD3FEAEBCAB28A560C6C6", hash_generated_method = "9A36C59C264B750AC892DA490404C9E5")
    public String getDatabaseName() {
String var851A3104A174A0317C1CB008C48A1898_1816861506 =         this.databaseName;
        var851A3104A174A0317C1CB008C48A1898_1816861506.addTaint(taint);
        return var851A3104A174A0317C1CB008C48A1898_1816861506;
        // ---------- Original Method ----------
        //return this.databaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.314 -0400", hash_original_method = "D51F20AACD3B656F6DA8A7AF0FAAC017", hash_generated_method = "91E5237D80F9174CB1590C4B10B03A2D")
    public void setDatabaseName(String databaseName) {
        if((databaseName==null)||(databaseName.equals(" ")))        
        {
        NullPointerException varA3D75CD097E396096D0DAAE2F57C8E0F_272624513 = new NullPointerException("Database name is null");
        varA3D75CD097E396096D0DAAE2F57C8E0F_272624513.addTaint(taint);
        throw varA3D75CD097E396096D0DAAE2F57C8E0F_272624513;
        }
        else
        if(!databaseName.contains("aaa://"))        
        this.databaseName = new StringBuffer().append("aaa://").append(databaseName).toString();
        else
        this.databaseName = databaseName;
        // ---------- Original Method ----------
        //if((databaseName==null)||(databaseName.equals(" ")))
            //throw new NullPointerException("Database name is null");
        //else
            //if(!databaseName.contains("aaa://"))
        //this.databaseName = new StringBuffer().append("aaa://").append(databaseName).toString();
            //else
                //this.databaseName = databaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.315 -0400", hash_original_method = "C5A419AE4F54D4DB306D1B917A489A39", hash_generated_method = "BEBA6C18DDCC85E39E5FF2F53C7E119B")
    protected String encodeBody() {
        StringBuffer retval = new StringBuffer();
        retval.append("<");
        if(getDatabaseName()!=null)        
        retval.append(getDatabaseName());
        if(!parameters.isEmpty())        
        retval.append(SEMICOLON + this.parameters.encode());
        retval.append(">");
String var1B324365A764C077A55854483509F4AB_1568807094 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1568807094.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1568807094;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //retval.append("<");
        //if(getDatabaseName()!=null)
        //retval.append(getDatabaseName());
        //if (!parameters.isEmpty())
            //retval.append(SEMICOLON + this.parameters.encode());
        //retval.append(">");
        //return retval.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.315 -0400", hash_original_method = "E720B3A09C72EF9AD917691C9271EB0A", hash_generated_method = "B3322184744010EEF7D53A92350244ED")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        boolean var3F1E40688CFCC9D3E63130371C01BF36_1897275212 = ((other instanceof PUserDatabaseHeader) && super.equals(other));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_633777465 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_633777465;
        // ---------- Original Method ----------
        //return (other instanceof PUserDatabaseHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.316 -0400", hash_original_method = "0C530D20B34B6FA1A3EDDB9B09D02FD1", hash_generated_method = "ACF42A12B145A985EA606CF7A8E3892E")
    public Object clone() {
        PUserDatabase retval = (PUserDatabase) super.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_1478173343 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1478173343.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1478173343;
        // ---------- Original Method ----------
        //PUserDatabase retval = (PUserDatabase) super.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.316 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "428B4B9CDB575F17D579EF393C70DE47")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1750790898 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1750790898.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1750790898;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

