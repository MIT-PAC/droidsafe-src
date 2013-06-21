package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ActionMenuItemView extends LinearLayout implements MenuView.ItemView, View.OnClickListener, View.OnLongClickListener, ActionMenuView.ActionMenuChildView {
    private MenuItemImpl mItemData;
    private CharSequence mTitle;
    private MenuBuilder.ItemInvoker mItemInvoker;
    private ImageButton mImageButton;
    private Button mTextButton;
    private boolean mAllowTextWithIcon;
    private boolean mExpandedFormat;
    private int mMinWidth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.349 -0400", hash_original_method = "A9C9E45D494EF4E28228859D4DA5948C", hash_generated_method = "836C27FBA13AB595AD58D51346C8D421")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMenuItemView(Context context) {
        this(context, null);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.350 -0400", hash_original_method = "414C1C737BA41080151B3C84CB3C1FDA", hash_generated_method = "4813BBDC9A0AB793A24073D7DD049668")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.350 -0400", hash_original_method = "7FEBDC4FE1DC1778EBE8D4C1AD12D9F5", hash_generated_method = "A14281EA9FAA534135E43F77E789A38C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ActionMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(defStyle);
        dsTaint.addTaint(context.dsTaint);
        Resources res;
        res = context.getResources();
        mAllowTextWithIcon = res.getBoolean(
                com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
        TypedArray a;
        a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ActionMenuItemView, 0, 0);
        mMinWidth = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ActionMenuItemView_minWidth, 0);
        a.recycle();
        // ---------- Original Method ----------
        //final Resources res = context.getResources();
        //mAllowTextWithIcon = res.getBoolean(
                //com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
        //TypedArray a = context.obtainStyledAttributes(attrs,
                //com.android.internal.R.styleable.ActionMenuItemView, 0, 0);
        //mMinWidth = a.getDimensionPixelSize(
                //com.android.internal.R.styleable.ActionMenuItemView_minWidth, 0);
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.351 -0400", hash_original_method = "97E99CBFA7DAC670C6AD27C0843F8326", hash_generated_method = "B97291A5FF679C68FDE6F45741CA7D42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onFinishInflate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mImageButton = (ImageButton) findViewById(com.android.internal.R.id.imageButton);
        mTextButton = (Button) findViewById(com.android.internal.R.id.textButton);
        mImageButton.setOnClickListener(this);
        mTextButton.setOnClickListener(this);
        mImageButton.setOnLongClickListener(this);
        setOnClickListener(this);
        setOnLongClickListener(this);
        // ---------- Original Method ----------
        //mImageButton = (ImageButton) findViewById(com.android.internal.R.id.imageButton);
        //mTextButton = (Button) findViewById(com.android.internal.R.id.textButton);
        //mImageButton.setOnClickListener(this);
        //mTextButton.setOnClickListener(this);
        //mImageButton.setOnLongClickListener(this);
        //setOnClickListener(this);
        //setOnLongClickListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.352 -0400", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "DEB2C950FA1C69F3293D4DDB2C352A9E")
    @DSModeled(DSC.SAFE)
    public MenuItemImpl getItemData() {
        return (MenuItemImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mItemData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.352 -0400", hash_original_method = "F3ADD2CA2E2A1F1636EEF9ECFE1172AF", hash_generated_method = "8496D733B4954582A7DDEB2EE9D14B65")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void initialize(MenuItemImpl itemData, int menuType) {
        dsTaint.addTaint(itemData.dsTaint);
        dsTaint.addTaint(menuType);
        setIcon(itemData.getIcon());
        setTitle(itemData.getTitleForItemView(this));
        setId(itemData.getItemId());
        setVisibility(itemData.isVisible() ? View.VISIBLE : View.GONE);
        setEnabled(itemData.isEnabled());
        // ---------- Original Method ----------
        //mItemData = itemData;
        //setIcon(itemData.getIcon());
        //setTitle(itemData.getTitleForItemView(this));
        //setId(itemData.getItemId());
        //setVisibility(itemData.isVisible() ? View.VISIBLE : View.GONE);
        //setEnabled(itemData.isEnabled());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.352 -0400", hash_original_method = "CB61F2977C03C3D4A47A54A8D609CC23", hash_generated_method = "8621D41678982D31A65D3DAFC4F57FEC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabled(boolean enabled) {
        dsTaint.addTaint(enabled);
        super.setEnabled(enabled);
        mImageButton.setEnabled(enabled);
        mTextButton.setEnabled(enabled);
        // ---------- Original Method ----------
        //super.setEnabled(enabled);
        //mImageButton.setEnabled(enabled);
        //mTextButton.setEnabled(enabled);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.352 -0400", hash_original_method = "B665A21C15F294A662D29A2BA3A7A359", hash_generated_method = "C0EF9CBAAF603DCCFA770B7E8753C7D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        {
            mItemInvoker.invokeItem(mItemData);
        } //End block
        // ---------- Original Method ----------
        //if (mItemInvoker != null) {
            //mItemInvoker.invokeItem(mItemData);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.353 -0400", hash_original_method = "D4B10D907261C4745939FD5942191820", hash_generated_method = "A1494FCBD653AB727EF3D7773A39E185")
    @DSModeled(DSC.SAFE)
    public void setItemInvoker(MenuBuilder.ItemInvoker invoker) {
        dsTaint.addTaint(invoker.dsTaint);
        // ---------- Original Method ----------
        //mItemInvoker = invoker;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.353 -0400", hash_original_method = "A2F62AB27113ADE9EE493677370BEC6F", hash_generated_method = "9B0117D24BBE296475CCFE87D75EB533")
    @DSModeled(DSC.SAFE)
    public boolean prefersCondensedTitle() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.353 -0400", hash_original_method = "206C9D092F8D2CE8A945E1A45B818CB4", hash_generated_method = "43246A4B74146232F0F51D9534EE9D86")
    @DSModeled(DSC.SAFE)
    public void setCheckable(boolean checkable) {
        dsTaint.addTaint(checkable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.354 -0400", hash_original_method = "98D5E38367DB01B2323D3E891737183A", hash_generated_method = "0CEC7F419320801875E5030005446DE8")
    @DSModeled(DSC.SAFE)
    public void setChecked(boolean checked) {
        dsTaint.addTaint(checked);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.354 -0400", hash_original_method = "4B7C35F58E3B5D585DF448A46B8AF434", hash_generated_method = "592DE328EE494DBADB796CA3745F0947")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setExpandedFormat(boolean expandedFormat) {
        dsTaint.addTaint(expandedFormat);
        {
            {
                mItemData.actionFormatChanged();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mExpandedFormat != expandedFormat) {
            //mExpandedFormat = expandedFormat;
            //if (mItemData != null) {
                //mItemData.actionFormatChanged();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.354 -0400", hash_original_method = "A914366A36A1D33567DEDC1A62560744", hash_generated_method = "AED81A7E3307AC6153D8625850340F1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateTextButtonVisibility() {
        boolean visible;
        visible = !TextUtils.isEmpty(mTextButton.getText());
        visible &= mImageButton.getDrawable() == null ||
                (mItemData.showsTextAsAction() && (mAllowTextWithIcon || mExpandedFormat));
        mTextButton.setVisibility(visible ? VISIBLE : GONE);
        // ---------- Original Method ----------
        //boolean visible = !TextUtils.isEmpty(mTextButton.getText());
        //visible &= mImageButton.getDrawable() == null ||
                //(mItemData.showsTextAsAction() && (mAllowTextWithIcon || mExpandedFormat));
        //mTextButton.setVisibility(visible ? VISIBLE : GONE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.355 -0400", hash_original_method = "48979BF203DB7148CE59E9B74A531A1E", hash_generated_method = "1931EC896D6265A9289BC313EC4F4330")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setIcon(Drawable icon) {
        dsTaint.addTaint(icon.dsTaint);
        mImageButton.setImageDrawable(icon);
        {
            mImageButton.setVisibility(VISIBLE);
        } //End block
        {
            mImageButton.setVisibility(GONE);
        } //End block
        updateTextButtonVisibility();
        // ---------- Original Method ----------
        //mImageButton.setImageDrawable(icon);
        //if (icon != null) {
            //mImageButton.setVisibility(VISIBLE);
        //} else {
            //mImageButton.setVisibility(GONE);
        //}
        //updateTextButtonVisibility();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.355 -0400", hash_original_method = "DAE9552F4F404C09BF99313735727BF7", hash_generated_method = "1AE35309ECA58420ACCFCDF6AEFD5FA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasText() {
        boolean varF5FAB128084D5D7ABF824447FC5A8FC0_1012364222 = (mTextButton.getVisibility() != GONE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mTextButton.getVisibility() != GONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.355 -0400", hash_original_method = "85A41D343B47A7443CFB0CEF90E94BCA", hash_generated_method = "678FC03B66FFDDB6E89136C6E7448131")
    @DSModeled(DSC.SAFE)
    public void setShortcut(boolean showShortcut, char shortcutKey) {
        dsTaint.addTaint(showShortcut);
        dsTaint.addTaint(shortcutKey);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.355 -0400", hash_original_method = "E35411C4CA419EBD2C9EFEDC089EF32B", hash_generated_method = "DABFDB893A94A218B4A0187B41E31B52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTitle(CharSequence title) {
        dsTaint.addTaint(title);
        mTextButton.setText(mTitle);
        setContentDescription(mTitle);
        updateTextButtonVisibility();
        // ---------- Original Method ----------
        //mTitle = title;
        //mTextButton.setText(mTitle);
        //setContentDescription(mTitle);
        //updateTextButtonVisibility();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.356 -0400", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "FD2C97EB05DDCC2028D2AD0FBB9830FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        onPopulateAccessibilityEvent(event);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //onPopulateAccessibilityEvent(event);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.356 -0400", hash_original_method = "FDE4E65FE29B6BBB876E3C716DF53BA6", hash_generated_method = "494A8C18251A32B0D46359374B09EC95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        super.onPopulateAccessibilityEvent(event);
        CharSequence cdesc;
        cdesc = getContentDescription();
        {
            boolean var084C16D53D5FFC75BDE8D9D1CF00C211_221182135 = (!TextUtils.isEmpty(cdesc));
            {
                event.getText().add(cdesc);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //final CharSequence cdesc = getContentDescription();
        //if (!TextUtils.isEmpty(cdesc)) {
            //event.getText().add(cdesc);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.356 -0400", hash_original_method = "757AA99E9D5B690C1E0FFF7AC4DD062B", hash_generated_method = "DCDA2D20D9AFFF589DA681C708FEF47B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean dispatchHoverEvent(MotionEvent event) {
        dsTaint.addTaint(event.dsTaint);
        boolean var20FA514C60FFF8C5D29FC4243A17D964_323647583 = (onHoverEvent(event));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return onHoverEvent(event);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.356 -0400", hash_original_method = "C76AE16CD3DCE07A39A065D6C2B5EB3F", hash_generated_method = "014150786E87CFCF90CB6FC625D513F8")
    @DSModeled(DSC.SAFE)
    public boolean showsIcon() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.357 -0400", hash_original_method = "6E6CD62A341ADB3BA1A0AA59225DD877", hash_generated_method = "DA7B04706477E3EE8254A41388E4A9DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean needsDividerBefore() {
        boolean varC391B8333746DF3495063ECE87850875_886567465 = (hasText() && mItemData.getIcon() == null);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasText() && mItemData.getIcon() == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.357 -0400", hash_original_method = "20C5403BD48B33FD0977D6BAA2D766A2", hash_generated_method = "F7739B5E6AEEBA62530CBE2F420C30CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean needsDividerAfter() {
        boolean varFE379F5963DF6F578F28789FBF75C885_1530612464 = (hasText());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasText();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.358 -0400", hash_original_method = "10936D3B137771DD6A653DC8F3F943BC", hash_generated_method = "1165A7D93D14CED192650082B9E7ED4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean onLongClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        {
            boolean var2426BFEBBB871B2BC0447A62A0462B28_1883870175 = (hasText());
        } //End collapsed parenthetic
        int[] screenPos;
        screenPos = new int[2];
        Rect displayFrame;
        displayFrame = new Rect();
        getLocationOnScreen(screenPos);
        getWindowVisibleDisplayFrame(displayFrame);
        Context context;
        context = getContext();
        int width;
        width = getWidth();
        int height;
        height = getHeight();
        int midy;
        midy = screenPos[1] + height / 2;
        int screenWidth;
        screenWidth = context.getResources().getDisplayMetrics().widthPixels;
        Toast cheatSheet;
        cheatSheet = Toast.makeText(context, mItemData.getTitle(), Toast.LENGTH_SHORT);
        {
            boolean varE02E65C8258A93EC7D0AFE2F76F131C1_235828809 = (midy < displayFrame.height());
            {
                cheatSheet.setGravity(Gravity.TOP | Gravity.RIGHT,
                    screenWidth - screenPos[0] - width / 2, height);
            } //End block
            {
                cheatSheet.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, height);
            } //End block
        } //End collapsed parenthetic
        cheatSheet.show();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:18.358 -0400", hash_original_method = "0390CA0D2B05A2CB99D4521DDD33A8D8", hash_generated_method = "C3EC59F259C3772E6474B428807C05F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(heightMeasureSpec);
        dsTaint.addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode;
        widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize;
        specSize = MeasureSpec.getSize(widthMeasureSpec);
        int oldMeasuredWidth;
        oldMeasuredWidth = getMeasuredWidth();
        int targetWidth;
        targetWidth = Math.min(specSize, mMinWidth);
        targetWidth = mMinWidth;
        {
            super.onMeasure(MeasureSpec.makeMeasureSpec(targetWidth, MeasureSpec.EXACTLY),
                    heightMeasureSpec);
        } //End block
        // ---------- Original Method ----------
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        //final int specSize = MeasureSpec.getSize(widthMeasureSpec);
        //final int oldMeasuredWidth = getMeasuredWidth();
        //final int targetWidth = widthMode == MeasureSpec.AT_MOST ? Math.min(specSize, mMinWidth)
                //: mMinWidth;
        //if (widthMode != MeasureSpec.EXACTLY && mMinWidth > 0 && oldMeasuredWidth < targetWidth) {
            //super.onMeasure(MeasureSpec.makeMeasureSpec(targetWidth, MeasureSpec.EXACTLY),
                    //heightMeasureSpec);
        //}
    }

    
    private static final String TAG = "ActionMenuItemView";
}

