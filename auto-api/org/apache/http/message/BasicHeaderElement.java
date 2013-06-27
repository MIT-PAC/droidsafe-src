package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public class BasicHeaderElement implements HeaderElement, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.910 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.910 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.910 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "3C3A5449D27C0E3F0EFEC4E0CCB17416")

    private NameValuePair[] parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.911 -0400", hash_original_method = "84DDDE558F062A2A9F901E85C44DEB99", hash_generated_method = "1B1C4CA419E7F536B2D3E7A767506957")
    public  BasicHeaderElement(
            final String name, 
            final String value,
            final NameValuePair[] parameters) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        this.name = name;
        this.value = value;
        {
            this.parameters = parameters;
        } //End block
        {
            this.parameters = new NameValuePair[] {};
        } //End block
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name may not be null");
        //}
        //this.name = name;
        //this.value = value;
        //if (parameters != null) {
            //this.parameters = parameters;
        //} else {
            //this.parameters = new NameValuePair[] {};
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.911 -0400", hash_original_method = "F40B924328FFEB3DAF8466EC412BA557", hash_generated_method = "9AE15BC4C24958C2D2383363AE148836")
    public  BasicHeaderElement(final String name, final String value) {
        this(name, value, null);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.912 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "48FAE5A908DD09CFF169D708E00C60CF")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_74236006 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_74236006 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_74236006.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_74236006;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.912 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "0CA0F8D641712BF335A0DAB0CDE44FCA")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_1861726173 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1861726173 = this.value;
        varB4EAC82CA7396A68D541C85D26508E83_1861726173.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1861726173;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.912 -0400", hash_original_method = "3731305FA78433D69AC55713BB946E12", hash_generated_method = "B0E83F6A28B798FD8004B95F1FE862B9")
    public NameValuePair[] getParameters() {
        NameValuePair[] varB4EAC82CA7396A68D541C85D26508E83_1484293678 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1484293678 = (NameValuePair[])this.parameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1484293678.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1484293678;
        // ---------- Original Method ----------
        //return (NameValuePair[])this.parameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.913 -0400", hash_original_method = "D96148994A6BB50642F5897F1E874B9E", hash_generated_method = "58E66C82E4E928CD54243B4A994F8987")
    public int getParameterCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_893902061 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_893902061;
        // ---------- Original Method ----------
        //return this.parameters.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.913 -0400", hash_original_method = "7A51C396EF547B19A00C38AEE513A356", hash_generated_method = "D108D2315ADFB2FA499B35A28977E971")
    public NameValuePair getParameter(int index) {
        NameValuePair varB4EAC82CA7396A68D541C85D26508E83_1934770712 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1934770712 = this.parameters[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1934770712.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1934770712;
        // ---------- Original Method ----------
        //return this.parameters[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.923 -0400", hash_original_method = "EB48045459F47CF0118B0835F7086CA0", hash_generated_method = "85F092E813D3ED18E2C10B77EAB6FBF4")
    public NameValuePair getParameterByName(final String name) {
        NameValuePair varB4EAC82CA7396A68D541C85D26508E83_1465296819 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        NameValuePair found;
        found = null;
        {
            int i;
            i = 0;
            {
                NameValuePair current;
                current = this.parameters[ i ];
                {
                    boolean varD8B60F651B18EF4ED8FDAFAC5C2644BE_455494898 = (current.getName().equalsIgnoreCase(name));
                    {
                        found = current;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1465296819 = found;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1465296819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1465296819;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Name may not be null");
        //}
        //NameValuePair found = null;
        //for (int i = 0; i < this.parameters.length; i++) {
            //NameValuePair current = this.parameters[ i ];
            //if (current.getName().equalsIgnoreCase(name)) {
                //found = current;
                //break;
            //}
        //}
        //return found;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.930 -0400", hash_original_method = "84D34B9B0982E4EBAA99AAAC5467288A", hash_generated_method = "3C1541670C38970DC8B26C6CCF7F4784")
    public boolean equals(final Object object) {
        {
            BasicHeaderElement that;
            that = (BasicHeaderElement) object;
            boolean varFDF7DC2D2925ED8761C1D16434692326_1312045388 = (this.name.equals(that.name)
                && LangUtils.equals(this.value, that.value)
                && LangUtils.equals(this.parameters, that.parameters));
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_797460407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_797460407;
        // ---------- Original Method ----------
        //if (object == null) return false;
        //if (this == object) return true;
        //if (object instanceof HeaderElement) {
            //BasicHeaderElement that = (BasicHeaderElement) object;
            //return this.name.equals(that.name)
                //&& LangUtils.equals(this.value, that.value)
                //&& LangUtils.equals(this.parameters, that.parameters);
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.931 -0400", hash_original_method = "4C03DB3D3629EDBB8E252CDFFA259653", hash_generated_method = "D32941ECD9F37AD2D8720986B10154D7")
    public int hashCode() {
        int hash;
        hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        {
            int i;
            i = 0;
            {
                hash = LangUtils.hashCode(hash, this.parameters[i]);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530920051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_530920051;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.value);
        //for (int i = 0; i < this.parameters.length; i++) {
            //hash = LangUtils.hashCode(hash, this.parameters[i]);
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.942 -0400", hash_original_method = "D1269B43C4D02DE243B0BC051FD8549B", hash_generated_method = "4665A90C7EFB33FC69907DC02A5CE70C")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_711052688 = null; //Variable for return #1
        CharArrayBuffer buffer;
        buffer = new CharArrayBuffer(64);
        buffer.append(this.name);
        {
            buffer.append("=");
            buffer.append(this.value);
        } //End block
        {
            int i;
            i = 0;
            {
                buffer.append("; ");
                buffer.append(this.parameters[i]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_711052688 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_711052688.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_711052688;
        // ---------- Original Method ----------
        //CharArrayBuffer buffer = new CharArrayBuffer(64);
        //buffer.append(this.name);
        //if (this.value != null) {
            //buffer.append("=");
            //buffer.append(this.value);
        //}
        //for (int i = 0; i < this.parameters.length; i++) {
            //buffer.append("; ");
            //buffer.append(this.parameters[i]);
        //}
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.942 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "A6FE57E3367DDEA039C892D7D9A8ECDF")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_854638588 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_854638588 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_854638588.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_854638588;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

