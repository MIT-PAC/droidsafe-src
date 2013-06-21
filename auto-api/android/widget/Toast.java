package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.INotificationManager;
import android.app.ITransientNotification;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManagerImpl;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;

public class Toast {
    Context mContext;
    TN mTN;
    int mDuration;
    View mNextView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.783 -0400", hash_original_method = "2A3FE9273E86BBACFA2AB5C5898C3146", hash_generated_method = "586D0F63DA8312C4BE63A28EE47B3442")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Toast(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mTN = new TN();
        mTN.mY = context.getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.toast_y_offset);
        // ---------- Original Method ----------
        //mContext = context;
        //mTN = new TN();
        //mTN.mY = context.getResources().getDimensionPixelSize(
                //com.android.internal.R.dimen.toast_y_offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.783 -0400", hash_original_method = "EBD8B8572362DD92CF984D93DE6E4FF9", hash_generated_method = "3BE8918CAD81CCFB746595A1EFA0AE41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void show() {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("setView must have been called");
        } //End block
        INotificationManager service;
        service = getService();
        String pkg;
        pkg = mContext.getPackageName();
        TN tn;
        tn = mTN;
        tn.mNextView = mNextView;
        try 
        {
            service.enqueueToast(pkg, tn, mDuration);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //if (mNextView == null) {
            //throw new RuntimeException("setView must have been called");
        //}
        //INotificationManager service = getService();
        //String pkg = mContext.getPackageName();
        //TN tn = mTN;
        //tn.mNextView = mNextView;
        //try {
            //service.enqueueToast(pkg, tn, mDuration);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.783 -0400", hash_original_method = "905E110A9D66070AD259EFE2B60EBDFA", hash_generated_method = "5E755949284AFD2F0E09AB46034EB948")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        mTN.hide();
        // ---------- Original Method ----------
        //mTN.hide();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.784 -0400", hash_original_method = "A152CAEDF892AE03EF7992276FE51073", hash_generated_method = "26D3ECAB197167EFF09AD089FBD77192")
    @DSModeled(DSC.SAFE)
    public void setView(View view) {
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
        //mNextView = view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.784 -0400", hash_original_method = "2CED2C577EBE287B42B9009F6CFBB820", hash_generated_method = "8DDA48E678D7C8F43597E171241D8EF2")
    @DSModeled(DSC.SAFE)
    public View getView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNextView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.784 -0400", hash_original_method = "CFB561A2B5CB71F6E4A1F9C7A12A3738", hash_generated_method = "085A6AAA128A2B1F04C29FE8C12B3FA0")
    @DSModeled(DSC.SAFE)
    public void setDuration(int duration) {
        dsTaint.addTaint(duration);
        // ---------- Original Method ----------
        //mDuration = duration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.784 -0400", hash_original_method = "C5CB9F23218BD0303C05492AF6E52DA2", hash_generated_method = "28DF85F007796C157967BAC1C0AC3A90")
    @DSModeled(DSC.SAFE)
    public int getDuration() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.784 -0400", hash_original_method = "F425C47FB7437E78AF178C34F14EA79B", hash_generated_method = "FC30739E8FF10CB3F7ECA281AAAE2F23")
    @DSModeled(DSC.SAFE)
    public void setMargin(float horizontalMargin, float verticalMargin) {
        dsTaint.addTaint(horizontalMargin);
        dsTaint.addTaint(verticalMargin);
        mTN.mHorizontalMargin = horizontalMargin;
        mTN.mVerticalMargin = verticalMargin;
        // ---------- Original Method ----------
        //mTN.mHorizontalMargin = horizontalMargin;
        //mTN.mVerticalMargin = verticalMargin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.785 -0400", hash_original_method = "F7B8097D0A28A7644F4CAA36263A6BC5", hash_generated_method = "F16CA63DD2AF487F3389702BE94E54C9")
    @DSModeled(DSC.SAFE)
    public float getHorizontalMargin() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTN.mHorizontalMargin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.785 -0400", hash_original_method = "08E3924FC925E4DE8E371EC71C6F9BB2", hash_generated_method = "74C21F7F17527D6AB19C7A3F43B64729")
    @DSModeled(DSC.SAFE)
    public float getVerticalMargin() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTN.mVerticalMargin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.785 -0400", hash_original_method = "0F798A7E93CD7957534C3E69090E738D", hash_generated_method = "9D667AD7C7C7054E0221CE5CDC35A7AE")
    @DSModeled(DSC.SAFE)
    public void setGravity(int gravity, int xOffset, int yOffset) {
        dsTaint.addTaint(yOffset);
        dsTaint.addTaint(xOffset);
        dsTaint.addTaint(gravity);
        mTN.mGravity = gravity;
        mTN.mX = xOffset;
        mTN.mY = yOffset;
        // ---------- Original Method ----------
        //mTN.mGravity = gravity;
        //mTN.mX = xOffset;
        //mTN.mY = yOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.785 -0400", hash_original_method = "2C9BD84752A31EC6F5E143771739878E", hash_generated_method = "49E5296A841D66D916CA9943E4592E16")
    @DSModeled(DSC.SAFE)
    public int getGravity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTN.mGravity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.785 -0400", hash_original_method = "2AE943B633C6B771A3DBDC9830EE282D", hash_generated_method = "7195421435D7D8F58F98781B9CA30313")
    @DSModeled(DSC.SAFE)
    public int getXOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTN.mX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.785 -0400", hash_original_method = "3212505834221ECE93D6F08E5BDF4AC5", hash_generated_method = "DC25ECD5B30F67217907D7E8F61CEDC7")
    @DSModeled(DSC.SAFE)
    public int getYOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTN.mY;
    }

    
        public static Toast makeText(Context context, CharSequence text, int duration) {
        Toast result = new Toast(context);
        LayoutInflater inflate = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflate.inflate(com.android.internal.R.layout.transient_notification, null);
        TextView tv = (TextView)v.findViewById(com.android.internal.R.id.message);
        tv.setText(text);
        result.mNextView = v;
        result.mDuration = duration;
        return result;
    }

    
        public static Toast makeText(Context context, int resId, int duration) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.786 -0400", hash_original_method = "FD3914B9295A9EB352EBE416E97ECCF2", hash_generated_method = "6B439A776692E16AE822225687D15AD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(int resId) {
        dsTaint.addTaint(resId);
        setText(mContext.getText(resId));
        // ---------- Original Method ----------
        //setText(mContext.getText(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.786 -0400", hash_original_method = "75C0E785CBEB5D5B8434AF0D1C3897A8", hash_generated_method = "FBCCF3C43A524EDEA538AA7BDAA28328")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(CharSequence s) {
        dsTaint.addTaint(s);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("This Toast was not created with Toast.makeText()");
        } //End block
        TextView tv;
        tv = (TextView) mNextView.findViewById(com.android.internal.R.id.message);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("This Toast was not created with Toast.makeText()");
        } //End block
        tv.setText(s);
        // ---------- Original Method ----------
        //if (mNextView == null) {
            //throw new RuntimeException("This Toast was not created with Toast.makeText()");
        //}
        //TextView tv = (TextView) mNextView.findViewById(com.android.internal.R.id.message);
        //if (tv == null) {
            //throw new RuntimeException("This Toast was not created with Toast.makeText()");
        //}
        //tv.setText(s);
    }

    
        static private INotificationManager getService() {
        if (sService != null) {
            return sService;
        }
        sService = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        return sService;
    }

    
    private static class TN extends ITransientNotification.Stub {
        final Runnable mShow = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.786 -0400", hash_original_method = "44EABCAA91D08F4C06482A1ED1EE7668", hash_generated_method = "C9938375C8B8C21D868647BA643A9E49")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                handleShow();
                // ---------- Original Method ----------
                //handleShow();
            }

            
}; //Transformed anonymous class
        final Runnable mHide = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.787 -0400", hash_original_method = "E71A75E071185259CF3C7ACA95EB5B7E", hash_generated_method = "49C08F8FDD2E9C240F65F014A25A620F")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                handleHide();
                mNextView = null;
                // ---------- Original Method ----------
                //handleHide();
                //mNextView = null;
            }

            
}; //Transformed anonymous class
        private WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
        Handler mHandler = new Handler();
        int mGravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        int mX, mY;
        float mHorizontalMargin;
        float mVerticalMargin;
        View mView;
        View mNextView;
        WindowManagerImpl mWM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.787 -0400", hash_original_method = "41B653C614D176194B8FC12B04D74B1D", hash_generated_method = "5D2AB94EA13B478627376DE5AF67C9AE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         TN() {
            WindowManager.LayoutParams params;
            params = mParams;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.787 -0400", hash_original_method = "3E96BAE0A73C07217EE9E69C0532B078", hash_generated_method = "DB21D5FEBA237BDEFB3DEAADE3B14154")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void show() {
            mHandler.post(mShow);
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "SHOW: " + this);
            //mHandler.post(mShow);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.787 -0400", hash_original_method = "FE787FFB2514635467B163AE42817C6A", hash_generated_method = "1CA4F3CC11777FC85B713964648F2E8A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void hide() {
            mHandler.post(mHide);
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "HIDE: " + this);
            //mHandler.post(mHide);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.788 -0400", hash_original_method = "98FF4DE105C724C8A8B16C9823509AFE", hash_generated_method = "99C3F6E9594EFD22773FE712AB71148B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleShow() {
            {
                handleHide();
                mView = mNextView;
                mWM = WindowManagerImpl.getDefault();
                int gravity;
                gravity = mGravity;
                mParams.gravity = gravity;
                {
                    mParams.horizontalWeight = 1.0f;
                } //End block
                {
                    mParams.verticalWeight = 1.0f;
                } //End block
                mParams.x = mX;
                mParams.y = mY;
                mParams.verticalMargin = mVerticalMargin;
                mParams.horizontalMargin = mHorizontalMargin;
                {
                    boolean var343900A41CC12F4354B7979405515384_1724173893 = (mView.getParent() != null);
                    {
                        mWM.removeView(mView);
                    } //End block
                } //End collapsed parenthetic
                mWM.addView(mView, mParams);
                trySendAccessibilityEvent();
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.788 -0400", hash_original_method = "D907D354027470BBEF302644D06948FD", hash_generated_method = "01727266867847FEA02124D95EE77D40")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void trySendAccessibilityEvent() {
            AccessibilityManager accessibilityManager;
            accessibilityManager = AccessibilityManager.getInstance(mView.getContext());
            {
                boolean var08EDE530C2FAA323754F9BC061A1BF41_394775549 = (!accessibilityManager.isEnabled());
            } //End collapsed parenthetic
            AccessibilityEvent event;
            event = AccessibilityEvent.obtain(
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.788 -0400", hash_original_method = "20728D50D3469CDB24AC075F372999DE", hash_generated_method = "D0A4248A262BFE4D5F4B7ADF843C264E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleHide() {
            {
                {
                    boolean var343900A41CC12F4354B7979405515384_1833157141 = (mView.getParent() != null);
                    {
                        mWM.removeView(mView);
                    } //End block
                } //End collapsed parenthetic
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
    private static INotificationManager sService;
}

