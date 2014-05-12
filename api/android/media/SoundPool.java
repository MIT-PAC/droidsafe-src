package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.util.AndroidRuntimeException;
import android.util.Log;

public class SoundPool {

    // post event from native code to message handler
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.624 -0500", hash_original_method = "504DAC0A61388EA8148C9F4BC59C64B8", hash_generated_method = "59C5F6AE465FD1C8037D4636411E620C")
    
private static void postEventFromNative(Object weakRef, int msg, int arg1, int arg2, Object obj)
    {
        SoundPool soundPool = (SoundPool)((WeakReference)weakRef).get();
        if (soundPool == null)
            return;

        if (soundPool.mEventHandler != null) {
            Message m = soundPool.mEventHandler.obtainMessage(msg, arg1, arg2, obj);
            soundPool.mEventHandler.sendMessage(m);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.525 -0500", hash_original_field = "AA8CB5F7395B139E4A33E2239A25A58A", hash_generated_field = "6DF3C44590F8CA7F63D7F38A9FE65359")

    private final static String TAG = "SoundPool";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.528 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.540 -0500", hash_original_field = "AC0D4323B94E186E16CA92DF9A430A18", hash_generated_field = "C37BDDEF05265D589C3CD0FD62C27620")

    //
    // must match SoundPool.h
    private static final int SAMPLE_LOADED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.530 -0500", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.533 -0500", hash_original_field = "48DBEFEB1D57D7425F34775E3B0822FD", hash_generated_field = "04D6DC37F0EF901EF71A528809491D49")

    private EventHandler mEventHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.535 -0500", hash_original_field = "BE3C0426E0435563CFE42823A578DFAA", hash_generated_field = "497ED3DB79F8602C8296F1F823EA04F7")

    private OnLoadCompleteListener mOnLoadCompleteListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.538 -0500", hash_original_field = "3526352753B6B6D766C1FB8917CD22F8", hash_generated_field = "7811049C9A4FE55905A497F504D75A1C")

    private  Object mLock;

    /**
     * Constructor. Constructs a SoundPool object with the following
     * characteristics:
     *
     * @param maxStreams the maximum number of simultaneous streams for this
     *                   SoundPool object
     * @param streamType the audio stream type as described in AudioManager 
     *                   For example, game applications will normally use
     *                   {@link AudioManager#STREAM_MUSIC}.
     * @param srcQuality the sample-rate converter quality. Currently has no
     *                   effect. Use 0 for the default.
     * @return a SoundPool object, or null if creation failed
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.543 -0500", hash_original_method = "9A330E706059F126F0EDC112CA4EBD0D", hash_generated_method = "218B1507D724E755A777A71169D89D52")
    
public SoundPool(int maxStreams, int streamType, int srcQuality) {

        // do native setup
        if (native_setup(new WeakReference(this), maxStreams, streamType, srcQuality) != 0) {
            throw new RuntimeException("Native setup failed");
        }
        mLock = new Object();
    }

    /**
     * Load the sound from the specified path.
     *
     * @param path the path to the audio file
     * @param priority the priority of the sound. Currently has no effect. Use
     *                 a value of 1 for future compatibility.
     * @return a sound ID. This value can be used to play or unload the sound.
     */
    @DSComment("Reaching to files/URI")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.546 -0500", hash_original_method = "E1F98F0EB3621DC5A63042A4ACC9BAA2", hash_generated_method = "3157633A5C57FBD320C57C422905B6D3")
    
public int load(String path, int priority)
    {
        // pass network streams to player
        if (path.startsWith("http:"))
            return _load(path, priority);

        // try local path
        int id = 0;
        try {
            File f = new File(path);
            if (f != null) {
                ParcelFileDescriptor fd = ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_ONLY);
                if (fd != null) {
                    id = _load(fd.getFileDescriptor(), 0, f.length(), priority);
                    fd.close();
                }
            }
        } catch (java.io.IOException e) {
            Log.e(TAG, "error loading " + path);
        }
        return id;
    }

    /**
     * Load the sound from the specified APK resource.
     *
     * Note that the extension is dropped. For example, if you want to load
     * a sound from the raw resource file "explosion.mp3", you would specify
     * "R.raw.explosion" as the resource ID. Note that this means you cannot
     * have both an "explosion.wav" and an "explosion.mp3" in the res/raw
     * directory.
     * 
     * @param context the application context
     * @param resId the resource ID
     * @param priority the priority of the sound. Currently has no effect. Use
     *                 a value of 1 for future compatibility.
     * @return a sound ID. This value can be used to play or unload the sound.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.548 -0500", hash_original_method = "DBD8B5A7FFACE026F7AD7D856CBD2B6E", hash_generated_method = "31EAA745F82F7F91E7D4FD9828D831FE")
    
public int load(Context context, int resId, int priority) {
        AssetFileDescriptor afd = context.getResources().openRawResourceFd(resId);
        int id = 0;
        if (afd != null) {
            id = _load(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength(), priority);
            try {
                afd.close();
            } catch (java.io.IOException ex) {
                //Log.d(TAG, "close failed:", ex);
            }
        }
        return id;
    }

    /**
     * Load the sound from an asset file descriptor.
     *
     * @param afd an asset file descriptor
     * @param priority the priority of the sound. Currently has no effect. Use
     *                 a value of 1 for future compatibility.
     * @return a sound ID. This value can be used to play or unload the sound.
     */
    @DSComment("Reaching to files/URI")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.550 -0500", hash_original_method = "13C5B0F29B8E9F766E159F72001665A3", hash_generated_method = "CE1BB35CF565C4C4B2DF4A3848958448")
    
public int load(AssetFileDescriptor afd, int priority) {
        if (afd != null) {
            long len = afd.getLength();
            if (len < 0) {
                throw new AndroidRuntimeException("no length for fd");
            }
            return _load(afd.getFileDescriptor(), afd.getStartOffset(), len, priority);
        } else {
            return 0;
        }
    }

    /**
     * Load the sound from a FileDescriptor.
     *
     * This version is useful if you store multiple sounds in a single
     * binary. The offset specifies the offset from the start of the file
     * and the length specifies the length of the sound within the file.
     *
     * @param fd a FileDescriptor object
     * @param offset offset to the start of the sound
     * @param length length of the sound
     * @param priority the priority of the sound. Currently has no effect. Use
     *                 a value of 1 for future compatibility.
     * @return a sound ID. This value can be used to play or unload the sound.
     */
    @DSComment("Reaching to files/URI")
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.553 -0500", hash_original_method = "880A1376217C4927F288F839E096A293", hash_generated_method = "B2FD08A4851FCB0A5B2B59ECFEDC7090")
    
public int load(FileDescriptor fd, long offset, long length, int priority) {
        return _load(fd, offset, length, priority);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.558 -0500", hash_original_method = "85C3F47AB710FF718648D7EFD49684BE", hash_generated_method = "6BDD75A4565875E2BBDE88C3E1E09E74")
    
    private final int _load(String uri, int priority){
    	//Formerly a native method
    	addTaint(uri.getTaint());
    	addTaint(priority);
    	return getTaintInt();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.562 -0500", hash_original_method = "C8E2F6B503F32805E6B119DE960F5701", hash_generated_method = "3AFCD46812429082330FD5DF02EB7BCC")
    
    private final int _load(FileDescriptor fd, long offset, long length, int priority){
    	//Formerly a native method
    	addTaint(fd.getTaint());
    	addTaint(offset);
    	addTaint(length);
    	addTaint(priority);
    	return getTaintInt();
    }

    /**
     * Unload a sound from a sound ID.
     *
     * Unloads the sound specified by the soundID. This is the value
     * returned by the load() function. Returns true if the sound is
     * successfully unloaded, false if the sound was already unloaded.
     *
     * @param soundID a soundID returned by the load() function
     * @return true if just unloaded, false if previously unloaded
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.566 -0500", hash_original_method = "C196F2E01E1A194C3DA5827EEB00DADF", hash_generated_method = "750843C7A7AB4B1318C9907928961CD0")
    
    public final boolean unload(int soundID){
    	//Formerly a native method
    	addTaint(soundID);
    	return getTaintBoolean();
    }

    /**
     * Play a sound from a sound ID.
     *
     * Play the sound specified by the soundID. This is the value 
     * returned by the load() function. Returns a non-zero streamID
     * if successful, zero if it fails. The streamID can be used to
     * further control playback. Note that calling play() may cause
     * another sound to stop playing if the maximum number of active
     * streams is exceeded. A loop value of -1 means loop forever,
     * a value of 0 means don't loop, other values indicate the
     * number of repeats, e.g. a value of 1 plays the audio twice.
     * The playback rate allows the application to vary the playback
     * rate (pitch) of the sound. A value of 1.0 means play back at
     * the original frequency. A value of 2.0 means play back twice
     * as fast, and a value of 0.5 means playback at half speed.
     *
     * @param soundID a soundID returned by the load() function
     * @param leftVolume left volume value (range = 0.0 to 1.0)
     * @param rightVolume right volume value (range = 0.0 to 1.0)
     * @param priority stream priority (0 = lowest priority)
     * @param loop loop mode (0 = no loop, -1 = loop forever)
     * @param rate playback rate (1.0 = normal playback, range 0.5 to 2.0)
     * @return non-zero streamID if successful, zero if failed
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.570 -0500", hash_original_method = "9589225497E51729346B545BB33DDBAF", hash_generated_method = "D13FD2428C126D4BA837BC50DF71D828")
    
    public final int play(int soundID, float leftVolume, float rightVolume,
                int priority, int loop, float rate){
    	//Formerly a native method
    	addTaint(soundID);
    	addTaint(leftVolume);
    	addTaint(rightVolume);
    	addTaint(priority);
    	addTaint(loop);
    	addTaint(rate);
    	return getTaintInt();
    }

    /**
     * Pause a playback stream.
     *
     * Pause the stream specified by the streamID. This is the
     * value returned by the play() function. If the stream is
     * playing, it will be paused. If the stream is not playing
     * (e.g. is stopped or was previously paused), calling this
     * function will have no effect.
     *
     * @param streamID a streamID returned by the play() function
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.574 -0500", hash_original_method = "54A0F66BCDE4EF4A44EB64BA62B8B616", hash_generated_method = "935421F35E4DE3CC482113B39257EAC8")
    
    public final void pause(int streamID){
    	//Formerly a native method
    	addTaint(streamID);
    }

    /**
     * Resume a playback stream.
     *
     * Resume the stream specified by the streamID. This
     * is the value returned by the play() function. If the stream
     * is paused, this will resume playback. If the stream was not
     * previously paused, calling this function will have no effect.
     *
     * @param streamID a streamID returned by the play() function
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.578 -0500", hash_original_method = "91631F30419B4DD14ADA49D91B638AA9", hash_generated_method = "123197704D7EDF8FD0700B8CC2FE9F2A")
    
    public final void resume(int streamID){
    	//Formerly a native method
    	addTaint(streamID);
    }

    /**
     * Pause all active streams.
     *
     * Pause all streams that are currently playing. This function
     * iterates through all the active streams and pauses any that
     * are playing. It also sets a flag so that any streams that
     * are playing can be resumed by calling autoResume().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.582 -0500", hash_original_method = "8FEE6E2BE62E09C5DD25C1A91956DDC0", hash_generated_method = "9448D11435CE1845BE737E32461CC45B")
    
    public final void autoPause(){
    	//Formerly a native method
    }

    /**
     * Resume all previously active streams.
     *
     * Automatically resumes all streams that were paused in previous
     * calls to autoPause().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.586 -0500", hash_original_method = "C44CD98A45EC461F196F123D70897C27", hash_generated_method = "021357EB558A409236E7C8F3B1393B3C")
    
    public final void autoResume(){
    	//Formerly a native method
    }

    /**
     * Stop a playback stream.
     *
     * Stop the stream specified by the streamID. This
     * is the value returned by the play() function. If the stream
     * is playing, it will be stopped. It also releases any native
     * resources associated with this stream. If the stream is not
     * playing, it will have no effect.
     *
     * @param streamID a streamID returned by the play() function
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.590 -0500", hash_original_method = "256BB7EB28001D07413FAE5DCA57A75D", hash_generated_method = "5AE0A72F34F80926A6E65AF8AF9B73A0")
    
    public final void stop(int streamID){
    	//Formerly a native method
    	addTaint(streamID);
    }

    /**
     * Set stream volume.
     *
     * Sets the volume on the stream specified by the streamID.
     * This is the value returned by the play() function. The
     * value must be in the range of 0.0 to 1.0. If the stream does
     * not exist, it will have no effect.
     *
     * @param streamID a streamID returned by the play() function
     * @param leftVolume left volume value (range = 0.0 to 1.0)
     * @param rightVolume right volume value (range = 0.0 to 1.0)
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.593 -0500", hash_original_method = "20F7132E4AACD7E452666ABABCAB0364", hash_generated_method = "F6881F993E9B642ED7EC5312069842A9")
    
    public final void setVolume(int streamID,
                float leftVolume, float rightVolume){
    	//Formerly a native method
    	addTaint(streamID);
    	addTaint(leftVolume);
    	addTaint(rightVolume);
    }

    /**
     * Change stream priority.
     *
     * Change the priority of the stream specified by the streamID.
     * This is the value returned by the play() function. Affects the
     * order in which streams are re-used to play new sounds. If the
     * stream does not exist, it will have no effect.
     *
     * @param streamID a streamID returned by the play() function
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.597 -0500", hash_original_method = "CCA6C13126A90C5188BC1E15A109E7B2", hash_generated_method = "3515FDAAEDEA152880E03416C7A5BFD9")
    
    public final void setPriority(int streamID, int priority){
    	//Formerly a native method
    	addTaint(streamID);
    	addTaint(priority);
    }

    /**
     * Set loop mode.
     *
     * Change the loop mode. A loop value of -1 means loop forever,
     * a value of 0 means don't loop, other values indicate the
     * number of repeats, e.g. a value of 1 plays the audio twice.
     * If the stream does not exist, it will have no effect.
     *
     * @param streamID a streamID returned by the play() function
     * @param loop loop mode (0 = no loop, -1 = loop forever)
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.602 -0500", hash_original_method = "E029D221BD7CC57706C78C8567A53755", hash_generated_method = "69816FD76CE77FEEE7CB8E21CAE13B5A")
    
    public final void setLoop(int streamID, int loop){
    	//Formerly a native method
    	addTaint(streamID);
    	addTaint(loop);
    }

    /**
     * Change playback rate.
     *
     * The playback rate allows the application to vary the playback
     * rate (pitch) of the sound. A value of 1.0 means playback at
     * the original frequency. A value of 2.0 means playback twice
     * as fast, and a value of 0.5 means playback at half speed.
     * If the stream does not exist, it will have no effect.
     *
     * @param streamID a streamID returned by the play() function
     * @param rate playback rate (1.0 = normal playback, range 0.5 to 2.0)
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.606 -0500", hash_original_method = "825447C8FC2A68B86E6BD75A907AFFEE", hash_generated_method = "6DFC049E0287A218C0F682E46D49411D")
    
    public final void setRate(int streamID, float rate){
    	//Formerly a native method
    	addTaint(streamID);
    	addTaint(rate);
    }

    /**
     * Sets the callback hook for the OnLoadCompleteListener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.611 -0500", hash_original_method = "093CAC8CD903CBE9AAF47DBBDF966468", hash_generated_method = "2A4B1D5909A4BC4D1E5AC1B3F367A2AD")
    @DSVerified("Calling callbacks ")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void setOnLoadCompleteListener(OnLoadCompleteListener listener)
    {
        synchronized(mLock) {
            if (listener != null) {
                // setup message handler
                Looper looper;
                if ((looper = Looper.myLooper()) != null) {
                    mEventHandler = new EventHandler(this, looper);
                } else if ((looper = Looper.getMainLooper()) != null) {
                    mEventHandler = new EventHandler(this, looper);
                } else {
                    mEventHandler = null;
                }
            } else {
                mEventHandler = null;
            }
            mOnLoadCompleteListener = listener;
        }
        if (listener != null) {
            listener.onLoadComplete(this, DSUtils.FAKE_INT, DSUtils.FAKE_INT);
        }
    }
    
    private class EventHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.614 -0500", hash_original_field = "BBA969104F92FE619036260FE50B33EE", hash_generated_field = "57F9E596595665A3ABBC76A135513391")

        private SoundPool mSoundPool;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.617 -0500", hash_original_method = "623C6FE52B72FF4CA79E1D55E5E352CD", hash_generated_method = "F797FA1171885A018007A81170C2B9F0")
        
public EventHandler(SoundPool soundPool, Looper looper) {
            super(looper);
            mSoundPool = soundPool;
        }

        @DSSafe(DSCat.IPC_CALLBACK)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.620 -0500", hash_original_method = "489ADADA267AA176412248D35C25EA36", hash_generated_method = "D4BCFD52F35376B492DC44C76D15FE10")
        
@Override
        public void handleMessage(Message msg) {
            switch(msg.what) {
            case SAMPLE_LOADED:
                if (DEBUG) Log.d(TAG, "Sample " + msg.arg1 + " loaded");
                synchronized(mLock) {
                    if (mOnLoadCompleteListener != null) {
                        mOnLoadCompleteListener.onLoadComplete(mSoundPool, msg.arg1, msg.arg2);
                    }
                }
                break;
            default:
                Log.e(TAG, "Unknown message type " + msg.what);
                return;
            }
        }
        
    }
    
    public interface OnLoadCompleteListener
    {
        @DSVerified
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onLoadComplete(SoundPool soundPool, int sampleId, int status);
    }
    
    static { System.loadLibrary("soundpool"); }

    /**
     * Release the SoundPool resources.
     *
     * Release all memory and native resources used by the SoundPool
     * object. The SoundPool can no longer be used and the reference
     * should be set to null.
     */
    @DSComment("not sensitive")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.628 -0500", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "727A0BB95ED1BAF2DF30AF20E79B8791")
    
    public final void release(){
    	//Formerly a native method
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.633 -0500", hash_original_method = "643150117BD11ABB17CD24F5EE247C54", hash_generated_method = "A76E14668CE0F65762CD958CABD4D853")
    
    private final int native_setup(Object weakRef, int maxStreams, int streamType, int srcQuality){
    	//Formerly a native method
    	addTaint(weakRef.getTaint());
    	addTaint(maxStreams);
    	addTaint(streamType);
    	addTaint(srcQuality);
    	return getTaintInt();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:29.635 -0500", hash_original_method = "52F53B59AD091F99DC7C4D49031A27E5", hash_generated_method = "9A6AA3EE3AA1630FAE214B52E6DCE99D")
    
protected void finalize() { release(); }
}

