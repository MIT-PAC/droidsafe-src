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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.152 -0400", hash_original_field = "F003D44A4CF514277D9944C7A47DACA3", hash_generated_field = "B027621B27AE52A5595EFB742F1A4AE3")

    List<LeafNodeImpl> children = new ArrayList<LeafNodeImpl>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.153 -0400", hash_original_method = "7512CE9829BC408DFDD38505D289D8D9", hash_generated_method = "759FE285685D2D6F5C8C62BAA5F6D928")
    protected  InnerNodeImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.153 -0400", hash_original_method = "32EEE6618A157AF1714C0ED00AB24628", hash_generated_method = "3BE78595340C295BF7677E8D97B14732")
    public Node appendChild(Node newChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_1344493555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1344493555 = insertChildAt(newChild, children.size());
        addTaint(newChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1344493555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1344493555;
        // ---------- Original Method ----------
        //return insertChildAt(newChild, children.size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.156 -0400", hash_original_method = "8F58F724DAE50380735EAE0A1E873E0C", hash_generated_method = "45BEDA59B4C28D2B4FA69A30EA62B35E")
    public NodeList getChildNodes() {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_172396503 = null; //Variable for return #1
        NodeListImpl list = new NodeListImpl();
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_1663059677 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_1663059677.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_1663059677.next();
            {
                list.add(node);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_172396503 = list;
        varB4EAC82CA7396A68D541C85D26508E83_172396503.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_172396503;
        // ---------- Original Method ----------
        //NodeListImpl list = new NodeListImpl();
        //for (NodeImpl node : children) {
            //list.add(node);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.157 -0400", hash_original_method = "135BB34C460FCFA99784841F3EF5F177", hash_generated_method = "D3EBA45A22ED9C76EF16FB3C0E28F989")
    public Node getFirstChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_293149901 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_293149901 = (!children.isEmpty() ? children.get(0) : null);
        varB4EAC82CA7396A68D541C85D26508E83_293149901.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_293149901;
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(0) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.157 -0400", hash_original_method = "56E890D8D2E0854FB8D72E107BF6DE5B", hash_generated_method = "6DA9516340C70B02D5F3E63F9CC0E230")
    public Node getLastChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_119990776 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_119990776 = (!children.isEmpty() ? children.get(children.size() - 1) : null);
        varB4EAC82CA7396A68D541C85D26508E83_119990776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_119990776;
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(children.size() - 1) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.158 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "7A3DD37A55FAF2DFD7F02325C2EF0026")
    public Node getNextSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1971876975 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_1136487545 = null; //Variable for return #2
        {
            boolean var95B22E1313A32C2512A690CDD98132D0_1887705486 = (parent == null || index + 1 >= parent.children.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1971876975 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1136487545 = parent.children.get(index + 1);
        Node varA7E53CE21691AB073D9660D615818899_443790838; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_443790838 = varB4EAC82CA7396A68D541C85D26508E83_1971876975;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_443790838 = varB4EAC82CA7396A68D541C85D26508E83_1136487545;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_443790838.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_443790838;
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.158 -0400", hash_original_method = "6A6B7C4F52A3C0800D99001450A25AF3", hash_generated_method = "9A4CA3AEABEF93C4173F7E907811F24C")
    public boolean hasChildNodes() {
        boolean var8262366BE5FECA43DE8839E89CC7AF71_758578677 = (children.size() != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_631166447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_631166447;
        // ---------- Original Method ----------
        //return children.size() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.159 -0400", hash_original_method = "DC35B4AC23E21A549DCF9BD17D39CB3A", hash_generated_method = "6709D357A896A422CE8E8C2D737F8DE2")
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_56515754 = null; //Variable for return #1
        LeafNodeImpl refChildImpl = (LeafNodeImpl) refChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var1B4D1136BBE144D03083FB7AFA2D14A8_210676975 = (refChildImpl.parent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_56515754 = insertChildAt(newChild, refChildImpl.index);
        addTaint(newChild.getTaint());
        addTaint(refChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_56515754.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_56515754;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.159 -0400", hash_original_method = "CC52893233A8017E84157556EAC90FCB", hash_generated_method = "BBDCB0F1140CC47CDCDA208F935DE350")
     Node insertChildAt(Node newChild, int index) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_2090503090 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_472319982 = null; //Variable for return #2
        {
            NodeList toAdd = newChild.getChildNodes();
            {
                int i = 0;
                boolean varDC934698E25916C2FABFA381BD4DE9B7_1655453949 = (i < toAdd.getLength());
                {
                    insertChildAt(toAdd.item(i), index + i);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_2090503090 = newChild;
        } //End block
        LeafNodeImpl toInsert = (LeafNodeImpl) newChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var7E521D440FB130E09B2CF2E8B50E4EB7_1767827122 = (toInsert.isParentOf(this));
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
        } //End collapsed parenthetic
        {
            int oldIndex = toInsert.index;
            toInsert.parent.children.remove(oldIndex);
            toInsert.parent.refreshIndices(oldIndex);
        } //End block
        children.add(index, toInsert);
        toInsert.parent = this;
        refreshIndices(index);
        varB4EAC82CA7396A68D541C85D26508E83_472319982 = newChild;
        addTaint(newChild.getTaint());
        addTaint(index);
        Node varA7E53CE21691AB073D9660D615818899_233371759; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_233371759 = varB4EAC82CA7396A68D541C85D26508E83_2090503090;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_233371759 = varB4EAC82CA7396A68D541C85D26508E83_472319982;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_233371759.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_233371759;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.160 -0400", hash_original_method = "EAC92D1975EC52765900D3EB8DB15DFE", hash_generated_method = "AB4960E58E47B5BBBFA777AB2053BB48")
    public boolean isParentOf(Node node) {
        LeafNodeImpl nodeImpl = (LeafNodeImpl) node;
        {
            {
                boolean var9D4CF3D60302A27824664D3E7562F2BC_931775404 = (nodeImpl == this);
            } //End collapsed parenthetic
            nodeImpl = nodeImpl.parent;
        } //End block
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_366769915 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_366769915;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.160 -0400", hash_original_method = "2E387D6B5E2ABD0B7044442BD7493DDC", hash_generated_method = "D16AA0D292629F344208EC0D260A51E0")
    @Override
    public final void normalize() {
        Node next;
        {
            Node node = getFirstChild();
            node = next;
            {
                next = node.getNextSibling();
                node.normalize();
                {
                    boolean var2628A96A2868983DC825715150B653A5_1596789942 = (node.getNodeType() == Node.TEXT_NODE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.161 -0400", hash_original_method = "228203F3C91B72F7B5E602122B5A1790", hash_generated_method = "2BF58871AFAA6F95F56C11D06695DC3D")
    private void refreshIndices(int fromIndex) {
        {
            int i = fromIndex;
            boolean varB0E66E6EEC032D7C731F1288248DA7B2_1664868945 = (i < children.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.161 -0400", hash_original_method = "45F8FB3BF08F1B2108957574E4D1D247", hash_generated_method = "0D3037A9089DA96F0CDF4DB6EA291AE0")
    public Node removeChild(Node oldChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_340935107 = null; //Variable for return #1
        LeafNodeImpl oldChildImpl = (LeafNodeImpl) oldChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var5B2AAC709E2BC750B78267487F1388BF_1118933041 = (oldChildImpl.parent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
        } //End collapsed parenthetic
        int index = oldChildImpl.index;
        children.remove(index);
        oldChildImpl.parent = null;
        refreshIndices(index);
        varB4EAC82CA7396A68D541C85D26508E83_340935107 = oldChild;
        addTaint(oldChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_340935107.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_340935107;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.162 -0400", hash_original_method = "7E92B523792E0B3571F5728856964E5D", hash_generated_method = "212DF1DAB7694C64D79CCDA51774D534")
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_651169415 = null; //Variable for return #1
        int index = ((LeafNodeImpl) oldChild).index;
        removeChild(oldChild);
        insertChildAt(newChild, index);
        varB4EAC82CA7396A68D541C85D26508E83_651169415 = oldChild;
        addTaint(newChild.getTaint());
        addTaint(oldChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_651169415.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_651169415;
        // ---------- Original Method ----------
        //int index = ((LeafNodeImpl) oldChild).index;
        //removeChild(oldChild);
        //insertChildAt(newChild, index);
        //return oldChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.162 -0400", hash_original_method = "32F8137481F8B7A6AF322114BC5A4B22", hash_generated_method = "0FB325DCD11358B62C1487B4AE570C23")
    public String getTextContent() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_1182284866 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_916584744 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_535653319 = null; //Variable for return #3
        Node child = getFirstChild();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1182284866 = "";
        } //End block
        Node next = child.getNextSibling();
        {
            varB4EAC82CA7396A68D541C85D26508E83_916584744 = hasTextContent(child) ? child.getTextContent() : "";
        } //End block
        StringBuilder buf = new StringBuilder();
        getTextContent(buf);
        varB4EAC82CA7396A68D541C85D26508E83_535653319 = buf.toString();
        String varA7E53CE21691AB073D9660D615818899_623619887; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_623619887 = varB4EAC82CA7396A68D541C85D26508E83_1182284866;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_623619887 = varB4EAC82CA7396A68D541C85D26508E83_916584744;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_623619887 = varB4EAC82CA7396A68D541C85D26508E83_535653319;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_623619887.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_623619887;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.163 -0400", hash_original_method = "1B7875C51CF051392D3264002D3285E5", hash_generated_method = "8216C2862FECA01CE9E5D181948D7462")
     void getTextContent(StringBuilder buf) throws DOMException {
        Node child = getFirstChild();
        {
            {
                boolean var98835D1F8A8D94D5FD916EC0A96C3236_259394397 = (hasTextContent(child));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.163 -0400", hash_original_method = "8BE6B36212848E97AA53F8A83F869F11", hash_generated_method = "E1FAC7BF3D2698ED41C6C85E2A30A5DC")
    final boolean hasTextContent(Node child) {
        boolean varC323A2C407A7388B602A20BDD170C827_1078489033 = (child.getNodeType() != Node.COMMENT_NODE
                && child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE);
        addTaint(child.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_365196824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_365196824;
        // ---------- Original Method ----------
        //return child.getNodeType() != Node.COMMENT_NODE
                //&& child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.170 -0400", hash_original_method = "FBC9DCE28E1410ABABC4D8105012C635", hash_generated_method = "BC7C693F4F82967C67619D63D719B936")
     void getElementsByTagName(NodeListImpl out, String name) {
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_96871479 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_96871479.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_96871479.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_1197527740 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        ElementImpl element = (ElementImpl) node;
                        {
                            boolean varF984C71D0812111CE29297C56DC1B9F6_1745490063 = (matchesNameOrWildcard(name, element.getNodeName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.175 -0400", hash_original_method = "E06ADC8546BD526D25CE87ECAD401587", hash_generated_method = "5FFFFB5011B1E75071E2100E8621C193")
     void getElementsByTagNameNS(NodeListImpl out, String namespaceURI, String localName) {
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_1031272512 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_1031272512.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_1031272512.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_1791516407 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        ElementImpl element = (ElementImpl) node;
                        {
                            boolean varA44D031206E1B3571B84811D648E0917_71673019 = (matchesNameOrWildcard(namespaceURI, element.getNamespaceURI())
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

