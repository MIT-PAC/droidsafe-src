package android.speech.tts;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.470 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.470 -0400", hash_original_field = "94CA83B0A5EF3662095068A2D93D4E51", hash_generated_field = "46824CCAF8D8A297954B79F68288C27C")

    private Connection mServiceConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.470 -0400", hash_original_field = "BD66CA08574E567F4A2FF02EAF3A3C43", hash_generated_field = "9260ADD518F0FEF38A450F7DB53206FF")

    private OnInitListener mInitListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.470 -0400", hash_original_field = "FCC9BC767DCFBBDC0E992E8F8F631777", hash_generated_field = "328E3D7B680D2F02E50F03A1B91A5C91")

    private volatile UtteranceProgressListener mUtteranceProgressListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.470 -0400", hash_original_field = "A566AAD21AECEFD87B9A641763F0E8ED", hash_generated_field = "A8116CC7E9FFC22E32CD58F7221C57D1")

    private final Object mStartLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.470 -0400", hash_original_field = "79A963EB2FE6CF7ED985A37C9C2DAFC8", hash_generated_field = "87C8AA46082F357B5A90BEFDCD55A9CA")

    private String mRequestedEngine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.471 -0400", hash_original_field = "4FBF9E2CF0458E920CECA1122F7CE66F", hash_generated_field = "F6B4C1579EC35D212C4AF2EE4A947247")

    private Map<String, Uri> mEarcons;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.471 -0400", hash_original_field = "DADCFF0BCD3190EF5EA5DAA385F05AFC", hash_generated_field = "AF9F14E0A7A7BBE0D15082F4D775A15F")

    private Map<String, Uri> mUtterances;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.471 -0400", hash_original_field = "2E7257A953F47313410ACCB399EF186C", hash_generated_field = "0509EAD5E22611839DB01FDA008360EE")

    private final Bundle mParams = new Bundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.471 -0400", hash_original_field = "3D23233AD3766EA5A08A04C38A75975D", hash_generated_field = "C4FA3CBED7ED304B229BB483017A66E9")

    private TtsEngines mEnginesHelper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.471 -0400", hash_original_field = "BE0173788749EF3CF5679DF9E1224605", hash_generated_field = "6F81845A3A2771C3EC987E5A01DBA4C6")

    private String mPackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.471 -0400", hash_original_field = "D10648D448DDFF74BD81B300412AA0DA", hash_generated_field = "8E5DC033BD559466A27E8B7E16939D55")

    private volatile String mCurrentEngine = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.471 -0400", hash_original_method = "E5C095C9A34533EB222D42D1A6D92941", hash_generated_method = "F5C7AE788B42B97E7919890D99F1C1CA")
    public  TextToSpeech(Context context, OnInitListener listener) {
        this(context, listener, null);
        addTaint(listener.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.471 -0400", hash_original_method = "894D965EFAB67E7E0E3D1E11B990F0FA", hash_generated_method = "954C0978587FF52E755C15C7B4BA6C9B")
    public  TextToSpeech(Context context, OnInitListener listener, String engine) {
        this(context, listener, engine, null);
        addTaint(engine.getTaint());
        addTaint(listener.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.472 -0400", hash_original_method = "0584A597F5F20737FDED0391417BF29B", hash_generated_method = "87C5710AD5949D036B5FDC6AB2829764")
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
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.472 -0400", hash_original_method = "B3E128BBA0564CAE955B890D71B1CE7C", hash_generated_method = "5AF6905AA3044CDEF025D22B7C1CEDD0")
    private String getPackageName() {
String var5601F77C1E784C31FA233AB799182FA6_1643098705 =         mPackageName;
        var5601F77C1E784C31FA233AB799182FA6_1643098705.addTaint(taint);
        return var5601F77C1E784C31FA233AB799182FA6_1643098705;
        // ---------- Original Method ----------
        //return mPackageName;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.473 -0400", hash_original_method = "001A57975E2E50499F283478CA48737A", hash_generated_method = "99FA7B56A0A7DF121F6A686013D0F9D7")
    private int initTts() {
        if(mRequestedEngine != null && mEnginesHelper.isEngineInstalled(mRequestedEngine))        
        {
            if(connectToEngine(mRequestedEngine))            
            {
                mCurrentEngine = mRequestedEngine;
                int varD0749AABA8B833466DFCBB0428E4F89C_765529569 = (SUCCESS);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1692952966 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1692952966;
            } //End block
        } //End block
        final String defaultEngine = getDefaultEngine();
        if(defaultEngine != null && !defaultEngine.equals(mRequestedEngine))        
        {
            if(connectToEngine(defaultEngine))            
            {
                mCurrentEngine = defaultEngine;
                int varD0749AABA8B833466DFCBB0428E4F89C_494031418 = (SUCCESS);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_307547812 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_307547812;
            } //End block
        } //End block
        final String highestRanked = mEnginesHelper.getHighestRankedEngineName();
        if(highestRanked != null && !highestRanked.equals(mRequestedEngine) &&
                !highestRanked.equals(defaultEngine))        
        {
            if(connectToEngine(highestRanked))            
            {
                mCurrentEngine = highestRanked;
                int varD0749AABA8B833466DFCBB0428E4F89C_513513077 = (SUCCESS);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797836056 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_797836056;
            } //End block
        } //End block
        mCurrentEngine = null;
        dispatchOnInit(ERROR);
        int varBB1CA97EC761FC37101737BA0AA2E7C5_1215944504 = (ERROR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282940231 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_282940231;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.474 -0400", hash_original_method = "5177E4BA973A00FB9C33DC0A5DBEACDB", hash_generated_method = "C8D474BC54338265C8795A39BD2C1210")
    private boolean connectToEngine(String engine) {
        addTaint(engine.getTaint());
        Connection connection = new Connection();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        boolean bound = mContext.bindService(intent, connection, Context.BIND_AUTO_CREATE);
        if(!bound)        
        {
            boolean var68934A3E9455FA72420237EB05902327_2051463792 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_386081845 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_386081845;
        } //End block
        else
        {
            boolean varB326B5062B2F0E69046810717534CB09_1176495535 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_624526007 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_624526007;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.474 -0400", hash_original_method = "16B0CCB3D7329F5127962CE558D4D17C", hash_generated_method = "E21FFB2444D259D2156403B08D3C8F87")
    private void dispatchOnInit(int result) {
        addTaint(result);
        synchronized
(mStartLock)        {
            if(mInitListener != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.476 -0400", hash_original_method = "EAB786CB351424B1FA3879678813021A", hash_generated_method = "5FAD6AB9F593673BFECD98DA9DBEE19F")
    public void shutdown() {
        runActionNoReconnect(new Action<Void>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.476 -0400", hash_original_method = "1C176575622D770489EE559F23BB4FED", hash_generated_method = "DE7FB7F3FBD17AEC9541FC22E34AE18B")
        @Override
        public Void run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            service.setCallback(getPackageName(), null);
            service.stop(getPackageName());
            mServiceConnection.disconnect();
            mServiceConnection = null;
            mCurrentEngine = null;
Void var540C13E9E156B687226421B24F2DF178_1214196210 =             null;
            var540C13E9E156B687226421B24F2DF178_1214196210.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1214196210;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.476 -0400", hash_original_method = "DD10D1EA0D37E9C3175CB1CE81EACE27", hash_generated_method = "FCBD320A3EF2F81DF255ABF28602C43A")
    public int addSpeech(String text, String packagename, int resourceId) {
        addTaint(resourceId);
        addTaint(packagename.getTaint());
        addTaint(text.getTaint());
        synchronized
(mStartLock)        {
            mUtterances.put(text, makeResourceUri(packagename, resourceId));
            int varD0749AABA8B833466DFCBB0428E4F89C_5525726 = (SUCCESS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87613376 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_87613376;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //mUtterances.put(text, makeResourceUri(packagename, resourceId));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.477 -0400", hash_original_method = "DBC13E8086F9460080E153D9CAE05A02", hash_generated_method = "D7FC58D1EB64EC3D11FB033249FCD80B")
    public int addSpeech(String text, String filename) {
        addTaint(filename.getTaint());
        addTaint(text.getTaint());
        synchronized
(mStartLock)        {
            mUtterances.put(text, Uri.parse(filename));
            int varD0749AABA8B833466DFCBB0428E4F89C_409622847 = (SUCCESS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797920457 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1797920457;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mStartLock) {
            //mUtterances.put(text, Uri.parse(filename));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.477 -0400", hash_original_method = "773577F8E212F06A89510B07A5731283", hash_generated_method = "B818EF855D5C53BEB03DA54EE83E4027")
    public int addEarcon(String earcon, String packagename, int resourceId) {
        addTaint(resourceId);
        addTaint(packagename.getTaint());
        addTaint(earcon.getTaint());
        synchronized
(mStartLock)        {
            mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
            int varD0749AABA8B833466DFCBB0428E4F89C_681717962 = (SUCCESS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_949181096 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_949181096;
        } //End block
        // ---------- Original Method ----------
        //synchronized(mStartLock) {
            //mEarcons.put(earcon, makeResourceUri(packagename, resourceId));
            //return SUCCESS;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.477 -0400", hash_original_method = "409D0B7C115347E1FFF71FD2BD1F314E", hash_generated_method = "F0D9489E8E81AF6FA638D7C8470B096C")
    public int addEarcon(String earcon, String filename) {
        addTaint(filename.getTaint());
        addTaint(earcon.getTaint());
        synchronized
(mStartLock)        {
            mEarcons.put(earcon, Uri.parse(filename));
            int varD0749AABA8B833466DFCBB0428E4F89C_998607693 = (SUCCESS);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527484937 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_527484937;
        } //End block
        // ---------- Original Method ----------
        //synchronized(mStartLock) {
            //mEarcons.put(earcon, Uri.parse(filename));
            //return SUCCESS;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.477 -0400", hash_original_method = "276BC175828DCE484EB0703A6A0D8E9B", hash_generated_method = "A29D91D66E98AD3A3417E4FF58164A5F")
    private Uri makeResourceUri(String packageName, int resourceId) {
        addTaint(resourceId);
        addTaint(packageName.getTaint());
Uri var5AA96771068ABD432380D30C1FF16905_972264206 =         new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .encodedAuthority(packageName)
                .appendEncodedPath(String.valueOf(resourceId))
                .build();
        var5AA96771068ABD432380D30C1FF16905_972264206.addTaint(taint);
        return var5AA96771068ABD432380D30C1FF16905_972264206;
        // ---------- Original Method ----------
        //return new Uri.Builder()
                //.scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                //.encodedAuthority(packageName)
                //.appendEncodedPath(String.valueOf(resourceId))
                //.build();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.478 -0400", hash_original_method = "BE0E5C2CBBCD37525836C6DA289D2EEC", hash_generated_method = "FE16B91E07F4F76934319E0BF680AC27")
    public int speak(final String text, final int queueMode, final HashMap<String, String> params) {
        addTaint(params.getTaint());
        addTaint(queueMode);
        addTaint(text.getTaint());
        int var67F606D80913DCFF0FAD355D44879011_1308944481 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.478 -0400", hash_original_method = "7D06D49EA86F29A3C163217832E59726", hash_generated_method = "1EA83F08F72C2F916061C953169D793D")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            Uri utteranceUri = mUtterances.get(text);
            if(utteranceUri != null)            
            {
Integer varC830AAB5FAB696E7256A7C3D283C883D_1783112731 =                 service.playAudio(getPackageName(), utteranceUri, queueMode,
                            getParams(params));
                varC830AAB5FAB696E7256A7C3D283C883D_1783112731.addTaint(taint);
                return varC830AAB5FAB696E7256A7C3D283C883D_1783112731;
            } //End block
            else
            {
Integer var74EFE1A3416A985FD34BFF617FF395BF_236311624 =                 service.speak(getPackageName(), text, queueMode, getParams(params));
                var74EFE1A3416A985FD34BFF617FF395BF_236311624.addTaint(taint);
                return var74EFE1A3416A985FD34BFF617FF395BF_236311624;
            } //End block
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
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375632044 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_375632044;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.479 -0400", hash_original_method = "F18AB3CD06A1E20DE6BD7099833B6FEC", hash_generated_method = "F4F327327BD43E35156CE6F68DB38993")
    public int playEarcon(final String earcon, final int queueMode,
            final HashMap<String, String> params) {
        addTaint(params.getTaint());
        addTaint(queueMode);
        addTaint(earcon.getTaint());
        int var00E14815AC1E4BCC1B8F3491C7EAD882_1409996302 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.479 -0400", hash_original_method = "6A26B14D42F3FBBE45C132D11F693742", hash_generated_method = "B7F511E2E1D8F25E305BF1B6757A0F6A")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            Uri earconUri = mEarcons.get(earcon);
            if(earconUri == null)            
            {
Integer var3F5FB64C1A12F0A78F9609D9CC474A24_1311206824 =                 ERROR;
                var3F5FB64C1A12F0A78F9609D9CC474A24_1311206824.addTaint(taint);
                return var3F5FB64C1A12F0A78F9609D9CC474A24_1311206824;
            } //End block
Integer var3F4F7F85D5B430AD0CF35D2C5F73E872_378350826 =             service.playAudio(getPackageName(), earconUri, queueMode,
                        getParams(params));
            var3F4F7F85D5B430AD0CF35D2C5F73E872_378350826.addTaint(taint);
            return var3F4F7F85D5B430AD0CF35D2C5F73E872_378350826;
            // ---------- Original Method ----------
            //Uri earconUri = mEarcons.get(earcon);
            //if (earconUri == null) {
                    //return ERROR;
                //}
            //return service.playAudio(getPackageName(), earconUri, queueMode,
                        //getParams(params));
        }
}, ERROR, "playEarcon"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1395032468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1395032468;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.479 -0400", hash_original_method = "94C759FE8B677E32982F42F6A676D86E", hash_generated_method = "EBF68524185B5FC79E6FB052904E922C")
    public int playSilence(final long durationInMs, final int queueMode,
            final HashMap<String, String> params) {
        addTaint(params.getTaint());
        addTaint(queueMode);
        addTaint(durationInMs);
        int var2897FAD1804EAFB14469219582A5A336_1770464438 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.479 -0400", hash_original_method = "78C333BA11B47CA10C93733938393F3E", hash_generated_method = "AE755088C1B2B81028EA3DF8E86F709A")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
Integer varF960BC12575747C24E20C0225559D5BB_1920124868 =             service.playSilence(getPackageName(), durationInMs, queueMode,
                        getParams(params));
            varF960BC12575747C24E20C0225559D5BB_1920124868.addTaint(taint);
            return varF960BC12575747C24E20C0225559D5BB_1920124868;
            // ---------- Original Method ----------
            //return service.playSilence(getPackageName(), durationInMs, queueMode,
                        //getParams(params));
        }
}, ERROR, "playSilence"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567689455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1567689455;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.playSilence(getPackageName(), durationInMs, queueMode,
                        //getParams(params));
            //}
        //}, ERROR, "playSilence");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.480 -0400", hash_original_method = "8AF2E385B6F026EB817E9FE98AB99B1D", hash_generated_method = "0E0207C257D249705EC78A68E1927AC6")
    public Set<String> getFeatures(final Locale locale) {
        addTaint(locale.getTaint());
Set<String> var628544D9C2D4854478D09F82EACFFF99_1523039023 =         runAction(new Action<Set<String>>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.479 -0400", hash_original_method = "F0504A62951AE3DA8704A40623A9C42B", hash_generated_method = "9B7DA26F73ABBC69713220E1A71FE60A")
        @Override
        public Set<String> run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            String[] features = service.getFeaturesForLanguage(
                        locale.getISO3Language(), locale.getISO3Country(), locale.getVariant());
            if(features != null)            
            {
                final Set<String> featureSet = new HashSet<String>();
                Collections.addAll(featureSet, features);
Set<String> var5857656592B7BBF1A241131B963ED712_110507434 =                 featureSet;
                var5857656592B7BBF1A241131B963ED712_110507434.addTaint(taint);
                return var5857656592B7BBF1A241131B963ED712_110507434;
            } //End block
Set<String> var540C13E9E156B687226421B24F2DF178_1778072 =             null;
            var540C13E9E156B687226421B24F2DF178_1778072.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1778072;
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
}, null, "getFeatures");
        var628544D9C2D4854478D09F82EACFFF99_1523039023.addTaint(taint);
        return var628544D9C2D4854478D09F82EACFFF99_1523039023;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.480 -0400", hash_original_method = "DC605D9F82407CF596B06CFECEFBD8A5", hash_generated_method = "F49CBE3DA618CF82BD6FF72757F4D073")
    public boolean isSpeaking() {
        boolean var66C59FC12C5790A44C2216988A712382_404610934 = (runAction(new Action<Boolean>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.480 -0400", hash_original_method = "CDD6871E0A3D820171A5453DF320B8D3", hash_generated_method = "A8A2C9A192ADD33079177E820B9C09E2")
        @Override
        public Boolean run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
Boolean var8E649280B66AA64AE13D2F0B9F1A2024_1162440999 =             service.isSpeaking();
            var8E649280B66AA64AE13D2F0B9F1A2024_1162440999.addTaint(taint);
            return var8E649280B66AA64AE13D2F0B9F1A2024_1162440999;
            // ---------- Original Method ----------
            //return service.isSpeaking();
        }
}, false, "isSpeaking"));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_248778419 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_248778419;
        // ---------- Original Method ----------
        //return runAction(new Action<Boolean>() {
            //@Override
            //public Boolean run(ITextToSpeechService service) throws RemoteException {
                //return service.isSpeaking();
            //}
        //}, false, "isSpeaking");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.480 -0400", hash_original_method = "1B011279D3385FBEA81C0EEE9DDE31E7", hash_generated_method = "21CFA2A9CD7496EDB45108D9BA348E37")
    public int stop() {
        int var4F2D875BADA56F7DF942831817D092D9_1641920473 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.480 -0400", hash_original_method = "C3E115845E07ACC22BB6BDAD6EAAC990", hash_generated_method = "44BCFA108D0D53ECED992AF0F35A94A7")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
Integer varE12943068FF9423862F1428EAB10C44E_993820268 =             service.stop(getPackageName());
            varE12943068FF9423862F1428EAB10C44E_993820268.addTaint(taint);
            return varE12943068FF9423862F1428EAB10C44E_993820268;
            // ---------- Original Method ----------
            //return service.stop(getPackageName());
        }
}, ERROR, "stop"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410304070 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_410304070;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.stop(getPackageName());
            //}
        //}, ERROR, "stop");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.480 -0400", hash_original_method = "6950E84EE314E7032010233B0706B078", hash_generated_method = "1B3512A0D8D3A9C33619D7BF468B5188")
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
                } //End block
                int varD0749AABA8B833466DFCBB0428E4F89C_1751311651 = (SUCCESS);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_39528037 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_39528037;
            } //End block
        } //End block
        int varBB1CA97EC761FC37101737BA0AA2E7C5_319592040 = (ERROR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238345254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1238345254;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.481 -0400", hash_original_method = "7DADB23AB82E5180649E2697B1338160", hash_generated_method = "17E8ED2970E43943D01B43EB40F5A1CD")
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
                } //End block
                int varD0749AABA8B833466DFCBB0428E4F89C_1794404569 = (SUCCESS);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163589123 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1163589123;
            } //End block
        } //End block
        int varBB1CA97EC761FC37101737BA0AA2E7C5_1682669223 = (ERROR);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303863485 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1303863485;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.481 -0400", hash_original_method = "6F277B1B16E884F81974EA73065A64D8", hash_generated_method = "7C5DD4F2F20B8EA806FEEAD16A4A1484")
    public String getCurrentEngine() {
String varF0379D96643374605D6BA399231446A3_2085603067 =         mCurrentEngine;
        varF0379D96643374605D6BA399231446A3_2085603067.addTaint(taint);
        return varF0379D96643374605D6BA399231446A3_2085603067;
        // ---------- Original Method ----------
        //return mCurrentEngine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.481 -0400", hash_original_method = "4B10A46E0E63D1391FC966E12E9B561D", hash_generated_method = "D0A550B65685F2F756E50EA3CAD43137")
    public int setLanguage(final Locale loc) {
        addTaint(loc.getTaint());
        int varB5A720CBA5BFC3F56C9E3EB7985F8D67_1526274301 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.481 -0400", hash_original_method = "0CBE42B90B008DE7C85EE0BE4FA8A569", hash_generated_method = "D649EF105FD9A3B78AD6963B7095D94E")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            if(loc == null)            
            {
Integer var9D0095E272DA84611754C424FD1F1417_1996244126 =                 LANG_NOT_SUPPORTED;
                var9D0095E272DA84611754C424FD1F1417_1996244126.addTaint(taint);
                return var9D0095E272DA84611754C424FD1F1417_1996244126;
            } //End block
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
                    } //End block
                } //End block
                mParams.putString(Engine.KEY_PARAM_LANGUAGE, language);
                mParams.putString(Engine.KEY_PARAM_COUNTRY, country);
                mParams.putString(Engine.KEY_PARAM_VARIANT, variant);
            } //End block
Integer varDC838461EE2FA0CA4C9BBB70A15456B0_887135832 =             result;
            varDC838461EE2FA0CA4C9BBB70A15456B0_887135832.addTaint(taint);
            return varDC838461EE2FA0CA4C9BBB70A15456B0_887135832;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
}, LANG_NOT_SUPPORTED, "setLanguage"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354786726 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_354786726;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.482 -0400", hash_original_method = "BC427E909E00C5BE5A5F111E336651C0", hash_generated_method = "68011A46608C6DEF97D433B336D7A9B3")
    public Locale getLanguage() {
Locale var0611285425B54BCEC8D4A31276F61EE9_2012770969 =         runAction(new Action<Locale>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.482 -0400", hash_original_method = "419A6331670010A27050C72F09FCFBF2", hash_generated_method = "B24223BA29AEEEA930B65C8D77EA25B8")
        @Override
        public Locale run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
            String[] locStrings = service.getLanguage();
            if(locStrings != null && locStrings.length == 3)            
            {
Locale varB43BF46312C2A6C29483921803035C51_10750041 =                 new Locale(locStrings[0], locStrings[1], locStrings[2]);
                varB43BF46312C2A6C29483921803035C51_10750041.addTaint(taint);
                return varB43BF46312C2A6C29483921803035C51_10750041;
            } //End block
Locale var540C13E9E156B687226421B24F2DF178_1383765164 =             null;
            var540C13E9E156B687226421B24F2DF178_1383765164.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1383765164;
            // ---------- Original Method ----------
            //String[] locStrings = service.getLanguage();
            //if (locStrings != null && locStrings.length == 3) {
                    //return new Locale(locStrings[0], locStrings[1], locStrings[2]);
                //}
            //return null;
        }
}, null, "getLanguage");
        var0611285425B54BCEC8D4A31276F61EE9_2012770969.addTaint(taint);
        return var0611285425B54BCEC8D4A31276F61EE9_2012770969;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.483 -0400", hash_original_method = "4344244CB1F796DE537DEBF5170866A9", hash_generated_method = "738BBD58A88C2A1CBD25A49D014A7C36")
    public int isLanguageAvailable(final Locale loc) {
        addTaint(loc.getTaint());
        int varE5C435983FAF064C8A7CC3A6EA16C575_1771874008 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.482 -0400", hash_original_method = "104F6D4E3824B9F3A36823FE96275A8A", hash_generated_method = "685FF0479DDFC7D9EF5EEC45FFFBA12F")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
Integer varD84127CF44AD07A1F9D09370E321480F_1832090826 =             service.isLanguageAvailable(loc.getISO3Language(),
                        loc.getISO3Country(), loc.getVariant());
            varD84127CF44AD07A1F9D09370E321480F_1832090826.addTaint(taint);
            return varD84127CF44AD07A1F9D09370E321480F_1832090826;
            // ---------- Original Method ----------
            //return service.isLanguageAvailable(loc.getISO3Language(),
                        //loc.getISO3Country(), loc.getVariant());
        }
}, LANG_NOT_SUPPORTED, "isLanguageAvailable"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81612289 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_81612289;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.isLanguageAvailable(loc.getISO3Language(),
                        //loc.getISO3Country(), loc.getVariant());
            //}
        //}, LANG_NOT_SUPPORTED, "isLanguageAvailable");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.483 -0400", hash_original_method = "59A7F0A106B55E8A59A4D44C2073C3C6", hash_generated_method = "8662AE02EA07D69AF8E450DA67E09AE7")
    public int synthesizeToFile(final String text, final HashMap<String, String> params,
            final String filename) {
        addTaint(filename.getTaint());
        addTaint(params.getTaint());
        addTaint(text.getTaint());
        int var09BE08403C7D342B52A0E608B00A4547_1510698885 = (runAction(new Action<Integer>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.483 -0400", hash_original_method = "126F93B055F255BA3903970B4BD95F1E", hash_generated_method = "FC8010A027935496899CA8905888D989")
        @Override
        public Integer run(ITextToSpeechService service) throws RemoteException {
            addTaint(service.getTaint());
Integer varC17144DAEB3B66EB3DD5823B0FC8BDAB_1073849130 =             service.synthesizeToFile(getPackageName(), text, filename,
                        getParams(params));
            varC17144DAEB3B66EB3DD5823B0FC8BDAB_1073849130.addTaint(taint);
            return varC17144DAEB3B66EB3DD5823B0FC8BDAB_1073849130;
            // ---------- Original Method ----------
            //return service.synthesizeToFile(getPackageName(), text, filename,
                        //getParams(params));
        }
}, ERROR, "synthesizeToFile"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840353426 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1840353426;
        // ---------- Original Method ----------
        //return runAction(new Action<Integer>() {
            //@Override
            //public Integer run(ITextToSpeechService service) throws RemoteException {
                //return service.synthesizeToFile(getPackageName(), text, filename,
                        //getParams(params));
            //}
        //}, ERROR, "synthesizeToFile");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.484 -0400", hash_original_method = "F4A729CBEB92036D830EC51C9E6B27A9", hash_generated_method = "9309CF08BD54BD7F6007A875E3D93999")
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
                    } //End block
                } //End block
            } //End block
Bundle var7B2862195409742DCA365D8C6330AB92_1386509759 =             bundle;
            var7B2862195409742DCA365D8C6330AB92_1386509759.addTaint(taint);
            return var7B2862195409742DCA365D8C6330AB92_1386509759;
        } //End block
        else
        {
Bundle var1ECA468F8F118273F13D0667CCE29D60_195731346 =             mParams;
            var1ECA468F8F118273F13D0667CCE29D60_195731346.addTaint(taint);
            return var1ECA468F8F118273F13D0667CCE29D60_195731346;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.484 -0400", hash_original_method = "CA756292003AA5F2AACD5FD8062D880F", hash_generated_method = "83FC21CCF2FEF6EF908F8F8C5B3944CF")
    private void copyStringParam(Bundle bundle, HashMap<String, String> params, String key) {
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        addTaint(bundle.getTaint());
        String value = params.get(key);
        if(value != null)        
        {
            bundle.putString(key, value);
        } //End block
        // ---------- Original Method ----------
        //String value = params.get(key);
        //if (value != null) {
            //bundle.putString(key, value);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.484 -0400", hash_original_method = "D148C993B4D17B611EC6A14A9B3B3D7B", hash_generated_method = "0BAF632F1BCB4B1B2EB236F5BF94314F")
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
            } //End block
            catch (NumberFormatException ex)
            {
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.484 -0400", hash_original_method = "335CA474B2AA628361250A653672DD72", hash_generated_method = "0F4C694C627AD9B09B48050637C517F4")
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
            } //End block
            catch (NumberFormatException ex)
            {
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.484 -0400", hash_original_method = "24D73865C05CC11CAA8C791D8BA56024", hash_generated_method = "404032C7B27C6F77404943276B12BB6E")
    @Deprecated
    public int setOnUtteranceCompletedListener(final OnUtteranceCompletedListener listener) {
        mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        int var29748D5FD7A8274F3DF6C0697E48D88B_497395026 = (TextToSpeech.SUCCESS);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216873371 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_216873371;
        // ---------- Original Method ----------
        //mUtteranceProgressListener = UtteranceProgressListener.from(listener);
        //return TextToSpeech.SUCCESS;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.485 -0400", hash_original_method = "98074E19965AB76BE23153F0217E2857", hash_generated_method = "59B81E59DE5F25A0AE1ED610D6CDAF28")
    public int setOnUtteranceProgressListener(UtteranceProgressListener listener) {
        mUtteranceProgressListener = listener;
        int var29748D5FD7A8274F3DF6C0697E48D88B_1738684598 = (TextToSpeech.SUCCESS);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590064984 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_590064984;
        // ---------- Original Method ----------
        //mUtteranceProgressListener = listener;
        //return TextToSpeech.SUCCESS;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.485 -0400", hash_original_method = "06FE1E6C6795B03B25AD43DFED268D92", hash_generated_method = "F1965A8EF8C70F530856E4AB648FA978")
    @Deprecated
    public int setEngineByPackageName(String enginePackageName) {
        mRequestedEngine = enginePackageName;
        int varA378E50E83B3BEF2BF06C44276D52CC5_771764387 = (initTts());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547774731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1547774731;
        // ---------- Original Method ----------
        //mRequestedEngine = enginePackageName;
        //return initTts();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.485 -0400", hash_original_method = "AAA28EF74B57D47AEDCF93243FD04D81", hash_generated_method = "4114E86BC071A807E4523928F29D245B")
    public String getDefaultEngine() {
String varF168E94075BBE3E03A9472F1231D848D_171082847 =         mEnginesHelper.getDefaultEngine();
        varF168E94075BBE3E03A9472F1231D848D_171082847.addTaint(taint);
        return varF168E94075BBE3E03A9472F1231D848D_171082847;
        // ---------- Original Method ----------
        //return mEnginesHelper.getDefaultEngine();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.485 -0400", hash_original_method = "FDBC18F088428D1AA4FA407CF8A38EB5", hash_generated_method = "CFABFD8D615BE917B0EABF94766312CD")
    public boolean areDefaultsEnforced() {
        boolean var68934A3E9455FA72420237EB05902327_132125007 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482258212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482258212;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.485 -0400", hash_original_method = "C282EF17EB1B4600865CB51DA0934709", hash_generated_method = "45FD71C57C19F87B860E1BBC1C4F1DB4")
    public List<EngineInfo> getEngines() {
List<EngineInfo> var581E578A303E6D7E78C66653FD081751_674990620 =         mEnginesHelper.getEngines();
        var581E578A303E6D7E78C66653FD081751_674990620.addTaint(taint);
        return var581E578A303E6D7E78C66653FD081751_674990620;
        // ---------- Original Method ----------
        //return mEnginesHelper.getEngines();
    }

    
    public class Engine {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.485 -0400", hash_original_method = "0CEE966FD083EAF9A38425EF355FEEF7", hash_generated_method = "0CEE966FD083EAF9A38425EF355FEEF7")
        public Engine ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.485 -0400", hash_original_field = "36D45D439A9D88F92C91EED7F227B118", hash_generated_field = "6EA685DC1F94714F1A1A1A053FC21028")

        public static final int DEFAULT_RATE = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.485 -0400", hash_original_field = "735042F181F97049F645A49551694C8F", hash_generated_field = "7265570D9BCE2101E8993107FABA1337")

        public static final int DEFAULT_PITCH = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "2CCE70ADE73106C43ECEE5E8A9205C7A", hash_generated_field = "95742929B161124D7ABDF4B245140DE7")

        public static final float DEFAULT_VOLUME = 1.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "1B7AB37CA837BE7D293E3424675F31F6", hash_generated_field = "BDDAA621A92D5CA41E24125645C10B9B")

        public static final float DEFAULT_PAN = 0.0f;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "24C227C2F4C89803E4CC9D1CA4639012", hash_generated_field = "79A00612A369353FB0B563BBFBDD7A1F")

        public static final int USE_DEFAULTS = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "963BFD7556945F0ADCDB7063AA317405", hash_generated_field = "52D9AB195E713E24D836C4A49CC0D622")

        @Deprecated
        public static final String DEFAULT_ENGINE = "com.svox.pico";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "54C932376EBA54F9168634618A59869D", hash_generated_field = "C75C9F49D040B89D31A5EEE24181A5F2")

        public static final int DEFAULT_STREAM = AudioManager.STREAM_MUSIC;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "E08E1E62A1BA16AAB29D7A9A032DCA62", hash_generated_field = "C254DAAF5EBFA8002B27291ACC23702C")

        public static final int CHECK_VOICE_DATA_PASS = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "EE2889DAB98E247108FD560D3EFB02FD", hash_generated_field = "E9C03161A9F0FFF5472A0040222D4C52")

        public static final int CHECK_VOICE_DATA_FAIL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "2DAAF7CA0FE4E57592622B27A82A704D", hash_generated_field = "431FD9B6D302AD606FFE065DF75DD2FA")

        public static final int CHECK_VOICE_DATA_BAD_DATA = -1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "CFC6EC4DDDF9F323DBC81D082171E33E", hash_generated_field = "7387564E7167154EEFED8705FCA0EED8")

        public static final int CHECK_VOICE_DATA_MISSING_DATA = -2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "8D2D3E2E79C2C4E707239463D369E33B", hash_generated_field = "183E08CD13799093F5F5A44B05FDE73C")

        public static final int CHECK_VOICE_DATA_MISSING_VOLUME = -3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "43EE5A08705D902AFADBFC04343199B2", hash_generated_field = "CAF4E59B3718CCEA9FF9E5188B9F6370")

        @SdkConstant(SdkConstantType.SERVICE_ACTION)
        public static final String INTENT_ACTION_TTS_SERVICE =
                "android.intent.action.TTS_SERVICE";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "E4042E25AFA9C947989DCC050E289401", hash_generated_field = "1838FC1E408F29335D36A08788A826E6")

        public static final String SERVICE_META_DATA = "android.speech.tts";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "A6833C0165AB755C6E068259E162C946", hash_generated_field = "AD45F25D873943976C37BF808E1956BE")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_INSTALL_TTS_DATA =
                "android.speech.tts.engine.INSTALL_TTS_DATA";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "D6AE8B393AF81687E39AF98587E4CABC", hash_generated_field = "A33F17727F43DBD7A47E893BB9B716B9")

        @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
        public static final String ACTION_TTS_DATA_INSTALLED =
                "android.speech.tts.engine.TTS_DATA_INSTALLED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "FA190AA53E599DBC899F53B55858698C", hash_generated_field = "43F20E850CE384CB5D9C74DD369FDD87")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_CHECK_TTS_DATA =
                "android.speech.tts.engine.CHECK_TTS_DATA";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "5C6C6397C49314D5F5E204CA1933345E", hash_generated_field = "58E16B540735E811A37625B0342CFA0F")

        @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
        public static final String ACTION_GET_SAMPLE_TEXT =
                "android.speech.tts.engine.GET_SAMPLE_TEXT";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "9F649196082E67572C2349155C9919D2", hash_generated_field = "178CAFEE370EC9E79529912F27523F36")

        public static final String EXTRA_VOICE_DATA_ROOT_DIRECTORY = "dataRoot";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "EFCBBB44D3D24A3D84E5ABC46FC70857", hash_generated_field = "2FCEBB35020F29546E39463BDD214A73")

        public static final String EXTRA_VOICE_DATA_FILES = "dataFiles";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "1DC90AA7734216663D84607F446D95B3", hash_generated_field = "23CB204D3DC0650A224FB5ABA98F25A7")

        public static final String EXTRA_VOICE_DATA_FILES_INFO = "dataFilesInfo";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "FD4F2914F7FB71A96D2E879989B79136", hash_generated_field = "A5FF7832C171B046C21F825764FE8230")

        public static final String EXTRA_AVAILABLE_VOICES = "availableVoices";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "25CADBA271F43B9ED671E6822C5D1A88", hash_generated_field = "AC4770FDD8C95CC92539FC82143B39C5")

        public static final String EXTRA_UNAVAILABLE_VOICES = "unavailableVoices";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "C44D63A48B4EB093B375BC969B445992", hash_generated_field = "C8E0905A88A840D679AC2FF9508E3712")

        public static final String EXTRA_CHECK_VOICE_DATA_FOR = "checkVoiceDataFor";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "85A22E5221C66B5FEA03947CDBB2D9D0", hash_generated_field = "566A9FB915E742DB0D9FCBB9613D8A98")

        public static final String EXTRA_TTS_DATA_INSTALLED = "dataInstalled";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "F36FF974081651AF068D67E5D4C4C65B", hash_generated_field = "9662C467B57A79462A5A958B925CD456")

        public static final String KEY_PARAM_RATE = "rate";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "A30E5701A5E3DB6B461EF4FA9632FED2", hash_generated_field = "41A112801807BF60F6B64B56EABC75A7")

        public static final String KEY_PARAM_LANGUAGE = "language";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "049E0A857DB03C5705F89387DBFA3F94", hash_generated_field = "B9529957E3604F14146602846E9977A5")

        public static final String KEY_PARAM_COUNTRY = "country";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "5DD9CAE974E3E4DF07273B713C0141E3", hash_generated_field = "194C150941509AFA9F06806544278558")

        public static final String KEY_PARAM_VARIANT = "variant";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "4BF977BE522A7D4FAECCE001402B4B22", hash_generated_field = "5790995E2173B750C19C7F0DF730BD18")

        public static final String KEY_PARAM_ENGINE = "engine";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "8EFCD27051CF12277949A1C6787CF4CA", hash_generated_field = "3BDB1A8EA9944800172EB2E01D630D39")

        public static final String KEY_PARAM_PITCH = "pitch";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "82BD90E3DC3CCF8584C41564CAE4AAB5", hash_generated_field = "AA44CC9D49E0D6103F2E361CC4DC18B0")

        public static final String KEY_PARAM_STREAM = "streamType";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "1A45AC9684F0F72F5EB630E624D8FB7C", hash_generated_field = "D01CCD0CAFBD7B77262BEE4DF757451B")

        public static final String KEY_PARAM_UTTERANCE_ID = "utteranceId";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "EB555D6AB84BF7E41BAC2B5D53A5F9B2", hash_generated_field = "F31741CDDA9583A05DBFC466602DB856")

        public static final String KEY_PARAM_VOLUME = "volume";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "5C37A91E922F1CA033CF81267F80980E", hash_generated_field = "5C33025FF7CAEFB03AF35CC41A77E51F")

        public static final String KEY_PARAM_PAN = "pan";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "B9B59CA107B4998520D8F04E86304BB9", hash_generated_field = "9C632C8E548D61E23BCBF91A78385C5A")

        public static final String KEY_FEATURE_NETWORK_SYNTHESIS = "networkTts";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.486 -0400", hash_original_field = "5D6A2E8BAB4CD47E940B987CF3C63014", hash_generated_field = "367B7447EF0E1BB5CDEB71ED7EF27786")

        public static final String KEY_FEATURE_EMBEDDED_SYNTHESIS = "embeddedTts";
    }


    
    private class Connection implements ServiceConnection {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.487 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "D3C3F8FD9BA670292396CDDDD2DBC0CC")

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


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.487 -0400", hash_original_method = "E38F495B4498EDF08C66FB9F592C4572", hash_generated_method = "A1514C12F5D6C61A269996643C2C0762")
        public void onServiceConnected(ComponentName name, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(name.getTaint());
            synchronized
(mStartLock)            {
                if(mServiceConnection != null)                
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.487 -0400", hash_original_method = "9CBB724FFDF56C58A2F363CBB7ADEB66", hash_generated_method = "D28DEE74DED717A18DE07AB51DBABDBD")
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(name.getTaint());
            synchronized
(mStartLock)            {
                mService = null;
                if(mServiceConnection == this)                
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.487 -0400", hash_original_method = "670DB56217535BA78AC55188B9013676", hash_generated_method = "22BDFB36185642ED4E82BED8A6D53D5B")
        public void disconnect() {
            mContext.unbindService(this);
            // ---------- Original Method ----------
            //mContext.unbindService(this);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "B1C3A1439C6538148E2C8C0A71DA201D")

        public String label;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

        public int icon;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "54B53072540EEEB8F8E9343E71F28176", hash_generated_field = "D1DBA00001B7F415431AD6FCAB5BAA5D")

        public boolean system;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

        public int priority;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_method = "1BD677F38EE0D51841725F2C2D5029FA", hash_generated_method = "1BD677F38EE0D51841725F2C2D5029FA")
        public EngineInfo ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_method = "2BF343FE966C95427B565E993C403E36", hash_generated_method = "9E1D36E0E7345ABFFA2A1200DE7630F0")
        @Override
        public String toString() {
String varD2DF1B343E843F1081AD8889C5F4C655_1094249298 =             "EngineInfo{name=" + name + "}";
            varD2DF1B343E843F1081AD8889C5F4C655_1094249298.addTaint(taint);
            return varD2DF1B343E843F1081AD8889C5F4C655_1094249298;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "DF41A127C133B054D95ADD91C88170F4", hash_generated_field = "9FEA0A384A6DC49F3D654A7B0E49ACFB")

    private static final String TAG = "TextToSpeech";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "C8AE4103156B65C0D23556A48DB4D815", hash_generated_field = "9B986A2CF4CE0B3870A44EA118A88E9A")

    public static final int SUCCESS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "5DDED9E5103DBD4703C0660F86E0B86E", hash_generated_field = "D9FDA3C0E4B8421EF0ECF23EDE3289A4")

    public static final int ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "95588520F32581BA8D1244F13101ED06", hash_generated_field = "02E0C42BFDC9472143A2816BE6A46302")

    public static final int QUEUE_FLUSH = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "E3380CB05B87800713541EA7B6C5393B", hash_generated_field = "E3D905B07D88D805D26B80E9C9543333")

    public static final int QUEUE_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "7B7F3B3D69B07673CD2E7AAF005CBF5F", hash_generated_field = "D4957AFE7D527970CF14C5B19ED60003")

    static final int QUEUE_DESTROY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "DFAFB9213D04FA47F5A5F2A4B74F14B3", hash_generated_field = "114C4BE7840CE5276181D4AD399DD60A")

    public static final int LANG_COUNTRY_VAR_AVAILABLE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "5FA467857132F3FB084FACD4877020EB", hash_generated_field = "615AF214DE081692194C09BC057B78F6")

    public static final int LANG_COUNTRY_AVAILABLE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "E8D8099546226BEB455FFD46312483E0", hash_generated_field = "D0C3004A60A5D721A3D561D3F15B8744")

    public static final int LANG_AVAILABLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "728E1D2145BB05D62DE4ABA628047B9D", hash_generated_field = "811988C198657A72F3A46F0269AEEEC3")

    public static final int LANG_MISSING_DATA = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "E4F8C9D14EBD840CD3FB4037BAF176AF", hash_generated_field = "D282ACE529F1D4C71E5D1D903CE29D28")

    public static final int LANG_NOT_SUPPORTED = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.488 -0400", hash_original_field = "7D2E96656AB2A31B8BC2DBA52B97A09F", hash_generated_field = "1613EE279914B2EEC593ED6D5A8EDA25")

    @SdkConstant(SdkConstantType.BROADCAST_INTENT_ACTION)
    public static final String ACTION_TTS_QUEUE_PROCESSING_COMPLETED =
            "android.speech.tts.TTS_QUEUE_PROCESSING_COMPLETED";
}

