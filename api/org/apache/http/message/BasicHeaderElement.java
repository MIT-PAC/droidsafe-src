package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;






public class BasicHeaderElement implements HeaderElement, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.399 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")


    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.401 -0500", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private  String value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.404 -0500", hash_original_field = "35BBBB8A5769EB05E114740F81CC75E0", hash_generated_field = "3C3A5449D27C0E3F0EFEC4E0CCB17416")

    private  NameValuePair[] parameters;

    /**
     * Constructor with name, value and parameters.
     *
     * @param name header element name
     * @param value header element value. May be <tt>null</tt>
     * @param parameters header element parameters. May be <tt>null</tt>.
     *   Parameters are copied by reference, not by value
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.408 -0500", hash_original_method = "84DDDE558F062A2A9F901E85C44DEB99", hash_generated_method = "8E79D46080EB308C3D2FCB126F51CB86")
    
public BasicHeaderElement(
            final String name, 
            final String value,
            final NameValuePair[] parameters) {
        super();
        if (name == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.name = name;
        this.value = value;
        if (parameters != null) {
            this.parameters = parameters;
        } else {
            this.parameters = new NameValuePair[] {};
        }
    }

    /**
     * Constructor with name and value.
     * 
     * @param name header element name
     * @param value header element value. May be <tt>null</tt>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.411 -0500", hash_original_method = "F40B924328FFEB3DAF8466EC412BA557", hash_generated_method = "61C05DD60BF2F557F681130A321A4CE4")
    
public BasicHeaderElement(final String name, final String value) {
       this(name, value, null);
    }

    /**
     * Returns the name.
     *
     * @return String name The name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.413 -0500", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "10AFD575EA26BE807F18801FAC02C531")
    
public String getName() {
        return this.name;
    }

    /**
     * Returns the value.
     *
     * @return String value The current value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.416 -0500", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "FC2353DBE9194DE53203DA3AB851288B")
    
public String getValue() {
        return this.value;
    }

    /**
     * Get parameters, if any.
     * The returned array is created for each invocation and can
     * be modified by the caller without affecting this header element.
     *
     * @return parameters as an array of {@link NameValuePair}s
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.418 -0500", hash_original_method = "3731305FA78433D69AC55713BB946E12", hash_generated_method = "B7C67BDA96821C2F9B3F0B75E1343D18")
    
public NameValuePair[] getParameters() {
        return (NameValuePair[])this.parameters.clone();
    }


    /**
     * Obtains the number of parameters.
     *
     * @return  the number of parameters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.420 -0500", hash_original_method = "D96148994A6BB50642F5897F1E874B9E", hash_generated_method = "B00651AC76B47D2ADD963896D88D7747")
    
public int getParameterCount() {
        return this.parameters.length;
    }


    /**
     * Obtains the parameter with the given index.
     *
     * @param index     the index of the parameter, 0-based
     *
     * @return  the parameter with the given index
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.423 -0500", hash_original_method = "7A51C396EF547B19A00C38AEE513A356", hash_generated_method = "B0BDC4F089A0CD13C111C927BE2F26EB")
    
public NameValuePair getParameter(int index) {
        // ArrayIndexOutOfBoundsException is appropriate
        return this.parameters[index];
    }


    /**
     * Returns parameter with the given name, if found. Otherwise null 
     * is returned
     *
     * @param name The name to search by.
     * @return NameValuePair parameter with the given name
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.425 -0500", hash_original_method = "EB48045459F47CF0118B0835F7086CA0", hash_generated_method = "192A0E34C343ABEABB4035A4CAF21211")
    
public NameValuePair getParameterByName(final String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name may not be null");
        } 
        NameValuePair found = null;
        for (int i = 0; i < this.parameters.length; i++) {
            NameValuePair current = this.parameters[ i ];
            if (current.getName().equalsIgnoreCase(name)) {
                found = current;
                break;
            }
        }
        return found;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.428 -0500", hash_original_method = "84D34B9B0982E4EBAA99AAAC5467288A", hash_generated_method = "28F87E9F6913D4B62CAF358B96D04F06")
    
public boolean equals(final Object object) {
        if (object == null) return false;
        if (this == object) return true;
        if (object instanceof HeaderElement) {
            BasicHeaderElement that = (BasicHeaderElement) object;
            return this.name.equals(that.name)
                && LangUtils.equals(this.value, that.value)
                && LangUtils.equals(this.parameters, that.parameters);
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.430 -0500", hash_original_method = "4C03DB3D3629EDBB8E252CDFFA259653", hash_generated_method = "0AC79E97C45F371739F4D81F67CF5148")
    
public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        for (int i = 0; i < this.parameters.length; i++) {
            hash = LangUtils.hashCode(hash, this.parameters[i]);
        }
        return hash;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.433 -0500", hash_original_method = "D1269B43C4D02DE243B0BC051FD8549B", hash_generated_method = "DE1F58D21F632AE1F47CA9F620164127")
    
public String toString() {
        CharArrayBuffer buffer = new CharArrayBuffer(64);
        buffer.append(this.name);
        if (this.value != null) {
            buffer.append("=");
            buffer.append(this.value);
        }
        for (int i = 0; i < this.parameters.length; i++) {
            buffer.append("; ");
            buffer.append(this.parameters[i]);
        }
        return buffer.toString();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.437 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "CAEEFC6B38E6AA38254BCB526D971A1D")
    
public Object clone() throws CloneNotSupportedException {
        // parameters array is considered immutable
        // no need to make a copy of it
        return super.clone();
    }

    
}

