package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    boolean namespaceAware;
    String namespaceURI;
    String prefix;
    String localName;
    private List<AttrImpl> attributes = new ArrayList<AttrImpl>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.266 -0400", hash_original_method = "E83037DBBA9A213D892AFBAECFD42006", hash_generated_method = "E98A3C967917180100118DBAC0D5A99D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ElementImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        dsTaint.addTaint(namespaceURI);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(qualifiedName);
        setNameNS(this, namespaceURI, qualifiedName);
        // ---------- Original Method ----------
        //setNameNS(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.266 -0400", hash_original_method = "D2CD0310D5C8F85822C82439B7C2ED0A", hash_generated_method = "37E71A6084FE6738821EAE7B6A164867")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ElementImpl(DocumentImpl document, String name) {
        super(document);
        dsTaint.addTaint(document.dsTaint);
        dsTaint.addTaint(name);
        setName(this, name);
        // ---------- Original Method ----------
        //setName(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.268 -0400", hash_original_method = "33812125B5F046930FB02168EEB43D40", hash_generated_method = "DDABB337A50A86CD957CF52550EDC981")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int indexOfAttribute(String name) {
        dsTaint.addTaint(name);
        {
            int i;
            i = 0;
            boolean var4BF9AA01498A302A953E7B72FFE2E6DF_667827315 = (i < attributes.size());
            {
                AttrImpl attr;
                attr = attributes.get(i);
                {
                    boolean var7BAD3BFC039F765668FE34CB011AC143_1627100077 = (Objects.equal(name, attr.getNodeName()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (int i = 0; i < attributes.size(); i++) {
            //AttrImpl attr = attributes.get(i);
            //if (Objects.equal(name, attr.getNodeName())) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.268 -0400", hash_original_method = "7BDB91D541F3C8F5E0B377A9C520D55B", hash_generated_method = "F016BC999BF5E506AFA0F9113B06420B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int indexOfAttributeNS(String namespaceURI, String localName) {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(namespaceURI);
        {
            int i;
            i = 0;
            boolean var4BF9AA01498A302A953E7B72FFE2E6DF_743226198 = (i < attributes.size());
            {
                AttrImpl attr;
                attr = attributes.get(i);
                {
                    boolean var862ADD8BB15D0BE1810DD35AF160FA42_1788447760 = (Objects.equal(namespaceURI, attr.getNamespaceURI())
                    && Objects.equal(localName, attr.getLocalName()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //for (int i = 0; i < attributes.size(); i++) {
            //AttrImpl attr = attributes.get(i);
            //if (Objects.equal(namespaceURI, attr.getNamespaceURI())
                    //&& Objects.equal(localName, attr.getLocalName())) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.269 -0400", hash_original_method = "813C4DD10F102D6D885192D956222478", hash_generated_method = "77FE2137DD6D56AC87429937304242E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAttribute(String name) {
        dsTaint.addTaint(name);
        Attr attr;
        attr = getAttributeNode(name);
        String var37846A278B3310440E7BC7A0C28A7B94_893138170 = (attr.getValue());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Attr attr = getAttributeNode(name);
        //if (attr == null) {
            //return "";
        //}
        //return attr.getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.269 -0400", hash_original_method = "2AD352ABD4B75CC40A48A87FB5C80EF1", hash_generated_method = "0BCACF27D0EBE04179FF6C4CEE0A80B8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getAttributeNS(String namespaceURI, String localName) {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(namespaceURI);
        Attr attr;
        attr = getAttributeNodeNS(namespaceURI, localName);
        String var37846A278B3310440E7BC7A0C28A7B94_1592060641 = (attr.getValue());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Attr attr = getAttributeNodeNS(namespaceURI, localName);
        //if (attr == null) {
            //return "";
        //}
        //return attr.getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.269 -0400", hash_original_method = "83D3ED81624F77A7E713E4996ABE0363", hash_generated_method = "322A4DFD056DC100B56C82C1EF4E8713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttrImpl getAttributeNode(String name) {
        dsTaint.addTaint(name);
        int i;
        i = indexOfAttribute(name);
        AttrImpl var3C2A4BE06C19D5D5918C2AE234A31899_316092261 = (attributes.get(i));
        return (AttrImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int i = indexOfAttribute(name);
        //if (i == -1) {
            //return null;
        //}
        //return attributes.get(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.270 -0400", hash_original_method = "3B62D6330977637E22606F97FB7DAA33", hash_generated_method = "82FEC936123E2D2F47875EB48AE942FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttrImpl getAttributeNodeNS(String namespaceURI, String localName) {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(namespaceURI);
        int i;
        i = indexOfAttributeNS(namespaceURI, localName);
        AttrImpl var3C2A4BE06C19D5D5918C2AE234A31899_796430423 = (attributes.get(i));
        return (AttrImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int i = indexOfAttributeNS(namespaceURI, localName);
        //if (i == -1) {
            //return null;
        //}
        //return attributes.get(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.270 -0400", hash_original_method = "DB6D276ECDED2CB7A7381953F02FE1C2", hash_generated_method = "4A1337DF3FEC3AA72F7ABFEC3A6D6941")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public NamedNodeMap getAttributes() {
        NamedNodeMap varB210BA0DFC4F60105F412440B19BBDDF_1837472038 = (new ElementAttrNamedNodeMapImpl());
        return (NamedNodeMap)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ElementAttrNamedNodeMapImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.275 -0400", hash_original_method = "75972D234B77F7219B8A807D51F2F4BE", hash_generated_method = "43B12D8E93E372DD85229BEA53E987A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Element getElementById(String name) {
        dsTaint.addTaint(name);
        {
            Iterator<Attr> var85569F768AA62BA2E033CE436AD30008_821504370 = (attributes).iterator();
            var85569F768AA62BA2E033CE436AD30008_821504370.hasNext();
            Attr attr = var85569F768AA62BA2E033CE436AD30008_821504370.next();
            {
                {
                    boolean varDE620A923FB4415A0C3EC0AB13170E4C_1351102971 = (attr.isId() && name.equals(attr.getValue()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAA388FAC5E10062A184F3A6F89066921_260474750 = (name.equals(getAttribute("id")));
        } //End collapsed parenthetic
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_1701851986 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_1701851986.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_1701851986.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_1098433325 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        Element element;
                        element = ((ElementImpl) node).getElementById(name);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Element)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (Attr attr : attributes) {
            //if (attr.isId() && name.equals(attr.getValue())) {
                //return this;
            //}
        //}
        //if (name.equals(getAttribute("id"))) {
            //return this;
        //}
        //for (NodeImpl node : children) {
            //if (node.getNodeType() == Node.ELEMENT_NODE) {
                //Element element = ((ElementImpl) node).getElementById(name);
                //if (element != null) {
                    //return element;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.276 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "447F9FCA8D0FC92C69CF6A8F635BAD93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NodeList getElementsByTagName(String name) {
        dsTaint.addTaint(name);
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagName(result, name);
        return (NodeList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagName(result, name);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.276 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "2BA2BA008BAF46E3B6A4998B4C5FD0BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(namespaceURI);
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        return (NodeList)dsTaint.getTaint();
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagNameNS(result, namespaceURI, localName);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.276 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "F1A1D9C71B0FC51F77DD5BAEDAB15A2D")
    @DSModeled(DSC.SAFE)
    @Override
    public String getLocalName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return namespaceAware ? localName : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.276 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "5E28B0040100F10E7FA051BB8138BF3A")
    @DSModeled(DSC.SAFE)
    @Override
    public String getNamespaceURI() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return namespaceURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.276 -0400", hash_original_method = "24A50BD0D938263A925A0CD0D8B09D61", hash_generated_method = "52C5D9F50A70F1856F4C04B8A6CFA8B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getNodeName() {
        String var3652CBF98B554AB602053B15736AE1E2_536905158 = (getTagName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getTagName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.276 -0400", hash_original_method = "8EDB6CFF77634EC46F3FE6E39D5C4072", hash_generated_method = "DDD55574CEB43A6BA1DFECBE66C40075")
    @DSModeled(DSC.SAFE)
    public short getNodeType() {
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return Node.ELEMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.277 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "ED5F2F04082C1BA63A051B667FDB20B2")
    @DSModeled(DSC.SAFE)
    @Override
    public String getPrefix() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.277 -0400", hash_original_method = "84D6D79E2DD8ACB2C7098589FE413C76", hash_generated_method = "B8E06D0B0B6DFC98C0DC5924C3301C64")
    @DSModeled(DSC.SAFE)
    public String getTagName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return prefix != null
                //? prefix + ":" + localName
                //: localName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.277 -0400", hash_original_method = "6C8F2E9D9AC7653B36D8183C37FDC271", hash_generated_method = "D34A0112ADB5D213612B92AA5CE35FE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasAttribute(String name) {
        dsTaint.addTaint(name);
        boolean var9A6B46C7A05A149C7FD72F2126229268_450420505 = (indexOfAttribute(name) != -1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return indexOfAttribute(name) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.277 -0400", hash_original_method = "A72242585FC8C818B78134FE05A6EE18", hash_generated_method = "5995E53D698332CF42E83D42C6A57256")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(namespaceURI);
        boolean varFD44CF5CE0E790CFF22EA7E5CF2E4CA0_473197808 = (indexOfAttributeNS(namespaceURI, localName) != -1);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return indexOfAttributeNS(namespaceURI, localName) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.278 -0400", hash_original_method = "F148456BA584CDD324D3AD480B7851B4", hash_generated_method = "255697ABF31290BEE735C7863EF9D971")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean hasAttributes() {
        boolean varC14277A36C5456E69030CF13195697F1_2086196991 = (!attributes.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return !attributes.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.278 -0400", hash_original_method = "8DBF320E88520709ECE3A3A8169ED4DA", hash_generated_method = "133BBE67C57BE0BF41619E9A0DE39FD7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAttribute(String name) throws DOMException {
        dsTaint.addTaint(name);
        int i;
        i = indexOfAttribute(name);
        {
            attributes.remove(i);
        } //End block
        // ---------- Original Method ----------
        //int i = indexOfAttribute(name);
        //if (i != -1) {
            //attributes.remove(i);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.278 -0400", hash_original_method = "DB944C5E777E2AB6A4CA622A526DBBB8", hash_generated_method = "28405368F7C654CAA4B9807669A62334")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(namespaceURI);
        int i;
        i = indexOfAttributeNS(namespaceURI, localName);
        {
            attributes.remove(i);
        } //End block
        // ---------- Original Method ----------
        //int i = indexOfAttributeNS(namespaceURI, localName);
        //if (i != -1) {
            //attributes.remove(i);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.278 -0400", hash_original_method = "48A4F4D8663A7BAF5C33913CE98C9411", hash_generated_method = "7B29F96AA72E62F3448882D39E0B1AA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
        dsTaint.addTaint(oldAttr.dsTaint);
        AttrImpl oldAttrImpl;
        oldAttrImpl = (AttrImpl) oldAttr;
        {
            boolean var5F8EC0C033C14176F1E7190A783BB3E6_908134374 = (oldAttrImpl.getOwnerElement() != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } //End block
        } //End collapsed parenthetic
        attributes.remove(oldAttrImpl);
        oldAttrImpl.ownerElement = null;
        return (Attr)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AttrImpl oldAttrImpl = (AttrImpl) oldAttr;
        //if (oldAttrImpl.getOwnerElement() != this) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
        //}
        //attributes.remove(oldAttrImpl);
        //oldAttrImpl.ownerElement = null;
        //return oldAttrImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.278 -0400", hash_original_method = "6DCEAAD8535FDF367A6D4293F8DE36CE", hash_generated_method = "6F603B23B0E8225D8DA34D33838CE05A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAttribute(String name, String value) throws DOMException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(value);
        Attr attr;
        attr = getAttributeNode(name);
        {
            attr = document.createAttribute(name);
            setAttributeNode(attr);
        } //End block
        attr.setValue(value);
        // ---------- Original Method ----------
        //Attr attr = getAttributeNode(name);
        //if (attr == null) {
            //attr = document.createAttribute(name);
            //setAttributeNode(attr);
        //}
        //attr.setValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.279 -0400", hash_original_method = "F2270012ECC9DDE7A199A2B08906CDAC", hash_generated_method = "8C5B826B19C53F255CF94703CF36F9E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAttributeNS(String namespaceURI, String qualifiedName,
            String value) throws DOMException {
        dsTaint.addTaint(namespaceURI);
        dsTaint.addTaint(qualifiedName);
        dsTaint.addTaint(value);
        Attr attr;
        attr = getAttributeNodeNS(namespaceURI, qualifiedName);
        {
            attr = document.createAttributeNS(namespaceURI, qualifiedName);
            setAttributeNodeNS(attr);
        } //End block
        attr.setValue(value);
        // ---------- Original Method ----------
        //Attr attr = getAttributeNodeNS(namespaceURI, qualifiedName);
        //if (attr == null) {
            //attr = document.createAttributeNS(namespaceURI, qualifiedName);
            //setAttributeNodeNS(attr);
        //}
        //attr.setValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.279 -0400", hash_original_method = "2863AD660D70C60FE387E2DF61C003C1", hash_generated_method = "3D4F5215BBA7A75AE82A300AAE05857A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Attr setAttributeNode(Attr newAttr) throws DOMException {
        dsTaint.addTaint(newAttr.dsTaint);
        AttrImpl newAttrImpl;
        newAttrImpl = (AttrImpl) newAttr;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var877A67893D24F6B22E8A0E6DF1EAF1B0_2085341312 = (newAttrImpl.getOwnerElement() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
            } //End block
        } //End collapsed parenthetic
        AttrImpl oldAttrImpl;
        oldAttrImpl = null;
        int i;
        i = indexOfAttribute(newAttr.getName());
        {
            oldAttrImpl = attributes.get(i);
            attributes.remove(i);
        } //End block
        attributes.add(newAttrImpl);
        newAttrImpl.ownerElement = this;
        return (Attr)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AttrImpl newAttrImpl = (AttrImpl) newAttr;
        //if (newAttrImpl.document != this.document) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //if (newAttrImpl.getOwnerElement() != null) {
            //throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
        //}
        //AttrImpl oldAttrImpl = null;
        //int i = indexOfAttribute(newAttr.getName());
        //if (i != -1) {
            //oldAttrImpl = attributes.get(i);
            //attributes.remove(i);
        //}
        //attributes.add(newAttrImpl);
        //newAttrImpl.ownerElement = this;
        //return oldAttrImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.279 -0400", hash_original_method = "1229E8AF3668CCD52190CAB83AB0EAC8", hash_generated_method = "78EBD523B9FA8066DB0AA5CCE339CE90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
        dsTaint.addTaint(newAttr.dsTaint);
        AttrImpl newAttrImpl;
        newAttrImpl = (AttrImpl) newAttr;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var877A67893D24F6B22E8A0E6DF1EAF1B0_1116409522 = (newAttrImpl.getOwnerElement() != null);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
            } //End block
        } //End collapsed parenthetic
        AttrImpl oldAttrImpl;
        oldAttrImpl = null;
        int i;
        i = indexOfAttributeNS(newAttr.getNamespaceURI(), newAttr.getLocalName());
        {
            oldAttrImpl = attributes.get(i);
            attributes.remove(i);
        } //End block
        attributes.add(newAttrImpl);
        newAttrImpl.ownerElement = this;
        return (Attr)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AttrImpl newAttrImpl = (AttrImpl) newAttr;
        //if (newAttrImpl.document != this.document) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //if (newAttrImpl.getOwnerElement() != null) {
            //throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, null);
        //}
        //AttrImpl oldAttrImpl = null;
        //int i = indexOfAttributeNS(newAttr.getNamespaceURI(), newAttr.getLocalName());
        //if (i != -1) {
            //oldAttrImpl = attributes.get(i);
            //attributes.remove(i);
        //}
        //attributes.add(newAttrImpl);
        //newAttrImpl.ownerElement = this;
        //return oldAttrImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.280 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "0CB7FC42C6CFB8F1AC6AE794166FD516")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setPrefix(String prefix) {
        dsTaint.addTaint(prefix);
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        // ---------- Original Method ----------
        //this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.280 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "F627AC6B24CA05AEF1200312D3FA4E96")
    @DSModeled(DSC.SAFE)
    public TypeInfo getSchemaTypeInfo() {
        return (TypeInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return NULL_TYPE_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.280 -0400", hash_original_method = "E2D0D43F42925D6B235314ECDF3F88D2", hash_generated_method = "F56DA2E0E770197B119A46F9E415EDEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIdAttribute(String name, boolean isId) throws DOMException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(isId);
        AttrImpl attr;
        attr = getAttributeNode(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + name);
        } //End block
        attr.isId = isId;
        // ---------- Original Method ----------
        //AttrImpl attr = getAttributeNode(name);
        //if (attr == null) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR,
                    //"No such attribute: " + name);
        //}
        //attr.isId = isId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.280 -0400", hash_original_method = "EB4B24B3B95C74A915F87535C0F28019", hash_generated_method = "AEDA3C35DDB1BA8529549287898302D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIdAttributeNS(String namespaceURI, String localName,
            boolean isId) throws DOMException {
        dsTaint.addTaint(localName);
        dsTaint.addTaint(namespaceURI);
        dsTaint.addTaint(isId);
        AttrImpl attr;
        attr = getAttributeNodeNS(namespaceURI, localName);
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + namespaceURI +  " " + localName);
        } //End block
        attr.isId = isId;
        // ---------- Original Method ----------
        //AttrImpl attr = getAttributeNodeNS(namespaceURI, localName);
        //if (attr == null) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR,
                    //"No such attribute: " + namespaceURI +  " " + localName);
        //}
        //attr.isId = isId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.281 -0400", hash_original_method = "D45D107EAB7744EE0777BE918C2E0DD2", hash_generated_method = "F9863DF5451534EAF0B6DBB337273B53")
    @DSModeled(DSC.SAFE)
    public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
        dsTaint.addTaint(isId);
        dsTaint.addTaint(idAttr.dsTaint);
        ((AttrImpl) idAttr).isId = isId;
        // ---------- Original Method ----------
        //((AttrImpl) idAttr).isId = isId;
    }

    
    public class ElementAttrNamedNodeMapImpl implements NamedNodeMap {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.281 -0400", hash_original_method = "5D43BEB1BC3FBD92A3FCE5698EEA9A20", hash_generated_method = "5D43BEB1BC3FBD92A3FCE5698EEA9A20")
                public ElementAttrNamedNodeMapImpl ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.281 -0400", hash_original_method = "FF1F71CDD63994FD93D39F9EA196EECF", hash_generated_method = "79A0B3DD4FC00A484BCE2CD63D4BC825")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getLength() {
            int var885D16ACBA3AAF937512B6C61A3B731A_153633732 = (ElementImpl.this.attributes.size());
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return ElementImpl.this.attributes.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.281 -0400", hash_original_method = "DC316EFAFE6C9719F9A6712C7C0724A1", hash_generated_method = "E14D995E7D747DA6CDBCBD07C2824965")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int indexOfItem(String name) {
            dsTaint.addTaint(name);
            int var4539B068F44D8760B8121FFD1C636043_571560208 = (ElementImpl.this.indexOfAttribute(name));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return ElementImpl.this.indexOfAttribute(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.281 -0400", hash_original_method = "258D65E063DA88D4950E14323AAE31E6", hash_generated_method = "134545C4E900B35201C678B5FDDE4959")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int indexOfItemNS(String namespaceURI, String localName) {
            dsTaint.addTaint(localName);
            dsTaint.addTaint(namespaceURI);
            int var6BB86ADC07E7A5ED0C713094AF81B0B0_780002161 = (ElementImpl.this.indexOfAttributeNS(namespaceURI, localName));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return ElementImpl.this.indexOfAttributeNS(namespaceURI, localName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.281 -0400", hash_original_method = "5386255E2AB4AB2C7C1C9B01DBB08720", hash_generated_method = "C5AF27EBA7A87B83523A08D7D5BA5E43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Node getNamedItem(String name) {
            dsTaint.addTaint(name);
            Node var0894CFAE661DAA7DA5C5708C74F87631_1261217443 = (ElementImpl.this.getAttributeNode(name));
            return (Node)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ElementImpl.this.getAttributeNode(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.282 -0400", hash_original_method = "4A42E6CB38C61058D8EEC911A360EDF7", hash_generated_method = "A08FE3D758BB4CFA8F8557502C8D92B7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Node getNamedItemNS(String namespaceURI, String localName) {
            dsTaint.addTaint(localName);
            dsTaint.addTaint(namespaceURI);
            Node varFF6583D8C43F1DB76B12D4F8E32DDD4F_97776731 = (ElementImpl.this.getAttributeNodeNS(namespaceURI, localName));
            return (Node)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ElementImpl.this.getAttributeNodeNS(namespaceURI, localName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.282 -0400", hash_original_method = "F60AE240A182D1B0B5E9071C74F61EEF", hash_generated_method = "71AD668CA29D5B424AAB2552FC7F6FDD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Node item(int index) {
            dsTaint.addTaint(index);
            Node var27AB385494C42D227DE5B4E7CB1B858D_194330201 = (ElementImpl.this.attributes.get(index));
            return (Node)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return ElementImpl.this.attributes.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.282 -0400", hash_original_method = "92540DEE2EDFF119EB60FC0ECC313E2F", hash_generated_method = "5162BFA4A11D66A11520EF5843EE0EB1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Node removeNamedItem(String name) throws DOMException {
            dsTaint.addTaint(name);
            int i;
            i = indexOfItem(name);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } //End block
            Node var9197C830AA31C0F1C59CE7E66ADEFCC9_202910481 = (ElementImpl.this.attributes.remove(i));
            return (Node)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int i = indexOfItem(name);
            //if (i == -1) {
                //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            //}
            //return ElementImpl.this.attributes.remove(i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.282 -0400", hash_original_method = "5947BF939F7AE1F8A4D4CDE5B6951547", hash_generated_method = "B55EC68B27C5EAA433CF74F7E7BE5C35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException {
            dsTaint.addTaint(localName);
            dsTaint.addTaint(namespaceURI);
            int i;
            i = indexOfItemNS(namespaceURI, localName);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } //End block
            Node var9197C830AA31C0F1C59CE7E66ADEFCC9_510997261 = (ElementImpl.this.attributes.remove(i));
            return (Node)dsTaint.getTaint();
            // ---------- Original Method ----------
            //int i = indexOfItemNS(namespaceURI, localName);
            //if (i == -1) {
                //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            //}
            //return ElementImpl.this.attributes.remove(i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.283 -0400", hash_original_method = "5D95624F12CAAE730B29BD47EADFC40A", hash_generated_method = "1699D3770A0FE458CBEA07DE37FC193E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Node setNamedItem(Node arg) throws DOMException {
            dsTaint.addTaint(arg.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
            Node var1976DA9B456B733DC53CA7D27723FF1C_2041356030 = (ElementImpl.this.setAttributeNode((Attr)arg));
            return (Node)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (!(arg instanceof Attr)) {
                //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            //}
            //return ElementImpl.this.setAttributeNode((Attr)arg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.283 -0400", hash_original_method = "74F8A255439FFDD82EF1D14936D16522", hash_generated_method = "A0980747F055AD150B59B968F97224AD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Node setNamedItemNS(Node arg) throws DOMException {
            dsTaint.addTaint(arg.dsTaint);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
            Node var91A95665E4F43D8F6C059A6751DE7A7E_802231156 = (ElementImpl.this.setAttributeNodeNS((Attr)arg));
            return (Node)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (!(arg instanceof Attr)) {
                //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            //}
            //return ElementImpl.this.setAttributeNodeNS((Attr)arg);
        }

        
    }


    
}

