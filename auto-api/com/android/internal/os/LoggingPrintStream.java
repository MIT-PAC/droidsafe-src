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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.960 -0400", hash_original_field = "F3FE2D9E511ACAFB35D0D4B62216EA77", hash_generated_field = "B22A19C726D6F0AAA471B43D99DB18CF")

    private StringBuilder builder = new StringBuilder();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.960 -0400", hash_original_field = "67E97075F28081FE8D380FC823FD5C79", hash_generated_field = "12A99FAB87A4DFA0636B74A246FED9BE")

    private ByteBuffer encodedBytes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.960 -0400", hash_original_field = "C0BA4833ED6D5DC9B32E33A8BC4B863D", hash_generated_field = "F099383316D72C3F3F910ED1AEEDD48F")

    private CharBuffer decodedChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.960 -0400", hash_original_field = "3A6BDBA8FB33A88CF7D52A1AF07A9C00", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.960 -0400", hash_original_field = "82A6C186E4B45FBB3B170E2EBBEB6568", hash_generated_field = "AA744C9D5601B116EC03B81F66F3ACCD")

    private Formatter formatter = new Formatter(builder, null);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.961 -0400", hash_original_method = "9EC321B6DFE561BEEE5F374ADAFA7A30", hash_generated_method = "0CF066A83124D2B7F58571604E6E54B0")
    protected  LoggingPrintStream() {
        super(new OutputStream() {
            public void write(int oneByte) throws IOException {
                throw new AssertionError();
            }
        });
        // ---------- Original Method ----------
    }

    
    protected abstract void log(String line);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.962 -0400", hash_original_method = "B82EE3D19B5D6B5B238555A3C574E964", hash_generated_method = "E395ABEE7588D1C6079D814E6681CA0E")
    @Override
    public synchronized void flush() {
        flush(true);
        // ---------- Original Method ----------
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.963 -0400", hash_original_method = "4ED1A827BC075458493301694F5FB1B1", hash_generated_method = "FFD39330F125100806D535811F8C64D1")
    private void flush(boolean completely) {
        int length;
        length = builder.length();
        int start;
        start = 0;
        int nextBreak;
        {
            boolean varCECC465DB0C1A2DC9772F41A0AEFAF78_2088586219 = (start < length
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
        addTaint(completely);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.975 -0400", hash_original_method = "2DD612F978C37BC7835E83A5EC002758", hash_generated_method = "3562EDA4AD15882C66033AF2249E0E8C")
    public void write(int oneByte) {
        write(new byte[] { (byte) oneByte }, 0, 1);
        addTaint(oneByte);
        // ---------- Original Method ----------
        //write(new byte[] { (byte) oneByte }, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.976 -0400", hash_original_method = "DD74A1A5E8F3C8FBA0F2CF6C71691621", hash_generated_method = "15AD6E56C1F74FA611EC66CED98083C6")
    @Override
    public void write(byte[] buffer) {
        write(buffer, 0, buffer.length);
        addTaint(buffer[0]);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.977 -0400", hash_original_method = "3A82678B6E3902D5ED4B1D00D7245300", hash_generated_method = "6688E40254FA035EF61DBB968E547D5D")
    @Override
    public synchronized void write(byte bytes[], int start, int count) {
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
                boolean var1F4BF95B8230AF5CFFBC6FA75DC274CF_2117696729 = (coderResult.isOverflow());
            } //End collapsed parenthetic
            encodedBytes.compact();
        } //End block
        flush(false);
        addTaint(bytes);
        addTaint(start);
        addTaint(count);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.977 -0400", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "ABC6292CCB5452BFCB9C2282267BB0A5")
    @Override
    public boolean checkError() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_40816368 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_40816368;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.977 -0400", hash_original_method = "51169B2EF8C8211EB75CA27439BAE4AB", hash_generated_method = "2A0A3827C6A0447713ECA04520FF48CE")
    @Override
    protected void setError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.978 -0400", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "1A3F8C083102602A57FB2D0CBE40EA76")
    @Override
    public void close() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.978 -0400", hash_original_method = "05D45546979F5891D35AE44E50FD3553", hash_generated_method = "4A6B838EF4E172C7632C0B94087AA3C6")
    @Override
    public PrintStream format(String format, Object... args) {
        PrintStream varB4EAC82CA7396A68D541C85D26508E83_417138314 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_417138314 = format(Locale.getDefault(), format, args);
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_417138314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_417138314;
        // ---------- Original Method ----------
        //return format(Locale.getDefault(), format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.987 -0400", hash_original_method = "AF1C3DC823982E73CFCD03CCF036C65E", hash_generated_method = "7E93375AA01B1D06C7D8281784CDC950")
    @Override
    public PrintStream printf(String format, Object... args) {
        PrintStream varB4EAC82CA7396A68D541C85D26508E83_1256781653 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1256781653 = format(format, args);
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1256781653.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1256781653;
        // ---------- Original Method ----------
        //return format(format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.988 -0400", hash_original_method = "F50C21D98ADC94B4526029B9C256D54E", hash_generated_method = "E429D5F8C12EC35836F2366CAED89C9F")
    @Override
    public PrintStream printf(Locale l, String format, Object... args) {
        PrintStream varB4EAC82CA7396A68D541C85D26508E83_1008966033 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1008966033 = format(l, format, args);
        addTaint(l.getTaint());
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1008966033.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008966033;
        // ---------- Original Method ----------
        //return format(l, format, args);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.991 -0400", hash_original_method = "F1983A352222AF67B3078F0EEE870AAE", hash_generated_method = "02DDD4468C139D7A89684044025AC33A")
    @Override
    public synchronized PrintStream format(
            Locale l, String format, Object... args) {
        PrintStream varB4EAC82CA7396A68D541C85D26508E83_131232030 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("format");
        } //End block
        formatter.format(l, format, args);
        flush(false);
        varB4EAC82CA7396A68D541C85D26508E83_131232030 = this;
        addTaint(l.getTaint());
        addTaint(format.getTaint());
        addTaint(args[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_131232030.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_131232030;
        // ---------- Original Method ----------
        //if (format == null) {
            //throw new NullPointerException("format");
        //}
        //formatter.format(l, format, args);
        //flush(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.999 -0400", hash_original_method = "34D92369FB78C59105446434E08E5A35", hash_generated_method = "898C10C4680BE6C2143642F88D4BD836")
    @Override
    public synchronized void print(char[] charArray) {
        builder.append(charArray);
        flush(false);
        addTaint(charArray[0]);
        // ---------- Original Method ----------
        //builder.append(charArray);
        //flush(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:13.999 -0400", hash_original_method = "9A1F4F8E7B087A358A5E2FCB594FC1F1", hash_generated_method = "CDAE0635B43EEC63F055D4B76742C4C4")
    @Override
    public synchronized void print(char ch) {
        builder.append(ch);
        {
            flush(false);
        } //End block
        addTaint(ch);
        // ---------- Original Method ----------
        //builder.append(ch);
        //if (ch == '\n') {
            //flush(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.000 -0400", hash_original_method = "820BD1560BF89A8CCF87FDD4C009E434", hash_generated_method = "F78639730707ED9BD177D8952DA148FB")
    @Override
    public synchronized void print(double dnum) {
        builder.append(dnum);
        addTaint(dnum);
        // ---------- Original Method ----------
        //builder.append(dnum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.000 -0400", hash_original_method = "BF192CAA8CC79321D5E28D82D881B0DE", hash_generated_method = "91863F148C4D427E0EF4C819704EF2A6")
    @Override
    public synchronized void print(float fnum) {
        builder.append(fnum);
        addTaint(fnum);
        // ---------- Original Method ----------
        //builder.append(fnum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.000 -0400", hash_original_method = "EA729F5E50977D112911F5C250343E89", hash_generated_method = "DDC167F4C6759CED125FC0F04236CAEE")
    @Override
    public synchronized void print(int inum) {
        builder.append(inum);
        addTaint(inum);
        // ---------- Original Method ----------
        //builder.append(inum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.000 -0400", hash_original_method = "2F9DD3DF69B1439CAC48F255A2B06D16", hash_generated_method = "ECB2AD88E01AB9D396A633E7AEB5C754")
    @Override
    public synchronized void print(long lnum) {
        builder.append(lnum);
        addTaint(lnum);
        // ---------- Original Method ----------
        //builder.append(lnum);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.001 -0400", hash_original_method = "0154750185D34191234B4807E3679F12", hash_generated_method = "11CD0E31AD24A72E3B67363961501932")
    @Override
    public synchronized void print(Object obj) {
        builder.append(obj);
        flush(false);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //builder.append(obj);
        //flush(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.001 -0400", hash_original_method = "F2C90C1214AEAFC8178C26840ED36663", hash_generated_method = "54E546F9E9D478082AE491E435EF20CA")
    @Override
    public synchronized void print(String str) {
        builder.append(str);
        flush(false);
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //builder.append(str);
        //flush(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.001 -0400", hash_original_method = "5ECA1B577D18215F52A8C9A6333D9CFC", hash_generated_method = "C81EC0805D7660D0093A45C269C9BDCC")
    @Override
    public synchronized void print(boolean bool) {
        builder.append(bool);
        addTaint(bool);
        // ---------- Original Method ----------
        //builder.append(bool);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.001 -0400", hash_original_method = "7A4D58C37164C3E851ED3ACE479C647B", hash_generated_method = "092FE2800A8865F19D4DB0FB3E12EEF9")
    @Override
    public synchronized void println() {
        flush(true);
        // ---------- Original Method ----------
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.075 -0400", hash_original_method = "9D1363302FBD4F1058D52926AD245DD3", hash_generated_method = "969C92469937D9CD918229C8B1F34E2E")
    @Override
    public synchronized void println(char[] charArray) {
        builder.append(charArray);
        flush(true);
        addTaint(charArray[0]);
        // ---------- Original Method ----------
        //builder.append(charArray);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.075 -0400", hash_original_method = "01C278022DBB5824908D391A202B4A36", hash_generated_method = "A44D3F528C22867165E68CD0BFC025D6")
    @Override
    public synchronized void println(char ch) {
        builder.append(ch);
        flush(true);
        addTaint(ch);
        // ---------- Original Method ----------
        //builder.append(ch);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.076 -0400", hash_original_method = "CE32681476B37833026295BF14F82F86", hash_generated_method = "920A2EEEEBC8773C5C8A2F1B4461DBA1")
    @Override
    public synchronized void println(double dnum) {
        builder.append(dnum);
        flush(true);
        addTaint(dnum);
        // ---------- Original Method ----------
        //builder.append(dnum);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.076 -0400", hash_original_method = "DD6ED147F9391D413B16E144DA317870", hash_generated_method = "D2D5837336D9C3C5097EF60D10DD367B")
    @Override
    public synchronized void println(float fnum) {
        builder.append(fnum);
        flush(true);
        addTaint(fnum);
        // ---------- Original Method ----------
        //builder.append(fnum);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.076 -0400", hash_original_method = "AF6787AC8EF2FEBAAFAF97782B2D9A73", hash_generated_method = "5743FFE727C1C25760693117F7FD06D6")
    @Override
    public synchronized void println(int inum) {
        builder.append(inum);
        flush(true);
        addTaint(inum);
        // ---------- Original Method ----------
        //builder.append(inum);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.079 -0400", hash_original_method = "460CB99F3847A5BE06D2BF7094246043", hash_generated_method = "DDF3DD14BBA0D4F2073392ABBCE2A24A")
    @Override
    public synchronized void println(long lnum) {
        builder.append(lnum);
        flush(true);
        addTaint(lnum);
        // ---------- Original Method ----------
        //builder.append(lnum);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.080 -0400", hash_original_method = "790D5F04D5F763A67F6384A1DADD6007", hash_generated_method = "2B5EBC7148272338C4834B8C2FFE8584")
    @Override
    public synchronized void println(Object obj) {
        builder.append(obj);
        flush(true);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //builder.append(obj);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.080 -0400", hash_original_method = "EBB6B619FF9A797B3350DC2D212BCB5E", hash_generated_method = "BB3934B4920CBF6F64033F823A18B23C")
    @Override
    public synchronized void println(String s) {
        {
            boolean varA54061C544715EB0A7F9DC6F7247A715_1389204977 = (builder.length() == 0);
            {
                int length;
                length = s.length();
                int start;
                start = 0;
                int nextBreak;
                {
                    boolean var3E9DE48AFC111E2F733EDFF180729139_485481308 = (start < length
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
        addTaint(s.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.081 -0400", hash_original_method = "09E0763383C859949559D7053E0AFD5D", hash_generated_method = "BC72CEBFD4ED3C9E87921BC3BE8F3BD0")
    @Override
    public synchronized void println(boolean bool) {
        builder.append(bool);
        flush(true);
        addTaint(bool);
        // ---------- Original Method ----------
        //builder.append(bool);
        //flush(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.081 -0400", hash_original_method = "C72D2A095158FF2DF7FBE0880B8BD63F", hash_generated_method = "67E1D1D3AC68F8F8EFC1C9399A2A5768")
    @Override
    public synchronized PrintStream append(char c) {
        PrintStream varB4EAC82CA7396A68D541C85D26508E83_345459456 = null; //Variable for return #1
        print(c);
        varB4EAC82CA7396A68D541C85D26508E83_345459456 = this;
        addTaint(c);
        varB4EAC82CA7396A68D541C85D26508E83_345459456.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345459456;
        // ---------- Original Method ----------
        //print(c);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.085 -0400", hash_original_method = "C203B04FBC05591B3DF1483A3F91F520", hash_generated_method = "0CBF3728C4EEF272BB89D80812935796")
    @Override
    public synchronized PrintStream append(CharSequence csq) {
        PrintStream varB4EAC82CA7396A68D541C85D26508E83_1864590927 = null; //Variable for return #1
        builder.append(csq);
        flush(false);
        varB4EAC82CA7396A68D541C85D26508E83_1864590927 = this;
        addTaint(csq.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1864590927.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1864590927;
        // ---------- Original Method ----------
        //builder.append(csq);
        //flush(false);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:14.086 -0400", hash_original_method = "6ED0867725346C7DB431FFF2CFBE5CE7", hash_generated_method = "30A979F7361A6D9C01188800909B268C")
    @Override
    public synchronized PrintStream append(
            CharSequence csq, int start, int end) {
        PrintStream varB4EAC82CA7396A68D541C85D26508E83_1764637790 = null; //Variable for return #1
        builder.append(csq, start, end);
        flush(false);
        varB4EAC82CA7396A68D541C85D26508E83_1764637790 = this;
        addTaint(csq.getTaint());
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1764637790.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1764637790;
        // ---------- Original Method ----------
        //builder.append(csq, start, end);
        //flush(false);
        //return this;
    }

    
}

