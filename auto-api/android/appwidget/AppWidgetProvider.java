package android.appwidget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class AppWidgetProvider extends BroadcastReceiver {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.965 -0400", hash_original_method = "9EAF442CC86F0B5BA1B1B46FB2948CE7", hash_generated_method = "3C7FFC20A8A1FC0D5303AF1AED86D932")
    public  AppWidgetProvider() {
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.965 -0400", hash_original_method = "8B20EBF206EE708E791CD471F78F9BAE", hash_generated_method = "71ECAE668D3FE6847867371C513A9E71")
    public void onReceive(Context context, Intent intent) {
        
        String action = intent.getAction();
        {
            boolean var307CDE1D015D0C1F1D9991106E69910C_687845836 = (AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action));
            {
                Bundle extras = intent.getExtras();
                {
                    int[] appWidgetIds = extras.getIntArray(AppWidgetManager.EXTRA_APPWIDGET_IDS);
                    {
                        this.onUpdate(context, AppWidgetManager.getInstance(context), appWidgetIds);
                    } 
                } 
            } 
            {
                boolean var923A63CF191840A6FD3FC0F3787C7A75_1384065875 = (AppWidgetManager.ACTION_APPWIDGET_DELETED.equals(action));
                {
                    Bundle extras = intent.getExtras();
                    {
                        boolean var0BD3CCC63013F99F24FE0E1FCCAAE11B_681015216 = (extras != null && extras.containsKey(AppWidgetManager.EXTRA_APPWIDGET_ID));
                        {
                            final int appWidgetId = extras.getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);
                            this.onDeleted(context, new int[] { appWidgetId });
                        } 
                    } 
                } 
                {
                    boolean var67002C0B6308476D027F017D118DCB37_1401420368 = (AppWidgetManager.ACTION_APPWIDGET_ENABLED.equals(action));
                    {
                        this.onEnabled(context);
                    } 
                    {
                        boolean var5CF4CBB4CCBBADF34A3E6121AE7CA60B_2011307447 = (AppWidgetManager.ACTION_APPWIDGET_DISABLED.equals(action));
                        {
                            this.onDisabled(context);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(context.getTaint());
        addTaint(intent.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.966 -0400", hash_original_method = "A2E84788BA84189ABE3F219EBDAC629C", hash_generated_method = "CC9D7FBF747BA60370E681863405F31C")
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        
        addTaint(context.getTaint());
        addTaint(appWidgetManager.getTaint());
        addTaint(appWidgetIds[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.967 -0400", hash_original_method = "0AB37BC4D28009D0D79CD2D0DC9B7953", hash_generated_method = "74FB7EC64DEB1852B45907EF66A2EA22")
    public void onDeleted(Context context, int[] appWidgetIds) {
        
        addTaint(context.getTaint());
        addTaint(appWidgetIds[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.967 -0400", hash_original_method = "A066DA52DDA31A9511487AE3845ED018", hash_generated_method = "0B915167097F155742FBB7F56749B7EC")
    public void onEnabled(Context context) {
        
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:21.968 -0400", hash_original_method = "D927F2373817E24DFC9B3FEAB7D30B31", hash_generated_method = "BBBA003B1A0C8AA6F2BE99EB08B19D4C")
    public void onDisabled(Context context) {
        
        addTaint(context.getTaint());
        
    }

    
}

