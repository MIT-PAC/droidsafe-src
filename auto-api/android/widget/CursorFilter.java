package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.database.Cursor;

class CursorFilter extends Filter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.310 -0400", hash_original_field = "C2AFC6EFB8302E140D5B8FB82E161BFF", hash_generated_field = "D7B21BB19581EA5872B7B46EEFBFEFD2")

    CursorFilterClient mClient;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.310 -0400", hash_original_method = "D61DC331CF58D286B36C03C7DC72D315", hash_generated_method = "6E3D5C0883E914F2A2E7C1B092F68B97")
      CursorFilter(CursorFilterClient client) {
        mClient = client;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.311 -0400", hash_original_method = "13FD068C641361B638C17FBE36928984", hash_generated_method = "6037E08F7E942C79FC32AAC55DD1E401")
    @Override
    public CharSequence convertResultToString(Object resultValue) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2007627158 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2007627158 = mClient.convertToString((Cursor) resultValue);
        addTaint(resultValue.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2007627158.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2007627158;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.311 -0400", hash_original_method = "A46F4651EB2D092BF8983D238E1886EF", hash_generated_method = "30C8E842A20326D475BFADF83EA52221")
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults varB4EAC82CA7396A68D541C85D26508E83_1595122440 = null; 
        Cursor cursor = mClient.runQueryOnBackgroundThread(constraint);
        FilterResults results = new FilterResults();
        {
            results.count = cursor.getCount();
            results.values = cursor;
        } 
        {
            results.count = 0;
            results.values = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1595122440 = results;
        addTaint(constraint.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1595122440.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1595122440;
        
        
        
        
            
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:10.312 -0400", hash_original_method = "9BA8484E000B7F5A5243E4175A8A6AA1", hash_generated_method = "9281DEBA38AB6EC83134B8885228505B")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        Cursor oldCursor = mClient.getCursor();
        {
            mClient.changeCursor((Cursor) results.values);
        } 
        addTaint(constraint.getTaint());
        addTaint(results.getTaint());
        
        
        
            
        
    }

    
    interface CursorFilterClient {
        CharSequence convertToString(Cursor cursor);
        Cursor runQueryOnBackgroundThread(CharSequence constraint);
        Cursor getCursor();
        void changeCursor(Cursor cursor);
    }
    
}

