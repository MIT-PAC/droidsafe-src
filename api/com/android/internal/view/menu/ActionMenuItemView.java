package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.831 -0400", hash_original_field = "1F6C4899836DE7690E2FFD7BA4FE83E4", hash_generated_field = "B32E7CB0DF6786FBC4DDA7C50169A79B")

    private MenuItemImpl mItemData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.831 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.831 -0400", hash_original_field = "AB2CFA1082AD5EABA7FF59C86326776C", hash_generated_field = "FCA7C24D10E4756C2F866687779CE7A2")

    private MenuBuilder.ItemInvoker mItemInvoker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.831 -0400", hash_original_field = "B46A9475B590D71DAC22FFF92B526569", hash_generated_field = "FAB3D217CE66519B4E9F8FFE982A38EF")

    private ImageButton mImageButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.831 -0400", hash_original_field = "3A930298E00D63BB2C7CE42A58E94428", hash_generated_field = "9B0FB4DD236A598CA5E9F899DD0004A7")

    private Button mTextButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.831 -0400", hash_original_field = "6E9B974F382AF000861E8A4BB9D2A625", hash_generated_field = "026998B37BE3694ADAD845A945E977A5")

    private boolean mAllowTextWithIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.832 -0400", hash_original_field = "B3A27FF3D8463FDB775C445216DF0827", hash_generated_field = "8BCC0CCB20D7838DC0FF6BF986026A67")

    private boolean mExpandedFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.832 -0400", hash_original_field = "2FB832D2671571BF4EC0C84F8DA6AA79", hash_generated_field = "ED0C6BF081117F2A257C521DB4125AB9")

    private int mMinWidth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.832 -0400", hash_original_method = "A9C9E45D494EF4E28228859D4DA5948C", hash_generated_method = "8AE7A8B46B263A83796861159E003845")
    public  ActionMenuItemView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.832 -0400", hash_original_method = "414C1C737BA41080151B3C84CB3C1FDA", hash_generated_method = "48B150A4A42D8801B138F4C1AF9CC7C5")
    public  ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.833 -0400", hash_original_method = "7FEBDC4FE1DC1778EBE8D4C1AD12D9F5", hash_generated_method = "DE074BBC4282EB0C4356B86ED11EC651")
    public  ActionMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        final Resources res = context.getResources();
        mAllowTextWithIcon = res.getBoolean(
                com.android.internal.R.bool.config_allowActionMenuItemTextWithIcon);
        TypedArray a = context.obtainStyledAttributes(attrs,
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.834 -0400", hash_original_method = "97E99CBFA7DAC670C6AD27C0843F8326", hash_generated_method = "B97291A5FF679C68FDE6F45741CA7D42")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.834 -0400", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "66831D9BECC77227F873F24ECBF9B87A")
    public MenuItemImpl getItemData() {
MenuItemImpl varFD5535759C41B540EBDBAE602A671A91_1920329424 =         mItemData;
        varFD5535759C41B540EBDBAE602A671A91_1920329424.addTaint(taint);
        return varFD5535759C41B540EBDBAE602A671A91_1920329424;
        // ---------- Original Method ----------
        //return mItemData;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.835 -0400", hash_original_method = "F3ADD2CA2E2A1F1636EEF9ECFE1172AF", hash_generated_method = "BDAEADB7ECC79CCFDBA235C5401E2F96")
    public void initialize(MenuItemImpl itemData, int menuType) {
        addTaint(menuType);
        mItemData = itemData;
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.835 -0400", hash_original_method = "CB61F2977C03C3D4A47A54A8D609CC23", hash_generated_method = "026AC703DB577E76F03D45C71009FABF")
    @Override
    public void setEnabled(boolean enabled) {
        addTaint(enabled);
        super.setEnabled(enabled);
        mImageButton.setEnabled(enabled);
        mTextButton.setEnabled(enabled);
        // ---------- Original Method ----------
        //super.setEnabled(enabled);
        //mImageButton.setEnabled(enabled);
        //mTextButton.setEnabled(enabled);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.836 -0400", hash_original_method = "B665A21C15F294A662D29A2BA3A7A359", hash_generated_method = "7D982665677A48E6E8C4E1CEAADF4B3D")
    public void onClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
    if(mItemInvoker != null)        
        {
            mItemInvoker.invokeItem(mItemData);
        } //End block
        // ---------- Original Method ----------
        //if (mItemInvoker != null) {
            //mItemInvoker.invokeItem(mItemData);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.836 -0400", hash_original_method = "D4B10D907261C4745939FD5942191820", hash_generated_method = "270FC8FDA3818D246FF2F1F090AA616A")
    public void setItemInvoker(MenuBuilder.ItemInvoker invoker) {
        mItemInvoker = invoker;
        // ---------- Original Method ----------
        //mItemInvoker = invoker;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.836 -0400", hash_original_method = "A2F62AB27113ADE9EE493677370BEC6F", hash_generated_method = "188E8EA5571D5FA9518D4DAC93FEBF12")
    public boolean prefersCondensedTitle() {
        boolean varB326B5062B2F0E69046810717534CB09_74906016 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1033704486 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1033704486;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.836 -0400", hash_original_method = "206C9D092F8D2CE8A945E1A45B818CB4", hash_generated_method = "BA66FBB494F3C28FF06B59EB6EC283AE")
    public void setCheckable(boolean checkable) {
        addTaint(checkable);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.837 -0400", hash_original_method = "98D5E38367DB01B2323D3E891737183A", hash_generated_method = "E13CE4DF4F9AB654448A696784A01853")
    public void setChecked(boolean checked) {
        addTaint(checked);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.837 -0400", hash_original_method = "4B7C35F58E3B5D585DF448A46B8AF434", hash_generated_method = "CE8154469970DCEC081F8F3A55062017")
    public void setExpandedFormat(boolean expandedFormat) {
    if(mExpandedFormat != expandedFormat)        
        {
            mExpandedFormat = expandedFormat;
    if(mItemData != null)            
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.837 -0400", hash_original_method = "A914366A36A1D33567DEDC1A62560744", hash_generated_method = "08641A48D4E5352A15AB3B2B909D4F77")
    private void updateTextButtonVisibility() {
        boolean visible = !TextUtils.isEmpty(mTextButton.getText());
        visible &= mImageButton.getDrawable() == null ||
                (mItemData.showsTextAsAction() && (mAllowTextWithIcon || mExpandedFormat));
        mTextButton.setVisibility(visible ? VISIBLE : GONE);
        // ---------- Original Method ----------
        //boolean visible = !TextUtils.isEmpty(mTextButton.getText());
        //visible &= mImageButton.getDrawable() == null ||
                //(mItemData.showsTextAsAction() && (mAllowTextWithIcon || mExpandedFormat));
        //mTextButton.setVisibility(visible ? VISIBLE : GONE);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.838 -0400", hash_original_method = "48979BF203DB7148CE59E9B74A531A1E", hash_generated_method = "E4ABE11698C172FCC4E498367198B809")
    public void setIcon(Drawable icon) {
        addTaint(icon.getTaint());
        mImageButton.setImageDrawable(icon);
    if(icon != null)        
        {
            mImageButton.setVisibility(VISIBLE);
        } //End block
        else
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.838 -0400", hash_original_method = "DAE9552F4F404C09BF99313735727BF7", hash_generated_method = "05C990B2FC56750BF8413166EBCF89F4")
    public boolean hasText() {
        boolean var78CB5C0383862B43CCC18F151ED7ED57_622642770 = (mTextButton.getVisibility() != GONE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1848853190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1848853190;
        // ---------- Original Method ----------
        //return mTextButton.getVisibility() != GONE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.838 -0400", hash_original_method = "85A41D343B47A7443CFB0CEF90E94BCA", hash_generated_method = "C06B8F35FB567A3ECE4C1BBF2E09D77F")
    public void setShortcut(boolean showShortcut, char shortcutKey) {
        addTaint(shortcutKey);
        addTaint(showShortcut);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.839 -0400", hash_original_method = "E35411C4CA419EBD2C9EFEDC089EF32B", hash_generated_method = "E6232845222D16CB5B1317A1EBB18D80")
    public void setTitle(CharSequence title) {
        mTitle = title;
        mTextButton.setText(mTitle);
        setContentDescription(mTitle);
        updateTextButtonVisibility();
        // ---------- Original Method ----------
        //mTitle = title;
        //mTextButton.setText(mTitle);
        //setContentDescription(mTitle);
        //updateTextButtonVisibility();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.839 -0400", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "F52D2FC33061B551401D942060E1688D")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        onPopulateAccessibilityEvent(event);
        boolean varB326B5062B2F0E69046810717534CB09_1100178834 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1250555719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1250555719;
        // ---------- Original Method ----------
        //onPopulateAccessibilityEvent(event);
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.839 -0400", hash_original_method = "FDE4E65FE29B6BBB876E3C716DF53BA6", hash_generated_method = "99FC9FA52CFCA1A2C8C1E179E8D834D1")
    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        super.onPopulateAccessibilityEvent(event);
        final CharSequence cdesc = getContentDescription();
    if(!TextUtils.isEmpty(cdesc))        
        {
            event.getText().add(cdesc);
        } //End block
        // ---------- Original Method ----------
        //super.onPopulateAccessibilityEvent(event);
        //final CharSequence cdesc = getContentDescription();
        //if (!TextUtils.isEmpty(cdesc)) {
            //event.getText().add(cdesc);
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.840 -0400", hash_original_method = "757AA99E9D5B690C1E0FFF7AC4DD062B", hash_generated_method = "8C4D4F714439204998B90E240268240E")
    @Override
    public boolean dispatchHoverEvent(MotionEvent event) {
        addTaint(event.getTaint());
        boolean var47449F9991FAD303C66FB26061BA8D47_373360898 = (onHoverEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_626047002 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_626047002;
        // ---------- Original Method ----------
        //return onHoverEvent(event);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.840 -0400", hash_original_method = "C76AE16CD3DCE07A39A065D6C2B5EB3F", hash_generated_method = "D2B4C97F4956BA74F44115090A195250")
    public boolean showsIcon() {
        boolean varB326B5062B2F0E69046810717534CB09_1866958669 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1595899190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1595899190;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.840 -0400", hash_original_method = "6E6CD62A341ADB3BA1A0AA59225DD877", hash_generated_method = "908C2C380995C14A769607A495F7707F")
    public boolean needsDividerBefore() {
        boolean var07F43ED82747B5C54AA3B8AE4FF30842_1104287980 = (hasText() && mItemData.getIcon() == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_142733990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_142733990;
        // ---------- Original Method ----------
        //return hasText() && mItemData.getIcon() == null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.840 -0400", hash_original_method = "20C5403BD48B33FD0977D6BAA2D766A2", hash_generated_method = "B83AF8DC217706FAFEFA713498AD729B")
    public boolean needsDividerAfter() {
        boolean varFCAE703F51C693C202C4C473359F2031_1690687309 = (hasText());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_628334790 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_628334790;
        // ---------- Original Method ----------
        //return hasText();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.841 -0400", hash_original_method = "10936D3B137771DD6A653DC8F3F943BC", hash_generated_method = "E9F0D0A4D2FB0696BE6B3D0BC3388523")
    @Override
    public boolean onLongClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
    if(hasText())        
        {
            boolean var68934A3E9455FA72420237EB05902327_1853689439 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_882807010 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_882807010;
        } //End block
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
    if(midy < displayFrame.height())        
        {
            cheatSheet.setGravity(Gravity.TOP | Gravity.RIGHT,
                    screenWidth - screenPos[0] - width / 2, height);
        } //End block
        else
        {
            cheatSheet.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, height);
        } //End block
        cheatSheet.show();
        boolean varB326B5062B2F0E69046810717534CB09_1210611359 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_942252529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_942252529;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.841 -0400", hash_original_method = "0390CA0D2B05A2CB99D4521DDD33A8D8", hash_generated_method = "8E10BF82E594163FEBE56E26F7F84A47")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(heightMeasureSpec);
        addTaint(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int specSize = MeasureSpec.getSize(widthMeasureSpec);
        final int oldMeasuredWidth = getMeasuredWidth();
        final int targetWidth = widthMode == MeasureSpec.AT_MOST ? Math.min(specSize, mMinWidth)
                : mMinWidth;
    if(widthMode != MeasureSpec.EXACTLY && mMinWidth > 0 && oldMeasuredWidth < targetWidth)        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:30.841 -0400", hash_original_field = "1B7293974E82EC0E13643EFB7F5F9643", hash_generated_field = "59FAE62321B2FBA7C3D29B6855696300")

    private static final String TAG = "ActionMenuItemView";
}

