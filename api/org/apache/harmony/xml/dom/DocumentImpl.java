package org.apache.harmony.xml.dom;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class DocumentImpl extends InnerNodeImpl implements Document {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.358 -0400", hash_original_field = "9A0C2D739DCDFB02BF9A89440A1742BE", hash_generated_field = "02CE798A8CB59B7226C8831D772A3C37")

    private DOMImplementation domImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.359 -0400", hash_original_field = "5C1DDF42AF97D3B8A25E52B51295CBCC", hash_generated_field = "4C2B5AB6B1E4F28DC9582765A0F90963")

    private DOMConfigurationImpl domConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.359 -0400", hash_original_field = "7F008BD20578B4549518F8F2105F0B56", hash_generated_field = "677F469BCAF22AAF9C9A1BCAA78B217D")

    private String documentUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.359 -0400", hash_original_field = "095EA6E25F03C3DC620F669B4CE91A23", hash_generated_field = "6E57DD71D7D0E77E0155AE21B6C03BD4")

    private String inputEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.359 -0400", hash_original_field = "CAD97869F74973B5626CFC237B513EAA", hash_generated_field = "656761370EB1B6AB6991B2A74412BA8B")

    private String xmlEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.359 -0400", hash_original_field = "D937E495C2709421D5BB34439EB7E5BF", hash_generated_field = "D19F092C2B57A6CC2509D5D658E0ECE5")

    private String xmlVersion = "1.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.359 -0400", hash_original_field = "D57C79C8DAC76C34330A7438298EC2AF", hash_generated_field = "ED1ABCCC72304E22012FCF1E2F4242CD")

    private boolean xmlStandalone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.359 -0400", hash_original_field = "A6BEA613612CBF77E8D9A1D2B43F7D75", hash_generated_field = "AEC49EFA08DDCABA663F00B7AA711A75")

    private boolean strictErrorChecking = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.359 -0400", hash_original_field = "83989D7A486A577204E595124E91C3FB", hash_generated_field = "2C2B0316F02F109A0965964EB1E285F6")

    private WeakHashMap<NodeImpl, Map<String, UserData>> nodeToUserData;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.360 -0400", hash_original_method = "163C3C7D3935E830694E09EA8384B9EA", hash_generated_method = "3F556D19054A03740E830ABA0E8C4D3B")
    public  DocumentImpl(DOMImplementationImpl impl, String namespaceURI,
            String qualifiedName, DocumentType doctype, String inputEncoding) {
        super(null);
        addTaint(doctype.getTaint());
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
        this.document = this;
        this.domImplementation = impl;
        this.inputEncoding = inputEncoding;
        if(doctype != null)        
        {
            appendChild(doctype);
        } //End block
        if(qualifiedName != null)        
        {
            appendChild(createElementNS(namespaceURI, qualifiedName));
        } //End block
        // ---------- Original Method ----------
        //this.document = this;
        //this.domImplementation = impl;
        //this.inputEncoding = inputEncoding;
        //if (doctype != null) {
            //appendChild(doctype);
        //}
        //if (qualifiedName != null) {
            //appendChild(createElementNS(namespaceURI, qualifiedName));
        //}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.363 -0400", hash_original_method = "71EB0F41099D1D8D08C83EAF224E8D36", hash_generated_method = "167DBB89EF80A441E8710A4368353B25")
    private NodeImpl shallowCopy(short operation, Node node) {
        addTaint(node.getTaint());
        addTaint(operation);
switch(node.getNodeType()){
        case Node.ATTRIBUTE_NODE:
        AttrImpl attr = (AttrImpl) node;
        AttrImpl attrCopy;
        if(attr.namespaceAware)        
        {
            attrCopy = createAttributeNS(attr.getNamespaceURI(), attr.getLocalName());
            attrCopy.setPrefix(attr.getPrefix());
        } //End block
        else
        {
            attrCopy = createAttribute(attr.getName());
        } //End block
        attrCopy.setNodeValue(attr.getValue());
NodeImpl var52C2AE82F44DFBAB6EB50CDA2D5BD512_584559349 =         attrCopy;
        var52C2AE82F44DFBAB6EB50CDA2D5BD512_584559349.addTaint(taint);
        return var52C2AE82F44DFBAB6EB50CDA2D5BD512_584559349;
        case Node.CDATA_SECTION_NODE:
NodeImpl var8EE5C71A4D490AB3DE8E4FBBCD28DF3B_1518819553 =         createCDATASection(((CharacterData) node).getData());
        var8EE5C71A4D490AB3DE8E4FBBCD28DF3B_1518819553.addTaint(taint);
        return var8EE5C71A4D490AB3DE8E4FBBCD28DF3B_1518819553;
        case Node.COMMENT_NODE:
NodeImpl varFF37C0AEE453C2D59B12476D364B6832_559568405 =         createComment(((Comment) node).getData());
        varFF37C0AEE453C2D59B12476D364B6832_559568405.addTaint(taint);
        return varFF37C0AEE453C2D59B12476D364B6832_559568405;
        case Node.DOCUMENT_FRAGMENT_NODE:
NodeImpl varF58E9B178A00396BCA922B39BB626EC4_1606352838 =         createDocumentFragment();
        varF58E9B178A00396BCA922B39BB626EC4_1606352838.addTaint(taint);
        return varF58E9B178A00396BCA922B39BB626EC4_1606352838;
        case Node.DOCUMENT_NODE:
        case Node.DOCUMENT_TYPE_NODE:
        DOMException var2B2423393A14EDC652431F2E9236CFC2_349616700 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Cannot copy node of type " + node.getNodeType());
        var2B2423393A14EDC652431F2E9236CFC2_349616700.addTaint(taint);
        throw var2B2423393A14EDC652431F2E9236CFC2_349616700;
        case Node.ELEMENT_NODE:
        ElementImpl element = (ElementImpl) node;
        ElementImpl elementCopy;
        if(element.namespaceAware)        
        {
            elementCopy = createElementNS(element.getNamespaceURI(), element.getLocalName());
            elementCopy.setPrefix(element.getPrefix());
        } //End block
        else
        {
            elementCopy = createElement(element.getTagName());
        } //End block
        NamedNodeMap attributes = element.getAttributes();
for(int i = 0;i < attributes.getLength();i++)
        {
            AttrImpl elementAttr = (AttrImpl) attributes.item(i);
            AttrImpl elementAttrCopy = (AttrImpl) shallowCopy(operation, elementAttr);
            notifyUserDataHandlers(operation, elementAttr, elementAttrCopy);
            if(elementAttr.namespaceAware)            
            {
                elementCopy.setAttributeNodeNS(elementAttrCopy);
            } //End block
            else
            {
                elementCopy.setAttributeNode(elementAttrCopy);
            } //End block
        } //End block
NodeImpl varEE2C06C82B22C0F4F7846B62C2E3945B_639606624 =         elementCopy;
        varEE2C06C82B22C0F4F7846B62C2E3945B_639606624.addTaint(taint);
        return varEE2C06C82B22C0F4F7846B62C2E3945B_639606624;
        case Node.ENTITY_NODE:
        case Node.NOTATION_NODE:
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_331562336 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_331562336.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_331562336;
        case Node.ENTITY_REFERENCE_NODE:
NodeImpl var51BD6D0C42EAEAA88BE07E5DEFFBFA2A_1648864931 =         createEntityReference(node.getNodeName());
        var51BD6D0C42EAEAA88BE07E5DEFFBFA2A_1648864931.addTaint(taint);
        return var51BD6D0C42EAEAA88BE07E5DEFFBFA2A_1648864931;
        case Node.PROCESSING_INSTRUCTION_NODE:
        ProcessingInstruction pi = (ProcessingInstruction) node;
NodeImpl var585C6A3F6BC6E6BCEC5AA4A55804D5E3_1646415696 =         createProcessingInstruction(pi.getTarget(), pi.getData());
        var585C6A3F6BC6E6BCEC5AA4A55804D5E3_1646415696.addTaint(taint);
        return var585C6A3F6BC6E6BCEC5AA4A55804D5E3_1646415696;
        case Node.TEXT_NODE:
NodeImpl var8A7EEC6EF96FD1552AA04838C81FCFF3_1573589639 =         createTextNode(((Text) node).getData());
        var8A7EEC6EF96FD1552AA04838C81FCFF3_1573589639.addTaint(taint);
        return var8A7EEC6EF96FD1552AA04838C81FCFF3_1573589639;
        default:
        DOMException var96E7F93A47E198E550B071124DD8FDC7_1450027810 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Unsupported node type " + node.getNodeType());
        var96E7F93A47E198E550B071124DD8FDC7_1450027810.addTaint(taint);
        throw var96E7F93A47E198E550B071124DD8FDC7_1450027810;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.364 -0400", hash_original_method = "33992AC73E126DB7F05D741A2596DA1D", hash_generated_method = "70B55934FB4B30596E8C12A1F11BABC1")
     Node cloneOrImportNode(short operation, Node node, boolean deep) {
        addTaint(deep);
        addTaint(node.getTaint());
        addTaint(operation);
        NodeImpl copy = shallowCopy(operation, node);
        if(deep)        
        {
            NodeList list = node.getChildNodes();
for(int i = 0;i < list.getLength();i++)
            {
                copy.appendChild(cloneOrImportNode(operation, list.item(i), deep));
            } //End block
        } //End block
        notifyUserDataHandlers(operation, node, copy);
Node varB3465FEBAD4DD5A7F38E28E6AD35F9E7_1929013493 =         copy;
        varB3465FEBAD4DD5A7F38E28E6AD35F9E7_1929013493.addTaint(taint);
        return varB3465FEBAD4DD5A7F38E28E6AD35F9E7_1929013493;
        // ---------- Original Method ----------
        //NodeImpl copy = shallowCopy(operation, node);
        //if (deep) {
            //NodeList list = node.getChildNodes();
            //for (int i = 0; i < list.getLength(); i++) {
                //copy.appendChild(cloneOrImportNode(operation, list.item(i), deep));
            //}
        //}
        //notifyUserDataHandlers(operation, node, copy);
        //return copy;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.365 -0400", hash_original_method = "B9F8F7C255F6A56C10B3E640DB2181B9", hash_generated_method = "7797FC4BF69426196D010D2EAC6B3D7B")
    public Node importNode(Node importedNode, boolean deep) {
        addTaint(deep);
        addTaint(importedNode.getTaint());
Node varC8509DEAD331B5235D239291E0E4DEA0_1516281355 =         cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
        varC8509DEAD331B5235D239291E0E4DEA0_1516281355.addTaint(taint);
        return varC8509DEAD331B5235D239291E0E4DEA0_1516281355;
        // ---------- Original Method ----------
        //return cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.365 -0400", hash_original_method = "5D3B579AF503CA96D628AD6AA8EE2361", hash_generated_method = "DE1B46ABB0462A2ECC06251BACF61FD4")
    public Node adoptNode(Node node) {
        addTaint(node.getTaint());
        if(!(node instanceof NodeImpl))        
        {
Node var540C13E9E156B687226421B24F2DF178_1802999341 =             null;
            var540C13E9E156B687226421B24F2DF178_1802999341.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1802999341;
        } //End block
        NodeImpl nodeImpl = (NodeImpl) node;
switch(nodeImpl.getNodeType()){
        case Node.ATTRIBUTE_NODE:
        AttrImpl attr = (AttrImpl) node;
        if(attr.ownerElement != null)        
        {
            attr.ownerElement.removeAttributeNode(attr);
        } //End block
        break;
        case Node.DOCUMENT_FRAGMENT_NODE:
        case Node.ENTITY_REFERENCE_NODE:
        case Node.PROCESSING_INSTRUCTION_NODE:
        case Node.TEXT_NODE:
        case Node.CDATA_SECTION_NODE:
        case Node.COMMENT_NODE:
        case Node.ELEMENT_NODE:
        break;
        case Node.DOCUMENT_NODE:
        case Node.DOCUMENT_TYPE_NODE:
        case Node.ENTITY_NODE:
        case Node.NOTATION_NODE:
        DOMException varEF9D4E8B659847D04770073B3DA7118A_1378186694 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Cannot adopt nodes of type " + nodeImpl.getNodeType());
        varEF9D4E8B659847D04770073B3DA7118A_1378186694.addTaint(taint);
        throw varEF9D4E8B659847D04770073B3DA7118A_1378186694;
        default:
        DOMException var96E7F93A47E198E550B071124DD8FDC7_1931268096 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + node.getNodeType());
        var96E7F93A47E198E550B071124DD8FDC7_1931268096.addTaint(taint);
        throw var96E7F93A47E198E550B071124DD8FDC7_1931268096;
}        Node parent = nodeImpl.getParentNode();
        if(parent != null)        
        {
            parent.removeChild(nodeImpl);
        } //End block
        changeDocumentToThis(nodeImpl);
        notifyUserDataHandlers(UserDataHandler.NODE_ADOPTED, node, null);
Node varC986607E6DD9F5E55531D8567E31A845_281067735 =         nodeImpl;
        varC986607E6DD9F5E55531D8567E31A845_281067735.addTaint(taint);
        return varC986607E6DD9F5E55531D8567E31A845_281067735;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.366 -0400", hash_original_method = "AE2A1AE898A744D8ADE864AE8BDC4C1C", hash_generated_method = "5B2F7B3F041A3C8C776EF632BA0EDDA9")
    private void changeDocumentToThis(NodeImpl node) {
        addTaint(node.getTaint());
        Map<String, UserData> userData = node.document.getUserDataMapForRead(node);
        if(!userData.isEmpty())        
        {
            getUserDataMap(node).putAll(userData);
        } //End block
        node.document = this;
        NodeList list = node.getChildNodes();
for(int i = 0;i < list.getLength();i++)
        {
            changeDocumentToThis((NodeImpl) list.item(i));
        } //End block
        if(node.getNodeType() == Node.ELEMENT_NODE)        
        {
            NamedNodeMap attributes = node.getAttributes();
for(int i = 0;i < attributes.getLength();i++)
            {
                changeDocumentToThis((AttrImpl) attributes.item(i));
            } //End block
        } //End block
        // ---------- Original Method ----------
        //Map<String, UserData> userData = node.document.getUserDataMapForRead(node);
        //if (!userData.isEmpty()) {
            //getUserDataMap(node).putAll(userData);
        //}
        //node.document = this;
        //NodeList list = node.getChildNodes();
        //for (int i = 0; i < list.getLength(); i++) {
            //changeDocumentToThis((NodeImpl) list.item(i));
        //}
        //if (node.getNodeType() == Node.ELEMENT_NODE) {
            //NamedNodeMap attributes = node.getAttributes();
            //for (int i = 0; i < attributes.getLength(); i++) {
                //changeDocumentToThis((AttrImpl) attributes.item(i));
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.367 -0400", hash_original_method = "B4181EC124183B0357F0B78B4540BB52", hash_generated_method = "AD55468E46B388E1ABB7E38A96AFA4E7")
    public Node renameNode(Node node, String namespaceURI, String qualifiedName) {
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(node.getTaint());
        if(node.getOwnerDocument() != this)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_1818476600 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_1818476600.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_1818476600;
        } //End block
        setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
Node var1924C94B76524D1C3D7310EA17B0EF94_1211155370 =         node;
        var1924C94B76524D1C3D7310EA17B0EF94_1211155370.addTaint(taint);
        return var1924C94B76524D1C3D7310EA17B0EF94_1211155370;
        // ---------- Original Method ----------
        //if (node.getOwnerDocument() != this) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        //notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        //return node;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.367 -0400", hash_original_method = "03FB31A26F55DD46B5E0B444E3BDF78D", hash_generated_method = "D0E96109408755E43EF91F0977366727")
    public AttrImpl createAttribute(String name) {
        addTaint(name.getTaint());
AttrImpl var612F11A16FB15528D6F57502CE3AFF73_514489414 =         new AttrImpl(this, name);
        var612F11A16FB15528D6F57502CE3AFF73_514489414.addTaint(taint);
        return var612F11A16FB15528D6F57502CE3AFF73_514489414;
        // ---------- Original Method ----------
        //return new AttrImpl(this, name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.368 -0400", hash_original_method = "7E9190A2987BE4C0864253AAA3A5BE1B", hash_generated_method = "CBE3EE729F30C2CD092C72DB0FE1F660")
    public AttrImpl createAttributeNS(String namespaceURI, String qualifiedName) {
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
AttrImpl varAE4AF0F0A1BFE1A443C0FAB76488FDAC_1083821753 =         new AttrImpl(this, namespaceURI, qualifiedName);
        varAE4AF0F0A1BFE1A443C0FAB76488FDAC_1083821753.addTaint(taint);
        return varAE4AF0F0A1BFE1A443C0FAB76488FDAC_1083821753;
        // ---------- Original Method ----------
        //return new AttrImpl(this, namespaceURI, qualifiedName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.368 -0400", hash_original_method = "33E9B43072FE607E52B07810FE2FCABA", hash_generated_method = "42C0F5D2BCED167ED3DA6F6AC0F7D4E2")
    public CDATASectionImpl createCDATASection(String data) {
        addTaint(data.getTaint());
CDATASectionImpl var0316399DDDD248E550709E3EB38F478E_1452669423 =         new CDATASectionImpl(this, data);
        var0316399DDDD248E550709E3EB38F478E_1452669423.addTaint(taint);
        return var0316399DDDD248E550709E3EB38F478E_1452669423;
        // ---------- Original Method ----------
        //return new CDATASectionImpl(this, data);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.368 -0400", hash_original_method = "4FD6147AAF1A19FB78D88E22C913FA0B", hash_generated_method = "26530BDF6C1992B141279E4EE1406D88")
    public CommentImpl createComment(String data) {
        addTaint(data.getTaint());
CommentImpl var467367A6C8142BE09506EACAD57C07F6_748521626 =         new CommentImpl(this, data);
        var467367A6C8142BE09506EACAD57C07F6_748521626.addTaint(taint);
        return var467367A6C8142BE09506EACAD57C07F6_748521626;
        // ---------- Original Method ----------
        //return new CommentImpl(this, data);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.369 -0400", hash_original_method = "E0A12B60B45AEC987C1DC80CBB7F44C4", hash_generated_method = "AADC4B38339D86CE91283D592E4C5807")
    public DocumentFragmentImpl createDocumentFragment() {
DocumentFragmentImpl var9ED80EE37509EA4B3FC2221170BA699A_955619931 =         new DocumentFragmentImpl(this);
        var9ED80EE37509EA4B3FC2221170BA699A_955619931.addTaint(taint);
        return var9ED80EE37509EA4B3FC2221170BA699A_955619931;
        // ---------- Original Method ----------
        //return new DocumentFragmentImpl(this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.369 -0400", hash_original_method = "292829053BF3153AB99E6877B4023526", hash_generated_method = "CC645F19545B8F12F7EA0FF50B163B56")
    public ElementImpl createElement(String tagName) {
        addTaint(tagName.getTaint());
ElementImpl var74C5D4A07EA40C7F07F1E3EAEA07A0A3_213515724 =         new ElementImpl(this, tagName);
        var74C5D4A07EA40C7F07F1E3EAEA07A0A3_213515724.addTaint(taint);
        return var74C5D4A07EA40C7F07F1E3EAEA07A0A3_213515724;
        // ---------- Original Method ----------
        //return new ElementImpl(this, tagName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.369 -0400", hash_original_method = "A5861E1D8245000D4878ACAD76251828", hash_generated_method = "190194D4EFB956FB98CD8CD63B4E6796")
    public ElementImpl createElementNS(String namespaceURI, String qualifiedName) {
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
ElementImpl varF241DA3ACA0466C867DC512C0DB8D42B_1498939354 =         new ElementImpl(this, namespaceURI, qualifiedName);
        varF241DA3ACA0466C867DC512C0DB8D42B_1498939354.addTaint(taint);
        return varF241DA3ACA0466C867DC512C0DB8D42B_1498939354;
        // ---------- Original Method ----------
        //return new ElementImpl(this, namespaceURI, qualifiedName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.370 -0400", hash_original_method = "3D6CE6751E22FD6EDABA3110F50E9507", hash_generated_method = "1345A2FFCCD5D28AC5DB28E51910BC93")
    public EntityReferenceImpl createEntityReference(String name) {
        addTaint(name.getTaint());
EntityReferenceImpl varED3530A5DF816B816E808483A7C6C62D_372010605 =         new EntityReferenceImpl(this, name);
        varED3530A5DF816B816E808483A7C6C62D_372010605.addTaint(taint);
        return varED3530A5DF816B816E808483A7C6C62D_372010605;
        // ---------- Original Method ----------
        //return new EntityReferenceImpl(this, name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.370 -0400", hash_original_method = "D7C06C722D311E922A32C921DF42A71E", hash_generated_method = "E87BF02572BD5E58A6E7610CF817C920")
    public ProcessingInstructionImpl createProcessingInstruction(String target, String data) {
        addTaint(data.getTaint());
        addTaint(target.getTaint());
ProcessingInstructionImpl varCA75367CD4431BBD4808433F10741000_1754119049 =         new ProcessingInstructionImpl(this, target, data);
        varCA75367CD4431BBD4808433F10741000_1754119049.addTaint(taint);
        return varCA75367CD4431BBD4808433F10741000_1754119049;
        // ---------- Original Method ----------
        //return new ProcessingInstructionImpl(this, target, data);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.370 -0400", hash_original_method = "194421EA05B5C62E27597F16A7528043", hash_generated_method = "293B639D3852DD0AA60971FE831290C6")
    public TextImpl createTextNode(String data) {
        addTaint(data.getTaint());
TextImpl varD13621AEB8B98070CD69DC7C279B3075_1843317385 =         new TextImpl(this, data);
        varD13621AEB8B98070CD69DC7C279B3075_1843317385.addTaint(taint);
        return varD13621AEB8B98070CD69DC7C279B3075_1843317385;
        // ---------- Original Method ----------
        //return new TextImpl(this, data);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.371 -0400", hash_original_method = "D024EAB4EE7007F22F93D8BE399D2ED2", hash_generated_method = "5945ED614177CC9E07EA1BC61CEED318")
    public DocumentType getDoctype() {
for(LeafNodeImpl child : children)
        {
            if(child instanceof DocumentType)            
            {
DocumentType var0498972267A749CF8B0A92E3BA5C7EB7_1536270928 =                 (DocumentType) child;
                var0498972267A749CF8B0A92E3BA5C7EB7_1536270928.addTaint(taint);
                return var0498972267A749CF8B0A92E3BA5C7EB7_1536270928;
            } //End block
        } //End block
DocumentType var540C13E9E156B687226421B24F2DF178_875423203 =         null;
        var540C13E9E156B687226421B24F2DF178_875423203.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_875423203;
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof DocumentType) {
                //return (DocumentType) child;
            //}
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.371 -0400", hash_original_method = "59978D20A08E2A3D10080AFCDAEC6A5E", hash_generated_method = "C00E02B3C89E0F61B5F801727B22D068")
    public Element getDocumentElement() {
for(LeafNodeImpl child : children)
        {
            if(child instanceof Element)            
            {
Element var52E420693F147DB2DE17E047C7CA0895_2041501227 =                 (Element) child;
                var52E420693F147DB2DE17E047C7CA0895_2041501227.addTaint(taint);
                return var52E420693F147DB2DE17E047C7CA0895_2041501227;
            } //End block
        } //End block
Element var540C13E9E156B687226421B24F2DF178_798363618 =         null;
        var540C13E9E156B687226421B24F2DF178_798363618.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_798363618;
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof Element) {
                //return (Element) child;
            //}
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.372 -0400", hash_original_method = "F4A17E55F2C93FA371B29DDF570BB5F6", hash_generated_method = "B3CA857D8F34BC6273175E3EA1DD66E6")
    public Element getElementById(String elementId) {
        addTaint(elementId.getTaint());
        ElementImpl root = (ElementImpl) getDocumentElement();
Element varEB03DC82262B48F10745A4ABBCED7432_601242952 =         (root == null ? null : root.getElementById(elementId));
        varEB03DC82262B48F10745A4ABBCED7432_601242952.addTaint(taint);
        return varEB03DC82262B48F10745A4ABBCED7432_601242952;
        // ---------- Original Method ----------
        //ElementImpl root = (ElementImpl) getDocumentElement();
        //return (root == null ? null : root.getElementById(elementId));
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.373 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "5652CCF93966C360AFDA82236666F935")
    public NodeList getElementsByTagName(String name) {
        addTaint(name.getTaint());
        NodeListImpl result = new NodeListImpl();
        getElementsByTagName(result, name);
NodeList varDC838461EE2FA0CA4C9BBB70A15456B0_305548093 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_305548093.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_305548093;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagName(result, name);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.373 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "9960B61B992126181B264DD9405CC6CC")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        NodeListImpl result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
NodeList varDC838461EE2FA0CA4C9BBB70A15456B0_1596407927 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1596407927.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1596407927;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagNameNS(result, namespaceURI, localName);
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.373 -0400", hash_original_method = "871220F29645F989F5FF83627B59D2B9", hash_generated_method = "1E487C7E6A23281F51007CD522B90D99")
    public DOMImplementation getImplementation() {
DOMImplementation var0CB0D946FB5941C9150C9E48B5077394_1106968923 =         domImplementation;
        var0CB0D946FB5941C9150C9E48B5077394_1106968923.addTaint(taint);
        return var0CB0D946FB5941C9150C9E48B5077394_1106968923;
        // ---------- Original Method ----------
        //return domImplementation;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.374 -0400", hash_original_method = "3823D9F624F2EC5FAA072B7BE8806F96", hash_generated_method = "4CA669EBBEBB32ED9337BB980FCDFCFE")
    @Override
    public String getNodeName() {
String var184E07E47A1EBD9CDE63E55F8C3223BD_2003174678 =         "#document";
        var184E07E47A1EBD9CDE63E55F8C3223BD_2003174678.addTaint(taint);
        return var184E07E47A1EBD9CDE63E55F8C3223BD_2003174678;
        // ---------- Original Method ----------
        //return "#document";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.374 -0400", hash_original_method = "043CCE8DE1A8362BF53702E45F3637E9", hash_generated_method = "B318FD2A90CC7837C0633B98B5B180E3")
    @Override
    public short getNodeType() {
        short var9DC38E743DEA0184187604DE55890A66_575580303 = (Node.DOCUMENT_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1375702999 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1375702999;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_NODE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.375 -0400", hash_original_method = "C51ADCEBFAB6A11E8C0AA42A3197A4ED", hash_generated_method = "5D059DB89D1D43B27616BCC5E846AE3B")
    @Override
    public Node insertChildAt(Node toInsert, int index) {
        addTaint(index);
        addTaint(toInsert.getTaint());
        if(toInsert instanceof Element && getDocumentElement() != null)        
        {
            DOMException var6EFB525E3BA58214860A1ECCBE7B0554_1738504510 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one root element allowed");
            var6EFB525E3BA58214860A1ECCBE7B0554_1738504510.addTaint(taint);
            throw var6EFB525E3BA58214860A1ECCBE7B0554_1738504510;
        } //End block
        if(toInsert instanceof DocumentType && getDoctype() != null)        
        {
            DOMException var4E5075F9F62ABDFD65E549C3A33CA64A_1884823995 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one DOCTYPE element allowed");
            var4E5075F9F62ABDFD65E549C3A33CA64A_1884823995.addTaint(taint);
            throw var4E5075F9F62ABDFD65E549C3A33CA64A_1884823995;
        } //End block
Node varC4CD74D80210786139448546B3578BE5_1847531796 =         super.insertChildAt(toInsert, index);
        varC4CD74D80210786139448546B3578BE5_1847531796.addTaint(taint);
        return varC4CD74D80210786139448546B3578BE5_1847531796;
        // ---------- Original Method ----------
        //if (toInsert instanceof Element && getDocumentElement() != null) {
            //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    //"Only one root element allowed");
        //}
        //if (toInsert instanceof DocumentType && getDoctype() != null) {
            //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    //"Only one DOCTYPE element allowed");
        //}
        //return super.insertChildAt(toInsert, index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.375 -0400", hash_original_method = "523640531DE4ABEBCC885A0C8EFFAA8E", hash_generated_method = "48058652E94D22178B29D1B77227B96F")
    @Override
    public String getTextContent() {
String var540C13E9E156B687226421B24F2DF178_542401651 =         null;
        var540C13E9E156B687226421B24F2DF178_542401651.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_542401651;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.375 -0400", hash_original_method = "94C9917BD9FB417B21D37D438D58D41C", hash_generated_method = "4B50F09161FE2A9CDB70AB2841B36CA9")
    public String getInputEncoding() {
String varAF565BD5329AC6390DBCBCB5155BFF73_297060309 =         inputEncoding;
        varAF565BD5329AC6390DBCBCB5155BFF73_297060309.addTaint(taint);
        return varAF565BD5329AC6390DBCBCB5155BFF73_297060309;
        // ---------- Original Method ----------
        //return inputEncoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.376 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "772689E10AA6BB752012ECFEA42F96D6")
    public String getXmlEncoding() {
String var73B8B2E9305670B097C62E479C746550_330018960 =         xmlEncoding;
        var73B8B2E9305670B097C62E479C746550_330018960.addTaint(taint);
        return var73B8B2E9305670B097C62E479C746550_330018960;
        // ---------- Original Method ----------
        //return xmlEncoding;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.376 -0400", hash_original_method = "A9BBCA9526831CCA3B1BE6D8EEF33ABE", hash_generated_method = "497053967F3BA27035E6AB42CA0D6306")
    public boolean getXmlStandalone() {
        boolean var8D032D498937B83920DC3FA77257B667_1466665669 = (xmlStandalone);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_946452363 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_946452363;
        // ---------- Original Method ----------
        //return xmlStandalone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.376 -0400", hash_original_method = "9E601CBC8BB08C0D3B66A0213931419B", hash_generated_method = "9E81AB93ADB44B2013F3533C3DA5BE8E")
    public void setXmlStandalone(boolean xmlStandalone) {
        this.xmlStandalone = xmlStandalone;
        // ---------- Original Method ----------
        //this.xmlStandalone = xmlStandalone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.376 -0400", hash_original_method = "BC354AC833FDCF3905B7FEDC7BFD541D", hash_generated_method = "B610831A88C4FE8F96650933E2BBDBD7")
    public String getXmlVersion() {
String varB592761CA9968991FA44D1528F93C283_191905143 =         xmlVersion;
        varB592761CA9968991FA44D1528F93C283_191905143.addTaint(taint);
        return varB592761CA9968991FA44D1528F93C283_191905143;
        // ---------- Original Method ----------
        //return xmlVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.376 -0400", hash_original_method = "C0A21B3EE9603BF0EAE2488DE43FD78E", hash_generated_method = "1D025D03CF816AA6E6E7E13C188987CA")
    public void setXmlVersion(String xmlVersion) {
        this.xmlVersion = xmlVersion;
        // ---------- Original Method ----------
        //this.xmlVersion = xmlVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.376 -0400", hash_original_method = "338EEC38209BE0DB329E33E9EDD7ED88", hash_generated_method = "0B7031BE19FD6396E9A79101A2D17929")
    public boolean getStrictErrorChecking() {
        boolean var45AE3A38A330419EF5540FA43DEE084B_1326567791 = (strictErrorChecking);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2018040481 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2018040481;
        // ---------- Original Method ----------
        //return strictErrorChecking;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.376 -0400", hash_original_method = "55375073A29EAEC23495FBD30A28EDB3", hash_generated_method = "B5D30D71D7A11256EBFA7BCECCF3D144")
    public void setStrictErrorChecking(boolean strictErrorChecking) {
        this.strictErrorChecking = strictErrorChecking;
        // ---------- Original Method ----------
        //this.strictErrorChecking = strictErrorChecking;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.377 -0400", hash_original_method = "2433E48CE07A4EB6DFAAA40EF72A0853", hash_generated_method = "2348AD62B785007F875B01D41194B31E")
    public String getDocumentURI() {
String varDD799FF124BC34A6AA6495A09CB91A11_75484969 =         documentUri;
        varDD799FF124BC34A6AA6495A09CB91A11_75484969.addTaint(taint);
        return varDD799FF124BC34A6AA6495A09CB91A11_75484969;
        // ---------- Original Method ----------
        //return documentUri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.377 -0400", hash_original_method = "2ABB3572AC2E2195C4BFB544AFA05B7C", hash_generated_method = "88DFDC039A98BD865B0FDF5C62AD2EAE")
    public void setDocumentURI(String documentUri) {
        this.documentUri = documentUri;
        // ---------- Original Method ----------
        //this.documentUri = documentUri;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.377 -0400", hash_original_method = "9C5D9FE4294F6D7509E6E0C2DA50CF2D", hash_generated_method = "01335E8433D53593272B27CD3E002FC8")
    public DOMConfiguration getDomConfig() {
        if(domConfiguration == null)        
        {
            domConfiguration = new DOMConfigurationImpl();
        } //End block
DOMConfiguration var0D370929C0EBAAB3536D872023877E23_1291644338 =         domConfiguration;
        var0D370929C0EBAAB3536D872023877E23_1291644338.addTaint(taint);
        return var0D370929C0EBAAB3536D872023877E23_1291644338;
        // ---------- Original Method ----------
        //if (domConfiguration == null) {
            //domConfiguration = new DOMConfigurationImpl();
        //}
        //return domConfiguration;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.377 -0400", hash_original_method = "89D7CC816429D9C559DCCAF8A85B9CA9", hash_generated_method = "382B37736C48E4651B0923427E76B4A0")
    public void normalizeDocument() {
        Element root = getDocumentElement();
        if(root == null)        
        {
            return;
        } //End block
        ((DOMConfigurationImpl) getDomConfig()).normalize(root);
        // ---------- Original Method ----------
        //Element root = getDocumentElement();
        //if (root == null) {
            //return;
        //}
        //((DOMConfigurationImpl) getDomConfig()).normalize(root);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.377 -0400", hash_original_method = "83962F2DF698AAA6D760C50C082C5A3C", hash_generated_method = "01325DB84780D2BD89B418DB0C964DE5")
     Map<String, UserData> getUserDataMap(NodeImpl node) {
        addTaint(node.getTaint());
        if(nodeToUserData == null)        
        {
            nodeToUserData = new WeakHashMap<NodeImpl, Map<String, UserData>>();
        } //End block
        Map<String, UserData> userDataMap = nodeToUserData.get(node);
        if(userDataMap == null)        
        {
            userDataMap = new HashMap<String, UserData>();
            nodeToUserData.put(node, userDataMap);
        } //End block
Map<String, UserData> varC9322CB19A196C9D9117A684D649D268_908379247 =         userDataMap;
        varC9322CB19A196C9D9117A684D649D268_908379247.addTaint(taint);
        return varC9322CB19A196C9D9117A684D649D268_908379247;
        // ---------- Original Method ----------
        //if (nodeToUserData == null) {
            //nodeToUserData = new WeakHashMap<NodeImpl, Map<String, UserData>>();
        //}
        //Map<String, UserData> userDataMap = nodeToUserData.get(node);
        //if (userDataMap == null) {
            //userDataMap = new HashMap<String, UserData>();
            //nodeToUserData.put(node, userDataMap);
        //}
        //return userDataMap;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.378 -0400", hash_original_method = "8B5F30F59CCBC9322DB0F048DEF01A52", hash_generated_method = "70E14C5D9F2A6DB7058A6FCC67B0A0AC")
     Map<String, UserData> getUserDataMapForRead(NodeImpl node) {
        addTaint(node.getTaint());
        if(nodeToUserData == null)        
        {
Map<String, UserData> varA32ED10B45EA6ACB8D1ECFEFE1C18540_408976465 =             Collections.emptyMap();
            varA32ED10B45EA6ACB8D1ECFEFE1C18540_408976465.addTaint(taint);
            return varA32ED10B45EA6ACB8D1ECFEFE1C18540_408976465;
        } //End block
        Map<String, UserData> userDataMap = nodeToUserData.get(node);
Map<String, UserData> varD826347363F7164F3227DB7372F59AE9_1396791905 =         userDataMap == null
                ? Collections.<String, UserData>emptyMap()
                : userDataMap;
        varD826347363F7164F3227DB7372F59AE9_1396791905.addTaint(taint);
        return varD826347363F7164F3227DB7372F59AE9_1396791905;
        // ---------- Original Method ----------
        //if (nodeToUserData == null) {
            //return Collections.emptyMap();
        //}
        //Map<String, UserData> userDataMap = nodeToUserData.get(node);
        //return userDataMap == null
                //? Collections.<String, UserData>emptyMap()
                //: userDataMap;
    }

    
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

