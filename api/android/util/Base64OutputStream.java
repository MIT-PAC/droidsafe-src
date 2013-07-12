package android.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64OutputStream extends FilterOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.782 -0400", hash_original_field = "0EA4A0DB010EFD4ED3CA4EBEE723B65C", hash_generated_field = "1F1AACA9B8C921BF3C739250DBC6741F")

    private Base64.Coder coder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.782 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "C01DA7975DA485EEDBF522635D053B3B")

    private int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.782 -0400", hash_original_field = "0ED511E8C84BB7FDA5F61798CB01880D", hash_generated_field = "B17349ED402A8EE321EE2D687D0FC773")

    private byte[] buffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.782 -0400", hash_original_field = "1CED8361F6C9D1EA84596FC0922D5599", hash_generated_field = "DE1311439F73FF2DC9E1E67409991F70")

    private int bpos = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.782 -0400", hash_original_method = "E46F474FD2867F9C3A785E56A0AD2237", hash_generated_method = "CD5B57D572F3090C097CF762D46E8458")
    public  Base64OutputStream(OutputStream out, int flags) {
        this(out, flags, true);
        addTaint(flags);
        addTaint(out.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.783 -0400", hash_original_method = "5457B6ADA9169BEDA2429E8007C22AEC", hash_generated_method = "6C6B2C937DD34D93B5EED25E7BFB26EE")
    public  Base64OutputStream(OutputStream out, int flags, boolean encode) {
        super(out);
        addTaint(encode);
        addTaint(out.getTaint());
        this.flags = flags;
    if(encode)        
        {
            coder = new Base64.Encoder(flags, null);
        } 
        else
        {
            coder = new Base64.Decoder(flags, null);
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.784 -0400", hash_original_method = "FE73EB52D6E189AC5420897BE3BAB488", hash_generated_method = "CC7A998E19022A793CC09650902F7B5D")
    public void write(int b) throws IOException {
    if(buffer == null)        
        {
            buffer = new byte[1024];
        } 
    if(bpos >= buffer.length)        
        {
            internalWrite(buffer, 0, bpos, false);
            bpos = 0;
        } 
        buffer[bpos++] = (byte) b;
        
        
            
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.784 -0400", hash_original_method = "F067C038C49D9731F81C40BA311D56BE", hash_generated_method = "56B2963A30BC9470257F370E84B15732")
    private void flushBuffer() throws IOException {
    if(bpos > 0)        
        {
            internalWrite(buffer, 0, bpos, false);
            bpos = 0;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.785 -0400", hash_original_method = "A3459DDB741D1D5DB893FD9A7CFFE0F1", hash_generated_method = "9B8A7469D3F6400D187082335FF47885")
    public void write(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
    if(len <= 0)        
        return;
        flushBuffer();
        internalWrite(b, off, len, false);
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.786 -0400", hash_original_method = "17457DFCCCBD635753AB001ED5B818FB", hash_generated_method = "9CE0DEBDB385AF1C9E213046ADEE54C4")
    public void close() throws IOException {
        IOException thrown = null;
        try 
        {
            flushBuffer();
            internalWrite(EMPTY, 0, 0, true);
        } 
        catch (IOException e)
        {
            thrown = e;
        } 
        try 
        {
    if((flags & Base64.NO_CLOSE) == 0)            
            {
                out.close();
            } 
            else
            {
                out.flush();
            } 
        } 
        catch (IOException e)
        {
    if(thrown != null)            
            {
                thrown = e;
            } 
        } 
    if(thrown != null)        
        {
            thrown.addTaint(taint);
            throw thrown;
        } 
        
        
        
            
            
        
            
        
        
            
                
            
                
            
        
            
                
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.787 -0400", hash_original_method = "4C39B7C855C3608586F188D73E5D3223", hash_generated_method = "96CDA3220F8106DE4E091274637B4286")
    private void internalWrite(byte[] b, int off, int len, boolean finish) throws IOException {
        addTaint(finish);
        addTaint(off);
        addTaint(b[0]);
        coder.output = embiggen(coder.output, coder.maxOutputSize(len));
    if(!coder.process(b, off, len, finish))        
        {
            Base64DataException varF0DD44910C7219815AA4C8F30CAF8B81_2100553887 = new Base64DataException("bad base-64");
            varF0DD44910C7219815AA4C8F30CAF8B81_2100553887.addTaint(taint);
            throw varF0DD44910C7219815AA4C8F30CAF8B81_2100553887;
        } 
        out.write(coder.output, 0, coder.op);
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.788 -0400", hash_original_method = "8F1A1CDA0B50B3C3FF8220D3A1F18B22", hash_generated_method = "FEB15C45BCAED0327B33AA870DD50865")
    private byte[] embiggen(byte[] b, int len) {
        addTaint(len);
        addTaint(b[0]);
    if(b == null || b.length < len)        
        {
            byte[] varB12B4D663E56EB1612747752D18CD890_1725077452 = (new byte[len]);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_836485339 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_836485339;
        } 
        else
        {
            byte[] var92EB5FFEE6AE2FEC3AD71C777531578F_179360640 = (b);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1791531903 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1791531903;
        } 
        
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:47.788 -0400", hash_original_field = "CC2A27A8C099042B0B85E81604FE266C", hash_generated_field = "8DC8CC9D462633D2F5F238FD63AB94FA")

    private static byte[] EMPTY = new byte[0];
}

