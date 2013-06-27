package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import libcore.util.Objects;
import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class InnerNodeImpl extends LeafNodeImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.892 -0400", hash_original_field = "F003D44A4CF514277D9944C7A47DACA3", hash_generated_field = "B027621B27AE52A5595EFB742F1A4AE3")

    List<LeafNodeImpl> children = new ArrayList<LeafNodeImpl>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.892 -0400", hash_original_method = "7512CE9829BC408DFDD38505D289D8D9", hash_generated_method = "759FE285685D2D6F5C8C62BAA5F6D928")
    protected  InnerNodeImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.892 -0400", hash_original_method = "32EEE6618A157AF1714C0ED00AB24628", hash_generated_method = "E3B69B8E584C03A3D3A28E505EAE721C")
    public Node appendChild(Node newChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_1865963086 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1865963086 = insertChildAt(newChild, children.size());
        addTaint(newChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1865963086.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1865963086;
        // ---------- Original Method ----------
        //return insertChildAt(newChild, children.size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.910 -0400", hash_original_method = "8F58F724DAE50380735EAE0A1E873E0C", hash_generated_method = "1F43C130538E396FE80E68A61CB46520")
    public NodeList getChildNodes() {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_976706192 = null; //Variable for return #1
        NodeListImpl list;
        list = new NodeListImpl();
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_651321119 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_651321119.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_651321119.next();
            {
                list.add(node);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_976706192 = list;
        varB4EAC82CA7396A68D541C85D26508E83_976706192.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_976706192;
        // ---------- Original Method ----------
        //NodeListImpl list = new NodeListImpl();
        //for (NodeImpl node : children) {
            //list.add(node);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.911 -0400", hash_original_method = "135BB34C460FCFA99784841F3EF5F177", hash_generated_method = "F27DDD23E73CC7966B0121DFE5641491")
    public Node getFirstChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1583296884 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1583296884 = (!children.isEmpty() ? children.get(0) : null);
        varB4EAC82CA7396A68D541C85D26508E83_1583296884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1583296884;
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(0) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.912 -0400", hash_original_method = "56E890D8D2E0854FB8D72E107BF6DE5B", hash_generated_method = "76445D986F5BDFFE084357CA2FA50305")
    public Node getLastChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1205687816 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1205687816 = (!children.isEmpty() ? children.get(children.size() - 1) : null);
        varB4EAC82CA7396A68D541C85D26508E83_1205687816.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1205687816;
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(children.size() - 1) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.913 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "648D6C8F29ECE5E4550307809AA07412")
    public Node getNextSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_117388242 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_1215688574 = null; //Variable for return #2
        {
            boolean var95B22E1313A32C2512A690CDD98132D0_2083027361 = (parent == null || index + 1 >= parent.children.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_117388242 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1215688574 = parent.children.get(index + 1);
        Node varA7E53CE21691AB073D9660D615818899_469735438; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_469735438 = varB4EAC82CA7396A68D541C85D26508E83_117388242;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_469735438 = varB4EAC82CA7396A68D541C85D26508E83_1215688574;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_469735438.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_469735438;
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.931 -0400", hash_original_method = "6A6B7C4F52A3C0800D99001450A25AF3", hash_generated_method = "3517E0F09ED84619A92BD159DF471388")
    public boolean hasChildNodes() {
        boolean var8262366BE5FECA43DE8839E89CC7AF71_2072953113 = (children.size() != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711924147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711924147;
        // ---------- Original Method ----------
        //return children.size() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.942 -0400", hash_original_method = "DC35B4AC23E21A549DCF9BD17D39CB3A", hash_generated_method = "F247C901E20B815FC82621A1B98150F9")
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_1309233852 = null; //Variable for return #1
        LeafNodeImpl refChildImpl;
        refChildImpl = (LeafNodeImpl) refChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var1B4D1136BBE144D03083FB7AFA2D14A8_1570800633 = (refChildImpl.parent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1309233852 = insertChildAt(newChild, refChildImpl.index);
        addTaint(newChild.getTaint());
        addTaint(refChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1309233852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1309233852;
        // ---------- Original Method ----------
        //LeafNodeImpl refChildImpl = (LeafNodeImpl) refChild;
        //if (refChildImpl.document != document) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //if (refChildImpl.parent != this) {
            //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        //}
        //return insertChildAt(newChild, refChildImpl.index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.943 -0400", hash_original_method = "CC52893233A8017E84157556EAC90FCB", hash_generated_method = "38FC579AB76447FB59F2A2B4A3B566D9")
     Node insertChildAt(Node newChild, int index) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_1503538586 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_1923866757 = null; //Variable for return #2
        {
            NodeList toAdd;
            toAdd = newChild.getChildNodes();
            {
                int i;
                i = 0;
                boolean varDC934698E25916C2FABFA381BD4DE9B7_1124975825 = (i < toAdd.getLength());
                {
                    insertChildAt(toAdd.item(i), index + i);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1503538586 = newChild;
        } //End block
        LeafNodeImpl toInsert;
        toInsert = (LeafNodeImpl) newChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var7E521D440FB130E09B2CF2E8B50E4EB7_1016150528 = (toInsert.isParentOf(this));
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
        } //End collapsed parenthetic
        {
            int oldIndex;
            oldIndex = toInsert.index;
            toInsert.parent.children.remove(oldIndex);
            toInsert.parent.refreshIndices(oldIndex);
        } //End block
        children.add(index, toInsert);
        toInsert.parent = this;
        refreshIndices(index);
        varB4EAC82CA7396A68D541C85D26508E83_1923866757 = newChild;
        addTaint(newChild.getTaint());
        addTaint(index);
        Node varA7E53CE21691AB073D9660D615818899_1490694463; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1490694463 = varB4EAC82CA7396A68D541C85D26508E83_1503538586;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1490694463 = varB4EAC82CA7396A68D541C85D26508E83_1923866757;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1490694463.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1490694463;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.944 -0400", hash_original_method = "EAC92D1975EC52765900D3EB8DB15DFE", hash_generated_method = "DACF8704E4C8D5C63570C00BE2A486CF")
    public boolean isParentOf(Node node) {
        LeafNodeImpl nodeImpl;
        nodeImpl = (LeafNodeImpl) node;
        {
            {
                boolean var9D4CF3D60302A27824664D3E7562F2BC_176794403 = (nodeImpl == this);
            } //End collapsed parenthetic
            nodeImpl = nodeImpl.parent;
        } //End block
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1982043744 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1982043744;
        // ---------- Original Method ----------
        //LeafNodeImpl nodeImpl = (LeafNodeImpl) node;
        //while (nodeImpl != null) {
            //if (nodeImpl == this) {
                //return true;
            //}
            //nodeImpl = nodeImpl.parent;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.952 -0400", hash_original_method = "2E387D6B5E2ABD0B7044442BD7493DDC", hash_generated_method = "F6827E153902ED8A3D7BEB499DE641C7")
    @Override
    public final void normalize() {
        Node next;
        {
            Node node;
            node = getFirstChild();
            node = next;
            {
                next = node.getNextSibling();
                node.normalize();
                {
                    boolean var2628A96A2868983DC825715150B653A5_1833173965 = (node.getNodeType() == Node.TEXT_NODE);
                    {
                        ((TextImpl) node).minimize();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Node next;
        //for (Node node = getFirstChild(); node != null; node = next) {
            //next = node.getNextSibling();
            //node.normalize();
            //if (node.getNodeType() == Node.TEXT_NODE) {
                //((TextImpl) node).minimize();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.954 -0400", hash_original_method = "228203F3C91B72F7B5E602122B5A1790", hash_generated_method = "4761AE3594F0B455B6FD286C27F290CD")
    private void refreshIndices(int fromIndex) {
        {
            int i;
            i = fromIndex;
            boolean varB0E66E6EEC032D7C731F1288248DA7B2_398654190 = (i < children.size());
            {
                children.get(i).index = i;
            } //End block
        } //End collapsed parenthetic
        addTaint(fromIndex);
        // ---------- Original Method ----------
        //for (int i = fromIndex; i < children.size(); i++) {
            //children.get(i).index = i;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.955 -0400", hash_original_method = "45F8FB3BF08F1B2108957574E4D1D247", hash_generated_method = "52539322F409D0A5C1833719123C3576")
    public Node removeChild(Node oldChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_664930422 = null; //Variable for return #1
        LeafNodeImpl oldChildImpl;
        oldChildImpl = (LeafNodeImpl) oldChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var5B2AAC709E2BC750B78267487F1388BF_178493178 = (oldChildImpl.parent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
        } //End collapsed parenthetic
        int index;
        index = oldChildImpl.index;
        children.remove(index);
        oldChildImpl.parent = null;
        refreshIndices(index);
        varB4EAC82CA7396A68D541C85D26508E83_664930422 = oldChild;
        addTaint(oldChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_664930422.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_664930422;
        // ---------- Original Method ----------
        //LeafNodeImpl oldChildImpl = (LeafNodeImpl) oldChild;
        //if (oldChildImpl.document != document) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //if (oldChildImpl.parent != this) {
            //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        //}
        //int index = oldChildImpl.index;
        //children.remove(index);
        //oldChildImpl.parent = null;
        //refreshIndices(index);
        //return oldChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.961 -0400", hash_original_method = "7E92B523792E0B3571F5728856964E5D", hash_generated_method = "5E4F87F250E5390F86850DC669C306DD")
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_93224775 = null; //Variable for return #1
        int index;
        index = ((LeafNodeImpl) oldChild).index;
        removeChild(oldChild);
        insertChildAt(newChild, index);
        varB4EAC82CA7396A68D541C85D26508E83_93224775 = oldChild;
        addTaint(newChild.getTaint());
        addTaint(oldChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_93224775.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93224775;
        // ---------- Original Method ----------
        //int index = ((LeafNodeImpl) oldChild).index;
        //removeChild(oldChild);
        //insertChildAt(newChild, index);
        //return oldChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.976 -0400", hash_original_method = "32F8137481F8B7A6AF322114BC5A4B22", hash_generated_method = "E3A9993606AB2D11D1214F9A6717A577")
    public String getTextContent() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_1190368675 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1587427157 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1179315549 = null; //Variable for return #3
        Node child;
        child = getFirstChild();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1190368675 = "";
        } //End block
        Node next;
        next = child.getNextSibling();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1587427157 = hasTextContent(child) ? child.getTextContent() : "";
        } //End block
        StringBuilder buf;
        buf = new StringBuilder();
        getTextContent(buf);
        varB4EAC82CA7396A68D541C85D26508E83_1179315549 = buf.toString();
        String varA7E53CE21691AB073D9660D615818899_1510172427; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1510172427 = varB4EAC82CA7396A68D541C85D26508E83_1190368675;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1510172427 = varB4EAC82CA7396A68D541C85D26508E83_1587427157;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1510172427 = varB4EAC82CA7396A68D541C85D26508E83_1179315549;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1510172427.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1510172427;
        // ---------- Original Method ----------
        //Node child = getFirstChild();
        //if (child == null) {
            //return "";
        //}
        //Node next = child.getNextSibling();
        //if (next == null) {
            //return hasTextContent(child) ? child.getTextContent() : "";
        //}
        //StringBuilder buf = new StringBuilder();
        //getTextContent(buf);
        //return buf.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.976 -0400", hash_original_method = "1B7875C51CF051392D3264002D3285E5", hash_generated_method = "E8748B431A16A5626D1BB31F394B48C6")
     void getTextContent(StringBuilder buf) throws DOMException {
        Node child;
        child = getFirstChild();
        {
            {
                boolean var98835D1F8A8D94D5FD916EC0A96C3236_1408149946 = (hasTextContent(child));
                {
                    ((NodeImpl) child).getTextContent(buf);
                } //End block
            } //End collapsed parenthetic
            child = child.getNextSibling();
        } //End block
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //Node child = getFirstChild();
        //while (child != null) {
            //if (hasTextContent(child)) {
                //((NodeImpl) child).getTextContent(buf);
            //}
            //child = child.getNextSibling();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.976 -0400", hash_original_method = "8BE6B36212848E97AA53F8A83F869F11", hash_generated_method = "0180C5E14D28BD7CADE5C6AD20BAB826")
    final boolean hasTextContent(Node child) {
        boolean varC323A2C407A7388B602A20BDD170C827_1914122194 = (child.getNodeType() != Node.COMMENT_NODE
                && child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE);
        addTaint(child.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_548694620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_548694620;
        // ---------- Original Method ----------
        //return child.getNodeType() != Node.COMMENT_NODE
                //&& child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.995 -0400", hash_original_method = "FBC9DCE28E1410ABABC4D8105012C635", hash_generated_method = "9CD2C842206ACF9054A60F23B16B892A")
     void getElementsByTagName(NodeListImpl out, String name) {
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_113772619 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_113772619.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_113772619.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_100269512 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        ElementImpl element;
                        element = (ElementImpl) node;
                        {
                            boolean varF984C71D0812111CE29297C56DC1B9F6_1155775456 = (matchesNameOrWildcard(name, element.getNodeName()));
                            {
                                out.add(element);
                            } //End block
                        } //End collapsed parenthetic
                        element.getElementsByTagName(out, name);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(out.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //for (NodeImpl node : children) {
            //if (node.getNodeType() == Node.ELEMENT_NODE) {
                //ElementImpl element = (ElementImpl) node;
                //if (matchesNameOrWildcard(name, element.getNodeName())) {
                    //out.add(element);
                //}
                //element.getElementsByTagName(out, name);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.021 -0400", hash_original_method = "E06ADC8546BD526D25CE87ECAD401587", hash_generated_method = "BA133D15F1C713D64744BA088C439971")
     void getElementsByTagNameNS(NodeListImpl out, String namespaceURI, String localName) {
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_1532448870 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_1532448870.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_1532448870.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_1228267972 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        ElementImpl element;
                        element = (ElementImpl) node;
                        {
                            boolean varA44D031206E1B3571B84811D648E0917_921581161 = (matchesNameOrWildcard(namespaceURI, element.getNamespaceURI())
                        && matchesNameOrWildcard(localName, element.getLocalName()));
                            {
                                out.add(element);
                            } //End block
                        } //End collapsed parenthetic
                        element.getElementsByTagNameNS(out, namespaceURI, localName);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(out.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        // ---------- Original Method ----------
        //for (NodeImpl node : children) {
            //if (node.getNodeType() == Node.ELEMENT_NODE) {
                //ElementImpl element = (ElementImpl) node;
                //if (matchesNameOrWildcard(namespaceURI, element.getNamespaceURI())
                        //&& matchesNameOrWildcard(localName, element.getLocalName())) {
                    //out.add(element);
                //}
                //element.getElementsByTagNameNS(out, namespaceURI, localName);
            //}
        //}
    }

    
        private static boolean matchesNameOrWildcard(String pattern, String s) {
        return "*".equals(pattern) || Objects.equal(pattern, s);
    }

    
}

