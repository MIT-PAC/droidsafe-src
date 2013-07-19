package org.apache.harmony.xml.dom;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.List;

import libcore.util.Objects;

import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class InnerNodeImpl extends LeafNodeImpl {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.488 -0400", hash_original_field = "F003D44A4CF514277D9944C7A47DACA3", hash_generated_field = "B027621B27AE52A5595EFB742F1A4AE3")

    List<LeafNodeImpl> children = new ArrayList<LeafNodeImpl>();
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.488 -0400", hash_original_method = "7512CE9829BC408DFDD38505D289D8D9", hash_generated_method = "759FE285685D2D6F5C8C62BAA5F6D928")
    protected  InnerNodeImpl(DocumentImpl document) {
        super(document);
        addTaint(document.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.489 -0400", hash_original_method = "32EEE6618A157AF1714C0ED00AB24628", hash_generated_method = "CF9584B1C4F8F05E0D3DD73F22272317")
    public Node appendChild(Node newChild) throws DOMException {
        addTaint(newChild.getTaint());
Node var4CB1E8A00542B0F7DC36A9DD411590EE_89139027 =         insertChildAt(newChild, children.size());
        var4CB1E8A00542B0F7DC36A9DD411590EE_89139027.addTaint(taint);
        return var4CB1E8A00542B0F7DC36A9DD411590EE_89139027;
        // ---------- Original Method ----------
        //return insertChildAt(newChild, children.size());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.489 -0400", hash_original_method = "8F58F724DAE50380735EAE0A1E873E0C", hash_generated_method = "5E32066C01AD9AB245F4EBF07DF4AD25")
    public NodeList getChildNodes() {
        NodeListImpl list = new NodeListImpl();
for(NodeImpl node : children)
        {
            list.add(node);
        } //End block
NodeList varED12C351C2E8CA4F85F097DDC7E77B4D_946938529 =         list;
        varED12C351C2E8CA4F85F097DDC7E77B4D_946938529.addTaint(taint);
        return varED12C351C2E8CA4F85F097DDC7E77B4D_946938529;
        // ---------- Original Method ----------
        //NodeListImpl list = new NodeListImpl();
        //for (NodeImpl node : children) {
            //list.add(node);
        //}
        //return list;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.489 -0400", hash_original_method = "135BB34C460FCFA99784841F3EF5F177", hash_generated_method = "98D49BA2D9224B40C31914E2C35C081C")
    public Node getFirstChild() {
Node var211369CA7A87CE4D90A908226EA35128_1706390719 =         (!children.isEmpty() ? children.get(0) : null);
        var211369CA7A87CE4D90A908226EA35128_1706390719.addTaint(taint);
        return var211369CA7A87CE4D90A908226EA35128_1706390719;
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(0) : null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.490 -0400", hash_original_method = "56E890D8D2E0854FB8D72E107BF6DE5B", hash_generated_method = "0AC45CCC0D2DC456B7B16E3DBCCE1B2B")
    public Node getLastChild() {
Node var291C8A7910E5657FE27007C3CE5E035B_1225587335 =         (!children.isEmpty() ? children.get(children.size() - 1) : null);
        var291C8A7910E5657FE27007C3CE5E035B_1225587335.addTaint(taint);
        return var291C8A7910E5657FE27007C3CE5E035B_1225587335;
        // ---------- Original Method ----------
        //return (!children.isEmpty() ? children.get(children.size() - 1) : null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.490 -0400", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "E60508E79AD93C3DDED123A8A416E07E")
    public Node getNextSibling() {
        if(parent == null || index + 1 >= parent.children.size())        
        {
Node var540C13E9E156B687226421B24F2DF178_935360857 =             null;
            var540C13E9E156B687226421B24F2DF178_935360857.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_935360857;
        } //End block
Node varCAF2121A40A40843AD59F9E2CDF911E5_128790072 =         parent.children.get(index + 1);
        varCAF2121A40A40843AD59F9E2CDF911E5_128790072.addTaint(taint);
        return varCAF2121A40A40843AD59F9E2CDF911E5_128790072;
        // ---------- Original Method ----------
        //if (parent == null || index + 1 >= parent.children.size()) {
            //return null;
        //}
        //return parent.children.get(index + 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.491 -0400", hash_original_method = "6A6B7C4F52A3C0800D99001450A25AF3", hash_generated_method = "6A2CC915315640B7DE459E2D096B7BBE")
    public boolean hasChildNodes() {
        boolean var13BDCCF740AD270748E63B1C649E3359_1356307511 = (children.size() != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_402872692 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_402872692;
        // ---------- Original Method ----------
        //return children.size() != 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.491 -0400", hash_original_method = "DC35B4AC23E21A549DCF9BD17D39CB3A", hash_generated_method = "0F2FB1CB8D6DF9DBDAE9F67CD22E2FE4")
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        addTaint(refChild.getTaint());
        addTaint(newChild.getTaint());
        LeafNodeImpl refChildImpl = (LeafNodeImpl) refChild;
        if(refChildImpl.document != document)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_306028730 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_306028730.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_306028730;
        } //End block
        if(refChildImpl.parent != this)        
        {
            DOMException varB08FA5F9049CD84DC42B7238D3D303A7_537029518 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            varB08FA5F9049CD84DC42B7238D3D303A7_537029518.addTaint(taint);
            throw varB08FA5F9049CD84DC42B7238D3D303A7_537029518;
        } //End block
Node varF2F52C5D5B9224A092E2EE27351786CF_771459193 =         insertChildAt(newChild, refChildImpl.index);
        varF2F52C5D5B9224A092E2EE27351786CF_771459193.addTaint(taint);
        return varF2F52C5D5B9224A092E2EE27351786CF_771459193;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.492 -0400", hash_original_method = "CC52893233A8017E84157556EAC90FCB", hash_generated_method = "34DB466D955F93C91542E8E57009CEB1")
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
Node var27D66BDD904EAAAD70983474F8274FA5_394464079 =             newChild;
            var27D66BDD904EAAAD70983474F8274FA5_394464079.addTaint(taint);
            return var27D66BDD904EAAAD70983474F8274FA5_394464079;
        } //End block
        LeafNodeImpl toInsert = (LeafNodeImpl) newChild;
        if(toInsert.document != null && document != null && toInsert.document != document)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_380445643 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_380445643.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_380445643;
        } //End block
        if(toInsert.isParentOf(this))        
        {
            DOMException varB08FA5F9049CD84DC42B7238D3D303A7_1622417728 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            varB08FA5F9049CD84DC42B7238D3D303A7_1622417728.addTaint(taint);
            throw varB08FA5F9049CD84DC42B7238D3D303A7_1622417728;
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
Node var27D66BDD904EAAAD70983474F8274FA5_1690387262 =         newChild;
        var27D66BDD904EAAAD70983474F8274FA5_1690387262.addTaint(taint);
        return var27D66BDD904EAAAD70983474F8274FA5_1690387262;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.493 -0400", hash_original_method = "EAC92D1975EC52765900D3EB8DB15DFE", hash_generated_method = "C94DD5EE77AA50B080F77A4F6B8F4E63")
    public boolean isParentOf(Node node) {
        addTaint(node.getTaint());
        LeafNodeImpl nodeImpl = (LeafNodeImpl) node;
        while
(nodeImpl != null)        
        {
            if(nodeImpl == this)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_124869810 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_925903267 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_925903267;
            } //End block
            nodeImpl = nodeImpl.parent;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_824943948 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_54166798 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_54166798;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.495 -0400", hash_original_method = "2E387D6B5E2ABD0B7044442BD7493DDC", hash_generated_method = "0851C03A522EA36C2C186F7ACFED741B")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.497 -0400", hash_original_method = "228203F3C91B72F7B5E602122B5A1790", hash_generated_method = "61FBA5A4E9A80FD4DAA43034EB2FA4CC")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.500 -0400", hash_original_method = "45F8FB3BF08F1B2108957574E4D1D247", hash_generated_method = "4223E34080438B208E928260CDBD6259")
    public Node removeChild(Node oldChild) throws DOMException {
        addTaint(oldChild.getTaint());
        LeafNodeImpl oldChildImpl = (LeafNodeImpl) oldChild;
        if(oldChildImpl.document != document)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_994683520 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_994683520.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_994683520;
        } //End block
        if(oldChildImpl.parent != this)        
        {
            DOMException varB08FA5F9049CD84DC42B7238D3D303A7_697157075 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            varB08FA5F9049CD84DC42B7238D3D303A7_697157075.addTaint(taint);
            throw varB08FA5F9049CD84DC42B7238D3D303A7_697157075;
        } //End block
        int index = oldChildImpl.index;
        children.remove(index);
        oldChildImpl.parent = null;
        refreshIndices(index);
Node var21D2FEAF038767ED878631E3A660594F_1361802705 =         oldChild;
        var21D2FEAF038767ED878631E3A660594F_1361802705.addTaint(taint);
        return var21D2FEAF038767ED878631E3A660594F_1361802705;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.501 -0400", hash_original_method = "7E92B523792E0B3571F5728856964E5D", hash_generated_method = "02A442A2A27BA96726DEA85262E0CB61")
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        addTaint(oldChild.getTaint());
        addTaint(newChild.getTaint());
        int index = ((LeafNodeImpl) oldChild).index;
        removeChild(oldChild);
        insertChildAt(newChild, index);
Node var21D2FEAF038767ED878631E3A660594F_1121233446 =         oldChild;
        var21D2FEAF038767ED878631E3A660594F_1121233446.addTaint(taint);
        return var21D2FEAF038767ED878631E3A660594F_1121233446;
        // ---------- Original Method ----------
        //int index = ((LeafNodeImpl) oldChild).index;
        //removeChild(oldChild);
        //insertChildAt(newChild, index);
        //return oldChild;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.502 -0400", hash_original_method = "32F8137481F8B7A6AF322114BC5A4B22", hash_generated_method = "C4DE43C0204CD6F2F53983889E4CCD11")
    public String getTextContent() throws DOMException {
        Node child = getFirstChild();
        if(child == null)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1638411060 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1638411060.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1638411060;
        } //End block
        Node next = child.getNextSibling();
        if(next == null)        
        {
String var324EC079A1FB1AE8B38221F99BD2FABE_1207284187 =             hasTextContent(child) ? child.getTextContent() : "";
            var324EC079A1FB1AE8B38221F99BD2FABE_1207284187.addTaint(taint);
            return var324EC079A1FB1AE8B38221F99BD2FABE_1207284187;
        } //End block
        StringBuilder buf = new StringBuilder();
        getTextContent(buf);
String var4FC680801218E6372BC708D6FA44AE60_678367590 =         buf.toString();
        var4FC680801218E6372BC708D6FA44AE60_678367590.addTaint(taint);
        return var4FC680801218E6372BC708D6FA44AE60_678367590;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.502 -0400", hash_original_method = "1B7875C51CF051392D3264002D3285E5", hash_generated_method = "0963CC40442BA7D1727FA1465DCA5237")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.503 -0400", hash_original_method = "8BE6B36212848E97AA53F8A83F869F11", hash_generated_method = "FA7429830B44E0704AB94BD49757D1C6")
    final boolean hasTextContent(Node child) {
        addTaint(child.getTaint());
        boolean var24D64F611680AC891B2331D26F98C9D8_47185440 = (child.getNodeType() != Node.COMMENT_NODE
                && child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852414379 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_852414379;
        // ---------- Original Method ----------
        //return child.getNodeType() != Node.COMMENT_NODE
                //&& child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.503 -0400", hash_original_method = "FBC9DCE28E1410ABABC4D8105012C635", hash_generated_method = "E0C823BA49A408A4D7EE0AE53C19B1D8")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.504 -0400", hash_original_method = "E06ADC8546BD526D25CE87ECAD401587", hash_generated_method = "1CA514B9CABF0D1284CAF9441FF6E39D")
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

    
    @DSModeled(DSC.SAFE)
    private static boolean matchesNameOrWildcard(String pattern, String s) {
        return "*".equals(pattern) || Objects.equal(pattern, s);
    }

    
}

