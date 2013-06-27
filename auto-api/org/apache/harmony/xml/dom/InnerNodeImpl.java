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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.011 -0400", hash_original_field = "F003D44A4CF514277D9944C7A47DACA3", hash_generated_field = "B027621B27AE52A5595EFB742F1A4AE3")

    List<LeafNodeImpl> children = new ArrayList<LeafNodeImpl>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.011 -0400", hash_original_method = "7512CE9829BC408DFDD38505D289D8D9", hash_generated_method = "759FE285685D2D6F5C8C62BAA5F6D928")
    protected  InnerNodeImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.012 -0400", hash_original_method = "32EEE6618A157AF1714C0ED00AB24628", hash_generated_method = "D398BB1B98CF19360CC914F95669AD98")
    public Node appendChild(Node newChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_710013110 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_710013110 = insertChildAt(newChild, children.size());
        addTaint(newChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_710013110.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_710013110;
        // ---------- Original Method ----------
        //return insertChildAt(newChild, children.size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.016 -0400", hash_original_method = "8F58F724DAE50380735EAE0A1E873E0C", hash_generated_method = "0EE42C3FBCF2EA55254B447CD3BAEF52")
    public NodeList getChildNodes() {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_2027841981 = null; //Variable for return #1
        NodeListImpl list;
        list = new NodeListImpl();
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_1524363282 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_1524363282.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_1524363282.next();
            {
                list.add(node);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2027841981 = list;
        varB4EAC82CA7396A68D541C85D26508E83_2027841981.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2027841981;
        // ---------- Original Method ----------
        //NodeListImpl list = new NodeListImpl();
        //for (NodeImpl node : children) {
            //list.add(node);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.023 -0400", hash_original_method = "135BB34C460FCFA99784841F3EF5F177", hash_generated_method = "18A31D763D24087EAB1F435C098B0AE7")
    public Node getFirstChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1992863903 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1992863903 = (!children.isEmpty() ? children.get(0) : null);
        varB4EAC82CA7396A68D541C85D26508E83_1992863903.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1992863903;
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(0) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.036 -0400", hash_original_method = "56E890D8D2E0854FB8D72E107BF6DE5B", hash_generated_method = "1EF515937BB0196C59EBC6013B7D599B")
    public Node getLastChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_128147047 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_128147047 = (!children.isEmpty() ? children.get(children.size() - 1) : null);
        varB4EAC82CA7396A68D541C85D26508E83_128147047.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_128147047;
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(children.size() - 1) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.037 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "C63F983193EB59DD96E730DF214E0D4A")
    public Node getNextSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1549004729 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_1676413564 = null; //Variable for return #2
        {
            boolean var95B22E1313A32C2512A690CDD98132D0_1232521065 = (parent == null || index + 1 >= parent.children.size());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1549004729 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1676413564 = parent.children.get(index + 1);
        Node varA7E53CE21691AB073D9660D615818899_132652946; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_132652946 = varB4EAC82CA7396A68D541C85D26508E83_1549004729;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_132652946 = varB4EAC82CA7396A68D541C85D26508E83_1676413564;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_132652946.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_132652946;
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.037 -0400", hash_original_method = "6A6B7C4F52A3C0800D99001450A25AF3", hash_generated_method = "B6A5BF76E765A2BA9F03EB09D268CC1A")
    public boolean hasChildNodes() {
        boolean var8262366BE5FECA43DE8839E89CC7AF71_1911628108 = (children.size() != 0);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_960783490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_960783490;
        // ---------- Original Method ----------
        //return children.size() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.038 -0400", hash_original_method = "DC35B4AC23E21A549DCF9BD17D39CB3A", hash_generated_method = "656D42E1B2314085CE006E3D34021083")
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_1372542752 = null; //Variable for return #1
        LeafNodeImpl refChildImpl;
        refChildImpl = (LeafNodeImpl) refChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var1B4D1136BBE144D03083FB7AFA2D14A8_566799058 = (refChildImpl.parent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1372542752 = insertChildAt(newChild, refChildImpl.index);
        addTaint(newChild.getTaint());
        addTaint(refChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1372542752.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1372542752;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.039 -0400", hash_original_method = "CC52893233A8017E84157556EAC90FCB", hash_generated_method = "A66649F5D19D403BA31D809B7680F20D")
     Node insertChildAt(Node newChild, int index) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_1455702390 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_838894875 = null; //Variable for return #2
        {
            NodeList toAdd;
            toAdd = newChild.getChildNodes();
            {
                int i;
                i = 0;
                boolean varDC934698E25916C2FABFA381BD4DE9B7_924281279 = (i < toAdd.getLength());
                {
                    insertChildAt(toAdd.item(i), index + i);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1455702390 = newChild;
        } //End block
        LeafNodeImpl toInsert;
        toInsert = (LeafNodeImpl) newChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var7E521D440FB130E09B2CF2E8B50E4EB7_67668897 = (toInsert.isParentOf(this));
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
        varB4EAC82CA7396A68D541C85D26508E83_838894875 = newChild;
        addTaint(newChild.getTaint());
        addTaint(index);
        Node varA7E53CE21691AB073D9660D615818899_1242158704; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1242158704 = varB4EAC82CA7396A68D541C85D26508E83_1455702390;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1242158704 = varB4EAC82CA7396A68D541C85D26508E83_838894875;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1242158704.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1242158704;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.039 -0400", hash_original_method = "EAC92D1975EC52765900D3EB8DB15DFE", hash_generated_method = "51A1E8AA0AB7BC5D3CFC390161B33C6E")
    public boolean isParentOf(Node node) {
        LeafNodeImpl nodeImpl;
        nodeImpl = (LeafNodeImpl) node;
        {
            {
                boolean var9D4CF3D60302A27824664D3E7562F2BC_583269063 = (nodeImpl == this);
            } //End collapsed parenthetic
            nodeImpl = nodeImpl.parent;
        } //End block
        addTaint(node.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_755545274 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_755545274;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.040 -0400", hash_original_method = "2E387D6B5E2ABD0B7044442BD7493DDC", hash_generated_method = "38BAB3ABF4464025042790C1A23AD41E")
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
                    boolean var2628A96A2868983DC825715150B653A5_663679908 = (node.getNodeType() == Node.TEXT_NODE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.051 -0400", hash_original_method = "228203F3C91B72F7B5E602122B5A1790", hash_generated_method = "A93A7E686E7C375ED64B9067505DF45B")
    private void refreshIndices(int fromIndex) {
        {
            int i;
            i = fromIndex;
            boolean varB0E66E6EEC032D7C731F1288248DA7B2_1749243274 = (i < children.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.051 -0400", hash_original_method = "45F8FB3BF08F1B2108957574E4D1D247", hash_generated_method = "779282C2B9F7693458BED9EB003E5614")
    public Node removeChild(Node oldChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_699244732 = null; //Variable for return #1
        LeafNodeImpl oldChildImpl;
        oldChildImpl = (LeafNodeImpl) oldChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var5B2AAC709E2BC750B78267487F1388BF_125741918 = (oldChildImpl.parent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
        } //End collapsed parenthetic
        int index;
        index = oldChildImpl.index;
        children.remove(index);
        oldChildImpl.parent = null;
        refreshIndices(index);
        varB4EAC82CA7396A68D541C85D26508E83_699244732 = oldChild;
        addTaint(oldChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_699244732.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_699244732;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.052 -0400", hash_original_method = "7E92B523792E0B3571F5728856964E5D", hash_generated_method = "669A835DD111D074BD6DEEF63F404996")
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        Node varB4EAC82CA7396A68D541C85D26508E83_1787254220 = null; //Variable for return #1
        int index;
        index = ((LeafNodeImpl) oldChild).index;
        removeChild(oldChild);
        insertChildAt(newChild, index);
        varB4EAC82CA7396A68D541C85D26508E83_1787254220 = oldChild;
        addTaint(newChild.getTaint());
        addTaint(oldChild.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1787254220.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1787254220;
        // ---------- Original Method ----------
        //int index = ((LeafNodeImpl) oldChild).index;
        //removeChild(oldChild);
        //insertChildAt(newChild, index);
        //return oldChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.055 -0400", hash_original_method = "32F8137481F8B7A6AF322114BC5A4B22", hash_generated_method = "0FE055DF89ECE22D94BA06ED2F8045A6")
    public String getTextContent() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_949654266 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1805539165 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1236811978 = null; //Variable for return #3
        Node child;
        child = getFirstChild();
        {
            varB4EAC82CA7396A68D541C85D26508E83_949654266 = "";
        } //End block
        Node next;
        next = child.getNextSibling();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1805539165 = hasTextContent(child) ? child.getTextContent() : "";
        } //End block
        StringBuilder buf;
        buf = new StringBuilder();
        getTextContent(buf);
        varB4EAC82CA7396A68D541C85D26508E83_1236811978 = buf.toString();
        String varA7E53CE21691AB073D9660D615818899_1954507363; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1954507363 = varB4EAC82CA7396A68D541C85D26508E83_949654266;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1954507363 = varB4EAC82CA7396A68D541C85D26508E83_1805539165;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1954507363 = varB4EAC82CA7396A68D541C85D26508E83_1236811978;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1954507363.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1954507363;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.062 -0400", hash_original_method = "1B7875C51CF051392D3264002D3285E5", hash_generated_method = "E47EA28E13A0EB1566E9A377D8215D10")
     void getTextContent(StringBuilder buf) throws DOMException {
        Node child;
        child = getFirstChild();
        {
            {
                boolean var98835D1F8A8D94D5FD916EC0A96C3236_1272478886 = (hasTextContent(child));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.062 -0400", hash_original_method = "8BE6B36212848E97AA53F8A83F869F11", hash_generated_method = "362A59CD750B7BCE44EBE445459971D8")
    final boolean hasTextContent(Node child) {
        boolean varC323A2C407A7388B602A20BDD170C827_645970696 = (child.getNodeType() != Node.COMMENT_NODE
                && child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE);
        addTaint(child.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1823226279 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1823226279;
        // ---------- Original Method ----------
        //return child.getNodeType() != Node.COMMENT_NODE
                //&& child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.100 -0400", hash_original_method = "FBC9DCE28E1410ABABC4D8105012C635", hash_generated_method = "DE68D5FDD16F4EF1B56A05BBC907A333")
     void getElementsByTagName(NodeListImpl out, String name) {
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_822351614 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_822351614.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_822351614.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_409483550 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        ElementImpl element;
                        element = (ElementImpl) node;
                        {
                            boolean varF984C71D0812111CE29297C56DC1B9F6_1759497299 = (matchesNameOrWildcard(name, element.getNodeName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.138 -0400", hash_original_method = "E06ADC8546BD526D25CE87ECAD401587", hash_generated_method = "669D3A6A6C843EC8A7245F23CD048FFB")
     void getElementsByTagNameNS(NodeListImpl out, String namespaceURI, String localName) {
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_976661743 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_976661743.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_976661743.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_834286700 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        ElementImpl element;
                        element = (ElementImpl) node;
                        {
                            boolean varA44D031206E1B3571B84811D648E0917_1388439135 = (matchesNameOrWildcard(namespaceURI, element.getNamespaceURI())
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

