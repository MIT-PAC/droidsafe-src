package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.address.*;
import javax.sip.address.*;

public final class AlertInfo extends ParametersHeader implements javax.sip.header.AlertInfoHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.868 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "D17BDF81091C1074F22AD5D363A1EFEF")

    protected GenericURI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.868 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "0515D9B755A4065CCD98BBCCA2A45812")

    protected String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.869 -0400", hash_original_method = "573DE3A32F61321788993C5785A09259", hash_generated_method = "427D589A7E774F7BCAE83A7C7B6EDB4C")
    public  AlertInfo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.869 -0400", hash_original_method = "9B65437FA923D12CE9D4363AF11C8369", hash_generated_method = "ADD9BC51ACDB45748D2DD389F8B5CE68")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1441812570 = null; //Variable for return #1
        StringBuffer encoding = new StringBuffer();
        {
            encoding.append(LESS_THAN).append(uri.encode()).append(GREATER_THAN);
        } //End block
        {
            encoding.append(string);
        } //End block
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_354179512 = (!parameters.isEmpty());
            {
                encoding.append(SEMICOLON).append(parameters.encode());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1441812570 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1441812570.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1441812570;
        // ---------- Original Method ----------
        //StringBuffer encoding = new StringBuffer();
        //if (uri != null) {
            //encoding.append(LESS_THAN).append(uri.encode()).append(GREATER_THAN);
        //} else if (string != null) {
            //encoding.append(string);
        //}
        //if (!parameters.isEmpty()) {
            //encoding.append(SEMICOLON).append(parameters.encode());
        //}
        //return encoding.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.870 -0400", hash_original_method = "9100B3E97C317A9574634DF51E7BF148", hash_generated_method = "2A7E426316EE15F7DFB236079F127014")
    public void setAlertInfo(URI uri) {
        this.uri = (GenericURI) uri;
        // ---------- Original Method ----------
        //this.uri = (GenericURI) uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.870 -0400", hash_original_method = "70582DF127DE5708E4C226DA4F1719D4", hash_generated_method = "5CC62B65558F5189ED3430FEE8A6DEC0")
    public void setAlertInfo(String string) {
        this.string = string;
        // ---------- Original Method ----------
        //this.string = string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.871 -0400", hash_original_method = "93EE3BCFF83F692256BB0B6CBD3B0531", hash_generated_method = "750E323DA310DBAA3194417EDBA00CF2")
    public URI getAlertInfo() {
        URI varB4EAC82CA7396A68D541C85D26508E83_825876809 = null; //Variable for return #1
        URI alertInfoUri = null;
        {
            alertInfoUri = (URI) this.uri;
        } //End block
        {
            try 
            {
                alertInfoUri = (URI) new GenericURI(string);
            } //End block
            catch (ParseException e)
            {
                ;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_825876809 = alertInfoUri;
        varB4EAC82CA7396A68D541C85D26508E83_825876809.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_825876809;
        // ---------- Original Method ----------
        //URI alertInfoUri = null;
        //if (this.uri != null) {
            //alertInfoUri = (URI) this.uri;
        //} else {
            //try {
                //alertInfoUri = (URI) new GenericURI(string);
            //} catch (ParseException e) {
                //;  
            //}
        //}
        //return alertInfoUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.872 -0400", hash_original_method = "1467211F1910FD2BE16563F269CB9AF0", hash_generated_method = "F71F3BE8989ECCE86BF2C379C28E6ACE")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_175923626 = null; //Variable for return #1
        AlertInfo retval = (AlertInfo) super.clone();
        {
            retval.uri = (GenericURI) this.uri.clone();
        } //End block
        {
            retval.string = this.string;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_175923626 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_175923626.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_175923626;
        // ---------- Original Method ----------
        //AlertInfo retval = (AlertInfo) super.clone();
        //if (this.uri != null) {
            //retval.uri = (GenericURI) this.uri.clone();
        //} else if (this.string != null) {
            //retval.string = this.string;
        //}
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.872 -0400", hash_original_field = "F96C8A2DF33D2FE930751822FDAE4BDB", hash_generated_field = "837DE0F76A5BA789D54E73518AECF665")

    private static final long serialVersionUID = 4159657362051508719L;
}

