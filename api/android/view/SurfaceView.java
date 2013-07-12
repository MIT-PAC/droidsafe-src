package android.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.view.BaseIWindow;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.CompatibilityInfo.Translator;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.ParcelFileDescriptor;
import android.util.AttributeSet;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class SurfaceView extends View {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.904 -0400", hash_original_field = "5B2965AE5247A9A1234D4FDCDF03BACD", hash_generated_field = "BA9586511B46C47E39B6901EB112183C")

    final ArrayList<SurfaceHolder.Callback> mCallbacks = new ArrayList<SurfaceHolder.Callback>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.904 -0400", hash_original_field = "A0037653DE7FE22D1CDC645BBB2BB2C1", hash_generated_field = "D8970684837F794E969EF06F7541B80D")

    final int[] mLocation = new int[2];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.904 -0400", hash_original_field = "52392AFCA83FA6F6A2B3A89B48CC1408", hash_generated_field = "D2CD36C589A71CE62D612FF351C42C56")

    final ReentrantLock mSurfaceLock = new ReentrantLock();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.904 -0400", hash_original_field = "41551392C18EC9CD321667F2791AD52A", hash_generated_field = "7222C2DE2FD124DAAEF5694ECAF5C2CC")

    final Surface mSurface = new Surface();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.904 -0400", hash_original_field = "32DF5A5B638D647186A34FEB9E8C25DF", hash_generated_field = "F6B8FDB4721A8C7A02FED41E37BA183E")

    final Surface mNewSurface = new Surface();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.904 -0400", hash_original_field = "CEEF4EC564E6E901BB24E650B19154D7", hash_generated_field = "ED76781863F61A13511BF58C002B1BBF")

    boolean mDrawingStopped = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "0F1C7BA6D88E38AFC2CF565631CFDF11", hash_generated_field = "6916D4DA8C178A5064085A69A92BC4AF")

    final WindowManager.LayoutParams mLayout = new WindowManager.LayoutParams();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "585864B1433B33593F88424BEC9E09EF", hash_generated_field = "380F2E6581760A76AE57EA2F3E243A67")

    IWindowSession mSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "F4214BE1FFE044F8CA79EEDDDED72016", hash_generated_field = "577B9FE3738F8B6ADA92EA52C1927104")

    MyWindow mWindow;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "CDCC88BCD1FA2B6E7E3A22E8D09269CC", hash_generated_field = "74237CDD8A53EAC9CF0433F0AD4D3E35")

    final Rect mVisibleInsets = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "1A9453997FFEAAB68E371A8E6CB115CF", hash_generated_field = "62E173574E58D5F6E2049BF7CF48DBEF")

    final Rect mWinFrame = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "5E83131046575CE08F0EE6BB5ECA21AF", hash_generated_field = "7E3E0CF71C5FF5FEFC1FCFE669E40B4A")

    final Rect mContentInsets = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "31DF163B31592D80065FABA8640DBF8D", hash_generated_field = "B8A51E3BDFDFA6BD4DD6947FD2E6D5ED")

    final Configuration mConfiguration = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "325D4DEA58C109037A7113B457894D60", hash_generated_field = "04DC44CC08E2DC20E8C9B7FBC3A9792F")

    int mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "2FDD8FE938F2AD2E3BA3A87A5ED30FD3", hash_generated_field = "42CCBD966EE81CE9697FAB49E6D2582E")

    boolean mIsCreating = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.953 -0400", hash_original_field = "D90D1A693D5D2F3783052425E42CECB8", hash_generated_field = "341AB2CE4BC44F58CE9A63D19452DF45")

    final Handler mHandler = new Handler() {        
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "A124F28EC7E5F4344D8D38052F1778DB", hash_generated_field = "635EB6FF292E3DF71B68E7C0E21EA943")

    boolean mRequestedVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "A7658E846ECCF73E0DE4384402026F36", hash_generated_field = "A4CF9D6AC09D23B227BAB3B89F31B2D3")

    boolean mWindowVisibility = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "5B7BC98FCFA3E8B4B553A22D8243D3E3", hash_generated_field = "06D97C0D460C26A534A69E573E309009")

    boolean mViewVisibility = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "8A5806C480FF6E75927A4F1D6AFC8E5D", hash_generated_field = "F9EC238B16254BED53BCBCEFBD6EF45D")

    int mRequestedWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "62C4EF08A7A4B3F04161E6472DF8ACF1", hash_generated_field = "C329ECB2BC7D94AC739801F768FE2BE6")

    int mRequestedHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.905 -0400", hash_original_field = "2F147CED7E6D6E28D296B68A8175227F", hash_generated_field = "29DAC60891B320846596127D4DD3367B")

    int mRequestedFormat = PixelFormat.RGB_565;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "0D8E6A9A6439BD0EDB0134B86DD0FF56", hash_generated_field = "6528C85159177027E6C5270BE403086B")

    boolean mHaveFrame = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "8D4F01906A9F4DADAC82180AAD02A4F6", hash_generated_field = "EB662B160F18E144C2B151B11D4F4499")

    boolean mSurfaceCreated = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "D42022960F60B4E9A38A4C00D0651E27", hash_generated_field = "0FB69CE58A9B36474A3E521462C289A0")

    long mLastLockTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "95D7DEECF5DCCC2A9C275828FA450168", hash_generated_field = "DEB26416BF26A48B3D4535794C8EE816")

    boolean mVisible = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "47627E0D2063C2FF25F544DF82A07CEB", hash_generated_field = "C83F50A8E49AF7EE896F43CE50428149")

    int mLeft = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "4D79044FCC074DC8AB1CC40842F16BE9", hash_generated_field = "AE34762D67DAF237F215EF8196939D1A")

    int mTop = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "A95631D81A2F2A7712CA1BACF8C3ED06", hash_generated_field = "2BA03B5BE1E097B9BC57B210061D879D")

    int mWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "B3AC750C72790F3A16FDCF47C86F48B7", hash_generated_field = "3D81262840DA37820D58425FC486E30D")

    int mHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "03A4C44BAF25FFDAE87EE7226502A224", hash_generated_field = "4E9A781D69912D6E8BAF53B79A032165")

    int mFormat = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "430EE1EE1C2CEA5C342BF8D9010C8AB2", hash_generated_field = "5FF70CE962F22D930D1FDE55775FEDAE")

    final Rect mSurfaceFrame = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "EE99E1DF5AAD9573B58AE4256DDE7025", hash_generated_field = "0C3E6D0D62BE6C4E33545B05306C722E")

    Rect mTmpDirty;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "CA2F10DABCDE4DB5E5429CEA11987117", hash_generated_field = "3C23020B8A6266AAC0EC35C1AE5914DB")

    int mLastSurfaceWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "BA8354FB152B0EDF2F1A5839CC1B59A1", hash_generated_field = "7A4380591F3319A8BF6EAA09BD8D0D2B")

    int mLastSurfaceHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "84A013955992EDF984AB619D44940C9F", hash_generated_field = "83948CC76D0AA6ED0473B87897DB5577")

    boolean mUpdateWindowNeeded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "D5CF8343673CBDFD480FC15CF4FB6B2A", hash_generated_field = "7FDE85C5D470B5DB18C438DFA8239FBA")

    boolean mReportDrawNeeded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "D30D964DEC107E6D034DC2A2CB80EA28", hash_generated_field = "9240D36EAA3EB63C790BD51122AD0F85")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.906 -0400", hash_original_field = "B4AC2A786F54EF959652EE43FF37D9C4", hash_generated_field = "67DE23FE0E490AA5CEE7BA68C5F3FA75")

    private boolean mGlobalListenersAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.962 -0400", hash_original_field = "6FDAAEDC4A7B9F01F100A9951CA155B8", hash_generated_field = "530D605DB6C75935065881CA57601D54")

    private SurfaceHolder mSurfaceHolder = new SurfaceHolder() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.955 -0400", hash_original_method = "FBEC596A43003FDD0C674BF719352967", hash_generated_method = "0AE8C164963D9154C5373545011D347E")
        public boolean isCreating() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2145375023 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2145375023;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.956 -0400", hash_original_method = "A6B53DAA62C6D5AB170B791AD6D4E39D", hash_generated_method = "B2CAB5E929433EA6D0C0BB2DEC01017A")
        public void addCallback(Callback callback) {
            {
                {
                    boolean var1B2EEED5E498982D843BE645C828D6CD_462515332 = (mCallbacks.contains(callback) == false);
                    {
                        mCallbacks.add(callback);
                    } 
                } 
            } 
            addTaint(callback.getTaint());
            
            
                
                    
                
            
        }

        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.961 -0400", hash_original_method = "FB03EEF08A419E6F5E4B7D4C32AA13C8", hash_generated_method = "EAE603A661341677B1E1442890212909")
        public Surface getSurface() {
            Surface varB4EAC82CA7396A68D541C85D26508E83_993699055 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_993699055 = mSurface;
            varB4EAC82CA7396A68D541C85D26508E83_993699055.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_993699055;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.962 -0400", hash_original_method = "BE643F9C45A14CE663214357E2B511D8", hash_generated_method = "E910481C9324FAFBE5C38994E3533063")
        public Rect getSurfaceFrame() {
            Rect varB4EAC82CA7396A68D541C85D26508E83_1622396157 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1622396157 = mSurfaceFrame;
            varB4EAC82CA7396A68D541C85D26508E83_1622396157.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1622396157;
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:54.962 -0400", hash_original_field = "A256D9ED1DA4748F37339B7E0CAA53F3", hash_generated_field = "5C6F2FBBC61AC1A10962558A845ED6F9")

        private static final String LOG_TAG = "SurfaceHolder";
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.907 -0400", hash_original_method = "36676A10DA9FEB0757A9258740A87950", hash_generated_method = "87DDB0D9485C6492CE7FD762F34FC60E")
    public  SurfaceView(Context context) {
        super(context);
        addTaint(context.getTaint());
        init();
        // ---------- Original Method ----------
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.907 -0400", hash_original_method = "AC0FAD92FEC32BF55C39DC93EF8576EF", hash_generated_method = "6331146784CA69D821F0D321E8959B8A")
    public  SurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        init();
        // ---------- Original Method ----------
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.908 -0400", hash_original_method = "56551BC688438C77EC1087EC18E1D5A3", hash_generated_method = "1316159281F03B74F08359F3AE0D7BC3")
    public  SurfaceView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        init();
        // ---------- Original Method ----------
        //init();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.908 -0400", hash_original_method = "8A7163C0B5D9260FCDBBE7B713CA285D", hash_generated_method = "EC875459420059988B62E0689FF79ECE")
    private void init() {
        setWillNotDraw(true);
        // ---------- Original Method ----------
        //setWillNotDraw(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.908 -0400", hash_original_method = "11B3726B61DA4E45A86A0978E3D5B1EE", hash_generated_method = "7F2AB83E07352A89B75F8314517BF106")
    public SurfaceHolder getHolder() {
SurfaceHolder var2103ECF1F3E4D3C9052D93458F857375_873333173 =         mSurfaceHolder;
        var2103ECF1F3E4D3C9052D93458F857375_873333173.addTaint(taint);
        return var2103ECF1F3E4D3C9052D93458F857375_873333173;
        // ---------- Original Method ----------
        //return mSurfaceHolder;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.909 -0400", hash_original_method = "D0F196EB2D52CF89A074E8F883CCEE9A", hash_generated_method = "D9472E9EFB76A81E90B6C355FEE22C88")
    @Override
    protected void onAttachedToWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onAttachedToWindow();
        mParent.requestTransparentRegion(this);
        mSession = getWindowSession();
        mLayout.token = getWindowToken();
        mLayout.setTitle("SurfaceView");
        mViewVisibility = getVisibility() == VISIBLE;
    if(!mGlobalListenersAdded)        
        {
            ViewTreeObserver observer = getViewTreeObserver();
            observer.addOnScrollChangedListener(mScrollChangedListener);
            observer.addOnPreDrawListener(mDrawListener);
            mGlobalListenersAdded = true;
        } //End block
        // ---------- Original Method ----------
        //super.onAttachedToWindow();
        //mParent.requestTransparentRegion(this);
        //mSession = getWindowSession();
        //mLayout.token = getWindowToken();
        //mLayout.setTitle("SurfaceView");
        //mViewVisibility = getVisibility() == VISIBLE;
        //if (!mGlobalListenersAdded) {
            //ViewTreeObserver observer = getViewTreeObserver();
            //observer.addOnScrollChangedListener(mScrollChangedListener);
            //observer.addOnPreDrawListener(mDrawListener);
            //mGlobalListenersAdded = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.909 -0400", hash_original_method = "798A4FFA4C7A67465D94471AB247681B", hash_generated_method = "B598EEA46B3AE9FA935DB6F1CD600126")
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onWindowVisibilityChanged(visibility);
        mWindowVisibility = visibility == VISIBLE;
        mRequestedVisible = mWindowVisibility && mViewVisibility;
        updateWindow(false, false);
        // ---------- Original Method ----------
        //super.onWindowVisibilityChanged(visibility);
        //mWindowVisibility = visibility == VISIBLE;
        //mRequestedVisible = mWindowVisibility && mViewVisibility;
        //updateWindow(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.909 -0400", hash_original_method = "644621127059D6B23356D81576DC6A8B", hash_generated_method = "E5286B2FAA243D4A8768171F99DC52AA")
    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        mViewVisibility = visibility == VISIBLE;
        mRequestedVisible = mWindowVisibility && mViewVisibility;
        updateWindow(false, false);
        // ---------- Original Method ----------
        //super.setVisibility(visibility);
        //mViewVisibility = visibility == VISIBLE;
        //mRequestedVisible = mWindowVisibility && mViewVisibility;
        //updateWindow(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.910 -0400", hash_original_method = "4BCDE7E4A5F0F207B0BFA481971C6B8A", hash_generated_method = "D367F621F4A7622F955D0920BB8E45AC")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
    if(mGlobalListenersAdded)        
        {
            ViewTreeObserver observer = getViewTreeObserver();
            observer.removeOnScrollChangedListener(mScrollChangedListener);
            observer.removeOnPreDrawListener(mDrawListener);
            mGlobalListenersAdded = false;
        } //End block
        mRequestedVisible = false;
        updateWindow(false, false);
        mHaveFrame = false;
    if(mWindow != null)        
        {
            try 
            {
                mSession.remove(mWindow);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
            mWindow = null;
        } //End block
        mSession = null;
        mLayout.token = null;
        super.onDetachedFromWindow();
        // ---------- Original Method ----------
        //if (mGlobalListenersAdded) {
            //ViewTreeObserver observer = getViewTreeObserver();
            //observer.removeOnScrollChangedListener(mScrollChangedListener);
            //observer.removeOnPreDrawListener(mDrawListener);
            //mGlobalListenersAdded = false;
        //}
        //mRequestedVisible = false;
        //updateWindow(false, false);
        //mHaveFrame = false;
        //if (mWindow != null) {
            //try {
                //mSession.remove(mWindow);
            //} catch (RemoteException ex) {
            //}
            //mWindow = null;
        //}
        //mSession = null;
        //mLayout.token = null;
        //super.onDetachedFromWindow();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.911 -0400", hash_original_method = "D2E319C9E98A8DC50F96090A40CA6589", hash_generated_method = "2BA9608B48E6D31DC70ABB1CCE47FA61")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        int width = mRequestedWidth >= 0
                ? resolveSizeAndState(mRequestedWidth, widthMeasureSpec, 0)
                : getDefaultSize(0, widthMeasureSpec);
        int height = mRequestedHeight >= 0
                ? resolveSizeAndState(mRequestedHeight, heightMeasureSpec, 0)
                : getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
        // ---------- Original Method ----------
        //int width = mRequestedWidth >= 0
                //? resolveSizeAndState(mRequestedWidth, widthMeasureSpec, 0)
                //: getDefaultSize(0, widthMeasureSpec);
        //int height = mRequestedHeight >= 0
                //? resolveSizeAndState(mRequestedHeight, heightMeasureSpec, 0)
                //: getDefaultSize(0, heightMeasureSpec);
        //setMeasuredDimension(width, height);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.911 -0400", hash_original_method = "F99ED41FE6B39B12C38A6C99019A5F97", hash_generated_method = "AFA29B0248EB98983533ECEACFF2A426")
    @Override
    protected boolean setFrame(int left, int top, int right, int bottom) {
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        boolean result = super.setFrame(left, top, right, bottom);
        updateWindow(false, false);
        boolean varB4A88417B3D0170D754C647C30B7216A_221213497 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397210683 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397210683;
        // ---------- Original Method ----------
        //boolean result = super.setFrame(left, top, right, bottom);
        //updateWindow(false, false);
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.912 -0400", hash_original_method = "41B5D508388526C331B138172391BB1E", hash_generated_method = "6CF5C84ACFEC9F483C4CF6E694B8D8A8")
    @Override
    public boolean gatherTransparentRegion(Region region) {
        addTaint(region.getTaint());
    if(mWindowType == WindowManager.LayoutParams.TYPE_APPLICATION_PANEL)        
        {
            boolean varB88F1B51417F3A653712641E7DE67E51_886078449 = (super.gatherTransparentRegion(region));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2094475976 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2094475976;
        } //End block
        boolean opaque = true;
    if((mPrivateFlags & SKIP_DRAW) == 0)        
        {
            opaque = super.gatherTransparentRegion(region);
        } //End block
        else
    if(region != null)        
        {
            int w = getWidth();
            int h = getHeight();
    if(w>0 && h>0)            
            {
                getLocationInWindow(mLocation);
                int l = mLocation[0];
                int t = mLocation[1];
                region.op(l, t, l+w, t+h, Region.Op.UNION);
            } //End block
        } //End block
    if(PixelFormat.formatHasAlpha(mRequestedFormat))        
        {
            opaque = false;
        } //End block
        boolean var94619F8A70068B2591C2EED622525B0E_1612634273 = (opaque);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_255907662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_255907662;
        // ---------- Original Method ----------
        //if (mWindowType == WindowManager.LayoutParams.TYPE_APPLICATION_PANEL) {
            //return super.gatherTransparentRegion(region);
        //}
        //boolean opaque = true;
        //if ((mPrivateFlags & SKIP_DRAW) == 0) {
            //opaque = super.gatherTransparentRegion(region);
        //} else if (region != null) {
            //int w = getWidth();
            //int h = getHeight();
            //if (w>0 && h>0) {
                //getLocationInWindow(mLocation);
                //int l = mLocation[0];
                //int t = mLocation[1];
                //region.op(l, t, l+w, t+h, Region.Op.UNION);
            //}
        //}
        //if (PixelFormat.formatHasAlpha(mRequestedFormat)) {
            //opaque = false;
        //}
        //return opaque;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.912 -0400", hash_original_method = "B44BAC95FDBF1A2D6C6E955BD515D9FE", hash_generated_method = "6F8CFC8D036B6EE8D63F1E476DFC1695")
    @Override
    public void draw(Canvas canvas) {
        addTaint(canvas.getTaint());
    if(mWindowType != WindowManager.LayoutParams.TYPE_APPLICATION_PANEL)        
        {
    if((mPrivateFlags & SKIP_DRAW) == 0)            
            {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            } //End block
        } //End block
        super.draw(canvas);
        // ---------- Original Method ----------
        //if (mWindowType != WindowManager.LayoutParams.TYPE_APPLICATION_PANEL) {
            //if ((mPrivateFlags & SKIP_DRAW) == 0) {
                //canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            //}
        //}
        //super.draw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.912 -0400", hash_original_method = "1FF1947FA48636DD52DD4F3203EB471D", hash_generated_method = "E1A54D5D3FB86B729D84A9CC4184AB67")
    @Override
    protected void dispatchDraw(Canvas canvas) {
        addTaint(canvas.getTaint());
    if(mWindowType != WindowManager.LayoutParams.TYPE_APPLICATION_PANEL)        
        {
    if((mPrivateFlags & SKIP_DRAW) == SKIP_DRAW)            
            {
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            } //End block
        } //End block
        super.dispatchDraw(canvas);
        // ---------- Original Method ----------
        //if (mWindowType != WindowManager.LayoutParams.TYPE_APPLICATION_PANEL) {
            //if ((mPrivateFlags & SKIP_DRAW) == SKIP_DRAW) {
                //canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            //}
        //}
        //super.dispatchDraw(canvas);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.913 -0400", hash_original_method = "FB26E6D2AB831E35DDA7A9ED4DEF2DCC", hash_generated_method = "3A11010F1FE7203445373F74FB7FA109")
    public void setZOrderMediaOverlay(boolean isMediaOverlay) {
        mWindowType = isMediaOverlay
                ? WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA_OVERLAY
                : WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
        // ---------- Original Method ----------
        //mWindowType = isMediaOverlay
                //? WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA_OVERLAY
                //: WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.913 -0400", hash_original_method = "001C3D591DD99644CBE6444F60EBCCA2", hash_generated_method = "96488BE6391412F9F36CDC74D9BA36A6")
    public void setZOrderOnTop(boolean onTop) {
        addTaint(onTop);
    if(onTop)        
        {
            mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
            mLayout.flags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        } //End block
        else
        {
            mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
            mLayout.flags &= ~WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        } //End block
        // ---------- Original Method ----------
        //if (onTop) {
            //mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_PANEL;
            //mLayout.flags |= WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        //} else {
            //mWindowType = WindowManager.LayoutParams.TYPE_APPLICATION_MEDIA;
            //mLayout.flags &= ~WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.914 -0400", hash_original_method = "1670DE99B4A30E6D116E6931C42E66D0", hash_generated_method = "038066FDD6533F376555CE67954F9E82")
    public void setWindowType(int type) {
        mWindowType = type;
        // ---------- Original Method ----------
        //mWindowType = type;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.919 -0400", hash_original_method = "1133978B42097E05A4BF8CED29255FA3", hash_generated_method = "128EED3733F0FC01E31068F53657E414")
    private void updateWindow(boolean force, boolean redrawNeeded) {
        addTaint(redrawNeeded);
        addTaint(force);
    if(!mHaveFrame)        
        {
            return;
        } //End block
        ViewRootImpl viewRoot = (ViewRootImpl) getRootView().getParent();
    if(viewRoot != null)        
        {
            mTranslator = viewRoot.mTranslator;
        } //End block
    if(mTranslator != null)        
        {
            mSurface.setCompatibilityTranslator(mTranslator);
        } //End block
        int myWidth = mRequestedWidth;
    if(myWidth <= 0)        
        myWidth = getWidth();
        int myHeight = mRequestedHeight;
    if(myHeight <= 0)        
        myHeight = getHeight();
        getLocationInWindow(mLocation);
        final boolean creating = mWindow == null;
        final boolean formatChanged = mFormat != mRequestedFormat;
        final boolean sizeChanged = mWidth != myWidth || mHeight != myHeight;
        final boolean visibleChanged = mVisible != mRequestedVisible;
    if(force || creating || formatChanged || sizeChanged || visibleChanged
            || mLeft != mLocation[0] || mTop != mLocation[1]
            || mUpdateWindowNeeded || mReportDrawNeeded || redrawNeeded)        
        {
    if(DEBUG){ }            try 
            {
                final boolean visible = mVisible = mRequestedVisible;
                mLeft = mLocation[0];
                mTop = mLocation[1];
                mWidth = myWidth;
                mHeight = myHeight;
                mFormat = mRequestedFormat;
                mLayout.x = mLeft;
                mLayout.y = mTop;
                mLayout.width = getWidth();
                mLayout.height = getHeight();
    if(mTranslator != null)                
                {
                    mTranslator.translateLayoutParamsInAppWindowToScreen(mLayout);
                } //End block
                mLayout.format = mRequestedFormat;
                mLayout.flags |=WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                              | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                              | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
                              | WindowManager.LayoutParams.FLAG_SCALED
                              | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                              | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
    if(!getContext().getResources().getCompatibilityInfo().supportsScreen())                
                {
                    mLayout.flags |= WindowManager.LayoutParams.FLAG_COMPATIBLE_WINDOW;
                } //End block
    if(mWindow == null)                
                {
                    mWindow = new MyWindow(this);
                    mLayout.type = mWindowType;
                    mLayout.gravity = Gravity.LEFT|Gravity.TOP;
                    mSession.addWithoutInputChannel(mWindow, mWindow.mSeq, mLayout,
                            mVisible ? VISIBLE : GONE, mContentInsets);
                } //End block
                boolean realSizeChanged;
                boolean reportDrawNeeded;
                int relayoutResult;
                mSurfaceLock.lock();
                try 
                {
                    mUpdateWindowNeeded = false;
                    reportDrawNeeded = mReportDrawNeeded;
                    mReportDrawNeeded = false;
                    mDrawingStopped = !visible;
    if(DEBUG){ }                    relayoutResult = mSession.relayout(
                        mWindow, mWindow.mSeq, mLayout, mWidth, mHeight,
                            visible ? VISIBLE : GONE,
                            WindowManagerImpl.RELAYOUT_DEFER_SURFACE_DESTROY,
                            mWinFrame, mContentInsets,
                            mVisibleInsets, mConfiguration, mNewSurface);
    if((relayoutResult&WindowManagerImpl.RELAYOUT_RES_FIRST_TIME) != 0)                    
                    {
                        mReportDrawNeeded = true;
                    } //End block
    if(DEBUG){ }                    mSurfaceFrame.left = 0;
                    mSurfaceFrame.top = 0;
    if(mTranslator == null)                    
                    {
                        mSurfaceFrame.right = mWinFrame.width();
                        mSurfaceFrame.bottom = mWinFrame.height();
                    } //End block
                    else
                    {
                        float appInvertedScale = mTranslator.applicationInvertedScale;
                        mSurfaceFrame.right = (int) (mWinFrame.width() * appInvertedScale + 0.5f);
                        mSurfaceFrame.bottom = (int) (mWinFrame.height() * appInvertedScale + 0.5f);
                    } //End block
                    final int surfaceWidth = mSurfaceFrame.right;
                    final int surfaceHeight = mSurfaceFrame.bottom;
                    realSizeChanged = mLastSurfaceWidth != surfaceWidth
                            || mLastSurfaceHeight != surfaceHeight;
                    mLastSurfaceWidth = surfaceWidth;
                    mLastSurfaceHeight = surfaceHeight;
                } //End block
                finally 
                {
                    mSurfaceLock.unlock();
                } //End block
                try 
                {
                    redrawNeeded |= creating | reportDrawNeeded;
                    SurfaceHolder.Callback callbacks[] = null;
                    final boolean surfaceChanged = (relayoutResult&WindowManagerImpl.RELAYOUT_RES_SURFACE_CHANGED) != 0;
    if(mSurfaceCreated && (surfaceChanged || (!visible && visibleChanged)))                    
                    {
                        mSurfaceCreated = false;
    if(mSurface.isValid())                        
                        {
    if(DEBUG){ }                            callbacks = getSurfaceCallbacks();
for(SurfaceHolder.Callback c : callbacks)
                            {
                                c.surfaceDestroyed(mSurfaceHolder);
                            } //End block
                        } //End block
                    } //End block
                    mSurface.transferFrom(mNewSurface);
    if(visible)                    
                    {
    if(!mSurfaceCreated && (surfaceChanged || visibleChanged))                        
                        {
                            mSurfaceCreated = true;
                            mIsCreating = true;
    if(DEBUG){ }    if(callbacks == null)                            
                            {
                                callbacks = getSurfaceCallbacks();
                            } //End block
for(SurfaceHolder.Callback c : callbacks)
                            {
                                c.surfaceCreated(mSurfaceHolder);
                            } //End block
                        } //End block
    if(creating || formatChanged || sizeChanged
                                || visibleChanged || realSizeChanged)                        
                        {
    if(DEBUG){ }    if(callbacks == null)                            
                            {
                                callbacks = getSurfaceCallbacks();
                            } //End block
for(SurfaceHolder.Callback c : callbacks)
                            {
                                c.surfaceChanged(mSurfaceHolder, mFormat, myWidth, myHeight);
                            } //End block
                        } //End block
    if(redrawNeeded)                        
                        {
    if(DEBUG){ }    if(callbacks == null)                            
                            {
                                callbacks = getSurfaceCallbacks();
                            } //End block
for(SurfaceHolder.Callback c : callbacks)
                            {
    if(c instanceof SurfaceHolder.Callback2)                                
                                {
                                    ((SurfaceHolder.Callback2)c).surfaceRedrawNeeded(
                                            mSurfaceHolder);
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                } //End block
                finally 
                {
                    mIsCreating = false;
    if(redrawNeeded)                    
                    {
    if(DEBUG){ }                        mSession.finishDrawing(mWindow);
                    } //End block
                    mSession.performDeferredDestroy(mWindow);
                } //End block
            } //End block
            catch (RemoteException ex)
            {
            } //End block
    if(DEBUG){ }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.920 -0400", hash_original_method = "45F3E6A4EE2EB731EF40485FB92CA6AA", hash_generated_method = "68A9022C4F710B48F1991F9CBC236C6C")
    private SurfaceHolder.Callback[] getSurfaceCallbacks() {
        SurfaceHolder.Callback callbacks[];
        synchronized
(mCallbacks)        {
            callbacks = new SurfaceHolder.Callback[mCallbacks.size()];
            mCallbacks.toArray(callbacks);
        } //End block
SurfaceHolder.Callback[] var7E06ACD9C2C819F377F4C0B98904AB11_207615594 =         callbacks;
        var7E06ACD9C2C819F377F4C0B98904AB11_207615594.addTaint(taint);
        return var7E06ACD9C2C819F377F4C0B98904AB11_207615594;
        // ---------- Original Method ----------
        //SurfaceHolder.Callback callbacks[];
        //synchronized (mCallbacks) {
            //callbacks = new SurfaceHolder.Callback[mCallbacks.size()];
            //mCallbacks.toArray(callbacks);
        //}
        //return callbacks;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.921 -0400", hash_original_method = "300B2B985E368655B5E11ADA1916748D", hash_generated_method = "A6C8E4CA52B47BE053F3A9B363230D11")
     void handleGetNewSurface() {
        updateWindow(false, false);
        // ---------- Original Method ----------
        //updateWindow(false, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.921 -0400", hash_original_method = "A4CE5F54BDA2367531BCEA3F1517BC09", hash_generated_method = "35973A73CAFE77268E21B04BF502CB01")
    public boolean isFixedSize() {
        boolean var1C8AF9176ECD1A92CAC16542656B0789_1421680205 = ((mRequestedWidth != -1 || mRequestedHeight != -1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_961246004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_961246004;
        // ---------- Original Method ----------
        //return (mRequestedWidth != -1 || mRequestedHeight != -1);
    }

    
    private static class MyWindow extends BaseIWindow {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.921 -0400", hash_original_field = "FFEFB75A0F9FEAB417F471653D590355", hash_generated_field = "73AFFA24F24539E576EC15DD4CDCD19C")

        private WeakReference<SurfaceView> mSurfaceView;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.921 -0400", hash_original_field = "14007EAED353F6DDFF3C1DA3BAB2E803", hash_generated_field = "42653608DC496806D049FEC5FE343B4C")

        int mCurWidth = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.921 -0400", hash_original_field = "5A0937958D4C2EDA36A1341FFE1B73F6", hash_generated_field = "A4245ADE78B2EC437A5483DD0C64E816")

        int mCurHeight = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.921 -0400", hash_original_method = "636A3C131A2E0F598D9E9841916F7C6A", hash_generated_method = "C467142DB8EFC51A87F6CBFE9326D247")
        public  MyWindow(SurfaceView surfaceView) {
            mSurfaceView = new WeakReference<SurfaceView>(surfaceView);
            // ---------- Original Method ----------
            //mSurfaceView = new WeakReference<SurfaceView>(surfaceView);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.922 -0400", hash_original_method = "C97B8379077214A326B52B9AC32750F8", hash_generated_method = "1D9A85B41E9B59DAA2962F843DC37A53")
        public void resized(int w, int h, Rect coveredInsets,
                Rect visibleInsets, boolean reportDraw, Configuration newConfig) {
            addTaint(newConfig.getTaint());
            addTaint(reportDraw);
            addTaint(visibleInsets.getTaint());
            addTaint(coveredInsets.getTaint());
            addTaint(h);
            addTaint(w);
            SurfaceView surfaceView = mSurfaceView.get();
    if(surfaceView != null)            
            {
    if(DEBUG){ }                surfaceView.mSurfaceLock.lock();
                try 
                {
    if(reportDraw)                    
                    {
                        surfaceView.mUpdateWindowNeeded = true;
                        surfaceView.mReportDrawNeeded = true;
                        surfaceView.mHandler.sendEmptyMessage(UPDATE_WINDOW_MSG);
                    } //End block
                    else
    if(surfaceView.mWinFrame.width() != w
                            || surfaceView.mWinFrame.height() != h)                    
                    {
                        surfaceView.mUpdateWindowNeeded = true;
                        surfaceView.mHandler.sendEmptyMessage(UPDATE_WINDOW_MSG);
                    } //End block
                } //End block
                finally 
                {
                    surfaceView.mSurfaceLock.unlock();
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.923 -0400", hash_original_method = "BE0716F4AD0CF82E07CDF7A02946EA01", hash_generated_method = "8DFBCE56B7B4A7917AC4BEE9870F8E58")
        public void dispatchAppVisibility(boolean visible) {
            addTaint(visible);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.923 -0400", hash_original_method = "9244563860F137FED28CE6F0E7AFA6B7", hash_generated_method = "362A3029662AE55AB7359794FA0C4782")
        public void dispatchGetNewSurface() {
            SurfaceView surfaceView = mSurfaceView.get();
    if(surfaceView != null)            
            {
                Message msg = surfaceView.mHandler.obtainMessage(GET_NEW_SURFACE_MSG);
                surfaceView.mHandler.sendMessage(msg);
            } //End block
            // ---------- Original Method ----------
            //SurfaceView surfaceView = mSurfaceView.get();
            //if (surfaceView != null) {
                //Message msg = surfaceView.mHandler.obtainMessage(GET_NEW_SURFACE_MSG);
                //surfaceView.mHandler.sendMessage(msg);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.923 -0400", hash_original_method = "76E66C458D6EE4887227CD5EB1B9C2E4", hash_generated_method = "06FDADF4A88FD06BDDFCD1EBF1A46969")
        public void windowFocusChanged(boolean hasFocus, boolean touchEnabled) {
            addTaint(touchEnabled);
            addTaint(hasFocus);
            // ---------- Original Method ----------
            //Log.w("SurfaceView", "Unexpected focus in surface: focus=" + hasFocus + ", touchEnabled=" + touchEnabled);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.923 -0400", hash_original_method = "FFE9D2CBC83B323644FA8C6DFE6F40CA", hash_generated_method = "9E1B88B9F5CFD832DDE372F9EEB87E36")
        public void executeCommand(String command, String parameters, ParcelFileDescriptor out) {
            addTaint(out.getTaint());
            addTaint(parameters.getTaint());
            addTaint(command.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.924 -0400", hash_original_field = "17C2FCA65BA409D2E301586963F3AB4A", hash_generated_field = "9B43E9AA5D64C04C9855106BA9F67D87")

    static private final String TAG = "SurfaceView";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.924 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "AC679AD647C8EB62DD459B8B7830EF02")

    static private final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.924 -0400", hash_original_field = "BF3275DE4C1DB046534CACF411AB989A", hash_generated_field = "2D52D591F7078D964DA3AE3FF0B678A8")

    static final int KEEP_SCREEN_ON_MSG = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.924 -0400", hash_original_field = "69AC27C120B24FC39F060EAC12D8163F", hash_generated_field = "921AAF60B1D7D413C64B8466E0451555")

    static final int GET_NEW_SURFACE_MSG = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:50.924 -0400", hash_original_field = "7277BE5D63C248CF093342EC93BA1EFD", hash_generated_field = "5118B77301D9A719E0B2FDF720426263")

    static final int UPDATE_WINDOW_MSG = 3;
}

