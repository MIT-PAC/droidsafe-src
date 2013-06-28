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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.642 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6778D731BF0BE2E5E9F46404EEE44664")

    ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.642 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "1E356AACEE2D50E0C905EA0627229FF1")

    String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.642 -0400", hash_original_field = "4554908A8E26081711E37F2891765BE1", hash_generated_field = "C308135F64EE76FAD8A4F39458F20392")

    int mThumbnailResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.642 -0400", hash_original_field = "8EBCDAD2B63FBADDF3471AEE8D1290BF", hash_generated_field = "0691CCFFB273CFC14946667627C5AD49")

    int mAuthorResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.642 -0400", hash_original_field = "50344039A2139E68EBB953B2C832814A", hash_generated_field = "4746EA78955ECA6177E056F9EE2DC4A6")

    int mDescriptionResource;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.644 -0400", hash_original_method = "74057F7C8E144B72C39BB7F86C2AB292", hash_generated_method = "DBC19D80D9AD7503D57E42C7F484F788")
    public  WallpaperInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        mService = service;
        ServiceInfo si = service.serviceInfo;
        PackageManager pm = context.getPackageManager();
        String settingsActivityComponent = null;
        int thumbnailRes = -1;
        int authorRes = -1;
        int descriptionRes = -1;
        XmlResourceParser parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, WallpaperService.SERVICE_META_DATA);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("No "
                        + WallpaperService.SERVICE_META_DATA + " meta-data");
            } //End block
            Resources res = pm.getResourcesForApplication(si.applicationInfo);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_667768221 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName = parser.getName();
            {
                boolean var1A485311BBD4557C4268D292EA798D60_600213287 = (!"wallpaper".equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Meta-data does not start with wallpaper tag");
                } //End block
            } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.645 -0400", hash_original_method = "C0E8BFC94627855CBFADB81460DD6D49", hash_generated_method = "440597EE814EC8A35B340ADB80FE34F7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.647 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "B52407B2C5865734055A78B3EE9A242E")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1308905164 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1308905164 = mService.serviceInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_1308905164.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1308905164;
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.649 -0400", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "6952DA0C37AD643FD76D146596A8D70E")
    public String getServiceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_88135324 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_88135324 = mService.serviceInfo.name;
        varB4EAC82CA7396A68D541C85D26508E83_88135324.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_88135324;
        // ---------- Original Method ----------
        //return mService.serviceInfo.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.650 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "E75B6B1BDEBC2079BAA4F0E601DC142A")
    public ServiceInfo getServiceInfo() {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_1006189050 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1006189050 = mService.serviceInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1006189050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1006189050;
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.651 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "0F9B06F45F0ED81756E4BFA6F7304423")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1660428541 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1660428541 = new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_1660428541.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1660428541;
        // ---------- Original Method ----------
        //return new ComponentName(mService.serviceInfo.packageName,
                //mService.serviceInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.652 -0400", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "821F913B4ED25AAC76F514F1E6D58C85")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1573848517 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1573848517 = mService.loadLabel(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1573848517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1573848517;
        // ---------- Original Method ----------
        //return mService.loadLabel(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.654 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "1FBA5C9A5F2E3814F756BE88C6F017F0")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_809570845 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_809570845 = mService.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_809570845.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_809570845;
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.655 -0400", hash_original_method = "C26983A19295502D4CFCF4D89E5CA369", hash_generated_method = "5F9C4CB840ACF18B48CD3F7459A24E3E")
    public Drawable loadThumbnail(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_214765856 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1557471045 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_214765856 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1557471045 = pm.getDrawable(mService.serviceInfo.packageName,
                              mThumbnailResource,
                              mService.serviceInfo.applicationInfo);
        addTaint(pm.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_101717774; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_101717774 = varB4EAC82CA7396A68D541C85D26508E83_214765856;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_101717774 = varB4EAC82CA7396A68D541C85D26508E83_1557471045;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_101717774.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_101717774;
        // ---------- Original Method ----------
        //if (mThumbnailResource < 0) return null;
        //return pm.getDrawable(mService.serviceInfo.packageName,
                              //mThumbnailResource,
                              //mService.serviceInfo.applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.659 -0400", hash_original_method = "9EB36950261646858CECEB28CEC974AC", hash_generated_method = "882C521264B67E2FDC199F5E192086A0")
    public CharSequence loadAuthor(PackageManager pm) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1785986569 = null; //Variable for return #1
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException();
        String packageName = mService.resolvePackageName;
        ApplicationInfo applicationInfo = null;
        {
            packageName = mService.serviceInfo.packageName;
            applicationInfo = mService.serviceInfo.applicationInfo;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1785986569 = pm.getText(packageName, mAuthorResource, applicationInfo);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1785986569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1785986569;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.662 -0400", hash_original_method = "ECA3C93288FC3A8841FE238CFCF9AD1A", hash_generated_method = "E052F81B59850FB68396374C7455DD5E")
    public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_137720809 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1528884593 = null; //Variable for return #2
        String packageName = mService.resolvePackageName;
        ApplicationInfo applicationInfo = null;
        {
            packageName = mService.serviceInfo.packageName;
            applicationInfo = mService.serviceInfo.applicationInfo;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_137720809 = pm.getText(packageName, mService.serviceInfo.descriptionRes,
                    applicationInfo);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException();
        varB4EAC82CA7396A68D541C85D26508E83_1528884593 = pm.getText(packageName, mDescriptionResource,
                mService.serviceInfo.applicationInfo);
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1445398753; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1445398753 = varB4EAC82CA7396A68D541C85D26508E83_137720809;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1445398753 = varB4EAC82CA7396A68D541C85D26508E83_1528884593;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1445398753.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1445398753;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.664 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "1B447F66B2920AAAA7F79519A24BADE6")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_280989164 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_280989164 = mSettingsActivityName;
        varB4EAC82CA7396A68D541C85D26508E83_280989164.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_280989164;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.665 -0400", hash_original_method = "01A70486818EE80E3925B6A989FED93F", hash_generated_method = "D837342F7135DA886DBDD9FAEB55B9D5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.667 -0400", hash_original_method = "01F16DDF22698F82DBFF601E0002CE8F", hash_generated_method = "AF7C1ECC97F1699B6F7453462FEC1E8E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1630526235 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1630526235 = "WallpaperInfo{" + mService.serviceInfo.name
                + ", settings: "
                + mSettingsActivityName + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1630526235.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1630526235;
        // ---------- Original Method ----------
        //return "WallpaperInfo{" + mService.serviceInfo.name
                //+ ", settings: "
                //+ mSettingsActivityName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.670 -0400", hash_original_method = "E04AD845315D2630A943DB9D13064432", hash_generated_method = "50C7F6597A243A7DCA21B5365504DB54")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.671 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D1AE93A9088C53C09A0C85C637E8C6FA")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_534232932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_534232932;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.671 -0400", hash_original_field = "FC9E2C4F1BD44A0CA44485FE9D62FF40", hash_generated_field = "01792FAFBA46EE705FA5945B423BCDDA")

    static final String TAG = "WallpaperInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.671 -0400", hash_original_field = "84A4B5F5E39D6F71F6BCEDFA677A58DF", hash_generated_field = "3E4220CC5B52A5C0AED6D687E5CC83E9")

    public static final Parcelable.Creator<WallpaperInfo> CREATOR = new Parcelable.Creator<WallpaperInfo>() {
        public WallpaperInfo createFromParcel(Parcel source) {
            return new WallpaperInfo(source);
        }

        public WallpaperInfo[] newArray(int size) {
            return new WallpaperInfo[size];
        }
    };
    // orphaned legacy method
    public WallpaperInfo createFromParcel(Parcel source) {
            return new WallpaperInfo(source);
        }
    
    // orphaned legacy method
    public WallpaperInfo[] newArray(int size) {
            return new WallpaperInfo[size];
        }
    
}

