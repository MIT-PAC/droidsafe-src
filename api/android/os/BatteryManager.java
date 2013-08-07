package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;



public class BatteryManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.640 -0400", hash_original_method = "46CB3C3298CDC989655A7D5A93769408", hash_generated_method = "46CB3C3298CDC989655A7D5A93769408")
    public BatteryManager ()
    {
        //Synthesized constructor
    }


    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.640 -0400", hash_original_field = "D52B717AA6260922B5C33ADA654C939E", hash_generated_field = "BCC0736EDE3B26CB905D1BB3B56EDBCE")

    public static final String EXTRA_STATUS = "status";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.640 -0400", hash_original_field = "88325C91CB073AFB53F744955F785736", hash_generated_field = "F3D41227E93BCCA3BD670F6F01E09F4A")

    public static final String EXTRA_HEALTH = "health";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.640 -0400", hash_original_field = "3A439664A4D47F74D25F16D012D2A12E", hash_generated_field = "C026888824D5E8B465CFAF202E21B5A9")

    public static final String EXTRA_PRESENT = "present";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.640 -0400", hash_original_field = "05D448E35B40F3768C81F23BC8560B52", hash_generated_field = "3326991A78A7A7DC44362730BB946B03")

    public static final String EXTRA_LEVEL = "level";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.640 -0400", hash_original_field = "F0AC4E49251BABB9695384CE8F6B89C0", hash_generated_field = "C1ECA1F3CE4E811D1F54D1D66199D9E3")

    public static final String EXTRA_SCALE = "scale";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "7B905488E0F27F38E7CE4DC07DD604C4", hash_generated_field = "A7CB7717E5C3493E8E6A45316CC93D5C")

    public static final String EXTRA_ICON_SMALL = "icon-small";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "AFFBB0FA334A6773C430697ACB7BDDD9", hash_generated_field = "A975D8190BDB7566D76D51B390DA41D4")

    public static final String EXTRA_PLUGGED = "plugged";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "B5FED427D2F7DF0533B0C99EFD399CD1", hash_generated_field = "B0643E89516B759A769263EC1314FDF6")

    public static final String EXTRA_VOLTAGE = "voltage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "E2F5CACC0A67D5AA5DFDC8C344EAC26D", hash_generated_field = "D3F71A67FBB3E8CB6CEB087295549858")

    public static final String EXTRA_TEMPERATURE = "temperature";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "F251E1C6169171774FA7E93AA2C49504", hash_generated_field = "3BAB33272C3009DF4CE97081B3E042F6")

    public static final String EXTRA_TECHNOLOGY = "technology";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "D6134E70B3AEBFAA9DD0EB0965DDC534", hash_generated_field = "950280DD5A04B3E663E9CBD797E4D667")

    public static final String EXTRA_INVALID_CHARGER = "invalid_charger";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "3057E0E9D36B04DEB54FA5E0B54428C9", hash_generated_field = "D19868B109B988139D5EB4348F770E35")

    public static final int BATTERY_STATUS_UNKNOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "8B0BEE6A40E607BAD09B2F72DA69AE44", hash_generated_field = "9DFBF21AF2D6B57E7B98290BDBDD5420")

    public static final int BATTERY_STATUS_CHARGING = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "4ACB18A1AE0BD9F6BC2DEEE032321A12", hash_generated_field = "A99FB7B4897AF92317F8A6AEF63D81A5")

    public static final int BATTERY_STATUS_DISCHARGING = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "CB49BDDCAAE811902746DC62A583AD6C", hash_generated_field = "FA63AC00D5A226107FB7EC7F687CAD01")

    public static final int BATTERY_STATUS_NOT_CHARGING = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "231949B600F0612547DA203BC83944BB", hash_generated_field = "6E5572CA1D35BA3A4F7FB713E8DFA8D3")

    public static final int BATTERY_STATUS_FULL = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "C057F5AB8D6892D3E1E6F7CF55DDC90C", hash_generated_field = "1BFB46E805C08D368E565958DB9A2A99")

    public static final int BATTERY_HEALTH_UNKNOWN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.641 -0400", hash_original_field = "B853559CFDD10B9C8BE27D057D625E66", hash_generated_field = "3675916AEF9AB16398BF7333BF6406FB")

    public static final int BATTERY_HEALTH_GOOD = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.642 -0400", hash_original_field = "53F1FFF1C6CCAB012CD0D59392630E17", hash_generated_field = "3F7322619C7F7529D6A0D8095DFA97CD")

    public static final int BATTERY_HEALTH_OVERHEAT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.642 -0400", hash_original_field = "EEAF57197165DB4724867E784BC06F7A", hash_generated_field = "F33805FFD653154B1895025FA5E0D271")

    public static final int BATTERY_HEALTH_DEAD = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.642 -0400", hash_original_field = "0FA024458FAAB49A0335C1157C4D2EAF", hash_generated_field = "A7DE31DA13C36F7D2438292B9115C572")

    public static final int BATTERY_HEALTH_OVER_VOLTAGE = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.642 -0400", hash_original_field = "3F2F84AA866E53922F5A6162B4DEB68D", hash_generated_field = "050B3616CAEBB115FCD231352F9C0708")

    public static final int BATTERY_HEALTH_UNSPECIFIED_FAILURE = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.642 -0400", hash_original_field = "15ABEF4C5D0835750653891D66DDDA1D", hash_generated_field = "6634DD98BE4631F565171C33D9F00BBE")

    public static final int BATTERY_HEALTH_COLD = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.642 -0400", hash_original_field = "474850528C3C7442587BA2B3035DFC0C", hash_generated_field = "6F976058808D053564DD1F460CFDBA9E")

    public static final int BATTERY_PLUGGED_AC = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.642 -0400", hash_original_field = "9A884E548B4FBA388C9CB18A9180E81D", hash_generated_field = "2B7754593DA4CDF0D6CBD2CE1B5E8872")

    public static final int BATTERY_PLUGGED_USB = 2;
}

