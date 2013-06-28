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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.162 -0400", hash_original_field = "FC5853EBD25A81E51480C1F88229B3D5", hash_generated_field = "F3BED1F8B7471EDFA3DEE43D0E822572")

    CommandDetails mCmdDet;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.162 -0400", hash_original_field = "55947DD7A32A2317B8555D9CC8098132", hash_generated_field = "95BA37E81B305AD16C052C1DE2B63A00")

    private TextMessage mTextMsg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.162 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "BA8FAC39BC14653B8489A88E4C7F45E8")

    private Menu mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.162 -0400", hash_original_field = "BF2A01F10E67DAFA01668D8D4043BDC6", hash_generated_field = "1653B4A7DC6935A0E7A2A3521BF59B41")

    private Input mInput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.162 -0400", hash_original_field = "F573800E32B1824797EA18578CE3D932", hash_generated_field = "A148C19D41A4942661C2294406E6034F")

    private BrowserSettings mBrowserSettings = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.162 -0400", hash_original_field = "A0BE8F174186FD5F2F569457C2788D72", hash_generated_field = "67589C53D525A47287676DEA903A92DD")

    private ToneSettings mToneSettings = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.162 -0400", hash_original_field = "748224E697A64A0739269F79D08A92C5", hash_generated_field = "4DCADAA8CE4074A01B7E7DBABA47BE34")

    private CallSettings mCallSettings = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.163 -0400", hash_original_method = "85FA7BFB98F5F6D568F6D9939AB5FCD7", hash_generated_method = "F82C5894B42EBD4002EC8BF43DC21D98")
      CatCmdMessage(CommandParams cmdParams) {
        mCmdDet = cmdParams.cmdDet;
        {
            Object var7C0242CD3987BBBFEDEF25AAC224AE4E_542372589 = (getCmdType());
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
            PlayToneParams params = (PlayToneParams) cmdParams;
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
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.164 -0400", hash_original_method = "306FD95D06B6EED68CF8CC22E17FB2A4", hash_generated_method = "6F0993B8E152B7649311E2938CFC4582")
    public  CatCmdMessage(Parcel in) {
        mCmdDet = in.readParcelable(null);
        mTextMsg = in.readParcelable(null);
        mMenu = in.readParcelable(null);
        mInput = in.readParcelable(null);
        {
            Object var7C0242CD3987BBBFEDEF25AAC224AE4E_365619948 = (getCmdType());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.164 -0400", hash_original_method = "295CE7717289B4264BB3488CE709915A", hash_generated_method = "094137AB399134CBA66560EEB83F3A04")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(mCmdDet, 0);
        dest.writeParcelable(mTextMsg, 0);
        dest.writeParcelable(mMenu, 0);
        dest.writeParcelable(mInput, 0);
        {
            Object var7C0242CD3987BBBFEDEF25AAC224AE4E_992990359 = (getCmdType());
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
        addTaint(dest.getTaint());
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.165 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D3FA9CBA353C431B56ABB180B0F5B013")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204360083 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204360083;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.165 -0400", hash_original_method = "440B4EFDAC51D17D5534873190E2CFC2", hash_generated_method = "C56D5A7F2005E36D17ADD4A26470015B")
    public AppInterface.CommandType getCmdType() {
        AppInterface.CommandType varB4EAC82CA7396A68D541C85D26508E83_1976153922 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1976153922 = AppInterface.CommandType.fromInt(mCmdDet.typeOfCommand);
        varB4EAC82CA7396A68D541C85D26508E83_1976153922.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1976153922;
        // ---------- Original Method ----------
        //return AppInterface.CommandType.fromInt(mCmdDet.typeOfCommand);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.166 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "B8112A00B937154CA4B007DE355BB9A2")
    public Menu getMenu() {
        Menu varB4EAC82CA7396A68D541C85D26508E83_589191472 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_589191472 = mMenu;
        varB4EAC82CA7396A68D541C85D26508E83_589191472.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_589191472;
        // ---------- Original Method ----------
        //return mMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.166 -0400", hash_original_method = "C85A9B2343174A665E1C349326B79E38", hash_generated_method = "ACA82EE8AAE924DB7A8CE1EA6439858C")
    public Input geInput() {
        Input varB4EAC82CA7396A68D541C85D26508E83_1618955143 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1618955143 = mInput;
        varB4EAC82CA7396A68D541C85D26508E83_1618955143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1618955143;
        // ---------- Original Method ----------
        //return mInput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.167 -0400", hash_original_method = "036B73CC89055059C138E5824D02BCAD", hash_generated_method = "F0C3BFBA3F18AE984065B2132DFCE9CE")
    public TextMessage geTextMessage() {
        TextMessage varB4EAC82CA7396A68D541C85D26508E83_85001012 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_85001012 = mTextMsg;
        varB4EAC82CA7396A68D541C85D26508E83_85001012.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_85001012;
        // ---------- Original Method ----------
        //return mTextMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.167 -0400", hash_original_method = "C25A9BA40FBC0B8B0A069261C5A04294", hash_generated_method = "6B720845FFFCE1F13A9838858F88A43F")
    public BrowserSettings getBrowserSettings() {
        BrowserSettings varB4EAC82CA7396A68D541C85D26508E83_565476183 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_565476183 = mBrowserSettings;
        varB4EAC82CA7396A68D541C85D26508E83_565476183.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_565476183;
        // ---------- Original Method ----------
        //return mBrowserSettings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.168 -0400", hash_original_method = "7E3240C4BE07A52ADC96DFEAA4674C6F", hash_generated_method = "B5953564E238C7D6F8D3E33C417C64CF")
    public ToneSettings getToneSettings() {
        ToneSettings varB4EAC82CA7396A68D541C85D26508E83_65790701 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_65790701 = mToneSettings;
        varB4EAC82CA7396A68D541C85D26508E83_65790701.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_65790701;
        // ---------- Original Method ----------
        //return mToneSettings;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.168 -0400", hash_original_method = "7782D77E1F5CCB427C450A93C0BFB1C1", hash_generated_method = "34BDA4ACDF8CEC9F56E920DEDCD0A79E")
    public CallSettings getCallSettings() {
        CallSettings varB4EAC82CA7396A68D541C85D26508E83_698712767 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_698712767 = mCallSettings;
        varB4EAC82CA7396A68D541C85D26508E83_698712767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_698712767;
        // ---------- Original Method ----------
        //return mCallSettings;
    }

    
    public class BrowserSettings {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.168 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "51C843584AF7FEEEC1BC36266893D9E3")

        public String url;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.168 -0400", hash_original_field = "15D61712450A686A7F365ADF4FEF581F", hash_generated_field = "AD474836BE6C6BACEFFF3A292B89CF50")

        public LaunchBrowserMode mode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.168 -0400", hash_original_method = "290DD86DB6C194D95C4634D36677ECAA", hash_generated_method = "290DD86DB6C194D95C4634D36677ECAA")
        public BrowserSettings ()
        {
            //Synthesized constructor
        }


    }


    
    public class CallSettings {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.168 -0400", hash_original_field = "06B4D899C3434F9B6E6ACC3F56239187", hash_generated_field = "6B0A9871C084B1A19AD04EFDCF9D8F63")

        public TextMessage confirmMsg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.169 -0400", hash_original_field = "C92AF136DB908B735C01311448F4DE71", hash_generated_field = "C3620957A179529F73856288CE265C94")

        public TextMessage callMsg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.169 -0400", hash_original_method = "28C9A5C9E4697FF118CEC7F372F0E1C6", hash_generated_method = "28C9A5C9E4697FF118CEC7F372F0E1C6")
        public CallSettings ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.169 -0400", hash_original_field = "813EE9C3EA954A2ED8EA1B649296F1E1", hash_generated_field = "8249415CCA348F6779E9FD531D50B60E")

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

