package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.Cursor;

class CursorFilter extends Filter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.928 -0400", hash_original_field = "C2AFC6EFB8302E140D5B8FB82E161BFF", hash_generated_field = "D7B21BB19581EA5872B7B46EEFBFEFD2")

    CursorFilterClient mClient;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.928 -0400", hash_original_method = "D61DC331CF58D286B36C03C7DC72D315", hash_generated_method = "6E3D5C0883E914F2A2E7C1B092F68B97")
      CursorFilter(CursorFilterClient client) {
        mClient = client;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.929 -0400", hash_original_method = "13FD068C641361B638C17FBE36928984", hash_generated_method = "56010BC93026B9693376E40893023824")
    @Override
    public CharSequence convertResultToString(Object resultValue) {
        addTaint(resultValue.getTaint());
CharSequence var96717A582256C30A3C013FF45D0F5738_627331209 =         mClient.convertToString((Cursor) resultValue);
        var96717A582256C30A3C013FF45D0F5738_627331209.addTaint(taint);
        return var96717A582256C30A3C013FF45D0F5738_627331209;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.933 -0400", hash_original_method = "A46F4651EB2D092BF8983D238E1886EF", hash_generated_method = "5B5E83B070C4A42DCA083CC049B98709")
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        addTaint(constraint.getTaint());
        Cursor cursor = mClient.runQueryOnBackgroundThread(constraint);
        FilterResults results = new FilterResults();
    if(cursor != null)        
        {
            results.count = cursor.getCount();
            results.values = cursor;
        } 
        else
        {
            results.count = 0;
            results.values = null;
        } 
FilterResults var238ECCC9872FFCA0B3C3DB83598FF044_2055990058 =         results;
        var238ECCC9872FFCA0B3C3DB83598FF044_2055990058.addTaint(taint);
        return var238ECCC9872FFCA0B3C3DB83598FF044_2055990058;
        
        
        
        
            
            
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:04.933 -0400", hash_original_method = "9BA8484E000B7F5A5243E4175A8A6AA1", hash_generated_method = "07A6D1B9C8B212FBC9454342D3AD39D0")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        addTaint(results.getTaint());
        addTaint(constraint.getTaint());
        Cursor oldCursor = mClient.getCursor();
    if(results.values != null && results.values != oldCursor)        
        {
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

