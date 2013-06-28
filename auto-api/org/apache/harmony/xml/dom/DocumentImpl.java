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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.963 -0400", hash_original_field = "9A0C2D739DCDFB02BF9A89440A1742BE", hash_generated_field = "02CE798A8CB59B7226C8831D772A3C37")

    private DOMImplementation domImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.963 -0400", hash_original_field = "5C1DDF42AF97D3B8A25E52B51295CBCC", hash_generated_field = "4C2B5AB6B1E4F28DC9582765A0F90963")

    private DOMConfigurationImpl domConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.963 -0400", hash_original_field = "7F008BD20578B4549518F8F2105F0B56", hash_generated_field = "677F469BCAF22AAF9C9A1BCAA78B217D")

    private String documentUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.963 -0400", hash_original_field = "095EA6E25F03C3DC620F669B4CE91A23", hash_generated_field = "6E57DD71D7D0E77E0155AE21B6C03BD4")

    private String inputEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.963 -0400", hash_original_field = "CAD97869F74973B5626CFC237B513EAA", hash_generated_field = "656761370EB1B6AB6991B2A74412BA8B")

    private String xmlEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.963 -0400", hash_original_field = "D937E495C2709421D5BB34439EB7E5BF", hash_generated_field = "D19F092C2B57A6CC2509D5D658E0ECE5")

    private String xmlVersion = "1.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.963 -0400", hash_original_field = "D57C79C8DAC76C34330A7438298EC2AF", hash_generated_field = "ED1ABCCC72304E22012FCF1E2F4242CD")

    private boolean xmlStandalone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.963 -0400", hash_original_field = "A6BEA613612CBF77E8D9A1D2B43F7D75", hash_generated_field = "AEC49EFA08DDCABA663F00B7AA711A75")

    private boolean strictErrorChecking = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.963 -0400", hash_original_field = "83989D7A486A577204E595124E91C3FB", hash_generated_field = "2C2B0316F02F109A0965964EB1E285F6")

    private WeakHashMap<NodeImpl, Map<String, UserData>> nodeToUserData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.964 -0400", hash_original_method = "163C3C7D3935E830694E09EA8384B9EA", hash_generated_method = "B5FE01C124BF0138B331C2E93AD2C0DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.966 -0400", hash_original_method = "71EB0F41099D1D8D08C83EAF224E8D36", hash_generated_method = "D45342567F58D74AB0E403CEE2D3F2C2")
    private NodeImpl shallowCopy(short operation, Node node) {
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_622527559 = null; //Variable for return #1
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_419811082 = null; //Variable for return #2
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_815010354 = null; //Variable for return #3
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1812404361 = null; //Variable for return #4
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1832365069 = null; //Variable for return #5
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_38132622 = null; //Variable for return #6
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1177099101 = null; //Variable for return #7
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1248793957 = null; //Variable for return #8
        {
            Object var09E3B15CD8604B5CA0883ABFA37862BC_663079568 = (node.getNodeType());
            //Begin case Node.ATTRIBUTE_NODE 
            AttrImpl attr = (AttrImpl) node;
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
            varB4EAC82CA7396A68D541C85D26508E83_622527559 = attrCopy;
            //End case Node.ATTRIBUTE_NODE 
            //Begin case Node.CDATA_SECTION_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_419811082 = createCDATASection(((CharacterData) node).getData());
            //End case Node.CDATA_SECTION_NODE 
            //Begin case Node.COMMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_815010354 = createComment(((Comment) node).getData());
            //End case Node.COMMENT_NODE 
            //Begin case Node.DOCUMENT_FRAGMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1812404361 = createDocumentFragment();
            //End case Node.DOCUMENT_FRAGMENT_NODE 
            //Begin case Node.DOCUMENT_NODE Node.DOCUMENT_TYPE_NODE 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Cannot copy node of type " + node.getNodeType());
            //End case Node.DOCUMENT_NODE Node.DOCUMENT_TYPE_NODE 
            //Begin case Node.ELEMENT_NODE 
            ElementImpl element = (ElementImpl) node;
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
            NamedNodeMap attributes = element.getAttributes();
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ELEMENT_NODE 
            {
                int i = 0;
                boolean varB52A5F5C76706054FE03857094E040A4_289389031 = (i < attributes.getLength());
                {
                    AttrImpl elementAttr = (AttrImpl) attributes.item(i);
                    AttrImpl elementAttrCopy = (AttrImpl) shallowCopy(operation, elementAttr);
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
            varB4EAC82CA7396A68D541C85D26508E83_1832365069 = elementCopy;
            //End case Node.ELEMENT_NODE 
            //Begin case Node.ENTITY_NODE Node.NOTATION_NODE 
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            //End case Node.ENTITY_NODE Node.NOTATION_NODE 
            //Begin case Node.ENTITY_REFERENCE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_38132622 = createEntityReference(node.getNodeName());
            //End case Node.ENTITY_REFERENCE_NODE 
            //Begin case Node.PROCESSING_INSTRUCTION_NODE 
            ProcessingInstruction pi = (ProcessingInstruction) node;
            //End case Node.PROCESSING_INSTRUCTION_NODE 
            //Begin case Node.PROCESSING_INSTRUCTION_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1177099101 = createProcessingInstruction(pi.getTarget(), pi.getData());
            //End case Node.PROCESSING_INSTRUCTION_NODE 
            //Begin case Node.TEXT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1248793957 = createTextNode(((Text) node).getData());
            //End case Node.TEXT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Unsupported node type " + node.getNodeType());
            //End case default 
        } //End collapsed parenthetic
        addTaint(operation);
        addTaint(node.getTaint());
        NodeImpl varA7E53CE21691AB073D9660D615818899_385081314; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_622527559;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_419811082;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_815010354;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_1812404361;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_1832365069;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_38132622;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_1177099101;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_1248793957;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_385081314.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_385081314;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.967 -0400", hash_original_method = "33992AC73E126DB7F05D741A2596DA1D", hash_generated_method = "425943538F930B51E1EA6048A5B4C13D")
     Node cloneOrImportNode(short operation, Node node, boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_279417790 = null; //Variable for return #1
        NodeImpl copy = shallowCopy(operation, node);
        {
            NodeList list = node.getChildNodes();
            {
                int i = 0;
                boolean varD38DCC138D8AE85AC511580302329122_1609600298 = (i < list.getLength());
                {
                    copy.appendChild(cloneOrImportNode(operation, list.item(i), deep));
                } //End block
            } //End collapsed parenthetic
        } //End block
        notifyUserDataHandlers(operation, node, copy);
        varB4EAC82CA7396A68D541C85D26508E83_279417790 = copy;
        addTaint(operation);
        addTaint(node.getTaint());
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_279417790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_279417790;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.968 -0400", hash_original_method = "B9F8F7C255F6A56C10B3E640DB2181B9", hash_generated_method = "5E48AC07996D8502B9ED5FC1C6DD5DF1")
    public Node importNode(Node importedNode, boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1109281202 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1109281202 = cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
        addTaint(importedNode.getTaint());
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_1109281202.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1109281202;
        // ---------- Original Method ----------
        //return cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.969 -0400", hash_original_method = "5D3B579AF503CA96D628AD6AA8EE2361", hash_generated_method = "9822DB9877F04E0AADF33D3219E643D9")
    public Node adoptNode(Node node) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1673330799 = null; //Variable for return #1
        Node varB4EAC82CA7396A68D541C85D26508E83_876669418 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1673330799 = null;
        } //End block
        NodeImpl nodeImpl = (NodeImpl) node;
        {
            Object var6BBEF303238720B74B8389D1213ECB55_971337156 = (nodeImpl.getNodeType());
            //Begin case Node.ATTRIBUTE_NODE 
            AttrImpl attr = (AttrImpl) node;
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
        Node parent = nodeImpl.getParentNode();
        {
            parent.removeChild(nodeImpl);
        } //End block
        changeDocumentToThis(nodeImpl);
        notifyUserDataHandlers(UserDataHandler.NODE_ADOPTED, node, null);
        varB4EAC82CA7396A68D541C85D26508E83_876669418 = nodeImpl;
        addTaint(node.getTaint());
        Node varA7E53CE21691AB073D9660D615818899_262806528; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_262806528 = varB4EAC82CA7396A68D541C85D26508E83_1673330799;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_262806528 = varB4EAC82CA7396A68D541C85D26508E83_876669418;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_262806528.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_262806528;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.970 -0400", hash_original_method = "AE2A1AE898A744D8ADE864AE8BDC4C1C", hash_generated_method = "3847AE075D387FD49F645AFADBC89215")
    private void changeDocumentToThis(NodeImpl node) {
        Map<String, UserData> userData = node.document.getUserDataMapForRead(node);
        {
            boolean var2BD8DBC7AC026EFBD37682A9989557BC_993780835 = (!userData.isEmpty());
            {
                getUserDataMap(node).putAll(userData);
            } //End block
        } //End collapsed parenthetic
        node.document = this;
        NodeList list = node.getChildNodes();
        {
            int i = 0;
            boolean var7D5CF764E267A57EB4954ADA1415240F_1166169263 = (i < list.getLength());
            {
                changeDocumentToThis((NodeImpl) list.item(i));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var652FE86C56206CB08EFEE8747EA1A76A_1407754524 = (node.getNodeType() == Node.ELEMENT_NODE);
            {
                NamedNodeMap attributes = node.getAttributes();
                {
                    int i = 0;
                    boolean var66E0E7022CDBCD518DFA8161D49D9AAF_1348135117 = (i < attributes.getLength());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.971 -0400", hash_original_method = "B4181EC124183B0357F0B78B4540BB52", hash_generated_method = "E0EB4DC7D850B835CB0A989295585AB5")
    public Node renameNode(Node node, String namespaceURI, String qualifiedName) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1082465243 = null; //Variable for return #1
        {
            boolean var85BF6B8FC8FE97D97DB1ED3788EB031C_545499200 = (node.getOwnerDocument() != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            } //End block
        } //End collapsed parenthetic
        setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        varB4EAC82CA7396A68D541C85D26508E83_1082465243 = node;
        addTaint(node.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1082465243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1082465243;
        // ---------- Original Method ----------
        //if (node.getOwnerDocument() != this) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        //notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.971 -0400", hash_original_method = "03FB31A26F55DD46B5E0B444E3BDF78D", hash_generated_method = "A72C5970D4525C4ADFCD2C9A978466CE")
    public AttrImpl createAttribute(String name) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_570497815 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_570497815 = new AttrImpl(this, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_570497815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_570497815;
        // ---------- Original Method ----------
        //return new AttrImpl(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.972 -0400", hash_original_method = "7E9190A2987BE4C0864253AAA3A5BE1B", hash_generated_method = "2319F3B84EAE5FB6E1008E03EE6BBF17")
    public AttrImpl createAttributeNS(String namespaceURI, String qualifiedName) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_1986417313 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1986417313 = new AttrImpl(this, namespaceURI, qualifiedName);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1986417313.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1986417313;
        // ---------- Original Method ----------
        //return new AttrImpl(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.972 -0400", hash_original_method = "33E9B43072FE607E52B07810FE2FCABA", hash_generated_method = "37BAE45CA7E9BB00C48B1E87EA0834D8")
    public CDATASectionImpl createCDATASection(String data) {
        CDATASectionImpl varB4EAC82CA7396A68D541C85D26508E83_1792284354 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1792284354 = new CDATASectionImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1792284354.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1792284354;
        // ---------- Original Method ----------
        //return new CDATASectionImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.973 -0400", hash_original_method = "4FD6147AAF1A19FB78D88E22C913FA0B", hash_generated_method = "995BFD7465B3AE57D140E8FA2750EFC4")
    public CommentImpl createComment(String data) {
        CommentImpl varB4EAC82CA7396A68D541C85D26508E83_1603634601 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1603634601 = new CommentImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1603634601.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1603634601;
        // ---------- Original Method ----------
        //return new CommentImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.973 -0400", hash_original_method = "E0A12B60B45AEC987C1DC80CBB7F44C4", hash_generated_method = "A6A28D2B7AC74500CB9F5EBBCA196A78")
    public DocumentFragmentImpl createDocumentFragment() {
        DocumentFragmentImpl varB4EAC82CA7396A68D541C85D26508E83_1993229058 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1993229058 = new DocumentFragmentImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_1993229058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1993229058;
        // ---------- Original Method ----------
        //return new DocumentFragmentImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.974 -0400", hash_original_method = "292829053BF3153AB99E6877B4023526", hash_generated_method = "B9383B7B9862198568A4B5B737BCE4E6")
    public ElementImpl createElement(String tagName) {
        ElementImpl varB4EAC82CA7396A68D541C85D26508E83_299476555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_299476555 = new ElementImpl(this, tagName);
        addTaint(tagName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_299476555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_299476555;
        // ---------- Original Method ----------
        //return new ElementImpl(this, tagName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.974 -0400", hash_original_method = "A5861E1D8245000D4878ACAD76251828", hash_generated_method = "37965C248B69118DD13A2CA179A42C08")
    public ElementImpl createElementNS(String namespaceURI, String qualifiedName) {
        ElementImpl varB4EAC82CA7396A68D541C85D26508E83_339216570 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_339216570 = new ElementImpl(this, namespaceURI, qualifiedName);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_339216570.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_339216570;
        // ---------- Original Method ----------
        //return new ElementImpl(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.975 -0400", hash_original_method = "3D6CE6751E22FD6EDABA3110F50E9507", hash_generated_method = "9526C64FD3B8B3F23B94D008334FFBC5")
    public EntityReferenceImpl createEntityReference(String name) {
        EntityReferenceImpl varB4EAC82CA7396A68D541C85D26508E83_840770139 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_840770139 = new EntityReferenceImpl(this, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_840770139.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_840770139;
        // ---------- Original Method ----------
        //return new EntityReferenceImpl(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.975 -0400", hash_original_method = "D7C06C722D311E922A32C921DF42A71E", hash_generated_method = "C28AA896FC747CE52973B8D23BF5E51E")
    public ProcessingInstructionImpl createProcessingInstruction(String target, String data) {
        ProcessingInstructionImpl varB4EAC82CA7396A68D541C85D26508E83_1993326265 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1993326265 = new ProcessingInstructionImpl(this, target, data);
        addTaint(target.getTaint());
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1993326265.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1993326265;
        // ---------- Original Method ----------
        //return new ProcessingInstructionImpl(this, target, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.976 -0400", hash_original_method = "194421EA05B5C62E27597F16A7528043", hash_generated_method = "9A72E4BE54C42EAB5E85D87EBC4D72E4")
    public TextImpl createTextNode(String data) {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_1455236647 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1455236647 = new TextImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1455236647.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1455236647;
        // ---------- Original Method ----------
        //return new TextImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.981 -0400", hash_original_method = "D024EAB4EE7007F22F93D8BE399D2ED2", hash_generated_method = "84017E2A539F112F9C858D48EBC7FB8B")
    public DocumentType getDoctype() {
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_346855712 = null; //Variable for return #1
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_750031489 = null; //Variable for return #2
        {
            Iterator<LeafNodeImpl> varD9F9BEAAEB1609B5416C40DE92F9DCC9_1063930909 = (children).iterator();
            varD9F9BEAAEB1609B5416C40DE92F9DCC9_1063930909.hasNext();
            LeafNodeImpl child = varD9F9BEAAEB1609B5416C40DE92F9DCC9_1063930909.next();
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_346855712 = (DocumentType) child;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_750031489 = null;
        DocumentType varA7E53CE21691AB073D9660D615818899_472499859; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_472499859 = varB4EAC82CA7396A68D541C85D26508E83_346855712;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_472499859 = varB4EAC82CA7396A68D541C85D26508E83_750031489;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_472499859.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_472499859;
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof DocumentType) {
                //return (DocumentType) child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.985 -0400", hash_original_method = "59978D20A08E2A3D10080AFCDAEC6A5E", hash_generated_method = "4206A0657064432403E0FEDA953BD57A")
    public Element getDocumentElement() {
        Element varB4EAC82CA7396A68D541C85D26508E83_1369667577 = null; //Variable for return #1
        Element varB4EAC82CA7396A68D541C85D26508E83_1984032709 = null; //Variable for return #2
        {
            Iterator<LeafNodeImpl> varD9F9BEAAEB1609B5416C40DE92F9DCC9_444227826 = (children).iterator();
            varD9F9BEAAEB1609B5416C40DE92F9DCC9_444227826.hasNext();
            LeafNodeImpl child = varD9F9BEAAEB1609B5416C40DE92F9DCC9_444227826.next();
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1369667577 = (Element) child;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1984032709 = null;
        Element varA7E53CE21691AB073D9660D615818899_1965560177; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1965560177 = varB4EAC82CA7396A68D541C85D26508E83_1369667577;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1965560177 = varB4EAC82CA7396A68D541C85D26508E83_1984032709;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1965560177.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1965560177;
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof Element) {
                //return (Element) child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.985 -0400", hash_original_method = "F4A17E55F2C93FA371B29DDF570BB5F6", hash_generated_method = "709756A1E77A8E90E28B74EB75C82093")
    public Element getElementById(String elementId) {
        Element varB4EAC82CA7396A68D541C85D26508E83_436869129 = null; //Variable for return #1
        ElementImpl root = (ElementImpl) getDocumentElement();
        varB4EAC82CA7396A68D541C85D26508E83_436869129 = (root == null ? null : root.getElementById(elementId));
        addTaint(elementId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_436869129.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_436869129;
        // ---------- Original Method ----------
        //ElementImpl root = (ElementImpl) getDocumentElement();
        //return (root == null ? null : root.getElementById(elementId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.986 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "C3A98F0BFA50891BECE896BE14FA5F1C")
    public NodeList getElementsByTagName(String name) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_909238634 = null; //Variable for return #1
        NodeListImpl result = new NodeListImpl();
        getElementsByTagName(result, name);
        varB4EAC82CA7396A68D541C85D26508E83_909238634 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_909238634.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_909238634;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagName(result, name);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.987 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "7D37CF19A95004B5EF7555FE2104B071")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_1258998233 = null; //Variable for return #1
        NodeListImpl result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        varB4EAC82CA7396A68D541C85D26508E83_1258998233 = result;
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1258998233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1258998233;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagNameNS(result, namespaceURI, localName);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.988 -0400", hash_original_method = "871220F29645F989F5FF83627B59D2B9", hash_generated_method = "EAAAAF1FB641A83308A6C16A64A1E3DA")
    public DOMImplementation getImplementation() {
        DOMImplementation varB4EAC82CA7396A68D541C85D26508E83_560051331 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_560051331 = domImplementation;
        varB4EAC82CA7396A68D541C85D26508E83_560051331.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_560051331;
        // ---------- Original Method ----------
        //return domImplementation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.988 -0400", hash_original_method = "3823D9F624F2EC5FAA072B7BE8806F96", hash_generated_method = "C63464EA2FC4955A9EA2364467949DAD")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_541840641 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_541840641 = "#document";
        varB4EAC82CA7396A68D541C85D26508E83_541840641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_541840641;
        // ---------- Original Method ----------
        //return "#document";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.989 -0400", hash_original_method = "043CCE8DE1A8362BF53702E45F3637E9", hash_generated_method = "3F022F9B36FC363604695629A2CBFA56")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_537151179 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_537151179;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.990 -0400", hash_original_method = "C51ADCEBFAB6A11E8C0AA42A3197A4ED", hash_generated_method = "49AF779B9B03DB76408088111C7CCC17")
    @Override
    public Node insertChildAt(Node toInsert, int index) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1684272268 = null; //Variable for return #1
        {
            boolean var04BB177618B02F1518CBEFA9FED48CA0_282101904 = (toInsert instanceof Element && getDocumentElement() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one root element allowed");
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD2DDB695B9F05EE403A0265E37F38EFF_439928021 = (toInsert instanceof DocumentType && getDoctype() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one DOCTYPE element allowed");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1684272268 = super.insertChildAt(toInsert, index);
        addTaint(toInsert.getTaint());
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1684272268.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1684272268;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.991 -0400", hash_original_method = "523640531DE4ABEBCC885A0C8EFFAA8E", hash_generated_method = "3B912C2B9892FA16B606A7239A1A0310")
    @Override
    public String getTextContent() {
        String varB4EAC82CA7396A68D541C85D26508E83_1575827385 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1575827385 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1575827385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1575827385;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.991 -0400", hash_original_method = "94C9917BD9FB417B21D37D438D58D41C", hash_generated_method = "E9FFE4657CAB12B0725BD210869C877F")
    public String getInputEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1747317049 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1747317049 = inputEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1747317049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1747317049;
        // ---------- Original Method ----------
        //return inputEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.992 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "E01C0555B9E002A8AF65149A4BB67B25")
    public String getXmlEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1238373996 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1238373996 = xmlEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1238373996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1238373996;
        // ---------- Original Method ----------
        //return xmlEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.993 -0400", hash_original_method = "A9BBCA9526831CCA3B1BE6D8EEF33ABE", hash_generated_method = "E546989B70CA9A58AB9017F9B9306488")
    public boolean getXmlStandalone() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1219670322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1219670322;
        // ---------- Original Method ----------
        //return xmlStandalone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.993 -0400", hash_original_method = "9E601CBC8BB08C0D3B66A0213931419B", hash_generated_method = "9E81AB93ADB44B2013F3533C3DA5BE8E")
    public void setXmlStandalone(boolean xmlStandalone) {
        this.xmlStandalone = xmlStandalone;
        // ---------- Original Method ----------
        //this.xmlStandalone = xmlStandalone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.994 -0400", hash_original_method = "BC354AC833FDCF3905B7FEDC7BFD541D", hash_generated_method = "D1B5E2A21761D22F13285DE90080484F")
    public String getXmlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_391548280 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_391548280 = xmlVersion;
        varB4EAC82CA7396A68D541C85D26508E83_391548280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_391548280;
        // ---------- Original Method ----------
        //return xmlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.994 -0400", hash_original_method = "C0A21B3EE9603BF0EAE2488DE43FD78E", hash_generated_method = "1D025D03CF816AA6E6E7E13C188987CA")
    public void setXmlVersion(String xmlVersion) {
        this.xmlVersion = xmlVersion;
        // ---------- Original Method ----------
        //this.xmlVersion = xmlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.994 -0400", hash_original_method = "338EEC38209BE0DB329E33E9EDD7ED88", hash_generated_method = "D91C8F10F239263591A51904E592E5ED")
    public boolean getStrictErrorChecking() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1460295096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1460295096;
        // ---------- Original Method ----------
        //return strictErrorChecking;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.995 -0400", hash_original_method = "55375073A29EAEC23495FBD30A28EDB3", hash_generated_method = "B5D30D71D7A11256EBFA7BCECCF3D144")
    public void setStrictErrorChecking(boolean strictErrorChecking) {
        this.strictErrorChecking = strictErrorChecking;
        // ---------- Original Method ----------
        //this.strictErrorChecking = strictErrorChecking;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.996 -0400", hash_original_method = "2433E48CE07A4EB6DFAAA40EF72A0853", hash_generated_method = "B82097050DBD3D59564067E207205FA7")
    public String getDocumentURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1698116428 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1698116428 = documentUri;
        varB4EAC82CA7396A68D541C85D26508E83_1698116428.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1698116428;
        // ---------- Original Method ----------
        //return documentUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.997 -0400", hash_original_method = "2ABB3572AC2E2195C4BFB544AFA05B7C", hash_generated_method = "88DFDC039A98BD865B0FDF5C62AD2EAE")
    public void setDocumentURI(String documentUri) {
        this.documentUri = documentUri;
        // ---------- Original Method ----------
        //this.documentUri = documentUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.999 -0400", hash_original_method = "9C5D9FE4294F6D7509E6E0C2DA50CF2D", hash_generated_method = "42CBA32FF79D14DB08FFD675C0910DCB")
    public DOMConfiguration getDomConfig() {
        DOMConfiguration varB4EAC82CA7396A68D541C85D26508E83_1849910742 = null; //Variable for return #1
        {
            domConfiguration = new DOMConfigurationImpl();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1849910742 = domConfiguration;
        varB4EAC82CA7396A68D541C85D26508E83_1849910742.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1849910742;
        // ---------- Original Method ----------
        //if (domConfiguration == null) {
            //domConfiguration = new DOMConfigurationImpl();
        //}
        //return domConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.000 -0400", hash_original_method = "89D7CC816429D9C559DCCAF8A85B9CA9", hash_generated_method = "2A263F9916A358FC93ECD804CC950359")
    public void normalizeDocument() {
        Element root = getDocumentElement();
        ((DOMConfigurationImpl) getDomConfig()).normalize(root);
        // ---------- Original Method ----------
        //Element root = getDocumentElement();
        //if (root == null) {
            //return;
        //}
        //((DOMConfigurationImpl) getDomConfig()).normalize(root);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.004 -0400", hash_original_method = "83962F2DF698AAA6D760C50C082C5A3C", hash_generated_method = "984E30F44B97C64503F740A3FA33CAFF")
     Map<String, UserData> getUserDataMap(NodeImpl node) {
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_1906694607 = null; //Variable for return #1
        {
            nodeToUserData = new WeakHashMap<NodeImpl, Map<String, UserData>>();
        } //End block
        Map<String, UserData> userDataMap = nodeToUserData.get(node);
        {
            userDataMap = new HashMap<String, UserData>();
            nodeToUserData.put(node, userDataMap);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1906694607 = userDataMap;
        addTaint(node.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1906694607.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1906694607;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.005 -0400", hash_original_method = "8B5F30F59CCBC9322DB0F048DEF01A52", hash_generated_method = "D1930783A384FC6A9D90865CB9008D1E")
     Map<String, UserData> getUserDataMapForRead(NodeImpl node) {
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_1402615827 = null; //Variable for return #1
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_1586639408 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1402615827 = Collections.emptyMap();
        } //End block
        Map<String, UserData> userDataMap = nodeToUserData.get(node);
        varB4EAC82CA7396A68D541C85D26508E83_1586639408 = userDataMap == null
                ? Collections.<String, UserData>emptyMap()
                : userDataMap;
        addTaint(node.getTaint());
        Map<String, UserData> varA7E53CE21691AB073D9660D615818899_2010544052; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2010544052 = varB4EAC82CA7396A68D541C85D26508E83_1402615827;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2010544052 = varB4EAC82CA7396A68D541C85D26508E83_1586639408;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2010544052.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2010544052;
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

