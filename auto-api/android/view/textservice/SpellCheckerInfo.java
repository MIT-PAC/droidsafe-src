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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.555 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "47A49524DB3D9D5011E27A061CD906FB")

    private ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.556 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "34D624C7CD290D72B15AB814BF1BA854")

    private String mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.556 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "288F27297FDE0055206DB25B18D34AF5")

    private int mLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.556 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "3227A556BB8D91CC368DE162089FC968")

    private String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.556 -0400", hash_original_field = "58B4845692446C00D28E793F604359BA", hash_generated_field = "5C2B208B40F45F16C055A65B066B3210")

    private ArrayList<SpellCheckerSubtype> mSubtypes = new ArrayList<SpellCheckerSubtype>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.559 -0400", hash_original_method = "6A25F08819F54F2E6B313A58A8CE6D90", hash_generated_method = "015A95C1ADE73E87091CE8CFF2898C8C")
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
                boolean var995057C222283DCE9E465AE35974357A_145880885 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean varB5CFADE7245E4FEF78AB00B840C32F3B_363971442 = (!"spell-checker".equals(nodeName));
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
                boolean var3BCD25E42C06A3F4443E39624F08B54A_1059010818 = (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT);
                {
                    {
                        String subtypeNodeName;
                        subtypeNodeName = parser.getName();
                        {
                            boolean var5F9B3D3FE3DCD3142E05F57C429CD825_967635481 = (!"subtype".equals(subtypeNodeName));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.570 -0400", hash_original_method = "D0DF2452D02A3DC9C8E7C8BB825D11D4", hash_generated_method = "C0D8D8F6984FB63466EE4BBD97721CF4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.571 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "8DF2D537D7D322EB1D2BF58248F3D3A1")
    public String getId() {
        String varB4EAC82CA7396A68D541C85D26508E83_413764172 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_413764172 = mId;
        varB4EAC82CA7396A68D541C85D26508E83_413764172.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_413764172;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.571 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "8633574595FEC0093295335A56CDF0B7")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1312537537 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1312537537 = new ComponentName(
                mService.serviceInfo.packageName, mService.serviceInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_1312537537.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1312537537;
        // ---------- Original Method ----------
        //return new ComponentName(
                //mService.serviceInfo.packageName, mService.serviceInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.572 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "156FDFB37F402EF9ED85D0A3B70363D4")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_963957534 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_963957534 = mService.serviceInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_963957534.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_963957534;
        // ---------- Original Method ----------
        //return mService.serviceInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.572 -0400", hash_original_method = "2F472510FA9E87ADC65F29887FB84501", hash_generated_method = "A06D3D0929585487CD60797ED6A8E14C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.584 -0400", hash_original_method = "440496C0C039EAF57937C0E12546E16A", hash_generated_method = "E6F0D7E1E47D3D1A4FBCEA2D9B15D26F")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_788440300 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2004169856 = null; //Variable for return #2
        varB4EAC82CA7396A68D541C85D26508E83_788440300 = "";
        varB4EAC82CA7396A68D541C85D26508E83_2004169856 = pm.getText(getPackageName(), mLabel, mService.serviceInfo.applicationInfo);
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1849743382; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1849743382 = varB4EAC82CA7396A68D541C85D26508E83_788440300;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1849743382 = varB4EAC82CA7396A68D541C85D26508E83_2004169856;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1849743382.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1849743382;
        // ---------- Original Method ----------
        //if (mLabel == 0 || pm == null) return "";
        //return pm.getText(getPackageName(), mLabel, mService.serviceInfo.applicationInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.585 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "37BA26A43DB823F47F597EE606672924")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_736556080 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_736556080 = mService.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_736556080.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_736556080;
        // ---------- Original Method ----------
        //return mService.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.585 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "B579D11607BE7C64AA11B191DC5D58E2")
    public ServiceInfo getServiceInfo() {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_205886027 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_205886027 = mService.serviceInfo;
        varB4EAC82CA7396A68D541C85D26508E83_205886027.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_205886027;
        // ---------- Original Method ----------
        //return mService.serviceInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.586 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "B24619FB2599D98E72AC6BBD01F1AC5F")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_375723891 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_375723891 = mSettingsActivityName;
        varB4EAC82CA7396A68D541C85D26508E83_375723891.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_375723891;
        // ---------- Original Method ----------
        //return mSettingsActivityName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.586 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "B96CE59235F11244C9110514FC7F4019")
    public int getSubtypeCount() {
        int var2A2E26F2E1FE9603006EE3A64DF7EF6B_1431833462 = (mSubtypes.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111501750 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111501750;
        // ---------- Original Method ----------
        //return mSubtypes.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.586 -0400", hash_original_method = "A5CD061EE9765DD17A95FDAD389682DB", hash_generated_method = "9CAC40429CD6CE58D554BECBE211B7C5")
    public SpellCheckerSubtype getSubtypeAt(int index) {
        SpellCheckerSubtype varB4EAC82CA7396A68D541C85D26508E83_837499475 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_837499475 = mSubtypes.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_837499475.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_837499475;
        // ---------- Original Method ----------
        //return mSubtypes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.588 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "F45A39C59A88F2F5D47A171A1E664132")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125744158 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_125744158;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.588 -0400", hash_original_field = "58FAD4C7527ECEFE39EC0BB22BC5051B", hash_generated_field = "601B4D0DF6336CE3D17946758A0E7CEE")

    private static String TAG = SpellCheckerInfo.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:58.588 -0400", hash_original_field = "7A612228AEBA5D53B0643FEBD5AE3BB8", hash_generated_field = "3A3EE9B5EE70A014F29E533D3D1BDF90")

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

