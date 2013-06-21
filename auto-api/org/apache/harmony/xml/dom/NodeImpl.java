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
    DocumentImpl document;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.412 -0400", hash_original_method = "A803585FEFBC6246911A956CA607D5CA", hash_generated_method = "172B7B8166CDD67F6FD91E70D602DBDE")
    @DSModeled(DSC.SAFE)
     NodeImpl(DocumentImpl document) {
        dsTaint.addTaint(document.dsTaint);
        // ---------- Original Method ----------
        //this.document = document;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.412 -0400", hash_original_method = "2014C4DBC7F925271C7D07A1BBA7C167", hash_generated_method = "2129AD6D29729FF026AF9C0C729CE036")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node appendChild(Node newChild) throws DOMException {
        dsTaint.addTaint(newChild.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.413 -0400", hash_original_method = "917775F899DEE58C265631FD33F793ED", hash_generated_method = "D8117FD0CB8A79B677C33A77A07FFCB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Node cloneNode(boolean deep) {
        dsTaint.addTaint(deep);
        Node var9272D8E027A7FB5F74EDB4B1C72F486A_510852271 = (document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep));
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return document.cloneOrImportNode(UserDataHandler.NODE_CLONED, this, deep);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.413 -0400", hash_original_method = "E2D79625FBECAF1E43447A0BEFC228B9", hash_generated_method = "EFC54CD70E8182048AD7A428D90D1952")
    @DSModeled(DSC.SAFE)
    public NamedNodeMap getAttributes() {
        return (NamedNodeMap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.413 -0400", hash_original_method = "1F381BCE8228355FEE86D697E02DDE0B", hash_generated_method = "D23A7EA077EBC3A27BE832DEFCE54355")
    @DSModeled(DSC.SAFE)
    public NodeList getChildNodes() {
        return (NodeList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return EMPTY_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.413 -0400", hash_original_method = "DB31E0DD76C8C1947AB843730A5D8205", hash_generated_method = "82FE86A1EE7C6A0C6A60FC3654B3ED5F")
    @DSModeled(DSC.SAFE)
    public Node getFirstChild() {
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.413 -0400", hash_original_method = "6070A4A9C5DDD0223B459D45F6FD5CBB", hash_generated_method = "22A27F6CF831D9B3E3BCDA250A8DC922")
    @DSModeled(DSC.SAFE)
    public Node getLastChild() {
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.414 -0400", hash_original_method = "DEB04882A70946FEC78DD7AD3ABDE01B", hash_generated_method = "74862798E2F00019C0310E583ED53276")
    @DSModeled(DSC.SAFE)
    public String getLocalName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.414 -0400", hash_original_method = "4D95F58ABD4076A5B25FED87E28A6FD8", hash_generated_method = "8D6B44B1F9198C5D198B860037F4BEC6")
    @DSModeled(DSC.SAFE)
    public String getNamespaceURI() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.414 -0400", hash_original_method = "D23B45CE7514A5E8C576F43815BA5C75", hash_generated_method = "8C2495D4EF89DE415E6B1E45B1EBDF0F")
    @DSModeled(DSC.SAFE)
    public Node getNextSibling() {
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.414 -0400", hash_original_method = "FDA68CAC7DBE692AD654EACCAEB8ADF4", hash_generated_method = "28F22BA05655B442797952E16573DE5E")
    @DSModeled(DSC.SAFE)
    public String getNodeName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    public abstract short getNodeType();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.414 -0400", hash_original_method = "5D533F6B29FA017DED37EB54506CEFCE", hash_generated_method = "867C356DAB52007B1D9B17CEBDAECC48")
    @DSModeled(DSC.SAFE)
    public String getNodeValue() throws DOMException {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.415 -0400", hash_original_method = "683FB3B36E3C0C255B09CB1FE69555EA", hash_generated_method = "D53D6CEA3CC1B09A3C96CA4DF6F5B569")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Document getOwnerDocument() {
        {
            boolean var068D152B16A7C4E642745AC06C4DA57A_1492173561 = (document == this);
        } //End flattened ternary
        return (Document)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return document == this ? null : document;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.415 -0400", hash_original_method = "2F661FBCA438408BEACED1A87A3CFAEE", hash_generated_method = "BA5BE5249D1296DF6F33164E249BFCCE")
    @DSModeled(DSC.SAFE)
    public Node getParentNode() {
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.415 -0400", hash_original_method = "727413C23E49E727D2327332BBC1F81A", hash_generated_method = "1AE0A4A9D1BECA415703109D364E4382")
    @DSModeled(DSC.SAFE)
    public String getPrefix() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.415 -0400", hash_original_method = "70F44FC98E437F8103C8C034DB4ECB33", hash_generated_method = "55BD1EF1A709DD9A7006263286B4762B")
    @DSModeled(DSC.SAFE)
    public Node getPreviousSibling() {
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.415 -0400", hash_original_method = "B7795536C66ABB4718F9ED686281788D", hash_generated_method = "A2CE2FF8ED567A6A94A23992C00A1860")
    @DSModeled(DSC.SAFE)
    public boolean hasAttributes() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.416 -0400", hash_original_method = "75BC1F0CD3DD7ADF1C7C374A2270CAC3", hash_generated_method = "2DAA2286EFA89EF369764807BB048469")
    @DSModeled(DSC.SAFE)
    public boolean hasChildNodes() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.416 -0400", hash_original_method = "02900D7407B8981D4618C0943B784132", hash_generated_method = "5B35689AFB05740608C80AB5B10A251C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node insertBefore(Node newChild, Node refChild) throws DOMException {
        dsTaint.addTaint(refChild.dsTaint);
        dsTaint.addTaint(newChild.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.416 -0400", hash_original_method = "83D2E21D1EF19CE5C027A4D56C9BBECC", hash_generated_method = "240E2CEF7DD16E2D8938ABE2DFB6219A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSupported(String feature, String version) {
        dsTaint.addTaint(feature);
        dsTaint.addTaint(version);
        boolean var35F7927EF3CC7F4E5B6C50A87B9E3142_1982463407 = (DOMImplementationImpl.getInstance().hasFeature(feature, version));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return DOMImplementationImpl.getInstance().hasFeature(feature, version);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.416 -0400", hash_original_method = "6E21C006D39E2D7D2AB395E9723D1D3D", hash_generated_method = "AAB79EA75709AFAC418FB3A2AD6C8459")
    @DSModeled(DSC.SAFE)
    public void normalize() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.416 -0400", hash_original_method = "C0BCC4253F844D2665FCB84131264ACF", hash_generated_method = "914B87337830A04CE933622A14DEE720")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node removeChild(Node oldChild) throws DOMException {
        dsTaint.addTaint(oldChild.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.417 -0400", hash_original_method = "3CB9ABDC605D3811167E9E73D3AF8E67", hash_generated_method = "9B1519BA23A70922C3D5D6A3C2A469D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
        dsTaint.addTaint(oldChild.dsTaint);
        dsTaint.addTaint(newChild.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
        return (Node)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.417 -0400", hash_original_method = "DD460B5BCEAE1CB09CE08B91E621DF7E", hash_generated_method = "54CCEF7419448397CAFEF7FA4399462C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setNodeValue(String nodeValue) throws DOMException {
        dsTaint.addTaint(nodeValue);
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_2000016167 = (getNodeType());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.417 -0400", hash_original_method = "534A727E4FDB6CDBB5DC8BBEFB80CC50", hash_generated_method = "06E429DB918AD75F09381A70BFBB5961")
    @DSModeled(DSC.SAFE)
    public void setPrefix(String prefix) throws DOMException {
        dsTaint.addTaint(prefix);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.418 -0400", hash_original_method = "DD28C7A733028F46F0F8ECAE2D47C2BC", hash_generated_method = "4E1EB1B02074C5DCDBAF79EBE8C0036D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getBaseURI() {
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_1778013665 = (getNodeType());
            //Begin case DOCUMENT_NODE 
            String var51D7D496A2FC072030D7EDBD2332D3D3_1197653065 = (sanitizeUri(((Document) this).getDocumentURI()));
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
                    boolean varCD5A1EF129D63A19CBA8F3323E78D018_2062120661 = (uri == null || uri.isEmpty());
                    {
                        String var86F1F29131BCC4DE7C352496DB8DCF4A_361231284 = (getParentBaseUri());
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varCFCB3A4B5B2F222B09B28B628CD2D035_517385919 = (new URI(uri).isAbsolute());
                } //End collapsed parenthetic
                String parentUri;
                parentUri = getParentBaseUri();
                String varA59A4A397BEA44DF94D7C5A3203B8BF4_1145851321 = (new URI(parentUri).resolve(uri).toString());
            } //End block
            catch (URISyntaxException e)
            { }
            //End case ELEMENT_NODE 
            //Begin case PROCESSING_INSTRUCTION_NODE 
            String varDD84219A057AAEF893A62D5D5A709AEB_1672857973 = (getParentBaseUri());
            //End case PROCESSING_INSTRUCTION_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
            //End case default 
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.419 -0400", hash_original_method = "DFD855C107B39D74015E43DCF13ECA5E", hash_generated_method = "A5FFED778D57B9DBA15E21AE8EE6E6BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getParentBaseUri() {
        Node parentNode;
        parentNode = getParentNode();
        {
            Object varE4470602EBE04021D17B6DB0B9C30476_249901159 = (parentNode.getBaseURI());
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Node parentNode = getParentNode();
        //return parentNode != null ? parentNode.getBaseURI() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.419 -0400", hash_original_method = "1D824B9402137DBC708C242BAEC27F82", hash_generated_method = "97AE55123403E3E5C13AACCBF0A07DBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String sanitizeUri(String uri) {
        dsTaint.addTaint(uri);
        {
            boolean var6E057AB845D6ADAE670C60C55D7A447B_396488463 = (uri == null || uri.length() == 0);
        } //End collapsed parenthetic
        try 
        {
            String varB84C8EB05F8077EE93943D767EBBA4E6_1752709257 = (new URI(uri).toString());
        } //End block
        catch (URISyntaxException e)
        { }
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.419 -0400", hash_original_method = "1DDF123F9002EFB3DC60D7666C901199", hash_generated_method = "A2363E1C2B95F9E0957A1A2DA4DF05F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short compareDocumentPosition(Node other) throws DOMException {
        dsTaint.addTaint(other.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.419 -0400", hash_original_method = "67AC02ADFBE93754C1AB8AE0D37378EE", hash_generated_method = "7AA44A831DD44AF765B558E268491569")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTextContent() throws DOMException {
        String varFE07727FB199EDD1A2ED443CF9E8401D_131675349 = (getNodeValue());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getNodeValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.419 -0400", hash_original_method = "6ADB0BF10CD256A5C763161A1385CD79", hash_generated_method = "34FBDC8BAFE875BCC2C3C34E78641E6B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void getTextContent(StringBuilder buf) throws DOMException {
        dsTaint.addTaint(buf.dsTaint);
        String content;
        content = getNodeValue();
        {
            buf.append(content);
        } //End block
        // ---------- Original Method ----------
        //String content = getNodeValue();
        //if (content != null) {
            //buf.append(content);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.420 -0400", hash_original_method = "B267D49587C3D1DB842740F077498528", hash_generated_method = "8998E179B73552D9F24CC3B9DC9E2FFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void setTextContent(String textContent) throws DOMException {
        dsTaint.addTaint(textContent);
        {
            Object varCC9A300B2E62238AE3ECD7C9C406491C_1493677052 = (getNodeType());
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            Node child;
            //End case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            {
                boolean var7B4B4D60718B8920C8140722D3CC2681_1124052544 = ((child = getFirstChild()) != null);
                {
                    removeChild(child);
                } //End block
            } //End collapsed parenthetic
            //End case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            //Begin case ELEMENT_NODE ENTITY_NODE ENTITY_REFERENCE_NODE DOCUMENT_FRAGMENT_NODE 
            {
                boolean varE87C319A84018C6C43084B4686BD5121_808206238 = (textContent != null && textContent.length() != 0);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.420 -0400", hash_original_method = "CDCF2BEBCB3DF8B0191B82144C39E4E3", hash_generated_method = "BF47CE62396D026414BD7A9A6553D4C6")
    @DSModeled(DSC.SAFE)
    public boolean isSameNode(Node other) {
        dsTaint.addTaint(other.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return this == other;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.420 -0400", hash_original_method = "DDD4A4E09BB31E4B92DF0753DE457415", hash_generated_method = "3FFA14ED61EFE5903E984435C14FC754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NodeImpl getNamespacingElement() {
        {
            Object varCF51CDECE43343A636AB308505B1992B_2025800422 = (this.getNodeType());
            //Begin case DOCUMENT_NODE 
            NodeImpl varD5268B9A0BB258A71CED60B74F069EF5_1573416860 = ((NodeImpl) ((Document) this).getDocumentElement());
            //End case DOCUMENT_NODE 
            //Begin case ATTRIBUTE_NODE 
            NodeImpl var84C12B9F94D02B3B616A05B7925ADDD7_33649921 = ((NodeImpl) ((Attr) this).getOwnerElement());
            //End case ATTRIBUTE_NODE 
            //Begin case TEXT_NODE CDATA_SECTION_NODE ENTITY_REFERENCE_NODE PROCESSING_INSTRUCTION_NODE COMMENT_NODE 
            NodeImpl varBF0D85A60A7C51C32DB5EA1A380F6468_134296185 = (getContainingElement());
            //End case TEXT_NODE CDATA_SECTION_NODE ENTITY_REFERENCE_NODE PROCESSING_INSTRUCTION_NODE COMMENT_NODE 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + getNodeType());
            //End case default 
        } //End collapsed parenthetic
        return (NodeImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.421 -0400", hash_original_method = "E4B9E13482B5AB13521831694CDD3F31", hash_generated_method = "B279AAC4D369B8639F4C1F080ED78EBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private NodeImpl getContainingElement() {
        {
            Node p;
            p = getParentNode();
            p = p.getParentNode();
            {
                {
                    boolean varFBC5A12935C2B20E9065353DA95A8A18_1434610727 = (p.getNodeType() == ELEMENT_NODE);
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (NodeImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (Node p = getParentNode(); p != null; p = p.getParentNode()) {
            //if (p.getNodeType() == ELEMENT_NODE) {
                //return (NodeImpl) p;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.421 -0400", hash_original_method = "7FA28D24E20CD6244334CF1DE396DB62", hash_generated_method = "98338B04F66EA4BA4668298BC34E73E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String lookupPrefix(String namespaceURI) {
        dsTaint.addTaint(namespaceURI);
        NodeImpl target;
        target = getNamespacingElement();
        {
            NodeImpl node;
            node = target;
            node = node.getContainingElement();
            {
                {
                    boolean varB403AB9B9BBCA7835D5E0AFC14FDB897_180005767 = (namespaceURI.equals(node.getNamespaceURI())
                    && target.isPrefixMappedToUri(node.getPrefix(), namespaceURI));
                    {
                        String var85B67CC151C7F2AA825ED3976BCBF00D_441059058 = (node.getPrefix());
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varC9579644D782C09885D8B6799B24D1B7_156615083 = (!node.hasAttributes());
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
                            boolean var041AF16A4322928AB25B30D9E76210A6_1910770195 = (!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI())
                        || !"xmlns".equals(attr.getPrefix())
                        || !namespaceURI.equals(attr.getNodeValue()));
                        } //End collapsed parenthetic
                        {
                            boolean varF15B4EC2E77AFBBC3F4E8FC11243E540_2049373151 = (target.isPrefixMappedToUri(attr.getLocalName(), namespaceURI));
                            {
                                String var3B638078D38D4AD7565EEEC945B9E84E_1692338590 = (attr.getLocalName());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.421 -0400", hash_original_method = "AA07F6405A8EB7821F818F6C760FCB2D", hash_generated_method = "FF888C04B6D9FE4B56244141FEED469A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isPrefixMappedToUri(String prefix, String uri) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(uri);
        String actual;
        actual = lookupNamespaceURI(prefix);
        boolean varF9523BA0BFC98B7D91C11E34CD185911_1996657903 = (uri.equals(actual));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (prefix == null) {
            //return false;
        //}
        //String actual = lookupNamespaceURI(prefix);
        //return uri.equals(actual);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.422 -0400", hash_original_method = "408B99A289EC0349924637E46549BA26", hash_generated_method = "796783C44E71B4DE89D5A044070AB16B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isDefaultNamespace(String namespaceURI) {
        dsTaint.addTaint(namespaceURI);
        String actual;
        actual = lookupNamespaceURI(null);
        {
            Object varA1932E607C647B6D725637B43AC06F10_332819830 = (namespaceURI.equals(actual));
        } //End flattened ternary
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //String actual = lookupNamespaceURI(null);
        //return namespaceURI == null
                //? actual == null
                //: namespaceURI.equals(actual);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.425 -0400", hash_original_method = "4BD06F1D22ADF3EA57842F923303423E", hash_generated_method = "936DAC2F799F6FFD84FAC8B35F8E187C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String lookupNamespaceURI(String prefix) {
        dsTaint.addTaint(prefix);
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
                    boolean var8BF87494DE6EC4578842A86B09D729A6_982302276 = (node.getNamespaceURI() != null);
                    {
                        {
                            {
                                boolean var37CC4D70FC3B61DCF871FB1CF8AD2846_1949507031 = (prefix.equals(nodePrefix));
                            } //End flattened ternary
                            {
                                String varD61DEF1F1C93CED6CFC4912702B1B393_543827237 = (node.getNamespaceURI());
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varC9579644D782C09885D8B6799B24D1B7_506277998 = (!node.hasAttributes());
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
                            boolean varA13C057422A3B97AA60AD41894F0635F_489390199 = (!"http://www.w3.org/2000/xmlns/".equals(attr.getNamespaceURI()));
                        } //End collapsed parenthetic
                        {
                            {
                                boolean varFF1254D872CF5DC8F931458B444BA8F1_1708369733 = ("xmlns".equals(attr.getNodeName()));
                                boolean varBCF6CD3EF8E6EAEC9EE3BFD950C4EEDF_827760043 = ("xmlns".equals(attr.getPrefix()) && prefix.equals(attr.getLocalName()));
                            } //End flattened ternary
                            {
                                String value;
                                value = attr.getNodeValue();
                                {
                                    boolean varBE7FEEBC3723ED291359FAA5BC9FF81E_899645223 = (value.length() > 0);
                                } //End flattened ternary
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.427 -0400", hash_original_method = "5ACD5A1048128B414FC469A4162D7D49", hash_generated_method = "B0ADB9AFA7F4D5173D0EFE349E1826C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean isEqualNode(Node arg) {
        dsTaint.addTaint(arg.dsTaint);
        {
            boolean var651A5D8954C9CB1305B0993B5221CC81_1473795645 = (arg == this);
        } //End collapsed parenthetic
        List<Object> listA;
        listA = createEqualityKey(this);
        List<Object> listB;
        listB = createEqualityKey(arg);
        {
            boolean varA3551D9BD39003E9C908D438AFCDB1BC_1273324266 = (listA.size() != listB.size());
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean var6EBB52ED45932AB49617FFD096C89B6F_1304417601 = (i < listA.size());
            {
                Object a;
                a = listA.get(i);
                Object b;
                b = listB.get(i);
                {
                    {
                        boolean var0773BCBF827A4914F7F4F933191F9A10_1974674816 = (!a.equals(b));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean var7D0BEECF51923FA96C755BED3C32C5AF_5197093 = (!(b instanceof NamedNodeMap)
                        || !namedNodeMapsEqual((NamedNodeMap) a, (NamedNodeMap) b));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        boolean varBA00253A935A73454F5089C6C332A1DE_1747305658 = (!(b instanceof Node)
                        || !((Node) a).isEqualNode((Node) b));
                    } //End collapsed parenthetic
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new AssertionError();
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.427 -0400", hash_original_method = "C9854B9EF2C5621F4F378B8106F34125", hash_generated_method = "DF8A08C62BA52C13A9E76D40C4EC1F9F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean namedNodeMapsEqual(NamedNodeMap a, NamedNodeMap b) {
        dsTaint.addTaint(b.dsTaint);
        dsTaint.addTaint(a.dsTaint);
        {
            boolean var0E71204F221B1B5EA61075617DA2C225_1608274328 = (a.getLength() != b.getLength());
        } //End collapsed parenthetic
        {
            int i;
            i = 0;
            boolean var4A7AD866419D9BB4E8A28D673C28686A_1271649792 = (i < a.getLength());
            {
                Node aNode;
                aNode = a.item(i);
                Node bNode;
                boolean var880BE5E00764F10380C46D6CC262B0C9_1908691214 = (aNode.getLocalName() == null);
                bNode = b.getNamedItem(aNode.getNodeName());
                bNode = b.getNamedItemNS(aNode.getNamespaceURI(), aNode.getLocalName());
                {
                    boolean var7A836BDFDA6DC612AD6664CCCED1DCCF_1602860785 = (bNode == null || !aNode.isEqualNode(bNode));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.428 -0400", hash_original_method = "654AD0B7653E61CCCCF2A287DD7A9FCF", hash_generated_method = "53A2B3255A7D8E96F9E4F41FA6408AE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Object getFeature(String feature, String version) {
        dsTaint.addTaint(feature);
        dsTaint.addTaint(version);
        {
            boolean var66F05B8060F922898335F669B4E1D7F3_1445277251 = (isSupported(feature, version));
        } //End flattened ternary
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return isSupported(feature, version) ? this : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.429 -0400", hash_original_method = "9F34FDEA3DB7CC58B5A8B86C5F6353A5", hash_generated_method = "1444129100A7C1960CBAE79D081109D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Object setUserData(String key, Object data, UserDataHandler handler) {
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(key);
        dsTaint.addTaint(handler.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        Map<String, UserData> map;
        map = document.getUserDataMap(this);
        UserData previous;
        previous = map.remove(key);
        previous = map.put(key, new UserData(data, handler));
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.429 -0400", hash_original_method = "B29B782E95D64D942AA9D9D3C7EEF744", hash_generated_method = "807649D60BFC2BF8E8A928FB758D1409")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Object getUserData(String key) {
        dsTaint.addTaint(key);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        Map<String, UserData> map;
        map = document.getUserDataMapForRead(this);
        UserData userData;
        userData = map.get(key);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //Map<String, UserData> map = document.getUserDataMapForRead(this);
        //UserData userData = map.get(key);
        //return userData != null ? userData.value : null;
    }

    
    static class UserData {
        Object value;
        UserDataHandler handler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.430 -0400", hash_original_method = "0B6C19B4FFBA791689124EA47788F25F", hash_generated_method = "8CBF5F891B79E93820423EA9B4A762D0")
        @DSModeled(DSC.SAFE)
         UserData(Object value, UserDataHandler handler) {
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(handler.dsTaint);
            // ---------- Original Method ----------
            //this.value = value;
            //this.handler = handler;
        }

        
    }


    
    private static final NodeList EMPTY_LIST = new NodeListImpl();
    static final TypeInfo NULL_TYPE_INFO = new TypeInfo() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.430 -0400", hash_original_method = "D6670B1956B399E1F4484C7409D24E32", hash_generated_method = "4EF75A949DAFE91F0C20CFE6B560CA29")
        @DSModeled(DSC.SAFE)
        public String getTypeName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.430 -0400", hash_original_method = "076EDBD720D64B1CD58A3E3161F3A408", hash_generated_method = "11F62CCF0A734E065E9B670738734377")
        @DSModeled(DSC.SAFE)
        public String getTypeNamespace() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.430 -0400", hash_original_method = "C5EC47855C2BF530753D3BD268C04AD2", hash_generated_method = "C093EF368F2059921AB2AEF08A23ADDF")
        @DSModeled(DSC.SAFE)
        public boolean isDerivedFrom(
                String typeNamespaceArg, String typeNameArg, int derivationMethod) {
            dsTaint.addTaint(typeNameArg);
            dsTaint.addTaint(derivationMethod);
            dsTaint.addTaint(typeNamespaceArg);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return false;
        }

        
}; //Transformed anonymous class
}

