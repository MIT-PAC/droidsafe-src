package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.util.Log;
import android.util.Printer;
import java.lang.reflect.Modifier;

public class Handler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.253 -0400", hash_original_field = "2D043F2822EC0D4E2690BDFE63EDDFCA", hash_generated_field = "331CAFDD37154BFFB4C27FB1EC4DE2ED")

    MessageQueue mQueue;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.253 -0400", hash_original_field = "DA288C1345E9C94467C02060ED19C6FA", hash_generated_field = "4C6A73D1D5351706C43659B423CF9288")

    Looper mLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.253 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "1A99E72B6409E38FBCC780D1BAB4898D")

    Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.253 -0400", hash_original_field = "83FE717B4B643B5D605C868F0E136C03", hash_generated_field = "35095A7AFB955F43B213705056D01A47")

    IMessenger mMessenger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.254 -0400", hash_original_method = "BF99A47DD8BD9030B611C5F1BD90EC8F", hash_generated_method = "087FFA656C79075CAB4DF302C0973FB0")
    public  Handler() {
        {
            final Class<? extends Handler> klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_221696865 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0);
            } 
        } 
        mLooper = Looper.myLooper();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "Can't create handler inside thread that has not called Looper.prepare()");
        } 
        mQueue = mLooper.mQueue;
        mCallback = null;
        
        
            
            
                    
                
                    
            
        
        
        
            
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.255 -0400", hash_original_method = "4145BBA061FAEF73002F915149455D35", hash_generated_method = "D625E10CFD2EDDB3A572B97E78830D9A")
    public  Handler(Callback callback) {
        {
            final Class<? extends Handler> klass = getClass();
            {
                boolean var21C0A6071D67597815EE38AB22BE22C0_294295454 = ((klass.isAnonymousClass() || klass.isMemberClass() || klass.isLocalClass()) &&
                    (klass.getModifiers() & Modifier.STATIC) == 0);
            } 
        } 
        mLooper = Looper.myLooper();
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "Can't create handler inside thread that has not called Looper.prepare()");
        } 
        mQueue = mLooper.mQueue;
        mCallback = callback;
        
        
            
            
                    
                
                    
            
        
        
        
            
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.255 -0400", hash_original_method = "878DD6FD2A8B0F6865454043C68D5888", hash_generated_method = "9B81A69A46DF15261D6C68147933E52E")
    public  Handler(Looper looper) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = null;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.255 -0400", hash_original_method = "0F1A18EF6331120AB094322F735FD8FC", hash_generated_method = "43AB9E70D0EFEBDC964E78082CA1DB45")
    public  Handler(Looper looper, Callback callback) {
        mLooper = looper;
        mQueue = looper.mQueue;
        mCallback = callback;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.256 -0400", hash_original_method = "C13ECA453D39BD1621DCBD4764283A41", hash_generated_method = "6C9E5B782C82352543D0D7A957AAB817")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.256 -0400", hash_original_method = "1565D7D72E28223A47E7963B114AD9E6", hash_generated_method = "BB22BFF4CB028300B838709485CC9123")
    public void dispatchMessage(Message msg) {
        {
            handleCallback(msg);
        } 
        {
            {
                {
                    boolean var40429B7E6C52EDCF4719B5E6B95BAF9A_291605266 = (mCallback.handleMessage(msg));
                } 
            } 
            handleMessage(msg);
        } 
        addTaint(msg.getTaint());
        
        
            
        
            
                
                    
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.257 -0400", hash_original_method = "7AEB9F9BBB8F24805A35E34BFA8BA452", hash_generated_method = "D2A625E0269F4BC1D3F76B8A5CCE6218")
    public String getMessageName(Message message) {
        String varB4EAC82CA7396A68D541C85D26508E83_15789435 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1395542592 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_15789435 = message.callback.getClass().getName();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1395542592 = "0x" + Integer.toHexString(message.what);
        addTaint(message.getTaint());
        String varA7E53CE21691AB073D9660D615818899_462398323; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_462398323 = varB4EAC82CA7396A68D541C85D26508E83_15789435;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_462398323 = varB4EAC82CA7396A68D541C85D26508E83_1395542592;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_462398323.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_462398323;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.258 -0400", hash_original_method = "3FA1D1E6850485EFDFF54C55EBFDD1CC", hash_generated_method = "F18F2BBA937F858099E2D8E7F38AE314")
    public final Message obtainMessage() {
        Message varB4EAC82CA7396A68D541C85D26508E83_1264868245 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1264868245 = Message.obtain(this);
        varB4EAC82CA7396A68D541C85D26508E83_1264868245.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1264868245;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.258 -0400", hash_original_method = "83ED22E0C23176DA2E639FBDA9F30743", hash_generated_method = "7C147784C8E20F061919ABE350F955D9")
    public final Message obtainMessage(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1994560359 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1994560359 = Message.obtain(this, what);
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_1994560359.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1994560359;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.259 -0400", hash_original_method = "16AA2451698F7981D4974062DB733B90", hash_generated_method = "C69574EB588468284EE04DECC01E190D")
    public final Message obtainMessage(int what, Object obj) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1917007416 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1917007416 = Message.obtain(this, what, obj);
        addTaint(what);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1917007416.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1917007416;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.259 -0400", hash_original_method = "E0C335742F8D26DCA388CDB62E97551F", hash_generated_method = "DAC072B71EFCA5B1827BBDF82C468425")
    public final Message obtainMessage(int what, int arg1, int arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1270770872 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1270770872 = Message.obtain(this, what, arg1, arg2);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        varB4EAC82CA7396A68D541C85D26508E83_1270770872.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1270770872;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.260 -0400", hash_original_method = "73E3B8E788E4FE19D8B1D7007BFD268C", hash_generated_method = "9256854F42156C8CCB67DDE9325B27F5")
    public final Message obtainMessage(int what, int arg1, int arg2, Object obj) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1903921911 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1903921911 = Message.obtain(this, what, arg1, arg2, obj);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1903921911.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1903921911;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.260 -0400", hash_original_method = "6A0575D5625A2B33566AA17E837BEE40", hash_generated_method = "94A86F28036F9753E3E7EF9180DDEAD2")
    public final boolean post(Runnable r) {
        boolean var7A01F528DFCD9F3B64D013796B5AEAEA_314510704 = (sendMessageDelayed(getPostMessage(r), 0));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394310334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394310334;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.260 -0400", hash_original_method = "AE818DFE2AFBC7BA2C1B26423E282D08", hash_generated_method = "E69119CA5BFD720807F9B60EC3449B4D")
    public final boolean postAtTime(Runnable r, long uptimeMillis) {
        boolean varE06D54AE70CF1F1A96C302B669F59131_235955530 = (sendMessageAtTime(getPostMessage(r), uptimeMillis));
        addTaint(r.getTaint());
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724487365 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_724487365;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.261 -0400", hash_original_method = "545FD7F3E8EB84671B1FDA0DB6EB661F", hash_generated_method = "AE79CAFC2325CD2345E52B0A0DB3E3A3")
    public final boolean postAtTime(Runnable r, Object token, long uptimeMillis) {
        boolean var3BAF00809B4281FFDC01C90B27A5CF75_615763450 = (sendMessageAtTime(getPostMessage(r, token), uptimeMillis));
        addTaint(r.getTaint());
        addTaint(token.getTaint());
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1539897456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1539897456;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.261 -0400", hash_original_method = "E41A8A27723BD019DF77785AB7446793", hash_generated_method = "574479531A4C9EBA71FCF935DAB15CCD")
    public final boolean postDelayed(Runnable r, long delayMillis) {
        boolean varF8B393B58C339C87BBA330695569D4F5_1125793335 = (sendMessageDelayed(getPostMessage(r), delayMillis));
        addTaint(r.getTaint());
        addTaint(delayMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305517846 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305517846;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.261 -0400", hash_original_method = "349F8881748C55ABBCC660C80A5C77C8", hash_generated_method = "30F608539097D485730DAF669965EDA2")
    public final boolean postAtFrontOfQueue(Runnable r) {
        boolean varBFA199A426AAF2B85E67B2328E173359_50994724 = (sendMessageAtFrontOfQueue(getPostMessage(r)));
        addTaint(r.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2013355077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2013355077;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.262 -0400", hash_original_method = "EA17D2D89EBC0DA60DAE54B4D2813C6D", hash_generated_method = "19A443F0A686C5D1DFA3C6AEA93334E1")
    public final void removeCallbacks(Runnable r) {
        mQueue.removeMessages(this, r, null);
        addTaint(r.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.262 -0400", hash_original_method = "159A6F4E93CA274BF5D9A61C57FA58AA", hash_generated_method = "B81059E219504F6CBFDDBEF6C09852EB")
    public final void removeCallbacks(Runnable r, Object token) {
        mQueue.removeMessages(this, r, token);
        addTaint(r.getTaint());
        addTaint(token.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.262 -0400", hash_original_method = "A97266028157506969A5B89288A9C9BC", hash_generated_method = "F388D19818DBA9E0EEAFB1B2BEF08635")
    public final boolean sendMessage(Message msg) {
        boolean var61A3771F06272201631ECD7A68EAD4FF_298571033 = (sendMessageDelayed(msg, 0));
        addTaint(msg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1047071253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1047071253;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.262 -0400", hash_original_method = "A52967DD531D2E9895F5558692B5D99D", hash_generated_method = "BC7911B8EF24D00CF7D1AB79E82BFCBC")
    public final boolean sendEmptyMessage(int what) {
        boolean var4556D7D1710FA2FD730FBBBE12542C68_1787587351 = (sendEmptyMessageDelayed(what, 0));
        addTaint(what);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1693149691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1693149691;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.263 -0400", hash_original_method = "C345E8B6D42103BAB2779DE84E2F8005", hash_generated_method = "02DAFFD6B4F0680E250FC0E10E12F694")
    public final boolean sendEmptyMessageDelayed(int what, long delayMillis) {
        Message msg = Message.obtain();
        msg.what = what;
        boolean var422D34FE7EBBD1E444F99420C6560E7D_1559967286 = (sendMessageDelayed(msg, delayMillis));
        addTaint(what);
        addTaint(delayMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598042004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_598042004;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.263 -0400", hash_original_method = "0234DAD2CAD8EF6B170E56EDA713A580", hash_generated_method = "D4721C8164855F2B18D63DE23C130E9E")
    public final boolean sendEmptyMessageAtTime(int what, long uptimeMillis) {
        Message msg = Message.obtain();
        msg.what = what;
        boolean var6676E1BAAA52F02DEEF6C770E4ABF19C_1244564555 = (sendMessageAtTime(msg, uptimeMillis));
        addTaint(what);
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1480432644 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1480432644;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.263 -0400", hash_original_method = "F32DF35552A73512081963AF1F333EEC", hash_generated_method = "2CC2910E040879AABB968448815C8AC3")
    public final boolean sendMessageDelayed(Message msg, long delayMillis) {
        {
            delayMillis = 0;
        } 
        boolean var1761F03F3EEFC16009DC3CA8E9725E10_1832126661 = (sendMessageAtTime(msg, SystemClock.uptimeMillis() + delayMillis));
        addTaint(msg.getTaint());
        addTaint(delayMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_191041135 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_191041135;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.264 -0400", hash_original_method = "9EBABACA140C9DF9A34851CFCEDCA0D2", hash_generated_method = "C4092BC0E1DA2BC28856DA308658CA4A")
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        boolean sent = false;
        MessageQueue queue = mQueue;
        {
            msg.target = this;
            sent = queue.enqueueMessage(msg, uptimeMillis);
        } 
        {
            RuntimeException e = new RuntimeException(
                this + " sendMessageAtTime() called with no mQueue");
        } 
        addTaint(msg.getTaint());
        addTaint(uptimeMillis);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2045443230 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2045443230;
        
        
        
        
            
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.264 -0400", hash_original_method = "915CC0C6E8D23436D72B6BC5461B3284", hash_generated_method = "E0784F9B84B7CCF8175791465BB74C71")
    public final boolean sendMessageAtFrontOfQueue(Message msg) {
        boolean sent = false;
        MessageQueue queue = mQueue;
        {
            msg.target = this;
            sent = queue.enqueueMessage(msg, 0);
        } 
        {
            RuntimeException e = new RuntimeException(
                this + " sendMessageAtTime() called with no mQueue");
        } 
        addTaint(msg.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129072618 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129072618;
        
        
        
        
            
            
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.265 -0400", hash_original_method = "4176E8C258200D3721001C1E43AEA8B7", hash_generated_method = "596DC98388E02314F3D663DF1DBD1A82")
    public final void removeMessages(int what) {
        mQueue.removeMessages(this, what, null, true);
        addTaint(what);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.265 -0400", hash_original_method = "23ED3231C29D8F11BAA051AB6C64E2F2", hash_generated_method = "77D5EA64BE5560CAF694E8030DA3E86B")
    public final void removeMessages(int what, Object object) {
        mQueue.removeMessages(this, what, object, true);
        addTaint(what);
        addTaint(object.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.265 -0400", hash_original_method = "448E73D7B69D80F7826BA330AB50FE66", hash_generated_method = "6B402AB47C76673EE7A06907E80CC4A1")
    public final void removeCallbacksAndMessages(Object token) {
        mQueue.removeCallbacksAndMessages(this, token);
        addTaint(token.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.266 -0400", hash_original_method = "311185E2299156FD883BD00C28E38599", hash_generated_method = "4DB3C828CF12C3350201D56C9AA06BCC")
    public final boolean hasMessages(int what) {
        boolean var3318D5FB3681CEA99F369FDDCF03D4B8_99082435 = (mQueue.removeMessages(this, what, null, false));
        addTaint(what);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1377419256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1377419256;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.266 -0400", hash_original_method = "49BF5F4269CD0924DE36FF7A410C4BAC", hash_generated_method = "BE11E8ACCC8E4E2CD7CC022071B2BF41")
    public final boolean hasMessages(int what, Object object) {
        boolean var09A85EE8C328ECF4A84EF4C40DF7B776_1666358467 = (mQueue.removeMessages(this, what, object, false));
        addTaint(what);
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_117272259 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_117272259;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.267 -0400", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "5AFC68D79E5FE4EC8F6C299A605E70A9")
    public final Looper getLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_527747846 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_527747846 = mLooper;
        varB4EAC82CA7396A68D541C85D26508E83_527747846.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_527747846;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.267 -0400", hash_original_method = "F69D7CBFCB904B3AB08CCA20C9F65B2F", hash_generated_method = "F34828814FA68CDBD9F822D3B537392E")
    public final void dump(Printer pw, String prefix) {
        pw.println(prefix + this + " @ " + SystemClock.uptimeMillis());
        {
            pw.println(prefix + "looper uninitialized");
        } 
        {
            mLooper.dump(pw, prefix + "  ");
        } 
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.268 -0400", hash_original_method = "05520CD35CB4412A1070385C35DB25A1", hash_generated_method = "97A527EA45A8AEED44CDD80005CA5DE8")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_645424487 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_645424487 = "Handler (" + getClass().getName() + ") {"
        + Integer.toHexString(System.identityHashCode(this))
        + "}";
        varB4EAC82CA7396A68D541C85D26508E83_645424487.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_645424487;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.269 -0400", hash_original_method = "022CD131F6EA96B24851C91C40C740AA", hash_generated_method = "F4571C57E4BBB3F3CC876665CB460FD6")
    final IMessenger getIMessenger() {
        IMessenger varB4EAC82CA7396A68D541C85D26508E83_1727900204 = null; 
        IMessenger varB4EAC82CA7396A68D541C85D26508E83_283352959 = null; 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1727900204 = mMessenger;
            } 
            mMessenger = new MessengerImpl();
            varB4EAC82CA7396A68D541C85D26508E83_283352959 = mMessenger;
        } 
        IMessenger varA7E53CE21691AB073D9660D615818899_1117210616; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1117210616 = varB4EAC82CA7396A68D541C85D26508E83_1727900204;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1117210616 = varB4EAC82CA7396A68D541C85D26508E83_283352959;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1117210616.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1117210616;
        
        
            
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.270 -0400", hash_original_method = "9DFB5128F30D3CFE7C2F086A6667AA29", hash_generated_method = "1BB82D361F1C6B31E1B8802A7972E30D")
    private final Message getPostMessage(Runnable r) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1876531813 = null; 
        Message m = Message.obtain();
        m.callback = r;
        varB4EAC82CA7396A68D541C85D26508E83_1876531813 = m;
        addTaint(r.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1876531813.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1876531813;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.271 -0400", hash_original_method = "001850E10F072AF670657F2F37A16A9C", hash_generated_method = "71355708AF17265B22195D2DFE0901B4")
    private final Message getPostMessage(Runnable r, Object token) {
        Message varB4EAC82CA7396A68D541C85D26508E83_926723829 = null; 
        Message m = Message.obtain();
        m.obj = token;
        m.callback = r;
        varB4EAC82CA7396A68D541C85D26508E83_926723829 = m;
        addTaint(r.getTaint());
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_926723829.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_926723829;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.271 -0400", hash_original_method = "6CA31B63D4772009E291A8EEE8116A2F", hash_generated_method = "E3D7BD18C18A1C9B4EF9E7B89730EA91")
    private final void handleCallback(Message message) {
        message.callback.run();
        addTaint(message.getTaint());
        
        
    }

    
    private final class MessengerImpl extends IMessenger.Stub {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.271 -0400", hash_original_method = "68A768E132C1125DE9510AF39EB42EE7", hash_generated_method = "68A768E132C1125DE9510AF39EB42EE7")
        public MessengerImpl ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.271 -0400", hash_original_method = "CF11BADC884B068E4FC98150B23E5EB1", hash_generated_method = "CE1189B26F74072764E72C8583836693")
        public void send(Message msg) {
            Handler.this.sendMessage(msg);
            addTaint(msg.getTaint());
            
            
        }

        
    }


    
    public interface Callback {
        public boolean handleMessage(Message msg);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.271 -0400", hash_original_field = "E98C260B28FA80AA89F6D5E5597392E0", hash_generated_field = "0511AC5400F6AB0B4374BEAACA5C07BE")

    private static final boolean FIND_POTENTIAL_LEAKS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:42.271 -0400", hash_original_field = "C705D79D983762D5A9E5A78751871C79", hash_generated_field = "BFB213888655CBD96A5FA5BA90716E2A")

    private static final String TAG = "Handler";
}

