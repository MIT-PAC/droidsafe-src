package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Modifier;

public class Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.181 -0400", hash_original_field = "2D043F2822EC0D4E2690BDFE63EDDFCA", hash_generated_field = "331CAFDD37154BFFB4C27FB1EC4DE2ED")

    MessageQueue mQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.181 -0400", hash_original_field = "DA288C1345E9C94467C02060ED19C6FA", hash_generated_field = "4C6A73D1D5351706C43659B423CF9288")

    Looper mLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.181 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "1A99E72B6409E38FBCC780D1BAB4898D")

    Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.181 -0400", hash_original_field = "83FE717B4B643B5D605C868F0E136C03", hash_generated_field = "35095A7AFB955F43B213705056D01A47")

    IMessenger mMessenger;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.182 -0400", hash_original_method = "BF99A47DD8BD9030B611C5F1BD90EC8F", hash_generated_method = "ADB181AE50C1210FEB4DD228DF6C5B25")
    public  Handler() {
        if(FIND_POTENTIAL_LEAKS)        
        {
            final Class<? extends Handler> klass = getClass();
            if((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0)            
            {
            } //End block
        } //End block
        mLooper = Looper.myLooper();
        if(mLooper == null)        
        {
            RuntimeException varE0339C4E2D2CC3153FF43A285C10CA3B_413916061 = new RuntimeException(
                "Can't create handler inside thread that has not called Looper.prepare()");
            varE0339C4E2D2CC3153FF43A285C10CA3B_413916061.addTaint(taint);
            throw varE0339C4E2D2CC3153FF43A285C10CA3B_413916061;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.183 -0400", hash_original_method = "4145BBA061FAEF73002F915149455D35", hash_generated_method = "BE3567660A33D7ED1E7E70050DC9D0DA")
    public  Handler(Callback callback) {
        if(FIND_POTENTIAL_LEAKS)        
        {
            final Class<? extends Handler> klass = getClass();
            if((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0)            
            {
            } //End block
        } //End block
        mLooper = Looper.myLooper();
        if(mLooper == null)        
        {
            RuntimeException varE0339C4E2D2CC3153FF43A285C10CA3B_1567235497 = new RuntimeException(
                "Can't create handler inside thread that has not called Looper.prepare()");
            varE0339C4E2D2CC3153FF43A285C10CA3B_1567235497.addTaint(taint);
            throw varE0339C4E2D2CC3153FF43A285C10CA3B_1567235497;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.183 -0400", hash_original_method = "878DD6FD2A8B0F6865454043C68D5888", hash_generated_method = "9B81A69A46DF15261D6C68147933E52E")
    public  Handler(Looper looper) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = null;
        // ---------- Original Method ----------
        //mLooper = looper;
        //mQueue = looper.mQueue;
        //mCallback = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.184 -0400", hash_original_method = "0F1A18EF6331120AB094322F735FD8FC", hash_generated_method = "43AB9E70D0EFEBDC964E78082CA1DB45")
    public  Handler(Looper looper, Callback callback) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = callback;
        // ---------- Original Method ----------
        //mLooper = looper;
        //mQueue = looper.mQueue;
        //mCallback = callback;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.184 -0400", hash_original_method = "C13ECA453D39BD1621DCBD4764283A41", hash_generated_method = "6C9E5B782C82352543D0D7A957AAB817")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.185 -0400", hash_original_method = "1565D7D72E28223A47E7963B114AD9E6", hash_generated_method = "1131D6C31E6AF3687EF1C18804BCED1A")
    public void dispatchMessage(Message msg) {
        addTaint(msg.getTaint());
        if(msg.callback != null)        
        {
            handleCallback(msg);
        } //End block
        else
        {
            if(mCallback != null)            
            {
                if(mCallback.handleMessage(msg))                
                {
                    return;
                } //End block
            } //End block
            handleMessage(msg);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.185 -0400", hash_original_method = "7AEB9F9BBB8F24805A35E34BFA8BA452", hash_generated_method = "E8C9EB7A3A8BB169BE19C4BB95B4A816")
    public String getMessageName(Message message) {
        addTaint(message.getTaint());
        if(message.callback != null)        
        {
String varF3D40722B9411601D9DEC5D89A0C385A_1218770334 =             message.callback.getClass().getName();
            varF3D40722B9411601D9DEC5D89A0C385A_1218770334.addTaint(taint);
            return varF3D40722B9411601D9DEC5D89A0C385A_1218770334;
        } //End block
String varBD10C5CB802C447840087B8DCE03339E_512758296 =         "0x" + Integer.toHexString(message.what);
        varBD10C5CB802C447840087B8DCE03339E_512758296.addTaint(taint);
        return varBD10C5CB802C447840087B8DCE03339E_512758296;
        // ---------- Original Method ----------
        //if (message.callback != null) {
            //return message.callback.getClass().getName();
        //}
        //return "0x" + Integer.toHexString(message.what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.186 -0400", hash_original_method = "3FA1D1E6850485EFDFF54C55EBFDD1CC", hash_generated_method = "BA2249868DCD57B69951CFFC86A4E6DE")
    public final Message obtainMessage() {
Message varFFE27A75B51A30F9F839C92C3BD965AA_239562589 =         Message.obtain(this);
        varFFE27A75B51A30F9F839C92C3BD965AA_239562589.addTaint(taint);
        return varFFE27A75B51A30F9F839C92C3BD965AA_239562589;
        // ---------- Original Method ----------
        //return Message.obtain(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.186 -0400", hash_original_method = "83ED22E0C23176DA2E639FBDA9F30743", hash_generated_method = "8B3D6D0861BD2D931B3878D89051E987")
    public final Message obtainMessage(int what) {
        addTaint(what);
Message varB83CC02BCA711F53AC867766194BA4A9_878245815 =         Message.obtain(this, what);
        varB83CC02BCA711F53AC867766194BA4A9_878245815.addTaint(taint);
        return varB83CC02BCA711F53AC867766194BA4A9_878245815;
        // ---------- Original Method ----------
        //return Message.obtain(this, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.187 -0400", hash_original_method = "16AA2451698F7981D4974062DB733B90", hash_generated_method = "3DD1AEF387A0A5B753A310DCA6D9F9DF")
    public final Message obtainMessage(int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
Message varD3C972A66109A6F4788882442061F6EC_2113843980 =         Message.obtain(this, what, obj);
        varD3C972A66109A6F4788882442061F6EC_2113843980.addTaint(taint);
        return varD3C972A66109A6F4788882442061F6EC_2113843980;
        // ---------- Original Method ----------
        //return Message.obtain(this, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.188 -0400", hash_original_method = "E0C335742F8D26DCA388CDB62E97551F", hash_generated_method = "664780E5F9CCD370FFE52B5D64FCC36C")
    public final Message obtainMessage(int what, int arg1, int arg2) {
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
Message var32A3C44FDE40EBD19E7DA8DF27C78804_341926621 =         Message.obtain(this, what, arg1, arg2);
        var32A3C44FDE40EBD19E7DA8DF27C78804_341926621.addTaint(taint);
        return var32A3C44FDE40EBD19E7DA8DF27C78804_341926621;
        // ---------- Original Method ----------
        //return Message.obtain(this, what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.188 -0400", hash_original_method = "73E3B8E788E4FE19D8B1D7007BFD268C", hash_generated_method = "6455FA050B52A52036376FCC30996D3F")
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        addTaint(obj.getTaint());
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
Message var70261DC0D432637FC67FB7F77AF0394F_1004158441 =         Message.obtain(this, what, arg1, arg2, obj);
        var70261DC0D432637FC67FB7F77AF0394F_1004158441.addTaint(taint);
        return var70261DC0D432637FC67FB7F77AF0394F_1004158441;
        // ---------- Original Method ----------
        //return Message.obtain(this, what, arg1, arg2, obj);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.189 -0400", hash_original_method = "6A0575D5625A2B33566AA17E837BEE40", hash_generated_method = "000B9D64CD31CB3C3813F912C1C88337")
    public final boolean post(Runnable r) {
        addTaint(r.getTaint());
        boolean var4413CE19446E04BCB84D4DC5AEC33B62_1827683630 = (sendMessageDelayed(getPostMessage(r), 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_979959899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_979959899;
        // ---------- Original Method ----------
        //return  sendMessageDelayed(getPostMessage(r), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.189 -0400", hash_original_method = "AE818DFE2AFBC7BA2C1B26423E282D08", hash_generated_method = "722F776DEF3F69564311364C7A54F13F")
    public final boolean postAtTime(Runnable r, long uptimeMillis) {
        addTaint(uptimeMillis);
        addTaint(r.getTaint());
        boolean var5EAF99ABE6C713AF48B56B1E000FCEC9_253528632 = (sendMessageAtTime(getPostMessage(r), uptimeMillis));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1768351745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1768351745;
        // ---------- Original Method ----------
        //return sendMessageAtTime(getPostMessage(r), uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.189 -0400", hash_original_method = "545FD7F3E8EB84671B1FDA0DB6EB661F", hash_generated_method = "D546F0FF05C44FD9343704C13521F54C")
    public final boolean postAtTime(Runnable r, Object token, long uptimeMillis) {
        addTaint(uptimeMillis);
        addTaint(token.getTaint());
        addTaint(r.getTaint());
        boolean var3C369DA4877DB86952E37548CBBA0F23_696097672 = (sendMessageAtTime(getPostMessage(r, token), uptimeMillis));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1012192901 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1012192901;
        // ---------- Original Method ----------
        //return sendMessageAtTime(getPostMessage(r, token), uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.190 -0400", hash_original_method = "E41A8A27723BD019DF77785AB7446793", hash_generated_method = "FCC58E17B47ACC668E8B8D4E825667D7")
    public final boolean postDelayed(Runnable r, long delayMillis) {
        addTaint(delayMillis);
        addTaint(r.getTaint());
        boolean varD13B1F096E34E0983BB1809C1512F79B_795689109 = (sendMessageDelayed(getPostMessage(r), delayMillis));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_37468861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_37468861;
        // ---------- Original Method ----------
        //return sendMessageDelayed(getPostMessage(r), delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.190 -0400", hash_original_method = "349F8881748C55ABBCC660C80A5C77C8", hash_generated_method = "2153CAC249026E84EA78535624AEB26C")
    public final boolean postAtFrontOfQueue(Runnable r) {
        addTaint(r.getTaint());
        boolean var3C1D95E160676D2525C06F5BDD5C684B_616151826 = (sendMessageAtFrontOfQueue(getPostMessage(r)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_767127774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_767127774;
        // ---------- Original Method ----------
        //return sendMessageAtFrontOfQueue(getPostMessage(r));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.190 -0400", hash_original_method = "EA17D2D89EBC0DA60DAE54B4D2813C6D", hash_generated_method = "EEDBB718F3FB992DA549CA845188E3BF")
    public final void removeCallbacks(Runnable r) {
        addTaint(r.getTaint());
        mQueue.removeMessages(this, r, null);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, r, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.191 -0400", hash_original_method = "159A6F4E93CA274BF5D9A61C57FA58AA", hash_generated_method = "16D81BAF9EF29772FE22941EF3AC9227")
    public final void removeCallbacks(Runnable r, Object token) {
        addTaint(token.getTaint());
        addTaint(r.getTaint());
        mQueue.removeMessages(this, r, token);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, r, token);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.191 -0400", hash_original_method = "A97266028157506969A5B89288A9C9BC", hash_generated_method = "D8973093541F30FD8C5C6A82A7F7B27F")
    public final boolean sendMessage(Message msg) {
        addTaint(msg.getTaint());
        boolean var781D95A1A0E5AD31CA0E5FE11DC07AEE_1934082548 = (sendMessageDelayed(msg, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_712562155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_712562155;
        // ---------- Original Method ----------
        //return sendMessageDelayed(msg, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.191 -0400", hash_original_method = "A52967DD531D2E9895F5558692B5D99D", hash_generated_method = "1685BC216927A55C3D8557C8D2E67D8C")
    public final boolean sendEmptyMessage(int what) {
        addTaint(what);
        boolean var286459B55505DABFD0566347297BCD66_333817036 = (sendEmptyMessageDelayed(what, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802911030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802911030;
        // ---------- Original Method ----------
        //return sendEmptyMessageDelayed(what, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.192 -0400", hash_original_method = "C345E8B6D42103BAB2779DE84E2F8005", hash_generated_method = "D23A61A5BD5036ABCE9731C91A406F45")
    public final boolean sendEmptyMessageDelayed(int what, long delayMillis) {
        addTaint(delayMillis);
        addTaint(what);
        Message msg = Message.obtain();
        msg.what = what;
        boolean var8F36A808C0E7E801F9E5E1C2C84A55EE_833382909 = (sendMessageDelayed(msg, delayMillis));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_781781653 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_781781653;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //return sendMessageDelayed(msg, delayMillis);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.192 -0400", hash_original_method = "0234DAD2CAD8EF6B170E56EDA713A580", hash_generated_method = "8FD8BAD9CC977CB0B9816D10251BC3E4")
    public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {
        addTaint(uptimeMillis);
        addTaint(what);
        Message msg = Message.obtain();
        msg.what = what;
        boolean var1BE13E139C4674878DD5E851EB6CA6BB_1596590083 = (sendMessageAtTime(msg, uptimeMillis));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_474074704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_474074704;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //return sendMessageAtTime(msg, uptimeMillis);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.193 -0400", hash_original_method = "F32DF35552A73512081963AF1F333EEC", hash_generated_method = "D938876CBAAA0559E74560D4CFA7A2F4")
    public final boolean sendMessageDelayed(Message msg, long delayMillis) {
        addTaint(delayMillis);
        addTaint(msg.getTaint());
        if(delayMillis < 0)        
        {
            delayMillis = 0;
        } //End block
        boolean var41AAB0AB386CC896858254072DDAFBE7_151027030 = (sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2007187055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2007187055;
        // ---------- Original Method ----------
        //if (delayMillis < 0) {
            //delayMillis = 0;
        //}
        //return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.193 -0400", hash_original_method = "9EBABACA140C9DF9A34851CFCEDCA0D2", hash_generated_method = "A70FB8AF6135A3A4CE1683988EEAD4D2")
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        addTaint(uptimeMillis);
        addTaint(msg.getTaint());
        boolean sent = false;
        MessageQueue queue = mQueue;
        if(queue != null)        
        {
            msg.target = this;
            sent = queue.enqueueMessage(msg, uptimeMillis);
        } //End block
        else
        {
            RuntimeException e = new RuntimeException(
                this + " sendMessageAtTime() called with no mQueue");
        } //End block
        boolean var789183B7E98646C11D5F0544C8F3C4C9_1620293872 = (sent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1243274139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1243274139;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.194 -0400", hash_original_method = "915CC0C6E8D23436D72B6BC5461B3284", hash_generated_method = "E105A1EE3EB53FAFB97E1E17E6C1DBAF")
    public final boolean sendMessageAtFrontOfQueue(Message msg) {
        addTaint(msg.getTaint());
        boolean sent = false;
        MessageQueue queue = mQueue;
        if(queue != null)        
        {
            msg.target = this;
            sent = queue.enqueueMessage(msg, 0);
        } //End block
        else
        {
            RuntimeException e = new RuntimeException(
                this + " sendMessageAtTime() called with no mQueue");
        } //End block
        boolean var789183B7E98646C11D5F0544C8F3C4C9_1276752953 = (sent);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_746478888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_746478888;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.194 -0400", hash_original_method = "4176E8C258200D3721001C1E43AEA8B7", hash_generated_method = "D9759DBD74B056D29ED9618D44A94932")
    public final void removeMessages(int what) {
        addTaint(what);
        mQueue.removeMessages(this, what, null, true);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, what, null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.194 -0400", hash_original_method = "23ED3231C29D8F11BAA051AB6C64E2F2", hash_generated_method = "FF3409D4DA853397A158DBF3B30C0A24")
    public final void removeMessages(int what, Object object) {
        addTaint(object.getTaint());
        addTaint(what);
        mQueue.removeMessages(this, what, object, true);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, what, object, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.195 -0400", hash_original_method = "448E73D7B69D80F7826BA330AB50FE66", hash_generated_method = "AD1769327C67F43DBE328D4CF697FB3D")
    public final void removeCallbacksAndMessages(Object token) {
        addTaint(token.getTaint());
        mQueue.removeCallbacksAndMessages(this, token);
        // ---------- Original Method ----------
        //mQueue.removeCallbacksAndMessages(this, token);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.195 -0400", hash_original_method = "311185E2299156FD883BD00C28E38599", hash_generated_method = "6E9B84B3875DB934F1FEEC156DEE8D65")
    public final boolean hasMessages(int what) {
        addTaint(what);
        boolean varFE8C582CD938F501217339A00CE7467B_655743134 = (mQueue.removeMessages(this, what, null, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1789558600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1789558600;
        // ---------- Original Method ----------
        //return mQueue.removeMessages(this, what, null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.196 -0400", hash_original_method = "49BF5F4269CD0924DE36FF7A410C4BAC", hash_generated_method = "2802A651D239C24CA0C9CB1DC32CB8D2")
    public final boolean hasMessages(int what, Object object) {
        addTaint(object.getTaint());
        addTaint(what);
        boolean var9F285325104F534BC5F56EF97D070B9E_635394624 = (mQueue.removeMessages(this, what, object, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1465823123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1465823123;
        // ---------- Original Method ----------
        //return mQueue.removeMessages(this, what, object, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.196 -0400", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "E9497F0FDCE64AD0255EB0DAF1FFF654")
    public final Looper getLooper() {
Looper var0D78717954912E9F181D5C0583378DCC_1240597851 =         mLooper;
        var0D78717954912E9F181D5C0583378DCC_1240597851.addTaint(taint);
        return var0D78717954912E9F181D5C0583378DCC_1240597851;
        // ---------- Original Method ----------
        //return mLooper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.196 -0400", hash_original_method = "F69D7CBFCB904B3AB08CCA20C9F65B2F", hash_generated_method = "1272C692FC76049E07274D24A6F80244")
    public final void dump(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        pw.println(prefix + this + " @ " + SystemClock.uptimeMillis());
        if(mLooper == null)        
        {
            pw.println(prefix + "looper uninitialized");
        } //End block
        else
        {
            mLooper.dump(pw, prefix + "  ");
        } //End block
        // ---------- Original Method ----------
        //pw.println(prefix + this + " @ " + SystemClock.uptimeMillis());
        //if (mLooper == null) {
            //pw.println(prefix + "looper uninitialized");
        //} else {
            //mLooper.dump(pw, prefix + "  ");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.197 -0400", hash_original_method = "05520CD35CB4412A1070385C35DB25A1", hash_generated_method = "7D20E02239C5324BAFB05D167403E036")
    @Override
    public String toString() {
String var0C1471386DF22590A5BBFD7BB2A28056_2046719607 =         "Handler (" + getClass().getName() + ") {"
        + Integer.toHexString(System.identityHashCode(this))
        + "}";
        var0C1471386DF22590A5BBFD7BB2A28056_2046719607.addTaint(taint);
        return var0C1471386DF22590A5BBFD7BB2A28056_2046719607;
        // ---------- Original Method ----------
        //return "Handler (" + getClass().getName() + ") {"
        //+ Integer.toHexString(System.identityHashCode(this))
        //+ "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.197 -0400", hash_original_method = "022CD131F6EA96B24851C91C40C740AA", hash_generated_method = "9707055051AEBAB2992892766405D0A4")
    final IMessenger getIMessenger() {
        synchronized
(mQueue)        {
            if(mMessenger != null)            
            {
IMessenger var8654BE9299324672E260B3FAC70B3CD7_969074813 =                 mMessenger;
                var8654BE9299324672E260B3FAC70B3CD7_969074813.addTaint(taint);
                return var8654BE9299324672E260B3FAC70B3CD7_969074813;
            } //End block
            mMessenger = new MessengerImpl();
IMessenger var8654BE9299324672E260B3FAC70B3CD7_1697484095 =             mMessenger;
            var8654BE9299324672E260B3FAC70B3CD7_1697484095.addTaint(taint);
            return var8654BE9299324672E260B3FAC70B3CD7_1697484095;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mQueue) {
            //if (mMessenger != null) {
                //return mMessenger;
            //}
            //mMessenger = new MessengerImpl();
            //return mMessenger;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.198 -0400", hash_original_method = "9DFB5128F30D3CFE7C2F086A6667AA29", hash_generated_method = "7A0E38B0CA114937C88B63C9667B1189")
    private final Message getPostMessage(Runnable r) {
        addTaint(r.getTaint());
        Message m = Message.obtain();
        m.callback = r;
Message varBD22C5ECD1F8BC3EE2416AF7A8014FD2_133403432 =         m;
        varBD22C5ECD1F8BC3EE2416AF7A8014FD2_133403432.addTaint(taint);
        return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_133403432;
        // ---------- Original Method ----------
        //Message m = Message.obtain();
        //m.callback = r;
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.198 -0400", hash_original_method = "001850E10F072AF670657F2F37A16A9C", hash_generated_method = "6235723CFA24093D4F4B058EC19D1BB1")
    private final Message getPostMessage(Runnable r, Object token) {
        addTaint(token.getTaint());
        addTaint(r.getTaint());
        Message m = Message.obtain();
        m.obj = token;
        m.callback = r;
Message varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1475378870 =         m;
        varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1475378870.addTaint(taint);
        return varBD22C5ECD1F8BC3EE2416AF7A8014FD2_1475378870;
        // ---------- Original Method ----------
        //Message m = Message.obtain();
        //m.obj = token;
        //m.callback = r;
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.199 -0400", hash_original_method = "6CA31B63D4772009E291A8EEE8116A2F", hash_generated_method = "4F5BF0AD5154E4E243D5141532570008")
    private final void handleCallback(Message message) {
        addTaint(message.getTaint());
        message.callback.run();
        // ---------- Original Method ----------
        //message.callback.run();
    }

    
    private final class MessengerImpl extends IMessenger.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.199 -0400", hash_original_method = "68A768E132C1125DE9510AF39EB42EE7", hash_generated_method = "68A768E132C1125DE9510AF39EB42EE7")
        public MessengerImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.199 -0400", hash_original_method = "CF11BADC884B068E4FC98150B23E5EB1", hash_generated_method = "3D5BFAE5EFAA50E33F179B6665E82D73")
        public void send(Message msg) {
            addTaint(msg.getTaint());
            Handler.this.sendMessage(msg);
            // ---------- Original Method ----------
            //Handler.this.sendMessage(msg);
        }

        
    }


    
    public interface Callback {
        public boolean handleMessage(Message msg);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.199 -0400", hash_original_field = "E98C260B28FA80AA89F6D5E5597392E0", hash_generated_field = "0511AC5400F6AB0B4374BEAACA5C07BE")

    private static final boolean FIND_POTENTIAL_LEAKS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:26.199 -0400", hash_original_field = "C705D79D983762D5A9E5A78751871C79", hash_generated_field = "BFB213888655CBD96A5FA5BA90716E2A")

    private static final String TAG = "Handler";
}

