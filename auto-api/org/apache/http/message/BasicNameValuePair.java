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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.233 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.239 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.252 -0400", hash_original_method = "9B16B3F0FD8B0C655E61EA7019E7F0C5", hash_generated_method = "E48C6861298E8FB66DFAFDD51480F8B0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.253 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "8674F08BE5CC006689BC590C5534F997")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_556313947 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_556313947 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_556313947.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_556313947;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.254 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "51B518EFFF47A0E10C7DF7EB946069AA")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_937684861 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_937684861 = this.value;
        varB4EAC82CA7396A68D541C85D26508E83_937684861.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_937684861;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.254 -0400", hash_original_method = "93FF9F6BC44FD78A86FF56612368CE29", hash_generated_method = "570E4FDF627DA92B5B954CC7B0FF1C4E")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_269680955 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_269680955 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_269680955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_269680955;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.256 -0400", hash_original_method = "3849D74FE9AE53A80E5FA00389489FFC", hash_generated_method = "60B4FBA2DA91580310ED919EB7C3F6FE")
    public boolean equals(final Object object) {
        {
            BasicNameValuePair that;
            that = (BasicNameValuePair) object;
            boolean var12460EC170C55F6123FCD61C93037C8D_1318523216 = (this.name.equals(that.name)
                  && LangUtils.equals(this.value, that.value));
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1886914788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1886914788;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.257 -0400", hash_original_method = "A586BF0615CE91E5DB31F98DF42747A4", hash_generated_method = "DC5E6F7E22901BCBD4AFDFC05BD8F550")
    public int hashCode() {
        int hash;
        hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079433431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079433431;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.value);
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.258 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "0AA37B48137E61A7F27F3D93D555A5A9")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1324457120 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1324457120 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1324457120.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1324457120;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

