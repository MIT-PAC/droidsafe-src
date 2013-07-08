package java.util.jar;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.208 -0400", hash_original_field = "C1F637C34A7763FD4FC74D504F0298D3", hash_generated_field = "E1BDEFB6141BA3D4A18686A70FD48EA7")

    private Attributes mainAttributes = new Attributes();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.208 -0400", hash_original_field = "BE2B649826060A2900FD073079DE6432", hash_generated_field = "8F8C40B44CE5717105C1E59BBDAB375B")

    private HashMap<String, Attributes> entries = new HashMap<String, Attributes>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.209 -0400", hash_original_field = "A0E6AA3F5109DC15B489F628B2F01028", hash_generated_field = "786638D71EF24F3687C38482B297CD1D")

    private HashMap<String, Chunk> chunks;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.209 -0400", hash_original_field = "D91B5AEA932CCF7F1674264625D0E318", hash_generated_field = "DCB6AE1819FDCE75D830612AD5F2AE24")

    private int mainEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.209 -0400", hash_original_method = "2CD70F0E3E6560EF53C780EFAB38343C", hash_generated_method = "BD1DF1E0A8292856D9BBD81FC9365027")
    public  Manifest() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.209 -0400", hash_original_method = "2FA11E9347D2AC2716E0BA224CCFCCB5", hash_generated_method = "A466E8C3351F8A84F96CEFCBF56A1F4A")
    public  Manifest(InputStream is) throws IOException {
        read(is);
        addTaint(is.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.209 -0400", hash_original_method = "0E23B3A5115DCECDE6F46702BE2E2DEF", hash_generated_method = "CCE22E52017A98DFD89C5BA563E76749")
    @SuppressWarnings("unchecked")
    public  Manifest(Manifest man) {
        mainAttributes = (Attributes) man.mainAttributes.clone();
        entries = (HashMap<String, Attributes>) ((HashMap<String, Attributes>) man
                .getEntries()).clone();
        
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.210 -0400", hash_original_method = "19FA98C36DB13DC48F6FA00606FD5E9E", hash_generated_method = "27D52846BBAFD82E8F937B79B5A05469")
      Manifest(InputStream is, boolean readChunks) throws IOException {
        {
            chunks = new HashMap<String, Chunk>();
        } 
        read(is);
        addTaint(is.getTaint());
        addTaint(readChunks);
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static Field getByteArrayInputStreamField(String name) {
        try {
            Field f = ByteArrayInputStream.class.getDeclaredField(name);
            f.setAccessible(true);
            return f;
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.210 -0400", hash_original_method = "C6A465A281EC0C52F4CC8FABE5DA0F03", hash_generated_method = "EE197A83742325B0084D76BFCFD44EFE")
    public void clear() {
        entries.clear();
        mainAttributes.clear();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.210 -0400", hash_original_method = "78C1F2A094121E0A509E66806BC04C36", hash_generated_method = "5CED7BE79D7F560DD87854E9B7DCFCEE")
    public Attributes getAttributes(String name) {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_758484611 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_758484611 = getEntries().get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_758484611.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_758484611;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.211 -0400", hash_original_method = "AD5E8B028D2F33E921C50CB4C1BDCE39", hash_generated_method = "9F5E156AC4CBA5F6FBD0DFD1AAEF2DE9")
    public Map<String, Attributes> getEntries() {
        Map<String, Attributes> varB4EAC82CA7396A68D541C85D26508E83_380717323 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_380717323 = entries;
        varB4EAC82CA7396A68D541C85D26508E83_380717323.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_380717323;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.211 -0400", hash_original_method = "E50165B574B80B3A6D479CE79F6197B1", hash_generated_method = "DB214AFF465C192A449E8E040A47E03D")
    public Attributes getMainAttributes() {
        Attributes varB4EAC82CA7396A68D541C85D26508E83_626538263 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_626538263 = mainAttributes;
        varB4EAC82CA7396A68D541C85D26508E83_626538263.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_626538263;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.212 -0400", hash_original_method = "ED40FF59379F92DE3112CA6576AF5963", hash_generated_method = "AA8B88F197646D9D4AC468F233529040")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_781601946 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_781601946 = new Manifest(this);
        varB4EAC82CA7396A68D541C85D26508E83_781601946.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_781601946;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.212 -0400", hash_original_method = "FE58047C3F32AF11D7E00269EA71B148", hash_generated_method = "1509FB39BB5B6CF34F2EA58005FAE1EC")
    public void write(OutputStream os) throws IOException {
        write(this, os);
        addTaint(os.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.213 -0400", hash_original_method = "0BB09A51480801FE7389A84744CD3AA5", hash_generated_method = "F421A18B479A372693857C38BB1ADD98")
    public void read(InputStream is) throws IOException {
        byte[] buf;
        {
            buf = exposeByteArrayInputStreamBytes((ByteArrayInputStream) is);
        } 
        {
            buf = Streams.readFullyNoClose(is);
        } 
        byte b = buf[buf.length - 1];
        {
            buf[buf.length - 1] = '\n';
        } 
        InitManifest im = new InitManifest(buf, mainAttributes, null);
        mainEnd = im.getPos();
        im.initEntries(entries, chunks);
        addTaint(is.getTaint());
        
        
        
            
        
            
        
        
            
        
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.214 -0400", hash_original_method = "208E1F4DBC48E80FE528AF7E25427460", hash_generated_method = "9AD98E20D926266955E0EF1686B1A8C7")
    @Override
    public int hashCode() {
        int varEF13FBF52DBA3662F05AEFFC8A7E9CD7_322389589 = (mainAttributes.hashCode() ^ getEntries().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2032569579 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2032569579;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.214 -0400", hash_original_method = "7BEE688CCC8D49794388E10DAC06F788", hash_generated_method = "CE86D8F6E91BF7E43CE189784A81EF67")
    @Override
    public boolean equals(Object o) {
        {
            boolean var8F267E3B3062BBF3BAF09C797D10285D_1412949960 = (o.getClass() != this.getClass());
        } 
        {
            boolean var9A663C6DBCBC777FAAEA8BA62E02CB77_1801952812 = (!mainAttributes.equals(((Manifest) o).mainAttributes));
        } 
        boolean var9BE940C40A7DBAE3E8C23B9E65EEE9B4_452945196 = (getEntries().equals(((Manifest) o).getEntries()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_389469204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_389469204;
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.215 -0400", hash_original_method = "5810BB520240B1A3498784B2D92EABA8", hash_generated_method = "CFF471924FC3F84E09006CC3A4D26870")
     Chunk getChunk(String name) {
        Chunk varB4EAC82CA7396A68D541C85D26508E83_1094798013 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1094798013 = chunks.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1094798013.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1094798013;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.215 -0400", hash_original_method = "CB43854902C5BB6A2160DF9CF6991C4E", hash_generated_method = "9BF48AA4EEED401D667F1EAB133BFDF9")
     void removeChunks() {
        chunks = null;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.215 -0400", hash_original_method = "4F9436521007A1D33F6CF267D74BE295", hash_generated_method = "B607A1217DF244E85EBCE613F8CF2FDE")
     int getMainAttributesEnd() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857486032 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857486032;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.216 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

        int start;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.216 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

        int end;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.216 -0400", hash_original_method = "A8971FBD893650A54F56F7BF8B0891D6", hash_generated_method = "9B34306804CCDE7336BAF0539474B713")
          Chunk(int start, int end) {
            this.start = start;
            this.end = end;
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.216 -0400", hash_original_field = "9AB3FC40184A237C51AFFC319F4B6271", hash_generated_field = "4AAD2B66AAA9D2F0328C62F34531C5E8")

    static final int LINE_LENGTH_LIMIT = 72;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.216 -0400", hash_original_field = "400320F729519F67F20FF8655EC9AA32", hash_generated_field = "B67A073FAA2504AFA1E673A3A73B5070")

    private static final byte[] LINE_SEPARATOR = new byte[] { '\r', '\n' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.216 -0400", hash_original_field = "2D71FA77994AB0062A8DC99F7EBA7A6B", hash_generated_field = "9343CBDAF9029B97005DD375E4D0C015")

    private static final byte[] VALUE_SEPARATOR = new byte[] { ':', ' ' };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.216 -0400", hash_original_field = "EC072178305B566085FBD8840CD24803", hash_generated_field = "D9224D7DE651E7F79EB2339E3FD0F906")

    private static final Attributes.Name NAME_ATTRIBUTE = new Attributes.Name("Name");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.216 -0400", hash_original_field = "7B5685038886EEE668D9A84381421F4C", hash_generated_field = "1A0ED102D992A4F1419CAAB83C42E3A5")

    private static final Field BAIS_BUF = getByteArrayInputStreamField("buf");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:16.216 -0400", hash_original_field = "FFD409EB230FC948C9A6C7B22EBAD86A", hash_generated_field = "BAEA4D286068745E7FCE0DB863E317C3")

    private static final Field BAIS_POS = getByteArrayInputStreamField("pos");
}

