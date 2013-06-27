package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Attr;
import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

public abstract class NodeImpl implements Node {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.521 -0400", hash_original_field = "FDC3BDEFB79CEC8EB8211D2499E04704", hash_generated_field = "3C52D3A90E4759490A57AF776DEAFE65")

    DocumentImpl document;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.524 -0400", hash_original_method = "A803585FEFBC6246911A956CA607D5CA", hash_generated_method = "9F50EA75A2AED9D57A4F24B1458FBC54")
      NodeImpl(DocumentImpl document) {
        this.document = document;
        // ---------- Original Method ----------
        //this.document = document;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.526 -0400", hash_original_method = "2014C4DBC7F925271C7D07A1BBA7C167", hash_generated_method = "79482AFAA555B5637FF2DF58F8E2AAF9")
    public Node appendChild(Node newChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(newChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.540 -0400", hash_original_method = "917775F899DEE58C265631FD33F793ED", hash_generated_method = "24C95575183CA83F3637B0F331BF0C40")
    public final Node cloneNode(boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_687799170 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_687799170 = document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_687799170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_687799170;
        // ---------- Original Method ----------
        //return document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.542 -0400", hash_original_method = "E2D79625FBECAF1E43447A0BEFC228B9", hash_generated_method = "440674615F7F6D9E84011B1C5C890604")
    public NamedNodeMap getAttributes() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_1013021769 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1013021769 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1013021769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1013021769;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.542 -0400", hash_original_method = "1F381BCE8228355FEE86D697E02DDE0B", hash_generated_method = "1024651066F20623C8D0E7C63693DB77")
    public NodeList getChildNodes() {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_345503296 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_345503296 = EMPTY_LIST;
        varB4EAC82CA7396A68D541C85D26508E83_345503296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345503296;
        // ---------- Original Method ----------
        //return EMPTY_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.542 -0400", hash_original_method = "DB31E0DD76C8C1947AB843730A5D8205", hash_generated_method = "1D953CB4B42FC39DE357E29E33F0F23D")
    public Node getFirstChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1064873104 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1064873104 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1064873104.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1064873104;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.544 -0400", hash_original_method = "6070A4A9C5DDD0223B459D45F6FD5CBB", hash_generated_method = "99502E2725A58A765883C297C2BA8AF1")
    public Node getLastChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_144668409 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_144668409 = null;
        varB4EAC82CA7396A68D541C85D26508E83_144668409.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_144668409;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.553 -0400", hash_original_method = "DEB04882A70946FEC78DD7AD3ABDE01B", hash_generated_method = "D1F6247D84208A315843F5C9B4FF66C0")
    public String getLocalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_41694555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_41694555 = null;
        varB4EAC82CA7396A68D541C85D26508E83_41694555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_41694555;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.554 -0400", hash_original_method = "4D95F58ABD4076A5B25FED87E28A6FD8", hash_generated_method = "B47C49832C529C75E47DF398A2B7E8A9")
    public String getNamespaceURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_785887495 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_785887495 = null;
        varB4EAC82CA7396A68D541C85D26508E83_785887495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_785887495;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.555 -0400", hash_original_method = "D23B45CE7514A5E8C576F43815BA5C75", hash_generated_method = "7BC3702D600290C52BAB8C36B201DF24")
    public Node getNextSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1632460119 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1632460119 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1632460119.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1632460119;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.559 -0400", hash_original_method = "FDA68CAC7DBE692AD654EACCAEB8ADF4", hash_generated_method = "00CAED177B13A0F087213145E6F4D3A1")
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1008468205 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1008468205 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1008468205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008468205;
        // ---------- Original Method ----------
        //return null;
    }

    
    public abstract short getNodeType();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.565 -0400", hash_original_method = "5D533F6B29FA017DED37EB54506CEFCE", hash_generated_method = "4550AD26A556153FBFF560AE485F4B1A")
    public String getNodeValue() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_1741253602 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1741253602 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1741253602.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1741253602;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.569 -0400", hash_original_method = "683FB3B36E3C0C255B09CB1FE69555EA", hash_generated_method = "BA8A9EE6C47BC02F1A5B6864052D3FF9")
    public final Document getOwnerDocument() {
        Document varB4EAC82CA7396A68D541C85D26508E83_1784655487 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1784655487 = document == this ? null : document;
        varB4EAC82CA7396A68D541C85D26508E83_1784655487.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1784655487;
        // ---------- Original Method ----------
        //return document == this ? null : document;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.570 -0400", hash_original_method = "2F661FBCA438408BEACED1A87A3CFAEE", hash_generated_method = "3D30475B9AAE2726D091CB8AC494FED3")
    public Node getParentNode() {
        Node varB4EAC82CA7396A68D541C85D26508E83_624559928 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_624559928 = null;
        varB4EAC82CA7396A68D541C85D26508E83_624559928.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_624559928;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.570 -0400", hash_original_method = "727413C23E49E727D2327332BBC1F81A", hash_generated_method = "F6B7A9295866B947A71C6C8F983FCB42")
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1842426525 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1842426525 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1842426525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1842426525;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.574 -0400", hash_original_method = "70F44FC98E437F8103C8C034DB4ECB33", hash_generated_method = "8138B4F6F951E22349A9CCF5CE6B89E6")
    public Node getPreviousSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1183941244 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1183941244 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1183941244.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1183941244;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.586 -0400", hash_original_method = "B7795536C66ABB4718F9ED686281788D", hash_generated_method = "DC019C0291538AA62DD8E6DFCD83C85A")
    public boolean hasAttributes() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1048188220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1048188220;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.587 -0400", hash_original_method = "75BC1F0CD3DD7ADF1C7C374A2270CAC3", hash_generated_method = "9B1F9EF5EDC2641C013824007C30DEE4")
    public boolean hasChildNodes() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040775694 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040775694;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.587 -0400", hash_original_method = "02900D7407B8981D4618C0943B784132", hash_generated_method = "617F6B66ECDBA72611816581457BD4A3")
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(newChild.getTaint());
        addTaint(refChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.588 -0400", hash_original_method = "83D2E21D1EF19CE5C027A4D56C9BBECC", hash_generated_method = "5CB77E8E25B2FA0407B7725C460BA9B0")
    public boolean isSupported(String feature, String version) {
        boolean var35F7927EF3CC7F4E5B6C50A87B9E3142_894117784 = (DOMImplementationImpl.getInstance().hasFeature(feature, version));
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622337771 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622337771;
        // ---------- Original Method ----------
        //return DOMImplementationImpl.getInstance().hasFeature(feature, version);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.588 -0400", hash_original_method = "6E21C006D39E2D7D2AB395E9723D1D3D", hash_generated_method = "AAB79EA75709AFAC418FB3A2AD6C8459")
    public void normalize() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.589 -0400", hash_original_method = "C0BCC4253F844D2665FCB84131264ACF", hash_generated_method = "FE717F7796FE21AB7A918AF615E52C34")
    public Node removeChild(Node oldChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(oldChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.589 -0400", hash_original_method = "3CB9ABDC605D3811167E9E73D3AF8E67", hash_generated_method = "A322881ED50C77810DAE5B16E19CB0DD")
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(newChild.getTaint());
        addTaint(oldChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.593 -0400", hash_original_method = "DD460B5BCEAE1CB09CE08B91E621DF7E", hash_generated_method = "AF4BB0499330BFE85D3591A356EDCE40")
    public final void setNodeValue(String nodeValue) throws DOMException {
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_973066179 = (getNodeType());
            //Begin case CDATA_SECTION_NODE COMMENT_NODE TEXT_NODE 
            ((CharacterData) this).setData(nodeValue);
            //End case CDATA_SECTION_NODE COMMENT_NODE TEXT_NODE 
            //Begin case PROCESSING_INSTRUCTION_NODE 
            ((ProcessingInstruction) this).setData(nodeValue);
            //End case PROCESSING_INSTRUCTION_NODE 
            //Begin case ATTRIBUTE_NODE 
            ((Attr) this).setValue(nodeValue);
            //End case ATTRIBUTE_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
            //End case default 
        } //End collapsed parenthetic
        addTaint(nodeValue.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.593 -0400", hash_original_method = "534A727E4FDB6CDBB5DC8BBEFB80CC50", hash_generated_method = "6394A903E9072527732E970BA56A5453")
    public void setPrefix(String prefix) throws DOMException {
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
        static String validatePrefix(String prefix, boolean namespaceAware, String namespaceURI) {
        if (!namespaceAware) {
            throw new DOMException(DOMException.NAMESPACE_ERR, prefix);
        }
        if (prefix != null) {
            if (namespaceURI == null
                    || !DocumentImpl.isXMLIdentifier(prefix)
                    || "xml".equals(prefix) && !"http://www.w3.org/XML/1998/namespace".equals(namespaceURI)
                    || "xmlns".equals(prefix) && !"http://www.w3.org/2000/xmlns/".equals(namespaceURI)) {
                throw new DOMException(DOMException.NAMESPACE_ERR, prefix);
            }
        }
        return prefix;
    }

    
        static void setNameNS(NodeImpl node, String namespaceURI, String qualifiedName) {
        if (qualifiedName == null) {
            throw new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
        }
        String prefix = null;
        int p = qualifiedName.lastIndexOf(":");
        if (p != -1) {
            prefix = validatePrefix(qualifiedName.substring(0, p), true, namespaceURI);
            qualifiedName = qualifiedName.substring(p + 1);
        }
        if (!DocumentImpl.isXMLIdentifier(qualifiedName)) {
            throw new DOMException(DOMException.INVALID_CHARACTER_ERR, qualifiedName);
        }
        switch (node.getNodeType()) {
        case ATTRIBUTE_NODE:
            if ("xmlns".equals(qualifiedName)
                    && !"http://www.w3.org/2000/xmlns/".equals(namespaceURI)) {
                throw new DOMException(DOMException.NAMESPACE_ERR, qualifiedName);
            }
            AttrImpl attr = (AttrImpl) node;
            attr.namespaceAware = true;
            attr.namespaceURI = namespaceURI;
            attr.prefix = prefix;
            attr.localName = qualifiedName;
            break;
        case ELEMENT_NODE:
            ElementImpl element = (ElementImpl) node;
            element.namespaceAware = true;
            element.namespaceURI = namespaceURI;
            element.prefix = prefix;
            element.localName = qualifiedName;
            break;
        default:
            throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Cannot rename nodes of type " + node.getNodeType());
        }
    }

    
        static void setName(NodeImpl node, String name) {
        int prefixSeparator = name.lastIndexOf(":");
        if (prefixSeparator != -1) {
            String prefix = name.substring(0, prefixSeparator);
            String localName = name.substring(prefixSeparator + 1);
            if (!DocumentImpl.isXMLIdentifier(prefix) || !DocumentImpl.isXMLIdentifier(localName)) {
                throw new DOMException(DOMException.INVALID_CHARACTER_ERR, name);
            }
        } else if (!DocumentImpl.isXMLIdentifier(name)) {
            throw new DOMException(DOMException.INVALID_CHARACTER_ERR, name);
        }
        switch (node.getNodeType()) {
        case ATTRIBUTE_NODE:
            AttrImpl attr = (AttrImpl) node;
            attr.namespaceAware = false;
            attr.localName = name;
            break;
        case ELEMENT_NODE:
            ElementImpl element = (ElementImpl) node;
            element.namespaceAware = false;
            element.localName = name;
            break;
        default:
            throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Cannot rename nodes of type " + node.getNodeType());
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.608 -0400", hash_original_method = "DD28C7A733028F46F0F8ECAE2D47C2BC", hash_generated_method = "FC8C5A53481B2A0A7EC12066C4769923")
    public final String getBaseURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1005443735 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1565077161 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_231559112 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_260218265 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1790805426 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_1618467944 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_1445139737 = null; //Variable for return #7
        String varB4EAC82CA7396A68D541C85D26508E83_1466471358 = null; //Variable for return #8
        String varB4EAC82CA7396A68D541C85D26508E83_248411534 = null; //Variable for return #9
        String varB4EAC82CA7396A68D541C85D26508E83_1770257354 = null; //Variable for return #10
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_700444297 = (getNodeType());
            //Begin case DOCUMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1005443735 = sanitizeUri(((Document) this).getDocumentURI());
            //End case DOCUMENT_NODE 
            //Begin case ELEMENT_NODE 
            Element element;
            element = (Element) this;
            //End case ELEMENT_NODE 
            //Begin case ELEMENT_NODE 
            String uri;
            uri = element.getAttributeNS(
                        "http://www.w3.org/XML/1998/namespace", "base");
            //End case ELEMENT_NODE 
            //Begin case ELEMENT_NODE 
            try 
            {
                {
                    boolean varCD5A1EF129D63A19CBA8F3323E78D018_814778760 = (uri == null || uri.isEmpty());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1565077161 = getParentBaseUri();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varCFCB3A4B5B2F222B09B28B628CD2D035_74671367 = (new URI(uri).isAbsolute());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_231559112 = uri;
                    } //End block
                } //End collapsed parenthetic
                String parentUri;
                parentUri = getParentBaseUri();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_260218265 = null;
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1790805426 = new URI(parentUri).resolve(uri).toString();
            } //End block
            catch (URISyntaxException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1618467944 = null;
            } //End block
            //End case ELEMENT_NODE 
            //Begin case PROCESSING_INSTRUCTION_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1445139737 = getParentBaseUri();
            //End case PROCESSING_INSTRUCTION_NODE 
            //Begin case NOTATION_NODE ENTITY_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1466471358 = null;
            //End case NOTATION_NODE ENTITY_NODE 
            //Begin case ENTITY_REFERENCE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_248411534 = null;
            //End case ENTITY_REFERENCE_NODE 
            //Begin case DOCUMENT_TYPE_NODE DOCUMENT_FRAGMENT_NODE ATTRIBUTE_NODE TEXT_NODE CDATA_SECTION_NODE COMMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1770257354 = null;
            //End case DOCUMENT_TYPE_NODE DOCUMENT_FRAGMENT_NODE ATTRIBUTE_NODE TEXT_NODE CDATA_SECTION_NODE COMMENT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
            //End case default 
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_2024373681; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2024373681 = varB4EAC82CA7396A68D541C85D26508E83_1005443735;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2024373681 = varB4EAC82CA7396A68D541C85D26508E83_1565077161;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2024373681 = varB4EAC82CA7396A68D541C85D26508E83_231559112;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_2024373681 = varB4EAC82CA7396A68D541C85D26508E83_260218265;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_2024373681 = varB4EAC82CA7396A68D541C85D26508E83_1790805426;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_2024373681 = varB4EAC82CA7396A68D541C85D26508E83_1618467944;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_2024373681 = varB4EAC82CA7396A68D541C85D26508E83_1445139737;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_2024373681 = varB4EAC82CA7396A68D541C85D26508E83_1466471358;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_2024373681 = varB4EAC82CA7396A68D541C85D26508E83_248411534;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2024373681 = varB4EAC82CA7396A68D541C85D26508E83_1770257354;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2024373681.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2024373681;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.612 -0400", hash_original_method = "DFD855C107B39D74015E43DCF13ECA5E", hash_generated_method = "63AEA14E511C6B88089D7091F65DEACC")
    private String getParentBaseUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_2031563588 = null; //Variable for return #1
        Node parentNode;
        parentNode = getParentNode();
        varB4EAC82CA7396A68D541C85D26508E83_2031563588 = parentNode != null ? parentNode.getBaseURI() : null;
        varB4EAC82CA7396A68D541C85D26508E83_2031563588.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2031563588;
        // ---------- Original Method ----------
        //Node parentNode = getParentNode();
        //return parentNode != null ? parentNode.getBaseURI() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.620 -0400", hash_original_method = "1D824B9402137DBC708C242BAEC27F82", hash_generated_method = "95713C5283152A287B9BC82A3DF0A7A4")
    private String sanitizeUri(String uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_1730683072 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_262377275 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1179804021 = null; //Variable for return #3
        {
            boolean var6E057AB845D6ADAE670C60C55D7A447B_208294733 = (uri == null || uri.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1730683072 = null;
            } //End block
        } //End collapsed parenthetic
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_262377275 = new URI(uri).toString();
        } //End block
        catch (URISyntaxException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1179804021 = null;
        } //End block
        addTaint(uri.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1826689570; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1826689570 = varB4EAC82CA7396A68D541C85D26508E83_1730683072;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1826689570 = varB4EAC82CA7396A68D541C85D26508E83_262377275;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1826689570 = varB4EAC82CA7396A68D541C85D26508E83_1179804021;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1826689570.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1826689570;
        // ---------- Original Method ----------
        //if (uri == null || uri.length() == 0) {
            //return null;
        //}
        //try {
            //return new URI(uri).toString();
        //} catch (URISyntaxException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.624 -0400", hash_original_method = "1DDF123F9002EFB3DC60D7666C901199", hash_generated_method = "C4ADFC74587B6BA30A071E3C6A0096C6")
    public short compareDocumentPosition(Node other) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(other.getTaint());
        short var4F09DAA9D95BCB166A302407A0E0BABE_1327931669 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1327931669;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.625 -0400", hash_original_method = "67AC02ADFBE93754C1AB8AE0D37378EE", hash_generated_method = "54F2441C29B1A5F8DB42674B5261E3AB")
    public String getTextContent() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_259134507 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_259134507 = getNodeValue();
        varB4EAC82CA7396A68D541C85D26508E83_259134507.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_259134507;
        // ---------- Original Method ----------
        //return getNodeValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.625 -0400", hash_original_method = "6ADB0BF10CD256A5C763161A1385CD79", hash_generated_method = "E911BAAF6AF9E50E5560F90FE3EB1287")
     void getTextContent(StringBuilder buf) throws DOMException {
        String content;
        content = getNodeValue();
        {
            buf.append(content);
        } //End block
        addTaint(buf.getTaint());
        // ---------- Original Method ----------
        //String content = getNodeValue();
        //if (content != null) {
            //buf.append(content);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.626 -0400", hash_original_method = "B267D49587C3D1DB842740F077498528", hash_generated_method = "11D82D97435F9CA1B66E4BC3DC88020C")
    public final void setTextContent(String textContent) throws DOMException {
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_1239490269 = (getNodeType());
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            Node child;
            //End case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            {
                boolean var7B4B4D60718B8920C8140722D3CC2681_1703235070 = ((child = getFirstChild()) != null);
                {
                    removeChild(child);
                } //End block
            } //End collapsed parenthetic
            //End case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            {
                boolean varE87C319A84018C6C43084B4686BD5121_992800830 = (textContent != null && textContent.length() != 0);
                {
                    appendChild(document.createTextNode(textContent));
                } //End block
            } //End collapsed parenthetic
            //End case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            //Begin case ATTRIBUTE_NODE TEXT_NODE CDATA_SECTION_NODE PROCESSING_INSTRUCTION_NODE COMMENT_NODE NOTATION_NODE 
            setNodeValue(textContent);
            //End case ATTRIBUTE_NODE TEXT_NODE CDATA_SECTION_NODE PROCESSING_INSTRUCTION_NODE COMMENT_NODE NOTATION_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
            //End case default 
        } //End collapsed parenthetic
        addTaint(textContent.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.626 -0400", hash_original_method = "CDCF2BEBCB3DF8B0191B82144C39E4E3", hash_generated_method = "27E45E696F35508D5FBC772128D4B1C1")
    public boolean isSameNode(Node other) {
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_78532911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_78532911;
        // ---------- Original Method ----------
        //return this == other;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.636 -0400", hash_original_method = "DDD4A4E09BB31E4B92DF0753DE457415", hash_generated_method = "AA2A6DB32E0B7D599F7E802121CC461E")
    private NodeImpl getNamespacingElement() {
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_2053193318 = null; //Variable for return #1
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1897009828 = null; //Variable for return #2
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1454860185 = null; //Variable for return #3
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_982236019 = null; //Variable for return #4
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_796993399 = null; //Variable for return #5
        {
            Object varCF51CDECE43343A636AB308505B1992B_1845195696 = (this.getNodeType());
            //Begin case ELEMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_2053193318 = this;
            //End case ELEMENT_NODE 
            //Begin case DOCUMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1897009828 = (NodeImpl) ((Document) this).getDocumentElement();
            //End case DOCUMENT_NODE 
            //Begin case ENTITY_NODE NOTATION_NODE DOCUMENT_FRAGMENT_NODE DOCUMENT_TYPE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1454860185 = null;
            //End case ENTITY_NODE NOTATION_NODE DOCUMENT_FRAGMENT_NODE DOCUMENT_TYPE_NODE 
            //Begin case ATTRIBUTE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_982236019 = (NodeImpl) ((Attr) this).getOwnerElement();
            //End case ATTRIBUTE_NODE 
            //Begin case TEXT_NODE CDATA_SECTION_NODE ENTITY_REFERENCE_NODE PROCESSING_INSTRUCTION_NODE COMMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_796993399 = getContainingElement();
            //End case TEXT_NODE CDATA_SECTION_NODE ENTITY_REFERENCE_NODE PROCESSING_INSTRUCTION_NODE COMMENT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
            //End case default 
        } //End collapsed parenthetic
        NodeImpl varA7E53CE21691AB073D9660D615818899_51730111; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_51730111 = varB4EAC82CA7396A68D541C85D26508E83_2053193318;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_51730111 = varB4EAC82CA7396A68D541C85D26508E83_1897009828;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_51730111 = varB4EAC82CA7396A68D541C85D26508E83_1454860185;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_51730111 = varB4EAC82CA7396A68D541C85D26508E83_982236019;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_51730111 = varB4EAC82CA7396A68D541C85D26508E83_796993399;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_51730111.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_51730111;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.638 -0400", hash_original_method = "E4B9E13482B5AB13521831694CDD3F31", hash_generated_method = "8224CCF1CB5224ED719A14E81B3E4482")
    private NodeImpl getContainingElement() {
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_81795234 = null; //Variable for return #1
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1908004718 = null; //Variable for return #2
        {
            Node p;
            p = getParentNode();
            p = p.getParentNode();
            {
                {
                    boolean varFBC5A12935C2B20E9065353DA95A8A18_167959521 = (p.getNodeType() == ELEMENT_NODE);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_81795234 = (NodeImpl) p;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1908004718 = null;
        NodeImpl varA7E53CE21691AB073D9660D615818899_1628484595; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1628484595 = varB4EAC82CA7396A68D541C85D26508E83_81795234;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1628484595 = varB4EAC82CA7396A68D541C85D26508E83_1908004718;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1628484595.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1628484595;
        // ---------- Original Method ----------
        //for (Node p = getParentNode(); p != null; p = p.getParentNode()) {
            //if (p.getNodeType() == ELEMENT_NODE) {
                //return (NodeImpl) p;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.694 -0400", hash_original_method = "7FA28D24E20CD6244334CF1DE396DB62", hash_generated_method = "21EAA27E2F2B5AFA15450E7CCF130AAD")
    public final String lookupPrefix(String namespaceURI) {
        String varB4EAC82CA7396A68D541C85D26508E83_1401592456 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_989533510 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1952731143 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1454207009 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_1401592456 = null;
        } //End block
        NodeImpl target;
        target = getNamespacingElement();
        {
            NodeImpl node;
            node = target;
            node = node.getContainingElement();
            {
                {
                    boolean varB403AB9B9BBCA7835D5E0AFC14FDB897_1461508784 = (namespaceURI.equals(node.getNamespaceURI())
                    && target.isPrefixMappedToUri(node.getPrefix(), namespaceURI));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_989533510 = node.getPrefix();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varC9579644D782C09885D8B6799B24D1B7_1433597125 = (!node.hasAttributes());
                } //End collapsed parenthetic
                NamedNodeMap attributes;
                attributes = node.getAttributes();
                {
                    int i, length;
                    i = 0;
                    length = attributes.getLength();
                    {
                        Node attr;
                        attr = attributes.item(i);
                        {
                            boolean var041AF16A4322928AB25B30D9E76210A6_1433140816 = (!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())
                        || !"xmlns".equals(attr.getPrefix())
                        || !namespaceURI.equals(attr.getNodeValue()));
                        } //End collapsed parenthetic
                        {
                            boolean varF15B4EC2E77AFBBC3F4E8FC11243E540_521236349 = (target.isPrefixMappedToUri(attr.getLocalName(), namespaceURI));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1952731143 = attr.getLocalName();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1454207009 = null;
        addTaint(namespaceURI.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1582994354; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1582994354 = varB4EAC82CA7396A68D541C85D26508E83_1401592456;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1582994354 = varB4EAC82CA7396A68D541C85D26508E83_989533510;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1582994354 = varB4EAC82CA7396A68D541C85D26508E83_1952731143;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1582994354 = varB4EAC82CA7396A68D541C85D26508E83_1454207009;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1582994354.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1582994354;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.695 -0400", hash_original_method = "AA07F6405A8EB7821F818F6C760FCB2D", hash_generated_method = "C71EC05409DCCAA10227C0A255D7B215")
     boolean isPrefixMappedToUri(String prefix, String uri) {
        String actual;
        actual = lookupNamespaceURI(prefix);
        boolean varF9523BA0BFC98B7D91C11E34CD185911_806019176 = (uri.equals(actual));
        addTaint(prefix.getTaint());
        addTaint(uri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1544269261 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1544269261;
        // ---------- Original Method ----------
        //if (prefix == null) {
            //return false;
        //}
        //String actual = lookupNamespaceURI(prefix);
        //return uri.equals(actual);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.696 -0400", hash_original_method = "408B99A289EC0349924637E46549BA26", hash_generated_method = "466300C22C36F53761B632B2D145DE9A")
    public final boolean isDefaultNamespace(String namespaceURI) {
        String actual;
        actual = lookupNamespaceURI(null);
        {
            Object varA1932E607C647B6D725637B43AC06F10_657893226 = (namespaceURI.equals(actual));
        } //End flattened ternary
        addTaint(namespaceURI.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888016289 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888016289;
        // ---------- Original Method ----------
        //String actual = lookupNamespaceURI(null);
        //return namespaceURI == null
                //? actual == null
                //: namespaceURI.equals(actual);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.713 -0400", hash_original_method = "4BD06F1D22ADF3EA57842F923303423E", hash_generated_method = "13A930807C73D288F03523B62E2B0027")
    public final String lookupNamespaceURI(String prefix) {
        String varB4EAC82CA7396A68D541C85D26508E83_906766834 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1766516852 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_296257762 = null; //Variable for return #3
        NodeImpl target;
        target = getNamespacingElement();
        {
            NodeImpl node;
            node = target;
            node = node.getContainingElement();
            {
                String nodePrefix;
                nodePrefix = node.getPrefix();
                {
                    boolean var8BF87494DE6EC4578842A86B09D729A6_64395278 = (node.getNamespaceURI() != null);
                    {
                        {
                            {
                                boolean var37CC4D70FC3B61DCF871FB1CF8AD2846_1390889868 = (prefix.equals(nodePrefix));
                            } //End flattened ternary
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_906766834 = node.getNamespaceURI();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varC9579644D782C09885D8B6799B24D1B7_2010634740 = (!node.hasAttributes());
                } //End collapsed parenthetic
                NamedNodeMap attributes;
                attributes = node.getAttributes();
                {
                    int i, length;
                    i = 0;
                    length = attributes.getLength();
                    {
                        Node attr;
                        attr = attributes.item(i);
                        {
                            boolean varA13C057422A3B97AA60AD41894F0635F_1335429192 = (!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI()));
                        } //End collapsed parenthetic
                        {
                            {
                                boolean varFF1254D872CF5DC8F931458B444BA8F1_1977985231 = ("xmlns".equals(attr.getNodeName()));
                                boolean varBCF6CD3EF8E6EAEC9EE3BFD950C4EEDF_593428715 = ("xmlns".equals(attr.getPrefix()) && prefix.equals(attr.getLocalName()));
                            } //End flattened ternary
                            {
                                String value;
                                value = attr.getNodeValue();
                                varB4EAC82CA7396A68D541C85D26508E83_1766516852 = value.length() > 0 ? value : null;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_296257762 = null;
        addTaint(prefix.getTaint());
        String varA7E53CE21691AB073D9660D615818899_640539539; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_640539539 = varB4EAC82CA7396A68D541C85D26508E83_906766834;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_640539539 = varB4EAC82CA7396A68D541C85D26508E83_1766516852;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_640539539 = varB4EAC82CA7396A68D541C85D26508E83_296257762;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_640539539.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_640539539;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static List<Object> createEqualityKey(Node node) {
        List<Object> values = new ArrayList<Object>();
        values.add(node.getNodeType());
        values.add(node.getNodeName());
        values.add(node.getLocalName());
        values.add(node.getNamespaceURI());
        values.add(node.getPrefix());
        values.add(node.getNodeValue());
        for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
            values.add(child);
        }
        switch (node.getNodeType()) {
            case DOCUMENT_TYPE_NODE:
                DocumentTypeImpl doctype = (DocumentTypeImpl) node;
                values.add(doctype.getPublicId());
                values.add(doctype.getSystemId());
                values.add(doctype.getInternalSubset());
                values.add(doctype.getEntities());
                values.add(doctype.getNotations());
                break;
            case ELEMENT_NODE:
                Element element = (Element) node;
                values.add(element.getAttributes());
                break;
        }
        return values;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.715 -0400", hash_original_method = "5ACD5A1048128B414FC469A4162D7D49", hash_generated_method = "49502D95489A717815809DF7763661F6")
    public final boolean isEqualNode(Node arg) {
        {
            boolean var651A5D8954C9CB1305B0993B5221CC81_19356004 = (arg == this);
        } //End collapsed parenthetic
        List<Object> listA;
        listA = createEqualityKey(this);
        List<Object> listB;
        listB = createEqualityKey(arg);
        {
            boolean varA3551D9BD39003E9C908D438AFCDB1BC_1889790284 = (listA.size() != listB.size());
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean var6EBB52ED45932AB49617FFD096C89B6F_1703880201 = (i < listA.size());
            {
                Object a;
                a = listA.get(i);
                Object b;
                b = listB.get(i);
                {
                    {
                        boolean var0773BCBF827A4914F7F4F933191F9A10_1464173680 = (!a.equals(b));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var7D0BEECF51923FA96C755BED3C32C5AF_756003136 = (!(b instanceof NamedNodeMap)
                        || !namedNodeMapsEqual((NamedNodeMap) a, (NamedNodeMap) b));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varBA00253A935A73454F5089C6C332A1DE_1818647219 = (!(b instanceof Node)
                        || !((Node) a).isEqualNode((Node) b));
                    } //End collapsed parenthetic
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(arg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1641221638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1641221638;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.720 -0400", hash_original_method = "C9854B9EF2C5621F4F378B8106F34125", hash_generated_method = "F20B5E0EE646FC153C70FBA3CAFCAE02")
    private boolean namedNodeMapsEqual(NamedNodeMap a, NamedNodeMap b) {
        {
            boolean var0E71204F221B1B5EA61075617DA2C225_1232465908 = (a.getLength() != b.getLength());
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean var4A7AD866419D9BB4E8A28D673C28686A_1979561420 = (i < a.getLength());
            {
                Node aNode;
                aNode = a.item(i);
                Node bNode;
                boolean var880BE5E00764F10380C46D6CC262B0C9_1948337873 = (aNode.getLocalName() == null);
                bNode = b.getNamedItem(aNode.getNodeName());
                bNode = b.getNamedItemNS(aNode.getNamespaceURI(), aNode.getLocalName());
                {
                    boolean var7A836BDFDA6DC612AD6664CCCED1DCCF_735368358 = (bNode == null || !aNode.isEqualNode(bNode));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1897131315 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1897131315;
        // ---------- Original Method ----------
        //if (a.getLength() != b.getLength()) {
            //return false;
        //}
        //for (int i = 0; i < a.getLength(); i++) {
            //Node aNode = a.item(i);
            //Node bNode = aNode.getLocalName() == null
                    //? b.getNamedItem(aNode.getNodeName())
                    //: b.getNamedItemNS(aNode.getNamespaceURI(), aNode.getLocalName());
            //if (bNode == null || !aNode.isEqualNode(bNode)) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.720 -0400", hash_original_method = "654AD0B7653E61CCCCF2A287DD7A9FCF", hash_generated_method = "45D7FB2D20161D94CA399651AB62D14D")
    public final Object getFeature(String feature, String version) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1545727237 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1545727237 = isSupported(feature, version) ? this : null;
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1545727237.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1545727237;
        // ---------- Original Method ----------
        //return isSupported(feature, version) ? this : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.721 -0400", hash_original_method = "9F34FDEA3DB7CC58B5A8B86C5F6353A5", hash_generated_method = "E56625ED24F4E5974765EA30EF94E61F")
    public final Object setUserData(String key, Object data, UserDataHandler handler) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2069942667 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        Map<String, UserData> map;
        map = document.getUserDataMap(this);
        UserData previous;
        previous = map.remove(key);
        previous = map.put(key, new UserData(data, handler));
        varB4EAC82CA7396A68D541C85D26508E83_2069942667 = previous != null ? previous.value : null;
        addTaint(key.getTaint());
        addTaint(data.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2069942667.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2069942667;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //Map<String, UserData> map = document.getUserDataMap(this);
        //UserData previous = data == null
                //? map.remove(key)
                //: map.put(key, new UserData(data, handler));
        //return previous != null ? previous.value : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.721 -0400", hash_original_method = "B29B782E95D64D942AA9D9D3C7EEF744", hash_generated_method = "0432B494B3261E7AE4E488F207D5FDFB")
    public final Object getUserData(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_740965525 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        Map<String, UserData> map;
        map = document.getUserDataMapForRead(this);
        UserData userData;
        userData = map.get(key);
        varB4EAC82CA7396A68D541C85D26508E83_740965525 = userData != null ? userData.value : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_740965525.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_740965525;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //Map<String, UserData> map = document.getUserDataMapForRead(this);
        //UserData userData = map.get(key);
        //return userData != null ? userData.value : null;
    }

    
    static class UserData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.721 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.721 -0400", hash_original_field = "C1CBFE271A40788A00E8BF8574D94D4B", hash_generated_field = "827CB1F78A0BBD2016258DC26E1ED2F5")

        UserDataHandler handler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.739 -0400", hash_original_method = "0B6C19B4FFBA791689124EA47788F25F", hash_generated_method = "B74553803370CA04690975E42C003D03")
          UserData(Object value, UserDataHandler handler) {
            this.value = value;
            this.handler = handler;
            // ---------- Original Method ----------
            //this.value = value;
            //this.handler = handler;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.739 -0400", hash_original_field = "EEA06414AB077EBEC8501A6D636767BD", hash_generated_field = "F73237D1385F8D24CDF90DCA1C2652F9")

    private static NodeList EMPTY_LIST = new NodeListImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.740 -0400", hash_original_field = "50B55FD6A8E5705F66BF71830D3227D1", hash_generated_field = "A0AFDF3B0C851015B98952DDA1DDE92E")

    static TypeInfo NULL_TYPE_INFO = new TypeInfo() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.740 -0400", hash_original_method = "D6670B1956B399E1F4484C7409D24E32", hash_generated_method = "C1A6502A8458CEAD22520E0A91154026")
        public String getTypeName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1085920047 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1085920047 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1085920047.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1085920047;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.740 -0400", hash_original_method = "076EDBD720D64B1CD58A3E3161F3A408", hash_generated_method = "1D4E39B6A25E9B2F5E66751421950DD0")
        public String getTypeNamespace() {
            String varB4EAC82CA7396A68D541C85D26508E83_87383269 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_87383269 = null;
            varB4EAC82CA7396A68D541C85D26508E83_87383269.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_87383269;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.740 -0400", hash_original_method = "C5EC47855C2BF530753D3BD268C04AD2", hash_generated_method = "F43AB815A0C6D182BD7628615D6E885E")
        public boolean isDerivedFrom(
                String typeNamespaceArg, String typeNameArg, int derivationMethod) {
            addTaint(typeNamespaceArg.getTaint());
            addTaint(typeNameArg.getTaint());
            addTaint(derivationMethod);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794150003 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_794150003;
            // ---------- Original Method ----------
            //return false;
        }

        
};
}

