package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Printer;
import android.util.Xml;





public final class InputMethodInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.602 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6778D731BF0BE2E5E9F46404EEE44664")

    ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.602 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "5AB31FF91690EC0315884BA04F6C543E")

    String mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.602 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "1E356AACEE2D50E0C905EA0627229FF1")

    String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.602 -0400", hash_original_field = "792F9E8EA99BA75EE8CA84357D69011E", hash_generated_field = "8430CEC44BF27F97FC3604538A03E5EA")

    int mIsDefaultResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.602 -0400", hash_original_field = "02285A865B63873E8E4A6486105ABE87", hash_generated_field = "21F533BA3E9571D81DF5BF77269CE919")

    private final ArrayList<InputMethodSubtype> mSubtypes = new ArrayList<InputMethodSubtype>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.602 -0400", hash_original_field = "977F5006FFFDD545C39D52373806572E", hash_generated_field = "EB108F753B89051896699C9D79AA6EB9")

    private boolean mIsAuxIme;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.602 -0400", hash_original_method = "89874ED803E39B5F353BEED5B6B29424", hash_generated_method = "F33B66CC8F8D6666A7BB774EB1215D95")
    public  InputMethodInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        this(context, service, null);
        addTaint(service.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.606 -0400", hash_original_method = "889D0140370752FE888ACF7EA3C15BF9", hash_generated_method = "79BF859366DFA1E9E68484929F8A49B5")
    public  InputMethodInfo(Context context, ResolveInfo service,
            Map<String, List<InputMethodSubtype>> additionalSubtypesMap) throws XmlPullParserException, IOException {
        addTaint(additionalSubtypesMap.getTaint());
        addTaint(context.getTaint());
        mService = service;
        ServiceInfo si = service.serviceInfo;
        mId = new ComponentName(si.packageName, si.name).flattenToShortString();
        mIsAuxIme = true;
        PackageManager pm = context.getPackageManager();
        String settingsActivityComponent = null;
        int isDefaultResId = 0;
        XmlResourceParser parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, InputMethod.SERVICE_META_DATA);
            if(parser == null)            
            {
                XmlPullParserException varC2031FC67DB218FE767A18537DF81FBA_1227023677 = new XmlPullParserException("No "
                        + InputMethod.SERVICE_META_DATA + " meta-data");
                varC2031FC67DB218FE767A18537DF81FBA_1227023677.addTaint(taint);
                throw varC2031FC67DB218FE767A18537DF81FBA_1227023677;
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
            if(!"input-method".equals(nodeName))            
            {
                XmlPullParserException var381A6AA54113D66A5A8107F495E9846B_1381437498 = new XmlPullParserException(
                        "Meta-data does not start with input-method tag");
                var381A6AA54113D66A5A8107F495E9846B_1381437498.addTaint(taint);
                throw var381A6AA54113D66A5A8107F495E9846B_1381437498;
            } //End block
            TypedArray sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.InputMethod);
            settingsActivityComponent = sa.getString(
                    com.android.internal.R.styleable.InputMethod_settingsActivity);
            isDefaultResId = sa.getResourceId(
                    com.android.internal.R.styleable.InputMethod_isDefault, 0);
            sa.recycle();
            final int depth = parser.getDepth();
            while
(((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT)            
            {
                if(type == XmlPullParser.START_TAG)                
                {
                    nodeName = parser.getName();
                    if(!"subtype".equals(nodeName))                    
                    {
                        XmlPullParserException var90E94D5C928EFFC182D2E40E388072FD_369403365 = new XmlPullParserException(
                                "Meta-data in input-method does not start with subtype tag");
                        var90E94D5C928EFFC182D2E40E388072FD_369403365.addTaint(taint);
                        throw var90E94D5C928EFFC182D2E40E388072FD_369403365;
                    } //End block
                    final TypedArray a = res.obtainAttributes(
                            attrs, com.android.internal.R.styleable.InputMethod_Subtype);
                    InputMethodSubtype subtype = new InputMethodSubtype(
                            a.getResourceId(com.android.internal.R.styleable
                                    .InputMethod_Subtype_label, 0),
                            a.getResourceId(com.android.internal.R.styleable
                                    .InputMethod_Subtype_icon, 0),
                            a.getString(com.android.internal.R.styleable
                                    .InputMethod_Subtype_imeSubtypeLocale),
                            a.getString(com.android.internal.R.styleable
                                    .InputMethod_Subtype_imeSubtypeMode),
                            a.getString(com.android.internal.R.styleable
                                    .InputMethod_Subtype_imeSubtypeExtraValue),
                            a.getBoolean(com.android.internal.R.styleable
                                    .InputMethod_Subtype_isAuxiliary, false),
                            a.getBoolean(com.android.internal.R.styleable
                                    .InputMethod_Subtype_overridesImplicitlyEnabledSubtype, false));
                    if(!subtype.isAuxiliary())                    
                    {
                        mIsAuxIme = false;
                    } //End block
                    mSubtypes.add(subtype);
                } //End block
            } //End block
        } //End block
        catch (NameNotFoundException e)
        {
            XmlPullParserException varB6EED742DEFFBFD1A69F8473E03396C1_765587397 = new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
            varB6EED742DEFFBFD1A69F8473E03396C1_765587397.addTaint(taint);
            throw varB6EED742DEFFBFD1A69F8473E03396C1_765587397;
        } //End block
        finally 
        {
            if(parser != null)            
            parser.close();
        } //End block
        if(mSubtypes.size() == 0)        
        {
            mIsAuxIme = false;
        } //End block
        if(additionalSubtypesMap != null && additionalSubtypesMap.containsKey(mId))        
        {
            final List<InputMethodSubtype> additionalSubtypes = additionalSubtypesMap.get(mId);
            final int N = additionalSubtypes.size();
for(int i = 0;i < N;++i)
            {
                final InputMethodSubtype subtype = additionalSubtypes.get(i);
                if(!mSubtypes.contains(subtype))                
                {
                    mSubtypes.add(subtype);
                } //End block
            } //End block
        } //End block
        mSettingsActivityName = settingsActivityComponent;
        mIsDefaultResId = isDefaultResId;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.609 -0400", hash_original_method = "408133FF0ACC2482487194D0CAB563F8", hash_generated_method = "BB70880FF8A7B7B804EA683372E90436")
      InputMethodInfo(Parcel source) {
        mId = source.readString();
        mSettingsActivityName = source.readString();
        mIsDefaultResId = source.readInt();
        mIsAuxIme = source.readInt() == 1;
        mService = ResolveInfo.CREATOR.createFromParcel(source);
        source.readTypedList(mSubtypes, InputMethodSubtype.CREATOR);
        // ---------- Original Method ----------
        //mId = source.readString();
        //mSettingsActivityName = source.readString();
        //mIsDefaultResId = source.readInt();
        //mIsAuxIme = source.readInt() == 1;
        //mService = ResolveInfo.CREATOR.createFromParcel(source);
        //source.readTypedList(mSubtypes, InputMethodSubtype.CREATOR);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.613 -0400", hash_original_method = "530FB6E934B0A6A853BD43F0002757A2", hash_generated_method = "3D340D9430D7166AD960AE610713F156")
    public  InputMethodInfo(String packageName, String className,
            CharSequence label, String settingsActivity) {
        addTaint(label.getTaint());
        addTaint(className.getTaint());
        ResolveInfo ri = new ResolveInfo();
        ServiceInfo si = new ServiceInfo();
        ApplicationInfo ai = new ApplicationInfo();
        ai.packageName = packageName;
        ai.enabled = true;
        si.applicationInfo = ai;
        si.enabled = true;
        si.packageName = packageName;
        si.name = className;
        si.exported = true;
        si.nonLocalizedLabel = label;
        ri.serviceInfo = si;
        mService = ri;
        mId = new ComponentName(si.packageName, si.name).flattenToShortString();
        mSettingsActivityName = settingsActivity;
        mIsDefaultResId = 0;
        mIsAuxIme = false;
        // ---------- Original Method ----------
        //ResolveInfo ri = new ResolveInfo();
        //ServiceInfo si = new ServiceInfo();
        //ApplicationInfo ai = new ApplicationInfo();
        //ai.packageName = packageName;
        //ai.enabled = true;
        //si.applicationInfo = ai;
        //si.enabled = true;
        //si.packageName = packageName;
        //si.name = className;
        //si.exported = true;
        //si.nonLocalizedLabel = label;
        //ri.serviceInfo = si;
        //mService = ri;
        //mId = new ComponentName(si.packageName, si.name).flattenToShortString();
        //mSettingsActivityName = settingsActivity;
        //mIsDefaultResId = 0;
        //mIsAuxIme = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.613 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "171E4C7B3C0B1F8B047797314B20B11A")
    public String getId() {
String var565D51511D15781AE576ED3D7A8F70E9_1207731908 =         mId;
        var565D51511D15781AE576ED3D7A8F70E9_1207731908.addTaint(taint);
        return var565D51511D15781AE576ED3D7A8F70E9_1207731908;
        // ---------- Original Method ----------
        //return mId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.613 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "EC0403853ED0202116AAC965FDA536FE")
    public String getPackageName() {
String var255A04E9345861413C0ACB855498FFE1_1736628501 =         mService.serviceInfo.packageName;
        var255A04E9345861413C0ACB855498FFE1_1736628501.addTaint(taint);
        return var255A04E9345861413C0ACB855498FFE1_1736628501;
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.613 -0400", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "471B8150858572E3B3486759B385CCA5")
    public String getServiceName() {
String varD4631640EAF59249824E850938835B61_1297449833 =         mService.serviceInfo.name;
        varD4631640EAF59249824E850938835B61_1297449833.addTaint(taint);
        return varD4631640EAF59249824E850938835B61_1297449833;
        // ---------- Original Method ----------
        //return mService.serviceInfo.name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.614 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "2D90056DD92CE73DE5C87683DCE2FC73")
    public ServiceInfo getServiceInfo() {
ServiceInfo var28B71D71C22FF17E2913DF471BE53524_765440611 =         mService.serviceInfo;
        var28B71D71C22FF17E2913DF471BE53524_765440611.addTaint(taint);
        return var28B71D71C22FF17E2913DF471BE53524_765440611;
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.614 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "6BBBD594CEA9D755CBCA282889343252")
    public ComponentName getComponent() {
ComponentName var93E6F91556E618C88339096F31BDB937_410357168 =         new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name);
        var93E6F91556E618C88339096F31BDB937_410357168.addTaint(taint);
        return var93E6F91556E618C88339096F31BDB937_410357168;
        // ---------- Original Method ----------
        //return new ComponentName(mService.serviceInfo.packageName,
                //mService.serviceInfo.name);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.614 -0400", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "3A8D3591F195DEEEA582AA8E284346E8")
    public CharSequence loadLabel(PackageManager pm) {
        addTaint(pm.getTaint());
CharSequence var2E9E378F798705D673A3CD2955015CB9_1871051554 =         mService.loadLabel(pm);
        var2E9E378F798705D673A3CD2955015CB9_1871051554.addTaint(taint);
        return var2E9E378F798705D673A3CD2955015CB9_1871051554;
        // ---------- Original Method ----------
        //return mService.loadLabel(pm);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.614 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "75E53CA766B6C04A4823C7C78EC625A9")
    public Drawable loadIcon(PackageManager pm) {
        addTaint(pm.getTaint());
Drawable varFF3368A5083B43E8384DF7E2744DD5A3_1438342939 =         mService.loadIcon(pm);
        varFF3368A5083B43E8384DF7E2744DD5A3_1438342939.addTaint(taint);
        return varFF3368A5083B43E8384DF7E2744DD5A3_1438342939;
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.615 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "1447BFE74FB494F56A73FFFF4B9BF74E")
    public String getSettingsActivity() {
String varF52598D579FB7EF6DE23C12DD22DC004_1413239720 =         mSettingsActivityName;
        varF52598D579FB7EF6DE23C12DD22DC004_1413239720.addTaint(taint);
        return varF52598D579FB7EF6DE23C12DD22DC004_1413239720;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.615 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "C0F95D5CE976D016CAB5E573F1F46BA5")
    public int getSubtypeCount() {
        int var4D00EFCF59D020D8587406D0543FA800_1324848574 = (mSubtypes.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521585633 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521585633;
        // ---------- Original Method ----------
        //return mSubtypes.size();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.615 -0400", hash_original_method = "8DB3E81066DAFF6D6FC518E613D3324D", hash_generated_method = "28AD2E2488EF01AE8AB100A08EFD1EFB")
    public InputMethodSubtype getSubtypeAt(int index) {
        addTaint(index);
InputMethodSubtype var20D9F29322B7A583A76DDB79ACEBD923_7180723 =         mSubtypes.get(index);
        var20D9F29322B7A583A76DDB79ACEBD923_7180723.addTaint(taint);
        return var20D9F29322B7A583A76DDB79ACEBD923_7180723;
        // ---------- Original Method ----------
        //return mSubtypes.get(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.616 -0400", hash_original_method = "D40E950149CD5654CB7133AFB587F871", hash_generated_method = "3FDED4AA2B92B8ED0B483D0AA6E17EAB")
    public int getIsDefaultResourceId() {
        int var792F9E8EA99BA75EE8CA84357D69011E_425839729 = (mIsDefaultResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364373300 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364373300;
        // ---------- Original Method ----------
        //return mIsDefaultResId;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.616 -0400", hash_original_method = "117DA0E6EED582D5768D87F87FE31C9D", hash_generated_method = "C3F71DCA885DD63BEE2EC78F28AB92BA")
    public void dump(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        pw.println(prefix + "mId=" + mId
                + " mSettingsActivityName=" + mSettingsActivityName);
        pw.println(prefix + "mIsDefaultResId=0x"
                + Integer.toHexString(mIsDefaultResId));
        pw.println(prefix + "Service:");
        mService.dump(pw, prefix + "  ");
        // ---------- Original Method ----------
        //pw.println(prefix + "mId=" + mId
                //+ " mSettingsActivityName=" + mSettingsActivityName);
        //pw.println(prefix + "mIsDefaultResId=0x"
                //+ Integer.toHexString(mIsDefaultResId));
        //pw.println(prefix + "Service:");
        //mService.dump(pw, prefix + "  ");
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.616 -0400", hash_original_method = "B1E623174B0D17462D77E01C624BA9A3", hash_generated_method = "DBD740914EA66C54C49C87A2C71151A5")
    @Override
    public String toString() {
String var46A8C37BD18223DBA7F7BB5E017FE828_810412377 =         "InputMethodInfo{" + mId
                + ", settings: "
                + mSettingsActivityName + "}";
        var46A8C37BD18223DBA7F7BB5E017FE828_810412377.addTaint(taint);
        return var46A8C37BD18223DBA7F7BB5E017FE828_810412377;
        // ---------- Original Method ----------
        //return "InputMethodInfo{" + mId
                //+ ", settings: "
                //+ mSettingsActivityName + "}";
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.617 -0400", hash_original_method = "138C64F4407505D90DB7ED842C7A62A7", hash_generated_method = "C376F0B5415221CAE89455C1482001A9")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_2060751166 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_460207957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_460207957;
        }
        if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_2109360737 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1352973769 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1352973769;
        }
        if(!(o instanceof InputMethodInfo))        
        {
        boolean var68934A3E9455FA72420237EB05902327_938175424 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_257490682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_257490682;
        }
        InputMethodInfo obj = (InputMethodInfo) o;
        boolean var2CC9492E350495F6F3799A87FF1AF9D0_1224860620 = (mId.equals(obj.mId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_93721634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_93721634;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (o == null) return false;
        //if (!(o instanceof InputMethodInfo)) return false;
        //InputMethodInfo obj = (InputMethodInfo) o;
        //return mId.equals(obj.mId);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.617 -0400", hash_original_method = "703EF4DB2908CB7D83260BB6EC0F610D", hash_generated_method = "D6A6068A972458D17675069D18E188C1")
    @Override
    public int hashCode() {
        int var84C17997E2817A5DFA997C0A689C50D8_172117584 = (mId.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968263538 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_968263538;
        // ---------- Original Method ----------
        //return mId.hashCode();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.617 -0400", hash_original_method = "14EC3F96E0FE12EE22A064553C434BBF", hash_generated_method = "1686782B21CE6904A08E907EEA880889")
    public boolean isAuxiliaryIme() {
        boolean var977F5006FFFDD545C39D52373806572E_1919870510 = (mIsAuxIme);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1398802623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1398802623;
        // ---------- Original Method ----------
        //return mIsAuxIme;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.617 -0400", hash_original_method = "A776E868EB44985D1E2E0042801983B1", hash_generated_method = "0D12A7C503BE78F4174FD70EEAB4CFDA")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeString(mId);
        dest.writeString(mSettingsActivityName);
        dest.writeInt(mIsDefaultResId);
        dest.writeInt(mIsAuxIme ? 1 : 0);
        mService.writeToParcel(dest, flags);
        dest.writeTypedList(mSubtypes);
        // ---------- Original Method ----------
        //dest.writeString(mId);
        //dest.writeString(mSettingsActivityName);
        //dest.writeInt(mIsDefaultResId);
        //dest.writeInt(mIsAuxIme ? 1 : 0);
        //mService.writeToParcel(dest, flags);
        //dest.writeTypedList(mSubtypes);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.618 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C93BE1644D6201B286058DD7EA3A4BA2")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_31843078 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082411921 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1082411921;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.618 -0400", hash_original_field = "9F72F07379E6C161D406B99662BBC7ED", hash_generated_field = "0D3F383A8AE37AD4A1E896720B0C8651")

    static final String TAG = "InputMethodInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.618 -0400", hash_original_field = "DEB12F1F6F201D41FBA42CC969CA4837", hash_generated_field = "0C5D3B1B4FDD1347C21CE5B24224A6EF")

    public static final Parcelable.Creator<InputMethodInfo> CREATOR
            = new Parcelable.Creator<InputMethodInfo>() {
        @Override
        public InputMethodInfo createFromParcel(Parcel source) {
            return new InputMethodInfo(source);
        }

        @Override
        public InputMethodInfo[] newArray(int size) {
            return new InputMethodInfo[size];
        }
    };
}

