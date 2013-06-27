package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NodeListImpl implements NodeList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.995 -0400", hash_original_field = "268184C12DF027F536154D099D497B31", hash_generated_field = "01219BC14411B8933603C8E4F4F1DCA8")

    private List<NodeImpl> children;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.995 -0400", hash_original_method = "90C695C7BB2C17E5AEDC35249C42B72B", hash_generated_method = "0E4047B11F334542A784CB40C2591858")
      NodeListImpl() {
        children = new ArrayList<NodeImpl>();
        // ---------- Original Method ----------
        //children = new ArrayList<NodeImpl>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.996 -0400", hash_original_method = "769B9507B64DB92B25819A81313D951D", hash_generated_method = "7C6AE4C06DED08E678C5A34AF3F9DA08")
      NodeListImpl(List<NodeImpl> list) {
        children = list;
        // ---------- Original Method ----------
        //children = list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.996 -0400", hash_original_method = "3686ABB43FF3696F10F1056AA01C2579", hash_generated_method = "CB0E572162F21B0C5C964E256FE53E18")
     void add(NodeImpl node) {
        children.add(node);
        addTaint(node.getTaint());
        // ---------- Original Method ----------
        //children.add(node);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.996 -0400", hash_original_method = "91DC5DE88E19C57D8C382EFD5B1079BB", hash_generated_method = "8AD318FE3791CA4713AEF4DCF976A6B0")
    public int getLength() {
        int var491B2FC4AC35162024953FBA897D93CD_465713772 = (children.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331886926 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_331886926;
        // ---------- Original Method ----------
        //return children.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.997 -0400", hash_original_method = "41D1F200C8CAC9D2F8301DE4F00B532B", hash_generated_method = "C6B626793EA6B5DD251B72DF6A26C52C")
    public Node item(int index) {
        Node varB4EAC82CA7396A68D541C85D26508E83_513931987 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_638522882 = null; //Variable for return #2
        {
            boolean varB91815A31D273609574EB28CAF1CE458_1023917922 = (index >= children.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_513931987 = null;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_638522882 = children.get(index);
            } //End block
        } //End collapsed parenthetic
        addTaint(index);
        Node varA7E53CE21691AB073D9660D615818899_419190814; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_419190814 = varB4EAC82CA7396A68D541C85D26508E83_513931987;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_419190814 = varB4EAC82CA7396A68D541C85D26508E83_638522882;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_419190814.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_419190814;
        // ---------- Original Method ----------
        //if (index >= children.size()) {
            //return null;
        //} else {
            //return children.get(index);
        //}
    }

    
}

