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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.039 -0400", hash_original_field = "F9B1081663AF351C5C340BD27A8FEE5E", hash_generated_field = "FB524F3C45513827A3D0C2FF3CDC9338")

    private ProtocolVersion protoversion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.039 -0400", hash_original_field = "EA9F6ACA279138C58F705C8D4CB4B8CE", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private String method;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.039 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

    private String uri;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.047 -0400", hash_original_method = "C975E0C09D0E2EF1EBE9CA9605A59CBA", hash_generated_method = "EC0EAF55684E71E47796502822BAF60C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.051 -0400", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "E9C45AFB6B24B5E8699EC72EDFC78235")
    public String getMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_2091000057 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2091000057 = this.method;
        varB4EAC82CA7396A68D541C85D26508E83_2091000057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2091000057;
        // ---------- Original Method ----------
        //return this.method;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.053 -0400", hash_original_method = "96B8CBD1E6801618947DE1A14DEAA69F", hash_generated_method = "74658889AFFCF6A83F4691666E93776A")
    public ProtocolVersion getProtocolVersion() {
        ProtocolVersion varB4EAC82CA7396A68D541C85D26508E83_67233434 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_67233434 = this.protoversion;
        varB4EAC82CA7396A68D541C85D26508E83_67233434.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_67233434;
        // ---------- Original Method ----------
        //return this.protoversion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.058 -0400", hash_original_method = "638E54DC35C58AE1ED57DF94E885B4C7", hash_generated_method = "BBA858B175EC2C4B21E3CECAFD6EF7EE")
    public String getUri() {
        String varB4EAC82CA7396A68D541C85D26508E83_459587768 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_459587768 = this.uri;
        varB4EAC82CA7396A68D541C85D26508E83_459587768.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_459587768;
        // ---------- Original Method ----------
        //return this.uri;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.059 -0400", hash_original_method = "DE48B9AC65FB9CF013FEA7278BE0E864", hash_generated_method = "8BE45F5EDA30A6403DF1A72AF7F78EA1")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1771790004 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1771790004 = BasicLineFormatter.DEFAULT
            .formatRequestLine(null, this).toString();
        varB4EAC82CA7396A68D541C85D26508E83_1771790004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1771790004;
        // ---------- Original Method ----------
        //return BasicLineFormatter.DEFAULT
            //.formatRequestLine(null, this).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.059 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "B848C2FC4EC376FF02BF9C2753DCF708")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_715373241 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_715373241 = super.clone();
        varB4EAC82CA7396A68D541C85D26508E83_715373241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_715373241;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

