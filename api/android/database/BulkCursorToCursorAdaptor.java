package android.database;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.998 -0400", hash_original_field = "DFCD77CC0FBBCE4763B1866A24A4CCFF", hash_generated_field = "1E15C10F775B223368F80DF5C8726D1A")

    private SelfContentObserver mObserverBridge = new SelfContentObserver(this);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.999 -0400", hash_original_field = "5E226C90629AB595B8588FEA451FAAAF", hash_generated_field = "9C921B869C896D2D1E8F32F098601C98")

    private IBulkCursor mBulkCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.999 -0400", hash_original_field = "4A5FC91463CC1EF00D3AA26340B946C6", hash_generated_field = "C71F96D16C33B34D6BB40030CD898648")

    private int mCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.999 -0400", hash_original_field = "11C985F30142FD30ACDDFE7CD3BD4A9B", hash_generated_field = "53DC72E56AF72859CCB6315DB649FC3E")

    private String[] mColumns;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:15.999 -0400", hash_original_field = "DDF7CB3D8C37186F6FE6C3046EEF714F", hash_generated_field = "09D230C6B972C5B44F7AE21F206E5D75")

    private boolean mWantsAllOnMoveCalls;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.000 -0400", hash_original_method = "579A2D9511CAAA6B79AA847929FD0E6D", hash_generated_method = "579A2D9511CAAA6B79AA847929FD0E6D")
    public BulkCursorToCursorAdaptor ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.001 -0400", hash_original_method = "BDEAB060DBF06B617753E5FD68DF3DA6", hash_generated_method = "CF17B3F2DAC2067844F40FF84CF8C685")
    public void initialize(IBulkCursor bulkCursor, int count, int idIndex,
            boolean wantsAllOnMoveCalls) {
        addTaint(idIndex);
        mBulkCursor = bulkCursor;
        mColumns = null;
        mCount = count;
        mRowIdColumnIndex = idIndex;
        mWantsAllOnMoveCalls = wantsAllOnMoveCalls;
        
        
        
        
        
        
    }

    
        public static int findRowIdColumnIndex(String[] columnNames) {
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            if (columnNames[i].equals("_id")) {
                return i;
            }
        }
        return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.001 -0400", hash_original_method = "7E3AA4478BE7164F626026375ACE354B", hash_generated_method = "2B03ECD5E1C36FA03AC508F89A579D51")
    public IContentObserver getObserver() {
IContentObserver var79B4C6682518603384B80B07D25B4279_1318970171 =         mObserverBridge.getContentObserver();
        var79B4C6682518603384B80B07D25B4279_1318970171.addTaint(taint);
        return var79B4C6682518603384B80B07D25B4279_1318970171;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.002 -0400", hash_original_method = "A0DC3D6282923B31FCC435384F5B1B63", hash_generated_method = "471E017D8C275266FB2B1ADF5AC3AA88")
    private void throwIfCursorIsClosed() {
    if(mBulkCursor == null)        
        {
            StaleDataException var241EC54C1C02F408EBF48FDE17C24E97_1893770721 = new StaleDataException("Attempted to access a cursor after it has been closed.");
            var241EC54C1C02F408EBF48FDE17C24E97_1893770721.addTaint(taint);
            throw var241EC54C1C02F408EBF48FDE17C24E97_1893770721;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.002 -0400", hash_original_method = "0E6B64C20F6304D897F9214656E1B9B2", hash_generated_method = "15AADBBD4BFCA1BCCEC302E97141582D")
    @Override
    public int getCount() {
        throwIfCursorIsClosed();
        int var4A5FC91463CC1EF00D3AA26340B946C6_528914145 = (mCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_336376915 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_336376915;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.003 -0400", hash_original_method = "A467CB6464BEC42A874BA0630DE4F114", hash_generated_method = "5FDAE91A1EDF61E7FC4F2BC5E5D27063")
    @Override
    public boolean onMove(int oldPosition, int newPosition) {
        
        addTaint(newPosition);
        addTaint(oldPosition);
        throwIfCursorIsClosed();
        try 
        {
    if(mWindow == null
                    || newPosition < mWindow.getStartPosition()
                    || newPosition >= mWindow.getStartPosition() + mWindow.getNumRows())            
            {
                setWindow(mBulkCursor.getWindow(newPosition));
            } 
            else
    if(mWantsAllOnMoveCalls)            
            {
                mBulkCursor.onMove(newPosition);
            } 
        } 
        catch (RemoteException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1669640994 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_192652764 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_192652764;
        } 
    if(mWindow == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_363667412 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1586838955 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1586838955;
        } 
        boolean varB326B5062B2F0E69046810717534CB09_2061549910 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1684463767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1684463767;
        
        
        
            
                    
                    
                
            
                
            
        
            
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.003 -0400", hash_original_method = "DCD3F558B41192D9CD395623901FE4A3", hash_generated_method = "ED7A593E1FCB5ECE9BD6FCEFF4B73CDD")
    @Override
    public void deactivate() {
        super.deactivate();
    if(mBulkCursor != null)        
        {
            try 
            {
                mBulkCursor.deactivate();
            } 
            catch (RemoteException ex)
            {
            } 
        } 
        
        
        
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.004 -0400", hash_original_method = "546597EB3DC3CEE4DD604F653491E5D5", hash_generated_method = "B726E89BEC8F15DFCCF0CB5B814DC12C")
    @Override
    public void close() {
        super.close();
    if(mBulkCursor != null)        
        {
            try 
            {
                mBulkCursor.close();
            } 
            catch (RemoteException ex)
            {
            } 
            finally 
            {
                mBulkCursor = null;
            } 
        } 
        
        
        
            
                
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.005 -0400", hash_original_method = "2BB8C0DB5A3CE31D75C859DF8A5992AB", hash_generated_method = "BDBEEC9DF9B39A61C8C91A042F031EC1")
    @Override
    public boolean requery() {
        throwIfCursorIsClosed();
        try 
        {
            mCount = mBulkCursor.requery(getObserver());
    if(mCount != -1)            
            {
                mPos = -1;
                closeWindow();
                super.requery();
                boolean varB326B5062B2F0E69046810717534CB09_1238598005 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_744538067 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_744538067;
            } 
            else
            {
                deactivate();
                boolean var68934A3E9455FA72420237EB05902327_1194340608 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1523271919 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1523271919;
            } 
        } 
        catch (Exception ex)
        {
            deactivate();
            boolean var68934A3E9455FA72420237EB05902327_3856915 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1975744410 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1975744410;
        } 
        
        
        
            
            
                
                
                
                
            
                
                
            
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.006 -0400", hash_original_method = "1A723D6E7321D209C1569AA4BBEA85AD", hash_generated_method = "3B0B458E9FA50B3473F3BF6C9404640D")
    @Override
    public String[] getColumnNames() {
        throwIfCursorIsClosed();
    if(mColumns == null)        
        {
            try 
            {
                mColumns = mBulkCursor.getColumnNames();
            } 
            catch (RemoteException ex)
            {
String[] var540C13E9E156B687226421B24F2DF178_1636749489 =                 null;
                var540C13E9E156B687226421B24F2DF178_1636749489.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1636749489;
            } 
        } 
String[] varD3E6185118B69354C5CA1E2493E0C19D_1079731183 =         mColumns;
        varD3E6185118B69354C5CA1E2493E0C19D_1079731183.addTaint(taint);
        return varD3E6185118B69354C5CA1E2493E0C19D_1079731183;
        
        
        
            
                
            
                
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.006 -0400", hash_original_method = "5109D579D87DF77312539D6DDC351AB2", hash_generated_method = "4620EF584F69894E5FD9C80DDC9BA6A0")
    @Override
    public Bundle getExtras() {
        throwIfCursorIsClosed();
        try 
        {
Bundle varC9D220A55BC9FCE6E848D4BF5278F31D_2101728474 =             mBulkCursor.getExtras();
            varC9D220A55BC9FCE6E848D4BF5278F31D_2101728474.addTaint(taint);
            return varC9D220A55BC9FCE6E848D4BF5278F31D_2101728474;
        } 
        catch (RemoteException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1011501676 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1011501676.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1011501676;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.008 -0400", hash_original_method = "EAE7773B95560E382A302B739F6438AF", hash_generated_method = "0EC1AA2494B840D129421A63A640A894")
    @Override
    public Bundle respond(Bundle extras) {
        addTaint(extras.getTaint());
        throwIfCursorIsClosed();
        try 
        {
Bundle varDA852F898B244A7E1232C20D0C2D350D_1675579451 =             mBulkCursor.respond(extras);
            varDA852F898B244A7E1232C20D0C2D350D_1675579451.addTaint(taint);
            return varDA852F898B244A7E1232C20D0C2D350D_1675579451;
        } 
        catch (RemoteException e)
        {
Bundle var998437625BBF03281B97467174D26383_1353462489 =             Bundle.EMPTY;
            var998437625BBF03281B97467174D26383_1353462489.addTaint(taint);
            return var998437625BBF03281B97467174D26383_1353462489;
        } 
        
        
        
            
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.009 -0400", hash_original_field = "5C21103A672655DA3072B23ECCA325CD", hash_generated_field = "ADC0FCD54016ADA5A4BD1654F2DAEC28")

    private static final String TAG = "BulkCursor";
}

