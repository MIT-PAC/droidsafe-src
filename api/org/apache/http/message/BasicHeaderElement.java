package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public class BasicHeaderElement implements HeaderElement, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.343 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.343 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

    private String value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.344 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "3C3A5449D27C0E3F0EFEC4E0CCB17416")

    private NameValuePair[] parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.345 -0400", hash_original_method = "84DDDE558F062A2A9F901E85C44DEB99", hash_generated_method = "09080C28DE198FD34351FE734526E4FC")
    public  BasicHeaderElement(
            final String name, 
            final String value,
            final NameValuePair[] parameters) {
        super();
    if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_674237100 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_674237100.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_674237100;
        } //End block
        this.name = name;
        this.value = value;
    if(parameters != null)        
        {
            this.parameters = parameters;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.345 -0400", hash_original_method = "F40B924328FFEB3DAF8466EC412BA557", hash_generated_method = "7642ECF454330FF8ACF313792244BF58")
    public  BasicHeaderElement(final String name, final String value) {
        this(name, value, null);
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.346 -0400", hash_original_method = "6F5A80252F54E883F3837DA0C6833E69", hash_generated_method = "1EF2283997EA84B7E4D04A1643F1F99D")
    public String getName() {
String varDC708CD29829AA84C3F2D9B68CF84B0D_1362286811 =         this.name;
        varDC708CD29829AA84C3F2D9B68CF84B0D_1362286811.addTaint(taint);
        return varDC708CD29829AA84C3F2D9B68CF84B0D_1362286811;
        // ---------- Original Method ----------
        //return this.name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.346 -0400", hash_original_method = "ADE49245CA79B6D6B3F4663E953C8CD9", hash_generated_method = "B79A96FD2A77BBBFC00017225ADA574E")
    public String getValue() {
String varD64EF4B55BF21CB8765EC6BE5560B5B8_943017635 =         this.value;
        varD64EF4B55BF21CB8765EC6BE5560B5B8_943017635.addTaint(taint);
        return varD64EF4B55BF21CB8765EC6BE5560B5B8_943017635;
        // ---------- Original Method ----------
        //return this.value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.346 -0400", hash_original_method = "3731305FA78433D69AC55713BB946E12", hash_generated_method = "5D84B42AA4D2C60DABFE2D7705D7F05D")
    public NameValuePair[] getParameters() {
NameValuePair[] varCBFB6E66E9BA858BA07B15CDA982B151_1494122935 =         (NameValuePair[])this.parameters.clone();
        varCBFB6E66E9BA858BA07B15CDA982B151_1494122935.addTaint(taint);
        return varCBFB6E66E9BA858BA07B15CDA982B151_1494122935;
        // ---------- Original Method ----------
        //return (NameValuePair[])this.parameters.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.347 -0400", hash_original_method = "D96148994A6BB50642F5897F1E874B9E", hash_generated_method = "DF4A64F3E14A2C03CA18425F168C0CFC")
    public int getParameterCount() {
        int var1E5254465D1C41EA837730F8F4D25786_699651151 = (this.parameters.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008932252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2008932252;
        // ---------- Original Method ----------
        //return this.parameters.length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.347 -0400", hash_original_method = "7A51C396EF547B19A00C38AEE513A356", hash_generated_method = "4117C3F891814EFFB5B48374B9FF6746")
    public NameValuePair getParameter(int index) {
        addTaint(index);
NameValuePair varA110B53CAEF3F85A3C14AF777DCEB7F7_853726613 =         this.parameters[index];
        varA110B53CAEF3F85A3C14AF777DCEB7F7_853726613.addTaint(taint);
        return varA110B53CAEF3F85A3C14AF777DCEB7F7_853726613;
        // ---------- Original Method ----------
        //return this.parameters[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.348 -0400", hash_original_method = "EB48045459F47CF0118B0835F7086CA0", hash_generated_method = "B771527D9E00D94128BF308DAE711D9A")
    public NameValuePair getParameterByName(final String name) {
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException var3C43595648C24A9FD2A1B7AF0D642045_2060367112 = new IllegalArgumentException("Name may not be null");
            var3C43595648C24A9FD2A1B7AF0D642045_2060367112.addTaint(taint);
            throw var3C43595648C24A9FD2A1B7AF0D642045_2060367112;
        } //End block
        NameValuePair found = null;
for(int i = 0;i < this.parameters.length;i++)
        {
            NameValuePair current = this.parameters[ i ];
    if(current.getName().equalsIgnoreCase(name))            
            {
                found = current;
                break;
            } //End block
        } //End block
NameValuePair varF632CA15DF7F0948C110F1E316CEC23E_896126278 =         found;
        varF632CA15DF7F0948C110F1E316CEC23E_896126278.addTaint(taint);
        return varF632CA15DF7F0948C110F1E316CEC23E_896126278;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.349 -0400", hash_original_method = "84D34B9B0982E4EBAA99AAAC5467288A", hash_generated_method = "5AFB80E928B14B8A1D6E189BC6A849D1")
    public boolean equals(final Object object) {
        addTaint(object.getTaint());
    if(object == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1789635032 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075462313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075462313;
        }
    if(this == object)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1834674906 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1986260283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1986260283;
        }
    if(object instanceof HeaderElement)        
        {
            BasicHeaderElement that = (BasicHeaderElement) object;
            boolean var490A0655CEBCA928415C53590C0948A6_706193817 = (this.name.equals(that.name)
                && LangUtils.equals(this.value, that.value)
                && LangUtils.equals(this.parameters, that.parameters));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980443044 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980443044;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_2055725148 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_295572327 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_295572327;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.351 -0400", hash_original_method = "4C03DB3D3629EDBB8E252CDFFA259653", hash_generated_method = "830BAAC65685FEC599640482C10123E9")
    public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.value);
for(int i = 0;i < this.parameters.length;i++)
        {
            hash = LangUtils.hashCode(hash, this.parameters[i]);
        } //End block
        int var0800FC577294C34E0B28AD2839435945_1751514807 = (hash);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312110906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312110906;
        // ---------- Original Method ----------
        //int hash = LangUtils.HASH_SEED;
        //hash = LangUtils.hashCode(hash, this.name);
        //hash = LangUtils.hashCode(hash, this.value);
        //for (int i = 0; i < this.parameters.length; i++) {
            //hash = LangUtils.hashCode(hash, this.parameters[i]);
        //}
        //return hash;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.352 -0400", hash_original_method = "D1269B43C4D02DE243B0BC051FD8549B", hash_generated_method = "225B475DF0A83A8E62A2CF80B752B85B")
    public String toString() {
        CharArrayBuffer buffer = new CharArrayBuffer(64);
        buffer.append(this.name);
    if(this.value != null)        
        {
            buffer.append("=");
            buffer.append(this.value);
        } //End block
for(int i = 0;i < this.parameters.length;i++)
        {
            buffer.append("; ");
            buffer.append(this.parameters[i]);
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_2062130916 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_2062130916.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_2062130916;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.353 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "B5F9F83F1AB89B050D49A2CA27507DFC")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_1467748586 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_1467748586.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_1467748586;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

