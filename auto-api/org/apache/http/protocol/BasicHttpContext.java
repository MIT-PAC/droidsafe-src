package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;

public class BasicHttpContext implements HttpContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.207 -0400", hash_original_field = "7D67682364DBB9F3485BABE9AD33ACCD", hash_generated_field = "D1460501CCEE3C619EE4C99664E2DBB5")

    private HttpContext parentContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.207 -0400", hash_original_field = "39165B451A557CE4CA8964DFE5102735", hash_generated_field = "14270C32B91E233A04B6BA686361124C")

    private Map map = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.220 -0400", hash_original_method = "7A4905790D001081AE9E7E7092B16556", hash_generated_method = "B3C58EE05EB2DAD95672DF798CE06022")
    public  BasicHttpContext() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.220 -0400", hash_original_method = "A4B2F68240B72FA009235C6627ABF17D", hash_generated_method = "A47175A671B513D5930880862C333301")
    public  BasicHttpContext(final HttpContext parentContext) {
        super();
        this.parentContext = parentContext;
        // ---------- Original Method ----------
        //this.parentContext = parentContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.221 -0400", hash_original_method = "5AF73FFF83A5EDE5922275A66AC65FB8", hash_generated_method = "846484EBA972099D344DFC6EE49E966D")
    public Object getAttribute(final String id) {
        Object varB4EAC82CA7396A68D541C85D26508E83_2075393032 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Id may not be null");
        } //End block
        Object obj;
        obj = null;
        {
            obj = this.map.get(id);
        } //End block
        {
            obj = this.parentContext.getAttribute(id);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2075393032 = obj;
        addTaint(id.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2075393032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2075393032;
        // ---------- Original Method ----------
        //if (id == null) {
            //throw new IllegalArgumentException("Id may not be null");
        //}
        //Object obj = null;
        //if (this.map != null) {
            //obj = this.map.get(id);
        //}
        //if (obj == null && this.parentContext != null) {
            //obj = this.parentContext.getAttribute(id);
        //}
        //return obj;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.222 -0400", hash_original_method = "7CCB44BFA094973C3F41CEC20132EE3C", hash_generated_method = "F40BC07141F8C50B47132E71A03ADD55")
    public void setAttribute(final String id, final Object obj) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Id may not be null");
        } //End block
        {
            this.map = new HashMap();
        } //End block
        this.map.put(id, obj);
        addTaint(id.getTaint());
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //if (id == null) {
            //throw new IllegalArgumentException("Id may not be null");
        //}
        //if (this.map == null) {
            //this.map = new HashMap();
        //}
        //this.map.put(id, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.223 -0400", hash_original_method = "F81CB5E3AB9015A95E5E2B5DBCB1E2A6", hash_generated_method = "1E30E2BEF9A33FB56F28FB753D12EE2E")
    public Object removeAttribute(final String id) {
        Object varB4EAC82CA7396A68D541C85D26508E83_365338891 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_901504076 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Id may not be null");
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_365338891 = this.map.remove(id);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_901504076 = null;
        } //End block
        addTaint(id.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_714463498; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_714463498 = varB4EAC82CA7396A68D541C85D26508E83_365338891;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_714463498 = varB4EAC82CA7396A68D541C85D26508E83_901504076;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_714463498.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_714463498;
        // ---------- Original Method ----------
        //if (id == null) {
            //throw new IllegalArgumentException("Id may not be null");
        //}
        //if (this.map != null) {
            //return this.map.remove(id);
        //} else {
            //return null;
        //}
    }

    
}

