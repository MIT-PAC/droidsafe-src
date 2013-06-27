package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public final class CursorToBulkCursorAdaptor extends BulkCursorNative implements IBinder.DeathRecipient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.163 -0400", hash_original_field = "B89DEBA2CB26B1AC973763E3E152017B", hash_generated_field = "C8F8FCD335E09ED70E70801AB39A894A")

    private Object mLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.163 -0400", hash_original_field = "BE3ECC20597938A47D79DA54D6F5A5B3", hash_generated_field = "A729030D5DBB0175A438B51B5B1D1491")

    private String mProviderName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.163 -0400", hash_original_field = "C61FA2E7C36AC7AB9C40A5C4B482DC3A", hash_generated_field = "C0BC6E9ED279A4CF6D17FF3227AF4CAD")

    private ContentObserverProxy mObserver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.163 -0400", hash_original_field = "F54BB255BEA99BFE91A331B490610EDF", hash_generated_field = "33920F0BCDF13F29B9CC06EF8E2B2F17")

    private CrossProcessCursor mCursor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.163 -0400", hash_original_field = "527A0C16C3D4F603E2378D6B58B5B412", hash_generated_field = "E8734D79A4BD19C7AB5E7CF160F0A9A7")

    private CursorWindow mFilledWindow;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.185 -0400", hash_original_method = "DFFFDCE95BD5626A15621DE9255909D3", hash_generated_method = "293445B9CBC82303AB5645F5814EC7E4")
    public  CursorToBulkCursorAdaptor(Cursor cursor, IContentObserver observer,
            String providerName) {
        {
            mCursor = (CrossProcessCursor)cursor;
        } //End block
        {
            mCursor = new CrossProcessCursorWrapper(cursor);
        } //End block
        mProviderName = providerName;
        {
            createAndRegisterObserverProxyLocked(observer);
        } //End block
        addTaint(observer.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.186 -0400", hash_original_method = "AD579F119ED4886B2C182C86869C4CD9", hash_generated_method = "C0A1ED446740574B689012835A978650")
    private void closeFilledWindowLocked() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.195 -0400", hash_original_method = "E626ABF61F7540C19BF105C7958133EC", hash_generated_method = "FC6E01A149851342D11F794232C93227")
    private void disposeLocked() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.196 -0400", hash_original_method = "18B24C6ABC409A0E548E21131FCA3F48", hash_generated_method = "52590B2688227D4F3CDE916B839BBFBF")
    private void throwIfCursorIsClosed() {
        {
            if (DroidSafeAndroidRuntime.control) throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        } //End block
        // ---------- Original Method ----------
        //if (mCursor == null) {
            //throw new StaleDataException("Attempted to access a cursor after it has been closed.");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.196 -0400", hash_original_method = "C4AF1DDC0409484A2B59D555E10A97E5", hash_generated_method = "7811CE0DF771F7DCC608E68A68E599FA")
    @Override
    public void binderDied() {
        {
            disposeLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //disposeLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.228 -0400", hash_original_method = "4ECB0E8EDFF03AFDCED1B443F780B12E", hash_generated_method = "E50968BEEC61A44FE41CE2CDD6910D97")
    @Override
    public CursorWindow getWindow(int startPos) {
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_631377728 = null; //Variable for return #1
        CursorWindow varB4EAC82CA7396A68D541C85D26508E83_1737357474 = null; //Variable for return #2
        {
            throwIfCursorIsClosed();
            {
                boolean var04D558ECAB1E17991563926E69879491_981759185 = (!mCursor.moveToPosition(startPos));
                {
                    closeFilledWindowLocked();
                    varB4EAC82CA7396A68D541C85D26508E83_631377728 = null;
                } //End block
            } //End collapsed parenthetic
            CursorWindow window;
            window = mCursor.getWindow();
            {
                closeFilledWindowLocked();
            } //End block
            {
                window = mFilledWindow;
                {
                    mFilledWindow = new CursorWindow(mProviderName);
                    window = mFilledWindow;
                    mCursor.fillWindow(startPos, window);
                } //End block
                {
                    boolean varC97F342FBEDA56BA63E8F208810D5BA4_767187474 = (startPos < window.getStartPosition()
                        || startPos >= window.getStartPosition() + window.getNumRows());
                    {
                        window.clear();
                        mCursor.fillWindow(startPos, window);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                window.acquireReference();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1737357474 = window;
        } //End block
        addTaint(startPos);
        CursorWindow varA7E53CE21691AB073D9660D615818899_186958753; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_186958753 = varB4EAC82CA7396A68D541C85D26508E83_631377728;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_186958753 = varB4EAC82CA7396A68D541C85D26508E83_1737357474;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_186958753.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_186958753;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.229 -0400", hash_original_method = "4E23514B564E80A833367A4C9E43D15C", hash_generated_method = "237C6D1805DC54AE0BDEBF73E6445E37")
    @Override
    public void onMove(int position) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            throwIfCursorIsClosed();
            mCursor.onMove(mCursor.getPosition(), position);
        } //End block
        addTaint(position);
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //mCursor.onMove(mCursor.getPosition(), position);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.233 -0400", hash_original_method = "DC4D033FD1BAE66931C8A4D6EEEA211D", hash_generated_method = "F80C714C0C26387BFD243F2FCC9CEAB8")
    @Override
    public int count() {
        {
            throwIfCursorIsClosed();
            int varA0B4CA491E47E321D82FB34DD7E77E5A_1061991485 = (mCursor.getCount());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684008092 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_684008092;
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.239 -0400", hash_original_method = "51920E427207C9DB40FE51CEF3CF1E5F", hash_generated_method = "CF976DA79AF63E30ECE65FCD996A96C1")
    @Override
    public String[] getColumnNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1765028352 = null; //Variable for return #1
        {
            throwIfCursorIsClosed();
            varB4EAC82CA7396A68D541C85D26508E83_1765028352 = mCursor.getColumnNames();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1765028352.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1765028352;
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getColumnNames();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.247 -0400", hash_original_method = "E8CA6D89EFD51007B93658764C0D15A1", hash_generated_method = "4301E443B96F110B0EDD6EDBEB212BEE")
    @Override
    public void deactivate() {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.255 -0400", hash_original_method = "AC20EBAE7250AB68ABF5848E6A31630D", hash_generated_method = "66209B28B9295F964E905A06C3A39A02")
    @Override
    public void close() {
        {
            disposeLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //disposeLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.260 -0400", hash_original_method = "C42BE5036A3BA050EE736974AEACDE99", hash_generated_method = "B37B7901688F6DAEE0E91EAEEE8B4BBA")
    @Override
    public int requery(IContentObserver observer) {
        {
            throwIfCursorIsClosed();
            closeFilledWindowLocked();
            try 
            {
                {
                    boolean var9F860FB704DE0324D019EBF4330135F9_1492903295 = (!mCursor.requery());
                } //End collapsed parenthetic
            } //End block
            catch (IllegalStateException e)
            {
                IllegalStateException leakProgram;
                leakProgram = new IllegalStateException(
                        mProviderName + " Requery misuse db, mCursor isClosed:" +
                        mCursor.isClosed(), e);
                if (DroidSafeAndroidRuntime.control) throw leakProgram;
            } //End block
            unregisterObserverProxyLocked();
            createAndRegisterObserverProxyLocked(observer);
            int varA0B4CA491E47E321D82FB34DD7E77E5A_1867093126 = (mCursor.getCount());
        } //End block
        addTaint(observer.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1856053143 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1856053143;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.287 -0400", hash_original_method = "4EDF40CD28E1B076C101ED75649491F5", hash_generated_method = "FCE41F32082D63E5E8BF769E781A7770")
    @Override
    public boolean getWantsAllOnMoveCalls() {
        {
            throwIfCursorIsClosed();
            boolean varA4ACC3F53F22F27EF64482D87EFB3327_1009344011 = (mCursor.getWantsAllOnMoveCalls());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1189636442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1189636442;
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getWantsAllOnMoveCalls();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.288 -0400", hash_original_method = "1F751777DEFC6D435260F5703D7849F2", hash_generated_method = "828BF5D91675AC33AE1B129624AC2408")
    private void createAndRegisterObserverProxyLocked(IContentObserver observer) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("an observer is already registered");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.292 -0400", hash_original_method = "8431B5C8F0968484F229748CA95CA0A8", hash_generated_method = "5059298AAFCE2E73868DD161EF14E61F")
    private void unregisterObserverProxyLocked() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.293 -0400", hash_original_method = "D70B44F91871C59AEA1A14E0E16BCFE5", hash_generated_method = "8ECF0331B0AD46C1DE4DAE75DCC43B6D")
    @Override
    public Bundle getExtras() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1364330085 = null; //Variable for return #1
        {
            throwIfCursorIsClosed();
            varB4EAC82CA7396A68D541C85D26508E83_1364330085 = mCursor.getExtras();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1364330085.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1364330085;
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.getExtras();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.294 -0400", hash_original_method = "7B57D96B3C93268C95F4ADF84D5A7417", hash_generated_method = "0BB1251847339226D51F2293F8BEF5F9")
    @Override
    public Bundle respond(Bundle extras) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1964344400 = null; //Variable for return #1
        {
            throwIfCursorIsClosed();
            varB4EAC82CA7396A68D541C85D26508E83_1964344400 = mCursor.respond(extras);
        } //End block
        addTaint(extras.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1964344400.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1964344400;
        // ---------- Original Method ----------
        //synchronized (mLock) {
            //throwIfCursorIsClosed();
            //return mCursor.respond(extras);
        //}
    }

    
    private static final class ContentObserverProxy extends ContentObserver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.301 -0400", hash_original_field = "571FFBF4D13799B98890AF05D7751D0E", hash_generated_field = "74D5AC8BC3A14B4C09214B5B5668899E")

        protected IContentObserver mRemote;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.306 -0400", hash_original_method = "319996A1B242CEE2610029D3C2CFA436", hash_generated_method = "84C77E41FEEBF0005DD8AE7EB49A1435")
        public  ContentObserverProxy(IContentObserver remoteObserver, DeathRecipient recipient) {
            super(null);
            mRemote = remoteObserver;
            try 
            {
                remoteObserver.asBinder().linkToDeath(recipient, 0);
            } //End block
            catch (RemoteException e)
            { }
            addTaint(recipient.getTaint());
            // ---------- Original Method ----------
            //mRemote = remoteObserver;
            //try {
                //remoteObserver.asBinder().linkToDeath(recipient, 0);
            //} catch (RemoteException e) {
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.307 -0400", hash_original_method = "96222C4BC704270291C489EC7FF2AF65", hash_generated_method = "0F052980845A25A411365AF4D9784742")
        public boolean unlinkToDeath(DeathRecipient recipient) {
            boolean var9B7D13AFC7CC219CF51B2ED7350C5633_1755690049 = (mRemote.asBinder().unlinkToDeath(recipient, 0));
            addTaint(recipient.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_414272805 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_414272805;
            // ---------- Original Method ----------
            //return mRemote.asBinder().unlinkToDeath(recipient, 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.308 -0400", hash_original_method = "A5B2D8696143266ED24B145CF029F206", hash_generated_method = "3424E5C28C7CBBD6A74CBA82911A2062")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42278723 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_42278723;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.309 -0400", hash_original_method = "288C053C9E4DFF84CBC0887DEC7513A2", hash_generated_method = "D2A5886C48C692BDC8474CF4CBF28E57")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            try 
            {
                mRemote.onChange(selfChange);
            } //End block
            catch (RemoteException ex)
            { }
            addTaint(selfChange);
            // ---------- Original Method ----------
            //try {
                //mRemote.onChange(selfChange);
            //} catch (RemoteException ex) {
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.309 -0400", hash_original_field = "DC537D9C80C940A5B4FF394A8B2339AB", hash_generated_field = "83D8F62B166FF393281884A03CF64D6D")

    private static String TAG = "Cursor";
}

