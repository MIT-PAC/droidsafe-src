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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.594 -0400", hash_original_field = "239E1A8E5C884A724F64EE44024C15F5", hash_generated_field = "0DF1829DEBB6EA0D971CFA5BDB181CF9")

    private final byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.594 -0400", hash_original_method = "AECD3C5985C6EE616C4F48FE6E0C81F1", hash_generated_method = "17F9689D72B0B78F1037BD70D626285A")
    public  DataInputStream(InputStream in) {
        super(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.595 -0400", hash_original_method = "FBBAC6E2F22E2CF0617F10AA12B44AF0", hash_generated_method = "90DCE4BA80B937C353FBB58C5C59F432")
    @Override
    public final int read(byte[] buffer) throws IOException {
        addTaint(buffer[0]);
        int var3FE886BA5F76407D9A7A09D1A143BE63_441410314 = (super.read(buffer));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690457978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1690457978;
        // ---------- Original Method ----------
        //return super.read(buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.595 -0400", hash_original_method = "C547CA79E9FB46C2C7E21DBC0BF20334", hash_generated_method = "3DA2B16BFD35804A552E0622EE2FAFE9")
    @Override
    public final int read(byte[] buffer, int offset, int length) throws IOException {
        addTaint(length);
        addTaint(offset);
        addTaint(buffer[0]);
        int varC5C3B52C3F3EBBB977DA9D0736DD40A6_1255954826 = (in.read(buffer, offset, length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500087267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_500087267;
        // ---------- Original Method ----------
        //return in.read(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.596 -0400", hash_original_method = "7A8DE34B63BF8ABCBAC1CB4AC19FEB68", hash_generated_method = "3781EDC0BA419AC26B73D949CA8F26B3")
    public final boolean readBoolean() throws IOException {
        int temp = in.read();
        if(temp < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_1108342908 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_1108342908.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_1108342908;
        } //End block
        boolean var581071D2E1ACA721FA204A220D24D3E5_759548879 = (temp != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1137134868 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1137134868;
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.597 -0400", hash_original_method = "4C5816AE98147904E59B8C8EC0214947", hash_generated_method = "EC31631E01E5C46B8AA4777D37313118")
    public final byte readByte() throws IOException {
        int temp = in.read();
        if(temp < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_32282732 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_32282732.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_32282732;
        } //End block
        byte varEB0C37FB3D2A4D56EFEF536C0C588373_698801517 = ((byte) temp);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_2024975301 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_2024975301;
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return (byte) temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.597 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "A3144722B0C34DAEC59564E20AE95BAD")
    public final char readChar() throws IOException {
        char varD2B9D0AC7E6CAD4B64D448E3DC4EE790_654823183 = ((char) readShort());
                char varA87DEB01C5F539E6BDA34829C8EF2368_954970455 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_954970455;
        // ---------- Original Method ----------
        //return (char) readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.597 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "942EF2759FD3A8B38B991184B5F77F8C")
    public final double readDouble() throws IOException {
        double varB44FB75D2A60D6225B161B58EE8BE0EE_2029970247 = (Double.longBitsToDouble(readLong()));
                double varE8CD7DA078A86726031AD64F35F5A6C0_410439842 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_410439842;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(readLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.598 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "C69ED0F37BAFA82AA27E789E17304690")
    public final float readFloat() throws IOException {
        float var61F55322990BB97833DB081A7753B25B_1172833478 = (Float.intBitsToFloat(readInt()));
                float var546ADE640B6EDFBC8A086EF31347E768_222762415 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_222762415;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.598 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "2444EFC16C3B6FEB5364E7D874F2DA2F")
    public final void readFully(byte[] dst) throws IOException {
        addTaint(dst[0]);
        readFully(dst, 0, dst.length);
        // ---------- Original Method ----------
        //readFully(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.598 -0400", hash_original_method = "DF35152FE50D45334A46E811DED0CD82", hash_generated_method = "4117C883ACA3777753272E10895A71E8")
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(dst[0]);
        Streams.readFully(in, dst, offset, byteCount);
        // ---------- Original Method ----------
        //Streams.readFully(in, dst, offset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.599 -0400", hash_original_method = "9458C501A59EB6F89A7F70AB314A9403", hash_generated_method = "63E602D4D7FBBED820A69AA0B00F1647")
    public final int readInt() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.INT);
        int var7C922A9B161AE4D77245C27862C5A0B3_901752148 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121621376 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1121621376;
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.INT);
        //return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.600 -0400", hash_original_method = "65FD20FE420262B12F0063D27F62A405", hash_generated_method = "AFD13BC618A545DD482E5790AC57A2CE")
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
String var540C13E9E156B687226421B24F2DF178_966024972 =                 null;
                var540C13E9E156B687226421B24F2DF178_966024972.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_966024972;
            } //End block
String var212D8FC412CCB2BE0F33E17280622756_917087151 =             line.toString();
            var212D8FC412CCB2BE0F33E17280622756_917087151.addTaint(taint);
            return var212D8FC412CCB2BE0F33E17280622756_917087151;
            case (byte) '\r':
            if(foundTerminator)            
            {
                ((PushbackInputStream) in).unread(nextByte);
String var212D8FC412CCB2BE0F33E17280622756_1019901460 =                 line.toString();
                var212D8FC412CCB2BE0F33E17280622756_1019901460.addTaint(taint);
                return var212D8FC412CCB2BE0F33E17280622756_1019901460;
            } //End block
            foundTerminator = true;
            if(!(in.getClass() == PushbackInputStream.class))            
            {
                in = new PushbackInputStream(in);
            } //End block
            break;
            case (byte) '\n':
String var212D8FC412CCB2BE0F33E17280622756_1805283810 =             line.toString();
            var212D8FC412CCB2BE0F33E17280622756_1805283810.addTaint(taint);
            return var212D8FC412CCB2BE0F33E17280622756_1805283810;
            default:
            if(foundTerminator)            
            {
                ((PushbackInputStream) in).unread(nextByte);
String var212D8FC412CCB2BE0F33E17280622756_1830903830 =                 line.toString();
                var212D8FC412CCB2BE0F33E17280622756_1830903830.addTaint(taint);
                return var212D8FC412CCB2BE0F33E17280622756_1830903830;
            } //End block
            line.append((char) nextByte);
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.601 -0400", hash_original_method = "326E32602D90F4299C77023F7351E4DA", hash_generated_method = "2DD0854CEF984EB42112E8B3DD1AE6CF")
    public final long readLong() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.LONG);
        long var2D893E0C4B322812F3FC68288B698EF2_873036401 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1405131490 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1405131490;
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.LONG);
        //return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.601 -0400", hash_original_method = "F2D7E122731E959B896496A8F1F12120", hash_generated_method = "C782A24A91B72B0BC1DBA0BFFE4A2152")
    public final short readShort() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        short var5EF02BCDD6FDC20E2BA6E56CB7B1512F_1076755228 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
                short var4F09DAA9D95BCB166A302407A0E0BABE_601550108 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_601550108;
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        //return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.601 -0400", hash_original_method = "2685A0C57282E82FAD08AB2620B6B572", hash_generated_method = "03C77DC36B98CF1CEBD3BBF32CAA5FA9")
    public final int readUnsignedByte() throws IOException {
        int temp = in.read();
        if(temp < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_938460599 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_938460599.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_938460599;
        } //End block
        int var3D801AA532C1CEC3EE82D87A99FDF63F_1674210044 = (temp);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497800484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497800484;
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.602 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "8F7E83D85FA8D00062B91F3402309600")
    public final int readUnsignedShort() throws IOException {
        int var4535605AA0CDF96DAC5C016A8613FBB9_1917556202 = (((int) readShort()) & 0xffff);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920132617 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1920132617;
        // ---------- Original Method ----------
        //return ((int) readShort()) & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.602 -0400", hash_original_method = "5E72291B0CE6A92E15C4771FA586BE01", hash_generated_method = "CD5A2B74D49C2CA6154DF173578C0A4D")
    public final String readUTF() throws IOException {
String var13BDC1EE45FDB60E3252771D7EB64C4D_2044043183 =         decodeUTF(readUnsignedShort());
        var13BDC1EE45FDB60E3252771D7EB64C4D_2044043183.addTaint(taint);
        return var13BDC1EE45FDB60E3252771D7EB64C4D_2044043183;
        // ---------- Original Method ----------
        //return decodeUTF(readUnsignedShort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.602 -0400", hash_original_method = "97504F653AF4B98C0D73EF18B85FA029", hash_generated_method = "B115BEC5D6C0499FBCFFDF67B271A9D4")
     String decodeUTF(int utfSize) throws IOException {
        addTaint(utfSize);
String var8DE7745E9459616109A9A855B8DF1F39_1217144226 =         decodeUTF(utfSize, this);
        var8DE7745E9459616109A9A855B8DF1F39_1217144226.addTaint(taint);
        return var8DE7745E9459616109A9A855B8DF1F39_1217144226;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.603 -0400", hash_original_method = "1E41AE98ED32B14C0D86483ED6D0EE22", hash_generated_method = "EB847CD119C88298CF51F7B1F2A593F6")
    public final int skipBytes(int count) throws IOException {
        addTaint(count);
        int skipped = 0;
        long skip;
        while
(skipped < count && (skip = in.skip(count - skipped)) != 0)        
        {
            skipped += skip;
        } //End block
        int varE52E279299E912838F689D4380C81F4A_422178992 = (skipped);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287353433 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287353433;
        // ---------- Original Method ----------
        //int skipped = 0;
        //long skip;
        //while (skipped < count && (skip = in.skip(count - skipped)) != 0) {
            //skipped += skip;
        //}
        //return skipped;
    }

    
}

