package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import libcore.io.Memory;
import libcore.io.Streams;
import libcore.io.SizeOf;

public class DataInputStream extends FilterInputStream implements DataInput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.688 -0400", hash_original_field = "239E1A8E5C884A724F64EE44024C15F5", hash_generated_field = "D820A674F7D8FF0413B54161C23F9DAA")

    private byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.689 -0400", hash_original_method = "AECD3C5985C6EE616C4F48FE6E0C81F1", hash_generated_method = "17F9689D72B0B78F1037BD70D626285A")
    public  DataInputStream(InputStream in) {
        super(in);
        addTaint(in.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.689 -0400", hash_original_method = "FBBAC6E2F22E2CF0617F10AA12B44AF0", hash_generated_method = "46C13C23B9A341F4780AEEF80404BFAE")
    @Override
    public final int read(byte[] buffer) throws IOException {
        int var5D20304CDE93C454B73A071B58B41FC2_588125570 = (super.read(buffer));
        addTaint(buffer[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_667097681 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_667097681;
        // ---------- Original Method ----------
        //return super.read(buffer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.690 -0400", hash_original_method = "C547CA79E9FB46C2C7E21DBC0BF20334", hash_generated_method = "E32242484B86FE508624EBB4CD818549")
    @Override
    public final int read(byte[] buffer, int offset, int length) throws IOException {
        int varD4EC737F94C97A2DC68884F821BEA260_849458304 = (in.read(buffer, offset, length));
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_751103095 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_751103095;
        // ---------- Original Method ----------
        //return in.read(buffer, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.690 -0400", hash_original_method = "7A8DE34B63BF8ABCBAC1CB4AC19FEB68", hash_generated_method = "66A660EC55E12888ED4913296E2E86F5")
    public final boolean readBoolean() throws IOException {
        int temp;
        temp = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_95671761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_95671761;
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.690 -0400", hash_original_method = "4C5816AE98147904E59B8C8EC0214947", hash_generated_method = "CE0F868B98116FCA9079CD6789113D84")
    public final byte readByte() throws IOException {
        int temp;
        temp = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        byte var40EA57D3EE3C07BF1C102B466E1C3091_665021800 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_665021800;
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return (byte) temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.690 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "CE9F9DEBA6EAD7892C183A28467B7BFC")
    public final char readChar() throws IOException {
        char varF2ACC106D91692A1DB07375484A6C29E_923796903 = ((char) readShort());
        char varA87DEB01C5F539E6BDA34829C8EF2368_1909731091 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1909731091;
        // ---------- Original Method ----------
        //return (char) readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.694 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "C5FF952C8338EA246B18D7F89FCFB8B2")
    public final double readDouble() throws IOException {
        double var3292A685AD9C8EB2CF3ABF2B88C345AA_1367899127 = (Double.longBitsToDouble(readLong()));
        double varE8CD7DA078A86726031AD64F35F5A6C0_2065291641 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2065291641;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(readLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.694 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "B0CDDDC6B9487BAAAE55FD5CCB864AB0")
    public final float readFloat() throws IOException {
        float var6656A3EBF72C98EFC9F149CC98AAD604_1953108343 = (Float.intBitsToFloat(readInt()));
        float var546ADE640B6EDFBC8A086EF31347E768_531141255 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_531141255;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.695 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "E93784CCBCD5A11C504F8C0F004D4369")
    public final void readFully(byte[] dst) throws IOException {
        readFully(dst, 0, dst.length);
        addTaint(dst[0]);
        // ---------- Original Method ----------
        //readFully(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.695 -0400", hash_original_method = "DF35152FE50D45334A46E811DED0CD82", hash_generated_method = "57351F3EEB87BB1101CD83C3F43D0271")
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        Streams.readFully(in, dst, offset, byteCount);
        addTaint(dst[0]);
        addTaint(offset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //Streams.readFully(in, dst, offset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.706 -0400", hash_original_method = "9458C501A59EB6F89A7F70AB314A9403", hash_generated_method = "1A27277D26D16BD79D307EA7DA6BE12E")
    public final int readInt() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.INT);
        int varB097092D008CB2C0CB75F2D5D42B4BD8_2144656804 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2007859504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2007859504;
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.INT);
        //return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.708 -0400", hash_original_method = "65FD20FE420262B12F0063D27F62A405", hash_generated_method = "DACC37D4303642A2A6CB36186B1834FC")
    @Deprecated
    public final String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1240509011 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_976148951 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1518301658 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_2075382651 = null; //Variable for return #4
        String varB4EAC82CA7396A68D541C85D26508E83_1525041768 = null; //Variable for return #5
        StringBuilder line;
        line = new StringBuilder(80);
        boolean foundTerminator;
        foundTerminator = false;
        {
            int nextByte;
            nextByte = in.read();
            //Begin case -1 
            {
                boolean var9283EC23547FB4E91F8ADED78FB3824E_894613615 = (line.length() == 0 && !foundTerminator);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1240509011 = null;
                } //End block
            } //End collapsed parenthetic
            //End case -1 
            //Begin case -1 
            varB4EAC82CA7396A68D541C85D26508E83_976148951 = line.toString();
            //End case -1 
            //Begin case (byte) '\r' 
            {
                ((PushbackInputStream) in).unread(nextByte);
                varB4EAC82CA7396A68D541C85D26508E83_1518301658 = line.toString();
            } //End block
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            foundTerminator = true;
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            {
                boolean var2EF3DF204DF2FA3A280904C5F67B208D_496720145 = (!(in.getClass() == PushbackInputStream.class));
                {
                    in = new PushbackInputStream(in);
                } //End block
            } //End collapsed parenthetic
            //End case (byte) '\r' 
            //Begin case (byte) '\n' 
            varB4EAC82CA7396A68D541C85D26508E83_2075382651 = line.toString();
            //End case (byte) '\n' 
            //Begin case default 
            {
                ((PushbackInputStream) in).unread(nextByte);
                varB4EAC82CA7396A68D541C85D26508E83_1525041768 = line.toString();
            } //End block
            //End case default 
            //Begin case default 
            line.append((char) nextByte);
            //End case default 
        } //End block
        String varA7E53CE21691AB073D9660D615818899_443645846; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_443645846 = varB4EAC82CA7396A68D541C85D26508E83_1240509011;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_443645846 = varB4EAC82CA7396A68D541C85D26508E83_976148951;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_443645846 = varB4EAC82CA7396A68D541C85D26508E83_1518301658;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_443645846 = varB4EAC82CA7396A68D541C85D26508E83_2075382651;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_443645846 = varB4EAC82CA7396A68D541C85D26508E83_1525041768;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_443645846.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_443645846;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.709 -0400", hash_original_method = "326E32602D90F4299C77023F7351E4DA", hash_generated_method = "4079E4C9388AAE69215E8A61006948C2")
    public final long readLong() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.LONG);
        long var9F6710AAE72C6645C9CB5D9BAF2C5E79_1445366479 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1538520281 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1538520281;
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.LONG);
        //return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.709 -0400", hash_original_method = "F2D7E122731E959B896496A8F1F12120", hash_generated_method = "E6CF2FCF88F52F0BC188C14D84D224F0")
    public final short readShort() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        short var007DE4DE11DFBCEFBB55FC3C89A2F231_1921207788 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
        short var4F09DAA9D95BCB166A302407A0E0BABE_1981059164 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1981059164;
        // ---------- Original Method ----------
        //Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        //return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.709 -0400", hash_original_method = "2685A0C57282E82FAD08AB2620B6B572", hash_generated_method = "576E13F216F6D437DE86AFF06F863DDC")
    public final int readUnsignedByte() throws IOException {
        int temp;
        temp = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120608320 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_120608320;
        // ---------- Original Method ----------
        //int temp = in.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.719 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "DB3AE23A4B048F621B8B082C062111E7")
    public final int readUnsignedShort() throws IOException {
        int var80645AD98CDAD0EE0FB3459E3825971C_1981555518 = (((int) readShort()) & 0xffff);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_600212212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_600212212;
        // ---------- Original Method ----------
        //return ((int) readShort()) & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.720 -0400", hash_original_method = "5E72291B0CE6A92E15C4771FA586BE01", hash_generated_method = "2E9BB3B21C28C880191E509F0BDBE6A8")
    public final String readUTF() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_854529892 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_854529892 = decodeUTF(readUnsignedShort());
        varB4EAC82CA7396A68D541C85D26508E83_854529892.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_854529892;
        // ---------- Original Method ----------
        //return decodeUTF(readUnsignedShort());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.721 -0400", hash_original_method = "97504F653AF4B98C0D73EF18B85FA029", hash_generated_method = "FB39526FBFCFF36EFDC3009684C91721")
     String decodeUTF(int utfSize) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1900896648 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1900896648 = decodeUTF(utfSize, this);
        addTaint(utfSize);
        varB4EAC82CA7396A68D541C85D26508E83_1900896648.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1900896648;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:37.722 -0400", hash_original_method = "1E41AE98ED32B14C0D86483ED6D0EE22", hash_generated_method = "48FCCCF78F4C9B72C6AEEBAE16937415")
    public final int skipBytes(int count) throws IOException {
        int skipped;
        skipped = 0;
        long skip;
        {
            boolean var2A4115B73034251059ADD8819B331806_2070634015 = (skipped < count && (skip = in.skip(count - skipped)) != 0);
            {
                skipped += skip;
            } //End block
        } //End collapsed parenthetic
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598863226 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_598863226;
        // ---------- Original Method ----------
        //int skipped = 0;
        //long skip;
        //while (skipped < count && (skip = in.skip(count - skipped)) != 0) {
            //skipped += skip;
        //}
        //return skipped;
    }

    
}

