package com.android.internal.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private Context mContext;
    private DialogInterface mDialogInterface;
    private Window mWindow;
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.979 -0400", hash_original_method = "23692F5F6532A376A1C310E4C1F7AE36", hash_generated_method = "0CB99187E04918FF9E8D6FA3509185A3")
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.980 -0400", hash_original_method = "1F16FD36E11C30DD7C480C9A0A11F40F", hash_generated_method = "9FC43571B8520A234760232E364BE938")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AlertController(Context context, DialogInterface di, Window window) {
        dsTaint.addTaint(window.dsTaint);
        dsTaint.addTaint(di.dsTaint);
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

    
        private static boolean shouldCenterSingleButton(Context context) {
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(com.android.internal.R.attr.alertDialogCenterButtons,
                outValue, true);
        return outValue.data != 0;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.981 -0400", hash_original_method = "9A4AA3E1D6FBAA7AEFBA0C5C78FA5BFD", hash_generated_method = "6EEF9F57A3204B99A2F5A8AAAD996E47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void installContent() {
        mWindow.requestFeature(Window.FEATURE_NO_TITLE);
        {
            boolean varAB694981E47E161D0D13D676835C3CCC_916784855 = (mView == null || !canTextInput(mView));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.981 -0400", hash_original_method = "27E388CB8AFA6CAD5DDDE89F3EB645E1", hash_generated_method = "B1FE80842E0634EE749D18879F536A1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.981 -0400", hash_original_method = "94C17D404D39F375178D63AA6F858393", hash_generated_method = "D6AFB75439627B8FF878A0BAABD57C7A")
    @DSModeled(DSC.SAFE)
    public void setCustomTitle(View customTitleView) {
        dsTaint.addTaint(customTitleView.dsTaint);
        // ---------- Original Method ----------
        //mCustomTitleView = customTitleView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.981 -0400", hash_original_method = "BE4B8F8527E733138AAA8E77FCFD81CC", hash_generated_method = "29F15FAD51724FBE9CD9AE8F5CB0731C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.982 -0400", hash_original_method = "042A2BE3A9972DB9108969963EFE2152", hash_generated_method = "E716F4C9C03774102710961E0D20CE74")
    @DSModeled(DSC.SAFE)
    public void setView(View view) {
        dsTaint.addTaint(view.dsTaint);
        mViewSpacingSpecified = false;
        // ---------- Original Method ----------
        //mView = view;
        //mViewSpacingSpecified = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.982 -0400", hash_original_method = "2847E990E96B77DB4BD87DDDB577F2D4", hash_generated_method = "428C0D90D03C69A49FAEC54B3FFA7EF0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.982 -0400", hash_original_method = "F0CE922A10C717C707A211DED1E4F7AA", hash_generated_method = "8C2B621EDD7A76C4C349A02C97013CD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setButton(int whichButton, CharSequence text,
            DialogInterface.OnClickListener listener, Message msg) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(whichButton);
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(msg.dsTaint);
        {
            msg = mHandler.obtainMessage(whichButton, listener);
        } //End block
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Button does not exist");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.983 -0400", hash_original_method = "FB4271E4605E30D98972B290FB7DEC88", hash_generated_method = "219BF3DCDDFAC0F21044B9E1852A4AA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.983 -0400", hash_original_method = "5C2407A3F3458DD1635D398D03E8F03F", hash_generated_method = "EB27594CD028C59589F12D1D05DB0DCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.983 -0400", hash_original_method = "19D779B93DDFF4465E595606B06C3EFE", hash_generated_method = "0FA161A1E29A298C59D00A2010015BF3")
    @DSModeled(DSC.SAFE)
    public void setInverseBackgroundForced(boolean forceInverseBackground) {
        dsTaint.addTaint(forceInverseBackground);
        // ---------- Original Method ----------
        //mForceInverseBackground = forceInverseBackground;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.983 -0400", hash_original_method = "3273CA9467A607A59D9BD9C18D0394BC", hash_generated_method = "47FE9C1E848C5389360B31940103F5E1")
    @DSModeled(DSC.SAFE)
    public ListView getListView() {
        return (ListView)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mListView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.983 -0400", hash_original_method = "3833583B80F66F9531985629B1AE2E3F", hash_generated_method = "5C6D0C778F04D2923CEB211392C53152")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.984 -0400", hash_original_method = "B7833AF2811E127AB8391879126162ED", hash_generated_method = "2CBCD0886A7E9305173CFA462B9CF8F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedDeclaration"})
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        boolean varB0629CF80F4172C61489257E2E1A4A2C_1388758767 = (mScrollView != null && mScrollView.executeKeyEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollView != null && mScrollView.executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.984 -0400", hash_original_method = "98FE899904FE72C0DB5091897F5A09B0", hash_generated_method = "DDBD702D3CE73662DA2A20FEAFDB4BC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings({"UnusedDeclaration"})
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(keyCode);
        dsTaint.addTaint(event.dsTaint);
        boolean varB0629CF80F4172C61489257E2E1A4A2C_1032217244 = (mScrollView != null && mScrollView.executeKeyEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mScrollView != null && mScrollView.executeKeyEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.985 -0400", hash_original_method = "0CE32455CB333C36B4EB85B89D65D186", hash_generated_method = "4DC832D561DBCF24925409DC01541B7D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.986 -0400", hash_original_method = "291261EC5A45F15B0AF035A0FADD9120", hash_generated_method = "7B8A85F087B9BB38BB22A4F7BC8B8DAF")
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
            boolean hasTextTitle;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.986 -0400", hash_original_method = "887622C8B8EC01B1F9012F53B044827B", hash_generated_method = "5C662404723921B6B66834AEE1C5D7DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.987 -0400", hash_original_method = "5BA34AF0614F863A3B9D6C4A8679B5AF", hash_generated_method = "E1C0361C6A78DC7CB30CBFF29C6DF3C0")
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
            boolean var93FA727FD667414F3938FEED09717F2A_1409953050 = (TextUtils.isEmpty(mButtonPositiveText));
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
            boolean var505565EA7766DA4AFDFEB9FF9ACE7D96_1717277686 = (TextUtils.isEmpty(mButtonNegativeText));
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
            boolean var5386D208F588E97ACB39A369F476A793_6973256 = (TextUtils.isEmpty(mButtonNeutralText));
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
            boolean var4F7576D2B8F76BB57F10978A4D9C1675_134955025 = (shouldCenterSingleButton(mContext));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.987 -0400", hash_original_method = "28BC3CB500322D129CBA8E7C7A78AD5A", hash_generated_method = "23D15850A83B86D2727D0C13DA69B5D0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.988 -0400", hash_original_method = "6198B5046244FDCE77443F1833B74949", hash_generated_method = "DF4F7762D3B1430A46667E14AF47D42F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setBackground(LinearLayout topPanel, LinearLayout contentPanel,
            View customPanel, boolean hasButtons, TypedArray a, boolean hasTitle, 
            View buttonPanel) {
        dsTaint.addTaint(a.dsTaint);
        dsTaint.addTaint(contentPanel.dsTaint);
        dsTaint.addTaint(hasTitle);
        dsTaint.addTaint(buttonPanel.dsTaint);
        dsTaint.addTaint(hasButtons);
        dsTaint.addTaint(customPanel.dsTaint);
        dsTaint.addTaint(topPanel.dsTaint);
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
        } //End block
        views[pos] = (contentPanel.getVisibility() == View.GONE) 
                ? null : contentPanel;
        light[pos] = mListView != null;
        {
            views[pos] = customPanel;
            light[pos] = mForceInverseBackground;
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
        private WeakReference<DialogInterface> mDialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.988 -0400", hash_original_method = "94BD8A25739D33DF469E488FF271595A", hash_generated_method = "23BD05D33C1ADFFD8A4EED31B5E5C8CF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ButtonHandler(DialogInterface dialog) {
            dsTaint.addTaint(dialog.dsTaint);
            mDialog = new WeakReference<DialogInterface>(dialog);
            // ---------- Original Method ----------
            //mDialog = new WeakReference<DialogInterface>(dialog);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.989 -0400", hash_original_method = "278B02327B6D097A80A5697E74542815", hash_generated_method = "EA7E65FEFBFBC305989C808893A9A672")
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

        
        private static final int MSG_DISMISS_DIALOG = 1;
    }


    
    public static class RecycleListView extends ListView {
        boolean mRecycleOnMeasure = true;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.989 -0400", hash_original_method = "EE9FD5306D2F93DFDAA34BAADCE625A8", hash_generated_method = "C1C737F906A5C6BA1A42D0C4FF55DAAB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RecycleListView(Context context) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.989 -0400", hash_original_method = "FD9F3D8D98E58119FCDEC82734593D0D", hash_generated_method = "C4D7B416CE4440C549846B39430A7286")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RecycleListView(Context context, AttributeSet attrs) {
            super(context, attrs);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.989 -0400", hash_original_method = "B696B9456EBFFE7A743BD389E8B7B605", hash_generated_method = "98F45D166CD5023824E8132EE32EC215")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public RecycleListView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            dsTaint.addTaint(attrs.dsTaint);
            dsTaint.addTaint(defStyle);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.990 -0400", hash_original_method = "9DCA0509220194E0D65C0AA0793BD261", hash_generated_method = "E001B35E981834BF4EF95D4D80A9D9F9")
        @DSModeled(DSC.SAFE)
        @Override
        protected boolean recycleOnMeasure() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mRecycleOnMeasure;
        }

        
    }


    
    public static class AlertParams {
        public Context mContext;
        public LayoutInflater mInflater;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.991 -0400", hash_original_method = "30F42D5772B75365825E237386B4299E", hash_generated_method = "748F5AEC6F7CE0B45C8AAFF4EA1E0D40")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.991 -0400", hash_original_method = "80497DB7CC0D98B7F92FD843E557F0AA", hash_generated_method = "7BDB68D82C69E637EC046C9C76EE4BC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.994 -0400", hash_original_method = "8E786D28D6E36F7AAC42E3AE032D9CF8", hash_generated_method = "53C343E8AB7B27E6B2EAD5648412CFDF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void createListView(final AlertController dialog) {
            dsTaint.addTaint(dialog.dsTaint);
            RecycleListView listView;
            listView = (RecycleListView)
                    mInflater.inflate(dialog.mListLayout, null);
            ListAdapter adapter;
            {
                {
                    adapter = new ArrayAdapter<CharSequence>(
                            mContext, dialog.mMultiChoiceItemLayout, R.id.text1, mItems) {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.992 -0400", hash_original_method = "23A354B1E3F11023EC3EF5623A4E6D9E", hash_generated_method = "FAF4FE3A308EF9BF6EF8EDB7945DBFC6")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {
                            dsTaint.addTaint(position);
                            dsTaint.addTaint(parent.dsTaint);
                            dsTaint.addTaint(convertView.dsTaint);
                            View view;
                            view = super.getView(position, convertView, parent);
                            {
                                boolean isItemChecked;
                                isItemChecked = mCheckedItems[position];
                                {
                                    listView.setItemChecked(position, true);
                                } //End block
                            } //End block
                            return (View)dsTaint.getTaint();
                            // ---------- Original Method ----------
                            //View view = super.getView(position, convertView, parent);
                            //if (mCheckedItems != null) {
                                //boolean isItemChecked = mCheckedItems[position];
                                //if (isItemChecked) {
                                    //listView.setItemChecked(position, true);
                                //}
                            //}
                            //return view;
                        }
};
                } //End block
                {
                    adapter = new CursorAdapter(mContext, mCursor, false) {                        private int mLabelIndex;
                        private int mIsCheckedIndex;
                        {
                            final Cursor cursor = getCursor();
                            mLabelIndex = cursor.getColumnIndexOrThrow(mLabelColumn);
                            mIsCheckedIndex = cursor.getColumnIndexOrThrow(mIsCheckedColumn);
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.993 -0400", hash_original_method = "9923C63783513415221DB53D1A04C6D7", hash_generated_method = "C4C9DD69860262C2B3E08BAE849A91DC")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        @Override
                        public void bindView(View view, Context context, Cursor cursor) {
                            dsTaint.addTaint(cursor.dsTaint);
                            dsTaint.addTaint(context.dsTaint);
                            dsTaint.addTaint(view.dsTaint);
                            CheckedTextView text;
                            text = (CheckedTextView) view.findViewById(R.id.text1);
                            text.setText(cursor.getString(mLabelIndex));
                            listView.setItemChecked(cursor.getPosition(),
                                    cursor.getInt(mIsCheckedIndex) == 1);
                            // ---------- Original Method ----------
                            //CheckedTextView text = (CheckedTextView) view.findViewById(R.id.text1);
                            //text.setText(cursor.getString(mLabelIndex));
                            //listView.setItemChecked(cursor.getPosition(),
                                    //cursor.getInt(mIsCheckedIndex) == 1);
                        }
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.993 -0400", hash_original_method = "87A8136D8ED8F9724DD65BD87F7B3B3A", hash_generated_method = "67612694BABB28E13231C4067044404A")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        @Override
                        public View newView(Context context, Cursor cursor, ViewGroup parent) {
                            dsTaint.addTaint(cursor.dsTaint);
                            dsTaint.addTaint(context.dsTaint);
                            dsTaint.addTaint(parent.dsTaint);
                            View varBFA033A422DC2028C029D67826147F64_1107357343 = (mInflater.inflate(dialog.mMultiChoiceItemLayout,
                                    parent, false));
                            return (View)dsTaint.getTaint();
                            // ---------- Original Method ----------
                            //return mInflater.inflate(dialog.mMultiChoiceItemLayout,
                                    //parent, false);
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
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.993 -0400", hash_original_method = "8EA9AA28841E6789D2A0900FF06F5143", hash_generated_method = "5FD3C26BB8320B658C11105A6275E130")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        dsTaint.addTaint(id);
                        dsTaint.addTaint(position);
                        dsTaint.addTaint(v.dsTaint);
                        dsTaint.addTaint(parent.dsTaint);
                        mOnClickListener.onClick(dialog.mDialogInterface, position);
                        {
                            dialog.mDialogInterface.dismiss();
                        } //End block
                        // ---------- Original Method ----------
                        //mOnClickListener.onClick(dialog.mDialogInterface, position);
                        //if (!mIsSingleChoice) {
                            //dialog.mDialogInterface.dismiss();
                        //}
                    }
});
            } //End block
            {
                listView.setOnItemClickListener(new OnItemClickListener() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:09.994 -0400", hash_original_method = "A7D02743B14CEBBCE2076709416E7025", hash_generated_method = "D9A3DCBF58F1116DD087952322B30625")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    public void onItemClick(AdapterView parent, View v, int position, long id) {
                        //DSFIXME:  CODE0009: Possible callback target function detected
                        dsTaint.addTaint(id);
                        dsTaint.addTaint(position);
                        dsTaint.addTaint(v.dsTaint);
                        dsTaint.addTaint(parent.dsTaint);
                        {
                            mCheckedItems[position] = listView.isItemChecked(position);
                        } //End block
                        mOnCheckboxClickListener.onClick(
                                dialog.mDialogInterface, position, listView.isItemChecked(position));
                        // ---------- Original Method ----------
                        //if (mCheckedItems != null) {
                            //mCheckedItems[position] = listView.isItemChecked(position);
                        //}
                        //mOnCheckboxClickListener.onClick(
                                //dialog.mDialogInterface, position, listView.isItemChecked(position));
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

