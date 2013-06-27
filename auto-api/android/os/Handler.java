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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.643 -0400", hash_original_field = "2D043F2822EC0D4E2690BDFE63EDDFCA", hash_generated_field = "331CAFDD37154BFFB4C27FB1EC4DE2ED")

    MessageQueue mQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.643 -0400", hash_original_field = "DA288C1345E9C94467C02060ED19C6FA", hash_generated_field = "4C6A73D1D5351706C43659B423CF9288")

    Looper mLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.643 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "1A99E72B6409E38FBCC780D1BAB4898D")

    Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.643 -0400", hash_original_field = "83FE717B4B643B5D605C868F0E136C03", hash_generated_field = "35095A7AFB955F43B213705056D01A47")

    IMessenger mMessenger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.644 -0400", hash_original_method = "BF99A47DD8BD9030B611C5F1BD90EC8F", hash_generated_method = "5A348B246CDF5D55014472A17C3BEEF1")
    public  Handler() {
        {
            Class<? extends Handler> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_1952292167 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.645 -0400", hash_original_method = "4145BBA061FAEF73002F915149455D35", hash_generated_method = "3DFDA294AADCD50E68088A65C83C50BC")
    public  Handler(Callback callback) {
        {
            Class<? extends Handler> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_697405225 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.658 -0400", hash_original_method = "878DD6FD2A8B0F6865454043C68D5888", hash_generated_method = "9B81A69A46DF15261D6C68147933E52E")
    public  Handler(Looper looper) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = null;
        // ---------- Original Method ----------
        //mLooper = looper;
        //mQueue = looper.mQueue;
        //mCallback = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.670 -0400", hash_original_method = "0F1A18EF6331120AB094322F735FD8FC", hash_generated_method = "43AB9E70D0EFEBDC964E78082CA1DB45")
    public  Handler(Looper looper, Callback callback) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = callback;
        // ---------- Original Method ----------
        //mLooper = looper;
        //mQueue = looper.mQueue;
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.674 -0400", hash_original_method = "C13ECA453D39BD1621DCBD4764283A41", hash_generated_method = "6C9E5B782C82352543D0D7A957AAB817")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.675 -0400", hash_original_method = "1565D7D72E28223A47E7963B114AD9E6", hash_generated_method = "76B87CDBB3B15E5EC58D61F35E480608")
    public void dispatchMessage(Message msg) {
        {
            handleCallback(msg);
        } //End block
        {
            {
                {
                    boolean var40429B7E6C52EDCF4719B5E6B95BAF9A_1367630527 = (mCallback.handleMessage(msg));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.679 -0400", hash_original_method = "7AEB9F9BBB8F24805A35E34BFA8BA452", hash_generated_method = "161BACFEBD94F72C554E9943211263F1")
    public String getMessageName(Message message) {
        String varB4EAC82CA7396A68D541C85D26508E83_1872043221 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_983958443 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1872043221 = message.callback.getClass().getName();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_983958443 = "0x" + Integer.toHexString(message.what);
        addTaint(message.getTaint());
        String varA7E53CE21691AB073D9660D615818899_890315969; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_890315969 = varB4EAC82CA7396A68D541C85D26508E83_1872043221;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_890315969 = varB4EAC82CA7396A68D541C85D26508E83_983958443;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_890315969.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_890315969;
        // ---------- Original Method ----------
        //if (message.callback != null) {
            //return message.callback.getClass().getName();
        //}
        //return "0x" + Integer.toHexString(message.what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.684 -0400", hash_original_method = "3FA1D1E6850485EFDFF54C55EBFDD1CC", hash_generated_method = "C35E893509284D17F733A623946C2BCD")
    public final Message obtainMessage() {
        Message varB4EAC82CA7396A68D541C85D26508E83_604272715 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_604272715 = Message.obtain(this);
        varB4EAC82CA7396A68D541C85D26508E83_604272715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_604272715;
        // ---------- Original Method ----------
        //return Message.obtain(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.699 -0400", hash_original_method = "83ED22E0C23176DA2E639FBDA9F30743", hash_generated_method = "ECA9CC7968C27C00C030976AF24258EE")
    public final Message obtainMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_584251913 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_584251913 = Message.obtain(this, what);
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_584251913.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_584251913;
        // ---------- Original Method ----------
        //return Message.obtain(this, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.700 -0400", hash_original_method = "16AA2451698F7981D4974062DB733B90", hash_generated_method = "5448B953D5B628A94F170F18EB5C0B9F")
    public final Message obtainMessage(int what, Object obj) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1777469663 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1777469663 = Message.obtain(this, what, obj);
        addTaint(what);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1777469663.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1777469663;
        // ---------- Original Method ----------
        //return Message.obtain(this, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.700 -0400", hash_original_method = "E0C335742F8D26DCA388CDB62E97551F", hash_generated_method = "5EB879FCBE6EC4AB85C181FF017D3B6D")
    public final Message obtainMessage(int what, int arg1, int arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_962307606 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_962307606 = Message.obtain(this, what, arg1, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        varB4EAC82CA7396A68D541C85D26508E83_962307606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_962307606;
        // ---------- Original Method ----------
        //return Message.obtain(this, what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.720 -0400", hash_original_method = "73E3B8E788E4FE19D8B1D7007BFD268C", hash_generated_method = "AA346A90B72A92FDD77935EE578D3841")
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        Message varB4EAC82CA7396A68D541C85D26508E83_933809666 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_933809666 = Message.obtain(this, what, arg1, arg2, obj);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_933809666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_933809666;
        // ---------- Original Method ----------
        //return Message.obtain(this, what, arg1, arg2, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.721 -0400", hash_original_method = "6A0575D5625A2B33566AA17E837BEE40", hash_generated_method = "66F542D7F40A819C2A1FFAE3DB4E6FE3")
    public final boolean post(Runnable r) {
        boolean var7A01F528DFCD9F3B64D013796B5AEAEA_453589241 = (sendMessageDelayed(getPostMessage(r), 0));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780931888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780931888;
        // ---------- Original Method ----------
        //return  sendMessageDelayed(getPostMessage(r), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.721 -0400", hash_original_method = "AE818DFE2AFBC7BA2C1B26423E282D08", hash_generated_method = "A935268C658DC30ECF76D5620E1D85C2")
    public final boolean postAtTime(Runnable r, long uptimeMillis) {
        boolean varE06D54AE70CF1F1A96C302B669F59131_1045934292 = (sendMessageAtTime(getPostMessage(r), uptimeMillis));
        addTaint(r.getTaint());
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1019766011 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1019766011;
        // ---------- Original Method ----------
        //return sendMessageAtTime(getPostMessage(r), uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.722 -0400", hash_original_method = "545FD7F3E8EB84671B1FDA0DB6EB661F", hash_generated_method = "CF49F884FCB68DA1468A3E73D6228553")
    public final boolean postAtTime(Runnable r, Object token, long uptimeMillis) {
        boolean var3BAF00809B4281FFDC01C90B27A5CF75_1511779590 = (sendMessageAtTime(getPostMessage(r, token), uptimeMillis));
        addTaint(r.getTaint());
        addTaint(token.getTaint());
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_874422965 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_874422965;
        // ---------- Original Method ----------
        //return sendMessageAtTime(getPostMessage(r, token), uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.722 -0400", hash_original_method = "E41A8A27723BD019DF77785AB7446793", hash_generated_method = "858112FA366728841E6818BAF4DAFE88")
    public final boolean postDelayed(Runnable r, long delayMillis) {
        boolean varF8B393B58C339C87BBA330695569D4F5_82311892 = (sendMessageDelayed(getPostMessage(r), delayMillis));
        addTaint(r.getTaint());
        addTaint(delayMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1310812993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1310812993;
        // ---------- Original Method ----------
        //return sendMessageDelayed(getPostMessage(r), delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.727 -0400", hash_original_method = "349F8881748C55ABBCC660C80A5C77C8", hash_generated_method = "6B9463DDD21AA64871B56DFB1B736E64")
    public final boolean postAtFrontOfQueue(Runnable r) {
        boolean varBFA199A426AAF2B85E67B2328E173359_638402442 = (sendMessageAtFrontOfQueue(getPostMessage(r)));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1517831136 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1517831136;
        // ---------- Original Method ----------
        //return sendMessageAtFrontOfQueue(getPostMessage(r));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.743 -0400", hash_original_method = "EA17D2D89EBC0DA60DAE54B4D2813C6D", hash_generated_method = "19A443F0A686C5D1DFA3C6AEA93334E1")
    public final void removeCallbacks(Runnable r) {
        mQueue.removeMessages(this, r, null);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, r, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.744 -0400", hash_original_method = "159A6F4E93CA274BF5D9A61C57FA58AA", hash_generated_method = "B81059E219504F6CBFDDBEF6C09852EB")
    public final void removeCallbacks(Runnable r, Object token) {
        mQueue.removeMessages(this, r, token);
        addTaint(r.getTaint());
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, r, token);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.744 -0400", hash_original_method = "A97266028157506969A5B89288A9C9BC", hash_generated_method = "AB0DA636BEA41AF04ED5C3EA06D618F4")
    public final boolean sendMessage(Message msg) {
        boolean var61A3771F06272201631ECD7A68EAD4FF_1293007457 = (sendMessageDelayed(msg, 0));
        addTaint(msg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1261670255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1261670255;
        // ---------- Original Method ----------
        //return sendMessageDelayed(msg, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.745 -0400", hash_original_method = "A52967DD531D2E9895F5558692B5D99D", hash_generated_method = "67C68EAFCA52C920851DB4A59210BBAA")
    public final boolean sendEmptyMessage(int what) {
        boolean var4556D7D1710FA2FD730FBBBE12542C68_1211555100 = (sendEmptyMessageDelayed(what, 0));
        addTaint(what);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_230152848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_230152848;
        // ---------- Original Method ----------
        //return sendEmptyMessageDelayed(what, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.748 -0400", hash_original_method = "C345E8B6D42103BAB2779DE84E2F8005", hash_generated_method = "CA5EEBB949A1D31E8E952B85ADBFBE8A")
    public final boolean sendEmptyMessageDelayed(int what, long delayMillis) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        boolean var422D34FE7EBBD1E444F99420C6560E7D_1768471342 = (sendMessageDelayed(msg, delayMillis));
        addTaint(what);
        addTaint(delayMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1446433912 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1446433912;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //return sendMessageDelayed(msg, delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.752 -0400", hash_original_method = "0234DAD2CAD8EF6B170E56EDA713A580", hash_generated_method = "77248C9EDE3A0E9E2AEA9CD1B01DFE47")
    public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        boolean var6676E1BAAA52F02DEEF6C770E4ABF19C_1515612618 = (sendMessageAtTime(msg, uptimeMillis));
        addTaint(what);
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1767250551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1767250551;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //return sendMessageAtTime(msg, uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.753 -0400", hash_original_method = "F32DF35552A73512081963AF1F333EEC", hash_generated_method = "10814BA705A0D6D82939F26CA8E59CD1")
    public final boolean sendMessageDelayed(Message msg, long delayMillis) {
        {
            delayMillis = 0;
        } //End block
        boolean var1761F03F3EEFC16009DC3CA8E9725E10_851681804 = (sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis));
        addTaint(msg.getTaint());
        addTaint(delayMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1259358608 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1259358608;
        // ---------- Original Method ----------
        //if (delayMillis < 0) {
            //delayMillis = 0;
        //}
        //return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.767 -0400", hash_original_method = "9EBABACA140C9DF9A34851CFCEDCA0D2", hash_generated_method = "F49F86665DBE917A4DEA880B76CFDEFA")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667523612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_667523612;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.769 -0400", hash_original_method = "915CC0C6E8D23436D72B6BC5461B3284", hash_generated_method = "2E8057D8E277A56CDCB43ED43EA79942")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2001976794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2001976794;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.769 -0400", hash_original_method = "4176E8C258200D3721001C1E43AEA8B7", hash_generated_method = "596DC98388E02314F3D663DF1DBD1A82")
    public final void removeMessages(int what) {
        mQueue.removeMessages(this, what, null, true);
        addTaint(what);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, what, null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.773 -0400", hash_original_method = "23ED3231C29D8F11BAA051AB6C64E2F2", hash_generated_method = "77D5EA64BE5560CAF694E8030DA3E86B")
    public final void removeMessages(int what, Object object) {
        mQueue.removeMessages(this, what, object, true);
        addTaint(what);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, what, object, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.777 -0400", hash_original_method = "448E73D7B69D80F7826BA330AB50FE66", hash_generated_method = "6B402AB47C76673EE7A06907E80CC4A1")
    public final void removeCallbacksAndMessages(Object token) {
        mQueue.removeCallbacksAndMessages(this, token);
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //mQueue.removeCallbacksAndMessages(this, token);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.778 -0400", hash_original_method = "311185E2299156FD883BD00C28E38599", hash_generated_method = "6A6EA2032430BC1D496E3CBC6CAD32EA")
    public final boolean hasMessages(int what) {
        boolean var3318D5FB3681CEA99F369FDDCF03D4B8_1057760541 = (mQueue.removeMessages(this, what, null, false));
        addTaint(what);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166956461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166956461;
        // ---------- Original Method ----------
        //return mQueue.removeMessages(this, what, null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.778 -0400", hash_original_method = "49BF5F4269CD0924DE36FF7A410C4BAC", hash_generated_method = "C72C5903AD9071145B20893DB9F6419D")
    public final boolean hasMessages(int what, Object object) {
        boolean var09A85EE8C328ECF4A84EF4C40DF7B776_247938605 = (mQueue.removeMessages(this, what, object, false));
        addTaint(what);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1655936990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1655936990;
        // ---------- Original Method ----------
        //return mQueue.removeMessages(this, what, object, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.791 -0400", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "1522C216177A2A7D801965EE9EA4A596")
    public final Looper getLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_598046367 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_598046367 = mLooper;
        varB4EAC82CA7396A68D541C85D26508E83_598046367.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_598046367;
        // ---------- Original Method ----------
        //return mLooper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.792 -0400", hash_original_method = "F69D7CBFCB904B3AB08CCA20C9F65B2F", hash_generated_method = "F34828814FA68CDBD9F822D3B537392E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.793 -0400", hash_original_method = "05520CD35CB4412A1070385C35DB25A1", hash_generated_method = "D20C9DB26AC897FF3D267258B4A06196")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_559868874 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_559868874 = "Handler (" + getClass().getName() + ") {"
        + Integer.toHexString(System.identityHashCode(this))
        + "}";
        varB4EAC82CA7396A68D541C85D26508E83_559868874.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_559868874;
        // ---------- Original Method ----------
        //return "Handler (" + getClass().getName() + ") {"
        //+ Integer.toHexString(System.identityHashCode(this))
        //+ "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.805 -0400", hash_original_method = "022CD131F6EA96B24851C91C40C740AA", hash_generated_method = "6684C21FAB0EF92FB82899A53BD5C2AA")
    final IMessenger getIMessenger() {
        IMessenger varB4EAC82CA7396A68D541C85D26508E83_423654683 = null; //Variable for return #1
        IMessenger varB4EAC82CA7396A68D541C85D26508E83_589546079 = null; //Variable for return #2
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_423654683 = mMessenger;
            } //End block
            mMessenger = new MessengerImpl();
            varB4EAC82CA7396A68D541C85D26508E83_589546079 = mMessenger;
        } //End block
        IMessenger varA7E53CE21691AB073D9660D615818899_1199850296; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1199850296 = varB4EAC82CA7396A68D541C85D26508E83_423654683;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1199850296 = varB4EAC82CA7396A68D541C85D26508E83_589546079;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1199850296.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1199850296;
        // ---------- Original Method ----------
        //synchronized (mQueue) {
            //if (mMessenger != null) {
                //return mMessenger;
            //}
            //mMessenger = new MessengerImpl();
            //return mMessenger;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.806 -0400", hash_original_method = "9DFB5128F30D3CFE7C2F086A6667AA29", hash_generated_method = "BC2E71728D296339C818A876AFEA3A61")
    private final Message getPostMessage(Runnable r) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1492490585 = null; //Variable for return #1
        Message m;
        m = Message.obtain();
        m.callback = r;
        varB4EAC82CA7396A68D541C85D26508E83_1492490585 = m;
        addTaint(r.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1492490585.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1492490585;
        // ---------- Original Method ----------
        //Message m = Message.obtain();
        //m.callback = r;
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.817 -0400", hash_original_method = "001850E10F072AF670657F2F37A16A9C", hash_generated_method = "7A029BFAC5FFA9A3CC0DD92A461E9990")
    private final Message getPostMessage(Runnable r, Object token) {
        Message varB4EAC82CA7396A68D541C85D26508E83_787908311 = null; //Variable for return #1
        Message m;
        m = Message.obtain();
        m.obj = token;
        m.callback = r;
        varB4EAC82CA7396A68D541C85D26508E83_787908311 = m;
        addTaint(r.getTaint());
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_787908311.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_787908311;
        // ---------- Original Method ----------
        //Message m = Message.obtain();
        //m.obj = token;
        //m.callback = r;
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.818 -0400", hash_original_method = "6CA31B63D4772009E291A8EEE8116A2F", hash_generated_method = "E3D7BD18C18A1C9B4EF9E7B89730EA91")
    private final void handleCallback(Message message) {
        message.callback.run();
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //message.callback.run();
    }

    
    private final class MessengerImpl extends IMessenger.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.825 -0400", hash_original_method = "68A768E132C1125DE9510AF39EB42EE7", hash_generated_method = "68A768E132C1125DE9510AF39EB42EE7")
        public MessengerImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.832 -0400", hash_original_method = "CF11BADC884B068E4FC98150B23E5EB1", hash_generated_method = "CE1189B26F74072764E72C8583836693")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.833 -0400", hash_original_field = "E98C260B28FA80AA89F6D5E5597392E0", hash_generated_field = "85F8EDE7194C9C1A1A22315BDC750456")

    private static boolean FIND_POTENTIAL_LEAKS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:27.833 -0400", hash_original_field = "C705D79D983762D5A9E5A78751871C79", hash_generated_field = "8914EFEA99C29A6C7B19CF4C0DC11F7B")

    private static String TAG = "Handler";
}

