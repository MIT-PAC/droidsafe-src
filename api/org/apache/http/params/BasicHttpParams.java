package org.apache.http.params;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;






public final class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.193 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "40F49A62ECB5E9A3DA22A5AD615034CA")

    private HashMap parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.193 -0400", hash_original_method = "A376B34D8EF6688DA5CE35D3A9BF9679", hash_generated_method = "FBB171961C65791D0D41F7E11BB5ADB7")
    public  BasicHttpParams() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.194 -0400", hash_original_method = "B548E6F0EBE84EE65DD3D63619F6DBC3", hash_generated_method = "87E100FD5F34D5117BAA67C0F0D40643")
    public Object getParameter(final String name) {
        addTaint(name.getTaint());
        Object param = null;
        if(this.parameters != null)        
        {
            param = this.parameters.get(name);
        } //End block
Object varF81FB673F6C2DA8AAD87B981F743A4D2_1264839386 =         param;
        varF81FB673F6C2DA8AAD87B981F743A4D2_1264839386.addTaint(taint);
        return varF81FB673F6C2DA8AAD87B981F743A4D2_1264839386;
        // ---------- Original Method ----------
        //Object param = null;
        //if (this.parameters != null) {
            //param = this.parameters.get(name);
        //}
        //return param;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.195 -0400", hash_original_method = "1FD1BD81C0FB0FA6F81246999A2D5591", hash_generated_method = "FA90F9F06487A4A59CD66F253489FF15")
    public HttpParams setParameter(final String name, final Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(this.parameters == null)        
        {
            this.parameters = new HashMap();
        } //End block
        this.parameters.put(name, value);
HttpParams var72A74007B2BE62B849F475C7BDA4658B_1041172179 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1041172179.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1041172179;
        // ---------- Original Method ----------
        //if (this.parameters == null) {
            //this.parameters = new HashMap();
        //}
        //this.parameters.put(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.195 -0400", hash_original_method = "74E2BBABB6578D4A29281B78A6332CF9", hash_generated_method = "390B33CD1D8142D037BA522370DADDAB")
    public boolean removeParameter(String name) {
        addTaint(name.getTaint());
        if(this.parameters == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1577936168 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1950649912 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1950649912;
        } //End block
        if(this.parameters.containsKey(name))        
        {
            this.parameters.remove(name);
            boolean varB326B5062B2F0E69046810717534CB09_696118744 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_348390492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_348390492;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1675326490 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033359415 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033359415;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.196 -0400", hash_original_method = "4E0B88EB2C18EFA7166D69CABFC3CCFE", hash_generated_method = "C2BF800610DED8E8109B377D2B217E38")
    public void setParameters(final String[] names, final Object value) {
        addTaint(value.getTaint());
        addTaint(names[0].getTaint());
for(int i = 0;i < names.length;i++)
        {
            setParameter(names[i], value);
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < names.length; i++) {
            //setParameter(names[i], value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.196 -0400", hash_original_method = "D24982AEF13E062DCCB77CEA2BBD14B0", hash_generated_method = "9553E63F72F0BCF4BF0B663B3EB56050")
    public boolean isParameterSet(final String name) {
        addTaint(name.getTaint());
        boolean varAFC06D2E57DCF01DF92E426A4E2BF138_737720224 = (getParameter(name) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090240138 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090240138;
        // ---------- Original Method ----------
        //return getParameter(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.197 -0400", hash_original_method = "DA4682045050DAC8AB210F57CB41214B", hash_generated_method = "DDF78BFDB9DDE6ECEF8AC728E75D576C")
    public boolean isParameterSetLocally(final String name) {
        addTaint(name.getTaint());
        boolean var8831547921B7445B9C61719A1B464FC6_743338087 = (this.parameters != null && this.parameters.get(name) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1617685643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1617685643;
        // ---------- Original Method ----------
        //return this.parameters != null && this.parameters.get(name) != null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.197 -0400", hash_original_method = "F2DDE632E78D7CF5EE18F245B99A4352", hash_generated_method = "031BD174CA8DBEE1FA499F246DE138F9")
    public void clear() {
        this.parameters = null;
        // ---------- Original Method ----------
        //this.parameters = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.197 -0400", hash_original_method = "3AB09D0457EC8C59F84E0399637D76B5", hash_generated_method = "1416171D65A0CE4D90BA36B8DBBD19E2")
    public HttpParams copy() {
        BasicHttpParams clone = new BasicHttpParams();
        copyParams(clone);
HttpParams var3DE52045BFD3C1BF3742F994ED6139AD_1970884729 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1970884729.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1970884729;
        // ---------- Original Method ----------
        //BasicHttpParams clone = new BasicHttpParams();
        //copyParams(clone);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.198 -0400", hash_original_method = "D3B18BE40EFEF439795B5F92D987CA92", hash_generated_method = "BAC855232B15C88F3CC80B25BFDB45DB")
    public Object clone() throws CloneNotSupportedException {
        BasicHttpParams clone = (BasicHttpParams) super.clone();
        copyParams(clone);
Object var3DE52045BFD3C1BF3742F994ED6139AD_1412729291 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1412729291.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1412729291;
        // ---------- Original Method ----------
        //BasicHttpParams clone = (BasicHttpParams) super.clone();
        //copyParams(clone);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.198 -0400", hash_original_method = "8367EB3601C4507E3D4CDEA1BB7DE03E", hash_generated_method = "743DC82F640204389E64ECBDB0DF6CAB")
    protected void copyParams(HttpParams target) {
        addTaint(target.getTaint());
        if(this.parameters == null)        
        return;
        Iterator iter = parameters.entrySet().iterator();
        while
(iter.hasNext())        
        {
            Map.Entry me = (Map.Entry) iter.next();
            if(me.getKey() instanceof String)            
            target.setParameter((String)me.getKey(), me.getValue());
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.198 -0400", hash_original_field = "1DB64B55E10C4DAB95AC3FF85092E3B2", hash_generated_field = "F3BCAA56010B705CF935A8FD863598FA")

    private static final long serialVersionUID = -7086398485908701455L;
}

