package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;

public final class Entity {
    private ContentValues mValues;
    private ArrayList<NamedContentValues> mSubValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.180 -0400", hash_original_method = "F3CEBA8F3F7B881E0532AE5995D0A010", hash_generated_method = "E86975AEF6BB4A035AD3246898C778A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Entity(ContentValues values) {
        dsTaint.addTaint(values.dsTaint);
        mSubValues = new ArrayList<NamedContentValues>();
        // ---------- Original Method ----------
        //mValues = values;
        //mSubValues = new ArrayList<NamedContentValues>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.180 -0400", hash_original_method = "9F7798ADCC4D95B2412D7A9959C9D6A8", hash_generated_method = "520A356C8635D5A1389184AE7E994E8B")
    @DSModeled(DSC.SAFE)
    public ContentValues getEntityValues() {
        return (ContentValues)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.181 -0400", hash_original_method = "8F0C435720446C70ACF6C91C6A520904", hash_generated_method = "CA0AB60211E538B66981EAEDCB6FEF27")
    @DSModeled(DSC.SAFE)
    public ArrayList<NamedContentValues> getSubValues() {
        return (ArrayList<NamedContentValues>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSubValues;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.181 -0400", hash_original_method = "449CDF61C26C702D333F5FFE04D80FB4", hash_generated_method = "1780A5970B4617F24A75CD93A5F5B1C9")
    @DSModeled(DSC.SPEC)
    public void addSubValue(Uri uri, ContentValues values) {
        dsTaint.addTaint(values.dsTaint);
        dsTaint.addTaint(uri.dsTaint);
        mSubValues.add(new Entity.NamedContentValues(uri, values));
        // ---------- Original Method ----------
        //mSubValues.add(new Entity.NamedContentValues(uri, values));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.195 -0400", hash_original_method = "2AB28DA05FBE72723F9BBB19B5801CC4", hash_generated_method = "18A5838DA9C366A588C6191217758B19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Entity: ").append(getEntityValues());
        {
            Iterator<Entity.NamedContentValues> var1B10561C24033D8FCFC2DEDACF29A4CB_341812765 = (getSubValues()).iterator();
            var1B10561C24033D8FCFC2DEDACF29A4CB_341812765.hasNext();
            Entity.NamedContentValues namedValue = var1B10561C24033D8FCFC2DEDACF29A4CB_341812765.next();
            {
                sb.append("\n  ").append(namedValue.uri);
                sb.append("\n  -> ").append(namedValue.values);
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_1757465649 = (sb.toString());
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
        public Uri uri;
        public ContentValues values;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.197 -0400", hash_original_method = "533825480D51754A83735318617774D9", hash_generated_method = "AE16BB7C8BC66490B2ECFCC0F7377400")
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

