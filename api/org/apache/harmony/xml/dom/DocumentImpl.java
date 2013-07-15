package org.apache.harmony.xml.dom;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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

public final class DocumentImpl extends InnerNodeImpl implements Document {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.656 -0400", hash_original_field = "9A0C2D739DCDFB02BF9A89440A1742BE", hash_generated_field = "02CE798A8CB59B7226C8831D772A3C37")

    private DOMImplementation domImplementation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.656 -0400", hash_original_field = "5C1DDF42AF97D3B8A25E52B51295CBCC", hash_generated_field = "4C2B5AB6B1E4F28DC9582765A0F90963")

    private DOMConfigurationImpl domConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.657 -0400", hash_original_field = "7F008BD20578B4549518F8F2105F0B56", hash_generated_field = "677F469BCAF22AAF9C9A1BCAA78B217D")

    private String documentUri;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.657 -0400", hash_original_field = "095EA6E25F03C3DC620F669B4CE91A23", hash_generated_field = "6E57DD71D7D0E77E0155AE21B6C03BD4")

    private String inputEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.657 -0400", hash_original_field = "CAD97869F74973B5626CFC237B513EAA", hash_generated_field = "656761370EB1B6AB6991B2A74412BA8B")

    private String xmlEncoding;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.657 -0400", hash_original_field = "D937E495C2709421D5BB34439EB7E5BF", hash_generated_field = "D19F092C2B57A6CC2509D5D658E0ECE5")

    private String xmlVersion = "1.0";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.657 -0400", hash_original_field = "D57C79C8DAC76C34330A7438298EC2AF", hash_generated_field = "ED1ABCCC72304E22012FCF1E2F4242CD")

    private boolean xmlStandalone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.657 -0400", hash_original_field = "A6BEA613612CBF77E8D9A1D2B43F7D75", hash_generated_field = "AEC49EFA08DDCABA663F00B7AA711A75")

    private boolean strictErrorChecking = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.657 -0400", hash_original_field = "83989D7A486A577204E595124E91C3FB", hash_generated_field = "2C2B0316F02F109A0965964EB1E285F6")

    private WeakHashMap<NodeImpl, Map<String, UserData>> nodeToUserData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.658 -0400", hash_original_method = "163C3C7D3935E830694E09EA8384B9EA", hash_generated_method = "3F556D19054A03740E830ABA0E8C4D3B")
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

    
        private static boolean isXMLIdentifierStart(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c == '_');
    }

    
        private static boolean isXMLIdentifierPart(char c) {
        return isXMLIdentifierStart(c) || (c >= '0' && c <= '9') || (c == '-') || (c == '.');
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.660 -0400", hash_original_method = "71EB0F41099D1D8D08C83EAF224E8D36", hash_generated_method = "36E6317BD5242499D895589EE1EBF3D0")
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
NodeImpl var52C2AE82F44DFBAB6EB50CDA2D5BD512_1465787129 =         attrCopy;
        var52C2AE82F44DFBAB6EB50CDA2D5BD512_1465787129.addTaint(taint);
        return var52C2AE82F44DFBAB6EB50CDA2D5BD512_1465787129;
        case Node.CDATA_SECTION_NODE:
NodeImpl var8EE5C71A4D490AB3DE8E4FBBCD28DF3B_1057109682 =         createCDATASection(((CharacterData) node).getData());
        var8EE5C71A4D490AB3DE8E4FBBCD28DF3B_1057109682.addTaint(taint);
        return var8EE5C71A4D490AB3DE8E4FBBCD28DF3B_1057109682;
        case Node.COMMENT_NODE:
NodeImpl varFF37C0AEE453C2D59B12476D364B6832_567689045 =         createComment(((Comment) node).getData());
        varFF37C0AEE453C2D59B12476D364B6832_567689045.addTaint(taint);
        return varFF37C0AEE453C2D59B12476D364B6832_567689045;
        case Node.DOCUMENT_FRAGMENT_NODE:
NodeImpl varF58E9B178A00396BCA922B39BB626EC4_1632862161 =         createDocumentFragment();
        varF58E9B178A00396BCA922B39BB626EC4_1632862161.addTaint(taint);
        return varF58E9B178A00396BCA922B39BB626EC4_1632862161;
        case Node.DOCUMENT_NODE:
        case Node.DOCUMENT_TYPE_NODE:
        DOMException var2B2423393A14EDC652431F2E9236CFC2_499022010 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Cannot copy node of type " + node.getNodeType());
        var2B2423393A14EDC652431F2E9236CFC2_499022010.addTaint(taint);
        throw var2B2423393A14EDC652431F2E9236CFC2_499022010;
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
NodeImpl varEE2C06C82B22C0F4F7846B62C2E3945B_1604155968 =         elementCopy;
        varEE2C06C82B22C0F4F7846B62C2E3945B_1604155968.addTaint(taint);
        return varEE2C06C82B22C0F4F7846B62C2E3945B_1604155968;
        case Node.ENTITY_NODE:
        case Node.NOTATION_NODE:
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1820382152 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1820382152.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1820382152;
        case Node.ENTITY_REFERENCE_NODE:
NodeImpl var51BD6D0C42EAEAA88BE07E5DEFFBFA2A_318225118 =         createEntityReference(node.getNodeName());
        var51BD6D0C42EAEAA88BE07E5DEFFBFA2A_318225118.addTaint(taint);
        return var51BD6D0C42EAEAA88BE07E5DEFFBFA2A_318225118;
        case Node.PROCESSING_INSTRUCTION_NODE:
        ProcessingInstruction pi = (ProcessingInstruction) node;
NodeImpl var585C6A3F6BC6E6BCEC5AA4A55804D5E3_55251428 =         createProcessingInstruction(pi.getTarget(), pi.getData());
        var585C6A3F6BC6E6BCEC5AA4A55804D5E3_55251428.addTaint(taint);
        return var585C6A3F6BC6E6BCEC5AA4A55804D5E3_55251428;
        case Node.TEXT_NODE:
NodeImpl var8A7EEC6EF96FD1552AA04838C81FCFF3_2129859364 =         createTextNode(((Text) node).getData());
        var8A7EEC6EF96FD1552AA04838C81FCFF3_2129859364.addTaint(taint);
        return var8A7EEC6EF96FD1552AA04838C81FCFF3_2129859364;
        default:
        DOMException var96E7F93A47E198E550B071124DD8FDC7_1056180721 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                    "Unsupported node type " + node.getNodeType());
        var96E7F93A47E198E550B071124DD8FDC7_1056180721.addTaint(taint);
        throw var96E7F93A47E198E550B071124DD8FDC7_1056180721;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.661 -0400", hash_original_method = "33992AC73E126DB7F05D741A2596DA1D", hash_generated_method = "1A42F6C3BA11B6EBEFBD524D2757B4B0")
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
Node varB3465FEBAD4DD5A7F38E28E6AD35F9E7_1527861679 =         copy;
        varB3465FEBAD4DD5A7F38E28E6AD35F9E7_1527861679.addTaint(taint);
        return varB3465FEBAD4DD5A7F38E28E6AD35F9E7_1527861679;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.661 -0400", hash_original_method = "B9F8F7C255F6A56C10B3E640DB2181B9", hash_generated_method = "ACEF21F2A11EF51B4D870FC0EA9E0409")
    public Node importNode(Node importedNode, boolean deep) {
        addTaint(deep);
        addTaint(importedNode.getTaint());
Node varC8509DEAD331B5235D239291E0E4DEA0_409816145 =         cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
        varC8509DEAD331B5235D239291E0E4DEA0_409816145.addTaint(taint);
        return varC8509DEAD331B5235D239291E0E4DEA0_409816145;
        // ---------- Original Method ----------
        //return cloneOrImportNode(UserDataHandler.NODE_IMPORTED, importedNode, deep);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.662 -0400", hash_original_method = "5D3B579AF503CA96D628AD6AA8EE2361", hash_generated_method = "3A5D43BB5D08454E7C005F53BD653876")
    public Node adoptNode(Node node) {
        addTaint(node.getTaint());
    if(!(node instanceof NodeImpl))        
        {
Node var540C13E9E156B687226421B24F2DF178_510410471 =             null;
            var540C13E9E156B687226421B24F2DF178_510410471.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_510410471;
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
        DOMException varEF9D4E8B659847D04770073B3DA7118A_1078536494 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Cannot adopt nodes of type " + nodeImpl.getNodeType());
        varEF9D4E8B659847D04770073B3DA7118A_1078536494.addTaint(taint);
        throw varEF9D4E8B659847D04770073B3DA7118A_1078536494;
        default:
        DOMException var96E7F93A47E198E550B071124DD8FDC7_1220170553 = new DOMException(DOMException.NOT_SUPPORTED_ERR,
                        "Unsupported node type " + node.getNodeType());
        var96E7F93A47E198E550B071124DD8FDC7_1220170553.addTaint(taint);
        throw var96E7F93A47E198E550B071124DD8FDC7_1220170553;
}        Node parent = nodeImpl.getParentNode();
    if(parent != null)        
        {
            parent.removeChild(nodeImpl);
        } //End block
        changeDocumentToThis(nodeImpl);
        notifyUserDataHandlers(UserDataHandler.NODE_ADOPTED, node, null);
Node varC986607E6DD9F5E55531D8567E31A845_1604605694 =         nodeImpl;
        varC986607E6DD9F5E55531D8567E31A845_1604605694.addTaint(taint);
        return varC986607E6DD9F5E55531D8567E31A845_1604605694;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.663 -0400", hash_original_method = "AE2A1AE898A744D8ADE864AE8BDC4C1C", hash_generated_method = "5B2F7B3F041A3C8C776EF632BA0EDDA9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.663 -0400", hash_original_method = "B4181EC124183B0357F0B78B4540BB52", hash_generated_method = "3F3D43714973DA480246750FB27C6A2B")
    public Node renameNode(Node node, String namespaceURI, String qualifiedName) {
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(node.getTaint());
    if(node.getOwnerDocument() != this)        
        {
            DOMException varA328C7C3947948BA7A5CD8E93B74AC3F_1524901068 = new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
            varA328C7C3947948BA7A5CD8E93B74AC3F_1524901068.addTaint(taint);
            throw varA328C7C3947948BA7A5CD8E93B74AC3F_1524901068;
        } //End block
        setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
Node var1924C94B76524D1C3D7310EA17B0EF94_568718925 =         node;
        var1924C94B76524D1C3D7310EA17B0EF94_568718925.addTaint(taint);
        return var1924C94B76524D1C3D7310EA17B0EF94_568718925;
        // ---------- Original Method ----------
        //if (node.getOwnerDocument() != this) {
            //throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        //}
        //setNameNS((NodeImpl) node, namespaceURI, qualifiedName);
        //notifyUserDataHandlers(UserDataHandler.NODE_RENAMED, node, null);
        //return node;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.664 -0400", hash_original_method = "03FB31A26F55DD46B5E0B444E3BDF78D", hash_generated_method = "50DFE6A5A63B11A4D019F67F82CA85AB")
    public AttrImpl createAttribute(String name) {
        addTaint(name.getTaint());
AttrImpl var612F11A16FB15528D6F57502CE3AFF73_1470114534 =         new AttrImpl(this, name);
        var612F11A16FB15528D6F57502CE3AFF73_1470114534.addTaint(taint);
        return var612F11A16FB15528D6F57502CE3AFF73_1470114534;
        // ---------- Original Method ----------
        //return new AttrImpl(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.664 -0400", hash_original_method = "7E9190A2987BE4C0864253AAA3A5BE1B", hash_generated_method = "0BB44B9B58706A0148B5B1E08A1E269B")
    public AttrImpl createAttributeNS(String namespaceURI, String qualifiedName) {
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
AttrImpl varAE4AF0F0A1BFE1A443C0FAB76488FDAC_1614576326 =         new AttrImpl(this, namespaceURI, qualifiedName);
        varAE4AF0F0A1BFE1A443C0FAB76488FDAC_1614576326.addTaint(taint);
        return varAE4AF0F0A1BFE1A443C0FAB76488FDAC_1614576326;
        // ---------- Original Method ----------
        //return new AttrImpl(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.664 -0400", hash_original_method = "33E9B43072FE607E52B07810FE2FCABA", hash_generated_method = "6F12D399357764A1F1FB9E76A089A5BF")
    public CDATASectionImpl createCDATASection(String data) {
        addTaint(data.getTaint());
CDATASectionImpl var0316399DDDD248E550709E3EB38F478E_1416699493 =         new CDATASectionImpl(this, data);
        var0316399DDDD248E550709E3EB38F478E_1416699493.addTaint(taint);
        return var0316399DDDD248E550709E3EB38F478E_1416699493;
        // ---------- Original Method ----------
        //return new CDATASectionImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.665 -0400", hash_original_method = "4FD6147AAF1A19FB78D88E22C913FA0B", hash_generated_method = "EF0A5D6257D450E8F15748627C056988")
    public CommentImpl createComment(String data) {
        addTaint(data.getTaint());
CommentImpl var467367A6C8142BE09506EACAD57C07F6_660922905 =         new CommentImpl(this, data);
        var467367A6C8142BE09506EACAD57C07F6_660922905.addTaint(taint);
        return var467367A6C8142BE09506EACAD57C07F6_660922905;
        // ---------- Original Method ----------
        //return new CommentImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.665 -0400", hash_original_method = "E0A12B60B45AEC987C1DC80CBB7F44C4", hash_generated_method = "8051FE1BE3A62682F853C0F7D2294F4E")
    public DocumentFragmentImpl createDocumentFragment() {
DocumentFragmentImpl var9ED80EE37509EA4B3FC2221170BA699A_1898309116 =         new DocumentFragmentImpl(this);
        var9ED80EE37509EA4B3FC2221170BA699A_1898309116.addTaint(taint);
        return var9ED80EE37509EA4B3FC2221170BA699A_1898309116;
        // ---------- Original Method ----------
        //return new DocumentFragmentImpl(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.665 -0400", hash_original_method = "292829053BF3153AB99E6877B4023526", hash_generated_method = "0A8A31EBA3A7E24D916ADD70807FD114")
    public ElementImpl createElement(String tagName) {
        addTaint(tagName.getTaint());
ElementImpl var74C5D4A07EA40C7F07F1E3EAEA07A0A3_1532088105 =         new ElementImpl(this, tagName);
        var74C5D4A07EA40C7F07F1E3EAEA07A0A3_1532088105.addTaint(taint);
        return var74C5D4A07EA40C7F07F1E3EAEA07A0A3_1532088105;
        // ---------- Original Method ----------
        //return new ElementImpl(this, tagName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.666 -0400", hash_original_method = "A5861E1D8245000D4878ACAD76251828", hash_generated_method = "41D14B89F9389A8942CBB54EC3AA0FF8")
    public ElementImpl createElementNS(String namespaceURI, String qualifiedName) {
        addTaint(qualifiedName.getTaint());
        addTaint(namespaceURI.getTaint());
ElementImpl varF241DA3ACA0466C867DC512C0DB8D42B_688045628 =         new ElementImpl(this, namespaceURI, qualifiedName);
        varF241DA3ACA0466C867DC512C0DB8D42B_688045628.addTaint(taint);
        return varF241DA3ACA0466C867DC512C0DB8D42B_688045628;
        // ---------- Original Method ----------
        //return new ElementImpl(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.666 -0400", hash_original_method = "3D6CE6751E22FD6EDABA3110F50E9507", hash_generated_method = "E41E9061ADF74080F0BC7A7CE69D7477")
    public EntityReferenceImpl createEntityReference(String name) {
        addTaint(name.getTaint());
EntityReferenceImpl varED3530A5DF816B816E808483A7C6C62D_772244759 =         new EntityReferenceImpl(this, name);
        varED3530A5DF816B816E808483A7C6C62D_772244759.addTaint(taint);
        return varED3530A5DF816B816E808483A7C6C62D_772244759;
        // ---------- Original Method ----------
        //return new EntityReferenceImpl(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.666 -0400", hash_original_method = "D7C06C722D311E922A32C921DF42A71E", hash_generated_method = "5CEB4C5C261D146708F640A2C65E3B53")
    public ProcessingInstructionImpl createProcessingInstruction(String target, String data) {
        addTaint(data.getTaint());
        addTaint(target.getTaint());
ProcessingInstructionImpl varCA75367CD4431BBD4808433F10741000_186625281 =         new ProcessingInstructionImpl(this, target, data);
        varCA75367CD4431BBD4808433F10741000_186625281.addTaint(taint);
        return varCA75367CD4431BBD4808433F10741000_186625281;
        // ---------- Original Method ----------
        //return new ProcessingInstructionImpl(this, target, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.667 -0400", hash_original_method = "194421EA05B5C62E27597F16A7528043", hash_generated_method = "EFB82AA4AA2C664F9ED60B53951F6435")
    public TextImpl createTextNode(String data) {
        addTaint(data.getTaint());
TextImpl varD13621AEB8B98070CD69DC7C279B3075_1381750880 =         new TextImpl(this, data);
        varD13621AEB8B98070CD69DC7C279B3075_1381750880.addTaint(taint);
        return varD13621AEB8B98070CD69DC7C279B3075_1381750880;
        // ---------- Original Method ----------
        //return new TextImpl(this, data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.667 -0400", hash_original_method = "D024EAB4EE7007F22F93D8BE399D2ED2", hash_generated_method = "984C4110EC32AAB6584B898720407FF2")
    public DocumentType getDoctype() {
for(LeafNodeImpl child : children)
        {
    if(child instanceof DocumentType)            
            {
DocumentType var0498972267A749CF8B0A92E3BA5C7EB7_1629132396 =                 (DocumentType) child;
                var0498972267A749CF8B0A92E3BA5C7EB7_1629132396.addTaint(taint);
                return var0498972267A749CF8B0A92E3BA5C7EB7_1629132396;
            } //End block
        } //End block
DocumentType var540C13E9E156B687226421B24F2DF178_548817011 =         null;
        var540C13E9E156B687226421B24F2DF178_548817011.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_548817011;
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof DocumentType) {
                //return (DocumentType) child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.668 -0400", hash_original_method = "59978D20A08E2A3D10080AFCDAEC6A5E", hash_generated_method = "16BC71A2DB017852DA1347BB1D1CCCFC")
    public Element getDocumentElement() {
for(LeafNodeImpl child : children)
        {
    if(child instanceof Element)            
            {
Element var52E420693F147DB2DE17E047C7CA0895_1859565819 =                 (Element) child;
                var52E420693F147DB2DE17E047C7CA0895_1859565819.addTaint(taint);
                return var52E420693F147DB2DE17E047C7CA0895_1859565819;
            } //End block
        } //End block
Element var540C13E9E156B687226421B24F2DF178_590890161 =         null;
        var540C13E9E156B687226421B24F2DF178_590890161.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_590890161;
        // ---------- Original Method ----------
        //for (LeafNodeImpl child : children) {
            //if (child instanceof Element) {
                //return (Element) child;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.668 -0400", hash_original_method = "F4A17E55F2C93FA371B29DDF570BB5F6", hash_generated_method = "131D846975CBC9269653FE0AA8592AEC")
    public Element getElementById(String elementId) {
        addTaint(elementId.getTaint());
        ElementImpl root = (ElementImpl) getDocumentElement();
Element varEB03DC82262B48F10745A4ABBCED7432_1618222401 =         (root == null ? null : root.getElementById(elementId));
        varEB03DC82262B48F10745A4ABBCED7432_1618222401.addTaint(taint);
        return varEB03DC82262B48F10745A4ABBCED7432_1618222401;
        // ---------- Original Method ----------
        //ElementImpl root = (ElementImpl) getDocumentElement();
        //return (root == null ? null : root.getElementById(elementId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.668 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "00186566FA593C50C6C9D505DA79A7C9")
    public NodeList getElementsByTagName(String name) {
        addTaint(name.getTaint());
        NodeListImpl result = new NodeListImpl();
        getElementsByTagName(result, name);
NodeList varDC838461EE2FA0CA4C9BBB70A15456B0_545281663 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_545281663.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_545281663;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagName(result, name);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.669 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "C07CCDA8A3E65BB7FFDEEE23873A3B5A")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        addTaint(localName.getTaint());
        addTaint(namespaceURI.getTaint());
        NodeListImpl result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
NodeList varDC838461EE2FA0CA4C9BBB70A15456B0_59331462 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_59331462.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_59331462;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagNameNS(result, namespaceURI, localName);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.669 -0400", hash_original_method = "871220F29645F989F5FF83627B59D2B9", hash_generated_method = "CE1ECC2F501715EA7419FADEE3CF4725")
    public DOMImplementation getImplementation() {
DOMImplementation var0CB0D946FB5941C9150C9E48B5077394_1180367377 =         domImplementation;
        var0CB0D946FB5941C9150C9E48B5077394_1180367377.addTaint(taint);
        return var0CB0D946FB5941C9150C9E48B5077394_1180367377;
        // ---------- Original Method ----------
        //return domImplementation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.669 -0400", hash_original_method = "3823D9F624F2EC5FAA072B7BE8806F96", hash_generated_method = "61BB24EBF5D7ECD62337773F7DB3604E")
    @Override
    public String getNodeName() {
String var184E07E47A1EBD9CDE63E55F8C3223BD_544016789 =         "#document";
        var184E07E47A1EBD9CDE63E55F8C3223BD_544016789.addTaint(taint);
        return var184E07E47A1EBD9CDE63E55F8C3223BD_544016789;
        // ---------- Original Method ----------
        //return "#document";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.670 -0400", hash_original_method = "043CCE8DE1A8362BF53702E45F3637E9", hash_generated_method = "915788BB5DAD0FB051ACDB4405D508A4")
    @Override
    public short getNodeType() {
        short var9DC38E743DEA0184187604DE55890A66_1198632783 = (Node.DOCUMENT_NODE);
                short var4F09DAA9D95BCB166A302407A0E0BABE_1672895489 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1672895489;
        // ---------- Original Method ----------
        //return Node.DOCUMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.670 -0400", hash_original_method = "C51ADCEBFAB6A11E8C0AA42A3197A4ED", hash_generated_method = "7A64A052C46BEE8F1954A26041DB1C32")
    @Override
    public Node insertChildAt(Node toInsert, int index) {
        addTaint(index);
        addTaint(toInsert.getTaint());
    if(toInsert instanceof Element && getDocumentElement() != null)        
        {
            DOMException var6EFB525E3BA58214860A1ECCBE7B0554_1649750025 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one root element allowed");
            var6EFB525E3BA58214860A1ECCBE7B0554_1649750025.addTaint(taint);
            throw var6EFB525E3BA58214860A1ECCBE7B0554_1649750025;
        } //End block
    if(toInsert instanceof DocumentType && getDoctype() != null)        
        {
            DOMException var4E5075F9F62ABDFD65E549C3A33CA64A_1807001636 = new DOMException(DOMException.HIERARCHY_REQUEST_ERR,
                    "Only one DOCTYPE element allowed");
            var4E5075F9F62ABDFD65E549C3A33CA64A_1807001636.addTaint(taint);
            throw var4E5075F9F62ABDFD65E549C3A33CA64A_1807001636;
        } //End block
Node varC4CD74D80210786139448546B3578BE5_423652116 =         super.insertChildAt(toInsert, index);
        varC4CD74D80210786139448546B3578BE5_423652116.addTaint(taint);
        return varC4CD74D80210786139448546B3578BE5_423652116;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.671 -0400", hash_original_method = "523640531DE4ABEBCC885A0C8EFFAA8E", hash_generated_method = "58F6AB8A64B966EF566298FE571D432A")
    @Override
    public String getTextContent() {
String var540C13E9E156B687226421B24F2DF178_472050379 =         null;
        var540C13E9E156B687226421B24F2DF178_472050379.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_472050379;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.671 -0400", hash_original_method = "94C9917BD9FB417B21D37D438D58D41C", hash_generated_method = "FD4D3769A00EC6B2763A134267961E6A")
    public String getInputEncoding() {
String varAF565BD5329AC6390DBCBCB5155BFF73_1702185204 =         inputEncoding;
        varAF565BD5329AC6390DBCBCB5155BFF73_1702185204.addTaint(taint);
        return varAF565BD5329AC6390DBCBCB5155BFF73_1702185204;
        // ---------- Original Method ----------
        //return inputEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.671 -0400", hash_original_method = "54494C811BAA1F5B46191C70DF542771", hash_generated_method = "6582572FDF9DAACB02A7611123CD397C")
    public String getXmlEncoding() {
String var73B8B2E9305670B097C62E479C746550_1227720045 =         xmlEncoding;
        var73B8B2E9305670B097C62E479C746550_1227720045.addTaint(taint);
        return var73B8B2E9305670B097C62E479C746550_1227720045;
        // ---------- Original Method ----------
        //return xmlEncoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.671 -0400", hash_original_method = "A9BBCA9526831CCA3B1BE6D8EEF33ABE", hash_generated_method = "D5DD137913AD04951E35D4BA64E1E083")
    public boolean getXmlStandalone() {
        boolean var8D032D498937B83920DC3FA77257B667_1983792697 = (xmlStandalone);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_431209248 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_431209248;
        // ---------- Original Method ----------
        //return xmlStandalone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.672 -0400", hash_original_method = "9E601CBC8BB08C0D3B66A0213931419B", hash_generated_method = "9E81AB93ADB44B2013F3533C3DA5BE8E")
    public void setXmlStandalone(boolean xmlStandalone) {
        this.xmlStandalone = xmlStandalone;
        // ---------- Original Method ----------
        //this.xmlStandalone = xmlStandalone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.672 -0400", hash_original_method = "BC354AC833FDCF3905B7FEDC7BFD541D", hash_generated_method = "93AAF01CE470629C29AE4F8D88914C2C")
    public String getXmlVersion() {
String varB592761CA9968991FA44D1528F93C283_1715960285 =         xmlVersion;
        varB592761CA9968991FA44D1528F93C283_1715960285.addTaint(taint);
        return varB592761CA9968991FA44D1528F93C283_1715960285;
        // ---------- Original Method ----------
        //return xmlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.673 -0400", hash_original_method = "C0A21B3EE9603BF0EAE2488DE43FD78E", hash_generated_method = "1D025D03CF816AA6E6E7E13C188987CA")
    public void setXmlVersion(String xmlVersion) {
        this.xmlVersion = xmlVersion;
        // ---------- Original Method ----------
        //this.xmlVersion = xmlVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.673 -0400", hash_original_method = "338EEC38209BE0DB329E33E9EDD7ED88", hash_generated_method = "3C888A918F96C88DEE979789FF70404A")
    public boolean getStrictErrorChecking() {
        boolean var45AE3A38A330419EF5540FA43DEE084B_2096817011 = (strictErrorChecking);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2033275711 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2033275711;
        // ---------- Original Method ----------
        //return strictErrorChecking;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.673 -0400", hash_original_method = "55375073A29EAEC23495FBD30A28EDB3", hash_generated_method = "B5D30D71D7A11256EBFA7BCECCF3D144")
    public void setStrictErrorChecking(boolean strictErrorChecking) {
        this.strictErrorChecking = strictErrorChecking;
        // ---------- Original Method ----------
        //this.strictErrorChecking = strictErrorChecking;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.674 -0400", hash_original_method = "2433E48CE07A4EB6DFAAA40EF72A0853", hash_generated_method = "749E286B18A10981D8C126BB74AEA9E0")
    public String getDocumentURI() {
String varDD799FF124BC34A6AA6495A09CB91A11_404728196 =         documentUri;
        varDD799FF124BC34A6AA6495A09CB91A11_404728196.addTaint(taint);
        return varDD799FF124BC34A6AA6495A09CB91A11_404728196;
        // ---------- Original Method ----------
        //return documentUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.674 -0400", hash_original_method = "2ABB3572AC2E2195C4BFB544AFA05B7C", hash_generated_method = "88DFDC039A98BD865B0FDF5C62AD2EAE")
    public void setDocumentURI(String documentUri) {
        this.documentUri = documentUri;
        // ---------- Original Method ----------
        //this.documentUri = documentUri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.674 -0400", hash_original_method = "9C5D9FE4294F6D7509E6E0C2DA50CF2D", hash_generated_method = "D616942B52FA1FFC8BF650A704E9032A")
    public DOMConfiguration getDomConfig() {
    if(domConfiguration == null)        
        {
            domConfiguration = new DOMConfigurationImpl();
        } //End block
DOMConfiguration var0D370929C0EBAAB3536D872023877E23_584563902 =         domConfiguration;
        var0D370929C0EBAAB3536D872023877E23_584563902.addTaint(taint);
        return var0D370929C0EBAAB3536D872023877E23_584563902;
        // ---------- Original Method ----------
        //if (domConfiguration == null) {
            //domConfiguration = new DOMConfigurationImpl();
        //}
        //return domConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.675 -0400", hash_original_method = "89D7CC816429D9C559DCCAF8A85B9CA9", hash_generated_method = "382B37736C48E4651B0923427E76B4A0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.675 -0400", hash_original_method = "83962F2DF698AAA6D760C50C082C5A3C", hash_generated_method = "41DD27C99EA68451DBB39336041EF9FD")
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
Map<String, UserData> varC9322CB19A196C9D9117A684D649D268_1063110520 =         userDataMap;
        varC9322CB19A196C9D9117A684D649D268_1063110520.addTaint(taint);
        return varC9322CB19A196C9D9117A684D649D268_1063110520;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.676 -0400", hash_original_method = "8B5F30F59CCBC9322DB0F048DEF01A52", hash_generated_method = "90A5AE075F8D53D27B588B7E03D337E3")
     Map<String, UserData> getUserDataMapForRead(NodeImpl node) {
        addTaint(node.getTaint());
    if(nodeToUserData == null)        
        {
Map<String, UserData> varA32ED10B45EA6ACB8D1ECFEFE1C18540_1921543769 =             Collections.emptyMap();
            varA32ED10B45EA6ACB8D1ECFEFE1C18540_1921543769.addTaint(taint);
            return varA32ED10B45EA6ACB8D1ECFEFE1C18540_1921543769;
        } //End block
        Map<String, UserData> userDataMap = nodeToUserData.get(node);
Map<String, UserData> varD826347363F7164F3227DB7372F59AE9_1079004375 =         userDataMap == null
                ? Collections.<String, UserData>emptyMap()
                : userDataMap;
        varD826347363F7164F3227DB7372F59AE9_1079004375.addTaint(taint);
        return varD826347363F7164F3227DB7372F59AE9_1079004375;
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

