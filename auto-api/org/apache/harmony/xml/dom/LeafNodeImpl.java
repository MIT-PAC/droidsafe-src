package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.Node;

public abstract class LeafNodeImpl extends NodeImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.187 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "5449DEEA97DBC636B0C94C7706497CE1")

    InnerNodeImpl parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.187 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.187 -0400", hash_original_method = "C37CADF0F64FF24C3BED74AC237BFE15", hash_generated_method = "BD8792B33C5ED85E1BF733B7FAB8E9B4")
      LeafNodeImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.188 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "E33860C3AD2E094DE5C5CC122B4231DB")
    public Node getNextSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1085428481 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_7311926 = null; //Variable for return #2
        {
            boolean var95B22E1313A32C2512A690CDD98132D0_453746818 = (parent == null || index + 1 >= parent.children.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1085428481 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_7311926 = parent.children.get(index + 1);
        Node varA7E53CE21691AB073D9660D615818899_783741008; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_783741008 = varB4EAC82CA7396A68D541C85D26508E83_1085428481;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_783741008 = varB4EAC82CA7396A68D541C85D26508E83_7311926;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_783741008.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_783741008;
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.188 -0400", hash_original_method = "B8A0C756618E449548951ECCC8542C8B", hash_generated_method = "2C7F3B301384E7EF8FC0560550673E62")
    public Node getParentNode() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1432085404 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1432085404 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_1432085404.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1432085404;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.189 -0400", hash_original_method = "8D9655D90408A316224292865014DAE6", hash_generated_method = "19420DE7AF3F6AB72EF89829042D1DD1")
    public Node getPreviousSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1389005034 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_1092170556 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1389005034 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1092170556 = parent.children.get(index - 1);
        Node varA7E53CE21691AB073D9660D615818899_157978887; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_157978887 = varB4EAC82CA7396A68D541C85D26508E83_1389005034;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_157978887 = varB4EAC82CA7396A68D541C85D26508E83_1092170556;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_157978887.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_157978887;
        // ---------- Original Method ----------
        //if (parent == null || index == 0) {
            //return null;
        //}
        //return parent.children.get(index - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.189 -0400", hash_original_method = "4FE9AF789BEC71BD17F719913A9768F5", hash_generated_method = "AD748F93A7E45C04AE711A8C7755F4A4")
     boolean isParentOf(Node node) {
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1754503027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1754503027;
        // ---------- Original Method ----------
        //return false;
    }

    
}

