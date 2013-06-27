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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.573 -0400", hash_original_field = "FDC3BDEFB79CEC8EB8211D2499E04704", hash_generated_field = "3C52D3A90E4759490A57AF776DEAFE65")

    DocumentImpl document;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.574 -0400", hash_original_method = "A803585FEFBC6246911A956CA607D5CA", hash_generated_method = "9F50EA75A2AED9D57A4F24B1458FBC54")
      NodeImpl(DocumentImpl document) {
        this.document = document;
        // ---------- Original Method ----------
        //this.document = document;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.574 -0400", hash_original_method = "2014C4DBC7F925271C7D07A1BBA7C167", hash_generated_method = "79482AFAA555B5637FF2DF58F8E2AAF9")
    public Node appendChild(Node newChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(newChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.585 -0400", hash_original_method = "917775F899DEE58C265631FD33F793ED", hash_generated_method = "E3BC8CADE6A7A420C3EB99487F9A1353")
    public final Node cloneNode(boolean deep) {
        Node varB4EAC82CA7396A68D541C85D26508E83_1518113911 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1518113911 = document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
        addTaint(deep);
        varB4EAC82CA7396A68D541C85D26508E83_1518113911.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1518113911;
        // ---------- Original Method ----------
        //return document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.585 -0400", hash_original_method = "E2D79625FBECAF1E43447A0BEFC228B9", hash_generated_method = "3C549DD236A7F61CFA8407D64513F84E")
    public NamedNodeMap getAttributes() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_76409671 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_76409671 = null;
        varB4EAC82CA7396A68D541C85D26508E83_76409671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_76409671;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.585 -0400", hash_original_method = "1F381BCE8228355FEE86D697E02DDE0B", hash_generated_method = "CC022433A7D8131D3CB2D448910F8386")
    public NodeList getChildNodes() {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_544988050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_544988050 = EMPTY_LIST;
        varB4EAC82CA7396A68D541C85D26508E83_544988050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_544988050;
        // ---------- Original Method ----------
        //return EMPTY_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.586 -0400", hash_original_method = "DB31E0DD76C8C1947AB843730A5D8205", hash_generated_method = "2A0248C4D23F38698565CBBEC786952D")
    public Node getFirstChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1142455890 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1142455890 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1142455890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1142455890;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.586 -0400", hash_original_method = "6070A4A9C5DDD0223B459D45F6FD5CBB", hash_generated_method = "5C85F3CF1C2B32FC93D8A2D5361E7BE5")
    public Node getLastChild() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1134180043 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1134180043 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1134180043.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1134180043;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.587 -0400", hash_original_method = "DEB04882A70946FEC78DD7AD3ABDE01B", hash_generated_method = "DA5F50427913453AA53B7CB484E8A79E")
    public String getLocalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1929288230 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1929288230 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1929288230.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1929288230;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.587 -0400", hash_original_method = "4D95F58ABD4076A5B25FED87E28A6FD8", hash_generated_method = "707C468FDFB14B847F0E4BA18E0A1CB4")
    public String getNamespaceURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1492611024 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1492611024 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1492611024.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1492611024;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.587 -0400", hash_original_method = "D23B45CE7514A5E8C576F43815BA5C75", hash_generated_method = "88B632607FB2E7A3C97D7F789BA2D8AD")
    public Node getNextSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_1652926283 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1652926283 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1652926283.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1652926283;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.591 -0400", hash_original_method = "FDA68CAC7DBE692AD654EACCAEB8ADF4", hash_generated_method = "821866428FE74E3DB5E4898E77DFF55C")
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_451326064 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_451326064 = null;
        varB4EAC82CA7396A68D541C85D26508E83_451326064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_451326064;
        // ---------- Original Method ----------
        //return null;
    }

    
    public abstract short getNodeType();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.592 -0400", hash_original_method = "5D533F6B29FA017DED37EB54506CEFCE", hash_generated_method = "82B75A207C0A03B67235AABC730C61EE")
    public String getNodeValue() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_2055033950 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2055033950 = null;
        varB4EAC82CA7396A68D541C85D26508E83_2055033950.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2055033950;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.592 -0400", hash_original_method = "683FB3B36E3C0C255B09CB1FE69555EA", hash_generated_method = "101DD06CE85101CDBABF8994C9501D62")
    public final Document getOwnerDocument() {
        Document varB4EAC82CA7396A68D541C85D26508E83_418804957 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_418804957 = document == this ? null : document;
        varB4EAC82CA7396A68D541C85D26508E83_418804957.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_418804957;
        // ---------- Original Method ----------
        //return document == this ? null : document;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.598 -0400", hash_original_method = "2F661FBCA438408BEACED1A87A3CFAEE", hash_generated_method = "384378C93E2651106E702E47EA1424F1")
    public Node getParentNode() {
        Node varB4EAC82CA7396A68D541C85D26508E83_946022664 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_946022664 = null;
        varB4EAC82CA7396A68D541C85D26508E83_946022664.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946022664;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.599 -0400", hash_original_method = "727413C23E49E727D2327332BBC1F81A", hash_generated_method = "D8EAB4C0E90A14949F34FBB485BE12A3")
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1471496078 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1471496078 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1471496078.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1471496078;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.599 -0400", hash_original_method = "70F44FC98E437F8103C8C034DB4ECB33", hash_generated_method = "835378BC8302D32D989F593371033F65")
    public Node getPreviousSibling() {
        Node varB4EAC82CA7396A68D541C85D26508E83_400811808 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_400811808 = null;
        varB4EAC82CA7396A68D541C85D26508E83_400811808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_400811808;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.599 -0400", hash_original_method = "B7795536C66ABB4718F9ED686281788D", hash_generated_method = "61A6D7B083A0C8F54330F96B866EA2ED")
    public boolean hasAttributes() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_380469467 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_380469467;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.600 -0400", hash_original_method = "75BC1F0CD3DD7ADF1C7C374A2270CAC3", hash_generated_method = "A120E3E27F34796C8DA52499508BB098")
    public boolean hasChildNodes() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1199103160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1199103160;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.600 -0400", hash_original_method = "02900D7407B8981D4618C0943B784132", hash_generated_method = "617F6B66ECDBA72611816581457BD4A3")
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(newChild.getTaint());
        addTaint(refChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.600 -0400", hash_original_method = "83D2E21D1EF19CE5C027A4D56C9BBECC", hash_generated_method = "8ACC8C3B29445FD2DBB249F466620819")
    public boolean isSupported(String feature, String version) {
        boolean var35F7927EF3CC7F4E5B6C50A87B9E3142_845382596 = (DOMImplementationImpl.getInstance().hasFeature(feature, version));
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110501827 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_110501827;
        // ---------- Original Method ----------
        //return DOMImplementationImpl.getInstance().hasFeature(feature, version);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.602 -0400", hash_original_method = "6E21C006D39E2D7D2AB395E9723D1D3D", hash_generated_method = "AAB79EA75709AFAC418FB3A2AD6C8459")
    public void normalize() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.603 -0400", hash_original_method = "C0BCC4253F844D2665FCB84131264ACF", hash_generated_method = "FE717F7796FE21AB7A918AF615E52C34")
    public Node removeChild(Node oldChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(oldChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.603 -0400", hash_original_method = "3CB9ABDC605D3811167E9E73D3AF8E67", hash_generated_method = "A322881ED50C77810DAE5B16E19CB0DD")
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        addTaint(newChild.getTaint());
        addTaint(oldChild.getTaint());
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.604 -0400", hash_original_method = "DD460B5BCEAE1CB09CE08B91E621DF7E", hash_generated_method = "043F9F8805E781EB5D977B4CEB9AEDC9")
    public final void setNodeValue(String nodeValue) throws DOMException {
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_1877927880 = (getNodeType());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.604 -0400", hash_original_method = "534A727E4FDB6CDBB5DC8BBEFB80CC50", hash_generated_method = "6394A903E9072527732E970BA56A5453")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.612 -0400", hash_original_method = "DD28C7A733028F46F0F8ECAE2D47C2BC", hash_generated_method = "F777F03EEB2948380070F53920E6A6A2")
    public final String getBaseURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1787147078 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_288078612 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1821492497 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1620833414 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1669308924 = null; //Variable for return #5
        String varB4EAC82CA7396A68D541C85D26508E83_1253468928 = null; //Variable for return #6
        String varB4EAC82CA7396A68D541C85D26508E83_1191373475 = null; //Variable for return #7
        String varB4EAC82CA7396A68D541C85D26508E83_384834383 = null; //Variable for return #8
        String varB4EAC82CA7396A68D541C85D26508E83_1358654000 = null; //Variable for return #9
        String varB4EAC82CA7396A68D541C85D26508E83_1250959704 = null; //Variable for return #10
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_918977087 = (getNodeType());
            //Begin case DOCUMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1787147078 = sanitizeUri(((Document) this).getDocumentURI());
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
                    boolean varCD5A1EF129D63A19CBA8F3323E78D018_886123776 = (uri == null || uri.isEmpty());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_288078612 = getParentBaseUri();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varCFCB3A4B5B2F222B09B28B628CD2D035_1307719251 = (new URI(uri).isAbsolute());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1821492497 = uri;
                    } //End block
                } //End collapsed parenthetic
                String parentUri;
                parentUri = getParentBaseUri();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1620833414 = null;
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1669308924 = new URI(parentUri).resolve(uri).toString();
            } //End block
            catch (URISyntaxException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1253468928 = null;
            } //End block
            //End case ELEMENT_NODE 
            //Begin case PROCESSING_INSTRUCTION_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1191373475 = getParentBaseUri();
            //End case PROCESSING_INSTRUCTION_NODE 
            //Begin case NOTATION_NODE ENTITY_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_384834383 = null;
            //End case NOTATION_NODE ENTITY_NODE 
            //Begin case ENTITY_REFERENCE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1358654000 = null;
            //End case ENTITY_REFERENCE_NODE 
            //Begin case DOCUMENT_TYPE_NODE DOCUMENT_FRAGMENT_NODE ATTRIBUTE_NODE TEXT_NODE CDATA_SECTION_NODE COMMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1250959704 = null;
            //End case DOCUMENT_TYPE_NODE DOCUMENT_FRAGMENT_NODE ATTRIBUTE_NODE TEXT_NODE CDATA_SECTION_NODE COMMENT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
            //End case default 
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_1354524274; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1354524274 = varB4EAC82CA7396A68D541C85D26508E83_1787147078;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1354524274 = varB4EAC82CA7396A68D541C85D26508E83_288078612;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1354524274 = varB4EAC82CA7396A68D541C85D26508E83_1821492497;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1354524274 = varB4EAC82CA7396A68D541C85D26508E83_1620833414;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1354524274 = varB4EAC82CA7396A68D541C85D26508E83_1669308924;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1354524274 = varB4EAC82CA7396A68D541C85D26508E83_1253468928;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1354524274 = varB4EAC82CA7396A68D541C85D26508E83_1191373475;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1354524274 = varB4EAC82CA7396A68D541C85D26508E83_384834383;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1354524274 = varB4EAC82CA7396A68D541C85D26508E83_1358654000;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1354524274 = varB4EAC82CA7396A68D541C85D26508E83_1250959704;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1354524274.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1354524274;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.615 -0400", hash_original_method = "DFD855C107B39D74015E43DCF13ECA5E", hash_generated_method = "D0E5658DA901BEAD3E20CA79444C9EE3")
    private String getParentBaseUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_58362263 = null; //Variable for return #1
        Node parentNode;
        parentNode = getParentNode();
        varB4EAC82CA7396A68D541C85D26508E83_58362263 = parentNode != null ? parentNode.getBaseURI() : null;
        varB4EAC82CA7396A68D541C85D26508E83_58362263.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_58362263;
        // ---------- Original Method ----------
        //Node parentNode = getParentNode();
        //return parentNode != null ? parentNode.getBaseURI() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.616 -0400", hash_original_method = "1D824B9402137DBC708C242BAEC27F82", hash_generated_method = "6ABB47C04294C1F0F9F8DF8A785781F3")
    private String sanitizeUri(String uri) {
        String varB4EAC82CA7396A68D541C85D26508E83_1259137310 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1745880154 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2099141061 = null; //Variable for return #3
        {
            boolean var6E057AB845D6ADAE670C60C55D7A447B_1178165536 = (uri == null || uri.length() == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1259137310 = null;
            } //End block
        } //End collapsed parenthetic
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1745880154 = new URI(uri).toString();
        } //End block
        catch (URISyntaxException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_2099141061 = null;
        } //End block
        addTaint(uri.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1637009399; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1637009399 = varB4EAC82CA7396A68D541C85D26508E83_1259137310;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1637009399 = varB4EAC82CA7396A68D541C85D26508E83_1745880154;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1637009399 = varB4EAC82CA7396A68D541C85D26508E83_2099141061;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1637009399.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1637009399;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.616 -0400", hash_original_method = "1DDF123F9002EFB3DC60D7666C901199", hash_generated_method = "85959B76AC2E41C3B4503D835A8213D9")
    public short compareDocumentPosition(Node other) throws DOMException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(other.getTaint());
        short var4F09DAA9D95BCB166A302407A0E0BABE_1449689943 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1449689943;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.620 -0400", hash_original_method = "67AC02ADFBE93754C1AB8AE0D37378EE", hash_generated_method = "D05AB31CB422088C04133578E1F08693")
    public String getTextContent() throws DOMException {
        String varB4EAC82CA7396A68D541C85D26508E83_532607489 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_532607489 = getNodeValue();
        varB4EAC82CA7396A68D541C85D26508E83_532607489.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_532607489;
        // ---------- Original Method ----------
        //return getNodeValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.620 -0400", hash_original_method = "6ADB0BF10CD256A5C763161A1385CD79", hash_generated_method = "E911BAAF6AF9E50E5560F90FE3EB1287")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.621 -0400", hash_original_method = "B267D49587C3D1DB842740F077498528", hash_generated_method = "ABED55B8B16192EE9223A6C901C95A9E")
    public final void setTextContent(String textContent) throws DOMException {
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_701416160 = (getNodeType());
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            Node child;
            //End case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            {
                boolean var7B4B4D60718B8920C8140722D3CC2681_88267051 = ((child = getFirstChild()) != null);
                {
                    removeChild(child);
                } //End block
            } //End collapsed parenthetic
            //End case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            {
                boolean varE87C319A84018C6C43084B4686BD5121_1599123638 = (textContent != null && textContent.length() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.621 -0400", hash_original_method = "CDCF2BEBCB3DF8B0191B82144C39E4E3", hash_generated_method = "D5A41D7233439C526DC14B742EE109DD")
    public boolean isSameNode(Node other) {
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_581906138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_581906138;
        // ---------- Original Method ----------
        //return this == other;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.622 -0400", hash_original_method = "DDD4A4E09BB31E4B92DF0753DE457415", hash_generated_method = "CFF59301EE1D9BC790AE526DB3C52E40")
    private NodeImpl getNamespacingElement() {
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1043231908 = null; //Variable for return #1
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1310637475 = null; //Variable for return #2
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1623870650 = null; //Variable for return #3
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1266540429 = null; //Variable for return #4
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_119345882 = null; //Variable for return #5
        {
            Object varCF51CDECE43343A636AB308505B1992B_410326454 = (this.getNodeType());
            //Begin case ELEMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1043231908 = this;
            //End case ELEMENT_NODE 
            //Begin case DOCUMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1310637475 = (NodeImpl) ((Document) this).getDocumentElement();
            //End case DOCUMENT_NODE 
            //Begin case ENTITY_NODE NOTATION_NODE DOCUMENT_FRAGMENT_NODE DOCUMENT_TYPE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1623870650 = null;
            //End case ENTITY_NODE NOTATION_NODE DOCUMENT_FRAGMENT_NODE DOCUMENT_TYPE_NODE 
            //Begin case ATTRIBUTE_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_1266540429 = (NodeImpl) ((Attr) this).getOwnerElement();
            //End case ATTRIBUTE_NODE 
            //Begin case TEXT_NODE CDATA_SECTION_NODE ENTITY_REFERENCE_NODE PROCESSING_INSTRUCTION_NODE COMMENT_NODE 
            varB4EAC82CA7396A68D541C85D26508E83_119345882 = getContainingElement();
            //End case TEXT_NODE CDATA_SECTION_NODE ENTITY_REFERENCE_NODE PROCESSING_INSTRUCTION_NODE COMMENT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
            //End case default 
        } //End collapsed parenthetic
        NodeImpl varA7E53CE21691AB073D9660D615818899_1724297760; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1724297760 = varB4EAC82CA7396A68D541C85D26508E83_1043231908;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1724297760 = varB4EAC82CA7396A68D541C85D26508E83_1310637475;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1724297760 = varB4EAC82CA7396A68D541C85D26508E83_1623870650;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1724297760 = varB4EAC82CA7396A68D541C85D26508E83_1266540429;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1724297760 = varB4EAC82CA7396A68D541C85D26508E83_119345882;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1724297760.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1724297760;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.626 -0400", hash_original_method = "E4B9E13482B5AB13521831694CDD3F31", hash_generated_method = "B0A219C09483C5C71C0FFC8885E714B1")
    private NodeImpl getContainingElement() {
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_449829199 = null; //Variable for return #1
        NodeImpl varB4EAC82CA7396A68D541C85D26508E83_1270362626 = null; //Variable for return #2
        {
            Node p;
            p = getParentNode();
            p = p.getParentNode();
            {
                {
                    boolean varFBC5A12935C2B20E9065353DA95A8A18_2074978322 = (p.getNodeType() == ELEMENT_NODE);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_449829199 = (NodeImpl) p;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1270362626 = null;
        NodeImpl varA7E53CE21691AB073D9660D615818899_88344392; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_88344392 = varB4EAC82CA7396A68D541C85D26508E83_449829199;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_88344392 = varB4EAC82CA7396A68D541C85D26508E83_1270362626;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_88344392.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_88344392;
        // ---------- Original Method ----------
        //for (Node p = getParentNode(); p != null; p = p.getParentNode()) {
            //if (p.getNodeType() == ELEMENT_NODE) {
                //return (NodeImpl) p;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.634 -0400", hash_original_method = "7FA28D24E20CD6244334CF1DE396DB62", hash_generated_method = "DFD347CA3459C7548CAB599827C582AC")
    public final String lookupPrefix(String namespaceURI) {
        String varB4EAC82CA7396A68D541C85D26508E83_805737528 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_794659048 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_986713952 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_2116997834 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_805737528 = null;
        } //End block
        NodeImpl target;
        target = getNamespacingElement();
        {
            NodeImpl node;
            node = target;
            node = node.getContainingElement();
            {
                {
                    boolean varB403AB9B9BBCA7835D5E0AFC14FDB897_1516951726 = (namespaceURI.equals(node.getNamespaceURI())
                    && target.isPrefixMappedToUri(node.getPrefix(), namespaceURI));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_794659048 = node.getPrefix();
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varC9579644D782C09885D8B6799B24D1B7_1168789785 = (!node.hasAttributes());
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
                            boolean var041AF16A4322928AB25B30D9E76210A6_2049379787 = (!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())
                        || !"xmlns".equals(attr.getPrefix())
                        || !namespaceURI.equals(attr.getNodeValue()));
                        } //End collapsed parenthetic
                        {
                            boolean varF15B4EC2E77AFBBC3F4E8FC11243E540_183874121 = (target.isPrefixMappedToUri(attr.getLocalName(), namespaceURI));
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_986713952 = attr.getLocalName();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2116997834 = null;
        addTaint(namespaceURI.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1544218119; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1544218119 = varB4EAC82CA7396A68D541C85D26508E83_805737528;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1544218119 = varB4EAC82CA7396A68D541C85D26508E83_794659048;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1544218119 = varB4EAC82CA7396A68D541C85D26508E83_986713952;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1544218119 = varB4EAC82CA7396A68D541C85D26508E83_2116997834;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1544218119.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1544218119;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.634 -0400", hash_original_method = "AA07F6405A8EB7821F818F6C760FCB2D", hash_generated_method = "D9249F6E4D7E6EED25E6FD9C8C725243")
     boolean isPrefixMappedToUri(String prefix, String uri) {
        String actual;
        actual = lookupNamespaceURI(prefix);
        boolean varF9523BA0BFC98B7D91C11E34CD185911_758957159 = (uri.equals(actual));
        addTaint(prefix.getTaint());
        addTaint(uri.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2076955857 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2076955857;
        // ---------- Original Method ----------
        //if (prefix == null) {
            //return false;
        //}
        //String actual = lookupNamespaceURI(prefix);
        //return uri.equals(actual);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.641 -0400", hash_original_method = "408B99A289EC0349924637E46549BA26", hash_generated_method = "8F977CDC25BD62AAF15932F4B77D182D")
    public final boolean isDefaultNamespace(String namespaceURI) {
        String actual;
        actual = lookupNamespaceURI(null);
        {
            Object varA1932E607C647B6D725637B43AC06F10_1494933779 = (namespaceURI.equals(actual));
        } //End flattened ternary
        addTaint(namespaceURI.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1667837535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1667837535;
        // ---------- Original Method ----------
        //String actual = lookupNamespaceURI(null);
        //return namespaceURI == null
                //? actual == null
                //: namespaceURI.equals(actual);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.645 -0400", hash_original_method = "4BD06F1D22ADF3EA57842F923303423E", hash_generated_method = "25C3FC605CE03674D771C81179171ED4")
    public final String lookupNamespaceURI(String prefix) {
        String varB4EAC82CA7396A68D541C85D26508E83_538008460 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_474469577 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_228971011 = null; //Variable for return #3
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
                    boolean var8BF87494DE6EC4578842A86B09D729A6_1429983938 = (node.getNamespaceURI() != null);
                    {
                        {
                            {
                                boolean var37CC4D70FC3B61DCF871FB1CF8AD2846_521481984 = (prefix.equals(nodePrefix));
                            } //End flattened ternary
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_538008460 = node.getNamespaceURI();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varC9579644D782C09885D8B6799B24D1B7_1969832789 = (!node.hasAttributes());
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
                            boolean varA13C057422A3B97AA60AD41894F0635F_600347403 = (!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI()));
                        } //End collapsed parenthetic
                        {
                            {
                                boolean varFF1254D872CF5DC8F931458B444BA8F1_2029767731 = ("xmlns".equals(attr.getNodeName()));
                                boolean varBCF6CD3EF8E6EAEC9EE3BFD950C4EEDF_1334277388 = ("xmlns".equals(attr.getPrefix()) && prefix.equals(attr.getLocalName()));
                            } //End flattened ternary
                            {
                                String value;
                                value = attr.getNodeValue();
                                varB4EAC82CA7396A68D541C85D26508E83_474469577 = value.length() > 0 ? value : null;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_228971011 = null;
        addTaint(prefix.getTaint());
        String varA7E53CE21691AB073D9660D615818899_317156760; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_317156760 = varB4EAC82CA7396A68D541C85D26508E83_538008460;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_317156760 = varB4EAC82CA7396A68D541C85D26508E83_474469577;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_317156760 = varB4EAC82CA7396A68D541C85D26508E83_228971011;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_317156760.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_317156760;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.658 -0400", hash_original_method = "5ACD5A1048128B414FC469A4162D7D49", hash_generated_method = "E72930B94354C7E5AEBDE0194CA62620")
    public final boolean isEqualNode(Node arg) {
        {
            boolean var651A5D8954C9CB1305B0993B5221CC81_186566771 = (arg == this);
        } //End collapsed parenthetic
        List<Object> listA;
        listA = createEqualityKey(this);
        List<Object> listB;
        listB = createEqualityKey(arg);
        {
            boolean varA3551D9BD39003E9C908D438AFCDB1BC_1009358850 = (listA.size() != listB.size());
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean var6EBB52ED45932AB49617FFD096C89B6F_1907787222 = (i < listA.size());
            {
                Object a;
                a = listA.get(i);
                Object b;
                b = listB.get(i);
                {
                    {
                        boolean var0773BCBF827A4914F7F4F933191F9A10_79215692 = (!a.equals(b));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var7D0BEECF51923FA96C755BED3C32C5AF_1332860243 = (!(b instanceof NamedNodeMap)
                        || !namedNodeMapsEqual((NamedNodeMap) a, (NamedNodeMap) b));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varBA00253A935A73454F5089C6C332A1DE_1657672877 = (!(b instanceof Node)
                        || !((Node) a).isEqualNode((Node) b));
                    } //End collapsed parenthetic
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError();
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(arg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_529992477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_529992477;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.659 -0400", hash_original_method = "C9854B9EF2C5621F4F378B8106F34125", hash_generated_method = "87E0D63EC49CB4A3D6111E144CCC5F2C")
    private boolean namedNodeMapsEqual(NamedNodeMap a, NamedNodeMap b) {
        {
            boolean var0E71204F221B1B5EA61075617DA2C225_1642418653 = (a.getLength() != b.getLength());
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean var4A7AD866419D9BB4E8A28D673C28686A_157371558 = (i < a.getLength());
            {
                Node aNode;
                aNode = a.item(i);
                Node bNode;
                boolean var880BE5E00764F10380C46D6CC262B0C9_221958826 = (aNode.getLocalName() == null);
                bNode = b.getNamedItem(aNode.getNodeName());
                bNode = b.getNamedItemNS(aNode.getNamespaceURI(), aNode.getLocalName());
                {
                    boolean var7A836BDFDA6DC612AD6664CCCED1DCCF_185266883 = (bNode == null || !aNode.isEqualNode(bNode));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(a.getTaint());
        addTaint(b.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418850939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418850939;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.659 -0400", hash_original_method = "654AD0B7653E61CCCCF2A287DD7A9FCF", hash_generated_method = "CE4844874569C89043154165CE116597")
    public final Object getFeature(String feature, String version) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1018948888 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1018948888 = isSupported(feature, version) ? this : null;
        addTaint(feature.getTaint());
        addTaint(version.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1018948888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1018948888;
        // ---------- Original Method ----------
        //return isSupported(feature, version) ? this : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.660 -0400", hash_original_method = "9F34FDEA3DB7CC58B5A8B86C5F6353A5", hash_generated_method = "A787D62059A04E1551CA187DBD197B9D")
    public final Object setUserData(String key, Object data, UserDataHandler handler) {
        Object varB4EAC82CA7396A68D541C85D26508E83_278407298 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        Map<String, UserData> map;
        map = document.getUserDataMap(this);
        UserData previous;
        previous = map.remove(key);
        previous = map.put(key, new UserData(data, handler));
        varB4EAC82CA7396A68D541C85D26508E83_278407298 = previous != null ? previous.value : null;
        addTaint(key.getTaint());
        addTaint(data.getTaint());
        addTaint(handler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_278407298.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_278407298;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.660 -0400", hash_original_method = "B29B782E95D64D942AA9D9D3C7EEF744", hash_generated_method = "684CFCB7B9888B19B02F137C98142662")
    public final Object getUserData(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1715799147 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        Map<String, UserData> map;
        map = document.getUserDataMapForRead(this);
        UserData userData;
        userData = map.get(key);
        varB4EAC82CA7396A68D541C85D26508E83_1715799147 = userData != null ? userData.value : null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1715799147.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1715799147;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //Map<String, UserData> map = document.getUserDataMapForRead(this);
        //UserData userData = map.get(key);
        //return userData != null ? userData.value : null;
    }

    
    static class UserData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.660 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.660 -0400", hash_original_field = "C1CBFE271A40788A00E8BF8574D94D4B", hash_generated_field = "827CB1F78A0BBD2016258DC26E1ED2F5")

        UserDataHandler handler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.666 -0400", hash_original_method = "0B6C19B4FFBA791689124EA47788F25F", hash_generated_method = "B74553803370CA04690975E42C003D03")
          UserData(Object value, UserDataHandler handler) {
            this.value = value;
            this.handler = handler;
            // ---------- Original Method ----------
            //this.value = value;
            //this.handler = handler;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.667 -0400", hash_original_field = "EEA06414AB077EBEC8501A6D636767BD", hash_generated_field = "F73237D1385F8D24CDF90DCA1C2652F9")

    private static NodeList EMPTY_LIST = new NodeListImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.678 -0400", hash_original_field = "50B55FD6A8E5705F66BF71830D3227D1", hash_generated_field = "654B50596C5329EE2B356D149F30632C")

    static TypeInfo NULL_TYPE_INFO = new TypeInfo() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.677 -0400", hash_original_method = "D6670B1956B399E1F4484C7409D24E32", hash_generated_method = "8E267ECF41FD39EC19E95BB618287B5F")
        public String getTypeName() {
            String varB4EAC82CA7396A68D541C85D26508E83_840465471 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_840465471 = null;
            varB4EAC82CA7396A68D541C85D26508E83_840465471.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_840465471;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.677 -0400", hash_original_method = "076EDBD720D64B1CD58A3E3161F3A408", hash_generated_method = "54DC7B6704F77CD561A043832B806A6E")
        public String getTypeNamespace() {
            String varB4EAC82CA7396A68D541C85D26508E83_1724516456 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1724516456 = null;
            varB4EAC82CA7396A68D541C85D26508E83_1724516456.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1724516456;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:12.678 -0400", hash_original_method = "C5EC47855C2BF530753D3BD268C04AD2", hash_generated_method = "7C25A3581894E360DDBCA4D4A6BBDDCE")
        public boolean isDerivedFrom(
                String typeNamespaceArg, String typeNameArg, int derivationMethod) {
            addTaint(typeNamespaceArg.getTaint());
            addTaint(typeNameArg.getTaint());
            addTaint(derivationMethod);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008335709 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008335709;
            // ---------- Original Method ----------
            //return false;
        }

        
};
}

