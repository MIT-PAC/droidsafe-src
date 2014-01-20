package android.text.format;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;
import java.util.TimeZone;

import android.content.res.Resources;

import droidsafe.helpers.DSUtils;

public class Time {

    /**
     * Compare two {@code Time} objects and return a negative number if {@code
     * a} is less than {@code b}, a positive number if {@code a} is greater than
     * {@code b}, or 0 if they are equal.
     *
     * @param a first {@code Time} instance to compare
     * @param b second {@code Time} instance to compare
     * @throws NullPointerException if either argument is {@code null}
     * @throws IllegalArgumentException if {@link #allDay} is true but {@code
     *             hour}, {@code minute}, and {@code second} are not 0.
     * @return a negative result if {@code a} is earlier, a positive result if
     *         {@code a} is earlier, or 0 if they are equal.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.769 -0500", hash_original_method = "1E5DE9F7F5CC8351FCC6C06EF6103A1F", hash_generated_method = "207458D93B711E43419FC34C3E3297FD")
    
public static int compare(Time a, Time b) {
        if (a == null) {
            throw new NullPointerException("a == null");
        } else if (b == null) {
            throw new NullPointerException("b == null");
        }

        return nativeCompare(a, b);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int nativeCompare(Time a, Time b) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450183953 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450183953;
    }

    /**
     * Returns the timezone string that is currently set for the device.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.804 -0500", hash_original_method = "9C730CB6C697DB2A56C8E6FAE9E8F345", hash_generated_method = "DEB2074E7BB36BB0690F5D23D9C3701A")
    
public static String getCurrentTimezone() {
        return TimeZone.getDefault().getID();
    }

    /**
     * Returns true if the day of the given time is the epoch on the Julian Calendar
     * (January 1, 1970 on the Gregorian calendar).
     *
     * @param time the time to test
     * @return true if epoch.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.847 -0500", hash_original_method = "7198CC6BA3A84102ED750212181BD596", hash_generated_method = "CD4840D16E29173496AB01362327D8D0")
    
public static boolean isEpoch(Time time) {
        long millis = time.toMillis(true);
        return getJulianDay(millis, 0) == EPOCH_JULIAN_DAY;
    }

    /**
     * Computes the Julian day number, given the UTC milliseconds
     * and the offset (in seconds) from UTC.  The Julian day for a given
     * date will be the same for every timezone.  For example, the Julian
     * day for July 1, 2008 is 2454649.  This is the same value no matter
     * what timezone is being used.  The Julian day is useful for testing
     * if two events occur on the same day and for determining the relative
     * time of an event from the present ("yesterday", "3 days ago", etc.).
     *
     * <p>
     * Use {@link #toMillis(boolean)} to get the milliseconds.
     *
     * @param millis the time in UTC milliseconds
     * @param gmtoff the offset from UTC in seconds
     * @return the Julian day
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.850 -0500", hash_original_method = "D08E597819461A2ABCDA3ECFD890EA67", hash_generated_method = "ED2CB255FE1DAAC50CD2EFB1B5DF55C9")
    
public static int getJulianDay(long millis, long gmtoff) {
        long offsetMillis = gmtoff * 1000;
        long julianDay = (millis + offsetMillis) / DateUtils.DAY_IN_MILLIS;
        return (int) julianDay + EPOCH_JULIAN_DAY;
    }

    /**
     * Returns the week since {@link #EPOCH_JULIAN_DAY} (Jan 1, 1970) adjusted
     * for first day of week. This takes a julian day and the week start day and
     * calculates which week since {@link #EPOCH_JULIAN_DAY} that day occurs in,
     * starting at 0. *Do not* use this to compute the ISO week number for the
     * year.
     *
     * @param julianDay The julian day to calculate the week number for
     * @param firstDayOfWeek Which week day is the first day of the week, see
     *            {@link #SUNDAY}
     * @return Weeks since the epoch
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.856 -0500", hash_original_method = "38665BD593D83A76BE7E942EDFDF3356", hash_generated_method = "B2667088C9EA16944039F40AC1BA4A98")
    
public static int getWeeksSinceEpochFromJulianDay(int julianDay, int firstDayOfWeek) {
        int diff = THURSDAY - firstDayOfWeek;
        if (diff < 0) {
            diff += 7;
        }
        int refDay = EPOCH_JULIAN_DAY - diff;
        return (julianDay - refDay) / 7;
    }

    /**
     * Takes a number of weeks since the epoch and calculates the Julian day of
     * the Monday for that week. This assumes that the week containing the
     * {@link #EPOCH_JULIAN_DAY} is considered week 0. It returns the Julian day
     * for the Monday week weeks after the Monday of the week containing the
     * epoch.
     *
     * @param week Number of weeks since the epoch
     * @return The julian day for the Monday of the given week since the epoch
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.860 -0500", hash_original_method = "416CF5B8E045D66926F7C97658B32152", hash_generated_method = "83D4A15CD9D63C38AEC7654782EF38DD")
    
public static int getJulianMondayFromWeeksSinceEpoch(int week) {
        return MONDAY_BEFORE_JULIAN_EPOCH + week * 7;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.618 -0500", hash_original_field = "171F51C704177D9DFA07E083225E94D0", hash_generated_field = "802872930A389D11D7EB611619410907")

    private static final String Y_M_D_T_H_M_S_000 = "%Y-%m-%dT%H:%M:%S.000";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.621 -0500", hash_original_field = "9A6256A33DC042A9C962ADC7260D41D0", hash_generated_field = "F2587797ED5FCC288039F472A44FF8DF")

    private static final String Y_M_D_T_H_M_S_000_Z = "%Y-%m-%dT%H:%M:%S.000Z";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.624 -0500", hash_original_field = "3098456EA3213E50EBA1BE93513CB2E7", hash_generated_field = "CE9712E85C8167032E58AF870E4AC065")

    private static final String Y_M_D = "%Y-%m-%d";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.627 -0500", hash_original_field = "CA779BEC9970A623BDF311FCF64D40A7", hash_generated_field = "448FF7C314ECEAD51910DBE6ACEDCDB5")

    public static final String TIMEZONE_UTC = "UTC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.630 -0500", hash_original_field = "6D770E847D0056A79F87678CF7610409", hash_generated_field = "979BA9E17F757813AD1F7415B808BB0C")

    public static final int EPOCH_JULIAN_DAY = 2440588;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.632 -0500", hash_original_field = "F547711B801AD80C1FB903D87A18AF84", hash_generated_field = "A7D9C1300EE29A3CDE02A8EECF9723D6")

    public static final int MONDAY_BEFORE_JULIAN_EPOCH = EPOCH_JULIAN_DAY - 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.666 -0500", hash_original_field = "EDEFC2D57E3823F21D895BAC165C1F04", hash_generated_field = "7FF4F0346D35D6C7C8B8BCC5519DE964")

    public static final int SECOND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.669 -0500", hash_original_field = "59D2805489C34F51BCB95DD0C9446DAC", hash_generated_field = "D0EB317712B94EA17EDF8EC80DCF85DB")

    public static final int MINUTE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.671 -0500", hash_original_field = "48A360B8626EB468EABB0DCE6B7A5A1C", hash_generated_field = "A9E692DAB7440DC6EB0D7F4DD2D7375E")

    public static final int HOUR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.674 -0500", hash_original_field = "080F8455F3B0A1C1EE1C1314BC28D9DE", hash_generated_field = "489C40FE157D5F22714A4E9936E2FEF9")

    public static final int MONTH_DAY = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.677 -0500", hash_original_field = "7AC57CD6315D929CB376280C906EC273", hash_generated_field = "0E6F1A978C703C9F706BC42E33AED3B6")

    public static final int MONTH = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.680 -0500", hash_original_field = "BE1BBEBC20E9EA5651D0E536B15E04E0", hash_generated_field = "095BB4D2F66C929D527B4FEA7AFDE434")

    public static final int YEAR = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.682 -0500", hash_original_field = "6036FBE193175EB78EF0D43B835D53EE", hash_generated_field = "644B9E0E7BB470630B3F7074481A1661")

    public static final int WEEK_DAY = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.685 -0500", hash_original_field = "C0378CD23017A150A1B71ACE5CC5DFC1", hash_generated_field = "D424E291AD7674530D2A22060204690D")

    public static final int YEAR_DAY = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.688 -0500", hash_original_field = "39351CFDECCC0F514679460C496EC5D4", hash_generated_field = "0CE17F6EE54DD1C54BC1AC6939F0B86B")

    public static final int WEEK_NUM = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.690 -0500", hash_original_field = "8E4DE116B88A16555727E91FF6A1712C", hash_generated_field = "36AE026E6127E76EA1E3630F36493111")

    public static final int SUNDAY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.693 -0500", hash_original_field = "9A33D4C4CC018E922638687FF5A8DC99", hash_generated_field = "DBFAE43E90D9723C40B3BB19C4831A6F")

    public static final int MONDAY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.697 -0500", hash_original_field = "3E34249F11C30AB2EF237600ECB236B7", hash_generated_field = "0AF5A39C736FD970539D13FECC07F642")

    public static final int TUESDAY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.699 -0500", hash_original_field = "EF26237AF4DB4AB8647381D1362A3222", hash_generated_field = "BFE153BB36785196E448AA0629AF5098")

    public static final int WEDNESDAY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.702 -0500", hash_original_field = "C08F7A152680C4D55F09326F2020D105", hash_generated_field = "F84C1880084ECF6559A8D1789EE9E462")

    public static final int THURSDAY = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.704 -0500", hash_original_field = "506E55BE09B27CDE24834409BB9E3A87", hash_generated_field = "7463C16A7E71971D61BDA2D5A24C098B")

    public static final int FRIDAY = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.707 -0500", hash_original_field = "C95BB1092FBB4DE86C9A8777AB6731B6", hash_generated_field = "E997F6B4D53FE6A93D9DBC1991F97475")

    public static final int SATURDAY = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.710 -0500", hash_original_field = "B5750F26C28E1875446D9F884C03889C", hash_generated_field = "3DB7C9A03487D4317932026B0B75600E")

    private static Locale sLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.713 -0500", hash_original_field = "3BF6D1743BB2DDD859380C0617D9D1D3", hash_generated_field = "0EA7D12DBAF1FF850CC67ACF8DFDF8EF")

    private static String[] sShortMonths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.715 -0500", hash_original_field = "2383F4D20259068E49472CC44E5335A4", hash_generated_field = "956EA71F943BA7163DF13EFC9EF5F36D")

    private static String[] sLongMonths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.718 -0500", hash_original_field = "2A22D6E5663A5689C80EC6DE0E13535D", hash_generated_field = "3123B9CC7541D84227EA87717D65FAA1")

    private static String[] sLongStandaloneMonths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.720 -0500", hash_original_field = "4A4B4C429D2E7A0B52D8D3C339E02C81", hash_generated_field = "2DC83AEE31236F07C8D5F903FEDACD55")

    private static String[] sShortWeekdays;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.723 -0500", hash_original_field = "C310778572781289BD25BE31A0E7B541", hash_generated_field = "541B609CC12419AD123C2B65C675E1AD")

    private static String[] sLongWeekdays;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.726 -0500", hash_original_field = "DD63A63C1005058560A44B17CD69A341", hash_generated_field = "8F436CFB23F48A022279E854E7B6D1C2")

    private static String sTimeOnlyFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.729 -0500", hash_original_field = "57FC3EF1FF2CFC557AAC33B5FDFA0966", hash_generated_field = "1EA7F4605A70A3B15EEDC849C141F108")

    private static String sDateOnlyFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.731 -0500", hash_original_field = "40C724B10ECA4524A12A16BC977B4FC6", hash_generated_field = "936F4B1ED85D1E8F390302A602CF23FA")

    private static String sDateTimeFormat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.734 -0500", hash_original_field = "638D7F342CA21B28EA6696493A482387", hash_generated_field = "B48A1A193AAD9526CBE9E1FCAA96057D")

    private static String sAm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.737 -0500", hash_original_field = "0F6AD837460F44A99C7F9C1270033AAE", hash_generated_field = "05937CAA819E1FE81EB88395748387A8")

    private static String sPm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.739 -0500", hash_original_field = "D5601BE8EAD9DE55261316814F3FCE33", hash_generated_field = "3ADD89E952ECF0F0D214DD51E2FB944E")

    private static String sDateCommand = "%a %b %e %H:%M:%S %Z %Y";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.759 -0500", hash_original_field = "9626A128BD0ED0153979370F22647A9E", hash_generated_field = "C556B2A442B943AEC4D04E626AB106F8")

    private static final int[] DAYS_PER_MONTH = { 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.838 -0500", hash_original_field = "64057F2A6D95863CCE213E0945666F9B", hash_generated_field = "90DD57B3997497DA0FBDC833C844F416")

    private static final int[] sThursdayOffset = { -3, 3, 2, 1, 0, -1, -2 };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.635 -0500", hash_original_field = "D83D26D3A7BED58B7D9A54CE8DDF7347", hash_generated_field = "9B333262C59ACAF4662993E0381B186B")

    public boolean allDay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.637 -0500", hash_original_field = "662760B0A001432CFE4D3F18F01B3CEF", hash_generated_field = "26A3892DE5720DF4430FA2DBFDE4FF62")

    public int second;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.640 -0500", hash_original_field = "56A69BE5A6B1DCF64B7123BACE74483B", hash_generated_field = "455B65DB16084F27D41C85247D5F2D46")

    public int minute;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.642 -0500", hash_original_field = "6CAA30872566AAC3D8208DA318F04BBD", hash_generated_field = "60957A9D10A9EBFF70AB0506CE8D72D3")

    public int hour;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.645 -0500", hash_original_field = "0FA6A160BDF34114B08FC29D0E26C932", hash_generated_field = "0D8CCE169482BCBB0FA5CD710145A28F")

    public int monthDay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.647 -0500", hash_original_field = "D47DF9EB6B827E7A5A09905C90EC13DE", hash_generated_field = "0230F059D3F4D4B04ED8DF3526CB7866")

    public int month;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.649 -0500", hash_original_field = "A74C473B668E5186D1BA6112E0F14F77", hash_generated_field = "262796C768431713D9A766C22E1203FB")

    public int year;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.653 -0500", hash_original_field = "E3730C3B09A2E8CB4ED94DBFE23E041B", hash_generated_field = "A89A7B58B286334824EC64B00634216D")

    public int weekDay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.655 -0500", hash_original_field = "8F02844E7E59E7640F6383596476B0E7", hash_generated_field = "A5C458E466E7DA8146F10E83C68D95FA")

    public int yearDay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.658 -0500", hash_original_field = "47C811F4DCCD83354BC625C7EAD9B7FF", hash_generated_field = "C8977C2FF5A43A716AE2D045D6EB6CF6")

    public int isDst;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.660 -0500", hash_original_field = "D6200031A26D82AF47FFF4DBC522FFA4", hash_generated_field = "5C20967D8EBD6408D4E1A635480B5B75")

    public long gmtoff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.662 -0500", hash_original_field = "CCC9876930059D91932A6512CE7BF42A", hash_generated_field = "3B69EE778051333E277A9B76EADD3A80")

    public String timezone;

    /**
     * Construct a Time object in the timezone named by the string
     * argument "timezone". The time is initialized to Jan 1, 1970.
     * @param timezone string containing the timezone to use.
     * @see TimeZone
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.743 -0500", hash_original_method = "E0FCF5C2DD1FC8B8CECA3F88CA26F2FA", hash_generated_method = "AEAC7D1422FF6F48C2FC8B5E88EABD1C")
    
public Time(String timezone) {
        if (timezone == null) {
            throw new NullPointerException("timezone is null!");
        }
        this.timezone = timezone;
        this.year = 1970;
        this.monthDay = 1;
        // Set the daylight-saving indicator to the unknown value -1 so that
        // it will be recomputed.
        this.isDst = -1;
    }

    /**
     * Construct a Time object in the default timezone. The time is initialized to
     * Jan 1, 1970.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.745 -0500", hash_original_method = "B143F86B302A5932C8EBD6FB2BD46478", hash_generated_method = "B2115C0DC328A5BA3B9C03D90D22162C")
    
public Time() {
        this(TimeZone.getDefault().getID());
    }

    /**
     * A copy constructor.  Construct a Time object by copying the given
     * Time object.  No normalization occurs.
     *
     * @param other
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.748 -0500", hash_original_method = "5882A59C3CCF918AE2BB2D84CAA18E36", hash_generated_method = "79A4A459DF6EBC6ED9161BF9A91D2065")
    
public Time(Time other) {
        set(other);
    }

    /**
     * Ensures the values in each field are in range. For example if the
     * current value of this calendar is March 32, normalize() will convert it
     * to April 1. It also fills in weekDay, yearDay, isDst and gmtoff.
     *
     * <p>
     * If "ignoreDst" is true, then this method sets the "isDst" field to -1
     * (the "unknown" value) before normalizing.  It then computes the
     * correct value for "isDst".
     *
     * <p>
     * See {@link #toMillis(boolean)} for more information about when to
     * use <tt>true</tt> or <tt>false</tt> for "ignoreDst".
     *
     * @return the UTC milliseconds since the epoch
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.752 -0500", hash_original_method = "7DE92E5F5A39A244E977EE497A88E369", hash_generated_method = "7B8800BC77EF2206F5173B29D405A6EC")
    
    public long normalize(boolean ignoreDst){
    	//Formerly a native method
    	addTaint(ignoreDst);
    	return getTaintLong();
    }

    /**
     * Convert this time object so the time represented remains the same, but is
     * instead located in a different timezone. This method automatically calls
     * normalize() in some cases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.757 -0500", hash_original_method = "13E8DE21AE4CB3AA83156EE3A5950ED3", hash_generated_method = "A614ED0ED34DE6FC84D338B19E98B302")
    
    public void switchTimezone(String timezone){
    	//Formerly a native method
    	addTaint(timezone.getTaint());
    }

    /**
     * Return the maximum possible value for the given field given the value of
     * the other fields. Requires that it be normalized for MONTH_DAY and
     * YEAR_DAY.
     * @param field one of the constants for HOUR, MINUTE, SECOND, etc.
     * @return the maximum value for the field.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.763 -0500", hash_original_method = "DF789B90859E8F04F5333F3487A99DFB", hash_generated_method = "414C0A84A438577DA829FE91C903F5D1")
    
public int getActualMaximum(int field) {
        switch (field) {
        case SECOND:
            return 59; // leap seconds, bah humbug
        case MINUTE:
            return 59;
        case HOUR:
            return 23;
        case MONTH_DAY: {
            int n = DAYS_PER_MONTH[this.month];
            if (n != 28) {
                return n;
            } else {
                int y = this.year;
                return ((y % 4) == 0 && ((y % 100) != 0 || (y % 400) == 0)) ? 29 : 28;
            }
        }
        case MONTH:
            return 11;
        case YEAR:
            return 2037;
        case WEEK_DAY:
            return 6;
        case YEAR_DAY: {
            int y = this.year;
            // Year days are numbered from 0, so the last one is usually 364.
            return ((y % 4) == 0 && ((y % 100) != 0 || (y % 400) == 0)) ? 365 : 364;
        }
        case WEEK_NUM:
            throw new RuntimeException("WEEK_NUM not implemented");
        default:
            throw new RuntimeException("bad field=" + field);
        }
    }

    /**
     * Clears all values, setting the timezone to the given timezone. Sets isDst
     * to a negative value to mean "unknown".
     * @param timezone the timezone to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.766 -0500", hash_original_method = "CE0E4353FCA63B39E00F0F1C4B7BFC83", hash_generated_method = "D2E9DC52851AEA20301E0C4311780C12")
    
public void clear(String timezone) {
        if (timezone == null) {
            throw new NullPointerException("timezone is null!");
        }
        this.timezone = timezone;
        this.allDay = false;
        this.second = 0;
        this.minute = 0;
        this.hour = 0;
        this.monthDay = 0;
        this.month = 0;
        this.year = 0;
        this.weekDay = 0;
        this.yearDay = 0;
        this.gmtoff = 0;
        this.isDst = -1;
    }

    /**
     * Print the current value given the format string provided. See man
     * strftime for what means what. The final string must be less than 256
     * characters.
     * @param format a string containing the desired format.
     * @return a String containing the current time expressed in the current locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.779 -0500", hash_original_method = "2DA36736B256CECB86984D41B76F2A40", hash_generated_method = "BEADFC2B62F6E215351018013EAE25A0")
    
public String format(String format) {
        synchronized (Time.class) {
            Locale locale = Locale.getDefault();

            if (sLocale == null || locale == null || !(locale.equals(sLocale))) {
                Resources r = Resources.getSystem();

                sShortMonths = new String[] {
                    r.getString(com.android.internal.R.string.month_medium_january),
                    r.getString(com.android.internal.R.string.month_medium_february),
                    r.getString(com.android.internal.R.string.month_medium_march),
                    r.getString(com.android.internal.R.string.month_medium_april),
                    r.getString(com.android.internal.R.string.month_medium_may),
                    r.getString(com.android.internal.R.string.month_medium_june),
                    r.getString(com.android.internal.R.string.month_medium_july),
                    r.getString(com.android.internal.R.string.month_medium_august),
                    r.getString(com.android.internal.R.string.month_medium_september),
                    r.getString(com.android.internal.R.string.month_medium_october),
                    r.getString(com.android.internal.R.string.month_medium_november),
                    r.getString(com.android.internal.R.string.month_medium_december),
                };
                sLongMonths = new String[] {
                    r.getString(com.android.internal.R.string.month_long_january),
                    r.getString(com.android.internal.R.string.month_long_february),
                    r.getString(com.android.internal.R.string.month_long_march),
                    r.getString(com.android.internal.R.string.month_long_april),
                    r.getString(com.android.internal.R.string.month_long_may),
                    r.getString(com.android.internal.R.string.month_long_june),
                    r.getString(com.android.internal.R.string.month_long_july),
                    r.getString(com.android.internal.R.string.month_long_august),
                    r.getString(com.android.internal.R.string.month_long_september),
                    r.getString(com.android.internal.R.string.month_long_october),
                    r.getString(com.android.internal.R.string.month_long_november),
                    r.getString(com.android.internal.R.string.month_long_december),
                };
                sLongStandaloneMonths = new String[] {
                    r.getString(com.android.internal.R.string.month_long_standalone_january),
                    r.getString(com.android.internal.R.string.month_long_standalone_february),
                    r.getString(com.android.internal.R.string.month_long_standalone_march),
                    r.getString(com.android.internal.R.string.month_long_standalone_april),
                    r.getString(com.android.internal.R.string.month_long_standalone_may),
                    r.getString(com.android.internal.R.string.month_long_standalone_june),
                    r.getString(com.android.internal.R.string.month_long_standalone_july),
                    r.getString(com.android.internal.R.string.month_long_standalone_august),
                    r.getString(com.android.internal.R.string.month_long_standalone_september),
                    r.getString(com.android.internal.R.string.month_long_standalone_october),
                    r.getString(com.android.internal.R.string.month_long_standalone_november),
                    r.getString(com.android.internal.R.string.month_long_standalone_december),
                };
                sShortWeekdays = new String[] {
                    r.getString(com.android.internal.R.string.day_of_week_medium_sunday),
                    r.getString(com.android.internal.R.string.day_of_week_medium_monday),
                    r.getString(com.android.internal.R.string.day_of_week_medium_tuesday),
                    r.getString(com.android.internal.R.string.day_of_week_medium_wednesday),
                    r.getString(com.android.internal.R.string.day_of_week_medium_thursday),
                    r.getString(com.android.internal.R.string.day_of_week_medium_friday),
                    r.getString(com.android.internal.R.string.day_of_week_medium_saturday),
                };
                sLongWeekdays = new String[] {
                    r.getString(com.android.internal.R.string.day_of_week_long_sunday),
                    r.getString(com.android.internal.R.string.day_of_week_long_monday),
                    r.getString(com.android.internal.R.string.day_of_week_long_tuesday),
                    r.getString(com.android.internal.R.string.day_of_week_long_wednesday),
                    r.getString(com.android.internal.R.string.day_of_week_long_thursday),
                    r.getString(com.android.internal.R.string.day_of_week_long_friday),
                    r.getString(com.android.internal.R.string.day_of_week_long_saturday),
                };
                sTimeOnlyFormat = r.getString(com.android.internal.R.string.time_of_day);
                sDateOnlyFormat = r.getString(com.android.internal.R.string.month_day_year);
                sDateTimeFormat = r.getString(com.android.internal.R.string.date_and_time);
                sAm = r.getString(com.android.internal.R.string.am);
                sPm = r.getString(com.android.internal.R.string.pm);

                sLocale = locale;
            }

            return format1(format);
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.831 -0400", hash_original_method = "751765C8BBD19CCE2EF370E3AB9D4D19", hash_generated_method = "CC9E7C3FAB0B3C60FBFB40FF6979F754")
    private String format1(String format) {
    	String s = new String();
    	s.addTaint(taint);
    	s.addTaint(format.getTaint());
    	return s;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.831 -0400", hash_original_method = "D4E4943029EE450E10D723A13B21ADBA", hash_generated_method = "93A7BDD7A073B21936AAAC2D97F258FB")
    @Override
    public String toString() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    /**
     * Parses a date-time string in either the RFC 2445 format or an abbreviated
     * format that does not include the "time" field.  For example, all of the
     * following strings are valid:
     *
     * <ul>
     *   <li>"20081013T160000Z"</li>
     *   <li>"20081013T160000"</li>
     *   <li>"20081013"</li>
     * </ul>
     *
     * Returns whether or not the time is in UTC (ends with Z).  If the string
     * ends with "Z" then the timezone is set to UTC.  If the date-time string
     * included only a date and no time field, then the <code>allDay</code>
     * field of this Time class is set to true and the <code>hour</code>,
     * <code>minute</code>, and <code>second</code> fields are set to zero;
     * otherwise (a time field was included in the date-time string)
     * <code>allDay</code> is set to false. The fields <code>weekDay</code>,
     * <code>yearDay</code>, and <code>gmtoff</code> are always set to zero,
     * and the field <code>isDst</code> is set to -1 (unknown).  To set those
     * fields, call {@link #normalize(boolean)} after parsing.
     *
     * To parse a date-time string and convert it to UTC milliseconds, do
     * something like this:
     *
     * <pre>
     *   Time time = new Time();
     *   String date = "20081013T160000Z";
     *   time.parse(date);
     *   long millis = time.normalize(false);
     * </pre>
     *
     * @param s the string to parse
     * @return true if the resulting time value is in UTC time
     * @throws android.util.TimeFormatException if s cannot be parsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.790 -0500", hash_original_method = "412A6EFDB33A9BCE94A5C52880803E0F", hash_generated_method = "00E04CF05A04A7A34BCFBE1E8F8AC975")
    
public boolean parse(String s) {
        if (nativeParse(s)) {
            timezone = TIMEZONE_UTC;
            return true;
        }
        return false;
    }

    /**
     * Parse a time in the current zone in YYYYMMDDTHHMMSS format.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.795 -0500", hash_original_method = "715F84C962A7921497F55D5349A2140A", hash_generated_method = "EA919FD7BE7C474CE83983166A9CD5B1")
    
    private boolean nativeParse(String s){
    	//Formerly a native method
    	addTaint(s.getTaint());
    	return getTaintBoolean();
    }

    /**
     * Parse a time in RFC 3339 format.  This method also parses simple dates
     * (that is, strings that contain no time or time offset).  For example,
     * all of the following strings are valid:
     *
     * <ul>
     *   <li>"2008-10-13T16:00:00.000Z"</li>
     *   <li>"2008-10-13T16:00:00.000+07:00"</li>
     *   <li>"2008-10-13T16:00:00.000-07:00"</li>
     *   <li>"2008-10-13"</li>
     * </ul>
     *
     * <p>
     * If the string contains a time and time offset, then the time offset will
     * be used to convert the time value to UTC.
     * </p>
     *
     * <p>
     * If the given string contains just a date (with no time field), then
     * the {@link #allDay} field is set to true and the {@link #hour},
     * {@link #minute}, and  {@link #second} fields are set to zero.
     * </p>
     *
     * <p>
     * Returns true if the resulting time value is in UTC time.
     * </p>
     *
     * @param s the string to parse
     * @return true if the resulting time value is in UTC time
     * @throws android.util.TimeFormatException if s cannot be parsed.
     */
     @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.798 -0500", hash_original_method = "E417695E8CAC19265A6537D747474825", hash_generated_method = "DE9F06A70AE7B2D50C4E75981B0D2CE7")
    
public boolean parse3339(String s) {
         if (nativeParse3339(s)) {
             timezone = TIMEZONE_UTC;
             return true;
         }
         return false;
     }

     @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.802 -0500", hash_original_method = "57499E6D502331FE1EE9DA37E2D15CA3", hash_generated_method = "759E8A7ADB981CAAF0E76B982DD539A2")
    
    private boolean nativeParse3339(String s){
    	//Formerly a native method
    	addTaint(s.getTaint());
    	return getTaintBoolean();
    }

    /**
     * Sets the time of the given Time object to the current time.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.809 -0500", hash_original_method = "6CDA1CA0525F04C652EDF79AA26F0E90", hash_generated_method = "15AB5FFDBF444B39AECF6C7B3D1436D7")
    
    public void setToNow(){
    	//Formerly a native method
    }

    /**
     * Converts this time to milliseconds. Suitable for interacting with the
     * standard java libraries. The time is in UTC milliseconds since the epoch.
     * This does an implicit normalization to compute the milliseconds but does
     * <em>not</em> change any of the fields in this Time object.  If you want
     * to normalize the fields in this Time object and also get the milliseconds
     * then use {@link #normalize(boolean)}.
     *
     * <p>
     * If "ignoreDst" is false, then this method uses the current setting of the
     * "isDst" field and will adjust the returned time if the "isDst" field is
     * wrong for the given time.  See the sample code below for an example of
     * this.
     *
     * <p>
     * If "ignoreDst" is true, then this method ignores the current setting of
     * the "isDst" field in this Time object and will instead figure out the
     * correct value of "isDst" (as best it can) from the fields in this
     * Time object.  The only case where this method cannot figure out the
     * correct value of the "isDst" field is when the time is inherently
     * ambiguous because it falls in the hour that is repeated when switching
     * from Daylight-Saving Time to Standard Time.
     *
     * <p>
     * Here is an example where <tt>toMillis(true)</tt> adjusts the time,
     * assuming that DST changes at 2am on Sunday, Nov 4, 2007.
     *
     * <pre>
     * Time time = new Time();
     * time.set(4, 10, 2007);  // set the date to Nov 4, 2007, 12am
     * time.normalize();       // this sets isDst = 1
     * time.monthDay += 1;     // changes the date to Nov 5, 2007, 12am
     * millis = time.toMillis(false);   // millis is Nov 4, 2007, 11pm
     * millis = time.toMillis(true);    // millis is Nov 5, 2007, 12am
     * </pre>
     *
     * <p>
     * To avoid this problem, use <tt>toMillis(true)</tt>
     * after adding or subtracting days or explicitly setting the "monthDay"
     * field.  On the other hand, if you are adding
     * or subtracting hours or minutes, then you should use
     * <tt>toMillis(false)</tt>.
     *
     * <p>
     * You should also use <tt>toMillis(false)</tt> if you want
     * to read back the same milliseconds that you set with {@link #set(long)}
     * or {@link #set(Time)} or after parsing a date string.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.813 -0500", hash_original_method = "C1956449864825DE1FCC969EAC519409", hash_generated_method = "D0531688B3741002E0E1F71977D0DF65")
    
    public long toMillis(boolean ignoreDst){
    	//Formerly a native method
    	addTaint(ignoreDst);
    	return getTaintLong();
    }

    /**
     * Sets the fields in this Time object given the UTC milliseconds.  After
     * this method returns, all the fields are normalized.
     * This also sets the "isDst" field to the correct value.
     *
     * @param millis the time in UTC milliseconds since the epoch.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.817 -0500", hash_original_method = "934B6518FEFEB3D5C2DEFA32BEB78382", hash_generated_method = "AB41981E05C419C3C9509C60D6834BFE")
    
    public void set(long millis){
    	//Formerly a native method
    	addTaint(millis);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.834 -0400", hash_original_method = "41A869EF339B8E1FD69184435BC2AFF4", hash_generated_method = "80016ED483EF4736E85C065EFF5B1D3A")
    public String format2445() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    /**
     * Copy the value of that to this Time object. No normalization happens.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.824 -0500", hash_original_method = "F960E973DC6F4E791CEC3120624756A7", hash_generated_method = "4509CB793883F76F83FC9ADE0AE82EDA")
    
public void set(Time that) {
        this.timezone = that.timezone;
        this.allDay = that.allDay;
        this.second = that.second;
        this.minute = that.minute;
        this.hour = that.hour;
        this.monthDay = that.monthDay;
        this.month = that.month;
        this.year = that.year;
        this.weekDay = that.weekDay;
        this.yearDay = that.yearDay;
        this.isDst = that.isDst;
        this.gmtoff = that.gmtoff;
    }

    /**
     * Sets the fields. Sets weekDay, yearDay and gmtoff to 0, and isDst to -1.
     * Call {@link #normalize(boolean)} if you need those.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.827 -0500", hash_original_method = "667ED0F0E30647AFF648664194B11038", hash_generated_method = "92F17A84723EF022C6D0E7B30F11ECFB")
    
public void set(int second, int minute, int hour, int monthDay, int month, int year) {
        this.allDay = false;
        this.second = second;
        this.minute = minute;
        this.hour = hour;
        this.monthDay = monthDay;
        this.month = month;
        this.year = year;
        this.weekDay = 0;
        this.yearDay = 0;
        this.isDst = -1;
        this.gmtoff = 0;
    }

    /**
     * Sets the date from the given fields.  Also sets allDay to true.
     * Sets weekDay, yearDay and gmtoff to 0, and isDst to -1.
     * Call {@link #normalize(boolean)} if you need those.
     *
     * @param monthDay the day of the month (in the range [1,31])
     * @param month the zero-based month number (in the range [0,11])
     * @param year the year
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.830 -0500", hash_original_method = "C60C1B5EF923FFCA596CDB2EA96B61D3", hash_generated_method = "FDBC3EF51B06E4661D2EC9A00FA59CE0")
    
public void set(int monthDay, int month, int year) {
        this.allDay = true;
        this.second = 0;
        this.minute = 0;
        this.hour = 0;
        this.monthDay = monthDay;
        this.month = month;
        this.year = year;
        this.weekDay = 0;
        this.yearDay = 0;
        this.isDst = -1;
        this.gmtoff = 0;
    }

    /**
     * Returns true if the time represented by this Time object occurs before
     * the given time.
     *
     * @param that a given Time object to compare against
     * @return true if this time is less than the given time
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.832 -0500", hash_original_method = "42CA0EB350D1B07EC08DFD981A2476E6", hash_generated_method = "4BF352DA354F27A8224D77D655FC3EE8")
    
public boolean before(Time that) {
        return Time.compare(this, that) < 0;
    }

    /**
     * Returns true if the time represented by this Time object occurs after
     * the given time.
     *
     * @param that a given Time object to compare against
     * @return true if this time is greater than the given time
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.835 -0500", hash_original_method = "63DFD446B1AADA69AC0B8E51A8B5B261", hash_generated_method = "D877C7116F720B085DA5A516A1965C66")
    
public boolean after(Time that) {
        return Time.compare(this, that) > 0;
    }

    /**
     * Computes the week number according to ISO 8601.  The current Time
     * object must already be normalized because this method uses the
     * yearDay and weekDay fields.
     *
     * <p>
     * In IS0 8601, weeks start on Monday.
     * The first week of the year (week 1) is defined by ISO 8601 as the
     * first week with four or more of its days in the starting year.
     * Or equivalently, the week containing January 4.  Or equivalently,
     * the week with the year's first Thursday in it.
     * </p>
     *
     * <p>
     * The week number can be calculated by counting Thursdays.  Week N
     * contains the Nth Thursday of the year.
     * </p>
     *
     * @return the ISO week number.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.841 -0500", hash_original_method = "9786C5AD526EBB88697D6E3283396468", hash_generated_method = "1B937AB060B37085837F082A0464B732")
    
public int getWeekNumber() {
        // Get the year day for the closest Thursday
        int closestThursday = yearDay + sThursdayOffset[weekDay];

        // Year days start at 0
        if (closestThursday >= 0 && closestThursday <= 364) {
            return closestThursday / 7 + 1;
        }

        // The week crosses a year boundary.
        Time temp = new Time(this);
        temp.monthDay += sThursdayOffset[weekDay];
        temp.normalize(true /* ignore isDst */);
        return temp.yearDay / 7 + 1;
    }

    /**
     * Return a string in the RFC 3339 format.
     * <p>
     * If allDay is true, expresses the time as Y-M-D</p>
     * <p>
     * Otherwise, if the timezone is UTC, expresses the time as Y-M-D-T-H-M-S UTC</p>
     * <p>
     * Otherwise the time is expressed the time as Y-M-D-T-H-M-S +- GMT</p>
     * @param allDay
     * @return string in the RFC 3339 format.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.844 -0500", hash_original_method = "84747EB963EFC6E551D95C210645E8C0", hash_generated_method = "6A5FBB901968BCE27B64EB8A163EDECD")
    
public String format3339(boolean allDay) {
        if (allDay) {
            return format(Y_M_D);
        } else if (TIMEZONE_UTC.equals(timezone)) {
            return format(Y_M_D_T_H_M_S_000_Z);
        } else {
            String base = format(Y_M_D_T_H_M_S_000);
            String sign = (gmtoff < 0) ? "-" : "+";
            int offset = (int)Math.abs(gmtoff);
            int minutes = (offset % 3600) / 60;
            int hours = offset / 3600;

            return String.format("%s%s%02d:%02d", base, sign, hours, minutes);
        }
    }

    /**
     * <p>Sets the time from the given Julian day number, which must be based on
     * the same timezone that is set in this Time object.  The "gmtoff" field
     * need not be initialized because the given Julian day may have a different
     * GMT offset than whatever is currently stored in this Time object anyway.
     * After this method returns all the fields will be normalized and the time
     * will be set to 12am at the beginning of the given Julian day.
     * </p>
     *
     * <p>
     * The only exception to this is if 12am does not exist for that day because
     * of daylight saving time.  For example, Cairo, Eqypt moves time ahead one
     * hour at 12am on April 25, 2008 and there are a few other places that
     * also change daylight saving time at 12am.  In those cases, the time
     * will be set to 1am.
     * </p>
     *
     * @param julianDay the Julian day in the timezone for this Time object
     * @return the UTC milliseconds for the beginning of the Julian day
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:18.853 -0500", hash_original_method = "D0FEABA86A68FA32A36FDA48979CCD03", hash_generated_method = "BB3981764C056CDB01D2B20973E9B989")
    
public long setJulianDay(int julianDay) {
        // Don't bother with the GMT offset since we don't know the correct
        // value for the given Julian day.  Just get close and then adjust
        // the day.
        long millis = (julianDay - EPOCH_JULIAN_DAY) * DateUtils.DAY_IN_MILLIS;
        set(millis);

        // Figure out how close we are to the requested Julian day.
        // We can't be off by more than a day.
        int approximateDay = getJulianDay(millis, gmtoff);
        int diff = julianDay - approximateDay;
        monthDay += diff;

        // Set the time to 12am and re-normalize.
        hour = 0;
        minute = 0;
        second = 0;
        millis = normalize(true);
        return millis;
    }
}

