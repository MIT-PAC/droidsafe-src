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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.550 -0400", hash_original_field = "F618483EEF4956A817EFB2CA268621CA", hash_generated_field = "86C05D139AEEDD5C16FB836B4667558E")

    private String databaseName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.550 -0400", hash_original_method = "7F14AD9E055B0EDA573715DABAF69E4A", hash_generated_method = "D92B52698CB02D38DCC6FEC6BDD40EC8")
    public  PUserDatabase(String databaseName) {
        super(NAME);
        this.databaseName = databaseName;
        // ---------- Original Method ----------
        //this.databaseName = databaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.553 -0400", hash_original_method = "E39FCB193BD9E02D223AAEA09A512240", hash_generated_method = "7ADBEBC1D5F5E2626F7290454A00780A")
    public  PUserDatabase() {
        super(P_USER_DATABASE);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.555 -0400", hash_original_method = "1786B1376B4CD3FEAEBCAB28A560C6C6", hash_generated_method = "D711C262641ED4B01540BEE48F0AAEA7")
    public String getDatabaseName() {
        String varB4EAC82CA7396A68D541C85D26508E83_241500307 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_241500307 = this.databaseName;
        varB4EAC82CA7396A68D541C85D26508E83_241500307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_241500307;
        // ---------- Original Method ----------
        //return this.databaseName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.559 -0400", hash_original_method = "D51F20AACD3B656F6DA8A7AF0FAAC017", hash_generated_method = "310F7E88D0CFE29B124AC32549BCA19E")
    public void setDatabaseName(String databaseName) {
        {
            boolean var6F885EEACD664FF487C08E325F655CE7_1687134856 = ((databaseName==null)||(databaseName.equals(" ")));
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Database name is null");
            {
                boolean varE80BF1BFB6096183B0C913A4D14DBC6F_1020094486 = (!databaseName.contains("aaa://"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.561 -0400", hash_original_method = "C5A419AE4F54D4DB306D1B917A489A39", hash_generated_method = "FE1162022C3E3E8EA1F7A9977BC8072F")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_339304121 = null; //Variable for return #1
        StringBuffer retval;
        retval = new StringBuffer();
        retval.append("<");
        {
            boolean varA9B2934EF83AB045E2C5BEB25251AC8C_2098387102 = (getDatabaseName()!=null);
            retval.append(getDatabaseName());
        } //End collapsed parenthetic
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_636472982 = (!parameters.isEmpty());
            retval.append(SEMICOLON + this.parameters.encode());
        } //End collapsed parenthetic
        retval.append(">");
        varB4EAC82CA7396A68D541C85D26508E83_339304121 = retval.toString();
        varB4EAC82CA7396A68D541C85D26508E83_339304121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_339304121;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.569 -0400", hash_original_method = "E720B3A09C72EF9AD917691C9271EB0A", hash_generated_method = "EDEF580F661B557CB85F0DC97C562B0B")
    public boolean equals(Object other) {
        boolean varB67670436F072ACD0F3C6E986BAF90AF_526112995 = ((other instanceof PUserDatabaseHeader) && super.equals(other));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824156747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_824156747;
        // ---------- Original Method ----------
        //return (other instanceof PUserDatabaseHeader) && super.equals(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.570 -0400", hash_original_method = "0C530D20B34B6FA1A3EDDB9B09D02FD1", hash_generated_method = "A3B59E9F330A05E43C19C7964156F1FE")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_282986133 = null; //Variable for return #1
        PUserDatabase retval;
        retval = (PUserDatabase) super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_282986133 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_282986133.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_282986133;
        // ---------- Original Method ----------
        //PUserDatabase retval = (PUserDatabase) super.clone();
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.570 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
}

