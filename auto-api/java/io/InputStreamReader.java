package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.095 -0400", hash_original_field = "13B5BFE96F3E2FE411C9F66F4A582ADF", hash_generated_field = "9DA78E40E39AA56A72373CEA8B1326DF")

    private InputStream in;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.095 -0400", hash_original_field = "1BD372EDACBB8876856A0324150C4E1B", hash_generated_field = "C1BD264EA71B8905202FEFE2EB6106E5")

    private boolean endOfInput = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.095 -0400", hash_original_field = "3A6BDBA8FB33A88CF7D52A1AF07A9C00", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.095 -0400", hash_original_field = "50E41AB3FDB67E2442AFB04B480B97A2", hash_generated_field = "C7ACDD8E59EDFE2B06C91B0B5639E9AE")

    private final ByteBuffer bytes = ByteBuffer.allocate(8192);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.096 -0400", hash_original_method = "3590A2EED02D10C52AB0172AD4BE22C4", hash_generated_method = "C11E1C8740A43C21BC55AB18059CCFB4")
    public  InputStreamReader(InputStream in) {
        this(in, Charset.defaultCharset());
        addTaint(in.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.096 -0400", hash_original_method = "EBBB6FD529AC9BA283207DBA01D68764", hash_generated_method = "B19D799ED9C44B276EEBF3E22A0E9CFA")
    public  InputStreamReader(InputStream in, final String enc) throws UnsupportedEncodingException {
        super(in);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.in = in;
        try 
        {
            decoder = Charset.forName(enc).newDecoder().onMalformedInput(
                    CodingErrorAction.REPLACE).onUnmappableCharacter(
                    CodingErrorAction.REPLACE);
        } 
        catch (IllegalArgumentException e)
        {
            if (DroidSafeAndroidRuntime.control) throw (UnsupportedEncodingException)
                    new UnsupportedEncodingException(enc).initCause(e);
        } 
        bytes.limit(0);
        
        
            
        
        
        
            
                    
                    
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.096 -0400", hash_original_method = "A7068E06FC6AB9497581BF79FF6884E3", hash_generated_method = "B08D041F736141AFFE6AB91E312D04A3")
    public  InputStreamReader(InputStream in, CharsetDecoder dec) {
        super(in);
        dec.averageCharsPerByte();
        this.in = in;
        decoder = dec;
        bytes.limit(0);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.097 -0400", hash_original_method = "F689BDB30C937E91D3C146F93A07A4B9", hash_generated_method = "638E03BD1AF4CDE5E50D3D3938B8A100")
    public  InputStreamReader(InputStream in, Charset charset) {
        super(in);
        this.in = in;
        decoder = charset.newDecoder().onMalformedInput(
                CodingErrorAction.REPLACE).onUnmappableCharacter(
                CodingErrorAction.REPLACE);
        bytes.limit(0);
        
        
        
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.097 -0400", hash_original_method = "FE46DA5B445A82E67613621D1604074D", hash_generated_method = "91CD4FB6B2BDBF7D5C31CD457304E226")
    @Override
    public void close() throws IOException {
        {
            {
                decoder.reset();
            } 
            decoder = null;
            {
                in.close();
                in = null;
            } 
        } 
        
        
            
                
            
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.098 -0400", hash_original_method = "4B46B0B3D8C39E950459FB803D7FD65D", hash_generated_method = "E78CBEA15E9B3E8062C32106C5D3CD57")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_884814371 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_711548670 = null; 
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_926074416 = (!isOpen());
            {
                varB4EAC82CA7396A68D541C85D26508E83_884814371 = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_711548670 = HistoricalCharsetNames.get(decoder.charset());
        String varA7E53CE21691AB073D9660D615818899_973546859; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_973546859 = varB4EAC82CA7396A68D541C85D26508E83_884814371;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_973546859 = varB4EAC82CA7396A68D541C85D26508E83_711548670;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_973546859.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_973546859;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.099 -0400", hash_original_method = "42220754D208F7633D722D928E4FD163", hash_generated_method = "87C2F29A671269A2B426E0FC74BFA5DA")
    @Override
    public int read() throws IOException {
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_1888931720 = (!isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("InputStreamReader is closed");
                } 
            } 
            char[] buf = new char[1];
            {
                boolean varBFA2CBA932C78B2EDB4EFBCC9C2BD268_1025252901 = (read(buf, 0, 1) != -1);
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_160637149 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_160637149;
        
        
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.100 -0400", hash_original_method = "610EEC39BC95175186F6D1B73FBDC240", hash_generated_method = "68DC1DAC756613F1D3485322C3F4B19B")
    @Override
    public int read(char[] buffer, int offset, int length) throws IOException {
        {
            {
                boolean varC984E2D68DED4A73C5D827F4E91A6961_40024360 = (!isOpen());
                {
                    if (DroidSafeAndroidRuntime.control) throw new IOException("InputStreamReader is closed");
                } 
            } 
            Arrays.checkOffsetAndCount(buffer.length, offset, length);
            CharBuffer out = CharBuffer.wrap(buffer, offset, length);
            CoderResult result = CoderResult.UNDERFLOW;
            boolean needInput = !bytes.hasRemaining();
            {
                boolean var6EA51BFF030AC0EE79ECA43CE531D9FC_992242704 = (out.hasRemaining());
                {
                    {
                        try 
                        {
                            {
                                boolean var4AC61F8278E79629BB6185CF1B67BBC0_913404665 = (in.available() == 0 && out.position() > offset);
                            } 
                        } 
                        catch (IOException e)
                        { }
                        int desiredByteCount = bytes.capacity() - bytes.limit();
                        int off = bytes.arrayOffset() + bytes.limit();
                        int actualByteCount = in.read(bytes.array(), off, desiredByteCount);
                        {
                            endOfInput = true;
                        } 
                        bytes.limit(bytes.limit() + actualByteCount);
                        needInput = false;
                    } 
                    result = decoder.decode(bytes, out, false);
                    {
                        boolean varAC4D83163F80498905F17C73ED1D644E_2122957616 = (result.isUnderflow());
                        {
                            {
                                boolean var48640C2061CEED262B55902D998F4A8C_34775211 = (bytes.limit() == bytes.capacity());
                                {
                                    bytes.compact();
                                    bytes.limit(bytes.position());
                                    bytes.position(0);
                                } 
                            } 
                            needInput = true;
                        } 
                    } 
                } 
            } 
            {
                result = decoder.decode(bytes, out, true);
                decoder.flush(out);
                decoder.reset();
            } 
            {
                boolean var6B3A7901B659B60BD25125F126644325_609147635 = (result.isMalformed() || result.isUnmappable());
                {
                    result.throwException();
                } 
            } 
            {
                boolean varE052619487BC744D8B744A86EA346CB4_1735344794 = (out.position() - offset == 0);
                Object var0963A0483AED66CC947363DDE1373507_1525724687 = (out.position() - offset);
            } 
        } 
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516922169 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516922169;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.101 -0400", hash_original_method = "2814A675517787CC2FFF66E2663BBAA6", hash_generated_method = "49D874379D0E719E8EB172AC835AF759")
    private boolean isOpen() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_910724077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_910724077;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.101 -0400", hash_original_method = "281B3CA6768822BAE894DB2D1EB23921", hash_generated_method = "06D0A8858F20C045600B1D81C3B9E934")
    @Override
    public boolean ready() throws IOException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("InputStreamReader is closed");
            } 
            try 
            {
                boolean varD153F2A141285B7908CE526B5F4D7ED6_1257991413 = (bytes.hasRemaining() || in.available() > 0);
            } 
            catch (IOException e)
            { }
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_572013564 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_572013564;
        
        
            
                
            
            
                
            
                
            
        
    }

    
}

