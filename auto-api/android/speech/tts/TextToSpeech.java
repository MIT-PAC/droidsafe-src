package android.speech.tts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED =
            "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
    private final Context mContext;
    private Connection mServiceConnection;
    private OnInitListener mInitListener;
    private volatile UtteranceProgressListener mUtteranceProgressListener;
    private final Object mStartLock = new Object();
    private String mRequestedEngine;
    private final Map<String, Uri> mEarcons;
    private final Map<String, Uri> mUtterances;
    private final Bundle mParams = new Bundle();
    private final TtsEngines mEnginesHelper;
    private final String mPackageName;
    private volatile String mCurrentEngine = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.413 -0400", hash_original_method = "E5C095C9A34533EB222D42D1A6D92941", hash_generated_method = "0C4C34EAA8A7CBF6069EB1682EEB8C14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextToSpeech(Context context, OnInitListener listener) {
        this(context, listener, null);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.414 -0400", hash_original_method = "894D965EFAB67E7E0E3D1E11B990F0FA", hash_generated_method = "AC5FB681B2A8A432A720D4BBB74206BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextToSpeech(Context context, OnInitListener listener, String engine) {
        this(context, listener, engine, null);
        dsTaint.addTaint(engine);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.414 -0400", hash_original_method = "0584A597F5F20737FDED0391417BF29B", hash_generated_method = "211689A408AF6470825C20E5694C1FE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TextToSpeech(Context context, OnInitListener listener, String engine,
            String packageName) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(engine);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(listener.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.414 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "17FEF947E45B76BACBACE7F6C3F8D197")
    @DSModeled(DSC.SAFE)
    private String getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.414 -0400", hash_original_method = "94C951553FBC2F5928AD7C3B02D8E2C9", hash_generated_method = "099AC97F4E0E07C1FF3A117CC879F07C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <R> R runActionNoReconnect(Action<R> action, R errorResult, String method) {
        dsTaint.addTaint(action.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(errorResult.dsTaint);
        R var9BEF42F8A9C81E69D4349C4B56482084_1864050683 = (runAction(action, errorResult, method, false));
        return (R)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return runAction(action, errorResult, method, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.414 -0400", hash_original_method = "29E7B310AE240E4C21F0167C8B8476FB", hash_generated_method = "D38E71207DFCAD945F6A8582CBD2018F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <R> R runAction(Action<R> action, R errorResult, String method) {
        dsTaint.addTaint(action.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(errorResult.dsTaint);
        R varA322373C3CB1722F7DDB6E468C5D6732_2087137831 = (runAction(action, errorResult, method, true));
        return (R)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return runAction(action, errorResult, method, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.414 -0400", hash_original_method = "6EC1A4E0A67965882D9F244E76909BAE", hash_generated_method = "993C67EFF8BD44E2E80AC4793FDBC817")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
        dsTaint.addTaint(reconnect);
        dsTaint.addTaint(action.dsTaint);
        dsTaint.addTaint(method);
        dsTaint.addTaint(errorResult.dsTaint);
        {
            R var7C0DC93A0C217AAFD716074E55158CDC_251393104 = (mServiceConnection.runAction(action, errorResult, method, reconnect));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.415 -0400", hash_original_method = "001A57975E2E50499F283478CA48737A", hash_generated_method = "9A9DB6D9DDDAC0471F59DB6F3C03BCEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int initTts() {
        {
            boolean varC76336549734AD44BDCB678BF01D59F2_1823158767 = (mRequestedEngine != null && mEnginesHelper.isEngineInstalled(mRequestedEngine));
            {
                {
                    boolean var8911BEC7CCD0FB9FC7E4675F4D27106A_380738317 = (connectToEngine(mRequestedEngine));
                    {
                        mCurrentEngine = mRequestedEngine;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        final String defaultEngine;
        defaultEngine = getDefaultEngine();
        {
            boolean varABC6D22B8FBEAE604936A23D49D6DDD0_2017833295 = (defaultEngine != null && !defaultEngine.equals(mRequestedEngine));
            {
                {
                    boolean var7836D76553A5F05531279189C3A7B50A_1789525303 = (connectToEngine(defaultEngine));
                    {
                        mCurrentEngine = defaultEngine;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        final String highestRanked;
        highestRanked = mEnginesHelper.getHighestRankedEngineName();
        {
            boolean var1A9867EA58712819C70FBE667FD48C74_1982906693 = (highestRanked != null && !highestRanked.equals(mRequestedEngine) &&
                !highestRanked.equals(defaultEngine));
            {
                {
                    boolean varB08B03620CB751C6F0BCA99823142EEF_74310161 = (connectToEngine(highestRanked));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.415 -0400", hash_original_method = "5177E4BA973A00FB9C33DC0A5DBEACDB", hash_generated_method = "DD3FCC17F176F3788D1585C260C3C031")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.415 -0400", hash_original_method = "16B0CCB3D7329F5127962CE558D4D17C", hash_generated_method = "7CC59342C810C5D21679E87C058B2D39")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.415 -0400", hash_original_method = "EAB786CB351424B1FA3879678813021A", hash_generated_method = "AC54D1B8582565D7BFEC737F2B797757")
    @DSModeled(DSC.SAFE)
    public void shutdown() {
        runActionNoReconnect(new Action<Void>() {
            @Override
            public Void run(ITextToSpeechService service) throws RemoteException {
                service.setCallback(getPackageName(), null);
                service.stop(getPackageName());
                mServiceConnection.disconnect();
                mServiceConnection = null;
                mCurrentEngine = null;
                return null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.415 -0400", hash_original_method = "DD10D1EA0D37E9C3175CB1CE81EACE27", hash_generated_method = "BBA6D73ECEEEFD4B474F6D6EEEC43ACD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int addSpeech(String text, String packagename, int resourceId) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(resourceId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.415 -0400", hash_original_method = "DBC13E8086F9460080E153D9CAE05A02", hash_generated_method = "6F2DDE27070455F2DC4C5D8AB3BBAFD5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.415 -0400", hash_original_method = "773577F8E212F06A89510B07A5731283", hash_generated_method = "EAFC5EADAEFC8A1E4D624084F4A19433")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.416 -0400", hash_original_method = "409D0B7C115347E1FFF71FD2BD1F314E", hash_generated_method = "CB9C3040E121E1011181558475899BB4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.416 -0400", hash_original_method = "276BC175828DCE484EB0703A6A0D8E9B", hash_generated_method = "D0113712EFBCFF183DDFC96B383AA3B2")
    @DSModeled(DSC.SPEC)
    private Uri makeResourceUri(String packageName, int resourceId) {
        dsTaint.addTaint(resourceId);
        dsTaint.addTaint(packageName);
        Uri var4EE4C7AB3E0199A9D4381C59C16559EE_1073289107 = (new Uri.Builder()
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.416 -0400", hash_original_method = "BE0E5C2CBBCD37525836C6DA289D2EEC", hash_generated_method = "7BC28FE75992FE33FE25D7E918A50441")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int speak(final String text, final int queueMode, final HashMap<String, String> params) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(queueMode);
        dsTaint.addTaint(params.dsTaint);
        int varD7A6110FA8B9E791DE9C81C7D9887DE1_1931117830 = (runAction(new Action<Integer>() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.416 -0400", hash_original_method = "F18AB3CD06A1E20DE6BD7099833B6FEC", hash_generated_method = "7CDE26BBC11FA94D47720A7757582EEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int playEarcon(final String earcon, final int queueMode,
            final HashMap<String, String> params) {
        dsTaint.addTaint(earcon);
        dsTaint.addTaint(queueMode);
        dsTaint.addTaint(params.dsTaint);
        int var8AC7019DD852EB6CE5ECCA06A501D0EA_239335452 = (runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Uri earconUri = mEarcons.get(earcon);
                if (earconUri == null) {
                    return ERROR;
                }
                return service.playAudio(getPackageName(), earconUri, queueMode,
                        getParams(params));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.416 -0400", hash_original_method = "94C759FE8B677E32982F42F6A676D86E", hash_generated_method = "0D3EAF9C910A46A9D2EADAEDACFB45B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int playSilence(final long durationInMs, final int queueMode,
            final HashMap<String, String> params) {
        dsTaint.addTaint(durationInMs);
        dsTaint.addTaint(queueMode);
        dsTaint.addTaint(params.dsTaint);
        int var4C245C33353F114BC3C4D23DBA0ABA28_536805829 = (runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                return service.playSilence(getPackageName(), durationInMs, queueMode,
                        getParams(params));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.416 -0400", hash_original_method = "8AF2E385B6F026EB817E9FE98AB99B1D", hash_generated_method = "8FB6D5B1D2A67903837919BCB850C6B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> getFeatures(final Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        Set<String> varC01E530995147A5CCE09F46904E9A5A7_286289585 = (runAction(new Action<Set<String>>() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.416 -0400", hash_original_method = "DC605D9F82407CF596B06CFECEFBD8A5", hash_generated_method = "734A7AAE24AEEA9C6C03A6A93FD9BC22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSpeaking() {
        boolean var54D4A66D2DEF47B80502EDF0A45F5A32_1994942363 = (runAction(new Action<Boolean>() {
            @Override
            public Boolean run(ITextToSpeechService service) throws RemoteException {
                return service.isSpeaking();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.416 -0400", hash_original_method = "1B011279D3385FBEA81C0EEE9DDE31E7", hash_generated_method = "7AC27D43935FC3759FC15B758FA1B648")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int stop() {
        int var194032E6A639915D9B3A6D48CB961DE9_86976849 = (runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                return service.stop(getPackageName());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.417 -0400", hash_original_method = "6950E84EE314E7032010233B0706B078", hash_generated_method = "A310C48650969E2C69B916689736A311")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.417 -0400", hash_original_method = "7DADB23AB82E5180649E2697B1338160", hash_generated_method = "0983A8AC589E0AA2B8D4B16E2773E719")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.417 -0400", hash_original_method = "6F277B1B16E884F81974EA73065A64D8", hash_generated_method = "277C8FAA56511AE7D95176A11103DD6B")
    @DSModeled(DSC.SAFE)
    public String getCurrentEngine() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mCurrentEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.417 -0400", hash_original_method = "4B10A46E0E63D1391FC966E12E9B561D", hash_generated_method = "CE6D3537E864C206D4F28682937529FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int setLanguage(final Locale loc) {
        dsTaint.addTaint(loc.dsTaint);
        int var3B27E7FAE159DE82ADE62D88D6E803B8_852822043 = (runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                if (loc == null) {
                    return LANG_NOT_SUPPORTED;
                }
                String language = loc.getISO3Language();
                String country = loc.getISO3Country();
                String variant = loc.getVariant();
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
        }, LANG_NOT_SUPPORTED, "setLanguage"));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.417 -0400", hash_original_method = "BC427E909E00C5BE5A5F111E336651C0", hash_generated_method = "2B7AC4B3A6B961BF64E3F297D3468C4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Locale getLanguage() {
        Locale varBF606596C8B1DDE60A6D35FBA99F4F02_25871615 = (runAction(new Action<Locale>() {
            @Override
            public Locale run(ITextToSpeechService service) throws RemoteException {
                String[] locStrings = service.getLanguage();
                if (locStrings != null && locStrings.length == 3) {
                    return new Locale(locStrings[0], locStrings[1], locStrings[2]);
                }
                return null;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.417 -0400", hash_original_method = "4344244CB1F796DE537DEBF5170866A9", hash_generated_method = "332966912D3C10BB3B8A4C6A9241AD8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int isLanguageAvailable(final Locale loc) {
        dsTaint.addTaint(loc.dsTaint);
        int varB1F69BEA1490328842223210D399CFEE_897119006 = (runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                return service.isLanguageAvailable(loc.getISO3Language(),
                        loc.getISO3Country(), loc.getVariant());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.417 -0400", hash_original_method = "59A7F0A106B55E8A59A4D44C2073C3C6", hash_generated_method = "7ABB5ECE35B636D39E419D87DE3DFF48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int synthesizeToFile(final String text, final HashMap<String, String> params,
            final String filename) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(filename);
        dsTaint.addTaint(params.dsTaint);
        int varFF8AA8A4CBD72B48C6615C17069505D6_1118576496 = (runAction(new Action<Integer>() {
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                return service.synthesizeToFile(getPackageName(), text, filename,
                        getParams(params));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.418 -0400", hash_original_method = "F4A729CBEB92036D830EC51C9E6B27A9", hash_generated_method = "8F7A7EFEF60A658439D2FDEC97885AB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Bundle getParams(HashMap<String, String> params) {
        dsTaint.addTaint(params.dsTaint);
        {
            boolean var03F97DC16CD5D3704D59B126AFD4BB5D_1507700090 = (params != null && !params.isEmpty());
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
                    boolean varDCACF1CEFE09ED31579385123C6A41F9_1693468223 = (!TextUtils.isEmpty(mCurrentEngine));
                    {
                        {
                            Iterator<Map.Entry<String, String>> seatecAstronomy42 = params.entrySet().iterator();
                            seatecAstronomy42.hasNext();
                            Map.Entry<String, String> entry = seatecAstronomy42.next();
                            {
                                final String key;
                                key = entry.getKey();
                                {
                                    boolean var067B24247B41FD99A3F806EDF88D0891_1578496632 = (key != null && key.startsWith(mCurrentEngine));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.418 -0400", hash_original_method = "CA756292003AA5F2AACD5FD8062D880F", hash_generated_method = "C3BF386A8D0F153CD2D855064A48C2F0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.418 -0400", hash_original_method = "D148C993B4D17B611EC6A14A9B3B3D7B", hash_generated_method = "9036EB3184AE6DF5556DDB5C05D3C17F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void copyIntParam(Bundle bundle, HashMap<String, String> params, String key) {
        dsTaint.addTaint(bundle.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key);
        String valueString;
        valueString = params.get(key);
        {
            boolean var7538D513B192AB3E879BF618E72A8D7E_1226487672 = (!TextUtils.isEmpty(valueString));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.418 -0400", hash_original_method = "335CA474B2AA628361250A653672DD72", hash_generated_method = "FB89D0D2D691AA771ECB5DD26FA06F48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void copyFloatParam(Bundle bundle, HashMap<String, String> params, String key) {
        dsTaint.addTaint(bundle.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key);
        String valueString;
        valueString = params.get(key);
        {
            boolean var7538D513B192AB3E879BF618E72A8D7E_1361293242 = (!TextUtils.isEmpty(valueString));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.418 -0400", hash_original_method = "24D73865C05CC11CAA8C791D8BA56024", hash_generated_method = "E5484E8D47B38006A797C5AD46CA3425")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.418 -0400", hash_original_method = "98074E19965AB76BE23153F0217E2857", hash_generated_method = "E7DF0DE0D0F50945AED755711E3F6120")
    @DSModeled(DSC.SAFE)
    public int setOnUtteranceProgressListener(UtteranceProgressListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //mUtteranceProgressListener = listener;
        //return TextToSpeech.SUCCESS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.418 -0400", hash_original_method = "06FE1E6C6795B03B25AD43DFED268D92", hash_generated_method = "E69D96C8DC1EB21245C825714C7228A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public int setEngineByPackageName(String enginePackageName) {
        dsTaint.addTaint(enginePackageName);
        int var663EB57F9D9E552BC588A53FE17E210D_1919756686 = (initTts());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //mRequestedEngine = enginePackageName;
        //return initTts();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.418 -0400", hash_original_method = "AAA28EF74B57D47AEDCF93243FD04D81", hash_generated_method = "7BE1D366E50309659A70DCC4130EA55E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDefaultEngine() {
        String varE66A85DAAE300464DC8F4B1130A4F2D0_256233648 = (mEnginesHelper.getDefaultEngine());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mEnginesHelper.getDefaultEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.419 -0400", hash_original_method = "FDBC18F088428D1AA4FA407CF8A38EB5", hash_generated_method = "0E9FEA49D8D5A79982E56C0CF7DAB636")
    @DSModeled(DSC.SAFE)
    public boolean areDefaultsEnforced() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.419 -0400", hash_original_method = "C282EF17EB1B4600865CB51DA0934709", hash_generated_method = "8EE85EB56715B75FEBFC46BEAB1A0A37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<EngineInfo> getEngines() {
        List<EngineInfo> varD60635E1E46F4709CB05167D7A017C33_1962532599 = (mEnginesHelper.getEngines());
        return (List<EngineInfo>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mEnginesHelper.getEngines();
    }

    
    public class Engine {
        public static final int DEFAULT_RATE = 100;
        public static final int DEFAULT_PITCH = 100;
        public static final float DEFAULT_VOLUME = 1.0f;
        public static final float DEFAULT_PAN = 0.0f;
        public static final int USE_DEFAULTS = 0;
        @Deprecated
        public static final String DEFAULT_ENGINE = "com.svox.pico";
        public static final int DEFAULT_STREAM = AudioManager.STREAM_MUSIC;
        public static final int CHECK_VOICE_DATA_PASS = 1;
        public static final int CHECK_VOICE_DATA_FAIL = 0;
        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
        @SdkConstant(SdkConstantType.SERVICE_ACTION)
        public static final String INTENT_ACTION_TTS_SERVICE =
                "android.intent.action.TTS_SERVICE";
        public static final String SERVICE_META_DATA = "android.speech.tts";
        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_INSTALL_TTS_DATA =
                "android.speech.tts.engine.INSTALL_TTS_DATA";
        @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
        public static final String ACTION_TTS_DATA_INSTALLED =
                "android.speech.tts.engine.TTS_DATA_INSTALLED";
        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_CHECK_TTS_DATA =
                "android.speech.tts.engine.CHECK_TTS_DATA";
        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_GET_SAMPLE_TEXT =
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.419 -0400", hash_original_method = "5A69319C8BD2B805ED99ED76716CFEEE", hash_generated_method = "A7356E7477E3778371B46C0811D0A1C1")
            @DSModeled(DSC.SAFE)
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.419 -0400", hash_original_method = "71BFFA04ED8551E163779942DCEAA326", hash_generated_method = "25E52AE4B41B8194D091D25FDD31A273")
            @DSModeled(DSC.SAFE)
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.419 -0400", hash_original_method = "AC6831F715B5A1560C1EB20081DD1B2E", hash_generated_method = "F066D74EF0E33F252FBDD7CEB2F1FD4F")
            @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.419 -0400", hash_original_method = "E38F495B4498EDF08C66FB9F592C4572", hash_generated_method = "741A2A5359305EE0F588F3013A52F5AF")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.419 -0400", hash_original_method = "9CBB724FFDF56C58A2F363CBB7ADEB66", hash_generated_method = "24EDC1B4273B95EEB1A6A639794B0E80")
        @DSModeled(DSC.SAFE)
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name.dsTaint);
            {
                mService = null;
                {
                    mServiceConnection = null;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized(mStartLock) {
                //mService = null;
                //if (mServiceConnection == this) {
                    //mServiceConnection = null;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.420 -0400", hash_original_method = "670DB56217535BA78AC55188B9013676", hash_generated_method = "7B983250DDD166D8C32326109FB6B9BC")
        @DSModeled(DSC.SAFE)
        public void disconnect() {
            mContext.unbindService(this);
            // ---------- Original Method ----------
            //mContext.unbindService(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.420 -0400", hash_original_method = "34464E55B5499CA206CC99D3045C1292", hash_generated_method = "0041EF7DF9A9203565C58BDCA16EBAC8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
            dsTaint.addTaint(reconnect);
            dsTaint.addTaint(action.dsTaint);
            dsTaint.addTaint(method);
            dsTaint.addTaint(errorResult.dsTaint);
            try 
            {
                {
                    R var3E303FE7B7031E73BD8B1C98792BC65A_1329047681 = (action.run(mService));
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:03.420 -0400", hash_original_method = "2BF343FE966C95427B565E993C403E36", hash_generated_method = "57D719C1B9CAD1511852B10A3B44B265")
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
    
}


