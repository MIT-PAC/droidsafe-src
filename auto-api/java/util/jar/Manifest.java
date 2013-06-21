package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private Attributes mainAttributes = new Attributes();
    private HashMap<String, Attributes> entries = new HashMap<String, Attributes>();
    private HashMap<String, Chunk> chunks;
    private int mainEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.398 -0400", hash_original_method = "2CD70F0E3E6560EF53C780EFAB38343C", hash_generated_method = "BD1DF1E0A8292856D9BBD81FC9365027")
    @DSModeled(DSC.SAFE)
    public Manifest() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.398 -0400", hash_original_method = "2FA11E9347D2AC2716E0BA224CCFCCB5", hash_generated_method = "EFB02FF1A31BDEC8113349E53CE9FF37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Manifest(InputStream is) throws IOException {
        dsTaint.addTaint(is.dsTaint);
        read(is);
        // ---------- Original Method ----------
        //read(is);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.399 -0400", hash_original_method = "0E23B3A5115DCECDE6F46702BE2E2DEF", hash_generated_method = "E94CFB10CA06D11817D195A17335994F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public Manifest(Manifest man) {
        dsTaint.addTaint(man.dsTaint);
        mainAttributes = (Attributes) man.mainAttributes.clone();
        entries = (HashMap<String, Attributes>) ((HashMap<String, Attributes>) man
                .getEntries()).clone();
        // ---------- Original Method ----------
        //mainAttributes = (Attributes) man.mainAttributes.clone();
        //entries = (HashMap<String, Attributes>) ((HashMap<String, Attributes>) man
                //.getEntries()).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.399 -0400", hash_original_method = "19FA98C36DB13DC48F6FA00606FD5E9E", hash_generated_method = "E0450D8D8E4EBF863FEFFF66DA61AC90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Manifest(InputStream is, boolean readChunks) throws IOException {
        dsTaint.addTaint(is.dsTaint);
        dsTaint.addTaint(readChunks);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.399 -0400", hash_original_method = "C6A465A281EC0C52F4CC8FABE5DA0F03", hash_generated_method = "EE197A83742325B0084D76BFCFD44EFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear() {
        entries.clear();
        mainAttributes.clear();
        // ---------- Original Method ----------
        //entries.clear();
        //mainAttributes.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.399 -0400", hash_original_method = "78C1F2A094121E0A509E66806BC04C36", hash_generated_method = "56D333F0D2D319BD368BD4CB0EF0508B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Attributes getAttributes(String name) {
        dsTaint.addTaint(name);
        Attributes varC6810D66133524D827FA875FE6182808_980603562 = (getEntries().get(name));
        return (Attributes)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getEntries().get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.400 -0400", hash_original_method = "AD5E8B028D2F33E921C50CB4C1BDCE39", hash_generated_method = "73B8885520498F0834A441F782821D21")
    @DSModeled(DSC.SAFE)
    public Map<String, Attributes> getEntries() {
        return (Map<String, Attributes>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return entries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.400 -0400", hash_original_method = "E50165B574B80B3A6D479CE79F6197B1", hash_generated_method = "9E134E07B1B4456DE0C53DFCC57D9D89")
    @DSModeled(DSC.SAFE)
    public Attributes getMainAttributes() {
        return (Attributes)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mainAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.400 -0400", hash_original_method = "ED40FF59379F92DE3112CA6576AF5963", hash_generated_method = "6BECADDFAE9C5A38C39AB9D54D364386")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        Object var554AFAE08DC37D5563EB7D6887997C2A_1213822460 = (new Manifest(this));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Manifest(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.400 -0400", hash_original_method = "FE58047C3F32AF11D7E00269EA71B148", hash_generated_method = "E38A5B169647DB0A063A292856BF1160")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(OutputStream os) throws IOException {
        dsTaint.addTaint(os.dsTaint);
        write(this, os);
        // ---------- Original Method ----------
        //write(this, os);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.400 -0400", hash_original_method = "0BB09A51480801FE7389A84744CD3AA5", hash_generated_method = "D1F5D0928B75EC88731229326C62EA5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void read(InputStream is) throws IOException {
        dsTaint.addTaint(is.dsTaint);
        byte[] buf;
        {
            buf = exposeByteArrayInputStreamBytes((ByteArrayInputStream) is);
        } //End block
        {
            buf = Streams.readFullyNoClose(is);
        } //End block
        byte b;
        b = buf[buf.length - 1];
        {
            buf[buf.length - 1] = '\n';
        } //End block
        InitManifest im;
        im = new InitManifest(buf, mainAttributes, null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.401 -0400", hash_original_method = "208E1F4DBC48E80FE528AF7E25427460", hash_generated_method = "674CF1875BF55A41488A54570C6FD31A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varEF13FBF52DBA3662F05AEFFC8A7E9CD7_2099413064 = (mainAttributes.hashCode() ^ getEntries().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mainAttributes.hashCode() ^ getEntries().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.401 -0400", hash_original_method = "7BEE688CCC8D49794388E10DAC06F788", hash_generated_method = "8CF4C5C72108A521C14CF299FAFC8AC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var8F267E3B3062BBF3BAF09C797D10285D_895014675 = (o.getClass() != this.getClass());
        } //End collapsed parenthetic
        {
            boolean var9A663C6DBCBC777FAAEA8BA62E02CB77_1249271216 = (!mainAttributes.equals(((Manifest) o).mainAttributes));
        } //End collapsed parenthetic
        boolean var9BE940C40A7DBAE3E8C23B9E65EEE9B4_2001752126 = (getEntries().equals(((Manifest) o).getEntries()));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.401 -0400", hash_original_method = "5810BB520240B1A3498784B2D92EABA8", hash_generated_method = "7F7BE212C0147195A4EE696A4C4F59FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Chunk getChunk(String name) {
        dsTaint.addTaint(name);
        Chunk var491A6EBABF094311E835A47FB63C885F_670172150 = (chunks.get(name));
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return chunks.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.401 -0400", hash_original_method = "CB43854902C5BB6A2160DF9CF6991C4E", hash_generated_method = "9BF48AA4EEED401D667F1EAB133BFDF9")
    @DSModeled(DSC.SAFE)
     void removeChunks() {
        chunks = null;
        // ---------- Original Method ----------
        //chunks = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.402 -0400", hash_original_method = "4F9436521007A1D33F6CF267D74BE295", hash_generated_method = "E1B44F4044E006726AA4DEF3372A0EDD")
    @DSModeled(DSC.SAFE)
     int getMainAttributesEnd() {
        return dsTaint.getTaintInt();
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
        int start;
        int end;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.402 -0400", hash_original_method = "A8971FBD893650A54F56F7BF8B0891D6", hash_generated_method = "7398CBE5F38D47DD7F3DAE9945413946")
        @DSModeled(DSC.SAFE)
         Chunk(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            // ---------- Original Method ----------
            //this.start = start;
            //this.end = end;
        }

        
    }


    
    static final int LINE_LENGTH_LIMIT = 72;
    private static final byte[] LINE_SEPARATOR = new byte[] { '\r', '\n' };
    private static final byte[] VALUE_SEPARATOR = new byte[] { ':', ' ' };
    private static final Attributes.Name NAME_ATTRIBUTE = new Attributes.Name("Name");
    private static final Field BAIS_BUF = getByteArrayInputStreamField("buf");
    private static final Field BAIS_POS = getByteArrayInputStreamField("pos");
}

