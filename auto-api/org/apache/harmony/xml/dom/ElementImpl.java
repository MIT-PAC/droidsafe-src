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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.956 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.956 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.956 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.956 -0400", hash_original_field = "E62B9ECBD883C26642197A7DC8246D3C", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.956 -0400", hash_original_field = "D7461AFEBA4ED0DC3AB3D12F77C8DA48", hash_generated_field = "370A7E27C76BC902168F8323D6CEB238")

    private List<AttrImpl> attributes = new ArrayList<AttrImpl>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.956 -0400", hash_original_method = "E83037DBBA9A213D892AFBAECFD42006", hash_generated_method = "B4C8F7A3379A1792597209CAFC9B21E5")
      ElementImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        setNameNS(this, namespaceURI, qualifiedName);
        addTaint(document.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        // ---------- Original Method ----------
        //setNameNS(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.957 -0400", hash_original_method = "D2CD0310D5C8F85822C82439B7C2ED0A", hash_generated_method = "70C1123D5E98FE030C6FA18966F03C09")
      ElementImpl(DocumentImpl document, String name) {
        super(document);
        setName(this, name);
        addTaint(document.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //setName(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.957 -0400", hash_original_method = "33812125B5F046930FB02168EEB43D40", hash_generated_method = "B7689D65A05DC48A04F1B3788F6E138B")
    private int indexOfAttribute(String name) {
        {
            int i;
            i = 0;
            boolean var4BF9AA01498A302A953E7B72FFE2E6DF_589381664 = (i < attributes.size());
            {
                AttrImpl attr;
                attr = attributes.get(i);
                {
                    boolean var7BAD3BFC039F765668FE34CB011AC143_1383835061 = (Objects.equal(name, attr.getNodeName()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_740325807 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_740325807;
        // ---------- Original Method ----------
        //for (int i = 0; i < attributes.size(); i++) {
            //AttrImpl attr = attributes.get(i);
            //if (Objects.equal(name, attr.getNodeName())) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.958 -0400", hash_original_method = "7BDB91D541F3C8F5E0B377A9C520D55B", hash_generated_method = "6CB4D4B9CFFD7081D8D22F8926397FA2")
    private int indexOfAttributeNS(String namespaceURI, String localName) {
        {
            int i;
            i = 0;
            boolean var4BF9AA01498A302A953E7B72FFE2E6DF_287372129 = (i < attributes.size());
            {
                AttrImpl attr;
                attr = attributes.get(i);
                {
                    boolean var862ADD8BB15D0BE1810DD35AF160FA42_167691275 = (Objects.equal(namespaceURI, attr.getNamespaceURI())
                    && Objects.equal(localName, attr.getLocalName()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565079069 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565079069;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.959 -0400", hash_original_method = "813C4DD10F102D6D885192D956222478", hash_generated_method = "B94059C7B90B16C5596A90A0D05DD894")
    public String getAttribute(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1560391251 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1883036149 = null; //Variable for return #2
        Attr attr;
        attr = getAttributeNode(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1560391251 = "";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1883036149 = attr.getValue();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1497855141; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1497855141 = varB4EAC82CA7396A68D541C85D26508E83_1560391251;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1497855141 = varB4EAC82CA7396A68D541C85D26508E83_1883036149;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1497855141.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1497855141;
        // ---------- Original Method ----------
        //Attr attr = getAttributeNode(name);
        //if (attr == null) {
            //return "";
        //}
        //return attr.getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.974 -0400", hash_original_method = "2AD352ABD4B75CC40A48A87FB5C80EF1", hash_generated_method = "2671129EDB6F9A80198AFA952E22A0DD")
    public String getAttributeNS(String namespaceURI, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1788618166 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_452354626 = null; //Variable for return #2
        Attr attr;
        attr = getAttributeNodeNS(namespaceURI, localName);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1788618166 = "";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_452354626 = attr.getValue();
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_480844083; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_480844083 = varB4EAC82CA7396A68D541C85D26508E83_1788618166;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_480844083 = varB4EAC82CA7396A68D541C85D26508E83_452354626;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_480844083.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_480844083;
        // ---------- Original Method ----------
        //Attr attr = getAttributeNodeNS(namespaceURI, localName);
        //if (attr == null) {
            //return "";
        //}
        //return attr.getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.974 -0400", hash_original_method = "83D3ED81624F77A7E713E4996ABE0363", hash_generated_method = "1EB7091F04F36C1D2CC4F6C072E78CF5")
    public AttrImpl getAttributeNode(String name) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_804626202 = null; //Variable for return #1
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_2112675034 = null; //Variable for return #2
        int i;
        i = indexOfAttribute(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_804626202 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2112675034 = attributes.get(i);
        addTaint(name.getTaint());
        AttrImpl varA7E53CE21691AB073D9660D615818899_532908805; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_532908805 = varB4EAC82CA7396A68D541C85D26508E83_804626202;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_532908805 = varB4EAC82CA7396A68D541C85D26508E83_2112675034;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_532908805.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_532908805;
        // ---------- Original Method ----------
        //int i = indexOfAttribute(name);
        //if (i == -1) {
            //return null;
        //}
        //return attributes.get(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.975 -0400", hash_original_method = "3B62D6330977637E22606F97FB7DAA33", hash_generated_method = "00CF4F39A65C64ADF0B2499B81C0900D")
    public AttrImpl getAttributeNodeNS(String namespaceURI, String localName) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_1444028346 = null; //Variable for return #1
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_2045911505 = null; //Variable for return #2
        int i;
        i = indexOfAttributeNS(namespaceURI, localName);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1444028346 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2045911505 = attributes.get(i);
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        AttrImpl varA7E53CE21691AB073D9660D615818899_1909582939; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1909582939 = varB4EAC82CA7396A68D541C85D26508E83_1444028346;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1909582939 = varB4EAC82CA7396A68D541C85D26508E83_2045911505;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1909582939.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1909582939;
        // ---------- Original Method ----------
        //int i = indexOfAttributeNS(namespaceURI, localName);
        //if (i == -1) {
            //return null;
        //}
        //return attributes.get(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.976 -0400", hash_original_method = "DB6D276ECDED2CB7A7381953F02FE1C2", hash_generated_method = "927453718A5B8DBEE83AB35733FABBA1")
    @Override
    public NamedNodeMap getAttributes() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_514224275 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_514224275 = new ElementAttrNamedNodeMapImpl();
        varB4EAC82CA7396A68D541C85D26508E83_514224275.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_514224275;
        // ---------- Original Method ----------
        //return new ElementAttrNamedNodeMapImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.034 -0400", hash_original_method = "75972D234B77F7219B8A807D51F2F4BE", hash_generated_method = "D8862EE28195AD3C5D6C8D84F09C49A7")
     Element getElementById(String name) {
        Element varB4EAC82CA7396A68D541C85D26508E83_679387864 = null; //Variable for return #1
        Element varB4EAC82CA7396A68D541C85D26508E83_1449058650 = null; //Variable for return #2
        Element varB4EAC82CA7396A68D541C85D26508E83_1227113106 = null; //Variable for return #3
        Element varB4EAC82CA7396A68D541C85D26508E83_436123978 = null; //Variable for return #4
        {
            Iterator<Attr> var85569F768AA62BA2E033CE436AD30008_1026396681 = (attributes).iterator();
            var85569F768AA62BA2E033CE436AD30008_1026396681.hasNext();
            Attr attr = var85569F768AA62BA2E033CE436AD30008_1026396681.next();
            {
                {
                    boolean varDE620A923FB4415A0C3EC0AB13170E4C_1828816889 = (attr.isId() && name.equals(attr.getValue()));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_679387864 = this;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAA388FAC5E10062A184F3A6F89066921_1987300794 = (name.equals(getAttribute("id")));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1449058650 = this;
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_1509242523 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_1509242523.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_1509242523.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_489411945 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        Element element;
                        element = ((ElementImpl) node).getElementById(name);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1227113106 = element;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_436123978 = null;
        addTaint(name.getTaint());
        Element varA7E53CE21691AB073D9660D615818899_1816874590; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1816874590 = varB4EAC82CA7396A68D541C85D26508E83_679387864;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1816874590 = varB4EAC82CA7396A68D541C85D26508E83_1449058650;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1816874590 = varB4EAC82CA7396A68D541C85D26508E83_1227113106;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1816874590 = varB4EAC82CA7396A68D541C85D26508E83_436123978;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1816874590.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1816874590;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.035 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "0BAB146DCF55046CF257696028B47DF5")
    public NodeList getElementsByTagName(String name) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_1273445598 = null; //Variable for return #1
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagName(result, name);
        varB4EAC82CA7396A68D541C85D26508E83_1273445598 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1273445598.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1273445598;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagName(result, name);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.035 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "C6362D9B507C70BDD47B28F344267336")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_1505419235 = null; //Variable for return #1
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        varB4EAC82CA7396A68D541C85D26508E83_1505419235 = result;
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1505419235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1505419235;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagNameNS(result, namespaceURI, localName);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.036 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "3E696125173FECF68121E84C107C72C7")
    @Override
    public String getLocalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1615108591 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1615108591 = namespaceAware ? localName : null;
        varB4EAC82CA7396A68D541C85D26508E83_1615108591.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1615108591;
        // ---------- Original Method ----------
        //return namespaceAware ? localName : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.036 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "651A876E1D2DB7DFB3FCB3F8508EF34A")
    @Override
    public String getNamespaceURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1393934233 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1393934233 = namespaceURI;
        varB4EAC82CA7396A68D541C85D26508E83_1393934233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1393934233;
        // ---------- Original Method ----------
        //return namespaceURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.042 -0400", hash_original_method = "24A50BD0D938263A925A0CD0D8B09D61", hash_generated_method = "096CF09B99E2A1C43301A88CB6FB2921")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_218437616 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_218437616 = getTagName();
        varB4EAC82CA7396A68D541C85D26508E83_218437616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_218437616;
        // ---------- Original Method ----------
        //return getTagName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.042 -0400", hash_original_method = "8EDB6CFF77634EC46F3FE6E39D5C4072", hash_generated_method = "D3C9889F2569B053F1E2D22F58FA7781")
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_1532323377 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1532323377;
        // ---------- Original Method ----------
        //return Node.ELEMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.042 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "92D9245A8078205B658C901BA0C6E762")
    @Override
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_961698811 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_961698811 = prefix;
        varB4EAC82CA7396A68D541C85D26508E83_961698811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_961698811;
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.043 -0400", hash_original_method = "84D6D79E2DD8ACB2C7098589FE413C76", hash_generated_method = "D1A523C5E319E620C03FD81914D49964")
    public String getTagName() {
        String varB4EAC82CA7396A68D541C85D26508E83_686977022 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_686977022 = prefix != null
                ? prefix + ":" + localName
                : localName;
        varB4EAC82CA7396A68D541C85D26508E83_686977022.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_686977022;
        // ---------- Original Method ----------
        //return prefix != null
                //? prefix + ":" + localName
                //: localName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.043 -0400", hash_original_method = "6C8F2E9D9AC7653B36D8183C37FDC271", hash_generated_method = "D798B16A57B2574A5F20547F7D3D62BA")
    public boolean hasAttribute(String name) {
        boolean var9A6B46C7A05A149C7FD72F2126229268_1307656561 = (indexOfAttribute(name) != -1);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_32251447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_32251447;
        // ---------- Original Method ----------
        //return indexOfAttribute(name) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.043 -0400", hash_original_method = "A72242585FC8C818B78134FE05A6EE18", hash_generated_method = "5672BD7A32FD7A613338D07739127FEA")
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        boolean varFD44CF5CE0E790CFF22EA7E5CF2E4CA0_671099674 = (indexOfAttributeNS(namespaceURI, localName) != -1);
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2006911874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2006911874;
        // ---------- Original Method ----------
        //return indexOfAttributeNS(namespaceURI, localName) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.047 -0400", hash_original_method = "F148456BA584CDD324D3AD480B7851B4", hash_generated_method = "88AFF5269D820722E45D03B48D2BB7CA")
    @Override
    public boolean hasAttributes() {
        boolean varC14277A36C5456E69030CF13195697F1_1228579907 = (!attributes.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_142302312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_142302312;
        // ---------- Original Method ----------
        //return !attributes.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.047 -0400", hash_original_method = "8DBF320E88520709ECE3A3A8169ED4DA", hash_generated_method = "B87F937971CBA28DD295BB23CAD1582D")
    public void removeAttribute(String name) throws DOMException {
        int i;
        i = indexOfAttribute(name);
        {
            attributes.remove(i);
        } //End block
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //int i = indexOfAttribute(name);
        //if (i != -1) {
            //attributes.remove(i);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.047 -0400", hash_original_method = "DB944C5E777E2AB6A4CA622A526DBBB8", hash_generated_method = "F365A6BF581B18103266D7DCF7910ABB")
    public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
        int i;
        i = indexOfAttributeNS(namespaceURI, localName);
        {
            attributes.remove(i);
        } //End block
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        // ---------- Original Method ----------
        //int i = indexOfAttributeNS(namespaceURI, localName);
        //if (i != -1) {
            //attributes.remove(i);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.049 -0400", hash_original_method = "48A4F4D8663A7BAF5C33913CE98C9411", hash_generated_method = "2D0E2E35BE7318EA7F221C18BC1F56E2")
    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
        Attr varB4EAC82CA7396A68D541C85D26508E83_1209656003 = null; //Variable for return #1
        AttrImpl oldAttrImpl;
        oldAttrImpl = (AttrImpl) oldAttr;
        {
            boolean var5F8EC0C033C14176F1E7190A783BB3E6_1942395963 = (oldAttrImpl.getOwnerElement() != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } //End block
        } //End collapsed parenthetic
        attributes.remove(oldAttrImpl);
        oldAttrImpl.ownerElement = null;
        varB4EAC82CA7396A68D541C85D26508E83_1209656003 = oldAttrImpl;
        addTaint(oldAttr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1209656003.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1209656003;
        // ---------- Original Method ----------
        //AttrImpl oldAttrImpl = (AttrImpl) oldAttr;
        //if (oldAttrImpl.getOwnerElement() != this) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
        //}
        //attributes.remove(oldAttrImpl);
        //oldAttrImpl.ownerElement = null;
        //return oldAttrImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.049 -0400", hash_original_method = "6DCEAAD8535FDF367A6D4293F8DE36CE", hash_generated_method = "4ED2A70962C28A86547349547AB239D5")
    public void setAttribute(String name, String value) throws DOMException {
        Attr attr;
        attr = getAttributeNode(name);
        {
            attr = document.createAttribute(name);
            setAttributeNode(attr);
        } //End block
        attr.setValue(value);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //Attr attr = getAttributeNode(name);
        //if (attr == null) {
            //attr = document.createAttribute(name);
            //setAttributeNode(attr);
        //}
        //attr.setValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.055 -0400", hash_original_method = "F2270012ECC9DDE7A199A2B08906CDAC", hash_generated_method = "76EBD549894A536A1C74746376F6127B")
    public void setAttributeNS(String namespaceURI, String qualifiedName,
            String value) throws DOMException {
        Attr attr;
        attr = getAttributeNodeNS(namespaceURI, qualifiedName);
        {
            attr = document.createAttributeNS(namespaceURI, qualifiedName);
            setAttributeNodeNS(attr);
        } //End block
        attr.setValue(value);
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //Attr attr = getAttributeNodeNS(namespaceURI, qualifiedName);
        //if (attr == null) {
            //attr = document.createAttributeNS(namespaceURI, qualifiedName);
            //setAttributeNodeNS(attr);
        //}
        //attr.setValue(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.066 -0400", hash_original_method = "2863AD660D70C60FE387E2DF61C003C1", hash_generated_method = "411A90E885BA7FD15936A3D8D0676484")
    public Attr setAttributeNode(Attr newAttr) throws DOMException {
        Attr varB4EAC82CA7396A68D541C85D26508E83_848268521 = null; //Variable for return #1
        AttrImpl newAttrImpl;
        newAttrImpl = (AttrImpl) newAttr;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var877A67893D24F6B22E8A0E6DF1EAF1B0_1327939940 = (newAttrImpl.getOwnerElement() != null);
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
        varB4EAC82CA7396A68D541C85D26508E83_848268521 = oldAttrImpl;
        addTaint(newAttr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_848268521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_848268521;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.067 -0400", hash_original_method = "1229E8AF3668CCD52190CAB83AB0EAC8", hash_generated_method = "0E71D0FFB8F95D18A72DFEAFCBAC6731")
    public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
        Attr varB4EAC82CA7396A68D541C85D26508E83_681506887 = null; //Variable for return #1
        AttrImpl newAttrImpl;
        newAttrImpl = (AttrImpl) newAttr;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var877A67893D24F6B22E8A0E6DF1EAF1B0_118131076 = (newAttrImpl.getOwnerElement() != null);
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
        varB4EAC82CA7396A68D541C85D26508E83_681506887 = oldAttrImpl;
        addTaint(newAttr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_681506887.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_681506887;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.067 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "756E644F22A977734EE8F4F9494CEE85")
    @Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        // ---------- Original Method ----------
        //this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.079 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "201575239338968515F1300D02E54601")
    public TypeInfo getSchemaTypeInfo() {
        TypeInfo varB4EAC82CA7396A68D541C85D26508E83_1896277395 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1896277395 = NULL_TYPE_INFO;
        varB4EAC82CA7396A68D541C85D26508E83_1896277395.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1896277395;
        // ---------- Original Method ----------
        //return NULL_TYPE_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.079 -0400", hash_original_method = "E2D0D43F42925D6B235314ECDF3F88D2", hash_generated_method = "8F7C228C9CA428DE149B33BB88D9BE85")
    public void setIdAttribute(String name, boolean isId) throws DOMException {
        AttrImpl attr;
        attr = getAttributeNode(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + name);
        } //End block
        attr.isId = isId;
        addTaint(name.getTaint());
        addTaint(isId);
        // ---------- Original Method ----------
        //AttrImpl attr = getAttributeNode(name);
        //if (attr == null) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR,
                    //"No such attribute: " + name);
        //}
        //attr.isId = isId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.079 -0400", hash_original_method = "EB4B24B3B95C74A915F87535C0F28019", hash_generated_method = "BA68B2DCBA77D95128659EA8A0E28F6D")
    public void setIdAttributeNS(String namespaceURI, String localName,
            boolean isId) throws DOMException {
        AttrImpl attr;
        attr = getAttributeNodeNS(namespaceURI, localName);
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR,
                    "No such attribute: " + namespaceURI +  " " + localName);
        } //End block
        attr.isId = isId;
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        addTaint(isId);
        // ---------- Original Method ----------
        //AttrImpl attr = getAttributeNodeNS(namespaceURI, localName);
        //if (attr == null) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR,
                    //"No such attribute: " + namespaceURI +  " " + localName);
        //}
        //attr.isId = isId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.080 -0400", hash_original_method = "D45D107EAB7744EE0777BE918C2E0DD2", hash_generated_method = "E2B7E4981C910FE7A405E777C907172A")
    public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
        ((AttrImpl) idAttr).isId = isId;
        addTaint(idAttr.getTaint());
        addTaint(isId);
        // ---------- Original Method ----------
        //((AttrImpl) idAttr).isId = isId;
    }

    
    public class ElementAttrNamedNodeMapImpl implements NamedNodeMap {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.080 -0400", hash_original_method = "4DE56E7A278FE2CED469184A8A1F6E47", hash_generated_method = "4DE56E7A278FE2CED469184A8A1F6E47")
        public ElementAttrNamedNodeMapImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.080 -0400", hash_original_method = "FF1F71CDD63994FD93D39F9EA196EECF", hash_generated_method = "7B8E67ABB16BB022837F2F6C26EC73A5")
        public int getLength() {
            int var885D16ACBA3AAF937512B6C61A3B731A_785055306 = (ElementImpl.this.attributes.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085210436 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2085210436;
            // ---------- Original Method ----------
            //return ElementImpl.this.attributes.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.081 -0400", hash_original_method = "DC316EFAFE6C9719F9A6712C7C0724A1", hash_generated_method = "62C073F4AA990BFA0F28BC027E00CEC5")
        private int indexOfItem(String name) {
            int var4539B068F44D8760B8121FFD1C636043_1417069177 = (ElementImpl.this.indexOfAttribute(name));
            addTaint(name.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120150943 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1120150943;
            // ---------- Original Method ----------
            //return ElementImpl.this.indexOfAttribute(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.082 -0400", hash_original_method = "258D65E063DA88D4950E14323AAE31E6", hash_generated_method = "7A39F4254D84C439722D8F788F3E6347")
        private int indexOfItemNS(String namespaceURI, String localName) {
            int var6BB86ADC07E7A5ED0C713094AF81B0B0_1741932597 = (ElementImpl.this.indexOfAttributeNS(namespaceURI, localName));
            addTaint(namespaceURI.getTaint());
            addTaint(localName.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2145798279 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2145798279;
            // ---------- Original Method ----------
            //return ElementImpl.this.indexOfAttributeNS(namespaceURI, localName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.090 -0400", hash_original_method = "5386255E2AB4AB2C7C1C9B01DBB08720", hash_generated_method = "A1A3416F1D2D7A1699213CCC3D892B7C")
        public Node getNamedItem(String name) {
            Node varB4EAC82CA7396A68D541C85D26508E83_1477724361 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1477724361 = ElementImpl.this.getAttributeNode(name);
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1477724361.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1477724361;
            // ---------- Original Method ----------
            //return ElementImpl.this.getAttributeNode(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.090 -0400", hash_original_method = "4A42E6CB38C61058D8EEC911A360EDF7", hash_generated_method = "8578277BDB15FFA5341A043125F0F4C4")
        public Node getNamedItemNS(String namespaceURI, String localName) {
            Node varB4EAC82CA7396A68D541C85D26508E83_1834583015 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1834583015 = ElementImpl.this.getAttributeNodeNS(namespaceURI, localName);
            addTaint(namespaceURI.getTaint());
            addTaint(localName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1834583015.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1834583015;
            // ---------- Original Method ----------
            //return ElementImpl.this.getAttributeNodeNS(namespaceURI, localName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.091 -0400", hash_original_method = "F60AE240A182D1B0B5E9071C74F61EEF", hash_generated_method = "221DEF723D58CC2C85F5B4CBBF07E448")
        public Node item(int index) {
            Node varB4EAC82CA7396A68D541C85D26508E83_1620301352 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1620301352 = ElementImpl.this.attributes.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1620301352.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1620301352;
            // ---------- Original Method ----------
            //return ElementImpl.this.attributes.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.091 -0400", hash_original_method = "92540DEE2EDFF119EB60FC0ECC313E2F", hash_generated_method = "41931786995B599F062226E033B408DC")
        public Node removeNamedItem(String name) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_1689208734 = null; //Variable for return #1
            int i;
            i = indexOfItem(name);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1689208734 = ElementImpl.this.attributes.remove(i);
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1689208734.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1689208734;
            // ---------- Original Method ----------
            //int i = indexOfItem(name);
            //if (i == -1) {
                //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            //}
            //return ElementImpl.this.attributes.remove(i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.096 -0400", hash_original_method = "5947BF939F7AE1F8A4D4CDE5B6951547", hash_generated_method = "D6C82B05B1FA38D3EAFFF94FE0BD92A8")
        public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_998678017 = null; //Variable for return #1
            int i;
            i = indexOfItemNS(namespaceURI, localName);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_998678017 = ElementImpl.this.attributes.remove(i);
            addTaint(namespaceURI.getTaint());
            addTaint(localName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_998678017.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_998678017;
            // ---------- Original Method ----------
            //int i = indexOfItemNS(namespaceURI, localName);
            //if (i == -1) {
                //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            //}
            //return ElementImpl.this.attributes.remove(i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.107 -0400", hash_original_method = "5D95624F12CAAE730B29BD47EADFC40A", hash_generated_method = "0514EE494C182A7253E5F1C111C50C9D")
        public Node setNamedItem(Node arg) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_550851526 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_550851526 = ElementImpl.this.setAttributeNode((Attr)arg);
            addTaint(arg.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_550851526.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_550851526;
            // ---------- Original Method ----------
            //if (!(arg instanceof Attr)) {
                //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            //}
            //return ElementImpl.this.setAttributeNode((Attr)arg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.107 -0400", hash_original_method = "74F8A255439FFDD82EF1D14936D16522", hash_generated_method = "78C667764BADEAE5570AB46F4D29D3DD")
        public Node setNamedItemNS(Node arg) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_278423745 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_278423745 = ElementImpl.this.setAttributeNodeNS((Attr)arg);
            addTaint(arg.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_278423745.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_278423745;
            // ---------- Original Method ----------
            //if (!(arg instanceof Attr)) {
                //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            //}
            //return ElementImpl.this.setAttributeNodeNS((Attr)arg);
        }

        
    }


    
}

