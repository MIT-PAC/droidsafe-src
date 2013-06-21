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
    private int mNativeContext;
    private int mNativeSurfaceTexture;
    private int mListenerContext;
    private SurfaceHolder mSurfaceHolder;
    private EventHandler mEventHandler;
    private PowerManager.WakeLock mWakeLock = null;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private OnPreparedListener mOnPreparedListener;
    private OnCompletionListener mOnCompletionListener;
    private OnBufferingUpdateListener mOnBufferingUpdateListener;
    private OnSeekCompleteListener mOnSeekCompleteListener;
    private OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private OnTimedTextListener mOnTimedTextListener;
    private OnErrorListener mOnErrorListener;
    private OnInfoListener mOnInfoListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.245 -0400", hash_original_method = "2C929CFD6011D1A8428ADCC5A270A92B", hash_generated_method = "CB82C1F25260F94E980FCF8A71A016DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MediaPlayer() {
        Looper looper;
        {
            boolean var59AC82EBCD14E4AA50598F2AE3563759_1403819934 = ((looper = Looper.myLooper()) != null);
            {
                mEventHandler = new EventHandler(this, looper);
            } //End block
            {
                boolean var9D854D75870272BF06142F5CE681F893_1250186293 = ((looper = Looper.getMainLooper()) != null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.245 -0400", hash_original_method = "53B8A3255E430D9C87E415235A089C4A", hash_generated_method = "B2F4FFE24CCA4D50EBAFFE68AE3EAD28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _setVideoSurface(Surface surface) {
        dsTaint.addTaint(surface.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.245 -0400", hash_original_method = "9BA2A59C2D2CF14D2B23AE59BE37DCE6", hash_generated_method = "F85FFBC5525FFD0F33814777E3500A4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Parcel newRequest() {
        Parcel parcel;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken(IMEDIA_PLAYER);
        return (Parcel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Parcel parcel = Parcel.obtain();
        //parcel.writeInterfaceToken(IMEDIA_PLAYER);
        //return parcel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.246 -0400", hash_original_method = "F1F9A39481AD241B93A7EFA7B112C8A9", hash_generated_method = "8E838968047BAED13016B7292A44ACEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int invoke(Parcel request, Parcel reply) {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        int retcode;
        retcode = native_invoke(request, reply);
        reply.setDataPosition(0);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int retcode = native_invoke(request, reply);
        //reply.setDataPosition(0);
        //return retcode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.246 -0400", hash_original_method = "936E4BA5EFE5EFD7E502D57ADB83F5AB", hash_generated_method = "DFF7B02DADC4E083607459B8F3C72BE9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDisplay(SurfaceHolder sh) {
        dsTaint.addTaint(sh.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.246 -0400", hash_original_method = "E1CEE3A46E058530408C5094E8A255A4", hash_generated_method = "59378515212F127C2F485F976BE2226A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSurface(Surface surface) {
        dsTaint.addTaint(surface.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.247 -0400", hash_original_method = "40ED5E4D3E36120D5E7C77AB85EB12F0", hash_generated_method = "2296EA18816FB26114409AFD03EF820A")
    @DSModeled(DSC.SPEC)
    public void setDataSource(Context context, Uri uri) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        setDataSource(context, uri, null);
        // ---------- Original Method ----------
        //setDataSource(context, uri, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.248 -0400", hash_original_method = "0C532A10BBEED73B371000A59C797624", hash_generated_method = "1F883285F9C1059F4F487AD969D3BDA0")
    @DSModeled(DSC.SPEC)
    public void setDataSource(Context context, Uri uri, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        String scheme;
        scheme = uri.getScheme();
        {
            boolean varB783BCB76216B10372231D3D68484DB8_1493901597 = (scheme == null || scheme.equals("file"));
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
                boolean var761F6419C241ADD42691E3D2E85CB236_1585727562 = (fd.getDeclaredLength() < 0);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.248 -0400", hash_original_method = "70B5385C7A556D37595F97E42F2F2DFE", hash_generated_method = "C73A036B7A7A92B4AC162575AF560E30")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataSource(String path) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.254 -0400", hash_original_method = "21A95B4BC3854510C509CF1B7B37D46D", hash_generated_method = "EB9C94763A888B5639FFACD3431F6FF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataSource(String path, Map<String, String> headers) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        dsTaint.addTaint(headers.dsTaint);
        dsTaint.addTaint(path);
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
                Iterator<Map.Entry<String, String>> var837775D5302415DDC2678074F3242FEF_1414119610 = (headers.entrySet()).iterator();
                var837775D5302415DDC2678074F3242FEF_1414119610.hasNext();
                Map.Entry<String, String> entry = var837775D5302415DDC2678074F3242FEF_1414119610.next();
                {
                    keys[i] = entry.getKey();
                    values[i] = entry.getValue();
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.254 -0400", hash_original_method = "35737102382ABAAE0A83F0ED650DE965", hash_generated_method = "6043537FC0B24C947AC2222DEF8D2788")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _setDataSource(
        String path, String[] keys, String[] values) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException {
        dsTaint.addTaint(values[0]);
        dsTaint.addTaint(keys[0]);
        dsTaint.addTaint(path);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.255 -0400", hash_original_method = "67ED0EB071685F0AFDAFB2EFB1BC8776", hash_generated_method = "6D52DC3951B8F7A3A8EA15BC4B42F6CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataSource(FileDescriptor fd) throws IOException, IllegalArgumentException, IllegalStateException {
        dsTaint.addTaint(fd.dsTaint);
        setDataSource(fd, 0, 0x7ffffffffffffffL);
        // ---------- Original Method ----------
        //setDataSource(fd, 0, 0x7ffffffffffffffL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.255 -0400", hash_original_method = "CF807E4C5554BB2848F7651782391DCD", hash_generated_method = "78D9F0FDE011E099A7BB8C39FDD6D208")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDataSource(FileDescriptor fd, long offset, long length) throws IOException, IllegalArgumentException, IllegalStateException {
        dsTaint.addTaint(length);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.255 -0400", hash_original_method = "BE634EB7B5A47DD549B3D4698CE7CD0F", hash_generated_method = "E7E943D15349F05D8E6452080C3FE19C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void prepare() throws IOException, IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.255 -0400", hash_original_method = "9BEAA7388253BD2C3E319E2E43B2453F", hash_generated_method = "953CE432DFBBEC63464F146F85A74F11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void prepareAsync() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.256 -0400", hash_original_method = "40DE58868CCCFC32104AEA08DBC3B0CD", hash_generated_method = "8D9FC9E4EE85EF00796B52D423965C3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void start() throws IllegalStateException {
        stayAwake(true);
        _start();
        // ---------- Original Method ----------
        //stayAwake(true);
        //_start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.256 -0400", hash_original_method = "6DEDFC534300C5310A66033260D8A31E", hash_generated_method = "D1FE609F1EBAE49EEF1BACBB02C63952")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _start() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.256 -0400", hash_original_method = "09E3A57706D9EF8F79E07C48FA7F3A4D", hash_generated_method = "50D137FD7257996CE996E4B7E4E11980")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stop() throws IllegalStateException {
        stayAwake(false);
        _stop();
        // ---------- Original Method ----------
        //stayAwake(false);
        //_stop();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.256 -0400", hash_original_method = "7A254901D3417D112F523A3CB4C0BACF", hash_generated_method = "E38D7EC8B95A05706550F50CD55A4851")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _stop() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.256 -0400", hash_original_method = "857D1517B1757951DF038ED3088FF3B2", hash_generated_method = "9DD53ADFA67EFE3B90445FCC4D8F68C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void pause() throws IllegalStateException {
        stayAwake(false);
        _pause();
        // ---------- Original Method ----------
        //stayAwake(false);
        //_pause();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.257 -0400", hash_original_method = "3CFA64AA4FE31303B150AAAF6D2A439E", hash_generated_method = "85A230E7AF7EEA7FE619291D65BB2491")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _pause() throws IllegalStateException {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.257 -0400", hash_original_method = "2C98FD0B2087D81FFC1D38F1403791EF", hash_generated_method = "7F1187EF19963E3EDAB6816E8ABAD428")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWakeMode(Context context, int mode) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(mode);
        boolean washeld;
        washeld = false;
        {
            {
                boolean varA10E0F7CBE89603E5C4D8E437932CB2B_101350026 = (mWakeLock.isHeld());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.257 -0400", hash_original_method = "1D2643121E0BBACA918AEEFF16FB1665", hash_generated_method = "2DAB58C2DE7D3A7EFCFB2B497D092227")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setScreenOnWhilePlaying(boolean screenOn) {
        dsTaint.addTaint(screenOn);
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.258 -0400", hash_original_method = "02316AFDA0A1E822630D7CE99583BEE5", hash_generated_method = "9F3AA7F52042455470BE909B7D489A5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void stayAwake(boolean awake) {
        dsTaint.addTaint(awake);
        {
            {
                boolean var2AF05387B6FE9C5F416A6EC845CFCE19_232324044 = (awake && !mWakeLock.isHeld());
                {
                    mWakeLock.acquire();
                } //End block
                {
                    boolean var5AEF773A774AC1175FEC7C5357C07830_1427281511 = (!awake && mWakeLock.isHeld());
                    {
                        mWakeLock.release();
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.258 -0400", hash_original_method = "D56BBB45DF467B2DAD5698BBF1920DD6", hash_generated_method = "10DE4749CDD3C23C1A28F71467D50BD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateSurfaceScreenOn() {
        {
            mSurfaceHolder.setKeepScreenOn(mScreenOnWhilePlaying && mStayAwake);
        } //End block
        // ---------- Original Method ----------
        //if (mSurfaceHolder != null) {
            //mSurfaceHolder.setKeepScreenOn(mScreenOnWhilePlaying && mStayAwake);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.258 -0400", hash_original_method = "33D5C83ED46D1CA5E488AF592A477814", hash_generated_method = "9C1CB7AA6F4FE1E821EE49CCAE0AD75B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVideoWidth() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.258 -0400", hash_original_method = "AA8703DABD049C78A6839F5E3DDBB949", hash_generated_method = "7A47D4A54E96D76A2FDF4574A9086832")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getVideoHeight() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.258 -0400", hash_original_method = "F383FE244E24C0C545B5D975B4462316", hash_generated_method = "E85BA7C9F6438D316FDF53F8775E2014")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPlaying() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.259 -0400", hash_original_method = "97A3BCAAD25A5F0CCA6DBA135F05FFD4", hash_generated_method = "D226F53F231FF58BA41FCBAEC61B1B44")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void seekTo(int msec) throws IllegalStateException {
        dsTaint.addTaint(msec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.259 -0400", hash_original_method = "540585A22AA6C1E9C18EA05D71ACEBDE", hash_generated_method = "6863A3A107A60634A8BFEAC39C2C973A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCurrentPosition() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.259 -0400", hash_original_method = "5FCC06EDC9BF2D1AEA92A44CF2A2F31E", hash_generated_method = "8FD65AE93316C3CBC57332E5B95F87F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDuration() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.259 -0400", hash_original_method = "62D59DE780FDA113D7200968BD4DD768", hash_generated_method = "53CB1D781724BB5169BF1F9AF0901148")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Metadata getMetadata(final boolean update_only,
                                final boolean apply_filter) {
        dsTaint.addTaint(apply_filter);
        dsTaint.addTaint(update_only);
        Parcel reply;
        reply = Parcel.obtain();
        Metadata data;
        data = new Metadata();
        {
            boolean varE627D518551FE7C5957D927A36F80D7B_1780835358 = (!native_getMetadata(update_only, apply_filter, reply));
            {
                reply.recycle();
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD5B0854FD3A7E24F478943612F0067D6_1144298662 = (!data.parse(reply));
            {
                reply.recycle();
            } //End block
        } //End collapsed parenthetic
        return (Metadata)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.266 -0400", hash_original_method = "B0BBED6481EDE7F10FEA4CF182EBE3D1", hash_generated_method = "7983734D8E0AD4F02E47FEE2473EE379")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int setMetadataFilter(Set<Integer> allow, Set<Integer> block) {
        dsTaint.addTaint(allow.dsTaint);
        dsTaint.addTaint(block.dsTaint);
        Parcel request;
        request = newRequest();
        int capacity;
        capacity = request.dataSize() + 4 * (1 + allow.size() + 1 + block.size());
        {
            boolean var640875AB0A5247DF32010D4EDDB1E66D_1623930496 = (request.dataCapacity() < capacity);
            {
                request.setDataCapacity(capacity);
            } //End block
        } //End collapsed parenthetic
        request.writeInt(allow.size());
        {
            Iterator<Integer> varC4C5C0703D00EC448346EFAF5E5FC39F_1803166481 = (allow).iterator();
            varC4C5C0703D00EC448346EFAF5E5FC39F_1803166481.hasNext();
            Integer t = varC4C5C0703D00EC448346EFAF5E5FC39F_1803166481.next();
            {
                request.writeInt(t);
            } //End block
        } //End collapsed parenthetic
        request.writeInt(block.size());
        {
            Iterator<Integer> varFE3C5D648E83A09BB0DA5A5CD9C28882_1293971998 = (block).iterator();
            varFE3C5D648E83A09BB0DA5A5CD9C28882_1293971998.hasNext();
            Integer t = varFE3C5D648E83A09BB0DA5A5CD9C28882_1293971998.next();
            {
                request.writeInt(t);
            } //End block
        } //End collapsed parenthetic
        int varCED2E107F0C63635B55997925961AC14_81235721 = (native_setMetadataFilter(request));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.266 -0400", hash_original_method = "40ADFE91226CE43AA5B2CBEBA3591229", hash_generated_method = "BB9AD88E0EDF8FF01039518B20FC95A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.267 -0400", hash_original_method = "D6ED0B9EBF82A338F6093204ADC2E481", hash_generated_method = "AA5F59E16F2B6AC2DE4549F16EAF4890")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _release() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.267 -0400", hash_original_method = "0163217153F6E824039D5121A760EBE0", hash_generated_method = "2954E9520438919A7ABC834FCE4C8288")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reset() {
        stayAwake(false);
        _reset();
        mEventHandler.removeCallbacksAndMessages(null);
        // ---------- Original Method ----------
        //stayAwake(false);
        //_reset();
        //mEventHandler.removeCallbacksAndMessages(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.267 -0400", hash_original_method = "3FFFF13DAAD4B409C984414CD8318D6D", hash_generated_method = "3553160F21F5CD09799179A1C4084CF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void _reset() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.267 -0400", hash_original_method = "7EA0CD9F896B971C851CD4CA96BFE5FA", hash_generated_method = "C48DC3177C89BFB6E914AAD72AB62244")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAudioStreamType(int streamtype) {
        dsTaint.addTaint(streamtype);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.268 -0400", hash_original_method = "4C3A78CA2E07F71A05B213D4CFF64128", hash_generated_method = "D5D08A554339F0F40518B77F3EF9EC73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLooping(boolean looping) {
        dsTaint.addTaint(looping);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.268 -0400", hash_original_method = "0D67125EE341895F5558E4CEF076C5C6", hash_generated_method = "C648202B115B87166A4D1B1F990DDE10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLooping() {
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.268 -0400", hash_original_method = "BE4EAA7A7DB479C280C8B84C90E58238", hash_generated_method = "1EC17EB36AD960168BFD3FDF9FFCB352")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setVolume(float leftVolume, float rightVolume) {
        dsTaint.addTaint(leftVolume);
        dsTaint.addTaint(rightVolume);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.268 -0400", hash_original_method = "E7BF05B3622AAF2F5F3BF2C4557A0B3B", hash_generated_method = "D0C8B10ECECEE076D3C916178536BAF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Bitmap getFrameAt(int msec) throws IllegalStateException {
        dsTaint.addTaint(msec);
        return (Bitmap)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.269 -0400", hash_original_method = "63928D15D2C6CC99F2E8386267D06FF3", hash_generated_method = "9DBA6C34DA005850DE0EE525C76EA945")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAudioSessionId(int sessionId) throws IllegalArgumentException, IllegalStateException {
        dsTaint.addTaint(sessionId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.269 -0400", hash_original_method = "A9F7BB2486256FFAA61FE97D99C9B85E", hash_generated_method = "957A43FFB07ADDE018F8CA1895192FA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAudioSessionId() {
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.269 -0400", hash_original_method = "267B75456E03BDFBAB6FC1F227BFBD27", hash_generated_method = "3E7F0CE4A2D22EC925E9D78C21A99B5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attachAuxEffect(int effectId) {
        dsTaint.addTaint(effectId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.269 -0400", hash_original_method = "4D1DAD410063C63E8C280A1116B73E03", hash_generated_method = "6434720C9EAE305566357E733EFEFA59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setParameter(int key, Parcel value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(key);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.270 -0400", hash_original_method = "007895DA6F9E8604D81FFE810C3D87FB", hash_generated_method = "2C6771053A2C7F3B5518D2E095DF6C35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setParameter(int key, String value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        Parcel p;
        p = Parcel.obtain();
        p.writeString(value);
        boolean ret;
        ret = setParameter(key, p);
        p.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //p.writeString(value);
        //boolean ret = setParameter(key, p);
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.271 -0400", hash_original_method = "42E72BE22D4EC0A8F92EA2FFF9A1B8CD", hash_generated_method = "D8A999D94E8FA5E9CDEC18582BB40EED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean setParameter(int key, int value) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(key);
        Parcel p;
        p = Parcel.obtain();
        p.writeInt(value);
        boolean ret;
        ret = setParameter(key, p);
        p.recycle();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //p.writeInt(value);
        //boolean ret = setParameter(key, p);
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.272 -0400", hash_original_method = "331C8FC44967717E7E0670FCEDE9BFD0", hash_generated_method = "B422EC051B62EAF0B42427A726689EE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void getParameter(int key, Parcel reply) {
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.272 -0400", hash_original_method = "5EBE9A62BAE86EE2E5C065958EFCD9CF", hash_generated_method = "1CE9BF8045FA985E06CB09632F86FF1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Parcel getParcelParameter(int key) {
        dsTaint.addTaint(key);
        Parcel p;
        p = Parcel.obtain();
        getParameter(key, p);
        return (Parcel)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //getParameter(key, p);
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.273 -0400", hash_original_method = "E362F946FCE7F90CCCD629666B73E43A", hash_generated_method = "66BEBE4454BBF76ECAF73ABE15013D8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getStringParameter(int key) {
        dsTaint.addTaint(key);
        Parcel p;
        p = Parcel.obtain();
        getParameter(key, p);
        String ret;
        ret = p.readString();
        p.recycle();
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //getParameter(key, p);
        //String ret = p.readString();
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.273 -0400", hash_original_method = "6CEECAB43DB86BAC5EC65D39A3A924D5", hash_generated_method = "F8ED97758A710C992222472AC4A3B3B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIntParameter(int key) {
        dsTaint.addTaint(key);
        Parcel p;
        p = Parcel.obtain();
        getParameter(key, p);
        int ret;
        ret = p.readInt();
        p.recycle();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Parcel p = Parcel.obtain();
        //getParameter(key, p);
        //int ret = p.readInt();
        //p.recycle();
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.273 -0400", hash_original_method = "D28173AB681B94731B1FF3947E2DFEF3", hash_generated_method = "E99A9B8FAFF448E5594EEF331A7F02F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAuxEffectSendLevel(float level) {
        dsTaint.addTaint(level);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.273 -0400", hash_original_method = "4B4989130AC0D9F13A471859CBC524C2", hash_generated_method = "EE353B7AA42A5E8798AA8625CF777D73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int native_invoke(Parcel request, Parcel reply) {
        dsTaint.addTaint(request.dsTaint);
        dsTaint.addTaint(reply.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.274 -0400", hash_original_method = "226F7D6B434A382FD3304895D8BD3523", hash_generated_method = "71BDB9B7859747C6AF391617EA80FE62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final boolean native_getMetadata(boolean update_only,
                                                    boolean apply_filter,
                                                    Parcel reply) {
        dsTaint.addTaint(reply.dsTaint);
        dsTaint.addTaint(apply_filter);
        dsTaint.addTaint(update_only);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.274 -0400", hash_original_method = "DFB5479CBB8EF2503AE55C0DE7F21BA6", hash_generated_method = "B89B36DE17A2DCE48AEAEA6C1BA69599")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final int native_setMetadataFilter(Parcel request) {
        dsTaint.addTaint(request.dsTaint);
        return dsTaint.getTaintInt();
    }

    
        private static final void native_init() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.274 -0400", hash_original_method = "B3ECC5C677CF7E418546A8C45CAC4774", hash_generated_method = "6D69EB75498168CECFBEB7ABFE2F2E98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_setup(Object mediaplayer_this) {
        dsTaint.addTaint(mediaplayer_this.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.274 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "BE94CB6DE9EDBEEF7D151AA52A7096EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void native_finalize() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.274 -0400", hash_original_method = "BB295A571473D1F777DD0CCBCDDABC95", hash_generated_method = "7B4A0BD43619C8A7BAEF979708CFD00D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableTimedTextTrackIndex(int index) {
        dsTaint.addTaint(index);
        boolean varF44A7C6F586908C2FF471FA2CC296F4F_1613740697 = (setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, index));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (index < 0) {
            //return false;
        //}
        //return setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.275 -0400", hash_original_method = "74C1C7D2920140BDBE1C5FB72709063E", hash_generated_method = "DDD1574E6CE1B1260B467D0DA05E44C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean enableTimedText() {
        boolean var962E6194C8024D9ACCA053481E058D18_634205980 = (enableTimedTextTrackIndex(0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return enableTimedTextTrackIndex(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.275 -0400", hash_original_method = "D4D5A570D263843DA145431C05408526", hash_generated_method = "D8423028F4DA1854304F4B66E3E92EF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean disableTimedText() {
        boolean var9CC5D1B744DD01592D7EC11B0626EBF9_1289627970 = (setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, -1));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return setParameter(KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX, -1);
    }

    
        public static int native_pullBatteryData(Parcel reply) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.275 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "50625AE6DF481AE64B3EB15F7175DFBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.276 -0400", hash_original_method = "652A10B898FA76BB677D4E34679A7B5D", hash_generated_method = "FA2FEDC52907C69B50B864C47DF2E0E4")
    @DSModeled(DSC.SAFE)
    public void setOnPreparedListener(OnPreparedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnPreparedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.276 -0400", hash_original_method = "6CC4251EDF834484FDBD6F0A122C65D9", hash_generated_method = "DADF7EAE98835D732A75387C99E99F82")
    @DSModeled(DSC.SAFE)
    public void setOnCompletionListener(OnCompletionListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnCompletionListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.276 -0400", hash_original_method = "DDA62D9965B414E96A3CCD5D800217D1", hash_generated_method = "81C073FBF81C0490D652334BECEB8E27")
    @DSModeled(DSC.SAFE)
    public void setOnBufferingUpdateListener(OnBufferingUpdateListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnBufferingUpdateListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.276 -0400", hash_original_method = "E6C283B9723E51C1AAC734ADC41F741F", hash_generated_method = "286AEDDD4AAA84B62CE4783129DA922E")
    @DSModeled(DSC.SAFE)
    public void setOnSeekCompleteListener(OnSeekCompleteListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnSeekCompleteListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.276 -0400", hash_original_method = "8379FC1073131EA9347F12938BFC14C4", hash_generated_method = "904E7C12808DDEA2EAAC759E9F5424C6")
    @DSModeled(DSC.SAFE)
    public void setOnVideoSizeChangedListener(OnVideoSizeChangedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnVideoSizeChangedListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.277 -0400", hash_original_method = "EF2D264E164B28DBC06EEC6D3EBE8B23", hash_generated_method = "2598C6BF428D304475B985A8C5AF3C8D")
    @DSModeled(DSC.SAFE)
    public void setOnTimedTextListener(OnTimedTextListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnTimedTextListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.277 -0400", hash_original_method = "606EB06B64A07407B83CA5CBEBF309C3", hash_generated_method = "AC534D8902AE86E60C21C08DDD810D3B")
    @DSModeled(DSC.SAFE)
    public void setOnErrorListener(OnErrorListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnErrorListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.277 -0400", hash_original_method = "4D9753A45AFF6F50F6DD9F2BE501A438", hash_generated_method = "DB771F2178D903D4E0EE756EC5A31D80")
    @DSModeled(DSC.SAFE)
    public void setOnInfoListener(OnInfoListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
        //mOnInfoListener = listener;
    }

    
    private class EventHandler extends Handler {
        private MediaPlayer mMediaPlayer;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.277 -0400", hash_original_method = "9E040026EAD08DF6FC1B72FC06387530", hash_generated_method = "DD049DB85DFC79C6BDEE4EEC5C8F0C7C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public EventHandler(MediaPlayer mp, Looper looper) {
            super(looper);
            dsTaint.addTaint(mp.dsTaint);
            dsTaint.addTaint(looper.dsTaint);
            // ---------- Original Method ----------
            //mMediaPlayer = mp;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:50.278 -0400", hash_original_method = "D299385F381B46BF939056A8A39EEDB2", hash_generated_method = "352E72866F0540A44D8476283B164C65")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
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
    
    public static final boolean METADATA_UPDATE_ONLY = true;
    public static final boolean METADATA_ALL = false;
    public static final boolean APPLY_METADATA_FILTER = true;
    public static final boolean BYPASS_METADATA_FILTER = false;
    static {
        System.loadLibrary("media_jni");
        native_init();
    }
    
    private final static String TAG = "MediaPlayer";
    private final static String IMEDIA_PLAYER = "android.media.IMediaPlayer";
    private static final int KEY_PARAMETER_TIMED_TEXT_TRACK_INDEX = 1000;
    private static final int KEY_PARAMETER_TIMED_TEXT_ADD_OUT_OF_BAND_SOURCE = 1001;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_TIMED_TEXT = 99;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_INFO = 200;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
}

