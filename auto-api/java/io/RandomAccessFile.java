package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private FileDescriptor fd;
    private boolean syncMetadata = false;
    private FileChannel channel;
    private int mode;
    private final CloseGuard guard = CloseGuard.get();
    private final byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.676 -0400", hash_original_method = "C0E3F3B9285851822189430A61815E02", hash_generated_method = "D2E33B34DB65D25DCE47183D61C2D5E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RandomAccessFile(File file, String mode) throws FileNotFoundException {
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(mode);
        int flags;
        {
            boolean var31FE68E20085E76C60E612103E1A721B_65321300 = (mode.equals("r"));
            {
                flags = O_RDONLY;
            } //End block
            {
                boolean varC150FED3A23211AE0FE87A89CE48B078_56568868 = (mode.equals("rw") || mode.equals("rws") || mode.equals("rwd"));
                {
                    flags = O_RDWR | O_CREAT;
                    {
                        boolean varE03788F9BE4713BC79E72BE8EDB25E88_2145676160 = (mode.equals("rws"));
                        {
                            syncMetadata = true;
                        } //End block
                        {
                            boolean var01F727A511D8361A7B723843053429C0_253725269 = (mode.equals("rwd"));
                            {
                                flags |= O_SYNC;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
                if(DroidSafeAndroidRuntime.control) {
                    throw new IllegalArgumentException("Invalid mode: " + mode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.676 -0400", hash_original_method = "1B258B17ED328999F6B21E961C189B35", hash_generated_method = "648160421839A088B799F62308EC9BA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RandomAccessFile(String fileName, String mode) throws FileNotFoundException {
        this(new File(fileName), mode);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.676 -0400", hash_original_method = "884D49058FBF3FAB457C152EAAE74126", hash_generated_method = "9DCB9C4CAC1F8A4FEF43CAE117A936EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        guard.close();
        {
            {
                boolean var360D1941DE5CB2B0EB1B1C57F7580CBA_1278178770 = (channel != null && channel.isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.676 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "648B7AB6646E68C24A879D2C00314B10")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.676 -0400", hash_original_method = "C91B0C3B79D457313F842097EE5F90EE", hash_generated_method = "BCEBB646F0A0EBB4442E38E28047FB3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final synchronized FileChannel getChannel() {
        {
            channel = NioUtils.newFileChannel(this, fd, mode);
        } //End block
        return (FileChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if(channel == null) {
            //channel = NioUtils.newFileChannel(this, fd, mode);
        //}
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.676 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "5EEBEE949DA2AB28C9F4160248A81D9F")
    @DSModeled(DSC.SAFE)
    public final FileDescriptor getFD() throws IOException {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.676 -0400", hash_original_method = "BF89D60C39AB56A10CD4BF202DEE6E59", hash_generated_method = "8E31653A3BEFF7371BC8397D3F3CEE21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getFilePointer() throws IOException {
        try 
        {
            long varF0C05ECAF241A024A616B548A1469DB9_1525814684 = (Libcore.os.lseek(fd, 0L, SEEK_CUR));
        } //End block
        catch (ErrnoException errnoException)
        {
            throw errnoException.rethrowAsIOException();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.676 -0400", hash_original_method = "E8687801225ADA3B0E63B61937B0020C", hash_generated_method = "AF2CB6CFFABC6492C85FEC7F6BDA1367")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long length() throws IOException {
        try 
        {
            long var2D9D0231F90D97A868E782013621466D_1551067543 = (Libcore.os.fstat(fd).st_size);
        } //End block
        catch (ErrnoException errnoException)
        {
            throw errnoException.rethrowAsIOException();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.fstat(fd).st_size;
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.676 -0400", hash_original_method = "9CBC8BBFD7044A0BC3A194777FBBD2CA", hash_generated_method = "2C59CD700D6E4E337915C260A11FC19D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read() throws IOException {
        {
            boolean var5AE8D1125A90BB891EE77B81D048DDF5_588182331 = ((read(scratch, 0, 1) != -1));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (read(scratch, 0, 1) != -1) ? scratch[0] & 0xff : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.676 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "D5D84DD5C898F731F42D6829E220CCFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer);
        int var6FC2792F895D13BB16201EFCBA1330E5_1878574132 = (read(buffer, 0, buffer.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return read(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "6129CA45F1AB270C51C40CD5D0391C2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(byteCount);
        int varA119A82C704C62A3513B82F79810D9CB_1414076535 = (IoBridge.read(fd, buffer, byteOffset, byteCount));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return IoBridge.read(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "50A11AE3C5EDA3B4603E1C2204F22ED8", hash_generated_method = "2E5F7C0D93BBA9F480B9E4AF1A4478BC")
    @DSModeled(DSC.SAFE)
    public final boolean readBoolean() throws IOException {
        int temp;
        temp = this.read();
        if(DroidSafeAndroidRuntime.control) {
            throw new EOFException();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "2659119ED4E9182341F4E2CF2510ACC4", hash_generated_method = "25DC02ECE2B225D7A253CCF85C37B76A")
    @DSModeled(DSC.SAFE)
    public final byte readByte() throws IOException {
        int temp;
        temp = this.read();
        if(DroidSafeAndroidRuntime.control) {
            throw new EOFException();
        } //End block
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return (byte) temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "8CD02BB94AC204B3FA7A867D7CEBE1D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char readChar() throws IOException {
        char varF2ACC106D91692A1DB07375484A6C29E_275243182 = ((char) readShort());
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return (char) readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "19A352237D1F9DB07F3A575D702D2873")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final double readDouble() throws IOException {
        double var3292A685AD9C8EB2CF3ABF2B88C345AA_1320282579 = (Double.longBitsToDouble(readLong()));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(readLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "592E32590BD28F4BFD9D4003244C24F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float readFloat() throws IOException {
        float var6656A3EBF72C98EFC9F149CC98AAD604_1477065632 = (Float.intBitsToFloat(readInt()));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "C1CBB04FBF7269F52C32DF32F806BDA7")
    @DSModeled(DSC.SAFE)
    public final void readFully(byte[] dst) throws IOException {
        dsTaint.addTaint(dst);
        readFully(dst, 0, dst.length);
        // ---------- Original Method ----------
        //readFully(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "35386938706C6610A66A6C02D11FE342", hash_generated_method = "20DD06CEFFF8E2230E832D7CED60297A")
    @DSModeled(DSC.SAFE)
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dst);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(dst.length, offset, byteCount);
        {
            int result;
            result = read(dst, offset, byteCount);
            if(DroidSafeAndroidRuntime.control) {
                throw new EOFException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "623A6326FEE6BEAC4C71D9EAB23D5BE9", hash_generated_method = "BAEBA62F3400EAA7318CAF46E1457064")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readInt() throws IOException {
        readFully(scratch, 0, SizeOf.INT);
        int varB097092D008CB2C0CB75F2D5D42B4BD8_663968124 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.INT);
        //return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "A3561FB7999FC54AB0AB272B825D1BA9", hash_generated_method = "F8B003288A44EADF5F782244EFE33DEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String readLine() throws IOException {
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
            {
                boolean varEE785E4857F27CB2802B4138E78A0F4F_1101768474 = (line.length() != 0);
                Object var17A15FA5FFB6049E90AD08C06406E86F_921086603 = (line.toString());
            } //End flattened ternary
            //End case -1 
            //Begin case (byte) '\r' 
            {
                seek(unreadPosition);
                String var17A15FA5FFB6049E90AD08C06406E86F_1618076356 = (line.toString());
            } //End block
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            foundTerminator = true;
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            unreadPosition = getFilePointer();
            //End case (byte) '\r' 
            //Begin case (byte) '\n' 
            String var1EC93FDCAE6CEDB0F6DB29587930777B_1607254820 = (line.toString());
            //End case (byte) '\n' 
            //Begin case default 
            {
                seek(unreadPosition);
                String var17A15FA5FFB6049E90AD08C06406E86F_1847407069 = (line.toString());
            } //End block
            //End case default 
            //Begin case default 
            line.append((char) nextByte);
            //End case default 
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "469514DB0DA90571D02A531A0FA63D6F", hash_generated_method = "0C0E5C7C70131706262387750EA69A87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long readLong() throws IOException {
        readFully(scratch, 0, SizeOf.LONG);
        long var9F6710AAE72C6645C9CB5D9BAF2C5E79_208396310 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.LONG);
        //return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.677 -0400", hash_original_method = "C93410329A523BCD2A1636A4AEB3409A", hash_generated_method = "5C1EF6206714BC03A579E62137CDEDB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final short readShort() throws IOException {
        readFully(scratch, 0, SizeOf.SHORT);
        short var007DE4DE11DFBCEFBB55FC3C89A2F231_892117405 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.SHORT);
        //return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "AF5E7921B4B2187E0041EFA801E04DA5", hash_generated_method = "A4A36009C839D8B979A6A6A8FBCDE082")
    @DSModeled(DSC.SAFE)
    public final int readUnsignedByte() throws IOException {
        int temp;
        temp = this.read();
        if(DroidSafeAndroidRuntime.control) {
            throw new EOFException();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "4035494E951FB907A5E9F75AC48BCAB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readUnsignedShort() throws IOException {
        int var80645AD98CDAD0EE0FB3459E3825971C_576372472 = (((int) readShort()) & 0xffff);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((int) readShort()) & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "1E6F905958EDDE8569C0995497961028", hash_generated_method = "FC741416BC6C87284C395055FAC43E5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String readUTF() throws IOException {
        int utfSize;
        utfSize = readUnsignedShort();
        byte[] buf;
        buf = new byte[utfSize];
        {
            boolean varCC708F7E031AEDABCA9DFF40A76762B8_582700568 = (read(buf, 0, buf.length) != buf.length);
            if(DroidSafeAndroidRuntime.control) {
                throw new EOFException();
            } //End block
        } //End collapsed parenthetic
        String varAD1A050819E15DAA49394A2885C5D1A9_648266335 = (ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "92812216A189B62C22C36FA4ABFCEF90", hash_generated_method = "2BE5E046440FC8DDC9D720E0ED77FBF0")
    @DSModeled(DSC.SAFE)
    public void seek(long offset) throws IOException {
        dsTaint.addTaint(offset);
        if(DroidSafeAndroidRuntime.control) {
            throw new IOException("offset < 0: " + offset);
        } //End block
        try 
        {
            Libcore.os.lseek(fd, offset, SEEK_SET);
        } //End block
        catch (ErrnoException errnoException)
        {
            throw errnoException.rethrowAsIOException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "385EF87B8915AB37CD3540061C92256B", hash_generated_method = "4A82C5746185E8025A8DB6A7E68CAE2F")
    @DSModeled(DSC.SAFE)
    public void setLength(long newLength) throws IOException {
        dsTaint.addTaint(newLength);
        if(DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("newLength < 0");
        } //End block
        try 
        {
            Libcore.os.ftruncate(fd, newLength);
        } //End block
        catch (ErrnoException errnoException)
        {
            throw errnoException.rethrowAsIOException();
        } //End block
        long filePointer;
        filePointer = getFilePointer();
        {
            seek(newLength);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "FB9C2E97D200EE03574ADD76D56D23DD", hash_generated_method = "65E55DEC45254B42F1BB2AE7ABF6927A")
    @DSModeled(DSC.SAFE)
    public int skipBytes(int count) throws IOException {
        dsTaint.addTaint(count);
        {
            long currentPos, eof;
            currentPos = getFilePointer();
            eof = length();
            int newCount;
            newCount = (int) ((currentPos + count > eof) ? eof - currentPos : count);//DSFIXME:  CODE0008: Nested ternary operator in expression
            seek(currentPos + newCount);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (count > 0) {
            //long currentPos = getFilePointer(), eof = length();
            //int newCount = (int) ((currentPos + count > eof) ? eof - currentPos : count);
            //seek(currentPos + newCount);
            //return newCount;
        //}
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "BD4CBDB7F6953C5B04B1698E514A1872")
    @DSModeled(DSC.SAFE)
    public void write(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer);
        write(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "35FA4EEB101513E91F640D0BB99E182F", hash_generated_method = "3F8EB005722E55A9A1394F7D5EB9047A")
    @DSModeled(DSC.SAFE)
    public void write(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        dsTaint.addTaint(buffer);
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(byteCount);
        IoBridge.write(fd, buffer, byteOffset, byteCount);
        {
            fd.sync();
        } //End block
        // ---------- Original Method ----------
        //IoBridge.write(fd, buffer, byteOffset, byteCount);
        //if (syncMetadata) {
            //fd.sync();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "9AECC3BD7576DA9A6BE139AE80679C12", hash_generated_method = "C4548D2BF91DD27B488C8B852CF33A76")
    @DSModeled(DSC.SAFE)
    public void write(int oneByte) throws IOException {
        dsTaint.addTaint(oneByte);
        scratch[0] = (byte) (oneByte & 0xff);
        write(scratch, 0, 1);
        // ---------- Original Method ----------
        //scratch[0] = (byte) (oneByte & 0xff);
        //write(scratch, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "9F118A4D5206A4234B8C15F22340D26C", hash_generated_method = "9EF29B0D92E4FF189D240B6CCB7B0ED8")
    @DSModeled(DSC.SAFE)
    public final void writeBoolean(boolean val) throws IOException {
        dsTaint.addTaint(val);
        write(val ? 1 : 0);
        // ---------- Original Method ----------
        //write(val ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "B252FC199353C3326913DC87EC8ACD0F", hash_generated_method = "D4DCCD27482431D7E0F5B6E21E9508F5")
    @DSModeled(DSC.SAFE)
    public final void writeByte(int val) throws IOException {
        dsTaint.addTaint(val);
        write(val & 0xFF);
        // ---------- Original Method ----------
        //write(val & 0xFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.678 -0400", hash_original_method = "EECBC8862767167AF0CABDC3594E6347", hash_generated_method = "3038311B600FB8E8FBFE22D5A767DE45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeBytes(String str) throws IOException {
        dsTaint.addTaint(str);
        byte[] bytes;
        bytes = new byte[str.length()];
        {
            int index;
            index = 0;
            boolean varA02C1B1CDA6C37943246730579D9D4AA_93177257 = (index < str.length());
            {
                bytes[index] = (byte) (str.charAt(index) & 0xFF);
            } //End block
        } //End collapsed parenthetic
        write(bytes);
        // ---------- Original Method ----------
        //byte[] bytes = new byte[str.length()];
        //for (int index = 0; index < str.length(); index++) {
            //bytes[index] = (byte) (str.charAt(index) & 0xFF);
        //}
        //write(bytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.679 -0400", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "12C19891F61CFBC3E746AD0E6AEE8AE8")
    @DSModeled(DSC.SAFE)
    public final void writeChar(int val) throws IOException {
        dsTaint.addTaint(val);
        writeShort(val);
        // ---------- Original Method ----------
        //writeShort(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.679 -0400", hash_original_method = "C993D359026F2BBBDD097DA5FA69EA70", hash_generated_method = "D528AC8BBF1B5C71C8F81E4FCA9425A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeChars(String str) throws IOException {
        dsTaint.addTaint(str);
        write(str.getBytes("UTF-16BE"));
        // ---------- Original Method ----------
        //write(str.getBytes("UTF-16BE"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.679 -0400", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "D1EEB7713D6304552B5377F83A84DF41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeDouble(double val) throws IOException {
        dsTaint.addTaint(val);
        writeLong(Double.doubleToLongBits(val));
        // ---------- Original Method ----------
        //writeLong(Double.doubleToLongBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.679 -0400", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "66AE7CFE9293D88FB6E5F68B9F3CB17D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeFloat(float val) throws IOException {
        dsTaint.addTaint(val);
        writeInt(Float.floatToIntBits(val));
        // ---------- Original Method ----------
        //writeInt(Float.floatToIntBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.679 -0400", hash_original_method = "37CBB7B1E5121DA5847923CB75DB4FD7", hash_generated_method = "0EC2724B3B8D33C023F849F667B5C775")
    @DSModeled(DSC.SAFE)
    public final void writeInt(int val) throws IOException {
        dsTaint.addTaint(val);
        Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.INT);
        // ---------- Original Method ----------
        //Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.679 -0400", hash_original_method = "7B3E247666A6F3E05280E703124B5A4E", hash_generated_method = "375C82F24EF659DCA624F02E6FDD58B9")
    @DSModeled(DSC.SAFE)
    public final void writeLong(long val) throws IOException {
        dsTaint.addTaint(val);
        Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.LONG);
        // ---------- Original Method ----------
        //Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.679 -0400", hash_original_method = "64B98C2F1C9F8A49F0516D9D78465522", hash_generated_method = "6159F2218F5CB5E9728799E51551E9F8")
    @DSModeled(DSC.SAFE)
    public final void writeShort(int val) throws IOException {
        dsTaint.addTaint(val);
        Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.SHORT);
        // ---------- Original Method ----------
        //Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.679 -0400", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "7EB3DC8AD349F52AB6B902F2F6AA463E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeUTF(String str) throws IOException {
        dsTaint.addTaint(str);
        write(ModifiedUtf8.encode(str));
        // ---------- Original Method ----------
        //write(ModifiedUtf8.encode(str));
    }

    
}


