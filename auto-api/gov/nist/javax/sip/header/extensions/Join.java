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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.883 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "64120D09C2B0721B310316A22E4103F4")

    public CallIdentifier callIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.883 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "B530B3F06EB2C57DA5D10CD3EC3286F9")

    public String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.884 -0400", hash_original_method = "87F4B3791A773FA2D819A20B11BB86DF", hash_generated_method = "23B37B63F5C24397936779F145AE090F")
    public  Join() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.884 -0400", hash_original_method = "873C342CB455582A93D9F186CC2FD1CC", hash_generated_method = "EC235DE55FAB4BA862DA3EC36BAA7583")
    public  Join(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        // ---------- Original Method ----------
        //this.callIdentifier = new CallIdentifier(callId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.885 -0400", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "6633FCA72839E28283B1CFC3B1FDE282")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1927961727 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1861673623 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1927961727 = null;
        {
            String retVal;
            retVal = callId;
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_339224564 = (!parameters.isEmpty());
                {
                    retVal += SEMICOLON + parameters.encode();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1861673623 = retVal;
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1483768751; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1483768751 = varB4EAC82CA7396A68D541C85D26508E83_1927961727;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1483768751 = varB4EAC82CA7396A68D541C85D26508E83_1861673623;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1483768751.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1483768751;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.885 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "AC7BE07C7213B812824EFA60B6E03523")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_690495367 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_690495367 = callId;
        varB4EAC82CA7396A68D541C85D26508E83_690495367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_690495367;
        // ---------- Original Method ----------
        //return callId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.891 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "0602B49755B9749DAEC4FABFEDDBF53E")
    public CallIdentifier getCallIdentifer() {
        CallIdentifier varB4EAC82CA7396A68D541C85D26508E83_1465983072 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1465983072 = callIdentifier;
        varB4EAC82CA7396A68D541C85D26508E83_1465983072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1465983072;
        // ---------- Original Method ----------
        //return callIdentifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.944 -0400", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "6992A879D69ED0B331E4999AE9EC11CE")
    public void setCallId(String cid) {
        callId = cid;
        // ---------- Original Method ----------
        //callId = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.945 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        // ---------- Original Method ----------
        //callIdentifier = cid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.946 -0400", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "60C450ABEEFEA12E96BEF704315ABC94")
    public String getToTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_268777323 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_495075970 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_268777323 = null;
        varB4EAC82CA7396A68D541C85D26508E83_495075970 = getParameter(ParameterNames.TO_TAG);
        String varA7E53CE21691AB073D9660D615818899_335479397; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_335479397 = varB4EAC82CA7396A68D541C85D26508E83_268777323;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_335479397 = varB4EAC82CA7396A68D541C85D26508E83_495075970;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_335479397.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_335479397;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.946 -0400", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "82B57695B78D6C10F0B81F757E5DA37B")
    public void setToTag(String t) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_1647747962 = (t.trim().equals(""));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.946 -0400", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "6D08467A9220B87DFD04CB834714BC08")
    public boolean hasToTag() {
        boolean var98F1538999349B56334E8D4578BD3F6B_1659659203 = (hasParameter(ParameterNames.TO_TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_182943852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_182943852;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.946 -0400", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "8F5C24D1B4E10E96F090DB388EB7CB97")
    public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.TO_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.950 -0400", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "A59BB092179F687C3C289F8E4917B81B")
    public String getFromTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1640291453 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1145055657 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1640291453 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1145055657 = getParameter(ParameterNames.FROM_TAG);
        String varA7E53CE21691AB073D9660D615818899_407714784; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_407714784 = varB4EAC82CA7396A68D541C85D26508E83_1640291453;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_407714784 = varB4EAC82CA7396A68D541C85D26508E83_1145055657;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_407714784.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_407714784;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.951 -0400", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "58BC87488EAB153F98B51666F6801DD5")
    public void setFromTag(String t) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_1560178689 = (t.trim().equals(""));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.951 -0400", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "CF8DCA006546F9C5D5C5018792813C40")
    public boolean hasFromTag() {
        boolean var3E2433518F90E4E3614AF7C9562C82F0_1627611164 = (hasParameter(ParameterNames.FROM_TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_857139847 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_857139847;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.951 -0400", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "B61172F24259436FBA34D6DD3E3FE321")
    public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.FROM_TAG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.951 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.951 -0400", hash_original_field = "458D5CDFA53BA618A9930E93AC7CDE95", hash_generated_field = "2841A53191D7E6EA8A3FD2ABEE04AF9A")

    private static long serialVersionUID = -840116548918120056L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.951 -0400", hash_original_field = "BD7843C2FC1C4934D2D46FD2DD982DF8", hash_generated_field = "13095D8F107AFC77A4F003D089C600F0")

    public static final String NAME = "Join";
}

