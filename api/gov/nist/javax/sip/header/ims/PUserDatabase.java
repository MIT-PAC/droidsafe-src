package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.ExtensionHeader;






public class PUserDatabase extends gov.nist.javax.sip.header.ParametersHeader implements PUserDatabaseHeader, SIPHeaderNamesIms, ExtensionHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.819 -0500", hash_original_field = "1D4A58FFF7AA38B6C9A27CCC6771A449", hash_generated_field = "86C05D139AEEDD5C16FB836B4667558E")


    private String databaseName;

    /**
     *
     * @param databaseName
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.821 -0500", hash_original_method = "7F14AD9E055B0EDA573715DABAF69E4A", hash_generated_method = "CDEDE6DD1D14EFE79101F1481576C186")
    public PUserDatabase(String databaseName)
    {
        super(NAME);
        this.databaseName = databaseName;
    }

    /**
     * Default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.822 -0500", hash_original_method = "E39FCB193BD9E02D223AAEA09A512240", hash_generated_method = "4A7D58B86640240005440BF8BA013D2B")
    public PUserDatabase() {
        super(P_USER_DATABASE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.823 -0500", hash_original_method = "1786B1376B4CD3FEAEBCAB28A560C6C6", hash_generated_method = "670AFE2F9B8340580BECCDB06D8BB4C6")
    public String getDatabaseName() {

        return this.databaseName;
    }

    
    @DSModeled(DSC.SAFE)
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.826 -0500", hash_original_method = "C5A419AE4F54D4DB306D1B917A489A39", hash_generated_method = "C70DDAAF4CE56806DA74FFF9FD29CFCD")
    protected String encodeBody() {

        StringBuffer retval = new StringBuffer();
        retval.append("<");
        if(getDatabaseName()!=null)
        retval.append(getDatabaseName());

        if (!parameters.isEmpty())
            retval.append(SEMICOLON + this.parameters.encode());
        retval.append(">");

        return retval.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.827 -0500", hash_original_method = "E720B3A09C72EF9AD917691C9271EB0A", hash_generated_method = "97914C0F9C0738B1832C0F5D20126DF8")
    public boolean equals(Object other)
    {
        return (other instanceof PUserDatabaseHeader) && super.equals(other);

    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.828 -0500", hash_original_method = "0C530D20B34B6FA1A3EDDB9B09D02FD1", hash_generated_method = "6D9B725C8901044875E10FB3FDDD193C")
    public Object clone() {
        PUserDatabase retval = (PUserDatabase) super.clone();
        return retval;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.829 -0500", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "014FE50D8A9A4F50DCF1C9E31F934432")
    public void setValue(String value) throws ParseException {
        throw new ParseException(value,0);

    }

    
}

