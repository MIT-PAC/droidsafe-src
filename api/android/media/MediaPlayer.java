package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.lang.ref.WeakReference;

public class MediaPlayer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.297 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.297 -0400", hash_original_field = "BE5CC207AA2102AA21E53D2B0759CBB6", hash_generated_field = "E4C872FF50935D400555417B96D7DB8B")

    private int mNativeSurfaceTexture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.297 -0400", hash_original_field = "2C8EB028354FAD28E406D94E97D80E98", hash_generated_field = "A6AFD67537F59D7EDA48AC0935CEB2EB")

    private int mListenerContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.297 -0400", hash_original_field = "81860DC8C5AA6AEFA5F2B79E06C56A49", hash_generated_field = "89B6C7956CC59129C12F3A4CE408B773")

    private SurfaceHolder mSurfaceHolder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "84210E3DC11AD387548B7B4521B43660", hash_generated_field = "2CC8C155682313371D14B1061F526A1E")

    private PowerManager.WakeLock mWakeLock = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "7DFC8C8A6C6CBDAFC46C16D404AF05DA", hash_generated_field = "B2A729676011F53A18FA54544A74160B")

    private boolean mScreenOnWhilePlaying;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "13AFE2ABC050EB3B4701EC47A6C3E8E2", hash_generated_field = "21432D6ADD88A429FB2470D3D66606D0")

    private boolean mStayAwake;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "A5799EF941029779B8612CAB38609700", hash_generated_field = "A2852387273CF168455EF7C99DC77C4A")

    private OnPreparedListener mOnPreparedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "58EDA864F1A796AFB176C7FB07AA20E0", hash_generated_field = "EC9BCCBF3C86489E298221F5D4476C58")

    private OnCompletionListener mOnCompletionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "CD010591D4F50D2ADF2DA8FA035729D1", hash_generated_field = "0091D0B159C1300DEBA144C3752FC48B")

    private OnBufferingUpdateListener mOnBufferingUpdateListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "CE3F8CE2BAB7757A1EEE6E4E7808D2F9", hash_generated_field = "2403596CEA6AA0A7A2E7B136A5284A81")

    private OnSeekCompleteListener mOnSeekCompleteListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "A50AF1E7A30FF8806BB22C72726A6805", hash_generated_field = "8E3213E6DC01DA241A4C3F8027EB24E5")

    private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "DA5615FE1E343952031B4D8F420EF34F", hash_generated_field = "CF913FD08AF8A12FA8042BA315C5F119")

    private OnTimedTextListener mOnTimedTextListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "8E38E8F2821E37DC1388D37AC12A00C5", hash_generated_field = "16CDD39A55F7F6321E357628DB75DCA6")

    private OnErrorListener mOnErrorListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.298 -0400", hash_original_field = "A7BB806605AE0AF35AD87648479DCA6F", hash_generated_field = "1D3DA06942FC758771FAEF9EA193F57C")

    private OnInfoListener mOnInfoListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.299 -0400", hash_original_method = "2C929CFD6011D1A8428ADCC5A270A92B", hash_generated_method = "8DA16F0FDDAA594430FA29C4067A1254")
    public  MediaPlayer() {
        Looper looper;
    if((looper = Looper.myLooper()) != null)        
        {
            mEventHandler = new EventHandler(this, looper);
        } //End block
        else
    if((looper = Looper.getMainLooper()) != null)        
        {
            mEventHandler = new EventHandler(this, looper);
        } //End block
        else
        {
            mEventHandler = null;
        } //End block
        native_setup(new WeakReference<MediaPlayer>(this));
        // ---------- Original Method ----------
        //Looper looper;
        //if ((looper = Looper.myLooper()) != null) {
            //mEventHandler = new EventHandler(this, looper);
        //} else if ((looper = Looper.getMainLooper()) != null) {
            //mEventHandler = new EventHandler(this, looper);
        //} else {
            //mEventHandler = null;
        //}
        //native_setup(new WeakReference<MediaPlayer>(this));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.299 -0400", hash_original_method = "53B8A3255E430D9C87E415235A089C4A", hash_generated_method = "F5B57F3315662D3ED70CDAF04D4628F0")
    private void _setVideoSurface(Surface surface) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.300 -0400", hash_original_method = "9BA2A59C2D2CF14D2B23AE59BE37DCE6", hash_generated_method = "BED5BF27228423915D5B3DCB8412EBF1")
    public Parcel newRequest() {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken(IMEDIA_PLAYER);
Parcel varE1D9FB4EF23B2E2DCF7F61DDCE95DE0F_5384302 =         parcel;
        varE1D9FB4EF23B2E2DCF7F61DDCE95DE0F_5384302.addTaint(taint);
        return varE1D9FB4EF23B2E2DCF7F61DDCE95DE0F_5384302;
        // ---------- Original Method ----------
        //Parcel parcel = Parcel.obtain();
        //parcel.writeInterfaceToken(IMEDIA_PLAYER);
        //return parcel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.301 -0400", hash_original_method = "F1F9A39481AD241B93A7EFA7B112C8A9", hash_generated_method = "FA170D2281C1BE9B3A477511C30A93F3")
    public int invoke(Parcel request, Parcel reply) {
        addTaint(reply.getTaint());
        addTaint(request.getTaint());
        int retcode = native_invoke(request, reply);
        reply.setDataPosition(0);
        int var038970C09BCC57B17734FF8598F974F2_1782713117 = (retcode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100120616 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100120616;
        // ---------- Original Method ----------
        //int retcode = native_invoke(request, reply);
        //reply.setDataPosition(0);
        //return retcode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.301 -0400", hash_original_method = "936E4BA5EFE5EFD7E502D57ADB83F5AB", hash_generated_method = "6A9417EBF36FA135328DF0ACE51C8F1E")
    public void setDisplay(SurfaceHolder sh) {
        mSurfaceHolder = sh;
        Surface surface;
    if(sh != null)        
        {
            surface = sh.getSurface();
        } //End block
        else
        {
            surface = null;
        } //End block
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
        // ---------- Original Method ----------
        //mSurfaceHolder = sh;
        //Surface surface;
        //if (sh != null) {
            //surface = sh.getSurface();
        //} else {
            //surface = null;
        //}
        //_setVideoSurface(surface);
        //updateSurfaceScreenOn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.302 -0400", hash_original_method = "E1CEE3A46E058530408C5094E8A255A4", hash_generated_method = "796FA0F60902F4B58FB721B44A54DF97")
    public void setSurface(Surface surface) {
        addTaint(surface.getTaint());
    if(mScreenOnWhilePlaying && surface != null)        
        {
        } //End block
        mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
        // ---------- Original Method ----------
        //if (mScreenOnWhilePlaying && surface != null) {
            //Log.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        //}
        //mSurfaceHolder = null;
        //_setVideoSurface(surface);
        //updateSurfaceScreenOn();
    }

    
        public static MediaPlayer create(Context context, Uri uri) {
        return create (context, uri, null);
    }

    
        public static MediaPlayer create(Context context, Uri uri, SurfaceHolder holder) {
        try {
            MediaPlayer mp = new MediaPlayer();
            mp.setDataSource(context, uri);
            if (holder != null) {
                mp.setDisplay(holder);
            }
            mp.prepare();
            return mp;
        } catch (IOException ex) {
            Log.d(TAG, "create failed:", ex);
        } catch (IllegalArgumentException ex) {
            Log.d(TAG, "create failed:", ex);
        } catch (SecurityException ex) {
            Log.d(TAG, "create failed:", ex);
        }
        return null;
    }

    
        public static MediaPlayer create(Context context, int resid) {
        try {
            AssetFileDescriptor afd = context.getResources().openRawResourceFd(resid);
            if (afd == null) return null;
            MediaPlayer mp = new MediaPlayer();
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mp.prepare();
            return mp;
        } catch (IOException ex) {
            Log.d(TAG, "create failed:", ex);
        } catch (IllegalArgumentException ex) {
            Log.d(TAG, "create failed:", ex);
        } catch (SecurityException ex) {
            Log.d(TAG, "create failed:", ex);
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.304 -0400", hash_original_method = "40ED5E4D3E36120D5E7C77AB85EB12F0", hash_generated_method = "BD51E02768AFE95BF00E0182B9B96EF5")
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        addTaint(uri.getTaint());
        addTaint(context.getTaint());
        setDataSource(context, uri, null);
        // ---------- Original Method ----------
        //setDataSource(context, uri, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.304 -0400", hash_original_method = "0C532A10BBEED73B371000A59C797624", hash_generated_method = "1C96CF47DD17B4F15FB7687BFB37E986")
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        addTaint(headers.getTaint());
        addTaint(uri.getTaint());
        addTaint(context.getTaint());
        String scheme = uri.getScheme();
    if(scheme == null || scheme.equals("file"))        
        {
            setDataSource(uri.getPath());
            return;
        } //End block
        AssetFileDescriptor fd = null;
        try 
        {
            ContentResolver resolver = context.getContentResolver();
            fd = resolver.openAssetFileDescriptor(uri, "r");
    if(fd == null)            
            {
                return;
            } //End block
    if(fd.getDeclaredLength() < 0)            
            {
                setDataSource(fd.getFileDescriptor());
            } //End block
            else
            {
                setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getDeclaredLength());
            } //End block
            return;
        } //End block
        catch (SecurityException ex)
        {
        } //End block
        catch (IOException ex)
        {
        } //End block
        finally 
        {
    if(fd != null)            
            {
                fd.close();
            } //End block
        } //End block
        Log.d(TAG, "Couldn't open file on client side, trying server side");
        setDataSource(uri.toString(), headers);
        return;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.305 -0400", hash_original_method = "70B5385C7A556D37595F97E42F2F2DFE", hash_generated_method = "F5B05B6380317717B89E41C25427E8C2")
    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.306 -0400", hash_original_method = "21A95B4BC3854510C509CF1B7B37D46D", hash_generated_method = "B66E39D2FD0B42F57DD4D003AAF76F23")
    public void setDataSource(String path, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        addTaint(headers.getTaint());
        addTaint(path.getTaint());
        String[] keys = null;
        String[] values = null;
    if(headers != null)        
        {
            keys = new String[headers.size()];
            values = new String[headers.size()];
            int i = 0;
for(Map.Entry<String, String> entry : headers.entrySet())
            {
                keys[i] = entry.getKey();
                values[i] = entry.getValue();
                ++i;
            } //End block
        } //End block
        _setDataSource(path, keys, values);
        // ---------- Original Method ----------
        //String[] keys = null;
        //String[] values = null;
        //if (headers != null) {
            //keys = new String[headers.size()];
            //values = new String[headers.size()];
            //int i = 0;
            //for (Map.Entry<String, String> entry: headers.entrySet()) {
                //keys[i] = entry.getKey();
                //values[i] = entry.getValue();
                //++i;
            //}
        //}
        //_setDataSource(path, keys, values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.306 -0400", hash_original_method = "35737102382ABAAE0A83F0ED650DE965", hash_generated_method = "1B2287D7576FA769D7F1C01F8D9C70AA")
    private void _setDataSource(
        String path, String[] keys, String[] values) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.306 -0400", hash_original_method = "67ED0EB071685F0AFDAFB2EFB1BC8776", hash_generated_method = "F6A7068555B881C8A804649D69AFDB67")
    public void setDataSource(FileDescriptor fd) throws IOException, IllegalArgumentException, IllegalStateException {
        addTaint(fd.getTaint());
        setDataSource(fd, 0, 0x7ffffffffffffffL);
        // ---------- Original Method ----------
        //setDataSource(fd, 0, 0x7ffffffffffffffL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.307 -0400", hash_original_method = "CF807E4C5554BB2848F7651782391DCD", hash_generated_method = "26CA4E702FD63E687650E57F874CD4B8")
    public void setDataSource(FileDescriptor fd, long offset, long length) throws IOException, IllegalArgumentException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.307 -0400", hash_original_method = "BE634EB7B5A47DD549B3D4698CE7CD0F", hash_generated_method = "E7E943D15349F05D8E6452080C3FE19C")
    public void prepare() throws IOException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.307 -0400", hash_original_method = "9BEAA7388253BD2C3E319E2E43B2453F", hash_generated_method = "953CE432DFBBEC63464F146F85A74F11")
    public void prepareAsync() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.307 -0400", hash_original_method = "40DE58868CCCFC32104AEA08DBC3B0CD", hash_generated_method = "8D9FC9E4EE85EF00796B52D423965C3C")
    public void start() throws IllegalStateException {
        stayAwake(true);
        _start();
        // ---------- Original Method ----------
        //stayAwake(true);
        //_start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.307 -0400", hash_original_method = "6DEDFC534300C5310A66033260D8A31E", hash_generated_method = "D1FE609F1EBAE49EEF1BACBB02C63952")
    private void _start() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.308 -0400", hash_original_method = "09E3A57706D9EF8F79E07C48FA7F3A4D", hash_generated_method = "50D137FD7257996CE996E4B7E4E11980")
    public void stop() throws IllegalStateException {
        stayAwake(false);
        _stop();
        // ---------- Original Method ----------
        //stayAwake(false);
        //_stop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.308 -0400", hash_original_method = "7A254901D3417D112F523A3CB4C0BACF", hash_generated_method = "E38D7EC8B95A05706550F50CD55A4851")
    private void _stop() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.308 -0400", hash_original_method = "857D1517B1757951DF038ED3088FF3B2", hash_generated_method = "9DD53ADFA67EFE3B90445FCC4D8F68C6")
    public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
        // ---------- Original Method ----------
        //stayAwake(false);
        //_pause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.308 -0400", hash_original_method = "3CFA64AA4FE31303B150AAAF6D2A439E", hash_generated_method = "85A230E7AF7EEA7FE619291D65BB2491")
    private void _pause() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.309 -0400", hash_original_method = "2C98FD0B2087D81FFC1D38F1403791EF", hash_generated_method = "06AFAF75EE750623A542728C6F12B554")
    public void setWakeMode(Context context, int mode) {
        addTaint(context.getTaint());
        boolean washeld = false;
    if(mWakeLock != null)        
        {
    if(mWakeLock.isHeld())            
            {
                washeld = true;
                mWakeLock.release();
            } //End block
            mWakeLock = null;
        } //End block
        PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(mode|PowerManager.ON_AFTER_RELEASE, MediaPlayer.class.getName());
        mWakeLock.setReferenceCounted(false);
    if(washeld)        
        {
            mWakeLock.acquire();
        } //End block
        // ---------- Original Method ----------
        //boolean washeld = false;
        //if (mWakeLock != null) {
            //if (mWakeLock.isHeld()) {
                //washeld = true;
                //mWakeLock.release();
            //}
            //mWakeLock = null;
        //}
        //PowerManager pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        //mWakeLock = pm.newWakeLock(mode|PowerManager.ON_AFTER_RELEASE, MediaPlayer.class.getName());
        //mWakeLock.setReferenceCounted(false);
        //if (washeld) {
            //mWakeLock.acquire();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.310 -0400", hash_original_method = "1D2643121E0BBACA918AEEFF16FB1665", hash_generated_method = "DC7BC558E6738B318DD0330215120E62")
    public void setScreenOnWhilePlaying(boolean screenOn) {
    if(mScreenOnWhilePlaying != screenOn)        
        {
    if(screenOn && mSurfaceHolder == null)            
            {
            } //End block
            mScreenOnWhilePlaying = screenOn;
            updateSurfaceScreenOn();
        } //End block
        // ---------- Original Method ----------
        //if (mScreenOnWhilePlaying != screenOn) {
            //if (screenOn && mSurfaceHolder == null) {
                //Log.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            //}
            //mScreenOnWhilePlaying = screenOn;
            //updateSurfaceScreenOn();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.310 -0400", hash_original_method = "02316AFDA0A1E822630D7CE99583BEE5", hash_generated_method = "E81B31E4072B6C9972042DCDB32723AD")
    private void stayAwake(boolean awake) {
    if(mWakeLock != null)        
        {
    if(awake && !mWakeLock.isHeld())            
            {
                mWakeLock.acquire();
            } //End block
            else
    if(!awake && mWakeLock.isHeld())            
            {
                mWakeLock.release();
            } //End block
        } //End block
        mStayAwake = awake;
        updateSurfaceScreenOn();
        // ---------- Original Method ----------
        //if (mWakeLock != null) {
            //if (awake && !mWakeLock.isHeld()) {
                //mWakeLock.acquire();
            //} else if (!awake && mWakeLock.isHeld()) {
                //mWakeLock.release();
            //}
        //}
        //mStayAwake = awake;
        //updateSurfaceScreenOn();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.311 -0400", hash_original_method = "D56BBB45DF467B2DAD5698BBF1920DD6", hash_generated_method = "1095DB7E71289C67CD32176EB14BB102")
    private void updateSurfaceScreenOn() {
    if(mSurfaceHolder != null)        
        {
            mSurfaceHolder.setKeepScreenOn(mScreenOnWhilePlaying && mStayAwake);
        } //End block
        // ---------- Original Method ----------
        //if (mSurfaceHolder != null) {
            //mSurfaceHolder.setKeepScreenOn(mScreenOnWhilePlaying && mStayAwake);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.311 -0400", hash_original_method = "33D5C83ED46D1CA5E488AF592A477814", hash_generated_method = "1176079568A1D7CE15A3127BF3E53D1D")
    public int getVideoWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436668441 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1436668441;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.311 -0400", hash_original_method = "AA8703DABD049C78A6839F5E3DDBB949", hash_generated_method = "599B9FDFBF2A332511F2FB13B4D7712D")
    public int getVideoHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901892713 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1901892713;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.311 -0400", hash_original_method = "F383FE244E24C0C545B5D975B4462316", hash_generated_method = "5BBD80285A5EEC249D7B7E7A1D24B033")
    public boolean isPlaying() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_382980376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_382980376;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.312 -0400", hash_original_method = "97A3BCAAD25A5F0CCA6DBA135F05FFD4", hash_generated_method = "9C09E9E38768EBB3BE88E178DF59A105")
    public void seekTo(int msec) throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.312 -0400", hash_original_method = "540585A22AA6C1E9C18EA05D71ACEBDE", hash_generated_method = "345045D3817606856C71239CD5FE7D84")
    public int getCurrentPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729969722 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729969722;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.312 -0400", hash_original_method = "5FCC06EDC9BF2D1AEA92A44CF2A2F31E", hash_generated_method = "4F55CE986FCE430DEF6DE8167732A09B")
    public int getDuration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017827264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1017827264;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.313 -0400", hash_original_method = "62D59DE780FDA113D7200968BD4DD768", hash_generated_method = "88837C78F593A4F30C3D761963AC2CBC")
    public Metadata getMetadata(final boolean update_only,
                                final boolean apply_filter) {
        addTaint(apply_filter);
        addTaint(update_only);
        Parcel reply = Parcel.obtain();
        Metadata data = new Metadata();
    if(!native_getMetadata(update_only, apply_filter, reply))        
        {
            reply.recycle();
Metadata var540C13E9E156B687226421B24F2DF178_99602171 =             null;
            var540C13E9E156B687226421B24F2DF178_99602171.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_99602171;
        } //End block
    if(!data.parse(reply))        
        {
            reply.recycle();
Metadata var540C13E9E156B687226421B24F2DF178_324358686 =             null;
            var540C13E9E156B687226421B24F2DF178_324358686.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_324358686;
        } //End block
Metadata var0C8B2C9585EB05DD9CD70726CF8CBC07_671283680 =         data;
        var0C8B2C9585EB05DD9CD70726CF8CBC07_671283680.addTaint(taint);
        return var0C8B2C9585EB05DD9CD70726CF8CBC07_671283680;
        // ---------- Original Method ----------
        //Parcel reply = Parcel.obtain();
        //Metadata data = new Metadata();
        //if (!native_getMetadata(update_only, apply_filter, reply)) {
            //reply.recycle();
            //return null;
        //}
        //if (!data.parse(reply)) {
            //reply.recycle();
            //return null;
        //}
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.313 -0400", hash_original_method = "B0BBED6481EDE7F10FEA4CF182EBE3D1", hash_generated_method = "E4F43187770632DF0ADEBD313A809778")
    public int setMetadataFilter(Set<Integer> allow, Set<Integer> block) {
        addTaint(block.getTaint());
        addTaint(allow.getTaint());
        Parcel request = newRequest();
        int capacity = request.dataSize() + 4 * (1 + allow.size() + 1 + block.size());
    if(request.dataCapacity() < capacity)        
        {
            request.setDataCapacity(capacity);
        } //End block
        request.writeInt(allow.size());
for(Integer t : allow)
        {
            request.writeInt(t);
        } //End block
        request.writeInt(block.size());
for(Integer t : block)
        {
            request.writeInt(t);
        } //End block
        int var830512877C789BCE8F8A9D83241BA841_36900800 = (native_setMetadataFilter(request));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905384977 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_905384977;
        // ---------- Original Method ----------
        //Parcel request =  newRequest();
        //int capacity = request.dataSize() + 4 * (1 + allow.size() + 1 + block.size());
        //if (request.dataCapacity() < capacity) {
            //request.setDataCapacity(capacity);
        //}
        //request.writeInt(allow.size());
        //for(Integer t: allow) {
            //request.writeInt(t);
        //}
        //request.writeInt(block.size());
        //for(Integer t: block) {
            //request.writeInt(t);
        //}
        //return native_setMetadataFilter(request);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.314 -0400", hash_original_method = "40ADFE91226CE43AA5B2CBEBA3591229", hash_generated_method = "BB9AD88E0EDF8FF01039518B20FC95A4")
    public void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        mOnPreparedListener = null;
        mOnBufferingUpdateListener = null;
        mOnCompletionListener = null;
        mOnSeekCompleteListener = null;
        mOnErrorListener = null;
        mOnInfoListener = null;
        mOnVideoSizeChangedListener = null;
        mOnTimedTextListener = null;
        _release();
        // ---------- Original Method ----------
        //stayAwake(false);
        //updateSurfaceScreenOn();
        //mOnPreparedListener = null;
        //mOnBufferingUpdateListener = null;
        //mOnCompletionListener = null;
        //mOnSeekCompleteListener = null;
        //mOnErrorListener = null;
        //mOnInfoListener = null;
        //mOnVideoSizeChangedListener = null;
        //mOnTimedTextListener = null;
        //_release();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.315 -0400", hash_original_method = "D6ED0B9EBF82A338F6093204ADC2E481", hash_generated_method = "AA5F59E16F2B6AC2DE4549F16EAF4890")
    private void _release() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.315 -0400", hash_original_method = "0163217153F6E824039D5121A760EBE0", hash_generated_method = "2954E9520438919A7ABC834FCE4C8288")
    public void reset() {
        stayAwake(false);
        _reset();
        mEventHandler.removeCallbacksAndMessages(null);
        // ---------- Original Method ----------
        //stayAwake(false);
        //_reset();
        //mEventHandler.removeCallbacksAndMessages(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.315 -0400", hash_original_method = "3FFFF13DAAD4B409C984414CD8318D6D", hash_generated_method = "3553160F21F5CD09799179A1C4084CF0")
    private void _reset() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.315 -0400", hash_original_method = "7EA0CD9F896B971C851CD4CA96BFE5FA", hash_generated_method = "99A0AEB1474BFA8AD85F70AF19D36753")
    public void setAudioStreamType(int streamtype) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.316 -0400", hash_original_method = "4C3A78CA2E07F71A05B213D4CFF64128", hash_generated_method = "0C49790A1DD7D1A295D28EB1B65DC925")
    public void setLooping(boolean looping) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.316 -0400", hash_original_method = "0D67125EE341895F5558E4CEF076C5C6", hash_generated_method = "E9AFB64D6287829004ADA34B1AF7E295")
    public boolean isLooping() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_928028193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_928028193;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.316 -0400", hash_original_method = "BE4EAA7A7DB479C280C8B84C90E58238", hash_generated_method = "D76177723C9C7B83B2B950CDE7DB2CDA")
    public void setVolume(float leftVolume, float rightVolume) {
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:36.387 -0400", hash_original_method = "E7BF05B3622AAF2F5F3BF2C4557A0B3B", hash_generated_method = "BE7FFC2E098F8066660793B3DA145138")
    public Bitmap getFrameAt(int msec) throws IllegalStateException {
        Bitmap bm = new Bitmap();
        bm.addTaint(this.taint);
        return bm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.317 -0400", hash_original_method = "63928D15D2C6CC99F2E8386267D06FF3", hash_generated_method = "90A8FC942E771DDCEC53B1C3A67572F9")
    public void setAudioSessionId(int sessionId) throws IllegalArgumentException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.317 -0400", hash_original_method = "A9F7BB2486256FFAA61FE97D99C9B85E", hash_generated_method = "C240D4226C6057B44FB0F98AF045A917")
    public int getAudioSessionId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072000340 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1072000340;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.317 -0400", hash_original_method = "267B75456E03BDFBAB6FC1F227BFBD27", hash_generated_method = "308855D822BAB31E9E5D0F3584415B59")
    public void attachAuxEffect(int effectId) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.318 -0400", hash_original_method = "4D1DAD410063C63E8C280A1116B73E03", hash_generated_method = "A661988F25917D0D8693F4930F0533A8")
    public boolean setParameter(int key, Parcel value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1820334070 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1820334070;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.318 -0400", hash_original_method = "007895DA6F9E8604D81FFE810C3D87FB", hash_generated_method = "2E89917925039CE64DA0E18C665515FF")
    public boolean setParameter(int key, String value) {
        addTaint(value.getTaint());
        addTaint(key);
        Parcel p = Parcel.obtain();
        p.writeString(value);
        boolean ret = setParameter(key, p);
        p.recycle();
        boolean var2CB9DF9898E55FD0AD829DC202DDBD1C_880766874 = (ret);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1958015774 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1958015774;
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //p.writeString(value);
        //boolean ret = setParameter(key, p);
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.318 -0400", hash_original_method = "42E72BE22D4EC0A8F92EA2FFF9A1B8CD", hash_generated_method = "7D5AAB78066DCD0CEE10A11DE617D012")
    public boolean setParameter(int key, int value) {
        addTaint(value);
        addTaint(key);
        Parcel p = Parcel.obtain();
        p.writeInt(value);
        boolean ret = setParameter(key, p);
        p.recycle();
        boolean var2CB9DF9898E55FD0AD829DC202DDBD1C_1459387319 = (ret);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2040873231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2040873231;
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //p.writeInt(value);
        //boolean ret = setParameter(key, p);
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.319 -0400", hash_original_method = "331C8FC44967717E7E0670FCEDE9BFD0", hash_generated_method = "7FD7F9F0D2267E4E3D8F33E6B3FB173B")
    private void getParameter(int key, Parcel reply) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.319 -0400", hash_original_method = "5EBE9A62BAE86EE2E5C065958EFCD9CF", hash_generated_method = "233482B11B5C5FE32F0514C3DEF83062")
    public Parcel getParcelParameter(int key) {
        addTaint(key);
        Parcel p = Parcel.obtain();
        getParameter(key, p);
Parcel var74E4690D9F2A026504928C017944E149_779931954 =         p;
        var74E4690D9F2A026504928C017944E149_779931954.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_779931954;
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //getParameter(key, p);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.319 -0400", hash_original_method = "E362F946FCE7F90CCCD629666B73E43A", hash_generated_method = "E95EB6F2D671EC033AB2306F4FDEF129")
    public String getStringParameter(int key) {
        addTaint(key);
        Parcel p = Parcel.obtain();
        getParameter(key, p);
        String ret = p.readString();
        p.recycle();
String varEDFF4FBBF053B5DC2B444ADFA049EE0F_2027771813 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_2027771813.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_2027771813;
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //getParameter(key, p);
        //String ret = p.readString();
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.320 -0400", hash_original_method = "6CEECAB43DB86BAC5EC65D39A3A924D5", hash_generated_method = "5201C351CD3D1EAB1EE7E42F39CE7741")
    public int getIntParameter(int key) {
        addTaint(key);
        Parcel p = Parcel.obtain();
        getParameter(key, p);
        int ret = p.readInt();
        p.recycle();
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_330576938 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720108651 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1720108651;
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //getParameter(key, p);
        //int ret = p.readInt();
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.320 -0400", hash_original_method = "D28173AB681B94731B1FF3947E2DFEF3", hash_generated_method = "672F3C0FD3FDB80EEF14F3C255A04A14")
    public void setAuxEffectSendLevel(float level) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.320 -0400", hash_original_method = "4B4989130AC0D9F13A471859CBC524C2", hash_generated_method = "1D43091B7F7DC60BAD3F360AE01645D3")
    private final int native_invoke(Parcel request, Parcel reply) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814285865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_814285865;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.320 -0400", hash_original_method = "226F7D6B434A382FD3304895D8BD3523", hash_generated_method = "79D7D9AFAEC3CF339BEE77C8106A19DB")
    private final boolean native_getMetadata(boolean update_only,
                                                    boolean apply_filter,
                                                    Parcel reply) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120070663 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120070663;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.321 -0400", hash_original_method = "DFB5479CBB8EF2503AE55C0DE7F21BA6", hash_generated_method = "3459234C7A561C7A58D7CFE4F2A11EF1")
    private final int native_setMetadataFilter(Parcel request) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143167605 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143167605;
    }

    
    private static final void native_init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.321 -0400", hash_original_method = "B3ECC5C677CF7E418546A8C45CAC4774", hash_generated_method = "4DE4A52F106E1BB4613AFE97E9519CEB")
    private final void native_setup(Object mediaplayer_this) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.321 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "BE94CB6DE9EDBEEF7D151AA52A7096EC")
    private final void native_finalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.322 -0400", hash_original_method = "BB295A571473D1F777DD0CCBCDDABC95", hash_generated_method = "8CE91083B75D7C2D19B205EDB4F32870")
    public boolean enableTimedTextTrackIndex(int index) {
        addTaint(index);
    if(index < 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_587895448 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1665889666 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1665889666;
        } //End block
        boolean var0609CF9757C146007CCA7E7D3D953696_250167530 = (setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, index));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1739485402 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1739485402;
        // ---------- Original Method ----------
        //if (index < 0) {
            //return false;
        //}
        //return setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.322 -0400", hash_original_method = "74C1C7D2920140BDBE1C5FB72709063E", hash_generated_method = "08A8FC73BAFE5730075149BBDE84A493")
    public boolean enableTimedText() {
        boolean varA25F83339352E8D1308780CF786FBF5C_1736561660 = (enableTimedTextTrackIndex(0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_180620851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_180620851;
        // ---------- Original Method ----------
        //return enableTimedTextTrackIndex(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.322 -0400", hash_original_method = "D4D5A570D263843DA145431C05408526", hash_generated_method = "749E95F64ABF70EBA1CFC832701C62E1")
    public boolean disableTimedText() {
        boolean varBF138E6E82C5C2C93AC9D2604652D7B0_401946604 = (setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, -1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_69801826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_69801826;
        // ---------- Original Method ----------
        //return setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, -1);
    }

    
    @DSModeled(DSC.SAFE)
    public static int native_pullBatteryData(Parcel reply) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814873156 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1814873156;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.323 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "50625AE6DF481AE64B3EB15F7175DFBD")
    @Override
    protected void finalize() {
        native_finalize();
        // ---------- Original Method ----------
        //native_finalize();
    }

    
        private static void postEventFromNative(Object mediaplayer_ref,
                                            int what, int arg1, int arg2, Object obj) {
        MediaPlayer mp = (MediaPlayer)((WeakReference)mediaplayer_ref).get();
        if (mp == null) {
            return;
        }
        if (mp.mEventHandler != null) {
            Message m = mp.mEventHandler.obtainMessage(what, arg1, arg2, obj);
            mp.mEventHandler.sendMessage(m);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.324 -0400", hash_original_method = "652A10B898FA76BB677D4E34679A7B5D", hash_generated_method = "987EBE7B07F0BFE0DA24DF93DF11B855")
    public void setOnPreparedListener(OnPreparedListener listener) {
        mOnPreparedListener = listener;
        // ---------- Original Method ----------
        //mOnPreparedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.325 -0400", hash_original_method = "6CC4251EDF834484FDBD6F0A122C65D9", hash_generated_method = "02AF5E76A57B14C22A8D31C1FD5DA3AF")
    public void setOnCompletionListener(OnCompletionListener listener) {
        mOnCompletionListener = listener;
        // ---------- Original Method ----------
        //mOnCompletionListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.325 -0400", hash_original_method = "DDA62D9965B414E96A3CCD5D800217D1", hash_generated_method = "0C9AB338C3C684416FAC16C098DF00A6")
    public void setOnBufferingUpdateListener(OnBufferingUpdateListener listener) {
        mOnBufferingUpdateListener = listener;
        // ---------- Original Method ----------
        //mOnBufferingUpdateListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.326 -0400", hash_original_method = "E6C283B9723E51C1AAC734ADC41F741F", hash_generated_method = "09F00DE120F67FA2E06D414F50C2147F")
    public void setOnSeekCompleteListener(OnSeekCompleteListener listener) {
        mOnSeekCompleteListener = listener;
        // ---------- Original Method ----------
        //mOnSeekCompleteListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.326 -0400", hash_original_method = "8379FC1073131EA9347F12938BFC14C4", hash_generated_method = "136130265E2833871182C75F9CC3334A")
    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {
        mOnVideoSizeChangedListener = listener;
        // ---------- Original Method ----------
        //mOnVideoSizeChangedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.326 -0400", hash_original_method = "EF2D264E164B28DBC06EEC6D3EBE8B23", hash_generated_method = "D337EF32E4653756194FC2A4088DE668")
    public void setOnTimedTextListener(OnTimedTextListener listener) {
        mOnTimedTextListener = listener;
        // ---------- Original Method ----------
        //mOnTimedTextListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.327 -0400", hash_original_method = "606EB06B64A07407B83CA5CBEBF309C3", hash_generated_method = "C60A0B1416D18FD751AE5692034CBEE5")
    public void setOnErrorListener(OnErrorListener listener) {
        mOnErrorListener = listener;
        // ---------- Original Method ----------
        //mOnErrorListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.327 -0400", hash_original_method = "4D9753A45AFF6F50F6DD9F2BE501A438", hash_generated_method = "CC22DF79C368D299CC0E0400ABB99A07")
    public void setOnInfoListener(OnInfoListener listener) {
        mOnInfoListener = listener;
        // ---------- Original Method ----------
        //mOnInfoListener = listener;
    }

    
    private class EventHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.327 -0400", hash_original_field = "69B00892DEC6EACEEA68FA7F3BC343FF", hash_generated_field = "8CCD253E1D8FDE10357015F7795C2D1A")

        private MediaPlayer mMediaPlayer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.328 -0400", hash_original_method = "9E040026EAD08DF6FC1B72FC06387530", hash_generated_method = "98A39D246D51104A2B093C0BA8238005")
        public  EventHandler(MediaPlayer mp, Looper looper) {
            super(looper);
            addTaint(looper.getTaint());
            mMediaPlayer = mp;
            // ---------- Original Method ----------
            //mMediaPlayer = mp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.329 -0400", hash_original_method = "D299385F381B46BF939056A8A39EEDB2", hash_generated_method = "895E811B527B5ABB363CAEB6EC86C437")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
    if(mMediaPlayer.mNativeContext == 0)            
            {
                return;
            } //End block
switch(msg.what){
            case MEDIA_PREPARED:
    if(mOnPreparedListener != null)            
            mOnPreparedListener.onPrepared(mMediaPlayer);
            return;
            case MEDIA_PLAYBACK_COMPLETE:
    if(mOnCompletionListener != null)            
            mOnCompletionListener.onCompletion(mMediaPlayer);
            stayAwake(false);
            return;
            case MEDIA_BUFFERING_UPDATE:
    if(mOnBufferingUpdateListener != null)            
            mOnBufferingUpdateListener.onBufferingUpdate(mMediaPlayer, msg.arg1);
            return;
            case MEDIA_SEEK_COMPLETE:
    if(mOnSeekCompleteListener != null)            
            mOnSeekCompleteListener.onSeekComplete(mMediaPlayer);
            return;
            case MEDIA_SET_VIDEO_SIZE:
    if(mOnVideoSizeChangedListener != null)            
            mOnVideoSizeChangedListener.onVideoSizeChanged(mMediaPlayer, msg.arg1, msg.arg2);
            return;
            case MEDIA_ERROR:
            boolean error_was_handled = false;
    if(mOnErrorListener != null)            
            {
                error_was_handled = mOnErrorListener.onError(mMediaPlayer, msg.arg1, msg.arg2);
            } //End block
    if(mOnCompletionListener != null && ! error_was_handled)            
            {
                mOnCompletionListener.onCompletion(mMediaPlayer);
            } //End block
            stayAwake(false);
            return;
            case MEDIA_INFO:
    if(msg.arg1 != MEDIA_INFO_VIDEO_TRACK_LAGGING)            
            {
            } //End block
    if(mOnInfoListener != null)            
            {
                mOnInfoListener.onInfo(mMediaPlayer, msg.arg1, msg.arg2);
            } //End block
            return;
            case MEDIA_TIMED_TEXT:
    if(mOnTimedTextListener != null)            
            {
    if(msg.obj == null)                
                {
                    mOnTimedTextListener.onTimedText(mMediaPlayer, null);
                } //End block
                else
                {
    if(msg.obj instanceof byte[])                    
                    {
                        TimedText text = new TimedText((byte[])(msg.obj));
                        mOnTimedTextListener.onTimedText(mMediaPlayer, text);
                    } //End block
                } //End block
            } //End block
            return;
            case MEDIA_NOP:
            break;
            default:
            return;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    public interface OnPreparedListener
    {
        
        void onPrepared(MediaPlayer mp);
    }
    
    public interface OnCompletionListener
    {
        
        void onCompletion(MediaPlayer mp);
    }
    
    public interface OnBufferingUpdateListener
    {
        
        void onBufferingUpdate(MediaPlayer mp, int percent);
    }
    
    public interface OnSeekCompleteListener
    {
        
        public void onSeekComplete(MediaPlayer mp);
    }
    
    public interface OnVideoSizeChangedListener
    {
        
        public void onVideoSizeChanged(MediaPlayer mp, int width, int height);
    }
    
    public interface OnTimedTextListener
    {
        
        public void onTimedText(MediaPlayer mp, TimedText text);
    }
    
    public interface OnErrorListener
    {
        
        boolean onError(MediaPlayer mp, int what, int extra);
    }
    
    public interface OnInfoListener
    {
        
        boolean onInfo(MediaPlayer mp, int what, int extra);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.329 -0400", hash_original_field = "2B81CAA02D7D1242F9852CAC7134355E", hash_generated_field = "E5A643B1D418726D99E5A8F3970E5556")

    public static final boolean METADATA_UPDATE_ONLY = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.329 -0400", hash_original_field = "29B52589B71C7315FE816A628FD45BF3", hash_generated_field = "C4299F59C35DA7B075841FA52A06DF72")

    public static final boolean METADATA_ALL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.329 -0400", hash_original_field = "A369572D94705B584ED4CA716EDD5076", hash_generated_field = "0F0666F4EEF61F70AF44DC91825D4969")

    public static final boolean APPLY_METADATA_FILTER = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.329 -0400", hash_original_field = "4C9106A4FF579D8CE23A8847FB979E36", hash_generated_field = "1049A3BBD43F92B7A4632827C73A789E")

    public static final boolean BYPASS_METADATA_FILTER = false;
    static {
        System.loadLibrary("media_jni");
        native_init();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "83EAA951DEEF1316171AE44680D58845", hash_generated_field = "8BF0B63CF7DC67F5CB722C0B4A64DFA2")

    private final static String TAG = "MediaPlayer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "8310AB953C210656B503D183BF619520", hash_generated_field = "85E132392948ED10488C46204A1804E7")

    private final static String IMEDIA_PLAYER = "android.media.IMediaPlayer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "064DFBA424C7213BE703E49094602A22", hash_generated_field = "72B9972522F0A2DD25E1C8FD3B68003B")

    private static final int KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "3BB3080855F2B67AF1E96703C7E48C71", hash_generated_field = "978C74E4442A5A8AD4D9D557896E347A")

    private static final int KEY_PARAMETER_TIMED_TEXT_ADD_OUT_OF_BAND_SOURCE = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "D4CDB0D2094A0C349AFF33AAAC0067FE", hash_generated_field = "7F291BAD9387D41B6A164A1BFA75315A")

    private static final int MEDIA_NOP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "4B24482E9D2C267C9A287EDE6F592111", hash_generated_field = "E329E69C41FA2733486EBCEC7C114412")

    private static final int MEDIA_PREPARED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "66F638BCC1FAA461C5CCB1A9E411CB1A", hash_generated_field = "B132F9D1D22009420456C651590B4249")

    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "8BCA2A9AE2629A0340DDE0FB82F3925C", hash_generated_field = "9CA74E4A66FE346F84987525C845EC7E")

    private static final int MEDIA_BUFFERING_UPDATE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "61346ACBC3C3E5C02A58E8C0B96BFBBA", hash_generated_field = "923E906B8ACFD14F8396ED27A8F08EDD")

    private static final int MEDIA_SEEK_COMPLETE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "647D37D7C30F0596F1729B1A0C3DD25F", hash_generated_field = "AB0BF930EEED5A3AD843B20DB5F3114D")

    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "4FA27E073FEA162B15FA3C4A1350185B", hash_generated_field = "0A95E910FACE7EC2BFA9D61726C0240D")

    private static final int MEDIA_TIMED_TEXT = 99;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.330 -0400", hash_original_field = "034B4E27C9934B7E5EE6F1D14C7DB69C", hash_generated_field = "5510672F996C033C929341BBDB0954D2")

    private static final int MEDIA_ERROR = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "A435AC6A8180A4DA12EA054862142CEA", hash_generated_field = "AD695ED20EBD55D4F24DCFBB2D7498FB")

    private static final int MEDIA_INFO = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "59B00BA0B25CB14099C620E1F88F8680", hash_generated_field = "2CACBDD6D4608C168454A86007B01373")

    public static final int MEDIA_ERROR_UNKNOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "8BFDCC551B6A7FA397ECE4FBF1A85AF2", hash_generated_field = "DB95F5B0F907621EE3C274E114EE5AD1")

    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "52671B78310C79F5F4B6B9C200F9B7DD", hash_generated_field = "06C2C428D805E0A67D6BAD19B365C91C")

    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "2D4ED1FD2E10E3B09D0872A64CB9F2D2", hash_generated_field = "D3589790B5B6A82CA9C075033A457158")

    public static final int MEDIA_INFO_UNKNOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "BAB185AF4B17E16BFC767F210973FFB0", hash_generated_field = "C514B988C6EE0C70B1A7903973F10397")

    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "C6DE574072A9069EEA2D5276349060CF", hash_generated_field = "C18AAAC03D3E808C49320185870D0BAE")

    public static final int MEDIA_INFO_BUFFERING_START = 701;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "933043B3A280FC833A7C7019B5FA6652", hash_generated_field = "607F18EB2223B97FD6DA02FA3195836F")

    public static final int MEDIA_INFO_BUFFERING_END = 702;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "54901B095B647A95572D625A2F5A86F4", hash_generated_field = "86017CADB92B26DE78EEC620504FE574")

    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "29698CC1BB7E71A5AB661E9D75748649", hash_generated_field = "06DD5F069EB77262680FEF74A227A7D4")

    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:24.331 -0400", hash_original_field = "C90DC7A69E9C2C6E88E44934A8A051B7", hash_generated_field = "A307F706DBE6E89451A83E6E4C58505E")

    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
}

