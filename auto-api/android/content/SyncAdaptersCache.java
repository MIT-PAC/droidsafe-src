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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.112 -0400", hash_original_method = "8CDDE404CCAAE32CB4E80B968E9086E6", hash_generated_method = "E5A0DC5E7425097021D4867100D22B09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SyncAdaptersCache(Context context) {
        super(context, SERVICE_INTERFACE, SERVICE_META_DATA, ATTRIBUTES_NAME, sSerializer);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.113 -0400", hash_original_method = "F9B230DBB35FEE10F3AAB555789F4A09", hash_generated_method = "DF514CDE09E8390E9EFCE578EEBF6E36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncAdapterType parseServiceAttributes(Resources res,
            String packageName, AttributeSet attrs) {
        dsTaint.addTaint(res.dsTaint);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(attrs.dsTaint);
        TypedArray sa;
        sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.SyncAdapter);
        try 
        {
            String authority;
            authority = sa.getString(com.android.internal.R.styleable.SyncAdapter_contentAuthority);
            String accountType;
            accountType = sa.getString(com.android.internal.R.styleable.SyncAdapter_accountType);
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
            SyncAdapterType var750BA9643314F8D5535F84AA61624D5D_20008677 = (new SyncAdapterType(authority, accountType, userVisible, supportsUploading,
                    isAlwaysSyncable, allowParallelSyncs, settingsActivity));
        } //End block
        finally 
        {
            sa.recycle();
        } //End block
        return (SyncAdapterType)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class MySerializer implements XmlSerializerAndParser<SyncAdapterType> {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.113 -0400", hash_original_method = "228985E7D221B8D50D3F9C5074A94F01", hash_generated_method = "228985E7D221B8D50D3F9C5074A94F01")
                public MySerializer ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.114 -0400", hash_original_method = "15333EFEF823B7914676A1825E4A4C8F", hash_generated_method = "D4B35EC6B3E0723A49CCE8EB4BE613B8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void writeAsXml(SyncAdapterType item, XmlSerializer out) throws IOException {
            dsTaint.addTaint(item.dsTaint);
            dsTaint.addTaint(out.dsTaint);
            out.attribute(null, "authority", item.authority);
            out.attribute(null, "accountType", item.accountType);
            // ---------- Original Method ----------
            //out.attribute(null, "authority", item.authority);
            //out.attribute(null, "accountType", item.accountType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.115 -0400", hash_original_method = "E847E68056A13960846185658512993F", hash_generated_method = "52AC24AE1978DCEA61C33F18BE45EF09")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncAdapterType createFromXml(XmlPullParser parser) throws IOException, XmlPullParserException {
            dsTaint.addTaint(parser.dsTaint);
            String authority;
            authority = parser.getAttributeValue(null, "authority");
            String accountType;
            accountType = parser.getAttributeValue(null, "accountType");
            SyncAdapterType var05AC44A7462121A2866DD9A1721D102F_1743098522 = (SyncAdapterType.newKey(authority, accountType));
            return (SyncAdapterType)dsTaint.getTaint();
            // ---------- Original Method ----------
            //final String authority = parser.getAttributeValue(null, "authority");
            //final String accountType = parser.getAttributeValue(null, "accountType");
            //return SyncAdapterType.newKey(authority, accountType);
        }

        
    }


    
    private static final String TAG = "Account";
    private static final String SERVICE_INTERFACE = "android.content.SyncAdapter";
    private static final String SERVICE_META_DATA = "android.content.SyncAdapter";
    private static final String ATTRIBUTES_NAME = "sync-adapter";
    private static final MySerializer sSerializer = new MySerializer();
}

