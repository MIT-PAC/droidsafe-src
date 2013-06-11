package com.android.internal.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import com.android.internal.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class AlertController {
    private final Context mContext;
    private final DialogInterface mDialogInterface;
    private final Window mWindow;
    private CharSequence mTitle;
    private CharSequence mMessage;
    private ListView mListView;
    private View mView;
    private int mViewSpacingLeft;
    private int mViewSpacingTop;
    private int mViewSpacingRight;
    private int mViewSpacingBottom;
    private boolean mViewSpacingSpecified = false;
    private Button mButtonPositive;
    private CharSequence mButtonPositiveText;
    private Message mButtonPositiveMessage;
    private Button mButtonNegative;
    private CharSequence mButtonNegativeText;
    private Message mButtonNegativeMessage;
    private Button mButtonNeutral;
    private CharSequence mButtonNeutralText;
    private Message mButtonNeutralMessage;
    private ScrollView mScrollView;
    private int mIconId = -1;
    private Drawable mIcon;
    private ImageView mIconView;
    private TextView mTitleView;
    private TextView mMessageView;
    private View mCustomTitleView;
    private boolean mForceInverseBackground;
    private ListAdapter mAdapter;
    private int mCheckedItem = -1;
    private int mAlertDialogLayout;
    private int mListLayout;
    private int mMultiChoiceItemLayout;
    private int mSingleChoiceItemLayout;
    private int mListItemLayout;
    private Handler mHandler;
    View.OnClickListener mButtonHandler = new View.OnClickListener() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.450 -0400", hash_original_method = "23692F5F6532A376A1C310E4C1F7AE36", hash_generated_method = "96E5E4D7BD490AB88A77F84E006558A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onClick(View v) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(v.dsTaint);
            Message m;
            m = null;
            {
                m = Message.obtain(mButtonPositiveMessage);
            } //End block
            {
                m = Message.obtain(mButtonNegativeMessage);
            } //End block
            {
                m = Message.obtain(mButtonNeutralMessage);
            } //End block
            {
                m.sendToTarget();
            } //End block
            mHandler.obtainMessage(ButtonHandler.MSG_DISMISS_DIALOG, mDialogInterface)
                    .sendToTarget();
            // ---------- Original Method ----------
            //Message m = null;
            //if (v == mButtonPositive && mButtonPositiveMessage != null) {
                //m = Message.obtain(mButtonPositiveMessage);
            //} else if (v == mButtonNegative && mButtonNegativeMessage != null) {
                //m = Message.obtain(mButtonNegativeMessage);
            //} else if (v == mButtonNeutral && mButtonNeutralMessage != null) {
                //m = Message.obtain(mButtonNeutralMessage);
            //}
            //if (m != null) {
                //m.sendToTarget();
            //}
            //mHandler.obtainMessage(ButtonHandler.MSG_DISMISS_DIALOG, mDialogInterface)
                    //.sendToTarget();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.451 -0400", hash_original_method = "1F16FD36E11C30DD7C480C9A0A11F40F", hash_generated_method = "0E0631E72F1D52C7E60AF8FE14E93432")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AlertController(Context context, DialogInterface di, Window window) {
        dsTaint.addTaint(di.dsTaint);
        dsTaint.addTaint(window.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mHandler = new ButtonHandler(di);
        TypedArray a;
        a = context.obtainStyledAttributes(null,
                com.android.internal.R.styleable.AlertDialog,
                com.android.internal.R.attr.alertDialogStyle, 0);
        mAlertDialogLayout = a.getResourceId(com.android.internal.R.styleable.AlertDialog_layout,
                com.android.internal.R.layout.alert_dialog);
        mListLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_listLayout,
                com.android.internal.R.layout.select_dialog);
        mMultiChoiceItemLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_multiChoiceItemLayout,
                com.android.internal.R.layout.select_dialog_multichoice);
        mSingleChoiceItemLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_singleChoiceItemLayout,
                com.android.internal.R.layout.select_dialog_singlechoice);
        mListItemLayout = a.getResourceId(
                com.android.internal.R.styleable.AlertDialog_listItemLayout,
                com.android.internal.R.layout.select_dialog_item);
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.451 -0400", hash_original_method = "72DE9F1667F0AC69B84EC6B497C20732", hash_generated_method = "8B4C999718DE3CFEA840007E7081B23B")
    private static boolean shouldCenterSingleButton(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(com.android.internal.R.attr.alertDialogCenterButtons,
                outValue, true);
        return outValue.data != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.451 -0400", hash_original_method = "71B58AF2F457DFA0A129B301D5386B40", hash_generated_method = "2C9AAF0AB02E0D558666791D023EC365")
    static boolean canTextInput(View v) {
        if (v.onCheckIsTextEditor()) {
            return true;
        }
        if (!(v instanceof ViewGroup)) {
            return false;
        }
        ViewGroup vg = (ViewGroup)v;
        int i = vg.getChildCount();
        while (i > 0) {
            i--;
            v = vg.getChildAt(i);
            if (canTextInput(v)) {
                return true;
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.451 -0400", hash_original_method = "9A4AA3E1D6FBAA7AEFBA0C5C78FA5BFD", hash_generated_method = "CCDC1D08D7DC8CA7C2031E6654B19194")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void installContent() {
        mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        {
            boolean varAB694981E47E161D0D13D676835C3CCC_1820769909 = (mView == null || !canTextInput(mView));
            {
                mWindow.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                    WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            } //End block
        } //End collapsed parenthetic
        mWindow.setContentView(mAlertDialogLayout);
        setupView();
        // ---------- Original Method ----------
        //mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        //if (mView == null || !canTextInput(mView)) {
            //mWindow.setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                    //WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        //}
        //mWindow.setContentView(mAlertDialogLayout);
        //setupView();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.451 -0400", hash_original_method = "27E388CB8AFA6CAD5DDDE89F3EB645E1", hash_generated_method = "518471A79CC577396B1C4305789D4015")
    @DSModeled(DSC.SAFE)
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        {
            mTitleView.setText(title);
        } //End block
        // ---------- Original Method ----------
        //mTitle = title;
        //if (mTitleView != null) {
            //mTitleView.setText(title);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.451 -0400", hash_original_method = "94C17D404D39F375178D63AA6F858393", hash_generated_method = "9A46DA74E900396BC5E2A036409AA8BB")
    @DSModeled(DSC.SAFE)
    public void setCustomTitle(View customTitleView) {
        dsTaint.addTaint(customTitleView.dsTaint);
        // ---------- Original Method ----------
        //mCustomTitleView = customTitleView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.451 -0400", hash_original_method = "BE4B8F8527E733138AAA8E77FCFD81CC", hash_generated_method = "29F805229B26EBBE5E826CA9945E0429")
    @DSModeled(DSC.SAFE)
    public void setMessage(CharSequence message) {
        dsTaint.addTaint(message);
        {
            mMessageView.setText(message);
        } //End block
        // ---------- Original Method ----------
        //mMessage = message;
        //if (mMessageView != null) {
            //mMessageView.setText(message);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.451 -0400", hash_original_method = "042A2BE3A9972DB9108969963EFE2152", hash_generated_method = "D7C2FE55002C3CBEC9BEEDF3B800D6AE")
    @DSModeled(DSC.SAFE)
    public void setView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mViewSpacingSpecified = false;
        // ---------- Original Method ----------
        //mView = view;
        //mViewSpacingSpecified = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.452 -0400", hash_original_method = "2847E990E96B77DB4BD87DDDB577F2D4", hash_generated_method = "72D590C903BD82BC557364C836FC9D6D")
    @DSModeled(DSC.SAFE)
    public void setView(View view, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight,
            int viewSpacingBottom) {
        dsTaint.addTaint(viewSpacingBottom);
        dsTaint.addTaint(viewSpacingTop);
        dsTaint.addTaint(viewSpacingRight);
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(viewSpacingLeft);
        mViewSpacingSpecified = true;
        // ---------- Original Method ----------
        //mView = view;
        //mViewSpacingSpecified = true;
        //mViewSpacingLeft = viewSpacingLeft;
        //mViewSpacingTop = viewSpacingTop;
        //mViewSpacingRight = viewSpacingRight;
        //mViewSpacingBottom = viewSpacingBottom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.452 -0400", hash_original_method = "F0CE922A10C717C707A211DED1E4F7AA", hash_generated_method = "E3215D187E5F7FB6D7A350B4790FC565")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setButton(int whichButton, CharSequence text,
            DialogInterface.OnClickListener listener, Message msg) {
        dsTaint.addTaint(whichButton);
        dsTaint.addTaint(text);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(msg.dsTaint);
        {
            msg = mHandler.obtainMessage(whichButton, listener);
        } //End block
        //Begin case default 
        throw new IllegalArgumentException("Button does not exist");
        //End case default 
        // ---------- Original Method ----------
        //if (msg == null && listener != null) {
            //msg = mHandler.obtainMessage(whichButton, listener);
        //}
        //switch (whichButton) {
            //case DialogInterface.BUTTON_POSITIVE:
                //mButtonPositiveText = text;
                //mButtonPositiveMessage = msg;
                //break;
            //case DialogInterface.BUTTON_NEGATIVE:
                //mButtonNegativeText = text;
                //mButtonNegativeMessage = msg;
                //break;
            //case DialogInterface.BUTTON_NEUTRAL:
                //mButtonNeutralText = text;
                //mButtonNeutralMessage = msg;
                //break;
            //default:
                //throw new IllegalArgumentException("Button does not exist");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.452 -0400", hash_original_method = "FB4271E4605E30D98972B290FB7DEC88", hash_generated_method = "A9FB0BDE897093656D4F482B769DAA84")
    @DSModeled(DSC.SAFE)
    public void setIcon(int resId) {
        dsTaint.addTaint(resId);
        {
            {
                mIconView.setImageResource(mIconId);
            } //End block
            {
                mIconView.setVisibility(View.GONE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mIconId = resId;
        //if (mIconView != null) {
            //if (resId > 0) {
                //mIconView.setImageResource(mIconId);
            //} else if (resId == 0) {
                //mIconView.setVisibility(View.GONE);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.452 -0400", hash_original_method = "5C2407A3F3458DD1635D398D03E8F03F", hash_generated_method = "677ED06CCEE791EAE98FED681286A46A")
    @DSModeled(DSC.SAFE)
    public void setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        {
            mIconView.setImageDrawable(icon);
        } //End block
        // ---------- Original Method ----------
        //mIcon = icon;
        //if ((mIconView != null) && (mIcon != null)) {
            //mIconView.setImageDrawable(icon);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.452 -0400", hash_original_method = "19D779B93DDFF4465E595606B06C3EFE", hash_generated_method = "2B55714BAB5BC4B9517B4F7B02012F62")
    @DSModeled(DSC.SAFE)
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        dsTaint.addTaint(forceInverseBackground);
        // ---------- Original Method ----------
        //mForceInverseBackground = forceInverseBackground;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.452 -0400", hash_original_method = "3273CA9467A607A59D9BD9C18D0394BC", hash_generated_method = "2A4C294D0062FE22989A5E95F0757B9B")
    @DSModeled(DSC.SAFE)
    public ListView getListView() {
        return (ListView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mListView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.452 -0400", hash_original_method = "3833583B80F66F9531985629B1AE2E3F", hash_generated_method = "6E614C3D20B048763224787C198FF46A")
    @DSModeled(DSC.SAFE)
    public Button getButton(int whichButton) {
        dsTaint.addTaint(whichButton);
        return (Button)dsTaint.getTaint();
        // ---------- Original Method ----------
        //switch (whichButton) {
            //case DialogInterface.BUTTON_POSITIVE:
                //return mButtonPositive;
            //case DialogInterface.BUTTON_NEGATIVE:
                //return mButtonNegative;
            //case DialogInterface.BUTTON_NEUTRAL:
                //return mButtonNeutral;
            //default:
                //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.452 -0400", hash_original_method = "B7833AF2811E127AB8391879126162ED", hash_generated_method = "DAF9E503AD41313A9AED92D4622EDA0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedDeclaration"})
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        boolean varB0629CF80F4172C61489257E2E1A4A2C_1260984993 = (mScrollView != null && mScrollView.executeKeyEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollView != null && mScrollView.executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.452 -0400", hash_original_method = "98FE899904FE72C0DB5091897F5A09B0", hash_generated_method = "15CD33B0584320E26B15F4D033D736F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedDeclaration"})
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        boolean varB0629CF80F4172C61489257E2E1A4A2C_1356018670 = (mScrollView != null && mScrollView.executeKeyEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollView != null && mScrollView.executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.453 -0400", hash_original_method = "0CE32455CB333C36B4EB85B89D65D186", hash_generated_method = "B44AF9B1D15F47ED84E62B2E5000D371")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupView() {
        LinearLayout contentPanel;
        contentPanel = (LinearLayout) mWindow.findViewById(R.id.contentPanel);
        setupContent(contentPanel);
        boolean hasButtons;
        hasButtons = setupButtons();
        LinearLayout topPanel;
        topPanel = (LinearLayout) mWindow.findViewById(R.id.topPanel);
        TypedArray a;
        a = mContext.obtainStyledAttributes(
                null, com.android.internal.R.styleable.AlertDialog, com.android.internal.R.attr.alertDialogStyle, 0);
        boolean hasTitle;
        hasTitle = setupTitle(topPanel);
        View buttonPanel;
        buttonPanel = mWindow.findViewById(R.id.buttonPanel);
        {
            buttonPanel.setVisibility(View.GONE);
            mWindow.setCloseOnTouchOutsideIfNotSet(true);
        } //End block
        FrameLayout customPanel;
        customPanel = null;
        {
            customPanel = (FrameLayout) mWindow.findViewById(R.id.customPanel);
            FrameLayout custom;
            custom = (FrameLayout) mWindow.findViewById(R.id.custom);
            custom.addView(mView, new LayoutParams(MATCH_PARENT, MATCH_PARENT));
            {
                custom.setPadding(mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight,
                        mViewSpacingBottom);
            } //End block
            {
                ((LinearLayout.LayoutParams) customPanel.getLayoutParams()).weight = 0;
            } //End block
        } //End block
        {
            mWindow.findViewById(R.id.customPanel).setVisibility(View.GONE);
        } //End block
        {
            View divider;
            divider = null;
            {
                divider = mWindow.findViewById(R.id.titleDivider);
            } //End block
            {
                divider = mWindow.findViewById(R.id.titleDividerTop);
            } //End block
            {
                divider.setVisibility(View.VISIBLE);
            } //End block
        } //End block
        setBackground(topPanel, contentPanel, customPanel, hasButtons, a, hasTitle, buttonPanel);
        a.recycle();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.453 -0400", hash_original_method = "291261EC5A45F15B0AF035A0FADD9120", hash_generated_method = "D818D568DECBF9A216326DC96359CEA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setupTitle(LinearLayout topPanel) {
        dsTaint.addTaint(topPanel.dsTaint);
        boolean hasTitle;
        hasTitle = true;
        {
            LinearLayout.LayoutParams lp;
            lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            topPanel.addView(mCustomTitleView, 0, lp);
            View titleTemplate;
            titleTemplate = mWindow.findViewById(R.id.title_template);
            titleTemplate.setVisibility(View.GONE);
        } //End block
        {
            final boolean hasTextTitle;
            hasTextTitle = !TextUtils.isEmpty(mTitle);
            mIconView = (ImageView) mWindow.findViewById(R.id.icon);
            {
                mTitleView = (TextView) mWindow.findViewById(R.id.alertTitle);
                mTitleView.setText(mTitle);
                {
                    mIconView.setImageResource(mIconId);
                } //End block
                {
                    mIconView.setImageDrawable(mIcon);
                } //End block
                {
                    mTitleView.setPadding(mIconView.getPaddingLeft(),
                            mIconView.getPaddingTop(),
                            mIconView.getPaddingRight(),
                            mIconView.getPaddingBottom());
                    mIconView.setVisibility(View.GONE);
                } //End block
            } //End block
            {
                View titleTemplate;
                titleTemplate = mWindow.findViewById(R.id.title_template);
                titleTemplate.setVisibility(View.GONE);
                mIconView.setVisibility(View.GONE);
                topPanel.setVisibility(View.GONE);
                hasTitle = false;
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.453 -0400", hash_original_method = "887622C8B8EC01B1F9012F53B044827B", hash_generated_method = "713D96C604C7EF7A0AB5018EF38C1797")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupContent(LinearLayout contentPanel) {
        dsTaint.addTaint(contentPanel.dsTaint);
        mScrollView = (ScrollView) mWindow.findViewById(R.id.scrollView);
        mScrollView.setFocusable(false);
        mMessageView = (TextView) mWindow.findViewById(R.id.message);
        {
            mMessageView.setText(mMessage);
        } //End block
        {
            mMessageView.setVisibility(View.GONE);
            mScrollView.removeView(mMessageView);
            {
                contentPanel.removeView(mWindow.findViewById(R.id.scrollView));
                contentPanel.addView(mListView,
                        new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));
                contentPanel.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT, 0, 1.0f));
            } //End block
            {
                contentPanel.setVisibility(View.GONE);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.454 -0400", hash_original_method = "5BA34AF0614F863A3B9D6C4A8679B5AF", hash_generated_method = "5190E002D6383C74EE0EB255695ECF8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean setupButtons() {
        int BIT_BUTTON_POSITIVE;
        BIT_BUTTON_POSITIVE = 1;
        int BIT_BUTTON_NEGATIVE;
        BIT_BUTTON_NEGATIVE = 2;
        int BIT_BUTTON_NEUTRAL;
        BIT_BUTTON_NEUTRAL = 4;
        int whichButtons;
        whichButtons = 0;
        mButtonPositive = (Button) mWindow.findViewById(R.id.button1);
        mButtonPositive.setOnClickListener(mButtonHandler);
        {
            boolean var93FA727FD667414F3938FEED09717F2A_1138478764 = (TextUtils.isEmpty(mButtonPositiveText));
            {
                mButtonPositive.setVisibility(View.GONE);
            } //End block
            {
                mButtonPositive.setText(mButtonPositiveText);
                mButtonPositive.setVisibility(View.VISIBLE);
                whichButtons = whichButtons | BIT_BUTTON_POSITIVE;
            } //End block
        } //End collapsed parenthetic
        mButtonNegative = (Button) mWindow.findViewById(R.id.button2);
        mButtonNegative.setOnClickListener(mButtonHandler);
        {
            boolean var505565EA7766DA4AFDFEB9FF9ACE7D96_78415725 = (TextUtils.isEmpty(mButtonNegativeText));
            {
                mButtonNegative.setVisibility(View.GONE);
            } //End block
            {
                mButtonNegative.setText(mButtonNegativeText);
                mButtonNegative.setVisibility(View.VISIBLE);
                whichButtons = whichButtons | BIT_BUTTON_NEGATIVE;
            } //End block
        } //End collapsed parenthetic
        mButtonNeutral = (Button) mWindow.findViewById(R.id.button3);
        mButtonNeutral.setOnClickListener(mButtonHandler);
        {
            boolean var5386D208F588E97ACB39A369F476A793_713275795 = (TextUtils.isEmpty(mButtonNeutralText));
            {
                mButtonNeutral.setVisibility(View.GONE);
            } //End block
            {
                mButtonNeutral.setText(mButtonNeutralText);
                mButtonNeutral.setVisibility(View.VISIBLE);
                whichButtons = whichButtons | BIT_BUTTON_NEUTRAL;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var4F7576D2B8F76BB57F10978A4D9C1675_638499113 = (shouldCenterSingleButton(mContext));
            {
                {
                    centerButton(mButtonPositive);
                } //End block
                {
                    centerButton(mButtonNeutral);
                } //End block
                {
                    centerButton(mButtonNeutral);
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.454 -0400", hash_original_method = "28BC3CB500322D129CBA8E7C7A78AD5A", hash_generated_method = "7A7560304D37817910F6E2F6F53503F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void centerButton(Button button) {
        dsTaint.addTaint(button.dsTaint);
        LinearLayout.LayoutParams params;
        params = (LinearLayout.LayoutParams) button.getLayoutParams();
        params.gravity = Gravity.CENTER_HORIZONTAL;
        params.weight = 0.5f;
        button.setLayoutParams(params);
        View leftSpacer;
        leftSpacer = mWindow.findViewById(R.id.leftSpacer);
        {
            leftSpacer.setVisibility(View.VISIBLE);
        } //End block
        View rightSpacer;
        rightSpacer = mWindow.findViewById(R.id.rightSpacer);
        {
            rightSpacer.setVisibility(View.VISIBLE);
        } //End block
        // ---------- Original Method ----------
        //LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) button.getLayoutParams();
        //params.gravity = Gravity.CENTER_HORIZONTAL;
        //params.weight = 0.5f;
        //button.setLayoutParams(params);
        //View leftSpacer = mWindow.findViewById(R.id.leftSpacer);
        //if (leftSpacer != null) {
            //leftSpacer.setVisibility(View.VISIBLE);
        //}
        //View rightSpacer = mWindow.findViewById(R.id.rightSpacer);
        //if (rightSpacer != null) {
            //rightSpacer.setVisibility(View.VISIBLE);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.454 -0400", hash_original_method = "6198B5046244FDCE77443F1833B74949", hash_generated_method = "A52F809A47F26DAAA7C8FBE4C156CEBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setBackground(LinearLayout topPanel, LinearLayout contentPanel,
            View customPanel, boolean hasButtons, TypedArray a, boolean hasTitle, 
            View buttonPanel) {
        dsTaint.addTaint(contentPanel.dsTaint);
        dsTaint.addTaint(a.dsTaint);
        dsTaint.addTaint(hasTitle);
        dsTaint.addTaint(hasButtons);
        dsTaint.addTaint(buttonPanel.dsTaint);
        dsTaint.addTaint(topPanel.dsTaint);
        dsTaint.addTaint(customPanel.dsTaint);
        int fullDark;
        fullDark = a.getResourceId(
                R.styleable.AlertDialog_fullDark, R.drawable.popup_full_dark);
        int topDark;
        topDark = a.getResourceId(
                R.styleable.AlertDialog_topDark, R.drawable.popup_top_dark);
        int centerDark;
        centerDark = a.getResourceId(
                R.styleable.AlertDialog_centerDark, R.drawable.popup_center_dark);
        int bottomDark;
        bottomDark = a.getResourceId(
                R.styleable.AlertDialog_bottomDark, R.drawable.popup_bottom_dark);
        int fullBright;
        fullBright = a.getResourceId(
                R.styleable.AlertDialog_fullBright, R.drawable.popup_full_bright);
        int topBright;
        topBright = a.getResourceId(
                R.styleable.AlertDialog_topBright, R.drawable.popup_top_bright);
        int centerBright;
        centerBright = a.getResourceId(
                R.styleable.AlertDialog_centerBright, R.drawable.popup_center_bright);
        int bottomBright;
        bottomBright = a.getResourceId(
                R.styleable.AlertDialog_bottomBright, R.drawable.popup_bottom_bright);
        int bottomMedium;
        bottomMedium = a.getResourceId(
                R.styleable.AlertDialog_bottomMedium, R.drawable.popup_bottom_medium);
        View[] views;
        views = new View[4];
        boolean[] light;
        light = new boolean[4];
        View lastView;
        lastView = null;
        boolean lastLight;
        lastLight = false;
        int pos;
        pos = 0;
        {
            views[pos] = topPanel;
            light[pos] = false;
            pos++;
        } //End block
        views[pos] = (contentPanel.getVisibility() == View.GONE) 
                ? null : contentPanel;
        light[pos] = mListView != null;
        pos++;
        {
            views[pos] = customPanel;
            light[pos] = mForceInverseBackground;
            pos++;
        } //End block
        {
            views[pos] = buttonPanel;
            light[pos] = true;
        } //End block
        boolean setView;
        setView = false;
        {
            pos=0;
            {
                View v;
                v = views[pos];
                {
                    {
                        lastView.setBackgroundResource(lastLight ? topBright : topDark);
                    } //End block
                    {
                        lastView.setBackgroundResource(lastLight ? centerBright : centerDark);
                    } //End block
                    setView = true;
                } //End block
                lastView = v;
                lastLight = light[pos];
            } //End block
        } //End collapsed parenthetic
        {
            {
                lastView.setBackgroundResource(
                        lastLight ? (hasButtons ? bottomMedium : bottomBright) : bottomDark);
            } //End block
            {
                lastView.setBackgroundResource(lastLight ? fullBright : fullDark);
            } //End block
        } //End block
        {
            mListView.setAdapter(mAdapter);
            {
                mListView.setItemChecked(mCheckedItem, true);
                mListView.setSelection(mCheckedItem);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final class ButtonHandler extends Handler {
        private static final int MSG_DISMISS_DIALOG = 1;
        private WeakReference<DialogInterface> mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.454 -0400", hash_original_method = "94BD8A25739D33DF469E488FF271595A", hash_generated_method = "D56E5ADF56A8F57ADE694D4C0F89F888")
        @DSModeled(DSC.SAFE)
        public ButtonHandler(DialogInterface dialog) {
            dsTaint.addTaint(dialog.dsTaint);
            mDialog = new WeakReference<DialogInterface>(dialog);
            // ---------- Original Method ----------
            //mDialog = new WeakReference<DialogInterface>(dialog);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.455 -0400", hash_original_method = "278B02327B6D097A80A5697E74542815", hash_generated_method = "1C0AB342CDA4FD6A4691B63EFDB40F45")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case DialogInterface.BUTTON_POSITIVE DialogInterface.BUTTON_NEGATIVE DialogInterface.BUTTON_NEUTRAL 
            ((DialogInterface.OnClickListener) msg.obj).onClick(mDialog.get(), msg.what);
            //End case DialogInterface.BUTTON_POSITIVE DialogInterface.BUTTON_NEGATIVE DialogInterface.BUTTON_NEUTRAL 
            //Begin case MSG_DISMISS_DIALOG 
            ((DialogInterface) msg.obj).dismiss();
            //End case MSG_DISMISS_DIALOG 
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case DialogInterface.BUTTON_POSITIVE:
                //case DialogInterface.BUTTON_NEGATIVE:
                //case DialogInterface.BUTTON_NEUTRAL:
                    //((DialogInterface.OnClickListener) msg.obj).onClick(mDialog.get(), msg.what);
                    //break;
                //case MSG_DISMISS_DIALOG:
                    //((DialogInterface) msg.obj).dismiss();
            //}
        }

        
    }


    
    public static class RecycleListView extends ListView {
        boolean mRecycleOnMeasure = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.455 -0400", hash_original_method = "EE9FD5306D2F93DFDAA34BAADCE625A8", hash_generated_method = "52C624DA345D6C2FCAC95AA106F69169")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RecycleListView(Context context) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.455 -0400", hash_original_method = "FD9F3D8D98E58119FCDEC82734593D0D", hash_generated_method = "4ED77AE905863AF8DCCB51211E8F966B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RecycleListView(Context context, AttributeSet attrs) {
            super(context, attrs);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.455 -0400", hash_original_method = "B696B9456EBFFE7A743BD389E8B7B605", hash_generated_method = "9E51975F778955AA433DDE62212EA4E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RecycleListView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(defStyle);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.455 -0400", hash_original_method = "9DCA0509220194E0D65C0AA0793BD261", hash_generated_method = "C86D6E0F22720202BF3BF6A9C2A782B6")
        @DSModeled(DSC.SAFE)
        @Override
        protected boolean recycleOnMeasure() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mRecycleOnMeasure;
        }

        
    }


    
    public static class AlertParams {
        public final Context mContext;
        public final LayoutInflater mInflater;
        public int mIconId = 0;
        public Drawable mIcon;
        public CharSequence mTitle;
        public View mCustomTitleView;
        public CharSequence mMessage;
        public CharSequence mPositiveButtonText;
        public DialogInterface.OnClickListener mPositiveButtonListener;
        public CharSequence mNegativeButtonText;
        public DialogInterface.OnClickListener mNegativeButtonListener;
        public CharSequence mNeutralButtonText;
        public DialogInterface.OnClickListener mNeutralButtonListener;
        public boolean mCancelable;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public CharSequence[] mItems;
        public ListAdapter mAdapter;
        public DialogInterface.OnClickListener mOnClickListener;
        public View mView;
        public int mViewSpacingLeft;
        public int mViewSpacingTop;
        public int mViewSpacingRight;
        public int mViewSpacingBottom;
        public boolean mViewSpacingSpecified = false;
        public boolean[] mCheckedItems;
        public boolean mIsMultiChoice;
        public boolean mIsSingleChoice;
        public int mCheckedItem = -1;
        public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
        public Cursor mCursor;
        public String mLabelColumn;
        public String mIsCheckedColumn;
        public boolean mForceInverseBackground;
        public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
        public OnPrepareListViewListener mOnPrepareListViewListener;
        public boolean mRecycleOnMeasure = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.455 -0400", hash_original_method = "30F42D5772B75365825E237386B4299E", hash_generated_method = "F1AC1D2390F1C9DA7A345D58F84EB6EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AlertParams(Context context) {
            dsTaint.addTaint(context.dsTaint);
            mCancelable = true;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // ---------- Original Method ----------
            //mContext = context;
            //mCancelable = true;
            //mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.455 -0400", hash_original_method = "80497DB7CC0D98B7F92FD843E557F0AA", hash_generated_method = "B0DD20CD6BCB6A95FE0D1963ACD4C5E6")
        @DSModeled(DSC.SAFE)
        public void apply(AlertController dialog) {
            dsTaint.addTaint(dialog.dsTaint);
            {
                dialog.setCustomTitle(mCustomTitleView);
            } //End block
            {
                {
                    dialog.setTitle(mTitle);
                } //End block
                {
                    dialog.setIcon(mIcon);
                } //End block
                {
                    dialog.setIcon(mIconId);
                } //End block
            } //End block
            {
                dialog.setMessage(mMessage);
            } //End block
            {
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, mPositiveButtonText,
                        mPositiveButtonListener, null);
            } //End block
            {
                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, mNegativeButtonText,
                        mNegativeButtonListener, null);
            } //End block
            {
                dialog.setButton(DialogInterface.BUTTON_NEUTRAL, mNeutralButtonText,
                        mNeutralButtonListener, null);
            } //End block
            {
                dialog.setInverseBackgroundForced(true);
            } //End block
            {
                createListView(dialog);
            } //End block
            {
                {
                    dialog.setView(mView, mViewSpacingLeft, mViewSpacingTop, mViewSpacingRight,
                            mViewSpacingBottom);
                } //End block
                {
                    dialog.setView(mView);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.456 -0400", hash_original_method = "8E786D28D6E36F7AAC42E3AE032D9CF8", hash_generated_method = "83A58F20AE6F69A1365707F4BEAD0B8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void createListView(final AlertController dialog) {
            dsTaint.addTaint(dialog.dsTaint);
            final RecycleListView listView;
            listView = (RecycleListView)
                    mInflater.inflate(dialog.mListLayout, null);
            ListAdapter adapter;
            {
                {
                    adapter = new ArrayAdapter<CharSequence>(
                            mContext, dialog.mMultiChoiceItemLayout, R.id.text1, mItems) {
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);
                            if (mCheckedItems != null) {
                                boolean isItemChecked = mCheckedItems[position];
                                if (isItemChecked) {
                                    listView.setItemChecked(position, true);
                                }
                            }
                            return view;
                        }
                    };
                } //End block
                {
                    adapter = new CursorAdapter(mContext, mCursor, false) {
                        private final int mLabelIndex;
                        private final int mIsCheckedIndex;
                        {
                            final Cursor cursor = getCursor();
                            mLabelIndex = cursor.getColumnIndexOrThrow(mLabelColumn);
                            mIsCheckedIndex = cursor.getColumnIndexOrThrow(mIsCheckedColumn);
                        }
                        @Override
                        public void bindView(View view, Context context, Cursor cursor) {
                            CheckedTextView text = (CheckedTextView) view.findViewById(R.id.text1);
                            text.setText(cursor.getString(mLabelIndex));
                            listView.setItemChecked(cursor.getPosition(),
                                    cursor.getInt(mIsCheckedIndex) == 1);
                        }
                        @Override
                        public View newView(Context context, Cursor cursor, ViewGroup parent) {
                            return mInflater.inflate(dialog.mMultiChoiceItemLayout,
                                    parent, false);
                        }
                    };
                } //End block
            } //End block
            {
                int layout;
                layout = dialog.mSingleChoiceItemLayout;
                layout = dialog.mListItemLayout;
                {
                    adapter = (mAdapter != null) ? mAdapter
                            : new ArrayAdapter<CharSequence>(mContext, layout, R.id.text1, mItems);
                } //End block
                {
                    adapter = new SimpleCursorAdapter(mContext, layout, 
                            mCursor, new String[]{mLabelColumn}, new int[]{R.id.text1});
                } //End block
            } //End block
            {
                mOnPrepareListViewListener.onPrepareListView(listView);
            } //End block
            dialog.mAdapter = adapter;
            dialog.mCheckedItem = mCheckedItem;
            {
                listView.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        mOnClickListener.onClick(dialog.mDialogInterface, position);
                        if (!mIsSingleChoice) {
                            dialog.mDialogInterface.dismiss();
                        }
                    }
                });
            } //End block
            {
                listView.setOnItemClickListener(new OnItemClickListener() {
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        if (mCheckedItems != null) {
                            mCheckedItems[position] = listView.isItemChecked(position);
                        }
                        mOnCheckboxClickListener.onClick(
                                dialog.mDialogInterface, position, listView.isItemChecked(position));
                    }
                });
            } //End block
            {
                listView.setOnItemSelectedListener(mOnItemSelectedListener);
            } //End block
            {
                listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            } //End block
            {
                listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
            } //End block
            listView.mRecycleOnMeasure = mRecycleOnMeasure;
            dialog.mListView = listView;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public interface OnPrepareListViewListener {
            
            
            void onPrepareListView(ListView listView);
        }
        
    }


    
}


