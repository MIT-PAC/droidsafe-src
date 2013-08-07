package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.IBinder;
import android.app.Dialog;
import android.app.AlertDialog;
import android.view.Window;
import android.content.DialogInterface;
import android.view.WindowManager;
import android.view.KeyEvent;
import android.view.View;
public class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.471 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.472 -0400", hash_original_field = "58806F2D99FD4DF33CF42E0C232738D7", hash_generated_field = "F83602A20E99C2560EE913CF62B217D5")

    private AlertDialog mDialog;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.473 -0400", hash_original_field = "24BE2DD94A844242C35ABB990B9E3B93", hash_generated_field = "DB66F87540FFC45043582E4DC1C87907")

    ListMenuPresenter mPresenter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.473 -0400", hash_original_field = "64B773BD800647AE257B13A75F1C94CE", hash_generated_field = "66C54582B67241B61607C99E4C46472E")

    private MenuPresenter.Callback mPresenterCallback;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.473 -0400", hash_original_method = "E4FD56253F3F6ADA36D4CFC26E589D61", hash_generated_method = "0233E57599A718D290D450723A67CD9C")
    public  MenuDialogHelper(MenuBuilder menu) {
        addTaint(menu.getTaint());
mMenu=menu
        // ---------- Original Method ----------
        //mMenu = menu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.475 -0400", hash_original_method = "A6C7BF5F295A95BA9C2B4CB01496A965", hash_generated_method = "5ED37438C11EBE3241CD9CF55A70A98F")
    public void show(IBinder windowToken) {
        addTaint(windowToken.getTaint());
        final MenuBuilder menu = mMenu;
        final AlertDialog.Builder builder = new AlertDialog.Builder(menu.getContext());
mPresenter=new ListMenuPresenter(builder.getContext(), com.android.internal.R.layout.list_menu_item_layout)mPresenter.setCallback(this)mMenu.addMenuPresenter(mPresenter)builder.setAdapter(mPresenter.getAdapter(), this)        final View headerView = menu.getHeaderView();
        if(headerView!=null)        
        {
builder.setCustomTitle(headerView)
        } //End block
        else
        {
builder.setIcon(menu.getHeaderIcon()).setTitle(menu.getHeaderTitle())
        } //End block
builder.setOnKeyListener(this)mDialog=builder.create()mDialog.setOnDismissListener(this)        WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
lp.type=WindowManager.LayoutParams.TYPE_APPLICATION_ATTACHED_DIALOG        if(windowToken!=null)        
        {
lp.token=windowToken
        } //End block
lp.flags|=WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IMmDialog.show()
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.476 -0400", hash_original_method = "7FA2E70C24A29492003E7D41632C85C5", hash_generated_method = "3C1F7AE618F262DA89B965D8CFC7FC5D")
    public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        addTaint(keyCode);
        addTaint(dialog.getTaint());
        if(keyCode==KeyEvent.KEYCODE_MENU||keyCode==KeyEvent.KEYCODE_BACK)        
        {
            if(event.getAction()==KeyEvent.ACTION_DOWN&&event.getRepeatCount()==0)            
            {
                Window win = mDialog.getWindow();
                if(win!=null)                
                {
                    View decor = win.getDecorView();
                    if(decor!=null)                    
                    {
                        KeyEvent.DispatcherState ds = decor.getKeyDispatcherState();
                        if(ds!=null)                        
                        {
ds.startTracking(event, this)                            boolean varB326B5062B2F0E69046810717534CB09_376218852 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1571484178 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1571484178;
                        } //End block
                    } //End block
                } //End block
            } //End block
            else
            if(event.getAction()==KeyEvent.ACTION_UP&&!event.isCanceled())            
            {
                Window win = mDialog.getWindow();
                if(win!=null)                
                {
                    View decor = win.getDecorView();
                    if(decor!=null)                    
                    {
                        KeyEvent.DispatcherState ds = decor.getKeyDispatcherState();
                        if(ds!=null&&ds.isTracking(event))                        
                        {
mMenu.close(true)dialog.dismiss()                            boolean varB326B5062B2F0E69046810717534CB09_313700061 = (true);
                                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_125076466 = getTaintBoolean();
                            return var84E2C64F38F78BA3EA5C905AB5A2DA27_125076466;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var36A7C1D27A51C6DAE0C59F9CF4103BE1_99595866 = (mMenu.performShortcut(keyCode, event, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002399101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002399101;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.478 -0400", hash_original_method = "9428581351DA56E5D84FF3309DF7BACF", hash_generated_method = "AD49120F975D0171A0897BA83BDCEC35")
    public void setPresenterCallback(MenuPresenter.Callback cb) {
        addTaint(cb.getTaint());
mPresenterCallback=cb
        // ---------- Original Method ----------
        //mPresenterCallback = cb;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.478 -0400", hash_original_method = "85B0BC88009D26568BAEDC3852E0DEEF", hash_generated_method = "3F50B07119A95005868A4464A14F20EC")
    public void dismiss() {
        if(mDialog!=null)        
        {
mDialog.dismiss()
        } //End block
        // ---------- Original Method ----------
        //if (mDialog != null) {
            //mDialog.dismiss();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.478 -0400", hash_original_method = "3E9C803E65E5B82ED710485BB8BDB3C5", hash_generated_method = "13E6E22FE64193D15F8B1797A790D3AB")
    @Override
    public void onDismiss(DialogInterface dialog) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(dialog.getTaint());
mPresenter.onCloseMenu(mMenu, true)
        // ---------- Original Method ----------
        //mPresenter.onCloseMenu(mMenu, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.479 -0400", hash_original_method = "A718635F64E8AD72FBCA655033555352", hash_generated_method = "404BE4BB7C275D441CA7FCBA7DD7A58F")
    @Override
    public void onCloseMenu(MenuBuilder menu, boolean allMenusAreClosing) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(allMenusAreClosing);
        addTaint(menu.getTaint());
        if(allMenusAreClosing||menu==mMenu)        
        {
dismiss()
        } //End block
        if(mPresenterCallback!=null)        
        {
mPresenterCallback.onCloseMenu(menu, allMenusAreClosing)
        } //End block
        // ---------- Original Method ----------
        //if (allMenusAreClosing || menu == mMenu) {
            //dismiss();
        //}
        //if (mPresenterCallback != null) {
            //mPresenterCallback.onCloseMenu(menu, allMenusAreClosing);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.479 -0400", hash_original_method = "DC034CF78D1777A9042EE11EB550F98E", hash_generated_method = "F97A56C215A01480B4747F5405E424D9")
    @Override
    public boolean onOpenSubMenu(MenuBuilder subMenu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(subMenu.getTaint());
        if(mPresenterCallback!=null)        
        {
            boolean varADF4301B481DD7DFBF74C05F57828166_1231172299 = (mPresenterCallback.onOpenSubMenu(subMenu));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_958813420 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_958813420;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1028347841 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_169206491 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_169206491;
        // ---------- Original Method ----------
        //if (mPresenterCallback != null) {
            //return mPresenterCallback.onOpenSubMenu(subMenu);
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.480 -0400", hash_original_method = "21A50852386DBBCBCF36C27713EEFE3F", hash_generated_method = "24B5CF87F032ECE8319EE524DF50F451")
    public void onClick(DialogInterface dialog, int which) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(which);
        addTaint(dialog.getTaint());
mMenu.performItemAction((MenuItemImpl) mPresenter.getAdapter().getItem(which), 0)
        // ---------- Original Method ----------
        //mMenu.performItemAction((MenuItemImpl) mPresenter.getAdapter().getItem(which), 0);
    }

    
}

