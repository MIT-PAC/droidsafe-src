package org.apache.commons.io.input;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class ReaderInputStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.065 -0400", hash_original_field = "1DE9B0A30075AE8C303EB420C103C320", hash_generated_field = "506A19594AC0AF91386404965612888E")

    private Reader reader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.065 -0400", hash_original_field = "724A00E315992B82D662231EA0DCBE50", hash_generated_field = "A07B3C678B690A0A298B0184B628874A")

    private CharsetEncoder encoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.065 -0400", hash_original_field = "BA6A1587F877C510A43B1337AD84BF2F", hash_generated_field = "B60F0BBBB9014F06D5B95B719C3C190B")

    private CharBuffer encoderIn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.065 -0400", hash_original_field = "E139CFBFBDC301E0E43F94244AD938D2", hash_generated_field = "72413451FD4C93ACB89B8EE051BE2E39")

    private ByteBuffer encoderOut;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.065 -0400", hash_original_field = "49E94AEF481544C434081CEAE0E81D3C", hash_generated_field = "027A16390EC7AF19AFCD69BC85AAE931")

    private CoderResult lastCoderResult;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.065 -0400", hash_original_field = "B72417FF598F6E6F9B5A22B7CB95F394", hash_generated_field = "759737216E42E53DB8195D44DC15B09C")

    private boolean endOfInput;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.065 -0400", hash_original_method = "DC774D82E80C58D521C1DE3E75EA3234", hash_generated_method = "395B4EFA90DC3FB6DD9ABC7839D29888")
    public  ReaderInputStream(Reader reader, CharsetEncoder encoder) {
        this(reader, encoder, DEFAULT_BUFFER_SIZE);
        addTaint(reader.getTaint());
        addTaint(encoder.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.066 -0400", hash_original_method = "A6AF0B0DEDD8FD34E7B252A21E73275C", hash_generated_method = "A19A08667CA19337AABF154EA550CFE1")
    public  ReaderInputStream(Reader reader, CharsetEncoder encoder, int bufferSize) {
        this.reader = reader;
        this.encoder = encoder;
        this.encoderIn = CharBuffer.allocate(bufferSize);
        this.encoderIn.flip();
        this.encoderOut = ByteBuffer.allocate(128);
        this.encoderOut.flip();
        // ---------- Original Method ----------
        //this.reader = reader;
        //this.encoder = encoder;
        //this.encoderIn = CharBuffer.allocate(bufferSize);
        //this.encoderIn.flip();
        //this.encoderOut = ByteBuffer.allocate(128);
        //this.encoderOut.flip();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.066 -0400", hash_original_method = "098FEFB55144E5D136CA5E0996327A4A", hash_generated_method = "69F3954E95120C4EE69A3223791103EA")
    public  ReaderInputStream(Reader reader, Charset charset, int bufferSize) {
        this(reader,
             charset.newEncoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE),
             bufferSize);
        addTaint(reader.getTaint());
        addTaint(charset.getTaint());
        addTaint(bufferSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.066 -0400", hash_original_method = "69E1F502F9939E0034482B73D6F14557", hash_generated_method = "01986B53F8020B95FA5AAB8F11CF5C22")
    public  ReaderInputStream(Reader reader, Charset charset) {
        this(reader, charset, DEFAULT_BUFFER_SIZE);
        addTaint(reader.getTaint());
        addTaint(charset.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.074 -0400", hash_original_method = "62449A8A28906ABC0866BF33E5F4E4BA", hash_generated_method = "71B3757EF466AECE20045F215A4A4836")
    public  ReaderInputStream(Reader reader, String charsetName, int bufferSize) {
        this(reader, Charset.forName(charsetName), bufferSize);
        addTaint(reader.getTaint());
        addTaint(charsetName.getTaint());
        addTaint(bufferSize);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.080 -0400", hash_original_method = "98B240FEEBDE4993FBD19F610BA6219B", hash_generated_method = "3A1AD01C2F64CE67A6C634FEE684514F")
    public  ReaderInputStream(Reader reader, String charsetName) {
        this(reader, charsetName, DEFAULT_BUFFER_SIZE);
        addTaint(reader.getTaint());
        addTaint(charsetName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.080 -0400", hash_original_method = "CD00642F55B4FEC77508F18FE9833050", hash_generated_method = "2A36062049A73893C49EDC554D59A34E")
    public  ReaderInputStream(Reader reader) {
        this(reader, Charset.defaultCharset());
        addTaint(reader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.081 -0400", hash_original_method = "A6D59C67E1B0FB9D0521062EBAAF3984", hash_generated_method = "64957FAC742C168F5F445813254DB4BB")
    private void fillBuffer() throws IOException {
        {
            boolean varA36B44C98A388A79958B1C1A11095B79_1555496891 = (!endOfInput && (lastCoderResult == null || lastCoderResult.isUnderflow()));
            {
                encoderIn.compact();
                int position;
                position = encoderIn.position();
                int c;
                c = reader.read(encoderIn.array(), position, encoderIn.remaining());
                {
                    endOfInput = true;
                } //End block
                {
                    encoderIn.position(position+c);
                } //End block
                encoderIn.flip();
            } //End block
        } //End collapsed parenthetic
        encoderOut.compact();
        lastCoderResult = encoder.encode(encoderIn, encoderOut, endOfInput);
        encoderOut.flip();
        // ---------- Original Method ----------
        //if (!endOfInput && (lastCoderResult == null || lastCoderResult.isUnderflow())) {
            //encoderIn.compact();
            //int position = encoderIn.position();
            //int c = reader.read(encoderIn.array(), position, encoderIn.remaining());
            //if (c == -1) {
                //endOfInput = true;
            //} else {
                //encoderIn.position(position+c);
            //}
            //encoderIn.flip();
        //}
        //encoderOut.compact();
        //lastCoderResult = encoder.encode(encoderIn, encoderOut, endOfInput);
        //encoderOut.flip();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.091 -0400", hash_original_method = "9AA2BEF9DA8AFF8D251BF2FC6F763561", hash_generated_method = "6438419B38C0B79DA09E871F13113F9E")
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("Byte array must not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException("Array Size=" + b.length +
                    ", offset=" + off + ", length=" + len);
        } //End block
        int read;
        read = 0;
        {
            {
                boolean varCA0CDCAECD073FD5C50E68016B46BB06_705400076 = (encoderOut.hasRemaining());
                {
                    int c;
                    c = Math.min(encoderOut.remaining(), len);
                    encoderOut.get(b, off, c);
                    off += c;
                    len -= c;
                    read += c;
                } //End block
                {
                    fillBuffer();
                    {
                        boolean var1BFADDC84FDAF431B3F5CA44D8F63FE6_56567534 = (endOfInput && !encoderOut.hasRemaining());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835161085 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835161085;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.092 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "EF53497FEB6D2A1C72DA661E2A6CCE6E")
    @Override
    public int read(byte[] b) throws IOException {
        int var38A74F3EE8B05A9B738F2B8C0F60B1F0_113631490 = (read(b, 0, b.length));
        addTaint(b[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306381887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_306381887;
        // ---------- Original Method ----------
        //return read(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.092 -0400", hash_original_method = "DE40F403B4AA3B3194A9FBF22582153E", hash_generated_method = "B6229D4D1BC7B066347164F7AE7B7D20")
    @Override
    public int read() throws IOException {
        {
            {
                boolean varCA0CDCAECD073FD5C50E68016B46BB06_1619099565 = (encoderOut.hasRemaining());
                {
                    int var73530728B2A273A024F37B0944098BB0_2039351035 = (encoderOut.get() & 0xFF);
                } //End block
                {
                    fillBuffer();
                    {
                        boolean var1BFADDC84FDAF431B3F5CA44D8F63FE6_505117848 = (endOfInput && !encoderOut.hasRemaining());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440935257 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440935257;
        // ---------- Original Method ----------
        //for (;;) {
            //if (encoderOut.hasRemaining()) {
                //return encoderOut.get() & 0xFF;
            //} else {
                //fillBuffer();
                //if (endOfInput && !encoderOut.hasRemaining()) {
                    //return -1;
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.092 -0400", hash_original_method = "A1FFC9B80BA56A6C1B0EFB45497D16D1", hash_generated_method = "B3E1029E376B5E0CFBFF8FD738B892BD")
    @Override
    public void close() throws IOException {
        reader.close();
        // ---------- Original Method ----------
        //reader.close();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.092 -0400", hash_original_field = "E1C1EEB189E8C6F96F23FE164A5738F0", hash_generated_field = "41DBE8ECCC336910BBFC874AF2375A40")

    private static int DEFAULT_BUFFER_SIZE = 1024;
}

