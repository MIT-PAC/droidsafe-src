package org.apache.http.impl.entity;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.538 -0400", hash_original_field = "27B348194FA2C44245DD354AB07C0458", hash_generated_field = "ADE4068D7F9D27835F9860151E36C4D1")

    private ContentLengthStrategy lenStrategy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.539 -0400", hash_original_method = "6A84330A1DEB7B7037DF31B55F2620FD", hash_generated_method = "BDA3024842794745F7DD2305DBD71B77")
    public  EntitySerializer(final ContentLengthStrategy lenStrategy) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Content length strategy may not be null");
        } 
        this.lenStrategy = lenStrategy;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.540 -0400", hash_original_method = "6B5C9440DDF8E3FBB590642D99DA80CB", hash_generated_method = "CEE0D806FBE6D520389ADD6D5DDCF3B4")
    protected OutputStream doSerialize(
            final SessionOutputBuffer outbuffer,
            final HttpMessage message) throws HttpException, IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_2072989526 = null; 
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_2144717227 = null; 
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_1004591378 = null; 
        long len = this.lenStrategy.determineLength(message);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2072989526 = new ChunkedOutputStream(outbuffer);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2144717227 = new IdentityOutputStream(outbuffer);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1004591378 = new ContentLengthOutputStream(outbuffer, len);
        } 
        addTaint(outbuffer.getTaint());
        addTaint(message.getTaint());
        OutputStream varA7E53CE21691AB073D9660D615818899_1047856680; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1047856680 = varB4EAC82CA7396A68D541C85D26508E83_2072989526;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1047856680 = varB4EAC82CA7396A68D541C85D26508E83_2144717227;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1047856680 = varB4EAC82CA7396A68D541C85D26508E83_1004591378;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1047856680.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1047856680;
        
        
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.540 -0400", hash_original_method = "61D7ADAF4C31C152373CEA6CC3FA217A", hash_generated_method = "BFE6D0B599A9DF097AF665F5A50F1DE5")
    public void serialize(
            final SessionOutputBuffer outbuffer,
            final HttpMessage message,
            final HttpEntity entity) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Session output buffer may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP message may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP entity may not be null");
        } 
        OutputStream outstream = doSerialize(outbuffer, message);
        entity.writeTo(outstream);
        outstream.close();
        addTaint(outbuffer.getTaint());
        addTaint(message.getTaint());
        addTaint(entity.getTaint());
        
        
            
        
        
            
        
        
            
        
        
        
        
    }

    
}

