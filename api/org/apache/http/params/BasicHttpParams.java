package org.apache.http.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.438 -0500", hash_original_field = "BC5EFD781344EAB47B90C0C271E51038", hash_generated_field = "F3BCAA56010B705CF935A8FD863598FA")

    private static final long serialVersionUID = -7086398485908701455L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.440 -0500", hash_original_field = "8E1CDF2B2F62A3D8B019D3F373DAEE1F", hash_generated_field = "40F49A62ECB5E9A3DA22A5AD615034CA")

    private HashMap parameters;

    @DSComment("Http parameter structures")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.443 -0500", hash_original_method = "A376B34D8EF6688DA5CE35D3A9BF9679", hash_generated_method = "8F1AC69ECFF81B618B2B0A098F561EF5")
    
public BasicHttpParams() {
        super();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.446 -0500", hash_original_method = "B548E6F0EBE84EE65DD3D63619F6DBC3", hash_generated_method = "3DB416A8E004DF61064859322C5CEE24")
    
public Object getParameter(final String name) {
        // See if the parameter has been explicitly defined
        Object param = null;
        if (this.parameters != null) {
            param = this.parameters.get(name);
        }    
        return param;
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.448 -0500", hash_original_method = "1FD1BD81C0FB0FA6F81246999A2D5591", hash_generated_method = "3F1A4F58012C127ECA7E5436D47FA4D2")
    
public HttpParams setParameter(final String name, final Object value) {
        if (this.parameters == null) {
            this.parameters = new HashMap();
        }
        this.parameters.put(name, value);
        return this;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.450 -0500", hash_original_method = "74E2BBABB6578D4A29281B78A6332CF9", hash_generated_method = "3FFF1C4ADF852A2F96AB1BC646A3E4A1")
    
public boolean removeParameter(String name) {
        if (this.parameters == null) {
            return false;
        }
        //this is to avoid the case in which the key has a null value
        if (this.parameters.containsKey(name)) {
            this.parameters.remove(name);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Assigns the value to all the parameter with the given names
     * 
     * @param names array of parameter name
     * @param value parameter value
     */ 
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.452 -0500", hash_original_method = "4E0B88EB2C18EFA7166D69CABFC3CCFE", hash_generated_method = "2390DD39F63C40A7DE9F994906EBF141")
    
public void setParameters(final String[] names, final Object value) {
        for (int i = 0; i < names.length; i++) {
            setParameter(names[i], value);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.455 -0500", hash_original_method = "D24982AEF13E062DCCB77CEA2BBD14B0", hash_generated_method = "66E27F7358ED80A611B7EA690178F07D")
    
public boolean isParameterSet(final String name) {
        return getParameter(name) != null;
    }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.457 -0500", hash_original_method = "DA4682045050DAC8AB210F57CB41214B", hash_generated_method = "4D9A458F9853E2AB797F1F839371A896")
    
public boolean isParameterSetLocally(final String name) {
        return this.parameters != null && this.parameters.get(name) != null;
    }
        
    /**
     * Removes all parameters from this collection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.459 -0500", hash_original_method = "F2DDE632E78D7CF5EE18F245B99A4352", hash_generated_method = "ABCF605936245ED0084439F6DA43E9A0")
    
public void clear() {
        this.parameters = null;
    }

    /**
     * Creates a copy of these parameters.
     * The implementation here instantiates {@link BasicHttpParams}, 
     * then calls {@link #copyParams(HttpParams)} to populate the copy.
     *
     * @return  a new set of params holding a copy of the
     *          <i>local</i> parameters in this object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.461 -0500", hash_original_method = "3AB09D0457EC8C59F84E0399637D76B5", hash_generated_method = "AAFFFE7D5092118CB9E694C18102A102")
    
public HttpParams copy() {
        BasicHttpParams clone = new BasicHttpParams();
        copyParams(clone);
        return clone;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.464 -0500", hash_original_method = "D3B18BE40EFEF439795B5F92D987CA92", hash_generated_method = "7287DE456BC2E2CFA515D4865466FDA2")
    
public Object clone() throws CloneNotSupportedException {
        BasicHttpParams clone = (BasicHttpParams) super.clone();
        copyParams(clone);
        return clone;
    }
 
    /**
     * Copies the locally defined parameters to the argument parameters.
     * This method is called from {@link #copy()}.
     *
     * @param target    the parameters to which to copy
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.466 -0500", hash_original_method = "8367EB3601C4507E3D4CDEA1BB7DE03E", hash_generated_method = "D3905C18AE2CFC808BDD71E7252C76AA")
    
protected void copyParams(HttpParams target) {
        if (this.parameters == null)
            return;

        Iterator iter = parameters.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry me = (Map.Entry) iter.next();
            if (me.getKey() instanceof String)
                target.setParameter((String)me.getKey(), me.getValue());
        }
    }
}

