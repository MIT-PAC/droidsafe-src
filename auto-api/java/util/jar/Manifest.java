package java.util.jar;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    static final int LINE_LENGTH_LIMIT = 72;
    private static final byte[] LINE_SEPARATOR = new byte[] { '\r', '\n' };
    private static final byte[] VALUE_SEPARATOR = new byte[] { ':', ' ' };
    private static final Attributes.Name NAME_ATTRIBUTE = new Attributes.Name("Name");
    private static final Field BAIS_BUF = getByteArrayInputStreamField("buf");
    private static final Field BAIS_POS = getByteArrayInputStreamField("pos");
    private Attributes mainAttributes = new Attributes();
    private HashMap<String, Attributes> entries = new HashMap<String, Attributes>();
    private HashMap<String, Chunk> chunks;
    private int mainEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.071 -0400", hash_original_method = "2CD70F0E3E6560EF53C780EFAB38343C", hash_generated_method = "33F0D9E08CCF9395D341BDBB50268234")
    @DSModeled(DSC.SAFE)
    public Manifest() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.072 -0400", hash_original_method = "2FA11E9347D2AC2716E0BA224CCFCCB5", hash_generated_method = "5F89A2708225FD925C877C272EEF9186")
    @DSModeled(DSC.SAFE)
    public Manifest(InputStream is) throws IOException {
        dsTaint.addTaint(is.dsTaint);
        read(is);
        // ---------- Original Method ----------
        //read(is);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.075 -0400", hash_original_method = "0E23B3A5115DCECDE6F46702BE2E2DEF", hash_generated_method = "848E2CCBCDA625E754552D2076660B87")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.077 -0400", hash_original_method = "19FA98C36DB13DC48F6FA00606FD5E9E", hash_generated_method = "F3B3B35E06D8359CF1B20ABCCBF799DD")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.079 -0400", hash_original_method = "54A9C882DCF00408D3A492AAABB65302", hash_generated_method = "4120E28E793559951DD415810AFAABC0")
    private static Field getByteArrayInputStreamField(String name) {
        try {
            Field f = ByteArrayInputStream.class.getDeclaredField(name);
            f.setAccessible(true);
            return f;
        } catch (Exception ex) {
            throw new AssertionError(ex);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.081 -0400", hash_original_method = "C6A465A281EC0C52F4CC8FABE5DA0F03", hash_generated_method = "4222B42B47947C5C07C44F42788D1746")
    @DSModeled(DSC.SAFE)
    public void clear() {
        entries.clear();
        mainAttributes.clear();
        // ---------- Original Method ----------
        //entries.clear();
        //mainAttributes.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.082 -0400", hash_original_method = "78C1F2A094121E0A509E66806BC04C36", hash_generated_method = "8BC86427283F1F0CBBCD26620DE7CAD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Attributes getAttributes(String name) {
        dsTaint.addTaint(name);
        Attributes varC6810D66133524D827FA875FE6182808_1145436275 = (getEntries().get(name));
        return (Attributes)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getEntries().get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.084 -0400", hash_original_method = "AD5E8B028D2F33E921C50CB4C1BDCE39", hash_generated_method = "39C505221E1FC432DCD2985E7AEAD381")
    @DSModeled(DSC.SAFE)
    public Map<String, Attributes> getEntries() {
        return (Map<String, Attributes>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return entries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.085 -0400", hash_original_method = "E50165B574B80B3A6D479CE79F6197B1", hash_generated_method = "28AB1BC97CC659238B70382EF32FEDF4")
    @DSModeled(DSC.SAFE)
    public Attributes getMainAttributes() {
        return (Attributes)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mainAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.086 -0400", hash_original_method = "ED40FF59379F92DE3112CA6576AF5963", hash_generated_method = "8F04EE899376E28045C504172F3EB0E5")
    @DSModeled(DSC.SAFE)
    @Override
    public Object clone() {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Manifest(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.088 -0400", hash_original_method = "FE58047C3F32AF11D7E00269EA71B148", hash_generated_method = "707B9CB496DBD186B1EDCA40366A1AE7")
    @DSModeled(DSC.SAFE)
    public void write(OutputStream os) throws IOException {
        dsTaint.addTaint(os.dsTaint);
        write(this, os);
        // ---------- Original Method ----------
        //write(this, os);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.093 -0400", hash_original_method = "0BB09A51480801FE7389A84744CD3AA5", hash_generated_method = "126F5C3E20F27395D64CB09280A0ADF6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.095 -0400", hash_original_method = "2E7B60C359CF2BD0792E359FF0052325", hash_generated_method = "4574E71359566A1BDF8A7837EF55FE2A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.098 -0400", hash_original_method = "208E1F4DBC48E80FE528AF7E25427460", hash_generated_method = "8591FFB43A7EEC10559921E91D869E65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varEF13FBF52DBA3662F05AEFFC8A7E9CD7_1193708930 = (mainAttributes.hashCode() ^ getEntries().hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mainAttributes.hashCode() ^ getEntries().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.102 -0400", hash_original_method = "7BEE688CCC8D49794388E10DAC06F788", hash_generated_method = "BDE3A5B2B44CC2C6825B656830D562F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var8F267E3B3062BBF3BAF09C797D10285D_385325940 = (o.getClass() != this.getClass());
        } //End collapsed parenthetic
        {
            boolean var9A663C6DBCBC777FAAEA8BA62E02CB77_784142988 = (!mainAttributes.equals(((Manifest) o).mainAttributes));
        } //End collapsed parenthetic
        boolean var9BE940C40A7DBAE3E8C23B9E65EEE9B4_1342892532 = (getEntries().equals(((Manifest) o).getEntries()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.105 -0400", hash_original_method = "5810BB520240B1A3498784B2D92EABA8", hash_generated_method = "0C2E47868588476013E0A5B5BEF95AC1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Chunk getChunk(String name) {
        dsTaint.addTaint(name);
        Chunk var491A6EBABF094311E835A47FB63C885F_1676077047 = (chunks.get(name));
        return (Chunk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return chunks.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.106 -0400", hash_original_method = "CB43854902C5BB6A2160DF9CF6991C4E", hash_generated_method = "B92E055048F893E4BFC098CE2595CD69")
    @DSModeled(DSC.SAFE)
     void removeChunks() {
        chunks = null;
        // ---------- Original Method ----------
        //chunks = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.108 -0400", hash_original_method = "4F9436521007A1D33F6CF267D74BE295", hash_generated_method = "EFC467FF0BAFAA2D47EB91A790A3DE96")
    @DSModeled(DSC.SAFE)
     int getMainAttributesEnd() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mainEnd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.111 -0400", hash_original_method = "364FA78950C637E356994D1026A925C2", hash_generated_method = "0EE1D0450F252260DB5C7949D54F5970")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.114 -0400", hash_original_method = "91A1237435E0826AC7F08CD4C51C942A", hash_generated_method = "C07BDDD76C2E3BC73A743964855535EC")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 15:53:15.117 -0400", hash_original_method = "A8971FBD893650A54F56F7BF8B0891D6", hash_generated_method = "EDF077FACA8F5898755EB16980D1544A")
        @DSModeled(DSC.SAFE)
         Chunk(int start, int end) {
            dsTaint.addTaint(start);
            dsTaint.addTaint(end);
            // ---------- Original Method ----------
            //this.start = start;
            //this.end = end;
        }

        
    }


    
}


