package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.Cursor;
import android.widget.Filter;

class CursorFilter extends Filter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.221 -0400", hash_original_field = "C2AFC6EFB8302E140D5B8FB82E161BFF", hash_generated_field = "D7B21BB19581EA5872B7B46EEFBFEFD2")

    CursorFilterClient mClient;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.222 -0400", hash_original_method = "D61DC331CF58D286B36C03C7DC72D315", hash_generated_method = "6E3D5C0883E914F2A2E7C1B092F68B97")
      CursorFilter(CursorFilterClient client) {
        mClient = client;
        // ---------- Original Method ----------
        //mClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.222 -0400", hash_original_method = "13FD068C641361B638C17FBE36928984", hash_generated_method = "A54278DDBE7B7838919D09DBBB81F0B8")
    @Override
    public CharSequence convertResultToString(Object resultValue) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2138996521 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2138996521 = mClient.convertToString((Cursor) resultValue);
        addTaint(resultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2138996521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2138996521;
        // ---------- Original Method ----------
        //return mClient.convertToString((Cursor) resultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.223 -0400", hash_original_method = "A46F4651EB2D092BF8983D238E1886EF", hash_generated_method = "F5F4735BCFF7A0A4A85BA81DFED9CA96")
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults varB4EAC82CA7396A68D541C85D26508E83_2028624017 = null; //Variable for return #1
        Cursor cursor;
        cursor = mClient.runQueryOnBackgroundThread(constraint);
        FilterResults results;
        results = new FilterResults();
        {
            results.count = cursor.getCount();
            results.values = cursor;
        } //End block
        {
            results.count = 0;
            results.values = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2028624017 = results;
        addTaint(constraint.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2028624017.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2028624017;
        // ---------- Original Method ----------
        //Cursor cursor = mClient.runQueryOnBackgroundThread(constraint);
        //FilterResults results = new FilterResults();
        //if (cursor != null) {
            //results.count = cursor.getCount();
            //results.values = cursor;
        //} else {
            //results.count = 0;
            //results.values = null;
        //}
        //return results;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.236 -0400", hash_original_method = "9BA8484E000B7F5A5243E4175A8A6AA1", hash_generated_method = "E84B3616505445C57236F943F1B9FC43")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        Cursor oldCursor;
        oldCursor = mClient.getCursor();
        {
            mClient.changeCursor((Cursor) results.values);
        } //End block
        addTaint(constraint.getTaint());
        addTaint(results.getTaint());
        // ---------- Original Method ----------
        //Cursor oldCursor = mClient.getCursor();
        //if (results.values != null && results.values != oldCursor) {
            //mClient.changeCursor((Cursor) results.values);
        //}
    }

    
    interface CursorFilterClient {
        CharSequence convertToString(Cursor cursor);
        Cursor runQueryOnBackgroundThread(CharSequence constraint);
        Cursor getCursor();
        void changeCursor(Cursor cursor);
    }
    
}

