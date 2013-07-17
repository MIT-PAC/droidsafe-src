package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.address.*;
import javax.sip.address.*;

public final class AlertInfo extends ParametersHeader implements javax.sip.header.AlertInfoHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.712 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "D17BDF81091C1074F22AD5D363A1EFEF")

    protected GenericURI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.712 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "0515D9B755A4065CCD98BBCCA2A45812")

    protected String string;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.713 -0400", hash_original_method = "573DE3A32F61321788993C5785A09259", hash_generated_method = "427D589A7E774F7BCAE83A7C7B6EDB4C")
    public  AlertInfo() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.713 -0400", hash_original_method = "9B65437FA923D12CE9D4363AF11C8369", hash_generated_method = "964D3CFBB14A51A256CA38BCD0306F2B")
    protected String encodeBody() {
        StringBuffer encoding = new StringBuffer();
        if(uri != null)        
        {
            encoding.append(LESS_THAN).append(uri.encode()).append(GREATER_THAN);
        } //End block
        else
        if(string != null)        
        {
            encoding.append(string);
        } //End block
        if(!parameters.isEmpty())        
        {
            encoding.append(SEMICOLON).append(parameters.encode());
        } //End block
String varD48A745DC29A29C7851286E6A426D0D0_1153303745 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_1153303745.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_1153303745;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.714 -0400", hash_original_method = "9100B3E97C317A9574634DF51E7BF148", hash_generated_method = "2A7E426316EE15F7DFB236079F127014")
    public void setAlertInfo(URI uri) {
        this.uri = (GenericURI) uri;
        // ---------- Original Method ----------
        //this.uri = (GenericURI) uri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.715 -0400", hash_original_method = "70582DF127DE5708E4C226DA4F1719D4", hash_generated_method = "5CC62B65558F5189ED3430FEE8A6DEC0")
    public void setAlertInfo(String string) {
        this.string = string;
        // ---------- Original Method ----------
        //this.string = string;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.716 -0400", hash_original_method = "93EE3BCFF83F692256BB0B6CBD3B0531", hash_generated_method = "21C03C8411CECB8A327BF672CAB7F790")
    public URI getAlertInfo() {
        URI alertInfoUri = null;
        if(this.uri != null)        
        {
            alertInfoUri = (URI) this.uri;
        } //End block
        else
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
URI var33576398091C0FA65107B0049538C483_70714285 =         alertInfoUri;
        var33576398091C0FA65107B0049538C483_70714285.addTaint(taint);
        return var33576398091C0FA65107B0049538C483_70714285;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.717 -0400", hash_original_method = "1467211F1910FD2BE16563F269CB9AF0", hash_generated_method = "724134BBB3192D37BB1917E582C86E25")
    public Object clone() {
        AlertInfo retval = (AlertInfo) super.clone();
        if(this.uri != null)        
        {
            retval.uri = (GenericURI) this.uri.clone();
        } //End block
        else
        if(this.string != null)        
        {
            retval.string = this.string;
        } //End block
Object varF9E19AD6135C970F387F77C6F3DE4477_172916852 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_172916852.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_172916852;
        // ---------- Original Method ----------
        //AlertInfo retval = (AlertInfo) super.clone();
        //if (this.uri != null) {
            //retval.uri = (GenericURI) this.uri.clone();
        //} else if (this.string != null) {
            //retval.string = this.string;
        //}
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.718 -0400", hash_original_field = "F96C8A2DF33D2FE930751822FDAE4BDB", hash_generated_field = "837DE0F76A5BA789D54E73518AECF665")

    private static final long serialVersionUID = 4159657362051508719L;
}

