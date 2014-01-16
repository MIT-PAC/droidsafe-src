package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Pair;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.943 -0500", hash_original_field = "7A43BE15E30AAB677E00CA000B61133A", hash_generated_field = "23BA72495E1959CF9D5D5CA8183FBE7E")

    private static final String TAG = "DefaultDatabaseErrorHandler";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.957 -0400", hash_original_method = "896C9D78E64EAD9D50DC29D09D68C65A", hash_generated_method = "896C9D78E64EAD9D50DC29D09D68C65A")
    public DefaultDatabaseErrorHandler ()
    {
        //Synthesized constructor
    }

    /**
     * defines the default method to be invoked when database corruption is detected.
     * @param dbObj the {@link SQLiteDatabase} object representing the database on which corruption
     * is detected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.947 -0500", hash_original_method = "4074EC86E696A918C28D96A3FA80513A", hash_generated_method = "A534DEC657F3794646B757D69A82EF0B")
    
public void onCorruption(SQLiteDatabase dbObj) {
        Log.e(TAG, "Corruption reported by sqlite on database: " + dbObj.getPath());

        // is the corruption detected even before database could be 'opened'?
        if (!dbObj.isOpen()) {
            // database files are not even openable. delete this database file.
            // NOTE if the database has attached databases, then any of them could be corrupt.
            // and not deleting all of them could cause corrupted database file to remain and 
            // make the application crash on database open operation. To avoid this problem,
            // the application should provide its own {@link DatabaseErrorHandler} impl class
            // to delete ALL files of the database (including the attached databases).
            deleteDatabaseFile(dbObj.getPath());
            return;
        }

        List<Pair<String, String>> attachedDbs = null;
        try {
            // Close the database, which will cause subsequent operations to fail.
            // before that, get the attached database list first.
            try {
                attachedDbs = dbObj.getAttachedDbs();
            } catch (SQLiteException e) {
                /* ignore */
            }
            try {
                dbObj.close();
            } catch (SQLiteException e) {
                /* ignore */
            }
        } finally {
            // Delete all files of this corrupt database and/or attached databases
            if (attachedDbs != null) {
                for (Pair<String, String> p : attachedDbs) {
                    deleteDatabaseFile(p.second);
                }
            } else {
                // attachedDbs = null is possible when the database is so corrupt that even
                // "PRAGMA database_list;" also fails. delete the main database file
                deleteDatabaseFile(dbObj.getPath());
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:44.949 -0500", hash_original_method = "47DF5B8E2F3C355F760906ED9FB0475D", hash_generated_method = "39FC2F2C866EDC4F25097633E0CD189C")
    
private void deleteDatabaseFile(String fileName) {
        if (fileName.equalsIgnoreCase(":memory:") || fileName.trim().length() == 0) {
            return;
        }
        Log.e(TAG, "deleting the database file: " + fileName);
        try {
            new File(fileName).delete();
        } catch (Exception e) {
            /* print warning and ignore exception */
            Log.w(TAG, "delete failed: " + e.getMessage());
        }
    }
}

