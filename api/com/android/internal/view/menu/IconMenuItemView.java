package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.SoundEffectConstants;
import android.graphics.Rect;
import android.content.Context;
import android.view.View;
import android.util.AttributeSet;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import android.text.Layout;
import android.view.Gravity;
import com.android.internal.view.menu.MenuBuilder.ItemInvoker;
import android.view.ViewDebug;
import android.content.res.TypedArray;
public final class IconMenuItemView extends TextView implements MenuView.ItemView {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.313 -0400", hash_original_field = "02DDE57B64C0BE523D0D96FE5736F5D8", hash_generated_field = "F84531E38F2FCF9F5A9F318DF05E11F8")

    private IconMenuView mIconMenuView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.314 -0400", hash_original_field = "AB2CFA1082AD5EABA7FF59C86326776C", hash_generated_field = "D2D54C24932B8B9548FB244B0C3E4266")

    private ItemInvoker mItemInvoker;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.314 -0400", hash_original_field = "1F6C4899836DE7690E2FFD7BA4FE83E4", hash_generated_field = "B32E7CB0DF6786FBC4DDA7C50169A79B")

    private MenuItemImpl mItemData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.314 -0400", hash_original_field = "1A265556E59DF15CAEC4E55FB61E68C7", hash_generated_field = "FFB83F2A7C9A877B036AAEB7C21DDF6E")

    private Drawable mIcon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.315 -0400", hash_original_field = "2FB2E5650EED06BEBF40BB55A12238EF", hash_generated_field = "E1363564E2F8BE551770EA738359CA9A")

    private int mTextAppearance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.315 -0400", hash_original_field = "A40BA604A2EA30F7C4E7BFCB28412D34", hash_generated_field = "FABF004F46FE66709A563A85D0AA3A43")

    private Context mTextAppearanceContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.315 -0400", hash_original_field = "442F8731C67AF26E1E29D47472A461BF", hash_generated_field = "BE45430B4E582ECC76FDAE96B324FF18")

    private float mDisabledAlpha;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.315 -0400", hash_original_field = "8E73B1B8D1CBFD937BB99EBD173943E5", hash_generated_field = "7F2AAB3196817165636438306614137E")

    private Rect mPositionIconAvailable = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.315 -0400", hash_original_field = "A7022393917A046B107561669A186E11", hash_generated_field = "8094973E932B3E44C1D67FDB46FBAE57")

    private Rect mPositionIconOutput = new Rect();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.315 -0400", hash_original_field = "AE2DAC280C84CE19350AD932AD159E5A", hash_generated_field = "B974C6A55EADCFD20CCECF43CCCF46A3")

    private boolean mShortcutCaptionMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.315 -0400", hash_original_field = "88C62A39A521FF21382A3356FB116AAB", hash_generated_field = "9F852047E3713B4D362B0C9DE43574F4")

    private String mShortcutCaption;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.316 -0400", hash_original_method = "333E717CC82B8C7442AB1D0ECD021DDF", hash_generated_method = "504DDFB0ED4116AED0787B55D7F11A01")
    public  IconMenuItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        addTaint(defStyle);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        if(sPrependShortcutLabel==null)        
        {
sPrependShortcutLabel=getResources().getString(com.android.internal.R.string.prepend_shortcut_label)
        } //End block
        TypedArray a = context.obtainStyledAttributes(
                attrs, com.android.internal.R.styleable.MenuView, defStyle, 0);
mDisabledAlpha=a.getFloat(com.android.internal.R.styleable.MenuView_itemIconDisabledAlpha, 0.8f)mTextAppearance=a.getResourceId(com.android.internal.R.styleable.MenuView_itemTextAppearance, -1)mTextAppearanceContext=contexta.recycle()
        // ---------- Original Method ----------
        //if (sPrependShortcutLabel == null) {
            //sPrependShortcutLabel = getResources().getString(
                    //com.android.internal.R.string.prepend_shortcut_label);
        //}
        //TypedArray a =
            //context.obtainStyledAttributes(
                //attrs, com.android.internal.R.styleable.MenuView, defStyle, 0);
        //mDisabledAlpha = a.getFloat(
                //com.android.internal.R.styleable.MenuView_itemIconDisabledAlpha, 0.8f);
        //mTextAppearance = a.getResourceId(com.android.internal.R.styleable.
                                          //MenuView_itemTextAppearance, -1);
        //mTextAppearanceContext = context;
        //a.recycle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.317 -0400", hash_original_method = "E8E8FF94AF2AEB616F5543925159C808", hash_generated_method = "0D07EC2BBEA868ABB904FD461C67BB21")
    public  IconMenuItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.317 -0400", hash_original_method = "D3EA499101C50F733538C7F2C71C7FCD", hash_generated_method = "FE7892E2413650F21D4BC9E6EBC6611D")
     void initialize(CharSequence title, Drawable icon) {
        addTaint(icon.getTaint());
        addTaint(title.getTaint());
setClickable(true)setFocusable(true)        if(mTextAppearance!=-1)        
        {
setTextAppearance(mTextAppearanceContext, mTextAppearance)
        } //End block
setTitle(title)setIcon(icon)
        // ---------- Original Method ----------
        //setClickable(true);
        //setFocusable(true);
        //if (mTextAppearance != -1) {
            //setTextAppearance(mTextAppearanceContext, mTextAppearance);
        //}
        //setTitle(title);
        //setIcon(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.318 -0400", hash_original_method = "1099F31E7523CC7CE24BCA918A71DE6A", hash_generated_method = "92A32E462C9F110CD3BC3DF0F53BB4D1")
    public void initialize(MenuItemImpl itemData, int menuType) {
        addTaint(menuType);
        addTaint(itemData.getTaint());
mItemData=itemDatainitialize(itemData.getTitleForItemView(this), itemData.getIcon())setVisibility(itemData.isVisible()?View.VISIBLE:View.VISIBLE)setEnabled(itemData.isEnabled())
        // ---------- Original Method ----------
        //mItemData = itemData;
        //initialize(itemData.getTitleForItemView(this), itemData.getIcon());
        //setVisibility(itemData.isVisible() ? View.VISIBLE : View.GONE);
        //setEnabled(itemData.isEnabled());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.318 -0400", hash_original_method = "408343F1CCEA5C2B74621865B3C13CF2", hash_generated_method = "ECBB5571BEAF24B37CEC5604B9EFC9E8")
    public void setItemData(MenuItemImpl data) {
        addTaint(data.getTaint());
mItemData=data
        // ---------- Original Method ----------
        //mItemData = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.319 -0400", hash_original_method = "1F3E4D754C7CA6574366D8D8716081C5", hash_generated_method = "3749D98933013E828AEC94A74E79BEB9")
    @Override
    public boolean performClick() {
        if(super.performClick())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_2084399601 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239675212 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239675212;
        } //End block
        if((mItemInvoker!=null)&&(mItemInvoker.invokeItem(mItemData)))        
        {
playSoundEffect(SoundEffectConstants.CLICK)            boolean varB326B5062B2F0E69046810717534CB09_279691915 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1347569934 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1347569934;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1010365792 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1749733852 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1749733852;
        } //End block
        // ---------- Original Method ----------
        //if (super.performClick()) {
            //return true;
        //}
        //if ((mItemInvoker != null) && (mItemInvoker.invokeItem(mItemData))) {
            //playSoundEffect(SoundEffectConstants.CLICK);
            //return true;
        //} else {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.320 -0400", hash_original_method = "435DDD074156E5F8AC666AFC90F64B0C", hash_generated_method = "6B2663E4CBCE038CAD145B958089F30B")
    public void setTitle(CharSequence title) {
        addTaint(title.getTaint());
        if(mShortcutCaptionMode)        
        {
setCaptionMode(true)
        } //End block
        else
        if(title!=null)        
        {
setText(title)
        } //End block
        // ---------- Original Method ----------
        //if (mShortcutCaptionMode) {
            //setCaptionMode(true);
        //} else if (title != null) {
            //setText(title);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.320 -0400", hash_original_method = "268E65D83193F6DFB62FB02E39B8BA58", hash_generated_method = "FAA384FCDA48AFD79EE5AF1ED0AE600B")
     void setCaptionMode(boolean shortcut) {
        addTaint(shortcut);
        if(mItemData==null)        
        {
            return;
        } //End block
mShortcutCaptionMode=shortcut&&(mItemData.shouldShowShortcut())        CharSequence text = mItemData.getTitleForItemView(this);
        if(mShortcutCaptionMode)        
        {
            if(mShortcutCaption==null)            
            {
mShortcutCaption=mItemData.getShortcutLabel()
            } //End block
text=mShortcutCaption
        } //End block
setText(text)
        // ---------- Original Method ----------
        //if (mItemData == null) {
            //return;
        //}
        //mShortcutCaptionMode = shortcut && (mItemData.shouldShowShortcut());
        //CharSequence text = mItemData.getTitleForItemView(this);
        //if (mShortcutCaptionMode) {
            //if (mShortcutCaption == null) {
                //mShortcutCaption = mItemData.getShortcutLabel();
            //}
            //text = mShortcutCaption;
        //}
        //setText(text);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.321 -0400", hash_original_method = "E86E1C6C90B3F8C756031A3C4EFA1265", hash_generated_method = "05C32894AE5F6DF65D97D186BCA2C74F")
    public void setIcon(Drawable icon) {
        addTaint(icon.getTaint());
mIcon=icon        if(icon!=null)        
        {
icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight())setCompoundDrawables(null, icon, null, null)setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL)requestLayout()
        } //End block
        else
        {
setCompoundDrawables(null, null, null, null)setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL)
        } //End block
        // ---------- Original Method ----------
        //mIcon = icon;
        //if (icon != null) {
            //icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            //setCompoundDrawables(null, icon, null, null);
            //setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);
            //requestLayout();
        //} else {
            //setCompoundDrawables(null, null, null, null);
            //setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.322 -0400", hash_original_method = "F13132D83BCDECF7A96B81A8D9495932", hash_generated_method = "EBE90E8023D0056E68B94E7778D0A13D")
    public void setItemInvoker(ItemInvoker itemInvoker) {
        addTaint(itemInvoker.getTaint());
mItemInvoker=itemInvoker
        // ---------- Original Method ----------
        //mItemInvoker = itemInvoker;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.322 -0400", hash_original_method = "F39E0849ABCF707480ABC0B9D2EE2311", hash_generated_method = "05F7D0A08A3416A4D955CAF6AE275CA0")
    @ViewDebug.CapturedViewProperty(retrieveReturn = true)
    public MenuItemImpl getItemData() {
MenuItemImpl varFD5535759C41B540EBDBAE602A671A91_1648208270 = mItemData        varFD5535759C41B540EBDBAE602A671A91_1648208270.addTaint(taint);
        return varFD5535759C41B540EBDBAE602A671A91_1648208270;
        // ---------- Original Method ----------
        //return mItemData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.322 -0400", hash_original_method = "18E20B37C2037D9678EE3D5F626F477A", hash_generated_method = "353D7E3487810EA5E043783AED64B5A2")
    @Override
    public void setVisibility(int v) {
        addTaint(v);
super.setVisibility(v)        if(mIconMenuView!=null)        
        {
mIconMenuView.markStaleChildren()
        } //End block
        // ---------- Original Method ----------
        //super.setVisibility(v);
        //if (mIconMenuView != null) {
            //mIconMenuView.markStaleChildren();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.323 -0400", hash_original_method = "F41FC72E52D0D0429768759B38C272E5", hash_generated_method = "75E4A6A5E38EE10B3D956AEA71F4C7BD")
     void setIconMenuView(IconMenuView iconMenuView) {
        addTaint(iconMenuView.getTaint());
mIconMenuView=iconMenuView
        // ---------- Original Method ----------
        //mIconMenuView = iconMenuView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.323 -0400", hash_original_method = "952F4BA8D09FBA47BFF7AA31D6EF11F8", hash_generated_method = "1E1C7C8B05EB7DB6430A08D5B12B9B96")
    @Override
    protected void drawableStateChanged() {
super.drawableStateChanged()        if(mItemData!=null&&mIcon!=null)        
        {
            final boolean isInAlphaState = !mItemData.isEnabled() && (isPressed() || !isFocused());
mIcon.setAlpha(isInAlphaState?(int) (mDisabledAlpha*NO_ALPHA):(int) (mDisabledAlpha*NO_ALPHA))
        } //End block
        // ---------- Original Method ----------
        //super.drawableStateChanged();
        //if (mItemData != null && mIcon != null) {
            //final boolean isInAlphaState = !mItemData.isEnabled() && (isPressed() || !isFocused());
            //mIcon.setAlpha(isInAlphaState ? (int) (mDisabledAlpha * NO_ALPHA) : NO_ALPHA);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.324 -0400", hash_original_method = "EC240A91CEC2FCFB14C22517271B909F", hash_generated_method = "C0742FCE612360E229403120629BB3DB")
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(bottom);
        addTaint(right);
        addTaint(top);
        addTaint(left);
        addTaint(changed);
super.onLayout(changed, left, top, right, bottom)positionIcon()
        // ---------- Original Method ----------
        //super.onLayout(changed, left, top, right, bottom);
        //positionIcon();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.324 -0400", hash_original_method = "B52C5A42BAF189526CC4D81203333F26", hash_generated_method = "02FE90148ED4E4C6860B4DC543484ED6")
    @Override
    protected void onTextChanged(CharSequence text, int start, int before, int after) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(after);
        addTaint(before);
        addTaint(start);
        addTaint(text.getTaint());
super.onTextChanged(text, start, before, after)setLayoutParams(getTextAppropriateLayoutParams())
        // ---------- Original Method ----------
        //super.onTextChanged(text, start, before, after);
        //setLayoutParams(getTextAppropriateLayoutParams());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.324 -0400", hash_original_method = "1A7B65F16ED9AD94820131969E68B65D", hash_generated_method = "0A1B166B60CA3EA8F912E46549E1027F")
     IconMenuView.LayoutParams getTextAppropriateLayoutParams() {
        IconMenuView.LayoutParams lp = (IconMenuView.LayoutParams) getLayoutParams();
        if(lp==null)        
        {
lp=new IconMenuView.LayoutParams(IconMenuView.LayoutParams.MATCH_PARENT, IconMenuView.LayoutParams.MATCH_PARENT)
        } //End block
lp.desiredWidth=(int) Layout.getDesiredWidth(getText(), getPaint())IconMenuView.LayoutParams var91B5D28524FC29CFA4C262BA1E7587AA_1449105383 = lp        var91B5D28524FC29CFA4C262BA1E7587AA_1449105383.addTaint(taint);
        return var91B5D28524FC29CFA4C262BA1E7587AA_1449105383;
        // ---------- Original Method ----------
        //IconMenuView.LayoutParams lp = (IconMenuView.LayoutParams) getLayoutParams();
        //if (lp == null) {
            //lp = new IconMenuView.LayoutParams(
                    //IconMenuView.LayoutParams.MATCH_PARENT, IconMenuView.LayoutParams.MATCH_PARENT);
        //}
        //lp.desiredWidth = (int) Layout.getDesiredWidth(getText(), getPaint());
        //return lp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.325 -0400", hash_original_method = "4276555C70F21953C97B2894725A8F05", hash_generated_method = "C15DC3621FE29D079E51650318B02172")
    private void positionIcon() {
        if(mIcon==null)        
        {
            return;
        } //End block
        Rect tmpRect = mPositionIconOutput;
getLineBounds(0, tmpRect)mPositionIconAvailable.set(0, 0, getWidth(), tmpRect.top)        final int layoutDirection = getResolvedLayoutDirection();
Gravity.apply(Gravity.CENTER_VERTICAL|Gravity.LEFT, mIcon.getIntrinsicWidth(), mIcon.getIntrinsicHeight(), mPositionIconAvailable, mPositionIconOutput, layoutDirection)mIcon.setBounds(mPositionIconOutput)
        // ---------- Original Method ----------
        //if (mIcon == null) {
            //return;
        //}
        //Rect tmpRect = mPositionIconOutput;
        //getLineBounds(0, tmpRect);
        //mPositionIconAvailable.set(0, 0, getWidth(), tmpRect.top);
        //final int layoutDirection = getResolvedLayoutDirection();
        //Gravity.apply(Gravity.CENTER_VERTICAL | Gravity.LEFT, mIcon.getIntrinsicWidth(), mIcon
                //.getIntrinsicHeight(), mPositionIconAvailable, mPositionIconOutput,
                //layoutDirection);
        //mIcon.setBounds(mPositionIconOutput);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.325 -0400", hash_original_method = "206C9D092F8D2CE8A945E1A45B818CB4", hash_generated_method = "BA66FBB494F3C28FF06B59EB6EC283AE")
    public void setCheckable(boolean checkable) {
        addTaint(checkable);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.325 -0400", hash_original_method = "98D5E38367DB01B2323D3E891737183A", hash_generated_method = "E13CE4DF4F9AB654448A696784A01853")
    public void setChecked(boolean checked) {
        addTaint(checked);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.326 -0400", hash_original_method = "BBB3858AAFDAD9070C5F59311E1CA341", hash_generated_method = "19C637ED876B874C6D8D76C0993E9C80")
    public void setShortcut(boolean showShortcut, char shortcutKey) {
        addTaint(shortcutKey);
        addTaint(showShortcut);
        if(mShortcutCaptionMode)        
        {
mShortcutCaption=nullsetCaptionMode(true)
        } //End block
        // ---------- Original Method ----------
        //if (mShortcutCaptionMode) {
            //mShortcutCaption = null;
            //setCaptionMode(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.326 -0400", hash_original_method = "A2F62AB27113ADE9EE493677370BEC6F", hash_generated_method = "4A6188B8B0124BF62FD3EFEA9A1AA4CD")
    public boolean prefersCondensedTitle() {
        boolean varB326B5062B2F0E69046810717534CB09_781501910 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_800057931 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_800057931;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.327 -0400", hash_original_method = "C76AE16CD3DCE07A39A065D6C2B5EB3F", hash_generated_method = "696A4FAC569B19A3FEE669DD0477D830")
    public boolean showsIcon() {
        boolean varB326B5062B2F0E69046810717534CB09_1125253837 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1929824794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1929824794;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.327 -0400", hash_original_field = "B56B6FA624E764C4691175252EBD6A92", hash_generated_field = "0FC0F1E74EFFD499D7E9EC90666C1A5B")

    private static final int NO_ALPHA = 0xFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.327 -0400", hash_original_field = "3610FD0730E1C31E028C448BDFDCFC99", hash_generated_field = "FC531438BE18962F76B22C0A35F07352")

    private static String sPrependShortcutLabel;
}

