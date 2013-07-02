package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;
import android.os.Parcel;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;

public final class Entity {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:37:52.285 -0400", hash_original_field = "90BFF6F4E8E62CBC2DC12A9ACE468001", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

    private ContentValues mValues;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:37:52.285 -0400", hash_original_field = "76A66352B35F47FCFAE3288541EB8FEA", hash_generated_field = "A0D35E97D8D95CF7A700DBE5D80CA8FF")

    private ArrayList<NamedContentValues> mSubValues;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:37:52.289 -0400", hash_original_method = "F3CEBA8F3F7B881E0532AE5995D0A010", hash_generated_method = "A0F41973C26BBD2EF4AEC2688117A9CD")
    public void Entity(ContentValues values) {
        mValues = values;
        mSubValues = new ArrayList<NamedContentValues>();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:37:52.294 -0400", hash_original_method = "9F7798ADCC4D95B2412D7A9959C9D6A8", hash_generated_method = "31206EA52D71C2AAE119741FB69AFC90")
    public ContentValues getEntityValues() {
        ContentValues var0B3F26AA9B0B1F6439612E31660CBF58_1397921823; 
        var0B3F26AA9B0B1F6439612E31660CBF58_1397921823 = mValues;
        ContentValues var1E6151782509B2C92750CFF962B742CD_575924772 = var0B3F26AA9B0B1F6439612E31660CBF58_1397921823;
        var1E6151782509B2C92750CFF962B742CD_575924772.addTaint(getTaint()); 
        return var1E6151782509B2C92750CFF962B742CD_575924772;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:37:52.300 -0400", hash_original_method = "8F0C435720446C70ACF6C91C6A520904", hash_generated_method = "75C0ED9AD29900EC19C99F879F46FC61")
    public ArrayList<NamedContentValues> getSubValues() {
        ArrayList<NamedContentValues> var3D9959157E96E1475F221AA7D27AA229_1398072199; 
        var3D9959157E96E1475F221AA7D27AA229_1398072199 = mSubValues;
        ArrayList<NamedContentValues> var1E6151782509B2C92750CFF962B742CD_1353465674 = var3D9959157E96E1475F221AA7D27AA229_1398072199;
        var1E6151782509B2C92750CFF962B742CD_1353465674.addTaint(getTaint()); 
        return var1E6151782509B2C92750CFF962B742CD_1353465674;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:37:52.303 -0400", hash_original_method = "449CDF61C26C702D333F5FFE04D80FB4", hash_generated_method = "85E31631BE5378DEF6F4D769C07CF941")
    public void addSubValue(Uri uri, ContentValues values) {
        mSubValues.add(new Entity.NamedContentValues(uri, values));
        addTaint(uri.getTaint());
        addTaint(values.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:12.280 -0400", hash_original_method = "2AB28DA05FBE72723F9BBB19B5801CC4", hash_generated_method = "1B8C3E560866DD82693309C96956A944")
    public String toString() {
        String var514A0BA3FE098DCA8E0FB2C35A4AB3F6_1995672588; 
        StringBuilder sb;
        sb = new StringBuilder();
        sb.append("Entity: ").append(getEntityValues());
        {
            Iterator<Entity.NamedContentValues> var1B10561C24033D8FCFC2DEDACF29A4CB_1633430471 = (getSubValues()).iterator();
            var1B10561C24033D8FCFC2DEDACF29A4CB_1633430471.hasNext();
            Entity.NamedContentValues namedValue = var1B10561C24033D8FCFC2DEDACF29A4CB_1633430471.next();
            {
                sb.append("\n  ").append(namedValue.uri);
                sb.append("\n  -> ").append(namedValue.values);
            } 
        } 
        var514A0BA3FE098DCA8E0FB2C35A4AB3F6_1995672588 = sb.toString();
        String var1E6151782509B2C92750CFF962B742CD_959849163 = var514A0BA3FE098DCA8E0FB2C35A4AB3F6_1995672588;
        var1E6151782509B2C92750CFF962B742CD_959849163.addTaint(getTaint()); 
        return var1E6151782509B2C92750CFF962B742CD_959849163;
        
        
        
        
            
            
        
        
    }

    
    public static class NamedContentValues {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:12.281 -0400", hash_original_field = "9305B73D359BD06734FEE0B3638079E1", hash_generated_field = "CD245B47D421EDF9464454AF3C13247D")

        public Uri uri;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:12.282 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "FAD78C29B35EAA7FE2C8690E9FAFF606")

        public ContentValues values;
        
        public NamedContentValues(Uri uri2, ContentValues values2) {
			
		}

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 15:38:12.285 -0400", hash_original_method = "533825480D51754A83735318617774D9", hash_generated_method = "C8064FBF3B8433C85D625F13DADD73EB")
        public void NamedContentValues(Uri uri, ContentValues values) {
            this.uri = uri;
            this.values = values;
            
            
            
        }

        
    }


    
}

