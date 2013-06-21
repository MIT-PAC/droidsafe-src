package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class CatCmdMessage implements Parcelable {
    CommandDetails mCmdDet;
    private TextMessage mTextMsg;
    private Menu mMenu;
    private Input mInput;
    private BrowserSettings mBrowserSettings = null;
    private ToneSettings mToneSettings = null;
    private CallSettings mCallSettings = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.637 -0400", hash_original_method = "9BB462C60817EE3885822B8D2993699C", hash_generated_method = "528283FA18381D1B621D5680AF6A5B31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CatCmdMessage(CommandParams cmdParams) {
        dsTaint.addTaint(cmdParams.dsTaint);
        mCmdDet = cmdParams.cmdDet;
        {
            Object var7C0242CD3987BBBFEDEF25AAC224AE4E_1666929051 = (getCmdType());
            //Begin case SET_UP_MENU SELECT_ITEM 
            mMenu = ((SelectItemParams) cmdParams).menu;
            //End case SET_UP_MENU SELECT_ITEM 
            //Begin case DISPLAY_TEXT SET_UP_IDLE_MODE_TEXT SEND_DTMF SEND_SMS SEND_SS SEND_USSD 
            mTextMsg = ((DisplayTextParams) cmdParams).textMsg;
            //End case DISPLAY_TEXT SET_UP_IDLE_MODE_TEXT SEND_DTMF SEND_SMS SEND_SS SEND_USSD 
            //Begin case GET_INPUT GET_INKEY 
            mInput = ((GetInputParams) cmdParams).input;
            //End case GET_INPUT GET_INKEY 
            //Begin case LAUNCH_BROWSER 
            mTextMsg = ((LaunchBrowserParams) cmdParams).confirmMsg;
            //End case LAUNCH_BROWSER 
            //Begin case LAUNCH_BROWSER 
            mBrowserSettings = new BrowserSettings();
            //End case LAUNCH_BROWSER 
            //Begin case LAUNCH_BROWSER 
            mBrowserSettings.url = ((LaunchBrowserParams) cmdParams).url;
            //End case LAUNCH_BROWSER 
            //Begin case LAUNCH_BROWSER 
            mBrowserSettings.mode = ((LaunchBrowserParams) cmdParams).mode;
            //End case LAUNCH_BROWSER 
            //Begin case PLAY_TONE 
            PlayToneParams params;
            params = (PlayToneParams) cmdParams;
            //End case PLAY_TONE 
            //Begin case PLAY_TONE 
            mToneSettings = params.settings;
            //End case PLAY_TONE 
            //Begin case PLAY_TONE 
            mTextMsg = params.textMsg;
            //End case PLAY_TONE 
            //Begin case SET_UP_CALL 
            mCallSettings = new CallSettings();
            //End case SET_UP_CALL 
            //Begin case SET_UP_CALL 
            mCallSettings.confirmMsg = ((CallSetupParams) cmdParams).confirmMsg;
            //End case SET_UP_CALL 
            //Begin case SET_UP_CALL 
            mCallSettings.callMsg = ((CallSetupParams) cmdParams).callMsg;
            //End case SET_UP_CALL 
            //Begin case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            BIPClientParams param;
            param = (BIPClientParams) cmdParams;
            //End case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            //Begin case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
            mTextMsg = param.textMsg;
            //End case OPEN_CHANNEL CLOSE_CHANNEL RECEIVE_DATA SEND_DATA 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.638 -0400", hash_original_method = "306FD95D06B6EED68CF8CC22E17FB2A4", hash_generated_method = "A1A8F2C1121B5D4901B292FD417D2F50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CatCmdMessage(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mCmdDet = in.readParcelable(null);
        mTextMsg = in.readParcelable(null);
        mMenu = in.readParcelable(null);
        mInput = in.readParcelable(null);
        {
            Object var7C0242CD3987BBBFEDEF25AAC224AE4E_735127133 = (getCmdType());
            //Begin case LAUNCH_BROWSER 
            mBrowserSettings = new BrowserSettings();
            //End case LAUNCH_BROWSER 
            //Begin case LAUNCH_BROWSER 
            mBrowserSettings.url = in.readString();
            //End case LAUNCH_BROWSER 
            //Begin case LAUNCH_BROWSER 
            mBrowserSettings.mode = LaunchBrowserMode.values()[in.readInt()];
            //End case LAUNCH_BROWSER 
            //Begin case PLAY_TONE 
            mToneSettings = in.readParcelable(null);
            //End case PLAY_TONE 
            //Begin case SET_UP_CALL 
            mCallSettings = new CallSettings();
            //End case SET_UP_CALL 
            //Begin case SET_UP_CALL 
            mCallSettings.confirmMsg = in.readParcelable(null);
            //End case SET_UP_CALL 
            //Begin case SET_UP_CALL 
            mCallSettings.callMsg = in.readParcelable(null);
            //End case SET_UP_CALL 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mCmdDet = in.readParcelable(null);
        //mTextMsg = in.readParcelable(null);
        //mMenu = in.readParcelable(null);
        //mInput = in.readParcelable(null);
        //switch (getCmdType()) {
        //case LAUNCH_BROWSER:
            //mBrowserSettings = new BrowserSettings();
            //mBrowserSettings.url = in.readString();
            //mBrowserSettings.mode = LaunchBrowserMode.values()[in.readInt()];
            //break;
        //case PLAY_TONE:
            //mToneSettings = in.readParcelable(null);
            //break;
        //case SET_UP_CALL:
            //mCallSettings = new CallSettings();
            //mCallSettings.confirmMsg = in.readParcelable(null);
            //mCallSettings.callMsg = in.readParcelable(null);
            //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.638 -0400", hash_original_method = "295CE7717289B4264BB3488CE709915A", hash_generated_method = "B425DEA0AC79DC5387F6D8E44221EBF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeParcelable(mCmdDet, 0);
        dest.writeParcelable(mTextMsg, 0);
        dest.writeParcelable(mMenu, 0);
        dest.writeParcelable(mInput, 0);
        {
            Object var7C0242CD3987BBBFEDEF25AAC224AE4E_1071343287 = (getCmdType());
            //Begin case LAUNCH_BROWSER 
            dest.writeString(mBrowserSettings.url);
            //End case LAUNCH_BROWSER 
            //Begin case LAUNCH_BROWSER 
            dest.writeInt(mBrowserSettings.mode.ordinal());
            //End case LAUNCH_BROWSER 
            //Begin case PLAY_TONE 
            dest.writeParcelable(mToneSettings, 0);
            //End case PLAY_TONE 
            //Begin case SET_UP_CALL 
            dest.writeParcelable(mCallSettings.confirmMsg, 0);
            //End case SET_UP_CALL 
            //Begin case SET_UP_CALL 
            dest.writeParcelable(mCallSettings.callMsg, 0);
            //End case SET_UP_CALL 
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //dest.writeParcelable(mCmdDet, 0);
        //dest.writeParcelable(mTextMsg, 0);
        //dest.writeParcelable(mMenu, 0);
        //dest.writeParcelable(mInput, 0);
        //switch(getCmdType()) {
        //case LAUNCH_BROWSER:
            //dest.writeString(mBrowserSettings.url);
            //dest.writeInt(mBrowserSettings.mode.ordinal());
            //break;
        //case PLAY_TONE:
            //dest.writeParcelable(mToneSettings, 0);
            //break;
        //case SET_UP_CALL:
            //dest.writeParcelable(mCallSettings.confirmMsg, 0);
            //dest.writeParcelable(mCallSettings.callMsg, 0);
            //break;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.639 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.639 -0400", hash_original_method = "440B4EFDAC51D17D5534873190E2CFC2", hash_generated_method = "1F2F0814EF748CA40EF44C0B95E08A50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AppInterface.CommandType getCmdType() {
        AppInterface.CommandType var8543A8DB1EE4BD5DFE134A3435FE5518_565013845 = (AppInterface.CommandType.fromInt(mCmdDet.typeOfCommand));
        return (AppInterface.CommandType)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return AppInterface.CommandType.fromInt(mCmdDet.typeOfCommand);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.641 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "82DE804A4148BAAF0D64F7ADA6760AE7")
    @DSModeled(DSC.SAFE)
    public Menu getMenu() {
        return (Menu)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.641 -0400", hash_original_method = "C85A9B2343174A665E1C349326B79E38", hash_generated_method = "A3AAEB63E01C78B8A59099B3ED33A4DB")
    @DSModeled(DSC.SAFE)
    public Input geInput() {
        return (Input)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.641 -0400", hash_original_method = "036B73CC89055059C138E5824D02BCAD", hash_generated_method = "A51021B8519238CB6D0A7C004DD5ED17")
    @DSModeled(DSC.SAFE)
    public TextMessage geTextMessage() {
        return (TextMessage)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTextMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.641 -0400", hash_original_method = "C25A9BA40FBC0B8B0A069261C5A04294", hash_generated_method = "4C4741441F4B976ED35C7DCE2A2EB592")
    @DSModeled(DSC.SAFE)
    public BrowserSettings getBrowserSettings() {
        return (BrowserSettings)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBrowserSettings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.641 -0400", hash_original_method = "7E3240C4BE07A52ADC96DFEAA4674C6F", hash_generated_method = "B89C7F17CDFE6DFEDF72DCF959A2E636")
    @DSModeled(DSC.SAFE)
    public ToneSettings getToneSettings() {
        return (ToneSettings)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mToneSettings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.642 -0400", hash_original_method = "7782D77E1F5CCB427C450A93C0BFB1C1", hash_generated_method = "1029DF34EDC99A37C4B8F787D8E977D5")
    @DSModeled(DSC.SAFE)
    public CallSettings getCallSettings() {
        return (CallSettings)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mCallSettings;
    }

    
    public class BrowserSettings {
        public String url;
        public LaunchBrowserMode mode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.642 -0400", hash_original_method = "6AC663CF6E3D4D68A02BB086457FF072", hash_generated_method = "6AC663CF6E3D4D68A02BB086457FF072")
                public BrowserSettings ()
        {
        }


    }


    
    public class CallSettings {
        public TextMessage confirmMsg;
        public TextMessage callMsg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.642 -0400", hash_original_method = "A6E018D5DFECA6A67CE6F9FAD59DCD2C", hash_generated_method = "A6E018D5DFECA6A67CE6F9FAD59DCD2C")
                public CallSettings ()
        {
        }


    }


    
    public static final Parcelable.Creator<CatCmdMessage> CREATOR = new Parcelable.Creator<CatCmdMessage>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.642 -0400", hash_original_method = "4595398167E4395A49E9546F147C5CF0", hash_generated_method = "52B3A99F8BA1DEDF56C94C7FEFE0E540")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CatCmdMessage createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            CatCmdMessage var03EE70718C77C258C0D30D5A8D25313B_1126613119 = (new CatCmdMessage(in));
            return (CatCmdMessage)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CatCmdMessage(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.642 -0400", hash_original_method = "618CBEB6A41673A06EFD623BC8144103", hash_generated_method = "E845281F055D16FA301655BA0E5E33AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public CatCmdMessage[] newArray(int size) {
            dsTaint.addTaint(size);
            CatCmdMessage[] varCDB3199D644FB8BC9329FE57E2AAB696_333042800 = (new CatCmdMessage[size]);
            return (CatCmdMessage[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new CatCmdMessage[size];
        }

        
}; //Transformed anonymous class
}

