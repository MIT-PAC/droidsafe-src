package android.app;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.internal.app.AlertController;






public class AlertDialog extends Dialog implements DialogInterface {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.975 -0400", hash_original_field = "5117530B5FC21047AC49783CC786404F", hash_generated_field = "167B5CF3490749BA13C3817234C227CF")

    private AlertController mAlert;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.975 -0400", hash_original_method = "3B9AE3A4287FBB2F8914E3FC42E19D75", hash_generated_method = "1583F710FE0C1778C52687E18EADF09B")
    protected  AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.976 -0400", hash_original_method = "C5FA972556687388DAE356FD387A2EE9", hash_generated_method = "90F63D555F618DCEC64E8B91F3181DA4")
    protected  AlertDialog(Context context, int theme) {
        this(context, theme, true);
        addTaint(theme);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.977 -0400", hash_original_method = "6D386DC5BAB559A725B0E80B3B80739F", hash_generated_method = "4708DAF209A9E264F2870699385AEC0D")
      AlertDialog(Context context, int theme, boolean createContextWrapper) {
        super(context, resolveDialogTheme(context, theme), createContextWrapper);
        addTaint(createContextWrapper);
        addTaint(theme);
        addTaint(context.getTaint());
        mWindow.alwaysReadCloseOnTouchAttr();
        mAlert = new AlertController(getContext(), this, getWindow());
        // ---------- Original Method ----------
        //mWindow.alwaysReadCloseOnTouchAttr();
        //mAlert = new AlertController(getContext(), this, getWindow());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.978 -0400", hash_original_method = "EA464E0CF4AA10E0AEDF6B163BEEF729", hash_generated_method = "7F5A902CFE78FB8167596A55229CBCFE")
    protected  AlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, resolveDialogTheme(context, 0));
        addTaint(cancelListener.getTaint());
        addTaint(cancelable);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.979 -0400", hash_original_method = "2277A8C194577CB499FB53C1370D61D1", hash_generated_method = "B7188CF39CE4A1207BBBFBF54836C5CF")
    public Button getButton(int whichButton) {
        addTaint(whichButton);
Button var982AAF2A195CEB114AEA08F0D79D1554_623151443 =         mAlert.getButton(whichButton);
        var982AAF2A195CEB114AEA08F0D79D1554_623151443.addTaint(taint);
        return var982AAF2A195CEB114AEA08F0D79D1554_623151443;
        // ---------- Original Method ----------
        //return mAlert.getButton(whichButton);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.980 -0400", hash_original_method = "ECC410A91FC6F30B82508F44C93EA39B", hash_generated_method = "EC273ECC084A55FEFC17F7A6C80AAD1E")
    public ListView getListView() {
ListView var2506D587169C0D50E4901C6C53BC48B5_2012875858 =         mAlert.getListView();
        var2506D587169C0D50E4901C6C53BC48B5_2012875858.addTaint(taint);
        return var2506D587169C0D50E4901C6C53BC48B5_2012875858;
        // ---------- Original Method ----------
        //return mAlert.getListView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.981 -0400", hash_original_method = "5655E82DFA793B6CD86300EA45F77D5A", hash_generated_method = "752B50DE17B484A92012992274CD105C")
    @Override
    public void setTitle(CharSequence title) {
        addTaint(title.getTaint());
        super.setTitle(title);
        mAlert.setTitle(title);
        // ---------- Original Method ----------
        //super.setTitle(title);
        //mAlert.setTitle(title);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.981 -0400", hash_original_method = "0AAF0E3192DB53DCF899ECF927301A42", hash_generated_method = "6CFF09B36F781300333D722EA91046F8")
    public void setCustomTitle(View customTitleView) {
        addTaint(customTitleView.getTaint());
        mAlert.setCustomTitle(customTitleView);
        // ---------- Original Method ----------
        //mAlert.setCustomTitle(customTitleView);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.982 -0400", hash_original_method = "0FDFF41BD74285789F29E89A2F2C112C", hash_generated_method = "AD0A1CFD85BC03625326EDD2E6B6DEF0")
    public void setMessage(CharSequence message) {
        addTaint(message.getTaint());
        mAlert.setMessage(message);
        // ---------- Original Method ----------
        //mAlert.setMessage(message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.982 -0400", hash_original_method = "588C26275F4E62D9742C7DBB082EE340", hash_generated_method = "9DFBFC5BE7B086484A96014C0BB838EA")
    public void setView(View view) {
        addTaint(view.getTaint());
        mAlert.setView(view);
        // ---------- Original Method ----------
        //mAlert.setView(view);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.983 -0400", hash_original_method = "399D46DD3D86F04F15AA9836309BED7E", hash_generated_method = "8EC4841573DFDA1EC25234F425B2F3F7")
    public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight,
            int viewSpacingBottom) {
        addTaint(viewSpacingBottom);
        addTaint(viewSpacingRight);
        addTaint(viewSpacingTop);
        addTaint(viewSpacingLeft);
        addTaint(view.getTaint());
        mAlert.setView(view, viewSpacingLeft, viewSpacingTop, viewSpacingRight, viewSpacingBottom);
        // ---------- Original Method ----------
        //mAlert.setView(view, viewSpacingLeft, viewSpacingTop, viewSpacingRight, viewSpacingBottom);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.984 -0400", hash_original_method = "CFE09EBA63F60A6BEEDA0ECE4DBD2BBE", hash_generated_method = "5D987EC8CFC176A30136BDA78EB8E7B4")
    public void setButton(int whichButton, CharSequence text, Message msg) {
        addTaint(msg.getTaint());
        addTaint(text.getTaint());
        addTaint(whichButton);
        mAlert.setButton(whichButton, text, null, msg);
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, null, msg);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.985 -0400", hash_original_method = "FD92C01692F456341A0525E9D1CD5A83", hash_generated_method = "29E6440070F9D9702911D1F48D6B97EB")
    public void setButton(int whichButton, CharSequence text, OnClickListener listener) {
        addTaint(listener.getTaint());
        addTaint(text.getTaint());
        addTaint(whichButton);
        mAlert.setButton(whichButton, text, listener, null);
        // ---------- Original Method ----------
        //mAlert.setButton(whichButton, text, listener, null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.985 -0400", hash_original_method = "2930D21A7389B776726F7D14477E22A5", hash_generated_method = "10A49A8C11997F4F0A6B9043D88B162B")
    @Deprecated
    public void setButton(CharSequence text, Message msg) {
        addTaint(msg.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_POSITIVE, text, msg);
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, msg);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.986 -0400", hash_original_method = "5D138EC6D4B89A4911514A5D190A83FC", hash_generated_method = "91274E3FDD2D3B7490342C08DC50366D")
    @Deprecated
    public void setButton2(CharSequence text, Message msg) {
        addTaint(msg.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_NEGATIVE, text, msg);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, msg);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.986 -0400", hash_original_method = "E62AA308196D7D74E77874CB13CC8D38", hash_generated_method = "AAD1B41DE37D96FC451C9F58D920A9FB")
    @Deprecated
    public void setButton3(CharSequence text, Message msg) {
        addTaint(msg.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_NEUTRAL, text, msg);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.987 -0400", hash_original_method = "14303CDDA201782BB4EE72003EBE4B25", hash_generated_method = "F5A39D614B0E1C476633016ECABDFCB3")
    @Deprecated
    public void setButton(CharSequence text, final OnClickListener listener) {
        addTaint(listener.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_POSITIVE, text, listener);
        // ---------- Original Method ----------
        //setButton(BUTTON_POSITIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.988 -0400", hash_original_method = "99FBB4BC7546CFCEFDAC9CCE0B0EC52F", hash_generated_method = "A133C1FA29229A311BCC319905DF1878")
    @Deprecated
    public void setButton2(CharSequence text, final OnClickListener listener) {
        addTaint(listener.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_NEGATIVE, text, listener);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEGATIVE, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.989 -0400", hash_original_method = "9225C5ACB453A48CCE22F622BD426A12", hash_generated_method = "469E8C38083E77334CDE31443F3D835E")
    @Deprecated
    public void setButton3(CharSequence text, final OnClickListener listener) {
        addTaint(listener.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_NEUTRAL, text, listener);
        // ---------- Original Method ----------
        //setButton(BUTTON_NEUTRAL, text, listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.990 -0400", hash_original_method = "B742B976A105323EE27DB344109D47DF", hash_generated_method = "3C4D87639FE619F12997B202A1E9113E")
    public void setIcon(int resId) {
        addTaint(resId);
        mAlert.setIcon(resId);
        // ---------- Original Method ----------
        //mAlert.setIcon(resId);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.991 -0400", hash_original_method = "58CB6A167EA4E7B84F26608014843ADF", hash_generated_method = "44579B1B6EA54F49D24FAAC7B34B46E5")
    public void setIcon(Drawable icon) {
        addTaint(icon.getTaint());
        mAlert.setIcon(icon);
        // ---------- Original Method ----------
        //mAlert.setIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.992 -0400", hash_original_method = "1B8133F4D68862D013C951EDD0C82832", hash_generated_method = "08969955AC3254B40ADC900C8F0396CF")
    public void setIconAttribute(int attrId) {
        addTaint(attrId);
        TypedValue out = new TypedValue();
        mContext.getTheme().resolveAttribute(attrId, out, true);
        mAlert.setIcon(out.resourceId);
        // ---------- Original Method ----------
        //TypedValue out = new TypedValue();
        //mContext.getTheme().resolveAttribute(attrId, out, true);
        //mAlert.setIcon(out.resourceId);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.994 -0400", hash_original_method = "21C74C630736CECBD7AD6F509C2AA5D7", hash_generated_method = "58DE19A281AA9B85C15AE7D335D2445B")
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        addTaint(forceInverseBackground);
        mAlert.setInverseBackgroundForced(forceInverseBackground);
        // ---------- Original Method ----------
        //mAlert.setInverseBackgroundForced(forceInverseBackground);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.995 -0400", hash_original_method = "84106AE7CC1A6E59D6E45CD48A2A2307", hash_generated_method = "36DE6950D3A8DC6BB6CD6BE5B103CE52")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        super.onCreate(savedInstanceState);
        mAlert.installContent();
        // ---------- Original Method ----------
        //super.onCreate(savedInstanceState);
        //mAlert.installContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.997 -0400", hash_original_method = "BF8AB256B91D3A887301218CA5494F2D", hash_generated_method = "F1E94738E2950904756A842ECA018013")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(mAlert.onKeyDown(keyCode, event))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_76511358 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_55733473 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_55733473;
        }
        boolean var947F0C250323B9F4475E02588E9A9740_957211751 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_312746819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_312746819;
        // ---------- Original Method ----------
        //if (mAlert.onKeyDown(keyCode, event)) return true;
        //return super.onKeyDown(keyCode, event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.999 -0400", hash_original_method = "A1B1EEF278CFBA53A19AA72D7DAA37CB", hash_generated_method = "AEAC5EBEA3E8D8056ACA2C0E53CD5A0E")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        if(mAlert.onKeyUp(keyCode, event))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1686881823 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_721676980 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_721676980;
        }
        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_1830230319 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_190022509 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_190022509;
        // ---------- Original Method ----------
        //if (mAlert.onKeyUp(keyCode, event)) return true;
        //return super.onKeyUp(keyCode, event);
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.000 -0400", hash_original_field = "44C29EDB103A2872F519AD0C9A0FDAAA", hash_generated_field = "A137DC00364323BBFDABBB1A415FA549")

        private AlertController.AlertParams P;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.000 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "34E231731C1A787DE0ECD3122BFFE819")

        private int mTheme;
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.001 -0400", hash_original_method = "CB1BA6F353D1C3D1D9DFD93D2E2AA221", hash_generated_method = "791B948FE20DB84EB9AFE7EAB27B0BAA")
        public  Builder(Context context) {
            this(context, resolveDialogTheme(context, 0));
            addTaint(context.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.002 -0400", hash_original_method = "054A5871E094F7103A36213597CB2400", hash_generated_method = "75925050F4252355E77EE07B943F447E")
        public  Builder(Context context, int theme) {
            P = new AlertController.AlertParams(new ContextThemeWrapper(
                    context, resolveDialogTheme(context, theme)));
            mTheme = theme;
            // ---------- Original Method ----------
            //P = new AlertController.AlertParams(new ContextThemeWrapper(
                    //context, resolveDialogTheme(context, theme)));
            //mTheme = theme;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.004 -0400", hash_original_method = "D1A12C2F09D145663A4318954DC7CD00", hash_generated_method = "BE8C86CD5BBE29CA66AE94A563388FA6")
        public Context getContext() {
Context var102D10C674A12CAF94F2F690E7FA7CC0_732488015 =             P.mContext;
            var102D10C674A12CAF94F2F690E7FA7CC0_732488015.addTaint(taint);
            return var102D10C674A12CAF94F2F690E7FA7CC0_732488015;
            // ---------- Original Method ----------
            //return P.mContext;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.006 -0400", hash_original_method = "E63FAC4DEED51E16AAD703A71B581EEF", hash_generated_method = "E3E35ECB79DD0E447BC361C4D5A7BCB5")
        public Builder setTitle(int titleId) {
            P.mTitle = P.mContext.getText(titleId);
Builder var72A74007B2BE62B849F475C7BDA4658B_1753926760 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1753926760.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1753926760;
            // ---------- Original Method ----------
            //P.mTitle = P.mContext.getText(titleId);
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.008 -0400", hash_original_method = "255D326AF0B389CCA9CBF4AFBC3FE756", hash_generated_method = "DB66A5DD283AFE0E962525118602727F")
        public Builder setTitle(CharSequence title) {
            P.mTitle = title;
Builder var72A74007B2BE62B849F475C7BDA4658B_2106314327 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2106314327.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2106314327;
            // ---------- Original Method ----------
            //P.mTitle = title;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.010 -0400", hash_original_method = "0009CCFABCB39131348E93CD167BBCD7", hash_generated_method = "BB8A18714306B32FB501EA97AC533026")
        public Builder setCustomTitle(View customTitleView) {
            P.mCustomTitleView = customTitleView;
Builder var72A74007B2BE62B849F475C7BDA4658B_1775466109 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1775466109.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1775466109;
            // ---------- Original Method ----------
            //P.mCustomTitleView = customTitleView;
            //return this;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.011 -0400", hash_original_method = "3B23BD93B750653B90374824F5917D89", hash_generated_method = "55CAAC69575BB85E9E24C593C560257B")
        public Builder setMessage(int messageId) {
            P.mMessage = P.mContext.getText(messageId);
Builder var72A74007B2BE62B849F475C7BDA4658B_1081926548 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1081926548.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1081926548;
            // ---------- Original Method ----------
            //P.mMessage = P.mContext.getText(messageId);
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.012 -0400", hash_original_method = "F560859B14C962F22BDF3327E633A8EC", hash_generated_method = "1E6EE68839EEFDCC59402F9F2E3458FD")
        public Builder setMessage(CharSequence message) {
            P.mMessage = message;
Builder var72A74007B2BE62B849F475C7BDA4658B_1356972325 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1356972325.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1356972325;
            // ---------- Original Method ----------
            //P.mMessage = message;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.014 -0400", hash_original_method = "EBD38AA9C651B93ADF14B14E5D33C5C9", hash_generated_method = "C3B64C11B52EEDA9E30667CE914975F9")
        public Builder setIcon(int iconId) {
            P.mIconId = iconId;
Builder var72A74007B2BE62B849F475C7BDA4658B_604989255 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_604989255.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_604989255;
            // ---------- Original Method ----------
            //P.mIconId = iconId;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.014 -0400", hash_original_method = "EDCD80F224B2F3CED85A928D84460540", hash_generated_method = "7D71D78C24659915A10399D9C9EE1E1C")
        public Builder setIcon(Drawable icon) {
            P.mIcon = icon;
Builder var72A74007B2BE62B849F475C7BDA4658B_894892718 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_894892718.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_894892718;
            // ---------- Original Method ----------
            //P.mIcon = icon;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.015 -0400", hash_original_method = "3A94A6A2822E55FB53EB2F980E52FF8E", hash_generated_method = "B006CC613930A86C82B08ECAB6EA22FA")
        public Builder setIconAttribute(int attrId) {
            addTaint(attrId);
            TypedValue out = new TypedValue();
            P.mContext.getTheme().resolveAttribute(attrId, out, true);
            P.mIconId = out.resourceId;
Builder var72A74007B2BE62B849F475C7BDA4658B_768269418 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_768269418.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_768269418;
            // ---------- Original Method ----------
            //TypedValue out = new TypedValue();
            //P.mContext.getTheme().resolveAttribute(attrId, out, true);
            //P.mIconId = out.resourceId;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.017 -0400", hash_original_method = "1908B917B7F2E57ADC23D5E48F4386F2", hash_generated_method = "BFEDD3E2F1BC7C8CBF3AF2CA3644354B")
        public Builder setPositiveButton(int textId, final OnClickListener listener) {
            P.mPositiveButtonText = P.mContext.getText(textId);
            P.mPositiveButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1345585724 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1345585724.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1345585724;
            // ---------- Original Method ----------
            //P.mPositiveButtonText = P.mContext.getText(textId);
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.018 -0400", hash_original_method = "1500328C36AB679D672A26C184A5FC31", hash_generated_method = "BCB0629197C59D83B61E8D44D8EB4327")
        public Builder setPositiveButton(CharSequence text, final OnClickListener listener) {
            P.mPositiveButtonText = text;
            P.mPositiveButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1271100816 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1271100816.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1271100816;
            // ---------- Original Method ----------
            //P.mPositiveButtonText = text;
            //P.mPositiveButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.019 -0400", hash_original_method = "375537371A0A52AA7AA0B24EAC6A7474", hash_generated_method = "639ACB51B11907734BA9F908614BA135")
        public Builder setNegativeButton(int textId, final OnClickListener listener) {
            P.mNegativeButtonText = P.mContext.getText(textId);
            P.mNegativeButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1812162133 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1812162133.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1812162133;
            // ---------- Original Method ----------
            //P.mNegativeButtonText = P.mContext.getText(textId);
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.020 -0400", hash_original_method = "50EFB872DEBCC22CFB32B40979906BC8", hash_generated_method = "6B70CF2D3BAB8DEB214DFE9A8BD81358")
        public Builder setNegativeButton(CharSequence text, final OnClickListener listener) {
            P.mNegativeButtonText = text;
            P.mNegativeButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1965877369 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1965877369.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1965877369;
            // ---------- Original Method ----------
            //P.mNegativeButtonText = text;
            //P.mNegativeButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.022 -0400", hash_original_method = "0D40DB16A6B6349ABA0D8583C3D4D844", hash_generated_method = "7AB54CED670EBB7CC27C403DCFC5F39C")
        public Builder setNeutralButton(int textId, final OnClickListener listener) {
            P.mNeutralButtonText = P.mContext.getText(textId);
            P.mNeutralButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_69162640 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_69162640.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_69162640;
            // ---------- Original Method ----------
            //P.mNeutralButtonText = P.mContext.getText(textId);
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.024 -0400", hash_original_method = "4D91C8A8E1E08D55171F5837D3929412", hash_generated_method = "EF3C01AAD6204D2A70C227EE0641BB52")
        public Builder setNeutralButton(CharSequence text, final OnClickListener listener) {
            P.mNeutralButtonText = text;
            P.mNeutralButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_668800448 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_668800448.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_668800448;
            // ---------- Original Method ----------
            //P.mNeutralButtonText = text;
            //P.mNeutralButtonListener = listener;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.026 -0400", hash_original_method = "D23CAE45E6F3DF826F9F93A9D8E4F37B", hash_generated_method = "46915D6AC6D0CF683D7D687F414E0F17")
        public Builder setCancelable(boolean cancelable) {
            P.mCancelable = cancelable;
Builder var72A74007B2BE62B849F475C7BDA4658B_1276533003 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1276533003.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1276533003;
            // ---------- Original Method ----------
            //P.mCancelable = cancelable;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.028 -0400", hash_original_method = "D6E5909FD450512C75F4E75E987AC229", hash_generated_method = "F04B3AD238783F944E442F8D6BA7A986")
        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            P.mOnCancelListener = onCancelListener;
Builder var72A74007B2BE62B849F475C7BDA4658B_703198700 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_703198700.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_703198700;
            // ---------- Original Method ----------
            //P.mOnCancelListener = onCancelListener;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.030 -0400", hash_original_method = "6E5FB56A362A817B52A235DFACC25DAE", hash_generated_method = "F7AE69BA0B9EBAE1A1E16EF34E557F82")
        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            P.mOnKeyListener = onKeyListener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1102212499 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1102212499.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1102212499;
            // ---------- Original Method ----------
            //P.mOnKeyListener = onKeyListener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.032 -0400", hash_original_method = "6D193582453841FD4D6BB305EA061757", hash_generated_method = "AA83DF773A3D2138E1A7612B08561C2F")
        public Builder setItems(int itemsId, final OnClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1219590025 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1219590025.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1219590025;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.034 -0400", hash_original_method = "AFD2C4146CF077CBCC62EEF7225AE645", hash_generated_method = "74B4A29A1F35FE7C0138051CB8159A7D")
        public Builder setItems(CharSequence[] items, final OnClickListener listener) {
            P.mItems = items;
            P.mOnClickListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1482300472 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1482300472.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1482300472;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.037 -0400", hash_original_method = "2FCAEDE0B3C9195EDB3158F22A7C0109", hash_generated_method = "A89CF367BEAEE08C5F0A4B950466329C")
        public Builder setAdapter(final ListAdapter adapter, final OnClickListener listener) {
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_519620734 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_519620734.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_519620734;
            // ---------- Original Method ----------
            //P.mAdapter = adapter;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.039 -0400", hash_original_method = "7DFF15703A2CCBB36AC3557F6AE7E187", hash_generated_method = "D904B5F149A0F9C89F9399D941ED46B7")
        public Builder setCursor(final Cursor cursor, final OnClickListener listener,
                String labelColumn) {
            P.mCursor = cursor;
            P.mLabelColumn = labelColumn;
            P.mOnClickListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1257976296 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1257976296.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1257976296;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mLabelColumn = labelColumn;
            //P.mOnClickListener = listener;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.041 -0400", hash_original_method = "7878252A286B56EBCE9E439D4FCEB298", hash_generated_method = "C84C459099D32D54CFB1E42C523A810D")
        public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_183145158 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_183145158.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_183145158;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnCheckboxClickListener = listener;
            //P.mCheckedItems = checkedItems;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.043 -0400", hash_original_method = "73AB6C3AD26EFF6561BAC3BA481ECFD7", hash_generated_method = "6DF3E6B2B733392B670A6E268034D256")
        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            P.mItems = items;
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_397081415 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_397081415.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_397081415;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnCheckboxClickListener = listener;
            //P.mCheckedItems = checkedItems;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.045 -0400", hash_original_method = "E8A3FFCE7184DC2DAE306B849E312FF3", hash_generated_method = "E1125E75348D765F87AC30A6DA001A73")
        public Builder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn, 
                final OnMultiChoiceClickListener listener) {
            P.mCursor = cursor;
            P.mOnCheckboxClickListener = listener;
            P.mIsCheckedColumn = isCheckedColumn;
            P.mLabelColumn = labelColumn;
            P.mIsMultiChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_172881778 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_172881778.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_172881778;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mOnCheckboxClickListener = listener;
            //P.mIsCheckedColumn = isCheckedColumn;
            //P.mLabelColumn = labelColumn;
            //P.mIsMultiChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.046 -0400", hash_original_method = "CF9378D7D2AE06BB2F5FFE088D660C44", hash_generated_method = "BB6A18157F30E49F3CA274D6B78CC1A7")
        public Builder setSingleChoiceItems(int itemsId, int checkedItem, 
                final OnClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_1638587830 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1638587830.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1638587830;
            // ---------- Original Method ----------
            //P.mItems = P.mContext.getResources().getTextArray(itemsId);
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.050 -0400", hash_original_method = "02441459B611830238DF1D8B31546828", hash_generated_method = "AF94B70B6983BDFB6CC69E8323E74876")
        public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, 
                final OnClickListener listener) {
            P.mCursor = cursor;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mLabelColumn = labelColumn;
            P.mIsSingleChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_224247942 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_224247942.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_224247942;
            // ---------- Original Method ----------
            //P.mCursor = cursor;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mLabelColumn = labelColumn;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.055 -0400", hash_original_method = "7491118E608CEFA972DD3B23E3E7B8C6", hash_generated_method = "A31014734A56E32D87841F1BFEF76C5E")
        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener) {
            P.mItems = items;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_478597044 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_478597044.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_478597044;
            // ---------- Original Method ----------
            //P.mItems = items;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.058 -0400", hash_original_method = "06BB43759703ED3EE55275B85ACF4622", hash_generated_method = "2A9A62A8F1F34EF73421157174A6F80E")
        public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, final OnClickListener listener) {
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_533244218 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_533244218.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_533244218;
            // ---------- Original Method ----------
            //P.mAdapter = adapter;
            //P.mOnClickListener = listener;
            //P.mCheckedItem = checkedItem;
            //P.mIsSingleChoice = true;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.060 -0400", hash_original_method = "2F93F9BAEF2ABE538EE141EAC45DF294", hash_generated_method = "562B2701FA2243C10E2CC3CE340D32FD")
        public Builder setOnItemSelectedListener(final AdapterView.OnItemSelectedListener listener) {
            P.mOnItemSelectedListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_281662635 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_281662635.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_281662635;
            // ---------- Original Method ----------
            //P.mOnItemSelectedListener = listener;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.063 -0400", hash_original_method = "ECE0E9F89C9289601A4B4F810B41F8E6", hash_generated_method = "F4A5BD0515589278F3C80A9642BDD358")
        public Builder setView(View view) {
            P.mView = view;
            P.mViewSpacingSpecified = false;
Builder var72A74007B2BE62B849F475C7BDA4658B_96541784 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_96541784.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_96541784;
            // ---------- Original Method ----------
            //P.mView = view;
            //P.mViewSpacingSpecified = false;
            //return this;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.066 -0400", hash_original_method = "BAFAE1A19AC8AE3D7A23796C6231E632", hash_generated_method = "0749378B45A87D9B27127D25D71BAA31")
        public Builder setView(View view, int viewSpacingLeft, int viewSpacingTop,
                int viewSpacingRight, int viewSpacingBottom) {
            P.mView = view;
            P.mViewSpacingSpecified = true;
            P.mViewSpacingLeft = viewSpacingLeft;
            P.mViewSpacingTop = viewSpacingTop;
            P.mViewSpacingRight = viewSpacingRight;
            P.mViewSpacingBottom = viewSpacingBottom;
Builder var72A74007B2BE62B849F475C7BDA4658B_446105524 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_446105524.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_446105524;
            // ---------- Original Method ----------
            //P.mView = view;
            //P.mViewSpacingSpecified = true;
            //P.mViewSpacingLeft = viewSpacingLeft;
            //P.mViewSpacingTop = viewSpacingTop;
            //P.mViewSpacingRight = viewSpacingRight;
            //P.mViewSpacingBottom = viewSpacingBottom;
            //return this;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.067 -0400", hash_original_method = "574A516CEEC9B60678E7B4D3D76288FB", hash_generated_method = "46F7B97839756B980590BA3C900DD47A")
        public Builder setInverseBackgroundForced(boolean useInverseBackground) {
            P.mForceInverseBackground = useInverseBackground;
Builder var72A74007B2BE62B849F475C7BDA4658B_292044711 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_292044711.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_292044711;
            // ---------- Original Method ----------
            //P.mForceInverseBackground = useInverseBackground;
            //return this;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.069 -0400", hash_original_method = "B90B897256AEB065436BDBB1FFCE63CD", hash_generated_method = "9DD41119228AE4686AD2CBFF3CCD7130")
        public Builder setRecycleOnMeasureEnabled(boolean enabled) {
            P.mRecycleOnMeasure = enabled;
Builder var72A74007B2BE62B849F475C7BDA4658B_1521219680 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1521219680.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1521219680;
            // ---------- Original Method ----------
            //P.mRecycleOnMeasure = enabled;
            //return this;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.070 -0400", hash_original_method = "24F2ECF5FEA53B0907C34A4AFC4C2134", hash_generated_method = "776F67F1F733289C64AE4A93107A0614")
        public AlertDialog create() {
            final AlertDialog dialog = new AlertDialog(P.mContext, mTheme, false);
            P.apply(dialog.mAlert);
            dialog.setCancelable(P.mCancelable);
            if(P.mCancelable)            
            {
                dialog.setCanceledOnTouchOutside(true);
            } //End block
            dialog.setOnCancelListener(P.mOnCancelListener);
            if(P.mOnKeyListener != null)            
            {
                dialog.setOnKeyListener(P.mOnKeyListener);
            } //End block
AlertDialog varE19892282EF70932DF3A147A213BE89D_580931381 =             dialog;
            varE19892282EF70932DF3A147A213BE89D_580931381.addTaint(taint);
            return varE19892282EF70932DF3A147A213BE89D_580931381;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.071 -0400", hash_original_method = "9ED881995B2EAB3CB90B8129D2705377", hash_generated_method = "33469449DD6A882A6A0B8831F6E6ED34")
        public AlertDialog show() {
            AlertDialog dialog = create();
            dialog.show();
AlertDialog varE19892282EF70932DF3A147A213BE89D_872083796 =             dialog;
            varE19892282EF70932DF3A147A213BE89D_872083796.addTaint(taint);
            return varE19892282EF70932DF3A147A213BE89D_872083796;
            // ---------- Original Method ----------
            //AlertDialog dialog = create();
            //dialog.show();
            //return dialog;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.073 -0400", hash_original_field = "4DFDB4E3D636655F48E1A3F56FC8B460", hash_generated_field = "04F8A3C57B2864E838978D2CD85E8969")

    public static final int THEME_TRADITIONAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.073 -0400", hash_original_field = "1FEAEF575CA7C9C499A21A6D00FF6A81", hash_generated_field = "2784576D25C201833EBEF780244434BE")

    public static final int THEME_HOLO_DARK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.074 -0400", hash_original_field = "89D7D60DEB78F2A37B347CF842C4D168", hash_generated_field = "C3AAAE4F57F49818B346717868538E05")

    public static final int THEME_HOLO_LIGHT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.075 -0400", hash_original_field = "5D9B0E66987E45D6A6FA09D644E80FED", hash_generated_field = "BFF34475E73341D4B4E388DEB93A3440")

    public static final int THEME_DEVICE_DEFAULT_DARK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.076 -0400", hash_original_field = "DFB38917D9774209AE404DFC71CA5CE8", hash_generated_field = "E0D4DDCC01DBB4B3153128208E0562F5")

    public static final int THEME_DEVICE_DEFAULT_LIGHT = 5;
}

