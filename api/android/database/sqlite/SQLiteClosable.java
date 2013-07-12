package android.database.sqlite;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.CursorWindow;

public abstract class SQLiteClosable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.533 -0400", hash_original_field = "0802B8E2DAE298D5C141DE08467D5410", hash_generated_field = "DCE5AF4DC7C8F75088B97A64E4AB1192")

    private int mReferenceCount = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.533 -0400", hash_original_method = "A9F6E0E907A2CB5A9B2E32487BA16D84", hash_generated_method = "A9F6E0E907A2CB5A9B2E32487BA16D84")
    public SQLiteClosable ()
    {
        
    }


    protected abstract void onAllReferencesReleased();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.533 -0400", hash_original_method = "E024C98C9CCE430E2F2A96AB4D1C1206", hash_generated_method = "3847CCA86EF22D8030ACE2211D68342D")
    protected void onAllReferencesReleasedFromContainer() {
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.534 -0400", hash_original_method = "1061625992B0C8C116E9B0FDA746DD53", hash_generated_method = "BA99D3E820A11052D91D1B8D8BA58DA6")
    public void acquireReference() {
        synchronized
(this)        {
    if(mReferenceCount <= 0)            
            {
                IllegalStateException varF1A2B69BBA8977AC92410E407EA77A50_182155985 = new IllegalStateException(
                        "attempt to re-open an already-closed object: " + getObjInfo());
                varF1A2B69BBA8977AC92410E407EA77A50_182155985.addTaint(taint);
                throw varF1A2B69BBA8977AC92410E407EA77A50_182155985;
            } 
            mReferenceCount++;
        } 
        
        
            
                
                        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.535 -0400", hash_original_method = "9A856B4F8EE35DA89AAA5714CDA66263", hash_generated_method = "60FD0B0C5835682C4BC2BE3A3BC65896")
    public void releaseReference() {
        boolean refCountIsZero = false;
        synchronized
(this)        {
            refCountIsZero = --mReferenceCount == 0;
        } 
    if(refCountIsZero)        
        {
            onAllReferencesReleased();
        } 
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.536 -0400", hash_original_method = "09E098F074A456ED367ED67E041E3D74", hash_generated_method = "D5ED093E91D9051E8879E840395CDAD2")
    public void releaseReferenceFromContainer() {
        boolean refCountIsZero = false;
        synchronized
(this)        {
            refCountIsZero = --mReferenceCount == 0;
        } 
    if(refCountIsZero)        
        {
            onAllReferencesReleasedFromContainer();
        } 
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.537 -0400", hash_original_method = "DF04C7F4D466F671C367EF5E9F18369F", hash_generated_method = "1460133C04008E8EFA9ABB46DE06988E")
    private String getObjInfo() {
        StringBuilder buff = new StringBuilder();
        buff.append(this.getClass().getName());
        buff.append(" (");
    if(this instanceof SQLiteDatabase)        
        {
            buff.append("database = ");
            buff.append(((SQLiteDatabase)this).getPath());
        } 
        else
    if(this instanceof SQLiteProgram)        
        {
            buff.append("mSql = ");
            buff.append(((SQLiteProgram)this).mSql);
        } 
        else
    if(this instanceof CursorWindow)        
        {
            buff.append("mStartPos = ");
            buff.append(((CursorWindow)this).getStartPosition());
        } 
        buff.append(") ");
String varA8F8BFF7B1F2F52B225C2C2411606CA3_974443847 =         buff.toString();
        varA8F8BFF7B1F2F52B225C2C2411606CA3_974443847.addTaint(taint);
        return varA8F8BFF7B1F2F52B225C2C2411606CA3_974443847;
        
        
        
        
        
            
            
        
            
            
        
            
            
        
        
        
    }

    
}

