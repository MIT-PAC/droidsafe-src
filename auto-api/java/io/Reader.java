package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;

public abstract class Reader implements Readable, Closeable {
    protected Object lock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.681 -0400", hash_original_method = "23BD0F45FCD5744DE183656F7640DB10", hash_generated_method = "C4D442694B72E8B7566DA051274CBB91")
    @DSModeled(DSC.SAFE)
    protected Reader() {
        lock = this;
        // ---------- Original Method ----------
        //lock = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.681 -0400", hash_original_method = "841CA56D08654DE62644A6941CD75AE9", hash_generated_method = "C5CB6392B2EDBCE307554D0BFDBF0C5E")
    @DSModeled(DSC.SAFE)
    protected Reader(Object lock) {
        dsTaint.addTaint(lock.dsTaint);
        {
            throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (lock == null) {
            //throw new NullPointerException();
        //}
        //this.lock = lock;
    }

    
    public abstract void close() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.681 -0400", hash_original_method = "2066C142E0E9A9BCC65518E0FCDDA1D6", hash_generated_method = "CEFA1B9B2454F1AC1D87E74F4BD82BD9")
    @DSModeled(DSC.SAFE)
    public void mark(int readLimit) throws IOException {
        dsTaint.addTaint(readLimit);
        throw new IOException();
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.682 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "DBAA4FD3517D5C6FBE92DAB042582601")
    @DSModeled(DSC.SAFE)
    public boolean markSupported() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.682 -0400", hash_original_method = "4B904F9F4843983C12271BC14A375F35", hash_generated_method = "29F7EA5543599DEF5E32742DD4AAE7B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read() throws IOException {
        {
            char[] charArray;
            charArray = new char[1];
            {
                boolean var73E325C49628EE2FF23237E9667EC984_44409130 = (read(charArray, 0, 1) != -1);
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (lock) {
            //char[] charArray = new char[1];
            //if (read(charArray, 0, 1) != -1) {
                //return charArray[0];
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.682 -0400", hash_original_method = "E743E3D19B5FD453D0CBC2E5CA424673", hash_generated_method = "B69BF36A089C36F4710CCC198E49ABCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(char[] buf) throws IOException {
        dsTaint.addTaint(buf);
        int varCC1AB894CEDAC6AF53B5291411180A42_1744363753 = (read(buf, 0, buf.length));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return read(buf, 0, buf.length);
    }

    
    public abstract int read(char[] buf, int offset, int count) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.682 -0400", hash_original_method = "D41EE0434E50B3C6E1AA0E42EDD44E0B", hash_generated_method = "C06C43D622D2B2008AA00CF103FCB639")
    @DSModeled(DSC.SAFE)
    public boolean ready() throws IOException {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.682 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "A3553D42BB3F5C8F04A7F0447970A087")
    @DSModeled(DSC.SAFE)
    public void reset() throws IOException {
        throw new IOException();
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.682 -0400", hash_original_method = "7E8A2F73FB8EAE936D216E90BE91676B", hash_generated_method = "D824ED3D406BDE6768A04E1979D0FEB7")
    @DSModeled(DSC.SAFE)
    public long skip(long charCount) throws IOException {
        dsTaint.addTaint(charCount);
        if(DroidSafeAndroidRuntime.control) {
            throw new IllegalArgumentException("charCount < 0: " + charCount);
        } //End block
        {
            long skipped;
            skipped = 0;
            int toRead;
            toRead = (int) charCount;
            toRead = 512;
            char[] charsSkipped;
            charsSkipped = new char[toRead];
            {
                int read;
                read = read(charsSkipped, 0, toRead);
                skipped += read;
                {
                    toRead = (int) (charCount - skipped);
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (charCount < 0) {
            //throw new IllegalArgumentException("charCount < 0: " + charCount);
        //}
        //synchronized (lock) {
            //long skipped = 0;
            //int toRead = charCount < 512 ? (int) charCount : 512;
            //char[] charsSkipped = new char[toRead];
            //while (skipped < charCount) {
                //int read = read(charsSkipped, 0, toRead);
                //if (read == -1) {
                    //return skipped;
                //}
                //skipped += read;
                //if (read < toRead) {
                    //return skipped;
                //}
                //if (charCount - skipped < toRead) {
                    //toRead = (int) (charCount - skipped);
                //}
            //}
            //return skipped;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.682 -0400", hash_original_method = "3EEA08DE1417537F34B729CF4FE40629", hash_generated_method = "3D8DA6BEB183C0DE85FA5B7CCC140EEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int read(CharBuffer target) throws IOException {
        dsTaint.addTaint(target.dsTaint);
        int length;
        length = target.length();
        char[] buf;
        buf = new char[length];
        length = Math.min(length, read(buf));
        {
            target.put(buf, 0, length);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int length = target.length();
        //char[] buf = new char[length];
        //length = Math.min(length, read(buf));
        //if (length > 0) {
            //target.put(buf, 0, length);
        //}
        //return length;
    }

    
}


