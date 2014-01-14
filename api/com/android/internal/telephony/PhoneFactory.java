package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    //***** Class Methods

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.857 -0500", hash_original_method = "0E1E8931F63DFB6885BA0E932A386482", hash_generated_method = "EAE0AA2B1398ECEDBB04FE2727AB5B98")
    
public static void makeDefaultPhones(Context context) {
        makeDefaultPhone(context);
    }

    /**
     * FIXME replace this with some other way of making these
     * instances
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.862 -0500", hash_original_method = "FD504A8EE66FE46638165E4FA7669C08", hash_generated_method = "A7B536DB29EACCA84CD9D770118ACB70")
    
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
                        // use UNIX domain socket to
                        // prevent subsequent initialization
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

                // Get preferred network mode
                int preferredNetworkMode = RILConstants.PREFERRED_NETWORK_MODE;
                if (BaseCommands.getLteOnCdmaModeStatic() == Phone.LTE_ON_CDMA_TRUE) {
                    preferredNetworkMode = Phone.NT_MODE_GLOBAL;
                }
                int networkMode = Settings.Secure.getInt(context.getContentResolver(),
                        Settings.Secure.PREFERRED_NETWORK_MODE, preferredNetworkMode);
                Log.i(LOG_TAG, "Network Mode set to " + Integer.toString(networkMode));

                // Get cdmaSubscription
                // TODO: Change when the ril will provides a way to know at runtime
                //       the configuration, bug 4202572. And the ril issues the
                //       RIL_UNSOL_CDMA_SUBSCRIPTION_SOURCE_CHANGED, bug 4295439.
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
                        //Get cdmaSubscription mode from Settings.System
                        cdmaSubscription = Settings.Secure.getInt(context.getContentResolver(),
                                Settings.Secure.PREFERRED_CDMA_SUBSCRIPTION,
                                preferredCdmaSubscription);
                        Log.i(LOG_TAG, "lteOnCdma not set, using PREFERRED_CDMA_SUBSCRIPTION");
                        break;
                }
                Log.i(LOG_TAG, "Cdma Subscription set to " + cdmaSubscription);

                //reads the system properties and makes commandsinterface
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

    /*
     * This function returns the type of the phone, depending
     * on the network mode.
     *
     * @param network mode
     * @return Phone Type
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.865 -0500", hash_original_method = "EF5F5E28A34E9E9EC202E3A779439E2A", hash_generated_method = "5E332680A8C51EC776B281EEFA3D5618")
    
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

        // Use CDMA Phone for the global mode including CDMA
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

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.868 -0500", hash_original_method = "E0E640EABAC4777B910C56F03DFB97E3", hash_generated_method = "AF440F5EC61D362F245508B2E93D2847")
    
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

    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.870 -0500", hash_original_method = "3914D022DA63364ED06A0A76AA75F742", hash_generated_method = "C3AD0A4549895A2281873672BB52AEDE")
    
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

    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.873 -0500", hash_original_method = "D21324550B0D208FEBE5EE2A4FB6D6A5", hash_generated_method = "30715F2D0DF0026F0D876CE7EC5B115B")
    
public static Phone getGsmPhone() {
        synchronized(PhoneProxy.lockForRadioTechnologyChange) {
            Phone phone = new GSMPhone(sContext, sCommandsInterface, sPhoneNotifier);
            return phone;
        }
    }

    /**
     * Makes a {@link SipPhone} object.
     * @param sipUri the local SIP URI the phone runs on
     * @return the {@code SipPhone} object or null if the SIP URI is not valid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.875 -0500", hash_original_method = "602CEBAA873618AF473B0ECCA9F1A939", hash_generated_method = "CB4F46AA4D258D2DB4E21ECE953B9CFF")
    
public static SipPhone makeSipPhone(String sipUri) {
        return SipPhoneFactory.makePhone(sipUri, sContext, sPhoneNotifier);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.834 -0500", hash_original_field = "F4446E751DD7D5E85FE650192A5E7AE4", hash_generated_field = "90DFE6F4299DB554E753A7D7707C6EC5")

    static final String LOG_TAG = "PHONE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.836 -0500", hash_original_field = "C31BFCCF5322C7DAFBAA7F6F38E8E8EF", hash_generated_field = "D9188122A97A294FF16BEFA0A1A17979")

    static final int SOCKET_OPEN_RETRY_MILLIS = 2 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.838 -0500", hash_original_field = "92646751BF3F7FC3FA1E904F900FAB05", hash_generated_field = "E1118DBBDAB6CAFBF7DDF57BCC17F890")

    static final int SOCKET_OPEN_MAX_RETRY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.841 -0500", hash_original_field = "E40B43EECEFF894B61232068FF4B6452", hash_generated_field = "FFD48797B24EE6D7B6E4F727582D4861")

    static private Phone sProxyPhone = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.843 -0500", hash_original_field = "4CEBC247DDA6403F22746931A1D46857", hash_generated_field = "948633D0D5C93BC4F71449321A821594")

    static private CommandsInterface sCommandsInterface = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.846 -0500", hash_original_field = "72293D3627C82681D2739C24FC972587", hash_generated_field = "02E9DB57BA34902E9B630E9F37D0663A")

    static private boolean sMadeDefaults = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.848 -0500", hash_original_field = "229EFF098D4EE5A4D864A34ADA836109", hash_generated_field = "C04DE785FB2B397C6D68F5F32B6C5018")

    static private PhoneNotifier sPhoneNotifier;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.850 -0500", hash_original_field = "DC7DC1FDFC7889453CE997D3B604ED46", hash_generated_field = "C4167377B5F2D6FE4CFD038AB9D2C19B")

    static private Looper sLooper;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.853 -0500", hash_original_field = "CEF70F4829B188D89E37229D281B99F4", hash_generated_field = "6C044CAE0B4842270F6CBBA83E26A7BE")

    static private Context sContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:08.855 -0500", hash_original_field = "3D13FFAC931996EA14B80B41398A0178", hash_generated_field = "DCF8A1C5D546D28BD0D7A720AA48C565")

    static final int preferredCdmaSubscription = RILConstants.PREFERRED_CDMA_SUBSCRIPTION;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.753 -0400", hash_original_method = "BADF3E1DCB0337DAED03CEBED853A313", hash_generated_method = "BADF3E1DCB0337DAED03CEBED853A313")
    public PhoneFactory ()
    {
        //Synthesized constructor
    }
}

