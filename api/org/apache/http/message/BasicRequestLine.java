package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;






public class BasicRequestLine implements RequestLine, Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.760 -0500", hash_original_field = "13562D9F74FFA1CC7E8C143377A3FB6C", hash_generated_field = "FB524F3C45513827A3D0C2FF3CDC9338")


    private  ProtocolVersion protoversion;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.762 -0500", hash_original_field = "842C170402669AC7A74293BBBFD3BC5D", hash_generated_field = "F42F15CDE806BBAD7F26F7952D68FCE2")

    private  String method;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.765 -0500", hash_original_field = "EDEBE52DCF191A03299D02F6C51FE39B", hash_generated_field = "26AD8F31DE2ECD559067F2936328A369")

    private  String uri;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.767 -0500", hash_original_method = "C975E0C09D0E2EF1EBE9CA9605A59CBA", hash_generated_method = "C1CE0317F0F4B1E0033EC310B4C00990")
    
public BasicRequestLine(final String method,
                            final String uri,
                            final ProtocolVersion version) {
        super();
        if (method == null) {
            throw new IllegalArgumentException
                ("Method must not be null.");
        }
        if (uri == null) {
            throw new IllegalArgumentException
                ("URI must not be null.");
        }
        if (version == null) {
            throw new IllegalArgumentException
                ("Protocol version must not be null.");
        }
        this.method = method;
        this.uri = uri;
        this.protoversion = version;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.770 -0500", hash_original_method = "691C5451C67574E660997BC2056A5F23", hash_generated_method = "7472B5026828D1D5EB47237766CBDA14")
    
public String getMethod() {
        return this.method;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.772 -0500", hash_original_method = "96B8CBD1E6801618947DE1A14DEAA69F", hash_generated_method = "55024CD90D2ECAD5CDA12A5A8B3254BE")
    
public ProtocolVersion getProtocolVersion() {
        return this.protoversion;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.774 -0500", hash_original_method = "638E54DC35C58AE1ED57DF94E885B4C7", hash_generated_method = "8857A4DB81E344D0C9514C8654CCFB43")
    
public String getUri() {
        return this.uri;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.777 -0500", hash_original_method = "DE48B9AC65FB9CF013FEA7278BE0E864", hash_generated_method = "A51B2F4332CB3FF013F07CB238AFB447")
    
public String toString() {
        // no need for non-default formatting in toString()
        return BasicLineFormatter.DEFAULT
            .formatRequestLine(null, this).toString();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:48.782 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "587F7AA34F50D42D8C2635621B97F7C1")
    
public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    
}

