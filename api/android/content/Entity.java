package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.net.Uri;

public final class Entity {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.345 -0500", hash_original_field = "4BBDD741F50F220390CF4FB3A7A2B7BA", hash_generated_field = "2CDA41B4D101B2B770760EBED9C98242")

     private ContentValues mValues;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.347 -0500", hash_original_field = "F159E93239387824FDF7C6DD32FDB550", hash_generated_field = "A0D35E97D8D95CF7A700DBE5D80CA8FF")

     private ArrayList<NamedContentValues> mSubValues;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.350 -0500", hash_original_method = "F3CEBA8F3F7B881E0532AE5995D0A010", hash_generated_method = "91291DB9B3613E1D19A83255B5D34AA0")
    
public Entity(ContentValues values) {
        mValues = values;
        mSubValues = new ArrayList<NamedContentValues>();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.352 -0500", hash_original_method = "9F7798ADCC4D95B2412D7A9959C9D6A8", hash_generated_method = "15EFDDD40DBDAEE56304A40B4513670D")
    
public ContentValues getEntityValues() {
        return mValues;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.354 -0500", hash_original_method = "8F0C435720446C70ACF6C91C6A520904", hash_generated_method = "46F344F82842A4CE323BED17EBAC6CDC")
    
public ArrayList<NamedContentValues> getSubValues() {
        return mSubValues;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.356 -0500", hash_original_method = "449CDF61C26C702D333F5FFE04D80FB4", hash_generated_method = "5AD9F8726178A503E97A851A0B2ED1A2")
    
public void addSubValue(Uri uri, ContentValues values) {
        mSubValues.add(new Entity.NamedContentValues(uri, values));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.369 -0500", hash_original_method = "2AB28DA05FBE72723F9BBB19B5801CC4", hash_generated_method = "56366AF07653F7836849199EFAE2630A")
    
public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Entity: ").append(getEntityValues());
        for (Entity.NamedContentValues namedValue : getSubValues()) {
            sb.append("\n  ").append(namedValue.uri);
            sb.append("\n  -> ").append(namedValue.values);
        }
        return sb.toString();
    }
    
    public static class NamedContentValues {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.360 -0500", hash_original_field = "F30A3503738FDB118E2076C7F22FF172", hash_generated_field = "CD245B47D421EDF9464454AF3C13247D")

        public  Uri uri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.363 -0500", hash_original_field = "0447B23FBF8F2DC77579AB5D67D851A7", hash_generated_field = "FAD78C29B35EAA7FE2C8690E9FAFF606")

        public  ContentValues values;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:42.366 -0500", hash_original_method = "533825480D51754A83735318617774D9", hash_generated_method = "6F40BC61F4BA6DECF43ACC94A5923B3B")
        
public NamedContentValues(Uri uri, ContentValues values) {
            this.uri = uri;
            this.values = values;
        }
        
    }
    
}

