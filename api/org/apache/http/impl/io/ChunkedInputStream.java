package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.492 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.492 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "2D6B54E04F26AA35A63824F1627650C8")

    private CharArrayBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.492 -0400", hash_original_field = "00255DCB7E7FE62F3DD8ED38644CC3EE", hash_generated_field = "47235E9A35474F8DBDD6D8DBB4AB5B6A")

    private int chunkSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.492 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.492 -0400", hash_original_field = "E3768FD843616B8E3C32D658F28B0EED", hash_generated_field = "C7D7F0DB76F14B1CC635F97425C47305")

    private boolean bof = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.492 -0400", hash_original_field = "150E2E5209DF95A2ED53E3B4D212578D", hash_generated_field = "9D21D7F75CFE95F29DC47C0C3AFEC881")

    private boolean eof = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.492 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.493 -0400", hash_original_field = "08F4D1ABD4CF9E9634E1EDF5560E2D18", hash_generated_field = "A74851231E6F66E8990234BC00C8E61F")

    private Header[] footers = new Header[] {};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.494 -0400", hash_original_method = "A74B5C02541010DFF9C03CAF0620A33C", hash_generated_method = "B1987F1EB48B490191A32BBAC8AE9528")
    public  ChunkedInputStream(final SessionInputBuffer in) {
        super();
        if(in == null)        
        {
            IllegalArgumentException varB3677395451B18A3F9262E9D7FE254B3_82664936 = new IllegalArgumentException("Session input buffer may not be null");
            varB3677395451B18A3F9262E9D7FE254B3_82664936.addTaint(taint);
            throw varB3677395451B18A3F9262E9D7FE254B3_82664936;
        } //End block
        this.in = in;
        this.pos = 0;
        this.buffer = new CharArrayBuffer(16);
        // ---------- Original Method ----------
        //if (in == null) {
            //throw new IllegalArgumentException("Session input buffer may not be null");
        //}
        //this.in = in;
        //this.pos = 0;
        //this.buffer = new CharArrayBuffer(16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.494 -0400", hash_original_method = "5987C40EBD16187447E09174CE17A1D5", hash_generated_method = "CF70092E5AF63F34AF81423C88726984")
    public int read() throws IOException {
        if(this.closed)        
        {
            IOException varEE3E399CAE0E5DE731C2BF5A8C5ABA04_141561404 = new IOException("Attempted read from closed stream.");
            varEE3E399CAE0E5DE731C2BF5A8C5ABA04_141561404.addTaint(taint);
            throw varEE3E399CAE0E5DE731C2BF5A8C5ABA04_141561404;
        } //End block
        if(this.eof)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1603577208 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9539763 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9539763;
        } //End block
        if(this.pos >= this.chunkSize)        
        {
            nextChunk();
            if(this.eof)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_403281864 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406479666 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406479666;
            } //End block
        } //End block
        pos++;
        int varC746AA2461228F1337791E992A2C4661_721093765 = (in.read());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629113190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1629113190;
        // ---------- Original Method ----------
        //if (this.closed) {
            //throw new IOException("Attempted read from closed stream.");
        //}
        //if (this.eof) {
            //return -1;
        //}
        //if (this.pos >= this.chunkSize) {
            //nextChunk();
            //if (this.eof) { 
                //return -1;
            //}
        //}
        //pos++;
        //return in.read();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.496 -0400", hash_original_method = "3658228930DC027E604760F33BD6E163", hash_generated_method = "915116D6286E0B2225323B7E94C4F8DD")
    public int read(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        if(closed)        
        {
            IOException varEE3E399CAE0E5DE731C2BF5A8C5ABA04_634877390 = new IOException("Attempted read from closed stream.");
            varEE3E399CAE0E5DE731C2BF5A8C5ABA04_634877390.addTaint(taint);
            throw varEE3E399CAE0E5DE731C2BF5A8C5ABA04_634877390;
        } //End block
        if(eof)        
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1390074120 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711360085 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711360085;
        } //End block
        if(pos >= chunkSize)        
        {
            nextChunk();
            if(eof)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1536481514 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535200049 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535200049;
            } //End block
        } //End block
        len = Math.min(len, chunkSize - pos);
        int count = in.read(b, off, len);
        pos += count;
        int varE2942A04780E223B215EB8B663CF5353_136682026 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996366877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996366877;
        // ---------- Original Method ----------
        //if (closed) {
            //throw new IOException("Attempted read from closed stream.");
        //}
        //if (eof) { 
            //return -1;
        //}
        //if (pos >= chunkSize) {
            //nextChunk();
            //if (eof) { 
                //return -1;
            //}
        //}
        //len = Math.min(len, chunkSize - pos);
        //int count = in.read(b, off, len);
        //pos += count;
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.497 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "E7ADAB211096714EB964A975486A2D7E")
    public int read(byte[] b) throws IOException {
        addTaint(b[0]);
        int var3AE1B8835719D1E8BA9C297EF156E04B_1163900151 = (read(b, 0, b.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138369022 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_138369022;
        // ---------- Original Method ----------
        //return read(b, 0, b.length);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.498 -0400", hash_original_method = "4EC8EF70B227B064D40EEFDD2252C457", hash_generated_method = "19055AF53F3ECC5BBFAAE3C51AE57F9F")
    private void nextChunk() throws IOException {
        chunkSize = getChunkSize();
        if(chunkSize < 0)        
        {
            MalformedChunkCodingException var28C5AFFBEDB64B19E76A8CF5514A8118_1418487449 = new MalformedChunkCodingException("Negative chunk size");
            var28C5AFFBEDB64B19E76A8CF5514A8118_1418487449.addTaint(taint);
            throw var28C5AFFBEDB64B19E76A8CF5514A8118_1418487449;
        } //End block
        bof = false;
        pos = 0;
        if(chunkSize == 0)        
        {
            eof = true;
            parseTrailerHeaders();
        } //End block
        // ---------- Original Method ----------
        //chunkSize = getChunkSize();
        //if (chunkSize < 0) {
            //throw new MalformedChunkCodingException("Negative chunk size");
        //}
        //bof = false;
        //pos = 0;
        //if (chunkSize == 0) {
            //eof = true;
            //parseTrailerHeaders();
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.499 -0400", hash_original_method = "992D2E5FFE364796E637C7610DCE798B", hash_generated_method = "D94521F7AF2CCE4FCEBC81CB38EFC671")
    private int getChunkSize() throws IOException {
        if(!bof)        
        {
            int cr = in.read();
            int lf = in.read();
            if((cr != HTTP.CR) || (lf != HTTP.LF))            
            {
                MalformedChunkCodingException varA913243D9FF4ADF2D38AC59F4946E043_828466851 = new MalformedChunkCodingException(
                    "CRLF expected at end of chunk");
                varA913243D9FF4ADF2D38AC59F4946E043_828466851.addTaint(taint);
                throw varA913243D9FF4ADF2D38AC59F4946E043_828466851;
            } //End block
        } //End block
        this.buffer.clear();
        int i = this.in.readLine(this.buffer);
        if(i == -1)        
        {
            MalformedChunkCodingException var7E0993B7D5BCD90AA97B5B44DE9AF341_1033364978 = new MalformedChunkCodingException(
                    "Chunked stream ended unexpectedly");
            var7E0993B7D5BCD90AA97B5B44DE9AF341_1033364978.addTaint(taint);
            throw var7E0993B7D5BCD90AA97B5B44DE9AF341_1033364978;
        } //End block
        int separator = this.buffer.indexOf(';');
        if(separator < 0)        
        {
            separator = this.buffer.length();
        } //End block
        try 
        {
            int var9FF7CA7B2D3F599F686EDFDA0F1A651E_1351831325 = (Integer.parseInt(this.buffer.substringTrimmed(0, separator), 16));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_187060559 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_187060559;
        } //End block
        catch (NumberFormatException e)
        {
            MalformedChunkCodingException var8537FEBE30BCA3D60D84474C2C9A4E3E_132032247 = new MalformedChunkCodingException("Bad chunk header");
            var8537FEBE30BCA3D60D84474C2C9A4E3E_132032247.addTaint(taint);
            throw var8537FEBE30BCA3D60D84474C2C9A4E3E_132032247;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.501 -0400", hash_original_method = "B639A385C0DFC1E0B0F3B3045E38F98A", hash_generated_method = "8830E16668B021D9E0644ED706E6DE45")
    private void parseTrailerHeaders() throws IOException {
        try 
        {
            this.footers = AbstractMessageParser.parseHeaders
                (in, -1, -1, null);
        } //End block
        catch (HttpException e)
        {
            IOException ioe = new MalformedChunkCodingException("Invalid footer: " 
                    + e.getMessage());
            ExceptionUtils.initCause(ioe, e);
            ioe.addTaint(taint);
            throw ioe;
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.footers = AbstractMessageParser.parseHeaders
                //(in, -1, -1, null);
        //} catch (HttpException e) {
            //IOException ioe = new MalformedChunkCodingException("Invalid footer: " 
                    //+ e.getMessage());
            //ExceptionUtils.initCause(ioe, e); 
            //throw ioe;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.503 -0400", hash_original_method = "7C0EA5C3612B6B07D60F3A7E9A05393C", hash_generated_method = "1DC47ABACDE91C315D402201107410A9")
    public void close() throws IOException {
        if(!closed)        
        {
            try 
            {
                if(!eof)                
                {
                    exhaustInputStream(this);
                } //End block
            } //End block
            finally 
            {
                eof = true;
                closed = true;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!closed) {
            //try {
                //if (!eof) {
                    //exhaustInputStream(this);
                //}
            //} finally {
                //eof = true;
                //closed = true;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.503 -0400", hash_original_method = "7163A37F445D9A153E08F6B88D28A6E4", hash_generated_method = "F007D61CA6F82A9AB656A1141649D0E0")
    public Header[] getFooters() {
Header[] var9FFC098F6658A5A943CD9CFF2C06B71C_12854951 =         (Header[])this.footers.clone();
        var9FFC098F6658A5A943CD9CFF2C06B71C_12854951.addTaint(taint);
        return var9FFC098F6658A5A943CD9CFF2C06B71C_12854951;
        // ---------- Original Method ----------
        //return (Header[])this.footers.clone();
    }

    
    static void exhaustInputStream(final InputStream inStream) throws IOException {
        byte buffer[] = new byte[1024];
        while (inStream.read(buffer) >= 0) {
            ;
        }
    }

    
}

