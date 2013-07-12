package org.apache.http.entity;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class HttpEntityWrapper implements HttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.949 -0400", hash_original_field = "D326C2B6E95F9CF98B4A5DCB39DA6BE2", hash_generated_field = "6CE3FA3FF9DD066356D6790411FF1D54")

    protected HttpEntity wrappedEntity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.950 -0400", hash_original_method = "33160DF8469148C6436960E1E1B046E8", hash_generated_method = "743D805B1FCFD31B904D5BC4357235DB")
    public  HttpEntityWrapper(HttpEntity wrapped) {
        super();
    if(wrapped == null)        
        {
            IllegalArgumentException var891221892810DF8BECFD57BEC0767C7B_175850901 = new IllegalArgumentException
                ("wrapped entity must not be null");
            var891221892810DF8BECFD57BEC0767C7B_175850901.addTaint(taint);
            throw var891221892810DF8BECFD57BEC0767C7B_175850901;
        } 
        wrappedEntity = wrapped;
        
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.950 -0400", hash_original_method = "66A5D6AE1E6AB86EE56321AB2307DFBE", hash_generated_method = "089E4AC673F0190EAB81C7748C9D1183")
    public boolean isRepeatable() {
        boolean var9B05981995E2CC50F5B2959ADB42FEAD_430774410 = (wrappedEntity.isRepeatable());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1224882689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1224882689;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.950 -0400", hash_original_method = "9378790138EC2F8EEF6B9F1F6E40BE95", hash_generated_method = "5CF987ECB65A259D098E4989840E59DA")
    public boolean isChunked() {
        boolean varC45756BB83310DF83D8CA2EF7D5FA04A_2089039443 = (wrappedEntity.isChunked());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1681593516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1681593516;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.950 -0400", hash_original_method = "0FBEEBE2CCF30C86364D7AFCA680099F", hash_generated_method = "65EE6E6CDFA073779CEB5D2D3A9E8A33")
    public long getContentLength() {
        long varE16A3D9A28884C197B737656D3267561_1975306861 = (wrappedEntity.getContentLength());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2003238145 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2003238145;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.951 -0400", hash_original_method = "FA7C53183DDD1E469C3D069CC9C24FBF", hash_generated_method = "BFBB7C6331AC9643402D00AA50B823F3")
    public Header getContentType() {
Header var590535281942B049533B59980AFA506D_1877479784 =         wrappedEntity.getContentType();
        var590535281942B049533B59980AFA506D_1877479784.addTaint(taint);
        return var590535281942B049533B59980AFA506D_1877479784;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.951 -0400", hash_original_method = "09414FECE5ABE9B3537B6C0C8466B754", hash_generated_method = "33B9A8C98C8035897C893D1492B8B5FC")
    public Header getContentEncoding() {
Header var0AA5129D0D17831211E9BEAEA729D4E5_71309972 =         wrappedEntity.getContentEncoding();
        var0AA5129D0D17831211E9BEAEA729D4E5_71309972.addTaint(taint);
        return var0AA5129D0D17831211E9BEAEA729D4E5_71309972;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.951 -0400", hash_original_method = "DDB93A3EE1E007696449240BA2D658FB", hash_generated_method = "1422F813D4D7390D130B63A1D2A2D732")
    public InputStream getContent() throws IOException {
InputStream varF6ACD77A5F5C16B8B8AB61A8E0321333_550231487 =         wrappedEntity.getContent();
        varF6ACD77A5F5C16B8B8AB61A8E0321333_550231487.addTaint(taint);
        return varF6ACD77A5F5C16B8B8AB61A8E0321333_550231487;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.951 -0400", hash_original_method = "AB7D45D5A15CAF2F20DF541B4637AB99", hash_generated_method = "92D8AF4EE3A6932E6EB5045201D44F0A")
    public void writeTo(OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        wrappedEntity.writeTo(outstream);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.951 -0400", hash_original_method = "0A035D35D476DBE850196C054D458020", hash_generated_method = "CACC67CCC08D30C99C0B14FE5B826D10")
    public boolean isStreaming() {
        boolean varA1379DC23CA041DAFBB19393B6C62948_399115862 = (wrappedEntity.isStreaming());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69628975 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69628975;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.952 -0400", hash_original_method = "D38253ACE34121886ACB6BC0EC310CC5", hash_generated_method = "B8262C4ECF5B4F1C60F7AA5E1B2551F2")
    public void consumeContent() throws IOException {
        wrappedEntity.consumeContent();
        
        
    }

    
}

