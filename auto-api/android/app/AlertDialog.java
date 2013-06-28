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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.105 -0400", hash_original_field = "5117530B5FC21047AC49783CC786404F", hash_generated_field = "167B5CF3490749BA13C3817234C227CF")

    private AlertController mAlert;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.106 -0400", hash_original_method = "3B9AE3A4287FBB2F8914E3FC42E19D75", hash_generated_method = "1583F710FE0C1778C52687E18EADF09B")
    protected  AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.106 -0400", hash_original_method = "C5FA972556687388DAE356FD387A2EE9", hash_generated_method = "CE0D53A489B0326F02AB48EAEA4541F5")
    protected  AlertDialog(Context context, int theme) {
        this(context, theme, true);
        addTaint(context.getTaint());
        addTaint(theme);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.107 -0400", hash_original_method = "6D386DC5BAB559A725B0E80B3B80739F", hash_generated_method = "3F34B817F90BB4AEA127B1A439CCC1C5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.108 -0400", hash_original_method = "EA464E0CF4AA10E0AEDF6B163BEEF729", hash_generated_method = "E49815D05BEC276A8A0718C38E86FAA0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.110 -0400", hash_original_method = "2277A8C194577CB499FB53C1370D61D1", hash_generated_method = "0D6DA74593395E40E51F1DD7D38CA3D2")
    public Button getButton(int whichButton) {
        Button varB4EAC82CA7396A68D541C85D26508E83_621540935 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_621540935 = mAlert.getButton(whichButton);
        addTaint(whichButton);
        varB4EAC82CA7396A68D541C85D26508E83_621540935.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_621540935;
        // ---------- Original Method ----------
        //return mAlert.getButton(whichButton);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.111 -0400", hash_original_method = "ECC410A91FC6F30B82508F44C93EA39B", hash_generated_method = "4CED19AE9CE2EF6DBB20DDD0F76B6059")
    public ListView getListView() {
        ListView varB4EAC82CA7396A68D541C85D26508E83_1338091066 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1338091066 = mAlert.getListView();
        varB4EAC82CA7396A68D541C85D26508E83_1338091066.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1338091066;
        // ---------- Original Method ----------
        //return mAlert.getListView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.111 -0400", hash_original_method = "5655E82DFA793B6CD86300EA45F77D5A", hash_generated_method = "DE06D1A99CF7710D2FF4A3875EC195AB")
    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        mAlert.setTitle(title);
        addTaint(title.getTaint());
        // ---------- Original Method ----------
        //super.setTitle(title);
        //mAlert.setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.112 -0400", hash_original_method = "0AAF0E3192DB53DCF899ECF927301A42", hash_generated_method = "401A0C95D03B818F2FD5C0F48514DA52")
    public void setCustomTitle(View customTitleView) {
        mAlert.setCustomTitle(customTitleView);
        addTaint(customTitleView.getTaint());
        // ---------- Original Method ----------
        //mAlert.setCustomTitle(customTitleView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.113 -0400", hash_original_method = "0FDFF41BD74285789F29E89A2F2C112C", hash_generated_method = "DFE20EAF301830597C4553689C7ED5B0")
    public void setMessage(CharSequence message) {
        mAlert.setMessage(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mAlert.setMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.113 -0400", hash_original_method = "588C26275F4E62D9742C7DBB082EE340", hash_generated_method = "92BB9529E33FE238EDD1E736CCCC1BA9")
    public void setView(View view) {
        mAlert.setView(view);
        addTaint(view.getTaint());
        // ---------- Original Method ----------
        //mAlert.setView(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.114 -0400", hash_original_method = "399D46DD3D86F04F15AA9836309BED7E", hash_generated_method = "7132CC9A7DDAA98937D40C431D424567")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.114 -0400", hash_original_method = "CFE09EBA63F60A6BEEDA0ECE4DBD2BBE", hash_generated_method = "CC8087F197B860A791414E2743719A9A")
    public void setButton(int whichButton, CharSequence text, Message msg) {
        mAlert.setButton(whichButton, text, null, msg);
        addTaint(whichButton);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, null, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.115 -0400", hash_original_method = "FD92C01692F456341A0525E9D1CD5A83", hash_generated_method = "E0CEE024DC7576AEB4B24A793ACADA2E")
    public void setButton(int whichButton, CharSequence text, OnClickListener listener) {
        mAlert.setButton(whichButton, text, listener, null);
        addTaint(whichButton);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, listener, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.116 -0400", hash_original_method = "2930D21A7389B776726F7D14477E22A5", hash_generated_method = "BC76FB53B508B9E9863D099CA48B69CD")
    @Deprecated
    public void setButton(CharSequence text, Message msg) {
        setButton(BUTTON_POSITIVE, text, msg);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.116 -0400", hash_original_method = "5D138EC6D4B89A4911514A5D190A83FC", hash_generated_method = "39EF83642AEEC6F615FF4EE793E037EC")
    @Deprecated
    public void setButton2(CharSequence text, Message msg) {
        setButton(BUTTON_NEGATIVE, text, msg);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.117 -0400", hash_original_method = "E62AA308196D7D74E77874CB13CC8D38", hash_generated_method = "EAD067B9A0D5323E10ADD3B9C0D8B697")
    @Deprecated
    public void setButton3(CharSequence text, Message msg) {
        setButton(BUTTON_NEUTRAL, text, msg);
        addTaint(text.getTaint());
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.118 -0400", hash_original_method = "14303CDDA201782BB4EE72003EBE4B25", hash_generated_method = "21608FE9B96A65C9E363130572949387")
    @Deprecated
    public void setButton(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_POSITIVE, text, listener);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.119 -0400", hash_original_method = "99FBB4BC7546CFCEFDAC9CCE0B0EC52F", hash_generated_method = "65F8A2093B65525353B016963C5779BA")
    @Deprecated
    public void setButton2(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_NEGATIVE, text, listener);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.121 -0400", hash_original_method = "9225C5ACB453A48CCE22F622BD426A12", hash_generated_method = "B1A8586464BEE77ACC61CB4FC4037361")
    @Deprecated
    public void setButton3(CharSequence text, final OnClickListener listener) {
        setButton(BUTTON_NEUTRAL, text, listener);
        addTaint(text.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.122 -0400", hash_original_method = "B742B976A105323EE27DB344109D47DF", hash_generated_method = "3B5D69ED7EFFB6F98CF943BC39C8F58C")
    public void setIcon(int resId) {
        mAlert.setIcon(resId);
        addTaint(resId);
        // ---------- Original Method ----------
        //mAlert.setIcon(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.123 -0400", hash_original_method = "58CB6A167EA4E7B84F26608014843ADF", hash_generated_method = "A2F13A37CA62F872F0695FC18AD2339B")
    public void setIcon(Drawable icon) {
        mAlert.setIcon(icon);
        addTaint(icon.getTaint());
        // ---------- Original Method ----------
        //mAlert.setIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.124 -0400", hash_original_method = "1B8133F4D68862D013C951EDD0C82832", hash_generated_method = "E58A26E1B0C530AEDB2AAD4567349D8E")
    public void setIconAttribute(int attrId) {
        TypedValue out = new TypedValue();
        mContext.getTheme().resolveAttribute(attrId, out, true);
        mAlert.setIcon(out.resourceId);
        addTaint(attrId);
        // ---------- Original Method ----------
        //TypedValue out = new TypedValue();
        //mContext.getTheme().resolveAttribute(attrId, out, true);
        //mAlert.setIcon(out.resourceId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.124 -0400", hash_original_method = "21C74C630736CECBD7AD6F509C2AA5D7", hash_generated_method = "809D805EF0EA5017FA5539ADB79B922E")
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        mAlert.setInverseBackgroundForced(forceInverseBackground);
        addTaint(forceInverseBackground);
        // ---------- Original Method ----------
        //mAlert.setInverseBackgroundForced(forceInverseBackground);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.125 -0400", hash_original_method = "84106AE7CC1A6E59D6E45CD48A2A2307", hash_generated_method = "A869CA6151B0EF8E805C5693785CB0CE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.126 -0400", hash_original_method = "BF8AB256B91D3A887301218CA5494F2D", hash_generated_method = "4974E99F8C16796B894C17779260C6A8")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean var0860591BEC688168A96E8D7B8A8FC21B_1539976935 = (mAlert.onKeyDown(keyCode, event));
        } //End collapsed parenthetic
        boolean var8C6E6C19273FC56B5C56CC7DEF63ED7B_1980090399 = (super.onKeyDown(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942877204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942877204;
        // ---------- Original Method ----------
        //if (mAlert.onKeyDown(keyCode, event)) return true;
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.126 -0400", hash_original_method = "A1B1EEF278CFBA53A19AA72D7DAA37CB", hash_generated_method = "700569865A55B38CA8E28B19D8936DE8")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            boolean varC975F70000285699A9B742C42371726C_301993917 = (mAlert.onKeyUp(keyCode, event));
        } //End collapsed parenthetic
        boolean varEDD771EBF66425AD21882AB08CD0EE48_824455426 = (super.onKeyUp(keyCode, event));
        addTaint(keyCode);
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922303344 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_922303344;
        // ---------- Original Method ----------
        //if (mAlert.onKeyUp(keyCode, event)) return true;
        //return super.onKeyUp(keyCode, event);
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.127 -0400", hash_original_field = "44C29EDB103A2872F519AD0C9A0FDAAA", hash_generated_field = "A137DC00364323BBFDABBB1A415FA549")

        private AlertController.AlertParams P;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.127 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "34E231731C1A787DE0ECD3122BFFE819")

        private int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.128 -0400", hash_original_method = "CB1BA6F353D1C3D1D9DFD93D2E2AA221", hash_generated_method = "791B948FE20DB84EB9AFE7EAB27B0BAA")
        public  Builder(Context context) {
            this(context, resolveDialogTheme(context, 0));
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.129 -0400", hash_original_method = "054A5871E094F7103A36213597CB2400", hash_generated_method = "75925050F4252355E77EE07B943F447E")
        public  Builder(Context context, int theme) {
            P = new AlertController.AlertParams(new ContextThemeWrapper(
                    context, resolveDialogTheme(context, theme)));
            mTheme = theme;
            // ---------- Original Method ----------
            //P = new AlertController.AlertParams(new ContextThemeWrapper(
                    //context, resolveDialogTheme(context, theme)));
            //mTheme = theme;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.132 -0400", hash_original_method = "D1A12C2F09D145663A4318954DC7CD00", hash_generated_method = "1062951FCBA1D8886A1F49A60B6BAE2D")
        public Context getContext() {
            Context varB4EAC82CA7396A68D541C85D26508E83_850213284 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_850213284 = P.mContext;
            varB4EAC82CA7396A68D541C85D26508E83_850213284.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_850213284;
            // ---------- Original Method ----------
            //return P.mContext;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.134 -0400", hash_original_method = "E63FAC4DEED51E16AAD703A71B581EEF", hash_generated_method = "1A797C04F181024ABD8AB44855F6E814")
        public Builder setTitle(int titleId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_670987992 = null; //Variable for return #1
            P.mTitle = P.mContext.getText(titleId);
            varB4EAC82CA7396A68D541C85D26508E83_670987992 = this;
            varB4EAC82CA7396A68D541C85D26508E83_670987992.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_670987992;
            // ---------- Original Method ----------
            //P.mTitle = P.mContext.getText(titleId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.136 -0400", hash_original_method = "255D326AF0B389CCA9CBF4AFBC3FE756", hash_generated_method = "3C337CF6CF5041BF28F1DBA38F395954")
        public Builder setTitle(CharSequence title) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1127320860 = null; //Variable for return #1
            P.mTitle = title;
            varB4EAC82CA7396A68D541C85D26508E83_1127320860 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1127320860.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1127320860;
            // ---------- Original Method ----------
            //P.mTitle = title;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.137 -0400", hash_original_method = "0009CCFABCB39131348E93CD167BBCD7", hash_generated_method = "E3607112CCBC762A15E5378F94FAD3FB")
        public Builder setCustomTitle(View customTitleView) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_481447098 = null; //Variable for return #1
            P.mCustomTitleView = customTitleView;
            varB4EAC82CA7396A68D541C85D26508E83_481447098 = this;
            varB4EAC82CA7396A68D541C85D26508E83_481447098.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_481447098;
            // ---------- Original Method ----------
            //P.mCustomTitleView = customTitleView;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.140 -0400", hash_original_method = "3B23BD93B750653B90374824F5917D89", hash_generated_method = "C9071B9685D5E866E0509C6867C46F96")
        public Builder setMessage(int messageId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1405964991 = null; //Variable for return #1
            P.mMessage = P.mContext.getText(messageId);
            varB4EAC82CA7396A68D541C85D26508E83_1405964991 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1405964991.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1405964991;
            // ---------- Original Method ----------
            //P.mMessage = P.mContext.getText(messageId);
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.143 -0400", hash_original_method = "F560859B14C962F22BDF3327E633A8EC", hash_generated_method = "0123107DB7ED682D7EB13C23E2B9E1B3")
        public Builder setMessage(CharSequence message) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_219578305 = null; //Variable for return #1
            P.mMessage = message;
            varB4EAC82CA7396A68D541C85D26508E83_219578305 = this;
            varB4EAC82CA7396A68D541C85D26508E83_219578305.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_219578305;
            // ---------- Original Method ----------
            //P.mMessage = message;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.144 -0400", hash_original_method = "EBD38AA9C651B93ADF14B14E5D33C5C9", hash_generated_method = "21F2F91A9B581CB5D3A37C55690A45DC")
        public Builder setIcon(int iconId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_83829625 = null; //Variable for return #1
            P.mIconId = iconId;
            varB4EAC82CA7396A68D541C85D26508E83_83829625 = this;
            varB4EAC82CA7396A68D541C85D26508E83_83829625.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_83829625;
            // ---------- Original Method ----------
            //P.mIconId = iconId;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.146 -0400", hash_original_method = "EDCD80F224B2F3CED85A928D84460540", hash_generated_method = "17F9C7CEF58487A846A41624777681CC")
        public Builder setIcon(Drawable icon) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2130016178 = null; //Variable for return #1
            P.mIcon = icon;
            varB4EAC82CA7396A68D541C85D26508E83_2130016178 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2130016178.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2130016178;
            // ---------- Original Method ----------
            //P.mIcon = icon;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.148 -0400", hash_original_method = "3A94A6A2822E55FB53EB2F980E52FF8E", hash_generated_method = "339CD66C570A85CB1603D6E095B91199")
        public Builder setIconAttribute(int attrId) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_446185064 = null; //Variable for return #1
            TypedValue out = new TypedValue();
            P.mContext.getTheme().resolveAttribute(attrId, out, true);
            P.mIconId = out.resourceId;
            varB4EAC82CA7396A68D541C85D26508E83_446185064 = this;
            addTaint(attrId);
            varB4EAC82CA7396A68D541C85D26508E83_446185064.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_446185064;
            // ---------- Original Method ----------
            //TypedValue out = new TypedValue();
            //P.mContext.getTheme().resolveAttribute(attrId, out, true);
            //P.mIconId = out.resourceId;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.150 -0400", hash_original_method = "1908B917B7F2E57ADC23D5E48F4386F2", hash_generated_method = "F2A33FBB9E118FFBCB9C6057AD6765B9")
        public Builder setPositiveButton(int textId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_611086097 = null; //Variable for return #1
            P.mPositiveButtonText = P.mContext.getText(textId);
            P.mPositiveButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_611086097 = this;
            varB4EAC82CA7396A68D541C85D26508E83_611086097.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_611086097;
            // ---------- Original Method ----------
            //P.mPositiveButtonText = P.mContext.getText(textId);
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.153 -0400", hash_original_method = "1500328C36AB679D672A26C184A5FC31", hash_generated_method = "7F8447EAE30711794CD11716EBECAB62")
        public Builder setPositiveButton(CharSequence text, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_456191245 = null; //Variable for return #1
            P.mPositiveButtonText = text;
            P.mPositiveButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_456191245 = this;
            varB4EAC82CA7396A68D541C85D26508E83_456191245.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_456191245;
            // ---------- Original Method ----------
            //P.mPositiveButtonText = text;
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.154 -0400", hash_original_method = "375537371A0A52AA7AA0B24EAC6A7474", hash_generated_method = "461EF5FC5F788FA0A6BC99F3D78FAFE3")
        public Builder setNegativeButton(int textId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1899584364 = null; //Variable for return #1
            P.mNegativeButtonText = P.mContext.getText(textId);
            P.mNegativeButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_1899584364 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1899584364.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1899584364;
            // ---------- Original Method ----------
            //P.mNegativeButtonText = P.mContext.getText(textId);
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.155 -0400", hash_original_method = "50EFB872DEBCC22CFB32B40979906BC8", hash_generated_method = "81F27C21C6BA085BF406FE1D81955535")
        public Builder setNegativeButton(CharSequence text, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1590493049 = null; //Variable for return #1
            P.mNegativeButtonText = text;
            P.mNegativeButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_1590493049 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1590493049.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1590493049;
            // ---------- Original Method ----------
            //P.mNegativeButtonText = text;
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.157 -0400", hash_original_method = "0D40DB16A6B6349ABA0D8583C3D4D844", hash_generated_method = "2238FA7FD6C6DB27B4CE3BABA6B7F7D5")
        public Builder setNeutralButton(int textId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1659775540 = null; //Variable for return #1
            P.mNeutralButtonText = P.mContext.getText(textId);
            P.mNeutralButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_1659775540 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1659775540.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1659775540;
            // ---------- Original Method ----------
            //P.mNeutralButtonText = P.mContext.getText(textId);
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.158 -0400", hash_original_method = "4D91C8A8E1E08D55171F5837D3929412", hash_generated_method = "CC4270A2F165816C6E062FB1B17D2F31")
        public Builder setNeutralButton(CharSequence text, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_806564817 = null; //Variable for return #1
            P.mNeutralButtonText = text;
            P.mNeutralButtonListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_806564817 = this;
            varB4EAC82CA7396A68D541C85D26508E83_806564817.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_806564817;
            // ---------- Original Method ----------
            //P.mNeutralButtonText = text;
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.159 -0400", hash_original_method = "D23CAE45E6F3DF826F9F93A9D8E4F37B", hash_generated_method = "ED0D34F07DA03201FB7E75BB22CDDDB4")
        public Builder setCancelable(boolean cancelable) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1973558221 = null; //Variable for return #1
            P.mCancelable = cancelable;
            varB4EAC82CA7396A68D541C85D26508E83_1973558221 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1973558221.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1973558221;
            // ---------- Original Method ----------
            //P.mCancelable = cancelable;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.162 -0400", hash_original_method = "D6E5909FD450512C75F4E75E987AC229", hash_generated_method = "87F021F020072177D33B113DC3450C07")
        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_48450637 = null; //Variable for return #1
            P.mOnCancelListener = onCancelListener;
            varB4EAC82CA7396A68D541C85D26508E83_48450637 = this;
            varB4EAC82CA7396A68D541C85D26508E83_48450637.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_48450637;
            // ---------- Original Method ----------
            //P.mOnCancelListener = onCancelListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.163 -0400", hash_original_method = "6E5FB56A362A817B52A235DFACC25DAE", hash_generated_method = "98BE61FE07A598C2B126401B9572EA5C")
        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1822393842 = null; //Variable for return #1
            P.mOnKeyListener = onKeyListener;
            varB4EAC82CA7396A68D541C85D26508E83_1822393842 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1822393842.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1822393842;
            // ---------- Original Method ----------
            //P.mOnKeyListener = onKeyListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.164 -0400", hash_original_method = "6D193582453841FD4D6BB305EA061757", hash_generated_method = "293B353D9658A52B555641D910F5CAE8")
        public Builder setItems(int itemsId, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_856700478 = null; //Variable for return #1
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_856700478 = this;
            varB4EAC82CA7396A68D541C85D26508E83_856700478.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_856700478;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.165 -0400", hash_original_method = "AFD2C4146CF077CBCC62EEF7225AE645", hash_generated_method = "42CB68800C7BD89D80C0D79FBFD3627F")
        public Builder setItems(CharSequence[] items, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2143123918 = null; //Variable for return #1
            P.mItems = items;
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_2143123918 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2143123918.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2143123918;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.166 -0400", hash_original_method = "2FCAEDE0B3C9195EDB3158F22A7C0109", hash_generated_method = "A28920AAEFD52A6B861473BDE2C8AD67")
        public Builder setAdapter(final ListAdapter adapter, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_183980647 = null; //Variable for return #1
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_183980647 = this;
            varB4EAC82CA7396A68D541C85D26508E83_183980647.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_183980647;
            // ---------- Original Method ----------
            //P.mAdapter = adapter;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.167 -0400", hash_original_method = "7DFF15703A2CCBB36AC3557F6AE7E187", hash_generated_method = "685F708C2B3463C0032F9923194D3E37")
        public Builder setCursor(final Cursor cursor, final OnClickListener listener,
                String labelColumn) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1649366504 = null; //Variable for return #1
            P.mCursor = cursor;
            P.mLabelColumn = labelColumn;
            P.mOnClickListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_1649366504 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1649366504.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1649366504;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mLabelColumn = labelColumn;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.169 -0400", hash_original_method = "7878252A286B56EBCE9E439D4FCEB298", hash_generated_method = "0BB573C3AF2A2773B6339E8772FED618")
        public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1956185314 = null; //Variable for return #1
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_1956185314 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1956185314.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1956185314;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnCheckboxClickListener = listener;
            //P.mCheckedItems = checkedItems;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.172 -0400", hash_original_method = "73AB6C3AD26EFF6561BAC3BA481ECFD7", hash_generated_method = "F3631FBFFADE507CABF83CBAC45D6FB7")
        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_756697468 = null; //Variable for return #1
            P.mItems = items;
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_756697468 = this;
            varB4EAC82CA7396A68D541C85D26508E83_756697468.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_756697468;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnCheckboxClickListener = listener;
            //P.mCheckedItems = checkedItems;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.174 -0400", hash_original_method = "E8A3FFCE7184DC2DAE306B849E312FF3", hash_generated_method = "73889A36D2D2C3AEB4751A322E964108")
        public Builder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn, 
                final OnMultiChoiceClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1214158675 = null; //Variable for return #1
            P.mCursor = cursor;
            P.mOnCheckboxClickListener = listener;
            P.mIsCheckedColumn = isCheckedColumn;
            P.mLabelColumn = labelColumn;
            P.mIsMultiChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_1214158675 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1214158675.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1214158675;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mOnCheckboxClickListener = listener;
            //P.mIsCheckedColumn = isCheckedColumn;
            //P.mLabelColumn = labelColumn;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.175 -0400", hash_original_method = "CF9378D7D2AE06BB2F5FFE088D660C44", hash_generated_method = "1FEB3830553B46942021A79C24F50FF9")
        public Builder setSingleChoiceItems(int itemsId, int checkedItem, 
                final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1322000096 = null; //Variable for return #1
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_1322000096 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1322000096.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1322000096;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.176 -0400", hash_original_method = "02441459B611830238DF1D8B31546828", hash_generated_method = "D5689D6BCDEA04F90B884AB440AFA901")
        public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, 
                final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2000247488 = null; //Variable for return #1
            P.mCursor = cursor;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mLabelColumn = labelColumn;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_2000247488 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2000247488.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2000247488;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mLabelColumn = labelColumn;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.178 -0400", hash_original_method = "7491118E608CEFA972DD3B23E3E7B8C6", hash_generated_method = "9685DC9328EBFA1749215139E4E81416")
        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_2034687494 = null; //Variable for return #1
            P.mItems = items;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_2034687494 = this;
            varB4EAC82CA7396A68D541C85D26508E83_2034687494.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2034687494;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.180 -0400", hash_original_method = "06BB43759703ED3EE55275B85ACF4622", hash_generated_method = "295CC5ABF12C610C77FCDC2082AA79A1")
        public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, final OnClickListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1613272042 = null; //Variable for return #1
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
            varB4EAC82CA7396A68D541C85D26508E83_1613272042 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1613272042.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1613272042;
            // ---------- Original Method ----------
            //P.mAdapter = adapter;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.183 -0400", hash_original_method = "2F93F9BAEF2ABE538EE141EAC45DF294", hash_generated_method = "63413A158C5F43A2DF649BD4A84E1EE4")
        public Builder setOnItemSelectedListener(final AdapterView.OnItemSelectedListener listener) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_6727290 = null; //Variable for return #1
            P.mOnItemSelectedListener = listener;
            varB4EAC82CA7396A68D541C85D26508E83_6727290 = this;
            varB4EAC82CA7396A68D541C85D26508E83_6727290.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_6727290;
            // ---------- Original Method ----------
            //P.mOnItemSelectedListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.184 -0400", hash_original_method = "ECE0E9F89C9289601A4B4F810B41F8E6", hash_generated_method = "B67467F3627E7B0101315ABB0AE23673")
        public Builder setView(View view) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_538509390 = null; //Variable for return #1
            P.mView = view;
            P.mViewSpacingSpecified = false;
            varB4EAC82CA7396A68D541C85D26508E83_538509390 = this;
            varB4EAC82CA7396A68D541C85D26508E83_538509390.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_538509390;
            // ---------- Original Method ----------
            //P.mView = view;
            //P.mViewSpacingSpecified = false;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.186 -0400", hash_original_method = "BAFAE1A19AC8AE3D7A23796C6231E632", hash_generated_method = "A7606F9E3D31667197FFBBE7F83FC862")
        public Builder setView(View view, int viewSpacingLeft, int viewSpacingTop,
                int viewSpacingRight, int viewSpacingBottom) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1245449243 = null; //Variable for return #1
            P.mView = view;
            P.mViewSpacingSpecified = true;
            P.mViewSpacingLeft = viewSpacingLeft;
            P.mViewSpacingTop = viewSpacingTop;
            P.mViewSpacingRight = viewSpacingRight;
            P.mViewSpacingBottom = viewSpacingBottom;
            varB4EAC82CA7396A68D541C85D26508E83_1245449243 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1245449243.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1245449243;
            // ---------- Original Method ----------
            //P.mView = view;
            //P.mViewSpacingSpecified = true;
            //P.mViewSpacingLeft = viewSpacingLeft;
            //P.mViewSpacingTop = viewSpacingTop;
            //P.mViewSpacingRight = viewSpacingRight;
            //P.mViewSpacingBottom = viewSpacingBottom;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.187 -0400", hash_original_method = "574A516CEEC9B60678E7B4D3D76288FB", hash_generated_method = "E1D2ED5CDEBB29902D8A842F22644AB7")
        public Builder setInverseBackgroundForced(boolean useInverseBackground) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1721607082 = null; //Variable for return #1
            P.mForceInverseBackground = useInverseBackground;
            varB4EAC82CA7396A68D541C85D26508E83_1721607082 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1721607082.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1721607082;
            // ---------- Original Method ----------
            //P.mForceInverseBackground = useInverseBackground;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.188 -0400", hash_original_method = "B90B897256AEB065436BDBB1FFCE63CD", hash_generated_method = "3379C16313FB3C257545FDB91283E590")
        public Builder setRecycleOnMeasureEnabled(boolean enabled) {
            Builder varB4EAC82CA7396A68D541C85D26508E83_1351559399 = null; //Variable for return #1
            P.mRecycleOnMeasure = enabled;
            varB4EAC82CA7396A68D541C85D26508E83_1351559399 = this;
            varB4EAC82CA7396A68D541C85D26508E83_1351559399.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1351559399;
            // ---------- Original Method ----------
            //P.mRecycleOnMeasure = enabled;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.190 -0400", hash_original_method = "24F2ECF5FEA53B0907C34A4AFC4C2134", hash_generated_method = "054F68C7AD34EECAB843C9E2A93DCBFF")
        public AlertDialog create() {
            AlertDialog varB4EAC82CA7396A68D541C85D26508E83_2021859400 = null; //Variable for return #1
            final AlertDialog dialog = new AlertDialog(P.mContext, mTheme, false);
            P.apply(dialog.mAlert);
            dialog.setCancelable(P.mCancelable);
            {
                dialog.setCanceledOnTouchOutside(true);
            } //End block
            dialog.setOnCancelListener(P.mOnCancelListener);
            {
                dialog.setOnKeyListener(P.mOnKeyListener);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_2021859400 = dialog;
            varB4EAC82CA7396A68D541C85D26508E83_2021859400.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2021859400;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.193 -0400", hash_original_method = "9ED881995B2EAB3CB90B8129D2705377", hash_generated_method = "1F6D9F13FD2C03758D8A96FE922CFC70")
        public AlertDialog show() {
            AlertDialog varB4EAC82CA7396A68D541C85D26508E83_1865292396 = null; //Variable for return #1
            AlertDialog dialog = create();
            dialog.show();
            varB4EAC82CA7396A68D541C85D26508E83_1865292396 = dialog;
            varB4EAC82CA7396A68D541C85D26508E83_1865292396.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1865292396;
            // ---------- Original Method ----------
            //AlertDialog dialog = create();
            //dialog.show();
            //return dialog;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.193 -0400", hash_original_field = "4DFDB4E3D636655F48E1A3F56FC8B460", hash_generated_field = "04F8A3C57B2864E838978D2CD85E8969")

    public static final int THEME_TRADITIONAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.193 -0400", hash_original_field = "1FEAEF575CA7C9C499A21A6D00FF6A81", hash_generated_field = "2784576D25C201833EBEF780244434BE")

    public static final int THEME_HOLO_DARK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.194 -0400", hash_original_field = "89D7D60DEB78F2A37B347CF842C4D168", hash_generated_field = "C3AAAE4F57F49818B346717868538E05")

    public static final int THEME_HOLO_LIGHT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.194 -0400", hash_original_field = "5D9B0E66987E45D6A6FA09D644E80FED", hash_generated_field = "BFF34475E73341D4B4E388DEB93A3440")

    public static final int THEME_DEVICE_DEFAULT_DARK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.194 -0400", hash_original_field = "DFB38917D9774209AE404DFC71CA5CE8", hash_generated_field = "E0D4DDCC01DBB4B3153128208E0562F5")

    public static final int THEME_DEVICE_DEFAULT_LIGHT = 5;
}

