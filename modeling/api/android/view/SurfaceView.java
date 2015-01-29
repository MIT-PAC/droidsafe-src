package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

import android.content.Context;
import android.content.res.CompatibilityInfo.Translator;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Handler;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.AttributeSet;

import com.android.internal.view.BaseIWindow;

import droidsafe.runtime.DroidSafeAndroidRuntime;

public class SurfaceView extends View {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.208 -0500", hash_original_field = "FC689FD8944CB77CB872F1DB7A3EB20C", hash_generated_field = "9B43E9AA5D64C04C9855106BA9F67D87")

    static private final String TAG = "SurfaceView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.210 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "AC679AD647C8EB62DD459B8B7830EF02")

    static private final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.241 -0500", hash_original_field = "582B11C7E982C01B3B4660900AE53BE3", hash_generated_field = "2D52D591F7078D964DA3AE3FF0B678A8")
    
    static final int KEEP_SCREEN_ON_MSG = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.244 -0500", hash_original_field = "357B9F780183CC3EF22FA0AB32DE4ED5", hash_generated_field = "921AAF60B1D7D413C64B8466E0451555")

    static final int GET_NEW_SURFACE_MSG = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.246 -0500", hash_original_field = "F6180D8CC5BA8F3797DD93F0A6BE1F24", hash_generated_field = "5118B77301D9A719E0B2FDF720426263")

    static final int UPDATE_WINDOW_MSG = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.213 -0500", hash_original_field = "245DBB681D9BCEAB91C3AF9BEFD14B0B", hash_generated_field = "BA9586511B46C47E39B6901EB112183C")

    final ArrayList<SurfaceHolder.Callback> mCallbacks
            = new ArrayList<SurfaceHolder.Callback>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.215 -0500", hash_original_field = "0BBE1A6E0D187D935362410EE6F68233", hash_generated_field = "D8970684837F794E969EF06F7541B80D")

    final int[] mLocation = new int[2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.217 -0500", hash_original_field = "F02D12B5BB0722412233675ECD5E628C", hash_generated_field = "D2CD36C589A71CE62D612FF351C42C56")
    
    final ReentrantLock mSurfaceLock = new ReentrantLock();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.219 -0500", hash_original_field = "1124ED61F6BA8AE3DABDAA886BC252C4", hash_generated_field = "7222C2DE2FD124DAAEF5694ECAF5C2CC")

    final Surface mSurface = new Surface();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.221 -0500", hash_original_field = "C3CEB06BC5C17AE4AD5789A804DB64BD", hash_generated_field = "F6B8FDB4721A8C7A02FED41E37BA183E")

    final Surface mNewSurface = new Surface();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.223 -0500", hash_original_field = "ED76781863F61A13511BF58C002B1BBF", hash_generated_field = "ED76781863F61A13511BF58C002B1BBF")

    boolean mDrawingStopped = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.225 -0500", hash_original_field = "8DE6D5890E78F90E00ECA1CD8D7B8427", hash_generated_field = "6916D4DA8C178A5064085A69A92BC4AF")

    final WindowManager.LayoutParams mLayout
            = new WindowManager.LayoutParams();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.227 -0500", hash_original_field = "380F2E6581760A76AE57EA2F3E243A67", hash_generated_field = "380F2E6581760A76AE57EA2F3E243A67")

    IWindowSession mSession;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.229 -0500", hash_original_field = "577B9FE3738F8B6ADA92EA52C1927104", hash_generated_field = "577B9FE3738F8B6ADA92EA52C1927104")

    MyWindow mWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.232 -0500", hash_original_field = "FFC6F470A4680792125A2753E4F0C9F9", hash_generated_field = "74237CDD8A53EAC9CF0433F0AD4D3E35")

    final Rect mVisibleInsets = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.234 -0500", hash_original_field = "537EDF90B62D70B92824A580BE2EED80", hash_generated_field = "62E173574E58D5F6E2049BF7CF48DBEF")

    final Rect mWinFrame = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.237 -0500", hash_original_field = "290E9F8E6A73A2B3125DD9995CBD7840", hash_generated_field = "7E3E0CF71C5FF5FEFC1FCFE669E40B4A")

    final Rect mContentInsets = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.239 -0500", hash_original_field = "3C4DD425CF8419EC4E2481AF19CC253D", hash_generated_field = "B8A51E3BDFDFA6BD4DD6947FD2E6D5ED")

    final Configuration mConfiguration = new Configuration();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.248 -0500", hash_original_field = "04DC44CC08E2DC20E8C9B7FBC3A9792F", hash_generated_field = "04DC44CC08E2DC20E8C9B7FBC3A9792F")
    
    int mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.250 -0500", hash_original_field = "42CCBD966EE81CE9697FAB49E6D2582E", hash_generated_field = "42CCBD966EE81CE9697FAB49E6D2582E")
    
    boolean mIsCreating = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.953 -0400", hash_original_field = "D90D1A693D5D2F3783052425E42CECB8", hash_generated_field = "341AB2CE4BC44F58CE9A63D19452DF45")

    final Handler mHandler = new Handler() {
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.953 -0400", hash_original_method = "82BE8897E23B3ED9422918649CBA5FAB", hash_generated_method = "6BEB6804DB838516BA4CFA4771D978CB")
        @Override
        public void handleMessage(Message msg) {
            
            {
                setKeepScreenOn(msg.arg1 != 0);
            }
            
            {
                handleGetNewSurface();
            }
            
            {
                updateWindow(false, false);
            }
            
            addTaint(msg.getTaint());
            
        }
        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.953 -0400", hash_original_field = "913D85241AB526174FCEFAE21DC92202", hash_generated_field = "F93A5F157956482F9A7A0FA31A439CC6")

    final ViewTreeObserver.OnScrollChangedListener mScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.953 -0400", hash_original_method = "5F51326E8091C450ECA5819AAACF378E", hash_generated_method = "9745D3D4F8B077B019362B4564B9A421")
        public void onScrollChanged() {
            
            updateWindow(false, false);
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.263 -0500", hash_original_field = "635EB6FF292E3DF71B68E7C0E21EA943", hash_generated_field = "635EB6FF292E3DF71B68E7C0E21EA943")
            
    boolean mRequestedVisible = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.266 -0500", hash_original_field = "A4CF9D6AC09D23B227BAB3B89F31B2D3", hash_generated_field = "A4CF9D6AC09D23B227BAB3B89F31B2D3")

    boolean mWindowVisibility = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.268 -0500", hash_original_field = "06D97C0D460C26A534A69E573E309009", hash_generated_field = "06D97C0D460C26A534A69E573E309009")

    boolean mViewVisibility = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.269 -0500", hash_original_field = "F9EC238B16254BED53BCBCEFBD6EF45D", hash_generated_field = "F9EC238B16254BED53BCBCEFBD6EF45D")

    int mRequestedWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.271 -0500", hash_original_field = "C329ECB2BC7D94AC739801F768FE2BE6", hash_generated_field = "C329ECB2BC7D94AC739801F768FE2BE6")

    int mRequestedHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.273 -0500", hash_original_field = "29DAC60891B320846596127D4DD3367B", hash_generated_field = "29DAC60891B320846596127D4DD3367B")

    int mRequestedFormat = PixelFormat.RGB_565;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.275 -0500", hash_original_field = "6528C85159177027E6C5270BE403086B", hash_generated_field = "6528C85159177027E6C5270BE403086B")

    boolean mHaveFrame = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.277 -0500", hash_original_field = "EB662B160F18E144C2B151B11D4F4499", hash_generated_field = "EB662B160F18E144C2B151B11D4F4499")

    boolean mSurfaceCreated = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.280 -0500", hash_original_field = "0FB69CE58A9B36474A3E521462C289A0", hash_generated_field = "0FB69CE58A9B36474A3E521462C289A0")

    long mLastLockTime = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.282 -0500", hash_original_field = "DEB26416BF26A48B3D4535794C8EE816", hash_generated_field = "DEB26416BF26A48B3D4535794C8EE816")
    
    boolean mVisible = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.285 -0500", hash_original_field = "C83F50A8E49AF7EE896F43CE50428149", hash_generated_field = "C83F50A8E49AF7EE896F43CE50428149")

    int mLeft = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.287 -0500", hash_original_field = "AE34762D67DAF237F215EF8196939D1A", hash_generated_field = "AE34762D67DAF237F215EF8196939D1A")

    int mTop = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.289 -0500", hash_original_field = "2BA03B5BE1E097B9BC57B210061D879D", hash_generated_field = "2BA03B5BE1E097B9BC57B210061D879D")

    int mWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.291 -0500", hash_original_field = "3D81262840DA37820D58425FC486E30D", hash_generated_field = "3D81262840DA37820D58425FC486E30D")

    int mHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.293 -0500", hash_original_field = "4E9A781D69912D6E8BAF53B79A032165", hash_generated_field = "4E9A781D69912D6E8BAF53B79A032165")

    int mFormat = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.295 -0500", hash_original_field = "F621A8E01339D28C0B8365EF1B47521B", hash_generated_field = "5FF70CE962F22D930D1FDE55775FEDAE")

    final Rect mSurfaceFrame = new Rect();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.297 -0500", hash_original_field = "0C3E6D0D62BE6C4E33545B05306C722E", hash_generated_field = "0C3E6D0D62BE6C4E33545B05306C722E")

    Rect mTmpDirty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.202 -0400", hash_original_field = "CA2F10DABCDE4DB5E5429CEA11987117", hash_generated_field = "3C23020B8A6266AAC0EC35C1AE5914DB")

    int mLastSurfaceWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:44.202 -0400", hash_original_field = "BA8354FB152B0EDF2F1A5839CC1B59A1", hash_generated_field = "7A4380591F3319A8BF6EAA09BD8D0D2B")

    int mLastSurfaceHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.301 -0500", hash_original_field = "83948CC76D0AA6ED0473B87897DB5577", hash_generated_field = "83948CC76D0AA6ED0473B87897DB5577")

    boolean mUpdateWindowNeeded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.303 -0500", hash_original_field = "7FDE85C5D470B5DB18C438DFA8239FBA", hash_generated_field = "7FDE85C5D470B5DB18C438DFA8239FBA")

    boolean mReportDrawNeeded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.305 -0500", hash_original_field = "C99D456D0176E245708DC63706237F48", hash_generated_field = "9240D36EAA3EB63C790BD51122AD0F85")

    private Translator mTranslator;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.954 -0400", hash_original_field = "7DE4F3D906ECFBD3310695CE98EDB143", hash_generated_field = "979F3EC4D28AB25C8DBFA7FB0D4ADD56")

    private final ViewTreeObserver.OnPreDrawListener mDrawListener = new ViewTreeObserver.OnPreDrawListener() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.954 -0400", hash_original_method = "BFD620CC97E89E709383D7DD902C160A", hash_generated_method = "2F9E5D9FADD874B33CEA4E7EAF8958D8")
        @Override
        public boolean onPreDraw() {
            
            mHaveFrame = getWidth() > 0 && getHeight() > 0;
            updateWindow(false, false);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_423263947 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_423263947;
            
        }
        
};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.314 -0500", hash_original_field = "614DA8F4F76977965501E87007BEDCD3", hash_generated_field = "67DE23FE0E490AA5CEE7BA68C5F3FA75")

    private boolean mGlobalListenersAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.962 -0400", hash_original_field = "6FDAAEDC4A7B9F01F100A9951CA155B8", hash_generated_field = "530D605DB6C75935065881CA57601D54")

    private SurfaceHolder mSurfaceHolder = new SurfaceHolder() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.955 -0400", hash_original_method = "FBEC596A43003FDD0C674BF719352967", hash_generated_method = "0AE8C164963D9154C5373545011D347E")
        public boolean isCreating() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2145375023 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2145375023;
            
        }
        
            @DSSafe(DSCat.SAFE_LIST)
            @DSVerified
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.956 -0400", hash_original_method = "A6B53DAA62C6D5AB170B791AD6D4E39D", hash_generated_method = "B2CAB5E929433EA6D0C0BB2DEC01017A")
        public void addCallback(Callback callback) {
            {
                callback.surfaceCreated(mSurfaceHolder);
                callback.surfaceChanged(mSurfaceHolder, 0, 0, 0);
                callback.surfaceDestroyed(mSurfaceHolder);

                {
                    boolean var1B2EEED5E498982D843BE645C828D6CD_462515332 = (mCallbacks.contains(callback) == false);
                    {
                        mCallbacks.add(callback);
                    } 
                } 
            } 
            addTaint(callback.getTaint());
            
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.956 -0400", hash_original_method = "C2F2686F3B633A931E5A1A7B954047E4", hash_generated_method = "DB035C8CD46FF3BDF3B8256D88449CEF")
        public void removeCallback(Callback callback) {
            {
                mCallbacks.remove(callback);
            } 
            addTaint(callback.getTaint());
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.957 -0400", hash_original_method = "64431562EF44F0DC495EE5D0EB57FE21", hash_generated_method = "5EC1C042E9F8EC07E989C383D5D12DF4")
        public void setFixedSize(int width, int height) {
            {
                mRequestedWidth = width;
                mRequestedHeight = height;
                requestLayout();
            } 
            addTaint(width);
            addTaint(height);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.957 -0400", hash_original_method = "E36476A0B11513BDBDEF513EF43A7F69", hash_generated_method = "8A56DFCEE733F3CA1DA6DDD667110EAA")
        public void setSizeFromLayout() {
            {
                mRequestedWidth = mRequestedHeight = -1;
                requestLayout();
            }
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.957 -0400", hash_original_method = "E4680DDEA725EDF754E21194707CA19F", hash_generated_method = "57E59E04C359A177D2ED4A63F5D25E6A")
        public void setFormat(int format) {
            format = PixelFormat.RGB_565;
            mRequestedFormat = format;
            {
                updateWindow(false, false);
            } 
            addTaint(format);
            
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.958 -0400", hash_original_method = "B37A48D0CAD6F4AF8C78DA1B2A495A29", hash_generated_method = "6068068249DD588BA4B94775BE4C5DEA")
        @Deprecated
        public void setType(int type) {
            addTaint(type);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.958 -0400", hash_original_method = "2D0915C13785F2B0579D7E71B7329015", hash_generated_method = "13518B89DEE9C48F4005A1526A4BB700")
        public void setKeepScreenOn(boolean screenOn) {
            Message msg = mHandler.obtainMessage(KEEP_SCREEN_ON_MSG);
            msg.arg1 = screenOn ? 1 : 0;
            mHandler.sendMessage(msg);
            addTaint(screenOn);
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.959 -0400", hash_original_method = "62E11A68BFE49B76328D9C868319D907", hash_generated_method = "2EA88269BA14916674E29DFFA53637C6")
        public Canvas lockCanvas() {
            Canvas varB4EAC82CA7396A68D541C85D26508E83_1416433397 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1416433397 = internalLockCanvas(null);
            varB4EAC82CA7396A68D541C85D26508E83_1416433397.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1416433397;
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.959 -0400", hash_original_method = "680C567FEFB26BF9B08DD2E5AA0C3FA9", hash_generated_method = "7FD2CB9F0FE0D2BFA9842A0854F9C8A3")
        public Canvas lockCanvas(Rect dirty) {
            Canvas varB4EAC82CA7396A68D541C85D26508E83_633323187 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_633323187 = internalLockCanvas(dirty);
            addTaint(dirty.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_633323187.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_633323187;
            
        }
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.960 -0400", hash_original_method = "4B95DCD02F9C44A8215403B28FBCC461", hash_generated_method = "E2365ED314FD823C889E68CD4EC4E0E5")
        private final Canvas internalLockCanvas(Rect dirty) {
            Canvas varB4EAC82CA7396A68D541C85D26508E83_1001906738 = null; 
            Canvas varB4EAC82CA7396A68D541C85D26508E83_757444974 = null; 
            mSurfaceLock.lock();
            Canvas c = null;
            {
                {
                    {
                        mTmpDirty = new Rect();
                    } 
                    mTmpDirty.set(mSurfaceFrame);
                    dirty = mTmpDirty;
                } 
                try 
                {
                    c = mSurface.lockCanvas(dirty);
                } 
                catch (Exception e)
                { }
            } 
            {
                mLastLockTime = SystemClock.uptimeMillis();
                varB4EAC82CA7396A68D541C85D26508E83_1001906738 = c;
            } 
            long now = SystemClock.uptimeMillis();
            long nextTime = mLastLockTime + 100;
            {
                try 
                {
                    Thread.sleep(nextTime-now);
                } 
                catch (InterruptedException e)
                { }
                now = SystemClock.uptimeMillis();
            } 
            mLastLockTime = now;
            mSurfaceLock.unlock();
            varB4EAC82CA7396A68D541C85D26508E83_757444974 = null;
            addTaint(dirty.getTaint());
            Canvas varA7E53CE21691AB073D9660D615818899_1563807688; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1563807688 = varB4EAC82CA7396A68D541C85D26508E83_1001906738;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1563807688 = varB4EAC82CA7396A68D541C85D26508E83_757444974;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1563807688.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1563807688;
            
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.961 -0400", hash_original_method = "94198D6DEEC3932A7E8E0C313FB26861", hash_generated_method = "DF654BF347DD18B3ED2B0613B73B292C")
        public void unlockCanvasAndPost(Canvas canvas) {
            mSurface.unlockCanvasAndPost(canvas);
            mSurfaceLock.unlock();
            addTaint(canvas.getTaint());
            
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.961 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "EAE603A661341677B1E1442890212909")
        public Surface getSurface() {
            Surface varB4EAC82CA7396A68D541C85D26508E83_993699055 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_993699055 = mSurface;
            varB4EAC82CA7396A68D541C85D26508E83_993699055.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_993699055;
            
        }
        
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.962 -0400", hash_original_method = "BE643F9C45A14CE663214357E2B511D8", hash_generated_method = "E910481C9324FAFBE5C38994E3533063")
        public Rect getSurfaceFrame() {
            Rect varB4EAC82CA7396A68D541C85D26508E83_1622396157 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1622396157 = mSurfaceFrame;
            varB4EAC82CA7396A68D541C85D26508E83_1622396157.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1622396157;
            
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.398 -0500", hash_original_field = "33B9D4C789C0DC5B7BE170363AD4B61A", hash_generated_field = "5C6F2FBBC61AC1A10962558A845ED6F9")
        
        private static final String LOG_TAG = "SurfaceHolder";
};

    @DSComment("Dedicated drawing surface")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.316 -0500", hash_original_method = "36676A10DA9FEB0757A9258740A87950", hash_generated_method = "A255D2F26C979B06132201DF48675A41")
    
public SurfaceView(Context context) {
        super(context);
        init();
    }
    
    @DSComment("Dedicated drawing surface")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.319 -0500", hash_original_method = "AC0FAD92FEC32BF55C39DC93EF8576EF", hash_generated_method = "FE366B161C66A6AFC530ABCACA3BED3A")
    
public SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.321 -0500", hash_original_method = "56551BC688438C77EC1087EC18E1D5A3", hash_generated_method = "E60A198277FDD607DC15186BA89DA660")
    
public SurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.323 -0500", hash_original_method = "8A7163C0B5D9260FCDBBE7B713CA285D", hash_generated_method = "A8F7F0532972A5FF42195F1D7D4D5A43")
    
private void init() {
        setWillNotDraw(true);
    }
    
    /**
     * Return the SurfaceHolder providing access and control over this
     * SurfaceView's underlying surface.
     * 
     * @return SurfaceHolder The holder of the surface.
     */
    @DSComment("Dedicated drawing surface")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.325 -0500", hash_original_method = "11B3726B61DA4E45A86A0978E3D5B1EE", hash_generated_method = "58FC46A9E0D6EACC68242F9E95DD21CD")
    
public SurfaceHolder getHolder() {
        return mSurfaceHolder;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.328 -0500", hash_original_method = "D0F196EB2D52CF89A074E8F883CCEE9A", hash_generated_method = "704795F2F7A3F9BC3517311919405778")
    
@Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mParent.requestTransparentRegion(this);
        mSession = getWindowSession();
        mLayout.token = getWindowToken();
        mLayout.setTitle("SurfaceView");
        mViewVisibility = getVisibility() == VISIBLE;

        if (!mGlobalListenersAdded) {
            ViewTreeObserver observer = getViewTreeObserver();
            observer.addOnScrollChangedListener(mScrollChangedListener);
            observer.addOnPreDrawListener(mDrawListener);
            mGlobalListenersAdded = true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.331 -0500", hash_original_method = "798A4FFA4C7A67465D94471AB247681B", hash_generated_method = "E59464FD638923B10F627BB40B745688")
    
@Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        mWindowVisibility = visibility == VISIBLE;
        mRequestedVisible = mWindowVisibility && mViewVisibility;
        updateWindow(false, false);
    }

    @DSComment("Dedicated drawing surface")
    @DSSafe(DSCat.GUI)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.333 -0500", hash_original_method = "644621127059D6B23356D81576DC6A8B", hash_generated_method = "62E82B7696931E2AE444CFAC3B347A50")
    
@Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        mViewVisibility = visibility == VISIBLE;
        mRequestedVisible = mWindowVisibility && mViewVisibility;
        updateWindow(false, false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.337 -0500", hash_original_method = "4BCDE7E4A5F0F207B0BFA481971C6B8A", hash_generated_method = "477A7AB82862631629C2AAE68886FAE0")
    
@Override
    protected void onDetachedFromWindow() {
        if (mGlobalListenersAdded) {
            ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnScrollChangedListener(mScrollChangedListener);
            observer.removeOnPreDrawListener(mDrawListener);
            mGlobalListenersAdded = false;
        }

        mRequestedVisible = false;
        updateWindow(false, false);
        mHaveFrame = false;
        if (mWindow != null) {
            try {
                mSession.remove(mWindow);
            } catch (RemoteException ex) {
                // Not much we can do here...
            }
            mWindow = null;
        }
        mSession = null;
        mLayout.token = null;

        super.onDetachedFromWindow();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.339 -0500", hash_original_method = "D2E319C9E98A8DC50F96090A40CA6589", hash_generated_method = "8B9AD3348D0EC20E6CD20121A69AB982")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = mRequestedWidth >= 0
                ? resolveSizeAndState(mRequestedWidth, widthMeasureSpec, 0)
                : getDefaultSize(0, widthMeasureSpec);
        int height = mRequestedHeight >= 0
                ? resolveSizeAndState(mRequestedHeight, heightMeasureSpec, 0)
                : getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
    
    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.342 -0500", hash_original_method = "F99ED41FE6B39B12C38A6C99019A5F97", hash_generated_method = "D2F449C5B196FDE027BF0D856E4D6600")
    
@Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        boolean result = super.setFrame(left, top, right, bottom);
        updateWindow(false, false);
        return result;
    }

    @DSComment("Dedicated drawing surface")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.344 -0500", hash_original_method = "41B5D508388526C331B138172391BB1E", hash_generated_method = "873D27504319B774EF13CEACA2326F59")
    
@Override
    public boolean gatherTransparentRegion(Region region) {
        if (mWindowType == WindowManager.LayoutParams.TYPE_APPLICATION_PANEL) {
            return super.gatherTransparentRegion(region);
        }
        
        boolean opaque = true;
        if ((mPrivateFlags & SKIP_DRAW) == 0) {
            // this view draws, remove it from the transparent region
            opaque = super.gatherTransparentRegion(region);
        } else if (region != null) {
            int w = getWidth();
            int h = getHeight();
            if (w>0 && h>0) {
                getLocationInWindow(mLocation);
                // otherwise, punch a hole in the whole hierarchy
                int l = mLocation[0];
                int t = mLocation[1];
                region.op(l, t, l+w, t+h, Region.Op.UNION);
            }
        }
        if (PixelFormat.formatHasAlpha(mRequestedFormat)) {
            opaque = false;
        }
        return opaque;
    }

    @DSComment("Dedicated drawing surface")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.347 -0500", hash_original_method = "B44BAC95FDBF1A2D6C6E955BD515D9FE", hash_generated_method = "97DE4A6D3543F02FB257F594A425585B")
    
@Override
    public void draw(Canvas canvas) {
        if (mWindowType != WindowManager.LayoutParams.TYPE_APPLICATION_PANEL) {
            // draw() is not called when SKIP_DRAW is set
            if ((mPrivateFlags & SKIP_DRAW) == 0) {
                // punch a whole in the view-hierarchy below us
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            }
        }
        super.draw(canvas);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.349 -0500", hash_original_method = "1FF1947FA48636DD52DD4F3203EB471D", hash_generated_method = "D9BFD1783A0B4C389A14143428EAB7DC")
    
@Override
    protected void dispatchDraw(Canvas canvas) {
        if (mWindowType != WindowManager.LayoutParams.TYPE_APPLICATION_PANEL) {
            // if SKIP_DRAW is cleared, draw() has already punched a hole
            if ((mPrivateFlags & SKIP_DRAW) == SKIP_DRAW) {
                // punch a whole in the view-hierarchy below us
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            }
        }
        super.dispatchDraw(canvas);
    }

    /**
     * Control whether the surface view's surface is placed on top of another
     * regular surface view in the window (but still behind the window itself).
     * This is typically used to place overlays on top of an underlying media
     * surface view.
     * 
     * <p>Note that this must be set before the surface view's containing
     * window is attached to the window manager.
     * 
     * <p>Calling this overrides any previous call to {@link #setZOrderOnTop}.
     */
    @DSComment("Dedicated drawing surface")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.351 -0500", hash_original_method = "FB26E6D2AB831E35DDA7A9ED4DEF2DCC", hash_generated_method = "DBA5C15CDD3EF8CF9CB4AA861D493175")
    
public void setZOrderMediaOverlay(boolean isMediaOverlay) {
        mWindowType = isMediaOverlay
                ? WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA_OVERLAY
                : WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
    }
    
    /**
     * Control whether the surface view's surface is placed on top of its
     * window.  Normally it is placed behind the window, to allow it to
     * (for the most part) appear to composite with the views in the
     * hierarchy.  By setting this, you cause it to be placed above the
     * window.  This means that none of the contents of the window this
     * SurfaceView is in will be visible on top of its surface.
     * 
     * <p>Note that this must be set before the surface view's containing
     * window is attached to the window manager.
     * 
     * <p>Calling this overrides any previous call to {@link #setZOrderMediaOverlay}.
     */
    @DSComment("Dedicated drawing surface")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.354 -0500", hash_original_method = "001C3D591DD99644CBE6444F60EBCCA2", hash_generated_method = "BD86D3EEB2C88766840B4730D205088A")
    
public void setZOrderOnTop(boolean onTop) {
        if (onTop) {
            mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
            // ensures the surface is placed below the IME
            mLayout.flags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        } else {
            mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
            mLayout.flags &= ~WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        }
    }
    
    private static class MyWindow extends BaseIWindow {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.373 -0500", hash_original_field = "D57B8B07074CE48AC3729175742AF2A3", hash_generated_field = "73AFFA24F24539E576EC15DD4CDCD19C")

        private  WeakReference<SurfaceView> mSurfaceView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.391 -0500", hash_original_field = "42653608DC496806D049FEC5FE343B4C", hash_generated_field = "42653608DC496806D049FEC5FE343B4C")

        int mCurWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.393 -0500", hash_original_field = "A4245ADE78B2EC437A5483DD0C64E816", hash_generated_field = "A4245ADE78B2EC437A5483DD0C64E816")

        int mCurHeight = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.376 -0500", hash_original_method = "636A3C131A2E0F598D9E9841916F7C6A", hash_generated_method = "9BE8CE4024A99A0A0F8C17D09B61B478")
        
public MyWindow(SurfaceView surfaceView) {
            mSurfaceView = new WeakReference<SurfaceView>(surfaceView);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.379 -0500", hash_original_method = "C97B8379077214A326B52B9AC32750F8", hash_generated_method = "81ACF06BF2282C42B831510D2E78E98B")
        
public void resized(int w, int h, Rect coveredInsets,
                Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
            SurfaceView surfaceView = mSurfaceView.get();
            if (surfaceView != null) {
                if (DEBUG) Log.v(
                        "SurfaceView", surfaceView + " got resized: w=" +
                                w + " h=" + h + ", cur w=" + mCurWidth + " h=" + mCurHeight);
                surfaceView.mSurfaceLock.lock();
                try {
                    if (reportDraw) {
                        surfaceView.mUpdateWindowNeeded = true;
                        surfaceView.mReportDrawNeeded = true;
                        surfaceView.mHandler.sendEmptyMessage(UPDATE_WINDOW_MSG);
                    } else if (surfaceView.mWinFrame.width() != w
                            || surfaceView.mWinFrame.height() != h) {
                        surfaceView.mUpdateWindowNeeded = true;
                        surfaceView.mHandler.sendEmptyMessage(UPDATE_WINDOW_MSG);
                    }
                } finally {
                    surfaceView.mSurfaceLock.unlock();
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.382 -0500", hash_original_method = "BE0716F4AD0CF82E07CDF7A02946EA01", hash_generated_method = "AA82348EC19FB34466CD88A8130DFD30")
        
public void dispatchAppVisibility(boolean visible) {
            // The point of SurfaceView is to let the app control the surface.
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.384 -0500", hash_original_method = "9244563860F137FED28CE6F0E7AFA6B7", hash_generated_method = "CC78B8FD3916C9BB4FCE62BDA1F8E0E2")
        
public void dispatchGetNewSurface() {
            SurfaceView surfaceView = mSurfaceView.get();
            if (surfaceView != null) {
                Message msg = surfaceView.mHandler.obtainMessage(GET_NEW_SURFACE_MSG);
                surfaceView.mHandler.sendMessage(msg);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.387 -0500", hash_original_method = "76E66C458D6EE4887227CD5EB1B9C2E4", hash_generated_method = "D4C445FE30F9A714808BCA84840EE725")
        
public void windowFocusChanged(boolean hasFocus, boolean touchEnabled) {
            Log.w("SurfaceView", "Unexpected focus in surface: focus=" + hasFocus + ", touchEnabled=" + touchEnabled);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.389 -0500", hash_original_method = "FFE9D2CBC83B323644FA8C6DFE6F40CA", hash_generated_method = "7EBEC9D17C27061D1FB56967BC4F83EC")
        
public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
        }
        
    }
    
    /**
     * Hack to allow special layering of windows.  The type is one of the
     * types in WindowManager.LayoutParams.  This is a hack so:
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.356 -0500", hash_original_method = "1670DE99B4A30E6D116E6931C42E66D0", hash_generated_method = "7F588508632C1EE33D9EBB8D9430B830")
    
public void setWindowType(int type) {
        mWindowType = type;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.363 -0500", hash_original_method = "1133978B42097E05A4BF8CED29255FA3", hash_generated_method = "E57E11319E2E1E7E89A4A47602828A7B")
    
private void updateWindow(boolean force, boolean redrawNeeded) {
        if (!mHaveFrame) {
            return;
        }
        ViewRootImpl viewRoot = (ViewRootImpl) getRootView().getParent();
        if (viewRoot != null) {
            mTranslator = viewRoot.mTranslator;
        }

        if (mTranslator != null) {
            mSurface.setCompatibilityTranslator(mTranslator);
        }
        
        int myWidth = mRequestedWidth;
        if (myWidth <= 0) myWidth = getWidth();
        int myHeight = mRequestedHeight;
        if (myHeight <= 0) myHeight = getHeight();

        getLocationInWindow(mLocation);
        final boolean creating = mWindow == null;
        final boolean formatChanged = mFormat != mRequestedFormat;
        final boolean sizeChanged = mWidth != myWidth || mHeight != myHeight;
        final boolean visibleChanged = mVisible != mRequestedVisible;

        if (force || creating || formatChanged || sizeChanged || visibleChanged
            || mLeft != mLocation[0] || mTop != mLocation[1]
            || mUpdateWindowNeeded || mReportDrawNeeded || redrawNeeded) {

            if (DEBUG) Log.i(TAG, "Changes: creating=" + creating
                    + " format=" + formatChanged + " size=" + sizeChanged
                    + " visible=" + visibleChanged
                    + " left=" + (mLeft != mLocation[0])
                    + " top=" + (mTop != mLocation[1]));

            try {
                final boolean visible = mVisible = mRequestedVisible;
                mLeft = mLocation[0];
                mTop = mLocation[1];
                mWidth = myWidth;
                mHeight = myHeight;
                mFormat = mRequestedFormat;

                // Scaling/Translate window's layout here because mLayout is not used elsewhere.
                
                // Places the window relative
                mLayout.x = mLeft;
                mLayout.y = mTop;
                mLayout.width = getWidth();
                mLayout.height = getHeight();
                if (mTranslator != null) {
                    mTranslator.translateLayoutParamsInAppWindowToScreen(mLayout);
                }
                
                mLayout.format = mRequestedFormat;
                mLayout.flags |=WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                              | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                              | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                              | WindowManager.LayoutParams.FLAG_SCALED
                              | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                              | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                              ;
                if (!getContext().getResources().getCompatibilityInfo().supportsScreen()) {
                    mLayout.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                }

                if (mWindow == null) {
                    mWindow = new MyWindow(this);
                    mLayout.type = mWindowType;
                    mLayout.gravity = Gravity.LEFT|Gravity.TOP;
                    mSession.addWithoutInputChannel(mWindow, mWindow.mSeq, mLayout,
                            mVisible ? VISIBLE : GONE, mContentInsets);
                }
                
                boolean realSizeChanged;
                boolean reportDrawNeeded;

                int relayoutResult;

                mSurfaceLock.lock();
                try {
                    mUpdateWindowNeeded = false;
                    reportDrawNeeded = mReportDrawNeeded;
                    mReportDrawNeeded = false;
                    mDrawingStopped = !visible;
    
                    if (DEBUG) Log.i(TAG, "Cur surface: " + mSurface);

                    relayoutResult = mSession.relayout(
                        mWindow, mWindow.mSeq, mLayout, mWidth, mHeight,
                            visible ? VISIBLE : GONE,
                            WindowManagerImpl.RELAYOUT_DEFER_SURFACE_DESTROY,
                            mWinFrame, mContentInsets,
                            mVisibleInsets, mConfiguration, mNewSurface);
                    if ((relayoutResult&WindowManagerImpl.RELAYOUT_RES_FIRST_TIME) != 0) {
                        mReportDrawNeeded = true;
                    }

                    if (DEBUG) Log.i(TAG, "New surface: " + mNewSurface
                            + ", vis=" + visible + ", frame=" + mWinFrame);

                    mSurfaceFrame.addTaint(mWinFrame.getTaintInt() + 
                            mTranslator.applicationInvertedScale);
                    /*
                    mSurfaceFrame.left = 0;
                    mSurfaceFrame.top = 0;
                    if (mTranslator == null) {
                        mSurfaceFrame.right = mWinFrame.width();
                        mSurfaceFrame.bottom = mWinFrame.height();
                    } else {
                        float appInvertedScale = mTranslator.applicationInvertedScale;
                        mSurfaceFrame.right = (int) (mWinFrame.width() * appInvertedScale + 0.5f);
                        mSurfaceFrame.bottom = (int) (mWinFrame.height() * appInvertedScale + 0.5f);
                    }
                    */
                    
                    final int surfaceWidth = mSurfaceFrame.right;
                    final int surfaceHeight = mSurfaceFrame.bottom;
                    realSizeChanged = 1 == (mLastSurfaceWidth + mLastSurfaceHeight + 
                                                    surfaceWidth + surfaceHeight);
                    mLastSurfaceWidth = surfaceWidth;
                    mLastSurfaceHeight = surfaceHeight;
                } finally {
                    mSurfaceLock.unlock();
                }

                try {
                    redrawNeeded |= creating | reportDrawNeeded;

                    SurfaceHolder.Callback callbacks[] = null;

                    final boolean surfaceChanged =
                            (relayoutResult&WindowManagerImpl.RELAYOUT_RES_SURFACE_CHANGED) != 0;
                    if (mSurfaceCreated && (surfaceChanged || (!visible && visibleChanged))) {
                        mSurfaceCreated = false;
                        if (mSurface.isValid()) {
                            if (DEBUG) Log.i(TAG, "visibleChanged -- surfaceDestroyed");
                            callbacks = getSurfaceCallbacks();
                            for (SurfaceHolder.Callback c : callbacks) {
                                c.surfaceDestroyed(mSurfaceHolder);
                            }
                        }
                    }

                    mSurface.transferFrom(mNewSurface);

                    if (visible) {
                        if (!mSurfaceCreated && (surfaceChanged || visibleChanged)) {
                            mSurfaceCreated = true;
                            mIsCreating = true;
                            if (DEBUG) Log.i(TAG, "visibleChanged -- surfaceCreated");
                            if (callbacks == null) {
                                callbacks = getSurfaceCallbacks();
                            }
                            for (SurfaceHolder.Callback c : callbacks) {
                                c.surfaceCreated(mSurfaceHolder);
                            }
                        }
                        if (creating || formatChanged || sizeChanged
                                || visibleChanged || realSizeChanged) {
                            if (DEBUG) Log.i(TAG, "surfaceChanged -- format=" + mFormat
                                    + " w=" + myWidth + " h=" + myHeight);
                            if (callbacks == null) {
                                callbacks = getSurfaceCallbacks();
                            }
                            for (SurfaceHolder.Callback c : callbacks) {
                                c.surfaceChanged(mSurfaceHolder, mFormat, myWidth, myHeight);
                            }
                        }
                        if (redrawNeeded) {
                            if (DEBUG) Log.i(TAG, "surfaceRedrawNeeded");
                            if (callbacks == null) {
                                callbacks = getSurfaceCallbacks();
                            }
                            for (SurfaceHolder.Callback c : callbacks) {
                                if (c instanceof SurfaceHolder.Callback2) {
                                    ((SurfaceHolder.Callback2)c).surfaceRedrawNeeded(
                                            mSurfaceHolder);
                                }
                            }
                        }
                    }
                } finally {
                    mIsCreating = false;
                    if (redrawNeeded) {
                        if (DEBUG) Log.i(TAG, "finishedDrawing");
                        mSession.finishDrawing(mWindow);
                    }
                    mSession.performDeferredDestroy(mWindow);
                }
            } catch (RemoteException ex) {
            }
            if (DEBUG) Log.v(
                TAG, "Layout: x=" + mLayout.x + " y=" + mLayout.y +
                " w=" + mLayout.width + " h=" + mLayout.height +
                ", frame=" + mSurfaceFrame);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.365 -0500", hash_original_method = "45F3E6A4EE2EB731EF40485FB92CA6AA", hash_generated_method = "ECF1A1800DED8854EB26E7BC4EE6F559")
    
private SurfaceHolder.Callback[] getSurfaceCallbacks() {
        SurfaceHolder.Callback callbacks[];
        synchronized (mCallbacks) {
            callbacks = new SurfaceHolder.Callback[mCallbacks.size()];
            mCallbacks.toArray(callbacks);
        }
        return callbacks;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.368 -0500", hash_original_method = "300B2B985E368655B5E11ADA1916748D", hash_generated_method = "300B2B985E368655B5E11ADA1916748D")
    
void handleGetNewSurface() {
        updateWindow(false, false);
    }

    /**
     * Check to see if the surface has fixed size dimensions or if the surface's
     * dimensions are dimensions are dependent on its current layout.
     *
     * @return true if the surface has dimensions that are fixed in size
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:49.370 -0500", hash_original_method = "A4CE5F54BDA2367531BCEA3F1517BC09", hash_generated_method = "FE37A70ACE94F0EDE1EBA253A75202E1")
    
public boolean isFixedSize() {
        return (mRequestedWidth != -1 || mRequestedHeight != -1);
    }
}

