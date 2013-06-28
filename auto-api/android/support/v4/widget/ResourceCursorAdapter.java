package android.support.v4.widget;

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.335 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "5CC2A1296B93C3BD6A25D936449BB206")

    private int mLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.335 -0400", hash_original_field = "977AEFED84760681591C43DE706A4DD0", hash_generated_field = "987A6AA6040898D3C8BF11B145CB7E2D")

    private int mDropDownLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.335 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.336 -0400", hash_original_method = "64F07E8E3FA816788C81269041C7BE2C", hash_generated_method = "B9D621DCF65C2CF014757B76E42AF9D3")
    @Deprecated
    public  ResourceCursorAdapter(Context context, int layout, Cursor c) {
        super(context, c);
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        addTaint(c.getTaint());
        // ---------- Original Method ----------
        //mLayout = mDropDownLayout = layout;
        //mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.336 -0400", hash_original_method = "2548BF0AFC8B02A5BB725BAA0B70445F", hash_generated_method = "B94523A15B183B62D0C49286CCC3BA20")
    public  ResourceCursorAdapter(Context context, int layout, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        addTaint(c.getTaint());
        addTaint(autoRequery);
        // ---------- Original Method ----------
        //mLayout = mDropDownLayout = layout;
        //mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.337 -0400", hash_original_method = "1C7227D889BF56CFA0B952AEE07E9BD1", hash_generated_method = "A13A035FA75131A63251E683444F0B43")
    public  ResourceCursorAdapter(Context context, int layout, Cursor c, int flags) {
        super(context, c, flags);
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        addTaint(c.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //mLayout = mDropDownLayout = layout;
        //mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.338 -0400", hash_original_method = "E86C9DC4408CF260B8E6AACF31CF8025", hash_generated_method = "C351B2859969A529C87B3D8BFE4B4FB3")
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1701503117 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1701503117 = mInflater.inflate(mLayout, parent, false);
        addTaint(context.getTaint());
        addTaint(cursor.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1701503117.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1701503117;
        // ---------- Original Method ----------
        //return mInflater.inflate(mLayout, parent, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.339 -0400", hash_original_method = "C82CC5D78027B48163EBCC94CFA263B9", hash_generated_method = "88B4F7D2BE9FB11B23B53AA9ED528228")
    @Override
    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_42242571 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_42242571 = mInflater.inflate(mDropDownLayout, parent, false);
        addTaint(context.getTaint());
        addTaint(cursor.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_42242571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_42242571;
        // ---------- Original Method ----------
        //return mInflater.inflate(mDropDownLayout, parent, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.339 -0400", hash_original_method = "D5BDA165ADCD99BE26CEA9E8AC3FEB13", hash_generated_method = "1A4A3AE74ACD1FAC94DDB52DB24657BB")
    public void setViewResource(int layout) {
        mLayout = layout;
        // ---------- Original Method ----------
        //mLayout = layout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:47.341 -0400", hash_original_method = "62C4D5A7D859DBC1B997DA83ECA5AEBB", hash_generated_method = "B6434D367B58893890DAD8DEC2EDE7DC")
    public void setDropDownViewResource(int dropDownLayout) {
        mDropDownLayout = dropDownLayout;
        // ---------- Original Method ----------
        //mDropDownLayout = dropDownLayout;
    }

    
}

