package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.CloseGuard;
import java.nio.ByteOrder;
import java.nio.NioUtils;
import java.nio.channels.FileChannel;
import java.nio.charset.ModifiedUtf8;
import java.util.Arrays;
import libcore.io.ErrnoException;
import libcore.io.IoBridge;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.io.Memory;
import libcore.io.SizeOf;
import static libcore.io.OsConstants.*;

public class RandomAccessFile implements DataInput, DataOutput, Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.675 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.675 -0400", hash_original_field = "85486C53545A8169C1E28251CF0C4807", hash_generated_field = "3B32EAA0CEEDC75E8106E9EDC5E4B7B8")

    private boolean syncMetadata = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.675 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.675 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.675 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "2D38C9B39338C5B15F94E3339CE63B3F")

    private CloseGuard guard = CloseGuard.get();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.675 -0400", hash_original_field = "239E1A8E5C884A724F64EE44024C15F5", hash_generated_field = "D820A674F7D8FF0413B54161C23F9DAA")

    private byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.690 -0400", hash_original_method = "C0E3F3B9285851822189430A61815E02", hash_generated_method = "FF679CD8D6AD27B995726ECB4F81F34B")
    public  RandomAccessFile(File file, String mode) throws FileNotFoundException {
        int flags;
        {
            boolean var31FE68E20085E76C60E612103E1A721B_118342621 = (mode.equals("r"));
            {
                flags = O_RDONLY;
            } //End block
            {
                boolean varC150FED3A23211AE0FE87A89CE48B078_1977025156 = (mode.equals("rw") || mode.equals("rws") || mode.equals("rwd"));
                {
                    flags = O_RDWR | O_CREAT;
                    {
                        boolean varE03788F9BE4713BC79E72BE8EDB25E88_877429010 = (mode.equals("rws"));
                        {
                            syncMetadata = true;
                        } //End block
                        {
                            boolean var01F727A511D8361A7B723843053429C0_176913775 = (mode.equals("rwd"));
                            {
                                flags |= O_SYNC;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid mode: " + mode);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        this.mode = flags;
        this.fd = IoBridge.open(file.getAbsolutePath(), flags);
        {
            try 
            {
                fd.sync();
            } //End block
            catch (IOException e)
            { }
        } //End block
        guard.open("close");
        // ---------- Original Method ----------
        //int flags;
        //if (mode.equals("r")) {
            //flags = O_RDONLY;
        //} else if (mode.equals("rw") || mode.equals("rws") || mode.equals("rwd")) {
            //flags = O_RDWR | O_CREAT;
            //if (mode.equals("rws")) {
                //syncMetadata = true;
            //} else if (mode.equals("rwd")) {
                //flags |= O_SYNC;
            //}
        //} else {
            //throw new IllegalArgumentException("Invalid mode: " + mode);
        //}
        //this.mode = flags;
        //this.fd = IoBridge.open(file.getAbsolutePath(), flags);
        //if (syncMetadata) {
            //try {
                //fd.sync();
            //} catch (IOException e) {
            //}
        //}
        //guard.open("close");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.691 -0400", hash_original_method = "1B258B17ED328999F6B21E961C189B35", hash_generated_method = "F1AE990B617E43963A1A4F7BFB0EA56D")
    public  RandomAccessFile(String fileName, String mode) throws FileNotFoundException {
        this(new File(fileName), mode);
        addTaint(fileName.getTaint());
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.691 -0400", hash_original_method = "884D49058FBF3FAB457C152EAAE74126", hash_generated_method = "FCC816146224C27B37B4E04869E690BB")
    public void close() throws IOException {
        guard.close();
        {
            {
                boolean var360D1941DE5CB2B0EB1B1C57F7580CBA_725228119 = (channel != null && channel.isOpen());
                {
                    channel.close();
                    channel = null;
                } //End block
            } //End collapsed parenthetic
            IoUtils.close(fd);
        } //End block
        // ---------- Original Method ----------
        //guard.close();
        //synchronized (this) {
            //if (channel != null && channel.isOpen()) {
                //channel.close();
                //channel = null;
            //}
            //IoUtils.close(fd);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.692 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                guard.warnIfOpen();
            } //End block
            close();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (guard != null) {
                //guard.warnIfOpen();
            //}
            //close();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.692 -0400", hash_original_method = "C91B0C3B79D457313F842097EE5F90EE", hash_generated_method = "60D11B6B0B012B4F69B913CF3BB5B6B5")
    public final synchronized FileChannel getChannel() {
        FileChannel varB4EAC82CA7396A68D541C85D26508E83_1924581332 = null; //Variable for return #1
        {
            channel = NioUtils.newFileChannel(this, fd, mode);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1924581332 = channel;
        varB4EAC82CA7396A68D541C85D26508E83_1924581332.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1924581332;
        // ---------- Original Method ----------
        //if(channel == null) {
            //channel = NioUtils.newFileChannel(this, fd, mode);
        //}
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.692 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "D98620F38B8ECE1C4CB1A39F6E1FDD68")
    public final FileDescriptor getFD() throws IOException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1830696587 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1830696587 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_1830696587.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1830696587;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.693 -0400", hash_original_method = "BF89D60C39AB56A10CD4BF202DEE6E59", hash_generated_method = "E25AE175E9B329A9B2E53E136FD59FF2")
    public long getFilePointer() throws IOException {
        try 
        {
            long varF0C05ECAF241A024A616B548A1469DB9_1919224593 = (Libcore.os.lseek(fd, 0L, SEEK_CUR));
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1211628812 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1211628812;
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.693 -0400", hash_original_method = "E8687801225ADA3B0E63B61937B0020C", hash_generated_method = "5BE295F68B0DEA6394E8F5E33FB00B7F")
    public long length() throws IOException {
        try 
        {
            long var2D9D0231F90D97A868E782013621466D_1545381670 = (Libcore.os.fstat(fd).st_size);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2109546181 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2109546181;
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.fstat(fd).st_size;
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.699 -0400", hash_original_method = "9CBC8BBFD7044A0BC3A194777FBBD2CA", hash_generated_method = "E22561AF7FC9AFE34F068BE8EF969D4F")
    public int read() throws IOException {
        {
            boolean var5AE8D1125A90BB891EE77B81D048DDF5_835872404 = ((read(scratch, 0, 1) != -1));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984385882 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984385882;
        // ---------- Original Method ----------
        //return (read(scratch, 0, 1) != -1) ? scratch[0] & 0xff : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.700 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "667079D6CBD54DA47E3C98FAFB1271A2")
    public int read(byte[] buffer) throws IOException {
        int var6FC2792F895D13BB16201EFCBA1330E5_1155358240 = (read(buffer, 0, buffer.length));
        addTaint(buffer[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748961388 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_748961388;
        // ---------- Original Method ----------
        //return read(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.701 -0400", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "7837DC573DE0507A8A49497858EA160E")
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        int varA119A82C704C62A3513B82F79810D9CB_102893231 = (IoBridge.read(fd, buffer, byteOffset, byteCount));
        addTaint(buffer[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131864092 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2131864092;
        // ---------- Original Method ----------
        //return IoBridge.read(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.708 -0400", hash_original_method = "50A11AE3C5EDA3B4603E1C2204F22ED8", hash_generated_method = "E90E90B00144BA51B269F530B3D82D6E")
    public final boolean readBoolean() throws IOException {
        int temp;
        temp = this.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_33364431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_33364431;
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.709 -0400", hash_original_method = "2659119ED4E9182341F4E2CF2510ACC4", hash_generated_method = "E17F91DFA8BAABB3FB27C67236D70335")
    public final byte readByte() throws IOException {
        int temp;
        temp = this.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        byte var40EA57D3EE3C07BF1C102B466E1C3091_305569072 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_305569072;
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return (byte) temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.709 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "93DF51F11A79EF4CABDC1531D43149EA")
    public final char readChar() throws IOException {
        char varF2ACC106D91692A1DB07375484A6C29E_502142593 = ((char) readShort());
        char varA87DEB01C5F539E6BDA34829C8EF2368_391233053 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_391233053;
        // ---------- Original Method ----------
        //return (char) readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.709 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "165440C9062A22BC88181153790444B3")
    public final double readDouble() throws IOException {
        double var3292A685AD9C8EB2CF3ABF2B88C345AA_2042158630 = (Double.longBitsToDouble(readLong()));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1916654371 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1916654371;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(readLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.709 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "607CE5EC04D5C3B7995E91D3C5A39A2B")
    public final float readFloat() throws IOException {
        float var6656A3EBF72C98EFC9F149CC98AAD604_870356438 = (Float.intBitsToFloat(readInt()));
        float var546ADE640B6EDFBC8A086EF31347E768_893439736 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_893439736;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.714 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "E93784CCBCD5A11C504F8C0F004D4369")
    public final void readFully(byte[] dst) throws IOException {
        readFully(dst, 0, dst.length);
        addTaint(dst[0]);
        // ---------- Original Method ----------
        //readFully(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.717 -0400", hash_original_method = "35386938706C6610A66A6C02D11FE342", hash_generated_method = "3A6E65E0578F5BD498E4511458C414CE")
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(dst.length, offset, byteCount);
        {
            int result;
            result = read(dst, offset, byteCount);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException();
            } //End block
            offset += result;
            byteCount -= result;
        } //End block
        addTaint(dst[0]);
        addTaint(offset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(dst.length, offset, byteCount);
        //while (byteCount > 0) {
            //int result = read(dst, offset, byteCount);
            //if (result < 0) {
                //throw new EOFException();
            //}
            //offset += result;
            //byteCount -= result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.717 -0400", hash_original_method = "623A6326FEE6BEAC4C71D9EAB23D5BE9", hash_generated_method = "1447656B40A51CAEBCC865B7AF7D20AB")
    public final int readInt() throws IOException {
        readFully(scratch, 0, SizeOf.INT);
        int varB097092D008CB2C0CB75F2D5D42B4BD8_408601737 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938989626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938989626;
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.INT);
        //return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.719 -0400", hash_original_method = "A3561FB7999FC54AB0AB272B825D1BA9", hash_generated_method = "8AA72AFA424279A75A3338CB6B087E8D")
    public final String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_241173780 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1193910734 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2104182619 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1918551427 = null; //Variable for return #4
        StringBuilder line;
        line = new StringBuilder(80);
        boolean foundTerminator;
        foundTerminator = false;
        long unreadPosition;
        unreadPosition = 0;
        {
            int nextByte;
            nextByte = read();
            //Begin case -1 
            varB4EAC82CA7396A68D541C85D26508E83_241173780 = line.length() != 0 ? line.toString() : null;
            //End case -1 
            //Begin case (byte) '\r' 
            {
                seek(unreadPosition);
                varB4EAC82CA7396A68D541C85D26508E83_1193910734 = line.toString();
            } //End block
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            foundTerminator = true;
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            unreadPosition = getFilePointer();
            //End case (byte) '\r' 
            //Begin case (byte) '\n' 
            varB4EAC82CA7396A68D541C85D26508E83_2104182619 = line.toString();
            //End case (byte) '\n' 
            //Begin case default 
            {
                seek(unreadPosition);
                varB4EAC82CA7396A68D541C85D26508E83_1918551427 = line.toString();
            } //End block
            //End case default 
            //Begin case default 
            line.append((char) nextByte);
            //End case default 
        } //End block
        String varA7E53CE21691AB073D9660D615818899_2136578888; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2136578888 = varB4EAC82CA7396A68D541C85D26508E83_241173780;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2136578888 = varB4EAC82CA7396A68D541C85D26508E83_1193910734;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2136578888 = varB4EAC82CA7396A68D541C85D26508E83_2104182619;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2136578888 = varB4EAC82CA7396A68D541C85D26508E83_1918551427;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2136578888.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2136578888;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.727 -0400", hash_original_method = "469514DB0DA90571D02A531A0FA63D6F", hash_generated_method = "3271C9F8B232FA2DE08A58034A6BEFDA")
    public final long readLong() throws IOException {
        readFully(scratch, 0, SizeOf.LONG);
        long var9F6710AAE72C6645C9CB5D9BAF2C5E79_1835747476 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1708762984 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1708762984;
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.LONG);
        //return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.727 -0400", hash_original_method = "C93410329A523BCD2A1636A4AEB3409A", hash_generated_method = "8A9E1EF3652EFCDF8F61A65C08EF9EBC")
    public final short readShort() throws IOException {
        readFully(scratch, 0, SizeOf.SHORT);
        short var007DE4DE11DFBCEFBB55FC3C89A2F231_1173327633 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
        short var4F09DAA9D95BCB166A302407A0E0BABE_649754936 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_649754936;
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.SHORT);
        //return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.727 -0400", hash_original_method = "AF5E7921B4B2187E0041EFA801E04DA5", hash_generated_method = "8B9B327301B6AC27BE2160BC1326EF27")
    public final int readUnsignedByte() throws IOException {
        int temp;
        temp = this.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209240209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_209240209;
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.728 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "7627294A085F381858910D99732D5021")
    public final int readUnsignedShort() throws IOException {
        int var80645AD98CDAD0EE0FB3459E3825971C_1046646372 = (((int) readShort()) & 0xffff);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857244301 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_857244301;
        // ---------- Original Method ----------
        //return ((int) readShort()) & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.782 -0400", hash_original_method = "1E6F905958EDDE8569C0995497961028", hash_generated_method = "8ECA80C119C3F27D9F5ADBB3A993ABCB")
    public final String readUTF() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1856005345 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_796031132 = null; //Variable for return #2
        int utfSize;
        utfSize = readUnsignedShort();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1856005345 = "";
        } //End block
        byte[] buf;
        buf = new byte[utfSize];
        {
            boolean varCC708F7E031AEDABCA9DFF40A76762B8_1833362232 = (read(buf, 0, buf.length) != buf.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_796031132 = ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize);
        String varA7E53CE21691AB073D9660D615818899_978759195; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_978759195 = varB4EAC82CA7396A68D541C85D26508E83_1856005345;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_978759195 = varB4EAC82CA7396A68D541C85D26508E83_796031132;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_978759195.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_978759195;
        // ---------- Original Method ----------
        //int utfSize = readUnsignedShort();
        //if (utfSize == 0) {
            //return "";
        //}
        //byte[] buf = new byte[utfSize];
        //if (read(buf, 0, buf.length) != buf.length) {
            //throw new EOFException();
        //}
        //return ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.783 -0400", hash_original_method = "92812216A189B62C22C36FA4ABFCEF90", hash_generated_method = "1EDCC76EAAB68A14E3C73C2F91B5DC47")
    public void seek(long offset) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("offset < 0: " + offset);
        } //End block
        try 
        {
            Libcore.os.lseek(fd, offset, SEEK_SET);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        addTaint(offset);
        // ---------- Original Method ----------
        //if (offset < 0) {
            //throw new IOException("offset < 0: " + offset);
        //}
        //try {
            //Libcore.os.lseek(fd, offset, SEEK_SET);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.790 -0400", hash_original_method = "385EF87B8915AB37CD3540061C92256B", hash_generated_method = "2494BEDC9196EAEB5D89EFD2F59EEB58")
    public void setLength(long newLength) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("newLength < 0");
        } //End block
        try 
        {
            Libcore.os.ftruncate(fd, newLength);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        long filePointer;
        filePointer = getFilePointer();
        {
            seek(newLength);
        } //End block
        {
            fd.sync();
        } //End block
        addTaint(newLength);
        // ---------- Original Method ----------
        //if (newLength < 0) {
            //throw new IllegalArgumentException("newLength < 0");
        //}
        //try {
            //Libcore.os.ftruncate(fd, newLength);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
        //long filePointer = getFilePointer();
        //if (filePointer > newLength) {
            //seek(newLength);
        //}
        //if (syncMetadata) {
            //fd.sync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.791 -0400", hash_original_method = "FB9C2E97D200EE03574ADD76D56D23DD", hash_generated_method = "BACB5A507B2D0FB25AAA87D73821E329")
    public int skipBytes(int count) throws IOException {
        {
            long currentPos, eof;
            currentPos = getFilePointer();
            eof = length();
            int newCount;
            newCount = (int) ((currentPos + count > eof) ? eof - currentPos : count);//DSFIXME:  CODE0008: Nested ternary operator in expression
            seek(currentPos + newCount);
        } //End block
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000414508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000414508;
        // ---------- Original Method ----------
        //if (count > 0) {
            //long currentPos = getFilePointer(), eof = length();
            //int newCount = (int) ((currentPos + count > eof) ? eof - currentPos : count);
            //seek(currentPos + newCount);
            //return newCount;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.791 -0400", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "9CF54F5514EB45305F74BC43AC7A8B7B")
    public void write(byte[] buffer) throws IOException {
        write(buffer, 0, buffer.length);
        addTaint(buffer[0]);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.792 -0400", hash_original_method = "35FA4EEB101513E91F640D0BB99E182F", hash_generated_method = "8287C1A4E77452B86B1A6636CB10DD0B")
    public void write(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        IoBridge.write(fd, buffer, byteOffset, byteCount);
        {
            fd.sync();
        } //End block
        addTaint(buffer[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        // ---------- Original Method ----------
        //IoBridge.write(fd, buffer, byteOffset, byteCount);
        //if (syncMetadata) {
            //fd.sync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.792 -0400", hash_original_method = "9AECC3BD7576DA9A6BE139AE80679C12", hash_generated_method = "9FAA380C1F42D314AD87185ABF65B775")
    public void write(int oneByte) throws IOException {
        scratch[0] = (byte) (oneByte & 0xff);
        write(scratch, 0, 1);
        // ---------- Original Method ----------
        //scratch[0] = (byte) (oneByte & 0xff);
        //write(scratch, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.793 -0400", hash_original_method = "9F118A4D5206A4234B8C15F22340D26C", hash_generated_method = "F960884DA0D70FA85EFF44FE71615754")
    public final void writeBoolean(boolean val) throws IOException {
        write(val ? 1 : 0);
        addTaint(val);
        // ---------- Original Method ----------
        //write(val ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.793 -0400", hash_original_method = "B252FC199353C3326913DC87EC8ACD0F", hash_generated_method = "358B6869D9197862EB33BA05E9BB4712")
    public final void writeByte(int val) throws IOException {
        write(val & 0xFF);
        addTaint(val);
        // ---------- Original Method ----------
        //write(val & 0xFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.812 -0400", hash_original_method = "EECBC8862767167AF0CABDC3594E6347", hash_generated_method = "044B0BB88C3985B1CD282F386B6C93B5")
    public final void writeBytes(String str) throws IOException {
        byte[] bytes;
        bytes = new byte[str.length()];
        {
            int index;
            index = 0;
            boolean varA02C1B1CDA6C37943246730579D9D4AA_303391616 = (index < str.length());
            {
                bytes[index] = (byte) (str.charAt(index) & 0xFF);
            } //End block
        } //End collapsed parenthetic
        write(bytes);
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //byte[] bytes = new byte[str.length()];
        //for (int index = 0; index < str.length(); index++) {
            //bytes[index] = (byte) (str.charAt(index) & 0xFF);
        //}
        //write(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.813 -0400", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "DD808167E0A0638EDB5F24AB5B6A989B")
    public final void writeChar(int val) throws IOException {
        writeShort(val);
        addTaint(val);
        // ---------- Original Method ----------
        //writeShort(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.813 -0400", hash_original_method = "C993D359026F2BBBDD097DA5FA69EA70", hash_generated_method = "40C828827D2C23B332B7B0C74D7D5610")
    public final void writeChars(String str) throws IOException {
        write(str.getBytes("UTF-16BE"));
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //write(str.getBytes("UTF-16BE"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.813 -0400", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "3DBCD431F669B61280931467601A41C3")
    public final void writeDouble(double val) throws IOException {
        writeLong(Double.doubleToLongBits(val));
        addTaint(val);
        // ---------- Original Method ----------
        //writeLong(Double.doubleToLongBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.814 -0400", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "23BFEF07C67385B17FCF73AD5AC52B24")
    public final void writeFloat(float val) throws IOException {
        writeInt(Float.floatToIntBits(val));
        addTaint(val);
        // ---------- Original Method ----------
        //writeInt(Float.floatToIntBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.814 -0400", hash_original_method = "37CBB7B1E5121DA5847923CB75DB4FD7", hash_generated_method = "B72C4BFD7AF3D937976228E85AFBE2DD")
    public final void writeInt(int val) throws IOException {
        Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.INT);
        addTaint(val);
        // ---------- Original Method ----------
        //Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.815 -0400", hash_original_method = "7B3E247666A6F3E05280E703124B5A4E", hash_generated_method = "AC936AFC0AE896E6890B4B63CBE3BE69")
    public final void writeLong(long val) throws IOException {
        Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.LONG);
        addTaint(val);
        // ---------- Original Method ----------
        //Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.815 -0400", hash_original_method = "64B98C2F1C9F8A49F0516D9D78465522", hash_generated_method = "83B73BEC87F40B88F764696ABE144F8A")
    public final void writeShort(int val) throws IOException {
        Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.SHORT);
        addTaint(val);
        // ---------- Original Method ----------
        //Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:38.815 -0400", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "D46F217503ADED3A09B4FFB1E313F623")
    public final void writeUTF(String str) throws IOException {
        write(ModifiedUtf8.encode(str));
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //write(ModifiedUtf8.encode(str));
    }

    
}

