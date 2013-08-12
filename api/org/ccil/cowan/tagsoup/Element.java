package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.annotations.*;





public class Element {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.728 -0400", hash_original_field = "E8584B0E37179A7B82F4A85271799B93", hash_generated_field = "3F58E4656692FD6FEAD0053A32B05324")

    private ElementType theType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.728 -0400", hash_original_field = "89E65547A8BBD28E301BA7733FD2E3AF", hash_generated_field = "B0A2FBEB8F242E836C1CA731A6AB041F")

    private AttributesImpl theAtts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.728 -0400", hash_original_field = "A42D0E0DE01D51B60927FDF6C1F0B526", hash_generated_field = "76A7ADBAEEEC2718891FF24B2F2B9374")

    private Element theNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.728 -0400", hash_original_field = "D8AE31ABFACD39F1529F19591E594EAD", hash_generated_field = "0EC43875BA19E67350871B910584306F")

    private boolean preclosed;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.730 -0400", hash_original_method = "99F284A13C47F669710FCFDC8EC8F9ED", hash_generated_method = "B1C5F8B124607918F0FDE82A4ABD9D88")
    public  Element(ElementType type, boolean defaultAttributes) {
        addTaint(defaultAttributes);
        theType = type;
        if(defaultAttributes)        
        theAtts = new AttributesImpl(type.atts());
        else
        theAtts = new AttributesImpl();
        theNext = null;
        preclosed = false;
        // ---------- Original Method ----------
        //theType = type;
        //if (defaultAttributes) theAtts = new AttributesImpl(type.atts());
		//else theAtts = new AttributesImpl();
        //theNext = null;
        //preclosed = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.730 -0400", hash_original_method = "BFA15C1190E0B500E7A321E762D22239", hash_generated_method = "600964534B1E4FADDBF41CF612F8A6D0")
    public ElementType type() {
ElementType varF51095CBFCCE381E73DD672B54BEF95F_938425503 =         theType;
        varF51095CBFCCE381E73DD672B54BEF95F_938425503.addTaint(taint);
        return varF51095CBFCCE381E73DD672B54BEF95F_938425503;
        // ---------- Original Method ----------
        //return theType;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.731 -0400", hash_original_method = "5DFAF4737CD1323AC5BCD66ECC931C62", hash_generated_method = "133F61A0BE19C316BACACAA6C37157C7")
    public AttributesImpl atts() {
AttributesImpl varFB5CAB611E727D03F638BBA9F461FD53_362753756 =         theAtts;
        varFB5CAB611E727D03F638BBA9F461FD53_362753756.addTaint(taint);
        return varFB5CAB611E727D03F638BBA9F461FD53_362753756;
        // ---------- Original Method ----------
        //return theAtts;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.731 -0400", hash_original_method = "9BD985D9D137F9E87CC0C75657FC57B8", hash_generated_method = "E554BCB6A95AA473CAE36810BB5D79DE")
    public Element next() {
Element varB89BFAC58CA29A6FFD18C2AE8DA88577_940414750 =         theNext;
        varB89BFAC58CA29A6FFD18C2AE8DA88577_940414750.addTaint(taint);
        return varB89BFAC58CA29A6FFD18C2AE8DA88577_940414750;
        // ---------- Original Method ----------
        //return theNext;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.732 -0400", hash_original_method = "9784418C474A290336108D75EC2613BB", hash_generated_method = "B0D02388E7E125BF20397459054E2AB9")
    public void setNext(Element next) {
        theNext = next;
        // ---------- Original Method ----------
        //theNext = next;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.732 -0400", hash_original_method = "4B70092235E7A40F6E106A246C1B1B53", hash_generated_method = "6F2F6B925AE1C0DF5DA801AC24F653D2")
    public String name() {
String var005C4062513861A340896052683FF400_976220520 =         theType.name();
        var005C4062513861A340896052683FF400_976220520.addTaint(taint);
        return var005C4062513861A340896052683FF400_976220520;
        // ---------- Original Method ----------
        //return theType.name();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.732 -0400", hash_original_method = "80004BAEB2388ADEF62653D4EDD03DA4", hash_generated_method = "640112CFEBAF388FA93C0BBD4EF9E2FC")
    public String namespace() {
String var423C72382D1E2291404BC0912AFBCE6F_623377143 =         theType.namespace();
        var423C72382D1E2291404BC0912AFBCE6F_623377143.addTaint(taint);
        return var423C72382D1E2291404BC0912AFBCE6F_623377143;
        // ---------- Original Method ----------
        //return theType.namespace();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.732 -0400", hash_original_method = "013647E32C485C8E11074DEB96ED8B2D", hash_generated_method = "3C52B7C0A384F6CF3FB199541DFC8D40")
    public String localName() {
String varB3EF0FC926F2BDE57E879A05A0656297_1942043459 =         theType.localName();
        varB3EF0FC926F2BDE57E879A05A0656297_1942043459.addTaint(taint);
        return varB3EF0FC926F2BDE57E879A05A0656297_1942043459;
        // ---------- Original Method ----------
        //return theType.localName();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.733 -0400", hash_original_method = "3430000E3BB78B9B3224C2ADE055F8C5", hash_generated_method = "380A80C3228A0EA7865E08E06976279F")
    public int model() {
        int var736FB8E81AE145E9ACFCE37EE55156CB_649516623 = (theType.model());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367929277 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_367929277;
        // ---------- Original Method ----------
        //return theType.model();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.733 -0400", hash_original_method = "1DD49D169AB38515FFA4793B4461E091", hash_generated_method = "B47781E2F50CF6026C71E3BD76CA06C1")
    public int memberOf() {
        int var86578D803F3E2C7995C52681C9AD2EB0_486051793 = (theType.memberOf());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139785238 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139785238;
        // ---------- Original Method ----------
        //return theType.memberOf();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.733 -0400", hash_original_method = "383432538F005F982D316492CCCB0325", hash_generated_method = "79FC18D289808827CFF7B41BC31A72D8")
    public int flags() {
        int var711B48DD659D94FE27F8ADFDD5622E4A_649514765 = (theType.flags());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261722626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1261722626;
        // ---------- Original Method ----------
        //return theType.flags();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.733 -0400", hash_original_method = "BCFB422D01A5282722899F511B11ECF6", hash_generated_method = "C578E295913BB8E47E0B12705098B67A")
    public ElementType parent() {
ElementType varBCFFE70A770DBF894E201FA2576E81A0_682853896 =         theType.parent();
        varBCFFE70A770DBF894E201FA2576E81A0_682853896.addTaint(taint);
        return varBCFFE70A770DBF894E201FA2576E81A0_682853896;
        // ---------- Original Method ----------
        //return theType.parent();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.734 -0400", hash_original_method = "BC680BBCF0406870088BFC77978994BB", hash_generated_method = "95F2BBC88C9693D1EC79D2901824ED64")
    public boolean canContain(Element other) {
        addTaint(other.getTaint());
        boolean var8885BCA2DBC3218C8B2A336EB9FA1B44_1824549433 = (theType.canContain(other.theType));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_62788045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_62788045;
        // ---------- Original Method ----------
        //return theType.canContain(other.theType);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.734 -0400", hash_original_method = "D84E1EF02E49BC2153CE4E53757510D3", hash_generated_method = "4249155B1CC51900DBF381C89E01AC95")
    public void setAttribute(String name, String type, String value) {
        addTaint(value.getTaint());
        addTaint(type.getTaint());
        addTaint(name.getTaint());
        theType.setAttribute(theAtts, name, type, value);
        // ---------- Original Method ----------
        //theType.setAttribute(theAtts, name, type, value);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.735 -0400", hash_original_method = "B1EC3E2E623AD0C28D4FB442F2195ED7", hash_generated_method = "4811898F9D444106B3C5C3D5A6BEC4D1")
    public void anonymize() {
for(int i = theAtts.getLength() - 1;i >= 0;i--)
        {
            if(theAtts.getType(i).equals("ID") ||
			    theAtts.getQName(i).equals("name"))            
            {
                theAtts.removeAttribute(i);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (int i = theAtts.getLength() - 1; i >= 0; i--) {
			//if (theAtts.getType(i).equals("ID") ||
			    //theAtts.getQName(i).equals("name")) {
				//theAtts.removeAttribute(i);
				//}
			//}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.735 -0400", hash_original_method = "D93155F43F41AF612E7774F463E1747A", hash_generated_method = "58ACB8CBF2A09804B1FD80B474F58E3E")
    public void clean() {
for(int i = theAtts.getLength() - 1;i >= 0;i--)
        {
            String name = theAtts.getLocalName(i);
            if(theAtts.getValue(i) == null || name == null ||
					name.length() == 0)            
            {
                theAtts.removeAttribute(i);
                continue;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //for (int i = theAtts.getLength() - 1; i >= 0; i--) {
			//String name = theAtts.getLocalName(i);
			//if (theAtts.getValue(i) == null || name == null ||
					//name.length() == 0) {
				//theAtts.removeAttribute(i);
				//continue;
				//}
			//}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.735 -0400", hash_original_method = "4B2B445A367BD9870FD7E6D0B377F667", hash_generated_method = "9487A721FE8CC0EDA322618ED3CDFEEE")
    public void preclose() {
        preclosed = true;
        // ---------- Original Method ----------
        //preclosed = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.736 -0400", hash_original_method = "D6339CFBAEA862E2360C9454B8ED0BC8", hash_generated_method = "C90906B1F1E3FF71E54B615A8D2BB084")
    public boolean isPreclosed() {
        boolean varD8AE31ABFACD39F1529F19591E594EAD_1545916132 = (preclosed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_298220399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_298220399;
        // ---------- Original Method ----------
        //return preclosed;
    }

    
}

