package android.speech.tts;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.481 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.481 -0400", hash_original_field = "94CA83B0A5EF3662095068A2D93D4E51", hash_generated_field = "46824CCAF8D8A297954B79F68288C27C")

    private Connection mServiceConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.481 -0400", hash_original_field = "BD66CA08574E567F4A2FF02EAF3A3C43", hash_generated_field = "9260ADD518F0FEF38A450F7DB53206FF")

    private OnInitListener mInitListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.481 -0400", hash_original_field = "FCC9BC767DCFBBDC0E992E8F8F631777", hash_generated_field = "328E3D7B680D2F02E50F03A1B91A5C91")

    private volatile UtteranceProgressListener mUtteranceProgressListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.481 -0400", hash_original_field = "A566AAD21AECEFD87B9A641763F0E8ED", hash_generated_field = "A8116CC7E9FFC22E32CD58F7221C57D1")

    private final Object mStartLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.482 -0400", hash_original_field = "79A963EB2FE6CF7ED985A37C9C2DAFC8", hash_generated_field = "87C8AA46082F357B5A90BEFDCD55A9CA")

    private String mRequestedEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.482 -0400", hash_original_field = "4FBF9E2CF0458E920CECA1122F7CE66F", hash_generated_field = "F6B4C1579EC35D212C4AF2EE4A947247")

    private Map<String, Uri> mEarcons;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.482 -0400", hash_original_field = "DADCFF0BCD3190EF5EA5DAA385F05AFC", hash_generated_field = "AF9F14E0A7A7BBE0D15082F4D775A15F")

    private Map<String, Uri> mUtterances;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.482 -0400", hash_original_field = "2E7257A953F47313410ACCB399EF186C", hash_generated_field = "0509EAD5E22611839DB01FDA008360EE")

    private final Bundle mParams = new Bundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.482 -0400", hash_original_field = "3D23233AD3766EA5A08A04C38A75975D", hash_generated_field = "C4FA3CBED7ED304B229BB483017A66E9")

    private TtsEngines mEnginesHelper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.483 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.483 -0400", hash_original_field = "D10648D448DDFF74BD81B300412AA0DA", hash_generated_field = "8E5DC033BD559466A27E8B7E16939D55")

    private volatile String mCurrentEngine = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.484 -0400", hash_original_method = "E5C095C9A34533EB222D42D1A6D92941", hash_generated_method = "F5C7AE788B42B97E7919890D99F1C1CA")
    public  TextToSpeech(Context context, OnInitListener listener) {
        this(context, listener, null);
        addTaint(listener.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.485 -0400", hash_original_method = "894D965EFAB67E7E0E3D1E11B990F0FA", hash_generated_method = "954C0978587FF52E755C15C7B4BA6C9B")
    public  TextToSpeech(Context context, OnInitListener listener, String engine) {
        this(context, listener, engine, null);
        addTaint(engine.getTaint());
        addTaint(listener.getTaint());
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.487 -0400", hash_original_method = "0584A597F5F20737FDED0391417BF29B", hash_generated_method = "87C5710AD5949D036B5FDC6AB2829764")
    public  TextToSpeech(Context context, OnInitListener listener, String engine,
            String packageName) {
        mContext = context;
        mInitListener = listener;
        mRequestedEngine = engine;
        mEarcons = new HashMap<String, Uri>();
        mUtterances = new HashMap<String, Uri>();
        mUtteranceProgressListener = null;
        mEnginesHelper = new TtsEngines(mContext);
    if(packageName != null)        
        {
            mPackageName = packageName;
        } 
        else
        {
            mPackageName = mContext.getPackageName();
        } 
        initTts();
        
        
        
        
        
        
        
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.488 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "2DEAD8D0CEC9CB7275A5B493F0D280F9")
    private String getPackageName() {
String var5601F77C1E784C31FA233AB799182FA6_1064570548 =         mPackageName;
        var5601F77C1E784C31FA233AB799182FA6_1064570548.addTaint(taint);
        return var5601F77C1E784C31FA233AB799182FA6_1064570548;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.489 -0400", hash_original_method = "94C951553FBC2F5928AD7C3B02D8E2C9", hash_generated_method = "FFA7720BE29A6CECA22CAB6A95E02F2A")
    private <R> R runActionNoReconnect(Action<R> action, R errorResult, String method) {
        addTaint(method.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(action.getTaint());
R var6CD80DC7ED7C75CB0A432FA52BFDBB11_45796599 =         runAction(action, errorResult, method, false);
        var6CD80DC7ED7C75CB0A432FA52BFDBB11_45796599.addTaint(taint);
        return var6CD80DC7ED7C75CB0A432FA52BFDBB11_45796599;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.489 -0400", hash_original_method = "29E7B310AE240E4C21F0167C8B8476FB", hash_generated_method = "DAAE3D5BB458A08F58998F7C5E8640E5")
    private <R> R runAction(Action<R> action, R errorResult, String method) {
        addTaint(method.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(action.getTaint());
R varBE0F0122D8EC62CE380C7C3C781DBEA1_1321638623 =         runAction(action, errorResult, method, true);
        varBE0F0122D8EC62CE380C7C3C781DBEA1_1321638623.addTaint(taint);
        return varBE0F0122D8EC62CE380C7C3C781DBEA1_1321638623;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.490 -0400", hash_original_method = "6EC1A4E0A67965882D9F244E76909BAE", hash_generated_method = "030822410BE24B93210940358DC69F89")
    private <R> R runAction(Action<R> action, R errorResult, String method, boolean reconnect) {
        addTaint(reconnect);
        addTaint(method.getTaint());
        addTaint(errorResult.getTaint());
        addTaint(action.getTaint());
        synchronized
(mStartLock)        {
    if(mServiceConnection == null)            
            {
R var79B35EE005A3F2115C55AE7046E4A0E2_1576155018 =                 errorResult;
                var79B35EE005A3F2115C55AE7046E4A0E2_1576155018.addTaint(taint);
                return var79B35EE005A3F2115C55AE7046E4A0E2_1576155018;
            } 
R var6E73D2A7B1D3CEC549E60088058AF61B_651202102 =             mServiceConnection.runAction(action, errorResult, method, reconnect);
            var6E73D2A7B1D3CEC549E60088058AF61B_651202102.addTaint(taint);
            return var6E73D2A7B1D3CEC549E60088058AF61B_651202102;
        } 
        
        
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.492 -0400", hash_original_method = "001A57975E2E50499F283478CA48737A", hash_generated_method = "2EEBFE39C7B0033FDD01F7880CC54D65")
    private int initTts() {
    if(mRequestedEngine != null && mEnginesHelper.isEngineInstalled(mRequestedEngine))        
        {
    if(connectToEngine(mRequestedEngine))            
            {
                mCurrentEngine = mRequestedEngine;
                int varD0749AABA8B833466DFCBB0428E4F89C_415681456 = (SUCCESS);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1560874222 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1560874222;
            } 
        } 
        final String defaultEngine = getDefaultEngine();
    if(defaultEngine != null && !defaultEngine.equals(mRequestedEngine))        
        {
    if(connectToEngine(defaultEngine))            
            {
                mCurrentEngine = defaultEngine;
                int varD0749AABA8B833466DFCBB0428E4F89C_911918176 = (SUCCESS);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182789580 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182789580;
            } 
        } 
        final String highestRanked = mEnginesHelper.getHighestRankedEngineName();
    if(highestRanked != null && !highestRanked.equals(mRequestedEngine) &&
                !highestRanked.equals(defaultEngine))        
        {
    if(connectToEngine(highestRanked))            
            {
                mCurrentEngine = highestRanked;
                int varD0749AABA8B833466DFCBB0428E4F89C_494347753 = (SUCCESS);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2057885878 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2057885878;
            } 
        } 
        mCurrentEngine = null;
        dispatchOnInit(ERROR);
        int varBB1CA97EC761FC37101737BA0AA2E7C5_1436805873 = (ERROR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983965366 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_983965366;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.493 -0400", hash_original_method = "5177E4BA973A00FB9C33DC0A5DBEACDB", hash_generated_method = "3B80C5625CF19F1F4136E4CBE76B3E69")
    private boolean connectToEngine(String engine) {
        addTaint(engine.getTaint());
        Connection connection = new Connection();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        boolean bound = mContext.bindService(intent, connection, Context.BIND_AUTO_CREATE);
    if(!bound)        
        {
            boolean var68934A3E9455FA72420237EB05902327_75331102 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_52960114 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_52960114;
        } 
        else
        {
            boolean varB326B5062B2F0E69046810717534CB09_1041214881 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811523492 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_811523492;
        } 
        
        
        
        
        
        
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.494 -0400", hash_original_method = "16B0CCB3D7329F5127962CE558D4D17C", hash_generated_method = "E21FFB2444D259D2156403B08D3C8F87")
    private void dispatchOnInit(int result) {
        addTaint(result);
        synchronized
(mStartLock)        {
    if(mInitListener != null)            
            {
                mInitListener.onInit(result);
                mInitListener = null;
            } 
        } 
        
        
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.505 -0400", hash_original_method = "EAB786CB351424B1FA3879678813021A", hash_generated_method = "F557564239A46E371E0653E451E94906")
    public void shutdown() {
        runActionNoReconnect(new Action<Void>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.505 -0400", hash_original_method = "1C176575622D770489EE559F23BB4FED", hash_generated_method = "94729370F9B306B8A624C5243D4A3120")
        @Override
        public Void run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            service.setCallback(getPackageName(), null);
            service.stop(getPackageName());
            mServiceConnection.disconnect();
            mServiceConnection = null;
            mCurrentEngine = null;
Void var540C13E9E156B687226421B24F2DF178_774945443 =             null;
            var540C13E9E156B687226421B24F2DF178_774945443.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_774945443;
            
            
            
            
            
            
            
        }
}, null, "shutdown");
        
        
            
            
                
                
                
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.505 -0400", hash_original_method = "DD10D1EA0D37E9C3175CB1CE81EACE27", hash_generated_method = "EB8551152581D49283C8AFEBA2FDB464")
    public int addSpeech(String text, String packagename, int resourceId) {
        addTaint(resourceId);
        addTaint(packagename.getTaint());
        addTaint(text.getTaint());
        synchronized
(mStartLock)        {
            mUtterances.put(text, makeResourceUri(packagename, resourceId));
            int varD0749AABA8B833466DFCBB0428E4F89C_1283310755 = (SUCCESS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437148320 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1437148320;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.505 -0400", hash_original_method = "DBC13E8086F9460080E153D9CAE05A02", hash_generated_method = "1C9D834C25E4078171214E4C75715CF1")
    public int addSpeech(String text, String filename) {
        addTaint(filename.getTaint());
        addTaint(text.getTaint());
        synchronized
(mStartLock)        {
            mUtterances.put(text, Uri.parse(filename));
            int varD0749AABA8B833466DFCBB0428E4F89C_979270292 = (SUCCESS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139796164 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139796164;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.505 -0400", hash_original_method = "773577F8E212F06A89510B07A5731283", hash_generated_method = "2BD6267E22986611DBE0B0E325CB62E6")
    public int addEarcon(String earcon, String packagename, int resourceId) {
        addTaint(resourceId);
        addTaint(packagename.getTaint());
        addTaint(earcon.getTaint());
        synchronized
(mStartLock)        {
            mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
            int varD0749AABA8B833466DFCBB0428E4F89C_1201016068 = (SUCCESS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732058993 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_732058993;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.506 -0400", hash_original_method = "409D0B7C115347E1FFF71FD2BD1F314E", hash_generated_method = "59B74CEA6DE4747A595D8F40B3C23DF2")
    public int addEarcon(String earcon, String filename) {
        addTaint(filename.getTaint());
        addTaint(earcon.getTaint());
        synchronized
(mStartLock)        {
            mEarcons.put(earcon, Uri.parse(filename));
            int varD0749AABA8B833466DFCBB0428E4F89C_266741419 = (SUCCESS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691748503 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691748503;
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.506 -0400", hash_original_method = "276BC175828DCE484EB0703A6A0D8E9B", hash_generated_method = "265BCC8E7FDAF1C7B61360584544A6BA")
    private Uri makeResourceUri(String packageName, int resourceId) {
        addTaint(resourceId);
        addTaint(packageName.getTaint());
Uri var5AA96771068ABD432380D30C1FF16905_2016544362 =         new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .encodedAuthority(packageName)
                .appendEncodedPath(String.valueOf(resourceId))
                .build();
        var5AA96771068ABD432380D30C1FF16905_2016544362.addTaint(taint);
        return var5AA96771068ABD432380D30C1FF16905_2016544362;
        
        
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.506 -0400", hash_original_method = "BE0E5C2CBBCD37525836C6DA289D2EEC", hash_generated_method = "D51892A0EA6F821CFD018BD7A8E4C3A9")
    public int speak(final String text, final int queueMode, final HashMap<String, String> params) {
        addTaint(params.getTaint());
        addTaint(queueMode);
        addTaint(text.getTaint());
        int varABCF8F5BF7A5ACEFD988C02E7527F098_2141980427 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.506 -0400", hash_original_method = "7D06D49EA86F29A3C163217832E59726", hash_generated_method = "613CFE438F557CB0DD0243BA958C7D8E")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            Uri utteranceUri = mUtterances.get(text);
    if(utteranceUri != null)            
            {
Integer varC830AAB5FAB696E7256A7C3D283C883D_1391392770 =                 service.playAudio(getPackageName(), utteranceUri, queueMode,
                            getParams(params));
                varC830AAB5FAB696E7256A7C3D283C883D_1391392770.addTaint(taint);
                return varC830AAB5FAB696E7256A7C3D283C883D_1391392770;
            } 
            else
            {
Integer var74EFE1A3416A985FD34BFF617FF395BF_1599113184 =                 service.speak(getPackageName(), text, queueMode, getParams(params));
                var74EFE1A3416A985FD34BFF617FF395BF_1599113184.addTaint(taint);
                return var74EFE1A3416A985FD34BFF617FF395BF_1599113184;
            } 
            
            
            
                    
                            
                
                    
                
        }
}, ERROR, "speak"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521617113 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521617113;
        
        
            
            
                
                
                    
                            
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.507 -0400", hash_original_method = "F18AB3CD06A1E20DE6BD7099833B6FEC", hash_generated_method = "63C4F4183D7B4501EFCB393A0245EA1A")
    public int playEarcon(final String earcon, final int queueMode,
            final HashMap<String, String> params) {
        addTaint(params.getTaint());
        addTaint(queueMode);
        addTaint(earcon.getTaint());
        int varC329F98532E330BD5FD4FB7288208153_961587843 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.507 -0400", hash_original_method = "6A26B14D42F3FBBE45C132D11F693742", hash_generated_method = "421AF7F3797CE82EA431B2B7C74DCBB3")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            Uri earconUri = mEarcons.get(earcon);
    if(earconUri == null)            
            {
Integer var3F5FB64C1A12F0A78F9609D9CC474A24_2122971830 =                 ERROR;
                var3F5FB64C1A12F0A78F9609D9CC474A24_2122971830.addTaint(taint);
                return var3F5FB64C1A12F0A78F9609D9CC474A24_2122971830;
            } 
Integer var3F4F7F85D5B430AD0CF35D2C5F73E872_486677747 =             service.playAudio(getPackageName(), earconUri, queueMode,
                        getParams(params));
            var3F4F7F85D5B430AD0CF35D2C5F73E872_486677747.addTaint(taint);
            return var3F4F7F85D5B430AD0CF35D2C5F73E872_486677747;
            
            
            
                    
                
            
                        
        }
}, ERROR, "playEarcon"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221884353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221884353;
        
        
            
            
                
                
                    
                
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.507 -0400", hash_original_method = "94C759FE8B677E32982F42F6A676D86E", hash_generated_method = "9563CA379E89EFD2113A6C2DCED58A33")
    public int playSilence(final long durationInMs, final int queueMode,
            final HashMap<String, String> params) {
        addTaint(params.getTaint());
        addTaint(queueMode);
        addTaint(durationInMs);
        int var96250F63D5322E961559B7EEC724A21A_1072261832 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.507 -0400", hash_original_method = "78C333BA11B47CA10C93733938393F3E", hash_generated_method = "572C2478C887116CEB15E47AE8B6A21E")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
Integer varF960BC12575747C24E20C0225559D5BB_503683950 =             service.playSilence(getPackageName(), durationInMs, queueMode,
                        getParams(params));
            varF960BC12575747C24E20C0225559D5BB_503683950.addTaint(taint);
            return varF960BC12575747C24E20C0225559D5BB_503683950;
            
            
                        
        }
}, ERROR, "playSilence"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_130901785 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_130901785;
        
        
            
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.508 -0400", hash_original_method = "8AF2E385B6F026EB817E9FE98AB99B1D", hash_generated_method = "6C2DD311A396E1383A6F635EE0825698")
    public Set<String> getFeatures(final Locale locale) {
        addTaint(locale.getTaint());
Set<String> var628544D9C2D4854478D09F82EACFFF99_1001683886 =         runAction(new Action<Set<String>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.507 -0400", hash_original_method = "F0504A62951AE3DA8704A40623A9C42B", hash_generated_method = "74487F11873FC9BFA2961E83838490BF")
        @Override
        public Set<String> run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            String[] features = service.getFeaturesForLanguage(
                        locale.getISO3Language(), locale.getISO3Country(), locale.getVariant());
    if(features != null)            
            {
                final Set<String> featureSet = new HashSet<String>();
                Collections.addAll(featureSet, features);
Set<String> var5857656592B7BBF1A241131B963ED712_460762720 =                 featureSet;
                var5857656592B7BBF1A241131B963ED712_460762720.addTaint(taint);
                return var5857656592B7BBF1A241131B963ED712_460762720;
            } 
Set<String> var540C13E9E156B687226421B24F2DF178_1924797060 =             null;
            var540C13E9E156B687226421B24F2DF178_1924797060.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1924797060;
            
            
                        
            
                    
                    
                    
                
            
        }
}, null, "getFeatures");
        var628544D9C2D4854478D09F82EACFFF99_1001683886.addTaint(taint);
        return var628544D9C2D4854478D09F82EACFFF99_1001683886;
        
        
            
            
                
                        
                
                    
                    
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.508 -0400", hash_original_method = "DC605D9F82407CF596B06CFECEFBD8A5", hash_generated_method = "4079975EEE093948BFD295F618A1530B")
    public boolean isSpeaking() {
        boolean var2579DEB72906C66139EE1C3912D1794B_1477650524 = (runAction(new Action<Boolean>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.508 -0400", hash_original_method = "CDD6871E0A3D820171A5453DF320B8D3", hash_generated_method = "CD1A7A8859D89FDA7C5CFD03DA11501D")
        @Override
        public Boolean run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
Boolean var8E649280B66AA64AE13D2F0B9F1A2024_336844809 =             service.isSpeaking();
            var8E649280B66AA64AE13D2F0B9F1A2024_336844809.addTaint(taint);
            return var8E649280B66AA64AE13D2F0B9F1A2024_336844809;
            
            
        }
}, false, "isSpeaking"));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8391240 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_8391240;
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.508 -0400", hash_original_method = "1B011279D3385FBEA81C0EEE9DDE31E7", hash_generated_method = "AA73BB84F4F80FDFCCE9B71C2097903F")
    public int stop() {
        int var683F2C5095B69150ADF39E7F3EBD7BC7_1950529039 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.508 -0400", hash_original_method = "C3E115845E07ACC22BB6BDAD6EAAC990", hash_generated_method = "9618AF79A82C348EA2C4196FB49A994F")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
Integer varE12943068FF9423862F1428EAB10C44E_594155218 =             service.stop(getPackageName());
            varE12943068FF9423862F1428EAB10C44E_594155218.addTaint(taint);
            return varE12943068FF9423862F1428EAB10C44E_594155218;
            
            
        }
}, ERROR, "stop"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1298834310 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1298834310;
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.508 -0400", hash_original_method = "6950E84EE314E7032010233B0706B078", hash_generated_method = "FBC96591F0E1E5A5A0D9AB3499CD240E")
    public int setSpeechRate(float speechRate) {
        addTaint(speechRate);
    if(speechRate > 0.0f)        
        {
            int intRate = (int)(speechRate * 100);
    if(intRate > 0)            
            {
                synchronized
(mStartLock)                {
                    mParams.putInt(Engine.KEY_PARAM_RATE, intRate);
                } 
                int varD0749AABA8B833466DFCBB0428E4F89C_1812824592 = (SUCCESS);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_397099494 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_397099494;
            } 
        } 
        int varBB1CA97EC761FC37101737BA0AA2E7C5_891028293 = (ERROR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003457335 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003457335;
        
        
            
            
                
                    
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.509 -0400", hash_original_method = "7DADB23AB82E5180649E2697B1338160", hash_generated_method = "1E159C9844EBFB3BB07CC7FF5AAE1C7F")
    public int setPitch(float pitch) {
        addTaint(pitch);
    if(pitch > 0.0f)        
        {
            int intPitch = (int)(pitch * 100);
    if(intPitch > 0)            
            {
                synchronized
(mStartLock)                {
                    mParams.putInt(Engine.KEY_PARAM_PITCH, intPitch);
                } 
                int varD0749AABA8B833466DFCBB0428E4F89C_99695893 = (SUCCESS);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132218794 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_132218794;
            } 
        } 
        int varBB1CA97EC761FC37101737BA0AA2E7C5_1764582672 = (ERROR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406312329 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1406312329;
        
        
            
            
                
                    
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.509 -0400", hash_original_method = "6F277B1B16E884F81974EA73065A64D8", hash_generated_method = "28F7B2CF674EEEAA2C6DAEB8F094369E")
    public String getCurrentEngine() {
String varF0379D96643374605D6BA399231446A3_1088072200 =         mCurrentEngine;
        varF0379D96643374605D6BA399231446A3_1088072200.addTaint(taint);
        return varF0379D96643374605D6BA399231446A3_1088072200;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.509 -0400", hash_original_method = "4B10A46E0E63D1391FC966E12E9B561D", hash_generated_method = "4B9F933195496292C184A6830B0BF640")
    public int setLanguage(final Locale loc) {
        addTaint(loc.getTaint());
        int var9C79AEEA6B37E59C4209A6F4D63CBEF7_474621527 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.509 -0400", hash_original_method = "0CBE42B90B008DE7C85EE0BE4FA8A569", hash_generated_method = "598AD858CD7D62B433F3D7FAEC901830")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
    if(loc == null)            
            {
Integer var9D0095E272DA84611754C424FD1F1417_1092511828 =                 LANG_NOT_SUPPORTED;
                var9D0095E272DA84611754C424FD1F1417_1092511828.addTaint(taint);
                return var9D0095E272DA84611754C424FD1F1417_1092511828;
            } 
            String language = loc.getISO3Language();
            String country = loc.getISO3Country();
            String variant = loc.getVariant();
            int result = service.loadLanguage(language, country, variant);
    if(result >= LANG_AVAILABLE)            
            {
    if(result < LANG_COUNTRY_VAR_AVAILABLE)                
                {
                    variant = "";
    if(result < LANG_COUNTRY_AVAILABLE)                    
                    {
                        country = "";
                    } 
                } 
                mParams.putString(Engine.KEY_PARAM_LANGUAGE, language);
                mParams.putString(Engine.KEY_PARAM_COUNTRY, country);
                mParams.putString(Engine.KEY_PARAM_VARIANT, variant);
            } 
Integer varDC838461EE2FA0CA4C9BBB70A15456B0_610345275 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_610345275.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_610345275;
            
            
        }
}, LANG_NOT_SUPPORTED, "setLanguage"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773664151 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1773664151;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.510 -0400", hash_original_method = "BC427E909E00C5BE5A5F111E336651C0", hash_generated_method = "47853A15EF79EE86385CCB9E740C8463")
    public Locale getLanguage() {
Locale var0611285425B54BCEC8D4A31276F61EE9_966341318 =         runAction(new Action<Locale>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.510 -0400", hash_original_method = "419A6331670010A27050C72F09FCFBF2", hash_generated_method = "5593A3B3E9E2E00212076A053D5DFBAD")
        @Override
        public Locale run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            String[] locStrings = service.getLanguage();
    if(locStrings != null && locStrings.length == 3)            
            {
Locale varB43BF46312C2A6C29483921803035C51_1847746383 =                 new Locale(locStrings[0], locStrings[1], locStrings[2]);
                varB43BF46312C2A6C29483921803035C51_1847746383.addTaint(taint);
                return varB43BF46312C2A6C29483921803035C51_1847746383;
            } 
Locale var540C13E9E156B687226421B24F2DF178_1447233126 =             null;
            var540C13E9E156B687226421B24F2DF178_1447233126.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1447233126;
            
            
            
                    
                
            
        }
}, null, "getLanguage");
        var0611285425B54BCEC8D4A31276F61EE9_966341318.addTaint(taint);
        return var0611285425B54BCEC8D4A31276F61EE9_966341318;
        
        
            
            
                
                
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.510 -0400", hash_original_method = "4344244CB1F796DE537DEBF5170866A9", hash_generated_method = "0BEDA968006D133F203A8057CD874B94")
    public int isLanguageAvailable(final Locale loc) {
        addTaint(loc.getTaint());
        int var65295AC726184FABCA5FC2252D033EE4_278119522 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.510 -0400", hash_original_method = "104F6D4E3824B9F3A36823FE96275A8A", hash_generated_method = "4A324B3C28A58F9038B07AF47F0AFBE0")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
Integer varD84127CF44AD07A1F9D09370E321480F_1759874501 =             service.isLanguageAvailable(loc.getISO3Language(),
                        loc.getISO3Country(), loc.getVariant());
            varD84127CF44AD07A1F9D09370E321480F_1759874501.addTaint(taint);
            return varD84127CF44AD07A1F9D09370E321480F_1759874501;
            
            
                        
        }
}, LANG_NOT_SUPPORTED, "isLanguageAvailable"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1344467604 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1344467604;
        
        
            
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.510 -0400", hash_original_method = "59A7F0A106B55E8A59A4D44C2073C3C6", hash_generated_method = "0B90795F7537DDE514C868E037212A7F")
    public int synthesizeToFile(final String text, final HashMap<String, String> params,
            final String filename) {
        addTaint(filename.getTaint());
        addTaint(params.getTaint());
        addTaint(text.getTaint());
        int varE74A981B07A776A5D8B94B6FCE052216_1509940561 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.510 -0400", hash_original_method = "126F93B055F255BA3903970B4BD95F1E", hash_generated_method = "9643D2440A23776065D2FC3BDC06EC76")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
Integer varC17144DAEB3B66EB3DD5823B0FC8BDAB_565915187 =             service.synthesizeToFile(getPackageName(), text, filename,
                        getParams(params));
            varC17144DAEB3B66EB3DD5823B0FC8BDAB_565915187.addTaint(taint);
            return varC17144DAEB3B66EB3DD5823B0FC8BDAB_565915187;
            
            
                        
        }
}, ERROR, "synthesizeToFile"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93990464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93990464;
        
        
            
            
                
                        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.511 -0400", hash_original_method = "F4A729CBEB92036D830EC51C9E6B27A9", hash_generated_method = "9EDC6137E6EAC8FF4225641133B98CD1")
    private Bundle getParams(HashMap<String, String> params) {
        addTaint(params.getTaint());
    if(params != null && !params.isEmpty())        
        {
            Bundle bundle = new Bundle(mParams);
            copyIntParam(bundle, params, Engine.KEY_PARAM_STREAM);
            copyStringParam(bundle, params, Engine.KEY_PARAM_UTTERANCE_ID);
            copyFloatParam(bundle, params, Engine.KEY_PARAM_VOLUME);
            copyFloatParam(bundle, params, Engine.KEY_PARAM_PAN);
            copyStringParam(bundle, params, Engine.KEY_FEATURE_NETWORK_SYNTHESIS);
            copyStringParam(bundle, params, Engine.KEY_FEATURE_EMBEDDED_SYNTHESIS);
    if(!TextUtils.isEmpty(mCurrentEngine))            
            {
for(Map.Entry<String, String> entry : params.entrySet())
                {
                    final String key = entry.getKey();
    if(key != null && key.startsWith(mCurrentEngine))                    
                    {
                        bundle.putString(key, entry.getValue());
                    } 
                } 
            } 
Bundle var7B2862195409742DCA365D8C6330AB92_1155623514 =             bundle;
            var7B2862195409742DCA365D8C6330AB92_1155623514.addTaint(taint);
            return var7B2862195409742DCA365D8C6330AB92_1155623514;
        } 
        else
        {
Bundle var1ECA468F8F118273F13D0667CCE29D60_1419058719 =             mParams;
            var1ECA468F8F118273F13D0667CCE29D60_1419058719.addTaint(taint);
            return var1ECA468F8F118273F13D0667CCE29D60_1419058719;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.511 -0400", hash_original_method = "CA756292003AA5F2AACD5FD8062D880F", hash_generated_method = "83FC21CCF2FEF6EF908F8F8C5B3944CF")
    private void copyStringParam(Bundle bundle, HashMap<String, String> params, String key) {
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        addTaint(bundle.getTaint());
        String value = params.get(key);
    if(value != null)        
        {
            bundle.putString(key, value);
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.511 -0400", hash_original_method = "D148C993B4D17B611EC6A14A9B3B3D7B", hash_generated_method = "0BAF632F1BCB4B1B2EB236F5BF94314F")
    private void copyIntParam(Bundle bundle, HashMap<String, String> params, String key) {
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        addTaint(bundle.getTaint());
        String valueString = params.get(key);
    if(!TextUtils.isEmpty(valueString))        
        {
            try 
            {
                int value = Integer.parseInt(valueString);
                bundle.putInt(key, value);
            } 
            catch (NumberFormatException ex)
            {
            } 
        } 
        
        
        
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.511 -0400", hash_original_method = "335CA474B2AA628361250A653672DD72", hash_generated_method = "0F4C694C627AD9B09B48050637C517F4")
    private void copyFloatParam(Bundle bundle, HashMap<String, String> params, String key) {
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        addTaint(bundle.getTaint());
        String valueString = params.get(key);
    if(!TextUtils.isEmpty(valueString))        
        {
            try 
            {
                float value = Float.parseFloat(valueString);
                bundle.putFloat(key, value);
            } 
            catch (NumberFormatException ex)
            {
            } 
        } 
        
        
        
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.511 -0400", hash_original_method = "24D73865C05CC11CAA8C791D8BA56024", hash_generated_method = "F8767D9AC6CCD36ED81198FEC5341817")
    @Deprecated
    public int setOnUtteranceCompletedListener(final OnUtteranceCompletedListener listener) {
        mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        int var29748D5FD7A8274F3DF6C0697E48D88B_1315605633 = (TextToSpeech.SUCCESS);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_649275750 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_649275750;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.512 -0400", hash_original_method = "98074E19965AB76BE23153F0217E2857", hash_generated_method = "6A2F9DD31162300B877E68390A8619E9")
    public int setOnUtteranceProgressListener(UtteranceProgressListener listener) {
        mUtteranceProgressListener = listener;
        int var29748D5FD7A8274F3DF6C0697E48D88B_1287951696 = (TextToSpeech.SUCCESS);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_994358958 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_994358958;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.512 -0400", hash_original_method = "06FE1E6C6795B03B25AD43DFED268D92", hash_generated_method = "6F02F06B5A311692A0BBEAE244C893F9")
    @Deprecated
    public int setEngineByPackageName(String enginePackageName) {
        mRequestedEngine = enginePackageName;
        int varA378E50E83B3BEF2BF06C44276D52CC5_1307234509 = (initTts());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708189429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1708189429;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.512 -0400", hash_original_method = "AAA28EF74B57D47AEDCF93243FD04D81", hash_generated_method = "485B686A9DD74926A8FA38689814D3AE")
    public String getDefaultEngine() {
String varF168E94075BBE3E03A9472F1231D848D_73500005 =         mEnginesHelper.getDefaultEngine();
        varF168E94075BBE3E03A9472F1231D848D_73500005.addTaint(taint);
        return varF168E94075BBE3E03A9472F1231D848D_73500005;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.512 -0400", hash_original_method = "FDBC18F088428D1AA4FA407CF8A38EB5", hash_generated_method = "27D856C849EB66A6953B0A78F0850A7F")
    public boolean areDefaultsEnforced() {
        boolean var68934A3E9455FA72420237EB05902327_937697649 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858790828 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_858790828;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.512 -0400", hash_original_method = "C282EF17EB1B4600865CB51DA0934709", hash_generated_method = "89143A0D142869453F225AF35E039600")
    public List<EngineInfo> getEngines() {
List<EngineInfo> var581E578A303E6D7E78C66653FD081751_1957637112 =         mEnginesHelper.getEngines();
        var581E578A303E6D7E78C66653FD081751_1957637112.addTaint(taint);
        return var581E578A303E6D7E78C66653FD081751_1957637112;
        
        
    }

    
    public class Engine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.512 -0400", hash_original_method = "0CEE966FD083EAF9A38425EF355FEEF7", hash_generated_method = "0CEE966FD083EAF9A38425EF355FEEF7")
        public Engine ()
        {
            
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.512 -0400", hash_original_field = "36D45D439A9D88F92C91EED7F227B118", hash_generated_field = "6EA685DC1F94714F1A1A1A053FC21028")

        public static final int DEFAULT_RATE = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.512 -0400", hash_original_field = "735042F181F97049F645A49551694C8F", hash_generated_field = "7265570D9BCE2101E8993107FABA1337")

        public static final int DEFAULT_PITCH = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.512 -0400", hash_original_field = "2CCE70ADE73106C43ECEE5E8A9205C7A", hash_generated_field = "95742929B161124D7ABDF4B245140DE7")

        public static final float DEFAULT_VOLUME = 1.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "1B7AB37CA837BE7D293E3424675F31F6", hash_generated_field = "BDDAA621A92D5CA41E24125645C10B9B")

        public static final float DEFAULT_PAN = 0.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "24C227C2F4C89803E4CC9D1CA4639012", hash_generated_field = "79A00612A369353FB0B563BBFBDD7A1F")

        public static final int USE_DEFAULTS = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "963BFD7556945F0ADCDB7063AA317405", hash_generated_field = "52D9AB195E713E24D836C4A49CC0D622")

        @Deprecated
        public static final String DEFAULT_ENGINE = "com.svox.pico";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "54C932376EBA54F9168634618A59869D", hash_generated_field = "C75C9F49D040B89D31A5EEE24181A5F2")

        public static final int DEFAULT_STREAM = AudioManager.STREAM_MUSIC;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "E08E1E62A1BA16AAB29D7A9A032DCA62", hash_generated_field = "C254DAAF5EBFA8002B27291ACC23702C")

        public static final int CHECK_VOICE_DATA_PASS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "EE2889DAB98E247108FD560D3EFB02FD", hash_generated_field = "E9C03161A9F0FFF5472A0040222D4C52")

        public static final int CHECK_VOICE_DATA_FAIL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "2DAAF7CA0FE4E57592622B27A82A704D", hash_generated_field = "431FD9B6D302AD606FFE065DF75DD2FA")

        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "CFC6EC4DDDF9F323DBC81D082171E33E", hash_generated_field = "7387564E7167154EEFED8705FCA0EED8")

        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "8D2D3E2E79C2C4E707239463D369E33B", hash_generated_field = "183E08CD13799093F5F5A44B05FDE73C")

        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "43EE5A08705D902AFADBFC04343199B2", hash_generated_field = "CAF4E59B3718CCEA9FF9E5188B9F6370")

        @SdkConstant(SdkConstantType.SERVICE_ACTION)
        public static final String INTENT_ACTION_TTS_SERVICE =
                "android.intent.action.TTS_SERVICE";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "E4042E25AFA9C947989DCC050E289401", hash_generated_field = "1838FC1E408F29335D36A08788A826E6")

        public static final String SERVICE_META_DATA = "android.speech.tts";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "A6833C0165AB755C6E068259E162C946", hash_generated_field = "AD45F25D873943976C37BF808E1956BE")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_INSTALL_TTS_DATA =
                "android.speech.tts.engine.INSTALL_TTS_DATA";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "D6AE8B393AF81687E39AF98587E4CABC", hash_generated_field = "A33F17727F43DBD7A47E893BB9B716B9")

        @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
        public static final String ACTION_TTS_DATA_INSTALLED =
                "android.speech.tts.engine.TTS_DATA_INSTALLED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "FA190AA53E599DBC899F53B55858698C", hash_generated_field = "43F20E850CE384CB5D9C74DD369FDD87")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_CHECK_TTS_DATA =
                "android.speech.tts.engine.CHECK_TTS_DATA";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "5C6C6397C49314D5F5E204CA1933345E", hash_generated_field = "58E16B540735E811A37625B0342CFA0F")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_GET_SAMPLE_TEXT =
                "android.speech.tts.engine.GET_SAMPLE_TEXT";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "9F649196082E67572C2349155C9919D2", hash_generated_field = "178CAFEE370EC9E79529912F27523F36")

        public static final String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.513 -0400", hash_original_field = "EFCBBB44D3D24A3D84E5ABC46FC70857", hash_generated_field = "2FCEBB35020F29546E39463BDD214A73")

        public static final String EXTRA_VOICE_DATA_FILES = "dataFiles";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "1DC90AA7734216663D84607F446D95B3", hash_generated_field = "23CB204D3DC0650A224FB5ABA98F25A7")

        public static final String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "FD4F2914F7FB71A96D2E879989B79136", hash_generated_field = "A5FF7832C171B046C21F825764FE8230")

        public static final String EXTRA_AVAILABLE_VOICES = "availableVoices";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "25CADBA271F43B9ED671E6822C5D1A88", hash_generated_field = "AC4770FDD8C95CC92539FC82143B39C5")

        public static final String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "C44D63A48B4EB093B375BC969B445992", hash_generated_field = "C8E0905A88A840D679AC2FF9508E3712")

        public static final String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "85A22E5221C66B5FEA03947CDBB2D9D0", hash_generated_field = "566A9FB915E742DB0D9FCBB9613D8A98")

        public static final String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "F36FF974081651AF068D67E5D4C4C65B", hash_generated_field = "9662C467B57A79462A5A958B925CD456")

        public static final String KEY_PARAM_RATE = "rate";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "A30E5701A5E3DB6B461EF4FA9632FED2", hash_generated_field = "41A112801807BF60F6B64B56EABC75A7")

        public static final String KEY_PARAM_LANGUAGE = "language";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "049E0A857DB03C5705F89387DBFA3F94", hash_generated_field = "B9529957E3604F14146602846E9977A5")

        public static final String KEY_PARAM_COUNTRY = "country";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "5DD9CAE974E3E4DF07273B713C0141E3", hash_generated_field = "194C150941509AFA9F06806544278558")

        public static final String KEY_PARAM_VARIANT = "variant";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "4BF977BE522A7D4FAECCE001402B4B22", hash_generated_field = "5790995E2173B750C19C7F0DF730BD18")

        public static final String KEY_PARAM_ENGINE = "engine";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "8EFCD27051CF12277949A1C6787CF4CA", hash_generated_field = "3BDB1A8EA9944800172EB2E01D630D39")

        public static final String KEY_PARAM_PITCH = "pitch";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "82BD90E3DC3CCF8584C41564CAE4AAB5", hash_generated_field = "AA44CC9D49E0D6103F2E361CC4DC18B0")

        public static final String KEY_PARAM_STREAM = "streamType";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "1A45AC9684F0F72F5EB630E624D8FB7C", hash_generated_field = "D01CCD0CAFBD7B77262BEE4DF757451B")

        public static final String KEY_PARAM_UTTERANCE_ID = "utteranceId";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "EB555D6AB84BF7E41BAC2B5D53A5F9B2", hash_generated_field = "F31741CDDA9583A05DBFC466602DB856")

        public static final String KEY_PARAM_VOLUME = "volume";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "5C37A91E922F1CA033CF81267F80980E", hash_generated_field = "5C33025FF7CAEFB03AF35CC41A77E51F")

        public static final String KEY_PARAM_PAN = "pan";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "B9B59CA107B4998520D8F04E86304BB9", hash_generated_field = "9C632C8E548D61E23BCBF91A78385C5A")

        public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.514 -0400", hash_original_field = "5D6A2E8BAB4CD47E940B987CF3C63014", hash_generated_field = "367B7447EF0E1BB5CDEB71ED7EF27786")

        public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    }


    
    private class Connection implements ServiceConnection {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.515 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "D3C3F8FD9BA670292396CDDDD2DBC0CC")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.515 -0400", hash_original_method = "4879E6D30CC79D00A25F9B445CF68B6E", hash_generated_method = "4879E6D30CC79D00A25F9B445CF68B6E")
        public Connection ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.516 -0400", hash_original_method = "E38F495B4498EDF08C66FB9F592C4572", hash_generated_method = "A1514C12F5D6C61A269996643C2C0762")
        public void onServiceConnected(ComponentName name, IBinder service) {
            
            addTaint(name.getTaint());
            synchronized
(mStartLock)            {
    if(mServiceConnection != null)                
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
            
            
            
                
                    
                
                
                
                
                    
                    
                
                    
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.516 -0400", hash_original_method = "9CBB724FFDF56C58A2F363CBB7ADEB66", hash_generated_method = "D28DEE74DED717A18DE07AB51DBABDBD")
        public void onServiceDisconnected(ComponentName name) {
            
            addTaint(name.getTaint());
            synchronized
(mStartLock)            {
                mService = null;
    if(mServiceConnection == this)                
                {
                    mServiceConnection = null;
                } 
            } 
            
            
                
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.516 -0400", hash_original_method = "670DB56217535BA78AC55188B9013676", hash_generated_method = "22BDFB36185642ED4E82BED8A6D53D5B")
        public void disconnect() {
            mContext.unbindService(this);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.516 -0400", hash_original_method = "34464E55B5499CA206CC99D3045C1292", hash_generated_method = "CDC7AD2641E558ECA0F90AC163B9E40A")
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
R var79B35EE005A3F2115C55AE7046E4A0E2_1177946337 =                         errorResult;
                        var79B35EE005A3F2115C55AE7046E4A0E2_1177946337.addTaint(taint);
                        return var79B35EE005A3F2115C55AE7046E4A0E2_1177946337;
                    } 
R varD2997F7A1AE93B1FCC30EEA67FF3D50D_776526598 =                     action.run(mService);
                    varD2997F7A1AE93B1FCC30EEA67FF3D50D_776526598.addTaint(taint);
                    return varD2997F7A1AE93B1FCC30EEA67FF3D50D_776526598;
                } 
            } 
            catch (RemoteException ex)
            {
    if(reconnect)                
                {
                    disconnect();
                    initTts();
                } 
R var79B35EE005A3F2115C55AE7046E4A0E2_357284263 =                 errorResult;
                var79B35EE005A3F2115C55AE7046E4A0E2_357284263.addTaint(taint);
                return var79B35EE005A3F2115C55AE7046E4A0E2_357284263;
            } 
            
            
                
                    
                        
                        
                    
                    
                
            
                
                
                    
                    
                
                
            
        }

        
    }


    
    public static class EngineInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.516 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "B1C3A1439C6538148E2C8C0A71DA201D")

        public String label;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "54B53072540EEEB8F8E9343E71F28176", hash_generated_field = "D1DBA00001B7F415431AD6FCAB5BAA5D")

        public boolean system;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

        public int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_method = "1BD677F38EE0D51841725F2C2D5029FA", hash_generated_method = "1BD677F38EE0D51841725F2C2D5029FA")
        public EngineInfo ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_method = "2BF343FE966C95427B565E993C403E36", hash_generated_method = "8163B73D833CCB4127B27A838BE26A5D")
        @Override
        public String toString() {
String varD2DF1B343E843F1081AD8889C5F4C655_1043290930 =             "EngineInfo{name=" + name + "}";
            varD2DF1B343E843F1081AD8889C5F4C655_1043290930.addTaint(taint);
            return varD2DF1B343E843F1081AD8889C5F4C655_1043290930;
            
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "DF41A127C133B054D95ADD91C88170F4", hash_generated_field = "9FEA0A384A6DC49F3D654A7B0E49ACFB")

    private static final String TAG = "TextToSpeech";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "C8AE4103156B65C0D23556A48DB4D815", hash_generated_field = "9B986A2CF4CE0B3870A44EA118A88E9A")

    public static final int SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "5DDED9E5103DBD4703C0660F86E0B86E", hash_generated_field = "D9FDA3C0E4B8421EF0ECF23EDE3289A4")

    public static final int ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "95588520F32581BA8D1244F13101ED06", hash_generated_field = "02E0C42BFDC9472143A2816BE6A46302")

    public static final int QUEUE_FLUSH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "E3380CB05B87800713541EA7B6C5393B", hash_generated_field = "E3D905B07D88D805D26B80E9C9543333")

    public static final int QUEUE_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "7B7F3B3D69B07673CD2E7AAF005CBF5F", hash_generated_field = "D4957AFE7D527970CF14C5B19ED60003")

    static final int QUEUE_DESTROY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "DFAFB9213D04FA47F5A5F2A4B74F14B3", hash_generated_field = "114C4BE7840CE5276181D4AD399DD60A")

    public static final int LANG_COUNTRY_VAR_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "5FA467857132F3FB084FACD4877020EB", hash_generated_field = "615AF214DE081692194C09BC057B78F6")

    public static final int LANG_COUNTRY_AVAILABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "E8D8099546226BEB455FFD46312483E0", hash_generated_field = "D0C3004A60A5D721A3D561D3F15B8744")

    public static final int LANG_AVAILABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.517 -0400", hash_original_field = "728E1D2145BB05D62DE4ABA628047B9D", hash_generated_field = "811988C198657A72F3A46F0269AEEEC3")

    public static final int LANG_MISSING_DATA = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.518 -0400", hash_original_field = "E4F8C9D14EBD840CD3FB4037BAF176AF", hash_generated_field = "D282ACE529F1D4C71E5D1D903CE29D28")

    public static final int LANG_NOT_SUPPORTED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.518 -0400", hash_original_field = "7D2E96656AB2A31B8BC2DBA52B97A09F", hash_generated_field = "1613EE279914B2EEC593ED6D5A8EDA25")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED =
            "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
}

