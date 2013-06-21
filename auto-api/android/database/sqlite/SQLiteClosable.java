package android.database.sqlite;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.CursorWindow;

public abstract class SQLiteClosable {
    private int mReferenceCount = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.270 -0400", hash_original_method = "9E030C88A072FD1CDF2911DCD18DDDBF", hash_generated_method = "9E030C88A072FD1CDF2911DCD18DDDBF")
        public SQLiteClosable ()
    {
    }


    protected abstract void onAllReferencesReleased();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.271 -0400", hash_original_method = "E024C98C9CCE430E2F2A96AB4D1C1206", hash_generated_method = "3847CCA86EF22D8030ACE2211D68342D")
    @DSModeled(DSC.SAFE)
    protected void onAllReferencesReleasedFromContainer() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.271 -0400", hash_original_method = "1061625992B0C8C116E9B0FDA746DD53", hash_generated_method = "E1C9E3F7C5F37E93374A232562C01032")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void acquireReference() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "attempt to re-open an already-closed object: " + getObjInfo());
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.272 -0400", hash_original_method = "9A856B4F8EE35DA89AAA5714CDA66263", hash_generated_method = "4A17BBD9A435ABAC8FFB392A51AB3C22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.272 -0400", hash_original_method = "09E098F074A456ED367ED67E041E3D74", hash_generated_method = "EE972F60D52976575418ABA56B93EE87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:46.273 -0400", hash_original_method = "DF04C7F4D466F671C367EF5E9F18369F", hash_generated_method = "46C56C5EBC27604577A6070C51916204")
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
        String var7886FFD5307B2368E4A89A54A82E532B_398196971 = (buff.toString());
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

