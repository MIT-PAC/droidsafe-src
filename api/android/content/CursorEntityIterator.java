package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.database.Cursor;
import android.os.RemoteException;





public abstract class CursorEntityIterator implements EntityIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.492 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    private Cursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.492 -0400", hash_original_field = "42C51B2F76146A5EC92C9811D57ACF10", hash_generated_field = "A6BB6E42C38AE7C525A0832B55750D8F")

    private boolean mIsClosed;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.492 -0400", hash_original_method = "76B86F8C1E31679F8727B434E61B14CB", hash_generated_method = "B0CDFD30A5D8289392A197569989206F")
    public  CursorEntityIterator(Cursor cursor) {
        mIsClosed = false;
        mCursor = cursor;
        mCursor.moveToFirst();
        // ---------- Original Method ----------
        //mIsClosed = false;
        //mCursor = cursor;
        //mCursor.moveToFirst();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException;

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.492 -0400", hash_original_method = "EFC615883F392C5E7B7F6E9EF3393B85", hash_generated_method = "615271A9F440649387636AA3AD1F6FE7")
    public final boolean hasNext() {
        if(mIsClosed)        
        {
            IllegalStateException var994C5FDCB689CD476D720223C1A2E97C_1542407664 = new IllegalStateException("calling hasNext() when the iterator is closed");
            var994C5FDCB689CD476D720223C1A2E97C_1542407664.addTaint(taint);
            throw var994C5FDCB689CD476D720223C1A2E97C_1542407664;
        } //End block
        boolean varA900E63D2652380A0AE5EC5450C680D1_2026531991 = (!mCursor.isAfterLast());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_736286325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_736286325;
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("calling hasNext() when the iterator is closed");
        //}
        //return !mCursor.isAfterLast();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.493 -0400", hash_original_method = "D761CE40C9BF5BACB311C894FE3131D0", hash_generated_method = "E69C7FE396FBF487669DC0A4275B461F")
    public Entity next() {
        if(mIsClosed)        
        {
            IllegalStateException var12E76C3A9A7CEE219DB8C76087FF564B_713154180 = new IllegalStateException("calling next() when the iterator is closed");
            var12E76C3A9A7CEE219DB8C76087FF564B_713154180.addTaint(taint);
            throw var12E76C3A9A7CEE219DB8C76087FF564B_713154180;
        } //End block
        if(!hasNext())        
        {
            IllegalStateException varE20C7FA15E48B005588D91906DC67B5F_832914009 = new IllegalStateException("you may only call next() if hasNext() is true");
            varE20C7FA15E48B005588D91906DC67B5F_832914009.addTaint(taint);
            throw varE20C7FA15E48B005588D91906DC67B5F_832914009;
        } //End block
        try 
        {
Entity var89A776ACF604CF5B8BF8FB402D39F0BE_656514421 =             getEntityAndIncrementCursor(mCursor);
            var89A776ACF604CF5B8BF8FB402D39F0BE_656514421.addTaint(taint);
            return var89A776ACF604CF5B8BF8FB402D39F0BE_656514421;
        } //End block
        catch (RemoteException e)
        {
            RuntimeException varA9C8EAB58C0973C3C3455840A2CBB98C_257334363 = new RuntimeException("caught a remote exception, this process will die soon", e);
            varA9C8EAB58C0973C3C3455840A2CBB98C_257334363.addTaint(taint);
            throw varA9C8EAB58C0973C3C3455840A2CBB98C_257334363;
        } //End block
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("calling next() when the iterator is closed");
        //}
        //if (!hasNext()) {
            //throw new IllegalStateException("you may only call next() if hasNext() is true");
        //}
        //try {
            //return getEntityAndIncrementCursor(mCursor);
        //} catch (RemoteException e) {
            //throw new RuntimeException("caught a remote exception, this process will die soon", e);
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.493 -0400", hash_original_method = "2158F00E167F00121D9D2190C01FAABB", hash_generated_method = "079DFC141AAC73FA45B9C248EB02DE6E")
    public void remove() {
        UnsupportedOperationException var3507AD2E5185A524A543CF22C0250BAC_1298754522 = new UnsupportedOperationException("remove not supported by EntityIterators");
        var3507AD2E5185A524A543CF22C0250BAC_1298754522.addTaint(taint);
        throw var3507AD2E5185A524A543CF22C0250BAC_1298754522;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("remove not supported by EntityIterators");
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.493 -0400", hash_original_method = "D0360F07FA873653A69218CB10B6D78C", hash_generated_method = "B230BABD808BEAE19CD0AE46FE64A3B0")
    public final void reset() {
        if(mIsClosed)        
        {
            IllegalStateException var47A5740EFD7F765F130EF9990EDEC229_1347989156 = new IllegalStateException("calling reset() when the iterator is closed");
            var47A5740EFD7F765F130EF9990EDEC229_1347989156.addTaint(taint);
            throw var47A5740EFD7F765F130EF9990EDEC229_1347989156;
        } //End block
        mCursor.moveToFirst();
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("calling reset() when the iterator is closed");
        //}
        //mCursor.moveToFirst();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.493 -0400", hash_original_method = "B24D9E2E069589E778F23FCBC29406BF", hash_generated_method = "C3809F69E058058F0178670A46CC07E2")
    public final void close() {
        if(mIsClosed)        
        {
            IllegalStateException varC011F9740FCC2D0357D3F5533DD6D908_612880557 = new IllegalStateException("closing when already closed");
            varC011F9740FCC2D0357D3F5533DD6D908_612880557.addTaint(taint);
            throw varC011F9740FCC2D0357D3F5533DD6D908_612880557;
        } //End block
        mIsClosed = true;
        mCursor.close();
        // ---------- Original Method ----------
        //if (mIsClosed) {
            //throw new IllegalStateException("closing when already closed");
        //}
        //mIsClosed = true;
        //mCursor.close();
    }

    
}

