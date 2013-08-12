package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;




public class HttpEntityWrapper implements HttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.257 -0400", hash_original_field = "D326C2B6E95F9CF98B4A5DCB39DA6BE2", hash_generated_field = "6CE3FA3FF9DD066356D6790411FF1D54")

    protected HttpEntity wrappedEntity;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.258 -0400", hash_original_method = "33160DF8469148C6436960E1E1B046E8", hash_generated_method = "6C37F122ED33968AC986F7F761C17BB6")
    public  HttpEntityWrapper(HttpEntity wrapped) {
        super();
        if(wrapped == null)        
        {
            IllegalArgumentException var891221892810DF8BECFD57BEC0767C7B_857538353 = new IllegalArgumentException
                ("wrapped entity must not be null");
            var891221892810DF8BECFD57BEC0767C7B_857538353.addTaint(taint);
            throw var891221892810DF8BECFD57BEC0767C7B_857538353;
        } //End block
        wrappedEntity = wrapped;
        // ---------- Original Method ----------
        //if (wrapped == null) {
            //throw new IllegalArgumentException
                //("wrapped entity must not be null");
        //}
        //wrappedEntity = wrapped;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.258 -0400", hash_original_method = "66A5D6AE1E6AB86EE56321AB2307DFBE", hash_generated_method = "CA7C01566F5D9EEBD363A52D721E1E6E")
    public boolean isRepeatable() {
        boolean var9B05981995E2CC50F5B2959ADB42FEAD_829023517 = (wrappedEntity.isRepeatable());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1421445987 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1421445987;
        // ---------- Original Method ----------
        //return wrappedEntity.isRepeatable();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.258 -0400", hash_original_method = "9378790138EC2F8EEF6B9F1F6E40BE95", hash_generated_method = "E67E8CF61AD5D5F59E8E6DDFC1C6A023")
    public boolean isChunked() {
        boolean varC45756BB83310DF83D8CA2EF7D5FA04A_1502684085 = (wrappedEntity.isChunked());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1346910946 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1346910946;
        // ---------- Original Method ----------
        //return wrappedEntity.isChunked();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.259 -0400", hash_original_method = "0FBEEBE2CCF30C86364D7AFCA680099F", hash_generated_method = "EBE428CF7707776648B16FAEF01A97E1")
    public long getContentLength() {
        long varE16A3D9A28884C197B737656D3267561_1346499934 = (wrappedEntity.getContentLength());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1608855046 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1608855046;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentLength();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.259 -0400", hash_original_method = "FA7C53183DDD1E469C3D069CC9C24FBF", hash_generated_method = "9A96628CEA464001A147F28C205DE6E0")
    public Header getContentType() {
Header var590535281942B049533B59980AFA506D_516971484 =         wrappedEntity.getContentType();
        var590535281942B049533B59980AFA506D_516971484.addTaint(taint);
        return var590535281942B049533B59980AFA506D_516971484;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentType();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.259 -0400", hash_original_method = "09414FECE5ABE9B3537B6C0C8466B754", hash_generated_method = "CEBA331F04C4EB923543488AFB9C31B1")
    public Header getContentEncoding() {
Header var0AA5129D0D17831211E9BEAEA729D4E5_1010119539 =         wrappedEntity.getContentEncoding();
        var0AA5129D0D17831211E9BEAEA729D4E5_1010119539.addTaint(taint);
        return var0AA5129D0D17831211E9BEAEA729D4E5_1010119539;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentEncoding();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.259 -0400", hash_original_method = "DDB93A3EE1E007696449240BA2D658FB", hash_generated_method = "F079B130AD74734E1E64CAE148CA1E9A")
    public InputStream getContent() throws IOException {
InputStream varF6ACD77A5F5C16B8B8AB61A8E0321333_209149113 =         wrappedEntity.getContent();
        varF6ACD77A5F5C16B8B8AB61A8E0321333_209149113.addTaint(taint);
        return varF6ACD77A5F5C16B8B8AB61A8E0321333_209149113;
        // ---------- Original Method ----------
        //return wrappedEntity.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.260 -0400", hash_original_method = "AB7D45D5A15CAF2F20DF541B4637AB99", hash_generated_method = "92D8AF4EE3A6932E6EB5045201D44F0A")
    public void writeTo(OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        wrappedEntity.writeTo(outstream);
        // ---------- Original Method ----------
        //wrappedEntity.writeTo(outstream);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.260 -0400", hash_original_method = "0A035D35D476DBE850196C054D458020", hash_generated_method = "121E7689700A62C0A440A7A4C8F49360")
    public boolean isStreaming() {
        boolean varA1379DC23CA041DAFBB19393B6C62948_795102101 = (wrappedEntity.isStreaming());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064285083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064285083;
        // ---------- Original Method ----------
        //return wrappedEntity.isStreaming();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.260 -0400", hash_original_method = "D38253ACE34121886ACB6BC0EC310CC5", hash_generated_method = "B8262C4ECF5B4F1C60F7AA5E1B2551F2")
    public void consumeContent() throws IOException {
        wrappedEntity.consumeContent();
        // ---------- Original Method ----------
        //wrappedEntity.consumeContent();
    }

    
}

