package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private DOMImplementation domImplementation;
    private DOMConfigurationImpl domConfiguration;
    private String documentUri;
    private String inputEncoding;
    private String xmlEncoding;
    private String xmlVersion = "1.0";
    private boolean xmlStandalone = false;
    private boolean strictErrorChecking = true;
    private WeakHashMap<NodeImpl, Map<String, UserData>> nodeToUserData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.213 -0400", hash_original_method = "163C3C7D3935E830694E09EA8384B9EA", hash_generated_method = "259C09E1352B2D8983BC598FA3323BB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DocumentImpl(DOMImplementationImpl impl, String namespaceURI,
            String qualifiedName, DocumentType doctype, String inputEncoding) {
        super(null);
        dsTaint.addTaint(namespaceURI);
        dsTaint.addTaint(impl.dsTaint);
        dsTaint.addTaint(inputEncoding);
        dsTaint.addTaint(qualifiedName);
        dsTaint.addTaint(doctype.dsTaint);
        this.document = this;
        {
            appendChild(doctype);
        } //End block
        {
            appendChild(createElementNS(namespaceURI, qualifiedName));
        } //End block
        // ---------- Original Method ----------
        //this.document = this;
        //this.domImplementation = impl;
        //this.inputEncoding = inputEncoding;
        //if (doctype != null) {
            //appendChild(doctype);
        //}
        //if (qualifiedName != null) {
            //appendChild(createElementNS(namespaceURI, qualifiedName));
        //}
    }

    
        private static boolean isXMLIdentifierStart(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c == '_');
    }

    
        private static boolean isXMLIdentifierPart(char c) {
        return isXMLIdentifierStart(c) || (c >= '0' && c <= '9') || (c == '-') || (c == '.');
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.214 -0400", hash_original_method = "71EB0F41099D1D8D08C83EAF224E8D36", hash_generated_method = "21CC557F6834FB4031482DAA65C12483")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NodeImpl shallowCopy(short operation, Node node) {
        dsTaint.addTaint(operation);
        dsTaint.addTaint(node.dsTaint);
        {
            Object var09E3B15CD8604B5CA0883ABFA37862BC_2133078004 = (node.getNodeType());
            //Begin case Node.ATTRIBUTE_NODE 
            AttrImpl attr;
            attr = (AttrImpl) node;
            //End case Node.ATTRIBUTE_NODE 
            //Begin case Node.ATTRIBUTE_NODE 
            AttrImpl attrCopy;
            //End case Node.ATTRIBUTE_NODE 
            //Begin case Node.ATTRIBUTE_NODE 
            {
                attrCopy = createAttributeNS(attr.getNamespaceURI(), attr.getLocalName());
                attrCopy.setPrefix(attr.getPrefix());
            } //End block
            {
                attrCopy = createAttribute(attr.getName());
            } //End block
            //End case Node.ATTRIBUTE_NODE 
            //Begin case Node.ATTRIBUTE_NODE 
            attrCopy.setNodeValue(attr.getValue());
            //End case Node.ATTRIBUTE_NODE 
            //Begin case Node.CDATA_SECTION_NODE 
            NodeImpl var1433150934698BE3B3C068E5747BEC81_1020168198 = (createCDATASection(((CharacterData) node).getData()));
            //End case Node.CDATA_SECTION_NODE 
            //Begin case Node.COMMENT_NODE 
            NodeImpl var3AB6CB7CA7FBFE8F9176A3E25E8388F4_306653600 = (createComment(((Comment) node).getData()));
            //End case Node.COMMENT_NODE 
            //Begin case Node.DOCUMENT_FRAGMENT_NODE 
            NodeImpl var538877C18B45DA977AE28E093D3DF976_306780601 = (createDocumentFragment());
            //End case Node.DOCUMENT_FRAGMENT_NODE 
            //Begin case Node.DOCUMENT_NODE Node.DOCUMENT_TYPE_NODE 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Cannot copy node of type " + node.getNodeType());
            //End case Node.DOCUMENT_NODE Node.DOCUMENT_TYPE_NODE 
            //Begin case Node.ELEMENT_NODE 
            ElementImpl element;
            element = (ElementImpl) node;
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ELEMENT_NODE 
            ElementImpl elementCopy;
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ELEMENT_NODE 
            {
                elementCopy = createElementNS(element.getNamespaceURI(), element.getLocalName());
                elementCopy.setPrefix(element.getPrefix());
            } //End block
            {
                elementCopy = createElement(element.getTagName());
            } //End block
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ELEMENT_NODE 
            NamedNodeMap attributes;
            attributes = element.getAttributes();
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ELEMENT_NODE 
            {
                int i;
                i = 0;
                boolean varB52A5F5C76706054FE03857094E040A4_1815030041 = (i < attributes.getLength());
                {
                    AttrImpl elementAttr;
                    elementAttr = (AttrImpl) attributes.item(i);
                    AttrImpl elementAttrCopy;
                    elementAttrCopy = (AttrImpl) shallowCopy(operation, elementAttr);
                    notifyUserDataHandlers(operation, elementAttr, elementAttrCopy);
                    {
                        elementCopy.setAttributeNodeNS(elementAttrCopy);
                    } //End block
                    {
                        elementCopy.setAttributeNode(elementAttrCopy);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ENTITY_NODE Node.NOTATION_NODE 
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            //End case Node.ENTITY_NODE Node.NOTATION_NODE 
            //Begin case Node.ENTITY_REFERENCE_NODE 
            NodeImpl var4921B2B6A35D1AE644CCC01ED92B7564_710002837 = (createEntityReference(node.getNodeName()));
            //End case Node.ENTITY_REFERENCE_NODE 
            //Begin case Node.PROCESSING_INSTRUCTION_NODE 
            ProcessingInstruction pi;
            pi = (ProcessingInstruction) node;
            //End case Node.PROCESSING_INSTRUCTION_NODE 
            //Begin case Node.PROCESSING_INSTRUCTION_NODE 
            NodeImpl varE745D7988FBFA988D8180193FF11536F_874475751 = (createProcessingInstruction(pi.getTarget(), pi.getData()));
            //End case Node.PROCESSING_INSTRUCTION_NODE 
            //Begin case Node.TEXT_NODE 
            NodeImpl var2E97E86A31848FA35C07B837A4A89259_1530085209 = (createTextNode(((Text) node).getData()));
            //End case Node.TEXT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Unsupported node type " + node.getNodeType());
            //End case default 
        } //End collapsed parenthetic
        return (NodeImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.214 -0400", hash_original_method = "33992AC73E126DB7F05D741A2596DA1D", hash_generated_method = "376FBF63549FCA3528B7AF808CCD1A63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Node cloneOrImportNode(short operation, Node node, boolean deep) {
        dsTaint.addTaint(operation);
        dsTaint.addTaint(node.dsTaint);
        dsTaint.addTaint(deep);
        NodeImpl copy;
        copy = shallowCopy(operation, node);
        {
            NodeList list;
            list = node.getChildNodes();
            {
                int i;
                i = 0;
                boolean varD38DCC138D8AE85AC511580302329122_1078596351 = (i < list.getLength());
                {
                    copy.appendChild(cloneOrImportNode(operation, list.item(i), deep));
                } //End block
            } //End collapsed parenthetic
        } //End block
        notifyUserDataHandlers(operation, node, copy);
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //NodeImpl copy = shallowCopy(operation, node);
        //if (deep) {
            //NodeList list = node.getChildNodes();
            //for (int i = 0; i < list.getLength(); i++) {
                //copy.appendChild(cloneOrImportNode(operation, list.item(i), deep));
            //}
        //}
        //notifyUserDataHandlers(operation, node, copy);
        //return copy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.215 -0400", hash_original_method = "B9F8F7C255F6A56C10B3E640DB2181B9", hash_generated_method = "D821BA5021EA75E80FC468171BF37B12")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node importNode(Node importedNode, boolean deep) {
        dsTaint.addTaint(importedNode.dsTaint);
        dsTaint.addTaint(deep);
        Node var503A15D00994FFB925DC7A60619D680B_986363973 = (cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep));
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.215 -0400", hash_original_method = "5D3B579AF503CA96D628AD6AA8EE2361", hash_generated_method = "5562553323BAC919D9BD2A857D933120")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node adoptNode(Node node) {
        dsTaint.addTaint(node.dsTaint);
        NodeImpl nodeImpl;
        nodeImpl = (NodeImpl) node;
        {
            Object var6BBEF303238720B74B8389D1213ECB55_191986416 = (nodeImpl.getNodeType());
            //Begin case Node.ATTRIBUTE_NODE 
            AttrImpl attr;
            attr = (AttrImpl) node;
            //End case Node.ATTRIBUTE_NODE 
            //Begin case Node.ATTRIBUTE_NODE 
            {
                attr.ownerElement.removeAttributeNode(attr);
            } //End block
            //End case Node.ATTRIBUTE_NODE 
            //Begin case Node.DOCUMENT_NODE Node.DOCUMENT_TYPE_NODE Node.ENTITY_NODE Node.NOTATION_NODE 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Cannot adopt nodes of type " + nodeImpl.getNodeType());
            //End case Node.DOCUMENT_NODE Node.DOCUMENT_TYPE_NODE Node.ENTITY_NODE Node.NOTATION_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + node.getNodeType());
            //End case default 
        } //End collapsed parenthetic
        Node parent;
        parent = nodeImpl.getParentNode();
        {
            parent.removeChild(nodeImpl);
        } //End block
        changeDocumentToThis(nodeImpl);
        notifyUserDataHandlers(UserDataHandler.NODE_ADOPTED, node, null);
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.215 -0400", hash_original_method = "AE2A1AE898A744D8ADE864AE8BDC4C1C", hash_generated_method = "EB1D6108D91133471E1498A8BAEF53A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void changeDocumentToThis(NodeImpl node) {
        dsTaint.addTaint(node.dsTaint);
        Map<String, UserData> userData;
        userData = node.document.getUserDataMapForRead(node);
        {
            boolean var2BD8DBC7AC026EFBD37682A9989557BC_2003673700 = (!userData.isEmpty());
            {
                getUserDataMap(node).putAll(userData);
            } //End block
        } //End collapsed parenthetic
        node.document = this;
        NodeList list;
        list = node.getChildNodes();
        {
            int i;
            i = 0;
            boolean var7D5CF764E267A57EB4954ADA1415240F_1165978512 = (i < list.getLength());
            {
                changeDocumentToThis((NodeImpl) list.item(i));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var652FE86C56206CB08EFEE8747EA1A76A_604637292 = (node.getNodeType() == Node.ELEMENT_NODE);
            {
                NamedNodeMap attributes;
                attributes = node.getAttributes();
                {
                    int i;
                    i = 0;
                    boolean var66E0E7022CDBCD518DFA8161D49D9AAF_1147737204 = (i < attributes.getLength());
                    {
                        changeDocumentToThis((AttrImpl) attributes.item(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Map<String, UserData> userData = node.document.getUserDataMapForRead(node);
        //if (!userData.isEmpty()) {
            //getUserDataMap(node).putAll(userData);
        //}
        //node.document = this;
        //NodeList list = node.getChildNodes();
        //for (int i = 0; i < list.getLength(); i++) {
            //changeDocumentToThis((NodeImpl) list.item(i));
        //}
        //if (node.getNodeType() == Node.ELEMENT_NODE) {
            //NamedNodeMap attributes = node.getAttributes();
            //for (int i = 0; i < attributes.getLength(); i++) {
                //changeDocumentToThis((AttrImpl) attributes.item(i));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.216 -0400", hash_original_method = "B4181EC124183B0357F0B78B4540BB52", hash_generated_method = "2DB0780F4635CD72258C9EC2347B91E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node renameNode(Node node, String namespaceURI, String qualifiedName) {
        dsTaint.addTaint(namespaceURI);
        dsTaint.addTaint(node.dsTaint);
        dsTaint.addTaint(qualifiedName);
        {
            boolean var85BF6B8FC8FE97D97DB1ED3788EB031C_1652507862 = (node.getOwnerDocument() != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            } //End block
        } //End collapsed parenthetic
        setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (node.getOwnerDocument() != this) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        //notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.216 -0400", hash_original_method = "03FB31A26F55DD46B5E0B444E3BDF78D", hash_generated_method = "C82DE1CD86799D48EF4FCE377822B5D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttrImpl createAttribute(String name) {
        dsTaint.addTaint(name);
        AttrImpl var96C53611888389DFFAB4C88AA405C59A_178130800 = (new AttrImpl(this, name));
        return (AttrImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AttrImpl(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.216 -0400", hash_original_method = "7E9190A2987BE4C0864253AAA3A5BE1B", hash_generated_method = "B43EEBD16BDDEF8D5B82E9351859B556")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttrImpl createAttributeNS(String namespaceURI, String qualifiedName) {
        dsTaint.addTaint(namespaceURI);
        dsTaint.addTaint(qualifiedName);
        AttrImpl var213B808107E7DA50EECA750B20CCF63D_478677886 = (new AttrImpl(this, namespaceURI, qualifiedName));
        return (AttrImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AttrImpl(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.216 -0400", hash_original_method = "33E9B43072FE607E52B07810FE2FCABA", hash_generated_method = "2FB3C3C36AE8244D6A05A552B1C6A409")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CDATASectionImpl createCDATASection(String data) {
        dsTaint.addTaint(data);
        CDATASectionImpl var3C4BE4515D11895029319588D04A15FE_1949419644 = (new CDATASectionImpl(this, data));
        return (CDATASectionImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new CDATASectionImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.217 -0400", hash_original_method = "4FD6147AAF1A19FB78D88E22C913FA0B", hash_generated_method = "10DD37A7CC8F66BB07EF41B26717C766")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CommentImpl createComment(String data) {
        dsTaint.addTaint(data);
        CommentImpl varD081E754AB44E76AEE37C71167D967CD_991016470 = (new CommentImpl(this, data));
        return (CommentImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new CommentImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.217 -0400", hash_original_method = "E0A12B60B45AEC987C1DC80CBB7F44C4", hash_generated_method = "E884E4D5524CE6E7A31C349343970EB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DocumentFragmentImpl createDocumentFragment() {
        DocumentFragmentImpl varC45B7F556DC58A8AC6193E3BED9CA6B2_1956042741 = (new DocumentFragmentImpl(this));
        return (DocumentFragmentImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DocumentFragmentImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.217 -0400", hash_original_method = "292829053BF3153AB99E6877B4023526", hash_generated_method = "1ABF231272E980A9038E8F739C1851D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ElementImpl createElement(String tagName) {
        dsTaint.addTaint(tagName);
        ElementImpl var8C3A76B441429DA1DBD8E824E92F08F0_310906023 = (new ElementImpl(this, tagName));
        return (ElementImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ElementImpl(this, tagName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.217 -0400", hash_original_method = "A5861E1D8245000D4878ACAD76251828", hash_generated_method = "86A3D9218BF169B218AEDC208887EBA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ElementImpl createElementNS(String namespaceURI, String qualifiedName) {
        dsTaint.addTaint(namespaceURI);
        dsTaint.addTaint(qualifiedName);
        ElementImpl var87526D2834B0FF96001F6CFBE6460E0B_1340928819 = (new ElementImpl(this, namespaceURI, qualifiedName));
        return (ElementImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ElementImpl(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.217 -0400", hash_original_method = "3D6CE6751E22FD6EDABA3110F50E9507", hash_generated_method = "A6A173D2A601915840A0649A93B135C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EntityReferenceImpl createEntityReference(String name) {
        dsTaint.addTaint(name);
        EntityReferenceImpl var12C03BE2A7AF2FA78D2D107CC9F5582A_1606056097 = (new EntityReferenceImpl(this, name));
        return (EntityReferenceImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new EntityReferenceImpl(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.217 -0400", hash_original_method = "D7C06C722D311E922A32C921DF42A71E", hash_generated_method = "1A6BCFC03DAED2A6ECC2DF2506CE9A55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProcessingInstructionImpl createProcessingInstruction(String target, String data) {
        dsTaint.addTaint(data);
        dsTaint.addTaint(target);
        ProcessingInstructionImpl var077AEF61C1C1ADB3958F541C292AEEC5_1886393927 = (new ProcessingInstructionImpl(this, target, data));
        return (ProcessingInstructionImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ProcessingInstructionImpl(this, target, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.218 -0400", hash_original_method = "194421EA05B5C62E27597F16A7528043", hash_generated_method = "6FBE98B073AC4AC035545675EC64D869")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextImpl createTextNode(String data) {
        dsTaint.addTaint(data);
        TextImpl varBD2B9A2066E365B0B80F7E4FBBEEFBAD_1829412446 = (new TextImpl(this, data));
        return (TextImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new TextImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.227 -0400", hash_original_method = "D024EAB4EE7007F22F93D8BE399D2ED2", hash_generated_method = "744AFC2F639E06EB629D3CA8538F387A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DocumentType getDoctype() {
        {
            Iterator<LeafNodeImpl> varD9F9BEAAEB1609B5416C40DE92F9DCC9_534414098 = (children).iterator();
            varD9F9BEAAEB1609B5416C40DE92F9DCC9_534414098.hasNext();
            LeafNodeImpl child = varD9F9BEAAEB1609B5416C40DE92F9DCC9_534414098.next();
        } //End collapsed parenthetic
        return (DocumentType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof DocumentType) {
                //return (DocumentType) child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.232 -0400", hash_original_method = "59978D20A08E2A3D10080AFCDAEC6A5E", hash_generated_method = "D90C19A254ED62373C4057F23AFC1B8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Element getDocumentElement() {
        {
            Iterator<LeafNodeImpl> varD9F9BEAAEB1609B5416C40DE92F9DCC9_617317385 = (children).iterator();
            varD9F9BEAAEB1609B5416C40DE92F9DCC9_617317385.hasNext();
            LeafNodeImpl child = varD9F9BEAAEB1609B5416C40DE92F9DCC9_617317385.next();
        } //End collapsed parenthetic
        return (Element)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof Element) {
                //return (Element) child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.233 -0400", hash_original_method = "F4A17E55F2C93FA371B29DDF570BB5F6", hash_generated_method = "0E133E235EE43B568CCF8909411A7CEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Element getElementById(String elementId) {
        dsTaint.addTaint(elementId);
        ElementImpl root;
        root = (ElementImpl) getDocumentElement();
        Element varA47E94EF53870E5FD0AA9B58859F2117_1103714188 = ((root == null ? null : root.getElementById(elementId))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return (Element)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ElementImpl root = (ElementImpl) getDocumentElement();
        //return (root == null ? null : root.getElementById(elementId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.233 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "447F9FCA8D0FC92C69CF6A8F635BAD93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NodeList getElementsByTagName(String name) {
        dsTaint.addTaint(name);
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagName(result, name);
        return (NodeList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagName(result, name);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.233 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "2BA2BA008BAF46E3B6A4998B4C5FD0BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(namespaceURI);
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        return (NodeList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagNameNS(result, namespaceURI, localName);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.233 -0400", hash_original_method = "871220F29645F989F5FF83627B59D2B9", hash_generated_method = "144C6A7D94CE7913181AE60BA83357AC")
    @DSModeled(DSC.SAFE)
    public DOMImplementation getImplementation() {
        return (DOMImplementation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return domImplementation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.233 -0400", hash_original_method = "3823D9F624F2EC5FAA072B7BE8806F96", hash_generated_method = "B9663F41ACE63CC9D3479E364528904D")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNodeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "#document";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.233 -0400", hash_original_method = "043CCE8DE1A8362BF53702E45F3637E9", hash_generated_method = "DAE44A26DCE7A46C7FAE9622FF4372A3")
    @DSModeled(DSC.SAFE)
    @Override
    public short getNodeType() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Node.DOCUMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.234 -0400", hash_original_method = "C51ADCEBFAB6A11E8C0AA42A3197A4ED", hash_generated_method = "3B981EBD594DB644010A44D880992A6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Node insertChildAt(Node toInsert, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(toInsert.dsTaint);
        {
            boolean var04BB177618B02F1518CBEFA9FED48CA0_445897045 = (toInsert instanceof Element && getDocumentElement() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one root element allowed");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD2DDB695B9F05EE403A0265E37F38EFF_380302726 = (toInsert instanceof DocumentType && getDoctype() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one DOCTYPE element allowed");
            } //End block
        } //End collapsed parenthetic
        Node varF140296933D69D996589F57E8E121FB3_175886887 = (super.insertChildAt(toInsert, index));
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (toInsert instanceof Element && getDocumentElement() != null) {
            //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    //"Only one root element allowed");
        //}
        //if (toInsert instanceof DocumentType && getDoctype() != null) {
            //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    //"Only one DOCTYPE element allowed");
        //}
        //return super.insertChildAt(toInsert, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.234 -0400", hash_original_method = "523640531DE4ABEBCC885A0C8EFFAA8E", hash_generated_method = "D51A24A10ECF039988627B53B57AB1B5")
    @DSModeled(DSC.SAFE)
    @Override
    public String getTextContent() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.235 -0400", hash_original_method = "94C9917BD9FB417B21D37D438D58D41C", hash_generated_method = "78F05104EDC15EF163548D524244FFC8")
    @DSModeled(DSC.SAFE)
    public String getInputEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return inputEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.235 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "87F3FE72ADA8B9643F1B6DFA95E5C786")
    @DSModeled(DSC.SAFE)
    public String getXmlEncoding() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return xmlEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.235 -0400", hash_original_method = "A9BBCA9526831CCA3B1BE6D8EEF33ABE", hash_generated_method = "6D13156D5E48E37CBFF1DFA6E2605E94")
    @DSModeled(DSC.SAFE)
    public boolean getXmlStandalone() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return xmlStandalone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.236 -0400", hash_original_method = "9E601CBC8BB08C0D3B66A0213931419B", hash_generated_method = "93C2CC247C43CA32A4B7501986B04A2F")
    @DSModeled(DSC.SAFE)
    public void setXmlStandalone(boolean xmlStandalone) {
        dsTaint.addTaint(xmlStandalone);
        // ---------- Original Method ----------
        //this.xmlStandalone = xmlStandalone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.236 -0400", hash_original_method = "BC354AC833FDCF3905B7FEDC7BFD541D", hash_generated_method = "D00179CA95FE228007ABFA0309BCF587")
    @DSModeled(DSC.SAFE)
    public String getXmlVersion() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return xmlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.236 -0400", hash_original_method = "C0A21B3EE9603BF0EAE2488DE43FD78E", hash_generated_method = "44EA4D3DC8F2A35E14593390B5E78A14")
    @DSModeled(DSC.SAFE)
    public void setXmlVersion(String xmlVersion) {
        dsTaint.addTaint(xmlVersion);
        // ---------- Original Method ----------
        //this.xmlVersion = xmlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.237 -0400", hash_original_method = "338EEC38209BE0DB329E33E9EDD7ED88", hash_generated_method = "56B0E70D42ABA02D149EDD723717F7A7")
    @DSModeled(DSC.SAFE)
    public boolean getStrictErrorChecking() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return strictErrorChecking;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.237 -0400", hash_original_method = "55375073A29EAEC23495FBD30A28EDB3", hash_generated_method = "37D601DB680900525F00D01B21F49B21")
    @DSModeled(DSC.SAFE)
    public void setStrictErrorChecking(boolean strictErrorChecking) {
        dsTaint.addTaint(strictErrorChecking);
        // ---------- Original Method ----------
        //this.strictErrorChecking = strictErrorChecking;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.237 -0400", hash_original_method = "2433E48CE07A4EB6DFAAA40EF72A0853", hash_generated_method = "BC9B10CD60592DBEA1EB36B5B3D92E9D")
    @DSModeled(DSC.SAFE)
    public String getDocumentURI() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return documentUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.238 -0400", hash_original_method = "2ABB3572AC2E2195C4BFB544AFA05B7C", hash_generated_method = "BB4EB112379B83290F7CE5F625DA0C21")
    @DSModeled(DSC.SAFE)
    public void setDocumentURI(String documentUri) {
        dsTaint.addTaint(documentUri);
        // ---------- Original Method ----------
        //this.documentUri = documentUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.239 -0400", hash_original_method = "9C5D9FE4294F6D7509E6E0C2DA50CF2D", hash_generated_method = "FE06B5460DA8093D69FE3B9D54441F40")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DOMConfiguration getDomConfig() {
        {
            domConfiguration = new DOMConfigurationImpl();
        } //End block
        return (DOMConfiguration)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (domConfiguration == null) {
            //domConfiguration = new DOMConfigurationImpl();
        //}
        //return domConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.239 -0400", hash_original_method = "89D7CC816429D9C559DCCAF8A85B9CA9", hash_generated_method = "57A4AFF372611908EDFB9510C8ACFAC3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void normalizeDocument() {
        Element root;
        root = getDocumentElement();
        ((DOMConfigurationImpl) getDomConfig()).normalize(root);
        // ---------- Original Method ----------
        //Element root = getDocumentElement();
        //if (root == null) {
            //return;
        //}
        //((DOMConfigurationImpl) getDomConfig()).normalize(root);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.240 -0400", hash_original_method = "83962F2DF698AAA6D760C50C082C5A3C", hash_generated_method = "084C6DEE51876073DDD1F7AE88F9D73D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Map<String, UserData> getUserDataMap(NodeImpl node) {
        dsTaint.addTaint(node.dsTaint);
        {
            nodeToUserData = new WeakHashMap<NodeImpl, Map<String, UserData>>();
        } //End block
        Map<String, UserData> userDataMap;
        userDataMap = nodeToUserData.get(node);
        {
            userDataMap = new HashMap<String, UserData>();
            nodeToUserData.put(node, userDataMap);
        } //End block
        return (Map<String, UserData>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (nodeToUserData == null) {
            //nodeToUserData = new WeakHashMap<NodeImpl, Map<String, UserData>>();
        //}
        //Map<String, UserData> userDataMap = nodeToUserData.get(node);
        //if (userDataMap == null) {
            //userDataMap = new HashMap<String, UserData>();
            //nodeToUserData.put(node, userDataMap);
        //}
        //return userDataMap;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.240 -0400", hash_original_method = "8B5F30F59CCBC9322DB0F048DEF01A52", hash_generated_method = "ED23B42BB4E07E74814ABABDDF0F8249")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Map<String, UserData> getUserDataMapForRead(NodeImpl node) {
        dsTaint.addTaint(node.dsTaint);
        {
            Map<String, UserData> varC2F26C53BC551CEF4662FB3B09FFC95E_924865311 = (Collections.emptyMap());
        } //End block
        Map<String, UserData> userDataMap;
        userDataMap = nodeToUserData.get(node);
        {
            Object var20478DAF7192C586B7C5B56BDA695D11_1745069598 = (Collections.<String, UserData>emptyMap());
        } //End flattened ternary
        return (Map<String, UserData>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (nodeToUserData == null) {
            //return Collections.emptyMap();
        //}
        //Map<String, UserData> userDataMap = nodeToUserData.get(node);
        //return userDataMap == null
                //? Collections.<String, UserData>emptyMap()
                //: userDataMap;
    }

    
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

    
}

