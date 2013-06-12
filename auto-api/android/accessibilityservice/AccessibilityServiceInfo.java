package android.accessibilityservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final String TAG_ACCESSIBILITY_SERVICE = "accessibility-service";
    public static final int FEEDBACK_SPOKEN = 0x0000001;
    public static final int FEEDBACK_HAPTIC =  0x0000002;
    public static final int FEEDBACK_AUDIBLE = 0x0000004;
    public static final int FEEDBACK_VISUAL = 0x0000008;
    public static final int FEEDBACK_GENERIC = 0x0000010;
    public static final int FEEDBACK_ALL_MASK = 0xFFFFFFFF;
    public static final int DEFAULT = 0x0000001;
    public int eventTypes;
    public String[] packageNames;
    public int feedbackType;
    public long notificationTimeout;
    public int flags;
    private String mId;
    private ResolveInfo mResolveInfo;
    private String mSettingsActivityName;
    private boolean mCanRetrieveWindowContent;
    private String mDescription;
    public static final Parcelable.Creator<AccessibilityServiceInfo> CREATOR = new Parcelable.Creator<AccessibilityServiceInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.625 -0400", hash_original_method = "04114293203BBEAA7C56518D0943E789", hash_generated_method = "B504F8640EA5FC77E8DBA06FB0A94F67")
        @DSModeled(DSC.SAFE)
        public AccessibilityServiceInfo createFromParcel(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            AccessibilityServiceInfo info;
            info = new AccessibilityServiceInfo();
            info.initFromParcel(parcel);
            return (AccessibilityServiceInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //AccessibilityServiceInfo info = new AccessibilityServiceInfo();
            //info.initFromParcel(parcel);
            //return info;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.627 -0400", hash_original_method = "3D78A09C155E8CD458CF46AE5A54F7C4", hash_generated_method = "4982F1DE03EBAAED2F5D06821472B582")
        @DSModeled(DSC.SAFE)
        public AccessibilityServiceInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            return (AccessibilityServiceInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AccessibilityServiceInfo[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.628 -0400", hash_original_method = "32AC306673DA52F864FB7CE370FDF901", hash_generated_method = "0BF231E89CB1BB5ED9B4004511E93049")
    @DSModeled(DSC.SAFE)
    public AccessibilityServiceInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.639 -0400", hash_original_method = "D068D99220BF43F7F5E36309EDDC7C96", hash_generated_method = "1EEDB613051E875CB2E24BF2970CCD92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityServiceInfo(ResolveInfo resolveInfo, Context context) throws XmlPullParserException, IOException {
        dsTaint.addTaint(resolveInfo.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        ServiceInfo serviceInfo;
        serviceInfo = resolveInfo.serviceInfo;
        mId = new ComponentName(serviceInfo.packageName, serviceInfo.name).flattenToShortString();
        XmlResourceParser parser;
        parser = null;
        try 
        {
            PackageManager packageManager;
            packageManager = context.getPackageManager();
            parser = serviceInfo.loadXmlMetaData(packageManager,
                    AccessibilityService.SERVICE_META_DATA);
            int type;
            type = 0;
            {
                type = parser.next();
            } //End block
            String nodeName;
            nodeName = parser.getName();
            {
                boolean varEA4A996B829F560398797296F3090D5F_416758697 = (!TAG_ACCESSIBILITY_SERVICE.equals(nodeName));
                {
                	if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException( "Meta-data does not start with"
                        + TAG_ACCESSIBILITY_SERVICE + " tag");
                } //End block
            } //End collapsed parenthetic
            AttributeSet allAttributes;
            allAttributes = Xml.asAttributeSet(parser);
            Resources resources;
            resources = packageManager.getResourcesForApplication(
                    serviceInfo.applicationInfo);
            TypedArray asAttributes;
            asAttributes = resources.obtainAttributes(allAttributes,
                    com.android.internal.R.styleable.AccessibilityService);
            eventTypes = asAttributes.getInt(
                    com.android.internal.R.styleable.AccessibilityService_accessibilityEventTypes,
                    0);
            String packageNamez;
            packageNamez = asAttributes.getString(
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
            throw new XmlPullParserException( "Unable to create context for: "
                    + serviceInfo.packageName);
        } //End block
        finally 
        {
            {
                parser.close();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.643 -0400", hash_original_method = "2C9B75B7F79417EB76D61370935CF9C8", hash_generated_method = "5447A9FFF09D4342BC1489619E9967A6")
    @DSModeled(DSC.SAFE)
    public void updateDynamicallyConfigurableProperties(AccessibilityServiceInfo other) {
        dsTaint.addTaint(other.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.646 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "B95538D66F70EE507A6E952D6FA61E59")
    @DSModeled(DSC.SAFE)
    public String getId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.647 -0400", hash_original_method = "CD70F9B024F94168959F7F67ECCC2D46", hash_generated_method = "1C668EB7D95B29B0C124597D2F8CA84B")
    @DSModeled(DSC.SAFE)
    public ResolveInfo getResolveInfo() {
        return (ResolveInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResolveInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.647 -0400", hash_original_method = "193585B262D581003491A72A585CC7AB", hash_generated_method = "5D21DFA61FAE38A6F4B10C20FA3AD458")
    @DSModeled(DSC.SAFE)
    public String getSettingsActivityName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.648 -0400", hash_original_method = "E6B94BCDAE7DB4F02CCDA58E176F7C09", hash_generated_method = "D4E499ED277C3D5C817747C7547EA8E1")
    @DSModeled(DSC.SAFE)
    public boolean getCanRetrieveWindowContent() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mCanRetrieveWindowContent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.649 -0400", hash_original_method = "177DD147D2F75620FD2B154278EC57FA", hash_generated_method = "AD5DE9BBF158FCF5DC5329F0202539C6")
    @DSModeled(DSC.SAFE)
    public String getDescription() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mDescription;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.649 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.651 -0400", hash_original_method = "D1D2BA1A1EB65F368E7D0CDDBF151C6C", hash_generated_method = "74C415F6B12261A46CF0A72F83AE1829")
    @DSModeled(DSC.SAFE)
    public void writeToParcel(Parcel parcel, int flagz) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flagz);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.654 -0400", hash_original_method = "7D575AC4AF313C6A4D2D5091D77147E2", hash_generated_method = "8CACD2CC3DF0E9BAB08D82A00EF18201")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void initFromParcel(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.657 -0400", hash_original_method = "854D12839280F599645F8CCCA5C3093D", hash_generated_method = "DF6CE204AE73BBEF68370DEEB958D02F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
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
        String var7FAF04B660A183FCAEF2183700DA41DE_1716830473 = (stringBuilder.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.658 -0400", hash_original_method = "CD1EB6EF0A8B00F8CC3A1C44C2784273", hash_generated_method = "FFD56650C98DD483EB919248719D2800")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.659 -0400", hash_original_method = "5383084D29DBC1B20EAFED5DB2C0EA76", hash_generated_method = "B73B4785698EDBD64DB7B34D5C78D318")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.660 -0400", hash_original_method = "1753417F6188163583020B8A4473CCB2", hash_generated_method = "A0184A2E274DB8A88DC34B8A8300139A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.660 -0400", hash_original_method = "FD95D8B216BC160B0D7D30A0BBADC80C", hash_generated_method = "C3F2D4EDE9264638EA6F514FDD9B9838")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.661 -0400", hash_original_method = "27B0429CCEEA0953C7B8CE17A0DD59B7", hash_generated_method = "702B958A0B510AD4FE42B27B242BE90C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:56.662 -0400", hash_original_method = "4CD573AB2EE8978F6B282821B915117F", hash_generated_method = "7EBCFF1E8EF553F057B0B54254D94B71")
    public static String flagToString(int flag) {
        switch (flag) {
            case DEFAULT:
                return "DEFAULT";
            default:
                return null;
        }
    }

    
}


