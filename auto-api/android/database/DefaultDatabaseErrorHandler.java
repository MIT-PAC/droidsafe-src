package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.File;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private static final String TAG = "DefaultDatabaseErrorHandler";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.692 -0400", hash_original_method = "4074EC86E696A918C28D96A3FA80513A", hash_generated_method = "C8B9F9037AB2ED5C105DBDD4678A141E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onCorruption(SQLiteDatabase dbObj) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(dbObj.dsTaint);
        {
            boolean varCC82C5DB1413B99E1CCAB065EFAB5770_1226526329 = (!dbObj.isOpen());
            {
                deleteDatabaseFile(dbObj.getPath());
            } //End block
        } //End collapsed parenthetic
        List<Pair<String, String>> attachedDbs;
        attachedDbs = null;
        try 
        {
            try 
            {
                attachedDbs = dbObj.getAttachedDbs();
            } //End block
            catch (SQLiteException e)
            { }
            try 
            {
                dbObj.close();
            } //End block
            catch (SQLiteException e)
            { }
        } //End block
        finally 
        {
            {
                {
                    Iterator<Pair<String, String>> seatecAstronomy42 = attachedDbs.iterator();
                    seatecAstronomy42.hasNext();
                    Pair<String, String> p = seatecAstronomy42.next();
                    {
                        deleteDatabaseFile(p.second);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                deleteDatabaseFile(dbObj.getPath());
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:00.692 -0400", hash_original_method = "47DF5B8E2F3C355F760906ED9FB0475D", hash_generated_method = "F4799A1FCE7769221A1982842C59E341")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void deleteDatabaseFile(String fileName) {
        dsTaint.addTaint(fileName);
        {
            boolean var8E5C270C0C0207C35D217A26023CE022_878992565 = (fileName.equalsIgnoreCase(":memory:") || fileName.trim().length() == 0);
        } //End collapsed parenthetic
        try 
        {
            new File(fileName).delete();
        } //End block
        catch (Exception e)
        { }
        // ---------- Original Method ----------
        //if (fileName.equalsIgnoreCase(":memory:") || fileName.trim().length() == 0) {
            //return;
        //}
        //Log.e(TAG, "deleting the database file: " + fileName);
        //try {
            //new File(fileName).delete();
        //} catch (Exception e) {
            //Log.w(TAG, "delete failed: " + e.getMessage());
        //}
    }

    
}


