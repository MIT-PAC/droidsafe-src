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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.928 -0400", hash_original_field = "9A0C2D739DCDFB02BF9A89440A1742BE", hash_generated_field = "02CE798A8CB59B7226C8831D772A3C37")

    private DOMImplementation domImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.928 -0400", hash_original_field = "5C1DDF42AF97D3B8A25E52B51295CBCC", hash_generated_field = "4C2B5AB6B1E4F28DC9582765A0F90963")

    private DOMConfigurationImpl domConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.928 -0400", hash_original_field = "7F008BD20578B4549518F8F2105F0B56", hash_generated_field = "677F469BCAF22AAF9C9A1BCAA78B217D")

    private String documentUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.928 -0400", hash_original_field = "095EA6E25F03C3DC620F669B4CE91A23", hash_generated_field = "6E57DD71D7D0E77E0155AE21B6C03BD4")

    private String inputEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.928 -0400", hash_original_field = "CAD97869F74973B5626CFC237B513EAA", hash_generated_field = "656761370EB1B6AB6991B2A74412BA8B")

    private String xmlEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.928 -0400", hash_original_field = "D937E495C2709421D5BB34439EB7E5BF", hash_generated_field = "D19F092C2B57A6CC2509D5D658E0ECE5")

    private String xmlVersion = "1.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.929 -0400", hash_original_field = "D57C79C8DAC76C34330A7438298EC2AF", hash_generated_field = "ED1ABCCC72304E22012FCF1E2F4242CD")

    private boolean xmlStandalone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.929 -0400", hash_original_field = "A6BEA613612CBF77E8D9A1D2B43F7D75", hash_generated_field = "AEC49EFA08DDCABA663F00B7AA711A75")

    private boolean strictErrorChecking = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.929 -0400", hash_original_field = "83989D7A486A577204E595124E91C3FB", hash_generated_field = "2C2B0316F02F109A0965964EB1E285F6")

    private WeakHashMap<NodeImpl, Map<String, UserData>> nodeToUserData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.929 -0400", hash_original_method = "163C3C7D3935E830694E09EA8384B9EA", hash_generated_method = "B5FE01C124BF0138B331C2E93AD2C0DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.935 -0400", hash_original_method = "71EB0F41099D1D8D08C83EAF224E8D36", hash_generated_method = "E475603BFE2873C7867464A5D61C64AE")
    private NodeImpl shallowCopy(short operation, Node node) {
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_91126006 = null; //Variable for return #1
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1540877000 = null; //Variable for return #2
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1438463589 = null; //Variable for return #3
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1327519085 = null; //Variable for return #4
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_51308003 = null; //Variable for return #5
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_842464205 = null; //Variable for return #6
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1586907820 = null; //Variable for return #7
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_992456602 = null; //Variable for return #8
        {
            Object var09E3B15CD8604B5CA0883ABFA37862BC_1942059733 = (node.getNodeType());
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
            varB4EAC82CA7396A68D541C85D26508E83_91126006 = attrCopy;
            //End case Node.ATTRIBUTE_NODE 
            //Begin case Node.CDATA_SECTION_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1540877000 = createCDATASection(((CharacterData) node).getData());
            //End case Node.CDATA_SECTION_NODE 
            //Begin case Node.COMMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1438463589 = createComment(((Comment) node).getData());
            //End case Node.COMMENT_NODE 
            //Begin case Node.DOCUMENT_FRAGMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1327519085 = createDocumentFragment();
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
                boolean varB52A5F5C76706054FE03857094E040A4_200495887 = (i < attributes.getLength());
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
            varB4EAC82CA7396A68D541C85D26508E83_51308003 = elementCopy;
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ENTITY_NODE Node.NOTATION_NODE 
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            //End case Node.ENTITY_NODE Node.NOTATION_NODE 
            //Begin case Node.ENTITY_REFERENCE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_842464205 = createEntityReference(node.getNodeName());
            //End case Node.ENTITY_REFERENCE_NODE 
            //Begin case Node.PROCESSING_INSTRUCTION_NODE 
            ProcessingInstruction pi;
            pi = (ProcessingInstruction) node;
            //End case Node.PROCESSING_INSTRUCTION_NODE 
            //Begin case Node.PROCESSING_INSTRUCTION_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1586907820 = createProcessingInstruction(pi.getTarget(), pi.getData());
            //End case Node.PROCESSING_INSTRUCTION_NODE 
            //Begin case Node.TEXT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_992456602 = createTextNode(((Text) node).getData());
            //End case Node.TEXT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Unsupported node type " + node.getNodeType());
            //End case default 
        } //End collapsed parenthetic
        addTaint(operation);
        addTaint(node.getTaint());
        NodeImpl varA7E53CE21691AB073D9660D615818899_477534114; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_477534114 = varB4EAC82CA7396A68D541C85D26508E83_91126006;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_477534114 = varB4EAC82CA7396A68D541C85D26508E83_1540877000;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_477534114 = varB4EAC82CA7396A68D541C85D26508E83_1438463589;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_477534114 = varB4EAC82CA7396A68D541C85D26508E83_1327519085;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_477534114 = varB4EAC82CA7396A68D541C85D26508E83_51308003;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_477534114 = varB4EAC82CA7396A68D541C85D26508E83_842464205;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_477534114 = varB4EAC82CA7396A68D541C85D26508E83_1586907820;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_477534114 = varB4EAC82CA7396A68D541C85D26508E83_992456602;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_477534114.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_477534114;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.949 -0400", hash_original_method = "33992AC73E126DB7F05D741A2596DA1D", hash_generated_method = "43D3B0379F281C55E72F40209620B6D7")
     Node cloneOrImportNode(short operation, Node node, boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1227746828 = null; //Variable for return #1
        NodeImpl copy;
        copy = shallowCopy(operation, node);
        {
            NodeList list;
            list = node.getChildNodes();
            {
                int i;
                i = 0;
                boolean varD38DCC138D8AE85AC511580302329122_1538428552 = (i < list.getLength());
                {
                    copy.appendChild(cloneOrImportNode(operation, list.item(i), deep));
                } //End block
            } //End collapsed parenthetic
        } //End block
        notifyUserDataHandlers(operation, node, copy);
        varB4EAC82CA7396A68D541C85D26508E83_1227746828 = copy;
        addTaint(operation);
        addTaint(node.getTaint());
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_1227746828.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1227746828;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.949 -0400", hash_original_method = "B9F8F7C255F6A56C10B3E640DB2181B9", hash_generated_method = "ACEF786C62C49DB8235D6E3471CFC3AB")
    public Node importNode(Node importedNode, boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_974698107 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_974698107 = cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
        addTaint(importedNode.getTaint());
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_974698107.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_974698107;
        // ---------- Original Method ----------
        //return cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.951 -0400", hash_original_method = "5D3B579AF503CA96D628AD6AA8EE2361", hash_generated_method = "38E4B1A140BD1FF51C674A0D6C851A73")
    public Node adoptNode(Node node) {
        Node varB4EAC82CA7396A68D541C85D26508E83_17411940 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_1219476047 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_17411940 = null;
        } //End block
        NodeImpl nodeImpl;
        nodeImpl = (NodeImpl) node;
        {
            Object var6BBEF303238720B74B8389D1213ECB55_117161437 = (nodeImpl.getNodeType());
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
        varB4EAC82CA7396A68D541C85D26508E83_1219476047 = nodeImpl;
        addTaint(node.getTaint());
        Node varA7E53CE21691AB073D9660D615818899_1766634909; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1766634909 = varB4EAC82CA7396A68D541C85D26508E83_17411940;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1766634909 = varB4EAC82CA7396A68D541C85D26508E83_1219476047;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1766634909.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1766634909;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.960 -0400", hash_original_method = "AE2A1AE898A744D8ADE864AE8BDC4C1C", hash_generated_method = "70C0B779C7BABE96E2EDE6EE44BD998B")
    private void changeDocumentToThis(NodeImpl node) {
        Map<String, UserData> userData;
        userData = node.document.getUserDataMapForRead(node);
        {
            boolean var2BD8DBC7AC026EFBD37682A9989557BC_749467675 = (!userData.isEmpty());
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
            boolean var7D5CF764E267A57EB4954ADA1415240F_1599102759 = (i < list.getLength());
            {
                changeDocumentToThis((NodeImpl) list.item(i));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var652FE86C56206CB08EFEE8747EA1A76A_261662915 = (node.getNodeType() == Node.ELEMENT_NODE);
            {
                NamedNodeMap attributes;
                attributes = node.getAttributes();
                {
                    int i;
                    i = 0;
                    boolean var66E0E7022CDBCD518DFA8161D49D9AAF_1595941128 = (i < attributes.getLength());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.969 -0400", hash_original_method = "B4181EC124183B0357F0B78B4540BB52", hash_generated_method = "77FC0C78F5CB19CE5A7E2BFBE698D05D")
    public Node renameNode(Node node, String namespaceURI, String qualifiedName) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1285825320 = null; //Variable for return #1
        {
            boolean var85BF6B8FC8FE97D97DB1ED3788EB031C_289983111 = (node.getOwnerDocument() != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            } //End block
        } //End collapsed parenthetic
        setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        varB4EAC82CA7396A68D541C85D26508E83_1285825320 = node;
        addTaint(node.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1285825320.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1285825320;
        // ---------- Original Method ----------
        //if (node.getOwnerDocument() != this) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        //notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.970 -0400", hash_original_method = "03FB31A26F55DD46B5E0B444E3BDF78D", hash_generated_method = "5B25954E04BCC9737D12A8F79C407875")
    public AttrImpl createAttribute(String name) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_377437969 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_377437969 = new AttrImpl(this, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_377437969.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_377437969;
        // ---------- Original Method ----------
        //return new AttrImpl(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.971 -0400", hash_original_method = "7E9190A2987BE4C0864253AAA3A5BE1B", hash_generated_method = "5560892716C7577E99F4E4C38C8DB429")
    public AttrImpl createAttributeNS(String namespaceURI, String qualifiedName) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_362287048 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_362287048 = new AttrImpl(this, namespaceURI, qualifiedName);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_362287048.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_362287048;
        // ---------- Original Method ----------
        //return new AttrImpl(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.972 -0400", hash_original_method = "33E9B43072FE607E52B07810FE2FCABA", hash_generated_method = "19CB38F5DCDD2B5F1BDB1F33ADE396D1")
    public CDATASectionImpl createCDATASection(String data) {
        CDATASectionImpl varB4EAC82CA7396A68D541C85D26508E83_1649910473 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1649910473 = new CDATASectionImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1649910473.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1649910473;
        // ---------- Original Method ----------
        //return new CDATASectionImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.989 -0400", hash_original_method = "4FD6147AAF1A19FB78D88E22C913FA0B", hash_generated_method = "4292E608EBDA5C76E4F5B0B4D2AFEC35")
    public CommentImpl createComment(String data) {
        CommentImpl varB4EAC82CA7396A68D541C85D26508E83_746748150 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_746748150 = new CommentImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_746748150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_746748150;
        // ---------- Original Method ----------
        //return new CommentImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.990 -0400", hash_original_method = "E0A12B60B45AEC987C1DC80CBB7F44C4", hash_generated_method = "B6F461EC7B09A00895B19C01E67922C6")
    public DocumentFragmentImpl createDocumentFragment() {
        DocumentFragmentImpl varB4EAC82CA7396A68D541C85D26508E83_1492212128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1492212128 = new DocumentFragmentImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_1492212128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1492212128;
        // ---------- Original Method ----------
        //return new DocumentFragmentImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.990 -0400", hash_original_method = "292829053BF3153AB99E6877B4023526", hash_generated_method = "22DC96E627AB26608C379F8B15C2DC46")
    public ElementImpl createElement(String tagName) {
        ElementImpl varB4EAC82CA7396A68D541C85D26508E83_1904697049 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1904697049 = new ElementImpl(this, tagName);
        addTaint(tagName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1904697049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1904697049;
        // ---------- Original Method ----------
        //return new ElementImpl(this, tagName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.992 -0400", hash_original_method = "A5861E1D8245000D4878ACAD76251828", hash_generated_method = "188AD47C1DF11B596BDE40F523D14B79")
    public ElementImpl createElementNS(String namespaceURI, String qualifiedName) {
        ElementImpl varB4EAC82CA7396A68D541C85D26508E83_528913409 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_528913409 = new ElementImpl(this, namespaceURI, qualifiedName);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_528913409.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_528913409;
        // ---------- Original Method ----------
        //return new ElementImpl(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.993 -0400", hash_original_method = "3D6CE6751E22FD6EDABA3110F50E9507", hash_generated_method = "4CF34E7D3AFE91F3D1639B3D7E1D44EF")
    public EntityReferenceImpl createEntityReference(String name) {
        EntityReferenceImpl varB4EAC82CA7396A68D541C85D26508E83_481803695 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_481803695 = new EntityReferenceImpl(this, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_481803695.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_481803695;
        // ---------- Original Method ----------
        //return new EntityReferenceImpl(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.003 -0400", hash_original_method = "D7C06C722D311E922A32C921DF42A71E", hash_generated_method = "44D60D0EC4C9C2CA1211EF5348E509A2")
    public ProcessingInstructionImpl createProcessingInstruction(String target, String data) {
        ProcessingInstructionImpl varB4EAC82CA7396A68D541C85D26508E83_338099852 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_338099852 = new ProcessingInstructionImpl(this, target, data);
        addTaint(target.getTaint());
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_338099852.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_338099852;
        // ---------- Original Method ----------
        //return new ProcessingInstructionImpl(this, target, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.003 -0400", hash_original_method = "194421EA05B5C62E27597F16A7528043", hash_generated_method = "CB9353CA949351EFEE27C71971718114")
    public TextImpl createTextNode(String data) {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_658737078 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_658737078 = new TextImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_658737078.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658737078;
        // ---------- Original Method ----------
        //return new TextImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.021 -0400", hash_original_method = "D024EAB4EE7007F22F93D8BE399D2ED2", hash_generated_method = "8E1A0063BC1E914112C08CE83D2D6313")
    public DocumentType getDoctype() {
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_1356076932 = null; //Variable for return #1
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_1575537340 = null; //Variable for return #2
        {
            Iterator<LeafNodeImpl> varD9F9BEAAEB1609B5416C40DE92F9DCC9_1880770315 = (children).iterator();
            varD9F9BEAAEB1609B5416C40DE92F9DCC9_1880770315.hasNext();
            LeafNodeImpl child = varD9F9BEAAEB1609B5416C40DE92F9DCC9_1880770315.next();
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1356076932 = (DocumentType) child;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1575537340 = null;
        DocumentType varA7E53CE21691AB073D9660D615818899_578374020; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_578374020 = varB4EAC82CA7396A68D541C85D26508E83_1356076932;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_578374020 = varB4EAC82CA7396A68D541C85D26508E83_1575537340;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_578374020.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_578374020;
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof DocumentType) {
                //return (DocumentType) child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.050 -0400", hash_original_method = "59978D20A08E2A3D10080AFCDAEC6A5E", hash_generated_method = "D7B4D3E229706F91E6578148D42EE838")
    public Element getDocumentElement() {
        Element varB4EAC82CA7396A68D541C85D26508E83_1624124233 = null; //Variable for return #1
        Element varB4EAC82CA7396A68D541C85D26508E83_252631926 = null; //Variable for return #2
        {
            Iterator<LeafNodeImpl> varD9F9BEAAEB1609B5416C40DE92F9DCC9_1490383408 = (children).iterator();
            varD9F9BEAAEB1609B5416C40DE92F9DCC9_1490383408.hasNext();
            LeafNodeImpl child = varD9F9BEAAEB1609B5416C40DE92F9DCC9_1490383408.next();
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1624124233 = (Element) child;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_252631926 = null;
        Element varA7E53CE21691AB073D9660D615818899_1178814522; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1178814522 = varB4EAC82CA7396A68D541C85D26508E83_1624124233;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1178814522 = varB4EAC82CA7396A68D541C85D26508E83_252631926;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1178814522.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1178814522;
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof Element) {
                //return (Element) child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.050 -0400", hash_original_method = "F4A17E55F2C93FA371B29DDF570BB5F6", hash_generated_method = "DA22AE1ABABB9EF235C362F76F8F07AD")
    public Element getElementById(String elementId) {
        Element varB4EAC82CA7396A68D541C85D26508E83_1790409319 = null; //Variable for return #1
        ElementImpl root;
        root = (ElementImpl) getDocumentElement();
        varB4EAC82CA7396A68D541C85D26508E83_1790409319 = (root == null ? null : root.getElementById(elementId));
        addTaint(elementId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1790409319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1790409319;
        // ---------- Original Method ----------
        //ElementImpl root = (ElementImpl) getDocumentElement();
        //return (root == null ? null : root.getElementById(elementId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.053 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "0B940CDBFB992DA57759C60FFC28DF5A")
    public NodeList getElementsByTagName(String name) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_717687996 = null; //Variable for return #1
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagName(result, name);
        varB4EAC82CA7396A68D541C85D26508E83_717687996 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_717687996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_717687996;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagName(result, name);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.059 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "C6697FA45AD0FBCC6FDC86C285F0F95C")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_1627082003 = null; //Variable for return #1
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        varB4EAC82CA7396A68D541C85D26508E83_1627082003 = result;
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1627082003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1627082003;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagNameNS(result, namespaceURI, localName);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.059 -0400", hash_original_method = "871220F29645F989F5FF83627B59D2B9", hash_generated_method = "7913B92925E611A952C699AD4341B0F5")
    public DOMImplementation getImplementation() {
        DOMImplementation varB4EAC82CA7396A68D541C85D26508E83_1521321710 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1521321710 = domImplementation;
        varB4EAC82CA7396A68D541C85D26508E83_1521321710.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1521321710;
        // ---------- Original Method ----------
        //return domImplementation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.060 -0400", hash_original_method = "3823D9F624F2EC5FAA072B7BE8806F96", hash_generated_method = "C4C1328C563CB25C147FD6FD47FE2D27")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_502539264 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_502539264 = "#document";
        varB4EAC82CA7396A68D541C85D26508E83_502539264.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_502539264;
        // ---------- Original Method ----------
        //return "#document";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.060 -0400", hash_original_method = "043CCE8DE1A8362BF53702E45F3637E9", hash_generated_method = "7F29A6EE1D0422E580B43227716DA2E1")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1674057126 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1674057126;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.072 -0400", hash_original_method = "C51ADCEBFAB6A11E8C0AA42A3197A4ED", hash_generated_method = "A1158A7DF4F7CF9E51DD04F4FBFEA9F6")
    @Override
    public Node insertChildAt(Node toInsert, int index) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1243729161 = null; //Variable for return #1
        {
            boolean var04BB177618B02F1518CBEFA9FED48CA0_1421786943 = (toInsert instanceof Element && getDocumentElement() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one root element allowed");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD2DDB695B9F05EE403A0265E37F38EFF_546665162 = (toInsert instanceof DocumentType && getDoctype() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one DOCTYPE element allowed");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1243729161 = super.insertChildAt(toInsert, index);
        addTaint(toInsert.getTaint());
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1243729161.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1243729161;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.073 -0400", hash_original_method = "523640531DE4ABEBCC885A0C8EFFAA8E", hash_generated_method = "58005B82CB35E315D4562B330AF800F8")
    @Override
    public String getTextContent() {
        String varB4EAC82CA7396A68D541C85D26508E83_269860745 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_269860745 = null;
        varB4EAC82CA7396A68D541C85D26508E83_269860745.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_269860745;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.073 -0400", hash_original_method = "94C9917BD9FB417B21D37D438D58D41C", hash_generated_method = "9F3C091BF1472459CE459AE535CC33B8")
    public String getInputEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1917291956 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1917291956 = inputEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1917291956.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1917291956;
        // ---------- Original Method ----------
        //return inputEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.074 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "15971F9D322FC03A00429ABC5109C1BE")
    public String getXmlEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1158962935 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1158962935 = xmlEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1158962935.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1158962935;
        // ---------- Original Method ----------
        //return xmlEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.078 -0400", hash_original_method = "A9BBCA9526831CCA3B1BE6D8EEF33ABE", hash_generated_method = "6223A5A5D951982C809CD5F9FF916A2F")
    public boolean getXmlStandalone() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_884694908 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_884694908;
        // ---------- Original Method ----------
        //return xmlStandalone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.078 -0400", hash_original_method = "9E601CBC8BB08C0D3B66A0213931419B", hash_generated_method = "9E81AB93ADB44B2013F3533C3DA5BE8E")
    public void setXmlStandalone(boolean xmlStandalone) {
        this.xmlStandalone = xmlStandalone;
        // ---------- Original Method ----------
        //this.xmlStandalone = xmlStandalone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.088 -0400", hash_original_method = "BC354AC833FDCF3905B7FEDC7BFD541D", hash_generated_method = "A71E249C21F3C3A397651E2E3E2210E7")
    public String getXmlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_1666644615 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1666644615 = xmlVersion;
        varB4EAC82CA7396A68D541C85D26508E83_1666644615.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1666644615;
        // ---------- Original Method ----------
        //return xmlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.088 -0400", hash_original_method = "C0A21B3EE9603BF0EAE2488DE43FD78E", hash_generated_method = "1D025D03CF816AA6E6E7E13C188987CA")
    public void setXmlVersion(String xmlVersion) {
        this.xmlVersion = xmlVersion;
        // ---------- Original Method ----------
        //this.xmlVersion = xmlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.089 -0400", hash_original_method = "338EEC38209BE0DB329E33E9EDD7ED88", hash_generated_method = "1BFFCDC2BEAA28A6E5BE16409EB94A3D")
    public boolean getStrictErrorChecking() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316298395 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316298395;
        // ---------- Original Method ----------
        //return strictErrorChecking;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.092 -0400", hash_original_method = "55375073A29EAEC23495FBD30A28EDB3", hash_generated_method = "B5D30D71D7A11256EBFA7BCECCF3D144")
    public void setStrictErrorChecking(boolean strictErrorChecking) {
        this.strictErrorChecking = strictErrorChecking;
        // ---------- Original Method ----------
        //this.strictErrorChecking = strictErrorChecking;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.094 -0400", hash_original_method = "2433E48CE07A4EB6DFAAA40EF72A0853", hash_generated_method = "061C838C6A0A7B00D4AE9DB71A9DDF08")
    public String getDocumentURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_968439634 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_968439634 = documentUri;
        varB4EAC82CA7396A68D541C85D26508E83_968439634.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_968439634;
        // ---------- Original Method ----------
        //return documentUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.094 -0400", hash_original_method = "2ABB3572AC2E2195C4BFB544AFA05B7C", hash_generated_method = "88DFDC039A98BD865B0FDF5C62AD2EAE")
    public void setDocumentURI(String documentUri) {
        this.documentUri = documentUri;
        // ---------- Original Method ----------
        //this.documentUri = documentUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.104 -0400", hash_original_method = "9C5D9FE4294F6D7509E6E0C2DA50CF2D", hash_generated_method = "CFC35150B1FA60F9944001FA792B8B16")
    public DOMConfiguration getDomConfig() {
        DOMConfiguration varB4EAC82CA7396A68D541C85D26508E83_34274178 = null; //Variable for return #1
        {
            domConfiguration = new DOMConfigurationImpl();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_34274178 = domConfiguration;
        varB4EAC82CA7396A68D541C85D26508E83_34274178.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_34274178;
        // ---------- Original Method ----------
        //if (domConfiguration == null) {
            //domConfiguration = new DOMConfigurationImpl();
        //}
        //return domConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.104 -0400", hash_original_method = "89D7CC816429D9C559DCCAF8A85B9CA9", hash_generated_method = "57A4AFF372611908EDFB9510C8ACFAC3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.105 -0400", hash_original_method = "83962F2DF698AAA6D760C50C082C5A3C", hash_generated_method = "0513D6530EF83C91316F2A1D9FC583F3")
     Map<String, UserData> getUserDataMap(NodeImpl node) {
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_106057060 = null; //Variable for return #1
        {
            nodeToUserData = new WeakHashMap<NodeImpl, Map<String, UserData>>();
        } //End block
        Map<String, UserData> userDataMap;
        userDataMap = nodeToUserData.get(node);
        {
            userDataMap = new HashMap<String, UserData>();
            nodeToUserData.put(node, userDataMap);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_106057060 = userDataMap;
        addTaint(node.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_106057060.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_106057060;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.105 -0400", hash_original_method = "8B5F30F59CCBC9322DB0F048DEF01A52", hash_generated_method = "B5EC28C44029AA80B3CDA0526424BE5B")
     Map<String, UserData> getUserDataMapForRead(NodeImpl node) {
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_1612505092 = null; //Variable for return #1
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_1914490603 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1612505092 = Collections.emptyMap();
        } //End block
        Map<String, UserData> userDataMap;
        userDataMap = nodeToUserData.get(node);
        varB4EAC82CA7396A68D541C85D26508E83_1914490603 = userDataMap == null
                ? Collections.<String, UserData>emptyMap()
                : userDataMap;
        addTaint(node.getTaint());
        Map<String, UserData> varA7E53CE21691AB073D9660D615818899_743885368; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_743885368 = varB4EAC82CA7396A68D541C85D26508E83_1612505092;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_743885368 = varB4EAC82CA7396A68D541C85D26508E83_1914490603;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_743885368.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_743885368;
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

