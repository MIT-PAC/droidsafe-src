package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.133 -0500", hash_original_field = "5E900415DC83EB4A21128A5F009D6AD3", hash_generated_field = "59FAE62321B2FBA7C3D29B6855696300")

    private static final String TAG = "ActionMenuItemView";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.135 -0500", hash_original_field = "DBB703567F4F0AD8C976E510ACED07CC", hash_generated_field = "B32E7CB0DF6786FBC4DDA7C50169A79B")


    private MenuItemImpl mItemData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.137 -0500", hash_original_field = "8C445459F9A68BF8713F87AC9D695E47", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.139 -0500", hash_original_field = "3873EAC5176BA972832B90424E16F31B", hash_generated_field = "FCA7C24D10E4756C2F866687779CE7A2")

    private MenuBuilder.ItemInvoker mItemInvoker;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.141 -0500", hash_original_field = "E7F1856FFCFEC6DE5CAE6A6442AAAAA2", hash_generated_field = "FAB3D217CE66519B4E9F8FFE982A38EF")


    private ImageButton mImageButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.143 -0500", hash_original_field = "1DD0FEF7EAFC27E50D0C652743229254", hash_generated_field = "9B0FB4DD236A598CA5E9F899DD0004A7")

    private Button mTextButton;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.146 -0500", hash_original_field = "0702D0132C7EEE9027A2928CF259A952", hash_generated_field = "026998B37BE3694ADAD845A945E977A5")

    private boolean mAllowTextWithIcon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.148 -0500", hash_original_field = "D4382F3ED434DC2AD3ED58497C2CF171", hash_generated_field = "8BCC0CCB20D7838DC0FF6BF986026A67")

    private boolean mExpandedFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.151 -0500", hash_original_field = "B5D566AA92521F570066E8773A24B0C0", hash_generated_field = "ED0C6BF081117F2A257C521DB4125AB9")

    private int mMinWidth;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.154 -0500", hash_original_method = "A9C9E45D494EF4E28228859D4DA5948C", hash_generated_method = "91AFDFED7E9E4BB957665A65DA1425D2")
    
public ActionMenuItemView(Context context) {
        this(context, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.156 -0500", hash_original_method = "414C1C737BA41080151B3C84CB3C1FDA", hash_generated_method = "87214AEC09D948C7F0D6DC9CACBE6A85")
    
public ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.159 -0500", hash_original_method = "7FEBDC4FE1DC1778EBE8D4C1AD12D9F5", hash_generated_method = "4F4C16A002E5D0E7A8BE8981108E7614")
    
public ActionMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        final Resources res = context.getResources();
        mAllowTextWithIcon = res.getBoolean(
                com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
        TypedArray a = context.obtainStyledAttributes(attrs,
                com.android.internal.R.styleable.ActionMenuItemView, 0, 0);
        mMinWidth = a.getDimensionPixelSize(
                com.android.internal.R.styleable.ActionMenuItemView_minWidth, 0);
        a.recycle();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.162 -0500", hash_original_method = "97E99CBFA7DAC670C6AD27C0843F8326", hash_generated_method = "BE8676670C19750D6AFF885681045E64")
    
@Override
    public void onFinishInflate() {
        mImageButton = (ImageButton) findViewById(com.android.internal.R.id.imageButton);
        mTextButton = (Button) findViewById(com.android.internal.R.id.textButton);
        mImageButton.setOnClickListener(this);
        mTextButton.setOnClickListener(this);
        mImageButton.setOnLongClickListener(this);
        setOnClickListener(this);
        setOnLongClickListener(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.164 -0500", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "B0B9AF9FA2DDD827E4877533896893E2")
    
public MenuItemImpl getItemData() {
        return mItemData;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.166 -0500", hash_original_method = "F3ADD2CA2E2A1F1636EEF9ECFE1172AF", hash_generated_method = "3BD3E26FCD7FBA7C893F1862F0D48A86")
    
public void initialize(MenuItemImpl itemData, int menuType) {
        mItemData = itemData;

        setIcon(itemData.getIcon());
        setTitle(itemData.getTitleForItemView(this)); // Title only takes effect if there is no icon
        setId(itemData.getItemId());

        setVisibility(itemData.isVisible() ? View.VISIBLE : View.GONE);
        setEnabled(itemData.isEnabled());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.169 -0500", hash_original_method = "CB61F2977C03C3D4A47A54A8D609CC23", hash_generated_method = "9ABE21DB6A14905831E45CBC2CD9F24A")
    
@Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        mImageButton.setEnabled(enabled);
        mTextButton.setEnabled(enabled);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.171 -0500", hash_original_method = "B665A21C15F294A662D29A2BA3A7A359", hash_generated_method = "65B53CE5C8BCAADCAFE5306720FD4967")
    
public void onClick(View v) {
        if (mItemInvoker != null) {
            mItemInvoker.invokeItem(mItemData);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.173 -0500", hash_original_method = "D4B10D907261C4745939FD5942191820", hash_generated_method = "4783FD42B5554823B93906301DBAAE90")
    
public void setItemInvoker(MenuBuilder.ItemInvoker invoker) {
        mItemInvoker = invoker;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.175 -0500", hash_original_method = "A2F62AB27113ADE9EE493677370BEC6F", hash_generated_method = "EAF4F3B980307BACF84AAB2557327ACE")
    
public boolean prefersCondensedTitle() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.177 -0500", hash_original_method = "206C9D092F8D2CE8A945E1A45B818CB4", hash_generated_method = "190A86B6FCC2D0FB7D679FA2B212DD27")
    
public void setCheckable(boolean checkable) {
        // TODO Support checkable action items
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.180 -0500", hash_original_method = "98D5E38367DB01B2323D3E891737183A", hash_generated_method = "FD79D39CDBCB9A353A0E4D9EECD3BA27")
    
public void setChecked(boolean checked) {
        // TODO Support checkable action items
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.182 -0500", hash_original_method = "4B7C35F58E3B5D585DF448A46B8AF434", hash_generated_method = "C1C279B2A64D79787BDEE19FDD350769")
    
public void setExpandedFormat(boolean expandedFormat) {
        if (mExpandedFormat != expandedFormat) {
            mExpandedFormat = expandedFormat;
            if (mItemData != null) {
                mItemData.actionFormatChanged();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.184 -0500", hash_original_method = "A914366A36A1D33567DEDC1A62560744", hash_generated_method = "4A963B151F239BF2C34A0862E0CC5186")
    
private void updateTextButtonVisibility() {
        boolean visible = !TextUtils.isEmpty(mTextButton.getText());
        visible &= mImageButton.getDrawable() == null ||
                (mItemData.showsTextAsAction() && (mAllowTextWithIcon || mExpandedFormat));

        mTextButton.setVisibility(visible ? VISIBLE : GONE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.186 -0500", hash_original_method = "48979BF203DB7148CE59E9B74A531A1E", hash_generated_method = "BCD1AA0E3109CD464646036E90919008")
    
public void setIcon(Drawable icon) {
        mImageButton.setImageDrawable(icon);
        if (icon != null) {
            mImageButton.setVisibility(VISIBLE);
        } else {
            mImageButton.setVisibility(GONE);
        }

        updateTextButtonVisibility();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.188 -0500", hash_original_method = "DAE9552F4F404C09BF99313735727BF7", hash_generated_method = "E3A1D8C8FB44ABE597F45C641D18BDA9")
    
public boolean hasText() {
        return mTextButton.getVisibility() != GONE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.191 -0500", hash_original_method = "85A41D343B47A7443CFB0CEF90E94BCA", hash_generated_method = "A602A3D9225E44DB42D70BA9D23108A5")
    
public void setShortcut(boolean showShortcut, char shortcutKey) {
        // Action buttons don't show text for shortcut keys.
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.193 -0500", hash_original_method = "E35411C4CA419EBD2C9EFEDC089EF32B", hash_generated_method = "584B6F0FC2DB1E77AE6060189223A142")
    
public void setTitle(CharSequence title) {
        mTitle = title;

        mTextButton.setText(mTitle);

        setContentDescription(mTitle);
        updateTextButtonVisibility();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.196 -0500", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "B2DB9880D1A02B35D29BED9E1EE131DA")
    
@Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        onPopulateAccessibilityEvent(event);
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.198 -0500", hash_original_method = "FDE4E65FE29B6BBB876E3C716DF53BA6", hash_generated_method = "FC7F3A83CEC8ED8AF4EBACB87FAF6207")
    
@Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);
        final CharSequence cdesc = getContentDescription();
        if (!TextUtils.isEmpty(cdesc)) {
            event.getText().add(cdesc);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.201 -0500", hash_original_method = "757AA99E9D5B690C1E0FFF7AC4DD062B", hash_generated_method = "F90F76EFAEEABFE6AC3C6C9354D0BBCC")
    
@Override
    public boolean dispatchHoverEvent(MotionEvent event) {
        // Don't allow children to hover; we want this to be treated as a single component.
        return onHoverEvent(event);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.203 -0500", hash_original_method = "C76AE16CD3DCE07A39A065D6C2B5EB3F", hash_generated_method = "FAD9516926F7D312A8FE978C46B59F8A")
    
public boolean showsIcon() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.205 -0500", hash_original_method = "6E6CD62A341ADB3BA1A0AA59225DD877", hash_generated_method = "FE88FE30B1A5236EA1B105EE42CE4F1F")
    
public boolean needsDividerBefore() {
        return hasText() && mItemData.getIcon() == null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.207 -0500", hash_original_method = "20C5403BD48B33FD0977D6BAA2D766A2", hash_generated_method = "A0E113A1C8848D7BFCD7B37E8887D853")
    
public boolean needsDividerAfter() {
        return hasText();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.210 -0500", hash_original_method = "10936D3B137771DD6A653DC8F3F943BC", hash_generated_method = "426553A69A4B123A45A4CE5BF91333E1")
    
@Override
    public boolean onLongClick(View v) {
        if (hasText()) {
            // Don't show the cheat sheet for items that already show text.
            return false;
        }

        final int[] screenPos = new int[2];
        final Rect displayFrame = new Rect();
        getLocationOnScreen(screenPos);
        getWindowVisibleDisplayFrame(displayFrame);

        final Context context = getContext();
        final int width = getWidth();
        final int height = getHeight();
        final int midy = screenPos[1] + height / 2;
        final int screenWidth = context.getResources().getDisplayMetrics().widthPixels;

        Toast cheatSheet = Toast.makeText(context, mItemData.getTitle(), Toast.LENGTH_SHORT);
        if (midy < displayFrame.height()) {
            // Show along the top; follow action buttons
            cheatSheet.setGravity(Gravity.TOP | Gravity.RIGHT,
                    screenWidth - screenPos[0] - width / 2, height);
        } else {
            // Show along the bottom center
            cheatSheet.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, height);
        }
        cheatSheet.show();
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:37.212 -0500", hash_original_method = "0390CA0D2B05A2CB99D4521DDD33A8D8", hash_generated_method = "2C13AD4CD17121165A34BC2452178F87")
    
@Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int specSize = MeasureSpec.getSize(widthMeasureSpec);
        final int oldMeasuredWidth = getMeasuredWidth();
        final int targetWidth = widthMode == MeasureSpec.AT_MOST ? Math.min(specSize, mMinWidth)
                : mMinWidth;

        if (widthMode != MeasureSpec.EXACTLY && mMinWidth > 0 && oldMeasuredWidth < targetWidth) {
            // Remeasure at exactly the minimum width.
            super.onMeasure(MeasureSpec.makeMeasureSpec(targetWidth, MeasureSpec.EXACTLY),
                    heightMeasureSpec);
        }
    }
}

