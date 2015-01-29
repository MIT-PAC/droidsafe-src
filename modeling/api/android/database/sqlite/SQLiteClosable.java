package android.database.sqlite;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.CursorWindow;

public abstract class SQLiteClosable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.232 -0500", hash_original_field = "75771A365A5811FB0582BD66B20EC330", hash_generated_field = "DCE5AF4DC7C8F75088B97A64E4AB1192")

    private int mReferenceCount = 1;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:08.179 -0400", hash_original_method = "A9F6E0E907A2CB5A9B2E32487BA16D84", hash_generated_method = "A9F6E0E907A2CB5A9B2E32487BA16D84")
    public SQLiteClosable ()
    {
        //Synthesized constructor
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.235 -0500", hash_original_method = "FD90E275F743F61127A2FB1BCCAA6783", hash_generated_method = "30A897A9BCC5879ADA06C65F6AA46200")
    
protected abstract void onAllReferencesReleased();
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.237 -0500", hash_original_method = "E024C98C9CCE430E2F2A96AB4D1C1206", hash_generated_method = "715F697B7A80B9123BE58CD298232D0E")
    
protected void onAllReferencesReleasedFromContainer() {}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.239 -0500", hash_original_method = "1061625992B0C8C116E9B0FDA746DD53", hash_generated_method = "C4E2C81F722FB41F4EA6B90C56C0F937")
    
public void acquireReference() {
        synchronized(this) {
            if (mReferenceCount <= 0) {
                throw new IllegalStateException(
                        "attempt to re-open an already-closed object: " + getObjInfo());
            }
            mReferenceCount++;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.242 -0500", hash_original_method = "9A856B4F8EE35DA89AAA5714CDA66263", hash_generated_method = "5995B6F7B9E0CE6574260F5A0344F5FE")
    
public void releaseReference() {
        boolean refCountIsZero = false;
        synchronized(this) {
            refCountIsZero = --mReferenceCount == 0;
        }
        if (refCountIsZero) {
            onAllReferencesReleased();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.244 -0500", hash_original_method = "09E098F074A456ED367ED67E041E3D74", hash_generated_method = "42F2D0696021472DE618932FC94233F1")
    
public void releaseReferenceFromContainer() {
        boolean refCountIsZero = false;
        synchronized(this) {
            refCountIsZero = --mReferenceCount == 0;
        }
        if (refCountIsZero) {
            onAllReferencesReleasedFromContainer();
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:43.247 -0500", hash_original_method = "DF04C7F4D466F671C367EF5E9F18369F", hash_generated_method = "B7AD478023FCCE1AB5389FE7E43F8EC4")
    
private String getObjInfo() {
        StringBuilder buff = new StringBuilder();
        buff.append(this.getClass().getName());
        buff.append(" (");
        if (this instanceof SQLiteDatabase) {
            buff.append("database = ");
            buff.append(((SQLiteDatabase)this).getPath());
        } else if (this instanceof SQLiteProgram) {
            buff.append("mSql = ");
            buff.append(((SQLiteProgram)this).mSql);
        } else if (this instanceof CursorWindow) {
            buff.append("mStartPos = ");
            buff.append(((CursorWindow)this).getStartPosition());
        }
        buff.append(") ");
        return buff.toString();
    }
    
}

