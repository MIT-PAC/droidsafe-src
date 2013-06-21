package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.util.Arrays;

public class InputStreamReader extends Reader {
    private InputStream in;
    private boolean endOfInput = false;
    private CharsetDecoder decoder;
    private ByteBuffer bytes = ByteBuffer.allocate(8192);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.828 -0400", hash_original_method = "3590A2EED02D10C52AB0172AD4BE22C4", hash_generated_method = "73161F0B246AE3084A360E06EA84EE17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStreamReader(InputStream in) {
        this(in, Charset.defaultCharset());
        dsTaint.addTaint(in.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.828 -0400", hash_original_method = "EBBB6FD529AC9BA283207DBA01D68764", hash_generated_method = "0CBE523C0F798CB4CFE31B29C74ABE03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStreamReader(InputStream in, final String enc) throws UnsupportedEncodingException {
        super(in);
        dsTaint.addTaint(in.dsTaint);
        dsTaint.addTaint(enc);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        try 
        {
            decoder = Charset.forName(enc).newDecoder().onMalformedInput(
                    CodingErrorAction.REPLACE).onUnmappableCharacter(
                    CodingErrorAction.REPLACE);
        } //End block
        catch (IllegalArgumentException e)
        {
            if (DroidSafeAndroidRuntime.control) throw (UnsupportedEncodingException)
                    new UnsupportedEncodingException(enc).initCause(e);
        } //End block
        bytes.limit(0);
        // ---------- Original Method ----------
        //if (enc == null) {
            //throw new NullPointerException();
        //}
        //this.in = in;
        //try {
            //decoder = Charset.forName(enc).newDecoder().onMalformedInput(
                    //CodingErrorAction.REPLACE).onUnmappableCharacter(
                    //CodingErrorAction.REPLACE);
        //} catch (IllegalArgumentException e) {
            //throw (UnsupportedEncodingException)
                    //new UnsupportedEncodingException(enc).initCause(e);
        //}
        //bytes.limit(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.828 -0400", hash_original_method = "A7068E06FC6AB9497581BF79FF6884E3", hash_generated_method = "43747D8EB8EAE0AB7D4E0D1326C21511")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStreamReader(InputStream in, CharsetDecoder dec) {
        super(in);
        dsTaint.addTaint(dec.dsTaint);
        dsTaint.addTaint(in.dsTaint);
        dec.averageCharsPerByte();
        bytes.limit(0);
        // ---------- Original Method ----------
        //dec.averageCharsPerByte();
        //this.in = in;
        //decoder = dec;
        //bytes.limit(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.829 -0400", hash_original_method = "F689BDB30C937E91D3C146F93A07A4B9", hash_generated_method = "ADB50AFC1BCC617D2A5FE1EEEA991A6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputStreamReader(InputStream in, Charset charset) {
        super(in);
        dsTaint.addTaint(charset.dsTaint);
        dsTaint.addTaint(in.dsTaint);
        decoder = charset.newDecoder().onMalformedInput(
                CodingErrorAction.REPLACE).onUnmappableCharacter(
                CodingErrorAction.REPLACE);
        bytes.limit(0);
        // ---------- Original Method ----------
        //this.in = in;
        //decoder = charset.newDecoder().onMalformedInput(
                //CodingErrorAction.REPLACE).onUnmappableCharacter(
                //CodingErrorAction.REPLACE);
        //bytes.limit(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.829 -0400", hash_original_method = "FE46DA5B445A82E67613621D1604074D", hash_generated_method = "91CD4FB6B2BDBF7D5C31CD457304E226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        {
            {
                decoder.reset();
            } //End block
            decoder = null;
            {
                in.close();
                in = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (decoder != null) {
                //decoder.reset();
            //}
            //decoder = null;
            //if (in != null) {
                //in.close();
                //in = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.829 -0400", hash_original_method = "4B46B0B3D8C39E950459FB803D7FD65D", hash_generated_method = "53A5555AF8167F7D0419978367C5CC73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEncoding() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_875321230 = (!isOpen());
        } //End collapsed parenthetic
        String var817FF4900D55FF602379C3CEBE77261F_226166954 = (HistoricalCharsetNames.get(decoder.charset()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //return null;
        //}
        //return HistoricalCharsetNames.get(decoder.charset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.829 -0400", hash_original_method = "42220754D208F7633D722D928E4FD163", hash_generated_method = "9544D61362AFDDE436A3D8CEF5379A6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read() throws IOException {
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_1240246987 = (!isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("InputStreamReader is closed");
                } //End block
            } //End collapsed parenthetic
            char[] buf;
            buf = new char[1];
            {
                boolean varBFA2CBA932C78B2EDB4EFBCC9C2BD268_860873072 = (read(buf, 0, 1) != -1);
            } //End flattened ternary
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (!isOpen()) {
                //throw new IOException("InputStreamReader is closed");
            //}
            //char[] buf = new char[1];
            //return read(buf, 0, 1) != -1 ? buf[0] : -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.830 -0400", hash_original_method = "610EEC39BC95175186F6D1B73FBDC240", hash_generated_method = "F7036159B2D65A6B59E4073CFDE9D1F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_1248907849 = (!isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("InputStreamReader is closed");
                } //End block
            } //End collapsed parenthetic
            Arrays.checkOffsetAndCount(buffer.length, offset, length);
            CharBuffer out;
            out = CharBuffer.wrap(buffer, offset, length);
            CoderResult result;
            result = CoderResult.UNDERFLOW;
            boolean needInput;
            needInput = !bytes.hasRemaining();
            {
                boolean var6EA51BFF030AC0EE79ECA43CE531D9FC_799050850 = (out.hasRemaining());
                {
                    {
                        try 
                        {
                            {
                                boolean var4AC61F8278E79629BB6185CF1B67BBC0_63652414 = (in.available() == 0 && out.position() > offset);
                            } //End collapsed parenthetic
                        } //End block
                        catch (IOException e)
                        { }
                        int desiredByteCount;
                        desiredByteCount = bytes.capacity() - bytes.limit();
                        int off;
                        off = bytes.arrayOffset() + bytes.limit();
                        int actualByteCount;
                        actualByteCount = in.read(bytes.array(), off, desiredByteCount);
                        {
                            endOfInput = true;
                        } //End block
                        bytes.limit(bytes.limit() + actualByteCount);
                        needInput = false;
                    } //End block
                    result = decoder.decode(bytes, out, false);
                    {
                        boolean varAC4D83163F80498905F17C73ED1D644E_1284321380 = (result.isUnderflow());
                        {
                            {
                                boolean var48640C2061CEED262B55902D998F4A8C_1946213943 = (bytes.limit() == bytes.capacity());
                                {
                                    bytes.compact();
                                    bytes.limit(bytes.position());
                                    bytes.position(0);
                                } //End block
                            } //End collapsed parenthetic
                            needInput = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                result = decoder.decode(bytes, out, true);
                decoder.flush(out);
                decoder.reset();
            } //End block
            {
                boolean var6B3A7901B659B60BD25125F126644325_1546621780 = (result.isMalformed() || result.isUnmappable());
                {
                    result.throwException();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varE052619487BC744D8B744A86EA346CB4_1574197432 = (out.position() - offset == 0);
                Object var0963A0483AED66CC947363DDE1373507_1449787573 = (out.position() - offset);
            } //End flattened ternary
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.831 -0400", hash_original_method = "2814A675517787CC2FFF66E2663BBAA6", hash_generated_method = "05F559D4652E1BD1F3A59BE500066616")
    @DSModeled(DSC.SAFE)
    private boolean isOpen() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return in != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.831 -0400", hash_original_method = "281B3CA6768822BAE894DB2D1EB23921", hash_generated_method = "6B58ED906FF68D8E6C0F41521E8CF377")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean ready() throws IOException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("InputStreamReader is closed");
            } //End block
            try 
            {
                boolean varD153F2A141285B7908CE526B5F4D7ED6_1529627985 = (bytes.hasRemaining() || in.available() > 0);
            } //End block
            catch (IOException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (in == null) {
                //throw new IOException("InputStreamReader is closed");
            //}
            //try {
                //return bytes.hasRemaining() || in.available() > 0;
            //} catch (IOException e) {
                //return false;
            //}
        //}
    }

    
}

