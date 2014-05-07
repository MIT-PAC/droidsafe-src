package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.wallpaper.WallpaperService;
import android.util.AttributeSet;
import android.util.Printer;
import android.util.Xml;

public final class WallpaperInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.102 -0500", hash_original_field = "889243BDB94A4B7A4467D941107193F3", hash_generated_field = "01792FAFBA46EE705FA5945B423BCDDA")

    static final String TAG = "WallpaperInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.379 -0400", hash_original_field = "84A4B5F5E39D6F71F6BCEDFA677A58DF", hash_generated_field = "3E4220CC5B52A5C0AED6D687E5CC83E9")

    public static final Parcelable.Creator<WallpaperInfo> CREATOR = new Parcelable.Creator<WallpaperInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.152 -0500", hash_original_method = "E0CA03F91A5FF6E3DEA1E1ECC308F7EB", hash_generated_method = "64724678AC7189A0458687F49B340F3D")
        
public WallpaperInfo createFromParcel(Parcel source) {
            return new WallpaperInfo(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.154 -0500", hash_original_method = "B2B9815F42BAA1995A48EC036922067C", hash_generated_method = "0C21E0E8FA009D4925A2C5CF876433C4")
        
public WallpaperInfo[] newArray(int size) {
            return new WallpaperInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.105 -0500", hash_original_field = "6778D731BF0BE2E5E9F46404EEE44664", hash_generated_field = "6778D731BF0BE2E5E9F46404EEE44664")

     ResolveInfo mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.107 -0500", hash_original_field = "1E356AACEE2D50E0C905EA0627229FF1", hash_generated_field = "1E356AACEE2D50E0C905EA0627229FF1")

     String mSettingsActivityName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.109 -0500", hash_original_field = "C308135F64EE76FAD8A4F39458F20392", hash_generated_field = "C308135F64EE76FAD8A4F39458F20392")

     int mThumbnailResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.111 -0500", hash_original_field = "0691CCFFB273CFC14946667627C5AD49", hash_generated_field = "0691CCFFB273CFC14946667627C5AD49")

     int mAuthorResource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.113 -0500", hash_original_field = "4746EA78955ECA6177E056F9EE2DC4A6", hash_generated_field = "4746EA78955ECA6177E056F9EE2DC4A6")

     int mDescriptionResource;

    /**
     * Constructor.
     * 
     * @param context The Context in which we are parsing the wallpaper.
     * @param service The ResolveInfo returned from the package manager about
     * this wallpaper's component.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.116 -0500", hash_original_method = "74057F7C8E144B72C39BB7F86C2AB292", hash_generated_method = "DDA9E765CB130F80E28EB85C38E310AB")
    
public WallpaperInfo(Context context, ResolveInfo service)
            throws XmlPullParserException, IOException {
        mService = service;
        ServiceInfo si = service.serviceInfo;
        
        PackageManager pm = context.getPackageManager();
        String settingsActivityComponent = null;
        int thumbnailRes = -1;
        int authorRes = -1;
        int descriptionRes = -1;
        
        XmlResourceParser parser = null;
        try {
            parser = si.loadXmlMetaData(pm, WallpaperService.SERVICE_META_DATA);
            if (parser == null) {
                throw new XmlPullParserException("No "
                        + WallpaperService.SERVICE_META_DATA + " meta-data");
            }
        
            Resources res = pm.getResourcesForApplication(si.applicationInfo);
            
            AttributeSet attrs = Xml.asAttributeSet(parser);
            
            int type;
            while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG) {
            }
            
            String nodeName = parser.getName();
            if (!"wallpaper".equals(nodeName)) {
                throw new XmlPullParserException(
                        "Meta-data does not start with wallpaper tag");
            }
            
            TypedArray sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.Wallpaper);
            settingsActivityComponent = sa.getString(
                    com.android.internal.R.styleable.Wallpaper_settingsActivity);
            
            thumbnailRes = sa.getResourceId(
                    com.android.internal.R.styleable.Wallpaper_thumbnail,
                    -1);
            authorRes = sa.getResourceId(
                    com.android.internal.R.styleable.Wallpaper_author,
                    -1);
            descriptionRes = sa.getResourceId(
                    com.android.internal.R.styleable.Wallpaper_description,
                    -1);

            sa.recycle();
        } catch (NameNotFoundException e) {
            throw new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
        } finally {
            if (parser != null) parser.close();
        }
        
        mSettingsActivityName = settingsActivityComponent;
        mThumbnailResource = thumbnailRes;
        mAuthorResource = authorRes;
        mDescriptionResource = descriptionRes;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.119 -0500", hash_original_method = "C0E8BFC94627855CBFADB81460DD6D49", hash_generated_method = "C0E8BFC94627855CBFADB81460DD6D49")
    
WallpaperInfo(Parcel source) {
        mSettingsActivityName = source.readString();
        mThumbnailResource = source.readInt();
        mAuthorResource = source.readInt();
        mDescriptionResource = source.readInt();
        mService = ResolveInfo.CREATOR.createFromParcel(source);
    }
    
    /**
     * Return the .apk package that implements this wallpaper.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.121 -0500", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "6994E25AD1E96805A7C2A499125900C0")
    
public String getPackageName() {
        return mService.serviceInfo.packageName;
    }
    
    /**
     * Return the class name of the service component that implements
     * this wallpaper.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.123 -0500", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "41E20EE2BC25C2B6141BF6F906B02B30")
    
public String getServiceName() {
        return mService.serviceInfo.name;
    }

    /**
     * Return the raw information about the Service implementing this
     * wallpaper.  Do not modify the returned object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.125 -0500", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "1E6E8EA06F8EE7CE7231791DBE1C3740")
    
public ServiceInfo getServiceInfo() {
        return mService.serviceInfo;
    }

    /**
     * Return the component of the service that implements this wallpaper.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.127 -0500", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "2B97835D1618C71F40A014490410F857")
    
public ComponentName getComponent() {
        return new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name);
    }
    
    /**
     * Load the user-displayed label for this wallpaper.
     * 
     * @param pm Supply a PackageManager used to load the wallpaper's
     * resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.130 -0500", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "EEB9E79FEAEC952302B9A8639AC3433B")
    
public CharSequence loadLabel(PackageManager pm) {
        return mService.loadLabel(pm);
    }
    
    /**
     * Load the user-displayed icon for this wallpaper.
     * 
     * @param pm Supply a PackageManager used to load the wallpaper's
     * resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.133 -0500", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "510880B85D007E14A841E542571C558E")
    
public Drawable loadIcon(PackageManager pm) {
        return mService.loadIcon(pm);
    }
    
    /**
     * Load the thumbnail image for this wallpaper.
     * 
     * @param pm Supply a PackageManager used to load the wallpaper's
     * resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.135 -0500", hash_original_method = "C26983A19295502D4CFCF4D89E5CA369", hash_generated_method = "620EF765CC501E9F296E5352F3847065")
    
public Drawable loadThumbnail(PackageManager pm) {
        if (mThumbnailResource < 0) return null;

        return pm.getDrawable(mService.serviceInfo.packageName,
                              mThumbnailResource,
                              mService.serviceInfo.applicationInfo);
    }

    /**
     * Return a string indicating the author(s) of this wallpaper.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.137 -0500", hash_original_method = "9EB36950261646858CECEB28CEC974AC", hash_generated_method = "1FD39668FB440D378C7EC134EA86D3F8")
    
public CharSequence loadAuthor(PackageManager pm) throws NotFoundException {
        if (mAuthorResource <= 0) throw new NotFoundException();
        String packageName = mService.resolvePackageName;
        ApplicationInfo applicationInfo = null;
        if (packageName == null) {
            packageName = mService.serviceInfo.packageName;
            applicationInfo = mService.serviceInfo.applicationInfo;
        }
        return pm.getText(packageName, mAuthorResource, applicationInfo);
    }

    /**
     * Return a brief summary of this wallpaper's behavior.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.139 -0500", hash_original_method = "ECA3C93288FC3A8841FE238CFCF9AD1A", hash_generated_method = "97D8855B31C45A83D215E7DC34734208")
    
public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        String packageName = mService.resolvePackageName;
        ApplicationInfo applicationInfo = null;
        if (packageName == null) {
            packageName = mService.serviceInfo.packageName;
            applicationInfo = mService.serviceInfo.applicationInfo;
        }
        if (mService.serviceInfo.descriptionRes != 0) {
            return pm.getText(packageName, mService.serviceInfo.descriptionRes,
                    applicationInfo);
            
        }
        if (mDescriptionResource <= 0) throw new NotFoundException();
        return pm.getText(packageName, mDescriptionResource,
                mService.serviceInfo.applicationInfo);
    }
    
    /**
     * Return the class name of an activity that provides a settings UI for
     * the wallpaper.  You can launch this activity be starting it with
     * an {@link android.content.Intent} whose action is MAIN and with an
     * explicit {@link android.content.ComponentName}
     * composed of {@link #getPackageName} and the class name returned here.
     * 
     * <p>A null will be returned if there is no settings activity associated
     * with the wallpaper.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.141 -0500", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "B6031419836B6E01A163B6457817552A")
    
public String getSettingsActivity() {
        return mSettingsActivityName;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.144 -0500", hash_original_method = "01A70486818EE80E3925B6A989FED93F", hash_generated_method = "DA5A264806DBF48B291050B433A1CA8F")
    
public void dump(Printer pw, String prefix) {
        pw.println(prefix + "Service:");
        mService.dump(pw, prefix + "  ");
        pw.println(prefix + "mSettingsActivityName=" + mSettingsActivityName);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.146 -0500", hash_original_method = "01F16DDF22698F82DBFF601E0002CE8F", hash_generated_method = "66DB4E29EAD0EDE7B818ED2F22ED0573")
    
@Override
    public String toString() {
        return "WallpaperInfo{" + mService.serviceInfo.name
                + ", settings: "
                + mSettingsActivityName + "}";
    }

    /**
     * Used to package this object into a {@link Parcel}.
     * 
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.148 -0500", hash_original_method = "E04AD845315D2630A943DB9D13064432", hash_generated_method = "5A4AC2D12B91C63CA8219D3BA2396E98")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSettingsActivityName);
        dest.writeInt(mThumbnailResource);
        dest.writeInt(mAuthorResource);
        dest.writeInt(mDescriptionResource);
        mService.writeToParcel(dest, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:29.158 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public WallpaperInfo createFromParcel(Parcel source) {
            return new WallpaperInfo(source);
        }
    
    // orphaned legacy method
    public WallpaperInfo[] newArray(int size) {
            return new WallpaperInfo[size];
        }
    
}

