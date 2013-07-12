package org.apache.http.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.HashMap;
import java.util.Map;

public class BasicHttpContext implements HttpContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.849 -0400", hash_original_field = "7D67682364DBB9F3485BABE9AD33ACCD", hash_generated_field = "D1460501CCEE3C619EE4C99664E2DBB5")

    private HttpContext parentContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.849 -0400", hash_original_field = "39165B451A557CE4CA8964DFE5102735", hash_generated_field = "14270C32B91E233A04B6BA686361124C")

    private Map map = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.849 -0400", hash_original_method = "7A4905790D001081AE9E7E7092B16556", hash_generated_method = "B3C58EE05EB2DAD95672DF798CE06022")
    public  BasicHttpContext() {
        this(null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.850 -0400", hash_original_method = "A4B2F68240B72FA009235C6627ABF17D", hash_generated_method = "A47175A671B513D5930880862C333301")
    public  BasicHttpContext(final HttpContext parentContext) {
        super();
        this.parentContext = parentContext;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.851 -0400", hash_original_method = "5AF73FFF83A5EDE5922275A66AC65FB8", hash_generated_method = "E2369CDE395D8C6F778C21BD399B4815")
    public Object getAttribute(final String id) {
        addTaint(id.getTaint());
    if(id == null)        
        {
            IllegalArgumentException var13FBCB15CD042AA2AF7E715F4F86FACE_1738695403 = new IllegalArgumentException("Id may not be null");
            var13FBCB15CD042AA2AF7E715F4F86FACE_1738695403.addTaint(taint);
            throw var13FBCB15CD042AA2AF7E715F4F86FACE_1738695403;
        } 
        Object obj = null;
    if(this.map != null)        
        {
            obj = this.map.get(id);
        } 
    if(obj == null && this.parentContext != null)        
        {
            obj = this.parentContext.getAttribute(id);
        } 
Object var2FDE1120F80AA4E8798ECDBDB1C0E85C_1738279305 =         obj;
        var2FDE1120F80AA4E8798ECDBDB1C0E85C_1738279305.addTaint(taint);
        return var2FDE1120F80AA4E8798ECDBDB1C0E85C_1738279305;
        
        
            
        
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.852 -0400", hash_original_method = "7CCB44BFA094973C3F41CEC20132EE3C", hash_generated_method = "E1F8964C25D6D0D9C373F8B0B2CC726F")
    public void setAttribute(final String id, final Object obj) {
        addTaint(obj.getTaint());
        addTaint(id.getTaint());
    if(id == null)        
        {
            IllegalArgumentException var13FBCB15CD042AA2AF7E715F4F86FACE_1957496647 = new IllegalArgumentException("Id may not be null");
            var13FBCB15CD042AA2AF7E715F4F86FACE_1957496647.addTaint(taint);
            throw var13FBCB15CD042AA2AF7E715F4F86FACE_1957496647;
        } 
    if(this.map == null)        
        {
            this.map = new HashMap();
        } 
        this.map.put(id, obj);
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.853 -0400", hash_original_method = "F81CB5E3AB9015A95E5E2B5DBCB1E2A6", hash_generated_method = "A9BD32612E6262F1861B36F32192DC98")
    public Object removeAttribute(final String id) {
        addTaint(id.getTaint());
    if(id == null)        
        {
            IllegalArgumentException var13FBCB15CD042AA2AF7E715F4F86FACE_545309391 = new IllegalArgumentException("Id may not be null");
            var13FBCB15CD042AA2AF7E715F4F86FACE_545309391.addTaint(taint);
            throw var13FBCB15CD042AA2AF7E715F4F86FACE_545309391;
        } 
    if(this.map != null)        
        {
Object varA35C08B2512A001A56088846D8851B60_42313221 =             this.map.remove(id);
            varA35C08B2512A001A56088846D8851B60_42313221.addTaint(taint);
            return varA35C08B2512A001A56088846D8851B60_42313221;
        } 
        else
        {
Object var540C13E9E156B687226421B24F2DF178_1587546056 =             null;
            var540C13E9E156B687226421B24F2DF178_1587546056.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1587546056;
        } 
        
        
            
        
        
            
        
            
        
    }

    
}

