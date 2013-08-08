package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.Arrays;




public class BufferedOutputStream extends FilterOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.313 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.314 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.315 -0400", hash_original_method = "D896F62F17EBF4CCE50C0B823DA78DD6", hash_generated_method = "DCF2592BEC0A2A9308E8AFC5C2200B2C")
    public  BufferedOutputStream(OutputStream out) {
        this(out, 8192);
        addTaint(out.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.316 -0400", hash_original_method = "D77D548D42DBDD230976FC72C0A9CFDA", hash_generated_method = "D7E5266AD0B89A6C52E69533BFEE5F1A")
    public  BufferedOutputStream(OutputStream out, int size) {
        super(out);
        addTaint(out.getTaint());
        if(size <= 0)        
        {
            IllegalArgumentException var5AFB46BA040E4CEE38200888DC74991F_85070262 = new IllegalArgumentException("size <= 0");
            var5AFB46BA040E4CEE38200888DC74991F_85070262.addTaint(taint);
            throw var5AFB46BA040E4CEE38200888DC74991F_85070262;
        } //End block
        buf = new byte[size];
        // ---------- Original Method ----------
        //if (size <= 0) {
            //throw new IllegalArgumentException("size <= 0");
        //}
        //buf = new byte[size];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.316 -0400", hash_original_method = "1ACC3FF49FD09C78DA86C982A642A64A", hash_generated_method = "5BF171C333DC6B7D2DE5007FBC651EFA")
    @Override
    public synchronized void flush() throws IOException {
        checkNotClosed();
        flushInternal();
        out.flush();
        // ---------- Original Method ----------
        //checkNotClosed();
        //flushInternal();
        //out.flush();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.317 -0400", hash_original_method = "E23D99313D714FF4FE33BC33C5A12E3B", hash_generated_method = "D8FD0801B6E456AE5F329DE44381A8CC")
    private void checkNotClosed() throws IOException {
        if(buf == null)        
        {
            IOException varED812FFE0FE88798191D2BDE77D59D44_337247410 = new IOException("BufferedOutputStream is closed");
            varED812FFE0FE88798191D2BDE77D59D44_337247410.addTaint(taint);
            throw varED812FFE0FE88798191D2BDE77D59D44_337247410;
        } //End block
        // ---------- Original Method ----------
        //if (buf == null) {
            //throw new IOException("BufferedOutputStream is closed");
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.319 -0400", hash_original_method = "EC14898AF1C6D500DEF61C098384315C", hash_generated_method = "056EEFC2CFD24F3FE74AD94037D7003F")
    @Override
    public synchronized void write(byte[] buffer, int offset, int length) throws IOException {
        addTaint(offset);
        addTaint(buffer[0]);
        checkNotClosed();
        if(buffer == null)        
        {
            NullPointerException varD1F0B530B211C354FD4DD40207900970_219607541 = new NullPointerException("buffer == null");
            varD1F0B530B211C354FD4DD40207900970_219607541.addTaint(taint);
            throw varD1F0B530B211C354FD4DD40207900970_219607541;
        } //End block
        byte[] internalBuffer = buf;
        if(length >= internalBuffer.length)        
        {
            flushInternal();
            out.write(buffer, offset, length);
            return;
        } //End block
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
        if(length > (internalBuffer.length - count))        
        {
            flushInternal();
        } //End block
        System.arraycopy(buffer, offset, internalBuffer, count, length);
        count += length;
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //byte[] internalBuffer = buf;
        //if (length >= internalBuffer.length) {
            //flushInternal();
            //out.write(buffer, offset, length);
            //return;
        //}
        //Arrays.checkOffsetAndCount(buffer.length, offset, length);
        //if (length > (internalBuffer.length - count)) {
            //flushInternal();
        //}
        //System.arraycopy(buffer, offset, internalBuffer, count, length);
        //count += length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.320 -0400", hash_original_method = "C551C170B690A76D4989DEC0BC19E3FB", hash_generated_method = "943098EF6E4001D5D5FB37EF37934B8C")
    @Override
    public synchronized void close() throws IOException {
        if(buf == null)        
        {
            return;
        } //End block
        try 
        {
            super.close();
        } //End block
        finally 
        {
            buf = null;
        } //End block
        // ---------- Original Method ----------
        //if (buf == null) {
            //return;
        //}
        //try {
            //super.close();
        //} finally {
            //buf = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.321 -0400", hash_original_method = "45333A97ED5F96C22A3D88C235B79D5A", hash_generated_method = "8196BAFC44CEA190508D7332895439C2")
    @Override
    public synchronized void write(int oneByte) throws IOException {
        checkNotClosed();
        if(count == buf.length)        
        {
            out.write(buf, 0, count);
            count = 0;
        } //End block
        buf[count++] = (byte) oneByte;
        // ---------- Original Method ----------
        //checkNotClosed();
        //if (count == buf.length) {
            //out.write(buf, 0, count);
            //count = 0;
        //}
        //buf[count++] = (byte) oneByte;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:43.321 -0400", hash_original_method = "AAC3F75032624F788E22A2E407A017DD", hash_generated_method = "B666C8C1C7135EA8F14F583F8FCB7409")
    private void flushInternal() throws IOException {
        if(count > 0)        
        {
            out.write(buf, 0, count);
            count = 0;
        } //End block
        // ---------- Original Method ----------
        //if (count > 0) {
            //out.write(buf, 0, count);
            //count = 0;
        //}
    }

    
}

