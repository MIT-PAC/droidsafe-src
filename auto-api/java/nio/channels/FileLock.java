package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;

public abstract class FileLock {
    private final FileChannel channel;
    private final long position;
    private final long size;
    private final boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.485 -0400", hash_original_method = "CD9224B029C4E22DF1D36B9A88EF4582", hash_generated_method = "3655D135A7AE8741B4F425F4FC4EA56C")
    @DSModeled(DSC.SAFE)
    protected FileLock(FileChannel channel, long position, long size, boolean shared) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(shared);
        dsTaint.addTaint(channel.dsTaint);
        dsTaint.addTaint(size);
        {
            throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (position < 0 || size < 0 || position + size < 0) {
            //throw new IllegalArgumentException();
        //}
        //this.channel = channel;
        //this.position = position;
        //this.size = size;
        //this.shared = shared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.485 -0400", hash_original_method = "51CC76EF226D8C9ED837839CEF3A7EEC", hash_generated_method = "34880C2F44ADCDDC78BD38D12FF20766")
    @DSModeled(DSC.SAFE)
    public final FileChannel channel() {
        return (FileChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.485 -0400", hash_original_method = "B51039013FACF3B9BE83986840749101", hash_generated_method = "2929197989335EF4FCDE18025C1DDCD7")
    @DSModeled(DSC.SAFE)
    public final long position() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.485 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "FBAE1605FBF963B08D0AF72784F196E6")
    @DSModeled(DSC.SAFE)
    public final long size() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.485 -0400", hash_original_method = "9101EDDE96E9CB8A45C7075BA466C705", hash_generated_method = "436A66F0C8D8EF372D7CF7C718835438")
    @DSModeled(DSC.SAFE)
    public final boolean isShared() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return shared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.485 -0400", hash_original_method = "BD91EA1BF31FE8BEA01F707FE570CF9B", hash_generated_method = "DE316F1F6C59863E7505257D5DED1AA3")
    @DSModeled(DSC.SAFE)
    public final boolean overlaps(long start, long length) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(length);
        final long end;
        end = position + size - 1;
        final long newEnd;
        newEnd = start + length - 1;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final long end = position + size - 1;
        //final long newEnd = start + length - 1;
        //if (end < start || position > newEnd) {
            //return false;
        //}
        //return true;
    }

    
    public abstract boolean isValid();

    
    public abstract void release() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.486 -0400", hash_original_method = "1F1F0B30DE920C1569E46FCBBEE46A56", hash_generated_method = "1FF28E8DBBF868D27B7863A046A260F6")
    @DSModeled(DSC.SAFE)
    @Override
    public final String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "FileLock[position=" + position + ", size=" + size + ", shared=" + shared + "]";
    }

    
}


