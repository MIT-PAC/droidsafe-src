package android.database;

// Droidsafe Imports
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class CursorToBulkCursorAdaptor extends BulkCursorNative implements IBinder.DeathRecipient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.649 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.649 -0400", hash_original_field = "BE3ECC20597938A47D79DA54D6F5A5B3", hash_generated_field = "A729030D5DBB0175A438B51B5B1D1491")

    private String mProviderName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.649 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "C0BC6E9ED279A4CF6D17FF3227AF4CAD")

    private ContentObserverProxy mObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.649 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "33920F0BCDF13F29B9CC06EF8E2B2F17")

    private CrossProcessCursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.650 -0400", hash_original_field = "527A0C16C3D4F603E2378D6B58B5B412", hash_generated_field = "E8734D79A4BD19C7AB5E7CF160F0A9A7")

    private CursorWindow mFilledWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.651 -0400", hash_original_method = "DFFFDCE95BD5626A15621DE9255909D3", hash_generated_method = "AE9FC056E1B17F51A8F106F7774A5B69")
    public  CursorToBulkCursorAdaptor(Cursor cursor, IContentObserver observer,
            String providerName) {
        addTaint(observer.getTaint());
        if(cursor instanceof CrossProcessCursor)        
        {
            mCursor = (CrossProcessCursor)cursor;
        } //End block
        else
        {
            mCursor = new CrossProcessCursorWrapper(cursor);
        } //End block
        mProviderName = providerName;
        synchronized
(mLock)        {
            createAndRegisterObserverProxyLocked(observer);
        } //End block
        // ---------- Original Method ----------
        //if (cursor instanceof CrossProcessCursor) {
            //mCursor = (CrossProcessCursor)cursor;
        //} else {
            //mCursor = new CrossProcessCursorWrapper(cursor);
        //}
        //mProviderName = providerName;
        //synchronized (mLock) {
            //createAndRegisterObserverProxyLocked(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.653 -0400", hash_original_method = "AD579F119ED4886B2C182C86869C4CD9", hash_generated_method = "EFD48DFD6F9C42C2320A3B1F791B1BBC")
    private void closeFilledWindowLocked() {
        if(mFilledWindow != null)        
        {
            mFilledWindow.close();
            mFilledWindow = null;
        } //End block
        // ---------- Original Method ----------
        //if (mFilledWindow != null) {
            //mFilledWindow.close();
            //mFilledWindow = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.654 -0400", hash_original_method = "E626ABF61F7540C19BF105C7958133EC", hash_generated_method = "82B5740E59C4C3BEF8D6880381268902")
    private void disposeLocked() {
        if(mCursor != null)        
        {
            unregisterObserverProxyLocked();
            mCursor.close();
            mCursor = null;
        } //End block
        closeFilledWindowLocked();
        // ---------- Original Method ----------
        //if (mCursor != null) {
            //unregisterObserverProxyLocked();
            //mCursor.close();
            //mCursor = null;
        //}
        //closeFilledWindowLocked();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.655 -0400", hash_original_method = "18B24C6ABC409A0E548E21131FCA3F48", hash_generated_method = "BDC1AD82020E63DC33249D5D0E46751F")
    private void throwIfCursorIsClosed() {
        if(mCursor == null)        
        {
            StaleDataException var241EC54C1C02F408EBF48FDE17C24E97_782200518 = new StaleDataException("Attempted to access a cursor after it has been closed.");
            var241EC54C1C02F408EBF48FDE17C24E97_782200518.addTaint(taint);
            throw var241EC54C1C02F408EBF48FDE17C24E97_782200518;
        } //End block
        // ---------- Original Method ----------
        //if (mCursor == null) {
            //throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.656 -0400", hash_original_method = "C4AF1DDC0409484A2B59D555E10A97E5", hash_generated_method = "6FF863A09CEDF7753805E887E3D94A3B")
    @Override
    public void binderDied() {
        synchronized
(mLock)        {
            disposeLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //disposeLocked();
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.658 -0400", hash_original_method = "4ECB0E8EDFF03AFDCED1B443F780B12E", hash_generated_method = "6C829C1C0B864D696A3102C4DDCD4C1C")
    @Override
    public CursorWindow getWindow(int startPos) {
        addTaint(startPos);
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
            if(!mCursor.moveToPosition(startPos))            
            {
                closeFilledWindowLocked();
CursorWindow var540C13E9E156B687226421B24F2DF178_1255020163 =                 null;
                var540C13E9E156B687226421B24F2DF178_1255020163.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1255020163;
            } //End block
            CursorWindow window = mCursor.getWindow();
            if(window != null)            
            {
                closeFilledWindowLocked();
            } //End block
            else
            {
                window = mFilledWindow;
                if(window == null)                
                {
                    mFilledWindow = new CursorWindow(mProviderName);
                    window = mFilledWindow;
                    mCursor.fillWindow(startPos, window);
                } //End block
                else
                if(startPos < window.getStartPosition()
                        || startPos >= window.getStartPosition() + window.getNumRows())                
                {
                    window.clear();
                    mCursor.fillWindow(startPos, window);
                } //End block
            } //End block
            if(window != null)            
            {
                window.acquireReference();
            } //End block
CursorWindow var414B2CEBDF7E679ADF378DBBAB956EC0_2137587591 =             window;
            var414B2CEBDF7E679ADF378DBBAB956EC0_2137587591.addTaint(taint);
            return var414B2CEBDF7E679ADF378DBBAB956EC0_2137587591;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.660 -0400", hash_original_method = "4E23514B564E80A833367A4C9E43D15C", hash_generated_method = "6DCA5230DCF2AE94C135FA2F6891D417")
    @Override
    public void onMove(int position) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(position);
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
            mCursor.onMove(mCursor.getPosition(), position);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //mCursor.onMove(mCursor.getPosition(), position);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.660 -0400", hash_original_method = "DC4D033FD1BAE66931C8A4D6EEEA211D", hash_generated_method = "0E1A3B2705D55B39DDFA7172BF563036")
    @Override
    public int count() {
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
            int var75D1A080281180206349E970682A62F2_1369987906 = (mCursor.getCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992434885 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1992434885;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.661 -0400", hash_original_method = "51920E427207C9DB40FE51CEF3CF1E5F", hash_generated_method = "FE3A53C2E26D6C4415189C4ECDAF3A86")
    @Override
    public String[] getColumnNames() {
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
String[] varF8FF07705E74C2344D2EF0339BC7BE26_1479222050 =             mCursor.getColumnNames();
            varF8FF07705E74C2344D2EF0339BC7BE26_1479222050.addTaint(taint);
            return varF8FF07705E74C2344D2EF0339BC7BE26_1479222050;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getColumnNames();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.662 -0400", hash_original_method = "E8CA6D89EFD51007B93658764C0D15A1", hash_generated_method = "C8A3162FA05FA9B6B194E605A69AF8D3")
    @Override
    public void deactivate() {
        synchronized
(mLock)        {
            if(mCursor != null)            
            {
                unregisterObserverProxyLocked();
                mCursor.deactivate();
            } //End block
            closeFilledWindowLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //if (mCursor != null) {
                //unregisterObserverProxyLocked();
                //mCursor.deactivate();
            //}
            //closeFilledWindowLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.662 -0400", hash_original_method = "AC20EBAE7250AB68ABF5848E6A31630D", hash_generated_method = "43EC4774C116950FA821DA760807670F")
    @Override
    public void close() {
        synchronized
(mLock)        {
            disposeLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //disposeLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.664 -0400", hash_original_method = "C42BE5036A3BA050EE736974AEACDE99", hash_generated_method = "8E8A2DED8C1B82EBF73CCA2E777A0864")
    @Override
    public int requery(IContentObserver observer) {
        addTaint(observer.getTaint());
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
            closeFilledWindowLocked();
            try 
            {
                if(!mCursor.requery())                
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_1693568257 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408795673 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408795673;
                } //End block
            } //End block
            catch (IllegalStateException e)
            {
                IllegalStateException leakProgram = new IllegalStateException(
                        mProviderName + " Requery misuse db, mCursor isClosed:" +
                        mCursor.isClosed(), e);
                leakProgram.addTaint(taint);
                throw leakProgram;
            } //End block
            unregisterObserverProxyLocked();
            createAndRegisterObserverProxyLocked(observer);
            int var75D1A080281180206349E970682A62F2_1257256121 = (mCursor.getCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671561322 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1671561322;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //closeFilledWindowLocked();
            //try {
                //if (!mCursor.requery()) {
                    //return -1;
                //}
            //} catch (IllegalStateException e) {
                //IllegalStateException leakProgram = new IllegalStateException(
                        //mProviderName + " Requery misuse db, mCursor isClosed:" +
                        //mCursor.isClosed(), e);
                //throw leakProgram;
            //}
            //unregisterObserverProxyLocked();
            //createAndRegisterObserverProxyLocked(observer);
            //return mCursor.getCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.665 -0400", hash_original_method = "4EDF40CD28E1B076C101ED75649491F5", hash_generated_method = "7DCCFD7AA21E44B3A6E00695ABF3DA8C")
    @Override
    public boolean getWantsAllOnMoveCalls() {
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
            boolean varF2AEC4C640284983322BCF08D912C7EE_925135909 = (mCursor.getWantsAllOnMoveCalls());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664425606 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_664425606;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getWantsAllOnMoveCalls();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.666 -0400", hash_original_method = "1F751777DEFC6D435260F5703D7849F2", hash_generated_method = "20894FBD6BF872790CEEE482CFD43907")
    private void createAndRegisterObserverProxyLocked(IContentObserver observer) {
        if(mObserver != null)        
        {
            IllegalStateException var1B8FE5B98B04EEB3A1D884281849CE50_1811852796 = new IllegalStateException("an observer is already registered");
            var1B8FE5B98B04EEB3A1D884281849CE50_1811852796.addTaint(taint);
            throw var1B8FE5B98B04EEB3A1D884281849CE50_1811852796;
        } //End block
        mObserver = new ContentObserverProxy(observer, this);
        mCursor.registerContentObserver(mObserver);
        // ---------- Original Method ----------
        //if (mObserver != null) {
            //throw new IllegalStateException("an observer is already registered");
        //}
        //mObserver = new ContentObserverProxy(observer, this);
        //mCursor.registerContentObserver(mObserver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.667 -0400", hash_original_method = "8431B5C8F0968484F229748CA95CA0A8", hash_generated_method = "9C22600B7E70291A61594B31D26AD069")
    private void unregisterObserverProxyLocked() {
        if(mObserver != null)        
        {
            mCursor.unregisterContentObserver(mObserver);
            mObserver.unlinkToDeath(this);
            mObserver = null;
        } //End block
        // ---------- Original Method ----------
        //if (mObserver != null) {
            //mCursor.unregisterContentObserver(mObserver);
            //mObserver.unlinkToDeath(this);
            //mObserver = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.668 -0400", hash_original_method = "D70B44F91871C59AEA1A14E0E16BCFE5", hash_generated_method = "F27CC84A36F0DE54A763C7586F730391")
    @Override
    public Bundle getExtras() {
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
Bundle var9F26218347A1E5FAB3EDA37346898AB0_473273318 =             mCursor.getExtras();
            var9F26218347A1E5FAB3EDA37346898AB0_473273318.addTaint(taint);
            return var9F26218347A1E5FAB3EDA37346898AB0_473273318;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getExtras();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.669 -0400", hash_original_method = "7B57D96B3C93268C95F4ADF84D5A7417", hash_generated_method = "27B2D0C9D4ED256D33211E919213FAC2")
    @Override
    public Bundle respond(Bundle extras) {
        addTaint(extras.getTaint());
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
Bundle varB44D2A19DAE9C7C11B872C4BE3A24267_825410189 =             mCursor.respond(extras);
            varB44D2A19DAE9C7C11B872C4BE3A24267_825410189.addTaint(taint);
            return varB44D2A19DAE9C7C11B872C4BE3A24267_825410189;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.respond(extras);
        //}
    }

    
    private static final class ContentObserverProxy extends ContentObserver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.669 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "74D5AC8BC3A14B4C09214B5B5668899E")

        protected IContentObserver mRemote;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.670 -0400", hash_original_method = "319996A1B242CEE2610029D3C2CFA436", hash_generated_method = "E8EC5B4827AD900D4FBDB767EDFA2B6D")
        public  ContentObserverProxy(IContentObserver remoteObserver, DeathRecipient recipient) {
            super(null);
            addTaint(recipient.getTaint());
            mRemote = remoteObserver;
            try 
            {
                remoteObserver.asBinder().linkToDeath(recipient, 0);
            } //End block
            catch (RemoteException e)
            {
            } //End block
            // ---------- Original Method ----------
            //mRemote = remoteObserver;
            //try {
                //remoteObserver.asBinder().linkToDeath(recipient, 0);
            //} catch (RemoteException e) {
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.671 -0400", hash_original_method = "96222C4BC704270291C489EC7FF2AF65", hash_generated_method = "E2BACA8DF8B8B028AE61A7B685224CDE")
        public boolean unlinkToDeath(DeathRecipient recipient) {
            addTaint(recipient.getTaint());
            boolean var515E8CDA644F1FC6BE876B635F36354F_185016358 = (mRemote.asBinder().unlinkToDeath(recipient, 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1434892566 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1434892566;
            // ---------- Original Method ----------
            //return mRemote.asBinder().unlinkToDeath(recipient, 0);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.672 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "08591CA96C095C445B2594CDD6765E5E")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var68934A3E9455FA72420237EB05902327_935316388 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1216103573 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1216103573;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.672 -0400", hash_original_method = "288C053C9E4DFF84CBC0887DEC7513A2", hash_generated_method = "FB26B6C9695A6219183C4A64D40993F5")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(selfChange);
            try 
            {
                mRemote.onChange(selfChange);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
            // ---------- Original Method ----------
            //try {
                //mRemote.onChange(selfChange);
            //} catch (RemoteException ex) {
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:07.673 -0400", hash_original_field = "DC537D9C80C940A5B4FF394A8B2339AB", hash_generated_field = "C0008393E22A94FFD078F5CB06D7EC35")

    private static final String TAG = "Cursor";
}

