package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class CatCmdMessage implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.713 -0400", hash_original_field = "813EE9C3EA954A2ED8EA1B649296F1E1", hash_generated_field = "8249415CCA348F6779E9FD531D50B60E")

    public static final Parcelable.Creator<CatCmdMessage> CREATOR = new Parcelable.Creator<CatCmdMessage>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.388 -0500", hash_original_method = "4595398167E4395A49E9546F147C5CF0", hash_generated_method = "939296841E86D98BF60F3DC2F8FA32CD")
        
public CatCmdMessage createFromParcel(Parcel in) {
            return new CatCmdMessage(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.390 -0500", hash_original_method = "618CBEB6A41673A06EFD623BC8144103", hash_generated_method = "D6E88631290C7D79C955A1C5D2114290")
        
public CatCmdMessage[] newArray(int size) {
            return new CatCmdMessage[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.347 -0500", hash_original_field = "F3BED1F8B7471EDFA3DEE43D0E822572", hash_generated_field = "F3BED1F8B7471EDFA3DEE43D0E822572")

    CommandDetails mCmdDet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.349 -0500", hash_original_field = "2FB18D66D4346E1604AF23F949AE2640", hash_generated_field = "95BA37E81B305AD16C052C1DE2B63A00")

    private TextMessage mTextMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.352 -0500", hash_original_field = "3ACDC4FB192289AC415FA5263D322EC6", hash_generated_field = "BA8FAC39BC14653B8489A88E4C7F45E8")

    private Menu mMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.354 -0500", hash_original_field = "F1334C4B5A1BDEEFADEE4C4056C90835", hash_generated_field = "1653B4A7DC6935A0E7A2A3521BF59B41")

    private Input mInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.356 -0500", hash_original_field = "3976E27DC128F87E2F9E13C7E932A608", hash_generated_field = "A148C19D41A4942661C2294406E6034F")

    private BrowserSettings mBrowserSettings = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.359 -0500", hash_original_field = "F2382422333951EAA25CFD2E42401BED", hash_generated_field = "67589C53D525A47287676DEA903A92DD")

    private ToneSettings mToneSettings = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.362 -0500", hash_original_field = "C4367788319613A6D8D584D1E342E101", hash_generated_field = "4DCADAA8CE4074A01B7E7DBABA47BE34")

    private CallSettings mCallSettings = null;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.379 -0500", hash_original_method = "85FA7BFB98F5F6D568F6D9939AB5FCD7", hash_generated_method = "85FA7BFB98F5F6D568F6D9939AB5FCD7")
    
CatCmdMessage(CommandParams cmdParams) {
        mCmdDet = cmdParams.cmdDet;
        switch(getCmdType()) {
        case SET_UP_MENU:
        case SELECT_ITEM:
            mMenu = ((SelectItemParams) cmdParams).menu;
            break;
        case DISPLAY_TEXT:
        case SET_UP_IDLE_MODE_TEXT:
        case SEND_DTMF:
        case SEND_SMS:
        case SEND_SS:
        case SEND_USSD:
            mTextMsg = ((DisplayTextParams) cmdParams).textMsg;
            break;
        case GET_INPUT:
        case GET_INKEY:
            mInput = ((GetInputParams) cmdParams).input;
            break;
        case LAUNCH_BROWSER:
            mTextMsg = ((LaunchBrowserParams) cmdParams).confirmMsg;
            mBrowserSettings = new BrowserSettings();
            mBrowserSettings.url = ((LaunchBrowserParams) cmdParams).url;
            mBrowserSettings.mode = ((LaunchBrowserParams) cmdParams).mode;
            break;
        case PLAY_TONE:
            PlayToneParams params = (PlayToneParams) cmdParams;
            mToneSettings = params.settings;
            mTextMsg = params.textMsg;
            break;
        case SET_UP_CALL:
            mCallSettings = new CallSettings();
            mCallSettings.confirmMsg = ((CallSetupParams) cmdParams).confirmMsg;
            mCallSettings.callMsg = ((CallSetupParams) cmdParams).callMsg;
            break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.382 -0500", hash_original_method = "306FD95D06B6EED68CF8CC22E17FB2A4", hash_generated_method = "6E50AD8643A2FDBCEADB3310A3375CCF")
    
public CatCmdMessage(Parcel in) {
        mCmdDet = in.readParcelable(null);
        mTextMsg = in.readParcelable(null);
        mMenu = in.readParcelable(null);
        mInput = in.readParcelable(null);
        switch (getCmdType()) {
        case LAUNCH_BROWSER:
            mBrowserSettings = new BrowserSettings();
            mBrowserSettings.url = in.readString();
            mBrowserSettings.mode = LaunchBrowserMode.values()[in.readInt()];
            break;
        case PLAY_TONE:
            mToneSettings = in.readParcelable(null);
            break;
        case SET_UP_CALL:
            mCallSettings = new CallSettings();
            mCallSettings.confirmMsg = in.readParcelable(null);
            mCallSettings.callMsg = in.readParcelable(null);
            break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.385 -0500", hash_original_method = "295CE7717289B4264BB3488CE709915A", hash_generated_method = "9EA8AACC31365F69F7E044A42AD0CE8B")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mCmdDet, 0);
        dest.writeParcelable(mTextMsg, 0);
        dest.writeParcelable(mMenu, 0);
        dest.writeParcelable(mInput, 0);
        switch(getCmdType()) {
        case LAUNCH_BROWSER:
            dest.writeString(mBrowserSettings.url);
            dest.writeInt(mBrowserSettings.mode.ordinal());
            break;
        case PLAY_TONE:
            dest.writeParcelable(mToneSettings, 0);
            break;
        case SET_UP_CALL:
            dest.writeParcelable(mCallSettings.confirmMsg, 0);
            dest.writeParcelable(mCallSettings.callMsg, 0);
            break;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.396 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /* external API to be used by application */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.398 -0500", hash_original_method = "440B4EFDAC51D17D5534873190E2CFC2", hash_generated_method = "99FF7EF80AC75BBB449211635F85EC54")
    
public AppInterface.CommandType getCmdType() {
        return AppInterface.CommandType.fromInt(mCmdDet.typeOfCommand);
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.401 -0500", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "DCDBC063D5B5258CB417C095AA16E240")
    
public Menu getMenu() {
        return mMenu;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.403 -0500", hash_original_method = "C85A9B2343174A665E1C349326B79E38", hash_generated_method = "DD81A45C55601B9A8C3836C9D6E994F5")
    
public Input geInput() {
        return mInput;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.405 -0500", hash_original_method = "036B73CC89055059C138E5824D02BCAD", hash_generated_method = "66289A3F49AACFA726A339419149623B")
    
public TextMessage geTextMessage() {
        return mTextMsg;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.408 -0500", hash_original_method = "C25A9BA40FBC0B8B0A069261C5A04294", hash_generated_method = "FEA290FDBF2EE2D14BC33CB2151F457C")
    
public BrowserSettings getBrowserSettings() {
        return mBrowserSettings;
    }

    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.410 -0500", hash_original_method = "7E3240C4BE07A52ADC96DFEAA4674C6F", hash_generated_method = "532037AD900501825AFB75B03F43FB35")
    
public ToneSettings getToneSettings() {
        return mToneSettings;
    }
    
    public class BrowserSettings {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.365 -0500", hash_original_field = "1B433832A8D8C8722BF3FE2FD98C7841", hash_generated_field = "51C843584AF7FEEEC1BC36266893D9E3")

        public String url;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.367 -0500", hash_original_field = "A5764D2D4FA704D86881B5DFDB508312", hash_generated_field = "AD474836BE6C6BACEFFF3A292B89CF50")

        public LaunchBrowserMode mode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.712 -0400", hash_original_method = "290DD86DB6C194D95C4634D36677ECAA", hash_generated_method = "290DD86DB6C194D95C4634D36677ECAA")
        public BrowserSettings ()
        {
            //Synthesized constructor
        }

    }
    
    public class CallSettings {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.372 -0500", hash_original_field = "B2111E59C12A8525442758C5427A208C", hash_generated_field = "6B0A9871C084B1A19AD04EFDCF9D8F63")

        public TextMessage confirmMsg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.374 -0500", hash_original_field = "965D344D08F644937D8D78D46A2A1817", hash_generated_field = "C3620957A179529F73856288CE265C94")

        public TextMessage callMsg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.713 -0400", hash_original_method = "28C9A5C9E4697FF118CEC7F372F0E1C6", hash_generated_method = "28C9A5C9E4697FF118CEC7F372F0E1C6")
        public CallSettings ()
        {
            //Synthesized constructor
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.412 -0500", hash_original_method = "7782D77E1F5CCB427C450A93C0BFB1C1", hash_generated_method = "F60B390939EEB8E03CA04586F80129AA")
    
public CallSettings getCallSettings() {
        return mCallSettings;
    }
    // orphaned legacy method
    public CatCmdMessage createFromParcel(Parcel in) {
            return new CatCmdMessage(in);
        }
    
    // orphaned legacy method
    public CatCmdMessage[] newArray(int size) {
            return new CatCmdMessage[size];
        }
    
}

