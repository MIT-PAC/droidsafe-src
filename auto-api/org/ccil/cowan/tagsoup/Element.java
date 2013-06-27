package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class Element {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.155 -0400", hash_original_field = "E8584B0E37179A7B82F4A85271799B93", hash_generated_field = "3F58E4656692FD6FEAD0053A32B05324")

    private ElementType theType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.155 -0400", hash_original_field = "89E65547A8BBD28E301BA7733FD2E3AF", hash_generated_field = "B0A2FBEB8F242E836C1CA731A6AB041F")

    private AttributesImpl theAtts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.155 -0400", hash_original_field = "A42D0E0DE01D51B60927FDF6C1F0B526", hash_generated_field = "76A7ADBAEEEC2718891FF24B2F2B9374")

    private Element theNext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.155 -0400", hash_original_field = "D8AE31ABFACD39F1529F19591E594EAD", hash_generated_field = "0EC43875BA19E67350871B910584306F")

    private boolean preclosed;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.156 -0400", hash_original_method = "99F284A13C47F669710FCFDC8EC8F9ED", hash_generated_method = "04214B341044697FFBB96FF5A224EEFA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.156 -0400", hash_original_method = "BFA15C1190E0B500E7A321E762D22239", hash_generated_method = "421C401185F34131470487824734C07A")
    public ElementType type() {
        ElementType varB4EAC82CA7396A68D541C85D26508E83_1180255672 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1180255672 = theType;
        varB4EAC82CA7396A68D541C85D26508E83_1180255672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1180255672;
        // ---------- Original Method ----------
        //return theType;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.169 -0400", hash_original_method = "5DFAF4737CD1323AC5BCD66ECC931C62", hash_generated_method = "D7324504F141AC5767E11F029A56888A")
    public AttributesImpl atts() {
        AttributesImpl varB4EAC82CA7396A68D541C85D26508E83_1967670815 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1967670815 = theAtts;
        varB4EAC82CA7396A68D541C85D26508E83_1967670815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1967670815;
        // ---------- Original Method ----------
        //return theAtts;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.177 -0400", hash_original_method = "9BD985D9D137F9E87CC0C75657FC57B8", hash_generated_method = "EE086AB27D29E4AC83E8988377D52047")
    public Element next() {
        Element varB4EAC82CA7396A68D541C85D26508E83_571194924 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_571194924 = theNext;
        varB4EAC82CA7396A68D541C85D26508E83_571194924.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_571194924;
        // ---------- Original Method ----------
        //return theNext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.178 -0400", hash_original_method = "9784418C474A290336108D75EC2613BB", hash_generated_method = "B0D02388E7E125BF20397459054E2AB9")
    public void setNext(Element next) {
        theNext = next;
        // ---------- Original Method ----------
        //theNext = next;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.178 -0400", hash_original_method = "4B70092235E7A40F6E106A246C1B1B53", hash_generated_method = "14598AA911D90151A2D082C878FD27D0")
    public String name() {
        String varB4EAC82CA7396A68D541C85D26508E83_1247486064 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1247486064 = theType.name();
        varB4EAC82CA7396A68D541C85D26508E83_1247486064.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1247486064;
        // ---------- Original Method ----------
        //return theType.name();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.179 -0400", hash_original_method = "80004BAEB2388ADEF62653D4EDD03DA4", hash_generated_method = "CF4E212A68188F42EA034ED551315B16")
    public String namespace() {
        String varB4EAC82CA7396A68D541C85D26508E83_1250412888 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1250412888 = theType.namespace();
        varB4EAC82CA7396A68D541C85D26508E83_1250412888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1250412888;
        // ---------- Original Method ----------
        //return theType.namespace();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.179 -0400", hash_original_method = "013647E32C485C8E11074DEB96ED8B2D", hash_generated_method = "81D1794EFC59140228563F7BE4A3EB66")
    public String localName() {
        String varB4EAC82CA7396A68D541C85D26508E83_177890992 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_177890992 = theType.localName();
        varB4EAC82CA7396A68D541C85D26508E83_177890992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_177890992;
        // ---------- Original Method ----------
        //return theType.localName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.179 -0400", hash_original_method = "3430000E3BB78B9B3224C2ADE055F8C5", hash_generated_method = "9256D6272A7D2ED2317CE83DE16DBC9A")
    public int model() {
        int var87C293C06F6326DAD38E1EED16478E96_1267751764 = (theType.model());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824009233 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_824009233;
        // ---------- Original Method ----------
        //return theType.model();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.183 -0400", hash_original_method = "1DD49D169AB38515FFA4793B4461E091", hash_generated_method = "1B8F0A23C8F1FF5F3565BD557694382B")
    public int memberOf() {
        int varC369B5AC966004DAAEF261D6A5B451C7_1011360904 = (theType.memberOf());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041973107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041973107;
        // ---------- Original Method ----------
        //return theType.memberOf();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.183 -0400", hash_original_method = "383432538F005F982D316492CCCB0325", hash_generated_method = "272D4514FB3BC2BC141EE25D8816A482")
    public int flags() {
        int var5F5B58AEBED9FD6538AC133F2C4BB508_1411311601 = (theType.flags());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000152302 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000152302;
        // ---------- Original Method ----------
        //return theType.flags();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.185 -0400", hash_original_method = "BCFB422D01A5282722899F511B11ECF6", hash_generated_method = "33501CE2487516F9625720F7524A2188")
    public ElementType parent() {
        ElementType varB4EAC82CA7396A68D541C85D26508E83_1725113532 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1725113532 = theType.parent();
        varB4EAC82CA7396A68D541C85D26508E83_1725113532.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1725113532;
        // ---------- Original Method ----------
        //return theType.parent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.185 -0400", hash_original_method = "BC680BBCF0406870088BFC77978994BB", hash_generated_method = "B5A25B0B3E0319B4F9954557B5CA5397")
    public boolean canContain(Element other) {
        boolean varF9189E12565A22C3DA8922E37488105B_1289000835 = (theType.canContain(other.theType));
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1407098468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1407098468;
        // ---------- Original Method ----------
        //return theType.canContain(other.theType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.187 -0400", hash_original_method = "D84E1EF02E49BC2153CE4E53757510D3", hash_generated_method = "255DBE3CCC95BED1505C9869F086C125")
    public void setAttribute(String name, String type, String value) {
        theType.setAttribute(theAtts, name, type, value);
        addTaint(name.getTaint());
        addTaint(type.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //theType.setAttribute(theAtts, name, type, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.201 -0400", hash_original_method = "B1EC3E2E623AD0C28D4FB442F2195ED7", hash_generated_method = "E95B9929143A6EC72CCF183642AE62B2")
    public void anonymize() {
        {
            int i;
            i = theAtts.getLength() - 1;
            {
                {
                    boolean varD8E160731D132C052E071E26A7523DC2_273694172 = (theAtts.getType(i).equals("ID") ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.201 -0400", hash_original_method = "D93155F43F41AF612E7774F463E1747A", hash_generated_method = "B4B52D391184F78EA9AEB671D5DF90F7")
    public void clean() {
        {
            int i;
            i = theAtts.getLength() - 1;
            {
                String name;
                name = theAtts.getLocalName(i);
                {
                    boolean var038E9107644A4E913804C921F9A3F0D9_460528544 = (theAtts.getValue(i) == null || name == null ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.201 -0400", hash_original_method = "4B2B445A367BD9870FD7E6D0B377F667", hash_generated_method = "9487A721FE8CC0EDA322618ED3CDFEEE")
    public void preclose() {
        preclosed = true;
        // ---------- Original Method ----------
        //preclosed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.202 -0400", hash_original_method = "D6339CFBAEA862E2360C9454B8ED0BC8", hash_generated_method = "CBB20DB525C0CC63877DB68849B16286")
    public boolean isPreclosed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1798386552 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1798386552;
        // ---------- Original Method ----------
        //return preclosed;
    }

    
}

