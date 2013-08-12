package org.apache.harmony.xml.dom;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.657 -0400", hash_original_field = "FDC3BDEFB79CEC8EB8211D2499E04704", hash_generated_field = "3C52D3A90E4759490A57AF776DEAFE65")

    DocumentImpl document;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.658 -0400", hash_original_method = "A803585FEFBC6246911A956CA607D5CA", hash_generated_method = "9F50EA75A2AED9D57A4F24B1458FBC54")
      NodeImpl(DocumentImpl document) {
        this.document = document;
        // ---------- Original Method ----------
        //this.document = document;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.658 -0400", hash_original_method = "2014C4DBC7F925271C7D07A1BBA7C167", hash_generated_method = "E781A9F5C9F7BDEB20204748A5F3C9F6")
    public Node appendChild(Node newChild) throws DOMException {
        addTaint(newChild.getTaint());
        DOMException varB08FA5F9049CD84DC42B7238D3D303A7_487555422 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        varB08FA5F9049CD84DC42B7238D3D303A7_487555422.addTaint(taint);
        throw varB08FA5F9049CD84DC42B7238D3D303A7_487555422;
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.658 -0400", hash_original_method = "917775F899DEE58C265631FD33F793ED", hash_generated_method = "E140B814DE5DDC38768A737B6B8FD3D8")
    public final Node cloneNode(boolean deep) {
        addTaint(deep);
Node var04421AF73B134EC262B05FD2063BE675_399613688 =         document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
        var04421AF73B134EC262B05FD2063BE675_399613688.addTaint(taint);
        return var04421AF73B134EC262B05FD2063BE675_399613688;
        // ---------- Original Method ----------
        //return document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.658 -0400", hash_original_method = "E2D79625FBECAF1E43447A0BEFC228B9", hash_generated_method = "9D125CC3194F4AAA64E3CF8BDE19659D")
    public NamedNodeMap getAttributes() {
NamedNodeMap var540C13E9E156B687226421B24F2DF178_461277868 =         null;
        var540C13E9E156B687226421B24F2DF178_461277868.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_461277868;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.659 -0400", hash_original_method = "1F381BCE8228355FEE86D697E02DDE0B", hash_generated_method = "08D4CD494A6DB254116D23B4388313CF")
    public NodeList getChildNodes() {
NodeList var3EB787547078B98C6DA0C5CC8DE617C5_51915092 =         EMPTY_LIST;
        var3EB787547078B98C6DA0C5CC8DE617C5_51915092.addTaint(taint);
        return var3EB787547078B98C6DA0C5CC8DE617C5_51915092;
        // ---------- Original Method ----------
        //return EMPTY_LIST;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.659 -0400", hash_original_method = "DB31E0DD76C8C1947AB843730A5D8205", hash_generated_method = "2739BBCBED10CE69B5F48E12ED9899B6")
    public Node getFirstChild() {
Node var540C13E9E156B687226421B24F2DF178_983824697 =         null;
        var540C13E9E156B687226421B24F2DF178_983824697.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_983824697;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.659 -0400", hash_original_method = "6070A4A9C5DDD0223B459D45F6FD5CBB", hash_generated_method = "2748BA9ACC80FE620E30835C13108B91")
    public Node getLastChild() {
Node var540C13E9E156B687226421B24F2DF178_1740409503 =         null;
        var540C13E9E156B687226421B24F2DF178_1740409503.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1740409503;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.659 -0400", hash_original_method = "DEB04882A70946FEC78DD7AD3ABDE01B", hash_generated_method = "7C2F02ECE3F9D0F7DEF564728814B85A")
    public String getLocalName() {
String var540C13E9E156B687226421B24F2DF178_602366889 =         null;
        var540C13E9E156B687226421B24F2DF178_602366889.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_602366889;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.659 -0400", hash_original_method = "4D95F58ABD4076A5B25FED87E28A6FD8", hash_generated_method = "2D908431532A4720F4E8ADE812C59EE0")
    public String getNamespaceURI() {
String var540C13E9E156B687226421B24F2DF178_1688087419 =         null;
        var540C13E9E156B687226421B24F2DF178_1688087419.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1688087419;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.660 -0400", hash_original_method = "D23B45CE7514A5E8C576F43815BA5C75", hash_generated_method = "E7786B677273EEE5C4FD03FCDA9F01F4")
    public Node getNextSibling() {
Node var540C13E9E156B687226421B24F2DF178_1569714923 =         null;
        var540C13E9E156B687226421B24F2DF178_1569714923.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1569714923;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.660 -0400", hash_original_method = "FDA68CAC7DBE692AD654EACCAEB8ADF4", hash_generated_method = "0F673B6B032FD54057C51915F7479B66")
    public String getNodeName() {
String var540C13E9E156B687226421B24F2DF178_425243618 =         null;
        var540C13E9E156B687226421B24F2DF178_425243618.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_425243618;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract short getNodeType();

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.660 -0400", hash_original_method = "5D533F6B29FA017DED37EB54506CEFCE", hash_generated_method = "056CCD5C03E6261D217DC0720D1AE33A")
    public String getNodeValue() throws DOMException {
String var540C13E9E156B687226421B24F2DF178_1945154981 =         null;
        var540C13E9E156B687226421B24F2DF178_1945154981.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1945154981;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.660 -0400", hash_original_method = "683FB3B36E3C0C255B09CB1FE69555EA", hash_generated_method = "50A624EA88ED52933DA32F4C10DC9A9A")
    public final Document getOwnerDocument() {
Document var8A49EDE76E6856D243C546DB784C50EC_769526117 =         document == this ? null : document;
        var8A49EDE76E6856D243C546DB784C50EC_769526117.addTaint(taint);
        return var8A49EDE76E6856D243C546DB784C50EC_769526117;
        // ---------- Original Method ----------
        //return document == this ? null : document;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.660 -0400", hash_original_method = "2F661FBCA438408BEACED1A87A3CFAEE", hash_generated_method = "58FFB71E5503326C898B6EFCF1D7346D")
    public Node getParentNode() {
Node var540C13E9E156B687226421B24F2DF178_718583546 =         null;
        var540C13E9E156B687226421B24F2DF178_718583546.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_718583546;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.661 -0400", hash_original_method = "727413C23E49E727D2327332BBC1F81A", hash_generated_method = "12095E681D38D30D6048BAB2FB7A10A3")
    public String getPrefix() {
String var540C13E9E156B687226421B24F2DF178_527741399 =         null;
        var540C13E9E156B687226421B24F2DF178_527741399.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_527741399;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.661 -0400", hash_original_method = "70F44FC98E437F8103C8C034DB4ECB33", hash_generated_method = "F124171D4C5D5686CF219BF394B5DF05")
    public Node getPreviousSibling() {
Node var540C13E9E156B687226421B24F2DF178_667859912 =         null;
        var540C13E9E156B687226421B24F2DF178_667859912.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_667859912;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.661 -0400", hash_original_method = "B7795536C66ABB4718F9ED686281788D", hash_generated_method = "83BA35829655692957F282B823FAE518")
    public boolean hasAttributes() {
        boolean var68934A3E9455FA72420237EB05902327_117038022 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_541887298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_541887298;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.662 -0400", hash_original_method = "75BC1F0CD3DD7ADF1C7C374A2270CAC3", hash_generated_method = "2B1ED350B4EAA04F9BBCE3B85FDE59F6")
    public boolean hasChildNodes() {
        boolean var68934A3E9455FA72420237EB05902327_1583095799 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1159931155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1159931155;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.662 -0400", hash_original_method = "02900D7407B8981D4618C0943B784132", hash_generated_method = "65CB2986201D3D437DE85194EA25445A")
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        addTaint(refChild.getTaint());
        addTaint(newChild.getTaint());
        DOMException varB08FA5F9049CD84DC42B7238D3D303A7_691508933 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        varB08FA5F9049CD84DC42B7238D3D303A7_691508933.addTaint(taint);
        throw varB08FA5F9049CD84DC42B7238D3D303A7_691508933;
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.662 -0400", hash_original_method = "83D2E21D1EF19CE5C027A4D56C9BBECC", hash_generated_method = "52535EB97A4DADB7559EA7A1700413E6")
    public boolean isSupported(String feature, String version) {
        addTaint(version.getTaint());
        addTaint(feature.getTaint());
        boolean varA7FDD0EF468A82511F267BB626337ADB_779489479 = (DOMImplementationImpl.getInstance().hasFeature(feature, version));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1679744093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1679744093;
        // ---------- Original Method ----------
        //return DOMImplementationImpl.getInstance().hasFeature(feature, version);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.662 -0400", hash_original_method = "6E21C006D39E2D7D2AB395E9723D1D3D", hash_generated_method = "AAB79EA75709AFAC418FB3A2AD6C8459")
    public void normalize() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.663 -0400", hash_original_method = "C0BCC4253F844D2665FCB84131264ACF", hash_generated_method = "31682ABC887587C52B4DF636DA083228")
    public Node removeChild(Node oldChild) throws DOMException {
        addTaint(oldChild.getTaint());
        DOMException varB08FA5F9049CD84DC42B7238D3D303A7_1805819501 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        varB08FA5F9049CD84DC42B7238D3D303A7_1805819501.addTaint(taint);
        throw varB08FA5F9049CD84DC42B7238D3D303A7_1805819501;
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.663 -0400", hash_original_method = "3CB9ABDC605D3811167E9E73D3AF8E67", hash_generated_method = "DEA35E5ED04115617750B4B0B4D059F6")
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        addTaint(oldChild.getTaint());
        addTaint(newChild.getTaint());
        DOMException varB08FA5F9049CD84DC42B7238D3D303A7_381188448 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        varB08FA5F9049CD84DC42B7238D3D303A7_381188448.addTaint(taint);
        throw varB08FA5F9049CD84DC42B7238D3D303A7_381188448;
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.664 -0400", hash_original_method = "DD460B5BCEAE1CB09CE08B91E621DF7E", hash_generated_method = "D82199B85EC211480F130FA22EBC37A6")
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
        DOMException var27285F41C0EC27EB44BA0E5E07EE31A9_220166379 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        var27285F41C0EC27EB44BA0E5E07EE31A9_220166379.addTaint(taint);
        throw var27285F41C0EC27EB44BA0E5E07EE31A9_220166379;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.664 -0400", hash_original_method = "534A727E4FDB6CDBB5DC8BBEFB80CC50", hash_generated_method = "6394A903E9072527732E970BA56A5453")
    public void setPrefix(String prefix) throws DOMException {
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.665 -0400", hash_original_method = "DFD855C107B39D74015E43DCF13ECA5E", hash_generated_method = "4A151236E96E7834D93EDE416595FC15")
    private String getParentBaseUri() {
        Node parentNode = getParentNode();
String var9F008E4670FF2B5D32F29108A858BFF8_837578713 =         parentNode != null ? parentNode.getBaseURI() : null;
        var9F008E4670FF2B5D32F29108A858BFF8_837578713.addTaint(taint);
        return var9F008E4670FF2B5D32F29108A858BFF8_837578713;
        // ---------- Original Method ----------
        //Node parentNode = getParentNode();
        //return parentNode != null ? parentNode.getBaseURI() : null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.665 -0400", hash_original_method = "1D824B9402137DBC708C242BAEC27F82", hash_generated_method = "59A0AFD5BDFB375765FF87142B34C576")
    private String sanitizeUri(String uri) {
        addTaint(uri.getTaint());
        if(uri == null || uri.length() == 0)        
        {
String var540C13E9E156B687226421B24F2DF178_702831928 =             null;
            var540C13E9E156B687226421B24F2DF178_702831928.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_702831928;
        } //End block
        try 
        {
String var0370934740A23317A971FB463A48421D_471510111 =             new URI(uri).toString();
            var0370934740A23317A971FB463A48421D_471510111.addTaint(taint);
            return var0370934740A23317A971FB463A48421D_471510111;
        } //End block
        catch (URISyntaxException e)
        {
String var540C13E9E156B687226421B24F2DF178_1988083797 =             null;
            var540C13E9E156B687226421B24F2DF178_1988083797.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1988083797;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.665 -0400", hash_original_method = "1DDF123F9002EFB3DC60D7666C901199", hash_generated_method = "C03FD9C70CFF0243A35826E68FB64A81")
    public short compareDocumentPosition(Node other) throws DOMException {
        addTaint(other.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1388783981 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1388783981.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1388783981;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.665 -0400", hash_original_method = "67AC02ADFBE93754C1AB8AE0D37378EE", hash_generated_method = "2D1254D0F142580E04401EC940751B26")
    public String getTextContent() throws DOMException {
String var7364FBEBC22E1599B041B125CD0C1F76_903473998 =         getNodeValue();
        var7364FBEBC22E1599B041B125CD0C1F76_903473998.addTaint(taint);
        return var7364FBEBC22E1599B041B125CD0C1F76_903473998;
        // ---------- Original Method ----------
        //return getNodeValue();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.666 -0400", hash_original_method = "6ADB0BF10CD256A5C763161A1385CD79", hash_generated_method = "83697DB6930881E839504C8200EC175F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.666 -0400", hash_original_method = "B267D49587C3D1DB842740F077498528", hash_generated_method = "2E26A27AB936D646206DCE934DB7BC0C")
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
        DOMException var27285F41C0EC27EB44BA0E5E07EE31A9_856334443 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        var27285F41C0EC27EB44BA0E5E07EE31A9_856334443.addTaint(taint);
        throw var27285F41C0EC27EB44BA0E5E07EE31A9_856334443;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.667 -0400", hash_original_method = "CDCF2BEBCB3DF8B0191B82144C39E4E3", hash_generated_method = "622F635A2B9F4B77AB57706107D14CFB")
    public boolean isSameNode(Node other) {
        addTaint(other.getTaint());
        boolean varBE1F9AF96A88D9FBF24773A7F592CAA1_1943448392 = (this == other);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510880304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510880304;
        // ---------- Original Method ----------
        //return this == other;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.667 -0400", hash_original_method = "DDD4A4E09BB31E4B92DF0753DE457415", hash_generated_method = "9B8DA67EFE7623ABEF6FCA93DBE97B5C")
    private NodeImpl getNamespacingElement() {
switch(this.getNodeType()){
        case ELEMENT_NODE:
NodeImpl var72A74007B2BE62B849F475C7BDA4658B_1724858040 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1724858040.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1724858040;
        case DOCUMENT_NODE:
NodeImpl var9C44064DA096AF5EE1C299DE4B805A85_161486100 =         (NodeImpl) ((Document) this).getDocumentElement();
        var9C44064DA096AF5EE1C299DE4B805A85_161486100.addTaint(taint);
        return var9C44064DA096AF5EE1C299DE4B805A85_161486100;
        case ENTITY_NODE:
        case NOTATION_NODE:
        case DOCUMENT_FRAGMENT_NODE:
        case DOCUMENT_TYPE_NODE:
NodeImpl var540C13E9E156B687226421B24F2DF178_1238503698 =         null;
        var540C13E9E156B687226421B24F2DF178_1238503698.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1238503698;
        case ATTRIBUTE_NODE:
NodeImpl var253799FEBA18F79910817934AFD00BEF_88164140 =         (NodeImpl) ((Attr) this).getOwnerElement();
        var253799FEBA18F79910817934AFD00BEF_88164140.addTaint(taint);
        return var253799FEBA18F79910817934AFD00BEF_88164140;
        case TEXT_NODE:
        case CDATA_SECTION_NODE:
        case ENTITY_REFERENCE_NODE:
        case PROCESSING_INSTRUCTION_NODE:
        case COMMENT_NODE:
NodeImpl var8BC235EA48173B3F91C3D3D2A4E83A35_887718335 =         getContainingElement();
        var8BC235EA48173B3F91C3D3D2A4E83A35_887718335.addTaint(taint);
        return var8BC235EA48173B3F91C3D3D2A4E83A35_887718335;
        default:
        DOMException var27285F41C0EC27EB44BA0E5E07EE31A9_2021227950 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
        var27285F41C0EC27EB44BA0E5E07EE31A9_2021227950.addTaint(taint);
        throw var27285F41C0EC27EB44BA0E5E07EE31A9_2021227950;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.667 -0400", hash_original_method = "E4B9E13482B5AB13521831694CDD3F31", hash_generated_method = "D3338B06D1114EF374E5B3B105140C7A")
    private NodeImpl getContainingElement() {
for(Node p = getParentNode();p != null;p = p.getParentNode())
        {
            if(p.getNodeType() == ELEMENT_NODE)            
            {
NodeImpl varBEA0A08D3E1C9339930C51EE49C1BB6C_980814702 =                 (NodeImpl) p;
                varBEA0A08D3E1C9339930C51EE49C1BB6C_980814702.addTaint(taint);
                return varBEA0A08D3E1C9339930C51EE49C1BB6C_980814702;
            } //End block
        } //End block
NodeImpl var540C13E9E156B687226421B24F2DF178_1885668922 =         null;
        var540C13E9E156B687226421B24F2DF178_1885668922.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1885668922;
        // ---------- Original Method ----------
        //for (Node p = getParentNode(); p != null; p = p.getParentNode()) {
            //if (p.getNodeType() == ELEMENT_NODE) {
                //return (NodeImpl) p;
            //}
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.668 -0400", hash_original_method = "AA07F6405A8EB7821F818F6C760FCB2D", hash_generated_method = "1D9CA2B76229798F71F83B6CA3511C32")
     boolean isPrefixMappedToUri(String prefix, String uri) {
        addTaint(uri.getTaint());
        addTaint(prefix.getTaint());
        if(prefix == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1332913338 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_537520316 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_537520316;
        } //End block
        String actual = lookupNamespaceURI(prefix);
        boolean var5089C02DA3CB33691AF3AF6613290012_660092351 = (uri.equals(actual));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1455174349 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1455174349;
        // ---------- Original Method ----------
        //if (prefix == null) {
            //return false;
        //}
        //String actual = lookupNamespaceURI(prefix);
        //return uri.equals(actual);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.669 -0400", hash_original_method = "408B99A289EC0349924637E46549BA26", hash_generated_method = "4FFFEC33A636C6A7CB31D80472729501")
    public final boolean isDefaultNamespace(String namespaceURI) {
        addTaint(namespaceURI.getTaint());
        String actual = lookupNamespaceURI(null);
        boolean var63D85A01DEF4141D91C38A25918BABCF_17874741 = (namespaceURI == null
                ? actual == null
                : namespaceURI.equals(actual));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_761561439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_761561439;
        // ---------- Original Method ----------
        //String actual = lookupNamespaceURI(null);
        //return namespaceURI == null
                //? actual == null
                //: namespaceURI.equals(actual);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.670 -0400", hash_original_method = "5ACD5A1048128B414FC469A4162D7D49", hash_generated_method = "ED17DDFDD6E26AE5E6FFFB9355334508")
    public final boolean isEqualNode(Node arg) {
        addTaint(arg.getTaint());
        if(arg == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1067902189 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311233112 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_311233112;
        } //End block
        List<Object> listA = createEqualityKey(this);
        List<Object> listB = createEqualityKey(arg);
        if(listA.size() != listB.size())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1241871078 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_75747994 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_75747994;
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
                boolean var68934A3E9455FA72420237EB05902327_1490584670 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1031947445 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1031947445;
            } //End block
            else
            if(a instanceof String || a instanceof Short)            
            {
                if(!a.equals(b))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_458991101 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_441028029 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_441028029;
                } //End block
            } //End block
            else
            if(a instanceof NamedNodeMap)            
            {
                if(!(b instanceof NamedNodeMap)
                        || !namedNodeMapsEqual((NamedNodeMap) a, (NamedNodeMap) b))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_1133564157 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58624047 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_58624047;
                } //End block
            } //End block
            else
            if(a instanceof Node)            
            {
                if(!(b instanceof Node)
                        || !((Node) a).isEqualNode((Node) b))                
                {
                    boolean var68934A3E9455FA72420237EB05902327_349067658 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_83456878 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_83456878;
                } //End block
            } //End block
            else
            {
                AssertionError varA81442E36297E737EB908877E58260E8_75635585 = new AssertionError();
                varA81442E36297E737EB908877E58260E8_75635585.addTaint(taint);
                throw varA81442E36297E737EB908877E58260E8_75635585;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_386000600 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_921211485 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_921211485;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.671 -0400", hash_original_method = "C9854B9EF2C5621F4F378B8106F34125", hash_generated_method = "C1FE56E83238551C5563D64E8A01BF38")
    private boolean namedNodeMapsEqual(NamedNodeMap a, NamedNodeMap b) {
        addTaint(b.getTaint());
        addTaint(a.getTaint());
        if(a.getLength() != b.getLength())        
        {
            boolean var68934A3E9455FA72420237EB05902327_319928796 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_970647978 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_970647978;
        } //End block
for(int i = 0;i < a.getLength();i++)
        {
            Node aNode = a.item(i);
            Node bNode = aNode.getLocalName() == null
                    ? b.getNamedItem(aNode.getNodeName())
                    : b.getNamedItemNS(aNode.getNamespaceURI(), aNode.getLocalName());
            if(bNode == null || !aNode.isEqualNode(bNode))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1151386581 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1703624416 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1703624416;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_512597577 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_92738119 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_92738119;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.671 -0400", hash_original_method = "654AD0B7653E61CCCCF2A287DD7A9FCF", hash_generated_method = "81EACEF3A8D3E96A392B4A37F58F98F7")
    public final Object getFeature(String feature, String version) {
        addTaint(version.getTaint());
        addTaint(feature.getTaint());
Object var279AA1B9AF99C23199C38B381D516AF6_1214617498 =         isSupported(feature, version) ? this : null;
        var279AA1B9AF99C23199C38B381D516AF6_1214617498.addTaint(taint);
        return var279AA1B9AF99C23199C38B381D516AF6_1214617498;
        // ---------- Original Method ----------
        //return isSupported(feature, version) ? this : null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.671 -0400", hash_original_method = "9F34FDEA3DB7CC58B5A8B86C5F6353A5", hash_generated_method = "C5D606D6850F3688DFC519B45FF1C1E0")
    public final Object setUserData(String key, Object data, UserDataHandler handler) {
        addTaint(handler.getTaint());
        addTaint(data.getTaint());
        addTaint(key.getTaint());
        if(key == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_494748414 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_494748414.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_494748414;
        } //End block
        Map<String, UserData> map = document.getUserDataMap(this);
        UserData previous = data == null
                ? map.remove(key)
                : map.put(key, new UserData(data, handler));
Object var7AEBFE563B5E30066C7D8D5A898AA937_446877585 =         previous != null ? previous.value : null;
        var7AEBFE563B5E30066C7D8D5A898AA937_446877585.addTaint(taint);
        return var7AEBFE563B5E30066C7D8D5A898AA937_446877585;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.671 -0400", hash_original_method = "B29B782E95D64D942AA9D9D3C7EEF744", hash_generated_method = "D83DD91E6BE2A8B75A5F5F8197E8257D")
    public final Object getUserData(String key) {
        addTaint(key.getTaint());
        if(key == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_959036359 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_959036359.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_959036359;
        } //End block
        Map<String, UserData> map = document.getUserDataMapForRead(this);
        UserData userData = map.get(key);
Object var0B7881AA1F8DD69A4EC48032632042A1_506108637 =         userData != null ? userData.value : null;
        var0B7881AA1F8DD69A4EC48032632042A1_506108637.addTaint(taint);
        return var0B7881AA1F8DD69A4EC48032632042A1_506108637;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //Map<String, UserData> map = document.getUserDataMapForRead(this);
        //UserData userData = map.get(key);
        //return userData != null ? userData.value : null;
    }

    
    static class UserData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.671 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "01495BEB834F5098BB0B06183674C819")

        Object value;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.672 -0400", hash_original_field = "C1CBFE271A40788A00E8BF8574D94D4B", hash_generated_field = "827CB1F78A0BBD2016258DC26E1ED2F5")

        UserDataHandler handler;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.672 -0400", hash_original_method = "0B6C19B4FFBA791689124EA47788F25F", hash_generated_method = "B74553803370CA04690975E42C003D03")
          UserData(Object value, UserDataHandler handler) {
            this.value = value;
            this.handler = handler;
            // ---------- Original Method ----------
            //this.value = value;
            //this.handler = handler;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.672 -0400", hash_original_field = "EEA06414AB077EBEC8501A6D636767BD", hash_generated_field = "F53B7EB5F95F86FB434D25A8A5066C44")

    private static final NodeList EMPTY_LIST = new NodeListImpl();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.373 -0400", hash_original_field = "50B55FD6A8E5705F66BF71830D3227D1", hash_generated_field = "9BE656944A6DBF09637C80D55E352920")

    static final TypeInfo NULL_TYPE_INFO = new TypeInfo() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.372 -0400", hash_original_method = "D6670B1956B399E1F4484C7409D24E32", hash_generated_method = "B4051AD4FF44AD338624469365B280F8")
        public String getTypeName() {
            String varB4EAC82CA7396A68D541C85D26508E83_366710541 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_366710541 = null;
            varB4EAC82CA7396A68D541C85D26508E83_366710541.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_366710541;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:36.373 -0400", hash_original_method = "076EDBD720D64B1CD58A3E3161F3A408", hash_generated_method = "83D91F2300DCAB76D6EC29A18904FFB6")
        public String getTypeNamespace() {
            String varB4EAC82CA7396A68D541C85D26508E83_2015477207 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_2015477207 = null;
            varB4EAC82CA7396A68D541C85D26508E83_2015477207.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2015477207;
            
            
        }

        
        @DSModeled(DSC.SAFE)
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

