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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.801 -0400", hash_original_field = "5117530B5FC21047AC49783CC786404F", hash_generated_field = "167B5CF3490749BA13C3817234C227CF")

    private AlertController mAlert;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.814 -0400", hash_original_method = "3B9AE3A4287FBB2F8914E3FC42E19D75", hash_generated_method = "1583F710FE0C1778C52687E18EADF09B")
    protected  AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.816 -0400", hash_original_method = "C5FA972556687388DAE356FD387A2EE9", hash_generated_method = "CE0D53A489B0326F02AB48EAEA4541F5")
    protected  AlertDialog(Context context, int theme) {
        this(context, theme, true);
        addTaint(context.getTaint());
        addTaint(theme);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.831 -0400", hash_original_method = "6D386DC5BAB559A725B0E80B3B80739F", hash_generated_method = "3F34B817F90BB4AEA127B1A439CCC1C5")
      AlertDialog(Context context, int theme, boolean createContextWrapper) {
        super(context, resolveDialogTheme(context, theme), createContextWrapper);
        mWindow.alwaysReadCloseOnTouchAttr();
        mAlert = new AlertController(getContext(), this, getWindow());
        addTaint(context.getTaint());
        addTaint(theme);
        addTaint(createContextWrapper);
        // ---------- Original Method ----------
        //mWindow.alwaysReadCloseOnTouchAttr();
        //mAlert = new AlertController(getContext(), this, getWindow());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.834 -0400", hash_original_method = "EA464E0CF4AA10E0AEDF6B163BEEF729", hash_generated_method = "E49815D05BEC276A8A0718C38E86FAA0")
    protected  AlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, resolveDialogTheme(context, 0));
        mWindow.alwaysReadCloseOnTouchAttr();
        setCancelable(cancelable);
        setOnCancelListener(cancelListener);
        mAlert = new AlertController(context, this, getWindow());
        addTaint(cancelable);
        addTaint(cancelListener.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.856 -0400", hash_original_method = "2277A8C194577CB499FB53C1370D61D1", hash_generated_method = "F3632A04613825381EE5B16D90EADCE1")
    public Button getButton(int whichButton) {
        Button varB4EAC82CA7396A68D541C85D26508E83_1498849939 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1498849939 = mAlert.getButton(whichButton);
        addTaint(whichButton);
        varB4EAC82CA7396A68D541C85D26508E83_1498849939.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1498849939;
        // ---------- Original Method ----------
        //return mAlert.getButton(whichButton);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.858 -0400", hash_original_method = "ECC410A91FC6F30B82508F44C93EA39B", hash_generated_method = "F4F6E0C21FA6F62172787A1726339B1C")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_1233751549 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1233751549 = mAlert.getListView();
        varB4EAC82CA7396A68D541C85D26508E83_1233751549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1233751549;
        // ---------- Original Method ----------
        //return mAlert.getListView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.870 -0400", hash_original_method = "5655E82DFA793B6CD86300EA45F77D5A", hash_generated_method = "DE06D1A99CF7710D2FF4A3875EC195AB")
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mAlert.setTitle(title);
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //super.setTitle(title);
        //mAlert.setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.891 -0400", hash_original_method = "0AAF0E3192DB53DCF899ECF927301A42", hash_generated_method = "401A0C95D03B818F2FD5C0F48514DA52")
    public void setCustomTitle(View customTitleView) {
        mAlert.setCustomTitle(customTitleView);
        addTaint(customTitleView.getTaint());
        // ---------- Original Method ----------
        //mAlert.setCustomTitle(customTitleView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.901 -0400", hash_original_method = "0FDFF41BD74285789F29E89A2F2C112C", hash_generated_method = "DFE20EAF301830597C4553689C7ED5B0")
    public void setMessage(CharSequence message) {
        mAlert.setMessage(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mAlert.setMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.903 -0400", hash_original_method = "588C26275F4E62D9742C7DBB082EE340", hash_generated_method = "92BB9529E33FE238EDD1E736CCCC1BA9")
    public void setView(View view) {
        mAlert.setView(view);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //mAlert.setView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.908 -0400", hash_original_method = "399D46DD3D86F04F15AA9836309BED7E", hash_generated_method = "7132CC9A7DDAA98937D40C431D424567")
    public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight,
            int viewSpacingBottom) {
        mAlert.setView(view, viewSpacingLeft, viewSpacingTop, viewSpacingRight, viewSpacingBottom);
        addTaint(view.getTaint());
        addTaint(viewSpacingLeft);
        addTaint(viewSpacingTop);
        addTaint(viewSpacingRight);
        addTaint(viewSpacingBottom);
        // ---------- Original Method ----------
        //mAlert.setView(view, viewSpacingLeft, viewSpacingTop, viewSpacingRight, viewSpacingBottom);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.924 -0400", hash_original_method = "CFE09EBA63F60A6BEEDA0ECE4DBD2BBE", hash_generated_method = "CC8087F197B860A791414E2743719A9A")
    public void setButton(int whichButton, CharSequence text, Message msg) {
        mAlert.setButton(whichButton, text, null, msg);
        addTaint(whichButton);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, null, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.926 -0400", hash_original_method = "FD92C01692F456341A0525E9D1CD5A83", hash_generated_method = "E0CEE024DC7576AEB4B24A793ACADA2E")
    public void setButton(int whichButton, CharSequence text, OnClickListener listener) {
        mAlert.setButton(whichButton, text, listener, null);
        addTaint(whichButton);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, listener, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.927 -0400", hash_original_method = "2930D21A7389B776726F7D14477E22A5", hash_generated_method = "BC76FB53B508B9E9863D099CA48B69CD")
    @Deprecated
    public void setButton(CharSequence text, Message msg) {
        setButton(BUTTON_POSITIVE, text, msg);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.939 -0400", hash_original_method = "5D138EC6D4B89A4911514A5D190A83FC", hash_generated_method = "39EF83642AEEC6F615FF4EE793E037EC")
    @Deprecated
    public void setButton2(CharSequence text, Message msg) {
        setButton(BUTTON_NEGATIVE, text, msg);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.980 -0400", hash_original_method = "E62AA308196D7D74E77874CB13CC8D38", hash_generated_method = "EAD067B9A0D5323E10ADD3B9C0D8B697")
    @Deprecated
    public void setButton3(CharSequence text, Message msg) {
        setButton(BUTTON_NEUTRAL, text, msg);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:41.982 -0400", hash_original_method = "14303CDDA201782BB4EE72003EBE4B25", hash_generated_method = "21608FE9B96A65C9E363130572949387")
    @Deprecated
    public void setButton(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_POSITIVE, text, listener);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.129 -0400", hash_original_method = "99FBB4BC7546CFCEFDAC9CCE0B0EC52F", hash_generated_method = "65F8A2093B65525353B016963C5779BA")
    @Deprecated
    public void setButton2(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_NEGATIVE, text, listener);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.145 -0400", hash_original_method = "9225C5ACB453A48CCE22F622BD426A12", hash_generated_method = "B1A8586464BEE77ACC61CB4FC4037361")
    @Deprecated
    public void setButton3(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_NEUTRAL, text, listener);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.180 -0400", hash_original_method = "B742B976A105323EE27DB344109D47DF", hash_generated_method = "3B5D69ED7EFFB6F98CF943BC39C8F58C")
    public void setIcon(int resId) {
        mAlert.setIcon(resId);
        addTaint(resId);
        // ---------- Original Method ----------
        //mAlert.setIcon(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.182 -0400", hash_original_method = "58CB6A167EA4E7B84F26608014843ADF", hash_generated_method = "A2F13A37CA62F872F0695FC18AD2339B")
    public void setIcon(Drawable icon) {
        mAlert.setIcon(icon);
        addTaint(icon.getTaint());
        // ---------- Original Method ----------
        //mAlert.setIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.185 -0400", hash_original_method = "1B8133F4D68862D013C951EDD0C82832", hash_generated_method = "2A92FB364C536170FCA2140ECE849A81")
    public void setIconAttribute(int attrId) {
        TypedValue out;
        out = new TypedValue();
        mContext.getTheme().resolveAttribute(attrId, out, true);
        mAlert.setIcon(out.resourceId);
        addTaint(attrId);
        // ---------- Original Method ----------
        //TypedValue out = new TypedValue();
        //mContext.getTheme().resolveAttribute(attrId, out, true);
        //mAlert.setIcon(out.resourceId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.187 -0400", hash_original_method = "21C74C630736CECBD7AD6F509C2AA5D7", hash_generated_method = "809D805EF0EA5017FA5539ADB79B922E")
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        mAlert.setInverseBackgroundForced(forceInverseBackground);
        addTaint(forceInverseBackground);
        // ---------- Original Method ----------
        //mAlert.setInverseBackgroundForced(forceInverseBackground);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.193 -0400", hash_original_method = "84106AE7CC1A6E59D6E45CD48A2A2307", hash_generated_method = "A869CA6151B0EF8E805C5693785CB0CE")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        super.onCreate(savedInstanceState);
        mAlert.installContent();
        addTaint(savedInstanceState.getTaint());
        // ---------- Original Method ----------
        //super.onCreate(savedInstanceState);
        //mAlert.installContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.206 -0400", hash_original_method = "BF8AB256B91D3A887301218CA5494F2D", hash_generated_method = "259996AF41CE5E751113BFEA4FBE1469")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var0860591BEC688168A96E8D7B8A8FC21B_1638769380 = (mAlert.onKeyDown(keyCode, event));
        } //End collapsed parenthetic
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_814768891 = (super.onKeyDown(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394162455 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_394162455;
        // ---------- Original Method ----------
        //if (mAlert.onKeyDown(keyCode, event)) return true;
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.208 -0400", hash_original_method = "A1B1EEF278CFBA53A19AA72D7DAA37CB", hash_generated_method = "55030535AC486FF5D4C73B5F1C41AF71")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varC975F70000285699A9B742C42371726C_510633714 = (mAlert.onKeyUp(keyCode, event));
        } //End collapsed parenthetic
        boolean varEDD771EBF66425AD21882AB08CD0EE48_1530536524 = (super.onKeyUp(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1921290046 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1921290046;
        // ---------- Original Method ----------
        //if (mAlert.onKeyUp(keyCode, event)) return true;
        //return super.onKeyUp(keyCode, event);
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.239 -0400", hash_original_field = "44C29EDB103A2872F519AD0C9A0FDAAA", hash_generated_field = "A137DC00364323BBFDABBB1A415FA549")

        private AlertController.AlertParams P;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.240 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "34E231731C1A787DE0ECD3122BFFE819")

        private int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.256 -0400", hash_original_method = "CB1BA6F353D1C3D1D9DFD93D2E2AA221", hash_generated_method = "791B948FE20DB84EB9AFE7EAB27B0BAA")
        public  Builder(Context context) {
            this(context, resolveDialogTheme(context, 0));
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.258 -0400", hash_original_method = "054A5871E094F7103A36213597CB2400", hash_generated_method = "75925050F4252355E77EE07B943F447E")
        public  Builder(Context context, int theme) {
            P = new AlertController.AlertParams(new ContextThemeWrapper(
                    context, resolveDialogTheme(context, theme)));
            mTheme = theme;
            // ---------- Original Method ----------
            //P = new AlertController.AlertParams(new ContextThemeWrapper(
                    //context, resolveDialogTheme(context, theme)));
            //mTheme = theme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.281 -0400", hash_original_method = "D1A12C2F09D145663A4318954DC7CD00", hash_generated_method = "79F76256A700F51A0662059352AE66BB")
        public Context getContext() {
            Context varB4EAC82CA7396A68D541C85D26508E83_751971734 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_751971734 = P.mContext;
            varB4EAC82CA7396A68D541C85D26508E83_751971734.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_751971734;
            // ---------- Original Method ----------
            //return P.mContext;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.283 -0400", hash_original_method = "E63FAC4DEED51E16AAD703A71B581EEF", hash_generated_method = "149F8496B15B63A5AFDF6B60C15AF2C3")
        public Builder setTitle(int titleId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1499566931 = null; //Variable for return #1
            P.mTitle = P.mContext.getText(titleId);
            varB4EAC82CA7396A68D541C85D26508E83_1499566931 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1499566931.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1499566931;
            // ---------- Original Method ----------
            //P.mTitle = P.mContext.getText(titleId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.311 -0400", hash_original_method = "255D326AF0B389CCA9CBF4AFBC3FE756", hash_generated_method = "5319E987F42A1EFE80E3226F40FF79F7")
        public Builder setTitle(CharSequence title) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1698937275 = null; //Variable for return #1
            P.mTitle = title;
            varB4EAC82CA7396A68D541C85D26508E83_1698937275 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1698937275.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1698937275;
            // ---------- Original Method ----------
            //P.mTitle = title;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.317 -0400", hash_original_method = "0009CCFABCB39131348E93CD167BBCD7", hash_generated_method = "C738AE34775FE75689F3F59CA40A7F6E")
        public Builder setCustomTitle(View customTitleView) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1814801425 = null; //Variable for return #1
            P.mCustomTitleView = customTitleView;
            varB4EAC82CA7396A68D541C85D26508E83_1814801425 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1814801425.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1814801425;
            // ---------- Original Method ----------
            //P.mCustomTitleView = customTitleView;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.325 -0400", hash_original_method = "3B23BD93B750653B90374824F5917D89", hash_generated_method = "ABF78040421315D1717D823698F6F625")
        public Builder setMessage(int messageId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1308169265 = null; //Variable for return #1
            P.mMessage = P.mContext.getText(messageId);
            varB4EAC82CA7396A68D541C85D26508E83_1308169265 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1308169265.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1308169265;
            // ---------- Original Method ----------
            //P.mMessage = P.mContext.getText(messageId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.347 -0400", hash_original_method = "F560859B14C962F22BDF3327E633A8EC", hash_generated_method = "330D02A2E83B3F7B71A0481E79A46290")
        public Builder setMessage(CharSequence message) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1640603270 = null; //Variable for return #1
            P.mMessage = message;
            varB4EAC82CA7396A68D541C85D26508E83_1640603270 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1640603270.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1640603270;
            // ---------- Original Method ----------
            //P.mMessage = message;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.365 -0400", hash_original_method = "EBD38AA9C651B93ADF14B14E5D33C5C9", hash_generated_method = "01ACA27BCF06A9324C3CCA5EAFB96E46")
        public Builder setIcon(int iconId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_931050836 = null; //Variable for return #1
            P.mIconId = iconId;
            varB4EAC82CA7396A68D541C85D26508E83_931050836 = this;
            varB4EAC82CA7396A68D541C85D26508E83_931050836.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_931050836;
            // ---------- Original Method ----------
            //P.mIconId = iconId;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.373 -0400", hash_original_method = "EDCD80F224B2F3CED85A928D84460540", hash_generated_method = "09EE63B620E366A5ABB887760E2B75DC")
        public Builder setIcon(Drawable icon) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_874598039 = null; //Variable for return #1
            P.mIcon = icon;
            varB4EAC82CA7396A68D541C85D26508E83_874598039 = this;
            varB4EAC82CA7396A68D541C85D26508E83_874598039.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_874598039;
            // ---------- Original Method ----------
            //P.mIcon = icon;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.403 -0400", hash_original_method = "3A94A6A2822E55FB53EB2F980E52FF8E", hash_generated_method = "07F7998B2CDDEA0B1EFCD9C8AA824B9D")
        public Builder setIconAttribute(int attrId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1256677672 = null; //Variable for return #1
            TypedValue out;
            out = new TypedValue();
            P.mContext.getTheme().resolveAttribute(attrId, out, true);
            P.mIconId = out.resourceId;
            varB4EAC82CA7396A68D541C85D26508E83_1256677672 = this;
            addTaint(attrId);
            varB4EAC82CA7396A68D541C85D26508E83_1256677672.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1256677672;
            // ---------- Original Method ----------
            //TypedValue out = new TypedValue();
            //P.mContext.getTheme().resolveAttribute(attrId, out, true);
            //P.mIconId = out.resourceId;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.418 -0400", hash_original_method = "1908B917B7F2E57ADC23D5E48F4386F2", hash_generated_method = "8740A5DD161F29692F5FDABCFA33FF91")
        public Builder setPositiveButton(int textId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_115223443 = null; //Variable for return #1
            P.mPositiveButtonText = P.mContext.getText(textId);
            P.mPositiveButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_115223443 = this;
            varB4EAC82CA7396A68D541C85D26508E83_115223443.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_115223443;
            // ---------- Original Method ----------
            //P.mPositiveButtonText = P.mContext.getText(textId);
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.441 -0400", hash_original_method = "1500328C36AB679D672A26C184A5FC31", hash_generated_method = "BAD13B14370BD47320B5A3F4E8468072")
        public Builder setPositiveButton(CharSequence text, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1222821295 = null; //Variable for return #1
            P.mPositiveButtonText = text;
            P.mPositiveButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_1222821295 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1222821295.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1222821295;
            // ---------- Original Method ----------
            //P.mPositiveButtonText = text;
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.446 -0400", hash_original_method = "375537371A0A52AA7AA0B24EAC6A7474", hash_generated_method = "78C19FD3015300DE22406C26A91C361D")
        public Builder setNegativeButton(int textId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2123279689 = null; //Variable for return #1
            P.mNegativeButtonText = P.mContext.getText(textId);
            P.mNegativeButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_2123279689 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2123279689.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2123279689;
            // ---------- Original Method ----------
            //P.mNegativeButtonText = P.mContext.getText(textId);
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.469 -0400", hash_original_method = "50EFB872DEBCC22CFB32B40979906BC8", hash_generated_method = "B5AC2FCB7361FF0DDE5DC5916BD75F7A")
        public Builder setNegativeButton(CharSequence text, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_200323542 = null; //Variable for return #1
            P.mNegativeButtonText = text;
            P.mNegativeButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_200323542 = this;
            varB4EAC82CA7396A68D541C85D26508E83_200323542.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_200323542;
            // ---------- Original Method ----------
            //P.mNegativeButtonText = text;
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.481 -0400", hash_original_method = "0D40DB16A6B6349ABA0D8583C3D4D844", hash_generated_method = "4B915CD8619E47FEB3748B4905275EEB")
        public Builder setNeutralButton(int textId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_252522450 = null; //Variable for return #1
            P.mNeutralButtonText = P.mContext.getText(textId);
            P.mNeutralButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_252522450 = this;
            varB4EAC82CA7396A68D541C85D26508E83_252522450.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_252522450;
            // ---------- Original Method ----------
            //P.mNeutralButtonText = P.mContext.getText(textId);
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.495 -0400", hash_original_method = "4D91C8A8E1E08D55171F5837D3929412", hash_generated_method = "A5CBCF47A9944FA8FF03F35DFC402FF5")
        public Builder setNeutralButton(CharSequence text, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_208534227 = null; //Variable for return #1
            P.mNeutralButtonText = text;
            P.mNeutralButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_208534227 = this;
            varB4EAC82CA7396A68D541C85D26508E83_208534227.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_208534227;
            // ---------- Original Method ----------
            //P.mNeutralButtonText = text;
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.508 -0400", hash_original_method = "D23CAE45E6F3DF826F9F93A9D8E4F37B", hash_generated_method = "D782363B4431A3CF5579FAB98FA11186")
        public Builder setCancelable(boolean cancelable) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1503733562 = null; //Variable for return #1
            P.mCancelable = cancelable;
            varB4EAC82CA7396A68D541C85D26508E83_1503733562 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1503733562.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1503733562;
            // ---------- Original Method ----------
            //P.mCancelable = cancelable;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.531 -0400", hash_original_method = "D6E5909FD450512C75F4E75E987AC229", hash_generated_method = "76CE2D4713C10CF3620965BE9E01C82D")
        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1969938123 = null; //Variable for return #1
            P.mOnCancelListener = onCancelListener;
            varB4EAC82CA7396A68D541C85D26508E83_1969938123 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1969938123.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1969938123;
            // ---------- Original Method ----------
            //P.mOnCancelListener = onCancelListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.533 -0400", hash_original_method = "6E5FB56A362A817B52A235DFACC25DAE", hash_generated_method = "C2B1EE5693D6A7A4420F098AC20DCEE9")
        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_496070593 = null; //Variable for return #1
            P.mOnKeyListener = onKeyListener;
            varB4EAC82CA7396A68D541C85D26508E83_496070593 = this;
            varB4EAC82CA7396A68D541C85D26508E83_496070593.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_496070593;
            // ---------- Original Method ----------
            //P.mOnKeyListener = onKeyListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.556 -0400", hash_original_method = "6D193582453841FD4D6BB305EA061757", hash_generated_method = "06C69810C029E8AC3CFB8983CF1A8ECC")
        public Builder setItems(int itemsId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_188368150 = null; //Variable for return #1
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_188368150 = this;
            varB4EAC82CA7396A68D541C85D26508E83_188368150.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_188368150;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.559 -0400", hash_original_method = "AFD2C4146CF077CBCC62EEF7225AE645", hash_generated_method = "8BECEFB9C86A813CB1AC0ECB42D5DA5A")
        public Builder setItems(CharSequence[] items, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_284840095 = null; //Variable for return #1
            P.mItems = items;
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_284840095 = this;
            varB4EAC82CA7396A68D541C85D26508E83_284840095.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_284840095;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.591 -0400", hash_original_method = "2FCAEDE0B3C9195EDB3158F22A7C0109", hash_generated_method = "356857D78AFC0782C04D71861B473E37")
        public Builder setAdapter(final ListAdapter adapter, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_400162140 = null; //Variable for return #1
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_400162140 = this;
            varB4EAC82CA7396A68D541C85D26508E83_400162140.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_400162140;
            // ---------- Original Method ----------
            //P.mAdapter = adapter;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.605 -0400", hash_original_method = "7DFF15703A2CCBB36AC3557F6AE7E187", hash_generated_method = "4122617E80D1ECE91CB2BE0DAA7BC6F0")
        public Builder setCursor(final Cursor cursor, final OnClickListener listener,
                String labelColumn) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_403767112 = null; //Variable for return #1
            P.mCursor = cursor;
            P.mLabelColumn = labelColumn;
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_403767112 = this;
            varB4EAC82CA7396A68D541C85D26508E83_403767112.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_403767112;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mLabelColumn = labelColumn;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.621 -0400", hash_original_method = "7878252A286B56EBCE9E439D4FCEB298", hash_generated_method = "C9583BAE2A66A7F59CFC991B37D62FB5")
        public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_198081932 = null; //Variable for return #1
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_198081932 = this;
            varB4EAC82CA7396A68D541C85D26508E83_198081932.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_198081932;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnCheckboxClickListener = listener;
            //P.mCheckedItems = checkedItems;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.639 -0400", hash_original_method = "73AB6C3AD26EFF6561BAC3BA481ECFD7", hash_generated_method = "CD9673FEDC1DC737C87363F33E0908E1")
        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_799649591 = null; //Variable for return #1
            P.mItems = items;
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_799649591 = this;
            varB4EAC82CA7396A68D541C85D26508E83_799649591.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_799649591;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnCheckboxClickListener = listener;
            //P.mCheckedItems = checkedItems;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.665 -0400", hash_original_method = "E8A3FFCE7184DC2DAE306B849E312FF3", hash_generated_method = "8BE4685E3A6DC7E65DBA0DC7752F4110")
        public Builder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn, 
                final OnMultiChoiceClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1082135052 = null; //Variable for return #1
            P.mCursor = cursor;
            P.mOnCheckboxClickListener = listener;
            P.mIsCheckedColumn = isCheckedColumn;
            P.mLabelColumn = labelColumn;
            P.mIsMultiChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_1082135052 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1082135052.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1082135052;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mOnCheckboxClickListener = listener;
            //P.mIsCheckedColumn = isCheckedColumn;
            //P.mLabelColumn = labelColumn;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.685 -0400", hash_original_method = "CF9378D7D2AE06BB2F5FFE088D660C44", hash_generated_method = "ACC9035A0B305D676AC70398F0DF6242")
        public Builder setSingleChoiceItems(int itemsId, int checkedItem, 
                final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_920787018 = null; //Variable for return #1
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_920787018 = this;
            varB4EAC82CA7396A68D541C85D26508E83_920787018.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_920787018;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.937 -0400", hash_original_method = "02441459B611830238DF1D8B31546828", hash_generated_method = "99DF94B908C41AEE69E458075852E3D9")
        public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, 
                final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_293254253 = null; //Variable for return #1
            P.mCursor = cursor;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mLabelColumn = labelColumn;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_293254253 = this;
            varB4EAC82CA7396A68D541C85D26508E83_293254253.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_293254253;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mLabelColumn = labelColumn;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.943 -0400", hash_original_method = "7491118E608CEFA972DD3B23E3E7B8C6", hash_generated_method = "C471603CF820E3B80A8CBBA9030D6332")
        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_212246538 = null; //Variable for return #1
            P.mItems = items;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_212246538 = this;
            varB4EAC82CA7396A68D541C85D26508E83_212246538.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_212246538;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.945 -0400", hash_original_method = "06BB43759703ED3EE55275B85ACF4622", hash_generated_method = "3D724A55B5E34A29D6B1B498686FC316")
        public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_549380020 = null; //Variable for return #1
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_549380020 = this;
            varB4EAC82CA7396A68D541C85D26508E83_549380020.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_549380020;
            // ---------- Original Method ----------
            //P.mAdapter = adapter;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.963 -0400", hash_original_method = "2F93F9BAEF2ABE538EE141EAC45DF294", hash_generated_method = "9E3CFB10BACC14982BBE2DB1CCD9F98C")
        public Builder setOnItemSelectedListener(final AdapterView.OnItemSelectedListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1507146080 = null; //Variable for return #1
            P.mOnItemSelectedListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_1507146080 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1507146080.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1507146080;
            // ---------- Original Method ----------
            //P.mOnItemSelectedListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.966 -0400", hash_original_method = "ECE0E9F89C9289601A4B4F810B41F8E6", hash_generated_method = "573CF63F27FC52BD4726A400EEA67E5B")
        public Builder setView(View view) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1194866853 = null; //Variable for return #1
            P.mView = view;
            P.mViewSpacingSpecified = false;
            varB4EAC82CA7396A68D541C85D26508E83_1194866853 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1194866853.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1194866853;
            // ---------- Original Method ----------
            //P.mView = view;
            //P.mViewSpacingSpecified = false;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:42.985 -0400", hash_original_method = "BAFAE1A19AC8AE3D7A23796C6231E632", hash_generated_method = "76FDDBC58414E46D7B9C7746824694AE")
        public Builder setView(View view, int viewSpacingLeft, int viewSpacingTop,
                int viewSpacingRight, int viewSpacingBottom) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1233570379 = null; //Variable for return #1
            P.mView = view;
            P.mViewSpacingSpecified = true;
            P.mViewSpacingLeft = viewSpacingLeft;
            P.mViewSpacingTop = viewSpacingTop;
            P.mViewSpacingRight = viewSpacingRight;
            P.mViewSpacingBottom = viewSpacingBottom;
            varB4EAC82CA7396A68D541C85D26508E83_1233570379 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1233570379.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1233570379;
            // ---------- Original Method ----------
            //P.mView = view;
            //P.mViewSpacingSpecified = true;
            //P.mViewSpacingLeft = viewSpacingLeft;
            //P.mViewSpacingTop = viewSpacingTop;
            //P.mViewSpacingRight = viewSpacingRight;
            //P.mViewSpacingBottom = viewSpacingBottom;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.002 -0400", hash_original_method = "574A516CEEC9B60678E7B4D3D76288FB", hash_generated_method = "F2DF809DCD3A0733838D0D14B1578D47")
        public Builder setInverseBackgroundForced(boolean useInverseBackground) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_836072604 = null; //Variable for return #1
            P.mForceInverseBackground = useInverseBackground;
            varB4EAC82CA7396A68D541C85D26508E83_836072604 = this;
            varB4EAC82CA7396A68D541C85D26508E83_836072604.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_836072604;
            // ---------- Original Method ----------
            //P.mForceInverseBackground = useInverseBackground;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.004 -0400", hash_original_method = "B90B897256AEB065436BDBB1FFCE63CD", hash_generated_method = "46AB2D060F0BA606D546B222F257C804")
        public Builder setRecycleOnMeasureEnabled(boolean enabled) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_379374321 = null; //Variable for return #1
            P.mRecycleOnMeasure = enabled;
            varB4EAC82CA7396A68D541C85D26508E83_379374321 = this;
            varB4EAC82CA7396A68D541C85D26508E83_379374321.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_379374321;
            // ---------- Original Method ----------
            //P.mRecycleOnMeasure = enabled;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.014 -0400", hash_original_method = "24F2ECF5FEA53B0907C34A4AFC4C2134", hash_generated_method = "89778029C44F73BAB5D787BF13B1954E")
        public AlertDialog create() {
            AlertDialog varB4EAC82CA7396A68D541C85D26508E83_1616470596 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_1616470596 = dialog;
            varB4EAC82CA7396A68D541C85D26508E83_1616470596.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1616470596;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.027 -0400", hash_original_method = "9ED881995B2EAB3CB90B8129D2705377", hash_generated_method = "C962385F1FCB7A03B6C6C13CA376660E")
        public AlertDialog show() {
            AlertDialog varB4EAC82CA7396A68D541C85D26508E83_1441771893 = null; //Variable for return #1
            AlertDialog dialog;
            dialog = create();
            dialog.show();
            varB4EAC82CA7396A68D541C85D26508E83_1441771893 = dialog;
            varB4EAC82CA7396A68D541C85D26508E83_1441771893.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1441771893;
            // ---------- Original Method ----------
            //AlertDialog dialog = create();
            //dialog.show();
            //return dialog;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.037 -0400", hash_original_field = "4DFDB4E3D636655F48E1A3F56FC8B460", hash_generated_field = "04F8A3C57B2864E838978D2CD85E8969")

    public static final int THEME_TRADITIONAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.038 -0400", hash_original_field = "1FEAEF575CA7C9C499A21A6D00FF6A81", hash_generated_field = "2784576D25C201833EBEF780244434BE")

    public static final int THEME_HOLO_DARK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.039 -0400", hash_original_field = "89D7D60DEB78F2A37B347CF842C4D168", hash_generated_field = "C3AAAE4F57F49818B346717868538E05")

    public static final int THEME_HOLO_LIGHT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.039 -0400", hash_original_field = "5D9B0E66987E45D6A6FA09D644E80FED", hash_generated_field = "BFF34475E73341D4B4E388DEB93A3440")

    public static final int THEME_DEVICE_DEFAULT_DARK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:43.040 -0400", hash_original_field = "DFB38917D9774209AE404DFC71CA5CE8", hash_generated_field = "E0D4DDCC01DBB4B3153128208E0562F5")

    public static final int THEME_DEVICE_DEFAULT_LIGHT = 5;
}

