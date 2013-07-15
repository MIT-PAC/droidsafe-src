package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMLocator;
import org.w3c.dom.Node;

public final class DOMErrorImpl implements DOMError {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.877 -0400", hash_original_field = "F6CDD8562435F8DC36B4C5A221A11D7C", hash_generated_field = "F6245D3BBEE7E5AD850161E037644184")

    private short severity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.877 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.877 -0400", hash_original_method = "D93952774FCD9E5EB0D2AAFF03FA31D6", hash_generated_method = "8AF09089EC69917AFCD10E7D197821EB")
    public  DOMErrorImpl(short severity, String type) {
        this.severity = severity;
        this.type = type;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.878 -0400", hash_original_method = "486D9FD618449ECBCAAA947A01B6396E", hash_generated_method = "2E2FA91A6CCD9357FDD3E8AF45E8DCBD")
    public short getSeverity() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_905718940 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_905718940;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.879 -0400", hash_original_method = "736EB773CAD78737D003DEF14371364B", hash_generated_method = "7C51036A55D9079DA3FD6404A349A090")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1469760418 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1469760418 = type;
        varB4EAC82CA7396A68D541C85D26508E83_1469760418.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1469760418;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.879 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "469F0720F67FC140EFE140CF1E2A4C2E")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1470449931 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1470449931 = type;
        varB4EAC82CA7396A68D541C85D26508E83_1470449931.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1470449931;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.880 -0400", hash_original_method = "69DC7C3C45CF145B81BFA491DBEA3D67", hash_generated_method = "71FEF7FDC7FFB6C6D642199AFD9AC691")
    public Object getRelatedException() {
        Object varB4EAC82CA7396A68D541C85D26508E83_612102527 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_612102527 = null;
        varB4EAC82CA7396A68D541C85D26508E83_612102527.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_612102527;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.880 -0400", hash_original_method = "2E051F1CC67E124CEB94F15E64801D89", hash_generated_method = "D8A7540938A42CE4047883F9829BC106")
    public Object getRelatedData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1402651769 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1402651769 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1402651769.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1402651769;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.880 -0400", hash_original_method = "5FDC1F3E63CCD7CD3042D9A19CD94FF4", hash_generated_method = "7C212B1DADE41DD6E034CBC57517CDE4")
    public DOMLocator getLocation() {
        DOMLocator varB4EAC82CA7396A68D541C85D26508E83_396124574 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_396124574 = NULL_DOM_LOCATOR;
        varB4EAC82CA7396A68D541C85D26508E83_396124574.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_396124574;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.882 -0400", hash_original_field = "9F933224B2AAA0DFFB143BC6D8928978", hash_generated_field = "966D54A811D8CFE5E01A60999E418189")

    private static final DOMLocator NULL_DOM_LOCATOR = new DOMLocator() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.881 -0400", hash_original_method = "B226EF391D7A5788D2A6B61A29A598E0", hash_generated_method = "5DA5637A847F7AE9184CEAA4895A9079")
        public int getLineNumber() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2078389753 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2078389753;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.881 -0400", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "EBFE671DC655AF943474BB2E67D8CBE7")
        public int getColumnNumber() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113900983 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113900983;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.881 -0400", hash_original_method = "05B54428E2337843F9A27998024BB4FC", hash_generated_method = "3C44385CD6EE799E6690F7F8643E50DB")
        public int getByteOffset() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300430371 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1300430371;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.882 -0400", hash_original_method = "971AF81D7B5A736C60DA276A39DEF629", hash_generated_method = "641E94AEEC7A047E600E18A787A2360D")
        public int getUtf16Offset() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651457179 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1651457179;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.882 -0400", hash_original_method = "BD213E5A838EDE8A4D1403172904A1AB", hash_generated_method = "5254BCC77657250B9A05F6256FC455A2")
        public Node getRelatedNode() {
            Node varB4EAC82CA7396A68D541C85D26508E83_2051227868 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2051227868 = null;
            varB4EAC82CA7396A68D541C85D26508E83_2051227868.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2051227868;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.882 -0400", hash_original_method = "08DC8B98EA7E10D6197A6D233921DA55", hash_generated_method = "CD4F23A9BDE71DF49DFCB648FC57E9F7")
        public String getUri() {
            String varB4EAC82CA7396A68D541C85D26508E83_1385380363 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1385380363 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1385380363.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1385380363;
            
            
        }

        
};
}

