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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.040 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "2D4BD551D6F35F2FF0B83E0BB38D3A72")

    ResolveInfo mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.040 -0400", hash_original_field = "807A18BD291896E7D3B58F90DB9F75FD", hash_generated_field = "03850172BDDB3583B6C36063C483BA26")

    boolean mVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.041 -0400", hash_original_field = "930676CBE49D17827359BC4BBABCE218", hash_generated_field = "1401AC0E78CE2E5B04FC90A3723E0EBA")

    int mUsesPolicies;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.056 -0400", hash_original_method = "DA2A583494497907A2E88C8448FC887F", hash_generated_method = "8E2BAB5DAAC7CD8FF88C8E8DBCA3EA4F")
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
                boolean var995057C222283DCE9E465AE35974357A_1223595195 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean varBDC9FBA0FE68CEEC67E40AC42EB09865_540606947 = (!"device-admin".equals(nodeName));
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
                boolean var8956F460685E7D17F4EB87103FD834D7_460535341 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                   && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
                {
                    String tagName;
                    tagName = parser.getName();
                    {
                        boolean varBB2EC4F1FAE99CCAACDF1005EBC6FBF7_1791698121 = (tagName.equals("uses-policies"));
                        {
                            int innerDepth;
                            innerDepth = parser.getDepth();
                            {
                                boolean var554531EF1BF3152A9E18038DDC877C21_2004101394 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.078 -0400", hash_original_method = "63AFCAD0BD5EA5852A2B80B7C90D81EC", hash_generated_method = "BB2740E4F064F8E201F116E2693410B2")
      DeviceAdminInfo(Parcel source) {
        mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        mUsesPolicies = source.readInt();
        // ---------- Original Method ----------
        //mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        //mUsesPolicies = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.096 -0400", hash_original_method = "15D7F1C05476F5ABD61BE7FA06DD15FF", hash_generated_method = "1B087E63B8C4F7DF5BB553F679F99229")
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_262208796 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_262208796 = mReceiver.activityInfo.packageName;
        varB4EAC82CA7396A68D541C85D26508E83_262208796.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_262208796;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.106 -0400", hash_original_method = "DA104755B25D83C27775D5E8DE9A1BBA", hash_generated_method = "673263F92027FFE2C398C6D6E50DB6E5")
    public String getReceiverName() {
        String varB4EAC82CA7396A68D541C85D26508E83_419803305 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_419803305 = mReceiver.activityInfo.name;
        varB4EAC82CA7396A68D541C85D26508E83_419803305.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_419803305;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.118 -0400", hash_original_method = "841DC64081A3A73FAF123BE852CFB557", hash_generated_method = "3DCDE65DDE4F00D039550DFB3EC9D9C0")
    public ActivityInfo getActivityInfo() {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_1456421419 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1456421419 = mReceiver.activityInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1456421419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1456421419;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.143 -0400", hash_original_method = "D8CD91DC98C1B02E60FA507EA4460E94", hash_generated_method = "460A3E3197E6417F4DB87B88F1E43295")
    public ComponentName getComponent() {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1432013037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1432013037 = new ComponentName(mReceiver.activityInfo.packageName,
                mReceiver.activityInfo.name);
        varB4EAC82CA7396A68D541C85D26508E83_1432013037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1432013037;
        // ---------- Original Method ----------
        //return new ComponentName(mReceiver.activityInfo.packageName,
                //mReceiver.activityInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.165 -0400", hash_original_method = "4FE582D960848B41E26F8E6C418819DF", hash_generated_method = "77D853DAEAFFDD23528CEC55ACC4D229")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_49647174 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_49647174 = mReceiver.loadLabel(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_49647174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_49647174;
        // ---------- Original Method ----------
        //return mReceiver.loadLabel(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.187 -0400", hash_original_method = "0302FD8CF05010F5CDB923C74BE177F9", hash_generated_method = "E9C75C69041B90EC77D67B908A8A4470")
    public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1707208710 = null; //Variable for return #1
        {
            String packageName;
            packageName = mReceiver.resolvePackageName;
            ApplicationInfo applicationInfo;
            applicationInfo = null;
            {
                packageName = mReceiver.activityInfo.packageName;
                applicationInfo = mReceiver.activityInfo.applicationInfo;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1707208710 = pm.getText(packageName,
                    mReceiver.activityInfo.descriptionRes, applicationInfo);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException();
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1707208710.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1707208710;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.198 -0400", hash_original_method = "0A539B1C4B2E8E617EDD9C83DE1E1B83", hash_generated_method = "3FA906EC772B124DD12C952B1E5D6EC9")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_661852377 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_661852377 = mReceiver.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_661852377.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_661852377;
        // ---------- Original Method ----------
        //return mReceiver.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.216 -0400", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "1DB3EA8DCB26C12F56C57C24A84D7A32")
    public boolean isVisible() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1512201613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1512201613;
        // ---------- Original Method ----------
        //return mVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.234 -0400", hash_original_method = "E08C907F6F855F797C3DCE0727348F6B", hash_generated_method = "F8EAC0130F05ECDD404535307355437C")
    public boolean usesPolicy(int policyIdent) {
        addTaint(policyIdent);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_642012556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_642012556;
        // ---------- Original Method ----------
        //return (mUsesPolicies & (1<<policyIdent)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.236 -0400", hash_original_method = "535AB0E7EF604572B28232B709525301", hash_generated_method = "86BB5F12A1BBA25EC60B80B5E472D471")
    public String getTagForPolicy(int policyIdent) {
        String varB4EAC82CA7396A68D541C85D26508E83_119174579 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_119174579 = sRevKnownPolicies.get(policyIdent).tag;
        addTaint(policyIdent);
        varB4EAC82CA7396A68D541C85D26508E83_119174579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_119174579;
        // ---------- Original Method ----------
        //return sRevKnownPolicies.get(policyIdent).tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.261 -0400", hash_original_method = "ED92B1C7E9AB1C3DE434E84362F61420", hash_generated_method = "D1D3F7D20F32708A7EBC0C77438C2019")
    public ArrayList<PolicyInfo> getUsedPolicies() {
        ArrayList<PolicyInfo> varB4EAC82CA7396A68D541C85D26508E83_1924552232 = null; //Variable for return #1
        ArrayList<PolicyInfo> res;
        res = new ArrayList<PolicyInfo>();
        {
            int i;
            i = 0;
            boolean varF1005D5C6AE4E2221C992F4E4F8202F3_2142515972 = (i<sPoliciesDisplayOrder.size());
            {
                PolicyInfo pi;
                pi = sPoliciesDisplayOrder.get(i);
                {
                    boolean varEC2D8F41B9495C03BBAAB789B6756C67_916836263 = (usesPolicy(pi.ident));
                    {
                        res.add(pi);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1924552232 = res;
        varB4EAC82CA7396A68D541C85D26508E83_1924552232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1924552232;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.265 -0400", hash_original_method = "9540BEA2A1ABEB78FD332A0993AE68E4", hash_generated_method = "191DEE2CB5502CCB12D96C521844C486")
    public void writePoliciesToXml(XmlSerializer out) throws IllegalArgumentException, IllegalStateException, IOException {
        out.attribute(null, "flags", Integer.toString(mUsesPolicies));
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.attribute(null, "flags", Integer.toString(mUsesPolicies));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.278 -0400", hash_original_method = "8AE790C821B5E4F39ADC01FFE00626E1", hash_generated_method = "8C9590F7F9DB5EE5A22B3E48C1DCA69F")
    public void readPoliciesFromXml(XmlPullParser parser) throws XmlPullParserException, IOException {
        mUsesPolicies = Integer.parseInt(
                parser.getAttributeValue(null, "flags"));
        // ---------- Original Method ----------
        //mUsesPolicies = Integer.parseInt(
                //parser.getAttributeValue(null, "flags"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.301 -0400", hash_original_method = "B6CA0FCEADAF7A26300AC5E399081259", hash_generated_method = "88FFD06078DA5A57E9EC5F71341D3FD9")
    public void dump(Printer pw, String prefix) {
        pw.println(prefix + "Receiver:");
        mReceiver.dump(pw, prefix + "  ");
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //pw.println(prefix + "Receiver:");
        //mReceiver.dump(pw, prefix + "  ");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.304 -0400", hash_original_method = "337DF8B9CB781ADE72580EF8EE42E4C5", hash_generated_method = "91BAB0E7744CF4AB02520D8A26AE4D94")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1140876435 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1140876435 = "DeviceAdminInfo{" + mReceiver.activityInfo.name + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1140876435.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1140876435;
        // ---------- Original Method ----------
        //return "DeviceAdminInfo{" + mReceiver.activityInfo.name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.318 -0400", hash_original_method = "3425AE1C08CE1294933DDD04C3D7531A", hash_generated_method = "E4F4365FB5AB73A9C0DFE6CD20A0CCC3")
    public void writeToParcel(Parcel dest, int flags) {
        mReceiver.writeToParcel(dest, flags);
        dest.writeInt(mUsesPolicies);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //mReceiver.writeToParcel(dest, flags);
        //dest.writeInt(mUsesPolicies);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.319 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "231B8C3BAE12A11187E0F74324F9B774")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699724809 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1699724809;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class PolicyInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.320 -0400", hash_original_field = "67217D8B401CF5E72BBF5103D60F3E97", hash_generated_field = "3ED5BE6AB29FB35B15159E9F367B83D4")

        public int ident;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.320 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

        public String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.321 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "4E631ABECBB784587134D99CABB6D578")

        public int label;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.321 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "5C8D64BE7911844358CFF2EE4DECE98F")

        public int description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.347 -0400", hash_original_method = "A90CA239E6D53FEA8EFED1E11D7512A4", hash_generated_method = "E3787431209518667B6BC2676B74AB95")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.348 -0400", hash_original_field = "BFCAA000FE160E5F7BB766375D4ADD22", hash_generated_field = "DF04598A674670183FF59D6CD9647C8B")

    static String TAG = "DeviceAdminInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.348 -0400", hash_original_field = "725F9C73A34DE547E47E4F7957A81C07", hash_generated_field = "E9DCD048F5A6CCC8DFE12FD941C198E5")

    public static final int USES_POLICY_LIMIT_PASSWORD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.348 -0400", hash_original_field = "863AD8CC348C390802665805D24E874C", hash_generated_field = "AE5A988FA3BA388E907590C417363EE7")

    public static final int USES_POLICY_WATCH_LOGIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.349 -0400", hash_original_field = "F52E3BCB4ED41E03A7E379585CCAC4B1", hash_generated_field = "7F4234536F6741F04549A2277B1EFC5E")

    public static final int USES_POLICY_RESET_PASSWORD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.349 -0400", hash_original_field = "2D4E9DF54EDA4FED3ECE31EC26594C58", hash_generated_field = "067F511682A4B373E6E879C62919F307")

    public static final int USES_POLICY_FORCE_LOCK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.376 -0400", hash_original_field = "FA1308E3ECDDE25A3B149A68AA49ED37", hash_generated_field = "CA3D915D2D1C7DC903035A2E3ADB84C8")

    public static final int USES_POLICY_WIPE_DATA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.376 -0400", hash_original_field = "3152B4EA535C17578AB6AC3680C46D2A", hash_generated_field = "BF7504138BD4B0F7F20156F0A1C27890")

    public static final int USES_POLICY_SETS_GLOBAL_PROXY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.377 -0400", hash_original_field = "EFE987220A950F180042948AD0FA3113", hash_generated_field = "649F755854D82F65F45D4A5450A5B1C1")

    public static final int USES_POLICY_EXPIRE_PASSWORD = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.378 -0400", hash_original_field = "C0622E07B90C8132AC5B5273F8C8C15B", hash_generated_field = "62C8687D0FBBB6D1C4927BFFEC3671FA")

    public static final int USES_ENCRYPTED_STORAGE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.378 -0400", hash_original_field = "3029FC1DEC6F43C637710C1A1A244931", hash_generated_field = "AD7A455AB97C1169FE5F3ADEFB8A2B45")

    public static final int USES_POLICY_DISABLE_CAMERA = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.378 -0400", hash_original_field = "4CA518A70763CEC212339FA5C9F3C3A9", hash_generated_field = "5BE1EFEEF690A563A986877DACAE99BD")

    static ArrayList<PolicyInfo> sPoliciesDisplayOrder = new ArrayList<PolicyInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.400 -0400", hash_original_field = "3C158DA5DE0145AF6111C2405D7D5C4F", hash_generated_field = "33B4C32B2D5C5AE03E24E067E342238A")

    static HashMap<String, Integer> sKnownPolicies = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.401 -0400", hash_original_field = "4E7CC588DEF8602DA2222A5E6E3CA75D", hash_generated_field = "154BC990F414FCC0C38CFD009DD9E193")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:54.401 -0400", hash_original_field = "8388F181CBDE36845D31A8253E2A0818", hash_generated_field = "AE364B217CEEC3B0E90343DDAC8BFCA3")

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

