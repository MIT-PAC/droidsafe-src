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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.880 -0400", hash_original_field = "D326C2B6E95F9CF98B4A5DCB39DA6BE2", hash_generated_field = "6CE3FA3FF9DD066356D6790411FF1D54")

    protected HttpEntity wrappedEntity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.881 -0400", hash_original_method = "33160DF8469148C6436960E1E1B046E8", hash_generated_method = "7B412E7BE14F4942BF02478FE7CA746B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.882 -0400", hash_original_method = "66A5D6AE1E6AB86EE56321AB2307DFBE", hash_generated_method = "160E757C991289944C59097F4BCA5BC0")
    public boolean isRepeatable() {
        boolean var750619BE4D92F2F37FAA6C2235C144A5_579853433 = (wrappedEntity.isRepeatable());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_482387699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_482387699;
        // ---------- Original Method ----------
        //return wrappedEntity.isRepeatable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.882 -0400", hash_original_method = "9378790138EC2F8EEF6B9F1F6E40BE95", hash_generated_method = "2EC943427FE7AFA3ACEA554C70F5209F")
    public boolean isChunked() {
        boolean var7BCD3D498F1AC6A0FA3A04DF940896CD_2061694529 = (wrappedEntity.isChunked());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1207713060 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1207713060;
        // ---------- Original Method ----------
        //return wrappedEntity.isChunked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.882 -0400", hash_original_method = "0FBEEBE2CCF30C86364D7AFCA680099F", hash_generated_method = "E30C311AE92AE469E55F00A6ED20E8F0")
    public long getContentLength() {
        long var74FB159CC189DFB73157E7A17095FEDE_1619248438 = (wrappedEntity.getContentLength());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2098166267 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2098166267;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.883 -0400", hash_original_method = "FA7C53183DDD1E469C3D069CC9C24FBF", hash_generated_method = "6F5C5CBE1C8BE11D9150291471830CD2")
    public Header getContentType() {
        Header varB4EAC82CA7396A68D541C85D26508E83_1892931029 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1892931029 = wrappedEntity.getContentType();
        varB4EAC82CA7396A68D541C85D26508E83_1892931029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1892931029;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentType();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.885 -0400", hash_original_method = "09414FECE5ABE9B3537B6C0C8466B754", hash_generated_method = "7265503BC853090EB4B963224BE5140C")
    public Header getContentEncoding() {
        Header varB4EAC82CA7396A68D541C85D26508E83_149851515 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_149851515 = wrappedEntity.getContentEncoding();
        varB4EAC82CA7396A68D541C85D26508E83_149851515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_149851515;
        // ---------- Original Method ----------
        //return wrappedEntity.getContentEncoding();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.885 -0400", hash_original_method = "DDB93A3EE1E007696449240BA2D658FB", hash_generated_method = "CED3B507D0548C4122EB8BEA20B6BF03")
    public InputStream getContent() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_609884006 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_609884006 = wrappedEntity.getContent();
        varB4EAC82CA7396A68D541C85D26508E83_609884006.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_609884006;
        // ---------- Original Method ----------
        //return wrappedEntity.getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.886 -0400", hash_original_method = "AB7D45D5A15CAF2F20DF541B4637AB99", hash_generated_method = "F428BEA343364BFCCFAEA2F292F9451C")
    public void writeTo(OutputStream outstream) throws IOException {
        wrappedEntity.writeTo(outstream);
        addTaint(outstream.getTaint());
        // ---------- Original Method ----------
        //wrappedEntity.writeTo(outstream);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.886 -0400", hash_original_method = "0A035D35D476DBE850196C054D458020", hash_generated_method = "0A18881AEB130A5EF6FA95F3BCFC1B29")
    public boolean isStreaming() {
        boolean varAF6BD3DD5E8866794AC60EB31F00EB0F_407303869 = (wrappedEntity.isStreaming());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1362392339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1362392339;
        // ---------- Original Method ----------
        //return wrappedEntity.isStreaming();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.886 -0400", hash_original_method = "D38253ACE34121886ACB6BC0EC310CC5", hash_generated_method = "B8262C4ECF5B4F1C60F7AA5E1B2551F2")
    public void consumeContent() throws IOException {
        wrappedEntity.consumeContent();
        // ---------- Original Method ----------
        //wrappedEntity.consumeContent();
    }

    
}

