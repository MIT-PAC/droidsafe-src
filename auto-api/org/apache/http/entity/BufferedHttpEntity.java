package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

public class BufferedHttpEntity extends HttpEntityWrapper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.868 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.880 -0400", hash_original_method = "9933624B15A1F62492A5E829A3A364D0", hash_generated_method = "DA3E714C0697A0614256D7F9CDFEB1E1")
    public  BufferedHttpEntity(final HttpEntity entity) throws IOException {
        super(entity);
        {
            boolean var42645DCCE1E77C405020D4089695E44D_709210374 = (!entity.isRepeatable() || entity.getContentLength() < 0);
            {
                this.buffer = EntityUtils.toByteArray(entity);
            } //End block
            {
                this.buffer = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (!entity.isRepeatable() || entity.getContentLength() < 0) {
            //this.buffer = EntityUtils.toByteArray(entity);
        //} else {
            //this.buffer = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.881 -0400", hash_original_method = "26AA3A162E430A9FEBBBBE7476A32626", hash_generated_method = "8973376559428C2973D0A7360F007CED")
    public long getContentLength() {
        {
            long varB6AA5DA0DD38948E6D83260B0102CBFF_1137613331 = (wrappedEntity.getContentLength());
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1641110933 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1641110933;
        // ---------- Original Method ----------
        //if (this.buffer != null) {
            //return this.buffer.length;
        //} else {
            //return wrappedEntity.getContentLength();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.881 -0400", hash_original_method = "C66624A0F56D5B3373911F6483E82581", hash_generated_method = "ADFC3E8E74D054AAC39CD0AC48B084A1")
    public InputStream getContent() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_12412721 = null; //Variable for return #1
        InputStream varB4EAC82CA7396A68D541C85D26508E83_2032669238 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_12412721 = new ByteArrayInputStream(this.buffer);
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2032669238 = wrappedEntity.getContent();
        } //End block
        InputStream varA7E53CE21691AB073D9660D615818899_1052227918; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1052227918 = varB4EAC82CA7396A68D541C85D26508E83_12412721;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1052227918 = varB4EAC82CA7396A68D541C85D26508E83_2032669238;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1052227918.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1052227918;
        // ---------- Original Method ----------
        //if (this.buffer != null) {
            //return new ByteArrayInputStream(this.buffer);
        //} else {
            //return wrappedEntity.getContent();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.887 -0400", hash_original_method = "2A121AFE9268A901CC611E90FC00D0E8", hash_generated_method = "AE2BD7B08E48F2CD17D02E024ED07B3D")
    public boolean isChunked() {
        boolean var5B8668F885218BF58EAEE896094735B0_1578960044 = ((buffer == null) && wrappedEntity.isChunked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1073503184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1073503184;
        // ---------- Original Method ----------
        //return (buffer == null) && wrappedEntity.isChunked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.887 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "E7D1D954E4CDB96B80494476761D24B5")
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922832805 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922832805;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.897 -0400", hash_original_method = "6978AFF2D6BA6FB48D86DE86B3A93492", hash_generated_method = "B91875387B08AEAA90BB8BC66D026C00")
    public void writeTo(final OutputStream outstream) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Output stream may not be null");
        } //End block
        {
            outstream.write(this.buffer);
        } //End block
        {
            wrappedEntity.writeTo(outstream);
        } //End block
        addTaint(outstream.getTaint());
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output stream may not be null");
        //}
        //if (this.buffer != null) {
            //outstream.write(this.buffer);
        //} else {
            //wrappedEntity.writeTo(outstream);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.897 -0400", hash_original_method = "298A03178432926E5E6E7F0EA9A50E03", hash_generated_method = "0BBCD0B72B53B829B7B2BF92A4938EFD")
    public boolean isStreaming() {
        boolean var9EEC56ECE9813C929E1EF0389C57597D_1097915986 = ((buffer == null) && wrappedEntity.isStreaming());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_891448732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_891448732;
        // ---------- Original Method ----------
        //return (buffer == null) && wrappedEntity.isStreaming();
    }

    
}

