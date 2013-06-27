package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;

public class BasicRequestLine implements RequestLine, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.236 -0400", hash_original_field = "F9B1081663AF351C5C340BD27A8FEE5E", hash_generated_field = "FB524F3C45513827A3D0C2FF3CDC9338")

    private ProtocolVersion protoversion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.236 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.236 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

    private String uri;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.237 -0400", hash_original_method = "C975E0C09D0E2EF1EBE9CA9605A59CBA", hash_generated_method = "EC0EAF55684E71E47796502822BAF60C")
    public  BasicRequestLine(final String method,
                            final String uri,
                            final ProtocolVersion version) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Method must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("URI must not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Protocol version must not be null.");
        } //End block
        this.method = method;
        this.uri = uri;
        this.protoversion = version;
        // ---------- Original Method ----------
        //if (method == null) {
            //throw new IllegalArgumentException
                //("Method must not be null.");
        //}
        //if (uri == null) {
            //throw new IllegalArgumentException
                //("URI must not be null.");
        //}
        //if (version == null) {
            //throw new IllegalArgumentException
                //("Protocol version must not be null.");
        //}
        //this.method = method;
        //this.uri = uri;
        //this.protoversion = version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.237 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "6BA0E8BC40A6C780D347EEABCC4AB40D")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_1596729953 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1596729953 = this.method;
        varB4EAC82CA7396A68D541C85D26508E83_1596729953.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1596729953;
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.237 -0400", hash_original_method = "96B8CBD1E6801618947DE1A14DEAA69F", hash_generated_method = "3CB307C31882880A2D7F4C48E46E40F4")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_1861066512 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1861066512 = this.protoversion;
        varB4EAC82CA7396A68D541C85D26508E83_1861066512.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1861066512;
        // ---------- Original Method ----------
        //return this.protoversion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.238 -0400", hash_original_method = "638E54DC35C58AE1ED57DF94E885B4C7", hash_generated_method = "98AEACAFB1154261A83FAB971D696ADD")
    public String getUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_180976735 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_180976735 = this.uri;
        varB4EAC82CA7396A68D541C85D26508E83_180976735.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_180976735;
        // ---------- Original Method ----------
        //return this.uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.238 -0400", hash_original_method = "DE48B9AC65FB9CF013FEA7278BE0E864", hash_generated_method = "C2E0D5220CC3A08A6DE4F6513DDBD4B6")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2115137257 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2115137257 = BasicLineFormatter.DEFAULT
            .formatRequestLine(null, this).toString();
        varB4EAC82CA7396A68D541C85D26508E83_2115137257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2115137257;
        // ---------- Original Method ----------
        //return BasicLineFormatter.DEFAULT
            //.formatRequestLine(null, this).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.246 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "5BCA960F8B6627D81FB793FFCE4F1611")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_859250560 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_859250560 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_859250560.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_859250560;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

