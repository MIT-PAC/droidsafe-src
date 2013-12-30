package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ByteArrayOutputStream;
public class SerializableEntity extends AbstractHttpEntity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.177 -0500", hash_original_field = "C36D1E2F5E375E8641C86FB595FB0653", hash_generated_field = "5E992B0B880ECD381D3DDEA22743FFE2")

    
    private byte[] objSer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.180 -0500", hash_original_field = "530231EA78B6189A4C02EACEE06CA19A", hash_generated_field = "DEF28E95A6CF8B60225389E7AE432494")

    
    private Serializable objRef;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.183 -0500", hash_original_method = "50E1D3F23CF8DFFC0168609829D105B6", hash_generated_method = "9FE403BC3841C398BC23BCA964613631")
    
public SerializableEntity(Serializable ser, boolean bufferize) throws IOException {
        super();
        if (ser == null) {
            throw new IllegalArgumentException("Source object may not be null");
        }
        
        if (bufferize) {
            createBytes(ser);
        } else {
            this.objRef = ser;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.187 -0500", hash_original_method = "F8F96B1EFE3C5408C7469562A006AE42", hash_generated_method = "036AD32E5F4C881115E91AD8D895EB38")
    
private void createBytes(Serializable ser) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(ser);
        out.flush();	
        this.objSer = baos.toByteArray();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.189 -0500", hash_original_method = "41C62F9ED6209D6FC57675AB476C6A9C", hash_generated_method = "EAFE3C65EBC2C318522248C2A50F220A")
    
public InputStream getContent() throws IOException, IllegalStateException {
        if (this.objSer == null) {
            createBytes(this.objRef);
        }
        return new ByteArrayInputStream(this.objSer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.191 -0500", hash_original_method = "A561CA8D724D7AB3B72F0BCAFCE9F723", hash_generated_method = "67404975969B922529280569584854D6")
    
public long getContentLength() {
        if (this.objSer ==  null) { 
            return -1;
        } else {
            return this.objSer.length;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.193 -0500", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "827F310DEB1F388C181FD1C8E221D99B")
    
public boolean isRepeatable() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.195 -0500", hash_original_method = "4B9BA0750731747351E989E259D272E6", hash_generated_method = "F695F6F273E8A9A82DDC73EE3A614E21")
    
public boolean isStreaming() {
        return this.objSer == null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:45.198 -0500", hash_original_method = "777BCC972B9546F96E8BA640E747E34D", hash_generated_method = "2CE57D569CD61F2056A881C3023EC56A")
    
public void writeTo(OutputStream outstream) throws IOException {
        if (outstream == null) {
            throw new IllegalArgumentException("Output stream may not be null");
        }
        
        if (this.objSer == null) {
            ObjectOutputStream out = new ObjectOutputStream(outstream);
            out.writeObject(this.objRef);
            out.flush();
        } else {
            outstream.write(this.objSer);
            outstream.flush();
        }
    }

    
}

