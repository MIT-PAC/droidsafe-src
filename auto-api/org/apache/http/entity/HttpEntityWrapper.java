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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.883 -0400", hash_original_field = "D326C2B6E95F9CF98B4A5DCB39DA6BE2", hash_generated_field = "6CE3FA3FF9DD066356D6790411FF1D54")

    protected HttpEntity wrappedEntity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.884 -0400", hash_original_method = "33160DF8469148C6436960E1E1B046E8", hash_generated_method = "7B412E7BE14F4942BF02478FE7CA746B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.884 -0400", hash_original_method = "66A5D6AE1E6AB86EE56321AB2307DFBE", hash_generated_method = "1AE40B5B852F7CBC23F2C85A069F6B98")
    public boolean isRepeatable() {
        boolean var750619BE4D92F2F37FAA6C2235C144A5_267156533 = (wrappedEntity.isRepeatable());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_843985392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_843985392;
        // ---------- Original Method ----------
        //return wrappedEntity.isRepeatable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.884 -0400", hash_original_method = "9378790138EC2F8EEF6B9F1F6E40BE95", hash_generated_method = "52ADD0B914EA3D21549B289A8B6A2D87")
    public boolean isChunked() {
        boolean var7BCD3D498F1AC6A0FA3A04DF940896CD_446717742 = (wrappedEntity.isChunked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1992010778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1992010778;
        // ---------- Original Method ----------
        //return wrappedEntity.isChunked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.885 -0400", hash_original_method = "0FBEEBE2CCF30C86364D7AFCA680099F", hash_generated_method = "4E363A2DD1ABE415F6FAF6E2B3034B87")
    public long getContentLength() {
        long var74FB159CC189DFB73157E7A17095FEDE_1753366536 = (wrappedEntity.getContentLength());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1445607236 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1445607236;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.885 -0400", hash_original_method = "FA7C53183DDD1E469C3D069CC9C24FBF", hash_generated_method = "EE88ACF952A61DFA6F1D7DE08061060E")
    public Header getContentType() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1347089614 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1347089614 = wrappedEntity.getContentType();
        varB4EAC82CA7396A68D541C85D26508E83_1347089614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1347089614;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.886 -0400", hash_original_method = "09414FECE5ABE9B3537B6C0C8466B754", hash_generated_method = "7A7C82D180068E6E5BE5935A76E86EBE")
    public Header getContentEncoding() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1683187329 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1683187329 = wrappedEntity.getContentEncoding();
        varB4EAC82CA7396A68D541C85D26508E83_1683187329.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1683187329;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentEncoding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.891 -0400", hash_original_method = "DDB93A3EE1E007696449240BA2D658FB", hash_generated_method = "1602A5DF3BD955B5C80B9D6342A82338")
    public InputStream getContent() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_832721244 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_832721244 = wrappedEntity.getContent();
        varB4EAC82CA7396A68D541C85D26508E83_832721244.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_832721244;
        // ---------- Original Method ----------
        //return wrappedEntity.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.892 -0400", hash_original_method = "AB7D45D5A15CAF2F20DF541B4637AB99", hash_generated_method = "F428BEA343364BFCCFAEA2F292F9451C")
    public void writeTo(OutputStream outstream) throws IOException {
        wrappedEntity.writeTo(outstream);
        addTaint(outstream.getTaint());
        // ---------- Original Method ----------
        //wrappedEntity.writeTo(outstream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.893 -0400", hash_original_method = "0A035D35D476DBE850196C054D458020", hash_generated_method = "70E97A3E2C42E3C9FE9216DC595E828D")
    public boolean isStreaming() {
        boolean varAF6BD3DD5E8866794AC60EB31F00EB0F_1796645955 = (wrappedEntity.isStreaming());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1252718140 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1252718140;
        // ---------- Original Method ----------
        //return wrappedEntity.isStreaming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.898 -0400", hash_original_method = "D38253ACE34121886ACB6BC0EC310CC5", hash_generated_method = "B8262C4ECF5B4F1C60F7AA5E1B2551F2")
    public void consumeContent() throws IOException {
        wrappedEntity.consumeContent();
        // ---------- Original Method ----------
        //wrappedEntity.consumeContent();
    }

    
}

