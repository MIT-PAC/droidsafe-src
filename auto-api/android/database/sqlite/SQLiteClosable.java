package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.database.CursorWindow;

public abstract class SQLiteClosable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.130 -0400", hash_original_field = "0802B8E2DAE298D5C141DE08467D5410", hash_generated_field = "DCE5AF4DC7C8F75088B97A64E4AB1192")

    private int mReferenceCount = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.130 -0400", hash_original_method = "A9F6E0E907A2CB5A9B2E32487BA16D84", hash_generated_method = "A9F6E0E907A2CB5A9B2E32487BA16D84")
    public SQLiteClosable ()
    {
        
    }


    protected abstract void onAllReferencesReleased();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.131 -0400", hash_original_method = "E024C98C9CCE430E2F2A96AB4D1C1206", hash_generated_method = "3847CCA86EF22D8030ACE2211D68342D")
    protected void onAllReferencesReleasedFromContainer() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.131 -0400", hash_original_method = "1061625992B0C8C116E9B0FDA746DD53", hash_generated_method = "E1C9E3F7C5F37E93374A232562C01032")
    public void acquireReference() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "attempt to re-open an already-closed object: " + getObjInfo());
            } 
        } 
        
        
            
                
                        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.132 -0400", hash_original_method = "9A856B4F8EE35DA89AAA5714CDA66263", hash_generated_method = "2CD3E8E71FB06394EDEC404E3ED7ADF3")
    public void releaseReference() {
        boolean refCountIsZero = false;
        {
            refCountIsZero = --mReferenceCount == 0;
        } 
        {
            onAllReferencesReleased();
        } 
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.132 -0400", hash_original_method = "09E098F074A456ED367ED67E041E3D74", hash_generated_method = "516D4CD236DADE9C46471246AD377223")
    public void releaseReferenceFromContainer() {
        boolean refCountIsZero = false;
        {
            refCountIsZero = --mReferenceCount == 0;
        } 
        {
            onAllReferencesReleasedFromContainer();
        } 
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:30.133 -0400", hash_original_method = "DF04C7F4D466F671C367EF5E9F18369F", hash_generated_method = "38CDD69B47A928CD1BD0F69A64786356")
    private String getObjInfo() {
        String varB4EAC82CA7396A68D541C85D26508E83_576556473 = null; 
        StringBuilder buff = new StringBuilder();
        buff.append(this.getClass().getName());
        buff.append(" (");
        {
            buff.append("database = ");
            buff.append(((SQLiteDatabase)this).getPath());
        } 
        {
            buff.append("mSql = ");
            buff.append(((SQLiteProgram)this).mSql);
        } 
        {
            buff.append("mStartPos = ");
            buff.append(((CursorWindow)this).getStartPosition());
        } 
        buff.append(") ");
        varB4EAC82CA7396A68D541C85D26508E83_576556473 = buff.toString();
        varB4EAC82CA7396A68D541C85D26508E83_576556473.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_576556473;
        
        
        
        
        
            
            
        
            
            
        
            
            
        
        
        
    }

    
}

