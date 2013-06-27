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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.122 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.122 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.122 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "3C3A5449D27C0E3F0EFEC4E0CCB17416")

    private NameValuePair[] parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.123 -0400", hash_original_method = "84DDDE558F062A2A9F901E85C44DEB99", hash_generated_method = "1B1C4CA419E7F536B2D3E7A767506957")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.124 -0400", hash_original_method = "F40B924328FFEB3DAF8466EC412BA557", hash_generated_method = "9AE15BC4C24958C2D2383363AE148836")
    public  BasicHeaderElement(final String name, final String value) {
        this(name, value, null);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.124 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "79137DECD0AE6183972D676F2A2B0557")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_371442705 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_371442705 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_371442705.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_371442705;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.133 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "2461EF63327F25676F241276735A64B1")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_144197716 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_144197716 = this.value;
        varB4EAC82CA7396A68D541C85D26508E83_144197716.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_144197716;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.134 -0400", hash_original_method = "3731305FA78433D69AC55713BB946E12", hash_generated_method = "BD2A76581C0BCF56A2B1F5F6EEACF933")
    public NameValuePair[] getParameters() {
        NameValuePair[] varB4EAC82CA7396A68D541C85D26508E83_1109411466 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1109411466 = (NameValuePair[])this.parameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1109411466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1109411466;
        // ---------- Original Method ----------
        //return (NameValuePair[])this.parameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.134 -0400", hash_original_method = "D96148994A6BB50642F5897F1E874B9E", hash_generated_method = "E36B1AACCF2E595C0DD160E594A8E101")
    public int getParameterCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_28133924 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_28133924;
        // ---------- Original Method ----------
        //return this.parameters.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.135 -0400", hash_original_method = "7A51C396EF547B19A00C38AEE513A356", hash_generated_method = "C227FADC29B33D0E5559EF323415BBEB")
    public NameValuePair getParameter(int index) {
        NameValuePair varB4EAC82CA7396A68D541C85D26508E83_27840599 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_27840599 = this.parameters[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_27840599.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_27840599;
        // ---------- Original Method ----------
        //return this.parameters[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.135 -0400", hash_original_method = "EB48045459F47CF0118B0835F7086CA0", hash_generated_method = "5E631F2270F082459C21558358C1FC0F")
    public NameValuePair getParameterByName(final String name) {
        NameValuePair varB4EAC82CA7396A68D541C85D26508E83_901105945 = null; //Variable for return #1
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
                    boolean varD8B60F651B18EF4ED8FDAFAC5C2644BE_1114976600 = (current.getName().equalsIgnoreCase(name));
                    {
                        found = current;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_901105945 = found;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_901105945.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_901105945;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.136 -0400", hash_original_method = "84D34B9B0982E4EBAA99AAAC5467288A", hash_generated_method = "CF92EC0ED4787A44A748E03980C78E0E")
    public boolean equals(final Object object) {
        {
            BasicHeaderElement that;
            that = (BasicHeaderElement) object;
            boolean varFDF7DC2D2925ED8761C1D16434692326_1560314913 = (this.name.equals(that.name)
                && LangUtils.equals(this.value, that.value)
                && LangUtils.equals(this.parameters, that.parameters));
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2044458596 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2044458596;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.136 -0400", hash_original_method = "4C03DB3D3629EDBB8E252CDFFA259653", hash_generated_method = "69EB3D794D6D3EC205928EAA1A7E9D73")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809380250 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809380250;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.value);
        //for (int i = 0; i < this.parameters.length; i++) {
            //hash = LangUtils.hashCode(hash, this.parameters[i]);
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.143 -0400", hash_original_method = "D1269B43C4D02DE243B0BC051FD8549B", hash_generated_method = "D70A2D2F2A0543DB6643A2A96A71C40C")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_556018449 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_556018449 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_556018449.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_556018449;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.156 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "382F565C2A63EA9F8B98D519FD45EB1D")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1938129309 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1938129309 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1938129309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1938129309;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

