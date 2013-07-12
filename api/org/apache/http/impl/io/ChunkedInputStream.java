package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.ExceptionUtils;

public class ChunkedInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.133 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.133 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "2D6B54E04F26AA35A63824F1627650C8")

    private CharArrayBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.133 -0400", hash_original_field = "00255DCB7E7FE62F3DD8ED38644CC3EE", hash_generated_field = "47235E9A35474F8DBDD6D8DBB4AB5B6A")

    private int chunkSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.133 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.133 -0400", hash_original_field = "E3768FD843616B8E3C32D658F28B0EED", hash_generated_field = "C7D7F0DB76F14B1CC635F97425C47305")

    private boolean bof = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.133 -0400", hash_original_field = "150E2E5209DF95A2ED53E3B4D212578D", hash_generated_field = "9D21D7F75CFE95F29DC47C0C3AFEC881")

    private boolean eof = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.133 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.133 -0400", hash_original_field = "08F4D1ABD4CF9E9634E1EDF5560E2D18", hash_generated_field = "A74851231E6F66E8990234BC00C8E61F")

    private Header[] footers = new Header[] {};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.134 -0400", hash_original_method = "A74B5C02541010DFF9C03CAF0620A33C", hash_generated_method = "A0D3392F5EE52C0BC18E49DC640AF0B2")
    public  ChunkedInputStream(final SessionInputBuffer in) {
        super();
    if(in == null)        
        {
            IllegalArgumentException varB3677395451B18A3F9262E9D7FE254B3_1477151009 = new IllegalArgumentException("Session input buffer may not be null");
            varB3677395451B18A3F9262E9D7FE254B3_1477151009.addTaint(taint);
            throw varB3677395451B18A3F9262E9D7FE254B3_1477151009;
        } 
        this.in = in;
        this.pos = 0;
        this.buffer = new CharArrayBuffer(16);
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.134 -0400", hash_original_method = "5987C40EBD16187447E09174CE17A1D5", hash_generated_method = "88DEC6DE0309833BC96F38A459DCD330")
    public int read() throws IOException {
    if(this.closed)        
        {
            IOException varEE3E399CAE0E5DE731C2BF5A8C5ABA04_1952205903 = new IOException("Attempted read from closed stream.");
            varEE3E399CAE0E5DE731C2BF5A8C5ABA04_1952205903.addTaint(taint);
            throw varEE3E399CAE0E5DE731C2BF5A8C5ABA04_1952205903;
        } 
    if(this.eof)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1637241303 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757435411 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1757435411;
        } 
    if(this.pos >= this.chunkSize)        
        {
            nextChunk();
    if(this.eof)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_177924018 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805795800 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_805795800;
            } 
        } 
        pos++;
        int varC746AA2461228F1337791E992A2C4661_1969024042 = (in.read());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193291695 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1193291695;
        
        
            
        
        
            
        
        
            
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.135 -0400", hash_original_method = "3658228930DC027E604760F33BD6E163", hash_generated_method = "D5A446EB478644122AE1E7965F3D1B7C")
    public int read(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
    if(closed)        
        {
            IOException varEE3E399CAE0E5DE731C2BF5A8C5ABA04_1399651351 = new IOException("Attempted read from closed stream.");
            varEE3E399CAE0E5DE731C2BF5A8C5ABA04_1399651351.addTaint(taint);
            throw varEE3E399CAE0E5DE731C2BF5A8C5ABA04_1399651351;
        } 
    if(eof)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1084840743 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057581075 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1057581075;
        } 
    if(pos >= chunkSize)        
        {
            nextChunk();
    if(eof)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_349486945 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_675680070 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_675680070;
            } 
        } 
        len = Math.min(len, chunkSize - pos);
        int count = in.read(b, off, len);
        pos += count;
        int varE2942A04780E223B215EB8B663CF5353_745603047 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148862117 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1148862117;
        
        
            
        
        
            
        
        
            
            
                
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.136 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "273C1F3B40D2180BE8C16A76764046B0")
    public int read(byte[] b) throws IOException {
        addTaint(b[0]);
        int var3AE1B8835719D1E8BA9C297EF156E04B_2117559790 = (read(b, 0, b.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273370083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_273370083;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.136 -0400", hash_original_method = "4EC8EF70B227B064D40EEFDD2252C457", hash_generated_method = "75AF556D837699B829E11FA7E6ECF493")
    private void nextChunk() throws IOException {
        chunkSize = getChunkSize();
    if(chunkSize < 0)        
        {
            MalformedChunkCodingException var28C5AFFBEDB64B19E76A8CF5514A8118_1160535115 = new MalformedChunkCodingException("Negative chunk size");
            var28C5AFFBEDB64B19E76A8CF5514A8118_1160535115.addTaint(taint);
            throw var28C5AFFBEDB64B19E76A8CF5514A8118_1160535115;
        } 
        bof = false;
        pos = 0;
    if(chunkSize == 0)        
        {
            eof = true;
            parseTrailerHeaders();
        } 
        
        
        
            
        
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.138 -0400", hash_original_method = "992D2E5FFE364796E637C7610DCE798B", hash_generated_method = "B2FC2A72A6D245B8B28CDFCD78B538C0")
    private int getChunkSize() throws IOException {
    if(!bof)        
        {
            int cr = in.read();
            int lf = in.read();
    if((cr != HTTP.CR) || (lf != HTTP.LF))            
            {
                MalformedChunkCodingException varA913243D9FF4ADF2D38AC59F4946E043_634285731 = new MalformedChunkCodingException(
                    "CRLF expected at end of chunk");
                varA913243D9FF4ADF2D38AC59F4946E043_634285731.addTaint(taint);
                throw varA913243D9FF4ADF2D38AC59F4946E043_634285731;
            } 
        } 
        this.buffer.clear();
        int i = this.in.readLine(this.buffer);
    if(i == -1)        
        {
            MalformedChunkCodingException var7E0993B7D5BCD90AA97B5B44DE9AF341_1012783012 = new MalformedChunkCodingException(
                    "Chunked stream ended unexpectedly");
            var7E0993B7D5BCD90AA97B5B44DE9AF341_1012783012.addTaint(taint);
            throw var7E0993B7D5BCD90AA97B5B44DE9AF341_1012783012;
        } 
        int separator = this.buffer.indexOf(';');
    if(separator < 0)        
        {
            separator = this.buffer.length();
        } 
        try 
        {
            int var9FF7CA7B2D3F599F686EDFDA0F1A651E_1840775573 = (Integer.parseInt(this.buffer.substringTrimmed(0, separator), 16));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266806991 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266806991;
        } 
        catch (NumberFormatException e)
        {
            MalformedChunkCodingException var8537FEBE30BCA3D60D84474C2C9A4E3E_547779466 = new MalformedChunkCodingException("Bad chunk header");
            var8537FEBE30BCA3D60D84474C2C9A4E3E_547779466.addTaint(taint);
            throw var8537FEBE30BCA3D60D84474C2C9A4E3E_547779466;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.139 -0400", hash_original_method = "B639A385C0DFC1E0B0F3B3045E38F98A", hash_generated_method = "8830E16668B021D9E0644ED706E6DE45")
    private void parseTrailerHeaders() throws IOException {
        try 
        {
            this.footers = AbstractMessageParser.parseHeaders
                (in, -1, -1, null);
        } 
        catch (HttpException e)
        {
            IOException ioe = new MalformedChunkCodingException("Invalid footer: " 
                    + e.getMessage());
            ExceptionUtils.initCause(ioe, e);
            ioe.addTaint(taint);
            throw ioe;
        } 
        
        
            
                
        
            
                    
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.139 -0400", hash_original_method = "7C0EA5C3612B6B07D60F3A7E9A05393C", hash_generated_method = "1DC47ABACDE91C315D402201107410A9")
    public void close() throws IOException {
    if(!closed)        
        {
            try 
            {
    if(!eof)                
                {
                    exhaustInputStream(this);
                } 
            } 
            finally 
            {
                eof = true;
                closed = true;
            } 
        } 
        
        
            
                
                    
                
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.140 -0400", hash_original_method = "7163A37F445D9A153E08F6B88D28A6E4", hash_generated_method = "C84D893A5B8808F1DA96288D3ECE1614")
    public Header[] getFooters() {
Header[] var9FFC098F6658A5A943CD9CFF2C06B71C_2061484693 =         (Header[])this.footers.clone();
        var9FFC098F6658A5A943CD9CFF2C06B71C_2061484693.addTaint(taint);
        return var9FFC098F6658A5A943CD9CFF2C06B71C_2061484693;
        
        
    }

    
        static void exhaustInputStream(final InputStream inStream) throws IOException {
        byte buffer[] = new byte[1024];
        while (inStream.read(buffer) >= 0) {
            ;
        }
    }

    
}

