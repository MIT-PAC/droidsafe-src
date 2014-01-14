package android.speech.tts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;

public class TextToSpeech {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.626 -0500", hash_original_field = "C4A3C5832A23D8C079E9B7C865BB4B1D", hash_generated_field = "9FEA0A384A6DC49F3D654A7B0E49ACFB")

    private static final String TAG = "TextToSpeech";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.628 -0500", hash_original_field = "746609D22FCF0D7F2FA5575D91BB0797", hash_generated_field = "9B986A2CF4CE0B3870A44EA118A88E9A")

    public static final int SUCCESS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.631 -0500", hash_original_field = "060BE1B4136BE1AC2BFF57541DF9E977", hash_generated_field = "D9FDA3C0E4B8421EF0ECF23EDE3289A4")

    public static final int ERROR = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.633 -0500", hash_original_field = "F70E541CE4A910B1DE2846AD16E182F2", hash_generated_field = "02E0C42BFDC9472143A2816BE6A46302")

    public static final int QUEUE_FLUSH = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.636 -0500", hash_original_field = "E20B4E7C4C146CEB084440B9CDBF01F3", hash_generated_field = "E3D905B07D88D805D26B80E9C9543333")

    public static final int QUEUE_ADD = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.639 -0500", hash_original_field = "E163CCA0B86F9C4443565B42B9B2C731", hash_generated_field = "D4957AFE7D527970CF14C5B19ED60003")

    static final int QUEUE_DESTROY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.641 -0500", hash_original_field = "F095FC4E9B218A16B1D99CBF123AFD47", hash_generated_field = "114C4BE7840CE5276181D4AD399DD60A")

    public static final int LANG_COUNTRY_VAR_AVAILABLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.643 -0500", hash_original_field = "5B3C4FF733D1088B3906011028FBEC5E", hash_generated_field = "615AF214DE081692194C09BC057B78F6")

    public static final int LANG_COUNTRY_AVAILABLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.646 -0500", hash_original_field = "04C5A3D01B5713DB0B2B7D2CF032BC50", hash_generated_field = "D0C3004A60A5D721A3D561D3F15B8744")

    public static final int LANG_AVAILABLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.648 -0500", hash_original_field = "1FFBF9631ED77553E3C8399E8C0D5068", hash_generated_field = "811988C198657A72F3A46F0269AEEEC3")

    public static final int LANG_MISSING_DATA = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.650 -0500", hash_original_field = "AE4FC45EE91E39DDEDAB16330F0F9A84", hash_generated_field = "D282ACE529F1D4C71E5D1D903CE29D28")

    public static final int LANG_NOT_SUPPORTED = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.653 -0500", hash_original_field = "C83DB15142BD24BE3F90F7341C1F6506", hash_generated_field = "1613EE279914B2EEC593ED6D5A8EDA25")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED =
            "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.762 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.764 -0500", hash_original_field = "BB0A098F4EF2BC260768F4AA2B2B0709", hash_generated_field = "46824CCAF8D8A297954B79F68288C27C")

    private Connection mServiceConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.767 -0500", hash_original_field = "294C5C0D7C6D28FD3AE0746E1766622A", hash_generated_field = "9260ADD518F0FEF38A450F7DB53206FF")

    private OnInitListener mInitListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.769 -0500", hash_original_field = "86E4149C637B5D060C57CAFDCA63A789", hash_generated_field = "A2396708ACA0814F0BE351469A06A94E")

    // a binder thread.
    private volatile UtteranceProgressListener mUtteranceProgressListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.771 -0500", hash_original_field = "DB5A02C3C488BC068D30AECDB58F3545", hash_generated_field = "A8116CC7E9FFC22E32CD58F7221C57D1")

    private final Object mStartLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.773 -0500", hash_original_field = "01DD4447DCC171AB23243684D88DD048", hash_generated_field = "87C8AA46082F357B5A90BEFDCD55A9CA")

    private String mRequestedEngine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.776 -0500", hash_original_field = "724B35CE2619B39A4479C54A141CD6A1", hash_generated_field = "F6B4C1579EC35D212C4AF2EE4A947247")

    private  Map<String, Uri> mEarcons;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.778 -0500", hash_original_field = "19E5D04AA55C9A18632EDAFFB9BD4AC0", hash_generated_field = "AF9F14E0A7A7BBE0D15082F4D775A15F")

    private  Map<String, Uri> mUtterances;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.780 -0500", hash_original_field = "1DC6FA24A8849A63174EB1CF5DEC335E", hash_generated_field = "0509EAD5E22611839DB01FDA008360EE")

    private final Bundle mParams = new Bundle();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.782 -0500", hash_original_field = "C96188D6044858ACAF7355DDC517BC0F", hash_generated_field = "C4FA3CBED7ED304B229BB483017A66E9")

    private  TtsEngines mEnginesHelper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.785 -0500", hash_original_field = "7A5990DF4A54BF373C395B6501E20B02", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private  String mPackageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.787 -0500", hash_original_field = "170CC40C116F7203516C8A4AC0BC7E35", hash_generated_field = "8E5DC033BD559466A27E8B7E16939D55")

    private volatile String mCurrentEngine = null;

    /**
     * The constructor for the TextToSpeech class, using the default TTS engine.
     * This will also initialize the associated TextToSpeech engine if it isn't already running.
     *
     * @param context
     *            The context this instance is running in.
     * @param listener
     *            The {@link TextToSpeech.OnInitListener} that will be called when the
     *            TextToSpeech engine has initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.789 -0500", hash_original_method = "E5C095C9A34533EB222D42D1A6D92941", hash_generated_method = "DB0023924EAB35A5131073F90BE5AF52")
    
public TextToSpeech(Context context, OnInitListener listener) {
        this(context, listener, null);
    }

    /**
     * The constructor for the TextToSpeech class, using the given TTS engine.
     * This will also initialize the associated TextToSpeech engine if it isn't already running.
     *
     * @param context
     *            The context this instance is running in.
     * @param listener
     *            The {@link TextToSpeech.OnInitListener} that will be called when the
     *            TextToSpeech engine has initialized.
     * @param engine Package name of the TTS engine to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.792 -0500", hash_original_method = "894D965EFAB67E7E0E3D1E11B990F0FA", hash_generated_method = "B77B528C353D0C2AA70AFAE103466C37")
    
public TextToSpeech(Context context, OnInitListener listener, String engine) {
        this(context, listener, engine, null);
    }

    /**
     * Used by the framework to instantiate TextToSpeech objects with a supplied
     * package name, instead of using {@link android.content.Context#getPackageName()}
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.795 -0500", hash_original_method = "0584A597F5F20737FDED0391417BF29B", hash_generated_method = "2DA20A19DB905167AB47566B52ACA4E6")
    
public TextToSpeech(Context context, OnInitListener listener, String engine,
            String packageName) {
        mContext = context;
        mInitListener = listener;
        mRequestedEngine = engine;

        mEarcons = new HashMap<String, Uri>();
        mUtterances = new HashMap<String, Uri>();
        mUtteranceProgressListener = null;

        mEnginesHelper = new TtsEngines(mContext);
        if (packageName != null) {
            mPackageName = packageName;
        } else {
            mPackageName = mContext.getPackageName();
        }
        initTts();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.797 -0500", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "D4EDD6B3F4683C2FAA619A8BA3F6D2C4")
    
private String getPackageName() {
        return mPackageName;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.472 -0400", hash_original_method = "94C951553FBC2F5928AD7C3B02D8E2C9", hash_generated_method = "8BEDEBD4C8747828322C3B505CBC3EED")
    private <R> R runActionNoReconnect(Action<R> action, R errorResult, String method) {
        addTaint(method.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(action.getTaint());
R var6CD80DC7ED7C75CB0A432FA52BFDBB11_1308670570 =         runAction(action, errorResult, method, false);
        var6CD80DC7ED7C75CB0A432FA52BFDBB11_1308670570.addTaint(taint);
        return var6CD80DC7ED7C75CB0A432FA52BFDBB11_1308670570;
        // ---------- Original Method ----------
        //return runAction(action, errorResult, method, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.472 -0400", hash_original_method = "29E7B310AE240E4C21F0167C8B8476FB", hash_generated_method = "835072A4301C23CCF2DA5AF0A87B876B")
    private <R> R runAction(Action<R> action, R errorResult, String method) {
        addTaint(method.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(action.getTaint());
R varBE0F0122D8EC62CE380C7C3C781DBEA1_2048697216 =         runAction(action, errorResult, method, true);
        varBE0F0122D8EC62CE380C7C3C781DBEA1_2048697216.addTaint(taint);
        return varBE0F0122D8EC62CE380C7C3C781DBEA1_2048697216;
        // ---------- Original Method ----------
        //return runAction(action, errorResult, method, true);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.472 -0400", hash_original_method = "6EC1A4E0A67965882D9F244E76909BAE", hash_generated_method = "612554FE1430B70C0AE6021DFDD93A61")
    private <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
        addTaint(reconnect);
        addTaint(method.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(action.getTaint());
        synchronized
(mStartLock)        {
            if(mServiceConnection == null)            
            {
R var79B35EE005A3F2115C55AE7046E4A0E2_125574140 =                 errorResult;
                var79B35EE005A3F2115C55AE7046E4A0E2_125574140.addTaint(taint);
                return var79B35EE005A3F2115C55AE7046E4A0E2_125574140;
            } //End block
R var6E73D2A7B1D3CEC549E60088058AF61B_843365152 =             mServiceConnection.runAction(action, errorResult, method, reconnect);
            var6E73D2A7B1D3CEC549E60088058AF61B_843365152.addTaint(taint);
            return var6E73D2A7B1D3CEC549E60088058AF61B_843365152;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //if (mServiceConnection == null) {
                //Log.w(TAG, method + " failed: not bound to TTS engine");
                //return errorResult;
            //}
            //return mServiceConnection.runAction(action, errorResult, method, reconnect);
        //}
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.805 -0500", hash_original_method = "001A57975E2E50499F283478CA48737A", hash_generated_method = "1864A1EDB61231599B8F13B328991905")
    
private int initTts() {
        // Step 1: Try connecting to the engine that was requested.
        if (mRequestedEngine != null && mEnginesHelper.isEngineInstalled(mRequestedEngine)) {
            if (connectToEngine(mRequestedEngine)) {
                mCurrentEngine = mRequestedEngine;
                return SUCCESS;
            }
        }

        // Step 2: Try connecting to the user's default engine.
        final String defaultEngine = getDefaultEngine();
        if (defaultEngine != null && !defaultEngine.equals(mRequestedEngine)) {
            if (connectToEngine(defaultEngine)) {
                mCurrentEngine = defaultEngine;
                return SUCCESS;
            }
        }

        // Step 3: Try connecting to the highest ranked engine in the
        // system.
        final String highestRanked = mEnginesHelper.getHighestRankedEngineName();
        if (highestRanked != null && !highestRanked.equals(mRequestedEngine) &&
                !highestRanked.equals(defaultEngine)) {
            if (connectToEngine(highestRanked)) {
                mCurrentEngine = highestRanked;
                return SUCCESS;
            }
        }

        // NOTE: The API currently does not allow the caller to query whether
        // they are actually connected to any engine. This might fail for various
        // reasons like if the user disables all her TTS engines.

        mCurrentEngine = null;
        dispatchOnInit(ERROR);
        return ERROR;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.808 -0500", hash_original_method = "5177E4BA973A00FB9C33DC0A5DBEACDB", hash_generated_method = "55356FC8457A638C1E5548F08FDDD340")
    
private boolean connectToEngine(String engine) {
        Connection connection = new Connection();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        boolean bound = mContext.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        if (!bound) {
            Log.e(TAG, "Failed to bind to " + engine);
            return false;
        } else {
            Log.i(TAG, "Sucessfully bound to " + engine);
            return true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.811 -0500", hash_original_method = "16B0CCB3D7329F5127962CE558D4D17C", hash_generated_method = "14D5262097785DA864A06C12FC47F902")
    
private void dispatchOnInit(int result) {
        synchronized (mStartLock) {
            if (mInitListener != null) {
                mInitListener.onInit(result);
                mInitListener = null;
            }
        }
    }

    /**
     * Releases the resources used by the TextToSpeech engine.
     * It is good practice for instance to call this method in the onDestroy() method of an Activity
     * so the TextToSpeech engine can be cleanly stopped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.817 -0500", hash_original_method = "EAB786CB351424B1FA3879678813021A", hash_generated_method = "DAB730F25E13AEC80174B05AB6A2CEF3")
    
public void shutdown() {
        runActionNoReconnect(new Action<Void>() {
            @Override
            public Void run(ITextToSpeechService service) throws RemoteException {
                service.setCallback(getPackageName(), null);
                service.stop(getPackageName());
                mServiceConnection.disconnect();
                // Context#unbindService does not result in a call to
                // ServiceConnection#onServiceDisconnected. As a result, the
                // service ends up being destroyed (if there are no other open
                // connections to it) but the process lives on and the
                // ServiceConnection continues to refer to the destroyed service.
                //
                // This leads to tons of log spam about SynthThread being dead.
                mServiceConnection = null;
                mCurrentEngine = null;
                return null;
            }
        }, null, "shutdown");
    }

    /**
     * Adds a mapping between a string of text and a sound resource in a
     * package. After a call to this method, subsequent calls to
     * {@link #speak(String, int, HashMap)} will play the specified sound resource
     * if it is available, or synthesize the text it is missing.
     *
     * @param text
     *            The string of text. Example: <code>"south_south_east"</code>
     *
     * @param packagename
     *            Pass the packagename of the application that contains the
     *            resource. If the resource is in your own application (this is
     *            the most common case), then put the packagename of your
     *            application here.<br/>
     *            Example: <b>"com.google.marvin.compass"</b><br/>
     *            The packagename can be found in the AndroidManifest.xml of
     *            your application.
     *            <p>
     *            <code>&lt;manifest xmlns:android=&quot;...&quot;
     *      package=&quot;<b>com.google.marvin.compass</b>&quot;&gt;</code>
     *            </p>
     *
     * @param resourceId
     *            Example: <code>R.raw.south_south_east</code>
     *
     * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.820 -0500", hash_original_method = "DD10D1EA0D37E9C3175CB1CE81EACE27", hash_generated_method = "1D8BEA60642A53880416AA335B351404")
    
public int addSpeech(String text, String packagename, int resourceId) {
        synchronized (mStartLock) {
            mUtterances.put(text, makeResourceUri(packagename, resourceId));
            return SUCCESS;
        }
    }

    /**
     * Adds a mapping between a string of text and a sound file. Using this, it
     * is possible to add custom pronounciations for a string of text.
     * After a call to this method, subsequent calls to {@link #speak(String, int, HashMap)}
     * will play the specified sound resource if it is available, or synthesize the text it is
     * missing.
     *
     * @param text
     *            The string of text. Example: <code>"south_south_east"</code>
     * @param filename
     *            The full path to the sound file (for example:
     *            "/sdcard/mysounds/hello.wav")
     *
     * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.822 -0500", hash_original_method = "DBC13E8086F9460080E153D9CAE05A02", hash_generated_method = "FCA712957D5EB36730B314BF5C8DEAAD")
    
public int addSpeech(String text, String filename) {
        synchronized (mStartLock) {
            mUtterances.put(text, Uri.parse(filename));
            return SUCCESS;
        }
    }

    /**
     * Adds a mapping between a string of text and a sound resource in a
     * package. Use this to add custom earcons.
     *
     * @see #playEarcon(String, int, HashMap)
     *
     * @param earcon The name of the earcon.
     *            Example: <code>"[tick]"</code><br/>
     *
     * @param packagename
     *            the package name of the application that contains the
     *            resource. This can for instance be the package name of your own application.
     *            Example: <b>"com.google.marvin.compass"</b><br/>
     *            The package name can be found in the AndroidManifest.xml of
     *            the application containing the resource.
     *            <p>
     *            <code>&lt;manifest xmlns:android=&quot;...&quot;
     *      package=&quot;<b>com.google.marvin.compass</b>&quot;&gt;</code>
     *            </p>
     *
     * @param resourceId
     *            Example: <code>R.raw.tick_snd</code>
     *
     * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.824 -0500", hash_original_method = "773577F8E212F06A89510B07A5731283", hash_generated_method = "21B611FD140646706908E8CBA5682894")
    
public int addEarcon(String earcon, String packagename, int resourceId) {
        synchronized(mStartLock) {
            mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
            return SUCCESS;
        }
    }

    /**
     * Adds a mapping between a string of text and a sound file.
     * Use this to add custom earcons.
     *
     * @see #playEarcon(String, int, HashMap)
     *
     * @param earcon
     *            The name of the earcon.
     *            Example: <code>"[tick]"</code>
     * @param filename
     *            The full path to the sound file (for example:
     *            "/sdcard/mysounds/tick.wav")
     *
     * @return Code indicating success or failure. See {@link #ERROR} and {@link #SUCCESS}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.826 -0500", hash_original_method = "409D0B7C115347E1FFF71FD2BD1F314E", hash_generated_method = "90F619A89369DAB6AF74E7021450C3C8")
    
public int addEarcon(String earcon, String filename) {
        synchronized(mStartLock) {
            mEarcons.put(earcon, Uri.parse(filename));
            return SUCCESS;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.829 -0500", hash_original_method = "276BC175828DCE484EB0703A6A0D8E9B", hash_generated_method = "1300F8BAF607C3ACFC1100CFAB674186")
    
private Uri makeResourceUri(String packageName, int resourceId) {
        return new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .encodedAuthority(packageName)
                .appendEncodedPath(String.valueOf(resourceId))
                .build();
    }

    /**
     * Speaks the string using the specified queuing strategy and speech
     * parameters.
     *
     * @param text The string of text to be spoken.
     * @param queueMode The queuing strategy to use, {@link #QUEUE_ADD} or {@link #QUEUE_FLUSH}.
     * @param params Parameters for the request. Can be null.
     *            Supported parameter names:
     *            {@link Engine#KEY_PARAM_STREAM},
     *            {@link Engine#KEY_PARAM_UTTERANCE_ID},
     *            {@link Engine#KEY_PARAM_VOLUME},
     *            {@link Engine#KEY_PARAM_PAN}.
     *            Engine specific parameters may be passed in but the parameter keys
     *            must be prefixed by the name of the engine they are intended for. For example
     *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
     *            engine named "com.svox.pico" if it is being used.
     *
     * @return {@link #ERROR} or {@link #SUCCESS}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.835 -0500", hash_original_method = "BE0E5C2CBBCD37525836C6DA289D2EEC", hash_generated_method = "78B19EB55365A2C2A45BAC88E91BDB08")
    
public int speak(final String text, final int queueMode, final HashMap<String, String> params) {
        return runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Uri utteranceUri = mUtterances.get(text);
                if (utteranceUri != null) {
                    return service.playAudio(getPackageName(), utteranceUri, queueMode,
                            getParams(params));
                } else {
                    return service.speak(getPackageName(), text, queueMode, getParams(params));
                }
            }
        }, ERROR, "speak");
    }

    /**
     * Plays the earcon using the specified queueing mode and parameters.
     * The earcon must already have been added with {@link #addEarcon(String, String)} or
     * {@link #addEarcon(String, String, int)}.
     *
     * @param earcon The earcon that should be played
     * @param queueMode {@link #QUEUE_ADD} or {@link #QUEUE_FLUSH}.
     * @param params Parameters for the request. Can be null.
     *            Supported parameter names:
     *            {@link Engine#KEY_PARAM_STREAM},
     *            {@link Engine#KEY_PARAM_UTTERANCE_ID}.
     *            Engine specific parameters may be passed in but the parameter keys
     *            must be prefixed by the name of the engine they are intended for. For example
     *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
     *            engine named "com.svox.pico" if it is being used.
     *
     * @return {@link #ERROR} or {@link #SUCCESS}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.841 -0500", hash_original_method = "F18AB3CD06A1E20DE6BD7099833B6FEC", hash_generated_method = "73F2ED21B5E6FF76D11AAA2EAFC0CF3C")
    
public int playEarcon(final String earcon, final int queueMode,
            final HashMap<String, String> params) {
        return runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Uri earconUri = mEarcons.get(earcon);
                if (earconUri == null) {
                    return ERROR;
                }
                return service.playAudio(getPackageName(), earconUri, queueMode,
                        getParams(params));
            }
        }, ERROR, "playEarcon");
    }

    /**
     * Plays silence for the specified amount of time using the specified
     * queue mode.
     *
     * @param durationInMs The duration of the silence.
     * @param queueMode {@link #QUEUE_ADD} or {@link #QUEUE_FLUSH}.
     * @param params Parameters for the request. Can be null.
     *            Supported parameter names:
     *            {@link Engine#KEY_PARAM_UTTERANCE_ID}.
     *            Engine specific parameters may be passed in but the parameter keys
     *            must be prefixed by the name of the engine they are intended for. For example
     *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
     *            engine named "com.svox.pico" if it is being used.
     *
     * @return {@link #ERROR} or {@link #SUCCESS}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.846 -0500", hash_original_method = "94C759FE8B677E32982F42F6A676D86E", hash_generated_method = "49A145C9AE6B5732DADE72FC8770D9AB")
    
public int playSilence(final long durationInMs, final int queueMode,
            final HashMap<String, String> params) {
        return runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                return service.playSilence(getPackageName(), durationInMs, queueMode,
                        getParams(params));
            }
        }, ERROR, "playSilence");
    }

    /**
     * Queries the engine for the set of features it supports for a given locale.
     * Features can either be framework defined, e.g.
     * {@link TextToSpeech.Engine#KEY_FEATURE_NETWORK_SYNTHESIS} or engine specific.
     * Engine specific keys must be prefixed by the name of the engine they
     * are intended for. These keys can be used as parameters to
     * {@link TextToSpeech#speak(String, int, java.util.HashMap)} and
     * {@link TextToSpeech#synthesizeToFile(String, java.util.HashMap, String)}.
     *
     * Features are boolean flags, and their values in the synthesis parameters
     * must be behave as per {@link Boolean#parseBoolean(String)}.
     *
     * @param locale The locale to query features for.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.851 -0500", hash_original_method = "8AF2E385B6F026EB817E9FE98AB99B1D", hash_generated_method = "4E35CE29E18E6B058A13D0F42DA06365")
    
public Set<String> getFeatures(final Locale locale) {
        return runAction(new Action<Set<String>>() {
            @Override
            public Set<String> run(ITextToSpeechService service) throws RemoteException {
                String[] features = service.getFeaturesForLanguage(
                        locale.getISO3Language(), locale.getISO3Country(), locale.getVariant());
                if (features != null) {
                    final Set<String> featureSet = new HashSet<String>();
                    Collections.addAll(featureSet, features);
                    return featureSet;
                }
                return null;
            }
        }, null, "getFeatures");
    }

    /**
     * Checks whether the TTS engine is busy speaking. Note that a speech item is
     * considered complete once it's audio data has been sent to the audio mixer, or
     * written to a file. There might be a finite lag between this point, and when
     * the audio hardware completes playback.
     *
     * @return {@code true} if the TTS engine is speaking.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.857 -0500", hash_original_method = "DC605D9F82407CF596B06CFECEFBD8A5", hash_generated_method = "FDF382D4BC20E46E62CBC4D085EDC79B")
    
public boolean isSpeaking() {
        return runAction(new Action<Boolean>() {
            @Override
            public Boolean run(ITextToSpeechService service) throws RemoteException {
                return service.isSpeaking();
            }
        }, false, "isSpeaking");
    }

    /**
     * Interrupts the current utterance (whether played or rendered to file) and discards other
     * utterances in the queue.
     *
     * @return {@link #ERROR} or {@link #SUCCESS}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.862 -0500", hash_original_method = "1B011279D3385FBEA81C0EEE9DDE31E7", hash_generated_method = "6D0891E8C63E8A15A192B1A3A8F8ED83")
    
public int stop() {
        return runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                return service.stop(getPackageName());
            }
        }, ERROR, "stop");
    }

    /**
     * Sets the speech rate.
     *
     * This has no effect on any pre-recorded speech.
     *
     * @param speechRate Speech rate. {@code 1.0} is the normal speech rate,
     *            lower values slow down the speech ({@code 0.5} is half the normal speech rate),
     *            greater values accelerate it ({@code 2.0} is twice the normal speech rate).
     *
     * @return {@link #ERROR} or {@link #SUCCESS}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.864 -0500", hash_original_method = "6950E84EE314E7032010233B0706B078", hash_generated_method = "CF78FA347B116B8BC5D0C2BA03058EDA")
    
public int setSpeechRate(float speechRate) {
        if (speechRate > 0.0f) {
            int intRate = (int)(speechRate * 100);
            if (intRate > 0) {
                synchronized (mStartLock) {
                    mParams.putInt(Engine.KEY_PARAM_RATE, intRate);
                }
                return SUCCESS;
            }
        }
        return ERROR;
    }

    /**
     * Sets the speech pitch for the TextToSpeech engine.
     *
     * This has no effect on any pre-recorded speech.
     *
     * @param pitch Speech pitch. {@code 1.0} is the normal pitch,
     *            lower values lower the tone of the synthesized voice,
     *            greater values increase it.
     *
     * @return {@link #ERROR} or {@link #SUCCESS}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.868 -0500", hash_original_method = "7DADB23AB82E5180649E2697B1338160", hash_generated_method = "F4F362DE2FFFF4DF81E98DAB385C789C")
    
public int setPitch(float pitch) {
        if (pitch > 0.0f) {
            int intPitch = (int)(pitch * 100);
            if (intPitch > 0) {
                synchronized (mStartLock) {
                    mParams.putInt(Engine.KEY_PARAM_PITCH, intPitch);
                }
                return SUCCESS;
            }
        }
        return ERROR;
    }

    /**
     * @return the engine currently in use by this TextToSpeech instance.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.870 -0500", hash_original_method = "6F277B1B16E884F81974EA73065A64D8", hash_generated_method = "7B3DE1D09317EEFD1148729DA273942E")
    
public String getCurrentEngine() {
        return mCurrentEngine;
    }

    /**
     * Sets the text-to-speech language.
     * The TTS engine will try to use the closest match to the specified
     * language as represented by the Locale, but there is no guarantee that the exact same Locale
     * will be used. Use {@link #isLanguageAvailable(Locale)} to check the level of support
     * before choosing the language to use for the next utterances.
     *
     * @param loc The locale describing the language to be used.
     *
     * @return Code indicating the support status for the locale. See {@link #LANG_AVAILABLE},
     *         {@link #LANG_COUNTRY_AVAILABLE}, {@link #LANG_COUNTRY_VAR_AVAILABLE},
     *         {@link #LANG_MISSING_DATA} and {@link #LANG_NOT_SUPPORTED}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.876 -0500", hash_original_method = "4B10A46E0E63D1391FC966E12E9B561D", hash_generated_method = "BC87FB6DD68FF08AD982B393B7308B67")
    
public int setLanguage(final Locale loc) {
        return runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                if (loc == null) {
                    return LANG_NOT_SUPPORTED;
                }
                String language = loc.getISO3Language();
                String country = loc.getISO3Country();
                String variant = loc.getVariant();
                // Check if the language, country, variant are available, and cache
                // the available parts.
                // Note that the language is not actually set here, instead it is cached so it
                // will be associated with all upcoming utterances.
                int result = service.loadLanguage(language, country, variant);
                if (result >= LANG_AVAILABLE){
                    if (result < LANG_COUNTRY_VAR_AVAILABLE) {
                        variant = "";
                        if (result < LANG_COUNTRY_AVAILABLE) {
                            country = "";
                        }
                    }
                    mParams.putString(Engine.KEY_PARAM_LANGUAGE, language);
                    mParams.putString(Engine.KEY_PARAM_COUNTRY, country);
                    mParams.putString(Engine.KEY_PARAM_VARIANT, variant);
                }
                return result;
            }
        }, LANG_NOT_SUPPORTED, "setLanguage");
    }

    /**
     * Returns a Locale instance describing the language currently being used by the TextToSpeech
     * engine.
     *
     * @return language, country (if any) and variant (if any) used by the engine stored in a Locale
     *     instance, or {@code null} on error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.882 -0500", hash_original_method = "BC427E909E00C5BE5A5F111E336651C0", hash_generated_method = "610B9C13B54862D2C4CEF2D05C24FBA7")
    
public Locale getLanguage() {
        return runAction(new Action<Locale>() {
            @Override
            public Locale run(ITextToSpeechService service) throws RemoteException {
                String[] locStrings = service.getLanguage();
                if (locStrings != null && locStrings.length == 3) {
                    return new Locale(locStrings[0], locStrings[1], locStrings[2]);
                }
                return null;
            }
        }, null, "getLanguage");
    }
    
    public class Engine {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.660 -0500", hash_original_field = "DD4FAA2B6EDFFC4B787C777868DFA7AB", hash_generated_field = "6EA685DC1F94714F1A1A1A053FC21028")

        public static final int DEFAULT_RATE = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.663 -0500", hash_original_field = "0FB7772C932BF98033761D22F6B9B102", hash_generated_field = "7265570D9BCE2101E8993107FABA1337")

        public static final int DEFAULT_PITCH = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.665 -0500", hash_original_field = "6BBD876116083F4FDCF3FE6B3C4C4C49", hash_generated_field = "95742929B161124D7ABDF4B245140DE7")

        public static final float DEFAULT_VOLUME = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.668 -0500", hash_original_field = "3925650A36A480813438CEFF1A5C65EE", hash_generated_field = "BDDAA621A92D5CA41E24125645C10B9B")

        public static final float DEFAULT_PAN = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.671 -0500", hash_original_field = "20252C12473C30FB6BC6A7170B70E9A2", hash_generated_field = "79A00612A369353FB0B563BBFBDD7A1F")

        public static final int USE_DEFAULTS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.673 -0500", hash_original_field = "09790C5C54DFC02849BDF0FDCC9B3592", hash_generated_field = "E67C17E73F19BA85E706AEDE17D00422")

        /**
         * Package name of the default TTS engine.
         *
         * @hide
         * @deprecated No longer in use, the default engine is determined by
         *         the sort order defined in {@link TtsEngines}. Note that
         *         this doesn't "break" anything because there is no guarantee that
         *         the engine specified below is installed on a given build, let
         *         alone be the default.
         */
        @Deprecated
        public static final String DEFAULT_ENGINE = "com.svox.pico";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.677 -0500", hash_original_field = "D3B9A54C41BBAA120A3E0B42624998AB", hash_generated_field = "C75C9F49D040B89D31A5EEE24181A5F2")

        public static final int DEFAULT_STREAM = AudioManager.STREAM_MUSIC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.679 -0500", hash_original_field = "512607B926CB557E66AB8CA75AD14DCF", hash_generated_field = "C254DAAF5EBFA8002B27291ACC23702C")

        public static final int CHECK_VOICE_DATA_PASS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.682 -0500", hash_original_field = "5C808E3EFA9E533E438DB208B9EA458B", hash_generated_field = "E9C03161A9F0FFF5472A0040222D4C52")

        public static final int CHECK_VOICE_DATA_FAIL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.684 -0500", hash_original_field = "265E77DEB872FE737D0615EA840DFFFA", hash_generated_field = "431FD9B6D302AD606FFE065DF75DD2FA")

        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.687 -0500", hash_original_field = "64FB7534375C5DDE7BF3995B165AFD59", hash_generated_field = "7387564E7167154EEFED8705FCA0EED8")

        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.689 -0500", hash_original_field = "C00D2C5BD9D5553A9D55F500831507E2", hash_generated_field = "183E08CD13799093F5F5A44B05FDE73C")

        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.692 -0500", hash_original_field = "DEEB96CF65BD502979EAC068C82C3BD8", hash_generated_field = "CAF4E59B3718CCEA9FF9E5188B9F6370")

        @SdkConstant(SdkConstantType.SERVICE_ACTION)
        public static final String INTENT_ACTION_TTS_SERVICE =
                "android.intent.action.TTS_SERVICE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.694 -0500", hash_original_field = "282800AA4E4C017BC31C2E96173862D6", hash_generated_field = "1838FC1E408F29335D36A08788A826E6")

        public static final String SERVICE_META_DATA = "android.speech.tts";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.697 -0500", hash_original_field = "3D5F01602701564AA42F7544DC83F83F", hash_generated_field = "201E63002B52979561B02D290B342122")

        /**
         * Activity Action: Triggers the platform TextToSpeech engine to
         * start the activity that installs the resource files on the device
         * that are required for TTS to be operational. Since the installation
         * of the data can be interrupted or declined by the user, the application
         * shouldn't expect successful installation upon return from that intent,
         * and if need be, should check installation status with
         * {@link #ACTION_CHECK_TTS_DATA}.
         */
        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_INSTALL_TTS_DATA =
                "android.speech.tts.engine.INSTALL_TTS_DATA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.701 -0500", hash_original_field = "47FB447E53FACBAAD28E02874B48851D", hash_generated_field = "A33F17727F43DBD7A47E893BB9B716B9")

        @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
        public static final String ACTION_TTS_DATA_INSTALLED =
                "android.speech.tts.engine.TTS_DATA_INSTALLED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.703 -0500", hash_original_field = "162B24C6A16529CA3A821EEE5C6BAE96", hash_generated_field = "43F20E850CE384CB5D9C74DD369FDD87")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_CHECK_TTS_DATA =
                "android.speech.tts.engine.CHECK_TTS_DATA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.706 -0500", hash_original_field = "F6EDAFDA9E8C2665122AECF163C861AA", hash_generated_field = "58E16B540735E811A37625B0342CFA0F")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_GET_SAMPLE_TEXT =
                "android.speech.tts.engine.GET_SAMPLE_TEXT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.709 -0500", hash_original_field = "524D8775511C88B18F0DDD8E8DA189CA", hash_generated_field = "A2E8C3A43C454E554DF7AB6896C4C7AE")

        /**
         * Extra information received with the {@link #ACTION_CHECK_TTS_DATA} intent where
         * the TextToSpeech engine specifies the path to its resources.
         */
        public static final String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.711 -0500", hash_original_field = "B74E7FBFF5ACC7DBFF5EF531FDBE9F63", hash_generated_field = "2FCEBB35020F29546E39463BDD214A73")

        public static final String EXTRA_VOICE_DATA_FILES = "dataFiles";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.713 -0500", hash_original_field = "32A566C947724BAC4B39FE4B56C0F04C", hash_generated_field = "23CB204D3DC0650A224FB5ABA98F25A7")

        public static final String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.716 -0500", hash_original_field = "9692134613D5F5138A07EEA3E8ACC9C4", hash_generated_field = "A5FF7832C171B046C21F825764FE8230")

        public static final String EXTRA_AVAILABLE_VOICES = "availableVoices";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.718 -0500", hash_original_field = "E55BAA213FE591A00B78978813630674", hash_generated_field = "AC4770FDD8C95CC92539FC82143B39C5")

        public static final String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.721 -0500", hash_original_field = "E29B3316540C5150D08C581473EB9608", hash_generated_field = "C8E0905A88A840D679AC2FF9508E3712")

        public static final String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.724 -0500", hash_original_field = "41CF2F4FDC004D1FF78BAFB5946336B3", hash_generated_field = "23DBDBE14B277A6958D66D580A9AA9D0")

        /**
         * Extra information received with the {@link #ACTION_TTS_DATA_INSTALLED} intent.
         * It indicates whether the data files for the synthesis engine were successfully
         * installed. The installation was initiated with the  {@link #ACTION_INSTALL_TTS_DATA}
         * intent. The possible values for this extra are
         * {@link TextToSpeech#SUCCESS} and {@link TextToSpeech#ERROR}.
         */
        public static final String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.726 -0500", hash_original_field = "9A68B31E22C4A89760C4EF289A9AFB05", hash_generated_field = "624C7A92F601707654AA5577BE9E16DC")

        // to maintain engine state for each TextToSpeech instance.
        /**
         * @hide
         */
        public static final String KEY_PARAM_RATE = "rate";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.729 -0500", hash_original_field = "D4AE44F8F670CB4CB3A0AE03C566E1AE", hash_generated_field = "41A112801807BF60F6B64B56EABC75A7")

        public static final String KEY_PARAM_LANGUAGE = "language";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.731 -0500", hash_original_field = "B541858026446E019570CB77E0F66875", hash_generated_field = "B9529957E3604F14146602846E9977A5")

        public static final String KEY_PARAM_COUNTRY = "country";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.734 -0500", hash_original_field = "DB989654DAED4364DAA3F4A61E78EF8A", hash_generated_field = "194C150941509AFA9F06806544278558")

        public static final String KEY_PARAM_VARIANT = "variant";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.737 -0500", hash_original_field = "4A2D017471DC6EF4C08041124E79C27E", hash_generated_field = "5790995E2173B750C19C7F0DF730BD18")

        public static final String KEY_PARAM_ENGINE = "engine";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.739 -0500", hash_original_field = "9086D077B270556500D114CCEDD85A8F", hash_generated_field = "3BDB1A8EA9944800172EB2E01D630D39")

        public static final String KEY_PARAM_PITCH = "pitch";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.742 -0500", hash_original_field = "F2E9C668E0A45DD8EF310DB5F0BF69FC", hash_generated_field = "AA44CC9D49E0D6103F2E361CC4DC18B0")

        public static final String KEY_PARAM_STREAM = "streamType";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.745 -0500", hash_original_field = "DB697DD21E7D308ED4A7C127216B4D68", hash_generated_field = "D01CCD0CAFBD7B77262BEE4DF757451B")

        public static final String KEY_PARAM_UTTERANCE_ID = "utteranceId";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.748 -0500", hash_original_field = "20C97C1CE19896754C26BAA90DA75D96", hash_generated_field = "F31741CDDA9583A05DBFC466602DB856")

        public static final String KEY_PARAM_VOLUME = "volume";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.750 -0500", hash_original_field = "BBBDEAE1CE0E8AB599E92BC5226758A3", hash_generated_field = "5C33025FF7CAEFB03AF35CC41A77E51F")

        public static final String KEY_PARAM_PAN = "pan";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.752 -0500", hash_original_field = "ED7D5845A160216EB3A67D92E5AC3DC8", hash_generated_field = "9C632C8E548D61E23BCBF91A78385C5A")

        public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.755 -0500", hash_original_field = "2F928B0BAFF7EA01733E9949DDA0D5D2", hash_generated_field = "367B7447EF0E1BB5CDEB71ED7EF27786")

        public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.485 -0400", hash_original_method = "0CEE966FD083EAF9A38425EF355FEEF7", hash_generated_method = "0CEE966FD083EAF9A38425EF355FEEF7")
        public Engine ()
        {
            //Synthesized constructor
        }
    }
    
    private class Connection implements ServiceConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.920 -0500", hash_original_field = "21BB9A18C241F11B90BD168F6EFD8119", hash_generated_field = "D3C3F8FD9BA670292396CDDDD2DBC0CC")

        private ITextToSpeechService mService;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.357 -0400", hash_original_field = "E1D8F791D3BB3666B7074B1777047AD0", hash_generated_field = "8BD4C977E187C06AE0FA8E41601DDC82")

        private final ITextToSpeechCallback.Stub mCallback = new ITextToSpeechCallback.Stub() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.356 -0400", hash_original_method = "5A69319C8BD2B805ED99ED76716CFEEE", hash_generated_method = "C36FD71BC5968822F50D75F6D7641286")
            @Override
            public void onDone(String utteranceId) {
                
                UtteranceProgressListener listener = mUtteranceProgressListener;
                {
                    listener.onDone(utteranceId);
                } 
                addTaint(utteranceId.getTaint());
                
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.357 -0400", hash_original_method = "71BFFA04ED8551E163779942DCEAA326", hash_generated_method = "BFEBE931F4A282E2199C01DE22C7D8D5")
            @Override
            public void onError(String utteranceId) {
                
                UtteranceProgressListener listener = mUtteranceProgressListener;
                {
                    listener.onError(utteranceId);
                } 
                addTaint(utteranceId.getTaint());
                
            }
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.357 -0400", hash_original_method = "AC6831F715B5A1560C1EB20081DD1B2E", hash_generated_method = "7FB994A124F9001B2239D7AE9A074095")
            @Override
            public void onStart(String utteranceId) {
                
                UtteranceProgressListener listener = mUtteranceProgressListener;
                {
                    listener.onStart(utteranceId);
                } 
                addTaint(utteranceId.getTaint());
                
            }
            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.487 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
        public Connection ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.935 -0500", hash_original_method = "E38F495B4498EDF08C66FB9F592C4572", hash_generated_method = "44AAFFE2FDED94774BCA88DDA24E4269")
        
public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "Connected to " + name);
            synchronized(mStartLock) {
                if (mServiceConnection != null) {
                    // Disconnect any previous service connection
                    mServiceConnection.disconnect();
                }
                mServiceConnection = this;
                mService = ITextToSpeechService.Stub.asInterface(service);
                try {
                    mService.setCallback(getPackageName(), mCallback);
                    dispatchOnInit(SUCCESS);
                } catch (RemoteException re) {
                    Log.e(TAG, "Error connecting to service, setCallback() failed");
                    dispatchOnInit(ERROR);
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.937 -0500", hash_original_method = "9CBB724FFDF56C58A2F363CBB7ADEB66", hash_generated_method = "E2AF069D6FE74E902E89D53034B8FD7A")
        
public void onServiceDisconnected(ComponentName name) {
            synchronized(mStartLock) {
                mService = null;
                // If this is the active connection, clear it
                if (mServiceConnection == this) {
                    mServiceConnection = null;
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.939 -0500", hash_original_method = "670DB56217535BA78AC55188B9013676", hash_generated_method = "A1E17E3F48576D4371025199E731BA0F")
        
public void disconnect() {
            mContext.unbindService(this);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.487 -0400", hash_original_method = "34464E55B5499CA206CC99D3045C1292", hash_generated_method = "27193611E0B349FA2F74596F34D8B6CD")
        public <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
            addTaint(reconnect);
            addTaint(method.getTaint());
            addTaint(errorResult.getTaint());
            addTaint(action.getTaint());
            try 
            {
                synchronized
(mStartLock)                {
                    if(mService == null)                    
                    {
R var79B35EE005A3F2115C55AE7046E4A0E2_305781130 =                         errorResult;
                        var79B35EE005A3F2115C55AE7046E4A0E2_305781130.addTaint(taint);
                        return var79B35EE005A3F2115C55AE7046E4A0E2_305781130;
                    } //End block
R varD2997F7A1AE93B1FCC30EEA67FF3D50D_1331602775 =                     action.run(mService);
                    varD2997F7A1AE93B1FCC30EEA67FF3D50D_1331602775.addTaint(taint);
                    return varD2997F7A1AE93B1FCC30EEA67FF3D50D_1331602775;
                } //End block
            } //End block
            catch (RemoteException ex)
            {
                if(reconnect)                
                {
                    disconnect();
                    initTts();
                } //End block
R var79B35EE005A3F2115C55AE7046E4A0E2_113215503 =                 errorResult;
                var79B35EE005A3F2115C55AE7046E4A0E2_113215503.addTaint(taint);
                return var79B35EE005A3F2115C55AE7046E4A0E2_113215503;
            } //End block
            // ---------- Original Method ----------
            //try {
                //synchronized (mStartLock) {
                    //if (mService == null) {
                        //Log.w(TAG, method + " failed: not connected to TTS engine");
                        //return errorResult;
                    //}
                    //return action.run(mService);
                //}
            //} catch (RemoteException ex) {
                //Log.e(TAG, method + " failed", ex);
                //if (reconnect) {
                    //disconnect();
                    //initTts();
                //}
                //return errorResult;
            //}
        }
        
    }
    
    public static class EngineInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.949 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.952 -0500", hash_original_field = "70D504428E5C639AB422D258A4592324", hash_generated_field = "B1C3A1439C6538148E2C8C0A71DA201D")

        public String label;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.954 -0500", hash_original_field = "107298D9FB7BD66B47A702264D3B04F5", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.956 -0500", hash_original_field = "016E96A32B19F608119986960AC1140B", hash_generated_field = "D1DBA00001B7F415431AD6FCAB5BAA5D")

        public boolean system;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.958 -0500", hash_original_field = "4AD9F2E37B35E313CD211FBAFDADA238", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

        public int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_method = "1BD677F38EE0D51841725F2C2D5029FA", hash_generated_method = "1BD677F38EE0D51841725F2C2D5029FA")
        public EngineInfo ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.961 -0500", hash_original_method = "2BF343FE966C95427B565E993C403E36", hash_generated_method = "61EAFEADD24724A45A6E554E1B0CDB90")
        
@Override
        public String toString() {
            return "EngineInfo{name=" + name + "}";
        }
        
    }
    
    public interface OnInitListener {
        
        public void onInit(int status);
    }
    
    public interface OnUtteranceCompletedListener {
        
        public void onUtteranceCompleted(String utteranceId);
    }
    
    private interface Action<R> {
        R run(ITextToSpeechService service) throws RemoteException;
    }

    /**
     * Checks if the specified language as represented by the Locale is available and supported.
     *
     * @param loc The Locale describing the language to be used.
     *
     * @return Code indicating the support status for the locale. See {@link #LANG_AVAILABLE},
     *         {@link #LANG_COUNTRY_AVAILABLE}, {@link #LANG_COUNTRY_VAR_AVAILABLE},
     *         {@link #LANG_MISSING_DATA} and {@link #LANG_NOT_SUPPORTED}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.888 -0500", hash_original_method = "4344244CB1F796DE537DEBF5170866A9", hash_generated_method = "F539D176723A9B78E38EA7A176D375FF")
    
public int isLanguageAvailable(final Locale loc) {
        return runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                return service.isLanguageAvailable(loc.getISO3Language(),
                        loc.getISO3Country(), loc.getVariant());
            }
        }, LANG_NOT_SUPPORTED, "isLanguageAvailable");
    }

    /**
     * Synthesizes the given text to a file using the specified parameters.
     *
     * @param text The text that should be synthesized
     * @param params Parameters for the request. Can be null.
     *            Supported parameter names:
     *            {@link Engine#KEY_PARAM_UTTERANCE_ID}.
     *            Engine specific parameters may be passed in but the parameter keys
     *            must be prefixed by the name of the engine they are intended for. For example
     *            the keys "com.svox.pico_foo" and "com.svox.pico:bar" will be passed to the
     *            engine named "com.svox.pico" if it is being used.
     * @param filename Absolute file filename to write the generated audio data to.It should be
     *            something like "/sdcard/myappsounds/mysound.wav".
     *
     * @return {@link #ERROR} or {@link #SUCCESS}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.893 -0500", hash_original_method = "59A7F0A106B55E8A59A4D44C2073C3C6", hash_generated_method = "90E3CFE0C96CC197892664DCB51072B6")
    
public int synthesizeToFile(final String text, final HashMap<String, String> params,
            final String filename) {
        return runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                return service.synthesizeToFile(getPackageName(), text, filename,
                        getParams(params));
            }
        }, ERROR, "synthesizeToFile");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.895 -0500", hash_original_method = "F4A729CBEB92036D830EC51C9E6B27A9", hash_generated_method = "6F024215E8F0CBFEEF24D0B43544E887")
    
private Bundle getParams(HashMap<String, String> params) {
        if (params != null && !params.isEmpty()) {
            Bundle bundle = new Bundle(mParams);
            copyIntParam(bundle, params, Engine.KEY_PARAM_STREAM);
            copyStringParam(bundle, params, Engine.KEY_PARAM_UTTERANCE_ID);
            copyFloatParam(bundle, params, Engine.KEY_PARAM_VOLUME);
            copyFloatParam(bundle, params, Engine.KEY_PARAM_PAN);

            // Copy feature strings defined by the framework.
            copyStringParam(bundle, params, Engine.KEY_FEATURE_NETWORK_SYNTHESIS);
            copyStringParam(bundle, params, Engine.KEY_FEATURE_EMBEDDED_SYNTHESIS);

            // Copy over all parameters that start with the name of the
            // engine that we are currently connected to. The engine is
            // free to interpret them as it chooses.
            if (!TextUtils.isEmpty(mCurrentEngine)) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    final String key = entry.getKey();
                    if (key != null && key.startsWith(mCurrentEngine)) {
                        bundle.putString(key, entry.getValue());
                    }
                }
            }

            return bundle;
        } else {
            return mParams;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.897 -0500", hash_original_method = "CA756292003AA5F2AACD5FD8062D880F", hash_generated_method = "5329041D79789C0257C21005A4DB6000")
    
private void copyStringParam(Bundle bundle, HashMap<String, String> params, String key) {
        String value = params.get(key);
        if (value != null) {
            bundle.putString(key, value);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.900 -0500", hash_original_method = "D148C993B4D17B611EC6A14A9B3B3D7B", hash_generated_method = "D9AB5E9A1FF9CB069E893FDCAA00CB6C")
    
private void copyIntParam(Bundle bundle, HashMap<String, String> params, String key) {
        String valueString = params.get(key);
        if (!TextUtils.isEmpty(valueString)) {
            try {
                int value = Integer.parseInt(valueString);
                bundle.putInt(key, value);
            } catch (NumberFormatException ex) {
                // don't set the value in the bundle
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.902 -0500", hash_original_method = "335CA474B2AA628361250A653672DD72", hash_generated_method = "C6C9FDA332AD044D4E36183DC491210D")
    
private void copyFloatParam(Bundle bundle, HashMap<String, String> params, String key) {
        String valueString = params.get(key);
        if (!TextUtils.isEmpty(valueString)) {
            try {
                float value = Float.parseFloat(valueString);
                bundle.putFloat(key, value);
            } catch (NumberFormatException ex) {
                // don't set the value in the bundle
            }
        }
    }

    /**
     * Sets the listener that will be notified when synthesis of an utterance completes.
     *
     * @param listener The listener to use.
     *
     * @return {@link #ERROR} or {@link #SUCCESS}.
     *
     * @deprecated Use {@link #setOnUtteranceProgressListener(UtteranceProgressListener)}
     *        instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.905 -0500", hash_original_method = "24D73865C05CC11CAA8C791D8BA56024", hash_generated_method = "1D8F482EE17CE53A16C9EF8377CCF2B9")
    
@Deprecated
    public int setOnUtteranceCompletedListener(final OnUtteranceCompletedListener listener) {
        mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        return TextToSpeech.SUCCESS;
    }

    /**
     * Sets the listener that will be notified of various events related to the
     * synthesis of a given utterance.
     *
     * See {@link UtteranceProgressListener} and
     * {@link TextToSpeech.Engine#KEY_PARAM_UTTERANCE_ID}.
     *
     * @param listener the listener to use.
     * @return {@link #ERROR} or {@link #SUCCESS}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.909 -0500", hash_original_method = "98074E19965AB76BE23153F0217E2857", hash_generated_method = "8BF8B2590D841C769CC31866B06ED9B9")
    
public int setOnUtteranceProgressListener(UtteranceProgressListener listener) {
        mUtteranceProgressListener = listener;
        return TextToSpeech.SUCCESS;
    }

    /**
     * Sets the TTS engine to use.
     *
     * @deprecated This doesn't inform callers when the TTS engine has been
     *        initialized. {@link #TextToSpeech(Context, OnInitListener, String)}
     *        can be used with the appropriate engine name. Also, there is no
     *        guarantee that the engine specified will be loaded. If it isn't
     *        installed or disabled, the user / system wide defaults will apply.
     *
     * @param enginePackageName The package name for the synthesis engine (e.g. "com.svox.pico")
     *
     * @return {@link #ERROR} or {@link #SUCCESS}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.911 -0500", hash_original_method = "06FE1E6C6795B03B25AD43DFED268D92", hash_generated_method = "00BED59A18C06AB2FB47DC0DB30FEEEB")
    
@Deprecated
    public int setEngineByPackageName(String enginePackageName) {
        mRequestedEngine = enginePackageName;
        return initTts();
    }

    /**
     * Gets the package name of the default speech synthesis engine.
     *
     * @return Package name of the TTS engine that the user has chosen
     *        as their default.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.913 -0500", hash_original_method = "AAA28EF74B57D47AEDCF93243FD04D81", hash_generated_method = "772EF1D56C94BAFF878FA584C4BDBE7A")
    
public String getDefaultEngine() {
        return mEnginesHelper.getDefaultEngine();
    }

    /**
     * Checks whether the user's settings should override settings requested
     * by the calling application. As of the Ice cream sandwich release,
     * user settings never forcibly override the app's settings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.915 -0500", hash_original_method = "FDBC18F088428D1AA4FA407CF8A38EB5", hash_generated_method = "67638FD3097744011A61C1E400B95CBF")
    
public boolean areDefaultsEnforced() {
        return false;
    }

    /**
     * Gets a list of all installed TTS engines.
     *
     * @return A list of engine info objects. The list can be empty, but never {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:53.917 -0500", hash_original_method = "C282EF17EB1B4600865CB51DA0934709", hash_generated_method = "7941E360898875DDF37668F270DFE3F5")
    
public List<EngineInfo> getEngines() {
        return mEnginesHelper.getEngines();
    }
}

