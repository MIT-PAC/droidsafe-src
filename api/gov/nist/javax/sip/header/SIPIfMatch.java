package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;
import java.text.ParseException;

public class SIPIfMatch extends SIPHeader implements SIPIfMatchHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.324 -0400", hash_original_field = "BF2C63393DC4B17F2F6428EBE8608DDC", hash_generated_field = "885FC2B59F698305A2C8A7BD5CC3FE18")

    protected String entityTag;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.325 -0400", hash_original_method = "BAD2DC814CD45D5939615C62F83835FA", hash_generated_method = "BC1325341205D047D33E2F234910D97F")
    public  SIPIfMatch() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.325 -0400", hash_original_method = "3D0893288CE2D1B79B07387D603E62DB", hash_generated_method = "01CDA246878419CA1D7404FB25E3602E")
    public  SIPIfMatch(String etag) throws ParseException {
        this();
        addTaint(etag.getTaint());
        this.setETag( etag );
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.326 -0400", hash_original_method = "D71FCA65B3027CF0021F4CC3EAA91DA7", hash_generated_method = "505D6A6746DE21806DF2360A1F541FD5")
    public String encodeBody() {
String var6F841ECF197400A993B46628101FE372_2031055004 =         entityTag;
        var6F841ECF197400A993B46628101FE372_2031055004.addTaint(taint);
        return var6F841ECF197400A993B46628101FE372_2031055004;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.326 -0400", hash_original_method = "3D6890113704CA3A689BE5D16088DA64", hash_generated_method = "25B9B4C3D045DDDECE7452029F969023")
    public String getETag() {
String var6F841ECF197400A993B46628101FE372_915738000 =         entityTag;
        var6F841ECF197400A993B46628101FE372_915738000.addTaint(taint);
        return var6F841ECF197400A993B46628101FE372_915738000;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.327 -0400", hash_original_method = "FF09F62ACDB51364A1C119FC09E0694A", hash_generated_method = "4A50D59B9324C0E13D0E7D5237AF8333")
    public void setETag(String etag) throws ParseException {
    if(etag == null)        
        {
        NullPointerException var95ED79636C178D71A0ABF9AD39122FAE_161639167 = new NullPointerException(
                "JAIN-SIP Exception,"
                    + "SIP-If-Match, setETag(), the etag parameter is null");
        var95ED79636C178D71A0ABF9AD39122FAE_161639167.addTaint(taint);
        throw var95ED79636C178D71A0ABF9AD39122FAE_161639167;
        }
        this.entityTag = etag;
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.328 -0400", hash_original_method = "7CA3A2804F10C6CA29833F9AB88CD018", hash_generated_method = "A8A2B2114609A7D3128BB34B68EE199C")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        this.setETag(value);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.328 -0400", hash_original_field = "54B1BEC1DAECBE024DEB1918FCD60093", hash_generated_field = "F99AB9EB7E164B071039EF12AA230274")

    private static final long serialVersionUID = 3833745477828359730L;
}

