package org.apache.harmony.security.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.nio.charset.Charsets;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public final class ASN1GeneralizedTime extends ASN1Time {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.507 -0400", hash_original_method = "BB0F4D8A317B403CA2CD2FD0C74F8C92", hash_generated_method = "AB7ED863FCD9D63D36CDA59E2988CC10")
    public  ASN1GeneralizedTime() {
        super(TAG_GENERALIZEDTIME);
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ASN1GeneralizedTime getInstance() {
        return ASN1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.508 -0400", hash_original_method = "9601D88CE03A72C3505152153428ACD0", hash_generated_method = "6B29C18D1086946BBAE67EB7A67739EA")
    public Object decode(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_974916992 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1957326908 = null; 
        in.readGeneralizedTime();
        {
            varB4EAC82CA7396A68D541C85D26508E83_974916992 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1957326908 = getDecodedObject(in);
        addTaint(in.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1761566707; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1761566707 = varB4EAC82CA7396A68D541C85D26508E83_974916992;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1761566707 = varB4EAC82CA7396A68D541C85D26508E83_1957326908;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1761566707.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1761566707;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.509 -0400", hash_original_method = "815E5B13588CE775C73F05D1D7B36D43", hash_generated_method = "07EA86AD64B9979A045C94D243E60921")
    public void encodeContent(BerOutputStream out) {
        out.encodeGeneralizedTime();
        addTaint(out.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.510 -0400", hash_original_method = "D33B8806BE3331999BE0A247A6FB02E4", hash_generated_method = "391250EF8A190005FA9C08346C1E2C56")
    public void setEncodingContent(BerOutputStream out) {
        SimpleDateFormat sdf = new SimpleDateFormat(GEN_PATTERN);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String temp = sdf.format(out.content);
        int nullId;
        int currLength;
        {
            boolean varEA3B2EF7AD4FD6854C0460808E435C91_1598298065 = (((nullId = temp.lastIndexOf('0', currLength = temp.length() - 1)) != -1)
                & (nullId == currLength));
            {
                temp = temp.substring(0, nullId);
            } 
        } 
        {
            boolean var20645FD268BF4909ADE246C840DD0211_893070848 = (temp.charAt(currLength) == '.');
            {
                temp = temp.substring(0, currLength);
            } 
        } 
        out.content = (temp + "Z").getBytes(Charsets.UTF_8);
        out.length = ((byte[]) out.content).length;
        addTaint(out.getTaint());
        
        
        
        
        
        
        
                
            
        
        
            
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.510 -0400", hash_original_field = "0F3C7EF5E3C60EA92CED4C3504F2779F", hash_generated_field = "239E9CA407C152785E67097B54E8268F")

    private static final ASN1GeneralizedTime ASN1 = new ASN1GeneralizedTime();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:33.510 -0400", hash_original_field = "A2534DA841AAEDBC550D45A7FE68CB06", hash_generated_field = "23A74B159873D60AD28A6667478A53DA")

    private static final String GEN_PATTERN = "yyyyMMddHHmmss.SSS";
}

