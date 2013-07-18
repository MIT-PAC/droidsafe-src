package com.android.internal.view.menu;

// Droidsafe Imports
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ActionMenuItemView extends LinearLayout implements MenuView.ItemView, View.OnClickListener, View.OnLongClickListener, ActionMenuView.ActionMenuChildView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.880 -0400", hash_original_field = "1F6C4899836DE7690E2FFD7BA4FE83E4", hash_generated_field = "B32E7CB0DF6786FBC4DDA7C50169A79B")

    private MenuItemImpl mItemData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.880 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.880 -0400", hash_original_field = "AB2CFA1082AD5EABA7FF59C86326776C", hash_generated_field = "FCA7C24D10E4756C2F866687779CE7A2")

    private MenuBuilder.ItemInvoker mItemInvoker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.880 -0400", hash_original_field = "B46A9475B590D71DAC22FFF92B526569", hash_generated_field = "FAB3D217CE66519B4E9F8FFE982A38EF")

    private ImageButton mImageButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.880 -0400", hash_original_field = "3A930298E00D63BB2C7CE42A58E94428", hash_generated_field = "9B0FB4DD236A598CA5E9F899DD0004A7")

    private Button mTextButton;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.880 -0400", hash_original_field = "6E9B974F382AF000861E8A4BB9D2A625", hash_generated_field = "026998B37BE3694ADAD845A945E977A5")

    private boolean mAllowTextWithIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.880 -0400", hash_original_field = "B3A27FF3D8463FDB775C445216DF0827", hash_generated_field = "8BCC0CCB20D7838DC0FF6BF986026A67")

    private boolean mExpandedFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.881 -0400", hash_original_field = "2FB832D2671571BF4EC0C84F8DA6AA79", hash_generated_field = "ED0C6BF081117F2A257C521DB4125AB9")

    private int mMinWidth;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.881 -0400", hash_original_method = "A9C9E45D494EF4E28228859D4DA5948C", hash_generated_method = "8AE7A8B46B263A83796861159E003845")
    public  ActionMenuItemView(Context context) {
        this(context, null);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.881 -0400", hash_original_method = "414C1C737BA41080151B3C84CB3C1FDA", hash_generated_method = "48B150A4A42D8801B138F4C1AF9CC7C5")
    public  ActionMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.882 -0400", hash_original_method = "7FEBDC4FE1DC1778EBE8D4C1AD12D9F5", hash_generated_method = "DE074BBC4282EB0C4356B86ED11EC651")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.883 -0400", hash_original_method = "97E99CBFA7DAC670C6AD27C0843F8326", hash_generated_method = "B97291A5FF679C68FDE6F45741CA7D42")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.883 -0400", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "6279F9C04A824E078D7BEB273178828D")
    public MenuItemImpl getItemData() {
MenuItemImpl varFD5535759C41B540EBDBAE602A671A91_57113468 =         mItemData;
        varFD5535759C41B540EBDBAE602A671A91_57113468.addTaint(taint);
        return varFD5535759C41B540EBDBAE602A671A91_57113468;
        // ---------- Original Method ----------
        //return mItemData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.883 -0400", hash_original_method = "F3ADD2CA2E2A1F1636EEF9ECFE1172AF", hash_generated_method = "BDAEADB7ECC79CCFDBA235C5401E2F96")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.884 -0400", hash_original_method = "CB61F2977C03C3D4A47A54A8D609CC23", hash_generated_method = "026AC703DB577E76F03D45C71009FABF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.884 -0400", hash_original_method = "B665A21C15F294A662D29A2BA3A7A359", hash_generated_method = "7D982665677A48E6E8C4E1CEAADF4B3D")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.884 -0400", hash_original_method = "D4B10D907261C4745939FD5942191820", hash_generated_method = "270FC8FDA3818D246FF2F1F090AA616A")
    public void setItemInvoker(MenuBuilder.ItemInvoker invoker) {
        mItemInvoker = invoker;
        // ---------- Original Method ----------
        //mItemInvoker = invoker;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.884 -0400", hash_original_method = "A2F62AB27113ADE9EE493677370BEC6F", hash_generated_method = "0631C3DE3A3902B73426CADD9B3831AF")
    public boolean prefersCondensedTitle() {
        boolean varB326B5062B2F0E69046810717534CB09_260470803 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_640929255 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_640929255;
        // ---------- Original Method ----------
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.885 -0400", hash_original_method = "206C9D092F8D2CE8A945E1A45B818CB4", hash_generated_method = "BA66FBB494F3C28FF06B59EB6EC283AE")
    public void setCheckable(boolean checkable) {
        addTaint(checkable);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.885 -0400", hash_original_method = "98D5E38367DB01B2323D3E891737183A", hash_generated_method = "E13CE4DF4F9AB654448A696784A01853")
    public void setChecked(boolean checked) {
        addTaint(checked);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.885 -0400", hash_original_method = "4B7C35F58E3B5D585DF448A46B8AF434", hash_generated_method = "CE8154469970DCEC081F8F3A55062017")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.886 -0400", hash_original_method = "A914366A36A1D33567DEDC1A62560744", hash_generated_method = "08641A48D4E5352A15AB3B2B909D4F77")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.886 -0400", hash_original_method = "48979BF203DB7148CE59E9B74A531A1E", hash_generated_method = "E4ABE11698C172FCC4E498367198B809")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.886 -0400", hash_original_method = "DAE9552F4F404C09BF99313735727BF7", hash_generated_method = "EC33F0AB0BA426EB92437F1FDE9C049B")
    public boolean hasText() {
        boolean var78CB5C0383862B43CCC18F151ED7ED57_1384586729 = (mTextButton.getVisibility() != GONE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1760330517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1760330517;
        // ---------- Original Method ----------
        //return mTextButton.getVisibility() != GONE;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.887 -0400", hash_original_method = "85A41D343B47A7443CFB0CEF90E94BCA", hash_generated_method = "C06B8F35FB567A3ECE4C1BBF2E09D77F")
    public void setShortcut(boolean showShortcut, char shortcutKey) {
        addTaint(shortcutKey);
        addTaint(showShortcut);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.887 -0400", hash_original_method = "E35411C4CA419EBD2C9EFEDC089EF32B", hash_generated_method = "E6232845222D16CB5B1317A1EBB18D80")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.887 -0400", hash_original_method = "CFB95F18A35F8E50D440D10682646E0E", hash_generated_method = "7F9968FA06E4A7D6D51B76579F015BF1")
    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        addTaint(event.getTaint());
        onPopulateAccessibilityEvent(event);
        boolean varB326B5062B2F0E69046810717534CB09_2049797219 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1727430297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1727430297;
        // ---------- Original Method ----------
        //onPopulateAccessibilityEvent(event);
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.888 -0400", hash_original_method = "FDE4E65FE29B6BBB876E3C716DF53BA6", hash_generated_method = "99FC9FA52CFCA1A2C8C1E179E8D834D1")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.889 -0400", hash_original_method = "757AA99E9D5B690C1E0FFF7AC4DD062B", hash_generated_method = "A99FC08B9568BC21ABF0DAF07014AD38")
    @Override
    public boolean dispatchHoverEvent(MotionEvent event) {
        addTaint(event.getTaint());
        boolean var47449F9991FAD303C66FB26061BA8D47_1877497829 = (onHoverEvent(event));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_752811227 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_752811227;
        // ---------- Original Method ----------
        //return onHoverEvent(event);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.889 -0400", hash_original_method = "C76AE16CD3DCE07A39A065D6C2B5EB3F", hash_generated_method = "CC40EC4E929E52E0BAC6C0B72C6028CE")
    public boolean showsIcon() {
        boolean varB326B5062B2F0E69046810717534CB09_1512784851 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2044833740 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2044833740;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.889 -0400", hash_original_method = "6E6CD62A341ADB3BA1A0AA59225DD877", hash_generated_method = "D7CFC90C0DD24B4D9F0B7CCAE70EBDDD")
    public boolean needsDividerBefore() {
        boolean var07F43ED82747B5C54AA3B8AE4FF30842_875190920 = (hasText() && mItemData.getIcon() == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1466988380 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1466988380;
        // ---------- Original Method ----------
        //return hasText() && mItemData.getIcon() == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.890 -0400", hash_original_method = "20C5403BD48B33FD0977D6BAA2D766A2", hash_generated_method = "8B36D783D9A174591AAEE8BACB668AC9")
    public boolean needsDividerAfter() {
        boolean varFCAE703F51C693C202C4C473359F2031_1841513765 = (hasText());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_112186031 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_112186031;
        // ---------- Original Method ----------
        //return hasText();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.890 -0400", hash_original_method = "10936D3B137771DD6A653DC8F3F943BC", hash_generated_method = "BEFC3C0D1AE3FF6DCDFD038AB6D864D6")
    @Override
    public boolean onLongClick(View v) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(v.getTaint());
        if(hasText())        
        {
            boolean var68934A3E9455FA72420237EB05902327_314912449 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_760521784 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_760521784;
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
        boolean varB326B5062B2F0E69046810717534CB09_1085778382 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1116991268 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1116991268;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.891 -0400", hash_original_method = "0390CA0D2B05A2CB99D4521DDD33A8D8", hash_generated_method = "8E10BF82E594163FEBE56E26F7F84A47")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.891 -0400", hash_original_field = "1B7293974E82EC0E13643EFB7F5F9643", hash_generated_field = "59FAE62321B2FBA7C3D29B6855696300")

    private static final String TAG = "ActionMenuItemView";
}

