package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.net.LocalServerSocket;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.os.SystemProperties;
import com.android.internal.telephony.cdma.CDMAPhone;
import com.android.internal.telephony.cdma.CDMALTEPhone;
import com.android.internal.telephony.gsm.GSMPhone;
import com.android.internal.telephony.sip.SipPhone;
import com.android.internal.telephony.sip.SipPhoneFactory;

public class PhoneFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.655 -0400", hash_original_method = "A5A2411EAE8CB20F35449EA0283F36D4", hash_generated_method = "A5A2411EAE8CB20F35449EA0283F36D4")
        public PhoneFactory ()
    {
    }


        public static void makeDefaultPhones(Context context) {
        makeDefaultPhone(context);
    }

    
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

    
        public static Phone getGsmPhone() {
        synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            Phone phone = new GSMPhone(sContext, sCommandsInterface, sPhoneNotifier);
            return phone;
        }
    }

    
        public static SipPhone makeSipPhone(String sipUri) {
        return SipPhoneFactory.makePhone(sipUri, sContext, sPhoneNotifier);
    }

    
    static final String LOG_TAG = "PHONE";
    static final int SOCKET_OPEN_RETRY_MILLIS = 2 * 1000;
    static final int SOCKET_OPEN_MAX_RETRY = 3;
    static private Phone sProxyPhone = null;
    static private CommandsInterface sCommandsInterface = null;
    static private boolean sMadeDefaults = false;
    static private PhoneNotifier sPhoneNotifier;
    static private Looper sLooper;
    static private Context sContext;
    static final int preferredCdmaSubscription = RILConstants.PREFERRED_CDMA_SUBSCRIPTION;
}

