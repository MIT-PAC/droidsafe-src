package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.821 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "498CE712CAAE1F07C5579CD1CD1DAD57", hash_generated_field = "FE42DB9D5DCA1AF8D89775C484584DA0")

    private TypedArray mWindowStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "B05DD02C49016AA70EF55EB624CC40D3")

    private Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "306519E50E3A91B9733D09F5D8EB985C", hash_generated_field = "3C750A4AE06B71AF3A05B7797C7182A4")

    private WindowManager mWindowManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "789FE61F50A486E596710FCC2797F1A1", hash_generated_field = "BB83A73F1EDDB2848C32920D653DC06A")

    private IBinder mAppToken;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "334FA2026AC041CBE5D1FA36A7B88E1D", hash_generated_field = "501107DCDCDE4B64DECA2D54F1B3291E")

    private String mAppName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "4CDA12FC009B8C79FD6D240C994A9B4E")

    private Window mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "BE3C2B61EEA527B7F044539C63D75FA8", hash_generated_field = "DAACFEA6BDA9FDD8068D4E47DE036B80")

    private Window mActiveChild;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "730139AE05F592457BDB9570EC12930C", hash_generated_field = "4A15BC690E6A07E466E1CFFEE049FB44")

    private boolean mIsActive = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "5F9CE42C2C7A9A4CC27FAB771A519B7B", hash_generated_field = "AE99BD7E76B07B1A3DB18B1673132924")

    private boolean mHasChildren = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "4474256FCA60986E0CDEBD6FE991F5A6", hash_generated_field = "6682B7CD42017C622EC5F9455D0BBBB5")

    private boolean mCloseOnTouchOutside = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "9BF91B6682AA2CC112DA8EA276F3D9DC", hash_generated_field = "913E6AEF20F2BF812FF1E6B4367E9661")

    private boolean mSetCloseOnTouchOutside = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "B3BB2135DFF47F34C57F1CB6AA0A88B7", hash_generated_field = "1D791569E1CBBFE45EC5118F952AEEB8")

    private int mForcedWindowFlags = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "2F5089C3B4A1DDBB3A300C5F83D7F839", hash_generated_field = "8DD2F8572C71CE50B81F1050762E8D15")

    private int mFeatures = DEFAULT_FEATURES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "926B360AADE14E1F7E8C8CE0149173B3", hash_generated_field = "8F439E32EE732AE863B494C6265A86B0")

    private int mLocalFeatures = DEFAULT_FEATURES;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "2091AA96E9CFC124D843E780B1AF9FE2", hash_generated_field = "68BCF9C876C3A5A4265478D3D60D9E88")

    private boolean mHaveWindowFormat = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.822 -0400", hash_original_field = "977B58BC5E2619A5F17A53D98D2D3D18", hash_generated_field = "08A6E705463382C516C1DE51AD82637F")

    private boolean mHaveDimAmount = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.823 -0400", hash_original_field = "5F8108FA3F94E8350770ECAD348104BC", hash_generated_field = "D05EC1E75FF8953CFD3364A5A03E7B08")

    private int mDefaultWindowFormat = PixelFormat.OPAQUE;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.823 -0400", hash_original_field = "6C9EC292E2B58AA639DB4D7E1C83FCA3", hash_generated_field = "0B8978AD19103B60226718E5263B1651")

    private boolean mHasSoftInputMode = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.823 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "1C64CB399BFF718CD14799195853AA6E")

    private boolean mDestroyed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.823 -0400", hash_original_field = "5A8DDBFFB48FB5038CAE7BDFEFA84A3A", hash_generated_field = "7F9A9896CA9A2F1A549BC7CFD23C8D28")

    private final WindowManager.LayoutParams mWindowAttributes = new WindowManager.LayoutParams();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.823 -0400", hash_original_method = "50ED378DEE1AF31F505AB3EFDADA9166", hash_generated_method = "2F4374F5D0B28DE042B0A979121F000F")
    public  Window(Context context) {
        mContext = context;
        // ---------- Original Method ----------
        //mContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.823 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "C246600354D6373DE82D3D6CC26FAA4B")
    public final Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_1410405501 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_1410405501.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_1410405501;
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.824 -0400", hash_original_method = "F2F0D9C02E357CB8D6CDE50C6B929622", hash_generated_method = "E40EAFCADA704F86CFE7FCCF80EFEF94")
    public final TypedArray getWindowStyle() {
        synchronized
(this)        {
    if(mWindowStyle == null)            
            {
                mWindowStyle = mContext.obtainStyledAttributes(
                        com.android.internal.R.styleable.Window);
            } //End block
TypedArray varE5D89730C76964B19AE0B3B4D5D0266A_1168940584 =             mWindowStyle;
            varE5D89730C76964B19AE0B3B4D5D0266A_1168940584.addTaint(taint);
            return varE5D89730C76964B19AE0B3B4D5D0266A_1168940584;
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mWindowStyle == null) {
                //mWindowStyle = mContext.obtainStyledAttributes(
                        //com.android.internal.R.styleable.Window);
            //}
            //return mWindowStyle;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.824 -0400", hash_original_method = "8852F0C837DC7060948A60A90C2A9042", hash_generated_method = "91556CB3AAC867AB9985DBFC953233DC")
    public void setContainer(Window container) {
        mContainer = container;
    if(container != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.825 -0400", hash_original_method = "DCCDF946CE22DD9064205FD95E96DECD", hash_generated_method = "9C18F2E282723983868EA72E266ACA18")
    public final Window getContainer() {
Window varCFF48C15085C1760829740A9CBEECBE6_1618215079 =         mContainer;
        varCFF48C15085C1760829740A9CBEECBE6_1618215079.addTaint(taint);
        return varCFF48C15085C1760829740A9CBEECBE6_1618215079;
        // ---------- Original Method ----------
        //return mContainer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.825 -0400", hash_original_method = "E436A7964E92BE677F4D553F3B295F27", hash_generated_method = "03E53C3FCE9C80B9125486C66BEC1C9E")
    public final boolean hasChildren() {
        boolean var9B0261922B47B9E850EEBFAE778A57BC_2079101653 = (mHasChildren);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_685435181 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_685435181;
        // ---------- Original Method ----------
        //return mHasChildren;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.825 -0400", hash_original_method = "66C6B9EE658776AAE6ED0A2EE9CF8E48", hash_generated_method = "592FCE4D1921959BBFF73FDA835F18F9")
    public final void destroy() {
        mDestroyed = true;
        // ---------- Original Method ----------
        //mDestroyed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.826 -0400", hash_original_method = "36E279B4F2F5FC702C91E645725B1821", hash_generated_method = "5C44A2664696B4E786866B5AB112265E")
    public final boolean isDestroyed() {
        boolean varC724374D1A8B3D38592BCBAA64034D32_2146347069 = (mDestroyed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_926542254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_926542254;
        // ---------- Original Method ----------
        //return mDestroyed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.826 -0400", hash_original_method = "49C37E5CFC1C233E6DF0E927E49CABF4", hash_generated_method = "6F20CD6A75212FB6CDDA20ADCE81D557")
    public void setWindowManager(WindowManager wm, IBinder appToken, String appName) {
        addTaint(appName.getTaint());
        addTaint(appToken.getTaint());
        addTaint(wm.getTaint());
        setWindowManager(wm, appToken, appName, false);
        // ---------- Original Method ----------
        //setWindowManager(wm, appToken, appName, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.826 -0400", hash_original_method = "07A6DAE3F5C8016383AB9A64DB3A39A3", hash_generated_method = "D2613A512E51374BE7A68F598A992C59")
    public void setWindowManager(WindowManager wm, IBinder appToken, String appName,
            boolean hardwareAccelerated) {
        mAppToken = appToken;
        mAppName = appName;
    if(wm == null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.827 -0400", hash_original_method = "1DCFADD2C71F0E408EA049F81A8ACDED", hash_generated_method = "93087EC7FB2A2F65820233A8013909FA")
    public WindowManager getWindowManager() {
WindowManager varC209C60BFE9D7B593AFE54EB902C1459_1279367762 =         mWindowManager;
        varC209C60BFE9D7B593AFE54EB902C1459_1279367762.addTaint(taint);
        return varC209C60BFE9D7B593AFE54EB902C1459_1279367762;
        // ---------- Original Method ----------
        //return mWindowManager;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.828 -0400", hash_original_method = "DD1DEB01F922CA329B6B6BD86F551D46", hash_generated_method = "C7938EB55EEAA39F9972B5240A5CA9B0")
    public void setCallback(Callback callback) {
        mCallback = callback;
        // ---------- Original Method ----------
        //mCallback = callback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.829 -0400", hash_original_method = "F07002384A5D5C29596645EE02BC1965", hash_generated_method = "30FA8C8FAA9CBF319A148E0D16288666")
    public final Callback getCallback() {
Callback var31075088B2A2E9D45AA9874A2DA07598_314587721 =         mCallback;
        var31075088B2A2E9D45AA9874A2DA07598_314587721.addTaint(taint);
        return var31075088B2A2E9D45AA9874A2DA07598_314587721;
        // ---------- Original Method ----------
        //return mCallback;
    }

    
    public abstract void takeSurface(SurfaceHolder.Callback2 callback);

    
    public abstract void takeInputQueue(InputQueue.Callback callback);

    
    public abstract boolean isFloating();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.830 -0400", hash_original_method = "BDF4A9191EC276CB59743DF4E4B8A744", hash_generated_method = "64B086A2C23AD801500639D2DF405F06")
    public void setLayout(int width, int height) {
        addTaint(height);
        addTaint(width);
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.width = width;
        attrs.height = height;
    if(mCallback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.831 -0400", hash_original_method = "76A69B8FD04E6A39E52E254D3C51CA75", hash_generated_method = "F5A2A19ABDB6C046D37D2DE5021441BD")
    public void setGravity(int gravity) {
        addTaint(gravity);
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.gravity = gravity;
    if(mCallback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.831 -0400", hash_original_method = "07612A9950A1C7129B1F4B699CE0FA52", hash_generated_method = "61A1AD06520B6963720B345DC0A28650")
    public void setType(int type) {
        addTaint(type);
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.type = type;
    if(mCallback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.832 -0400", hash_original_method = "ADD82385ADE43D8CE9305C2F63E34252", hash_generated_method = "0D7C00771DBF06B55ECF94C937C82A08")
    public void setFormat(int format) {
        addTaint(format);
        final WindowManager.LayoutParams attrs = getAttributes();
    if(format != PixelFormat.UNKNOWN)        
        {
            attrs.format = format;
            mHaveWindowFormat = true;
        } //End block
        else
        {
            attrs.format = mDefaultWindowFormat;
            mHaveWindowFormat = false;
        } //End block
    if(mCallback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.833 -0400", hash_original_method = "4617417E681280CCA3448C5B912BCD7D", hash_generated_method = "81B8A8887D1A3780F6E6E3124225E07A")
    public void setWindowAnimations(int resId) {
        addTaint(resId);
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.windowAnimations = resId;
    if(mCallback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.833 -0400", hash_original_method = "C4620B459A4A0F6C7D91CF9A478EC82D", hash_generated_method = "05F36EC04B656EEEDB43C217A42BF1C3")
    public void setSoftInputMode(int mode) {
        addTaint(mode);
        final WindowManager.LayoutParams attrs = getAttributes();
    if(mode != WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED)        
        {
            attrs.softInputMode = mode;
            mHasSoftInputMode = true;
        } //End block
        else
        {
            mHasSoftInputMode = false;
        } //End block
    if(mCallback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.834 -0400", hash_original_method = "0498A767AE3286E2ACD9E77A8750E86F", hash_generated_method = "638DDC552CF6A3ECA77448F017D52858")
    public void addFlags(int flags) {
        addTaint(flags);
        setFlags(flags, flags);
        // ---------- Original Method ----------
        //setFlags(flags, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.834 -0400", hash_original_method = "1B1BB2C51A9E558BB4222C67BD342AB1", hash_generated_method = "94CEB5A34A6C6B781C4053AAA1D39E16")
    public void clearFlags(int flags) {
        addTaint(flags);
        setFlags(0, flags);
        // ---------- Original Method ----------
        //setFlags(0, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.834 -0400", hash_original_method = "40E42D383A45AE28D15E52653F68CBD5", hash_generated_method = "98457A0C40EC3E9FEDCFCF8DDC473CCE")
    public void setFlags(int flags, int mask) {
        addTaint(flags);
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.flags = (attrs.flags&~mask) | (flags&mask);
    if((mask&WindowManager.LayoutParams.FLAG_NEEDS_MENU_KEY) != 0)        
        {
            attrs.privateFlags |= WindowManager.LayoutParams.PRIVATE_FLAG_SET_NEEDS_MENU_KEY;
        } //End block
        mForcedWindowFlags |= mask;
    if(mCallback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.835 -0400", hash_original_method = "9455DB63259C6955368CE857C592C952", hash_generated_method = "807C83D89FBB5D743DA177F9A002CA59")
    public void setDimAmount(float amount) {
        addTaint(amount);
        final WindowManager.LayoutParams attrs = getAttributes();
        attrs.dimAmount = amount;
        mHaveDimAmount = true;
    if(mCallback != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.835 -0400", hash_original_method = "66B5C1599B3320A30790CC9FF26FC996", hash_generated_method = "2B1526F7EA2574D0DBD3513CACCB6043")
    public void setAttributes(WindowManager.LayoutParams a) {
        addTaint(a.getTaint());
        mWindowAttributes.copyFrom(a);
    if(mCallback != null)        
        {
            mCallback.onWindowAttributesChanged(mWindowAttributes);
        } //End block
        // ---------- Original Method ----------
        //mWindowAttributes.copyFrom(a);
        //if (mCallback != null) {
            //mCallback.onWindowAttributesChanged(mWindowAttributes);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.836 -0400", hash_original_method = "1740BD4A684D4859A9304C42BFBB0628", hash_generated_method = "E8D42C8D0DB2FBD23CBFB471B379B077")
    public final WindowManager.LayoutParams getAttributes() {
WindowManager.LayoutParams varE57270F4ADC424A6223549BA17009D8D_2036557780 =         mWindowAttributes;
        varE57270F4ADC424A6223549BA17009D8D_2036557780.addTaint(taint);
        return varE57270F4ADC424A6223549BA17009D8D_2036557780;
        // ---------- Original Method ----------
        //return mWindowAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.836 -0400", hash_original_method = "78D10AE7087B6FEDF7B8FA7D71B4D366", hash_generated_method = "A1A5F804913CDDB35A77F42F8FABA870")
    protected final int getForcedWindowFlags() {
        int var4EE36C5865D89E55EC7E436C6E156515_1688642835 = (mForcedWindowFlags);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286654686 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286654686;
        // ---------- Original Method ----------
        //return mForcedWindowFlags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.836 -0400", hash_original_method = "3FB6B9359B05585EE87D1E296E0BA56E", hash_generated_method = "C5EBC986E462B8D1503AD5AFD9FC334C")
    protected final boolean hasSoftInputMode() {
        boolean var21F55EAD7EB0233F4CD6F052E1E40E3A_217748268 = (mHasSoftInputMode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534225709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_534225709;
        // ---------- Original Method ----------
        //return mHasSoftInputMode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.837 -0400", hash_original_method = "A665A75B43AC6644089B2FAB21289091", hash_generated_method = "0CBE03D8878DA6B3055F2BC397378281")
    public void setCloseOnTouchOutside(boolean close) {
        mCloseOnTouchOutside = close;
        mSetCloseOnTouchOutside = true;
        // ---------- Original Method ----------
        //mCloseOnTouchOutside = close;
        //mSetCloseOnTouchOutside = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.837 -0400", hash_original_method = "585D2A4E90DC505694C50AFA60811C60", hash_generated_method = "BCF6D3153CBF82853BAE2A8C284E5D74")
    public void setCloseOnTouchOutsideIfNotSet(boolean close) {
    if(!mSetCloseOnTouchOutside)        
        {
            mCloseOnTouchOutside = close;
            mSetCloseOnTouchOutside = true;
        } //End block
        // ---------- Original Method ----------
        //if (!mSetCloseOnTouchOutside) {
            //mCloseOnTouchOutside = close;
            //mSetCloseOnTouchOutside = true;
        //}
    }

    
    public abstract void alwaysReadCloseOnTouchAttr();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.837 -0400", hash_original_method = "8CE0B3F5C0E964B12FFD1AA84260C5B9", hash_generated_method = "F3D1E57BEB83CFB5785024707FEDDCD8")
    public boolean shouldCloseOnTouch(Context context, MotionEvent event) {
        addTaint(event.getTaint());
        addTaint(context.getTaint());
    if(mCloseOnTouchOutside && event.getAction() == MotionEvent.ACTION_DOWN
                && isOutOfBounds(context, event) && peekDecorView() != null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1388789310 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_711442710 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_711442710;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1338744223 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_766188499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_766188499;
        // ---------- Original Method ----------
        //if (mCloseOnTouchOutside && event.getAction() == MotionEvent.ACTION_DOWN
                //&& isOutOfBounds(context, event) && peekDecorView() != null) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.838 -0400", hash_original_method = "AB4AFCB92A037D63668D3D8B793C0712", hash_generated_method = "BA2F1B90CDF7C5E010531816A39076A5")
    private boolean isOutOfBounds(Context context, MotionEvent event) {
        addTaint(event.getTaint());
        addTaint(context.getTaint());
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        final int slop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        final View decorView = getDecorView();
        boolean var35E2A7088BF57907B3561E1F5AC3DF33_277555869 = ((x < -slop) || (y < -slop)
                || (x > (decorView.getWidth()+slop))
                || (y > (decorView.getHeight()+slop)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054153399 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054153399;
        // ---------- Original Method ----------
        //final int x = (int) event.getX();
        //final int y = (int) event.getY();
        //final int slop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        //final View decorView = getDecorView();
        //return (x < -slop) || (y < -slop)
                //|| (x > (decorView.getWidth()+slop))
                //|| (y > (decorView.getHeight()+slop));
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.839 -0400", hash_original_method = "56D6FF40FC7BCA35CBE5379E385EA86C", hash_generated_method = "3BB2B818E02378B60233CCEECF96AFE5")
    public boolean requestFeature(int featureId) {
        addTaint(featureId);
        final int flag = 1<<featureId;
        mFeatures |= flag;
        mLocalFeatures |= mContainer != null ? (flag&~mContainer.mFeatures) : flag;
        boolean var6384D4741CF70EDEB341429AA32AA95F_1539279544 = ((mFeatures&flag) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_404870721 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_404870721;
        // ---------- Original Method ----------
        //final int flag = 1<<featureId;
        //mFeatures |= flag;
        //mLocalFeatures |= mContainer != null ? (flag&~mContainer.mFeatures) : flag;
        //return (mFeatures&flag) != 0;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.839 -0400", hash_original_method = "24AB1A47189F5640F802580999D5EF0B", hash_generated_method = "51319D33017B41F04E4A916C38F9F5CE")
    protected void removeFeature(int featureId) {
        addTaint(featureId);
        final int flag = 1<<featureId;
        mFeatures &= ~flag;
        mLocalFeatures &= ~(mContainer != null ? (flag&~mContainer.mFeatures) : flag);
        // ---------- Original Method ----------
        //final int flag = 1<<featureId;
        //mFeatures &= ~flag;
        //mLocalFeatures &= ~(mContainer != null ? (flag&~mContainer.mFeatures) : flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.840 -0400", hash_original_method = "B5CCAAF5805277DBB8CBB8283B5C5952", hash_generated_method = "752B6EF22D908DC7546F1B2C413CEA63")
    public final void makeActive() {
    if(mContainer != null)        
        {
    if(mContainer.mActiveChild != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.840 -0400", hash_original_method = "825B8CF70F64E49AF2D9884D4F1141F6", hash_generated_method = "CFBCFC65ECF84D3B4C1EB8A3410D3ED1")
    public final boolean isActive() {
        boolean var972BCC941F1372E1A778AE1D6E99926D_1566776211 = (mIsActive);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_482777473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_482777473;
        // ---------- Original Method ----------
        //return mIsActive;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.840 -0400", hash_original_method = "06392AB1384FAD789566489ED7477D15", hash_generated_method = "AFFE0ED2B7555FD5767179D0669DD3F7")
    public View findViewById(int id) {
        addTaint(id);
View var4A691E6E01A019BBE376A012F4AAC75B_1833508895 =         getDecorView().findViewById(id);
        var4A691E6E01A019BBE376A012F4AAC75B_1833508895.addTaint(taint);
        return var4A691E6E01A019BBE376A012F4AAC75B_1833508895;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.842 -0400", hash_original_method = "AFC383C5A753BE0283DE80727207DE11", hash_generated_method = "6679B188DA27417B7AD7511D43F747C1")
    public void setBackgroundDrawableResource(int resid) {
        addTaint(resid);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.845 -0400", hash_original_method = "201C8696C96B5CE4C022F78574069483", hash_generated_method = "FAA8414C5D03476708A8BDCADF787BC6")
    protected final int getFeatures() {
        int varB6FEAD34C9CE2FFD9FDB8BCB7536B5B4_1770137471 = (mFeatures);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042383514 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2042383514;
        // ---------- Original Method ----------
        //return mFeatures;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.845 -0400", hash_original_method = "5A085FB22E39DFD08969173C82283E9B", hash_generated_method = "7647F66C5CF8C2861BFCB06510DFD871")
    public boolean hasFeature(int feature) {
        addTaint(feature);
        boolean var5153CEC0D1228CF2E69293DA1694211D_1833732163 = ((getFeatures() & (1 << feature)) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1759157183 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1759157183;
        // ---------- Original Method ----------
        //return (getFeatures() & (1 << feature)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.845 -0400", hash_original_method = "D46E90B97B876B97E16E92A5FEA18EB3", hash_generated_method = "91A14E7DC16C4D9D4D3DF8A03F894A41")
    protected final int getLocalFeatures() {
        int var03B104EA3187129C36E0DC9BFDDB4C89_1995280559 = (mLocalFeatures);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_553978878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_553978878;
        // ---------- Original Method ----------
        //return mLocalFeatures;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.845 -0400", hash_original_method = "439CF6A84E0EE9568E72DFCB057259B4", hash_generated_method = "A0F3828852B1925840BECDE82620B466")
    protected void setDefaultWindowFormat(int format) {
        mDefaultWindowFormat = format;
    if(!mHaveWindowFormat)        
        {
            final WindowManager.LayoutParams attrs = getAttributes();
            attrs.format = format;
    if(mCallback != null)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.845 -0400", hash_original_method = "765B449347DE858F4538165B748C680A", hash_generated_method = "447D909330EC98272B7C93EDB298CD51")
    protected boolean haveDimAmount() {
        boolean varEBD748F40F1824CE253B65FC97383B87_318947719 = (mHaveDimAmount);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_931562340 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_931562340;
        // ---------- Original Method ----------
        //return mHaveDimAmount;
    }

    
    public abstract void setChildDrawable(int featureId, Drawable drawable);

    
    public abstract void setChildInt(int featureId, int value);

    
    public abstract boolean isShortcutKey(int keyCode, KeyEvent event);

    
    public abstract void setVolumeControlStream(int streamType);

    
    public abstract int getVolumeControlStream();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.846 -0400", hash_original_method = "5C7A5DC825C127CAEB67314627C1344D", hash_generated_method = "41402CC6B89BFAB78A866C7788612094")
    public void setUiOptions(int uiOptions) {
        addTaint(uiOptions);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.846 -0400", hash_original_method = "DD14EAF3AEC819DEC25B96FED2D2DF84", hash_generated_method = "E45DD96DC91929140767CFFEF651CA13")
    public void setUiOptions(int uiOptions, int mask) {
        addTaint(mask);
        addTaint(uiOptions);
        // ---------- Original Method ----------
    }

    
    private class LocalWindowManager extends WindowManagerImpl.CompatModeWrapper {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.846 -0400", hash_original_field = "6AB4A5F453379ED66BAA79CE64FDFD98", hash_generated_field = "C592280128F52BDDBAD2DA621E45F814")

        private boolean mHardwareAccelerated;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.846 -0400", hash_original_method = "BB2707026A85041C76D7C937C71FA0C1", hash_generated_method = "25110D3B89BF96A2C7DE3EED97DC643A")
          LocalWindowManager(WindowManager wm, boolean hardwareAccelerated) {
            super(wm, getCompatInfo(mContext));
            addTaint(wm.getTaint());
            mHardwareAccelerated = hardwareAccelerated ||
                    SystemProperties.getBoolean(PROPERTY_HARDWARE_UI, false);
            // ---------- Original Method ----------
            //mHardwareAccelerated = hardwareAccelerated ||
                    //SystemProperties.getBoolean(PROPERTY_HARDWARE_UI, false);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.847 -0400", hash_original_method = "93C5B5997EB72284CF079AECD506D640", hash_generated_method = "A6D915C41DF6CDDB7A45000495642554")
        public boolean isHardwareAccelerated() {
            boolean var6AB4A5F453379ED66BAA79CE64FDFD98_473921847 = (mHardwareAccelerated);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_237902501 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_237902501;
            // ---------- Original Method ----------
            //return mHardwareAccelerated;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.848 -0400", hash_original_method = "AADD2F7F32065CABAE6715302100F897", hash_generated_method = "77360A7438A9710121AC60539E0DA9F2")
        public final void addView(View view, ViewGroup.LayoutParams params) {
            addTaint(params.getTaint());
            addTaint(view.getTaint());
            WindowManager.LayoutParams wp = (WindowManager.LayoutParams)params;
            CharSequence curTitle = wp.getTitle();
    if(wp.type >= WindowManager.LayoutParams.FIRST_SUB_WINDOW &&
                wp.type <= WindowManager.LayoutParams.LAST_SUB_WINDOW)            
            {
    if(wp.token == null)                
                {
                    View decor = peekDecorView();
    if(decor != null)                    
                    {
                        wp.token = decor.getWindowToken();
                    } //End block
                } //End block
    if(curTitle == null || curTitle.length() == 0)                
                {
                    String title;
    if(wp.type == WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA)                    
                    {
                        title="Media";
                    } //End block
                    else
    if(wp.type == WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA_OVERLAY)                    
                    {
                        title="MediaOvr";
                    } //End block
                    else
    if(wp.type == WindowManager.LayoutParams.TYPE_APPLICATION_PANEL)                    
                    {
                        title="Panel";
                    } //End block
                    else
    if(wp.type == WindowManager.LayoutParams.TYPE_APPLICATION_SUB_PANEL)                    
                    {
                        title="SubPanel";
                    } //End block
                    else
    if(wp.type == WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG)                    
                    {
                        title="AtchDlg";
                    } //End block
                    else
                    {
                        title=Integer.toString(wp.type);
                    } //End block
    if(mAppName != null)                    
                    {
                        title += ":" + mAppName;
                    } //End block
                    wp.setTitle(title);
                } //End block
            } //End block
            else
            {
    if(wp.token == null)                
                {
                    wp.token = mContainer == null ? mAppToken : mContainer.mAppToken;
                } //End block
    if((curTitle == null || curTitle.length() == 0)
                        && mAppName != null)                
                {
                    wp.setTitle(mAppName);
                } //End block
            } //End block
    if(wp.packageName == null)            
            {
                wp.packageName = mContext.getPackageName();
            } //End block
    if(mHardwareAccelerated)            
            {
                wp.flags |= WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED;
            } //End block
            super.addView(view, params);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.848 -0400", hash_original_field = "627F75A013AB2C65C956BA07A57C87CE", hash_generated_field = "BA2C677D1D301CB311A67BA2544B79AA")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.848 -0400", hash_original_field = "142CC032426664F1131AAD84F0B71E27", hash_generated_field = "472DA983306B223D5089DE41C6B304F6")

    public static final int FEATURE_OPTIONS_PANEL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.848 -0400", hash_original_field = "1A42FC1E9D8C4FD687250F3D04736852", hash_generated_field = "0E27D3969BF23D79444C083F69CE913B")

    public static final int FEATURE_NO_TITLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.848 -0400", hash_original_field = "DFD0C7B479301B6462562BA8E617A688", hash_generated_field = "C56DCBD5961394440275C325C5322980")

    public static final int FEATURE_PROGRESS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.848 -0400", hash_original_field = "F9BC41525AF04F818CA21EA1C65A9752", hash_generated_field = "1A609527E6D52575F7BB34AA94FA5452")

    public static final int FEATURE_LEFT_ICON = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.848 -0400", hash_original_field = "E3D0DA5C9E2C6149A42256DD0267FF03", hash_generated_field = "1950720A14827F199C723E292C8843CB")

    public static final int FEATURE_RIGHT_ICON = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "90A6D7170362C56F2D4D0CEBF3E1AE60", hash_generated_field = "A0820169C7BD3B2ADEF3346DA41635B2")

    public static final int FEATURE_INDETERMINATE_PROGRESS = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "22FEE503AF84A4305AF39AD674C528CA", hash_generated_field = "330D7D49F8F1B757C106B92F0683EDB7")

    public static final int FEATURE_CONTEXT_MENU = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "DCAE9AA00DFEF52AD022057232B407ED", hash_generated_field = "DECB0F3E1BE49983D78AAF2637ECB72D")

    public static final int FEATURE_CUSTOM_TITLE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "F5A95B890AEDDD6850F504A9DD313912", hash_generated_field = "C443D1CC878B321D84BA4ED206191978")

    public static final int FEATURE_ACTION_BAR = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "C4BB95867602847B3342D6AE68130898", hash_generated_field = "136B78431D739532A1C4A86F966210BE")

    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "19F86BE28D746FBCED37D00A7EC49E48", hash_generated_field = "691774D2B2F1BBA031D2D45979BFB0DE")

    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "7E15567E6F95C49BB6FBBF62B4163850", hash_generated_field = "9D38CA915D3E74CA2094BA5902BED0B2")

    public static final int PROGRESS_VISIBILITY_ON = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "58DFD3754B62F9205F89FA1C06CF7603", hash_generated_field = "5D4C8296C206C08EA35B814522DD9983")

    public static final int PROGRESS_VISIBILITY_OFF = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "079C6A39AEDEF6EB46F945CC4F332A40", hash_generated_field = "1877511F5796C123D37BB3D39E902341")

    public static final int PROGRESS_INDETERMINATE_ON = -3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "D50731EF9F2698D26A8D8D5D24135910", hash_generated_field = "68E36EAEDD10C796D1EA6ADEF387DFC2")

    public static final int PROGRESS_INDETERMINATE_OFF = -4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "03AEB78BD497B6FA66E18440F2EB9D21", hash_generated_field = "8A8B490338B3753D82CBEEAAB64BD7CA")

    public static final int PROGRESS_START = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "270B737C2A6802DC318F3F31F96D76D8", hash_generated_field = "40A0B7325B8605AF6527271642B9A30A")

    public static final int PROGRESS_END = 10000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "6B37BABFB3B5D043229EC1DC752924D1", hash_generated_field = "5F723C725C29E1DA5AF89AB3DD752716")

    public static final int PROGRESS_SECONDARY_START = 20000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "2CB2298C5DE78F9345D4EB3F45DBA8B5", hash_generated_field = "CC459F31B753B125143BA79C6808282B")

    public static final int PROGRESS_SECONDARY_END = 30000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "F44A8BAE7300C4DAB7403F9638FB79CF", hash_generated_field = "9C42AD869F8A2C22203ED8B37C7EB793")

    @SuppressWarnings({"PointlessBitwiseExpression"}) protected static final int DEFAULT_FEATURES = (1 << FEATURE_OPTIONS_PANEL) |
            (1 << FEATURE_CONTEXT_MENU);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:54.849 -0400", hash_original_field = "D7F131DA2B7D215B81908F2D274AD794", hash_generated_field = "93F6ACF9E071115D7CCE648A911B5392")

    public static final int ID_ANDROID_CONTENT = com.android.internal.R.id.content;
}

