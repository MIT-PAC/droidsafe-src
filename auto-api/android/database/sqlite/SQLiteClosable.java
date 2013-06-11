package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.database.CursorWindow;

public abstract class SQLiteClosable {
    private int mReferenceCount = 1;
    
    protected abstract void onAllReferencesReleased();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.699 -0400", hash_original_method = "E024C98C9CCE430E2F2A96AB4D1C1206", hash_generated_method = "C13A33C2569B29C2D76B51FD03AA0690")
    @DSModeled(DSC.SAFE)
    protected void onAllReferencesReleasedFromContainer() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.699 -0400", hash_original_method = "1061625992B0C8C116E9B0FDA746DD53", hash_generated_method = "53F390D3CD0F6BA11993C98E67C8D51D")
    @DSModeled(DSC.SAFE)
    public void acquireReference() {
        {
            {
                throw new IllegalStateException(
                        "attempt to re-open an already-closed object: " + getObjInfo());
            } //End block
            mReferenceCount++;
        } //End block
        // ---------- Original Method ----------
        //synchronized(this) {
            //if (mReferenceCount <= 0) {
                //throw new IllegalStateException(
                        //"attempt to re-open an already-closed object: " + getObjInfo());
            //}
            //mReferenceCount++;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.700 -0400", hash_original_method = "9A856B4F8EE35DA89AAA5714CDA66263", hash_generated_method = "90F483940C799423799B6F5413EC635E")
    @DSModeled(DSC.SAFE)
    public void releaseReference() {
        boolean refCountIsZero;
        refCountIsZero = false;
        {
            refCountIsZero = --mReferenceCount == 0;
        } //End block
        {
            onAllReferencesReleased();
        } //End block
        // ---------- Original Method ----------
        //boolean refCountIsZero = false;
        //synchronized(this) {
            //refCountIsZero = --mReferenceCount == 0;
        //}
        //if (refCountIsZero) {
            //onAllReferencesReleased();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.700 -0400", hash_original_method = "09E098F074A456ED367ED67E041E3D74", hash_generated_method = "6042248758B1CB8D9877A551D7C00C16")
    @DSModeled(DSC.SAFE)
    public void releaseReferenceFromContainer() {
        boolean refCountIsZero;
        refCountIsZero = false;
        {
            refCountIsZero = --mReferenceCount == 0;
        } //End block
        {
            onAllReferencesReleasedFromContainer();
        } //End block
        // ---------- Original Method ----------
        //boolean refCountIsZero = false;
        //synchronized(this) {
            //refCountIsZero = --mReferenceCount == 0;
        //}
        //if (refCountIsZero) {
            //onAllReferencesReleasedFromContainer();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.700 -0400", hash_original_method = "DF04C7F4D466F671C367EF5E9F18369F", hash_generated_method = "2610A6C0AAD0BE8C4E3222A9557C6C22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getObjInfo() {
        StringBuilder buff;
        buff = new StringBuilder();
        buff.append(this.getClass().getName());
        buff.append(" (");
        {
            buff.append("database = ");
            buff.append(((SQLiteDatabase)this).getPath());
        } //End block
        {
            buff.append("mSql = ");
            buff.append(((SQLiteProgram)this).mSql);
        } //End block
        {
            buff.append("mStartPos = ");
            buff.append(((CursorWindow)this).getStartPosition());
        } //End block
        buff.append(") ");
        String var7886FFD5307B2368E4A89A54A82E532B_1287490998 = (buff.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder buff = new StringBuilder();
        //buff.append(this.getClass().getName());
        //buff.append(" (");
        //if (this instanceof SQLiteDatabase) {
            //buff.append("database = ");
            //buff.append(((SQLiteDatabase)this).getPath());
        //} else if (this instanceof SQLiteProgram) {
            //buff.append("mSql = ");
            //buff.append(((SQLiteProgram)this).mSql);
        //} else if (this instanceof CursorWindow) {
            //buff.append("mStartPos = ");
            //buff.append(((CursorWindow)this).getStartPosition());
        //}
        //buff.append(") ");
        //return buff.toString();
    }

    
}


