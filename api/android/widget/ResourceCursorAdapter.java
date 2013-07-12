package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

public abstract class ResourceCursorAdapter extends CursorAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.859 -0400", hash_original_field = "AF58F50E47532278404C3D8470630FC4", hash_generated_field = "5CC2A1296B93C3BD6A25D936449BB206")

    private int mLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.860 -0400", hash_original_field = "977AEFED84760681591C43DE706A4DD0", hash_generated_field = "987A6AA6040898D3C8BF11B145CB7E2D")

    private int mDropDownLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.860 -0400", hash_original_field = "D03597FDEDE23F3823480E0520822BB2", hash_generated_field = "CBB0EE0A851756643DA52E1D33B6B161")

    private LayoutInflater mInflater;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.860 -0400", hash_original_method = "64F07E8E3FA816788C81269041C7BE2C", hash_generated_method = "53013D3A3F29175031F7903528B214EF")
    @Deprecated
    public  ResourceCursorAdapter(Context context, int layout, Cursor c) {
        super(context, c);
        addTaint(c.getTaint());
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.861 -0400", hash_original_method = "2548BF0AFC8B02A5BB725BAA0B70445F", hash_generated_method = "CA2E44791E3B839C002D72FC80792E8C")
    public  ResourceCursorAdapter(Context context, int layout, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        addTaint(autoRequery);
        addTaint(c.getTaint());
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.861 -0400", hash_original_method = "1C7227D889BF56CFA0B952AEE07E9BD1", hash_generated_method = "317D63852F959D2A0D0845D324886911")
    public  ResourceCursorAdapter(Context context, int layout, Cursor c, int flags) {
        super(context, c, flags);
        addTaint(flags);
        addTaint(c.getTaint());
        mLayout = mDropDownLayout = layout;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.862 -0400", hash_original_method = "E86C9DC4408CF260B8E6AACF31CF8025", hash_generated_method = "52DBA06CBE5F09774FC3253182EBE8D2")
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(cursor.getTaint());
        addTaint(context.getTaint());
View var68828DAED9379EACCE08B520DE480281_1647672776 =         mInflater.inflate(mLayout, parent, false);
        var68828DAED9379EACCE08B520DE480281_1647672776.addTaint(taint);
        return var68828DAED9379EACCE08B520DE480281_1647672776;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.862 -0400", hash_original_method = "C82CC5D78027B48163EBCC94CFA263B9", hash_generated_method = "B9751B78A5C40836754D0A7C3CC8326F")
    @Override
    public View newDropDownView(Context context, Cursor cursor, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(cursor.getTaint());
        addTaint(context.getTaint());
View varD511244D5B36DA80A1C2A116230466EA_255520258 =         mInflater.inflate(mDropDownLayout, parent, false);
        varD511244D5B36DA80A1C2A116230466EA_255520258.addTaint(taint);
        return varD511244D5B36DA80A1C2A116230466EA_255520258;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.862 -0400", hash_original_method = "D5BDA165ADCD99BE26CEA9E8AC3FEB13", hash_generated_method = "1A4A3AE74ACD1FAC94DDB52DB24657BB")
    public void setViewResource(int layout) {
        mLayout = layout;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:09.863 -0400", hash_original_method = "62C4D5A7D859DBC1B997DA83ECA5AEBB", hash_generated_method = "B6434D367B58893890DAD8DEC2EDE7DC")
    public void setDropDownViewResource(int dropDownLayout) {
        mDropDownLayout = dropDownLayout;
        
        
    }

    
}

