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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.396 -0400", hash_original_field = "F618483EEF4956A817EFB2CA268621CA", hash_generated_field = "86C05D139AEEDD5C16FB836B4667558E")

    private String databaseName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.396 -0400", hash_original_method = "7F14AD9E055B0EDA573715DABAF69E4A", hash_generated_method = "D92B52698CB02D38DCC6FEC6BDD40EC8")
    public  PUserDatabase(String databaseName) {
        super(NAME);
        this.databaseName = databaseName;
        // ---------- Original Method ----------
        //this.databaseName = databaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.396 -0400", hash_original_method = "E39FCB193BD9E02D223AAEA09A512240", hash_generated_method = "7ADBEBC1D5F5E2626F7290454A00780A")
    public  PUserDatabase() {
        super(P_USER_DATABASE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.397 -0400", hash_original_method = "1786B1376B4CD3FEAEBCAB28A560C6C6", hash_generated_method = "F7A3CF916A13AEABDABAF52BAD64758B")
    public String getDatabaseName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1701562485 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1701562485 = this.databaseName;
        varB4EAC82CA7396A68D541C85D26508E83_1701562485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1701562485;
        // ---------- Original Method ----------
        //return this.databaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.405 -0400", hash_original_method = "D51F20AACD3B656F6DA8A7AF0FAAC017", hash_generated_method = "47BF2A126108FE00F7152BBE3D314DFC")
    public void setDatabaseName(String databaseName) {
        {
            boolean var6F885EEACD664FF487C08E325F655CE7_946204001 = ((databaseName==null)||(databaseName.equals(" ")));
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Database name is null");
            {
                boolean varE80BF1BFB6096183B0C913A4D14DBC6F_384575127 = (!databaseName.contains("aaa://"));
                this.databaseName = new StringBuffer().append("aaa://").append(databaseName).toString();
                this.databaseName = databaseName;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.406 -0400", hash_original_method = "C5A419AE4F54D4DB306D1B917A489A39", hash_generated_method = "86040D392E6A891C11AC3FF35B7415AB")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_873169723 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        retval.append("<");
        {
            boolean varA9B2934EF83AB045E2C5BEB25251AC8C_155232595 = (getDatabaseName()!=null);
            retval.append(getDatabaseName());
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_501743115 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        retval.append(">");
        varB4EAC82CA7396A68D541C85D26508E83_873169723 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_873169723.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_873169723;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.406 -0400", hash_original_method = "E720B3A09C72EF9AD917691C9271EB0A", hash_generated_method = "08FFF8EF3936AA189AC356EEF59BFA49")
    public boolean equals(Object other) {
        boolean varB67670436F072ACD0F3C6E986BAF90AF_940970543 = ((other instanceof PUserDatabaseHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740701260 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740701260;
        // ---------- Original Method ----------
        //return (other instanceof PUserDatabaseHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.409 -0400", hash_original_method = "0C530D20B34B6FA1A3EDDB9B09D02FD1", hash_generated_method = "8FE8DF7A83C16563EAD41763FDBCE434")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1896136018 = null; //Variable for return #1
        PUserDatabase retval;
        retval = (PUserDatabase) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1896136018 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1896136018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1896136018;
        // ---------- Original Method ----------
        //PUserDatabase retval = (PUserDatabase) super.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.412 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

