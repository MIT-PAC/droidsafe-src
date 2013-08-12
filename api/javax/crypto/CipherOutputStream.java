package javax.crypto;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import libcore.io.Streams;



public class CipherOutputStream extends FilterOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.033 -0400", hash_original_field = "08406A6E18BDF83010DDD1187251454D", hash_generated_field = "2FF9F58B969F4213F59ABA296D3A8FC3")

    private Cipher cipher;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.033 -0400", hash_original_method = "F0906B408310381889BAAA52B967EE5F", hash_generated_method = "57240CA476F2FB73AFC71C5CFA33B19D")
    public  CipherOutputStream(OutputStream os, Cipher c) {
        super(os);
        addTaint(os.getTaint());
        cipher = c;
        // ---------- Original Method ----------
        //cipher = c;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.034 -0400", hash_original_method = "1AEB5C9039E95E13C9B65FD65F4D37C9", hash_generated_method = "2452D155566C590B8303E81F27321ACD")
    protected  CipherOutputStream(OutputStream os) {
        this(os, new NullCipher());
        addTaint(os.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.034 -0400", hash_original_method = "C558B2B88CBF261C0FBBE5741F96019C", hash_generated_method = "A356673BF18A00CFAC4BA54C535E65CE")
    @Override
    public void write(int b) throws IOException {
        addTaint(b);
        Streams.writeSingleByte(this, b);
        // ---------- Original Method ----------
        //Streams.writeSingleByte(this, b);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.035 -0400", hash_original_method = "5836CE17B48698DBC2254777B1086E69", hash_generated_method = "629B78E12011F9B7558D0465B289DCCF")
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        if(len == 0)        
        {
            return;
        } //End block
        byte[] result = cipher.update(b, off, len);
        if(result != null)        
        {
            out.write(result);
        } //End block
        // ---------- Original Method ----------
        //if (len == 0) {
            //return;
        //}
        //byte[] result = cipher.update(b, off, len);
        //if (result != null) {
            //out.write(result);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.036 -0400", hash_original_method = "C99FBA65B0D308569620507D6E099042", hash_generated_method = "A2EF74EEF7203CB573D4B22064D57305")
    @Override
    public void flush() throws IOException {
        out.flush();
        // ---------- Original Method ----------
        //out.flush();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.037 -0400", hash_original_method = "C8083FF618F908C15CB2AD663C443A1B", hash_generated_method = "71A8B3D36E46173846F1C6A0A87868B2")
    @Override
    public void close() throws IOException {
        byte[] result;
        try 
        {
            if(cipher != null)            
            {
                result = cipher.doFinal();
                if(result != null)                
                {
                    out.write(result);
                } //End block
            } //End block
            if(out != null)            
            {
                out.flush();
            } //End block
        } //End block
        catch (BadPaddingException e)
        {
            IOException varDFC4605B531BC1C5380FD94E58912494_1260136690 = new IOException(e.getMessage());
            varDFC4605B531BC1C5380FD94E58912494_1260136690.addTaint(taint);
            throw varDFC4605B531BC1C5380FD94E58912494_1260136690;
        } //End block
        catch (IllegalBlockSizeException e)
        {
            IOException varDFC4605B531BC1C5380FD94E58912494_325817332 = new IOException(e.getMessage());
            varDFC4605B531BC1C5380FD94E58912494_325817332.addTaint(taint);
            throw varDFC4605B531BC1C5380FD94E58912494_325817332;
        } //End block
        finally 
        {
            if(out != null)            
            {
                out.close();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //byte[] result;
        //try {
            //if (cipher != null) {
                //result = cipher.doFinal();
                //if (result != null) {
                    //out.write(result);
                //}
            //}
            //if (out != null) {
                //out.flush();
            //}
        //} catch (BadPaddingException e) {
            //throw new IOException(e.getMessage());
        //} catch (IllegalBlockSizeException e) {
            //throw new IOException(e.getMessage());
        //} finally {
            //if (out != null) {
                //out.close();
            //}
        //}
    }

    
}

