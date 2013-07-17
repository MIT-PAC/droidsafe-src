package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BasicHttpEntity extends AbstractHttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.211 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "E10265C22C3282384A3FF9B20A322BFE")

    private InputStream content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.212 -0400", hash_original_field = "516B89C2901255DCB4FAEF46CBC2D6CE", hash_generated_field = "F83D62FF33880A5C9450BAF66AEC5A3C")

    private boolean contentObtained;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.212 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C62D106264E132930C7955708C9A9CDD")

    private long length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.212 -0400", hash_original_method = "6C56C11F8A570F150FD118B6F4CE07D0", hash_generated_method = "422F155C0F38937E2C1FE41DC8DFE07C")
    public  BasicHttpEntity() {
        super();
        this.length = -1;
        // ---------- Original Method ----------
        //this.length = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.213 -0400", hash_original_method = "120309BFFDD6935F8B30886147626A04", hash_generated_method = "27FBF73D0A425974E9305A980EB7AF5D")
    public long getContentLength() {
        long varB9E8DC303FCECCA10418D2C0EA295E0F_1313012765 = (this.length);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1051295442 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1051295442;
        // ---------- Original Method ----------
        //return this.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.214 -0400", hash_original_method = "DD43DF1BE34625633489098C75403E56", hash_generated_method = "12D8D80225BA20429A74E10B41551D26")
    public InputStream getContent() throws IllegalStateException {
        if(this.content == null)        
        {
            IllegalStateException varEB19220DAA75124884B5A5F0A5B1358C_251401274 = new IllegalStateException("Content has not been provided");
            varEB19220DAA75124884B5A5F0A5B1358C_251401274.addTaint(taint);
            throw varEB19220DAA75124884B5A5F0A5B1358C_251401274;
        } //End block
        if(this.contentObtained)        
        {
            IllegalStateException var55F452EC1C6805B1D6D5FE9B207E920E_1951382377 = new IllegalStateException("Content has been consumed");
            var55F452EC1C6805B1D6D5FE9B207E920E_1951382377.addTaint(taint);
            throw var55F452EC1C6805B1D6D5FE9B207E920E_1951382377;
        } //End block
        this.contentObtained = true;
InputStream var5B4E22E160A1A738CCEDC8C85B064397_108912998 =         this.content;
        var5B4E22E160A1A738CCEDC8C85B064397_108912998.addTaint(taint);
        return var5B4E22E160A1A738CCEDC8C85B064397_108912998;
        // ---------- Original Method ----------
        //if (this.content == null) {
            //throw new IllegalStateException("Content has not been provided");
        //}
        //if (this.contentObtained) {
            //throw new IllegalStateException("Content has been consumed");
        //}
        //this.contentObtained = true;
        //return this.content;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.215 -0400", hash_original_method = "731D88F5D8865617BA362DCED4C30896", hash_generated_method = "68D0E7879B03AD49C80B4B64BD4597ED")
    public boolean isRepeatable() {
        boolean var68934A3E9455FA72420237EB05902327_1954725328 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_223029963 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_223029963;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.216 -0400", hash_original_method = "7EB1D34B8B79AC60227ACAB040078324", hash_generated_method = "727B385E1B6CC2143FAFA858B4B3D854")
    public void setContentLength(long len) {
        this.length = len;
        // ---------- Original Method ----------
        //this.length = len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.218 -0400", hash_original_method = "9243F298C9B144B2EDE1C1ED14CD424D", hash_generated_method = "5E27285ED6D5A57AA981DC542F0CB0AA")
    public void setContent(final InputStream instream) {
        this.content = instream;
        this.contentObtained = false;
        // ---------- Original Method ----------
        //this.content = instream;
        //this.contentObtained = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.219 -0400", hash_original_method = "4D2C7455ACC84C8F2AC9220CC460CB0C", hash_generated_method = "38DEA44FDD7AADB0ADBAC42C8E64E3E2")
    public void writeTo(final OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        if(outstream == null)        
        {
            IllegalArgumentException var8C9256F172D6E7DD26CC6F974ABC4716_306105825 = new IllegalArgumentException("Output stream may not be null");
            var8C9256F172D6E7DD26CC6F974ABC4716_306105825.addTaint(taint);
            throw var8C9256F172D6E7DD26CC6F974ABC4716_306105825;
        } //End block
        InputStream instream = getContent();
        int l;
        byte[] tmp = new byte[2048];
        while
((l = instream.read(tmp)) != -1)        
        {
            outstream.write(tmp, 0, l);
        } //End block
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output stream may not be null");
        //}
        //InputStream instream = getContent();
        //int l;
        //byte[] tmp = new byte[2048];
        //while ((l = instream.read(tmp)) != -1) {
            //outstream.write(tmp, 0, l);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.220 -0400", hash_original_method = "12B60AB15F5876110075CCE154554A33", hash_generated_method = "585352E6141CCFE6ADE5FB8E059AA47D")
    public boolean isStreaming() {
        boolean varB5BC9C92D105767A96B2D82FEBEBBB3B_2124171490 = (!this.contentObtained && this.content != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1156344756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1156344756;
        // ---------- Original Method ----------
        //return !this.contentObtained && this.content != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.221 -0400", hash_original_method = "DCFF80E870BC55BBCCB28CB7928D312B", hash_generated_method = "5478524E96912DE3DA4F0CACC6449FE5")
    public void consumeContent() throws IOException {
        if(content != null)        
        {
            content.close();
        } //End block
        // ---------- Original Method ----------
        //if (content != null) {
            //content.close(); 
        //}
    }

    
}

