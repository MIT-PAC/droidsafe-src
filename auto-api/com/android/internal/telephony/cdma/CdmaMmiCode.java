package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import com.android.internal.telephony.CommandException;
import com.android.internal.telephony.MmiCode;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public final class CdmaMmiCode extends Handler implements MmiCode {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "571FE4403DDA9BF54693EBF4F0D6639D")

    Context context;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "418C5509E2171D55B0AEE5C2EA4442B5", hash_generated_field = "F0D53334D1D58D4E79746838A9C851E9")

    String action;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "D54185B71F614C30A396AC4BC44D3269", hash_generated_field = "1F12170F3EB5D5C8E81971C7E7A70DEB")

    String sc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "07AF7E75676EAB410D1F83937D7AFB62", hash_generated_field = "A81AA63AE09D96070D67E017AC9A9A05")

    String sia;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "A444633D8CF456EECA3138C78F4AE12E", hash_generated_field = "58A1CEF50FC10710B7250BC1FCA66342")

    String sib;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "82F5C1C9BE89C68344D5C6BCF404C804", hash_generated_field = "8A9043BD9E04D5B2D22710F5E973C72C")

    String sic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "A265DB9AE14F0DD90BC117F8B98A0755", hash_generated_field = "BB2724DBDDFCC035B982DADDB95A1B73")

    String poundString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "CEFDF90E0BAE9FC3A52CE140170834F6", hash_generated_field = "8E3BE840A192C669D20F33CA83223066")

    String dialingNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "9003D1DF22EB4D3820015070385194C8", hash_generated_field = "389FC73FC9600F29B99C9C32C4AF72ED")

    String pwd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "B355E0B84F8AFF2409A9BE6D26D2C44F", hash_generated_field = "1C260AF567CCE39E2DADC6C6A5D564F0")

    State state = State.PENDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.796 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "422FD4BFD34A850AED895188AD7E511B")

    CharSequence message;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.797 -0400", hash_original_method = "0E9735A507190BB775A80B2FEDEEE634", hash_generated_method = "3C26477742E86CC6E45CC5268A0F2AE9")
      CdmaMmiCode(CDMAPhone phone) {
        super(phone.getHandler().getLooper());
        this.phone = phone;
        this.context = phone.getContext();
        // ---------- Original Method ----------
        //this.phone = phone;
        //this.context = phone.getContext();
    }

    
        public static CdmaMmiCode newFromDialString(String dialString, CDMAPhone phone) {
        Matcher m;
        CdmaMmiCode ret = null;
        m = sPatternSuppService.matcher(dialString);
        if (m.matches()) {
            ret = new CdmaMmiCode(phone);
            ret.poundString = makeEmptyNull(m.group(MATCH_GROUP_POUND_STRING));
            ret.action = makeEmptyNull(m.group(MATCH_GROUP_ACTION));
            ret.sc = makeEmptyNull(m.group(MATCH_GROUP_SERVICE_CODE));
            ret.sia = makeEmptyNull(m.group(MATCH_GROUP_SIA));
            ret.sib = makeEmptyNull(m.group(MATCH_GROUP_SIB));
            ret.sic = makeEmptyNull(m.group(MATCH_GROUP_SIC));
            ret.pwd = makeEmptyNull(m.group(MATCH_GROUP_PWD_CONFIRM));
            ret.dialingNumber = makeEmptyNull(m.group(MATCH_GROUP_DIALING_NUMBER));
        }
        return ret;
    }

    
        private static String makeEmptyNull(String s) {
        if (s != null && s.length() == 0) return null;
        return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.806 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "3B3F29BCAF726ACD008077E285CE4F29")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_317350572 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_317350572 = state;
        varB4EAC82CA7396A68D541C85D26508E83_317350572.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_317350572;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.807 -0400", hash_original_method = "570FEAA437E41D0252DA00ACF07950A0", hash_generated_method = "5A6DB26CACC678E3C19132B8048373E2")
    public CharSequence getMessage() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1784926835 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1784926835 = message;
        varB4EAC82CA7396A68D541C85D26508E83_1784926835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1784926835;
        // ---------- Original Method ----------
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.807 -0400", hash_original_method = "7D43DA40239536121B4F58148ED0B98B", hash_generated_method = "38743023E5DCE6354E7A13760E727F5C")
    public void cancel() {
        state = State.CANCELLED;
        phone.onMMIDone (this);
        // ---------- Original Method ----------
        //if (state == State.COMPLETE || state == State.FAILED) {
            //return;
        //}
        //state = State.CANCELLED;
        //phone.onMMIDone (this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.807 -0400", hash_original_method = "ABB2058860BEBFF25C4A9C7B954D0A37", hash_generated_method = "3777527E1474ACF183377FED3ACBD552")
    public boolean isCancelable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1585745778 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1585745778;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.807 -0400", hash_original_method = "F83C3F3C3A6997A8F3CDD4D707F81FB0", hash_generated_method = "8AD013C75AD47182F5D96F4105ECC5C4")
     boolean isPukCommand() {
        boolean var371F3A7931E167CECB2D64F563A18326_869824952 = (sc != null && sc.equals(SC_PUK));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867066634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867066634;
        // ---------- Original Method ----------
        //return sc != null && sc.equals(SC_PUK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.808 -0400", hash_original_method = "CA7357DC4342746EF1FE3C742A9E7FC8", hash_generated_method = "FD93C1DC333CEF3F1B8E9402BACB8060")
     boolean isRegister() {
        boolean var8F8DE4A6AF200F3CCE4ABD0A031FFBC0_1160646752 = (action != null && action.equals(ACTION_REGISTER));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1564898155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1564898155;
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_REGISTER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.809 -0400", hash_original_method = "325A40B5366E66641BBFDAE340904BED", hash_generated_method = "C32F2041A2F6C88BA7E8E5F3A45FD45F")
    public boolean isUssdRequest() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_112618800 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_112618800;
        // ---------- Original Method ----------
        //Log.w(LOG_TAG, "isUssdRequest is not implemented in CdmaMmiCode");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.823 -0400", hash_original_method = "D40242C1775E5BFA18B0D32E606C72BC", hash_generated_method = "C481FBEBAE4703B18767806A1E0C7756")
     void processCode() {
        try 
        {
            {
                boolean varB4EA12E9B9BD9B4AA7429F91CF36E810_742600901 = (isPukCommand());
                {
                    String oldPinOrPuk;
                    oldPinOrPuk = sia;
                    String newPin;
                    newPin = sib;
                    int pinLen;
                    pinLen = newPin.length();
                    {
                        boolean varEA4E815E4B62E47FA77B50ABCAA83B6E_1381980371 = (isRegister());
                        {
                            {
                                boolean var1A02DE66B92C254F98F83985D3C86A02_840668496 = (!newPin.equals(sic));
                                {
                                    handlePasswordError(com.android.internal.R.string.mismatchPin);
                                } //End block
                                {
                                    handlePasswordError(com.android.internal.R.string.invalidPin);
                                } //End block
                                {
                                    phone.mCM.supplyIccPuk(oldPinOrPuk, newPin,
                                obtainMessage(EVENT_SET_COMPLETE, this));
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RuntimeException exc)
        {
            state = State.FAILED;
            message = context.getText(com.android.internal.R.string.mmiError);
            phone.onMMIDone(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.823 -0400", hash_original_method = "60196158E22905B06D5E62564673E5E1", hash_generated_method = "AF6C40B6962A4F309E3E610CFAB2D730")
    private void handlePasswordError(int res) {
        state = State.FAILED;
        StringBuilder sb;
        sb = new StringBuilder(getScString());
        sb.append("\n");
        sb.append(context.getText(res));
        message = sb;
        phone.onMMIDone(this);
        addTaint(res);
        // ---------- Original Method ----------
        //state = State.FAILED;
        //StringBuilder sb = new StringBuilder(getScString());
        //sb.append("\n");
        //sb.append(context.getText(res));
        //message = sb;
        //phone.onMMIDone(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.824 -0400", hash_original_method = "20352E1B7818DCA44840F8C27B44EA84", hash_generated_method = "9B1B40370E577AF2D7084273674FBADB")
    public void handleMessage(Message msg) {
        AsyncResult ar;
        {
            ar = (AsyncResult) (msg.obj);
            onSetComplete(ar);
        } //End block
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //AsyncResult ar;
        //if (msg.what == EVENT_SET_COMPLETE) {
            //ar = (AsyncResult) (msg.obj);
            //onSetComplete(ar);
        //} else {
            //Log.e(LOG_TAG, "Unexpected reply");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.824 -0400", hash_original_method = "DCFC51ECC309A2A613B704517DAD4649", hash_generated_method = "F3A8C14D87021DA9176A78FDEC822551")
    private CharSequence getScString() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2092265138 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1424937274 = null; //Variable for return #2
        {
            {
                boolean varB4EA12E9B9BD9B4AA7429F91CF36E810_2081632759 = (isPukCommand());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2092265138 = context.getText(com.android.internal.R.string.PinMmi);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1424937274 = "";
        CharSequence varA7E53CE21691AB073D9660D615818899_609523205; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_609523205 = varB4EAC82CA7396A68D541C85D26508E83_2092265138;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_609523205 = varB4EAC82CA7396A68D541C85D26508E83_1424937274;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_609523205.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_609523205;
        // ---------- Original Method ----------
        //if (sc != null) {
            //if (isPukCommand()) {
                //return context.getText(com.android.internal.R.string.PinMmi);
            //}
        //}
        //return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_method = "52C2461B739F9120EA0709185D4E10B9", hash_generated_method = "A6668F73C9DAE5EA500D24365DFA0D0F")
    private void onSetComplete(AsyncResult ar) {
        StringBuilder sb;
        sb = new StringBuilder(getScString());
        sb.append("\n");
        {
            state = State.FAILED;
            {
                CommandException.Error err;
                err = ((CommandException)(ar.exception)).getCommandError();
                {
                    {
                        boolean var7264D194DA23AC627D10ED044CFE74DF_1719618503 = (isPukCommand());
                        {
                            sb.append(context.getText(
                                com.android.internal.R.string.badPuk));
                        } //End block
                        {
                            sb.append(context.getText(
                                com.android.internal.R.string.passwordIncorrect));
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    sb.append(context.getText(
                            com.android.internal.R.string.mmiError));
                } //End block
            } //End block
            {
                sb.append(context.getText(
                        com.android.internal.R.string.mmiError));
            } //End block
        } //End block
        {
            boolean var4DDE405F14FB31FAE30FA9EB5093778E_1643022394 = (isRegister());
            {
                state = State.COMPLETE;
                sb.append(context.getText(
                    com.android.internal.R.string.serviceRegistered));
            } //End block
            {
                state = State.FAILED;
                sb.append(context.getText(
                    com.android.internal.R.string.mmiError));
            } //End block
        } //End collapsed parenthetic
        message = sb;
        phone.onMMIDone(this);
        addTaint(ar.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "76D85040174C5D7BAB27AEDF79036BEC", hash_generated_field = "A055278DC0193347ECFC5A1EDEB18BA7")

    static String LOG_TAG = "CDMA_MMI";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "B36D859659D29B3CF582794F8F07A110", hash_generated_field = "A7C2819604CBED112A4FCD46FBEE7793")

    static String ACTION_REGISTER = "**";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "5BAD5D2228CE32354A88D354D80B2D1B", hash_generated_field = "52D6EA3DA97CB2F6CC9A378A79272126")

    static String SC_PUK = "05";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "4C1215DA515DFC3564B3BB1182B13CFF", hash_generated_field = "C28C6E89E5E737E3205DD6BF7D09334C")

    static int EVENT_SET_COMPLETE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "E6AB098F50646317DD4CD4AD482AE641", hash_generated_field = "1B64CFB800A067861DC4A66690D66019")

    static Pattern sPatternSuppService = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)(.*)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "BB3719B16018B63D6E1AEFEF4670AD63", hash_generated_field = "67A82B8D8FFD3CEB2AC78DA930FA08EA")

    static int MATCH_GROUP_POUND_STRING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "90C3F831BEE8235DF8513B65A2F403D2", hash_generated_field = "3967DC6CB27B4A176DB06BB6965EA740")

    static int MATCH_GROUP_ACTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "CF0646443BB08F914B0A122FED173F6E", hash_generated_field = "8DF1955D2A80A64DF6CA9D07E7279925")

    static int MATCH_GROUP_SERVICE_CODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "99D1B083A79036DBCFC5A60D46F22411", hash_generated_field = "2DE2E56A202D75EA6DBC7E02F9C168B1")

    static int MATCH_GROUP_SIA = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "CDB9823919E9311E255A6F07A6DD9342", hash_generated_field = "727CAF1B82B6257573EF47EE75C4ECA5")

    static int MATCH_GROUP_SIB = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "1470B5B0F1CC2B70632F064AA14D1792", hash_generated_field = "9D7105B73000DCD3E53DB6C109CCDA24")

    static int MATCH_GROUP_SIC = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "F90A3CDD189D147E86CFA37AA82536DD", hash_generated_field = "B4452B6B6B57FCBB2B8E7D60831D61DB")

    static int MATCH_GROUP_PWD_CONFIRM = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:20.837 -0400", hash_original_field = "663794BFD8D4A5D988354CA3CFA9154D", hash_generated_field = "12AF7E84BC19F5E3B62CF4AF7BE7F361")

    static int MATCH_GROUP_DIALING_NUMBER = 12;
}

