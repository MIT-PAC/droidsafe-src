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
    MessageQueue mQueue;
    Looper mLooper;
    Callback mCallback;
    IMessenger mMessenger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.527 -0400", hash_original_method = "BF99A47DD8BD9030B611C5F1BD90EC8F", hash_generated_method = "2D8BED8053D23809457495C36E905D55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Handler() {
        {
            Class<? extends Handler> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_1578144215 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.527 -0400", hash_original_method = "4145BBA061FAEF73002F915149455D35", hash_generated_method = "DBD455ADF04562678C896F69E3087503")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Handler(Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        {
            Class<? extends Handler> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_800136153 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0);
            } //End collapsed parenthetic
        } //End block
        mLooper = Looper.myLooper();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "Can't create handler inside thread that has not called Looper.prepare()");
        } //End block
        mQueue = mLooper.mQueue;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.527 -0400", hash_original_method = "878DD6FD2A8B0F6865454043C68D5888", hash_generated_method = "F7FFCD60F697E1238154A07B5A1B754A")
    @DSModeled(DSC.SAFE)
    public Handler(Looper looper) {
        dsTaint.addTaint(looper.dsTaint);
        mQueue = looper.mQueue;
        mCallback = null;
        // ---------- Original Method ----------
        //mLooper = looper;
        //mQueue = looper.mQueue;
        //mCallback = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.528 -0400", hash_original_method = "0F1A18EF6331120AB094322F735FD8FC", hash_generated_method = "39C566975D77D1ECCE492DD4922F002B")
    @DSModeled(DSC.SAFE)
    public Handler(Looper looper, Callback callback) {
        dsTaint.addTaint(looper.dsTaint);
        dsTaint.addTaint(callback.dsTaint);
        mQueue = looper.mQueue;
        // ---------- Original Method ----------
        //mLooper = looper;
        //mQueue = looper.mQueue;
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.528 -0400", hash_original_method = "C13ECA453D39BD1621DCBD4764283A41", hash_generated_method = "B40ECDDCDE771B96B93715CE4FFD7150")
    @DSModeled(DSC.SAFE)
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.529 -0400", hash_original_method = "1565D7D72E28223A47E7963B114AD9E6", hash_generated_method = "B86B28886902B135A037F7AE53BA1B04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            handleCallback(msg);
        } //End block
        {
            {
                {
                    boolean var40429B7E6C52EDCF4719B5E6B95BAF9A_1307180484 = (mCallback.handleMessage(msg));
                } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.529 -0400", hash_original_method = "7AEB9F9BBB8F24805A35E34BFA8BA452", hash_generated_method = "FB5AC9FA2C7EE89B15B4FD070D4FDE57")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMessageName(Message message) {
        dsTaint.addTaint(message.dsTaint);
        {
            String var5813D9B6BD8F3923738F21B8D9294584_1127885367 = (message.callback.getClass().getName());
        } //End block
        String var1118157A0EDF9DCF1E9A816FA4D45E8C_1385596951 = ("0x" + Integer.toHexString(message.what));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (message.callback != null) {
            //return message.callback.getClass().getName();
        //}
        //return "0x" + Integer.toHexString(message.what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.529 -0400", hash_original_method = "3FA1D1E6850485EFDFF54C55EBFDD1CC", hash_generated_method = "A7DB3E21A532E449C11B9829FFF11D35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage() {
        Message var19BF8B9E7C32DF339B8BD7E22E614C84_1470108707 = (Message.obtain(this));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Message.obtain(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.530 -0400", hash_original_method = "83ED22E0C23176DA2E639FBDA9F30743", hash_generated_method = "395A0EE254C617724A83127D0EEBF798")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what) {
        dsTaint.addTaint(what);
        Message var84E7C4E748CAFCDFCD7FDC49B909D4A4_891051666 = (Message.obtain(this, what));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Message.obtain(this, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.530 -0400", hash_original_method = "16AA2451698F7981D4974062DB733B90", hash_generated_method = "EB62F7255E49A3AC2AA941C3EB32C44F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        Message var991EB1896EE6924BE55C65D85D99E725_318987042 = (Message.obtain(this, what, obj));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Message.obtain(this, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.530 -0400", hash_original_method = "E0C335742F8D26DCA388CDB62E97551F", hash_generated_method = "566557DB639EF9144AD1436C8413C539")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message var20E0EE76C9627FAF70A37529FF275EFD_1245383261 = (Message.obtain(this, what, arg1, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Message.obtain(this, what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.530 -0400", hash_original_method = "73E3B8E788E4FE19D8B1D7007BFD268C", hash_generated_method = "D80CB6268150ECF12EFC3EF1BA286EBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        Message var908529AE03CEFF1A1D33D61B5F9BF8BA_1619798100 = (Message.obtain(this, what, arg1, arg2, obj));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Message.obtain(this, what, arg1, arg2, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.531 -0400", hash_original_method = "6A0575D5625A2B33566AA17E837BEE40", hash_generated_method = "9B5CD45B56117C783C4B71618B5A33E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean post(Runnable r) {
        dsTaint.addTaint(r.dsTaint);
        boolean var7A01F528DFCD9F3B64D013796B5AEAEA_85055791 = (sendMessageDelayed(getPostMessage(r), 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return  sendMessageDelayed(getPostMessage(r), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.531 -0400", hash_original_method = "AE818DFE2AFBC7BA2C1B26423E282D08", hash_generated_method = "DDBC803FFF173C35120794F7ADF9D402")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean postAtTime(Runnable r, long uptimeMillis) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(uptimeMillis);
        boolean varE06D54AE70CF1F1A96C302B669F59131_374601031 = (sendMessageAtTime(getPostMessage(r), uptimeMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendMessageAtTime(getPostMessage(r), uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.531 -0400", hash_original_method = "545FD7F3E8EB84671B1FDA0DB6EB661F", hash_generated_method = "9A46765E80798D0B2E89BDDCC015F97E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean postAtTime(Runnable r, Object token, long uptimeMillis) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(uptimeMillis);
        boolean var3BAF00809B4281FFDC01C90B27A5CF75_1190431878 = (sendMessageAtTime(getPostMessage(r, token), uptimeMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendMessageAtTime(getPostMessage(r, token), uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.531 -0400", hash_original_method = "E41A8A27723BD019DF77785AB7446793", hash_generated_method = "6C22FC1A7CBD5944E79E00AC92B6290F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean postDelayed(Runnable r, long delayMillis) {
        dsTaint.addTaint(delayMillis);
        dsTaint.addTaint(r.dsTaint);
        boolean varF8B393B58C339C87BBA330695569D4F5_1022171392 = (sendMessageDelayed(getPostMessage(r), delayMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendMessageDelayed(getPostMessage(r), delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.532 -0400", hash_original_method = "349F8881748C55ABBCC660C80A5C77C8", hash_generated_method = "CFA74DD8AEA5C6640AA849363B26C42B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean postAtFrontOfQueue(Runnable r) {
        dsTaint.addTaint(r.dsTaint);
        boolean varBFA199A426AAF2B85E67B2328E173359_514640332 = (sendMessageAtFrontOfQueue(getPostMessage(r)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendMessageAtFrontOfQueue(getPostMessage(r));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.532 -0400", hash_original_method = "EA17D2D89EBC0DA60DAE54B4D2813C6D", hash_generated_method = "342387D3A0A1545571AF048892CF92A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void removeCallbacks(Runnable r) {
        dsTaint.addTaint(r.dsTaint);
        mQueue.removeMessages(this, r, null);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, r, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.532 -0400", hash_original_method = "159A6F4E93CA274BF5D9A61C57FA58AA", hash_generated_method = "5FAA336A31EEF2F950E6E55FEA6F7EFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void removeCallbacks(Runnable r, Object token) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        mQueue.removeMessages(this, r, token);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, r, token);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.533 -0400", hash_original_method = "A97266028157506969A5B89288A9C9BC", hash_generated_method = "1048FEF0BA2BB5CFE0EDB2EAEDE52C00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        boolean var61A3771F06272201631ECD7A68EAD4FF_1467802593 = (sendMessageDelayed(msg, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendMessageDelayed(msg, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.533 -0400", hash_original_method = "A52967DD531D2E9895F5558692B5D99D", hash_generated_method = "BF4957098A76E7F2E28CB774054D09D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendEmptyMessage(int what) {
        dsTaint.addTaint(what);
        boolean var4556D7D1710FA2FD730FBBBE12542C68_1220363002 = (sendEmptyMessageDelayed(what, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendEmptyMessageDelayed(what, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.534 -0400", hash_original_method = "C345E8B6D42103BAB2779DE84E2F8005", hash_generated_method = "B8EB48D3C8ABF908CBBA0DB9546FEC49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendEmptyMessageDelayed(int what, long delayMillis) {
        dsTaint.addTaint(delayMillis);
        dsTaint.addTaint(what);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        boolean var422D34FE7EBBD1E444F99420C6560E7D_1323572718 = (sendMessageDelayed(msg, delayMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //return sendMessageDelayed(msg, delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.536 -0400", hash_original_method = "0234DAD2CAD8EF6B170E56EDA713A580", hash_generated_method = "2B244C30FCC207C5CC362400996E19DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(uptimeMillis);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        boolean var6676E1BAAA52F02DEEF6C770E4ABF19C_1384281223 = (sendMessageAtTime(msg, uptimeMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //return sendMessageAtTime(msg, uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.537 -0400", hash_original_method = "F32DF35552A73512081963AF1F333EEC", hash_generated_method = "B562516C75E3E09A6116C59FEB6224C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendMessageDelayed(Message msg, long delayMillis) {
        dsTaint.addTaint(delayMillis);
        dsTaint.addTaint(msg.dsTaint);
        {
            delayMillis = 0;
        } //End block
        boolean var1761F03F3EEFC16009DC3CA8E9725E10_1124423049 = (sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (delayMillis < 0) {
            //delayMillis = 0;
        //}
        //return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.537 -0400", hash_original_method = "9EBABACA140C9DF9A34851CFCEDCA0D2", hash_generated_method = "2E0B922B8611D011089FA613501B7961")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        dsTaint.addTaint(uptimeMillis);
        dsTaint.addTaint(msg.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.538 -0400", hash_original_method = "915CC0C6E8D23436D72B6BC5461B3284", hash_generated_method = "8EE0A319D334F5AB66090989F89F7BA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendMessageAtFrontOfQueue(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.538 -0400", hash_original_method = "4176E8C258200D3721001C1E43AEA8B7", hash_generated_method = "92299907912010BAF65E8D5E5A9DB50C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void removeMessages(int what) {
        dsTaint.addTaint(what);
        mQueue.removeMessages(this, what, null, true);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, what, null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.538 -0400", hash_original_method = "23ED3231C29D8F11BAA051AB6C64E2F2", hash_generated_method = "2B4A9604D4D799F1378715034509CA6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void removeMessages(int what, Object object) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(object.dsTaint);
        mQueue.removeMessages(this, what, object, true);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, what, object, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.539 -0400", hash_original_method = "448E73D7B69D80F7826BA330AB50FE66", hash_generated_method = "E618782E73F68B6524BC912734ED63AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void removeCallbacksAndMessages(Object token) {
        dsTaint.addTaint(token.dsTaint);
        mQueue.removeCallbacksAndMessages(this, token);
        // ---------- Original Method ----------
        //mQueue.removeCallbacksAndMessages(this, token);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.539 -0400", hash_original_method = "311185E2299156FD883BD00C28E38599", hash_generated_method = "4DC510B218BDD3EDD7B7677680D2461D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasMessages(int what) {
        dsTaint.addTaint(what);
        boolean var3318D5FB3681CEA99F369FDDCF03D4B8_1049456240 = (mQueue.removeMessages(this, what, null, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mQueue.removeMessages(this, what, null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.539 -0400", hash_original_method = "49BF5F4269CD0924DE36FF7A410C4BAC", hash_generated_method = "67AFDEE94234883A74AC6C1D2F8F0284")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasMessages(int what, Object object) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(object.dsTaint);
        boolean var09A85EE8C328ECF4A84EF4C40DF7B776_859128544 = (mQueue.removeMessages(this, what, object, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mQueue.removeMessages(this, what, object, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.539 -0400", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "8524C4EFFA430537AEFAE0B50569CC69")
    @DSModeled(DSC.SAFE)
    public final Looper getLooper() {
        return (Looper)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLooper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.540 -0400", hash_original_method = "F69D7CBFCB904B3AB08CCA20C9F65B2F", hash_generated_method = "F44C922684D573A3C1A4E4AF63F5E788")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        pw.println(prefix + this + " @ " + SystemClock.uptimeMillis());
        {
            pw.println(prefix + "looper uninitialized");
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.540 -0400", hash_original_method = "05520CD35CB4412A1070385C35DB25A1", hash_generated_method = "2621F3CF30AD0AEC28446313DF61B745")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var11C2818B86AE8D97DB04DBB48CA290B9_932386662 = ("Handler (" + getClass().getName() + ") {"
        + Integer.toHexString(System.identityHashCode(this))
        + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Handler (" + getClass().getName() + ") {"
        //+ Integer.toHexString(System.identityHashCode(this))
        //+ "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.540 -0400", hash_original_method = "022CD131F6EA96B24851C91C40C740AA", hash_generated_method = "EED8732811DAB803DA9C93AE61DD1C96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final IMessenger getIMessenger() {
        {
            mMessenger = new MessengerImpl();
        } //End block
        return (IMessenger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mQueue) {
            //if (mMessenger != null) {
                //return mMessenger;
            //}
            //mMessenger = new MessengerImpl();
            //return mMessenger;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.541 -0400", hash_original_method = "9DFB5128F30D3CFE7C2F086A6667AA29", hash_generated_method = "CA76BCF041F5F851D45881B656A4F18A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final Message getPostMessage(Runnable r) {
        dsTaint.addTaint(r.dsTaint);
        Message m;
        m = Message.obtain();
        m.callback = r;
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message m = Message.obtain();
        //m.callback = r;
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.541 -0400", hash_original_method = "001850E10F072AF670657F2F37A16A9C", hash_generated_method = "4EB4444185038D8827832B0128688BA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final Message getPostMessage(Runnable r, Object token) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        Message m;
        m = Message.obtain();
        m.obj = token;
        m.callback = r;
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message m = Message.obtain();
        //m.obj = token;
        //m.callback = r;
        //return m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.541 -0400", hash_original_method = "6CA31B63D4772009E291A8EEE8116A2F", hash_generated_method = "BAFFECEC2B2FA526E7426C7161C55584")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void handleCallback(Message message) {
        dsTaint.addTaint(message.dsTaint);
        message.callback.run();
        // ---------- Original Method ----------
        //message.callback.run();
    }

    
    private final class MessengerImpl extends IMessenger.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.541 -0400", hash_original_method = "1D9B7F7F4D3A4EF60A6B06EC48AB056C", hash_generated_method = "1D9B7F7F4D3A4EF60A6B06EC48AB056C")
                public MessengerImpl ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:53.541 -0400", hash_original_method = "CF11BADC884B068E4FC98150B23E5EB1", hash_generated_method = "CD4834EE6147888E8599B01D38F0212B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void send(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            Handler.this.sendMessage(msg);
            // ---------- Original Method ----------
            //Handler.this.sendMessage(msg);
        }

        
    }


    
    public interface Callback {
        public boolean handleMessage(Message msg);
    }
    
    private static final boolean FIND_POTENTIAL_LEAKS = false;
    private static final String TAG = "Handler";
}

