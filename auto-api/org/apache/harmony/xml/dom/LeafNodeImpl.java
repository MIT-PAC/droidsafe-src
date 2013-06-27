package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.Node;

public abstract class LeafNodeImpl extends NodeImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.937 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "5449DEEA97DBC636B0C94C7706497CE1")

    InnerNodeImpl parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.937 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.941 -0400", hash_original_method = "C37CADF0F64FF24C3BED74AC237BFE15", hash_generated_method = "BD8792B33C5ED85E1BF733B7FAB8E9B4")
      LeafNodeImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.949 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "E18695B965DB2B4D90BB0B9D955F3FCD")
    public Node getNextSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_621394314 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_486593204 = null; //Variable for return #2
        {
            boolean var95B22E1313A32C2512A690CDD98132D0_746459763 = (parent == null || index + 1 >= parent.children.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_621394314 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_486593204 = parent.children.get(index + 1);
        Node varA7E53CE21691AB073D9660D615818899_158556988; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_158556988 = varB4EAC82CA7396A68D541C85D26508E83_621394314;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_158556988 = varB4EAC82CA7396A68D541C85D26508E83_486593204;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_158556988.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_158556988;
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.950 -0400", hash_original_method = "B8A0C756618E449548951ECCC8542C8B", hash_generated_method = "06EBC339E09D66278A6A56B877812CFB")
    public Node getParentNode() {
        Node varB4EAC82CA7396A68D541C85D26508E83_311053793 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_311053793 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_311053793.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_311053793;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.951 -0400", hash_original_method = "8D9655D90408A316224292865014DAE6", hash_generated_method = "C47EA04E1463D3F52D44392472D2AD4E")
    public Node getPreviousSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_499405809 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_1962407474 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_499405809 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1962407474 = parent.children.get(index - 1);
        Node varA7E53CE21691AB073D9660D615818899_227746066; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_227746066 = varB4EAC82CA7396A68D541C85D26508E83_499405809;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_227746066 = varB4EAC82CA7396A68D541C85D26508E83_1962407474;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_227746066.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_227746066;
        // ---------- Original Method ----------
        //if (parent == null || index == 0) {
            //return null;
        //}
        //return parent.children.get(index - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.974 -0400", hash_original_method = "4FE9AF789BEC71BD17F719913A9768F5", hash_generated_method = "52908556FCA6A3BC4C62F58C5833ECEF")
     boolean isParentOf(Node node) {
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1632394864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1632394864;
        // ---------- Original Method ----------
        //return false;
    }

    
}

