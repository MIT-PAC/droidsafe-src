package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.util.Arrays;
import libcore.io.Streams;

public abstract class InputStream extends Object implements Closeable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.465 -0400", hash_original_method = "24B6F89B4CF6382DB2E4A4E334B70B5D", hash_generated_method = "ADC249D6C409A5442C2ACCCCFC332B1D")
    @DSModeled(DSC.SAFE)
    public InputStream() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.465 -0400", hash_original_method = "1AA324AC6812BCD54DB71C20D6BA0F20", hash_generated_method = "62AF7AFBCA5CE481E58D5B962A558FFA")
    @DSModeled(DSC.SAFE)
    public int available() throws IOException {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.465 -0400", hash_original_method = "403A1214A00C2300123B494982A31042", hash_generated_method = "21115B8151778BA3C6136A3C8DA8EA25")
    @DSModeled(DSC.SAFE)
    public void close() throws IOException {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.465 -0400", hash_original_method = "99EDC8CF58ACEFC383E40E1B1F253896", hash_generated_method = "502E9DF43E60E0844736159A25558D29")
    @DSModeled(DSC.SAFE)
    public void mark(int readlimit) {
        dsTaint.addTaint(readlimit);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.465 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "DBAA4FD3517D5C6FBE92DAB042582601")
    @DSModeled(DSC.SAFE)
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract int read() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.465 -0400", hash_original_method = "73C43862A3B640F09D97EB0273F5287B", hash_generated_method = "F725391FF61143181AAE48E7DDA9BF36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(byte[] buffer) throws IOException {
        dsTaint.addTaint(buffer);
        int var6FC2792F895D13BB16201EFCBA1330E5_1159377428 = (read(buffer, 0, buffer.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return read(buffer, 0, buffer.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.466 -0400", hash_original_method = "287E8AA63F5F0E35884524D6430753F1", hash_generated_method = "917DF2DC8D82E2016BDE9322F25E2330")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(byte[] buffer, int offset, int length) throws IOException {
        dsTaint.addTaint(buffer);
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
                        boolean var906137A6060AF34E5FF4A077340C70B0_1010185654 = ((c = read()) == -1);
                    } //End collapsed parenthetic
                } //End block
                catch (IOException e)
                {
                    throw e;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.466 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "18F618A53A74D84A7BE451E1723D0A86")
    @DSModeled(DSC.SAFE)
    public synchronized void reset() throws IOException {
        throw new IOException();
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.466 -0400", hash_original_method = "B0B2C5ABB0F3ADBF684B825EB14D5721", hash_generated_method = "D057D9F2E94F5142B40ED227ECDED1DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long skip(long byteCount) throws IOException {
        dsTaint.addTaint(byteCount);
        long var242616A7471CF01D821614D0D0C41129_247423995 = (Streams.skipByReading(this, byteCount));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return Streams.skipByReading(this, byteCount);
    }

    
}


