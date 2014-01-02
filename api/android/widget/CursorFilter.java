package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.database.Cursor;



class CursorFilter extends Filter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.218 -0500", hash_original_field = "D7B21BB19581EA5872B7B46EEFBFEFD2", hash_generated_field = "D7B21BB19581EA5872B7B46EEFBFEFD2")

    
    CursorFilterClient mClient;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.222 -0500", hash_original_method = "D61DC331CF58D286B36C03C7DC72D315", hash_generated_method = "D61DC331CF58D286B36C03C7DC72D315")
    
CursorFilter(CursorFilterClient client) {
        mClient = client;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.224 -0500", hash_original_method = "13FD068C641361B638C17FBE36928984", hash_generated_method = "FF91822F802434705CBC4C09319997FF")
    
@Override
    public CharSequence convertResultToString(Object resultValue) {
        return mClient.convertToString((Cursor) resultValue);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.226 -0500", hash_original_method = "A46F4651EB2D092BF8983D238E1886EF", hash_generated_method = "E68AF8F684BAC8BB9C76E876AB44A3BD")
    
@Override
    protected FilterResults performFiltering(CharSequence constraint) {
        Cursor cursor = mClient.runQueryOnBackgroundThread(constraint);

        FilterResults results = new FilterResults();
        if (cursor != null) {
            results.count = cursor.getCount();
            results.values = cursor;
        } else {
            results.count = 0;
            results.values = null;
        }
        return results;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:33.229 -0500", hash_original_method = "9BA8484E000B7F5A5243E4175A8A6AA1", hash_generated_method = "F36CBE0D47BEC60B532B63E6A8C401B3")
    
@Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        Cursor oldCursor = mClient.getCursor();
        
        if (results.values != null && results.values != oldCursor) {
            mClient.changeCursor((Cursor) results.values);
        }
    }

    
    interface CursorFilterClient {
        CharSequence convertToString(Cursor cursor);
        Cursor runQueryOnBackgroundThread(CharSequence constraint);
        Cursor getCursor();
        void changeCursor(Cursor cursor);
    }
    
}

