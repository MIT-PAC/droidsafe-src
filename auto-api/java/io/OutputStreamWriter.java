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
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

public class OutputStreamWriter extends Writer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.325 -0400", hash_original_field = "C68271A63DDBC431C307BEB7D2918275", hash_generated_field = "FAC7CE5410064D378AF9E7B2309C5BE9")

    private OutputStream out;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.326 -0400", hash_original_field = "724A00E315992B82D662231EA0DCBE50", hash_generated_field = "A07B3C678B690A0A298B0184B628874A")

    private CharsetEncoder encoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.326 -0400", hash_original_field = "50E41AB3FDB67E2442AFB04B480B97A2", hash_generated_field = "A3FC74598F816F44A8E790B9843EEF7E")

    private ByteBuffer bytes = ByteBuffer.allocate(8192);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.326 -0400", hash_original_method = "8C206CCA706FC5574C37E56D894D8687", hash_generated_method = "A65923CB537A3E6CFE8AB882E44ABF1A")
    public  OutputStreamWriter(OutputStream out) {
        this(out, Charset.defaultCharset());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.326 -0400", hash_original_method = "FE2D64915F756E150E2359224C906A4F", hash_generated_method = "E6B40133128F40D312C008BFFF8AE10E")
    public  OutputStreamWriter(OutputStream out, final String enc) throws UnsupportedEncodingException {
        super(out);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.out = out;
        try 
        {
            encoder = Charset.forName(enc).newEncoder();
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedEncodingException(enc);
        } //End block
        encoder.onMalformedInput(CodingErrorAction.REPLACE);
        encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        // ---------- Original Method ----------
        //if (enc == null) {
            //throw new NullPointerException();
        //}
        //this.out = out;
        //try {
            //encoder = Charset.forName(enc).newEncoder();
        //} catch (Exception e) {
            //throw new UnsupportedEncodingException(enc);
        //}
        //encoder.onMalformedInput(CodingErrorAction.REPLACE);
        //encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.327 -0400", hash_original_method = "8F31DE887FC24410EE09434FBA44CA21", hash_generated_method = "B1E3E8C23C37F25FE6C0A3EDCFDF5EE6")
    public  OutputStreamWriter(OutputStream out, Charset cs) {
        super(out);
        this.out = out;
        encoder = cs.newEncoder();
        encoder.onMalformedInput(CodingErrorAction.REPLACE);
        encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
        // ---------- Original Method ----------
        //this.out = out;
        //encoder = cs.newEncoder();
        //encoder.onMalformedInput(CodingErrorAction.REPLACE);
        //encoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.327 -0400", hash_original_method = "C5AFC76AE8F04EED9C657E07A65429EA", hash_generated_method = "626EF98BAB75BECB16EB0021472230A0")
    public  OutputStreamWriter(OutputStream out, CharsetEncoder enc) {
        super(out);
        enc.charset();
        this.out = out;
        encoder = enc;
        // ---------- Original Method ----------
        //enc.charset();
        //this.out = out;
        //encoder = enc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.327 -0400", hash_original_method = "348EDF61477AE4A3DCAC4870D899F874", hash_generated_method = "0F9AAA4D045280E27D752D538A167E2B")
    @Override
    public void close() throws IOException {
        {
            {
                drainEncoder();
                flushBytes(false);
                out.close();
                encoder = null;
                bytes = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (encoder != null) {
                //drainEncoder();
                //flushBytes(false);
                //out.close();
                //encoder = null;
                //bytes = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.328 -0400", hash_original_method = "E89503CD667F6DF7A02E3D218DF666E8", hash_generated_method = "27D5E48695D4DA71C3C79EED49114041")
    @Override
    public void flush() throws IOException {
        flushBytes(true);
        // ---------- Original Method ----------
        //flushBytes(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.328 -0400", hash_original_method = "0B376EED04C0EE48C2109F7445B1F9FC", hash_generated_method = "CB23A323A1C340B164DA1BE2E8B54B3C")
    private void flushBytes(boolean flushUnderlyingStream) throws IOException {
        {
            checkStatus();
            int position;
            position = bytes.position();
            {
                bytes.flip();
                out.write(bytes.array(), bytes.arrayOffset(), position);
                bytes.clear();
            } //End block
            {
                out.flush();
            } //End block
        } //End block
        addTaint(flushUnderlyingStream);
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkStatus();
            //int position = bytes.position();
            //if (position > 0) {
                //bytes.flip();
                //out.write(bytes.array(), bytes.arrayOffset(), position);
                //bytes.clear();
            //}
            //if (flushUnderlyingStream) {
                //out.flush();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.328 -0400", hash_original_method = "5FDBBBBEF70B98878F7238A71245F3A5", hash_generated_method = "D4039FAF001267CF597B424EF56BEBCC")
    private void convert(CharBuffer chars) throws IOException {
        {
            CoderResult result;
            result = encoder.encode(chars, bytes, false);
            {
                boolean var2AAE7F5A955BA87C5F37AFB5998173CD_116639060 = (result.isOverflow());
                {
                    flushBytes(false);
                } //End block
                {
                    boolean varF7BD3CBEDDA7528374E2BADAF0C2CE69_1984186168 = (result.isError());
                    {
                        result.throwException();
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        addTaint(chars.getTaint());
        // ---------- Original Method ----------
        //while (true) {
            //CoderResult result = encoder.encode(chars, bytes, false);
            //if (result.isOverflow()) {
                //flushBytes(false);
                //continue;
            //} else if (result.isError()) {
                //result.throwException();
            //}
            //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.330 -0400", hash_original_method = "17AF81F5CD218F57FFE1053C07491E0D", hash_generated_method = "22AA7CEF307547C3D7217E7D85FD91DB")
    private void drainEncoder() throws IOException {
        CharBuffer chars;
        chars = CharBuffer.allocate(0);
        {
            CoderResult result;
            result = encoder.encode(chars, bytes, true);
            {
                boolean varFA1F9C74A878DA56E1CBBC06101478FE_1955395290 = (result.isError());
                {
                    result.throwException();
                } //End block
                {
                    boolean varD20C9318A05139203F7B82FC87F4D343_41638194 = (result.isOverflow());
                    {
                        flushBytes(false);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        CoderResult result;
        result = encoder.flush(bytes);
        {
            boolean var6269F73C38E0F4CC7433B3E45BCBBD1A_1133128199 = (!result.isUnderflow());
            {
                {
                    boolean varD20C9318A05139203F7B82FC87F4D343_68674597 = (result.isOverflow());
                    {
                        flushBytes(false);
                        result = encoder.flush(bytes);
                    } //End block
                    {
                        result.throwException();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //CharBuffer chars = CharBuffer.allocate(0);
        //while (true) {
            //CoderResult result = encoder.encode(chars, bytes, true);
            //if (result.isError()) {
                //result.throwException();
            //} else if (result.isOverflow()) {
                //flushBytes(false);
                //continue;
            //}
            //break;
        //}
        //CoderResult result = encoder.flush(bytes);
        //while (!result.isUnderflow()) {
            //if (result.isOverflow()) {
                //flushBytes(false);
                //result = encoder.flush(bytes);
            //} else {
                //result.throwException();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.330 -0400", hash_original_method = "75BDF3BC8D58179DECD9AB14C1C7F3EE", hash_generated_method = "0CCFD47D8052AACFCCB82C51FB64AB87")
    private void checkStatus() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("OutputStreamWriter is closed");
        } //End block
        // ---------- Original Method ----------
        //if (encoder == null) {
            //throw new IOException("OutputStreamWriter is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.344 -0400", hash_original_method = "A69A1F1EB2BFDD0474AAD9460630967D", hash_generated_method = "9B84F7EE829127D95D625DB739D564E9")
    public String getEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_1710293430 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_372373534 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1710293430 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_372373534 = HistoricalCharsetNames.get(encoder.charset());
        String varA7E53CE21691AB073D9660D615818899_1346710630; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1346710630 = varB4EAC82CA7396A68D541C85D26508E83_1710293430;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1346710630 = varB4EAC82CA7396A68D541C85D26508E83_372373534;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1346710630.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1346710630;
        // ---------- Original Method ----------
        //if (encoder == null) {
            //return null;
        //}
        //return HistoricalCharsetNames.get(encoder.charset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.345 -0400", hash_original_method = "A1014AE81A36DB02C830992F3B254644", hash_generated_method = "85C21ED15D3CE069C74C929A6579352E")
    @Override
    public void write(char[] buffer, int offset, int count) throws IOException {
        {
            checkStatus();
            Arrays.checkOffsetAndCount(buffer.length, offset, count);
            CharBuffer chars;
            chars = CharBuffer.wrap(buffer, offset, count);
            convert(chars);
        } //End block
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkStatus();
            //Arrays.checkOffsetAndCount(buffer.length, offset, count);
            //CharBuffer chars = CharBuffer.wrap(buffer, offset, count);
            //convert(chars);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.345 -0400", hash_original_method = "9F78C67C90A8F7A084F2E3084DB157FE", hash_generated_method = "D032140F2460F18E650922614EE1FB50")
    @Override
    public void write(int oneChar) throws IOException {
        {
            checkStatus();
            CharBuffer chars;
            chars = CharBuffer.wrap(new char[] { (char) oneChar });
            convert(chars);
        } //End block
        addTaint(oneChar);
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkStatus();
            //CharBuffer chars = CharBuffer.wrap(new char[] { (char) oneChar });
            //convert(chars);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.346 -0400", hash_original_method = "720362548945B36884470AD2C6B99C23", hash_generated_method = "E897375CEF8328AB0395C130F5FE8D56")
    @Override
    public void write(String str, int offset, int count) throws IOException {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(str, offset, count);
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException("str == null");
            } //End block
            {
                boolean varE39C66E187123901EC1A51437E6D0861_1289881086 = ((offset | count) < 0 || offset > str.length() - count);
                {
                    if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(str, offset, count);
                } //End block
            } //End collapsed parenthetic
            checkStatus();
            CharBuffer chars;
            chars = CharBuffer.wrap(str, offset, count + offset);
            convert(chars);
        } //End block
        addTaint(str.getTaint());
        addTaint(offset);
        addTaint(count);
        // ---------- Original Method ----------
        //synchronized (lock) {
            //if (count < 0) {
                //throw new StringIndexOutOfBoundsException(str, offset, count);
            //}
            //if (str == null) {
                //throw new NullPointerException("str == null");
            //}
            //if ((offset | count) < 0 || offset > str.length() - count) {
                //throw new StringIndexOutOfBoundsException(str, offset, count);
            //}
            //checkStatus();
            //CharBuffer chars = CharBuffer.wrap(str, offset, count + offset);
            //convert(chars);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.346 -0400", hash_original_method = "E279B5931B3E4ADEA2A691FE75B2536D", hash_generated_method = "4E6D4CAFF28A8047D96CBEC0662E4DD5")
    @Override
     boolean checkError() {
        boolean varE897CEE6D3B84AA9639D67587BC457A0_1429563971 = (out.checkError());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7506027 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7506027;
        // ---------- Original Method ----------
        //return out.checkError();
    }

    
}

