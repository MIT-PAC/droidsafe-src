package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ElementType {

	/**
	Normalize an attribute value (ID-style).
	CDATA-style attribute normalization is already done.
	@param value The value to normalize
	@return The normalized value
	**/
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.085 -0500", hash_original_method = "1F863325AF2C0E7F13338BA09821D55A", hash_generated_method = "AAA224C6EEF138024ADBB901DEBA5E26")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.032 -0500", hash_original_field = "C9BF456096FD1EDE64799D87FE904F59", hash_generated_field = "8ED9B31DDDAAEF65D7BC0612CAD3C8F5")

	private String theName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.034 -0500", hash_original_field = "0D015F2E6E1B3535A1A820BF1CC408A7", hash_generated_field = "19C10BCA5601E77C9A4AD4EB7613A6D2")

	private String theNamespace;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.037 -0500", hash_original_field = "390AA937FAC4200A18EF0EA5C819ADA9", hash_generated_field = "908B54F8164D1728F147F01078E48FD7")

	private String theLocalName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.039 -0500", hash_original_field = "BB5B772DCE785F8F77C3047833133EB4", hash_generated_field = "29F2E6973C085F18D48340ABDDFD37F9")

	private int theModel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.041 -0500", hash_original_field = "A5436F7B3761984FF8F03E11B8DCD560", hash_generated_field = "BCDF5B935532376D5B4CFDA618EF9F39")

	private int theMemberOf;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.043 -0500", hash_original_field = "937B87D7BFF9788287E5540AAE018D0D", hash_generated_field = "CAADB9D6664219E6AE1F0AA6CE0533C4")

	private int theFlags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.045 -0500", hash_original_field = "04C9AEBC1E4947AFBDB44B7BD1940B45", hash_generated_field = "B0A2FBEB8F242E836C1CA731A6AB041F")

	private AttributesImpl theAtts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.047 -0500", hash_original_field = "1D6144944F238F7E999319D76CE9A583", hash_generated_field = "0A3173D9C249D5F313C956327888B602")

	private ElementType theParent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.049 -0500", hash_original_field = "28AB313AF53C2A1BC66B7A4934DF6012", hash_generated_field = "B0C8961A31DE3AC8E1FA05C39CF43268")

	private Schema theSchema;	// schema to which this belongs

	/**
	Construct an ElementType:
	but it's better to use Schema.element() instead.
	The content model, member-of, and flags vectors are specified as ints.
	@param name The element type name
	@param model ORed-together bits representing the content models
	   allowed in the content of this element type
	@param memberOf ORed-together bits representing the content models
	   to which this element type belongs
	@param flags ORed-together bits representing the flags associated
	   with this element type
	@param schema The schema with which this element type will be
	associated
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.052 -0500", hash_original_method = "B2956F900AF52D9E41A7969852791670", hash_generated_method = "B85A43553E3A2E354F79DAA8C0BBDF5A")
    
public ElementType(String name, int model, int memberOf, int flags, Schema schema) {
		theName = name;
		theModel = model;
		theMemberOf = memberOf;
		theFlags = flags;
		theAtts = new AttributesImpl();
		theSchema = schema;
		theNamespace = namespace(name, false);
		theLocalName = localName(name);
		}
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.761 -0400", hash_original_method = "4A889710B67B4CF3F628D3945249B60A", hash_generated_method = "8036DA52FB4BA64617C0DA44519E5FF0")
    public String namespace(String name, boolean attribute) {
        addTaint(attribute);
        addTaint(name.getTaint());
        int colon = name.indexOf(':');
        if(colon == -1)        
        {
String varAB2345C238CB3313D565FE6B975DC720_909030397 =             attribute ? "" : theSchema.getURI();
            varAB2345C238CB3313D565FE6B975DC720_909030397.addTaint(getTaint());
            return varAB2345C238CB3313D565FE6B975DC720_909030397;
        } //End block
        String prefix = name.substring(0, colon);
        if(prefix.equals("xml"))        
        {
String varB42E997512DFFB350471AB44C36A387C_1201065483 =             "http://www.w3.org/XML/1998/namespace";
            varB42E997512DFFB350471AB44C36A387C_1201065483.addTaint(getTaint());
            return varB42E997512DFFB350471AB44C36A387C_1201065483;
        } //End block
        else
        {
String varAA673C9A0924498AE38DAA66A4683FC8_1871885814 =             ("urn:x-prefix:" + prefix).intern();
            varAA673C9A0924498AE38DAA66A4683FC8_1871885814.addTaint(getTaint());
            return varAA673C9A0924498AE38DAA66A4683FC8_1871885814;
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

	/**
	Return a local name from a Qname.
	@param name The Qname
	@return The local name
	**/
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.056 -0500", hash_original_method = "76654AC28D619222BBA1A28B5AC8BB60", hash_generated_method = "3C614CFF977835D0BE5CAEABFB7C59E3")
    
public String localName(String name) {
		int colon = name.indexOf(':');
		if (colon == -1) {
			return name;
			}
		else {
			return name.substring(colon+1).intern();
			}
		}

	/**
	Returns the name of this element type.
	@return The name of the element type
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.058 -0500", hash_original_method = "AEAF2CA6A2A9BD287C2AECB04BDA5589", hash_generated_method = "29C14E4FBC90CD3C4AFEE2BE2A31847E")
    
public String name() { return theName; }

	/**
	Returns the namespace name of this element type.
	@return The namespace name of the element type
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.061 -0500", hash_original_method = "D5C09A7EAC3540D5025F54207902E2D8", hash_generated_method = "0A3A120914A3FC2CDB8394889CA70444")
    
public String namespace() { return theNamespace; }

	/**
	Returns the local name of this element type.
	@return The local name of the element type
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.063 -0500", hash_original_method = "7820A4FDEE02D17FDE49851C9121389B", hash_generated_method = "7AC79524ED0EBA889F1E1AF706679515")
    
public String localName() { return theLocalName; }

	/**
	Returns the content models of this element type.
	@return The content models of this element type as a vector of bits
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.065 -0500", hash_original_method = "863150B34251535222F20C0EAB163E01", hash_generated_method = "C6707C99228A8487FEA6AB57A4EE8C5B")
    
public int model() { return theModel; }

	/**
	Returns the content models to which this element type belongs.
	@return The content models to which this element type belongs as a
	   vector of bits
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.068 -0500", hash_original_method = "9FFB3E9386976737FD5FBA37B814C4D0", hash_generated_method = "A81D559722C826C072C8443710626B34")
    
public int memberOf() { return theMemberOf; }

	/**
	Returns the flags associated with this element type.
	@return The flags associated with this element type as a vector of bits
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.071 -0500", hash_original_method = "19D08FF6AA5F9D4D6B65E686C6EC5676", hash_generated_method = "679C3A0573ECBD7C7C7659C937002ECA")
    
public int flags() { return theFlags; }

	/**
	Returns the default attributes associated with this element type.
	Attributes of type CDATA that don't have default values are
	typically not included.  Other attributes without default values
	have an internal value of <tt>null</tt>.
	The return value is an AttributesImpl to allow the caller to mutate
	the attributes.
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.073 -0500", hash_original_method = "5DFAF4737CD1323AC5BCD66ECC931C62", hash_generated_method = "A5059275FC8F144B7A8A5FD136ABE33B")
    
public AttributesImpl atts() {return theAtts;}

	/**
	Returns the parent element type of this element type.
	@return The parent element type
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.075 -0500", hash_original_method = "E92CD830CE12526F79993827804AE423", hash_generated_method = "BCEB42369EE07C003669C698ED16F549")
    
public ElementType parent() {return theParent;}

	/**
	Returns the schema which this element type is associated with.
	@return The schema
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.077 -0500", hash_original_method = "5ED9C031E5D9227A40A639080CADBFC4", hash_generated_method = "22BF3ECCFE3C34E0208F4D8D850AF163")
    
public Schema schema() {return theSchema;}

	/**
	Returns true if this element type can contain another element type.
	That is, if any of the models in this element's model vector
	match any of the models in the other element type's member-of
	vector.
	@param other The other element type
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.079 -0500", hash_original_method = "3CB53268EE03367F93FB62614B11BBE8", hash_generated_method = "62695132D3996D94203F0867318C9D15")
    
public boolean canContain(ElementType other) {
		return (theModel & other.theMemberOf) != 0;
		}

	/**
	Sets an attribute and its value into an AttributesImpl object.
	Attempts to set a namespace declaration are ignored.
	@param atts The AttributesImpl object
	@param name The name (Qname) of the attribute
	@param type The type of the attribute
	@param value The value of the attribute
	*/

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.082 -0500", hash_original_method = "704A404E71DCE2FCDA4DFB645734E42D", hash_generated_method = "A4CB3D824D3358C4B0FDC3DF58D30A92")
    
public void setAttribute(AttributesImpl atts, String name, String type, String value) {
		if (name.equals("xmlns") || name.startsWith("xmlns:")) {
			return;
			}
;
		String namespace = namespace(name, true);
		String localName = localName(name);
		int i = atts.getIndex(name);
		if (i == -1) {
			name = name.intern();
			if (type == null) type = "CDATA";
			if (!type.equals("CDATA")) value = normalize(value);
			atts.addAttribute(namespace, localName, name, type, value);
			}
		else {
			if (type == null) type = atts.getType(i);
			if (!type.equals("CDATA")) value=normalize(value);
			atts.setAttribute(i, namespace, localName, name, type, value);
			}
		}

	/**
	Sets an attribute and its value into this element type.
	@param name The name of the attribute
	@param type The type of the attribute
	@param value The value of the attribute
	*/

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.087 -0500", hash_original_method = "EA247B977CB57294BB68422F3AC78185", hash_generated_method = "DB609339BB276B926F59AF9100DC19FD")
    
public void setAttribute(String name, String type, String value) {
		setAttribute(theAtts, name, type, value);
		}

	/**
	Sets the models of this element type.
	@param model The content models of this element type as a vector of bits
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.089 -0500", hash_original_method = "3D843454E0461CA80E31D71540C9240B", hash_generated_method = "B38E7B1CC13F14CC809C2666DFDB24F2")
    
public void setModel(int model) { theModel = model; }

	/**
	Sets the content models to which this element type belongs.
	@param memberOf The content models to which this element type belongs as a vector of bits
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.092 -0500", hash_original_method = "49C12A488EE0CFA925BEADC8ACD7C6C0", hash_generated_method = "D8FC33FA051DC00DAD4A8826E568DC82")
    
public void setMemberOf(int memberOf) { theMemberOf = memberOf; }

	/**
	Sets the flags of this element type.
	@param flags associated with this element type The flags as a vector of bits
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.094 -0500", hash_original_method = "40381178E3FA56E0EF661C8DC2AD49FA", hash_generated_method = "49FF43A90A4B8EEF8A1309A42243A1E3")
    
public void setFlags(int flags) { theFlags = flags; }

	/**
	Sets the parent element type of this element type.
	@param parent The parent element type
	*/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.096 -0500", hash_original_method = "DBB2D29F8F1C5757D222A7D837762BD5", hash_generated_method = "FF7F2BFA65D275731047E832D0945722")
    
public void setParent(ElementType parent) { theParent = parent; }
    
}

