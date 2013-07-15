package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class CatCmdMessage implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.727 -0400", hash_original_field = "FC5853EBD25A81E51480C1F88229B3D5", hash_generated_field = "F3BED1F8B7471EDFA3DEE43D0E822572")

    CommandDetails mCmdDet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.727 -0400", hash_original_field = "55947DD7A32A2317B8555D9CC8098132", hash_generated_field = "95BA37E81B305AD16C052C1DE2B63A00")

    private TextMessage mTextMsg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.728 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "BA8FAC39BC14653B8489A88E4C7F45E8")

    private Menu mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.728 -0400", hash_original_field = "BF2A01F10E67DAFA01668D8D4043BDC6", hash_generated_field = "1653B4A7DC6935A0E7A2A3521BF59B41")

    private Input mInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.728 -0400", hash_original_field = "F573800E32B1824797EA18578CE3D932", hash_generated_field = "A148C19D41A4942661C2294406E6034F")

    private BrowserSettings mBrowserSettings = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.728 -0400", hash_original_field = "A0BE8F174186FD5F2F569457C2788D72", hash_generated_field = "67589C53D525A47287676DEA903A92DD")

    private ToneSettings mToneSettings = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.728 -0400", hash_original_field = "748224E697A64A0739269F79D08A92C5", hash_generated_field = "4DCADAA8CE4074A01B7E7DBABA47BE34")

    private CallSettings mCallSettings = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.729 -0400", hash_original_method = "85FA7BFB98F5F6D568F6D9939AB5FCD7", hash_generated_method = "45E9E265D510238C3160EABB59921F96")
      CatCmdMessage(CommandParams cmdParams) {
        mCmdDet = cmdParams.cmdDet;
switch(getCmdType()){
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.732 -0400", hash_original_method = "306FD95D06B6EED68CF8CC22E17FB2A4", hash_generated_method = "3572395BC985833F9F3127C07E6CE921")
    public  CatCmdMessage(Parcel in) {
        mCmdDet = in.readParcelable(null);
        mTextMsg = in.readParcelable(null);
        mMenu = in.readParcelable(null);
        mInput = in.readParcelable(null);
switch(getCmdType()){
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.732 -0400", hash_original_method = "295CE7717289B4264BB3488CE709915A", hash_generated_method = "DEEF93DB332FEDC0995A73666B414E6E")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeParcelable(mCmdDet, 0);
        dest.writeParcelable(mTextMsg, 0);
        dest.writeParcelable(mMenu, 0);
        dest.writeParcelable(mInput, 0);
switch(getCmdType()){
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.733 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3CBC270B0468CBF28EA33276FBB40EE8")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1586098707 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771358723 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_771358723;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.733 -0400", hash_original_method = "440B4EFDAC51D17D5534873190E2CFC2", hash_generated_method = "F03365DB8245B75E898863A11A5298AE")
    public AppInterface.CommandType getCmdType() {
AppInterface.CommandType varA683FB7A9A13DB88A682BED484FDB4AC_2099977219 =         AppInterface.CommandType.fromInt(mCmdDet.typeOfCommand);
        varA683FB7A9A13DB88A682BED484FDB4AC_2099977219.addTaint(taint);
        return varA683FB7A9A13DB88A682BED484FDB4AC_2099977219;
        // ---------- Original Method ----------
        //return AppInterface.CommandType.fromInt(mCmdDet.typeOfCommand);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.733 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "868E5C0106368A29D5BA61CDF4ABD5F5")
    public Menu getMenu() {
Menu var10D851031FD6BA7C53B0186C7F1D9213_1140021716 =         mMenu;
        var10D851031FD6BA7C53B0186C7F1D9213_1140021716.addTaint(taint);
        return var10D851031FD6BA7C53B0186C7F1D9213_1140021716;
        // ---------- Original Method ----------
        //return mMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.733 -0400", hash_original_method = "C85A9B2343174A665E1C349326B79E38", hash_generated_method = "0C22DBC6400EBD9159736A15846ADA42")
    public Input geInput() {
Input var5EBB3E30E30E9FC3A51B2E7E91DCB5FE_400443564 =         mInput;
        var5EBB3E30E30E9FC3A51B2E7E91DCB5FE_400443564.addTaint(taint);
        return var5EBB3E30E30E9FC3A51B2E7E91DCB5FE_400443564;
        // ---------- Original Method ----------
        //return mInput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.734 -0400", hash_original_method = "036B73CC89055059C138E5824D02BCAD", hash_generated_method = "D665E89C1883EBE55A5C67C89D56D7EA")
    public TextMessage geTextMessage() {
TextMessage var91B4A201CA718B216069C33DDA2396AF_1277975001 =         mTextMsg;
        var91B4A201CA718B216069C33DDA2396AF_1277975001.addTaint(taint);
        return var91B4A201CA718B216069C33DDA2396AF_1277975001;
        // ---------- Original Method ----------
        //return mTextMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.734 -0400", hash_original_method = "C25A9BA40FBC0B8B0A069261C5A04294", hash_generated_method = "81B3C3EDC0133D9A9C1A28E923618AD2")
    public BrowserSettings getBrowserSettings() {
BrowserSettings var2B8CF6D94FAAFA8D1F008DBC148D5DB9_1377565042 =         mBrowserSettings;
        var2B8CF6D94FAAFA8D1F008DBC148D5DB9_1377565042.addTaint(taint);
        return var2B8CF6D94FAAFA8D1F008DBC148D5DB9_1377565042;
        // ---------- Original Method ----------
        //return mBrowserSettings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.734 -0400", hash_original_method = "7E3240C4BE07A52ADC96DFEAA4674C6F", hash_generated_method = "26EDE40432441115FF1CA96A1D41688C")
    public ToneSettings getToneSettings() {
ToneSettings varE0D8F704D90D63C32C75F848926DB3CF_454140980 =         mToneSettings;
        varE0D8F704D90D63C32C75F848926DB3CF_454140980.addTaint(taint);
        return varE0D8F704D90D63C32C75F848926DB3CF_454140980;
        // ---------- Original Method ----------
        //return mToneSettings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.734 -0400", hash_original_method = "7782D77E1F5CCB427C450A93C0BFB1C1", hash_generated_method = "49977913DA7F41E1738D1360171F84FF")
    public CallSettings getCallSettings() {
CallSettings var8E0FC694A78A0D1D49799D2C92B59218_1050822326 =         mCallSettings;
        var8E0FC694A78A0D1D49799D2C92B59218_1050822326.addTaint(taint);
        return var8E0FC694A78A0D1D49799D2C92B59218_1050822326;
        // ---------- Original Method ----------
        //return mCallSettings;
    }

    
    public class BrowserSettings {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.734 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "51C843584AF7FEEEC1BC36266893D9E3")

        public String url;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.734 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "AD474836BE6C6BACEFFF3A292B89CF50")

        public LaunchBrowserMode mode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.734 -0400", hash_original_method = "290DD86DB6C194D95C4634D36677ECAA", hash_generated_method = "290DD86DB6C194D95C4634D36677ECAA")
        public BrowserSettings ()
        {
            //Synthesized constructor
        }


    }


    
    public class CallSettings {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.735 -0400", hash_original_field = "06B4D899C3434F9B6E6ACC3F56239187", hash_generated_field = "6B0A9871C084B1A19AD04EFDCF9D8F63")

        public TextMessage confirmMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.735 -0400", hash_original_field = "C92AF136DB908B735C01311448F4DE71", hash_generated_field = "C3620957A179529F73856288CE265C94")

        public TextMessage callMsg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.735 -0400", hash_original_method = "28C9A5C9E4697FF118CEC7F372F0E1C6", hash_generated_method = "28C9A5C9E4697FF118CEC7F372F0E1C6")
        public CallSettings ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.735 -0400", hash_original_field = "813EE9C3EA954A2ED8EA1B649296F1E1", hash_generated_field = "8249415CCA348F6779E9FD531D50B60E")

    public static final Parcelable.Creator<CatCmdMessage> CREATOR = new Parcelable.Creator<CatCmdMessage>() {
        public CatCmdMessage createFromParcel(Parcel in) {
            return new CatCmdMessage(in);
        }

        public CatCmdMessage[] newArray(int size) {
            return new CatCmdMessage[size];
        }
    };
    // orphaned legacy method
    public CatCmdMessage createFromParcel(Parcel in) {
            return new CatCmdMessage(in);
        }
    
    // orphaned legacy method
    public CatCmdMessage[] newArray(int size) {
            return new CatCmdMessage[size];
        }
    
}

