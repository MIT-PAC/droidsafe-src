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

public class BasicHttpEntity extends AbstractHttpEntity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.858 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "E10265C22C3282384A3FF9B20A322BFE")

    private InputStream content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.858 -0400", hash_original_field = "516B89C2901255DCB4FAEF46CBC2D6CE", hash_generated_field = "F83D62FF33880A5C9450BAF66AEC5A3C")

    private boolean contentObtained;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.858 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "C62D106264E132930C7955708C9A9CDD")

    private long length;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.859 -0400", hash_original_method = "6C56C11F8A570F150FD118B6F4CE07D0", hash_generated_method = "422F155C0F38937E2C1FE41DC8DFE07C")
    public  BasicHttpEntity() {
        super();
        this.length = -1;
        // ---------- Original Method ----------
        //this.length = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.859 -0400", hash_original_method = "120309BFFDD6935F8B30886147626A04", hash_generated_method = "6C094EBF84A56D2605F0C5FBB3FF16E0")
    public long getContentLength() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2113845495 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2113845495;
        // ---------- Original Method ----------
        //return this.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.860 -0400", hash_original_method = "DD43DF1BE34625633489098C75403E56", hash_generated_method = "9A7782BEA50DE8298AB3F91FA86114FD")
    public InputStream getContent() throws IllegalStateException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1574091978 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Content has not been provided");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Content has been consumed");
        } //End block
        this.contentObtained = true;
        varB4EAC82CA7396A68D541C85D26508E83_1574091978 = this.content;
        varB4EAC82CA7396A68D541C85D26508E83_1574091978.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1574091978;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.860 -0400", hash_original_method = "731D88F5D8865617BA362DCED4C30896", hash_generated_method = "565135490CC188A331A30452C2BF5338")
    public boolean isRepeatable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1594004509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1594004509;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.860 -0400", hash_original_method = "7EB1D34B8B79AC60227ACAB040078324", hash_generated_method = "727B385E1B6CC2143FAFA858B4B3D854")
    public void setContentLength(long len) {
        this.length = len;
        // ---------- Original Method ----------
        //this.length = len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.864 -0400", hash_original_method = "9243F298C9B144B2EDE1C1ED14CD424D", hash_generated_method = "5E27285ED6D5A57AA981DC542F0CB0AA")
    public void setContent(final InputStream instream) {
        this.content = instream;
        this.contentObtained = false;
        // ---------- Original Method ----------
        //this.content = instream;
        //this.contentObtained = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.865 -0400", hash_original_method = "4D2C7455ACC84C8F2AC9220CC460CB0C", hash_generated_method = "92AA2F938E9680E6A844D117FD65965F")
    public void writeTo(final OutputStream outstream) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Output stream may not be null");
        } //End block
        InputStream instream;
        instream = getContent();
        int l;
        byte[] tmp;
        tmp = new byte[2048];
        {
            boolean var760073AB7A72A3E24F5E04B77421525F_1910514979 = ((l = instream.read(tmp)) != -1);
            {
                outstream.write(tmp, 0, l);
            } //End block
        } //End collapsed parenthetic
        addTaint(outstream.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.865 -0400", hash_original_method = "12B60AB15F5876110075CCE154554A33", hash_generated_method = "BBBF21A85A3AD3D3F118C5E104629181")
    public boolean isStreaming() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_270491035 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_270491035;
        // ---------- Original Method ----------
        //return !this.contentObtained && this.content != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.865 -0400", hash_original_method = "DCFF80E870BC55BBCCB28CB7928D312B", hash_generated_method = "46CCF474F141CDEED1AEE1D6680B93F6")
    public void consumeContent() throws IOException {
        {
            content.close();
        } //End block
        // ---------- Original Method ----------
        //if (content != null) {
            //content.close(); 
        //}
    }

    
}

