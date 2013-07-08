package android.view.textservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.346 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "47A49524DB3D9D5011E27A061CD906FB")

    private ResolveInfo mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.346 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "34D624C7CD290D72B15AB814BF1BA854")

    private String mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.346 -0400", hash_original_field = "D9334C2D55F77CE82F97CD28EFAAD24C", hash_generated_field = "288F27297FDE0055206DB25B18D34AF5")

    private int mLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.346 -0400", hash_original_field = "A7226C9DD6CAE5D50DDA70DBC0A93E5E", hash_generated_field = "3227A556BB8D91CC368DE162089FC968")

    private String mSettingsActivityName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.347 -0400", hash_original_field = "58B4845692446C00D28E793F604359BA", hash_generated_field = "116F12542346011C049323E2C901D79E")

    private final ArrayList<SpellCheckerSubtype> mSubtypes = new ArrayList<SpellCheckerSubtype>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.348 -0400", hash_original_method = "6A25F08819F54F2E6B313A58A8CE6D90", hash_generated_method = "8120EBA47C8810A27D9226B059F4A2FA")
    public  SpellCheckerInfo(Context context, ResolveInfo service) throws XmlPullParserException, IOException {
        mService = service;
        ServiceInfo si = service.serviceInfo;
        mId = new ComponentName(si.packageName, si.name).flattenToShortString();
        final PackageManager pm = context.getPackageManager();
        int label = 0;
        String settingsActivityComponent = null;
        XmlResourceParser parser = null;
        try 
        {
            parser = si.loadXmlMetaData(pm, SpellCheckerSession.SERVICE_META_DATA);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("No "
                        + SpellCheckerSession.SERVICE_META_DATA + " meta-data");
            } 
            final Resources res = pm.getResourcesForApplication(si.applicationInfo);
            final AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_730601334 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } 
            final String nodeName = parser.getName();
            {
                boolean varB5CFADE7245E4FEF78AB00B840C32F3B_1696735429 = (!"spell-checker".equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Meta-data does not start with spell-checker tag");
                } 
            } 
            TypedArray sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.SpellChecker);
            label = sa.getResourceId(com.android.internal.R.styleable.SpellChecker_label, 0);
            settingsActivityComponent = sa.getString(
                    com.android.internal.R.styleable.SpellChecker_settingsActivity);
            sa.recycle();
            final int depth = parser.getDepth();
            {
                boolean var3BCD25E42C06A3F4443E39624F08B54A_1877177194 = (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT);
                {
                    {
                        final String subtypeNodeName = parser.getName();
                        {
                            boolean var5F9B3D3FE3DCD3142E05F57C429CD825_697988163 = (!"subtype".equals(subtypeNodeName));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                                "Meta-data in spell-checker does not start with subtype tag");
                            } 
                        } 
                        final TypedArray a = res.obtainAttributes(
                            attrs, com.android.internal.R.styleable.SpellChecker_Subtype);
                        SpellCheckerSubtype subtype = new SpellCheckerSubtype(
                            a.getResourceId(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_label, 0),
                            a.getString(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_subtypeLocale),
                            a.getString(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_subtypeExtraValue));
                        mSubtypes.add(subtype);
                    } 
                } 
            } 
        } 
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
        } 
        finally 
        {
            parser.close();
        } 
        mLabel = label;
        mSettingsActivityName = settingsActivityComponent;
        addTaint(context.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.348 -0400", hash_original_method = "D0DF2452D02A3DC9C8E7C8BB825D11D4", hash_generated_method = "C0D8D8F6984FB63466EE4BBD97721CF4")
    public  SpellCheckerInfo(Parcel source) {
        mLabel = source.readInt();
        mId = source.readString();
        mSettingsActivityName = source.readString();
        mService = ResolveInfo.CREATOR.createFromParcel(source);
        source.readTypedList(mSubtypes, SpellCheckerSubtype.CREATOR);
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.349 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "B59860F0541885FC6C96D873BA85F328")
    public String getId() {
        String varB4EAC82CA7396A68D541C85D26508E83_992484029 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_992484029 = mId;
        varB4EAC82CA7396A68D541C85D26508E83_992484029.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_992484029;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.350 -0400", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "0A0FEDA92AAB1307D27DC59C0D71026B")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1352120255 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1352120255 = new ComponentName(
                mService.serviceInfo.packageName, mService.serviceInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_1352120255.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1352120255;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.351 -0400", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "94DE522BD985B0A8409969A2499C3F34")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_148437986 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_148437986 = mService.serviceInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_148437986.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_148437986;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.351 -0400", hash_original_method = "2F472510FA9E87ADC65F29887FB84501", hash_generated_method = "A06D3D0929585487CD60797ED6A8E14C")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mLabel);
        dest.writeString(mId);
        dest.writeString(mSettingsActivityName);
        mService.writeToParcel(dest, flags);
        dest.writeTypedList(mSubtypes);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.352 -0400", hash_original_method = "440496C0C039EAF57937C0E12546E16A", hash_generated_method = "9078FAD1C36DCCFD9203DDEEF3C39EBE")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_31444712 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1921237592 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_31444712 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1921237592 = pm.getText(getPackageName(), mLabel, mService.serviceInfo.applicationInfo);
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1653543028; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1653543028 = varB4EAC82CA7396A68D541C85D26508E83_31444712;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1653543028 = varB4EAC82CA7396A68D541C85D26508E83_1921237592;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1653543028.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1653543028;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.352 -0400", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "17B5346015AE61E90222E0FA9AC14189")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_299117744 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_299117744 = mService.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_299117744.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_299117744;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.353 -0400", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "A684532516BD3542A2AE6868CED1D5B1")
    public ServiceInfo getServiceInfo() {
        ServiceInfo varB4EAC82CA7396A68D541C85D26508E83_1655255538 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1655255538 = mService.serviceInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1655255538.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1655255538;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.353 -0400", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "861EE5347B3FC0680304F4A976AC75A4")
    public String getSettingsActivity() {
        String varB4EAC82CA7396A68D541C85D26508E83_1505974517 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1505974517 = mSettingsActivityName;
        varB4EAC82CA7396A68D541C85D26508E83_1505974517.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1505974517;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.353 -0400", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "51EEE144125B1D6050322892D1C8A582")
    public int getSubtypeCount() {
        int var2A2E26F2E1FE9603006EE3A64DF7EF6B_1606791154 = (mSubtypes.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089279559 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2089279559;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.354 -0400", hash_original_method = "A5CD061EE9765DD17A95FDAD389682DB", hash_generated_method = "E866E1C55E7111C03DA4A4F73AB9EE63")
    public SpellCheckerSubtype getSubtypeAt(int index) {
        SpellCheckerSubtype varB4EAC82CA7396A68D541C85D26508E83_1917874592 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1917874592 = mSubtypes.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1917874592.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1917874592;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.354 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C6612F2225D0BD719856A07579C6FF1D")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536374914 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_536374914;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.354 -0400", hash_original_field = "58FAD4C7527ECEFE39EC0BB22BC5051B", hash_generated_field = "B9C780B55162E0EEA102B93C8BE1103A")

    private static final String TAG = SpellCheckerInfo.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.354 -0400", hash_original_field = "7A612228AEBA5D53B0643FEBD5AE3BB8", hash_generated_field = "3A3EE9B5EE70A014F29E533D3D1BDF90")

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

