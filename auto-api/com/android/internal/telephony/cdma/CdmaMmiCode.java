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
    CDMAPhone phone;
    Context context;
    String action;
    String sc;
    String sia, sib, sic;
    String poundString;
    String dialingNumber;
    String pwd;
    State state = State.PENDING;
    CharSequence message;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.624 -0400", hash_original_method = "0E9735A507190BB775A80B2FEDEEE634", hash_generated_method = "3DA8697D34A04D11A91D69279795FAFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     CdmaMmiCode(CDMAPhone phone) {
        super(phone.getHandler().getLooper());
        dsTaint.addTaint(phone.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.624 -0400", hash_original_method = "83A2E3FFD7B88E291F9EB06E3105AC3A", hash_generated_method = "F5E227F5D2B96691C815C4C56ED31889")
    @DSModeled(DSC.SAFE)
    public State getState() {
        return (State)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.625 -0400", hash_original_method = "570FEAA437E41D0252DA00ACF07950A0", hash_generated_method = "F66C4D887CEB386B9EEE5F07E323C620")
    @DSModeled(DSC.SAFE)
    public CharSequence getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return message;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.625 -0400", hash_original_method = "7D43DA40239536121B4F58148ED0B98B", hash_generated_method = "38743023E5DCE6354E7A13760E727F5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.625 -0400", hash_original_method = "ABB2058860BEBFF25C4A9C7B954D0A37", hash_generated_method = "AA651C7799401D35DD0E09C7ACFCFBA5")
    @DSModeled(DSC.SAFE)
    public boolean isCancelable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.625 -0400", hash_original_method = "F83C3F3C3A6997A8F3CDD4D707F81FB0", hash_generated_method = "8BC7CC5EC07D764452F479A4A786850A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isPukCommand() {
        boolean var371F3A7931E167CECB2D64F563A18326_1324686937 = (sc != null && sc.equals(SC_PUK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sc != null && sc.equals(SC_PUK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.625 -0400", hash_original_method = "CA7357DC4342746EF1FE3C742A9E7FC8", hash_generated_method = "66AF953E806CA31925654A4CCCCB7511")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean isRegister() {
        boolean var8F8DE4A6AF200F3CCE4ABD0A031FFBC0_1599704480 = (action != null && action.equals(ACTION_REGISTER));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return action != null && action.equals(ACTION_REGISTER);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.625 -0400", hash_original_method = "325A40B5366E66641BBFDAE340904BED", hash_generated_method = "DF5560AC34F1C7DCFE77DF5B2D0EE43A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isUssdRequest() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Log.w(LOG_TAG, "isUssdRequest is not implemented in CdmaMmiCode");
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.626 -0400", hash_original_method = "D40242C1775E5BFA18B0D32E606C72BC", hash_generated_method = "271DF0DC013682EF4B9ACC540E686B61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void processCode() {
        try 
        {
            {
                boolean varB4EA12E9B9BD9B4AA7429F91CF36E810_772682195 = (isPukCommand());
                {
                    String oldPinOrPuk;
                    oldPinOrPuk = sia;
                    String newPin;
                    newPin = sib;
                    int pinLen;
                    pinLen = newPin.length();
                    {
                        boolean varEA4E815E4B62E47FA77B50ABCAA83B6E_247451521 = (isRegister());
                        {
                            {
                                boolean var1A02DE66B92C254F98F83985D3C86A02_1914203575 = (!newPin.equals(sic));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.626 -0400", hash_original_method = "60196158E22905B06D5E62564673E5E1", hash_generated_method = "9FDE71BB93423304BC5C1C23A2BDA87B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handlePasswordError(int res) {
        dsTaint.addTaint(res);
        state = State.FAILED;
        StringBuilder sb;
        sb = new StringBuilder(getScString());
        sb.append("\n");
        sb.append(context.getText(res));
        message = sb;
        phone.onMMIDone(this);
        // ---------- Original Method ----------
        //state = State.FAILED;
        //StringBuilder sb = new StringBuilder(getScString());
        //sb.append("\n");
        //sb.append(context.getText(res));
        //message = sb;
        //phone.onMMIDone(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.626 -0400", hash_original_method = "20352E1B7818DCA44840F8C27B44EA84", hash_generated_method = "C0D50A89FDF81D574AFDC55A6047401B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        {
            ar = (AsyncResult) (msg.obj);
            onSetComplete(ar);
        } //End block
        // ---------- Original Method ----------
        //AsyncResult ar;
        //if (msg.what == EVENT_SET_COMPLETE) {
            //ar = (AsyncResult) (msg.obj);
            //onSetComplete(ar);
        //} else {
            //Log.e(LOG_TAG, "Unexpected reply");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.626 -0400", hash_original_method = "DCFC51ECC309A2A613B704517DAD4649", hash_generated_method = "4F3ABDA77B68FD90CA4BAF882F7A5F58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private CharSequence getScString() {
        {
            {
                boolean varB4EA12E9B9BD9B4AA7429F91CF36E810_520960727 = (isPukCommand());
                {
                    CharSequence varD84F5A043FCEA398AC4955F91EF1721A_1469059635 = (context.getText(com.android.internal.R.string.PinMmi));
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (sc != null) {
            //if (isPukCommand()) {
                //return context.getText(com.android.internal.R.string.PinMmi);
            //}
        //}
        //return "";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.627 -0400", hash_original_method = "52C2461B739F9120EA0709185D4E10B9", hash_generated_method = "977354159F97D16EEF1CF8CA20276D5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void onSetComplete(AsyncResult ar) {
        dsTaint.addTaint(ar.dsTaint);
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
                        boolean var7264D194DA23AC627D10ED044CFE74DF_1589501966 = (isPukCommand());
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
            boolean var4DDE405F14FB31FAE30FA9EB5093778E_75650901 = (isRegister());
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static final String LOG_TAG = "CDMA_MMI";
    static final String ACTION_REGISTER = "**";
    static final String SC_PUK          = "05";
    static final int EVENT_SET_COMPLETE = 1;
    static Pattern sPatternSuppService = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)(.*)");
    static final int MATCH_GROUP_POUND_STRING = 1;
    static final int MATCH_GROUP_ACTION = 2;
    static final int MATCH_GROUP_SERVICE_CODE = 3;
    static final int MATCH_GROUP_SIA = 5;
    static final int MATCH_GROUP_SIB = 7;
    static final int MATCH_GROUP_SIC = 9;
    static final int MATCH_GROUP_PWD_CONFIRM = 11;
    static final int MATCH_GROUP_DIALING_NUMBER = 12;
}

