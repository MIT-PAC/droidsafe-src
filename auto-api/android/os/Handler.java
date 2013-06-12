package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Modifier;

public class Handler {
    private static final boolean FIND_POTENTIAL_LEAKS = false;
    private static final String TAG = "Handler";
    final MessageQueue mQueue;
    final Looper mLooper;
    final Callback mCallback;
    IMessenger mMessenger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.628 -0400", hash_original_method = "BF99A47DD8BD9030B611C5F1BD90EC8F", hash_generated_method = "664CDC939EF0D31C9830D3B012A701D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Handler() {
        {
            final Class<? extends Handler> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_1901403877 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0);
            } //End collapsed parenthetic
        } //End block
        mLooper = Looper.myLooper();
        {
            throw new RuntimeException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.628 -0400", hash_original_method = "4145BBA061FAEF73002F915149455D35", hash_generated_method = "C2F4CEDF155AE8C235258D713B06EF79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Handler(Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        {
            final Class<? extends Handler> klass;
            klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_568419852 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0);
            } //End collapsed parenthetic
        } //End block
        mLooper = Looper.myLooper();
        {
            throw new RuntimeException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.628 -0400", hash_original_method = "878DD6FD2A8B0F6865454043C68D5888", hash_generated_method = "4C3A82C2481C28F5AA8390D0D2CC753D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.629 -0400", hash_original_method = "0F1A18EF6331120AB094322F735FD8FC", hash_generated_method = "CF0320225116F4197A5393607026857C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.629 -0400", hash_original_method = "C13ECA453D39BD1621DCBD4764283A41", hash_generated_method = "9A71EFC3F21A90A4E8D1AAF7202F27B7")
    @DSModeled(DSC.SAFE)
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.629 -0400", hash_original_method = "1565D7D72E28223A47E7963B114AD9E6", hash_generated_method = "06D99A692A23C6EBB977CA1E2A8814CE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            handleCallback(msg);
        } //End block
        {
            {
                {
                    boolean var40429B7E6C52EDCF4719B5E6B95BAF9A_650302170 = (mCallback.handleMessage(msg));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.629 -0400", hash_original_method = "7AEB9F9BBB8F24805A35E34BFA8BA452", hash_generated_method = "C13151D7ECA0B9757035B96E4074F781")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getMessageName(Message message) {
        dsTaint.addTaint(message.dsTaint);
        {
            String var5813D9B6BD8F3923738F21B8D9294584_1322767166 = (message.callback.getClass().getName());
        } //End block
        String var1118157A0EDF9DCF1E9A816FA4D45E8C_1971440941 = ("0x" + Integer.toHexString(message.what));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (message.callback != null) {
            //return message.callback.getClass().getName();
        //}
        //return "0x" + Integer.toHexString(message.what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.629 -0400", hash_original_method = "3FA1D1E6850485EFDFF54C55EBFDD1CC", hash_generated_method = "EC5383EC2F92C4C3DE6EC09A95BE54E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage() {
        Message var19BF8B9E7C32DF339B8BD7E22E614C84_1157300460 = (Message.obtain(this));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Message.obtain(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.629 -0400", hash_original_method = "83ED22E0C23176DA2E639FBDA9F30743", hash_generated_method = "A003E3D43E3D29B159E40C9D2A4590B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what) {
        dsTaint.addTaint(what);
        Message var84E7C4E748CAFCDFCD7FDC49B909D4A4_1287508999 = (Message.obtain(this, what));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Message.obtain(this, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.629 -0400", hash_original_method = "16AA2451698F7981D4974062DB733B90", hash_generated_method = "0FF5664268D85A91B09FF10DA2B95C18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        Message var991EB1896EE6924BE55C65D85D99E725_679212125 = (Message.obtain(this, what, obj));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Message.obtain(this, what, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.629 -0400", hash_original_method = "E0C335742F8D26DCA388CDB62E97551F", hash_generated_method = "EC808443A22F5872B1280B4730DA156B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message var20E0EE76C9627FAF70A37529FF275EFD_2137125638 = (Message.obtain(this, what, arg1, arg2));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Message.obtain(this, what, arg1, arg2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.630 -0400", hash_original_method = "73E3B8E788E4FE19D8B1D7007BFD268C", hash_generated_method = "703B2AF5FFFAFD25400A5CE483DB5ADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        Message var908529AE03CEFF1A1D33D61B5F9BF8BA_867904230 = (Message.obtain(this, what, arg1, arg2, obj));
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Message.obtain(this, what, arg1, arg2, obj);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.630 -0400", hash_original_method = "6A0575D5625A2B33566AA17E837BEE40", hash_generated_method = "F6612BB942A00A9137C6BA560A03ECD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean post(Runnable r) {
        dsTaint.addTaint(r.dsTaint);
        boolean var7A01F528DFCD9F3B64D013796B5AEAEA_708402716 = (sendMessageDelayed(getPostMessage(r), 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return  sendMessageDelayed(getPostMessage(r), 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.630 -0400", hash_original_method = "AE818DFE2AFBC7BA2C1B26423E282D08", hash_generated_method = "B22D626220B1DDFD025D3CD349F903C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean postAtTime(Runnable r, long uptimeMillis) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(uptimeMillis);
        boolean varE06D54AE70CF1F1A96C302B669F59131_603133944 = (sendMessageAtTime(getPostMessage(r), uptimeMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendMessageAtTime(getPostMessage(r), uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.630 -0400", hash_original_method = "545FD7F3E8EB84671B1FDA0DB6EB661F", hash_generated_method = "E05BED05C1AA67DDB792E23B4B124933")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean postAtTime(Runnable r, Object token, long uptimeMillis) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(uptimeMillis);
        boolean var3BAF00809B4281FFDC01C90B27A5CF75_925102631 = (sendMessageAtTime(getPostMessage(r, token), uptimeMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendMessageAtTime(getPostMessage(r, token), uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.630 -0400", hash_original_method = "E41A8A27723BD019DF77785AB7446793", hash_generated_method = "6BB0D758A1D6984C9DBC57313B822DA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean postDelayed(Runnable r, long delayMillis) {
        dsTaint.addTaint(delayMillis);
        dsTaint.addTaint(r.dsTaint);
        boolean varF8B393B58C339C87BBA330695569D4F5_2087135302 = (sendMessageDelayed(getPostMessage(r), delayMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendMessageDelayed(getPostMessage(r), delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.630 -0400", hash_original_method = "349F8881748C55ABBCC660C80A5C77C8", hash_generated_method = "CB6E383407D1E6107CB1D0DB6047756D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean postAtFrontOfQueue(Runnable r) {
        dsTaint.addTaint(r.dsTaint);
        boolean varBFA199A426AAF2B85E67B2328E173359_508369860 = (sendMessageAtFrontOfQueue(getPostMessage(r)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendMessageAtFrontOfQueue(getPostMessage(r));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.630 -0400", hash_original_method = "EA17D2D89EBC0DA60DAE54B4D2813C6D", hash_generated_method = "8A02FFABB667907ADF8C5C640A639996")
    @DSModeled(DSC.SAFE)
    public final void removeCallbacks(Runnable r) {
        dsTaint.addTaint(r.dsTaint);
        mQueue.removeMessages(this, r, null);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, r, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.630 -0400", hash_original_method = "159A6F4E93CA274BF5D9A61C57FA58AA", hash_generated_method = "67522D7C7C3A10C9F774B88DE18A68E5")
    @DSModeled(DSC.SAFE)
    public final void removeCallbacks(Runnable r, Object token) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        mQueue.removeMessages(this, r, token);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, r, token);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.630 -0400", hash_original_method = "A97266028157506969A5B89288A9C9BC", hash_generated_method = "2FD211B7156317014AEF9F519E99EF26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        boolean var61A3771F06272201631ECD7A68EAD4FF_1043502413 = (sendMessageDelayed(msg, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendMessageDelayed(msg, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.631 -0400", hash_original_method = "A52967DD531D2E9895F5558692B5D99D", hash_generated_method = "C4DFE6F95AC08CBA82D9B01AB7C8D626")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendEmptyMessage(int what) {
        dsTaint.addTaint(what);
        boolean var4556D7D1710FA2FD730FBBBE12542C68_1990772506 = (sendEmptyMessageDelayed(what, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sendEmptyMessageDelayed(what, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.631 -0400", hash_original_method = "C345E8B6D42103BAB2779DE84E2F8005", hash_generated_method = "9D24ABCDEF2DC790418DEF43EC70D1DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendEmptyMessageDelayed(int what, long delayMillis) {
        dsTaint.addTaint(delayMillis);
        dsTaint.addTaint(what);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        boolean var422D34FE7EBBD1E444F99420C6560E7D_235534300 = (sendMessageDelayed(msg, delayMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //return sendMessageDelayed(msg, delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.631 -0400", hash_original_method = "0234DAD2CAD8EF6B170E56EDA713A580", hash_generated_method = "9CF80CEB535337428BDCF06459A46331")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(uptimeMillis);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        boolean var6676E1BAAA52F02DEEF6C770E4ABF19C_1152594251 = (sendMessageAtTime(msg, uptimeMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //return sendMessageAtTime(msg, uptimeMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.631 -0400", hash_original_method = "F32DF35552A73512081963AF1F333EEC", hash_generated_method = "AC7B1455BA6E717A1A7CD122AC006551")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean sendMessageDelayed(Message msg, long delayMillis) {
        dsTaint.addTaint(delayMillis);
        dsTaint.addTaint(msg.dsTaint);
        {
            delayMillis = 0;
        } //End block
        boolean var1761F03F3EEFC16009DC3CA8E9725E10_485670382 = (sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (delayMillis < 0) {
            //delayMillis = 0;
        //}
        //return sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.631 -0400", hash_original_method = "9EBABACA140C9DF9A34851CFCEDCA0D2", hash_generated_method = "F4728E30BA011AAF53006A9B567C452A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        dsTaint.addTaint(msg.dsTaint);
        dsTaint.addTaint(uptimeMillis);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.631 -0400", hash_original_method = "915CC0C6E8D23436D72B6BC5461B3284", hash_generated_method = "1BFA1FB3983E79C27907C3CB3DA762C1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.632 -0400", hash_original_method = "4176E8C258200D3721001C1E43AEA8B7", hash_generated_method = "B1E4E930FD6F310EC1A5E91437384ED7")
    @DSModeled(DSC.SAFE)
    public final void removeMessages(int what) {
        dsTaint.addTaint(what);
        mQueue.removeMessages(this, what, null, true);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, what, null, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.632 -0400", hash_original_method = "23ED3231C29D8F11BAA051AB6C64E2F2", hash_generated_method = "3DA940460D821060CEDFDA94FD42873E")
    @DSModeled(DSC.SAFE)
    public final void removeMessages(int what, Object object) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(object.dsTaint);
        mQueue.removeMessages(this, what, object, true);
        // ---------- Original Method ----------
        //mQueue.removeMessages(this, what, object, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.632 -0400", hash_original_method = "448E73D7B69D80F7826BA330AB50FE66", hash_generated_method = "DF8F8406F078CD6C30EB8B1400ED04A5")
    @DSModeled(DSC.SAFE)
    public final void removeCallbacksAndMessages(Object token) {
        dsTaint.addTaint(token.dsTaint);
        mQueue.removeCallbacksAndMessages(this, token);
        // ---------- Original Method ----------
        //mQueue.removeCallbacksAndMessages(this, token);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.632 -0400", hash_original_method = "311185E2299156FD883BD00C28E38599", hash_generated_method = "B9CAF6C6F48EB49885774C2C048DBC48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasMessages(int what) {
        dsTaint.addTaint(what);
        boolean var3318D5FB3681CEA99F369FDDCF03D4B8_943011309 = (mQueue.removeMessages(this, what, null, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mQueue.removeMessages(this, what, null, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.632 -0400", hash_original_method = "49BF5F4269CD0924DE36FF7A410C4BAC", hash_generated_method = "15F31153C766C419831AA7683FFB4ECF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean hasMessages(int what, Object object) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(object.dsTaint);
        boolean var09A85EE8C328ECF4A84EF4C40DF7B776_1613091287 = (mQueue.removeMessages(this, what, object, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mQueue.removeMessages(this, what, object, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.632 -0400", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "DA91F5A1B5A3993FC4A84843E0F7BE6D")
    @DSModeled(DSC.SAFE)
    public final Looper getLooper() {
        return (Looper)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLooper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.632 -0400", hash_original_method = "F69D7CBFCB904B3AB08CCA20C9F65B2F", hash_generated_method = "0724DEB5EAB87879D1B1330B5F071092")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.632 -0400", hash_original_method = "05520CD35CB4412A1070385C35DB25A1", hash_generated_method = "D861E338E528567B55D9FE6A7EBC76A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var11C2818B86AE8D97DB04DBB48CA290B9_2138000884 = ("Handler (" + getClass().getName() + ") {"
        + Integer.toHexString(System.identityHashCode(this))
        + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Handler (" + getClass().getName() + ") {"
        //+ Integer.toHexString(System.identityHashCode(this))
        //+ "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.633 -0400", hash_original_method = "022CD131F6EA96B24851C91C40C740AA", hash_generated_method = "CC5574682D9C46A67EF22BFDAE29E6CB")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.633 -0400", hash_original_method = "9DFB5128F30D3CFE7C2F086A6667AA29", hash_generated_method = "52D3FCA93F801931F00229AF14B69D37")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.633 -0400", hash_original_method = "001850E10F072AF670657F2F37A16A9C", hash_generated_method = "94FAEC770775057E52C4E02516F86B59")
    @DSModeled(DSC.SAFE)
    private final Message getPostMessage(Runnable r, Object token) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(token.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.633 -0400", hash_original_method = "6CA31B63D4772009E291A8EEE8116A2F", hash_generated_method = "05A8C4749A4885A8BA8A603F453EB37F")
    @DSModeled(DSC.SAFE)
    private final void handleCallback(Message message) {
        dsTaint.addTaint(message.dsTaint);
        message.callback.run();
        // ---------- Original Method ----------
        //message.callback.run();
    }

    
    private final class MessengerImpl extends IMessenger.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:02.633 -0400", hash_original_method = "CF11BADC884B068E4FC98150B23E5EB1", hash_generated_method = "DED85A9398E2E5B66FBE075A57B1F5BB")
        @DSModeled(DSC.SAFE)
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
    
}


