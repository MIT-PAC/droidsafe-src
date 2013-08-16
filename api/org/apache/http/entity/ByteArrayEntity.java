package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;






public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.251 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "5694DF6F087835D263272D46C49C87A7")

    protected byte[] content;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.252 -0400", hash_original_method = "85F43E7DC885CA97417C9F3E2732068E", hash_generated_method = "C1E581FD058F9E744AC822F2C28A6EDF")
    public  ByteArrayEntity(final byte[] b) {
        super();
        if(b == null)        
        {
            IllegalArgumentException var34B358B29BB5C3E485EDF7496E5DF046_1624547643 = new IllegalArgumentException("Source byte array may not be null");
            var34B358B29BB5C3E485EDF7496E5DF046_1624547643.addTaint(taint);
            throw var34B358B29BB5C3E485EDF7496E5DF046_1624547643;
        } //End block
        this.content = b;
        // ---------- Original Method ----------
        //if (b == null) {
            //throw new IllegalArgumentException("Source byte array may not be null");
        //}
        //this.content = b;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.252 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "098BA278EFCAC881425F2FB1DC432816")
    public boolean isRepeatable() {
        boolean varB326B5062B2F0E69046810717534CB09_1007190948 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_29127437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_29127437;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.252 -0400", hash_original_method = "161FF0185286748984501E39486F36ED", hash_generated_method = "33D14BE2022D5732381DB90058ACD35B")
    public long getContentLength() {
        long varFF3D4578F788B008DD2D7570337D294B_1967242154 = (this.content.length);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1840427101 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1840427101;
        // ---------- Original Method ----------
        //return this.content.length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.252 -0400", hash_original_method = "004C3F78EC3F500E7D7F762D94BAEB0E", hash_generated_method = "6E374596836A3D418E02104954FC3291")
    public InputStream getContent() {
InputStream varEFD22E670A1626295FDBD437906D30FE_748342161 =         new ByteArrayInputStream(this.content);
        varEFD22E670A1626295FDBD437906D30FE_748342161.addTaint(taint);
        return varEFD22E670A1626295FDBD437906D30FE_748342161;
        // ---------- Original Method ----------
        //return new ByteArrayInputStream(this.content);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.252 -0400", hash_original_method = "F9996C70B2856060246DFF92163DB1CA", hash_generated_method = "CB15D82E84241B1B5213EC10AC9A3BC5")
    public void writeTo(final OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        if(outstream == null)        
        {
            IllegalArgumentException var8C9256F172D6E7DD26CC6F974ABC4716_928536154 = new IllegalArgumentException("Output stream may not be null");
            var8C9256F172D6E7DD26CC6F974ABC4716_928536154.addTaint(taint);
            throw var8C9256F172D6E7DD26CC6F974ABC4716_928536154;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.252 -0400", hash_original_method = "1C9916E491D93B6DAF758D3D738C6EEB", hash_generated_method = "001A9267FDAC668603238A2929A4B6F5")
    public boolean isStreaming() {
        boolean var68934A3E9455FA72420237EB05902327_411884300 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_999889758 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_999889758;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.252 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "5D007952A2A94BFDBE205E97CBEF816D")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_148335629 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_148335629.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_148335629;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

