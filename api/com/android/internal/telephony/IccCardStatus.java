package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;

public class IccCardStatus {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.432 -0400", hash_original_field = "B5278EC7E3332C34F3E9480E899A5F4E", hash_generated_field = "9AED67EEE170BD9DAD5D65F0CE4452F9")

    private CardState mCardState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.432 -0400", hash_original_field = "152D6E7C0308956D4C8858B0EA7E2DB9", hash_generated_field = "1DDE8EC46673F45F99B09063FF5B571E")

    private PinState mUniversalPinState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.432 -0400", hash_original_field = "3E8DC37F731F198865915768FB05C367", hash_generated_field = "090D7E62D114F08B9CA4CF4D1B53543A")

    private int mGsmUmtsSubscriptionAppIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.432 -0400", hash_original_field = "C0CBC2A81F0876A1D29E0DD01BDCB0D2", hash_generated_field = "0CB2051C72F8A9F185E8515861584ED4")

    private int mCdmaSubscriptionAppIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.432 -0400", hash_original_field = "396B4A6976B7DC9E2179C8BE7CC98B90", hash_generated_field = "839C2CEF025CD77CEE8431A6690D5463")

    private int mImsSubscriptionAppIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.432 -0400", hash_original_field = "360D6A6B07C55B04E0858861D2699CF8", hash_generated_field = "7829DD0F9B94AC0F0A078A40E3A30616")

    private int mNumApplications;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.432 -0400", hash_original_field = "237E11857BAFAA3AA116B773CD491149", hash_generated_field = "03B1A6FBCA9A9355A5688EA97989AA4B")

    private ArrayList<IccCardApplication> mApplications = new ArrayList<IccCardApplication>(CARD_MAX_APPS);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.432 -0400", hash_original_method = "E3AA20EE9B616A59DB2B25CE475E2F88", hash_generated_method = "E3AA20EE9B616A59DB2B25CE475E2F88")
    public IccCardStatus ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.433 -0400", hash_original_method = "FA0602D88E7C21991E0740ABD82BDA04", hash_generated_method = "E8A329A89DA1394AB1F8A7EB0516AB9F")
    public CardState getCardState() {
CardState var2D1E0840F22322CEA6782A0E26A4A513_1566293230 =         mCardState;
        var2D1E0840F22322CEA6782A0E26A4A513_1566293230.addTaint(taint);
        return var2D1E0840F22322CEA6782A0E26A4A513_1566293230;
        // ---------- Original Method ----------
        //return mCardState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.433 -0400", hash_original_method = "DF1BA1B7D815247B6DDD09A8150ACB8E", hash_generated_method = "890589AE829FC25E884BEC58BB099453")
    public void setCardState(int state) {
        addTaint(state);
switch(state){
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
        RuntimeException var476640B0F65B6B98A1F316AB5F425E40_1937736064 = new RuntimeException("Unrecognized RIL_CardState: " + state);
        var476640B0F65B6B98A1F316AB5F425E40_1937736064.addTaint(taint);
        throw var476640B0F65B6B98A1F316AB5F425E40_1937736064;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.434 -0400", hash_original_method = "EAD880236056BC0FED4A918911F5B846", hash_generated_method = "2FA73BB56BD790225B35824B6148F4E7")
    public PinState getUniversalPinState() {
PinState var01A551BCF4C2957CEA82343EFB7BBFCF_1989370772 =         mUniversalPinState;
        var01A551BCF4C2957CEA82343EFB7BBFCF_1989370772.addTaint(taint);
        return var01A551BCF4C2957CEA82343EFB7BBFCF_1989370772;
        // ---------- Original Method ----------
        //return mUniversalPinState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.435 -0400", hash_original_method = "B5D48B53E99405CE8B767A81E3B60FC3", hash_generated_method = "28C47A5B66F3C14B36EE39BF7FEDD247")
    public void setUniversalPinState(int state) {
        addTaint(state);
switch(state){
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
        RuntimeException varC268DAB217193013B5F1193A23F2A03C_356390112 = new RuntimeException("Unrecognized RIL_PinState: " + state);
        varC268DAB217193013B5F1193A23F2A03C_356390112.addTaint(taint);
        throw varC268DAB217193013B5F1193A23F2A03C_356390112;
}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.435 -0400", hash_original_method = "BB106B954443B302CECFC313EF7CB395", hash_generated_method = "E4511B63706939E711B01A34F986FF96")
    public int getGsmUmtsSubscriptionAppIndex() {
        int var3E8DC37F731F198865915768FB05C367_803135689 = (mGsmUmtsSubscriptionAppIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200407773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1200407773;
        // ---------- Original Method ----------
        //return mGsmUmtsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.436 -0400", hash_original_method = "08BD9E6DFC873F65C3F784287907D5E3", hash_generated_method = "03968C0784B0953DB1DC116AD2BB207A")
    public void setGsmUmtsSubscriptionAppIndex(int gsmUmtsSubscriptionAppIndex) {
        mGsmUmtsSubscriptionAppIndex = gsmUmtsSubscriptionAppIndex;
        // ---------- Original Method ----------
        //mGsmUmtsSubscriptionAppIndex = gsmUmtsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.436 -0400", hash_original_method = "2A192AC2BA1E64618C17CC6A1074F688", hash_generated_method = "7B2707F563DF522B4E6320CF829F9A36")
    public int getCdmaSubscriptionAppIndex() {
        int varC0CBC2A81F0876A1D29E0DD01BDCB0D2_160065172 = (mCdmaSubscriptionAppIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955152910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_955152910;
        // ---------- Original Method ----------
        //return mCdmaSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.437 -0400", hash_original_method = "891E989E2EC1A38AF8B37DBC8E8322CF", hash_generated_method = "6D1B0649C9CFAF249D62B999C50E4C43")
    public void setCdmaSubscriptionAppIndex(int cdmaSubscriptionAppIndex) {
        mCdmaSubscriptionAppIndex = cdmaSubscriptionAppIndex;
        // ---------- Original Method ----------
        //mCdmaSubscriptionAppIndex = cdmaSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.437 -0400", hash_original_method = "66775E00E5C07C014B4CD9717DAD3963", hash_generated_method = "420C4C1A97B86FBCEE78EDD765B6406E")
    public int getImsSubscriptionAppIndex() {
        int var396B4A6976B7DC9E2179C8BE7CC98B90_686602745 = (mImsSubscriptionAppIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876081429 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876081429;
        // ---------- Original Method ----------
        //return mImsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.437 -0400", hash_original_method = "F62298652BB86C33D896C0D398774EF1", hash_generated_method = "EDDFA44F41288CFC56DC7BAF3703C59D")
    public void setImsSubscriptionAppIndex(int imsSubscriptionAppIndex) {
        mImsSubscriptionAppIndex = imsSubscriptionAppIndex;
        // ---------- Original Method ----------
        //mImsSubscriptionAppIndex = imsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.438 -0400", hash_original_method = "73A878FBCD525FA581932F7C6A7C55D4", hash_generated_method = "53D4625F4441676A7E6EF5F1FC01E7DB")
    public int getNumApplications() {
        int var360D6A6B07C55B04E0858861D2699CF8_1041873787 = (mNumApplications);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30051867 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_30051867;
        // ---------- Original Method ----------
        //return mNumApplications;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.438 -0400", hash_original_method = "6F974EA3499D29038B295A1FDDF2D7B1", hash_generated_method = "E0EE19C0A0A8F7AD8CB842C7430E7BAA")
    public void setNumApplications(int numApplications) {
        mNumApplications = numApplications;
        // ---------- Original Method ----------
        //mNumApplications = numApplications;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.438 -0400", hash_original_method = "A2EAD3988F60EC73A08878F3FE639EE8", hash_generated_method = "16675080692E3ED5EA9853877242ED18")
    public void addApplication(IccCardApplication application) {
        addTaint(application.getTaint());
        mApplications.add(application);
        // ---------- Original Method ----------
        //mApplications.add(application);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.438 -0400", hash_original_method = "57D1023FA4D5ED682F8C58AD605F19ED", hash_generated_method = "481E28371A2E65BC786C85E5F0CD274C")
    public IccCardApplication getApplication(int index) {
        addTaint(index);
IccCardApplication var4EF5E4003948690D864DE616AE0C5D71_1695984726 =         mApplications.get(index);
        var4EF5E4003948690D864DE616AE0C5D71_1695984726.addTaint(taint);
        return var4EF5E4003948690D864DE616AE0C5D71_1695984726;
        // ---------- Original Method ----------
        //return mApplications.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.439 -0400", hash_original_method = "29E2CBB78335356F6993D73415A74DA6", hash_generated_method = "3DD20A405D3864109B178C6A2200A748")
    @Override
    public String toString() {
        IccCardApplication app;
        StringBuilder sb = new StringBuilder();
        sb.append("IccCardState {").append(mCardState).append(",")
        .append(mUniversalPinState)
        .append(",num_apps=").append(mNumApplications)
        .append(",gsm_id=").append(mGsmUmtsSubscriptionAppIndex);
    if(mGsmUmtsSubscriptionAppIndex >=0
                && mGsmUmtsSubscriptionAppIndex <CARD_MAX_APPS)        
        {
            app = getApplication(mGsmUmtsSubscriptionAppIndex);
            sb.append(app == null ? "null" : app);
        } //End block
        sb.append(",cmda_id=").append(mCdmaSubscriptionAppIndex);
    if(mCdmaSubscriptionAppIndex >=0
                && mCdmaSubscriptionAppIndex <CARD_MAX_APPS)        
        {
            app = getApplication(mCdmaSubscriptionAppIndex);
            sb.append(app == null ? "null" : app);
        } //End block
        sb.append(",ism_id=").append(mImsSubscriptionAppIndex);
        sb.append("}");
String var2460B846747F8B22185AD8BE722266A5_651276945 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_651276945.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_651276945;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:21.440 -0400", hash_original_field = "9077F12194B02D6EF8AF620DF49E8A1B", hash_generated_field = "F5DEB270E27E9EBAAF4255B1D38C3900")

    static final int CARD_MAX_APPS = 8;
}

