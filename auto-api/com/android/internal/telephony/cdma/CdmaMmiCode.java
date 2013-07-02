package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "571FE4403DDA9BF54693EBF4F0D6639D")

    Context context;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "418C5509E2171D55B0AEE5C2EA4442B5", hash_generated_field = "F0D53334D1D58D4E79746838A9C851E9")

    String action;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "D54185B71F614C30A396AC4BC44D3269", hash_generated_field = "1F12170F3EB5D5C8E81971C7E7A70DEB")

    String sc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "07AF7E75676EAB410D1F83937D7AFB62", hash_generated_field = "A81AA63AE09D96070D67E017AC9A9A05")

    String sia;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "A444633D8CF456EECA3138C78F4AE12E", hash_generated_field = "58A1CEF50FC10710B7250BC1FCA66342")

    String sib;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "82F5C1C9BE89C68344D5C6BCF404C804", hash_generated_field = "8A9043BD9E04D5B2D22710F5E973C72C")

    String sic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "A265DB9AE14F0DD90BC117F8B98A0755", hash_generated_field = "BB2724DBDDFCC035B982DADDB95A1B73")

    String poundString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "CEFDF90E0BAE9FC3A52CE140170834F6", hash_generated_field = "8E3BE840A192C669D20F33CA83223066")

    String dialingNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "9003D1DF22EB4D3820015070385194C8", hash_generated_field = "389FC73FC9600F29B99C9C32C4AF72ED")

    String pwd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "B355E0B84F8AFF2409A9BE6D26D2C44F", hash_generated_field = "1C260AF567CCE39E2DADC6C6A5D564F0")

    State state = State.PENDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.049 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "422FD4BFD34A850AED895188AD7E511B")

    CharSequence message;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.051 -0400", hash_original_method = "0E9735A507190BB775A80B2FEDEEE634", hash_generated_method = "3C26477742E86CC6E45CC5268A0F2AE9")
      CdmaMmiCode(CDMAPhone phone) {
        super(phone.getHandler().getLooper());
        this.phone = phone;
        this.context = phone.getContext();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static String makeEmptyNull(String s) {
        if (s != null && s.length() == 0) return null;
        return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.055 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "ED4E448A4711263BA83E0398D0A720EB")
    public State getState() {
        State varB4EAC82CA7396A68D541C85D26508E83_904418833 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_904418833 = state;
        varB4EAC82CA7396A68D541C85D26508E83_904418833.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_904418833;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.058 -0400", hash_original_method = "570FEAA437E41D0252DA00ACF07950A0", hash_generated_method = "5786300863EC0311E5678678FF4B5416")
    public CharSequence getMessage() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_829080566 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_829080566 = message;
        varB4EAC82CA7396A68D541C85D26508E83_829080566.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_829080566;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.059 -0400", hash_original_method = "7D43DA40239536121B4F58148ED0B98B", hash_generated_method = "38743023E5DCE6354E7A13760E727F5C")
    public void cancel() {
        state = State.CANCELLED;
        phone.onMMIDone (this);
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.059 -0400", hash_original_method = "ABB2058860BEBFF25C4A9C7B954D0A37", hash_generated_method = "1394463026A86776E6AD6EF2AF11D4F9")
    public boolean isCancelable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_130021299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_130021299;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.060 -0400", hash_original_method = "F83C3F3C3A6997A8F3CDD4D707F81FB0", hash_generated_method = "6AF4E896D53D1A5367DDC835DB1B8662")
     boolean isPukCommand() {
        boolean var371F3A7931E167CECB2D64F563A18326_2096866469 = (sc != null && sc.equals(SC_PUK));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_48507242 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_48507242;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.061 -0400", hash_original_method = "CA7357DC4342746EF1FE3C742A9E7FC8", hash_generated_method = "DCDE0EBD47CA871808ADB1AEEB562CE8")
     boolean isRegister() {
        boolean var8F8DE4A6AF200F3CCE4ABD0A031FFBC0_691503158 = (action != null && action.equals(ACTION_REGISTER));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1496501403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1496501403;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.062 -0400", hash_original_method = "325A40B5366E66641BBFDAE340904BED", hash_generated_method = "FF5F334963D5C6E873454379225BEF52")
    public boolean isUssdRequest() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1623329701 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1623329701;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.065 -0400", hash_original_method = "D40242C1775E5BFA18B0D32E606C72BC", hash_generated_method = "0A850A21F61CCF1B153225A0DD9B02A9")
     void processCode() {
        try 
        {
            {
                boolean varB4EA12E9B9BD9B4AA7429F91CF36E810_1551542952 = (isPukCommand());
                {
                    String oldPinOrPuk = sia;
                    String newPin = sib;
                    int pinLen = newPin.length();
                    {
                        boolean varEA4E815E4B62E47FA77B50ABCAA83B6E_864424400 = (isRegister());
                        {
                            {
                                boolean var1A02DE66B92C254F98F83985D3C86A02_1784821752 = (!newPin.equals(sic));
                                {
                                    handlePasswordError(com.android.internal.R.string.mismatchPin);
                                } 
                                {
                                    handlePasswordError(com.android.internal.R.string.invalidPin);
                                } 
                                {
                                    phone.mCM.supplyIccPuk(oldPinOrPuk, newPin,
                                obtainMessage(EVENT_SET_COMPLETE, this));
                                } 
                            } 
                        } 
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                        } 
                    } 
                } 
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("Invalid or Unsupported MMI Code");
                } 
            } 
        } 
        catch (RuntimeException exc)
        {
            state = State.FAILED;
            message = context.getText(com.android.internal.R.string.mmiError);
            phone.onMMIDone(this);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.069 -0400", hash_original_method = "60196158E22905B06D5E62564673E5E1", hash_generated_method = "878F8042D8FA72C244D61D1029C0968B")
    private void handlePasswordError(int res) {
        state = State.FAILED;
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        sb.append(context.getText(res));
        message = sb;
        phone.onMMIDone(this);
        addTaint(res);
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.070 -0400", hash_original_method = "20352E1B7818DCA44840F8C27B44EA84", hash_generated_method = "9B1B40370E577AF2D7084273674FBADB")
    public void handleMessage(Message msg) {
        AsyncResult ar;
        {
            ar = (AsyncResult) (msg.obj);
            onSetComplete(ar);
        } 
        addTaint(msg.getTaint());
        
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.070 -0400", hash_original_method = "DCFC51ECC309A2A613B704517DAD4649", hash_generated_method = "3DF7CF404A5BF7FF5538A20D68C64825")
    private CharSequence getScString() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_199636123 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1173295422 = null; 
        {
            {
                boolean varB4EA12E9B9BD9B4AA7429F91CF36E810_1481511620 = (isPukCommand());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_199636123 = context.getText(com.android.internal.R.string.PinMmi);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1173295422 = "";
        CharSequence varA7E53CE21691AB073D9660D615818899_1076093449; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1076093449 = varB4EAC82CA7396A68D541C85D26508E83_199636123;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1076093449 = varB4EAC82CA7396A68D541C85D26508E83_1173295422;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1076093449.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1076093449;
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_method = "52C2461B739F9120EA0709185D4E10B9", hash_generated_method = "F7ADD13173DDE59B9F37DAFF2A45D186")
    private void onSetComplete(AsyncResult ar) {
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        {
            state = State.FAILED;
            {
                CommandException.Error err = ((CommandException)(ar.exception)).getCommandError();
                {
                    {
                        boolean var7264D194DA23AC627D10ED044CFE74DF_1306165664 = (isPukCommand());
                        {
                            sb.append(context.getText(
                                com.android.internal.R.string.badPuk));
                        } 
                        {
                            sb.append(context.getText(
                                com.android.internal.R.string.passwordIncorrect));
                        } 
                    } 
                } 
                {
                    sb.append(context.getText(
                            com.android.internal.R.string.mmiError));
                } 
            } 
            {
                sb.append(context.getText(
                        com.android.internal.R.string.mmiError));
            } 
        } 
        {
            boolean var4DDE405F14FB31FAE30FA9EB5093778E_785597329 = (isRegister());
            {
                state = State.COMPLETE;
                sb.append(context.getText(
                    com.android.internal.R.string.serviceRegistered));
            } 
            {
                state = State.FAILED;
                sb.append(context.getText(
                    com.android.internal.R.string.mmiError));
            } 
        } 
        message = sb;
        phone.onMMIDone(this);
        addTaint(ar.getTaint());
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "76D85040174C5D7BAB27AEDF79036BEC", hash_generated_field = "4DD0BAA4F34FC065C38619A5EA5AD032")

    static final String LOG_TAG = "CDMA_MMI";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "B36D859659D29B3CF582794F8F07A110", hash_generated_field = "A747A2BA07E0220107EEBEA1B6706D02")

    static final String ACTION_REGISTER = "**";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "5BAD5D2228CE32354A88D354D80B2D1B", hash_generated_field = "F24A24DD4B537B4770521D463804E4D1")

    static final String SC_PUK = "05";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "4C1215DA515DFC3564B3BB1182B13CFF", hash_generated_field = "A94BA604FE3CDE84F64462E973B833FB")

    static final int EVENT_SET_COMPLETE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "E6AB098F50646317DD4CD4AD482AE641", hash_generated_field = "1B64CFB800A067861DC4A66690D66019")

    static Pattern sPatternSuppService = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)(.*)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "BB3719B16018B63D6E1AEFEF4670AD63", hash_generated_field = "7CA15DFCD577D5C84BA78A4189BC0E2C")

    static final int MATCH_GROUP_POUND_STRING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "90C3F831BEE8235DF8513B65A2F403D2", hash_generated_field = "F4DF33F7D8D6D17C4F4FEA7F8C1A94D0")

    static final int MATCH_GROUP_ACTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "CF0646443BB08F914B0A122FED173F6E", hash_generated_field = "A024C419F83A9F642C010C9489DE8C1A")

    static final int MATCH_GROUP_SERVICE_CODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "99D1B083A79036DBCFC5A60D46F22411", hash_generated_field = "EF421560D72C37CDE6066BA9C31D6755")

    static final int MATCH_GROUP_SIA = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "CDB9823919E9311E255A6F07A6DD9342", hash_generated_field = "D2593982434FD1D6031B1B2239618C42")

    static final int MATCH_GROUP_SIB = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "1470B5B0F1CC2B70632F064AA14D1792", hash_generated_field = "2B00556FFA768C0F276AE643F78A7D2C")

    static final int MATCH_GROUP_SIC = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "F90A3CDD189D147E86CFA37AA82536DD", hash_generated_field = "2B2C87265D64C476329F77ED35E669F5")

    static final int MATCH_GROUP_PWD_CONFIRM = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:27.071 -0400", hash_original_field = "663794BFD8D4A5D988354CA3CFA9154D", hash_generated_field = "9FA3793E535AC26009C54ED054C80B08")

    static final int MATCH_GROUP_DIALING_NUMBER = 12;
}

