package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.662 -0500", hash_original_field = "D3F755D7E6A94238E098AB303C90B35E", hash_generated_field = "CC4DF3149FCDDB900A4695D39D4D2780")

    private static final String TAG = "ViewFlipper";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.664 -0500", hash_original_field = "D4ECFFBD11965A74CC5370FCF966AD54", hash_generated_field = "7A4FFF4799751F839BC14FD728217C88")

    private static final boolean LOGD = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.667 -0500", hash_original_field = "981A5CEE819E2D7AB9C46995D4A7FFC1", hash_generated_field = "C50E8EF39D157581F3ADA3B799342BBB")

    private static final int DEFAULT_INTERVAL = 3000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.669 -0500", hash_original_field = "45FA4E5265FF50261C110F724A036FFE", hash_generated_field = "EF72A9C12698542BA68675F47801C510")

    private int mFlipInterval = DEFAULT_INTERVAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.671 -0500", hash_original_field = "501E8B454A780DB4BF3497D9A7232702", hash_generated_field = "9C643D61158922DF6FDCA155A2D64171")

    private boolean mAutoStart = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.674 -0500", hash_original_field = "B7399D00B226DB1EFC02A9A44C6E372C", hash_generated_field = "BF66F685C8DAD91C6D305A2AD45B0022")

    private boolean mRunning = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.676 -0500", hash_original_field = "5D947BF952E8653BAADEA609028A78F9", hash_generated_field = "649FDFAC63847330ACCF3CE36C09777A")

    private boolean mStarted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.678 -0500", hash_original_field = "DEB26416BF26A48B3D4535794C8EE816", hash_generated_field = "95F7E58D2B9BB4F0C1C65AF576B6388E")

    private boolean mVisible = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.680 -0500", hash_original_field = "C2E7E9865FC949B188CDC2778A3CDB49", hash_generated_field = "22924785424C7732F326AFFE2483DB6D")

    private boolean mUserPresent = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.242 -0400", hash_original_field = "222E91439CEAD2DB1901D5AA0C5663AF", hash_generated_field = "8570C3C2B40A1C3E01F5D2029A49DFD5")

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.688 -0500", hash_original_method = "42FB9B1799748BE0453D66D785C793D7", hash_generated_method = "23D1606681C6D12B93F6FE5A1B1DE135")
        
@Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (Intent.ACTION_SCREEN_OFF.equals(action)) {
                mUserPresent = false;
                updateRunning();
            } else if (Intent.ACTION_USER_PRESENT.equals(action)) {
                mUserPresent = true;
                updateRunning(false);
            }
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.718 -0500", hash_original_field = "BA0637B23BB6A08212BC08AF87AA314C", hash_generated_field = "1535E31D28A65629AD405F9453386A42")

    private final int FLIP_MSG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:08.243 -0400", hash_original_field = "02869CDAF60D7BAD10F76E3EF9313FAC", hash_generated_field = "1FE43EAD86528C4571343BC4A0A3488D")

    private final Handler mHandler = new Handler() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.721 -0500", hash_original_method = "9F9F367503C2FAC32268BB267EBDCEAD", hash_generated_method = "CD26E5BE6357ABE9D2346B7AF9741B36")
        
@Override
        public void handleMessage(Message msg) {
            if (msg.what == FLIP_MSG) {
                if (mRunning) {
                    showNext();
                    msg = obtainMessage(FLIP_MSG);
                    sendMessageDelayed(msg, mFlipInterval);
                }
            }
        }
        
};

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.683 -0500", hash_original_method = "A199B0DFDE8F43BC0101C713FC646DAD", hash_generated_method = "F1434FE2DD7F51D20188988B1483EF43")
    
public ViewFlipper(Context context) {
        super(context);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.685 -0500", hash_original_method = "723832B306031BCDBE4BDCBA5DD42292", hash_generated_method = "EB20B59F8C96A8F49C048C0431FD3F80")
    
public ViewFlipper(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ViewFlipper);
        mFlipInterval = a.getInt(
                com.android.internal.R.styleable.ViewFlipper_flipInterval, DEFAULT_INTERVAL);
        mAutoStart = a.getBoolean(
                com.android.internal.R.styleable.ViewFlipper_autoStart, false);
        a.recycle();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.693 -0500", hash_original_method = "3C103BE4B999027DCB77DEB70D76599C", hash_generated_method = "FCE5AF733C5043F7461CE249BD2606AB")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        // Listen for broadcasts related to user-presence
        final IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.addAction(Intent.ACTION_USER_PRESENT);
        getContext().registerReceiver(mReceiver, filter);

        if (mAutoStart) {
            // Automatically start when requested
            startFlipping();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.696 -0500", hash_original_method = "5655570C437E83231F73A4B16A590D9C", hash_generated_method = "D0F3975A24544A8640CD91BD25CE7B13")
    
@Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mVisible = false;

        getContext().unregisterReceiver(mReceiver);
        updateRunning();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.698 -0500", hash_original_method = "B937BC0D8F057FC72AF74494BA3F6E3F", hash_generated_method = "7055D7B4883B6AB16F1FE2A76FC4240A")
    
@Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        mVisible = visibility == VISIBLE;
        updateRunning(false);
    }

    /**
     * How long to wait before flipping to the next view
     *
     * @param milliseconds
     *            time in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.700 -0500", hash_original_method = "FE23BFE06BF9BB8E822638D81DB338AA", hash_generated_method = "3BBF18AB973F26F75921817E02CEF872")
    
@android.view.RemotableViewMethod
    public void setFlipInterval(int milliseconds) {
        mFlipInterval = milliseconds;
    }

    /**
     * Start a timer to cycle through child views
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.702 -0500", hash_original_method = "5822F81CA7F02DBEFB349FF1928E2AAF", hash_generated_method = "39C61B259BA1261CD6245AE66BFEBE04")
    
public void startFlipping() {
        mStarted = true;
        updateRunning();
    }

    /**
     * No more flips
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.704 -0500", hash_original_method = "B53A11C7EF817F793ACB0CF78B800084", hash_generated_method = "8E3EB162110C30BEE66BD38213722D7C")
    
public void stopFlipping() {
        mStarted = false;
        updateRunning();
    }

    /**
     * Internal method to start or stop dispatching flip {@link Message} based
     * on {@link #mRunning} and {@link #mVisible} state.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.707 -0500", hash_original_method = "01EB120A60E7A5C93ADD152BE225A9A1", hash_generated_method = "EDCA1C3925D67C2FE8986A6375531C5A")
    
private void updateRunning() {
        updateRunning(true);
    }

    /**
     * Internal method to start or stop dispatching flip {@link Message} based
     * on {@link #mRunning} and {@link #mVisible} state.
     *
     * @param flipNow Determines whether or not to execute the animation now, in
     *            addition to queuing future flips. If omitted, defaults to
     *            true.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.710 -0500", hash_original_method = "FEBFE82757020B844DFA7E8A1658E9A7", hash_generated_method = "B818E36C169E4F3ABFEA4B684A66854A")
    
private void updateRunning(boolean flipNow) {
        boolean running = mVisible && mStarted && mUserPresent;
        if (running != mRunning) {
            if (running) {
                showOnly(mWhichChild, flipNow);
                Message msg = mHandler.obtainMessage(FLIP_MSG);
                mHandler.sendMessageDelayed(msg, mFlipInterval);
            } else {
                mHandler.removeMessages(FLIP_MSG);
            }
            mRunning = running;
        }
        if (LOGD) {
            Log.d(TAG, "updateRunning() mVisible=" + mVisible + ", mStarted=" + mStarted
                    + ", mUserPresent=" + mUserPresent + ", mRunning=" + mRunning);
        }
    }

    /**
     * Returns true if the child views are flipping.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.712 -0500", hash_original_method = "DA5270F6FAC446A7F1E0A4F7A45712B2", hash_generated_method = "CC45C819AC99492B223D0D8A3E72BB57")
    
public boolean isFlipping() {
        return mStarted;
    }

    /**
     * Set if this view automatically calls {@link #startFlipping()} when it
     * becomes attached to a window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.714 -0500", hash_original_method = "718522AE4DB02C55EF285DE2125FBBC5", hash_generated_method = "469968AC2CEC14C20335FC3120ADE3F0")
    
public void setAutoStart(boolean autoStart) {
        mAutoStart = autoStart;
    }

    /**
     * Returns true if this view automatically calls {@link #startFlipping()}
     * when it becomes attached to a window.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:12.716 -0500", hash_original_method = "0E315A42E6B247C6D130CCD7ADAB21A6", hash_generated_method = "CAA954AB0CA6C52101704248348CA558")
    
public boolean isAutoStart() {
        return mAutoStart;
    }
}

