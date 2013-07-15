package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.sip.*;
import javax.sip.header.ContentLengthHeader;

public class ContentLength extends SIPHeader implements javax.sip.header.ContentLengthHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.436 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "8B32F0E2687755E2873F555A7E264239")

    protected Integer contentLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.437 -0400", hash_original_method = "6E8A391CB1CB04739D58E661944CCFB0", hash_generated_method = "BEA878E6A814B0FF9D7761D669FAB007")
    public  ContentLength() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.437 -0400", hash_original_method = "2D2F8FB9FD0DE4D4C70B238FD2D4C88B", hash_generated_method = "D12872C2D47D49B4D77E9FE423C6010C")
    public  ContentLength(int length) {
        super(NAME);
        this.contentLength = Integer.valueOf(length);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.437 -0400", hash_original_method = "071F13E55E71377D8D1F79D63D84EB7C", hash_generated_method = "3E86F5BC11A980025BD8047703E4C207")
    public int getContentLength() {
        int var959B9E91EDB949EF182CA415D001798B_2024220020 = (contentLength.intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575198145 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1575198145;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.437 -0400", hash_original_method = "D2E39B4328F6A55D8ECA212C37A06119", hash_generated_method = "7E264BD81ABF5DD5CE2C02AA30F647EC")
    public void setContentLength(int contentLength) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", ContentLength, setContentLength(), the contentLength parameter is <0");
        this.contentLength = Integer.valueOf(contentLength);
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.438 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "DF5829F1A08E05B133B531683A762D72")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1047523501 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1047523501 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1047523501.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1047523501;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.438 -0400", hash_original_method = "5B96EE656807643EA726005E8D24EEAD", hash_generated_method = "3967F889CEEE52349D15C99F071247AD")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_951260566 = null; 
        buffer.append("0");
        buffer.append(contentLength.toString());
        varB4EAC82CA7396A68D541C85D26508E83_951260566 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_951260566.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_951260566;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.439 -0400", hash_original_method = "9921BFF09FACC23B6D23BD0D026EB023", hash_generated_method = "A4F3182160FF8CBD19D4E6CA50690D7C")
    public boolean match(Object other) {
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_517372530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_517372530;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.439 -0400", hash_original_method = "B4957EC40AAAC0570CBC84EE1092BF02", hash_generated_method = "F86044FDF0164AEC760BEAED376F2B50")
    public boolean equals(Object other) {
        {
            final ContentLengthHeader o = (ContentLengthHeader) other;
            boolean varB67ADC09111838E0523E2E12184F643D_1230172649 = (this.getContentLength() == o.getContentLength());
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524138675 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524138675;
        
        
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.439 -0400", hash_original_field = "0A8F14B7447B017C5FFCEC85C0E796E8", hash_generated_field = "0DAE05D7BF9A340249D2F42939DD9CA2")

    private static final long serialVersionUID = 1187190542411037027L;
}

