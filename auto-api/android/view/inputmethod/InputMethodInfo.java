package android.view.inputmethod;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class InputMethodInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.111 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6778D731BF0BE2E5E9F46404EEE44664")

    ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.111 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "5AB31FF91690EC0315884BA04F6C543E")

    String mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.111 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "1E356AACEE2D50E0C905EA0627229FF1")

    String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.111 -0400", hash_original_field = "792F9E8EA99BA75EE8CA84357D69011E", hash_generated_field = "8430CEC44BF27F97FC3604538A03E5EA")

    int mIsDefaultResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.111 -0400", hash_original_field = "02285A865B63873E8E4A6486105ABE87", hash_generated_field = "21F533BA3E9571D81DF5BF77269CE919")

    private final ArrayList<InputMethodSubtype> mSubtypes = new ArrayList<InputMethodSubtype>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.111 -0400", hash_original_field = "977F5006FFFDD545C39D52373806572E", hash_generated_field = "EB108F753B89051896699C9D79AA6EB9")

    private boolean mIsAuxIme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.112 -0400", hash_original_method = "89874ED803E39B5F353BEED5B6B29424", hash_generated_method = "3C8362D39A2AB89AC67E1587324BC4A9")
    public  InputMethodInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        this(context, service, null);
        addTaint(context.getTaint());
        addTaint(service.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.113 -0400", hash_original_method = "889D0140370752FE888ACF7EA3C15BF9", hash_generated_method = "D335FBFC475BC82B0C47B8CCAA65F9E8")
    public  InputMethodInfo(Context context, ResolveInfo service,
            Map<String, List<InputMethodSubtype>> additionalSubtypesMap) throws XmlPullParserException, IOException {
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
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("No "
                        + InputMethod.SERVICE_META_DATA + " meta-data");
            } 
            Resources res = pm.getResourcesForApplication(si.applicationInfo);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_1122952166 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } 
            String nodeName = parser.getName();
            {
                boolean var3BAF69D2A2DF70BFF2D5EC6E347C15F0_1694436240 = (!"input-method".equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Meta-data does not start with input-method tag");
                } 
            } 
            TypedArray sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.InputMethod);
            settingsActivityComponent = sa.getString(
                    com.android.internal.R.styleable.InputMethod_settingsActivity);
            isDefaultResId = sa.getResourceId(
                    com.android.internal.R.styleable.InputMethod_isDefault, 0);
            sa.recycle();
            final int depth = parser.getDepth();
            {
                boolean var3BCD25E42C06A3F4443E39624F08B54A_618905800 = (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT);
                {
                    {
                        nodeName = parser.getName();
                        {
                            boolean varD77CB44AB3FA1C503F181A8217D1EED1_533309577 = (!"subtype".equals(nodeName));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                                "Meta-data in input-method does not start with subtype tag");
                            } 
                        } 
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
                        {
                            boolean var22671D0549DC9FE86ECAAC712821FB09_405930946 = (!subtype.isAuxiliary());
                            {
                                mIsAuxIme = false;
                            } 
                        } 
                        mSubtypes.add(subtype);
                    } 
                } 
            } 
        } 
        catch (NameNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
        } 
        finally 
        {
            parser.close();
        } 
        {
            boolean var5AA00C27AF563E9923FCEF7BF46CB452_1493114051 = (mSubtypes.size() == 0);
            {
                mIsAuxIme = false;
            } 
        } 
        {
            boolean var01ADBFE6B0BB77A97C046964E7D5DA54_922619816 = (additionalSubtypesMap != null && additionalSubtypesMap.containsKey(mId));
            {
                final List<InputMethodSubtype> additionalSubtypes = additionalSubtypesMap.get(mId);
                final int N = additionalSubtypes.size();
                {
                    int i = 0;
                    {
                        final InputMethodSubtype subtype = additionalSubtypes.get(i);
                        {
                            boolean var437404FD15332E5CF30D79D6DB67B176_337861564 = (!mSubtypes.contains(subtype));
                            {
                                mSubtypes.add(subtype);
                            } 
                        } 
                    } 
                } 
            } 
        } 
        mSettingsActivityName = settingsActivityComponent;
        mIsDefaultResId = isDefaultResId;
        addTaint(context.getTaint());
        addTaint(additionalSubtypesMap.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.114 -0400", hash_original_method = "408133FF0ACC2482487194D0CAB563F8", hash_generated_method = "BB70880FF8A7B7B804EA683372E90436")
      InputMethodInfo(Parcel source) {
        mId = source.readString();
        mSettingsActivityName = source.readString();
        mIsDefaultResId = source.readInt();
        mIsAuxIme = source.readInt() == 1;
        mService = ResolveInfo.CREATOR.createFromParcel(source);
        source.readTypedList(mSubtypes, InputMethodSubtype.CREATOR);
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.115 -0400", hash_original_method = "530FB6E934B0A6A853BD43F0002757A2", hash_generated_method = "F23980264BE1A304471E0F3EB09B9633")
    public  InputMethodInfo(String packageName, String className,
            CharSequence label, String settingsActivity) {
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
        addTaint(className.getTaint());
        addTaint(label.getTaint());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.116 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "8AAC170F5A9580AE8F730981B5627A2A")
    public String getId() {
        String varB4EAC82CA7396A68D541C85D26508E83_491624549 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_491624549 = mId;
        varB4EAC82CA7396A68D541C85D26508E83_491624549.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_491624549;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.116 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "4FF8199AFBBCA9CB06A08103320D4F57")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1186263226 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1186263226 = mService.serviceInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_1186263226.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1186263226;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.117 -0400", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "231EBB64A56911FBBEB402EBF649E02D")
    public String getServiceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1318661863 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1318661863 = mService.serviceInfo.name;
        varB4EAC82CA7396A68D541C85D26508E83_1318661863.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1318661863;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.117 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "9941E6315694AA5FF10E95654CD2B949")
    public ServiceInfo getServiceInfo() {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_977818660 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_977818660 = mService.serviceInfo;
        varB4EAC82CA7396A68D541C85D26508E83_977818660.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_977818660;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.118 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "359FF1C421B27B91B085BAFB4C703663")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1397578828 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1397578828 = new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_1397578828.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1397578828;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.118 -0400", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "D4C7EAA10FF553068A795561C38E3722")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_128813326 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_128813326 = mService.loadLabel(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_128813326.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_128813326;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.119 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "AAFA1FEEC2386D9D37EF5A18B9CEC0A1")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1627735518 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1627735518 = mService.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1627735518.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1627735518;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.119 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "B483EF1ECB6F5E79EE683D3DEF2838A5")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_358803926 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_358803926 = mSettingsActivityName;
        varB4EAC82CA7396A68D541C85D26508E83_358803926.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_358803926;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.119 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "8543D8F43741F09520C58DD1574A35F4")
    public int getSubtypeCount() {
        int var2A2E26F2E1FE9603006EE3A64DF7EF6B_526174776 = (mSubtypes.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851577139 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851577139;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.120 -0400", hash_original_method = "8DB3E81066DAFF6D6FC518E613D3324D", hash_generated_method = "3A786903EFB33538DA4D2DB468A02394")
    public InputMethodSubtype getSubtypeAt(int index) {
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_1315033264 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1315033264 = mSubtypes.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1315033264.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1315033264;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.120 -0400", hash_original_method = "D40E950149CD5654CB7133AFB587F871", hash_generated_method = "19F8E759F64A76FDECFF3604D330384B")
    public int getIsDefaultResourceId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528394842 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1528394842;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.120 -0400", hash_original_method = "117DA0E6EED582D5768D87F87FE31C9D", hash_generated_method = "C6242AAEDA1344D529ECF34008F4F5D8")
    public void dump(Printer pw, String prefix) {
        pw.println(prefix + "mId=" + mId
                + " mSettingsActivityName=" + mSettingsActivityName);
        pw.println(prefix + "mIsDefaultResId=0x"
                + Integer.toHexString(mIsDefaultResId));
        pw.println(prefix + "Service:");
        mService.dump(pw, prefix + "  ");
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        
        
                
        
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.121 -0400", hash_original_method = "B1E623174B0D17462D77E01C624BA9A3", hash_generated_method = "05FD34EBDA03CD21420DA61DB8EFE345")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_117180449 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_117180449 = "InputMethodInfo{" + mId
                + ", settings: "
                + mSettingsActivityName + "}";
        varB4EAC82CA7396A68D541C85D26508E83_117180449.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_117180449;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.121 -0400", hash_original_method = "138C64F4407505D90DB7ED842C7A62A7", hash_generated_method = "BAF21F1E0178DC192493C10EA8AF6C33")
    @Override
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1571798918 = (o == this);
        } 
        InputMethodInfo obj = (InputMethodInfo) o;
        boolean var503735D73D79A1B1147D713C845FB65C_1915852798 = (mId.equals(obj.mId));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_112430949 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_112430949;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.122 -0400", hash_original_method = "703EF4DB2908CB7D83260BB6EC0F610D", hash_generated_method = "4E67001ED1AC2165F714AB0D3AED57DD")
    @Override
    public int hashCode() {
        int varD0D1563019D677BB305608F4816D3FC7_1266478934 = (mId.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139599629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1139599629;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.122 -0400", hash_original_method = "14EC3F96E0FE12EE22A064553C434BBF", hash_generated_method = "A259026E9B8AD2D58AF03E3294F38E5D")
    public boolean isAuxiliaryIme() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1602551623 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1602551623;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.122 -0400", hash_original_method = "A776E868EB44985D1E2E0042801983B1", hash_generated_method = "85A9740AE516393F9AE9A2F5229965B2")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mSettingsActivityName);
        dest.writeInt(mIsDefaultResId);
        dest.writeInt(mIsAuxIme ? 1 : 0);
        mService.writeToParcel(dest, flags);
        dest.writeTypedList(mSubtypes);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.122 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C47DBC87D8AE9099275D15958816097E")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_855477231 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_855477231;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.122 -0400", hash_original_field = "9F72F07379E6C161D406B99662BBC7ED", hash_generated_field = "0D3F383A8AE37AD4A1E896720B0C8651")

    static final String TAG = "InputMethodInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.122 -0400", hash_original_field = "DEB12F1F6F201D41FBA42CC969CA4837", hash_generated_field = "0C5D3B1B4FDD1347C21CE5B24224A6EF")

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

