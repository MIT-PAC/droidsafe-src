package gov.nist.javax.sip.header.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import javax.sip.header.ExtensionHeader;

public class Join extends ParametersHeader implements ExtensionHeader, JoinHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.002 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "64120D09C2B0721B310316A22E4103F4")

    public CallIdentifier callIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.002 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "B530B3F06EB2C57DA5D10CD3EC3286F9")

    public String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.003 -0400", hash_original_method = "87F4B3791A773FA2D819A20B11BB86DF", hash_generated_method = "23B37B63F5C24397936779F145AE090F")
    public  Join() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.003 -0400", hash_original_method = "873C342CB455582A93D9F186CC2FD1CC", hash_generated_method = "EC235DE55FAB4BA862DA3EC36BAA7583")
    public  Join(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.004 -0400", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "E7B1E3CFF2EB6BF7FFE1FA8937533E53")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1707755602 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1942246730 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1707755602 = null;
        {
            String retVal = callId;
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_911522222 = (!parameters.isEmpty());
                {
                    retVal += SEMICOLON + parameters.encode();
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1942246730 = retVal;
        } 
        String varA7E53CE21691AB073D9660D615818899_2019561638; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2019561638 = varB4EAC82CA7396A68D541C85D26508E83_1707755602;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2019561638 = varB4EAC82CA7396A68D541C85D26508E83_1942246730;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2019561638.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2019561638;
        
        
            
        
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.005 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "5C5092CE414EAA1B23E74DA362D5EB48")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_447799118 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_447799118 = callId;
        varB4EAC82CA7396A68D541C85D26508E83_447799118.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_447799118;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.005 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "368DBD28BA71FA13152B5B68AFFECD14")
    public CallIdentifier getCallIdentifer() {
        CallIdentifier varB4EAC82CA7396A68D541C85D26508E83_56064719 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_56064719 = callIdentifier;
        varB4EAC82CA7396A68D541C85D26508E83_56064719.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_56064719;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.006 -0400", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "6992A879D69ED0B331E4999AE9EC11CE")
    public void setCallId(String cid) {
        callId = cid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.006 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.007 -0400", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "74CDBD7E4A67C909668942E5DF1F8D95")
    public String getToTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_588929834 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_854669294 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_588929834 = null;
        varB4EAC82CA7396A68D541C85D26508E83_854669294 = getParameter(ParameterNames.TO_TAG);
        String varA7E53CE21691AB073D9660D615818899_1744319495; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1744319495 = varB4EAC82CA7396A68D541C85D26508E83_588929834;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1744319495 = varB4EAC82CA7396A68D541C85D26508E83_854669294;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1744319495.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1744319495;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.008 -0400", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "76D98031AA87EA3B7086F96BB810A95B")
    public void setToTag(String t) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_1415433901 = (t.trim().equals(""));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad tag", 0);
        } 
        this.setParameter(ParameterNames.TO_TAG, t);
        addTaint(t.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.010 -0400", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "BEB54C2B3F4DD077E8CAC0EC7C529079")
    public boolean hasToTag() {
        boolean var98F1538999349B56334E8D4578BD3F6B_1123746819 = (hasParameter(ParameterNames.TO_TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_378057576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_378057576;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.011 -0400", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "8F5C24D1B4E10E96F090DB388EB7CB97")
    public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.012 -0400", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "55E17DDCBB100BB80D53BFF61519425A")
    public String getFromTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1205089111 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_849091438 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1205089111 = null;
        varB4EAC82CA7396A68D541C85D26508E83_849091438 = getParameter(ParameterNames.FROM_TAG);
        String varA7E53CE21691AB073D9660D615818899_219113166; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_219113166 = varB4EAC82CA7396A68D541C85D26508E83_1205089111;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_219113166 = varB4EAC82CA7396A68D541C85D26508E83_849091438;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_219113166.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_219113166;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.013 -0400", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "D4CD0C1A9CE16F48B7092EDECCA0BD33")
    public void setFromTag(String t) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_935551639 = (t.trim().equals(""));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad tag", 0);
        } 
        this.setParameter(ParameterNames.FROM_TAG, t);
        addTaint(t.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.014 -0400", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "8BB8CF37AECA46953A59ED8969809941")
    public boolean hasFromTag() {
        boolean var3E2433518F90E4E3614AF7C9562C82F0_1728801315 = (hasParameter(ParameterNames.FROM_TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_880846444 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_880846444;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.014 -0400", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "B61172F24259436FBA34D6DD3E3FE321")
    public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.014 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.015 -0400", hash_original_field = "458D5CDFA53BA618A9930E93AC7CDE95", hash_generated_field = "6CB5FD5185865CE37770D9CE36F56865")

    private static final long serialVersionUID = -840116548918120056L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.015 -0400", hash_original_field = "BD7843C2FC1C4934D2D46FD2DD982DF8", hash_generated_field = "13095D8F107AFC77A4F003D089C600F0")

    public static final String NAME = "Join";
}

