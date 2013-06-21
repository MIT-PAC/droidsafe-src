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
    ResolveInfo mService;
    String mSettingsActivityName;
    int mThumbnailResource;
    int mAuthorResource;
    int mDescriptionResource;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.102 -0400", hash_original_method = "74057F7C8E144B72C39BB7F86C2AB292", hash_generated_method = "052E6707B66DE0E25F0B3CCADB1E1364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WallpaperInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(context.dsTaint);
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
                boolean var995057C222283DCE9E465AE35974357A_869749861 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean var1A485311BBD4557C4268D292EA798D60_1819793296 = (!"wallpaper".equals(nodeName));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.103 -0400", hash_original_method = "C0E8BFC94627855CBFADB81460DD6D49", hash_generated_method = "5C650029F1ECC23927B8934D65BC844A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     WallpaperInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.103 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "63877C04759CD6A29BB5A9D09769BD95")
    @DSModeled(DSC.SAFE)
    public String getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.104 -0400", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "AFF3C5622D211F1659EB1D0A2141C7AB")
    @DSModeled(DSC.SAFE)
    public String getServiceName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mService.serviceInfo.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.104 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "9C67A090AD36EBAC69BD5168FBDFB473")
    @DSModeled(DSC.SAFE)
    public ServiceInfo getServiceInfo() {
        return (ServiceInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.105 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "2188AED21819A21139E13D755B9FE41C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName getComponent() {
        ComponentName var36812892F2F610F061B81BA39B626ED6_445559203 = (new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name));
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ComponentName(mService.serviceInfo.packageName,
                //mService.serviceInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.105 -0400", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "4A5BBDC9FFD04641DD118D775FB9AE77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadLabel(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        CharSequence var37856CDD70F50ABB3C82E07A4EC679C0_775817210 = (mService.loadLabel(pm));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mService.loadLabel(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.105 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "978F8F7661CF8A4E546866F034E0852A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable loadIcon(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        Drawable var8EEC18B2BAAC36DADFAD2C3B55E7EE45_1078261085 = (mService.loadIcon(pm));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.106 -0400", hash_original_method = "C26983A19295502D4CFCF4D89E5CA369", hash_generated_method = "3D28E2EA1FC3B5F434DC2FF05289A7AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable loadThumbnail(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        Drawable varEFEB04D40443F6B5BBB2B59D7CE31154_1130984538 = (pm.getDrawable(mService.serviceInfo.packageName,
                              mThumbnailResource,
                              mService.serviceInfo.applicationInfo));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mThumbnailResource < 0) return null;
        //return pm.getDrawable(mService.serviceInfo.packageName,
                              //mThumbnailResource,
                              //mService.serviceInfo.applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.106 -0400", hash_original_method = "9EB36950261646858CECEB28CEC974AC", hash_generated_method = "315D7B31F83EEEB33474AD4900AEB18F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadAuthor(PackageManager pm) throws NotFoundException {
        dsTaint.addTaint(pm.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException();
        String packageName;
        packageName = mService.resolvePackageName;
        ApplicationInfo applicationInfo;
        applicationInfo = null;
        {
            packageName = mService.serviceInfo.packageName;
            applicationInfo = mService.serviceInfo.applicationInfo;
        } //End block
        CharSequence var0DF353B6631EC85D484C0DB4210A67EF_1061037797 = (pm.getText(packageName, mAuthorResource, applicationInfo));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.107 -0400", hash_original_method = "ECA3C93288FC3A8841FE238CFCF9AD1A", hash_generated_method = "92E1196102DF357B61B4537EA1652E39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        dsTaint.addTaint(pm.dsTaint);
        String packageName;
        packageName = mService.resolvePackageName;
        ApplicationInfo applicationInfo;
        applicationInfo = null;
        {
            packageName = mService.serviceInfo.packageName;
            applicationInfo = mService.serviceInfo.applicationInfo;
        } //End block
        {
            CharSequence varE99A149A4D09E68099E99A96D5317342_783797780 = (pm.getText(packageName, mService.serviceInfo.descriptionRes,
                    applicationInfo));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException();
        CharSequence var24F6E6C6AB00139038D7D316F2849C4E_256125328 = (pm.getText(packageName, mDescriptionResource,
                mService.serviceInfo.applicationInfo));
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.107 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "A8B888BFD8A46E2CDEC1514677D36FA3")
    @DSModeled(DSC.SAFE)
    public String getSettingsActivity() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.108 -0400", hash_original_method = "01A70486818EE80E3925B6A989FED93F", hash_generated_method = "390E64507D855F262C91CBF828425501")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        pw.println(prefix + "Service:");
        mService.dump(pw, prefix + "  ");
        pw.println(prefix + "mSettingsActivityName=" + mSettingsActivityName);
        // ---------- Original Method ----------
        //pw.println(prefix + "Service:");
        //mService.dump(pw, prefix + "  ");
        //pw.println(prefix + "mSettingsActivityName=" + mSettingsActivityName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.108 -0400", hash_original_method = "01F16DDF22698F82DBFF601E0002CE8F", hash_generated_method = "8B75CE55A74835F005C71B0C33748B9F")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "WallpaperInfo{" + mService.serviceInfo.name
                //+ ", settings: "
                //+ mSettingsActivityName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.109 -0400", hash_original_method = "E04AD845315D2630A943DB9D13064432", hash_generated_method = "5A7F184CD4125650C206449F677EBAFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(mSettingsActivityName);
        dest.writeInt(mThumbnailResource);
        dest.writeInt(mAuthorResource);
        dest.writeInt(mDescriptionResource);
        mService.writeToParcel(dest, flags);
        // ---------- Original Method ----------
        //dest.writeString(mSettingsActivityName);
        //dest.writeInt(mThumbnailResource);
        //dest.writeInt(mAuthorResource);
        //dest.writeInt(mDescriptionResource);
        //mService.writeToParcel(dest, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.109 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    static final String TAG = "WallpaperInfo";
    public static final Parcelable.Creator<WallpaperInfo> CREATOR = new Parcelable.Creator<WallpaperInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.110 -0400", hash_original_method = "E0CA03F91A5FF6E3DEA1E1ECC308F7EB", hash_generated_method = "2914452E72B17372150C2556F6E31654")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WallpaperInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            WallpaperInfo varFFC939F759EEFFD32F43D312601C358A_183921137 = (new WallpaperInfo(source));
            return (WallpaperInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WallpaperInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.110 -0400", hash_original_method = "B2B9815F42BAA1995A48EC036922067C", hash_generated_method = "E1715210A369D590984D3DD80C8593B6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WallpaperInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            WallpaperInfo[] var91B9D467803FD7A1E925417152AB69CC_429701462 = (new WallpaperInfo[size]);
            return (WallpaperInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WallpaperInfo[size];
        }

        
}; //Transformed anonymous class
}

