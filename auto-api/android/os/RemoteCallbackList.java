package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;

public class RemoteCallbackList<E extends IInterface> {
    HashMap<IBinder, Callback> mCallbacks
            = new HashMap<IBinder, Callback>();
    private Object[] mActiveBroadcast;
    private int mBroadcastCount = -1;
    private boolean mKilled = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.154 -0400", hash_original_method = "58CDB6D576D43F8535C3404B35223CED", hash_generated_method = "58CDB6D576D43F8535C3404B35223CED")
        public RemoteCallbackList ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.155 -0400", hash_original_method = "46F1FD6FBAE5A826BE086BA154A601C8", hash_generated_method = "683FB40CB1EB97CBE08961B0FD29D768")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean register(E callback) {
        dsTaint.addTaint(callback.dsTaint);
        boolean varBDBB33B5D7C0AC8FAE2D3B9C46063DFE_201104176 = (register(callback, null));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return register(callback, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.155 -0400", hash_original_method = "228836B43DD98CF5855A1427021AF94C", hash_generated_method = "CC28DBCDE52CAEFBD7E51644B2954EB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean register(E callback, Object cookie) {
        dsTaint.addTaint(cookie.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        {
            IBinder binder;
            binder = callback.asBinder();
            try 
            {
                Callback cb;
                cb = new Callback(callback, cookie);
                binder.linkToDeath(cb, 0);
                mCallbacks.put(binder, cb);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mCallbacks) {
            //if (mKilled) {
                //return false;
            //}
            //IBinder binder = callback.asBinder();
            //try {
                //Callback cb = new Callback(callback, cookie);
                //binder.linkToDeath(cb, 0);
                //mCallbacks.put(binder, cb);
                //return true;
            //} catch (RemoteException e) {
                //return false;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.156 -0400", hash_original_method = "E94D872448628F2BAA0FD192A750EA6D", hash_generated_method = "08D98DE63D6168D050F632519F1132FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean unregister(E callback) {
        dsTaint.addTaint(callback.dsTaint);
        {
            Callback cb;
            cb = mCallbacks.remove(callback.asBinder());
            {
                cb.mCallback.asBinder().unlinkToDeath(cb, 0);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mCallbacks) {
            //Callback cb = mCallbacks.remove(callback.asBinder());
            //if (cb != null) {
                //cb.mCallback.asBinder().unlinkToDeath(cb, 0);
                //return true;
            //}
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.161 -0400", hash_original_method = "143F9A34B740B6676238190B04E5358A", hash_generated_method = "181302555077E9F23716BB9DEA058111")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void kill() {
        {
            {
                Iterator<Callback> var5D52E140987DCF0A2A1B652E3C6CD766_1573358255 = (mCallbacks.values()).iterator();
                var5D52E140987DCF0A2A1B652E3C6CD766_1573358255.hasNext();
                Callback cb = var5D52E140987DCF0A2A1B652E3C6CD766_1573358255.next();
                {
                    cb.mCallback.asBinder().unlinkToDeath(cb, 0);
                } //End block
            } //End collapsed parenthetic
            mCallbacks.clear();
            mKilled = true;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mCallbacks) {
            //for (Callback cb : mCallbacks.values()) {
                //cb.mCallback.asBinder().unlinkToDeath(cb, 0);
            //}
            //mCallbacks.clear();
            //mKilled = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.161 -0400", hash_original_method = "B434989CEB936B9194BF8BFB60F8F696", hash_generated_method = "419F71AAF45429AFBDEF0A1376D5416D")
    @DSModeled(DSC.SAFE)
    public void onCallbackDied(E callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(callback.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.162 -0400", hash_original_method = "0963A4798BF8140F1109AA736DE1F9A0", hash_generated_method = "34E8AEEB1A0CA3ECB648C5C8C9C012CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onCallbackDied(E callback, Object cookie) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(cookie.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        onCallbackDied(callback);
        // ---------- Original Method ----------
        //onCallbackDied(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.173 -0400", hash_original_method = "1FD0E6F07E109275C9353B8621589475", hash_generated_method = "CC2B04557B84498D82C3ECC2FE2EB7E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int beginBroadcast() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "beginBroadcast() called while already in a broadcast");
            } //End block
            int N;
            N = mBroadcastCount = mCallbacks.size();
            Object[] active;
            active = mActiveBroadcast;
            {
                mActiveBroadcast = active = new Object[N];
            } //End block
            int i;
            i = 0;
            {
                Iterator<Callback> var5D52E140987DCF0A2A1B652E3C6CD766_447877376 = (mCallbacks.values()).iterator();
                var5D52E140987DCF0A2A1B652E3C6CD766_447877376.hasNext();
                Callback cb = var5D52E140987DCF0A2A1B652E3C6CD766_447877376.next();
                {
                    active[i++] = cb;
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mCallbacks) {
            //if (mBroadcastCount > 0) {
                //throw new IllegalStateException(
                        //"beginBroadcast() called while already in a broadcast");
            //}
            //final int N = mBroadcastCount = mCallbacks.size();
            //if (N <= 0) {
                //return 0;
            //}
            //Object[] active = mActiveBroadcast;
            //if (active == null || active.length < N) {
                //mActiveBroadcast = active = new Object[N];
            //}
            //int i=0;
            //for (Callback cb : mCallbacks.values()) {
                //active[i++] = cb;
            //}
            //return i;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.174 -0400", hash_original_method = "C48AB0BBF7A76319F21B51268A720A67", hash_generated_method = "F817C7B6701F87D7E686CAAFCBE0D28B")
    @DSModeled(DSC.SAFE)
    public E getBroadcastItem(int index) {
        dsTaint.addTaint(index);
        return (E)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ((Callback)mActiveBroadcast[index]).mCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.174 -0400", hash_original_method = "25A2DBE745AB094B33E63C6F1B03FB52", hash_generated_method = "0D023584EABF23ADDD04740F486655DE")
    @DSModeled(DSC.SAFE)
    public Object getBroadcastCookie(int index) {
        dsTaint.addTaint(index);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return ((Callback)mActiveBroadcast[index]).mCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.174 -0400", hash_original_method = "2675E2000594C860776B6FA43AA81FEA", hash_generated_method = "1049761392BCC3A10B66F6D089BA6677")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void finishBroadcast() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "finishBroadcast() called outside of a broadcast");
        } //End block
        Object[] active;
        active = mActiveBroadcast;
        {
            int N;
            N = mBroadcastCount;
            {
                int i;
                i = 0;
                {
                    active[i] = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        mBroadcastCount = -1;
        // ---------- Original Method ----------
        //if (mBroadcastCount < 0) {
            //throw new IllegalStateException(
                    //"finishBroadcast() called outside of a broadcast");
        //}
        //Object[] active = mActiveBroadcast;
        //if (active != null) {
            //final int N = mBroadcastCount;
            //for (int i=0; i<N; i++) {
                //active[i] = null;
            //}
        //}
        //mBroadcastCount = -1;
    }

    
    private final class Callback implements IBinder.DeathRecipient {
        E mCallback;
        Object mCookie;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.175 -0400", hash_original_method = "C2984F09CEF5592866E406A38791BD39", hash_generated_method = "8FB6BB2FDE4EDEBA2F7BD3B47A333CC1")
        @DSModeled(DSC.SAFE)
         Callback(E callback, Object cookie) {
            dsTaint.addTaint(cookie.dsTaint);
            dsTaint.addTaint(callback.dsTaint);
            // ---------- Original Method ----------
            //mCallback = callback;
            //mCookie = cookie;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.175 -0400", hash_original_method = "984D7C16BA519E420EB37CE7E59C8134", hash_generated_method = "07DAF3C610B40B556241E7827292F713")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void binderDied() {
            {
                mCallbacks.remove(mCallback.asBinder());
            } //End block
            onCallbackDied(mCallback, mCookie);
            // ---------- Original Method ----------
            //synchronized (mCallbacks) {
                //mCallbacks.remove(mCallback.asBinder());
            //}
            //onCallbackDied(mCallback, mCookie);
        }

        
    }


    
}

