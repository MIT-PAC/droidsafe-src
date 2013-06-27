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

public class Replaces extends ParametersHeader implements ExtensionHeader, ReplacesHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.168 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "64120D09C2B0721B310316A22E4103F4")

    public CallIdentifier callIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.168 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "B530B3F06EB2C57DA5D10CD3EC3286F9")

    public String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.174 -0400", hash_original_method = "573D7C3C26F3FDBFC64B6AAA9C0FB261", hash_generated_method = "E109DF2046FCB28298FD5EAEEDF43CFC")
    public  Replaces() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.174 -0400", hash_original_method = "FC3FC3684A022FA26474BF29AC78B1CA", hash_generated_method = "9D6712590EF6EE91F7F5D49A3617C968")
    public  Replaces(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        // ---------- Original Method ----------
        //this.callIdentifier = new CallIdentifier(callId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.175 -0400", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "FEE8A5C709DA50A44B2A00FD1A68F3FD")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_875327822 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1604477942 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_875327822 = null;
        {
            String retVal;
            retVal = callId;
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_2059435236 = (!parameters.isEmpty());
                {
                    retVal += SEMICOLON + parameters.encode();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1604477942 = retVal;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1519745526; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1519745526 = varB4EAC82CA7396A68D541C85D26508E83_875327822;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1519745526 = varB4EAC82CA7396A68D541C85D26508E83_1604477942;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1519745526.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1519745526;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.175 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "B1BDA2AAB0507294959C5C7EFBE6C284")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1349448504 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1349448504 = callId;
        varB4EAC82CA7396A68D541C85D26508E83_1349448504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1349448504;
        // ---------- Original Method ----------
        //return callId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.176 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "64E5CC5657A01537DAC76F2EB773E9B4")
    public CallIdentifier getCallIdentifer() {
        CallIdentifier varB4EAC82CA7396A68D541C85D26508E83_36677555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_36677555 = callIdentifier;
        varB4EAC82CA7396A68D541C85D26508E83_36677555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_36677555;
        // ---------- Original Method ----------
        //return callIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.177 -0400", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "6992A879D69ED0B331E4999AE9EC11CE")
    public void setCallId(String cid) {
        callId = cid;
        // ---------- Original Method ----------
        //callId = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.189 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        // ---------- Original Method ----------
        //callIdentifier = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.189 -0400", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "7A2E2939034EBB9FF3145CB2F8FF95F4")
    public String getToTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_992818304 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1259939755 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_992818304 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1259939755 = getParameter(ParameterNames.TO_TAG);
        String varA7E53CE21691AB073D9660D615818899_885539293; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_885539293 = varB4EAC82CA7396A68D541C85D26508E83_992818304;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_885539293 = varB4EAC82CA7396A68D541C85D26508E83_1259939755;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_885539293.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_885539293;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.190 -0400", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "B5F61633A2A405FD69AA6A54DA5B17F7")
    public void setToTag(String t) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_1434386777 = (t.trim().equals(""));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.196 -0400", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "84CC91225EB608F6C2DE82469EF0096D")
    public boolean hasToTag() {
        boolean var98F1538999349B56334E8D4578BD3F6B_2104568693 = (hasParameter(ParameterNames.TO_TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1391287208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1391287208;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.196 -0400", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "8F5C24D1B4E10E96F090DB388EB7CB97")
    public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.197 -0400", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "5AD18559FDC9DDE662BC48288B94D8CF")
    public String getFromTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1749967820 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1901881035 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1749967820 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1901881035 = getParameter(ParameterNames.FROM_TAG);
        String varA7E53CE21691AB073D9660D615818899_593192353; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_593192353 = varB4EAC82CA7396A68D541C85D26508E83_1749967820;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_593192353 = varB4EAC82CA7396A68D541C85D26508E83_1901881035;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_593192353.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_593192353;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.197 -0400", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "D74CEE7722DD60CE9D20193EABB86AB1")
    public void setFromTag(String t) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_1894585462 = (t.trim().equals(""));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.198 -0400", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "76F0D1ADBAFD47545C5BA07478E6590A")
    public boolean hasFromTag() {
        boolean var3E2433518F90E4E3614AF7C9562C82F0_890294721 = (hasParameter(ParameterNames.FROM_TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_946542235 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_946542235;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.199 -0400", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "B61172F24259436FBA34D6DD3E3FE321")
    public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.199 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.199 -0400", hash_original_field = "1A90250BEA22A34094D11017692E5A52", hash_generated_field = "D44CFA417B8F36755294FBE5E8DD73BD")

    private static long serialVersionUID = 8765762413224043300L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.199 -0400", hash_original_field = "4403168D63862D2494FF603BBD9AC891", hash_generated_field = "6C314597CB78321B5F749A310B2C1B23")

    public static final String NAME = "Replaces";
}

