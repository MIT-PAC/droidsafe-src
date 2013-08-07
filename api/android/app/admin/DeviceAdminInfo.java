package android.app.admin;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.545 -0400", hash_original_field = "572851143F58D86B2089A8B56ED682F4", hash_generated_field = "2D4BD551D6F35F2FF0B83E0BB38D3A72")

    ResolveInfo mReceiver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.545 -0400", hash_original_field = "807A18BD291896E7D3B58F90DB9F75FD", hash_generated_field = "03850172BDDB3583B6C36063C483BA26")

    boolean mVisible;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.545 -0400", hash_original_field = "930676CBE49D17827359BC4BBABCE218", hash_generated_field = "1401AC0E78CE2E5B04FC90A3723E0EBA")

    int mUsesPolicies;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.548 -0400", hash_original_method = "DA2A583494497907A2E88C8448FC887F", hash_generated_method = "6C333069A6E0D37E63427E6168049870")
    public  DeviceAdminInfo(Context context, ResolveInfo receiver) throws XmlPullParserException, IOException {
        addTaint(context.getTaint());
        mReceiver = receiver;
        ActivityInfo ai = receiver.activityInfo;
        PackageManager pm = context.getPackageManager();
        XmlResourceParser parser = null;
        try 
        {
            parser = ai.loadXmlMetaData(pm, DeviceAdminReceiver.DEVICE_ADMIN_META_DATA);
            if(parser == null)            
            {
                XmlPullParserException varE91392195A2CBF4116736208DF6E65F6_333639244 = new XmlPullParserException("No "
                        + DeviceAdminReceiver.DEVICE_ADMIN_META_DATA + " meta-data");
                varE91392195A2CBF4116736208DF6E65F6_333639244.addTaint(taint);
                throw varE91392195A2CBF4116736208DF6E65F6_333639244;
            } //End block
            Resources res = pm.getResourcesForApplication(ai.applicationInfo);
            AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG)            
            {
            } //End block
            String nodeName = parser.getName();
            if(!"device-admin".equals(nodeName))            
            {
                XmlPullParserException var2FCA523136D4DA1E77EC80B48F84CE1C_190247382 = new XmlPullParserException(
                        "Meta-data does not start with device-admin tag");
                var2FCA523136D4DA1E77EC80B48F84CE1C_190247382.addTaint(taint);
                throw var2FCA523136D4DA1E77EC80B48F84CE1C_190247382;
            } //End block
            TypedArray sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.DeviceAdmin);
            mVisible = sa.getBoolean(
                    com.android.internal.R.styleable.DeviceAdmin_visible, true);
            sa.recycle();
            int outerDepth = parser.getDepth();
            while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
                   && (type != XmlPullParser.END_TAG || parser.getDepth() > outerDepth))            
            {
                if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)                
                {
                    continue;
                } //End block
                String tagName = parser.getName();
                if(tagName.equals("uses-policies"))                
                {
                    int innerDepth = parser.getDepth();
                    while
((type=parser.next()) != XmlPullParser.END_DOCUMENT
                           && (type != XmlPullParser.END_TAG || parser.getDepth() > innerDepth))                    
                    {
                        if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)                        
                        {
                            continue;
                        } //End block
                        String policyName = parser.getName();
                        Integer val = sKnownPolicies.get(policyName);
                        if(val != null)                        
                        {
                            mUsesPolicies |= 1 << val.intValue();
                        } //End block
                        else
                        {
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
        catch (NameNotFoundException e)
        {
            XmlPullParserException var742595AE6BD4D40F88FD9D08E6897212_2077758656 = new XmlPullParserException(
                    "Unable to create context for: " + ai.packageName);
            var742595AE6BD4D40F88FD9D08E6897212_2077758656.addTaint(taint);
            throw var742595AE6BD4D40F88FD9D08E6897212_2077758656;
        } //End block
        finally 
        {
            if(parser != null)            
            parser.close();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.549 -0400", hash_original_method = "63AFCAD0BD5EA5852A2B80B7C90D81EC", hash_generated_method = "BB2740E4F064F8E201F116E2693410B2")
      DeviceAdminInfo(Parcel source) {
        mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        mUsesPolicies = source.readInt();
        // ---------- Original Method ----------
        //mReceiver = ResolveInfo.CREATOR.createFromParcel(source);
        //mUsesPolicies = source.readInt();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.550 -0400", hash_original_method = "15D7F1C05476F5ABD61BE7FA06DD15FF", hash_generated_method = "F422B5DDC4E12688191A7C6AA9E6249A")
    public String getPackageName() {
String var3B1034BB39A5A73C8BF58CC10281FC09_130195661 =         mReceiver.activityInfo.packageName;
        var3B1034BB39A5A73C8BF58CC10281FC09_130195661.addTaint(taint);
        return var3B1034BB39A5A73C8BF58CC10281FC09_130195661;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo.packageName;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.551 -0400", hash_original_method = "DA104755B25D83C27775D5E8DE9A1BBA", hash_generated_method = "63894232809F53D2C8B04F190CA1567E")
    public String getReceiverName() {
String var4C05455EF0EF7A0F66C206DE9565448A_1151249894 =         mReceiver.activityInfo.name;
        var4C05455EF0EF7A0F66C206DE9565448A_1151249894.addTaint(taint);
        return var4C05455EF0EF7A0F66C206DE9565448A_1151249894;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo.name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.552 -0400", hash_original_method = "841DC64081A3A73FAF123BE852CFB557", hash_generated_method = "D1156E112A05884364B90B807E775833")
    public ActivityInfo getActivityInfo() {
ActivityInfo var39591A5DB2C8552B9C453FB5E13269B3_1163161374 =         mReceiver.activityInfo;
        var39591A5DB2C8552B9C453FB5E13269B3_1163161374.addTaint(taint);
        return var39591A5DB2C8552B9C453FB5E13269B3_1163161374;
        // ---------- Original Method ----------
        //return mReceiver.activityInfo;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.553 -0400", hash_original_method = "D8CD91DC98C1B02E60FA507EA4460E94", hash_generated_method = "5BCE6C9DD271148B497CF52FB7D8FF88")
    public ComponentName getComponent() {
ComponentName var73DBFE97B1EBA815AB1736DBEF9255C3_172165546 =         new ComponentName(mReceiver.activityInfo.packageName,
                mReceiver.activityInfo.name);
        var73DBFE97B1EBA815AB1736DBEF9255C3_172165546.addTaint(taint);
        return var73DBFE97B1EBA815AB1736DBEF9255C3_172165546;
        // ---------- Original Method ----------
        //return new ComponentName(mReceiver.activityInfo.packageName,
                //mReceiver.activityInfo.name);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.554 -0400", hash_original_method = "4FE582D960848B41E26F8E6C418819DF", hash_generated_method = "5B3E466EF50B86782F7B9B600466C365")
    public CharSequence loadLabel(PackageManager pm) {
        addTaint(pm.getTaint());
CharSequence var04836563D840A9771BC52B90814EF285_340721659 =         mReceiver.loadLabel(pm);
        var04836563D840A9771BC52B90814EF285_340721659.addTaint(taint);
        return var04836563D840A9771BC52B90814EF285_340721659;
        // ---------- Original Method ----------
        //return mReceiver.loadLabel(pm);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.555 -0400", hash_original_method = "0302FD8CF05010F5CDB923C74BE177F9", hash_generated_method = "7C2D26E5530B679C397EBC9322FF5025")
    public CharSequence loadDescription(PackageManager pm) throws NotFoundException {
        addTaint(pm.getTaint());
        if(mReceiver.activityInfo.descriptionRes != 0)        
        {
            String packageName = mReceiver.resolvePackageName;
            ApplicationInfo applicationInfo = null;
            if(packageName == null)            
            {
                packageName = mReceiver.activityInfo.packageName;
                applicationInfo = mReceiver.activityInfo.applicationInfo;
            } //End block
CharSequence var1B6CAE566C6EF31064804F74FCA7B757_1172766269 =             pm.getText(packageName,
                    mReceiver.activityInfo.descriptionRes, applicationInfo);
            var1B6CAE566C6EF31064804F74FCA7B757_1172766269.addTaint(taint);
            return var1B6CAE566C6EF31064804F74FCA7B757_1172766269;
        } //End block
        NotFoundException var093D7BD5AA2C711924D0289C785A4288_51017074 = new NotFoundException();
        var093D7BD5AA2C711924D0289C785A4288_51017074.addTaint(taint);
        throw var093D7BD5AA2C711924D0289C785A4288_51017074;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.556 -0400", hash_original_method = "0A539B1C4B2E8E617EDD9C83DE1E1B83", hash_generated_method = "42AAF26022EA399C2311B45B1C9B1053")
    public Drawable loadIcon(PackageManager pm) {
        addTaint(pm.getTaint());
Drawable var9E48956E65D02F3940B6623A96EA2B8E_1426641544 =         mReceiver.loadIcon(pm);
        var9E48956E65D02F3940B6623A96EA2B8E_1426641544.addTaint(taint);
        return var9E48956E65D02F3940B6623A96EA2B8E_1426641544;
        // ---------- Original Method ----------
        //return mReceiver.loadIcon(pm);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.556 -0400", hash_original_method = "5E5A2EDE31F4C9B537E19F3E9904B493", hash_generated_method = "CC59D391888C2638BAC290412F365744")
    public boolean isVisible() {
        boolean var807A18BD291896E7D3B58F90DB9F75FD_144963549 = (mVisible);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811755381 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_811755381;
        // ---------- Original Method ----------
        //return mVisible;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.557 -0400", hash_original_method = "E08C907F6F855F797C3DCE0727348F6B", hash_generated_method = "00F15D61FCE2EA7CBA07D08B6F1AFAC7")
    public boolean usesPolicy(int policyIdent) {
        addTaint(policyIdent);
        boolean var02AF1B973461B48CD4D7EAEADCC44BCA_809416862 = ((mUsesPolicies & (1<<policyIdent)) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2036060441 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2036060441;
        // ---------- Original Method ----------
        //return (mUsesPolicies & (1<<policyIdent)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.558 -0400", hash_original_method = "535AB0E7EF604572B28232B709525301", hash_generated_method = "13D58473FDD37B2A4FBF10C541E17836")
    public String getTagForPolicy(int policyIdent) {
        addTaint(policyIdent);
String varDD87F71CE88E649A307A99E76E33B4BE_1503969972 =         sRevKnownPolicies.get(policyIdent).tag;
        varDD87F71CE88E649A307A99E76E33B4BE_1503969972.addTaint(taint);
        return varDD87F71CE88E649A307A99E76E33B4BE_1503969972;
        // ---------- Original Method ----------
        //return sRevKnownPolicies.get(policyIdent).tag;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.559 -0400", hash_original_method = "ED92B1C7E9AB1C3DE434E84362F61420", hash_generated_method = "7F144ECFEE6AA34F506CABBDCCA11BAE")
    public ArrayList<PolicyInfo> getUsedPolicies() {
        ArrayList<PolicyInfo> res = new ArrayList<PolicyInfo>();
for(int i=0;i<sPoliciesDisplayOrder.size();i++)
        {
            PolicyInfo pi = sPoliciesDisplayOrder.get(i);
            if(usesPolicy(pi.ident))            
            {
                res.add(pi);
            } //End block
        } //End block
ArrayList<PolicyInfo> varB5053E025797B3BF768F5C37934C244D_857479402 =         res;
        varB5053E025797B3BF768F5C37934C244D_857479402.addTaint(taint);
        return varB5053E025797B3BF768F5C37934C244D_857479402;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.562 -0400", hash_original_method = "9540BEA2A1ABEB78FD332A0993AE68E4", hash_generated_method = "4B3338A8DE0DA566E6DE84827D5710FC")
    public void writePoliciesToXml(XmlSerializer out) throws IllegalArgumentException, IllegalStateException, IOException {
        addTaint(out.getTaint());
        out.attribute(null, "flags", Integer.toString(mUsesPolicies));
        // ---------- Original Method ----------
        //out.attribute(null, "flags", Integer.toString(mUsesPolicies));
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.565 -0400", hash_original_method = "8AE790C821B5E4F39ADC01FFE00626E1", hash_generated_method = "8C9590F7F9DB5EE5A22B3E48C1DCA69F")
    public void readPoliciesFromXml(XmlPullParser parser) throws XmlPullParserException, IOException {
        mUsesPolicies = Integer.parseInt(
                parser.getAttributeValue(null, "flags"));
        // ---------- Original Method ----------
        //mUsesPolicies = Integer.parseInt(
                //parser.getAttributeValue(null, "flags"));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.565 -0400", hash_original_method = "B6CA0FCEADAF7A26300AC5E399081259", hash_generated_method = "4A2A281075112D6089C1D6EE9257E786")
    public void dump(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        pw.println(prefix + "Receiver:");
        mReceiver.dump(pw, prefix + "  ");
        // ---------- Original Method ----------
        //pw.println(prefix + "Receiver:");
        //mReceiver.dump(pw, prefix + "  ");
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.566 -0400", hash_original_method = "337DF8B9CB781ADE72580EF8EE42E4C5", hash_generated_method = "19944A59C117294479426877F476A98A")
    @Override
    public String toString() {
String var1E9B509EA010A811781E44EEDFCE69A1_1577623421 =         "DeviceAdminInfo{" + mReceiver.activityInfo.name + "}";
        var1E9B509EA010A811781E44EEDFCE69A1_1577623421.addTaint(taint);
        return var1E9B509EA010A811781E44EEDFCE69A1_1577623421;
        // ---------- Original Method ----------
        //return "DeviceAdminInfo{" + mReceiver.activityInfo.name + "}";
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.567 -0400", hash_original_method = "3425AE1C08CE1294933DDD04C3D7531A", hash_generated_method = "AC57E475E95D2B4277F0D8D1B578241D")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        mReceiver.writeToParcel(dest, flags);
        dest.writeInt(mUsesPolicies);
        // ---------- Original Method ----------
        //mReceiver.writeToParcel(dest, flags);
        //dest.writeInt(mUsesPolicies);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.567 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B0747FBF0C70098FC8301276B0DBAB32")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_732999376 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867054674 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_867054674;
        // ---------- Original Method ----------
        //return 0;
    }

    
    public static class PolicyInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.568 -0400", hash_original_field = "67217D8B401CF5E72BBF5103D60F3E97", hash_generated_field = "3ED5BE6AB29FB35B15159E9F367B83D4")

        public int ident;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.568 -0400", hash_original_field = "E4D23E841D8E8804190027BCE3180FA5", hash_generated_field = "928ED6D003A1BBA8E668A5F46546830A")

        public String tag;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.569 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "4E631ABECBB784587134D99CABB6D578")

        public int label;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.569 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "5C8D64BE7911844358CFF2EE4DECE98F")

        public int description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.571 -0400", hash_original_method = "A90CA239E6D53FEA8EFED1E11D7512A4", hash_generated_method = "E3787431209518667B6BC2676B74AB95")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.571 -0400", hash_original_field = "BFCAA000FE160E5F7BB766375D4ADD22", hash_generated_field = "EF54ADA6F74B065C52190993EC3B85DD")

    static final String TAG = "DeviceAdminInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.571 -0400", hash_original_field = "725F9C73A34DE547E47E4F7957A81C07", hash_generated_field = "E9DCD048F5A6CCC8DFE12FD941C198E5")

    public static final int USES_POLICY_LIMIT_PASSWORD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.572 -0400", hash_original_field = "863AD8CC348C390802665805D24E874C", hash_generated_field = "AE5A988FA3BA388E907590C417363EE7")

    public static final int USES_POLICY_WATCH_LOGIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.572 -0400", hash_original_field = "F52E3BCB4ED41E03A7E379585CCAC4B1", hash_generated_field = "7F4234536F6741F04549A2277B1EFC5E")

    public static final int USES_POLICY_RESET_PASSWORD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.572 -0400", hash_original_field = "2D4E9DF54EDA4FED3ECE31EC26594C58", hash_generated_field = "067F511682A4B373E6E879C62919F307")

    public static final int USES_POLICY_FORCE_LOCK = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.572 -0400", hash_original_field = "FA1308E3ECDDE25A3B149A68AA49ED37", hash_generated_field = "CA3D915D2D1C7DC903035A2E3ADB84C8")

    public static final int USES_POLICY_WIPE_DATA = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.572 -0400", hash_original_field = "3152B4EA535C17578AB6AC3680C46D2A", hash_generated_field = "BF7504138BD4B0F7F20156F0A1C27890")

    public static final int USES_POLICY_SETS_GLOBAL_PROXY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.573 -0400", hash_original_field = "EFE987220A950F180042948AD0FA3113", hash_generated_field = "649F755854D82F65F45D4A5450A5B1C1")

    public static final int USES_POLICY_EXPIRE_PASSWORD = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.573 -0400", hash_original_field = "C0622E07B90C8132AC5B5273F8C8C15B", hash_generated_field = "62C8687D0FBBB6D1C4927BFFEC3671FA")

    public static final int USES_ENCRYPTED_STORAGE = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.573 -0400", hash_original_field = "3029FC1DEC6F43C637710C1A1A244931", hash_generated_field = "AD7A455AB97C1169FE5F3ADEFB8A2B45")

    public static final int USES_POLICY_DISABLE_CAMERA = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.573 -0400", hash_original_field = "4CA518A70763CEC212339FA5C9F3C3A9", hash_generated_field = "5BE1EFEEF690A563A986877DACAE99BD")

    static ArrayList<PolicyInfo> sPoliciesDisplayOrder = new ArrayList<PolicyInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.573 -0400", hash_original_field = "3C158DA5DE0145AF6111C2405D7D5C4F", hash_generated_field = "33B4C32B2D5C5AE03E24E067E342238A")

    static HashMap<String, Integer> sKnownPolicies = new HashMap<String, Integer>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.574 -0400", hash_original_field = "4E7CC588DEF8602DA2222A5E6E3CA75D", hash_generated_field = "154BC990F414FCC0C38CFD009DD9E193")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:56.574 -0400", hash_original_field = "8388F181CBDE36845D31A8253E2A0818", hash_generated_field = "AE364B217CEEC3B0E90343DDAC8BFCA3")

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

