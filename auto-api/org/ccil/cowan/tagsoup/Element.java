package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Element {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.131 -0400", hash_original_field = "E8584B0E37179A7B82F4A85271799B93", hash_generated_field = "3F58E4656692FD6FEAD0053A32B05324")

    private ElementType theType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.131 -0400", hash_original_field = "89E65547A8BBD28E301BA7733FD2E3AF", hash_generated_field = "B0A2FBEB8F242E836C1CA731A6AB041F")

    private AttributesImpl theAtts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.132 -0400", hash_original_field = "A42D0E0DE01D51B60927FDF6C1F0B526", hash_generated_field = "76A7ADBAEEEC2718891FF24B2F2B9374")

    private Element theNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.132 -0400", hash_original_field = "D8AE31ABFACD39F1529F19591E594EAD", hash_generated_field = "0EC43875BA19E67350871B910584306F")

    private boolean preclosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.138 -0400", hash_original_method = "99F284A13C47F669710FCFDC8EC8F9ED", hash_generated_method = "04214B341044697FFBB96FF5A224EEFA")
    public  Element(ElementType type, boolean defaultAttributes) {
        theType = type;
        theAtts = new AttributesImpl(type.atts());
        theAtts = new AttributesImpl();
        theNext = null;
        preclosed = false;
        addTaint(defaultAttributes);
        // ---------- Original Method ----------
        //theType = type;
        //if (defaultAttributes) theAtts = new AttributesImpl(type.atts());
		//else theAtts = new AttributesImpl();
        //theNext = null;
        //preclosed = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.139 -0400", hash_original_method = "BFA15C1190E0B500E7A321E762D22239", hash_generated_method = "79D08E61BE28155B1E57229A6470F347")
    public ElementType type() {
        ElementType varB4EAC82CA7396A68D541C85D26508E83_1527325687 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1527325687 = theType;
        varB4EAC82CA7396A68D541C85D26508E83_1527325687.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1527325687;
        // ---------- Original Method ----------
        //return theType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.139 -0400", hash_original_method = "5DFAF4737CD1323AC5BCD66ECC931C62", hash_generated_method = "535262A3FC32E6CDE984A89FCAD215D7")
    public AttributesImpl atts() {
        AttributesImpl varB4EAC82CA7396A68D541C85D26508E83_469648753 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_469648753 = theAtts;
        varB4EAC82CA7396A68D541C85D26508E83_469648753.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_469648753;
        // ---------- Original Method ----------
        //return theAtts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.140 -0400", hash_original_method = "9BD985D9D137F9E87CC0C75657FC57B8", hash_generated_method = "66158C835CA1F87CB0A38F17F8109B8F")
    public Element next() {
        Element varB4EAC82CA7396A68D541C85D26508E83_2090114005 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2090114005 = theNext;
        varB4EAC82CA7396A68D541C85D26508E83_2090114005.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2090114005;
        // ---------- Original Method ----------
        //return theNext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.140 -0400", hash_original_method = "9784418C474A290336108D75EC2613BB", hash_generated_method = "B0D02388E7E125BF20397459054E2AB9")
    public void setNext(Element next) {
        theNext = next;
        // ---------- Original Method ----------
        //theNext = next;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.140 -0400", hash_original_method = "4B70092235E7A40F6E106A246C1B1B53", hash_generated_method = "40432987692659CDA1A270471D1BB0E7")
    public String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_554153925 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_554153925 = theType.name();
        varB4EAC82CA7396A68D541C85D26508E83_554153925.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_554153925;
        // ---------- Original Method ----------
        //return theType.name();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.141 -0400", hash_original_method = "80004BAEB2388ADEF62653D4EDD03DA4", hash_generated_method = "3726AFB7440A295AF47E199098FE5EB6")
    public String namespace() {
        String varB4EAC82CA7396A68D541C85D26508E83_894927599 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_894927599 = theType.namespace();
        varB4EAC82CA7396A68D541C85D26508E83_894927599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_894927599;
        // ---------- Original Method ----------
        //return theType.namespace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.141 -0400", hash_original_method = "013647E32C485C8E11074DEB96ED8B2D", hash_generated_method = "DB0A73343B110175DEF5B6EB9BA20821")
    public String localName() {
        String varB4EAC82CA7396A68D541C85D26508E83_199293514 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_199293514 = theType.localName();
        varB4EAC82CA7396A68D541C85D26508E83_199293514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_199293514;
        // ---------- Original Method ----------
        //return theType.localName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.163 -0400", hash_original_method = "3430000E3BB78B9B3224C2ADE055F8C5", hash_generated_method = "B78B2C18C4CBF20535E33744C5E6275D")
    public int model() {
        int var87C293C06F6326DAD38E1EED16478E96_366204328 = (theType.model());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546096884 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_546096884;
        // ---------- Original Method ----------
        //return theType.model();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.163 -0400", hash_original_method = "1DD49D169AB38515FFA4793B4461E091", hash_generated_method = "6AA419A25D63C25318FB18A424F1DFD7")
    public int memberOf() {
        int varC369B5AC966004DAAEF261D6A5B451C7_1437033124 = (theType.memberOf());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027865447 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027865447;
        // ---------- Original Method ----------
        //return theType.memberOf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.163 -0400", hash_original_method = "383432538F005F982D316492CCCB0325", hash_generated_method = "47E2B3BB090E5C19037BB9E08E96D958")
    public int flags() {
        int var5F5B58AEBED9FD6538AC133F2C4BB508_31921343 = (theType.flags());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651205919 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_651205919;
        // ---------- Original Method ----------
        //return theType.flags();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.164 -0400", hash_original_method = "BCFB422D01A5282722899F511B11ECF6", hash_generated_method = "6B24482E499C256A2CB5D08C98B39C45")
    public ElementType parent() {
        ElementType varB4EAC82CA7396A68D541C85D26508E83_1298586854 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1298586854 = theType.parent();
        varB4EAC82CA7396A68D541C85D26508E83_1298586854.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1298586854;
        // ---------- Original Method ----------
        //return theType.parent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.164 -0400", hash_original_method = "BC680BBCF0406870088BFC77978994BB", hash_generated_method = "D24C10EE5EAB5B4A6406357840499952")
    public boolean canContain(Element other) {
        boolean varF9189E12565A22C3DA8922E37488105B_1266528843 = (theType.canContain(other.theType));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1622533557 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1622533557;
        // ---------- Original Method ----------
        //return theType.canContain(other.theType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.164 -0400", hash_original_method = "D84E1EF02E49BC2153CE4E53757510D3", hash_generated_method = "255DBE3CCC95BED1505C9869F086C125")
    public void setAttribute(String name, String type, String value) {
        theType.setAttribute(theAtts, name, type, value);
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //theType.setAttribute(theAtts, name, type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.165 -0400", hash_original_method = "B1EC3E2E623AD0C28D4FB442F2195ED7", hash_generated_method = "4D552BAD0F9A6E4121FD13F04886DE3D")
    public void anonymize() {
        {
            int i;
            i = theAtts.getLength() - 1;
            {
                {
                    boolean varD8E160731D132C052E071E26A7523DC2_1398816617 = (theAtts.getType(i).equals("ID") ||
			    theAtts.getQName(i).equals("name"));
                    {
                        theAtts.removeAttribute(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = theAtts.getLength() - 1; i >= 0; i--) {
			//if (theAtts.getType(i).equals("ID") ||
			    //theAtts.getQName(i).equals("name")) {
				//theAtts.removeAttribute(i);
				//}
			//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.166 -0400", hash_original_method = "D93155F43F41AF612E7774F463E1747A", hash_generated_method = "7731806854FDF7033ADD618551B21B72")
    public void clean() {
        {
            int i;
            i = theAtts.getLength() - 1;
            {
                String name;
                name = theAtts.getLocalName(i);
                {
                    boolean var038E9107644A4E913804C921F9A3F0D9_1178808161 = (theAtts.getValue(i) == null || name == null ||
					name.length() == 0);
                    {
                        theAtts.removeAttribute(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.166 -0400", hash_original_method = "4B2B445A367BD9870FD7E6D0B377F667", hash_generated_method = "9487A721FE8CC0EDA322618ED3CDFEEE")
    public void preclose() {
        preclosed = true;
        // ---------- Original Method ----------
        //preclosed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.166 -0400", hash_original_method = "D6339CFBAEA862E2360C9454B8ED0BC8", hash_generated_method = "23BA1523930B67707A568EBCFAB5DBAC")
    public boolean isPreclosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_48758208 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_48758208;
        // ---------- Original Method ----------
        //return preclosed;
    }

    
}

