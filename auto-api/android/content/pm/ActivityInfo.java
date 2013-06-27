package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ActivityInfo extends ComponentInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.924 -0400", hash_original_field = "F484570D7CF557020E11ACE406901B10", hash_generated_field = "A97FD2465AC4AAA472175729CDE0BBF3")

    public int theme;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.924 -0400", hash_original_field = "7E6246B32CC3EBCF36E7C8E03043E3A2", hash_generated_field = "44DED241F3CE7B79E35C4E3B1267012B")

    public int launchMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.925 -0400", hash_original_field = "4B65CA0F8B76E7181A12BF1FABC48532", hash_generated_field = "3670CE1CBA400C10EB64B3D7DD616511")

    public String permission;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.925 -0400", hash_original_field = "076F9A985964BB9FD17F8637C357D2C5", hash_generated_field = "7AA799578052361E8AB8F2E0B535D75E")

    public String taskAffinity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.925 -0400", hash_original_field = "58B29B3FB22FD91E95B7A499EB352CEF", hash_generated_field = "B7B6389CFB3895770F2F6EE8D0A8782B")

    public String targetActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.925 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.925 -0400", hash_original_field = "99634E199ABC2F6238F7886B4FDC8676", hash_generated_field = "DEB1388656DED838D1768D719876593D")

    public int screenOrientation = SCREEN_ORIENTATION_UNSPECIFIED;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.926 -0400", hash_original_field = "13CABB6015C63F857C74ACA5CFBF32B7", hash_generated_field = "FDFF8A48AEB40DAF58DDD31BD86042B9")

    public int configChanges;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.926 -0400", hash_original_field = "C8CDD504FC1F4DA0D99A7ED050D879BE", hash_generated_field = "3D8BA35B328FE1B6C6D3197F4C56033F")

    public int softInputMode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.926 -0400", hash_original_field = "BC63366481A204D80153970F9D4FBA5D", hash_generated_field = "9FF841B59BE996A97456D758065D4280")

    public int uiOptions = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.927 -0400", hash_original_method = "AADA555071E489A7B136029649F29F63", hash_generated_method = "853ED7E1741821951AE7AFCCD338E611")
    public  ActivityInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.951 -0400", hash_original_method = "4FD441668078A896A91515A186821C6A", hash_generated_method = "60B598AF11004321053C2B180B310E50")
    public  ActivityInfo(ActivityInfo orig) {
        super(orig);
        theme = orig.theme;
        launchMode = orig.launchMode;
        permission = orig.permission;
        taskAffinity = orig.taskAffinity;
        targetActivity = orig.targetActivity;
        flags = orig.flags;
        screenOrientation = orig.screenOrientation;
        configChanges = orig.configChanges;
        softInputMode = orig.softInputMode;
        uiOptions = orig.uiOptions;
        // ---------- Original Method ----------
        //theme = orig.theme;
        //launchMode = orig.launchMode;
        //permission = orig.permission;
        //taskAffinity = orig.taskAffinity;
        //targetActivity = orig.targetActivity;
        //flags = orig.flags;
        //screenOrientation = orig.screenOrientation;
        //configChanges = orig.configChanges;
        //softInputMode = orig.softInputMode;
        //uiOptions = orig.uiOptions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.969 -0400", hash_original_method = "BC25ED8BD045A23681F3CDE53EF4296B", hash_generated_method = "CDE6876CF9D039988B46F54724AEA3A8")
    private  ActivityInfo(Parcel source) {
        super(source);
        theme = source.readInt();
        launchMode = source.readInt();
        permission = source.readString();
        taskAffinity = source.readString();
        targetActivity = source.readString();
        flags = source.readInt();
        screenOrientation = source.readInt();
        configChanges = source.readInt();
        softInputMode = source.readInt();
        uiOptions = source.readInt();
        // ---------- Original Method ----------
        //theme = source.readInt();
        //launchMode = source.readInt();
        //permission = source.readString();
        //taskAffinity = source.readString();
        //targetActivity = source.readString();
        //flags = source.readInt();
        //screenOrientation = source.readInt();
        //configChanges = source.readInt();
        //softInputMode = source.readInt();
        //uiOptions = source.readInt();
    }

    
        public static int activityInfoConfigToNative(int input) {
        int output = 0;
        for (int i=0; i<CONFIG_NATIVE_BITS.length; i++) {
            if ((input&(1<<i)) != 0) {
                output |= CONFIG_NATIVE_BITS[i];
            }
        }
        return output;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.975 -0400", hash_original_method = "2220B48CFCD1F70E454B4F27BFE80BE1", hash_generated_method = "CD4D24DBDB65E2BFB1E293AC4D27D753")
    public int getRealConfigChanged() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691638573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1691638573;
        // ---------- Original Method ----------
        //return applicationInfo.targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB_MR2
                //? (configChanges | ActivityInfo.CONFIG_SCREEN_SIZE
                        //| ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE)
                //: configChanges;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.976 -0400", hash_original_method = "49F7EEB7DFDAB588B69DE97F89E77EAC", hash_generated_method = "57F731AEA33B56AC2FC4EEE10780E9CC")
    public final int getThemeResource() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006308950 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1006308950;
        // ---------- Original Method ----------
        //return theme != 0 ? theme : applicationInfo.theme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:01.999 -0400", hash_original_method = "0EA21654C0B5D84D36E2F9B8C286493E", hash_generated_method = "7406477AE117D15E18E7F87B1B82B282")
    public void dump(Printer pw, String prefix) {
        super.dumpFront(pw, prefix);
        {
            pw.println(prefix + "permission=" + permission);
        } //End block
        pw.println(prefix + "taskAffinity=" + taskAffinity
                + " targetActivity=" + targetActivity);
        {
            pw.println(prefix + "launchMode=" + launchMode
                    + " flags=0x" + Integer.toHexString(flags)
                    + " theme=0x" + Integer.toHexString(theme));
        } //End block
        {
            pw.println(prefix + "screenOrientation=" + screenOrientation
                    + " configChanges=0x" + Integer.toHexString(configChanges)
                    + " softInputMode=0x" + Integer.toHexString(softInputMode));
        } //End block
        {
            pw.println(prefix + " uiOptions=0x" + Integer.toHexString(uiOptions));
        } //End block
        super.dumpBack(pw, prefix);
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.000 -0400", hash_original_method = "B913D35C681ED2748C3576E23600DB3E", hash_generated_method = "51B3F11BDC1BABB1B78129B19EFD7FF3")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_167765545 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_167765545 = "ActivityInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
        varB4EAC82CA7396A68D541C85D26508E83_167765545.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_167765545;
        // ---------- Original Method ----------
        //return "ActivityInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + name + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.015 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C0FB71ABB9D0A80C93108F48FAE32F19")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226736142 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_226736142;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.024 -0400", hash_original_method = "0DBABFC7118E214F01D60FEE309F0914", hash_generated_method = "764FA04ED7291035B5F3DEF65BC58142")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        dest.writeInt(theme);
        dest.writeInt(launchMode);
        dest.writeString(permission);
        dest.writeString(taskAffinity);
        dest.writeString(targetActivity);
        dest.writeInt(flags);
        dest.writeInt(screenOrientation);
        dest.writeInt(configChanges);
        dest.writeInt(softInputMode);
        dest.writeInt(uiOptions);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //dest.writeInt(theme);
        //dest.writeInt(launchMode);
        //dest.writeString(permission);
        //dest.writeString(taskAffinity);
        //dest.writeString(targetActivity);
        //dest.writeInt(flags);
        //dest.writeInt(screenOrientation);
        //dest.writeInt(configChanges);
        //dest.writeInt(softInputMode);
        //dest.writeInt(uiOptions);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.024 -0400", hash_original_field = "E8431EF60432D4266A76DEA6A224C545", hash_generated_field = "97A05F3EFCDB13E39BC3ACB57277040B")

    public static final int LAUNCH_MULTIPLE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.024 -0400", hash_original_field = "75D05791384306DF3B06A4572743F66F", hash_generated_field = "3346F153D56014348EA4AABCC632FEC7")

    public static final int LAUNCH_SINGLE_TOP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.024 -0400", hash_original_field = "C7FD217C9BDDD9FA5A453019E1DBEDAA", hash_generated_field = "274027FCAA4012389CEE68B6058B89B1")

    public static final int LAUNCH_SINGLE_TASK = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.027 -0400", hash_original_field = "A82FAC33E1C01E0F1DFF92C01B82F2D7", hash_generated_field = "429EC3FADE282AD238148C52EB4272A8")

    public static final int LAUNCH_SINGLE_INSTANCE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.027 -0400", hash_original_field = "9FB5488AA0D4078FDA5F9C69876873E3", hash_generated_field = "E10ACE5AB39803D2DD5BD3FB31DB605E")

    public static final int FLAG_MULTIPROCESS = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.028 -0400", hash_original_field = "6412B84DA547860E4914249D6761EE7B", hash_generated_field = "7A7185CF558C460C5BAA6804AF709870")

    public static final int FLAG_FINISH_ON_TASK_LAUNCH = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.028 -0400", hash_original_field = "CF1044E5F95E9CD484FD4145B39E3319", hash_generated_field = "26E518A39B4CAF219C69B3E718A86691")

    public static final int FLAG_CLEAR_TASK_ON_LAUNCH = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.028 -0400", hash_original_field = "56E31978BAB849E5F325FE61E9BEF50F", hash_generated_field = "71217956806EFD13BDA790423AF010D6")

    public static final int FLAG_ALWAYS_RETAIN_TASK_STATE = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.028 -0400", hash_original_field = "08B674ACBAACF6EC9A4BB8873BAA8503", hash_generated_field = "EE6215FB7A481181A853996AA2E14DBF")

    public static final int FLAG_STATE_NOT_NEEDED = 0x0010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.028 -0400", hash_original_field = "7C65F60398C2418226F14AAE42C5FB10", hash_generated_field = "9E30A9653012F6BF0551A8232A6322D6")

    public static final int FLAG_EXCLUDE_FROM_RECENTS = 0x0020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.028 -0400", hash_original_field = "BB7FBA62CE4B17C51EB4F60FD27C1607", hash_generated_field = "93F5FF1DF9125B7794713028E8C4D08B")

    public static final int FLAG_ALLOW_TASK_REPARENTING = 0x0040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.029 -0400", hash_original_field = "79593F2F35606DAE9B1FEF5E63C2AC57", hash_generated_field = "356D126C83E7B4704E2534452CA43637")

    public static final int FLAG_NO_HISTORY = 0x0080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.029 -0400", hash_original_field = "A28A1E2ED8815EAA5BC0A6DD5829BF96", hash_generated_field = "AE2DC166D5DC2D8B5E1564A26130A703")

    public static final int FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS = 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.029 -0400", hash_original_field = "9C99A9650832B35039C8D0E413B5A0CE", hash_generated_field = "CA6915BA5049341568E8C11126058F20")

    public static final int FLAG_HARDWARE_ACCELERATED = 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.029 -0400", hash_original_field = "A940FA6DCA5C7C1CCCCB41D33BB05084", hash_generated_field = "BA8A64B3ECA3E30985E745EF97C29C4F")

    public static final int FLAG_IMMERSIVE = 0x0400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.029 -0400", hash_original_field = "E53F4A78F2346A207C2A1C6D414AB193", hash_generated_field = "4EE91C87E229BD888491D41B6FFA2087")

    public static final int SCREEN_ORIENTATION_UNSPECIFIED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.029 -0400", hash_original_field = "C06A17DBA3D19AE741723C8F0EC928D0", hash_generated_field = "51E03776BE2DD6980AA26F97BE6FF149")

    public static final int SCREEN_ORIENTATION_LANDSCAPE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.048 -0400", hash_original_field = "6597EC16774A092B8224D4FE087C2031", hash_generated_field = "88A2FE9E0A0F12C9AE10A2BFC22DE8B8")

    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.048 -0400", hash_original_field = "FA107FC237A976D6F14FE39D60BF3787", hash_generated_field = "809E4F9E456EBA59575E190A9761FCF8")

    public static final int SCREEN_ORIENTATION_USER = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.049 -0400", hash_original_field = "7E27972D5666C02375CD65D734F84F14", hash_generated_field = "9EB8AF2D3510751A7ADEEB293663A365")

    public static final int SCREEN_ORIENTATION_BEHIND = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.049 -0400", hash_original_field = "C33472F2EBB05485CCA413BC020B3C1D", hash_generated_field = "082D68ED3A8B5E41CD54764495EF3F3C")

    public static final int SCREEN_ORIENTATION_SENSOR = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.049 -0400", hash_original_field = "DF6F63CE8ECA1DD4B422278E43F9D2FB", hash_generated_field = "09B898BC316947914416072F01817041")

    public static final int SCREEN_ORIENTATION_NOSENSOR = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.049 -0400", hash_original_field = "F2A2CA672AC7CB9B1D8E95A49EC9692B", hash_generated_field = "B42F8A51DB28D288AB762EDE0064CC99")

    public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.049 -0400", hash_original_field = "A96F683E9FDF8BD5ACED39DFE21F8CF1", hash_generated_field = "7590EF159EA1676F45C451D9D09538EA")

    public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.049 -0400", hash_original_field = "9CD429D105F481B0722B28D8500BEE43", hash_generated_field = "036D6CA8B87C65ADA879EA52998AA962")

    public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.050 -0400", hash_original_field = "5219BD51B0DE2E1D5CF72360A6BEE69B", hash_generated_field = "E66D17CEF1E27011C8367816474F48EF")

    public static final int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.050 -0400", hash_original_field = "F3069E7C88CE8E25B69D54A556BDBC9F", hash_generated_field = "28FEA547E8D1B40DE8A2FE15BEC645AC")

    public static final int SCREEN_ORIENTATION_FULL_SENSOR = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.050 -0400", hash_original_field = "ED8EA7F70755FA2FC2062F5437FFDCA9", hash_generated_field = "0E2BF712ED9D4CC79F08860395DA25DF")

    public static final int CONFIG_MCC = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.050 -0400", hash_original_field = "A7B72DA1912C194ED9CCAD049B724A20", hash_generated_field = "2E711D8CDADEDE68279C80B62C1E9FC6")

    public static final int CONFIG_MNC = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.050 -0400", hash_original_field = "CB60C88A14C2EDF5F11AB70D112EA143", hash_generated_field = "7FDD2B692126BEFCFAEE202D9B8688E8")

    public static final int CONFIG_LOCALE = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.050 -0400", hash_original_field = "CB62FE562B5ECC86ABF1F28BCE85D6C4", hash_generated_field = "E6685BED680245CBD03F43F4A75D9AB3")

    public static final int CONFIG_TOUCHSCREEN = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.050 -0400", hash_original_field = "B6AB1CBAC8747D2CAD18F75FF2B89866", hash_generated_field = "16B50005BCF39890424F730B7C729D86")

    public static final int CONFIG_KEYBOARD = 0x0010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.051 -0400", hash_original_field = "28D3A69E3AC7B87C469D15619B2E256D", hash_generated_field = "0969B2213D8306E2A4EFE82F986CD5B8")

    public static final int CONFIG_KEYBOARD_HIDDEN = 0x0020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.051 -0400", hash_original_field = "9FAB88CC4849C72CEB40B4B8F3B61C6A", hash_generated_field = "B4CCFA896DAA369294842419E2C450A0")

    public static final int CONFIG_NAVIGATION = 0x0040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.051 -0400", hash_original_field = "90DD1E2DA40A40AF33438E02FFD46510", hash_generated_field = "D0CE0746E82DAAD347064D78B16961DE")

    public static final int CONFIG_ORIENTATION = 0x0080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.051 -0400", hash_original_field = "43C2C6FC5B1A7A98BAD05CBC6412A147", hash_generated_field = "21B6DB04E1224EDE72327EB73DCE8948")

    public static final int CONFIG_SCREEN_LAYOUT = 0x0100;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.051 -0400", hash_original_field = "A91667D7562FAD2FDADC36410E3ADB87", hash_generated_field = "5413F783BC23EAD9A791F333D3755C37")

    public static final int CONFIG_UI_MODE = 0x0200;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.051 -0400", hash_original_field = "0C05A4177F6875FA787A21E57044823B", hash_generated_field = "0576C7FBD838C33267E15403FD6508A7")

    public static final int CONFIG_SCREEN_SIZE = 0x0400;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.139 -0400", hash_original_field = "6EA9B44B157EC42E35B9E5AEA1820A79", hash_generated_field = "4AC00F0D846EFC64A03124A0FAB57AB9")

    public static final int CONFIG_SMALLEST_SCREEN_SIZE = 0x0800;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.139 -0400", hash_original_field = "756A304CD3F21BC0AF009F4E7A4357E8", hash_generated_field = "5DFC0E02E808681E71B270AC339BA9B5")

    public static final int CONFIG_FONT_SCALE = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.140 -0400", hash_original_field = "97C80307FD849194597C8F245B288239", hash_generated_field = "ACD3D8E754C08B545F24096668975C7B")

    public static int[] CONFIG_NATIVE_BITS = new int[] {
        0x0001, 
        0x0002, 
        0x0004, 
        0x0008, 
        0x0010, 
        0x0020, 
        0x0040, 
        0x0080, 
        0x0800, 
        0x1000, 
        0x0200, 
        0x2000, 
    };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.140 -0400", hash_original_field = "2443C138297073D90686EFE7A98F5439", hash_generated_field = "351DF51F338F0BA21BC350720F4B5C56")

    public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:02.140 -0400", hash_original_field = "9059F3A3D7B4DF9CA5E75D5D8B5E910F", hash_generated_field = "04734804928EE89485FA43E2528A8EC1")

    public static final Parcelable.Creator<ActivityInfo> CREATOR
            = new Parcelable.Creator<ActivityInfo>() {
        public ActivityInfo createFromParcel(Parcel source) {
            return new ActivityInfo(source);
        }
        public ActivityInfo[] newArray(int size) {
            return new ActivityInfo[size];
        }
    };
}

