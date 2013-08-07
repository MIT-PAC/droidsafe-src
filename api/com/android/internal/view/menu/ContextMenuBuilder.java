package com.android.internal.view.menu;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.IBinder;
import android.view.ContextMenu;
import android.content.Context;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.util.EventLog;
public class ContextMenuBuilder extends MenuBuilder implements ContextMenu {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.284 -0400", hash_original_method = "31B204B44ADDD3A74D11B61FB9698D09", hash_generated_method = "D9DD2C738A761D0A60D2A6B0C20ECEFE")
    public  ContextMenuBuilder(Context context) {
        super(context);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.285 -0400", hash_original_method = "4EA0414FDCF4934CB74E67C2BA91AD26", hash_generated_method = "4025AE80EE3C196303F2A578DDE2E62D")
    public ContextMenu setHeaderIcon(Drawable icon) {
        addTaint(icon.getTaint());
ContextMenu varA408E1AD4CCE4E36EDFF2E18C45EABEC_1588787743 = (ContextMenu) super.setHeaderIconInt(icon)        varA408E1AD4CCE4E36EDFF2E18C45EABEC_1588787743.addTaint(taint);
        return varA408E1AD4CCE4E36EDFF2E18C45EABEC_1588787743;
        // ---------- Original Method ----------
        //return (ContextMenu) super.setHeaderIconInt(icon);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.286 -0400", hash_original_method = "B14F406860E750B2D4438CE5ACEB1ABE", hash_generated_method = "33A0891D7C405B9D43B6549BF1D8E4ED")
    public ContextMenu setHeaderIcon(int iconRes) {
        addTaint(iconRes);
ContextMenu varAAD24A37BE4795EA570157E283A657B6_2053735757 = (ContextMenu) super.setHeaderIconInt(iconRes)        varAAD24A37BE4795EA570157E283A657B6_2053735757.addTaint(taint);
        return varAAD24A37BE4795EA570157E283A657B6_2053735757;
        // ---------- Original Method ----------
        //return (ContextMenu) super.setHeaderIconInt(iconRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.287 -0400", hash_original_method = "86AE1DFFD66E55B341B47437A16E4421", hash_generated_method = "73E3B1D641BC6F3C38F0F30E342D8F3A")
    public ContextMenu setHeaderTitle(CharSequence title) {
        addTaint(title.getTaint());
ContextMenu varDA1E39137B53B92E86819DCB2C064DB1_1951298463 = (ContextMenu) super.setHeaderTitleInt(title)        varDA1E39137B53B92E86819DCB2C064DB1_1951298463.addTaint(taint);
        return varDA1E39137B53B92E86819DCB2C064DB1_1951298463;
        // ---------- Original Method ----------
        //return (ContextMenu) super.setHeaderTitleInt(title);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.288 -0400", hash_original_method = "6128AAB2C2C12BC1DF4BD1A1C09E51AD", hash_generated_method = "E6F5DA8A187C6F90D78CBDEF7AAC74AE")
    public ContextMenu setHeaderTitle(int titleRes) {
        addTaint(titleRes);
ContextMenu var5715ABE3B6CFB17162E05C6C3F303F9B_2096022707 = (ContextMenu) super.setHeaderTitleInt(titleRes)        var5715ABE3B6CFB17162E05C6C3F303F9B_2096022707.addTaint(taint);
        return var5715ABE3B6CFB17162E05C6C3F303F9B_2096022707;
        // ---------- Original Method ----------
        //return (ContextMenu) super.setHeaderTitleInt(titleRes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.288 -0400", hash_original_method = "8246E41CF02E865119BF768460C603BA", hash_generated_method = "92D2337E1B436D85010A6B88CAD0F4AC")
    public ContextMenu setHeaderView(View view) {
        addTaint(view.getTaint());
ContextMenu varC120DB9D5E237A584042C1492DAAA089_542072662 = (ContextMenu) super.setHeaderViewInt(view)        varC120DB9D5E237A584042C1492DAAA089_542072662.addTaint(taint);
        return varC120DB9D5E237A584042C1492DAAA089_542072662;
        // ---------- Original Method ----------
        //return (ContextMenu) super.setHeaderViewInt(view);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:51.289 -0400", hash_original_method = "288A87448E6D764011C1399D11E72FEF", hash_generated_method = "BD6791712F54900D0765C6EA66DD8C47")
    public MenuDialogHelper show(View originalView, IBinder token) {
        addTaint(token.getTaint());
        addTaint(originalView.getTaint());
        if(originalView!=null)        
        {
originalView.createContextMenu(this)
        } //End block
        if(getVisibleItems().size()>0)        
        {
EventLog.writeEvent(50001, 1)            MenuDialogHelper helper = new MenuDialogHelper(this);
helper.show(token)MenuDialogHelper varA2C58D2E0A81E65942076B14BA0E8DDA_2050047140 = helper            varA2C58D2E0A81E65942076B14BA0E8DDA_2050047140.addTaint(taint);
            return varA2C58D2E0A81E65942076B14BA0E8DDA_2050047140;
        } //End block
MenuDialogHelper var540C13E9E156B687226421B24F2DF178_1927971725 = null        var540C13E9E156B687226421B24F2DF178_1927971725.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1927971725;
        // ---------- Original Method ----------
        //if (originalView != null) {
            //originalView.createContextMenu(this);
        //}
        //if (getVisibleItems().size() > 0) {
            //EventLog.writeEvent(50001, 1);
            //MenuDialogHelper helper = new MenuDialogHelper(this); 
            //helper.show(token);
            //return helper;
        //}
        //return null;
    }

    
}

