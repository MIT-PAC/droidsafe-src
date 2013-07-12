package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public final class CursorToBulkCursorAdaptor extends BulkCursorNative implements IBinder.DeathRecipient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.089 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "E59081251AD157907AA4CE8B3D8E654E")

    private final Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.089 -0400", hash_original_field = "BE3ECC20597938A47D79DA54D6F5A5B3", hash_generated_field = "A729030D5DBB0175A438B51B5B1D1491")

    private String mProviderName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.089 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "C0BC6E9ED279A4CF6D17FF3227AF4CAD")

    private ContentObserverProxy mObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.089 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "33920F0BCDF13F29B9CC06EF8E2B2F17")

    private CrossProcessCursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.090 -0400", hash_original_field = "527A0C16C3D4F603E2378D6B58B5B412", hash_generated_field = "E8734D79A4BD19C7AB5E7CF160F0A9A7")

    private CursorWindow mFilledWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.092 -0400", hash_original_method = "DFFFDCE95BD5626A15621DE9255909D3", hash_generated_method = "AE9FC056E1B17F51A8F106F7774A5B69")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.093 -0400", hash_original_method = "AD579F119ED4886B2C182C86869C4CD9", hash_generated_method = "EFD48DFD6F9C42C2320A3B1F791B1BBC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.094 -0400", hash_original_method = "E626ABF61F7540C19BF105C7958133EC", hash_generated_method = "82B5740E59C4C3BEF8D6880381268902")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.096 -0400", hash_original_method = "18B24C6ABC409A0E548E21131FCA3F48", hash_generated_method = "97230D383B279549C96B3E1CCC232A8F")
    private void throwIfCursorIsClosed() {
    if(mCursor == null)        
        {
            StaleDataException var241EC54C1C02F408EBF48FDE17C24E97_2084541947 = new StaleDataException("Attempted to access a cursor after it has been closed.");
            var241EC54C1C02F408EBF48FDE17C24E97_2084541947.addTaint(taint);
            throw var241EC54C1C02F408EBF48FDE17C24E97_2084541947;
        } //End block
        // ---------- Original Method ----------
        //if (mCursor == null) {
            //throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.096 -0400", hash_original_method = "C4AF1DDC0409484A2B59D555E10A97E5", hash_generated_method = "6FF863A09CEDF7753805E887E3D94A3B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.097 -0400", hash_original_method = "4ECB0E8EDFF03AFDCED1B443F780B12E", hash_generated_method = "521ECE19EBBDE4B1240EE3F708DD5A64")
    @Override
    public CursorWindow getWindow(int startPos) {
        addTaint(startPos);
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
    if(!mCursor.moveToPosition(startPos))            
            {
                closeFilledWindowLocked();
CursorWindow var540C13E9E156B687226421B24F2DF178_710724339 =                 null;
                var540C13E9E156B687226421B24F2DF178_710724339.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_710724339;
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
CursorWindow var414B2CEBDF7E679ADF378DBBAB956EC0_1954555286 =             window;
            var414B2CEBDF7E679ADF378DBBAB956EC0_1954555286.addTaint(taint);
            return var414B2CEBDF7E679ADF378DBBAB956EC0_1954555286;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.098 -0400", hash_original_method = "4E23514B564E80A833367A4C9E43D15C", hash_generated_method = "6DCA5230DCF2AE94C135FA2F6891D417")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.099 -0400", hash_original_method = "DC4D033FD1BAE66931C8A4D6EEEA211D", hash_generated_method = "16C0DF3B60A3ED77089A31E2E91E981B")
    @Override
    public int count() {
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
            int var75D1A080281180206349E970682A62F2_1653540609 = (mCursor.getCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259720218 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259720218;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.099 -0400", hash_original_method = "51920E427207C9DB40FE51CEF3CF1E5F", hash_generated_method = "D978B85292E5BCAF697F65CD745FA619")
    @Override
    public String[] getColumnNames() {
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
String[] varF8FF07705E74C2344D2EF0339BC7BE26_465712313 =             mCursor.getColumnNames();
            varF8FF07705E74C2344D2EF0339BC7BE26_465712313.addTaint(taint);
            return varF8FF07705E74C2344D2EF0339BC7BE26_465712313;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getColumnNames();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.099 -0400", hash_original_method = "E8CA6D89EFD51007B93658764C0D15A1", hash_generated_method = "C8A3162FA05FA9B6B194E605A69AF8D3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.100 -0400", hash_original_method = "AC20EBAE7250AB68ABF5848E6A31630D", hash_generated_method = "43EC4774C116950FA821DA760807670F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.100 -0400", hash_original_method = "C42BE5036A3BA050EE736974AEACDE99", hash_generated_method = "6283A4968CFA32D13777C6662B7E1873")
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
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_2048825779 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_544565175 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_544565175;
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
            int var75D1A080281180206349E970682A62F2_1483721694 = (mCursor.getCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109308031 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2109308031;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.101 -0400", hash_original_method = "4EDF40CD28E1B076C101ED75649491F5", hash_generated_method = "0F42C392B0C2F846239342A4A5023A42")
    @Override
    public boolean getWantsAllOnMoveCalls() {
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
            boolean varF2AEC4C640284983322BCF08D912C7EE_1485281217 = (mCursor.getWantsAllOnMoveCalls());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1766368232 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1766368232;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getWantsAllOnMoveCalls();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.101 -0400", hash_original_method = "1F751777DEFC6D435260F5703D7849F2", hash_generated_method = "DE647E410A1B1FA8B1BE3B4C27E131FA")
    private void createAndRegisterObserverProxyLocked(IContentObserver observer) {
    if(mObserver != null)        
        {
            IllegalStateException var1B8FE5B98B04EEB3A1D884281849CE50_53214702 = new IllegalStateException("an observer is already registered");
            var1B8FE5B98B04EEB3A1D884281849CE50_53214702.addTaint(taint);
            throw var1B8FE5B98B04EEB3A1D884281849CE50_53214702;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.102 -0400", hash_original_method = "8431B5C8F0968484F229748CA95CA0A8", hash_generated_method = "9C22600B7E70291A61594B31D26AD069")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.103 -0400", hash_original_method = "D70B44F91871C59AEA1A14E0E16BCFE5", hash_generated_method = "BE0267F9BDE43CBACC5E2A0124025323")
    @Override
    public Bundle getExtras() {
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
Bundle var9F26218347A1E5FAB3EDA37346898AB0_18022931 =             mCursor.getExtras();
            var9F26218347A1E5FAB3EDA37346898AB0_18022931.addTaint(taint);
            return var9F26218347A1E5FAB3EDA37346898AB0_18022931;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getExtras();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.103 -0400", hash_original_method = "7B57D96B3C93268C95F4ADF84D5A7417", hash_generated_method = "38CD1D333432AED7808ED9AF8E0B299C")
    @Override
    public Bundle respond(Bundle extras) {
        addTaint(extras.getTaint());
        synchronized
(mLock)        {
            throwIfCursorIsClosed();
Bundle varB44D2A19DAE9C7C11B872C4BE3A24267_971310098 =             mCursor.respond(extras);
            varB44D2A19DAE9C7C11B872C4BE3A24267_971310098.addTaint(taint);
            return varB44D2A19DAE9C7C11B872C4BE3A24267_971310098;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.respond(extras);
        //}
    }

    
    private static final class ContentObserverProxy extends ContentObserver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.104 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "74D5AC8BC3A14B4C09214B5B5668899E")

        protected IContentObserver mRemote;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.104 -0400", hash_original_method = "319996A1B242CEE2610029D3C2CFA436", hash_generated_method = "E8EC5B4827AD900D4FBDB767EDFA2B6D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.105 -0400", hash_original_method = "96222C4BC704270291C489EC7FF2AF65", hash_generated_method = "B77E8A9B48689A41029BCC88B61AE230")
        public boolean unlinkToDeath(DeathRecipient recipient) {
            addTaint(recipient.getTaint());
            boolean var515E8CDA644F1FC6BE876B635F36354F_1173446209 = (mRemote.asBinder().unlinkToDeath(recipient, 0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1625397100 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1625397100;
            // ---------- Original Method ----------
            //return mRemote.asBinder().unlinkToDeath(recipient, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.105 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "DF3C064C47AC49393F42D4E71739C248")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var68934A3E9455FA72420237EB05902327_1118943695 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_970249488 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_970249488;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.105 -0400", hash_original_method = "288C053C9E4DFF84CBC0887DEC7513A2", hash_generated_method = "FB26B6C9695A6219183C4A64D40993F5")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:16.106 -0400", hash_original_field = "DC537D9C80C940A5B4FF394A8B2339AB", hash_generated_field = "C0008393E22A94FFD078F5CB06D7EC35")

    private static final String TAG = "Cursor";
}

