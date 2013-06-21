package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;

public class PUserDatabase extends gov.nist.javax.sip.header.ParametersHeader implements PUserDatabaseHeader, SIPHeaderNamesIms, ExtensionHeader {
    private String databaseName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.616 -0400", hash_original_method = "7F14AD9E055B0EDA573715DABAF69E4A", hash_generated_method = "CA7B1F512B05A69C129B24DF8853B01E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PUserDatabase(String databaseName) {
        super(NAME);
        dsTaint.addTaint(databaseName);
        // ---------- Original Method ----------
        //this.databaseName = databaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.616 -0400", hash_original_method = "E39FCB193BD9E02D223AAEA09A512240", hash_generated_method = "7ADBEBC1D5F5E2626F7290454A00780A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PUserDatabase() {
        super(P_USER_DATABASE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.617 -0400", hash_original_method = "1786B1376B4CD3FEAEBCAB28A560C6C6", hash_generated_method = "CE27ABC28D966B7DBB2A4494228AF4E7")
    @DSModeled(DSC.SAFE)
    public String getDatabaseName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.databaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.617 -0400", hash_original_method = "D51F20AACD3B656F6DA8A7AF0FAAC017", hash_generated_method = "6E22054E17C6DA802221B2F0AACDFA3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDatabaseName(String databaseName) {
        dsTaint.addTaint(databaseName);
        {
            boolean var6F885EEACD664FF487C08E325F655CE7_1906669122 = ((databaseName==null)||(databaseName.equals(" ")));
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Database name is null");
            {
                boolean varE80BF1BFB6096183B0C913A4D14DBC6F_764389791 = (!databaseName.contains("aaa://"));
                this.databaseName = new StringBuffer().append("aaa://").append(databaseName).toString();
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if((databaseName==null)||(databaseName.equals(" ")))
            //throw new NullPointerException("Database name is null");
        //else
            //if(!databaseName.contains("aaa://"))
        //this.databaseName = new StringBuffer().append("aaa://").append(databaseName).toString();
            //else
                //this.databaseName = databaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.618 -0400", hash_original_method = "C5A419AE4F54D4DB306D1B917A489A39", hash_generated_method = "13660C88E08C7EFE07E07AC5AC7390B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        StringBuffer retval;
        retval = new StringBuffer();
        retval.append("<");
        {
            boolean varA9B2934EF83AB045E2C5BEB25251AC8C_1271862718 = (getDatabaseName()!=null);
            retval.append(getDatabaseName());
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1544641687 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        retval.append(">");
        String var0F1F65BA89BF920BA1A29FC87F91B969_1261552073 = (retval.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.618 -0400", hash_original_method = "E720B3A09C72EF9AD917691C9271EB0A", hash_generated_method = "C349F46E125F4D947D8B52EE462F9F2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        boolean varB67670436F072ACD0F3C6E986BAF90AF_1131097083 = ((other instanceof PUserDatabaseHeader) && super.equals(other));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (other instanceof PUserDatabaseHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.618 -0400", hash_original_method = "0C530D20B34B6FA1A3EDDB9B09D02FD1", hash_generated_method = "2C88CD98E7146E5D7BD96FE1C63891E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PUserDatabase retval;
        retval = (PUserDatabase) super.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PUserDatabase retval = (PUserDatabase) super.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.619 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

