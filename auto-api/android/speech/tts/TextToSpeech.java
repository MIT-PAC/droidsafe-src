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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.816 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.816 -0400", hash_original_field = "94CA83B0A5EF3662095068A2D93D4E51", hash_generated_field = "46824CCAF8D8A297954B79F68288C27C")

    private Connection mServiceConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.817 -0400", hash_original_field = "BD66CA08574E567F4A2FF02EAF3A3C43", hash_generated_field = "9260ADD518F0FEF38A450F7DB53206FF")

    private OnInitListener mInitListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.817 -0400", hash_original_field = "FCC9BC767DCFBBDC0E992E8F8F631777", hash_generated_field = "328E3D7B680D2F02E50F03A1B91A5C91")

    private volatile UtteranceProgressListener mUtteranceProgressListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.817 -0400", hash_original_field = "A566AAD21AECEFD87B9A641763F0E8ED", hash_generated_field = "4A192614697485D7DF6A454D01177650")

    private Object mStartLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.817 -0400", hash_original_field = "79A963EB2FE6CF7ED985A37C9C2DAFC8", hash_generated_field = "87C8AA46082F357B5A90BEFDCD55A9CA")

    private String mRequestedEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.817 -0400", hash_original_field = "4FBF9E2CF0458E920CECA1122F7CE66F", hash_generated_field = "F6B4C1579EC35D212C4AF2EE4A947247")

    private Map<String, Uri> mEarcons;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.817 -0400", hash_original_field = "DADCFF0BCD3190EF5EA5DAA385F05AFC", hash_generated_field = "AF9F14E0A7A7BBE0D15082F4D775A15F")

    private Map<String, Uri> mUtterances;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.817 -0400", hash_original_field = "2E7257A953F47313410ACCB399EF186C", hash_generated_field = "9E4D0E55335EFF51CCB0FD2F602C54D1")

    private Bundle mParams = new Bundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.817 -0400", hash_original_field = "3D23233AD3766EA5A08A04C38A75975D", hash_generated_field = "C4FA3CBED7ED304B229BB483017A66E9")

    private TtsEngines mEnginesHelper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.817 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.817 -0400", hash_original_field = "D10648D448DDFF74BD81B300412AA0DA", hash_generated_field = "8E5DC033BD559466A27E8B7E16939D55")

    private volatile String mCurrentEngine = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.830 -0400", hash_original_method = "E5C095C9A34533EB222D42D1A6D92941", hash_generated_method = "5EBF6E91AC53E9A8A9B0A253EEC90A14")
    public  TextToSpeech(Context context, OnInitListener listener) {
        this(context, listener, null);
        addTaint(context.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.831 -0400", hash_original_method = "894D965EFAB67E7E0E3D1E11B990F0FA", hash_generated_method = "9DB3A3DA3B73688B98CF2FBCD7304F9A")
    public  TextToSpeech(Context context, OnInitListener listener, String engine) {
        this(context, listener, engine, null);
        addTaint(context.getTaint());
        addTaint(listener.getTaint());
        addTaint(engine.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.832 -0400", hash_original_method = "0584A597F5F20737FDED0391417BF29B", hash_generated_method = "B4006DE63FF57B393B290520D5ED86F0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.836 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "7789821F4E967F0C55F2A0FF73DB63CD")
    private String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1748633073 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1748633073 = mPackageName;
        varB4EAC82CA7396A68D541C85D26508E83_1748633073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1748633073;
        // ---------- Original Method ----------
        //return mPackageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.847 -0400", hash_original_method = "94C951553FBC2F5928AD7C3B02D8E2C9", hash_generated_method = "EC808065796A3D7471E6D3BA272E4B06")
    private <R> R runActionNoReconnect(Action<R> action, R errorResult, String method) {
        R varB4EAC82CA7396A68D541C85D26508E83_1519563960 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1519563960 = runAction(action, errorResult, method, false);
        addTaint(action.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1519563960.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1519563960;
        // ---------- Original Method ----------
        //return runAction(action, errorResult, method, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.848 -0400", hash_original_method = "29E7B310AE240E4C21F0167C8B8476FB", hash_generated_method = "8F52CF973F140721BBBD9431DFD221B5")
    private <R> R runAction(Action<R> action, R errorResult, String method) {
        R varB4EAC82CA7396A68D541C85D26508E83_301178484 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_301178484 = runAction(action, errorResult, method, true);
        addTaint(action.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_301178484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_301178484;
        // ---------- Original Method ----------
        //return runAction(action, errorResult, method, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.853 -0400", hash_original_method = "6EC1A4E0A67965882D9F244E76909BAE", hash_generated_method = "9ABCB26E26104114A1A4CCCF7454420A")
    private <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
        R varB4EAC82CA7396A68D541C85D26508E83_1615240845 = null; //Variable for return #1
        R varB4EAC82CA7396A68D541C85D26508E83_1665079555 = null; //Variable for return #2
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1615240845 = errorResult;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1665079555 = mServiceConnection.runAction(action, errorResult, method, reconnect);
        } //End block
        addTaint(action.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(method.getTaint());
        addTaint(reconnect);
        R varA7E53CE21691AB073D9660D615818899_1119018654; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1119018654 = varB4EAC82CA7396A68D541C85D26508E83_1615240845;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1119018654 = varB4EAC82CA7396A68D541C85D26508E83_1665079555;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1119018654.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1119018654;
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //if (mServiceConnection == null) {
                //Log.w(TAG, method + " failed: not bound to TTS engine");
                //return errorResult;
            //}
            //return mServiceConnection.runAction(action, errorResult, method, reconnect);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.875 -0400", hash_original_method = "001A57975E2E50499F283478CA48737A", hash_generated_method = "78A9F069C80799586830D4B605D8CDAA")
    private int initTts() {
        {
            boolean varC76336549734AD44BDCB678BF01D59F2_822864389 = (mRequestedEngine != null && mEnginesHelper.isEngineInstalled(mRequestedEngine));
            {
                {
                    boolean var8911BEC7CCD0FB9FC7E4675F4D27106A_2025547914 = (connectToEngine(mRequestedEngine));
                    {
                        mCurrentEngine = mRequestedEngine;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String defaultEngine;
        defaultEngine = getDefaultEngine();
        {
            boolean varABC6D22B8FBEAE604936A23D49D6DDD0_86932072 = (defaultEngine != null && !defaultEngine.equals(mRequestedEngine));
            {
                {
                    boolean var7836D76553A5F05531279189C3A7B50A_665849567 = (connectToEngine(defaultEngine));
                    {
                        mCurrentEngine = defaultEngine;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String highestRanked;
        highestRanked = mEnginesHelper.getHighestRankedEngineName();
        {
            boolean var1A9867EA58712819C70FBE667FD48C74_836724804 = (highestRanked != null && !highestRanked.equals(mRequestedEngine) &&
                !highestRanked.equals(defaultEngine));
            {
                {
                    boolean varB08B03620CB751C6F0BCA99823142EEF_1098803791 = (connectToEngine(highestRanked));
                    {
                        mCurrentEngine = highestRanked;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mCurrentEngine = null;
        dispatchOnInit(ERROR);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835265854 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1835265854;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.881 -0400", hash_original_method = "5177E4BA973A00FB9C33DC0A5DBEACDB", hash_generated_method = "496A6F1231164BF0F5E8A9A42A7E093E")
    private boolean connectToEngine(String engine) {
        Connection connection;
        connection = new Connection();
        Intent intent;
        intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        boolean bound;
        bound = mContext.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        addTaint(engine.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_731924924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_731924924;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.882 -0400", hash_original_method = "16B0CCB3D7329F5127962CE558D4D17C", hash_generated_method = "7C813A8608A399BC59BEDAAF103A163A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.892 -0400", hash_original_method = "EAB786CB351424B1FA3879678813021A", hash_generated_method = "BE602F3DEC8578C0464A784F2966EDB4")
    public void shutdown() {
        runActionNoReconnect(new Action<Void>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.884 -0400", hash_original_method = "1C176575622D770489EE559F23BB4FED", hash_generated_method = "4C3201F42835E28D062A2D6D5363729F")
            @Override
            public Void run(ITextToSpeechService service) throws RemoteException {
                Void varB4EAC82CA7396A68D541C85D26508E83_2038744676 = null; //Variable for return #1
                service.setCallback(getPackageName(), null);
                service.stop(getPackageName());
                mServiceConnection.disconnect();
                mServiceConnection = null;
                mCurrentEngine = null;
                varB4EAC82CA7396A68D541C85D26508E83_2038744676 = null;
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_2038744676.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_2038744676;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.893 -0400", hash_original_method = "DD10D1EA0D37E9C3175CB1CE81EACE27", hash_generated_method = "913D9C9A3F33E91B33A88A5D6198E809")
    public int addSpeech(String text, String packagename, int resourceId) {
        {
            mUtterances.put(text, makeResourceUri(packagename, resourceId));
        } //End block
        addTaint(text.getTaint());
        addTaint(packagename.getTaint());
        addTaint(resourceId);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585706810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1585706810;
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //mUtterances.put(text, makeResourceUri(packagename, resourceId));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.893 -0400", hash_original_method = "DBC13E8086F9460080E153D9CAE05A02", hash_generated_method = "1A1EC0FD50FA2F0ECEF3D67B9928DC30")
    public int addSpeech(String text, String filename) {
        {
            mUtterances.put(text, Uri.parse(filename));
        } //End block
        addTaint(text.getTaint());
        addTaint(filename.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773987181 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773987181;
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //mUtterances.put(text, Uri.parse(filename));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.897 -0400", hash_original_method = "773577F8E212F06A89510B07A5731283", hash_generated_method = "5C16E2E867704421F57213F89801E3FE")
    public int addEarcon(String earcon, String packagename, int resourceId) {
        {
            mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
        } //End block
        addTaint(earcon.getTaint());
        addTaint(packagename.getTaint());
        addTaint(resourceId);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517952250 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_517952250;
        // ---------- Original Method ----------
        //synchronized(mStartLock) {
            //mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.898 -0400", hash_original_method = "409D0B7C115347E1FFF71FD2BD1F314E", hash_generated_method = "B1B06736B99AFDAB1B7AC0F00850693F")
    public int addEarcon(String earcon, String filename) {
        {
            mEarcons.put(earcon, Uri.parse(filename));
        } //End block
        addTaint(earcon.getTaint());
        addTaint(filename.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577350 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577350;
        // ---------- Original Method ----------
        //synchronized(mStartLock) {
            //mEarcons.put(earcon, Uri.parse(filename));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.920 -0400", hash_original_method = "276BC175828DCE484EB0703A6A0D8E9B", hash_generated_method = "4DC3C75D0E9A221970E237588B06812D")
    private Uri makeResourceUri(String packageName, int resourceId) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1430962779 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1430962779 = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .encodedAuthority(packageName)
                .appendEncodedPath(String.valueOf(resourceId))
                .build();
        addTaint(packageName.getTaint());
        addTaint(resourceId);
        varB4EAC82CA7396A68D541C85D26508E83_1430962779.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1430962779;
        // ---------- Original Method ----------
        //return new Uri.Builder()
                //.scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                //.encodedAuthority(packageName)
                //.appendEncodedPath(String.valueOf(resourceId))
                //.build();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.922 -0400", hash_original_method = "BE0E5C2CBBCD37525836C6DA289D2EEC", hash_generated_method = "45C6FD5C6A5788A9C5FE7CCC7D1C5923")
    public int speak(final String text, final int queueMode, final HashMap<String, String> params) {
        int varD70EEE39766B311A3E22856CBD792BA7_1990515002 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.922 -0400", hash_original_method = "7D06D49EA86F29A3C163217832E59726", hash_generated_method = "840DB06F048FAAA1E14F0973B094C446")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_297653656 = null; //Variable for return #1
                Integer varB4EAC82CA7396A68D541C85D26508E83_337488375 = null; //Variable for return #2
                Uri utteranceUri;
                utteranceUri = mUtterances.get(text);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_297653656 = service.playAudio(getPackageName(), utteranceUri, queueMode,
                            getParams(params));
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_337488375 = service.speak(getPackageName(), text, queueMode, getParams(params));
                } //End block
                addTaint(service.getTaint());
                Integer varA7E53CE21691AB073D9660D615818899_563379489; //Final return value
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: //Assign result for return ordinal #1
                        varA7E53CE21691AB073D9660D615818899_563379489 = varB4EAC82CA7396A68D541C85D26508E83_297653656;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_563379489 = varB4EAC82CA7396A68D541C85D26508E83_337488375;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_563379489.addTaint(getTaint()); //Add taint from parent
                return varA7E53CE21691AB073D9660D615818899_563379489;
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041791953 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1041791953;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.936 -0400", hash_original_method = "F18AB3CD06A1E20DE6BD7099833B6FEC", hash_generated_method = "1059E4EAC0A30B592AD3260D524374A5")
    public int playEarcon(final String earcon, final int queueMode,
            final HashMap<String, String> params) {
        int varC1089C97BAF76885643BA39998114DCC_1548012996 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.936 -0400", hash_original_method = "6A26B14D42F3FBBE45C132D11F693742", hash_generated_method = "06EC1A6F1165B283E035A21F660B62B3")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_884170850 = null; //Variable for return #1
                Integer varB4EAC82CA7396A68D541C85D26508E83_795517037 = null; //Variable for return #2
                Uri earconUri;
                earconUri = mEarcons.get(earcon);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_884170850 = ERROR;
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_795517037 = service.playAudio(getPackageName(), earconUri, queueMode,
                        getParams(params));
                addTaint(service.getTaint());
                Integer varA7E53CE21691AB073D9660D615818899_184286574; //Final return value
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: //Assign result for return ordinal #1
                        varA7E53CE21691AB073D9660D615818899_184286574 = varB4EAC82CA7396A68D541C85D26508E83_884170850;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_184286574 = varB4EAC82CA7396A68D541C85D26508E83_795517037;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_184286574.addTaint(getTaint()); //Add taint from parent
                return varA7E53CE21691AB073D9660D615818899_184286574;
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142826084 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142826084;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.941 -0400", hash_original_method = "94C759FE8B677E32982F42F6A676D86E", hash_generated_method = "352C1A7D0268C2382EDDA4CAC0769441")
    public int playSilence(final long durationInMs, final int queueMode,
            final HashMap<String, String> params) {
        int varBC0DC48D06E7A0A1310E0340A21C0E16_1964213249 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.941 -0400", hash_original_method = "78C333BA11B47CA10C93733938393F3E", hash_generated_method = "D063A7BF959289C5A75A8C1A72F117FE")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_595176210 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_595176210 = service.playSilence(getPackageName(), durationInMs, queueMode,
                        getParams(params));
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_595176210.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_595176210;
                // ---------- Original Method ----------
                //return service.playSilence(getPackageName(), durationInMs, queueMode,
                        //getParams(params));
            }
}, ERROR, "playSilence"));
        addTaint(durationInMs);
        addTaint(queueMode);
        addTaint(params.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544244021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1544244021;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.playSilence(getPackageName(), durationInMs, queueMode,
                        //getParams(params));
            //}
        //}, ERROR, "playSilence");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.942 -0400", hash_original_method = "8AF2E385B6F026EB817E9FE98AB99B1D", hash_generated_method = "2FFC1F28BDC081D367BA71B9912F6AE0")
    public Set<String> getFeatures(final Locale locale) {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1589815514 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1589815514 = runAction(new Action<Set<String>>() {
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
        varB4EAC82CA7396A68D541C85D26508E83_1589815514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1589815514;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.956 -0400", hash_original_method = "DC605D9F82407CF596B06CFECEFBD8A5", hash_generated_method = "D75C168CB0FB64F80A2A6C631310106D")
    public boolean isSpeaking() {
        boolean var4A398702A28DEA06AE8211FD44D87780_1622630787 = (runAction(new Action<Boolean>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.955 -0400", hash_original_method = "CDD6871E0A3D820171A5453DF320B8D3", hash_generated_method = "7DBBDB8736A96F2E22DDA5EFC12E8860")
            @Override
            public Boolean run(ITextToSpeechService service) throws RemoteException {
                Boolean varB4EAC82CA7396A68D541C85D26508E83_1206210270 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1206210270 = service.isSpeaking();
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1206210270.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1206210270;
                // ---------- Original Method ----------
                //return service.isSpeaking();
            }
}, false, "isSpeaking"));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1949605312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1949605312;
        // ---------- Original Method ----------
        //return runAction(new Action<Boolean>() {
            //@Override
            //public Boolean run(ITextToSpeechService service) throws RemoteException {
                //return service.isSpeaking();
            //}
        //}, false, "isSpeaking");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.976 -0400", hash_original_method = "1B011279D3385FBEA81C0EEE9DDE31E7", hash_generated_method = "32E83745FEA3B8EE20199D78E6B7AE51")
    public int stop() {
        int var2205B6250A5DC2D83B6B4FB979F5BE30_1409269175 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.975 -0400", hash_original_method = "C3E115845E07ACC22BB6BDAD6EAAC990", hash_generated_method = "72029BBCDE447B5D5ABB2C85863DF1B8")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_218742128 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_218742128 = service.stop(getPackageName());
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_218742128.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_218742128;
                // ---------- Original Method ----------
                //return service.stop(getPackageName());
            }
}, ERROR, "stop"));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585330212 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_585330212;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.stop(getPackageName());
            //}
        //}, ERROR, "stop");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.976 -0400", hash_original_method = "6950E84EE314E7032010233B0706B078", hash_generated_method = "23852045AA1D6E207A9F06DD37724612")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929490507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1929490507;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.977 -0400", hash_original_method = "7DADB23AB82E5180649E2697B1338160", hash_generated_method = "1A995EE12606605AB0D4F684E169F0F0")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706111000 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1706111000;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:31.977 -0400", hash_original_method = "6F277B1B16E884F81974EA73065A64D8", hash_generated_method = "E47CF325BDAA7EAB67B0604FAB2F1AEB")
    public String getCurrentEngine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1713094723 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1713094723 = mCurrentEngine;
        varB4EAC82CA7396A68D541C85D26508E83_1713094723.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1713094723;
        // ---------- Original Method ----------
        //return mCurrentEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.008 -0400", hash_original_method = "4B10A46E0E63D1391FC966E12E9B561D", hash_generated_method = "2C5DE96B0A98446B86BD04BBF0B6DC0A")
    public int setLanguage(final Locale loc) {
        int var463C3B5B751E3455AD47E55D9C8E0273_2016977041 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.008 -0400", hash_original_method = "0CBE42B90B008DE7C85EE0BE4FA8A569", hash_generated_method = "8011ABA85A63BABAF4FFC05C753EA89C")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_1502847210 = null; //Variable for return #1
                Integer varB4EAC82CA7396A68D541C85D26508E83_990500056 = null; //Variable for return #2
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1502847210 = LANG_NOT_SUPPORTED;
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
                varB4EAC82CA7396A68D541C85D26508E83_990500056 = result;
                addTaint(service.getTaint());
                Integer varA7E53CE21691AB073D9660D615818899_966795460; //Final return value
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: //Assign result for return ordinal #1
                        varA7E53CE21691AB073D9660D615818899_966795460 = varB4EAC82CA7396A68D541C85D26508E83_1502847210;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_966795460 = varB4EAC82CA7396A68D541C85D26508E83_990500056;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_966795460.addTaint(getTaint()); //Add taint from parent
                return varA7E53CE21691AB073D9660D615818899_966795460;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }
}, LANG_NOT_SUPPORTED, "setLanguage"));
        addTaint(loc.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219205849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1219205849;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.009 -0400", hash_original_method = "BC427E909E00C5BE5A5F111E336651C0", hash_generated_method = "002C5BAF7C8F969D145523151317636A")
    public Locale getLanguage() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_2085827687 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2085827687 = runAction(new Action<Locale>() {
            @Override
            public Locale run(ITextToSpeechService service) throws RemoteException {
                String[] locStrings = service.getLanguage();
                if (locStrings != null && locStrings.length == 3) {
                    return new Locale(locStrings[0], locStrings[1], locStrings[2]);
                }
                return null;
            }
        }, null, "getLanguage");
        varB4EAC82CA7396A68D541C85D26508E83_2085827687.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2085827687;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.023 -0400", hash_original_method = "4344244CB1F796DE537DEBF5170866A9", hash_generated_method = "44A16AA8E5D2F9EC2041BA40954297EF")
    public int isLanguageAvailable(final Locale loc) {
        int var8D52C44B3F856E1B6A599352828A3544_659204170 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.022 -0400", hash_original_method = "104F6D4E3824B9F3A36823FE96275A8A", hash_generated_method = "62996E40111F5D0CCB1EF0CF89A79497")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_402805363 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_402805363 = service.isLanguageAvailable(loc.getISO3Language(),
                        loc.getISO3Country(), loc.getVariant());
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_402805363.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_402805363;
                // ---------- Original Method ----------
                //return service.isLanguageAvailable(loc.getISO3Language(),
                        //loc.getISO3Country(), loc.getVariant());
            }
}, LANG_NOT_SUPPORTED, "isLanguageAvailable"));
        addTaint(loc.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526356368 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1526356368;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.isLanguageAvailable(loc.getISO3Language(),
                        //loc.getISO3Country(), loc.getVariant());
            //}
        //}, LANG_NOT_SUPPORTED, "isLanguageAvailable");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.024 -0400", hash_original_method = "59A7F0A106B55E8A59A4D44C2073C3C6", hash_generated_method = "1F149B8D31EED4B64970EEF7B715F827")
    public int synthesizeToFile(final String text, final HashMap<String, String> params,
            final String filename) {
        int var5017D31CBA903F9ED900B08B43192031_256352983 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.024 -0400", hash_original_method = "126F93B055F255BA3903970B4BD95F1E", hash_generated_method = "A93BDC2056D2DFEA11E25298DC29A7DA")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_1264179282 = null; //Variable for return #1
                varB4EAC82CA7396A68D541C85D26508E83_1264179282 = service.synthesizeToFile(getPackageName(), text, filename,
                        getParams(params));
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1264179282.addTaint(getTaint()); //Add taint from parent
                return varB4EAC82CA7396A68D541C85D26508E83_1264179282;
                // ---------- Original Method ----------
                //return service.synthesizeToFile(getPackageName(), text, filename,
                        //getParams(params));
            }
}, ERROR, "synthesizeToFile"));
        addTaint(text.getTaint());
        addTaint(params.getTaint());
        addTaint(filename.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273146881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1273146881;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.synthesizeToFile(getPackageName(), text, filename,
                        //getParams(params));
            //}
        //}, ERROR, "synthesizeToFile");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.192 -0400", hash_original_method = "F4A729CBEB92036D830EC51C9E6B27A9", hash_generated_method = "E1576C31FC38B9232A8141555AA759E8")
    private Bundle getParams(HashMap<String, String> params) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1923075629 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_2052622560 = null; //Variable for return #2
        {
            boolean var03F97DC16CD5D3704D59B126AFD4BB5D_621804476 = (params != null && !params.isEmpty());
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
                    boolean varDCACF1CEFE09ED31579385123C6A41F9_1914661669 = (!TextUtils.isEmpty(mCurrentEngine));
                    {
                        {
                            Iterator<Map.Entry<String, String>> varE9C4AC5EB9F7220631D2D77DC566F3A2_1832070053 = (params.entrySet()).iterator();
                            varE9C4AC5EB9F7220631D2D77DC566F3A2_1832070053.hasNext();
                            Map.Entry<String, String> entry = varE9C4AC5EB9F7220631D2D77DC566F3A2_1832070053.next();
                            {
                                String key;
                                key = entry.getKey();
                                {
                                    boolean var067B24247B41FD99A3F806EDF88D0891_1524422635 = (key != null && key.startsWith(mCurrentEngine));
                                    {
                                        bundle.putString(key, entry.getValue());
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1923075629 = bundle;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_2052622560 = mParams;
            } //End block
        } //End collapsed parenthetic
        addTaint(params.getTaint());
        Bundle varA7E53CE21691AB073D9660D615818899_105349041; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_105349041 = varB4EAC82CA7396A68D541C85D26508E83_1923075629;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_105349041 = varB4EAC82CA7396A68D541C85D26508E83_2052622560;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_105349041.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_105349041;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.193 -0400", hash_original_method = "CA756292003AA5F2AACD5FD8062D880F", hash_generated_method = "109398798ADEAF0B723B1AE6063B940B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.193 -0400", hash_original_method = "D148C993B4D17B611EC6A14A9B3B3D7B", hash_generated_method = "7DEF357290BB6D15E32881CFF70B17DE")
    private void copyIntParam(Bundle bundle, HashMap<String, String> params, String key) {
        String valueString;
        valueString = params.get(key);
        {
            boolean var7538D513B192AB3E879BF618E72A8D7E_1042729370 = (!TextUtils.isEmpty(valueString));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.194 -0400", hash_original_method = "335CA474B2AA628361250A653672DD72", hash_generated_method = "D57BE9895D3361908778177D13A95D31")
    private void copyFloatParam(Bundle bundle, HashMap<String, String> params, String key) {
        String valueString;
        valueString = params.get(key);
        {
            boolean var7538D513B192AB3E879BF618E72A8D7E_2117035864 = (!TextUtils.isEmpty(valueString));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.206 -0400", hash_original_method = "24D73865C05CC11CAA8C791D8BA56024", hash_generated_method = "D863708BD4C3B787DFD434CB819BECF5")
    @Deprecated
    public int setOnUtteranceCompletedListener(final OnUtteranceCompletedListener listener) {
        mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149175901 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149175901;
        // ---------- Original Method ----------
        //mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        //return TextToSpeech.SUCCESS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.206 -0400", hash_original_method = "98074E19965AB76BE23153F0217E2857", hash_generated_method = "DE57FE729AEFA1BA0FF35AF0AEBDB7AE")
    public int setOnUtteranceProgressListener(UtteranceProgressListener listener) {
        mUtteranceProgressListener = listener;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948530859 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1948530859;
        // ---------- Original Method ----------
        //mUtteranceProgressListener = listener;
        //return TextToSpeech.SUCCESS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.207 -0400", hash_original_method = "06FE1E6C6795B03B25AD43DFED268D92", hash_generated_method = "475EDA6AED39E107DC3BB32C1A19756F")
    @Deprecated
    public int setEngineByPackageName(String enginePackageName) {
        mRequestedEngine = enginePackageName;
        int var663EB57F9D9E552BC588A53FE17E210D_1294761010 = (initTts());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942746369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942746369;
        // ---------- Original Method ----------
        //mRequestedEngine = enginePackageName;
        //return initTts();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.234 -0400", hash_original_method = "AAA28EF74B57D47AEDCF93243FD04D81", hash_generated_method = "A195FE95748BC7BD218424054C9EF478")
    public String getDefaultEngine() {
        String varB4EAC82CA7396A68D541C85D26508E83_427145657 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_427145657 = mEnginesHelper.getDefaultEngine();
        varB4EAC82CA7396A68D541C85D26508E83_427145657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_427145657;
        // ---------- Original Method ----------
        //return mEnginesHelper.getDefaultEngine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.234 -0400", hash_original_method = "FDBC18F088428D1AA4FA407CF8A38EB5", hash_generated_method = "75F63D1940AC678D597C261C8211ED69")
    public boolean areDefaultsEnforced() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1471656187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1471656187;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.235 -0400", hash_original_method = "C282EF17EB1B4600865CB51DA0934709", hash_generated_method = "32F8A93B65077E2D473A3EE22BFDC56E")
    public List<EngineInfo> getEngines() {
        List<EngineInfo> varB4EAC82CA7396A68D541C85D26508E83_267168026 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_267168026 = mEnginesHelper.getEngines();
        varB4EAC82CA7396A68D541C85D26508E83_267168026.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_267168026;
        // ---------- Original Method ----------
        //return mEnginesHelper.getEngines();
    }

    
    public class Engine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.236 -0400", hash_original_method = "0CEE966FD083EAF9A38425EF355FEEF7", hash_generated_method = "0CEE966FD083EAF9A38425EF355FEEF7")
        public Engine ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.236 -0400", hash_original_field = "36D45D439A9D88F92C91EED7F227B118", hash_generated_field = "6EA685DC1F94714F1A1A1A053FC21028")

        public static final int DEFAULT_RATE = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.236 -0400", hash_original_field = "735042F181F97049F645A49551694C8F", hash_generated_field = "7265570D9BCE2101E8993107FABA1337")

        public static final int DEFAULT_PITCH = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.236 -0400", hash_original_field = "2CCE70ADE73106C43ECEE5E8A9205C7A", hash_generated_field = "95742929B161124D7ABDF4B245140DE7")

        public static final float DEFAULT_VOLUME = 1.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.236 -0400", hash_original_field = "1B7AB37CA837BE7D293E3424675F31F6", hash_generated_field = "BDDAA621A92D5CA41E24125645C10B9B")

        public static final float DEFAULT_PAN = 0.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.236 -0400", hash_original_field = "24C227C2F4C89803E4CC9D1CA4639012", hash_generated_field = "79A00612A369353FB0B563BBFBDD7A1F")

        public static final int USE_DEFAULTS = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.236 -0400", hash_original_field = "963BFD7556945F0ADCDB7063AA317405", hash_generated_field = "52D9AB195E713E24D836C4A49CC0D622")

        @Deprecated
        public static final String DEFAULT_ENGINE = "com.svox.pico";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.236 -0400", hash_original_field = "54C932376EBA54F9168634618A59869D", hash_generated_field = "C75C9F49D040B89D31A5EEE24181A5F2")

        public static final int DEFAULT_STREAM = AudioManager.STREAM_MUSIC;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.236 -0400", hash_original_field = "E08E1E62A1BA16AAB29D7A9A032DCA62", hash_generated_field = "C254DAAF5EBFA8002B27291ACC23702C")

        public static final int CHECK_VOICE_DATA_PASS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "EE2889DAB98E247108FD560D3EFB02FD", hash_generated_field = "E9C03161A9F0FFF5472A0040222D4C52")

        public static final int CHECK_VOICE_DATA_FAIL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "2DAAF7CA0FE4E57592622B27A82A704D", hash_generated_field = "431FD9B6D302AD606FFE065DF75DD2FA")

        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "CFC6EC4DDDF9F323DBC81D082171E33E", hash_generated_field = "7387564E7167154EEFED8705FCA0EED8")

        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "8D2D3E2E79C2C4E707239463D369E33B", hash_generated_field = "183E08CD13799093F5F5A44B05FDE73C")

        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "43EE5A08705D902AFADBFC04343199B2", hash_generated_field = "CAF4E59B3718CCEA9FF9E5188B9F6370")

        @SdkConstant(SdkConstantType.SERVICE_ACTION)
        public static final String INTENT_ACTION_TTS_SERVICE =
                "android.intent.action.TTS_SERVICE";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "E4042E25AFA9C947989DCC050E289401", hash_generated_field = "1838FC1E408F29335D36A08788A826E6")

        public static final String SERVICE_META_DATA = "android.speech.tts";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "A6833C0165AB755C6E068259E162C946", hash_generated_field = "AD45F25D873943976C37BF808E1956BE")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_INSTALL_TTS_DATA =
                "android.speech.tts.engine.INSTALL_TTS_DATA";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "D6AE8B393AF81687E39AF98587E4CABC", hash_generated_field = "A33F17727F43DBD7A47E893BB9B716B9")

        @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
        public static final String ACTION_TTS_DATA_INSTALLED =
                "android.speech.tts.engine.TTS_DATA_INSTALLED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "FA190AA53E599DBC899F53B55858698C", hash_generated_field = "43F20E850CE384CB5D9C74DD369FDD87")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_CHECK_TTS_DATA =
                "android.speech.tts.engine.CHECK_TTS_DATA";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "5C6C6397C49314D5F5E204CA1933345E", hash_generated_field = "58E16B540735E811A37625B0342CFA0F")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_GET_SAMPLE_TEXT =
                "android.speech.tts.engine.GET_SAMPLE_TEXT";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "9F649196082E67572C2349155C9919D2", hash_generated_field = "178CAFEE370EC9E79529912F27523F36")

        public static final String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "EFCBBB44D3D24A3D84E5ABC46FC70857", hash_generated_field = "2FCEBB35020F29546E39463BDD214A73")

        public static final String EXTRA_VOICE_DATA_FILES = "dataFiles";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "1DC90AA7734216663D84607F446D95B3", hash_generated_field = "23CB204D3DC0650A224FB5ABA98F25A7")

        public static final String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "FD4F2914F7FB71A96D2E879989B79136", hash_generated_field = "A5FF7832C171B046C21F825764FE8230")

        public static final String EXTRA_AVAILABLE_VOICES = "availableVoices";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "25CADBA271F43B9ED671E6822C5D1A88", hash_generated_field = "AC4770FDD8C95CC92539FC82143B39C5")

        public static final String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "C44D63A48B4EB093B375BC969B445992", hash_generated_field = "C8E0905A88A840D679AC2FF9508E3712")

        public static final String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.237 -0400", hash_original_field = "85A22E5221C66B5FEA03947CDBB2D9D0", hash_generated_field = "566A9FB915E742DB0D9FCBB9613D8A98")

        public static final String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "F36FF974081651AF068D67E5D4C4C65B", hash_generated_field = "9662C467B57A79462A5A958B925CD456")

        public static final String KEY_PARAM_RATE = "rate";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "A30E5701A5E3DB6B461EF4FA9632FED2", hash_generated_field = "41A112801807BF60F6B64B56EABC75A7")

        public static final String KEY_PARAM_LANGUAGE = "language";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "049E0A857DB03C5705F89387DBFA3F94", hash_generated_field = "B9529957E3604F14146602846E9977A5")

        public static final String KEY_PARAM_COUNTRY = "country";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "5DD9CAE974E3E4DF07273B713C0141E3", hash_generated_field = "194C150941509AFA9F06806544278558")

        public static final String KEY_PARAM_VARIANT = "variant";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "4BF977BE522A7D4FAECCE001402B4B22", hash_generated_field = "5790995E2173B750C19C7F0DF730BD18")

        public static final String KEY_PARAM_ENGINE = "engine";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "8EFCD27051CF12277949A1C6787CF4CA", hash_generated_field = "3BDB1A8EA9944800172EB2E01D630D39")

        public static final String KEY_PARAM_PITCH = "pitch";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "82BD90E3DC3CCF8584C41564CAE4AAB5", hash_generated_field = "AA44CC9D49E0D6103F2E361CC4DC18B0")

        public static final String KEY_PARAM_STREAM = "streamType";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "1A45AC9684F0F72F5EB630E624D8FB7C", hash_generated_field = "D01CCD0CAFBD7B77262BEE4DF757451B")

        public static final String KEY_PARAM_UTTERANCE_ID = "utteranceId";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "EB555D6AB84BF7E41BAC2B5D53A5F9B2", hash_generated_field = "F31741CDDA9583A05DBFC466602DB856")

        public static final String KEY_PARAM_VOLUME = "volume";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "5C37A91E922F1CA033CF81267F80980E", hash_generated_field = "5C33025FF7CAEFB03AF35CC41A77E51F")

        public static final String KEY_PARAM_PAN = "pan";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "B9B59CA107B4998520D8F04E86304BB9", hash_generated_field = "9C632C8E548D61E23BCBF91A78385C5A")

        public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.238 -0400", hash_original_field = "5D6A2E8BAB4CD47E940B987CF3C63014", hash_generated_field = "367B7447EF0E1BB5CDEB71ED7EF27786")

        public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    }


    
    private class Connection implements ServiceConnection {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.256 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "D3C3F8FD9BA670292396CDDDD2DBC0CC")

        private ITextToSpeechService mService;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.258 -0400", hash_original_field = "E1D8F791D3BB3666B7074B1777047AD0", hash_generated_field = "6EA19E29AA6676CA1F51B21042B4AA97")

        private ITextToSpeechCallback.Stub mCallback = new ITextToSpeechCallback.Stub() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.257 -0400", hash_original_method = "5A69319C8BD2B805ED99ED76716CFEEE", hash_generated_method = "77FAF422931FDA5832200B836CFC99B0")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.258 -0400", hash_original_method = "71BFFA04ED8551E163779942DCEAA326", hash_generated_method = "4512F4857A045800C3D1AF83F334076A")
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

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.258 -0400", hash_original_method = "AC6831F715B5A1560C1EB20081DD1B2E", hash_generated_method = "3D1CEB6C91B05D2DC1A5F2F6BAB0ACC6")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.271 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
        public Connection ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.272 -0400", hash_original_method = "E38F495B4498EDF08C66FB9F592C4572", hash_generated_method = "13D0F2DA18AB79324430B218EDA72263")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.273 -0400", hash_original_method = "9CBB724FFDF56C58A2F363CBB7ADEB66", hash_generated_method = "15A98A2FE946EA4E033F8F688963C2D8")
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                mService = null;
                {
                    boolean varCFBB343190D0053DBC4029F6CA0B9372_1777531207 = (mServiceConnection == this);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.282 -0400", hash_original_method = "670DB56217535BA78AC55188B9013676", hash_generated_method = "22BDFB36185642ED4E82BED8A6D53D5B")
        public void disconnect() {
            mContext.unbindService(this);
            // ---------- Original Method ----------
            //mContext.unbindService(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.284 -0400", hash_original_method = "34464E55B5499CA206CC99D3045C1292", hash_generated_method = "A1921505E3CBF14FC0B306CF819913FF")
        public <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
            R varB4EAC82CA7396A68D541C85D26508E83_464838881 = null; //Variable for return #1
            R varB4EAC82CA7396A68D541C85D26508E83_631348115 = null; //Variable for return #2
            R varB4EAC82CA7396A68D541C85D26508E83_1745911545 = null; //Variable for return #3
            try 
            {
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_464838881 = errorResult;
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_631348115 = action.run(mService);
                } //End block
            } //End block
            catch (RemoteException ex)
            {
                {
                    disconnect();
                    initTts();
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_1745911545 = errorResult;
            } //End block
            addTaint(action.getTaint());
            addTaint(errorResult.getTaint());
            addTaint(method.getTaint());
            addTaint(reconnect);
            R varA7E53CE21691AB073D9660D615818899_1852891223; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1852891223 = varB4EAC82CA7396A68D541C85D26508E83_464838881;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1852891223 = varB4EAC82CA7396A68D541C85D26508E83_631348115;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1852891223 = varB4EAC82CA7396A68D541C85D26508E83_1745911545;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1852891223.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1852891223;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.284 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.284 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "B1C3A1439C6538148E2C8C0A71DA201D")

        public String label;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.284 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.284 -0400", hash_original_field = "54B53072540EEEB8F8E9343E71F28176", hash_generated_field = "D1DBA00001B7F415431AD6FCAB5BAA5D")

        public boolean system;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.284 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

        public int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.293 -0400", hash_original_method = "1BD677F38EE0D51841725F2C2D5029FA", hash_generated_method = "1BD677F38EE0D51841725F2C2D5029FA")
        public EngineInfo ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.294 -0400", hash_original_method = "2BF343FE966C95427B565E993C403E36", hash_generated_method = "54C89F894481B2D9E0CB86948B647BCE")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_2124571358 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_2124571358 = "EngineInfo{name=" + name + "}";
            varB4EAC82CA7396A68D541C85D26508E83_2124571358.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2124571358;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.294 -0400", hash_original_field = "DF41A127C133B054D95ADD91C88170F4", hash_generated_field = "0DC1DBFECA0D70FFFE44CCB13E744EFC")

    private static String TAG = "TextToSpeech";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.294 -0400", hash_original_field = "C8AE4103156B65C0D23556A48DB4D815", hash_generated_field = "9B986A2CF4CE0B3870A44EA118A88E9A")

    public static final int SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.294 -0400", hash_original_field = "5DDED9E5103DBD4703C0660F86E0B86E", hash_generated_field = "D9FDA3C0E4B8421EF0ECF23EDE3289A4")

    public static final int ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.294 -0400", hash_original_field = "95588520F32581BA8D1244F13101ED06", hash_generated_field = "02E0C42BFDC9472143A2816BE6A46302")

    public static final int QUEUE_FLUSH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.294 -0400", hash_original_field = "E3380CB05B87800713541EA7B6C5393B", hash_generated_field = "E3D905B07D88D805D26B80E9C9543333")

    public static final int QUEUE_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.294 -0400", hash_original_field = "7B7F3B3D69B07673CD2E7AAF005CBF5F", hash_generated_field = "966838726B4A9B6303183A4F3EDD9D23")

    static int QUEUE_DESTROY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.295 -0400", hash_original_field = "DFAFB9213D04FA47F5A5F2A4B74F14B3", hash_generated_field = "114C4BE7840CE5276181D4AD399DD60A")

    public static final int LANG_COUNTRY_VAR_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.295 -0400", hash_original_field = "5FA467857132F3FB084FACD4877020EB", hash_generated_field = "615AF214DE081692194C09BC057B78F6")

    public static final int LANG_COUNTRY_AVAILABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.295 -0400", hash_original_field = "E8D8099546226BEB455FFD46312483E0", hash_generated_field = "D0C3004A60A5D721A3D561D3F15B8744")

    public static final int LANG_AVAILABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.295 -0400", hash_original_field = "728E1D2145BB05D62DE4ABA628047B9D", hash_generated_field = "811988C198657A72F3A46F0269AEEEC3")

    public static final int LANG_MISSING_DATA = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.295 -0400", hash_original_field = "E4F8C9D14EBD840CD3FB4037BAF176AF", hash_generated_field = "D282ACE529F1D4C71E5D1D903CE29D28")

    public static final int LANG_NOT_SUPPORTED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:32.295 -0400", hash_original_field = "7D2E96656AB2A31B8BC2DBA52B97A09F", hash_generated_field = "1613EE279914B2EEC593ED6D5A8EDA25")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED =
            "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
}

