package gov.nist.javax.sip.header.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import javax.sip.header.ExtensionHeader;

public class Replaces extends ParametersHeader implements ExtensionHeader, ReplacesHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.070 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "64120D09C2B0721B310316A22E4103F4")

    public CallIdentifier callIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.070 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "B530B3F06EB2C57DA5D10CD3EC3286F9")

    public String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.071 -0400", hash_original_method = "573D7C3C26F3FDBFC64B6AAA9C0FB261", hash_generated_method = "E109DF2046FCB28298FD5EAEEDF43CFC")
    public  Replaces() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.071 -0400", hash_original_method = "FC3FC3684A022FA26474BF29AC78B1CA", hash_generated_method = "9D6712590EF6EE91F7F5D49A3617C968")
    public  Replaces(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.072 -0400", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "3A4875F979BF9791B839C2791BC99F9B")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_352080441 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_516070396 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_352080441 = null;
        {
            String retVal = callId;
            {
                boolean var68D5E9BF75957AD09F9F4AEE7444A527_1114846332 = (!parameters.isEmpty());
                {
                    retVal += SEMICOLON + parameters.encode();
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_516070396 = retVal;
        } 
        String varA7E53CE21691AB073D9660D615818899_1139289244; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1139289244 = varB4EAC82CA7396A68D541C85D26508E83_352080441;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1139289244 = varB4EAC82CA7396A68D541C85D26508E83_516070396;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1139289244.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1139289244;
        
        
            
        
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.072 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "838150AD0DEDF5182D61BF1DA28BF86C")
    public String getCallId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1452977651 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1452977651 = callId;
        varB4EAC82CA7396A68D541C85D26508E83_1452977651.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1452977651;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.073 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "BA9D97B03B4B879A1032B792EE0836FC")
    public CallIdentifier getCallIdentifer() {
        CallIdentifier varB4EAC82CA7396A68D541C85D26508E83_900227208 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_900227208 = callIdentifier;
        varB4EAC82CA7396A68D541C85D26508E83_900227208.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_900227208;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.073 -0400", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "6992A879D69ED0B331E4999AE9EC11CE")
    public void setCallId(String cid) {
        callId = cid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.073 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.073 -0400", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "280A7B9E4E71F036B2450E28168DC7E2")
    public String getToTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_948892651 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_589835538 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_948892651 = null;
        varB4EAC82CA7396A68D541C85D26508E83_589835538 = getParameter(ParameterNames.TO_TAG);
        String varA7E53CE21691AB073D9660D615818899_1184937856; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1184937856 = varB4EAC82CA7396A68D541C85D26508E83_948892651;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1184937856 = varB4EAC82CA7396A68D541C85D26508E83_589835538;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1184937856.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1184937856;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.074 -0400", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "D245438D9B2629526A081B93856E367D")
    public void setToTag(String t) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_293603327 = (t.trim().equals(""));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad tag", 0);
        } 
        this.setParameter(ParameterNames.TO_TAG, t);
        addTaint(t.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.074 -0400", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "EE745FA5FA53FDF79F98A023ADE8F56E")
    public boolean hasToTag() {
        boolean var98F1538999349B56334E8D4578BD3F6B_606877972 = (hasParameter(ParameterNames.TO_TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1643488546 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1643488546;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.074 -0400", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "8F5C24D1B4E10E96F090DB388EB7CB97")
    public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.075 -0400", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "E5A4E686D01AE698075C0B7215D3FCF2")
    public String getFromTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_1356357039 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_738068542 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1356357039 = null;
        varB4EAC82CA7396A68D541C85D26508E83_738068542 = getParameter(ParameterNames.FROM_TAG);
        String varA7E53CE21691AB073D9660D615818899_365136629; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_365136629 = varB4EAC82CA7396A68D541C85D26508E83_1356357039;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_365136629 = varB4EAC82CA7396A68D541C85D26508E83_738068542;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_365136629.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_365136629;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.075 -0400", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "68579E8E99FB40B32A3CC86ED1D4F326")
    public void setFromTag(String t) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("null tag ");
        {
            boolean var545A2558F1CD00AC700C1719D675DFB3_108313582 = (t.trim().equals(""));
            if (DroidSafeAndroidRuntime.control) throw new ParseException("bad tag", 0);
        } 
        this.setParameter(ParameterNames.FROM_TAG, t);
        addTaint(t.getTaint());
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.076 -0400", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "5364C8D3ECE66D23FC1DF4A0F6C8479E")
    public boolean hasFromTag() {
        boolean var3E2433518F90E4E3614AF7C9562C82F0_222104524 = (hasParameter(ParameterNames.FROM_TAG));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1023326792 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1023326792;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.076 -0400", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "B61172F24259436FBA34D6DD3E3FE321")
    public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.077 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value,0);
        addTaint(value.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.077 -0400", hash_original_field = "1A90250BEA22A34094D11017692E5A52", hash_generated_field = "F2330FF32F2F9FA993B883D22A1E4D56")

    private static final long serialVersionUID = 8765762413224043300L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.077 -0400", hash_original_field = "4403168D63862D2494FF603BBD9AC891", hash_generated_field = "6C314597CB78321B5F749A310B2C1B23")

    public static final String NAME = "Replaces";
}

