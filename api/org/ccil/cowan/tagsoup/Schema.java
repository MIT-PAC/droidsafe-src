package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;

public abstract class Schema {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.558 -0500", hash_original_field = "7B9B8D8C65214C1209B9736D13129F13", hash_generated_field = "9FCDE2F85894A1F88D902902F60C43F2")

	public static final int M_ANY = 0xFFFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.560 -0500", hash_original_field = "9097721D5F4C408541CA8ACEACBA5D6C", hash_generated_field = "6F158764A73B46F4A4EF45B21BF7FC55")

	public static final int M_EMPTY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.563 -0500", hash_original_field = "9FD9E47ECF3A20AEEA0BA4BA84D2D26B", hash_generated_field = "FB18EC4D7B430B5F3DA623CFEF2C73F4")

	public static final int M_PCDATA = 1 << 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.566 -0500", hash_original_field = "795CB7A6CC138A590ED352B00FC2EAF0", hash_generated_field = "1CEEB9FAE29B30670902C2BB3F4C57A8")

	public static final int M_ROOT = 1 << 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.568 -0500", hash_original_field = "373AB40E918CD93F3D7C0764BA7C902B", hash_generated_field = "BABC86BDE81AF8887C1078673844A155")

	public static final int F_RESTART = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.571 -0500", hash_original_field = "5791D2EBC58ADAC60C798A72C51DB15E", hash_generated_field = "0FA7AC7F743D988121B9D5FEAB58BEF3")

	public static final int F_CDATA = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.573 -0500", hash_original_field = "93FF7A793DC925D22791EC72CFB622BA", hash_generated_field = "ED6D4EA7416612E8042D06B320A6ED78")

	public static final int F_NOFORCE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.575 -0500", hash_original_field = "4FF597B40464138A12F1BC703557698C", hash_generated_field = "C61B01F294C72FE231EFE447D1205178")

	private HashMap theEntities = 
		new HashMap();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.577 -0500", hash_original_field = "E6FDB0B1CE111C676317D30A861DB314", hash_generated_field = "2AE92EDACE151B18CC432468ECADC6DB")

	private HashMap theElementTypes = 
		new HashMap();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.579 -0500", hash_original_field = "D332EB80004BB49BBA7DB7583D6C4F3A", hash_generated_field = "0B2F19732EC7E786F963FECFA20F63AD")

	private String theURI = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.581 -0500", hash_original_field = "8DA8615272D67B88BD5184E710B07CA7", hash_generated_field = "FC283CC8AA8CD94A57C44DB3DEB67DE7")

	private String thePrefix = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.584 -0500", hash_original_field = "6B67E6723A4EDE3F1F1F47B3701CFAF2", hash_generated_field = "ED3D267A195694465C51E002655EFB20")

	private ElementType theRoot = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.189 -0400", hash_original_method = "D0D844E899EF8830D95ED807F7DF602A", hash_generated_method = "D0D844E899EF8830D95ED807F7DF602A")
    public Schema ()
    {
        //Synthesized constructor
    }

	/**
	Add or replace an element type for this schema.
	@param name Name (Qname) of the element
	@param model Models of the element's content as a vector of bits
	@param memberOf Models the element is a member of as a vector of bits
	@param flags Flags for the element
	**/

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.586 -0500", hash_original_method = "9699024F392D458CCB5B62F4AD905856", hash_generated_method = "4AFD451E2BF26CC0F159647EEFC1B89B")
    
public void elementType(String name, int model, int memberOf, int flags) {
		ElementType e = new ElementType(name, model, memberOf, flags, this);
		theElementTypes.put(name.toLowerCase(), e);
		if (memberOf == M_ROOT) theRoot = e;
		}

	/**
	Get the root element of this schema
	**/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.588 -0500", hash_original_method = "7A084406CC3B18F733E08ECB30CF0A86", hash_generated_method = "891CC4941D384D14DFB199FC6400C0E7")
    
public ElementType rootElementType() {
		return theRoot;
		}

	/**
	Add or replace a default attribute for an element type in this schema.
	@param elemName Name (Qname) of the element type
	@param attrName Name (Qname) of the attribute
	@param type Type of the attribute
	@param value Default value of the attribute; null if no default
	**/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.591 -0500", hash_original_method = "1826BAE4A7A25490C40F3DF9456EC509", hash_generated_method = "0536068E09AA97B2F65BC6D788B4F18D")
    
public void attribute(String elemName, String attrName,
				String type, String value) {
		ElementType e = getElementType(elemName);
		if (e == null) {
			throw new Error("Attribute " + attrName +
				" specified for unknown element type " +
				elemName);
			}
		e.setAttribute(attrName, type, value);
		}

	/**
	Specify natural parent of an element in this schema.
	@param name Name of the child element
	@param parentName Name of the parent element
	**/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.593 -0500", hash_original_method = "C7818769967A7B7D6BCF0765E44CE567", hash_generated_method = "44AA204A9050B6BC0FC326F2F3444824")
    
public void parent(String name, String parentName) {
		ElementType child = getElementType(name);
		ElementType parent = getElementType(parentName);
		if (child == null) {
			throw new Error("No child " + name + " for parent " + parentName);
			}
		if (parent == null) {
			throw new Error("No parent " + parentName + " for child " + name);
			}
		child.setParent(parent);
		}

	/**
	Add to or replace a character entity in this schema.
	@param name Name of the entity
	@param value Value of the entity
	**/

	@DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.595 -0500", hash_original_method = "9D058B55598451C1F46B788161F3861A", hash_generated_method = "06F67D4C24568F09661364790AC2A7A2")
    
public void entity(String name, int value) {
		theEntities.put(name, new Integer(value));
		}

	/**
	Get an ElementType by name.
	@param name Name (Qname) of the element type
	@return The corresponding ElementType
	**/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.597 -0500", hash_original_method = "15E50FC94B256079445190BC5C208F0A", hash_generated_method = "4E04A29951EB496FE7F2B795EC7E466D")
    
public ElementType getElementType(String name) {
		return (ElementType)(theElementTypes.get(name.toLowerCase()));
		}

	/**
	Get an entity value by name.
	@param name Name of the entity
	@return The corresponding character, or 0 if none
	**/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.600 -0500", hash_original_method = "5590AE9B6B63818372EC6D8DB973BC8E", hash_generated_method = "8C9D062CFD681C3CA2422E23264E9428")
    
public int getEntity(String name) {
//		System.err.println("%% Looking up entity " + name);
		Integer ch = (Integer)theEntities.get(name);
		if (ch == null) return 0;
		return ch.intValue();
		}

	/**
	Return the URI (namespace name) of this schema.
	**/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.603 -0500", hash_original_method = "1798242D281A34B11A86AFDBABA0D18C", hash_generated_method = "69FBDCE49E0C226DD39EC32B98FA96A7")
    
public String getURI() {
		return theURI;
		}

	/**
	Return the prefix of this schema.
	**/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.605 -0500", hash_original_method = "ED82F113C378B68FF5FAC6A19F5F47F3", hash_generated_method = "6BEFFAE6DB4AFA006FAA151DE7EA718E")
    
public String getPrefix() {
		return thePrefix;
		}

	/**
	Change the URI (namespace name) of this schema.
	**/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.607 -0500", hash_original_method = "234E680F6FA8586452A8BF7CCF48759A", hash_generated_method = "3AD301E5DB89E7DC03F0AFF9512B6578")
    
public void setURI(String uri) {
		theURI = uri;
		}

	/**
	Change the prefix of this schema.
	**/

	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:44.609 -0500", hash_original_method = "4CEDB742D62DCBE17383ACF000150A0B", hash_generated_method = "CE98ACC6EF381A6A0ED84D283E17E530")
    
public void setPrefix(String prefix) {
		thePrefix = prefix;
		}
}

