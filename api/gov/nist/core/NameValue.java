package gov.nist.core;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Map.Entry;






public class NameValue extends GenericObject implements Entry<String,String> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.393 -0500", hash_original_field = "CAC38838BA3887D6B16433765E3B8569", hash_generated_field = "01B78AA1575EDF3A89DB226DD6F71B77")


    private static final long serialVersionUID = -1857729012596437950L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.396 -0500", hash_original_field = "E8ECD1D17AE0A3DC80CCB39F53B1EE67", hash_generated_field = "03D21DED07B953DE189DA542ACCA4795")


    protected boolean isQuotedString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.398 -0500", hash_original_field = "F1443A6ABB9C123E20A8F3EE0D2B0167", hash_generated_field = "2074D0C8EACF17C06B998CAD345872CC")


    protected  boolean isFlagParameter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.401 -0500", hash_original_field = "9B5B4672FF037607BB8CCE0F5B6469A8", hash_generated_field = "A55DB8D30D61AD070DC11E077713D1B8")


    private String separator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.404 -0500", hash_original_field = "C468095960E8072B81063B29315D2A91", hash_generated_field = "2D87AB9C19BCCC29C070C92F351ED60D")


    private String quotes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.407 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")


    private String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.409 -0500", hash_original_field = "01495BEB834F5098BB0B06183674C819", hash_generated_field = "D3245881F91753AD0C508E1E9B72D31F")


    private Object value;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.412 -0500", hash_original_method = "673B7BD3BE99F15EF906052B0E031E5B", hash_generated_method = "2AA7E6D7779ECFDD44134F2929B41A1F")
    
public NameValue() {
        name = null;
        value = "";
        separator = Separators.EQUALS;
        this.quotes = "";
        this.isFlagParameter = false;
    }

    /**
     * New constructor, taking a boolean which is set if the NV pair is a flag
     *
     * @param n
     * @param v
     * @param isFlag
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.415 -0500", hash_original_method = "02C18CFA06711D9F4F613D5380036A37", hash_generated_method = "A3DD5C6ECDEBB3827C4D94F43710A800")
    
public NameValue(String n, Object v, boolean isFlag) {

        // assert (v != null ); // I dont think this assertion is correct mranga

        name = n;
        value = v;
        separator = Separators.EQUALS;
        quotes = "";
        this.isFlagParameter = isFlag;
    }

    /**
     * Original constructor, sets isFlagParameter to 'false'
     *
     * @param n
     * @param v
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.417 -0500", hash_original_method = "2B84565E65A85C087167BA7C90B69F9F", hash_generated_method = "8047CB080BB50F06E299CFCF6155FBD8")
    
public NameValue(String n, Object v) {
        this(n, v, false);
    }

    /**
     * Set the separator for the encoding method below.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.420 -0500", hash_original_method = "8B5A99905EE1811A879B3378EE7C88B1", hash_generated_method = "D87967DCDD8E0E00119098F0EC7FFAEC")
    
public void setSeparator(String sep) {
        separator = sep;
    }

    /**
     * A flag that indicates that doublequotes should be put around the value
     * when encoded (for example name=value when value is doublequoted).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.423 -0500", hash_original_method = "095AA0DB24FB99A12A6684BCE39B9F89", hash_generated_method = "6DAC0D21DCE3F19CCF169449C1773417")
    
public void setQuotedValue() {
        isQuotedString = true;
        this.quotes = Separators.DOUBLE_QUOTE;
    }

    /**
     * Return true if the value is quoted in doublequotes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.425 -0500", hash_original_method = "D2172C6C42893F443ABBD625D7655BA2", hash_generated_method = "FEE5FD6D1B8791B9F0B8835BB9FB17DF")
    
public boolean isValueQuoted() {
        return isQuotedString;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.427 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "50860709F8CC9FE19B604881E59FBA54")
    
public String getName() {
        return name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.430 -0500", hash_original_method = "1D746EB97F79FD095C35B4AB5FADFB51", hash_generated_method = "B600D4AE03E87C6917A0B4A190B9AC7D")
    
public Object getValueAsObject() {
        return isFlagParameter ? "" : value; // never return null for flag
                                                // params
    }

    /**
     * Set the name member
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.432 -0500", hash_original_method = "48E6CC9DD98BCA4A1A1FF2D370B346E5", hash_generated_method = "E808473C30679389E9B32D5F5E25435F")
    
public void setName(String n) {
        name = n;
    }

    /**
     * Set the value member
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.435 -0500", hash_original_method = "976564EFAA66565638B090B0BED90464", hash_generated_method = "564D0D6D0ACCD7870FA31EB4B032EFC8")
    
public void setValueAsObject(Object v) {
        value = v;
    }

    /**
     * Get the encoded representation of this namevalue object. Added
     * doublequote for encoding doublequoted values.
     *
     * Bug: RFC3261 stipulates that an opaque parameter in authenticate header
     * has to be:
     * opaque              =  "opaque" EQUAL quoted-string
     * so returning just the name is not acceptable. (e.g. LinkSys phones
     * are picky about this)
     *
     * @since 1.0
     * @return an encoded name value (eg. name=value) string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.437 -0500", hash_original_method = "A36333A6F745F23182438BFF478F971C", hash_generated_method = "3E83C3693072E036EE6283AD07E42258")
    
public String encode() {
        return encode(new StringBuffer()).toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.441 -0500", hash_original_method = "8C352692671CA7B4091AFB32E24F1EAA", hash_generated_method = "0F35815E9A673B84EF81B683C2DFFC0B")
    
public StringBuffer encode(StringBuffer buffer) {
        if (name != null && value != null && !isFlagParameter) {
            if (GenericObject.isMySubclass(value.getClass())) {
                GenericObject gv = (GenericObject) value;
                buffer.append(name).append(separator).append(quotes);
                gv.encode(buffer);
                buffer.append(quotes);
                return buffer;
            } else if (GenericObjectList.isMySubclass(value.getClass())) {
                GenericObjectList gvlist = (GenericObjectList) value;
                buffer.append(name).append(separator).append(gvlist.encode());
                return buffer;
            } else if ( value.toString().length() == 0) {
                // opaque="" bug fix - pmusgrave
                /*if (name.toString().equals(gov.nist.javax.sip.header.ParameterNames.OPAQUE))
                    return name + separator + quotes + quotes;
                else
                    return name;*/
                if ( this.isQuotedString ) {
                    buffer.append(name).append(separator).append(quotes).append(quotes);
                    return buffer;
                } else {
                    buffer.append(name).append(separator); // JvB: fix, case: "sip:host?subject="
                    return buffer;
                }
            } else {
                buffer.append(name).append(separator).append(quotes).append(value.toString()).append(quotes);
                return buffer;
            }
        } else if (name == null && value != null) {
            if (GenericObject.isMySubclass(value.getClass())) {
                GenericObject gv = (GenericObject) value;
                gv.encode(buffer);
                return buffer;
            } else if (GenericObjectList.isMySubclass(value.getClass())) {
                GenericObjectList gvlist = (GenericObjectList) value;
                buffer.append(gvlist.encode());
                return buffer;
            } else {
                buffer.append(quotes).append(value.toString()).append(quotes);
                return buffer;
            }
        } else if (name != null && (value == null || isFlagParameter)) {
            buffer.append(name);
            return buffer;
        } else {
            return buffer;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.443 -0500", hash_original_method = "AFA5C2A13F94EAF8D89E1398D2146232", hash_generated_method = "74A093710988F4AB9BF3E75FF3694D54")
    
public Object clone() {
        NameValue retval = (NameValue) super.clone();
        if (value != null)
            retval.value = makeClone(value);
        return retval;
    }

    /**
     * Equality comparison predicate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.446 -0500", hash_original_method = "C7D1B39DFE3B0192F0BEF83FC7C40106", hash_generated_method = "7A1651F101C7D29ABD74AA763DDBF0F7")
    
public boolean equals(Object other) {
        if (other == null ) return false;
        if (!other.getClass().equals(this.getClass()))
            return false;
        NameValue that = (NameValue) other;
        if (this == that)
            return true;
        if (this.name == null && that.name != null || this.name != null
                && that.name == null)
            return false;
        if (this.name != null && that.name != null
                && this.name.compareToIgnoreCase(that.name) != 0)
            return false;
        if (this.value != null && that.value == null || this.value == null
                && that.value != null)
            return false;
        if (this.value == that.value)
            return true;
        if (value instanceof String) {
            // Quoted string comparisions are case sensitive.
            if (isQuotedString)
                return this.value.equals(that.value);
            String val = (String) this.value;
            String val1 = (String) that.value;
            return val.compareToIgnoreCase(val1) == 0;
        } else
            return this.value.equals(that.value);
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map$Entry#getKey()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.448 -0500", hash_original_method = "2F0EB2DB361DE1F8D28986094D857BA0", hash_generated_method = "97999F76D4943E2177ECAA7D863A4AE0")
    
public String getKey() {

        return this.name;
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map$Entry#getValue()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.452 -0500", hash_original_method = "4618674F7CF871F15A32C0791ACD2466", hash_generated_method = "1934EA858DA05DEBA4327E847B52AB3D")
    
public String getValue() {

        return  value == null ? null : this.value.toString();
    }

    /*
     * (non-Javadoc)
     * @see java.util.Map$Entry#setValue(java.lang.Object)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.454 -0500", hash_original_method = "34CFBA77959CE5FB40B94FB25C9241AB", hash_generated_method = "66829753DDE2A772799FECB5E5C062CE")
    
public String setValue(String value) {
        String retval = this.value == null ? null : value;
        this.value = value;
        return retval;

    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:53.457 -0500", hash_original_method = "65B8B320E0D14FEF2FD57F3B89A2B17F", hash_generated_method = "A26E595A12BE7FA15D688FE7DB1E8704")
    
@Override
    public int hashCode() {
        return this.encode().toLowerCase().hashCode();
    }
}

