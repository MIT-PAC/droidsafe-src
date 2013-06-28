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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.832 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "2D4BD551D6F35F2FF0B83E0BB38D3A72")

    ResolveInfo mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.832 -0400", hash_original_field = "807A18BD291896E7D3B58F90DB9F75FD", hash_generated_field = "03850172BDDB3583B6C36063C483BA26")

    boolean mVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.832 -0400", hash_original_field = "930676CBE49D17827359BC4BBABCE218", hash_generated_field = "1401AC0E78CE2E5B04FC90A3723E0EBA")

    int mUsesPolicies;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.833 -0400", hash_original_method = "DA2A583494497907A2E88C8448FC887F", hash_generated_method = "328B8475C34A16960DD8A1D243B85E9C")
    public  DeviceAdminInfo(Context context, ResolveInfo receiver) throws XmlPullParserException, IOException {
        mReceiver = receiver;
        ActivityInfo ai = receiver.activityInfo;
        PackageManager pm = context.getPackageManager();
        XmlResourceParser parser = null;
        try 
        {
            parser = ai.loadXmlMetaData(pm, DeviceAdminReceiver.DEVICE_ADMIN_META_DATA);
            {
                if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("No "
                        + DeviceAdminReceiver.DEVICE_ADMIN_META_DATA + " meta-data");
            } //End block
            Resources res = pm.getResourcesForApplication(ai.applicationInfo);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            {
                boolean var995057C222283DCE9E465AE35974357A_1140508331 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName = parser.getName();
            {
                boolean varBDC9FBA0FE68CEEC67E40AC42EB09865_165295693 = (!"device-admin".equals(nodeName));
                {
                    if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException(
                        "Meta-data does not start with device-admin tag");
                } //End block
            } //End collapsed parenthetic
            TypedArray sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.DeviceAdmin);
            mVisible = sa.getBoolean(
                    com.android.internal.R.styleable.DeviceAdmin_visible, true);
            sa.recycle();
            int outerDepth = parser.getDepth();
            {
                boolean var8956F460685E7D17F4EB87103FD834D7_1080496353 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                   && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
                {
                    String tagName = parser.getName();
                    {
                        boolean varBB2EC4F1FAE99CCAACDF1005EBC6FBF7_319856453 = (tagName.equals("uses-policies"));
                        {
                            int innerDepth = parser.getDepth();
                            {
                                boolean var554531EF1BF3152A9E18038DDC877C21_955461243 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                           && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth));
                                {
                                    String policyName = parser.getName();
                                    Integer val = sKnownPolicies.get(policyName);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.834 -0400", hash_original_method = "63AFCAD0BD5EA5852A2B80B7C90D81EC", hash_generated_method = "BB2740E4F064F8E201F116E2693410B2")
      DeviceAdminInfo(Parcel source) {
        mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        mUsesPolicies = source.readInt();
        // ---------- Original Method ----------
        //mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        //mUsesPolicies = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.835 -0400", hash_original_method = "15D7F1C05476F5ABD61BE7FA06DD15FF", hash_generated_method = "2E85565EF34E340C0C2FD73AF5B4111B")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1300015829 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1300015829 = mReceiver.activityInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_1300015829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1300015829;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.836 -0400", hash_original_method = "DA104755B25D83C27775D5E8DE9A1BBA", hash_generated_method = "40A515F80D6ED29E6A0AF6FCB2AB1D6C")
    public String getReceiverName() {
        String varB4EAC82CA7396A68D541C85D26508E83_578242418 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_578242418 = mReceiver.activityInfo.name;
        varB4EAC82CA7396A68D541C85D26508E83_578242418.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_578242418;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.837 -0400", hash_original_method = "841DC64081A3A73FAF123BE852CFB557", hash_generated_method = "C4DE542067D3B85A52FDB894FDD9F9DE")
    public ActivityInfo getActivityInfo() {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_1932643556 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1932643556 = mReceiver.activityInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1932643556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1932643556;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.838 -0400", hash_original_method = "D8CD91DC98C1B02E60FA507EA4460E94", hash_generated_method = "19AD680D94D6623F17DD9D96812F3EB5")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_701740722 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_701740722 = new ComponentName(mReceiver.activityInfo.packageName,
                mReceiver.activityInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_701740722.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_701740722;
        // ---------- Original Method ----------
        //return new ComponentName(mReceiver.activityInfo.packageName,
                //mReceiver.activityInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.839 -0400", hash_original_method = "4FE582D960848B41E26F8E6C418819DF", hash_generated_method = "E947B3D19AA1147B0247DACC3F779509")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1168980385 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1168980385 = mReceiver.loadLabel(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1168980385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1168980385;
        // ---------- Original Method ----------
        //return mReceiver.loadLabel(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.840 -0400", hash_original_method = "0302FD8CF05010F5CDB923C74BE177F9", hash_generated_method = "1A204FDC7A70D27BF5265B8C1F900D30")
    public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1191363425 = null; //Variable for return #1
        {
            String packageName = mReceiver.resolvePackageName;
            ApplicationInfo applicationInfo = null;
            {
                packageName = mReceiver.activityInfo.packageName;
                applicationInfo = mReceiver.activityInfo.applicationInfo;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1191363425 = pm.getText(packageName,
                    mReceiver.activityInfo.descriptionRes, applicationInfo);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException();
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1191363425.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1191363425;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.841 -0400", hash_original_method = "0A539B1C4B2E8E617EDD9C83DE1E1B83", hash_generated_method = "AFE7EC34117A0CB4426B30DF86863CEF")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_262362135 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_262362135 = mReceiver.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_262362135.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_262362135;
        // ---------- Original Method ----------
        //return mReceiver.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.842 -0400", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "116561B8AB5301A4EBE4DFD20B2ACDEB")
    public boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_534638715 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_534638715;
        // ---------- Original Method ----------
        //return mVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.842 -0400", hash_original_method = "E08C907F6F855F797C3DCE0727348F6B", hash_generated_method = "257A38FA2E443E305E88E9BF0C43540A")
    public boolean usesPolicy(int policyIdent) {
        addTaint(policyIdent);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_372708478 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_372708478;
        // ---------- Original Method ----------
        //return (mUsesPolicies & (1<<policyIdent)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.843 -0400", hash_original_method = "535AB0E7EF604572B28232B709525301", hash_generated_method = "37DC480A4FE710D8A84051E7B4653C43")
    public String getTagForPolicy(int policyIdent) {
        String varB4EAC82CA7396A68D541C85D26508E83_102194484 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_102194484 = sRevKnownPolicies.get(policyIdent).tag;
        addTaint(policyIdent);
        varB4EAC82CA7396A68D541C85D26508E83_102194484.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_102194484;
        // ---------- Original Method ----------
        //return sRevKnownPolicies.get(policyIdent).tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.844 -0400", hash_original_method = "ED92B1C7E9AB1C3DE434E84362F61420", hash_generated_method = "8BC3D0557E67C0925D0C50ACCFA7F1C0")
    public ArrayList<PolicyInfo> getUsedPolicies() {
        ArrayList<PolicyInfo> varB4EAC82CA7396A68D541C85D26508E83_663302688 = null; //Variable for return #1
        ArrayList<PolicyInfo> res = new ArrayList<PolicyInfo>();
        {
            int i = 0;
            boolean varF1005D5C6AE4E2221C992F4E4F8202F3_65745586 = (i<sPoliciesDisplayOrder.size());
            {
                PolicyInfo pi = sPoliciesDisplayOrder.get(i);
                {
                    boolean varEC2D8F41B9495C03BBAAB789B6756C67_1621368155 = (usesPolicy(pi.ident));
                    {
                        res.add(pi);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_663302688 = res;
        varB4EAC82CA7396A68D541C85D26508E83_663302688.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_663302688;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.845 -0400", hash_original_method = "9540BEA2A1ABEB78FD332A0993AE68E4", hash_generated_method = "191DEE2CB5502CCB12D96C521844C486")
    public void writePoliciesToXml(XmlSerializer out) throws IllegalArgumentException, IllegalStateException, IOException {
        out.attribute(null, "flags", Integer.toString(mUsesPolicies));
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.attribute(null, "flags", Integer.toString(mUsesPolicies));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.846 -0400", hash_original_method = "8AE790C821B5E4F39ADC01FFE00626E1", hash_generated_method = "8C9590F7F9DB5EE5A22B3E48C1DCA69F")
    public void readPoliciesFromXml(XmlPullParser parser) throws XmlPullParserException, IOException {
        mUsesPolicies = Integer.parseInt(
                parser.getAttributeValue(null, "flags"));
        // ---------- Original Method ----------
        //mUsesPolicies = Integer.parseInt(
                //parser.getAttributeValue(null, "flags"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.846 -0400", hash_original_method = "B6CA0FCEADAF7A26300AC5E399081259", hash_generated_method = "88FFD06078DA5A57E9EC5F71341D3FD9")
    public void dump(Printer pw, String prefix) {
        pw.println(prefix + "Receiver:");
        mReceiver.dump(pw, prefix + "  ");
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //pw.println(prefix + "Receiver:");
        //mReceiver.dump(pw, prefix + "  ");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.848 -0400", hash_original_method = "337DF8B9CB781ADE72580EF8EE42E4C5", hash_generated_method = "46FD8285CF937711B0EC7733CC032571")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_846141287 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_846141287 = "DeviceAdminInfo{" + mReceiver.activityInfo.name + "}";
        varB4EAC82CA7396A68D541C85D26508E83_846141287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_846141287;
        // ---------- Original Method ----------
        //return "DeviceAdminInfo{" + mReceiver.activityInfo.name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.849 -0400", hash_original_method = "3425AE1C08CE1294933DDD04C3D7531A", hash_generated_method = "E4F4365FB5AB73A9C0DFE6CD20A0CCC3")
    public void writeToParcel(Parcel dest, int flags) {
        mReceiver.writeToParcel(dest, flags);
        dest.writeInt(mUsesPolicies);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //mReceiver.writeToParcel(dest, flags);
        //dest.writeInt(mUsesPolicies);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.850 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "88C13ED1AE7E78BC5B78447A7AA7DE74")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935234763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935234763;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class PolicyInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.850 -0400", hash_original_field = "67217D8B401CF5E72BBF5103D60F3E97", hash_generated_field = "3ED5BE6AB29FB35B15159E9F367B83D4")

        public int ident;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.850 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

        public String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.850 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "4E631ABECBB784587134D99CABB6D578")

        public int label;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.850 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "5C8D64BE7911844358CFF2EE4DECE98F")

        public int description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.851 -0400", hash_original_method = "A90CA239E6D53FEA8EFED1E11D7512A4", hash_generated_method = "E3787431209518667B6BC2676B74AB95")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.851 -0400", hash_original_field = "BFCAA000FE160E5F7BB766375D4ADD22", hash_generated_field = "EF54ADA6F74B065C52190993EC3B85DD")

    static final String TAG = "DeviceAdminInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.851 -0400", hash_original_field = "725F9C73A34DE547E47E4F7957A81C07", hash_generated_field = "E9DCD048F5A6CCC8DFE12FD941C198E5")

    public static final int USES_POLICY_LIMIT_PASSWORD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.851 -0400", hash_original_field = "863AD8CC348C390802665805D24E874C", hash_generated_field = "AE5A988FA3BA388E907590C417363EE7")

    public static final int USES_POLICY_WATCH_LOGIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.851 -0400", hash_original_field = "F52E3BCB4ED41E03A7E379585CCAC4B1", hash_generated_field = "7F4234536F6741F04549A2277B1EFC5E")

    public static final int USES_POLICY_RESET_PASSWORD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.851 -0400", hash_original_field = "2D4E9DF54EDA4FED3ECE31EC26594C58", hash_generated_field = "067F511682A4B373E6E879C62919F307")

    public static final int USES_POLICY_FORCE_LOCK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.852 -0400", hash_original_field = "FA1308E3ECDDE25A3B149A68AA49ED37", hash_generated_field = "CA3D915D2D1C7DC903035A2E3ADB84C8")

    public static final int USES_POLICY_WIPE_DATA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.852 -0400", hash_original_field = "3152B4EA535C17578AB6AC3680C46D2A", hash_generated_field = "BF7504138BD4B0F7F20156F0A1C27890")

    public static final int USES_POLICY_SETS_GLOBAL_PROXY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.852 -0400", hash_original_field = "EFE987220A950F180042948AD0FA3113", hash_generated_field = "649F755854D82F65F45D4A5450A5B1C1")

    public static final int USES_POLICY_EXPIRE_PASSWORD = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.852 -0400", hash_original_field = "C0622E07B90C8132AC5B5273F8C8C15B", hash_generated_field = "62C8687D0FBBB6D1C4927BFFEC3671FA")

    public static final int USES_ENCRYPTED_STORAGE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.852 -0400", hash_original_field = "3029FC1DEC6F43C637710C1A1A244931", hash_generated_field = "AD7A455AB97C1169FE5F3ADEFB8A2B45")

    public static final int USES_POLICY_DISABLE_CAMERA = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.852 -0400", hash_original_field = "4CA518A70763CEC212339FA5C9F3C3A9", hash_generated_field = "5BE1EFEEF690A563A986877DACAE99BD")

    static ArrayList<PolicyInfo> sPoliciesDisplayOrder = new ArrayList<PolicyInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.852 -0400", hash_original_field = "3C158DA5DE0145AF6111C2405D7D5C4F", hash_generated_field = "33B4C32B2D5C5AE03E24E067E342238A")

    static HashMap<String, Integer> sKnownPolicies = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.852 -0400", hash_original_field = "4E7CC588DEF8602DA2222A5E6E3CA75D", hash_generated_field = "154BC990F414FCC0C38CFD009DD9E193")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.852 -0400", hash_original_field = "8388F181CBDE36845D31A8253E2A0818", hash_generated_field = "AE364B217CEEC3B0E90343DDAC8BFCA3")

    public static final Parcelable.Creator<DeviceAdminInfo> CREATOR =
            new Parcelable.Creator<DeviceAdminInfo>() {
        public DeviceAdminInfo createFromParcel(Parcel source) {
            return new DeviceAdminInfo(source);
        }

        public DeviceAdminInfo[] newArray(int size) {
            return new DeviceAdminInfo[size];
        }
    };
    // orphaned legacy method
    public DeviceAdminInfo createFromParcel(Parcel source) {
            return new DeviceAdminInfo(source);
        }
    
    // orphaned legacy method
    public DeviceAdminInfo[] newArray(int size) {
            return new DeviceAdminInfo[size];
        }
    
}

