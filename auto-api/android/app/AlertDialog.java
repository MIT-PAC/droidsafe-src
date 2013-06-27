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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.318 -0400", hash_original_field = "5117530B5FC21047AC49783CC786404F", hash_generated_field = "167B5CF3490749BA13C3817234C227CF")

    private AlertController mAlert;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.320 -0400", hash_original_method = "3B9AE3A4287FBB2F8914E3FC42E19D75", hash_generated_method = "1583F710FE0C1778C52687E18EADF09B")
    protected  AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.337 -0400", hash_original_method = "C5FA972556687388DAE356FD387A2EE9", hash_generated_method = "CE0D53A489B0326F02AB48EAEA4541F5")
    protected  AlertDialog(Context context, int theme) {
        this(context, theme, true);
        addTaint(context.getTaint());
        addTaint(theme);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.347 -0400", hash_original_method = "6D386DC5BAB559A725B0E80B3B80739F", hash_generated_method = "3F34B817F90BB4AEA127B1A439CCC1C5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.359 -0400", hash_original_method = "EA464E0CF4AA10E0AEDF6B163BEEF729", hash_generated_method = "E49815D05BEC276A8A0718C38E86FAA0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.367 -0400", hash_original_method = "2277A8C194577CB499FB53C1370D61D1", hash_generated_method = "FE2DE3212B4D58AFCC97280A46C5B7F3")
    public Button getButton(int whichButton) {
        Button varB4EAC82CA7396A68D541C85D26508E83_675820091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_675820091 = mAlert.getButton(whichButton);
        addTaint(whichButton);
        varB4EAC82CA7396A68D541C85D26508E83_675820091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_675820091;
        // ---------- Original Method ----------
        //return mAlert.getButton(whichButton);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.396 -0400", hash_original_method = "ECC410A91FC6F30B82508F44C93EA39B", hash_generated_method = "4F2E83FF353C9F5EE0BE96595D2D818B")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_249203960 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_249203960 = mAlert.getListView();
        varB4EAC82CA7396A68D541C85D26508E83_249203960.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_249203960;
        // ---------- Original Method ----------
        //return mAlert.getListView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.398 -0400", hash_original_method = "5655E82DFA793B6CD86300EA45F77D5A", hash_generated_method = "DE06D1A99CF7710D2FF4A3875EC195AB")
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mAlert.setTitle(title);
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //super.setTitle(title);
        //mAlert.setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.418 -0400", hash_original_method = "0AAF0E3192DB53DCF899ECF927301A42", hash_generated_method = "401A0C95D03B818F2FD5C0F48514DA52")
    public void setCustomTitle(View customTitleView) {
        mAlert.setCustomTitle(customTitleView);
        addTaint(customTitleView.getTaint());
        // ---------- Original Method ----------
        //mAlert.setCustomTitle(customTitleView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.430 -0400", hash_original_method = "0FDFF41BD74285789F29E89A2F2C112C", hash_generated_method = "DFE20EAF301830597C4553689C7ED5B0")
    public void setMessage(CharSequence message) {
        mAlert.setMessage(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mAlert.setMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.441 -0400", hash_original_method = "588C26275F4E62D9742C7DBB082EE340", hash_generated_method = "92BB9529E33FE238EDD1E736CCCC1BA9")
    public void setView(View view) {
        mAlert.setView(view);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //mAlert.setView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.454 -0400", hash_original_method = "399D46DD3D86F04F15AA9836309BED7E", hash_generated_method = "7132CC9A7DDAA98937D40C431D424567")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.473 -0400", hash_original_method = "CFE09EBA63F60A6BEEDA0ECE4DBD2BBE", hash_generated_method = "CC8087F197B860A791414E2743719A9A")
    public void setButton(int whichButton, CharSequence text, Message msg) {
        mAlert.setButton(whichButton, text, null, msg);
        addTaint(whichButton);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, null, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.488 -0400", hash_original_method = "FD92C01692F456341A0525E9D1CD5A83", hash_generated_method = "E0CEE024DC7576AEB4B24A793ACADA2E")
    public void setButton(int whichButton, CharSequence text, OnClickListener listener) {
        mAlert.setButton(whichButton, text, listener, null);
        addTaint(whichButton);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, listener, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.506 -0400", hash_original_method = "2930D21A7389B776726F7D14477E22A5", hash_generated_method = "BC76FB53B508B9E9863D099CA48B69CD")
    @Deprecated
    public void setButton(CharSequence text, Message msg) {
        setButton(BUTTON_POSITIVE, text, msg);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.514 -0400", hash_original_method = "5D138EC6D4B89A4911514A5D190A83FC", hash_generated_method = "39EF83642AEEC6F615FF4EE793E037EC")
    @Deprecated
    public void setButton2(CharSequence text, Message msg) {
        setButton(BUTTON_NEGATIVE, text, msg);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.516 -0400", hash_original_method = "E62AA308196D7D74E77874CB13CC8D38", hash_generated_method = "EAD067B9A0D5323E10ADD3B9C0D8B697")
    @Deprecated
    public void setButton3(CharSequence text, Message msg) {
        setButton(BUTTON_NEUTRAL, text, msg);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.539 -0400", hash_original_method = "14303CDDA201782BB4EE72003EBE4B25", hash_generated_method = "21608FE9B96A65C9E363130572949387")
    @Deprecated
    public void setButton(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_POSITIVE, text, listener);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.543 -0400", hash_original_method = "99FBB4BC7546CFCEFDAC9CCE0B0EC52F", hash_generated_method = "65F8A2093B65525353B016963C5779BA")
    @Deprecated
    public void setButton2(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_NEGATIVE, text, listener);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.565 -0400", hash_original_method = "9225C5ACB453A48CCE22F622BD426A12", hash_generated_method = "B1A8586464BEE77ACC61CB4FC4037361")
    @Deprecated
    public void setButton3(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_NEUTRAL, text, listener);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.580 -0400", hash_original_method = "B742B976A105323EE27DB344109D47DF", hash_generated_method = "3B5D69ED7EFFB6F98CF943BC39C8F58C")
    public void setIcon(int resId) {
        mAlert.setIcon(resId);
        addTaint(resId);
        // ---------- Original Method ----------
        //mAlert.setIcon(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.582 -0400", hash_original_method = "58CB6A167EA4E7B84F26608014843ADF", hash_generated_method = "A2F13A37CA62F872F0695FC18AD2339B")
    public void setIcon(Drawable icon) {
        mAlert.setIcon(icon);
        addTaint(icon.getTaint());
        // ---------- Original Method ----------
        //mAlert.setIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.584 -0400", hash_original_method = "1B8133F4D68862D013C951EDD0C82832", hash_generated_method = "2A92FB364C536170FCA2140ECE849A81")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.612 -0400", hash_original_method = "21C74C630736CECBD7AD6F509C2AA5D7", hash_generated_method = "809D805EF0EA5017FA5539ADB79B922E")
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        mAlert.setInverseBackgroundForced(forceInverseBackground);
        addTaint(forceInverseBackground);
        // ---------- Original Method ----------
        //mAlert.setInverseBackgroundForced(forceInverseBackground);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.626 -0400", hash_original_method = "84106AE7CC1A6E59D6E45CD48A2A2307", hash_generated_method = "A869CA6151B0EF8E805C5693785CB0CE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.628 -0400", hash_original_method = "BF8AB256B91D3A887301218CA5494F2D", hash_generated_method = "510B3375163F48EFC8D8DE4A3CED8C91")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var0860591BEC688168A96E8D7B8A8FC21B_51259635 = (mAlert.onKeyDown(keyCode, event));
        } //End collapsed parenthetic
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1161432171 = (super.onKeyDown(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_796841536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_796841536;
        // ---------- Original Method ----------
        //if (mAlert.onKeyDown(keyCode, event)) return true;
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.642 -0400", hash_original_method = "A1B1EEF278CFBA53A19AA72D7DAA37CB", hash_generated_method = "3390604511C96669B2C6C52358F7836B")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varC975F70000285699A9B742C42371726C_615434996 = (mAlert.onKeyUp(keyCode, event));
        } //End collapsed parenthetic
        boolean varEDD771EBF66425AD21882AB08CD0EE48_351484156 = (super.onKeyUp(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1796279299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1796279299;
        // ---------- Original Method ----------
        //if (mAlert.onKeyUp(keyCode, event)) return true;
        //return super.onKeyUp(keyCode, event);
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.643 -0400", hash_original_field = "44C29EDB103A2872F519AD0C9A0FDAAA", hash_generated_field = "A137DC00364323BBFDABBB1A415FA549")

        private AlertController.AlertParams P;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.644 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "34E231731C1A787DE0ECD3122BFFE819")

        private int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.666 -0400", hash_original_method = "CB1BA6F353D1C3D1D9DFD93D2E2AA221", hash_generated_method = "791B948FE20DB84EB9AFE7EAB27B0BAA")
        public  Builder(Context context) {
            this(context, resolveDialogTheme(context, 0));
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.668 -0400", hash_original_method = "054A5871E094F7103A36213597CB2400", hash_generated_method = "75925050F4252355E77EE07B943F447E")
        public  Builder(Context context, int theme) {
            P = new AlertController.AlertParams(new ContextThemeWrapper(
                    context, resolveDialogTheme(context, theme)));
            mTheme = theme;
            // ---------- Original Method ----------
            //P = new AlertController.AlertParams(new ContextThemeWrapper(
                    //context, resolveDialogTheme(context, theme)));
            //mTheme = theme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.691 -0400", hash_original_method = "D1A12C2F09D145663A4318954DC7CD00", hash_generated_method = "EBAEC3782AFDC6117DB54423D1108FFA")
        public Context getContext() {
            Context varB4EAC82CA7396A68D541C85D26508E83_832885324 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_832885324 = P.mContext;
            varB4EAC82CA7396A68D541C85D26508E83_832885324.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_832885324;
            // ---------- Original Method ----------
            //return P.mContext;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.705 -0400", hash_original_method = "E63FAC4DEED51E16AAD703A71B581EEF", hash_generated_method = "6BF943EF62C71BF415163EEA0014DA80")
        public Builder setTitle(int titleId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1800088273 = null; //Variable for return #1
            P.mTitle = P.mContext.getText(titleId);
            varB4EAC82CA7396A68D541C85D26508E83_1800088273 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1800088273.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1800088273;
            // ---------- Original Method ----------
            //P.mTitle = P.mContext.getText(titleId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.721 -0400", hash_original_method = "255D326AF0B389CCA9CBF4AFBC3FE756", hash_generated_method = "67B65CF65B89F2E63979917229948E3A")
        public Builder setTitle(CharSequence title) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1485314940 = null; //Variable for return #1
            P.mTitle = title;
            varB4EAC82CA7396A68D541C85D26508E83_1485314940 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1485314940.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1485314940;
            // ---------- Original Method ----------
            //P.mTitle = title;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.743 -0400", hash_original_method = "0009CCFABCB39131348E93CD167BBCD7", hash_generated_method = "2C4E4983C7BB8BAB1B6279A3ED85B19E")
        public Builder setCustomTitle(View customTitleView) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1075231708 = null; //Variable for return #1
            P.mCustomTitleView = customTitleView;
            varB4EAC82CA7396A68D541C85D26508E83_1075231708 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1075231708.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1075231708;
            // ---------- Original Method ----------
            //P.mCustomTitleView = customTitleView;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.762 -0400", hash_original_method = "3B23BD93B750653B90374824F5917D89", hash_generated_method = "CD41015D61D027C103B68930A92B8D31")
        public Builder setMessage(int messageId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_789275500 = null; //Variable for return #1
            P.mMessage = P.mContext.getText(messageId);
            varB4EAC82CA7396A68D541C85D26508E83_789275500 = this;
            varB4EAC82CA7396A68D541C85D26508E83_789275500.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_789275500;
            // ---------- Original Method ----------
            //P.mMessage = P.mContext.getText(messageId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.777 -0400", hash_original_method = "F560859B14C962F22BDF3327E633A8EC", hash_generated_method = "D6CD03FA7F7BA9D4F6F245A80F903D04")
        public Builder setMessage(CharSequence message) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1767640035 = null; //Variable for return #1
            P.mMessage = message;
            varB4EAC82CA7396A68D541C85D26508E83_1767640035 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1767640035.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1767640035;
            // ---------- Original Method ----------
            //P.mMessage = message;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.789 -0400", hash_original_method = "EBD38AA9C651B93ADF14B14E5D33C5C9", hash_generated_method = "CFFE0EAC486316B11288ABA52C8985C0")
        public Builder setIcon(int iconId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1115093331 = null; //Variable for return #1
            P.mIconId = iconId;
            varB4EAC82CA7396A68D541C85D26508E83_1115093331 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1115093331.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1115093331;
            // ---------- Original Method ----------
            //P.mIconId = iconId;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.810 -0400", hash_original_method = "EDCD80F224B2F3CED85A928D84460540", hash_generated_method = "575A5022C221A056E6BDC080E1EE49E2")
        public Builder setIcon(Drawable icon) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1696953325 = null; //Variable for return #1
            P.mIcon = icon;
            varB4EAC82CA7396A68D541C85D26508E83_1696953325 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1696953325.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1696953325;
            // ---------- Original Method ----------
            //P.mIcon = icon;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.832 -0400", hash_original_method = "3A94A6A2822E55FB53EB2F980E52FF8E", hash_generated_method = "FF192CD43420DB415C7D55ABCA0D4E27")
        public Builder setIconAttribute(int attrId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1936848976 = null; //Variable for return #1
            TypedValue out;
            out = new TypedValue();
            P.mContext.getTheme().resolveAttribute(attrId, out, true);
            P.mIconId = out.resourceId;
            varB4EAC82CA7396A68D541C85D26508E83_1936848976 = this;
            addTaint(attrId);
            varB4EAC82CA7396A68D541C85D26508E83_1936848976.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1936848976;
            // ---------- Original Method ----------
            //TypedValue out = new TypedValue();
            //P.mContext.getTheme().resolveAttribute(attrId, out, true);
            //P.mIconId = out.resourceId;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.835 -0400", hash_original_method = "1908B917B7F2E57ADC23D5E48F4386F2", hash_generated_method = "2B7C349BBC85C8D5DA35EE75545F7086")
        public Builder setPositiveButton(int textId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_682405230 = null; //Variable for return #1
            P.mPositiveButtonText = P.mContext.getText(textId);
            P.mPositiveButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_682405230 = this;
            varB4EAC82CA7396A68D541C85D26508E83_682405230.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_682405230;
            // ---------- Original Method ----------
            //P.mPositiveButtonText = P.mContext.getText(textId);
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:39.856 -0400", hash_original_method = "1500328C36AB679D672A26C184A5FC31", hash_generated_method = "58DB437ADD428E7D26A54279932CF53B")
        public Builder setPositiveButton(CharSequence text, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1736673886 = null; //Variable for return #1
            P.mPositiveButtonText = text;
            P.mPositiveButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_1736673886 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1736673886.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1736673886;
            // ---------- Original Method ----------
            //P.mPositiveButtonText = text;
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.054 -0400", hash_original_method = "375537371A0A52AA7AA0B24EAC6A7474", hash_generated_method = "6B68941377BC00F34DDA3B5B655CF0DB")
        public Builder setNegativeButton(int textId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_872926940 = null; //Variable for return #1
            P.mNegativeButtonText = P.mContext.getText(textId);
            P.mNegativeButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_872926940 = this;
            varB4EAC82CA7396A68D541C85D26508E83_872926940.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_872926940;
            // ---------- Original Method ----------
            //P.mNegativeButtonText = P.mContext.getText(textId);
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.073 -0400", hash_original_method = "50EFB872DEBCC22CFB32B40979906BC8", hash_generated_method = "49CA7F797D5C18D7780CFC9ED5F5E7C1")
        public Builder setNegativeButton(CharSequence text, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1004814119 = null; //Variable for return #1
            P.mNegativeButtonText = text;
            P.mNegativeButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_1004814119 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1004814119.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1004814119;
            // ---------- Original Method ----------
            //P.mNegativeButtonText = text;
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.092 -0400", hash_original_method = "0D40DB16A6B6349ABA0D8583C3D4D844", hash_generated_method = "C9DC1845EE3C0FABEC5C9BC973A2C514")
        public Builder setNeutralButton(int textId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_765868905 = null; //Variable for return #1
            P.mNeutralButtonText = P.mContext.getText(textId);
            P.mNeutralButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_765868905 = this;
            varB4EAC82CA7396A68D541C85D26508E83_765868905.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_765868905;
            // ---------- Original Method ----------
            //P.mNeutralButtonText = P.mContext.getText(textId);
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.095 -0400", hash_original_method = "4D91C8A8E1E08D55171F5837D3929412", hash_generated_method = "86E687FDC648F43D8573B3D9B397B31F")
        public Builder setNeutralButton(CharSequence text, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_664372444 = null; //Variable for return #1
            P.mNeutralButtonText = text;
            P.mNeutralButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_664372444 = this;
            varB4EAC82CA7396A68D541C85D26508E83_664372444.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_664372444;
            // ---------- Original Method ----------
            //P.mNeutralButtonText = text;
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.147 -0400", hash_original_method = "D23CAE45E6F3DF826F9F93A9D8E4F37B", hash_generated_method = "E26080579D966A99300EAB6337F86FA5")
        public Builder setCancelable(boolean cancelable) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_372961847 = null; //Variable for return #1
            P.mCancelable = cancelable;
            varB4EAC82CA7396A68D541C85D26508E83_372961847 = this;
            varB4EAC82CA7396A68D541C85D26508E83_372961847.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_372961847;
            // ---------- Original Method ----------
            //P.mCancelable = cancelable;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.159 -0400", hash_original_method = "D6E5909FD450512C75F4E75E987AC229", hash_generated_method = "FF669B2E619C43DD6227BB51E1091A2A")
        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_270199150 = null; //Variable for return #1
            P.mOnCancelListener = onCancelListener;
            varB4EAC82CA7396A68D541C85D26508E83_270199150 = this;
            varB4EAC82CA7396A68D541C85D26508E83_270199150.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_270199150;
            // ---------- Original Method ----------
            //P.mOnCancelListener = onCancelListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.166 -0400", hash_original_method = "6E5FB56A362A817B52A235DFACC25DAE", hash_generated_method = "8724C4B51557A7F6151737D361030FA4")
        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_200286702 = null; //Variable for return #1
            P.mOnKeyListener = onKeyListener;
            varB4EAC82CA7396A68D541C85D26508E83_200286702 = this;
            varB4EAC82CA7396A68D541C85D26508E83_200286702.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_200286702;
            // ---------- Original Method ----------
            //P.mOnKeyListener = onKeyListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.205 -0400", hash_original_method = "6D193582453841FD4D6BB305EA061757", hash_generated_method = "47CDE45C46C10E4514BC804B71DA6DB6")
        public Builder setItems(int itemsId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_490028886 = null; //Variable for return #1
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_490028886 = this;
            varB4EAC82CA7396A68D541C85D26508E83_490028886.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_490028886;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.220 -0400", hash_original_method = "AFD2C4146CF077CBCC62EEF7225AE645", hash_generated_method = "AE9B428C02C22C1F8A3D389B44407C30")
        public Builder setItems(CharSequence[] items, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_306771491 = null; //Variable for return #1
            P.mItems = items;
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_306771491 = this;
            varB4EAC82CA7396A68D541C85D26508E83_306771491.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_306771491;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.239 -0400", hash_original_method = "2FCAEDE0B3C9195EDB3158F22A7C0109", hash_generated_method = "99412054584AFB31E403F7D75D4BECF6")
        public Builder setAdapter(final ListAdapter adapter, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1946284092 = null; //Variable for return #1
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_1946284092 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1946284092.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1946284092;
            // ---------- Original Method ----------
            //P.mAdapter = adapter;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.258 -0400", hash_original_method = "7DFF15703A2CCBB36AC3557F6AE7E187", hash_generated_method = "4A46F448ED5C7E16B63760EE9FC6D42A")
        public Builder setCursor(final Cursor cursor, final OnClickListener listener,
                String labelColumn) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_866011710 = null; //Variable for return #1
            P.mCursor = cursor;
            P.mLabelColumn = labelColumn;
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_866011710 = this;
            varB4EAC82CA7396A68D541C85D26508E83_866011710.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_866011710;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mLabelColumn = labelColumn;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.288 -0400", hash_original_method = "7878252A286B56EBCE9E439D4FCEB298", hash_generated_method = "FA51A731082AD8D41702F6D5600145E0")
        public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_359867214 = null; //Variable for return #1
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_359867214 = this;
            varB4EAC82CA7396A68D541C85D26508E83_359867214.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_359867214;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnCheckboxClickListener = listener;
            //P.mCheckedItems = checkedItems;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.309 -0400", hash_original_method = "73AB6C3AD26EFF6561BAC3BA481ECFD7", hash_generated_method = "CFE9B2EA939D8A4187D04F5393ABE21D")
        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1547770995 = null; //Variable for return #1
            P.mItems = items;
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_1547770995 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1547770995.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1547770995;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnCheckboxClickListener = listener;
            //P.mCheckedItems = checkedItems;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.322 -0400", hash_original_method = "E8A3FFCE7184DC2DAE306B849E312FF3", hash_generated_method = "9549949F1B9355EF2F6DF929B96EAD36")
        public Builder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn, 
                final OnMultiChoiceClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1440356561 = null; //Variable for return #1
            P.mCursor = cursor;
            P.mOnCheckboxClickListener = listener;
            P.mIsCheckedColumn = isCheckedColumn;
            P.mLabelColumn = labelColumn;
            P.mIsMultiChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_1440356561 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1440356561.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1440356561;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mOnCheckboxClickListener = listener;
            //P.mIsCheckedColumn = isCheckedColumn;
            //P.mLabelColumn = labelColumn;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.365 -0400", hash_original_method = "CF9378D7D2AE06BB2F5FFE088D660C44", hash_generated_method = "69AEACB23CF3BB6C91B7C17F0B08134A")
        public Builder setSingleChoiceItems(int itemsId, int checkedItem, 
                final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_631153740 = null; //Variable for return #1
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_631153740 = this;
            varB4EAC82CA7396A68D541C85D26508E83_631153740.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_631153740;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.368 -0400", hash_original_method = "02441459B611830238DF1D8B31546828", hash_generated_method = "2210E6E38B46F8758B18413DB467BAE9")
        public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, 
                final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_780322967 = null; //Variable for return #1
            P.mCursor = cursor;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mLabelColumn = labelColumn;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_780322967 = this;
            varB4EAC82CA7396A68D541C85D26508E83_780322967.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_780322967;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mLabelColumn = labelColumn;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.398 -0400", hash_original_method = "7491118E608CEFA972DD3B23E3E7B8C6", hash_generated_method = "E89C0BD617EFC331BC1237429C1E0420")
        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_520405948 = null; //Variable for return #1
            P.mItems = items;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_520405948 = this;
            varB4EAC82CA7396A68D541C85D26508E83_520405948.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_520405948;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.414 -0400", hash_original_method = "06BB43759703ED3EE55275B85ACF4622", hash_generated_method = "05FE88F0C1C6B0D218D425FF17AEEB81")
        public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_468916836 = null; //Variable for return #1
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_468916836 = this;
            varB4EAC82CA7396A68D541C85D26508E83_468916836.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_468916836;
            // ---------- Original Method ----------
            //P.mAdapter = adapter;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.435 -0400", hash_original_method = "2F93F9BAEF2ABE538EE141EAC45DF294", hash_generated_method = "B70D131D54502A040AE5EDD5AB39A2B3")
        public Builder setOnItemSelectedListener(final AdapterView.OnItemSelectedListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_703930427 = null; //Variable for return #1
            P.mOnItemSelectedListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_703930427 = this;
            varB4EAC82CA7396A68D541C85D26508E83_703930427.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_703930427;
            // ---------- Original Method ----------
            //P.mOnItemSelectedListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.452 -0400", hash_original_method = "ECE0E9F89C9289601A4B4F810B41F8E6", hash_generated_method = "FD5F0B41D122557150FF773B7EACBBFE")
        public Builder setView(View view) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_173784868 = null; //Variable for return #1
            P.mView = view;
            P.mViewSpacingSpecified = false;
            varB4EAC82CA7396A68D541C85D26508E83_173784868 = this;
            varB4EAC82CA7396A68D541C85D26508E83_173784868.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_173784868;
            // ---------- Original Method ----------
            //P.mView = view;
            //P.mViewSpacingSpecified = false;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.487 -0400", hash_original_method = "BAFAE1A19AC8AE3D7A23796C6231E632", hash_generated_method = "038464AFB1198BD9721FF5A3080040BE")
        public Builder setView(View view, int viewSpacingLeft, int viewSpacingTop,
                int viewSpacingRight, int viewSpacingBottom) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1388095248 = null; //Variable for return #1
            P.mView = view;
            P.mViewSpacingSpecified = true;
            P.mViewSpacingLeft = viewSpacingLeft;
            P.mViewSpacingTop = viewSpacingTop;
            P.mViewSpacingRight = viewSpacingRight;
            P.mViewSpacingBottom = viewSpacingBottom;
            varB4EAC82CA7396A68D541C85D26508E83_1388095248 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1388095248.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1388095248;
            // ---------- Original Method ----------
            //P.mView = view;
            //P.mViewSpacingSpecified = true;
            //P.mViewSpacingLeft = viewSpacingLeft;
            //P.mViewSpacingTop = viewSpacingTop;
            //P.mViewSpacingRight = viewSpacingRight;
            //P.mViewSpacingBottom = viewSpacingBottom;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.498 -0400", hash_original_method = "574A516CEEC9B60678E7B4D3D76288FB", hash_generated_method = "C91398228C0C0DE247D1D8BE5671F3FC")
        public Builder setInverseBackgroundForced(boolean useInverseBackground) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2104852530 = null; //Variable for return #1
            P.mForceInverseBackground = useInverseBackground;
            varB4EAC82CA7396A68D541C85D26508E83_2104852530 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2104852530.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2104852530;
            // ---------- Original Method ----------
            //P.mForceInverseBackground = useInverseBackground;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.516 -0400", hash_original_method = "B90B897256AEB065436BDBB1FFCE63CD", hash_generated_method = "E25783E2CF974E9F3E5A0D2E378E8EDB")
        public Builder setRecycleOnMeasureEnabled(boolean enabled) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1498971793 = null; //Variable for return #1
            P.mRecycleOnMeasure = enabled;
            varB4EAC82CA7396A68D541C85D26508E83_1498971793 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1498971793.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1498971793;
            // ---------- Original Method ----------
            //P.mRecycleOnMeasure = enabled;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.528 -0400", hash_original_method = "24F2ECF5FEA53B0907C34A4AFC4C2134", hash_generated_method = "1BC1D4ACFCB7954CB1A6C4CC0B2E4023")
        public AlertDialog create() {
            AlertDialog varB4EAC82CA7396A68D541C85D26508E83_2023620687 = null; //Variable for return #1
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
            varB4EAC82CA7396A68D541C85D26508E83_2023620687 = dialog;
            varB4EAC82CA7396A68D541C85D26508E83_2023620687.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2023620687;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.549 -0400", hash_original_method = "9ED881995B2EAB3CB90B8129D2705377", hash_generated_method = "CA0FFC19B91A8CBC176E5E32A9E0634D")
        public AlertDialog show() {
            AlertDialog varB4EAC82CA7396A68D541C85D26508E83_371896662 = null; //Variable for return #1
            AlertDialog dialog;
            dialog = create();
            dialog.show();
            varB4EAC82CA7396A68D541C85D26508E83_371896662 = dialog;
            varB4EAC82CA7396A68D541C85D26508E83_371896662.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_371896662;
            // ---------- Original Method ----------
            //AlertDialog dialog = create();
            //dialog.show();
            //return dialog;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.550 -0400", hash_original_field = "4DFDB4E3D636655F48E1A3F56FC8B460", hash_generated_field = "04F8A3C57B2864E838978D2CD85E8969")

    public static final int THEME_TRADITIONAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.550 -0400", hash_original_field = "1FEAEF575CA7C9C499A21A6D00FF6A81", hash_generated_field = "2784576D25C201833EBEF780244434BE")

    public static final int THEME_HOLO_DARK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.551 -0400", hash_original_field = "89D7D60DEB78F2A37B347CF842C4D168", hash_generated_field = "C3AAAE4F57F49818B346717868538E05")

    public static final int THEME_HOLO_LIGHT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.552 -0400", hash_original_field = "5D9B0E66987E45D6A6FA09D644E80FED", hash_generated_field = "BFF34475E73341D4B4E388DEB93A3440")

    public static final int THEME_DEVICE_DEFAULT_DARK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:40.572 -0400", hash_original_field = "DFB38917D9774209AE404DFC71CA5CE8", hash_generated_field = "E0D4DDCC01DBB4B3153128208E0562F5")

    public static final int THEME_DEVICE_DEFAULT_LIGHT = 5;
}

