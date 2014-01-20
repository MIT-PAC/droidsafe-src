package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import libcore.util.Objects;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

public class ElementImpl extends InnerNodeImpl implements Element {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.614 -0500", hash_original_field = "6DED3D0909D027805E22F95BA58508AE", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.616 -0500", hash_original_field = "5B184DBF8D93287A0F0C8BC78758CAB7", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.618 -0500", hash_original_field = "D07D332701F9B92847141D46D8B2C7CF", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.620 -0500", hash_original_field = "69F110BF2CAEA76B4D1C533597A16878", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.623 -0500", hash_original_field = "6408F542D6B012397242437C2E1CE163", hash_generated_field = "370A7E27C76BC902168F8323D6CEB238")

    private List<AttrImpl> attributes = new ArrayList<AttrImpl>();

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.626 -0500", hash_original_method = "E83037DBBA9A213D892AFBAECFD42006", hash_generated_method = "E83037DBBA9A213D892AFBAECFD42006")
    
ElementImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        setNameNS(this, namespaceURI, qualifiedName);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.628 -0500", hash_original_method = "D2CD0310D5C8F85822C82439B7C2ED0A", hash_generated_method = "D2CD0310D5C8F85822C82439B7C2ED0A")
    
ElementImpl(DocumentImpl document, String name) {
        super(document);
        setName(this, name);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.630 -0500", hash_original_method = "33812125B5F046930FB02168EEB43D40", hash_generated_method = "23F99DD0B0D8518DD30692A456887E11")
    
private int indexOfAttribute(String name) {
        for (int i = 0; i < attributes.size(); i++) {
            AttrImpl attr = attributes.get(i);
            if (Objects.equal(name, attr.getNodeName())) {
                return i;
            }
        }

        return -1;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.633 -0500", hash_original_method = "7BDB91D541F3C8F5E0B377A9C520D55B", hash_generated_method = "FB9659831FD5F15AB2256030C7D30848")
    
private int indexOfAttributeNS(String namespaceURI, String localName) {
        for (int i = 0; i < attributes.size(); i++) {
            AttrImpl attr = attributes.get(i);
            if (Objects.equal(namespaceURI, attr.getNamespaceURI())
                    && Objects.equal(localName, attr.getLocalName())) {
                return i;
            }
        }

        return -1;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.635 -0500", hash_original_method = "813C4DD10F102D6D885192D956222478", hash_generated_method = "64C63F1020C09A8001E8D22C9C233A8A")
    
public String getAttribute(String name) {
        Attr attr = getAttributeNode(name);

        if (attr == null) {
            return "";
        }

        return attr.getValue();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.637 -0500", hash_original_method = "2AD352ABD4B75CC40A48A87FB5C80EF1", hash_generated_method = "540AE61A32C69F3F77346A7063A09A6D")
    
public String getAttributeNS(String namespaceURI, String localName) {
        Attr attr = getAttributeNodeNS(namespaceURI, localName);

        if (attr == null) {
            return "";
        }

        return attr.getValue();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.639 -0500", hash_original_method = "83D3ED81624F77A7E713E4996ABE0363", hash_generated_method = "9AED552B1AF24A10DF029E5953ECD409")
    
public AttrImpl getAttributeNode(String name) {
        int i = indexOfAttribute(name);

        if (i == -1) {
            return null;
        }

        return attributes.get(i);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.641 -0500", hash_original_method = "3B62D6330977637E22606F97FB7DAA33", hash_generated_method = "2282D3125F8E69F0FBA11413D5601053")
    
public AttrImpl getAttributeNodeNS(String namespaceURI, String localName) {
        int i = indexOfAttributeNS(namespaceURI, localName);

        if (i == -1) {
            return null;
        }

        return attributes.get(i);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.644 -0500", hash_original_method = "DB6D276ECDED2CB7A7381953F02FE1C2", hash_generated_method = "D01AF0B2F7BD79BB194F63F371D9FE26")
    
@Override
    public NamedNodeMap getAttributes() {
        return new ElementAttrNamedNodeMapImpl();
    }

    /**
     * This implementation walks the entire document looking for an element
     * with the given ID attribute. We should consider adding an index to speed
     * navigation of large documents.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.646 -0500", hash_original_method = "75972D234B77F7219B8A807D51F2F4BE", hash_generated_method = "384AB3B70029125C168DD9A224D011F9")
    
Element getElementById(String name) {
        for (Attr attr : attributes) {
            if (attr.isId() && name.equals(attr.getValue())) {
                return this;
            }
        }

        /*
         * TODO: Remove this behavior.
         * The spec explicitly says that this is a bad idea. From
         * Document.getElementById(): "Attributes with the name "ID"
         * or "id" are not of type ID unless so defined.
         */
        if (name.equals(getAttribute("id"))) {
            return this;
        }

        for (NodeImpl node : children) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = ((ElementImpl) node).getElementById(name);
                if (element != null) {
                    return element;
                }
            }
        }

        return null;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.648 -0500", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "168E7265B92B25940BE256C44126574B")
    
public NodeList getElementsByTagName(String name) {
        NodeListImpl result = new NodeListImpl();
        getElementsByTagName(result, name);
        return result;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.650 -0500", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "564D369733C1D7372018653373C517B0")
    
public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        NodeListImpl result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        return result;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.653 -0500", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "F987DC43BC4FDF1130057C0E487D8DB9")
    
@Override
    public String getLocalName() {
        return namespaceAware ? localName : null;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.655 -0500", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "5C655AA6CF7D48092CB41BEF30260410")
    
@Override
    public String getNamespaceURI() {
        return namespaceURI;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.657 -0500", hash_original_method = "24A50BD0D938263A925A0CD0D8B09D61", hash_generated_method = "4B3C0890BB8DB7FFA65115C787FEE909")
    
@Override
    public String getNodeName() {
        return getTagName();
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.659 -0500", hash_original_method = "8EDB6CFF77634EC46F3FE6E39D5C4072", hash_generated_method = "ACC664DFF7152508BC19C53725D96D5C")
    
public short getNodeType() {
        return Node.ELEMENT_NODE;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.662 -0500", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "C905C4F3356722AF0C0E9CD6FA7F3CCD")
    
@Override
    public String getPrefix() {
        return prefix;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.664 -0500", hash_original_method = "84D6D79E2DD8ACB2C7098589FE413C76", hash_generated_method = "111EF6F217D5B08089301545BF5647B6")
    
public String getTagName() {
        return prefix != null
                ? prefix + ":" + localName
                : localName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.666 -0500", hash_original_method = "6C8F2E9D9AC7653B36D8183C37FDC271", hash_generated_method = "8D0D349A94D9AE31BDC7F2893A4A16E8")
    
public boolean hasAttribute(String name) {
        return indexOfAttribute(name) != -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.669 -0500", hash_original_method = "A72242585FC8C818B78134FE05A6EE18", hash_generated_method = "F27DA942ABA8CC20D3D758A5C7AED8B9")
    
public boolean hasAttributeNS(String namespaceURI, String localName) {
        return indexOfAttributeNS(namespaceURI, localName) != -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.672 -0500", hash_original_method = "F148456BA584CDD324D3AD480B7851B4", hash_generated_method = "0387505F6E78C68FF17D926F6E7F01AF")
    
@Override
    public boolean hasAttributes() {
        return !attributes.isEmpty();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.674 -0500", hash_original_method = "8DBF320E88520709ECE3A3A8169ED4DA", hash_generated_method = "E2CAA4C860C49A864A062647EB36A9D1")
    
public void removeAttribute(String name) throws DOMException {
        int i = indexOfAttribute(name);

        if (i != -1) {
            attributes.remove(i);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.676 -0500", hash_original_method = "DB944C5E777E2AB6A4CA622A526DBBB8", hash_generated_method = "849F2B2C2F5D736C1C55003C18C4C04E")
    
public void removeAttributeNS(String namespaceURI, String localName)
            throws DOMException {
        int i = indexOfAttributeNS(namespaceURI, localName);

        if (i != -1) {
            attributes.remove(i);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.678 -0500", hash_original_method = "48A4F4D8663A7BAF5C33913CE98C9411", hash_generated_method = "A71E6EF73959F8B04BB139B9323C10C2")
    
public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
        AttrImpl oldAttrImpl = (AttrImpl) oldAttr;

        if (oldAttrImpl.getOwnerElement() != this) {
            throw new DOMException(DOMException.NOT_FOUND_ERR, null);
        }

        attributes.remove(oldAttrImpl);
        oldAttrImpl.ownerElement = null;

        return oldAttrImpl;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.681 -0500", hash_original_method = "6DCEAAD8535FDF367A6D4293F8DE36CE", hash_generated_method = "5B276010C8E325BCDCF40DB6AA150F89")
    
public void setAttribute(String name, String value) throws DOMException {
        Attr attr = getAttributeNode(name);

        if (attr == null) {
            attr = document.createAttribute(name);
            setAttributeNode(attr);
        }

        attr.setValue(value);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.683 -0500", hash_original_method = "F2270012ECC9DDE7A199A2B08906CDAC", hash_generated_method = "3620E44C66FED951B063BCCAF29B3F66")
    
public void setAttributeNS(String namespaceURI, String qualifiedName,
            String value) throws DOMException {
        Attr attr = getAttributeNodeNS(namespaceURI, qualifiedName);

        if (attr == null) {
            attr = document.createAttributeNS(namespaceURI, qualifiedName);
            setAttributeNodeNS(attr);
        }

        attr.setValue(value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.686 -0500", hash_original_method = "2863AD660D70C60FE387E2DF61C003C1", hash_generated_method = "C788641B10CD6621A8E26F9AB87C9258")
    
public Attr setAttributeNode(Attr newAttr) throws DOMException {
        AttrImpl newAttrImpl = (AttrImpl) newAttr;

        if (newAttrImpl.document != this.document) {
            throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        }

        if (newAttrImpl.getOwnerElement() != null) {
            throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
        }

        AttrImpl oldAttrImpl = null;

        int i = indexOfAttribute(newAttr.getName());
        if (i != -1) {
            oldAttrImpl = attributes.get(i);
            attributes.remove(i);
        }

        attributes.add(newAttrImpl);
        newAttrImpl.ownerElement = this;

        return oldAttrImpl;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.689 -0500", hash_original_method = "1229E8AF3668CCD52190CAB83AB0EAC8", hash_generated_method = "16EE4AE222F765E95F8A96EF06AAFDB2")
    
public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
        AttrImpl newAttrImpl = (AttrImpl) newAttr;

        if (newAttrImpl.document != this.document) {
            throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        }

        if (newAttrImpl.getOwnerElement() != null) {
            throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
        }

        AttrImpl oldAttrImpl = null;

        int i = indexOfAttributeNS(newAttr.getNamespaceURI(), newAttr.getLocalName());
        if (i != -1) {
            oldAttrImpl = attributes.get(i);
            attributes.remove(i);
        }

        attributes.add(newAttrImpl);
        newAttrImpl.ownerElement = this;

        return oldAttrImpl;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.691 -0500", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "E839C95B45355A666035B4D9E3A8B013")
    
@Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.720 -0500", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "4EB9EC1BDB5787FF00F4421C186C425B")
    
public TypeInfo getSchemaTypeInfo() {
        // TODO: populate this when we support XML Schema
        return NULL_TYPE_INFO;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.722 -0500", hash_original_method = "E2D0D43F42925D6B235314ECDF3F88D2", hash_generated_method = "D987540CB46EE76FE5B329E7D2A301EC")
    
public void setIdAttribute(String name, boolean isId) throws DOMException {
        AttrImpl attr = getAttributeNode(name);
        if (attr == null) {
            throw new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + name);
        }
        attr.isId = isId;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.724 -0500", hash_original_method = "EB4B24B3B95C74A915F87535C0F28019", hash_generated_method = "5A31E3F6B187E70D74CB0E5CC5BC02F4")
    
public void setIdAttributeNS(String namespaceURI, String localName,
            boolean isId) throws DOMException {
        AttrImpl attr = getAttributeNodeNS(namespaceURI, localName);
        if (attr == null) {
            throw new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + namespaceURI +  " " + localName);
        }
        attr.isId = isId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.726 -0500", hash_original_method = "D45D107EAB7744EE0777BE918C2E0DD2", hash_generated_method = "221C36D38484C3DADD354ECDB9301E98")
    
public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
        ((AttrImpl) idAttr).isId = isId;
    }
    
    public class ElementAttrNamedNodeMapImpl implements NamedNodeMap {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.452 -0400", hash_original_method = "4DE56E7A278FE2CED469184A8A1F6E47", hash_generated_method = "4DE56E7A278FE2CED469184A8A1F6E47")
        public ElementAttrNamedNodeMapImpl ()
        {
            //Synthesized constructor
        }

        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.694 -0500", hash_original_method = "FF1F71CDD63994FD93D39F9EA196EECF", hash_generated_method = "A09471171D017419D2F2F222F7DEC4BE")
        
public int getLength() {
            return ElementImpl.this.attributes.size();
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.696 -0500", hash_original_method = "DC316EFAFE6C9719F9A6712C7C0724A1", hash_generated_method = "D6AB8A65CE16BD484A16ABCB1DB029F2")
        
private int indexOfItem(String name) {
            return ElementImpl.this.indexOfAttribute(name);
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.698 -0500", hash_original_method = "258D65E063DA88D4950E14323AAE31E6", hash_generated_method = "4AF2EF9990FEC62BA89EB3833E2D779E")
        
private int indexOfItemNS(String namespaceURI, String localName) {
            return ElementImpl.this.indexOfAttributeNS(namespaceURI, localName);
        }

        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.700 -0500", hash_original_method = "5386255E2AB4AB2C7C1C9B01DBB08720", hash_generated_method = "9EC35E60DE585173C34E79A3D203BDFC")
        
public Node getNamedItem(String name) {
            return ElementImpl.this.getAttributeNode(name);
        }

        @DSSource({DSSourceKind.NETWORK_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.703 -0500", hash_original_method = "4A42E6CB38C61058D8EEC911A360EDF7", hash_generated_method = "CE8F5690EF45A1C10F75F983EC9DDCA2")
        
public Node getNamedItemNS(String namespaceURI, String localName) {
            return ElementImpl.this.getAttributeNodeNS(namespaceURI, localName);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.705 -0500", hash_original_method = "F60AE240A182D1B0B5E9071C74F61EEF", hash_generated_method = "032B1E123904B19A59CA02DB18B455F5")
        
public Node item(int index) {
            return ElementImpl.this.attributes.get(index);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.708 -0500", hash_original_method = "92540DEE2EDFF119EB60FC0ECC313E2F", hash_generated_method = "47326BC5DBCEF8F503D04746BCA6D01B")
        
public Node removeNamedItem(String name) throws DOMException {
            int i = indexOfItem(name);

            if (i == -1) {
                throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            }

            return ElementImpl.this.attributes.remove(i);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.710 -0500", hash_original_method = "5947BF939F7AE1F8A4D4CDE5B6951547", hash_generated_method = "67E02E95D22280C1E1F9222EA6AD09F8")
        
public Node removeNamedItemNS(String namespaceURI, String localName)
                throws DOMException {
            int i = indexOfItemNS(namespaceURI, localName);

            if (i == -1) {
                throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            }

            return ElementImpl.this.attributes.remove(i);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.712 -0500", hash_original_method = "5D95624F12CAAE730B29BD47EADFC40A", hash_generated_method = "BA3510DAF2B2DD9235DD0EC127867BD9")
        
public Node setNamedItem(Node arg) throws DOMException {
            if (!(arg instanceof Attr)) {
                throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            }

            return ElementImpl.this.setAttributeNode((Attr)arg);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:22.716 -0500", hash_original_method = "74F8A255439FFDD82EF1D14936D16522", hash_generated_method = "53AEBE8FC6FF034BFF8EED2E6AD2A16D")
        
public Node setNamedItemNS(Node arg) throws DOMException {
            if (!(arg instanceof Attr)) {
                throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            }

            return ElementImpl.this.setAttributeNodeNS((Attr)arg);
        }
        
    }
    
}

