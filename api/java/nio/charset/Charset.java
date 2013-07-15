package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.spi.CharsetProvider;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import libcore.icu.NativeConverter;

public abstract class Charset implements Comparable<Charset> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.746 -0400", hash_original_field = "3FD37E7C1754DA8004AB09E17AD51B85", hash_generated_field = "4394C126BF71D5F3C3D84B833D0FB596")

    private String canonicalName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.746 -0400", hash_original_field = "496C43E2A9F7F1C8928D93EF34796C9E", hash_generated_field = "94A607030E0CCDFE52CAD878DD81F6F9")

    private HashSet<String> aliasesSet;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.747 -0400", hash_original_method = "70538FAF149E20AD4492F643DB83EDCB", hash_generated_method = "9AB45971258C835EC347CCE65D82FCE0")
    protected  Charset(String canonicalName, String[] aliases) {
        addTaint(aliases[0].getTaint());
        checkCharsetName(canonicalName);
        this.canonicalName = canonicalName;
        this.aliasesSet = new HashSet<String>();
    if(aliases != null)        
        {
for(String alias : aliases)
            {
                checkCharsetName(alias);
                this.aliasesSet.add(alias);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //checkCharsetName(canonicalName);
        //this.canonicalName = canonicalName;
        //this.aliasesSet = new HashSet<String>();
        //if (aliases != null) {
            //for (String alias : aliases) {
                //checkCharsetName(alias);
                //this.aliasesSet.add(alias);
            //}
        //}
    }

    
        private static void checkCharsetName(String name) {
        if (name.isEmpty()) {
            throw new IllegalCharsetNameException(name);
        }
        int length = name.length();
        for (int i = 0; i < length; ++i) {
            if (!isValidCharsetNameCharacter(name.charAt(i))) {
                throw new IllegalCharsetNameException(name);
            }
        }
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean isValidCharsetNameCharacter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') ||
                c == '-' || c == '.' || c == ':' || c == '_';
    }

    
        public static SortedMap<String, Charset> availableCharsets() {
        TreeMap<String, Charset> charsets = new TreeMap<String, Charset>(String.CASE_INSENSITIVE_ORDER);
        for (String charsetName : NativeConverter.getAvailableCharsetNames()) {
            Charset charset = NativeConverter.charsetForName(charsetName);
            charsets.put(charset.name(), charset);
        }
        for (CharsetProvider charsetProvider : ServiceLoader.load(CharsetProvider.class)) {
            Iterator<Charset> it = charsetProvider.charsets();
            while (it.hasNext()) {
                Charset cs = it.next();
                if (!charsets.containsKey(cs.name())) {
                    charsets.put(cs.name(), cs);
                }
            }
        }
        return Collections.unmodifiableSortedMap(charsets);
    }

    
        private static Charset cacheCharset(String charsetName, Charset cs) {
        synchronized (CACHED_CHARSETS) {
            String canonicalName = cs.name();
            Charset canonicalCharset = CACHED_CHARSETS.get(canonicalName);
            if (canonicalCharset == null) {
                canonicalCharset = cs;
            }
            CACHED_CHARSETS.put(canonicalName, canonicalCharset);
            CACHED_CHARSETS.put(charsetName, canonicalCharset);
            for (String alias : cs.aliasesSet) {
                CACHED_CHARSETS.put(alias, canonicalCharset);
            }
            return canonicalCharset;
        }
    }

    
        public static Charset forName(String charsetName) {
        Charset cs;
        synchronized (CACHED_CHARSETS) {
            cs = CACHED_CHARSETS.get(charsetName);
            if (cs != null) {
                return cs;
            }
        }
        if (charsetName == null) {
            throw new IllegalCharsetNameException(null);
        }
        checkCharsetName(charsetName);
        cs = NativeConverter.charsetForName(charsetName);
        if (cs != null) {
            return cacheCharset(charsetName, cs);
        }
        for (CharsetProvider charsetProvider : ServiceLoader.load(CharsetProvider.class)) {
            cs = charsetProvider.charsetForName(charsetName);
            if (cs != null) {
                return cacheCharset(charsetName, cs);
            }
        }
        throw new UnsupportedCharsetException(charsetName);
    }

    
        public static Charset forNameUEE(String charsetName) throws UnsupportedEncodingException {
        try {
            return Charset.forName(charsetName);
        } catch (Exception cause) {
            UnsupportedEncodingException ex = new UnsupportedEncodingException(charsetName);
            ex.initCause(cause);
            throw ex;
        }
    }

    
        public static boolean isSupported(String charsetName) {
        try {
            forName(charsetName);
            return true;
        } catch (UnsupportedCharsetException ex) {
            return false;
        }
    }

    
    public abstract boolean contains(Charset charset);

    
    public abstract CharsetEncoder newEncoder();

    
    public abstract CharsetDecoder newDecoder();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.750 -0400", hash_original_method = "C591AF6945C669FCF4033528E86B2077", hash_generated_method = "F59A16AF97FFE1F42E4E89E5EF4FA4CE")
    public final String name() {
String var10DFEB18F9F7F9CEB3FED88506D04E0A_170531210 =         this.canonicalName;
        var10DFEB18F9F7F9CEB3FED88506D04E0A_170531210.addTaint(taint);
        return var10DFEB18F9F7F9CEB3FED88506D04E0A_170531210;
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.750 -0400", hash_original_method = "9500673A94BC6D8C4BDA9785EBDB1148", hash_generated_method = "BABF1A7978F2D7AAF15B6F619C0AA6C5")
    public final Set<String> aliases() {
Set<String> var40C06DD4FB2A29FDD3D9FA27114D7854_815168563 =         Collections.unmodifiableSet(this.aliasesSet);
        var40C06DD4FB2A29FDD3D9FA27114D7854_815168563.addTaint(taint);
        return var40C06DD4FB2A29FDD3D9FA27114D7854_815168563;
        // ---------- Original Method ----------
        //return Collections.unmodifiableSet(this.aliasesSet);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.750 -0400", hash_original_method = "73ACF950C7885C6BB8F7DA98628525CE", hash_generated_method = "06EFB1291A73383A1D267DD03B9D5985")
    public String displayName() {
String var10DFEB18F9F7F9CEB3FED88506D04E0A_1877307095 =         this.canonicalName;
        var10DFEB18F9F7F9CEB3FED88506D04E0A_1877307095.addTaint(taint);
        return var10DFEB18F9F7F9CEB3FED88506D04E0A_1877307095;
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.751 -0400", hash_original_method = "E11EA2F6EB7DD1956A05FA3724D0F65C", hash_generated_method = "71D43D56FFCDAC2231D0D56847C750FD")
    public String displayName(Locale l) {
        addTaint(l.getTaint());
String var10DFEB18F9F7F9CEB3FED88506D04E0A_665402086 =         this.canonicalName;
        var10DFEB18F9F7F9CEB3FED88506D04E0A_665402086.addTaint(taint);
        return var10DFEB18F9F7F9CEB3FED88506D04E0A_665402086;
        // ---------- Original Method ----------
        //return this.canonicalName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.751 -0400", hash_original_method = "CFCFCF944F2C53D97106092AE9D34706", hash_generated_method = "DB89A3C85321E19E6FF7E97F354BEEF3")
    public final boolean isRegistered() {
        boolean varCB51E205F23C1939F459A89E6130BC67_2028234866 = (!canonicalName.startsWith("x-") && !canonicalName.startsWith("X-"));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_748882815 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_748882815;
        // ---------- Original Method ----------
        //return !canonicalName.startsWith("x-") && !canonicalName.startsWith("X-");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.751 -0400", hash_original_method = "CFD47AB423921DC9B7AAA90F2EE94666", hash_generated_method = "2425366DE98DAABDA25232B3D55F143E")
    public boolean canEncode() {
        boolean varB326B5062B2F0E69046810717534CB09_1781685818 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_570264981 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_570264981;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.752 -0400", hash_original_method = "0107CD00701D9024191BE26A03E59733", hash_generated_method = "B997765D4673660482F35FD22101FCC8")
    public final ByteBuffer encode(CharBuffer buffer) {
        addTaint(buffer.getTaint());
        try 
        {
ByteBuffer var95637A8358472CAB5AD181D75983367C_121629273 =             newEncoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).encode(
                            buffer);
            var95637A8358472CAB5AD181D75983367C_121629273.addTaint(taint);
            return var95637A8358472CAB5AD181D75983367C_121629273;
        } //End block
        catch (CharacterCodingException ex)
        {
            Error varBA1C780040AEBF69D20F00486E0D02B6_1627587156 = new Error(ex.getMessage(), ex);
            varBA1C780040AEBF69D20F00486E0D02B6_1627587156.addTaint(taint);
            throw varBA1C780040AEBF69D20F00486E0D02B6_1627587156;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return newEncoder()
                    //.onMalformedInput(CodingErrorAction.REPLACE)
                    //.onUnmappableCharacter(CodingErrorAction.REPLACE).encode(
                            //buffer);
        //} catch (CharacterCodingException ex) {
            //throw new Error(ex.getMessage(), ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.752 -0400", hash_original_method = "50936E0BD61264091679E7D1BE4B4220", hash_generated_method = "AF3CFFEE764EA207A1398EBA8BCCF0FA")
    public final ByteBuffer encode(String s) {
        addTaint(s.getTaint());
ByteBuffer varCA7411AD321AC1B671CDFFE1D3D2FACB_633654935 =         encode(CharBuffer.wrap(s));
        varCA7411AD321AC1B671CDFFE1D3D2FACB_633654935.addTaint(taint);
        return varCA7411AD321AC1B671CDFFE1D3D2FACB_633654935;
        // ---------- Original Method ----------
        //return encode(CharBuffer.wrap(s));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.753 -0400", hash_original_method = "126EFF7550A1ED9E8429CF707F327D0E", hash_generated_method = "93A6E196F233EF7D3BD5A00650FD6529")
    public final CharBuffer decode(ByteBuffer buffer) {
        addTaint(buffer.getTaint());
        try 
        {
CharBuffer var7F334E4D9C3050DD54B4BE69BB9C005E_1602090580 =             newDecoder()
                    .onMalformedInput(CodingErrorAction.REPLACE)
                    .onUnmappableCharacter(CodingErrorAction.REPLACE).decode(buffer);
            var7F334E4D9C3050DD54B4BE69BB9C005E_1602090580.addTaint(taint);
            return var7F334E4D9C3050DD54B4BE69BB9C005E_1602090580;
        } //End block
        catch (CharacterCodingException ex)
        {
            Error varBA1C780040AEBF69D20F00486E0D02B6_2077125350 = new Error(ex.getMessage(), ex);
            varBA1C780040AEBF69D20F00486E0D02B6_2077125350.addTaint(taint);
            throw varBA1C780040AEBF69D20F00486E0D02B6_2077125350;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return newDecoder()
                    //.onMalformedInput(CodingErrorAction.REPLACE)
                    //.onUnmappableCharacter(CodingErrorAction.REPLACE).decode(buffer);
        //} catch (CharacterCodingException ex) {
            //throw new Error(ex.getMessage(), ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.753 -0400", hash_original_method = "F361CD14D12B60D2CF0F30DB9C5F0195", hash_generated_method = "A037A17F7D204183F87050A49D317738")
    public final int compareTo(Charset charset) {
        addTaint(charset.getTaint());
        int var559C2DEB07E9C51892C555B37E09FFB6_479937663 = (this.canonicalName.compareToIgnoreCase(charset.canonicalName));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153684841 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1153684841;
        // ---------- Original Method ----------
        //return this.canonicalName.compareToIgnoreCase(charset.canonicalName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.753 -0400", hash_original_method = "938368666D1E90E2E2969E1342A5CFE9", hash_generated_method = "A62C75950185AA2D24F78A792CA67A0A")
    @Override
    public final boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(obj instanceof Charset)        
        {
            Charset that = (Charset) obj;
            boolean varBE0D88129CAE689FAE9C4634003460EC_1164169068 = (this.canonicalName.equals(that.canonicalName));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156301612 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_156301612;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1858491160 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1445361822 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1445361822;
        // ---------- Original Method ----------
        //if (obj instanceof Charset) {
            //Charset that = (Charset) obj;
            //return this.canonicalName.equals(that.canonicalName);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.754 -0400", hash_original_method = "D44320DAEF5566E6C5C975F4AAC84659", hash_generated_method = "34DA33BD20105AD4EE3236DDA5201859")
    @Override
    public final int hashCode() {
        int varFF837C799E5115E6D4362F2233C4456C_391778212 = (this.canonicalName.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113539701 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113539701;
        // ---------- Original Method ----------
        //return this.canonicalName.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.754 -0400", hash_original_method = "D15E03733F40849FC8BB6457075A7CA1", hash_generated_method = "CB66224383A1454A254BDEF5DE116351")
    @Override
    public final String toString() {
String varAE5877D4DAD502DC1B608A0F13648963_422464348 =         getClass().getName() + "[" + this.canonicalName + "]";
        varAE5877D4DAD502DC1B608A0F13648963_422464348.addTaint(taint);
        return varAE5877D4DAD502DC1B608A0F13648963_422464348;
        // ---------- Original Method ----------
        //return getClass().getName() + "[" + this.canonicalName + "]";
    }

    
        @DSModeled(DSC.SAFE)
    public static Charset defaultCharset() {
        return DEFAULT_CHARSET;
    }

    
        private static Charset getDefaultCharset() {
        String encoding = System.getProperty("file.encoding", "UTF-8");
        try {
            return Charset.forName(encoding);
        } catch (UnsupportedCharsetException e) {
            return Charset.forName("UTF-8");
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.755 -0400", hash_original_field = "3E37B559443703B81C9FE09E876D37B5", hash_generated_field = "978C227844F811E8AD7601EBA458F045")

    private static final HashMap<String, Charset> CACHED_CHARSETS = new HashMap<String, Charset>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.755 -0400", hash_original_field = "A025188D4D53C27CDD8B23136A99AC7E", hash_generated_field = "1A1C1C599D3935A97F31144300864BDF")

    private static final Charset DEFAULT_CHARSET = getDefaultCharset();
}

