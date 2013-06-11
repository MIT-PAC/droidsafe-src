package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final int THEME_TRADITIONAL = 1;
    public static final int THEME_HOLO_DARK = 2;
    public static final int THEME_HOLO_LIGHT = 3;
    public static final int THEME_DEVICE_DEFAULT_DARK = 4;
    public static final int THEME_DEVICE_DEFAULT_LIGHT = 5;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.696 -0400", hash_original_method = "3B9AE3A4287FBB2F8914E3FC42E19D75", hash_generated_method = "8ABCA4E6BC54E5E07B753430182D3459")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.696 -0400", hash_original_method = "C5FA972556687388DAE356FD387A2EE9", hash_generated_method = "5126FE6AEBDCCB6C125B3DEDACFD6380")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected AlertDialog(Context context, int theme) {
        this(context, theme, true);
        dsTaint.addTaint(theme);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.696 -0400", hash_original_method = "6D386DC5BAB559A725B0E80B3B80739F", hash_generated_method = "C0B1976CF4C6B8EDBBB9FC5DCBB69141")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.697 -0400", hash_original_method = "EA464E0CF4AA10E0AEDF6B163BEEF729", hash_generated_method = "A9E93662205438C420727A1A425E9A99")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.697 -0400", hash_original_method = "B16DF712FADBC6F763054B9AFC3C54C8", hash_generated_method = "F44F5FA06CEE315FB7317D3B45E8CE1D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.697 -0400", hash_original_method = "2277A8C194577CB499FB53C1370D61D1", hash_generated_method = "B7B15D7187C014C82EAD82067496E03D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Button getButton(int whichButton) {
        dsTaint.addTaint(whichButton);
        Button var029B30BB7360A70A943E2608DA0A708B_695408802 = (mAlert.getButton(whichButton));
        return (Button)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAlert.getButton(whichButton);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.698 -0400", hash_original_method = "ECC410A91FC6F30B82508F44C93EA39B", hash_generated_method = "A709E341E8B0A1978DBD6C4B637FD9FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListView getListView() {
        ListView var95A49C1FAF2DDB8BED96C01B211B1216_1701033091 = (mAlert.getListView());
        return (ListView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAlert.getListView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.698 -0400", hash_original_method = "5655E82DFA793B6CD86300EA45F77D5A", hash_generated_method = "DE3FEC2CDB464E35AC4AF069540E9D7D")
    @DSModeled(DSC.SAFE)
    @Override
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        super.setTitle(title);
        mAlert.setTitle(title);
        // ---------- Original Method ----------
        //super.setTitle(title);
        //mAlert.setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.698 -0400", hash_original_method = "0AAF0E3192DB53DCF899ECF927301A42", hash_generated_method = "6E4E161226DF6647637BCFD2EAD7CE8F")
    @DSModeled(DSC.SAFE)
    public void setCustomTitle(View customTitleView) {
        dsTaint.addTaint(customTitleView.dsTaint);
        mAlert.setCustomTitle(customTitleView);
        // ---------- Original Method ----------
        //mAlert.setCustomTitle(customTitleView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.699 -0400", hash_original_method = "0FDFF41BD74285789F29E89A2F2C112C", hash_generated_method = "F334590EFA1328F19E188ADA8295C4B4")
    @DSModeled(DSC.SAFE)
    public void setMessage(CharSequence message) {
        dsTaint.addTaint(message);
        mAlert.setMessage(message);
        // ---------- Original Method ----------
        //mAlert.setMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.699 -0400", hash_original_method = "588C26275F4E62D9742C7DBB082EE340", hash_generated_method = "4FE72C9BE50966DABCD846F9A7A0471E")
    @DSModeled(DSC.SAFE)
    public void setView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mAlert.setView(view);
        // ---------- Original Method ----------
        //mAlert.setView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.699 -0400", hash_original_method = "399D46DD3D86F04F15AA9836309BED7E", hash_generated_method = "EF3A25BD4015B6BCD798D7E01A62EED7")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.699 -0400", hash_original_method = "CFE09EBA63F60A6BEEDA0ECE4DBD2BBE", hash_generated_method = "29EEE3A15E194A6C9DAF0A4715FF95AD")
    @DSModeled(DSC.SAFE)
    public void setButton(int whichButton, CharSequence text, Message msg) {
        dsTaint.addTaint(whichButton);
        dsTaint.addTaint(text);
        dsTaint.addTaint(msg.dsTaint);
        mAlert.setButton(whichButton, text, null, msg);
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, null, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.700 -0400", hash_original_method = "FD92C01692F456341A0525E9D1CD5A83", hash_generated_method = "4ADA53CD48FBCBC4D8D3DD81C2E2DCB6")
    @DSModeled(DSC.SAFE)
    public void setButton(int whichButton, CharSequence text, OnClickListener listener) {
        dsTaint.addTaint(whichButton);
        dsTaint.addTaint(text);
        dsTaint.addTaint(listener.dsTaint);
        mAlert.setButton(whichButton, text, listener, null);
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, listener, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.700 -0400", hash_original_method = "2930D21A7389B776726F7D14477E22A5", hash_generated_method = "194F5CA9A0041DB3D627F14934CF83FF")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setButton(CharSequence text, Message msg) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(msg.dsTaint);
        setButton(BUTTON_POSITIVE, text, msg);
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.700 -0400", hash_original_method = "5D138EC6D4B89A4911514A5D190A83FC", hash_generated_method = "4ADDF364C2EC87BD83BAE8E7603D4692")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setButton2(CharSequence text, Message msg) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(msg.dsTaint);
        setButton(BUTTON_NEGATIVE, text, msg);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.701 -0400", hash_original_method = "E62AA308196D7D74E77874CB13CC8D38", hash_generated_method = "6B4447EEB1421E7409F6B8BA550C21DF")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setButton3(CharSequence text, Message msg) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(msg.dsTaint);
        setButton(BUTTON_NEUTRAL, text, msg);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.701 -0400", hash_original_method = "14303CDDA201782BB4EE72003EBE4B25", hash_generated_method = "5939C6BA3438C00FAADD705BF520CFB6")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setButton(CharSequence text, final OnClickListener listener) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(listener.dsTaint);
        setButton(BUTTON_POSITIVE, text, listener);
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.701 -0400", hash_original_method = "99FBB4BC7546CFCEFDAC9CCE0B0EC52F", hash_generated_method = "BFE1A1285557EEAD37E374181E49910E")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setButton2(CharSequence text, final OnClickListener listener) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(listener.dsTaint);
        setButton(BUTTON_NEGATIVE, text, listener);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.702 -0400", hash_original_method = "9225C5ACB453A48CCE22F622BD426A12", hash_generated_method = "0B029F1FB408DE032C8D78426CFEA6ED")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void setButton3(CharSequence text, final OnClickListener listener) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(listener.dsTaint);
        setButton(BUTTON_NEUTRAL, text, listener);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.702 -0400", hash_original_method = "B742B976A105323EE27DB344109D47DF", hash_generated_method = "BAD8698276E6F1D5F308792D0380C1B6")
    @DSModeled(DSC.SAFE)
    public void setIcon(int resId) {
        dsTaint.addTaint(resId);
        mAlert.setIcon(resId);
        // ---------- Original Method ----------
        //mAlert.setIcon(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.702 -0400", hash_original_method = "58CB6A167EA4E7B84F26608014843ADF", hash_generated_method = "2F93A052308C85E3162E08171E2BFDC9")
    @DSModeled(DSC.SAFE)
    public void setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        mAlert.setIcon(icon);
        // ---------- Original Method ----------
        //mAlert.setIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.702 -0400", hash_original_method = "1B8133F4D68862D013C951EDD0C82832", hash_generated_method = "0F6E1FEB060A1C209376526D7496B8FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIconAttribute(int attrId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.703 -0400", hash_original_method = "21C74C630736CECBD7AD6F509C2AA5D7", hash_generated_method = "8CD3BBE8079EC0048C9511ED54B3D284")
    @DSModeled(DSC.SAFE)
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        dsTaint.addTaint(forceInverseBackground);
        mAlert.setInverseBackgroundForced(forceInverseBackground);
        // ---------- Original Method ----------
        //mAlert.setInverseBackgroundForced(forceInverseBackground);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.703 -0400", hash_original_method = "84106AE7CC1A6E59D6E45CD48A2A2307", hash_generated_method = "6CE541DA57C553C3745AB307F3BB4737")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.703 -0400", hash_original_method = "BF8AB256B91D3A887301218CA5494F2D", hash_generated_method = "6694E46CE8CB756CE24BCF6CBB1780FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean var0860591BEC688168A96E8D7B8A8FC21B_582890114 = (mAlert.onKeyDown(keyCode, event));
        } //End collapsed parenthetic
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1357479989 = (super.onKeyDown(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAlert.onKeyDown(keyCode, event)) return true;
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.704 -0400", hash_original_method = "A1B1EEF278CFBA53A19AA72D7DAA37CB", hash_generated_method = "E9A21927B0EE4B56A389E0C38CB6FB48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        {
            boolean varC975F70000285699A9B742C42371726C_1010512554 = (mAlert.onKeyUp(keyCode, event));
        } //End collapsed parenthetic
        boolean varEDD771EBF66425AD21882AB08CD0EE48_898882030 = (super.onKeyUp(keyCode, event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAlert.onKeyUp(keyCode, event)) return true;
        //return super.onKeyUp(keyCode, event);
    }

    
    public static class Builder {
        private final AlertController.AlertParams P;
        private int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.704 -0400", hash_original_method = "CB1BA6F353D1C3D1D9DFD93D2E2AA221", hash_generated_method = "8B1CD487E6E560E91D01C9962D73C134")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder(Context context) {
            this(context, resolveDialogTheme(context, 0));
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.705 -0400", hash_original_method = "054A5871E094F7103A36213597CB2400", hash_generated_method = "DF58781580C9F1256809490AEE212FA2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.705 -0400", hash_original_method = "D1A12C2F09D145663A4318954DC7CD00", hash_generated_method = "19B136A4C0A1F8FF977BF8DDB89FFAB7")
        @DSModeled(DSC.SAFE)
        public Context getContext() {
            return (Context)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return P.mContext;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.705 -0400", hash_original_method = "E63FAC4DEED51E16AAD703A71B581EEF", hash_generated_method = "33049EF090B2EA24546B4C53CE7BAC6A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setTitle(int titleId) {
            dsTaint.addTaint(titleId);
            P.mTitle = P.mContext.getText(titleId);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mTitle = P.mContext.getText(titleId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.705 -0400", hash_original_method = "255D326AF0B389CCA9CBF4AFBC3FE756", hash_generated_method = "633CA40264DE168CC345430652BD0777")
        @DSModeled(DSC.SAFE)
        public Builder setTitle(CharSequence title) {
            dsTaint.addTaint(title);
            P.mTitle = title;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mTitle = title;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.706 -0400", hash_original_method = "0009CCFABCB39131348E93CD167BBCD7", hash_generated_method = "9DEF2D8ABCA5909892B082C848A17F26")
        @DSModeled(DSC.SAFE)
        public Builder setCustomTitle(View customTitleView) {
            dsTaint.addTaint(customTitleView.dsTaint);
            P.mCustomTitleView = customTitleView;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mCustomTitleView = customTitleView;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.706 -0400", hash_original_method = "3B23BD93B750653B90374824F5917D89", hash_generated_method = "BA691C75DD957111DFFCBFF1F6DA1BF6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setMessage(int messageId) {
            dsTaint.addTaint(messageId);
            P.mMessage = P.mContext.getText(messageId);
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mMessage = P.mContext.getText(messageId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.706 -0400", hash_original_method = "F560859B14C962F22BDF3327E633A8EC", hash_generated_method = "368D3986F1E78EFDE5059C850FBF22F8")
        @DSModeled(DSC.SAFE)
        public Builder setMessage(CharSequence message) {
            dsTaint.addTaint(message);
            P.mMessage = message;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mMessage = message;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.707 -0400", hash_original_method = "EBD38AA9C651B93ADF14B14E5D33C5C9", hash_generated_method = "78944630EE7CBC2E01B4535970260756")
        @DSModeled(DSC.SAFE)
        public Builder setIcon(int iconId) {
            dsTaint.addTaint(iconId);
            P.mIconId = iconId;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mIconId = iconId;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.707 -0400", hash_original_method = "EDCD80F224B2F3CED85A928D84460540", hash_generated_method = "3002C46616AB6CD460015775AF19FF71")
        @DSModeled(DSC.SAFE)
        public Builder setIcon(Drawable icon) {
            dsTaint.addTaint(icon.dsTaint);
            P.mIcon = icon;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mIcon = icon;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.707 -0400", hash_original_method = "3A94A6A2822E55FB53EB2F980E52FF8E", hash_generated_method = "67E43DCCF6C500145B31B1FC8260BA70")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setIconAttribute(int attrId) {
            //DSFIXME:  CODE0009: Possible callback target function detected
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.708 -0400", hash_original_method = "1908B917B7F2E57ADC23D5E48F4386F2", hash_generated_method = "8044B4D1DE6AE8B20541661CFCDEE990")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setPositiveButton(int textId, final OnClickListener listener) {
            dsTaint.addTaint(textId);
            dsTaint.addTaint(listener.dsTaint);
            P.mPositiveButtonText = P.mContext.getText(textId);
            P.mPositiveButtonListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mPositiveButtonText = P.mContext.getText(textId);
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.708 -0400", hash_original_method = "1500328C36AB679D672A26C184A5FC31", hash_generated_method = "BE7744F9AF76A68F1E19BB6AD6CDC1ED")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.708 -0400", hash_original_method = "375537371A0A52AA7AA0B24EAC6A7474", hash_generated_method = "D80177E48737287568323A62D465D5F5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setNegativeButton(int textId, final OnClickListener listener) {
            dsTaint.addTaint(textId);
            dsTaint.addTaint(listener.dsTaint);
            P.mNegativeButtonText = P.mContext.getText(textId);
            P.mNegativeButtonListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mNegativeButtonText = P.mContext.getText(textId);
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.709 -0400", hash_original_method = "50EFB872DEBCC22CFB32B40979906BC8", hash_generated_method = "C020C3DFBE2D8574F1BD9A2E832B7696")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.709 -0400", hash_original_method = "0D40DB16A6B6349ABA0D8583C3D4D844", hash_generated_method = "27A419E28BEF2238FDAF14772465597E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setNeutralButton(int textId, final OnClickListener listener) {
            dsTaint.addTaint(textId);
            dsTaint.addTaint(listener.dsTaint);
            P.mNeutralButtonText = P.mContext.getText(textId);
            P.mNeutralButtonListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mNeutralButtonText = P.mContext.getText(textId);
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.709 -0400", hash_original_method = "4D91C8A8E1E08D55171F5837D3929412", hash_generated_method = "974E2A5971F512BEC760B15A3114409D")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.710 -0400", hash_original_method = "D23CAE45E6F3DF826F9F93A9D8E4F37B", hash_generated_method = "6FBF2ED52063199E78088D4139B3CF94")
        @DSModeled(DSC.SAFE)
        public Builder setCancelable(boolean cancelable) {
            dsTaint.addTaint(cancelable);
            P.mCancelable = cancelable;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mCancelable = cancelable;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.710 -0400", hash_original_method = "D6E5909FD450512C75F4E75E987AC229", hash_generated_method = "BE2E644E8012B51C4B7444FF7724D169")
        @DSModeled(DSC.SAFE)
        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            dsTaint.addTaint(onCancelListener.dsTaint);
            P.mOnCancelListener = onCancelListener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mOnCancelListener = onCancelListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.710 -0400", hash_original_method = "6E5FB56A362A817B52A235DFACC25DAE", hash_generated_method = "50EE5B14CC92D6623FDF7F4FA6AE971C")
        @DSModeled(DSC.SAFE)
        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            dsTaint.addTaint(onKeyListener.dsTaint);
            P.mOnKeyListener = onKeyListener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mOnKeyListener = onKeyListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.710 -0400", hash_original_method = "6D193582453841FD4D6BB305EA061757", hash_generated_method = "B05E24B4CBD7F5F8BBA796955404573F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.711 -0400", hash_original_method = "AFD2C4146CF077CBCC62EEF7225AE645", hash_generated_method = "2EFD3FCE41EAE52C1089A4238AFAA71C")
        @DSModeled(DSC.SAFE)
        public Builder setItems(CharSequence[] items, final OnClickListener listener) {
            dsTaint.addTaint(items);
            dsTaint.addTaint(listener.dsTaint);
            P.mItems = items;
            P.mOnClickListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.711 -0400", hash_original_method = "2FCAEDE0B3C9195EDB3158F22A7C0109", hash_generated_method = "3C9BFBAA3C484598EC0043AF53C9EC99")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.711 -0400", hash_original_method = "7DFF15703A2CCBB36AC3557F6AE7E187", hash_generated_method = "9527363D69191CCA5C71B158DAC60ABE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.712 -0400", hash_original_method = "7878252A286B56EBCE9E439D4FCEB298", hash_generated_method = "0340627206AABF2876B79A38CE6DBB71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            dsTaint.addTaint(itemsId);
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(checkedItems);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.712 -0400", hash_original_method = "73AB6C3AD26EFF6561BAC3BA481ECFD7", hash_generated_method = "F78AB0F3DC674A7DD757253F2584208C")
        @DSModeled(DSC.SAFE)
        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            dsTaint.addTaint(items);
            dsTaint.addTaint(listener.dsTaint);
            dsTaint.addTaint(checkedItems);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.713 -0400", hash_original_method = "E8A3FFCE7184DC2DAE306B849E312FF3", hash_generated_method = "D8AB6EE3418E5C1E1331104696CE0AFC")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.713 -0400", hash_original_method = "CF9378D7D2AE06BB2F5FFE088D660C44", hash_generated_method = "50BCAF8FBED393085C86F35875F8F6DE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.713 -0400", hash_original_method = "02441459B611830238DF1D8B31546828", hash_generated_method = "BCE8A39F698033E0076E8F8EF8533DAD")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.714 -0400", hash_original_method = "7491118E608CEFA972DD3B23E3E7B8C6", hash_generated_method = "3ED9B55A630D9DBA5AFEF5BA13748521")
        @DSModeled(DSC.SAFE)
        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener) {
            dsTaint.addTaint(items);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.714 -0400", hash_original_method = "06BB43759703ED3EE55275B85ACF4622", hash_generated_method = "508F7B378210B4B909ADA3688245109C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.714 -0400", hash_original_method = "2F93F9BAEF2ABE538EE141EAC45DF294", hash_generated_method = "3ED7E335DE9EDD7DAFD0361BDC4C1166")
        @DSModeled(DSC.SAFE)
        public Builder setOnItemSelectedListener(final AdapterView.OnItemSelectedListener listener) {
            dsTaint.addTaint(listener.dsTaint);
            P.mOnItemSelectedListener = listener;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mOnItemSelectedListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.715 -0400", hash_original_method = "ECE0E9F89C9289601A4B4F810B41F8E6", hash_generated_method = "BC4B549905706B10493F4F96A387AD8E")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.715 -0400", hash_original_method = "BAFAE1A19AC8AE3D7A23796C6231E632", hash_generated_method = "8610F38A1DCA241C1DE76509CD146491")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.715 -0400", hash_original_method = "574A516CEEC9B60678E7B4D3D76288FB", hash_generated_method = "086F4B60A5EE2E8097352477957BFECB")
        @DSModeled(DSC.SAFE)
        public Builder setInverseBackgroundForced(boolean useInverseBackground) {
            dsTaint.addTaint(useInverseBackground);
            P.mForceInverseBackground = useInverseBackground;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mForceInverseBackground = useInverseBackground;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.716 -0400", hash_original_method = "B90B897256AEB065436BDBB1FFCE63CD", hash_generated_method = "7EEC6733898411E01A969B9AF7DE875A")
        @DSModeled(DSC.SAFE)
        public Builder setRecycleOnMeasureEnabled(boolean enabled) {
            dsTaint.addTaint(enabled);
            P.mRecycleOnMeasure = enabled;
            return (Builder)dsTaint.getTaint();
            // ---------- Original Method ----------
            //P.mRecycleOnMeasure = enabled;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.716 -0400", hash_original_method = "24F2ECF5FEA53B0907C34A4AFC4C2134", hash_generated_method = "7650F9359215B9DA0ABF5BF5A17B8FDD")
        @DSModeled(DSC.SAFE)
        public AlertDialog create() {
            final AlertDialog dialog;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:58.716 -0400", hash_original_method = "9ED881995B2EAB3CB90B8129D2705377", hash_generated_method = "30B67CF037DF521D3C4245ABBDC11265")
        @DSModeled(DSC.SAFE)
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


    
}


