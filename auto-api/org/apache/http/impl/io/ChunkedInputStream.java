package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.703 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "1D4C1FD37762DA513250BEA823E156F5")

    private SessionInputBuffer in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.703 -0400", hash_original_field = "7F2DB423A49B305459147332FB01CF87", hash_generated_field = "2D6B54E04F26AA35A63824F1627650C8")

    private CharArrayBuffer buffer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.703 -0400", hash_original_field = "00255DCB7E7FE62F3DD8ED38644CC3EE", hash_generated_field = "47235E9A35474F8DBDD6D8DBB4AB5B6A")

    private int chunkSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.703 -0400", hash_original_field = "5E0BDCBDDCCCA4D66D74BA8C1CEE1A68", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.703 -0400", hash_original_field = "E3768FD843616B8E3C32D658F28B0EED", hash_generated_field = "C7D7F0DB76F14B1CC635F97425C47305")

    private boolean bof = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.703 -0400", hash_original_field = "150E2E5209DF95A2ED53E3B4D212578D", hash_generated_field = "9D21D7F75CFE95F29DC47C0C3AFEC881")

    private boolean eof = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.703 -0400", hash_original_field = "1E79543A888DE7BB0ADBB289A8F4251D", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.703 -0400", hash_original_field = "08F4D1ABD4CF9E9634E1EDF5560E2D18", hash_generated_field = "A74851231E6F66E8990234BC00C8E61F")

    private Header[] footers = new Header[] {};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.704 -0400", hash_original_method = "A74B5C02541010DFF9C03CAF0620A33C", hash_generated_method = "41687BD34A23A0E8345E8714E67973A0")
    public  ChunkedInputStream(final SessionInputBuffer in) {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Session input buffer may not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.704 -0400", hash_original_method = "5987C40EBD16187447E09174CE17A1D5", hash_generated_method = "90F8E4CFD4FA12264D140A61D7E6A65C")
    public int read() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Attempted read from closed stream.");
        } //End block
        {
            nextChunk();
        } //End block
        int var2EE2703F88097027B4DEA42C13801E06_788473784 = (in.read());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_698443526 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_698443526;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.704 -0400", hash_original_method = "3658228930DC027E604760F33BD6E163", hash_generated_method = "A3FD1612E804A186FBDF43A1DC841FD8")
    public int read(byte[] b, int off, int len) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Attempted read from closed stream.");
        } //End block
        {
            nextChunk();
        } //End block
        len = Math.min(len, chunkSize - pos);
        int count = in.read(b, off, len);
        pos += count;
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462639806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1462639806;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.705 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "163F4A3D558F552548AA7594704D809E")
    public int read(byte[] b) throws IOException {
        int var38A74F3EE8B05A9B738F2B8C0F60B1F0_939147973 = (read(b, 0, b.length));
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230921946 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230921946;
        // ---------- Original Method ----------
        //return read(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.705 -0400", hash_original_method = "4EC8EF70B227B064D40EEFDD2252C457", hash_generated_method = "28ECF71031839DE6DDD675B330A3457C")
    private void nextChunk() throws IOException {
        chunkSize = getChunkSize();
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedChunkCodingException("Negative chunk size");
        } //End block
        bof = false;
        pos = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.706 -0400", hash_original_method = "992D2E5FFE364796E637C7610DCE798B", hash_generated_method = "88198C164DEE3DB4D0C273FFA3F2F3DF")
    private int getChunkSize() throws IOException {
        {
            int cr = in.read();
            int lf = in.read();
            {
                if (DroidSafeAndroidRuntime.control) throw new MalformedChunkCodingException(
                    "CRLF expected at end of chunk");
            } //End block
        } //End block
        this.buffer.clear();
        int i = this.in.readLine(this.buffer);
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedChunkCodingException(
                    "Chunked stream ended unexpectedly");
        } //End block
        int separator = this.buffer.indexOf(';');
        {
            separator = this.buffer.length();
        } //End block
        try 
        {
            int var636C033E3E4DDED0E344A1493F46699A_374696255 = (Integer.parseInt(this.buffer.substringTrimmed(0, separator), 16));
        } //End block
        catch (NumberFormatException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new MalformedChunkCodingException("Bad chunk header");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1286649935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1286649935;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.728 -0400", hash_original_method = "B639A385C0DFC1E0B0F3B3045E38F98A", hash_generated_method = "2AE1850C1CC01D47E0F9CF0811FE9C7D")
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
            if (DroidSafeAndroidRuntime.control) throw ioe;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.731 -0400", hash_original_method = "7C0EA5C3612B6B07D60F3A7E9A05393C", hash_generated_method = "5342CF578B54BD3827B9235A6EE0524F")
    public void close() throws IOException {
        {
            try 
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:41.732 -0400", hash_original_method = "7163A37F445D9A153E08F6B88D28A6E4", hash_generated_method = "743408F88C569998A9C0E11F5D2DBC6C")
    public Header[] getFooters() {
        Header[] varB4EAC82CA7396A68D541C85D26508E83_1736015008 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1736015008 = (Header[])this.footers.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1736015008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1736015008;
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

