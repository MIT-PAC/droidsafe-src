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
    private FileDescriptor fd;
    private boolean syncMetadata = false;
    private FileChannel channel;
    private int mode;
    private CloseGuard guard = CloseGuard.get();
    private byte[] scratch = new byte[8];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.256 -0400", hash_original_method = "C0E3F3B9285851822189430A61815E02", hash_generated_method = "B3703D04E910F7625D9DDEE3D14F6128")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RandomAccessFile(File file, String mode) throws FileNotFoundException {
        dsTaint.addTaint(file.dsTaint);
        dsTaint.addTaint(mode);
        int flags;
        {
            boolean var31FE68E20085E76C60E612103E1A721B_2036151489 = (mode.equals("r"));
            {
                flags = O_RDONLY;
            } //End block
            {
                boolean varC150FED3A23211AE0FE87A89CE48B078_636673558 = (mode.equals("rw") || mode.equals("rws") || mode.equals("rwd"));
                {
                    flags = O_RDWR | O_CREAT;
                    {
                        boolean varE03788F9BE4713BC79E72BE8EDB25E88_5247529 = (mode.equals("rws"));
                        {
                            syncMetadata = true;
                        } //End block
                        {
                            boolean var01F727A511D8361A7B723843053429C0_505084264 = (mode.equals("rwd"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.257 -0400", hash_original_method = "1B258B17ED328999F6B21E961C189B35", hash_generated_method = "FE7BB99500BF695D3C790B8515C160AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RandomAccessFile(String fileName, String mode) throws FileNotFoundException {
        this(new File(fileName), mode);
        dsTaint.addTaint(fileName);
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.257 -0400", hash_original_method = "884D49058FBF3FAB457C152EAAE74126", hash_generated_method = "5424CD864E7A5749223FD5595D3DB1C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        guard.close();
        {
            {
                boolean var360D1941DE5CB2B0EB1B1C57F7580CBA_946361375 = (channel != null && channel.isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.257 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.258 -0400", hash_original_method = "C91B0C3B79D457313F842097EE5F90EE", hash_generated_method = "C4D63259D4F103F1EFD374530494413A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.258 -0400", hash_original_method = "7178DA6FA6DD367775EBAB657FD1BDA0", hash_generated_method = "8A875069024AA7167BD98A27CFD5212E")
    @DSModeled(DSC.SAFE)
    public final FileDescriptor getFD() throws IOException {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.258 -0400", hash_original_method = "BF89D60C39AB56A10CD4BF202DEE6E59", hash_generated_method = "52D580D0C11F4056AC523E0E434DEC8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getFilePointer() throws IOException {
        try 
        {
            long varF0C05ECAF241A024A616B548A1469DB9_1931450264 = (Libcore.os.lseek(fd, 0L, SEEK_CUR));
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.lseek(fd, 0L, SEEK_CUR);
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.258 -0400", hash_original_method = "E8687801225ADA3B0E63B61937B0020C", hash_generated_method = "9CA57B884EDD04E979971B9F8C07C0D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long length() throws IOException {
        try 
        {
            long var2D9D0231F90D97A868E782013621466D_1262850444 = (Libcore.os.fstat(fd).st_size);
        } //End block
        catch (ErrnoException errnoException)
        {
            if (DroidSafeAndroidRuntime.control) throw errnoException.rethrowAsIOException();
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //try {
            //return Libcore.os.fstat(fd).st_size;
        //} catch (ErrnoException errnoException) {
            //throw errnoException.rethrowAsIOException();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.259 -0400", hash_original_method = "9CBC8BBFD7044A0BC3A194777FBBD2CA", hash_generated_method = "68CF64B788305A76B3C07AFA26080BBE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read() throws IOException {
        {
            boolean var5AE8D1125A90BB891EE77B81D048DDF5_832174288 = ((read(scratch, 0, 1) != -1));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (read(scratch, 0, 1) != -1) ? scratch[0] & 0xff : -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.259 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "214862F4B22543923FB8E725208AEE6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer[0]);
        int var6FC2792F895D13BB16201EFCBA1330E5_1742455690 = (read(buffer, 0, buffer.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return read(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.259 -0400", hash_original_method = "C5A4FB68C0A55B7975F40A4160EB1CAC", hash_generated_method = "DE273E094551A5BA5EF166F67ADA2DA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(byteCount);
        int varA119A82C704C62A3513B82F79810D9CB_1397770671 = (IoBridge.read(fd, buffer, byteOffset, byteCount));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return IoBridge.read(fd, buffer, byteOffset, byteCount);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.259 -0400", hash_original_method = "50A11AE3C5EDA3B4603E1C2204F22ED8", hash_generated_method = "23364142FF726E050ED2413B6C3DC477")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean readBoolean() throws IOException {
        int temp;
        temp = this.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.259 -0400", hash_original_method = "2659119ED4E9182341F4E2CF2510ACC4", hash_generated_method = "572793719D42BAA5793762527592D68F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte readByte() throws IOException {
        int temp;
        temp = this.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return (byte) temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.260 -0400", hash_original_method = "A44D11CC3BE0C88F3640C82011E315A3", hash_generated_method = "A254D58E7882B291CB11C3A32350CFA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final char readChar() throws IOException {
        char varF2ACC106D91692A1DB07375484A6C29E_2054851497 = ((char) readShort());
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //return (char) readShort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.260 -0400", hash_original_method = "D7A510C090532D6542CA33ECD805653E", hash_generated_method = "B79B436903D270EE84D8FDF68BC493F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final double readDouble() throws IOException {
        double var3292A685AD9C8EB2CF3ABF2B88C345AA_1003443199 = (Double.longBitsToDouble(readLong()));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return Double.longBitsToDouble(readLong());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.260 -0400", hash_original_method = "C7FD0C2698771DF8CC60A785DCC40BB4", hash_generated_method = "3FF1F2E5F1F9C89E499C0147BB69BE47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final float readFloat() throws IOException {
        float var6656A3EBF72C98EFC9F149CC98AAD604_698111515 = (Float.intBitsToFloat(readInt()));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return Float.intBitsToFloat(readInt());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.260 -0400", hash_original_method = "FD74F944C9A8F422C55042589648B5E4", hash_generated_method = "381A158999691B7214AD4191BE2969BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readFully(byte[] dst) throws IOException {
        dsTaint.addTaint(dst[0]);
        readFully(dst, 0, dst.length);
        // ---------- Original Method ----------
        //readFully(dst, 0, dst.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.260 -0400", hash_original_method = "35386938706C6610A66A6C02D11FE342", hash_generated_method = "DCF53FE648C62F55829DD8FB88C05507")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void readFully(byte[] dst, int offset, int byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(offset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.260 -0400", hash_original_method = "623A6326FEE6BEAC4C71D9EAB23D5BE9", hash_generated_method = "D4F9612B54133BFB2ACE9E8429C88972")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readInt() throws IOException {
        readFully(scratch, 0, SizeOf.INT);
        int varB097092D008CB2C0CB75F2D5D42B4BD8_1547331266 = (Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.INT);
        //return Memory.peekInt(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.261 -0400", hash_original_method = "A3561FB7999FC54AB0AB272B825D1BA9", hash_generated_method = "457638C1B81B56256943D4697C6D93EB")
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
                boolean varEE785E4857F27CB2802B4138E78A0F4F_2074525811 = (line.length() != 0);
                Object var17A15FA5FFB6049E90AD08C06406E86F_553092398 = (line.toString());
            } //End flattened ternary
            //End case -1 
            //Begin case (byte) '\r' 
            {
                seek(unreadPosition);
                String var17A15FA5FFB6049E90AD08C06406E86F_248519583 = (line.toString());
            } //End block
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            foundTerminator = true;
            //End case (byte) '\r' 
            //Begin case (byte) '\r' 
            unreadPosition = getFilePointer();
            //End case (byte) '\r' 
            //Begin case (byte) '\n' 
            String var1EC93FDCAE6CEDB0F6DB29587930777B_1814554033 = (line.toString());
            //End case (byte) '\n' 
            //Begin case default 
            {
                seek(unreadPosition);
                String var17A15FA5FFB6049E90AD08C06406E86F_1401476528 = (line.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.261 -0400", hash_original_method = "469514DB0DA90571D02A531A0FA63D6F", hash_generated_method = "4E1CBDDD540EFC8645213DF0098B2094")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final long readLong() throws IOException {
        readFully(scratch, 0, SizeOf.LONG);
        long var9F6710AAE72C6645C9CB5D9BAF2C5E79_1330579404 = (Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.LONG);
        //return Memory.peekLong(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.261 -0400", hash_original_method = "C93410329A523BCD2A1636A4AEB3409A", hash_generated_method = "049F182BA6DD83C9EC83BC099DF367F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final short readShort() throws IOException {
        readFully(scratch, 0, SizeOf.SHORT);
        short var007DE4DE11DFBCEFBB55FC3C89A2F231_261999804 = (Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //readFully(scratch, 0, SizeOf.SHORT);
        //return Memory.peekShort(scratch, 0, ByteOrder.BIG_ENDIAN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.261 -0400", hash_original_method = "AF5E7921B4B2187E0041EFA801E04DA5", hash_generated_method = "41BB1CCC518E8D2E2ABD559523C99A08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readUnsignedByte() throws IOException {
        int temp;
        temp = this.read();
        {
            if (DroidSafeAndroidRuntime.control) throw new EOFException();
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int temp = this.read();
        //if (temp < 0) {
            //throw new EOFException();
        //}
        //return temp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.262 -0400", hash_original_method = "856B18E0C9E8549741083F490D54C8D8", hash_generated_method = "93139F573F092D0D281322EA0E491220")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int readUnsignedShort() throws IOException {
        int var80645AD98CDAD0EE0FB3459E3825971C_946888672 = (((int) readShort()) & 0xffff);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((int) readShort()) & 0xffff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.262 -0400", hash_original_method = "1E6F905958EDDE8569C0995497961028", hash_generated_method = "56962E125F107AA2D8E2DAA35B0DA230")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String readUTF() throws IOException {
        int utfSize;
        utfSize = readUnsignedShort();
        byte[] buf;
        buf = new byte[utfSize];
        {
            boolean varCC708F7E031AEDABCA9DFF40A76762B8_413309865 = (read(buf, 0, buf.length) != buf.length);
            {
                if (DroidSafeAndroidRuntime.control) throw new EOFException();
            } //End block
        } //End collapsed parenthetic
        String varAD1A050819E15DAA49394A2885C5D1A9_985085756 = (ModifiedUtf8.decode(buf, new char[utfSize], 0, utfSize));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.262 -0400", hash_original_method = "92812216A189B62C22C36FA4ABFCEF90", hash_generated_method = "2008201C84915A0F5FC10E8A77C8C669")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void seek(long offset) throws IOException {
        dsTaint.addTaint(offset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.262 -0400", hash_original_method = "385EF87B8915AB37CD3540061C92256B", hash_generated_method = "3394F9D465AD295A69F8086FDCA7B039")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLength(long newLength) throws IOException {
        dsTaint.addTaint(newLength);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.263 -0400", hash_original_method = "FB9C2E97D200EE03574ADD76D56D23DD", hash_generated_method = "EC2FD1E9E0EDC527733FD339B047C13A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.263 -0400", hash_original_method = "773CDFC941DB5BD8F51FCC7460E1F3ED", hash_generated_method = "79277C5A941CF35D871B53A2B17A5D22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer[0]);
        write(buffer, 0, buffer.length);
        // ---------- Original Method ----------
        //write(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.263 -0400", hash_original_method = "35FA4EEB101513E91F640D0BB99E182F", hash_generated_method = "15761C1E631AD1051D08677498EB4C25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        dsTaint.addTaint(byteOffset);
        dsTaint.addTaint(buffer[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.263 -0400", hash_original_method = "9AECC3BD7576DA9A6BE139AE80679C12", hash_generated_method = "3D5AAE0A192125873920A233348AF445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void write(int oneByte) throws IOException {
        dsTaint.addTaint(oneByte);
        scratch[0] = (byte) (oneByte & 0xff);
        write(scratch, 0, 1);
        // ---------- Original Method ----------
        //scratch[0] = (byte) (oneByte & 0xff);
        //write(scratch, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.263 -0400", hash_original_method = "9F118A4D5206A4234B8C15F22340D26C", hash_generated_method = "44191D048C0B791C04D1E35D5EC468DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeBoolean(boolean val) throws IOException {
        dsTaint.addTaint(val);
        write(val ? 1 : 0);
        // ---------- Original Method ----------
        //write(val ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.263 -0400", hash_original_method = "B252FC199353C3326913DC87EC8ACD0F", hash_generated_method = "A5794C6A6094D7C2E6C7508A0CB1BD9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeByte(int val) throws IOException {
        dsTaint.addTaint(val);
        write(val & 0xFF);
        // ---------- Original Method ----------
        //write(val & 0xFF);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.264 -0400", hash_original_method = "EECBC8862767167AF0CABDC3594E6347", hash_generated_method = "F50F3B488462FA8C166B65ABF9E6DC4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeBytes(String str) throws IOException {
        dsTaint.addTaint(str);
        byte[] bytes;
        bytes = new byte[str.length()];
        {
            int index;
            index = 0;
            boolean varA02C1B1CDA6C37943246730579D9D4AA_2058088171 = (index < str.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.264 -0400", hash_original_method = "ECFC19989A55A064EF569F6E00E03595", hash_generated_method = "9B3F77BCDFD3570266EA5B4A54A6C490")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeChar(int val) throws IOException {
        dsTaint.addTaint(val);
        writeShort(val);
        // ---------- Original Method ----------
        //writeShort(val);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.264 -0400", hash_original_method = "C993D359026F2BBBDD097DA5FA69EA70", hash_generated_method = "A170DEFD12841627ECCD64986E679E11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeChars(String str) throws IOException {
        dsTaint.addTaint(str);
        write(str.getBytes("UTF-16BE"));
        // ---------- Original Method ----------
        //write(str.getBytes("UTF-16BE"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.264 -0400", hash_original_method = "F72176A2741A4B219C2AAE16A0D68BA2", hash_generated_method = "D6A384EDF89A44EBC738C0D6A777FD58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeDouble(double val) throws IOException {
        dsTaint.addTaint(val);
        writeLong(Double.doubleToLongBits(val));
        // ---------- Original Method ----------
        //writeLong(Double.doubleToLongBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.264 -0400", hash_original_method = "D8994DA56D4741462EE1F41757FFAE01", hash_generated_method = "51DC8D8BD51807ABFEDB0CC3CA019687")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeFloat(float val) throws IOException {
        dsTaint.addTaint(val);
        writeInt(Float.floatToIntBits(val));
        // ---------- Original Method ----------
        //writeInt(Float.floatToIntBits(val));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.265 -0400", hash_original_method = "37CBB7B1E5121DA5847923CB75DB4FD7", hash_generated_method = "80D64FB7AAA1DF72E271EA21B7F1BA50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeInt(int val) throws IOException {
        dsTaint.addTaint(val);
        Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.INT);
        // ---------- Original Method ----------
        //Memory.pokeInt(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.INT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.265 -0400", hash_original_method = "7B3E247666A6F3E05280E703124B5A4E", hash_generated_method = "BD78B7326E30F281547EDCFE21B819D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeLong(long val) throws IOException {
        dsTaint.addTaint(val);
        Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.LONG);
        // ---------- Original Method ----------
        //Memory.pokeLong(scratch, 0, val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.LONG);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.265 -0400", hash_original_method = "64B98C2F1C9F8A49F0516D9D78465522", hash_generated_method = "59DD25C5241087A9E4B561A2D2F9D1F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeShort(int val) throws IOException {
        dsTaint.addTaint(val);
        Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        write(scratch, 0, SizeOf.SHORT);
        // ---------- Original Method ----------
        //Memory.pokeShort(scratch, 0, (short) val, ByteOrder.BIG_ENDIAN);
        //write(scratch, 0, SizeOf.SHORT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.265 -0400", hash_original_method = "9D44E024EEA016D3EAD697517CA83CDC", hash_generated_method = "9E671ED2F004E5E9D7B540ABCB063BDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void writeUTF(String str) throws IOException {
        dsTaint.addTaint(str);
        write(ModifiedUtf8.encode(str));
        // ---------- Original Method ----------
        //write(ModifiedUtf8.encode(str));
    }

    
}

