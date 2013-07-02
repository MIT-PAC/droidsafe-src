package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.InvalidArgumentException;

public final class Accept extends ParametersHeader implements javax.sip.header.AcceptHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.773 -0400", hash_original_field = "658105D0D44EEADF22FE9B4C6C740531", hash_generated_field = "FE54B36640417CD311E956ED780B7202")

    protected MediaRange mediaRange;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.773 -0400", hash_original_method = "4311F842678DE87ACCC1A689A829FC2C", hash_generated_method = "078F21FB6AC134D27AFE15A2BEB94126")
    public  Accept() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.774 -0400", hash_original_method = "B50D7EE39281F850FBFCC110ACB58D68", hash_generated_method = "53F8073EACF86E1FB2B4CE1EFDB904DB")
    public boolean allowsAllContentTypes() {
        boolean var64DDE92D495F783D40417AA9F67FACBC_1701222251 = (mediaRange.type.compareTo(STAR) == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_518261869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_518261869;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.775 -0400", hash_original_method = "A0A0F085E1B8E4ED63796A6BDE3F17D2", hash_generated_method = "C5BB2E247CD152950F8F089A875B3932")
    public boolean allowsAllContentSubTypes() {
        boolean var845E1A09F821006DFE97BDC77E980731_657138138 = (mediaRange.getSubtype().compareTo(STAR) == 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1206264884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1206264884;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.776 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "1CB4DCC8A572A3680BD3020EA3F884E6")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1466923866 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1466923866 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1466923866.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1466923866;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.777 -0400", hash_original_method = "2E9CDABA864012CB945701B1775B2668", hash_generated_method = "8C5C4EC0C324C2B25A387FCC37713553")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_88784312 = null; 
        mediaRange.encode(buffer);
        {
            boolean var6EE855E3C41C4B08670E124CDE7B7E84_1009015670 = (parameters != null && !parameters.isEmpty());
            {
                buffer.append(';');
                parameters.encode(buffer);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_88784312 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_88784312.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_88784312;
        
        
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.778 -0400", hash_original_method = "95EC1B8E6B4FF94ADCA4E5294FD4A8E3", hash_generated_method = "51D932D9DD636367856BDDC573F1AB8F")
    public MediaRange getMediaRange() {
        MediaRange varB4EAC82CA7396A68D541C85D26508E83_837004590 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_837004590 = mediaRange;
        varB4EAC82CA7396A68D541C85D26508E83_837004590.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_837004590;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.779 -0400", hash_original_method = "44E6E041E8AD4F7B067250B3E11E39C2", hash_generated_method = "310F12F0E213486B24D10D7DBC991AB5")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1851538500 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_355589251 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1851538500 = null;
        varB4EAC82CA7396A68D541C85D26508E83_355589251 = mediaRange.getType();
        String varA7E53CE21691AB073D9660D615818899_715830320; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_715830320 = varB4EAC82CA7396A68D541C85D26508E83_1851538500;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_715830320 = varB4EAC82CA7396A68D541C85D26508E83_355589251;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_715830320.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_715830320;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.780 -0400", hash_original_method = "F0A4743083D481DF1A54A7DBA5F4C599", hash_generated_method = "88D823850EB92AE1086DC3794DDCFA02")
    public String getContentSubType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1470851391 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_594206757 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1470851391 = null;
        varB4EAC82CA7396A68D541C85D26508E83_594206757 = mediaRange.getSubtype();
        String varA7E53CE21691AB073D9660D615818899_1675149153; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1675149153 = varB4EAC82CA7396A68D541C85D26508E83_1470851391;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1675149153 = varB4EAC82CA7396A68D541C85D26508E83_594206757;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1675149153.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1675149153;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.781 -0400", hash_original_method = "2956E51B04B3FEA729EF44EFAC0B4B09", hash_generated_method = "9C3A382B099E447FBB25CC88AACB2855")
    public float getQValue() {
        float varFCCDE4ED6E8958DC6B6334A756EC9BB0_2058191037 = (getParameterAsFloat(ParameterNames.Q));
        float var546ADE640B6EDFBC8A086EF31347E768_236645005 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_236645005;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.781 -0400", hash_original_method = "43FA513912350854847003FDB290D6C5", hash_generated_method = "22BB807560120425EA387265A0884017")
    public boolean hasQValue() {
        boolean varA8464ED772B5E00402FF5E0AA2A3D240_1430872937 = (super.hasParameter(ParameterNames.Q));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_327857855 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_327857855;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.782 -0400", hash_original_method = "BF4B60E4788A555E5EC3F45CB4B13E83", hash_generated_method = "89EF342CEBC3F79A086D3DD96679DCC5")
    public void removeQValue() {
        super.removeParameter(ParameterNames.Q);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.782 -0400", hash_original_method = "812F213530DE805FDEF52FE413B9F204", hash_generated_method = "1CBB0A59F6E745D67FD31DA1C8332E48")
    public void setContentSubType(String subtype) {
        mediaRange = new MediaRange();
        mediaRange.setSubtype(subtype);
        addTaint(subtype.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.783 -0400", hash_original_method = "6381E85A55588E15B8DC137B6EE66A93", hash_generated_method = "B6E555F4520B093CCD5B4242AA516043")
    public void setContentType(String type) {
        mediaRange = new MediaRange();
        mediaRange.setType(type);
        addTaint(type.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.783 -0400", hash_original_method = "E4B2DA5B904DBFAB5481CDBAB5D46DBA", hash_generated_method = "3FA4205ACD2550423F1FE6C948A2B8C3")
    public void setQValue(float qValue) throws InvalidArgumentException {
        super.removeParameter(ParameterNames.Q);
        super.setParameter(ParameterNames.Q, qValue);
        addTaint(qValue);
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.783 -0400", hash_original_method = "E4AF328E0ACDB3837FCDCFA232CB922B", hash_generated_method = "D4B8159947A4E1D723FD3764612CBB21")
    public void setMediaRange(MediaRange m) {
        mediaRange = m;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.784 -0400", hash_original_method = "0EF41097CC41F1F6A85A85E560745DC8", hash_generated_method = "1084F848446856EB9ADB4C85F49F9C31")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1434976487 = null; 
        Accept retval = (Accept) super.clone();
        retval.mediaRange = (MediaRange) this.mediaRange.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1434976487 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1434976487.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1434976487;
        
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:38.784 -0400", hash_original_field = "9F9BCA318B9143C3A7133286BB978428", hash_generated_field = "67A05C878CFE3A4D19A95E223075CE16")

    private static final long serialVersionUID = -7866187924308658151L;
}

