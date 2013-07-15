package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;
import java.util.*;

public class Server extends SIPHeader implements ServerHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.613 -0400", hash_original_field = "9688EFB908EECBA4C560247BC17C9D80", hash_generated_field = "23BE30BA77F76A348892FB57EBB6010B")

    protected List productTokens;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.613 -0400", hash_original_method = "28A485C01704A957BCAF31556583EFBE", hash_generated_method = "305518061AF0A2CB840B318B99F5BA97")
    public  Server() {
        super(NAME);
        productTokens = new LinkedList();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.614 -0400", hash_original_method = "3BD03A3FDC86F025553E39D4B6A63060", hash_generated_method = "0D2E5FBE634E96CCC94C1CCA19D7BC43")
    private String encodeProduct() {
        String varB4EAC82CA7396A68D541C85D26508E83_1091660741 = null; 
        StringBuffer tokens = new StringBuffer();
        ListIterator it = productTokens.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1354626949 = (it.hasNext());
            {
                tokens.append((String) it.next());
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1527456953 = (it.hasNext());
                    tokens.append('/');
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1091660741 = tokens.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1091660741.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1091660741;
        
        
        
        
            
            
                
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.614 -0400", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "CEF2772B8F413B5DE4C8BE1EE4727C42")
    public void addProductToken(String pt) {
        productTokens.add(pt);
        addTaint(pt.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.615 -0400", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "367EDC06F65F8DA7482BC99F8926C652")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1934404534 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1934404534 = encodeProduct();
        varB4EAC82CA7396A68D541C85D26508E83_1934404534.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1934404534;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.615 -0400", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "D4FCE12434F1B3296A04FC29C403550B")
    public ListIterator getProduct() {
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_1991550309 = null; 
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_969707621 = null; 
        {
            boolean var6FC43180604DFF08774360C95FED0CF9_17426766 = (productTokens == null || productTokens.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_1991550309 = null;
            varB4EAC82CA7396A68D541C85D26508E83_969707621 = productTokens.listIterator();
        } 
        ListIterator varA7E53CE21691AB073D9660D615818899_1576202312; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1576202312 = varB4EAC82CA7396A68D541C85D26508E83_1991550309;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1576202312 = varB4EAC82CA7396A68D541C85D26508E83_969707621;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1576202312.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1576202312;
        
        
            
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.615 -0400", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "3149F1655FD6DBB53E41037D379F9BA7")
    public void setProduct(List product) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, UserAgent, "
                    + "setProduct(), the "
                    + " product parameter is null");
        productTokens = product;
        
        
            
                
                    
                    
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.615 -0400", hash_original_field = "C650C2D202702263731A478D25505F7E", hash_generated_field = "C0E073D0311495EC10E3519402318717")

    private static final long serialVersionUID = -3587764149383342973L;
}

