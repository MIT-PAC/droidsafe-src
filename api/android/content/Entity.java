package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.os.Parcel;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;

public final class Entity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.523 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

    private ContentValues mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.523 -0400", hash_original_field = "76A66352B35F47FCFAE3288541EB8FEA", hash_generated_field = "A0D35E97D8D95CF7A700DBE5D80CA8FF")

    private ArrayList<NamedContentValues> mSubValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.523 -0400", hash_original_method = "F3CEBA8F3F7B881E0532AE5995D0A010", hash_generated_method = "EABD197C03FF12EBD2C18CFF71395ADF")
    public  Entity(ContentValues values) {
        mValues = values;
        mSubValues = new ArrayList<NamedContentValues>();
        // ---------- Original Method ----------
        //mValues = values;
        //mSubValues = new ArrayList<NamedContentValues>();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.524 -0400", hash_original_method = "9F7798ADCC4D95B2412D7A9959C9D6A8", hash_generated_method = "9BE36D2DB2D9BEBC7DC353A0C1183061")
    public ContentValues getEntityValues() {
ContentValues varC2D5F196132EC24FFA86AC8D1AA44E77_702251163 =         mValues;
        varC2D5F196132EC24FFA86AC8D1AA44E77_702251163.addTaint(taint);
        return varC2D5F196132EC24FFA86AC8D1AA44E77_702251163;
        // ---------- Original Method ----------
        //return mValues;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.524 -0400", hash_original_method = "8F0C435720446C70ACF6C91C6A520904", hash_generated_method = "5BAB70B7F0F61B500DE5D1158C3AF6FF")
    public ArrayList<NamedContentValues> getSubValues() {
ArrayList<NamedContentValues> var5927EF407499F6B0E6446B9609227466_1334697494 =         mSubValues;
        var5927EF407499F6B0E6446B9609227466_1334697494.addTaint(taint);
        return var5927EF407499F6B0E6446B9609227466_1334697494;
        // ---------- Original Method ----------
        //return mSubValues;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.524 -0400", hash_original_method = "449CDF61C26C702D333F5FFE04D80FB4", hash_generated_method = "56706391E1CF37C4698B4A0787BEEBF1")
    public void addSubValue(Uri uri, ContentValues values) {
        addTaint(values.getTaint());
        addTaint(uri.getTaint());
        mSubValues.add(new Entity.NamedContentValues(uri, values));
        // ---------- Original Method ----------
        //mSubValues.add(new Entity.NamedContentValues(uri, values));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.525 -0400", hash_original_method = "2AB28DA05FBE72723F9BBB19B5801CC4", hash_generated_method = "A9AD525D293539BB24D6B8E478AE6434")
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Entity: ").append(getEntityValues());
for(Entity.NamedContentValues namedValue : getSubValues())
        {
            sb.append("\n  ").append(namedValue.uri);
            sb.append("\n  -> ").append(namedValue.values);
        } //End block
String var2460B846747F8B22185AD8BE722266A5_748626060 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_748626060.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_748626060;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.525 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "CD245B47D421EDF9464454AF3C13247D")

        public Uri uri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.526 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "FAD78C29B35EAA7FE2C8690E9FAFF606")

        public ContentValues values;
        
                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.526 -0400", hash_original_method = "533825480D51754A83735318617774D9", hash_generated_method = "6BF5E55727791FDE823E7FD6A13C3F01")
        public  NamedContentValues(Uri uri, ContentValues values) {
            this.uri = uri;
            this.values = values;
            // ---------- Original Method ----------
            //this.uri = uri;
            //this.values = values;
        }

        
    }


    
}

