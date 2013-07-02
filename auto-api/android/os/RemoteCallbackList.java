package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.HashMap;

public class RemoteCallbackList<E extends IInterface> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.079 -0400", hash_original_field = "72D1EACB1F5B2C1EAC84390B2F071A91", hash_generated_field = "A3014188D001ACE7213D971AD3B4EFAD")

    HashMap<IBinder, Callback> mCallbacks = new HashMap<IBinder, Callback>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.079 -0400", hash_original_field = "F7034A3B6A58DD3E159E33B889B4C8E7", hash_generated_field = "B75B95317849640E22DFE7A92A9E9DF6")

    private Object[] mActiveBroadcast;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.079 -0400", hash_original_field = "DA62EA2BD2797D2545C70678AC0C6477", hash_generated_field = "CB5FB74014BCEB13346A3C70AF8D1481")

    private int mBroadcastCount = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.079 -0400", hash_original_field = "7E462C185FBBAEC669F05A4FE352FEF7", hash_generated_field = "9A32E5255010279867B3E477F7AB34C4")

    private boolean mKilled = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.079 -0400", hash_original_method = "7510693ACC17AC22B2C7AA646F89D542", hash_generated_method = "7510693ACC17AC22B2C7AA646F89D542")
    public RemoteCallbackList ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.079 -0400", hash_original_method = "46F1FD6FBAE5A826BE086BA154A601C8", hash_generated_method = "FB6A6C61AB715556F0FC22D0901AA01A")
    public boolean register(E callback) {
        boolean varBDBB33B5D7C0AC8FAE2D3B9C46063DFE_2137529582 = (register(callback, null));
        addTaint(callback.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1577654435 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1577654435;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.080 -0400", hash_original_method = "228836B43DD98CF5855A1427021AF94C", hash_generated_method = "452FD37936545B6CCA150122BEB50A96")
    public boolean register(E callback, Object cookie) {
        {
            IBinder binder = callback.asBinder();
            try 
            {
                Callback cb = new Callback(callback, cookie);
                binder.linkToDeath(cb, 0);
                mCallbacks.put(binder, cb);
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(callback.getTaint());
        addTaint(cookie.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732474794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_732474794;
        
        
            
                
            
            
            
                
                
                
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.080 -0400", hash_original_method = "E94D872448628F2BAA0FD192A750EA6D", hash_generated_method = "F08FCEE5E9591FE2076C359F0D85386B")
    public boolean unregister(E callback) {
        {
            Callback cb = mCallbacks.remove(callback.asBinder());
            {
                cb.mCallback.asBinder().unlinkToDeath(cb, 0);
            } 
        } 
        addTaint(callback.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_375892726 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_375892726;
        
        
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.087 -0400", hash_original_method = "143F9A34B740B6676238190B04E5358A", hash_generated_method = "54C305ACF6DCF1584ADF9161EF49F47C")
    public void kill() {
        {
            {
                Iterator<Callback> var5D52E140987DCF0A2A1B652E3C6CD766_676103245 = (mCallbacks.values()).iterator();
                var5D52E140987DCF0A2A1B652E3C6CD766_676103245.hasNext();
                Callback cb = var5D52E140987DCF0A2A1B652E3C6CD766_676103245.next();
                {
                    cb.mCallback.asBinder().unlinkToDeath(cb, 0);
                } 
            } 
            mCallbacks.clear();
            mKilled = true;
        } 
        
        
            
                
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.088 -0400", hash_original_method = "B434989CEB936B9194BF8BFB60F8F696", hash_generated_method = "C207C2EEEC5BA9BE9962A64534BC332F")
    public void onCallbackDied(E callback) {
        
        addTaint(callback.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.088 -0400", hash_original_method = "0963A4798BF8140F1109AA736DE1F9A0", hash_generated_method = "936F3E5CD0F87C7CA919066C1A9D66EA")
    public void onCallbackDied(E callback, Object cookie) {
        
        onCallbackDied(callback);
        addTaint(callback.getTaint());
        addTaint(cookie.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.098 -0400", hash_original_method = "1FD0E6F07E109275C9353B8621589475", hash_generated_method = "A555E797AAF0630E99D71B4508CC40C0")
    public int beginBroadcast() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                        "beginBroadcast() called while already in a broadcast");
            } 
            final int N = mBroadcastCount = mCallbacks.size();
            Object[] active = mActiveBroadcast;
            {
                mActiveBroadcast = active = new Object[N];
            } 
            int i = 0;
            {
                Iterator<Callback> var5D52E140987DCF0A2A1B652E3C6CD766_1722160685 = (mCallbacks.values()).iterator();
                var5D52E140987DCF0A2A1B652E3C6CD766_1722160685.hasNext();
                Callback cb = var5D52E140987DCF0A2A1B652E3C6CD766_1722160685.next();
                {
                    active[i++] = cb;
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913858612 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913858612;
        
        
            
                
                        
            
            
            
                
            
            
            
                
            
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.099 -0400", hash_original_method = "C48AB0BBF7A76319F21B51268A720A67", hash_generated_method = "F15BD7F2A8FE49EED82932D385AB4372")
    public E getBroadcastItem(int index) {
        E varB4EAC82CA7396A68D541C85D26508E83_258900270 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_258900270 = ((Callback)mActiveBroadcast[index]).mCallback;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_258900270.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_258900270;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.099 -0400", hash_original_method = "25A2DBE745AB094B33E63C6F1B03FB52", hash_generated_method = "B061D4B541699FFBF691675D48857237")
    public Object getBroadcastCookie(int index) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1525616545 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1525616545 = ((Callback)mActiveBroadcast[index]).mCookie;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1525616545.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1525616545;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.100 -0400", hash_original_method = "2675E2000594C860776B6FA43AA81FEA", hash_generated_method = "AF00370E98D5FCA8495F54FFDB0F5847")
    public void finishBroadcast() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "finishBroadcast() called outside of a broadcast");
        } 
        Object[] active = mActiveBroadcast;
        {
            final int N = mBroadcastCount;
            {
                int i = 0;
                {
                    active[i] = null;
                } 
            } 
        } 
        mBroadcastCount = -1;
        
        
            
                    
        
        
        
            
            
                
            
        
        
    }

    
    private final class Callback implements IBinder.DeathRecipient {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.100 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "C5FF175C3C7088F24551555CDBB26192")

        E mCallback;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.100 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "3AD67F45247C091A10339EB1DB868D56")

        Object mCookie;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.100 -0400", hash_original_method = "C2984F09CEF5592866E406A38791BD39", hash_generated_method = "9ECBE985C29B48A9334DF8C135D302A2")
          Callback(E callback, Object cookie) {
            mCallback = callback;
            mCookie = cookie;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.101 -0400", hash_original_method = "984D7C16BA519E420EB37CE7E59C8134", hash_generated_method = "07DAF3C610B40B556241E7827292F713")
        public void binderDied() {
            {
                mCallbacks.remove(mCallback.asBinder());
            } 
            onCallbackDied(mCallback, mCookie);
            
            
                
            
            
        }

        
    }


    
}

