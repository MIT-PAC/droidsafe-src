package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.List;
import libcore.util.Objects;
import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class InnerNodeImpl extends LeafNodeImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.761 -0400", hash_original_field = "F003D44A4CF514277D9944C7A47DACA3", hash_generated_field = "B027621B27AE52A5595EFB742F1A4AE3")

    List<LeafNodeImpl> children = new ArrayList<LeafNodeImpl>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.762 -0400", hash_original_method = "7512CE9829BC408DFDD38505D289D8D9", hash_generated_method = "759FE285685D2D6F5C8C62BAA5F6D928")
    protected  InnerNodeImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.762 -0400", hash_original_method = "32EEE6618A157AF1714C0ED00AB24628", hash_generated_method = "EE8B2C26A6647C7F7015520973FED081")
    public Node appendChild(Node newChild) throws DOMException {
        addTaint(newChild.getTaint());
Node var4CB1E8A00542B0F7DC36A9DD411590EE_2031676871 =         insertChildAt(newChild, children.size());
        var4CB1E8A00542B0F7DC36A9DD411590EE_2031676871.addTaint(taint);
        return var4CB1E8A00542B0F7DC36A9DD411590EE_2031676871;
        // ---------- Original Method ----------
        //return insertChildAt(newChild, children.size());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.762 -0400", hash_original_method = "8F58F724DAE50380735EAE0A1E873E0C", hash_generated_method = "701CF8E8A0991A3A13F58DB3861B4257")
    public NodeList getChildNodes() {
        NodeListImpl list = new NodeListImpl();
for(NodeImpl node : children)
        {
            list.add(node);
        } //End block
NodeList varED12C351C2E8CA4F85F097DDC7E77B4D_1348232676 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_1348232676.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_1348232676;
        // ---------- Original Method ----------
        //NodeListImpl list = new NodeListImpl();
        //for (NodeImpl node : children) {
            //list.add(node);
        //}
        //return list;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.763 -0400", hash_original_method = "135BB34C460FCFA99784841F3EF5F177", hash_generated_method = "CE9777C5EA58987AC72C942030CAE53D")
    public Node getFirstChild() {
Node var211369CA7A87CE4D90A908226EA35128_920892501 =         (!children.isEmpty() ? children.get(0) : null);
        var211369CA7A87CE4D90A908226EA35128_920892501.addTaint(taint);
        return var211369CA7A87CE4D90A908226EA35128_920892501;
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(0) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.763 -0400", hash_original_method = "56E890D8D2E0854FB8D72E107BF6DE5B", hash_generated_method = "489770F7B478308D176A3BECA134CE86")
    public Node getLastChild() {
Node var291C8A7910E5657FE27007C3CE5E035B_851923607 =         (!children.isEmpty() ? children.get(children.size() - 1) : null);
        var291C8A7910E5657FE27007C3CE5E035B_851923607.addTaint(taint);
        return var291C8A7910E5657FE27007C3CE5E035B_851923607;
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(children.size() - 1) : null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.763 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "92AAC36D34EC35675CD9100B3C91CC05")
    public Node getNextSibling() {
    if(parent == null || index + 1 >= parent.children.size())        
        {
Node var540C13E9E156B687226421B24F2DF178_482052337 =             null;
            var540C13E9E156B687226421B24F2DF178_482052337.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_482052337;
        } //End block
Node varCAF2121A40A40843AD59F9E2CDF911E5_1184139360 =         parent.children.get(index + 1);
        varCAF2121A40A40843AD59F9E2CDF911E5_1184139360.addTaint(taint);
        return varCAF2121A40A40843AD59F9E2CDF911E5_1184139360;
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.764 -0400", hash_original_method = "6A6B7C4F52A3C0800D99001450A25AF3", hash_generated_method = "1755D4D22231BCA2517ABCC7DCAECD9C")
    public boolean hasChildNodes() {
        boolean var13BDCCF740AD270748E63B1C649E3359_2113013065 = (children.size() != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2072762172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2072762172;
        // ---------- Original Method ----------
        //return children.size() != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.764 -0400", hash_original_method = "DC35B4AC23E21A549DCF9BD17D39CB3A", hash_generated_method = "6DABDB26993ED27D38016ABD4939F1BD")
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        addTaint(refChild.getTaint());
        addTaint(newChild.getTaint());
        LeafNodeImpl refChildImpl = (LeafNodeImpl) refChild;
    if(refChildImpl.document != document)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_1505880049 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_1505880049.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_1505880049;
        } //End block
    if(refChildImpl.parent != this)        
        {
            DOMException varB08FA5F9049CD84DC42B7238D3D303A7_488836014 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            varB08FA5F9049CD84DC42B7238D3D303A7_488836014.addTaint(taint);
            throw varB08FA5F9049CD84DC42B7238D3D303A7_488836014;
        } //End block
Node varF2F52C5D5B9224A092E2EE27351786CF_259825320 =         insertChildAt(newChild, refChildImpl.index);
        varF2F52C5D5B9224A092E2EE27351786CF_259825320.addTaint(taint);
        return varF2F52C5D5B9224A092E2EE27351786CF_259825320;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.765 -0400", hash_original_method = "CC52893233A8017E84157556EAC90FCB", hash_generated_method = "CC7E6C74BB46A7569D76512FD5CEE4C7")
     Node insertChildAt(Node newChild, int index) throws DOMException {
        addTaint(index);
        addTaint(newChild.getTaint());
    if(newChild instanceof DocumentFragment)        
        {
            NodeList toAdd = newChild.getChildNodes();
for(int i = 0;i < toAdd.getLength();i++)
            {
                insertChildAt(toAdd.item(i), index + i);
            } //End block
Node var27D66BDD904EAAAD70983474F8274FA5_769578320 =             newChild;
            var27D66BDD904EAAAD70983474F8274FA5_769578320.addTaint(taint);
            return var27D66BDD904EAAAD70983474F8274FA5_769578320;
        } //End block
        LeafNodeImpl toInsert = (LeafNodeImpl) newChild;
    if(toInsert.document != null && document != null && toInsert.document != document)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_733765092 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_733765092.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_733765092;
        } //End block
    if(toInsert.isParentOf(this))        
        {
            DOMException varB08FA5F9049CD84DC42B7238D3D303A7_652783548 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            varB08FA5F9049CD84DC42B7238D3D303A7_652783548.addTaint(taint);
            throw varB08FA5F9049CD84DC42B7238D3D303A7_652783548;
        } //End block
    if(toInsert.parent != null)        
        {
            int oldIndex = toInsert.index;
            toInsert.parent.children.remove(oldIndex);
            toInsert.parent.refreshIndices(oldIndex);
        } //End block
        children.add(index, toInsert);
        toInsert.parent = this;
        refreshIndices(index);
Node var27D66BDD904EAAAD70983474F8274FA5_478543656 =         newChild;
        var27D66BDD904EAAAD70983474F8274FA5_478543656.addTaint(taint);
        return var27D66BDD904EAAAD70983474F8274FA5_478543656;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.765 -0400", hash_original_method = "EAC92D1975EC52765900D3EB8DB15DFE", hash_generated_method = "6D3AD9C50CFE1B966B72C2296AAB5573")
    public boolean isParentOf(Node node) {
        addTaint(node.getTaint());
        LeafNodeImpl nodeImpl = (LeafNodeImpl) node;
        while
(nodeImpl != null)        
        {
    if(nodeImpl == this)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1906422303 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_85019894 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_85019894;
            } //End block
            nodeImpl = nodeImpl.parent;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1304647133 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1176383013 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1176383013;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.766 -0400", hash_original_method = "2E387D6B5E2ABD0B7044442BD7493DDC", hash_generated_method = "0851C03A522EA36C2C186F7ACFED741B")
    @Override
    public final void normalize() {
        Node next;
for(Node node = getFirstChild();node != null;node = next)
        {
            next = node.getNextSibling();
            node.normalize();
    if(node.getNodeType() == Node.TEXT_NODE)            
            {
                ((TextImpl) node).minimize();
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.767 -0400", hash_original_method = "228203F3C91B72F7B5E602122B5A1790", hash_generated_method = "61FBA5A4E9A80FD4DAA43034EB2FA4CC")
    private void refreshIndices(int fromIndex) {
        addTaint(fromIndex);
for(int i = fromIndex;i < children.size();i++)
        {
            children.get(i).index = i;
        } //End block
        // ---------- Original Method ----------
        //for (int i = fromIndex; i < children.size(); i++) {
            //children.get(i).index = i;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.767 -0400", hash_original_method = "45F8FB3BF08F1B2108957574E4D1D247", hash_generated_method = "BBFCEC726ECFB2FB289373983AB8EA21")
    public Node removeChild(Node oldChild) throws DOMException {
        addTaint(oldChild.getTaint());
        LeafNodeImpl oldChildImpl = (LeafNodeImpl) oldChild;
    if(oldChildImpl.document != document)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_995384870 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_995384870.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_995384870;
        } //End block
    if(oldChildImpl.parent != this)        
        {
            DOMException varB08FA5F9049CD84DC42B7238D3D303A7_1864918061 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            varB08FA5F9049CD84DC42B7238D3D303A7_1864918061.addTaint(taint);
            throw varB08FA5F9049CD84DC42B7238D3D303A7_1864918061;
        } //End block
        int index = oldChildImpl.index;
        children.remove(index);
        oldChildImpl.parent = null;
        refreshIndices(index);
Node var21D2FEAF038767ED878631E3A660594F_2030763784 =         oldChild;
        var21D2FEAF038767ED878631E3A660594F_2030763784.addTaint(taint);
        return var21D2FEAF038767ED878631E3A660594F_2030763784;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.768 -0400", hash_original_method = "7E92B523792E0B3571F5728856964E5D", hash_generated_method = "C885591865976DFBBAA419C8C785DD28")
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        addTaint(oldChild.getTaint());
        addTaint(newChild.getTaint());
        int index = ((LeafNodeImpl) oldChild).index;
        removeChild(oldChild);
        insertChildAt(newChild, index);
Node var21D2FEAF038767ED878631E3A660594F_1419846152 =         oldChild;
        var21D2FEAF038767ED878631E3A660594F_1419846152.addTaint(taint);
        return var21D2FEAF038767ED878631E3A660594F_1419846152;
        // ---------- Original Method ----------
        //int index = ((LeafNodeImpl) oldChild).index;
        //removeChild(oldChild);
        //insertChildAt(newChild, index);
        //return oldChild;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.768 -0400", hash_original_method = "32F8137481F8B7A6AF322114BC5A4B22", hash_generated_method = "F2E3B8D4D3B132F803040A7C6EA0D52C")
    public String getTextContent() throws DOMException {
        Node child = getFirstChild();
    if(child == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_305021031 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_305021031.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_305021031;
        } //End block
        Node next = child.getNextSibling();
    if(next == null)        
        {
String var324EC079A1FB1AE8B38221F99BD2FABE_2036939976 =             hasTextContent(child) ? child.getTextContent() : "";
            var324EC079A1FB1AE8B38221F99BD2FABE_2036939976.addTaint(taint);
            return var324EC079A1FB1AE8B38221F99BD2FABE_2036939976;
        } //End block
        StringBuilder buf = new StringBuilder();
        getTextContent(buf);
String var4FC680801218E6372BC708D6FA44AE60_1664996555 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_1664996555.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_1664996555;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.769 -0400", hash_original_method = "1B7875C51CF051392D3264002D3285E5", hash_generated_method = "0963CC40442BA7D1727FA1465DCA5237")
     void getTextContent(StringBuilder buf) throws DOMException {
        addTaint(buf.getTaint());
        Node child = getFirstChild();
        while
(child != null)        
        {
    if(hasTextContent(child))            
            {
                ((NodeImpl) child).getTextContent(buf);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.769 -0400", hash_original_method = "8BE6B36212848E97AA53F8A83F869F11", hash_generated_method = "941144D2C1945AC326C853E4F778DD95")
    final boolean hasTextContent(Node child) {
        addTaint(child.getTaint());
        boolean var24D64F611680AC891B2331D26F98C9D8_737906405 = (child.getNodeType() != Node.COMMENT_NODE
                && child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1682104534 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1682104534;
        // ---------- Original Method ----------
        //return child.getNodeType() != Node.COMMENT_NODE
                //&& child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.770 -0400", hash_original_method = "FBC9DCE28E1410ABABC4D8105012C635", hash_generated_method = "E0C823BA49A408A4D7EE0AE53C19B1D8")
     void getElementsByTagName(NodeListImpl out, String name) {
        addTaint(name.getTaint());
        addTaint(out.getTaint());
for(NodeImpl node : children)
        {
    if(node.getNodeType() == Node.ELEMENT_NODE)            
            {
                ElementImpl element = (ElementImpl) node;
    if(matchesNameOrWildcard(name, element.getNodeName()))                
                {
                    out.add(element);
                } //End block
                element.getElementsByTagName(out, name);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.770 -0400", hash_original_method = "E06ADC8546BD526D25CE87ECAD401587", hash_generated_method = "1CA514B9CABF0D1284CAF9441FF6E39D")
     void getElementsByTagNameNS(NodeListImpl out, String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(out.getTaint());
for(NodeImpl node : children)
        {
    if(node.getNodeType() == Node.ELEMENT_NODE)            
            {
                ElementImpl element = (ElementImpl) node;
    if(matchesNameOrWildcard(namespaceURI, element.getNamespaceURI())
                        && matchesNameOrWildcard(localName, element.getLocalName()))                
                {
                    out.add(element);
                } //End block
                element.getElementsByTagNameNS(out, namespaceURI, localName);
            } //End block
        } //End block
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

