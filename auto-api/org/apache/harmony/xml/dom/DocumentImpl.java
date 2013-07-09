package org.apache.harmony.xml.dom;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
        } 
        {
            appendChild(createElementNS(namespaceURI, qualifiedName));
        } 
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        addTaint(doctype.getTaint());
        
        
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isXMLIdentifierStart(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c == '_');
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean isXMLIdentifierPart(char c) {
        return isXMLIdentifierStart(c) || (c >= '0' && c <= '9') || (c == '-') || (c == '.');
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.966 -0400", hash_original_method = "71EB0F41099D1D8D08C83EAF224E8D36", hash_generated_method = "D45342567F58D74AB0E403CEE2D3F2C2")
    private NodeImpl shallowCopy(short operation, Node node) {
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_622527559 = null; 
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_419811082 = null; 
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_815010354 = null; 
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1812404361 = null; 
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1832365069 = null; 
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_38132622 = null; 
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1177099101 = null; 
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1248793957 = null; 
        {
            Object var09E3B15CD8604B5CA0883ABFA37862BC_663079568 = (node.getNodeType());
            
            AttrImpl attr = (AttrImpl) node;
            
            
            AttrImpl attrCopy;
            
            
            {
                attrCopy = createAttributeNS(attr.getNamespaceURI(), attr.getLocalName());
                attrCopy.setPrefix(attr.getPrefix());
            } 
            {
                attrCopy = createAttribute(attr.getName());
            } 
            
            
            attrCopy.setNodeValue(attr.getValue());
            
            
            varB4EAC82CA7396A68D541C85D26508E83_622527559 = attrCopy;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_419811082 = createCDATASection(((CharacterData) node).getData());
            
            
            varB4EAC82CA7396A68D541C85D26508E83_815010354 = createComment(((Comment) node).getData());
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1812404361 = createDocumentFragment();
            
            
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Cannot copy node of type " + node.getNodeType());
            
            
            ElementImpl element = (ElementImpl) node;
            
            
            ElementImpl elementCopy;
            
            
            {
                elementCopy = createElementNS(element.getNamespaceURI(), element.getLocalName());
                elementCopy.setPrefix(element.getPrefix());
            } 
            {
                elementCopy = createElement(element.getTagName());
            } 
            
            
            NamedNodeMap attributes = element.getAttributes();
            
            
            {
                int i = 0;
                boolean varB52A5F5C76706054FE03857094E040A4_289389031 = (i < attributes.getLength());
                {
                    AttrImpl elementAttr = (AttrImpl) attributes.item(i);
                    AttrImpl elementAttrCopy = (AttrImpl) shallowCopy(operation, elementAttr);
                    notifyUserDataHandlers(operation, elementAttr, elementAttrCopy);
                    {
                        elementCopy.setAttributeNodeNS(elementAttrCopy);
                    } 
                    {
                        elementCopy.setAttributeNode(elementAttrCopy);
                    } 
                } 
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1832365069 = elementCopy;
            
            
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            
            
            varB4EAC82CA7396A68D541C85D26508E83_38132622 = createEntityReference(node.getNodeName());
            
            
            ProcessingInstruction pi = (ProcessingInstruction) node;
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1177099101 = createProcessingInstruction(pi.getTarget(), pi.getData());
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1248793957 = createTextNode(((Text) node).getData());
            
            
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Unsupported node type " + node.getNodeType());
            
        } 
        addTaint(operation);
        addTaint(node.getTaint());
        NodeImpl varA7E53CE21691AB073D9660D615818899_385081314; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_622527559;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_419811082;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_815010354;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_1812404361;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_1832365069;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_38132622;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_1177099101;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_385081314 = varB4EAC82CA7396A68D541C85D26508E83_1248793957;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_385081314.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_385081314;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.967 -0400", hash_original_method = "33992AC73E126DB7F05D741A2596DA1D", hash_generated_method = "425943538F930B51E1EA6048A5B4C13D")
     Node cloneOrImportNode(short operation, Node node, boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_279417790 = null; 
        NodeImpl copy = shallowCopy(operation, node);
        {
            NodeList list = node.getChildNodes();
            {
                int i = 0;
                boolean varD38DCC138D8AE85AC511580302329122_1609600298 = (i < list.getLength());
                {
                    copy.appendChild(cloneOrImportNode(operation, list.item(i), deep));
                } 
            } 
        } 
        notifyUserDataHandlers(operation, node, copy);
        varB4EAC82CA7396A68D541C85D26508E83_279417790 = copy;
        addTaint(operation);
        addTaint(node.getTaint());
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_279417790.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_279417790;
        
        
        
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.968 -0400", hash_original_method = "B9F8F7C255F6A56C10B3E640DB2181B9", hash_generated_method = "5E48AC07996D8502B9ED5FC1C6DD5DF1")
    public Node importNode(Node importedNode, boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1109281202 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1109281202 = cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
        addTaint(importedNode.getTaint());
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_1109281202.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1109281202;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.969 -0400", hash_original_method = "5D3B579AF503CA96D628AD6AA8EE2361", hash_generated_method = "9822DB9877F04E0AADF33D3219E643D9")
    public Node adoptNode(Node node) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1673330799 = null; 
        Node varB4EAC82CA7396A68D541C85D26508E83_876669418 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1673330799 = null;
        } 
        NodeImpl nodeImpl = (NodeImpl) node;
        {
            Object var6BBEF303238720B74B8389D1213ECB55_971337156 = (nodeImpl.getNodeType());
            
            AttrImpl attr = (AttrImpl) node;
            
            
            {
                attr.ownerElement.removeAttributeNode(attr);
            } 
            
            
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Cannot adopt nodes of type " + nodeImpl.getNodeType());
            
            
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + node.getNodeType());
            
        } 
        Node parent = nodeImpl.getParentNode();
        {
            parent.removeChild(nodeImpl);
        } 
        changeDocumentToThis(nodeImpl);
        notifyUserDataHandlers(UserDataHandler.NODE_ADOPTED, node, null);
        varB4EAC82CA7396A68D541C85D26508E83_876669418 = nodeImpl;
        addTaint(node.getTaint());
        Node varA7E53CE21691AB073D9660D615818899_262806528; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_262806528 = varB4EAC82CA7396A68D541C85D26508E83_1673330799;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_262806528 = varB4EAC82CA7396A68D541C85D26508E83_876669418;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_262806528.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_262806528;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.970 -0400", hash_original_method = "AE2A1AE898A744D8ADE864AE8BDC4C1C", hash_generated_method = "3847AE075D387FD49F645AFADBC89215")
    private void changeDocumentToThis(NodeImpl node) {
        Map<String, UserData> userData = node.document.getUserDataMapForRead(node);
        {
            boolean var2BD8DBC7AC026EFBD37682A9989557BC_993780835 = (!userData.isEmpty());
            {
                getUserDataMap(node).putAll(userData);
            } 
        } 
        node.document = this;
        NodeList list = node.getChildNodes();
        {
            int i = 0;
            boolean var7D5CF764E267A57EB4954ADA1415240F_1166169263 = (i < list.getLength());
            {
                changeDocumentToThis((NodeImpl) list.item(i));
            } 
        } 
        {
            boolean var652FE86C56206CB08EFEE8747EA1A76A_1407754524 = (node.getNodeType() == Node.ELEMENT_NODE);
            {
                NamedNodeMap attributes = node.getAttributes();
                {
                    int i = 0;
                    boolean var66E0E7022CDBCD518DFA8161D49D9AAF_1348135117 = (i < attributes.getLength());
                    {
                        changeDocumentToThis((AttrImpl) attributes.item(i));
                    } 
                } 
            } 
        } 
        addTaint(node.getTaint());
        
        
        
            
        
        
        
        
            
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.971 -0400", hash_original_method = "B4181EC124183B0357F0B78B4540BB52", hash_generated_method = "E0EB4DC7D850B835CB0A989295585AB5")
    public Node renameNode(Node node, String namespaceURI, String qualifiedName) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1082465243 = null; 
        {
            boolean var85BF6B8FC8FE97D97DB1ED3788EB031C_545499200 = (node.getOwnerDocument() != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            } 
        } 
        setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        varB4EAC82CA7396A68D541C85D26508E83_1082465243 = node;
        addTaint(node.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1082465243.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1082465243;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.971 -0400", hash_original_method = "03FB31A26F55DD46B5E0B444E3BDF78D", hash_generated_method = "A72C5970D4525C4ADFCD2C9A978466CE")
    public AttrImpl createAttribute(String name) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_570497815 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_570497815 = new AttrImpl(this, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_570497815.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_570497815;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.972 -0400", hash_original_method = "7E9190A2987BE4C0864253AAA3A5BE1B", hash_generated_method = "2319F3B84EAE5FB6E1008E03EE6BBF17")
    public AttrImpl createAttributeNS(String namespaceURI, String qualifiedName) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_1986417313 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1986417313 = new AttrImpl(this, namespaceURI, qualifiedName);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1986417313.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1986417313;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.972 -0400", hash_original_method = "33E9B43072FE607E52B07810FE2FCABA", hash_generated_method = "37BAE45CA7E9BB00C48B1E87EA0834D8")
    public CDATASectionImpl createCDATASection(String data) {
        CDATASectionImpl varB4EAC82CA7396A68D541C85D26508E83_1792284354 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1792284354 = new CDATASectionImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1792284354.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1792284354;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.973 -0400", hash_original_method = "4FD6147AAF1A19FB78D88E22C913FA0B", hash_generated_method = "995BFD7465B3AE57D140E8FA2750EFC4")
    public CommentImpl createComment(String data) {
        CommentImpl varB4EAC82CA7396A68D541C85D26508E83_1603634601 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1603634601 = new CommentImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1603634601.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1603634601;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.973 -0400", hash_original_method = "E0A12B60B45AEC987C1DC80CBB7F44C4", hash_generated_method = "A6A28D2B7AC74500CB9F5EBBCA196A78")
    public DocumentFragmentImpl createDocumentFragment() {
        DocumentFragmentImpl varB4EAC82CA7396A68D541C85D26508E83_1993229058 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1993229058 = new DocumentFragmentImpl(this);
        varB4EAC82CA7396A68D541C85D26508E83_1993229058.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1993229058;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.974 -0400", hash_original_method = "292829053BF3153AB99E6877B4023526", hash_generated_method = "B9383B7B9862198568A4B5B737BCE4E6")
    public ElementImpl createElement(String tagName) {
        ElementImpl varB4EAC82CA7396A68D541C85D26508E83_299476555 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_299476555 = new ElementImpl(this, tagName);
        addTaint(tagName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_299476555.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_299476555;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.974 -0400", hash_original_method = "A5861E1D8245000D4878ACAD76251828", hash_generated_method = "37965C248B69118DD13A2CA179A42C08")
    public ElementImpl createElementNS(String namespaceURI, String qualifiedName) {
        ElementImpl varB4EAC82CA7396A68D541C85D26508E83_339216570 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_339216570 = new ElementImpl(this, namespaceURI, qualifiedName);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_339216570.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_339216570;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.975 -0400", hash_original_method = "3D6CE6751E22FD6EDABA3110F50E9507", hash_generated_method = "9526C64FD3B8B3F23B94D008334FFBC5")
    public EntityReferenceImpl createEntityReference(String name) {
        EntityReferenceImpl varB4EAC82CA7396A68D541C85D26508E83_840770139 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_840770139 = new EntityReferenceImpl(this, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_840770139.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_840770139;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.975 -0400", hash_original_method = "D7C06C722D311E922A32C921DF42A71E", hash_generated_method = "C28AA896FC747CE52973B8D23BF5E51E")
    public ProcessingInstructionImpl createProcessingInstruction(String target, String data) {
        ProcessingInstructionImpl varB4EAC82CA7396A68D541C85D26508E83_1993326265 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1993326265 = new ProcessingInstructionImpl(this, target, data);
        addTaint(target.getTaint());
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1993326265.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1993326265;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.976 -0400", hash_original_method = "194421EA05B5C62E27597F16A7528043", hash_generated_method = "9A72E4BE54C42EAB5E85D87EBC4D72E4")
    public TextImpl createTextNode(String data) {
        TextImpl varB4EAC82CA7396A68D541C85D26508E83_1455236647 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1455236647 = new TextImpl(this, data);
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1455236647.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1455236647;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.981 -0400", hash_original_method = "D024EAB4EE7007F22F93D8BE399D2ED2", hash_generated_method = "84017E2A539F112F9C858D48EBC7FB8B")
    public DocumentType getDoctype() {
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_346855712 = null; 
        DocumentType varB4EAC82CA7396A68D541C85D26508E83_750031489 = null; 
        {
            Iterator<LeafNodeImpl> varD9F9BEAAEB1609B5416C40DE92F9DCC9_1063930909 = (children).iterator();
            varD9F9BEAAEB1609B5416C40DE92F9DCC9_1063930909.hasNext();
            LeafNodeImpl child = varD9F9BEAAEB1609B5416C40DE92F9DCC9_1063930909.next();
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_346855712 = (DocumentType) child;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_750031489 = null;
        DocumentType varA7E53CE21691AB073D9660D615818899_472499859; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_472499859 = varB4EAC82CA7396A68D541C85D26508E83_346855712;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_472499859 = varB4EAC82CA7396A68D541C85D26508E83_750031489;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_472499859.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_472499859;
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.985 -0400", hash_original_method = "59978D20A08E2A3D10080AFCDAEC6A5E", hash_generated_method = "4206A0657064432403E0FEDA953BD57A")
    public Element getDocumentElement() {
        Element varB4EAC82CA7396A68D541C85D26508E83_1369667577 = null; 
        Element varB4EAC82CA7396A68D541C85D26508E83_1984032709 = null; 
        {
            Iterator<LeafNodeImpl> varD9F9BEAAEB1609B5416C40DE92F9DCC9_444227826 = (children).iterator();
            varD9F9BEAAEB1609B5416C40DE92F9DCC9_444227826.hasNext();
            LeafNodeImpl child = varD9F9BEAAEB1609B5416C40DE92F9DCC9_444227826.next();
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1369667577 = (Element) child;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1984032709 = null;
        Element varA7E53CE21691AB073D9660D615818899_1965560177; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1965560177 = varB4EAC82CA7396A68D541C85D26508E83_1369667577;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1965560177 = varB4EAC82CA7396A68D541C85D26508E83_1984032709;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1965560177.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1965560177;
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.985 -0400", hash_original_method = "F4A17E55F2C93FA371B29DDF570BB5F6", hash_generated_method = "709756A1E77A8E90E28B74EB75C82093")
    public Element getElementById(String elementId) {
        Element varB4EAC82CA7396A68D541C85D26508E83_436869129 = null; 
        ElementImpl root = (ElementImpl) getDocumentElement();
        varB4EAC82CA7396A68D541C85D26508E83_436869129 = (root == null ? null : root.getElementById(elementId));
        addTaint(elementId.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_436869129.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_436869129;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.986 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "C3A98F0BFA50891BECE896BE14FA5F1C")
    public NodeList getElementsByTagName(String name) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_909238634 = null; 
        NodeListImpl result = new NodeListImpl();
        getElementsByTagName(result, name);
        varB4EAC82CA7396A68D541C85D26508E83_909238634 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_909238634.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_909238634;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.987 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "7D37CF19A95004B5EF7555FE2104B071")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_1258998233 = null; 
        NodeListImpl result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        varB4EAC82CA7396A68D541C85D26508E83_1258998233 = result;
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1258998233.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1258998233;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.988 -0400", hash_original_method = "871220F29645F989F5FF83627B59D2B9", hash_generated_method = "EAAAAF1FB641A83308A6C16A64A1E3DA")
    public DOMImplementation getImplementation() {
        DOMImplementation varB4EAC82CA7396A68D541C85D26508E83_560051331 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_560051331 = domImplementation;
        varB4EAC82CA7396A68D541C85D26508E83_560051331.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_560051331;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.988 -0400", hash_original_method = "3823D9F624F2EC5FAA072B7BE8806F96", hash_generated_method = "C63464EA2FC4955A9EA2364467949DAD")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_541840641 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_541840641 = "#document";
        varB4EAC82CA7396A68D541C85D26508E83_541840641.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_541840641;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.989 -0400", hash_original_method = "043CCE8DE1A8362BF53702E45F3637E9", hash_generated_method = "3F022F9B36FC363604695629A2CBFA56")
    @Override
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_537151179 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_537151179;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.990 -0400", hash_original_method = "C51ADCEBFAB6A11E8C0AA42A3197A4ED", hash_generated_method = "49AF779B9B03DB76408088111C7CCC17")
    @Override
    public Node insertChildAt(Node toInsert, int index) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1684272268 = null; 
        {
            boolean var04BB177618B02F1518CBEFA9FED48CA0_282101904 = (toInsert instanceof Element && getDocumentElement() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one root element allowed");
            } 
        } 
        {
            boolean varD2DDB695B9F05EE403A0265E37F38EFF_439928021 = (toInsert instanceof DocumentType && getDoctype() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one DOCTYPE element allowed");
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1684272268 = super.insertChildAt(toInsert, index);
        addTaint(toInsert.getTaint());
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1684272268.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1684272268;
        
        
            
                    
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.991 -0400", hash_original_method = "523640531DE4ABEBCC885A0C8EFFAA8E", hash_generated_method = "3B912C2B9892FA16B606A7239A1A0310")
    @Override
    public String getTextContent() {
        String varB4EAC82CA7396A68D541C85D26508E83_1575827385 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1575827385 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1575827385.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1575827385;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.991 -0400", hash_original_method = "94C9917BD9FB417B21D37D438D58D41C", hash_generated_method = "E9FFE4657CAB12B0725BD210869C877F")
    public String getInputEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1747317049 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1747317049 = inputEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1747317049.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1747317049;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.992 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "E01C0555B9E002A8AF65149A4BB67B25")
    public String getXmlEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1238373996 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1238373996 = xmlEncoding;
        varB4EAC82CA7396A68D541C85D26508E83_1238373996.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1238373996;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.993 -0400", hash_original_method = "A9BBCA9526831CCA3B1BE6D8EEF33ABE", hash_generated_method = "E546989B70CA9A58AB9017F9B9306488")
    public boolean getXmlStandalone() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1219670322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1219670322;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.993 -0400", hash_original_method = "9E601CBC8BB08C0D3B66A0213931419B", hash_generated_method = "9E81AB93ADB44B2013F3533C3DA5BE8E")
    public void setXmlStandalone(boolean xmlStandalone) {
        this.xmlStandalone = xmlStandalone;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.994 -0400", hash_original_method = "BC354AC833FDCF3905B7FEDC7BFD541D", hash_generated_method = "D1B5E2A21761D22F13285DE90080484F")
    public String getXmlVersion() {
        String varB4EAC82CA7396A68D541C85D26508E83_391548280 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_391548280 = xmlVersion;
        varB4EAC82CA7396A68D541C85D26508E83_391548280.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_391548280;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.994 -0400", hash_original_method = "C0A21B3EE9603BF0EAE2488DE43FD78E", hash_generated_method = "1D025D03CF816AA6E6E7E13C188987CA")
    public void setXmlVersion(String xmlVersion) {
        this.xmlVersion = xmlVersion;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.994 -0400", hash_original_method = "338EEC38209BE0DB329E33E9EDD7ED88", hash_generated_method = "D91C8F10F239263591A51904E592E5ED")
    public boolean getStrictErrorChecking() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1460295096 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1460295096;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.995 -0400", hash_original_method = "55375073A29EAEC23495FBD30A28EDB3", hash_generated_method = "B5D30D71D7A11256EBFA7BCECCF3D144")
    public void setStrictErrorChecking(boolean strictErrorChecking) {
        this.strictErrorChecking = strictErrorChecking;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.996 -0400", hash_original_method = "2433E48CE07A4EB6DFAAA40EF72A0853", hash_generated_method = "B82097050DBD3D59564067E207205FA7")
    public String getDocumentURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1698116428 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1698116428 = documentUri;
        varB4EAC82CA7396A68D541C85D26508E83_1698116428.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1698116428;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.997 -0400", hash_original_method = "2ABB3572AC2E2195C4BFB544AFA05B7C", hash_generated_method = "88DFDC039A98BD865B0FDF5C62AD2EAE")
    public void setDocumentURI(String documentUri) {
        this.documentUri = documentUri;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:35.999 -0400", hash_original_method = "9C5D9FE4294F6D7509E6E0C2DA50CF2D", hash_generated_method = "42CBA32FF79D14DB08FFD675C0910DCB")
    public DOMConfiguration getDomConfig() {
        DOMConfiguration varB4EAC82CA7396A68D541C85D26508E83_1849910742 = null; 
        {
            domConfiguration = new DOMConfigurationImpl();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1849910742 = domConfiguration;
        varB4EAC82CA7396A68D541C85D26508E83_1849910742.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1849910742;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.000 -0400", hash_original_method = "89D7CC816429D9C559DCCAF8A85B9CA9", hash_generated_method = "2A263F9916A358FC93ECD804CC950359")
    public void normalizeDocument() {
        Element root = getDocumentElement();
        ((DOMConfigurationImpl) getDomConfig()).normalize(root);
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.004 -0400", hash_original_method = "83962F2DF698AAA6D760C50C082C5A3C", hash_generated_method = "984E30F44B97C64503F740A3FA33CAFF")
     Map<String, UserData> getUserDataMap(NodeImpl node) {
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_1906694607 = null; 
        {
            nodeToUserData = new WeakHashMap<NodeImpl, Map<String, UserData>>();
        } 
        Map<String, UserData> userDataMap = nodeToUserData.get(node);
        {
            userDataMap = new HashMap<String, UserData>();
            nodeToUserData.put(node, userDataMap);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1906694607 = userDataMap;
        addTaint(node.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1906694607.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1906694607;
        
        
            
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.005 -0400", hash_original_method = "8B5F30F59CCBC9322DB0F048DEF01A52", hash_generated_method = "D1930783A384FC6A9D90865CB9008D1E")
     Map<String, UserData> getUserDataMapForRead(NodeImpl node) {
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_1402615827 = null; 
        Map<String, UserData> varB4EAC82CA7396A68D541C85D26508E83_1586639408 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1402615827 = Collections.emptyMap();
        } 
        Map<String, UserData> userDataMap = nodeToUserData.get(node);
        varB4EAC82CA7396A68D541C85D26508E83_1586639408 = userDataMap == null
                ? Collections.<String, UserData>emptyMap()
                : userDataMap;
        addTaint(node.getTaint());
        Map<String, UserData> varA7E53CE21691AB073D9660D615818899_2010544052; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2010544052 = varB4EAC82CA7396A68D541C85D26508E83_1402615827;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2010544052 = varB4EAC82CA7396A68D541C85D26508E83_1586639408;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2010544052.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2010544052;
        
        
            
        
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
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

