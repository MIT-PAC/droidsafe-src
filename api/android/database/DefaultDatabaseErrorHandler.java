package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.990 -0400", hash_original_method = "896C9D78E64EAD9D50DC29D09D68C65A", hash_generated_method = "896C9D78E64EAD9D50DC29D09D68C65A")
    public DefaultDatabaseErrorHandler ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.998 -0400", hash_original_method = "4074EC86E696A918C28D96A3FA80513A", hash_generated_method = "E988A6815B999D47675C94CED188A047")
    public void onCorruption(SQLiteDatabase dbObj) {
        
        {
            boolean varCC82C5DB1413B99E1CCAB065EFAB5770_2122915704 = (!dbObj.isOpen());
            {
                deleteDatabaseFile(dbObj.getPath());
            } 
        } 
        List<Pair<String, String>> attachedDbs = null;
        try 
        {
            try 
            {
                attachedDbs = dbObj.getAttachedDbs();
            } 
            catch (SQLiteException e)
            { }
            try 
            {
                dbObj.close();
            } 
            catch (SQLiteException e)
            { }
        } 
        finally 
        {
            {
                {
                    Iterator<Pair<String, String>> varAB3CF8EE812F512696CBC54246C34449_2003576424 = (attachedDbs).iterator();
                    varAB3CF8EE812F512696CBC54246C34449_2003576424.hasNext();
                    Pair<String, String> p = varAB3CF8EE812F512696CBC54246C34449_2003576424.next();
                    {
                        deleteDatabaseFile(p.second);
                    } 
                } 
            } 
            {
                deleteDatabaseFile(dbObj.getPath());
            } 
        } 
        addTaint(dbObj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.999 -0400", hash_original_method = "47DF5B8E2F3C355F760906ED9FB0475D", hash_generated_method = "8080052BEF74FEB056F07D9539B55980")
    private void deleteDatabaseFile(String fileName) {
        {
            boolean var8E5C270C0C0207C35D217A26023CE022_1303810963 = (fileName.equalsIgnoreCase(":memory:") || fileName.trim().length() == 0);
        } 
        try 
        {
            new File(fileName).delete();
        } 
        catch (Exception e)
        { }
        addTaint(fileName.getTaint());
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:29.999 -0400", hash_original_field = "10759C745B09949ED080760414F4B85B", hash_generated_field = "23BA72495E1959CF9D5D5CA8183FBE7E")

    private static final String TAG = "DefaultDatabaseErrorHandler";
}

