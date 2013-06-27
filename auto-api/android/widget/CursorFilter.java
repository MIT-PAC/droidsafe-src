package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.Cursor;

class CursorFilter extends Filter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.472 -0400", hash_original_field = "C2AFC6EFB8302E140D5B8FB82E161BFF", hash_generated_field = "D7B21BB19581EA5872B7B46EEFBFEFD2")

    CursorFilterClient mClient;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.473 -0400", hash_original_method = "D61DC331CF58D286B36C03C7DC72D315", hash_generated_method = "6E3D5C0883E914F2A2E7C1B092F68B97")
      CursorFilter(CursorFilterClient client) {
        mClient = client;
        // ---------- Original Method ----------
        //mClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.485 -0400", hash_original_method = "13FD068C641361B638C17FBE36928984", hash_generated_method = "913FEE82C70C1272AABB1CCD37054DF4")
    @Override
    public CharSequence convertResultToString(Object resultValue) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_830706348 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_830706348 = mClient.convertToString((Cursor) resultValue);
        addTaint(resultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_830706348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_830706348;
        // ---------- Original Method ----------
        //return mClient.convertToString((Cursor) resultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.492 -0400", hash_original_method = "A46F4651EB2D092BF8983D238E1886EF", hash_generated_method = "C00D5F18BCFA4A6708A176E483300DED")
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults varB4EAC82CA7396A68D541C85D26508E83_1298674471 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1298674471 = results;
        addTaint(constraint.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1298674471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1298674471;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:06.492 -0400", hash_original_method = "9BA8484E000B7F5A5243E4175A8A6AA1", hash_generated_method = "E84B3616505445C57236F943F1B9FC43")
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

