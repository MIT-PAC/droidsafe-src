package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;






public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.664 -0500", hash_original_field = "6A9B1BF6E4F51C5BBC665A9F39B095B2", hash_generated_field = "5694DF6F087835D263272D46C49C87A7")


    protected  byte[] content;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.667 -0500", hash_original_method = "85F43E7DC885CA97417C9F3E2732068E", hash_generated_method = "307B04CD5C0F134D3D3EE4FE12B80A20")
    
public ByteArrayEntity(final byte[] b) {
        super();        
        if (b == null) {
            throw new IllegalArgumentException("Source byte array may not be null");
        }
        this.content = b;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.670 -0500", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "827F310DEB1F388C181FD1C8E221D99B")
    
public boolean isRepeatable() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.673 -0500", hash_original_method = "161FF0185286748984501E39486F36ED", hash_generated_method = "93033B2A767636AD1C8B9B84FA3C5F42")
    
public long getContentLength() {
        return this.content.length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.675 -0500", hash_original_method = "004C3F78EC3F500E7D7F762D94BAEB0E", hash_generated_method = "27D3D214D0211F80B5801B5EB21C0033")
    
public InputStream getContent() {
        return new ByteArrayInputStream(this.content);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.677 -0500", hash_original_method = "F9996C70B2856060246DFF92163DB1CA", hash_generated_method = "BDD092DE07E44519E63AE6CE1D7E2553")
    
public void writeTo(final OutputStream outstream) throws IOException {
        if (outstream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        outstream.write(this.content);
        outstream.flush();
    }


    /**
     * Tells that this entity is not streaming.
     *
     * @return <code>false</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.680 -0500", hash_original_method = "1C9916E491D93B6DAF758D3D738C6EEB", hash_generated_method = "15A1411ACDA23E1A918918FF0CDDBE57")
    
public boolean isStreaming() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.682 -0500", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "587F7AA34F50D42D8C2635621B97F7C1")
    
public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    
}

