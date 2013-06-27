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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.388 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6778D731BF0BE2E5E9F46404EEE44664")

    ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.388 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "5AB31FF91690EC0315884BA04F6C543E")

    String mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.388 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "1E356AACEE2D50E0C905EA0627229FF1")

    String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.388 -0400", hash_original_field = "792F9E8EA99BA75EE8CA84357D69011E", hash_generated_field = "8430CEC44BF27F97FC3604538A03E5EA")

    int mIsDefaultResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.388 -0400", hash_original_field = "02285A865B63873E8E4A6486105ABE87", hash_generated_field = "884392D28CFD17B0275E083612373789")

    private ArrayList<InputMethodSubtype> mSubtypes = new ArrayList<InputMethodSubtype>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.388 -0400", hash_original_field = "977F5006FFFDD545C39D52373806572E", hash_generated_field = "EB108F753B89051896699C9D79AA6EB9")

    private boolean mIsAuxIme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.389 -0400", hash_original_method = "89874ED803E39B5F353BEED5B6B29424", hash_generated_method = "3C8362D39A2AB89AC67E1587324BC4A9")
    public  InputMethodInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        this(context, service, null);
        addTaint(context.getTaint());
        addTaint(service.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.395 -0400", hash_original_method = "889D0140370752FE888ACF7EA3C15BF9", hash_generated_method = "50820EDA7F087DA6D3DB41A2D78A4C06")
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
                boolean var995057C222283DCE9E465AE35974357A_550277014 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean var3BAF69D2A2DF70BFF2D5EC6E347C15F0_1746068245 = (!"input-method".equals(nodeName));
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
                boolean var3BCD25E42C06A3F4443E39624F08B54A_198133709 = (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT);
                {
                    {
                        nodeName = parser.getName();
                        {
                            boolean varD77CB44AB3FA1C503F181A8217D1EED1_851671235 = (!"subtype".equals(nodeName));
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
                            boolean var22671D0549DC9FE86ECAAC712821FB09_958003965 = (!subtype.isAuxiliary());
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
            boolean var5AA00C27AF563E9923FCEF7BF46CB452_1764206505 = (mSubtypes.size() == 0);
            {
                mIsAuxIme = false;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var01ADBFE6B0BB77A97C046964E7D5DA54_1062986652 = (additionalSubtypesMap != null && additionalSubtypesMap.containsKey(mId));
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
                            boolean var437404FD15332E5CF30D79D6DB67B176_1682595468 = (!mSubtypes.contains(subtype));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.396 -0400", hash_original_method = "408133FF0ACC2482487194D0CAB563F8", hash_generated_method = "BB70880FF8A7B7B804EA683372E90436")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.415 -0400", hash_original_method = "530FB6E934B0A6A853BD43F0002757A2", hash_generated_method = "3E4851267C5B33B47CFAE48AD953506F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.416 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "8B370D117A030B36AF549DDA2DAB8513")
    public String getId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1546175808 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1546175808 = mId;
        varB4EAC82CA7396A68D541C85D26508E83_1546175808.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1546175808;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.417 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "F25221787F2470DAD0EF8D1D2B863F30")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_388973142 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_388973142 = mService.serviceInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_388973142.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_388973142;
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.418 -0400", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "CED174F1CD52DCBC238C16E6C97B6FDC")
    public String getServiceName() {
        String varB4EAC82CA7396A68D541C85D26508E83_946442429 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_946442429 = mService.serviceInfo.name;
        varB4EAC82CA7396A68D541C85D26508E83_946442429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_946442429;
        // ---------- Original Method ----------
        //return mService.serviceInfo.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.419 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "92223C89FACB1208BA0CB968373575A1")
    public ServiceInfo getServiceInfo() {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_1220964974 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1220964974 = mService.serviceInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1220964974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1220964974;
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.419 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "3A7D90116D8AD603087D9D40C4A85E01")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1065697040 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1065697040 = new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_1065697040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1065697040;
        // ---------- Original Method ----------
        //return new ComponentName(mService.serviceInfo.packageName,
                //mService.serviceInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.422 -0400", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "D17BC2DE0C3EAE917A785558EF387EB4")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1698161532 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1698161532 = mService.loadLabel(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1698161532.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1698161532;
        // ---------- Original Method ----------
        //return mService.loadLabel(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.427 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "B21D43E15A9F062FAC0EA5E39E5EA53D")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1991036374 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1991036374 = mService.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1991036374.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1991036374;
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.427 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "A32F929B6A066B6AFCA4C60BFE6BDD52")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_731212646 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_731212646 = mSettingsActivityName;
        varB4EAC82CA7396A68D541C85D26508E83_731212646.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_731212646;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.429 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "B4DC7E34AF1EF0773F76E64D408F7A31")
    public int getSubtypeCount() {
        int var2A2E26F2E1FE9603006EE3A64DF7EF6B_1049507162 = (mSubtypes.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098361952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2098361952;
        // ---------- Original Method ----------
        //return mSubtypes.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.429 -0400", hash_original_method = "8DB3E81066DAFF6D6FC518E613D3324D", hash_generated_method = "08B75A32487D20E8683B29763B501993")
    public InputMethodSubtype getSubtypeAt(int index) {
        InputMethodSubtype varB4EAC82CA7396A68D541C85D26508E83_1797324186 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1797324186 = mSubtypes.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1797324186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1797324186;
        // ---------- Original Method ----------
        //return mSubtypes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.430 -0400", hash_original_method = "D40E950149CD5654CB7133AFB587F871", hash_generated_method = "5062A66ECA209B0A99EBF44DC8689C02")
    public int getIsDefaultResourceId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109486935 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1109486935;
        // ---------- Original Method ----------
        //return mIsDefaultResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.430 -0400", hash_original_method = "117DA0E6EED582D5768D87F87FE31C9D", hash_generated_method = "C6242AAEDA1344D529ECF34008F4F5D8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.436 -0400", hash_original_method = "B1E623174B0D17462D77E01C624BA9A3", hash_generated_method = "C72EBBD051FFC22CCF8C5078E34EF781")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1074373309 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1074373309 = "InputMethodInfo{" + mId
                + ", settings: "
                + mSettingsActivityName + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1074373309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1074373309;
        // ---------- Original Method ----------
        //return "InputMethodInfo{" + mId
                //+ ", settings: "
                //+ mSettingsActivityName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.436 -0400", hash_original_method = "138C64F4407505D90DB7ED842C7A62A7", hash_generated_method = "CEEAE2A04EDEDFDBFA69A4A81CC18E09")
    @Override
    public boolean equals(Object o) {
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_193743570 = (o == this);
        } //End collapsed parenthetic
        InputMethodInfo obj;
        obj = (InputMethodInfo) o;
        boolean var503735D73D79A1B1147D713C845FB65C_775854119 = (mId.equals(obj.mId));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1171517083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1171517083;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (o == null) return false;
        //if (!(o instanceof InputMethodInfo)) return false;
        //InputMethodInfo obj = (InputMethodInfo) o;
        //return mId.equals(obj.mId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.440 -0400", hash_original_method = "703EF4DB2908CB7D83260BB6EC0F610D", hash_generated_method = "2CB26826169E4D108AA4C5C68190894E")
    @Override
    public int hashCode() {
        int varD0D1563019D677BB305608F4816D3FC7_190147630 = (mId.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027865564 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027865564;
        // ---------- Original Method ----------
        //return mId.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.443 -0400", hash_original_method = "14EC3F96E0FE12EE22A064553C434BBF", hash_generated_method = "91584780B4FE89563DD5CCE03448D3F6")
    public boolean isAuxiliaryIme() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1013448851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1013448851;
        // ---------- Original Method ----------
        //return mIsAuxIme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.447 -0400", hash_original_method = "A776E868EB44985D1E2E0042801983B1", hash_generated_method = "85A9740AE516393F9AE9A2F5229965B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.447 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "943559D09D79AFEB40F6888CD8FF8969")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1956862171 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1956862171;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.448 -0400", hash_original_field = "9F72F07379E6C161D406B99662BBC7ED", hash_generated_field = "414B1CE6AC0576A11221BFB6BDE818C7")

    static String TAG = "InputMethodInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.448 -0400", hash_original_field = "DEB12F1F6F201D41FBA42CC969CA4837", hash_generated_field = "0C5D3B1B4FDD1347C21CE5B24224A6EF")

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

