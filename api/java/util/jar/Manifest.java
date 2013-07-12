package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.Charsets;
import java.nio.charset.CoderResult;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import libcore.io.Streams;

public class Manifest implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.242 -0400", hash_original_field = "C1F637C34A7763FD4FC74D504F0298D3", hash_generated_field = "E1BDEFB6141BA3D4A18686A70FD48EA7")

    private Attributes mainAttributes = new Attributes();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.242 -0400", hash_original_field = "BE2B649826060A2900FD073079DE6432", hash_generated_field = "8F8C40B44CE5717105C1E59BBDAB375B")

    private HashMap<String, Attributes> entries = new HashMap<String, Attributes>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.243 -0400", hash_original_field = "A0E6AA3F5109DC15B489F628B2F01028", hash_generated_field = "786638D71EF24F3687C38482B297CD1D")

    private HashMap<String, Chunk> chunks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.243 -0400", hash_original_field = "D91B5AEA932CCF7F1674264625D0E318", hash_generated_field = "DCB6AE1819FDCE75D830612AD5F2AE24")

    private int mainEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.243 -0400", hash_original_method = "2CD70F0E3E6560EF53C780EFAB38343C", hash_generated_method = "BD1DF1E0A8292856D9BBD81FC9365027")
    public  Manifest() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.243 -0400", hash_original_method = "2FA11E9347D2AC2716E0BA224CCFCCB5", hash_generated_method = "86671B3BDCFC8E436185AB91F1B806C9")
    public  Manifest(InputStream is) throws IOException {
        addTaint(is.getTaint());
        read(is);
        // ---------- Original Method ----------
        //read(is);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.244 -0400", hash_original_method = "0E23B3A5115DCECDE6F46702BE2E2DEF", hash_generated_method = "CCE22E52017A98DFD89C5BA563E76749")
    @SuppressWarnings("unchecked")
    public  Manifest(Manifest man) {
        mainAttributes = (Attributes) man.mainAttributes.clone();
        entries = (HashMap<String, Attributes>) ((HashMap<String, Attributes>) man
                .getEntries()).clone();
        // ---------- Original Method ----------
        //mainAttributes = (Attributes) man.mainAttributes.clone();
        //entries = (HashMap<String, Attributes>) ((HashMap<String, Attributes>) man
                //.getEntries()).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.244 -0400", hash_original_method = "19FA98C36DB13DC48F6FA00606FD5E9E", hash_generated_method = "19E49DDE84D514043ECC50D3E1AA986A")
      Manifest(InputStream is, boolean readChunks) throws IOException {
        addTaint(readChunks);
        addTaint(is.getTaint());
    if(readChunks)        
        {
            chunks = new HashMap<String, Chunk>();
        } //End block
        read(is);
        // ---------- Original Method ----------
        //if (readChunks) {
            //chunks = new HashMap<String, Chunk>();
        //}
        //read(is);
    }

    
        private static Field getByteArrayInputStreamField(String name) {
        try {
            Field f = ByteArrayInputStream.class.getDeclaredField(name);
            f.setAccessible(true);
            return f;
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.245 -0400", hash_original_method = "C6A465A281EC0C52F4CC8FABE5DA0F03", hash_generated_method = "EE197A83742325B0084D76BFCFD44EFE")
    public void clear() {
        entries.clear();
        mainAttributes.clear();
        // ---------- Original Method ----------
        //entries.clear();
        //mainAttributes.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.245 -0400", hash_original_method = "78C1F2A094121E0A509E66806BC04C36", hash_generated_method = "F895EBB0D32CF6893E3C8432ADE8F914")
    public Attributes getAttributes(String name) {
        addTaint(name.getTaint());
Attributes varBEDFED3E3A699A1253CAF5B0DC778D41_1361975845 =         getEntries().get(name);
        varBEDFED3E3A699A1253CAF5B0DC778D41_1361975845.addTaint(taint);
        return varBEDFED3E3A699A1253CAF5B0DC778D41_1361975845;
        // ---------- Original Method ----------
        //return getEntries().get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.246 -0400", hash_original_method = "AD5E8B028D2F33E921C50CB4C1BDCE39", hash_generated_method = "057031EEF9949567F7A80FD0AF98B529")
    public Map<String, Attributes> getEntries() {
Map<String, Attributes> var0AAD0D341A96E603A0F87B9A9B535A71_184544192 =         entries;
        var0AAD0D341A96E603A0F87B9A9B535A71_184544192.addTaint(taint);
        return var0AAD0D341A96E603A0F87B9A9B535A71_184544192;
        // ---------- Original Method ----------
        //return entries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.246 -0400", hash_original_method = "E50165B574B80B3A6D479CE79F6197B1", hash_generated_method = "0D250C56D182F5FEFDEB2AA418FA544F")
    public Attributes getMainAttributes() {
Attributes var297AF475E4F0A70B05EE71F0F8C21A0A_2113525924 =         mainAttributes;
        var297AF475E4F0A70B05EE71F0F8C21A0A_2113525924.addTaint(taint);
        return var297AF475E4F0A70B05EE71F0F8C21A0A_2113525924;
        // ---------- Original Method ----------
        //return mainAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.246 -0400", hash_original_method = "ED40FF59379F92DE3112CA6576AF5963", hash_generated_method = "FD672CB073F5395CA34DE9BCD70164D7")
    @Override
    public Object clone() {
Object var989B3762234D39A1325CCE2FE6669585_1754754422 =         new Manifest(this);
        var989B3762234D39A1325CCE2FE6669585_1754754422.addTaint(taint);
        return var989B3762234D39A1325CCE2FE6669585_1754754422;
        // ---------- Original Method ----------
        //return new Manifest(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.247 -0400", hash_original_method = "FE58047C3F32AF11D7E00269EA71B148", hash_generated_method = "461528CAC1EC7AE66032406B69381A3F")
    public void write(OutputStream os) throws IOException {
        addTaint(os.getTaint());
        write(this, os);
        // ---------- Original Method ----------
        //write(this, os);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.247 -0400", hash_original_method = "0BB09A51480801FE7389A84744CD3AA5", hash_generated_method = "7644ACDD2F45938F4FA6032FFC29498C")
    public void read(InputStream is) throws IOException {
        addTaint(is.getTaint());
        byte[] buf;
    if(is instanceof ByteArrayInputStream)        
        {
            buf = exposeByteArrayInputStreamBytes((ByteArrayInputStream) is);
        } //End block
        else
        {
            buf = Streams.readFullyNoClose(is);
        } //End block
    if(buf.length == 0)        
        {
            return;
        } //End block
        byte b = buf[buf.length - 1];
    if(b == 0 || b == 26)        
        {
            buf[buf.length - 1] = '\n';
        } //End block
        InitManifest im = new InitManifest(buf, mainAttributes, null);
        mainEnd = im.getPos();
        im.initEntries(entries, chunks);
        // ---------- Original Method ----------
        //byte[] buf;
        //if (is instanceof ByteArrayInputStream) {
            //buf = exposeByteArrayInputStreamBytes((ByteArrayInputStream) is);
        //} else {
            //buf = Streams.readFullyNoClose(is);
        //}
        //if (buf.length == 0) {
            //return;
        //}
        //byte b = buf[buf.length - 1];
        //if (b == 0 || b == 26) {
            //buf[buf.length - 1] = '\n';
        //}
        //InitManifest im = new InitManifest(buf, mainAttributes, null);
        //mainEnd = im.getPos();
        //im.initEntries(entries, chunks);
    }

    
        private static byte[] exposeByteArrayInputStreamBytes(ByteArrayInputStream bais) {
        byte[] buffer;
        synchronized (bais) {
            byte[] buf;
            int pos;
            try {
                buf = (byte[]) BAIS_BUF.get(bais);
                pos = BAIS_POS.getInt(bais);
            } catch (IllegalAccessException iae) {
                throw new AssertionError(iae);
            }
            int available = bais.available();
            if (pos == 0 && buf.length == available) {
                buffer = buf;
            } else {
                buffer = new byte[available];
                System.arraycopy(buf, pos, buffer, 0, available);
            }
            bais.skip(available);
        }
        return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.248 -0400", hash_original_method = "208E1F4DBC48E80FE528AF7E25427460", hash_generated_method = "FB30E84FF9FBB258E5A78B39F1B78588")
    @Override
    public int hashCode() {
        int var57ED9E541EF99C55B97EC87C8BB571DD_1325360932 = (mainAttributes.hashCode() ^ getEntries().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137017167 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_137017167;
        // ---------- Original Method ----------
        //return mainAttributes.hashCode() ^ getEntries().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.249 -0400", hash_original_method = "7BEE688CCC8D49794388E10DAC06F788", hash_generated_method = "B6E8385EA064F52B1D3A3D4CF4EB89B3")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_889391726 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_594774277 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_594774277;
        } //End block
    if(o.getClass() != this.getClass())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1734260106 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312755919 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312755919;
        } //End block
    if(!mainAttributes.equals(((Manifest) o).mainAttributes))        
        {
            boolean var68934A3E9455FA72420237EB05902327_837731091 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_222870445 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_222870445;
        } //End block
        boolean var0913CC37555A896BB33329A45ED6FADC_951403719 = (getEntries().equals(((Manifest) o).getEntries()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1018778669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1018778669;
        // ---------- Original Method ----------
        //if (o == null) {
            //return false;
        //}
        //if (o.getClass() != this.getClass()) {
            //return false;
        //}
        //if (!mainAttributes.equals(((Manifest) o).mainAttributes)) {
            //return false;
        //}
        //return getEntries().equals(((Manifest) o).getEntries());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.249 -0400", hash_original_method = "5810BB520240B1A3498784B2D92EABA8", hash_generated_method = "C8E3D0F5A0AC38E5483EB6642E9967D2")
     Chunk getChunk(String name) {
        addTaint(name.getTaint());
Chunk var90FA681B410416D5DB711643976E02D4_324526152 =         chunks.get(name);
        var90FA681B410416D5DB711643976E02D4_324526152.addTaint(taint);
        return var90FA681B410416D5DB711643976E02D4_324526152;
        // ---------- Original Method ----------
        //return chunks.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.250 -0400", hash_original_method = "CB43854902C5BB6A2160DF9CF6991C4E", hash_generated_method = "9BF48AA4EEED401D667F1EAB133BFDF9")
     void removeChunks() {
        chunks = null;
        // ---------- Original Method ----------
        //chunks = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.250 -0400", hash_original_method = "4F9436521007A1D33F6CF267D74BE295", hash_generated_method = "4F8845D833066B6A396991939EC47CDF")
     int getMainAttributesEnd() {
        int varD91B5AEA932CCF7F1674264625D0E318_1084592596 = (mainEnd);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206812186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206812186;
        // ---------- Original Method ----------
        //return mainEnd;
    }

    
        static void write(Manifest manifest, OutputStream out) throws IOException {
        CharsetEncoder encoder = Charsets.UTF_8.newEncoder();
        ByteBuffer buffer = ByteBuffer.allocate(LINE_LENGTH_LIMIT);
        String version = manifest.mainAttributes.getValue(Attributes.Name.MANIFEST_VERSION);
        if (version != null) {
            writeEntry(out, Attributes.Name.MANIFEST_VERSION, version, encoder, buffer);
            Iterator<?> entries = manifest.mainAttributes.keySet().iterator();
            while (entries.hasNext()) {
                Attributes.Name name = (Attributes.Name) entries.next();
                if (!name.equals(Attributes.Name.MANIFEST_VERSION)) {
                    writeEntry(out, name, manifest.mainAttributes.getValue(name), encoder, buffer);
                }
            }
        }
        out.write(LINE_SEPARATOR);
        Iterator<String> i = manifest.getEntries().keySet().iterator();
        while (i.hasNext()) {
            String key = i.next();
            writeEntry(out, NAME_ATTRIBUTE, key, encoder, buffer);
            Attributes attrib = manifest.entries.get(key);
            Iterator<?> entries = attrib.keySet().iterator();
            while (entries.hasNext()) {
                Attributes.Name name = (Attributes.Name) entries.next();
                writeEntry(out, name, attrib.getValue(name), encoder, buffer);
            }
            out.write(LINE_SEPARATOR);
        }
    }

    
        private static void writeEntry(OutputStream os, Attributes.Name name,
            String value, CharsetEncoder encoder, ByteBuffer bBuf) throws IOException {
        String nameString = name.getName();
        os.write(nameString.getBytes(Charsets.US_ASCII));
        os.write(VALUE_SEPARATOR);
        encoder.reset();
        bBuf.clear().limit(LINE_LENGTH_LIMIT - nameString.length() - 2);
        CharBuffer cBuf = CharBuffer.wrap(value);
        while (true) {
            CoderResult r = encoder.encode(cBuf, bBuf, true);
            if (CoderResult.UNDERFLOW == r) {
                r = encoder.flush(bBuf);
            }
            os.write(bBuf.array(), bBuf.arrayOffset(), bBuf.position());
            os.write(LINE_SEPARATOR);
            if (CoderResult.UNDERFLOW == r) {
                break;
            }
            os.write(' ');
            bBuf.clear().limit(LINE_LENGTH_LIMIT - 1);
        }
    }

    
    static class Chunk {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.251 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.251 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.252 -0400", hash_original_method = "A8971FBD893650A54F56F7BF8B0891D6", hash_generated_method = "9B34306804CCDE7336BAF0539474B713")
          Chunk(int start, int end) {
            this.start = start;
            this.end = end;
            // ---------- Original Method ----------
            //this.start = start;
            //this.end = end;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.252 -0400", hash_original_field = "9AB3FC40184A237C51AFFC319F4B6271", hash_generated_field = "4AAD2B66AAA9D2F0328C62F34531C5E8")

    static final int LINE_LENGTH_LIMIT = 72;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.252 -0400", hash_original_field = "400320F729519F67F20FF8655EC9AA32", hash_generated_field = "B67A073FAA2504AFA1E673A3A73B5070")

    private static final byte[] LINE_SEPARATOR = new byte[] { '\r', '\n' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.252 -0400", hash_original_field = "2D71FA77994AB0062A8DC99F7EBA7A6B", hash_generated_field = "9343CBDAF9029B97005DD375E4D0C015")

    private static final byte[] VALUE_SEPARATOR = new byte[] { ':', ' ' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.252 -0400", hash_original_field = "EC072178305B566085FBD8840CD24803", hash_generated_field = "D9224D7DE651E7F79EB2339E3FD0F906")

    private static final Attributes.Name NAME_ATTRIBUTE = new Attributes.Name("Name");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.252 -0400", hash_original_field = "7B5685038886EEE668D9A84381421F4C", hash_generated_field = "1A0ED102D992A4F1419CAAB83C42E3A5")

    private static final Field BAIS_BUF = getByteArrayInputStreamField("buf");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:09.253 -0400", hash_original_field = "FFD409EB230FC948C9A6C7B22EBAD86A", hash_generated_field = "BAEA4D286068745E7FCE0DB863E317C3")

    private static final Field BAIS_POS = getByteArrayInputStreamField("pos");
}

