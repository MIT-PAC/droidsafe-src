package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.964 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.964 -0400", hash_original_field = "A60F5180B22F6E5F19E5F083AF1E3B9C", hash_generated_field = "9FD3A39830EF0DBA4B8238391B28165D")

    TN mTN;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.964 -0400", hash_original_field = "25395741BFE51A7D136A5C7109AAD2D8", hash_generated_field = "BC345057CF9CBE8611DA24E477E3EC27")

    int mDuration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.964 -0400", hash_original_field = "BE0E61D34731712A85B6DF50B44906B0", hash_generated_field = "03D31907A1E7C016AB4113CE084AA49B")

    View mNextView;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.964 -0400", hash_original_method = "2A3FE9273E86BBACFA2AB5C5898C3146", hash_generated_method = "04A913AEB2170F506F817368C7F98503")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.965 -0400", hash_original_method = "EBD8B8572362DD92CF984D93DE6E4FF9", hash_generated_method = "BDA097CA89C7D0AA7419CDE84DFA6D71")
    public void show() {
        if(mNextView == null)        
        {
            RuntimeException varBA45B991E5FDF60526FD75B873E0DD10_1316605316 = new RuntimeException("setView must have been called");
            varBA45B991E5FDF60526FD75B873E0DD10_1316605316.addTaint(taint);
            throw varBA45B991E5FDF60526FD75B873E0DD10_1316605316;
        } //End block
        INotificationManager service = getService();
        String pkg = mContext.getPackageName();
        TN tn = mTN;
        tn.mNextView = mNextView;
        try 
        {
            service.enqueueToast(pkg, tn, mDuration);
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.966 -0400", hash_original_method = "905E110A9D66070AD259EFE2B60EBDFA", hash_generated_method = "5E755949284AFD2F0E09AB46034EB948")
    public void cancel() {
        mTN.hide();
        // ---------- Original Method ----------
        //mTN.hide();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.966 -0400", hash_original_method = "A152CAEDF892AE03EF7992276FE51073", hash_generated_method = "BEBF20515F3CF648B66FD299727BC65E")
    public void setView(View view) {
        mNextView = view;
        // ---------- Original Method ----------
        //mNextView = view;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.967 -0400", hash_original_method = "2CED2C577EBE287B42B9009F6CFBB820", hash_generated_method = "2E5DC6C87CF6C0667B38252D4E1827EF")
    public View getView() {
View varB9FC41AB8A20AAABE72BE5364175B5CC_1986367406 =         mNextView;
        varB9FC41AB8A20AAABE72BE5364175B5CC_1986367406.addTaint(taint);
        return varB9FC41AB8A20AAABE72BE5364175B5CC_1986367406;
        // ---------- Original Method ----------
        //return mNextView;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.968 -0400", hash_original_method = "CFB561A2B5CB71F6E4A1F9C7A12A3738", hash_generated_method = "F9C7C4EC13468CD19CD7C7E3AFD925F1")
    public void setDuration(int duration) {
        mDuration = duration;
        // ---------- Original Method ----------
        //mDuration = duration;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.968 -0400", hash_original_method = "C5CB9F23218BD0303C05492AF6E52DA2", hash_generated_method = "D69C64366D76A832B1C6F55082FCA2EF")
    public int getDuration() {
        int var25395741BFE51A7D136A5C7109AAD2D8_1682548789 = (mDuration);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497553636 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_497553636;
        // ---------- Original Method ----------
        //return mDuration;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.968 -0400", hash_original_method = "F425C47FB7437E78AF178C34F14EA79B", hash_generated_method = "F83E15EA06D82C079894A843F93CA717")
    public void setMargin(float horizontalMargin, float verticalMargin) {
        mTN.mHorizontalMargin = horizontalMargin;
        mTN.mVerticalMargin = verticalMargin;
        // ---------- Original Method ----------
        //mTN.mHorizontalMargin = horizontalMargin;
        //mTN.mVerticalMargin = verticalMargin;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.969 -0400", hash_original_method = "F7B8097D0A28A7644F4CAA36263A6BC5", hash_generated_method = "1E8421D93E2C974E621D22BF9248BDE0")
    public float getHorizontalMargin() {
        float varDF514617DE53B1EF9217C0FEF8317F13_1757300243 = (mTN.mHorizontalMargin);
                float var546ADE640B6EDFBC8A086EF31347E768_1057201222 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1057201222;
        // ---------- Original Method ----------
        //return mTN.mHorizontalMargin;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.969 -0400", hash_original_method = "08E3924FC925E4DE8E371EC71C6F9BB2", hash_generated_method = "2297E8D657FCAB00DC66DFC9CDA4EE25")
    public float getVerticalMargin() {
        float var7727757C0A1FC1ED9E73F93E7C322D59_508298795 = (mTN.mVerticalMargin);
                float var546ADE640B6EDFBC8A086EF31347E768_636434339 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_636434339;
        // ---------- Original Method ----------
        //return mTN.mVerticalMargin;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.970 -0400", hash_original_method = "0F798A7E93CD7957534C3E69090E738D", hash_generated_method = "C5E35E16B7D1472EF7531715FE78EC40")
    public void setGravity(int gravity, int xOffset, int yOffset) {
        mTN.mGravity = gravity;
        mTN.mX = xOffset;
        mTN.mY = yOffset;
        // ---------- Original Method ----------
        //mTN.mGravity = gravity;
        //mTN.mX = xOffset;
        //mTN.mY = yOffset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.970 -0400", hash_original_method = "2C9BD84752A31EC6F5E143771739878E", hash_generated_method = "0EF722FF7EA8A6D14B0AC289D385A31F")
    public int getGravity() {
        int var4E7026CC5A290E65914E34A9471C1765_1875393755 = (mTN.mGravity);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923581180 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1923581180;
        // ---------- Original Method ----------
        //return mTN.mGravity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.971 -0400", hash_original_method = "2AE943B633C6B771A3DBDC9830EE282D", hash_generated_method = "C05BB7A36A589AB1FA32377E53149E4B")
    public int getXOffset() {
        int varBD97F6BD1F2018E407E89BCB4E9D862C_269831318 = (mTN.mX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492889869 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1492889869;
        // ---------- Original Method ----------
        //return mTN.mX;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.971 -0400", hash_original_method = "3212505834221ECE93D6F08E5BDF4AC5", hash_generated_method = "B447EDB09BAF139FE391104954352264")
    public int getYOffset() {
        int varF71F6618D90D3064567B08C6118A822C_1373646323 = (mTN.mY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955071085 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955071085;
        // ---------- Original Method ----------
        //return mTN.mY;
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
    public static Toast makeText(Context context, int resId, int duration) throws Resources.NotFoundException {
        return makeText(context, context.getResources().getText(resId), duration);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.973 -0400", hash_original_method = "FD3914B9295A9EB352EBE416E97ECCF2", hash_generated_method = "E882ED36A19594361178A72F7D2FB9D1")
    public void setText(int resId) {
        addTaint(resId);
        setText(mContext.getText(resId));
        // ---------- Original Method ----------
        //setText(mContext.getText(resId));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.974 -0400", hash_original_method = "75C0E785CBEB5D5B8434AF0D1C3897A8", hash_generated_method = "6C819C5E957A680327C5C24E0E0F9FCA")
    public void setText(CharSequence s) {
        addTaint(s.getTaint());
        if(mNextView == null)        
        {
            RuntimeException varDE59A63592C52FD4676C11A3A24C5EB3_231532957 = new RuntimeException("This Toast was not created with Toast.makeText()");
            varDE59A63592C52FD4676C11A3A24C5EB3_231532957.addTaint(taint);
            throw varDE59A63592C52FD4676C11A3A24C5EB3_231532957;
        } //End block
        TextView tv = (TextView) mNextView.findViewById(com.android.internal.R.id.message);
        if(tv == null)        
        {
            RuntimeException varDE59A63592C52FD4676C11A3A24C5EB3_210457368 = new RuntimeException("This Toast was not created with Toast.makeText()");
            varDE59A63592C52FD4676C11A3A24C5EB3_210457368.addTaint(taint);
            throw varDE59A63592C52FD4676C11A3A24C5EB3_210457368;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.205 -0400", hash_original_field = "61DCBB3696F6FA4BE5725088AFF4EB28", hash_generated_field = "F71043D044FFF46BC2D291E4F438AF96")

        final Runnable mShow = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.205 -0400", hash_original_method = "44EABCAA91D08F4C06482A1ED1EE7668", hash_generated_method = "C9938375C8B8C21D868647BA643A9E49")
            public void run() {
                handleShow();
                
                
            }

            
};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.205 -0400", hash_original_field = "4A991A7F26DC9B6186AFC4C4EB669FA3", hash_generated_field = "C98CC5362648325DCF49FF191C9CB55D")

        final Runnable mHide = new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:17.205 -0400", hash_original_method = "E71A75E071185259CF3C7ACA95EB5B7E", hash_generated_method = "49C08F8FDD2E9C240F65F014A25A620F")
            public void run() {
                handleHide();
                mNextView = null;
                
                
                
            }

            
};
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.975 -0400", hash_original_field = "A49B715DAD456F789D4DE84CB6B77BBB", hash_generated_field = "9D5A036E2B4B34FBB053D812B184F194")

        private final WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.975 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "26DE2B72977ADBD047A9853341F26F79")

        final Handler mHandler = new Handler();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.975 -0400", hash_original_field = "D823E5E364D84A8EA59B0380B053EF90", hash_generated_field = "DD23A9E22F530443036D30182A32A544")

        int mGravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.975 -0400", hash_original_field = "E47D03BC59EE2C8B3B45870BE85294FB", hash_generated_field = "E0802CA55986D756D3E3A834B7025711")

        int mX;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.975 -0400", hash_original_field = "29DA5B2B864236A2CCB25B548E8F5F0A", hash_generated_field = "C11B85C67D00215273BFDFFDFCE3FC28")

        int mY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.975 -0400", hash_original_field = "E1F6755A84A68EBC18BAD4F06FC5D16F", hash_generated_field = "959E8F46A9EA632A6B6E3D2CF78E0965")

        float mHorizontalMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.975 -0400", hash_original_field = "98193689CD8029EF466C4AB846FA22ED", hash_generated_field = "0453553E896378DC7255CD56DA183A0A")

        float mVerticalMargin;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.975 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

        View mView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.975 -0400", hash_original_field = "BE0E61D34731712A85B6DF50B44906B0", hash_generated_field = "03D31907A1E7C016AB4113CE084AA49B")

        View mNextView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.975 -0400", hash_original_field = "4FEDCF33DA439800CB483956AE637716", hash_generated_field = "3C3F603D5D48071B1A37F937EDC3827B")

        WindowManagerImpl mWM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.976 -0400", hash_original_method = "41B653C614D176194B8FC12B04D74B1D", hash_generated_method = "E327577FEE453D387B060A3B6BA4FEA2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.976 -0400", hash_original_method = "3E96BAE0A73C07217EE9E69C0532B078", hash_generated_method = "BB5D385BC3C8223150F4E4262DAAE933")
        public void show() {
            if(localLOGV){ }            mHandler.post(mShow);
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "SHOW: " + this);
            //mHandler.post(mShow);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.976 -0400", hash_original_method = "FE787FFB2514635467B163AE42817C6A", hash_generated_method = "40ECBFB62DE691BA597DB6DCC67A7515")
        public void hide() {
            if(localLOGV){ }            mHandler.post(mHide);
            // ---------- Original Method ----------
            //if (localLOGV) Log.v(TAG, "HIDE: " + this);
            //mHandler.post(mHide);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.977 -0400", hash_original_method = "98FF4DE105C724C8A8B16C9823509AFE", hash_generated_method = "525D64A0BC18150DC506029B28E703A6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.977 -0400", hash_original_method = "D907D354027470BBEF302644D06948FD", hash_generated_method = "77A17536CC0EA3BEEAF27FC774321779")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.978 -0400", hash_original_method = "20728D50D3469CDB24AC075F372999DE", hash_generated_method = "AA70D0752BF89D1DDB63FBCD9D7D350D")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.978 -0400", hash_original_field = "DB936AFD4B778E49E9B3A6F57F800F03", hash_generated_field = "F05B76D447AAFE870701AA37F27DA0B8")

    static final String TAG = "Toast";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.978 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "071B7B77A9473B9527F9198838C91D11")

    static final boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.978 -0400", hash_original_field = "8FBF92D1463F5FA9A8A8384E33669946", hash_generated_field = "DADE3EEB6C5391F63930F5C39F2A4C3E")

    public static final int LENGTH_SHORT = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.978 -0400", hash_original_field = "996063A1511532B6B8A7BDA1D054B8E2", hash_generated_field = "64F95B063A0FA537B7B8301601F6DA0E")

    public static final int LENGTH_LONG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:07.978 -0400", hash_original_field = "5B4BCAAF27A7649717520CAA43216111", hash_generated_field = "F81A4B790E53712C35BD5EDD5A7B2761")

    private static INotificationManager sService;
}

