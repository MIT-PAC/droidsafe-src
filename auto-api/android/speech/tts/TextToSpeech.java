package android.speech.tts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "94CA83B0A5EF3662095068A2D93D4E51", hash_generated_field = "46824CCAF8D8A297954B79F68288C27C")

    private Connection mServiceConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "BD66CA08574E567F4A2FF02EAF3A3C43", hash_generated_field = "9260ADD518F0FEF38A450F7DB53206FF")

    private OnInitListener mInitListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "FCC9BC767DCFBBDC0E992E8F8F631777", hash_generated_field = "328E3D7B680D2F02E50F03A1B91A5C91")

    private volatile UtteranceProgressListener mUtteranceProgressListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "A566AAD21AECEFD87B9A641763F0E8ED", hash_generated_field = "A8116CC7E9FFC22E32CD58F7221C57D1")

    private final Object mStartLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "79A963EB2FE6CF7ED985A37C9C2DAFC8", hash_generated_field = "87C8AA46082F357B5A90BEFDCD55A9CA")

    private String mRequestedEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "4FBF9E2CF0458E920CECA1122F7CE66F", hash_generated_field = "F6B4C1579EC35D212C4AF2EE4A947247")

    private Map<String, Uri> mEarcons;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "DADCFF0BCD3190EF5EA5DAA385F05AFC", hash_generated_field = "AF9F14E0A7A7BBE0D15082F4D775A15F")

    private Map<String, Uri> mUtterances;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "2E7257A953F47313410ACCB399EF186C", hash_generated_field = "0509EAD5E22611839DB01FDA008360EE")

    private final Bundle mParams = new Bundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "3D23233AD3766EA5A08A04C38A75975D", hash_generated_field = "C4FA3CBED7ED304B229BB483017A66E9")

    private TtsEngines mEnginesHelper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_field = "D10648D448DDFF74BD81B300412AA0DA", hash_generated_field = "8E5DC033BD559466A27E8B7E16939D55")

    private volatile String mCurrentEngine = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.311 -0400", hash_original_method = "E5C095C9A34533EB222D42D1A6D92941", hash_generated_method = "5EBF6E91AC53E9A8A9B0A253EEC90A14")
    public  TextToSpeech(Context context, OnInitListener listener) {
        this(context, listener, null);
        addTaint(context.getTaint());
        addTaint(listener.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.312 -0400", hash_original_method = "894D965EFAB67E7E0E3D1E11B990F0FA", hash_generated_method = "9DB3A3DA3B73688B98CF2FBCD7304F9A")
    public  TextToSpeech(Context context, OnInitListener listener, String engine) {
        this(context, listener, engine, null);
        addTaint(context.getTaint());
        addTaint(listener.getTaint());
        addTaint(engine.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.312 -0400", hash_original_method = "0584A597F5F20737FDED0391417BF29B", hash_generated_method = "B4006DE63FF57B393B290520D5ED86F0")
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
        } 
        {
            mPackageName = mContext.getPackageName();
        } 
        initTts();
        
        
        
        
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.313 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "9D634CFE6F2CF4F7922198DF74498369")
    private String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_141016466 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_141016466 = mPackageName;
        varB4EAC82CA7396A68D541C85D26508E83_141016466.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_141016466;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.313 -0400", hash_original_method = "94C951553FBC2F5928AD7C3B02D8E2C9", hash_generated_method = "F25DA37FE3E692AA6E658CD0B703B881")
    private <R> R runActionNoReconnect(Action<R> action, R errorResult, String method) {
        R varB4EAC82CA7396A68D541C85D26508E83_575070136 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_575070136 = runAction(action, errorResult, method, false);
        addTaint(action.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_575070136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_575070136;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.315 -0400", hash_original_method = "29E7B310AE240E4C21F0167C8B8476FB", hash_generated_method = "3852F274F8960EA616679E4E9F1662D6")
    private <R> R runAction(Action<R> action, R errorResult, String method) {
        R varB4EAC82CA7396A68D541C85D26508E83_1268742917 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1268742917 = runAction(action, errorResult, method, true);
        addTaint(action.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(method.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1268742917.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1268742917;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.316 -0400", hash_original_method = "6EC1A4E0A67965882D9F244E76909BAE", hash_generated_method = "AC62ACC423E04D9A4BF5419C83E84FD0")
    private <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
        R varB4EAC82CA7396A68D541C85D26508E83_1677271070 = null; 
        R varB4EAC82CA7396A68D541C85D26508E83_2124435936 = null; 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1677271070 = errorResult;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2124435936 = mServiceConnection.runAction(action, errorResult, method, reconnect);
        } 
        addTaint(action.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(method.getTaint());
        addTaint(reconnect);
        R varA7E53CE21691AB073D9660D615818899_639931858; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_639931858 = varB4EAC82CA7396A68D541C85D26508E83_1677271070;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_639931858 = varB4EAC82CA7396A68D541C85D26508E83_2124435936;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_639931858.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_639931858;
        
        
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.316 -0400", hash_original_method = "001A57975E2E50499F283478CA48737A", hash_generated_method = "6F06DA2448AC74A529EB40E8F98956F4")
    private int initTts() {
        {
            boolean varC76336549734AD44BDCB678BF01D59F2_1273566478 = (mRequestedEngine != null && mEnginesHelper.isEngineInstalled(mRequestedEngine));
            {
                {
                    boolean var8911BEC7CCD0FB9FC7E4675F4D27106A_984440426 = (connectToEngine(mRequestedEngine));
                    {
                        mCurrentEngine = mRequestedEngine;
                    } 
                } 
            } 
        } 
        final String defaultEngine = getDefaultEngine();
        {
            boolean varABC6D22B8FBEAE604936A23D49D6DDD0_1372492783 = (defaultEngine != null && !defaultEngine.equals(mRequestedEngine));
            {
                {
                    boolean var7836D76553A5F05531279189C3A7B50A_1507092604 = (connectToEngine(defaultEngine));
                    {
                        mCurrentEngine = defaultEngine;
                    } 
                } 
            } 
        } 
        final String highestRanked = mEnginesHelper.getHighestRankedEngineName();
        {
            boolean var1A9867EA58712819C70FBE667FD48C74_1537125316 = (highestRanked != null && !highestRanked.equals(mRequestedEngine) &&
                !highestRanked.equals(defaultEngine));
            {
                {
                    boolean varB08B03620CB751C6F0BCA99823142EEF_1416998448 = (connectToEngine(highestRanked));
                    {
                        mCurrentEngine = highestRanked;
                    } 
                } 
            } 
        } 
        mCurrentEngine = null;
        dispatchOnInit(ERROR);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975614373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1975614373;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.317 -0400", hash_original_method = "5177E4BA973A00FB9C33DC0A5DBEACDB", hash_generated_method = "E091ABC2169A9294156E57D9562F2E7D")
    private boolean connectToEngine(String engine) {
        Connection connection = new Connection();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        boolean bound = mContext.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        addTaint(engine.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_212625283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_212625283;
        
        
        
        
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.317 -0400", hash_original_method = "16B0CCB3D7329F5127962CE558D4D17C", hash_generated_method = "7C813A8608A399BC59BEDAAF103A163A")
    private void dispatchOnInit(int result) {
        {
            {
                mInitListener.onInit(result);
                mInitListener = null;
            } 
        } 
        addTaint(result);
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.319 -0400", hash_original_method = "EAB786CB351424B1FA3879678813021A", hash_generated_method = "E737A68D9CD61756DA361DBE4632CA34")
    public void shutdown() {
        runActionNoReconnect(new Action<Void>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.318 -0400", hash_original_method = "1C176575622D770489EE559F23BB4FED", hash_generated_method = "3707B31C6B25768BCF79A76F427DDA48")
            @Override
            public Void run(ITextToSpeechService service) throws RemoteException {
                Void varB4EAC82CA7396A68D541C85D26508E83_1476847515 = null; 
                service.setCallback(getPackageName(), null);
                service.stop(getPackageName());
                mServiceConnection.disconnect();
                mServiceConnection = null;
                mCurrentEngine = null;
                varB4EAC82CA7396A68D541C85D26508E83_1476847515 = null;
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1476847515.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1476847515;
                
                
                
                
                
                
                
            }
}, null, "shutdown");
        
        
            
            
                
                
                
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.319 -0400", hash_original_method = "DD10D1EA0D37E9C3175CB1CE81EACE27", hash_generated_method = "644CB73161A75EECA94F9D5C22FF7303")
    public int addSpeech(String text, String packagename, int resourceId) {
        {
            mUtterances.put(text, makeResourceUri(packagename, resourceId));
        } 
        addTaint(text.getTaint());
        addTaint(packagename.getTaint());
        addTaint(resourceId);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913189626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_913189626;
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.319 -0400", hash_original_method = "DBC13E8086F9460080E153D9CAE05A02", hash_generated_method = "202E5B7E98DD0B61BDB8F63E8CCADB0D")
    public int addSpeech(String text, String filename) {
        {
            mUtterances.put(text, Uri.parse(filename));
        } 
        addTaint(text.getTaint());
        addTaint(filename.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888215056 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1888215056;
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.320 -0400", hash_original_method = "773577F8E212F06A89510B07A5731283", hash_generated_method = "611F2C38167EBA138C3E24E2A9541118")
    public int addEarcon(String earcon, String packagename, int resourceId) {
        {
            mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
        } 
        addTaint(earcon.getTaint());
        addTaint(packagename.getTaint());
        addTaint(resourceId);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993163488 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1993163488;
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.320 -0400", hash_original_method = "409D0B7C115347E1FFF71FD2BD1F314E", hash_generated_method = "487A59B90C1B2887CB5B3F65D21D0DE8")
    public int addEarcon(String earcon, String filename) {
        {
            mEarcons.put(earcon, Uri.parse(filename));
        } 
        addTaint(earcon.getTaint());
        addTaint(filename.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833495783 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1833495783;
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.321 -0400", hash_original_method = "276BC175828DCE484EB0703A6A0D8E9B", hash_generated_method = "9C6B8397935C9DE309AFC40AC1B5BC3E")
    private Uri makeResourceUri(String packageName, int resourceId) {
        Uri varB4EAC82CA7396A68D541C85D26508E83_1914109783 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1914109783 = new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .encodedAuthority(packageName)
                .appendEncodedPath(String.valueOf(resourceId))
                .build();
        addTaint(packageName.getTaint());
        addTaint(resourceId);
        varB4EAC82CA7396A68D541C85D26508E83_1914109783.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1914109783;
        
        
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.322 -0400", hash_original_method = "BE0E5C2CBBCD37525836C6DA289D2EEC", hash_generated_method = "55147D92CA95219EFB6AD63860DA03B6")
    public int speak(final String text, final int queueMode, final HashMap<String, String> params) {
        int varC50091A1AD920BA8EEDF382E9798C6F6_1268989541 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.322 -0400", hash_original_method = "7D06D49EA86F29A3C163217832E59726", hash_generated_method = "3AD389A712BBEC56224914A62756A00B")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_135905057 = null; 
                Integer varB4EAC82CA7396A68D541C85D26508E83_1213036560 = null; 
                Uri utteranceUri = mUtterances.get(text);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_135905057 = service.playAudio(getPackageName(), utteranceUri, queueMode,
                            getParams(params));
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1213036560 = service.speak(getPackageName(), text, queueMode, getParams(params));
                } 
                addTaint(service.getTaint());
                Integer varA7E53CE21691AB073D9660D615818899_607284139; 
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: 
                        varA7E53CE21691AB073D9660D615818899_607284139 = varB4EAC82CA7396A68D541C85D26508E83_135905057;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_607284139 = varB4EAC82CA7396A68D541C85D26508E83_1213036560;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_607284139.addTaint(getTaint()); 
                return varA7E53CE21691AB073D9660D615818899_607284139;
                
                
                
                    
                            
                
                    
                
            }
}, ERROR, "speak"));
        addTaint(text.getTaint());
        addTaint(queueMode);
        addTaint(params.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609154447 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1609154447;
        
        
            
            
                
                
                    
                            
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.324 -0400", hash_original_method = "F18AB3CD06A1E20DE6BD7099833B6FEC", hash_generated_method = "66DE9D8765A045D5770BEF3AE870DE4A")
    public int playEarcon(final String earcon, final int queueMode,
            final HashMap<String, String> params) {
        int varC07B76A6629AEEAAE145D306E0367E15_843229576 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.324 -0400", hash_original_method = "6A26B14D42F3FBBE45C132D11F693742", hash_generated_method = "9675BBD37D3352281621F0A864DF4E6B")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_1259276719 = null; 
                Integer varB4EAC82CA7396A68D541C85D26508E83_1457684292 = null; 
                Uri earconUri = mEarcons.get(earcon);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1259276719 = ERROR;
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1457684292 = service.playAudio(getPackageName(), earconUri, queueMode,
                        getParams(params));
                addTaint(service.getTaint());
                Integer varA7E53CE21691AB073D9660D615818899_2012622944; 
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: 
                        varA7E53CE21691AB073D9660D615818899_2012622944 = varB4EAC82CA7396A68D541C85D26508E83_1259276719;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_2012622944 = varB4EAC82CA7396A68D541C85D26508E83_1457684292;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_2012622944.addTaint(getTaint()); 
                return varA7E53CE21691AB073D9660D615818899_2012622944;
                
                
                
                    
                
                
                        
            }
}, ERROR, "playEarcon"));
        addTaint(earcon.getTaint());
        addTaint(queueMode);
        addTaint(params.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_237032863 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_237032863;
        
        
            
            
                
                
                    
                
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.327 -0400", hash_original_method = "94C759FE8B677E32982F42F6A676D86E", hash_generated_method = "D7007945B97C06B22BE728487077BC88")
    public int playSilence(final long durationInMs, final int queueMode,
            final HashMap<String, String> params) {
        int var6FA66AA0D66D2659772BDCCA9439E9DC_2028481148 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.327 -0400", hash_original_method = "78C333BA11B47CA10C93733938393F3E", hash_generated_method = "758A6E54F6EFE9209914219AFADD2F54")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_212766505 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_212766505 = service.playSilence(getPackageName(), durationInMs, queueMode,
                        getParams(params));
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_212766505.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_212766505;
                
                
                        
            }
}, ERROR, "playSilence"));
        addTaint(durationInMs);
        addTaint(queueMode);
        addTaint(params.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225202138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1225202138;
        
        
            
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.328 -0400", hash_original_method = "8AF2E385B6F026EB817E9FE98AB99B1D", hash_generated_method = "4F2F00B170472DAA974E1FF99236AFED")
    public Set<String> getFeatures(final Locale locale) {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1797231943 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1797231943 = runAction(new Action<Set<String>>() {
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
        varB4EAC82CA7396A68D541C85D26508E83_1797231943.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1797231943;
        
        
            
            
                
                        
                
                    
                    
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.330 -0400", hash_original_method = "DC605D9F82407CF596B06CFECEFBD8A5", hash_generated_method = "69B4FC158427EB3B56E01A42CDCC772F")
    public boolean isSpeaking() {
        boolean var39656775AD803E56E754335B5D700191_2039020394 = (runAction(new Action<Boolean>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.330 -0400", hash_original_method = "CDD6871E0A3D820171A5453DF320B8D3", hash_generated_method = "F935DF240B0BEB6DE181CF798618BE0F")
            @Override
            public Boolean run(ITextToSpeechService service) throws RemoteException {
                Boolean varB4EAC82CA7396A68D541C85D26508E83_1053986013 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1053986013 = service.isSpeaking();
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1053986013.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1053986013;
                
                
            }
}, false, "isSpeaking"));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_668717342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_668717342;
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.331 -0400", hash_original_method = "1B011279D3385FBEA81C0EEE9DDE31E7", hash_generated_method = "9B1709742AA12AA3A7BC074F08C6F90D")
    public int stop() {
        int varF7F77D332473026FB894BAE8DD0200F1_432320881 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.331 -0400", hash_original_method = "C3E115845E07ACC22BB6BDAD6EAAC990", hash_generated_method = "B507341D53F04445058F8E324966E9CA")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_1237063871 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1237063871 = service.stop(getPackageName());
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1237063871.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1237063871;
                
                
            }
}, ERROR, "stop"));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295819806 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1295819806;
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.331 -0400", hash_original_method = "6950E84EE314E7032010233B0706B078", hash_generated_method = "97EF31DFB4ECAE6AD192818D2FB4F9F1")
    public int setSpeechRate(float speechRate) {
        {
            int intRate = (int)(speechRate * 100);
            {
                {
                    mParams.putInt(Engine.KEY_PARAM_RATE, intRate);
                } 
            } 
        } 
        addTaint(speechRate);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208216519 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1208216519;
        
        
            
            
                
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.332 -0400", hash_original_method = "7DADB23AB82E5180649E2697B1338160", hash_generated_method = "92321A591857B2405743D0B0FE4679C0")
    public int setPitch(float pitch) {
        {
            int intPitch = (int)(pitch * 100);
            {
                {
                    mParams.putInt(Engine.KEY_PARAM_PITCH, intPitch);
                } 
            } 
        } 
        addTaint(pitch);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388453716 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_388453716;
        
        
            
            
                
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.332 -0400", hash_original_method = "6F277B1B16E884F81974EA73065A64D8", hash_generated_method = "D45B9199FE5A820B40DA5B7DF2C6638A")
    public String getCurrentEngine() {
        String varB4EAC82CA7396A68D541C85D26508E83_2119437381 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2119437381 = mCurrentEngine;
        varB4EAC82CA7396A68D541C85D26508E83_2119437381.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2119437381;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.334 -0400", hash_original_method = "4B10A46E0E63D1391FC966E12E9B561D", hash_generated_method = "1371D331D469CA5FF34C7ACFEDFA2B10")
    public int setLanguage(final Locale loc) {
        int varC880053095706C95BA3BD199E6D6C943_1692705091 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.334 -0400", hash_original_method = "0CBE42B90B008DE7C85EE0BE4FA8A569", hash_generated_method = "64D547EE3063345229DE27F1AB2ED2FC")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_637427362 = null; 
                Integer varB4EAC82CA7396A68D541C85D26508E83_14487278 = null; 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_637427362 = LANG_NOT_SUPPORTED;
                } 
                String language = loc.getISO3Language();
                String country = loc.getISO3Country();
                String variant = loc.getVariant();
                int result = service.loadLanguage(language, country, variant);
                {
                    {
                        variant = "";
                        {
                            country = "";
                        } 
                    } 
                    mParams.putString(Engine.KEY_PARAM_LANGUAGE, language);
                    mParams.putString(Engine.KEY_PARAM_COUNTRY, country);
                    mParams.putString(Engine.KEY_PARAM_VARIANT, variant);
                } 
                varB4EAC82CA7396A68D541C85D26508E83_14487278 = result;
                addTaint(service.getTaint());
                Integer varA7E53CE21691AB073D9660D615818899_1277912088; 
                switch (DroidSafeAndroidRuntime.switchControl) {
                    case 1: 
                        varA7E53CE21691AB073D9660D615818899_1277912088 = varB4EAC82CA7396A68D541C85D26508E83_637427362;
                        break;
                    default:
                        varA7E53CE21691AB073D9660D615818899_1277912088 = varB4EAC82CA7396A68D541C85D26508E83_14487278;
                        break;
                }
                varA7E53CE21691AB073D9660D615818899_1277912088.addTaint(getTaint()); 
                return varA7E53CE21691AB073D9660D615818899_1277912088;
                
                
            }
}, LANG_NOT_SUPPORTED, "setLanguage"));
        addTaint(loc.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394467290 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1394467290;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.335 -0400", hash_original_method = "BC427E909E00C5BE5A5F111E336651C0", hash_generated_method = "E51EC6FF2CF54CBA78496673FA9D035F")
    public Locale getLanguage() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_1815210533 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1815210533 = runAction(new Action<Locale>() {
            @Override
            public Locale run(ITextToSpeechService service) throws RemoteException {
                String[] locStrings = service.getLanguage();
                if (locStrings != null && locStrings.length == 3) {
                    return new Locale(locStrings[0], locStrings[1], locStrings[2]);
                }
                return null;
            }
        }, null, "getLanguage");
        varB4EAC82CA7396A68D541C85D26508E83_1815210533.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1815210533;
        
        
            
            
                
                
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.337 -0400", hash_original_method = "4344244CB1F796DE537DEBF5170866A9", hash_generated_method = "64E54A2D80B0586895E8396F3B299740")
    public int isLanguageAvailable(final Locale loc) {
        int varA16EA7B6A1DB6CA61AEE1507AB555BA7_76007248 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.337 -0400", hash_original_method = "104F6D4E3824B9F3A36823FE96275A8A", hash_generated_method = "A39A7E07D4EA1556CE5BBEAEC3417B0A")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_1704765782 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1704765782 = service.isLanguageAvailable(loc.getISO3Language(),
                        loc.getISO3Country(), loc.getVariant());
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1704765782.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1704765782;
                
                
                        
            }
}, LANG_NOT_SUPPORTED, "isLanguageAvailable"));
        addTaint(loc.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532017188 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_532017188;
        
        
            
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.339 -0400", hash_original_method = "59A7F0A106B55E8A59A4D44C2073C3C6", hash_generated_method = "529918276DECC8D1336468D4D1D5E46E")
    public int synthesizeToFile(final String text, final HashMap<String, String> params,
            final String filename) {
        int varF511082C7DC7489345AD35697E1C2511_942430946 = (runAction(new Action<Integer>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.339 -0400", hash_original_method = "126F93B055F255BA3903970B4BD95F1E", hash_generated_method = "103F44F380AFBDA83D3E81F035FED799")
            @Override
            public Integer run(ITextToSpeechService service) throws RemoteException {
                Integer varB4EAC82CA7396A68D541C85D26508E83_1905757266 = null; 
                varB4EAC82CA7396A68D541C85D26508E83_1905757266 = service.synthesizeToFile(getPackageName(), text, filename,
                        getParams(params));
                addTaint(service.getTaint());
                varB4EAC82CA7396A68D541C85D26508E83_1905757266.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_1905757266;
                
                
                        
            }
}, ERROR, "synthesizeToFile"));
        addTaint(text.getTaint());
        addTaint(params.getTaint());
        addTaint(filename.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_178129527 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_178129527;
        
        
            
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.348 -0400", hash_original_method = "F4A729CBEB92036D830EC51C9E6B27A9", hash_generated_method = "4D672F23CCCD766BF71E3CD066A9059F")
    private Bundle getParams(HashMap<String, String> params) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_529486515 = null; 
        Bundle varB4EAC82CA7396A68D541C85D26508E83_186515875 = null; 
        {
            boolean var03F97DC16CD5D3704D59B126AFD4BB5D_40117357 = (params != null && !params.isEmpty());
            {
                Bundle bundle = new Bundle(mParams);
                copyIntParam(bundle, params, Engine.KEY_PARAM_STREAM);
                copyStringParam(bundle, params, Engine.KEY_PARAM_UTTERANCE_ID);
                copyFloatParam(bundle, params, Engine.KEY_PARAM_VOLUME);
                copyFloatParam(bundle, params, Engine.KEY_PARAM_PAN);
                copyStringParam(bundle, params, Engine.KEY_FEATURE_NETWORK_SYNTHESIS);
                copyStringParam(bundle, params, Engine.KEY_FEATURE_EMBEDDED_SYNTHESIS);
                {
                    boolean varDCACF1CEFE09ED31579385123C6A41F9_563685262 = (!TextUtils.isEmpty(mCurrentEngine));
                    {
                        {
                            Iterator<Map.Entry<String, String>> varE9C4AC5EB9F7220631D2D77DC566F3A2_374071550 = (params.entrySet()).iterator();
                            varE9C4AC5EB9F7220631D2D77DC566F3A2_374071550.hasNext();
                            Map.Entry<String, String> entry = varE9C4AC5EB9F7220631D2D77DC566F3A2_374071550.next();
                            {
                                final String key = entry.getKey();
                                {
                                    boolean var067B24247B41FD99A3F806EDF88D0891_1648689040 = (key != null && key.startsWith(mCurrentEngine));
                                    {
                                        bundle.putString(key, entry.getValue());
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_529486515 = bundle;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_186515875 = mParams;
            } 
        } 
        addTaint(params.getTaint());
        Bundle varA7E53CE21691AB073D9660D615818899_1935422296; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1935422296 = varB4EAC82CA7396A68D541C85D26508E83_529486515;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1935422296 = varB4EAC82CA7396A68D541C85D26508E83_186515875;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1935422296.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1935422296;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.349 -0400", hash_original_method = "CA756292003AA5F2AACD5FD8062D880F", hash_generated_method = "6F19BF20D504CDA3FACF0271E7DB8B39")
    private void copyStringParam(Bundle bundle, HashMap<String, String> params, String key) {
        String value = params.get(key);
        {
            bundle.putString(key, value);
        } 
        addTaint(bundle.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.349 -0400", hash_original_method = "D148C993B4D17B611EC6A14A9B3B3D7B", hash_generated_method = "AA30650DFB5B4357429B307AA4D56E12")
    private void copyIntParam(Bundle bundle, HashMap<String, String> params, String key) {
        String valueString = params.get(key);
        {
            boolean var7538D513B192AB3E879BF618E72A8D7E_569751373 = (!TextUtils.isEmpty(valueString));
            {
                try 
                {
                    int value = Integer.parseInt(valueString);
                    bundle.putInt(key, value);
                } 
                catch (NumberFormatException ex)
                { }
            } 
        } 
        addTaint(bundle.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        
        
        
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.350 -0400", hash_original_method = "335CA474B2AA628361250A653672DD72", hash_generated_method = "6BFE45B126CB487642EBE0B420F8654E")
    private void copyFloatParam(Bundle bundle, HashMap<String, String> params, String key) {
        String valueString = params.get(key);
        {
            boolean var7538D513B192AB3E879BF618E72A8D7E_1790127232 = (!TextUtils.isEmpty(valueString));
            {
                try 
                {
                    float value = Float.parseFloat(valueString);
                    bundle.putFloat(key, value);
                } 
                catch (NumberFormatException ex)
                { }
            } 
        } 
        addTaint(bundle.getTaint());
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        
        
        
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.351 -0400", hash_original_method = "24D73865C05CC11CAA8C791D8BA56024", hash_generated_method = "DE2D94254FC1170FD1ECB5B685F4541D")
    @Deprecated
    public int setOnUtteranceCompletedListener(final OnUtteranceCompletedListener listener) {
        mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000486717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1000486717;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.351 -0400", hash_original_method = "98074E19965AB76BE23153F0217E2857", hash_generated_method = "E49C694EDAA32A66421B5D8B070F7DDD")
    public int setOnUtteranceProgressListener(UtteranceProgressListener listener) {
        mUtteranceProgressListener = listener;
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028335097 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028335097;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.352 -0400", hash_original_method = "06FE1E6C6795B03B25AD43DFED268D92", hash_generated_method = "E926145EEF5952F1517C33601A9B7A97")
    @Deprecated
    public int setEngineByPackageName(String enginePackageName) {
        mRequestedEngine = enginePackageName;
        int var663EB57F9D9E552BC588A53FE17E210D_733586770 = (initTts());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565336072 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1565336072;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.353 -0400", hash_original_method = "AAA28EF74B57D47AEDCF93243FD04D81", hash_generated_method = "93C474896439BF24EC0FE44A3F2EE9B1")
    public String getDefaultEngine() {
        String varB4EAC82CA7396A68D541C85D26508E83_256565830 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_256565830 = mEnginesHelper.getDefaultEngine();
        varB4EAC82CA7396A68D541C85D26508E83_256565830.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_256565830;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.354 -0400", hash_original_method = "FDBC18F088428D1AA4FA407CF8A38EB5", hash_generated_method = "0AD129853824954277A80DA30A4925BF")
    public boolean areDefaultsEnforced() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1664056272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1664056272;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.354 -0400", hash_original_method = "C282EF17EB1B4600865CB51DA0934709", hash_generated_method = "B6DF37939677BBAFE3AD2AB9434AF135")
    public List<EngineInfo> getEngines() {
        List<EngineInfo> varB4EAC82CA7396A68D541C85D26508E83_274380721 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_274380721 = mEnginesHelper.getEngines();
        varB4EAC82CA7396A68D541C85D26508E83_274380721.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_274380721;
        
        
    }

    
    public class Engine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_method = "0CEE966FD083EAF9A38425EF355FEEF7", hash_generated_method = "0CEE966FD083EAF9A38425EF355FEEF7")
        public Engine ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "36D45D439A9D88F92C91EED7F227B118", hash_generated_field = "6EA685DC1F94714F1A1A1A053FC21028")

        public static final int DEFAULT_RATE = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "735042F181F97049F645A49551694C8F", hash_generated_field = "7265570D9BCE2101E8993107FABA1337")

        public static final int DEFAULT_PITCH = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "2CCE70ADE73106C43ECEE5E8A9205C7A", hash_generated_field = "95742929B161124D7ABDF4B245140DE7")

        public static final float DEFAULT_VOLUME = 1.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "1B7AB37CA837BE7D293E3424675F31F6", hash_generated_field = "BDDAA621A92D5CA41E24125645C10B9B")

        public static final float DEFAULT_PAN = 0.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "24C227C2F4C89803E4CC9D1CA4639012", hash_generated_field = "79A00612A369353FB0B563BBFBDD7A1F")

        public static final int USE_DEFAULTS = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "963BFD7556945F0ADCDB7063AA317405", hash_generated_field = "52D9AB195E713E24D836C4A49CC0D622")

        @Deprecated
        public static final String DEFAULT_ENGINE = "com.svox.pico";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "54C932376EBA54F9168634618A59869D", hash_generated_field = "C75C9F49D040B89D31A5EEE24181A5F2")

        public static final int DEFAULT_STREAM = AudioManager.STREAM_MUSIC;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "E08E1E62A1BA16AAB29D7A9A032DCA62", hash_generated_field = "C254DAAF5EBFA8002B27291ACC23702C")

        public static final int CHECK_VOICE_DATA_PASS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "EE2889DAB98E247108FD560D3EFB02FD", hash_generated_field = "E9C03161A9F0FFF5472A0040222D4C52")

        public static final int CHECK_VOICE_DATA_FAIL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "2DAAF7CA0FE4E57592622B27A82A704D", hash_generated_field = "431FD9B6D302AD606FFE065DF75DD2FA")

        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "CFC6EC4DDDF9F323DBC81D082171E33E", hash_generated_field = "7387564E7167154EEFED8705FCA0EED8")

        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "8D2D3E2E79C2C4E707239463D369E33B", hash_generated_field = "183E08CD13799093F5F5A44B05FDE73C")

        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "43EE5A08705D902AFADBFC04343199B2", hash_generated_field = "CAF4E59B3718CCEA9FF9E5188B9F6370")

        @SdkConstant(SdkConstantType.SERVICE_ACTION)
        public static final String INTENT_ACTION_TTS_SERVICE =
                "android.intent.action.TTS_SERVICE";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "E4042E25AFA9C947989DCC050E289401", hash_generated_field = "1838FC1E408F29335D36A08788A826E6")

        public static final String SERVICE_META_DATA = "android.speech.tts";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "A6833C0165AB755C6E068259E162C946", hash_generated_field = "AD45F25D873943976C37BF808E1956BE")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_INSTALL_TTS_DATA =
                "android.speech.tts.engine.INSTALL_TTS_DATA";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "D6AE8B393AF81687E39AF98587E4CABC", hash_generated_field = "A33F17727F43DBD7A47E893BB9B716B9")

        @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
        public static final String ACTION_TTS_DATA_INSTALLED =
                "android.speech.tts.engine.TTS_DATA_INSTALLED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "FA190AA53E599DBC899F53B55858698C", hash_generated_field = "43F20E850CE384CB5D9C74DD369FDD87")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_CHECK_TTS_DATA =
                "android.speech.tts.engine.CHECK_TTS_DATA";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "5C6C6397C49314D5F5E204CA1933345E", hash_generated_field = "58E16B540735E811A37625B0342CFA0F")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_GET_SAMPLE_TEXT =
                "android.speech.tts.engine.GET_SAMPLE_TEXT";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "9F649196082E67572C2349155C9919D2", hash_generated_field = "178CAFEE370EC9E79529912F27523F36")

        public static final String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "EFCBBB44D3D24A3D84E5ABC46FC70857", hash_generated_field = "2FCEBB35020F29546E39463BDD214A73")

        public static final String EXTRA_VOICE_DATA_FILES = "dataFiles";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "1DC90AA7734216663D84607F446D95B3", hash_generated_field = "23CB204D3DC0650A224FB5ABA98F25A7")

        public static final String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "FD4F2914F7FB71A96D2E879989B79136", hash_generated_field = "A5FF7832C171B046C21F825764FE8230")

        public static final String EXTRA_AVAILABLE_VOICES = "availableVoices";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "25CADBA271F43B9ED671E6822C5D1A88", hash_generated_field = "AC4770FDD8C95CC92539FC82143B39C5")

        public static final String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "C44D63A48B4EB093B375BC969B445992", hash_generated_field = "C8E0905A88A840D679AC2FF9508E3712")

        public static final String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "85A22E5221C66B5FEA03947CDBB2D9D0", hash_generated_field = "566A9FB915E742DB0D9FCBB9613D8A98")

        public static final String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "F36FF974081651AF068D67E5D4C4C65B", hash_generated_field = "9662C467B57A79462A5A958B925CD456")

        public static final String KEY_PARAM_RATE = "rate";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "A30E5701A5E3DB6B461EF4FA9632FED2", hash_generated_field = "41A112801807BF60F6B64B56EABC75A7")

        public static final String KEY_PARAM_LANGUAGE = "language";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "049E0A857DB03C5705F89387DBFA3F94", hash_generated_field = "B9529957E3604F14146602846E9977A5")

        public static final String KEY_PARAM_COUNTRY = "country";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "5DD9CAE974E3E4DF07273B713C0141E3", hash_generated_field = "194C150941509AFA9F06806544278558")

        public static final String KEY_PARAM_VARIANT = "variant";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.355 -0400", hash_original_field = "4BF977BE522A7D4FAECCE001402B4B22", hash_generated_field = "5790995E2173B750C19C7F0DF730BD18")

        public static final String KEY_PARAM_ENGINE = "engine";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.356 -0400", hash_original_field = "8EFCD27051CF12277949A1C6787CF4CA", hash_generated_field = "3BDB1A8EA9944800172EB2E01D630D39")

        public static final String KEY_PARAM_PITCH = "pitch";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.356 -0400", hash_original_field = "82BD90E3DC3CCF8584C41564CAE4AAB5", hash_generated_field = "AA44CC9D49E0D6103F2E361CC4DC18B0")

        public static final String KEY_PARAM_STREAM = "streamType";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.356 -0400", hash_original_field = "1A45AC9684F0F72F5EB630E624D8FB7C", hash_generated_field = "D01CCD0CAFBD7B77262BEE4DF757451B")

        public static final String KEY_PARAM_UTTERANCE_ID = "utteranceId";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.356 -0400", hash_original_field = "EB555D6AB84BF7E41BAC2B5D53A5F9B2", hash_generated_field = "F31741CDDA9583A05DBFC466602DB856")

        public static final String KEY_PARAM_VOLUME = "volume";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.356 -0400", hash_original_field = "5C37A91E922F1CA033CF81267F80980E", hash_generated_field = "5C33025FF7CAEFB03AF35CC41A77E51F")

        public static final String KEY_PARAM_PAN = "pan";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.356 -0400", hash_original_field = "B9B59CA107B4998520D8F04E86304BB9", hash_generated_field = "9C632C8E548D61E23BCBF91A78385C5A")

        public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.356 -0400", hash_original_field = "5D6A2E8BAB4CD47E940B987CF3C63014", hash_generated_field = "367B7447EF0E1BB5CDEB71ED7EF27786")

        public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    }


    
    private class Connection implements ServiceConnection {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.356 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "D3C3F8FD9BA670292396CDDDD2DBC0CC")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.357 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
        public Connection ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.358 -0400", hash_original_method = "E38F495B4498EDF08C66FB9F592C4572", hash_generated_method = "13D0F2DA18AB79324430B218EDA72263")
        public void onServiceConnected(ComponentName name, IBinder service) {
            
            {
                {
                    mServiceConnection.disconnect();
                } 
                mServiceConnection = this;
                mService = ITextToSpeechService.Stub.asInterface(service);
                try 
                {
                    mService.setCallback(getPackageName(), mCallback);
                    dispatchOnInit(SUCCESS);
                } 
                catch (RemoteException re)
                {
                    dispatchOnInit(ERROR);
                } 
            } 
            addTaint(name.getTaint());
            
            
            
                
                    
                
                
                
                
                    
                    
                
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.358 -0400", hash_original_method = "9CBB724FFDF56C58A2F363CBB7ADEB66", hash_generated_method = "B197524A11BD86D1FD3BA448E9871989")
        public void onServiceDisconnected(ComponentName name) {
            
            {
                mService = null;
                {
                    boolean varCFBB343190D0053DBC4029F6CA0B9372_383429783 = (mServiceConnection == this);
                    {
                        mServiceConnection = null;
                    } 
                } 
            } 
            addTaint(name.getTaint());
            
            
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.358 -0400", hash_original_method = "670DB56217535BA78AC55188B9013676", hash_generated_method = "22BDFB36185642ED4E82BED8A6D53D5B")
        public void disconnect() {
            mContext.unbindService(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.359 -0400", hash_original_method = "34464E55B5499CA206CC99D3045C1292", hash_generated_method = "18B86691D994A4D13B385920345791BD")
        public <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
            R varB4EAC82CA7396A68D541C85D26508E83_2079859407 = null; 
            R varB4EAC82CA7396A68D541C85D26508E83_369131742 = null; 
            R varB4EAC82CA7396A68D541C85D26508E83_82352096 = null; 
            try 
            {
                {
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2079859407 = errorResult;
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_369131742 = action.run(mService);
                } 
            } 
            catch (RemoteException ex)
            {
                {
                    disconnect();
                    initTts();
                } 
                varB4EAC82CA7396A68D541C85D26508E83_82352096 = errorResult;
            } 
            addTaint(action.getTaint());
            addTaint(errorResult.getTaint());
            addTaint(method.getTaint());
            addTaint(reconnect);
            R varA7E53CE21691AB073D9660D615818899_71241882; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_71241882 = varB4EAC82CA7396A68D541C85D26508E83_2079859407;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_71241882 = varB4EAC82CA7396A68D541C85D26508E83_369131742;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_71241882 = varB4EAC82CA7396A68D541C85D26508E83_82352096;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_71241882.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_71241882;
            
            
                
                    
                        
                        
                    
                    
                
            
                
                
                    
                    
                
                
            
        }

        
    }


    
    public static class EngineInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.359 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.359 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "B1C3A1439C6538148E2C8C0A71DA201D")

        public String label;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.359 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.359 -0400", hash_original_field = "54B53072540EEEB8F8E9343E71F28176", hash_generated_field = "D1DBA00001B7F415431AD6FCAB5BAA5D")

        public boolean system;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.359 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

        public int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.359 -0400", hash_original_method = "1BD677F38EE0D51841725F2C2D5029FA", hash_generated_method = "1BD677F38EE0D51841725F2C2D5029FA")
        public EngineInfo ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.360 -0400", hash_original_method = "2BF343FE966C95427B565E993C403E36", hash_generated_method = "A6AB89E5C4B2081A7D16843DC48495DC")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1702809749 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1702809749 = "EngineInfo{name=" + name + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1702809749.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1702809749;
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.360 -0400", hash_original_field = "DF41A127C133B054D95ADD91C88170F4", hash_generated_field = "9FEA0A384A6DC49F3D654A7B0E49ACFB")

    private static final String TAG = "TextToSpeech";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "C8AE4103156B65C0D23556A48DB4D815", hash_generated_field = "9B986A2CF4CE0B3870A44EA118A88E9A")

    public static final int SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "5DDED9E5103DBD4703C0660F86E0B86E", hash_generated_field = "D9FDA3C0E4B8421EF0ECF23EDE3289A4")

    public static final int ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "95588520F32581BA8D1244F13101ED06", hash_generated_field = "02E0C42BFDC9472143A2816BE6A46302")

    public static final int QUEUE_FLUSH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "E3380CB05B87800713541EA7B6C5393B", hash_generated_field = "E3D905B07D88D805D26B80E9C9543333")

    public static final int QUEUE_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "7B7F3B3D69B07673CD2E7AAF005CBF5F", hash_generated_field = "D4957AFE7D527970CF14C5B19ED60003")

    static final int QUEUE_DESTROY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "DFAFB9213D04FA47F5A5F2A4B74F14B3", hash_generated_field = "114C4BE7840CE5276181D4AD399DD60A")

    public static final int LANG_COUNTRY_VAR_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "5FA467857132F3FB084FACD4877020EB", hash_generated_field = "615AF214DE081692194C09BC057B78F6")

    public static final int LANG_COUNTRY_AVAILABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "E8D8099546226BEB455FFD46312483E0", hash_generated_field = "D0C3004A60A5D721A3D561D3F15B8744")

    public static final int LANG_AVAILABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "728E1D2145BB05D62DE4ABA628047B9D", hash_generated_field = "811988C198657A72F3A46F0269AEEEC3")

    public static final int LANG_MISSING_DATA = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "E4F8C9D14EBD840CD3FB4037BAF176AF", hash_generated_field = "D282ACE529F1D4C71E5D1D903CE29D28")

    public static final int LANG_NOT_SUPPORTED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.361 -0400", hash_original_field = "7D2E96656AB2A31B8BC2DBA52B97A09F", hash_generated_field = "1613EE279914B2EEC593ED6D5A8EDA25")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED =
            "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
}

