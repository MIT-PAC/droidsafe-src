package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    /**
     * Validates the element or attribute namespace prefix on this node.
     *
     * @param namespaceAware whether this node is namespace aware
     * @param namespaceURI this node's namespace URI
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.220 -0500", hash_original_method = "5A076CF41CCED2BA03916DBA6A8D512A", hash_generated_method = "A02189EB4857335F0506463788C17864")
    
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

    /**
     * Sets {@code node} to be namespace-aware and assigns its namespace URI
     * and qualified name.
     *
     * @param node an element or attribute node.
     * @param namespaceURI this node's namespace URI. May be null.
     * @param qualifiedName a possibly-prefixed name like "img" or "html:img".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.223 -0500", hash_original_method = "DA9A10D4BFE6F3C7C94DCF078FE3E793", hash_generated_method = "3567149F6AB32EE63E57D654E909A1CC")
    
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

    /**
     * Sets {@code node} to be not namespace-aware and assigns its name.
     *
     * @param node an element or attribute node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.226 -0500", hash_original_method = "D4A9B75EBE5B2394483BA819B660B5EB", hash_generated_method = "9775A9FE12F5070EC7B931CA3F875BF0")
    
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

    /**
     * Returns a list of objects such that two nodes are equal if their lists
     * are equal. Be careful: the lists may contain NamedNodeMaps and Nodes,
     * neither of which override Object.equals(). Such values must be compared
     * manually.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.265 -0500", hash_original_method = "9793DB47E7673F718DADE1F7C169BB4E", hash_generated_method = "79A13F694D4418D3F15A793345940960")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.146 -0500", hash_original_field = "EB6AC58D4187F31636AB0B55B3807816", hash_generated_field = "F53B7EB5F95F86FB434D25A8A5066C44")

    private static final NodeList EMPTY_LIST = new NodeListImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.373 -0400", hash_original_field = "50B55FD6A8E5705F66BF71830D3227D1", hash_generated_field = "9BE656944A6DBF09637C80D55E352920")

    static final TypeInfo NULL_TYPE_INFO = new TypeInfo() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.372 -0400", hash_original_method = "D6670B1956B399E1F4484C7409D24E32", hash_generated_method = "B4051AD4FF44AD338624469365B280F8")
        public String getTypeName() {
            String varB4EAC82CA7396A68D541C85D26508E83_366710541 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_366710541 = null;
            varB4EAC82CA7396A68D541C85D26508E83_366710541.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_366710541;
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.373 -0400", hash_original_method = "076EDBD720D64B1CD58A3E3161F3A408", hash_generated_method = "83D91F2300DCAB76D6EC29A18904FFB6")
        public String getTypeNamespace() {
            String varB4EAC82CA7396A68D541C85D26508E83_2015477207 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2015477207 = null;
            varB4EAC82CA7396A68D541C85D26508E83_2015477207.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2015477207;
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.373 -0400", hash_original_method = "C5EC47855C2BF530753D3BD268C04AD2", hash_generated_method = "7E85F18F923F01A529081C723FC951EF")
        public boolean isDerivedFrom(
                String typeNamespaceArg, String typeNameArg, int derivationMethod) {
            addTaint(typeNamespaceArg.getTaint());
            addTaint(typeNameArg.getTaint());
            addTaint(derivationMethod);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_943518646 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_943518646;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.159 -0500", hash_original_field = "3C52D3A90E4759490A57AF776DEAFE65", hash_generated_field = "3C52D3A90E4759490A57AF776DEAFE65")

    DocumentImpl document;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.162 -0500", hash_original_method = "A803585FEFBC6246911A956CA607D5CA", hash_generated_method = "A803585FEFBC6246911A956CA607D5CA")
    
NodeImpl(DocumentImpl document) {
        this.document = document;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.164 -0500", hash_original_method = "2014C4DBC7F925271C7D07A1BBA7C167", hash_generated_method = "76D81537092E5F70C95EB74154A31BE7")
    
public Node appendChild(Node newChild) throws DOMException {
        throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.166 -0500", hash_original_method = "917775F899DEE58C265631FD33F793ED", hash_generated_method = "0E78FE35EBC68E83DB825ED6330BF37D")
    
public final Node cloneNode(boolean deep) {
        return document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.169 -0500", hash_original_method = "E2D79625FBECAF1E43447A0BEFC228B9", hash_generated_method = "F93927BCF29AB4CCA8EFBF832137603C")
    
public NamedNodeMap getAttributes() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.171 -0500", hash_original_method = "1F381BCE8228355FEE86D697E02DDE0B", hash_generated_method = "1ED27F314E2126FC1BB2F8C1F787096F")
    
public NodeList getChildNodes() {
        return EMPTY_LIST;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.173 -0500", hash_original_method = "DB31E0DD76C8C1947AB843730A5D8205", hash_generated_method = "A2835D1CD8E281CA60B54343298C349E")
    
public Node getFirstChild() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.175 -0500", hash_original_method = "6070A4A9C5DDD0223B459D45F6FD5CBB", hash_generated_method = "0393C378A39C4B1B35CDED5A945D8F64")
    
public Node getLastChild() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.177 -0500", hash_original_method = "DEB04882A70946FEC78DD7AD3ABDE01B", hash_generated_method = "72B2C09EF2527400688B3ECA412FC84B")
    
public String getLocalName() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.179 -0500", hash_original_method = "4D95F58ABD4076A5B25FED87E28A6FD8", hash_generated_method = "3200B922BB7D869E3E3D1561EF351142")
    
public String getNamespaceURI() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.182 -0500", hash_original_method = "D23B45CE7514A5E8C576F43815BA5C75", hash_generated_method = "2163D07AD240EE8FB15A46AC29230C59")
    
public Node getNextSibling() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.184 -0500", hash_original_method = "FDA68CAC7DBE692AD654EACCAEB8ADF4", hash_generated_method = "15BE672E670A14A468C529C3FF846AB0")
    
public String getNodeName() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.186 -0500", hash_original_method = "16B19D352521D775272307977AC58B41", hash_generated_method = "B8D2BA8533F0EF1FEBDD64D3DE6A1755")
    
public abstract short getNodeType();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.188 -0500", hash_original_method = "5D533F6B29FA017DED37EB54506CEFCE", hash_generated_method = "09F08BD2031C8DC15E6ABA4C033F8BE8")
    
public String getNodeValue() throws DOMException {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.190 -0500", hash_original_method = "683FB3B36E3C0C255B09CB1FE69555EA", hash_generated_method = "A5914BB150184644977FBF3D8F2A20FB")
    
public final Document getOwnerDocument() {
        return document == this ? null : document;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.192 -0500", hash_original_method = "2F661FBCA438408BEACED1A87A3CFAEE", hash_generated_method = "CBB5D0875BD6BBE90B07A3C3E00D40AF")
    
public Node getParentNode() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.194 -0500", hash_original_method = "727413C23E49E727D2327332BBC1F81A", hash_generated_method = "733EB16CF618211DCD50AC4465EBF684")
    
public String getPrefix() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.197 -0500", hash_original_method = "70F44FC98E437F8103C8C034DB4ECB33", hash_generated_method = "F5362F7A7F598714FCDCEBB489892969")
    
public Node getPreviousSibling() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.199 -0500", hash_original_method = "B7795536C66ABB4718F9ED686281788D", hash_generated_method = "43F52F5A6BE539160D4154314C0CFAF6")
    
public boolean hasAttributes() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.201 -0500", hash_original_method = "75BC1F0CD3DD7ADF1C7C374A2270CAC3", hash_generated_method = "699709FBF6E20EE0869D5AD4793F8385")
    
public boolean hasChildNodes() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.203 -0500", hash_original_method = "02900D7407B8981D4618C0943B784132", hash_generated_method = "B072803C8F8D4352614359BD33471F1D")
    
public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.206 -0500", hash_original_method = "83D2E21D1EF19CE5C027A4D56C9BBECC", hash_generated_method = "7847333289A7D5EA4C23B6CDBD56E2FB")
    
public boolean isSupported(String feature, String version) {
        return DOMImplementationImpl.getInstance().hasFeature(feature, version);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.208 -0500", hash_original_method = "6E21C006D39E2D7D2AB395E9723D1D3D", hash_generated_method = "4C12ED80C73EE5DB68A5BC4B46F899FB")
    
public void normalize() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.210 -0500", hash_original_method = "C0BCC4253F844D2665FCB84131264ACF", hash_generated_method = "0DD3B73283802C91454FFA05D6344E71")
    
public Node removeChild(Node oldChild) throws DOMException {
        throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.212 -0500", hash_original_method = "3CB9ABDC605D3811167E9E73D3AF8E67", hash_generated_method = "A1A571E4A7FEFD2F35F1569CA1E40869")
    
public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.216 -0500", hash_original_method = "DD460B5BCEAE1CB09CE08B91E621DF7E", hash_generated_method = "F6F04EBC749ACC85C9CF4AD58B8585EC")
    
public final void setNodeValue(String nodeValue) throws DOMException {
        switch (getNodeType()) {
            case CDATA_SECTION_NODE:
            case COMMENT_NODE:
            case TEXT_NODE:
                ((CharacterData) this).setData(nodeValue);
                return;

            case PROCESSING_INSTRUCTION_NODE:
                ((ProcessingInstruction) this).setData(nodeValue);
                return;

            case ATTRIBUTE_NODE:
                ((Attr) this).setValue(nodeValue);
                return;

            case ELEMENT_NODE:
            case ENTITY_REFERENCE_NODE:
            case ENTITY_NODE:
            case DOCUMENT_NODE:
            case DOCUMENT_TYPE_NODE:
            case DOCUMENT_FRAGMENT_NODE:
            case NOTATION_NODE:
                return; // do nothing!

            default:
                throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.218 -0500", hash_original_method = "534A727E4FDB6CDBB5DC8BBEFB80CC50", hash_generated_method = "72AD63D8257DD9AB99E10151EF5554C8")
    
public void setPrefix(String prefix) throws DOMException {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.664 -0400", hash_original_method = "DD28C7A733028F46F0F8ECAE2D47C2BC", hash_generated_method = "D5F1AA75A751F62DFBA88F7DF6AFE239")
    public final String getBaseURI() {
switch(getNodeType()){
        case DOCUMENT_NODE:
String var8C6C2AA139A5D5DCA0571B7FCE33A53A_1732703926 =         sanitizeUri(((Document) this).getDocumentURI());
        var8C6C2AA139A5D5DCA0571B7FCE33A53A_1732703926.addTaint(taint);
        return var8C6C2AA139A5D5DCA0571B7FCE33A53A_1732703926;
        case ELEMENT_NODE:
        Element element = (Element) this;
        String uri = element.getAttributeNS(
                        "http://www.w3.org/XML/1998/namespace", "base");
        try 
        {
            if(uri == null || uri.isEmpty())            
            {
String varDFCB5250C05033781B180FAD67727786_468916797 =                 getParentBaseUri();
                varDFCB5250C05033781B180FAD67727786_468916797.addTaint(taint);
                return varDFCB5250C05033781B180FAD67727786_468916797;
            } //End block
            if(new URI(uri).isAbsolute())            
            {
String varD12B663A5EB2F9B068EED08B4C05ECCC_458863998 =                 uri;
                varD12B663A5EB2F9B068EED08B4C05ECCC_458863998.addTaint(taint);
                return varD12B663A5EB2F9B068EED08B4C05ECCC_458863998;
            } //End block
            String parentUri = getParentBaseUri();
            if(parentUri == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1005867126 =                 null;
                var540C13E9E156B687226421B24F2DF178_1005867126.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1005867126;
            } //End block
String varC92DD9F13100E39CEEEBFB08A9BFC0CA_2026618984 =             new URI(parentUri).resolve(uri).toString();
            varC92DD9F13100E39CEEEBFB08A9BFC0CA_2026618984.addTaint(taint);
            return varC92DD9F13100E39CEEEBFB08A9BFC0CA_2026618984;
        } //End block
        catch (URISyntaxException e)
        {
String var540C13E9E156B687226421B24F2DF178_1745342977 =             null;
            var540C13E9E156B687226421B24F2DF178_1745342977.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1745342977;
        } //End block
        case PROCESSING_INSTRUCTION_NODE:
String varDFCB5250C05033781B180FAD67727786_988215234 =         getParentBaseUri();
        varDFCB5250C05033781B180FAD67727786_988215234.addTaint(taint);
        return varDFCB5250C05033781B180FAD67727786_988215234;
        case NOTATION_NODE:
        case ENTITY_NODE:
String var540C13E9E156B687226421B24F2DF178_571533574 =         null;
        var540C13E9E156B687226421B24F2DF178_571533574.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_571533574;
        case ENTITY_REFERENCE_NODE:
String var540C13E9E156B687226421B24F2DF178_1132718753 =         null;
        var540C13E9E156B687226421B24F2DF178_1132718753.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1132718753;
        case DOCUMENT_TYPE_NODE:
        case DOCUMENT_FRAGMENT_NODE:
        case ATTRIBUTE_NODE:
        case TEXT_NODE:
        case CDATA_SECTION_NODE:
        case COMMENT_NODE:
String var540C13E9E156B687226421B24F2DF178_2093286424 =         null;
        var540C13E9E156B687226421B24F2DF178_2093286424.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2093286424;
        default:
        DOMException var27285F41C0EC27EB44BA0E5E07EE31A9_1477196775 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        var27285F41C0EC27EB44BA0E5E07EE31A9_1477196775.addTaint(taint);
        throw var27285F41C0EC27EB44BA0E5E07EE31A9_1477196775;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.231 -0500", hash_original_method = "DFD855C107B39D74015E43DCF13ECA5E", hash_generated_method = "70495698BE58AB35C3ADE99D972A45B4")
    
private String getParentBaseUri() {
        Node parentNode = getParentNode();
        return parentNode != null ? parentNode.getBaseURI() : null;
    }

    /**
     * Returns the sanitized input if it is a URI, or {@code null} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.233 -0500", hash_original_method = "1D824B9402137DBC708C242BAEC27F82", hash_generated_method = "C952930FCE91E68AA5A642F8179D45E5")
    
private String sanitizeUri(String uri) {
        if (uri == null || uri.length() == 0) {
            return null;
        }
        try {
            return new URI(uri).toString();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.235 -0500", hash_original_method = "1DDF123F9002EFB3DC60D7666C901199", hash_generated_method = "81B18A1B51B4AE8A820A0E3B60679038")
    
public short compareDocumentPosition(Node other)
            throws DOMException {
        throw new UnsupportedOperationException(); // TODO
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.237 -0500", hash_original_method = "67AC02ADFBE93754C1AB8AE0D37378EE", hash_generated_method = "70FFC50792BB2E94BA92027FF912E313")
    
public String getTextContent() throws DOMException {
        return getNodeValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.239 -0500", hash_original_method = "6ADB0BF10CD256A5C763161A1385CD79", hash_generated_method = "6ADB0BF10CD256A5C763161A1385CD79")
    
void getTextContent(StringBuilder buf) throws DOMException {
        String content = getNodeValue();
        if (content != null) {
            buf.append(content);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.243 -0500", hash_original_method = "B267D49587C3D1DB842740F077498528", hash_generated_method = "2A4DF2AEBDA5F75AFB0FB707C6C12713")
    
public final void setTextContent(String textContent) throws DOMException {
        switch (getNodeType()) {
            case DOCUMENT_TYPE_NODE:
            case DOCUMENT_NODE:
                return; // do nothing!

            case ELEMENT_NODE:
            case ENTITY_NODE:
            case ENTITY_REFERENCE_NODE:
            case DOCUMENT_FRAGMENT_NODE:
                // remove all existing children
                Node child;
                while ((child = getFirstChild()) != null) {
                    removeChild(child);
                }
                // create a text node to hold the given content
                if (textContent != null && textContent.length() != 0) {
                    appendChild(document.createTextNode(textContent));
                }
                return;

            case ATTRIBUTE_NODE:
            case TEXT_NODE:
            case CDATA_SECTION_NODE:
            case PROCESSING_INSTRUCTION_NODE:
            case COMMENT_NODE:
            case NOTATION_NODE:
                setNodeValue(textContent);
                return;

            default:
                throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.245 -0500", hash_original_method = "CDCF2BEBCB3DF8B0191B82144C39E4E3", hash_generated_method = "E824669ABF4C851956D19FFED888CAA5")
    
public boolean isSameNode(Node other) {
        return this == other;
    }

    /**
     * Returns the element whose namespace definitions apply to this node. Use
     * this element when mapping prefixes to URIs and vice versa.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.247 -0500", hash_original_method = "DDD4A4E09BB31E4B92DF0753DE457415", hash_generated_method = "E5D08FEEF5044B534CF8CEA79BDC3E0C")
    
private NodeImpl getNamespacingElement() {
        switch (this.getNodeType()) {
            case ELEMENT_NODE:
                return this;

            case DOCUMENT_NODE:
                return (NodeImpl) ((Document) this).getDocumentElement();

            case ENTITY_NODE:
            case NOTATION_NODE:
            case DOCUMENT_FRAGMENT_NODE:
            case DOCUMENT_TYPE_NODE:
                return null;

            case ATTRIBUTE_NODE:
                return (NodeImpl) ((Attr) this).getOwnerElement();

            case TEXT_NODE:
            case CDATA_SECTION_NODE:
            case ENTITY_REFERENCE_NODE:
            case PROCESSING_INSTRUCTION_NODE:
            case COMMENT_NODE:
                return getContainingElement();

            default:
                throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        }
    }

    /**
     * Returns the nearest ancestor element that contains this node.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.249 -0500", hash_original_method = "E4B9E13482B5AB13521831694CDD3F31", hash_generated_method = "3BE440C3722A8E0923D8EC35D57A079C")
    
private NodeImpl getContainingElement() {
        for (Node p = getParentNode(); p != null; p = p.getParentNode()) {
            if (p.getNodeType() == ELEMENT_NODE) {
                return (NodeImpl) p;
            }
        }
        return null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.668 -0400", hash_original_method = "7FA28D24E20CD6244334CF1DE396DB62", hash_generated_method = "60503655F2339FC121D79DD201DAD826")
    public final String lookupPrefix(String namespaceURI) {
        addTaint(namespaceURI.getTaint());
        if(namespaceURI == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1108095504 =             null;
            var540C13E9E156B687226421B24F2DF178_1108095504.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1108095504;
        } //End block
        NodeImpl target = getNamespacingElement();
for(NodeImpl node = target;node != null;node = node.getContainingElement())
        {
            if(namespaceURI.equals(node.getNamespaceURI())
                    && target.isPrefixMappedToUri(node.getPrefix(), namespaceURI))            
            {
String varCA967D60876AC29383C8BF3C2697EA21_488989808 =                 node.getPrefix();
                varCA967D60876AC29383C8BF3C2697EA21_488989808.addTaint(taint);
                return varCA967D60876AC29383C8BF3C2697EA21_488989808;
            } //End block
            if(!node.hasAttributes())            
            {
                continue;
            } //End block
            NamedNodeMap attributes = node.getAttributes();
for(int i = 0, length = attributes.getLength();i < length;i++)
            {
                Node attr = attributes.item(i);
                if(!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())
                        || !"xmlns".equals(attr.getPrefix())
                        || !namespaceURI.equals(attr.getNodeValue()))                
                {
                    continue;
                } //End block
                if(target.isPrefixMappedToUri(attr.getLocalName(), namespaceURI))                
                {
String varBFF13D60192C772654AA3A036B78200E_1291873055 =                     attr.getLocalName();
                    varBFF13D60192C772654AA3A036B78200E_1291873055.addTaint(taint);
                    return varBFF13D60192C772654AA3A036B78200E_1291873055;
                } //End block
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_259019385 =         null;
        var540C13E9E156B687226421B24F2DF178_259019385.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_259019385;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Returns true if the given prefix is mapped to the given URI on this
     * element. Since child elements can redefine prefixes, this check is
     * necessary: {@code
     * <foo xmlns:a="http://good">
     *   <bar xmlns:a="http://evil">
     *     <a:baz />
     *   </bar>
     * </foo>}
     *
     * @param prefix the prefix to find. Nullable.
     * @param uri the URI to match. Non-null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.256 -0500", hash_original_method = "AA07F6405A8EB7821F818F6C760FCB2D", hash_generated_method = "AA07F6405A8EB7821F818F6C760FCB2D")
    
boolean isPrefixMappedToUri(String prefix, String uri) {
        if (prefix == null) {
            return false;
        }

        String actual = lookupNamespaceURI(prefix);
        return uri.equals(actual);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.258 -0500", hash_original_method = "408B99A289EC0349924637E46549BA26", hash_generated_method = "A0ED909DB763D30FA5061EC60A5D146B")
    
public final boolean isDefaultNamespace(String namespaceURI) {
        String actual = lookupNamespaceURI(null); // null yields the default namespace
        return namespaceURI == null
                ? actual == null
                : namespaceURI.equals(actual);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.669 -0400", hash_original_method = "4BD06F1D22ADF3EA57842F923303423E", hash_generated_method = "3A8219EC4D8C25D4EF07DEE01CDFB7AB")
    public final String lookupNamespaceURI(String prefix) {
        addTaint(prefix.getTaint());
        NodeImpl target = getNamespacingElement();
for(NodeImpl node = target;node != null;node = node.getContainingElement())
        {
            String nodePrefix = node.getPrefix();
            if(node.getNamespaceURI() != null)            
            {
                if(prefix == null 
                        ? nodePrefix == null
                        : prefix.equals(nodePrefix))                
                {
String var635A0C92002BCF6ED74FC0417E9137AE_660993192 =                     node.getNamespaceURI();
                    var635A0C92002BCF6ED74FC0417E9137AE_660993192.addTaint(taint);
                    return var635A0C92002BCF6ED74FC0417E9137AE_660993192;
                } //End block
            } //End block
            if(!node.hasAttributes())            
            {
                continue;
            } //End block
            NamedNodeMap attributes = node.getAttributes();
for(int i = 0, length = attributes.getLength();i < length;i++)
            {
                Node attr = attributes.item(i);
                if(!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI()))                
                {
                    continue;
                } //End block
                if(prefix == null 
                        ? "xmlns".equals(attr.getNodeName())
                        : "xmlns".equals(attr.getPrefix()) && prefix.equals(attr.getLocalName()))                
                {
                    String value = attr.getNodeValue();
String var933979A65FDA98D9635B5350FC86EE83_656744143 =                     value.length() > 0 ? value : null;
                    var933979A65FDA98D9635B5350FC86EE83_656744143.addTaint(taint);
                    return var933979A65FDA98D9635B5350FC86EE83_656744143;
                } //End block
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_551338838 =         null;
        var540C13E9E156B687226421B24F2DF178_551338838.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_551338838;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.268 -0500", hash_original_method = "5ACD5A1048128B414FC469A4162D7D49", hash_generated_method = "30929F434D466B34C7F18EE2CE7C26B5")
    
public final boolean isEqualNode(Node arg) {
        if (arg == this) {
            return true;
        }

        List<Object> listA = createEqualityKey(this);
        List<Object> listB = createEqualityKey(arg);

        if (listA.size() != listB.size()) {
            return false;
        }

        for (int i = 0; i < listA.size(); i++) {
            Object a = listA.get(i);
            Object b = listB.get(i);

            if (a == b) {
                continue;

            } else if (a == null || b == null) {
                return false;

            } else if (a instanceof String || a instanceof Short) {
                if (!a.equals(b)) {
                    return false;
                }

            } else if (a instanceof NamedNodeMap) {
                if (!(b instanceof NamedNodeMap)
                        || !namedNodeMapsEqual((NamedNodeMap) a, (NamedNodeMap) b)) {
                    return false;
                }

            } else if (a instanceof Node) {
                if (!(b instanceof Node)
                        || !((Node) a).isEqualNode((Node) b)) {
                    return false;
                }

            } else {
                throw new AssertionError(); // unexpected type
            }
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.271 -0500", hash_original_method = "C9854B9EF2C5621F4F378B8106F34125", hash_generated_method = "E50386A0818B7CDDEA4B1940F4C9C3B6")
    
private boolean namedNodeMapsEqual(NamedNodeMap a, NamedNodeMap b) {
        if (a.getLength() != b.getLength()) {
            return false;
        }
        for (int i = 0; i < a.getLength(); i++) {
            Node aNode = a.item(i);
            Node bNode = aNode.getLocalName() == null
                    ? b.getNamedItem(aNode.getNodeName())
                    : b.getNamedItemNS(aNode.getNamespaceURI(), aNode.getLocalName());
            if (bNode == null || !aNode.isEqualNode(bNode)) {
                return false;
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.273 -0500", hash_original_method = "654AD0B7653E61CCCCF2A287DD7A9FCF", hash_generated_method = "F21C3E203E1643D3A53B867FA5DC5478")
    
public final Object getFeature(String feature, String version) {
        return isSupported(feature, version) ? this : null;
    }
    
    static class UserData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.280 -0500", hash_original_field = "01495BEB834F5098BB0B06183674C819", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

         Object value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.283 -0500", hash_original_field = "827CB1F78A0BBD2016258DC26E1ED2F5", hash_generated_field = "827CB1F78A0BBD2016258DC26E1ED2F5")

         UserDataHandler handler;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.286 -0500", hash_original_method = "0B6C19B4FFBA791689124EA47788F25F", hash_generated_method = "0B6C19B4FFBA791689124EA47788F25F")
        
UserData(Object value, UserDataHandler handler) {
            this.value = value;
            this.handler = handler;
        }
        
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.275 -0500", hash_original_method = "9F34FDEA3DB7CC58B5A8B86C5F6353A5", hash_generated_method = "A0D2DF0527CEACAD6243FA01D61FF7BE")
    
public final Object setUserData(String key, Object data, UserDataHandler handler) {
        if (key == null) {
            throw new NullPointerException();
        }
        Map<String, UserData> map = document.getUserDataMap(this);
        UserData previous = data == null
                ? map.remove(key)
                : map.put(key, new UserData(data, handler));
        return previous != null ? previous.value : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:20.278 -0500", hash_original_method = "B29B782E95D64D942AA9D9D3C7EEF744", hash_generated_method = "7129FCAB54DD956423A4E6410148D2D8")
    
public final Object getUserData(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        Map<String, UserData> map = document.getUserDataMapForRead(this);
        UserData userData = map.get(key);
        return userData != null ? userData.value : null;
    }
}

