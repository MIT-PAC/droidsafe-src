package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.HashMap;

public class RemoteCallbackList<E extends IInterface> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.156 -0400", hash_original_field = "72D1EACB1F5B2C1EAC84390B2F071A91", hash_generated_field = "A3014188D001ACE7213D971AD3B4EFAD")

    HashMap<IBinder, Callback> mCallbacks = new HashMap<IBinder, Callback>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.156 -0400", hash_original_field = "F7034A3B6A58DD3E159E33B889B4C8E7", hash_generated_field = "B75B95317849640E22DFE7A92A9E9DF6")

    private Object[] mActiveBroadcast;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.156 -0400", hash_original_field = "DA62EA2BD2797D2545C70678AC0C6477", hash_generated_field = "CB5FB74014BCEB13346A3C70AF8D1481")

    private int mBroadcastCount = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.156 -0400", hash_original_field = "7E462C185FBBAEC669F05A4FE352FEF7", hash_generated_field = "9A32E5255010279867B3E477F7AB34C4")

    private boolean mKilled = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.157 -0400", hash_original_method = "7510693ACC17AC22B2C7AA646F89D542", hash_generated_method = "7510693ACC17AC22B2C7AA646F89D542")
    public RemoteCallbackList ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.161 -0400", hash_original_method = "46F1FD6FBAE5A826BE086BA154A601C8", hash_generated_method = "C240135201BF220117AD2C5F1C00DE7F")
    public boolean register(E callback) {
        boolean varBDBB33B5D7C0AC8FAE2D3B9C46063DFE_1236300951 = (register(callback, null));
        addTaint(callback.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1204538311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1204538311;
        // ---------- Original Method ----------
        //return register(callback, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.171 -0400", hash_original_method = "228836B43DD98CF5855A1427021AF94C", hash_generated_method = "EC5EC63DFAB94A92FF524D3A06796E9C")
    public boolean register(E callback, Object cookie) {
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
        addTaint(callback.getTaint());
        addTaint(cookie.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1649005048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1649005048;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.172 -0400", hash_original_method = "E94D872448628F2BAA0FD192A750EA6D", hash_generated_method = "DE3718CCBECC95A5754AD13A69528AD6")
    public boolean unregister(E callback) {
        {
            Callback cb;
            cb = mCallbacks.remove(callback.asBinder());
            {
                cb.mCallback.asBinder().unlinkToDeath(cb, 0);
            } //End block
        } //End block
        addTaint(callback.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779114176 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_779114176;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.217 -0400", hash_original_method = "143F9A34B740B6676238190B04E5358A", hash_generated_method = "893419F531C6BEC9C7BCEAAB5A942A3A")
    public void kill() {
        {
            {
                Iterator<Callback> var5D52E140987DCF0A2A1B652E3C6CD766_2102374841 = (mCallbacks.values()).iterator();
                var5D52E140987DCF0A2A1B652E3C6CD766_2102374841.hasNext();
                Callback cb = var5D52E140987DCF0A2A1B652E3C6CD766_2102374841.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.217 -0400", hash_original_method = "B434989CEB936B9194BF8BFB60F8F696", hash_generated_method = "C207C2EEEC5BA9BE9962A64534BC332F")
    public void onCallbackDied(E callback) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(callback.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.218 -0400", hash_original_method = "0963A4798BF8140F1109AA736DE1F9A0", hash_generated_method = "936F3E5CD0F87C7CA919066C1A9D66EA")
    public void onCallbackDied(E callback, Object cookie) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onCallbackDied(callback);
        addTaint(callback.getTaint());
        addTaint(cookie.getTaint());
        // ---------- Original Method ----------
        //onCallbackDied(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.380 -0400", hash_original_method = "1FD0E6F07E109275C9353B8621589475", hash_generated_method = "46CF88587DD88D241D6CCC9F20C44AF9")
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
                Iterator<Callback> var5D52E140987DCF0A2A1B652E3C6CD766_649805813 = (mCallbacks.values()).iterator();
                var5D52E140987DCF0A2A1B652E3C6CD766_649805813.hasNext();
                Callback cb = var5D52E140987DCF0A2A1B652E3C6CD766_649805813.next();
                {
                    active[i++] = cb;
                } //End block
            } //End collapsed parenthetic
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908980160 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_908980160;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.410 -0400", hash_original_method = "C48AB0BBF7A76319F21B51268A720A67", hash_generated_method = "FB5F3A25845187EDD2F593CE53033F8F")
    public E getBroadcastItem(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_1076585057 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1076585057 = ((Callback)mActiveBroadcast[index]).mCallback;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1076585057.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1076585057;
        // ---------- Original Method ----------
        //return ((Callback)mActiveBroadcast[index]).mCallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.411 -0400", hash_original_method = "25A2DBE745AB094B33E63C6F1B03FB52", hash_generated_method = "54F6DD9BF519EA32AD800E6F98CD5F54")
    public Object getBroadcastCookie(int index) {
        Object varB4EAC82CA7396A68D541C85D26508E83_755651158 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_755651158 = ((Callback)mActiveBroadcast[index]).mCookie;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_755651158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_755651158;
        // ---------- Original Method ----------
        //return ((Callback)mActiveBroadcast[index]).mCookie;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.415 -0400", hash_original_method = "2675E2000594C860776B6FA43AA81FEA", hash_generated_method = "1049761392BCC3A10B66F6D089BA6677")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.416 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "C5FF175C3C7088F24551555CDBB26192")

        E mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.416 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "3AD67F45247C091A10339EB1DB868D56")

        Object mCookie;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.417 -0400", hash_original_method = "C2984F09CEF5592866E406A38791BD39", hash_generated_method = "9ECBE985C29B48A9334DF8C135D302A2")
          Callback(E callback, Object cookie) {
            mCallback = callback;
            mCookie = cookie;
            // ---------- Original Method ----------
            //mCallback = callback;
            //mCookie = cookie;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:27.417 -0400", hash_original_method = "984D7C16BA519E420EB37CE7E59C8134", hash_generated_method = "07DAF3C610B40B556241E7827292F713")
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

