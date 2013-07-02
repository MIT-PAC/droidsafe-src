package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.*;

public final class ContentDisposition extends ParametersHeader implements javax.sip.header.ContentDispositionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.386 -0400", hash_original_field = "86E632F72B9E07ED6667FBC88CAC9E93", hash_generated_field = "3DCB42D88F9099A5D16D2C3D4422D6B7")

    protected String dispositionType;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.386 -0400", hash_original_method = "43E6E51171C31AE017D057FA4552D811", hash_generated_method = "30697E61C2A62E132F1F2ECEC533B294")
    public  ContentDisposition() {
        super(NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.387 -0400", hash_original_method = "A77142351A28E594907776BE9B73073E", hash_generated_method = "2A489B777048169B014CA8A86DF74DEB")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1822615963 = null; 
        StringBuffer encoding = new StringBuffer(dispositionType);
        {
            boolean var0D32F672AFA5F784DED3919887902299_1543398453 = (!this.parameters.isEmpty());
            {
                encoding.append(SEMICOLON).append(parameters.encode());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1822615963 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1822615963.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1822615963;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.387 -0400", hash_original_method = "BC30AB325A2FD01EDD0A547607B8E8A1", hash_generated_method = "157F515106160D420C46FCAD8B49535F")
    public void setDispositionType(String dispositionType) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setDispositionType(), the dispositionType parameter is null");
        this.dispositionType = dispositionType;
        
        
            
                
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.388 -0400", hash_original_method = "D3ED1AFB699417969621FE1884F8C7FE", hash_generated_method = "7F1FF4C0D83177AF43380CD19254D0E4")
    public String getDispositionType() {
        String varB4EAC82CA7396A68D541C85D26508E83_548435067 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_548435067 = this.dispositionType;
        varB4EAC82CA7396A68D541C85D26508E83_548435067.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_548435067;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.388 -0400", hash_original_method = "0297698DA62A584BC408978A78677ED8", hash_generated_method = "5C2417F2C5CDC23A8652289BD1113224")
    public String getHandling() {
        String varB4EAC82CA7396A68D541C85D26508E83_1084340543 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1084340543 = this.getParameter("handling");
        varB4EAC82CA7396A68D541C85D26508E83_1084340543.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1084340543;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.389 -0400", hash_original_method = "B6C4C36D7665EDCFABC9BF782D2AADE0", hash_generated_method = "3B5D28B005B96508C6481678E08CEEEA")
    public void setHandling(String handling) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception"
                    + ", ContentDisposition, setHandling(), the handling parameter is null");
        this.setParameter("handling", handling);
        addTaint(handling.getTaint());
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.389 -0400", hash_original_method = "C2FDE3A2DBDC43C0B4279ABCAA53BEFB", hash_generated_method = "CC8C89AF68E1C767FDF1F0EF3893A8F4")
    public String getContentDisposition() {
        String varB4EAC82CA7396A68D541C85D26508E83_2134361411 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2134361411 = this.encodeBody();
        varB4EAC82CA7396A68D541C85D26508E83_2134361411.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2134361411;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.389 -0400", hash_original_field = "BEA47888ED57494C760553D19E44266B", hash_generated_field = "1A47D47195A65F4F581EF3E849861302")

    private static final long serialVersionUID = 835596496276127003L;
}

