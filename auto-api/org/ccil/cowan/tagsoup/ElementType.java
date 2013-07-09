package org.ccil.cowan.tagsoup;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ElementType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.713 -0400", hash_original_field = "00A89501D143A41773B62B3B85C4A0FC", hash_generated_field = "8ED9B31DDDAAEF65D7BC0612CAD3C8F5")

    private String theName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.713 -0400", hash_original_field = "02D9D70DCAD40047E29468D75DED325C", hash_generated_field = "19C10BCA5601E77C9A4AD4EB7613A6D2")

    private String theNamespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.713 -0400", hash_original_field = "D11A4EA7171D20E8487A965391C55986", hash_generated_field = "908B54F8164D1728F147F01078E48FD7")

    private String theLocalName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.713 -0400", hash_original_field = "D799417756D0E4F3CEF7BE3BDCA5304D", hash_generated_field = "29F2E6973C085F18D48340ABDDFD37F9")

    private int theModel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.713 -0400", hash_original_field = "9D336585DF3A7AB55AAD7BDD3FC0C0D6", hash_generated_field = "BCDF5B935532376D5B4CFDA618EF9F39")

    private int theMemberOf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.713 -0400", hash_original_field = "B4210363C6C1EA0142699EBDD2F10BCA", hash_generated_field = "CAADB9D6664219E6AE1F0AA6CE0533C4")

    private int theFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.713 -0400", hash_original_field = "89E65547A8BBD28E301BA7733FD2E3AF", hash_generated_field = "B0A2FBEB8F242E836C1CA731A6AB041F")

    private AttributesImpl theAtts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.713 -0400", hash_original_field = "B6F8E9510A95601AE76D79092AE1B77D", hash_generated_field = "0A3173D9C249D5F313C956327888B602")

    private ElementType theParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.713 -0400", hash_original_field = "107D6A6C40AD2744AB6BBBE303D4ACFB", hash_generated_field = "B0C8961A31DE3AC8E1FA05C39CF43268")

    private Schema theSchema;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.713 -0400", hash_original_method = "B2956F900AF52D9E41A7969852791670", hash_generated_method = "ADF06BFC1D8E1E63059F3A60FA30EF72")
    public  ElementType(String name, int model, int memberOf, int flags, Schema schema) {
        theName = name;
        theModel = model;
        theMemberOf = memberOf;
        theFlags = flags;
        theAtts = new AttributesImpl();
        theSchema = schema;
        theNamespace = namespace(name, false);
        theLocalName = localName(name);
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.714 -0400", hash_original_method = "4A889710B67B4CF3F628D3945249B60A", hash_generated_method = "B4BDB7DDEBA2A74A1A96218A5EBCB63E")
    public String namespace(String name, boolean attribute) {
        String varB4EAC82CA7396A68D541C85D26508E83_643657560 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_266365090 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_699823699 = null; 
        int colon = name.indexOf(':');
        {
            varB4EAC82CA7396A68D541C85D26508E83_643657560 = attribute ? "" : theSchema.getURI();
        } 
        String prefix = name.substring(0, colon);
        {
            boolean var05D2A97F8C80619D6A9FF8AB74063B74_1376685028 = (prefix.equals("xml"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_266365090 = "http://www.w3.org/XML/1998/namespace";
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_699823699 = ("urn:x-prefix:" + prefix).intern();
            } 
        } 
        addTaint(name.getTaint());
        addTaint(attribute);
        String varA7E53CE21691AB073D9660D615818899_500379740; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_500379740 = varB4EAC82CA7396A68D541C85D26508E83_643657560;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_500379740 = varB4EAC82CA7396A68D541C85D26508E83_266365090;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_500379740 = varB4EAC82CA7396A68D541C85D26508E83_699823699;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_500379740.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_500379740;
        
        
        
			
			
        
        
			
			
		
			
			
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.715 -0400", hash_original_method = "76654AC28D619222BBA1A28B5AC8BB60", hash_generated_method = "8EF9B47563CBFA7F7C564C3C3633EB1B")
    public String localName(String name) {
        String varB4EAC82CA7396A68D541C85D26508E83_947571618 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1385617185 = null; 
        int colon = name.indexOf(':');
        {
            varB4EAC82CA7396A68D541C85D26508E83_947571618 = name;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1385617185 = name.substring(colon+1).intern();
        } 
        addTaint(name.getTaint());
        String varA7E53CE21691AB073D9660D615818899_701745303; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_701745303 = varB4EAC82CA7396A68D541C85D26508E83_947571618;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_701745303 = varB4EAC82CA7396A68D541C85D26508E83_1385617185;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_701745303.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_701745303;
        
        
        
			
			
		
			
			
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.716 -0400", hash_original_method = "AEAF2CA6A2A9BD287C2AECB04BDA5589", hash_generated_method = "42687F0BC34ABCFF903C7C3D71252E6A")
    public String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_821663436 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_821663436 = theName;
        varB4EAC82CA7396A68D541C85D26508E83_821663436.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_821663436;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.717 -0400", hash_original_method = "D5C09A7EAC3540D5025F54207902E2D8", hash_generated_method = "7900D0B31EFF897BBEF8667657DBF368")
    public String namespace() {
        String varB4EAC82CA7396A68D541C85D26508E83_517360488 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_517360488 = theNamespace;
        varB4EAC82CA7396A68D541C85D26508E83_517360488.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_517360488;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.717 -0400", hash_original_method = "7820A4FDEE02D17FDE49851C9121389B", hash_generated_method = "B18ED8AA5EF3A48C077BEFD8D0799AB3")
    public String localName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1417255585 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1417255585 = theLocalName;
        varB4EAC82CA7396A68D541C85D26508E83_1417255585.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1417255585;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.718 -0400", hash_original_method = "863150B34251535222F20C0EAB163E01", hash_generated_method = "C55C2A0623DE46395A7E75116E1C64B9")
    public int model() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1538764639 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1538764639;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.718 -0400", hash_original_method = "9FFB3E9386976737FD5FBA37B814C4D0", hash_generated_method = "38591C04926B70E15CE059CF26C507C3")
    public int memberOf() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443294493 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443294493;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.719 -0400", hash_original_method = "19D08FF6AA5F9D4D6B65E686C6EC5676", hash_generated_method = "8CBDDFB62555FE13A8DD0931428FE241")
    public int flags() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278069294 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1278069294;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.719 -0400", hash_original_method = "5DFAF4737CD1323AC5BCD66ECC931C62", hash_generated_method = "B52E5E3011B9ADD53AEE677B807139F9")
    public AttributesImpl atts() {
        AttributesImpl varB4EAC82CA7396A68D541C85D26508E83_140117178 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_140117178 = theAtts;
        varB4EAC82CA7396A68D541C85D26508E83_140117178.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_140117178;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.720 -0400", hash_original_method = "E92CD830CE12526F79993827804AE423", hash_generated_method = "69D15A643BE260FC0C5318899E2DC09E")
    public ElementType parent() {
        ElementType varB4EAC82CA7396A68D541C85D26508E83_2067293808 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2067293808 = theParent;
        varB4EAC82CA7396A68D541C85D26508E83_2067293808.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2067293808;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.720 -0400", hash_original_method = "5ED9C031E5D9227A40A639080CADBFC4", hash_generated_method = "CA515A64824F442243681620F447B546")
    public Schema schema() {
        Schema varB4EAC82CA7396A68D541C85D26508E83_401836195 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_401836195 = theSchema;
        varB4EAC82CA7396A68D541C85D26508E83_401836195.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_401836195;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.721 -0400", hash_original_method = "3CB53268EE03367F93FB62614B11BBE8", hash_generated_method = "DAE4AD53E387EC8EACC7E03A40313B29")
    public boolean canContain(ElementType other) {
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2017191700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2017191700;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.721 -0400", hash_original_method = "704A404E71DCE2FCDA4DFB645734E42D", hash_generated_method = "774B256F5E8108E98FE36EB07EDF5657")
    public void setAttribute(AttributesImpl atts, String name, String type, String value) {
        {
            boolean varFD0065A1E075B4E5E097070CD8045E16_533102165 = (name.equals("xmlns") || name.startsWith("xmlns:"));
        } 
        ;
        String namespace = namespace(name, true);
        String localName = localName(name);
        int i = atts.getIndex(name);
        {
            name = name.intern();
            type = "CDATA";
            {
                boolean var8D2DC3A708E5B58AD4A1214DF2AE02F5_1215533360 = (!type.equals("CDATA"));
                value = normalize(value);
            } 
            atts.addAttribute(namespace, localName, name, type, value);
        } 
        {
            type = atts.getType(i);
            {
                boolean var8D2DC3A708E5B58AD4A1214DF2AE02F5_921945131 = (!type.equals("CDATA"));
                value=normalize(value);
            } 
            atts.setAttribute(i, namespace, localName, name, type, value);
        } 
        addTaint(atts.getTaint());
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        addTaint(value.getTaint());
        
        
			
			
        
        
        
        
        
			
			
			
			
			
		
			
			
			
			
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.722 -0400", hash_original_method = "EA247B977CB57294BB68422F3AC78185", hash_generated_method = "ED0F786D4B7F3860A0E29B9B56BF06FA")
    public void setAttribute(String name, String type, String value) {
        setAttribute(theAtts, name, type, value);
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.722 -0400", hash_original_method = "3D843454E0461CA80E31D71540C9240B", hash_generated_method = "02D113F936059A5083A48C9FA70AED6B")
    public void setModel(int model) {
        theModel = model;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.722 -0400", hash_original_method = "49C12A488EE0CFA925BEADC8ACD7C6C0", hash_generated_method = "CF4421C34C163600235102D156504648")
    public void setMemberOf(int memberOf) {
        theMemberOf = memberOf;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.723 -0400", hash_original_method = "40381178E3FA56E0EF661C8DC2AD49FA", hash_generated_method = "C6564C5E0D1842F3281E028CC4944D07")
    public void setFlags(int flags) {
        theFlags = flags;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:47.723 -0400", hash_original_method = "DBB2D29F8F1C5757D222A7D837762BD5", hash_generated_method = "6E2410F5D8C251D0B3D77776823BF205")
    public void setParent(ElementType parent) {
        theParent = parent;
        
        
    }

    
}

