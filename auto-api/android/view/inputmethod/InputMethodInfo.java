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
    ResolveInfo mService;
    String mId;
    String mSettingsActivityName;
    int mIsDefaultResId;
    private ArrayList<InputMethodSubtype> mSubtypes = new ArrayList<InputMethodSubtype>();
    private boolean mIsAuxIme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.338 -0400", hash_original_method = "89874ED803E39B5F353BEED5B6B29424", hash_generated_method = "9EE975954AF5A837D6FA1DB01A6DCB5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethodInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        this(context, service, null);
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.339 -0400", hash_original_method = "889D0140370752FE888ACF7EA3C15BF9", hash_generated_method = "085B74F960800D449694F17ECA434AFB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethodInfo(Context context, ResolveInfo service,
            Map<String, List<InputMethodSubtype>> additionalSubtypesMap) throws XmlPullParserException, IOException {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(additionalSubtypesMap.dsTaint);
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
                boolean var995057C222283DCE9E465AE35974357A_987929692 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean var3BAF69D2A2DF70BFF2D5EC6E347C15F0_233382662 = (!"input-method".equals(nodeName));
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
                boolean var3BCD25E42C06A3F4443E39624F08B54A_943559012 = (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT);
                {
                    {
                        nodeName = parser.getName();
                        {
                            boolean varD77CB44AB3FA1C503F181A8217D1EED1_1967208179 = (!"subtype".equals(nodeName));
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
                            boolean var22671D0549DC9FE86ECAAC712821FB09_1107603164 = (!subtype.isAuxiliary());
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
            boolean var5AA00C27AF563E9923FCEF7BF46CB452_213982585 = (mSubtypes.size() == 0);
            {
                mIsAuxIme = false;
            } //End block
        } //End collapsed parenthetic
        {
            boolean var01ADBFE6B0BB77A97C046964E7D5DA54_85395010 = (additionalSubtypesMap != null && additionalSubtypesMap.containsKey(mId));
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
                            boolean var437404FD15332E5CF30D79D6DB67B176_613113578 = (!mSubtypes.contains(subtype));
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.340 -0400", hash_original_method = "408133FF0ACC2482487194D0CAB563F8", hash_generated_method = "F41E20B94DB49A4DE5067CDA6E0A8FDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     InputMethodInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.340 -0400", hash_original_method = "530FB6E934B0A6A853BD43F0002757A2", hash_generated_method = "F6074E21884FF4C7CE6F2C50CF20EDEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethodInfo(String packageName, String className,
            CharSequence label, String settingsActivity) {
        dsTaint.addTaint(settingsActivity);
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(label);
        dsTaint.addTaint(className);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.340 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "0FDB014011C1101442E06D2B7F29E689")
    @DSModeled(DSC.SAFE)
    public String getId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.341 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "63877C04759CD6A29BB5A9D09769BD95")
    @DSModeled(DSC.SAFE)
    public String getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.341 -0400", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "AFF3C5622D211F1659EB1D0A2141C7AB")
    @DSModeled(DSC.SAFE)
    public String getServiceName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mService.serviceInfo.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.341 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "9C67A090AD36EBAC69BD5168FBDFB473")
    @DSModeled(DSC.SAFE)
    public ServiceInfo getServiceInfo() {
        return (ServiceInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.341 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "35A40F8CFAFBFB160F12503BD50A21DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName getComponent() {
        ComponentName var36812892F2F610F061B81BA39B626ED6_887696435 = (new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name));
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ComponentName(mService.serviceInfo.packageName,
                //mService.serviceInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.341 -0400", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "A4D0EF3815869507AA1B2B2DDD4AD650")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadLabel(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        CharSequence var37856CDD70F50ABB3C82E07A4EC679C0_1408124156 = (mService.loadLabel(pm));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mService.loadLabel(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.341 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "89EA54B0E55FEAB81F9B989EFD49F15D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable loadIcon(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        Drawable var8EEC18B2BAAC36DADFAD2C3B55E7EE45_392930688 = (mService.loadIcon(pm));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.342 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "A8B888BFD8A46E2CDEC1514677D36FA3")
    @DSModeled(DSC.SAFE)
    public String getSettingsActivity() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.342 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "9ABC8F15A60DE37714C5A2945068D685")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSubtypeCount() {
        int var2A2E26F2E1FE9603006EE3A64DF7EF6B_1288435543 = (mSubtypes.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubtypes.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.342 -0400", hash_original_method = "8DB3E81066DAFF6D6FC518E613D3324D", hash_generated_method = "3BC3F44043E0FFDADE67C38E57E476B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InputMethodSubtype getSubtypeAt(int index) {
        dsTaint.addTaint(index);
        InputMethodSubtype var8D6B04E3BFE1316A079FE87971A302DA_1210260823 = (mSubtypes.get(index));
        return (InputMethodSubtype)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSubtypes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.342 -0400", hash_original_method = "D40E950149CD5654CB7133AFB587F871", hash_generated_method = "29C6691DD4758165E0FEA01776C8A7E6")
    @DSModeled(DSC.SAFE)
    public int getIsDefaultResourceId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIsDefaultResId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.342 -0400", hash_original_method = "117DA0E6EED582D5768D87F87FE31C9D", hash_generated_method = "D7DDB42905FCB7834A7B4956EEEDE6CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.342 -0400", hash_original_method = "B1E623174B0D17462D77E01C624BA9A3", hash_generated_method = "A4087BCAD1E232C07B830B1CD1522FC3")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "InputMethodInfo{" + mId
                //+ ", settings: "
                //+ mSettingsActivityName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.343 -0400", hash_original_method = "138C64F4407505D90DB7ED842C7A62A7", hash_generated_method = "CB4E399B7D9C7F55557E2942C1BEB678")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1929457327 = (o == this);
        } //End collapsed parenthetic
        InputMethodInfo obj;
        obj = (InputMethodInfo) o;
        boolean var503735D73D79A1B1147D713C845FB65C_1725200527 = (mId.equals(obj.mId));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (o == null) return false;
        //if (!(o instanceof InputMethodInfo)) return false;
        //InputMethodInfo obj = (InputMethodInfo) o;
        //return mId.equals(obj.mId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.343 -0400", hash_original_method = "703EF4DB2908CB7D83260BB6EC0F610D", hash_generated_method = "B0D94135CA429B18F6B29640901E508B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int varD0D1563019D677BB305608F4816D3FC7_1329630676 = (mId.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.343 -0400", hash_original_method = "14EC3F96E0FE12EE22A064553C434BBF", hash_generated_method = "3D4405DB4026DFAD8D1B3AFE132B21AC")
    @DSModeled(DSC.SAFE)
    public boolean isAuxiliaryIme() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mIsAuxIme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.343 -0400", hash_original_method = "A776E868EB44985D1E2E0042801983B1", hash_generated_method = "D92F0AFEDBC2EACCE75059721E130053")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.343 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    static final String TAG = "InputMethodInfo";
    public static final Parcelable.Creator<InputMethodInfo> CREATOR = new Parcelable.Creator<InputMethodInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.344 -0400", hash_original_method = "34C1AEE140730DF166077C8E73F0BE76", hash_generated_method = "A6B89721B43B59CD5B44447F6A2FE46D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public InputMethodInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            InputMethodInfo var6D889DEE8436EFE406C0B66417EF81F7_567638049 = (new InputMethodInfo(source));
            return (InputMethodInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputMethodInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.344 -0400", hash_original_method = "49600A5A1FFDA7DAE900783B5989229D", hash_generated_method = "4C83008DE1FB5BC670D1BB230E09856A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public InputMethodInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            InputMethodInfo[] varD436B8541CEDAFD6640E80F1D2A07FB7_1539520979 = (new InputMethodInfo[size]);
            return (InputMethodInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new InputMethodInfo[size];
        }

        
}; //Transformed anonymous class
}

