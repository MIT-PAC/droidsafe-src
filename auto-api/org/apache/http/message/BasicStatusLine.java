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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.046 -0400", hash_original_field = "23DDB025C27B126E5417C36D02A9A056", hash_generated_field = "72E55365A74A797579CAA53A070680F8")

    private ProtocolVersion protoVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.046 -0400", hash_original_field = "F9A31C6B3670C772D11230C8D4D1F33F", hash_generated_field = "1626BC0851E962932D77E9DFF3CA1BE0")

    private int statusCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.046 -0400", hash_original_field = "6A273AF93AEB8DA54D90CBF3B44D79AC", hash_generated_field = "6AD67BCB7682DA68E3445B9AD0549128")

    private String reasonPhrase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.047 -0400", hash_original_method = "E6F861CC92981BDB285C9E8C86704EF5", hash_generated_method = "8598BB5F34499146F874D49D2C108D38")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.055 -0400", hash_original_method = "95EA9BAD16482D8308F9206838B315E7", hash_generated_method = "549977905C48F34FB2ACFB2239EB1C6C")
    public int getStatusCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861056779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_861056779;
        // ---------- Original Method ----------
        //return this.statusCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.055 -0400", hash_original_method = "428750DB8A2FD05AED2F69E1D46A4B0B", hash_generated_method = "AFD3367A4F08AD824D94EB283029B40A")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_141793943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_141793943 = this.protoVersion;
        varB4EAC82CA7396A68D541C85D26508E83_141793943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_141793943;
        // ---------- Original Method ----------
        //return this.protoVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.056 -0400", hash_original_method = "F68F7EAA9CC529FF206693909CBAA2FE", hash_generated_method = "7669F52C202CA5EEDB0363F02B98E2F8")
    public String getReasonPhrase() {
        String varB4EAC82CA7396A68D541C85D26508E83_495861382 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_495861382 = this.reasonPhrase;
        varB4EAC82CA7396A68D541C85D26508E83_495861382.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_495861382;
        // ---------- Original Method ----------
        //return this.reasonPhrase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.056 -0400", hash_original_method = "B124288BE18B40A8DA205B6ACD4ADD5F", hash_generated_method = "B7F77005FA0B36565F1DAEBD01BE185D")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1531225197 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1531225197 = BasicLineFormatter.DEFAULT
            .formatStatusLine(null, this).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1531225197.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1531225197;
        // ---------- Original Method ----------
        //return BasicLineFormatter.DEFAULT
            //.formatStatusLine(null, this).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.057 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "0ADF8DC788B2756B00958D88A66FEC67")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1946714888 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1946714888 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1946714888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1946714888;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

