package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ElementType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.132 -0400", hash_original_field = "00A89501D143A41773B62B3B85C4A0FC", hash_generated_field = "8ED9B31DDDAAEF65D7BC0612CAD3C8F5")

    private String theName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.132 -0400", hash_original_field = "02D9D70DCAD40047E29468D75DED325C", hash_generated_field = "19C10BCA5601E77C9A4AD4EB7613A6D2")

    private String theNamespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.133 -0400", hash_original_field = "D11A4EA7171D20E8487A965391C55986", hash_generated_field = "908B54F8164D1728F147F01078E48FD7")

    private String theLocalName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.133 -0400", hash_original_field = "D799417756D0E4F3CEF7BE3BDCA5304D", hash_generated_field = "29F2E6973C085F18D48340ABDDFD37F9")

    private int theModel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.133 -0400", hash_original_field = "9D336585DF3A7AB55AAD7BDD3FC0C0D6", hash_generated_field = "BCDF5B935532376D5B4CFDA618EF9F39")

    private int theMemberOf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.133 -0400", hash_original_field = "B4210363C6C1EA0142699EBDD2F10BCA", hash_generated_field = "CAADB9D6664219E6AE1F0AA6CE0533C4")

    private int theFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.134 -0400", hash_original_field = "89E65547A8BBD28E301BA7733FD2E3AF", hash_generated_field = "B0A2FBEB8F242E836C1CA731A6AB041F")

    private AttributesImpl theAtts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.134 -0400", hash_original_field = "B6F8E9510A95601AE76D79092AE1B77D", hash_generated_field = "0A3173D9C249D5F313C956327888B602")

    private ElementType theParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.142 -0400", hash_original_field = "107D6A6C40AD2744AB6BBBE303D4ACFB", hash_generated_field = "B0C8961A31DE3AC8E1FA05C39CF43268")

    private Schema theSchema;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.143 -0400", hash_original_method = "B2956F900AF52D9E41A7969852791670", hash_generated_method = "ADF06BFC1D8E1E63059F3A60FA30EF72")
    public  ElementType(String name, int model, int memberOf, int flags, Schema schema) {
        theName = name;
        theModel = model;
        theMemberOf = memberOf;
        theFlags = flags;
        theAtts = new AttributesImpl();
        theSchema = schema;
        theNamespace = namespace(name, false);
        theLocalName = localName(name);
        // ---------- Original Method ----------
        //theName = name;
        //theModel = model;
        //theMemberOf = memberOf;
        //theFlags = flags;
        //theAtts = new AttributesImpl();
        //theSchema = schema;
        //theNamespace = namespace(name, false);
        //theLocalName = localName(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.151 -0400", hash_original_method = "4A889710B67B4CF3F628D3945249B60A", hash_generated_method = "9F7831DBF0A36D80F1D5A357FF58A38F")
    public String namespace(String name, boolean attribute) {
        String varB4EAC82CA7396A68D541C85D26508E83_1557178842 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_575051581 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1541918861 = null; //Variable for return #3
        int colon;
        colon = name.indexOf(':');
        {
            varB4EAC82CA7396A68D541C85D26508E83_1557178842 = attribute ? "" : theSchema.getURI();
        } //End block
        String prefix;
        prefix = name.substring(0, colon);
        {
            boolean var05D2A97F8C80619D6A9FF8AB74063B74_1075261693 = (prefix.equals("xml"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_575051581 = "http://www.w3.org/XML/1998/namespace";
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1541918861 = ("urn:x-prefix:" + prefix).intern();
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        addTaint(attribute);
        String varA7E53CE21691AB073D9660D615818899_656094046; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_656094046 = varB4EAC82CA7396A68D541C85D26508E83_1557178842;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_656094046 = varB4EAC82CA7396A68D541C85D26508E83_575051581;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_656094046 = varB4EAC82CA7396A68D541C85D26508E83_1541918861;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_656094046.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_656094046;
        // ---------- Original Method ----------
        //int colon = name.indexOf(':');
        //if (colon == -1) {
			//return attribute ? "" : theSchema.getURI();
			//}
        //String prefix = name.substring(0, colon);
        //if (prefix.equals("xml")) {
			//return "http://www.w3.org/XML/1998/namespace";
			//}
		//else {
			//return ("urn:x-prefix:" + prefix).intern();
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.152 -0400", hash_original_method = "76654AC28D619222BBA1A28B5AC8BB60", hash_generated_method = "3CEE731CAAEA0E19A62760BCA3E610B8")
    public String localName(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_520881977 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1056360637 = null; //Variable for return #2
        int colon;
        colon = name.indexOf(':');
        {
            varB4EAC82CA7396A68D541C85D26508E83_520881977 = name;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1056360637 = name.substring(colon+1).intern();
        } //End block
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1128254872; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1128254872 = varB4EAC82CA7396A68D541C85D26508E83_520881977;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1128254872 = varB4EAC82CA7396A68D541C85D26508E83_1056360637;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1128254872.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1128254872;
        // ---------- Original Method ----------
        //int colon = name.indexOf(':');
        //if (colon == -1) {
			//return name;
			//}
		//else {
			//return name.substring(colon+1).intern();
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.152 -0400", hash_original_method = "AEAF2CA6A2A9BD287C2AECB04BDA5589", hash_generated_method = "D7A361F7360985378A67F9AFB943BAD5")
    public String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_303943874 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_303943874 = theName;
        varB4EAC82CA7396A68D541C85D26508E83_303943874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_303943874;
        // ---------- Original Method ----------
        //return theName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.153 -0400", hash_original_method = "D5C09A7EAC3540D5025F54207902E2D8", hash_generated_method = "36176F8B8BB49727C974FCCACBA496B7")
    public String namespace() {
        String varB4EAC82CA7396A68D541C85D26508E83_1082397654 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1082397654 = theNamespace;
        varB4EAC82CA7396A68D541C85D26508E83_1082397654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1082397654;
        // ---------- Original Method ----------
        //return theNamespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.153 -0400", hash_original_method = "7820A4FDEE02D17FDE49851C9121389B", hash_generated_method = "24260F6BC89B8FF377CC3A4BB4D4C0F5")
    public String localName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2109145575 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2109145575 = theLocalName;
        varB4EAC82CA7396A68D541C85D26508E83_2109145575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2109145575;
        // ---------- Original Method ----------
        //return theLocalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.153 -0400", hash_original_method = "863150B34251535222F20C0EAB163E01", hash_generated_method = "C78DA665E3C621EF9F0D2077ED365686")
    public int model() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525303580 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1525303580;
        // ---------- Original Method ----------
        //return theModel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.154 -0400", hash_original_method = "9FFB3E9386976737FD5FBA37B814C4D0", hash_generated_method = "47E6D8F560C0DBA160D821141CFC2AB4")
    public int memberOf() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918810315 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1918810315;
        // ---------- Original Method ----------
        //return theMemberOf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.158 -0400", hash_original_method = "19D08FF6AA5F9D4D6B65E686C6EC5676", hash_generated_method = "DC5E367CB19214CC7E556176CEB4B10E")
    public int flags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763869550 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763869550;
        // ---------- Original Method ----------
        //return theFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.158 -0400", hash_original_method = "5DFAF4737CD1323AC5BCD66ECC931C62", hash_generated_method = "AB1C0A6B3127DFDD249BDE2BE6C8BB7E")
    public AttributesImpl atts() {
        AttributesImpl varB4EAC82CA7396A68D541C85D26508E83_1748076972 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1748076972 = theAtts;
        varB4EAC82CA7396A68D541C85D26508E83_1748076972.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1748076972;
        // ---------- Original Method ----------
        //return theAtts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.159 -0400", hash_original_method = "E92CD830CE12526F79993827804AE423", hash_generated_method = "E0FE489C98F4710E2C1AE946D3F48590")
    public ElementType parent() {
        ElementType varB4EAC82CA7396A68D541C85D26508E83_1499762625 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1499762625 = theParent;
        varB4EAC82CA7396A68D541C85D26508E83_1499762625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1499762625;
        // ---------- Original Method ----------
        //return theParent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.159 -0400", hash_original_method = "5ED9C031E5D9227A40A639080CADBFC4", hash_generated_method = "08A6091123085B4B0E4756EF63589DA3")
    public Schema schema() {
        Schema varB4EAC82CA7396A68D541C85D26508E83_931135700 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_931135700 = theSchema;
        varB4EAC82CA7396A68D541C85D26508E83_931135700.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_931135700;
        // ---------- Original Method ----------
        //return theSchema;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.174 -0400", hash_original_method = "3CB53268EE03367F93FB62614B11BBE8", hash_generated_method = "14CC29294D3461816AF6A4CB21AF4F68")
    public boolean canContain(ElementType other) {
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_806165492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_806165492;
        // ---------- Original Method ----------
        //return (theModel & other.theMemberOf) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.180 -0400", hash_original_method = "704A404E71DCE2FCDA4DFB645734E42D", hash_generated_method = "D62CC549969AC2C566A510A453BCC2E8")
    public void setAttribute(AttributesImpl atts, String name, String type, String value) {
        {
            boolean varFD0065A1E075B4E5E097070CD8045E16_1210987316 = (name.equals("xmlns") || name.startsWith("xmlns:"));
        } //End collapsed parenthetic
        ;
        String namespace;
        namespace = namespace(name, true);
        String localName;
        localName = localName(name);
        int i;
        i = atts.getIndex(name);
        {
            name = name.intern();
            type = "CDATA";
            {
                boolean var8D2DC3A708E5B58AD4A1214DF2AE02F5_1960578305 = (!type.equals("CDATA"));
                value = normalize(value);
            } //End collapsed parenthetic
            atts.addAttribute(namespace, localName, name, type, value);
        } //End block
        {
            type = atts.getType(i);
            {
                boolean var8D2DC3A708E5B58AD4A1214DF2AE02F5_454727777 = (!type.equals("CDATA"));
                value=normalize(value);
            } //End collapsed parenthetic
            atts.setAttribute(i, namespace, localName, name, type, value);
        } //End block
        addTaint(atts.getTaint());
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (name.equals("xmlns") || name.startsWith("xmlns:")) {
			//return;
			//}
        //;
        //String namespace = namespace(name, true);
        //String localName = localName(name);
        //int i = atts.getIndex(name);
        //if (i == -1) {
			//name = name.intern();
			//if (type == null) type = "CDATA";
			//if (!type.equals("CDATA")) value = normalize(value);
			//atts.addAttribute(namespace, localName, name, type, value);
			//}
		//else {
			//if (type == null) type = atts.getType(i);
			//if (!type.equals("CDATA")) value=normalize(value);
			//atts.setAttribute(i, namespace, localName, name, type, value);
			//}
    }

    
        public static String normalize(String value) {
        if (value == null) return value;
        value = value.trim();
        if (value.indexOf("  ") == -1) return value;
        boolean space = false;
        int len = value.length();
        StringBuffer b = new StringBuffer(len);
        for (int i = 0; i < len; i++) {
			char v = value.charAt(i);
			if (v == ' ') {
				if (!space) b.append(v);
				space = true;
				}
			else {
				b.append(v);
				space = false;
				}
			}
        return b.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.181 -0400", hash_original_method = "EA247B977CB57294BB68422F3AC78185", hash_generated_method = "ED0F786D4B7F3860A0E29B9B56BF06FA")
    public void setAttribute(String name, String type, String value) {
        setAttribute(theAtts, name, type, value);
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //setAttribute(theAtts, name, type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.181 -0400", hash_original_method = "3D843454E0461CA80E31D71540C9240B", hash_generated_method = "02D113F936059A5083A48C9FA70AED6B")
    public void setModel(int model) {
        theModel = model;
        // ---------- Original Method ----------
        //theModel = model;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.181 -0400", hash_original_method = "49C12A488EE0CFA925BEADC8ACD7C6C0", hash_generated_method = "CF4421C34C163600235102D156504648")
    public void setMemberOf(int memberOf) {
        theMemberOf = memberOf;
        // ---------- Original Method ----------
        //theMemberOf = memberOf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.182 -0400", hash_original_method = "40381178E3FA56E0EF661C8DC2AD49FA", hash_generated_method = "C6564C5E0D1842F3281E028CC4944D07")
    public void setFlags(int flags) {
        theFlags = flags;
        // ---------- Original Method ----------
        //theFlags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.182 -0400", hash_original_method = "DBB2D29F8F1C5757D222A7D837762BD5", hash_generated_method = "6E2410F5D8C251D0B3D77776823BF205")
    public void setParent(ElementType parent) {
        theParent = parent;
        // ---------- Original Method ----------
        //theParent = parent;
    }

    
}

