package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import libcore.util.Objects;

import org.w3c.dom.DOMException;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class InnerNodeImpl extends LeafNodeImpl {

    /**
     * Returns true if {@code pattern} equals either "*" or {@code s}. Pattern
     * may be {@code null}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.673 -0500", hash_original_method = "3AE42BF49D2EDB4F7904018AB416CBF8", hash_generated_method = "03D776F83958ECCD657E90FD9DA68DD8")
    
private static boolean matchesNameOrWildcard(String pattern, String s) {
        return "*".equals(pattern) || Objects.equal(pattern, s);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.626 -0500", hash_original_field = "B027621B27AE52A5595EFB742F1A4AE3", hash_generated_field = "B027621B27AE52A5595EFB742F1A4AE3")

    List<LeafNodeImpl> children = new ArrayList<LeafNodeImpl>();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.628 -0500", hash_original_method = "7512CE9829BC408DFDD38505D289D8D9", hash_generated_method = "399081EAF6884AD973758AAD109D58C8")
    
protected InnerNodeImpl(DocumentImpl document) {
        super(document);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.631 -0500", hash_original_method = "32EEE6618A157AF1714C0ED00AB24628", hash_generated_method = "A721AAF0A7D3D9C7DF2B2A27A9A90D86")
    
public Node appendChild(Node newChild) throws DOMException {
        return insertChildAt(newChild, children.size());
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.633 -0500", hash_original_method = "8F58F724DAE50380735EAE0A1E873E0C", hash_generated_method = "5A0137E101F54A715AFCF24EC1D83A21")
    
public NodeList getChildNodes() {
        NodeListImpl list = new NodeListImpl();

        for (NodeImpl node : children) {
            list.add(node);
        }

        return list;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.635 -0500", hash_original_method = "135BB34C460FCFA99784841F3EF5F177", hash_generated_method = "ECCFB26398F78676F565BA5D66A09E5B")
    
public Node getFirstChild() {
        return (!children.isEmpty() ? children.get(0) : null);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.638 -0500", hash_original_method = "56E890D8D2E0854FB8D72E107BF6DE5B", hash_generated_method = "1406C87A3999DDE1FCC445B82FD39ED1")
    
public Node getLastChild() {
        return (!children.isEmpty() ? children.get(children.size() - 1) : null);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.640 -0500", hash_original_method = "DC63B22231FC6D38D6E19E3A9D1523CF", hash_generated_method = "FC6A26CA5BCFEAD3D28518BEEF4E3F1F")
    
public Node getNextSibling() {
        if (parent == null || index + 1 >= parent.children.size()) {
            return null;
        }

        return parent.children.get(index + 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.643 -0500", hash_original_method = "6A6B7C4F52A3C0800D99001450A25AF3", hash_generated_method = "8DE5897F2B9918454DD6A6359CAC15A4")
    
public boolean hasChildNodes() {
        return children.size() != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.645 -0500", hash_original_method = "DC35B4AC23E21A549DCF9BD17D39CB3A", hash_generated_method = "55533D2F7EBC0D477408A85C8B9AF3A0")
    
public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        LeafNodeImpl refChildImpl = (LeafNodeImpl) refChild;

        if (refChildImpl.document != document) {
            throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        }

        if (refChildImpl.parent != this) {
            throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        }

        return insertChildAt(newChild, refChildImpl.index);
    }

    /**
     * Inserts {@code newChild} at {@code index}. If it is already child of
     * another node, it is removed from there.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.648 -0500", hash_original_method = "CC52893233A8017E84157556EAC90FCB", hash_generated_method = "CC52893233A8017E84157556EAC90FCB")
    
Node insertChildAt(Node newChild, int index) throws DOMException {
        if (newChild instanceof DocumentFragment) {
            NodeList toAdd = newChild.getChildNodes();
            for (int i = 0; i < toAdd.getLength(); i++) {
                insertChildAt(toAdd.item(i), index + i);
            }
            return newChild;
        }

        LeafNodeImpl toInsert = (LeafNodeImpl) newChild;
        if (toInsert.document != null && document != null && toInsert.document != document) {
            throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        }
        if (toInsert.isParentOf(this)) {
            throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        }

        if (toInsert.parent != null) {
            int oldIndex = toInsert.index;
            toInsert.parent.children.remove(oldIndex);
            toInsert.parent.refreshIndices(oldIndex);
        }

        children.add(index, toInsert);
        toInsert.parent = this;
        refreshIndices(index);

        return newChild;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.650 -0500", hash_original_method = "EAC92D1975EC52765900D3EB8DB15DFE", hash_generated_method = "7274E6D05E207D7C6F22331CDD742F2C")
    
public boolean isParentOf(Node node) {
        LeafNodeImpl nodeImpl = (LeafNodeImpl) node;

        while (nodeImpl != null) {
            if (nodeImpl == this) {
                return true;
            }

            nodeImpl = nodeImpl.parent;
        }

        return false;
    }

    /**
     * Normalize the text nodes within this subtree. Although named similarly,
     * this method is unrelated to Document.normalize.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.653 -0500", hash_original_method = "2E387D6B5E2ABD0B7044442BD7493DDC", hash_generated_method = "ADA45DDDF42A8F87AC7BE09AEC803F7A")
    
@Override
    public final void normalize() {
        Node next;
        for (Node node = getFirstChild(); node != null; node = next) {
            next = node.getNextSibling();
            node.normalize();

            if (node.getNodeType() == Node.TEXT_NODE) {
                ((TextImpl) node).minimize();
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.655 -0500", hash_original_method = "228203F3C91B72F7B5E602122B5A1790", hash_generated_method = "78917AE89F3085715146D7950084B621")
    
private void refreshIndices(int fromIndex) {
        for (int i = fromIndex; i < children.size(); i++) {
            children.get(i).index = i;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.657 -0500", hash_original_method = "45F8FB3BF08F1B2108957574E4D1D247", hash_generated_method = "1D95BFC9F1105809D0951EB8BA6FB4C6")
    
public Node removeChild(Node oldChild) throws DOMException {
        LeafNodeImpl oldChildImpl = (LeafNodeImpl) oldChild;

        if (oldChildImpl.document != document) {
            throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        }
        if (oldChildImpl.parent != this) {
            throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        }

        int index = oldChildImpl.index;
        children.remove(index);
        oldChildImpl.parent = null;
        refreshIndices(index);

        return oldChild;
    }

    /**
     * Removes {@code oldChild} and adds {@code newChild} in its place. This
     * is not atomic.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.659 -0500", hash_original_method = "7E92B523792E0B3571F5728856964E5D", hash_generated_method = "41E1984C383312CC4C8870EDBB2E6376")
    
public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        int index = ((LeafNodeImpl) oldChild).index;
        removeChild(oldChild);
        insertChildAt(newChild, index);
        return oldChild;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.662 -0500", hash_original_method = "32F8137481F8B7A6AF322114BC5A4B22", hash_generated_method = "CF8BCE57276D2FB5C5A25597BC22E7D3")
    
public String getTextContent() throws DOMException {
        Node child = getFirstChild();
        if (child == null) {
            return "";
        }

        Node next = child.getNextSibling();
        if (next == null) {
            return hasTextContent(child) ? child.getTextContent() : "";
        }

        StringBuilder buf = new StringBuilder();
        getTextContent(buf);
        return buf.toString();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.664 -0500", hash_original_method = "1B7875C51CF051392D3264002D3285E5", hash_generated_method = "1B7875C51CF051392D3264002D3285E5")
    
void getTextContent(StringBuilder buf) throws DOMException {
        Node child = getFirstChild();
        while (child != null) {
            if (hasTextContent(child)) {
                ((NodeImpl) child).getTextContent(buf);
            }
            child = child.getNextSibling();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.666 -0500", hash_original_method = "8BE6B36212848E97AA53F8A83F869F11", hash_generated_method = "7C194BC5DDEBF48FC31149B5BC1C2D72")
    
final boolean hasTextContent(Node child) {
        // TODO: skip text nodes with ignorable whitespace?
        return child.getNodeType() != Node.COMMENT_NODE
                && child.getNodeType() != Node.PROCESSING_INSTRUCTION_NODE;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.668 -0500", hash_original_method = "FBC9DCE28E1410ABABC4D8105012C635", hash_generated_method = "FBC9DCE28E1410ABABC4D8105012C635")
    
void getElementsByTagName(NodeListImpl out, String name) {
        for (NodeImpl node : children) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                ElementImpl element = (ElementImpl) node;
                if (matchesNameOrWildcard(name, element.getNodeName())) {
                    out.add(element);
                }
                element.getElementsByTagName(out, name);
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:19.671 -0500", hash_original_method = "E06ADC8546BD526D25CE87ECAD401587", hash_generated_method = "E06ADC8546BD526D25CE87ECAD401587")
    
void getElementsByTagNameNS(NodeListImpl out, String namespaceURI, String localName) {
        for (NodeImpl node : children) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                ElementImpl element = (ElementImpl) node;
                if (matchesNameOrWildcard(namespaceURI, element.getNamespaceURI())
                        && matchesNameOrWildcard(localName, element.getLocalName())) {
                    out.add(element);
                }
                element.getElementsByTagNameNS(out, namespaceURI, localName);
            }
        }
    }
    
}

