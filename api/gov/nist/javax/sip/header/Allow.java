package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public final class Allow extends SIPHeader implements javax.sip.header.AllowHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.735 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "7A7B3881B98B4FAF9D2BB4D0900875E7")

    protected String method;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.736 -0400", hash_original_method = "473413697039914FAE978B5460F14DD9", hash_generated_method = "4D31534EA8011D7FF178B53A73A728AA")
    public  Allow() {
        super(ALLOW);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.736 -0400", hash_original_method = "07DC0232E600446B62A81ACF6B5528CD", hash_generated_method = "8A73E6FD8CDE43ABC63EE34599FECCC8")
    public  Allow(String m) {
        super(ALLOW);
        method = m;
        // ---------- Original Method ----------
        //method = m;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.736 -0400", hash_original_method = "A65B682B0B822D8527FBE88A2FCA60FC", hash_generated_method = "36F74D61CC6A8E6B25845DC30FFE574B")
    public String getMethod() {
String var27E3C5B2D4A798771E5F53D6527EECD0_2107782951 =         method;
        var27E3C5B2D4A798771E5F53D6527EECD0_2107782951.addTaint(taint);
        return var27E3C5B2D4A798771E5F53D6527EECD0_2107782951;
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.737 -0400", hash_original_method = "78C1F544F0B2D71B62F1C06FF7335973", hash_generated_method = "859DE418AD3C1706A2C9171594A1C10E")
    public void setMethod(String method) throws ParseException {
    if(method == null)        
        {
        NullPointerException var2B425CF4608308F09E7B32D3135B3443_1838917454 = new NullPointerException(
                "JAIN-SIP Exception"
                    + ", Allow, setMethod(), the method parameter is null.");
        var2B425CF4608308F09E7B32D3135B3443_1838917454.addTaint(taint);
        throw var2B425CF4608308F09E7B32D3135B3443_1838917454;
        }
        this.method = method;
        // ---------- Original Method ----------
        //if (method == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception"
                    //+ ", Allow, setMethod(), the method parameter is null.");
        //this.method = method;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.738 -0400", hash_original_method = "48A673DBBFEBFCB1D74A4ACDDDC3C6AB", hash_generated_method = "F72FFAF9B6911605CD63BA10408842B2")
    protected String encodeBody() {
String var27E3C5B2D4A798771E5F53D6527EECD0_1466496406 =         method;
        var27E3C5B2D4A798771E5F53D6527EECD0_1466496406.addTaint(taint);
        return var27E3C5B2D4A798771E5F53D6527EECD0_1466496406;
        // ---------- Original Method ----------
        //return method;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.738 -0400", hash_original_field = "E2D8B8EAC99520FEE5D7EF6F1AA6DA96", hash_generated_field = "85C85A2237A84342C80D2A96596481BF")

    private static final long serialVersionUID = -3105079479020693930L;
}

