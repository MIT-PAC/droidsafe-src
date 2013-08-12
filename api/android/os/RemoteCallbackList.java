package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.HashMap;






public class RemoteCallbackList<E extends IInterface> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.498 -0400", hash_original_field = "72D1EACB1F5B2C1EAC84390B2F071A91", hash_generated_field = "A3014188D001ACE7213D971AD3B4EFAD")

    HashMap<IBinder, Callback> mCallbacks = new HashMap<IBinder, Callback>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.498 -0400", hash_original_field = "F7034A3B6A58DD3E159E33B889B4C8E7", hash_generated_field = "B75B95317849640E22DFE7A92A9E9DF6")

    private Object[] mActiveBroadcast;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.498 -0400", hash_original_field = "DA62EA2BD2797D2545C70678AC0C6477", hash_generated_field = "CB5FB74014BCEB13346A3C70AF8D1481")

    private int mBroadcastCount = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.498 -0400", hash_original_field = "7E462C185FBBAEC669F05A4FE352FEF7", hash_generated_field = "9A32E5255010279867B3E477F7AB34C4")

    private boolean mKilled = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.498 -0400", hash_original_method = "7510693ACC17AC22B2C7AA646F89D542", hash_generated_method = "7510693ACC17AC22B2C7AA646F89D542")
    public RemoteCallbackList ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.499 -0400", hash_original_method = "46F1FD6FBAE5A826BE086BA154A601C8", hash_generated_method = "650306CCACDD82AC7B6F15E3BB4938E2")
    public boolean register(E callback) {
        addTaint(callback.getTaint());
        boolean var92EA61A90CB5D0228FF67B2A9B2FE3AD_970731147 = (register(callback, null));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1226273918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1226273918;
        // ---------- Original Method ----------
        //return register(callback, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.500 -0400", hash_original_method = "228836B43DD98CF5855A1427021AF94C", hash_generated_method = "3EC34CE3E807AC27BD6E712F29E47A35")
    public boolean register(E callback, Object cookie) {
        addTaint(cookie.getTaint());
        addTaint(callback.getTaint());
        synchronized
(mCallbacks)        {
            if(mKilled)            
            {
                boolean var68934A3E9455FA72420237EB05902327_237188417 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922672567 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922672567;
            } //End block
            IBinder binder = callback.asBinder();
            try 
            {
                Callback cb = new Callback(callback, cookie);
                binder.linkToDeath(cb, 0);
                mCallbacks.put(binder, cb);
                boolean varB326B5062B2F0E69046810717534CB09_464298442 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2123874380 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2123874380;
            } //End block
            catch (RemoteException e)
            {
                boolean var68934A3E9455FA72420237EB05902327_890987740 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1204417302 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1204417302;
            } //End block
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.501 -0400", hash_original_method = "E94D872448628F2BAA0FD192A750EA6D", hash_generated_method = "23DD0EBAAD7AAEE691319DD7A364D5A6")
    public boolean unregister(E callback) {
        addTaint(callback.getTaint());
        synchronized
(mCallbacks)        {
            Callback cb = mCallbacks.remove(callback.asBinder());
            if(cb != null)            
            {
                cb.mCallback.asBinder().unlinkToDeath(cb, 0);
                boolean varB326B5062B2F0E69046810717534CB09_1092754509 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595396226 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_595396226;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_160725839 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035272692 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035272692;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.501 -0400", hash_original_method = "143F9A34B740B6676238190B04E5358A", hash_generated_method = "DC3FF614DB56E3D41714CD8AC4700ACE")
    public void kill() {
        synchronized
(mCallbacks)        {
for(Callback cb : mCallbacks.values())
            {
                cb.mCallback.asBinder().unlinkToDeath(cb, 0);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.502 -0400", hash_original_method = "B434989CEB936B9194BF8BFB60F8F696", hash_generated_method = "C207C2EEEC5BA9BE9962A64534BC332F")
    public void onCallbackDied(E callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.503 -0400", hash_original_method = "0963A4798BF8140F1109AA736DE1F9A0", hash_generated_method = "0F4DCC0F85E2CB1AE7F5362026E5BCDB")
    public void onCallbackDied(E callback, Object cookie) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(cookie.getTaint());
        addTaint(callback.getTaint());
        onCallbackDied(callback);
        // ---------- Original Method ----------
        //onCallbackDied(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.504 -0400", hash_original_method = "1FD0E6F07E109275C9353B8621589475", hash_generated_method = "B85F1423A4353F005407E82B8BCADD05")
    public int beginBroadcast() {
        synchronized
(mCallbacks)        {
            if(mBroadcastCount > 0)            
            {
                IllegalStateException varBAA632CC604AE88F1B3666724C0E416E_1654731828 = new IllegalStateException(
                        "beginBroadcast() called while already in a broadcast");
                varBAA632CC604AE88F1B3666724C0E416E_1654731828.addTaint(taint);
                throw varBAA632CC604AE88F1B3666724C0E416E_1654731828;
            } //End block
            final int N = mBroadcastCount = mCallbacks.size();
            if(N <= 0)            
            {
                int varCFCD208495D565EF66E7DFF9F98764DA_831932595 = (0);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_291410787 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_291410787;
            } //End block
            Object[] active = mActiveBroadcast;
            if(active == null || active.length < N)            
            {
                mActiveBroadcast = active = new Object[N];
            } //End block
            int i = 0;
for(Callback cb : mCallbacks.values())
            {
                active[i++] = cb;
            } //End block
            int var865C0C0B4AB0E063E5CAA3387C1A8741_1495952185 = (i);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_868067169 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_868067169;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.505 -0400", hash_original_method = "C48AB0BBF7A76319F21B51268A720A67", hash_generated_method = "4C416FEE6B329B2DC315C90A331ED91B")
    public E getBroadcastItem(int index) {
        addTaint(index);
E varB387F1FD5AB54FD12A37CFCEE986154C_96347515 =         ((Callback)mActiveBroadcast[index]).mCallback;
        varB387F1FD5AB54FD12A37CFCEE986154C_96347515.addTaint(taint);
        return varB387F1FD5AB54FD12A37CFCEE986154C_96347515;
        // ---------- Original Method ----------
        //return ((Callback)mActiveBroadcast[index]).mCallback;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.505 -0400", hash_original_method = "25A2DBE745AB094B33E63C6F1B03FB52", hash_generated_method = "5C476B5B11555D29BB4B2574D754B827")
    public Object getBroadcastCookie(int index) {
        addTaint(index);
Object var827DDB4E5F2D629148BAD499A051C937_1739028330 =         ((Callback)mActiveBroadcast[index]).mCookie;
        var827DDB4E5F2D629148BAD499A051C937_1739028330.addTaint(taint);
        return var827DDB4E5F2D629148BAD499A051C937_1739028330;
        // ---------- Original Method ----------
        //return ((Callback)mActiveBroadcast[index]).mCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.506 -0400", hash_original_method = "2675E2000594C860776B6FA43AA81FEA", hash_generated_method = "8309ABFFF275EACEA9CE6C25FB52F56C")
    public void finishBroadcast() {
        if(mBroadcastCount < 0)        
        {
            IllegalStateException var13D39806D294C1A85F74F92F61421CE1_300847167 = new IllegalStateException(
                    "finishBroadcast() called outside of a broadcast");
            var13D39806D294C1A85F74F92F61421CE1_300847167.addTaint(taint);
            throw var13D39806D294C1A85F74F92F61421CE1_300847167;
        } //End block
        Object[] active = mActiveBroadcast;
        if(active != null)        
        {
            final int N = mBroadcastCount;
for(int i=0;i<N;i++)
            {
                active[i] = null;
            } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.507 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "C5FF175C3C7088F24551555CDBB26192")

        E mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.507 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "3AD67F45247C091A10339EB1DB868D56")

        Object mCookie;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.508 -0400", hash_original_method = "C2984F09CEF5592866E406A38791BD39", hash_generated_method = "9ECBE985C29B48A9334DF8C135D302A2")
          Callback(E callback, Object cookie) {
            mCallback = callback;
            mCookie = cookie;
            // ---------- Original Method ----------
            //mCallback = callback;
            //mCookie = cookie;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.508 -0400", hash_original_method = "984D7C16BA519E420EB37CE7E59C8134", hash_generated_method = "A6A8C52E92568FCC0B00CF98FEE95C6F")
        public void binderDied() {
            synchronized
(mCallbacks)            {
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

