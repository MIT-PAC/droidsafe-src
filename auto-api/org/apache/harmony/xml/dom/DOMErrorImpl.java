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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.543 -0400", hash_original_field = "F6CDD8562435F8DC36B4C5A221A11D7C", hash_generated_field = "F6245D3BBEE7E5AD850161E037644184")

    private short severity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.543 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private String type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.544 -0400", hash_original_method = "D93952774FCD9E5EB0D2AAFF03FA31D6", hash_generated_method = "8AF09089EC69917AFCD10E7D197821EB")
    public  DOMErrorImpl(short severity, String type) {
        this.severity = severity;
        this.type = type;
        // ---------- Original Method ----------
        //this.severity = severity;
        //this.type = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.544 -0400", hash_original_method = "486D9FD618449ECBCAAA947A01B6396E", hash_generated_method = "92BC9D21192184B2007B2A60F3654FFA")
    public short getSeverity() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1304624131 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1304624131;
        // ---------- Original Method ----------
        //return severity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.544 -0400", hash_original_method = "736EB773CAD78737D003DEF14371364B", hash_generated_method = "ECF26F80269D13495F3668A12360A82F")
    public String getMessage() {
        String varB4EAC82CA7396A68D541C85D26508E83_1877987362 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1877987362 = type;
        varB4EAC82CA7396A68D541C85D26508E83_1877987362.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1877987362;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.545 -0400", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "22D27E88482FC5859AA165CF1F7C0A87")
    public String getType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1749348188 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1749348188 = type;
        varB4EAC82CA7396A68D541C85D26508E83_1749348188.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1749348188;
        // ---------- Original Method ----------
        //return type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.549 -0400", hash_original_method = "69DC7C3C45CF145B81BFA491DBEA3D67", hash_generated_method = "9B5B30F7279273F61A7A9936B7235EE9")
    public Object getRelatedException() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1119002426 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1119002426 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1119002426.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1119002426;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.551 -0400", hash_original_method = "2E051F1CC67E124CEB94F15E64801D89", hash_generated_method = "D1AD82AD8387DE4ED4AB4C05AB0B5D9A")
    public Object getRelatedData() {
        Object varB4EAC82CA7396A68D541C85D26508E83_307051717 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_307051717 = null;
        varB4EAC82CA7396A68D541C85D26508E83_307051717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_307051717;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.551 -0400", hash_original_method = "5FDC1F3E63CCD7CD3042D9A19CD94FF4", hash_generated_method = "4A87BDB20A885A0633B0DF5557C9FA5E")
    public DOMLocator getLocation() {
        DOMLocator varB4EAC82CA7396A68D541C85D26508E83_656584788 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_656584788 = NULL_DOM_LOCATOR;
        varB4EAC82CA7396A68D541C85D26508E83_656584788.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_656584788;
        // ---------- Original Method ----------
        //return NULL_DOM_LOCATOR;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.570 -0400", hash_original_field = "9F933224B2AAA0DFFB143BC6D8928978", hash_generated_field = "6B81C03AD8E5B9E720B2FF4BE39D0DF5")

    private static DOMLocator NULL_DOM_LOCATOR = new DOMLocator() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.552 -0400", hash_original_method = "B226EF391D7A5788D2A6B61A29A598E0", hash_generated_method = "CBEC03847CBD96190347882B654FBF88")
        public int getLineNumber() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991256246 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_991256246;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.552 -0400", hash_original_method = "8861CD3D81AD120598D5847E998DCDDD", hash_generated_method = "B856FA9D20998B745A05535A14870C66")
        public int getColumnNumber() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1968477398 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1968477398;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.567 -0400", hash_original_method = "05B54428E2337843F9A27998024BB4FC", hash_generated_method = "B1FD60387414F54FF78FC04C123E2DFC")
        public int getByteOffset() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1033172991 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1033172991;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.568 -0400", hash_original_method = "971AF81D7B5A736C60DA276A39DEF629", hash_generated_method = "6AE0FAD480F8DD4E43323DAD268EAA22")
        public int getUtf16Offset() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253424459 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_253424459;
            // ---------- Original Method ----------
            //return -1;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.568 -0400", hash_original_method = "BD213E5A838EDE8A4D1403172904A1AB", hash_generated_method = "FD76E476D3839AFE5A35AD741DE6509C")
        public Node getRelatedNode() {
            Node varB4EAC82CA7396A68D541C85D26508E83_1015845644 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1015845644 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1015845644.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1015845644;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.569 -0400", hash_original_method = "08DC8B98EA7E10D6197A6D233921DA55", hash_generated_method = "261E6F0B29E02DDE1387E46F3DC9C464")
        public String getUri() {
            String varB4EAC82CA7396A68D541C85D26508E83_1600570565 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1600570565 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1600570565.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1600570565;
            // ---------- Original Method ----------
            //return null;
        }

        
};
}

