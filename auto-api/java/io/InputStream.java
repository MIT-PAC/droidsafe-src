package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Arrays;
import libcore.io.Streams;

public abstract class InputStream extends Object implements Closeable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.810 -0400", hash_original_method = "24B6F89B4CF6382DB2E4A4E334B70B5D", hash_generated_method = "232D3ABC66DDB0962216577ED704AA4D")
    @DSModeled(DSC.SAFE)
    public InputStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.810 -0400", hash_original_method = "1AA324AC6812BCD54DB71C20D6BA0F20", hash_generated_method = "FD19BA146E00B898AD84B9620658EDC4")
    @DSModeled(DSC.SAFE)
    public int available() throws IOException {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.810 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "74372D27DE595543DBC3B69FBB71373E")
    @DSModeled(DSC.SAFE)
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.811 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "4E1550B09331468D34AFE4EF29C775B1")
    @DSModeled(DSC.SAFE)
    public void mark(int readlimit) {
        dsTaint.addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.811 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "D7A4350D03A166205FD77DA7EA1DB61D")
    @DSModeled(DSC.SAFE)
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract int read() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.811 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "0402B664F236833DFD0F3735A2689233")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer[0]);
        int var6FC2792F895D13BB16201EFCBA1330E5_334848041 = (read(buffer, 0, buffer.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return read(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.811 -0400", hash_original_method = "287E8AA63F5F0E35884524D6430753F1", hash_generated_method = "9C9B81DF290ABB11E3D1E1AC68EC0A66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer[0]);
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        {
            int i;
            i = 0;
            {
                int c;
                try 
                {
                    {
                        boolean var906137A6060AF34E5FF4A077340C70B0_1937037423 = ((c = read()) == -1);
                    } //End collapsed parenthetic
                } //End block
                catch (IOException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
                buffer[offset + i] = (byte) c;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //for (int i = 0; i < length; i++) {
            //int c;
            //try {
                //if ((c = read()) == -1) {
                    //return i == 0 ? -1 : i;
                //}
            //} catch (IOException e) {
                //if (i != 0) {
                    //return i;
                //}
                //throw e;
            //}
            //buffer[offset + i] = (byte) c;
        //}
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.812 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "C0D0914B605E4163C857D6AE3F030FDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:24.812 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "D4F98091DFDCE0B6B1FAD7699ED2C3B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        long var242616A7471CF01D821614D0D0C41129_1364940163 = (Streams.skipByReading(this, byteCount));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return Streams.skipByReading(this, byteCount);
    }

    
}

