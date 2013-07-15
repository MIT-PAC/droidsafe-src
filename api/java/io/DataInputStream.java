package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import libcore.io.Memory;
import libcore.io.Streams;
import libcore.io.SizeOf;

public class DataInputStream extends FilterInputStream implements DataInput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.616 -0400", hash_original_field = "239E1A8E5C884A724F64EE44024C15F5", hash_generated_field = "0DF1829DEBB6EA0D971CFA5BDB181CF9")

    private final byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.618 -0400", hash_original_method = "AECD3C5985C6EE616C4F48FE6E0C81F1", hash_generated_method = "17F9689D72B0B78F1037BD70D626285A")
    public  DataInputStream(InputStream in) {
        super(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.621 -0400", hash_original_method = "FBBAC6E2F22E2CF0617F10AA12B44AF0", hash_generated_method = "EF831A0DACC719AF44A1D3708F7C2260")
    @Override
    public final int read(byte[] buffer) throws IOException {
        addTaint(buffer[0]);
        int var3FE886BA5F76407D9A7A09D1A143BE63_1508871013 = (super.read(buffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_4472281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_4472281;
        // ---------- Original Method ----------
        //return super.read(buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.625 -0400", hash_original_method = "C547CA79E9FB46C2C7E21DBC0BF20334", hash_generated_method = "7012FE2155735C31CCEF1724425D22EB")
    @Override
    public final int read(byte[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        int varC5C3B52C3F3EBBB977DA9D0736DD40A6_462462596 = (in.read(buffer, offset, length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954144601 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954144601;
        // ---------- Original Method ----------
        //return in.read(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.627 -0400", hash_original_method = "7A8DE34B63BF8ABCBAC1CB4AC19FEB68", hash_generated_method = "E64DBFF01C2DACE79C48CE5E3DFC506B")
    public final boolean readBoolean() throws IOException {
        int temp = in.read();
    if(temp < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_751045366 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_751045366.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_751045366;
        } //End block
        boolean var581071D2E1ACA721FA204A220D24D3E5_1633810749 = (temp != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1173808878 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1173808878;
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.630 -0400", hash_original_method = "4C5816AE98147904E59B8C8EC0214947", hash_generated_method = "B85719C15876E19C32463E1B6983098D")
    public final byte readByte() throws IOException {
        int temp = in.read();
    if(temp < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_214234281 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_214234281.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_214234281;
        } //End block
        byte varEB0C37FB3D2A4D56EFEF536C0C588373_1076948528 = ((byte) temp);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_705470546 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_705470546;
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return (byte) temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.632 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "664AF9323BBA867BAAA570D49D494CA9")
    public final char readChar() throws IOException {
        char varD2B9D0AC7E6CAD4B64D448E3DC4EE790_1811063479 = ((char) readShort());
                char varA87DEB01C5F539E6BDA34829C8EF2368_268514711 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_268514711;
        // ---------- Original Method ----------
        //return (char) readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.634 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "7C3BB3C07649AF3E738A7060610B4294")
    public final double readDouble() throws IOException {
        double varB44FB75D2A60D6225B161B58EE8BE0EE_1858275803 = (Double.longBitsToDouble(readLong()));
                double varE8CD7DA078A86726031AD64F35F5A6C0_2133741514 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2133741514;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(readLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.635 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "73BD48653DABB51F1EE689E463D50DFF")
    public final float readFloat() throws IOException {
        float var61F55322990BB97833DB081A7753B25B_2083899482 = (Float.intBitsToFloat(readInt()));
                float var546ADE640B6EDFBC8A086EF31347E768_1001432340 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1001432340;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.637 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "2444EFC16C3B6FEB5364E7D874F2DA2F")
    public final void readFully(byte[] dst) throws IOException {
        addTaint(dst[0]);
        readFully(dst, 0, dst.length);
        // ---------- Original Method ----------
        //readFully(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.638 -0400", hash_original_method = "DF35152FE50D45334A46E811DED0CD82", hash_generated_method = "4117C883ACA3777753272E10895A71E8")
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(dst[0]);
        Streams.readFully(in, dst, offset, byteCount);
        // ---------- Original Method ----------
        //Streams.readFully(in, dst, offset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.640 -0400", hash_original_method = "9458C501A59EB6F89A7F70AB314A9403", hash_generated_method = "24EC5B1487297004260F048EDB69D9BA")
    public final int readInt() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.INT);
        int var7C922A9B161AE4D77245C27862C5A0B3_1554812222 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090888583 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090888583;
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.INT);
        //return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.648 -0400", hash_original_method = "65FD20FE420262B12F0063D27F62A405", hash_generated_method = "23DC2BCBACD14B8D46FEA923D72724F5")
    @Deprecated
    public final String readLine() throws IOException {
        StringBuilder line = new StringBuilder(80);
        boolean foundTerminator = false;
        while
(true)        
        {
            int nextByte = in.read();
switch(nextByte){
            case -1:
    if(line.length() == 0 && !foundTerminator)            
            {
String var540C13E9E156B687226421B24F2DF178_1676814054 =                 null;
                var540C13E9E156B687226421B24F2DF178_1676814054.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1676814054;
            } //End block
String var212D8FC412CCB2BE0F33E17280622756_271518949 =             line.toString();
            var212D8FC412CCB2BE0F33E17280622756_271518949.addTaint(taint);
            return var212D8FC412CCB2BE0F33E17280622756_271518949;
            case (byte) '\r':
    if(foundTerminator)            
            {
                ((PushbackInputStream) in).unread(nextByte);
String var212D8FC412CCB2BE0F33E17280622756_85811352 =                 line.toString();
                var212D8FC412CCB2BE0F33E17280622756_85811352.addTaint(taint);
                return var212D8FC412CCB2BE0F33E17280622756_85811352;
            } //End block
            foundTerminator = true;
    if(!(in.getClass() == PushbackInputStream.class))            
            {
                in = new PushbackInputStream(in);
            } //End block
            break;
            case (byte) '\n':
String var212D8FC412CCB2BE0F33E17280622756_1793280458 =             line.toString();
            var212D8FC412CCB2BE0F33E17280622756_1793280458.addTaint(taint);
            return var212D8FC412CCB2BE0F33E17280622756_1793280458;
            default:
    if(foundTerminator)            
            {
                ((PushbackInputStream) in).unread(nextByte);
String var212D8FC412CCB2BE0F33E17280622756_1687777459 =                 line.toString();
                var212D8FC412CCB2BE0F33E17280622756_1687777459.addTaint(taint);
                return var212D8FC412CCB2BE0F33E17280622756_1687777459;
            } //End block
            line.append((char) nextByte);
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.653 -0400", hash_original_method = "326E32602D90F4299C77023F7351E4DA", hash_generated_method = "3A72F169B1A8F0FBC7576F00E91E1141")
    public final long readLong() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.LONG);
        long var2D893E0C4B322812F3FC68288B698EF2_174969089 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1941120478 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1941120478;
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.LONG);
        //return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.655 -0400", hash_original_method = "F2D7E122731E959B896496A8F1F12120", hash_generated_method = "4F51A17AABDEE616A6C88FCE0897320E")
    public final short readShort() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        short var5EF02BCDD6FDC20E2BA6E56CB7B1512F_82450487 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
                short var4F09DAA9D95BCB166A302407A0E0BABE_313664077 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_313664077;
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        //return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.656 -0400", hash_original_method = "2685A0C57282E82FAD08AB2620B6B572", hash_generated_method = "A0983183B33E81AB8D8DDC8CA5F230E2")
    public final int readUnsignedByte() throws IOException {
        int temp = in.read();
    if(temp < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_322339668 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_322339668.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_322339668;
        } //End block
        int var3D801AA532C1CEC3EE82D87A99FDF63F_1707421226 = (temp);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902054879 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902054879;
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.657 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "92843641739CD936A250EC4CACD53EDF")
    public final int readUnsignedShort() throws IOException {
        int var4535605AA0CDF96DAC5C016A8613FBB9_492302945 = (((int) readShort()) & 0xffff);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_444376526 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_444376526;
        // ---------- Original Method ----------
        //return ((int) readShort()) & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.659 -0400", hash_original_method = "5E72291B0CE6A92E15C4771FA586BE01", hash_generated_method = "B1CE5D3D34C4F35FC9EBE99FFD464044")
    public final String readUTF() throws IOException {
String var13BDC1EE45FDB60E3252771D7EB64C4D_1065688850 =         decodeUTF(readUnsignedShort());
        var13BDC1EE45FDB60E3252771D7EB64C4D_1065688850.addTaint(taint);
        return var13BDC1EE45FDB60E3252771D7EB64C4D_1065688850;
        // ---------- Original Method ----------
        //return decodeUTF(readUnsignedShort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.661 -0400", hash_original_method = "97504F653AF4B98C0D73EF18B85FA029", hash_generated_method = "96ACADDE86A5BE23E7D5FD8F94C7A7C4")
     String decodeUTF(int utfSize) throws IOException {
        addTaint(utfSize);
String var8DE7745E9459616109A9A855B8DF1F39_871956042 =         decodeUTF(utfSize, this);
        var8DE7745E9459616109A9A855B8DF1F39_871956042.addTaint(taint);
        return var8DE7745E9459616109A9A855B8DF1F39_871956042;
        // ---------- Original Method ----------
        //return decodeUTF(utfSize, this);
    }

    
        private static String decodeUTF(int utfSize, DataInput in) throws IOException {
        byte[] buf = new byte[utfSize];
        in.readFully(buf, 0, utfSize);
        return ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize);
    }

    
        public static final String readUTF(DataInput in) throws IOException {
        return decodeUTF(in.readUnsignedShort(), in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.666 -0400", hash_original_method = "1E41AE98ED32B14C0D86483ED6D0EE22", hash_generated_method = "B5CEE22034CE5541C3E08861B4E9B981")
    public final int skipBytes(int count) throws IOException {
        addTaint(count);
        int skipped = 0;
        long skip;
        while
(skipped < count && (skip = in.skip(count - skipped)) != 0)        
        {
            skipped += skip;
        } //End block
        int varE52E279299E912838F689D4380C81F4A_123357545 = (skipped);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691419524 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_691419524;
        // ---------- Original Method ----------
        //int skipped = 0;
        //long skip;
        //while (skipped < count && (skip = in.skip(count - skipped)) != 0) {
            //skipped += skip;
        //}
        //return skipped;
    }

    
}

