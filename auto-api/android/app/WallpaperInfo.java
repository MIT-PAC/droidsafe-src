package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.wallpaper.WallpaperService;
import android.util.AttributeSet;
import android.util.Printer;
import android.util.Xml;
import java.io.IOException;

public final class WallpaperInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.716 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6778D731BF0BE2E5E9F46404EEE44664")

    ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.716 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "1E356AACEE2D50E0C905EA0627229FF1")

    String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.717 -0400", hash_original_field = "4554908A8E26081711E37F2891765BE1", hash_generated_field = "C308135F64EE76FAD8A4F39458F20392")

    int mThumbnailResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.718 -0400", hash_original_field = "8EBCDAD2B63FBADDF3471AEE8D1290BF", hash_generated_field = "0691CCFFB273CFC14946667627C5AD49")

    int mAuthorResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.719 -0400", hash_original_field = "50344039A2139E68EBB953B2C832814A", hash_generated_field = "4746EA78955ECA6177E056F9EE2DC4A6")

    int mDescriptionResource;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.758 -0400", hash_original_method = "74057F7C8E144B72C39BB7F86C2AB292", hash_generated_method = "9AC593D1B4E0E9568BA07DA68CFAF448")
    public  WallpaperInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        mService = service;
        ServiceInfo si;
        si = service.serviceInfo;
        PackageManager pm;
        pm = context.getPackageManager();
        String settingsActivityComponent;
        settingsActivityComponent = null;
        int thumbnailRes;
        thumbnailRes = -1;
        int authorRes;
        authorRes = -1;
        int descriptionRes;
        descriptionRes = -1;
        XmlResourceParser parser;
        parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, WallpaperService.SERVICE_META_DATA);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("No "
                        + WallpaperService.SERVICE_META_DATA + " meta-data");
            } //End block
            Resources res;
            res = pm.getResourcesForApplication(si.applicationInfo);
            AttributeSet attrs;
            attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_1653196539 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean var1A485311BBD4557C4268D292EA798D60_254528142 = (!"wallpaper".equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Meta-data does not start with wallpaper tag");
                } //End block
            } //End collapsed parenthetic
            TypedArray sa;
            sa = res.obtainAttributes(attrs,
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
        } //End block
        catch (NameNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        mSettingsActivityName = settingsActivityComponent;
        mThumbnailResource = thumbnailRes;
        mAuthorResource = authorRes;
        mDescriptionResource = descriptionRes;
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.759 -0400", hash_original_method = "C0E8BFC94627855CBFADB81460DD6D49", hash_generated_method = "440597EE814EC8A35B340ADB80FE34F7")
      WallpaperInfo(Parcel source) {
        mSettingsActivityName = source.readString();
        mThumbnailResource = source.readInt();
        mAuthorResource = source.readInt();
        mDescriptionResource = source.readInt();
        mService = ResolveInfo.CREATOR.createFromParcel(source);
        // ---------- Original Method ----------
        //mSettingsActivityName = source.readString();
        //mThumbnailResource = source.readInt();
        //mAuthorResource = source.readInt();
        //mDescriptionResource = source.readInt();
        //mService = ResolveInfo.CREATOR.createFromParcel(source);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.790 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "62B5972BF07405A68BCCA86310E427BB")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1828309631 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1828309631 = mService.serviceInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_1828309631.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1828309631;
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.798 -0400", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "10E589877C2293D3BB889759BFCBD3AF")
    public String getServiceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1440002653 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1440002653 = mService.serviceInfo.name;
        varB4EAC82CA7396A68D541C85D26508E83_1440002653.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1440002653;
        // ---------- Original Method ----------
        //return mService.serviceInfo.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.805 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "485C735BD6B976F186DA0EB1BE3D6F9C")
    public ServiceInfo getServiceInfo() {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_1261779792 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1261779792 = mService.serviceInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1261779792.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1261779792;
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.840 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "81DA3F96054B9DA6482E12BF21922B6A")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_568710861 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_568710861 = new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_568710861.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_568710861;
        // ---------- Original Method ----------
        //return new ComponentName(mService.serviceInfo.packageName,
                //mService.serviceInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.842 -0400", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "0AF8A9E802CC81A2A116F02056307742")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1998818458 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1998818458 = mService.loadLabel(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1998818458.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1998818458;
        // ---------- Original Method ----------
        //return mService.loadLabel(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.860 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "9BA0B996501E8B7EF04181F76803AB08")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_764835948 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_764835948 = mService.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_764835948.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_764835948;
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:53.862 -0400", hash_original_method = "C26983A19295502D4CFCF4D89E5CA369", hash_generated_method = "DB5229C1A13B331DB03E8E8643D8E301")
    public Drawable loadThumbnail(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_985108898 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1012197815 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_985108898 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1012197815 = pm.getDrawable(mService.serviceInfo.packageName,
                              mThumbnailResource,
                              mService.serviceInfo.applicationInfo);
        addTaint(pm.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_348112736; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_348112736 = varB4EAC82CA7396A68D541C85D26508E83_985108898;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_348112736 = varB4EAC82CA7396A68D541C85D26508E83_1012197815;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_348112736.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_348112736;
        // ---------- Original Method ----------
        //if (mThumbnailResource < 0) return null;
        //return pm.getDrawable(mService.serviceInfo.packageName,
                              //mThumbnailResource,
                              //mService.serviceInfo.applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.022 -0400", hash_original_method = "9EB36950261646858CECEB28CEC974AC", hash_generated_method = "B7AED9512915E2C9878ECA63587E6470")
    public CharSequence loadAuthor(PackageManager pm) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2095458665 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException();
        String packageName;
        packageName = mService.resolvePackageName;
        ApplicationInfo applicationInfo;
        applicationInfo = null;
        {
            packageName = mService.serviceInfo.packageName;
            applicationInfo = mService.serviceInfo.applicationInfo;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2095458665 = pm.getText(packageName, mAuthorResource, applicationInfo);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2095458665.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2095458665;
        // ---------- Original Method ----------
        //if (mAuthorResource <= 0) throw new NotFoundException();
        //String packageName = mService.resolvePackageName;
        //ApplicationInfo applicationInfo = null;
        //if (packageName == null) {
            //packageName = mService.serviceInfo.packageName;
            //applicationInfo = mService.serviceInfo.applicationInfo;
        //}
        //return pm.getText(packageName, mAuthorResource, applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.043 -0400", hash_original_method = "ECA3C93288FC3A8841FE238CFCF9AD1A", hash_generated_method = "755546E59092403F2D3E3750024A3F2A")
    public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_914103617 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1143016477 = null; //Variable for return #2
        String packageName;
        packageName = mService.resolvePackageName;
        ApplicationInfo applicationInfo;
        applicationInfo = null;
        {
            packageName = mService.serviceInfo.packageName;
            applicationInfo = mService.serviceInfo.applicationInfo;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_914103617 = pm.getText(packageName, mService.serviceInfo.descriptionRes,
                    applicationInfo);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException();
        varB4EAC82CA7396A68D541C85D26508E83_1143016477 = pm.getText(packageName, mDescriptionResource,
                mService.serviceInfo.applicationInfo);
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_180367234; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_180367234 = varB4EAC82CA7396A68D541C85D26508E83_914103617;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_180367234 = varB4EAC82CA7396A68D541C85D26508E83_1143016477;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_180367234.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_180367234;
        // ---------- Original Method ----------
        //String packageName = mService.resolvePackageName;
        //ApplicationInfo applicationInfo = null;
        //if (packageName == null) {
            //packageName = mService.serviceInfo.packageName;
            //applicationInfo = mService.serviceInfo.applicationInfo;
        //}
        //if (mService.serviceInfo.descriptionRes != 0) {
            //return pm.getText(packageName, mService.serviceInfo.descriptionRes,
                    //applicationInfo);
        //}
        //if (mDescriptionResource <= 0) throw new NotFoundException();
        //return pm.getText(packageName, mDescriptionResource,
                //mService.serviceInfo.applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.048 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "0399D336ED6B66799B77AC3A723A2B6A")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_272138762 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_272138762 = mSettingsActivityName;
        varB4EAC82CA7396A68D541C85D26508E83_272138762.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_272138762;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.060 -0400", hash_original_method = "01A70486818EE80E3925B6A989FED93F", hash_generated_method = "D837342F7135DA886DBDD9FAEB55B9D5")
    public void dump(Printer pw, String prefix) {
        pw.println(prefix + "Service:");
        mService.dump(pw, prefix + "  ");
        pw.println(prefix + "mSettingsActivityName=" + mSettingsActivityName);
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //pw.println(prefix + "Service:");
        //mService.dump(pw, prefix + "  ");
        //pw.println(prefix + "mSettingsActivityName=" + mSettingsActivityName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.074 -0400", hash_original_method = "01F16DDF22698F82DBFF601E0002CE8F", hash_generated_method = "D16A3DFD8D59A591431CC09681650592")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_381021445 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_381021445 = "WallpaperInfo{" + mService.serviceInfo.name
                + ", settings: "
                + mSettingsActivityName + "}";
        varB4EAC82CA7396A68D541C85D26508E83_381021445.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_381021445;
        // ---------- Original Method ----------
        //return "WallpaperInfo{" + mService.serviceInfo.name
                //+ ", settings: "
                //+ mSettingsActivityName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.075 -0400", hash_original_method = "E04AD845315D2630A943DB9D13064432", hash_generated_method = "50C7F6597A243A7DCA21B5365504DB54")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mSettingsActivityName);
        dest.writeInt(mThumbnailResource);
        dest.writeInt(mAuthorResource);
        dest.writeInt(mDescriptionResource);
        mService.writeToParcel(dest, flags);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeString(mSettingsActivityName);
        //dest.writeInt(mThumbnailResource);
        //dest.writeInt(mAuthorResource);
        //dest.writeInt(mDescriptionResource);
        //mService.writeToParcel(dest, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.088 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "413B24F7F84BB84895C5F4571A8E6709")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782606707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1782606707;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.096 -0400", hash_original_field = "FC9E2C4F1BD44A0CA44485FE9D62FF40", hash_generated_field = "79676732A428E1564E8F4C70B71E56E6")

    static String TAG = "WallpaperInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.097 -0400", hash_original_field = "84A4B5F5E39D6F71F6BCEDFA677A58DF", hash_generated_field = "3E4220CC5B52A5C0AED6D687E5CC83E9")

    public static final Parcelable.Creator<WallpaperInfo> CREATOR = new Parcelable.Creator<WallpaperInfo>() {
        public WallpaperInfo createFromParcel(Parcel source) {
            return new WallpaperInfo(source);
        }

        public WallpaperInfo[] newArray(int size) {
            return new WallpaperInfo[size];
        }
    };
}

