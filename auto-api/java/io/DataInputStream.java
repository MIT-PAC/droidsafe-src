package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.ByteOrder;
import java.nio.charset.ModifiedUtf8;
import libcore.io.Memory;
import libcore.io.Streams;
import libcore.io.SizeOf;

public class DataInputStream extends FilterInputStream implements DataInput {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.624 -0400", hash_original_field = "239E1A8E5C884A724F64EE44024C15F5", hash_generated_field = "0DF1829DEBB6EA0D971CFA5BDB181CF9")

    private final byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.624 -0400", hash_original_method = "AECD3C5985C6EE616C4F48FE6E0C81F1", hash_generated_method = "17F9689D72B0B78F1037BD70D626285A")
    public  DataInputStream(InputStream in) {
        super(in);
        addTaint(in.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.625 -0400", hash_original_method = "FBBAC6E2F22E2CF0617F10AA12B44AF0", hash_generated_method = "C3DEA94125E84E6DFAB1C0E25EAE6BD8")
    @Override
    public final int read(byte[] buffer) throws IOException {
        int var5D20304CDE93C454B73A071B58B41FC2_1289086012 = (super.read(buffer));
        addTaint(buffer[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406677225 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406677225;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.625 -0400", hash_original_method = "C547CA79E9FB46C2C7E21DBC0BF20334", hash_generated_method = "59A0D79A06B959189AB7CD8A05785637")
    @Override
    public final int read(byte[] buffer, int offset, int length) throws IOException {
        int varD4EC737F94C97A2DC68884F821BEA260_1380424808 = (in.read(buffer, offset, length));
        addTaint(buffer[0]);
        addTaint(offset);
        addTaint(length);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2140519441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2140519441;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.625 -0400", hash_original_method = "7A8DE34B63BF8ABCBAC1CB4AC19FEB68", hash_generated_method = "1B767409531E46F9EDD60FA39B3E611B")
    public final boolean readBoolean() throws IOException {
        int temp = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1945598824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1945598824;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.626 -0400", hash_original_method = "4C5816AE98147904E59B8C8EC0214947", hash_generated_method = "B0928283ECD97A67C18AA4266EE78923")
    public final byte readByte() throws IOException {
        int temp = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } 
        byte var40EA57D3EE3C07BF1C102B466E1C3091_426782481 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_426782481;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.626 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "9FEC2DA5173B4C2D231DABA6638EFF81")
    public final char readChar() throws IOException {
        char varF2ACC106D91692A1DB07375484A6C29E_1004196343 = ((char) readShort());
        char varA87DEB01C5F539E6BDA34829C8EF2368_73506440 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_73506440;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.627 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "9DC579633453C14CD7B2BFDB5A1F6914")
    public final double readDouble() throws IOException {
        double var3292A685AD9C8EB2CF3ABF2B88C345AA_260593345 = (Double.longBitsToDouble(readLong()));
        double varE8CD7DA078A86726031AD64F35F5A6C0_654856647 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_654856647;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.627 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "A10622F352FC754D4A974C43C7D924B7")
    public final float readFloat() throws IOException {
        float var6656A3EBF72C98EFC9F149CC98AAD604_1837081143 = (Float.intBitsToFloat(readInt()));
        float var546ADE640B6EDFBC8A086EF31347E768_2029566168 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2029566168;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.628 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "E93784CCBCD5A11C504F8C0F004D4369")
    public final void readFully(byte[] dst) throws IOException {
        readFully(dst, 0, dst.length);
        addTaint(dst[0]);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.628 -0400", hash_original_method = "DF35152FE50D45334A46E811DED0CD82", hash_generated_method = "57351F3EEB87BB1101CD83C3F43D0271")
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        Streams.readFully(in, dst, offset, byteCount);
        addTaint(dst[0]);
        addTaint(offset);
        addTaint(byteCount);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.629 -0400", hash_original_method = "9458C501A59EB6F89A7F70AB314A9403", hash_generated_method = "E858EF62DE83945109C6469862E4FADB")
    public final int readInt() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.INT);
        int varB097092D008CB2C0CB75F2D5D42B4BD8_578047449 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013547500 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2013547500;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.630 -0400", hash_original_method = "65FD20FE420262B12F0063D27F62A405", hash_generated_method = "7A9D784E0F1AC11C8762017A4AE35155")
    @Deprecated
    public final String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1965653342 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1979062937 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_864507129 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1781498610 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_940823076 = null; 
        StringBuilder line = new StringBuilder(80);
        boolean foundTerminator = false;
        {
            int nextByte = in.read();
            
            {
                boolean var9283EC23547FB4E91F8ADED78FB3824E_1542675609 = (line.length() == 0 && !foundTerminator);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1965653342 = null;
                } 
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1979062937 = line.toString();
            
            
            {
                ((PushbackInputStream) in).unread(nextByte);
                varB4EAC82CA7396A68D541C85D26508E83_864507129 = line.toString();
            } 
            
            
            foundTerminator = true;
            
            
            {
                boolean var2EF3DF204DF2FA3A280904C5F67B208D_1767112713 = (!(in.getClass() == PushbackInputStream.class));
                {
                    in = new PushbackInputStream(in);
                } 
            } 
            
            
            varB4EAC82CA7396A68D541C85D26508E83_1781498610 = line.toString();
            
            
            {
                ((PushbackInputStream) in).unread(nextByte);
                varB4EAC82CA7396A68D541C85D26508E83_940823076 = line.toString();
            } 
            
            
            line.append((char) nextByte);
            
        } 
        String varA7E53CE21691AB073D9660D615818899_1739601724; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1739601724 = varB4EAC82CA7396A68D541C85D26508E83_1965653342;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1739601724 = varB4EAC82CA7396A68D541C85D26508E83_1979062937;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1739601724 = varB4EAC82CA7396A68D541C85D26508E83_864507129;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1739601724 = varB4EAC82CA7396A68D541C85D26508E83_1781498610;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1739601724 = varB4EAC82CA7396A68D541C85D26508E83_940823076;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1739601724.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1739601724;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.631 -0400", hash_original_method = "326E32602D90F4299C77023F7351E4DA", hash_generated_method = "337F97078E151392B0D7D43BD421D8EA")
    public final long readLong() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.LONG);
        long var9F6710AAE72C6645C9CB5D9BAF2C5E79_855519699 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_779713653 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_779713653;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.631 -0400", hash_original_method = "F2D7E122731E959B896496A8F1F12120", hash_generated_method = "C238CA9F23D1CE5A8294EFC16823AC1A")
    public final short readShort() throws IOException {
        Streams.readFully(in, scratch, 0, SizeOf.SHORT);
        short var007DE4DE11DFBCEFBB55FC3C89A2F231_1250183614 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
        short var4F09DAA9D95BCB166A302407A0E0BABE_1449082449 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1449082449;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.632 -0400", hash_original_method = "2685A0C57282E82FAD08AB2620B6B572", hash_generated_method = "F497A8253398F9E23700904661E1B0D7")
    public final int readUnsignedByte() throws IOException {
        int temp = in.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173360704 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_173360704;
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.632 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "3EBF938DBF734E7484944E43726C9757")
    public final int readUnsignedShort() throws IOException {
        int var80645AD98CDAD0EE0FB3459E3825971C_1431381126 = (((int) readShort()) & 0xffff);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365782097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_365782097;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.633 -0400", hash_original_method = "5E72291B0CE6A92E15C4771FA586BE01", hash_generated_method = "F9FE688FA2E801B4DDCD0B766183DB02")
    public final String readUTF() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_2106963676 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2106963676 = decodeUTF(readUnsignedShort());
        varB4EAC82CA7396A68D541C85D26508E83_2106963676.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2106963676;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.634 -0400", hash_original_method = "97504F653AF4B98C0D73EF18B85FA029", hash_generated_method = "0FE21242551CE014291681D3C3D44D4A")
     String decodeUTF(int utfSize) throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_386134860 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_386134860 = decodeUTF(utfSize, this);
        addTaint(utfSize);
        varB4EAC82CA7396A68D541C85D26508E83_386134860.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_386134860;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static String decodeUTF(int utfSize, DataInput in) throws IOException {
        byte[] buf = new byte[utfSize];
        in.readFully(buf, 0, utfSize);
        return ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize);
    }

    
    public static final String readUTF(DataInput in) throws IOException {
        return decodeUTF(in.readUnsignedShort(), in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:47.635 -0400", hash_original_method = "1E41AE98ED32B14C0D86483ED6D0EE22", hash_generated_method = "2CDB2951334AE17D34680AA8677EF8D0")
    public final int skipBytes(int count) throws IOException {
        int skipped = 0;
        long skip = 0;
        {
            boolean var2A4115B73034251059ADD8819B331806_347997368 = (skipped < count && (skip = in.skip(count - skipped)) != 0);
            {
                skipped += skip;
            } 
        } 
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1683339777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1683339777;
        
        
        
        
            
        
        
    }

    
}

