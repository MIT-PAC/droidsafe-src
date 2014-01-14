package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.xml.sax.Attributes;

public class AttributesImpl implements Attributes {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.969 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "F8DDE62EA42266C7FC49FC2E2B951350")

    // Internal state.
    ////////////////////////////////////////////////////////////////////

    int length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.971 -0500", hash_original_field = "FF698A9C75F799EB4FE98C16A723AC90", hash_generated_field = "FF698A9C75F799EB4FE98C16A723AC90")

    String data [];

    ////////////////////////////////////////////////////////////////////
    // Constructors.
    ////////////////////////////////////////////////////////////////////

    /**
     * Construct a new, empty AttributesImpl object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.909 -0500", hash_original_method = "6313F45FC494FF406CD3064C58B63747", hash_generated_method = "C370A03C37745247C8F94146A819EC26")
    
public AttributesImpl ()
    {
    length = 0;
    data = null;
    }

    /**
     * Copy an existing Attributes object.
     *
     * <p>This constructor is especially useful inside a
     * {@link org.xml.sax.ContentHandler#startElement startElement} event.</p>
     *
     * @param atts The existing Attributes object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.911 -0500", hash_original_method = "8A0D874B41C17812C2FD00F4B363184D", hash_generated_method = "07852CEA6C2E1732055321149F419CFF")
    
public AttributesImpl (Attributes atts)
    {
    setAttributes(atts);
    }

    ////////////////////////////////////////////////////////////////////
    // Implementation of org.xml.sax.Attributes.
    ////////////////////////////////////////////////////////////////////

    /**
     * Return the number of attributes in the list.
     *
     * @return The number of attributes in the list.
     * @see org.xml.sax.Attributes#getLength
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.913 -0500", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "AF903EC3B9FE28DC883DCDAF202C537E")
    
public int getLength ()
    {
    return length;
    }

    /**
     * Return an attribute's Namespace URI.
     *
     * @param index The attribute's index (zero-based).
     * @return The Namespace URI, the empty string if none is
     *         available, or null if the index is out of range.
     * @see org.xml.sax.Attributes#getURI
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.916 -0500", hash_original_method = "1BF0AE5363A8618B6A71FCEE06881B7C", hash_generated_method = "0FFFF132B4642A83FB51F09E8A0805A7")
    
public String getURI (int index)
    {
    if (index >= 0 && index < length) {
        return data[index*5];
    } else {
        return null;
    }
    }

    /**
     * Return an attribute's local name.
     *
     * @param index The attribute's index (zero-based).
     * @return The attribute's local name, the empty string if
     *         none is available, or null if the index if out of range.
     * @see org.xml.sax.Attributes#getLocalName
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.918 -0500", hash_original_method = "92B1686F7E458511CE45EC4DB3E3CE89", hash_generated_method = "1535CAF44B8EFA0A3C48A1C3BD66BF06")
    
public String getLocalName (int index)
    {
    if (index >= 0 && index < length) {
        return data[index*5+1];
    } else {
        return null;
    }
    }

    /**
     * Return an attribute's qualified (prefixed) name.
     *
     * @param index The attribute's index (zero-based).
     * @return The attribute's qualified name, the empty string if
     *         none is available, or null if the index is out of bounds.
     * @see org.xml.sax.Attributes#getQName
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.920 -0500", hash_original_method = "32BD7D7FFA2C46007E9D534F2070D779", hash_generated_method = "E8383D48F2D53371D50DA725131EC7FB")
    
public String getQName (int index)
    {
    if (index >= 0 && index < length) {
        return data[index*5+2];
    } else {
        return null;
    }
    }

    /**
     * Return an attribute's type by index.
     *
     * @param index The attribute's index (zero-based).
     * @return The attribute's type, "CDATA" if the type is unknown, or null
     *         if the index is out of bounds.
     * @see org.xml.sax.Attributes#getType(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.922 -0500", hash_original_method = "CD55E4A1C2CBE3FE53B5A622E57F028C", hash_generated_method = "BF093253DB32009BC7EA7A29E1969D9E")
    
public String getType (int index)
    {
    if (index >= 0 && index < length) {
        return data[index*5+3];
    } else {
        return null;
    }
    }

    /**
     * Return an attribute's value by index.
     *
     * @param index The attribute's index (zero-based).
     * @return The attribute's value or null if the index is out of bounds.
     * @see org.xml.sax.Attributes#getValue(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.924 -0500", hash_original_method = "7BC4C2655702EDFE2361F9F97C33BDBD", hash_generated_method = "5E1A71BD421981F5C4A3E55A52E5CBDB")
    
public String getValue (int index)
    {
    if (index >= 0 && index < length) {
        return data[index*5+4];
    } else {
        return null;
    }
    }

    /**
     * Look up an attribute's index by Namespace name.
     *
     * <p>In many cases, it will be more efficient to look up the name once and
     * use the index query methods rather than using the name query methods
     * repeatedly.</p>
     *
     * @param uri The attribute's Namespace URI, or the empty
     *        string if none is available.
     * @param localName The attribute's local name.
     * @return The attribute's index, or -1 if none matches.
     * @see org.xml.sax.Attributes#getIndex(java.lang.String,java.lang.String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.927 -0500", hash_original_method = "090A4B083F61ECB7CB7169BD1EF033DF", hash_generated_method = "34F4F14577D0E0B4F663B614D68BA077")
    
public int getIndex (String uri, String localName)
    {
    int max = length * 5;
    for (int i = 0; i < max; i += 5) {
        if (data[i].equals(uri) && data[i+1].equals(localName)) {
        return i / 5;
        }
    }
    return -1;
    }

    /**
     * Look up an attribute's index by qualified (prefixed) name.
     *
     * @param qName The qualified name.
     * @return The attribute's index, or -1 if none matches.
     * @see org.xml.sax.Attributes#getIndex(java.lang.String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.929 -0500", hash_original_method = "EE3F059D65C038AB1F6CDD7302F8C95C", hash_generated_method = "213BD369DC01DBAC4203C3A74740F3CF")
    
public int getIndex (String qName)
    {
    int max = length * 5;
    for (int i = 0; i < max; i += 5) {
        if (data[i+2].equals(qName)) {
        return i / 5;
        }
    }
    return -1;
    }

    /**
     * Look up an attribute's type by Namespace-qualified name.
     *
     * @param uri The Namespace URI, or the empty string for a name
     *        with no explicit Namespace URI.
     * @param localName The local name.
     * @return The attribute's type, or null if there is no
     *         matching attribute.
     * @see org.xml.sax.Attributes#getType(java.lang.String,java.lang.String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.931 -0500", hash_original_method = "B693D2A452C34B3F63F46AE3F73B4CD6", hash_generated_method = "0E635E92BE81ABFAE39C45ED6E1AE126")
    
public String getType (String uri, String localName)
    {
    int max = length * 5;
    for (int i = 0; i < max; i += 5) {
        if (data[i].equals(uri) && data[i+1].equals(localName)) {
        return data[i+3];
        }
    }
    return null;
    }

    /**
     * Look up an attribute's type by qualified (prefixed) name.
     *
     * @param qName The qualified name.
     * @return The attribute's type, or null if there is no
     *         matching attribute.
     * @see org.xml.sax.Attributes#getType(java.lang.String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.933 -0500", hash_original_method = "EC27C5C1CA5357EEA1E16E770BA20FA2", hash_generated_method = "02AB4DE7FBB7D8E73706EC1ED1F91DE7")
    
public String getType (String qName)
    {
    int max = length * 5;
    for (int i = 0; i < max; i += 5) {
        if (data[i+2].equals(qName)) {
        return data[i+3];
        }
    }
    return null;
    }

    /**
     * Look up an attribute's value by Namespace-qualified name.
     *
     * @param uri The Namespace URI, or the empty string for a name
     *        with no explicit Namespace URI.
     * @param localName The local name.
     * @return The attribute's value, or null if there is no
     *         matching attribute.
     * @see org.xml.sax.Attributes#getValue(java.lang.String,java.lang.String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.936 -0500", hash_original_method = "522BBD1273EB28D82A0CFFAB0B22501D", hash_generated_method = "5D3230EED6E41B8C7028094FAB1539DB")
    
public String getValue (String uri, String localName)
    {
    int max = length * 5;
    for (int i = 0; i < max; i += 5) {
        if (data[i].equals(uri) && data[i+1].equals(localName)) {
        return data[i+4];
        }
    }
    return null;
    }

    /**
     * Look up an attribute's value by qualified (prefixed) name.
     *
     * @param qName The qualified name.
     * @return The attribute's value, or null if there is no
     *         matching attribute.
     * @see org.xml.sax.Attributes#getValue(java.lang.String)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.938 -0500", hash_original_method = "4282B0A2744D6B6FFA141D6FBFC4111A", hash_generated_method = "26C05066D63A3AF96C038D1448FD8999")
    
public String getValue (String qName)
    {
    int max = length * 5;
    for (int i = 0; i < max; i += 5) {
        if (data[i+2].equals(qName)) {
        return data[i+4];
        }
    }
    return null;
    }

    ////////////////////////////////////////////////////////////////////
    // Manipulators.
    ////////////////////////////////////////////////////////////////////

    /**
     * Clear the attribute list for reuse.
     *
     * <p>Note that little memory is freed by this call:
     * the current array is kept so it can be
     * reused.</p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.941 -0500", hash_original_method = "03C848B66796F8DBDE7832677AAFA935", hash_generated_method = "4F616F61747CD5D98531C671A2ACFE93")
    
public void clear ()
    {
    if (data != null) {
        for (int i = 0; i < (length * 5); i++)
        data [i] = null;
    }
    length = 0;
    }

    /**
     * Copy an entire Attributes object.
     *
     * <p>It may be more efficient to reuse an existing object
     * rather than constantly allocating new ones.</p>
     *
     * @param atts The attributes to copy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.943 -0500", hash_original_method = "AF86DF649668A0410832106AC7F2AE57", hash_generated_method = "BF682236C61170884AA2CC449B40ADB1")
    
public void setAttributes (Attributes atts)
    {
        clear();
        length = atts.getLength();
        if (length > 0) {
            data = new String[length*5];
            for (int i = 0; i < length; i++) {
                data[i*5] = atts.getURI(i);
                data[i*5+1] = atts.getLocalName(i);
                data[i*5+2] = atts.getQName(i);
                data[i*5+3] = atts.getType(i);
                data[i*5+4] = atts.getValue(i);
            }
    }
    }

    /**
     * Add an attribute to the end of the list.
     *
     * <p>For the sake of speed, this method does no checking
     * to see if the attribute is already in the list: that is
     * the responsibility of the application.</p>
     *
     * @param uri The Namespace URI, or the empty string if
     *        none is available or Namespace processing is not
     *        being performed.
     * @param localName The local name, or the empty string if
     *        Namespace processing is not being performed.
     * @param qName The qualified (prefixed) name, or the empty string
     *        if qualified names are not available.
     * @param type The attribute type as a string.
     * @param value The attribute value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.945 -0500", hash_original_method = "BEBCC50C9D4D6D2EEDEE155B4F15D792", hash_generated_method = "0BB8E31B2DB76EE59D88CA669423161E")
    
public void addAttribute (String uri, String localName, String qName,
                  String type, String value)
    {
    ensureCapacity(length+1);
    data[length*5] = uri;
    data[length*5+1] = localName;
    data[length*5+2] = qName;
    data[length*5+3] = type;
    data[length*5+4] = value;
    length++;
    }

    /**
     * Set an attribute in the list.
     *
     * <p>For the sake of speed, this method does no checking
     * for name conflicts or well-formedness: such checks are the
     * responsibility of the application.</p>
     *
     * @param index The index of the attribute (zero-based).
     * @param uri The Namespace URI, or the empty string if
     *        none is available or Namespace processing is not
     *        being performed.
     * @param localName The local name, or the empty string if
     *        Namespace processing is not being performed.
     * @param qName The qualified name, or the empty string
     *        if qualified names are not available.
     * @param type The attribute type as a string.
     * @param value The attribute value.
     * @exception java.lang.ArrayIndexOutOfBoundsException When the
     *            supplied index does not point to an attribute
     *            in the list.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.949 -0500", hash_original_method = "FF1F65C71EB4DEEB1CAA0E424ECEBB91", hash_generated_method = "E75C58011C3AC49D1DB796D4AC6CFEF7")
    
public void setAttribute (int index, String uri, String localName,
                  String qName, String type, String value)
    {
    if (index >= 0 && index < length) {
        data[index*5] = uri;
        data[index*5+1] = localName;
        data[index*5+2] = qName;
        data[index*5+3] = type;
        data[index*5+4] = value;
    } else {
        badIndex(index);
    }
    }

    /**
     * Remove an attribute from the list.
     *
     * @param index The index of the attribute (zero-based).
     * @exception java.lang.ArrayIndexOutOfBoundsException When the
     *            supplied index does not point to an attribute
     *            in the list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.951 -0500", hash_original_method = "CCD3032C3525D921C0B3FD28370332A3", hash_generated_method = "BFC6A709237B3892C610C764284EEBC1")
    
public void removeAttribute (int index)
    {
    if (index >= 0 && index < length) {
        if (index < length - 1) {
        System.arraycopy(data, (index+1)*5, data, index*5,
                 (length-index-1)*5);
        }
        index = (length - 1) * 5;
        data [index++] = null;
        data [index++] = null;
        data [index++] = null;
        data [index++] = null;
        data [index] = null;
        length--;
    } else {
        badIndex(index);
    }
    }

    /**
     * Set the Namespace URI of a specific attribute.
     *
     * @param index The index of the attribute (zero-based).
     * @param uri The attribute's Namespace URI, or the empty
     *        string for none.
     * @exception java.lang.ArrayIndexOutOfBoundsException When the
     *            supplied index does not point to an attribute
     *            in the list.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.953 -0500", hash_original_method = "50F4EE4994BD814C254566A0C91A3159", hash_generated_method = "9E5A6592D779AEB45A0A53187A650A27")
    
public void setURI (int index, String uri)
    {
    if (index >= 0 && index < length) {
        data[index*5] = uri;
    } else {
        badIndex(index);
    }
    }

    /**
     * Set the local name of a specific attribute.
     *
     * @param index The index of the attribute (zero-based).
     * @param localName The attribute's local name, or the empty
     *        string for none.
     * @exception java.lang.ArrayIndexOutOfBoundsException When the
     *            supplied index does not point to an attribute
     *            in the list.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.956 -0500", hash_original_method = "752FFE3C27BC55D6B126D5816B29C527", hash_generated_method = "8F327B8D22B2655EB2D407571922F410")
    
public void setLocalName (int index, String localName)
    {
    if (index >= 0 && index < length) {
        data[index*5+1] = localName;
    } else {
        badIndex(index);
    }
    }

    /**
     * Set the qualified name of a specific attribute.
     *
     * @param index The index of the attribute (zero-based).
     * @param qName The attribute's qualified name, or the empty
     *        string for none.
     * @exception java.lang.ArrayIndexOutOfBoundsException When the
     *            supplied index does not point to an attribute
     *            in the list.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.958 -0500", hash_original_method = "092FB5C36230E9F885C6748AEF4243E2", hash_generated_method = "15C7BA345DCAC8559E44C9DC72DD41DC")
    
public void setQName (int index, String qName)
    {
    if (index >= 0 && index < length) {
        data[index*5+2] = qName;
    } else {
        badIndex(index);
    }
    }

    /**
     * Set the type of a specific attribute.
     *
     * @param index The index of the attribute (zero-based).
     * @param type The attribute's type.
     * @exception java.lang.ArrayIndexOutOfBoundsException When the
     *            supplied index does not point to an attribute
     *            in the list.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.960 -0500", hash_original_method = "C2C16165C0A88812FD10B2DCA3F19338", hash_generated_method = "A51849AD3FE121726F738C6D42279E30")
    
public void setType (int index, String type)
    {
    if (index >= 0 && index < length) {
        data[index*5+3] = type;
    } else {
        badIndex(index);
    }
    }

    /**
     * Set the value of a specific attribute.
     *
     * @param index The index of the attribute (zero-based).
     * @param value The attribute's value.
     * @exception java.lang.ArrayIndexOutOfBoundsException When the
     *            supplied index does not point to an attribute
     *            in the list.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.962 -0500", hash_original_method = "384311AE4C6374A489D3CC7FA620C40E", hash_generated_method = "0C574FEAF85E06C61F8C9F4F84AF928D")
    
public void setValue (int index, String value)
    {
    if (index >= 0 && index < length) {
        data[index*5+4] = value;
    } else {
        badIndex(index);
    }
    }

    ////////////////////////////////////////////////////////////////////
    // Internal methods.
    ////////////////////////////////////////////////////////////////////

    /**
     * Ensure the internal array's capacity.
     *
     * @param n The minimum number of attributes that the array must
     *        be able to hold.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.965 -0500", hash_original_method = "CB574EAE8A001C113E60067C9D40C52E", hash_generated_method = "B6378334FA72666F89F67E54A013164D")
    
private void ensureCapacity (int n)    {
        if (n <= 0) {
            return;
        }
        int max;
        if (data == null || data.length == 0) {
            max = 25;
        }
        else if (data.length >= n * 5) {
            return;
        }
        else {
            max = data.length;
        }
        while (max < n * 5) {
            max *= 2;
        }

        String newData[] = new String[max];
        if (length > 0) {
            System.arraycopy(data, 0, newData, 0, length*5);
        }
        data = newData;
    }

    /**
     * Report a bad array index in a manipulator.
     *
     * @param index The index to report.
     * @exception java.lang.ArrayIndexOutOfBoundsException Always.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:48.967 -0500", hash_original_method = "5A39796CA8340A67B1FFF4D32268D0FF", hash_generated_method = "519CB9D5598641D49CD5C6D24A5E2D01")
    
private void badIndex (int index)
    throws ArrayIndexOutOfBoundsException
    {
    String msg =
        "Attempt to modify attribute at illegal index: " + index;
    throw new ArrayIndexOutOfBoundsException(msg);
    }
    
}

