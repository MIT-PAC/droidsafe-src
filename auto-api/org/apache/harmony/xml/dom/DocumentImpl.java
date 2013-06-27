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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.760 -0400", hash_original_field = "9A0C2D739DCDFB02BF9A89440A1742BE", hash_generated_field = "02CE798A8CB59B7226C8831D772A3C37")

    private DOMImplementation domImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.760 -0400", hash_original_field = "5C1DDF42AF97D3B8A25E52B51295CBCC", hash_generated_field = "4C2B5AB6B1E4F28DC9582765A0F90963")

    private DOMConfigurationImpl domConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.760 -0400", hash_original_field = "7F008BD20578B4549518F8F2105F0B56", hash_generated_field = "677F469BCAF22AAF9C9A1BCAA78B217D")

    private String documentUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.760 -0400", hash_original_field = "095EA6E25F03C3DC620F669B4CE91A23", hash_generated_field = "6E57DD71D7D0E77E0155AE21B6C03BD4")

    private String inputEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.760 -0400", hash_original_field = "CAD97869F74973B5626CFC237B513EAA", hash_generated_field = "656761370EB1B6AB6991B2A74412BA8B")

    private String xmlEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.760 -0400", hash_original_field = "D937E495C2709421D5BB34439EB7E5BF", hash_generated_field = "D19F092C2B57A6CC2509D5D658E0ECE5")

    private String xmlVersion = "1.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.760 -0400", hash_original_field = "D57C79C8DAC76C34330A7438298EC2AF", hash_generated_field = "ED1ABCCC72304E22012FCF1E2F4242CD")

    private boolean xmlStandalone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.760 -0400", hash_original_field = "A6BEA613612CBF77E8D9A1D2B43F7D75", hash_generated_field = "AEC49EFA08DDCABA663F00B7AA711A75")

    private boolean strictErrorChecking = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.760 -0400", hash_original_field = "83989D7A486A577204E595124E91C3FB", hash_generated_field = "2C2B0316F02F109A0965964EB1E285F6")

    private WeakHashMap<NodeImpl, Map<String, UserData>> nodeToUserData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.762 -0400", hash_original_method = "163C3C7D3935E830694E09EA8384B9EA", hash_generated_method = "B5FE01C124BF0138B331C2E93AD2C0DC")
    public  DocumentImpl(DOMImplementationImpl impl, String namespaceURI,
            String qualifiedName, DocumentType doctype, String inputEncoding) {
        super(null);
        this.document = this;
        this.domImplementation = impl;
        this.inputEncoding = inputEncoding;
        {
            appendChild(doctype);
        } //End block
        {
            appendChild(createElementNS(namespaceURI, qualifiedName));
        } //End block
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        addTaint(doctype.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.773 -0400", hash_original_method = "71EB0F41099D1D8D08C83EAF224E8D36", hash_generated_method = "322C2B2A845CC9C2E417B1F3DCEB3CC5")
    private NodeImpl shallowCopy(short operation, Node node) {
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1144420732 = null; //Variable for return #1
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_2084692274 = null; //Variable for return #2
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_2023392431 = null; //Variable for return #3
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1552854003 = null; //Variable for return #4
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1936387228 = null; //Variable for return #5
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_972795862 = null; //Variable for return #6
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1495150464 = null; //Variable for return #7
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_2089902303 = null; //Variable for return #8
        {
            Object var09E3B15CD8604B5CA0883ABFA37862BC_1131081180 = (node.getNodeType());
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
            //Begin case Node.ATTRIBUTE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1144420732 = attrCopy;
            //End case Node.ATTRIBUTE_NODE 
            //Begin case Node.CDATA_SECTION_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_2084692274 = createCDATASection(((CharacterData) node).getData());
            //End case Node.CDATA_SECTION_NODE 
            //Begin case Node.COMMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_2023392431 = createComment(((Comment) node).getData());
            //End case Node.COMMENT_NODE 
            //Begin case Node.DOCUMENT_FRAGMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1552854003 = createDocumentFragment();
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
                boolean varB52A5F5C76706054FE03857094E040A4_85776197 = (i < attributes.getLength());
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
            //Begin case Node.ELEMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1936387228 = elementCopy;
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ENTITY_NODE Node.NOTATION_NODE 
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            //End case Node.ENTITY_NODE Node.NOTATION_NODE 
            //Begin case Node.ENTITY_REFERENCE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_972795862 = createEntityReference(node.getNodeName());
            //End case Node.ENTITY_REFERENCE_NODE 
            //Begin case Node.PROCESSING_INSTRUCTION_NODE 
            ProcessingInstruction pi;
            pi = (ProcessingInstruction) node;
            //End case Node.PROCESSING_INSTRUCTION_NODE 
            //Begin case Node.PROCESSING_INSTRUCTION_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1495150464 = createProcessingInstruction(pi.getTarget(), pi.getData());
            //End case Node.PROCESSING_INSTRUCTION_NODE 
            //Begin case Node.TEXT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_2089902303 = createTextNode(((Text) node).getData());
            //End case Node.TEXT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Unsupported node type " + node.getNodeType());
            //End case default 
        } //End collapsed parenthetic
        addTaint(operation);
        addTaint(node.getTaint());
        NodeImpl varA7E53CE21691AB073D9660D615818899_211293870; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_211293870 = varB4EAC82CA7396A68D541C85D26508E83_1144420732;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_211293870 = varB4EAC82CA7396A68D541C85D26508E83_2084692274;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_211293870 = varB4EAC82CA7396A68D541C85D26508E83_2023392431;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_211293870 = varB4EAC82CA7396A68D541C85D26508E83_1552854003;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_211293870 = varB4EAC82CA7396A68D541C85D26508E83_1936387228;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_211293870 = varB4EAC82CA7396A68D541C85D26508E83_972795862;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_211293870 = varB4EAC82CA7396A68D541C85D26508E83_1495150464;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_211293870 = varB4EAC82CA7396A68D541C85D26508E83_2089902303;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_211293870.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_211293870;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.779 -0400", hash_original_method = "33992AC73E126DB7F05D741A2596DA1D", hash_generated_method = "EAF544BF31099B61C50B5C67F4E8651F")
     Node cloneOrImportNode(short operation, Node node, boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_878241135 = null; //Variable for return #1
        NodeImpl copy;
        copy = shallowCopy(operation, node);
        {
            NodeList list;
            list = node.getChildNodes();
            {
                int i;
                i = 0;
                boolean varD38DCC138D8AE85AC511580302329122_602295948 = (i < list.getLength());
                {
                    copy.appendChild(cloneOrImportNode(operation, list.item(i), deep));
                } //End block
            } //End collapsed parenthetic
        } //End block
        notifyUserDataHandlers(operation, node, copy);
        varB4EAC82CA7396A68D541C85D26508E83_878241135 = copy;
        addTaint(operation);
        addTaint(node.getTaint());
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_878241135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_878241135;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.779 -0400", hash_original_method = "B9F8F7C255F6A56C10B3E640DB2181B9", hash_generated_method = "DAE7027398BAC54BBB44D03F1667D96C")
    public Node importNode(Node importedNode, boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_252991365 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_252991365 = cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
        addTaint(importedNode.getTaint());
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_252991365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_252991365;
        // ---------- Original Method ----------
        //return cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.790 -0400", hash_original_method = "5D3B579AF503CA96D628AD6AA8EE2361", hash_generated_method = "31641C99A9BC5792E78A0F7A15AA4942")
    public Node adoptNode(Node node) {
        Node varB4EAC82CA7396A68D541C85D26508E83_722991929 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_1656106496 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_722991929 = null;
        } //End block
        NodeImpl nodeImpl;
        nodeImpl = (NodeImpl) node;
        {
            Object var6BBEF303238720B74B8389D1213ECB55_434802976 = (nodeImpl.getNodeType());
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
        varB4EAC82CA7396A68D541C85D26508E83_1656106496 = nodeImpl;
        addTaint(node.getTaint());
        Node varA7E53CE21691AB073D9660D615818899_64411940; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_64411940 = varB4EAC82CA7396A68D541C85D26508E83_722991929;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_64411940 = varB4EAC82CA7396A68D541C85D26508E83_1656106496;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_64411940.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_64411940;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.815 -0400", hash_original_method = "AE2A1AE898A744D8ADE864AE8BDC4C1C", hash_generated_method = "F1F5B7F8BD1935C7BB03FA3C1F400C84")
    private void changeDocumentToThis(NodeImpl node) {
        Map<String, UserData> userData;
        userData = node.document.getUserDataMapForRead(node);
        {
            boolean var2BD8DBC7AC026EFBD37682A9989557BC_944281344 = (!userData.isEmpty());
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
            boolean var7D5CF764E267A57EB4954ADA1415240F_96083373 = (i < list.getLength());
            {
                changeDocumentToThis((NodeImpl) list.item(i));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var652FE86C56206CB08EFEE8747EA1A76A_442949786 = (node.getNodeType() == Node.ELEMENT_NODE);
            {
                NamedNodeMap attributes;
                attributes = node.getAttributes();
                {
                    int i;
                    i = 0;
                    boolean var66E0E7022CDBCD518DFA8161D49D9AAF_730766605 = (i < attributes.getLength());
                    {
                        changeDocumentToThis((AttrImpl) attributes.item(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(node.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.822 -0400", hash_original_method = "B4181EC124183B0357F0B78B4540BB52", hash_generated_method = "A8C5DDF5ED5667CF29DDF29C670C9A2A")
    public Node renameNode(Node node, String namespaceURI, String qualifiedName) {
        Node varB4EAC82CA7396A68D541C85D26508E83_255777287 = null; //Variable for return #1
        {
            boolean var85BF6B8FC8FE97D97DB1ED3788EB031C_1721708287 = (node.getOwnerDocument() != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            } //End block
        } //End collapsed parenthetic
        setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        varB4EAC82CA7396A68D541C85D26508E83_255777287 = node;
        addTaint(node.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_255777287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_255777287;
        // ---------- Original Method ----------
        //if (node.getOwnerDocument() != this) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        //notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.822 -0400", hash_original_method = "03FB31A26F55DD46B5E0B444E3BDF78D", hash_generated_method = "C964ED8A3D328E01C87E199402A8E5D0")
    public AttrImpl createAttribute(String name) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_411045741 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_411045741 = new AttrImpl(this, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_411045741.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_411045741;
        // ---------- Original Method ----------
        //return new AttrImpl(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.825 -0400", hash_original_method = "7E9190A2987BE4C0864253AAA3A5BE1B", hash_generated_method = "526A496017DEB146BB579123CE8269F4")
    public AttrImpl createAttributeNS(String namespaceURI, String qualifiedName) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_2033049451 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2033049451 = new AttrImpl(this, namespaceURI, qualifiedName);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2033049451.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2033049451;
        // ---------- Original Method ----------
        //return new AttrImpl(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.825 -0400", hash_original_method = "33E9B43072FE607E52B07810FE2FCABA", hash_generated_method = "BB968310D26CEFF423E6BC655311C538")
    public CDATASectionImpl createCDATASection(String data) {
        CDATASectionImpl varB4EAC82CA7396A68D541C85D26508E83_1130896336 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1130896336 = new CDATASectionImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1130896336.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1130896336;
        // ---------- Original Method ----------
        //return new CDATASectionImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.827 -0400", hash_original_method = "4FD6147AAF1A19FB78D88E22C913FA0B", hash_generated_method = "9E5CFC240DC662E7AA61069BC50AB061")
    public CommentImpl createComment(String data) {
        CommentImpl varB4EAC82CA7396A68D541C85D26508E83_1230993415 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1230993415 = new CommentImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1230993415.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1230993415;
        // ---------- Original Method ----------
        //return new CommentImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.827 -0400", hash_original_method = "E0A12B60B45AEC987C1DC80CBB7F44C4", hash_generated_method = "79ED3A2C25A2B76ACD15A1A0A3506A7C")
    public DocumentFragmentImpl createDocumentFragment() {
        DocumentFragmentImpl varB4EAC82CA7396A68D541C85D26508E83_1663461503 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1663461503 = new DocumentFragmentImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_1663461503.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1663461503;
        // ---------- Original Method ----------
        //return new DocumentFragmentImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.834 -0400", hash_original_method = "292829053BF3153AB99E6877B4023526", hash_generated_method = "AAC7396029457ECB1873D2CC1AC731A8")
    public ElementImpl createElement(String tagName) {
        ElementImpl varB4EAC82CA7396A68D541C85D26508E83_2087033279 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2087033279 = new ElementImpl(this, tagName);
        addTaint(tagName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2087033279.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2087033279;
        // ---------- Original Method ----------
        //return new ElementImpl(this, tagName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.834 -0400", hash_original_method = "A5861E1D8245000D4878ACAD76251828", hash_generated_method = "D3FD0B2587FC190D112E65DB316A40F6")
    public ElementImpl createElementNS(String namespaceURI, String qualifiedName) {
        ElementImpl varB4EAC82CA7396A68D541C85D26508E83_1291761548 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1291761548 = new ElementImpl(this, namespaceURI, qualifiedName);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1291761548.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1291761548;
        // ---------- Original Method ----------
        //return new ElementImpl(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.835 -0400", hash_original_method = "3D6CE6751E22FD6EDABA3110F50E9507", hash_generated_method = "1788EBA6A0F8114AB3D2624577110414")
    public EntityReferenceImpl createEntityReference(String name) {
        EntityReferenceImpl varB4EAC82CA7396A68D541C85D26508E83_1536276680 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1536276680 = new EntityReferenceImpl(this, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1536276680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1536276680;
        // ---------- Original Method ----------
        //return new EntityReferenceImpl(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.835 -0400", hash_original_method = "D7C06C722D311E922A32C921DF42A71E", hash_generated_method = "394BB866DD8EA1186938B6129B0431DF")
    public ProcessingInstructionImpl createProcessingInstruction(String target, String data) {
        ProcessingInstructionImpl varB4EAC82CA7396A68D541C85D26508E83_607855251 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_607855251 = new ProcessingInstructionImpl(this, target, data);
        addTaint(target.getTaint());
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_607855251.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_607855251;
        // ---------- Original Method ----------
        //return new ProcessingInstructionImpl(this, target, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.836 -0400", hash_original_method = "194421EA05B5C62E27597F16A7528043", hash_generated_method = "FF36F8829152EDBAEE0F92D9304D1AE1")
    public TextImpl createTextNode(String data) {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_1995318592 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1995318592 = new TextImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1995318592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1995318592;
        // ---------- Original Method ----------
        //return new TextImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.877 -0400", hash_original_method = "D024EAB4EE7007F22F93D8BE399D2ED2", hash_generated_method = "1E677E03BFA9E9479CF04D914CF4C736")
    public DocumentType getDoctype() {
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_1063011676 = null; //Variable for return #1
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_1036339970 = null; //Variable for return #2
        {
            Iterator<LeafNodeImpl> varD9F9BEAAEB1609B5416C40DE92F9DCC9_168132769 = (children).iterator();
            varD9F9BEAAEB1609B5416C40DE92F9DCC9_168132769.hasNext();
            LeafNodeImpl child = varD9F9BEAAEB1609B5416C40DE92F9DCC9_168132769.next();
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1063011676 = (DocumentType) child;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1036339970 = null;
        DocumentType varA7E53CE21691AB073D9660D615818899_1523937689; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1523937689 = varB4EAC82CA7396A68D541C85D26508E83_1063011676;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1523937689 = varB4EAC82CA7396A68D541C85D26508E83_1036339970;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1523937689.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1523937689;
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof DocumentType) {
                //return (DocumentType) child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.913 -0400", hash_original_method = "59978D20A08E2A3D10080AFCDAEC6A5E", hash_generated_method = "446EF5D4FF230719FB35D0E23382EE86")
    public Element getDocumentElement() {
        Element varB4EAC82CA7396A68D541C85D26508E83_203561227 = null; //Variable for return #1
        Element varB4EAC82CA7396A68D541C85D26508E83_713278115 = null; //Variable for return #2
        {
            Iterator<LeafNodeImpl> varD9F9BEAAEB1609B5416C40DE92F9DCC9_1769807160 = (children).iterator();
            varD9F9BEAAEB1609B5416C40DE92F9DCC9_1769807160.hasNext();
            LeafNodeImpl child = varD9F9BEAAEB1609B5416C40DE92F9DCC9_1769807160.next();
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_203561227 = (Element) child;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_713278115 = null;
        Element varA7E53CE21691AB073D9660D615818899_68274646; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_68274646 = varB4EAC82CA7396A68D541C85D26508E83_203561227;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_68274646 = varB4EAC82CA7396A68D541C85D26508E83_713278115;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_68274646.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_68274646;
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof Element) {
                //return (Element) child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.914 -0400", hash_original_method = "F4A17E55F2C93FA371B29DDF570BB5F6", hash_generated_method = "042D7AE18E1559766C0FC49017EF6173")
    public Element getElementById(String elementId) {
        Element varB4EAC82CA7396A68D541C85D26508E83_790604944 = null; //Variable for return #1
        ElementImpl root;
        root = (ElementImpl) getDocumentElement();
        varB4EAC82CA7396A68D541C85D26508E83_790604944 = (root == null ? null : root.getElementById(elementId));
        addTaint(elementId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_790604944.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_790604944;
        // ---------- Original Method ----------
        //ElementImpl root = (ElementImpl) getDocumentElement();
        //return (root == null ? null : root.getElementById(elementId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.915 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "ED1CB260A7DAF4C982E483C0D182EF2D")
    public NodeList getElementsByTagName(String name) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_297909465 = null; //Variable for return #1
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagName(result, name);
        varB4EAC82CA7396A68D541C85D26508E83_297909465 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_297909465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_297909465;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagName(result, name);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.932 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "562505886EA83DB1D995DAD452E87E69")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_1073475685 = null; //Variable for return #1
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        varB4EAC82CA7396A68D541C85D26508E83_1073475685 = result;
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1073475685.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1073475685;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagNameNS(result, namespaceURI, localName);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.933 -0400", hash_original_method = "871220F29645F989F5FF83627B59D2B9", hash_generated_method = "A27CD92650DBDAF2A1DBE29B985F0E9E")
    public DOMImplementation getImplementation() {
        DOMImplementation varB4EAC82CA7396A68D541C85D26508E83_309080727 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_309080727 = domImplementation;
        varB4EAC82CA7396A68D541C85D26508E83_309080727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_309080727;
        // ---------- Original Method ----------
        //return domImplementation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.933 -0400", hash_original_method = "3823D9F624F2EC5FAA072B7BE8806F96", hash_generated_method = "55A890F0783D6C02EE077F27973B16B1")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1136756528 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1136756528 = "#document";
        varB4EAC82CA7396A68D541C85D26508E83_1136756528.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1136756528;
        // ---------- Original Method ----------
        //return "#document";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.934 -0400", hash_original_method = "043CCE8DE1A8362BF53702E45F3637E9", hash_generated_method = "9B9B198AE7CD69B7249402BCA55E476A")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1429156031 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1429156031;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.934 -0400", hash_original_method = "C51ADCEBFAB6A11E8C0AA42A3197A4ED", hash_generated_method = "32CE1D2809692D552B5D41E47FAC0029")
    @Override
    public Node insertChildAt(Node toInsert, int index) {
        Node varB4EAC82CA7396A68D541C85D26508E83_700754720 = null; //Variable for return #1
        {
            boolean var04BB177618B02F1518CBEFA9FED48CA0_1479632906 = (toInsert instanceof Element && getDocumentElement() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one root element allowed");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD2DDB695B9F05EE403A0265E37F38EFF_379008131 = (toInsert instanceof DocumentType && getDoctype() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one DOCTYPE element allowed");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_700754720 = super.insertChildAt(toInsert, index);
        addTaint(toInsert.getTaint());
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_700754720.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_700754720;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.935 -0400", hash_original_method = "523640531DE4ABEBCC885A0C8EFFAA8E", hash_generated_method = "176C7DC0622871811BAB13DEC045DEB4")
    @Override
    public String getTextContent() {
        String varB4EAC82CA7396A68D541C85D26508E83_658708032 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_658708032 = null;
        varB4EAC82CA7396A68D541C85D26508E83_658708032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658708032;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.935 -0400", hash_original_method = "94C9917BD9FB417B21D37D438D58D41C", hash_generated_method = "F24083BB3FFF8186BA632FD567A2B8FD")
    public String getInputEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_696279126 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_696279126 = inputEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_696279126.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_696279126;
        // ---------- Original Method ----------
        //return inputEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.936 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "6876CDBD4B14056FA9793218901D8D7E")
    public String getXmlEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_394906710 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_394906710 = xmlEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_394906710.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_394906710;
        // ---------- Original Method ----------
        //return xmlEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.937 -0400", hash_original_method = "A9BBCA9526831CCA3B1BE6D8EEF33ABE", hash_generated_method = "6F2F9218062D13CA2FE80DD68D63DFDD")
    public boolean getXmlStandalone() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_73615902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_73615902;
        // ---------- Original Method ----------
        //return xmlStandalone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.937 -0400", hash_original_method = "9E601CBC8BB08C0D3B66A0213931419B", hash_generated_method = "9E81AB93ADB44B2013F3533C3DA5BE8E")
    public void setXmlStandalone(boolean xmlStandalone) {
        this.xmlStandalone = xmlStandalone;
        // ---------- Original Method ----------
        //this.xmlStandalone = xmlStandalone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.944 -0400", hash_original_method = "BC354AC833FDCF3905B7FEDC7BFD541D", hash_generated_method = "DE075A05579570B60E834AC413BC470B")
    public String getXmlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_153538790 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_153538790 = xmlVersion;
        varB4EAC82CA7396A68D541C85D26508E83_153538790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_153538790;
        // ---------- Original Method ----------
        //return xmlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.961 -0400", hash_original_method = "C0A21B3EE9603BF0EAE2488DE43FD78E", hash_generated_method = "1D025D03CF816AA6E6E7E13C188987CA")
    public void setXmlVersion(String xmlVersion) {
        this.xmlVersion = xmlVersion;
        // ---------- Original Method ----------
        //this.xmlVersion = xmlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.962 -0400", hash_original_method = "338EEC38209BE0DB329E33E9EDD7ED88", hash_generated_method = "D7F779B177362869F32BB72BA07F53D9")
    public boolean getStrictErrorChecking() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1711240394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1711240394;
        // ---------- Original Method ----------
        //return strictErrorChecking;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.962 -0400", hash_original_method = "55375073A29EAEC23495FBD30A28EDB3", hash_generated_method = "B5D30D71D7A11256EBFA7BCECCF3D144")
    public void setStrictErrorChecking(boolean strictErrorChecking) {
        this.strictErrorChecking = strictErrorChecking;
        // ---------- Original Method ----------
        //this.strictErrorChecking = strictErrorChecking;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.962 -0400", hash_original_method = "2433E48CE07A4EB6DFAAA40EF72A0853", hash_generated_method = "A134DA569DF882A95AD2AB8D98C96F41")
    public String getDocumentURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_668044005 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_668044005 = documentUri;
        varB4EAC82CA7396A68D541C85D26508E83_668044005.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_668044005;
        // ---------- Original Method ----------
        //return documentUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.963 -0400", hash_original_method = "2ABB3572AC2E2195C4BFB544AFA05B7C", hash_generated_method = "88DFDC039A98BD865B0FDF5C62AD2EAE")
    public void setDocumentURI(String documentUri) {
        this.documentUri = documentUri;
        // ---------- Original Method ----------
        //this.documentUri = documentUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.963 -0400", hash_original_method = "9C5D9FE4294F6D7509E6E0C2DA50CF2D", hash_generated_method = "094251DBCAE55743E43447908B53424D")
    public DOMConfiguration getDomConfig() {
        DOMConfiguration varB4EAC82CA7396A68D541C85D26508E83_1514365614 = null; //Variable for return #1
        {
            domConfiguration = new DOMConfigurationImpl();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1514365614 = domConfiguration;
        varB4EAC82CA7396A68D541C85D26508E83_1514365614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514365614;
        // ---------- Original Method ----------
        //if (domConfiguration == null) {
            //domConfiguration = new DOMConfigurationImpl();
        //}
        //return domConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.963 -0400", hash_original_method = "89D7CC816429D9C559DCCAF8A85B9CA9", hash_generated_method = "57A4AFF372611908EDFB9510C8ACFAC3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.967 -0400", hash_original_method = "83962F2DF698AAA6D760C50C082C5A3C", hash_generated_method = "47DB646542AF0285EEE7766F1FD1ACFE")
     Map<String, UserData> getUserDataMap(NodeImpl node) {
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_2058410773 = null; //Variable for return #1
        {
            nodeToUserData = new WeakHashMap<NodeImpl, Map<String, UserData>>();
        } //End block
        Map<String, UserData> userDataMap;
        userDataMap = nodeToUserData.get(node);
        {
            userDataMap = new HashMap<String, UserData>();
            nodeToUserData.put(node, userDataMap);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2058410773 = userDataMap;
        addTaint(node.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2058410773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2058410773;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.968 -0400", hash_original_method = "8B5F30F59CCBC9322DB0F048DEF01A52", hash_generated_method = "2576FAEC7DF25927D54C2C2D8F841A30")
     Map<String, UserData> getUserDataMapForRead(NodeImpl node) {
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_2019135077 = null; //Variable for return #1
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_37334855 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2019135077 = Collections.emptyMap();
        } //End block
        Map<String, UserData> userDataMap;
        userDataMap = nodeToUserData.get(node);
        varB4EAC82CA7396A68D541C85D26508E83_37334855 = userDataMap == null
                ? Collections.<String, UserData>emptyMap()
                : userDataMap;
        addTaint(node.getTaint());
        Map<String, UserData> varA7E53CE21691AB073D9660D615818899_403207530; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_403207530 = varB4EAC82CA7396A68D541C85D26508E83_2019135077;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_403207530 = varB4EAC82CA7396A68D541C85D26508E83_37334855;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_403207530.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_403207530;
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

