package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;
import java.text.ParseException;

public class SIPIfMatch extends SIPHeader implements SIPIfMatchHeader, ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.370 -0400", hash_original_field = "BF2C63393DC4B17F2F6428EBE8608DDC", hash_generated_field = "885FC2B59F698305A2C8A7BD5CC3FE18")

    protected String entityTag;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.370 -0400", hash_original_method = "BAD2DC814CD45D5939615C62F83835FA", hash_generated_method = "BC1325341205D047D33E2F234910D97F")
    public  SIPIfMatch() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.371 -0400", hash_original_method = "3D0893288CE2D1B79B07387D603E62DB", hash_generated_method = "01CDA246878419CA1D7404FB25E3602E")
    public  SIPIfMatch(String etag) throws ParseException {
        this();
        addTaint(etag.getTaint());
        this.setETag( etag );
        // ---------- Original Method ----------
        //this.setETag( etag );
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.372 -0400", hash_original_method = "D71FCA65B3027CF0021F4CC3EAA91DA7", hash_generated_method = "714810758B59DC9A5A5E62BA28DBCE3A")
    public String encodeBody() {
String var6F841ECF197400A993B46628101FE372_1721747217 =         entityTag;
        var6F841ECF197400A993B46628101FE372_1721747217.addTaint(taint);
        return var6F841ECF197400A993B46628101FE372_1721747217;
        // ---------- Original Method ----------
        //return entityTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.372 -0400", hash_original_method = "3D6890113704CA3A689BE5D16088DA64", hash_generated_method = "1899654C9C55B582EF45F5474362FDA4")
    public String getETag() {
String var6F841ECF197400A993B46628101FE372_530329336 =         entityTag;
        var6F841ECF197400A993B46628101FE372_530329336.addTaint(taint);
        return var6F841ECF197400A993B46628101FE372_530329336;
        // ---------- Original Method ----------
        //return entityTag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.373 -0400", hash_original_method = "FF09F62ACDB51364A1C119FC09E0694A", hash_generated_method = "C1C801E10D60F46DC5CF7A95F6C6BB6C")
    public void setETag(String etag) throws ParseException {
        if(etag == null)        
        {
        NullPointerException var95ED79636C178D71A0ABF9AD39122FAE_1157836772 = new NullPointerException(
                "JAIN-SIP Exception,"
                    + "SIP-If-Match, setETag(), the etag parameter is null");
        var95ED79636C178D71A0ABF9AD39122FAE_1157836772.addTaint(taint);
        throw var95ED79636C178D71A0ABF9AD39122FAE_1157836772;
        }
        this.entityTag = etag;
        // ---------- Original Method ----------
        //if (etag == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception,"
                    //+ "SIP-If-Match, setETag(), the etag parameter is null");
        //this.entityTag = etag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.374 -0400", hash_original_method = "7CA3A2804F10C6CA29833F9AB88CD018", hash_generated_method = "A8A2B2114609A7D3128BB34B68EE199C")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        this.setETag(value);
        // ---------- Original Method ----------
        //this.setETag(value);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.374 -0400", hash_original_field = "54B1BEC1DAECBE024DEB1918FCD60093", hash_generated_field = "F99AB9EB7E164B071039EF12AA230274")

    private static final long serialVersionUID = 3833745477828359730L;
}

