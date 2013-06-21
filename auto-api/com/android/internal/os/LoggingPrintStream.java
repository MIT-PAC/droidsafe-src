package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Formatter;
import java.util.Locale;

abstract class LoggingPrintStream extends PrintStream {
    private StringBuilder builder = new StringBuilder();
    private ByteBuffer encodedBytes;
    private CharBuffer decodedChars;
    private CharsetDecoder decoder;
    private Formatter formatter = new Formatter(builder, null);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.238 -0400", hash_original_method = "9EC321B6DFE561BEEE5F374ADAFA7A30", hash_generated_method = "0CF066A83124D2B7F58571604E6E54B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected LoggingPrintStream() {
        super(new OutputStream() {
            public void write(int oneByte) throws IOException {
                throw new AssertionError();
            }
        });
        // ---------- Original Method ----------
    }

    
    protected abstract void log(String line);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.239 -0400", hash_original_method = "B82EE3D19B5D6B5B238555A3C574E964", hash_generated_method = "E395ABEE7588D1C6079D814E6681CA0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void flush() {
        flush(true);
        // ---------- Original Method ----------
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.239 -0400", hash_original_method = "4ED1A827BC075458493301694F5FB1B1", hash_generated_method = "1719D0C6CC8EC849B385C4A5B347EDC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void flush(boolean completely) {
        dsTaint.addTaint(completely);
        int length;
        length = builder.length();
        int start;
        start = 0;
        int nextBreak;
        {
            boolean varCECC465DB0C1A2DC9772F41A0AEFAF78_352430289 = (start < length
                && (nextBreak = builder.indexOf("\n", start)) != -1);
            {
                log(builder.substring(start, nextBreak));
                start = nextBreak + 1;
            } //End block
        } //End collapsed parenthetic
        {
            {
                log(builder.substring(start));
            } //End block
            builder.setLength(0);
        } //End block
        {
            builder.delete(0, start);
        } //End block
        // ---------- Original Method ----------
        //int length = builder.length();
        //int start = 0;
        //int nextBreak;
        //while (start < length
                //&& (nextBreak = builder.indexOf("\n", start)) != -1) {
            //log(builder.substring(start, nextBreak));
            //start = nextBreak + 1;
        //}
        //if (completely) {
            //if (start < length) {
                //log(builder.substring(start));
            //}
            //builder.setLength(0);
        //} else {
            //builder.delete(0, start);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.239 -0400", hash_original_method = "2DD612F978C37BC7835E83A5EC002758", hash_generated_method = "50D410DA470C8529E20AFA3A4B28C702")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(int oneByte) {
        dsTaint.addTaint(oneByte);
        write(new byte[] { (byte) oneByte }, 0, 1);
        // ---------- Original Method ----------
        //write(new byte[] { (byte) oneByte }, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.239 -0400", hash_original_method = "DD74A1A5E8F3C8FBA0F2CF6C71691621", hash_generated_method = "6989D543F0B1D9078824E527AB54FC08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void write(byte[] buffer) {
        dsTaint.addTaint(buffer[0]);
        write(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.240 -0400", hash_original_method = "3A82678B6E3902D5ED4B1D00D7245300", hash_generated_method = "6E08D9CB2C427C6C3FE47A818D5BC42C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void write(byte bytes[], int start, int count) {
        dsTaint.addTaint(bytes);
        dsTaint.addTaint(count);
        dsTaint.addTaint(start);
        {
            encodedBytes = ByteBuffer.allocate(80);
            decodedChars = CharBuffer.allocate(80);
            decoder = Charset.defaultCharset().newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE);
        } //End block
        int end;
        end = start + count;
        {
            int numBytes;
            numBytes = Math.min(encodedBytes.remaining(), end - start);
            encodedBytes.put(bytes, start, numBytes);
            start += numBytes;
            encodedBytes.flip();
            CoderResult coderResult;
            {
                coderResult = decoder.decode(encodedBytes, decodedChars, false);
                decodedChars.flip();
                builder.append(decodedChars);
                decodedChars.clear();
            } //End block
            {
                boolean var1F4BF95B8230AF5CFFBC6FA75DC274CF_2049329248 = (coderResult.isOverflow());
            } //End collapsed parenthetic
            encodedBytes.compact();
        } //End block
        flush(false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.240 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "2FF37DAECB0C9D3F5F3B1ECF836EB450")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean checkError() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.240 -0400", hash_original_method = "51169B2EF8C8211EB75CA27439BAE4AB", hash_generated_method = "2A0A3827C6A0447713ECA04520FF48CE")
    @DSModeled(DSC.SAFE)
    @Override
    protected void setError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.240 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @DSModeled(DSC.SAFE)
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.240 -0400", hash_original_method = "05D45546979F5891D35AE44E50FD3553", hash_generated_method = "AB5B21F992775282F85742D29BF00509")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PrintStream format(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        PrintStream varD8F2A1654CF3ACCC2BDB72B521CFFC4B_1616901909 = (format(Locale.getDefault(), format, args));
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(Locale.getDefault(), format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.241 -0400", hash_original_method = "AF1C3DC823982E73CFCD03CCF036C65E", hash_generated_method = "BD7AD26F1217BE541827C9778E0485BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PrintStream printf(String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(format);
        PrintStream var332B80BC927C6FFEEC76D8998999F86B_942084978 = (format(format, args));
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.241 -0400", hash_original_method = "F50C21D98ADC94B4526029B9C256D54E", hash_generated_method = "0892D4E148E0BDBD88EDC017A2AFEDB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PrintStream printf(Locale l, String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        PrintStream var2451FE83B7001C97A9C60A0560E8EC1F_1496627504 = (format(l, format, args));
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format(l, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.241 -0400", hash_original_method = "F1983A352222AF67B3078F0EEE870AAE", hash_generated_method = "F2ECDF909DBE54B6541C86ADBCBAA67C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized PrintStream format(
            Locale l, String format, Object... args) {
        dsTaint.addTaint(args[0].dsTaint);
        dsTaint.addTaint(l.dsTaint);
        dsTaint.addTaint(format);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("format");
        } //End block
        formatter.format(l, format, args);
        flush(false);
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (format == null) {
            //throw new NullPointerException("format");
        //}
        //formatter.format(l, format, args);
        //flush(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.241 -0400", hash_original_method = "34D92369FB78C59105446434E08E5A35", hash_generated_method = "555761DC24F8B116080718B09E7F2E6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void print(char[] charArray) {
        dsTaint.addTaint(charArray[0]);
        builder.append(charArray);
        flush(false);
        // ---------- Original Method ----------
        //builder.append(charArray);
        //flush(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.241 -0400", hash_original_method = "9A1F4F8E7B087A358A5E2FCB594FC1F1", hash_generated_method = "3DACA15881DFA151FD48191F1099609C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void print(char ch) {
        dsTaint.addTaint(ch);
        builder.append(ch);
        {
            flush(false);
        } //End block
        // ---------- Original Method ----------
        //builder.append(ch);
        //if (ch == '\n') {
            //flush(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.242 -0400", hash_original_method = "820BD1560BF89A8CCF87FDD4C009E434", hash_generated_method = "85226E2E04CCF553B1A300283FB161B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void print(double dnum) {
        dsTaint.addTaint(dnum);
        builder.append(dnum);
        // ---------- Original Method ----------
        //builder.append(dnum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.242 -0400", hash_original_method = "BF192CAA8CC79321D5E28D82D881B0DE", hash_generated_method = "19C910DF3AB6CE0E712EBEF620EC1871")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void print(float fnum) {
        dsTaint.addTaint(fnum);
        builder.append(fnum);
        // ---------- Original Method ----------
        //builder.append(fnum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.242 -0400", hash_original_method = "EA729F5E50977D112911F5C250343E89", hash_generated_method = "9DA28C2D33B534FB99CE119038B15905")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void print(int inum) {
        dsTaint.addTaint(inum);
        builder.append(inum);
        // ---------- Original Method ----------
        //builder.append(inum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.242 -0400", hash_original_method = "2F9DD3DF69B1439CAC48F255A2B06D16", hash_generated_method = "DD50A7DD74AEB8BAE69DAFEE5E64493E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void print(long lnum) {
        dsTaint.addTaint(lnum);
        builder.append(lnum);
        // ---------- Original Method ----------
        //builder.append(lnum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.242 -0400", hash_original_method = "0154750185D34191234B4807E3679F12", hash_generated_method = "FFEE932456D142F4A35F9A9B188015E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void print(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        builder.append(obj);
        flush(false);
        // ---------- Original Method ----------
        //builder.append(obj);
        //flush(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.242 -0400", hash_original_method = "F2C90C1214AEAFC8178C26840ED36663", hash_generated_method = "8486EF357C7018D1E8EC036A5FF1425A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void print(String str) {
        dsTaint.addTaint(str);
        builder.append(str);
        flush(false);
        // ---------- Original Method ----------
        //builder.append(str);
        //flush(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.242 -0400", hash_original_method = "5ECA1B577D18215F52A8C9A6333D9CFC", hash_generated_method = "A93F940CBA95320896F73ADFBC6BCB56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void print(boolean bool) {
        dsTaint.addTaint(bool);
        builder.append(bool);
        // ---------- Original Method ----------
        //builder.append(bool);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.243 -0400", hash_original_method = "7A4D58C37164C3E851ED3ACE479C647B", hash_generated_method = "092FE2800A8865F19D4DB0FB3E12EEF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void println() {
        flush(true);
        // ---------- Original Method ----------
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.243 -0400", hash_original_method = "9D1363302FBD4F1058D52926AD245DD3", hash_generated_method = "BB61215027D22D62D194001B7A961AB5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void println(char[] charArray) {
        dsTaint.addTaint(charArray[0]);
        builder.append(charArray);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(charArray);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.243 -0400", hash_original_method = "01C278022DBB5824908D391A202B4A36", hash_generated_method = "A05F449FBE9494466A475BB8E98D4898")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void println(char ch) {
        dsTaint.addTaint(ch);
        builder.append(ch);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(ch);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.243 -0400", hash_original_method = "CE32681476B37833026295BF14F82F86", hash_generated_method = "67D43839E5619FA64B803B71E3360ADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void println(double dnum) {
        dsTaint.addTaint(dnum);
        builder.append(dnum);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(dnum);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.243 -0400", hash_original_method = "DD6ED147F9391D413B16E144DA317870", hash_generated_method = "90E2CD5431998A0732C95489BA30E380")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void println(float fnum) {
        dsTaint.addTaint(fnum);
        builder.append(fnum);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(fnum);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.244 -0400", hash_original_method = "AF6787AC8EF2FEBAAFAF97782B2D9A73", hash_generated_method = "32862A258EAF77CAB65147FFC1514CDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void println(int inum) {
        dsTaint.addTaint(inum);
        builder.append(inum);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(inum);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.244 -0400", hash_original_method = "460CB99F3847A5BE06D2BF7094246043", hash_generated_method = "3B249615ABE99D86F4213BF749102C52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void println(long lnum) {
        dsTaint.addTaint(lnum);
        builder.append(lnum);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(lnum);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.244 -0400", hash_original_method = "790D5F04D5F763A67F6384A1DADD6007", hash_generated_method = "0BD413432B17B85E46B506AE21D1DC4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void println(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        builder.append(obj);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(obj);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.244 -0400", hash_original_method = "EBB6B619FF9A797B3350DC2D212BCB5E", hash_generated_method = "EE320B556CACF2A6229BBA8B144D4092")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void println(String s) {
        dsTaint.addTaint(s);
        {
            boolean varA54061C544715EB0A7F9DC6F7247A715_1429343821 = (builder.length() == 0);
            {
                int length;
                length = s.length();
                int start;
                start = 0;
                int nextBreak;
                {
                    boolean var3E9DE48AFC111E2F733EDFF180729139_1681230070 = (start < length
                    && (nextBreak = s.indexOf('\n', start)) != -1);
                    {
                        log(s.substring(start, nextBreak));
                        start = nextBreak + 1;
                    } //End block
                } //End collapsed parenthetic
                {
                    log(s.substring(start));
                } //End block
            } //End block
            {
                builder.append(s);
                flush(true);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (builder.length() == 0) {
            //int length = s.length();
            //int start = 0;
            //int nextBreak;
            //while (start < length
                    //&& (nextBreak = s.indexOf('\n', start)) != -1) {
                //log(s.substring(start, nextBreak));
                //start = nextBreak + 1;
            //}
            //if (start < length) {
                //log(s.substring(start));
            //}
        //} else {
            //builder.append(s);
            //flush(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.244 -0400", hash_original_method = "09E0763383C859949559D7053E0AFD5D", hash_generated_method = "35D9B6BDEEC4A5CE76EF277447B93637")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized void println(boolean bool) {
        dsTaint.addTaint(bool);
        builder.append(bool);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(bool);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.245 -0400", hash_original_method = "C72D2A095158FF2DF7FBE0880B8BD63F", hash_generated_method = "5BAD4A2130C0495E56DA99A70AA1ECF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized PrintStream append(char c) {
        dsTaint.addTaint(c);
        print(c);
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //print(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.245 -0400", hash_original_method = "C203B04FBC05591B3DF1483A3F91F520", hash_generated_method = "5D3AD1F4E8973FF5D7688B36FB4799EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized PrintStream append(CharSequence csq) {
        dsTaint.addTaint(csq);
        builder.append(csq);
        flush(false);
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //builder.append(csq);
        //flush(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.245 -0400", hash_original_method = "6ED0867725346C7DB431FFF2CFBE5CE7", hash_generated_method = "08C3231B7601198B379656F46D8A57CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public synchronized PrintStream append(
            CharSequence csq, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(csq);
        dsTaint.addTaint(end);
        builder.append(csq, start, end);
        flush(false);
        return (PrintStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //builder.append(csq, start, end);
        //flush(false);
        //return this;
    }

    
}

