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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.311 -0400", hash_original_field = "FDC3BDEFB79CEC8EB8211D2499E04704", hash_generated_field = "3C52D3A90E4759490A57AF776DEAFE65")

    DocumentImpl document;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.312 -0400", hash_original_method = "A803585FEFBC6246911A956CA607D5CA", hash_generated_method = "9F50EA75A2AED9D57A4F24B1458FBC54")
      NodeImpl(DocumentImpl document) {
        this.document = document;
        // ---------- Original Method ----------
        //this.document = document;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.315 -0400", hash_original_method = "2014C4DBC7F925271C7D07A1BBA7C167", hash_generated_method = "79482AFAA555B5637FF2DF58F8E2AAF9")
    public Node appendChild(Node newChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(newChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.318 -0400", hash_original_method = "917775F899DEE58C265631FD33F793ED", hash_generated_method = "C3C69E9289795CF422FD2A2F3FBBD680")
    public final Node cloneNode(boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_446304531 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_446304531 = document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_446304531.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_446304531;
        // ---------- Original Method ----------
        //return document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.320 -0400", hash_original_method = "E2D79625FBECAF1E43447A0BEFC228B9", hash_generated_method = "7083E0E1FAD6E5EEB14CA9F4F78E70FC")
    public NamedNodeMap getAttributes() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_25270632 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_25270632 = null;
        varB4EAC82CA7396A68D541C85D26508E83_25270632.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_25270632;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.324 -0400", hash_original_method = "1F381BCE8228355FEE86D697E02DDE0B", hash_generated_method = "BBEA9B1B0E3432A88B5E6A88A4E0198B")
    public NodeList getChildNodes() {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_1694326888 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1694326888 = EMPTY_LIST;
        varB4EAC82CA7396A68D541C85D26508E83_1694326888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1694326888;
        // ---------- Original Method ----------
        //return EMPTY_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.329 -0400", hash_original_method = "DB31E0DD76C8C1947AB843730A5D8205", hash_generated_method = "FCE072637AF8B35109A542937392C42B")
    public Node getFirstChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_2005833182 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2005833182 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2005833182.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2005833182;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.331 -0400", hash_original_method = "6070A4A9C5DDD0223B459D45F6FD5CBB", hash_generated_method = "B7672BBDCB8E76A0797AF42E21ED72B8")
    public Node getLastChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_2070987715 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2070987715 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2070987715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2070987715;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.332 -0400", hash_original_method = "DEB04882A70946FEC78DD7AD3ABDE01B", hash_generated_method = "42A3FB4234316E0830CBC893344D2C13")
    public String getLocalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_945844083 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_945844083 = null;
        varB4EAC82CA7396A68D541C85D26508E83_945844083.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_945844083;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.332 -0400", hash_original_method = "4D95F58ABD4076A5B25FED87E28A6FD8", hash_generated_method = "6F6ED3FDF559E754148952792C727991")
    public String getNamespaceURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_902808528 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_902808528 = null;
        varB4EAC82CA7396A68D541C85D26508E83_902808528.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_902808528;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.333 -0400", hash_original_method = "D23B45CE7514A5E8C576F43815BA5C75", hash_generated_method = "4105A5654FE1E1B488FB342A9B507F2D")
    public Node getNextSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1005290027 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1005290027 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1005290027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1005290027;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.334 -0400", hash_original_method = "FDA68CAC7DBE692AD654EACCAEB8ADF4", hash_generated_method = "0D30319D683D51EE46F255C11F8FAC8F")
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_504579303 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_504579303 = null;
        varB4EAC82CA7396A68D541C85D26508E83_504579303.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_504579303;
        // ---------- Original Method ----------
        //return null;
    }

    
    public abstract short getNodeType();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.334 -0400", hash_original_method = "5D533F6B29FA017DED37EB54506CEFCE", hash_generated_method = "C4E2F275144E81F163E226F14D258087")
    public String getNodeValue() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_1447824436 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1447824436 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1447824436.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1447824436;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.335 -0400", hash_original_method = "683FB3B36E3C0C255B09CB1FE69555EA", hash_generated_method = "CACA51F1116712077F4F040A4DAE5EF6")
    public final Document getOwnerDocument() {
        Document varB4EAC82CA7396A68D541C85D26508E83_102743053 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_102743053 = document == this ? null : document;
        varB4EAC82CA7396A68D541C85D26508E83_102743053.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_102743053;
        // ---------- Original Method ----------
        //return document == this ? null : document;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.336 -0400", hash_original_method = "2F661FBCA438408BEACED1A87A3CFAEE", hash_generated_method = "23AD83EFE0F5E05E09FD99115F57B887")
    public Node getParentNode() {
        Node varB4EAC82CA7396A68D541C85D26508E83_721086599 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_721086599 = null;
        varB4EAC82CA7396A68D541C85D26508E83_721086599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_721086599;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.337 -0400", hash_original_method = "727413C23E49E727D2327332BBC1F81A", hash_generated_method = "D0E8D1B9C86600CCCA1D9A62BF0A5780")
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1266334662 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1266334662 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1266334662.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1266334662;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.338 -0400", hash_original_method = "70F44FC98E437F8103C8C034DB4ECB33", hash_generated_method = "F5D9F5A32D244CD186CC509A4ED9A0C0")
    public Node getPreviousSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_305574671 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_305574671 = null;
        varB4EAC82CA7396A68D541C85D26508E83_305574671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_305574671;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.338 -0400", hash_original_method = "B7795536C66ABB4718F9ED686281788D", hash_generated_method = "C2AEE9885C3DB478548982DD15FF3E5A")
    public boolean hasAttributes() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1751044796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1751044796;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.338 -0400", hash_original_method = "75BC1F0CD3DD7ADF1C7C374A2270CAC3", hash_generated_method = "9153324F668D6B4A5C43AEB8BD88BB41")
    public boolean hasChildNodes() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1179075846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1179075846;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.339 -0400", hash_original_method = "02900D7407B8981D4618C0943B784132", hash_generated_method = "617F6B66ECDBA72611816581457BD4A3")
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(newChild.getTaint());
        addTaint(refChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.339 -0400", hash_original_method = "83D2E21D1EF19CE5C027A4D56C9BBECC", hash_generated_method = "C7B20C471619AEDFC624F99E2F03E2F8")
    public boolean isSupported(String feature, String version) {
        boolean var35F7927EF3CC7F4E5B6C50A87B9E3142_1130287747 = (DOMImplementationImpl.getInstance().hasFeature(feature, version));
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_485941476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_485941476;
        // ---------- Original Method ----------
        //return DOMImplementationImpl.getInstance().hasFeature(feature, version);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.339 -0400", hash_original_method = "6E21C006D39E2D7D2AB395E9723D1D3D", hash_generated_method = "AAB79EA75709AFAC418FB3A2AD6C8459")
    public void normalize() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.340 -0400", hash_original_method = "C0BCC4253F844D2665FCB84131264ACF", hash_generated_method = "FE717F7796FE21AB7A918AF615E52C34")
    public Node removeChild(Node oldChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(oldChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.340 -0400", hash_original_method = "3CB9ABDC605D3811167E9E73D3AF8E67", hash_generated_method = "A322881ED50C77810DAE5B16E19CB0DD")
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(newChild.getTaint());
        addTaint(oldChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.341 -0400", hash_original_method = "DD460B5BCEAE1CB09CE08B91E621DF7E", hash_generated_method = "94D7D756694B91CFB81F671264C19AC4")
    public final void setNodeValue(String nodeValue) throws DOMException {
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_30146915 = (getNodeType());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.341 -0400", hash_original_method = "534A727E4FDB6CDBB5DC8BBEFB80CC50", hash_generated_method = "6394A903E9072527732E970BA56A5453")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.343 -0400", hash_original_method = "DD28C7A733028F46F0F8ECAE2D47C2BC", hash_generated_method = "DD907AD94E90A2497BCB3AF61C394813")
    public final String getBaseURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_406613572 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1680282730 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_926777758 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_406810190 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_195117970 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_132338383 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_240884390 = null; //Variable for return #7
        String varB4EAC82CA7396A68D541C85D26508E83_1368890154 = null; //Variable for return #8
        String varB4EAC82CA7396A68D541C85D26508E83_1601395610 = null; //Variable for return #9
        String varB4EAC82CA7396A68D541C85D26508E83_346155741 = null; //Variable for return #10
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_420340381 = (getNodeType());
            //Begin case DOCUMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_406613572 = sanitizeUri(((Document) this).getDocumentURI());
            //End case DOCUMENT_NODE 
            //Begin case ELEMENT_NODE 
            Element element = (Element) this;
            //End case ELEMENT_NODE 
            //Begin case ELEMENT_NODE 
            String uri = element.getAttributeNS(
                        "http://www.w3.org/XML/1998/namespace", "base");
            //End case ELEMENT_NODE 
            //Begin case ELEMENT_NODE 
            try 
            {
                {
                    boolean varCD5A1EF129D63A19CBA8F3323E78D018_1964335458 = (uri == null || uri.isEmpty());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1680282730 = getParentBaseUri();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varCFCB3A4B5B2F222B09B28B628CD2D035_1374531890 = (new URI(uri).isAbsolute());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_926777758 = uri;
                    } //End block
                } //End collapsed parenthetic
                String parentUri = getParentBaseUri();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_406810190 = null;
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_195117970 = new URI(parentUri).resolve(uri).toString();
            } //End block
            catch (URISyntaxException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_132338383 = null;
            } //End block
            //End case ELEMENT_NODE 
            //Begin case PROCESSING_INSTRUCTION_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_240884390 = getParentBaseUri();
            //End case PROCESSING_INSTRUCTION_NODE 
            //Begin case NOTATION_NODE ENTITY_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1368890154 = null;
            //End case NOTATION_NODE ENTITY_NODE 
            //Begin case ENTITY_REFERENCE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1601395610 = null;
            //End case ENTITY_REFERENCE_NODE 
            //Begin case DOCUMENT_TYPE_NODE DOCUMENT_FRAGMENT_NODE ATTRIBUTE_NODE TEXT_NODE CDATA_SECTION_NODE COMMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_346155741 = null;
            //End case DOCUMENT_TYPE_NODE DOCUMENT_FRAGMENT_NODE ATTRIBUTE_NODE TEXT_NODE CDATA_SECTION_NODE COMMENT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
            //End case default 
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_83176162; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_83176162 = varB4EAC82CA7396A68D541C85D26508E83_406613572;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_83176162 = varB4EAC82CA7396A68D541C85D26508E83_1680282730;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_83176162 = varB4EAC82CA7396A68D541C85D26508E83_926777758;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_83176162 = varB4EAC82CA7396A68D541C85D26508E83_406810190;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_83176162 = varB4EAC82CA7396A68D541C85D26508E83_195117970;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_83176162 = varB4EAC82CA7396A68D541C85D26508E83_132338383;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_83176162 = varB4EAC82CA7396A68D541C85D26508E83_240884390;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_83176162 = varB4EAC82CA7396A68D541C85D26508E83_1368890154;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_83176162 = varB4EAC82CA7396A68D541C85D26508E83_1601395610;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_83176162 = varB4EAC82CA7396A68D541C85D26508E83_346155741;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_83176162.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_83176162;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.344 -0400", hash_original_method = "DFD855C107B39D74015E43DCF13ECA5E", hash_generated_method = "60276C34955E63A73E38BFBD0F6560FC")
    private String getParentBaseUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_1452372689 = null; //Variable for return #1
        Node parentNode = getParentNode();
        varB4EAC82CA7396A68D541C85D26508E83_1452372689 = parentNode != null ? parentNode.getBaseURI() : null;
        varB4EAC82CA7396A68D541C85D26508E83_1452372689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1452372689;
        // ---------- Original Method ----------
        //Node parentNode = getParentNode();
        //return parentNode != null ? parentNode.getBaseURI() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.346 -0400", hash_original_method = "1D824B9402137DBC708C242BAEC27F82", hash_generated_method = "3FCF201837C905A8F3CE11219244FC20")
    private String sanitizeUri(String uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_1997678531 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_680596464 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1255428898 = null; //Variable for return #3
        {
            boolean var6E057AB845D6ADAE670C60C55D7A447B_309698731 = (uri == null || uri.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1997678531 = null;
            } //End block
        } //End collapsed parenthetic
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_680596464 = new URI(uri).toString();
        } //End block
        catch (URISyntaxException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1255428898 = null;
        } //End block
        addTaint(uri.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2117009588; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2117009588 = varB4EAC82CA7396A68D541C85D26508E83_1997678531;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2117009588 = varB4EAC82CA7396A68D541C85D26508E83_680596464;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2117009588 = varB4EAC82CA7396A68D541C85D26508E83_1255428898;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2117009588.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2117009588;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.346 -0400", hash_original_method = "1DDF123F9002EFB3DC60D7666C901199", hash_generated_method = "F4D33B327270567822A4727F5CFCD0F6")
    public short compareDocumentPosition(Node other) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(other.getTaint());
        short var4F09DAA9D95BCB166A302407A0E0BABE_650108853 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_650108853;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.349 -0400", hash_original_method = "67AC02ADFBE93754C1AB8AE0D37378EE", hash_generated_method = "2F5D488C6794C2BC657D1C10B4492275")
    public String getTextContent() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_1483977069 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1483977069 = getNodeValue();
        varB4EAC82CA7396A68D541C85D26508E83_1483977069.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1483977069;
        // ---------- Original Method ----------
        //return getNodeValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.349 -0400", hash_original_method = "6ADB0BF10CD256A5C763161A1385CD79", hash_generated_method = "97786403CD5A24A6B0E351D184A792DC")
     void getTextContent(StringBuilder buf) throws DOMException {
        String content = getNodeValue();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.350 -0400", hash_original_method = "B267D49587C3D1DB842740F077498528", hash_generated_method = "BDC793B9B2593326F60A58883974F5A7")
    public final void setTextContent(String textContent) throws DOMException {
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_1188762204 = (getNodeType());
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            Node child;
            //End case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            {
                boolean var7B4B4D60718B8920C8140722D3CC2681_1149621012 = ((child = getFirstChild()) != null);
                {
                    removeChild(child);
                } //End block
            } //End collapsed parenthetic
            //End case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            {
                boolean varE87C319A84018C6C43084B4686BD5121_966603529 = (textContent != null && textContent.length() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.352 -0400", hash_original_method = "CDCF2BEBCB3DF8B0191B82144C39E4E3", hash_generated_method = "C11F0F39A3CC08D08EA36A3A47347532")
    public boolean isSameNode(Node other) {
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713792391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713792391;
        // ---------- Original Method ----------
        //return this == other;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.357 -0400", hash_original_method = "DDD4A4E09BB31E4B92DF0753DE457415", hash_generated_method = "7168FA8C58A563ABBFA2CA3669F25107")
    private NodeImpl getNamespacingElement() {
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_774994507 = null; //Variable for return #1
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1950485080 = null; //Variable for return #2
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_204253036 = null; //Variable for return #3
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_764275199 = null; //Variable for return #4
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1228824325 = null; //Variable for return #5
        {
            Object varCF51CDECE43343A636AB308505B1992B_1193424572 = (this.getNodeType());
            //Begin case ELEMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_774994507 = this;
            //End case ELEMENT_NODE 
            //Begin case DOCUMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1950485080 = (NodeImpl) ((Document) this).getDocumentElement();
            //End case DOCUMENT_NODE 
            //Begin case ENTITY_NODE NOTATION_NODE DOCUMENT_FRAGMENT_NODE DOCUMENT_TYPE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_204253036 = null;
            //End case ENTITY_NODE NOTATION_NODE DOCUMENT_FRAGMENT_NODE DOCUMENT_TYPE_NODE 
            //Begin case ATTRIBUTE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_764275199 = (NodeImpl) ((Attr) this).getOwnerElement();
            //End case ATTRIBUTE_NODE 
            //Begin case TEXT_NODE CDATA_SECTION_NODE ENTITY_REFERENCE_NODE PROCESSING_INSTRUCTION_NODE COMMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1228824325 = getContainingElement();
            //End case TEXT_NODE CDATA_SECTION_NODE ENTITY_REFERENCE_NODE PROCESSING_INSTRUCTION_NODE COMMENT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
            //End case default 
        } //End collapsed parenthetic
        NodeImpl varA7E53CE21691AB073D9660D615818899_1203942372; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1203942372 = varB4EAC82CA7396A68D541C85D26508E83_774994507;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1203942372 = varB4EAC82CA7396A68D541C85D26508E83_1950485080;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1203942372 = varB4EAC82CA7396A68D541C85D26508E83_204253036;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1203942372 = varB4EAC82CA7396A68D541C85D26508E83_764275199;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1203942372 = varB4EAC82CA7396A68D541C85D26508E83_1228824325;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1203942372.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1203942372;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.359 -0400", hash_original_method = "E4B9E13482B5AB13521831694CDD3F31", hash_generated_method = "F84C9ACA0D0A9635E9ECEE82247DE518")
    private NodeImpl getContainingElement() {
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_2056173692 = null; //Variable for return #1
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_330559089 = null; //Variable for return #2
        {
            Node p = getParentNode();
            p = p.getParentNode();
            {
                {
                    boolean varFBC5A12935C2B20E9065353DA95A8A18_1626016447 = (p.getNodeType() == ELEMENT_NODE);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2056173692 = (NodeImpl) p;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_330559089 = null;
        NodeImpl varA7E53CE21691AB073D9660D615818899_1874085165; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1874085165 = varB4EAC82CA7396A68D541C85D26508E83_2056173692;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1874085165 = varB4EAC82CA7396A68D541C85D26508E83_330559089;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1874085165.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1874085165;
        // ---------- Original Method ----------
        //for (Node p = getParentNode(); p != null; p = p.getParentNode()) {
            //if (p.getNodeType() == ELEMENT_NODE) {
                //return (NodeImpl) p;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.361 -0400", hash_original_method = "7FA28D24E20CD6244334CF1DE396DB62", hash_generated_method = "5D7320D6B69E163A1D47A601EB51C997")
    public final String lookupPrefix(String namespaceURI) {
        String varB4EAC82CA7396A68D541C85D26508E83_1949972761 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1938116680 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_788929797 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1639186122 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_1949972761 = null;
        } //End block
        NodeImpl target = getNamespacingElement();
        {
            NodeImpl node = target;
            node = node.getContainingElement();
            {
                {
                    boolean varB403AB9B9BBCA7835D5E0AFC14FDB897_1556524345 = (namespaceURI.equals(node.getNamespaceURI())
                    && target.isPrefixMappedToUri(node.getPrefix(), namespaceURI));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1938116680 = node.getPrefix();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varC9579644D782C09885D8B6799B24D1B7_2146882621 = (!node.hasAttributes());
                } //End collapsed parenthetic
                NamedNodeMap attributes = node.getAttributes();
                {
                    int i = 0;
                    int length = attributes.getLength();
                    {
                        Node attr = attributes.item(i);
                        {
                            boolean var041AF16A4322928AB25B30D9E76210A6_298667844 = (!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())
                        || !"xmlns".equals(attr.getPrefix())
                        || !namespaceURI.equals(attr.getNodeValue()));
                        } //End collapsed parenthetic
                        {
                            boolean varF15B4EC2E77AFBBC3F4E8FC11243E540_1160792601 = (target.isPrefixMappedToUri(attr.getLocalName(), namespaceURI));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_788929797 = attr.getLocalName();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1639186122 = null;
        addTaint(namespaceURI.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1483051630; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1483051630 = varB4EAC82CA7396A68D541C85D26508E83_1949972761;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1483051630 = varB4EAC82CA7396A68D541C85D26508E83_1938116680;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1483051630 = varB4EAC82CA7396A68D541C85D26508E83_788929797;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1483051630 = varB4EAC82CA7396A68D541C85D26508E83_1639186122;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1483051630.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1483051630;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.362 -0400", hash_original_method = "AA07F6405A8EB7821F818F6C760FCB2D", hash_generated_method = "E13F424CA3342321106A4623E00F4457")
     boolean isPrefixMappedToUri(String prefix, String uri) {
        String actual = lookupNamespaceURI(prefix);
        boolean varF9523BA0BFC98B7D91C11E34CD185911_835867797 = (uri.equals(actual));
        addTaint(prefix.getTaint());
        addTaint(uri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_127636857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_127636857;
        // ---------- Original Method ----------
        //if (prefix == null) {
            //return false;
        //}
        //String actual = lookupNamespaceURI(prefix);
        //return uri.equals(actual);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.363 -0400", hash_original_method = "408B99A289EC0349924637E46549BA26", hash_generated_method = "4FF79F3065DFB8C09B5C8180AB158B53")
    public final boolean isDefaultNamespace(String namespaceURI) {
        String actual = lookupNamespaceURI(null);
        {
            Object varA1932E607C647B6D725637B43AC06F10_388654941 = (namespaceURI.equals(actual));
        } //End flattened ternary
        addTaint(namespaceURI.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1531312508 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1531312508;
        // ---------- Original Method ----------
        //String actual = lookupNamespaceURI(null);
        //return namespaceURI == null
                //? actual == null
                //: namespaceURI.equals(actual);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.365 -0400", hash_original_method = "4BD06F1D22ADF3EA57842F923303423E", hash_generated_method = "A4907B048F1C906EEF7D252514809D5E")
    public final String lookupNamespaceURI(String prefix) {
        String varB4EAC82CA7396A68D541C85D26508E83_1640901861 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2121870348 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_676195140 = null; //Variable for return #3
        NodeImpl target = getNamespacingElement();
        {
            NodeImpl node = target;
            node = node.getContainingElement();
            {
                String nodePrefix = node.getPrefix();
                {
                    boolean var8BF87494DE6EC4578842A86B09D729A6_879438424 = (node.getNamespaceURI() != null);
                    {
                        {
                            {
                                boolean var37CC4D70FC3B61DCF871FB1CF8AD2846_1059800111 = (prefix.equals(nodePrefix));
                            } //End flattened ternary
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1640901861 = node.getNamespaceURI();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varC9579644D782C09885D8B6799B24D1B7_852659250 = (!node.hasAttributes());
                } //End collapsed parenthetic
                NamedNodeMap attributes = node.getAttributes();
                {
                    int i = 0;
                    int length = attributes.getLength();
                    {
                        Node attr = attributes.item(i);
                        {
                            boolean varA13C057422A3B97AA60AD41894F0635F_631282016 = (!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI()));
                        } //End collapsed parenthetic
                        {
                            {
                                boolean varFF1254D872CF5DC8F931458B444BA8F1_1394510912 = ("xmlns".equals(attr.getNodeName()));
                                boolean varBCF6CD3EF8E6EAEC9EE3BFD950C4EEDF_1713605128 = ("xmlns".equals(attr.getPrefix()) && prefix.equals(attr.getLocalName()));
                            } //End flattened ternary
                            {
                                String value = attr.getNodeValue();
                                varB4EAC82CA7396A68D541C85D26508E83_2121870348 = value.length() > 0 ? value : null;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_676195140 = null;
        addTaint(prefix.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1535099538; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1535099538 = varB4EAC82CA7396A68D541C85D26508E83_1640901861;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1535099538 = varB4EAC82CA7396A68D541C85D26508E83_2121870348;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1535099538 = varB4EAC82CA7396A68D541C85D26508E83_676195140;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1535099538.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1535099538;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.366 -0400", hash_original_method = "5ACD5A1048128B414FC469A4162D7D49", hash_generated_method = "B165D23370D391ADDDCBD96F6F4D4B37")
    public final boolean isEqualNode(Node arg) {
        {
            boolean var651A5D8954C9CB1305B0993B5221CC81_1019108756 = (arg == this);
        } //End collapsed parenthetic
        List<Object> listA = createEqualityKey(this);
        List<Object> listB = createEqualityKey(arg);
        {
            boolean varA3551D9BD39003E9C908D438AFCDB1BC_208998638 = (listA.size() != listB.size());
        } //End collapsed parenthetic
        {
            int i = 0;
            boolean var6EBB52ED45932AB49617FFD096C89B6F_1630532053 = (i < listA.size());
            {
                Object a = listA.get(i);
                Object b = listB.get(i);
                {
                    {
                        boolean var0773BCBF827A4914F7F4F933191F9A10_1872235562 = (!a.equals(b));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var7D0BEECF51923FA96C755BED3C32C5AF_1890077016 = (!(b instanceof NamedNodeMap)
                        || !namedNodeMapsEqual((NamedNodeMap) a, (NamedNodeMap) b));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varBA00253A935A73454F5089C6C332A1DE_1900078020 = (!(b instanceof Node)
                        || !((Node) a).isEqualNode((Node) b));
                    } //End collapsed parenthetic
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(arg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_480682676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_480682676;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.367 -0400", hash_original_method = "C9854B9EF2C5621F4F378B8106F34125", hash_generated_method = "2B2EC4EF582A77550BEBA08A8A142BCF")
    private boolean namedNodeMapsEqual(NamedNodeMap a, NamedNodeMap b) {
        {
            boolean var0E71204F221B1B5EA61075617DA2C225_1008214668 = (a.getLength() != b.getLength());
        } //End collapsed parenthetic
        {
            int i = 0;
            boolean var4A7AD866419D9BB4E8A28D673C28686A_998196645 = (i < a.getLength());
            {
                Node aNode = a.item(i);
                Node bNode;
                boolean var880BE5E00764F10380C46D6CC262B0C9_1635414951 = (aNode.getLocalName() == null);
                bNode = b.getNamedItem(aNode.getNodeName());
                bNode = b.getNamedItemNS(aNode.getNamespaceURI(), aNode.getLocalName());
                {
                    boolean var7A836BDFDA6DC612AD6664CCCED1DCCF_161450222 = (bNode == null || !aNode.isEqualNode(bNode));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1029851196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1029851196;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.369 -0400", hash_original_method = "654AD0B7653E61CCCCF2A287DD7A9FCF", hash_generated_method = "D14496651430BED8D01EC9E43FFE96FA")
    public final Object getFeature(String feature, String version) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1008957171 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1008957171 = isSupported(feature, version) ? this : null;
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1008957171.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008957171;
        // ---------- Original Method ----------
        //return isSupported(feature, version) ? this : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.371 -0400", hash_original_method = "9F34FDEA3DB7CC58B5A8B86C5F6353A5", hash_generated_method = "EF7176E29C04E6CC1A2305FB10FE4A5A")
    public final Object setUserData(String key, Object data, UserDataHandler handler) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1486769565 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        Map<String, UserData> map = document.getUserDataMap(this);
        UserData previous;
        previous = map.remove(key);
        previous = map.put(key, new UserData(data, handler));
        varB4EAC82CA7396A68D541C85D26508E83_1486769565 = previous != null ? previous.value : null;
        addTaint(key.getTaint());
        addTaint(data.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1486769565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1486769565;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.371 -0400", hash_original_method = "B29B782E95D64D942AA9D9D3C7EEF744", hash_generated_method = "19300AFCCA7307A3CB680A1C67D7761E")
    public final Object getUserData(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1222773921 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        Map<String, UserData> map = document.getUserDataMapForRead(this);
        UserData userData = map.get(key);
        varB4EAC82CA7396A68D541C85D26508E83_1222773921 = userData != null ? userData.value : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1222773921.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1222773921;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //Map<String, UserData> map = document.getUserDataMapForRead(this);
        //UserData userData = map.get(key);
        //return userData != null ? userData.value : null;
    }

    
    static class UserData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.371 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.371 -0400", hash_original_field = "C1CBFE271A40788A00E8BF8574D94D4B", hash_generated_field = "827CB1F78A0BBD2016258DC26E1ED2F5")

        UserDataHandler handler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.372 -0400", hash_original_method = "0B6C19B4FFBA791689124EA47788F25F", hash_generated_method = "B74553803370CA04690975E42C003D03")
          UserData(Object value, UserDataHandler handler) {
            this.value = value;
            this.handler = handler;
            // ---------- Original Method ----------
            //this.value = value;
            //this.handler = handler;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.372 -0400", hash_original_field = "EEA06414AB077EBEC8501A6D636767BD", hash_generated_field = "F53B7EB5F95F86FB434D25A8A5066C44")

    private static final NodeList EMPTY_LIST = new NodeListImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.373 -0400", hash_original_field = "50B55FD6A8E5705F66BF71830D3227D1", hash_generated_field = "9BE656944A6DBF09637C80D55E352920")

    static final TypeInfo NULL_TYPE_INFO = new TypeInfo() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.372 -0400", hash_original_method = "D6670B1956B399E1F4484C7409D24E32", hash_generated_method = "B4051AD4FF44AD338624469365B280F8")
        public String getTypeName() {
            String varB4EAC82CA7396A68D541C85D26508E83_366710541 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_366710541 = null;
            varB4EAC82CA7396A68D541C85D26508E83_366710541.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_366710541;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.373 -0400", hash_original_method = "076EDBD720D64B1CD58A3E3161F3A408", hash_generated_method = "83D91F2300DCAB76D6EC29A18904FFB6")
        public String getTypeNamespace() {
            String varB4EAC82CA7396A68D541C85D26508E83_2015477207 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2015477207 = null;
            varB4EAC82CA7396A68D541C85D26508E83_2015477207.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2015477207;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.373 -0400", hash_original_method = "C5EC47855C2BF530753D3BD268C04AD2", hash_generated_method = "7E85F18F923F01A529081C723FC951EF")
        public boolean isDerivedFrom(
                String typeNamespaceArg, String typeNameArg, int derivationMethod) {
            addTaint(typeNamespaceArg.getTaint());
            addTaint(typeNameArg.getTaint());
            addTaint(derivationMethod);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943518646 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_943518646;
            // ---------- Original Method ----------
            //return false;
        }

        
};
}

