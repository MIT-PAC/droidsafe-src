package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Element {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.764 -0500", hash_original_field = "48FC5DA7D9A4C1BF369BCA91A9EC45AD", hash_generated_field = "3F58E4656692FD6FEAD0053A32B05324")

	private ElementType theType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.766 -0500", hash_original_field = "04C9AEBC1E4947AFBDB44B7BD1940B45", hash_generated_field = "B0A2FBEB8F242E836C1CA731A6AB041F")

	private AttributesImpl theAtts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.768 -0500", hash_original_field = "3BA245AB5C0EF9B9814A4513B5FCA2E5", hash_generated_field = "76A7ADBAEEEC2718891FF24B2F2B9374")

	private Element theNext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.771 -0500", hash_original_field = "8157089D2DE843FF2DCA1650A0353374", hash_generated_field = "0EC43875BA19E67350871B910584306F")

	private boolean preclosed;		// this element has been preclosed

	/**
	Return an Element from a specified ElementType.
	@param type The element type of the newly constructed element
	@param defaultAttributes True if default attributes are wanted
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.773 -0500", hash_original_method = "99F284A13C47F669710FCFDC8EC8F9ED", hash_generated_method = "F656DF0A2026E45460A68C892D839B4D")
    
public Element(ElementType type, boolean defaultAttributes) {
		theType = type;
		if (defaultAttributes) theAtts = new AttributesImpl(type.atts());
		else theAtts = new AttributesImpl();
		theNext = null;
		preclosed = false;
		}

	/**
	Return the element type.
	@return The element type.
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.776 -0500", hash_original_method = "BFA15C1190E0B500E7A321E762D22239", hash_generated_method = "2875FF332AF6CE4B8C63A2367206488B")
    
public ElementType type() { return theType; }

	/**
	Return the attributes as an AttributesImpl object.
	Returning an AttributesImpl makes the attributes mutable.
	@return The attributes
	@see AttributesImpl
	*/
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.778 -0500", hash_original_method = "5DFAF4737CD1323AC5BCD66ECC931C62", hash_generated_method = "A5059275FC8F144B7A8A5FD136ABE33B")
    
public AttributesImpl atts() { return theAtts; }

	/**
	Return the next element in an element stack or queue.
	@return The next element
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.780 -0500", hash_original_method = "9BD985D9D137F9E87CC0C75657FC57B8", hash_generated_method = "32FF19C454094FA2C68CBFDFC4AA27D0")
    
public Element next() { return theNext; }

	/**
	Change the next element in an element stack or queue.
	@param next The new next element
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.782 -0500", hash_original_method = "9784418C474A290336108D75EC2613BB", hash_generated_method = "DF1C8B4C96BD5AB4F2458D45A009ADC3")
    
public void setNext(Element next) { theNext = next; }

	/**
	Return the name of the element's type.
	Convenience method.
	@return The element type name
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.784 -0500", hash_original_method = "4B70092235E7A40F6E106A246C1B1B53", hash_generated_method = "D91682FC0B2A992D45586C42FA5F0135")
    
public String name() { return theType.name(); }

	/**
	Return the namespace name of the element's type.
	Convenience method.
	@return The element type namespace name
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.787 -0500", hash_original_method = "80004BAEB2388ADEF62653D4EDD03DA4", hash_generated_method = "9277F78D069B6EE853C29B83B4097FBF")
    
public String namespace() { return theType.namespace(); }

	/**
	Return the local name of the element's type.
	Convenience method.
	@return The element type local name
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.789 -0500", hash_original_method = "013647E32C485C8E11074DEB96ED8B2D", hash_generated_method = "7E29A0B3CD01F381409D46FE78A1FB1B")
    
public String localName() { return theType.localName(); }

	/**
	Return the content model vector of the element's type.
	Convenience method.
	@return The content model vector
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.791 -0500", hash_original_method = "3430000E3BB78B9B3224C2ADE055F8C5", hash_generated_method = "89985E528DD0E88B550D9AD8B3FD074E")
    
public int model() { return theType.model(); }

	/**
	Return the member-of vector of the element's type.
	Convenience method.
	@return The member-of vector
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.793 -0500", hash_original_method = "1DD49D169AB38515FFA4793B4461E091", hash_generated_method = "7F429E698C9C5E544D1E6A71723F5085")
    
public int memberOf() { return theType.memberOf(); }

	/**
	Return the flags vector of the element's type.
	Convenience method.
	@return The flags vector
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.796 -0500", hash_original_method = "383432538F005F982D316492CCCB0325", hash_generated_method = "F9919C39AE93CC0FEAFC8BF6BBA4B875")
    
public int flags() { return theType.flags(); }

	/**
	Return the parent element type of the element's type.
	Convenience method.
	@return The parent element type
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.798 -0500", hash_original_method = "BCFB422D01A5282722899F511B11ECF6", hash_generated_method = "14D7A8B5CD7268744EC7DA49036B42B1")
    
public ElementType parent() { return theType.parent(); }

	/**
	Return true if the type of this element can contain the type of
	another element.
	Convenience method.
	@param other The other element
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.800 -0500", hash_original_method = "BC680BBCF0406870088BFC77978994BB", hash_generated_method = "FFE885D5C9B076C775282870959EC876")
    
public boolean canContain(Element other) {
		return theType.canContain(other.theType);
		}

	/**
	Set an attribute and its value into this element.
	@param name The attribute name (Qname)
	@param type The attribute type
	@param value The attribute value
	*/

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.803 -0500", hash_original_method = "D84E1EF02E49BC2153CE4E53757510D3", hash_generated_method = "7B76AD311063C5CDD549D2B8CD04EBE0")
    
public void setAttribute(String name, String type, String value) {
		theType.setAttribute(theAtts, name, type, value);
		}

	/**
	Make this element anonymous.
	Remove any <tt>id</tt> or <tt>name</tt> attribute present
	in the element's attributes.
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.805 -0500", hash_original_method = "B1EC3E2E623AD0C28D4FB442F2195ED7", hash_generated_method = "F36128AF3450EEB3C5ECD679FC6680CB")
    
public void anonymize() {
		for (int i = theAtts.getLength() - 1; i >= 0; i--) {
			if (theAtts.getType(i).equals("ID") ||
			    theAtts.getQName(i).equals("name")) {
				theAtts.removeAttribute(i);
				}
			}
		}

	/**
	Clean the attributes of this element.
	Attributes with null name (the name was ill-formed)
	or null value (the attribute was present in the element type but
	not in this actual element) are removed.
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.808 -0500", hash_original_method = "D93155F43F41AF612E7774F463E1747A", hash_generated_method = "B0A07F09AFEBA201295BC1C071BF2828")
    
public void clean() {
		for (int i = theAtts.getLength() - 1; i >= 0; i--) {
			String name = theAtts.getLocalName(i);
			if (theAtts.getValue(i) == null || name == null ||
					name.length() == 0) {
				theAtts.removeAttribute(i);
				continue;
				}
			}
		}

	/**
	Force this element to preclosed status, meaning that an end-tag has
	been seen but the element cannot yet be closed for structural reasons.
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.810 -0500", hash_original_method = "4B2B445A367BD9870FD7E6D0B377F667", hash_generated_method = "8E320527BB20B219C7F2ACCCB3287FEA")
    
public void preclose() {
		preclosed = true;
		}

	/**
	Return true if this element has been preclosed.
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.812 -0500", hash_original_method = "D6339CFBAEA862E2360C9454B8ED0BC8", hash_generated_method = "75DBB3A9402117CEFF362A3890042B39")
    
public boolean isPreclosed() {
		return preclosed;
		}
    
}

