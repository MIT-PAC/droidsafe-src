package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.Cursor;

class CursorFilter extends Filter {
    CursorFilterClient mClient;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.407 -0400", hash_original_method = "D61DC331CF58D286B36C03C7DC72D315", hash_generated_method = "CA813A5CE4989141707D0822DD0983BA")
    @DSModeled(DSC.SAFE)
     CursorFilter(CursorFilterClient client) {
        dsTaint.addTaint(client.dsTaint);
        // ---------- Original Method ----------
        //mClient = client;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.407 -0400", hash_original_method = "13FD068C641361B638C17FBE36928984", hash_generated_method = "EFD5F170B6DCDF01AD2B8C60D7318758")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence convertResultToString(Object resultValue) {
        dsTaint.addTaint(resultValue.dsTaint);
        CharSequence varB2571F6262C40033975F850E8CB832A8_532663736 = (mClient.convertToString((Cursor) resultValue));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mClient.convertToString((Cursor) resultValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.407 -0400", hash_original_method = "A46F4651EB2D092BF8983D238E1886EF", hash_generated_method = "1B73D5FCE34443F8C34DFDCCB57DC6BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        dsTaint.addTaint(constraint);
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
        return (FilterResults)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.408 -0400", hash_original_method = "9BA8484E000B7F5A5243E4175A8A6AA1", hash_generated_method = "1654AFE9137440CE8DCF9789108E6A7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        dsTaint.addTaint(results.dsTaint);
        dsTaint.addTaint(constraint);
        Cursor oldCursor;
        oldCursor = mClient.getCursor();
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

