package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class TextImpl extends CharacterDataImpl implements Text {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.644 -0500", hash_original_method = "8FBFCF7E900515A865ACF1E6532A7BB4", hash_generated_method = "2093298397731365B7122E0DB320CD74")
    
public TextImpl(DocumentImpl document, String data) {
        super(document, data);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.646 -0500", hash_original_method = "F5AD87001A4CE84E4D3D0566BEEE7118", hash_generated_method = "C4C300E154A22FD56C473059949B5D44")
    
@Override
    public String getNodeName() {
        return "#text";
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.648 -0500", hash_original_method = "C38FDDE6CC592E744EE6602E5FF8812E", hash_generated_method = "3E5F8D3FB7077ED3A914D5EEB7B1F1D4")
    
@Override
    public short getNodeType() {
        return Node.TEXT_NODE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.651 -0500", hash_original_method = "F2223FE614407E591CCAD60B04318A19", hash_generated_method = "ADB27526DF1F99C351E4DF0BB6A6BCE0")
    
public final Text splitText(int offset) throws DOMException {
        Text newText = document.createTextNode(
                substringData(offset, getLength() - offset));
        deleteData(0, offset);

        Node refNode = getNextSibling();
        if (refNode == null) {
            getParentNode().appendChild(newText);
        } else {
            getParentNode().insertBefore(newText, refNode);
        }

        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.653 -0500", hash_original_method = "E52052CEEE0E5966B25CAA49C3A5CE28", hash_generated_method = "4A2C61C778BF05DF76D092C416506FD3")
    
public final boolean isElementContentWhitespace() {
        // Undefined because we don't validate. Whether whitespace characters
        // constitute "element content whitespace" is defined by the containing
        // element's declaration (DTD) and we don't parse that.
        // TODO: wire this up when we support document validation
        return false;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.656 -0500", hash_original_method = "9EC887BD47A703F2DBB656ECC04AC254", hash_generated_method = "8C16B1BE6EF7D54588CAB10C28EE03DD")
    
public final String getWholeText() {
        // TODO: support entity references. This code should expand through
        // the child elements of entity references.
        //     http://code.google.com/p/android/issues/detail?id=6807

        StringBuilder result = new StringBuilder();
        for (TextImpl n = firstTextNodeInCurrentRun(); n != null; n = n.nextTextNode()) {
            n.appendDataTo(result);
        }
        return result.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.659 -0500", hash_original_method = "F1D9E0F93EC220C6C7713D2F10A5FC3E", hash_generated_method = "3F16AE598BB593F9209CF3A8C193ECAC")
    
public final Text replaceWholeText(String content) throws DOMException {
        // TODO: support entity references. This code should expand and replace
        // the child elements of entity references.
        //     http://code.google.com/p/android/issues/detail?id=6807

        Node parent = getParentNode();
        Text result = null;

        // delete all nodes in the current run of text...
        for (TextImpl n = firstTextNodeInCurrentRun(); n != null; ) {

            // ...except the current node if we have content for it
            if (n == this && content != null && content.length() > 0) {
                setData(content);
                result = this;
                n = n.nextTextNode();

            } else {
                Node toRemove = n; // because removeChild() detaches siblings
                n = n.nextTextNode();
                parent.removeChild(toRemove);
            }
        }

        return result;
    }

    /**
     * Returns the first text or CDATA node in the current sequence of text and
     * CDATA nodes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.661 -0500", hash_original_method = "9928E14A90ED22F7792AF824C555C38E", hash_generated_method = "FD09E15A05B5DCDBEE2328F70AACD50E")
    
private TextImpl firstTextNodeInCurrentRun() {
        TextImpl firstTextInCurrentRun = this;
        for (Node p = getPreviousSibling(); p != null; p = p.getPreviousSibling()) {
            short nodeType = p.getNodeType();
            if (nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE) {
                firstTextInCurrentRun = (TextImpl) p;
            } else {
                break;
            }
        }
        return firstTextInCurrentRun;
    }

    /**
     * Returns the next sibling node if it exists and it is text or CDATA.
     * Otherwise returns null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.664 -0500", hash_original_method = "E11C938286265122BF52D51A5CD9EED3", hash_generated_method = "3F748EF8100EBB2466E608B65108A031")
    
private TextImpl nextTextNode() {
        Node nextSibling = getNextSibling();
        if (nextSibling == null) {
            return null;
        }

        short nodeType = nextSibling.getNodeType();
        return nodeType == Node.TEXT_NODE || nodeType == Node.CDATA_SECTION_NODE
                ? (TextImpl) nextSibling
                : null;
    }

    /**
     * Tries to remove this node using itself and the previous node as context.
     * If this node's text is empty, this node is removed and null is returned.
     * If the previous node exists and is a text node, this node's text will be
     * appended to that node's text and this node will be removed.
     *
     * <p>Although this method alters the structure of the DOM tree, it does
     * not alter the document's semantics.
     *
     * @return the node holding this node's text and the end of the operation.
     *     Can be null if this node contained the empty string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:21.666 -0500", hash_original_method = "C12D207E9524D7914DF3EC77CD8084EB", hash_generated_method = "5528C0BA65E2BB16E317EC9B9A132B8D")
    
public final TextImpl minimize() {
        if (getLength() == 0) {
            parent.removeChild(this);
            return null;
        }

        Node previous = getPreviousSibling();
        if (previous == null || previous.getNodeType() != Node.TEXT_NODE) {
            return this;
        }

        TextImpl previousText = (TextImpl) previous;
        previousText.buffer.append(buffer);
        parent.removeChild(this);
        return previousText;
    }
    
}

