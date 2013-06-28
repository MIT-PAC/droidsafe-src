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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.957 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.957 -0400", hash_original_field = "85486C53545A8169C1E28251CF0C4807", hash_generated_field = "3B32EAA0CEEDC75E8106E9EDC5E4B7B8")

    private boolean syncMetadata = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.957 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.957 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.957 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.958 -0400", hash_original_field = "239E1A8E5C884A724F64EE44024C15F5", hash_generated_field = "0DF1829DEBB6EA0D971CFA5BDB181CF9")

    private final byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.958 -0400", hash_original_method = "C0E3F3B9285851822189430A61815E02", hash_generated_method = "1D6E43A87C52D095BBC68A41D2F1ACFB")
    public  RandomAccessFile(File file, String mode) throws FileNotFoundException {
        int flags;
        {
            boolean var31FE68E20085E76C60E612103E1A721B_4357745 = (mode.equals("r"));
            {
                flags = O_RDONLY;
            } //End block
            {
                boolean varC150FED3A23211AE0FE87A89CE48B078_1962028461 = (mode.equals("rw") || mode.equals("rws") || mode.equals("rwd"));
                {
                    flags = O_RDWR | O_CREAT;
                    {
                        boolean varE03788F9BE4713BC79E72BE8EDB25E88_114174127 = (mode.equals("rws"));
                        {
                            syncMetadata = true;
                        } //End block
                        {
                            boolean var01F727A511D8361A7B723843053429C0_2092150662 = (mode.equals("rwd"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.959 -0400", hash_original_method = "1B258B17ED328999F6B21E961C189B35", hash_generated_method = "F1AE990B617E43963A1A4F7BFB0EA56D")
    public  RandomAccessFile(String fileName, String mode) throws FileNotFoundException {
        this(new File(fileName), mode);
        addTaint(fileName.getTaint());
        addTaint(mode.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.959 -0400", hash_original_method = "884D49058FBF3FAB457C152EAAE74126", hash_generated_method = "96229194373EEAABDF0A0407B45C6248")
    public void close() throws IOException {
        guard.close();
        {
            {
                boolean var360D1941DE5CB2B0EB1B1C57F7580CBA_608451582 = (channel != null && channel.isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.959 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.960 -0400", hash_original_method = "C91B0C3B79D457313F842097EE5F90EE", hash_generated_method = "046F21EA9E9354722ABE25A82DD8CC83")
    public final synchronized FileChannel getChannel() {
        FileChannel varB4EAC82CA7396A68D541C85D26508E83_480498067 = null; //Variable for return #1
        {
            channel = NioUtils.newFileChannel(this, fd, mode);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_480498067 = channel;
        varB4EAC82CA7396A68D541C85D26508E83_480498067.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_480498067;
        // ---------- Original Method ----------
        //if(channel == null) {
            //channel = NioUtils.newFileChannel(this, fd, mode);
        //}
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.961 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "D6E942D5D4A46B46D087C8F3C010EE97")
    public final FileDescriptor getFD() throws IOException {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1764415272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1764415272 = fd;
        varB4EAC82CA7396A68D541C85D26508E83_1764415272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1764415272;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.962 -0400", hash_original_method = "BF89D60C39AB56A10CD4BF202DEE6E59", hash_generated_method = "7B2EE534E84888F700A0A59839F6DFE3")
    public long getFilePointer() throws IOException {
        try 
        {
            long varF0C05ECAF241A024A616B548A1469DB9_538938133 = (Libcore.os.lseek(fd, 0L, SEEK_CUR));
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_328627677 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_328627677;
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.963 -0400", hash_original_method = "E8687801225ADA3B0E63B61937B0020C", hash_generated_method = "B91587048CE176C289946B60A6014F3A")
    public long length() throws IOException {
        try 
        {
            long var2D9D0231F90D97A868E782013621466D_586482608 = (Libcore.os.fstat(fd).st_size);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1289733818 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1289733818;
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.fstat(fd).st_size;
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.963 -0400", hash_original_method = "9CBC8BBFD7044A0BC3A194777FBBD2CA", hash_generated_method = "12EF370AE6941CC12BF960CF08762BEB")
    public int read() throws IOException {
        {
            boolean var5AE8D1125A90BB891EE77B81D048DDF5_1671808242 = ((read(scratch, 0, 1) != -1));
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519680994 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519680994;
        // ---------- Original Method ----------
        //return (read(scratch, 0, 1) != -1) ? scratch[0] & 0xff : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.964 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "9221C51EBE989892AEBA781338C27593")
    public int read(byte[] buffer) throws IOException {
        int var6FC2792F895D13BB16201EFCBA1330E5_1053643638 = (read(buffer, 0, buffer.length));
        addTaint(buffer[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790073075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_790073075;
        // ---------- Original Method ----------
        //return read(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.965 -0400", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "F8321FD079A092936371EED3284D53F8")
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        int varA119A82C704C62A3513B82F79810D9CB_1594025321 = (IoBridge.read(fd, buffer, byteOffset, byteCount));
        addTaint(buffer[0]);
        addTaint(byteOffset);
        addTaint(byteCount);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632771782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_632771782;
        // ---------- Original Method ----------
        //return IoBridge.read(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.965 -0400", hash_original_method = "50A11AE3C5EDA3B4603E1C2204F22ED8", hash_generated_method = "CE35B0D21CB4BA9688369E630D524BE9")
    public final boolean readBoolean() throws IOException {
        int temp = this.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657584553 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_657584553;
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.965 -0400", hash_original_method = "2659119ED4E9182341F4E2CF2510ACC4", hash_generated_method = "20C02B53D327F79AC0A1F4A9C14D1E8C")
    public final byte readByte() throws IOException {
        int temp = this.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1132239596 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1132239596;
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return (byte) temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.966 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "8AC89F4C10B891D8382B3C543BA210F5")
    public final char readChar() throws IOException {
        char varF2ACC106D91692A1DB07375484A6C29E_1000611514 = ((char) readShort());
        char varA87DEB01C5F539E6BDA34829C8EF2368_254143636 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_254143636;
        // ---------- Original Method ----------
        //return (char) readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.966 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "29ECB3812888E8C77332D522E34EEE28")
    public final double readDouble() throws IOException {
        double var3292A685AD9C8EB2CF3ABF2B88C345AA_150765487 = (Double.longBitsToDouble(readLong()));
        double varE8CD7DA078A86726031AD64F35F5A6C0_1418694979 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1418694979;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(readLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.966 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "787A8D7A85236FC21416D5D9850D4974")
    public final float readFloat() throws IOException {
        float var6656A3EBF72C98EFC9F149CC98AAD604_305075835 = (Float.intBitsToFloat(readInt()));
        float var546ADE640B6EDFBC8A086EF31347E768_923319826 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_923319826;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.967 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "E93784CCBCD5A11C504F8C0F004D4369")
    public final void readFully(byte[] dst) throws IOException {
        readFully(dst, 0, dst.length);
        addTaint(dst[0]);
        // ---------- Original Method ----------
        //readFully(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.967 -0400", hash_original_method = "35386938706C6610A66A6C02D11FE342", hash_generated_method = "2693D7034F16ED9E9616E60A08F3D4DD")
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        Arrays.checkOffsetAndCount(dst.length, offset, byteCount);
        {
            int result = read(dst, offset, byteCount);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.967 -0400", hash_original_method = "623A6326FEE6BEAC4C71D9EAB23D5BE9", hash_generated_method = "5711A36A77ABD322230053FB03C996CC")
    public final int readInt() throws IOException {
        readFully(scratch, 0, SizeOf.INT);
        int varB097092D008CB2C0CB75F2D5D42B4BD8_1844394976 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_332963805 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_332963805;
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.INT);
        //return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.968 -0400", hash_original_method = "A3561FB7999FC54AB0AB272B825D1BA9", hash_generated_method = "F4E380CCB092C741D9FCB11498B62436")
    public final String readLine() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_25936767 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1289702789 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_638830089 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1430785728 = null; //Variable for return #4
        StringBuilder line = new StringBuilder(80);
        boolean foundTerminator = false;
        long unreadPosition = 0;
        {
            int nextByte = read();
            //Begin case -1 
            varB4EAC82CA7396A68D541C85D26508E83_25936767 = line.length() != 0 ? line.toString() : null;
            //End case -1 
            //Begin case (byte) '\r' 
            {
                seek(unreadPosition);
                varB4EAC82CA7396A68D541C85D26508E83_1289702789 = line.toString();
            } //End block
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            foundTerminator = true;
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            unreadPosition = getFilePointer();
            //End case (byte) '\r' 
            //Begin case (byte) '\n' 
            varB4EAC82CA7396A68D541C85D26508E83_638830089 = line.toString();
            //End case (byte) '\n' 
            //Begin case default 
            {
                seek(unreadPosition);
                varB4EAC82CA7396A68D541C85D26508E83_1430785728 = line.toString();
            } //End block
            //End case default 
            //Begin case default 
            line.append((char) nextByte);
            //End case default 
        } //End block
        String varA7E53CE21691AB073D9660D615818899_255042915; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_255042915 = varB4EAC82CA7396A68D541C85D26508E83_25936767;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_255042915 = varB4EAC82CA7396A68D541C85D26508E83_1289702789;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_255042915 = varB4EAC82CA7396A68D541C85D26508E83_638830089;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_255042915 = varB4EAC82CA7396A68D541C85D26508E83_1430785728;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_255042915.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_255042915;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.969 -0400", hash_original_method = "469514DB0DA90571D02A531A0FA63D6F", hash_generated_method = "82CFEF2464E8E7402B7AAB9BAD1863C6")
    public final long readLong() throws IOException {
        readFully(scratch, 0, SizeOf.LONG);
        long var9F6710AAE72C6645C9CB5D9BAF2C5E79_414803805 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1152758740 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1152758740;
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.LONG);
        //return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.970 -0400", hash_original_method = "C93410329A523BCD2A1636A4AEB3409A", hash_generated_method = "AC18F15478C88DE8D204598BB3924063")
    public final short readShort() throws IOException {
        readFully(scratch, 0, SizeOf.SHORT);
        short var007DE4DE11DFBCEFBB55FC3C89A2F231_669279467 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
        short var4F09DAA9D95BCB166A302407A0E0BABE_384984101 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_384984101;
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.SHORT);
        //return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.971 -0400", hash_original_method = "AF5E7921B4B2187E0041EFA801E04DA5", hash_generated_method = "A740703F49587132CBE8945E9F4E80A4")
    public final int readUnsignedByte() throws IOException {
        int temp = this.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387216916 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1387216916;
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.972 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "47CEB587082682135BE13EECD2F026FF")
    public final int readUnsignedShort() throws IOException {
        int var80645AD98CDAD0EE0FB3459E3825971C_1046931841 = (((int) readShort()) & 0xffff);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504723903 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1504723903;
        // ---------- Original Method ----------
        //return ((int) readShort()) & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.975 -0400", hash_original_method = "1E6F905958EDDE8569C0995497961028", hash_generated_method = "4E49B8FBCDA2E5E486A48D2ECFB8A83B")
    public final String readUTF() throws IOException {
        String varB4EAC82CA7396A68D541C85D26508E83_1779659117 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_575430023 = null; //Variable for return #2
        int utfSize = readUnsignedShort();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1779659117 = "";
        } //End block
        byte[] buf = new byte[utfSize];
        {
            boolean varCC708F7E031AEDABCA9DFF40A76762B8_557819228 = (read(buf, 0, buf.length) != buf.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_575430023 = ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize);
        String varA7E53CE21691AB073D9660D615818899_2063686772; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2063686772 = varB4EAC82CA7396A68D541C85D26508E83_1779659117;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2063686772 = varB4EAC82CA7396A68D541C85D26508E83_575430023;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2063686772.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2063686772;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.977 -0400", hash_original_method = "92812216A189B62C22C36FA4ABFCEF90", hash_generated_method = "1EDCC76EAAB68A14E3C73C2F91B5DC47")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.978 -0400", hash_original_method = "385EF87B8915AB37CD3540061C92256B", hash_generated_method = "BF7AEF5C171493C5A1C5613BC8D934D9")
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
        long filePointer = getFilePointer();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.979 -0400", hash_original_method = "FB9C2E97D200EE03574ADD76D56D23DD", hash_generated_method = "E845E837176EB08D541065FAF4716E3E")
    public int skipBytes(int count) throws IOException {
        {
            long currentPos = getFilePointer();
            long eof = length();
            int newCount = (int) ((currentPos + count > eof) ? eof - currentPos : count);//DSFIXME:  CODE0008: Nested ternary operator in expression
            seek(currentPos + newCount);
        } //End block
        addTaint(count);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528934211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528934211;
        // ---------- Original Method ----------
        //if (count > 0) {
            //long currentPos = getFilePointer(), eof = length();
            //int newCount = (int) ((currentPos + count > eof) ? eof - currentPos : count);
            //seek(currentPos + newCount);
            //return newCount;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.980 -0400", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "9CF54F5514EB45305F74BC43AC7A8B7B")
    public void write(byte[] buffer) throws IOException {
        write(buffer, 0, buffer.length);
        addTaint(buffer[0]);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.980 -0400", hash_original_method = "35FA4EEB101513E91F640D0BB99E182F", hash_generated_method = "8287C1A4E77452B86B1A6636CB10DD0B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.981 -0400", hash_original_method = "9AECC3BD7576DA9A6BE139AE80679C12", hash_generated_method = "9FAA380C1F42D314AD87185ABF65B775")
    public void write(int oneByte) throws IOException {
        scratch[0] = (byte) (oneByte & 0xff);
        write(scratch, 0, 1);
        // ---------- Original Method ----------
        //scratch[0] = (byte) (oneByte & 0xff);
        //write(scratch, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.981 -0400", hash_original_method = "9F118A4D5206A4234B8C15F22340D26C", hash_generated_method = "F960884DA0D70FA85EFF44FE71615754")
    public final void writeBoolean(boolean val) throws IOException {
        write(val ? 1 : 0);
        addTaint(val);
        // ---------- Original Method ----------
        //write(val ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.981 -0400", hash_original_method = "B252FC199353C3326913DC87EC8ACD0F", hash_generated_method = "358B6869D9197862EB33BA05E9BB4712")
    public final void writeByte(int val) throws IOException {
        write(val & 0xFF);
        addTaint(val);
        // ---------- Original Method ----------
        //write(val & 0xFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.982 -0400", hash_original_method = "EECBC8862767167AF0CABDC3594E6347", hash_generated_method = "4DA565FC306AC607FC5F76BB881A156A")
    public final void writeBytes(String str) throws IOException {
        byte[] bytes = new byte[str.length()];
        {
            int index = 0;
            boolean varA02C1B1CDA6C37943246730579D9D4AA_458768576 = (index < str.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.983 -0400", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "DD808167E0A0638EDB5F24AB5B6A989B")
    public final void writeChar(int val) throws IOException {
        writeShort(val);
        addTaint(val);
        // ---------- Original Method ----------
        //writeShort(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.983 -0400", hash_original_method = "C993D359026F2BBBDD097DA5FA69EA70", hash_generated_method = "40C828827D2C23B332B7B0C74D7D5610")
    public final void writeChars(String str) throws IOException {
        write(str.getBytes("UTF-16BE"));
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //write(str.getBytes("UTF-16BE"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.984 -0400", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "3DBCD431F669B61280931467601A41C3")
    public final void writeDouble(double val) throws IOException {
        writeLong(Double.doubleToLongBits(val));
        addTaint(val);
        // ---------- Original Method ----------
        //writeLong(Double.doubleToLongBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.984 -0400", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "23BFEF07C67385B17FCF73AD5AC52B24")
    public final void writeFloat(float val) throws IOException {
        writeInt(Float.floatToIntBits(val));
        addTaint(val);
        // ---------- Original Method ----------
        //writeInt(Float.floatToIntBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.985 -0400", hash_original_method = "37CBB7B1E5121DA5847923CB75DB4FD7", hash_generated_method = "B72C4BFD7AF3D937976228E85AFBE2DD")
    public final void writeInt(int val) throws IOException {
        Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.INT);
        addTaint(val);
        // ---------- Original Method ----------
        //Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.986 -0400", hash_original_method = "7B3E247666A6F3E05280E703124B5A4E", hash_generated_method = "AC936AFC0AE896E6890B4B63CBE3BE69")
    public final void writeLong(long val) throws IOException {
        Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.LONG);
        addTaint(val);
        // ---------- Original Method ----------
        //Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.986 -0400", hash_original_method = "64B98C2F1C9F8A49F0516D9D78465522", hash_generated_method = "83B73BEC87F40B88F764696ABE144F8A")
    public final void writeShort(int val) throws IOException {
        Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.SHORT);
        addTaint(val);
        // ---------- Original Method ----------
        //Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:48.986 -0400", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "D46F217503ADED3A09B4FFB1E313F623")
    public final void writeUTF(String str) throws IOException {
        write(ModifiedUtf8.encode(str));
        addTaint(str.getTaint());
        // ---------- Original Method ----------
        //write(ModifiedUtf8.encode(str));
    }

    
}

