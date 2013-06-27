package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public class BasicNameValuePair implements NameValuePair, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.034 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.034 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.035 -0400", hash_original_method = "9B16B3F0FD8B0C655E61EA7019E7F0C5", hash_generated_method = "E48C6861298E8FB66DFAFDD51480F8B0")
    public  BasicNameValuePair(final String name, final String value) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        this.name = name;
        this.value = value;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name may not be null");
        //}
        //this.name = name;
        //this.value = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.035 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "429C211535F4097C79CF49ECD0F83A1E")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1621661562 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1621661562 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_1621661562.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1621661562;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.036 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "80520DBA22171C41068DD225C95DD2EF")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_482404650 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_482404650 = this.value;
        varB4EAC82CA7396A68D541C85D26508E83_482404650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_482404650;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.052 -0400", hash_original_method = "93FF9F6BC44FD78A86FF56612368CE29", hash_generated_method = "53129E9D0ED8597D6ED155BEDEA39EFD")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_480151519 = null; //Variable for return #1
        int len;
        len = this.name.length();
        len += 1 + this.value.length();
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(len);
        buffer.append(this.name);
        {
            buffer.append("=");
            buffer.append(this.value);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_480151519 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_480151519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_480151519;
        // ---------- Original Method ----------
        //int len = this.name.length();
        //if (this.value != null)
            //len += 1 + this.value.length();
        //CharArrayBuffer buffer = new CharArrayBuffer(len);
        //buffer.append(this.name);
        //if (this.value != null) {
            //buffer.append("=");
            //buffer.append(this.value);
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.052 -0400", hash_original_method = "3849D74FE9AE53A80E5FA00389489FFC", hash_generated_method = "D24A02B19B68D078BBCAB082FAA77CE1")
    public boolean equals(final Object object) {
        {
            BasicNameValuePair that;
            that = (BasicNameValuePair) object;
            boolean var12460EC170C55F6123FCD61C93037C8D_1293138516 = (this.name.equals(that.name)
                  && LangUtils.equals(this.value, that.value));
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740847492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740847492;
        // ---------- Original Method ----------
        //if (object == null) return false;
        //if (this == object) return true;
        //if (object instanceof NameValuePair) {
            //BasicNameValuePair that = (BasicNameValuePair) object;
            //return this.name.equals(that.name)
                  //&& LangUtils.equals(this.value, that.value);
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.053 -0400", hash_original_method = "A586BF0615CE91E5DB31F98DF42747A4", hash_generated_method = "BBFEEEFCA7C2459864E90A792F5E0EAF")
    public int hashCode() {
        int hash;
        hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068514692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2068514692;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.value);
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.054 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "05737FC65C0940D7135700FFA1B918BC")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1827319269 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1827319269 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1827319269.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1827319269;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

