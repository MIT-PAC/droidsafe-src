package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;

public final class CallInfo extends ParametersHeader implements javax.sip.header.CallInfoHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.282 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "CFBF7E2410210225F23571A6DEE68EDE")

    protected GenericURI info;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.283 -0400", hash_original_method = "E32B7E5F9D4A1980425339805E4FFC9A", hash_generated_method = "37A5CF038F326ECEA85878995B55B295")
    public  CallInfo() {
        super(CALL_INFO);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.283 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "3D3FF878386BD46515873D7E627E324A")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1177739058 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1177739058 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1177739058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1177739058;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.284 -0400", hash_original_method = "A4CCBF948684EE8C510DCE8D73383A9B", hash_generated_method = "846A2AAA88F137D163D3C52265CD8D19")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1480298342 = null; //Variable for return #1
        buffer.append(LESS_THAN);
        info.encode(buffer);
        buffer.append(GREATER_THAN);
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_1161435889 = (parameters != null && !parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1480298342 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1480298342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1480298342;
        // ---------- Original Method ----------
        //buffer.append(LESS_THAN);
        //info.encode(buffer);
        //buffer.append(GREATER_THAN);
        //if (parameters != null && !parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.284 -0400", hash_original_method = "5AE253F427E5A28ACB58F8121152C53D", hash_generated_method = "3FE21F0BCC227C13462B1C87108D749A")
    public String getPurpose() {
        String varB4EAC82CA7396A68D541C85D26508E83_286961226 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_286961226 = this.getParameter("purpose");
        varB4EAC82CA7396A68D541C85D26508E83_286961226.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_286961226;
        // ---------- Original Method ----------
        //return this.getParameter("purpose");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.284 -0400", hash_original_method = "EF1B9495763809E09B57BAE8A2B95EE3", hash_generated_method = "F401F85D512B1666417DFD3AF88973B5")
    public javax.sip.address.URI getInfo() {
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_41003491 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_41003491 = info;
        varB4EAC82CA7396A68D541C85D26508E83_41003491.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_41003491;
        // ---------- Original Method ----------
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.285 -0400", hash_original_method = "02434F47BE675094B3D64F5516EB6DB6", hash_generated_method = "8EFE81A807F4E2B99D9C9DEFC118F62F")
    public void setPurpose(String purpose) {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        try 
        {
            this.setParameter("purpose", purpose);
        } //End block
        catch (ParseException ex)
        { }
        addTaint(purpose.getTaint());
        // ---------- Original Method ----------
        //if (purpose == null)
            //throw new NullPointerException("null arg");
        //try {
            //this.setParameter("purpose", purpose);
        //} catch (ParseException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.285 -0400", hash_original_method = "5AA5786EA20C5BC42796F42D6FB1BBD6", hash_generated_method = "529B104F54989C0661DF25CACCDA676F")
    public void setInfo(javax.sip.address.URI info) {
        this.info = (GenericURI) info;
        // ---------- Original Method ----------
        //this.info = (GenericURI) info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.286 -0400", hash_original_method = "13BFA074DC19025B66849B6C15AC7B30", hash_generated_method = "85B2A080ACE2B10681F54C9A9E3384F9")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_499110707 = null; //Variable for return #1
        CallInfo retval = (CallInfo) super.clone();
        retval.info = (GenericURI) this.info.clone();
        varB4EAC82CA7396A68D541C85D26508E83_499110707 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_499110707.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_499110707;
        // ---------- Original Method ----------
        //CallInfo retval = (CallInfo) super.clone();
        //if (this.info != null)
            //retval.info = (GenericURI) this.info.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.287 -0400", hash_original_field = "4494FB805A36EA869D54FB33F6FB1EA4", hash_generated_field = "2D62DF7E0A2A79C01356DE01B010437F")

    private static final long serialVersionUID = -8179246487696752928L;
}

