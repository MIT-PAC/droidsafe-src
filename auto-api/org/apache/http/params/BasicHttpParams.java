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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.414 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "40F49A62ECB5E9A3DA22A5AD615034CA")

    private HashMap parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.415 -0400", hash_original_method = "A376B34D8EF6688DA5CE35D3A9BF9679", hash_generated_method = "FBB171961C65791D0D41F7E11BB5ADB7")
    public  BasicHttpParams() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.416 -0400", hash_original_method = "B548E6F0EBE84EE65DD3D63619F6DBC3", hash_generated_method = "78A84E9F8F094901746992FBDC64C83E")
    public Object getParameter(final String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2090175159 = null; //Variable for return #1
        Object param = null;
        {
            param = this.parameters.get(name);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2090175159 = param;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2090175159.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2090175159;
        // ---------- Original Method ----------
        //Object param = null;
        //if (this.parameters != null) {
            //param = this.parameters.get(name);
        //}
        //return param;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.417 -0400", hash_original_method = "1FD1BD81C0FB0FA6F81246999A2D5591", hash_generated_method = "1C0604553C7BA1005EC793F507A22996")
    public HttpParams setParameter(final String name, final Object value) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1046456121 = null; //Variable for return #1
        {
            this.parameters = new HashMap();
        } //End block
        this.parameters.put(name, value);
        varB4EAC82CA7396A68D541C85D26508E83_1046456121 = this;
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1046456121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1046456121;
        // ---------- Original Method ----------
        //if (this.parameters == null) {
            //this.parameters = new HashMap();
        //}
        //this.parameters.put(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.418 -0400", hash_original_method = "74E2BBABB6578D4A29281B78A6332CF9", hash_generated_method = "AF0555F5BEA2243D3F922128F567C0D2")
    public boolean removeParameter(String name) {
        {
            boolean var7159A58A59FA577E95DBC3039E8696DC_820706793 = (this.parameters.containsKey(name));
            {
                this.parameters.remove(name);
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167020015 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167020015;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.419 -0400", hash_original_method = "4E0B88EB2C18EFA7166D69CABFC3CCFE", hash_generated_method = "6A53FD2403FB18769830F0EF2B0602CC")
    public void setParameters(final String[] names, final Object value) {
        {
            int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.419 -0400", hash_original_method = "D24982AEF13E062DCCB77CEA2BBD14B0", hash_generated_method = "999C83A615F3F44D208C6003A8BF7969")
    public boolean isParameterSet(final String name) {
        boolean var642969E26F8D1A04DFC5CA2692735681_1972386245 = (getParameter(name) != null);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514728816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_514728816;
        // ---------- Original Method ----------
        //return getParameter(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.420 -0400", hash_original_method = "DA4682045050DAC8AB210F57CB41214B", hash_generated_method = "D87DA748525267236327A3BA5563E55F")
    public boolean isParameterSetLocally(final String name) {
        boolean var6F0FA474CF97701B2EF95107F224A6BF_174715968 = (this.parameters != null && this.parameters.get(name) != null);
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945716304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945716304;
        // ---------- Original Method ----------
        //return this.parameters != null && this.parameters.get(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.420 -0400", hash_original_method = "F2DDE632E78D7CF5EE18F245B99A4352", hash_generated_method = "031BD174CA8DBEE1FA499F246DE138F9")
    public void clear() {
        this.parameters = null;
        // ---------- Original Method ----------
        //this.parameters = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.421 -0400", hash_original_method = "3AB09D0457EC8C59F84E0399637D76B5", hash_generated_method = "4E13AB95C42E405B78C26A9F3FC6E7CE")
    public HttpParams copy() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_29121215 = null; //Variable for return #1
        BasicHttpParams clone = new BasicHttpParams();
        copyParams(clone);
        varB4EAC82CA7396A68D541C85D26508E83_29121215 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_29121215.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_29121215;
        // ---------- Original Method ----------
        //BasicHttpParams clone = new BasicHttpParams();
        //copyParams(clone);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.421 -0400", hash_original_method = "D3B18BE40EFEF439795B5F92D987CA92", hash_generated_method = "3CD94B33500984B0263FFADCAA5CE79F")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1669498579 = null; //Variable for return #1
        BasicHttpParams clone = (BasicHttpParams) super.clone();
        copyParams(clone);
        varB4EAC82CA7396A68D541C85D26508E83_1669498579 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1669498579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1669498579;
        // ---------- Original Method ----------
        //BasicHttpParams clone = (BasicHttpParams) super.clone();
        //copyParams(clone);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.421 -0400", hash_original_method = "8367EB3601C4507E3D4CDEA1BB7DE03E", hash_generated_method = "24E730B873B18FE844B7763DDB4B4553")
    protected void copyParams(HttpParams target) {
        Iterator iter = parameters.entrySet().iterator();
        {
            boolean varADABAFEBBAB7E585DD903333BD7F20A8_1719169459 = (iter.hasNext());
            {
                Map.Entry me = (Map.Entry) iter.next();
                {
                    boolean var546FF2CA27A83DE3C7445BC7CFB4A404_1839707116 = (me.getKey() instanceof String);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.422 -0400", hash_original_field = "1DB64B55E10C4DAB95AC3FF85092E3B2", hash_generated_field = "F3BCAA56010B705CF935A8FD863598FA")

    private static final long serialVersionUID = -7086398485908701455L;
}

