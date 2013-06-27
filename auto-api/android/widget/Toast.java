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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.298 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.298 -0400", hash_original_field = "A60F5180B22F6E5F19E5F083AF1E3B9C", hash_generated_field = "9FD3A39830EF0DBA4B8238391B28165D")

    TN mTN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.298 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "BC345057CF9CBE8611DA24E477E3EC27")

    int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.298 -0400", hash_original_field = "BE0E61D34731712A85B6DF50B44906B0", hash_generated_field = "03D31907A1E7C016AB4113CE084AA49B")

    View mNextView;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.306 -0400", hash_original_method = "2A3FE9273E86BBACFA2AB5C5898C3146", hash_generated_method = "04A913AEB2170F506F817368C7F98503")
    public  Toast(Context context) {
        mContext = context;
        mTN = new TN();
        mTN.mY = context.getResources().getDimensionPixelSize(
                com.android.internal.R.dimen.toast_y_offset);
        // ---------- Original Method ----------
        //mContext = context;
        //mTN = new TN();
        //mTN.mY = context.getResources().getDimensionPixelSize(
                //com.android.internal.R.dimen.toast_y_offset);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.306 -0400", hash_original_method = "EBD8B8572362DD92CF984D93DE6E4FF9", hash_generated_method = "3BE8918CAD81CCFB746595A1EFA0AE41")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.307 -0400", hash_original_method = "905E110A9D66070AD259EFE2B60EBDFA", hash_generated_method = "5E755949284AFD2F0E09AB46034EB948")
    public void cancel() {
        mTN.hide();
        // ---------- Original Method ----------
        //mTN.hide();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.307 -0400", hash_original_method = "A152CAEDF892AE03EF7992276FE51073", hash_generated_method = "BEBF20515F3CF648B66FD299727BC65E")
    public void setView(View view) {
        mNextView = view;
        // ---------- Original Method ----------
        //mNextView = view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.307 -0400", hash_original_method = "2CED2C577EBE287B42B9009F6CFBB820", hash_generated_method = "7DF7C0257536A2258A8D27F035B59EF0")
    public View getView() {
        View varB4EAC82CA7396A68D541C85D26508E83_2101865081 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2101865081 = mNextView;
        varB4EAC82CA7396A68D541C85D26508E83_2101865081.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2101865081;
        // ---------- Original Method ----------
        //return mNextView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.319 -0400", hash_original_method = "CFB561A2B5CB71F6E4A1F9C7A12A3738", hash_generated_method = "F9C7C4EC13468CD19CD7C7E3AFD925F1")
    public void setDuration(int duration) {
        mDuration = duration;
        // ---------- Original Method ----------
        //mDuration = duration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.337 -0400", hash_original_method = "C5CB9F23218BD0303C05492AF6E52DA2", hash_generated_method = "9762FC0CDF0B48563614BDF3371D0E36")
    public int getDuration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_374847239 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_374847239;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.337 -0400", hash_original_method = "F425C47FB7437E78AF178C34F14EA79B", hash_generated_method = "F83E15EA06D82C079894A843F93CA717")
    public void setMargin(float horizontalMargin, float verticalMargin) {
        mTN.mHorizontalMargin = horizontalMargin;
        mTN.mVerticalMargin = verticalMargin;
        // ---------- Original Method ----------
        //mTN.mHorizontalMargin = horizontalMargin;
        //mTN.mVerticalMargin = verticalMargin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.337 -0400", hash_original_method = "F7B8097D0A28A7644F4CAA36263A6BC5", hash_generated_method = "EBCA59A2F6679EAE8E1AF74FFDB121B4")
    public float getHorizontalMargin() {
        float var546ADE640B6EDFBC8A086EF31347E768_1239936386 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1239936386;
        // ---------- Original Method ----------
        //return mTN.mHorizontalMargin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.338 -0400", hash_original_method = "08E3924FC925E4DE8E371EC71C6F9BB2", hash_generated_method = "D89EF1C5A3F7D3F7533D699A5B9B68E7")
    public float getVerticalMargin() {
        float var546ADE640B6EDFBC8A086EF31347E768_2022619571 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_2022619571;
        // ---------- Original Method ----------
        //return mTN.mVerticalMargin;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.338 -0400", hash_original_method = "0F798A7E93CD7957534C3E69090E738D", hash_generated_method = "C5E35E16B7D1472EF7531715FE78EC40")
    public void setGravity(int gravity, int xOffset, int yOffset) {
        mTN.mGravity = gravity;
        mTN.mX = xOffset;
        mTN.mY = yOffset;
        // ---------- Original Method ----------
        //mTN.mGravity = gravity;
        //mTN.mX = xOffset;
        //mTN.mY = yOffset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.338 -0400", hash_original_method = "2C9BD84752A31EC6F5E143771739878E", hash_generated_method = "E670115EB116FCAA38C4795B3FC6EFA3")
    public int getGravity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242538510 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1242538510;
        // ---------- Original Method ----------
        //return mTN.mGravity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.338 -0400", hash_original_method = "2AE943B633C6B771A3DBDC9830EE282D", hash_generated_method = "5BCA4173EC91F95AFADF98D30934CEB9")
    public int getXOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608162614 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_608162614;
        // ---------- Original Method ----------
        //return mTN.mX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.339 -0400", hash_original_method = "3212505834221ECE93D6F08E5BDF4AC5", hash_generated_method = "EE80EE7EF5284A7751710C1F67C041CF")
    public int getYOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135396353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2135396353;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.339 -0400", hash_original_method = "FD3914B9295A9EB352EBE416E97ECCF2", hash_generated_method = "B1E626708B182B1A5A89AB5D8ED65930")
    public void setText(int resId) {
        setText(mContext.getText(resId));
        addTaint(resId);
        // ---------- Original Method ----------
        //setText(mContext.getText(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.340 -0400", hash_original_method = "75C0E785CBEB5D5B8434AF0D1C3897A8", hash_generated_method = "6897497199781C04D02BA12C5DC7CBE2")
    public void setText(CharSequence s) {
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("This Toast was not created with Toast.makeText()");
        } //End block
        TextView tv;
        tv = (TextView) mNextView.findViewById(com.android.internal.R.id.message);
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("This Toast was not created with Toast.makeText()");
        } //End block
        tv.setText(s);
        addTaint(s.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.340 -0400", hash_original_field = "61DCBB3696F6FA4BE5725088AFF4EB28", hash_generated_field = "86E851BE173F8AB47329AC06A661F6BA")

        Runnable mShow = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.340 -0400", hash_original_method = "44EABCAA91D08F4C06482A1ED1EE7668", hash_generated_method = "C9938375C8B8C21D868647BA643A9E49")
            public void run() {
                handleShow();
                // ---------- Original Method ----------
                //handleShow();
            }

            
};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "4A991A7F26DC9B6186AFC4C4EB669FA3", hash_generated_field = "37EB54CCA1ACA12AB9DF0F7A988EAE0C")

        Runnable mHide = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_method = "E71A75E071185259CF3C7ACA95EB5B7E", hash_generated_method = "49C08F8FDD2E9C240F65F014A25A620F")
            public void run() {
                handleHide();
                mNextView = null;
                // ---------- Original Method ----------
                //handleHide();
                //mNextView = null;
            }

            
};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "A49B715DAD456F789D4DE84CB6B77BBB", hash_generated_field = "889111E756DDF3D89FA0C36B018C4BD7")

        private WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "AD9C3D1E48D73BF1547D53C4C62401B2")

        Handler mHandler = new Handler();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "D823E5E364D84A8EA59B0380B053EF90", hash_generated_field = "DD23A9E22F530443036D30182A32A544")

        int mGravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "E1F6755A84A68EBC18BAD4F06FC5D16F", hash_generated_field = "959E8F46A9EA632A6B6E3D2CF78E0965")

        float mHorizontalMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "98193689CD8029EF466C4AB846FA22ED", hash_generated_field = "0453553E896378DC7255CD56DA183A0A")

        float mVerticalMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

        View mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "BE0E61D34731712A85B6DF50B44906B0", hash_generated_field = "03D31907A1E7C016AB4113CE084AA49B")

        View mNextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.341 -0400", hash_original_field = "4FEDCF33DA439800CB483956AE637716", hash_generated_field = "3C3F603D5D48071B1A37F937EDC3827B")

        WindowManagerImpl mWM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.402 -0400", hash_original_method = "41B653C614D176194B8FC12B04D74B1D", hash_generated_method = "5D2AB94EA13B478627376DE5AF67C9AE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.404 -0400", hash_original_method = "3E96BAE0A73C07217EE9E69C0532B078", hash_generated_method = "DB21D5FEBA237BDEFB3DEAADE3B14154")
        public void show() {
            mHandler.post(mShow);
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "SHOW: " + this);
            //mHandler.post(mShow);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.404 -0400", hash_original_method = "FE787FFB2514635467B163AE42817C6A", hash_generated_method = "1CA4F3CC11777FC85B713964648F2E8A")
        public void hide() {
            mHandler.post(mHide);
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "HIDE: " + this);
            //mHandler.post(mHide);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.405 -0400", hash_original_method = "98FF4DE105C724C8A8B16C9823509AFE", hash_generated_method = "6CEB052B4D2EB7EA4F8B40534BF1C262")
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
                    boolean var343900A41CC12F4354B7979405515384_680081018 = (mView.getParent() != null);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.405 -0400", hash_original_method = "D907D354027470BBEF302644D06948FD", hash_generated_method = "AC86E5C1E508EEA605DC2C30F52BB47D")
        private void trySendAccessibilityEvent() {
            AccessibilityManager accessibilityManager;
            accessibilityManager = AccessibilityManager.getInstance(mView.getContext());
            {
                boolean var08EDE530C2FAA323754F9BC061A1BF41_2084835715 = (!accessibilityManager.isEnabled());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.406 -0400", hash_original_method = "20728D50D3469CDB24AC075F372999DE", hash_generated_method = "3FB76EBDE6D2A4ED398FDB616C57BCAE")
        public void handleHide() {
            {
                {
                    boolean var343900A41CC12F4354B7979405515384_1478950774 = (mView.getParent() != null);
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.406 -0400", hash_original_field = "DB936AFD4B778E49E9B3A6F57F800F03", hash_generated_field = "369EA51E397DFB70E3831FD30846924C")

    static String TAG = "Toast";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.406 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "28F5FC4643EA692F03C0CC4366480592")

    static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.406 -0400", hash_original_field = "8FBF92D1463F5FA9A8A8384E33669946", hash_generated_field = "DADE3EEB6C5391F63930F5C39F2A4C3E")

    public static final int LENGTH_SHORT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.406 -0400", hash_original_field = "996063A1511532B6B8A7BDA1D054B8E2", hash_generated_field = "64F95B063A0FA537B7B8301601F6DA0E")

    public static final int LENGTH_LONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:10.406 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "F81A4B790E53712C35BD5EDD5A7B2761")

    private static INotificationManager sService;
}

