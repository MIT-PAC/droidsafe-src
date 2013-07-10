package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.559 -0400", hash_original_method = "8CDDE404CCAAE32CB4E80B968E9086E6", hash_generated_method = "98D8627A1AB8DE395266F7B5DF74FF5B")
      SyncAdaptersCache(Context context) {
        super(context, SERVICE_INTERFACE, SERVICE_META_DATA, ATTRIBUTES_NAME, sSerializer);
        addTaint(context.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.560 -0400", hash_original_method = "F9B230DBB35FEE10F3AAB555789F4A09", hash_generated_method = "D0E9689488AC8C08490CC8D93858A3AE")
    public SyncAdapterType parseServiceAttributes(Resources res,
            String packageName, AttributeSet attrs) {
        SyncAdapterType varB4EAC82CA7396A68D541C85D26508E83_359996508 = null; 
        SyncAdapterType varB4EAC82CA7396A68D541C85D26508E83_2144439391 = null; 
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.SyncAdapter);
        try 
        {
            final String authority = sa.getString(com.android.internal.R.styleable.SyncAdapter_contentAuthority);
            final String accountType = sa.getString(com.android.internal.R.styleable.SyncAdapter_accountType);
            {
                varB4EAC82CA7396A68D541C85D26508E83_359996508 = null;
            } 
            final boolean userVisible = sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_userVisible, true);
            final boolean supportsUploading = sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_supportsUploading,
                            true);
            final boolean isAlwaysSyncable = sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_isAlwaysSyncable,
                            false);
            final boolean allowParallelSyncs = sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_allowParallelSyncs,
                            false);
            final String settingsActivity = sa.getString(com.android.internal.R.styleable
                            .SyncAdapter_settingsActivity);
            varB4EAC82CA7396A68D541C85D26508E83_2144439391 = new SyncAdapterType(authority, accountType, userVisible, supportsUploading,
                    isAlwaysSyncable, allowParallelSyncs, settingsActivity);
        } 
        finally 
        {
            sa.recycle();
        } 
        addTaint(res.getTaint());
        addTaint(packageName.getTaint());
        addTaint(attrs.getTaint());
        SyncAdapterType varA7E53CE21691AB073D9660D615818899_402077830; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_402077830 = varB4EAC82CA7396A68D541C85D26508E83_359996508;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_402077830 = varB4EAC82CA7396A68D541C85D26508E83_2144439391;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_402077830.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_402077830;
        
        
    }

    
    static class MySerializer implements XmlSerializerAndParser<SyncAdapterType> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.560 -0400", hash_original_method = "6E1FAE6E6E9693B60CA712A8476AA1E6", hash_generated_method = "6E1FAE6E6E9693B60CA712A8476AA1E6")
        public MySerializer ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.561 -0400", hash_original_method = "15333EFEF823B7914676A1825E4A4C8F", hash_generated_method = "313FBE9C43E31B655AFBA03F6950571C")
        public void writeAsXml(SyncAdapterType item, XmlSerializer out) throws IOException {
            out.attribute(null, "authority", item.authority);
            out.attribute(null, "accountType", item.accountType);
            addTaint(item.getTaint());
            addTaint(out.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.562 -0400", hash_original_method = "E847E68056A13960846185658512993F", hash_generated_method = "A92B1A04849DFF9649CB6C7844B9901C")
        public SyncAdapterType createFromXml(XmlPullParser parser) throws IOException, XmlPullParserException {
            SyncAdapterType varB4EAC82CA7396A68D541C85D26508E83_1996068489 = null; 
            final String authority = parser.getAttributeValue(null, "authority");
            final String accountType = parser.getAttributeValue(null, "accountType");
            varB4EAC82CA7396A68D541C85D26508E83_1996068489 = SyncAdapterType.newKey(authority, accountType);
            addTaint(parser.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1996068489.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1996068489;
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.562 -0400", hash_original_field = "88BC6D4B336F5098A115617D579E8465", hash_generated_field = "DFD9C75B63090EAAE5A4E1D087E8824B")

    private static final String TAG = "Account";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.562 -0400", hash_original_field = "2C55F8265FB4EBCBD45785B9E37A1405", hash_generated_field = "59887A17F3D56328CE5921EE7BAC7208")

    private static final String SERVICE_INTERFACE = "android.content.SyncAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.562 -0400", hash_original_field = "AB6AA9D6A8F65682722C6A03BB2F3962", hash_generated_field = "B965CC9F2D58B5F29B59B422674E8A41")

    private static final String SERVICE_META_DATA = "android.content.SyncAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.562 -0400", hash_original_field = "702A6D643C9163DBFED2BA8FEB9F09EB", hash_generated_field = "03DD69102D8F6B2F9E999B376ADF469A")

    private static final String ATTRIBUTES_NAME = "sync-adapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.562 -0400", hash_original_field = "5C108A317495C31F94D830D3B97E6771", hash_generated_field = "C1817FDD6C03FBAC02E4E4176D06D756")

    private static final MySerializer sSerializer = new MySerializer();
}

