package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NameValueList implements Serializable, Cloneable, Map<String,NameValue> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.290 -0500", hash_original_field = "E662DB54D850675116FF74C4EFDD6010", hash_generated_field = "6139D38F46B665D29EA8807167945764")

    private static final long serialVersionUID = -6998271876574260243L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.292 -0500", hash_original_field = "33A3F581E0310E8499E4FC923B469370", hash_generated_field = "EB935C097CDD69EAB431C97FAA415189")

    private Map<String,NameValue> hmap;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.294 -0500", hash_original_field = "9B5B4672FF037607BB8CCE0F5B6469A8", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")

    private String separator;

    /**
     * default constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.297 -0500", hash_original_method = "E8FF7D679153D33DE114891B4F9D5A45", hash_generated_method = "9F6507F0D8B8A1423A04394E2886FDD2")
    
public NameValueList() {
        this.separator = ";";
        this.hmap = new LinkedHashMap<String,NameValue>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.300 -0500", hash_original_method = "31A624E97D000A93AA89FEF53FE9BAB4", hash_generated_method = "667C371B946EE7FC25C4E3067C1B7B9D")
    
public NameValueList(boolean sync) {
        this.separator = ";";
        if (sync)
            this.hmap = new ConcurrentHashMap<String,NameValue>();
        else
            this.hmap = new LinkedHashMap<String,NameValue>();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.303 -0500", hash_original_method = "45084252F3EC1C5D752F2E607BC4F59B", hash_generated_method = "196F7CFE846A08DE285BBE8AD535B3F4")
    
public void setSeparator(String separator) {
        this.separator = separator;
    }

    /**
     * Encode the list in semicolon separated form.
     *
     * @return an encoded string containing the objects in this list.
     * @since v1.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.305 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.308 -0500", hash_original_method = "865D14C9D79B396183E2E3DA24E39568", hash_generated_method = "C0D5D4A09C64019333891EFD40AF7E63")
    
public StringBuffer encode(StringBuffer buffer) {
        if (!hmap.isEmpty()) {
            Iterator<NameValue> iterator = hmap.values().iterator();
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.310 -0500", hash_original_method = "9121421793EC5D37F14A312213FF0274", hash_generated_method = "0E38B803B5F7EA7FC3B7A952B8C48B78")
    
public String toString() {
        return this.encode();
    }

    /**
     * Set a namevalue object in this list.
     */

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.312 -0500", hash_original_method = "541832A041A683842702BE4F440BB6F9", hash_generated_method = "E018624C230C9C31C3C518EC3B046CE5")
    
public void set(NameValue nv) {
        this.hmap.put(nv.getName().toLowerCase(), nv);
    }

    /**
     * Set a namevalue object in this list.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.316 -0500", hash_original_method = "728B9B3DC246366575180118914F1A29", hash_generated_method = "31E831B42D3270F4C7FA1F12417970BF")
    
public void set(String name, Object value) {
        NameValue nameValue = new NameValue(name, value);
        hmap.put(name.toLowerCase(), nameValue);

    }

    /**
     * Compare if two NameValue lists are equal.
     *
     * @param otherObject
     *            is the object to compare to.
     * @return true if the two objects compare for equality.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.318 -0500", hash_original_method = "91A5AF22400C8AC862CBF8DA0CDC612B", hash_generated_method = "44538EA0BBD7886C3EDF088C05158874")
    
public boolean equals(Object otherObject) {
        if ( otherObject == null ) {
            return false;
        }
        if (!otherObject.getClass().equals(this.getClass())) {
            return false;
        }
        NameValueList other = (NameValueList) otherObject;

        if (hmap.size() != other.hmap.size()) {
            return false;
        }
        Iterator<String> li = this.hmap.keySet().iterator();

        while (li.hasNext()) {
            String key = (String) li.next();
            NameValue nv1 = this.getNameValue(key);
            NameValue nv2 = (NameValue) other.hmap.get(key);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.321 -0500", hash_original_method = "DE074F80660571F2D9A0EA59E951198A", hash_generated_method = "6A6C1DBE91B9E3540B369E66CE2E9391")
    
public Object getValue(String name) {
        NameValue nv = this.getNameValue(name.toLowerCase());
        if (nv != null)
            return nv.getValueAsObject();
        else
            return null;
    }

    /**
     * Get the NameValue record given a name.
     *
     * @since 1.0
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.323 -0500", hash_original_method = "5A90B099A8628E34F647DE9E37BC52D0", hash_generated_method = "FBA1238742EC29980D23943F7A0488BE")
    
public NameValue getNameValue(String name) {
        return (NameValue) this.hmap.get(name.toLowerCase());
    }

    /**
     * Returns a boolean telling if this NameValueList has a record with this
     * name
     *
     * @since 1.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.326 -0500", hash_original_method = "DB40CF4190456B2BE2224926B4D8156A", hash_generated_method = "7240BE9063BFF72D528C947ED57FEB0C")
    
public boolean hasNameValue(String name) {
        return hmap.containsKey(name.toLowerCase());
    }

    /**
     * Remove the element corresponding to this name.
     *
     * @since 1.0
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.328 -0500", hash_original_method = "91B0980C21C7F267937CEFAA60D652AB", hash_generated_method = "586111467C9DB306D8F6FAE813537546")
    
public boolean delete(String name) {
        String lcName = name.toLowerCase();
        if (this.hmap.containsKey(lcName)) {
            this.hmap.remove(lcName);
            return true;
        } else {
            return false;
        }

    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.331 -0500", hash_original_method = "6F9503A91BCD71FF680044D2BE3EB547", hash_generated_method = "887FADD658740F0C4FD3468B7649A4E6")
    
public Object clone() {
        NameValueList retval = new NameValueList();
        retval.setSeparator(this.separator);
        Iterator<NameValue> it = this.hmap.values().iterator();
        while (it.hasNext()) {
            retval.set((NameValue) ((NameValue) it.next()).clone());
        }
        return retval;
    }

    /**
     * Return the size of the embedded map
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.333 -0500", hash_original_method = "3E6F4B689378892245F121C3B2A70863", hash_generated_method = "C0F5598F3E4906D55CD1CB185842DAEC")
    
public int size() {
        return this.hmap.size();
    }

    /**
     * Return true if empty.
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.335 -0500", hash_original_method = "9CD772E1CB5E6BE1ED1982B78A84FA1B", hash_generated_method = "D9D23F1D55E63A0D788DDC2FCF9B1A62")
    
public boolean isEmpty() {
        return hmap.isEmpty();
    }

    /**
     * Return an iterator for the name-value pairs of this list.
     *
     * @return the iterator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.337 -0500", hash_original_method = "F37BBAD929816040B3EA007E6DF28502", hash_generated_method = "018C0671FAE463264117FE764EEADF62")
    
public Iterator<NameValue> iterator() {
        return this.hmap.values().iterator();
    }

    /**
     * Get a list of parameter names.
     *
     * @return a list iterator that has the names of the parameters.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.340 -0500", hash_original_method = "7A59F5DB1186413E79C951C76908BFDC", hash_generated_method = "592B62A6A46FF1A6CFD16C9BE8F1C302")
    
public Iterator<String> getNames() {
        return this.hmap.keySet().iterator();

    }

    /**
     * Get the parameter as a String.
     *
     * @return the parameter as a string.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.343 -0500", hash_original_method = "6D3851F46197204C176DAB6DC4EAB5DB", hash_generated_method = "228EAA2490CB2DA9DF62B4CB85A003A6")
    
public String getParameter(String name) {
        Object val = this.getValue(name);
        if (val == null)
            return null;
        if (val instanceof GenericObject)
            return ((GenericObject) val).encode();
        else
            return val.toString();
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map#clear()
     */

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.345 -0500", hash_original_method = "980179408BF501109227F08D5C9216B1", hash_generated_method = "0E94DD7300D59086C659C2DDAF9230FD")
    
public void clear() {
        this.hmap.clear();
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.347 -0500", hash_original_method = "2E0F75BA6AFD5C18A55AE3B632F0C375", hash_generated_method = "56F55413D46777830F29E7896EC73DA0")
    
public boolean containsKey(Object key) {
        return this.hmap.containsKey(key.toString().toLowerCase());
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map#containsValue(java.lang.Object)
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.349 -0500", hash_original_method = "A6EA0419C0087EA83C0DBCC271DA2735", hash_generated_method = "124EE3C317AA2BDE46A94891A435F5ED")
    
public boolean containsValue(Object value) {
        return this.hmap.containsValue(value);
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map#entrySet()
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.352 -0500", hash_original_method = "B4FF19B42F00873A6D908667D4FF7E33", hash_generated_method = "D1D2EA4E41BAEEC9803E17D3381364B3")
    
public Set<java.util.Map.Entry<String, NameValue>> entrySet() {
        return this.hmap.entrySet();
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map#get(java.lang.Object)
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.355 -0500", hash_original_method = "EA67EE9A45F5352AADEB9693E72F1050", hash_generated_method = "C5651D9A2CDBEA25F713AF6A1C5B7D9D")
    
public NameValue get(Object key) {
        return this.hmap.get(key.toString().toLowerCase());
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map#keySet()
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.357 -0500", hash_original_method = "EB227B4CB4A434E80044A70A11CCF2F7", hash_generated_method = "F0055EFB425011AF71DCBB79FB5C758F")
    
public Set<String> keySet() {
        return this.hmap.keySet();
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.360 -0500", hash_original_method = "35750F73219F56C1FC4F989AFDC72835", hash_generated_method = "347D6641225127CA586CA01208C62349")
    
public NameValue put(String name, NameValue nameValue) {
        return this.hmap.put(name, nameValue);
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.362 -0500", hash_original_method = "E36B216223163EA26215959E10A918CA", hash_generated_method = "7775F0474CFBAE4163E2FBBD14B14F7F")
    
public void putAll(Map<? extends String, ? extends NameValue> map) {
        this.hmap.putAll(map);
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map#remove(java.lang.Object)
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.364 -0500", hash_original_method = "790110009BF426B36394178253C0659C", hash_generated_method = "3ECFCE028BE9B366085522A857FB2584")
    
public NameValue remove(Object key) {
        return this.hmap.remove(key.toString().toLowerCase());
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map#values()
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.367 -0500", hash_original_method = "979875D580378EC87CDE1564DB1000BC", hash_generated_method = "A3DCECA6A540F9E6D53A6815630DA6D6")
    
public Collection<NameValue> values() {
        return this.hmap.values();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:49.369 -0500", hash_original_method = "2A0022C30F51CA39DC1594F13A7B2530", hash_generated_method = "FC7DE45E769CE0527ED071C4CF2B1B62")
    
@Override
    public int hashCode() {
        return this.hmap.keySet().hashCode();
    }
}

