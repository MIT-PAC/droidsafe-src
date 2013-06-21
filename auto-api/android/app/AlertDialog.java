package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.app.AlertController;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class AlertDialog extends Dialog implements DialogInterface {
    private AlertController mAlert;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.467 -0400", hash_original_method = "3B9AE3A4287FBB2F8914E3FC42E19D75", hash_generated_method = "DA18684D073BD46FFB50C38007B2B132")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.467 -0400", hash_original_method = "C5FA972556687388DAE356FD387A2EE9", hash_generated_method = "34B516C2A2C223B0B727F46542414A47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AlertDialog(Context context, int theme) {
        this(context, theme, true);
        dsTaint.addTaint(theme);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.468 -0400", hash_original_method = "6D386DC5BAB559A725B0E80B3B80739F", hash_generated_method = "506D90F63BCA644F334817D132DC506A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     AlertDialog(Context context, int theme, boolean createContextWrapper) {
        super(context, resolveDialogTheme(context, theme), createContextWrapper);
        dsTaint.addTaint(theme);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(createContextWrapper);
        mWindow.alwaysReadCloseOnTouchAttr();
        mAlert = new AlertController(getContext(), this, getWindow());
        // ---------- Original Method ----------
        //mWindow.alwaysReadCloseOnTouchAttr();
        //mAlert = new AlertController(getContext(), this, getWindow());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.469 -0400", hash_original_method = "EA464E0CF4AA10E0AEDF6B163BEEF729", hash_generated_method = "9301A178ED829E320B648CF3C29554CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, resolveDialogTheme(context, 0));
        dsTaint.addTaint(cancelListener.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(cancelable);
        mWindow.alwaysReadCloseOnTouchAttr();
        setCancelable(cancelable);
        setOnCancelListener(cancelListener);
        mAlert = new AlertController(context, this, getWindow());
        // ---------- Original Method ----------
        //mWindow.alwaysReadCloseOnTouchAttr();
        //setCancelable(cancelable);
        //setOnCancelListener(cancelListener);
        //mAlert = new AlertController(context, this, getWindow());
    }

    
        static int resolveDialogTheme(Context context, int resid) {
        if (resid == THEME_TRADITIONAL) {
            return com.android.internal.R.style.Theme_Dialog_Alert;
        } else if (resid == THEME_HOLO_DARK) {
            return com.android.internal.R.style.Theme_Holo_Dialog_Alert;
        } else if (resid == THEME_HOLO_LIGHT) {
            return com.android.internal.R.style.Theme_Holo_Light_Dialog_Alert;
        } else if (resid == THEME_DEVICE_DEFAULT_DARK) {
            return com.android.internal.R.style.Theme_DeviceDefault_Dialog_Alert;
        } else if (resid == THEME_DEVICE_DEFAULT_LIGHT) {
            return com.android.internal.R.style.Theme_DeviceDefault_Light_Dialog_Alert;
        } else if (resid >= 0x01000000) {   
            return resid;
        } else {
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(com.android.internal.R.attr.alertDialogTheme,
                    outValue, true);
            return outValue.resourceId;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.470 -0400", hash_original_method = "2277A8C194577CB499FB53C1370D61D1", hash_generated_method = "AD57380994B1975ABD2FD28C7D11B482")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Button getButton(int whichButton) {
        dsTaint.addTaint(whichButton);
        Button var029B30BB7360A70A943E2608DA0A708B_267978943 = (mAlert.getButton(whichButton));
        return (Button)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAlert.getButton(whichButton);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.470 -0400", hash_original_method = "ECC410A91FC6F30B82508F44C93EA39B", hash_generated_method = "4199504C72F7C41E817B0B17AB7FC2BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListView getListView() {
        ListView var95A49C1FAF2DDB8BED96C01B211B1216_1939659311 = (mAlert.getListView());
        return (ListView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAlert.getListView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.471 -0400", hash_original_method = "5655E82DFA793B6CD86300EA45F77D5A", hash_generated_method = "AC26E86426E2BFCF19C7ACA1690E403B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        super.setTitle(title);
        mAlert.setTitle(title);
        // ---------- Original Method ----------
        //super.setTitle(title);
        //mAlert.setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.471 -0400", hash_original_method = "0AAF0E3192DB53DCF899ECF927301A42", hash_generated_method = "9E4ADA0B5C543D3EC88D98FD91C353F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCustomTitle(View customTitleView) {
        dsTaint.addTaint(customTitleView.dsTaint);
        mAlert.setCustomTitle(customTitleView);
        // ---------- Original Method ----------
        //mAlert.setCustomTitle(customTitleView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.472 -0400", hash_original_method = "0FDFF41BD74285789F29E89A2F2C112C", hash_generated_method = "E9965DF480613ACFEE1CA00787D15214")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMessage(CharSequence message) {
        dsTaint.addTaint(message);
        mAlert.setMessage(message);
        // ---------- Original Method ----------
        //mAlert.setMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.473 -0400", hash_original_method = "588C26275F4E62D9742C7DBB082EE340", hash_generated_method = "B55E8F48B2AB65D7C4551A8B182300A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mAlert.setView(view);
        // ---------- Original Method ----------
        //mAlert.setView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.475 -0400", hash_original_method = "399D46DD3D86F04F15AA9836309BED7E", hash_generated_method = "EC642ADE8958F28A64459667FBF3C4B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight,
            int viewSpacingBottom) {
        dsTaint.addTaint(viewSpacingBottom);
        dsTaint.addTaint(viewSpacingTop);
        dsTaint.addTaint(viewSpacingRight);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(viewSpacingLeft);
        mAlert.setView(view, viewSpacingLeft, viewSpacingTop, viewSpacingRight, viewSpacingBottom);
        // ---------- Original Method ----------
        //mAlert.setView(view, viewSpacingLeft, viewSpacingTop, viewSpacingRight, viewSpacingBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.476 -0400", hash_original_method = "CFE09EBA63F60A6BEEDA0ECE4DBD2BBE", hash_generated_method = "C982819977F329DA0506AC5998DE6382")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setButton(int whichButton, CharSequence text, Message msg) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(whichButton);
        dsTaint.addTaint(msg.dsTaint);
        mAlert.setButton(whichButton, text, null, msg);
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, null, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.476 -0400", hash_original_method = "FD92C01692F456341A0525E9D1CD5A83", hash_generated_method = "6ACBA5941A104134E2BF1B1F9EFF88B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setButton(int whichButton, CharSequence text, OnClickListener listener) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(whichButton);
        dsTaint.addTaint(listener.dsTaint);
        mAlert.setButton(whichButton, text, listener, null);
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, listener, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.477 -0400", hash_original_method = "2930D21A7389B776726F7D14477E22A5", hash_generated_method = "1E20B9D853C6A09998D6F37A7B2A77C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setButton(CharSequence text, Message msg) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(msg.dsTaint);
        setButton(BUTTON_POSITIVE, text, msg);
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.477 -0400", hash_original_method = "5D138EC6D4B89A4911514A5D190A83FC", hash_generated_method = "1D7B979E0D42A526D0DC341D8AE8E070")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setButton2(CharSequence text, Message msg) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(msg.dsTaint);
        setButton(BUTTON_NEGATIVE, text, msg);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.478 -0400", hash_original_method = "E62AA308196D7D74E77874CB13CC8D38", hash_generated_method = "3F090488A77783AFDAACB95E43C019B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setButton3(CharSequence text, Message msg) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(msg.dsTaint);
        setButton(BUTTON_NEUTRAL, text, msg);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.478 -0400", hash_original_method = "14303CDDA201782BB4EE72003EBE4B25", hash_generated_method = "7396C6983891A1AB72DB3A06DE1B6829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setButton(CharSequence text, final OnClickListener listener) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(listener.dsTaint);
        setButton(BUTTON_POSITIVE, text, listener);
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.478 -0400", hash_original_method = "99FBB4BC7546CFCEFDAC9CCE0B0EC52F", hash_generated_method = "2781764F4F23642441FED10C33C94ABB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setButton2(CharSequence text, final OnClickListener listener) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(listener.dsTaint);
        setButton(BUTTON_NEGATIVE, text, listener);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.479 -0400", hash_original_method = "9225C5ACB453A48CCE22F622BD426A12", hash_generated_method = "47D639777C94CD314C1475F31B0B5162")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public void setButton3(CharSequence text, final OnClickListener listener) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(listener.dsTaint);
        setButton(BUTTON_NEUTRAL, text, listener);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.480 -0400", hash_original_method = "B742B976A105323EE27DB344109D47DF", hash_generated_method = "B4CAB4F1DDD08966EABDC674F2D5BAF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIcon(int resId) {
        dsTaint.addTaint(resId);
        mAlert.setIcon(resId);
        // ---------- Original Method ----------
        //mAlert.setIcon(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.480 -0400", hash_original_method = "58CB6A167EA4E7B84F26608014843ADF", hash_generated_method = "5CE9A91A74261EB1F3E7C960CDE1DF93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        mAlert.setIcon(icon);
        // ---------- Original Method ----------
        //mAlert.setIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.481 -0400", hash_original_method = "1B8133F4D68862D013C951EDD0C82832", hash_generated_method = "7052FCAAA31351E986103ED8035243B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIconAttribute(int attrId) {
        dsTaint.addTaint(attrId);
        TypedValue out;
        out = new TypedValue();
        mContext.getTheme().resolveAttribute(attrId, out, true);
        mAlert.setIcon(out.resourceId);
        // ---------- Original Method ----------
        //TypedValue out = new TypedValue();
        //mContext.getTheme().resolveAttribute(attrId, out, true);
        //mAlert.setIcon(out.resourceId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.481 -0400", hash_original_method = "21C74C630736CECBD7AD6F509C2AA5D7", hash_generated_method = "ADBF60BA66ADA8B82F49BDFB35475F3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        dsTaint.addTaint(forceInverseBackground);
        mAlert.setInverseBackgroundForced(forceInverseBackground);
        // ---------- Original Method ----------
        //mAlert.setInverseBackgroundForced(forceInverseBackground);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.482 -0400", hash_original_method = "84106AE7CC1A6E59D6E45CD48A2A2307", hash_generated_method = "E1C42F5103326E68F60675C6390A8F08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        super.onCreate(savedInstanceState);
        mAlert.installContent();
        // ---------- Original Method ----------
        //super.onCreate(savedInstanceState);
        //mAlert.installContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.483 -0400", hash_original_method = "BF8AB256B91D3A887301218CA5494F2D", hash_generated_method = "3886B9959B428FE271CF43D80E8AC43D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var0860591BEC688168A96E8D7B8A8FC21B_1730813808 = (mAlert.onKeyDown(keyCode, event));
        } //End collapsed parenthetic
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1015214375 = (super.onKeyDown(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAlert.onKeyDown(keyCode, event)) return true;
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.483 -0400", hash_original_method = "A1B1EEF278CFBA53A19AA72D7DAA37CB", hash_generated_method = "13CA8AD346B9E657489889EB92AB661D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varC975F70000285699A9B742C42371726C_67600207 = (mAlert.onKeyUp(keyCode, event));
        } //End collapsed parenthetic
        boolean varEDD771EBF66425AD21882AB08CD0EE48_127777484 = (super.onKeyUp(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAlert.onKeyUp(keyCode, event)) return true;
        //return super.onKeyUp(keyCode, event);
    }

    
    public static class Builder {
        private AlertController.AlertParams P;
        private int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.484 -0400", hash_original_method = "CB1BA6F353D1C3D1D9DFD93D2E2AA221", hash_generated_method = "65A4F22CD16D792A93CFAA09FD611D09")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder(Context context) {
            this(context, resolveDialogTheme(context, 0));
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.484 -0400", hash_original_method = "054A5871E094F7103A36213597CB2400", hash_generated_method = "70287CF43A543D03BB9E3EA61951D74B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder(Context context, int theme) {
            dsTaint.addTaint(theme);
            dsTaint.addTaint(context.dsTaint);
            P = new AlertController.AlertParams(new ContextThemeWrapper(
                    context, resolveDialogTheme(context, theme)));
            // ---------- Original Method ----------
            //P = new AlertController.AlertParams(new ContextThemeWrapper(
                    //context, resolveDialogTheme(context, theme)));
            //mTheme = theme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.485 -0400", hash_original_method = "D1A12C2F09D145663A4318954DC7CD00", hash_generated_method = "757A00004CAC04C42D6356DFB48169C0")
        @DSModeled(DSC.SAFE)
        public Context getContext() {
            return (Context)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return P.mContext;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.486 -0400", hash_original_method = "E63FAC4DEED51E16AAD703A71B581EEF", hash_generated_method = "230695B4EF0BFBA618BB3FCBB7EA27DF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setTitle(int titleId) {
            dsTaint.addTaint(titleId);
            P.mTitle = P.mContext.getText(titleId);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mTitle = P.mContext.getText(titleId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.487 -0400", hash_original_method = "255D326AF0B389CCA9CBF4AFBC3FE756", hash_generated_method = "B315DC7EAE7471D87BF8B1A3E5A95D6F")
        @DSModeled(DSC.SAFE)
        public Builder setTitle(CharSequence title) {
            dsTaint.addTaint(title);
            P.mTitle = title;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mTitle = title;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.487 -0400", hash_original_method = "0009CCFABCB39131348E93CD167BBCD7", hash_generated_method = "A63241008966394EFBF4BDF6C7D15FE0")
        @DSModeled(DSC.SAFE)
        public Builder setCustomTitle(View customTitleView) {
            dsTaint.addTaint(customTitleView.dsTaint);
            P.mCustomTitleView = customTitleView;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mCustomTitleView = customTitleView;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.488 -0400", hash_original_method = "3B23BD93B750653B90374824F5917D89", hash_generated_method = "C42172972B39089795DC894AA583ABAD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setMessage(int messageId) {
            dsTaint.addTaint(messageId);
            P.mMessage = P.mContext.getText(messageId);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mMessage = P.mContext.getText(messageId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.488 -0400", hash_original_method = "F560859B14C962F22BDF3327E633A8EC", hash_generated_method = "EA902B42CB4921523FE783DE7ABACEAF")
        @DSModeled(DSC.SAFE)
        public Builder setMessage(CharSequence message) {
            dsTaint.addTaint(message);
            P.mMessage = message;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mMessage = message;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.489 -0400", hash_original_method = "EBD38AA9C651B93ADF14B14E5D33C5C9", hash_generated_method = "F77AF34F4FA3BD0A5719D560DD48B2E9")
        @DSModeled(DSC.SAFE)
        public Builder setIcon(int iconId) {
            dsTaint.addTaint(iconId);
            P.mIconId = iconId;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mIconId = iconId;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.489 -0400", hash_original_method = "EDCD80F224B2F3CED85A928D84460540", hash_generated_method = "D90AE2908AEAC05ECEF5CDCD10B82881")
        @DSModeled(DSC.SAFE)
        public Builder setIcon(Drawable icon) {
            dsTaint.addTaint(icon.dsTaint);
            P.mIcon = icon;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mIcon = icon;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.490 -0400", hash_original_method = "3A94A6A2822E55FB53EB2F980E52FF8E", hash_generated_method = "6DDEB89D8D07F38350E1781D59B7431D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setIconAttribute(int attrId) {
            dsTaint.addTaint(attrId);
            TypedValue out;
            out = new TypedValue();
            P.mContext.getTheme().resolveAttribute(attrId, out, true);
            P.mIconId = out.resourceId;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //TypedValue out = new TypedValue();
            //P.mContext.getTheme().resolveAttribute(attrId, out, true);
            //P.mIconId = out.resourceId;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.490 -0400", hash_original_method = "1908B917B7F2E57ADC23D5E48F4386F2", hash_generated_method = "7C313E3FBC87BA8C8835CF8B467EBF52")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setPositiveButton(int textId, final OnClickListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(textId);
            P.mPositiveButtonText = P.mContext.getText(textId);
            P.mPositiveButtonListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mPositiveButtonText = P.mContext.getText(textId);
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.491 -0400", hash_original_method = "1500328C36AB679D672A26C184A5FC31", hash_generated_method = "5DDAB6C8FE277C7668113CB1F9A6DD97")
        @DSModeled(DSC.SAFE)
        public Builder setPositiveButton(CharSequence text, final OnClickListener listener) {
            dsTaint.addTaint(text);
            dsTaint.addTaint(listener.dsTaint);
            P.mPositiveButtonText = text;
            P.mPositiveButtonListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mPositiveButtonText = text;
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.491 -0400", hash_original_method = "375537371A0A52AA7AA0B24EAC6A7474", hash_generated_method = "BBD278E65CA06C11BC74E98F97CAE1B3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setNegativeButton(int textId, final OnClickListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(textId);
            P.mNegativeButtonText = P.mContext.getText(textId);
            P.mNegativeButtonListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mNegativeButtonText = P.mContext.getText(textId);
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.492 -0400", hash_original_method = "50EFB872DEBCC22CFB32B40979906BC8", hash_generated_method = "DD81F93FCC50208EE8FFC387FB7972B1")
        @DSModeled(DSC.SAFE)
        public Builder setNegativeButton(CharSequence text, final OnClickListener listener) {
            dsTaint.addTaint(text);
            dsTaint.addTaint(listener.dsTaint);
            P.mNegativeButtonText = text;
            P.mNegativeButtonListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mNegativeButtonText = text;
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.492 -0400", hash_original_method = "0D40DB16A6B6349ABA0D8583C3D4D844", hash_generated_method = "FDD57A265C158E7A0AF5393AA7A92405")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setNeutralButton(int textId, final OnClickListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(textId);
            P.mNeutralButtonText = P.mContext.getText(textId);
            P.mNeutralButtonListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mNeutralButtonText = P.mContext.getText(textId);
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.493 -0400", hash_original_method = "4D91C8A8E1E08D55171F5837D3929412", hash_generated_method = "07760C682290614415552BCB02357634")
        @DSModeled(DSC.SAFE)
        public Builder setNeutralButton(CharSequence text, final OnClickListener listener) {
            dsTaint.addTaint(text);
            dsTaint.addTaint(listener.dsTaint);
            P.mNeutralButtonText = text;
            P.mNeutralButtonListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mNeutralButtonText = text;
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.493 -0400", hash_original_method = "D23CAE45E6F3DF826F9F93A9D8E4F37B", hash_generated_method = "B1362DE1C377293A1BC37D21DDBE1D34")
        @DSModeled(DSC.SAFE)
        public Builder setCancelable(boolean cancelable) {
            dsTaint.addTaint(cancelable);
            P.mCancelable = cancelable;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mCancelable = cancelable;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.494 -0400", hash_original_method = "D6E5909FD450512C75F4E75E987AC229", hash_generated_method = "CCC181EC68B8275BED6389C21BFD6B8B")
        @DSModeled(DSC.SAFE)
        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            dsTaint.addTaint(onCancelListener.dsTaint);
            P.mOnCancelListener = onCancelListener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mOnCancelListener = onCancelListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.494 -0400", hash_original_method = "6E5FB56A362A817B52A235DFACC25DAE", hash_generated_method = "2C7D858FECD1B2ECD41892A93034DBD8")
        @DSModeled(DSC.SAFE)
        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            dsTaint.addTaint(onKeyListener.dsTaint);
            P.mOnKeyListener = onKeyListener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mOnKeyListener = onKeyListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.495 -0400", hash_original_method = "6D193582453841FD4D6BB305EA061757", hash_generated_method = "EF961A0C44768CEA660D3FC8D0162F45")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setItems(int itemsId, final OnClickListener listener) {
            dsTaint.addTaint(itemsId);
            dsTaint.addTaint(listener.dsTaint);
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.495 -0400", hash_original_method = "AFD2C4146CF077CBCC62EEF7225AE645", hash_generated_method = "FC6344E23F89EA0A7F741A2050E72906")
        @DSModeled(DSC.SAFE)
        public Builder setItems(CharSequence[] items, final OnClickListener listener) {
            dsTaint.addTaint(items[0]);
            dsTaint.addTaint(listener.dsTaint);
            P.mItems = items;
            P.mOnClickListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.496 -0400", hash_original_method = "2FCAEDE0B3C9195EDB3158F22A7C0109", hash_generated_method = "46D0F4F161735572039B8CAB8FCF1028")
        @DSModeled(DSC.SAFE)
        public Builder setAdapter(final ListAdapter adapter, final OnClickListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(adapter.dsTaint);
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mAdapter = adapter;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.496 -0400", hash_original_method = "7DFF15703A2CCBB36AC3557F6AE7E187", hash_generated_method = "107B51880A9426DF7F30E9989414EF94")
        @DSModeled(DSC.SAFE)
        public Builder setCursor(final Cursor cursor, final OnClickListener listener,
                String labelColumn) {
            dsTaint.addTaint(cursor.dsTaint);
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(labelColumn);
            P.mCursor = cursor;
            P.mLabelColumn = labelColumn;
            P.mOnClickListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mLabelColumn = labelColumn;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.497 -0400", hash_original_method = "7878252A286B56EBCE9E439D4FCEB298", hash_generated_method = "1E33619EBD743CE81781B1C79B325CA2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            dsTaint.addTaint(itemsId);
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(checkedItems[0]);
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnCheckboxClickListener = listener;
            //P.mCheckedItems = checkedItems;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.498 -0400", hash_original_method = "73AB6C3AD26EFF6561BAC3BA481ECFD7", hash_generated_method = "DDF244A9DDFA1F1B6AB14EF9CAB7A597")
        @DSModeled(DSC.SAFE)
        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            dsTaint.addTaint(items[0]);
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(checkedItems[0]);
            P.mItems = items;
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnCheckboxClickListener = listener;
            //P.mCheckedItems = checkedItems;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.499 -0400", hash_original_method = "E8A3FFCE7184DC2DAE306B849E312FF3", hash_generated_method = "6C88B8C750175251E5192A39368D82D5")
        @DSModeled(DSC.SAFE)
        public Builder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn, 
                final OnMultiChoiceClickListener listener) {
            dsTaint.addTaint(cursor.dsTaint);
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(isCheckedColumn);
            dsTaint.addTaint(labelColumn);
            P.mCursor = cursor;
            P.mOnCheckboxClickListener = listener;
            P.mIsCheckedColumn = isCheckedColumn;
            P.mLabelColumn = labelColumn;
            P.mIsMultiChoice = true;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mOnCheckboxClickListener = listener;
            //P.mIsCheckedColumn = isCheckedColumn;
            //P.mLabelColumn = labelColumn;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.500 -0400", hash_original_method = "CF9378D7D2AE06BB2F5FFE088D660C44", hash_generated_method = "948EC164DC904FF66022D5266ED5FBB1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setSingleChoiceItems(int itemsId, int checkedItem, 
                final OnClickListener listener) {
            dsTaint.addTaint(itemsId);
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(checkedItem);
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.500 -0400", hash_original_method = "02441459B611830238DF1D8B31546828", hash_generated_method = "0D0BE9CB6E83A4F6F5FFE59A8AD51294")
        @DSModeled(DSC.SAFE)
        public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, 
                final OnClickListener listener) {
            dsTaint.addTaint(cursor.dsTaint);
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(checkedItem);
            dsTaint.addTaint(labelColumn);
            P.mCursor = cursor;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mLabelColumn = labelColumn;
            P.mIsSingleChoice = true;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mLabelColumn = labelColumn;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.501 -0400", hash_original_method = "7491118E608CEFA972DD3B23E3E7B8C6", hash_generated_method = "CE0FC23B653D8A378438BD4EEBF5CD63")
        @DSModeled(DSC.SAFE)
        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener) {
            dsTaint.addTaint(items[0]);
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(checkedItem);
            P.mItems = items;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.502 -0400", hash_original_method = "06BB43759703ED3EE55275B85ACF4622", hash_generated_method = "E3440E5A4C18E3ECF66ED0464F761BAC")
        @DSModeled(DSC.SAFE)
        public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, final OnClickListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(checkedItem);
            dsTaint.addTaint(adapter.dsTaint);
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mAdapter = adapter;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.503 -0400", hash_original_method = "2F93F9BAEF2ABE538EE141EAC45DF294", hash_generated_method = "DA9B27F0127762A3D2C285359F0C53E8")
        @DSModeled(DSC.SAFE)
        public Builder setOnItemSelectedListener(final AdapterView.OnItemSelectedListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            P.mOnItemSelectedListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mOnItemSelectedListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.504 -0400", hash_original_method = "ECE0E9F89C9289601A4B4F810B41F8E6", hash_generated_method = "84EE86AA6B2BAE19991316B6DA423AEE")
        @DSModeled(DSC.SAFE)
        public Builder setView(View view) {
            dsTaint.addTaint(view.dsTaint);
            P.mView = view;
            P.mViewSpacingSpecified = false;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mView = view;
            //P.mViewSpacingSpecified = false;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.505 -0400", hash_original_method = "BAFAE1A19AC8AE3D7A23796C6231E632", hash_generated_method = "0772DAEC85BAFA50E85E4227E973CDCF")
        @DSModeled(DSC.SAFE)
        public Builder setView(View view, int viewSpacingLeft, int viewSpacingTop,
                int viewSpacingRight, int viewSpacingBottom) {
            dsTaint.addTaint(viewSpacingBottom);
            dsTaint.addTaint(viewSpacingTop);
            dsTaint.addTaint(viewSpacingRight);
            dsTaint.addTaint(view.dsTaint);
            dsTaint.addTaint(viewSpacingLeft);
            P.mView = view;
            P.mViewSpacingSpecified = true;
            P.mViewSpacingLeft = viewSpacingLeft;
            P.mViewSpacingTop = viewSpacingTop;
            P.mViewSpacingRight = viewSpacingRight;
            P.mViewSpacingBottom = viewSpacingBottom;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mView = view;
            //P.mViewSpacingSpecified = true;
            //P.mViewSpacingLeft = viewSpacingLeft;
            //P.mViewSpacingTop = viewSpacingTop;
            //P.mViewSpacingRight = viewSpacingRight;
            //P.mViewSpacingBottom = viewSpacingBottom;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.506 -0400", hash_original_method = "574A516CEEC9B60678E7B4D3D76288FB", hash_generated_method = "AE41E90F66813A0EE547440728C69F09")
        @DSModeled(DSC.SAFE)
        public Builder setInverseBackgroundForced(boolean useInverseBackground) {
            dsTaint.addTaint(useInverseBackground);
            P.mForceInverseBackground = useInverseBackground;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mForceInverseBackground = useInverseBackground;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.507 -0400", hash_original_method = "B90B897256AEB065436BDBB1FFCE63CD", hash_generated_method = "B80CAE2E6025A7990C6F4227C1FC82E0")
        @DSModeled(DSC.SAFE)
        public Builder setRecycleOnMeasureEnabled(boolean enabled) {
            dsTaint.addTaint(enabled);
            P.mRecycleOnMeasure = enabled;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mRecycleOnMeasure = enabled;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.507 -0400", hash_original_method = "24F2ECF5FEA53B0907C34A4AFC4C2134", hash_generated_method = "3E9D61A3418626F5C092E3C209459FBF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AlertDialog create() {
            AlertDialog dialog;
            dialog = new AlertDialog(P.mContext, mTheme, false);
            P.apply(dialog.mAlert);
            dialog.setCancelable(P.mCancelable);
            {
                dialog.setCanceledOnTouchOutside(true);
            } //End block
            dialog.setOnCancelListener(P.mOnCancelListener);
            {
                dialog.setOnKeyListener(P.mOnKeyListener);
            } //End block
            return (AlertDialog)dsTaint.getTaint();
            // ---------- Original Method ----------
            //final AlertDialog dialog = new AlertDialog(P.mContext, mTheme, false);
            //P.apply(dialog.mAlert);
            //dialog.setCancelable(P.mCancelable);
            //if (P.mCancelable) {
                //dialog.setCanceledOnTouchOutside(true);
            //}
            //dialog.setOnCancelListener(P.mOnCancelListener);
            //if (P.mOnKeyListener != null) {
                //dialog.setOnKeyListener(P.mOnKeyListener);
            //}
            //return dialog;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.508 -0400", hash_original_method = "9ED881995B2EAB3CB90B8129D2705377", hash_generated_method = "7D61511C9C8D6253B259A1566D7A0540")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AlertDialog show() {
            AlertDialog dialog;
            dialog = create();
            dialog.show();
            return (AlertDialog)dsTaint.getTaint();
            // ---------- Original Method ----------
            //AlertDialog dialog = create();
            //dialog.show();
            //return dialog;
        }

        
    }


    
    public static final int THEME_TRADITIONAL = 1;
    public static final int THEME_HOLO_DARK = 2;
    public static final int THEME_HOLO_LIGHT = 3;
    public static final int THEME_DEVICE_DEFAULT_DARK = 4;
    public static final int THEME_DEVICE_DEFAULT_LIGHT = 5;
}

