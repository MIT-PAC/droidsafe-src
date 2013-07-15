package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public abstract class FileLock {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.619 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.619 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.619 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.619 -0400", hash_original_field = "9E81E7B963C71363E2FB3EEFCFECFC0E", hash_generated_field = "208F8AA93D19EFFECF64F85E89AD016E")

    private boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.620 -0400", hash_original_method = "CD9224B029C4E22DF1D36B9A88EF4582", hash_generated_method = "A845A7E1ECC63B6912EDA770FA45B4E5")
    protected  FileLock(FileChannel channel, long position, long size, boolean shared) {
    if(position < 0 || size < 0 || position + size < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_232510318 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_232510318.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_232510318;
        } //End block
        this.channel = channel;
        this.position = position;
        this.size = size;
        this.shared = shared;
        // ---------- Original Method ----------
        //if (position < 0 || size < 0 || position + size < 0) {
            //throw new IllegalArgumentException();
        //}
        //this.channel = channel;
        //this.position = position;
        //this.size = size;
        //this.shared = shared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.620 -0400", hash_original_method = "51CC76EF226D8C9ED837839CEF3A7EEC", hash_generated_method = "D27258A2B5A75AD07826458F89AB971D")
    public final FileChannel channel() {
FileChannel var99BA3483FD74E36EACD435CEE6BD5D6F_404954840 =         channel;
        var99BA3483FD74E36EACD435CEE6BD5D6F_404954840.addTaint(taint);
        return var99BA3483FD74E36EACD435CEE6BD5D6F_404954840;
        // ---------- Original Method ----------
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.620 -0400", hash_original_method = "B51039013FACF3B9BE83986840749101", hash_generated_method = "4D16F0CB6722ABF548A0631C0DB59BE2")
    public final long position() {
        long var4757FE07FD492A8BE0EA6A760D683D6E_1374543241 = (position);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1732518068 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1732518068;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.620 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "DA2322CD957CD32E77DDF4B1CE65CE74")
    public final long size() {
        long varF7BD60B75B29D79B660A2859395C1A24_1598604602 = (size);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1999840446 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1999840446;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.621 -0400", hash_original_method = "9101EDDE96E9CB8A45C7075BA466C705", hash_generated_method = "3560516C99E767D143667A0DF4038EBA")
    public final boolean isShared() {
        boolean var9E81E7B963C71363E2FB3EEFCFECFC0E_2057608661 = (shared);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1403967802 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1403967802;
        // ---------- Original Method ----------
        //return shared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.621 -0400", hash_original_method = "BD91EA1BF31FE8BEA01F707FE570CF9B", hash_generated_method = "28CE5E1E4C649BCB8376EE594AEE5AB9")
    public final boolean overlaps(long start, long length) {
        addTaint(length);
        addTaint(start);
        final long end = position + size - 1;
        final long newEnd = start + length - 1;
    if(end < start || position > newEnd)        
        {
            boolean var68934A3E9455FA72420237EB05902327_949228314 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_230282461 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_230282461;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_652289934 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107103699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107103699;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:52.621 -0400", hash_original_method = "1F1F0B30DE920C1569E46FCBBEE46A56", hash_generated_method = "95D9A9BF177F9F098F650A8C5146183B")
    @Override
    public final String toString() {
String var8E19B0E47F27C9581CD7CF22D53F3239_1478177746 =         "FileLock[position=" + position + ", size=" + size + ", shared=" + shared + "]";
        var8E19B0E47F27C9581CD7CF22D53F3239_1478177746.addTaint(taint);
        return var8E19B0E47F27C9581CD7CF22D53F3239_1478177746;
        // ---------- Original Method ----------
        //return "FileLock[position=" + position + ", size=" + size + ", shared=" + shared + "]";
    }

    
}

