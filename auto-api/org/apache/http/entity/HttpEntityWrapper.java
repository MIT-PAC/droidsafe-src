package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;

public class HttpEntityWrapper implements HttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.613 -0400", hash_original_field = "D326C2B6E95F9CF98B4A5DCB39DA6BE2", hash_generated_field = "6CE3FA3FF9DD066356D6790411FF1D54")

    protected HttpEntity wrappedEntity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.613 -0400", hash_original_method = "33160DF8469148C6436960E1E1B046E8", hash_generated_method = "7B412E7BE14F4942BF02478FE7CA746B")
    public  HttpEntityWrapper(HttpEntity wrapped) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("wrapped entity must not be null");
        } //End block
        wrappedEntity = wrapped;
        // ---------- Original Method ----------
        //if (wrapped == null) {
            //throw new IllegalArgumentException
                //("wrapped entity must not be null");
        //}
        //wrappedEntity = wrapped;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.614 -0400", hash_original_method = "66A5D6AE1E6AB86EE56321AB2307DFBE", hash_generated_method = "A7D851B32B3F7E56F102C5C0C9573D82")
    public boolean isRepeatable() {
        boolean var750619BE4D92F2F37FAA6C2235C144A5_1780520272 = (wrappedEntity.isRepeatable());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2048835696 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2048835696;
        // ---------- Original Method ----------
        //return wrappedEntity.isRepeatable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.614 -0400", hash_original_method = "9378790138EC2F8EEF6B9F1F6E40BE95", hash_generated_method = "4AAEAC5E7BBAEDB7DA3EADC4B68B7DEE")
    public boolean isChunked() {
        boolean var7BCD3D498F1AC6A0FA3A04DF940896CD_1774128800 = (wrappedEntity.isChunked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_182276667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_182276667;
        // ---------- Original Method ----------
        //return wrappedEntity.isChunked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.615 -0400", hash_original_method = "0FBEEBE2CCF30C86364D7AFCA680099F", hash_generated_method = "22E6C11ADE838E99352457D643B96210")
    public long getContentLength() {
        long var74FB159CC189DFB73157E7A17095FEDE_2111873553 = (wrappedEntity.getContentLength());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1727126310 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1727126310;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.616 -0400", hash_original_method = "FA7C53183DDD1E469C3D069CC9C24FBF", hash_generated_method = "0728A6ED6CEEFDDB7E58F448FE4BB50A")
    public Header getContentType() {
        Header varB4EAC82CA7396A68D541C85D26508E83_2097189711 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2097189711 = wrappedEntity.getContentType();
        varB4EAC82CA7396A68D541C85D26508E83_2097189711.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2097189711;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.620 -0400", hash_original_method = "09414FECE5ABE9B3537B6C0C8466B754", hash_generated_method = "73F391490611BD94C1C789A2A4536E87")
    public Header getContentEncoding() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1408770594 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1408770594 = wrappedEntity.getContentEncoding();
        varB4EAC82CA7396A68D541C85D26508E83_1408770594.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1408770594;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentEncoding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.621 -0400", hash_original_method = "DDB93A3EE1E007696449240BA2D658FB", hash_generated_method = "38CF1027BE34C5DB42E2E9D702236881")
    public InputStream getContent() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1235687391 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1235687391 = wrappedEntity.getContent();
        varB4EAC82CA7396A68D541C85D26508E83_1235687391.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1235687391;
        // ---------- Original Method ----------
        //return wrappedEntity.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.622 -0400", hash_original_method = "AB7D45D5A15CAF2F20DF541B4637AB99", hash_generated_method = "F428BEA343364BFCCFAEA2F292F9451C")
    public void writeTo(OutputStream outstream) throws IOException {
        wrappedEntity.writeTo(outstream);
        addTaint(outstream.getTaint());
        // ---------- Original Method ----------
        //wrappedEntity.writeTo(outstream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.623 -0400", hash_original_method = "0A035D35D476DBE850196C054D458020", hash_generated_method = "49C09B54129ED483BFE07DD9DFA9047B")
    public boolean isStreaming() {
        boolean varAF6BD3DD5E8866794AC60EB31F00EB0F_1226476667 = (wrappedEntity.isStreaming());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_342372725 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_342372725;
        // ---------- Original Method ----------
        //return wrappedEntity.isStreaming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.623 -0400", hash_original_method = "D38253ACE34121886ACB6BC0EC310CC5", hash_generated_method = "B8262C4ECF5B4F1C60F7AA5E1B2551F2")
    public void consumeContent() throws IOException {
        wrappedEntity.consumeContent();
        // ---------- Original Method ----------
        //wrappedEntity.consumeContent();
    }

    
}

