package android.widget;

// Droidsafe Imports
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
    final Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.949 -0400", hash_original_field = "A60F5180B22F6E5F19E5F083AF1E3B9C", hash_generated_field = "9FD3A39830EF0DBA4B8238391B28165D")

    TN mTN;
    int mDuration;
    View mNextView;
    
    @DSModeled(DSC.SAFE)
    public Toast(Context context) {
        mContext = context;
        /*
        mTN = new TN();
        mTN.mY = context.getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.toast_y_offset);
         */
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public void cancel() {
        //mTN.hide();
    }

    
    @DSModeled(DSC.SAFE)
    public void setView(View view) {
        mNextView = view;
    }

    
    @DSModeled(DSC.SAFE)
    public View getView() {
        return mNextView;
    }

    
    @DSModeled(DSC.SAFE)
    public void setDuration(int duration) {
        mDuration = duration;
    }

    
    @DSModeled(DSC.SAFE)
    public int getDuration() {
        return mDuration;
    }

    
    @DSModeled(DSC.SAFE)
    public void setMargin(float horizontalMargin, float verticalMargin) {
    	addTaint(horizontalMargin);
    	addTaint(verticalMargin);
    	//DSModel nothing
        //mTN.mHorizontalMargin = horizontalMargin;
        //mTN.mVerticalMargin = verticalMargin;
    }

    
    @DSModeled(DSC.SAFE)
    public float getHorizontalMargin() {
        return getTaintFloat();
    }

    
    @DSModeled(DSC.SAFE)
    public float getVerticalMargin() {
    	 return getTaintFloat();
    }

    
    @DSModeled(DSC.SAFE)
    //just spread around 
    public void setGravity(int gravity, int xOffset, int yOffset) {
    	addTaint(gravity);
    	addTaint(xOffset);
    	addTaint(yOffset);
    }

    
    @DSModeled(DSC.SAFE)
    public int getGravity() {
        return getTaintInt();
    }

    
    @DSModeled(DSC.SAFE)
    public int getXOffset() {
    	return getTaintInt();
    }

    
    @DSModeled(DSC.SAFE)
    public int getYOffset() {
    	return getTaintInt();
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static Toast makeText(Context context, int resId, int duration)
                                throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    
    @DSModeled(DSC.SAFE)
    public void setText(int resId) {
        addTaint(resId);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    static private INotificationManager getService() {
        if (sService != null) {
            return sService;
        }
        sService = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        return sService;
    }

    
    private static class TN extends ITransientNotification.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.956 -0400", hash_original_field = "61DCBB3696F6FA4BE5725088AFF4EB28", hash_generated_field = "6AF3C3B4B49A59D6013EE9E0CE06975A")

        final Runnable mShow = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.956 -0400", hash_original_method = "44EABCAA91D08F4C06482A1ED1EE7668", hash_generated_method = "C9938375C8B8C21D868647BA643A9E49")
            public void run() {
                handleShow();
                // ---------- Original Method ----------
                //handleShow();
            }

            
};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.956 -0400", hash_original_field = "4A991A7F26DC9B6186AFC4C4EB669FA3", hash_generated_field = "4A646C9F9E760360BE93A3CC889065DC")

        final Runnable mHide = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.956 -0400", hash_original_method = "E71A75E071185259CF3C7ACA95EB5B7E", hash_generated_method = "49C08F8FDD2E9C240F65F014A25A620F")
            public void run() {
                handleHide();
                mNextView = null;
                // ---------- Original Method ----------
                //handleHide();
                //mNextView = null;
            }

            
};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.956 -0400", hash_original_field = "A49B715DAD456F789D4DE84CB6B77BBB", hash_generated_field = "9D5A036E2B4B34FBB053D812B184F194")

        private final WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

        final Handler mHandler = new Handler();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "D823E5E364D84A8EA59B0380B053EF90", hash_generated_field = "DD23A9E22F530443036D30182A32A544")

        int mGravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "E1F6755A84A68EBC18BAD4F06FC5D16F", hash_generated_field = "959E8F46A9EA632A6B6E3D2CF78E0965")

        float mHorizontalMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "98193689CD8029EF466C4AB846FA22ED", hash_generated_field = "0453553E896378DC7255CD56DA183A0A")

        float mVerticalMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

        View mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "BE0E61D34731712A85B6DF50B44906B0", hash_generated_field = "03D31907A1E7C016AB4113CE084AA49B")

        View mNextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.957 -0400", hash_original_field = "4FEDCF33DA439800CB483956AE637716", hash_generated_field = "3C3F603D5D48071B1A37F937EDC3827B")

        WindowManagerImpl mWM;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.958 -0400", hash_original_method = "41B653C614D176194B8FC12B04D74B1D", hash_generated_method = "E327577FEE453D387B060A3B6BA4FEA2")
          TN() {
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
            // ---------- Original Method ----------
            //final WindowManager.LayoutParams params = mParams;
            //params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            //params.width = WindowManager.LayoutParams.WRAP_CONTENT;
            //params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                    //| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                    //| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
            //params.format = PixelFormat.TRANSLUCENT;
            //params.windowAnimations = com.android.internal.R.style.Animation_Toast;
            //params.type = WindowManager.LayoutParams.TYPE_TOAST;
            //params.setTitle("Toast");
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.958 -0400", hash_original_method = "3E96BAE0A73C07217EE9E69C0532B078", hash_generated_method = "BB5D385BC3C8223150F4E4262DAAE933")
        public void show() {
            if(localLOGV){ }            mHandler.post(mShow);
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "SHOW: " + this);
            //mHandler.post(mShow);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.959 -0400", hash_original_method = "FE787FFB2514635467B163AE42817C6A", hash_generated_method = "40ECBFB62DE691BA597DB6DCC67A7515")
        public void hide() {
            if(localLOGV){ }            mHandler.post(mHide);
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "HIDE: " + this);
            //mHandler.post(mHide);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.959 -0400", hash_original_method = "98FF4DE105C724C8A8B16C9823509AFE", hash_generated_method = "525D64A0BC18150DC506029B28E703A6")
        public void handleShow() {
            if(localLOGV){ }            if(mView != mNextView)            
            {
                handleHide();
                mView = mNextView;
                mWM = WindowManagerImpl.getDefault();
                final int gravity = mGravity;
                mParams.gravity = gravity;
                if((gravity & Gravity.HORIZONTAL_GRAVITY_MASK) == Gravity.FILL_HORIZONTAL)                
                {
                    mParams.horizontalWeight = 1.0f;
                } //End block
                if((gravity & Gravity.VERTICAL_GRAVITY_MASK) == Gravity.FILL_VERTICAL)                
                {
                    mParams.verticalWeight = 1.0f;
                } //End block
                mParams.x = mX;
                mParams.y = mY;
                mParams.verticalMargin = mVerticalMargin;
                mParams.horizontalMargin = mHorizontalMargin;
                if(mView.getParent() != null)                
                {
                    if(localLOGV){ }                    mWM.removeView(mView);
                } //End block
                if(localLOGV){ }                mWM.addView(mView, mParams);
                trySendAccessibilityEvent();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.959 -0400", hash_original_method = "D907D354027470BBEF302644D06948FD", hash_generated_method = "77A17536CC0EA3BEEAF27FC774321779")
        private void trySendAccessibilityEvent() {
            AccessibilityManager accessibilityManager = AccessibilityManager.getInstance(mView.getContext());
            if(!accessibilityManager.isEnabled())            
            {
                return;
            } //End block
            AccessibilityEvent event = AccessibilityEvent.obtain(
                    AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED);
            event.setClassName(getClass().getName());
            event.setPackageName(mView.getContext().getPackageName());
            mView.dispatchPopulateAccessibilityEvent(event);
            accessibilityManager.sendAccessibilityEvent(event);
            // ---------- Original Method ----------
            //AccessibilityManager accessibilityManager =
                    //AccessibilityManager.getInstance(mView.getContext());
            //if (!accessibilityManager.isEnabled()) {
                //return;
            //}
            //AccessibilityEvent event = AccessibilityEvent.obtain(
                    //AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED);
            //event.setClassName(getClass().getName());
            //event.setPackageName(mView.getContext().getPackageName());
            //mView.dispatchPopulateAccessibilityEvent(event);
            //accessibilityManager.sendAccessibilityEvent(event);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.960 -0400", hash_original_method = "20728D50D3469CDB24AC075F372999DE", hash_generated_method = "AA70D0752BF89D1DDB63FBCD9D7D350D")
        public void handleHide() {
            if(localLOGV){ }            if(mView != null)            
            {
                if(mView.getParent() != null)                
                {
                    if(localLOGV){ }                    mWM.removeView(mView);
                } //End block
                mView = null;
            } //End block
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "HANDLE HIDE: " + this + " mView=" + mView);
            //if (mView != null) {
                //if (mView.getParent() != null) {
                    //if (localLOGV) Log.v(TAG, "REMOVE! " + mView + " in " + this);
                    //mWM.removeView(mView);
                //}
                //mView = null;
            //}
        }

        
    }


    
    static final String TAG = "Toast";
    static final boolean localLOGV = false;
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:42.960 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "F81A4B790E53712C35BD5EDD5A7B2761")

    private static INotificationManager sService;
}

