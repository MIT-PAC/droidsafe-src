package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamEntity extends AbstractHttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.980 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "E10265C22C3282384A3FF9B20A322BFE")

    private InputStream content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.980 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C62D106264E132930C7955708C9A9CDD")

    private long length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.980 -0400", hash_original_field = "56ABCB31D60DF0EE33CD31B673E135E7", hash_generated_field = "7CAB7C0CCDF9ABBB1D6144ACE3ECB9F8")

    private boolean consumed = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.981 -0400", hash_original_method = "9ECB63D0474F50482B9F88A6526A3761", hash_generated_method = "0CD788DFAEB32DB222368F68AE405C30")
    public  InputStreamEntity(final InputStream instream, long length) {
        super();
    if(instream == null)        
        {
            IllegalArgumentException var8C64D95986F2B0977DCD566D17E0B673_355705882 = new IllegalArgumentException("Source input stream may not be null");
            var8C64D95986F2B0977DCD566D17E0B673_355705882.addTaint(taint);
            throw var8C64D95986F2B0977DCD566D17E0B673_355705882;
        } //End block
        this.content = instream;
        this.length = length;
        // ---------- Original Method ----------
        //if (instream == null) {
            //throw new IllegalArgumentException("Source input stream may not be null");
        //}
        //this.content = instream;
        //this.length = length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.981 -0400", hash_original_method = "731D88F5D8865617BA362DCED4C30896", hash_generated_method = "A03AB1ED5203EF75F4411FBFADB11A94")
    public boolean isRepeatable() {
        boolean var68934A3E9455FA72420237EB05902327_2085818802 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58424459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_58424459;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.981 -0400", hash_original_method = "120309BFFDD6935F8B30886147626A04", hash_generated_method = "FB0D54DACD6B689EA04BC83FA93AC929")
    public long getContentLength() {
        long varB9E8DC303FCECCA10418D2C0EA295E0F_462758058 = (this.length);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_37843421 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_37843421;
        // ---------- Original Method ----------
        //return this.length;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.981 -0400", hash_original_method = "ED2F9B5D6194544F22CDAF63FF5B39F6", hash_generated_method = "90CA8990B00AF49C322D8DDFB25374BD")
    public InputStream getContent() throws IOException {
InputStream var5B4E22E160A1A738CCEDC8C85B064397_546528831 =         this.content;
        var5B4E22E160A1A738CCEDC8C85B064397_546528831.addTaint(taint);
        return var5B4E22E160A1A738CCEDC8C85B064397_546528831;
        // ---------- Original Method ----------
        //return this.content;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.981 -0400", hash_original_method = "094DB6B8612142F129E3320AF13B6EB0", hash_generated_method = "A4150877486CAEBDA02ED3DE514470EB")
    public void writeTo(final OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
    if(outstream == null)        
        {
            IllegalArgumentException var8C9256F172D6E7DD26CC6F974ABC4716_1472298068 = new IllegalArgumentException("Output stream may not be null");
            var8C9256F172D6E7DD26CC6F974ABC4716_1472298068.addTaint(taint);
            throw var8C9256F172D6E7DD26CC6F974ABC4716_1472298068;
        } //End block
        InputStream instream = this.content;
        byte[] buffer = new byte[BUFFER_SIZE];
        int l;
    if(this.length < 0)        
        {
            while
((l = instream.read(buffer)) != -1)            
            {
                outstream.write(buffer, 0, l);
            } //End block
        } //End block
        else
        {
            long remaining = this.length;
            while
(remaining > 0)            
            {
                l = instream.read(buffer, 0, (int)Math.min(BUFFER_SIZE, remaining));
    if(l == -1)                
                {
                    break;
                } //End block
                outstream.write(buffer, 0, l);
                remaining -= l;
            } //End block
        } //End block
        this.consumed = true;
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output stream may not be null");
        //}
        //InputStream instream = this.content;
        //byte[] buffer = new byte[BUFFER_SIZE];
        //int l;
        //if (this.length < 0) {
            //while ((l = instream.read(buffer)) != -1) {
                //outstream.write(buffer, 0, l);
            //}
        //} else {
            //long remaining = this.length;
            //while (remaining > 0) {
                //l = instream.read(buffer, 0, (int)Math.min(BUFFER_SIZE, remaining));
                //if (l == -1) {
                    //break;
                //}
                //outstream.write(buffer, 0, l);
                //remaining -= l;
            //}
        //}
        //this.consumed = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.981 -0400", hash_original_method = "3E82383C0A86BE67DCD75D0F1508916B", hash_generated_method = "BEA77A262F47FFC2950121D1442D42D3")
    public boolean isStreaming() {
        boolean varC5881E5585D5F83BFC38268C8395B4AF_76323512 = (!this.consumed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928054620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928054620;
        // ---------- Original Method ----------
        //return !this.consumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.982 -0400", hash_original_method = "1B9AD287611C066C29846341DA0AFC9D", hash_generated_method = "BB7A77B851C987DED184DD1B2AE91934")
    public void consumeContent() throws IOException {
        this.consumed = true;
        this.content.close();
        // ---------- Original Method ----------
        //this.consumed = true;
        //this.content.close();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.982 -0400", hash_original_field = "D4808A3FE7592153FBF8721DE2EDDCBC", hash_generated_field = "6E2192BB486EB38AA227C1403F5C8AE0")

    private final static int BUFFER_SIZE = 2048;
}

