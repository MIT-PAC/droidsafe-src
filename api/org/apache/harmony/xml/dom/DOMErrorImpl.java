package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMLocator;
import org.w3c.dom.Node;

public final class DOMErrorImpl implements DOMError {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.580 -0400", hash_original_field = "F6CDD8562435F8DC36B4C5A221A11D7C", hash_generated_field = "F6245D3BBEE7E5AD850161E037644184")

    private short severity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.580 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.580 -0400", hash_original_method = "D93952774FCD9E5EB0D2AAFF03FA31D6", hash_generated_method = "8AF09089EC69917AFCD10E7D197821EB")
    public  DOMErrorImpl(short severity, String type) {
        this.severity = severity;
        this.type = type;
        // ---------- Original Method ----------
        //this.severity = severity;
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.581 -0400", hash_original_method = "486D9FD618449ECBCAAA947A01B6396E", hash_generated_method = "C3CF86D18EC14C2706C74F9B09D49C85")
    public short getSeverity() {
        short varF6CDD8562435F8DC36B4C5A221A11D7C_345817214 = (severity);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1056259825 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1056259825;
        // ---------- Original Method ----------
        //return severity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.581 -0400", hash_original_method = "736EB773CAD78737D003DEF14371364B", hash_generated_method = "6E4F7F54F48A6439882FB3B42FC56A62")
    public String getMessage() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_824864219 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_824864219.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_824864219;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.581 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "70E1005ABDD735DBE54B2765A7342EA6")
    public String getType() {
String varC5B9F25B4EEAD3E8E2C33F9429204397_1373784448 =         type;
        varC5B9F25B4EEAD3E8E2C33F9429204397_1373784448.addTaint(taint);
        return varC5B9F25B4EEAD3E8E2C33F9429204397_1373784448;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.581 -0400", hash_original_method = "69DC7C3C45CF145B81BFA491DBEA3D67", hash_generated_method = "06ACC1AAE184B349FD3DACA79062E853")
    public Object getRelatedException() {
Object var540C13E9E156B687226421B24F2DF178_1990908078 =         null;
        var540C13E9E156B687226421B24F2DF178_1990908078.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1990908078;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.581 -0400", hash_original_method = "2E051F1CC67E124CEB94F15E64801D89", hash_generated_method = "860EA47A416C88C58CA9018EC9020B40")
    public Object getRelatedData() {
Object var540C13E9E156B687226421B24F2DF178_829572861 =         null;
        var540C13E9E156B687226421B24F2DF178_829572861.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_829572861;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.581 -0400", hash_original_method = "5FDC1F3E63CCD7CD3042D9A19CD94FF4", hash_generated_method = "3057E43224F6F0F3529AE1FEB7EF498A")
    public DOMLocator getLocation() {
DOMLocator varBCEE7747FFD5EB1F93193F1E8D2EBF97_1364555230 =         NULL_DOM_LOCATOR;
        varBCEE7747FFD5EB1F93193F1E8D2EBF97_1364555230.addTaint(taint);
        return varBCEE7747FFD5EB1F93193F1E8D2EBF97_1364555230;
        // ---------- Original Method ----------
        //return NULL_DOM_LOCATOR;
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

