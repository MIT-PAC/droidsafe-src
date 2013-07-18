package org.apache.http.entity;

// Droidsafe Imports
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class BufferedHttpEntity extends HttpEntityWrapper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.236 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "67DBC7965A32AEE1CAB7B25294021930")

    private byte[] buffer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.247 -0400", hash_original_method = "9933624B15A1F62492A5E829A3A364D0", hash_generated_method = "34411053CF28BA65BDAD703427BE5863")
    public  BufferedHttpEntity(final HttpEntity entity) throws IOException {
        super(entity);
        if(!entity.isRepeatable() || entity.getContentLength() < 0)        
        {
            this.buffer = EntityUtils.toByteArray(entity);
        } //End block
        else
        {
            this.buffer = null;
        } //End block
        // ---------- Original Method ----------
        //if (!entity.isRepeatable() || entity.getContentLength() < 0) {
            //this.buffer = EntityUtils.toByteArray(entity);
        //} else {
            //this.buffer = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.248 -0400", hash_original_method = "26AA3A162E430A9FEBBBBE7476A32626", hash_generated_method = "89CF2D207425D2C8DEF1667333A09AE8")
    public long getContentLength() {
        if(this.buffer != null)        
        {
            long var52B286FBAC396E14EB741753BEC48E2E_786359027 = (this.buffer.length);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1765056367 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1765056367;
        } //End block
        else
        {
            long varE16A3D9A28884C197B737656D3267561_1748651151 = (wrappedEntity.getContentLength());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1452177457 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1452177457;
        } //End block
        // ---------- Original Method ----------
        //if (this.buffer != null) {
            //return this.buffer.length;
        //} else {
            //return wrappedEntity.getContentLength();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.248 -0400", hash_original_method = "C66624A0F56D5B3373911F6483E82581", hash_generated_method = "665E98BF087D054D5E1EB52B4CB85DE1")
    public InputStream getContent() throws IOException {
        if(this.buffer != null)        
        {
InputStream varFB8BC527E57C1094D1FA48F51FC1BD49_1561635265 =             new ByteArrayInputStream(this.buffer);
            varFB8BC527E57C1094D1FA48F51FC1BD49_1561635265.addTaint(taint);
            return varFB8BC527E57C1094D1FA48F51FC1BD49_1561635265;
        } //End block
        else
        {
InputStream varF6ACD77A5F5C16B8B8AB61A8E0321333_824349158 =             wrappedEntity.getContent();
            varF6ACD77A5F5C16B8B8AB61A8E0321333_824349158.addTaint(taint);
            return varF6ACD77A5F5C16B8B8AB61A8E0321333_824349158;
        } //End block
        // ---------- Original Method ----------
        //if (this.buffer != null) {
            //return new ByteArrayInputStream(this.buffer);
        //} else {
            //return wrappedEntity.getContent();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.248 -0400", hash_original_method = "2A121AFE9268A901CC611E90FC00D0E8", hash_generated_method = "CC49D171D7F780462D89837F96B9CB51")
    public boolean isChunked() {
        boolean varEDC1D0D5ABDB221CF275D0292D0CB0A7_2002702624 = ((buffer == null) && wrappedEntity.isChunked());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2135986407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2135986407;
        // ---------- Original Method ----------
        //return (buffer == null) && wrappedEntity.isChunked();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.248 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "1041D669569FAC7AE82FC23882272721")
    public boolean isRepeatable() {
        boolean varB326B5062B2F0E69046810717534CB09_1775769101 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1352988794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1352988794;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.248 -0400", hash_original_method = "6978AFF2D6BA6FB48D86DE86B3A93492", hash_generated_method = "A71CC268CCA2EE0E37EBEE72613B23F3")
    public void writeTo(final OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        if(outstream == null)        
        {
            IllegalArgumentException var8C9256F172D6E7DD26CC6F974ABC4716_318167720 = new IllegalArgumentException("Output stream may not be null");
            var8C9256F172D6E7DD26CC6F974ABC4716_318167720.addTaint(taint);
            throw var8C9256F172D6E7DD26CC6F974ABC4716_318167720;
        } //End block
        if(this.buffer != null)        
        {
            outstream.write(this.buffer);
        } //End block
        else
        {
            wrappedEntity.writeTo(outstream);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.248 -0400", hash_original_method = "298A03178432926E5E6E7F0EA9A50E03", hash_generated_method = "1C06E706B10A826BA8C9341133FBF1B9")
    public boolean isStreaming() {
        boolean var3E6A1689093D41868EEEA62EB3AFDCAD_436194721 = ((buffer == null) && wrappedEntity.isStreaming());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1860275755 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1860275755;
        // ---------- Original Method ----------
        //return (buffer == null) && wrappedEntity.isStreaming();
    }

    
}

