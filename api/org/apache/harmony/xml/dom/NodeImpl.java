package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.907 -0400", hash_original_field = "FDC3BDEFB79CEC8EB8211D2499E04704", hash_generated_field = "3C52D3A90E4759490A57AF776DEAFE65")

    DocumentImpl document;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.907 -0400", hash_original_method = "A803585FEFBC6246911A956CA607D5CA", hash_generated_method = "9F50EA75A2AED9D57A4F24B1458FBC54")
      NodeImpl(DocumentImpl document) {
        this.document = document;
        // ---------- Original Method ----------
        //this.document = document;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.908 -0400", hash_original_method = "2014C4DBC7F925271C7D07A1BBA7C167", hash_generated_method = "1AAC607A213868555930488553E7FB6A")
    public Node appendChild(Node newChild) throws DOMException {
        addTaint(newChild.getTaint());
        DOMException varB08FA5F9049CD84DC42B7238D3D303A7_217708046 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        varB08FA5F9049CD84DC42B7238D3D303A7_217708046.addTaint(taint);
        throw varB08FA5F9049CD84DC42B7238D3D303A7_217708046;
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.908 -0400", hash_original_method = "917775F899DEE58C265631FD33F793ED", hash_generated_method = "1132ED1B0E3A18B2DB0A8E8F42CD60A4")
    public final Node cloneNode(boolean deep) {
        addTaint(deep);
Node var04421AF73B134EC262B05FD2063BE675_1490019355 =         document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
        var04421AF73B134EC262B05FD2063BE675_1490019355.addTaint(taint);
        return var04421AF73B134EC262B05FD2063BE675_1490019355;
        // ---------- Original Method ----------
        //return document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.908 -0400", hash_original_method = "E2D79625FBECAF1E43447A0BEFC228B9", hash_generated_method = "1DF95FE702AD0C2788282E89BACFC3A4")
    public NamedNodeMap getAttributes() {
NamedNodeMap var540C13E9E156B687226421B24F2DF178_1199673869 =         null;
        var540C13E9E156B687226421B24F2DF178_1199673869.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1199673869;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.909 -0400", hash_original_method = "1F381BCE8228355FEE86D697E02DDE0B", hash_generated_method = "679135F5F481434F93D07E3CE4B3807E")
    public NodeList getChildNodes() {
NodeList var3EB787547078B98C6DA0C5CC8DE617C5_1991701219 =         EMPTY_LIST;
        var3EB787547078B98C6DA0C5CC8DE617C5_1991701219.addTaint(taint);
        return var3EB787547078B98C6DA0C5CC8DE617C5_1991701219;
        // ---------- Original Method ----------
        //return EMPTY_LIST;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.909 -0400", hash_original_method = "DB31E0DD76C8C1947AB843730A5D8205", hash_generated_method = "2FC877E310B02DBC7D493C058A738FB6")
    public Node getFirstChild() {
Node var540C13E9E156B687226421B24F2DF178_404572476 =         null;
        var540C13E9E156B687226421B24F2DF178_404572476.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_404572476;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.909 -0400", hash_original_method = "6070A4A9C5DDD0223B459D45F6FD5CBB", hash_generated_method = "8B6A7CABB2C134EC403EBD5A51AD6654")
    public Node getLastChild() {
Node var540C13E9E156B687226421B24F2DF178_233173598 =         null;
        var540C13E9E156B687226421B24F2DF178_233173598.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_233173598;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.910 -0400", hash_original_method = "DEB04882A70946FEC78DD7AD3ABDE01B", hash_generated_method = "C22C25E4A827337F9D32B78AC188BCDF")
    public String getLocalName() {
String var540C13E9E156B687226421B24F2DF178_127657537 =         null;
        var540C13E9E156B687226421B24F2DF178_127657537.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_127657537;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.910 -0400", hash_original_method = "4D95F58ABD4076A5B25FED87E28A6FD8", hash_generated_method = "4F1A8C51DCA420F879FF94FBD14F2F3B")
    public String getNamespaceURI() {
String var540C13E9E156B687226421B24F2DF178_1088551392 =         null;
        var540C13E9E156B687226421B24F2DF178_1088551392.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1088551392;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.911 -0400", hash_original_method = "D23B45CE7514A5E8C576F43815BA5C75", hash_generated_method = "AE580892C6D47393E1C952F993BA9E5C")
    public Node getNextSibling() {
Node var540C13E9E156B687226421B24F2DF178_323817441 =         null;
        var540C13E9E156B687226421B24F2DF178_323817441.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_323817441;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.911 -0400", hash_original_method = "FDA68CAC7DBE692AD654EACCAEB8ADF4", hash_generated_method = "9F6491B52D3FE1C72F2CA7E683A29B53")
    public String getNodeName() {
String var540C13E9E156B687226421B24F2DF178_168399330 =         null;
        var540C13E9E156B687226421B24F2DF178_168399330.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_168399330;
        // ---------- Original Method ----------
        //return null;
    }

    
    public abstract short getNodeType();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.912 -0400", hash_original_method = "5D533F6B29FA017DED37EB54506CEFCE", hash_generated_method = "229F122FC47667268C6F74FA040D1FB1")
    public String getNodeValue() throws DOMException {
String var540C13E9E156B687226421B24F2DF178_566073849 =         null;
        var540C13E9E156B687226421B24F2DF178_566073849.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_566073849;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.912 -0400", hash_original_method = "683FB3B36E3C0C255B09CB1FE69555EA", hash_generated_method = "AD9FA9393756BC498E49F09632F698E3")
    public final Document getOwnerDocument() {
Document var8A49EDE76E6856D243C546DB784C50EC_1767911814 =         document == this ? null : document;
        var8A49EDE76E6856D243C546DB784C50EC_1767911814.addTaint(taint);
        return var8A49EDE76E6856D243C546DB784C50EC_1767911814;
        // ---------- Original Method ----------
        //return document == this ? null : document;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.913 -0400", hash_original_method = "2F661FBCA438408BEACED1A87A3CFAEE", hash_generated_method = "6A19A0A51E4BF35CBBA5E63DF0433359")
    public Node getParentNode() {
Node var540C13E9E156B687226421B24F2DF178_1523835501 =         null;
        var540C13E9E156B687226421B24F2DF178_1523835501.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1523835501;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.913 -0400", hash_original_method = "727413C23E49E727D2327332BBC1F81A", hash_generated_method = "E0904129E0B701998027B8FAB7294215")
    public String getPrefix() {
String var540C13E9E156B687226421B24F2DF178_1083709204 =         null;
        var540C13E9E156B687226421B24F2DF178_1083709204.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1083709204;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.914 -0400", hash_original_method = "70F44FC98E437F8103C8C034DB4ECB33", hash_generated_method = "0DDFB3055ED30E353182BBEC89B06C8D")
    public Node getPreviousSibling() {
Node var540C13E9E156B687226421B24F2DF178_850895892 =         null;
        var540C13E9E156B687226421B24F2DF178_850895892.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_850895892;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.914 -0400", hash_original_method = "B7795536C66ABB4718F9ED686281788D", hash_generated_method = "6469C6CFB6D0FD0A5C3F712C4002D7C5")
    public boolean hasAttributes() {
        boolean var68934A3E9455FA72420237EB05902327_1966388166 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1057266776 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1057266776;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.914 -0400", hash_original_method = "75BC1F0CD3DD7ADF1C7C374A2270CAC3", hash_generated_method = "0AF5D34511BFF1E0589C1E137EE44F92")
    public boolean hasChildNodes() {
        boolean var68934A3E9455FA72420237EB05902327_349197934 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_637730941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_637730941;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.915 -0400", hash_original_method = "02900D7407B8981D4618C0943B784132", hash_generated_method = "49C57727650C34094B5B8ACD9A4CA872")
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        addTaint(refChild.getTaint());
        addTaint(newChild.getTaint());
        DOMException varB08FA5F9049CD84DC42B7238D3D303A7_76658988 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        varB08FA5F9049CD84DC42B7238D3D303A7_76658988.addTaint(taint);
        throw varB08FA5F9049CD84DC42B7238D3D303A7_76658988;
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.915 -0400", hash_original_method = "83D2E21D1EF19CE5C027A4D56C9BBECC", hash_generated_method = "739F07BE2464A98FF5444116F1AB2C53")
    public boolean isSupported(String feature, String version) {
        addTaint(version.getTaint());
        addTaint(feature.getTaint());
        boolean varA7FDD0EF468A82511F267BB626337ADB_59760066 = (DOMImplementationImpl.getInstance().hasFeature(feature, version));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308750116 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308750116;
        // ---------- Original Method ----------
        //return DOMImplementationImpl.getInstance().hasFeature(feature, version);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.916 -0400", hash_original_method = "6E21C006D39E2D7D2AB395E9723D1D3D", hash_generated_method = "AAB79EA75709AFAC418FB3A2AD6C8459")
    public void normalize() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.916 -0400", hash_original_method = "C0BCC4253F844D2665FCB84131264ACF", hash_generated_method = "E1CAF61A74575DAF2EFB9E2705172711")
    public Node removeChild(Node oldChild) throws DOMException {
        addTaint(oldChild.getTaint());
        DOMException varB08FA5F9049CD84DC42B7238D3D303A7_1663903085 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        varB08FA5F9049CD84DC42B7238D3D303A7_1663903085.addTaint(taint);
        throw varB08FA5F9049CD84DC42B7238D3D303A7_1663903085;
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.916 -0400", hash_original_method = "3CB9ABDC605D3811167E9E73D3AF8E67", hash_generated_method = "C303B01634A99BA1D9D4219C7A3F8404")
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        addTaint(oldChild.getTaint());
        addTaint(newChild.getTaint());
        DOMException varB08FA5F9049CD84DC42B7238D3D303A7_1151671109 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        varB08FA5F9049CD84DC42B7238D3D303A7_1151671109.addTaint(taint);
        throw varB08FA5F9049CD84DC42B7238D3D303A7_1151671109;
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.917 -0400", hash_original_method = "DD460B5BCEAE1CB09CE08B91E621DF7E", hash_generated_method = "4EBAF2D4A663D9A6ACC293D430178615")
    public final void setNodeValue(String nodeValue) throws DOMException {
        addTaint(nodeValue.getTaint());
switch(getNodeType()){
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
        return;
        default:
        DOMException var27285F41C0EC27EB44BA0E5E07EE31A9_742624893 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        var27285F41C0EC27EB44BA0E5E07EE31A9_742624893.addTaint(taint);
        throw var27285F41C0EC27EB44BA0E5E07EE31A9_742624893;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.917 -0400", hash_original_method = "534A727E4FDB6CDBB5DC8BBEFB80CC50", hash_generated_method = "6394A903E9072527732E970BA56A5453")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.919 -0400", hash_original_method = "DD28C7A733028F46F0F8ECAE2D47C2BC", hash_generated_method = "DA42DEB18FC4096BAF935F9A190B5D80")
    public final String getBaseURI() {
switch(getNodeType()){
        case DOCUMENT_NODE:
String var8C6C2AA139A5D5DCA0571B7FCE33A53A_2081762519 =         sanitizeUri(((Document) this).getDocumentURI());
        var8C6C2AA139A5D5DCA0571B7FCE33A53A_2081762519.addTaint(taint);
        return var8C6C2AA139A5D5DCA0571B7FCE33A53A_2081762519;
        case ELEMENT_NODE:
        Element element = (Element) this;
        String uri = element.getAttributeNS(
                        "http://www.w3.org/XML/1998/namespace", "base");
        try 
        {
    if(uri == null || uri.isEmpty())            
            {
String varDFCB5250C05033781B180FAD67727786_975944136 =                 getParentBaseUri();
                varDFCB5250C05033781B180FAD67727786_975944136.addTaint(taint);
                return varDFCB5250C05033781B180FAD67727786_975944136;
            } //End block
    if(new URI(uri).isAbsolute())            
            {
String varD12B663A5EB2F9B068EED08B4C05ECCC_1947103527 =                 uri;
                varD12B663A5EB2F9B068EED08B4C05ECCC_1947103527.addTaint(taint);
                return varD12B663A5EB2F9B068EED08B4C05ECCC_1947103527;
            } //End block
            String parentUri = getParentBaseUri();
    if(parentUri == null)            
            {
String var540C13E9E156B687226421B24F2DF178_1343158180 =                 null;
                var540C13E9E156B687226421B24F2DF178_1343158180.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1343158180;
            } //End block
String varC92DD9F13100E39CEEEBFB08A9BFC0CA_537296053 =             new URI(parentUri).resolve(uri).toString();
            varC92DD9F13100E39CEEEBFB08A9BFC0CA_537296053.addTaint(taint);
            return varC92DD9F13100E39CEEEBFB08A9BFC0CA_537296053;
        } //End block
        catch (URISyntaxException e)
        {
String var540C13E9E156B687226421B24F2DF178_2050736372 =             null;
            var540C13E9E156B687226421B24F2DF178_2050736372.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2050736372;
        } //End block
        case PROCESSING_INSTRUCTION_NODE:
String varDFCB5250C05033781B180FAD67727786_1185006150 =         getParentBaseUri();
        varDFCB5250C05033781B180FAD67727786_1185006150.addTaint(taint);
        return varDFCB5250C05033781B180FAD67727786_1185006150;
        case NOTATION_NODE:
        case ENTITY_NODE:
String var540C13E9E156B687226421B24F2DF178_1533589058 =         null;
        var540C13E9E156B687226421B24F2DF178_1533589058.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1533589058;
        case ENTITY_REFERENCE_NODE:
String var540C13E9E156B687226421B24F2DF178_1094777181 =         null;
        var540C13E9E156B687226421B24F2DF178_1094777181.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1094777181;
        case DOCUMENT_TYPE_NODE:
        case DOCUMENT_FRAGMENT_NODE:
        case ATTRIBUTE_NODE:
        case TEXT_NODE:
        case CDATA_SECTION_NODE:
        case COMMENT_NODE:
String var540C13E9E156B687226421B24F2DF178_1809667097 =         null;
        var540C13E9E156B687226421B24F2DF178_1809667097.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1809667097;
        default:
        DOMException var27285F41C0EC27EB44BA0E5E07EE31A9_36320437 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        var27285F41C0EC27EB44BA0E5E07EE31A9_36320437.addTaint(taint);
        throw var27285F41C0EC27EB44BA0E5E07EE31A9_36320437;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.919 -0400", hash_original_method = "DFD855C107B39D74015E43DCF13ECA5E", hash_generated_method = "3173A7C6E00CA2A551040035E8BB4A61")
    private String getParentBaseUri() {
        Node parentNode = getParentNode();
String var9F008E4670FF2B5D32F29108A858BFF8_1676128504 =         parentNode != null ? parentNode.getBaseURI() : null;
        var9F008E4670FF2B5D32F29108A858BFF8_1676128504.addTaint(taint);
        return var9F008E4670FF2B5D32F29108A858BFF8_1676128504;
        // ---------- Original Method ----------
        //Node parentNode = getParentNode();
        //return parentNode != null ? parentNode.getBaseURI() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.920 -0400", hash_original_method = "1D824B9402137DBC708C242BAEC27F82", hash_generated_method = "FB0E00A7855D3F91D7AFEDE1A0400E58")
    private String sanitizeUri(String uri) {
        addTaint(uri.getTaint());
    if(uri == null || uri.length() == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_547713331 =             null;
            var540C13E9E156B687226421B24F2DF178_547713331.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_547713331;
        } //End block
        try 
        {
String var0370934740A23317A971FB463A48421D_1007119447 =             new URI(uri).toString();
            var0370934740A23317A971FB463A48421D_1007119447.addTaint(taint);
            return var0370934740A23317A971FB463A48421D_1007119447;
        } //End block
        catch (URISyntaxException e)
        {
String var540C13E9E156B687226421B24F2DF178_1612418045 =             null;
            var540C13E9E156B687226421B24F2DF178_1612418045.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1612418045;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.920 -0400", hash_original_method = "1DDF123F9002EFB3DC60D7666C901199", hash_generated_method = "FFDBA392D59FA8EAE3916F68B613A60B")
    public short compareDocumentPosition(Node other) throws DOMException {
        addTaint(other.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_379506800 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_379506800.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_379506800;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.920 -0400", hash_original_method = "67AC02ADFBE93754C1AB8AE0D37378EE", hash_generated_method = "0C4B52BB8D2383D2AFD5C3FA73131E1B")
    public String getTextContent() throws DOMException {
String var7364FBEBC22E1599B041B125CD0C1F76_648778828 =         getNodeValue();
        var7364FBEBC22E1599B041B125CD0C1F76_648778828.addTaint(taint);
        return var7364FBEBC22E1599B041B125CD0C1F76_648778828;
        // ---------- Original Method ----------
        //return getNodeValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.921 -0400", hash_original_method = "6ADB0BF10CD256A5C763161A1385CD79", hash_generated_method = "83697DB6930881E839504C8200EC175F")
     void getTextContent(StringBuilder buf) throws DOMException {
        addTaint(buf.getTaint());
        String content = getNodeValue();
    if(content != null)        
        {
            buf.append(content);
        } //End block
        // ---------- Original Method ----------
        //String content = getNodeValue();
        //if (content != null) {
            //buf.append(content);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.921 -0400", hash_original_method = "B267D49587C3D1DB842740F077498528", hash_generated_method = "1DA1B06656C83E89B9873974CFE55F8D")
    public final void setTextContent(String textContent) throws DOMException {
        addTaint(textContent.getTaint());
switch(getNodeType()){
        case DOCUMENT_TYPE_NODE:
        case DOCUMENT_NODE:
        return;
        case ELEMENT_NODE:
        case ENTITY_NODE:
        case ENTITY_REFERENCE_NODE:
        case DOCUMENT_FRAGMENT_NODE:
        Node child;
        while
((child = getFirstChild()) != null)        
        {
            removeChild(child);
        } //End block
    if(textContent != null && textContent.length() != 0)        
        {
            appendChild(document.createTextNode(textContent));
        } //End block
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
        DOMException var27285F41C0EC27EB44BA0E5E07EE31A9_1686346210 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        var27285F41C0EC27EB44BA0E5E07EE31A9_1686346210.addTaint(taint);
        throw var27285F41C0EC27EB44BA0E5E07EE31A9_1686346210;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.921 -0400", hash_original_method = "CDCF2BEBCB3DF8B0191B82144C39E4E3", hash_generated_method = "DB8EADA6700842874BEFF22C22812CD4")
    public boolean isSameNode(Node other) {
        addTaint(other.getTaint());
        boolean varBE1F9AF96A88D9FBF24773A7F592CAA1_964434814 = (this == other);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887116985 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887116985;
        // ---------- Original Method ----------
        //return this == other;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.922 -0400", hash_original_method = "DDD4A4E09BB31E4B92DF0753DE457415", hash_generated_method = "75A716F8549C2BE49D32EC11CC4042F1")
    private NodeImpl getNamespacingElement() {
switch(this.getNodeType()){
        case ELEMENT_NODE:
NodeImpl var72A74007B2BE62B849F475C7BDA4658B_531688763 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_531688763.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_531688763;
        case DOCUMENT_NODE:
NodeImpl var9C44064DA096AF5EE1C299DE4B805A85_1625840808 =         (NodeImpl) ((Document) this).getDocumentElement();
        var9C44064DA096AF5EE1C299DE4B805A85_1625840808.addTaint(taint);
        return var9C44064DA096AF5EE1C299DE4B805A85_1625840808;
        case ENTITY_NODE:
        case NOTATION_NODE:
        case DOCUMENT_FRAGMENT_NODE:
        case DOCUMENT_TYPE_NODE:
NodeImpl var540C13E9E156B687226421B24F2DF178_644314227 =         null;
        var540C13E9E156B687226421B24F2DF178_644314227.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_644314227;
        case ATTRIBUTE_NODE:
NodeImpl var253799FEBA18F79910817934AFD00BEF_183595174 =         (NodeImpl) ((Attr) this).getOwnerElement();
        var253799FEBA18F79910817934AFD00BEF_183595174.addTaint(taint);
        return var253799FEBA18F79910817934AFD00BEF_183595174;
        case TEXT_NODE:
        case CDATA_SECTION_NODE:
        case ENTITY_REFERENCE_NODE:
        case PROCESSING_INSTRUCTION_NODE:
        case COMMENT_NODE:
NodeImpl var8BC235EA48173B3F91C3D3D2A4E83A35_1526888838 =         getContainingElement();
        var8BC235EA48173B3F91C3D3D2A4E83A35_1526888838.addTaint(taint);
        return var8BC235EA48173B3F91C3D3D2A4E83A35_1526888838;
        default:
        DOMException var27285F41C0EC27EB44BA0E5E07EE31A9_237275237 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        var27285F41C0EC27EB44BA0E5E07EE31A9_237275237.addTaint(taint);
        throw var27285F41C0EC27EB44BA0E5E07EE31A9_237275237;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.922 -0400", hash_original_method = "E4B9E13482B5AB13521831694CDD3F31", hash_generated_method = "465628102735C95ED3037FEE559E8999")
    private NodeImpl getContainingElement() {
for(Node p = getParentNode();p != null;p = p.getParentNode())
        {
    if(p.getNodeType() == ELEMENT_NODE)            
            {
NodeImpl varBEA0A08D3E1C9339930C51EE49C1BB6C_1000331229 =                 (NodeImpl) p;
                varBEA0A08D3E1C9339930C51EE49C1BB6C_1000331229.addTaint(taint);
                return varBEA0A08D3E1C9339930C51EE49C1BB6C_1000331229;
            } //End block
        } //End block
NodeImpl var540C13E9E156B687226421B24F2DF178_1511760899 =         null;
        var540C13E9E156B687226421B24F2DF178_1511760899.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1511760899;
        // ---------- Original Method ----------
        //for (Node p = getParentNode(); p != null; p = p.getParentNode()) {
            //if (p.getNodeType() == ELEMENT_NODE) {
                //return (NodeImpl) p;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.923 -0400", hash_original_method = "7FA28D24E20CD6244334CF1DE396DB62", hash_generated_method = "31FD4068EF6E1D61F5CD6F4D8C6EEA3A")
    public final String lookupPrefix(String namespaceURI) {
        addTaint(namespaceURI.getTaint());
    if(namespaceURI == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1132681972 =             null;
            var540C13E9E156B687226421B24F2DF178_1132681972.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1132681972;
        } //End block
        NodeImpl target = getNamespacingElement();
for(NodeImpl node = target;node != null;node = node.getContainingElement())
        {
    if(namespaceURI.equals(node.getNamespaceURI())
                    && target.isPrefixMappedToUri(node.getPrefix(), namespaceURI))            
            {
String varCA967D60876AC29383C8BF3C2697EA21_1046185278 =                 node.getPrefix();
                varCA967D60876AC29383C8BF3C2697EA21_1046185278.addTaint(taint);
                return varCA967D60876AC29383C8BF3C2697EA21_1046185278;
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
String varBFF13D60192C772654AA3A036B78200E_1837472326 =                     attr.getLocalName();
                    varBFF13D60192C772654AA3A036B78200E_1837472326.addTaint(taint);
                    return varBFF13D60192C772654AA3A036B78200E_1837472326;
                } //End block
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_2060407365 =         null;
        var540C13E9E156B687226421B24F2DF178_2060407365.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2060407365;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.924 -0400", hash_original_method = "AA07F6405A8EB7821F818F6C760FCB2D", hash_generated_method = "C922DA004020660D032FF1E99179569C")
     boolean isPrefixMappedToUri(String prefix, String uri) {
        addTaint(uri.getTaint());
        addTaint(prefix.getTaint());
    if(prefix == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_380610799 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_465302308 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_465302308;
        } //End block
        String actual = lookupNamespaceURI(prefix);
        boolean var5089C02DA3CB33691AF3AF6613290012_1442127973 = (uri.equals(actual));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_257231383 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_257231383;
        // ---------- Original Method ----------
        //if (prefix == null) {
            //return false;
        //}
        //String actual = lookupNamespaceURI(prefix);
        //return uri.equals(actual);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.924 -0400", hash_original_method = "408B99A289EC0349924637E46549BA26", hash_generated_method = "696D023ECBF10555D7E7AF17C1D11464")
    public final boolean isDefaultNamespace(String namespaceURI) {
        addTaint(namespaceURI.getTaint());
        String actual = lookupNamespaceURI(null);
        boolean var63D85A01DEF4141D91C38A25918BABCF_1809432998 = (namespaceURI == null
                ? actual == null
                : namespaceURI.equals(actual));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169432282 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169432282;
        // ---------- Original Method ----------
        //String actual = lookupNamespaceURI(null);
        //return namespaceURI == null
                //? actual == null
                //: namespaceURI.equals(actual);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.925 -0400", hash_original_method = "4BD06F1D22ADF3EA57842F923303423E", hash_generated_method = "8451E4F08223EE356FFEF93DB00723D3")
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
String var635A0C92002BCF6ED74FC0417E9137AE_445096345 =                     node.getNamespaceURI();
                    var635A0C92002BCF6ED74FC0417E9137AE_445096345.addTaint(taint);
                    return var635A0C92002BCF6ED74FC0417E9137AE_445096345;
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
String var933979A65FDA98D9635B5350FC86EE83_776081469 =                     value.length() > 0 ? value : null;
                    var933979A65FDA98D9635B5350FC86EE83_776081469.addTaint(taint);
                    return var933979A65FDA98D9635B5350FC86EE83_776081469;
                } //End block
            } //End block
        } //End block
String var540C13E9E156B687226421B24F2DF178_35662591 =         null;
        var540C13E9E156B687226421B24F2DF178_35662591.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_35662591;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.926 -0400", hash_original_method = "5ACD5A1048128B414FC469A4162D7D49", hash_generated_method = "0CD0AEE366AAC2F7486A71411B4B3945")
    public final boolean isEqualNode(Node arg) {
        addTaint(arg.getTaint());
    if(arg == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_863221927 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_379239207 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_379239207;
        } //End block
        List<Object> listA = createEqualityKey(this);
        List<Object> listB = createEqualityKey(arg);
    if(listA.size() != listB.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_2101379641 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1037300020 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1037300020;
        } //End block
for(int i = 0;i < listA.size();i++)
        {
            Object a = listA.get(i);
            Object b = listB.get(i);
    if(a == b)            
            {
                continue;
            } //End block
            else
    if(a == null || b == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_2141636317 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_962857339 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_962857339;
            } //End block
            else
    if(a instanceof String || a instanceof Short)            
            {
    if(!a.equals(b))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_329158139 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_283035196 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_283035196;
                } //End block
            } //End block
            else
    if(a instanceof NamedNodeMap)            
            {
    if(!(b instanceof NamedNodeMap)
                        || !namedNodeMapsEqual((NamedNodeMap) a, (NamedNodeMap) b))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1282565650 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2138653387 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_2138653387;
                } //End block
            } //End block
            else
    if(a instanceof Node)            
            {
    if(!(b instanceof Node)
                        || !((Node) a).isEqualNode((Node) b))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_474378041 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752684397 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752684397;
                } //End block
            } //End block
            else
            {
                AssertionError varA81442E36297E737EB908877E58260E8_1346422350 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_1346422350.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_1346422350;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1291179746 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_666602115 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_666602115;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.927 -0400", hash_original_method = "C9854B9EF2C5621F4F378B8106F34125", hash_generated_method = "A5EA130A3D4E02C8947FF280E0905098")
    private boolean namedNodeMapsEqual(NamedNodeMap a, NamedNodeMap b) {
        addTaint(b.getTaint());
        addTaint(a.getTaint());
    if(a.getLength() != b.getLength())        
        {
            boolean var68934A3E9455FA72420237EB05902327_374959843 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373106139 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_373106139;
        } //End block
for(int i = 0;i < a.getLength();i++)
        {
            Node aNode = a.item(i);
            Node bNode = aNode.getLocalName() == null
                    ? b.getNamedItem(aNode.getNodeName())
                    : b.getNamedItemNS(aNode.getNamespaceURI(), aNode.getLocalName());
    if(bNode == null || !aNode.isEqualNode(bNode))            
            {
                boolean var68934A3E9455FA72420237EB05902327_2146018568 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_603047246 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_603047246;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_986501216 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015925063 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015925063;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.928 -0400", hash_original_method = "654AD0B7653E61CCCCF2A287DD7A9FCF", hash_generated_method = "3557D4C3CED6535F5FA64F17BC2B7CDD")
    public final Object getFeature(String feature, String version) {
        addTaint(version.getTaint());
        addTaint(feature.getTaint());
Object var279AA1B9AF99C23199C38B381D516AF6_177533520 =         isSupported(feature, version) ? this : null;
        var279AA1B9AF99C23199C38B381D516AF6_177533520.addTaint(taint);
        return var279AA1B9AF99C23199C38B381D516AF6_177533520;
        // ---------- Original Method ----------
        //return isSupported(feature, version) ? this : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.928 -0400", hash_original_method = "9F34FDEA3DB7CC58B5A8B86C5F6353A5", hash_generated_method = "A25B627A3DBD9CDE033101948AD318A0")
    public final Object setUserData(String key, Object data, UserDataHandler handler) {
        addTaint(handler.getTaint());
        addTaint(data.getTaint());
        addTaint(key.getTaint());
    if(key == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_827635321 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_827635321.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_827635321;
        } //End block
        Map<String, UserData> map = document.getUserDataMap(this);
        UserData previous = data == null
                ? map.remove(key)
                : map.put(key, new UserData(data, handler));
Object var7AEBFE563B5E30066C7D8D5A898AA937_1750695056 =         previous != null ? previous.value : null;
        var7AEBFE563B5E30066C7D8D5A898AA937_1750695056.addTaint(taint);
        return var7AEBFE563B5E30066C7D8D5A898AA937_1750695056;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.929 -0400", hash_original_method = "B29B782E95D64D942AA9D9D3C7EEF744", hash_generated_method = "99C2F0D82B738318C3DBBCAB3BB28A9C")
    public final Object getUserData(String key) {
        addTaint(key.getTaint());
    if(key == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1358344175 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1358344175.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1358344175;
        } //End block
        Map<String, UserData> map = document.getUserDataMapForRead(this);
        UserData userData = map.get(key);
Object var0B7881AA1F8DD69A4EC48032632042A1_734203603 =         userData != null ? userData.value : null;
        var0B7881AA1F8DD69A4EC48032632042A1_734203603.addTaint(taint);
        return var0B7881AA1F8DD69A4EC48032632042A1_734203603;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //Map<String, UserData> map = document.getUserDataMapForRead(this);
        //UserData userData = map.get(key);
        //return userData != null ? userData.value : null;
    }

    
    static class UserData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.929 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.929 -0400", hash_original_field = "C1CBFE271A40788A00E8BF8574D94D4B", hash_generated_field = "827CB1F78A0BBD2016258DC26E1ED2F5")

        UserDataHandler handler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.930 -0400", hash_original_method = "0B6C19B4FFBA791689124EA47788F25F", hash_generated_method = "B74553803370CA04690975E42C003D03")
          UserData(Object value, UserDataHandler handler) {
            this.value = value;
            this.handler = handler;
            // ---------- Original Method ----------
            //this.value = value;
            //this.handler = handler;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.930 -0400", hash_original_field = "EEA06414AB077EBEC8501A6D636767BD", hash_generated_field = "F53B7EB5F95F86FB434D25A8A5066C44")

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
}

