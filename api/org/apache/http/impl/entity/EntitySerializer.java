package org.apache.http.impl.entity;

// Droidsafe Imports
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

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class EntitySerializer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.299 -0400", hash_original_field = "27B348194FA2C44245DD354AB07C0458", hash_generated_field = "ADE4068D7F9D27835F9860151E36C4D1")

    private ContentLengthStrategy lenStrategy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.301 -0400", hash_original_method = "6A84330A1DEB7B7037DF31B55F2620FD", hash_generated_method = "3DF4460BCA2F70829FF28734C2C462A8")
    public  EntitySerializer(final ContentLengthStrategy lenStrategy) {
        super();
        if(lenStrategy == null)        
        {
            IllegalArgumentException var2ED90DC28C31D7F9E7A793F1A6612732_31311635 = new IllegalArgumentException("Content length strategy may not be null");
            var2ED90DC28C31D7F9E7A793F1A6612732_31311635.addTaint(taint);
            throw var2ED90DC28C31D7F9E7A793F1A6612732_31311635;
        } //End block
        this.lenStrategy = lenStrategy;
        // ---------- Original Method ----------
        //if (lenStrategy == null) {
            //throw new IllegalArgumentException("Content length strategy may not be null");
        //}
        //this.lenStrategy = lenStrategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.303 -0400", hash_original_method = "6B5C9440DDF8E3FBB590642D99DA80CB", hash_generated_method = "7944731C6FC41B6E88D2D9826D34253E")
    protected OutputStream doSerialize(
            final SessionOutputBuffer outbuffer,
            final HttpMessage message) throws HttpException, IOException {
        addTaint(message.getTaint());
        addTaint(outbuffer.getTaint());
        long len = this.lenStrategy.determineLength(message);
        if(len == ContentLengthStrategy.CHUNKED)        
        {
OutputStream var34B20F477A1C9747FC8E22CA83D1E053_1190640758 =             new ChunkedOutputStream(outbuffer);
            var34B20F477A1C9747FC8E22CA83D1E053_1190640758.addTaint(taint);
            return var34B20F477A1C9747FC8E22CA83D1E053_1190640758;
        } //End block
        else
        if(len == ContentLengthStrategy.IDENTITY)        
        {
OutputStream var3F43E1680B7209AAE027AB524FFB8ABC_1961013087 =             new IdentityOutputStream(outbuffer);
            var3F43E1680B7209AAE027AB524FFB8ABC_1961013087.addTaint(taint);
            return var3F43E1680B7209AAE027AB524FFB8ABC_1961013087;
        } //End block
        else
        {
OutputStream varC70AA7B701F6A379FFC7C55A4EAF1EE7_342090776 =             new ContentLengthOutputStream(outbuffer, len);
            varC70AA7B701F6A379FFC7C55A4EAF1EE7_342090776.addTaint(taint);
            return varC70AA7B701F6A379FFC7C55A4EAF1EE7_342090776;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.304 -0400", hash_original_method = "61D7ADAF4C31C152373CEA6CC3FA217A", hash_generated_method = "AED8863D2713E1059BD2579A8A568404")
    public void serialize(
            final SessionOutputBuffer outbuffer,
            final HttpMessage message,
            final HttpEntity entity) throws HttpException, IOException {
        addTaint(entity.getTaint());
        addTaint(message.getTaint());
        addTaint(outbuffer.getTaint());
        if(outbuffer == null)        
        {
            IllegalArgumentException var37F5C066C9D0ECEEAAAFE6FBC9B24E18_387793111 = new IllegalArgumentException("Session output buffer may not be null");
            var37F5C066C9D0ECEEAAAFE6FBC9B24E18_387793111.addTaint(taint);
            throw var37F5C066C9D0ECEEAAAFE6FBC9B24E18_387793111;
        } //End block
        if(message == null)        
        {
            IllegalArgumentException var1AA7713A32BCFE0974EC5B02C04D6E20_1675000994 = new IllegalArgumentException("HTTP message may not be null");
            var1AA7713A32BCFE0974EC5B02C04D6E20_1675000994.addTaint(taint);
            throw var1AA7713A32BCFE0974EC5B02C04D6E20_1675000994;
        } //End block
        if(entity == null)        
        {
            IllegalArgumentException varDB9CA28F6136097765A29928ABCD1C8A_1392578923 = new IllegalArgumentException("HTTP entity may not be null");
            varDB9CA28F6136097765A29928ABCD1C8A_1392578923.addTaint(taint);
            throw varDB9CA28F6136097765A29928ABCD1C8A_1392578923;
        } //End block
        OutputStream outstream = doSerialize(outbuffer, message);
        entity.writeTo(outstream);
        outstream.close();
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

