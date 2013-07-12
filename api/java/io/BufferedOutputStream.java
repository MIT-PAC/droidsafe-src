package java.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Arrays;

public class BufferedOutputStream extends FilterOutputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.095 -0400", hash_original_field = "CB7E52B21171FB9A53B498202607F0BD", hash_generated_field = "083037218D1B4F9535944A48D3FD1BCA")

    protected byte[] buf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.097 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "CADFF8C1F208C99E14B28CFC1A04442F")

    protected int count;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.099 -0400", hash_original_method = "D896F62F17EBF4CCE50C0B823DA78DD6", hash_generated_method = "DCF2592BEC0A2A9308E8AFC5C2200B2C")
    public  BufferedOutputStream(OutputStream out) {
        this(out, 8192);
        addTaint(out.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.102 -0400", hash_original_method = "D77D548D42DBDD230976FC72C0A9CFDA", hash_generated_method = "A38AEA9A07ED1A92A830383CA71168DD")
    public  BufferedOutputStream(OutputStream out, int size) {
        super(out);
        addTaint(out.getTaint());
    if(size <= 0)        
        {
            IllegalArgumentException var5AFB46BA040E4CEE38200888DC74991F_86586959 = new IllegalArgumentException("size <= 0");
            var5AFB46BA040E4CEE38200888DC74991F_86586959.addTaint(taint);
            throw var5AFB46BA040E4CEE38200888DC74991F_86586959;
        } 
        buf = new byte[size];
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.104 -0400", hash_original_method = "1ACC3FF49FD09C78DA86C982A642A64A", hash_generated_method = "5BF171C333DC6B7D2DE5007FBC651EFA")
    @Override
    public synchronized void flush() throws IOException {
        checkNotClosed();
        flushInternal();
        out.flush();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.106 -0400", hash_original_method = "E23D99313D714FF4FE33BC33C5A12E3B", hash_generated_method = "F02FA59B623D22DFA9E66B45848E8D2C")
    private void checkNotClosed() throws IOException {
    if(buf == null)        
        {
            IOException varED812FFE0FE88798191D2BDE77D59D44_744223777 = new IOException("BufferedOutputStream is closed");
            varED812FFE0FE88798191D2BDE77D59D44_744223777.addTaint(taint);
            throw varED812FFE0FE88798191D2BDE77D59D44_744223777;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.112 -0400", hash_original_method = "EC14898AF1C6D500DEF61C098384315C", hash_generated_method = "4178699C04366B9472989E6EBE48D41E")
    @Override
    public synchronized void write(byte[] buffer, int offset, int length) throws IOException {
        addTaint(offset);
        addTaint(buffer[0]);
        checkNotClosed();
    if(buffer == null)        
        {
            NullPointerException varD1F0B530B211C354FD4DD40207900970_468845177 = new NullPointerException("buffer == null");
            varD1F0B530B211C354FD4DD40207900970_468845177.addTaint(taint);
            throw varD1F0B530B211C354FD4DD40207900970_468845177;
        } 
        byte[] internalBuffer = buf;
    if(length >= internalBuffer.length)        
        {
            flushInternal();
            out.write(buffer, offset, length);
            return;
        } 
        Arrays.checkOffsetAndCount(buffer.length, offset, length);
    if(length > (internalBuffer.length - count))        
        {
            flushInternal();
        } 
        System.arraycopy(buffer, offset, internalBuffer, count, length);
        count += length;
        
        
        
            
        
        
        
            
            
            
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.114 -0400", hash_original_method = "C551C170B690A76D4989DEC0BC19E3FB", hash_generated_method = "943098EF6E4001D5D5FB37EF37934B8C")
    @Override
    public synchronized void close() throws IOException {
    if(buf == null)        
        {
            return;
        } 
        try 
        {
            super.close();
        } 
        finally 
        {
            buf = null;
        } 
        
        
            
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.120 -0400", hash_original_method = "45333A97ED5F96C22A3D88C235B79D5A", hash_generated_method = "8196BAFC44CEA190508D7332895439C2")
    @Override
    public synchronized void write(int oneByte) throws IOException {
        checkNotClosed();
    if(count == buf.length)        
        {
            out.write(buf, 0, count);
            count = 0;
        } 
        buf[count++] = (byte) oneByte;
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:39.124 -0400", hash_original_method = "AAC3F75032624F788E22A2E407A017DD", hash_generated_method = "B666C8C1C7135EA8F14F583F8FCB7409")
    private void flushInternal() throws IOException {
    if(count > 0)        
        {
            out.write(buf, 0, count);
            count = 0;
        } 
        
        
            
            
        
    }

    
}

