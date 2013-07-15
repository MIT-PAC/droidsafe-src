package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.935 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "5694DF6F087835D263272D46C49C87A7")

    protected byte[] content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.935 -0400", hash_original_method = "85F43E7DC885CA97417C9F3E2732068E", hash_generated_method = "E8BE85F78D40735D862738D0DE4CDB09")
    public  ByteArrayEntity(final byte[] b) {
        super();
    if(b == null)        
        {
            IllegalArgumentException var34B358B29BB5C3E485EDF7496E5DF046_1488842678 = new IllegalArgumentException("Source byte array may not be null");
            var34B358B29BB5C3E485EDF7496E5DF046_1488842678.addTaint(taint);
            throw var34B358B29BB5C3E485EDF7496E5DF046_1488842678;
        } //End block
        this.content = b;
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Source byte array may not be null");
        //}
        //this.content = b;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.936 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "040C1140A3D008EF6EE27A353A604B52")
    public boolean isRepeatable() {
        boolean varB326B5062B2F0E69046810717534CB09_51475802 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1837012782 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1837012782;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.937 -0400", hash_original_method = "161FF0185286748984501E39486F36ED", hash_generated_method = "C1C2A217E4413A89E46A3138D86FBB8E")
    public long getContentLength() {
        long varFF3D4578F788B008DD2D7570337D294B_990396490 = (this.content.length);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_24614517 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_24614517;
        // ---------- Original Method ----------
        //return this.content.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.938 -0400", hash_original_method = "004C3F78EC3F500E7D7F762D94BAEB0E", hash_generated_method = "2067FE5105EFE790251D9FDE29C5F5B2")
    public InputStream getContent() {
InputStream varEFD22E670A1626295FDBD437906D30FE_381162454 =         new ByteArrayInputStream(this.content);
        varEFD22E670A1626295FDBD437906D30FE_381162454.addTaint(taint);
        return varEFD22E670A1626295FDBD437906D30FE_381162454;
        // ---------- Original Method ----------
        //return new ByteArrayInputStream(this.content);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.939 -0400", hash_original_method = "F9996C70B2856060246DFF92163DB1CA", hash_generated_method = "27019B9985706243A3B36389C9C0B24E")
    public void writeTo(final OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
    if(outstream == null)        
        {
            IllegalArgumentException var8C9256F172D6E7DD26CC6F974ABC4716_749866160 = new IllegalArgumentException("Output stream may not be null");
            var8C9256F172D6E7DD26CC6F974ABC4716_749866160.addTaint(taint);
            throw var8C9256F172D6E7DD26CC6F974ABC4716_749866160;
        } //End block
        outstream.write(this.content);
        outstream.flush();
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output stream may not be null");
        //}
        //outstream.write(this.content);
        //outstream.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.939 -0400", hash_original_method = "1C9916E491D93B6DAF758D3D738C6EEB", hash_generated_method = "FA9C5DE607574E62EB4CEFA57E69D855")
    public boolean isStreaming() {
        boolean var68934A3E9455FA72420237EB05902327_646303520 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40694404 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_40694404;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.940 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "247D10C4E49DC7BA969D904DA7DFB6A1")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_1032325727 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_1032325727.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_1032325727;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

