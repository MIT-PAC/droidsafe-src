package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.889 -0500", hash_original_field = "93C0B127A393B45C7A17DFD8C2E2FAB1", hash_generated_field = "F25016152F6B827256AC69E5E852FFFB")

    private final StringBuilder builder = new StringBuilder();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.891 -0500", hash_original_field = "4062F5EEF61D4C15D41C846AC81C3BF7", hash_generated_field = "12A99FAB87A4DFA0636B74A246FED9BE")

    private ByteBuffer encodedBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.893 -0500", hash_original_field = "4C39EFCCB0A8865EB872E9A10F49FC09", hash_generated_field = "F099383316D72C3F3F910ED1AEEDD48F")

    private CharBuffer decodedChars;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.896 -0500", hash_original_field = "EB8B81788E764E7EC09C99438B975CD8", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.934 -0500", hash_original_field = "E2783AE3DE7012EB53F254219F7F1CE2", hash_generated_field = "188D772938696150A06C76EB179BFA12")

    private final Formatter formatter = new Formatter(builder, null);
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.035 -0400", hash_original_method = "9EC321B6DFE561BEEE5F374ADAFA7A30", hash_generated_method = "0CF066A83124D2B7F58571604E6E54B0")
    protected  LoggingPrintStream() {
        super(new OutputStream() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.899 -0500", hash_original_method = "17875F81676CAD7D322FCB70A8FEEF63", hash_generated_method = "8D574D3F591F04593DEEAE97ED174B2C")
            
public void write(int oneByte) throws IOException {
                throw new AssertionError();
            }
        });
        // ---------- Original Method ----------
    }

    /**
     * Logs the given line.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.904 -0500", hash_original_method = "741BD7E0920FC4CFC4FD808C58B1370D", hash_generated_method = "8391CEE98AE23D0FEBFBA27723C81326")
    
protected abstract void log(String line);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.906 -0500", hash_original_method = "B82EE3D19B5D6B5B238555A3C574E964", hash_generated_method = "3EE43C5F19AC175CE157B051ABB0CEB6")
    
@Override
    public synchronized void flush() {
        flush(true);
    }

    /**
     * Searches buffer for line breaks and logs a message for each one.
     *
     * @param completely true if the ending chars should be treated as a line
     *  even though they don't end in a line break
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.909 -0500", hash_original_method = "4ED1A827BC075458493301694F5FB1B1", hash_generated_method = "451AF770FEA5BA6E78B5FE7594E476E5")
    
private void flush(boolean completely) {
        int length = builder.length();

        int start = 0;
        int nextBreak;

        // Log one line for each line break.
        while (start < length
                && (nextBreak = builder.indexOf("\n", start)) != -1) {
            log(builder.substring(start, nextBreak));
            start = nextBreak + 1;
        }

        if (completely) {
            // Log the remainder of the buffer.
            if (start < length) {
                log(builder.substring(start));
            }
            builder.setLength(0);
        } else {
            // Delete characters leading up to the next starting point.
            builder.delete(0, start);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.911 -0500", hash_original_method = "2DD612F978C37BC7835E83A5EC002758", hash_generated_method = "C4A7241D547E3682892F683ED267EDFB")
    
public void write(int oneByte) {
        write(new byte[] { (byte) oneByte }, 0, 1);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.914 -0500", hash_original_method = "DD74A1A5E8F3C8FBA0F2CF6C71691621", hash_generated_method = "323A36545569C28FBC957EC749B4FCA5")
    
@Override
    public void write(byte[] buffer) {
        write(buffer, 0, buffer.length);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.917 -0500", hash_original_method = "3A82678B6E3902D5ED4B1D00D7245300", hash_generated_method = "7FEA4F5F33498E356C4F3504F428EE3E")
    
@Override
    public synchronized void write(byte bytes[], int start, int count) {
        if (decoder == null) {
            encodedBytes = ByteBuffer.allocate(80);
            decodedChars = CharBuffer.allocate(80);
            decoder = Charset.defaultCharset().newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE);
        }

        int end = start + count;
        while (start < end) {
            // copy some bytes from the array to the long-lived buffer. This
            // way, if we end with a partial character we don't lose it.
            int numBytes = Math.min(encodedBytes.remaining(), end - start);
            encodedBytes.put(bytes, start, numBytes);
            start += numBytes;

            encodedBytes.flip();
            CoderResult coderResult;
            do {
                // decode bytes from the byte buffer into the char buffer
                coderResult = decoder.decode(encodedBytes, decodedChars, false);

                // copy chars from the char buffer into our string builder
                decodedChars.flip();
                builder.append(decodedChars);
                decodedChars.clear();
            } while (coderResult.isOverflow());
            encodedBytes.compact();
        }
        flush(false);
    }

    /** Always returns false. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.920 -0500", hash_original_method = "0FEA708DB7A5B3B6D16FEC9623D0EEF8", hash_generated_method = "663C95C2616F192972B72A347C0C3F9B")
    
@Override
    public boolean checkError() {
        return false;
    }

    /** Ignored. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.922 -0500", hash_original_method = "51169B2EF8C8211EB75CA27439BAE4AB", hash_generated_method = "4B41D3A300DBCD0B879B9290D9805C4D")
    
@Override
    protected void setError() { /* ignored */ }

    /** Ignored. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.925 -0500", hash_original_method = "B96EF178F3ED1A0DFACDA94649407E5C", hash_generated_method = "78606FC25D89DCE00CCDC84D2F330D26")
    
@Override
    public void close() { /* ignored */ }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.927 -0500", hash_original_method = "05D45546979F5891D35AE44E50FD3553", hash_generated_method = "6CB158DD89D670BD4C656550135DE9C2")
    
@Override
    public PrintStream format(String format, Object... args) {
        return format(Locale.getDefault(), format, args);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.929 -0500", hash_original_method = "AF1C3DC823982E73CFCD03CCF036C65E", hash_generated_method = "1B43A4D18E853AC70AF8003B7119298C")
    
@Override
    public PrintStream printf(String format, Object... args) {
        return format(format, args);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.932 -0500", hash_original_method = "F50C21D98ADC94B4526029B9C256D54E", hash_generated_method = "D505ECE8B53B32CD600EBC185D50D8FD")
    
@Override
    public PrintStream printf(Locale l, String format, Object... args) {
        return format(l, format, args);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.936 -0500", hash_original_method = "F1983A352222AF67B3078F0EEE870AAE", hash_generated_method = "1C5BE187DC917E61F5336E3CD448FBC3")
    
@Override
    public synchronized PrintStream format(
            Locale l, String format, Object... args) {
        if (format == null) {
            throw new NullPointerException("format");
        }

        formatter.format(l, format, args);
        flush(false);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.939 -0500", hash_original_method = "34D92369FB78C59105446434E08E5A35", hash_generated_method = "13A54EBF460BC7EE4578C5120888BF86")
    
@Override
    public synchronized void print(char[] charArray) {
        builder.append(charArray);
        flush(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.942 -0500", hash_original_method = "9A1F4F8E7B087A358A5E2FCB594FC1F1", hash_generated_method = "FD821B0D212A11B10997658E816B0956")
    
@Override
    public synchronized void print(char ch) {
        builder.append(ch);
        if (ch == '\n') {
            flush(false);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.944 -0500", hash_original_method = "820BD1560BF89A8CCF87FDD4C009E434", hash_generated_method = "28B32CBEEF8EDAFB7B822C344EB01960")
    
@Override
    public synchronized void print(double dnum) {
        builder.append(dnum);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.947 -0500", hash_original_method = "BF192CAA8CC79321D5E28D82D881B0DE", hash_generated_method = "034FF427606E04499FF3C9F9FAE0A27C")
    
@Override
    public synchronized void print(float fnum) {
        builder.append(fnum);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.949 -0500", hash_original_method = "EA729F5E50977D112911F5C250343E89", hash_generated_method = "36A0F0FC4C0F703FC6E34123BBDBCDCA")
    
@Override
    public synchronized void print(int inum) {
        builder.append(inum);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.952 -0500", hash_original_method = "2F9DD3DF69B1439CAC48F255A2B06D16", hash_generated_method = "E69C67C5C0E229BB1885C8A437EC9DD8")
    
@Override
    public synchronized void print(long lnum) {
        builder.append(lnum);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.954 -0500", hash_original_method = "0154750185D34191234B4807E3679F12", hash_generated_method = "EFB637BA351BCA2D2A35628DEF7E3B07")
    
@Override
    public synchronized void print(Object obj) {
        builder.append(obj);
        flush(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.957 -0500", hash_original_method = "F2C90C1214AEAFC8178C26840ED36663", hash_generated_method = "9F4E2DBB1BD882340C297D18DDCF40DA")
    
@Override
    public synchronized void print(String str) {
        builder.append(str);
        flush(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.959 -0500", hash_original_method = "5ECA1B577D18215F52A8C9A6333D9CFC", hash_generated_method = "C6EAD88B1F8B2083ADBBB8AD0A1F0197")
    
@Override
    public synchronized void print(boolean bool) {
        builder.append(bool);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.962 -0500", hash_original_method = "7A4D58C37164C3E851ED3ACE479C647B", hash_generated_method = "D6CA1AB1BE09EFCA7247F47F4086897C")
    
@Override
    public synchronized void println() {
        flush(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.964 -0500", hash_original_method = "9D1363302FBD4F1058D52926AD245DD3", hash_generated_method = "1C7CA6D977F3BF445A3EDC3C37CD5216")
    
@Override
    public synchronized void println(char[] charArray) {
        builder.append(charArray);
        flush(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.968 -0500", hash_original_method = "01C278022DBB5824908D391A202B4A36", hash_generated_method = "C2D5D1A3E5E14CFC36062D087BB0FBFA")
    
@Override
    public synchronized void println(char ch) {
        builder.append(ch);
        flush(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.970 -0500", hash_original_method = "CE32681476B37833026295BF14F82F86", hash_generated_method = "C38FF0F9F289652AFFE567EDD8057225")
    
@Override
    public synchronized void println(double dnum) {
        builder.append(dnum);
        flush(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.973 -0500", hash_original_method = "DD6ED147F9391D413B16E144DA317870", hash_generated_method = "78125CD86B4D93108D39C66FEC0A094F")
    
@Override
    public synchronized void println(float fnum) {
        builder.append(fnum);
        flush(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.975 -0500", hash_original_method = "AF6787AC8EF2FEBAAFAF97782B2D9A73", hash_generated_method = "FB272A9A44606D7B035445FF24866B24")
    
@Override
    public synchronized void println(int inum) {
        builder.append(inum);
        flush(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.977 -0500", hash_original_method = "460CB99F3847A5BE06D2BF7094246043", hash_generated_method = "5292D5D93059810F191EB4DA1D221B67")
    
@Override
    public synchronized void println(long lnum) {
        builder.append(lnum);
        flush(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.980 -0500", hash_original_method = "790D5F04D5F763A67F6384A1DADD6007", hash_generated_method = "B9C7E81F183609F62EE534C79CCFD299")
    
@Override
    public synchronized void println(Object obj) {
        builder.append(obj);
        flush(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.982 -0500", hash_original_method = "EBB6B619FF9A797B3350DC2D212BCB5E", hash_generated_method = "43CF4AC7AE707F2E7420578D46F300BF")
    
@Override
    public synchronized void println(String s) {
        if (builder.length() == 0) {
            // Optimization for a simple println.
            int length = s.length();

            int start = 0;
            int nextBreak;

            // Log one line for each line break.
            while (start < length
                    && (nextBreak = s.indexOf('\n', start)) != -1) {
                log(s.substring(start, nextBreak));
                start = nextBreak + 1;
            }

            if (start < length) {
                log(s.substring(start));
            }
        } else {
            builder.append(s);
            flush(true);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.985 -0500", hash_original_method = "09E0763383C859949559D7053E0AFD5D", hash_generated_method = "88734376F2E3EF0C0CB27C01A87275B7")
    
@Override
    public synchronized void println(boolean bool) {
        builder.append(bool);
        flush(true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.988 -0500", hash_original_method = "C72D2A095158FF2DF7FBE0880B8BD63F", hash_generated_method = "F9CCD213825640F4DF80310DA8E78580")
    
@Override
    public synchronized PrintStream append(char c) {
        print(c);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.990 -0500", hash_original_method = "C203B04FBC05591B3DF1483A3F91F520", hash_generated_method = "E1DEDD2B6A0191E2EFF05528C8876987")
    
@Override
    public synchronized PrintStream append(CharSequence csq) {
        builder.append(csq);
        flush(false);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:52.993 -0500", hash_original_method = "6ED0867725346C7DB431FFF2CFBE5CE7", hash_generated_method = "4FFC6D1195E657BE41535EAD26FA4F09")
    
@Override
    public synchronized PrintStream append(
            CharSequence csq, int start, int end) {
        builder.append(csq, start, end);
        flush(false);
        return this;
    }
    
}

