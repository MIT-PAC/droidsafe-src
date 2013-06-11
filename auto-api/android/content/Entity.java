package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.os.Parcelable;
import android.os.Parcel;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;

public final class Entity {
    final private ContentValues mValues;
    final private ArrayList<NamedContentValues> mSubValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.531 -0400", hash_original_method = "F3CEBA8F3F7B881E0532AE5995D0A010", hash_generated_method = "B8B0BCAE8993AA44D785D576B0C6A4AA")
    @DSModeled(DSC.SAFE)
    public Entity(ContentValues values) {
        dsTaint.addTaint(values.dsTaint);
        mSubValues = new ArrayList<NamedContentValues>();
        // ---------- Original Method ----------
        //mValues = values;
        //mSubValues = new ArrayList<NamedContentValues>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.531 -0400", hash_original_method = "9F7798ADCC4D95B2412D7A9959C9D6A8", hash_generated_method = "1436618DD9D19624B63E301654BE6A2D")
    @DSModeled(DSC.SAFE)
    public ContentValues getEntityValues() {
        return (ContentValues)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.531 -0400", hash_original_method = "8F0C435720446C70ACF6C91C6A520904", hash_generated_method = "45CE2EA4D1509943B39CD91C14ABD9DD")
    @DSModeled(DSC.SAFE)
    public ArrayList<NamedContentValues> getSubValues() {
        return (ArrayList<NamedContentValues>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSubValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.531 -0400", hash_original_method = "449CDF61C26C702D333F5FFE04D80FB4", hash_generated_method = "7AFB83DF17D02EE274EDD4AAF5D5ED6A")
    @DSModeled(DSC.SPEC)
    public void addSubValue(Uri uri, ContentValues values) {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        mSubValues.add(new Entity.NamedContentValues(uri, values));
        // ---------- Original Method ----------
        //mSubValues.add(new Entity.NamedContentValues(uri, values));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.532 -0400", hash_original_method = "2AB28DA05FBE72723F9BBB19B5801CC4", hash_generated_method = "CC69AEA0D9065BCC6E5A1FA871734905")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Entity: ").append(getEntityValues());
        {
            Iterator<Entity.NamedContentValues> seatecAstronomy42 = getSubValues().iterator();
            seatecAstronomy42.hasNext();
            Entity.NamedContentValues namedValue = seatecAstronomy42.next();
            {
                sb.append("\n  ").append(namedValue.uri);
                sb.append("\n  -> ").append(namedValue.values);
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_175654570 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //final StringBuilder sb = new StringBuilder();
        //sb.append("Entity: ").append(getEntityValues());
        //for (Entity.NamedContentValues namedValue : getSubValues()) {
            //sb.append("\n  ").append(namedValue.uri);
            //sb.append("\n  -> ").append(namedValue.values);
        //}
        //return sb.toString();
    }

    
    public static class NamedContentValues {
        public final Uri uri;
        public final ContentValues values;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.532 -0400", hash_original_method = "533825480D51754A83735318617774D9", hash_generated_method = "719F01FE0C6D4568B90A30539841E1F7")
        @DSModeled(DSC.SPEC)
        public NamedContentValues(Uri uri, ContentValues values) {
            dsTaint.addTaint(values.dsTaint);
            dsTaint.addTaint(uri.dsTaint);
            // ---------- Original Method ----------
            //this.uri = uri;
            //this.values = values;
        }

        
    }


    
}


