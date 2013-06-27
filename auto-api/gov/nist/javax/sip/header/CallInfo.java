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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.638 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "CFBF7E2410210225F23571A6DEE68EDE")

    protected GenericURI info;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.638 -0400", hash_original_method = "E32B7E5F9D4A1980425339805E4FFC9A", hash_generated_method = "37A5CF038F326ECEA85878995B55B295")
    public  CallInfo() {
        super(CALL_INFO);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.639 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "30A287BE33215D5BE05AD86B4B5D600A")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1257203226 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1257203226 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1257203226.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1257203226;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.639 -0400", hash_original_method = "A4CCBF948684EE8C510DCE8D73383A9B", hash_generated_method = "6831ADDF19139C0D700C426B9CBF64FE")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_215815104 = null; //Variable for return #1
        buffer.append(LESS_THAN);
        info.encode(buffer);
        buffer.append(GREATER_THAN);
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_1889587041 = (parameters != null && !parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_215815104 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_215815104.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_215815104;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.640 -0400", hash_original_method = "5AE253F427E5A28ACB58F8121152C53D", hash_generated_method = "D936AE4EDDB483D8D228A98D57FBCF5F")
    public String getPurpose() {
        String varB4EAC82CA7396A68D541C85D26508E83_618210583 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_618210583 = this.getParameter("purpose");
        varB4EAC82CA7396A68D541C85D26508E83_618210583.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_618210583;
        // ---------- Original Method ----------
        //return this.getParameter("purpose");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.640 -0400", hash_original_method = "EF1B9495763809E09B57BAE8A2B95EE3", hash_generated_method = "72C13CC0672412E04F5BF650C545C2FF")
    public javax.sip.address.URI getInfo() {
        javax.sip.address.URI varB4EAC82CA7396A68D541C85D26508E83_603460275 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_603460275 = info;
        varB4EAC82CA7396A68D541C85D26508E83_603460275.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_603460275;
        // ---------- Original Method ----------
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.640 -0400", hash_original_method = "02434F47BE675094B3D64F5516EB6DB6", hash_generated_method = "8EFE81A807F4E2B99D9C9DEFC118F62F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.641 -0400", hash_original_method = "5AA5786EA20C5BC42796F42D6FB1BBD6", hash_generated_method = "529B104F54989C0661DF25CACCDA676F")
    public void setInfo(javax.sip.address.URI info) {
        this.info = (GenericURI) info;
        // ---------- Original Method ----------
        //this.info = (GenericURI) info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.642 -0400", hash_original_method = "13BFA074DC19025B66849B6C15AC7B30", hash_generated_method = "FF328A0B3C2D13441D238DBAEC589342")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1249758145 = null; //Variable for return #1
        CallInfo retval;
        retval = (CallInfo) super.clone();
        retval.info = (GenericURI) this.info.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1249758145 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1249758145.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1249758145;
        // ---------- Original Method ----------
        //CallInfo retval = (CallInfo) super.clone();
        //if (this.info != null)
            //retval.info = (GenericURI) this.info.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.642 -0400", hash_original_field = "4494FB805A36EA869D54FB33F6FB1EA4", hash_generated_field = "76F026440B71DA11B08013227CFAC076")

    private static long serialVersionUID = -8179246487696752928L;
}

