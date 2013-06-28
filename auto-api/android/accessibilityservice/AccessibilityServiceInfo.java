package android.accessibilityservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.accessibility.AccessibilityEvent;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;

public class AccessibilityServiceInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.071 -0400", hash_original_field = "B6798C32DB18990EFA91D37F3C984B4D", hash_generated_field = "EEF9A290ACD5C7B733F6B6DEDE8E3A43")

    public int eventTypes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.073 -0400", hash_original_field = "CDFCE21563C1C11CAC0A8B86CB3D248A", hash_generated_field = "4498F27AF93559A7532BFFF1A93CBFB9")

    public String[] packageNames;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.073 -0400", hash_original_field = "EF3D4DB24D1A38BA00C793A35B38641C", hash_generated_field = "68FE335A39435FE4A5727D74F41FDDD2")

    public int feedbackType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.074 -0400", hash_original_field = "634929FAC91F7F5B885BEAA1660825D9", hash_generated_field = "F1CBE56C199C9B56F74193D61740D91B")

    public long notificationTimeout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.074 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.074 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "34D624C7CD290D72B15AB814BF1BA854")

    private String mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.075 -0400", hash_original_field = "B56830C8982A0389C507F778EDDBDB2E", hash_generated_field = "6B33B1DC79BC09883016E8729764237B")

    private ResolveInfo mResolveInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.075 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "3227A556BB8D91CC368DE162089FC968")

    private String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.076 -0400", hash_original_field = "6D4745E833964FE3F3A2EBA5882199BF", hash_generated_field = "D82CCF51637435103547C999EFEF8AB3")

    private boolean mCanRetrieveWindowContent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.076 -0400", hash_original_field = "FF2B9B684DDD70D7BE468C8D9A54343D", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.078 -0400", hash_original_method = "32AC306673DA52F864FB7CE370FDF901", hash_generated_method = "96C87DCFF62BE612814976BB93D4DE38")
    public  AccessibilityServiceInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.097 -0400", hash_original_method = "D068D99220BF43F7F5E36309EDDC7C96", hash_generated_method = "F91D823F18D4E0EFF92EE052A0360A99")
    public  AccessibilityServiceInfo(ResolveInfo resolveInfo, Context context) throws XmlPullParserException, IOException {
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        mId = new ComponentName(serviceInfo.packageName, serviceInfo.name).flattenToShortString();
        mResolveInfo = resolveInfo;
        XmlResourceParser parser = null;
        try 
        {
            PackageManager packageManager = context.getPackageManager();
            parser = serviceInfo.loadXmlMetaData(packageManager,
                    AccessibilityService.SERVICE_META_DATA);
            int type = 0;
            {
                type = parser.next();
            } //End block
            String nodeName = parser.getName();
            {
                boolean varEA4A996B829F560398797296F3090D5F_1517819893 = (!TAG_ACCESSIBILITY_SERVICE.equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException( "Meta-data does not start with"
                        + TAG_ACCESSIBILITY_SERVICE + " tag");
                } //End block
            } //End collapsed parenthetic
            AttributeSet allAttributes = Xml.asAttributeSet(parser);
            Resources resources = packageManager.getResourcesForApplication(
                    serviceInfo.applicationInfo);
            TypedArray asAttributes = resources.obtainAttributes(allAttributes,
                    com.android.internal.R.styleable.AccessibilityService);
            eventTypes = asAttributes.getInt(
                    com.android.internal.R.styleable.AccessibilityService_accessibilityEventTypes,
                    0);
            String packageNamez = asAttributes.getString(
                    com.android.internal.R.styleable.AccessibilityService_packageNames);
            {
                packageNames = packageNamez.split("(\\s)*,(\\s)*");
            } //End block
            feedbackType = asAttributes.getInt(
                    com.android.internal.R.styleable.AccessibilityService_accessibilityFeedbackType,
                    0);
            notificationTimeout = asAttributes.getInt(
                    com.android.internal.R.styleable.AccessibilityService_notificationTimeout, 
                    0);
            flags = asAttributes.getInt(
                    com.android.internal.R.styleable.AccessibilityService_accessibilityFlags, 0);
            mSettingsActivityName = asAttributes.getString(
                    com.android.internal.R.styleable.AccessibilityService_settingsActivity);
            mCanRetrieveWindowContent = asAttributes.getBoolean(
                    com.android.internal.R.styleable.AccessibilityService_canRetrieveWindowContent,
                    false);
            mDescription = asAttributes.getString(
                    com.android.internal.R.styleable.AccessibilityService_description);
            asAttributes.recycle();
        } //End block
        catch (NameNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException( "Unable to create context for: "
                    + serviceInfo.packageName);
        } //End block
        finally 
        {
            {
                parser.close();
            } //End block
        } //End block
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.104 -0400", hash_original_method = "2C9B75B7F79417EB76D61370935CF9C8", hash_generated_method = "A0C7324A63FA3E4756821C675147A473")
    public void updateDynamicallyConfigurableProperties(AccessibilityServiceInfo other) {
        eventTypes = other.eventTypes;
        packageNames = other.packageNames;
        feedbackType = other.feedbackType;
        notificationTimeout = other.notificationTimeout;
        flags = other.flags;
        // ---------- Original Method ----------
        //eventTypes = other.eventTypes;
        //packageNames = other.packageNames;
        //feedbackType = other.feedbackType;
        //notificationTimeout = other.notificationTimeout;
        //flags = other.flags;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.112 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "3EED6C249AA90791338F588D56003678")
    public String getId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1776555801 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1776555801 = mId;
        varB4EAC82CA7396A68D541C85D26508E83_1776555801.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1776555801;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.124 -0400", hash_original_method = "CD70F9B024F94168959F7F67ECCC2D46", hash_generated_method = "7BC30821D7251AB6CE5640B4EC930763")
    public ResolveInfo getResolveInfo() {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_1461984509 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1461984509 = mResolveInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1461984509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1461984509;
        // ---------- Original Method ----------
        //return mResolveInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.128 -0400", hash_original_method = "193585B262D581003491A72A585CC7AB", hash_generated_method = "FDA7B7F7A54188BEDF911E9586FB18AF")
    public String getSettingsActivityName() {
        String varB4EAC82CA7396A68D541C85D26508E83_711015350 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_711015350 = mSettingsActivityName;
        varB4EAC82CA7396A68D541C85D26508E83_711015350.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_711015350;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.131 -0400", hash_original_method = "E6B94BCDAE7DB4F02CCDA58E176F7C09", hash_generated_method = "8803C1FCC908C19CEBB378123C8464FB")
    public boolean getCanRetrieveWindowContent() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_734356769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_734356769;
        // ---------- Original Method ----------
        //return mCanRetrieveWindowContent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.134 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "4ADCFA177F1CCD7352D3E519B32D92D6")
    public String getDescription() {
        String varB4EAC82CA7396A68D541C85D26508E83_297514688 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_297514688 = mDescription;
        varB4EAC82CA7396A68D541C85D26508E83_297514688.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_297514688;
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.136 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "EA903679E4A4CDA21988E6018D7C96D0")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574229752 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574229752;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.147 -0400", hash_original_method = "D1D2BA1A1EB65F368E7D0CDDBF151C6C", hash_generated_method = "245132751A155B09EA1FBF6405106F93")
    public void writeToParcel(Parcel parcel, int flagz) {
        parcel.writeInt(eventTypes);
        parcel.writeStringArray(packageNames);
        parcel.writeInt(feedbackType);
        parcel.writeLong(notificationTimeout);
        parcel.writeInt(flags);
        parcel.writeString(mId);
        parcel.writeParcelable(mResolveInfo, 0);
        parcel.writeString(mSettingsActivityName);
        parcel.writeInt(mCanRetrieveWindowContent ? 1 : 0);
        parcel.writeString(mDescription);
        addTaint(parcel.getTaint());
        addTaint(flagz);
        // ---------- Original Method ----------
        //parcel.writeInt(eventTypes);
        //parcel.writeStringArray(packageNames);
        //parcel.writeInt(feedbackType);
        //parcel.writeLong(notificationTimeout);
        //parcel.writeInt(flags);
        //parcel.writeString(mId);
        //parcel.writeParcelable(mResolveInfo, 0);
        //parcel.writeString(mSettingsActivityName);
        //parcel.writeInt(mCanRetrieveWindowContent ? 1 : 0);
        //parcel.writeString(mDescription);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.155 -0400", hash_original_method = "7D575AC4AF313C6A4D2D5091D77147E2", hash_generated_method = "A72BDE444FE7201E107DC7271F0D928A")
    private void initFromParcel(Parcel parcel) {
        eventTypes = parcel.readInt();
        packageNames = parcel.readStringArray();
        feedbackType = parcel.readInt();
        notificationTimeout = parcel.readLong();
        flags = parcel.readInt();
        mId = parcel.readString();
        mResolveInfo = parcel.readParcelable(null);
        mSettingsActivityName = parcel.readString();
        mCanRetrieveWindowContent = (parcel.readInt() == 1);
        mDescription = parcel.readString();
        // ---------- Original Method ----------
        //eventTypes = parcel.readInt();
        //packageNames = parcel.readStringArray();
        //feedbackType = parcel.readInt();
        //notificationTimeout = parcel.readLong();
        //flags = parcel.readInt();
        //mId = parcel.readString();
        //mResolveInfo = parcel.readParcelable(null);
        //mSettingsActivityName = parcel.readString();
        //mCanRetrieveWindowContent = (parcel.readInt() == 1);
        //mDescription = parcel.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.180 -0400", hash_original_method = "854D12839280F599645F8CCCA5C3093D", hash_generated_method = "4A4597A367FEB725B4B1FC1A0AEB6CD9")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2008600812 = null; //Variable for return #1
        StringBuilder stringBuilder = new StringBuilder();
        appendEventTypes(stringBuilder, eventTypes);
        stringBuilder.append(", ");
        appendPackageNames(stringBuilder, packageNames);
        stringBuilder.append(", ");
        appendFeedbackTypes(stringBuilder, feedbackType);
        stringBuilder.append(", ");
        stringBuilder.append("notificationTimeout: ").append(notificationTimeout);
        stringBuilder.append(", ");
        appendFlags(stringBuilder, flags);
        stringBuilder.append(", ");
        stringBuilder.append("id: ").append(mId);
        stringBuilder.append(", ");
        stringBuilder.append("resolveInfo: ").append(mResolveInfo);
        stringBuilder.append(", ");
        stringBuilder.append("settingsActivityName: ").append(mSettingsActivityName);
        stringBuilder.append(", ");
        stringBuilder.append("retrieveScreenContent: ").append(mCanRetrieveWindowContent);
        varB4EAC82CA7396A68D541C85D26508E83_2008600812 = stringBuilder.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2008600812.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2008600812;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static void appendFeedbackTypes(StringBuilder stringBuilder, int feedbackTypes) {
        stringBuilder.append("feedbackTypes:");
        stringBuilder.append("[");
        while (feedbackTypes != 0) {
            final int feedbackTypeBit = (1 << Integer.numberOfTrailingZeros(feedbackTypes));
            stringBuilder.append(feedbackTypeToString(feedbackTypeBit));
            feedbackTypes &= ~feedbackTypeBit;
            if (feedbackTypes != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
    }

    
    private static void appendPackageNames(StringBuilder stringBuilder, String[] packageNames) {
        stringBuilder.append("packageNames:");
        stringBuilder.append("[");
        if (packageNames != null) {
            final int packageNameCount = packageNames.length;
            for (int i = 0; i < packageNameCount; i++) {
                stringBuilder.append(packageNames[i]);
                if (i < packageNameCount - 1) {
                    stringBuilder.append(", ");
                }
            }
        }
        stringBuilder.append("]");
    }

    
    private static void appendEventTypes(StringBuilder stringBuilder, int eventTypes) {
        stringBuilder.append("eventTypes:");
        stringBuilder.append("[");
        while (eventTypes != 0) {
            final int eventTypeBit = (1 << Integer.numberOfTrailingZeros(eventTypes));
            stringBuilder.append(AccessibilityEvent.eventTypeToString(eventTypeBit));
            eventTypes &= ~eventTypeBit;
            if (eventTypes != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
    }

    
    private static void appendFlags(StringBuilder stringBuilder, int flags) {
        stringBuilder.append("flags:");
        stringBuilder.append("[");
        while (flags != 0) {
            final int flagBit = (1 << Integer.numberOfTrailingZeros(flags));
            stringBuilder.append(flagToString(flagBit));
            flags &= ~flagBit;
            if (flags != 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
    }

    
    public static String feedbackTypeToString(int feedbackType) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        while (feedbackType > 0) {
            final int feedbackTypeFlag = 1 << Integer.numberOfTrailingZeros(feedbackType);
            feedbackType &= ~feedbackTypeFlag;
            if (builder.length() > 1) {
                builder.append(", ");
            }
            switch (feedbackTypeFlag) {
                case FEEDBACK_AUDIBLE:
                    builder.append("FEEDBACK_AUDIBLE");
                    break;
                case FEEDBACK_HAPTIC:
                    builder.append("FEEDBACK_HAPTIC");
                    break;
                case FEEDBACK_GENERIC:
                    builder.append("FEEDBACK_GENERIC");
                    break;
                case FEEDBACK_SPOKEN:
                    builder.append("FEEDBACK_SPOKEN");
                    break;
                case FEEDBACK_VISUAL:
                    builder.append("FEEDBACK_VISUAL");
                    break;
            }
        }
        builder.append("]");
        return builder.toString();
    }

    
    public static String flagToString(int flag) {
        switch (flag) {
            case DEFAULT:
                return "DEFAULT";
            default:
                return null;
        }
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.202 -0400", hash_original_field = "5AD75209E87571A06A60F516C6D84721", hash_generated_field = "2C523776EC0C9005124059FD690CA3B4")

    private static final String TAG_ACCESSIBILITY_SERVICE = "accessibility-service";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.203 -0400", hash_original_field = "95BEA6CF6F955CE20115C3FE6D13B2A4", hash_generated_field = "71D96296190DC21E199DC14E475F746B")

    public static final int FEEDBACK_SPOKEN = 0x0000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.204 -0400", hash_original_field = "10271180B4879DACBBA3846E757B2DDA", hash_generated_field = "6D2D98BDDD1C2B6F757615BD3595D906")

    public static final int FEEDBACK_HAPTIC =  0x0000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.204 -0400", hash_original_field = "C76A63F61B3624BB5D22BE30D7F4C2E7", hash_generated_field = "6ADCA380195B52253A35EB0B375D1268")

    public static final int FEEDBACK_AUDIBLE = 0x0000004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.205 -0400", hash_original_field = "A8E17247CD6512F5A34581124FAB926D", hash_generated_field = "E92CD3AA57C6E0F9809E0BE28DA1C8D0")

    public static final int FEEDBACK_VISUAL = 0x0000008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.205 -0400", hash_original_field = "2F04AF42C7F881663D0068363021B2D4", hash_generated_field = "8258584ABD8E9E22B1F9F183B20BE2BC")

    public static final int FEEDBACK_GENERIC = 0x0000010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.206 -0400", hash_original_field = "DB5DB0B17BB92986AF9DB12CA7B96FA8", hash_generated_field = "F30739AC04BDBB3384FC429FE4C84EAD")

    public static final int FEEDBACK_ALL_MASK = 0xFFFFFFFF;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.206 -0400", hash_original_field = "0DE7A7646BF363996FBCDA8601C4B6C0", hash_generated_field = "D861C34854518E1545D3D8722C8CAD47")

    public static final int DEFAULT = 0x0000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:12:54.207 -0400", hash_original_field = "5E2AFB32F3A5C2A0FFD7DBA1DD373F44", hash_generated_field = "064E407C79FF2820562F6591958C9DF1")

    public static final Parcelable.Creator<AccessibilityServiceInfo> CREATOR =
            new Parcelable.Creator<AccessibilityServiceInfo>() {
        public AccessibilityServiceInfo createFromParcel(Parcel parcel) {
            AccessibilityServiceInfo info = new AccessibilityServiceInfo();
            info.initFromParcel(parcel);
            return info;
        }

        public AccessibilityServiceInfo[] newArray(int size) {
            return new AccessibilityServiceInfo[size];
        }
    };
    // orphaned legacy method
    public AccessibilityServiceInfo createFromParcel(Parcel parcel) {
            AccessibilityServiceInfo info = new AccessibilityServiceInfo();
            info.initFromParcel(parcel);
            return info;
        }
    
    // orphaned legacy method
    public AccessibilityServiceInfo[] newArray(int size) {
            return new AccessibilityServiceInfo[size];
        }
    
}

