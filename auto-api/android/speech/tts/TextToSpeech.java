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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.063 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.064 -0400", hash_original_field = "94CA83B0A5EF3662095068A2D93D4E51", hash_generated_field = "46824CCAF8D8A297954B79F68288C27C")

    private Connection mServiceConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.076 -0400", hash_original_field = "BD66CA08574E567F4A2FF02EAF3A3C43", hash_generated_field = "9260ADD518F0FEF38A450F7DB53206FF")

    private OnInitListener mInitListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.076 -0400", hash_original_field = "FCC9BC767DCFBBDC0E992E8F8F631777", hash_generated_field = "328E3D7B680D2F02E50F03A1B91A5C91")

    private volatile UtteranceProgressListener mUtteranceProgressListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.076 -0400", hash_original_field = "A566AAD21AECEFD87B9A641763F0E8ED", hash_generated_field = "4A192614697485D7DF6A454D01177650")

    private Object mStartLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.076 -0400", hash_original_field = "79A963EB2FE6CF7ED985A37C9C2DAFC8", hash_generated_field = "87C8AA46082F357B5A90BEFDCD55A9CA")

    private String mRequestedEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.076 -0400", hash_original_field = "4FBF9E2CF0458E920CECA1122F7CE66F", hash_generated_field = "F6B4C1579EC35D212C4AF2EE4A947247")

    private Map<String, Uri> mEarcons;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.076 -0400", hash_original_field = "DADCFF0BCD3190EF5EA5DAA385F05AFC", hash_generated_field = "AF9F14E0A7A7BBE0D15082F4D775A15F")

    private Map<String, Uri> mUtterances;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.076 -0400", hash_original_field = "2E7257A953F47313410ACCB399EF186C", hash_generated_field = "9E4D0E55335EFF51CCB0FD2F602C54D1")

    private Bundle mParams = new Bundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.076 -0400", hash_original_field = "3D23233AD3766EA5A08A04C38A75975D", hash_generated_field = "C4FA3CBED7ED304B229BB483017A66E9")

    private TtsEngines mEnginesHelper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.076 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.076 -0400", hash_original_field = "D10648D448DDFF74BD81B300412AA0DA", hash_generated_field = "8E5DC033BD559466A27E8B7E16939D55")

    private volatile String mCurrentEngine = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.082 -0400", hash_original_method = "E5C095C9A34533EB222D42D1A6D92941", hash_generated_method = "5EBF6E91AC53E9A8A9B0A253EEC90A14")
    public  TextToSpeech(Context context, OnInitListener listener) {
        this(context, listener, null);
        addTaint(context.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.085 -0400", hash_original_method = "894D965EFAB67E7E0E3D1E11B990F0FA", hash_generated_method = "9DB3A3DA3B73688B98CF2FBCD7304F9A")
    public  TextToSpeech(Context context, OnInitListener listener, String engine) {
        this(context, listener, engine, null);
        addTaint(context.getTaint());
        addTaint(listener.getTaint());
        addTaint(engine.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.086 -0400", hash_original_method = "0584A597F5F20737FDED0391417BF29B", hash_generated_method = "B4006DE63FF57B393B290520D5ED86F0")
    public  TextToSpeech(Context context, OnInitListener listener, String engine,
            String packageName) {
        mContext = context;
        mInitListener = listener;
        mRequestedEngine = engine;
        mEarcons = new HashMap<String, Uri>();
        mUtterances = new HashMap<String, Uri>();
        mUtteranceProgressListener = null;
        mEnginesHelper = new TtsEngines(mContext);
        {
            mPackageName = packageName;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.087 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "F3069459966FB519CCAC47D55D095D77")
    private String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_570541110 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_570541110 = mPackageName;
        varB4EAC82CA7396A68D541C85D26508E83_570541110.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_570541110;
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.091 -0400", hash_original_method = "94C951553FBC2F5928AD7C3B02D8E2C9", hash_generated_method = "EABAA1BBD581F237A7E2D913A8F08CBC")
    private <R> R runActionNoReconnect(Action<R> action, R errorResult, String method) {
        R varB4EAC82CA7396A68D541C85D26508E83_2039047134 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2039047134 = runAction(action, errorResult, method, false);
        addTaint(action.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2039047134.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2039047134;
        // ---------- Original Method ----------
        //return runAction(action, errorResult, method, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.091 -0400", hash_original_method = "29E7B310AE240E4C21F0167C8B8476FB", hash_generated_method = "0FED24CF2A77E8BE2FA60CEE59C4F389")
    private <R> R runAction(Action<R> action, R errorResult, String method) {
        R varB4EAC82CA7396A68D541C85D26508E83_125250072 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_125250072 = runAction(action, errorResult, method, true);
        addTaint(action.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_125250072.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_125250072;
        // ---------- Original Method ----------
        //return runAction(action, errorResult, method, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.093 -0400", hash_original_method = "6EC1A4E0A67965882D9F244E76909BAE", hash_generated_method = "F78BACD00D29E900D87A675836C281E9")
    private <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
        R varB4EAC82CA7396A68D541C85D26508E83_1084810271 = null; //Variable for return #1
        R varB4EAC82CA7396A68D541C85D26508E83_1174904735 = null; //Variable for return #2
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1084810271 = errorResult;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1174904735 = mServiceConnection.runAction(action, errorResult, method, reconnect);
        } //End block
        addTaint(action.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(method.getTaint());
        addTaint(reconnect);
        R varA7E53CE21691AB073D9660D615818899_479918994; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_479918994 = varB4EAC82CA7396A68D541C85D26508E83_1084810271;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_479918994 = varB4EAC82CA7396A68D541C85D26508E83_1174904735;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_479918994.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_479918994;
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //if (mServiceConnection == null) {
                //Log.w(TAG, method + " failed: not bound to TTS engine");
                //return errorResult;
            //}
            //return mServiceConnection.runAction(action, errorResult, method, reconnect);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.094 -0400", hash_original_method = "001A57975E2E50499F283478CA48737A", hash_generated_method = "2495B27CE0372A9A965239FCECB93320")
    private int initTts() {
        {
            boolean varC76336549734AD44BDCB678BF01D59F2_1891733949 = (mRequestedEngine != null && mEnginesHelper.isEngineInstalled(mRequestedEngine));
            {
                {
                    boolean var8911BEC7CCD0FB9FC7E4675F4D27106A_701928753 = (connectToEngine(mRequestedEngine));
                    {
                        mCurrentEngine = mRequestedEngine;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String defaultEngine;
        defaultEngine = getDefaultEngine();
        {
            boolean varABC6D22B8FBEAE604936A23D49D6DDD0_526243091 = (defaultEngine != null && !defaultEngine.equals(mRequestedEngine));
            {
                {
                    boolean var7836D76553A5F05531279189C3A7B50A_541709587 = (connectToEngine(defaultEngine));
                    {
                        mCurrentEngine = defaultEngine;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String highestRanked;
        highestRanked = mEnginesHelper.getHighestRankedEngineName();
        {
            boolean var1A9867EA58712819C70FBE667FD48C74_1624242386 = (highestRanked != null && !highestRanked.equals(mRequestedEngine) &&
                !highestRanked.equals(defaultEngine));
            {
                {
                    boolean varB08B03620CB751C6F0BCA99823142EEF_528651736 = (connectToEngine(highestRanked));
                    {
                        mCurrentEngine = highestRanked;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mCurrentEngine = null;
        dispatchOnInit(ERROR);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171754218 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1171754218;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.118 -0400", hash_original_method = "5177E4BA973A00FB9C33DC0A5DBEACDB", hash_generated_method = "0200BF18291CDAC8979455F9C91B3431")
    private boolean connectToEngine(String engine) {
        Connection connection;
        connection = new Connection();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        boolean bound;
        bound = mContext.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        addTaint(engine.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1964419606 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1964419606;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.119 -0400", hash_original_method = "16B0CCB3D7329F5127962CE558D4D17C", hash_generated_method = "7C813A8608A399BC59BEDAAF103A163A")
    private void dispatchOnInit(int result) {
        {
            {
                mInitListener.onInit(result);
                mInitListener = null;
            } //End block
        } //End block
        addTaint(result);
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //if (mInitListener != null) {
                //mInitListener.onInit(result);
                //mInitListener = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.120 -0400", hash_original_method = "EAB786CB351424B1FA3879678813021A", hash_generated_method = "8D82CD51F9F8342CEE218235B2A84B21")
    public void shutdown() {
        runActionNoReconnect(new Action<Void>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.120 -0400", hash_original_method = "1C176575622D770489EE559F23BB4FED", hash_generated_method = "1A5695A135D39C6B1FFCFA792DD8FAF0")
            @Override
            public Void run(ITextToSpeechService service) throws RemoteException {
                Void varB4EAC82CA7396A68D541C85D26508E83_2068550234 = null; //Variable for return #1
                service.setCallback(getPackageName(), null);
                service.stop(getPackageName());
                mServiceConnection.disconnect();
                mServiceConnection = null;
                mCurrentEngine = null;
                varB4EAC82CA7396A68D541C85D26508E83_2068550234 = null;
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_2068550234.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_2068550234;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.121 -0400", hash_original_method = "DD10D1EA0D37E9C3175CB1CE81EACE27", hash_generated_method = "8BC3CB46D6B4B20E6B248FB86B88EB44")
    public int addSpeech(String text, String packagename, int resourceId) {
        {
            mUtterances.put(text, makeResourceUri(packagename, resourceId));
        } //End block
        addTaint(text.getTaint());
        addTaint(packagename.getTaint());
        addTaint(resourceId);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137609091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2137609091;
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //mUtterances.put(text, makeResourceUri(packagename, resourceId));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.122 -0400", hash_original_method = "DBC13E8086F9460080E153D9CAE05A02", hash_generated_method = "D6C4CD5F6B78B540CCAA41DE26F4A7FA")
    public int addSpeech(String text, String filename) {
        {
            mUtterances.put(text, Uri.parse(filename));
        } //End block
        addTaint(text.getTaint());
        addTaint(filename.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657464758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1657464758;
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //mUtterances.put(text, Uri.parse(filename));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.123 -0400", hash_original_method = "773577F8E212F06A89510B07A5731283", hash_generated_method = "0FB392CC4CF814A70FECB74630C67B8F")
    public int addEarcon(String earcon, String packagename, int resourceId) {
        {
            mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
        } //End block
        addTaint(earcon.getTaint());
        addTaint(packagename.getTaint());
        addTaint(resourceId);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989854908 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989854908;
        // ---------- Original Method ----------
        //synchronized(mStartLock) {
            //mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.123 -0400", hash_original_method = "409D0B7C115347E1FFF71FD2BD1F314E", hash_generated_method = "DA133D35717AC85A7145169343C1E7FF")
    public int addEarcon(String earcon, String filename) {
        {
            mEarcons.put(earcon, Uri.parse(filename));
        } //End block
        addTaint(earcon.getTaint());
        addTaint(filename.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833686809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_833686809;
        // ---------- Original Method ----------
        //synchronized(mStartLock) {
            //mEarcons.put(earcon, Uri.parse(filename));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.132 -0400", hash_original_method = "276BC175828DCE484EB0703A6A0D8E9B", hash_generated_method = "0516B4E6E9371A8B48A2E1BC57689246")
    private Uri makeResourceUri(String packageName, int resourceId) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1127462433 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1127462433 = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .encodedAuthority(packageName)
                .appendEncodedPath(String.valueOf(resourceId))
                .build();
        addTaint(packageName.getTaint());
        addTaint(resourceId);
        varB4EAC82CA7396A68D541C85D26508E83_1127462433.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1127462433;
        // ---------- Original Method ----------
        //return new Uri.Builder()
                //.scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                //.encodedAuthority(packageName)
                //.appendEncodedPath(String.valueOf(resourceId))
                //.build();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.145 -0400", hash_original_method = "BE0E5C2CBBCD37525836C6DA289D2EEC", hash_generated_method = "7120CBBD1B1FB9D3E6B67F0CA89FEE8A")
    public int speak(final String text, final int queueMode, final HashMap<String, String> params) {
        int var06FF1E9A47498D3D5DA596E36D9320E6_1623657304 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.144 -0400", hash_original_method = "7D06D49EA86F29A3C163217832E59726", hash_generated_method = "8211E2D70E6FBB2948C8F6F26A93C131")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_1894360556 = null; //Variable for return #1
                Integer varB4EAC82CA7396A68D541C85D26508E83_715868492 = null; //Variable for return #2
                Uri utteranceUri;
                utteranceUri = mUtterances.get(text);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1894360556 = service.playAudio(getPackageName(), utteranceUri, queueMode,
                            getParams(params));
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_715868492 = service.speak(getPackageName(), text, queueMode, getParams(params));
                } //End block
                addTaint(service.getTaint());
                Integer varA7E53CE21691AB073D9660D615818899_379623958; //Final return value
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: //Assign result for return ordinal #1
                        varA7E53CE21691AB073D9660D615818899_379623958 = varB4EAC82CA7396A68D541C85D26508E83_1894360556;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_379623958 = varB4EAC82CA7396A68D541C85D26508E83_715868492;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_379623958.addTaint(getTaint()); //Add taint from parent
                return varA7E53CE21691AB073D9660D615818899_379623958;
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
        addTaint(text.getTaint());
        addTaint(queueMode);
        addTaint(params.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146238772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2146238772;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.165 -0400", hash_original_method = "F18AB3CD06A1E20DE6BD7099833B6FEC", hash_generated_method = "DE7B3BF87B313DAF17529B5FE6724DB5")
    public int playEarcon(final String earcon, final int queueMode,
            final HashMap<String, String> params) {
        int var76A83EEB264F992409EE3E934E5DC18E_540937415 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.165 -0400", hash_original_method = "6A26B14D42F3FBBE45C132D11F693742", hash_generated_method = "D8CCAEFB8C121FA5B8418B4393EA8424")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_839658318 = null; //Variable for return #1
                Integer varB4EAC82CA7396A68D541C85D26508E83_1369911508 = null; //Variable for return #2
                Uri earconUri;
                earconUri = mEarcons.get(earcon);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_839658318 = ERROR;
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1369911508 = service.playAudio(getPackageName(), earconUri, queueMode,
                        getParams(params));
                addTaint(service.getTaint());
                Integer varA7E53CE21691AB073D9660D615818899_389352500; //Final return value
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: //Assign result for return ordinal #1
                        varA7E53CE21691AB073D9660D615818899_389352500 = varB4EAC82CA7396A68D541C85D26508E83_839658318;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_389352500 = varB4EAC82CA7396A68D541C85D26508E83_1369911508;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_389352500.addTaint(getTaint()); //Add taint from parent
                return varA7E53CE21691AB073D9660D615818899_389352500;
                // ---------- Original Method ----------
                //Uri earconUri = mEarcons.get(earcon);
                //if (earconUri == null) {
                    //return ERROR;
                //}
                //return service.playAudio(getPackageName(), earconUri, queueMode,
                        //getParams(params));
            }
}, ERROR, "playEarcon"));
        addTaint(earcon.getTaint());
        addTaint(queueMode);
        addTaint(params.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718317927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718317927;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.168 -0400", hash_original_method = "94C759FE8B677E32982F42F6A676D86E", hash_generated_method = "429FE0B164FEDE2D0E01CB0A1FB84981")
    public int playSilence(final long durationInMs, final int queueMode,
            final HashMap<String, String> params) {
        int var1952120EBF5A615616D553AB14071EEA_645356462 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.167 -0400", hash_original_method = "78C333BA11B47CA10C93733938393F3E", hash_generated_method = "F784572F5A815686E34961B3C14C49D6")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_634160745 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_634160745 = service.playSilence(getPackageName(), durationInMs, queueMode,
                        getParams(params));
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_634160745.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_634160745;
                // ---------- Original Method ----------
                //return service.playSilence(getPackageName(), durationInMs, queueMode,
                        //getParams(params));
            }
}, ERROR, "playSilence"));
        addTaint(durationInMs);
        addTaint(queueMode);
        addTaint(params.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24585306 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_24585306;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.playSilence(getPackageName(), durationInMs, queueMode,
                        //getParams(params));
            //}
        //}, ERROR, "playSilence");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.169 -0400", hash_original_method = "8AF2E385B6F026EB817E9FE98AB99B1D", hash_generated_method = "21A9267D7D225E97D7A79E8C69CDAAED")
    public Set<String> getFeatures(final Locale locale) {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1528576270 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1528576270 = runAction(new Action<Set<String>>() {
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
        addTaint(locale.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1528576270.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1528576270;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.183 -0400", hash_original_method = "DC605D9F82407CF596B06CFECEFBD8A5", hash_generated_method = "37B8340C1FD12565DA1055F83509559C")
    public boolean isSpeaking() {
        boolean var1E5665730C685F135675E6D121F94A30_479094369 = (runAction(new Action<Boolean>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.183 -0400", hash_original_method = "CDD6871E0A3D820171A5453DF320B8D3", hash_generated_method = "182DB9A3DAC57BB7E483BE0142BA9BA2")
            @Override
            public Boolean run(ITextToSpeechService service) throws RemoteException {
                Boolean varB4EAC82CA7396A68D541C85D26508E83_307404224 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_307404224 = service.isSpeaking();
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_307404224.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_307404224;
                // ---------- Original Method ----------
                //return service.isSpeaking();
            }
}, false, "isSpeaking"));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_412287672 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_412287672;
        // ---------- Original Method ----------
        //return runAction(new Action<Boolean>() {
            //@Override
            //public Boolean run(ITextToSpeechService service) throws RemoteException {
                //return service.isSpeaking();
            //}
        //}, false, "isSpeaking");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.185 -0400", hash_original_method = "1B011279D3385FBEA81C0EEE9DDE31E7", hash_generated_method = "99D7766C9BFD728422162165CCC7BF05")
    public int stop() {
        int var8B881AA56A248EAEDFFD856E50D45137_1467612254 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.185 -0400", hash_original_method = "C3E115845E07ACC22BB6BDAD6EAAC990", hash_generated_method = "1C9B9A066F6DB3BFB830B90590142146")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_293754511 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_293754511 = service.stop(getPackageName());
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_293754511.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_293754511;
                // ---------- Original Method ----------
                //return service.stop(getPackageName());
            }
}, ERROR, "stop"));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103802642 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_103802642;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.stop(getPackageName());
            //}
        //}, ERROR, "stop");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.186 -0400", hash_original_method = "6950E84EE314E7032010233B0706B078", hash_generated_method = "02BAA0B4CE84FC1AA2CA7F838F987B81")
    public int setSpeechRate(float speechRate) {
        {
            int intRate;
            intRate = (int)(speechRate * 100);
            {
                {
                    mParams.putInt(Engine.KEY_PARAM_RATE, intRate);
                } //End block
            } //End block
        } //End block
        addTaint(speechRate);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_871501386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_871501386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.187 -0400", hash_original_method = "7DADB23AB82E5180649E2697B1338160", hash_generated_method = "D68FF1AA9A67FBE7E0D19FC260B24BD9")
    public int setPitch(float pitch) {
        {
            int intPitch;
            intPitch = (int)(pitch * 100);
            {
                {
                    mParams.putInt(Engine.KEY_PARAM_PITCH, intPitch);
                } //End block
            } //End block
        } //End block
        addTaint(pitch);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_653962357 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_653962357;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.198 -0400", hash_original_method = "6F277B1B16E884F81974EA73065A64D8", hash_generated_method = "BDAAD1EDB0B210F0AE4E11C186891AA7")
    public String getCurrentEngine() {
        String varB4EAC82CA7396A68D541C85D26508E83_657475557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_657475557 = mCurrentEngine;
        varB4EAC82CA7396A68D541C85D26508E83_657475557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_657475557;
        // ---------- Original Method ----------
        //return mCurrentEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.200 -0400", hash_original_method = "4B10A46E0E63D1391FC966E12E9B561D", hash_generated_method = "6D9BE2CDC1AE4C2514B29EF409FE51FF")
    public int setLanguage(final Locale loc) {
        int var355AB4CD0F40C7E5333F157D3656B0E1_1898409343 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.200 -0400", hash_original_method = "0CBE42B90B008DE7C85EE0BE4FA8A569", hash_generated_method = "87EF32AF7D47ED56717DE6EEBD3C560E")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_1093211630 = null; //Variable for return #1
                Integer varB4EAC82CA7396A68D541C85D26508E83_1584379040 = null; //Variable for return #2
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1093211630 = LANG_NOT_SUPPORTED;
                } //End block
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
                varB4EAC82CA7396A68D541C85D26508E83_1584379040 = result;
                addTaint(service.getTaint());
                Integer varA7E53CE21691AB073D9660D615818899_1075769938; //Final return value
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: //Assign result for return ordinal #1
                        varA7E53CE21691AB073D9660D615818899_1075769938 = varB4EAC82CA7396A68D541C85D26508E83_1093211630;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_1075769938 = varB4EAC82CA7396A68D541C85D26508E83_1584379040;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_1075769938.addTaint(getTaint()); //Add taint from parent
                return varA7E53CE21691AB073D9660D615818899_1075769938;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
}, LANG_NOT_SUPPORTED, "setLanguage"));
        addTaint(loc.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609771092 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609771092;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.213 -0400", hash_original_method = "BC427E909E00C5BE5A5F111E336651C0", hash_generated_method = "E6E05DB502AFD68320E8A0DC1A5DC924")
    public Locale getLanguage() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_128121077 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_128121077 = runAction(new Action<Locale>() {
            @Override
            public Locale run(ITextToSpeechService service) throws RemoteException {
                String[] locStrings = service.getLanguage();
                if (locStrings != null && locStrings.length == 3) {
                    return new Locale(locStrings[0], locStrings[1], locStrings[2]);
                }
                return null;
            }
        }, null, "getLanguage");
        varB4EAC82CA7396A68D541C85D26508E83_128121077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_128121077;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.215 -0400", hash_original_method = "4344244CB1F796DE537DEBF5170866A9", hash_generated_method = "AC81BE24E6722E31B83543AE8F768B40")
    public int isLanguageAvailable(final Locale loc) {
        int varCFDB3F6AAF4EA707C671768108FE16BB_1235732299 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.214 -0400", hash_original_method = "104F6D4E3824B9F3A36823FE96275A8A", hash_generated_method = "225CDB7D4563A438BBFA85590A979DCD")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_1553221961 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1553221961 = service.isLanguageAvailable(loc.getISO3Language(),
                        loc.getISO3Country(), loc.getVariant());
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1553221961.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1553221961;
                // ---------- Original Method ----------
                //return service.isLanguageAvailable(loc.getISO3Language(),
                        //loc.getISO3Country(), loc.getVariant());
            }
}, LANG_NOT_SUPPORTED, "isLanguageAvailable"));
        addTaint(loc.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798838145 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_798838145;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.isLanguageAvailable(loc.getISO3Language(),
                        //loc.getISO3Country(), loc.getVariant());
            //}
        //}, LANG_NOT_SUPPORTED, "isLanguageAvailable");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.228 -0400", hash_original_method = "59A7F0A106B55E8A59A4D44C2073C3C6", hash_generated_method = "58E11D001212FE1408BE475BB02D90F2")
    public int synthesizeToFile(final String text, final HashMap<String, String> params,
            final String filename) {
        int var8ED79F5341664E190B62E61920ECEEE9_1852449316 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.228 -0400", hash_original_method = "126F93B055F255BA3903970B4BD95F1E", hash_generated_method = "E9861BEB154564E9C04F44C140A1A807")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_1326327668 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1326327668 = service.synthesizeToFile(getPackageName(), text, filename,
                        getParams(params));
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1326327668.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1326327668;
                // ---------- Original Method ----------
                //return service.synthesizeToFile(getPackageName(), text, filename,
                        //getParams(params));
            }
}, ERROR, "synthesizeToFile"));
        addTaint(text.getTaint());
        addTaint(params.getTaint());
        addTaint(filename.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493801214 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_493801214;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.synthesizeToFile(getPackageName(), text, filename,
                        //getParams(params));
            //}
        //}, ERROR, "synthesizeToFile");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.360 -0400", hash_original_method = "F4A729CBEB92036D830EC51C9E6B27A9", hash_generated_method = "C4D5BC8ECD285D898E2B8FC2829CD363")
    private Bundle getParams(HashMap<String, String> params) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1328464840 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1662471752 = null; //Variable for return #2
        {
            boolean var03F97DC16CD5D3704D59B126AFD4BB5D_1426956023 = (params != null && !params.isEmpty());
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
                    boolean varDCACF1CEFE09ED31579385123C6A41F9_2002670189 = (!TextUtils.isEmpty(mCurrentEngine));
                    {
                        {
                            Iterator<Map.Entry<String, String>> varE9C4AC5EB9F7220631D2D77DC566F3A2_1377846725 = (params.entrySet()).iterator();
                            varE9C4AC5EB9F7220631D2D77DC566F3A2_1377846725.hasNext();
                            Map.Entry<String, String> entry = varE9C4AC5EB9F7220631D2D77DC566F3A2_1377846725.next();
                            {
                                String key;
                                key = entry.getKey();
                                {
                                    boolean var067B24247B41FD99A3F806EDF88D0891_550133050 = (key != null && key.startsWith(mCurrentEngine));
                                    {
                                        bundle.putString(key, entry.getValue());
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1328464840 = bundle;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1662471752 = mParams;
            } //End block
        } //End collapsed parenthetic
        addTaint(params.getTaint());
        Bundle varA7E53CE21691AB073D9660D615818899_1600885031; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1600885031 = varB4EAC82CA7396A68D541C85D26508E83_1328464840;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1600885031 = varB4EAC82CA7396A68D541C85D26508E83_1662471752;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1600885031.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1600885031;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.361 -0400", hash_original_method = "CA756292003AA5F2AACD5FD8062D880F", hash_generated_method = "109398798ADEAF0B723B1AE6063B940B")
    private void copyStringParam(Bundle bundle, HashMap<String, String> params, String key) {
        String value;
        value = params.get(key);
        {
            bundle.putString(key, value);
        } //End block
        addTaint(bundle.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //String value = params.get(key);
        //if (value != null) {
            //bundle.putString(key, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.373 -0400", hash_original_method = "D148C993B4D17B611EC6A14A9B3B3D7B", hash_generated_method = "B2235DCF85774550DAC3CDCDC6EF472A")
    private void copyIntParam(Bundle bundle, HashMap<String, String> params, String key) {
        String valueString;
        valueString = params.get(key);
        {
            boolean var7538D513B192AB3E879BF618E72A8D7E_1397351878 = (!TextUtils.isEmpty(valueString));
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
        addTaint(bundle.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.374 -0400", hash_original_method = "335CA474B2AA628361250A653672DD72", hash_generated_method = "47804573289C2D010D6F9C569C0C31D9")
    private void copyFloatParam(Bundle bundle, HashMap<String, String> params, String key) {
        String valueString;
        valueString = params.get(key);
        {
            boolean var7538D513B192AB3E879BF618E72A8D7E_937420046 = (!TextUtils.isEmpty(valueString));
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
        addTaint(bundle.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.375 -0400", hash_original_method = "24D73865C05CC11CAA8C791D8BA56024", hash_generated_method = "C178BE04EC8894AD5B243BE6CED17664")
    @Deprecated
    public int setOnUtteranceCompletedListener(final OnUtteranceCompletedListener listener) {
        mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_397555249 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_397555249;
        // ---------- Original Method ----------
        //mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        //return TextToSpeech.SUCCESS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.375 -0400", hash_original_method = "98074E19965AB76BE23153F0217E2857", hash_generated_method = "BD4AFB3F94C95ACF4AFF1EB0A09D9FFC")
    public int setOnUtteranceProgressListener(UtteranceProgressListener listener) {
        mUtteranceProgressListener = listener;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633837906 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1633837906;
        // ---------- Original Method ----------
        //mUtteranceProgressListener = listener;
        //return TextToSpeech.SUCCESS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.375 -0400", hash_original_method = "06FE1E6C6795B03B25AD43DFED268D92", hash_generated_method = "1243CD929415CAB793DD7F9F1333A40C")
    @Deprecated
    public int setEngineByPackageName(String enginePackageName) {
        mRequestedEngine = enginePackageName;
        int var663EB57F9D9E552BC588A53FE17E210D_988014289 = (initTts());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100999452 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100999452;
        // ---------- Original Method ----------
        //mRequestedEngine = enginePackageName;
        //return initTts();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.392 -0400", hash_original_method = "AAA28EF74B57D47AEDCF93243FD04D81", hash_generated_method = "C6D1C0585EF794F6A9650011B69F5167")
    public String getDefaultEngine() {
        String varB4EAC82CA7396A68D541C85D26508E83_978835741 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_978835741 = mEnginesHelper.getDefaultEngine();
        varB4EAC82CA7396A68D541C85D26508E83_978835741.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_978835741;
        // ---------- Original Method ----------
        //return mEnginesHelper.getDefaultEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.392 -0400", hash_original_method = "FDBC18F088428D1AA4FA407CF8A38EB5", hash_generated_method = "89BFE28E3DEF0968E5C1DE3A471AF6FE")
    public boolean areDefaultsEnforced() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_805720780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_805720780;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.393 -0400", hash_original_method = "C282EF17EB1B4600865CB51DA0934709", hash_generated_method = "44EB8295C2255EAF491A0F768FA6DA9A")
    public List<EngineInfo> getEngines() {
        List<EngineInfo> varB4EAC82CA7396A68D541C85D26508E83_10674978 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_10674978 = mEnginesHelper.getEngines();
        varB4EAC82CA7396A68D541C85D26508E83_10674978.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_10674978;
        // ---------- Original Method ----------
        //return mEnginesHelper.getEngines();
    }

    
    public class Engine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_method = "0CEE966FD083EAF9A38425EF355FEEF7", hash_generated_method = "0CEE966FD083EAF9A38425EF355FEEF7")
        public Engine ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "36D45D439A9D88F92C91EED7F227B118", hash_generated_field = "6EA685DC1F94714F1A1A1A053FC21028")

        public static final int DEFAULT_RATE = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "735042F181F97049F645A49551694C8F", hash_generated_field = "7265570D9BCE2101E8993107FABA1337")

        public static final int DEFAULT_PITCH = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "2CCE70ADE73106C43ECEE5E8A9205C7A", hash_generated_field = "95742929B161124D7ABDF4B245140DE7")

        public static final float DEFAULT_VOLUME = 1.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "1B7AB37CA837BE7D293E3424675F31F6", hash_generated_field = "BDDAA621A92D5CA41E24125645C10B9B")

        public static final float DEFAULT_PAN = 0.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "24C227C2F4C89803E4CC9D1CA4639012", hash_generated_field = "79A00612A369353FB0B563BBFBDD7A1F")

        public static final int USE_DEFAULTS = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "963BFD7556945F0ADCDB7063AA317405", hash_generated_field = "52D9AB195E713E24D836C4A49CC0D622")

        @Deprecated
        public static final String DEFAULT_ENGINE = "com.svox.pico";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "54C932376EBA54F9168634618A59869D", hash_generated_field = "C75C9F49D040B89D31A5EEE24181A5F2")

        public static final int DEFAULT_STREAM = AudioManager.STREAM_MUSIC;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "E08E1E62A1BA16AAB29D7A9A032DCA62", hash_generated_field = "C254DAAF5EBFA8002B27291ACC23702C")

        public static final int CHECK_VOICE_DATA_PASS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "EE2889DAB98E247108FD560D3EFB02FD", hash_generated_field = "E9C03161A9F0FFF5472A0040222D4C52")

        public static final int CHECK_VOICE_DATA_FAIL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "2DAAF7CA0FE4E57592622B27A82A704D", hash_generated_field = "431FD9B6D302AD606FFE065DF75DD2FA")

        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "CFC6EC4DDDF9F323DBC81D082171E33E", hash_generated_field = "7387564E7167154EEFED8705FCA0EED8")

        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "8D2D3E2E79C2C4E707239463D369E33B", hash_generated_field = "183E08CD13799093F5F5A44B05FDE73C")

        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "43EE5A08705D902AFADBFC04343199B2", hash_generated_field = "CAF4E59B3718CCEA9FF9E5188B9F6370")

        @SdkConstant(SdkConstantType.SERVICE_ACTION)
        public static final String INTENT_ACTION_TTS_SERVICE =
                "android.intent.action.TTS_SERVICE";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "E4042E25AFA9C947989DCC050E289401", hash_generated_field = "1838FC1E408F29335D36A08788A826E6")

        public static final String SERVICE_META_DATA = "android.speech.tts";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "A6833C0165AB755C6E068259E162C946", hash_generated_field = "AD45F25D873943976C37BF808E1956BE")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_INSTALL_TTS_DATA =
                "android.speech.tts.engine.INSTALL_TTS_DATA";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "D6AE8B393AF81687E39AF98587E4CABC", hash_generated_field = "A33F17727F43DBD7A47E893BB9B716B9")

        @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
        public static final String ACTION_TTS_DATA_INSTALLED =
                "android.speech.tts.engine.TTS_DATA_INSTALLED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "FA190AA53E599DBC899F53B55858698C", hash_generated_field = "43F20E850CE384CB5D9C74DD369FDD87")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_CHECK_TTS_DATA =
                "android.speech.tts.engine.CHECK_TTS_DATA";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.394 -0400", hash_original_field = "5C6C6397C49314D5F5E204CA1933345E", hash_generated_field = "58E16B540735E811A37625B0342CFA0F")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_GET_SAMPLE_TEXT =
                "android.speech.tts.engine.GET_SAMPLE_TEXT";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "9F649196082E67572C2349155C9919D2", hash_generated_field = "178CAFEE370EC9E79529912F27523F36")

        public static final String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "EFCBBB44D3D24A3D84E5ABC46FC70857", hash_generated_field = "2FCEBB35020F29546E39463BDD214A73")

        public static final String EXTRA_VOICE_DATA_FILES = "dataFiles";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "1DC90AA7734216663D84607F446D95B3", hash_generated_field = "23CB204D3DC0650A224FB5ABA98F25A7")

        public static final String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "FD4F2914F7FB71A96D2E879989B79136", hash_generated_field = "A5FF7832C171B046C21F825764FE8230")

        public static final String EXTRA_AVAILABLE_VOICES = "availableVoices";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "25CADBA271F43B9ED671E6822C5D1A88", hash_generated_field = "AC4770FDD8C95CC92539FC82143B39C5")

        public static final String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "C44D63A48B4EB093B375BC969B445992", hash_generated_field = "C8E0905A88A840D679AC2FF9508E3712")

        public static final String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "85A22E5221C66B5FEA03947CDBB2D9D0", hash_generated_field = "566A9FB915E742DB0D9FCBB9613D8A98")

        public static final String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "F36FF974081651AF068D67E5D4C4C65B", hash_generated_field = "9662C467B57A79462A5A958B925CD456")

        public static final String KEY_PARAM_RATE = "rate";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "A30E5701A5E3DB6B461EF4FA9632FED2", hash_generated_field = "41A112801807BF60F6B64B56EABC75A7")

        public static final String KEY_PARAM_LANGUAGE = "language";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "049E0A857DB03C5705F89387DBFA3F94", hash_generated_field = "B9529957E3604F14146602846E9977A5")

        public static final String KEY_PARAM_COUNTRY = "country";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "5DD9CAE974E3E4DF07273B713C0141E3", hash_generated_field = "194C150941509AFA9F06806544278558")

        public static final String KEY_PARAM_VARIANT = "variant";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "4BF977BE522A7D4FAECCE001402B4B22", hash_generated_field = "5790995E2173B750C19C7F0DF730BD18")

        public static final String KEY_PARAM_ENGINE = "engine";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "8EFCD27051CF12277949A1C6787CF4CA", hash_generated_field = "3BDB1A8EA9944800172EB2E01D630D39")

        public static final String KEY_PARAM_PITCH = "pitch";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "82BD90E3DC3CCF8584C41564CAE4AAB5", hash_generated_field = "AA44CC9D49E0D6103F2E361CC4DC18B0")

        public static final String KEY_PARAM_STREAM = "streamType";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "1A45AC9684F0F72F5EB630E624D8FB7C", hash_generated_field = "D01CCD0CAFBD7B77262BEE4DF757451B")

        public static final String KEY_PARAM_UTTERANCE_ID = "utteranceId";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "EB555D6AB84BF7E41BAC2B5D53A5F9B2", hash_generated_field = "F31741CDDA9583A05DBFC466602DB856")

        public static final String KEY_PARAM_VOLUME = "volume";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "5C37A91E922F1CA033CF81267F80980E", hash_generated_field = "5C33025FF7CAEFB03AF35CC41A77E51F")

        public static final String KEY_PARAM_PAN = "pan";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.395 -0400", hash_original_field = "B9B59CA107B4998520D8F04E86304BB9", hash_generated_field = "9C632C8E548D61E23BCBF91A78385C5A")

        public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.396 -0400", hash_original_field = "5D6A2E8BAB4CD47E940B987CF3C63014", hash_generated_field = "367B7447EF0E1BB5CDEB71ED7EF27786")

        public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    }


    
    private class Connection implements ServiceConnection {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.396 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "D3C3F8FD9BA670292396CDDDD2DBC0CC")

        private ITextToSpeechService mService;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.408 -0400", hash_original_field = "E1D8F791D3BB3666B7074B1777047AD0", hash_generated_field = "5A97993C9486A509C2F3120D21DEDD05")

        private ITextToSpeechCallback.Stub mCallback = new ITextToSpeechCallback.Stub() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.397 -0400", hash_original_method = "5A69319C8BD2B805ED99ED76716CFEEE", hash_generated_method = "77FAF422931FDA5832200B836CFC99B0")
            @Override
            public void onDone(String utteranceId) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                UtteranceProgressListener listener;
                listener = mUtteranceProgressListener;
                {
                    listener.onDone(utteranceId);
                } //End block
                addTaint(utteranceId.getTaint());
                // ---------- Original Method ----------
                //UtteranceProgressListener listener = mUtteranceProgressListener;
                //if (listener != null) {
                    //listener.onDone(utteranceId);
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.408 -0400", hash_original_method = "71BFFA04ED8551E163779942DCEAA326", hash_generated_method = "4512F4857A045800C3D1AF83F334076A")
            @Override
            public void onError(String utteranceId) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                UtteranceProgressListener listener;
                listener = mUtteranceProgressListener;
                {
                    listener.onError(utteranceId);
                } //End block
                addTaint(utteranceId.getTaint());
                // ---------- Original Method ----------
                //UtteranceProgressListener listener = mUtteranceProgressListener;
                //if (listener != null) {
                    //listener.onError(utteranceId);
                //}
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.408 -0400", hash_original_method = "AC6831F715B5A1560C1EB20081DD1B2E", hash_generated_method = "3D1CEB6C91B05D2DC1A5F2F6BAB0ACC6")
            @Override
            public void onStart(String utteranceId) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                UtteranceProgressListener listener;
                listener = mUtteranceProgressListener;
                {
                    listener.onStart(utteranceId);
                } //End block
                addTaint(utteranceId.getTaint());
                // ---------- Original Method ----------
                //UtteranceProgressListener listener = mUtteranceProgressListener;
                //if (listener != null) {
                    //listener.onStart(utteranceId);
                //}
            }

            
};
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.409 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
        public Connection ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.409 -0400", hash_original_method = "E38F495B4498EDF08C66FB9F592C4572", hash_generated_method = "13D0F2DA18AB79324430B218EDA72263")
        public void onServiceConnected(ComponentName name, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
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
            addTaint(name.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.416 -0400", hash_original_method = "9CBB724FFDF56C58A2F363CBB7ADEB66", hash_generated_method = "7DBB2DCB7F37C19B4AD373F0BA7808B0")
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mService = null;
                {
                    boolean varCFBB343190D0053DBC4029F6CA0B9372_1120251747 = (mServiceConnection == this);
                    {
                        mServiceConnection = null;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(name.getTaint());
            // ---------- Original Method ----------
            //synchronized(mStartLock) {
                //mService = null;
                //if (mServiceConnection == this) {
                    //mServiceConnection = null;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.417 -0400", hash_original_method = "670DB56217535BA78AC55188B9013676", hash_generated_method = "22BDFB36185642ED4E82BED8A6D53D5B")
        public void disconnect() {
            mContext.unbindService(this);
            // ---------- Original Method ----------
            //mContext.unbindService(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.421 -0400", hash_original_method = "34464E55B5499CA206CC99D3045C1292", hash_generated_method = "E97C8C0A4DFC24ECA6E9FEE0B1878A96")
        public <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
            R varB4EAC82CA7396A68D541C85D26508E83_1456395407 = null; //Variable for return #1
            R varB4EAC82CA7396A68D541C85D26508E83_547670891 = null; //Variable for return #2
            R varB4EAC82CA7396A68D541C85D26508E83_441829408 = null; //Variable for return #3
            try 
            {
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1456395407 = errorResult;
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_547670891 = action.run(mService);
                } //End block
            } //End block
            catch (RemoteException ex)
            {
                {
                    disconnect();
                    initTts();
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_441829408 = errorResult;
            } //End block
            addTaint(action.getTaint());
            addTaint(errorResult.getTaint());
            addTaint(method.getTaint());
            addTaint(reconnect);
            R varA7E53CE21691AB073D9660D615818899_2007480398; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_2007480398 = varB4EAC82CA7396A68D541C85D26508E83_1456395407;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_2007480398 = varB4EAC82CA7396A68D541C85D26508E83_547670891;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_2007480398 = varB4EAC82CA7396A68D541C85D26508E83_441829408;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_2007480398.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_2007480398;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.421 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.421 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "B1C3A1439C6538148E2C8C0A71DA201D")

        public String label;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.421 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.421 -0400", hash_original_field = "54B53072540EEEB8F8E9343E71F28176", hash_generated_field = "D1DBA00001B7F415431AD6FCAB5BAA5D")

        public boolean system;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.421 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

        public int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.421 -0400", hash_original_method = "1BD677F38EE0D51841725F2C2D5029FA", hash_generated_method = "1BD677F38EE0D51841725F2C2D5029FA")
        public EngineInfo ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.434 -0400", hash_original_method = "2BF343FE966C95427B565E993C403E36", hash_generated_method = "3BC373B826D0F60A23FFCBA94B97461C")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1316939170 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1316939170 = "EngineInfo{name=" + name + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1316939170.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1316939170;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "DF41A127C133B054D95ADD91C88170F4", hash_generated_field = "0DC1DBFECA0D70FFFE44CCB13E744EFC")

    private static String TAG = "TextToSpeech";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "C8AE4103156B65C0D23556A48DB4D815", hash_generated_field = "9B986A2CF4CE0B3870A44EA118A88E9A")

    public static final int SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "5DDED9E5103DBD4703C0660F86E0B86E", hash_generated_field = "D9FDA3C0E4B8421EF0ECF23EDE3289A4")

    public static final int ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "95588520F32581BA8D1244F13101ED06", hash_generated_field = "02E0C42BFDC9472143A2816BE6A46302")

    public static final int QUEUE_FLUSH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "E3380CB05B87800713541EA7B6C5393B", hash_generated_field = "E3D905B07D88D805D26B80E9C9543333")

    public static final int QUEUE_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "7B7F3B3D69B07673CD2E7AAF005CBF5F", hash_generated_field = "966838726B4A9B6303183A4F3EDD9D23")

    static int QUEUE_DESTROY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "DFAFB9213D04FA47F5A5F2A4B74F14B3", hash_generated_field = "114C4BE7840CE5276181D4AD399DD60A")

    public static final int LANG_COUNTRY_VAR_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "5FA467857132F3FB084FACD4877020EB", hash_generated_field = "615AF214DE081692194C09BC057B78F6")

    public static final int LANG_COUNTRY_AVAILABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "E8D8099546226BEB455FFD46312483E0", hash_generated_field = "D0C3004A60A5D721A3D561D3F15B8744")

    public static final int LANG_AVAILABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "728E1D2145BB05D62DE4ABA628047B9D", hash_generated_field = "811988C198657A72F3A46F0269AEEEC3")

    public static final int LANG_MISSING_DATA = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "E4F8C9D14EBD840CD3FB4037BAF176AF", hash_generated_field = "D282ACE529F1D4C71E5D1D903CE29D28")

    public static final int LANG_NOT_SUPPORTED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:30.435 -0400", hash_original_field = "7D2E96656AB2A31B8BC2DBA52B97A09F", hash_generated_field = "1613EE279914B2EEC593ED6D5A8EDA25")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED =
            "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
}

