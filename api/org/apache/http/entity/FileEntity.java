package org.apache.http.entity;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.IOException;
import java.io.FileInputStream;
public class FileEntity extends AbstractHttpEntity implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:13:01.165 -0400", hash_original_field = "8C7DD922AD47494FC02C388E12C00EAC", hash_generated_field = "BC43AA2BAF191D9B3508364DC44789C4")

    protected File file;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:13:01.181 -0400", hash_original_method = "7B0CB5F6DC40F7AD2351558FFB54B759", hash_generated_method = "E2893D82A5224282516C054390942732")
    public  FileEntity(final File file, final String contentType) {
        super();
        addTaint(contentType.getTaint());
        if(file == null)        
        {
            IllegalArgumentException varDC2F102995BAEB3E043234B4A6AD150F_640936987 = new IllegalArgumentException("File may not be null");
            varDC2F102995BAEB3E043234B4A6AD150F_640936987.addTaint(taint);
            throw varDC2F102995BAEB3E043234B4A6AD150F_640936987;
        } //End block
        this.file = file;
        setContentType(contentType);
        // ---------- Original Method ----------
        //if (file == null) {
            //throw new IllegalArgumentException("File may not be null");
        //}
        //this.file = file;
        //setContentType(contentType);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:13:01.190 -0400", hash_original_method = "8850B92ED3324DB77471CF2A1052D726", hash_generated_method = "7A721C34234C4BC978A62CD5F702713A")
    public boolean isRepeatable() {
        boolean varB326B5062B2F0E69046810717534CB09_1567267755 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222662676 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_222662676;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:13:01.196 -0400", hash_original_method = "6FED64655A79F9611E60093AE1FA3DE4", hash_generated_method = "DD50A0CBFAD9B239D5AF526DBA9C7B69")
    public long getContentLength() {
        long var91E4852EC071A8FD6941C0F9222A86A5_321132146 = (this.file.length());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1731822096 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1731822096;
        // ---------- Original Method ----------
        //return this.file.length();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:13:01.213 -0400", hash_original_method = "95DDD95C9EF8C53495A581F72CFD5F10", hash_generated_method = "9298CD1D830B6C33838ED7C2850B504F")
    public InputStream getContent() throws IOException {
InputStream var5FC8BAFF893BECA58BA344C2E2776DD8_1241647490 =         new FileInputStream(this.file);
        var5FC8BAFF893BECA58BA344C2E2776DD8_1241647490.addTaint(taint);
        return var5FC8BAFF893BECA58BA344C2E2776DD8_1241647490;
        // ---------- Original Method ----------
        //return new FileInputStream(this.file);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:13:01.223 -0400", hash_original_method = "91C2E73E59371A9FF089FC4D36B416A0", hash_generated_method = "BBBB4470B44BEA68DD39972FC1F891D7")
    public void writeTo(final OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        if(outstream == null)        
        {
            IllegalArgumentException var8C9256F172D6E7DD26CC6F974ABC4716_197247583 = new IllegalArgumentException("Output stream may not be null");
            var8C9256F172D6E7DD26CC6F974ABC4716_197247583.addTaint(taint);
            throw var8C9256F172D6E7DD26CC6F974ABC4716_197247583;
        } //End block
        InputStream instream = new FileInputStream(this.file);
        try 
        {
            byte[] tmp = new byte[4096];
            int l;
            while
((l = instream.read(tmp)) != -1)            
            {
                outstream.write(tmp, 0, l);
            } //End block
            outstream.flush();
        } //End block
        finally 
        {
            instream.close();
        } //End block
        // ---------- Original Method ----------
        //if (outstream == null) {
            //throw new IllegalArgumentException("Output stream may not be null");
        //}
        //InputStream instream = new FileInputStream(this.file);
        //try {
            //byte[] tmp = new byte[4096];
            //int l;
            //while ((l = instream.read(tmp)) != -1) {
                //outstream.write(tmp, 0, l);
            //}
            //outstream.flush();
        //} finally {
            //instream.close();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:13:01.235 -0400", hash_original_method = "1C9916E491D93B6DAF758D3D738C6EEB", hash_generated_method = "EF2DAA1567CFBF58ED8EC78E4880C7D1")
    public boolean isStreaming() {
        boolean var68934A3E9455FA72420237EB05902327_136120154 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030257639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030257639;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-09-16 16:13:01.241 -0400", hash_original_method = "66DEBDF0D0405CDDBB7BD5DED76064DF", hash_generated_method = "50141DF70999158DCBFB5ABF2A45C93D")
    public Object clone() throws CloneNotSupportedException {
Object var46F3A0D86742C1D6E099C2B166941A33_727383181 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_727383181.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_727383181;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
}

