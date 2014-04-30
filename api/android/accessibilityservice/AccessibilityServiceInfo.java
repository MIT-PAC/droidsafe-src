package android.accessibilityservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

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

public class AccessibilityServiceInfo implements Parcelable {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.300 -0500", hash_original_method = "CD1EB6EF0A8B00F8CC3A1C44C2784273", hash_generated_method = "FFD56650C98DD483EB919248719D2800")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.303 -0500", hash_original_method = "5383084D29DBC1B20EAFED5DB2C0EA76", hash_generated_method = "B73B4785698EDBD64DB7B34D5C78D318")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.306 -0500", hash_original_method = "1753417F6188163583020B8A4473CCB2", hash_generated_method = "A0184A2E274DB8A88DC34B8A8300139A")
    
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.309 -0500", hash_original_method = "FD95D8B216BC160B0D7D30A0BBADC80C", hash_generated_method = "C3F2D4EDE9264638EA6F514FDD9B9838")
    
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

    /**
     * Returns the string representation of a feedback type. For example,
     * {@link #FEEDBACK_SPOKEN} is represented by the string FEEDBACK_SPOKEN.
     *
     * @param feedbackType The feedback type.
     * @return The string representation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.312 -0500", hash_original_method = "27B0429CCEEA0953C7B8CE17A0DD59B7", hash_generated_method = "702B958A0B510AD4FE42B27B242BE90C")
    
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

    /**
     * Returns the string representation of a flag. For example,
     * {@link #DEFAULT} is represented by the string DEFAULT.
     *
     * @param flag The flag.
     * @return The string representation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.315 -0500", hash_original_method = "4CD573AB2EE8978F6B282821B915117F", hash_generated_method = "7EBCFF1E8EF553F057B0B54254D94B71")
    
public static String flagToString(int flag) {
        switch (flag) {
            case DEFAULT:
                return "DEFAULT";
            default:
                return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.224 -0500", hash_original_field = "05B74B66B3FB0AC5B2B968C51E6B6893", hash_generated_field = "2C523776EC0C9005124059FD690CA3B4")

    private static final String TAG_ACCESSIBILITY_SERVICE = "accessibility-service";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.227 -0500", hash_original_field = "AB4E0F69BE775299838A5A1574301F95", hash_generated_field = "71D96296190DC21E199DC14E475F746B")

    public static final int FEEDBACK_SPOKEN = 0x0000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.229 -0500", hash_original_field = "E4746DC05FB53E3BE35D6CD8416E2961", hash_generated_field = "6D2D98BDDD1C2B6F757615BD3595D906")

    public static final int FEEDBACK_HAPTIC =  0x0000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.231 -0500", hash_original_field = "55D55C3BC431CC2A3C61BA30F184406B", hash_generated_field = "6ADCA380195B52253A35EB0B375D1268")

    public static final int FEEDBACK_AUDIBLE = 0x0000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.234 -0500", hash_original_field = "CC131DA5AA38935152228064206C51CF", hash_generated_field = "E92CD3AA57C6E0F9809E0BE28DA1C8D0")

    public static final int FEEDBACK_VISUAL = 0x0000008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.237 -0500", hash_original_field = "C6DE87B7ED320867EFF1A289470CD378", hash_generated_field = "8258584ABD8E9E22B1F9F183B20BE2BC")

    public static final int FEEDBACK_GENERIC = 0x0000010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.240 -0500", hash_original_field = "31B80D955EEE0256F9A05F7B5AF3D0EE", hash_generated_field = "F30739AC04BDBB3384FC429FE4C84EAD")

    public static final int FEEDBACK_ALL_MASK = 0xFFFFFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.242 -0500", hash_original_field = "97C88284C7FB7A365D3D8A93DB373C8D", hash_generated_field = "D861C34854518E1545D3D8722C8CAD47")

    public static final int DEFAULT = 0x0000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:11.993 -0400", hash_original_field = "5E2AFB32F3A5C2A0FFD7DBA1DD373F44", hash_generated_field = "064E407C79FF2820562F6591958C9DF1")

    public static final Parcelable.Creator<AccessibilityServiceInfo> CREATOR =
            new Parcelable.Creator<AccessibilityServiceInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.318 -0500", hash_original_method = "04114293203BBEAA7C56518D0943E789", hash_generated_method = "D59A4749F55DD13BC19219836FB14EB5")
        
public AccessibilityServiceInfo createFromParcel(Parcel parcel) {
            AccessibilityServiceInfo info = new AccessibilityServiceInfo();
            info.initFromParcel(parcel);
            return info;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.320 -0500", hash_original_method = "3D78A09C155E8CD458CF46AE5A54F7C4", hash_generated_method = "E0C859426A6309DC8C4666DC7D11D197")
        
public AccessibilityServiceInfo[] newArray(int size) {
            return new AccessibilityServiceInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.245 -0500", hash_original_field = "8AF88127B35DE7DD89834D1EF290A4EB", hash_generated_field = "EEF9A290ACD5C7B733F6B6DEDE8E3A43")

    public int eventTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.247 -0500", hash_original_field = "FC17F07E9B01A509CD94653BCB81C0E1", hash_generated_field = "4498F27AF93559A7532BFFF1A93CBFB9")

    public String[] packageNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.249 -0500", hash_original_field = "54CD1B92714061E877199ECEF357039B", hash_generated_field = "68FE335A39435FE4A5727D74F41FDDD2")

    public int feedbackType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.252 -0500", hash_original_field = "F159496C294624B0DFD9EA05C0A1E02B", hash_generated_field = "F1CBE56C199C9B56F74193D61740D91B")

    public long notificationTimeout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.254 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.256 -0500", hash_original_field = "5AB31FF91690EC0315884BA04F6C543E", hash_generated_field = "34D624C7CD290D72B15AB814BF1BA854")

    private String mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.258 -0500", hash_original_field = "FE81B4A254792E0F53E0C9AF36C8B686", hash_generated_field = "6B33B1DC79BC09883016E8729764237B")

    private ResolveInfo mResolveInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.261 -0500", hash_original_field = "1E356AACEE2D50E0C905EA0627229FF1", hash_generated_field = "3227A556BB8D91CC368DE162089FC968")

    private String mSettingsActivityName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.264 -0500", hash_original_field = "E5326273B2A37FC5F858C289356E9724", hash_generated_field = "D82CCF51637435103547C999EFEF8AB3")

    private boolean mCanRetrieveWindowContent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.266 -0500", hash_original_field = "6FC53B81BF2A7EC21138D42F363D7B9A", hash_generated_field = "D58E2E2E369193E8B6C54168B334B477")

    private String mDescription;

    /**
     * Creates a new instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.269 -0500", hash_original_method = "32AC306673DA52F864FB7CE370FDF901", hash_generated_method = "175458E7CDA47AE2731389BF733FFE33")
    
public AccessibilityServiceInfo() {
        /* do nothing */
    }

    /**
     * Creates a new instance.
     *
     * @param resolveInfo The service resolve info.
     * @param context Context for accessing resources.
     * @throws XmlPullParserException If a XML parsing error occurs.
     * @throws IOException If a XML parsing error occurs.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.273 -0500", hash_original_method = "D068D99220BF43F7F5E36309EDDC7C96", hash_generated_method = "84A22973CB9A6039FAE0D3EAACCE525D")
    
public AccessibilityServiceInfo(ResolveInfo resolveInfo, Context context)
            throws XmlPullParserException, IOException {
        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
        mId = new ComponentName(serviceInfo.packageName, serviceInfo.name).flattenToShortString();
        mResolveInfo = resolveInfo;

        XmlResourceParser parser = null;

        try {
            PackageManager packageManager = context.getPackageManager();
            parser = serviceInfo.loadXmlMetaData(packageManager,
                    AccessibilityService.SERVICE_META_DATA);
            if (parser == null) {
                return;
            }

            int type = 0;
            while (type != XmlPullParser.END_DOCUMENT && type != XmlPullParser.START_TAG) {
                type = parser.next();
            }

            String nodeName = parser.getName();
            if (!TAG_ACCESSIBILITY_SERVICE.equals(nodeName)) {
                throw new XmlPullParserException( "Meta-data does not start with"
                        + TAG_ACCESSIBILITY_SERVICE + " tag");
            }

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
            if (packageNamez != null) {
                packageNames = packageNamez.split("(\\s)*,(\\s)*");
            }
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
        } catch (NameNotFoundException e) {
            throw new XmlPullParserException( "Unable to create context for: "
                    + serviceInfo.packageName);
        } finally {
            if (parser != null) {
                parser.close();
            }
        }
    }

    /**
     * Updates the properties that an AccessibilitySerivice can change dynamically.
     *
     * @param other The info from which to update the properties.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.276 -0500", hash_original_method = "2C9B75B7F79417EB76D61370935CF9C8", hash_generated_method = "3AE19D79D78EAE178365F31896C94E06")
    
public void updateDynamicallyConfigurableProperties(AccessibilityServiceInfo other) {
        eventTypes = other.eventTypes;
        packageNames = other.packageNames;
        feedbackType = other.feedbackType;
        notificationTimeout = other.notificationTimeout;
        flags = other.flags;
    }

    /**
     * The accessibility service id.
     * <p>
     *   <strong>Generated by the system.</strong>
     * </p>
     * @return The id.
     */
    @DSComment("Describes Acessibility Service")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.278 -0500", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "8F9FC8944DF69B66CB8D7A8B6ABB6416")
    
public String getId() {
        return mId;
    }

    /**
     * The service {@link ResolveInfo}.
     * <p>
     *   <strong>Generated by the system.</strong>
     * </p>
     * @return The info.
     */
    @DSComment("Describes Acessibility Service")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.280 -0500", hash_original_method = "CD70F9B024F94168959F7F67ECCC2D46", hash_generated_method = "C9D0D45F7969AB2459018B24DB336946")
    
public ResolveInfo getResolveInfo() {
        return mResolveInfo;
    }

    /**
     * The settings activity name.
     * <p>
     *    <strong>Statically set from
     *    {@link AccessibilityService#SERVICE_META_DATA meta-data}.</strong>
     * </p>
     * @return The settings activity name.
     */
    @DSComment("Describes Acessibility Service")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.283 -0500", hash_original_method = "193585B262D581003491A72A585CC7AB", hash_generated_method = "4412660C2BE872F360536E29B777FE85")
    
public String getSettingsActivityName() {
        return mSettingsActivityName;
    }

    /**
     * Whether this service can retrieve the current window's content.
     * <p>
     *    <strong>Statically set from
     *    {@link AccessibilityService#SERVICE_META_DATA meta-data}.</strong>
     * </p>
     * @return True window content can be retrieved.
     */
    @DSComment("Describes Acessibility Service")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.285 -0500", hash_original_method = "E6B94BCDAE7DB4F02CCDA58E176F7C09", hash_generated_method = "97B8477AF04EA26C388EF92B9525C33D")
    
public boolean getCanRetrieveWindowContent() {
        return mCanRetrieveWindowContent;
    }
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    public int getCapabilities () {
        return getTaintInt();
    }
    /**
     * Description of the accessibility service.
     * <p>
     *    <strong>Statically set from
     *    {@link AccessibilityService#SERVICE_META_DATA meta-data}.</strong>
     * </p>
     * @return The description.
     */
    @DSComment("Describes Acessibility Service")
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.288 -0500", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "C24A704C1B7693A32CE618B690D2C768")
    
public String getDescription() {
        return mDescription;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.290 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.293 -0500", hash_original_method = "D1D2BA1A1EB65F368E7D0CDDBF151C6C", hash_generated_method = "49773263E1C7D327CC5E745C54DA7225")
    
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
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.295 -0500", hash_original_method = "7D575AC4AF313C6A4D2D5091D77147E2", hash_generated_method = "E2CB992A247CB44F8E3FC48DDF1A28ED")
    
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
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:00.298 -0500", hash_original_method = "854D12839280F599645F8CCCA5C3093D", hash_generated_method = "A434ECC6E020B302AEE5A9D42BFC29B2")
    
@Override
    public String toString() {
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
        return stringBuilder.toString();
    }
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

