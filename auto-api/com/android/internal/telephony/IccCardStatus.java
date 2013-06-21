package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;

public class IccCardStatus {
    private CardState  mCardState;
    private PinState   mUniversalPinState;
    private int        mGsmUmtsSubscriptionAppIndex;
    private int        mCdmaSubscriptionAppIndex;
    private int        mImsSubscriptionAppIndex;
    private int        mNumApplications;
    private ArrayList<IccCardApplication> mApplications =
            new ArrayList<IccCardApplication>(CARD_MAX_APPS);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.294 -0400", hash_original_method = "B1DBE66DA40980F3FDD270609402F013", hash_generated_method = "B1DBE66DA40980F3FDD270609402F013")
        public IccCardStatus ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.294 -0400", hash_original_method = "FA0602D88E7C21991E0740ABD82BDA04", hash_generated_method = "4F8EDB5ABC949101E9A5CEA6129E76DF")
    @DSModeled(DSC.SAFE)
    public CardState getCardState() {
        return (CardState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCardState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.295 -0400", hash_original_method = "DF1BA1B7D815247B6DDD09A8150ACB8E", hash_generated_method = "FBDB025F2A2B9358D84A041F6646C3CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCardState(int state) {
        dsTaint.addTaint(state);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.295 -0400", hash_original_method = "EAD880236056BC0FED4A918911F5B846", hash_generated_method = "4A36A86BA49DF3075A020AB0545D18F4")
    @DSModeled(DSC.SAFE)
    public PinState getUniversalPinState() {
        return (PinState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mUniversalPinState;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.295 -0400", hash_original_method = "B5D48B53E99405CE8B767A81E3B60FC3", hash_generated_method = "1BDE401C1F12B16EEF95137B72A66E1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUniversalPinState(int state) {
        dsTaint.addTaint(state);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.295 -0400", hash_original_method = "BB106B954443B302CECFC313EF7CB395", hash_generated_method = "F2D0DAB991DD213AECA4AE5F0F1DD7C3")
    @DSModeled(DSC.SAFE)
    public int getGsmUmtsSubscriptionAppIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mGsmUmtsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.295 -0400", hash_original_method = "08BD9E6DFC873F65C3F784287907D5E3", hash_generated_method = "47D3B1866E607FD38EB778257655A357")
    @DSModeled(DSC.SAFE)
    public void setGsmUmtsSubscriptionAppIndex(int gsmUmtsSubscriptionAppIndex) {
        dsTaint.addTaint(gsmUmtsSubscriptionAppIndex);
        // ---------- Original Method ----------
        //mGsmUmtsSubscriptionAppIndex = gsmUmtsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.296 -0400", hash_original_method = "2A192AC2BA1E64618C17CC6A1074F688", hash_generated_method = "4F00528632B733093049E35BE0FC04FE")
    @DSModeled(DSC.SAFE)
    public int getCdmaSubscriptionAppIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mCdmaSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.296 -0400", hash_original_method = "891E989E2EC1A38AF8B37DBC8E8322CF", hash_generated_method = "355E3DEEF251B6B01A8008D4B65B1E55")
    @DSModeled(DSC.SAFE)
    public void setCdmaSubscriptionAppIndex(int cdmaSubscriptionAppIndex) {
        dsTaint.addTaint(cdmaSubscriptionAppIndex);
        // ---------- Original Method ----------
        //mCdmaSubscriptionAppIndex = cdmaSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.296 -0400", hash_original_method = "66775E00E5C07C014B4CD9717DAD3963", hash_generated_method = "457ECFD09112F695E53A8A76AC7F4FC6")
    @DSModeled(DSC.SAFE)
    public int getImsSubscriptionAppIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mImsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.296 -0400", hash_original_method = "F62298652BB86C33D896C0D398774EF1", hash_generated_method = "73775D4A8C338CAF1D2A010BB6468F03")
    @DSModeled(DSC.SAFE)
    public void setImsSubscriptionAppIndex(int imsSubscriptionAppIndex) {
        dsTaint.addTaint(imsSubscriptionAppIndex);
        // ---------- Original Method ----------
        //mImsSubscriptionAppIndex = imsSubscriptionAppIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.296 -0400", hash_original_method = "73A878FBCD525FA581932F7C6A7C55D4", hash_generated_method = "C70291C570F0F2255FC4FCBCAC3E65CA")
    @DSModeled(DSC.SAFE)
    public int getNumApplications() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNumApplications;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.296 -0400", hash_original_method = "6F974EA3499D29038B295A1FDDF2D7B1", hash_generated_method = "5C632E30244C24809D5277A75D640703")
    @DSModeled(DSC.SAFE)
    public void setNumApplications(int numApplications) {
        dsTaint.addTaint(numApplications);
        // ---------- Original Method ----------
        //mNumApplications = numApplications;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.296 -0400", hash_original_method = "A2EAD3988F60EC73A08878F3FE639EE8", hash_generated_method = "D691D42C81A30FA5E18749895CC6146C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addApplication(IccCardApplication application) {
        dsTaint.addTaint(application.dsTaint);
        mApplications.add(application);
        // ---------- Original Method ----------
        //mApplications.add(application);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.297 -0400", hash_original_method = "57D1023FA4D5ED682F8C58AD605F19ED", hash_generated_method = "FBFE1F35AFFD939525EE2B3DF847D2D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IccCardApplication getApplication(int index) {
        dsTaint.addTaint(index);
        IccCardApplication var49B9C0C4780A581FE0E144FA3F666ACC_1074080218 = (mApplications.get(index));
        return (IccCardApplication)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mApplications.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.297 -0400", hash_original_method = "29E2CBB78335356F6993D73415A74DA6", hash_generated_method = "77918F19A240EECB548501EE9D0F6BBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
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
        String var806458D832AB974D230FEE4CBBDBD390_1916362781 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    static final int CARD_MAX_APPS = 8;
}

