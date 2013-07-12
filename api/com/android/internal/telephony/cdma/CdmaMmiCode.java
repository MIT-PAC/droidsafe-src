package com.android.internal.telephony.cdma;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "F7A42FE7211F98AC7A60A285AC3A9E87", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")

    CDMAPhone phone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "571FE4403DDA9BF54693EBF4F0D6639D")

    Context context;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "418C5509E2171D55B0AEE5C2EA4442B5", hash_generated_field = "F0D53334D1D58D4E79746838A9C851E9")

    String action;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "D54185B71F614C30A396AC4BC44D3269", hash_generated_field = "1F12170F3EB5D5C8E81971C7E7A70DEB")

    String sc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "07AF7E75676EAB410D1F83937D7AFB62", hash_generated_field = "A81AA63AE09D96070D67E017AC9A9A05")

    String sia;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "A444633D8CF456EECA3138C78F4AE12E", hash_generated_field = "58A1CEF50FC10710B7250BC1FCA66342")

    String sib;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "82F5C1C9BE89C68344D5C6BCF404C804", hash_generated_field = "8A9043BD9E04D5B2D22710F5E973C72C")

    String sic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "A265DB9AE14F0DD90BC117F8B98A0755", hash_generated_field = "BB2724DBDDFCC035B982DADDB95A1B73")

    String poundString;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "CEFDF90E0BAE9FC3A52CE140170834F6", hash_generated_field = "8E3BE840A192C669D20F33CA83223066")

    String dialingNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "9003D1DF22EB4D3820015070385194C8", hash_generated_field = "389FC73FC9600F29B99C9C32C4AF72ED")

    String pwd;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "B355E0B84F8AFF2409A9BE6D26D2C44F", hash_generated_field = "1C260AF567CCE39E2DADC6C6A5D564F0")

    State state = State.PENDING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.658 -0400", hash_original_field = "78E731027D8FD50ED642340B7C9A63B3", hash_generated_field = "422FD4BFD34A850AED895188AD7E511B")

    CharSequence message;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.659 -0400", hash_original_method = "0E9735A507190BB775A80B2FEDEEE634", hash_generated_method = "3C26477742E86CC6E45CC5268A0F2AE9")
      CdmaMmiCode(CDMAPhone phone) {
        super(phone.getHandler().getLooper());
        this.phone = phone;
        this.context = phone.getContext();
        
        
        
    }

    
        @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.660 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "7ADDDAED3593938448F4650CB158A64D")
    public State getState() {
State var37C56C9D63C623261861C16DCFB73F6D_522716002 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_522716002.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_522716002;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.660 -0400", hash_original_method = "570FEAA437E41D0252DA00ACF07950A0", hash_generated_method = "C8504585C4743F7473F3A0E3CFCC0AFF")
    public CharSequence getMessage() {
CharSequence varFD182D7074F3848E773A38B067BBB880_1449812741 =         message;
        varFD182D7074F3848E773A38B067BBB880_1449812741.addTaint(taint);
        return varFD182D7074F3848E773A38B067BBB880_1449812741;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.660 -0400", hash_original_method = "7D43DA40239536121B4F58148ED0B98B", hash_generated_method = "56B028B32599CFE5108B411FA8B8E454")
    public void cancel() {
    if(state == State.COMPLETE || state == State.FAILED)        
        {
            return;
        } 
        state = State.CANCELLED;
        phone.onMMIDone (this);
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.661 -0400", hash_original_method = "ABB2058860BEBFF25C4A9C7B954D0A37", hash_generated_method = "D9E22CAF6B5A5EA30D5A30A372DFF3DC")
    public boolean isCancelable() {
        boolean var68934A3E9455FA72420237EB05902327_181060800 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1151611391 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1151611391;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.661 -0400", hash_original_method = "F83C3F3C3A6997A8F3CDD4D707F81FB0", hash_generated_method = "4F518DDA4C1DF97F84FF35D00DE82282")
     boolean isPukCommand() {
        boolean var5A581E433070AF4838840D8266C34F91_500430437 = (sc != null && sc.equals(SC_PUK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1341048763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1341048763;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.661 -0400", hash_original_method = "CA7357DC4342746EF1FE3C742A9E7FC8", hash_generated_method = "87C7A3F1CFBDB4044B6C5B471565E7F3")
     boolean isRegister() {
        boolean var8AFE299431940E3F9012D8FC2BB2FDCF_1139269199 = (action != null && action.equals(ACTION_REGISTER));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_114351184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_114351184;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.661 -0400", hash_original_method = "325A40B5366E66641BBFDAE340904BED", hash_generated_method = "F3C69617DBF4B16C2E0B39601E4F9FB6")
    public boolean isUssdRequest() {
        boolean var68934A3E9455FA72420237EB05902327_1825361485 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79138768 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_79138768;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.662 -0400", hash_original_method = "D40242C1775E5BFA18B0D32E606C72BC", hash_generated_method = "35122E3C62D4F45B28445E932090FEB8")
     void processCode() {
        try 
        {
    if(isPukCommand())            
            {
                String oldPinOrPuk = sia;
                String newPin = sib;
                int pinLen = newPin.length();
    if(isRegister())                
                {
    if(!newPin.equals(sic))                    
                    {
                        handlePasswordError(com.android.internal.R.string.mismatchPin);
                    } 
                    else
    if(pinLen < 4 || pinLen > 8)                    
                    {
                        handlePasswordError(com.android.internal.R.string.invalidPin);
                    } 
                    else
                    {
                        phone.mCM.supplyIccPuk(oldPinOrPuk, newPin,
                                obtainMessage(EVENT_SET_COMPLETE, this));
                    } 
                } 
                else
                {
                    RuntimeException var2E49DDD3355A805A242019B4EA18BC60_740019429 = new RuntimeException ("Invalid or Unsupported MMI Code");
                    var2E49DDD3355A805A242019B4EA18BC60_740019429.addTaint(taint);
                    throw var2E49DDD3355A805A242019B4EA18BC60_740019429;
                } 
            } 
            else
            {
                RuntimeException var2E49DDD3355A805A242019B4EA18BC60_1796680854 = new RuntimeException ("Invalid or Unsupported MMI Code");
                var2E49DDD3355A805A242019B4EA18BC60_1796680854.addTaint(taint);
                throw var2E49DDD3355A805A242019B4EA18BC60_1796680854;
            } 
        } 
        catch (RuntimeException exc)
        {
            state = State.FAILED;
            message = context.getText(com.android.internal.R.string.mmiError);
            phone.onMMIDone(this);
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.663 -0400", hash_original_method = "60196158E22905B06D5E62564673E5E1", hash_generated_method = "8D5D96E26CBDDA8A4D99891B21FC6323")
    private void handlePasswordError(int res) {
        addTaint(res);
        state = State.FAILED;
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        sb.append(context.getText(res));
        message = sb;
        phone.onMMIDone(this);
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.664 -0400", hash_original_method = "20352E1B7818DCA44840F8C27B44EA84", hash_generated_method = "52F1F85429917172AE9EC8F24D8A94E9")
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
    if(msg.what == EVENT_SET_COMPLETE)        
        {
            ar = (AsyncResult) (msg.obj);
            onSetComplete(ar);
        } 
        else
        {
        } 
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.664 -0400", hash_original_method = "DCFC51ECC309A2A613B704517DAD4649", hash_generated_method = "9979D78BEE71F8AB5AA0A8B873D3A795")
    private CharSequence getScString() {
    if(sc != null)        
        {
    if(isPukCommand())            
            {
CharSequence varC01B34D797D5ECB0C81BDA0577666337_1187906943 =                 context.getText(com.android.internal.R.string.PinMmi);
                varC01B34D797D5ECB0C81BDA0577666337_1187906943.addTaint(taint);
                return varC01B34D797D5ECB0C81BDA0577666337_1187906943;
            } 
        } 
CharSequence var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_752778919 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_752778919.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_752778919;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.665 -0400", hash_original_method = "52C2461B739F9120EA0709185D4E10B9", hash_generated_method = "84F89315011DA007F5466969C5E71D30")
    private void onSetComplete(AsyncResult ar) {
        addTaint(ar.getTaint());
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
    if(ar.exception != null)        
        {
            state = State.FAILED;
    if(ar.exception instanceof CommandException)            
            {
                CommandException.Error err = ((CommandException)(ar.exception)).getCommandError();
    if(err == CommandException.Error.PASSWORD_INCORRECT)                
                {
    if(isPukCommand())                    
                    {
                        sb.append(context.getText(
                                com.android.internal.R.string.badPuk));
                    } 
                    else
                    {
                        sb.append(context.getText(
                                com.android.internal.R.string.passwordIncorrect));
                    } 
                } 
                else
                {
                    sb.append(context.getText(
                            com.android.internal.R.string.mmiError));
                } 
            } 
            else
            {
                sb.append(context.getText(
                        com.android.internal.R.string.mmiError));
            } 
        } 
        else
    if(isRegister())        
        {
            state = State.COMPLETE;
            sb.append(context.getText(
                    com.android.internal.R.string.serviceRegistered));
        } 
        else
        {
            state = State.FAILED;
            sb.append(context.getText(
                    com.android.internal.R.string.mmiError));
        } 
        message = sb;
        phone.onMMIDone(this);
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "76D85040174C5D7BAB27AEDF79036BEC", hash_generated_field = "4DD0BAA4F34FC065C38619A5EA5AD032")

    static final String LOG_TAG = "CDMA_MMI";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "B36D859659D29B3CF582794F8F07A110", hash_generated_field = "A747A2BA07E0220107EEBEA1B6706D02")

    static final String ACTION_REGISTER = "**";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "5BAD5D2228CE32354A88D354D80B2D1B", hash_generated_field = "F24A24DD4B537B4770521D463804E4D1")

    static final String SC_PUK = "05";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "4C1215DA515DFC3564B3BB1182B13CFF", hash_generated_field = "A94BA604FE3CDE84F64462E973B833FB")

    static final int EVENT_SET_COMPLETE = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "E6AB098F50646317DD4CD4AD482AE641", hash_generated_field = "1B64CFB800A067861DC4A66690D66019")

    static Pattern sPatternSuppService = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)(.*)");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "BB3719B16018B63D6E1AEFEF4670AD63", hash_generated_field = "7CA15DFCD577D5C84BA78A4189BC0E2C")

    static final int MATCH_GROUP_POUND_STRING = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "90C3F831BEE8235DF8513B65A2F403D2", hash_generated_field = "F4DF33F7D8D6D17C4F4FEA7F8C1A94D0")

    static final int MATCH_GROUP_ACTION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "CF0646443BB08F914B0A122FED173F6E", hash_generated_field = "A024C419F83A9F642C010C9489DE8C1A")

    static final int MATCH_GROUP_SERVICE_CODE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "99D1B083A79036DBCFC5A60D46F22411", hash_generated_field = "EF421560D72C37CDE6066BA9C31D6755")

    static final int MATCH_GROUP_SIA = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "CDB9823919E9311E255A6F07A6DD9342", hash_generated_field = "D2593982434FD1D6031B1B2239618C42")

    static final int MATCH_GROUP_SIB = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "1470B5B0F1CC2B70632F064AA14D1792", hash_generated_field = "2B00556FFA768C0F276AE643F78A7D2C")

    static final int MATCH_GROUP_SIC = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "F90A3CDD189D147E86CFA37AA82536DD", hash_generated_field = "2B2C87265D64C476329F77ED35E669F5")

    static final int MATCH_GROUP_PWD_CONFIRM = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:25.666 -0400", hash_original_field = "663794BFD8D4A5D988354CA3CFA9154D", hash_generated_field = "9FA3793E535AC26009C54ED054C80B08")

    static final int MATCH_GROUP_DIALING_NUMBER = 12;
}

