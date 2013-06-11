package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

public class OutputStreamWriter extends Writer {
    private final OutputStream out;
    private CharsetEncoder encoder;
    private ByteBuffer bytes = ByteBuffer.allocate(8192);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.648 -0400", hash_original_method = "8C206CCA706FC5574C37E56D894D8687", hash_generated_method = "79DA7F89B527F210EE1BAECFDD6415E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStreamWriter(OutputStream out) {
        this(out, Charset.defaultCharset());
        dsTaint.addTaint(out.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.648 -0400", hash_original_method = "FE2D64915F756E150E2359224C906A4F", hash_generated_method = "E882E297B133F09698A0C0394BD0E5F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStreamWriter(OutputStream out, final String enc) throws UnsupportedEncodingException {
        super(out);
        dsTaint.addTaint(out.dsTaint);
        dsTaint.addTaint(enc);
        this.out = out;
        {
        	if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        try 
        {
            encoder = Charset.forName(enc).newEncoder();
        } //End block
        catch (Exception e)
        {
            throw new UnsupportedEncodingException(enc);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.648 -0400", hash_original_method = "8F31DE887FC24410EE09434FBA44CA21", hash_generated_method = "F5D9F6285CD4D6E63E4515D713BFEF34")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStreamWriter(OutputStream out, Charset cs) {
        super(out);
        dsTaint.addTaint(out.dsTaint);
        dsTaint.addTaint(cs.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.648 -0400", hash_original_method = "C5AFC76AE8F04EED9C657E07A65429EA", hash_generated_method = "2B67FA77F26CB9CB9F391CF7E856B702")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public OutputStreamWriter(OutputStream out, CharsetEncoder enc) {
        super(out);
        dsTaint.addTaint(out.dsTaint);
        dsTaint.addTaint(enc.dsTaint);
        this.out = out;
        enc.charset();
        // ---------- Original Method ----------
        //enc.charset();
        //this.out = out;
        //encoder = enc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.648 -0400", hash_original_method = "348EDF61477AE4A3DCAC4870D899F874", hash_generated_method = "04C3BF4BCA543251E501D098906805A0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.648 -0400", hash_original_method = "E89503CD667F6DF7A02E3D218DF666E8", hash_generated_method = "CB085FB7BD3475EB975DDCBB86F3DEF5")
    @DSModeled(DSC.SAFE)
    @Override
    public void flush() throws IOException {
        flushBytes(true);
        // ---------- Original Method ----------
        //flushBytes(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.648 -0400", hash_original_method = "0B376EED04C0EE48C2109F7445B1F9FC", hash_generated_method = "42D993603189A914454622E500E1ECDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void flushBytes(boolean flushUnderlyingStream) throws IOException {
        dsTaint.addTaint(flushUnderlyingStream);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.649 -0400", hash_original_method = "5FDBBBBEF70B98878F7238A71245F3A5", hash_generated_method = "41E063BDB36B5B3573B6EEE05F25B823")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void convert(CharBuffer chars) throws IOException {
        dsTaint.addTaint(chars.dsTaint);
        {
            CoderResult result;
            result = encoder.encode(chars, bytes, false);
            {
                boolean var2AAE7F5A955BA87C5F37AFB5998173CD_814056546 = (result.isOverflow());
                {
                    flushBytes(false);
                } //End block
                {
                    boolean varF7BD3CBEDDA7528374E2BADAF0C2CE69_926388706 = (result.isError());
                    {
                        result.throwException();
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.649 -0400", hash_original_method = "17AF81F5CD218F57FFE1053C07491E0D", hash_generated_method = "2F71A8677DE0AF27B6335273A8EE92CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void drainEncoder() throws IOException {
        CharBuffer chars;
        chars = CharBuffer.allocate(0);
        {
            CoderResult result;
            result = encoder.encode(chars, bytes, true);
            {
                boolean varFA1F9C74A878DA56E1CBBC06101478FE_265660962 = (result.isError());
                {
                    result.throwException();
                } //End block
                {
                    boolean varD20C9318A05139203F7B82FC87F4D343_2076790734 = (result.isOverflow());
                    {
                        flushBytes(false);
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        CoderResult result;
        result = encoder.flush(bytes);
        {
            boolean var6269F73C38E0F4CC7433B3E45BCBBD1A_260144857 = (!result.isUnderflow());
            {
                {
                    boolean varD20C9318A05139203F7B82FC87F4D343_1106800637 = (result.isOverflow());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.649 -0400", hash_original_method = "75BDF3BC8D58179DECD9AB14C1C7F3EE", hash_generated_method = "7888972EC1D8C06CF3314602E64A61BA")
    @DSModeled(DSC.SAFE)
    private void checkStatus() throws IOException {
        {
            throw new IOException("OutputStreamWriter is closed");
        } //End block
        // ---------- Original Method ----------
        //if (encoder == null) {
            //throw new IOException("OutputStreamWriter is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.649 -0400", hash_original_method = "A69A1F1EB2BFDD0474AAD9460630967D", hash_generated_method = "59CBABFBBC09CBD19059E242B4E75A36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getEncoding() {
        String var6D7E9569479C7184C40465F6E22AC692_883922486 = (HistoricalCharsetNames.get(encoder.charset()));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (encoder == null) {
            //return null;
        //}
        //return HistoricalCharsetNames.get(encoder.charset());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.649 -0400", hash_original_method = "A1014AE81A36DB02C830992F3B254644", hash_generated_method = "309CB283C07565EB6C0688B9D19F3771")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(char[] buffer, int offset, int count) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        {
            checkStatus();
            Arrays.checkOffsetAndCount(buffer.length, offset, count);
            CharBuffer chars;
            chars = CharBuffer.wrap(buffer, offset, count);
            convert(chars);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkStatus();
            //Arrays.checkOffsetAndCount(buffer.length, offset, count);
            //CharBuffer chars = CharBuffer.wrap(buffer, offset, count);
            //convert(chars);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.649 -0400", hash_original_method = "9F78C67C90A8F7A084F2E3084DB157FE", hash_generated_method = "8DDDC7E119051404B8EB427B0AABB715")
    @DSModeled(DSC.SAFE)
    @Override
    public void write(int oneChar) throws IOException {
        dsTaint.addTaint(oneChar);
        {
            checkStatus();
            CharBuffer chars;
            chars = CharBuffer.wrap(new char[] { (char) oneChar });
            convert(chars);
        } //End block
        // ---------- Original Method ----------
        //synchronized (lock) {
            //checkStatus();
            //CharBuffer chars = CharBuffer.wrap(new char[] { (char) oneChar });
            //convert(chars);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.649 -0400", hash_original_method = "720362548945B36884470AD2C6B99C23", hash_generated_method = "FEB6AA88AADF69DAE0F6BA520B4E6133")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(String str, int offset, int count) throws IOException {
        dsTaint.addTaint(str);
        dsTaint.addTaint(count);
        dsTaint.addTaint(offset);
        {
            {
            	if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(str, offset, count);
            } //End block
            {
            	if (DroidSafeAndroidRuntime.control) throw new NullPointerException("str == null");
            } //End block
            {
                boolean varE39C66E187123901EC1A51437E6D0861_586871488 = ((offset | count) < 0 || offset > str.length() - count);
                {
                	if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(str, offset, count);
                } //End block
            } //End collapsed parenthetic
            checkStatus();
            CharBuffer chars;
            chars = CharBuffer.wrap(str, offset, count + offset);
            convert(chars);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.649 -0400", hash_original_method = "E279B5931B3E4ADEA2A691FE75B2536D", hash_generated_method = "8EE98D94ACD9950F1058590C4AD9606E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     boolean checkError() {
        boolean varE897CEE6D3B84AA9639D67587BC457A0_962131807 = (out.checkError());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return out.checkError();
    }

    
}


