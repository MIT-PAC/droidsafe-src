package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;

public class IccCardStatus {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.252 -0400", hash_original_field = "B5278EC7E3332C34F3E9480E899A5F4E", hash_generated_field = "9AED67EEE170BD9DAD5D65F0CE4452F9")

    private CardState mCardState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.252 -0400", hash_original_field = "152D6E7C0308956D4C8858B0EA7E2DB9", hash_generated_field = "1DDE8EC46673F45F99B09063FF5B571E")

    private PinState mUniversalPinState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.252 -0400", hash_original_field = "3E8DC37F731F198865915768FB05C367", hash_generated_field = "090D7E62D114F08B9CA4CF4D1B53543A")

    private int mGsmUmtsSubscriptionAppIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.262 -0400", hash_original_field = "C0CBC2A81F0876A1D29E0DD01BDCB0D2", hash_generated_field = "0CB2051C72F8A9F185E8515861584ED4")

    private int mCdmaSubscriptionAppIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.262 -0400", hash_original_field = "396B4A6976B7DC9E2179C8BE7CC98B90", hash_generated_field = "839C2CEF025CD77CEE8431A6690D5463")

    private int mImsSubscriptionAppIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.262 -0400", hash_original_field = "360D6A6B07C55B04E0858861D2699CF8", hash_generated_field = "7829DD0F9B94AC0F0A078A40E3A30616")

    private int mNumApplications;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.262 -0400", hash_original_field = "237E11857BAFAA3AA116B773CD491149", hash_generated_field = "03B1A6FBCA9A9355A5688EA97989AA4B")

    private ArrayList<IccCardApplication> mApplications = new ArrayList<IccCardApplication>(CARD_MAX_APPS);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.262 -0400", hash_original_method = "E3AA20EE9B616A59DB2B25CE475E2F88", hash_generated_method = "E3AA20EE9B616A59DB2B25CE475E2F88")
    public IccCardStatus ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.263 -0400", hash_original_method = "FA0602D88E7C21991E0740ABD82BDA04", hash_generated_method = "EDAF3484E51B93D60055F3E0621D0DC5")
    public CardState getCardState() {
        CardState varB4EAC82CA7396A68D541C85D26508E83_816667218 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_816667218 = mCardState;
        varB4EAC82CA7396A68D541C85D26508E83_816667218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_816667218;
        // ---------- Original Method ----------
        //return mCardState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.264 -0400", hash_original_method = "DF1BA1B7D815247B6DDD09A8150ACB8E", hash_generated_method = "129DC0128092D4CDBF2170B5D21676E6")
    public void setCardState(int state) {
        //Begin case 0 
        mCardState = CardState.CARDSTATE_ABSENT;
        //End case 0 
        //Begin case 1 
        mCardState = CardState.CARDSTATE_PRESENT;
        //End case 1 
        //Begin case 2 
        mCardState = CardState.CARDSTATE_ERROR;
        //End case 2 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unrecognized RIL_CardState: " + state);
        //End case default 
        addTaint(state);
        // ---------- Original Method ----------
        //switch(state) {
        //case 0:
            //mCardState = CardState.CARDSTATE_ABSENT;
            //break;
        //case 1:
            //mCardState = CardState.CARDSTATE_PRESENT;
            //break;
        //case 2:
            //mCardState = CardState.CARDSTATE_ERROR;
            //break;
        //default:
            //throw new RuntimeException("Unrecognized RIL_CardState: " + state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.265 -0400", hash_original_method = "EAD880236056BC0FED4A918911F5B846", hash_generated_method = "BCA3D6F50EDCA648359AD8ED0518407F")
    public PinState getUniversalPinState() {
        PinState varB4EAC82CA7396A68D541C85D26508E83_2021737967 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2021737967 = mUniversalPinState;
        varB4EAC82CA7396A68D541C85D26508E83_2021737967.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2021737967;
        // ---------- Original Method ----------
        //return mUniversalPinState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.266 -0400", hash_original_method = "B5D48B53E99405CE8B767A81E3B60FC3", hash_generated_method = "0C139E91A6794361850581F0EE65077D")
    public void setUniversalPinState(int state) {
        //Begin case 0 
        mUniversalPinState = PinState.PINSTATE_UNKNOWN;
        //End case 0 
        //Begin case 1 
        mUniversalPinState = PinState.PINSTATE_ENABLED_NOT_VERIFIED;
        //End case 1 
        //Begin case 2 
        mUniversalPinState = PinState.PINSTATE_ENABLED_VERIFIED;
        //End case 2 
        //Begin case 3 
        mUniversalPinState = PinState.PINSTATE_DISABLED;
        //End case 3 
        //Begin case 4 
        mUniversalPinState = PinState.PINSTATE_ENABLED_BLOCKED;
        //End case 4 
        //Begin case 5 
        mUniversalPinState = PinState.PINSTATE_ENABLED_PERM_BLOCKED;
        //End case 5 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unrecognized RIL_PinState: " + state);
        //End case default 
        addTaint(state);
        // ---------- Original Method ----------
        //switch(state) {
        //case 0:
            //mUniversalPinState = PinState.PINSTATE_UNKNOWN;
            //break;
        //case 1:
            //mUniversalPinState = PinState.PINSTATE_ENABLED_NOT_VERIFIED;
            //break;
        //case 2:
            //mUniversalPinState = PinState.PINSTATE_ENABLED_VERIFIED;
            //break;
        //case 3:
            //mUniversalPinState = PinState.PINSTATE_DISABLED;
            //break;
        //case 4:
            //mUniversalPinState = PinState.PINSTATE_ENABLED_BLOCKED;
            //break;
        //case 5:
            //mUniversalPinState = PinState.PINSTATE_ENABLED_PERM_BLOCKED;
            //break;
        //default:
            //throw new RuntimeException("Unrecognized RIL_PinState: " + state);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.266 -0400", hash_original_method = "BB106B954443B302CECFC313EF7CB395", hash_generated_method = "ADFCB92C6327C110F2AC9DB32B8A9637")
    public int getGsmUmtsSubscriptionAppIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620781629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620781629;
        // ---------- Original Method ----------
        //return mGsmUmtsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.278 -0400", hash_original_method = "08BD9E6DFC873F65C3F784287907D5E3", hash_generated_method = "03968C0784B0953DB1DC116AD2BB207A")
    public void setGsmUmtsSubscriptionAppIndex(int gsmUmtsSubscriptionAppIndex) {
        mGsmUmtsSubscriptionAppIndex = gsmUmtsSubscriptionAppIndex;
        // ---------- Original Method ----------
        //mGsmUmtsSubscriptionAppIndex = gsmUmtsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.279 -0400", hash_original_method = "2A192AC2BA1E64618C17CC6A1074F688", hash_generated_method = "B3EBE9A26D864E3988AEABF9B03E44F4")
    public int getCdmaSubscriptionAppIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842240420 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_842240420;
        // ---------- Original Method ----------
        //return mCdmaSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.279 -0400", hash_original_method = "891E989E2EC1A38AF8B37DBC8E8322CF", hash_generated_method = "6D1B0649C9CFAF249D62B999C50E4C43")
    public void setCdmaSubscriptionAppIndex(int cdmaSubscriptionAppIndex) {
        mCdmaSubscriptionAppIndex = cdmaSubscriptionAppIndex;
        // ---------- Original Method ----------
        //mCdmaSubscriptionAppIndex = cdmaSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.279 -0400", hash_original_method = "66775E00E5C07C014B4CD9717DAD3963", hash_generated_method = "3FD0744859F2D8D451FA235EAE297FE1")
    public int getImsSubscriptionAppIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476268887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476268887;
        // ---------- Original Method ----------
        //return mImsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.279 -0400", hash_original_method = "F62298652BB86C33D896C0D398774EF1", hash_generated_method = "EDDFA44F41288CFC56DC7BAF3703C59D")
    public void setImsSubscriptionAppIndex(int imsSubscriptionAppIndex) {
        mImsSubscriptionAppIndex = imsSubscriptionAppIndex;
        // ---------- Original Method ----------
        //mImsSubscriptionAppIndex = imsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.280 -0400", hash_original_method = "73A878FBCD525FA581932F7C6A7C55D4", hash_generated_method = "7D722846653C845A19CFB46630CF5340")
    public int getNumApplications() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139889784 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_139889784;
        // ---------- Original Method ----------
        //return mNumApplications;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.280 -0400", hash_original_method = "6F974EA3499D29038B295A1FDDF2D7B1", hash_generated_method = "E0EE19C0A0A8F7AD8CB842C7430E7BAA")
    public void setNumApplications(int numApplications) {
        mNumApplications = numApplications;
        // ---------- Original Method ----------
        //mNumApplications = numApplications;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.285 -0400", hash_original_method = "A2EAD3988F60EC73A08878F3FE639EE8", hash_generated_method = "38BA05FD585779959ADE2AC5945F94BA")
    public void addApplication(IccCardApplication application) {
        mApplications.add(application);
        addTaint(application.getTaint());
        // ---------- Original Method ----------
        //mApplications.add(application);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.294 -0400", hash_original_method = "57D1023FA4D5ED682F8C58AD605F19ED", hash_generated_method = "1C03DF957EA5AA29A4A58C3D7FB0CF2D")
    public IccCardApplication getApplication(int index) {
        IccCardApplication varB4EAC82CA7396A68D541C85D26508E83_383693680 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_383693680 = mApplications.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_383693680.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_383693680;
        // ---------- Original Method ----------
        //return mApplications.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.295 -0400", hash_original_method = "29E2CBB78335356F6993D73415A74DA6", hash_generated_method = "FC1B284C23FC1D3128DB0FFCF4DE143C")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1143351485 = null; //Variable for return #1
        IccCardApplication app;
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("IccCardState {").append(mCardState).append(",")
        .append(mUniversalPinState)
        .append(",num_apps=").append(mNumApplications)
        .append(",gsm_id=").append(mGsmUmtsSubscriptionAppIndex);
        {
            app = getApplication(mGsmUmtsSubscriptionAppIndex);
            sb.append(app == null ? "null" : app);
        } //End block
        sb.append(",cmda_id=").append(mCdmaSubscriptionAppIndex);
        {
            app = getApplication(mCdmaSubscriptionAppIndex);
            sb.append(app == null ? "null" : app);
        } //End block
        sb.append(",ism_id=").append(mImsSubscriptionAppIndex);
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_1143351485 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1143351485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1143351485;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public enum CardState {
        CARDSTATE_ABSENT,
        CARDSTATE_PRESENT,
        CARDSTATE_ERROR;
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
        boolean isPermBlocked() {
            return this == PINSTATE_ENABLED_PERM_BLOCKED;
        }
        boolean isPinRequired() {
            return this == PINSTATE_ENABLED_NOT_VERIFIED;
        }
        boolean isPukRequired() {
            return this == PINSTATE_ENABLED_BLOCKED;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:16.295 -0400", hash_original_field = "9077F12194B02D6EF8AF620DF49E8A1B", hash_generated_field = "6E6E6D7DE72DDDBB0F831E36A0ECBF42")

    static int CARD_MAX_APPS = 8;
}

