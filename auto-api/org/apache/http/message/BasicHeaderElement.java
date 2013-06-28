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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.941 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.941 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.941 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "3C3A5449D27C0E3F0EFEC4E0CCB17416")

    private NameValuePair[] parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.942 -0400", hash_original_method = "84DDDE558F062A2A9F901E85C44DEB99", hash_generated_method = "1B1C4CA419E7F536B2D3E7A767506957")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.942 -0400", hash_original_method = "F40B924328FFEB3DAF8466EC412BA557", hash_generated_method = "9AE15BC4C24958C2D2383363AE148836")
    public  BasicHeaderElement(final String name, final String value) {
        this(name, value, null);
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.943 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "651B8C4A3F37554088C6C95D227A84E9")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1921052501 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1921052501 = this.name;
        varB4EAC82CA7396A68D541C85D26508E83_1921052501.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1921052501;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.943 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "931E9545B5F83752869EBF97E919C6D8")
    public String getValue() {
        String varB4EAC82CA7396A68D541C85D26508E83_544966416 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_544966416 = this.value;
        varB4EAC82CA7396A68D541C85D26508E83_544966416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_544966416;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.944 -0400", hash_original_method = "3731305FA78433D69AC55713BB946E12", hash_generated_method = "B3FFD5015E811878E4C15155AD3AFB07")
    public NameValuePair[] getParameters() {
        NameValuePair[] varB4EAC82CA7396A68D541C85D26508E83_94120930 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_94120930 = (NameValuePair[])this.parameters.clone();
        varB4EAC82CA7396A68D541C85D26508E83_94120930.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_94120930;
        // ---------- Original Method ----------
        //return (NameValuePair[])this.parameters.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.944 -0400", hash_original_method = "D96148994A6BB50642F5897F1E874B9E", hash_generated_method = "B39889B235AF5F858DB8F4E82438E362")
    public int getParameterCount() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353264288 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1353264288;
        // ---------- Original Method ----------
        //return this.parameters.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.944 -0400", hash_original_method = "7A51C396EF547B19A00C38AEE513A356", hash_generated_method = "0CBB9BE44E4DB78B14E1959C0293162B")
    public NameValuePair getParameter(int index) {
        NameValuePair varB4EAC82CA7396A68D541C85D26508E83_1199928553 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1199928553 = this.parameters[index];
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1199928553.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1199928553;
        // ---------- Original Method ----------
        //return this.parameters[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.946 -0400", hash_original_method = "EB48045459F47CF0118B0835F7086CA0", hash_generated_method = "80EA06D9CD65043A79EABD2BB958ECD9")
    public NameValuePair getParameterByName(final String name) {
        NameValuePair varB4EAC82CA7396A68D541C85D26508E83_456319706 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Name may not be null");
        } //End block
        NameValuePair found = null;
        {
            int i = 0;
            {
                NameValuePair current = this.parameters[ i ];
                {
                    boolean varD8B60F651B18EF4ED8FDAFAC5C2644BE_1203838741 = (current.getName().equalsIgnoreCase(name));
                    {
                        found = current;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_456319706 = found;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_456319706.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_456319706;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.946 -0400", hash_original_method = "84D34B9B0982E4EBAA99AAAC5467288A", hash_generated_method = "0A85A5C6ECE7E51F947599E670031E16")
    public boolean equals(final Object object) {
        {
            BasicHeaderElement that = (BasicHeaderElement) object;
            boolean varFDF7DC2D2925ED8761C1D16434692326_454564499 = (this.name.equals(that.name)
                && LangUtils.equals(this.value, that.value)
                && LangUtils.equals(this.parameters, that.parameters));
        } //End block
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_988476415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_988476415;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.947 -0400", hash_original_method = "4C03DB3D3629EDBB8E252CDFFA259653", hash_generated_method = "CBA48605645EB3BF3D48B9CE5767AEBF")
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
        {
            int i = 0;
            {
                hash = LangUtils.hashCode(hash, this.parameters[i]);
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428101475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1428101475;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.value);
        //for (int i = 0; i < this.parameters.length; i++) {
            //hash = LangUtils.hashCode(hash, this.parameters[i]);
        //}
        //return hash;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.948 -0400", hash_original_method = "D1269B43C4D02DE243B0BC051FD8549B", hash_generated_method = "126325E7F739AE21A1BAA2FB659CC269")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_206846374 = null; //Variable for return #1
        CharArrayBuffer buffer = new CharArrayBuffer(64);
        buffer.append(this.name);
        {
            buffer.append("=");
            buffer.append(this.value);
        } //End block
        {
            int i = 0;
            {
                buffer.append("; ");
                buffer.append(this.parameters[i]);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_206846374 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_206846374.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_206846374;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.948 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "A25B486E56BE4BB54252F06B828B57E9")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1783177289 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1783177289 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1783177289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783177289;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

