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
    protected GenericURI uri;
    protected String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.658 -0400", hash_original_method = "573DE3A32F61321788993C5785A09259", hash_generated_method = "427D589A7E774F7BCAE83A7C7B6EDB4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AlertInfo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.659 -0400", hash_original_method = "9B65437FA923D12CE9D4363AF11C8369", hash_generated_method = "6F1D4D26D89CDDEF4C1823A10AB292E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        StringBuffer encoding;
        encoding = new StringBuffer();
        {
            encoding.append(LESS_THAN).append(uri.encode()).append(GREATER_THAN);
        } //End block
        {
            encoding.append(string);
        } //End block
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_2012320005 = (!parameters.isEmpty());
            {
                encoding.append(SEMICOLON).append(parameters.encode());
            } //End block
        } //End collapsed parenthetic
        String varB81683B37658DAABB0D3F9E81B4869CA_496747788 = (encoding.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.659 -0400", hash_original_method = "9100B3E97C317A9574634DF51E7BF148", hash_generated_method = "209A783C61AB573347EBF2E4ED07B7A0")
    @DSModeled(DSC.SAFE)
    public void setAlertInfo(URI uri) {
        dsTaint.addTaint(uri.dsTaint);
        this.uri = (GenericURI) uri;
        // ---------- Original Method ----------
        //this.uri = (GenericURI) uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.659 -0400", hash_original_method = "70582DF127DE5708E4C226DA4F1719D4", hash_generated_method = "D1A5E9B1A466B45DD8FE25B4A420FE5A")
    @DSModeled(DSC.SAFE)
    public void setAlertInfo(String string) {
        dsTaint.addTaint(string);
        // ---------- Original Method ----------
        //this.string = string;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.659 -0400", hash_original_method = "93EE3BCFF83F692256BB0B6CBD3B0531", hash_generated_method = "A060DEFE445BA71DA5347F8416CE4FC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI getAlertInfo() {
        URI alertInfoUri;
        alertInfoUri = null;
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
        return (URI)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.659 -0400", hash_original_method = "1467211F1910FD2BE16563F269CB9AF0", hash_generated_method = "CB07D6657AEAFE50710D1AA30506B67B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        AlertInfo retval;
        retval = (AlertInfo) super.clone();
        {
            retval.uri = (GenericURI) this.uri.clone();
        } //End block
        {
            retval.string = this.string;
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AlertInfo retval = (AlertInfo) super.clone();
        //if (this.uri != null) {
            //retval.uri = (GenericURI) this.uri.clone();
        //} else if (this.string != null) {
            //retval.string = this.string;
        //}
        //return retval;
    }

    
    private static final long serialVersionUID = 4159657362051508719L;
}

