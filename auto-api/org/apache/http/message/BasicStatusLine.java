package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.HttpStatus;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

public class BasicStatusLine implements StatusLine, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.241 -0400", hash_original_field = "23DDB025C27B126E5417C36D02A9A056", hash_generated_field = "72E55365A74A797579CAA53A070680F8")

    private ProtocolVersion protoVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.241 -0400", hash_original_field = "F9A31C6B3670C772D11230C8D4D1F33F", hash_generated_field = "1626BC0851E962932D77E9DFF3CA1BE0")

    private int statusCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.241 -0400", hash_original_field = "6A273AF93AEB8DA54D90CBF3B44D79AC", hash_generated_field = "6AD67BCB7682DA68E3445B9AD0549128")

    private String reasonPhrase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.242 -0400", hash_original_method = "E6F861CC92981BDB285C9E8C86704EF5", hash_generated_method = "8598BB5F34499146F874D49D2C108D38")
    public  BasicStatusLine(final ProtocolVersion version, int statusCode,
                           final String reasonPhrase) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol version may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Status code may not be negative.");
        } //End block
        this.protoVersion = version;
        this.statusCode   = statusCode;
        this.reasonPhrase = reasonPhrase;
        // ---------- Original Method ----------
        //if (version == null) {
            //throw new IllegalArgumentException
                //("Protocol version may not be null.");
        //}
        //if (statusCode < 0) {
            //throw new IllegalArgumentException
                //("Status code may not be negative.");
        //}
        //this.protoVersion = version;
        //this.statusCode   = statusCode;
        //this.reasonPhrase = reasonPhrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.242 -0400", hash_original_method = "95EA9BAD16482D8308F9206838B315E7", hash_generated_method = "DF851F1B2F35A276553624F85E813B79")
    public int getStatusCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559277289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1559277289;
        // ---------- Original Method ----------
        //return this.statusCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.243 -0400", hash_original_method = "428750DB8A2FD05AED2F69E1D46A4B0B", hash_generated_method = "99B501604161B1B9A8C2A461F2CCC552")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1375246776 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1375246776 = this.protoVersion;
        varB4EAC82CA7396A68D541C85D26508E83_1375246776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1375246776;
        // ---------- Original Method ----------
        //return this.protoVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.243 -0400", hash_original_method = "F68F7EAA9CC529FF206693909CBAA2FE", hash_generated_method = "B12E1945C760D989A27F512C96B0CBCE")
    public String getReasonPhrase() {
        String varB4EAC82CA7396A68D541C85D26508E83_700894103 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_700894103 = this.reasonPhrase;
        varB4EAC82CA7396A68D541C85D26508E83_700894103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_700894103;
        // ---------- Original Method ----------
        //return this.reasonPhrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.244 -0400", hash_original_method = "B124288BE18B40A8DA205B6ACD4ADD5F", hash_generated_method = "1BD396EAEAE7857309275ADD0D736E32")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_674592392 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_674592392 = BasicLineFormatter.DEFAULT
            .formatStatusLine(null, this).toString();
        varB4EAC82CA7396A68D541C85D26508E83_674592392.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_674592392;
        // ---------- Original Method ----------
        //return BasicLineFormatter.DEFAULT
            //.formatStatusLine(null, this).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.245 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "702F2C3A84F02BFF4FB120826511F49F")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1564501697 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1564501697 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1564501697.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1564501697;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

