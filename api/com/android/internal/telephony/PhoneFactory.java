package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;

import com.android.internal.telephony.cdma.CDMALTEPhone;
import com.android.internal.telephony.cdma.CDMAPhone;
import com.android.internal.telephony.gsm.GSMPhone;
import com.android.internal.telephony.sip.SipPhone;
import com.android.internal.telephony.sip.SipPhoneFactory;




public class PhoneFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.753 -0400", hash_original_method = "BADF3E1DCB0337DAED03CEBED853A313", hash_generated_method = "BADF3E1DCB0337DAED03CEBED853A313")
    public PhoneFactory ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    public static void makeDefaultPhones(Context context) {
        makeDefaultPhone(context);
    }

    
    @DSModeled(DSC.BAN)
    public static void makeDefaultPhone(Context context) {
        synchronized(Phone.class) {
            if (!sMadeDefaults) {
                sLooper = Looper.myLooper();
                sContext = context;
                if (sLooper == null) {
                    throw new RuntimeException(
                        "PhoneFactory.makeDefaultPhone must be called from Looper thread");
                }
                int retryCount = 0;
                for(;;) {
                    boolean hasException = false;
                    retryCount ++;
                    try {
                        new LocalServerSocket("com.android.internal.telephony");
                    } catch (java.io.IOException ex) {
                        hasException = true;
                    }
                    if ( !hasException ) {
                        break;
                    } else if (retryCount > SOCKET_OPEN_MAX_RETRY) {
                        throw new RuntimeException("PhoneFactory probably already running");
                    } else {
                        try {
                            Thread.sleep(SOCKET_OPEN_RETRY_MILLIS);
                        } catch (InterruptedException er) {
                        }
                    }
                }
                sPhoneNotifier = new DefaultPhoneNotifier();
                int preferredNetworkMode = RILConstants.PREFERRED_NETWORK_MODE;
                if (BaseCommands.getLteOnCdmaModeStatic() == Phone.LTE_ON_CDMA_TRUE) {
                    preferredNetworkMode = Phone.NT_MODE_GLOBAL;
                }
                int networkMode = Settings.Secure.getInt(context.getContentResolver(),
                        Settings.Secure.PREFERRED_NETWORK_MODE, preferredNetworkMode);
                Log.i(LOG_TAG, "Network Mode set to " + Integer.toString(networkMode));
                int cdmaSubscription;
                int lteOnCdma = BaseCommands.getLteOnCdmaModeStatic();
                switch (lteOnCdma) {
                    case Phone.LTE_ON_CDMA_FALSE:
                        cdmaSubscription = RILConstants.SUBSCRIPTION_FROM_NV;
                        Log.i(LOG_TAG, "lteOnCdma is 0 use SUBSCRIPTION_FROM_NV");
                        break;
                    case Phone.LTE_ON_CDMA_TRUE:
                        cdmaSubscription = RILConstants.SUBSCRIPTION_FROM_RUIM;
                        Log.i(LOG_TAG, "lteOnCdma is 1 use SUBSCRIPTION_FROM_RUIM");
                        break;
                    case Phone.LTE_ON_CDMA_UNKNOWN:
                    default:
                        cdmaSubscription = Settings.Secure.getInt(context.getContentResolver(),
                                Settings.Secure.PREFERRED_CDMA_SUBSCRIPTION,
                                preferredCdmaSubscription);
                        Log.i(LOG_TAG, "lteOnCdma not set, using PREFERRED_CDMA_SUBSCRIPTION");
                        break;
                }
                Log.i(LOG_TAG, "Cdma Subscription set to " + cdmaSubscription);
                sCommandsInterface = new RIL(context, networkMode, cdmaSubscription);
                int phoneType = getPhoneType(networkMode);
                if (phoneType == Phone.PHONE_TYPE_GSM) {
                    Log.i(LOG_TAG, "Creating GSMPhone");
                    sProxyPhone = new PhoneProxy(new GSMPhone(context,
                            sCommandsInterface, sPhoneNotifier));
                } else if (phoneType == Phone.PHONE_TYPE_CDMA) {
                    switch (BaseCommands.getLteOnCdmaModeStatic()) {
                        case Phone.LTE_ON_CDMA_TRUE:
                            Log.i(LOG_TAG, "Creating CDMALTEPhone");
                            sProxyPhone = new PhoneProxy(new CDMALTEPhone(context,
                                sCommandsInterface, sPhoneNotifier));
                            break;
                        case Phone.LTE_ON_CDMA_FALSE:
                        default:
                            Log.i(LOG_TAG, "Creating CDMAPhone");
                            sProxyPhone = new PhoneProxy(new CDMAPhone(context,
                                    sCommandsInterface, sPhoneNotifier));
                            break;
                    }
                }
                sMadeDefaults = true;
            }
        }
    }

    
    @DSModeled(DSC.BAN)
    public static int getPhoneType(int networkMode) {
        switch(networkMode) {
        case RILConstants.NETWORK_MODE_CDMA:
        case RILConstants.NETWORK_MODE_CDMA_NO_EVDO:
        case RILConstants.NETWORK_MODE_EVDO_NO_CDMA:
            return Phone.PHONE_TYPE_CDMA;
        case RILConstants.NETWORK_MODE_WCDMA_PREF:
        case RILConstants.NETWORK_MODE_GSM_ONLY:
        case RILConstants.NETWORK_MODE_WCDMA_ONLY:
        case RILConstants.NETWORK_MODE_GSM_UMTS:
            return Phone.PHONE_TYPE_GSM;
        case RILConstants.NETWORK_MODE_GLOBAL:
        case RILConstants.NETWORK_MODE_LTE_CDMA_EVDO:
        case RILConstants.NETWORK_MODE_LTE_CMDA_EVDO_GSM_WCDMA:
            return Phone.PHONE_TYPE_CDMA;
        case RILConstants.NETWORK_MODE_LTE_ONLY:
            if (BaseCommands.getLteOnCdmaModeStatic() == Phone.LTE_ON_CDMA_TRUE) {
                return Phone.PHONE_TYPE_CDMA;
            } else {
                return Phone.PHONE_TYPE_GSM;
            }
        default:
            return Phone.PHONE_TYPE_GSM;
        }
    }

    
    @DSModeled(DSC.BAN)
    public static Phone getDefaultPhone() {
        if (sLooper != Looper.myLooper()) {
            throw new RuntimeException(
                "PhoneFactory.getDefaultPhone must be called from Looper thread");
        }
        if (!sMadeDefaults) {
            throw new IllegalStateException("Default phones haven't been made yet!");
        }
        return sProxyPhone;
    }

    
    @DSModeled(DSC.BAN)
    public static Phone getCdmaPhone() {
        Phone phone;
        synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            switch (BaseCommands.getLteOnCdmaModeStatic()) {
                case Phone.LTE_ON_CDMA_TRUE: {
                    phone = new CDMALTEPhone(sContext, sCommandsInterface, sPhoneNotifier);
                    break;
                }
                case Phone.LTE_ON_CDMA_FALSE:
                case Phone.LTE_ON_CDMA_UNKNOWN:
                default: {
                    phone = new CDMAPhone(sContext, sCommandsInterface, sPhoneNotifier);
                    break;
                }
            }
        }
        return phone;
    }

    
    @DSModeled(DSC.BAN)
    public static Phone getGsmPhone() {
        synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            Phone phone = new GSMPhone(sContext, sCommandsInterface, sPhoneNotifier);
            return phone;
        }
    }

    
    @DSModeled(DSC.BAN)
    public static SipPhone makeSipPhone(String sipUri) {
        return SipPhoneFactory.makePhone(sipUri, sContext, sPhoneNotifier);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.754 -0400", hash_original_field = "8C61C83FB4E7AA2A98C50A63D7FB9679", hash_generated_field = "90DFE6F4299DB554E753A7D7707C6EC5")

    static final String LOG_TAG = "PHONE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.754 -0400", hash_original_field = "39814A55329A242B757B55B778DFEEB7", hash_generated_field = "D9188122A97A294FF16BEFA0A1A17979")

    static final int SOCKET_OPEN_RETRY_MILLIS = 2 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.754 -0400", hash_original_field = "FC5F2D3CF499D8DA006996AD5C638296", hash_generated_field = "E1118DBBDAB6CAFBF7DDF57BCC17F890")

    static final int SOCKET_OPEN_MAX_RETRY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.754 -0400", hash_original_field = "3A9365FD5BDC6ACF817692FC464F8F09", hash_generated_field = "FFD48797B24EE6D7B6E4F727582D4861")

    static private Phone sProxyPhone = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.754 -0400", hash_original_field = "CE0E22323F77EB5C3DF25598A7C0E6EC", hash_generated_field = "948633D0D5C93BC4F71449321A821594")

    static private CommandsInterface sCommandsInterface = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.754 -0400", hash_original_field = "D685571617078569A664D121BE6E2A91", hash_generated_field = "02E9DB57BA34902E9B630E9F37D0663A")

    static private boolean sMadeDefaults = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.754 -0400", hash_original_field = "D961F59CC29BB985A416940ACFF8B61C", hash_generated_field = "C04DE785FB2B397C6D68F5F32B6C5018")

    static private PhoneNotifier sPhoneNotifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.754 -0400", hash_original_field = "2680FF81BD4665D624A062F001630548", hash_generated_field = "C4167377B5F2D6FE4CFD038AB9D2C19B")

    static private Looper sLooper;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.754 -0400", hash_original_field = "85E80EF1450B10017E4C79B6BDDE7990", hash_generated_field = "6C044CAE0B4842270F6CBBA83E26A7BE")

    static private Context sContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.754 -0400", hash_original_field = "9067925E915424A9EB413AD00BD72DC4", hash_generated_field = "DCF8A1C5D546D28BD0D7A720AA48C565")

    static final int preferredCdmaSubscription = RILConstants.PREFERRED_CDMA_SUBSCRIPTION;
}

