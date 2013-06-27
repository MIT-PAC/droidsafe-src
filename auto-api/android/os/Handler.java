package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Modifier;

public class Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.171 -0400", hash_original_field = "2D043F2822EC0D4E2690BDFE63EDDFCA", hash_generated_field = "331CAFDD37154BFFB4C27FB1EC4DE2ED")

    MessageQueue mQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.171 -0400", hash_original_field = "DA288C1345E9C94467C02060ED19C6FA", hash_generated_field = "4C6A73D1D5351706C43659B423CF9288")

    Looper mLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.171 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "1A99E72B6409E38FBCC780D1BAB4898D")

    Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.172 -0400", hash_original_field = "83FE717B4B643B5D605C868F0E136C03", hash_generated_field = "35095A7AFB955F43B213705056D01A47")

    IMessenger mMessenger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.232 -0400", hash_original_method = "BF99A47DD8BD9030B611C5F1BD90EC8F", hash_generated_method = "C8C6AB071494D35E1C1D384691D9133A")
    public  Handler() {
        {
            Class<? extends Handler> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_1362203294 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0);
            } //End collapsed parenthetic
        } //End block
        mLooper = Looper.myLooper();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "Can't create handler inside thread that has not called Looper.prepare()");
        } //End block
        mQueue = mLooper.mQueue;
        mCallback = null;
        // ---------- Original Method ----------
        //if (FIND_POTENTIAL_LEAKS) {
            //final Class<? extends Handler> klass = getClass();
            //if ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    //(klass.getModifiers() & Modifier.STATIC) == 0) {
                //Log.w(TAG, "The following Handler class should be static or leaks might occur: " +
                    //klass.getCanonicalName());
            //}
        //}
        //mLooper = Looper.myLooper();
        //if (mLooper == null) {
            //throw new RuntimeException(
                //"Can't create handler inside thread that has not called Looper.prepare()");
        //}
        //mQueue = mLooper.mQueue;
        //mCallback = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.234 -0400", hash_original_method = "4145BBA061FAEF73002F915149455D35", hash_generated_method = "CD195B1B827D94A4DDA2E8CE3E8E23ED")
    public  Handler(Callback callback) {
        {
            Class<? extends Handler> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_1091809510 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0);
            } //End collapsed parenthetic
        } //End block
        mLooper = Looper.myLooper();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "Can't create handler inside thread that has not called Looper.prepare()");
        } //End block
        mQueue = mLooper.mQueue;
        mCallback = callback;
        // ---------- Original Method ----------
        //if (FIND_POTENTIAL_LEAKS) {
            //final Class<? extends Handler> klass = getClass();
            //if ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    //(klass.getModifiers() & Modifier.STATIC) == 0) {
                //Log.w(TAG, "The following Handler class should be static or leaks might occur: " +
                    //klass.getCanonicalName());
            //}
        //}
        //mLooper = Looper.myLooper();
        //if (mLooper == null) {
            //throw new RuntimeException(
                //"Can't create handler inside thread that has not called Looper.prepare()");
        //}
        //mQueue = mLooper.mQueue;
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.236 -0400", hash_original_method = "878DD6FD2A8B0F6865454043C68D5888", hash_generated_method = "9B81A69A46DF15261D6C68147933E52E")
    public  Handler(Looper looper) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = null;
        // ---------- Original Method ----------
        //mLooper = looper;
        //mQueue = looper.mQueue;
        //mCallback = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.236 -0400", hash_original_method = "0F1A18EF6331120AB094322F735FD8FC", hash_generated_method = "43AB9E70D0EFEBDC964E78082CA1DB45")
    public  Handler(Looper looper, Callback callback) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = callback;
        // ---------- Original Method ----------
        //mLooper = looper;
        //mQueue = looper.mQueue;
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.236 -0400", hash_original_method = "C13ECA453D39BD1621DCBD4764283A41", hash_generated_method = "6C9E5B782C82352543D0D7A957AAB817")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.237 -0400", hash_original_method = "1565D7D72E28223A47E7963B114AD9E6", hash_generated_method = "46799823039E01A9EE1FB4B101373BEC")
    public void dispatchMessage(Message msg) {
        {
            handleCallback(msg);
        } //End block
        {
            {
                {
                    boolean var40429B7E6C52EDCF4719B5E6B95BAF9A_523801441 = (mCallback.handleMessage(msg));
                } //End collapsed parenthetic
            } //End block
            handleMessage(msg);
        } //End block
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //if (msg.callback != null) {
            //handleCallback(msg);
        //} else {
            //if (mCallback != null) {
                //if (mCallback.handleMessage(msg)) {
                    //return;
                //}
            //}
            //handleMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.270 -0400", hash_original_method = "7AEB9F9BBB8F24805A35E34BFA8BA452", hash_generated_method = "170038D5F1CD7796ADDBB57332D3D3EA")
    public String getMessageName(Message message) {
        String varB4EAC82CA7396A68D541C85D26508E83_496734461 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_998989539 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_496734461 = message.callback.getClass().getName();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_998989539 = "0x" + Integer.toHexString(message.what);
        addTaint(message.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1834311702; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1834311702 = varB4EAC82CA7396A68D541C85D26508E83_496734461;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1834311702 = varB4EAC82CA7396A68D541C85D26508E83_998989539;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1834311702.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1834311702;
        // ---------- Original Method ----------
        //if (message.callback != null) {
            //return message.callback.getClass().getName();
        //}
        //return "0x" + Integer.toHexString(message.what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.276 -0400", hash_original_method = "3FA1D1E6850485EFDFF54C55EBFDD1CC", hash_generated_method = "1E8F0648B9B3CD0B36F326D5EEB22782")
    public final Message obtainMessage() {
        Message varB4EAC82CA7396A68D541C85D26508E83_2043124854 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2043124854 = Message.obtain(this);
        varB4EAC82CA7396A68D541C85D26508E83_2043124854.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2043124854;
        // ---------- Original Method ----------
        //return Message.obtain(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.280 -0400", hash_original_method = "83ED22E0C23176DA2E639FBDA9F30743", hash_generated_method = "7268B39574FB82331C775A35946024C8")
    public final Message obtainMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1423160032 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1423160032 = Message.obtain(this, what);
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_1423160032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1423160032;
        // ---------- Original Method ----------
        //return Message.obtain(this, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.303 -0400", hash_original_method = "16AA2451698F7981D4974062DB733B90", hash_generated_method = "13EFAA3D34AC9FF5FDAA48FAF5176AAA")
    public final Message obtainMessage(int what, Object obj) {
        Message varB4EAC82CA7396A68D541C85D26508E83_310157616 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_310157616 = Message.obtain(this, what, obj);
        addTaint(what);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_310157616.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_310157616;
        // ---------- Original Method ----------
        //return Message.obtain(this, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.304 -0400", hash_original_method = "E0C335742F8D26DCA388CDB62E97551F", hash_generated_method = "E75B4236BD2A5907CA7A1F73B9459CB3")
    public final Message obtainMessage(int what, int arg1, int arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_313585499 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_313585499 = Message.obtain(this, what, arg1, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        varB4EAC82CA7396A68D541C85D26508E83_313585499.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_313585499;
        // ---------- Original Method ----------
        //return Message.obtain(this, what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.305 -0400", hash_original_method = "73E3B8E788E4FE19D8B1D7007BFD268C", hash_generated_method = "3F1BA49560986EC296ABE7761B42266D")
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        Message varB4EAC82CA7396A68D541C85D26508E83_855659804 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_855659804 = Message.obtain(this, what, arg1, arg2, obj);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_855659804.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_855659804;
        // ---------- Original Method ----------
        //return Message.obtain(this, what, arg1, arg2, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.305 -0400", hash_original_method = "6A0575D5625A2B33566AA17E837BEE40", hash_generated_method = "7DF04C0A7647CDB13AC070845A5A9F19")
    public final boolean post(Runnable r) {
        boolean var7A01F528DFCD9F3B64D013796B5AEAEA_1376901688 = (sendMessageDelayed(getPostMessage(r), 0));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_163128788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_163128788;
        // ---------- Original Method ----------
        //return  sendMessageDelayed(getPostMessage(r), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.306 -0400", hash_original_method = "AE818DFE2AFBC7BA2C1B26423E282D08", hash_generated_method = "C683A978ED63705BA13E4ACC99A77FA0")
    public final boolean postAtTime(Runnable r, long uptimeMillis) {
        boolean varE06D54AE70CF1F1A96C302B669F59131_523990913 = (sendMessageAtTime(getPostMessage(r), uptimeMillis));
        addTaint(r.getTaint());
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1644852846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1644852846;
        // ---------- Original Method ----------
        //return sendMessageAtTime(getPostMessage(r), uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.311 -0400", hash_original_method = "545FD7F3E8EB84671B1FDA0DB6EB661F", hash_generated_method = "10498D2BCD025CF088607F1692EBEE49")
    public final boolean postAtTime(Runnable r, Object token, long uptimeMillis) {
        boolean var3BAF00809B4281FFDC01C90B27A5CF75_237651385 = (sendMessageAtTime(getPostMessage(r, token), uptimeMillis));
        addTaint(r.getTaint());
        addTaint(token.getTaint());
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1635624199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1635624199;
        // ---------- Original Method ----------
        //return sendMessageAtTime(getPostMessage(r, token), uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.320 -0400", hash_original_method = "E41A8A27723BD019DF77785AB7446793", hash_generated_method = "AFE4E39E6635F8A3DE47A268E2024683")
    public final boolean postDelayed(Runnable r, long delayMillis) {
        boolean varF8B393B58C339C87BBA330695569D4F5_496971484 = (sendMessageDelayed(getPostMessage(r), delayMillis));
        addTaint(r.getTaint());
        addTaint(delayMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1169557744 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1169557744;
        // ---------- Original Method ----------
        //return sendMessageDelayed(getPostMessage(r), delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.331 -0400", hash_original_method = "349F8881748C55ABBCC660C80A5C77C8", hash_generated_method = "BDA8E5E120939A3279252C2505594D3E")
    public final boolean postAtFrontOfQueue(Runnable r) {
        boolean varBFA199A426AAF2B85E67B2328E173359_323584419 = (sendMessageAtFrontOfQueue(getPostMessage(r)));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1428570873 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1428570873;
        // ---------- Original Method ----------
        //return sendMessageAtFrontOfQueue(getPostMessage(r));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.332 -0400", hash_original_method = "EA17D2D89EBC0DA60DAE54B4D2813C6D", hash_generated_method = "19A443F0A686C5D1DFA3C6AEA93334E1")
    public final void removeCallbacks(Runnable r) {
        mQueue.removeMessages(this, r, null);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, r, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.332 -0400", hash_original_method = "159A6F4E93CA274BF5D9A61C57FA58AA", hash_generated_method = "B81059E219504F6CBFDDBEF6C09852EB")
    public final void removeCallbacks(Runnable r, Object token) {
        mQueue.removeMessages(this, r, token);
        addTaint(r.getTaint());
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, r, token);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.343 -0400", hash_original_method = "A97266028157506969A5B89288A9C9BC", hash_generated_method = "88C3DC0DF2579CAF484E2A765316709E")
    public final boolean sendMessage(Message msg) {
        boolean var61A3771F06272201631ECD7A68EAD4FF_2051839986 = (sendMessageDelayed(msg, 0));
        addTaint(msg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_596506869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_596506869;
        // ---------- Original Method ----------
        //return sendMessageDelayed(msg, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.344 -0400", hash_original_method = "A52967DD531D2E9895F5558692B5D99D", hash_generated_method = "2AE9F35C9B2C4665C1014ECB26A74D09")
    public final boolean sendEmptyMessage(int what) {
        boolean var4556D7D1710FA2FD730FBBBE12542C68_477673075 = (sendEmptyMessageDelayed(what, 0));
        addTaint(what);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_483857334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_483857334;
        // ---------- Original Method ----------
        //return sendEmptyMessageDelayed(what, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.373 -0400", hash_original_method = "C345E8B6D42103BAB2779DE84E2F8005", hash_generated_method = "8986E6E259CEC12C8C6A31BD9FDE3DD8")
    public final boolean sendEmptyMessageDelayed(int what, long delayMillis) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        boolean var422D34FE7EBBD1E444F99420C6560E7D_844222513 = (sendMessageDelayed(msg, delayMillis));
        addTaint(what);
        addTaint(delayMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_634732407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_634732407;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //return sendMessageDelayed(msg, delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.375 -0400", hash_original_method = "0234DAD2CAD8EF6B170E56EDA713A580", hash_generated_method = "998745CCF84DBEFC0A02B727928BA49A")
    public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        boolean var6676E1BAAA52F02DEEF6C770E4ABF19C_1145464373 = (sendMessageAtTime(msg, uptimeMillis));
        addTaint(what);
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_706980430 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_706980430;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //return sendMessageAtTime(msg, uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.376 -0400", hash_original_method = "F32DF35552A73512081963AF1F333EEC", hash_generated_method = "7D251FCBC38D6F3C9B107D7715073F79")
    public final boolean sendMessageDelayed(Message msg, long delayMillis) {
        {
            delayMillis = 0;
        } //End block
        boolean var1761F03F3EEFC16009DC3CA8E9725E10_325566519 = (sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis));
        addTaint(msg.getTaint());
        addTaint(delayMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084077662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084077662;
        // ---------- Original Method ----------
        //if (delayMillis < 0) {
            //delayMillis = 0;
        //}
        //return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.400 -0400", hash_original_method = "9EBABACA140C9DF9A34851CFCEDCA0D2", hash_generated_method = "59E2A9939B159796A09DFD905BA60701")
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        boolean sent;
        sent = false;
        MessageQueue queue;
        queue = mQueue;
        {
            msg.target = this;
            sent = queue.enqueueMessage(msg, uptimeMillis);
        } //End block
        {
            RuntimeException e;
            e = new RuntimeException(
                this + " sendMessageAtTime() called with no mQueue");
        } //End block
        addTaint(msg.getTaint());
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_850155548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_850155548;
        // ---------- Original Method ----------
        //boolean sent = false;
        //MessageQueue queue = mQueue;
        //if (queue != null) {
            //msg.target = this;
            //sent = queue.enqueueMessage(msg, uptimeMillis);
        //}
        //else {
            //RuntimeException e = new RuntimeException(
                //this + " sendMessageAtTime() called with no mQueue");
            //Log.w("Looper", e.getMessage(), e);
        //}
        //return sent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.401 -0400", hash_original_method = "915CC0C6E8D23436D72B6BC5461B3284", hash_generated_method = "7BFCC5259735AE29693FBA89E4E649E5")
    public final boolean sendMessageAtFrontOfQueue(Message msg) {
        boolean sent;
        sent = false;
        MessageQueue queue;
        queue = mQueue;
        {
            msg.target = this;
            sent = queue.enqueueMessage(msg, 0);
        } //End block
        {
            RuntimeException e;
            e = new RuntimeException(
                this + " sendMessageAtTime() called with no mQueue");
        } //End block
        addTaint(msg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1311443936 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1311443936;
        // ---------- Original Method ----------
        //boolean sent = false;
        //MessageQueue queue = mQueue;
        //if (queue != null) {
            //msg.target = this;
            //sent = queue.enqueueMessage(msg, 0);
        //}
        //else {
            //RuntimeException e = new RuntimeException(
                //this + " sendMessageAtTime() called with no mQueue");
            //Log.w("Looper", e.getMessage(), e);
        //}
        //return sent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.402 -0400", hash_original_method = "4176E8C258200D3721001C1E43AEA8B7", hash_generated_method = "596DC98388E02314F3D663DF1DBD1A82")
    public final void removeMessages(int what) {
        mQueue.removeMessages(this, what, null, true);
        addTaint(what);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, what, null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.402 -0400", hash_original_method = "23ED3231C29D8F11BAA051AB6C64E2F2", hash_generated_method = "77D5EA64BE5560CAF694E8030DA3E86B")
    public final void removeMessages(int what, Object object) {
        mQueue.removeMessages(this, what, object, true);
        addTaint(what);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, what, object, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.408 -0400", hash_original_method = "448E73D7B69D80F7826BA330AB50FE66", hash_generated_method = "6B402AB47C76673EE7A06907E80CC4A1")
    public final void removeCallbacksAndMessages(Object token) {
        mQueue.removeCallbacksAndMessages(this, token);
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //mQueue.removeCallbacksAndMessages(this, token);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.409 -0400", hash_original_method = "311185E2299156FD883BD00C28E38599", hash_generated_method = "5997F05E3721B1EF86E046BF23798A17")
    public final boolean hasMessages(int what) {
        boolean var3318D5FB3681CEA99F369FDDCF03D4B8_262515704 = (mQueue.removeMessages(this, what, null, false));
        addTaint(what);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2097235080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2097235080;
        // ---------- Original Method ----------
        //return mQueue.removeMessages(this, what, null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.409 -0400", hash_original_method = "49BF5F4269CD0924DE36FF7A410C4BAC", hash_generated_method = "5CAAC4570025AF47FFB8D0AA8F727E9F")
    public final boolean hasMessages(int what, Object object) {
        boolean var09A85EE8C328ECF4A84EF4C40DF7B776_1495176531 = (mQueue.removeMessages(this, what, object, false));
        addTaint(what);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257722329 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257722329;
        // ---------- Original Method ----------
        //return mQueue.removeMessages(this, what, object, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.431 -0400", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "15BDE77D090142E9B1D2E5A409715998")
    public final Looper getLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_1263564009 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1263564009 = mLooper;
        varB4EAC82CA7396A68D541C85D26508E83_1263564009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1263564009;
        // ---------- Original Method ----------
        //return mLooper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.432 -0400", hash_original_method = "F69D7CBFCB904B3AB08CCA20C9F65B2F", hash_generated_method = "F34828814FA68CDBD9F822D3B537392E")
    public final void dump(Printer pw, String prefix) {
        pw.println(prefix + this + " @ " + SystemClock.uptimeMillis());
        {
            pw.println(prefix + "looper uninitialized");
        } //End block
        {
            mLooper.dump(pw, prefix + "  ");
        } //End block
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //pw.println(prefix + this + " @ " + SystemClock.uptimeMillis());
        //if (mLooper == null) {
            //pw.println(prefix + "looper uninitialized");
        //} else {
            //mLooper.dump(pw, prefix + "  ");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.460 -0400", hash_original_method = "05520CD35CB4412A1070385C35DB25A1", hash_generated_method = "62FFA0678497C1DA847F00DF64463036")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_842293186 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_842293186 = "Handler (" + getClass().getName() + ") {"
        + Integer.toHexString(System.identityHashCode(this))
        + "}";
        varB4EAC82CA7396A68D541C85D26508E83_842293186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_842293186;
        // ---------- Original Method ----------
        //return "Handler (" + getClass().getName() + ") {"
        //+ Integer.toHexString(System.identityHashCode(this))
        //+ "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.462 -0400", hash_original_method = "022CD131F6EA96B24851C91C40C740AA", hash_generated_method = "7E1ECA17E7473E180512C8DF6270FC3A")
    final IMessenger getIMessenger() {
        IMessenger varB4EAC82CA7396A68D541C85D26508E83_63712104 = null; //Variable for return #1
        IMessenger varB4EAC82CA7396A68D541C85D26508E83_2103131592 = null; //Variable for return #2
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_63712104 = mMessenger;
            } //End block
            mMessenger = new MessengerImpl();
            varB4EAC82CA7396A68D541C85D26508E83_2103131592 = mMessenger;
        } //End block
        IMessenger varA7E53CE21691AB073D9660D615818899_1452321488; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1452321488 = varB4EAC82CA7396A68D541C85D26508E83_63712104;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1452321488 = varB4EAC82CA7396A68D541C85D26508E83_2103131592;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1452321488.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1452321488;
        // ---------- Original Method ----------
        //synchronized (mQueue) {
            //if (mMessenger != null) {
                //return mMessenger;
            //}
            //mMessenger = new MessengerImpl();
            //return mMessenger;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.463 -0400", hash_original_method = "9DFB5128F30D3CFE7C2F086A6667AA29", hash_generated_method = "D6F8D786B8983CB6A65E53D723E762BD")
    private final Message getPostMessage(Runnable r) {
        Message varB4EAC82CA7396A68D541C85D26508E83_578420009 = null; //Variable for return #1
        Message m;
        m = Message.obtain();
        m.callback = r;
        varB4EAC82CA7396A68D541C85D26508E83_578420009 = m;
        addTaint(r.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_578420009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_578420009;
        // ---------- Original Method ----------
        //Message m = Message.obtain();
        //m.callback = r;
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.464 -0400", hash_original_method = "001850E10F072AF670657F2F37A16A9C", hash_generated_method = "275FD22AD95F973B385113F96FE843F6")
    private final Message getPostMessage(Runnable r, Object token) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1879968800 = null; //Variable for return #1
        Message m;
        m = Message.obtain();
        m.obj = token;
        m.callback = r;
        varB4EAC82CA7396A68D541C85D26508E83_1879968800 = m;
        addTaint(r.getTaint());
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1879968800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1879968800;
        // ---------- Original Method ----------
        //Message m = Message.obtain();
        //m.obj = token;
        //m.callback = r;
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.486 -0400", hash_original_method = "6CA31B63D4772009E291A8EEE8116A2F", hash_generated_method = "E3D7BD18C18A1C9B4EF9E7B89730EA91")
    private final void handleCallback(Message message) {
        message.callback.run();
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //message.callback.run();
    }

    
    private final class MessengerImpl extends IMessenger.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.487 -0400", hash_original_method = "68A768E132C1125DE9510AF39EB42EE7", hash_generated_method = "68A768E132C1125DE9510AF39EB42EE7")
        public MessengerImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.487 -0400", hash_original_method = "CF11BADC884B068E4FC98150B23E5EB1", hash_generated_method = "CE1189B26F74072764E72C8583836693")
        public void send(Message msg) {
            Handler.this.sendMessage(msg);
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            //Handler.this.sendMessage(msg);
        }

        
    }


    
    public interface Callback {
        public boolean handleMessage(Message msg);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.487 -0400", hash_original_field = "E98C260B28FA80AA89F6D5E5597392E0", hash_generated_field = "85F8EDE7194C9C1A1A22315BDC750456")

    private static boolean FIND_POTENTIAL_LEAKS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:26.487 -0400", hash_original_field = "C705D79D983762D5A9E5A78751871C79", hash_generated_field = "8914EFEA99C29A6C7B19CF4C0DC11F7B")

    private static String TAG = "Handler";
}

