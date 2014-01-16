package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

public final class DocumentImpl extends InnerNodeImpl implements Document {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.812 -0500", hash_original_method = "ECB0F77202F680B9EEEE15A5B36EFD30", hash_generated_method = "CE41BC1EB0C8C3ADD328B005630C9650")
    
private static boolean isXMLIdentifierStart(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c == '_');
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.815 -0500", hash_original_method = "9963058EBDE294AF7CB17B568D9D59FD", hash_generated_method = "80CA41576FD1DAD2F598E0FAB8B91947")
    
private static boolean isXMLIdentifierPart(char c) {
        return isXMLIdentifierStart(c) || (c >= '0' && c <= '9') || (c == '-') || (c == '.');
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.817 -0500", hash_original_method = "651DBFFC8DA0DDFB6ECC66CE06F48991", hash_generated_method = "743B807297E077A47659F07B0C9CDAD7")
    
static boolean isXMLIdentifier(String s) {
        if (s.length() == 0) {
            return false;
        }

        if (!isXMLIdentifierStart(s.charAt(0))) {
            return false;
        }

        for (int i = 1; i < s.length(); i++) {
            if (!isXMLIdentifierPart(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Calls {@link UserDataHandler#handle} on each of the source node's
     * value/handler pairs.
     *
     * <p>If the source node comes from another DOM implementation, user data
     * handlers will <strong>not</strong> be notified. The DOM API provides no
     * mechanism to inspect a foreign node's user data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.913 -0500", hash_original_method = "88BA931E196E85E8D40A5B8A0AA99EFC", hash_generated_method = "C22C99BA5D5D8416927274F362A75128")
    
private static void notifyUserDataHandlers(
            short operation, Node source, NodeImpl destination) {
        if (!(source instanceof NodeImpl)) {
            return;
        }

        NodeImpl srcImpl = (NodeImpl) source;
        if (srcImpl.document == null) {
            return;
        }

        for (Map.Entry<String, UserData> entry
                : srcImpl.document.getUserDataMapForRead(srcImpl).entrySet()) {
            UserData userData = entry.getValue();
            if (userData.handler != null) {
                userData.handler.handle(
                        operation, entry.getKey(), userData.value, source, destination);
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.789 -0500", hash_original_field = "61E672D5F77F268BA078989C16727BAB", hash_generated_field = "02CE798A8CB59B7226C8831D772A3C37")

    private DOMImplementation domImplementation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.791 -0500", hash_original_field = "CD08A1D55EE4481C59A3B1181ED5BA8A", hash_generated_field = "4C2B5AB6B1E4F28DC9582765A0F90963")

    private DOMConfigurationImpl domConfiguration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.794 -0500", hash_original_field = "0913EB4A071CEC5A1CA65E785545CE35", hash_generated_field = "677F469BCAF22AAF9C9A1BCAA78B217D")

    private String documentUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.796 -0500", hash_original_field = "BC0D41D63117246DE1B3B3A6A9F6B583", hash_generated_field = "6E57DD71D7D0E77E0155AE21B6C03BD4")

    private String inputEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.798 -0500", hash_original_field = "DAFD1F56979D27C6800F92D1F6F82EE0", hash_generated_field = "656761370EB1B6AB6991B2A74412BA8B")

    private String xmlEncoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.800 -0500", hash_original_field = "C5D32B5DFEE8F520C50B50FC671AE547", hash_generated_field = "D19F092C2B57A6CC2509D5D658E0ECE5")

    private String xmlVersion = "1.0";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.802 -0500", hash_original_field = "6653266980B2F38E77ACF66CDE5BFF5D", hash_generated_field = "ED1ABCCC72304E22012FCF1E2F4242CD")

    private boolean xmlStandalone = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.804 -0500", hash_original_field = "5BECC698335D2E1FAC4A2E394258FF46", hash_generated_field = "AEC49EFA08DDCABA663F00B7AA711A75")

    private boolean strictErrorChecking = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.807 -0500", hash_original_field = "D1119D87DDE22D3E1776EF89693D6292", hash_generated_field = "2C2B0316F02F109A0965964EB1E285F6")

    private WeakHashMap<NodeImpl, Map<String, UserData>> nodeToUserData;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.810 -0500", hash_original_method = "163C3C7D3935E830694E09EA8384B9EA", hash_generated_method = "EDD1F9FCC95876B6F7342CE41A75C275")
    
public DocumentImpl(DOMImplementationImpl impl, String namespaceURI,
            String qualifiedName, DocumentType doctype, String inputEncoding) {
        super(null);
        this.document = this;
        this.domImplementation = impl;
        this.inputEncoding = inputEncoding;

        if (doctype != null) {
            appendChild(doctype);
        }

        if (qualifiedName != null) {
            appendChild(createElementNS(namespaceURI, qualifiedName));
        }
    }

    /**
     * Returns a shallow copy of the given node. If the node is an element node,
     * its attributes are always copied.
     *
     * @param node a node belonging to any document or DOM implementation.
     * @param operation the operation type to use when notifying user data
     *     handlers of copied element attributes. It is the caller's
     *     responsibility to notify user data handlers of the returned node.
     * @return a new node whose document is this document and whose DOM
     *     implementation is this DOM implementation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.821 -0500", hash_original_method = "71EB0F41099D1D8D08C83EAF224E8D36", hash_generated_method = "18477F0F671E7A0E78BDF283C62D7B0F")
    
private NodeImpl shallowCopy(short operation, Node node) {
        switch (node.getNodeType()) {
        case Node.ATTRIBUTE_NODE:
            AttrImpl attr = (AttrImpl) node;
            AttrImpl attrCopy;
            if (attr.namespaceAware) {
                attrCopy = createAttributeNS(attr.getNamespaceURI(), attr.getLocalName());
                attrCopy.setPrefix(attr.getPrefix());
            } else {
                attrCopy = createAttribute(attr.getName());
            }
            attrCopy.setNodeValue(attr.getValue());
            return attrCopy;

        case Node.CDATA_SECTION_NODE:
            return createCDATASection(((CharacterData) node).getData());

        case Node.COMMENT_NODE:
            return createComment(((Comment) node).getData());

        case Node.DOCUMENT_FRAGMENT_NODE:
            return createDocumentFragment();

        case Node.DOCUMENT_NODE:
        case Node.DOCUMENT_TYPE_NODE:
            throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Cannot copy node of type " + node.getNodeType());

        case Node.ELEMENT_NODE:
            ElementImpl element = (ElementImpl) node;
            ElementImpl elementCopy;
            if (element.namespaceAware) {
                elementCopy = createElementNS(element.getNamespaceURI(), element.getLocalName());
                elementCopy.setPrefix(element.getPrefix());
            } else {
                elementCopy = createElement(element.getTagName());
            }

            NamedNodeMap attributes = element.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                AttrImpl elementAttr = (AttrImpl) attributes.item(i);
                AttrImpl elementAttrCopy = (AttrImpl) shallowCopy(operation, elementAttr);
                notifyUserDataHandlers(operation, elementAttr, elementAttrCopy);
                if (elementAttr.namespaceAware) {
                    elementCopy.setAttributeNodeNS(elementAttrCopy);
                } else {
                    elementCopy.setAttributeNode(elementAttrCopy);
                }
            }
            return elementCopy;

        case Node.ENTITY_NODE:
        case Node.NOTATION_NODE:
            // TODO: implement this when we support these node types
            throw new UnsupportedOperationException();

        case Node.ENTITY_REFERENCE_NODE:
            /*
             * When we support entities in the doctype, this will need to
             * behave differently for clones vs. imports. Clones copy
             * entities by value, copying the referenced subtree from the
             * original document. Imports copy entities by reference,
             * possibly referring to a different subtree in the new
             * document.
             */
            return createEntityReference(node.getNodeName());

        case Node.PROCESSING_INSTRUCTION_NODE:
            ProcessingInstruction pi = (ProcessingInstruction) node;
            return createProcessingInstruction(pi.getTarget(), pi.getData());

        case Node.TEXT_NODE:
            return createTextNode(((Text) node).getData());

        default:
            throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Unsupported node type " + node.getNodeType());
        }
    }

    /**
     * Returns a copy of the given node or subtree with this document as its
     * owner.
     *
     * @param operation either {@link UserDataHandler#NODE_CLONED} or
     *      {@link UserDataHandler#NODE_IMPORTED}.
     * @param node a node belonging to any document or DOM implementation.
     * @param deep true to recursively copy any child nodes; false to do no such
     *      copying and return a node with no children.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.824 -0500", hash_original_method = "33992AC73E126DB7F05D741A2596DA1D", hash_generated_method = "33992AC73E126DB7F05D741A2596DA1D")
    
Node cloneOrImportNode(short operation, Node node, boolean deep) {
        NodeImpl copy = shallowCopy(operation, node);

        if (deep) {
            NodeList list = node.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                copy.appendChild(cloneOrImportNode(operation, list.item(i), deep));
            }
        }

        notifyUserDataHandlers(operation, node, copy);
        return copy;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.826 -0500", hash_original_method = "B9F8F7C255F6A56C10B3E640DB2181B9", hash_generated_method = "7A183D07331233E085A28724E48F8460")
    
public Node importNode(Node importedNode, boolean deep) {
        return cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
    }

    /**
     * Detaches the node from its parent (if any) and changes its document to
     * this document. The node's subtree and attributes will remain attached,
     * but their document will be changed to this document.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.829 -0500", hash_original_method = "5D3B579AF503CA96D628AD6AA8EE2361", hash_generated_method = "B942B2C2008C115A0C3F98637DFBC16D")
    
public Node adoptNode(Node node) {
        if (!(node instanceof NodeImpl)) {
            return null; // the API specifies this quiet failure
        }
        NodeImpl nodeImpl = (NodeImpl) node;
        switch (nodeImpl.getNodeType()) {
            case Node.ATTRIBUTE_NODE:
                AttrImpl attr = (AttrImpl) node;
                if (attr.ownerElement != null) {
                    attr.ownerElement.removeAttributeNode(attr);
                }
                break;

            case Node.DOCUMENT_FRAGMENT_NODE:
            case Node.ENTITY_REFERENCE_NODE:
            case Node.PROCESSING_INSTRUCTION_NODE:
            case Node.TEXT_NODE:
            case Node.CDATA_SECTION_NODE:
            case Node.COMMENT_NODE:
            case Node.ELEMENT_NODE:
                break;

            case Node.DOCUMENT_NODE:
            case Node.DOCUMENT_TYPE_NODE:
            case Node.ENTITY_NODE:
            case Node.NOTATION_NODE:
                throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Cannot adopt nodes of type " + nodeImpl.getNodeType());

            default:
                throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + node.getNodeType());
        }

        Node parent = nodeImpl.getParentNode();
        if (parent != null) {
            parent.removeChild(nodeImpl);
        }

        changeDocumentToThis(nodeImpl);
        notifyUserDataHandlers(UserDataHandler.NODE_ADOPTED, node, null);
        return nodeImpl;
    }

    /**
     * Recursively change the document of {@code node} without also changing its
     * parent node. Only adoptNode() should invoke this method, otherwise nodes
     * will be left in an inconsistent state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.832 -0500", hash_original_method = "AE2A1AE898A744D8ADE864AE8BDC4C1C", hash_generated_method = "42455D115284AA5D7F06ED32DA9CECB5")
    
private void changeDocumentToThis(NodeImpl node) {
        Map<String, UserData> userData = node.document.getUserDataMapForRead(node);
        if (!userData.isEmpty()) {
            getUserDataMap(node).putAll(userData);
        }
        node.document = this;

        // change the document on all child nodes
        NodeList list = node.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            changeDocumentToThis((NodeImpl) list.item(i));
        }

        // change the document on all attribute nodes
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            NamedNodeMap attributes = node.getAttributes();
            for (int i = 0; i < attributes.getLength(); i++) {
                changeDocumentToThis((AttrImpl) attributes.item(i));
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.834 -0500", hash_original_method = "B4181EC124183B0357F0B78B4540BB52", hash_generated_method = "C5AE1D6D64A3302C013599E9C179471D")
    
public Node renameNode(Node node, String namespaceURI, String qualifiedName) {
        if (node.getOwnerDocument() != this) {
            throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        }

        setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        return node;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.837 -0500", hash_original_method = "03FB31A26F55DD46B5E0B444E3BDF78D", hash_generated_method = "EAF0908AABD582019FDE2E3E1296E1A8")
    
public AttrImpl createAttribute(String name) {
        return new AttrImpl(this, name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.839 -0500", hash_original_method = "7E9190A2987BE4C0864253AAA3A5BE1B", hash_generated_method = "8C021403D381E8EEB125E545AB112957")
    
public AttrImpl createAttributeNS(String namespaceURI, String qualifiedName) {
        return new AttrImpl(this, namespaceURI, qualifiedName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.841 -0500", hash_original_method = "33E9B43072FE607E52B07810FE2FCABA", hash_generated_method = "C6DE19924B97C6AD3B89831ADDC535C6")
    
public CDATASectionImpl createCDATASection(String data) {
        return new CDATASectionImpl(this, data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.843 -0500", hash_original_method = "4FD6147AAF1A19FB78D88E22C913FA0B", hash_generated_method = "00015E40CA93436CACF37521E0B9965B")
    
public CommentImpl createComment(String data) {
        return new CommentImpl(this, data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.845 -0500", hash_original_method = "E0A12B60B45AEC987C1DC80CBB7F44C4", hash_generated_method = "F1FB018DE0BA61B1A9600B3FED1364A3")
    
public DocumentFragmentImpl createDocumentFragment() {
        return new DocumentFragmentImpl(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.847 -0500", hash_original_method = "292829053BF3153AB99E6877B4023526", hash_generated_method = "6BBF530EB5AC88EFEAB66A656FA1B7AF")
    
public ElementImpl createElement(String tagName) {
        return new ElementImpl(this, tagName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.849 -0500", hash_original_method = "A5861E1D8245000D4878ACAD76251828", hash_generated_method = "AE29FE9767384E0B9020D3B69B385E30")
    
public ElementImpl createElementNS(String namespaceURI, String qualifiedName) {
        return new ElementImpl(this, namespaceURI, qualifiedName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.851 -0500", hash_original_method = "3D6CE6751E22FD6EDABA3110F50E9507", hash_generated_method = "B1F0FB86B81FCA145E8DC8E241409906")
    
public EntityReferenceImpl createEntityReference(String name) {
        return new EntityReferenceImpl(this, name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.854 -0500", hash_original_method = "D7C06C722D311E922A32C921DF42A71E", hash_generated_method = "77E941C5CBDAB65965F6468A55ED9F74")
    
public ProcessingInstructionImpl createProcessingInstruction(String target, String data) {
        return new ProcessingInstructionImpl(this, target, data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.856 -0500", hash_original_method = "194421EA05B5C62E27597F16A7528043", hash_generated_method = "C8BBF86F72B010CE2B9BB373E28C9E7E")
    
public TextImpl createTextNode(String data) {
        return new TextImpl(this, data);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.859 -0500", hash_original_method = "D024EAB4EE7007F22F93D8BE399D2ED2", hash_generated_method = "16C0248F777E57593B3FA01DE6E2B23C")
    
public DocumentType getDoctype() {
        for (LeafNodeImpl child : children) {
            if (child instanceof DocumentType) {
                return (DocumentType) child;
            }
        }

        return null;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.861 -0500", hash_original_method = "59978D20A08E2A3D10080AFCDAEC6A5E", hash_generated_method = "62FF05BA0DE7E633D67E5B98D95C93B5")
    
public Element getDocumentElement() {
        for (LeafNodeImpl child : children) {
            if (child instanceof Element) {
                return (Element) child;
            }
        }

        return null;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.863 -0500", hash_original_method = "F4A17E55F2C93FA371B29DDF570BB5F6", hash_generated_method = "0F5C189FAAEA52CA318332C012FF1B32")
    
public Element getElementById(String elementId) {
        ElementImpl root = (ElementImpl) getDocumentElement();

        return (root == null ? null : root.getElementById(elementId));
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.865 -0500", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "168E7265B92B25940BE256C44126574B")
    
public NodeList getElementsByTagName(String name) {
        NodeListImpl result = new NodeListImpl();
        getElementsByTagName(result, name);
        return result;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.868 -0500", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "564D369733C1D7372018653373C517B0")
    
public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        NodeListImpl result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        return result;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.871 -0500", hash_original_method = "871220F29645F989F5FF83627B59D2B9", hash_generated_method = "DF6F69AC905886EBB87859BE95B4DCD1")
    
public DOMImplementation getImplementation() {
        return domImplementation;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.873 -0500", hash_original_method = "3823D9F624F2EC5FAA072B7BE8806F96", hash_generated_method = "4822B8A7C06D73334A43C4F1DE616B84")
    
@Override
    public String getNodeName() {
        return "#document";
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.875 -0500", hash_original_method = "043CCE8DE1A8362BF53702E45F3637E9", hash_generated_method = "B13708E24B8804412251FF767ACDDE04")
    
@Override
    public short getNodeType() {
        return Node.DOCUMENT_NODE;
    }

    /**
     * Document elements may have at most one root element and at most one DTD
     * element.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.878 -0500", hash_original_method = "C51ADCEBFAB6A11E8C0AA42A3197A4ED", hash_generated_method = "E2D123D1E548598D71D6411AA5C174CA")
    
@Override public Node insertChildAt(Node toInsert, int index) {
        if (toInsert instanceof Element && getDocumentElement() != null) {
            throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one root element allowed");
        }
        if (toInsert instanceof DocumentType && getDoctype() != null) {
            throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one DOCTYPE element allowed");
        }
        return super.insertChildAt(toInsert, index);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.880 -0500", hash_original_method = "523640531DE4ABEBCC885A0C8EFFAA8E", hash_generated_method = "61B43AF77696F8245AC8BEDFC2783D9E")
    
@Override public String getTextContent() {
        return null;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.882 -0500", hash_original_method = "94C9917BD9FB417B21D37D438D58D41C", hash_generated_method = "706E556FB08BB6E7A4BABC1C8F5C630E")
    
public String getInputEncoding() {
        return inputEncoding;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.884 -0500", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "52CC0571C63508D20A0FDEAF20E2DECC")
    
public String getXmlEncoding() {
        return xmlEncoding;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.887 -0500", hash_original_method = "A9BBCA9526831CCA3B1BE6D8EEF33ABE", hash_generated_method = "A5BCF2FBACC90DCFA7095DA841949981")
    
public boolean getXmlStandalone() {
        return xmlStandalone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.889 -0500", hash_original_method = "9E601CBC8BB08C0D3B66A0213931419B", hash_generated_method = "802FF8A7745A2252E50166728623CE01")
    
public void setXmlStandalone(boolean xmlStandalone) {
        this.xmlStandalone = xmlStandalone;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.891 -0500", hash_original_method = "BC354AC833FDCF3905B7FEDC7BFD541D", hash_generated_method = "571BDA5666B65F28D5766911A4647F9A")
    
public String getXmlVersion() {
        return xmlVersion;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.892 -0500", hash_original_method = "C0A21B3EE9603BF0EAE2488DE43FD78E", hash_generated_method = "811C88988130D681AE5F07F96D7B5559")
    
public void setXmlVersion(String xmlVersion) {
        this.xmlVersion = xmlVersion;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.895 -0500", hash_original_method = "338EEC38209BE0DB329E33E9EDD7ED88", hash_generated_method = "A4E39CC48AEA5FCA3091EA7D7F612D52")
    
public boolean getStrictErrorChecking() {
        return strictErrorChecking;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.897 -0500", hash_original_method = "55375073A29EAEC23495FBD30A28EDB3", hash_generated_method = "EA96CA366AE5FACF5D9D6E10EDAD989A")
    
public void setStrictErrorChecking(boolean strictErrorChecking) {
        this.strictErrorChecking = strictErrorChecking;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.899 -0500", hash_original_method = "2433E48CE07A4EB6DFAAA40EF72A0853", hash_generated_method = "CBC03157E2506B8B8D8D9DCF0AFFA92F")
    
public String getDocumentURI() {
        return documentUri;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.901 -0500", hash_original_method = "2ABB3572AC2E2195C4BFB544AFA05B7C", hash_generated_method = "D990C4525CE58E82FE05F9C6CC911CA5")
    
public void setDocumentURI(String documentUri) {
        this.documentUri = documentUri;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.904 -0500", hash_original_method = "9C5D9FE4294F6D7509E6E0C2DA50CF2D", hash_generated_method = "5DF89564672A342EA7D75930BF90EBA7")
    
public DOMConfiguration getDomConfig() {
        if (domConfiguration == null) {
            domConfiguration = new DOMConfigurationImpl();
        }
        return domConfiguration;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.906 -0500", hash_original_method = "89D7CC816429D9C559DCCAF8A85B9CA9", hash_generated_method = "F44135ECDDF7ABA1AFBFFCD80B024913")
    
public void normalizeDocument() {
        Element root = getDocumentElement();
        if (root == null) {
            return;
        }

        ((DOMConfigurationImpl) getDomConfig()).normalize(root);
    }

    /**
     * Returns a map with the user data objects attached to the specified node.
     * This map is readable and writable.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.908 -0500", hash_original_method = "83962F2DF698AAA6D760C50C082C5A3C", hash_generated_method = "83962F2DF698AAA6D760C50C082C5A3C")
    
Map<String, UserData> getUserDataMap(NodeImpl node) {
        if (nodeToUserData == null) {
            nodeToUserData = new WeakHashMap<NodeImpl, Map<String, UserData>>();
        }
        Map<String, UserData> userDataMap = nodeToUserData.get(node);
        if (userDataMap == null) {
            userDataMap = new HashMap<String, UserData>();
            nodeToUserData.put(node, userDataMap);
        }
        return userDataMap;
    }

    /**
     * Returns a map with the user data objects attached to the specified node.
     * The returned map may be read-only.
     */
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.911 -0500", hash_original_method = "8B5F30F59CCBC9322DB0F048DEF01A52", hash_generated_method = "8B5F30F59CCBC9322DB0F048DEF01A52")
    
Map<String, UserData> getUserDataMapForRead(NodeImpl node) {
        if (nodeToUserData == null) {
            return Collections.emptyMap();
        }
        Map<String, UserData> userDataMap = nodeToUserData.get(node);
        return userDataMap == null
                ? Collections.<String, UserData>emptyMap()
                : userDataMap;
    }
    
}

