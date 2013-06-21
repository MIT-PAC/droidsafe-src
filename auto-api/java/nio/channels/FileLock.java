package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public abstract class FileLock {
    private FileChannel channel;
    private long position;
    private long size;
    private boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.112 -0400", hash_original_method = "CD9224B029C4E22DF1D36B9A88EF4582", hash_generated_method = "685ABC872321FB13DB0C2FC41EF632ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected FileLock(FileChannel channel, long position, long size, boolean shared) {
        dsTaint.addTaint(shared);
        dsTaint.addTaint(position);
        dsTaint.addTaint(channel.dsTaint);
        dsTaint.addTaint(size);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.112 -0400", hash_original_method = "51CC76EF226D8C9ED837839CEF3A7EEC", hash_generated_method = "D51E3752D31E2F5D87DD6364EFD75787")
    @DSModeled(DSC.SAFE)
    public final FileChannel channel() {
        return (FileChannel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.112 -0400", hash_original_method = "B51039013FACF3B9BE83986840749101", hash_generated_method = "E93836A343771976F61808DA10A3477E")
    @DSModeled(DSC.SAFE)
    public final long position() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.112 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "19C1AED09E9AC7C821A18BD3390D3D9D")
    @DSModeled(DSC.SAFE)
    public final long size() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.116 -0400", hash_original_method = "9101EDDE96E9CB8A45C7075BA466C705", hash_generated_method = "6253FF071F9A3DCFBA3B97FF66C414D9")
    @DSModeled(DSC.SAFE)
    public final boolean isShared() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return shared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.116 -0400", hash_original_method = "BD91EA1BF31FE8BEA01F707FE570CF9B", hash_generated_method = "721C2D586A5721D512E69BAE5566C75F")
    @DSModeled(DSC.SAFE)
    public final boolean overlaps(long start, long length) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(length);
        long end;
        end = position + size - 1;
        long newEnd;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.117 -0400", hash_original_method = "1F1F0B30DE920C1569E46FCBBEE46A56", hash_generated_method = "F5FBE3A014333C96EA9D7C32E3A6BCA2")
    @DSModeled(DSC.SAFE)
    @Override
    public final String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "FileLock[position=" + position + ", size=" + size + ", shared=" + shared + "]";
    }

    
}

