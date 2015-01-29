package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class BatteryManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.084 -0500", hash_original_field = "2292E02218D54BAF718FEC054ADAA31A", hash_generated_field = "BCC0736EDE3B26CB905D1BB3B56EDBCE")

    public static final String EXTRA_STATUS = "status";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.086 -0500", hash_original_field = "5927C8FE64517B1B723325267D78E026", hash_generated_field = "F3D41227E93BCCA3BD670F6F01E09F4A")

    public static final String EXTRA_HEALTH = "health";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.088 -0500", hash_original_field = "869F45E491C11FB6A1AFE6DB664E7E81", hash_generated_field = "C026888824D5E8B465CFAF202E21B5A9")

    public static final String EXTRA_PRESENT = "present";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.091 -0500", hash_original_field = "B7F737F50F118A1F121D4E096B2C0AC7", hash_generated_field = "3326991A78A7A7DC44362730BB946B03")

    public static final String EXTRA_LEVEL = "level";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.093 -0500", hash_original_field = "971D84F34B21EF9BB67695E270FBD8A6", hash_generated_field = "C1ECA1F3CE4E811D1F54D1D66199D9E3")

    public static final String EXTRA_SCALE = "scale";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.095 -0500", hash_original_field = "1602C5D8D3A38A93978D6BB28BAF80D6", hash_generated_field = "A7CB7717E5C3493E8E6A45316CC93D5C")

    public static final String EXTRA_ICON_SMALL = "icon-small";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.097 -0500", hash_original_field = "86EC8B6FFAEEAAE95CF2A144CB41E764", hash_generated_field = "A975D8190BDB7566D76D51B390DA41D4")

    public static final String EXTRA_PLUGGED = "plugged";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.100 -0500", hash_original_field = "D0A54234499F7A01723EEF138E458A80", hash_generated_field = "B0643E89516B759A769263EC1314FDF6")

    public static final String EXTRA_VOLTAGE = "voltage";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.102 -0500", hash_original_field = "B9047F4BF201643CB18E94ECF8722931", hash_generated_field = "D3F71A67FBB3E8CB6CEB087295549858")

    public static final String EXTRA_TEMPERATURE = "temperature";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.104 -0500", hash_original_field = "7040840B6620F49AFFBF903CAFAB4A08", hash_generated_field = "3BAB33272C3009DF4CE97081B3E042F6")

    public static final String EXTRA_TECHNOLOGY = "technology";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.107 -0500", hash_original_field = "78435C9C2868625B487AFDADD4B9863B", hash_generated_field = "950280DD5A04B3E663E9CBD797E4D667")

    public static final String EXTRA_INVALID_CHARGER = "invalid_charger";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.109 -0500", hash_original_field = "E93C1D942779EDFABE89A01F317DA841", hash_generated_field = "D19868B109B988139D5EB4348F770E35")

    public static final int BATTERY_STATUS_UNKNOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.112 -0500", hash_original_field = "74FF6E173219B7B36D8F4CA3C41AF2F0", hash_generated_field = "9DFBF21AF2D6B57E7B98290BDBDD5420")

    public static final int BATTERY_STATUS_CHARGING = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.114 -0500", hash_original_field = "6F16C0B0690F9B000D9F12BD0AA46A1F", hash_generated_field = "A99FB7B4897AF92317F8A6AEF63D81A5")

    public static final int BATTERY_STATUS_DISCHARGING = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.116 -0500", hash_original_field = "0C96F8ABC51DF85AD16B2864242F8CF5", hash_generated_field = "FA63AC00D5A226107FB7EC7F687CAD01")

    public static final int BATTERY_STATUS_NOT_CHARGING = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.119 -0500", hash_original_field = "51714D2E07C2B6FBE637F30C299EFC99", hash_generated_field = "6E5572CA1D35BA3A4F7FB713E8DFA8D3")

    public static final int BATTERY_STATUS_FULL = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.121 -0500", hash_original_field = "8915CC2149A0D5E72ADA2CB046EEB865", hash_generated_field = "1BFB46E805C08D368E565958DB9A2A99")

    public static final int BATTERY_HEALTH_UNKNOWN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.123 -0500", hash_original_field = "27D1B0708711282D1404A8C102316A06", hash_generated_field = "3675916AEF9AB16398BF7333BF6406FB")

    public static final int BATTERY_HEALTH_GOOD = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.126 -0500", hash_original_field = "309B44EAC9E653ECDF07C54D72E32571", hash_generated_field = "3F7322619C7F7529D6A0D8095DFA97CD")

    public static final int BATTERY_HEALTH_OVERHEAT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.128 -0500", hash_original_field = "7D782B88377F3D013AB59AA7C3A49252", hash_generated_field = "F33805FFD653154B1895025FA5E0D271")

    public static final int BATTERY_HEALTH_DEAD = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.131 -0500", hash_original_field = "6DF56A200F00A552A562DF384317F76D", hash_generated_field = "A7DE31DA13C36F7D2438292B9115C572")

    public static final int BATTERY_HEALTH_OVER_VOLTAGE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.133 -0500", hash_original_field = "DB8018763FAB180DD11A059054943278", hash_generated_field = "050B3616CAEBB115FCD231352F9C0708")

    public static final int BATTERY_HEALTH_UNSPECIFIED_FAILURE = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.136 -0500", hash_original_field = "164672A68B75C90A4C3B0DBC3849DDBB", hash_generated_field = "6634DD98BE4631F565171C33D9F00BBE")

    public static final int BATTERY_HEALTH_COLD = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.138 -0500", hash_original_field = "959638EE9CB59880025BADF228F7AF43", hash_generated_field = "ABE3903AD9DE470329D8293AF4F80419")

    // These must be powers of 2.
    /** Power source is an AC charger. */
    public static final int BATTERY_PLUGGED_AC = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.140 -0500", hash_original_field = "224C574D83EBE3387454A6C61C414BB1", hash_generated_field = "2B7754593DA4CDF0D6CBD2CE1B5E8872")

    public static final int BATTERY_PLUGGED_USB = 2;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:25.640 -0400", hash_original_method = "46CB3C3298CDC989655A7D5A93769408", hash_generated_method = "46CB3C3298CDC989655A7D5A93769408")
    public BatteryManager ()
    {
        //Synthesized constructor
    }
}

