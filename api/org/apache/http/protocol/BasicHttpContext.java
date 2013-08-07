package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;




public class BasicHttpContext implements HttpContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.238 -0400", hash_original_field = "7D67682364DBB9F3485BABE9AD33ACCD", hash_generated_field = "D1460501CCEE3C619EE4C99664E2DBB5")

    private HttpContext parentContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.238 -0400", hash_original_field = "39165B451A557CE4CA8964DFE5102735", hash_generated_field = "14270C32B91E233A04B6BA686361124C")

    private Map map = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.238 -0400", hash_original_method = "7A4905790D001081AE9E7E7092B16556", hash_generated_method = "B3C58EE05EB2DAD95672DF798CE06022")
    public  BasicHttpContext() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.239 -0400", hash_original_method = "A4B2F68240B72FA009235C6627ABF17D", hash_generated_method = "A47175A671B513D5930880862C333301")
    public  BasicHttpContext(final HttpContext parentContext) {
        super();
        this.parentContext = parentContext;
        // ---------- Original Method ----------
        //this.parentContext = parentContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.240 -0400", hash_original_method = "5AF73FFF83A5EDE5922275A66AC65FB8", hash_generated_method = "B5A5242F5A3C49F125339A385D6736EC")
    public Object getAttribute(final String id) {
        addTaint(id.getTaint());
        if(id == null)        
        {
            IllegalArgumentException var13FBCB15CD042AA2AF7E715F4F86FACE_1206156869 = new IllegalArgumentException("Id may not be null");
            var13FBCB15CD042AA2AF7E715F4F86FACE_1206156869.addTaint(taint);
            throw var13FBCB15CD042AA2AF7E715F4F86FACE_1206156869;
        } //End block
        Object obj = null;
        if(this.map != null)        
        {
            obj = this.map.get(id);
        } //End block
        if(obj == null && this.parentContext != null)        
        {
            obj = this.parentContext.getAttribute(id);
        } //End block
Object var2FDE1120F80AA4E8798ECDBDB1C0E85C_791560751 =         obj;
        var2FDE1120F80AA4E8798ECDBDB1C0E85C_791560751.addTaint(taint);
        return var2FDE1120F80AA4E8798ECDBDB1C0E85C_791560751;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.240 -0400", hash_original_method = "7CCB44BFA094973C3F41CEC20132EE3C", hash_generated_method = "FE9F36E535B24EC7B3A1F92453CB44AF")
    public void setAttribute(final String id, final Object obj) {
        addTaint(obj.getTaint());
        addTaint(id.getTaint());
        if(id == null)        
        {
            IllegalArgumentException var13FBCB15CD042AA2AF7E715F4F86FACE_2108867127 = new IllegalArgumentException("Id may not be null");
            var13FBCB15CD042AA2AF7E715F4F86FACE_2108867127.addTaint(taint);
            throw var13FBCB15CD042AA2AF7E715F4F86FACE_2108867127;
        } //End block
        if(this.map == null)        
        {
            this.map = new HashMap();
        } //End block
        this.map.put(id, obj);
        // ---------- Original Method ----------
        //if (id == null) {
            //throw new IllegalArgumentException("Id may not be null");
        //}
        //if (this.map == null) {
            //this.map = new HashMap();
        //}
        //this.map.put(id, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.241 -0400", hash_original_method = "F81CB5E3AB9015A95E5E2B5DBCB1E2A6", hash_generated_method = "79BEF19CA9E16CF9966FE97A58B1EE8B")
    public Object removeAttribute(final String id) {
        addTaint(id.getTaint());
        if(id == null)        
        {
            IllegalArgumentException var13FBCB15CD042AA2AF7E715F4F86FACE_1022916962 = new IllegalArgumentException("Id may not be null");
            var13FBCB15CD042AA2AF7E715F4F86FACE_1022916962.addTaint(taint);
            throw var13FBCB15CD042AA2AF7E715F4F86FACE_1022916962;
        } //End block
        if(this.map != null)        
        {
Object varA35C08B2512A001A56088846D8851B60_446974955 =             this.map.remove(id);
            varA35C08B2512A001A56088846D8851B60_446974955.addTaint(taint);
            return varA35C08B2512A001A56088846D8851B60_446974955;
        } //End block
        else
        {
Object var540C13E9E156B687226421B24F2DF178_1065971036 =             null;
            var540C13E9E156B687226421B24F2DF178_1065971036.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1065971036;
        } //End block
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

