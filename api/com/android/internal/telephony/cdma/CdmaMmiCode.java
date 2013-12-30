package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;

import com.android.internal.telephony.CommandException;
import com.android.internal.telephony.MmiCode;






public final class CdmaMmiCode extends Handler implements MmiCode {


    // Public Class methods

    /**
     * Check if provided string contains Mmi code in it and create corresponding
     * Mmi if it does
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.574 -0500", hash_original_method = "3D9451AEE4864904091F150DA6CD0D04", hash_generated_method = "B8E898C214D0DC2DB1C02E14227FCC67")
    
public static CdmaMmiCode
    newFromDialString(String dialString, CDMAPhone phone) {
        Matcher m;
        CdmaMmiCode ret = null;

        m = sPatternSuppService.matcher(dialString);

        // Is this formatted like a standard supplementary service code?
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

    // Private Class methods

    /** make empty strings be null.
     *  Regexp returns empty strings for empty groups
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.576 -0500", hash_original_method = "2FD14CE5C15BA6F91A4A0B21760850CD", hash_generated_method = "D25CF56895B420B545C3566DEEFBA18C")
    
private static String
    makeEmptyNull (String s) {
        if (s != null && s.length() == 0) return null;

        return s;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.521 -0500", hash_original_field = "3D98A020ECACBAE7C422A168E160B847", hash_generated_field = "4DD0BAA4F34FC065C38619A5EA5AD032")

    static final String LOG_TAG = "CDMA_MMI";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.524 -0500", hash_original_field = "508EDED9B330FEB251BB9AFD01FC4828", hash_generated_field = "81F5AEFC46706CB75B91FC49E2FBC5D1")


    // From TS 22.030 6.5.2
    static final String ACTION_REGISTER = "**";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.526 -0500", hash_original_field = "A5BE53B19A33B16E1807824A89B907AF", hash_generated_field = "F24A24DD4B537B4770521D463804E4D1")

    static final String SC_PUK          = "05";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.528 -0500", hash_original_field = "EAC576E559D59F0C7D0950B0EFCE6458", hash_generated_field = "A94BA604FE3CDE84F64462E973B833FB")


    static final int EVENT_SET_COMPLETE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.551 -0500", hash_original_field = "D220AC52D8D11EFA84907D82D31BF91B", hash_generated_field = "1B64CFB800A067861DC4A66690D66019")


    static Pattern sPatternSuppService = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)(.*)");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.553 -0500", hash_original_field = "B70DD7A805C09DAF4B85DF3F2AA1E1D2", hash_generated_field = "7CA15DFCD577D5C84BA78A4189BC0E2C")


    static final int MATCH_GROUP_POUND_STRING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.557 -0500", hash_original_field = "3A1ADB951719F3F4638A18B5533A24F9", hash_generated_field = "F4DF33F7D8D6D17C4F4FEA7F8C1A94D0")

    static final int MATCH_GROUP_ACTION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.559 -0500", hash_original_field = "60DFF95A3FBFA52E5839032FA5DAE64A", hash_generated_field = "A024C419F83A9F642C010C9489DE8C1A")

    static final int MATCH_GROUP_SERVICE_CODE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.561 -0500", hash_original_field = "EC2B3FF25577BFAE4A7B9A3F0F49F4FE", hash_generated_field = "EF421560D72C37CDE6066BA9C31D6755")

    static final int MATCH_GROUP_SIA = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.564 -0500", hash_original_field = "2799B5FF8FF9569940BCDE317ED8FCE7", hash_generated_field = "D2593982434FD1D6031B1B2239618C42")

    static final int MATCH_GROUP_SIB = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.566 -0500", hash_original_field = "A4A50B05D3EB1967EB1A68ADBA889CAF", hash_generated_field = "2B00556FFA768C0F276AE643F78A7D2C")

    static final int MATCH_GROUP_SIC = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.568 -0500", hash_original_field = "543F51CD9008EAB9A82A82F8EE24DDF0", hash_generated_field = "2B2C87265D64C476329F77ED35E669F5")

    static final int MATCH_GROUP_PWD_CONFIRM = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.571 -0500", hash_original_field = "51D74AE56D031EF54174D999E1A2AD8E", hash_generated_field = "9FA3793E535AC26009C54ED054C80B08")

    static final int MATCH_GROUP_DIALING_NUMBER = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.530 -0500", hash_original_field = "F2FC592D71DA2BCBED04F0F797B7B907", hash_generated_field = "F2FC592D71DA2BCBED04F0F797B7B907")


    CDMAPhone phone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.532 -0500", hash_original_field = "571FE4403DDA9BF54693EBF4F0D6639D", hash_generated_field = "571FE4403DDA9BF54693EBF4F0D6639D")

    Context context;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.534 -0500", hash_original_field = "F0D53334D1D58D4E79746838A9C851E9", hash_generated_field = "F0D53334D1D58D4E79746838A9C851E9")


    String action;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.536 -0500", hash_original_field = "1F12170F3EB5D5C8E81971C7E7A70DEB", hash_generated_field = "1F12170F3EB5D5C8E81971C7E7A70DEB")

    String sc;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.912 -0400", hash_original_field = "07AF7E75676EAB410D1F83937D7AFB62", hash_generated_field = "A81AA63AE09D96070D67E017AC9A9A05")

    String sia;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.912 -0400", hash_original_field = "A444633D8CF456EECA3138C78F4AE12E", hash_generated_field = "58A1CEF50FC10710B7250BC1FCA66342")

    String sib;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:22.912 -0400", hash_original_field = "82F5C1C9BE89C68344D5C6BCF404C804", hash_generated_field = "8A9043BD9E04D5B2D22710F5E973C72C")

    String sic;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.541 -0500", hash_original_field = "BB2724DBDDFCC035B982DADDB95A1B73", hash_generated_field = "BB2724DBDDFCC035B982DADDB95A1B73")

    String poundString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.543 -0500", hash_original_field = "8E3BE840A192C669D20F33CA83223066", hash_generated_field = "8E3BE840A192C669D20F33CA83223066")

    String dialingNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.545 -0500", hash_original_field = "389FC73FC9600F29B99C9C32C4AF72ED", hash_generated_field = "389FC73FC9600F29B99C9C32C4AF72ED")

    String pwd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.547 -0500", hash_original_field = "1C260AF567CCE39E2DADC6C6A5D564F0", hash_generated_field = "1C260AF567CCE39E2DADC6C6A5D564F0")


    State state = State.PENDING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.549 -0500", hash_original_field = "422FD4BFD34A850AED895188AD7E511B", hash_generated_field = "422FD4BFD34A850AED895188AD7E511B")

    CharSequence message;

    // Constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.578 -0500", hash_original_method = "0E9735A507190BB775A80B2FEDEEE634", hash_generated_method = "0E9735A507190BB775A80B2FEDEEE634")
    
CdmaMmiCode (CDMAPhone phone) {
        super(phone.getHandler().getLooper());
        this.phone = phone;
        this.context = phone.getContext();
    }

    // MmiCode implementation

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.581 -0500", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "501DC0DCEBE66E1C2384E415192C6550")
    
public State
    getState() {
        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.583 -0500", hash_original_method = "570FEAA437E41D0252DA00ACF07950A0", hash_generated_method = "5CEF4B02F22CFEE27A7F9878596252B0")
    
public CharSequence
    getMessage() {
        return message;
    }

    // inherited javadoc suffices
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.585 -0500", hash_original_method = "7D43DA40239536121B4F58148ED0B98B", hash_generated_method = "B2F29DD8B3CB12E46F6EE801886D7875")
    
public void
    cancel() {
        // Complete or failed cannot be cancelled
        if (state == State.COMPLETE || state == State.FAILED) {
            return;
        }

        state = State.CANCELLED;
        phone.onMMIDone (this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.588 -0500", hash_original_method = "ABB2058860BEBFF25C4A9C7B954D0A37", hash_generated_method = "C61CEB8E69EBC29941E6F813D9673639")
    
public boolean isCancelable() {
        return false;
    }

    // Instance Methods

    /**
     * @return true if the Service Code is PIN/PIN2/PUK/PUK2-related
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.590 -0500", hash_original_method = "F83C3F3C3A6997A8F3CDD4D707F81FB0", hash_generated_method = "F83C3F3C3A6997A8F3CDD4D707F81FB0")
    
boolean isPukCommand() {
        return sc != null && sc.equals(SC_PUK);
     }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.592 -0500", hash_original_method = "CA7357DC4342746EF1FE3C742A9E7FC8", hash_generated_method = "CA7357DC4342746EF1FE3C742A9E7FC8")
    
boolean isRegister() {
        return action != null && action.equals(ACTION_REGISTER);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.594 -0500", hash_original_method = "325A40B5366E66641BBFDAE340904BED", hash_generated_method = "FE64D3059A0DB1EDEADEC3AA19700132")
    
public boolean isUssdRequest() {
        Log.w(LOG_TAG, "isUssdRequest is not implemented in CdmaMmiCode");
        return false;
    }

    /** Process a MMI PUK code */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.596 -0500", hash_original_method = "D40242C1775E5BFA18B0D32E606C72BC", hash_generated_method = "811B1D06942A741BDFAD8B5A12010FC7")
    
void
    processCode () {
        try {
            if (isPukCommand()) {
                // sia = old PUK
                // sib = new PIN
                // sic = new PIN
                String oldPinOrPuk = sia;
                String newPin = sib;
                int pinLen = newPin.length();
                if (isRegister()) {
                    if (!newPin.equals(sic)) {
                        // password mismatch; return error
                        handlePasswordError(com.android.internal.R.string.mismatchPin);
                    } else if (pinLen < 4 || pinLen > 8 ) {
                        // invalid length
                        handlePasswordError(com.android.internal.R.string.invalidPin);
                    } else {
                        phone.mCM.supplyIccPuk(oldPinOrPuk, newPin,
                                obtainMessage(EVENT_SET_COMPLETE, this));
                    }
                } else {
                    throw new RuntimeException ("Invalid or Unsupported MMI Code");
                }
            } else {
                throw new RuntimeException ("Invalid or Unsupported MMI Code");
            }
        } catch (RuntimeException exc) {
            state = State.FAILED;
            message = context.getText(com.android.internal.R.string.mmiError);
            phone.onMMIDone(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.599 -0500", hash_original_method = "60196158E22905B06D5E62564673E5E1", hash_generated_method = "6899933A4B68D0B99E8CE0B6EB2588C0")
    
private void handlePasswordError(int res) {
        state = State.FAILED;
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");
        sb.append(context.getText(res));
        message = sb;
        phone.onMMIDone(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.601 -0500", hash_original_method = "20352E1B7818DCA44840F8C27B44EA84", hash_generated_method = "934B9ACF089C1B3DD14B8E224402EA67")
    
public void
    handleMessage (Message msg) {
        AsyncResult ar;

        if (msg.what == EVENT_SET_COMPLETE) {
            ar = (AsyncResult) (msg.obj);
            onSetComplete(ar);
        } else {
            Log.e(LOG_TAG, "Unexpected reply");
        }
    }
    // Private instance methods

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.605 -0500", hash_original_method = "DCFC51ECC309A2A613B704517DAD4649", hash_generated_method = "503AE435275B67B6532B1B5687230078")
    
private CharSequence getScString() {
        if (sc != null) {
            if (isPukCommand()) {
                return context.getText(com.android.internal.R.string.PinMmi);
            }
        }

        return "";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:59.608 -0500", hash_original_method = "52C2461B739F9120EA0709185D4E10B9", hash_generated_method = "EB1A55DFFD705F5FBCA1B040D9226192")
    
private void
    onSetComplete(AsyncResult ar){
        StringBuilder sb = new StringBuilder(getScString());
        sb.append("\n");

        if (ar.exception != null) {
            state = State.FAILED;
            if (ar.exception instanceof CommandException) {
                CommandException.Error err = ((CommandException)(ar.exception)).getCommandError();
                if (err == CommandException.Error.PASSWORD_INCORRECT) {
                    if (isPukCommand()) {
                        sb.append(context.getText(
                                com.android.internal.R.string.badPuk));
                    } else {
                        sb.append(context.getText(
                                com.android.internal.R.string.passwordIncorrect));
                    }
                } else {
                    sb.append(context.getText(
                            com.android.internal.R.string.mmiError));
                }
            } else {
                sb.append(context.getText(
                        com.android.internal.R.string.mmiError));
            }
        } else if (isRegister()) {
            state = State.COMPLETE;
            sb.append(context.getText(
                    com.android.internal.R.string.serviceRegistered));
        } else {
            state = State.FAILED;
            sb.append(context.getText(
                    com.android.internal.R.string.mmiError));
        }

        message = sb;
        phone.onMMIDone(this);
    }
}

