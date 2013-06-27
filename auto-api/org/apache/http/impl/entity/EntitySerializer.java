package org.apache.http.impl.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.io.ChunkedOutputStream;
import org.apache.http.impl.io.ContentLengthOutputStream;
import org.apache.http.impl.io.IdentityOutputStream;
import org.apache.http.io.SessionOutputBuffer;

public class EntitySerializer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.775 -0400", hash_original_field = "27B348194FA2C44245DD354AB07C0458", hash_generated_field = "ADE4068D7F9D27835F9860151E36C4D1")

    private ContentLengthStrategy lenStrategy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.775 -0400", hash_original_method = "6A84330A1DEB7B7037DF31B55F2620FD", hash_generated_method = "BDA3024842794745F7DD2305DBD71B77")
    public  EntitySerializer(final ContentLengthStrategy lenStrategy) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Content length strategy may not be null");
        } //End block
        this.lenStrategy = lenStrategy;
        // ---------- Original Method ----------
        //if (lenStrategy == null) {
            //throw new IllegalArgumentException("Content length strategy may not be null");
        //}
        //this.lenStrategy = lenStrategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.776 -0400", hash_original_method = "6B5C9440DDF8E3FBB590642D99DA80CB", hash_generated_method = "B27F0C4E50FB48CECE7313AD1E281D96")
    protected OutputStream doSerialize(
            final SessionOutputBuffer outbuffer,
            final HttpMessage message) throws HttpException, IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1397263909 = null; //Variable for return #1
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_2109712281 = null; //Variable for return #2
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_220628492 = null; //Variable for return #3
        long len;
        len = this.lenStrategy.determineLength(message);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1397263909 = new ChunkedOutputStream(outbuffer);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2109712281 = new IdentityOutputStream(outbuffer);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_220628492 = new ContentLengthOutputStream(outbuffer, len);
        } //End block
        addTaint(outbuffer.getTaint());
        addTaint(message.getTaint());
        OutputStream varA7E53CE21691AB073D9660D615818899_1976125251; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1976125251 = varB4EAC82CA7396A68D541C85D26508E83_1397263909;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1976125251 = varB4EAC82CA7396A68D541C85D26508E83_2109712281;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1976125251 = varB4EAC82CA7396A68D541C85D26508E83_220628492;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1976125251.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1976125251;
        // ---------- Original Method ----------
        //long len = this.lenStrategy.determineLength(message);
        //if (len == ContentLengthStrategy.CHUNKED) {
            //return new ChunkedOutputStream(outbuffer);
        //} else if (len == ContentLengthStrategy.IDENTITY) {
            //return new IdentityOutputStream(outbuffer);
        //} else {
            //return new ContentLengthOutputStream(outbuffer, len);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:17.787 -0400", hash_original_method = "61D7ADAF4C31C152373CEA6CC3FA217A", hash_generated_method = "802B386D38136C34C36D6D778861E78D")
    public void serialize(
            final SessionOutputBuffer outbuffer,
            final HttpMessage message,
            final HttpEntity entity) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Session output buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP message may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP entity may not be null");
        } //End block
        OutputStream outstream;
        outstream = doSerialize(outbuffer, message);
        entity.writeTo(outstream);
        outstream.close();
        addTaint(outbuffer.getTaint());
        addTaint(message.getTaint());
        addTaint(entity.getTaint());
        // ---------- Original Method ----------
        //if (outbuffer == null) {
            //throw new IllegalArgumentException("Session output buffer may not be null");
        //}
        //if (message == null) {
            //throw new IllegalArgumentException("HTTP message may not be null");
        //}
        //if (entity == null) {
            //throw new IllegalArgumentException("HTTP entity may not be null");
        //}
        //OutputStream outstream = doSerialize(outbuffer, message);
        //entity.writeTo(outstream);
        //outstream.close();
    }

    
}

