package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import javax.sip.header.ExtensionHeader;

public class Join extends ParametersHeader implements ExtensionHeader, JoinHeader {
    public CallIdentifier callIdentifier;
    public String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.497 -0400", hash_original_method = "87F4B3791A773FA2D819A20B11BB86DF", hash_generated_method = "23B37B63F5C24397936779F145AE090F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Join() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.497 -0400", hash_original_method = "873C342CB455582A93D9F186CC2FD1CC", hash_generated_method = "8285ADA1CA6D1F72B33DD7561C30A142")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Join(String callId) throws IllegalArgumentException {
        super(NAME);
        dsTaint.addTaint(callId);
        this.callIdentifier = new CallIdentifier(callId);
        // ---------- Original Method ----------
        //this.callIdentifier = new CallIdentifier(callId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.498 -0400", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "D852323AF0CBFC6B717BFA087258EA8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        {
            String retVal;
            retVal = callId;
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_1588278611 = (!parameters.isEmpty());
                {
                    retVal += SEMICOLON + parameters.encode();
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (callId == null)
            //return null;
        //else {
            //String retVal = callId;
            //if (!parameters.isEmpty()) {
                //retVal += SEMICOLON + parameters.encode();
            //}
            //return retVal;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.499 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "A4C78CA17EF88B23534EF15A5A75B5C8")
    @DSModeled(DSC.SAFE)
    public String getCallId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return callId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.499 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "FED86B4D25B97C95F0A42DFA2DD811D8")
    @DSModeled(DSC.SAFE)
    public CallIdentifier getCallIdentifer() {
        return (CallIdentifier)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return callIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.500 -0400", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "243D4AE095F3179D04FFE963A6FC8AA7")
    @DSModeled(DSC.SAFE)
    public void setCallId(String cid) {
        dsTaint.addTaint(cid);
        // ---------- Original Method ----------
        //callId = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.500 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "6DC6E44B1B5E338C185D18F65474D66E")
    @DSModeled(DSC.SAFE)
    public void setCallIdentifier(CallIdentifier cid) {
        dsTaint.addTaint(cid.dsTaint);
        // ---------- Original Method ----------
        //callIdentifier = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.501 -0400", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "C18FF89994ED5AA719CE30D39FDA26BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getToTag() {
        String var07D15D2F834DC517281B4C7A84563009_440233460 = (getParameter(ParameterNames.TO_TAG));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.501 -0400", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "009421560DDAD31C753BB3A112614A42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setToTag(String t) throws ParseException {
        dsTaint.addTaint(t);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_1904994630 = (t.trim().equals(""));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad tag", 0);
        } //End collapsed parenthetic
        this.setParameter(ParameterNames.TO_TAG, t);
        // ---------- Original Method ----------
        //if (t == null)
            //throw new NullPointerException("null tag ");
        //else if (t.trim().equals(""))
            //throw new ParseException("bad tag", 0);
        //this.setParameter(ParameterNames.TO_TAG, t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.501 -0400", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "FB7F00F4980367AEF6CFC3C762E81AED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasToTag() {
        boolean var98F1538999349B56334E8D4578BD3F6B_839432437 = (hasParameter(ParameterNames.TO_TAG));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.501 -0400", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "8F5C24D1B4E10E96F090DB388EB7CB97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.501 -0400", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "72B06FA59C18C84357E604EE28B1F770")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getFromTag() {
        String varA70E1911382AE317B7319C6E08A8EDD9_208894615 = (getParameter(ParameterNames.FROM_TAG));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.502 -0400", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "600C8D4616E07D7B31847CCBE1A58A58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFromTag(String t) throws ParseException {
        dsTaint.addTaint(t);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_570096939 = (t.trim().equals(""));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad tag", 0);
        } //End collapsed parenthetic
        this.setParameter(ParameterNames.FROM_TAG, t);
        // ---------- Original Method ----------
        //if (t == null)
            //throw new NullPointerException("null tag ");
        //else if (t.trim().equals(""))
            //throw new ParseException("bad tag", 0);
        //this.setParameter(ParameterNames.FROM_TAG, t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.502 -0400", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "71A3E3A003C0EA49350069DCA6D36605")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasFromTag() {
        boolean var3E2433518F90E4E3614AF7C9562C82F0_1923166049 = (hasParameter(ParameterNames.FROM_TAG));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.502 -0400", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "B61172F24259436FBA34D6DD3E3FE321")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.502 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    private static final long serialVersionUID = -840116548918120056L;
    public static final String NAME = "Join";
}

