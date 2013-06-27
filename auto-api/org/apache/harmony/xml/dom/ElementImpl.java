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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.820 -0400", hash_original_field = "CEC00E48144CD3C5B0000055F3D7FF26", hash_generated_field = "6DED3D0909D027805E22F95BA58508AE")

    boolean namespaceAware;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.820 -0400", hash_original_field = "5295F3E9C46315AF1C2132265086FA24", hash_generated_field = "5B184DBF8D93287A0F0C8BC78758CAB7")

    String namespaceURI;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.820 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

    String prefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.820 -0400", hash_original_field = "E62B9ECBD883C26642197A7DC8246D3C", hash_generated_field = "69F110BF2CAEA76B4D1C533597A16878")

    String localName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.820 -0400", hash_original_field = "D7461AFEBA4ED0DC3AB3D12F77C8DA48", hash_generated_field = "370A7E27C76BC902168F8323D6CEB238")

    private List<AttrImpl> attributes = new ArrayList<AttrImpl>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.823 -0400", hash_original_method = "E83037DBBA9A213D892AFBAECFD42006", hash_generated_method = "B4C8F7A3379A1792597209CAFC9B21E5")
      ElementImpl(DocumentImpl document, String namespaceURI, String qualifiedName) {
        super(document);
        setNameNS(this, namespaceURI, qualifiedName);
        addTaint(document.getTaint());
        addTaint(namespaceURI.getTaint());
        addTaint(qualifiedName.getTaint());
        // ---------- Original Method ----------
        //setNameNS(this, namespaceURI, qualifiedName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.823 -0400", hash_original_method = "D2CD0310D5C8F85822C82439B7C2ED0A", hash_generated_method = "70C1123D5E98FE030C6FA18966F03C09")
      ElementImpl(DocumentImpl document, String name) {
        super(document);
        setName(this, name);
        addTaint(document.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //setName(this, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.824 -0400", hash_original_method = "33812125B5F046930FB02168EEB43D40", hash_generated_method = "8FF8667BAF444CB8A5130D884679B4AC")
    private int indexOfAttribute(String name) {
        {
            int i;
            i = 0;
            boolean var4BF9AA01498A302A953E7B72FFE2E6DF_126972981 = (i < attributes.size());
            {
                AttrImpl attr;
                attr = attributes.get(i);
                {
                    boolean var7BAD3BFC039F765668FE34CB011AC143_1261898545 = (Objects.equal(name, attr.getNodeName()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_783282874 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_783282874;
        // ---------- Original Method ----------
        //for (int i = 0; i < attributes.size(); i++) {
            //AttrImpl attr = attributes.get(i);
            //if (Objects.equal(name, attr.getNodeName())) {
                //return i;
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.826 -0400", hash_original_method = "7BDB91D541F3C8F5E0B377A9C520D55B", hash_generated_method = "064AB0B09F62DAA6C131FD2A18988809")
    private int indexOfAttributeNS(String namespaceURI, String localName) {
        {
            int i;
            i = 0;
            boolean var4BF9AA01498A302A953E7B72FFE2E6DF_1251880950 = (i < attributes.size());
            {
                AttrImpl attr;
                attr = attributes.get(i);
                {
                    boolean var862ADD8BB15D0BE1810DD35AF160FA42_477870490 = (Objects.equal(namespaceURI, attr.getNamespaceURI())
                    && Objects.equal(localName, attr.getLocalName()));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048317058 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2048317058;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.828 -0400", hash_original_method = "813C4DD10F102D6D885192D956222478", hash_generated_method = "AF85A2046898794C746AE63BFCA4D9F2")
    public String getAttribute(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_1537393270 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_336303369 = null; //Variable for return #2
        Attr attr;
        attr = getAttributeNode(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1537393270 = "";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_336303369 = attr.getValue();
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_707936844; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_707936844 = varB4EAC82CA7396A68D541C85D26508E83_1537393270;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_707936844 = varB4EAC82CA7396A68D541C85D26508E83_336303369;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_707936844.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_707936844;
        // ---------- Original Method ----------
        //Attr attr = getAttributeNode(name);
        //if (attr == null) {
            //return "";
        //}
        //return attr.getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.838 -0400", hash_original_method = "2AD352ABD4B75CC40A48A87FB5C80EF1", hash_generated_method = "7745C03A229A10FE4F551E4DD8543C29")
    public String getAttributeNS(String namespaceURI, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1330498373 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2123976977 = null; //Variable for return #2
        Attr attr;
        attr = getAttributeNodeNS(namespaceURI, localName);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1330498373 = "";
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2123976977 = attr.getValue();
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1683621231; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1683621231 = varB4EAC82CA7396A68D541C85D26508E83_1330498373;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1683621231 = varB4EAC82CA7396A68D541C85D26508E83_2123976977;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1683621231.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1683621231;
        // ---------- Original Method ----------
        //Attr attr = getAttributeNodeNS(namespaceURI, localName);
        //if (attr == null) {
            //return "";
        //}
        //return attr.getValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.839 -0400", hash_original_method = "83D3ED81624F77A7E713E4996ABE0363", hash_generated_method = "B8484FCDE2B7932B71810ABE6555F778")
    public AttrImpl getAttributeNode(String name) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_1926948780 = null; //Variable for return #1
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_1999644215 = null; //Variable for return #2
        int i;
        i = indexOfAttribute(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1926948780 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1999644215 = attributes.get(i);
        addTaint(name.getTaint());
        AttrImpl varA7E53CE21691AB073D9660D615818899_843234098; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_843234098 = varB4EAC82CA7396A68D541C85D26508E83_1926948780;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_843234098 = varB4EAC82CA7396A68D541C85D26508E83_1999644215;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_843234098.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_843234098;
        // ---------- Original Method ----------
        //int i = indexOfAttribute(name);
        //if (i == -1) {
            //return null;
        //}
        //return attributes.get(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.841 -0400", hash_original_method = "3B62D6330977637E22606F97FB7DAA33", hash_generated_method = "DB527E98271FB7331A5257F500035A82")
    public AttrImpl getAttributeNodeNS(String namespaceURI, String localName) {
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_1944948160 = null; //Variable for return #1
        AttrImpl varB4EAC82CA7396A68D541C85D26508E83_1709977128 = null; //Variable for return #2
        int i;
        i = indexOfAttributeNS(namespaceURI, localName);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1944948160 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1709977128 = attributes.get(i);
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        AttrImpl varA7E53CE21691AB073D9660D615818899_1867661381; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1867661381 = varB4EAC82CA7396A68D541C85D26508E83_1944948160;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1867661381 = varB4EAC82CA7396A68D541C85D26508E83_1709977128;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1867661381.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1867661381;
        // ---------- Original Method ----------
        //int i = indexOfAttributeNS(namespaceURI, localName);
        //if (i == -1) {
            //return null;
        //}
        //return attributes.get(i);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.841 -0400", hash_original_method = "DB6D276ECDED2CB7A7381953F02FE1C2", hash_generated_method = "8D33CED06B2261E00F63F2D4C3D1CC44")
    @Override
    public NamedNodeMap getAttributes() {
        NamedNodeMap varB4EAC82CA7396A68D541C85D26508E83_1880724680 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1880724680 = new ElementAttrNamedNodeMapImpl();
        varB4EAC82CA7396A68D541C85D26508E83_1880724680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1880724680;
        // ---------- Original Method ----------
        //return new ElementAttrNamedNodeMapImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.897 -0400", hash_original_method = "75972D234B77F7219B8A807D51F2F4BE", hash_generated_method = "34C1DDBEF7A49A8F056D0D93D627B7B0")
     Element getElementById(String name) {
        Element varB4EAC82CA7396A68D541C85D26508E83_849077380 = null; //Variable for return #1
        Element varB4EAC82CA7396A68D541C85D26508E83_1564978863 = null; //Variable for return #2
        Element varB4EAC82CA7396A68D541C85D26508E83_1501020692 = null; //Variable for return #3
        Element varB4EAC82CA7396A68D541C85D26508E83_1301958545 = null; //Variable for return #4
        {
            Iterator<Attr> var85569F768AA62BA2E033CE436AD30008_727750682 = (attributes).iterator();
            var85569F768AA62BA2E033CE436AD30008_727750682.hasNext();
            Attr attr = var85569F768AA62BA2E033CE436AD30008_727750682.next();
            {
                {
                    boolean varDE620A923FB4415A0C3EC0AB13170E4C_1437509247 = (attr.isId() && name.equals(attr.getValue()));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_849077380 = this;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean varAA388FAC5E10062A184F3A6F89066921_508386656 = (name.equals(getAttribute("id")));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1564978863 = this;
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<NodeImpl> varF58ADF1EBC9DDE72E3BE9125144A2DC8_723593941 = (children).iterator();
            varF58ADF1EBC9DDE72E3BE9125144A2DC8_723593941.hasNext();
            NodeImpl node = varF58ADF1EBC9DDE72E3BE9125144A2DC8_723593941.next();
            {
                {
                    boolean var680B8F21E738349851454831355CAC3D_1130868014 = (node.getNodeType() == Node.ELEMENT_NODE);
                    {
                        Element element;
                        element = ((ElementImpl) node).getElementById(name);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1501020692 = element;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1301958545 = null;
        addTaint(name.getTaint());
        Element varA7E53CE21691AB073D9660D615818899_849611071; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_849611071 = varB4EAC82CA7396A68D541C85D26508E83_849077380;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_849611071 = varB4EAC82CA7396A68D541C85D26508E83_1564978863;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_849611071 = varB4EAC82CA7396A68D541C85D26508E83_1501020692;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_849611071 = varB4EAC82CA7396A68D541C85D26508E83_1301958545;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_849611071.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_849611071;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.898 -0400", hash_original_method = "6E8835CC5AA6D9440E7C33D346671E0B", hash_generated_method = "44EBE32B7B4A7441212A1EE05E3C49F4")
    public NodeList getElementsByTagName(String name) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_1720341068 = null; //Variable for return #1
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagName(result, name);
        varB4EAC82CA7396A68D541C85D26508E83_1720341068 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1720341068.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1720341068;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagName(result, name);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.898 -0400", hash_original_method = "A5BCB04504E6AD1A3895B6FBC1B390B7", hash_generated_method = "295667EAE4C3C7A1F4209C2E9057B3AF")
    public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
        NodeList varB4EAC82CA7396A68D541C85D26508E83_93891791 = null; //Variable for return #1
        NodeListImpl result;
        result = new NodeListImpl();
        getElementsByTagNameNS(result, namespaceURI, localName);
        varB4EAC82CA7396A68D541C85D26508E83_93891791 = result;
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_93891791.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93891791;
        // ---------- Original Method ----------
        //NodeListImpl result = new NodeListImpl();
        //getElementsByTagNameNS(result, namespaceURI, localName);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.899 -0400", hash_original_method = "006A1593C2EDDFD80B5C8C9A0B08E49A", hash_generated_method = "9CF4B839284F648687D452FB89066EF6")
    @Override
    public String getLocalName() {
        String varB4EAC82CA7396A68D541C85D26508E83_155369865 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_155369865 = namespaceAware ? localName : null;
        varB4EAC82CA7396A68D541C85D26508E83_155369865.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_155369865;
        // ---------- Original Method ----------
        //return namespaceAware ? localName : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.900 -0400", hash_original_method = "1455FE8FE34AF373D39E8278191439A8", hash_generated_method = "46CC7B631A8E5BCCA1CD52647A392C50")
    @Override
    public String getNamespaceURI() {
        String varB4EAC82CA7396A68D541C85D26508E83_603802384 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_603802384 = namespaceURI;
        varB4EAC82CA7396A68D541C85D26508E83_603802384.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_603802384;
        // ---------- Original Method ----------
        //return namespaceURI;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.901 -0400", hash_original_method = "24A50BD0D938263A925A0CD0D8B09D61", hash_generated_method = "2BCD0FB4037B4DEA5BDE0C0C6F7B874B")
    @Override
    public String getNodeName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1128445505 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1128445505 = getTagName();
        varB4EAC82CA7396A68D541C85D26508E83_1128445505.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1128445505;
        // ---------- Original Method ----------
        //return getTagName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.901 -0400", hash_original_method = "8EDB6CFF77634EC46F3FE6E39D5C4072", hash_generated_method = "0CB4AACE9E7030C00D3C2623F7125511")
    public short getNodeType() {
        short var4F09DAA9D95BCB166A302407A0E0BABE_2054775838 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2054775838;
        // ---------- Original Method ----------
        //return Node.ELEMENT_NODE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.909 -0400", hash_original_method = "FA5CE5A0FCC0C736D9446FFEBD0CAB9D", hash_generated_method = "6089B9929C2D1DA667675DA6842B82F3")
    @Override
    public String getPrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_30875709 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_30875709 = prefix;
        varB4EAC82CA7396A68D541C85D26508E83_30875709.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_30875709;
        // ---------- Original Method ----------
        //return prefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.909 -0400", hash_original_method = "84D6D79E2DD8ACB2C7098589FE413C76", hash_generated_method = "88F9B60F95B18A30306D49C801E0C4E4")
    public String getTagName() {
        String varB4EAC82CA7396A68D541C85D26508E83_261813532 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_261813532 = prefix != null
                ? prefix + ":" + localName
                : localName;
        varB4EAC82CA7396A68D541C85D26508E83_261813532.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_261813532;
        // ---------- Original Method ----------
        //return prefix != null
                //? prefix + ":" + localName
                //: localName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.910 -0400", hash_original_method = "6C8F2E9D9AC7653B36D8183C37FDC271", hash_generated_method = "736DEFF2007798F4765224A6FE9EFF59")
    public boolean hasAttribute(String name) {
        boolean var9A6B46C7A05A149C7FD72F2126229268_2094014620 = (indexOfAttribute(name) != -1);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_965685428 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_965685428;
        // ---------- Original Method ----------
        //return indexOfAttribute(name) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.916 -0400", hash_original_method = "A72242585FC8C818B78134FE05A6EE18", hash_generated_method = "3BF82CE7B5527F63F2258E44235DD555")
    public boolean hasAttributeNS(String namespaceURI, String localName) {
        boolean varFD44CF5CE0E790CFF22EA7E5CF2E4CA0_752848815 = (indexOfAttributeNS(namespaceURI, localName) != -1);
        addTaint(namespaceURI.getTaint());
        addTaint(localName.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1489687451 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1489687451;
        // ---------- Original Method ----------
        //return indexOfAttributeNS(namespaceURI, localName) != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.916 -0400", hash_original_method = "F148456BA584CDD324D3AD480B7851B4", hash_generated_method = "AC9B97434B81933360C8021B55F2BEA5")
    @Override
    public boolean hasAttributes() {
        boolean varC14277A36C5456E69030CF13195697F1_418441044 = (!attributes.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1208282868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1208282868;
        // ---------- Original Method ----------
        //return !attributes.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.917 -0400", hash_original_method = "8DBF320E88520709ECE3A3A8169ED4DA", hash_generated_method = "B87F937971CBA28DD295BB23CAD1582D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.917 -0400", hash_original_method = "DB944C5E777E2AB6A4CA622A526DBBB8", hash_generated_method = "F365A6BF581B18103266D7DCF7910ABB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.918 -0400", hash_original_method = "48A4F4D8663A7BAF5C33913CE98C9411", hash_generated_method = "3BE79D015FE9CB02DECA5ABEFE230FFF")
    public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
        Attr varB4EAC82CA7396A68D541C85D26508E83_876267450 = null; //Variable for return #1
        AttrImpl oldAttrImpl;
        oldAttrImpl = (AttrImpl) oldAttr;
        {
            boolean var5F8EC0C033C14176F1E7190A783BB3E6_689418357 = (oldAttrImpl.getOwnerElement() != this);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } //End block
        } //End collapsed parenthetic
        attributes.remove(oldAttrImpl);
        oldAttrImpl.ownerElement = null;
        varB4EAC82CA7396A68D541C85D26508E83_876267450 = oldAttrImpl;
        addTaint(oldAttr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_876267450.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_876267450;
        // ---------- Original Method ----------
        //AttrImpl oldAttrImpl = (AttrImpl) oldAttr;
        //if (oldAttrImpl.getOwnerElement() != this) {
            //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
        //}
        //attributes.remove(oldAttrImpl);
        //oldAttrImpl.ownerElement = null;
        //return oldAttrImpl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.919 -0400", hash_original_method = "6DCEAAD8535FDF367A6D4293F8DE36CE", hash_generated_method = "4ED2A70962C28A86547349547AB239D5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.920 -0400", hash_original_method = "F2270012ECC9DDE7A199A2B08906CDAC", hash_generated_method = "76EBD549894A536A1C74746376F6127B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.923 -0400", hash_original_method = "2863AD660D70C60FE387E2DF61C003C1", hash_generated_method = "1A9AC05E0C8B3779277D22CA44E55584")
    public Attr setAttributeNode(Attr newAttr) throws DOMException {
        Attr varB4EAC82CA7396A68D541C85D26508E83_1575983399 = null; //Variable for return #1
        AttrImpl newAttrImpl;
        newAttrImpl = (AttrImpl) newAttr;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var877A67893D24F6B22E8A0E6DF1EAF1B0_211212951 = (newAttrImpl.getOwnerElement() != null);
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
        varB4EAC82CA7396A68D541C85D26508E83_1575983399 = oldAttrImpl;
        addTaint(newAttr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1575983399.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1575983399;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.924 -0400", hash_original_method = "1229E8AF3668CCD52190CAB83AB0EAC8", hash_generated_method = "4245FCF0BEDC5EFE51BC614FE7C75965")
    public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
        Attr varB4EAC82CA7396A68D541C85D26508E83_1481669848 = null; //Variable for return #1
        AttrImpl newAttrImpl;
        newAttrImpl = (AttrImpl) newAttr;
        {
            if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, null);
        } //End block
        {
            boolean var877A67893D24F6B22E8A0E6DF1EAF1B0_317259784 = (newAttrImpl.getOwnerElement() != null);
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
        varB4EAC82CA7396A68D541C85D26508E83_1481669848 = oldAttrImpl;
        addTaint(newAttr.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1481669848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1481669848;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.924 -0400", hash_original_method = "3E19055116AC2D87625766EB1DC83913", hash_generated_method = "756E644F22A977734EE8F4F9494CEE85")
    @Override
    public void setPrefix(String prefix) {
        this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
        // ---------- Original Method ----------
        //this.prefix = validatePrefix(prefix, namespaceAware, namespaceURI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.939 -0400", hash_original_method = "C51D6ACA797563231B3A9D05774313B4", hash_generated_method = "8ED471DAEFD377C09E04D9D3E5CE4316")
    public TypeInfo getSchemaTypeInfo() {
        TypeInfo varB4EAC82CA7396A68D541C85D26508E83_1875113517 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1875113517 = NULL_TYPE_INFO;
        varB4EAC82CA7396A68D541C85D26508E83_1875113517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1875113517;
        // ---------- Original Method ----------
        //return NULL_TYPE_INFO;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.939 -0400", hash_original_method = "E2D0D43F42925D6B235314ECDF3F88D2", hash_generated_method = "8F7C228C9CA428DE149B33BB88D9BE85")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.942 -0400", hash_original_method = "EB4B24B3B95C74A915F87535C0F28019", hash_generated_method = "BA68B2DCBA77D95128659EA8A0E28F6D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.964 -0400", hash_original_method = "D45D107EAB7744EE0777BE918C2E0DD2", hash_generated_method = "E2B7E4981C910FE7A405E777C907172A")
    public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
        ((AttrImpl) idAttr).isId = isId;
        addTaint(idAttr.getTaint());
        addTaint(isId);
        // ---------- Original Method ----------
        //((AttrImpl) idAttr).isId = isId;
    }

    
    public class ElementAttrNamedNodeMapImpl implements NamedNodeMap {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.964 -0400", hash_original_method = "4DE56E7A278FE2CED469184A8A1F6E47", hash_generated_method = "4DE56E7A278FE2CED469184A8A1F6E47")
        public ElementAttrNamedNodeMapImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.964 -0400", hash_original_method = "FF1F71CDD63994FD93D39F9EA196EECF", hash_generated_method = "765C03F9EA34AB592175D60DD8671BCF")
        public int getLength() {
            int var885D16ACBA3AAF937512B6C61A3B731A_1107487837 = (ElementImpl.this.attributes.size());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832749968 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_832749968;
            // ---------- Original Method ----------
            //return ElementImpl.this.attributes.size();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.965 -0400", hash_original_method = "DC316EFAFE6C9719F9A6712C7C0724A1", hash_generated_method = "BDC7CCC64809CD0B3000CFFFE8B4001F")
        private int indexOfItem(String name) {
            int var4539B068F44D8760B8121FFD1C636043_220389080 = (ElementImpl.this.indexOfAttribute(name));
            addTaint(name.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_242621877 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_242621877;
            // ---------- Original Method ----------
            //return ElementImpl.this.indexOfAttribute(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.965 -0400", hash_original_method = "258D65E063DA88D4950E14323AAE31E6", hash_generated_method = "68BAF28FD86E57080647FF45B9C20CC0")
        private int indexOfItemNS(String namespaceURI, String localName) {
            int var6BB86ADC07E7A5ED0C713094AF81B0B0_157761873 = (ElementImpl.this.indexOfAttributeNS(namespaceURI, localName));
            addTaint(namespaceURI.getTaint());
            addTaint(localName.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751829603 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1751829603;
            // ---------- Original Method ----------
            //return ElementImpl.this.indexOfAttributeNS(namespaceURI, localName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.966 -0400", hash_original_method = "5386255E2AB4AB2C7C1C9B01DBB08720", hash_generated_method = "0474683E7DD76193D3D38094FD2004F0")
        public Node getNamedItem(String name) {
            Node varB4EAC82CA7396A68D541C85D26508E83_1535015364 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1535015364 = ElementImpl.this.getAttributeNode(name);
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1535015364.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1535015364;
            // ---------- Original Method ----------
            //return ElementImpl.this.getAttributeNode(name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.966 -0400", hash_original_method = "4A42E6CB38C61058D8EEC911A360EDF7", hash_generated_method = "AD4B6A408CE5BC10CD0CE72AEB859470")
        public Node getNamedItemNS(String namespaceURI, String localName) {
            Node varB4EAC82CA7396A68D541C85D26508E83_273013476 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_273013476 = ElementImpl.this.getAttributeNodeNS(namespaceURI, localName);
            addTaint(namespaceURI.getTaint());
            addTaint(localName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_273013476.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_273013476;
            // ---------- Original Method ----------
            //return ElementImpl.this.getAttributeNodeNS(namespaceURI, localName);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.970 -0400", hash_original_method = "F60AE240A182D1B0B5E9071C74F61EEF", hash_generated_method = "27E5A176F73E8D1907FE13AF6BAE29E0")
        public Node item(int index) {
            Node varB4EAC82CA7396A68D541C85D26508E83_1636831787 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1636831787 = ElementImpl.this.attributes.get(index);
            addTaint(index);
            varB4EAC82CA7396A68D541C85D26508E83_1636831787.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1636831787;
            // ---------- Original Method ----------
            //return ElementImpl.this.attributes.get(index);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.970 -0400", hash_original_method = "92540DEE2EDFF119EB60FC0ECC313E2F", hash_generated_method = "299218537C0DC5D8B038D2496FF3ACC3")
        public Node removeNamedItem(String name) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_1411971134 = null; //Variable for return #1
            int i;
            i = indexOfItem(name);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1411971134 = ElementImpl.this.attributes.remove(i);
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1411971134.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1411971134;
            // ---------- Original Method ----------
            //int i = indexOfItem(name);
            //if (i == -1) {
                //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            //}
            //return ElementImpl.this.attributes.remove(i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.971 -0400", hash_original_method = "5947BF939F7AE1F8A4D4CDE5B6951547", hash_generated_method = "B8ED564352240495E36835923586A063")
        public Node removeNamedItemNS(String namespaceURI, String localName) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_1431257079 = null; //Variable for return #1
            int i;
            i = indexOfItemNS(namespaceURI, localName);
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1431257079 = ElementImpl.this.attributes.remove(i);
            addTaint(namespaceURI.getTaint());
            addTaint(localName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1431257079.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1431257079;
            // ---------- Original Method ----------
            //int i = indexOfItemNS(namespaceURI, localName);
            //if (i == -1) {
                //throw new DOMException(DOMException.NOT_FOUND_ERR, null);
            //}
            //return ElementImpl.this.attributes.remove(i);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.971 -0400", hash_original_method = "5D95624F12CAAE730B29BD47EADFC40A", hash_generated_method = "1E06F9EF5B27C7F00D8B9005CAB9D5C2")
        public Node setNamedItem(Node arg) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_1747965070 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1747965070 = ElementImpl.this.setAttributeNode((Attr)arg);
            addTaint(arg.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1747965070.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1747965070;
            // ---------- Original Method ----------
            //if (!(arg instanceof Attr)) {
                //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            //}
            //return ElementImpl.this.setAttributeNode((Attr)arg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.972 -0400", hash_original_method = "74F8A255439FFDD82EF1D14936D16522", hash_generated_method = "6E616EC5D4DD36F8EBF3C99674CB34E2")
        public Node setNamedItemNS(Node arg) throws DOMException {
            Node varB4EAC82CA7396A68D541C85D26508E83_1274908687 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1274908687 = ElementImpl.this.setAttributeNodeNS((Attr)arg);
            addTaint(arg.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1274908687.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1274908687;
            // ---------- Original Method ----------
            //if (!(arg instanceof Attr)) {
                //throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, null);
            //}
            //return ElementImpl.this.setAttributeNodeNS((Attr)arg);
        }

        
    }


    
}

