package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.android.internal.view.menu.MenuBuilder;
import com.android.internal.view.menu.MenuPopupHelper;
import com.android.internal.view.menu.MenuPresenter;
import com.android.internal.view.menu.SubMenuBuilder;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class PopupMenu implements MenuBuilder.Callback, MenuPresenter.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.327 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.328 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.329 -0400", hash_original_field = "8A2549E4A331F412E0868B04A8E3C179", hash_generated_field = "B5073E9D1328D8D85272F118048A8168")

    private View mAnchor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.330 -0400", hash_original_field = "E863CEB96C01242A6262A422DC21BA91", hash_generated_field = "06BEDB7656EEE290CD919822CE5BD94B")

    private MenuPopupHelper mPopup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.331 -0400", hash_original_field = "AC7DFC8040141ED5561DAE8C7125CCDA", hash_generated_field = "9703FDB31ADAFF0214804DE9893B785D")

    private OnMenuItemClickListener mMenuItemClickListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.332 -0400", hash_original_field = "33C16706A57763C2513EE19F0368A1F6", hash_generated_field = "5BB48C56597239A71FC51ED477A581A9")

    private OnDismissListener mDismissListener;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.341 -0400", hash_original_method = "A76A00F33E7790D7B562E67F217733EF", hash_generated_method = "7E9AB2771CC7429FCBD907BC176C44B9")
    public  PopupMenu(Context context, View anchor) {
        mContext = context;
        mMenu = new MenuBuilder(context);
        mMenu.setCallback(this);
        mAnchor = anchor;
        mPopup = new MenuPopupHelper(context, mMenu, anchor);
        mPopup.setCallback(this);
        // ---------- Original Method ----------
        //mContext = context;
        //mMenu = new MenuBuilder(context);
        //mMenu.setCallback(this);
        //mAnchor = anchor;
        //mPopup = new MenuPopupHelper(context, mMenu, anchor);
        //mPopup.setCallback(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.346 -0400", hash_original_method = "B2B8DF93D41CD214F77DE42BB625BB9F", hash_generated_method = "7B534D787BDA7218D4776D2172ED96A7")
    public Menu getMenu() {
Menu var10D851031FD6BA7C53B0186C7F1D9213_1122954786 =         mMenu;
        var10D851031FD6BA7C53B0186C7F1D9213_1122954786.addTaint(taint);
        return var10D851031FD6BA7C53B0186C7F1D9213_1122954786;
        // ---------- Original Method ----------
        //return mMenu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.349 -0400", hash_original_method = "2A6E49189DE888CD2A1EA8645E922DD3", hash_generated_method = "D202EDAAEC9839A6DCE43CD0C5984EE8")
    public MenuInflater getMenuInflater() {
MenuInflater var25503C1986659659AE31638A329E040B_451162616 =         new MenuInflater(mContext);
        var25503C1986659659AE31638A329E040B_451162616.addTaint(taint);
        return var25503C1986659659AE31638A329E040B_451162616;
        // ---------- Original Method ----------
        //return new MenuInflater(mContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.353 -0400", hash_original_method = "B5DA97073214511A8C4FCCDCD0202705", hash_generated_method = "391C6A8AB5BA5226583D9B904020DEA4")
    public void inflate(int menuRes) {
        addTaint(menuRes);
        getMenuInflater().inflate(menuRes, mMenu);
        // ---------- Original Method ----------
        //getMenuInflater().inflate(menuRes, mMenu);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.359 -0400", hash_original_method = "2CE72B1B8EF107541CE02DFAE137C08B", hash_generated_method = "172FB01191D78540638BED9CA4DCA28E")
    public void show() {
        mPopup.show();
        // ---------- Original Method ----------
        //mPopup.show();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.365 -0400", hash_original_method = "C5794CDCFC0B9690306B70531BF35214", hash_generated_method = "8183E39C4C1FC3F53D6BB2CEAED1F5B5")
    public void dismiss() {
        mPopup.dismiss();
        // ---------- Original Method ----------
        //mPopup.dismiss();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.371 -0400", hash_original_method = "28F3665ED7463B0146351549FFC48231", hash_generated_method = "9F6DA51E9D0BCDB48D44E9DCC692FF64")
    public void setOnMenuItemClickListener(OnMenuItemClickListener listener) {
        mMenuItemClickListener = listener;
        // ---------- Original Method ----------
        //mMenuItemClickListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.378 -0400", hash_original_method = "C95583275768EA3036A4E9EDA3D06AF7", hash_generated_method = "264730297F2947921933CD4642D9E756")
    public void setOnDismissListener(OnDismissListener listener) {
        mDismissListener = listener;
        // ---------- Original Method ----------
        //mDismissListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.385 -0400", hash_original_method = "930C91C797D93F5ADF8BC528FF612F76", hash_generated_method = "A3387C07622B6392053F3A19DCCA9445")
    public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        addTaint(menu.getTaint());
        if(mMenuItemClickListener != null)        
        {
            boolean var928BAA9FC0B2D373EF24891CA7B141EA_1272892307 = (mMenuItemClickListener.onMenuItemClick(item));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_774799396 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_774799396;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1046001807 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_65231990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_65231990;
        // ---------- Original Method ----------
        //if (mMenuItemClickListener != null) {
            //return mMenuItemClickListener.onMenuItemClick(item);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.392 -0400", hash_original_method = "86695013FCDBC0CB589820CBDB9A26C8", hash_generated_method = "4E01471C874A0D9C8186414D8DC87507")
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(allMenusAreClosing);
        addTaint(menu.getTaint());
        if(mDismissListener != null)        
        {
            mDismissListener.onDismiss(this);
        } //End block
        // ---------- Original Method ----------
        //if (mDismissListener != null) {
            //mDismissListener.onDismiss(this);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.401 -0400", hash_original_method = "B948BC656B334434A5ABFAFD3C309E66", hash_generated_method = "B34AA7D6348AE54C53D54AB893E97E48")
    public boolean onOpenSubMenu(MenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(subMenu.getTaint());
        if(subMenu == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_987859698 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1567871018 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1567871018;
        }
        if(!subMenu.hasVisibleItems())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1205143963 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1974891011 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1974891011;
        } //End block
        new MenuPopupHelper(mContext, subMenu, mAnchor).show();
        boolean varB326B5062B2F0E69046810717534CB09_866459008 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1958334902 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1958334902;
        // ---------- Original Method ----------
        //if (subMenu == null) return false;
        //if (!subMenu.hasVisibleItems()) {
            //return true;
        //}
        //new MenuPopupHelper(mContext, subMenu, mAnchor).show();
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.406 -0400", hash_original_method = "6B692B27380EC4C10CDFFF60DC2D0482", hash_generated_method = "2074465CD9A30183B1E5202C403E062E")
    public void onCloseSubMenu(SubMenuBuilder menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 11:14:54.413 -0400", hash_original_method = "BD3281B75359F57929C0B7D8E3BC0065", hash_generated_method = "00C3370B4338E9D0BE3E67D205B0AEAE")
    public void onMenuModeChange(MenuBuilder menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    public interface OnDismissListener {
        
        public void onDismiss(PopupMenu menu);
    }
    
    public interface OnMenuItemClickListener {
        
        public boolean onMenuItemClick(MenuItem item);
    }
    
}

