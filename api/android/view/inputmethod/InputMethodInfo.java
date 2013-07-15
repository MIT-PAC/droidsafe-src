package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.353 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "6778D731BF0BE2E5E9F46404EEE44664")

    ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.353 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "5AB31FF91690EC0315884BA04F6C543E")

    String mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.353 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "1E356AACEE2D50E0C905EA0627229FF1")

    String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.353 -0400", hash_original_field = "792F9E8EA99BA75EE8CA84357D69011E", hash_generated_field = "8430CEC44BF27F97FC3604538A03E5EA")

    int mIsDefaultResId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.353 -0400", hash_original_field = "02285A865B63873E8E4A6486105ABE87", hash_generated_field = "21F533BA3E9571D81DF5BF77269CE919")

    private final ArrayList<InputMethodSubtype> mSubtypes = new ArrayList<InputMethodSubtype>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.354 -0400", hash_original_field = "977F5006FFFDD545C39D52373806572E", hash_generated_field = "EB108F753B89051896699C9D79AA6EB9")

    private boolean mIsAuxIme;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.354 -0400", hash_original_method = "89874ED803E39B5F353BEED5B6B29424", hash_generated_method = "F33B66CC8F8D6666A7BB774EB1215D95")
    public  InputMethodInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        this(context, service, null);
        addTaint(service.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.356 -0400", hash_original_method = "889D0140370752FE888ACF7EA3C15BF9", hash_generated_method = "E84BA74143D81D99B8D61ABC1689AA7C")
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
                XmlPullParserException varC2031FC67DB218FE767A18537DF81FBA_1004397587 = new XmlPullParserException("No "
                        + InputMethod.SERVICE_META_DATA + " meta-data");
                varC2031FC67DB218FE767A18537DF81FBA_1004397587.addTaint(taint);
                throw varC2031FC67DB218FE767A18537DF81FBA_1004397587;
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
                XmlPullParserException var381A6AA54113D66A5A8107F495E9846B_1632718621 = new XmlPullParserException(
                        "Meta-data does not start with input-method tag");
                var381A6AA54113D66A5A8107F495E9846B_1632718621.addTaint(taint);
                throw var381A6AA54113D66A5A8107F495E9846B_1632718621;
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
                        XmlPullParserException var90E94D5C928EFFC182D2E40E388072FD_558070261 = new XmlPullParserException(
                                "Meta-data in input-method does not start with subtype tag");
                        var90E94D5C928EFFC182D2E40E388072FD_558070261.addTaint(taint);
                        throw var90E94D5C928EFFC182D2E40E388072FD_558070261;
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
            XmlPullParserException varB6EED742DEFFBFD1A69F8473E03396C1_197543511 = new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
            varB6EED742DEFFBFD1A69F8473E03396C1_197543511.addTaint(taint);
            throw varB6EED742DEFFBFD1A69F8473E03396C1_197543511;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.358 -0400", hash_original_method = "408133FF0ACC2482487194D0CAB563F8", hash_generated_method = "BB70880FF8A7B7B804EA683372E90436")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.361 -0400", hash_original_method = "530FB6E934B0A6A853BD43F0002757A2", hash_generated_method = "3D340D9430D7166AD960AE610713F156")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.362 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "C8562A1421D3BDEAB32CBAE0F233B85D")
    public String getId() {
String var565D51511D15781AE576ED3D7A8F70E9_1193405984 =         mId;
        var565D51511D15781AE576ED3D7A8F70E9_1193405984.addTaint(taint);
        return var565D51511D15781AE576ED3D7A8F70E9_1193405984;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.362 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "9C281F7F4A5D4456E55B0501D1549757")
    public String getPackageName() {
String var255A04E9345861413C0ACB855498FFE1_214653408 =         mService.serviceInfo.packageName;
        var255A04E9345861413C0ACB855498FFE1_214653408.addTaint(taint);
        return var255A04E9345861413C0ACB855498FFE1_214653408;
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.363 -0400", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "7C16705FE802D60BCB3EF3584D70FC2F")
    public String getServiceName() {
String varD4631640EAF59249824E850938835B61_886279554 =         mService.serviceInfo.name;
        varD4631640EAF59249824E850938835B61_886279554.addTaint(taint);
        return varD4631640EAF59249824E850938835B61_886279554;
        // ---------- Original Method ----------
        //return mService.serviceInfo.name;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.363 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "64C1FFD6F5A53A446528A9F2E9A300F2")
    public ServiceInfo getServiceInfo() {
ServiceInfo var28B71D71C22FF17E2913DF471BE53524_1803698030 =         mService.serviceInfo;
        var28B71D71C22FF17E2913DF471BE53524_1803698030.addTaint(taint);
        return var28B71D71C22FF17E2913DF471BE53524_1803698030;
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.363 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "053047A333B838E2A814B28740F02B43")
    public ComponentName getComponent() {
ComponentName var93E6F91556E618C88339096F31BDB937_320376727 =         new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name);
        var93E6F91556E618C88339096F31BDB937_320376727.addTaint(taint);
        return var93E6F91556E618C88339096F31BDB937_320376727;
        // ---------- Original Method ----------
        //return new ComponentName(mService.serviceInfo.packageName,
                //mService.serviceInfo.name);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.363 -0400", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "B3E7D3DB08A667FCAD35AF4F05D89E4B")
    public CharSequence loadLabel(PackageManager pm) {
        addTaint(pm.getTaint());
CharSequence var2E9E378F798705D673A3CD2955015CB9_1150503450 =         mService.loadLabel(pm);
        var2E9E378F798705D673A3CD2955015CB9_1150503450.addTaint(taint);
        return var2E9E378F798705D673A3CD2955015CB9_1150503450;
        // ---------- Original Method ----------
        //return mService.loadLabel(pm);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.364 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "919E72A4504106733ABA0257AD36D2BA")
    public Drawable loadIcon(PackageManager pm) {
        addTaint(pm.getTaint());
Drawable varFF3368A5083B43E8384DF7E2744DD5A3_394422948 =         mService.loadIcon(pm);
        varFF3368A5083B43E8384DF7E2744DD5A3_394422948.addTaint(taint);
        return varFF3368A5083B43E8384DF7E2744DD5A3_394422948;
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.364 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "0AC553BE7BE83F9D29CC0584BAF9A126")
    public String getSettingsActivity() {
String varF52598D579FB7EF6DE23C12DD22DC004_1534136727 =         mSettingsActivityName;
        varF52598D579FB7EF6DE23C12DD22DC004_1534136727.addTaint(taint);
        return varF52598D579FB7EF6DE23C12DD22DC004_1534136727;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.364 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "5DE9ED0653BE29D7CC36BDBD55EE66D4")
    public int getSubtypeCount() {
        int var4D00EFCF59D020D8587406D0543FA800_1005072561 = (mSubtypes.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686174763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686174763;
        // ---------- Original Method ----------
        //return mSubtypes.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.365 -0400", hash_original_method = "8DB3E81066DAFF6D6FC518E613D3324D", hash_generated_method = "0D570F54E1F9E98F4862B50400E78D24")
    public InputMethodSubtype getSubtypeAt(int index) {
        addTaint(index);
InputMethodSubtype var20D9F29322B7A583A76DDB79ACEBD923_1302585089 =         mSubtypes.get(index);
        var20D9F29322B7A583A76DDB79ACEBD923_1302585089.addTaint(taint);
        return var20D9F29322B7A583A76DDB79ACEBD923_1302585089;
        // ---------- Original Method ----------
        //return mSubtypes.get(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.365 -0400", hash_original_method = "D40E950149CD5654CB7133AFB587F871", hash_generated_method = "476EB9B02A5F0F4D7C82866D5BC0C24B")
    public int getIsDefaultResourceId() {
        int var792F9E8EA99BA75EE8CA84357D69011E_348980181 = (mIsDefaultResId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1028591824 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1028591824;
        // ---------- Original Method ----------
        //return mIsDefaultResId;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.365 -0400", hash_original_method = "117DA0E6EED582D5768D87F87FE31C9D", hash_generated_method = "C3F71DCA885DD63BEE2EC78F28AB92BA")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.365 -0400", hash_original_method = "B1E623174B0D17462D77E01C624BA9A3", hash_generated_method = "48B59744F3C78ACEED23B942EFCE293A")
    @Override
    public String toString() {
String var46A8C37BD18223DBA7F7BB5E017FE828_1540012274 =         "InputMethodInfo{" + mId
                + ", settings: "
                + mSettingsActivityName + "}";
        var46A8C37BD18223DBA7F7BB5E017FE828_1540012274.addTaint(taint);
        return var46A8C37BD18223DBA7F7BB5E017FE828_1540012274;
        // ---------- Original Method ----------
        //return "InputMethodInfo{" + mId
                //+ ", settings: "
                //+ mSettingsActivityName + "}";
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.366 -0400", hash_original_method = "138C64F4407505D90DB7ED842C7A62A7", hash_generated_method = "69F3C7E3641CAFCB4537A14352BA9CF6")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
    if(o == this)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1152539142 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_442283461 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_442283461;
        }
    if(o == null)        
        {
        boolean var68934A3E9455FA72420237EB05902327_1466703683 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_682358476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_682358476;
        }
    if(!(o instanceof InputMethodInfo))        
        {
        boolean var68934A3E9455FA72420237EB05902327_1165129315 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_249267270 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_249267270;
        }
        InputMethodInfo obj = (InputMethodInfo) o;
        boolean var2CC9492E350495F6F3799A87FF1AF9D0_1215299283 = (mId.equals(obj.mId));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_457260944 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_457260944;
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (o == null) return false;
        //if (!(o instanceof InputMethodInfo)) return false;
        //InputMethodInfo obj = (InputMethodInfo) o;
        //return mId.equals(obj.mId);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.366 -0400", hash_original_method = "703EF4DB2908CB7D83260BB6EC0F610D", hash_generated_method = "5D764C5D1FD807CF95F35D92B9B033C5")
    @Override
    public int hashCode() {
        int var84C17997E2817A5DFA997C0A689C50D8_1145120442 = (mId.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603678431 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1603678431;
        // ---------- Original Method ----------
        //return mId.hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.366 -0400", hash_original_method = "14EC3F96E0FE12EE22A064553C434BBF", hash_generated_method = "A0EACD31079F1BF3A2F51DB0C22D25D8")
    public boolean isAuxiliaryIme() {
        boolean var977F5006FFFDD545C39D52373806572E_1964033913 = (mIsAuxIme);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015743717 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015743717;
        // ---------- Original Method ----------
        //return mIsAuxIme;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.367 -0400", hash_original_method = "A776E868EB44985D1E2E0042801983B1", hash_generated_method = "0D12A7C503BE78F4174FD70EEAB4CFDA")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.367 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "270E8697A6431612AA0FEB709AF6932A")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_332102034 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194348147 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194348147;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.367 -0400", hash_original_field = "9F72F07379E6C161D406B99662BBC7ED", hash_generated_field = "0D3F383A8AE37AD4A1E896720B0C8651")

    static final String TAG = "InputMethodInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:56.367 -0400", hash_original_field = "DEB12F1F6F201D41FBA42CC969CA4837", hash_generated_field = "0C5D3B1B4FDD1347C21CE5B24224A6EF")

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

