package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import android.os.Parcel;

public class TimedText {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.668 -0500", hash_original_field = "F1861F6BC5D6F9B7FF21432832EC545B", hash_generated_field = "E49CBDB7AE1F173AF5FB090FFC3C4FEB")

    private static final int FIRST_PUBLIC_KEY                 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.671 -0500", hash_original_field = "6A32400A98A7CDA150679BB2DA747578", hash_generated_field = "756BB9BF85C013682FF0E3FD9274AFE8")

    public static final int KEY_DISPLAY_FLAGS                 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.673 -0500", hash_original_field = "636769305F9D1CDD3DC577A3C02DAB34", hash_generated_field = "69B8F6A5FE4F2F2839EF6455F859A670")

    public static final int KEY_STYLE_FLAGS                   = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.676 -0500", hash_original_field = "C93188852B2E55F52899FBACA7C152D4", hash_generated_field = "FA331786EAA2BF7D9E250DD004CF64AE")

    public static final int KEY_BACKGROUND_COLOR_RGBA         = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.678 -0500", hash_original_field = "DE5F6C98672B1FB951BC763E1305451E", hash_generated_field = "909AC6DB5871265C59876AA1526B616E")

    public static final int KEY_HIGHLIGHT_COLOR_RGBA          = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.681 -0500", hash_original_field = "FC6F1B13D2F5E6A14705A34DEED92E6C", hash_generated_field = "D76117D0D2E4C721C1D5C277CCE42E6C")

    public static final int KEY_SCROLL_DELAY                  = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.683 -0500", hash_original_field = "E5E173C8152931C1ECF094672C1BB1B8", hash_generated_field = "459782586CD3A074DDF48E5ECA4E9DCA")

    public static final int KEY_WRAP_TEXT                     = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.686 -0500", hash_original_field = "71BF3D10A9F6EA6561A54F9A1AE8A731", hash_generated_field = "AD8EBFAB35C49468949CD74B277805E1")

    public static final int KEY_START_TIME                    = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.689 -0500", hash_original_field = "F09803E56066BC0697FB56EE3BCF978B", hash_generated_field = "757FC0BA5095E02F6EB5ADAD209562E8")

    public static final int KEY_STRUCT_BLINKING_TEXT_LIST     = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.692 -0500", hash_original_field = "49126C08630B11B3F9E5A14344D2F2B4", hash_generated_field = "AE72EE439207D43E5B2F46673852ECD2")

    public static final int KEY_STRUCT_FONT_LIST              = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.695 -0500", hash_original_field = "8BC7BCEB10D4DCAD91AD362E6DB5258F", hash_generated_field = "2B277711D2775F74051C742443DCE46B")

    public static final int KEY_STRUCT_HIGHLIGHT_LIST         = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.698 -0500", hash_original_field = "C94CD6BCE6CC132A15FB57E23CC73966", hash_generated_field = "F1D15C21031656129FDB6A4824C5351E")

    public static final int KEY_STRUCT_HYPER_TEXT_LIST        = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.700 -0500", hash_original_field = "9162C4A208074FB1B32B9F13F056FCB1", hash_generated_field = "7F78C6940BB6D4D1433A4A4A6DBB1BD6")

    public static final int KEY_STRUCT_KARAOKE_LIST           = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.703 -0500", hash_original_field = "E9835BE6A98BC4E4C4D0713A6151653B", hash_generated_field = "46841B190A8AC2A913DD735B32102ACA")

    public static final int KEY_STRUCT_STYLE_LIST             = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.705 -0500", hash_original_field = "16DD22F85335D150E688D36CCAE29E43", hash_generated_field = "A4C3426DBF4160840A50F43C5D8C1BB7")

    public static final int KEY_STRUCT_TEXT_POS               = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.708 -0500", hash_original_field = "8329692D0BC928A13A170481DB34C05B", hash_generated_field = "02A63134903AB0332C4FB38E7F99C8A4")

    public static final int KEY_STRUCT_JUSTIFICATION          = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.711 -0500", hash_original_field = "EF45C52F2258985DE900C92080DDA235", hash_generated_field = "A7D4F8A21510C2EF1D3DD4C9348F035F")

    public static final int KEY_STRUCT_TEXT                   = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.713 -0500", hash_original_field = "253DB3D5AEE773DBCFEEDBD9ECB659B9", hash_generated_field = "D6CDB3F416E9332C18F044FCED7C7805")

    private static final int LAST_PUBLIC_KEY                  = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.716 -0500", hash_original_field = "078B3949C083A661F3F762B8E4DC7261", hash_generated_field = "2585FF6EA61E16643876449F9A8E9CF0")

    private static final int FIRST_PRIVATE_KEY                = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.719 -0500", hash_original_field = "649FC8584607BDEFAA82026224E5EB0F", hash_generated_field = "550C60CC5B77ADDB55702D62270B89EE")

    // TextDescription.cpp in order to parce the Parcel.
    private static final int KEY_GLOBAL_SETTING               = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.721 -0500", hash_original_field = "D97FC93272257D7D3E13B9D7E70F8EFC", hash_generated_field = "AF786833E9592414AB3FACCD8D705017")

    private static final int KEY_LOCAL_SETTING                = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.723 -0500", hash_original_field = "452D4CA7BF9EF293D7B10D0848F0EE9C", hash_generated_field = "4A3F4BC414F60AC34EF0A80D3741EBB0")

    private static final int KEY_START_CHAR                   = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.726 -0500", hash_original_field = "49913A0CBFE60936A08B4D106208C38D", hash_generated_field = "492BD1082B2F5D61A0061B00F3D402B9")

    private static final int KEY_END_CHAR                     = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.729 -0500", hash_original_field = "F1273F4DEEC1739858586C3950445C35", hash_generated_field = "876978FBD1B317FD3184FA7D8A52F286")

    private static final int KEY_FONT_ID                      = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.732 -0500", hash_original_field = "C1C77E39F262E537160F69066FF6E2C8", hash_generated_field = "5D9D6ADAFA5F74ACEF0D43596D7D0699")

    private static final int KEY_FONT_SIZE                    = 106;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.735 -0500", hash_original_field = "C1841487556683997AD30559250F20C7", hash_generated_field = "E31A7E59F387C77F228551E51C68ADA8")

    private static final int KEY_TEXT_COLOR_RGBA              = 107;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.737 -0500", hash_original_field = "7BA610CD5AA1893951B928DE5F7E8D69", hash_generated_field = "9E87440B093016A8A449C0F9FD5AC96B")

    private static final int LAST_PRIVATE_KEY                 = 107;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.740 -0500", hash_original_field = "D9EC20834F60046692FB0AFA51963D72", hash_generated_field = "EB79CC8B0353C1EBD30F062C0FE6F44E")

    private static final String TAG = "TimedText";
    
    public class Text {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.782 -0500", hash_original_field = "4450067011D3443A982DEB734DBDA61A", hash_generated_field = "0ECB483397C115F5BEBC3D12F8A4E7BA")

        public int textLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.784 -0500", hash_original_field = "E00D1D0082AD932DD3F5C0D9AD4133DD", hash_generated_field = "9601616E43E4E097DEAC054F9AEDBD4F")

        public byte[] text;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.787 -0500", hash_original_method = "3E1AB979E39DEC5F091AD71588A6931C", hash_generated_method = "B4B0EE2ADFAA9EAFD131C65C61249187")
        
public Text() { }
        
    }
    
    public class CharPos {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.791 -0500", hash_original_field = "BEC46065010EFB8DDA3984AF07796B3E", hash_generated_field = "D65473A240F787EB4314A0C92140B20D")

        public int startChar = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.794 -0500", hash_original_field = "2ECE813F0F810A7DDBAA40AE40D12230", hash_generated_field = "D036BF036E621E284C0E7A802A8D318C")

        public int endChar = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.797 -0500", hash_original_method = "B16942A4D6AA45C219307E42B3F01C5E", hash_generated_method = "71A09C280485717F465665957F7BCE92")
        
public CharPos() { }
        
    }
    
    public class TextPos {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.801 -0500", hash_original_field = "FBE8F9853F7DE6E2CAA9BC6D1F97B5F2", hash_generated_field = "C64E12BBD149C4BCB4C390DD3A4FF679")

        public int top = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.804 -0500", hash_original_field = "36561B3CA2D33D39BEA116D4A44182D5", hash_generated_field = "0F1BF7E12681395349F7DA55DB5AA159")

        public int left = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.806 -0500", hash_original_field = "369BAF81555C727294653760CF0AB0E4", hash_generated_field = "1067FFF30733E18F84211D17469C765B")

        public int bottom = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.809 -0500", hash_original_field = "E376901BA012731AE0F9D15A694B5C77", hash_generated_field = "DB264BE310D82168147D88131DA0FEBB")

        public int right = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.811 -0500", hash_original_method = "533CD86BF5A1B326154330F052078462", hash_generated_method = "AFE384654E883283F76C244E6B13EC99")
        
public TextPos() { }
        
    }
    
    public class Justification {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.815 -0500", hash_original_field = "64B01D5D707A7ABBB6D7911DD27BCB15", hash_generated_field = "FEA5E3C4079F71C4123525CB7E2A737C")

        public int horizontalJustification = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.818 -0500", hash_original_field = "A0E18DAF8DD4B3E0E6C91A17828B0775", hash_generated_field = "F401193FEE37D866191F6648D7A82D32")

        public int verticalJustification = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.822 -0500", hash_original_method = "9DE1082C41237E4CAACC983D55330CCE", hash_generated_method = "62E69134EF1E0F0225472B309B28760C")
        
public Justification() { }
        
    }
    
    public class Style {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.827 -0500", hash_original_field = "BEC46065010EFB8DDA3984AF07796B3E", hash_generated_field = "D65473A240F787EB4314A0C92140B20D")

        public int startChar = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.829 -0500", hash_original_field = "2ECE813F0F810A7DDBAA40AE40D12230", hash_generated_field = "D036BF036E621E284C0E7A802A8D318C")

        public int endChar = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.831 -0500", hash_original_field = "5B7821AE7E7E96FB9228FDA0E79C378D", hash_generated_field = "D3DBED92BCC77A2766F38CBE573BA8FA")

        public int fontID = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.834 -0500", hash_original_field = "CAC86DCA0D32896481E81A736C3212E1", hash_generated_field = "DB5DB470B390D3AA5EC6FEED0BA82BC5")

        public boolean isBold = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.836 -0500", hash_original_field = "8205B3389DF0364A7D57BADA6F3BD8F6", hash_generated_field = "643A8D0A990D54B278905C83EA497448")

        public boolean isItalic = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.839 -0500", hash_original_field = "3B881F632FF5D28CFD44462F052789F4", hash_generated_field = "3D8C955C264DC3F085D41880E7F16D1D")

        public boolean isUnderlined = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.841 -0500", hash_original_field = "2DF74C4F4E2E3BF1139D124480646EE5", hash_generated_field = "0041E0CA609906878711183AD327D4AD")

        public int fontSize = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.844 -0500", hash_original_field = "B7A26EFDB6A747CF99CA322B47A72338", hash_generated_field = "ED3A4209C8320A0033FE8146EF308EE0")

        public int colorRGBA = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.847 -0500", hash_original_method = "A73FFEA889FA48444DBD29C5B6A4F060", hash_generated_method = "827679062E7E52DFA444DAD22218BC84")
        
public Style() { }
        
    }
    
    public class Font {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.852 -0500", hash_original_field = "9FDAA33DB7B4C2894424E413E1D5BD4D", hash_generated_field = "BF5B80C071A192E34C9E8DFC1250E4D5")

        public int ID = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.855 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

        public String name;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.857 -0500", hash_original_method = "9DB8E4889CA776938A054F1FA406F93D", hash_generated_method = "E68041F90AF5AA077159787B096D5FBE")
        
public Font() { }
        
    }
    
    public class Karaoke {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.861 -0500", hash_original_field = "A0B3BAC3121C72A80108375A7330A360", hash_generated_field = "A3ACF88B9728F52220895FE4A0056B40")

        public int startTimeMs = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.864 -0500", hash_original_field = "374AF28FF8BC5A5C3EEE651FFF8F4E1B", hash_generated_field = "87669B6E364BF92F363BC6940EA6244D")

        public int endTimeMs = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.867 -0500", hash_original_field = "BEC46065010EFB8DDA3984AF07796B3E", hash_generated_field = "D65473A240F787EB4314A0C92140B20D")

        public int startChar = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.869 -0500", hash_original_field = "2ECE813F0F810A7DDBAA40AE40D12230", hash_generated_field = "D036BF036E621E284C0E7A802A8D318C")

        public int endChar = -1;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.872 -0500", hash_original_method = "20387F8DBBE28B02B4D4A333BCD1DC01", hash_generated_method = "7C8CDED970E3C90251249AEA32944455")
        
public Karaoke() { }
        
    }
    
    public class HyperText {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.877 -0500", hash_original_field = "BEC46065010EFB8DDA3984AF07796B3E", hash_generated_field = "D65473A240F787EB4314A0C92140B20D")

        public int startChar = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.879 -0500", hash_original_field = "2ECE813F0F810A7DDBAA40AE40D12230", hash_generated_field = "D036BF036E621E284C0E7A802A8D318C")

        public int endChar = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.881 -0500", hash_original_field = "8825D53582214EFCEB454B1220ED00E5", hash_generated_field = "31F0908C5724FBF0AFE05E1CB5F4B4DD")

        public String URL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.884 -0500", hash_original_field = "0548884C8EB5AE357930F79E8479456F", hash_generated_field = "D864AED02507FC933FD7E405F27F0330")

        public String altString;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.887 -0500", hash_original_method = "B6B5545C3ABD1F1E6601A7A1C2669923", hash_generated_method = "582775EA9E4FB8E7B5ACD4E5751B1179")
        
public HyperText() { }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.742 -0500", hash_original_field = "692CCB5FAB3D10FD8D970E4A07D6305C", hash_generated_field = "BB91EE8BB361270D3F9E96BDF275F77B")

    private Parcel mParcel = Parcel.obtain();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.745 -0500", hash_original_field = "1EF8093BDAB30375FC8B40761872B101", hash_generated_field = "EC5144F1059594ED79C7BE9A57DB8642")

    private final HashMap<Integer, Object> mKeyObjectMap =
            new HashMap<Integer, Object>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.747 -0500", hash_original_field = "3848A8A74E7CB61271DAF967ED91A66C", hash_generated_field = "80B2AE705A93483E0330D6F3D591DCEE")

    private int mDisplayFlags = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.750 -0500", hash_original_field = "0EA231E83D0A73509AD8D6D84F0F468E", hash_generated_field = "C453002A9E2C70445EB5199BE9B08059")

    private int mBackgroundColorRGBA = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.753 -0500", hash_original_field = "0373BED6F00A1266A3102FD2784AEECF", hash_generated_field = "31B8CD0D5AF7DFD87BA6E1CF70ABFB5F")

    private int mHighlightColorRGBA = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.755 -0500", hash_original_field = "4B411D6E1EA4CBB422837539E3D5EAAA", hash_generated_field = "6C96939CB5EB119D39955D86F77AB19B")

    private int mScrollDelay = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.757 -0500", hash_original_field = "3F76950B14C3EDC8D4718AEA6D9CB4AA", hash_generated_field = "036450566A3148835EE1A26286BC0ED1")

    private int mWrapText = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.760 -0500", hash_original_field = "8BCA25F71C4312A6750C9479542F8B47", hash_generated_field = "A15DDCA0E18A78ADEB869939295D7F43")

    private List<CharPos> mBlinkingPosList = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.762 -0500", hash_original_field = "2E7FF924CEA6D46E294320D13063A485", hash_generated_field = "DB74E93421E71106F88913A1AFB7B88A")

    private List<CharPos> mHighlightPosList = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.764 -0500", hash_original_field = "88F6A144764BC1A1ADAE4046E4A2CBD2", hash_generated_field = "FB398A4A7BD2FF6E3F6566BBB16FE725")

    private List<Karaoke> mKaraokeList = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.767 -0500", hash_original_field = "4E2AFB6393AC2E78F7526E1BC97CFF8B", hash_generated_field = "C1A505F457778FCB09CC9D54A415631E")

    private List<Font> mFontList = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.769 -0500", hash_original_field = "6BC48ABB7AF4163D4650DEF434E56991", hash_generated_field = "68E6863308C67DE90672639469C7B66A")

    private List<Style> mStyleList = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.771 -0500", hash_original_field = "DF261E7E1CE28FF6088336017ECFC6CB", hash_generated_field = "7D062F7EF76BD004C2E665883B094002")

    private List<HyperText> mHyperTextList = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.773 -0500", hash_original_field = "3491C39554D0B35B78418CA1261CB515", hash_generated_field = "1BF0EA15C173D16323FE9F74B1AD8364")

    private TextPos mTextPos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.776 -0500", hash_original_field = "58C98E0408C50A6BD64F8CAD24CB85FD", hash_generated_field = "D18AAA756EFD16ACECFD20B5F9951651")

    private Justification mJustification;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.779 -0500", hash_original_field = "C49CA782578AF82A90F8DC9BDE57BBF4", hash_generated_field = "616503694D60DD8DA85A8F29EBD2A282")

    private Text mTextStruct;

    /**
     * @param obj the byte array which contains the timed text.
     * @throws IllegalArgumentExcept if parseParcel() fails.
     * {@hide}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.892 -0500", hash_original_method = "20C0CCB7F458006F6F50D13C409F05F4", hash_generated_method = "8F0164FF1DEC19D0093D595A4FEC2E5E")
    
public TimedText(byte[] obj) {
        mParcel.unmarshall(obj, 0, obj.length);

        if (!parseParcel()) {
            mKeyObjectMap.clear();
            throw new IllegalArgumentException("parseParcel() fails");
        }
    }

    /**
     * Go over all the records, collecting metadata keys and fields in the
     * Parcel. These are stored in mKeyObjectMap for application to retrieve.
     * @return false if an error occurred during parsing. Otherwise, true.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.896 -0500", hash_original_method = "791BBBBBE0FA40697270B44A4D66C782", hash_generated_method = "6BE5A66C72A82CFFA51BE96C76461E51")
    
private boolean parseParcel() {
        mParcel.setDataPosition(0);
        if (mParcel.dataAvail() == 0) {
            return false;
        }

        int type = mParcel.readInt();
        if (type == KEY_LOCAL_SETTING) {
            type = mParcel.readInt();
            if (type != KEY_START_TIME) {
                return false;
            }
            int mStartTimeMs = mParcel.readInt();
            mKeyObjectMap.put(type, mStartTimeMs);

            type = mParcel.readInt();
            if (type != KEY_STRUCT_TEXT) {
                return false;
            }

            mTextStruct = new Text();
            mTextStruct.textLen = mParcel.readInt();

            mTextStruct.text = mParcel.createByteArray();
            mKeyObjectMap.put(type, mTextStruct);

        } else if (type != KEY_GLOBAL_SETTING) {
            Log.w(TAG, "Invalid timed text key found: " + type);
            return false;
        }

        while (mParcel.dataAvail() > 0) {
            int key = mParcel.readInt();
            if (!isValidKey(key)) {
                Log.w(TAG, "Invalid timed text key found: " + key);
                return false;
            }

            Object object = null;

            switch (key) {
                case KEY_STRUCT_STYLE_LIST: {
                    readStyle();
                    object = mStyleList;
                    break;
                }
                case KEY_STRUCT_FONT_LIST: {
                    readFont();
                    object = mFontList;
                    break;
                }
                case KEY_STRUCT_HIGHLIGHT_LIST: {
                    readHighlight();
                    object = mHighlightPosList;
                    break;
                }
                case KEY_STRUCT_KARAOKE_LIST: {
                    readKaraoke();
                    object = mKaraokeList;
                    break;
                }
                case KEY_STRUCT_HYPER_TEXT_LIST: {
                    readHyperText();
                    object = mHyperTextList;

                    break;
                }
                case KEY_STRUCT_BLINKING_TEXT_LIST: {
                    readBlinkingText();
                    object = mBlinkingPosList;

                    break;
                }
                case KEY_WRAP_TEXT: {
                    mWrapText = mParcel.readInt();
                    object = mWrapText;
                    break;
                }
                case KEY_HIGHLIGHT_COLOR_RGBA: {
                    mHighlightColorRGBA = mParcel.readInt();
                    object = mHighlightColorRGBA;
                    break;
                }
                case KEY_DISPLAY_FLAGS: {
                    mDisplayFlags = mParcel.readInt();
                    object = mDisplayFlags;
                    break;
                }
                case KEY_STRUCT_JUSTIFICATION: {
                    mJustification = new Justification();

                    mJustification.horizontalJustification = mParcel.readInt();
                    mJustification.verticalJustification = mParcel.readInt();

                    object = mJustification;
                    break;
                }
                case KEY_BACKGROUND_COLOR_RGBA: {
                    mBackgroundColorRGBA = mParcel.readInt();
                    object = mBackgroundColorRGBA;
                    break;
                }
                case KEY_STRUCT_TEXT_POS: {
                    mTextPos = new TextPos();

                    mTextPos.top = mParcel.readInt();
                    mTextPos.left = mParcel.readInt();
                    mTextPos.bottom = mParcel.readInt();
                    mTextPos.right = mParcel.readInt();

                    object = mTextPos;
                    break;
                }
                case KEY_SCROLL_DELAY: {
                    mScrollDelay = mParcel.readInt();
                    object = mScrollDelay;
                    break;
                }
                default: {
                    break;
                }
            }

            if (object != null) {
                if (mKeyObjectMap.containsKey(key)) {
                    mKeyObjectMap.remove(key);
                }
                mKeyObjectMap.put(key, object);
            }
        }

        mParcel.recycle();
        return true;
    }

    /**
     * To parse and store the Style list.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.899 -0500", hash_original_method = "0BA14F4ADFDDDB9356E71AC4A1ECA0E9", hash_generated_method = "169953A403CAD937E71E29022A5A362F")
    
private void readStyle() {
        Style style = new Style();
        boolean endOfStyle = false;

        while (!endOfStyle && (mParcel.dataAvail() > 0)) {
            int key = mParcel.readInt();
            switch (key) {
                case KEY_START_CHAR: {
                    style.startChar = mParcel.readInt();
                    break;
                }
                case KEY_END_CHAR: {
                    style.endChar = mParcel.readInt();
                    break;
                }
                case KEY_FONT_ID: {
                    style.fontID = mParcel.readInt();
                    break;
                }
                case KEY_STYLE_FLAGS: {
                    int flags = mParcel.readInt();
                    // In the absence of any bits set in flags, the text
                    // is plain. Otherwise, 1: bold, 2: italic, 4: underline
                    style.isBold = ((flags % 2) == 1);
                    style.isItalic = ((flags % 4) >= 2);
                    style.isUnderlined = ((flags / 4) == 1);
                    break;
                }
                case KEY_FONT_SIZE: {
                    style.fontSize = mParcel.readInt();
                    break;
                }
                case KEY_TEXT_COLOR_RGBA: {
                    style.colorRGBA = mParcel.readInt();
                    break;
                }
                default: {
                    // End of the Style parsing. Reset the data position back
                    // to the position before the last mParcel.readInt() call.
                    mParcel.setDataPosition(mParcel.dataPosition() - 4);
                    endOfStyle = true;
                    break;
                }
            }
        }

        if (mStyleList == null) {
            mStyleList = new ArrayList<Style>();
        }
        mStyleList.add(style);
    }

    /**
     * To parse and store the Font list
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.902 -0500", hash_original_method = "00AE5F5A406478801ABD16E12F474E1A", hash_generated_method = "4828E10B4D78E9B684F86709410BF1C4")
    
private void readFont() {
        int entryCount = mParcel.readInt();

        for (int i = 0; i < entryCount; i++) {
            Font font = new Font();

            font.ID = mParcel.readInt();
            int nameLen = mParcel.readInt();

            byte[] text = mParcel.createByteArray();
            font.name = new String(text, 0, nameLen);

            if (mFontList == null) {
                mFontList = new ArrayList<Font>();
            }
            mFontList.add(font);
        }
    }

    /**
     * To parse and store the Highlight list
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.904 -0500", hash_original_method = "89A8EBF8FEFD90B855BF480125FCEA6A", hash_generated_method = "24868BA389A9EF1988E4307F847489A7")
    
private void readHighlight() {
        CharPos pos = new CharPos();

        pos.startChar = mParcel.readInt();
        pos.endChar = mParcel.readInt();

        if (mHighlightPosList == null) {
            mHighlightPosList = new ArrayList<CharPos>();
        }
        mHighlightPosList.add(pos);
    }

    /**
     * To parse and store the Karaoke list
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.907 -0500", hash_original_method = "9FC931A03E07E67B33BB5A4FA8F46AC4", hash_generated_method = "01C5EF5795B351A3BE1C30AD17B445BE")
    
private void readKaraoke() {
        int entryCount = mParcel.readInt();

        for (int i = 0; i < entryCount; i++) {
            Karaoke kara = new Karaoke();

            kara.startTimeMs = mParcel.readInt();
            kara.endTimeMs = mParcel.readInt();
            kara.startChar = mParcel.readInt();
            kara.endChar = mParcel.readInt();

            if (mKaraokeList == null) {
                mKaraokeList = new ArrayList<Karaoke>();
            }
            mKaraokeList.add(kara);
        }
    }

    /**
     * To parse and store HyperText list
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.910 -0500", hash_original_method = "76399CA140680AA49BE7C693D75B5452", hash_generated_method = "AE1B956E482E3895DADD3266E599D404")
    
private void readHyperText() {
        HyperText hyperText = new HyperText();

        hyperText.startChar = mParcel.readInt();
        hyperText.endChar = mParcel.readInt();

        int len = mParcel.readInt();
        byte[] url = mParcel.createByteArray();
        hyperText.URL = new String(url, 0, len);

        len = mParcel.readInt();
        byte[] alt = mParcel.createByteArray();
        hyperText.altString = new String(alt, 0, len);

        if (mHyperTextList == null) {
            mHyperTextList = new ArrayList<HyperText>();
        }
        mHyperTextList.add(hyperText);
    }

    /**
     * To parse and store blinking text list
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.913 -0500", hash_original_method = "9C2885E2BFC08F88B4AF57AA760616C2", hash_generated_method = "703A1692EF67AAA49968A6A28EF906E7")
    
private void readBlinkingText() {
        CharPos blinkingPos = new CharPos();

        blinkingPos.startChar = mParcel.readInt();
        blinkingPos.endChar = mParcel.readInt();

        if (mBlinkingPosList == null) {
            mBlinkingPosList = new ArrayList<CharPos>();
        }
        mBlinkingPosList.add(blinkingPos);
    }

    /**
     * To check whether the given key is valid.
     * @param key the key to be checked.
     * @return true if the key is a valid one. Otherwise, false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.916 -0500", hash_original_method = "9BAFED3979BE76875AB5C6D705EB5845", hash_generated_method = "B0D28E477AE1051838EDCA4842E661F3")
    
public boolean isValidKey(final int key) {
        if (!((key >= FIRST_PUBLIC_KEY) && (key <= LAST_PUBLIC_KEY))
                && !((key >= FIRST_PRIVATE_KEY) && (key <= LAST_PRIVATE_KEY))) {
            return false;
        }
        return true;
    }

    /**
     * To check whether the given key is contained in this TimedText object.
     * @param key the key to be checked.
     * @return true if the key is contained in this TimedText object.
     *         Otherwise, false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.918 -0500", hash_original_method = "9397D6B2A6748EB9B0D75013A7674AB7", hash_generated_method = "8441653A556B6D938EDE0D9BE061E5BE")
    
public boolean containsKey(final int key) {
        if (isValidKey(key) && mKeyObjectMap.containsKey(key)) {
            return true;
        }
        return false;
    }
    /**
     * @return a set of the keys contained in this TimedText object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.920 -0500", hash_original_method = "D714619D6E49B86D75D24C1705999B69", hash_generated_method = "F22291B8058E4EB874E8972B3A5BB9D5")
    
public Set keySet() {
        return mKeyObjectMap.keySet();
    }

    /**
     * To retrieve the object associated with the key. Caller must make sure
     * the key is present using the containsKey method otherwise a
     * RuntimeException will occur.
     * @param key the key used to retrieve the object.
     * @return an object. The object could be an instanceof Integer, List, or
     * any of the helper classes such as TextPos, Justification, and Text.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:28.923 -0500", hash_original_method = "E013B89BFA963BB8F029FE138EDADA51", hash_generated_method = "B0E07293DB75810A5A2AA30BDC7B95BD")
    
public Object getObject(final int key) {
        if (containsKey(key)) {
            return mKeyObjectMap.get(key);
        } else {
            throw new IllegalArgumentException("Invalid key: " + key);
        }
    }
}

