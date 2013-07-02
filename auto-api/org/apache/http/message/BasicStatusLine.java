package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

public class BasicStatusLine implements StatusLine, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.243 -0400", hash_original_field = "23DDB025C27B126E5417C36D02A9A056", hash_generated_field = "72E55365A74A797579CAA53A070680F8")

    private ProtocolVersion protoVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.243 -0400", hash_original_field = "F9A31C6B3670C772D11230C8D4D1F33F", hash_generated_field = "1626BC0851E962932D77E9DFF3CA1BE0")

    private int statusCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.243 -0400", hash_original_field = "6A273AF93AEB8DA54D90CBF3B44D79AC", hash_generated_field = "6AD67BCB7682DA68E3445B9AD0549128")

    private String reasonPhrase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.244 -0400", hash_original_method = "E6F861CC92981BDB285C9E8C86704EF5", hash_generated_method = "8598BB5F34499146F874D49D2C108D38")
    public  BasicStatusLine(final ProtocolVersion version, int statusCode,
                           final String reasonPhrase) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol version may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Status code may not be negative.");
        } 
        this.protoVersion = version;
        this.statusCode   = statusCode;
        this.reasonPhrase = reasonPhrase;
        
        
            
                
        
        
            
                
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.244 -0400", hash_original_method = "95EA9BAD16482D8308F9206838B315E7", hash_generated_method = "D893F0EA9B55B0D323FF74B843770B31")
    public int getStatusCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726539549 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1726539549;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.244 -0400", hash_original_method = "428750DB8A2FD05AED2F69E1D46A4B0B", hash_generated_method = "A57116ED8EB999866B7F16A0EFC8590A")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_207199453 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_207199453 = this.protoVersion;
        varB4EAC82CA7396A68D541C85D26508E83_207199453.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_207199453;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.245 -0400", hash_original_method = "F68F7EAA9CC529FF206693909CBAA2FE", hash_generated_method = "AF6B2DEE56B074D121F8A071A645A693")
    public String getReasonPhrase() {
        String varB4EAC82CA7396A68D541C85D26508E83_673888634 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_673888634 = this.reasonPhrase;
        varB4EAC82CA7396A68D541C85D26508E83_673888634.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_673888634;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.245 -0400", hash_original_method = "B124288BE18B40A8DA205B6ACD4ADD5F", hash_generated_method = "571B98380EA707B7854F7BC28E61C986")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_802650611 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_802650611 = BasicLineFormatter.DEFAULT
            .formatStatusLine(null, this).toString();
        varB4EAC82CA7396A68D541C85D26508E83_802650611.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_802650611;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.246 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "342AD04E913231C6D8EC50F424DFCAD1")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1313524083 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1313524083 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1313524083.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1313524083;
        
        
    }

    
}

