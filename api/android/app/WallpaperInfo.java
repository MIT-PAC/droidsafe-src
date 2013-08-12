package android.app;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.360 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6778D731BF0BE2E5E9F46404EEE44664")

    ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.360 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "1E356AACEE2D50E0C905EA0627229FF1")

    String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.360 -0400", hash_original_field = "4554908A8E26081711E37F2891765BE1", hash_generated_field = "C308135F64EE76FAD8A4F39458F20392")

    int mThumbnailResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.360 -0400", hash_original_field = "8EBCDAD2B63FBADDF3471AEE8D1290BF", hash_generated_field = "0691CCFFB273CFC14946667627C5AD49")

    int mAuthorResource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.361 -0400", hash_original_field = "50344039A2139E68EBB953B2C832814A", hash_generated_field = "4746EA78955ECA6177E056F9EE2DC4A6")

    int mDescriptionResource;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.364 -0400", hash_original_method = "74057F7C8E144B72C39BB7F86C2AB292", hash_generated_method = "0BCEC9808420F913BE24BE3CC718ABE8")
    public  WallpaperInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        addTaint(context.getTaint());
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
            if(parser == null)            
            {
                XmlPullParserException varF846C5ABAEA9029673D00ED8A0565610_1664248349 = new XmlPullParserException("No "
                        + WallpaperService.SERVICE_META_DATA + " meta-data");
                varF846C5ABAEA9029673D00ED8A0565610_1664248349.addTaint(taint);
                throw varF846C5ABAEA9029673D00ED8A0565610_1664248349;
            } //End block
            Resources res = pm.getResourcesForApplication(si.applicationInfo);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG)            
            {
            } //End block
            String nodeName = parser.getName();
            if(!"wallpaper".equals(nodeName))            
            {
                XmlPullParserException var73B26AE5B6703271D0B75212630E7BA7_952370205 = new XmlPullParserException(
                        "Meta-data does not start with wallpaper tag");
                var73B26AE5B6703271D0B75212630E7BA7_952370205.addTaint(taint);
                throw var73B26AE5B6703271D0B75212630E7BA7_952370205;
            } //End block
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
            XmlPullParserException varB6EED742DEFFBFD1A69F8473E03396C1_1774920632 = new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
            varB6EED742DEFFBFD1A69F8473E03396C1_1774920632.addTaint(taint);
            throw varB6EED742DEFFBFD1A69F8473E03396C1_1774920632;
        } //End block
        finally 
        {
            if(parser != null)            
            parser.close();
        } //End block
        mSettingsActivityName = settingsActivityComponent;
        mThumbnailResource = thumbnailRes;
        mAuthorResource = authorRes;
        mDescriptionResource = descriptionRes;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.365 -0400", hash_original_method = "C0E8BFC94627855CBFADB81460DD6D49", hash_generated_method = "440597EE814EC8A35B340ADB80FE34F7")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.366 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "EC51BDDF0F658C8182024DA93F5EC67B")
    public String getPackageName() {
String var255A04E9345861413C0ACB855498FFE1_554123708 =         mService.serviceInfo.packageName;
        var255A04E9345861413C0ACB855498FFE1_554123708.addTaint(taint);
        return var255A04E9345861413C0ACB855498FFE1_554123708;
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.366 -0400", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "145F664956276AB5B56A62FD0F76EBEE")
    public String getServiceName() {
String varD4631640EAF59249824E850938835B61_252123804 =         mService.serviceInfo.name;
        varD4631640EAF59249824E850938835B61_252123804.addTaint(taint);
        return varD4631640EAF59249824E850938835B61_252123804;
        // ---------- Original Method ----------
        //return mService.serviceInfo.name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.367 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "63F9C7CFA98F04BC30717CE6336134A8")
    public ServiceInfo getServiceInfo() {
ServiceInfo var28B71D71C22FF17E2913DF471BE53524_1818732890 =         mService.serviceInfo;
        var28B71D71C22FF17E2913DF471BE53524_1818732890.addTaint(taint);
        return var28B71D71C22FF17E2913DF471BE53524_1818732890;
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.367 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "3D962D6275C31E76A96812A8FCAFB3FA")
    public ComponentName getComponent() {
ComponentName var93E6F91556E618C88339096F31BDB937_920729115 =         new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name);
        var93E6F91556E618C88339096F31BDB937_920729115.addTaint(taint);
        return var93E6F91556E618C88339096F31BDB937_920729115;
        // ---------- Original Method ----------
        //return new ComponentName(mService.serviceInfo.packageName,
                //mService.serviceInfo.name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.368 -0400", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "650883E8A808B52259189E1D2F2BED01")
    public CharSequence loadLabel(PackageManager pm) {
        addTaint(pm.getTaint());
CharSequence var2E9E378F798705D673A3CD2955015CB9_727759426 =         mService.loadLabel(pm);
        var2E9E378F798705D673A3CD2955015CB9_727759426.addTaint(taint);
        return var2E9E378F798705D673A3CD2955015CB9_727759426;
        // ---------- Original Method ----------
        //return mService.loadLabel(pm);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.369 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "6933BCFE62468209725B5C21E544231D")
    public Drawable loadIcon(PackageManager pm) {
        addTaint(pm.getTaint());
Drawable varFF3368A5083B43E8384DF7E2744DD5A3_934692210 =         mService.loadIcon(pm);
        varFF3368A5083B43E8384DF7E2744DD5A3_934692210.addTaint(taint);
        return varFF3368A5083B43E8384DF7E2744DD5A3_934692210;
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.370 -0400", hash_original_method = "C26983A19295502D4CFCF4D89E5CA369", hash_generated_method = "D4D3B1D6C1E0B53580E7D580ACD02482")
    public Drawable loadThumbnail(PackageManager pm) {
        addTaint(pm.getTaint());
        if(mThumbnailResource < 0)        
        {
Drawable var540C13E9E156B687226421B24F2DF178_1406489881 =         null;
        var540C13E9E156B687226421B24F2DF178_1406489881.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1406489881;
        }
Drawable var4348016AAF788F05EADA2157D91AE065_50686882 =         pm.getDrawable(mService.serviceInfo.packageName,
                              mThumbnailResource,
                              mService.serviceInfo.applicationInfo);
        var4348016AAF788F05EADA2157D91AE065_50686882.addTaint(taint);
        return var4348016AAF788F05EADA2157D91AE065_50686882;
        // ---------- Original Method ----------
        //if (mThumbnailResource < 0) return null;
        //return pm.getDrawable(mService.serviceInfo.packageName,
                              //mThumbnailResource,
                              //mService.serviceInfo.applicationInfo);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.371 -0400", hash_original_method = "9EB36950261646858CECEB28CEC974AC", hash_generated_method = "B043F5A4858CCEC3A7E98F60F2500E5F")
    public CharSequence loadAuthor(PackageManager pm) throws NotFoundException {
        addTaint(pm.getTaint());
        if(mAuthorResource <= 0)        
        {
        NotFoundException var093D7BD5AA2C711924D0289C785A4288_964348527 = new NotFoundException();
        var093D7BD5AA2C711924D0289C785A4288_964348527.addTaint(taint);
        throw var093D7BD5AA2C711924D0289C785A4288_964348527;
        }
        String packageName = mService.resolvePackageName;
        ApplicationInfo applicationInfo = null;
        if(packageName == null)        
        {
            packageName = mService.serviceInfo.packageName;
            applicationInfo = mService.serviceInfo.applicationInfo;
        } //End block
CharSequence varFE7FE420E7443373E8CC4AD0F8CFC84C_1099115748 =         pm.getText(packageName, mAuthorResource, applicationInfo);
        varFE7FE420E7443373E8CC4AD0F8CFC84C_1099115748.addTaint(taint);
        return varFE7FE420E7443373E8CC4AD0F8CFC84C_1099115748;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.373 -0400", hash_original_method = "ECA3C93288FC3A8841FE238CFCF9AD1A", hash_generated_method = "288D7866F465E89AD5B94F559F2A2A51")
    public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        addTaint(pm.getTaint());
        String packageName = mService.resolvePackageName;
        ApplicationInfo applicationInfo = null;
        if(packageName == null)        
        {
            packageName = mService.serviceInfo.packageName;
            applicationInfo = mService.serviceInfo.applicationInfo;
        } //End block
        if(mService.serviceInfo.descriptionRes != 0)        
        {
CharSequence var877FC5681D1B3E2D911968F9F0315959_1137473576 =             pm.getText(packageName, mService.serviceInfo.descriptionRes,
                    applicationInfo);
            var877FC5681D1B3E2D911968F9F0315959_1137473576.addTaint(taint);
            return var877FC5681D1B3E2D911968F9F0315959_1137473576;
        } //End block
        if(mDescriptionResource <= 0)        
        {
        NotFoundException var093D7BD5AA2C711924D0289C785A4288_1909184451 = new NotFoundException();
        var093D7BD5AA2C711924D0289C785A4288_1909184451.addTaint(taint);
        throw var093D7BD5AA2C711924D0289C785A4288_1909184451;
        }
CharSequence var14E19B841891B10CBA32CD92E4F4FA1D_322332373 =         pm.getText(packageName, mDescriptionResource,
                mService.serviceInfo.applicationInfo);
        var14E19B841891B10CBA32CD92E4F4FA1D_322332373.addTaint(taint);
        return var14E19B841891B10CBA32CD92E4F4FA1D_322332373;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.374 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "E901871B92C00F710FBCBAD378D6062F")
    public String getSettingsActivity() {
String varF52598D579FB7EF6DE23C12DD22DC004_700998418 =         mSettingsActivityName;
        varF52598D579FB7EF6DE23C12DD22DC004_700998418.addTaint(taint);
        return varF52598D579FB7EF6DE23C12DD22DC004_700998418;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.376 -0400", hash_original_method = "01A70486818EE80E3925B6A989FED93F", hash_generated_method = "5C53276B0A02CB986B326D0A5B555762")
    public void dump(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        pw.println(prefix + "Service:");
        mService.dump(pw, prefix + "  ");
        pw.println(prefix + "mSettingsActivityName=" + mSettingsActivityName);
        // ---------- Original Method ----------
        //pw.println(prefix + "Service:");
        //mService.dump(pw, prefix + "  ");
        //pw.println(prefix + "mSettingsActivityName=" + mSettingsActivityName);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.377 -0400", hash_original_method = "01F16DDF22698F82DBFF601E0002CE8F", hash_generated_method = "CD67CAB3C3A0FE3DA6E71AE1F6F8F460")
    @Override
    public String toString() {
String var74D6B0CBF1B60D7089F268183AE6E814_1616513075 =         "WallpaperInfo{" + mService.serviceInfo.name
                + ", settings: "
                + mSettingsActivityName + "}";
        var74D6B0CBF1B60D7089F268183AE6E814_1616513075.addTaint(taint);
        return var74D6B0CBF1B60D7089F268183AE6E814_1616513075;
        // ---------- Original Method ----------
        //return "WallpaperInfo{" + mService.serviceInfo.name
                //+ ", settings: "
                //+ mSettingsActivityName + "}";
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.378 -0400", hash_original_method = "E04AD845315D2630A943DB9D13064432", hash_generated_method = "19F40B7C882670751F9872FD41138884")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.378 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B0615AE772B296DE24340FEBDBAB1254")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2020645486 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491478297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_491478297;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.378 -0400", hash_original_field = "FC9E2C4F1BD44A0CA44485FE9D62FF40", hash_generated_field = "01792FAFBA46EE705FA5945B423BCDDA")

    static final String TAG = "WallpaperInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.379 -0400", hash_original_field = "84A4B5F5E39D6F71F6BCEDFA677A58DF", hash_generated_field = "3E4220CC5B52A5C0AED6D687E5CC83E9")

    public static final Parcelable.Creator<WallpaperInfo> CREATOR = new Parcelable.Creator<WallpaperInfo>() {
        @DSModeled(DSC.SAFE)
        public WallpaperInfo createFromParcel(Parcel source) {
            return new WallpaperInfo(source);
        }

        @DSModeled(DSC.SAFE)
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

