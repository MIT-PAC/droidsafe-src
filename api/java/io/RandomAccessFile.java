package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.469 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "B11DAE17AB1D35227E8CB61CED7BC01D")

    private FileDescriptor fd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.469 -0400", hash_original_field = "85486C53545A8169C1E28251CF0C4807", hash_generated_field = "3B32EAA0CEEDC75E8106E9EDC5E4B7B8")

    private boolean syncMetadata = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.469 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.469 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "D6093ADED541044A414FEED81979F5E2")

    private int mode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.469 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.469 -0400", hash_original_field = "239E1A8E5C884A724F64EE44024C15F5", hash_generated_field = "0DF1829DEBB6EA0D971CFA5BDB181CF9")

    private final byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.471 -0400", hash_original_method = "C0E3F3B9285851822189430A61815E02", hash_generated_method = "465E9A8CDD50C3016093326C69210E37")
    public  RandomAccessFile(File file, String mode) throws FileNotFoundException {
        int flags;
        if(mode.equals("r"))        
        {
            flags = O_RDONLY;
        } //End block
        else
        if(mode.equals("rw") || mode.equals("rws") || mode.equals("rwd"))        
        {
            flags = O_RDWR | O_CREAT;
            if(mode.equals("rws"))            
            {
                syncMetadata = true;
            } //End block
            else
            if(mode.equals("rwd"))            
            {
                flags |= O_SYNC;
            } //End block
        } //End block
        else
        {
            IllegalArgumentException varAC008075F2AF1E344EBFEE8ADEC436B5_763274417 = new IllegalArgumentException("Invalid mode: " + mode);
            varAC008075F2AF1E344EBFEE8ADEC436B5_763274417.addTaint(taint);
            throw varAC008075F2AF1E344EBFEE8ADEC436B5_763274417;
        } //End block
        this.mode = flags;
        this.fd = IoBridge.open(file.getAbsolutePath(), flags);
        if(syncMetadata)        
        {
            try 
            {
                fd.sync();
            } //End block
            catch (IOException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.472 -0400", hash_original_method = "1B258B17ED328999F6B21E961C189B35", hash_generated_method = "096D189D3D240EF0694FBE4643512F81")
    public  RandomAccessFile(String fileName, String mode) throws FileNotFoundException {
        this(new File(fileName), mode);
        addTaint(mode.getTaint());
        addTaint(fileName.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.473 -0400", hash_original_method = "884D49058FBF3FAB457C152EAAE74126", hash_generated_method = "C4477A007885E636F86C086FE42B2A22")
    public void close() throws IOException {
        guard.close();
        synchronized
(this)        {
            if(channel != null && channel.isOpen())            
            {
                channel.close();
                channel = null;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.473 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "271B01A0C286411ADC3A779686EF67E4")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            if(guard != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.474 -0400", hash_original_method = "C91B0C3B79D457313F842097EE5F90EE", hash_generated_method = "F0CDB859DEA9F49269FEB4C4C14AA422")
    public final synchronized FileChannel getChannel() {
        if(channel == null)        
        {
            channel = NioUtils.newFileChannel(this, fd, mode);
        } //End block
FileChannel var99BA3483FD74E36EACD435CEE6BD5D6F_946307640 =         channel;
        var99BA3483FD74E36EACD435CEE6BD5D6F_946307640.addTaint(taint);
        return var99BA3483FD74E36EACD435CEE6BD5D6F_946307640;
        // ---------- Original Method ----------
        //if(channel == null) {
            //channel = NioUtils.newFileChannel(this, fd, mode);
        //}
        //return channel;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.474 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "CF291064A1C8A11D457B382859D1F94B")
    public final FileDescriptor getFD() throws IOException {
FileDescriptor var020F72FC5D1BB0511CAD11CC0AA674A0_234051605 =         fd;
        var020F72FC5D1BB0511CAD11CC0AA674A0_234051605.addTaint(taint);
        return var020F72FC5D1BB0511CAD11CC0AA674A0_234051605;
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.483 -0400", hash_original_method = "BF89D60C39AB56A10CD4BF202DEE6E59", hash_generated_method = "D48D8E8B61431FA351150FD7B9FB5690")
    public long getFilePointer() throws IOException {
        try 
        {
            long var7BC510F6F7CB14449C552BCB6CAF281B_174001317 = (Libcore.os.lseek(fd, 0L, SEEK_CUR));
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_250941164 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_250941164;
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_2019343311 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_2019343311.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_2019343311;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.489 -0400", hash_original_method = "E8687801225ADA3B0E63B61937B0020C", hash_generated_method = "2CEF761C457B6E3083191EE27F5B6D33")
    public long length() throws IOException {
        try 
        {
            long varE497182731DBBCFBFD01D5C3B5A54B92_1168579252 = (Libcore.os.fstat(fd).st_size);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_839867995 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_839867995;
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_1460520403 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_1460520403.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_1460520403;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.fstat(fd).st_size;
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.490 -0400", hash_original_method = "9CBC8BBFD7044A0BC3A194777FBBD2CA", hash_generated_method = "203D89E0F1C924997F800B8F0E91183E")
    public int read() throws IOException {
        int varB322769BC0F2A0323E6473E85B782F19_1738404873 = ((read(scratch, 0, 1) != -1) ? scratch[0] & 0xff : -1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427459701 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427459701;
        // ---------- Original Method ----------
        //return (read(scratch, 0, 1) != -1) ? scratch[0] & 0xff : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.490 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "558363FB0EA6949E423A6166292C2397")
    public int read(byte[] buffer) throws IOException {
        addTaint(buffer[0]);
        int varB17F7FC0C34BA0A2828AFE480EE84868_1237510704 = (read(buffer, 0, buffer.length));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82711187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_82711187;
        // ---------- Original Method ----------
        //return read(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.491 -0400", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "5B2A004C641F54DBC34878FE4AF3966F")
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(buffer[0]);
        int var515005EC72FBFD1EBFD0E3FF9751DEEE_1712426997 = (IoBridge.read(fd, buffer, byteOffset, byteCount));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157506301 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1157506301;
        // ---------- Original Method ----------
        //return IoBridge.read(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.491 -0400", hash_original_method = "50A11AE3C5EDA3B4603E1C2204F22ED8", hash_generated_method = "2CA7418DED58B3E92B0150CC4DDB97B6")
    public final boolean readBoolean() throws IOException {
        int temp = this.read();
        if(temp < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_140421599 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_140421599.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_140421599;
        } //End block
        boolean var581071D2E1ACA721FA204A220D24D3E5_1048759095 = (temp != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461953359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_461953359;
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.492 -0400", hash_original_method = "2659119ED4E9182341F4E2CF2510ACC4", hash_generated_method = "7D5B1D552A41ACE901FC1CA2B347A6D2")
    public final byte readByte() throws IOException {
        int temp = this.read();
        if(temp < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_1691779371 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_1691779371.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_1691779371;
        } //End block
        byte varEB0C37FB3D2A4D56EFEF536C0C588373_2053779258 = ((byte) temp);
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1595845682 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1595845682;
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return (byte) temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.492 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "3D48D6AA2288581F298EBE607DCF2488")
    public final char readChar() throws IOException {
        char varD2B9D0AC7E6CAD4B64D448E3DC4EE790_249109450 = ((char) readShort());
                char varA87DEB01C5F539E6BDA34829C8EF2368_1669229802 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1669229802;
        // ---------- Original Method ----------
        //return (char) readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.493 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "7AA255D739A489C7087751AC0C7671FF")
    public final double readDouble() throws IOException {
        double varB44FB75D2A60D6225B161B58EE8BE0EE_521208649 = (Double.longBitsToDouble(readLong()));
                double varE8CD7DA078A86726031AD64F35F5A6C0_2055388223 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_2055388223;
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(readLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.493 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "A74AABD0475ABD60B5C0CFDD1BDA8884")
    public final float readFloat() throws IOException {
        float var61F55322990BB97833DB081A7753B25B_679451286 = (Float.intBitsToFloat(readInt()));
                float var546ADE640B6EDFBC8A086EF31347E768_105041351 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_105041351;
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.493 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "2444EFC16C3B6FEB5364E7D874F2DA2F")
    public final void readFully(byte[] dst) throws IOException {
        addTaint(dst[0]);
        readFully(dst, 0, dst.length);
        // ---------- Original Method ----------
        //readFully(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.494 -0400", hash_original_method = "35386938706C6610A66A6C02D11FE342", hash_generated_method = "C776764C30EF9B0BF7646E5F7010372C")
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(offset);
        addTaint(dst[0]);
        Arrays.checkOffsetAndCount(dst.length, offset, byteCount);
        while
(byteCount > 0)        
        {
            int result = read(dst, offset, byteCount);
            if(result < 0)            
            {
                EOFException var0239D63DB748BB20D119EB36D6D1C384_345301460 = new EOFException();
                var0239D63DB748BB20D119EB36D6D1C384_345301460.addTaint(taint);
                throw var0239D63DB748BB20D119EB36D6D1C384_345301460;
            } //End block
            offset += result;
            byteCount -= result;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.494 -0400", hash_original_method = "623A6326FEE6BEAC4C71D9EAB23D5BE9", hash_generated_method = "2C5038C59CE130787C0FA6B5BFD4E89A")
    public final int readInt() throws IOException {
        readFully(scratch, 0, SizeOf.INT);
        int var7C922A9B161AE4D77245C27862C5A0B3_128982881 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451738052 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451738052;
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.INT);
        //return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.495 -0400", hash_original_method = "A3561FB7999FC54AB0AB272B825D1BA9", hash_generated_method = "4D19A44D79E24A764E462C54A80954B7")
    public final String readLine() throws IOException {
        StringBuilder line = new StringBuilder(80);
        boolean foundTerminator = false;
        long unreadPosition = 0;
        while
(true)        
        {
            int nextByte = read();
switch(nextByte){
            case -1:
String var8CDD6AC64A89AABB1EE2F22C095CB3B3_1081990981 =             line.length() != 0 ? line.toString() : null;
            var8CDD6AC64A89AABB1EE2F22C095CB3B3_1081990981.addTaint(taint);
            return var8CDD6AC64A89AABB1EE2F22C095CB3B3_1081990981;
            case (byte) '\r':
            if(foundTerminator)            
            {
                seek(unreadPosition);
String var212D8FC412CCB2BE0F33E17280622756_203061324 =                 line.toString();
                var212D8FC412CCB2BE0F33E17280622756_203061324.addTaint(taint);
                return var212D8FC412CCB2BE0F33E17280622756_203061324;
            } //End block
            foundTerminator = true;
            unreadPosition = getFilePointer();
            break;
            case (byte) '\n':
String var212D8FC412CCB2BE0F33E17280622756_1282119484 =             line.toString();
            var212D8FC412CCB2BE0F33E17280622756_1282119484.addTaint(taint);
            return var212D8FC412CCB2BE0F33E17280622756_1282119484;
            default:
            if(foundTerminator)            
            {
                seek(unreadPosition);
String var212D8FC412CCB2BE0F33E17280622756_1475211587 =                 line.toString();
                var212D8FC412CCB2BE0F33E17280622756_1475211587.addTaint(taint);
                return var212D8FC412CCB2BE0F33E17280622756_1475211587;
            } //End block
            line.append((char) nextByte);
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.496 -0400", hash_original_method = "469514DB0DA90571D02A531A0FA63D6F", hash_generated_method = "33478FC0F7957E9D4C4BA0564C3FAB4E")
    public final long readLong() throws IOException {
        readFully(scratch, 0, SizeOf.LONG);
        long var2D893E0C4B322812F3FC68288B698EF2_985020183 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1878049407 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1878049407;
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.LONG);
        //return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.496 -0400", hash_original_method = "C93410329A523BCD2A1636A4AEB3409A", hash_generated_method = "2B791DFBFAD6B6BE434472501078B16F")
    public final short readShort() throws IOException {
        readFully(scratch, 0, SizeOf.SHORT);
        short var5EF02BCDD6FDC20E2BA6E56CB7B1512F_1358147345 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
                short var4F09DAA9D95BCB166A302407A0E0BABE_2036639323 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2036639323;
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.SHORT);
        //return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.496 -0400", hash_original_method = "AF5E7921B4B2187E0041EFA801E04DA5", hash_generated_method = "F040E4C9F0C287F437544A41371C203C")
    public final int readUnsignedByte() throws IOException {
        int temp = this.read();
        if(temp < 0)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_1606020777 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_1606020777.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_1606020777;
        } //End block
        int var3D801AA532C1CEC3EE82D87A99FDF63F_1049583705 = (temp);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_569728312 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_569728312;
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.497 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "F9E37FB63AFEA6666A0A5B8B3FFAAE37")
    public final int readUnsignedShort() throws IOException {
        int var4535605AA0CDF96DAC5C016A8613FBB9_304665845 = (((int) readShort()) & 0xffff);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998749 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_998749;
        // ---------- Original Method ----------
        //return ((int) readShort()) & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.497 -0400", hash_original_method = "1E6F905958EDDE8569C0995497961028", hash_generated_method = "F1AEC0629471396EB842BB6B6EBE0899")
    public final String readUTF() throws IOException {
        int utfSize = readUnsignedShort();
        if(utfSize == 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_816803260 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_816803260.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_816803260;
        } //End block
        byte[] buf = new byte[utfSize];
        if(read(buf, 0, buf.length) != buf.length)        
        {
            EOFException var0239D63DB748BB20D119EB36D6D1C384_2076411484 = new EOFException();
            var0239D63DB748BB20D119EB36D6D1C384_2076411484.addTaint(taint);
            throw var0239D63DB748BB20D119EB36D6D1C384_2076411484;
        } //End block
String var53043956345A52F3FC57178FAAB3FC3C_1476127053 =         ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize);
        var53043956345A52F3FC57178FAAB3FC3C_1476127053.addTaint(taint);
        return var53043956345A52F3FC57178FAAB3FC3C_1476127053;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.513 -0400", hash_original_method = "92812216A189B62C22C36FA4ABFCEF90", hash_generated_method = "E426E9F52179D8F0A8BF4C5CB70DDCCA")
    public void seek(long offset) throws IOException {
        addTaint(offset);
        if(offset < 0)        
        {
            IOException var407EF712642876D92F7D5DA11E26AD4E_862083562 = new IOException("offset < 0: " + offset);
            var407EF712642876D92F7D5DA11E26AD4E_862083562.addTaint(taint);
            throw var407EF712642876D92F7D5DA11E26AD4E_862083562;
        } //End block
        try 
        {
            Libcore.os.lseek(fd, offset, SEEK_SET);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_484827602 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_484827602.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_484827602;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.528 -0400", hash_original_method = "385EF87B8915AB37CD3540061C92256B", hash_generated_method = "B4FA8E56C3C0C9F13B0D325141003EA5")
    public void setLength(long newLength) throws IOException {
        addTaint(newLength);
        if(newLength < 0)        
        {
            IllegalArgumentException var3467204E3D409283EC814D3A00236787_2731359 = new IllegalArgumentException("newLength < 0");
            var3467204E3D409283EC814D3A00236787_2731359.addTaint(taint);
            throw var3467204E3D409283EC814D3A00236787_2731359;
        } //End block
        try 
        {
            Libcore.os.ftruncate(fd, newLength);
        } //End block
        catch (ErrnoException errnoException)
        {
            java.io.IOException var533DBF3F7D78874DC97ED285C3BC3B22_172053256 = errnoException.rethrowAsIOException();
            var533DBF3F7D78874DC97ED285C3BC3B22_172053256.addTaint(taint);
            throw var533DBF3F7D78874DC97ED285C3BC3B22_172053256;
        } //End block
        long filePointer = getFilePointer();
        if(filePointer > newLength)        
        {
            seek(newLength);
        } //End block
        if(syncMetadata)        
        {
            fd.sync();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.530 -0400", hash_original_method = "FB9C2E97D200EE03574ADD76D56D23DD", hash_generated_method = "3EE13A7B1E167069DD5CA857580463CA")
    public int skipBytes(int count) throws IOException {
        addTaint(count);
        if(count > 0)        
        {
            long currentPos = getFilePointer();
            long eof = length();
            int newCount = (int) ((currentPos + count > eof) ? eof - currentPos : count);
            seek(currentPos + newCount);
            int varD6F9071E53BC7EFF4BFE39EBFCDDF1B1_520849967 = (newCount);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_304080784 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_304080784;
        } //End block
        int varCFCD208495D565EF66E7DFF9F98764DA_76086744 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_551248156 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_551248156;
        // ---------- Original Method ----------
        //if (count > 0) {
            //long currentPos = getFilePointer(), eof = length();
            //int newCount = (int) ((currentPos + count > eof) ? eof - currentPos : count);
            //seek(currentPos + newCount);
            //return newCount;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.530 -0400", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "C874A8F3DD1DC4618E30BFCFA3F99F15")
    public void write(byte[] buffer) throws IOException {
        addTaint(buffer[0]);
        write(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.531 -0400", hash_original_method = "35FA4EEB101513E91F640D0BB99E182F", hash_generated_method = "AE78FA9D0171A0DFF9BB6B0BD4B93EAF")
    public void write(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        addTaint(byteCount);
        addTaint(byteOffset);
        addTaint(buffer[0]);
        IoBridge.write(fd, buffer, byteOffset, byteCount);
        if(syncMetadata)        
        {
            fd.sync();
        } //End block
        // ---------- Original Method ----------
        //IoBridge.write(fd, buffer, byteOffset, byteCount);
        //if (syncMetadata) {
            //fd.sync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.532 -0400", hash_original_method = "9AECC3BD7576DA9A6BE139AE80679C12", hash_generated_method = "9FAA380C1F42D314AD87185ABF65B775")
    public void write(int oneByte) throws IOException {
        scratch[0] = (byte) (oneByte & 0xff);
        write(scratch, 0, 1);
        // ---------- Original Method ----------
        //scratch[0] = (byte) (oneByte & 0xff);
        //write(scratch, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.532 -0400", hash_original_method = "9F118A4D5206A4234B8C15F22340D26C", hash_generated_method = "F713F47288329EB16C788561DCB2ED01")
    public final void writeBoolean(boolean val) throws IOException {
        addTaint(val);
        write(val ? 1 : 0);
        // ---------- Original Method ----------
        //write(val ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.532 -0400", hash_original_method = "B252FC199353C3326913DC87EC8ACD0F", hash_generated_method = "6E4AD66DD62E241338EB34F0C56F2D10")
    public final void writeByte(int val) throws IOException {
        addTaint(val);
        write(val & 0xFF);
        // ---------- Original Method ----------
        //write(val & 0xFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.533 -0400", hash_original_method = "EECBC8862767167AF0CABDC3594E6347", hash_generated_method = "BB8DC60E64954AED2A53DF895EA04FFA")
    public final void writeBytes(String str) throws IOException {
        addTaint(str.getTaint());
        byte[] bytes = new byte[str.length()];
for(int index = 0;index < str.length();index++)
        {
            bytes[index] = (byte) (str.charAt(index) & 0xFF);
        } //End block
        write(bytes);
        // ---------- Original Method ----------
        //byte[] bytes = new byte[str.length()];
        //for (int index = 0; index < str.length(); index++) {
            //bytes[index] = (byte) (str.charAt(index) & 0xFF);
        //}
        //write(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.533 -0400", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "1E31D82E4CCC1BDCFE3108E1328D9F76")
    public final void writeChar(int val) throws IOException {
        addTaint(val);
        writeShort(val);
        // ---------- Original Method ----------
        //writeShort(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.534 -0400", hash_original_method = "C993D359026F2BBBDD097DA5FA69EA70", hash_generated_method = "274A2C12E321B1FB370B9AD0B1AD8A5A")
    public final void writeChars(String str) throws IOException {
        addTaint(str.getTaint());
        write(str.getBytes("UTF-16BE"));
        // ---------- Original Method ----------
        //write(str.getBytes("UTF-16BE"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.534 -0400", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "015AAB732EE3FB11ACE6574EE6EF9751")
    public final void writeDouble(double val) throws IOException {
        addTaint(val);
        writeLong(Double.doubleToLongBits(val));
        // ---------- Original Method ----------
        //writeLong(Double.doubleToLongBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.534 -0400", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "D86DCBAF1163AA0C9FB91F716904211F")
    public final void writeFloat(float val) throws IOException {
        addTaint(val);
        writeInt(Float.floatToIntBits(val));
        // ---------- Original Method ----------
        //writeInt(Float.floatToIntBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.535 -0400", hash_original_method = "37CBB7B1E5121DA5847923CB75DB4FD7", hash_generated_method = "24DB24A6E79CF9D78FF30AF32FA9AD2E")
    public final void writeInt(int val) throws IOException {
        addTaint(val);
        Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.INT);
        // ---------- Original Method ----------
        //Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.535 -0400", hash_original_method = "7B3E247666A6F3E05280E703124B5A4E", hash_generated_method = "D764EBAB4B72E3E18C93C32E36DA29B6")
    public final void writeLong(long val) throws IOException {
        addTaint(val);
        Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.LONG);
        // ---------- Original Method ----------
        //Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.535 -0400", hash_original_method = "64B98C2F1C9F8A49F0516D9D78465522", hash_generated_method = "FFCD855202B608BD07893E99F2A62094")
    public final void writeShort(int val) throws IOException {
        addTaint(val);
        Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.SHORT);
        // ---------- Original Method ----------
        //Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:45.535 -0400", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "F3F91246F6CBB42958111ACA3F00042D")
    public final void writeUTF(String str) throws IOException {
        addTaint(str.getTaint());
        write(ModifiedUtf8.encode(str));
        // ---------- Original Method ----------
        //write(ModifiedUtf8.encode(str));
    }

    
}

