package java.nio.channels;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public abstract class FileLock {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.189 -0400", hash_original_field = "C485D2ED5CC4CE64FCCCCA710C7A0BB7", hash_generated_field = "D2F54CF06A6D02676AAD3B9CA4DD4532")

    private FileChannel channel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.189 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "8E29B08B4FE682944F05067766AFABCB")

    private long position;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.189 -0400", hash_original_field = "F7BD60B75B29D79B660A2859395C1A24", hash_generated_field = "CB917F06730B11F4BAAAFECA2C1D90A2")

    private long size;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.190 -0400", hash_original_field = "9E81E7B963C71363E2FB3EEFCFECFC0E", hash_generated_field = "208F8AA93D19EFFECF64F85E89AD016E")

    private boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.191 -0400", hash_original_method = "CD9224B029C4E22DF1D36B9A88EF4582", hash_generated_method = "F5ABF1CB705B458A35B898221DEDA719")
    protected  FileLock(FileChannel channel, long position, long size, boolean shared) {
        if(position < 0 || size < 0 || position + size < 0)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1532028116 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1532028116.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1532028116;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.191 -0400", hash_original_method = "51CC76EF226D8C9ED837839CEF3A7EEC", hash_generated_method = "4E63C680E81B793798F4969E2A8F8466")
    public final FileChannel channel() {
FileChannel var99BA3483FD74E36EACD435CEE6BD5D6F_1480987053 =         channel;
        var99BA3483FD74E36EACD435CEE6BD5D6F_1480987053.addTaint(taint);
        return var99BA3483FD74E36EACD435CEE6BD5D6F_1480987053;
        // ---------- Original Method ----------
        //return channel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.192 -0400", hash_original_method = "B51039013FACF3B9BE83986840749101", hash_generated_method = "38F5782B17269729EF586DF0CBFF690A")
    public final long position() {
        long var4757FE07FD492A8BE0EA6A760D683D6E_2140177084 = (position);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_317321577 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_317321577;
        // ---------- Original Method ----------
        //return position;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.192 -0400", hash_original_method = "EA3441215E7ACDF721D34D006EDC791B", hash_generated_method = "7BD6F966375549015102387D60F06DAD")
    public final long size() {
        long varF7BD60B75B29D79B660A2859395C1A24_1685486664 = (size);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_129410936 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_129410936;
        // ---------- Original Method ----------
        //return size;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.192 -0400", hash_original_method = "9101EDDE96E9CB8A45C7075BA466C705", hash_generated_method = "253B7E77CB7BB16C779C2539CE2F2C87")
    public final boolean isShared() {
        boolean var9E81E7B963C71363E2FB3EEFCFECFC0E_422022562 = (shared);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1271229947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1271229947;
        // ---------- Original Method ----------
        //return shared;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.193 -0400", hash_original_method = "BD91EA1BF31FE8BEA01F707FE570CF9B", hash_generated_method = "A3CE1D14B763EE15C56811946EAC426A")
    public final boolean overlaps(long start, long length) {
        addTaint(length);
        addTaint(start);
        final long end = position + size - 1;
        final long newEnd = start + length - 1;
        if(end < start || position > newEnd)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1488772751 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217743999 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_217743999;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1301859532 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_785647761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_785647761;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.193 -0400", hash_original_method = "1F1F0B30DE920C1569E46FCBBEE46A56", hash_generated_method = "D6B80064B4F48A7E2D7760A497203E2D")
    @Override
    public final String toString() {
String var8E19B0E47F27C9581CD7CF22D53F3239_1114752451 =         "FileLock[position=" + position + ", size=" + size + ", shared=" + shared + "]";
        var8E19B0E47F27C9581CD7CF22D53F3239_1114752451.addTaint(taint);
        return var8E19B0E47F27C9581CD7CF22D53F3239_1114752451;
        // ---------- Original Method ----------
        //return "FileLock[position=" + position + ", size=" + size + ", shared=" + shared + "]";
    }

    
}

