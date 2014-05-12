package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

public class IccCardStatus {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.085 -0500", hash_original_field = "9B7CCCE86F0546A7C4260731F2365F35", hash_generated_field = "F5DEB270E27E9EBAAF4255B1D38C3900")

    static final int CARD_MAX_APPS = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.100 -0500", hash_original_field = "BED51697F82CEBB8492E19EE3627BC61", hash_generated_field = "9AED67EEE170BD9DAD5D65F0CE4452F9")

    private CardState  mCardState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.103 -0500", hash_original_field = "73AECB2D1668DD8A37A4C38D956200C2", hash_generated_field = "1DDE8EC46673F45F99B09063FF5B571E")

    private PinState   mUniversalPinState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.105 -0500", hash_original_field = "B0A7CBDBE0599AA5C0EB768A6C903AD6", hash_generated_field = "090D7E62D114F08B9CA4CF4D1B53543A")

    private int        mGsmUmtsSubscriptionAppIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.107 -0500", hash_original_field = "3D7C385D7A26A6BC2E3E7710FF4FFD2D", hash_generated_field = "0CB2051C72F8A9F185E8515861584ED4")

    private int        mCdmaSubscriptionAppIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.110 -0500", hash_original_field = "65EBE3B8DDB44ABE10E8A3A5E676F5AA", hash_generated_field = "839C2CEF025CD77CEE8431A6690D5463")

    private int        mImsSubscriptionAppIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.112 -0500", hash_original_field = "2BFB2CF3F945CCE391C91AB0385AD150", hash_generated_field = "7829DD0F9B94AC0F0A078A40E3A30616")

    private int        mNumApplications;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.115 -0500", hash_original_field = "EBA8018819FCCB7F3AEA367EBD79D850", hash_generated_field = "03B1A6FBCA9A9355A5688EA97989AA4B")

    private ArrayList<IccCardApplication> mApplications =
            new ArrayList<IccCardApplication>(CARD_MAX_APPS);
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.014 -0400", hash_original_method = "E3AA20EE9B616A59DB2B25CE475E2F88", hash_generated_method = "E3AA20EE9B616A59DB2B25CE475E2F88")
    public IccCardStatus ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.117 -0500", hash_original_method = "FA0602D88E7C21991E0740ABD82BDA04", hash_generated_method = "78D9E79B934201B8526FAD0F323E5A15")
    
public CardState getCardState() {
        return mCardState;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.119 -0500", hash_original_method = "DF1BA1B7D815247B6DDD09A8150ACB8E", hash_generated_method = "1ED07E489D5A14D4581E28CB0D51784B")
    
public void setCardState(int state) {
        switch(state) {
        case 0:
            mCardState = CardState.CARDSTATE_ABSENT;
            break;
        case 1:
            mCardState = CardState.CARDSTATE_PRESENT;
            break;
        case 2:
            mCardState = CardState.CARDSTATE_ERROR;
            break;
        default:
            throw new RuntimeException("Unrecognized RIL_CardState: " + state);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.121 -0500", hash_original_method = "EAD880236056BC0FED4A918911F5B846", hash_generated_method = "70FBF0474E4C8D5E21398A539F8911F8")
    
public PinState getUniversalPinState() {
        return mUniversalPinState;
    }

    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.124 -0500", hash_original_method = "B5D48B53E99405CE8B767A81E3B60FC3", hash_generated_method = "04DC853202C5C40144085AF39F739EC4")
    
public void setUniversalPinState(int state) {
        switch(state) {
        case 0:
            mUniversalPinState = PinState.PINSTATE_UNKNOWN;
            break;
        case 1:
            mUniversalPinState = PinState.PINSTATE_ENABLED_NOT_VERIFIED;
            break;
        case 2:
            mUniversalPinState = PinState.PINSTATE_ENABLED_VERIFIED;
            break;
        case 3:
            mUniversalPinState = PinState.PINSTATE_DISABLED;
            break;
        case 4:
            mUniversalPinState = PinState.PINSTATE_ENABLED_BLOCKED;
            break;
        case 5:
            mUniversalPinState = PinState.PINSTATE_ENABLED_PERM_BLOCKED;
            break;
        default:
            throw new RuntimeException("Unrecognized RIL_PinState: " + state);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.128 -0500", hash_original_method = "BB106B954443B302CECFC313EF7CB395", hash_generated_method = "E717A52FD0BC4796F811BBBFD3AEDDC4")
    
public int getGsmUmtsSubscriptionAppIndex() {
        return mGsmUmtsSubscriptionAppIndex;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.130 -0500", hash_original_method = "08BD9E6DFC873F65C3F784287907D5E3", hash_generated_method = "5DDDF56E1A64333FF1016B4AE5C46D03")
    
public void setGsmUmtsSubscriptionAppIndex(int gsmUmtsSubscriptionAppIndex) {
        mGsmUmtsSubscriptionAppIndex = gsmUmtsSubscriptionAppIndex;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.132 -0500", hash_original_method = "2A192AC2BA1E64618C17CC6A1074F688", hash_generated_method = "20B15C47C8B7D1339CC30FF2B41D2CEE")
    
public int getCdmaSubscriptionAppIndex() {
        return mCdmaSubscriptionAppIndex;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.135 -0500", hash_original_method = "891E989E2EC1A38AF8B37DBC8E8322CF", hash_generated_method = "4DA6FCA7B5A0C165AD6EFC3B2CB69A6A")
    
public void setCdmaSubscriptionAppIndex(int cdmaSubscriptionAppIndex) {
        mCdmaSubscriptionAppIndex = cdmaSubscriptionAppIndex;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.137 -0500", hash_original_method = "66775E00E5C07C014B4CD9717DAD3963", hash_generated_method = "6D6AF17657553C6D76CCA1903D5FD002")
    
public int getImsSubscriptionAppIndex() {
        return mImsSubscriptionAppIndex;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.139 -0500", hash_original_method = "F62298652BB86C33D896C0D398774EF1", hash_generated_method = "28D6B86014554E11CD371F8EBA4D3859")
    
public void setImsSubscriptionAppIndex(int imsSubscriptionAppIndex) {
        mImsSubscriptionAppIndex = imsSubscriptionAppIndex;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.142 -0500", hash_original_method = "73A878FBCD525FA581932F7C6A7C55D4", hash_generated_method = "1FF8045019302067B0B9E609498B2E00")
    
public int getNumApplications() {
        return mNumApplications;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.144 -0500", hash_original_method = "6F974EA3499D29038B295A1FDDF2D7B1", hash_generated_method = "489A2399155CC5FC7CCDDF820858ECE6")
    
public void setNumApplications(int numApplications) {
        mNumApplications = numApplications;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.146 -0500", hash_original_method = "A2EAD3988F60EC73A08878F3FE639EE8", hash_generated_method = "83731E32E7D685D92A13DD52F23DC1A8")
    
public void addApplication(IccCardApplication application) {
        mApplications.add(application);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.148 -0500", hash_original_method = "57D1023FA4D5ED682F8C58AD605F19ED", hash_generated_method = "35CADA6111CED63972823CC5990D22BD")
    
public IccCardApplication getApplication(int index) {
        return mApplications.get(index);
    }
    
    public enum CardState {
        CARDSTATE_ABSENT,
        CARDSTATE_PRESENT,
        CARDSTATE_ERROR;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.088 -0500", hash_original_method = "5D2E7E7C9852D570FA7DEAEED6F01D06", hash_generated_method = "5D2E7E7C9852D570FA7DEAEED6F01D06")
            
boolean isCardPresent() {
            return this == CARDSTATE_PRESENT;
        }
    }
    
    public enum PinState {
        PINSTATE_UNKNOWN,
        PINSTATE_ENABLED_NOT_VERIFIED,
        PINSTATE_ENABLED_VERIFIED,
        PINSTATE_DISABLED,
        PINSTATE_ENABLED_BLOCKED,
        PINSTATE_ENABLED_PERM_BLOCKED;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.092 -0500", hash_original_method = "59BABA49443E4274C834D4D51105C6C6", hash_generated_method = "59BABA49443E4274C834D4D51105C6C6")
            
boolean isPermBlocked() {
            return this == PINSTATE_ENABLED_PERM_BLOCKED;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.095 -0500", hash_original_method = "E528847B449E85414759CA359F8F15CE", hash_generated_method = "E528847B449E85414759CA359F8F15CE")
            
boolean isPinRequired() {
            return this == PINSTATE_ENABLED_NOT_VERIFIED;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.097 -0500", hash_original_method = "76793F101293429894997ED5484D21C0", hash_generated_method = "76793F101293429894997ED5484D21C0")
            
boolean isPukRequired() {
            return this == PINSTATE_ENABLED_BLOCKED;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:45.151 -0500", hash_original_method = "29E2CBB78335356F6993D73415A74DA6", hash_generated_method = "9A6D439BF5D1A644B4B35621E9133986")
    
@Override
    public String toString() {
        IccCardApplication app;

        StringBuilder sb = new StringBuilder();
        sb.append("IccCardState {").append(mCardState).append(",")
        .append(mUniversalPinState)
        .append(",num_apps=").append(mNumApplications)
        .append(",gsm_id=").append(mGsmUmtsSubscriptionAppIndex);
        if (mGsmUmtsSubscriptionAppIndex >=0
                && mGsmUmtsSubscriptionAppIndex <CARD_MAX_APPS) {
            app = getApplication(mGsmUmtsSubscriptionAppIndex);
            sb.append(app == null ? "null" : app);
        }

        sb.append(",cmda_id=").append(mCdmaSubscriptionAppIndex);
        if (mCdmaSubscriptionAppIndex >=0
                && mCdmaSubscriptionAppIndex <CARD_MAX_APPS) {
            app = getApplication(mCdmaSubscriptionAppIndex);
            sb.append(app == null ? "null" : app);
        }

        sb.append(",ism_id=").append(mImsSubscriptionAppIndex);

        sb.append("}");

        return sb.toString();
    }
}

