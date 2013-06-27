package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.CharBuffer;
import java.nio.ReadOnlyBufferException;

public abstract class Reader implements Readable, Closeable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.581 -0400", hash_original_field = "DCE7C4174CE9323904A934A486C41288", hash_generated_field = "AB852390F41C8C6739EA01C427D6BB51")

    protected Object lock;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.582 -0400", hash_original_method = "23BD0F45FCD5744DE183656F7640DB10", hash_generated_method = "34ED878B44B0872C50C8F22A6EAAAA08")
    protected  Reader() {
        lock = this;
        // ---------- Original Method ----------
        //lock = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.583 -0400", hash_original_method = "841CA56D08654DE62644A6941CD75AE9", hash_generated_method = "9352131AA8C4B9857ACBC82BF46DCFFC")
    protected  Reader(Object lock) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.lock = lock;
        // ---------- Original Method ----------
        //if (lock == null) {
            //throw new NullPointerException();
        //}
        //this.lock = lock;
    }

    
    public abstract void close() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.583 -0400", hash_original_method = "2066C142E0E9A9BCC65518E0FCDDA1D6", hash_generated_method = "AFAF0F7EF370F6B3675548AD803F6AC7")
    public void mark(int readLimit) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        addTaint(readLimit);
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.583 -0400", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "B2154049E6A9D07C357AEA051B4E424E")
    public boolean markSupported() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156790039 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156790039;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.597 -0400", hash_original_method = "4B904F9F4843983C12271BC14A375F35", hash_generated_method = "F8B6FEF33AAB2755783A51D164EC73C3")
    public int read() throws IOException {
        {
            char[] charArray;
            charArray = new char[1];
            {
                boolean var73E325C49628EE2FF23237E9667EC984_1123546872 = (read(charArray, 0, 1) != -1);
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849227320 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1849227320;
        // ---------- Original Method ----------
        //synchronized (lock) {
            //char[] charArray = new char[1];
            //if (read(charArray, 0, 1) != -1) {
                //return charArray[0];
            //}
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.598 -0400", hash_original_method = "E743E3D19B5FD453D0CBC2E5CA424673", hash_generated_method = "E706D9948142FA95571D46E3BD31FA54")
    public int read(char[] buf) throws IOException {
        int varCC1AB894CEDAC6AF53B5291411180A42_1430633409 = (read(buf, 0, buf.length));
        addTaint(buf[0]);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1764538051 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1764538051;
        // ---------- Original Method ----------
        //return read(buf, 0, buf.length);
    }

    
    public abstract int read(char[] buf, int offset, int count) throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.598 -0400", hash_original_method = "D41EE0434E50B3C6E1AA0E42EDD44E0B", hash_generated_method = "C74A755BB57B5ED5CE6DEFD2B98F6F73")
    public boolean ready() throws IOException {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_84772169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_84772169;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.599 -0400", hash_original_method = "B2B0ACE34E24898AD20F33154DDE5ADD", hash_generated_method = "FB63651561D5F09834B18761B64A9A4D")
    public void reset() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new IOException();
        // ---------- Original Method ----------
        //throw new IOException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.599 -0400", hash_original_method = "7E8A2F73FB8EAE936D216E90BE91676B", hash_generated_method = "15E790D6C3EF7864D340314B8F16D703")
    public long skip(long charCount) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("charCount < 0: " + charCount);
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
        addTaint(charCount);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1461885879 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1461885879;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:39.600 -0400", hash_original_method = "3EEA08DE1417537F34B729CF4FE40629", hash_generated_method = "94E31516B9FD2415403F5E1C86F2143D")
    public int read(CharBuffer target) throws IOException {
        int length;
        length = target.length();
        char[] buf;
        buf = new char[length];
        length = Math.min(length, read(buf));
        {
            target.put(buf, 0, length);
        } //End block
        addTaint(target.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477689063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477689063;
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

