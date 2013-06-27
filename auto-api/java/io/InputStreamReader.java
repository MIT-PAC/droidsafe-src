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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.185 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.185 -0400", hash_original_field = "1BD372EDACBB8876856A0324150C4E1B", hash_generated_field = "C1BD264EA71B8905202FEFE2EB6106E5")

    private boolean endOfInput = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.185 -0400", hash_original_field = "3A6BDBA8FB33A88CF7D52A1AF07A9C00", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.185 -0400", hash_original_field = "50E41AB3FDB67E2442AFB04B480B97A2", hash_generated_field = "A3FC74598F816F44A8E790B9843EEF7E")

    private ByteBuffer bytes = ByteBuffer.allocate(8192);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.185 -0400", hash_original_method = "3590A2EED02D10C52AB0172AD4BE22C4", hash_generated_method = "C11E1C8740A43C21BC55AB18059CCFB4")
    public  InputStreamReader(InputStream in) {
        this(in, Charset.defaultCharset());
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.186 -0400", hash_original_method = "EBBB6FD529AC9BA283207DBA01D68764", hash_generated_method = "B19D799ED9C44B276EEBF3E22A0E9CFA")
    public  InputStreamReader(InputStream in, final String enc) throws UnsupportedEncodingException {
        super(in);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.in = in;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.187 -0400", hash_original_method = "A7068E06FC6AB9497581BF79FF6884E3", hash_generated_method = "B08D041F736141AFFE6AB91E312D04A3")
    public  InputStreamReader(InputStream in, CharsetDecoder dec) {
        super(in);
        dec.averageCharsPerByte();
        this.in = in;
        decoder = dec;
        bytes.limit(0);
        // ---------- Original Method ----------
        //dec.averageCharsPerByte();
        //this.in = in;
        //decoder = dec;
        //bytes.limit(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.187 -0400", hash_original_method = "F689BDB30C937E91D3C146F93A07A4B9", hash_generated_method = "638E03BD1AF4CDE5E50D3D3938B8A100")
    public  InputStreamReader(InputStream in, Charset charset) {
        super(in);
        this.in = in;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.188 -0400", hash_original_method = "FE46DA5B445A82E67613621D1604074D", hash_generated_method = "91CD4FB6B2BDBF7D5C31CD457304E226")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.197 -0400", hash_original_method = "4B46B0B3D8C39E950459FB803D7FD65D", hash_generated_method = "F47BE277B83A1C46E558E1F3A1B67E21")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1665045710 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_590116971 = null; //Variable for return #2
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1658263946 = (!isOpen());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1665045710 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_590116971 = HistoricalCharsetNames.get(decoder.charset());
        String varA7E53CE21691AB073D9660D615818899_2123847087; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2123847087 = varB4EAC82CA7396A68D541C85D26508E83_1665045710;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2123847087 = varB4EAC82CA7396A68D541C85D26508E83_590116971;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2123847087.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2123847087;
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //return null;
        //}
        //return HistoricalCharsetNames.get(decoder.charset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.198 -0400", hash_original_method = "42220754D208F7633D722D928E4FD163", hash_generated_method = "5E5B28BED0932E01F730FF80A64FA5E8")
    @Override
    public int read() throws IOException {
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_1412798557 = (!isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("InputStreamReader is closed");
                } //End block
            } //End collapsed parenthetic
            char[] buf;
            buf = new char[1];
            {
                boolean varBFA2CBA932C78B2EDB4EFBCC9C2BD268_714895379 = (read(buf, 0, 1) != -1);
            } //End flattened ternary
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000061999 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000061999;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (!isOpen()) {
                //throw new IOException("InputStreamReader is closed");
            //}
            //char[] buf = new char[1];
            //return read(buf, 0, 1) != -1 ? buf[0] : -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.205 -0400", hash_original_method = "610EEC39BC95175186F6D1B73FBDC240", hash_generated_method = "C8D3633C79143179F9CBCC3B80EF00BF")
    @Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_237690677 = (!isOpen());
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
                boolean var6EA51BFF030AC0EE79ECA43CE531D9FC_52013125 = (out.hasRemaining());
                {
                    {
                        try 
                        {
                            {
                                boolean var4AC61F8278E79629BB6185CF1B67BBC0_1894587121 = (in.available() == 0 && out.position() > offset);
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
                        boolean varAC4D83163F80498905F17C73ED1D644E_1623185626 = (result.isUnderflow());
                        {
                            {
                                boolean var48640C2061CEED262B55902D998F4A8C_1739557730 = (bytes.limit() == bytes.capacity());
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
                boolean var6B3A7901B659B60BD25125F126644325_1553175860 = (result.isMalformed() || result.isUnmappable());
                {
                    result.throwException();
                } //End block
            } //End collapsed parenthetic
            {
                boolean varE052619487BC744D8B744A86EA346CB4_1678519292 = (out.position() - offset == 0);
                Object var0963A0483AED66CC947363DDE1373507_1246484990 = (out.position() - offset);
            } //End flattened ternary
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903598410 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903598410;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.211 -0400", hash_original_method = "2814A675517787CC2FFF66E2663BBAA6", hash_generated_method = "32ACDAF4B1BFB892037405F62C2326DC")
    private boolean isOpen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_850809974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_850809974;
        // ---------- Original Method ----------
        //return in != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.212 -0400", hash_original_method = "281B3CA6768822BAE894DB2D1EB23921", hash_generated_method = "28D3C70575BD12C74B94B597C598E109")
    @Override
    public boolean ready() throws IOException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("InputStreamReader is closed");
            } //End block
            try 
            {
                boolean varD153F2A141285B7908CE526B5F4D7ED6_382469704 = (bytes.hasRemaining() || in.available() > 0);
            } //End block
            catch (IOException e)
            { }
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_863447527 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_863447527;
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

