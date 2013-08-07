package android.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;





public class ViewFlipper extends ViewAnimator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.240 -0400", hash_original_field = "AB885A31780121055D1BDD1B69C143B0", hash_generated_field = "EF72A9C12698542BA68675F47801C510")

    private int mFlipInterval = DEFAULT_INTERVAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.240 -0400", hash_original_field = "9D1D7F0887BD27A8D16A59D275316158", hash_generated_field = "9C643D61158922DF6FDCA155A2D64171")

    private boolean mAutoStart = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.240 -0400", hash_original_field = "62A2DC3D8C5F735AB3A7DFD6D4A40243", hash_generated_field = "BF66F685C8DAD91C6D305A2AD45B0022")

    private boolean mRunning = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.240 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.240 -0400", hash_original_field = "95D7DEECF5DCCC2A9C275828FA450168", hash_generated_field = "95F7E58D2B9BB4F0C1C65AF576B6388E")

    private boolean mVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.240 -0400", hash_original_field = "14A8C83C7F1FF831F0A13A17DF5AB6A7", hash_generated_field = "22924785424C7732F326AFFE2483DB6D")

    private boolean mUserPresent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.242 -0400", hash_original_field = "222E91439CEAD2DB1901D5AA0C5663AF", hash_generated_field = "8570C3C2B40A1C3E01F5D2029A49DFD5")

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.242 -0400", hash_original_method = "42FB9B1799748BE0453D66D785C793D7", hash_generated_method = "7CF62093314DB968F107DD7907FD4417")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
            final String action = intent.getAction();
            if(Intent.ACTION_SCREEN_OFF.equals(action))            
            {
                mUserPresent = false;
                updateRunning();
            } //End block
            else
            if(Intent.ACTION_USER_PRESENT.equals(action))            
            {
                mUserPresent = true;
                updateRunning(false);
            } //End block
            // ---------- Original Method ----------
            //final String action = intent.getAction();
            //if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                //mUserPresent = false;
                //updateRunning();
            //} else if (Intent.ACTION_USER_PRESENT.equals(action)) {
                //mUserPresent = true;
                //updateRunning(false);
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.242 -0400", hash_original_field = "E862543A04A58E4E58FB8E81927C11E8", hash_generated_field = "1535E31D28A65629AD405F9453386A42")

    private final int FLIP_MSG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.243 -0400", hash_original_field = "02869CDAF60D7BAD10F76E3EF9313FAC", hash_generated_field = "1FE43EAD86528C4571343BC4A0A3488D")

    private final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.243 -0400", hash_original_method = "9F9F367503C2FAC32268BB267EBDCEAD", hash_generated_method = "8005712ED1DB8AF5F18C577789BDFE94")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
            if(msg.what == FLIP_MSG)            
            {
                if(mRunning)                
                {
                    showNext();
                    msg = obtainMessage(FLIP_MSG);
                    sendMessageDelayed(msg, mFlipInterval);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //if (msg.what == FLIP_MSG) {
                //if (mRunning) {
                    //showNext();
                    //msg = obtainMessage(FLIP_MSG);
                    //sendMessageDelayed(msg, mFlipInterval);
                //}
            //}
        }

        
};
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.244 -0400", hash_original_method = "A199B0DFDE8F43BC0101C713FC646DAD", hash_generated_method = "BDA2F2DCBBDA64CD6219797FF6339D94")
    public  ViewFlipper(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.245 -0400", hash_original_method = "723832B306031BCDBE4BDCBA5DD42292", hash_generated_method = "8490F8A313C8F8C2154537D3C3B5AABE")
    public  ViewFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ViewFlipper);
        mFlipInterval = a.getInt(
                com.android.internal.R.styleable.ViewFlipper_flipInterval, DEFAULT_INTERVAL);
        mAutoStart = a.getBoolean(
                com.android.internal.R.styleable.ViewFlipper_autoStart, false);
        a.recycle();
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.ViewFlipper);
        //mFlipInterval = a.getInt(
                //com.android.internal.R.styleable.ViewFlipper_flipInterval, DEFAULT_INTERVAL);
        //mAutoStart = a.getBoolean(
                //com.android.internal.R.styleable.ViewFlipper_autoStart, false);
        //a.recycle();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.246 -0400", hash_original_method = "3C103BE4B999027DCB77DEB70D76599C", hash_generated_method = "56ACD26DC3FECE8BECD1A84A8FD6652E")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        final IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        getContext().registerReceiver(mReceiver, filter);
        if(mAutoStart)        
        {
            startFlipping();
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //final IntentFilter filter = new IntentFilter();
        //filter.addAction(Intent.ACTION_SCREEN_OFF);
        //filter.addAction(Intent.ACTION_USER_PRESENT);
        //getContext().registerReceiver(mReceiver, filter);
        //if (mAutoStart) {
            //startFlipping();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.246 -0400", hash_original_method = "5655570C437E83231F73A4B16A590D9C", hash_generated_method = "1626FB59EA0EC65657B41C811C1E9B62")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onDetachedFromWindow();
        mVisible = false;
        getContext().unregisterReceiver(mReceiver);
        updateRunning();
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //mVisible = false;
        //getContext().unregisterReceiver(mReceiver);
        //updateRunning();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.247 -0400", hash_original_method = "B937BC0D8F057FC72AF74494BA3F6E3F", hash_generated_method = "B204E105A37E32714A21261055CC4D32")
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onWindowVisibilityChanged(visibility);
        mVisible = visibility == VISIBLE;
        updateRunning(false);
        // ---------- Original Method ----------
        //super.onWindowVisibilityChanged(visibility);
        //mVisible = visibility == VISIBLE;
        //updateRunning(false);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.248 -0400", hash_original_method = "FE23BFE06BF9BB8E822638D81DB338AA", hash_generated_method = "188583DA2B863DCE0CA05C073A880E59")
    @android.view.RemotableViewMethod
    public void setFlipInterval(int milliseconds) {
        mFlipInterval = milliseconds;
        // ---------- Original Method ----------
        //mFlipInterval = milliseconds;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.249 -0400", hash_original_method = "5822F81CA7F02DBEFB349FF1928E2AAF", hash_generated_method = "DB03EDEB5215E2582BB6D4307C3D23A6")
    public void startFlipping() {
        mStarted = true;
        updateRunning();
        // ---------- Original Method ----------
        //mStarted = true;
        //updateRunning();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.249 -0400", hash_original_method = "B53A11C7EF817F793ACB0CF78B800084", hash_generated_method = "01BA27082DF02AD7E00FD433569A0C08")
    public void stopFlipping() {
        mStarted = false;
        updateRunning();
        // ---------- Original Method ----------
        //mStarted = false;
        //updateRunning();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.249 -0400", hash_original_method = "01EB120A60E7A5C93ADD152BE225A9A1", hash_generated_method = "95DAE41B7EF1D4EE1E159B09B77728E8")
    private void updateRunning() {
        updateRunning(true);
        // ---------- Original Method ----------
        //updateRunning(true);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.250 -0400", hash_original_method = "FEBFE82757020B844DFA7E8A1658E9A7", hash_generated_method = "AFC07426A2A5ED4EB088A9BC40257CB4")
    private void updateRunning(boolean flipNow) {
        addTaint(flipNow);
        boolean running = mVisible && mStarted && mUserPresent;
        if(running != mRunning)        
        {
            if(running)            
            {
                showOnly(mWhichChild, flipNow);
                Message msg = mHandler.obtainMessage(FLIP_MSG);
                mHandler.sendMessageDelayed(msg, mFlipInterval);
            } //End block
            else
            {
                mHandler.removeMessages(FLIP_MSG);
            } //End block
            mRunning = running;
        } //End block
        if(LOGD)        
        {
            Log.d(TAG, "updateRunning() mVisible=" + mVisible + ", mStarted=" + mStarted
                    + ", mUserPresent=" + mUserPresent + ", mRunning=" + mRunning);
        } //End block
        // ---------- Original Method ----------
        //boolean running = mVisible && mStarted && mUserPresent;
        //if (running != mRunning) {
            //if (running) {
                //showOnly(mWhichChild, flipNow);
                //Message msg = mHandler.obtainMessage(FLIP_MSG);
                //mHandler.sendMessageDelayed(msg, mFlipInterval);
            //} else {
                //mHandler.removeMessages(FLIP_MSG);
            //}
            //mRunning = running;
        //}
        //if (LOGD) {
            //Log.d(TAG, "updateRunning() mVisible=" + mVisible + ", mStarted=" + mStarted
                    //+ ", mUserPresent=" + mUserPresent + ", mRunning=" + mRunning);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.252 -0400", hash_original_method = "DA5270F6FAC446A7F1E0A4F7A45712B2", hash_generated_method = "88A03475FA4719DDABBC7F82E234D77D")
    public boolean isFlipping() {
        boolean var7103AE9E2C0D3B676C4EDC763D39DFCF_163316129 = (mStarted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1564229102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1564229102;
        // ---------- Original Method ----------
        //return mStarted;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.252 -0400", hash_original_method = "718522AE4DB02C55EF285DE2125FBBC5", hash_generated_method = "08DBE650A810C02E22CB6F0FC46C6DBE")
    public void setAutoStart(boolean autoStart) {
        mAutoStart = autoStart;
        // ---------- Original Method ----------
        //mAutoStart = autoStart;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.253 -0400", hash_original_method = "0E315A42E6B247C6D130CCD7ADAB21A6", hash_generated_method = "BCAE6591DA06F462D4F7907924F8D19E")
    public boolean isAutoStart() {
        boolean varDCC34F800E29708C501869F2DC7EB795_295123079 = (mAutoStart);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_924120088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_924120088;
        // ---------- Original Method ----------
        //return mAutoStart;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.253 -0400", hash_original_field = "BC8852EEA50B9EE6865A85E4B21B4864", hash_generated_field = "CC4DF3149FCDDB900A4695D39D4D2780")

    private static final String TAG = "ViewFlipper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.253 -0400", hash_original_field = "928751A5F820D0540184847C19228178", hash_generated_field = "7A4FFF4799751F839BC14FD728217C88")

    private static final boolean LOGD = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.253 -0400", hash_original_field = "D5606AB479F311FCCCCE6432412DF379", hash_generated_field = "C50E8EF39D157581F3ADA3B799342BBB")

    private static final int DEFAULT_INTERVAL = 3000;
}

