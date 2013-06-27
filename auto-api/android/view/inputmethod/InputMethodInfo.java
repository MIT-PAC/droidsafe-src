package android.view.inputmethod;

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.193 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6778D731BF0BE2E5E9F46404EEE44664")

    ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.194 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "5AB31FF91690EC0315884BA04F6C543E")

    String mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.194 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "1E356AACEE2D50E0C905EA0627229FF1")

    String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.194 -0400", hash_original_field = "792F9E8EA99BA75EE8CA84357D69011E", hash_generated_field = "8430CEC44BF27F97FC3604538A03E5EA")

    int mIsDefaultResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.194 -0400", hash_original_field = "02285A865B63873E8E4A6486105ABE87", hash_generated_field = "884392D28CFD17B0275E083612373789")

    private ArrayList<InputMethodSubtype> mSubtypes = new ArrayList<InputMethodSubtype>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.194 -0400", hash_original_field = "977F5006FFFDD545C39D52373806572E", hash_generated_field = "EB108F753B89051896699C9D79AA6EB9")

    private boolean mIsAuxIme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.194 -0400", hash_original_method = "89874ED803E39B5F353BEED5B6B29424", hash_generated_method = "3C8362D39A2AB89AC67E1587324BC4A9")
    public  InputMethodInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        this(context, service, null);
        addTaint(context.getTaint());
        addTaint(service.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.215 -0400", hash_original_method = "889D0140370752FE888ACF7EA3C15BF9", hash_generated_method = "B806D2A8FB7309DE4377B994DE557005")
    public  InputMethodInfo(Context context, ResolveInfo service,
            Map<String, List<InputMethodSubtype>> additionalSubtypesMap) throws XmlPullParserException, IOException {
        mService = service;
        ServiceInfo si;
        si = service.serviceInfo;
        mId = new ComponentName(si.packageName, si.name).flattenToShortString();
        mIsAuxIme = true;
        PackageManager pm;
        pm = context.getPackageManager();
        String settingsActivityComponent;
        settingsActivityComponent = null;
        int isDefaultResId;
        isDefaultResId = 0;
        XmlResourceParser parser;
        parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, InputMethod.SERVICE_META_DATA);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("No "
                        + InputMethod.SERVICE_META_DATA + " meta-data");
            } //End block
            Resources res;
            res = pm.getResourcesForApplication(si.applicationInfo);
            AttributeSet attrs;
            attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_1853383645 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean var3BAF69D2A2DF70BFF2D5EC6E347C15F0_1965855185 = (!"input-method".equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Meta-data does not start with input-method tag");
                } //End block
            } //End collapsed parenthetic
            TypedArray sa;
            sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.InputMethod);
            settingsActivityComponent = sa.getString(
                    com.android.internal.R.styleable.InputMethod_settingsActivity);
            isDefaultResId = sa.getResourceId(
                    com.android.internal.R.styleable.InputMethod_isDefault, 0);
            sa.recycle();
            int depth;
            depth = parser.getDepth();
            {
                boolean var3BCD25E42C06A3F4443E39624F08B54A_10321623 = (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT);
                {
                    {
                        nodeName = parser.getName();
                        {
                            boolean varD77CB44AB3FA1C503F181A8217D1EED1_848726783 = (!"subtype".equals(nodeName));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                                "Meta-data in input-method does not start with subtype tag");
                            } //End block
                        } //End collapsed parenthetic
                        TypedArray a;
                        a = res.obtainAttributes(
                            attrs, com.android.internal.R.styleable.InputMethod_Subtype);
                        InputMethodSubtype subtype;
                        subtype = new InputMethodSubtype(
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
                            boolean var22671D0549DC9FE86ECAAC712821FB09_1222669371 = (!subtype.isAuxiliary());
                            {
                                mIsAuxIme = false;
                            } //End block
                        } //End collapsed parenthetic
                        mSubtypes.add(subtype);
                    } //End block
                } //End block
            } //End collapsed parenthetic
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
        {
            boolean var5AA00C27AF563E9923FCEF7BF46CB452_1878612570 = (mSubtypes.size() == 0);
            {
                mIsAuxIme = false;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var01ADBFE6B0BB77A97C046964E7D5DA54_886163378 = (additionalSubtypesMap != null && additionalSubtypesMap.containsKey(mId));
            {
                List<InputMethodSubtype> additionalSubtypes;
                additionalSubtypes = additionalSubtypesMap.get(mId);
                int N;
                N = additionalSubtypes.size();
                {
                    int i;
                    i = 0;
                    {
                        InputMethodSubtype subtype;
                        subtype = additionalSubtypes.get(i);
                        {
                            boolean var437404FD15332E5CF30D79D6DB67B176_1129676243 = (!mSubtypes.contains(subtype));
                            {
                                mSubtypes.add(subtype);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        mSettingsActivityName = settingsActivityComponent;
        mIsDefaultResId = isDefaultResId;
        addTaint(context.getTaint());
        addTaint(additionalSubtypesMap.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.216 -0400", hash_original_method = "408133FF0ACC2482487194D0CAB563F8", hash_generated_method = "BB70880FF8A7B7B804EA683372E90436")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.225 -0400", hash_original_method = "530FB6E934B0A6A853BD43F0002757A2", hash_generated_method = "3E4851267C5B33B47CFAE48AD953506F")
    public  InputMethodInfo(String packageName, String className,
            CharSequence label, String settingsActivity) {
        ResolveInfo ri;
        ri = new ResolveInfo();
        ServiceInfo si;
        si = new ServiceInfo();
        ApplicationInfo ai;
        ai = new ApplicationInfo();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.226 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "B1A11F3C66DBA8A33CBCCDB143EF59A8")
    public String getId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1497399745 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1497399745 = mId;
        varB4EAC82CA7396A68D541C85D26508E83_1497399745.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1497399745;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.230 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "55A205B321667462792C00B3FD32A24F")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1403501321 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1403501321 = mService.serviceInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_1403501321.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1403501321;
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.231 -0400", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "6FEAF02F4A20E01B232749704AFC2276")
    public String getServiceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1689218188 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1689218188 = mService.serviceInfo.name;
        varB4EAC82CA7396A68D541C85D26508E83_1689218188.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1689218188;
        // ---------- Original Method ----------
        //return mService.serviceInfo.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.231 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "242E3AD161912CBBF0C320ADE4E4ED8E")
    public ServiceInfo getServiceInfo() {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_554599898 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_554599898 = mService.serviceInfo;
        varB4EAC82CA7396A68D541C85D26508E83_554599898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_554599898;
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.236 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "293077F4EBD3B48548FE7AD64C9A451D")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1965640020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1965640020 = new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_1965640020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1965640020;
        // ---------- Original Method ----------
        //return new ComponentName(mService.serviceInfo.packageName,
                //mService.serviceInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.240 -0400", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "86E03D31F9CF7FCD25BE4D7FD3D58A1F")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1668345671 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1668345671 = mService.loadLabel(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1668345671.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1668345671;
        // ---------- Original Method ----------
        //return mService.loadLabel(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.254 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "81969C81135DF081EFD206A48659C9DF")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_304692348 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_304692348 = mService.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_304692348.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_304692348;
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.255 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "7E97A604C947A2F247ECD2F8D81B8ED2")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_1489699091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1489699091 = mSettingsActivityName;
        varB4EAC82CA7396A68D541C85D26508E83_1489699091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1489699091;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.255 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "21401BAD002507D26E22240BE10CD503")
    public int getSubtypeCount() {
        int var2A2E26F2E1FE9603006EE3A64DF7EF6B_997094449 = (mSubtypes.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606469913 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1606469913;
        // ---------- Original Method ----------
        //return mSubtypes.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.256 -0400", hash_original_method = "8DB3E81066DAFF6D6FC518E613D3324D", hash_generated_method = "D337B526D6B96791B8BF5346C43805CD")
    public InputMethodSubtype getSubtypeAt(int index) {
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_1183610299 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1183610299 = mSubtypes.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1183610299.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1183610299;
        // ---------- Original Method ----------
        //return mSubtypes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.257 -0400", hash_original_method = "D40E950149CD5654CB7133AFB587F871", hash_generated_method = "E999382785CF90C53641065C2C72186C")
    public int getIsDefaultResourceId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_898435386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_898435386;
        // ---------- Original Method ----------
        //return mIsDefaultResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.257 -0400", hash_original_method = "117DA0E6EED582D5768D87F87FE31C9D", hash_generated_method = "C6242AAEDA1344D529ECF34008F4F5D8")
    public void dump(Printer pw, String prefix) {
        pw.println(prefix + "mId=" + mId
                + " mSettingsActivityName=" + mSettingsActivityName);
        pw.println(prefix + "mIsDefaultResId=0x"
                + Integer.toHexString(mIsDefaultResId));
        pw.println(prefix + "Service:");
        mService.dump(pw, prefix + "  ");
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //pw.println(prefix + "mId=" + mId
                //+ " mSettingsActivityName=" + mSettingsActivityName);
        //pw.println(prefix + "mIsDefaultResId=0x"
                //+ Integer.toHexString(mIsDefaultResId));
        //pw.println(prefix + "Service:");
        //mService.dump(pw, prefix + "  ");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.258 -0400", hash_original_method = "B1E623174B0D17462D77E01C624BA9A3", hash_generated_method = "40BC2D3BFCFC0F6215333C42F0E1FBCE")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1743098549 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1743098549 = "InputMethodInfo{" + mId
                + ", settings: "
                + mSettingsActivityName + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1743098549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1743098549;
        // ---------- Original Method ----------
        //return "InputMethodInfo{" + mId
                //+ ", settings: "
                //+ mSettingsActivityName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.258 -0400", hash_original_method = "138C64F4407505D90DB7ED842C7A62A7", hash_generated_method = "9D68252D3C556FD5D1D396A348D387FF")
    @Override
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_2009699054 = (o == this);
        } //End collapsed parenthetic
        InputMethodInfo obj;
        obj = (InputMethodInfo) o;
        boolean var503735D73D79A1B1147D713C845FB65C_1955670101 = (mId.equals(obj.mId));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980804142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980804142;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (o == null) return false;
        //if (!(o instanceof InputMethodInfo)) return false;
        //InputMethodInfo obj = (InputMethodInfo) o;
        //return mId.equals(obj.mId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.273 -0400", hash_original_method = "703EF4DB2908CB7D83260BB6EC0F610D", hash_generated_method = "6DB0D6C79DAF04711BC4C70A47D36BD5")
    @Override
    public int hashCode() {
        int varD0D1563019D677BB305608F4816D3FC7_22805343 = (mId.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_858789269 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_858789269;
        // ---------- Original Method ----------
        //return mId.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.273 -0400", hash_original_method = "14EC3F96E0FE12EE22A064553C434BBF", hash_generated_method = "E47FD340F15F844536AD852274777CBA")
    public boolean isAuxiliaryIme() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1207890345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1207890345;
        // ---------- Original Method ----------
        //return mIsAuxIme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.274 -0400", hash_original_method = "A776E868EB44985D1E2E0042801983B1", hash_generated_method = "85A9740AE516393F9AE9A2F5229965B2")
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
        // ---------- Original Method ----------
        //dest.writeString(mId);
        //dest.writeString(mSettingsActivityName);
        //dest.writeInt(mIsDefaultResId);
        //dest.writeInt(mIsAuxIme ? 1 : 0);
        //mService.writeToParcel(dest, flags);
        //dest.writeTypedList(mSubtypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.274 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8053CE92BE54BE2B2B69B6A1AB69586A")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983318782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1983318782;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.274 -0400", hash_original_field = "9F72F07379E6C161D406B99662BBC7ED", hash_generated_field = "414B1CE6AC0576A11221BFB6BDE818C7")

    static String TAG = "InputMethodInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.274 -0400", hash_original_field = "DEB12F1F6F201D41FBA42CC969CA4837", hash_generated_field = "0C5D3B1B4FDD1347C21CE5B24224A6EF")

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

