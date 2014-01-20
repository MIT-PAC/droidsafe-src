package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Printer;

public class ActivityInfo extends ComponentInfo implements Parcelable {
    
    public static int activityInfoConfigToNative(int input){
		return input;
		// Original method
		/*
		{
        int output = 0;
        for (int i=0; i<CONFIG_NATIVE_BITS.length; i++) {
            if ((input&(1<<i)) != 0) {
                output |= CONFIG_NATIVE_BITS[i];
            }
        }
        return output;
    }
		*/
	}
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.163 -0500", hash_original_field = "D19093F67CB9A0F84B096A58770A4664", hash_generated_field = "97A05F3EFCDB13E39BC3ACB57277040B")

    public static final int LAUNCH_MULTIPLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.165 -0500", hash_original_field = "26FA0C084D7EA9714FBC6A59FB7C272D", hash_generated_field = "3346F153D56014348EA4AABCC632FEC7")

    public static final int LAUNCH_SINGLE_TOP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.168 -0500", hash_original_field = "4BEC13F1256843AE1F2FEBC18F8FB465", hash_generated_field = "274027FCAA4012389CEE68B6058B89B1")

    public static final int LAUNCH_SINGLE_TASK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.170 -0500", hash_original_field = "938752EAC0A9B157D042DFD75D2051BA", hash_generated_field = "429EC3FADE282AD238148C52EB4272A8")

    public static final int LAUNCH_SINGLE_INSTANCE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.181 -0500", hash_original_field = "75F7AC449D1F1D6B3B370218A9D547EA", hash_generated_field = "E10ACE5AB39803D2DD5BD3FB31DB605E")

    public static final int FLAG_MULTIPROCESS = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.183 -0500", hash_original_field = "D52ACB7DBCAB7109F3C19327AA2F1D17", hash_generated_field = "7A7185CF558C460C5BAA6804AF709870")

    public static final int FLAG_FINISH_ON_TASK_LAUNCH = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.186 -0500", hash_original_field = "4AEBBBF929064A0B1378E302360DDBBB", hash_generated_field = "26E518A39B4CAF219C69B3E718A86691")

    public static final int FLAG_CLEAR_TASK_ON_LAUNCH = 0x0004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.188 -0500", hash_original_field = "28B55BF936BB0CC959060376B2A559B1", hash_generated_field = "71217956806EFD13BDA790423AF010D6")

    public static final int FLAG_ALWAYS_RETAIN_TASK_STATE = 0x0008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.190 -0500", hash_original_field = "458AB231BAB6DE21E292A251ADC89ABC", hash_generated_field = "EE6215FB7A481181A853996AA2E14DBF")

    public static final int FLAG_STATE_NOT_NEEDED = 0x0010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.192 -0500", hash_original_field = "8512A224AC5D3657AE7E0F657380E4C3", hash_generated_field = "9E30A9653012F6BF0551A8232A6322D6")

    public static final int FLAG_EXCLUDE_FROM_RECENTS = 0x0020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.194 -0500", hash_original_field = "C6C372CE57C86635014AEDF8A9C7AE8A", hash_generated_field = "93F5FF1DF9125B7794713028E8C4D08B")

    public static final int FLAG_ALLOW_TASK_REPARENTING = 0x0040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.196 -0500", hash_original_field = "CC6109F755E43C8C5F69C44034C6E4F9", hash_generated_field = "356D126C83E7B4704E2534452CA43637")

    public static final int FLAG_NO_HISTORY = 0x0080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.199 -0500", hash_original_field = "7A9683D89A71684C107C0C6C975E5F85", hash_generated_field = "AE2DC166D5DC2D8B5E1564A26130A703")

    public static final int FLAG_FINISH_ON_CLOSE_SYSTEM_DIALOGS = 0x0100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.203 -0500", hash_original_field = "798996E48539C3409140F6FDC4C28568", hash_generated_field = "CA6915BA5049341568E8C11126058F20")

    public static final int FLAG_HARDWARE_ACCELERATED = 0x0200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.205 -0500", hash_original_field = "E30C5C12450337BE4604FE7472049E3A", hash_generated_field = "BA8A64B3ECA3E30985E745EF97C29C4F")

    public static final int FLAG_IMMERSIVE = 0x0400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.209 -0500", hash_original_field = "82B28947E0AF101BFD7EDBFD3BA5F5BF", hash_generated_field = "4EE91C87E229BD888491D41B6FFA2087")

    public static final int SCREEN_ORIENTATION_UNSPECIFIED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.211 -0500", hash_original_field = "E27BBA2A01E67419CABABFAF145F3BB9", hash_generated_field = "51E03776BE2DD6980AA26F97BE6FF149")

    public static final int SCREEN_ORIENTATION_LANDSCAPE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.214 -0500", hash_original_field = "836522669CE4663DFA6B1F41B33963B2", hash_generated_field = "88A2FE9E0A0F12C9AE10A2BFC22DE8B8")

    public static final int SCREEN_ORIENTATION_PORTRAIT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.216 -0500", hash_original_field = "A903D352B596C3DF2C3A98C2148817A1", hash_generated_field = "809E4F9E456EBA59575E190A9761FCF8")

    public static final int SCREEN_ORIENTATION_USER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.218 -0500", hash_original_field = "B7A2CE233CDF0387B2EC61564A26C56A", hash_generated_field = "9EB8AF2D3510751A7ADEEB293663A365")

    public static final int SCREEN_ORIENTATION_BEHIND = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.221 -0500", hash_original_field = "3FD7DC930AFB1D4067D33C3AE95061B7", hash_generated_field = "082D68ED3A8B5E41CD54764495EF3F3C")

    public static final int SCREEN_ORIENTATION_SENSOR = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.223 -0500", hash_original_field = "F53F19DDC00FA2392C604FBF566B0E3C", hash_generated_field = "09B898BC316947914416072F01817041")

    public static final int SCREEN_ORIENTATION_NOSENSOR = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.225 -0500", hash_original_field = "381B4B9F4A20741DE9A58DFC59FCB6B3", hash_generated_field = "B42F8A51DB28D288AB762EDE0064CC99")

    public static final int SCREEN_ORIENTATION_SENSOR_LANDSCAPE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.228 -0500", hash_original_field = "0BB08BB5461EFD34709CB4188DAF8234", hash_generated_field = "7590EF159EA1676F45C451D9D09538EA")

    public static final int SCREEN_ORIENTATION_SENSOR_PORTRAIT = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.231 -0500", hash_original_field = "243B444F5442812B846E5041EDE598C2", hash_generated_field = "036D6CA8B87C65ADA879EA52998AA962")

    public static final int SCREEN_ORIENTATION_REVERSE_LANDSCAPE = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.233 -0500", hash_original_field = "C4DC79A5FD1F1EBFC1B46C0B51C9FD01", hash_generated_field = "E66D17CEF1E27011C8367816474F48EF")

    public static final int SCREEN_ORIENTATION_REVERSE_PORTRAIT = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.235 -0500", hash_original_field = "74051D8D64CDC149324399E6AF1DF156", hash_generated_field = "28FEA547E8D1B40DE8A2FE15BEC645AC")

    public static final int SCREEN_ORIENTATION_FULL_SENSOR = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.239 -0500", hash_original_field = "C9905CCD43F9D3827A925ED97F34272D", hash_generated_field = "0E2BF712ED9D4CC79F08860395DA25DF")

    public static final int CONFIG_MCC = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.242 -0500", hash_original_field = "FD15EE003BF9224D67E51690926D4074", hash_generated_field = "2E711D8CDADEDE68279C80B62C1E9FC6")

    public static final int CONFIG_MNC = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.244 -0500", hash_original_field = "C877BC270C98105BC18574F5B3F60293", hash_generated_field = "7FDD2B692126BEFCFAEE202D9B8688E8")

    public static final int CONFIG_LOCALE = 0x0004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.246 -0500", hash_original_field = "4846887B3BAE7C9961B4262C872E08C8", hash_generated_field = "E6685BED680245CBD03F43F4A75D9AB3")

    public static final int CONFIG_TOUCHSCREEN = 0x0008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.249 -0500", hash_original_field = "37FDF26F06B0CBE9C05B85311DB90DCA", hash_generated_field = "16B50005BCF39890424F730B7C729D86")

    public static final int CONFIG_KEYBOARD = 0x0010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.251 -0500", hash_original_field = "6A834D9ED438F8035934EA9F82F69729", hash_generated_field = "0969B2213D8306E2A4EFE82F986CD5B8")

    public static final int CONFIG_KEYBOARD_HIDDEN = 0x0020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.253 -0500", hash_original_field = "1D96FA0D929D95A283607117164B08F2", hash_generated_field = "B4CCFA896DAA369294842419E2C450A0")

    public static final int CONFIG_NAVIGATION = 0x0040;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.256 -0500", hash_original_field = "26E189573FCA8A4309CAEC3D072D43EB", hash_generated_field = "D0CE0746E82DAAD347064D78B16961DE")

    public static final int CONFIG_ORIENTATION = 0x0080;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.258 -0500", hash_original_field = "9C43468E8311EA64006756E10869A7EF", hash_generated_field = "21B6DB04E1224EDE72327EB73DCE8948")

    public static final int CONFIG_SCREEN_LAYOUT = 0x0100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.260 -0500", hash_original_field = "2D63B40BF2FAD098711CFD0D2C6F6897", hash_generated_field = "5413F783BC23EAD9A791F333D3755C37")

    public static final int CONFIG_UI_MODE = 0x0200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.264 -0500", hash_original_field = "94726786DD0938BEE31461A0DC24C115", hash_generated_field = "0576C7FBD838C33267E15403FD6508A7")

    public static final int CONFIG_SCREEN_SIZE = 0x0400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.266 -0500", hash_original_field = "034352348B3FA83EA0090275B28145D6", hash_generated_field = "4AC00F0D846EFC64A03124A0FAB57AB9")

    public static final int CONFIG_SMALLEST_SCREEN_SIZE = 0x0800;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.268 -0500", hash_original_field = "B63C329349BACB681736FD55D9AC6C9D", hash_generated_field = "5DFC0E02E808681E71B270AC339BA9B5")

    public static final int CONFIG_FONT_SCALE = 0x40000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.270 -0500", hash_original_field = "FFA89214F690AF42CD319E87B7BA4E07", hash_generated_field = "CFFF83F209312E1529E6C8A3FF91CFBA")

    public static int[] CONFIG_NATIVE_BITS = new int[] {
        0x0001, // MNC
        0x0002, // MCC
        0x0004, // LOCALE
        0x0008, // TOUCH SCREEN
        0x0010, // KEYBOARD
        0x0020, // KEYBOARD HIDDEN
        0x0040, // NAVIGATION
        0x0080, // ORIENTATION
        0x0800, // SCREEN LAYOUT
        0x1000, // UI MODE
        0x0200, // SCREEN SIZE
        0x2000, // SMALLEST SCREEN SIZE
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.283 -0500", hash_original_field = "56299B7E478E5B3692F5C2B8B4497274", hash_generated_field = "351DF51F338F0BA21BC350720F4B5C56")

    public static final int UIOPTION_SPLIT_ACTION_BAR_WHEN_NARROW = 1;
    public static final Parcelable.Creator<ActivityInfo> CREATOR
            = new Parcelable.Creator<ActivityInfo>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.303 -0500", hash_original_method = "7881E2AE5504281E1113E4204713DBE5", hash_generated_method = "59E2D7F3641921FBF670094B2FEECFB8")
        
public ActivityInfo createFromParcel(Parcel source) {
            return new ActivityInfo(source);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.305 -0500", hash_original_method = "55042204736C415254FD6A445E807C5C", hash_generated_method = "5212A3765BAA70AFCEEA3E9D00D39FC2")
        
public ActivityInfo[] newArray(int size) {
            return new ActivityInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.161 -0500", hash_original_field = "45D39EA345E2D2EE1A81DB875640D024", hash_generated_field = "A97FD2465AC4AAA472175729CDE0BBF3")

    public int theme;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.172 -0500", hash_original_field = "67BDC224DE71D71EB7F1A7B92C0FDD29", hash_generated_field = "44DED241F3CE7B79E35C4E3B1267012B")

    public int launchMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.174 -0500", hash_original_field = "6CAD99B186075AF38B34666A3804B23C", hash_generated_field = "3670CE1CBA400C10EB64B3D7DD616511")

    public String permission;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.176 -0500", hash_original_field = "1496746C771ADF266B3C98437087C3C9", hash_generated_field = "7AA799578052361E8AB8F2E0B535D75E")

    public String taskAffinity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.178 -0500", hash_original_field = "67935618967AF48C3656DFB0BB382185", hash_generated_field = "B7B6389CFB3895770F2F6EE8D0A8782B")

    public String targetActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.207 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.237 -0500", hash_original_field = "7ADA9CD087C2837FDDBB7D4B669CF913", hash_generated_field = "DEB1388656DED838D1768D719876593D")

    public int screenOrientation = SCREEN_ORIENTATION_UNSPECIFIED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.277 -0500", hash_original_field = "4C176A5E0E8ADF1A90A87F3803814492", hash_generated_field = "FDFF8A48AEB40DAF58DDD31BD86042B9")

    public int configChanges;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.279 -0500", hash_original_field = "E191C85AC29CBA81CD76EDE74703370C", hash_generated_field = "3D8BA35B328FE1B6C6D3197F4C56033F")

    public int softInputMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.281 -0500", hash_original_field = "847777BDD2DCF34920040D6850615B57", hash_generated_field = "9FF841B59BE996A97456D758065D4280")

    public int uiOptions = 0;
    // orphaned legacy field
    public String parentActivityName;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.285 -0500", hash_original_method = "AADA555071E489A7B136029649F29F63", hash_generated_method = "9A690FFA3F11B547A41D0A455A52FE55")
    
public ActivityInfo() {
    }
    
    public ActivityInfo(ActivityInfo orig){
		super(orig);
		addTaint(orig.getTaint());
		/*
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
		*/
	}
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private ActivityInfo(Parcel source) {
    	super(source);
        addTaint(source.readInt()); //theme
        addTaint(source.readInt()); //launchMode
        permission = source.readString();
        //addTaint(source.readString().getTaint()); //permission
        taskAffinity = source.readString();
        //addTaint(source.readString().getTaint()); //taskAffinity
        targetActivity = source.readString();
        //addTaint(source.readString().getTaint()); //targetActivity
        addTaint(source.readInt()); //flags
        addTaint(source.readInt()); //screenOrientation
        addTaint(source.readInt()); //configChanges
        addTaint(source.readInt()); //softInputMode
        addTaint(source.readInt()); //uiOptions
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public int getRealConfigChanged(){
		// Original method
		/*
		{
        return applicationInfo.targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB_MR2
                ? (configChanges | ActivityInfo.CONFIG_SCREEN_SIZE
                        | ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE)
                : configChanges;
    }
		*/
		return 0;
	}
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public final int getThemeResource() {
        return getTaintInt();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    public void dump(Printer pw, String prefix){
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		//Return nothing
	}
    
    public String toString(){
        String str = new String();
        str.addTaint(getTaint());
        return str;
		// Original method
		/*
		{
        return "ActivityInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + name + "}";
    }
		*/
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.298 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:00.300 -0500", hash_original_method = "0DBABFC7118E214F01D60FEE309F0914", hash_generated_method = "851AB96AA67DE049FD493A6EC3253DE4")
    
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
    }
    
}

