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
    protected GenericURI info;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.852 -0400", hash_original_method = "E32B7E5F9D4A1980425339805E4FFC9A", hash_generated_method = "37A5CF038F326ECEA85878995B55B295")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallInfo() {
        super(CALL_INFO);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.853 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "3AB6EAA91C1EECE17A02D4EBDF5F4F74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_1414454612 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.855 -0400", hash_original_method = "A4CCBF948684EE8C510DCE8D73383A9B", hash_generated_method = "29F68E345558472A7ED2CC8E8ED3AE45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append(LESS_THAN);
        info.encode(buffer);
        buffer.append(GREATER_THAN);
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_371578991 = (parameters != null && !parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.856 -0400", hash_original_method = "5AE253F427E5A28ACB58F8121152C53D", hash_generated_method = "591ED92DD3142609596512D5CCBD4E06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getPurpose() {
        String var7A8A755569852D5383CDF58082FE03D5_985815361 = (this.getParameter("purpose"));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return this.getParameter("purpose");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.856 -0400", hash_original_method = "EF1B9495763809E09B57BAE8A2B95EE3", hash_generated_method = "5045C97F3021EACA17F671F408E40F53")
    @DSModeled(DSC.SAFE)
    public javax.sip.address.URI getInfo() {
        return (javax.sip.address.URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.856 -0400", hash_original_method = "02434F47BE675094B3D64F5516EB6DB6", hash_generated_method = "F79244B792EB7405697D8CD6292C7451")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPurpose(String purpose) {
        dsTaint.addTaint(purpose);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null arg");
        try 
        {
            this.setParameter("purpose", purpose);
        } //End block
        catch (ParseException ex)
        { }
        // ---------- Original Method ----------
        //if (purpose == null)
            //throw new NullPointerException("null arg");
        //try {
            //this.setParameter("purpose", purpose);
        //} catch (ParseException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.857 -0400", hash_original_method = "5AA5786EA20C5BC42796F42D6FB1BBD6", hash_generated_method = "89A8DD50C0FDE9ED062D1933E9C59A69")
    @DSModeled(DSC.SAFE)
    public void setInfo(javax.sip.address.URI info) {
        dsTaint.addTaint(info.dsTaint);
        this.info = (GenericURI) info;
        // ---------- Original Method ----------
        //this.info = (GenericURI) info;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.857 -0400", hash_original_method = "13BFA074DC19025B66849B6C15AC7B30", hash_generated_method = "2C4C72117A5F824F2A554E9344C9F8AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        CallInfo retval;
        retval = (CallInfo) super.clone();
        retval.info = (GenericURI) this.info.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //CallInfo retval = (CallInfo) super.clone();
        //if (this.info != null)
            //retval.info = (GenericURI) this.info.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = -8179246487696752928L;
}

