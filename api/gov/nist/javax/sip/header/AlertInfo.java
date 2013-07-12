package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.address.*;
import javax.sip.address.*;

public final class AlertInfo extends ParametersHeader implements javax.sip.header.AlertInfoHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.723 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "D17BDF81091C1074F22AD5D363A1EFEF")

    protected GenericURI uri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.723 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "0515D9B755A4065CCD98BBCCA2A45812")

    protected String string;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.723 -0400", hash_original_method = "573DE3A32F61321788993C5785A09259", hash_generated_method = "427D589A7E774F7BCAE83A7C7B6EDB4C")
    public  AlertInfo() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.723 -0400", hash_original_method = "9B65437FA923D12CE9D4363AF11C8369", hash_generated_method = "3E6B7E4CAAE58F12E3B7EA8C8B68069B")
    protected String encodeBody() {
        StringBuffer encoding = new StringBuffer();
    if(uri != null)        
        {
            encoding.append(LESS_THAN).append(uri.encode()).append(GREATER_THAN);
        } 
        else
    if(string != null)        
        {
            encoding.append(string);
        } 
    if(!parameters.isEmpty())        
        {
            encoding.append(SEMICOLON).append(parameters.encode());
        } 
String varD48A745DC29A29C7851286E6A426D0D0_860748660 =         encoding.toString();
        varD48A745DC29A29C7851286E6A426D0D0_860748660.addTaint(taint);
        return varD48A745DC29A29C7851286E6A426D0D0_860748660;
        
        
        
            
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.724 -0400", hash_original_method = "9100B3E97C317A9574634DF51E7BF148", hash_generated_method = "2A7E426316EE15F7DFB236079F127014")
    public void setAlertInfo(URI uri) {
        this.uri = (GenericURI) uri;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.724 -0400", hash_original_method = "70582DF127DE5708E4C226DA4F1719D4", hash_generated_method = "5CC62B65558F5189ED3430FEE8A6DEC0")
    public void setAlertInfo(String string) {
        this.string = string;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.725 -0400", hash_original_method = "93EE3BCFF83F692256BB0B6CBD3B0531", hash_generated_method = "3F8F6C66F2AA8D72E4FC1321B60FEC32")
    public URI getAlertInfo() {
        URI alertInfoUri = null;
    if(this.uri != null)        
        {
            alertInfoUri = (URI) this.uri;
        } 
        else
        {
            try 
            {
                alertInfoUri = (URI) new GenericURI(string);
            } 
            catch (ParseException e)
            {
                ;
            } 
        } 
URI var33576398091C0FA65107B0049538C483_277266667 =         alertInfoUri;
        var33576398091C0FA65107B0049538C483_277266667.addTaint(taint);
        return var33576398091C0FA65107B0049538C483_277266667;
        
        
        
            
        
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.726 -0400", hash_original_method = "1467211F1910FD2BE16563F269CB9AF0", hash_generated_method = "7C1D92E55087ADB7B03BF656DBB0097D")
    public Object clone() {
        AlertInfo retval = (AlertInfo) super.clone();
    if(this.uri != null)        
        {
            retval.uri = (GenericURI) this.uri.clone();
        } 
        else
    if(this.string != null)        
        {
            retval.string = this.string;
        } 
Object varF9E19AD6135C970F387F77C6F3DE4477_1352488207 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1352488207.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1352488207;
        
        
        
            
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.726 -0400", hash_original_field = "F96C8A2DF33D2FE930751822FDAE4BDB", hash_generated_field = "837DE0F76A5BA789D54E73518AECF665")

    private static final long serialVersionUID = 4159657362051508719L;
}

