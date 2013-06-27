package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.pm.RegisteredServicesCache;
import android.content.pm.XmlSerializerAndParser;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

class SyncAdaptersCache extends RegisteredServicesCache<SyncAdapterType> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.620 -0400", hash_original_method = "8CDDE404CCAAE32CB4E80B968E9086E6", hash_generated_method = "98D8627A1AB8DE395266F7B5DF74FF5B")
      SyncAdaptersCache(Context context) {
        super(context, SERVICE_INTERFACE, SERVICE_META_DATA, ATTRIBUTES_NAME, sSerializer);
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.643 -0400", hash_original_method = "F9B230DBB35FEE10F3AAB555789F4A09", hash_generated_method = "8BB38D12F59554EBC5CF10932570A4F2")
    public SyncAdapterType parseServiceAttributes(Resources res,
            String packageName, AttributeSet attrs) {
        SyncAdapterType varB4EAC82CA7396A68D541C85D26508E83_1894716796 = null; //Variable for return #1
        SyncAdapterType varB4EAC82CA7396A68D541C85D26508E83_587411121 = null; //Variable for return #2
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.SyncAdapter);
        try 
        {
            String authority;
            authority = sa.getString(com.android.internal.R.styleable.SyncAdapter_contentAuthority);
            String accountType;
            accountType = sa.getString(com.android.internal.R.styleable.SyncAdapter_accountType);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1894716796 = null;
            } //End block
            boolean userVisible;
            userVisible = sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_userVisible, true);
            boolean supportsUploading;
            supportsUploading = sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_supportsUploading,
                            true);
            boolean isAlwaysSyncable;
            isAlwaysSyncable = sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_isAlwaysSyncable,
                            false);
            boolean allowParallelSyncs;
            allowParallelSyncs = sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_allowParallelSyncs,
                            false);
            String settingsActivity;
            settingsActivity = sa.getString(com.android.internal.R.styleable
                            .SyncAdapter_settingsActivity);
            varB4EAC82CA7396A68D541C85D26508E83_587411121 = new SyncAdapterType(authority, accountType, userVisible, supportsUploading,
                    isAlwaysSyncable, allowParallelSyncs, settingsActivity);
        } //End block
        finally 
        {
            sa.recycle();
        } //End block
        addTaint(res.getTaint());
        addTaint(packageName.getTaint());
        addTaint(attrs.getTaint());
        SyncAdapterType varA7E53CE21691AB073D9660D615818899_580400247; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_580400247 = varB4EAC82CA7396A68D541C85D26508E83_1894716796;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_580400247 = varB4EAC82CA7396A68D541C85D26508E83_587411121;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_580400247.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_580400247;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class MySerializer implements XmlSerializerAndParser<SyncAdapterType> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.644 -0400", hash_original_method = "6E1FAE6E6E9693B60CA712A8476AA1E6", hash_generated_method = "6E1FAE6E6E9693B60CA712A8476AA1E6")
        public MySerializer ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.645 -0400", hash_original_method = "15333EFEF823B7914676A1825E4A4C8F", hash_generated_method = "313FBE9C43E31B655AFBA03F6950571C")
        public void writeAsXml(SyncAdapterType item, XmlSerializer out) throws IOException {
            out.attribute(null, "authority", item.authority);
            out.attribute(null, "accountType", item.accountType);
            addTaint(item.getTaint());
            addTaint(out.getTaint());
            // ---------- Original Method ----------
            //out.attribute(null, "authority", item.authority);
            //out.attribute(null, "accountType", item.accountType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.661 -0400", hash_original_method = "E847E68056A13960846185658512993F", hash_generated_method = "DF76E42D68883906B8F19986FA63D955")
        public SyncAdapterType createFromXml(XmlPullParser parser) throws IOException, XmlPullParserException {
            SyncAdapterType varB4EAC82CA7396A68D541C85D26508E83_689703329 = null; //Variable for return #1
            String authority;
            authority = parser.getAttributeValue(null, "authority");
            String accountType;
            accountType = parser.getAttributeValue(null, "accountType");
            varB4EAC82CA7396A68D541C85D26508E83_689703329 = SyncAdapterType.newKey(authority, accountType);
            addTaint(parser.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_689703329.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_689703329;
            // ---------- Original Method ----------
            //final String authority = parser.getAttributeValue(null, "authority");
            //final String accountType = parser.getAttributeValue(null, "accountType");
            //return SyncAdapterType.newKey(authority, accountType);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.662 -0400", hash_original_field = "88BC6D4B336F5098A115617D579E8465", hash_generated_field = "7CBE65C760DC745827B4A780061F1AE2")

    private static String TAG = "Account";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.662 -0400", hash_original_field = "2C55F8265FB4EBCBD45785B9E37A1405", hash_generated_field = "646B770B282B67D2C7A05764997E19C2")

    private static String SERVICE_INTERFACE = "android.content.SyncAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.662 -0400", hash_original_field = "AB6AA9D6A8F65682722C6A03BB2F3962", hash_generated_field = "FC4AA0A7307EC8432B438F122377D5BB")

    private static String SERVICE_META_DATA = "android.content.SyncAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.662 -0400", hash_original_field = "702A6D643C9163DBFED2BA8FEB9F09EB", hash_generated_field = "8208BED3657FF937F44B67519486DD26")

    private static String ATTRIBUTES_NAME = "sync-adapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.663 -0400", hash_original_field = "5C108A317495C31F94D830D3B97E6771", hash_generated_field = "927C699886624B6463FA107A0D02C977")

    private static MySerializer sSerializer = new MySerializer();
}

