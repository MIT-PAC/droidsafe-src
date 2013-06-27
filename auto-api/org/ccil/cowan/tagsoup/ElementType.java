package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ElementType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.198 -0400", hash_original_field = "00A89501D143A41773B62B3B85C4A0FC", hash_generated_field = "8ED9B31DDDAAEF65D7BC0612CAD3C8F5")

    private String theName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.198 -0400", hash_original_field = "02D9D70DCAD40047E29468D75DED325C", hash_generated_field = "19C10BCA5601E77C9A4AD4EB7613A6D2")

    private String theNamespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.198 -0400", hash_original_field = "D11A4EA7171D20E8487A965391C55986", hash_generated_field = "908B54F8164D1728F147F01078E48FD7")

    private String theLocalName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.198 -0400", hash_original_field = "D799417756D0E4F3CEF7BE3BDCA5304D", hash_generated_field = "29F2E6973C085F18D48340ABDDFD37F9")

    private int theModel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.198 -0400", hash_original_field = "9D336585DF3A7AB55AAD7BDD3FC0C0D6", hash_generated_field = "BCDF5B935532376D5B4CFDA618EF9F39")

    private int theMemberOf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.198 -0400", hash_original_field = "B4210363C6C1EA0142699EBDD2F10BCA", hash_generated_field = "CAADB9D6664219E6AE1F0AA6CE0533C4")

    private int theFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.198 -0400", hash_original_field = "89E65547A8BBD28E301BA7733FD2E3AF", hash_generated_field = "B0A2FBEB8F242E836C1CA731A6AB041F")

    private AttributesImpl theAtts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.198 -0400", hash_original_field = "B6F8E9510A95601AE76D79092AE1B77D", hash_generated_field = "0A3173D9C249D5F313C956327888B602")

    private ElementType theParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.198 -0400", hash_original_field = "107D6A6C40AD2744AB6BBBE303D4ACFB", hash_generated_field = "B0C8961A31DE3AC8E1FA05C39CF43268")

    private Schema theSchema;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.199 -0400", hash_original_method = "B2956F900AF52D9E41A7969852791670", hash_generated_method = "ADF06BFC1D8E1E63059F3A60FA30EF72")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.199 -0400", hash_original_method = "4A889710B67B4CF3F628D3945249B60A", hash_generated_method = "034156C5917BE18EC7B4ECB962FFF1C4")
    public String namespace(String name, boolean attribute) {
        String varB4EAC82CA7396A68D541C85D26508E83_785192477 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_981159987 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1381782024 = null; //Variable for return #3
        int colon;
        colon = name.indexOf(':');
        {
            varB4EAC82CA7396A68D541C85D26508E83_785192477 = attribute ? "" : theSchema.getURI();
        } //End block
        String prefix;
        prefix = name.substring(0, colon);
        {
            boolean var05D2A97F8C80619D6A9FF8AB74063B74_1011914866 = (prefix.equals("xml"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_981159987 = "http://www.w3.org/XML/1998/namespace";
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1381782024 = ("urn:x-prefix:" + prefix).intern();
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        addTaint(attribute);
        String varA7E53CE21691AB073D9660D615818899_2023569499; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2023569499 = varB4EAC82CA7396A68D541C85D26508E83_785192477;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2023569499 = varB4EAC82CA7396A68D541C85D26508E83_981159987;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2023569499 = varB4EAC82CA7396A68D541C85D26508E83_1381782024;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2023569499.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2023569499;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.200 -0400", hash_original_method = "76654AC28D619222BBA1A28B5AC8BB60", hash_generated_method = "70DBCB66577305140E67F323727ECDB7")
    public String localName(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_213724836 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_452187064 = null; //Variable for return #2
        int colon;
        colon = name.indexOf(':');
        {
            varB4EAC82CA7396A68D541C85D26508E83_213724836 = name;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_452187064 = name.substring(colon+1).intern();
        } //End block
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_716361185; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_716361185 = varB4EAC82CA7396A68D541C85D26508E83_213724836;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_716361185 = varB4EAC82CA7396A68D541C85D26508E83_452187064;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_716361185.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_716361185;
        // ---------- Original Method ----------
        //int colon = name.indexOf(':');
        //if (colon == -1) {
			//return name;
			//}
		//else {
			//return name.substring(colon+1).intern();
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.208 -0400", hash_original_method = "AEAF2CA6A2A9BD287C2AECB04BDA5589", hash_generated_method = "0841F873E27D3E38A912F0B8FC7C53CF")
    public String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_724423930 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_724423930 = theName;
        varB4EAC82CA7396A68D541C85D26508E83_724423930.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_724423930;
        // ---------- Original Method ----------
        //return theName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.209 -0400", hash_original_method = "D5C09A7EAC3540D5025F54207902E2D8", hash_generated_method = "B0F9F6F63B929B6D6AB87F02455C7607")
    public String namespace() {
        String varB4EAC82CA7396A68D541C85D26508E83_2008463317 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2008463317 = theNamespace;
        varB4EAC82CA7396A68D541C85D26508E83_2008463317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2008463317;
        // ---------- Original Method ----------
        //return theNamespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.221 -0400", hash_original_method = "7820A4FDEE02D17FDE49851C9121389B", hash_generated_method = "C94D00CC6F9AA861846AFCC35EE7EB09")
    public String localName() {
        String varB4EAC82CA7396A68D541C85D26508E83_569984327 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_569984327 = theLocalName;
        varB4EAC82CA7396A68D541C85D26508E83_569984327.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_569984327;
        // ---------- Original Method ----------
        //return theLocalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.222 -0400", hash_original_method = "863150B34251535222F20C0EAB163E01", hash_generated_method = "75CAAB8DC1745DAE19FA9AFD8D7FEEF4")
    public int model() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066203561 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1066203561;
        // ---------- Original Method ----------
        //return theModel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.222 -0400", hash_original_method = "9FFB3E9386976737FD5FBA37B814C4D0", hash_generated_method = "C216375E50636F23A30E27963A96A237")
    public int memberOf() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41016735 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_41016735;
        // ---------- Original Method ----------
        //return theMemberOf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.234 -0400", hash_original_method = "19D08FF6AA5F9D4D6B65E686C6EC5676", hash_generated_method = "16B3ED7FA0D7338E2EC7C24B5F54EF9E")
    public int flags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_773366581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_773366581;
        // ---------- Original Method ----------
        //return theFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.236 -0400", hash_original_method = "5DFAF4737CD1323AC5BCD66ECC931C62", hash_generated_method = "0FFD9CE4787C7DC75BD4D00E275D5E11")
    public AttributesImpl atts() {
        AttributesImpl varB4EAC82CA7396A68D541C85D26508E83_1789281442 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1789281442 = theAtts;
        varB4EAC82CA7396A68D541C85D26508E83_1789281442.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1789281442;
        // ---------- Original Method ----------
        //return theAtts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.237 -0400", hash_original_method = "E92CD830CE12526F79993827804AE423", hash_generated_method = "DFBBF0FD1B68F96C28F2B4553573891C")
    public ElementType parent() {
        ElementType varB4EAC82CA7396A68D541C85D26508E83_1104975342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1104975342 = theParent;
        varB4EAC82CA7396A68D541C85D26508E83_1104975342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1104975342;
        // ---------- Original Method ----------
        //return theParent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.237 -0400", hash_original_method = "5ED9C031E5D9227A40A639080CADBFC4", hash_generated_method = "D726F5FEF14322B0AD75492F1AC1AA1A")
    public Schema schema() {
        Schema varB4EAC82CA7396A68D541C85D26508E83_1884216872 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1884216872 = theSchema;
        varB4EAC82CA7396A68D541C85D26508E83_1884216872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1884216872;
        // ---------- Original Method ----------
        //return theSchema;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.237 -0400", hash_original_method = "3CB53268EE03367F93FB62614B11BBE8", hash_generated_method = "41F1CEC33360F8E632E0FA8A9208CE1E")
    public boolean canContain(ElementType other) {
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1797773569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1797773569;
        // ---------- Original Method ----------
        //return (theModel & other.theMemberOf) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.238 -0400", hash_original_method = "704A404E71DCE2FCDA4DFB645734E42D", hash_generated_method = "F71D39136D931367BB8CBDBFE45A95FF")
    public void setAttribute(AttributesImpl atts, String name, String type, String value) {
        {
            boolean varFD0065A1E075B4E5E097070CD8045E16_327455077 = (name.equals("xmlns") || name.startsWith("xmlns:"));
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
                boolean var8D2DC3A708E5B58AD4A1214DF2AE02F5_1723153111 = (!type.equals("CDATA"));
                value = normalize(value);
            } //End collapsed parenthetic
            atts.addAttribute(namespace, localName, name, type, value);
        } //End block
        {
            type = atts.getType(i);
            {
                boolean var8D2DC3A708E5B58AD4A1214DF2AE02F5_536464922 = (!type.equals("CDATA"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.239 -0400", hash_original_method = "EA247B977CB57294BB68422F3AC78185", hash_generated_method = "ED0F786D4B7F3860A0E29B9B56BF06FA")
    public void setAttribute(String name, String type, String value) {
        setAttribute(theAtts, name, type, value);
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //setAttribute(theAtts, name, type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.252 -0400", hash_original_method = "3D843454E0461CA80E31D71540C9240B", hash_generated_method = "02D113F936059A5083A48C9FA70AED6B")
    public void setModel(int model) {
        theModel = model;
        // ---------- Original Method ----------
        //theModel = model;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.252 -0400", hash_original_method = "49C12A488EE0CFA925BEADC8ACD7C6C0", hash_generated_method = "CF4421C34C163600235102D156504648")
    public void setMemberOf(int memberOf) {
        theMemberOf = memberOf;
        // ---------- Original Method ----------
        //theMemberOf = memberOf;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.252 -0400", hash_original_method = "40381178E3FA56E0EF661C8DC2AD49FA", hash_generated_method = "C6564C5E0D1842F3281E028CC4944D07")
    public void setFlags(int flags) {
        theFlags = flags;
        // ---------- Original Method ----------
        //theFlags = flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.252 -0400", hash_original_method = "DBB2D29F8F1C5757D222A7D837762BD5", hash_generated_method = "6E2410F5D8C251D0B3D77776823BF205")
    public void setParent(ElementType parent) {
        theParent = parent;
        // ---------- Original Method ----------
        //theParent = parent;
    }

    
}

