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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.079 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "64120D09C2B0721B310316A22E4103F4")

    public CallIdentifier callIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.079 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "B530B3F06EB2C57DA5D10CD3EC3286F9")

    public String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.080 -0400", hash_original_method = "87F4B3791A773FA2D819A20B11BB86DF", hash_generated_method = "23B37B63F5C24397936779F145AE090F")
    public  Join() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.080 -0400", hash_original_method = "873C342CB455582A93D9F186CC2FD1CC", hash_generated_method = "EC235DE55FAB4BA862DA3EC36BAA7583")
    public  Join(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        // ---------- Original Method ----------
        //this.callIdentifier = new CallIdentifier(callId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.081 -0400", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "1FB16AC1A1324F5169AF58035B4ABBAB")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1746346942 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2046191944 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1746346942 = null;
        {
            String retVal;
            retVal = callId;
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_1615833435 = (!parameters.isEmpty());
                {
                    retVal += SEMICOLON + parameters.encode();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_2046191944 = retVal;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1067318959; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1067318959 = varB4EAC82CA7396A68D541C85D26508E83_1746346942;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1067318959 = varB4EAC82CA7396A68D541C85D26508E83_2046191944;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1067318959.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1067318959;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.082 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "2150CB4D0A3B429D03E2D80667731C50")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1993445173 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1993445173 = callId;
        varB4EAC82CA7396A68D541C85D26508E83_1993445173.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1993445173;
        // ---------- Original Method ----------
        //return callId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.083 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "9F87F299A080D1F7552EF6CD93597394")
    public CallIdentifier getCallIdentifer() {
        CallIdentifier varB4EAC82CA7396A68D541C85D26508E83_240371706 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_240371706 = callIdentifier;
        varB4EAC82CA7396A68D541C85D26508E83_240371706.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_240371706;
        // ---------- Original Method ----------
        //return callIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.083 -0400", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "6992A879D69ED0B331E4999AE9EC11CE")
    public void setCallId(String cid) {
        callId = cid;
        // ---------- Original Method ----------
        //callId = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.083 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        // ---------- Original Method ----------
        //callIdentifier = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.084 -0400", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "1282BECE4D54F39D446F25D4432663DC")
    public String getToTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1611684274 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1828776894 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1611684274 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1828776894 = getParameter(ParameterNames.TO_TAG);
        String varA7E53CE21691AB073D9660D615818899_779545081; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_779545081 = varB4EAC82CA7396A68D541C85D26508E83_1611684274;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_779545081 = varB4EAC82CA7396A68D541C85D26508E83_1828776894;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_779545081.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_779545081;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.087 -0400", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "6BCD4296B13B9D120AEEFC376DFE3F87")
    public void setToTag(String t) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_2043221195 = (t.trim().equals(""));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad tag", 0);
        } //End collapsed parenthetic
        this.setParameter(ParameterNames.TO_TAG, t);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //if (t == null)
            //throw new NullPointerException("null tag ");
        //else if (t.trim().equals(""))
            //throw new ParseException("bad tag", 0);
        //this.setParameter(ParameterNames.TO_TAG, t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.088 -0400", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "D20E241E54305259846402D618ADA4C4")
    public boolean hasToTag() {
        boolean var98F1538999349B56334E8D4578BD3F6B_504269837 = (hasParameter(ParameterNames.TO_TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874151406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874151406;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.090 -0400", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "8F5C24D1B4E10E96F090DB388EB7CB97")
    public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.093 -0400", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "8130A01115A4575D922C9357AD50B8E1")
    public String getFromTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1770200118 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1565864269 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1770200118 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1565864269 = getParameter(ParameterNames.FROM_TAG);
        String varA7E53CE21691AB073D9660D615818899_379903715; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_379903715 = varB4EAC82CA7396A68D541C85D26508E83_1770200118;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_379903715 = varB4EAC82CA7396A68D541C85D26508E83_1565864269;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_379903715.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_379903715;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.093 -0400", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "67946E555C2C815D92AACB62B85B00DC")
    public void setFromTag(String t) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_848404002 = (t.trim().equals(""));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad tag", 0);
        } //End collapsed parenthetic
        this.setParameter(ParameterNames.FROM_TAG, t);
        addTaint(t.getTaint());
        // ---------- Original Method ----------
        //if (t == null)
            //throw new NullPointerException("null tag ");
        //else if (t.trim().equals(""))
            //throw new ParseException("bad tag", 0);
        //this.setParameter(ParameterNames.FROM_TAG, t);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.093 -0400", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "1EE21AA2EABD658EECAC1118767BD956")
    public boolean hasFromTag() {
        boolean var3E2433518F90E4E3614AF7C9562C82F0_2102399420 = (hasParameter(ParameterNames.FROM_TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1009448396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1009448396;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.094 -0400", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "B61172F24259436FBA34D6DD3E3FE321")
    public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.098 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.099 -0400", hash_original_field = "458D5CDFA53BA618A9930E93AC7CDE95", hash_generated_field = "2841A53191D7E6EA8A3FD2ABEE04AF9A")

    private static long serialVersionUID = -840116548918120056L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.099 -0400", hash_original_field = "BD7843C2FC1C4934D2D46FD2DD982DF8", hash_generated_field = "13095D8F107AFC77A4F003D089C600F0")

    public static final String NAME = "Join";
}

