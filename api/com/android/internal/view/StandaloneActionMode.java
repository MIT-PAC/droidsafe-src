package com.android.internal.view;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.view.MenuItem;
import android.view.Menu;
import com.android.internal.widget.ActionBarContextView;
import com.android.internal.view.menu.SubMenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;
import java.lang.ref.WeakReference;
import android.content.Context;
import android.view.accessibility.AccessibilityEvent;
import com.android.internal.view.menu.MenuBuilder;
import android.view.View;
import android.view.MenuInflater;
import android.view.ActionMode;
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.486 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.487 -0400", hash_original_field = "13165738652608F9EE0CDB1A8EC90D22", hash_generated_field = "E4495F4DA753977DA3DA6F75D457D470")

    private ActionBarContextView mContextView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.487 -0400", hash_original_field = "1804C5EC7AAE0B28B15CFDA061D25829", hash_generated_field = "8F251D8FB2618CB877D06AB4E966D630")

    private ActionMode.Callback mCallback;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.487 -0400", hash_original_field = "0F85706FF7ACEA880EA803CB0E63A48D", hash_generated_field = "E98181B1669419FD7A308D60329FDF80")

    private WeakReference<View> mCustomView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.487 -0400", hash_original_field = "BB077E6B2FCDFA3F0EF71EB099A18F49", hash_generated_field = "0B1DE3EEB5BF08E36FD9B568D72D59CC")

    private boolean mFinished;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.487 -0400", hash_original_field = "07D4AD4D81CD2ED098EE3F04028AD5C2", hash_generated_field = "26ADB48C5A4311C541C946E4573DD3BE")

    private boolean mFocusable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.487 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.488 -0400", hash_original_method = "55FD50A60BD0ADE2BA07AA0D8B65A942", hash_generated_method = "746AB60B9F229CD1E69919DA15AC2BCB")
    public  StandaloneActionMode(Context context, ActionBarContextView view,
            ActionMode.Callback callback, boolean isFocusable) {
        addTaint(isFocusable);
        addTaint(callback.getTaint());
        addTaint(view.getTaint());
        addTaint(context.getTaint());
mContext=contextmContextView=viewmCallback=callbackmMenu=new MenuBuilder(context).setDefaultShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)mMenu.setCallback(this)mFocusable=isFocusable
        // ---------- Original Method ----------
        //mContext = context;
        //mContextView = view;
        //mCallback = callback;
        //mMenu = new MenuBuilder(context).setDefaultShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        //mMenu.setCallback(this);
        //mFocusable = isFocusable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.489 -0400", hash_original_method = "A400678911C36F7EF5F4C53636B8794A", hash_generated_method = "D36DBE275A55EBFABA713CD453FB1B5F")
    @Override
    public void setTitle(CharSequence title) {
        addTaint(title.getTaint());
mContextView.setTitle(title)
        // ---------- Original Method ----------
        //mContextView.setTitle(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.489 -0400", hash_original_method = "EDCF93193B842CC10D4874A3847ED8B0", hash_generated_method = "57F6C0A2DF036E7271AB7BC86948BC25")
    @Override
    public void setSubtitle(CharSequence subtitle) {
        addTaint(subtitle.getTaint());
mContextView.setSubtitle(subtitle)
        // ---------- Original Method ----------
        //mContextView.setSubtitle(subtitle);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.490 -0400", hash_original_method = "93A6ED10F8DC44A47D2A5E40CE348C6E", hash_generated_method = "1DB4F40763B82BB8E662C436BADF97BF")
    @Override
    public void setTitle(int resId) {
        addTaint(resId);
setTitle(mContext.getString(resId))
        // ---------- Original Method ----------
        //setTitle(mContext.getString(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.490 -0400", hash_original_method = "28BA950963DD65E7A01A305F037657F9", hash_generated_method = "DC1698A653FD5B2EADA88E76934ED1B8")
    @Override
    public void setSubtitle(int resId) {
        addTaint(resId);
setSubtitle(mContext.getString(resId))
        // ---------- Original Method ----------
        //setSubtitle(mContext.getString(resId));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.491 -0400", hash_original_method = "9E51AE6245B49C0A0C63CDC407B0F43A", hash_generated_method = "56FA6B2727229B53CEA1CB6545453624")
    @Override
    public void setCustomView(View view) {
        addTaint(view.getTaint());
mContextView.setCustomView(view)mCustomView=view!=null?new WeakReference<View>(view):new WeakReference<View>(view)
        // ---------- Original Method ----------
        //mContextView.setCustomView(view);
        //mCustomView = view != null ? new WeakReference<View>(view) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.491 -0400", hash_original_method = "372D218B87D4A0A142019F048ACE142A", hash_generated_method = "D7CFFD451CE863A7A36E16B497F050EA")
    @Override
    public void invalidate() {
mCallback.onPrepareActionMode(this, mMenu)
        // ---------- Original Method ----------
        //mCallback.onPrepareActionMode(this, mMenu);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.491 -0400", hash_original_method = "68A30112FFA7AC4F388A26854C0F5D1A", hash_generated_method = "4F2E28C5FF268B1FC242F0E94D62EA5A")
    @Override
    public void finish() {
        if(mFinished)        
        {
            return;
        } //End block
mFinished=truemContextView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED)mCallback.onDestroyActionMode(this)
        // ---------- Original Method ----------
        //if (mFinished) {
            //return;
        //}
        //mFinished = true;
        //mContextView.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED);
        //mCallback.onDestroyActionMode(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.492 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "15FF86A3D6F021AC18A708CE9C3722E6")
    @Override
    public Menu getMenu() {
Menu var10D851031FD6BA7C53B0186C7F1D9213_1541732643 = mMenu        var10D851031FD6BA7C53B0186C7F1D9213_1541732643.addTaint(taint);
        return var10D851031FD6BA7C53B0186C7F1D9213_1541732643;
        // ---------- Original Method ----------
        //return mMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.492 -0400", hash_original_method = "B7C7D06E8A777BBCD952F14E250A3EF1", hash_generated_method = "ECCC4375D6FD76A6746C196AFB028548")
    @Override
    public CharSequence getTitle() {
CharSequence var34D31794780ACEFCF0616B8B24AD4528_848317955 = mContextView.getTitle()        var34D31794780ACEFCF0616B8B24AD4528_848317955.addTaint(taint);
        return var34D31794780ACEFCF0616B8B24AD4528_848317955;
        // ---------- Original Method ----------
        //return mContextView.getTitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.492 -0400", hash_original_method = "117FD7BAEF9CDB7B98041D8B7F2D9548", hash_generated_method = "9613FD0BB1CD049CFC756E8B6B32B1BE")
    @Override
    public CharSequence getSubtitle() {
CharSequence varC52A494AB21A52CC12DF26E45A90E06F_2125056182 = mContextView.getSubtitle()        varC52A494AB21A52CC12DF26E45A90E06F_2125056182.addTaint(taint);
        return varC52A494AB21A52CC12DF26E45A90E06F_2125056182;
        // ---------- Original Method ----------
        //return mContextView.getSubtitle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.493 -0400", hash_original_method = "6445ACEDBE83E3C2D5AD83B96CDE83BC", hash_generated_method = "3C640F9158088D004EB94E4599D66812")
    @Override
    public View getCustomView() {
View varECA05EFB052EFC69FA07832FA3F4A1D6_1993831349 = mCustomView!=null?mCustomView.get():mCustomView.get()        varECA05EFB052EFC69FA07832FA3F4A1D6_1993831349.addTaint(taint);
        return varECA05EFB052EFC69FA07832FA3F4A1D6_1993831349;
        // ---------- Original Method ----------
        //return mCustomView != null ? mCustomView.get() : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.493 -0400", hash_original_method = "2A6E49189DE888CD2A1EA8645E922DD3", hash_generated_method = "B211CBCF8CC2E3ACCA53A9720F25C033")
    @Override
    public MenuInflater getMenuInflater() {
MenuInflater var25503C1986659659AE31638A329E040B_1376779804 = new MenuInflater(mContext)        var25503C1986659659AE31638A329E040B_1376779804.addTaint(taint);
        return var25503C1986659659AE31638A329E040B_1376779804;
        // ---------- Original Method ----------
        //return new MenuInflater(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.493 -0400", hash_original_method = "F51EDCD0F624ACFDC7C92A91A9DBCDC4", hash_generated_method = "DC3C11974D3AF02AF67759FE76B91BAA")
    public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        boolean var3FFB98B393CA4BB1089E3B773EEE7A13_468303031 = (mCallback.onActionItemClicked(this, item));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905101275 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905101275;
        // ---------- Original Method ----------
        //return mCallback.onActionItemClicked(this, item);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.494 -0400", hash_original_method = "FBD72BA67A5E56379A29D442239E7ED0", hash_generated_method = "8E80426A33290BFB819B8A6933C74555")
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(allMenusAreClosing);
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.494 -0400", hash_original_method = "564DCEF4229F57DD33C42CFA5F36AC6A", hash_generated_method = "53337B5B1B7F8C3A864B44323DAA78E5")
    public boolean onSubMenuSelected(SubMenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(subMenu.getTaint());
        if(!subMenu.hasVisibleItems())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_928277604 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104888372 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_104888372;
        } //End block
new MenuPopupHelper(mContext, subMenu).show()        boolean varB326B5062B2F0E69046810717534CB09_1068763395 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_602847280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_602847280;
        // ---------- Original Method ----------
        //if (!subMenu.hasVisibleItems()) {
            //return true;
        //}
        //new MenuPopupHelper(mContext, subMenu).show();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.495 -0400", hash_original_method = "6B692B27380EC4C10CDFFF60DC2D0482", hash_generated_method = "2074465CD9A30183B1E5202C403E062E")
    public void onCloseSubMenu(SubMenuBuilder menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.495 -0400", hash_original_method = "D7D55EF5CA244F9261DE1F2F7903B4A1", hash_generated_method = "CEB8A4DAC494C01AAEB8220B0422FB3A")
    public void onMenuModeChange(MenuBuilder menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
invalidate()mContextView.showOverflowMenu()
        // ---------- Original Method ----------
        //invalidate();
        //mContextView.showOverflowMenu();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.496 -0400", hash_original_method = "DE12DD01B34AD577F1E5C721709863BB", hash_generated_method = "00A6491C268E00A464C5A34614B6B387")
    public boolean isUiFocusable() {
        boolean var07D4AD4D81CD2ED098EE3F04028AD5C2_1372259314 = (mFocusable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1196592722 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1196592722;
        // ---------- Original Method ----------
        //return mFocusable;
    }

    
}

