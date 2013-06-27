package android.app.admin;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Printer;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public final class DeviceAdminInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.797 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "2D4BD551D6F35F2FF0B83E0BB38D3A72")

    ResolveInfo mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.798 -0400", hash_original_field = "807A18BD291896E7D3B58F90DB9F75FD", hash_generated_field = "03850172BDDB3583B6C36063C483BA26")

    boolean mVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.799 -0400", hash_original_field = "930676CBE49D17827359BC4BBABCE218", hash_generated_field = "1401AC0E78CE2E5B04FC90A3723E0EBA")

    int mUsesPolicies;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.827 -0400", hash_original_method = "DA2A583494497907A2E88C8448FC887F", hash_generated_method = "5A1E5BD3AE8C2EA7EB497BDA8D3FB51B")
    public  DeviceAdminInfo(Context context, ResolveInfo receiver) throws XmlPullParserException, IOException {
        mReceiver = receiver;
        ActivityInfo ai;
        ai = receiver.activityInfo;
        PackageManager pm;
        pm = context.getPackageManager();
        XmlResourceParser parser;
        parser = null;
        try 
        {
            parser = ai.loadXmlMetaData(pm, DeviceAdminReceiver.DEVICE_ADMIN_META_DATA);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("No "
                        + DeviceAdminReceiver.DEVICE_ADMIN_META_DATA + " meta-data");
            } //End block
            Resources res;
            res = pm.getResourcesForApplication(ai.applicationInfo);
            AttributeSet attrs;
            attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_170834029 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean varBDC9FBA0FE68CEEC67E40AC42EB09865_801751461 = (!"device-admin".equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Meta-data does not start with device-admin tag");
                } //End block
            } //End collapsed parenthetic
            TypedArray sa;
            sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.DeviceAdmin);
            mVisible = sa.getBoolean(
                    com.android.internal.R.styleable.DeviceAdmin_visible, true);
            sa.recycle();
            int outerDepth;
            outerDepth = parser.getDepth();
            {
                boolean var8956F460685E7D17F4EB87103FD834D7_1326120624 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                   && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
                {
                    String tagName;
                    tagName = parser.getName();
                    {
                        boolean varBB2EC4F1FAE99CCAACDF1005EBC6FBF7_571258909 = (tagName.equals("uses-policies"));
                        {
                            int innerDepth;
                            innerDepth = parser.getDepth();
                            {
                                boolean var554531EF1BF3152A9E18038DDC877C21_1257666076 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                           && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth));
                                {
                                    String policyName;
                                    policyName = parser.getName();
                                    Integer val;
                                    val = sKnownPolicies.get(policyName);
                                    {
                                        mUsesPolicies |= 1 << val.intValue();
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (NameNotFoundException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                    "Unable to create context for: " + ai.packageName);
        } //End block
        finally 
        {
            parser.close();
        } //End block
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.832 -0400", hash_original_method = "63AFCAD0BD5EA5852A2B80B7C90D81EC", hash_generated_method = "BB2740E4F064F8E201F116E2693410B2")
      DeviceAdminInfo(Parcel source) {
        mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        mUsesPolicies = source.readInt();
        // ---------- Original Method ----------
        //mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        //mUsesPolicies = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.861 -0400", hash_original_method = "15D7F1C05476F5ABD61BE7FA06DD15FF", hash_generated_method = "EF944F914F47A5767EBF204A3F7C7B15")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2144357245 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2144357245 = mReceiver.activityInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_2144357245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2144357245;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.864 -0400", hash_original_method = "DA104755B25D83C27775D5E8DE9A1BBA", hash_generated_method = "83530D0D3C9C42F8E4BF3785B7D28088")
    public String getReceiverName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1623748918 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1623748918 = mReceiver.activityInfo.name;
        varB4EAC82CA7396A68D541C85D26508E83_1623748918.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1623748918;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.879 -0400", hash_original_method = "841DC64081A3A73FAF123BE852CFB557", hash_generated_method = "D53BB9D058FB79C7E542C611440BAC9C")
    public ActivityInfo getActivityInfo() {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_1849740515 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1849740515 = mReceiver.activityInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1849740515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1849740515;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.890 -0400", hash_original_method = "D8CD91DC98C1B02E60FA507EA4460E94", hash_generated_method = "4A769EB29A4E9B7A830D93334C3EB5AE")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_132654569 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_132654569 = new ComponentName(mReceiver.activityInfo.packageName,
                mReceiver.activityInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_132654569.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_132654569;
        // ---------- Original Method ----------
        //return new ComponentName(mReceiver.activityInfo.packageName,
                //mReceiver.activityInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.909 -0400", hash_original_method = "4FE582D960848B41E26F8E6C418819DF", hash_generated_method = "5BE6058ABDE022BD1FDE84EFC65F3D86")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1851745492 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1851745492 = mReceiver.loadLabel(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1851745492.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1851745492;
        // ---------- Original Method ----------
        //return mReceiver.loadLabel(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.930 -0400", hash_original_method = "0302FD8CF05010F5CDB923C74BE177F9", hash_generated_method = "A1C6494A68BD43ECEB12833B750971E4")
    public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1700827007 = null; //Variable for return #1
        {
            String packageName;
            packageName = mReceiver.resolvePackageName;
            ApplicationInfo applicationInfo;
            applicationInfo = null;
            {
                packageName = mReceiver.activityInfo.packageName;
                applicationInfo = mReceiver.activityInfo.applicationInfo;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1700827007 = pm.getText(packageName,
                    mReceiver.activityInfo.descriptionRes, applicationInfo);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException();
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1700827007.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1700827007;
        // ---------- Original Method ----------
        //if (mReceiver.activityInfo.descriptionRes != 0) {
            //String packageName = mReceiver.resolvePackageName;
            //ApplicationInfo applicationInfo = null;
            //if (packageName == null) {
                //packageName = mReceiver.activityInfo.packageName;
                //applicationInfo = mReceiver.activityInfo.applicationInfo;
            //}
            //return pm.getText(packageName,
                    //mReceiver.activityInfo.descriptionRes, applicationInfo);
        //}
        //throw new NotFoundException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.935 -0400", hash_original_method = "0A539B1C4B2E8E617EDD9C83DE1E1B83", hash_generated_method = "66B95472B92CAD16A06D81C8C46AE5AE")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_456589825 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_456589825 = mReceiver.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_456589825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_456589825;
        // ---------- Original Method ----------
        //return mReceiver.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.955 -0400", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "C40CB5C23E8FD05CA1CA1211D2236CBD")
    public boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833204498 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_833204498;
        // ---------- Original Method ----------
        //return mVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.956 -0400", hash_original_method = "E08C907F6F855F797C3DCE0727348F6B", hash_generated_method = "BAF74BB0DC1426CFC5ED343CF19216F5")
    public boolean usesPolicy(int policyIdent) {
        addTaint(policyIdent);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1663259438 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1663259438;
        // ---------- Original Method ----------
        //return (mUsesPolicies & (1<<policyIdent)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.958 -0400", hash_original_method = "535AB0E7EF604572B28232B709525301", hash_generated_method = "32F57C18D611190E68A4D44E15CCF6E9")
    public String getTagForPolicy(int policyIdent) {
        String varB4EAC82CA7396A68D541C85D26508E83_883176078 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_883176078 = sRevKnownPolicies.get(policyIdent).tag;
        addTaint(policyIdent);
        varB4EAC82CA7396A68D541C85D26508E83_883176078.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_883176078;
        // ---------- Original Method ----------
        //return sRevKnownPolicies.get(policyIdent).tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.976 -0400", hash_original_method = "ED92B1C7E9AB1C3DE434E84362F61420", hash_generated_method = "562CD0A3F48F1EF0C50590666DAB3C53")
    public ArrayList<PolicyInfo> getUsedPolicies() {
        ArrayList<PolicyInfo> varB4EAC82CA7396A68D541C85D26508E83_897180046 = null; //Variable for return #1
        ArrayList<PolicyInfo> res;
        res = new ArrayList<PolicyInfo>();
        {
            int i;
            i = 0;
            boolean varF1005D5C6AE4E2221C992F4E4F8202F3_495088404 = (i<sPoliciesDisplayOrder.size());
            {
                PolicyInfo pi;
                pi = sPoliciesDisplayOrder.get(i);
                {
                    boolean varEC2D8F41B9495C03BBAAB789B6756C67_1349569151 = (usesPolicy(pi.ident));
                    {
                        res.add(pi);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_897180046 = res;
        varB4EAC82CA7396A68D541C85D26508E83_897180046.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_897180046;
        // ---------- Original Method ----------
        //ArrayList<PolicyInfo> res = new ArrayList<PolicyInfo>();
        //for (int i=0; i<sPoliciesDisplayOrder.size(); i++) {
            //PolicyInfo pi = sPoliciesDisplayOrder.get(i);
            //if (usesPolicy(pi.ident)) {
                //res.add(pi);
            //}
        //}
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.978 -0400", hash_original_method = "9540BEA2A1ABEB78FD332A0993AE68E4", hash_generated_method = "191DEE2CB5502CCB12D96C521844C486")
    public void writePoliciesToXml(XmlSerializer out) throws IllegalArgumentException, IllegalStateException, IOException {
        out.attribute(null, "flags", Integer.toString(mUsesPolicies));
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.attribute(null, "flags", Integer.toString(mUsesPolicies));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.980 -0400", hash_original_method = "8AE790C821B5E4F39ADC01FFE00626E1", hash_generated_method = "8C9590F7F9DB5EE5A22B3E48C1DCA69F")
    public void readPoliciesFromXml(XmlPullParser parser) throws XmlPullParserException, IOException {
        mUsesPolicies = Integer.parseInt(
                parser.getAttributeValue(null, "flags"));
        // ---------- Original Method ----------
        //mUsesPolicies = Integer.parseInt(
                //parser.getAttributeValue(null, "flags"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:55.998 -0400", hash_original_method = "B6CA0FCEADAF7A26300AC5E399081259", hash_generated_method = "88FFD06078DA5A57E9EC5F71341D3FD9")
    public void dump(Printer pw, String prefix) {
        pw.println(prefix + "Receiver:");
        mReceiver.dump(pw, prefix + "  ");
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //pw.println(prefix + "Receiver:");
        //mReceiver.dump(pw, prefix + "  ");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.000 -0400", hash_original_method = "337DF8B9CB781ADE72580EF8EE42E4C5", hash_generated_method = "49DD9E089F7C50AE97AEAB32AB284DB1")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_894436082 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_894436082 = "DeviceAdminInfo{" + mReceiver.activityInfo.name + "}";
        varB4EAC82CA7396A68D541C85D26508E83_894436082.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_894436082;
        // ---------- Original Method ----------
        //return "DeviceAdminInfo{" + mReceiver.activityInfo.name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.002 -0400", hash_original_method = "3425AE1C08CE1294933DDD04C3D7531A", hash_generated_method = "E4F4365FB5AB73A9C0DFE6CD20A0CCC3")
    public void writeToParcel(Parcel dest, int flags) {
        mReceiver.writeToParcel(dest, flags);
        dest.writeInt(mUsesPolicies);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //mReceiver.writeToParcel(dest, flags);
        //dest.writeInt(mUsesPolicies);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.021 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C974C4BFA147270D5D5C142BF5398C12")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1972052629 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1972052629;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class PolicyInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.021 -0400", hash_original_field = "67217D8B401CF5E72BBF5103D60F3E97", hash_generated_field = "3ED5BE6AB29FB35B15159E9F367B83D4")

        public int ident;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.022 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

        public String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.022 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "4E631ABECBB784587134D99CABB6D578")

        public int label;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.022 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "5C8D64BE7911844358CFF2EE4DECE98F")

        public int description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.042 -0400", hash_original_method = "A90CA239E6D53FEA8EFED1E11D7512A4", hash_generated_method = "E3787431209518667B6BC2676B74AB95")
        public  PolicyInfo(int identIn, String tagIn, int labelIn, int descriptionIn) {
            ident = identIn;
            tag = tagIn;
            label = labelIn;
            description = descriptionIn;
            // ---------- Original Method ----------
            //ident = identIn;
            //tag = tagIn;
            //label = labelIn;
            //description = descriptionIn;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.043 -0400", hash_original_field = "BFCAA000FE160E5F7BB766375D4ADD22", hash_generated_field = "DF04598A674670183FF59D6CD9647C8B")

    static String TAG = "DeviceAdminInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.044 -0400", hash_original_field = "725F9C73A34DE547E47E4F7957A81C07", hash_generated_field = "E9DCD048F5A6CCC8DFE12FD941C198E5")

    public static final int USES_POLICY_LIMIT_PASSWORD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.044 -0400", hash_original_field = "863AD8CC348C390802665805D24E874C", hash_generated_field = "AE5A988FA3BA388E907590C417363EE7")

    public static final int USES_POLICY_WATCH_LOGIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.059 -0400", hash_original_field = "F52E3BCB4ED41E03A7E379585CCAC4B1", hash_generated_field = "7F4234536F6741F04549A2277B1EFC5E")

    public static final int USES_POLICY_RESET_PASSWORD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.059 -0400", hash_original_field = "2D4E9DF54EDA4FED3ECE31EC26594C58", hash_generated_field = "067F511682A4B373E6E879C62919F307")

    public static final int USES_POLICY_FORCE_LOCK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.060 -0400", hash_original_field = "FA1308E3ECDDE25A3B149A68AA49ED37", hash_generated_field = "CA3D915D2D1C7DC903035A2E3ADB84C8")

    public static final int USES_POLICY_WIPE_DATA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.060 -0400", hash_original_field = "3152B4EA535C17578AB6AC3680C46D2A", hash_generated_field = "BF7504138BD4B0F7F20156F0A1C27890")

    public static final int USES_POLICY_SETS_GLOBAL_PROXY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.061 -0400", hash_original_field = "EFE987220A950F180042948AD0FA3113", hash_generated_field = "649F755854D82F65F45D4A5450A5B1C1")

    public static final int USES_POLICY_EXPIRE_PASSWORD = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.061 -0400", hash_original_field = "C0622E07B90C8132AC5B5273F8C8C15B", hash_generated_field = "62C8687D0FBBB6D1C4927BFFEC3671FA")

    public static final int USES_ENCRYPTED_STORAGE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.067 -0400", hash_original_field = "3029FC1DEC6F43C637710C1A1A244931", hash_generated_field = "AD7A455AB97C1169FE5F3ADEFB8A2B45")

    public static final int USES_POLICY_DISABLE_CAMERA = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.067 -0400", hash_original_field = "4CA518A70763CEC212339FA5C9F3C3A9", hash_generated_field = "5BE1EFEEF690A563A986877DACAE99BD")

    static ArrayList<PolicyInfo> sPoliciesDisplayOrder = new ArrayList<PolicyInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.068 -0400", hash_original_field = "3C158DA5DE0145AF6111C2405D7D5C4F", hash_generated_field = "33B4C32B2D5C5AE03E24E067E342238A")

    static HashMap<String, Integer> sKnownPolicies = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.069 -0400", hash_original_field = "4E7CC588DEF8602DA2222A5E6E3CA75D", hash_generated_field = "154BC990F414FCC0C38CFD009DD9E193")

    static SparseArray<PolicyInfo> sRevKnownPolicies = new SparseArray<PolicyInfo>();
    static {
        sPoliciesDisplayOrder.add(new PolicyInfo(USES_POLICY_WIPE_DATA, "wipe-data",
                com.android.internal.R.string.policylab_wipeData,
                com.android.internal.R.string.policydesc_wipeData));
        sPoliciesDisplayOrder.add(new PolicyInfo(USES_POLICY_RESET_PASSWORD, "reset-password",
                com.android.internal.R.string.policylab_resetPassword,
                com.android.internal.R.string.policydesc_resetPassword));
        sPoliciesDisplayOrder.add(new PolicyInfo(USES_POLICY_LIMIT_PASSWORD, "limit-password",
                com.android.internal.R.string.policylab_limitPassword,
                com.android.internal.R.string.policydesc_limitPassword));
        sPoliciesDisplayOrder.add(new PolicyInfo(USES_POLICY_WATCH_LOGIN, "watch-login",
                com.android.internal.R.string.policylab_watchLogin,
                com.android.internal.R.string.policydesc_watchLogin));
        sPoliciesDisplayOrder.add(new PolicyInfo(USES_POLICY_FORCE_LOCK, "force-lock",
                com.android.internal.R.string.policylab_forceLock,
                com.android.internal.R.string.policydesc_forceLock));
        sPoliciesDisplayOrder.add(new PolicyInfo(USES_POLICY_SETS_GLOBAL_PROXY, "set-global-proxy",
                com.android.internal.R.string.policylab_setGlobalProxy,
                com.android.internal.R.string.policydesc_setGlobalProxy));
        sPoliciesDisplayOrder.add(new PolicyInfo(USES_POLICY_EXPIRE_PASSWORD, "expire-password",
                com.android.internal.R.string.policylab_expirePassword,
                com.android.internal.R.string.policydesc_expirePassword));
        sPoliciesDisplayOrder.add(new PolicyInfo(USES_ENCRYPTED_STORAGE, "encrypted-storage",
                com.android.internal.R.string.policylab_encryptedStorage,
                com.android.internal.R.string.policydesc_encryptedStorage));
        sPoliciesDisplayOrder.add(new PolicyInfo(USES_POLICY_DISABLE_CAMERA, "disable-camera",
                com.android.internal.R.string.policylab_disableCamera,
                com.android.internal.R.string.policydesc_disableCamera));
        for (int i=0; i<sPoliciesDisplayOrder.size(); i++) {
            PolicyInfo pi = sPoliciesDisplayOrder.get(i);
            sRevKnownPolicies.put(pi.ident, pi);
            sKnownPolicies.put(pi.tag, pi.ident);
        }
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:56.079 -0400", hash_original_field = "8388F181CBDE36845D31A8253E2A0818", hash_generated_field = "AE364B217CEEC3B0E90343DDAC8BFCA3")

    public static final Parcelable.Creator<DeviceAdminInfo> CREATOR =
            new Parcelable.Creator<DeviceAdminInfo>() {
        public DeviceAdminInfo createFromParcel(Parcel source) {
            return new DeviceAdminInfo(source);
        }

        public DeviceAdminInfo[] newArray(int size) {
            return new DeviceAdminInfo[size];
        }
    };
}

