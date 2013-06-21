package android.view.textservice;

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
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Slog;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;

public final class SpellCheckerInfo implements Parcelable {
    private ResolveInfo mService;
    private String mId;
    private int mLabel;
    private String mSettingsActivityName;
    private ArrayList<SpellCheckerSubtype> mSubtypes = new ArrayList<SpellCheckerSubtype>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.443 -0400", hash_original_method = "6A25F08819F54F2E6B313A58A8CE6D90", hash_generated_method = "6EFF730A7CB2C5CD019047A99651A354")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckerInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        ServiceInfo si;
        si = service.serviceInfo;
        mId = new ComponentName(si.packageName, si.name).flattenToShortString();
        PackageManager pm;
        pm = context.getPackageManager();
        int label;
        label = 0;
        String settingsActivityComponent;
        settingsActivityComponent = null;
        XmlResourceParser parser;
        parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, SpellCheckerSession.SERVICE_META_DATA);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("No "
                        + SpellCheckerSession.SERVICE_META_DATA + " meta-data");
            } //End block
            Resources res;
            res = pm.getResourcesForApplication(si.applicationInfo);
            AttributeSet attrs;
            attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_1028971283 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean varB5CFADE7245E4FEF78AB00B840C32F3B_1138621748 = (!"spell-checker".equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Meta-data does not start with spell-checker tag");
                } //End block
            } //End collapsed parenthetic
            TypedArray sa;
            sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.SpellChecker);
            label = sa.getResourceId(com.android.internal.R.styleable.SpellChecker_label, 0);
            settingsActivityComponent = sa.getString(
                    com.android.internal.R.styleable.SpellChecker_settingsActivity);
            sa.recycle();
            int depth;
            depth = parser.getDepth();
            {
                boolean var3BCD25E42C06A3F4443E39624F08B54A_814592857 = (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT);
                {
                    {
                        String subtypeNodeName;
                        subtypeNodeName = parser.getName();
                        {
                            boolean var5F9B3D3FE3DCD3142E05F57C429CD825_585358035 = (!"subtype".equals(subtypeNodeName));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                                "Meta-data in spell-checker does not start with subtype tag");
                            } //End block
                        } //End collapsed parenthetic
                        TypedArray a;
                        a = res.obtainAttributes(
                            attrs, com.android.internal.R.styleable.SpellChecker_Subtype);
                        SpellCheckerSubtype subtype;
                        subtype = new SpellCheckerSubtype(
                            a.getResourceId(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_label, 0),
                            a.getString(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_subtypeLocale),
                            a.getString(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_subtypeExtraValue));
                        mSubtypes.add(subtype);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        mLabel = label;
        mSettingsActivityName = settingsActivityComponent;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.444 -0400", hash_original_method = "D0DF2452D02A3DC9C8E7C8BB825D11D4", hash_generated_method = "E3B2DF6F1E9C6C0F263DE75C40241AF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckerInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        mLabel = source.readInt();
        mId = source.readString();
        mSettingsActivityName = source.readString();
        mService = ResolveInfo.CREATOR.createFromParcel(source);
        source.readTypedList(mSubtypes, SpellCheckerSubtype.CREATOR);
        // ---------- Original Method ----------
        //mLabel = source.readInt();
        //mId = source.readString();
        //mSettingsActivityName = source.readString();
        //mService = ResolveInfo.CREATOR.createFromParcel(source);
        //source.readTypedList(mSubtypes, SpellCheckerSubtype.CREATOR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.444 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "0FDB014011C1101442E06D2B7F29E689")
    @DSModeled(DSC.SAFE)
    public String getId() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.444 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "07A162E6C05A41318615EA96C8A952B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName getComponent() {
        ComponentName var4F22164A5E0375B82A28BBE891F2760E_2047502754 = (new ComponentName(
                mService.serviceInfo.packageName, mService.serviceInfo.name));
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ComponentName(
                //mService.serviceInfo.packageName, mService.serviceInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.444 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "63877C04759CD6A29BB5A9D09769BD95")
    @DSModeled(DSC.SAFE)
    public String getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.444 -0400", hash_original_method = "2F472510FA9E87ADC65F29887FB84501", hash_generated_method = "119C8C0C6DDECE197A881DE73F11D801")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mLabel);
        dest.writeString(mId);
        dest.writeString(mSettingsActivityName);
        mService.writeToParcel(dest, flags);
        dest.writeTypedList(mSubtypes);
        // ---------- Original Method ----------
        //dest.writeInt(mLabel);
        //dest.writeString(mId);
        //dest.writeString(mSettingsActivityName);
        //mService.writeToParcel(dest, flags);
        //dest.writeTypedList(mSubtypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.444 -0400", hash_original_method = "440496C0C039EAF57937C0E12546E16A", hash_generated_method = "7FBF79F50E60C0C66C736A3BFC20DB6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadLabel(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        CharSequence var369522E1B5E8D478F311511AB203FA95_651246347 = (pm.getText(getPackageName(), mLabel, mService.serviceInfo.applicationInfo));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mLabel == 0 || pm == null) return "";
        //return pm.getText(getPackageName(), mLabel, mService.serviceInfo.applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.445 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "49C4B7E793AE500D0CB24D7BCAAFE656")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable loadIcon(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        Drawable var8EEC18B2BAAC36DADFAD2C3B55E7EE45_1313106837 = (mService.loadIcon(pm));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.445 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "9C67A090AD36EBAC69BD5168FBDFB473")
    @DSModeled(DSC.SAFE)
    public ServiceInfo getServiceInfo() {
        return (ServiceInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.445 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "A8B888BFD8A46E2CDEC1514677D36FA3")
    @DSModeled(DSC.SAFE)
    public String getSettingsActivity() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.445 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "015D8F6885F9D19E0E04525801D5236D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSubtypeCount() {
        int var2A2E26F2E1FE9603006EE3A64DF7EF6B_1482406500 = (mSubtypes.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mSubtypes.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.445 -0400", hash_original_method = "A5CD061EE9765DD17A95FDAD389682DB", hash_generated_method = "0F02F40D89854E237DA17B6E577DBAD2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckerSubtype getSubtypeAt(int index) {
        dsTaint.addTaint(index);
        SpellCheckerSubtype var8D6B04E3BFE1316A079FE87971A302DA_1602143838 = (mSubtypes.get(index));
        return (SpellCheckerSubtype)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSubtypes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.446 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    private static final String TAG = SpellCheckerInfo.class.getSimpleName();
    public static final Parcelable.Creator<SpellCheckerInfo> CREATOR = new Parcelable.Creator<SpellCheckerInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.446 -0400", hash_original_method = "B57052E05D31390D8AC825C45000906A", hash_generated_method = "DFE16BBEE66A2B0E05228D7A75E40F48")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SpellCheckerInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            SpellCheckerInfo var3EAE1610AA9F78FB158857ACC13D7F7C_667156561 = (new SpellCheckerInfo(source));
            return (SpellCheckerInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SpellCheckerInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.446 -0400", hash_original_method = "923FE0033E87D54E7EAC06D455D52BFB", hash_generated_method = "38CBCA040603E2A9DCB60ABD3221930E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public SpellCheckerInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            SpellCheckerInfo[] varB6969D96C9FAECCEFA1482DEFC315B5C_320262713 = (new SpellCheckerInfo[size]);
            return (SpellCheckerInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SpellCheckerInfo[size];
        }

        
}; //Transformed anonymous class
}

