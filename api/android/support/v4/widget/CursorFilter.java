package android.support.v4.widget;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.database.Cursor;
import android.widget.Filter;



class CursorFilter extends Filter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.009 -0400", hash_original_field = "C2AFC6EFB8302E140D5B8FB82E161BFF", hash_generated_field = "D7B21BB19581EA5872B7B46EEFBFEFD2")

    CursorFilterClient mClient;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.009 -0400", hash_original_method = "D61DC331CF58D286B36C03C7DC72D315", hash_generated_method = "6E3D5C0883E914F2A2E7C1B092F68B97")
      CursorFilter(CursorFilterClient client) {
        mClient = client;
        // ---------- Original Method ----------
        //mClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.009 -0400", hash_original_method = "13FD068C641361B638C17FBE36928984", hash_generated_method = "756EC37D1479D1EE2301BEE152EE9C18")
    @Override
    public CharSequence convertResultToString(Object resultValue) {
        addTaint(resultValue.getTaint());
CharSequence var96717A582256C30A3C013FF45D0F5738_1525537117 =         mClient.convertToString((Cursor) resultValue);
        var96717A582256C30A3C013FF45D0F5738_1525537117.addTaint(taint);
        return var96717A582256C30A3C013FF45D0F5738_1525537117;
        // ---------- Original Method ----------
        //return mClient.convertToString((Cursor) resultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.009 -0400", hash_original_method = "A46F4651EB2D092BF8983D238E1886EF", hash_generated_method = "6D9EA38260BC3691D62F4C1D925473A4")
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        addTaint(constraint.getTaint());
        Cursor cursor = mClient.runQueryOnBackgroundThread(constraint);
        FilterResults results = new FilterResults();
        if(cursor != null)        
        {
            results.count = cursor.getCount();
            results.values = cursor;
        } //End block
        else
        {
            results.count = 0;
            results.values = null;
        } //End block
FilterResults var238ECCC9872FFCA0B3C3DB83598FF044_1158287802 =         results;
        var238ECCC9872FFCA0B3C3DB83598FF044_1158287802.addTaint(taint);
        return var238ECCC9872FFCA0B3C3DB83598FF044_1158287802;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:34.010 -0400", hash_original_method = "9BA8484E000B7F5A5243E4175A8A6AA1", hash_generated_method = "07A6D1B9C8B212FBC9454342D3AD39D0")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        addTaint(results.getTaint());
        addTaint(constraint.getTaint());
        Cursor oldCursor = mClient.getCursor();
        if(results.values != null && results.values != oldCursor)        
        {
            mClient.changeCursor((Cursor) results.values);
        } //End block
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

