package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMLocator;
import org.w3c.dom.Node;

public final class DOMErrorImpl implements DOMError {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.697 -0400", hash_original_field = "F6CDD8562435F8DC36B4C5A221A11D7C", hash_generated_field = "F6245D3BBEE7E5AD850161E037644184")

    private short severity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.697 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.697 -0400", hash_original_method = "D93952774FCD9E5EB0D2AAFF03FA31D6", hash_generated_method = "8AF09089EC69917AFCD10E7D197821EB")
    public  DOMErrorImpl(short severity, String type) {
        this.severity = severity;
        this.type = type;
        // ---------- Original Method ----------
        //this.severity = severity;
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.697 -0400", hash_original_method = "486D9FD618449ECBCAAA947A01B6396E", hash_generated_method = "C581EF72946DBF5883EB4CA14F1DC378")
    public short getSeverity() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1502630418 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1502630418;
        // ---------- Original Method ----------
        //return severity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.698 -0400", hash_original_method = "736EB773CAD78737D003DEF14371364B", hash_generated_method = "AD4A3B69F7CE76528757A74E4212EBF1")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_433302121 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_433302121 = type;
        varB4EAC82CA7396A68D541C85D26508E83_433302121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_433302121;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.698 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "E5C426F2945F38F455948259E9C34A3D")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1291194197 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1291194197 = type;
        varB4EAC82CA7396A68D541C85D26508E83_1291194197.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1291194197;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.699 -0400", hash_original_method = "69DC7C3C45CF145B81BFA491DBEA3D67", hash_generated_method = "F741EA3F2BA8A371A0B4CD0CE8E2F217")
    public Object getRelatedException() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1748441975 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1748441975 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1748441975.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1748441975;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.700 -0400", hash_original_method = "2E051F1CC67E124CEB94F15E64801D89", hash_generated_method = "7AECD055B040713A451496D61EF445F1")
    public Object getRelatedData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1409724985 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1409724985 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1409724985.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1409724985;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.700 -0400", hash_original_method = "5FDC1F3E63CCD7CD3042D9A19CD94FF4", hash_generated_method = "EAA6A8F097CBCDC26C75A4E057A08619")
    public DOMLocator getLocation() {
        DOMLocator varB4EAC82CA7396A68D541C85D26508E83_2038638992 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2038638992 = NULL_DOM_LOCATOR;
        varB4EAC82CA7396A68D541C85D26508E83_2038638992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2038638992;
        // ---------- Original Method ----------
        //return NULL_DOM_LOCATOR;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.714 -0400", hash_original_field = "9F933224B2AAA0DFFB143BC6D8928978", hash_generated_field = "FC8417CF700899244313CB03363F5A02")

    private static DOMLocator NULL_DOM_LOCATOR = new DOMLocator() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.713 -0400", hash_original_method = "B226EF391D7A5788D2A6B61A29A598E0", hash_generated_method = "41E0F8DC5AA549522734EB5337FD5C52")
        public int getLineNumber() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640353407 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640353407;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.713 -0400", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "684E4961289A48FFB9E328344D097FA4")
        public int getColumnNumber() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207001167 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1207001167;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.713 -0400", hash_original_method = "05B54428E2337843F9A27998024BB4FC", hash_generated_method = "8D3407E4C0D596A1ECF5ED3DEF570BD6")
        public int getByteOffset() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135082091 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1135082091;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.713 -0400", hash_original_method = "971AF81D7B5A736C60DA276A39DEF629", hash_generated_method = "8C1B62A9578A610CE097C03AB4B36A22")
        public int getUtf16Offset() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971006785 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1971006785;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.714 -0400", hash_original_method = "BD213E5A838EDE8A4D1403172904A1AB", hash_generated_method = "2D6AF7BB09F805A4ADBF2F150F34C460")
        public Node getRelatedNode() {
            Node varB4EAC82CA7396A68D541C85D26508E83_212285847 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_212285847 = null;
            varB4EAC82CA7396A68D541C85D26508E83_212285847.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_212285847;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.714 -0400", hash_original_method = "08DC8B98EA7E10D6197A6D233921DA55", hash_generated_method = "06A8000E24EA7BB3FEF7F5C4391F7A7F")
        public String getUri() {
            String varB4EAC82CA7396A68D541C85D26508E83_1296153448 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1296153448 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1296153448.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1296153448;
            // ---------- Original Method ----------
            //return null;
        }

        
};
}

