package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ElementType {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.923 -0400", hash_original_field = "00A89501D143A41773B62B3B85C4A0FC", hash_generated_field = "8ED9B31DDDAAEF65D7BC0612CAD3C8F5")

    private String theName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.923 -0400", hash_original_field = "02D9D70DCAD40047E29468D75DED325C", hash_generated_field = "19C10BCA5601E77C9A4AD4EB7613A6D2")

    private String theNamespace;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.923 -0400", hash_original_field = "D11A4EA7171D20E8487A965391C55986", hash_generated_field = "908B54F8164D1728F147F01078E48FD7")

    private String theLocalName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.923 -0400", hash_original_field = "D799417756D0E4F3CEF7BE3BDCA5304D", hash_generated_field = "29F2E6973C085F18D48340ABDDFD37F9")

    private int theModel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.923 -0400", hash_original_field = "9D336585DF3A7AB55AAD7BDD3FC0C0D6", hash_generated_field = "BCDF5B935532376D5B4CFDA618EF9F39")

    private int theMemberOf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.923 -0400", hash_original_field = "B4210363C6C1EA0142699EBDD2F10BCA", hash_generated_field = "CAADB9D6664219E6AE1F0AA6CE0533C4")

    private int theFlags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.923 -0400", hash_original_field = "89E65547A8BBD28E301BA7733FD2E3AF", hash_generated_field = "B0A2FBEB8F242E836C1CA731A6AB041F")

    private AttributesImpl theAtts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.923 -0400", hash_original_field = "B6F8E9510A95601AE76D79092AE1B77D", hash_generated_field = "0A3173D9C249D5F313C956327888B602")

    private ElementType theParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.923 -0400", hash_original_field = "107D6A6C40AD2744AB6BBBE303D4ACFB", hash_generated_field = "B0C8961A31DE3AC8E1FA05C39CF43268")

    private Schema theSchema;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.924 -0400", hash_original_method = "B2956F900AF52D9E41A7969852791670", hash_generated_method = "ADF06BFC1D8E1E63059F3A60FA30EF72")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.925 -0400", hash_original_method = "4A889710B67B4CF3F628D3945249B60A", hash_generated_method = "1365AA37FC5EE8DD941ECE44C1664077")
    public String namespace(String name, boolean attribute) {
        addTaint(attribute);
        addTaint(name.getTaint());
        int colon = name.indexOf(':');
    if(colon == -1)        
        {
String varAB2345C238CB3313D565FE6B975DC720_1200808676 =             attribute ? "" : theSchema.getURI();
            varAB2345C238CB3313D565FE6B975DC720_1200808676.addTaint(taint);
            return varAB2345C238CB3313D565FE6B975DC720_1200808676;
        } //End block
        String prefix = name.substring(0, colon);
    if(prefix.equals("xml"))        
        {
String varB42E997512DFFB350471AB44C36A387C_1369807299 =             "http://www.w3.org/XML/1998/namespace";
            varB42E997512DFFB350471AB44C36A387C_1369807299.addTaint(taint);
            return varB42E997512DFFB350471AB44C36A387C_1369807299;
        } //End block
        else
        {
String varAA673C9A0924498AE38DAA66A4683FC8_2020434912 =             ("urn:x-prefix:" + prefix).intern();
            varAA673C9A0924498AE38DAA66A4683FC8_2020434912.addTaint(taint);
            return varAA673C9A0924498AE38DAA66A4683FC8_2020434912;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.925 -0400", hash_original_method = "76654AC28D619222BBA1A28B5AC8BB60", hash_generated_method = "5583856C6737AA992F1A967FBE575A94")
    public String localName(String name) {
        addTaint(name.getTaint());
        int colon = name.indexOf(':');
    if(colon == -1)        
        {
String varB017984728AC60AD1F0BF8734F33F15C_1430973016 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_1430973016.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_1430973016;
        } //End block
        else
        {
String var70CFE88F30A49EB927310132B2D66122_623257127 =             name.substring(colon+1).intern();
            var70CFE88F30A49EB927310132B2D66122_623257127.addTaint(taint);
            return var70CFE88F30A49EB927310132B2D66122_623257127;
        } //End block
        // ---------- Original Method ----------
        //int colon = name.indexOf(':');
        //if (colon == -1) {
			//return name;
			//}
		//else {
			//return name.substring(colon+1).intern();
			//}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.926 -0400", hash_original_method = "AEAF2CA6A2A9BD287C2AECB04BDA5589", hash_generated_method = "92D84FE296139DDD354CEB87789A5EBF")
    public String name() {
String var70F0F034C0DCFF6E2661DB55A73F06A1_331875182 =         theName;
        var70F0F034C0DCFF6E2661DB55A73F06A1_331875182.addTaint(taint);
        return var70F0F034C0DCFF6E2661DB55A73F06A1_331875182;
        // ---------- Original Method ----------
        //return theName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.926 -0400", hash_original_method = "D5C09A7EAC3540D5025F54207902E2D8", hash_generated_method = "954FE999F0751F570F5FA8225540AE5C")
    public String namespace() {
String var0406821FDFE3D35AD99B5845E33FC3E7_1703918737 =         theNamespace;
        var0406821FDFE3D35AD99B5845E33FC3E7_1703918737.addTaint(taint);
        return var0406821FDFE3D35AD99B5845E33FC3E7_1703918737;
        // ---------- Original Method ----------
        //return theNamespace;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.926 -0400", hash_original_method = "7820A4FDEE02D17FDE49851C9121389B", hash_generated_method = "C97B15317261D33BCFBDD84C57B2B60D")
    public String localName() {
String varB1346F921066FA7F8698728CBA4E1FCB_1639810395 =         theLocalName;
        varB1346F921066FA7F8698728CBA4E1FCB_1639810395.addTaint(taint);
        return varB1346F921066FA7F8698728CBA4E1FCB_1639810395;
        // ---------- Original Method ----------
        //return theLocalName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.926 -0400", hash_original_method = "863150B34251535222F20C0EAB163E01", hash_generated_method = "47FC7B36A829BA6A58566F0731FFE684")
    public int model() {
        int varD799417756D0E4F3CEF7BE3BDCA5304D_2110779436 = (theModel);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208663579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208663579;
        // ---------- Original Method ----------
        //return theModel;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.927 -0400", hash_original_method = "9FFB3E9386976737FD5FBA37B814C4D0", hash_generated_method = "326449CDE6832624BA448D79698702F1")
    public int memberOf() {
        int var9D336585DF3A7AB55AAD7BDD3FC0C0D6_779164625 = (theMemberOf);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1002192022 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1002192022;
        // ---------- Original Method ----------
        //return theMemberOf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.927 -0400", hash_original_method = "19D08FF6AA5F9D4D6B65E686C6EC5676", hash_generated_method = "1F5BF848BD162A17E3B54D7411EDD5E1")
    public int flags() {
        int varB4210363C6C1EA0142699EBDD2F10BCA_939164925 = (theFlags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148872441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148872441;
        // ---------- Original Method ----------
        //return theFlags;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.927 -0400", hash_original_method = "5DFAF4737CD1323AC5BCD66ECC931C62", hash_generated_method = "73014D5B5E3BD756C1790B479B2FAD4C")
    public AttributesImpl atts() {
AttributesImpl varFB5CAB611E727D03F638BBA9F461FD53_459980536 =         theAtts;
        varFB5CAB611E727D03F638BBA9F461FD53_459980536.addTaint(taint);
        return varFB5CAB611E727D03F638BBA9F461FD53_459980536;
        // ---------- Original Method ----------
        //return theAtts;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.927 -0400", hash_original_method = "E92CD830CE12526F79993827804AE423", hash_generated_method = "D33F3E42ADF2A9AA86FCD77E76DB02A2")
    public ElementType parent() {
ElementType varA18F4F163F633B2655786FDB630B95FF_596994650 =         theParent;
        varA18F4F163F633B2655786FDB630B95FF_596994650.addTaint(taint);
        return varA18F4F163F633B2655786FDB630B95FF_596994650;
        // ---------- Original Method ----------
        //return theParent;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.928 -0400", hash_original_method = "5ED9C031E5D9227A40A639080CADBFC4", hash_generated_method = "0D7E8E6BE17259F0018C728A11DAF221")
    public Schema schema() {
Schema varF1B5508E6B3CF9213428E6D6136C1D0E_79120465 =         theSchema;
        varF1B5508E6B3CF9213428E6D6136C1D0E_79120465.addTaint(taint);
        return varF1B5508E6B3CF9213428E6D6136C1D0E_79120465;
        // ---------- Original Method ----------
        //return theSchema;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.928 -0400", hash_original_method = "3CB53268EE03367F93FB62614B11BBE8", hash_generated_method = "62EC493022C184FCB729075ED5BCE6BF")
    public boolean canContain(ElementType other) {
        addTaint(other.getTaint());
        boolean var6E8A78404A02831D5436C4AEB930A0CE_729503929 = ((theModel & other.theMemberOf) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001574371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001574371;
        // ---------- Original Method ----------
        //return (theModel & other.theMemberOf) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.929 -0400", hash_original_method = "704A404E71DCE2FCDA4DFB645734E42D", hash_generated_method = "8D1670F34BBC76AE3C485BF64C009E88")
    public void setAttribute(AttributesImpl atts, String name, String type, String value) {
        addTaint(value.getTaint());
        addTaint(type.getTaint());
        addTaint(name.getTaint());
        addTaint(atts.getTaint());
    if(name.equals("xmlns") || name.startsWith("xmlns:"))        
        {
            return;
        } //End block
        ;
        String namespace = namespace(name, true);
        String localName = localName(name);
        int i = atts.getIndex(name);
    if(i == -1)        
        {
            name = name.intern();
    if(type == null)            
            type = "CDATA";
    if(!type.equals("CDATA"))            
            value = normalize(value);
            atts.addAttribute(namespace, localName, name, type, value);
        } //End block
        else
        {
    if(type == null)            
            type = atts.getType(i);
    if(!type.equals("CDATA"))            
            value=normalize(value);
            atts.setAttribute(i, namespace, localName, name, type, value);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.930 -0400", hash_original_method = "EA247B977CB57294BB68422F3AC78185", hash_generated_method = "E4B5F2E775A00BB422D4DB2FB7840A07")
    public void setAttribute(String name, String type, String value) {
        addTaint(value.getTaint());
        addTaint(type.getTaint());
        addTaint(name.getTaint());
        setAttribute(theAtts, name, type, value);
        // ---------- Original Method ----------
        //setAttribute(theAtts, name, type, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.930 -0400", hash_original_method = "3D843454E0461CA80E31D71540C9240B", hash_generated_method = "02D113F936059A5083A48C9FA70AED6B")
    public void setModel(int model) {
        theModel = model;
        // ---------- Original Method ----------
        //theModel = model;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.931 -0400", hash_original_method = "49C12A488EE0CFA925BEADC8ACD7C6C0", hash_generated_method = "CF4421C34C163600235102D156504648")
    public void setMemberOf(int memberOf) {
        theMemberOf = memberOf;
        // ---------- Original Method ----------
        //theMemberOf = memberOf;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.931 -0400", hash_original_method = "40381178E3FA56E0EF661C8DC2AD49FA", hash_generated_method = "C6564C5E0D1842F3281E028CC4944D07")
    public void setFlags(int flags) {
        theFlags = flags;
        // ---------- Original Method ----------
        //theFlags = flags;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:42.931 -0400", hash_original_method = "DBB2D29F8F1C5757D222A7D837762BD5", hash_generated_method = "6E2410F5D8C251D0B3D77776823BF205")
    public void setParent(ElementType parent) {
        theParent = parent;
        // ---------- Original Method ----------
        //theParent = parent;
    }

    
}

