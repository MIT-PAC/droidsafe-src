package android.speech.tts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class TextToSpeech {
    private Context mContext;
    private Connection mServiceConnection;
    private OnInitListener mInitListener;
    private volatile UtteranceProgressListener mUtteranceProgressListener;
    private Object mStartLock = new Object();
    private String mRequestedEngine;
    private Map<String, Uri> mEarcons;
    private Map<String, Uri> mUtterances;
    private Bundle mParams = new Bundle();
    private TtsEngines mEnginesHelper;
    private String mPackageName;
    private volatile String mCurrentEngine = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.257 -0400", hash_original_method = "E5C095C9A34533EB222D42D1A6D92941", hash_generated_method = "6B10F0D12443556EE033E1329CB9FA87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextToSpeech(Context context, OnInitListener listener) {
        this(context, listener, null);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.257 -0400", hash_original_method = "894D965EFAB67E7E0E3D1E11B990F0FA", hash_generated_method = "3F8D68E64BAD5E1789D56236D235D000")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextToSpeech(Context context, OnInitListener listener, String engine) {
        this(context, listener, engine, null);
        dsTaint.addTaint(engine);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.258 -0400", hash_original_method = "0584A597F5F20737FDED0391417BF29B", hash_generated_method = "E15D340E5D1EE6E90CB89832BF38DBB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextToSpeech(Context context, OnInitListener listener, String engine,
            String packageName) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(engine);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mEarcons = new HashMap<String, Uri>();
        mUtterances = new HashMap<String, Uri>();
        mUtteranceProgressListener = null;
        mEnginesHelper = new TtsEngines(mContext);
        {
            mPackageName = mContext.getPackageName();
        } //End block
        initTts();
        // ---------- Original Method ----------
        //mContext = context;
        //mInitListener = listener;
        //mRequestedEngine = engine;
        //mEarcons = new HashMap<String, Uri>();
        //mUtterances = new HashMap<String, Uri>();
        //mUtteranceProgressListener = null;
        //mEnginesHelper = new TtsEngines(mContext);
        //if (packageName != null) {
            //mPackageName = packageName;
        //} else {
            //mPackageName = mContext.getPackageName();
        //}
        //initTts();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.258 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "AE81D35EB6425E1BFF3A3DE73764EA4C")
    @DSModeled(DSC.SAFE)
    private String getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.258 -0400", hash_original_method = "94C951553FBC2F5928AD7C3B02D8E2C9", hash_generated_method = "047FBFEFA006348495A2FFB59BA32F95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <R> R runActionNoReconnect(Action<R> action, R errorResult, String method) {
        dsTaint.addTaint(action.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(errorResult.dsTaint);
        R var9BEF42F8A9C81E69D4349C4B56482084_1695655461 = (runAction(action, errorResult, method, false));
        return (R)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return runAction(action, errorResult, method, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.258 -0400", hash_original_method = "29E7B310AE240E4C21F0167C8B8476FB", hash_generated_method = "4AC8D2F3D7D0F8C95E26F813D339DBD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <R> R runAction(Action<R> action, R errorResult, String method) {
        dsTaint.addTaint(action.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(errorResult.dsTaint);
        R varA322373C3CB1722F7DDB6E468C5D6732_2020624034 = (runAction(action, errorResult, method, true));
        return (R)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return runAction(action, errorResult, method, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.259 -0400", hash_original_method = "6EC1A4E0A67965882D9F244E76909BAE", hash_generated_method = "E38E1D42DA4B87A91C188D7C8C4DFBE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
        dsTaint.addTaint(reconnect);
        dsTaint.addTaint(action.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(errorResult.dsTaint);
        {
            R var7C0DC93A0C217AAFD716074E55158CDC_1953943946 = (mServiceConnection.runAction(action, errorResult, method, reconnect));
        } //End block
        return (R)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //if (mServiceConnection == null) {
                //Log.w(TAG, method + " failed: not bound to TTS engine");
                //return errorResult;
            //}
            //return mServiceConnection.runAction(action, errorResult, method, reconnect);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.259 -0400", hash_original_method = "001A57975E2E50499F283478CA48737A", hash_generated_method = "78387DFEC314F4C4E7A761A5D521AC29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int initTts() {
        {
            boolean varC76336549734AD44BDCB678BF01D59F2_2060026853 = (mRequestedEngine != null && mEnginesHelper.isEngineInstalled(mRequestedEngine));
            {
                {
                    boolean var8911BEC7CCD0FB9FC7E4675F4D27106A_423175391 = (connectToEngine(mRequestedEngine));
                    {
                        mCurrentEngine = mRequestedEngine;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String defaultEngine;
        defaultEngine = getDefaultEngine();
        {
            boolean varABC6D22B8FBEAE604936A23D49D6DDD0_1306112627 = (defaultEngine != null && !defaultEngine.equals(mRequestedEngine));
            {
                {
                    boolean var7836D76553A5F05531279189C3A7B50A_1170279219 = (connectToEngine(defaultEngine));
                    {
                        mCurrentEngine = defaultEngine;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String highestRanked;
        highestRanked = mEnginesHelper.getHighestRankedEngineName();
        {
            boolean var1A9867EA58712819C70FBE667FD48C74_1089394674 = (highestRanked != null && !highestRanked.equals(mRequestedEngine) &&
                !highestRanked.equals(defaultEngine));
            {
                {
                    boolean varB08B03620CB751C6F0BCA99823142EEF_1547712600 = (connectToEngine(highestRanked));
                    {
                        mCurrentEngine = highestRanked;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mCurrentEngine = null;
        dispatchOnInit(ERROR);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.259 -0400", hash_original_method = "5177E4BA973A00FB9C33DC0A5DBEACDB", hash_generated_method = "6DB85652908F22E79AE245FC235D751F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean connectToEngine(String engine) {
        dsTaint.addTaint(engine);
        Connection connection;
        connection = new Connection();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        boolean bound;
        bound = mContext.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Connection connection = new Connection();
        //Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        //intent.setPackage(engine);
        //boolean bound = mContext.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        //if (!bound) {
            //Log.e(TAG, "Failed to bind to " + engine);
            //return false;
        //} else {
            //Log.i(TAG, "Sucessfully bound to " + engine);
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.260 -0400", hash_original_method = "16B0CCB3D7329F5127962CE558D4D17C", hash_generated_method = "4AE1D74A8882AFA8D8032D87B3560717")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dispatchOnInit(int result) {
        dsTaint.addTaint(result);
        {
            {
                mInitListener.onInit(result);
                mInitListener = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //if (mInitListener != null) {
                //mInitListener.onInit(result);
                //mInitListener = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.260 -0400", hash_original_method = "EAB786CB351424B1FA3879678813021A", hash_generated_method = "71CC8404FDBD3172BDE7414E32CCF93B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdown() {
        runActionNoReconnect(new Action<Void>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.260 -0400", hash_original_method = "1C176575622D770489EE559F23BB4FED", hash_generated_method = "272CE0CE70BE847A23731DFA1C84CCC7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Void run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                service.setCallback(getPackageName(), null);
                service.stop(getPackageName());
                mServiceConnection.disconnect();
                mServiceConnection = null;
                mCurrentEngine = null;
                return (Void)dsTaint.getTaint();
                // ---------- Original Method ----------
                //service.setCallback(getPackageName(), null);
                //service.stop(getPackageName());
                //mServiceConnection.disconnect();
                //mServiceConnection = null;
                //mCurrentEngine = null;
                //return null;
            }
}, null, "shutdown");
        // ---------- Original Method ----------
        //runActionNoReconnect(new Action<Void>() {
            //@Override
            //public Void run(ITextToSpeechService service) throws RemoteException {
                //service.setCallback(getPackageName(), null);
                //service.stop(getPackageName());
                //mServiceConnection.disconnect();
                //mServiceConnection = null;
                //mCurrentEngine = null;
                //return null;
            //}
        //}, null, "shutdown");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.260 -0400", hash_original_method = "DD10D1EA0D37E9C3175CB1CE81EACE27", hash_generated_method = "FA18A9183DE78E5B6BF52E162F15315C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int addSpeech(String text, String packagename, int resourceId) {
        dsTaint.addTaint(resourceId);
        dsTaint.addTaint(text);
        dsTaint.addTaint(packagename);
        {
            mUtterances.put(text, makeResourceUri(packagename, resourceId));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //mUtterances.put(text, makeResourceUri(packagename, resourceId));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.261 -0400", hash_original_method = "DBC13E8086F9460080E153D9CAE05A02", hash_generated_method = "46987B9DBE720F336100D67A076CB7F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int addSpeech(String text, String filename) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(filename);
        {
            mUtterances.put(text, Uri.parse(filename));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //mUtterances.put(text, Uri.parse(filename));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.261 -0400", hash_original_method = "773577F8E212F06A89510B07A5731283", hash_generated_method = "A537C31B42611207B67B5977F23E1E21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int addEarcon(String earcon, String packagename, int resourceId) {
        dsTaint.addTaint(resourceId);
        dsTaint.addTaint(earcon);
        dsTaint.addTaint(packagename);
        {
            mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized(mStartLock) {
            //mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.261 -0400", hash_original_method = "409D0B7C115347E1FFF71FD2BD1F314E", hash_generated_method = "1B4C3C1D42C79EE81AE1F919D72B8E11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int addEarcon(String earcon, String filename) {
        dsTaint.addTaint(earcon);
        dsTaint.addTaint(filename);
        {
            mEarcons.put(earcon, Uri.parse(filename));
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized(mStartLock) {
            //mEarcons.put(earcon, Uri.parse(filename));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.261 -0400", hash_original_method = "276BC175828DCE484EB0703A6A0D8E9B", hash_generated_method = "D9F3CFA90172C4794014CC5B081ED6BA")
    @DSModeled(DSC.SPEC)
    private Uri makeResourceUri(String packageName, int resourceId) {
        dsTaint.addTaint(resourceId);
        dsTaint.addTaint(packageName);
        Uri var4EE4C7AB3E0199A9D4381C59C16559EE_1304198025 = (new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .encodedAuthority(packageName)
                .appendEncodedPath(String.valueOf(resourceId))
                .build());
        return (Uri)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Uri.Builder()
                //.scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                //.encodedAuthority(packageName)
                //.appendEncodedPath(String.valueOf(resourceId))
                //.build();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.262 -0400", hash_original_method = "BE0E5C2CBBCD37525836C6DA289D2EEC", hash_generated_method = "84F6EE2D3D7FE0F3BD6601A9AF320549")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int speak(final String text, final int queueMode, final HashMap<String, String> params) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(queueMode);
        dsTaint.addTaint(params.dsTaint);
        int var6FDBFBDE6B2A36D62147BA56A5620E8D_1370632787 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.262 -0400", hash_original_method = "7D06D49EA86F29A3C163217832E59726", hash_generated_method = "8B5991A58E250D31C4EAA7EBF8877119")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                Uri utteranceUri;
                utteranceUri = mUtterances.get(text);
                {
                    Integer var3C7C5E408AE81F5B4CF27DEB6E4B17A8_166993184 = (service.playAudio(getPackageName(), utteranceUri, queueMode,
                            getParams(params)));
                } //End block
                {
                    Integer var02D5E69C765671E42F40A630237C31F6_303254530 = (service.speak(getPackageName(), text, queueMode, getParams(params)));
                } //End block
                return (Integer)dsTaint.getTaint();
                // ---------- Original Method ----------
                //Uri utteranceUri = mUtterances.get(text);
                //if (utteranceUri != null) {
                    //return service.playAudio(getPackageName(), utteranceUri, queueMode,
                            //getParams(params));
                //} else {
                    //return service.speak(getPackageName(), text, queueMode, getParams(params));
                //}
            }
}, ERROR, "speak"));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //Uri utteranceUri = mUtterances.get(text);
                //if (utteranceUri != null) {
                    //return service.playAudio(getPackageName(), utteranceUri, queueMode,
                            //getParams(params));
                //} else {
                    //return service.speak(getPackageName(), text, queueMode, getParams(params));
                //}
            //}
        //}, ERROR, "speak");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.263 -0400", hash_original_method = "F18AB3CD06A1E20DE6BD7099833B6FEC", hash_generated_method = "580C5C0C71C382F175D7B4618EB59F66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int playEarcon(final String earcon, final int queueMode,
            final HashMap<String, String> params) {
        dsTaint.addTaint(earcon);
        dsTaint.addTaint(queueMode);
        dsTaint.addTaint(params.dsTaint);
        int var8CBAB49306E75F3D2958016A36834B72_1849272188 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.263 -0400", hash_original_method = "6A26B14D42F3FBBE45C132D11F693742", hash_generated_method = "41F2ECCEDDA548BA39CF48B5310FA72C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                Uri earconUri;
                earconUri = mEarcons.get(earcon);
                Integer var2038B3BF81054BD7D3585CEA4EF16741_80085616 = (service.playAudio(getPackageName(), earconUri, queueMode,
                        getParams(params)));
                return (Integer)dsTaint.getTaint();
                // ---------- Original Method ----------
                //Uri earconUri = mEarcons.get(earcon);
                //if (earconUri == null) {
                    //return ERROR;
                //}
                //return service.playAudio(getPackageName(), earconUri, queueMode,
                        //getParams(params));
            }
}, ERROR, "playEarcon"));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //Uri earconUri = mEarcons.get(earcon);
                //if (earconUri == null) {
                    //return ERROR;
                //}
                //return service.playAudio(getPackageName(), earconUri, queueMode,
                        //getParams(params));
            //}
        //}, ERROR, "playEarcon");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.263 -0400", hash_original_method = "94C759FE8B677E32982F42F6A676D86E", hash_generated_method = "3EB49A47D2D9C9E0AB46E739B173E311")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int playSilence(final long durationInMs, final int queueMode,
            final HashMap<String, String> params) {
        dsTaint.addTaint(durationInMs);
        dsTaint.addTaint(queueMode);
        dsTaint.addTaint(params.dsTaint);
        int varC985076DC8BA45D3C2699BBAB0F09CA6_595441204 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.263 -0400", hash_original_method = "78C333BA11B47CA10C93733938393F3E", hash_generated_method = "4899EC8C07F8A862B88DEC6D61893DAE")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                Integer varFF464335773F5B4FCFA7FDB908068A3B_999235428 = (service.playSilence(getPackageName(), durationInMs, queueMode,
                        getParams(params)));
                return (Integer)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return service.playSilence(getPackageName(), durationInMs, queueMode,
                        //getParams(params));
            }
}, ERROR, "playSilence"));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.playSilence(getPackageName(), durationInMs, queueMode,
                        //getParams(params));
            //}
        //}, ERROR, "playSilence");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.268 -0400", hash_original_method = "8AF2E385B6F026EB817E9FE98AB99B1D", hash_generated_method = "1A0624B68A2BABA793560D61C6E889EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> getFeatures(final Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        Set<String> varB5EE32A58DE4BFA4BB7D7EF0828D145A_975832004 = (runAction(new Action<Set<String>>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.267 -0400", hash_original_method = "F0504A62951AE3DA8704A40623A9C42B", hash_generated_method = "133D31FD518BC91066EC1C068AC11204")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Set<String> run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                String[] features;
                features = service.getFeaturesForLanguage(
                        locale.getISO3Language(), locale.getISO3Country(), locale.getVariant());
                {
                    Set<String> featureSet;
                    featureSet = new HashSet<String>();
                    Collections.addAll(featureSet, features);
                } //End block
                return (Set<String>)dsTaint.getTaint();
                // ---------- Original Method ----------
                //String[] features = service.getFeaturesForLanguage(
                        //locale.getISO3Language(), locale.getISO3Country(), locale.getVariant());
                //if (features != null) {
                    //final Set<String> featureSet = new HashSet<String>();
                    //Collections.addAll(featureSet, features);
                    //return featureSet;
                //}
                //return null;
            }
}, null, "getFeatures"));
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return runAction(new Action<Set<String>>() {
            //@Override
            //public Set<String> run(ITextToSpeechService service) throws RemoteException {
                //String[] features = service.getFeaturesForLanguage(
                        //locale.getISO3Language(), locale.getISO3Country(), locale.getVariant());
                //if (features != null) {
                    //final Set<String> featureSet = new HashSet<String>();
                    //Collections.addAll(featureSet, features);
                    //return featureSet;
                //}
                //return null;
            //}
        //}, null, "getFeatures");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.269 -0400", hash_original_method = "DC605D9F82407CF596B06CFECEFBD8A5", hash_generated_method = "B4815E9B7271AA405664913D607191C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSpeaking() {
        boolean varB3685CEE0C2D31E8531C2F828CAE55D1_180906419 = (runAction(new Action<Boolean>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.268 -0400", hash_original_method = "CDD6871E0A3D820171A5453DF320B8D3", hash_generated_method = "677894898E5231C3551F3DCEAAD68B41")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Boolean run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                Boolean var8F689F8785512C7CF156E9A9FF74A927_1203162476 = (service.isSpeaking());
                return (Boolean)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return service.isSpeaking();
            }
}, false, "isSpeaking"));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return runAction(new Action<Boolean>() {
            //@Override
            //public Boolean run(ITextToSpeechService service) throws RemoteException {
                //return service.isSpeaking();
            //}
        //}, false, "isSpeaking");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.269 -0400", hash_original_method = "1B011279D3385FBEA81C0EEE9DDE31E7", hash_generated_method = "F49CC3FDB10C0F52D8EC8ABDD9E8C0A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int stop() {
        int var08F0CA820DCC97E91FE85B7C9F78142E_379507226 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.269 -0400", hash_original_method = "C3E115845E07ACC22BB6BDAD6EAAC990", hash_generated_method = "C0961D5622FE67D8BD5BD03EF91FE6BB")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                Integer var3DD90F900E2B0E699105D70AFC2F97FA_1804738726 = (service.stop(getPackageName()));
                return (Integer)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return service.stop(getPackageName());
            }
}, ERROR, "stop"));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.stop(getPackageName());
            //}
        //}, ERROR, "stop");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.269 -0400", hash_original_method = "6950E84EE314E7032010233B0706B078", hash_generated_method = "CB8D7DE38F1244D1C9C229AAE9EAFAFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int setSpeechRate(float speechRate) {
        dsTaint.addTaint(speechRate);
        {
            int intRate;
            intRate = (int)(speechRate * 100);
            {
                {
                    mParams.putInt(Engine.KEY_PARAM_RATE, intRate);
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (speechRate > 0.0f) {
            //int intRate = (int)(speechRate * 100);
            //if (intRate > 0) {
                //synchronized (mStartLock) {
                    //mParams.putInt(Engine.KEY_PARAM_RATE, intRate);
                //}
                //return SUCCESS;
            //}
        //}
        //return ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.270 -0400", hash_original_method = "7DADB23AB82E5180649E2697B1338160", hash_generated_method = "F5F15B3463E1C6329F7F537AD8637633")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int setPitch(float pitch) {
        dsTaint.addTaint(pitch);
        {
            int intPitch;
            intPitch = (int)(pitch * 100);
            {
                {
                    mParams.putInt(Engine.KEY_PARAM_PITCH, intPitch);
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (pitch > 0.0f) {
            //int intPitch = (int)(pitch * 100);
            //if (intPitch > 0) {
                //synchronized (mStartLock) {
                    //mParams.putInt(Engine.KEY_PARAM_PITCH, intPitch);
                //}
                //return SUCCESS;
            //}
        //}
        //return ERROR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.270 -0400", hash_original_method = "6F277B1B16E884F81974EA73065A64D8", hash_generated_method = "40334F1C91B3ED6FA2099C5E3217D33A")
    @DSModeled(DSC.SAFE)
    public String getCurrentEngine() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCurrentEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.271 -0400", hash_original_method = "4B10A46E0E63D1391FC966E12E9B561D", hash_generated_method = "96DC91C1D8E754D124E250440C0D1E1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int setLanguage(final Locale loc) {
        dsTaint.addTaint(loc.dsTaint);
        int var54FDD08201C853601B2E738ED52073B6_857754661 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.270 -0400", hash_original_method = "0CBE42B90B008DE7C85EE0BE4FA8A569", hash_generated_method = "D3A76EE38D06C8A688FB711EE81C0E34")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                String language;
                language = loc.getISO3Language();
                String country;
                country = loc.getISO3Country();
                String variant;
                variant = loc.getVariant();
                int result;
                result = service.loadLanguage(language, country, variant);
                {
                    {
                        variant = "";
                        {
                            country = "";
                        } //End block
                    } //End block
                    mParams.putString(Engine.KEY_PARAM_LANGUAGE, language);
                    mParams.putString(Engine.KEY_PARAM_COUNTRY, country);
                    mParams.putString(Engine.KEY_PARAM_VARIANT, variant);
                } //End block
                return (Integer)dsTaint.getTaint();
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
}, LANG_NOT_SUPPORTED, "setLanguage"));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.271 -0400", hash_original_method = "BC427E909E00C5BE5A5F111E336651C0", hash_generated_method = "CBF95EDB34AABC042B21A71DB7BAF19E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale getLanguage() {
        Locale varCEC60FDD8F756087D7524F36A5123961_1004521594 = (runAction(new Action<Locale>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.271 -0400", hash_original_method = "419A6331670010A27050C72F09FCFBF2", hash_generated_method = "786AC030C98F321FF31D47833E889F8D")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Locale run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                String[] locStrings;
                locStrings = service.getLanguage();
                {
                    Locale var24458E908F8488C6751B596F061ABE18_1499043906 = (new Locale(locStrings[0], locStrings[1], locStrings[2]));
                } //End block
                return (Locale)dsTaint.getTaint();
                // ---------- Original Method ----------
                //String[] locStrings = service.getLanguage();
                //if (locStrings != null && locStrings.length == 3) {
                    //return new Locale(locStrings[0], locStrings[1], locStrings[2]);
                //}
                //return null;
            }
}, null, "getLanguage"));
        return (Locale)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return runAction(new Action<Locale>() {
            //@Override
            //public Locale run(ITextToSpeechService service) throws RemoteException {
                //String[] locStrings = service.getLanguage();
                //if (locStrings != null && locStrings.length == 3) {
                    //return new Locale(locStrings[0], locStrings[1], locStrings[2]);
                //}
                //return null;
            //}
        //}, null, "getLanguage");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.272 -0400", hash_original_method = "4344244CB1F796DE537DEBF5170866A9", hash_generated_method = "96C36FED52838E2546E3F089EE6CA28E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int isLanguageAvailable(final Locale loc) {
        dsTaint.addTaint(loc.dsTaint);
        int var39575E648CD584238B4EC346270F0EA3_14638844 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.272 -0400", hash_original_method = "104F6D4E3824B9F3A36823FE96275A8A", hash_generated_method = "E14EB2111140F3436AAEF20E3A53F4AD")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                Integer varDABF0BE749025CA8151E42532D26D712_1416981932 = (service.isLanguageAvailable(loc.getISO3Language(),
                        loc.getISO3Country(), loc.getVariant()));
                return (Integer)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return service.isLanguageAvailable(loc.getISO3Language(),
                        //loc.getISO3Country(), loc.getVariant());
            }
}, LANG_NOT_SUPPORTED, "isLanguageAvailable"));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.isLanguageAvailable(loc.getISO3Language(),
                        //loc.getISO3Country(), loc.getVariant());
            //}
        //}, LANG_NOT_SUPPORTED, "isLanguageAvailable");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.273 -0400", hash_original_method = "59A7F0A106B55E8A59A4D44C2073C3C6", hash_generated_method = "57900E68105D5840C53A64873A58A097")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int synthesizeToFile(final String text, final HashMap<String, String> params,
            final String filename) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(filename);
        dsTaint.addTaint(params.dsTaint);
        int var47E1CC400E9205DE0D7DB2CE8430B3CD_38563250 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.273 -0400", hash_original_method = "126F93B055F255BA3903970B4BD95F1E", hash_generated_method = "D0905692B3FE011108F2E03EF0953388")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                dsTaint.addTaint(service.dsTaint);
                Integer var8FCFE5D891FCC80CEEA9E15B4874C921_817670715 = (service.synthesizeToFile(getPackageName(), text, filename,
                        getParams(params)));
                return (Integer)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return service.synthesizeToFile(getPackageName(), text, filename,
                        //getParams(params));
            }
}, ERROR, "synthesizeToFile"));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.synthesizeToFile(getPackageName(), text, filename,
                        //getParams(params));
            //}
        //}, ERROR, "synthesizeToFile");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.280 -0400", hash_original_method = "F4A729CBEB92036D830EC51C9E6B27A9", hash_generated_method = "9BF7DE45F3102B5981F696CA51FDD4E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Bundle getParams(HashMap<String, String> params) {
        dsTaint.addTaint(params.dsTaint);
        {
            boolean var03F97DC16CD5D3704D59B126AFD4BB5D_2141070243 = (params != null && !params.isEmpty());
            {
                Bundle bundle;
                bundle = new Bundle(mParams);
                copyIntParam(bundle, params, Engine.KEY_PARAM_STREAM);
                copyStringParam(bundle, params, Engine.KEY_PARAM_UTTERANCE_ID);
                copyFloatParam(bundle, params, Engine.KEY_PARAM_VOLUME);
                copyFloatParam(bundle, params, Engine.KEY_PARAM_PAN);
                copyStringParam(bundle, params, Engine.KEY_FEATURE_NETWORK_SYNTHESIS);
                copyStringParam(bundle, params, Engine.KEY_FEATURE_EMBEDDED_SYNTHESIS);
                {
                    boolean varDCACF1CEFE09ED31579385123C6A41F9_237107012 = (!TextUtils.isEmpty(mCurrentEngine));
                    {
                        {
                            Iterator<Map.Entry<String, String>> varE9C4AC5EB9F7220631D2D77DC566F3A2_625345054 = (params.entrySet()).iterator();
                            varE9C4AC5EB9F7220631D2D77DC566F3A2_625345054.hasNext();
                            Map.Entry<String, String> entry = varE9C4AC5EB9F7220631D2D77DC566F3A2_625345054.next();
                            {
                                String key;
                                key = entry.getKey();
                                {
                                    boolean var067B24247B41FD99A3F806EDF88D0891_1261608261 = (key != null && key.startsWith(mCurrentEngine));
                                    {
                                        bundle.putString(key, entry.getValue());
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.280 -0400", hash_original_method = "CA756292003AA5F2AACD5FD8062D880F", hash_generated_method = "4C87E933718BCD609562F4B3733ECF19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void copyStringParam(Bundle bundle, HashMap<String, String> params, String key) {
        dsTaint.addTaint(bundle.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key);
        String value;
        value = params.get(key);
        {
            bundle.putString(key, value);
        } //End block
        // ---------- Original Method ----------
        //String value = params.get(key);
        //if (value != null) {
            //bundle.putString(key, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.281 -0400", hash_original_method = "D148C993B4D17B611EC6A14A9B3B3D7B", hash_generated_method = "EEAFBB089954AEBFE2004531C490531A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void copyIntParam(Bundle bundle, HashMap<String, String> params, String key) {
        dsTaint.addTaint(bundle.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key);
        String valueString;
        valueString = params.get(key);
        {
            boolean var7538D513B192AB3E879BF618E72A8D7E_1646815430 = (!TextUtils.isEmpty(valueString));
            {
                try 
                {
                    int value;
                    value = Integer.parseInt(valueString);
                    bundle.putInt(key, value);
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String valueString = params.get(key);
        //if (!TextUtils.isEmpty(valueString)) {
            //try {
                //int value = Integer.parseInt(valueString);
                //bundle.putInt(key, value);
            //} catch (NumberFormatException ex) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.281 -0400", hash_original_method = "335CA474B2AA628361250A653672DD72", hash_generated_method = "1D000D874F9344A5213E1AD09CBF7698")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void copyFloatParam(Bundle bundle, HashMap<String, String> params, String key) {
        dsTaint.addTaint(bundle.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key);
        String valueString;
        valueString = params.get(key);
        {
            boolean var7538D513B192AB3E879BF618E72A8D7E_149581435 = (!TextUtils.isEmpty(valueString));
            {
                try 
                {
                    float value;
                    value = Float.parseFloat(valueString);
                    bundle.putFloat(key, value);
                } //End block
                catch (NumberFormatException ex)
                { }
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String valueString = params.get(key);
        //if (!TextUtils.isEmpty(valueString)) {
            //try {
                //float value = Float.parseFloat(valueString);
                //bundle.putFloat(key, value);
            //} catch (NumberFormatException ex) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.281 -0400", hash_original_method = "24D73865C05CC11CAA8C791D8BA56024", hash_generated_method = "B6AA097F627D663C2B06A53C660C3A13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int setOnUtteranceCompletedListener(final OnUtteranceCompletedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        //return TextToSpeech.SUCCESS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.281 -0400", hash_original_method = "98074E19965AB76BE23153F0217E2857", hash_generated_method = "B525E7ABE5C994A59F2A48810DDEB940")
    @DSModeled(DSC.SAFE)
    public int setOnUtteranceProgressListener(UtteranceProgressListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //mUtteranceProgressListener = listener;
        //return TextToSpeech.SUCCESS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.282 -0400", hash_original_method = "06FE1E6C6795B03B25AD43DFED268D92", hash_generated_method = "DF36A60C4FE4E90F959D6F84C1F2D87A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int setEngineByPackageName(String enginePackageName) {
        dsTaint.addTaint(enginePackageName);
        int var663EB57F9D9E552BC588A53FE17E210D_357330610 = (initTts());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //mRequestedEngine = enginePackageName;
        //return initTts();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.282 -0400", hash_original_method = "AAA28EF74B57D47AEDCF93243FD04D81", hash_generated_method = "0CD31F549DE544B5705F37029AB6519E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDefaultEngine() {
        String varE66A85DAAE300464DC8F4B1130A4F2D0_781984617 = (mEnginesHelper.getDefaultEngine());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mEnginesHelper.getDefaultEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.282 -0400", hash_original_method = "FDBC18F088428D1AA4FA407CF8A38EB5", hash_generated_method = "3E64FAD07E4B996BCBD7C03E4B23841E")
    @DSModeled(DSC.SAFE)
    public boolean areDefaultsEnforced() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.282 -0400", hash_original_method = "C282EF17EB1B4600865CB51DA0934709", hash_generated_method = "193AD5F3E02297B93243E4A91C157F65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<EngineInfo> getEngines() {
        List<EngineInfo> varD60635E1E46F4709CB05167D7A017C33_1541678804 = (mEnginesHelper.getEngines());
        return (List<EngineInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mEnginesHelper.getEngines();
    }

    
    public class Engine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.282 -0400", hash_original_method = "ED2726F348F560FAE98A0FB4178F1B0E", hash_generated_method = "ED2726F348F560FAE98A0FB4178F1B0E")
                public Engine ()
        {
        }


        public static final int DEFAULT_RATE = 100;
        public static final int DEFAULT_PITCH = 100;
        public static final float DEFAULT_VOLUME = 1.0f;
        public static final float DEFAULT_PAN = 0.0f;
        public static final int USE_DEFAULTS = 0;
        @Deprecated public static final String DEFAULT_ENGINE = "com.svox.pico";
        public static final int DEFAULT_STREAM = AudioManager.STREAM_MUSIC;
        public static final int CHECK_VOICE_DATA_PASS = 1;
        public static final int CHECK_VOICE_DATA_FAIL = 0;
        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
        @SdkConstant(SdkConstantType.SERVICE_ACTION) public static final String INTENT_ACTION_TTS_SERVICE =
                "android.intent.action.TTS_SERVICE";
        public static final String SERVICE_META_DATA = "android.speech.tts";
        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_INSTALL_TTS_DATA =
                "android.speech.tts.engine.INSTALL_TTS_DATA";
        @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_TTS_DATA_INSTALLED =
                "android.speech.tts.engine.TTS_DATA_INSTALLED";
        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_CHECK_TTS_DATA =
                "android.speech.tts.engine.CHECK_TTS_DATA";
        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION) public static final String ACTION_GET_SAMPLE_TEXT =
                "android.speech.tts.engine.GET_SAMPLE_TEXT";
        public static final String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";
        public static final String EXTRA_VOICE_DATA_FILES = "dataFiles";
        public static final String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";
        public static final String EXTRA_AVAILABLE_VOICES = "availableVoices";
        public static final String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";
        public static final String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";
        public static final String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";
        public static final String KEY_PARAM_RATE = "rate";
        public static final String KEY_PARAM_LANGUAGE = "language";
        public static final String KEY_PARAM_COUNTRY = "country";
        public static final String KEY_PARAM_VARIANT = "variant";
        public static final String KEY_PARAM_ENGINE = "engine";
        public static final String KEY_PARAM_PITCH = "pitch";
        public static final String KEY_PARAM_STREAM = "streamType";
        public static final String KEY_PARAM_UTTERANCE_ID = "utteranceId";
        public static final String KEY_PARAM_VOLUME = "volume";
        public static final String KEY_PARAM_PAN = "pan";
        public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
        public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    }


    
    private class Connection implements ServiceConnection {
        private ITextToSpeechService mService;
        private final ITextToSpeechCallback.Stub mCallback = new ITextToSpeechCallback.Stub() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.283 -0400", hash_original_method = "5A69319C8BD2B805ED99ED76716CFEEE", hash_generated_method = "5693F437C24D367455D2543A916171BD")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onDone(String utteranceId) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(utteranceId);
                UtteranceProgressListener listener;
                listener = mUtteranceProgressListener;
                {
                    listener.onDone(utteranceId);
                } //End block
                // ---------- Original Method ----------
                //UtteranceProgressListener listener = mUtteranceProgressListener;
                //if (listener != null) {
                    //listener.onDone(utteranceId);
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.283 -0400", hash_original_method = "71BFFA04ED8551E163779942DCEAA326", hash_generated_method = "B89E463768AD666BBCB1A163C77B5E3A")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onError(String utteranceId) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(utteranceId);
                UtteranceProgressListener listener;
                listener = mUtteranceProgressListener;
                {
                    listener.onError(utteranceId);
                } //End block
                // ---------- Original Method ----------
                //UtteranceProgressListener listener = mUtteranceProgressListener;
                //if (listener != null) {
                    //listener.onError(utteranceId);
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.283 -0400", hash_original_method = "AC6831F715B5A1560C1EB20081DD1B2E", hash_generated_method = "AF1FDE923057668357E40B3417DE4345")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void onStart(String utteranceId) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(utteranceId);
                UtteranceProgressListener listener;
                listener = mUtteranceProgressListener;
                {
                    listener.onStart(utteranceId);
                } //End block
                // ---------- Original Method ----------
                //UtteranceProgressListener listener = mUtteranceProgressListener;
                //if (listener != null) {
                    //listener.onStart(utteranceId);
                //}
            }

            
}; //Transformed anonymous class
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.284 -0400", hash_original_method = "F7537526BDBAE098BDB45EAA1AFC2E53", hash_generated_method = "F7537526BDBAE098BDB45EAA1AFC2E53")
                public Connection ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.284 -0400", hash_original_method = "E38F495B4498EDF08C66FB9F592C4572", hash_generated_method = "BE88C045355FE30D1AE9FF2D4CCAB343")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceConnected(ComponentName name, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name.dsTaint);
            dsTaint.addTaint(service.dsTaint);
            {
                {
                    mServiceConnection.disconnect();
                } //End block
                mServiceConnection = this;
                mService = ITextToSpeechService.Stub.asInterface(service);
                try 
                {
                    mService.setCallback(getPackageName(), mCallback);
                    dispatchOnInit(SUCCESS);
                } //End block
                catch (RemoteException re)
                {
                    dispatchOnInit(ERROR);
                } //End block
            } //End block
            // ---------- Original Method ----------
            //Log.i(TAG, "Connected to " + name);
            //synchronized(mStartLock) {
                //if (mServiceConnection != null) {
                    //mServiceConnection.disconnect();
                //}
                //mServiceConnection = this;
                //mService = ITextToSpeechService.Stub.asInterface(service);
                //try {
                    //mService.setCallback(getPackageName(), mCallback);
                    //dispatchOnInit(SUCCESS);
                //} catch (RemoteException re) {
                    //Log.e(TAG, "Error connecting to service, setCallback() failed");
                    //dispatchOnInit(ERROR);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.285 -0400", hash_original_method = "9CBB724FFDF56C58A2F363CBB7ADEB66", hash_generated_method = "5E5AE5CD49A93B83E9357536F55C01EB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name.dsTaint);
            {
                mService = null;
                {
                    boolean varCFBB343190D0053DBC4029F6CA0B9372_922821037 = (mServiceConnection == this);
                    {
                        mServiceConnection = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //synchronized(mStartLock) {
                //mService = null;
                //if (mServiceConnection == this) {
                    //mServiceConnection = null;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.286 -0400", hash_original_method = "670DB56217535BA78AC55188B9013676", hash_generated_method = "22BDFB36185642ED4E82BED8A6D53D5B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void disconnect() {
            mContext.unbindService(this);
            // ---------- Original Method ----------
            //mContext.unbindService(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.286 -0400", hash_original_method = "34464E55B5499CA206CC99D3045C1292", hash_generated_method = "00FF48F96BD35AB91F0C0C524102274E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
            dsTaint.addTaint(reconnect);
            dsTaint.addTaint(action.dsTaint);
            dsTaint.addTaint(method);
            dsTaint.addTaint(errorResult.dsTaint);
            try 
            {
                {
                    R var3E303FE7B7031E73BD8B1C98792BC65A_981708420 = (action.run(mService));
                } //End block
            } //End block
            catch (RemoteException ex)
            {
                {
                    disconnect();
                    initTts();
                } //End block
            } //End block
            return (R)dsTaint.getTaint();
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
        public String name;
        public String label;
        public int icon;
        public boolean system;
        public int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.287 -0400", hash_original_method = "058C7BDB65D29F4D986A1EA2E14B6BAF", hash_generated_method = "058C7BDB65D29F4D986A1EA2E14B6BAF")
                public EngineInfo ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.287 -0400", hash_original_method = "2BF343FE966C95427B565E993C403E36", hash_generated_method = "FE9B5D51F5D030108A92733DBB5C7F9A")
        @DSModeled(DSC.SAFE)
        @Override
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EngineInfo{name=" + name + "}";
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
    
    private static final String TAG = "TextToSpeech";
    public static final int SUCCESS = 0;
    public static final int ERROR = -1;
    public static final int QUEUE_FLUSH = 0;
    public static final int QUEUE_ADD = 1;
    static final int QUEUE_DESTROY = 2;
    public static final int LANG_COUNTRY_VAR_AVAILABLE = 2;
    public static final int LANG_COUNTRY_AVAILABLE = 1;
    public static final int LANG_AVAILABLE = 0;
    public static final int LANG_MISSING_DATA = -1;
    public static final int LANG_NOT_SUPPORTED = -2;
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION) public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED =
            "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
}

