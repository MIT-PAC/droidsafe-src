package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

public abstract class ResourceCursorAdapter extends CursorAdapter {
    private int mLayout;
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.249 -0400", hash_original_method = "64F07E8E3FA816788C81269041C7BE2C", hash_generated_method = "0F6863DE0922BB7B19A02EB58D38B825")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public ResourceCursorAdapter(Context context, int layout, Cursor c) {
        super(context, c);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(layout);
        dsTaint.addTaint(context.dsTaint);
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // ---------- Original Method ----------
        //mLayout = mDropDownLayout = layout;
        //mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.249 -0400", hash_original_method = "2548BF0AFC8B02A5BB725BAA0B70445F", hash_generated_method = "336A95A0E6405CF0B753F622701F4DC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ResourceCursorAdapter(Context context, int layout, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(layout);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(autoRequery);
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // ---------- Original Method ----------
        //mLayout = mDropDownLayout = layout;
        //mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.249 -0400", hash_original_method = "1C7227D889BF56CFA0B952AEE07E9BD1", hash_generated_method = "7B681BB2A9536C3016652EF3AA3FA5A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ResourceCursorAdapter(Context context, int layout, Cursor c, int flags) {
        super(context, c, flags);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(layout);
        dsTaint.addTaint(context.dsTaint);
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // ---------- Original Method ----------
        //mLayout = mDropDownLayout = layout;
        //mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.250 -0400", hash_original_method = "E86C9DC4408CF260B8E6AACF31CF8025", hash_generated_method = "E198AC4A2AD55109BA075540BC7A10AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        dsTaint.addTaint(cursor.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        View var56787D23CDA5175999F9773E950F3995_1853070114 = (mInflater.inflate(mLayout, parent, false));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInflater.inflate(mLayout, parent, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.250 -0400", hash_original_method = "C82CC5D78027B48163EBCC94CFA263B9", hash_generated_method = "27BB2F1546B8BAB154592C9693F1AFB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        dsTaint.addTaint(cursor.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        View var33A455FEFF277B0C30003C5B0367A422_2029623240 = (mInflater.inflate(mDropDownLayout, parent, false));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInflater.inflate(mDropDownLayout, parent, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.250 -0400", hash_original_method = "D5BDA165ADCD99BE26CEA9E8AC3FEB13", hash_generated_method = "737CB4C188FC640E039D55A5B8C26106")
    @DSModeled(DSC.SAFE)
    public void setViewResource(int layout) {
        dsTaint.addTaint(layout);
        // ---------- Original Method ----------
        //mLayout = layout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:08.250 -0400", hash_original_method = "62C4D5A7D859DBC1B997DA83ECA5AEBB", hash_generated_method = "64A47F3633D2665C5538DD757A05B794")
    @DSModeled(DSC.SAFE)
    public void setDropDownViewResource(int dropDownLayout) {
        dsTaint.addTaint(dropDownLayout);
        // ---------- Original Method ----------
        //mDropDownLayout = dropDownLayout;
    }

    
}

