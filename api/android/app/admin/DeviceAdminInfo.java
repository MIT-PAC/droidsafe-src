package android.app.admin;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Printer;
import android.util.SparseArray;
import android.util.Xml;

public final class DeviceAdminInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.298 -0500", hash_original_field = "1D0B73C8A1604964DC268CCF29F3B3AC", hash_generated_field = "EF54ADA6F74B065C52190993EC3B85DD")

    static final String TAG = "DeviceAdminInfo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.301 -0500", hash_original_field = "74E46C03BC73BA7643A3EB4CB7168897", hash_generated_field = "E9DCD048F5A6CCC8DFE12FD941C198E5")

    public static final int USES_POLICY_LIMIT_PASSWORD = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.303 -0500", hash_original_field = "7B0821671D9E2AD816AE28AD03CA9F1C", hash_generated_field = "AE5A988FA3BA388E907590C417363EE7")

    public static final int USES_POLICY_WATCH_LOGIN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.305 -0500", hash_original_field = "96DF065ED82B784F1686524148E34EC5", hash_generated_field = "7F4234536F6741F04549A2277B1EFC5E")

    public static final int USES_POLICY_RESET_PASSWORD = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.307 -0500", hash_original_field = "3DF48A456BF963C0258778C32FEECD89", hash_generated_field = "067F511682A4B373E6E879C62919F307")

    public static final int USES_POLICY_FORCE_LOCK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.309 -0500", hash_original_field = "793EBA60239C3A8E811275E3F642E7AD", hash_generated_field = "CA3D915D2D1C7DC903035A2E3ADB84C8")

    public static final int USES_POLICY_WIPE_DATA = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.312 -0500", hash_original_field = "961C3A0B51E22283992D2C65AB79C7D5", hash_generated_field = "BF7504138BD4B0F7F20156F0A1C27890")

    public static final int USES_POLICY_SETS_GLOBAL_PROXY = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.314 -0500", hash_original_field = "A9F2F4EB462DA867C2DB704604D6C225", hash_generated_field = "649F755854D82F65F45D4A5450A5B1C1")

    public static final int USES_POLICY_EXPIRE_PASSWORD = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.317 -0500", hash_original_field = "7B25E8CFEE06262BA0061629D830F799", hash_generated_field = "62C8687D0FBBB6D1C4927BFFEC3671FA")

    public static final int USES_ENCRYPTED_STORAGE = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.319 -0500", hash_original_field = "D653D6B9E1CA6C4DB3B368CA554A4451", hash_generated_field = "AD7A455AB97C1169FE5F3ADEFB8A2B45")

    public static final int USES_POLICY_DISABLE_CAMERA = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.337 -0500", hash_original_field = "008E81DBF25DA74651DE3A1DD0D235AD", hash_generated_field = "5BE1EFEEF690A563A986877DACAE99BD")
    
    static ArrayList<PolicyInfo> sPoliciesDisplayOrder = new ArrayList<PolicyInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.339 -0500", hash_original_field = "DB782502208588BCE8856E6D63253BCF", hash_generated_field = "33B4C32B2D5C5AE03E24E067E342238A")

    static HashMap<String, Integer> sKnownPolicies = new HashMap<String, Integer>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.341 -0500", hash_original_field = "6E4822FC7EDF97D6F24084AE6DBD1531", hash_generated_field = "154BC990F414FCC0C38CFD009DD9E193")

    static SparseArray<PolicyInfo> sRevKnownPolicies = new SparseArray<PolicyInfo>();
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.574 -0400", hash_original_field = "8388F181CBDE36845D31A8253E2A0818", hash_generated_field = "AE364B217CEEC3B0E90343DDAC8BFCA3")

    public static final Parcelable.Creator<DeviceAdminInfo> CREATOR =
            new Parcelable.Creator<DeviceAdminInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.394 -0500", hash_original_method = "7A66852E579D848B03B48F35711A6790", hash_generated_method = "9D8871F81CE2CDD6B825CAAD289DB0F6")
        
public DeviceAdminInfo createFromParcel(Parcel source) {
            return new DeviceAdminInfo(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.396 -0500", hash_original_method = "6AB0A52C94769C9606A4992E5F3F4C61", hash_generated_method = "1AB4749A0DFC4A249838D3648C9EAD85")
        
public DeviceAdminInfo[] newArray(int size) {
            return new DeviceAdminInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.343 -0500", hash_original_field = "2D4BD551D6F35F2FF0B83E0BB38D3A72", hash_generated_field = "2D4BD551D6F35F2FF0B83E0BB38D3A72")

     ResolveInfo mReceiver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.346 -0500", hash_original_field = "03850172BDDB3583B6C36063C483BA26", hash_generated_field = "03850172BDDB3583B6C36063C483BA26")

    boolean mVisible;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.348 -0500", hash_original_field = "1401AC0E78CE2E5B04FC90A3723E0EBA", hash_generated_field = "1401AC0E78CE2E5B04FC90A3723E0EBA")

    int mUsesPolicies;
    
    /**
     * Constructor.
     * 
     * @param context The Context in which we are parsing the device admin.
     * @param receiver The ResolveInfo returned from the package manager about
     * this device admin's component.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.351 -0500", hash_original_method = "DA2A583494497907A2E88C8448FC887F", hash_generated_method = "E9933F58428F3C0E763FCBAB86326530")
    
public DeviceAdminInfo(Context context, ResolveInfo receiver)
            throws XmlPullParserException, IOException {
        mReceiver = receiver;
        ActivityInfo ai = receiver.activityInfo;
        
        PackageManager pm = context.getPackageManager();
        
        XmlResourceParser parser = null;
        try {
            parser = ai.loadXmlMetaData(pm, DeviceAdminReceiver.DEVICE_ADMIN_META_DATA);
            if (parser == null) {
                throw new XmlPullParserException("No "
                        + DeviceAdminReceiver.DEVICE_ADMIN_META_DATA + " meta-data");
            }
        
            Resources res = pm.getResourcesForApplication(ai.applicationInfo);
            
            AttributeSet attrs = Xml.asAttributeSet(parser);
            
            int type;
            while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG) {
            }
            
            String nodeName = parser.getName();
            if (!"device-admin".equals(nodeName)) {
                throw new XmlPullParserException(
                        "Meta-data does not start with device-admin tag");
            }
            
            TypedArray sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.DeviceAdmin);

            mVisible = sa.getBoolean(
                    com.android.internal.R.styleable.DeviceAdmin_visible, true);
            
            sa.recycle();
            
            int outerDepth = parser.getDepth();
            while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                   && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth)) {
                if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                    continue;
                }
                String tagName = parser.getName();
                if (tagName.equals("uses-policies")) {
                    int innerDepth = parser.getDepth();
                    while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                           && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth)) {
                        if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                            continue;
                        }
                        String policyName = parser.getName();
                        Integer val = sKnownPolicies.get(policyName);
                        if (val != null) {
                            mUsesPolicies |= 1 << val.intValue();
                        } else {
                            Log.w(TAG, "Unknown tag under uses-policies of "
                                    + getComponent() + ": " + policyName);
                        }
                    }
                }
            }
        } catch (NameNotFoundException e) {
            throw new XmlPullParserException(
                    "Unable to create context for: " + ai.packageName);
        } finally {
            if (parser != null) parser.close();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.354 -0500", hash_original_method = "63AFCAD0BD5EA5852A2B80B7C90D81EC", hash_generated_method = "63AFCAD0BD5EA5852A2B80B7C90D81EC")
    
DeviceAdminInfo(Parcel source) {
        mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        mUsesPolicies = source.readInt();
    }
    
    /**
     * Return the .apk package that implements this device admin.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.356 -0500", hash_original_method = "15D7F1C05476F5ABD61BE7FA06DD15FF", hash_generated_method = "B03B6C7AB7C74F5F2B6B2A6BF5024941")
    
public String getPackageName() {
        return mReceiver.activityInfo.packageName;
    }
    
    /**
     * Return the class name of the receiver component that implements
     * this device admin.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.358 -0500", hash_original_method = "DA104755B25D83C27775D5E8DE9A1BBA", hash_generated_method = "1315B33408538A0F3BCEC0441C3BB0C9")
    
public String getReceiverName() {
        return mReceiver.activityInfo.name;
    }

    /**
     * Return the raw information about the receiver implementing this
     * device admin.  Do not modify the returned object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.361 -0500", hash_original_method = "841DC64081A3A73FAF123BE852CFB557", hash_generated_method = "7FE6CA6A34D9C48885B628AF1D3E310A")
    
public ActivityInfo getActivityInfo() {
        return mReceiver.activityInfo;
    }
    
    public static class PolicyInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.322 -0500", hash_original_field = "D6522CF0EB0B8A28ECDAD3A7DBFFD747", hash_generated_field = "3ED5BE6AB29FB35B15159E9F367B83D4")

        public  int ident;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.325 -0500", hash_original_field = "FFCA994A2F44B678330E924D8C87385D", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

         public String tag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.328 -0500", hash_original_field = "70EECA22202CA77412947D3C18B098A8", hash_generated_field = "4E631ABECBB784587134D99CABB6D578")

         public int label;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.330 -0500", hash_original_field = "DBFE21F85C471A140456D5EACB5AD7C4", hash_generated_field = "5C8D64BE7911844358CFF2EE4DECE98F")

         public int description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.333 -0500", hash_original_method = "A90CA239E6D53FEA8EFED1E11D7512A4", hash_generated_method = "7322C3DEFEECD35E83C33FDCF9792904")
        
public PolicyInfo(int identIn, String tagIn, int labelIn, int descriptionIn) {
            ident = identIn;
            tag = tagIn;
            label = labelIn;
            description = descriptionIn;
        }
        
    }

    /**
     * Return the component of the receiver that implements this device admin.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.363 -0500", hash_original_method = "D8CD91DC98C1B02E60FA507EA4460E94", hash_generated_method = "A0DC67A908DBE8989A95916CA6E6CE19")
    
public ComponentName getComponent() {
        return new ComponentName(mReceiver.activityInfo.packageName,
                mReceiver.activityInfo.name);
    }
    
    /**
     * Load the user-displayed label for this device admin.
     * 
     * @param pm Supply a PackageManager used to load the device admin's
     * resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.366 -0500", hash_original_method = "4FE582D960848B41E26F8E6C418819DF", hash_generated_method = "78DCC3D9F18822F61C1519A8CA3EDD7A")
    
public CharSequence loadLabel(PackageManager pm) {
        return mReceiver.loadLabel(pm);
    }
    
    /**
     * Load user-visible description associated with this device admin.
     * 
     * @param pm Supply a PackageManager used to load the device admin's
     * resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.369 -0500", hash_original_method = "0302FD8CF05010F5CDB923C74BE177F9", hash_generated_method = "F0519945758DEF606A15C565590D2C48")
    
public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        if (mReceiver.activityInfo.descriptionRes != 0) {
            String packageName = mReceiver.resolvePackageName;
            ApplicationInfo applicationInfo = null;
            if (packageName == null) {
                packageName = mReceiver.activityInfo.packageName;
                applicationInfo = mReceiver.activityInfo.applicationInfo;
            }
            return pm.getText(packageName,
                    mReceiver.activityInfo.descriptionRes, applicationInfo);
        }
        throw new NotFoundException();
    }
    
    /**
     * Load the user-displayed icon for this device admin.
     * 
     * @param pm Supply a PackageManager used to load the device admin's
     * resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.371 -0500", hash_original_method = "0A539B1C4B2E8E617EDD9C83DE1E1B83", hash_generated_method = "7ED872B6528BD6FE362BF16B9729A4E5")
    
public Drawable loadIcon(PackageManager pm) {
        return mReceiver.loadIcon(pm);
    }
    
    /**
     * Returns whether this device admin would like to be visible to the
     * user, even when it is not enabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.373 -0500", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "A4584BE7CD354A580AF55D02BDF10F67")
    
public boolean isVisible() {
        return mVisible;
    }
    
    /**
     * Return true if the device admin has requested that it be able to use
     * the given policy control.  The possible policy identifier inputs are:
     * {@link #USES_POLICY_LIMIT_PASSWORD}, {@link #USES_POLICY_WATCH_LOGIN},
     * {@link #USES_POLICY_RESET_PASSWORD}, {@link #USES_POLICY_FORCE_LOCK},
     * {@link #USES_POLICY_WIPE_DATA},
     * {@link #USES_POLICY_EXPIRE_PASSWORD}, {@link #USES_ENCRYPTED_STORAGE},
     * {@link #USES_POLICY_DISABLE_CAMERA}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.375 -0500", hash_original_method = "E08C907F6F855F797C3DCE0727348F6B", hash_generated_method = "5DA099686E4153D4293B4EBE71F5AE0A")
    
public boolean usesPolicy(int policyIdent) {
        return (mUsesPolicies & (1<<policyIdent)) != 0;
    }
    
    /**
     * Return the XML tag name for the given policy identifier.  Valid identifiers
     * are as per {@link #usesPolicy(int)}.  If the given identifier is not
     * known, null is returned.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.377 -0500", hash_original_method = "535AB0E7EF604572B28232B709525301", hash_generated_method = "454DE004557814BE7724602F32BD3F3F")
    
public String getTagForPolicy(int policyIdent) {
        return sRevKnownPolicies.get(policyIdent).tag;
    }
    
    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.379 -0500", hash_original_method = "ED92B1C7E9AB1C3DE434E84362F61420", hash_generated_method = "4942C81192F83DF82F633E5FEB22759B")
    
public ArrayList<PolicyInfo> getUsedPolicies() {
        ArrayList<PolicyInfo> res = new ArrayList<PolicyInfo>();
        for (int i=0; i<sPoliciesDisplayOrder.size(); i++) {
            PolicyInfo pi = sPoliciesDisplayOrder.get(i);
            if (usesPolicy(pi.ident)) {
                res.add(pi);
            }
        }
        return res;
    }
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.381 -0500", hash_original_method = "9540BEA2A1ABEB78FD332A0993AE68E4", hash_generated_method = "FC3FCFF4F07756E0E7143CE33875ED33")
    
public void writePoliciesToXml(XmlSerializer out)
            throws IllegalArgumentException, IllegalStateException, IOException {
        out.attribute(null, "flags", Integer.toString(mUsesPolicies));
    }
    
    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.384 -0500", hash_original_method = "8AE790C821B5E4F39ADC01FFE00626E1", hash_generated_method = "D9AD5AF156BB2C7C8A504732D21C2EFB")
    
public void readPoliciesFromXml(XmlPullParser parser)
            throws XmlPullParserException, IOException {
        mUsesPolicies = Integer.parseInt(
                parser.getAttributeValue(null, "flags"));
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.386 -0500", hash_original_method = "B6CA0FCEADAF7A26300AC5E399081259", hash_generated_method = "93FD6697C6D46EE7253F14E9BE51F139")
    
public void dump(Printer pw, String prefix) {
        pw.println(prefix + "Receiver:");
        mReceiver.dump(pw, prefix + "  ");
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.388 -0500", hash_original_method = "337DF8B9CB781ADE72580EF8EE42E4C5", hash_generated_method = "DDAFBE19093D528F6385011F89BC68D2")
    
@Override
    public String toString() {
        return "DeviceAdminInfo{" + mReceiver.activityInfo.name + "}";
    }

    /**
     * Used to package this object into a {@link Parcel}.
     * 
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.391 -0500", hash_original_method = "3425AE1C08CE1294933DDD04C3D7531A", hash_generated_method = "24A3BE9083E34B5DADE32B816241C040")
    
public void writeToParcel(Parcel dest, int flags) {
        mReceiver.writeToParcel(dest, flags);
        dest.writeInt(mUsesPolicies);
    }
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:53.400 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public DeviceAdminInfo createFromParcel(Parcel source) {
            return new DeviceAdminInfo(source);
        }
    
    // orphaned legacy method
    public DeviceAdminInfo[] newArray(int size) {
            return new DeviceAdminInfo[size];
        }
    
}

