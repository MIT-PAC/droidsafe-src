package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

public class DuplicateNameValueList implements Serializable, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.633 -0500", hash_original_field = "46A2E2709A942C98D11003053AA89B2B", hash_generated_field = "549B3ABEAD7830A28E925E7D8255A93A")

    private static final long serialVersionUID = -5611332957903796952L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.628 -0500", hash_original_field = "16956788616DBA937E1AD74D5F19F2F8", hash_generated_field = "6BB90EA38890EB2F7E772ABE1764102D")

    private MultiValueMapImpl<NameValue> nameValueMap = new MultiValueMapImpl<NameValue>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.630 -0500", hash_original_field = "9B5B4672FF037607BB8CCE0F5B6469A8", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.635 -0500", hash_original_method = "20742916A9CB1D797182F33AF39D95AA", hash_generated_method = "D06C3D0FE64A73CD5E2FF1308498E4CC")
    
public DuplicateNameValueList()

    {
        this.separator = ";";
    }

    // ------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.637 -0500", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "196F7CFE846A08DE285BBE8AD535B3F4")
    
public void setSeparator(String separator) {
        this.separator = separator;
    }

    /**
     * Encode the list in semicolon separated form.
     * 
     * @return an encoded string containing the objects in this list.
     * @since v1.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.639 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.643 -0500", hash_original_method = "D3346716394F96A19B31E823716035B3", hash_generated_method = "C33AE938D80558B25613DF3E7D1BE994")
    
public StringBuffer encode(StringBuffer buffer) {
        if (!nameValueMap.isEmpty()) {
            Iterator<NameValue> iterator = nameValueMap.values().iterator();
            if (iterator.hasNext()) {
                while (true) {
                    Object obj = iterator.next();
                    if (obj instanceof GenericObject) {
                        GenericObject gobj = (GenericObject) obj;
                        gobj.encode(buffer);
                    } else {
                        buffer.append(obj.toString());
                    }
                    if (iterator.hasNext())
                        buffer.append(separator);
                    else
                        break;
                }
            }
        }
        return buffer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.645 -0500", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "0E38B803B5F7EA7FC3B7A952B8C48B78")
    
public String toString() {
        return this.encode();
    }

    /**
     * Set a namevalue object in this list.
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.648 -0500", hash_original_method = "D5C6BB3BFBC83A4D51FBDE2E52B7ACF4", hash_generated_method = "4616BD6EAB14C5A645541D670FFD9E5D")
    
public void set(NameValue nv) {
        this.nameValueMap.put(nv.getName().toLowerCase(), nv);
    }

    /**
     * Set a namevalue object in this list.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.650 -0500", hash_original_method = "89FDC30721EFC0C6F270B8D9CF8001D0", hash_generated_method = "4F9B5F897615227E6655D9686BDA5DAE")
    
public void set(String name, Object value) {
        NameValue nameValue = new NameValue(name, value);
        nameValueMap.put(name.toLowerCase(), nameValue);

    }

    /**
     * Compare if two NameValue lists are equal.
     * 
     * @param otherObject is the object to compare to.
     * @return true if the two objects compare for equality.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.653 -0500", hash_original_method = "E566E8F19B44FC1FECCBFF06B810AB67", hash_generated_method = "C7B448223FE99A38ED9326670A6E96CB")
    
public boolean equals(Object otherObject) {
        if ( otherObject == null ) {
            return false;
        }
        if (!otherObject.getClass().equals(this.getClass())) {
            return false;
        }
        DuplicateNameValueList other = (DuplicateNameValueList) otherObject;

        if (nameValueMap.size() != other.nameValueMap.size()) {
            return false;
        }
        Iterator<String> li = this.nameValueMap.keySet().iterator();

        while (li.hasNext()) {
            String key = (String) li.next();
            Collection nv1 = this.getNameValue(key);
            Collection nv2 = (Collection) other.nameValueMap.get(key);
            if (nv2 == null)
                return false;
            else if (!nv2.equals(nv1))
                return false;
        }
        return true;
    }

    /**
     * Do a lookup on a given name and return value associated with it.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.655 -0500", hash_original_method = "C612873C096C9BEC2FEAD8B66B09FEED", hash_generated_method = "223CA02349F8A25B55FE556718350AB1")
    
public Object getValue(String name) {
        Collection nv = this.getNameValue(name.toLowerCase());
        if (nv != null)
            return nv;
        else
            return null;
    }

    /**
     * Get the NameValue record given a name.
     * 
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.657 -0500", hash_original_method = "3B6BB1718C2A9A54E5BA1FF364B56717", hash_generated_method = "F8A7E8C27E8294879A92DC08BC132470")
    
public Collection getNameValue(String name) {
        return (Collection) this.nameValueMap.get(name.toLowerCase());
    }

    /**
     * Returns a boolean telling if this NameValueList has a record with this name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.660 -0500", hash_original_method = "D5BB760FEF0605F784761761BB05E75A", hash_generated_method = "4064B20AE2DE04130AA512E7DA78EE34")
    
public boolean hasNameValue(String name) {
        return nameValueMap.containsKey(name.toLowerCase());
    }

    /**
     * Remove the element corresponding to this name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.662 -0500", hash_original_method = "DB3F0BFFB6CE4D49FE300461E52C77CC", hash_generated_method = "76B4CF795CAB6C13327720CABE59DD7D")
    
public boolean delete(String name) {
        String lcName = name.toLowerCase();
        if (this.nameValueMap.containsKey(lcName)) {
            this.nameValueMap.remove(lcName);
            return true;
        } else {
            return false;
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.665 -0500", hash_original_method = "19FF4230E4AD609C94D0ED393241A96C", hash_generated_method = "9FC0EEB7F84FC96960E4FC8965822DE9")
    
public Object clone() {
        DuplicateNameValueList retval = new DuplicateNameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it = this.nameValueMap.values().iterator();
        while (it.hasNext()) {
            retval.set((NameValue) ((NameValue) it.next()).clone());
        }
        return retval;
    }

    /**
     * Return an iterator for the name-value pairs of this list.
     * 
     * @return the iterator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.667 -0500", hash_original_method = "FD05C240A769227CDB628211DF5EC32E", hash_generated_method = "AF8A42319601A3FBBF15621EE9C6404D")
    
public Iterator<NameValue> iterator() {
        return this.nameValueMap.values().iterator();
    }

    /**
     * Get a list of parameter names.
     * 
     * @return a list iterator that has the names of the parameters.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.670 -0500", hash_original_method = "3A38488A38C81B5FE756BBBB95D22DE2", hash_generated_method = "E900327DA2454F6D418A61E12EDA9F00")
    
public Iterator<String> getNames() {
        return this.nameValueMap.keySet().iterator();

    }

    /**
     * Get the parameter as a String.
     * 
     * @return the parameter as a string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.673 -0500", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "228EAA2490CB2DA9DF62B4CB85A003A6")
    
public String getParameter(String name) {
        Object val = this.getValue(name);
        if (val == null)
            return null;
        if (val instanceof GenericObject)
            return ((GenericObject) val).encode();
        else
            return val.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.675 -0500", hash_original_method = "B40C6D0DEDA13F85BB68C572A20E397F", hash_generated_method = "6F4E1FA06F40A5A4B54946F3B1488ECB")
    
public void clear() {
        nameValueMap.clear();

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.677 -0500", hash_original_method = "A87A9771E4444067F01FCF3F6D8B907E", hash_generated_method = "DC3DD5421143DF7DAFED7ECD2E0C667E")
    
public boolean isEmpty() {
        return this.nameValueMap.isEmpty();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.680 -0500", hash_original_method = "3AC71B082E8AAC37EBD928C6A35A39AB", hash_generated_method = "CDA6E93D91E253B2EA4DB5B2498A2FF9")
    
public NameValue put(String key, NameValue value) {
        return (NameValue) this.nameValueMap.put(key, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.682 -0500", hash_original_method = "1975EE5F7D7766619160CC0D9D0851BB", hash_generated_method = "A095622913320C18C966511897D80080")
    
public NameValue remove(Object key) {
        return (NameValue) this.nameValueMap.remove(key);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.684 -0500", hash_original_method = "7BBCC8968D761DFCA7152F0BE4E82809", hash_generated_method = "11F035856B10FAD1BE255BC420368661")
    
public int size() {
        return this.nameValueMap.size();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.687 -0500", hash_original_method = "F30302CB3EB3055DF74F33593B8201EA", hash_generated_method = "15FFD92BA29CA0CD3500E6E3E834EFE8")
    
public Collection<NameValue> values() {
        return this.nameValueMap.values();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.689 -0500", hash_original_method = "4C24AE5D2C44E17C467B047C84E46484", hash_generated_method = "D65E3551648B92C066D2EC2E5808A452")
    
public int hashCode() {
        return this.nameValueMap.keySet().hashCode();
    }
}

