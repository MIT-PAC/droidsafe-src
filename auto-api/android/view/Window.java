package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Application;
import android.content.Context;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemProperties;
import android.util.Slog;
import android.view.accessibility.AccessibilityEvent;

public abstract class Window {
    private Context mContext;
    private TypedArray mWindowStyle;
    private Callback mCallback;
    private WindowManager mWindowManager;
    private IBinder mAppToken;
    private String mAppName;
    private Window mContainer;
    private Window mActiveChild;
    private boolean mIsActive = false;
    private boolean mHasChildren = false;
    private boolean mCloseOnTouchOutside = false;
    private boolean mSetCloseOnTouchOutside = false;
    private int mForcedWindowFlags = 0;
    private int mFeatures = DEFAULT_FEATURES;
    private int mLocalFeatures = DEFAULT_FEATURES;
    private boolean mHaveWindowFormat = false;
    private boolean mHaveDimAmount = false;
    private int mDefaultWindowFormat = PixelFormat.OPAQUE;
    private boolean mHasSoftInputMode = false;
    private boolean mDestroyed;
    private WindowManager.LayoutParams mWindowAttributes =
        new WindowManager.LayoutParams();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.678 -0400", hash_original_method = "50ED378DEE1AF31F505AB3EFDADA9166", hash_generated_method = "CE39A4476D5DDED4354C79DD31296E88")
    @DSModeled(DSC.SAFE)
    public Window(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.678 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "BE5638BA5602E1CB98C94695D5EEE971")
    @DSModeled(DSC.SAFE)
    public final Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.678 -0400", hash_original_method = "F2F0D9C02E357CB8D6CDE50C6B929622", hash_generated_method = "C970B59BB299519D180EC95727A6C04F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final TypedArray getWindowStyle() {
        {
            {
                mWindowStyle = mContext.obtainStyledAttributes(
                        com.android.internal.R.styleable.Window);
            } //End block
        } //End block
        return (TypedArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mWindowStyle == null) {
                //mWindowStyle = mContext.obtainStyledAttributes(
                        //com.android.internal.R.styleable.Window);
            //}
            //return mWindowStyle;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.678 -0400", hash_original_method = "8852F0C837DC7060948A60A90C2A9042", hash_generated_method = "6F15E6E58CF094273D01FEB05B3B6D10")
    @DSModeled(DSC.SAFE)
    public void setContainer(Window container) {
        dsTaint.addTaint(container.dsTaint);
        {
            mFeatures |= 1<<FEATURE_NO_TITLE;
            mLocalFeatures |= 1<<FEATURE_NO_TITLE;
            container.mHasChildren = true;
        } //End block
        // ---------- Original Method ----------
        //mContainer = container;
        //if (container != null) {
            //mFeatures |= 1<<FEATURE_NO_TITLE;
            //mLocalFeatures |= 1<<FEATURE_NO_TITLE;
            //container.mHasChildren = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.679 -0400", hash_original_method = "DCCDF946CE22DD9064205FD95E96DECD", hash_generated_method = "9562C21C304BB7F46BB7D0EC00BC5A08")
    @DSModeled(DSC.SAFE)
    public final Window getContainer() {
        return (Window)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContainer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.679 -0400", hash_original_method = "E436A7964E92BE677F4D553F3B295F27", hash_generated_method = "7CA6CC21882FD9F388270F07610B8158")
    @DSModeled(DSC.SAFE)
    public final boolean hasChildren() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasChildren;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.679 -0400", hash_original_method = "66C6B9EE658776AAE6ED0A2EE9CF8E48", hash_generated_method = "592FCE4D1921959BBFF73FDA835F18F9")
    @DSModeled(DSC.SAFE)
    public final void destroy() {
        mDestroyed = true;
        // ---------- Original Method ----------
        //mDestroyed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.679 -0400", hash_original_method = "36E279B4F2F5FC702C91E645725B1821", hash_generated_method = "A80FB86896419CE8288B28B08520820D")
    @DSModeled(DSC.SAFE)
    public final boolean isDestroyed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDestroyed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.679 -0400", hash_original_method = "49C37E5CFC1C233E6DF0E927E49CABF4", hash_generated_method = "757F5EE219B648D289198258B1C708DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWindowManager(WindowManager wm, IBinder appToken, String appName) {
        dsTaint.addTaint(appName);
        dsTaint.addTaint(appToken.dsTaint);
        dsTaint.addTaint(wm.dsTaint);
        setWindowManager(wm, appToken, appName, false);
        // ---------- Original Method ----------
        //setWindowManager(wm, appToken, appName, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.680 -0400", hash_original_method = "07A6DAE3F5C8016383AB9A64DB3A39A3", hash_generated_method = "3D2B92CD605DB9CBDE69E02964C9E6AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWindowManager(WindowManager wm, IBinder appToken, String appName,
            boolean hardwareAccelerated) {
        dsTaint.addTaint(appName);
        dsTaint.addTaint(appToken.dsTaint);
        dsTaint.addTaint(wm.dsTaint);
        dsTaint.addTaint(hardwareAccelerated);
        {
            wm = WindowManagerImpl.getDefault();
        } //End block
        mWindowManager = new LocalWindowManager(wm, hardwareAccelerated);
        // ---------- Original Method ----------
        //mAppToken = appToken;
        //mAppName = appName;
        //if (wm == null) {
            //wm = WindowManagerImpl.getDefault();
        //}
        //mWindowManager = new LocalWindowManager(wm, hardwareAccelerated);
    }

    
        static CompatibilityInfoHolder getCompatInfo(Context context) {
        Application app = (Application)context.getApplicationContext();
        return app != null ? app.mLoadedApk.mCompatibilityInfo : new CompatibilityInfoHolder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.680 -0400", hash_original_method = "1DCFADD2C71F0E408EA049F81A8ACDED", hash_generated_method = "B37848079873378B2DC662CF9FE27432")
    @DSModeled(DSC.SAFE)
    public WindowManager getWindowManager() {
        return (WindowManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindowManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.680 -0400", hash_original_method = "DD1DEB01F922CA329B6B6BD86F551D46", hash_generated_method = "DAED7684C342C2FE6121C7371BD77BFF")
    @DSModeled(DSC.SAFE)
    public void setCallback(Callback callback) {
        dsTaint.addTaint(callback.dsTaint);
        // ---------- Original Method ----------
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.680 -0400", hash_original_method = "F07002384A5D5C29596645EE02BC1965", hash_generated_method = "D3F4997A0A9316F58C4381FDF97769F8")
    @DSModeled(DSC.SAFE)
    public final Callback getCallback() {
        return (Callback)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCallback;
    }

    
    public abstract void takeSurface(SurfaceHolder.Callback2 callback);

    
    public abstract void takeInputQueue(InputQueue.Callback callback);

    
    public abstract boolean isFloating();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.681 -0400", hash_original_method = "BDF4A9191EC276CB59743DF4E4B8A744", hash_generated_method = "36F8B7256AC3D2EBCA3440C0C35FDA92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLayout(int width, int height) {
        dsTaint.addTaint(height);
        dsTaint.addTaint(width);
        WindowManager.LayoutParams attrs;
        attrs = getAttributes();
        attrs.width = width;
        attrs.height = height;
        {
            mCallback.onWindowAttributesChanged(attrs);
        } //End block
        // ---------- Original Method ----------
        //final WindowManager.LayoutParams attrs = getAttributes();
        //attrs.width = width;
        //attrs.height = height;
        //if (mCallback != null) {
            //mCallback.onWindowAttributesChanged(attrs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.681 -0400", hash_original_method = "76A69B8FD04E6A39E52E254D3C51CA75", hash_generated_method = "1896A9AAD75D5DAF671D69EC56712BDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setGravity(int gravity) {
        dsTaint.addTaint(gravity);
        WindowManager.LayoutParams attrs;
        attrs = getAttributes();
        attrs.gravity = gravity;
        {
            mCallback.onWindowAttributesChanged(attrs);
        } //End block
        // ---------- Original Method ----------
        //final WindowManager.LayoutParams attrs = getAttributes();
        //attrs.gravity = gravity;
        //if (mCallback != null) {
            //mCallback.onWindowAttributesChanged(attrs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.681 -0400", hash_original_method = "07612A9950A1C7129B1F4B699CE0FA52", hash_generated_method = "222A359EE2F1F6A708DD06D7DE8245C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setType(int type) {
        dsTaint.addTaint(type);
        WindowManager.LayoutParams attrs;
        attrs = getAttributes();
        attrs.type = type;
        {
            mCallback.onWindowAttributesChanged(attrs);
        } //End block
        // ---------- Original Method ----------
        //final WindowManager.LayoutParams attrs = getAttributes();
        //attrs.type = type;
        //if (mCallback != null) {
            //mCallback.onWindowAttributesChanged(attrs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.682 -0400", hash_original_method = "ADD82385ADE43D8CE9305C2F63E34252", hash_generated_method = "C5E534EF8B671ADF94CA7EADF96D4E93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFormat(int format) {
        dsTaint.addTaint(format);
        WindowManager.LayoutParams attrs;
        attrs = getAttributes();
        {
            attrs.format = format;
            mHaveWindowFormat = true;
        } //End block
        {
            attrs.format = mDefaultWindowFormat;
            mHaveWindowFormat = false;
        } //End block
        {
            mCallback.onWindowAttributesChanged(attrs);
        } //End block
        // ---------- Original Method ----------
        //final WindowManager.LayoutParams attrs = getAttributes();
        //if (format != PixelFormat.UNKNOWN) {
            //attrs.format = format;
            //mHaveWindowFormat = true;
        //} else {
            //attrs.format = mDefaultWindowFormat;
            //mHaveWindowFormat = false;
        //}
        //if (mCallback != null) {
            //mCallback.onWindowAttributesChanged(attrs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.682 -0400", hash_original_method = "4617417E681280CCA3448C5B912BCD7D", hash_generated_method = "C40D697F7048B714D9693A6D61671C48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWindowAnimations(int resId) {
        dsTaint.addTaint(resId);
        WindowManager.LayoutParams attrs;
        attrs = getAttributes();
        attrs.windowAnimations = resId;
        {
            mCallback.onWindowAttributesChanged(attrs);
        } //End block
        // ---------- Original Method ----------
        //final WindowManager.LayoutParams attrs = getAttributes();
        //attrs.windowAnimations = resId;
        //if (mCallback != null) {
            //mCallback.onWindowAttributesChanged(attrs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.682 -0400", hash_original_method = "C4620B459A4A0F6C7D91CF9A478EC82D", hash_generated_method = "AF8716780B239094D0E628A6880E5910")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSoftInputMode(int mode) {
        dsTaint.addTaint(mode);
        WindowManager.LayoutParams attrs;
        attrs = getAttributes();
        {
            attrs.softInputMode = mode;
            mHasSoftInputMode = true;
        } //End block
        {
            mHasSoftInputMode = false;
        } //End block
        {
            mCallback.onWindowAttributesChanged(attrs);
        } //End block
        // ---------- Original Method ----------
        //final WindowManager.LayoutParams attrs = getAttributes();
        //if (mode != WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED) {
            //attrs.softInputMode = mode;
            //mHasSoftInputMode = true;
        //} else {
            //mHasSoftInputMode = false;
        //}
        //if (mCallback != null) {
            //mCallback.onWindowAttributesChanged(attrs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.682 -0400", hash_original_method = "0498A767AE3286E2ACD9E77A8750E86F", hash_generated_method = "F94592AD1515A4E8715F75FC1492C9D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFlags(int flags) {
        dsTaint.addTaint(flags);
        setFlags(flags, flags);
        // ---------- Original Method ----------
        //setFlags(flags, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.682 -0400", hash_original_method = "1B1BB2C51A9E558BB4222C67BD342AB1", hash_generated_method = "2E93C80CF9F59C9912CD990FCD09BB79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearFlags(int flags) {
        dsTaint.addTaint(flags);
        setFlags(0, flags);
        // ---------- Original Method ----------
        //setFlags(0, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.683 -0400", hash_original_method = "40E42D383A45AE28D15E52653F68CBD5", hash_generated_method = "F802B39059EE223D4029B6A944B11D02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setFlags(int flags, int mask) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(mask);
        WindowManager.LayoutParams attrs;
        attrs = getAttributes();
        attrs.flags = (attrs.flags&~mask) | (flags&mask);
        {
            attrs.privateFlags |= WindowManager.LayoutParams.PRIVATE_FLAG_SET_NEEDS_MENU_KEY;
        } //End block
        {
            mCallback.onWindowAttributesChanged(attrs);
        } //End block
        // ---------- Original Method ----------
        //final WindowManager.LayoutParams attrs = getAttributes();
        //attrs.flags = (attrs.flags&~mask) | (flags&mask);
        //if ((mask&WindowManager.LayoutParams.FLAG_NEEDS_MENU_KEY) != 0) {
            //attrs.privateFlags |= WindowManager.LayoutParams.PRIVATE_FLAG_SET_NEEDS_MENU_KEY;
        //}
        //mForcedWindowFlags |= mask;
        //if (mCallback != null) {
            //mCallback.onWindowAttributesChanged(attrs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.683 -0400", hash_original_method = "9455DB63259C6955368CE857C592C952", hash_generated_method = "6BF15FCE4A22BAA1A0C6EA547AB6F27B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDimAmount(float amount) {
        dsTaint.addTaint(amount);
        WindowManager.LayoutParams attrs;
        attrs = getAttributes();
        attrs.dimAmount = amount;
        mHaveDimAmount = true;
        {
            mCallback.onWindowAttributesChanged(attrs);
        } //End block
        // ---------- Original Method ----------
        //final WindowManager.LayoutParams attrs = getAttributes();
        //attrs.dimAmount = amount;
        //mHaveDimAmount = true;
        //if (mCallback != null) {
            //mCallback.onWindowAttributesChanged(attrs);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.683 -0400", hash_original_method = "66B5C1599B3320A30790CC9FF26FC996", hash_generated_method = "B1B2788A8B9FDD6B507AA720C5DC57CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAttributes(WindowManager.LayoutParams a) {
        dsTaint.addTaint(a.dsTaint);
        mWindowAttributes.copyFrom(a);
        {
            mCallback.onWindowAttributesChanged(mWindowAttributes);
        } //End block
        // ---------- Original Method ----------
        //mWindowAttributes.copyFrom(a);
        //if (mCallback != null) {
            //mCallback.onWindowAttributesChanged(mWindowAttributes);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.683 -0400", hash_original_method = "1740BD4A684D4859A9304C42BFBB0628", hash_generated_method = "5C86A526E93CFD482627F3ED5440EBFA")
    @DSModeled(DSC.SAFE)
    public final WindowManager.LayoutParams getAttributes() {
        return (WindowManager.LayoutParams)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mWindowAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.683 -0400", hash_original_method = "78D10AE7087B6FEDF7B8FA7D71B4D366", hash_generated_method = "1794F7ED0DAE6CA15B5B1462FCD7BFDE")
    @DSModeled(DSC.SAFE)
    protected final int getForcedWindowFlags() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mForcedWindowFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.684 -0400", hash_original_method = "3FB6B9359B05585EE87D1E296E0BA56E", hash_generated_method = "07261E9EDFD23A9915F2BC4FC4F16D9F")
    @DSModeled(DSC.SAFE)
    protected final boolean hasSoftInputMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHasSoftInputMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.684 -0400", hash_original_method = "A665A75B43AC6644089B2FAB21289091", hash_generated_method = "5AEA6C6539AF5175F0A375A3F7F74C79")
    @DSModeled(DSC.SAFE)
    public void setCloseOnTouchOutside(boolean close) {
        dsTaint.addTaint(close);
        mSetCloseOnTouchOutside = true;
        // ---------- Original Method ----------
        //mCloseOnTouchOutside = close;
        //mSetCloseOnTouchOutside = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.684 -0400", hash_original_method = "585D2A4E90DC505694C50AFA60811C60", hash_generated_method = "90D8DD2C7BBCF26E3293E1B966B1C0B1")
    @DSModeled(DSC.SAFE)
    public void setCloseOnTouchOutsideIfNotSet(boolean close) {
        dsTaint.addTaint(close);
        {
            mSetCloseOnTouchOutside = true;
        } //End block
        // ---------- Original Method ----------
        //if (!mSetCloseOnTouchOutside) {
            //mCloseOnTouchOutside = close;
            //mSetCloseOnTouchOutside = true;
        //}
    }

    
    public abstract void alwaysReadCloseOnTouchAttr();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.685 -0400", hash_original_method = "8CE0B3F5C0E964B12FFD1AA84260C5B9", hash_generated_method = "7EA6CC5F8757ABA785E0DAE7F7C6A4BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean shouldCloseOnTouch(Context context, MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        {
            boolean var61852665015A4DA2650F638F2B403163_1772094742 = (mCloseOnTouchOutside && event.getAction() == MotionEvent.ACTION_DOWN
                && isOutOfBounds(context, event) && peekDecorView() != null);
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mCloseOnTouchOutside && event.getAction() == MotionEvent.ACTION_DOWN
                //&& isOutOfBounds(context, event) && peekDecorView() != null) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.685 -0400", hash_original_method = "AB4AFCB92A037D63668D3D8B793C0712", hash_generated_method = "18F94AC559F0EDF824CC932F8BD82C6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isOutOfBounds(Context context, MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        int x;
        x = (int) event.getX();
        int y;
        y = (int) event.getY();
        int slop;
        slop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        View decorView;
        decorView = getDecorView();
        boolean varBB8FA6DF4DF465DE0F30D38A2C9954DA_165902729 = ((x < -slop) || (y < -slop)
                || (x > (decorView.getWidth()+slop))
                || (y > (decorView.getHeight()+slop)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int x = (int) event.getX();
        //final int y = (int) event.getY();
        //final int slop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        //final View decorView = getDecorView();
        //return (x < -slop) || (y < -slop)
                //|| (x > (decorView.getWidth()+slop))
                //|| (y > (decorView.getHeight()+slop));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.685 -0400", hash_original_method = "56D6FF40FC7BCA35CBE5379E385EA86C", hash_generated_method = "0A963D71C5A7C26876908EEE0EC53F50")
    @DSModeled(DSC.SAFE)
    public boolean requestFeature(int featureId) {
        dsTaint.addTaint(featureId);
        int flag;
        flag = 1<<featureId;
        mFeatures |= flag;
        mLocalFeatures |= mContainer != null ? (flag&~mContainer.mFeatures) : flag;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //final int flag = 1<<featureId;
        //mFeatures |= flag;
        //mLocalFeatures |= mContainer != null ? (flag&~mContainer.mFeatures) : flag;
        //return (mFeatures&flag) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.686 -0400", hash_original_method = "24AB1A47189F5640F802580999D5EF0B", hash_generated_method = "EFADBFBDFB3AF61EC2637708BEB34D78")
    @DSModeled(DSC.SAFE)
    protected void removeFeature(int featureId) {
        dsTaint.addTaint(featureId);
        int flag;
        flag = 1<<featureId;
        mFeatures &= ~flag;
        mLocalFeatures &= ~(mContainer != null ? (flag&~mContainer.mFeatures) : flag);
        // ---------- Original Method ----------
        //final int flag = 1<<featureId;
        //mFeatures &= ~flag;
        //mLocalFeatures &= ~(mContainer != null ? (flag&~mContainer.mFeatures) : flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.686 -0400", hash_original_method = "B5CCAAF5805277DBB8CBB8283B5C5952", hash_generated_method = "0B4F368A60FA6E7CAE9973E5AC825355")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void makeActive() {
        {
            {
                mContainer.mActiveChild.mIsActive = false;
            } //End block
            mContainer.mActiveChild = this;
        } //End block
        mIsActive = true;
        onActive();
        // ---------- Original Method ----------
        //if (mContainer != null) {
            //if (mContainer.mActiveChild != null) {
                //mContainer.mActiveChild.mIsActive = false;
            //}
            //mContainer.mActiveChild = this;
        //}
        //mIsActive = true;
        //onActive();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.686 -0400", hash_original_method = "825B8CF70F64E49AF2D9884D4F1141F6", hash_generated_method = "BA5DA611360776D8ED2D10FCC2457AC4")
    @DSModeled(DSC.SAFE)
    public final boolean isActive() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsActive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.686 -0400", hash_original_method = "06392AB1384FAD789566489ED7477D15", hash_generated_method = "568E196B1B05C9CF3E1F7A3A5A0E9F7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View findViewById(int id) {
        dsTaint.addTaint(id);
        View varA94BB26CB8F53D92DAF8968FACFC5247_1302000244 = (getDecorView().findViewById(id));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getDecorView().findViewById(id);
    }

    
    public abstract void setContentView(int layoutResID);

    
    public abstract void setContentView(View view);

    
    public abstract void setContentView(View view, ViewGroup.LayoutParams params);

    
    public abstract void addContentView(View view, ViewGroup.LayoutParams params);

    
    public abstract View getCurrentFocus();

    
    public abstract LayoutInflater getLayoutInflater();

    
    public abstract void setTitle(CharSequence title);

    
    public abstract void setTitleColor(int textColor);

    
    public abstract void openPanel(int featureId, KeyEvent event);

    
    public abstract void closePanel(int featureId);

    
    public abstract void togglePanel(int featureId, KeyEvent event);

    
    public abstract void invalidatePanelMenu(int featureId);

    
    public abstract boolean performPanelShortcut(int featureId,
                                                 int keyCode,
                                                 KeyEvent event,
                                                 int flags);

    
    public abstract boolean performPanelIdentifierAction(int featureId,
                                                 int id,
                                                 int flags);

    
    public abstract void closeAllPanels();

    
    public abstract boolean performContextMenuIdentifierAction(int id, int flags);

    
    public abstract void onConfigurationChanged(Configuration newConfig);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.688 -0400", hash_original_method = "AFC383C5A753BE0283DE80727207DE11", hash_generated_method = "20474537654FCD2D27B85AB5CD17246F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBackgroundDrawableResource(int resid) {
        dsTaint.addTaint(resid);
        setBackgroundDrawable(mContext.getResources().getDrawable(resid));
        // ---------- Original Method ----------
        //setBackgroundDrawable(mContext.getResources().getDrawable(resid));
    }

    
    public abstract void setBackgroundDrawable(Drawable drawable);

    
    public abstract void setFeatureDrawableResource(int featureId, int resId);

    
    public abstract void setFeatureDrawableUri(int featureId, Uri uri);

    
    public abstract void setFeatureDrawable(int featureId, Drawable drawable);

    
    public abstract void setFeatureDrawableAlpha(int featureId, int alpha);

    
    public abstract void setFeatureInt(int featureId, int value);

    
    public abstract void takeKeyEvents(boolean get);

    
    public abstract boolean superDispatchKeyEvent(KeyEvent event);

    
    public abstract boolean superDispatchKeyShortcutEvent(KeyEvent event);

    
    public abstract boolean superDispatchTouchEvent(MotionEvent event);

    
    public abstract boolean superDispatchTrackballEvent(MotionEvent event);

    
    public abstract boolean superDispatchGenericMotionEvent(MotionEvent event);

    
    public abstract View getDecorView();

    
    public abstract View peekDecorView();

    
    public abstract Bundle saveHierarchyState();

    
    public abstract void restoreHierarchyState(Bundle savedInstanceState);

    
    protected abstract void onActive();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.690 -0400", hash_original_method = "201C8696C96B5CE4C022F78574069483", hash_generated_method = "91084A87C41E988D552E5F1C92A9F3D6")
    @DSModeled(DSC.SAFE)
    protected final int getFeatures() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFeatures;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.690 -0400", hash_original_method = "5A085FB22E39DFD08969173C82283E9B", hash_generated_method = "A52D14C2EF523C05A67769417709048E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasFeature(int feature) {
        dsTaint.addTaint(feature);
        boolean varA717CAC4D1FC0A0FC3A35CB28E72A65C_21246792 = ((getFeatures() & (1 << feature)) != 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (getFeatures() & (1 << feature)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.691 -0400", hash_original_method = "D46E90B97B876B97E16E92A5FEA18EB3", hash_generated_method = "FFA496C36112EC6BA73D845A7383541C")
    @DSModeled(DSC.SAFE)
    protected final int getLocalFeatures() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mLocalFeatures;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.691 -0400", hash_original_method = "439CF6A84E0EE9568E72DFCB057259B4", hash_generated_method = "67C75567AE4136BF89095F22A9FAD1F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setDefaultWindowFormat(int format) {
        dsTaint.addTaint(format);
        {
            WindowManager.LayoutParams attrs;
            attrs = getAttributes();
            attrs.format = format;
            {
                mCallback.onWindowAttributesChanged(attrs);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mDefaultWindowFormat = format;
        //if (!mHaveWindowFormat) {
            //final WindowManager.LayoutParams attrs = getAttributes();
            //attrs.format = format;
            //if (mCallback != null) {
                //mCallback.onWindowAttributesChanged(attrs);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.691 -0400", hash_original_method = "765B449347DE858F4538165B748C680A", hash_generated_method = "4A7B239B98899869D6755A70434A6994")
    @DSModeled(DSC.SAFE)
    protected boolean haveDimAmount() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHaveDimAmount;
    }

    
    public abstract void setChildDrawable(int featureId, Drawable drawable);

    
    public abstract void setChildInt(int featureId, int value);

    
    public abstract boolean isShortcutKey(int keyCode, KeyEvent event);

    
    public abstract void setVolumeControlStream(int streamType);

    
    public abstract int getVolumeControlStream();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.692 -0400", hash_original_method = "5C7A5DC825C127CAEB67314627C1344D", hash_generated_method = "C68886C623EC282D4F947C44E4F9DE2E")
    @DSModeled(DSC.SAFE)
    public void setUiOptions(int uiOptions) {
        dsTaint.addTaint(uiOptions);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.692 -0400", hash_original_method = "DD14EAF3AEC819DEC25B96FED2D2DF84", hash_generated_method = "BAB23113030D24D8D2D08B6EB79B356A")
    @DSModeled(DSC.SAFE)
    public void setUiOptions(int uiOptions, int mask) {
        dsTaint.addTaint(uiOptions);
        dsTaint.addTaint(mask);
        // ---------- Original Method ----------
    }

    
    private class LocalWindowManager extends WindowManagerImpl.CompatModeWrapper {
        private boolean mHardwareAccelerated;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.692 -0400", hash_original_method = "BB2707026A85041C76D7C937C71FA0C1", hash_generated_method = "134BE0880D617653A6C07A8676841906")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         LocalWindowManager(WindowManager wm, boolean hardwareAccelerated) {
            super(wm, getCompatInfo(mContext));
            dsTaint.addTaint(wm.dsTaint);
            dsTaint.addTaint(hardwareAccelerated);
            mHardwareAccelerated = hardwareAccelerated ||
                    SystemProperties.getBoolean(PROPERTY_HARDWARE_UI, false);
            // ---------- Original Method ----------
            //mHardwareAccelerated = hardwareAccelerated ||
                    //SystemProperties.getBoolean(PROPERTY_HARDWARE_UI, false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.692 -0400", hash_original_method = "93C5B5997EB72284CF079AECD506D640", hash_generated_method = "EDD09790A0DEC236AF3928A756BDDCC4")
        @DSModeled(DSC.SAFE)
        public boolean isHardwareAccelerated() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mHardwareAccelerated;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.693 -0400", hash_original_method = "AADD2F7F32065CABAE6715302100F897", hash_generated_method = "A058845A133A39154875C1053674584B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void addView(View view, ViewGroup.LayoutParams params) {
            dsTaint.addTaint(params.dsTaint);
            dsTaint.addTaint(view.dsTaint);
            WindowManager.LayoutParams wp;
            wp = (WindowManager.LayoutParams)params;
            CharSequence curTitle;
            curTitle = wp.getTitle();
            {
                {
                    View decor;
                    decor = peekDecorView();
                    {
                        wp.token = decor.getWindowToken();
                    } //End block
                } //End block
                {
                    boolean var618225A5546F933901E333CD89F06D8F_550481575 = (curTitle == null || curTitle.length() == 0);
                    {
                        String title;
                        {
                            title="Media";
                        } //End block
                        {
                            title="MediaOvr";
                        } //End block
                        {
                            title="Panel";
                        } //End block
                        {
                            title="SubPanel";
                        } //End block
                        {
                            title="AtchDlg";
                        } //End block
                        {
                            title=Integer.toString(wp.type);
                        } //End block
                        {
                            title += ":" + mAppName;
                        } //End block
                        wp.setTitle(title);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                {
                    wp.token = mContainer == null ? mAppToken : mContainer.mAppToken;
                } //End block
                {
                    boolean var04C9EAD0DFD9824FFF800C82EFF499AF_43153311 = ((curTitle == null || curTitle.length() == 0)
                        && mAppName != null);
                    {
                        wp.setTitle(mAppName);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                wp.packageName = mContext.getPackageName();
            } //End block
            {
                wp.flags |= WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED;
            } //End block
            super.addView(view, params);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        private static final String PROPERTY_HARDWARE_UI = "persist.sys.ui.hw";
    }


    
    public interface Callback {
        
        public boolean dispatchKeyEvent(KeyEvent event);

        
        public boolean dispatchKeyShortcutEvent(KeyEvent event);

        
        public boolean dispatchTouchEvent(MotionEvent event);
        
        
        public boolean dispatchTrackballEvent(MotionEvent event);

        
        public boolean dispatchGenericMotionEvent(MotionEvent event);

        
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event);

        
        public View onCreatePanelView(int featureId);

        
        public boolean onCreatePanelMenu(int featureId, Menu menu);

        
        public boolean onPreparePanel(int featureId, View view, Menu menu);

        
        public boolean onMenuOpened(int featureId, Menu menu);
        
        
        public boolean onMenuItemSelected(int featureId, MenuItem item);

        
        public void onWindowAttributesChanged(WindowManager.LayoutParams attrs);

        
        public void onContentChanged();

        
        public void onWindowFocusChanged(boolean hasFocus);

        
        public void onAttachedToWindow();
        
        
        public void onDetachedFromWindow();
        
        
        public void onPanelClosed(int featureId, Menu menu);
        
        
        public boolean onSearchRequested();

        
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback);

        
        public void onActionModeStarted(ActionMode mode);

        
        public void onActionModeFinished(ActionMode mode);
    }
    
    public static final int FEATURE_OPTIONS_PANEL = 0;
    public static final int FEATURE_NO_TITLE = 1;
    public static final int FEATURE_PROGRESS = 2;
    public static final int FEATURE_LEFT_ICON = 3;
    public static final int FEATURE_RIGHT_ICON = 4;
    public static final int FEATURE_INDETERMINATE_PROGRESS = 5;
    public static final int FEATURE_CONTEXT_MENU = 6;
    public static final int FEATURE_CUSTOM_TITLE = 7;
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int PROGRESS_VISIBILITY_ON = -1;
    public static final int PROGRESS_VISIBILITY_OFF = -2;
    public static final int PROGRESS_INDETERMINATE_ON = -3;
    public static final int PROGRESS_INDETERMINATE_OFF = -4;
    public static final int PROGRESS_START = 0;
    public static final int PROGRESS_END = 10000;
    public static final int PROGRESS_SECONDARY_START = 20000;
    public static final int PROGRESS_SECONDARY_END = 30000;
    @SuppressWarnings({"PointlessBitwiseExpression"}) protected static final int DEFAULT_FEATURES = (1 << FEATURE_OPTIONS_PANEL) |
            (1 << FEATURE_CONTEXT_MENU);
    public static final int ID_ANDROID_CONTENT = com.android.internal.R.id.content;
}

