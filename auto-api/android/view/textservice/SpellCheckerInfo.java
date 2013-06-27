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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.465 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "47A49524DB3D9D5011E27A061CD906FB")

    private ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.465 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "34D624C7CD290D72B15AB814BF1BA854")

    private String mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.465 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "288F27297FDE0055206DB25B18D34AF5")

    private int mLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.465 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "3227A556BB8D91CC368DE162089FC968")

    private String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.465 -0400", hash_original_field = "58B4845692446C00D28E793F604359BA", hash_generated_field = "5C2B208B40F45F16C055A65B066B3210")

    private ArrayList<SpellCheckerSubtype> mSubtypes = new ArrayList<SpellCheckerSubtype>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.477 -0400", hash_original_method = "6A25F08819F54F2E6B313A58A8CE6D90", hash_generated_method = "7DB186EC1E895D6A807F9A3600E23051")
    public  SpellCheckerInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        mService = service;
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
                boolean var995057C222283DCE9E465AE35974357A_113781742 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean varB5CFADE7245E4FEF78AB00B840C32F3B_398113565 = (!"spell-checker".equals(nodeName));
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
                boolean var3BCD25E42C06A3F4443E39624F08B54A_983626038 = (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT);
                {
                    {
                        String subtypeNodeName;
                        subtypeNodeName = parser.getName();
                        {
                            boolean var5F9B3D3FE3DCD3142E05F57C429CD825_1176429373 = (!"subtype".equals(subtypeNodeName));
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
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.478 -0400", hash_original_method = "D0DF2452D02A3DC9C8E7C8BB825D11D4", hash_generated_method = "C0D8D8F6984FB63466EE4BBD97721CF4")
    public  SpellCheckerInfo(Parcel source) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.487 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "5241A1AEF57F65CFA045728659CD66D2")
    public String getId() {
        String varB4EAC82CA7396A68D541C85D26508E83_509886325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_509886325 = mId;
        varB4EAC82CA7396A68D541C85D26508E83_509886325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_509886325;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.487 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "FC75E3C4BF4B47A2DFB7D8681F319A7B")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_2040964354 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2040964354 = new ComponentName(
                mService.serviceInfo.packageName, mService.serviceInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_2040964354.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2040964354;
        // ---------- Original Method ----------
        //return new ComponentName(
                //mService.serviceInfo.packageName, mService.serviceInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.488 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "55C6E26016D1FF08C0DDDACA6F992F80")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_789542349 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_789542349 = mService.serviceInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_789542349.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_789542349;
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.488 -0400", hash_original_method = "2F472510FA9E87ADC65F29887FB84501", hash_generated_method = "A06D3D0929585487CD60797ED6A8E14C")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mLabel);
        dest.writeString(mId);
        dest.writeString(mSettingsActivityName);
        mService.writeToParcel(dest, flags);
        dest.writeTypedList(mSubtypes);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mLabel);
        //dest.writeString(mId);
        //dest.writeString(mSettingsActivityName);
        //mService.writeToParcel(dest, flags);
        //dest.writeTypedList(mSubtypes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.489 -0400", hash_original_method = "440496C0C039EAF57937C0E12546E16A", hash_generated_method = "92871E7E8F608427B46F7641CE1120F5")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1578128015 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2059180027 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_1578128015 = "";
        varB4EAC82CA7396A68D541C85D26508E83_2059180027 = pm.getText(getPackageName(), mLabel, mService.serviceInfo.applicationInfo);
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1217725720; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1217725720 = varB4EAC82CA7396A68D541C85D26508E83_1578128015;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1217725720 = varB4EAC82CA7396A68D541C85D26508E83_2059180027;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1217725720.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1217725720;
        // ---------- Original Method ----------
        //if (mLabel == 0 || pm == null) return "";
        //return pm.getText(getPackageName(), mLabel, mService.serviceInfo.applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.497 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "4C199677E004318A999655261296139B")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_518614537 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_518614537 = mService.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_518614537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_518614537;
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.497 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "85257DD941A3F2722818C0D969BC48AB")
    public ServiceInfo getServiceInfo() {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_1824947156 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1824947156 = mService.serviceInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1824947156.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1824947156;
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.498 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "466C7347F31062C49131703D6D6E83DB")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_542187238 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_542187238 = mSettingsActivityName;
        varB4EAC82CA7396A68D541C85D26508E83_542187238.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_542187238;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.499 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "3D2A3433A18F0B9EC0786D533F957659")
    public int getSubtypeCount() {
        int var2A2E26F2E1FE9603006EE3A64DF7EF6B_24994691 = (mSubtypes.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477724032 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_477724032;
        // ---------- Original Method ----------
        //return mSubtypes.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.499 -0400", hash_original_method = "A5CD061EE9765DD17A95FDAD389682DB", hash_generated_method = "A57863D58E5A0BB7A49739B9DE8BC6BF")
    public SpellCheckerSubtype getSubtypeAt(int index) {
        SpellCheckerSubtype varB4EAC82CA7396A68D541C85D26508E83_85083565 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_85083565 = mSubtypes.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_85083565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_85083565;
        // ---------- Original Method ----------
        //return mSubtypes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.499 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F1D6792EDA2F3268F16994E51B4AE21C")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1791477878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1791477878;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.499 -0400", hash_original_field = "58FAD4C7527ECEFE39EC0BB22BC5051B", hash_generated_field = "601B4D0DF6336CE3D17946758A0E7CEE")

    private static String TAG = SpellCheckerInfo.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:56.499 -0400", hash_original_field = "7A612228AEBA5D53B0643FEBD5AE3BB8", hash_generated_field = "3A3EE9B5EE70A014F29E533D3D1BDF90")

    public static final Parcelable.Creator<SpellCheckerInfo> CREATOR
            = new Parcelable.Creator<SpellCheckerInfo>() {
        @Override
        public SpellCheckerInfo createFromParcel(Parcel source) {
            return new SpellCheckerInfo(source);
        }

        @Override
        public SpellCheckerInfo[] newArray(int size) {
            return new SpellCheckerInfo[size];
        }
    };
}

