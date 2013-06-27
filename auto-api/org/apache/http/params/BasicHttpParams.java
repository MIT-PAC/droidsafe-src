package org.apache.http.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.params.HttpParams;

public final class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.191 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "40F49A62ECB5E9A3DA22A5AD615034CA")

    private HashMap parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.191 -0400", hash_original_method = "A376B34D8EF6688DA5CE35D3A9BF9679", hash_generated_method = "FBB171961C65791D0D41F7E11BB5ADB7")
    public  BasicHttpParams() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.192 -0400", hash_original_method = "B548E6F0EBE84EE65DD3D63619F6DBC3", hash_generated_method = "BA493C9F4FDD3AC828308BB8EE411484")
    public Object getParameter(final String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_587582913 = null; //Variable for return #1
        Object param;
        param = null;
        {
            param = this.parameters.get(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_587582913 = param;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_587582913.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_587582913;
        // ---------- Original Method ----------
        //Object param = null;
        //if (this.parameters != null) {
            //param = this.parameters.get(name);
        //}
        //return param;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.192 -0400", hash_original_method = "1FD1BD81C0FB0FA6F81246999A2D5591", hash_generated_method = "AC369E2400850738AF8E61A7AFFBE6E2")
    public HttpParams setParameter(final String name, final Object value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1256016566 = null; //Variable for return #1
        {
            this.parameters = new HashMap();
        } //End block
        this.parameters.put(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1256016566 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1256016566.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1256016566;
        // ---------- Original Method ----------
        //if (this.parameters == null) {
            //this.parameters = new HashMap();
        //}
        //this.parameters.put(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.193 -0400", hash_original_method = "74E2BBABB6578D4A29281B78A6332CF9", hash_generated_method = "70B332551A08195D123BE554201B3042")
    public boolean removeParameter(String name) {
        {
            boolean var7159A58A59FA577E95DBC3039E8696DC_380730131 = (this.parameters.containsKey(name));
            {
                this.parameters.remove(name);
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_829314694 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_829314694;
        // ---------- Original Method ----------
        //if (this.parameters == null) {
            //return false;
        //}
        //if (this.parameters.containsKey(name)) {
            //this.parameters.remove(name);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.203 -0400", hash_original_method = "4E0B88EB2C18EFA7166D69CABFC3CCFE", hash_generated_method = "CCBAB8D701EADF1DAD9CA2FE4E2D0625")
    public void setParameters(final String[] names, final Object value) {
        {
            int i;
            i = 0;
            {
                setParameter(names[i], value);
            } //End block
        } //End collapsed parenthetic
        addTaint(names[0].getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //for (int i = 0; i < names.length; i++) {
            //setParameter(names[i], value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.203 -0400", hash_original_method = "D24982AEF13E062DCCB77CEA2BBD14B0", hash_generated_method = "0A0445AFCECDF747D97A36A855D4FE74")
    public boolean isParameterSet(final String name) {
        boolean var642969E26F8D1A04DFC5CA2692735681_1728007531 = (getParameter(name) != null);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1187929333 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1187929333;
        // ---------- Original Method ----------
        //return getParameter(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.203 -0400", hash_original_method = "DA4682045050DAC8AB210F57CB41214B", hash_generated_method = "8B2619C426ACD9AA08F426394574B036")
    public boolean isParameterSetLocally(final String name) {
        boolean var6F0FA474CF97701B2EF95107F224A6BF_203242276 = (this.parameters != null && this.parameters.get(name) != null);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_177423406 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_177423406;
        // ---------- Original Method ----------
        //return this.parameters != null && this.parameters.get(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.204 -0400", hash_original_method = "F2DDE632E78D7CF5EE18F245B99A4352", hash_generated_method = "031BD174CA8DBEE1FA499F246DE138F9")
    public void clear() {
        this.parameters = null;
        // ---------- Original Method ----------
        //this.parameters = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.204 -0400", hash_original_method = "3AB09D0457EC8C59F84E0399637D76B5", hash_generated_method = "4186388624C3D2734ADE4EEEE3FA9377")
    public HttpParams copy() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_904060412 = null; //Variable for return #1
        BasicHttpParams clone;
        clone = new BasicHttpParams();
        copyParams(clone);
        varB4EAC82CA7396A68D541C85D26508E83_904060412 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_904060412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_904060412;
        // ---------- Original Method ----------
        //BasicHttpParams clone = new BasicHttpParams();
        //copyParams(clone);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.210 -0400", hash_original_method = "D3B18BE40EFEF439795B5F92D987CA92", hash_generated_method = "5BA59D76A1FF9EB70F19E1C4771857F4")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_437806918 = null; //Variable for return #1
        BasicHttpParams clone;
        clone = (BasicHttpParams) super.clone();
        copyParams(clone);
        varB4EAC82CA7396A68D541C85D26508E83_437806918 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_437806918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_437806918;
        // ---------- Original Method ----------
        //BasicHttpParams clone = (BasicHttpParams) super.clone();
        //copyParams(clone);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.216 -0400", hash_original_method = "8367EB3601C4507E3D4CDEA1BB7DE03E", hash_generated_method = "FB7842A45904C6B515EAA31F42938314")
    protected void copyParams(HttpParams target) {
        Iterator iter;
        iter = parameters.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1228989490 = (iter.hasNext());
            {
                Map.Entry me;
                me = (Map.Entry) iter.next();
                {
                    boolean var546FF2CA27A83DE3C7445BC7CFB4A404_323484068 = (me.getKey() instanceof String);
                    target.setParameter((String)me.getKey(), me.getValue());
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(target.getTaint());
        // ---------- Original Method ----------
        //if (this.parameters == null)
            //return;
        //Iterator iter = parameters.entrySet().iterator();
        //while (iter.hasNext()) {
            //Map.Entry me = (Map.Entry) iter.next();
            //if (me.getKey() instanceof String)
                //target.setParameter((String)me.getKey(), me.getValue());
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.216 -0400", hash_original_field = "1DB64B55E10C4DAB95AC3FF85092E3B2", hash_generated_field = "0B23CD21529816976EF090988248341E")

    private static long serialVersionUID = -7086398485908701455L;
}

