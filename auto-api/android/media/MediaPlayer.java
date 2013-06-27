package android.media;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.328 -0400", hash_original_field = "20E813A614226843849BF2E571A8EBCA", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.329 -0400", hash_original_field = "BE5CC207AA2102AA21E53D2B0759CBB6", hash_generated_field = "E4C872FF50935D400555417B96D7DB8B")

    private int mNativeSurfaceTexture;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.329 -0400", hash_original_field = "2C8EB028354FAD28E406D94E97D80E98", hash_generated_field = "A6AFD67537F59D7EDA48AC0935CEB2EB")

    private int mListenerContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.329 -0400", hash_original_field = "81860DC8C5AA6AEFA5F2B79E06C56A49", hash_generated_field = "89B6C7956CC59129C12F3A4CE408B773")

    private SurfaceHolder mSurfaceHolder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.329 -0400", hash_original_field = "3487E63080D45B4AAFB4C377AC2DEA9F", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.329 -0400", hash_original_field = "84210E3DC11AD387548B7B4521B43660", hash_generated_field = "2CC8C155682313371D14B1061F526A1E")

    private PowerManager.WakeLock mWakeLock = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.329 -0400", hash_original_field = "7DFC8C8A6C6CBDAFC46C16D404AF05DA", hash_generated_field = "B2A729676011F53A18FA54544A74160B")

    private boolean mScreenOnWhilePlaying;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.329 -0400", hash_original_field = "13AFE2ABC050EB3B4701EC47A6C3E8E2", hash_generated_field = "21432D6ADD88A429FB2470D3D66606D0")

    private boolean mStayAwake;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.329 -0400", hash_original_field = "A5799EF941029779B8612CAB38609700", hash_generated_field = "A2852387273CF168455EF7C99DC77C4A")

    private OnPreparedListener mOnPreparedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.330 -0400", hash_original_field = "58EDA864F1A796AFB176C7FB07AA20E0", hash_generated_field = "EC9BCCBF3C86489E298221F5D4476C58")

    private OnCompletionListener mOnCompletionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.330 -0400", hash_original_field = "CD010591D4F50D2ADF2DA8FA035729D1", hash_generated_field = "0091D0B159C1300DEBA144C3752FC48B")

    private OnBufferingUpdateListener mOnBufferingUpdateListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.330 -0400", hash_original_field = "CE3F8CE2BAB7757A1EEE6E4E7808D2F9", hash_generated_field = "2403596CEA6AA0A7A2E7B136A5284A81")

    private OnSeekCompleteListener mOnSeekCompleteListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.330 -0400", hash_original_field = "A50AF1E7A30FF8806BB22C72726A6805", hash_generated_field = "8E3213E6DC01DA241A4C3F8027EB24E5")

    private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.330 -0400", hash_original_field = "DA5615FE1E343952031B4D8F420EF34F", hash_generated_field = "CF913FD08AF8A12FA8042BA315C5F119")

    private OnTimedTextListener mOnTimedTextListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.330 -0400", hash_original_field = "8E38E8F2821E37DC1388D37AC12A00C5", hash_generated_field = "16CDD39A55F7F6321E357628DB75DCA6")

    private OnErrorListener mOnErrorListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.330 -0400", hash_original_field = "A7BB806605AE0AF35AD87648479DCA6F", hash_generated_field = "1D3DA06942FC758771FAEF9EA193F57C")

    private OnInfoListener mOnInfoListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.341 -0400", hash_original_method = "2C929CFD6011D1A8428ADCC5A270A92B", hash_generated_method = "31268132C69D052F2F7ED06F25E03E2A")
    public  MediaPlayer() {
        Looper looper;
        {
            boolean var59AC82EBCD14E4AA50598F2AE3563759_1741776054 = ((looper = Looper.myLooper()) != null);
            {
                mEventHandler = new EventHandler(this, looper);
            } //End block
            {
                boolean var9D854D75870272BF06142F5CE681F893_1683948407 = ((looper = Looper.getMainLooper()) != null);
                {
                    mEventHandler = new EventHandler(this, looper);
                } //End block
                {
                    mEventHandler = null;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.366 -0400", hash_original_method = "53B8A3255E430D9C87E415235A089C4A", hash_generated_method = "F5B57F3315662D3ED70CDAF04D4628F0")
    private void _setVideoSurface(Surface surface) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.367 -0400", hash_original_method = "9BA2A59C2D2CF14D2B23AE59BE37DCE6", hash_generated_method = "5A72F992A58DB60CB29AB29A778E9353")
    public Parcel newRequest() {
        Parcel varB4EAC82CA7396A68D541C85D26508E83_1343051289 = null; //Variable for return #1
        Parcel parcel;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken(IMEDIA_PLAYER);
        varB4EAC82CA7396A68D541C85D26508E83_1343051289 = parcel;
        varB4EAC82CA7396A68D541C85D26508E83_1343051289.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1343051289;
        // ---------- Original Method ----------
        //Parcel parcel = Parcel.obtain();
        //parcel.writeInterfaceToken(IMEDIA_PLAYER);
        //return parcel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.368 -0400", hash_original_method = "F1F9A39481AD241B93A7EFA7B112C8A9", hash_generated_method = "BC22B23558DE56AF409BBC910730B7C0")
    public int invoke(Parcel request, Parcel reply) {
        int retcode;
        retcode = native_invoke(request, reply);
        reply.setDataPosition(0);
        addTaint(request.getTaint());
        addTaint(reply.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1779323476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1779323476;
        // ---------- Original Method ----------
        //int retcode = native_invoke(request, reply);
        //reply.setDataPosition(0);
        //return retcode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.378 -0400", hash_original_method = "936E4BA5EFE5EFD7E502D57ADB83F5AB", hash_generated_method = "E41C33BC8B5BC23C0AE48B7607536F4B")
    public void setDisplay(SurfaceHolder sh) {
        mSurfaceHolder = sh;
        Surface surface;
        {
            surface = sh.getSurface();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.379 -0400", hash_original_method = "E1CEE3A46E058530408C5094E8A255A4", hash_generated_method = "71983594FBC4B97967AE8001EE1A2DE8")
    public void setSurface(Surface surface) {
        mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
        addTaint(surface.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.380 -0400", hash_original_method = "40ED5E4D3E36120D5E7C77AB85EB12F0", hash_generated_method = "C7387BE2C99D08D494CD2A9F15D71D68")
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        setDataSource(context, uri, null);
        addTaint(context.getTaint());
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //setDataSource(context, uri, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.386 -0400", hash_original_method = "0C532A10BBEED73B371000A59C797624", hash_generated_method = "E4BBB69863CE08F842FBC8A245AB4083")
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String scheme;
        scheme = uri.getScheme();
        {
            boolean varB783BCB76216B10372231D3D68484DB8_521776404 = (scheme == null || scheme.equals("file"));
            {
                setDataSource(uri.getPath());
            } //End block
        } //End collapsed parenthetic
        AssetFileDescriptor fd;
        fd = null;
        try 
        {
            ContentResolver resolver;
            resolver = context.getContentResolver();
            fd = resolver.openAssetFileDescriptor(uri, "r");
            {
                boolean var761F6419C241ADD42691E3D2E85CB236_2095717589 = (fd.getDeclaredLength() < 0);
                {
                    setDataSource(fd.getFileDescriptor());
                } //End block
                {
                    setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getDeclaredLength());
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (SecurityException ex)
        { }
        catch (IOException ex)
        { }
        finally 
        {
            {
                fd.close();
            } //End block
        } //End block
        Log.d(TAG, "Couldn't open file on client side, trying server side");
        setDataSource(uri.toString(), headers);
        addTaint(context.getTaint());
        addTaint(uri.getTaint());
        addTaint(headers.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.414 -0400", hash_original_method = "70B5385C7A556D37595F97E42F2F2DFE", hash_generated_method = "F5B05B6380317717B89E41C25427E8C2")
    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.493 -0400", hash_original_method = "21A95B4BC3854510C509CF1B7B37D46D", hash_generated_method = "642D0B544EF8E568B14444226A7AFDD4")
    public void setDataSource(String path, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        String[] keys;
        keys = null;
        String[] values;
        values = null;
        {
            keys = new String[headers.size()];
            values = new String[headers.size()];
            int i;
            i = 0;
            {
                Iterator<Map.Entry<String, String>> var837775D5302415DDC2678074F3242FEF_1766977710 = (headers.entrySet()).iterator();
                var837775D5302415DDC2678074F3242FEF_1766977710.hasNext();
                Map.Entry<String, String> entry = var837775D5302415DDC2678074F3242FEF_1766977710.next();
                {
                    keys[i] = entry.getKey();
                    values[i] = entry.getValue();
                } //End block
            } //End collapsed parenthetic
        } //End block
        _setDataSource(path, keys, values);
        addTaint(path.getTaint());
        addTaint(headers.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.494 -0400", hash_original_method = "35737102382ABAAE0A83F0ED650DE965", hash_generated_method = "1B2287D7576FA769D7F1C01F8D9C70AA")
    private void _setDataSource(
        String path, String[] keys, String[] values) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.511 -0400", hash_original_method = "67ED0EB071685F0AFDAFB2EFB1BC8776", hash_generated_method = "5D3A3595104E286D34512CD6C49A5333")
    public void setDataSource(FileDescriptor fd) throws IOException, IllegalArgumentException, IllegalStateException {
        setDataSource(fd, 0, 0x7ffffffffffffffL);
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
        //setDataSource(fd, 0, 0x7ffffffffffffffL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.512 -0400", hash_original_method = "CF807E4C5554BB2848F7651782391DCD", hash_generated_method = "26CA4E702FD63E687650E57F874CD4B8")
    public void setDataSource(FileDescriptor fd, long offset, long length) throws IOException, IllegalArgumentException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.512 -0400", hash_original_method = "BE634EB7B5A47DD549B3D4698CE7CD0F", hash_generated_method = "E7E943D15349F05D8E6452080C3FE19C")
    public void prepare() throws IOException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.513 -0400", hash_original_method = "9BEAA7388253BD2C3E319E2E43B2453F", hash_generated_method = "953CE432DFBBEC63464F146F85A74F11")
    public void prepareAsync() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.513 -0400", hash_original_method = "40DE58868CCCFC32104AEA08DBC3B0CD", hash_generated_method = "8D9FC9E4EE85EF00796B52D423965C3C")
    public void start() throws IllegalStateException {
        stayAwake(true);
        _start();
        // ---------- Original Method ----------
        //stayAwake(true);
        //_start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.523 -0400", hash_original_method = "6DEDFC534300C5310A66033260D8A31E", hash_generated_method = "D1FE609F1EBAE49EEF1BACBB02C63952")
    private void _start() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.538 -0400", hash_original_method = "09E3A57706D9EF8F79E07C48FA7F3A4D", hash_generated_method = "50D137FD7257996CE996E4B7E4E11980")
    public void stop() throws IllegalStateException {
        stayAwake(false);
        _stop();
        // ---------- Original Method ----------
        //stayAwake(false);
        //_stop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.538 -0400", hash_original_method = "7A254901D3417D112F523A3CB4C0BACF", hash_generated_method = "E38D7EC8B95A05706550F50CD55A4851")
    private void _stop() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.539 -0400", hash_original_method = "857D1517B1757951DF038ED3088FF3B2", hash_generated_method = "9DD53ADFA67EFE3B90445FCC4D8F68C6")
    public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
        // ---------- Original Method ----------
        //stayAwake(false);
        //_pause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.539 -0400", hash_original_method = "3CFA64AA4FE31303B150AAAF6D2A439E", hash_generated_method = "85A230E7AF7EEA7FE619291D65BB2491")
    private void _pause() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.550 -0400", hash_original_method = "2C98FD0B2087D81FFC1D38F1403791EF", hash_generated_method = "CE7CED1F6B2FD3AFA7EF4B233C45F3EA")
    public void setWakeMode(Context context, int mode) {
        boolean washeld;
        washeld = false;
        {
            {
                boolean varA10E0F7CBE89603E5C4D8E437932CB2B_1898552669 = (mWakeLock.isHeld());
                {
                    washeld = true;
                    mWakeLock.release();
                } //End block
            } //End collapsed parenthetic
            mWakeLock = null;
        } //End block
        PowerManager pm;
        pm = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(mode|PowerManager.ON_AFTER_RELEASE, MediaPlayer.class.getName());
        mWakeLock.setReferenceCounted(false);
        {
            mWakeLock.acquire();
        } //End block
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.567 -0400", hash_original_method = "1D2643121E0BBACA918AEEFF16FB1665", hash_generated_method = "795B34F115D3ED8438F49191DBD317B1")
    public void setScreenOnWhilePlaying(boolean screenOn) {
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.568 -0400", hash_original_method = "02316AFDA0A1E822630D7CE99583BEE5", hash_generated_method = "F06BD803781F5C8E0FEF67629E09E3EA")
    private void stayAwake(boolean awake) {
        {
            {
                boolean var2AF05387B6FE9C5F416A6EC845CFCE19_2128174535 = (awake && !mWakeLock.isHeld());
                {
                    mWakeLock.acquire();
                } //End block
                {
                    boolean var5AEF773A774AC1175FEC7C5357C07830_665717288 = (!awake && mWakeLock.isHeld());
                    {
                        mWakeLock.release();
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.581 -0400", hash_original_method = "D56BBB45DF467B2DAD5698BBF1920DD6", hash_generated_method = "10DE4749CDD3C23C1A28F71467D50BD5")
    private void updateSurfaceScreenOn() {
        {
            mSurfaceHolder.setKeepScreenOn(mScreenOnWhilePlaying && mStayAwake);
        } //End block
        // ---------- Original Method ----------
        //if (mSurfaceHolder != null) {
            //mSurfaceHolder.setKeepScreenOn(mScreenOnWhilePlaying && mStayAwake);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.582 -0400", hash_original_method = "33D5C83ED46D1CA5E488AF592A477814", hash_generated_method = "CFE3BE8D801E36A199CF161EE3CB73EC")
    public int getVideoWidth() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312037504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312037504;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.583 -0400", hash_original_method = "AA8703DABD049C78A6839F5E3DDBB949", hash_generated_method = "2E791D81058013DBE38F3D23BE3C1A31")
    public int getVideoHeight() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966776651 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_966776651;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.584 -0400", hash_original_method = "F383FE244E24C0C545B5D975B4462316", hash_generated_method = "9F2380F7487CA21F7AA42AEB91390CD0")
    public boolean isPlaying() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1998986265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1998986265;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.590 -0400", hash_original_method = "97A3BCAAD25A5F0CCA6DBA135F05FFD4", hash_generated_method = "9C09E9E38768EBB3BE88E178DF59A105")
    public void seekTo(int msec) throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.610 -0400", hash_original_method = "540585A22AA6C1E9C18EA05D71ACEBDE", hash_generated_method = "E6986F1860AEE7F0590ED6EDC15EEF03")
    public int getCurrentPosition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396310808 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_396310808;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.610 -0400", hash_original_method = "5FCC06EDC9BF2D1AEA92A44CF2A2F31E", hash_generated_method = "CA49A60C74D8EDC8CC796D7C3D1E086B")
    public int getDuration() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163260834 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163260834;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.624 -0400", hash_original_method = "62D59DE780FDA113D7200968BD4DD768", hash_generated_method = "892560168BCDB65D57B4E85456062D2E")
    public Metadata getMetadata(final boolean update_only,
                                final boolean apply_filter) {
        Metadata varB4EAC82CA7396A68D541C85D26508E83_435618008 = null; //Variable for return #1
        Metadata varB4EAC82CA7396A68D541C85D26508E83_712945870 = null; //Variable for return #2
        Metadata varB4EAC82CA7396A68D541C85D26508E83_2142617324 = null; //Variable for return #3
        Parcel reply;
        reply = Parcel.obtain();
        Metadata data;
        data = new Metadata();
        {
            boolean varE627D518551FE7C5957D927A36F80D7B_297848155 = (!native_getMetadata(update_only, apply_filter, reply));
            {
                reply.recycle();
                varB4EAC82CA7396A68D541C85D26508E83_435618008 = null;
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD5B0854FD3A7E24F478943612F0067D6_1215502954 = (!data.parse(reply));
            {
                reply.recycle();
                varB4EAC82CA7396A68D541C85D26508E83_712945870 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2142617324 = data;
        addTaint(update_only);
        addTaint(apply_filter);
        Metadata varA7E53CE21691AB073D9660D615818899_849011493; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_849011493 = varB4EAC82CA7396A68D541C85D26508E83_435618008;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_849011493 = varB4EAC82CA7396A68D541C85D26508E83_712945870;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_849011493 = varB4EAC82CA7396A68D541C85D26508E83_2142617324;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_849011493.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_849011493;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.747 -0400", hash_original_method = "B0BBED6481EDE7F10FEA4CF182EBE3D1", hash_generated_method = "D70296E4F3A779312935C12867173581")
    public int setMetadataFilter(Set<Integer> allow, Set<Integer> block) {
        Parcel request;
        request = newRequest();
        int capacity;
        capacity = request.dataSize() + 4 * (1 + allow.size() + 1 + block.size());
        {
            boolean var640875AB0A5247DF32010D4EDDB1E66D_263942814 = (request.dataCapacity() < capacity);
            {
                request.setDataCapacity(capacity);
            } //End block
        } //End collapsed parenthetic
        request.writeInt(allow.size());
        {
            Iterator<Integer> varC4C5C0703D00EC448346EFAF5E5FC39F_917520845 = (allow).iterator();
            varC4C5C0703D00EC448346EFAF5E5FC39F_917520845.hasNext();
            Integer t = varC4C5C0703D00EC448346EFAF5E5FC39F_917520845.next();
            {
                request.writeInt(t);
            } //End block
        } //End collapsed parenthetic
        request.writeInt(block.size());
        {
            Iterator<Integer> varFE3C5D648E83A09BB0DA5A5CD9C28882_405150903 = (block).iterator();
            varFE3C5D648E83A09BB0DA5A5CD9C28882_405150903.hasNext();
            Integer t = varFE3C5D648E83A09BB0DA5A5CD9C28882_405150903.next();
            {
                request.writeInt(t);
            } //End block
        } //End collapsed parenthetic
        int varCED2E107F0C63635B55997925961AC14_605772068 = (native_setMetadataFilter(request));
        addTaint(allow.getTaint());
        addTaint(block.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208855908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_208855908;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.749 -0400", hash_original_method = "40ADFE91226CE43AA5B2CBEBA3591229", hash_generated_method = "BB9AD88E0EDF8FF01039518B20FC95A4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.750 -0400", hash_original_method = "D6ED0B9EBF82A338F6093204ADC2E481", hash_generated_method = "AA5F59E16F2B6AC2DE4549F16EAF4890")
    private void _release() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.758 -0400", hash_original_method = "0163217153F6E824039D5121A760EBE0", hash_generated_method = "2954E9520438919A7ABC834FCE4C8288")
    public void reset() {
        stayAwake(false);
        _reset();
        mEventHandler.removeCallbacksAndMessages(null);
        // ---------- Original Method ----------
        //stayAwake(false);
        //_reset();
        //mEventHandler.removeCallbacksAndMessages(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.758 -0400", hash_original_method = "3FFFF13DAAD4B409C984414CD8318D6D", hash_generated_method = "3553160F21F5CD09799179A1C4084CF0")
    private void _reset() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.759 -0400", hash_original_method = "7EA0CD9F896B971C851CD4CA96BFE5FA", hash_generated_method = "99A0AEB1474BFA8AD85F70AF19D36753")
    public void setAudioStreamType(int streamtype) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.759 -0400", hash_original_method = "4C3A78CA2E07F71A05B213D4CFF64128", hash_generated_method = "0C49790A1DD7D1A295D28EB1B65DC925")
    public void setLooping(boolean looping) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.759 -0400", hash_original_method = "0D67125EE341895F5558E4CEF076C5C6", hash_generated_method = "48B74541F00B90656E3F514C85CDC0B1")
    public boolean isLooping() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1432708614 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1432708614;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.771 -0400", hash_original_method = "BE4EAA7A7DB479C280C8B84C90E58238", hash_generated_method = "D76177723C9C7B83B2B950CDE7DB2CDA")
    public void setVolume(float leftVolume, float rightVolume) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.772 -0400", hash_original_method = "E7BF05B3622AAF2F5F3BF2C4557A0B3B", hash_generated_method = "BE7FFC2E098F8066660793B3DA145138")
    public Bitmap getFrameAt(int msec) throws IllegalStateException {
        //DSFIXME: CODE0013:  Native method returns a complex type and requires manual reviews
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.776 -0400", hash_original_method = "63928D15D2C6CC99F2E8386267D06FF3", hash_generated_method = "90A8FC942E771DDCEC53B1C3A67572F9")
    public void setAudioSessionId(int sessionId) throws IllegalArgumentException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.778 -0400", hash_original_method = "A9F7BB2486256FFAA61FE97D99C9B85E", hash_generated_method = "2D9722B5B07ADB7800BEFA7682608D3F")
    public int getAudioSessionId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522031843 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_522031843;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.779 -0400", hash_original_method = "267B75456E03BDFBAB6FC1F227BFBD27", hash_generated_method = "308855D822BAB31E9E5D0F3584415B59")
    public void attachAuxEffect(int effectId) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.787 -0400", hash_original_method = "4D1DAD410063C63E8C280A1116B73E03", hash_generated_method = "FFCBA173B0649B861ABD892070E2776C")
    public boolean setParameter(int key, Parcel value) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1855145573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1855145573;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.788 -0400", hash_original_method = "007895DA6F9E8604D81FFE810C3D87FB", hash_generated_method = "8092E97776D168B334BA9831576D6882")
    public boolean setParameter(int key, String value) {
        Parcel p;
        p = Parcel.obtain();
        p.writeString(value);
        boolean ret;
        ret = setParameter(key, p);
        p.recycle();
        addTaint(key);
        addTaint(value.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44901459 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_44901459;
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //p.writeString(value);
        //boolean ret = setParameter(key, p);
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.795 -0400", hash_original_method = "42E72BE22D4EC0A8F92EA2FFF9A1B8CD", hash_generated_method = "D89E292C61CFBE8DA8B424643DAC7C25")
    public boolean setParameter(int key, int value) {
        Parcel p;
        p = Parcel.obtain();
        p.writeInt(value);
        boolean ret;
        ret = setParameter(key, p);
        p.recycle();
        addTaint(key);
        addTaint(value);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_370150164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_370150164;
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //p.writeInt(value);
        //boolean ret = setParameter(key, p);
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.796 -0400", hash_original_method = "331C8FC44967717E7E0670FCEDE9BFD0", hash_generated_method = "7FD7F9F0D2267E4E3D8F33E6B3FB173B")
    private void getParameter(int key, Parcel reply) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.807 -0400", hash_original_method = "5EBE9A62BAE86EE2E5C065958EFCD9CF", hash_generated_method = "15F4CBA06C019290FBB586C9EDBAC77C")
    public Parcel getParcelParameter(int key) {
        Parcel varB4EAC82CA7396A68D541C85D26508E83_1619831761 = null; //Variable for return #1
        Parcel p;
        p = Parcel.obtain();
        getParameter(key, p);
        varB4EAC82CA7396A68D541C85D26508E83_1619831761 = p;
        addTaint(key);
        varB4EAC82CA7396A68D541C85D26508E83_1619831761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1619831761;
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //getParameter(key, p);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.814 -0400", hash_original_method = "E362F946FCE7F90CCCD629666B73E43A", hash_generated_method = "CAAEE3525845301088BDF4EE724DD4C5")
    public String getStringParameter(int key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1194321219 = null; //Variable for return #1
        Parcel p;
        p = Parcel.obtain();
        getParameter(key, p);
        String ret;
        ret = p.readString();
        p.recycle();
        varB4EAC82CA7396A68D541C85D26508E83_1194321219 = ret;
        addTaint(key);
        varB4EAC82CA7396A68D541C85D26508E83_1194321219.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1194321219;
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //getParameter(key, p);
        //String ret = p.readString();
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.814 -0400", hash_original_method = "6CEECAB43DB86BAC5EC65D39A3A924D5", hash_generated_method = "9F96A55290304E695A39BED0E45E895B")
    public int getIntParameter(int key) {
        Parcel p;
        p = Parcel.obtain();
        getParameter(key, p);
        int ret;
        ret = p.readInt();
        p.recycle();
        addTaint(key);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_627875972 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_627875972;
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //getParameter(key, p);
        //int ret = p.readInt();
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.823 -0400", hash_original_method = "D28173AB681B94731B1FF3947E2DFEF3", hash_generated_method = "672F3C0FD3FDB80EEF14F3C255A04A14")
    public void setAuxEffectSendLevel(float level) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.824 -0400", hash_original_method = "4B4989130AC0D9F13A471859CBC524C2", hash_generated_method = "C429221AE29FED43FDAFDADFCE7BF85A")
    private final int native_invoke(Parcel request, Parcel reply) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648122754 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648122754;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.824 -0400", hash_original_method = "226F7D6B434A382FD3304895D8BD3523", hash_generated_method = "ABB67FC54B778DA94F664316DB734406")
    private final boolean native_getMetadata(boolean update_only,
                                                    boolean apply_filter,
                                                    Parcel reply) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_567724429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_567724429;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.825 -0400", hash_original_method = "DFB5479CBB8EF2503AE55C0DE7F21BA6", hash_generated_method = "0227F0560343128DC99BDA94B0A8E2AD")
    private final int native_setMetadataFilter(Parcel request) {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865479782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865479782;
    }

    
        private static final void native_init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.826 -0400", hash_original_method = "B3ECC5C677CF7E418546A8C45CAC4774", hash_generated_method = "4DE4A52F106E1BB4613AFE97E9519CEB")
    private final void native_setup(Object mediaplayer_this) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.826 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "BE94CB6DE9EDBEEF7D151AA52A7096EC")
    private final void native_finalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.837 -0400", hash_original_method = "BB295A571473D1F777DD0CCBCDDABC95", hash_generated_method = "A4C956DD7264BBA8F8AD8984B14AECFE")
    public boolean enableTimedTextTrackIndex(int index) {
        boolean varF44A7C6F586908C2FF471FA2CC296F4F_1439396307 = (setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, index));
        addTaint(index);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1568134117 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1568134117;
        // ---------- Original Method ----------
        //if (index < 0) {
            //return false;
        //}
        //return setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.838 -0400", hash_original_method = "74C1C7D2920140BDBE1C5FB72709063E", hash_generated_method = "2AE4A7B0661065CA5357929E57EA83EC")
    public boolean enableTimedText() {
        boolean var962E6194C8024D9ACCA053481E058D18_1172748684 = (enableTimedTextTrackIndex(0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1979059353 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1979059353;
        // ---------- Original Method ----------
        //return enableTimedTextTrackIndex(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.839 -0400", hash_original_method = "D4D5A570D263843DA145431C05408526", hash_generated_method = "7BE236E12666C78A2E03EAA1D7A121E6")
    public boolean disableTimedText() {
        boolean var9CC5D1B744DD01592D7EC11B0626EBF9_324611396 = (setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, -1));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1935425791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1935425791;
        // ---------- Original Method ----------
        //return setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, -1);
    }

    
        public static int native_pullBatteryData(Parcel reply) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.839 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "50625AE6DF481AE64B3EB15F7175DFBD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.855 -0400", hash_original_method = "652A10B898FA76BB677D4E34679A7B5D", hash_generated_method = "987EBE7B07F0BFE0DA24DF93DF11B855")
    public void setOnPreparedListener(OnPreparedListener listener) {
        mOnPreparedListener = listener;
        // ---------- Original Method ----------
        //mOnPreparedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.856 -0400", hash_original_method = "6CC4251EDF834484FDBD6F0A122C65D9", hash_generated_method = "02AF5E76A57B14C22A8D31C1FD5DA3AF")
    public void setOnCompletionListener(OnCompletionListener listener) {
        mOnCompletionListener = listener;
        // ---------- Original Method ----------
        //mOnCompletionListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.856 -0400", hash_original_method = "DDA62D9965B414E96A3CCD5D800217D1", hash_generated_method = "0C9AB338C3C684416FAC16C098DF00A6")
    public void setOnBufferingUpdateListener(OnBufferingUpdateListener listener) {
        mOnBufferingUpdateListener = listener;
        // ---------- Original Method ----------
        //mOnBufferingUpdateListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.857 -0400", hash_original_method = "E6C283B9723E51C1AAC734ADC41F741F", hash_generated_method = "09F00DE120F67FA2E06D414F50C2147F")
    public void setOnSeekCompleteListener(OnSeekCompleteListener listener) {
        mOnSeekCompleteListener = listener;
        // ---------- Original Method ----------
        //mOnSeekCompleteListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.857 -0400", hash_original_method = "8379FC1073131EA9347F12938BFC14C4", hash_generated_method = "136130265E2833871182C75F9CC3334A")
    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {
        mOnVideoSizeChangedListener = listener;
        // ---------- Original Method ----------
        //mOnVideoSizeChangedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.864 -0400", hash_original_method = "EF2D264E164B28DBC06EEC6D3EBE8B23", hash_generated_method = "D337EF32E4653756194FC2A4088DE668")
    public void setOnTimedTextListener(OnTimedTextListener listener) {
        mOnTimedTextListener = listener;
        // ---------- Original Method ----------
        //mOnTimedTextListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.865 -0400", hash_original_method = "606EB06B64A07407B83CA5CBEBF309C3", hash_generated_method = "C60A0B1416D18FD751AE5692034CBEE5")
    public void setOnErrorListener(OnErrorListener listener) {
        mOnErrorListener = listener;
        // ---------- Original Method ----------
        //mOnErrorListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.865 -0400", hash_original_method = "4D9753A45AFF6F50F6DD9F2BE501A438", hash_generated_method = "CC22DF79C368D299CC0E0400ABB99A07")
    public void setOnInfoListener(OnInfoListener listener) {
        mOnInfoListener = listener;
        // ---------- Original Method ----------
        //mOnInfoListener = listener;
    }

    
    private class EventHandler extends Handler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.878 -0400", hash_original_field = "69B00892DEC6EACEEA68FA7F3BC343FF", hash_generated_field = "8CCD253E1D8FDE10357015F7795C2D1A")

        private MediaPlayer mMediaPlayer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.879 -0400", hash_original_method = "9E040026EAD08DF6FC1B72FC06387530", hash_generated_method = "E117B431F95348774119F3A38C7BCB16")
        public  EventHandler(MediaPlayer mp, Looper looper) {
            super(looper);
            mMediaPlayer = mp;
            addTaint(looper.getTaint());
            // ---------- Original Method ----------
            //mMediaPlayer = mp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.892 -0400", hash_original_method = "D299385F381B46BF939056A8A39EEDB2", hash_generated_method = "323F3164BEB42630FCE6A78200E79587")
        @Override
        public void handleMessage(Message msg) {
            //Begin case MEDIA_PREPARED 
            mOnPreparedListener.onPrepared(mMediaPlayer);
            //End case MEDIA_PREPARED 
            //Begin case MEDIA_PLAYBACK_COMPLETE 
            mOnCompletionListener.onCompletion(mMediaPlayer);
            //End case MEDIA_PLAYBACK_COMPLETE 
            //Begin case MEDIA_PLAYBACK_COMPLETE 
            stayAwake(false);
            //End case MEDIA_PLAYBACK_COMPLETE 
            //Begin case MEDIA_BUFFERING_UPDATE 
            mOnBufferingUpdateListener.onBufferingUpdate(mMediaPlayer, msg.arg1);
            //End case MEDIA_BUFFERING_UPDATE 
            //Begin case MEDIA_SEEK_COMPLETE 
            mOnSeekCompleteListener.onSeekComplete(mMediaPlayer);
            //End case MEDIA_SEEK_COMPLETE 
            //Begin case MEDIA_SET_VIDEO_SIZE 
            mOnVideoSizeChangedListener.onVideoSizeChanged(mMediaPlayer, msg.arg1, msg.arg2);
            //End case MEDIA_SET_VIDEO_SIZE 
            //Begin case MEDIA_ERROR 
            boolean error_was_handled;
            error_was_handled = false;
            //End case MEDIA_ERROR 
            //Begin case MEDIA_ERROR 
            {
                error_was_handled = mOnErrorListener.onError(mMediaPlayer, msg.arg1, msg.arg2);
            } //End block
            //End case MEDIA_ERROR 
            //Begin case MEDIA_ERROR 
            {
                mOnCompletionListener.onCompletion(mMediaPlayer);
            } //End block
            //End case MEDIA_ERROR 
            //Begin case MEDIA_ERROR 
            stayAwake(false);
            //End case MEDIA_ERROR 
            //Begin case MEDIA_INFO 
            {
                mOnInfoListener.onInfo(mMediaPlayer, msg.arg1, msg.arg2);
            } //End block
            //End case MEDIA_INFO 
            //Begin case MEDIA_TIMED_TEXT 
            {
                {
                    mOnTimedTextListener.onTimedText(mMediaPlayer, null);
                } //End block
                {
                    {
                        TimedText text;
                        text = new TimedText((byte[])(msg.obj));
                        mOnTimedTextListener.onTimedText(mMediaPlayer, text);
                    } //End block
                } //End block
            } //End block
            //End case MEDIA_TIMED_TEXT 
            addTaint(msg.getTaint());
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.898 -0400", hash_original_field = "2B81CAA02D7D1242F9852CAC7134355E", hash_generated_field = "E5A643B1D418726D99E5A8F3970E5556")

    public static final boolean METADATA_UPDATE_ONLY = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.898 -0400", hash_original_field = "29B52589B71C7315FE816A628FD45BF3", hash_generated_field = "C4299F59C35DA7B075841FA52A06DF72")

    public static final boolean METADATA_ALL = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.898 -0400", hash_original_field = "A369572D94705B584ED4CA716EDD5076", hash_generated_field = "0F0666F4EEF61F70AF44DC91825D4969")

    public static final boolean APPLY_METADATA_FILTER = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.899 -0400", hash_original_field = "4C9106A4FF579D8CE23A8847FB979E36", hash_generated_field = "1049A3BBD43F92B7A4632827C73A789E")

    public static final boolean BYPASS_METADATA_FILTER = false;
    static {
        System.loadLibrary("media_jni");
        native_init();
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.899 -0400", hash_original_field = "83EAA951DEEF1316171AE44680D58845", hash_generated_field = "C8E6FF13BA6971102ADDF354DB387363")

    private static String TAG = "MediaPlayer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.899 -0400", hash_original_field = "8310AB953C210656B503D183BF619520", hash_generated_field = "6B9E07E5FEB5194F99ACB68503043B09")

    private static String IMEDIA_PLAYER = "android.media.IMediaPlayer";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.899 -0400", hash_original_field = "064DFBA424C7213BE703E49094602A22", hash_generated_field = "395A97EC58AC091B4EC6519B779584F7")

    private static int KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.899 -0400", hash_original_field = "3BB3080855F2B67AF1E96703C7E48C71", hash_generated_field = "14BDA07E2B700534FFEB7899B3280235")

    private static int KEY_PARAMETER_TIMED_TEXT_ADD_OUT_OF_BAND_SOURCE = 1001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.899 -0400", hash_original_field = "D4CDB0D2094A0C349AFF33AAAC0067FE", hash_generated_field = "41C4FEAA2B32DCAC055583D9FC1E5F4D")

    private static int MEDIA_NOP = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.899 -0400", hash_original_field = "4B24482E9D2C267C9A287EDE6F592111", hash_generated_field = "FD02103F1A00467A9A310E6D33FFBCC9")

    private static int MEDIA_PREPARED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.899 -0400", hash_original_field = "66F638BCC1FAA461C5CCB1A9E411CB1A", hash_generated_field = "B122F17C685C788A604AC3B57397117E")

    private static int MEDIA_PLAYBACK_COMPLETE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.900 -0400", hash_original_field = "8BCA2A9AE2629A0340DDE0FB82F3925C", hash_generated_field = "7A923281C3DDBA45550FB3307A2C56F3")

    private static int MEDIA_BUFFERING_UPDATE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.900 -0400", hash_original_field = "61346ACBC3C3E5C02A58E8C0B96BFBBA", hash_generated_field = "C2438954DA77A8067C5113E3FB664912")

    private static int MEDIA_SEEK_COMPLETE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.900 -0400", hash_original_field = "647D37D7C30F0596F1729B1A0C3DD25F", hash_generated_field = "5354967B7BE19FC9D85A5DF92D717905")

    private static int MEDIA_SET_VIDEO_SIZE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.900 -0400", hash_original_field = "4FA27E073FEA162B15FA3C4A1350185B", hash_generated_field = "B91C57839DF98FD676BD3932CDE41D0A")

    private static int MEDIA_TIMED_TEXT = 99;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.900 -0400", hash_original_field = "034B4E27C9934B7E5EE6F1D14C7DB69C", hash_generated_field = "B9E012FDAC914F4D993B14AD0F12855A")

    private static int MEDIA_ERROR = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.900 -0400", hash_original_field = "A435AC6A8180A4DA12EA054862142CEA", hash_generated_field = "F4826DFC778357A39D4CB025932641F4")

    private static int MEDIA_INFO = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.900 -0400", hash_original_field = "59B00BA0B25CB14099C620E1F88F8680", hash_generated_field = "2CACBDD6D4608C168454A86007B01373")

    public static final int MEDIA_ERROR_UNKNOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.900 -0400", hash_original_field = "8BFDCC551B6A7FA397ECE4FBF1A85AF2", hash_generated_field = "DB95F5B0F907621EE3C274E114EE5AD1")

    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.901 -0400", hash_original_field = "52671B78310C79F5F4B6B9C200F9B7DD", hash_generated_field = "06C2C428D805E0A67D6BAD19B365C91C")

    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.908 -0400", hash_original_field = "2D4ED1FD2E10E3B09D0872A64CB9F2D2", hash_generated_field = "D3589790B5B6A82CA9C075033A457158")

    public static final int MEDIA_INFO_UNKNOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.909 -0400", hash_original_field = "BAB185AF4B17E16BFC767F210973FFB0", hash_generated_field = "C514B988C6EE0C70B1A7903973F10397")

    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.909 -0400", hash_original_field = "C6DE574072A9069EEA2D5276349060CF", hash_generated_field = "C18AAAC03D3E808C49320185870D0BAE")

    public static final int MEDIA_INFO_BUFFERING_START = 701;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.909 -0400", hash_original_field = "933043B3A280FC833A7C7019B5FA6652", hash_generated_field = "607F18EB2223B97FD6DA02FA3195836F")

    public static final int MEDIA_INFO_BUFFERING_END = 702;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.909 -0400", hash_original_field = "54901B095B647A95572D625A2F5A86F4", hash_generated_field = "86017CADB92B26DE78EEC620504FE574")

    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.914 -0400", hash_original_field = "29698CC1BB7E71A5AB661E9D75748649", hash_generated_field = "06DD5F069EB77262680FEF74A227A7D4")

    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:18.920 -0400", hash_original_field = "C90DC7A69E9C2C6E88E44934A8A051B7", hash_generated_field = "A307F706DBE6E89451A83E6E4C58505E")

    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
}

