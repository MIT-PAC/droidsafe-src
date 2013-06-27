package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.w3c.dom.Node;

public abstract class LeafNodeImpl extends NodeImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.069 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "5449DEEA97DBC636B0C94C7706497CE1")

    InnerNodeImpl parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.069 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "8BD524D6245D998B3BBC44EB9313082E")

    int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.069 -0400", hash_original_method = "C37CADF0F64FF24C3BED74AC237BFE15", hash_generated_method = "BD8792B33C5ED85E1BF733B7FAB8E9B4")
      LeafNodeImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.070 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "265D7943D3033B87C4D48C90FF3FD2E4")
    public Node getNextSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_478779008 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_472838420 = null; //Variable for return #2
        {
            boolean var95B22E1313A32C2512A690CDD98132D0_1265378749 = (parent == null || index + 1 >= parent.children.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_478779008 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_472838420 = parent.children.get(index + 1);
        Node varA7E53CE21691AB073D9660D615818899_1471470381; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1471470381 = varB4EAC82CA7396A68D541C85D26508E83_478779008;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1471470381 = varB4EAC82CA7396A68D541C85D26508E83_472838420;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1471470381.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1471470381;
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.071 -0400", hash_original_method = "B8A0C756618E449548951ECCC8542C8B", hash_generated_method = "DBB675AAE03441561B308BD266A38028")
    public Node getParentNode() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1543742044 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1543742044 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_1543742044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1543742044;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.083 -0400", hash_original_method = "8D9655D90408A316224292865014DAE6", hash_generated_method = "28A0894CD9711B0C244AC61FB4D69483")
    public Node getPreviousSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1675850315 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_1023837909 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1675850315 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1023837909 = parent.children.get(index - 1);
        Node varA7E53CE21691AB073D9660D615818899_569563991; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_569563991 = varB4EAC82CA7396A68D541C85D26508E83_1675850315;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_569563991 = varB4EAC82CA7396A68D541C85D26508E83_1023837909;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_569563991.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_569563991;
        // ---------- Original Method ----------
        //if (parent == null || index == 0) {
            //return null;
        //}
        //return parent.children.get(index - 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.083 -0400", hash_original_method = "4FE9AF789BEC71BD17F719913A9768F5", hash_generated_method = "01B2975183BE703FDBE096B28C53D65C")
     boolean isParentOf(Node node) {
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_260535535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_260535535;
        // ---------- Original Method ----------
        //return false;
    }

    
}

