package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    static final String TAG = "Toast";
    static final boolean localLOGV = false;
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    final Context mContext;
    final TN mTN;
    int mDuration;
    View mNextView;
    private static INotificationManager sService;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.231 -0400", hash_original_method = "2A3FE9273E86BBACFA2AB5C5898C3146", hash_generated_method = "16D41D23B22F5F58AB06F54D8F85300A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.231 -0400", hash_original_method = "EBD8B8572362DD92CF984D93DE6E4FF9", hash_generated_method = "54AEA1798B5EFF4C194E599D4DF717F6")
    @DSModeled(DSC.SAFE)
    public void show() {
        {
            throw new RuntimeException("setView must have been called");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.231 -0400", hash_original_method = "905E110A9D66070AD259EFE2B60EBDFA", hash_generated_method = "8BC1D7EC9BB3F66A2E522E103D21E311")
    @DSModeled(DSC.SAFE)
    public void cancel() {
        mTN.hide();
        // ---------- Original Method ----------
        //mTN.hide();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.231 -0400", hash_original_method = "A152CAEDF892AE03EF7992276FE51073", hash_generated_method = "A4CEFF8490432B9E1EF07E03148B998E")
    @DSModeled(DSC.SAFE)
    public void setView(View view) {
        dsTaint.addTaint(view.dsTaint);
        // ---------- Original Method ----------
        //mNextView = view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.231 -0400", hash_original_method = "2CED2C577EBE287B42B9009F6CFBB820", hash_generated_method = "D60D49AF68CB5D435CD8C14B7A3AFA6F")
    @DSModeled(DSC.SAFE)
    public View getView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mNextView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.231 -0400", hash_original_method = "CFB561A2B5CB71F6E4A1F9C7A12A3738", hash_generated_method = "5F9E2805B8481F80EA8909B49EC97936")
    @DSModeled(DSC.SAFE)
    public void setDuration(int duration) {
        dsTaint.addTaint(duration);
        // ---------- Original Method ----------
        //mDuration = duration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.231 -0400", hash_original_method = "C5CB9F23218BD0303C05492AF6E52DA2", hash_generated_method = "7CD82604E96F38B0181C6C3FBE51A8FE")
    @DSModeled(DSC.SAFE)
    public int getDuration() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "F425C47FB7437E78AF178C34F14EA79B", hash_generated_method = "0294080373C89A5476C74E1574C38796")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "F7B8097D0A28A7644F4CAA36263A6BC5", hash_generated_method = "7C75A41C8A7091D7042BD7E8CA86B417")
    @DSModeled(DSC.SAFE)
    public float getHorizontalMargin() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTN.mHorizontalMargin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "08E3924FC925E4DE8E371EC71C6F9BB2", hash_generated_method = "B41E3FDD4BDF9540370804C3D99253AB")
    @DSModeled(DSC.SAFE)
    public float getVerticalMargin() {
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return mTN.mVerticalMargin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "0F798A7E93CD7957534C3E69090E738D", hash_generated_method = "E1C313EF7EB84EC7C7814B44375CD66F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "2C9BD84752A31EC6F5E143771739878E", hash_generated_method = "0CC8A1EBE66C347A609D0D04FB5E5F5E")
    @DSModeled(DSC.SAFE)
    public int getGravity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTN.mGravity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "2AE943B633C6B771A3DBDC9830EE282D", hash_generated_method = "70C3F822FB6BA1D911FC814463EFE16A")
    @DSModeled(DSC.SAFE)
    public int getXOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTN.mX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "3212505834221ECE93D6F08E5BDF4AC5", hash_generated_method = "45D1D414B00D0473979F0A4BA325ACFA")
    @DSModeled(DSC.SAFE)
    public int getYOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTN.mY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "31F8B63B0A424AF01D11419A45F6A90D", hash_generated_method = "C715B147101884C363F795387AC62FC6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "DED4BD06169F84224562F0B1604E2BF3", hash_generated_method = "130DA15736FD2AED20E191F76300EB40")
    public static Toast makeText(Context context, int resId, int duration) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "FD3914B9295A9EB352EBE416E97ECCF2", hash_generated_method = "8326BC6F6FF80631177EF75F98BF6D2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(int resId) {
        dsTaint.addTaint(resId);
        setText(mContext.getText(resId));
        // ---------- Original Method ----------
        //setText(mContext.getText(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "75C0E785CBEB5D5B8434AF0D1C3897A8", hash_generated_method = "6A6149420C20099F4EC7EB36FADBA216")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(CharSequence s) {
        dsTaint.addTaint(s);
        {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
        } //End block
        TextView tv;
        tv = (TextView) mNextView.findViewById(com.android.internal.R.id.message);
        {
            throw new RuntimeException("This Toast was not created with Toast.makeText()");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "D9E8679815944C5B89F305CDC2FBAD3D", hash_generated_method = "F556B20E007842B92ED86508184E1CF6")
    static private INotificationManager getService() {
        if (sService != null) {
            return sService;
        }
        sService = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        return sService;
    }

    
    private static class TN extends ITransientNotification.Stub {
        final Runnable mShow = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "44EABCAA91D08F4C06482A1ED1EE7668", hash_generated_method = "A8E81C4419DF17AF316342D3AF5A56BC")
            @DSModeled(DSC.SAFE)
            public void run() {
                handleShow();
                // ---------- Original Method ----------
                //handleShow();
            }

            
}; //Transformed anonymous class
        final Runnable mHide = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "E71A75E071185259CF3C7ACA95EB5B7E", hash_generated_method = "36C75EFCCF7ACFAD34735FD834556D0D")
            @DSModeled(DSC.SAFE)
            public void run() {
                handleHide();
                mNextView = null;
                // ---------- Original Method ----------
                //handleHide();
                //mNextView = null;
            }

            
}; //Transformed anonymous class
        private final WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
        final Handler mHandler = new Handler();
        int mGravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        int mX, mY;
        float mHorizontalMargin;
        float mVerticalMargin;
        View mView;
        View mNextView;
        WindowManagerImpl mWM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.232 -0400", hash_original_method = "41B653C614D176194B8FC12B04D74B1D", hash_generated_method = "CE94C2F18DB695CA343E32DD2198528E")
        @DSModeled(DSC.SAFE)
         TN() {
            final WindowManager.LayoutParams params;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.233 -0400", hash_original_method = "3E96BAE0A73C07217EE9E69C0532B078", hash_generated_method = "CDD12CA89556801E769118E8A072956A")
        @DSModeled(DSC.SAFE)
        public void show() {
            mHandler.post(mShow);
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "SHOW: " + this);
            //mHandler.post(mShow);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.233 -0400", hash_original_method = "FE787FFB2514635467B163AE42817C6A", hash_generated_method = "659FFF3EBD3AAE12B723B47489382220")
        @DSModeled(DSC.SAFE)
        public void hide() {
            mHandler.post(mHide);
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "HIDE: " + this);
            //mHandler.post(mHide);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.233 -0400", hash_original_method = "98FF4DE105C724C8A8B16C9823509AFE", hash_generated_method = "69EDF458DF4D67AD8765E857FD791129")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleShow() {
            {
                handleHide();
                mView = mNextView;
                mWM = WindowManagerImpl.getDefault();
                final int gravity;
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
                    boolean var343900A41CC12F4354B7979405515384_726511831 = (mView.getParent() != null);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.233 -0400", hash_original_method = "D907D354027470BBEF302644D06948FD", hash_generated_method = "AE5AE87A7DCB6371879611C1E0FDA9AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void trySendAccessibilityEvent() {
            AccessibilityManager accessibilityManager;
            accessibilityManager = AccessibilityManager.getInstance(mView.getContext());
            {
                boolean var08EDE530C2FAA323754F9BC061A1BF41_2031659172 = (!accessibilityManager.isEnabled());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.233 -0400", hash_original_method = "20728D50D3469CDB24AC075F372999DE", hash_generated_method = "159331096A6274DE9AF1B547FE6CA4FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleHide() {
            {
                {
                    boolean var343900A41CC12F4354B7979405515384_661657776 = (mView.getParent() != null);
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


    
}


