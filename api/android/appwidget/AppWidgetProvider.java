package android.appwidget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AppWidgetProvider extends BroadcastReceiver {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.611 -0400", hash_original_method = "9EAF442CC86F0B5BA1B1B46FB2948CE7", hash_generated_method = "3C7FFC20A8A1FC0D5303AF1AED86D932")
    public  AppWidgetProvider() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.612 -0400", hash_original_method = "8B20EBF206EE708E791CD471F78F9BAE", hash_generated_method = "C286A2A8722EE9FF877C2D4BC18CE87A")
    public void onReceive(Context context, Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(context.getTaint());
        String action = intent.getAction();
    if(AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action))        
        {
            Bundle extras = intent.getExtras();
    if(extras != null)            
            {
                int[] appWidgetIds = extras.getIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS);
    if(appWidgetIds != null && appWidgetIds.length > 0)                
                {
                    this.onUpdate(context, AppWidgetManager.getInstance(context), appWidgetIds);
                } //End block
            } //End block
        } //End block
        else
    if(AppWidgetManager.ACTION_APPWIDGET_DELETED.equals(action))        
        {
            Bundle extras = intent.getExtras();
    if(extras != null && extras.containsKey(AppWidgetManager.EXTRA_APPWIDGET_ID))            
            {
                final int appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);
                this.onDeleted(context, new int[] { appWidgetId });
            } //End block
        } //End block
        else
    if(AppWidgetManager.ACTION_APPWIDGET_ENABLED.equals(action))        
        {
            this.onEnabled(context);
        } //End block
        else
    if(AppWidgetManager.ACTION_APPWIDGET_DISABLED.equals(action))        
        {
            this.onDisabled(context);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.613 -0400", hash_original_method = "A2E84788BA84189ABE3F219EBDAC629C", hash_generated_method = "3998F9E365E6902957A08F14D1CE8DF6")
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(appWidgetIds[0]);
        addTaint(appWidgetManager.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.614 -0400", hash_original_method = "0AB37BC4D28009D0D79CD2D0DC9B7953", hash_generated_method = "3FF9074FBCBC54386E250B91C39D9F63")
    public void onDeleted(Context context, int[] appWidgetIds) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(appWidgetIds[0]);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.615 -0400", hash_original_method = "A066DA52DDA31A9511487AE3845ED018", hash_generated_method = "0B915167097F155742FBB7F56749B7EC")
    public void onEnabled(Context context) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:06.616 -0400", hash_original_method = "D927F2373817E24DFC9B3FEAB7D30B31", hash_generated_method = "BBBA003B1A0C8AA6F2BE99EB08B19D4C")
    public void onDisabled(Context context) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
}

