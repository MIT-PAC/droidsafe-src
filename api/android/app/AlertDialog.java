package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.982 -0400", hash_original_field = "5117530B5FC21047AC49783CC786404F", hash_generated_field = "167B5CF3490749BA13C3817234C227CF")

    private AlertController mAlert;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.982 -0400", hash_original_method = "3B9AE3A4287FBB2F8914E3FC42E19D75", hash_generated_method = "1583F710FE0C1778C52687E18EADF09B")
    protected  AlertDialog(Context context) {
        this(context, resolveDialogTheme(context, 0), true);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.983 -0400", hash_original_method = "C5FA972556687388DAE356FD387A2EE9", hash_generated_method = "90F63D555F618DCEC64E8B91F3181DA4")
    protected  AlertDialog(Context context, int theme) {
        this(context, theme, true);
        addTaint(theme);
        addTaint(context.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.984 -0400", hash_original_method = "6D386DC5BAB559A725B0E80B3B80739F", hash_generated_method = "4708DAF209A9E264F2870699385AEC0D")
      AlertDialog(Context context, int theme, boolean createContextWrapper) {
        super(context, resolveDialogTheme(context, theme), createContextWrapper);
        addTaint(createContextWrapper);
        addTaint(theme);
        addTaint(context.getTaint());
        mWindow.alwaysReadCloseOnTouchAttr();
        mAlert = new AlertController(getContext(), this, getWindow());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.985 -0400", hash_original_method = "EA464E0CF4AA10E0AEDF6B163BEEF729", hash_generated_method = "7F5A902CFE78FB8167596A55229CBCFE")
    protected  AlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, resolveDialogTheme(context, 0));
        addTaint(cancelListener.getTaint());
        addTaint(cancelable);
        mWindow.alwaysReadCloseOnTouchAttr();
        setCancelable(cancelable);
        setOnCancelListener(cancelListener);
        mAlert = new AlertController(context, this, getWindow());
        
        
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.987 -0400", hash_original_method = "2277A8C194577CB499FB53C1370D61D1", hash_generated_method = "EEC847867E7A96CBA18D02B198B00745")
    public Button getButton(int whichButton) {
        addTaint(whichButton);
Button var982AAF2A195CEB114AEA08F0D79D1554_376709208 =         mAlert.getButton(whichButton);
        var982AAF2A195CEB114AEA08F0D79D1554_376709208.addTaint(taint);
        return var982AAF2A195CEB114AEA08F0D79D1554_376709208;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.989 -0400", hash_original_method = "ECC410A91FC6F30B82508F44C93EA39B", hash_generated_method = "C314974D485BEE10FC9B151EE9E0D352")
    public ListView getListView() {
ListView var2506D587169C0D50E4901C6C53BC48B5_1906744487 =         mAlert.getListView();
        var2506D587169C0D50E4901C6C53BC48B5_1906744487.addTaint(taint);
        return var2506D587169C0D50E4901C6C53BC48B5_1906744487;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.990 -0400", hash_original_method = "5655E82DFA793B6CD86300EA45F77D5A", hash_generated_method = "752B50DE17B484A92012992274CD105C")
    @Override
    public void setTitle(CharSequence title) {
        addTaint(title.getTaint());
        super.setTitle(title);
        mAlert.setTitle(title);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.991 -0400", hash_original_method = "0AAF0E3192DB53DCF899ECF927301A42", hash_generated_method = "6CFF09B36F781300333D722EA91046F8")
    public void setCustomTitle(View customTitleView) {
        addTaint(customTitleView.getTaint());
        mAlert.setCustomTitle(customTitleView);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.992 -0400", hash_original_method = "0FDFF41BD74285789F29E89A2F2C112C", hash_generated_method = "AD0A1CFD85BC03625326EDD2E6B6DEF0")
    public void setMessage(CharSequence message) {
        addTaint(message.getTaint());
        mAlert.setMessage(message);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.993 -0400", hash_original_method = "588C26275F4E62D9742C7DBB082EE340", hash_generated_method = "9DFBFC5BE7B086484A96014C0BB838EA")
    public void setView(View view) {
        addTaint(view.getTaint());
        mAlert.setView(view);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.993 -0400", hash_original_method = "399D46DD3D86F04F15AA9836309BED7E", hash_generated_method = "8EC4841573DFDA1EC25234F425B2F3F7")
    public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight,
            int viewSpacingBottom) {
        addTaint(viewSpacingBottom);
        addTaint(viewSpacingRight);
        addTaint(viewSpacingTop);
        addTaint(viewSpacingLeft);
        addTaint(view.getTaint());
        mAlert.setView(view, viewSpacingLeft, viewSpacingTop, viewSpacingRight, viewSpacingBottom);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.994 -0400", hash_original_method = "CFE09EBA63F60A6BEEDA0ECE4DBD2BBE", hash_generated_method = "5D987EC8CFC176A30136BDA78EB8E7B4")
    public void setButton(int whichButton, CharSequence text, Message msg) {
        addTaint(msg.getTaint());
        addTaint(text.getTaint());
        addTaint(whichButton);
        mAlert.setButton(whichButton, text, null, msg);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.995 -0400", hash_original_method = "FD92C01692F456341A0525E9D1CD5A83", hash_generated_method = "29E6440070F9D9702911D1F48D6B97EB")
    public void setButton(int whichButton, CharSequence text, OnClickListener listener) {
        addTaint(listener.getTaint());
        addTaint(text.getTaint());
        addTaint(whichButton);
        mAlert.setButton(whichButton, text, listener, null);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.996 -0400", hash_original_method = "2930D21A7389B776726F7D14477E22A5", hash_generated_method = "10A49A8C11997F4F0A6B9043D88B162B")
    @Deprecated
    public void setButton(CharSequence text, Message msg) {
        addTaint(msg.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_POSITIVE, text, msg);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.996 -0400", hash_original_method = "5D138EC6D4B89A4911514A5D190A83FC", hash_generated_method = "91274E3FDD2D3B7490342C08DC50366D")
    @Deprecated
    public void setButton2(CharSequence text, Message msg) {
        addTaint(msg.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_NEGATIVE, text, msg);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.997 -0400", hash_original_method = "E62AA308196D7D74E77874CB13CC8D38", hash_generated_method = "AAD1B41DE37D96FC451C9F58D920A9FB")
    @Deprecated
    public void setButton3(CharSequence text, Message msg) {
        addTaint(msg.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_NEUTRAL, text, msg);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.998 -0400", hash_original_method = "14303CDDA201782BB4EE72003EBE4B25", hash_generated_method = "F5A39D614B0E1C476633016ECABDFCB3")
    @Deprecated
    public void setButton(CharSequence text, final OnClickListener listener) {
        addTaint(listener.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_POSITIVE, text, listener);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.999 -0400", hash_original_method = "99FBB4BC7546CFCEFDAC9CCE0B0EC52F", hash_generated_method = "A133C1FA29229A311BCC319905DF1878")
    @Deprecated
    public void setButton2(CharSequence text, final OnClickListener listener) {
        addTaint(listener.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_NEGATIVE, text, listener);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.000 -0400", hash_original_method = "9225C5ACB453A48CCE22F622BD426A12", hash_generated_method = "469E8C38083E77334CDE31443F3D835E")
    @Deprecated
    public void setButton3(CharSequence text, final OnClickListener listener) {
        addTaint(listener.getTaint());
        addTaint(text.getTaint());
        setButton(BUTTON_NEUTRAL, text, listener);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.000 -0400", hash_original_method = "B742B976A105323EE27DB344109D47DF", hash_generated_method = "3C4D87639FE619F12997B202A1E9113E")
    public void setIcon(int resId) {
        addTaint(resId);
        mAlert.setIcon(resId);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.001 -0400", hash_original_method = "58CB6A167EA4E7B84F26608014843ADF", hash_generated_method = "44579B1B6EA54F49D24FAAC7B34B46E5")
    public void setIcon(Drawable icon) {
        addTaint(icon.getTaint());
        mAlert.setIcon(icon);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.001 -0400", hash_original_method = "1B8133F4D68862D013C951EDD0C82832", hash_generated_method = "08969955AC3254B40ADC900C8F0396CF")
    public void setIconAttribute(int attrId) {
        addTaint(attrId);
        TypedValue out = new TypedValue();
        mContext.getTheme().resolveAttribute(attrId, out, true);
        mAlert.setIcon(out.resourceId);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.002 -0400", hash_original_method = "21C74C630736CECBD7AD6F509C2AA5D7", hash_generated_method = "58DE19A281AA9B85C15AE7D335D2445B")
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        addTaint(forceInverseBackground);
        mAlert.setInverseBackgroundForced(forceInverseBackground);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.002 -0400", hash_original_method = "84106AE7CC1A6E59D6E45CD48A2A2307", hash_generated_method = "36DE6950D3A8DC6BB6CD6BE5B103CE52")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        addTaint(savedInstanceState.getTaint());
        super.onCreate(savedInstanceState);
        mAlert.installContent();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.003 -0400", hash_original_method = "BF8AB256B91D3A887301218CA5494F2D", hash_generated_method = "32800E870F25B21A60FC94F711C5C8DA")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(mAlert.onKeyDown(keyCode, event))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1085488010 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_490833436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_490833436;
        }
        boolean var947F0C250323B9F4475E02588E9A9740_29408293 = (super.onKeyDown(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588367196 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588367196;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.004 -0400", hash_original_method = "A1B1EEF278CFBA53A19AA72D7DAA37CB", hash_generated_method = "589D61DF7592634DE673A61C73E7AD8C")
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        
        addTaint(event.getTaint());
        addTaint(keyCode);
    if(mAlert.onKeyUp(keyCode, event))        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2069158801 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_965854558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_965854558;
        }
        boolean varAD33E8F21A74B923C1A24761EAF2F4A9_1347280296 = (super.onKeyUp(keyCode, event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_118780348 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_118780348;
        
        
        
    }

    
    public static class Builder {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.005 -0400", hash_original_field = "44C29EDB103A2872F519AD0C9A0FDAAA", hash_generated_field = "A137DC00364323BBFDABBB1A415FA549")

        private AlertController.AlertParams P;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.005 -0400", hash_original_field = "F33340182B9891501636E62AEA88BE69", hash_generated_field = "34E231731C1A787DE0ECD3122BFFE819")

        private int mTheme;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.006 -0400", hash_original_method = "CB1BA6F353D1C3D1D9DFD93D2E2AA221", hash_generated_method = "791B948FE20DB84EB9AFE7EAB27B0BAA")
        public  Builder(Context context) {
            this(context, resolveDialogTheme(context, 0));
            addTaint(context.getTaint());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.007 -0400", hash_original_method = "054A5871E094F7103A36213597CB2400", hash_generated_method = "75925050F4252355E77EE07B943F447E")
        public  Builder(Context context, int theme) {
            P = new AlertController.AlertParams(new ContextThemeWrapper(
                    context, resolveDialogTheme(context, theme)));
            mTheme = theme;
            
            
                    
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.008 -0400", hash_original_method = "D1A12C2F09D145663A4318954DC7CD00", hash_generated_method = "B76CECD6D3648212C3377C2539EC3558")
        public Context getContext() {
Context var102D10C674A12CAF94F2F690E7FA7CC0_1395037506 =             P.mContext;
            var102D10C674A12CAF94F2F690E7FA7CC0_1395037506.addTaint(taint);
            return var102D10C674A12CAF94F2F690E7FA7CC0_1395037506;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.009 -0400", hash_original_method = "E63FAC4DEED51E16AAD703A71B581EEF", hash_generated_method = "15A8AC4B7FA14025FF2D76CA31648355")
        public Builder setTitle(int titleId) {
            P.mTitle = P.mContext.getText(titleId);
Builder var72A74007B2BE62B849F475C7BDA4658B_2104403543 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2104403543.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2104403543;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.010 -0400", hash_original_method = "255D326AF0B389CCA9CBF4AFBC3FE756", hash_generated_method = "8088F89125450676068D42E1FCAF4AA5")
        public Builder setTitle(CharSequence title) {
            P.mTitle = title;
Builder var72A74007B2BE62B849F475C7BDA4658B_101941070 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_101941070.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_101941070;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.011 -0400", hash_original_method = "0009CCFABCB39131348E93CD167BBCD7", hash_generated_method = "BF65A8F591B0066133CAE3339F58625C")
        public Builder setCustomTitle(View customTitleView) {
            P.mCustomTitleView = customTitleView;
Builder var72A74007B2BE62B849F475C7BDA4658B_1404092349 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1404092349.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1404092349;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.012 -0400", hash_original_method = "3B23BD93B750653B90374824F5917D89", hash_generated_method = "DD1190175C87AED278B2047AB3529ABC")
        public Builder setMessage(int messageId) {
            P.mMessage = P.mContext.getText(messageId);
Builder var72A74007B2BE62B849F475C7BDA4658B_91003528 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_91003528.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_91003528;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.015 -0400", hash_original_method = "F560859B14C962F22BDF3327E633A8EC", hash_generated_method = "D39B48CC52670DB83D2FE0CB978719C6")
        public Builder setMessage(CharSequence message) {
            P.mMessage = message;
Builder var72A74007B2BE62B849F475C7BDA4658B_1306867256 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1306867256.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1306867256;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.017 -0400", hash_original_method = "EBD38AA9C651B93ADF14B14E5D33C5C9", hash_generated_method = "292D7724E2DE25A33CC698BCE06A3896")
        public Builder setIcon(int iconId) {
            P.mIconId = iconId;
Builder var72A74007B2BE62B849F475C7BDA4658B_133034797 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_133034797.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_133034797;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.018 -0400", hash_original_method = "EDCD80F224B2F3CED85A928D84460540", hash_generated_method = "06D94DF444DF07555CC46C764351B481")
        public Builder setIcon(Drawable icon) {
            P.mIcon = icon;
Builder var72A74007B2BE62B849F475C7BDA4658B_1808809881 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1808809881.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1808809881;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.020 -0400", hash_original_method = "3A94A6A2822E55FB53EB2F980E52FF8E", hash_generated_method = "E4E161EB13252193DE0EC39A351E7899")
        public Builder setIconAttribute(int attrId) {
            addTaint(attrId);
            TypedValue out = new TypedValue();
            P.mContext.getTheme().resolveAttribute(attrId, out, true);
            P.mIconId = out.resourceId;
Builder var72A74007B2BE62B849F475C7BDA4658B_1170748971 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1170748971.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1170748971;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.022 -0400", hash_original_method = "1908B917B7F2E57ADC23D5E48F4386F2", hash_generated_method = "E8647403F8DC238614BDBA627A4A9A3A")
        public Builder setPositiveButton(int textId, final OnClickListener listener) {
            P.mPositiveButtonText = P.mContext.getText(textId);
            P.mPositiveButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1817620420 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1817620420.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1817620420;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.024 -0400", hash_original_method = "1500328C36AB679D672A26C184A5FC31", hash_generated_method = "49F39324AC75A6E34895EBAE77472261")
        public Builder setPositiveButton(CharSequence text, final OnClickListener listener) {
            P.mPositiveButtonText = text;
            P.mPositiveButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_134601000 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_134601000.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_134601000;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.025 -0400", hash_original_method = "375537371A0A52AA7AA0B24EAC6A7474", hash_generated_method = "798F92E013294174DA573F5000E21382")
        public Builder setNegativeButton(int textId, final OnClickListener listener) {
            P.mNegativeButtonText = P.mContext.getText(textId);
            P.mNegativeButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_323971740 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_323971740.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_323971740;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.026 -0400", hash_original_method = "50EFB872DEBCC22CFB32B40979906BC8", hash_generated_method = "138A9707FB2DD23E5D78C0C82BD8204E")
        public Builder setNegativeButton(CharSequence text, final OnClickListener listener) {
            P.mNegativeButtonText = text;
            P.mNegativeButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1720011918 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1720011918.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1720011918;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.027 -0400", hash_original_method = "0D40DB16A6B6349ABA0D8583C3D4D844", hash_generated_method = "311B37BDFEDA53C6FBC1C68ECF971F1B")
        public Builder setNeutralButton(int textId, final OnClickListener listener) {
            P.mNeutralButtonText = P.mContext.getText(textId);
            P.mNeutralButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_322318395 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_322318395.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_322318395;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.029 -0400", hash_original_method = "4D91C8A8E1E08D55171F5837D3929412", hash_generated_method = "1484536F528D915CE734B487D588961F")
        public Builder setNeutralButton(CharSequence text, final OnClickListener listener) {
            P.mNeutralButtonText = text;
            P.mNeutralButtonListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1941971405 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1941971405.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1941971405;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.030 -0400", hash_original_method = "D23CAE45E6F3DF826F9F93A9D8E4F37B", hash_generated_method = "86582F57A1BF43BD7685C1C6DBB6F336")
        public Builder setCancelable(boolean cancelable) {
            P.mCancelable = cancelable;
Builder var72A74007B2BE62B849F475C7BDA4658B_1728505268 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1728505268.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1728505268;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.031 -0400", hash_original_method = "D6E5909FD450512C75F4E75E987AC229", hash_generated_method = "154486FF32CF1B46C33F469FD709AAB5")
        public Builder setOnCancelListener(OnCancelListener onCancelListener) {
            P.mOnCancelListener = onCancelListener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1148223235 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1148223235.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1148223235;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.032 -0400", hash_original_method = "6E5FB56A362A817B52A235DFACC25DAE", hash_generated_method = "9D40FA1D9B59B69D57E4D578DD369886")
        public Builder setOnKeyListener(OnKeyListener onKeyListener) {
            P.mOnKeyListener = onKeyListener;
Builder var72A74007B2BE62B849F475C7BDA4658B_846414020 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_846414020.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_846414020;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.033 -0400", hash_original_method = "6D193582453841FD4D6BB305EA061757", hash_generated_method = "C57FD03000FD8B7A9792CF9F661F5FC9")
        public Builder setItems(int itemsId, final OnClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1569630188 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1569630188.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1569630188;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.034 -0400", hash_original_method = "AFD2C4146CF077CBCC62EEF7225AE645", hash_generated_method = "5DDCFA29919D5EE8D25B77803DE49CBA")
        public Builder setItems(CharSequence[] items, final OnClickListener listener) {
            P.mItems = items;
            P.mOnClickListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_513516298 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_513516298.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_513516298;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.035 -0400", hash_original_method = "2FCAEDE0B3C9195EDB3158F22A7C0109", hash_generated_method = "2ED0D7E6519FC9283D05BA866360485F")
        public Builder setAdapter(final ListAdapter adapter, final OnClickListener listener) {
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_57720036 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_57720036.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_57720036;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.037 -0400", hash_original_method = "7DFF15703A2CCBB36AC3557F6AE7E187", hash_generated_method = "7270B4FEA7576F1A6CC96915C085E30A")
        public Builder setCursor(final Cursor cursor, final OnClickListener listener,
                String labelColumn) {
            P.mCursor = cursor;
            P.mLabelColumn = labelColumn;
            P.mOnClickListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1736618590 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1736618590.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1736618590;
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.039 -0400", hash_original_method = "7878252A286B56EBCE9E439D4FCEB298", hash_generated_method = "F9A01A854E12A9B27776BDD16458B118")
        public Builder setMultiChoiceItems(int itemsId, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_1623121370 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1623121370.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1623121370;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.043 -0400", hash_original_method = "73AB6C3AD26EFF6561BAC3BA481ECFD7", hash_generated_method = "C2A35208CE56F28161F1ABB2CDF11299")
        public Builder setMultiChoiceItems(CharSequence[] items, boolean[] checkedItems, 
                final OnMultiChoiceClickListener listener) {
            P.mItems = items;
            P.mOnCheckboxClickListener = listener;
            P.mCheckedItems = checkedItems;
            P.mIsMultiChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_1987556956 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1987556956.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1987556956;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.045 -0400", hash_original_method = "E8A3FFCE7184DC2DAE306B849E312FF3", hash_generated_method = "2A4441288432E3A60027B4309CAB02FF")
        public Builder setMultiChoiceItems(Cursor cursor, String isCheckedColumn, String labelColumn, 
                final OnMultiChoiceClickListener listener) {
            P.mCursor = cursor;
            P.mOnCheckboxClickListener = listener;
            P.mIsCheckedColumn = isCheckedColumn;
            P.mLabelColumn = labelColumn;
            P.mIsMultiChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_1328702846 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1328702846.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1328702846;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.047 -0400", hash_original_method = "CF9378D7D2AE06BB2F5FFE088D660C44", hash_generated_method = "0CAFC1D1C2983CAFF37E045AEA64499E")
        public Builder setSingleChoiceItems(int itemsId, int checkedItem, 
                final OnClickListener listener) {
            P.mItems = P.mContext.getResources().getTextArray(itemsId);
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_2090897356 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_2090897356.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_2090897356;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.048 -0400", hash_original_method = "02441459B611830238DF1D8B31546828", hash_generated_method = "6788A8FFE017DACBC967E9FA213548EE")
        public Builder setSingleChoiceItems(Cursor cursor, int checkedItem, String labelColumn, 
                final OnClickListener listener) {
            P.mCursor = cursor;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mLabelColumn = labelColumn;
            P.mIsSingleChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_554542471 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_554542471.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_554542471;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.050 -0400", hash_original_method = "7491118E608CEFA972DD3B23E3E7B8C6", hash_generated_method = "7177FA995D8EFB362E02315697C81FD3")
        public Builder setSingleChoiceItems(CharSequence[] items, int checkedItem, final OnClickListener listener) {
            P.mItems = items;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_1928803393 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1928803393.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1928803393;
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.052 -0400", hash_original_method = "06BB43759703ED3EE55275B85ACF4622", hash_generated_method = "A7F7734B9E64470EC26BD3F2F6CFD556")
        public Builder setSingleChoiceItems(ListAdapter adapter, int checkedItem, final OnClickListener listener) {
            P.mAdapter = adapter;
            P.mOnClickListener = listener;
            P.mCheckedItem = checkedItem;
            P.mIsSingleChoice = true;
Builder var72A74007B2BE62B849F475C7BDA4658B_1558384472 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1558384472.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1558384472;
            
            
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.053 -0400", hash_original_method = "2F93F9BAEF2ABE538EE141EAC45DF294", hash_generated_method = "DCABE40B8F760DD35AF7E74F8C0CC4F0")
        public Builder setOnItemSelectedListener(final AdapterView.OnItemSelectedListener listener) {
            P.mOnItemSelectedListener = listener;
Builder var72A74007B2BE62B849F475C7BDA4658B_1883921534 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1883921534.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1883921534;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.053 -0400", hash_original_method = "ECE0E9F89C9289601A4B4F810B41F8E6", hash_generated_method = "E27904C33E9F75794413ED7000591E4F")
        public Builder setView(View view) {
            P.mView = view;
            P.mViewSpacingSpecified = false;
Builder var72A74007B2BE62B849F475C7BDA4658B_931866219 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_931866219.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_931866219;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.055 -0400", hash_original_method = "BAFAE1A19AC8AE3D7A23796C6231E632", hash_generated_method = "5A4221317C0D9FF981F3EDF195B5F6F5")
        public Builder setView(View view, int viewSpacingLeft, int viewSpacingTop,
                int viewSpacingRight, int viewSpacingBottom) {
            P.mView = view;
            P.mViewSpacingSpecified = true;
            P.mViewSpacingLeft = viewSpacingLeft;
            P.mViewSpacingTop = viewSpacingTop;
            P.mViewSpacingRight = viewSpacingRight;
            P.mViewSpacingBottom = viewSpacingBottom;
Builder var72A74007B2BE62B849F475C7BDA4658B_1705100184 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1705100184.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1705100184;
            
            
            
            
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.056 -0400", hash_original_method = "574A516CEEC9B60678E7B4D3D76288FB", hash_generated_method = "D21CCCA8ADD4468F323C2567FAE7E3CE")
        public Builder setInverseBackgroundForced(boolean useInverseBackground) {
            P.mForceInverseBackground = useInverseBackground;
Builder var72A74007B2BE62B849F475C7BDA4658B_1610898504 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_1610898504.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_1610898504;
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.056 -0400", hash_original_method = "B90B897256AEB065436BDBB1FFCE63CD", hash_generated_method = "2A17EFA4FF2F970CE55053F1CAE73E70")
        public Builder setRecycleOnMeasureEnabled(boolean enabled) {
            P.mRecycleOnMeasure = enabled;
Builder var72A74007B2BE62B849F475C7BDA4658B_720721774 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_720721774.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_720721774;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.057 -0400", hash_original_method = "24F2ECF5FEA53B0907C34A4AFC4C2134", hash_generated_method = "609317A4A2010705D6BD90F09FAC63EA")
        public AlertDialog create() {
            final AlertDialog dialog = new AlertDialog(P.mContext, mTheme, false);
            P.apply(dialog.mAlert);
            dialog.setCancelable(P.mCancelable);
    if(P.mCancelable)            
            {
                dialog.setCanceledOnTouchOutside(true);
            } 
            dialog.setOnCancelListener(P.mOnCancelListener);
    if(P.mOnKeyListener != null)            
            {
                dialog.setOnKeyListener(P.mOnKeyListener);
            } 
AlertDialog varE19892282EF70932DF3A147A213BE89D_335329243 =             dialog;
            varE19892282EF70932DF3A147A213BE89D_335329243.addTaint(taint);
            return varE19892282EF70932DF3A147A213BE89D_335329243;
            
            
            
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.058 -0400", hash_original_method = "9ED881995B2EAB3CB90B8129D2705377", hash_generated_method = "92ED8E35A61FF3CB34D0549CEE7FFF29")
        public AlertDialog show() {
            AlertDialog dialog = create();
            dialog.show();
AlertDialog varE19892282EF70932DF3A147A213BE89D_1881043440 =             dialog;
            varE19892282EF70932DF3A147A213BE89D_1881043440.addTaint(taint);
            return varE19892282EF70932DF3A147A213BE89D_1881043440;
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.058 -0400", hash_original_field = "4DFDB4E3D636655F48E1A3F56FC8B460", hash_generated_field = "04F8A3C57B2864E838978D2CD85E8969")

    public static final int THEME_TRADITIONAL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.058 -0400", hash_original_field = "1FEAEF575CA7C9C499A21A6D00FF6A81", hash_generated_field = "2784576D25C201833EBEF780244434BE")

    public static final int THEME_HOLO_DARK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.059 -0400", hash_original_field = "89D7D60DEB78F2A37B347CF842C4D168", hash_generated_field = "C3AAAE4F57F49818B346717868538E05")

    public static final int THEME_HOLO_LIGHT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.059 -0400", hash_original_field = "5D9B0E66987E45D6A6FA09D644E80FED", hash_generated_field = "BFF34475E73341D4B4E388DEB93A3440")

    public static final int THEME_DEVICE_DEFAULT_DARK = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:00.059 -0400", hash_original_field = "DFB38917D9774209AE404DFC71CA5CE8", hash_generated_field = "E0D4DDCC01DBB4B3153128208E0562F5")

    public static final int THEME_DEVICE_DEFAULT_LIGHT = 5;
}

