package org.apache.http.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.params.HttpParams;

public final class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.799 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "40F49A62ECB5E9A3DA22A5AD615034CA")

    private HashMap parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.799 -0400", hash_original_method = "A376B34D8EF6688DA5CE35D3A9BF9679", hash_generated_method = "FBB171961C65791D0D41F7E11BB5ADB7")
    public  BasicHttpParams() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.800 -0400", hash_original_method = "B548E6F0EBE84EE65DD3D63619F6DBC3", hash_generated_method = "CBF0D8094D365FEABD042FCB0CD04F58")
    public Object getParameter(final String name) {
        addTaint(name.getTaint());
        Object param = null;
    if(this.parameters != null)        
        {
            param = this.parameters.get(name);
        } //End block
Object varF81FB673F6C2DA8AAD87B981F743A4D2_515697680 =         param;
        varF81FB673F6C2DA8AAD87B981F743A4D2_515697680.addTaint(taint);
        return varF81FB673F6C2DA8AAD87B981F743A4D2_515697680;
        // ---------- Original Method ----------
        //Object param = null;
        //if (this.parameters != null) {
            //param = this.parameters.get(name);
        //}
        //return param;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.800 -0400", hash_original_method = "1FD1BD81C0FB0FA6F81246999A2D5591", hash_generated_method = "B4A7D95981A3894FBB2AEF6579DCE3A2")
    public HttpParams setParameter(final String name, final Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(this.parameters == null)        
        {
            this.parameters = new HashMap();
        } //End block
        this.parameters.put(name, value);
HttpParams var72A74007B2BE62B849F475C7BDA4658B_268681332 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_268681332.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_268681332;
        // ---------- Original Method ----------
        //if (this.parameters == null) {
            //this.parameters = new HashMap();
        //}
        //this.parameters.put(name, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.801 -0400", hash_original_method = "74E2BBABB6578D4A29281B78A6332CF9", hash_generated_method = "DFF5BDE669DEEBA831E06EE887395AA7")
    public boolean removeParameter(String name) {
        addTaint(name.getTaint());
    if(this.parameters == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1969283889 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_51961470 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_51961470;
        } //End block
    if(this.parameters.containsKey(name))        
        {
            this.parameters.remove(name);
            boolean varB326B5062B2F0E69046810717534CB09_32882984 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_970568724 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_970568724;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_811514177 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_437839984 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_437839984;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.802 -0400", hash_original_method = "4E0B88EB2C18EFA7166D69CABFC3CCFE", hash_generated_method = "C2BF800610DED8E8109B377D2B217E38")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.803 -0400", hash_original_method = "D24982AEF13E062DCCB77CEA2BBD14B0", hash_generated_method = "27E881F1A84577E0087400395ADFAA47")
    public boolean isParameterSet(final String name) {
        addTaint(name.getTaint());
        boolean varAFC06D2E57DCF01DF92E426A4E2BF138_189632083 = (getParameter(name) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_551649710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_551649710;
        // ---------- Original Method ----------
        //return getParameter(name) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.803 -0400", hash_original_method = "DA4682045050DAC8AB210F57CB41214B", hash_generated_method = "C0EA6880EDF3C89283A00F68E298DDAF")
    public boolean isParameterSetLocally(final String name) {
        addTaint(name.getTaint());
        boolean var8831547921B7445B9C61719A1B464FC6_1848869005 = (this.parameters != null && this.parameters.get(name) != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495412544 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_495412544;
        // ---------- Original Method ----------
        //return this.parameters != null && this.parameters.get(name) != null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.804 -0400", hash_original_method = "F2DDE632E78D7CF5EE18F245B99A4352", hash_generated_method = "031BD174CA8DBEE1FA499F246DE138F9")
    public void clear() {
        this.parameters = null;
        // ---------- Original Method ----------
        //this.parameters = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.804 -0400", hash_original_method = "3AB09D0457EC8C59F84E0399637D76B5", hash_generated_method = "B522631A6C77C3D3B0D359F3BF05C4AC")
    public HttpParams copy() {
        BasicHttpParams clone = new BasicHttpParams();
        copyParams(clone);
HttpParams var3DE52045BFD3C1BF3742F994ED6139AD_1053274812 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1053274812.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1053274812;
        // ---------- Original Method ----------
        //BasicHttpParams clone = new BasicHttpParams();
        //copyParams(clone);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.804 -0400", hash_original_method = "D3B18BE40EFEF439795B5F92D987CA92", hash_generated_method = "3B4A697F16A62AD83A47E124A9695C51")
    public Object clone() throws CloneNotSupportedException {
        BasicHttpParams clone = (BasicHttpParams) super.clone();
        copyParams(clone);
Object var3DE52045BFD3C1BF3742F994ED6139AD_1544812668 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1544812668.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1544812668;
        // ---------- Original Method ----------
        //BasicHttpParams clone = (BasicHttpParams) super.clone();
        //copyParams(clone);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.805 -0400", hash_original_method = "8367EB3601C4507E3D4CDEA1BB7DE03E", hash_generated_method = "743DC82F640204389E64ECBDB0DF6CAB")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.805 -0400", hash_original_field = "1DB64B55E10C4DAB95AC3FF85092E3B2", hash_generated_field = "F3BCAA56010B705CF935A8FD863598FA")

    private static final long serialVersionUID = -7086398485908701455L;
}

