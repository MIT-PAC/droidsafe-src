package com.android.internal.os;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.583 -0400", hash_original_field = "F3FE2D9E511ACAFB35D0D4B62216EA77", hash_generated_field = "F25016152F6B827256AC69E5E852FFFB")

    private final StringBuilder builder = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.583 -0400", hash_original_field = "67E97075F28081FE8D380FC823FD5C79", hash_generated_field = "12A99FAB87A4DFA0636B74A246FED9BE")

    private ByteBuffer encodedBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.583 -0400", hash_original_field = "C0BA4833ED6D5DC9B32E33A8BC4B863D", hash_generated_field = "F099383316D72C3F3F910ED1AEEDD48F")

    private CharBuffer decodedChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.583 -0400", hash_original_field = "3A6BDBA8FB33A88CF7D52A1AF07A9C00", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.583 -0400", hash_original_field = "82A6C186E4B45FBB3B170E2EBBEB6568", hash_generated_field = "188D772938696150A06C76EB179BFA12")

    private final Formatter formatter = new Formatter(builder, null);
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.035 -0400", hash_original_method = "9EC321B6DFE561BEEE5F374ADAFA7A30", hash_generated_method = "0CF066A83124D2B7F58571604E6E54B0")
    protected  LoggingPrintStream() {
        super(new OutputStream() {
            @DSModeled(DSC.BAN)
    public void write(int oneByte) throws IOException {
                throw new AssertionError();
            }
        });
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract void log(String line);

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.584 -0400", hash_original_method = "B82EE3D19B5D6B5B238555A3C574E964", hash_generated_method = "E395ABEE7588D1C6079D814E6681CA0E")
    @Override
    public synchronized void flush() {
        flush(true);
        // ---------- Original Method ----------
        //flush(true);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.585 -0400", hash_original_method = "4ED1A827BC075458493301694F5FB1B1", hash_generated_method = "A6C030FAC50FA899E35DBC5E95E375E8")
    private void flush(boolean completely) {
        addTaint(completely);
        int length = builder.length();
        int start = 0;
        int nextBreak;
        while
(start < length
                && (nextBreak = builder.indexOf("\n", start)) != -1)        
        {
            log(builder.substring(start, nextBreak));
            start = nextBreak + 1;
        } //End block
        if(completely)        
        {
            if(start < length)            
            {
                log(builder.substring(start));
            } //End block
            builder.setLength(0);
        } //End block
        else
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.586 -0400", hash_original_method = "2DD612F978C37BC7835E83A5EC002758", hash_generated_method = "19044F57C28D10A8762C56261C2825FA")
    public void write(int oneByte) {
        addTaint(oneByte);
        write(new byte[] { (byte) oneByte }, 0, 1);
        // ---------- Original Method ----------
        //write(new byte[] { (byte) oneByte }, 0, 1);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.587 -0400", hash_original_method = "DD74A1A5E8F3C8FBA0F2CF6C71691621", hash_generated_method = "42D2B6801CF74ED52F10052A1528442E")
    @Override
    public void write(byte[] buffer) {
        addTaint(buffer[0]);
        write(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.589 -0400", hash_original_method = "3A82678B6E3902D5ED4B1D00D7245300", hash_generated_method = "74A70BCD449487B7D297D3335B0C0D67")
    @Override
    public synchronized void write(byte bytes[], int start, int count) {
        addTaint(count);
        addTaint(start);
        addTaint(bytes[0]);
        if(decoder == null)        
        {
            encodedBytes = ByteBuffer.allocate(80);
            decodedChars = CharBuffer.allocate(80);
            decoder = Charset.defaultCharset().newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE);
        } //End block
        int end = start + count;
        while
(start < end)        
        {
            int numBytes = Math.min(encodedBytes.remaining(), end - start);
            encodedBytes.put(bytes, start, numBytes);
            start += numBytes;
            encodedBytes.flip();
            CoderResult coderResult;
            do {
                {
                    coderResult = decoder.decode(encodedBytes, decodedChars, false);
                    decodedChars.flip();
                    builder.append(decodedChars);
                    decodedChars.clear();
                } //End block
} while (coderResult.isOverflow());
            encodedBytes.compact();
        } //End block
        flush(false);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.589 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "9A194AB1E98142D937813C3441CD5093")
    @Override
    public boolean checkError() {
        boolean var68934A3E9455FA72420237EB05902327_889699645 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_970161077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_970161077;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.590 -0400", hash_original_method = "51169B2EF8C8211EB75CA27439BAE4AB", hash_generated_method = "2A0A3827C6A0447713ECA04520FF48CE")
    @Override
    protected void setError() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.590 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.590 -0400", hash_original_method = "05D45546979F5891D35AE44E50FD3553", hash_generated_method = "4B0E73C1987000748FB92AB2C21903FB")
    @Override
    public PrintStream format(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
PrintStream varAC550D889141827F9746A4BB1DA8EE48_261490805 =         format(Locale.getDefault(), format, args);
        varAC550D889141827F9746A4BB1DA8EE48_261490805.addTaint(taint);
        return varAC550D889141827F9746A4BB1DA8EE48_261490805;
        // ---------- Original Method ----------
        //return format(Locale.getDefault(), format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.591 -0400", hash_original_method = "AF1C3DC823982E73CFCD03CCF036C65E", hash_generated_method = "8C0E3D01F1562657160B09DC57EF8FAD")
    @Override
    public PrintStream printf(String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
PrintStream var1C1A7E0ECC814A41656D8DF055D1B8DD_2069410133 =         format(format, args);
        var1C1A7E0ECC814A41656D8DF055D1B8DD_2069410133.addTaint(taint);
        return var1C1A7E0ECC814A41656D8DF055D1B8DD_2069410133;
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.591 -0400", hash_original_method = "F50C21D98ADC94B4526029B9C256D54E", hash_generated_method = "8EC3AA912C4DA4720DFD76ED9781BFEC")
    @Override
    public PrintStream printf(Locale l, String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        addTaint(l.getTaint());
PrintStream varF1FD5ACC9778B4CFE10AE6C4FA9F1943_1678997674 =         format(l, format, args);
        varF1FD5ACC9778B4CFE10AE6C4FA9F1943_1678997674.addTaint(taint);
        return varF1FD5ACC9778B4CFE10AE6C4FA9F1943_1678997674;
        // ---------- Original Method ----------
        //return format(l, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.592 -0400", hash_original_method = "F1983A352222AF67B3078F0EEE870AAE", hash_generated_method = "65A330A65DA98C3F25D714BC566239ED")
    @Override
    public synchronized PrintStream format(
            Locale l, String format, Object... args) {
        addTaint(args[0].getTaint());
        addTaint(format.getTaint());
        addTaint(l.getTaint());
        if(format == null)        
        {
            NullPointerException varD3D016020AEA632D4CDB44DA9D1C05B2_915803094 = new NullPointerException("format");
            varD3D016020AEA632D4CDB44DA9D1C05B2_915803094.addTaint(taint);
            throw varD3D016020AEA632D4CDB44DA9D1C05B2_915803094;
        } //End block
        formatter.format(l, format, args);
        flush(false);
PrintStream var72A74007B2BE62B849F475C7BDA4658B_1298104794 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1298104794.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1298104794;
        // ---------- Original Method ----------
        //if (format == null) {
            //throw new NullPointerException("format");
        //}
        //formatter.format(l, format, args);
        //flush(false);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.592 -0400", hash_original_method = "34D92369FB78C59105446434E08E5A35", hash_generated_method = "3493EAB224538C362E40F9AA2A494CD6")
    @Override
    public synchronized void print(char[] charArray) {
        addTaint(charArray[0]);
        builder.append(charArray);
        flush(false);
        // ---------- Original Method ----------
        //builder.append(charArray);
        //flush(false);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.593 -0400", hash_original_method = "9A1F4F8E7B087A358A5E2FCB594FC1F1", hash_generated_method = "8F59234D870BB91B140F494D96210C04")
    @Override
    public synchronized void print(char ch) {
        addTaint(ch);
        builder.append(ch);
        if(ch == '\n')        
        {
            flush(false);
        } //End block
        // ---------- Original Method ----------
        //builder.append(ch);
        //if (ch == '\n') {
            //flush(false);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.593 -0400", hash_original_method = "820BD1560BF89A8CCF87FDD4C009E434", hash_generated_method = "A3580F312FF2CD91E8F3C9669860705F")
    @Override
    public synchronized void print(double dnum) {
        addTaint(dnum);
        builder.append(dnum);
        // ---------- Original Method ----------
        //builder.append(dnum);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.593 -0400", hash_original_method = "BF192CAA8CC79321D5E28D82D881B0DE", hash_generated_method = "AC6D1853ACEE5CFBD99111BEB744EB49")
    @Override
    public synchronized void print(float fnum) {
        addTaint(fnum);
        builder.append(fnum);
        // ---------- Original Method ----------
        //builder.append(fnum);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.594 -0400", hash_original_method = "EA729F5E50977D112911F5C250343E89", hash_generated_method = "99CDB100941EA43D23B0C0DE8012F105")
    @Override
    public synchronized void print(int inum) {
        addTaint(inum);
        builder.append(inum);
        // ---------- Original Method ----------
        //builder.append(inum);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.595 -0400", hash_original_method = "2F9DD3DF69B1439CAC48F255A2B06D16", hash_generated_method = "60C25EB8338062E53DA4770A1F3642DB")
    @Override
    public synchronized void print(long lnum) {
        addTaint(lnum);
        builder.append(lnum);
        // ---------- Original Method ----------
        //builder.append(lnum);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.595 -0400", hash_original_method = "0154750185D34191234B4807E3679F12", hash_generated_method = "5D367BFBCCC01DA964F9118B676D990B")
    @Override
    public synchronized void print(Object obj) {
        addTaint(obj.getTaint());
        builder.append(obj);
        flush(false);
        // ---------- Original Method ----------
        //builder.append(obj);
        //flush(false);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.595 -0400", hash_original_method = "F2C90C1214AEAFC8178C26840ED36663", hash_generated_method = "68E76B8414EFAE337B87E8E1544C9093")
    @Override
    public synchronized void print(String str) {
        addTaint(str.getTaint());
        builder.append(str);
        flush(false);
        // ---------- Original Method ----------
        //builder.append(str);
        //flush(false);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.596 -0400", hash_original_method = "5ECA1B577D18215F52A8C9A6333D9CFC", hash_generated_method = "E4CCA37F26C4FDD0B557C46E2C5548FC")
    @Override
    public synchronized void print(boolean bool) {
        addTaint(bool);
        builder.append(bool);
        // ---------- Original Method ----------
        //builder.append(bool);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.596 -0400", hash_original_method = "7A4D58C37164C3E851ED3ACE479C647B", hash_generated_method = "092FE2800A8865F19D4DB0FB3E12EEF9")
    @Override
    public synchronized void println() {
        flush(true);
        // ---------- Original Method ----------
        //flush(true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.596 -0400", hash_original_method = "9D1363302FBD4F1058D52926AD245DD3", hash_generated_method = "58913D6D3A1147892A6E4B3D82A9BD0D")
    @Override
    public synchronized void println(char[] charArray) {
        addTaint(charArray[0]);
        builder.append(charArray);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(charArray);
        //flush(true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.596 -0400", hash_original_method = "01C278022DBB5824908D391A202B4A36", hash_generated_method = "EA6AA243657CE0F28AEB4BD13A7071C0")
    @Override
    public synchronized void println(char ch) {
        addTaint(ch);
        builder.append(ch);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(ch);
        //flush(true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.597 -0400", hash_original_method = "CE32681476B37833026295BF14F82F86", hash_generated_method = "1F0FA9E0B60635956ECDB30DD46B74B9")
    @Override
    public synchronized void println(double dnum) {
        addTaint(dnum);
        builder.append(dnum);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(dnum);
        //flush(true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.597 -0400", hash_original_method = "DD6ED147F9391D413B16E144DA317870", hash_generated_method = "B52705BD832C4AB9DE4A048961901694")
    @Override
    public synchronized void println(float fnum) {
        addTaint(fnum);
        builder.append(fnum);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(fnum);
        //flush(true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.597 -0400", hash_original_method = "AF6787AC8EF2FEBAAFAF97782B2D9A73", hash_generated_method = "379C679E30FE41C22E31048745C7442E")
    @Override
    public synchronized void println(int inum) {
        addTaint(inum);
        builder.append(inum);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(inum);
        //flush(true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.597 -0400", hash_original_method = "460CB99F3847A5BE06D2BF7094246043", hash_generated_method = "5511F77D9CFCA164858FCB876BEB5CF9")
    @Override
    public synchronized void println(long lnum) {
        addTaint(lnum);
        builder.append(lnum);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(lnum);
        //flush(true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.597 -0400", hash_original_method = "790D5F04D5F763A67F6384A1DADD6007", hash_generated_method = "5288593FA99D284EA0CD6B2FDA0E3C41")
    @Override
    public synchronized void println(Object obj) {
        addTaint(obj.getTaint());
        builder.append(obj);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(obj);
        //flush(true);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.598 -0400", hash_original_method = "EBB6B619FF9A797B3350DC2D212BCB5E", hash_generated_method = "D9678ADD59E2E9141705F87FA761B651")
    @Override
    public synchronized void println(String s) {
        addTaint(s.getTaint());
        if(builder.length() == 0)        
        {
            int length = s.length();
            int start = 0;
            int nextBreak;
            while
(start < length
                    && (nextBreak = s.indexOf('\n', start)) != -1)            
            {
                log(s.substring(start, nextBreak));
                start = nextBreak + 1;
            } //End block
            if(start < length)            
            {
                log(s.substring(start));
            } //End block
        } //End block
        else
        {
            builder.append(s);
            flush(true);
        } //End block
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.598 -0400", hash_original_method = "09E0763383C859949559D7053E0AFD5D", hash_generated_method = "4B1E47204068D4AF8121008BDEEA44DF")
    @Override
    public synchronized void println(boolean bool) {
        addTaint(bool);
        builder.append(bool);
        flush(true);
        // ---------- Original Method ----------
        //builder.append(bool);
        //flush(true);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.598 -0400", hash_original_method = "C72D2A095158FF2DF7FBE0880B8BD63F", hash_generated_method = "62952A2142A549E688310EFA8E42BE0A")
    @Override
    public synchronized PrintStream append(char c) {
        addTaint(c);
        print(c);
PrintStream var72A74007B2BE62B849F475C7BDA4658B_637892018 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_637892018.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_637892018;
        // ---------- Original Method ----------
        //print(c);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.598 -0400", hash_original_method = "C203B04FBC05591B3DF1483A3F91F520", hash_generated_method = "74ADAAC3A248F66E418C6F79057F723E")
    @Override
    public synchronized PrintStream append(CharSequence csq) {
        addTaint(csq.getTaint());
        builder.append(csq);
        flush(false);
PrintStream var72A74007B2BE62B849F475C7BDA4658B_407109973 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_407109973.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_407109973;
        // ---------- Original Method ----------
        //builder.append(csq);
        //flush(false);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.598 -0400", hash_original_method = "6ED0867725346C7DB431FFF2CFBE5CE7", hash_generated_method = "62347359B02F6127C241035416E39FCF")
    @Override
    public synchronized PrintStream append(
            CharSequence csq, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(csq.getTaint());
        builder.append(csq, start, end);
        flush(false);
PrintStream var72A74007B2BE62B849F475C7BDA4658B_1112382745 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1112382745.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1112382745;
        // ---------- Original Method ----------
        //builder.append(csq, start, end);
        //flush(false);
        //return this;
    }

    
}

