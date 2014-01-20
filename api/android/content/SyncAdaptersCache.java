package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.content.pm.RegisteredServicesCache;
import android.content.pm.XmlSerializerAndParser;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;

class SyncAdaptersCache extends RegisteredServicesCache<SyncAdapterType> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.687 -0500", hash_original_field = "6DC951A766331AA637AABD8353624C22", hash_generated_field = "DFD9C75B63090EAAE5A4E1D087E8824B")

    private static final String TAG = "Account";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.689 -0500", hash_original_field = "98A15733B14CA4344A0B58C3DD90FE0F", hash_generated_field = "59887A17F3D56328CE5921EE7BAC7208")

    private static final String SERVICE_INTERFACE = "android.content.SyncAdapter";
    
    static class MySerializer implements XmlSerializerAndParser<SyncAdapterType> {
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:01.933 -0400", hash_original_method = "6E1FAE6E6E9693B60CA712A8476AA1E6", hash_generated_method = "6E1FAE6E6E9693B60CA712A8476AA1E6")
        public MySerializer ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.705 -0500", hash_original_method = "15333EFEF823B7914676A1825E4A4C8F", hash_generated_method = "3CAD0B24077BA16687A3977C52D1F52D")
        
public void writeAsXml(SyncAdapterType item, XmlSerializer out) throws IOException {
            out.attribute(null, "authority", item.authority);
            out.attribute(null, "accountType", item.accountType);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.707 -0500", hash_original_method = "E847E68056A13960846185658512993F", hash_generated_method = "C182B87930032C86B30537E6EFC7EE4E")
        
public SyncAdapterType createFromXml(XmlPullParser parser)
                throws IOException, XmlPullParserException {
            final String authority = parser.getAttributeValue(null, "authority");
            final String accountType = parser.getAttributeValue(null, "accountType");
            return SyncAdapterType.newKey(authority, accountType);
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.691 -0500", hash_original_field = "C650BBA7E35ACCA34B98B85CDBC673BB", hash_generated_field = "B965CC9F2D58B5F29B59B422674E8A41")

    private static final String SERVICE_META_DATA = "android.content.SyncAdapter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.694 -0500", hash_original_field = "BF6E179F5F25D4F8831903528C911B70", hash_generated_field = "03DD69102D8F6B2F9E999B376ADF469A")

    private static final String ATTRIBUTES_NAME = "sync-adapter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.697 -0500", hash_original_field = "8DD095F5D65041BB269FBCA26198E23C", hash_generated_field = "C1817FDD6C03FBAC02E4E4176D06D756")

    private static final MySerializer sSerializer = new MySerializer();

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.699 -0500", hash_original_method = "8CDDE404CCAAE32CB4E80B968E9086E6", hash_generated_method = "8CDDE404CCAAE32CB4E80B968E9086E6")
    
SyncAdaptersCache(Context context) {
        super(context, SERVICE_INTERFACE, SERVICE_META_DATA, ATTRIBUTES_NAME, sSerializer);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:32.702 -0500", hash_original_method = "F9B230DBB35FEE10F3AAB555789F4A09", hash_generated_method = "980F9E927BDF828D50BCD0FBA9EBB8EA")
    
public SyncAdapterType parseServiceAttributes(Resources res,
            String packageName, AttributeSet attrs) {
        TypedArray sa = res.obtainAttributes(attrs,
                com.android.internal.R.styleable.SyncAdapter);
        try {
            final String authority =
                    sa.getString(com.android.internal.R.styleable.SyncAdapter_contentAuthority);
            final String accountType =
                    sa.getString(com.android.internal.R.styleable.SyncAdapter_accountType);
            if (authority == null || accountType == null) {
                return null;
            }
            final boolean userVisible =
                    sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_userVisible, true);
            final boolean supportsUploading =
                    sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_supportsUploading,
                            true);
            final boolean isAlwaysSyncable =
                    sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_isAlwaysSyncable,
                            false);
            final boolean allowParallelSyncs =
                    sa.getBoolean(com.android.internal.R.styleable.SyncAdapter_allowParallelSyncs,
                            false);
            final String settingsActivity =
                    sa.getString(com.android.internal.R.styleable
                            .SyncAdapter_settingsActivity);
            return new SyncAdapterType(authority, accountType, userVisible, supportsUploading,
                    isAlwaysSyncable, allowParallelSyncs, settingsActivity);
        } finally {
            sa.recycle();
        }
    }
}

