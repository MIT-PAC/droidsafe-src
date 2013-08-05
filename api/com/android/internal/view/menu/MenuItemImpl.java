package com.android.internal.view.menu;

// Droidsafe Imports
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.widget.LinearLayout;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class MenuItemImpl implements MenuItem {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9AA2EA3A2433F5D6F841BEFD54A673B4")

    private int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "21346FE9F16EBAFFE8F776F66247523D", hash_generated_field = "139D723F0BCE25D04BC8D7611B468FC1")

    private int mGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "B75BDC891F05DF8D9F77776476EBCDD6", hash_generated_field = "C02FACC72341D8232DF7DE8FD533B005")

    private int mCategoryOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "CCC67011C0B9AB1BA64ACA217793FF17", hash_generated_field = "F78AA2B5B3BB60746ED63F2672F0EA55")

    private int mOrdering;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "4B03BBB3AD21DBD17B2B689923FCF1F6", hash_generated_field = "ECAB18871B55104BACD4283C12B1074D")

    private CharSequence mTitle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "793CD2D3A29DBCA3B6EE3D2D5CF29A55", hash_generated_field = "9A30B5EECA08BCE5933D9DF448C3C601")

    private CharSequence mTitleCondensed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "5CA918862E899FBE57CD8F3D0DB44604", hash_generated_field = "8174C310D8FCB34389A44779008F37E0")

    private char mShortcutNumericChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "FAC611210B68F831D4A3B699FB58A971", hash_generated_field = "8770A0798EAFB550D1AA0B00DDE29D71")

    private char mShortcutAlphabeticChar;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "EF18AFCEFBAD21F6B816E931AD814543", hash_generated_field = "5BBE9A13BBEFEFDBDAB0D9CE7CB28815")

    private Drawable mIconDrawable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "37AC3635461CA62872231C85492F3A9C", hash_generated_field = "EE82110FD9A3CA9E9DF583035E6FED49")

    private int mIconResId = NO_ICON;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "E163EBF815349370E2BC91E219960B88", hash_generated_field = "CCE2E7E9B41EB859D026207A515694B8")

    private SubMenuBuilder mSubMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "2B7E0A3FBDE4E506B96DAB7C97214944", hash_generated_field = "E128AFA2E0B8F17E3CC9B8F36180ADD8")

    private Runnable mItemCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.488 -0400", hash_original_field = "C7443C6F6983E9AE465DCA4986300561", hash_generated_field = "AA6E2E07B42742685233FC6C893D59E2")

    private MenuItem.OnMenuItemClickListener mClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.489 -0400", hash_original_field = "25DDE236B20D5D6403355424CC7CFB83", hash_generated_field = "D6D6F10145E678C7E543CE23CD198F05")

    private int mFlags = ENABLED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.489 -0400", hash_original_field = "EE351B57987290D5C97C12334A4F5C8A", hash_generated_field = "7FED0AA513FCAFE5BBB64F7D855AC56C")

    private int mShowAsAction = SHOW_AS_ACTION_NEVER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.489 -0400", hash_original_field = "42ED82821F0D805CE8C635AE635639B9", hash_generated_field = "67E37FA198462CB2D5A9B9320B838135")

    private View mActionView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.489 -0400", hash_original_field = "6F151B4E913A23BC3B3F9FF725385336", hash_generated_field = "43987C5D315D6540F5B86319E4F6655F")

    private ActionProvider mActionProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.489 -0400", hash_original_field = "20990041D5CB5868F5C6A4F0A5C55C0F", hash_generated_field = "784094F6CF284A96EDEED4548B8FB05D")

    private OnActionExpandListener mOnActionExpandListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.489 -0400", hash_original_field = "07492CDCBB9799261CC2942AB3F6D415", hash_generated_field = "06A110AC8494F5C7468903392B66FD97")

    private boolean mIsActionViewExpanded = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.489 -0400", hash_original_field = "17699AE07D9C5F03811167BB1003FF3E", hash_generated_field = "B7A128C3CB7F07DDB09B9D1855650533")

    private ContextMenuInfo mMenuInfo;
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.491 -0400", hash_original_method = "64F6A72F78EB0039947A0530C3919D96", hash_generated_method = "81F31BB5B03E1E465D2BB0C07E80756D")
      MenuItemImpl(MenuBuilder menu, int group, int id, int categoryOrder, int ordering,
            CharSequence title, int showAsAction) {
        if(sPrependShortcutLabel == null)        
        {
            sPrependShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.prepend_shortcut_label);
            sEnterShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_enter_shortcut_label);
            sDeleteShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_delete_shortcut_label);
            sSpaceShortcutLabel = menu.getContext().getResources().getString(
                    com.android.internal.R.string.menu_space_shortcut_label);
        } //End block
        mMenu = menu;
        mId = id;
        mGroup = group;
        mCategoryOrder = categoryOrder;
        mOrdering = ordering;
        mTitle = title;
        mShowAsAction = showAsAction;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.492 -0400", hash_original_method = "DCB176B376623FC7561DCD073EB66D0A", hash_generated_method = "66EEB6B757B83AC24CE6DC37670349CB")
    public boolean invoke() {
        if(mClickListener != null &&
            mClickListener.onMenuItemClick(this))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_2056633494 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_566862244 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_566862244;
        } //End block
        if(mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this))        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1049791192 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1930578054 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1930578054;
        } //End block
        if(mItemCallback != null)        
        {
            mItemCallback.run();
            boolean varB326B5062B2F0E69046810717534CB09_1346640748 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1616949688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1616949688;
        } //End block
        if(mIntent != null)        
        {
            try 
            {
                mMenu.getContext().startActivity(mIntent);
                boolean varB326B5062B2F0E69046810717534CB09_1174417447 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_803822082 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_803822082;
            } //End block
            catch (ActivityNotFoundException e)
            {
            } //End block
        } //End block
        if(mActionProvider != null && mActionProvider.onPerformDefaultAction())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1351935999 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_419694158 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_419694158;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_798718838 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1389254100 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1389254100;
        // ---------- Original Method ----------
        //if (mClickListener != null &&
            //mClickListener.onMenuItemClick(this)) {
            //return true;
        //}
        //if (mMenu.dispatchMenuItemSelected(mMenu.getRootMenu(), this)) {
            //return true;
        //}
        //if (mItemCallback != null) {
            //mItemCallback.run();
            //return true;
        //}
        //if (mIntent != null) {
            //try {
                //mMenu.getContext().startActivity(mIntent);
                //return true;
            //} catch (ActivityNotFoundException e) {
                //Log.e(TAG, "Can't find activity to handle intent; ignoring", e);
            //}
        //}
        //if (mActionProvider != null && mActionProvider.onPerformDefaultAction()) {
            //return true;
        //}
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.493 -0400", hash_original_method = "064128A7513C2649CACBBF797CFF0AF2", hash_generated_method = "F659CE12CE71AA2C67DD60634867CEC2")
    public boolean isEnabled() {
        boolean varB87D9597EA81BF64B4340D9A8EF353D6_361961354 = ((mFlags & ENABLED) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1290038044 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1290038044;
        // ---------- Original Method ----------
        //return (mFlags & ENABLED) != 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.494 -0400", hash_original_method = "D7CDC1A4A52E7AA2B30AF0AEE42BB489", hash_generated_method = "A79ACA7271AF1F35CC44722F217E7AC8")
    public MenuItem setEnabled(boolean enabled) {
        addTaint(enabled);
        if(enabled)        
        {
            mFlags |= ENABLED;
        } //End block
        else
        {
            mFlags &= ~ENABLED;
        } //End block
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_821066721 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_821066721.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_821066721;
        // ---------- Original Method ----------
        //if (enabled) {
            //mFlags |= ENABLED;
        //} else {
            //mFlags &= ~ENABLED;
        //}
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.494 -0400", hash_original_method = "66AB3334E79E1A7B9556FEE3F51B4E39", hash_generated_method = "AA7956FA6319D5325FBAB17A535FA10D")
    public int getGroupId() {
        int var21346FE9F16EBAFFE8F776F66247523D_580705593 = (mGroup);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221277675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_221277675;
        // ---------- Original Method ----------
        //return mGroup;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.494 -0400", hash_original_method = "885331F67BBD80203E95A04A19AE99CE", hash_generated_method = "1A5641DC985BB8CFB911F70638149330")
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_1948700941 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1662066546 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1662066546;
        // ---------- Original Method ----------
        //return mId;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.495 -0400", hash_original_method = "C3905BED22935FA2186A402E1BBD1829", hash_generated_method = "638C5460950E7E944727C37E77483C1B")
    public int getOrder() {
        int varB75BDC891F05DF8D9F77776476EBCDD6_250149696 = (mCategoryOrder);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220349594 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1220349594;
        // ---------- Original Method ----------
        //return mCategoryOrder;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.495 -0400", hash_original_method = "92E8F82AA50FD1AD58335B2DC7895A83", hash_generated_method = "E2393B27F4918275C28AA94690060A16")
    public int getOrdering() {
        int varCCC67011C0B9AB1BA64ACA217793FF17_823222338 = (mOrdering);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692563455 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692563455;
        // ---------- Original Method ----------
        //return mOrdering;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.495 -0400", hash_original_method = "AD027B7B58A4A2F151CC138FB7B23244", hash_generated_method = "64B0693680DD7438AE0F2901293B24FB")
    public Intent getIntent() {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_889600146 =         mIntent;
        var4DCF8E3D75AE0B94CDA94656DCE16BCE_889600146.addTaint(taint);
        return var4DCF8E3D75AE0B94CDA94656DCE16BCE_889600146;
        // ---------- Original Method ----------
        //return mIntent;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.496 -0400", hash_original_method = "17F59D8B490C99308235DB62C5632C43", hash_generated_method = "472023B73FEBC44EA97136279866A16D")
    public MenuItem setIntent(Intent intent) {
        mIntent = intent;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1867814320 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1867814320.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1867814320;
        // ---------- Original Method ----------
        //mIntent = intent;
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.496 -0400", hash_original_method = "C32C9CAC3047604A3F615D0E2B0A3D92", hash_generated_method = "8F3FBE3593253C6743B224C85B92786A")
     Runnable getCallback() {
Runnable var994B3DDE084BD7BF79ED19A07059E09C_899305698 =         mItemCallback;
        var994B3DDE084BD7BF79ED19A07059E09C_899305698.addTaint(taint);
        return var994B3DDE084BD7BF79ED19A07059E09C_899305698;
        // ---------- Original Method ----------
        //return mItemCallback;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.496 -0400", hash_original_method = "CAD9375B57D68888676D597787CB9AA1", hash_generated_method = "EE20284733DD04D827B0102CA5995FAA")
    public MenuItem setCallback(Runnable callback) {
        mItemCallback = callback;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1367046923 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1367046923.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1367046923;
        // ---------- Original Method ----------
        //mItemCallback = callback;
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.497 -0400", hash_original_method = "74420A18C35CD9809E945AA28295EB23", hash_generated_method = "AC166B57E00C0CA77EFB0B1CA71D5269")
    public char getAlphabeticShortcut() {
        char varFAC611210B68F831D4A3B699FB58A971_515873088 = (mShortcutAlphabeticChar);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1978813201 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1978813201;
        // ---------- Original Method ----------
        //return mShortcutAlphabeticChar;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.498 -0400", hash_original_method = "88D9907A20D6B14742A0B31CE890DEE4", hash_generated_method = "B8F16E2D4F5F9B026946A43606BB1006")
    public MenuItem setAlphabeticShortcut(char alphaChar) {
        if(mShortcutAlphabeticChar == alphaChar)        
        {
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1935165644 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1935165644.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1935165644;
        }
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1080248772 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1080248772.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1080248772;
        // ---------- Original Method ----------
        //if (mShortcutAlphabeticChar == alphaChar) return this;
        //mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.499 -0400", hash_original_method = "4BF7437C18C8B8610ED809C4B1A41FBC", hash_generated_method = "C76A3078DA380D6059416A3623BD9F75")
    public char getNumericShortcut() {
        char var5CA918862E899FBE57CD8F3D0DB44604_1075340137 = (mShortcutNumericChar);
                char varA87DEB01C5F539E6BDA34829C8EF2368_385907708 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_385907708;
        // ---------- Original Method ----------
        //return mShortcutNumericChar;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.499 -0400", hash_original_method = "C979D44A5E5C9CB1A686CC5CF090F436", hash_generated_method = "34C39EE429F66F9DED73E1CFD5E48DB8")
    public MenuItem setNumericShortcut(char numericChar) {
        if(mShortcutNumericChar == numericChar)        
        {
MenuItem var72A74007B2BE62B849F475C7BDA4658B_645285584 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_645285584.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_645285584;
        }
        mShortcutNumericChar = numericChar;
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1575470151 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1575470151.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1575470151;
        // ---------- Original Method ----------
        //if (mShortcutNumericChar == numericChar) return this;
        //mShortcutNumericChar = numericChar;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.500 -0400", hash_original_method = "0C4A5B3F8F292031B8A33F43134542C3", hash_generated_method = "4D785D6DBAB2208C5A6E07A3D5B73747")
    public MenuItem setShortcut(char numericChar, char alphaChar) {
        mShortcutNumericChar = numericChar;
        mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_776039364 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_776039364.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_776039364;
        // ---------- Original Method ----------
        //mShortcutNumericChar = numericChar;
        //mShortcutAlphabeticChar = Character.toLowerCase(alphaChar);
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.500 -0400", hash_original_method = "D96803BF052A5945B7D152CA36FE6B7E", hash_generated_method = "DC84CC592A977C0AA8781F009D92C542")
     char getShortcut() {
        char var15D8842BF948C8124ABD1C2CAA208C37_37231017 = ((mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar));
                char varA87DEB01C5F539E6BDA34829C8EF2368_258270680 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_258270680;
        // ---------- Original Method ----------
        //return (mMenu.isQwertyMode() ? mShortcutAlphabeticChar : mShortcutNumericChar);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.501 -0400", hash_original_method = "BC454AC179D3698A29B0357FA131C3B2", hash_generated_method = "5B61AC0637ADCA3D428FB27A55F60181")
     String getShortcutLabel() {
        char shortcut = getShortcut();
        if(shortcut == 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_460188976 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_460188976.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_460188976;
        } //End block
        StringBuilder sb = new StringBuilder(sPrependShortcutLabel);
switch(shortcut){
        case '\n':
        sb.append(sEnterShortcutLabel);
        break;
        case '\b':
        sb.append(sDeleteShortcutLabel);
        break;
        case ' ':
        sb.append(sSpaceShortcutLabel);
        break;
        default:
        sb.append(shortcut);
        break;
}String var2460B846747F8B22185AD8BE722266A5_1703751700 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1703751700.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1703751700;
        // ---------- Original Method ----------
        //char shortcut = getShortcut();
        //if (shortcut == 0) {
            //return "";
        //}
        //StringBuilder sb = new StringBuilder(sPrependShortcutLabel);
        //switch (shortcut) {
            //case '\n':
                //sb.append(sEnterShortcutLabel);
                //break;
            //case '\b':
                //sb.append(sDeleteShortcutLabel);
                //break;
            //case ' ':
                //sb.append(sSpaceShortcutLabel);
                //break;
            //default:
                //sb.append(shortcut);
                //break;
        //}
        //return sb.toString();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.501 -0400", hash_original_method = "10F1B2AEF5DA21C52B4C4E0F70D42C6B", hash_generated_method = "0956E5E71E3D81CF5E374BA04CA67F2E")
     boolean shouldShowShortcut() {
        boolean var85E954290E01E66D0EA0EB08C143A431_398334586 = (mMenu.isShortcutsVisible() && (getShortcut() != 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_468879777 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_468879777;
        // ---------- Original Method ----------
        //return mMenu.isShortcutsVisible() && (getShortcut() != 0);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.501 -0400", hash_original_method = "4569B511D747F82913D0DE9D1EF62E55", hash_generated_method = "78A37249DB9BF75476F8D88116498CBF")
    public SubMenu getSubMenu() {
SubMenu varC083E519FF4D11870DD99D803CC3087D_167769046 =         mSubMenu;
        varC083E519FF4D11870DD99D803CC3087D_167769046.addTaint(taint);
        return varC083E519FF4D11870DD99D803CC3087D_167769046;
        // ---------- Original Method ----------
        //return mSubMenu;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.501 -0400", hash_original_method = "4556386DBA75360C55B0D4465EB5905E", hash_generated_method = "CF0046CBD3DA099761579028B52EA1F1")
    public boolean hasSubMenu() {
        boolean var59EAA12D7074A8427FEE88E96B6727FC_486643730 = (mSubMenu != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1551967848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1551967848;
        // ---------- Original Method ----------
        //return mSubMenu != null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.501 -0400", hash_original_method = "84077AC2D714BDDE1A3A80B85CC9BFB0", hash_generated_method = "9BE0E7ADF2FF7A8D98A414C8B1B91CC8")
     void setSubMenu(SubMenuBuilder subMenu) {
        mSubMenu = subMenu;
        subMenu.setHeaderTitle(getTitle());
        // ---------- Original Method ----------
        //mSubMenu = subMenu;
        //subMenu.setHeaderTitle(getTitle());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.501 -0400", hash_original_method = "7D691BCB64236E7B5AF8F6CB0399C091", hash_generated_method = "6994DF31856B647888356F87F28B7815")
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
CharSequence var4FE0D95ADE4B4BDFA36D55D8B62A6C49_945372969 =         mTitle;
        var4FE0D95ADE4B4BDFA36D55D8B62A6C49_945372969.addTaint(taint);
        return var4FE0D95ADE4B4BDFA36D55D8B62A6C49_945372969;
        // ---------- Original Method ----------
        //return mTitle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.501 -0400", hash_original_method = "6C0965535A50DC1B1EFB814EBEDF6248", hash_generated_method = "8DF0ED81FE34BE9206BAB1AAA8E0CCCD")
     CharSequence getTitleForItemView(MenuView.ItemView itemView) {
        addTaint(itemView.getTaint());
CharSequence varC8148C3D47075D36ED08877976FCC1CB_1455336521 =         ((itemView != null) && itemView.prefersCondensedTitle())
                ? getTitleCondensed()
                : getTitle();
        varC8148C3D47075D36ED08877976FCC1CB_1455336521.addTaint(taint);
        return varC8148C3D47075D36ED08877976FCC1CB_1455336521;
        // ---------- Original Method ----------
        //return ((itemView != null) && itemView.prefersCondensedTitle())
                //? getTitleCondensed()
                //: getTitle();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.502 -0400", hash_original_method = "1E48645B8578DDF9EFFB5676592C549A", hash_generated_method = "FBD913FADB702E57443AC555118BE5EB")
    public MenuItem setTitle(CharSequence title) {
        mTitle = title;
        mMenu.onItemsChanged(false);
        if(mSubMenu != null)        
        {
            mSubMenu.setHeaderTitle(title);
        } //End block
MenuItem var72A74007B2BE62B849F475C7BDA4658B_633095316 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_633095316.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_633095316;
        // ---------- Original Method ----------
        //mTitle = title;
        //mMenu.onItemsChanged(false);
        //if (mSubMenu != null) {
            //mSubMenu.setHeaderTitle(title);
        //}
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.502 -0400", hash_original_method = "504EB589769814F693A853F99C8002C5", hash_generated_method = "50FA43C69FB9B081C78D549ABF3351B5")
    public MenuItem setTitle(int title) {
        addTaint(title);
MenuItem var0E1869CCC2CA3BCD99ECDF58FF98A0E5_16226560 =         setTitle(mMenu.getContext().getString(title));
        var0E1869CCC2CA3BCD99ECDF58FF98A0E5_16226560.addTaint(taint);
        return var0E1869CCC2CA3BCD99ECDF58FF98A0E5_16226560;
        // ---------- Original Method ----------
        //return setTitle(mMenu.getContext().getString(title));
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.502 -0400", hash_original_method = "2F32534D1148FE277B46E47FA445D759", hash_generated_method = "906C19CFB45C7F1ACE78BD2C35A7DBC7")
    public CharSequence getTitleCondensed() {
CharSequence varCF2C43BCC97AC29D7C72C9E3E2C7AC7A_1741440504 =         mTitleCondensed != null ? mTitleCondensed : mTitle;
        varCF2C43BCC97AC29D7C72C9E3E2C7AC7A_1741440504.addTaint(taint);
        return varCF2C43BCC97AC29D7C72C9E3E2C7AC7A_1741440504;
        // ---------- Original Method ----------
        //return mTitleCondensed != null ? mTitleCondensed : mTitle;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.502 -0400", hash_original_method = "A10897990E671CAED83F82CF9B7ADDEE", hash_generated_method = "9D165B873242AE3B4CE25C5704FD0DB7")
    public MenuItem setTitleCondensed(CharSequence title) {
        mTitleCondensed = title;
        if(title == null)        
        {
            title = mTitle;
        } //End block
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_314504438 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_314504438.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_314504438;
        // ---------- Original Method ----------
        //mTitleCondensed = title;
        //if (title == null) {
            //title = mTitle;
        //}
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.502 -0400", hash_original_method = "77C51DB63A44599458883D3753A34CC1", hash_generated_method = "89A08447D5CD17154A2D93E867B34CE5")
    public Drawable getIcon() {
        if(mIconDrawable != null)        
        {
Drawable var5B92DD146545638DBC028505FF353915_986888593 =             mIconDrawable;
            var5B92DD146545638DBC028505FF353915_986888593.addTaint(taint);
            return var5B92DD146545638DBC028505FF353915_986888593;
        } //End block
        if(mIconResId != NO_ICON)        
        {
Drawable var21CC05CB12DD717B030220BB31472275_838293592 =             mMenu.getResources().getDrawable(mIconResId);
            var21CC05CB12DD717B030220BB31472275_838293592.addTaint(taint);
            return var21CC05CB12DD717B030220BB31472275_838293592;
        } //End block
Drawable var540C13E9E156B687226421B24F2DF178_2128482707 =         null;
        var540C13E9E156B687226421B24F2DF178_2128482707.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2128482707;
        // ---------- Original Method ----------
        //if (mIconDrawable != null) {
            //return mIconDrawable;
        //}
        //if (mIconResId != NO_ICON) {
            //return mMenu.getResources().getDrawable(mIconResId);
        //}
        //return null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.502 -0400", hash_original_method = "BD8BE6A7204F93A97A4B1462396F9006", hash_generated_method = "84718A60F29A5DB234F67E6CD61F3966")
    public MenuItem setIcon(Drawable icon) {
        mIconResId = NO_ICON;
        mIconDrawable = icon;
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_685367155 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_685367155.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_685367155;
        // ---------- Original Method ----------
        //mIconResId = NO_ICON;
        //mIconDrawable = icon;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.503 -0400", hash_original_method = "6CA4716E877DA09BBA89FF884DD9F3E1", hash_generated_method = "861FE42D9F3BC2FF1E0987EE9984FAA2")
    public MenuItem setIcon(int iconResId) {
        mIconDrawable = null;
        mIconResId = iconResId;
        mMenu.onItemsChanged(false);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1612408409 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1612408409.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1612408409;
        // ---------- Original Method ----------
        //mIconDrawable = null;
        //mIconResId = iconResId;
        //mMenu.onItemsChanged(false);
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.503 -0400", hash_original_method = "03294EC000E2E3A998710BD4D5DBC105", hash_generated_method = "E950F8DB8D16E156DE5773CE93779C4C")
    public boolean isCheckable() {
        boolean var6BB28F79584CC39AD277C56B84E68B02_1669354335 = ((mFlags & CHECKABLE) == CHECKABLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_462595990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_462595990;
        // ---------- Original Method ----------
        //return (mFlags & CHECKABLE) == CHECKABLE;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.503 -0400", hash_original_method = "97D03B8420DC0405BDED5AEBB6194B4D", hash_generated_method = "676F4E1316909F859351E52BFE7449D4")
    public MenuItem setCheckable(boolean checkable) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        if(oldFlags != mFlags)        
        {
            mMenu.onItemsChanged(false);
        } //End block
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1637232529 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1637232529.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1637232529;
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~CHECKABLE) | (checkable ? CHECKABLE : 0);
        //if (oldFlags != mFlags) {
            //mMenu.onItemsChanged(false);
        //}
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.503 -0400", hash_original_method = "D48B0A4B4830ACC112B29145FA304FB9", hash_generated_method = "72956FA378A284989864C014D06C7B79")
    public void setExclusiveCheckable(boolean exclusive) {
        mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
        // ---------- Original Method ----------
        //mFlags = (mFlags & ~EXCLUSIVE) | (exclusive ? EXCLUSIVE : 0);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.503 -0400", hash_original_method = "09CA122F8C23D0DDA91200023A557A5D", hash_generated_method = "E7FB467D4CDBD74A314F4DE7321AF335")
    public boolean isExclusiveCheckable() {
        boolean var8096B85672A60979E0F73628CCE17272_24534398 = ((mFlags & EXCLUSIVE) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1277850722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1277850722;
        // ---------- Original Method ----------
        //return (mFlags & EXCLUSIVE) != 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.504 -0400", hash_original_method = "153A3CA3675B13C11B20504065FC3BF7", hash_generated_method = "1B4FFA5B5B17DF472B0AF1B712BE0F3F")
    public boolean isChecked() {
        boolean varCC46849F211A0B2A01D25E271291DD49_1367732414 = ((mFlags & CHECKED) == CHECKED);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1487650697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1487650697;
        // ---------- Original Method ----------
        //return (mFlags & CHECKED) == CHECKED;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.504 -0400", hash_original_method = "9107E25FB1CB75DAB92AC94A4D8833A7", hash_generated_method = "F26158675779E3929342C2F8E6750B5F")
    public MenuItem setChecked(boolean checked) {
        addTaint(checked);
        if((mFlags & EXCLUSIVE) != 0)        
        {
            mMenu.setExclusiveItemChecked(this);
        } //End block
        else
        {
            setCheckedInt(checked);
        } //End block
MenuItem var72A74007B2BE62B849F475C7BDA4658B_724523338 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_724523338.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_724523338;
        // ---------- Original Method ----------
        //if ((mFlags & EXCLUSIVE) != 0) {
            //mMenu.setExclusiveItemChecked(this);
        //} else {
            //setCheckedInt(checked);
        //}
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.504 -0400", hash_original_method = "F4E3FA5EA691BD61029F7B342451D96B", hash_generated_method = "9542732515D02F97052891CEB6960F5D")
     void setCheckedInt(boolean checked) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        if(oldFlags != mFlags)        
        {
            mMenu.onItemsChanged(false);
        } //End block
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~CHECKED) | (checked ? CHECKED : 0);
        //if (oldFlags != mFlags) {
            //mMenu.onItemsChanged(false);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.504 -0400", hash_original_method = "81B83940195E51D968E293DAB7D6B254", hash_generated_method = "23EBB0A4953C862D31BA0ABB0432C8DA")
    public boolean isVisible() {
        boolean varE913D4BE32099E3F386AB8D84C78AB5D_1518781629 = ((mFlags & HIDDEN) == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824301911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_824301911;
        // ---------- Original Method ----------
        //return (mFlags & HIDDEN) == 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.504 -0400", hash_original_method = "6BBB65AE1F8C0F9A0552DC908B4D29C9", hash_generated_method = "362948F89824B0B132524BE05B2B035D")
     boolean setVisibleInt(boolean shown) {
        final int oldFlags = mFlags;
        mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        boolean var4B5C72ED6FA81B932732EC41C6FE39DB_987741006 = (oldFlags != mFlags);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975093906 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_975093906;
        // ---------- Original Method ----------
        //final int oldFlags = mFlags;
        //mFlags = (mFlags & ~HIDDEN) | (shown ? 0 : HIDDEN);
        //return oldFlags != mFlags;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.504 -0400", hash_original_method = "C575291A3325EE507AB9F55E92185E54", hash_generated_method = "C37373E1D7BB4ABA1456A66C567F1FF8")
    public MenuItem setVisible(boolean shown) {
        addTaint(shown);
        if(setVisibleInt(shown))        
        mMenu.onItemVisibleChanged(this);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_469697895 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_469697895.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_469697895;
        // ---------- Original Method ----------
        //if (setVisibleInt(shown)) mMenu.onItemVisibleChanged(this);
        //return this;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.505 -0400", hash_original_method = "1DDD55F9AC5A73432BCD73A94619FD45", hash_generated_method = "E75BF3EC2BCFA7092950426AEA5601BC")
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener clickListener) {
        mClickListener = clickListener;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1748031452 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1748031452.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1748031452;
        // ---------- Original Method ----------
        //mClickListener = clickListener;
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.505 -0400", hash_original_method = "233A3AFEB21203525FBA5B1CF441183E", hash_generated_method = "558216381D6CA93B47AF1D464517F791")
    @Override
    public String toString() {
String varD16376414E90AD88020E4E5437397840_1659929342 =         mTitle.toString();
        varD16376414E90AD88020E4E5437397840_1659929342.addTaint(taint);
        return varD16376414E90AD88020E4E5437397840_1659929342;
        // ---------- Original Method ----------
        //return mTitle.toString();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.505 -0400", hash_original_method = "B6421912A15ECCB29CB28DC744FEB4DF", hash_generated_method = "48D720FE3E7BA870AFBD08C536357B9E")
     void setMenuInfo(ContextMenuInfo menuInfo) {
        mMenuInfo = menuInfo;
        // ---------- Original Method ----------
        //mMenuInfo = menuInfo;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.505 -0400", hash_original_method = "A0E326FAE2703231717DF34591A2C639", hash_generated_method = "FAAF794EE5B2B084F84C82260C9D616C")
    public ContextMenuInfo getMenuInfo() {
ContextMenuInfo var05CE4E445EB5B7476BF0CDD0DC01EBEC_1585029090 =         mMenuInfo;
        var05CE4E445EB5B7476BF0CDD0DC01EBEC_1585029090.addTaint(taint);
        return var05CE4E445EB5B7476BF0CDD0DC01EBEC_1585029090;
        // ---------- Original Method ----------
        //return mMenuInfo;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.505 -0400", hash_original_method = "221F1892BBAF0D6C0448BF9B80F29C7C", hash_generated_method = "AA105CD9041C087568465B6F262D8004")
    public void actionFormatChanged() {
        mMenu.onItemActionRequestChanged(this);
        // ---------- Original Method ----------
        //mMenu.onItemActionRequestChanged(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.505 -0400", hash_original_method = "B7358CCF217D02273B220AA1E4900E11", hash_generated_method = "163AD55D6EC66EF0D06D9D4E34255364")
    public boolean shouldShowIcon() {
        boolean var5E1F8CD1F4DACFEE1DFD21FC398A511F_2021993244 = (mMenu.getOptionalIconsVisible());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2070587595 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2070587595;
        // ---------- Original Method ----------
        //return mMenu.getOptionalIconsVisible();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.505 -0400", hash_original_method = "8639B741C99124BF9C4FC28DBCA735D7", hash_generated_method = "6E4C95C27212A30AD41EB8340A73D9C2")
    public boolean isActionButton() {
        boolean varDA2D3C3EC0D999656803688D27357310_309710636 = ((mFlags & IS_ACTION) == IS_ACTION);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2047574521 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2047574521;
        // ---------- Original Method ----------
        //return (mFlags & IS_ACTION) == IS_ACTION;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.505 -0400", hash_original_method = "D20AA9738309FEFC21F93C6653D8A4BB", hash_generated_method = "E4F441CEDC4F0D5E533E71834527F521")
    public boolean requestsActionButton() {
        boolean var2CC5D29C4D044C456BC205735E1650B7_125174534 = ((mShowAsAction & SHOW_AS_ACTION_IF_ROOM) == SHOW_AS_ACTION_IF_ROOM);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888383728 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888383728;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_IF_ROOM) == SHOW_AS_ACTION_IF_ROOM;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.505 -0400", hash_original_method = "A0218090F414AFC2516DB1AFD001E557", hash_generated_method = "EFB538155F787F2AA521D1E72C1B2E88")
    public boolean requiresActionButton() {
        boolean varAB926195308BD6E1AF5A6EF6FE78277F_1539116267 = ((mShowAsAction & SHOW_AS_ACTION_ALWAYS) == SHOW_AS_ACTION_ALWAYS);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2035342199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2035342199;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_ALWAYS) == SHOW_AS_ACTION_ALWAYS;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.505 -0400", hash_original_method = "7A64484A152776341109FA7C71AB82BB", hash_generated_method = "22EA4C09EF7A8C0A08DD3D77EDCD284E")
    public void setIsActionButton(boolean isActionButton) {
        addTaint(isActionButton);
        if(isActionButton)        
        {
            mFlags |= IS_ACTION;
        } //End block
        else
        {
            mFlags &= ~IS_ACTION;
        } //End block
        // ---------- Original Method ----------
        //if (isActionButton) {
            //mFlags |= IS_ACTION;
        //} else {
            //mFlags &= ~IS_ACTION;
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.506 -0400", hash_original_method = "D19EFCF4D4C49A6F9A7B8D6E601DFE3B", hash_generated_method = "99AC079F19697B4A621BFFB377D0914D")
    public boolean showsTextAsAction() {
        boolean var43B66AAB0F5FC6D3BFBA8260B2E22E71_1240891173 = ((mShowAsAction & SHOW_AS_ACTION_WITH_TEXT) == SHOW_AS_ACTION_WITH_TEXT);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1116325888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1116325888;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_WITH_TEXT) == SHOW_AS_ACTION_WITH_TEXT;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.506 -0400", hash_original_method = "6034AD3E3F15BF95CED1827A99F9830A", hash_generated_method = "FA4124A5288DA9C1416D887BD5D42FB9")
    public void setShowAsAction(int actionEnum) {
switch(actionEnum & SHOW_AS_ACTION_MASK){
        case SHOW_AS_ACTION_ALWAYS:
        case SHOW_AS_ACTION_IF_ROOM:
        case SHOW_AS_ACTION_NEVER:
        break;
        default:
        IllegalArgumentException var7789CF77216A8CAA5E5E20DB36F22F7A_2015140022 = new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM,"
                        + " and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        var7789CF77216A8CAA5E5E20DB36F22F7A_2015140022.addTaint(taint);
        throw var7789CF77216A8CAA5E5E20DB36F22F7A_2015140022;
}        mShowAsAction = actionEnum;
        mMenu.onItemActionRequestChanged(this);
        // ---------- Original Method ----------
        //switch (actionEnum & SHOW_AS_ACTION_MASK) {
            //case SHOW_AS_ACTION_ALWAYS:
            //case SHOW_AS_ACTION_IF_ROOM:
            //case SHOW_AS_ACTION_NEVER:
                //break;
            //default:
                //throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM,"
                        //+ " and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        //}
        //mShowAsAction = actionEnum;
        //mMenu.onItemActionRequestChanged(this);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.506 -0400", hash_original_method = "9511E068798AA5E04A674F02DC2F7567", hash_generated_method = "1564660D52D876CB433B27662C63BC1D")
    public MenuItem setActionView(View view) {
        mActionView = view;
        mActionProvider = null;
        if(view != null && view.getId() == View.NO_ID && mId > 0)        
        {
            view.setId(mId);
        } //End block
        mMenu.onItemActionRequestChanged(this);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_991952340 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_991952340.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_991952340;
        // ---------- Original Method ----------
        //mActionView = view;
        //mActionProvider = null;
        //if (view != null && view.getId() == View.NO_ID && mId > 0) {
            //view.setId(mId);
        //}
        //mMenu.onItemActionRequestChanged(this);
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.506 -0400", hash_original_method = "B057E2C488C14BC05DF25DD2F229F8B2", hash_generated_method = "F2E1855B7EE143D2C5863B0587509248")
    public MenuItem setActionView(int resId) {
        addTaint(resId);
        final Context context = mMenu.getContext();
        final LayoutInflater inflater = LayoutInflater.from(context);
        setActionView(inflater.inflate(resId, new LinearLayout(context), false));
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1583632757 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1583632757.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1583632757;
        // ---------- Original Method ----------
        //final Context context = mMenu.getContext();
        //final LayoutInflater inflater = LayoutInflater.from(context);
        //setActionView(inflater.inflate(resId, new LinearLayout(context), false));
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.506 -0400", hash_original_method = "404D78F2C7005B21FAAA5C37E608175C", hash_generated_method = "D2DC8DEECB4FEDF39CECE47F022343CC")
    public View getActionView() {
        if(mActionView != null)        
        {
View var1CB7DEAB86EEBCB021D745E4C8E8D1D7_606662688 =             mActionView;
            var1CB7DEAB86EEBCB021D745E4C8E8D1D7_606662688.addTaint(taint);
            return var1CB7DEAB86EEBCB021D745E4C8E8D1D7_606662688;
        } //End block
        else
        if(mActionProvider != null)        
        {
            mActionView = mActionProvider.onCreateActionView();
View var1CB7DEAB86EEBCB021D745E4C8E8D1D7_2073834283 =             mActionView;
            var1CB7DEAB86EEBCB021D745E4C8E8D1D7_2073834283.addTaint(taint);
            return var1CB7DEAB86EEBCB021D745E4C8E8D1D7_2073834283;
        } //End block
        else
        {
View var540C13E9E156B687226421B24F2DF178_755382892 =             null;
            var540C13E9E156B687226421B24F2DF178_755382892.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_755382892;
        } //End block
        // ---------- Original Method ----------
        //if (mActionView != null) {
            //return mActionView;
        //} else if (mActionProvider != null) {
            //mActionView = mActionProvider.onCreateActionView();
            //return mActionView;
        //} else {
            //return null;
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.506 -0400", hash_original_method = "F6993BB94930E20BEF3D6DE6883E2D9B", hash_generated_method = "C70982A00502D7246A2EA767D5CC471C")
    public ActionProvider getActionProvider() {
ActionProvider var57BFCB16350F74344F74241EF039E23B_913130958 =         mActionProvider;
        var57BFCB16350F74344F74241EF039E23B_913130958.addTaint(taint);
        return var57BFCB16350F74344F74241EF039E23B_913130958;
        // ---------- Original Method ----------
        //return mActionProvider;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.507 -0400", hash_original_method = "C59B6F24EC844FBD609E594809339FFA", hash_generated_method = "F73BDC81C1C0651D382D04C6C3A41DE8")
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        mActionView = null;
        mActionProvider = actionProvider;
        mMenu.onItemsChanged(true);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1884881625 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1884881625.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1884881625;
        // ---------- Original Method ----------
        //mActionView = null;
        //mActionProvider = actionProvider;
        //mMenu.onItemsChanged(true);
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.507 -0400", hash_original_method = "90E2ACB3CB5E470B67823CDF97986260", hash_generated_method = "0268F9BF147D7E1A4FF8D52EF4E72190")
    @Override
    public MenuItem setShowAsActionFlags(int actionEnum) {
        addTaint(actionEnum);
        setShowAsAction(actionEnum);
MenuItem var72A74007B2BE62B849F475C7BDA4658B_1309085147 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1309085147.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1309085147;
        // ---------- Original Method ----------
        //setShowAsAction(actionEnum);
        //return this;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.507 -0400", hash_original_method = "9242B1434B9CD0ACB88D22E492AB3A81", hash_generated_method = "600A39F0A000C1F7852F3331417DC096")
    @Override
    public boolean expandActionView() {
        if((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) == 0 || mActionView == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_33917000 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162542800 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_162542800;
        } //End block
        if(mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionExpand(this))        
        {
            boolean var5CF2883D825F0938343481AA38A93254_1254741408 = (mMenu.expandItemActionView(this));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1869246635 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1869246635;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1157005943 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1370203320 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1370203320;
        // ---------- Original Method ----------
        //if ((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) == 0 || mActionView == null) {
            //return false;
        //}
        //if (mOnActionExpandListener == null ||
                //mOnActionExpandListener.onMenuItemActionExpand(this)) {
            //return mMenu.expandItemActionView(this);
        //}
        //return false;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.507 -0400", hash_original_method = "DB0EB37C3626C85F2C23377923AB6063", hash_generated_method = "BA166C407FD2C70F6AE18476E32DF133")
    @Override
    public boolean collapseActionView() {
        if((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) == 0)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1471432345 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2103483637 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2103483637;
        } //End block
        if(mActionView == null)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1227483859 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1529713633 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1529713633;
        } //End block
        if(mOnActionExpandListener == null ||
                mOnActionExpandListener.onMenuItemActionCollapse(this))        
        {
            boolean var523891D3A624E518BB9246710B1EC309_2082021701 = (mMenu.collapseItemActionView(this));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_866731899 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_866731899;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_805452908 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1062062369 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1062062369;
        // ---------- Original Method ----------
        //if ((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) == 0) {
            //return false;
        //}
        //if (mActionView == null) {
            //return true;
        //}
        //if (mOnActionExpandListener == null ||
                //mOnActionExpandListener.onMenuItemActionCollapse(this)) {
            //return mMenu.collapseItemActionView(this);
        //}
        //return false;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.507 -0400", hash_original_method = "B1FCAF7D5B88EED4E84E6E84EBEC9EE4", hash_generated_method = "670B7EB9262E5C70C6FD136DF6A32348")
    @Override
    public MenuItem setOnActionExpandListener(OnActionExpandListener listener) {
        mOnActionExpandListener = listener;
MenuItem var72A74007B2BE62B849F475C7BDA4658B_738911898 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_738911898.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_738911898;
        // ---------- Original Method ----------
        //mOnActionExpandListener = listener;
        //return this;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_method = "DAFC43ECD0E5D06566AA28ACE3B5E472", hash_generated_method = "28F67C3706127539DFF2F68F45EDA15B")
    public boolean hasCollapsibleActionView() {
        boolean var14B2EBB734F3A0D0904865526E922815_92737744 = ((mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) != 0 && mActionView != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_440293327 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_440293327;
        // ---------- Original Method ----------
        //return (mShowAsAction & SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW) != 0 && mActionView != null;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_method = "A7B0C8C0A6B0446C22F6521CC0C60064", hash_generated_method = "407D942D4124D9AF1A9CE9B210935DCE")
    public void setActionViewExpanded(boolean isExpanded) {
        mIsActionViewExpanded = isExpanded;
        mMenu.onItemsChanged(false);
        // ---------- Original Method ----------
        //mIsActionViewExpanded = isExpanded;
        //mMenu.onItemsChanged(false);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_method = "618A94DE2810D1D688B3A7F878D1125A", hash_generated_method = "01562F6E0F38C7111A33B82B272B4664")
    public boolean isActionViewExpanded() {
        boolean var6AB54D1A890E4390150D59788F645FF0_1859184877 = (mIsActionViewExpanded);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1225001550 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1225001550;
        // ---------- Original Method ----------
        //return mIsActionViewExpanded;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "25C064051816B881687ECD14B4BCA369", hash_generated_field = "8A8FA0202935EA55AD54CD7CFED45C98")

    private static final String TAG = "MenuItemImpl";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "4853419C3DE5BA7DDAE9908E29DAA2CD", hash_generated_field = "11894259A35F1BBB9E7F27DD18921EDE")

    private static final int SHOW_AS_ACTION_MASK = SHOW_AS_ACTION_NEVER |
            SHOW_AS_ACTION_IF_ROOM |
            SHOW_AS_ACTION_ALWAYS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "44D8ACA63E51B6F3484CCFC3C401596B", hash_generated_field = "943315568AC97A95BEE7FD4A533D08C8")

    private static final int CHECKABLE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "AA8FA6BAC5A05627B79C947C0D232729", hash_generated_field = "79E18373E7678760190793C5FAA4E940")

    private static final int CHECKED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "4BD83E56EE2A97900ECC9A6A8944AED1", hash_generated_field = "80F27CAAB6801F818B589E02F88FCA4D")

    private static final int EXCLUSIVE = 0x00000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "9C15CE115096770F474A2620CC59E12C", hash_generated_field = "14D725A9241DDEAEF12149E98726A5C2")

    private static final int HIDDEN = 0x00000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "DF3D10857D57E28E203991699F280170", hash_generated_field = "9D7A6896B452AD15AEC725047E2938A0")

    private static final int ENABLED = 0x00000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "C13DDE3EDD00011B2AF4BB6C84FA15EF", hash_generated_field = "C127B9B1DB91997F1F1D61DE17C3AF8E")

    private static final int IS_ACTION = 0x00000020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "3DA77B226EB38F673406BB1FC10EE04A", hash_generated_field = "3EDC205933905E009C1CD4D66D782972")

    static final int NO_ICON = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "3610FD0730E1C31E028C448BDFDCFC99", hash_generated_field = "FC531438BE18962F76B22C0A35F07352")

    private static String sPrependShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "2CB65CBD30CCC1E5D6CABB5A16183588", hash_generated_field = "DF49530CB048FF09160A19CF46D02A0E")

    private static String sEnterShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "0CB32DA7DEC1629C84A2E3AFD8E4445A", hash_generated_field = "E00B0A704D720C24AE1BBC26B39D8B85")

    private static String sDeleteShortcutLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:28.508 -0400", hash_original_field = "8271EB0483099BFFDF8EDE47E409B11D", hash_generated_field = "9D3B92E22BB5269C378158F8ED50B0E4")

    private static String sSpaceShortcutLabel;
}

