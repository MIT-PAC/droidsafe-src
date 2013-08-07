package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.widget.AdapterView.OnItemClickListener;
import android.content.Context;
import android.widget.ListView;
import android.view.View;
import android.util.AttributeSet;
import android.widget.AdapterView;
import com.android.internal.view.menu.MenuBuilder.ItemInvoker;
import android.content.res.TypedArray;
public final class ExpandedMenuView extends ListView implements ItemInvoker, MenuView, OnItemClickListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.295 -0400", hash_original_field = "CFE8F878843D1CA6A8D8B333030E59FA", hash_generated_field = "D444FB62DCB4C4F94C883BDD2D0F7012")

    private MenuBuilder mMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.295 -0400", hash_original_field = "4F367D4A038DAB863661E94112DDED08", hash_generated_field = "BE32B37325C289EA5DB8A350DE8A52C6")

    private int mAnimations;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.296 -0400", hash_original_method = "2D7D395683AE9CE33D072044336B70BB", hash_generated_method = "EA4C077A558F369DFC66E9EEFFE3B02E")
    public  ExpandedMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addTaint(attrs.getTaint());
        addTaint(context.getTaint());
        TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.MenuView, 0, 0);
mAnimations=a.getResourceId(com.android.internal.R.styleable.MenuView_windowAnimationStyle, 0)a.recycle()setOnItemClickListener(this)
        // ---------- Original Method ----------
        //TypedArray a = context.obtainStyledAttributes(attrs, com.android.internal.R.styleable.MenuView, 0, 0);
        //mAnimations = a.getResourceId(com.android.internal.R.styleable.MenuView_windowAnimationStyle, 0);
        //a.recycle();
        //setOnItemClickListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.297 -0400", hash_original_method = "EDB3B7E883C1486DD9AED3AB15C0E44B", hash_generated_method = "64DE7C333E040109CC9BE0A8C5E99770")
    public void initialize(MenuBuilder menu) {
        addTaint(menu.getTaint());
mMenu=menu
        // ---------- Original Method ----------
        //mMenu = menu;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.298 -0400", hash_original_method = "16FE2D47FED77BBFC2DAF1EAFCBDD67E", hash_generated_method = "443AFF843DB2E07FA9F404394282A9B6")
    @Override
    protected void onDetachedFromWindow() {
        //DSFIXME:  CODE0009: Possible callback target function detected
super.onDetachedFromWindow()setChildrenDrawingCacheEnabled(false)
        // ---------- Original Method ----------
        //super.onDetachedFromWindow();
        //setChildrenDrawingCacheEnabled(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.298 -0400", hash_original_method = "52251A4D38FF83C9B55C46C571A25CAE", hash_generated_method = "1D2E458B6CD806B744C0306A3A97173D")
    public boolean invokeItem(MenuItemImpl item) {
        addTaint(item.getTaint());
        boolean var9CE0C397DB4ABF248543C034E9F3CC19_2028653130 = (mMenu.performItemAction(item, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354062493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_354062493;
        // ---------- Original Method ----------
        //return mMenu.performItemAction(item, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.299 -0400", hash_original_method = "07EFE645E03814FCA0C371AE468C693E", hash_generated_method = "AF3C664BDC6C532A74F783D22C57AE27")
    public void onItemClick(AdapterView parent, View v, int position, long id) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(id);
        addTaint(position);
        addTaint(v.getTaint());
        addTaint(parent.getTaint());
invokeItem((MenuItemImpl) getAdapter().getItem(position))
        // ---------- Original Method ----------
        //invokeItem((MenuItemImpl) getAdapter().getItem(position));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.299 -0400", hash_original_method = "02CB30F0EA5DFC81374866D1443F8CD5", hash_generated_method = "98E676A753A4C7082C9D15D6354812E3")
    public int getWindowAnimations() {
        int var4F367D4A038DAB863661E94112DDED08_1192813896 = (mAnimations);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262486731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262486731;
        // ---------- Original Method ----------
        //return mAnimations;
    }

    
}

