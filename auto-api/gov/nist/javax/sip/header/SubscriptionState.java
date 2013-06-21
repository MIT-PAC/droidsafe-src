package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;
import javax.sip.header.SubscriptionStateHeader;
import java.text.ParseException;

public class SubscriptionState extends ParametersHeader implements SubscriptionStateHeader {
    protected int expires;
    protected int retryAfter;
    protected String reasonCode;
    protected String state;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.423 -0400", hash_original_method = "2AE8767260EE49A022E5D260FFA8A02D", hash_generated_method = "F9D33CC11D1A46D0CF22E4B318D53B6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SubscriptionState() {
        super(SIPHeaderNames.SUBSCRIPTION_STATE);
        expires = -1;
        retryAfter = -1;
        // ---------- Original Method ----------
        //expires = -1;
        //retryAfter = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.424 -0400", hash_original_method = "7314EC394325F26B79C36E58D3FDBB1D", hash_generated_method = "1CA96198D6F8596E53CEAEABD1D9087B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExpires(int expires) throws InvalidArgumentException {
        dsTaint.addTaint(expires);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setExpires(), the expires parameter is  < 0");
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SubscriptionState, setExpires(), the expires parameter is  < 0");
        //this.expires = expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.424 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "60423F18F704DCC829EC803D3BFEF274")
    @DSModeled(DSC.SAFE)
    public int getExpires() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.424 -0400", hash_original_method = "50CA09FDB5676EA1DD99646C83E4C5FC", hash_generated_method = "AC8B9E109326FC5A289916125AC6FE21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRetryAfter(int retryAfter) throws InvalidArgumentException {
        dsTaint.addTaint(retryAfter);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setRetryAfter(), the retryAfter parameter is <=0");
        // ---------- Original Method ----------
        //if (retryAfter <= 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SubscriptionState, setRetryAfter(), the retryAfter parameter is <=0");
        //this.retryAfter = retryAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.424 -0400", hash_original_method = "8B40198517FC200CD43F6E0235CB55DB", hash_generated_method = "4FA8BE9C65C077363A6AB5BF8544E62B")
    @DSModeled(DSC.SAFE)
    public int getRetryAfter() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return retryAfter;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.424 -0400", hash_original_method = "307A7F7469164C10B67FE98D6B3BB448", hash_generated_method = "4434BF3150585A6F5B4DD6275F13D2EA")
    @DSModeled(DSC.SAFE)
    public String getReasonCode() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return reasonCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.424 -0400", hash_original_method = "F3FEA6AFF4A02AB2AF0C89DB66C639D9", hash_generated_method = "F94546160B330DFF4D3A5F0A616D1E72")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReasonCode(String reasonCode) throws ParseException {
        dsTaint.addTaint(reasonCode);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setReasonCode(), the reasonCode parameter is null");
        // ---------- Original Method ----------
        //if (reasonCode == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SubscriptionState, setReasonCode(), the reasonCode parameter is null");
        //this.reasonCode = reasonCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.424 -0400", hash_original_method = "B507B0FDA436CA05802CD34EFC971C76", hash_generated_method = "BDD41BA03ACD74F67BF88F4AFD81A8D1")
    @DSModeled(DSC.SAFE)
    public String getState() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.425 -0400", hash_original_method = "26B14BBE6685B3C70475DE487DDF5C68", hash_generated_method = "BB20CBAC83F741C719F251B0D23BAB0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setState(String state) throws ParseException {
        dsTaint.addTaint(state);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setState(), the state parameter is null");
        // ---------- Original Method ----------
        //if (state == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SubscriptionState, setState(), the state parameter is null");
        //this.state = state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.425 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "AC65E0191E3D114A9568CA9F509219F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_87236558 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.425 -0400", hash_original_method = "612E9F6C82A7EBFF3AE59409AADEC810", hash_generated_method = "180FDD6B7C33F34F8D329DC781C8A8A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append(state);
        buffer.append(";reason=").append(reasonCode);
        buffer.append(";expires=").append(expires);
        buffer.append(";retry-after=").append(retryAfter);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_536606206 = (!parameters.isEmpty());
            {
                buffer.append(SEMICOLON);
                parameters.encode(buffer);
            } //End block
        } //End collapsed parenthetic
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (state != null)
            //buffer.append(state);
        //if (reasonCode != null)
            //buffer.append(";reason=").append(reasonCode);
        //if (expires != -1)
            //buffer.append(";expires=").append(expires);
        //if (retryAfter != -1)
            //buffer.append(";retry-after=").append(retryAfter);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    private static final long serialVersionUID = -6673833053927258745L;
}

