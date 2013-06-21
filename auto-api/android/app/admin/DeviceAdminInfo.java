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
    ResolveInfo mReceiver;
    boolean mVisible;
    int mUsesPolicies;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.231 -0400", hash_original_method = "DA2A583494497907A2E88C8448FC887F", hash_generated_method = "37F1D0B7B3EEB9C4B24A7286B8A6C9DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DeviceAdminInfo(Context context, ResolveInfo receiver) throws XmlPullParserException, IOException {
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(context.dsTaint);
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
                boolean var995057C222283DCE9E465AE35974357A_1853488180 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG);
            } //End collapsed parenthetic
            String nodeName;
            nodeName = parser.getName();
            {
                boolean varBDC9FBA0FE68CEEC67E40AC42EB09865_72650430 = (!"device-admin".equals(nodeName));
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
                boolean var8956F460685E7D17F4EB87103FD834D7_1770917450 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                   && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth));
                {
                    String tagName;
                    tagName = parser.getName();
                    {
                        boolean varBB2EC4F1FAE99CCAACDF1005EBC6FBF7_1104491331 = (tagName.equals("uses-policies"));
                        {
                            int innerDepth;
                            innerDepth = parser.getDepth();
                            {
                                boolean var554531EF1BF3152A9E18038DDC877C21_67465816 = ((type=parser.next()) != XmlPullParser.END_DOCUMENT
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.231 -0400", hash_original_method = "63AFCAD0BD5EA5852A2B80B7C90D81EC", hash_generated_method = "04B1B523AA39896812FA1F05FB03C033")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DeviceAdminInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        mUsesPolicies = source.readInt();
        // ---------- Original Method ----------
        //mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        //mUsesPolicies = source.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.231 -0400", hash_original_method = "15D7F1C05476F5ABD61BE7FA06DD15FF", hash_generated_method = "48EB6BF4025622843F2EA4389C147EFC")
    @DSModeled(DSC.SAFE)
    public String getPackageName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mReceiver.activityInfo.packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.232 -0400", hash_original_method = "DA104755B25D83C27775D5E8DE9A1BBA", hash_generated_method = "917AFDBE136543DF0839A60CA4727C29")
    @DSModeled(DSC.SAFE)
    public String getReceiverName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mReceiver.activityInfo.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.232 -0400", hash_original_method = "841DC64081A3A73FAF123BE852CFB557", hash_generated_method = "2E31E5ACDCA233AF1325C905B1C07AF8")
    @DSModeled(DSC.SAFE)
    public ActivityInfo getActivityInfo() {
        return (ActivityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mReceiver.activityInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.233 -0400", hash_original_method = "D8CD91DC98C1B02E60FA507EA4460E94", hash_generated_method = "8A9802551C3E5754D5D68D9EAAEB40DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentName getComponent() {
        ComponentName var1662F9048DB87BF022DEFB4738278910_1004815632 = (new ComponentName(mReceiver.activityInfo.packageName,
                mReceiver.activityInfo.name));
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ComponentName(mReceiver.activityInfo.packageName,
                //mReceiver.activityInfo.name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.233 -0400", hash_original_method = "4FE582D960848B41E26F8E6C418819DF", hash_generated_method = "B3BBE1D63056CCDF4E01F8CF0920F3BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadLabel(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        CharSequence varE70997E14FC1B235D3B0E6C845C93935_601657582 = (mReceiver.loadLabel(pm));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mReceiver.loadLabel(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.234 -0400", hash_original_method = "0302FD8CF05010F5CDB923C74BE177F9", hash_generated_method = "7C8F20B7E02C945179D54E9833ABD30D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        dsTaint.addTaint(pm.dsTaint);
        {
            String packageName;
            packageName = mReceiver.resolvePackageName;
            ApplicationInfo applicationInfo;
            applicationInfo = null;
            {
                packageName = mReceiver.activityInfo.packageName;
                applicationInfo = mReceiver.activityInfo.applicationInfo;
            } //End block
            CharSequence varC4619AB875D82C42EBD770063D58F7FF_744156496 = (pm.getText(packageName,
                    mReceiver.activityInfo.descriptionRes, applicationInfo));
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new NotFoundException();
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.234 -0400", hash_original_method = "0A539B1C4B2E8E617EDD9C83DE1E1B83", hash_generated_method = "ED8662069A20D1D9ED6E442CCFDAF769")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable loadIcon(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        Drawable var3CA34C9DBF95CC945C60248ADFB1C8EA_488375290 = (mReceiver.loadIcon(pm));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mReceiver.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.234 -0400", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "9DB428B9B3840227F1B2DE761ABCE10A")
    @DSModeled(DSC.SAFE)
    public boolean isVisible() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.235 -0400", hash_original_method = "E08C907F6F855F797C3DCE0727348F6B", hash_generated_method = "36FB6F60A975652F78185451D41A63F4")
    @DSModeled(DSC.SAFE)
    public boolean usesPolicy(int policyIdent) {
        dsTaint.addTaint(policyIdent);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (mUsesPolicies & (1<<policyIdent)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.235 -0400", hash_original_method = "535AB0E7EF604572B28232B709525301", hash_generated_method = "D229A44B02A69DA5F7E4BA6E6C050538")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTagForPolicy(int policyIdent) {
        dsTaint.addTaint(policyIdent);
        String varDB0B526F8685B901C47A518F5BD50739_670290848 = (sRevKnownPolicies.get(policyIdent).tag);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return sRevKnownPolicies.get(policyIdent).tag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.245 -0400", hash_original_method = "ED92B1C7E9AB1C3DE434E84362F61420", hash_generated_method = "8A65167DA370F395856E97231D2585C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ArrayList<PolicyInfo> getUsedPolicies() {
        ArrayList<PolicyInfo> res;
        res = new ArrayList<PolicyInfo>();
        {
            int i;
            i = 0;
            boolean varF1005D5C6AE4E2221C992F4E4F8202F3_1433866736 = (i<sPoliciesDisplayOrder.size());
            {
                PolicyInfo pi;
                pi = sPoliciesDisplayOrder.get(i);
                {
                    boolean varEC2D8F41B9495C03BBAAB789B6756C67_1879456031 = (usesPolicy(pi.ident));
                    {
                        res.add(pi);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (ArrayList<PolicyInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.247 -0400", hash_original_method = "9540BEA2A1ABEB78FD332A0993AE68E4", hash_generated_method = "A4F9465013E96BC1FC8E1D6A849ABB91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writePoliciesToXml(XmlSerializer out) throws IllegalArgumentException, IllegalStateException, IOException {
        dsTaint.addTaint(out.dsTaint);
        out.attribute(null, "flags", Integer.toString(mUsesPolicies));
        // ---------- Original Method ----------
        //out.attribute(null, "flags", Integer.toString(mUsesPolicies));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.248 -0400", hash_original_method = "8AE790C821B5E4F39ADC01FFE00626E1", hash_generated_method = "4BBD48878BE6ADCD983C0D8AE74FB734")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void readPoliciesFromXml(XmlPullParser parser) throws XmlPullParserException, IOException {
        dsTaint.addTaint(parser.dsTaint);
        mUsesPolicies = Integer.parseInt(
                parser.getAttributeValue(null, "flags"));
        // ---------- Original Method ----------
        //mUsesPolicies = Integer.parseInt(
                //parser.getAttributeValue(null, "flags"));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.248 -0400", hash_original_method = "B6CA0FCEADAF7A26300AC5E399081259", hash_generated_method = "126C408BAE20850E6DA4A52DB6BAB40D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        pw.println(prefix + "Receiver:");
        mReceiver.dump(pw, prefix + "  ");
        // ---------- Original Method ----------
        //pw.println(prefix + "Receiver:");
        //mReceiver.dump(pw, prefix + "  ");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.249 -0400", hash_original_method = "337DF8B9CB781ADE72580EF8EE42E4C5", hash_generated_method = "D7FFAB2DA41758EEACD7A538C3BB8C49")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "DeviceAdminInfo{" + mReceiver.activityInfo.name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.249 -0400", hash_original_method = "3425AE1C08CE1294933DDD04C3D7531A", hash_generated_method = "47E7EDC1F0AE26C491D4E2E2193F1AC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        mReceiver.writeToParcel(dest, flags);
        dest.writeInt(mUsesPolicies);
        // ---------- Original Method ----------
        //mReceiver.writeToParcel(dest, flags);
        //dest.writeInt(mUsesPolicies);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.250 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class PolicyInfo {
        public int ident;
        public String tag;
        public int label;
        public int description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.250 -0400", hash_original_method = "A90CA239E6D53FEA8EFED1E11D7512A4", hash_generated_method = "15902EBD3417579BA6A2E8142637E1B1")
        @DSModeled(DSC.SAFE)
        public PolicyInfo(int identIn, String tagIn, int labelIn, int descriptionIn) {
            dsTaint.addTaint(tagIn);
            dsTaint.addTaint(labelIn);
            dsTaint.addTaint(identIn);
            dsTaint.addTaint(descriptionIn);
            // ---------- Original Method ----------
            //ident = identIn;
            //tag = tagIn;
            //label = labelIn;
            //description = descriptionIn;
        }

        
    }


    
    static final String TAG = "DeviceAdminInfo";
    public static final int USES_POLICY_LIMIT_PASSWORD = 0;
    public static final int USES_POLICY_WATCH_LOGIN = 1;
    public static final int USES_POLICY_RESET_PASSWORD = 2;
    public static final int USES_POLICY_FORCE_LOCK = 3;
    public static final int USES_POLICY_WIPE_DATA = 4;
    public static final int USES_POLICY_SETS_GLOBAL_PROXY = 5;
    public static final int USES_POLICY_EXPIRE_PASSWORD = 6;
    public static final int USES_ENCRYPTED_STORAGE = 7;
    public static final int USES_POLICY_DISABLE_CAMERA = 8;
    static ArrayList<PolicyInfo> sPoliciesDisplayOrder = new ArrayList<PolicyInfo>();
    static HashMap<String, Integer> sKnownPolicies = new HashMap<String, Integer>();
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
    
    public static final Parcelable.Creator<DeviceAdminInfo> CREATOR = new Parcelable.Creator<DeviceAdminInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.251 -0400", hash_original_method = "7A66852E579D848B03B48F35711A6790", hash_generated_method = "89C032018AC0DAA6195C2D2F4ACACB7B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DeviceAdminInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            DeviceAdminInfo varF02AF88274BA920D871DC7A8A9EAABD2_869220457 = (new DeviceAdminInfo(source));
            return (DeviceAdminInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new DeviceAdminInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.251 -0400", hash_original_method = "6AB0A52C94769C9606A4992E5F3F4C61", hash_generated_method = "BEE5AE9C2EEC2E52999B972D53E820DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public DeviceAdminInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            DeviceAdminInfo[] var1EAEDB82AD22EF58282A1D4EAD6EB4CD_1536070093 = (new DeviceAdminInfo[size]);
            return (DeviceAdminInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new DeviceAdminInfo[size];
        }

        
}; //Transformed anonymous class
}

