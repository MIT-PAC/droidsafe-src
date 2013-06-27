package org.apache.commons.io.output;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class WriterOutputStream extends OutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.639 -0400", hash_original_field = "A82FEEE3CC1AF8BCABDA979E8775EF0F", hash_generated_field = "DB075F4140D7FA00980C54A40F997F59")

    private Writer writer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.639 -0400", hash_original_field = "3A6BDBA8FB33A88CF7D52A1AF07A9C00", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.639 -0400", hash_original_field = "7FA09A092FA86C64ECEBD742F33CFF42", hash_generated_field = "CD0A8A60A3B382C20C5A148FCE76F0A8")

    private boolean writeImmediately;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.639 -0400", hash_original_field = "837D15431197C3E9537FBE93F41CEBD2", hash_generated_field = "B1E846AAD5E020A4DC4DD096F7B5D579")

    private ByteBuffer decoderIn = ByteBuffer.allocate(128);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.639 -0400", hash_original_field = "47C0799C729F0F680260D06E3CD958CC", hash_generated_field = "455BF49B21823C664D42B2AC67A38E34")

    private CharBuffer decoderOut;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.639 -0400", hash_original_method = "4A2ECD3C7335CA4F94CBBF612E64A3A4", hash_generated_method = "EE87B62CE9062DC24DA9F2956AED8166")
    public  WriterOutputStream(Writer writer, CharsetDecoder decoder) {
        this(writer, decoder, DEFAULT_BUFFER_SIZE, false);
        addTaint(writer.getTaint());
        addTaint(decoder.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.640 -0400", hash_original_method = "3EDB33815F621AFED5D37E18A3A21495", hash_generated_method = "E42119C134E23C19A0E135DA58006EC5")
    public  WriterOutputStream(Writer writer, CharsetDecoder decoder, int bufferSize, boolean writeImmediately) {
        this.writer = writer;
        this.decoder = decoder;
        this.writeImmediately = writeImmediately;
        decoderOut = CharBuffer.allocate(bufferSize);
        // ---------- Original Method ----------
        //this.writer = writer;
        //this.decoder = decoder;
        //this.writeImmediately = writeImmediately;
        //decoderOut = CharBuffer.allocate(bufferSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.641 -0400", hash_original_method = "B867148FBA5E55CD84C23E5CFFC25359", hash_generated_method = "6B78C4D822A4B7F176341BAC49CF631D")
    public  WriterOutputStream(Writer writer, Charset charset, int bufferSize, boolean writeImmediately) {
        this(writer,
             charset.newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE)
                    .replaceWith("?"),
             bufferSize,
             writeImmediately);
        addTaint(writer.getTaint());
        addTaint(charset.getTaint());
        addTaint(bufferSize);
        addTaint(writeImmediately);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.641 -0400", hash_original_method = "F5E8CFB6E56AC508C368EDA9E41EBCA5", hash_generated_method = "E1CCF8C3D2EC261A505702D459A4F580")
    public  WriterOutputStream(Writer writer, Charset charset) {
        this(writer, charset, DEFAULT_BUFFER_SIZE, false);
        addTaint(writer.getTaint());
        addTaint(charset.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.641 -0400", hash_original_method = "EFA34CAB468BE610E644DAB0715A71E2", hash_generated_method = "27E95DA5B59B5B1BB6D5E11AA68706E9")
    public  WriterOutputStream(Writer writer, String charsetName, int bufferSize, boolean writeImmediately) {
        this(writer, Charset.forName(charsetName), bufferSize, writeImmediately);
        addTaint(writer.getTaint());
        addTaint(charsetName.getTaint());
        addTaint(bufferSize);
        addTaint(writeImmediately);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.641 -0400", hash_original_method = "F26B5DFECB697DCFF94DB93FC05ACF8E", hash_generated_method = "4ECC827CAFF62FF6CB5EAA88080BF822")
    public  WriterOutputStream(Writer writer, String charsetName) {
        this(writer, charsetName, DEFAULT_BUFFER_SIZE, false);
        addTaint(writer.getTaint());
        addTaint(charsetName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.642 -0400", hash_original_method = "C117D3B09C26E87BDD8081C71BA84253", hash_generated_method = "252B83BA4D7207E2C5F29EEBCDAA3025")
    public  WriterOutputStream(Writer writer) {
        this(writer, Charset.defaultCharset(), DEFAULT_BUFFER_SIZE, false);
        addTaint(writer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.643 -0400", hash_original_method = "C0D49EB08A267ED3491A74132BB97C44", hash_generated_method = "E99AC25B0375D63711203EB26C39E637")
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        {
            int c;
            c = Math.min(len, decoderIn.remaining());
            decoderIn.put(b, off, c);
            processInput(false);
            len -= c;
            off += c;
        } //End block
        {
            flushOutput();
        } //End block
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        // ---------- Original Method ----------
        //while (len > 0) {
            //int c = Math.min(len, decoderIn.remaining());
            //decoderIn.put(b, off, c);
            //processInput(false);
            //len -= c;
            //off += c;
        //}
        //if (writeImmediately) {
            //flushOutput();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.643 -0400", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "65527CB182AA774108E3787F67952FBA")
    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
        addTaint(b[0]);
        // ---------- Original Method ----------
        //write(b, 0, b.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.653 -0400", hash_original_method = "72E9EA9CB4D496A22134A9DE55B8B91A", hash_generated_method = "6D7B678E08FBFEE586422C6433BDCAD5")
    @Override
    public void write(int b) throws IOException {
        write(new byte[] { (byte)b }, 0, 1);
        addTaint(b);
        // ---------- Original Method ----------
        //write(new byte[] { (byte)b }, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.653 -0400", hash_original_method = "AC63B2DA15A83F7213D18D8342590F5B", hash_generated_method = "8B5A73988608AB8AFD2F020B6179FC74")
    @Override
    public void flush() throws IOException {
        flushOutput();
        writer.flush();
        // ---------- Original Method ----------
        //flushOutput();
        //writer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.657 -0400", hash_original_method = "420EB211773CB08496419ABA1A7EC597", hash_generated_method = "28EF03026D790D6562F1CF27EA9F49E7")
    @Override
    public void close() throws IOException {
        processInput(true);
        flushOutput();
        writer.close();
        // ---------- Original Method ----------
        //processInput(true);
        //flushOutput();
        //writer.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.658 -0400", hash_original_method = "8DBE36D3CC23C0C9E5FAAD9804EB9F8E", hash_generated_method = "157784243AA8BDC4D42A029C8B73D8C7")
    private void processInput(boolean endOfInput) throws IOException {
        decoderIn.flip();
        CoderResult coderResult;
        {
            coderResult = decoder.decode(decoderIn, decoderOut, endOfInput);
            {
                boolean var1F4BF95B8230AF5CFFBC6FA75DC274CF_1655626854 = (coderResult.isOverflow());
                {
                    flushOutput();
                } //End block
                {
                    boolean var91E1BBCAB1B1D4939387A6515FBC5859_238869895 = (coderResult.isUnderflow());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Unexpected coder result");
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        decoderIn.compact();
        addTaint(endOfInput);
        // ---------- Original Method ----------
        //decoderIn.flip();
        //CoderResult coderResult;
        //while (true) {
            //coderResult = decoder.decode(decoderIn, decoderOut, endOfInput);
            //if (coderResult.isOverflow()) {
                //flushOutput();
            //} else if (coderResult.isUnderflow()) {
                //break;
            //} else {
                //throw new IOException("Unexpected coder result");
            //}
        //}
        //decoderIn.compact();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.659 -0400", hash_original_method = "CB0233CD34D87630D222478FE14929AD", hash_generated_method = "3F69D18536A8F27F870A706C6EF0AF8E")
    private void flushOutput() throws IOException {
        {
            boolean var5A61A804EE9D9DD861B4FBA8E1F323BE_750875646 = (decoderOut.position() > 0);
            {
                writer.write(decoderOut.array(), 0, decoderOut.position());
                decoderOut.rewind();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (decoderOut.position() > 0) {
            //writer.write(decoderOut.array(), 0, decoderOut.position());
            //decoderOut.rewind();
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:07.659 -0400", hash_original_field = "E1C1EEB189E8C6F96F23FE164A5738F0", hash_generated_field = "41DBE8ECCC336910BBFC874AF2375A40")

    private static int DEFAULT_BUFFER_SIZE = 1024;
}

