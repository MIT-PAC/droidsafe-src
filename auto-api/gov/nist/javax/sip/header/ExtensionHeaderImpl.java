package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ExtensionHeaderImpl extends SIPHeader implements javax.sip.header.ExtensionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.531 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "67AFEE1CECFFBA6E89413397161A2E7D")

    protected String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.531 -0400", hash_original_method = "0D428BF693BC145CE79E697041FDBB13", hash_generated_method = "E16B4249E7E1D0E0C17B6F77DF99E8B5")
    public  ExtensionHeaderImpl() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.531 -0400", hash_original_method = "A937839923AA8BCCDCCEAF20D9D52A8A", hash_generated_method = "CE11635C6A2DA477CA25FDD83D492784")
    public  ExtensionHeaderImpl(String headerName) {
        super(headerName);
        addTaint(headerName.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.532 -0400", hash_original_method = "484F8876E72CD5E2F0338DF99C79D0F8", hash_generated_method = "CE5DDBB2CC882FDCDEEB362EE6539269")
    public void setName(String headerName) {
        this.headerName = headerName;
        addTaint(headerName.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.532 -0400", hash_original_method = "54A096BDAB783365763903A518BE6C1A", hash_generated_method = "811C079A212601355D5034023F0D4C0B")
    public void setValue(String value) {
        this.value = value;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.533 -0400", hash_original_method = "1D785F814110552974451EFCFA0C5F26", hash_generated_method = "BE3E854DE11DACD500F991B8F064FC6A")
    public String getHeaderValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_127191773 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_89504190 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1147209469 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_127191773 = this.value;
        } 
        {
            String encodedHdr = null;
            try 
            {
                encodedHdr = this.encode();
            } 
            catch (Exception ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_89504190 = null;
            } 
            StringBuffer buffer = new StringBuffer(encodedHdr);
            {
                boolean varEBE4927262008ED3958A3F76EC2D70F1_1496106714 = (buffer.length() > 0 && buffer.charAt(0) != ':');
                {
                    buffer.deleteCharAt(0);
                } 
            } 
            buffer.deleteCharAt(0);
            this.value = buffer.toString().trim();
            varB4EAC82CA7396A68D541C85D26508E83_1147209469 = this.value;
        } 
        String varA7E53CE21691AB073D9660D615818899_690944452; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_690944452 = varB4EAC82CA7396A68D541C85D26508E83_127191773;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_690944452 = varB4EAC82CA7396A68D541C85D26508E83_89504190;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_690944452 = varB4EAC82CA7396A68D541C85D26508E83_1147209469;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_690944452.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_690944452;
        
        
            
        
            
            
                
            
                
            
            
            
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.533 -0400", hash_original_method = "AC75BAF5D25E8A26F15256B1C5A7867F", hash_generated_method = "E88B1EB7299451CA24F491CC774722D7")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_1825662289 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1825662289 = new StringBuffer(this.headerName)
            .append(COLON)
            .append(SP)
            .append(this.value)
            .append(NEWLINE)
            .toString();
        varB4EAC82CA7396A68D541C85D26508E83_1825662289.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1825662289;
        
        
            
            
            
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.534 -0400", hash_original_method = "0A0703D799D76E700F53E1DA99AB2D69", hash_generated_method = "FBCA6E87E202FEF0F4FD897E669599F1")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1558265743 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1558265743 = this.getHeaderValue();
        varB4EAC82CA7396A68D541C85D26508E83_1558265743.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1558265743;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.534 -0400", hash_original_field = "17BBB107160A1B885287E0DF95FB240C", hash_generated_field = "2299100AA92F5021DFDAE61FD8547A67")

    private static final long serialVersionUID = -8693922839612081849L;
}

