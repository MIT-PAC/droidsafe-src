package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.app.INotificationManager;
import android.app.ITransientNotification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.ServiceManager;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManagerImpl;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

public class Toast {
    
    public static Toast makeText(Context context, CharSequence text, int duration) {
        Toast result = new Toast(context);
        result.addTaint(text.getTaint());
        result.addTaint(duration);
        /*  DSModel: Not needed for ds modeling
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(com.android.internal.R.layout.transient_notification, null);
        TextView tv = (TextView)v.findViewById(com.android.internal.R.id.message);
        tv.setText(text);
        result.mNextView = v;
        result.mDuration = duration;
         */
        return result;
    }

    /**
     * Make a standard toast that just contains a text view with the text from a resource.
     *
     * @param context  The context to use.  Usually your {@link android.app.Application}
     *                 or {@link android.app.Activity} object.
     * @param resId    The resource id of the string resource to use.  Can be formatted text.
     * @param duration How long to display the message.  Either {@link #LENGTH_SHORT} or
     *                 {@link #LENGTH_LONG}
     *
     * @throws Resources.NotFoundException if the resource can't be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.698 -0500", hash_original_method = "DED4BD06169F84224562F0B1604E2BF3", hash_generated_method = "130DA15736FD2AED20E191F76300EB40")
    
public static Toast makeText(Context context, int resId, int duration)
                                throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.708 -0500", hash_original_method = "D9E8679815944C5B89F305CDC2FBAD3D", hash_generated_method = "F556B20E007842B92ED86508184E1CF6")
    
static private INotificationManager getService() {
        if (sService != null) {
            return sService;
        }
        sService = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        return sService;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.648 -0500", hash_original_field = "FA327CDBB9DF0DDD5F73332DD03CFB4D", hash_generated_field = "F05B76D447AAFE870701AA37F27DA0B8")

    static final String TAG = "Toast";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.650 -0500", hash_original_field = "7A06C0A50B73200DDC70097F2AFFF800", hash_generated_field = "071B7B77A9473B9527F9198838C91D11")

    static final boolean localLOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.652 -0500", hash_original_field = "4DCF3879F09C14D5BCF76C916A0EC948", hash_generated_field = "DADE3EEB6C5391F63930F5C39F2A4C3E")

    public static final int LENGTH_SHORT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.655 -0500", hash_original_field = "D2BB38A305F850517366E77CF67E2007", hash_generated_field = "64F95B063A0FA537B7B8301601F6DA0E")

    public static final int LENGTH_LONG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.706 -0500", hash_original_field = "2143D8EEECB82E176C0D26D54E4D19A4", hash_generated_field = "48027B1580136F0A0F279FD14B6D6DEC")

    // All the gunk below is the interaction with the Notification Service, which handles
    // the proper ordering of these system-wide.
    // =======================================================================================

    private static INotificationManager sService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.657 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

     Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.659 -0500", hash_original_field = "9FD3A39830EF0DBA4B8238391B28165D", hash_generated_field = "9FD3A39830EF0DBA4B8238391B28165D")

     TN mTN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.661 -0500", hash_original_field = "BC345057CF9CBE8611DA24E477E3EC27", hash_generated_field = "BC345057CF9CBE8611DA24E477E3EC27")

    int mDuration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.663 -0500", hash_original_field = "03D31907A1E7C016AB4113CE084AA49B", hash_generated_field = "03D31907A1E7C016AB4113CE084AA49B")

    View mNextView;
    
    public Toast(Context context) {
        mContext = context;
        /*
        mTN = new TN();
        mTN.mY = context.getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.toast_y_offset);
         */
    }
    
    public void show() {
    	/*  DSModel: nothing
        if (mNextView == null) {
            throw new RuntimeException("setView must have been called");
        }
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        TN tn = mTN;
        tn.mNextView = mNextView;
        try {
            service.enqueueToast(pkg, tn, mDuration);
        } catch (RemoteException e) {
            // Empty
        }*/
    }
    
    public void cancel() {
        //mTN.hide();
    }
    
    /**
     * Set the view to show.
     * @see #getView
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.671 -0500", hash_original_method = "A152CAEDF892AE03EF7992276FE51073", hash_generated_method = "7A1335C4EBD21EC5DD94AA3AB645FF1E")
    
public void setView(View view) {
        mNextView = view;
    }

    /**
     * Return the view.
     * @see #setView
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.673 -0500", hash_original_method = "2CED2C577EBE287B42B9009F6CFBB820", hash_generated_method = "ED02319FD8C55BBBE02C9D62576886C6")
    
public View getView() {
        return mNextView;
    }

    /**
     * Set how long to show the view for.
     * @see #LENGTH_SHORT
     * @see #LENGTH_LONG
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.676 -0500", hash_original_method = "CFB561A2B5CB71F6E4A1F9C7A12A3738", hash_generated_method = "D51008122D27A2464E436EFAFCAD6803")
    
public void setDuration(int duration) {
        mDuration = duration;
    }

    /**
     * Return the duration.
     * @see #setDuration
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.678 -0500", hash_original_method = "C5CB9F23218BD0303C05492AF6E52DA2", hash_generated_method = "80F84565BFC7764AF82A57198D1B3547")
    
public int getDuration() {
        return mDuration;
    }
    
    public void setMargin(float horizontalMargin, float verticalMargin) {
    	addTaint(horizontalMargin);
    	addTaint(verticalMargin);
    	//DSModel nothing
        //mTN.mHorizontalMargin = horizontalMargin;
        //mTN.mVerticalMargin = verticalMargin;
    }
    
    public float getHorizontalMargin() {
        return getTaintFloat();
    }
    
    public float getVerticalMargin() {
    	 return getTaintFloat();
    }
    
    //just spread around 
    public void setGravity(int gravity, int xOffset, int yOffset) {
    	addTaint(gravity);
    	addTaint(xOffset);
    	addTaint(yOffset);
    }
    
    private static class TN extends ITransientNotification.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.956 -0400", hash_original_field = "61DCBB3696F6FA4BE5725088AFF4EB28", hash_generated_field = "6AF3C3B4B49A59D6013EE9E0CE06975A")

        final Runnable mShow = new Runnable() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.711 -0500", hash_original_method = "44EABCAA91D08F4C06482A1ED1EE7668", hash_generated_method = "121907DB5C04B31E2BB55AB36D30C2D9")
            
public void run() {
                handleShow();
            }
            
};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.956 -0400", hash_original_field = "4A991A7F26DC9B6186AFC4C4EB669FA3", hash_generated_field = "4A646C9F9E760360BE93A3CC889065DC")

        final Runnable mHide = new Runnable() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.716 -0500", hash_original_method = "E71A75E071185259CF3C7ACA95EB5B7E", hash_generated_method = "9E0890BCF1D46FD8EBD941351D9F7BE5")
            
public void run() {
                handleHide();
                // Don't do this in handleHide() because it is also invoked by handleShow()
                mNextView = null;
            }
            
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.721 -0500", hash_original_field = "BE5239BD4C6005A12F359DFD503635BD", hash_generated_field = "9D5A036E2B4B34FBB053D812B184F194")

        private final WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.723 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

        final Handler mHandler = new Handler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.725 -0500", hash_original_field = "DD23A9E22F530443036D30182A32A544", hash_generated_field = "DD23A9E22F530443036D30182A32A544")

        int mGravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.730 -0500", hash_original_field = "959E8F46A9EA632A6B6E3D2CF78E0965", hash_generated_field = "959E8F46A9EA632A6B6E3D2CF78E0965")

        float mHorizontalMargin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.732 -0500", hash_original_field = "0453553E896378DC7255CD56DA183A0A", hash_generated_field = "0453553E896378DC7255CD56DA183A0A")

        float mVerticalMargin;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.734 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")
       
        View mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.736 -0500", hash_original_field = "03D31907A1E7C016AB4113CE084AA49B", hash_generated_field = "03D31907A1E7C016AB4113CE084AA49B")

        View mNextView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.739 -0500", hash_original_field = "3C3F603D5D48071B1A37F937EDC3827B", hash_generated_field = "3C3F603D5D48071B1A37F937EDC3827B")
        
        WindowManagerImpl mWM;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.742 -0500", hash_original_method = "41B653C614D176194B8FC12B04D74B1D", hash_generated_method = "0605A5E0457D435CD7B49511E97EF060")
        
TN() {
            // XXX This should be changed to use a Dialog, with a Theme.Toast
            // defined that sets up the layout params appropriately.
            final WindowManager.LayoutParams params = mParams;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            params.width = WindowManager.LayoutParams.WRAP_CONTENT;
            params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
            params.format = PixelFormat.TRANSLUCENT;
            params.windowAnimations = com.android.internal.R.style.Animation_Toast;
            params.type = WindowManager.LayoutParams.TYPE_TOAST;
            params.setTitle("Toast");
        }

        /**
         * schedule handleShow into the right thread
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.744 -0500", hash_original_method = "3E96BAE0A73C07217EE9E69C0532B078", hash_generated_method = "2365E22F3A38CEC7407569DAB2E8C5E7")
        
public void show() {
            if (localLOGV) Log.v(TAG, "SHOW: " + this);
            mHandler.post(mShow);
        }

        /**
         * schedule handleHide into the right thread
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.746 -0500", hash_original_method = "FE787FFB2514635467B163AE42817C6A", hash_generated_method = "D3CEB0C7341C4FBC5FE1D26C18B92729")
        
public void hide() {
            if (localLOGV) Log.v(TAG, "HIDE: " + this);
            mHandler.post(mHide);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.749 -0500", hash_original_method = "98FF4DE105C724C8A8B16C9823509AFE", hash_generated_method = "5234CC5E9049C279A40DC4831CDE71FC")
        
public void handleShow() {
            if (localLOGV) Log.v(TAG, "HANDLE SHOW: " + this + " mView=" + mView
                    + " mNextView=" + mNextView);
            if (mView != mNextView) {
                // remove the old view if necessary
                handleHide();
                mView = mNextView;
                mWM = WindowManagerImpl.getDefault();
                final int gravity = mGravity;
                mParams.gravity = gravity;
                if ((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == Gravity.FILL_HORIZONTAL) {
                    mParams.horizontalWeight = 1.0f;
                }
                if ((gravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.FILL_VERTICAL) {
                    mParams.verticalWeight = 1.0f;
                }
                mParams.x = mX;
                mParams.y = mY;
                mParams.verticalMargin = mVerticalMargin;
                mParams.horizontalMargin = mHorizontalMargin;
                if (mView.getParent() != null) {
                    if (localLOGV) Log.v(TAG, "REMOVE! " + mView + " in " + this);
                    mWM.removeView(mView);
                }
                if (localLOGV) Log.v(TAG, "ADD! " + mView + " in " + this);
                mWM.addView(mView, mParams);
                trySendAccessibilityEvent();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.752 -0500", hash_original_method = "D907D354027470BBEF302644D06948FD", hash_generated_method = "B75002871EB6AE366E3CCD65B5A87161")
        
private void trySendAccessibilityEvent() {
            AccessibilityManager accessibilityManager =
                    AccessibilityManager.getInstance(mView.getContext());
            if (!accessibilityManager.isEnabled()) {
                return;
            }
            // treat toasts as notifications since they are used to
            // announce a transient piece of information to the user
            AccessibilityEvent event = AccessibilityEvent.obtain(
                    AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED);
            event.setClassName(getClass().getName());
            event.setPackageName(mView.getContext().getPackageName());
            mView.dispatchPopulateAccessibilityEvent(event);
            accessibilityManager.sendAccessibilityEvent(event);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:44.754 -0500", hash_original_method = "20728D50D3469CDB24AC075F372999DE", hash_generated_method = "8E5237ED1952EF14C2A5A1C766F6DC2E")
        
public void handleHide() {
            if (localLOGV) Log.v(TAG, "HANDLE HIDE: " + this + " mView=" + mView);
            if (mView != null) {
                // note: checking parent() just to make sure the view has
                // been added...  i have seen cases where we get here when
                // the view isn't yet added, so let's try not to crash.
                if (mView.getParent() != null) {
                    if (localLOGV) Log.v(TAG, "REMOVE! " + mView + " in " + this);
                    mWM.removeView(mView);
                }

                mView = null;
            }
        }
        
    }
    
    public int getGravity() {
        return getTaintInt();
    }
    
    public int getXOffset() {
    	return getTaintInt();
    }
    
    public int getYOffset() {
    	return getTaintInt();
    }
    
    public void setText(int resId) {
        addTaint(resId);
    }
    
    public void setText(CharSequence s) {
    	addTaint(s.toString().getTaint());
    	/*
        if (mNextView == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        TextView tv = (TextView) mNextView.findViewById(com.android.internal.R.id.message);
        if (tv == null) {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        }
        tv.setText(s);
        */
    }
}

