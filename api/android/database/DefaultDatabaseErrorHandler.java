package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.File;
import java.util.List;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;

public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.349 -0400", hash_original_method = "896C9D78E64EAD9D50DC29D09D68C65A", hash_generated_method = "896C9D78E64EAD9D50DC29D09D68C65A")
    public DefaultDatabaseErrorHandler ()
    {
        
    }


    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.350 -0400", hash_original_method = "4074EC86E696A918C28D96A3FA80513A", hash_generated_method = "9593A125A57B67579C3D7F63B84CA212")
    public void onCorruption(SQLiteDatabase dbObj) {
        
        addTaint(dbObj.getTaint());
    if(!dbObj.isOpen())        
        {
            deleteDatabaseFile(dbObj.getPath());
            return;
        } 
        List<Pair<String, String>> attachedDbs = null;
        try 
        {
            try 
            {
                attachedDbs = dbObj.getAttachedDbs();
            } 
            catch (SQLiteException e)
            {
            } 
            try 
            {
                dbObj.close();
            } 
            catch (SQLiteException e)
            {
            } 
        } 
        finally 
        {
    if(attachedDbs != null)            
            {
for(Pair<String, String> p : attachedDbs)
                {
                    deleteDatabaseFile(p.second);
                } 
            } 
            else
            {
                deleteDatabaseFile(dbObj.getPath());
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.350 -0400", hash_original_method = "47DF5B8E2F3C355F760906ED9FB0475D", hash_generated_method = "A95DA789E2F16824EB1FBA00E32B04E1")
    private void deleteDatabaseFile(String fileName) {
        addTaint(fileName.getTaint());
    if(fileName.equalsIgnoreCase(":memory:") || fileName.trim().length() == 0)        
        {
            return;
        } 
        try 
        {
            new File(fileName).delete();
        } 
        catch (Exception e)
        {
        } 
        
        
            
        
        
        
            
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.350 -0400", hash_original_field = "10759C745B09949ED080760414F4B85B", hash_generated_field = "23BA72495E1959CF9D5D5CA8183FBE7E")

    private static final String TAG = "DefaultDatabaseErrorHandler";
}

