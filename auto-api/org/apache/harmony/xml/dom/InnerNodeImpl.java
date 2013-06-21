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
    List<LeafNodeImpl> children = new ArrayList<LeafNodeImpl>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.309 -0400", hash_original_method = "7512CE9829BC408DFDD38505D289D8D9", hash_generated_method = "694E69961ACCFEB3E16D2DEA65A8DDDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected InnerNodeImpl(DocumentImpl document) {
        super(document);
        dsTaint.addTaint(document.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.310 -0400", hash_original_method = "32EEE6618A157AF1714C0ED00AB24628", hash_generated_method = "68B11E56E03AB7C4B70B69564BDD3669")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node appendChild(Node newChild) throws DOMException {
        dsTaint.addTaint(newChild.dsTaint);
        Node var532353D8D83E2D3FFE60EAD01AB8B794_1094349565 = (insertChildAt(newChild, children.size()));
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return insertChildAt(newChild, children.size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.312 -0400", hash_original_method = "8F58F724DAE50380735EAE0A1E873E0C", hash_generated_method = "31B10673EC058899FDDFECE5138A7793")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NodeList getChildNodes() {
        NodeListImpl list;
        list = new NodeListImpl();
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_867527042 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_867527042.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_867527042.next();
            {
                list.add(node);
            } //End block
        } //End collapsed parenthetic
        return (NodeList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //NodeListImpl list = new NodeListImpl();
        //for (NodeImpl node : children) {
            //list.add(node);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.312 -0400", hash_original_method = "135BB34C460FCFA99784841F3EF5F177", hash_generated_method = "89642133C1AA4103D015129784DBAC07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node getFirstChild() {
        Node varDC0652ABD6EF14D8EAA3203108761F4A_1910785162 = ((!children.isEmpty() ? children.get(0) : null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(0) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.312 -0400", hash_original_method = "56E890D8D2E0854FB8D72E107BF6DE5B", hash_generated_method = "5955F9FB89ED70ED55A28FD8DCD08F9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node getLastChild() {
        Node var14E22A41DDD5E98B6F78893B4BA2EA19_1367496953 = ((!children.isEmpty() ? children.get(children.size() - 1) : null)); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(children.size() - 1) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.312 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "552B58FB6188F849C3D9D404F09156FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node getNextSibling() {
        {
            boolean var95B22E1313A32C2512A690CDD98132D0_1636657321 = (parent == null || index + 1 >= parent.children.size());
        } //End collapsed parenthetic
        Node var002A65CD7D092A52936079C9508E6C2F_143440338 = (parent.children.get(index + 1));
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.313 -0400", hash_original_method = "6A6B7C4F52A3C0800D99001450A25AF3", hash_generated_method = "6D4CE7DE26D5A77CBEA4456797CFBABC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasChildNodes() {
        boolean var8262366BE5FECA43DE8839E89CC7AF71_1768274561 = (children.size() != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return children.size() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.313 -0400", hash_original_method = "DC35B4AC23E21A549DCF9BD17D39CB3A", hash_generated_method = "EEBDF01990F1C9AC3C389F377918FBC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        dsTaint.addTaint(refChild.dsTaint);
        dsTaint.addTaint(newChild.dsTaint);
        LeafNodeImpl refChildImpl;
        refChildImpl = (LeafNodeImpl) refChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var1B4D1136BBE144D03083FB7AFA2D14A8_1891078884 = (refChildImpl.parent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
        } //End collapsed parenthetic
        Node var1B822D55AE0D1420C805F01973AD7489_956667467 = (insertChildAt(newChild, refChildImpl.index));
        return (Node)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.313 -0400", hash_original_method = "CC52893233A8017E84157556EAC90FCB", hash_generated_method = "582BCF460CC42F1A8BC0E7D3E404D975")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Node insertChildAt(Node newChild, int index) throws DOMException {
        dsTaint.addTaint(index);
        dsTaint.addTaint(newChild.dsTaint);
        {
            NodeList toAdd;
            toAdd = newChild.getChildNodes();
            {
                int i;
                i = 0;
                boolean varDC934698E25916C2FABFA381BD4DE9B7_1480456669 = (i < toAdd.getLength());
                {
                    insertChildAt(toAdd.item(i), index + i);
                } //End block
            } //End collapsed parenthetic
        } //End block
        LeafNodeImpl toInsert;
        toInsert = (LeafNodeImpl) newChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var7E521D440FB130E09B2CF2E8B50E4EB7_150732900 = (toInsert.isParentOf(this));
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
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.314 -0400", hash_original_method = "EAC92D1975EC52765900D3EB8DB15DFE", hash_generated_method = "AFDE30B243C016C198A4B8A9D873D44F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isParentOf(Node node) {
        dsTaint.addTaint(node.dsTaint);
        LeafNodeImpl nodeImpl;
        nodeImpl = (LeafNodeImpl) node;
        {
            {
                boolean var9D4CF3D60302A27824664D3E7562F2BC_1034536583 = (nodeImpl == this);
            } //End collapsed parenthetic
            nodeImpl = nodeImpl.parent;
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.314 -0400", hash_original_method = "2E387D6B5E2ABD0B7044442BD7493DDC", hash_generated_method = "F6FA2EB40D88E7C5BD96A85B6F964DB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    boolean var2628A96A2868983DC825715150B653A5_390771214 = (node.getNodeType() == Node.TEXT_NODE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.314 -0400", hash_original_method = "228203F3C91B72F7B5E602122B5A1790", hash_generated_method = "1A4673BA35C434E3A4A39713DD6B81AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void refreshIndices(int fromIndex) {
        dsTaint.addTaint(fromIndex);
        {
            int i;
            i = fromIndex;
            boolean varB0E66E6EEC032D7C731F1288248DA7B2_994441289 = (i < children.size());
            {
                children.get(i).index = i;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = fromIndex; i < children.size(); i++) {
            //children.get(i).index = i;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.314 -0400", hash_original_method = "45F8FB3BF08F1B2108957574E4D1D247", hash_generated_method = "CB3DFD5559D06C561222D9220332591C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node removeChild(Node oldChild) throws DOMException {
        dsTaint.addTaint(oldChild.dsTaint);
        LeafNodeImpl oldChildImpl;
        oldChildImpl = (LeafNodeImpl) oldChild;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var5B2AAC709E2BC750B78267487F1388BF_512344659 = (oldChildImpl.parent != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
        } //End collapsed parenthetic
        int index;
        index = oldChildImpl.index;
        children.remove(index);
        oldChildImpl.parent = null;
        refreshIndices(index);
        return (Node)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.315 -0400", hash_original_method = "7E92B523792E0B3571F5728856964E5D", hash_generated_method = "CF957ED96FFBD5A7950CA2E7F34AA31E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        dsTaint.addTaint(oldChild.dsTaint);
        dsTaint.addTaint(newChild.dsTaint);
        int index;
        index = ((LeafNodeImpl) oldChild).index;
        removeChild(oldChild);
        insertChildAt(newChild, index);
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int index = ((LeafNodeImpl) oldChild).index;
        //removeChild(oldChild);
        //insertChildAt(newChild, index);
        //return oldChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.315 -0400", hash_original_method = "32F8137481F8B7A6AF322114BC5A4B22", hash_generated_method = "3E94A71EEF9E598B853CF50AD728488D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTextContent() throws DOMException {
        Node child;
        child = getFirstChild();
        Node next;
        next = child.getNextSibling();
        {
            {
                boolean var98835D1F8A8D94D5FD916EC0A96C3236_595396900 = (hasTextContent(child));
                Object varD873343AACD2CC5E43882F61A4C4A322_1251470511 = (child.getTextContent());
            } //End flattened ternary
        } //End block
        StringBuilder buf;
        buf = new StringBuilder();
        getTextContent(buf);
        String var0C174602EFE4BFBCB80A7056CFA680FB_794537330 = (buf.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.316 -0400", hash_original_method = "1B7875C51CF051392D3264002D3285E5", hash_generated_method = "0C2E3913423F0E1217FD32198966F127")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void getTextContent(StringBuilder buf) throws DOMException {
        dsTaint.addTaint(buf.dsTaint);
        Node child;
        child = getFirstChild();
        {
            {
                boolean var98835D1F8A8D94D5FD916EC0A96C3236_1919644361 = (hasTextContent(child));
                {
                    ((NodeImpl) child).getTextContent(buf);
                } //End block
            } //End collapsed parenthetic
            child = child.getNextSibling();
        } //End block
        // ---------- Original Method ----------
        //Node child = getFirstChild();
        //while (child != null) {
            //if (hasTextContent(child)) {
                //((NodeImpl) child).getTextContent(buf);
            //}
            //child = child.getNextSibling();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.316 -0400", hash_original_method = "8BE6B36212848E97AA53F8A83F869F11", hash_generated_method = "C99635AD6747A7987AE7C3AC9C03F157")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean hasTextContent(Node child) {
        dsTaint.addTaint(child.dsTaint);
        boolean varC323A2C407A7388B602A20BDD170C827_1770755553 = (child.getNodeType() != Node.COMMENT_NODE
                && child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return child.getNodeType() != Node.COMMENT_NODE
                //&& child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.328 -0400", hash_original_method = "FBC9DCE28E1410ABABC4D8105012C635", hash_generated_method = "43804E7F8A70F20C5298C473FEBF6351")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void getElementsByTagName(NodeListImpl out, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(out.dsTaint);
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_2125176453 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_2125176453.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_2125176453.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_634620811 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        ElementImpl element;
                        element = (ElementImpl) node;
                        {
                            boolean varF984C71D0812111CE29297C56DC1B9F6_3680566 = (matchesNameOrWildcard(name, element.getNodeName()));
                            {
                                out.add(element);
                            } //End block
                        } //End collapsed parenthetic
                        element.getElementsByTagName(out, name);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.335 -0400", hash_original_method = "E06ADC8546BD526D25CE87ECAD401587", hash_generated_method = "5D04959488DF6267351BF5715BD5D2FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void getElementsByTagNameNS(NodeListImpl out, String namespaceURI, String localName) {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(namespaceURI);
        dsTaint.addTaint(out.dsTaint);
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_1732062133 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_1732062133.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_1732062133.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_1802092352 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        ElementImpl element;
                        element = (ElementImpl) node;
                        {
                            boolean varA44D031206E1B3571B84811D648E0917_296282750 = (matchesNameOrWildcard(namespaceURI, element.getNamespaceURI())
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

