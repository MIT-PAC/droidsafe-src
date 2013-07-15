package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.ArrayList;

public class IccCardStatus {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.829 -0400", hash_original_field = "B5278EC7E3332C34F3E9480E899A5F4E", hash_generated_field = "9AED67EEE170BD9DAD5D65F0CE4452F9")

    private CardState mCardState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.829 -0400", hash_original_field = "152D6E7C0308956D4C8858B0EA7E2DB9", hash_generated_field = "1DDE8EC46673F45F99B09063FF5B571E")

    private PinState mUniversalPinState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.829 -0400", hash_original_field = "3E8DC37F731F198865915768FB05C367", hash_generated_field = "090D7E62D114F08B9CA4CF4D1B53543A")

    private int mGsmUmtsSubscriptionAppIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.829 -0400", hash_original_field = "C0CBC2A81F0876A1D29E0DD01BDCB0D2", hash_generated_field = "0CB2051C72F8A9F185E8515861584ED4")

    private int mCdmaSubscriptionAppIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.829 -0400", hash_original_field = "396B4A6976B7DC9E2179C8BE7CC98B90", hash_generated_field = "839C2CEF025CD77CEE8431A6690D5463")

    private int mImsSubscriptionAppIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.829 -0400", hash_original_field = "360D6A6B07C55B04E0858861D2699CF8", hash_generated_field = "7829DD0F9B94AC0F0A078A40E3A30616")

    private int mNumApplications;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.829 -0400", hash_original_field = "237E11857BAFAA3AA116B773CD491149", hash_generated_field = "03B1A6FBCA9A9355A5688EA97989AA4B")

    private ArrayList<IccCardApplication> mApplications = new ArrayList<IccCardApplication>(CARD_MAX_APPS);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.829 -0400", hash_original_method = "E3AA20EE9B616A59DB2B25CE475E2F88", hash_generated_method = "E3AA20EE9B616A59DB2B25CE475E2F88")
    public IccCardStatus ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.830 -0400", hash_original_method = "FA0602D88E7C21991E0740ABD82BDA04", hash_generated_method = "0EB1CA1150DC1C6E828468E164C3AC82")
    public CardState getCardState() {
        CardState varB4EAC82CA7396A68D541C85D26508E83_1307153303 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1307153303 = mCardState;
        varB4EAC82CA7396A68D541C85D26508E83_1307153303.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1307153303;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.830 -0400", hash_original_method = "DF1BA1B7D815247B6DDD09A8150ACB8E", hash_generated_method = "129DC0128092D4CDBF2170B5D21676E6")
    public void setCardState(int state) {
        
        mCardState = CardState.CARDSTATE_ABSENT;
        
        
        mCardState = CardState.CARDSTATE_PRESENT;
        
        
        mCardState = CardState.CARDSTATE_ERROR;
        
        
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unrecognized RIL_CardState: " + state);
        
        addTaint(state);
        
        
        
            
            
        
            
            
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.831 -0400", hash_original_method = "EAD880236056BC0FED4A918911F5B846", hash_generated_method = "D9EB8333E4A9F980D4CC2AEC3B2F15BF")
    public PinState getUniversalPinState() {
        PinState varB4EAC82CA7396A68D541C85D26508E83_1816383170 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1816383170 = mUniversalPinState;
        varB4EAC82CA7396A68D541C85D26508E83_1816383170.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1816383170;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.832 -0400", hash_original_method = "B5D48B53E99405CE8B767A81E3B60FC3", hash_generated_method = "0C139E91A6794361850581F0EE65077D")
    public void setUniversalPinState(int state) {
        
        mUniversalPinState = PinState.PINSTATE_UNKNOWN;
        
        
        mUniversalPinState = PinState.PINSTATE_ENABLED_NOT_VERIFIED;
        
        
        mUniversalPinState = PinState.PINSTATE_ENABLED_VERIFIED;
        
        
        mUniversalPinState = PinState.PINSTATE_DISABLED;
        
        
        mUniversalPinState = PinState.PINSTATE_ENABLED_BLOCKED;
        
        
        mUniversalPinState = PinState.PINSTATE_ENABLED_PERM_BLOCKED;
        
        
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unrecognized RIL_PinState: " + state);
        
        addTaint(state);
        
        
        
            
            
        
            
            
        
            
            
        
            
            
        
            
            
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.832 -0400", hash_original_method = "BB106B954443B302CECFC313EF7CB395", hash_generated_method = "6B387E2464718125797360AE55868CB7")
    public int getGsmUmtsSubscriptionAppIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044677459 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1044677459;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.833 -0400", hash_original_method = "08BD9E6DFC873F65C3F784287907D5E3", hash_generated_method = "03968C0784B0953DB1DC116AD2BB207A")
    public void setGsmUmtsSubscriptionAppIndex(int gsmUmtsSubscriptionAppIndex) {
        mGsmUmtsSubscriptionAppIndex = gsmUmtsSubscriptionAppIndex;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.833 -0400", hash_original_method = "2A192AC2BA1E64618C17CC6A1074F688", hash_generated_method = "658ACF9240068FDF8D5C5109F33FE8C1")
    public int getCdmaSubscriptionAppIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866603563 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_866603563;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.834 -0400", hash_original_method = "891E989E2EC1A38AF8B37DBC8E8322CF", hash_generated_method = "6D1B0649C9CFAF249D62B999C50E4C43")
    public void setCdmaSubscriptionAppIndex(int cdmaSubscriptionAppIndex) {
        mCdmaSubscriptionAppIndex = cdmaSubscriptionAppIndex;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.835 -0400", hash_original_method = "66775E00E5C07C014B4CD9717DAD3963", hash_generated_method = "966414EF21ACE5B3DA20999D9930B290")
    public int getImsSubscriptionAppIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922580674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_922580674;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.835 -0400", hash_original_method = "F62298652BB86C33D896C0D398774EF1", hash_generated_method = "EDDFA44F41288CFC56DC7BAF3703C59D")
    public void setImsSubscriptionAppIndex(int imsSubscriptionAppIndex) {
        mImsSubscriptionAppIndex = imsSubscriptionAppIndex;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.836 -0400", hash_original_method = "73A878FBCD525FA581932F7C6A7C55D4", hash_generated_method = "0E2892425140F61416B67B01BB4E452E")
    public int getNumApplications() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100150484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2100150484;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.837 -0400", hash_original_method = "6F974EA3499D29038B295A1FDDF2D7B1", hash_generated_method = "E0EE19C0A0A8F7AD8CB842C7430E7BAA")
    public void setNumApplications(int numApplications) {
        mNumApplications = numApplications;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.838 -0400", hash_original_method = "A2EAD3988F60EC73A08878F3FE639EE8", hash_generated_method = "38BA05FD585779959ADE2AC5945F94BA")
    public void addApplication(IccCardApplication application) {
        mApplications.add(application);
        addTaint(application.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.839 -0400", hash_original_method = "57D1023FA4D5ED682F8C58AD605F19ED", hash_generated_method = "D09FB3F30941887C29811FF91F1C51A6")
    public IccCardApplication getApplication(int index) {
        IccCardApplication varB4EAC82CA7396A68D541C85D26508E83_83529791 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_83529791 = mApplications.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_83529791.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_83529791;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.844 -0400", hash_original_method = "29E2CBB78335356F6993D73415A74DA6", hash_generated_method = "40100082B2C1B6340640CB59954CFBAB")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_36809112 = null; 
        IccCardApplication app;
        StringBuilder sb = new StringBuilder();
        sb.append("IccCardState {").append(mCardState).append(",")
        .append(mUniversalPinState)
        .append(",num_apps=").append(mNumApplications)
        .append(",gsm_id=").append(mGsmUmtsSubscriptionAppIndex);
        {
            app = getApplication(mGsmUmtsSubscriptionAppIndex);
            sb.append(app == null ? "null" : app);
        } 
        sb.append(",cmda_id=").append(mCdmaSubscriptionAppIndex);
        {
            app = getApplication(mCdmaSubscriptionAppIndex);
            sb.append(app == null ? "null" : app);
        } 
        sb.append(",ism_id=").append(mImsSubscriptionAppIndex);
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_36809112 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_36809112.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_36809112;
        
        
    }

    
    public enum CardState {
        CARDSTATE_ABSENT,
        CARDSTATE_PRESENT,
        CARDSTATE_ERROR;
        @DSModeled(DSC.SAFE)
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
        @DSModeled(DSC.SAFE)
        boolean isPermBlocked() {
            return this == PINSTATE_ENABLED_PERM_BLOCKED;
        }
        @DSModeled(DSC.SAFE)
        boolean isPinRequired() {
            return this == PINSTATE_ENABLED_NOT_VERIFIED;
        }
        @DSModeled(DSC.SAFE)
        boolean isPukRequired() {
            return this == PINSTATE_ENABLED_BLOCKED;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:21.845 -0400", hash_original_field = "9077F12194B02D6EF8AF620DF49E8A1B", hash_generated_field = "F5DEB270E27E9EBAAF4255B1D38C3900")

    static final int CARD_MAX_APPS = 8;
}

