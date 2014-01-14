package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.text.DateFormatSymbols;

import libcore.icu.ICU;
import libcore.icu.LocaleData;

public abstract class Calendar implements Serializable, Cloneable, Comparable<Calendar> {

    /**
     * Returns an array of locales for which custom {@code Calendar} instances
     * are available.
     * <p>Note that Android does not support user-supplied locale service providers.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.813 -0500", hash_original_method = "41105D11003C45662A0CC60EBB418302", hash_generated_method = "7EE9909FB376311AA4F87EC76340BBEE")
    
public static synchronized Locale[] getAvailableLocales() {
        return ICU.getAvailableCalendarLocales();
    }

    /**
     * Constructs a new instance of the {@code Calendar} subclass appropriate for the
     * default {@code Locale}.
     *
     * @return a {@code Calendar} subclass instance set to the current date and time in
     *         the default {@code Timezone}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.820 -0500", hash_original_method = "13DC520F4333E665034B03AB416FC5C0", hash_generated_method = "797174B25A8DDE1C62252B85466EB816")
    
public static synchronized Calendar getInstance() {
        return new GregorianCalendar();
    }

    /**
     * Constructs a new instance of the {@code Calendar} subclass appropriate for the
     * specified {@code Locale}.
     *
     * @param locale
     *            the locale to use.
     * @return a {@code Calendar} subclass instance set to the current date and time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.823 -0500", hash_original_method = "691484FDA756A7151BBC682C05DB892E", hash_generated_method = "D23801B3F583C8565835C978CAC9E4FD")
    
public static synchronized Calendar getInstance(Locale locale) {
        return new GregorianCalendar(locale);
    }

    /**
     * Constructs a new instance of the {@code Calendar} subclass appropriate for the
     * default {@code Locale}, using the specified {@code TimeZone}.
     *
     * @param timezone
     *            the {@code TimeZone} to use.
     * @return a {@code Calendar} subclass instance set to the current date and time in
     *         the specified timezone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.826 -0500", hash_original_method = "8659E4BE21B4ECA0C79A0D434746E08E", hash_generated_method = "8FB50815B1A4F787597CC8F8F4F87772")
    
public static synchronized Calendar getInstance(TimeZone timezone) {
        return new GregorianCalendar(timezone);
    }

    /**
     * Constructs a new instance of the {@code Calendar} subclass appropriate for the
     * specified {@code Locale}.
     *
     * @param timezone
     *            the {@code TimeZone} to use.
     * @param locale
     *            the {@code Locale} to use.
     * @return a {@code Calendar} subclass instance set to the current date and time in
     *         the specified timezone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.829 -0500", hash_original_method = "1579030499B60D9EDE224A7FC4647CD2", hash_generated_method = "C8EA010EC7DFE5460AEC766482B2448D")
    
public static synchronized Calendar getInstance(TimeZone timezone, Locale locale) {
        return new GregorianCalendar(timezone, locale);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.899 -0500", hash_original_method = "158908F3E16F190E3843624363472BB7", hash_generated_method = "AB655AA915AE637BF015DBEB23C1430B")
    
private static void checkStyle(int style) {
        if (style != ALL_STYLES && style != SHORT && style != LONG) {
            throw new IllegalArgumentException("bad style " + style);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.905 -0500", hash_original_method = "7FEAE0C8609C253A29E80C9ED2A4869C", hash_generated_method = "4DB3590F2001DB40A99B922BA2D92348")
    
private static void insertValuesInMap(Map<String, Integer> map, String[] values) {
        if (values == null) {
            return;
        }
        for (int i = 0; i < values.length; ++i) {
            if (values[i] != null && !values[i].isEmpty()) {
                map.put(values[i], i);
            }
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.625 -0500", hash_original_field = "4D8674EA548BD96F53EEDAA50DD1693D", hash_generated_field = "AF2E0A30DAA7888473F4B1DB6F9AB4E7")

    private static final long serialVersionUID = -1807547505821590642L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.653 -0500", hash_original_field = "96E737BC3A857442BE698F2E08262213", hash_generated_field = "18EBE6A0EA775581ADAF9A3A3B4BDF43")

    public static final int JANUARY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.656 -0500", hash_original_field = "4CFE46FE48D8A7AC3A7EDB03BEE968C3", hash_generated_field = "DE1A10C1CA4D58A0D0B71D5ED5651C5E")

    public static final int FEBRUARY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.658 -0500", hash_original_field = "E4EC554E62739257F49B8B29223FC5AF", hash_generated_field = "9A060A9F43E320077FEF91D7F3E16318")

    public static final int MARCH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.661 -0500", hash_original_field = "217EB13655AD9D91FCAA32C7F38020E5", hash_generated_field = "84082A64126E6ACD9A8A7166E76E4710")

    public static final int APRIL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.664 -0500", hash_original_field = "9E03CBCDCB21D12946D3F4E05FA20BA9", hash_generated_field = "2B49A74DDADD5147E334034FECF80F61")

    public static final int MAY = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.666 -0500", hash_original_field = "A2A0B43DDE1A6CFF792947D7FD6FCCC9", hash_generated_field = "40AAE596E48BB3CE7DED4445B6CA7C3A")

    public static final int JUNE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.669 -0500", hash_original_field = "CA65026A5E685AF2250934A4C12F3E9C", hash_generated_field = "57C7088304F19819321C68C4EA4D43FE")

    public static final int JULY = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.671 -0500", hash_original_field = "C30B5D569D49B695D9CE47C3B88D14C3", hash_generated_field = "DD0287EC2BAD39C6AA0CB00681983E13")

    public static final int AUGUST = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.674 -0500", hash_original_field = "0F70D2C7D822A952B4F804296DD4BC52", hash_generated_field = "65D9E0EA51CBB939F331D73F96E8F737")

    public static final int SEPTEMBER = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.676 -0500", hash_original_field = "915F62A76F7DD3E4C1CC1815E8EB5908", hash_generated_field = "5F215B3F48DD52DCA5B05BB8683ACB9E")

    public static final int OCTOBER = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.679 -0500", hash_original_field = "F774C99520113BD308DC7B2372D046AA", hash_generated_field = "07258F480C131FFB71C8F3192EC866BB")

    public static final int NOVEMBER = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.681 -0500", hash_original_field = "7E623836D4067D0F0AA519E7D093106B", hash_generated_field = "99346885877C320A88C5DEEF1FE5C6A1")

    public static final int DECEMBER = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.685 -0500", hash_original_field = "75D9389D334D550E05FECB529874FA33", hash_generated_field = "12CB74BD217D91F4A997C4A9B3204153")

    public static final int UNDECIMBER = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.687 -0500", hash_original_field = "B53AF7CBA0C12E8B461550AE0313BD16", hash_generated_field = "F91CDF25E1A1263D08DCDFDA293D2FF1")

    public static final int SUNDAY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.690 -0500", hash_original_field = "9567AE546C0609A9ABAD3C639649711D", hash_generated_field = "4F7898CDA37C0C1672B1DD0225C38742")

    public static final int MONDAY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.693 -0500", hash_original_field = "047508E2D0E4FC3D43D8A7832877CC9F", hash_generated_field = "EE1E35179BDB284983C5FA3C4A5286FB")

    public static final int TUESDAY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.695 -0500", hash_original_field = "6754BC73B95B624B26730DDF3CF7D3B6", hash_generated_field = "B8FE5FF93BBD24C3DBD1BA8DEAA957DF")

    public static final int WEDNESDAY = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.697 -0500", hash_original_field = "415AD65DC1BAF66746E73146C64FF40F", hash_generated_field = "3D06389FD7761B49C580CD0426877E03")

    public static final int THURSDAY = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.700 -0500", hash_original_field = "206BB123EA98621ED74C75DA6BD9391A", hash_generated_field = "6793376618E81D6864359810244D7454")

    public static final int FRIDAY = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.702 -0500", hash_original_field = "E8FE08A6A53B3579F77E067649CA78B6", hash_generated_field = "F33B8115640CE7F59D68A9F20CAEB4A4")

    public static final int SATURDAY = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.705 -0500", hash_original_field = "F090C2FBCCA10A64BD226CBBD16F5E95", hash_generated_field = "E301476B4E26DF25A92B3AA8A9107617")

    public static final int ERA = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.708 -0500", hash_original_field = "A7EAEF716B84CE7E731D85B5C012E338", hash_generated_field = "F11869056FDF683C955988AF5A0DDE34")

    public static final int YEAR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.710 -0500", hash_original_field = "3F085F0ADBD139F262E9B2B7BB7E9613", hash_generated_field = "7ADEC6D0CDDC20B12462876FAAA80E7F")

    public static final int MONTH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.713 -0500", hash_original_field = "35771AB5AA26C0DA566F13123C2B3267", hash_generated_field = "C4712C77A935F7F8EF3A0FAB8653CD50")

    public static final int WEEK_OF_YEAR = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.716 -0500", hash_original_field = "E37E7913C999950186EA441FBC645B6A", hash_generated_field = "4209CEA320055F2A79C871E83FA19ECD")

    public static final int WEEK_OF_MONTH = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.718 -0500", hash_original_field = "71D34D7D8AA274FE895C6C1FC526BD5B", hash_generated_field = "825B85B498FD03FCA906C87FB3805D32")

    public static final int DATE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.721 -0500", hash_original_field = "6DF544914C75FBF641F295B46AB4E2C0", hash_generated_field = "EFB6ACBBED425C9038C6D037D0082F4C")

    public static final int DAY_OF_MONTH = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.723 -0500", hash_original_field = "531EBC012130B7AAE62F3A7F68522B5F", hash_generated_field = "DDAC1EE15C7150842AE212280B96B617")

    public static final int DAY_OF_YEAR = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.726 -0500", hash_original_field = "C6A995B8225275500F18A2E7DFD5766D", hash_generated_field = "B5836DC3C1EA3C6522AC2F728E1D637D")

    public static final int DAY_OF_WEEK = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.729 -0500", hash_original_field = "5A1FF7CBF63CC9291D0772DD6FE503A9", hash_generated_field = "AECF12E2908165277F0D63DF571281C2")

    public static final int DAY_OF_WEEK_IN_MONTH = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.732 -0500", hash_original_field = "785D03FF23B0CAD154C38EA3A5BF6AD5", hash_generated_field = "FE3FF3E1A88CE7F17CFA86C2FD588F3A")

    public static final int AM_PM = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.734 -0500", hash_original_field = "74C2EAC20806E058AEE174CC5A312F8F", hash_generated_field = "EC0B014C2F8D2A70D0DC0E6595B16DC3")

    public static final int HOUR = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.737 -0500", hash_original_field = "6E72CF4A24999A2D4B8CD0A23AB78F57", hash_generated_field = "A6B692656855E13B4647C887CB94655F")

    public static final int HOUR_OF_DAY = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.740 -0500", hash_original_field = "7BE232E61F468461342D362DCF8143EC", hash_generated_field = "C1E0602297351F7BD222DD115F481FAA")

    public static final int MINUTE = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.742 -0500", hash_original_field = "DA3B5836E595FD86CD50F8FE85F62614", hash_generated_field = "50977DDBE62C0994013A6190F746E76D")

    public static final int SECOND = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.745 -0500", hash_original_field = "1D0F49F20C891E6184524643EECADC6B", hash_generated_field = "EBD943872B0DC03F8DA791205BB276E0")

    public static final int MILLISECOND = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.747 -0500", hash_original_field = "8678AD8024A68C9F23B3C38A0EA79274", hash_generated_field = "CF6B5B33A8280CA15F32F4C409683BB7")

    public static final int ZONE_OFFSET = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.749 -0500", hash_original_field = "8485FAC5791B6E99C0886EF0BBBD4B17", hash_generated_field = "5BC57F3FA8E3F55632AF6D9EE7639DD9")

    public static final int DST_OFFSET = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.752 -0500", hash_original_field = "0A5E4EE679F9915EC6F374646FB07833", hash_generated_field = "C0AD90D0AE4AA2CE7973DC573EBDB44F")

    public static final int FIELD_COUNT = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.755 -0500", hash_original_field = "B2AEB7141D72010CAF4CA22EADADE2B4", hash_generated_field = "12DF7D953F2E794CDDBE44C8913E7D53")

    public static final int AM = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.757 -0500", hash_original_field = "077B0C41E956DA3CD1C78F69C8E72F11", hash_generated_field = "8604262D117A4ECB98B8C2D2F8B21F35")

    public static final int PM = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.760 -0500", hash_original_field = "A5AE3E6269A72D6598718E9E4400A50B", hash_generated_field = "FDDDB5A7AFE2EF5F55DA4077744BE025")

    public static final int ALL_STYLES = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.763 -0500", hash_original_field = "02FB688FF9FAE7397AEA1A08E9B05152", hash_generated_field = "F7ACB78854980F98EB72B4076CEEC364")

    public static final int SHORT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.766 -0500", hash_original_field = "F98CB2249061B4F40F3CB699AFFB42D3", hash_generated_field = "00D4EA5E2F513F125A8CCE9688DB12D7")

    public static final int LONG = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.768 -0500", hash_original_field = "77F0167C8F21E8A84D31FA574DA522BF", hash_generated_field = "E98760CF948389324CD259C52EDE02C8")

    private static final String[] FIELD_NAMES = { "ERA", "YEAR", "MONTH",
            "WEEK_OF_YEAR", "WEEK_OF_MONTH", "DAY_OF_MONTH", "DAY_OF_YEAR",
            "DAY_OF_WEEK", "DAY_OF_WEEK_IN_MONTH", "AM_PM", "HOUR",
            "HOUR_OF_DAY", "MINUTE", "SECOND", "MILLISECOND",
            "ZONE_OFFSET", "DST_OFFSET" };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.908 -0500", hash_original_field = "AD47366764E5EFE3ABD0A29CF4241015", hash_generated_field = "38D65C9058142C88025F5AD8AC8D9090")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("areFieldsSet", boolean.class),
        new ObjectStreamField("fields", int[].class),
        new ObjectStreamField("firstDayOfWeek", int.class),
        new ObjectStreamField("isSet", boolean[].class),
        new ObjectStreamField("isTimeSet", boolean.class),
        new ObjectStreamField("lenient", boolean.class),
        new ObjectStreamField("minimalDaysInFirstWeek", int.class),
        new ObjectStreamField("nextStamp", int.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
        new ObjectStreamField("time", long.class),
        new ObjectStreamField("zone", TimeZone.class),
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.627 -0500", hash_original_field = "FC5805F94642E63247C8B0241D47B630", hash_generated_field = "CE3F9942C85635B6DB1739E7DBF40F0C")

    protected boolean areFieldsSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.629 -0500", hash_original_field = "5B55DADFFBF592AE1FCD826EADB0DFB1", hash_generated_field = "E574E68E645EC43F733A1248603B982F")

    protected int[] fields;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.632 -0500", hash_original_field = "11759D17CA54343BF0B7F4C784F772EC", hash_generated_field = "213F640A8226820C3FAD694FABC68220")

    protected boolean[] isSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.634 -0500", hash_original_field = "159B24B9313B3457B27C9F089C5507F8", hash_generated_field = "973A26005EDCFC142AE184E74D7A9C44")

    protected boolean isTimeSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.636 -0500", hash_original_field = "FB68C26D0BB5DD6577F61578B9AE66A8", hash_generated_field = "DF6F7F34B65DA140AA02B5623A896C3D")

    protected long time;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.639 -0500", hash_original_field = "81133861F580AD70A5F1D94554D53510", hash_generated_field = "8B06B22BB0D98B206D493E4536EE7432")

    transient int lastTimeFieldSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.642 -0500", hash_original_field = "1B46E0681663B26D10B6CA3A39018DC5", hash_generated_field = "FB479690428AB835107C0237892E7931")

    transient int lastDateFieldSet;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.644 -0500", hash_original_field = "F0C116C55DD7FB6180ECBEE0F0E0E9C6", hash_generated_field = "EAF178494884F790222D5DEEC0D047C3")

    private boolean lenient;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.646 -0500", hash_original_field = "D591572ED5B5BFDC9D565131C6CF2690", hash_generated_field = "AB58B3610E0723B715410016290F0168")

    private int firstDayOfWeek;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.649 -0500", hash_original_field = "5741E746E11541D804E4C7F4ECAFBD07", hash_generated_field = "B89C77A3F2A82BA7436489590490B056")

    private int minimalDaysInFirstWeek;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.651 -0500", hash_original_field = "879C1DD31D1F7B98FA691304642E4912", hash_generated_field = "05D717DFC6EF8897D7D254757AEA2790")

    private TimeZone zone;

    /**
     * Constructs a {@code Calendar} instance using the default {@code TimeZone} and {@code Locale}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.771 -0500", hash_original_method = "E09C10A5808D539238E77D59E7FF85D8", hash_generated_method = "61F8E9015365C5C0B51221FA55530C4E")
    
protected Calendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.774 -0500", hash_original_method = "88FEBE5E333C1748D0E9CCFA28BF3B86", hash_generated_method = "88FEBE5E333C1748D0E9CCFA28BF3B86")
    
Calendar(TimeZone timezone) {
        fields = new int[FIELD_COUNT];
        isSet = new boolean[FIELD_COUNT];
        areFieldsSet = isTimeSet = false;
        setLenient(true);
        setTimeZone(timezone);
    }

    /**
     * Constructs a {@code Calendar} instance using the specified {@code TimeZone} and {@code Locale}.
     *
     * @param timezone
     *            the timezone.
     * @param locale
     *            the locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.777 -0500", hash_original_method = "DC052852760F164E5EB6C2F703BBC41B", hash_generated_method = "3B6944312729AE6C0F7E674438547B28")
    
protected Calendar(TimeZone timezone, Locale locale) {
        this(timezone);
        LocaleData localeData = LocaleData.get(locale);
        setFirstDayOfWeek(localeData.firstDayOfWeek.intValue());
        setMinimalDaysInFirstWeek(localeData.minimalDaysInFirstWeek.intValue());
    }

    /**
     * Adds the specified amount to a {@code Calendar} field.
     *
     * @param field
     *            the {@code Calendar} field to modify.
     * @param value
     *            the amount to add to the field.
     * @throws IllegalArgumentException
     *                if {@code field} is {@code DST_OFFSET} or {@code
     *                ZONE_OFFSET}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.779 -0500", hash_original_method = "1B9CB183169BC098F5BE7A4F2BEC8165", hash_generated_method = "6DCB531333EC528588018EC7E90A2656")
    
public abstract void add(int field, int value);

    /**
     * Returns whether the {@code Date} specified by this {@code Calendar} instance is after the {@code Date}
     * specified by the parameter. The comparison is not dependent on the time
     * zones of the {@code Calendar}.
     *
     * @param calendar
     *            the {@code Calendar} instance to compare.
     * @return {@code true} when this Calendar is after calendar, {@code false} otherwise.
     * @throws IllegalArgumentException
     *                if the time is not set and the time cannot be computed
     *                from the current field values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.782 -0500", hash_original_method = "3DBAFBF02CB3C60196FBCDD8387C90F7", hash_generated_method = "946A7264FDC9C4B4729C2B236470BDD9")
    
public boolean after(Object calendar) {
        if (!(calendar instanceof Calendar)) {
            return false;
        }
        return getTimeInMillis() > ((Calendar) calendar).getTimeInMillis();
    }

    /**
     * Returns whether the {@code Date} specified by this {@code Calendar} instance is before the
     * {@code Date} specified by the parameter. The comparison is not dependent on the
     * time zones of the {@code Calendar}.
     *
     * @param calendar
     *            the {@code Calendar} instance to compare.
     * @return {@code true} when this Calendar is before calendar, {@code false} otherwise.
     * @throws IllegalArgumentException
     *                if the time is not set and the time cannot be computed
     *                from the current field values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.784 -0500", hash_original_method = "AB514F7047FACF0A18BC971364ADD066", hash_generated_method = "9A9B7F62422D6C2D080C1E4DE5B2DE1C")
    
public boolean before(Object calendar) {
        if (!(calendar instanceof Calendar)) {
            return false;
        }
        return getTimeInMillis() < ((Calendar) calendar).getTimeInMillis();
    }

    /**
     * Clears all of the fields of this {@code Calendar}. All fields are initialized to
     * zero.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.787 -0500", hash_original_method = "A9FFD41082BBDB8FD2EC401621467C0D", hash_generated_method = "C60FBC917B126A90B6D04D03036D7F06")
    
public final void clear() {
        for (int i = 0; i < FIELD_COUNT; i++) {
            fields[i] = 0;
            isSet[i] = false;
        }
        areFieldsSet = isTimeSet = false;
    }

    /**
     * Clears the specified field to zero and sets the isSet flag to {@code false}.
     *
     * @param field
     *            the field to clear.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.789 -0500", hash_original_method = "045ED04F1C7B7EFD467C2025674AC1C4", hash_generated_method = "394639ACC8586FF2373B339CD62BD0A9")
    
public final void clear(int field) {
        fields[field] = 0;
        isSet[field] = false;
        areFieldsSet = isTimeSet = false;
    }

    /**
     * Returns a new {@code Calendar} with the same properties.
     *
     * @return a shallow copy of this {@code Calendar}.
     *
     * @see java.lang.Cloneable
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.792 -0500", hash_original_method = "84D98F75151E4961D0916EA8CB3E0C38", hash_generated_method = "9F925B1A9D8B19359C917CFA9357F831")
    
@Override
    public Object clone() {
        try {
            Calendar clone = (Calendar) super.clone();
            clone.fields = fields.clone();
            clone.isSet = isSet.clone();
            clone.zone = (TimeZone) zone.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Computes the time from the fields if the time has not already been set.
     * Computes the fields from the time if the fields are not already set.
     *
     * @throws IllegalArgumentException
     *                if the time is not set and the time cannot be computed
     *                from the current field values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.794 -0500", hash_original_method = "A716BA757DE54F1250A3DB16F903EEB4", hash_generated_method = "75E3D8BB2F052EB74C0E433F9BCDAF91")
    
protected void complete() {
        if (!isTimeSet) {
            computeTime();
            isTimeSet = true;
        }
        if (!areFieldsSet) {
            computeFields();
            areFieldsSet = true;
        }
    }

    /**
     * Computes the {@code Calendar} fields from {@code time}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.797 -0500", hash_original_method = "13BBC340BA44DE8D38B9076FA1C054A9", hash_generated_method = "37629A66BECD3D6F5E10A82E09704267")
    
protected abstract void computeFields();

    /**
     * Computes {@code time} from the Calendar fields.
     *
     * @throws IllegalArgumentException
     *                if the time cannot be computed from the current field
     *                values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.799 -0500", hash_original_method = "20228C8C89B016D8EF2F596CD8D792FA", hash_generated_method = "24696761EFECCCA4BEAAC6843B3F6C86")
    
protected abstract void computeTime();

    /**
     * Compares the specified object to this {@code Calendar} and returns whether they are
     * equal. The object must be an instance of {@code Calendar} and have the same
     * properties.
     *
     * @param object
     *            the object to compare with this object.
     * @return {@code true} if the specified object is equal to this {@code Calendar}, {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.803 -0500", hash_original_method = "A4F7F4EE453A4994C5225BE31C26C1E8", hash_generated_method = "7E273282EEB021C923521D39C6D143FA")
    
@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Calendar)) {
            return false;
        }
        Calendar cal = (Calendar) object;
        return getTimeInMillis() == cal.getTimeInMillis()
                && isLenient() == cal.isLenient()
                && getFirstDayOfWeek() == cal.getFirstDayOfWeek()
                && getMinimalDaysInFirstWeek() == cal
                        .getMinimalDaysInFirstWeek()
                && getTimeZone().equals(cal.getTimeZone());
    }

    /**
     * Gets the value of the specified field after computing the field values by
     * calling {@code complete()} first.
     *
     * @param field
     *            the field to get.
     * @return the value of the specified field.
     *
     * @throws IllegalArgumentException
     *                if the fields are not set, the time is not set, and the
     *                time cannot be computed from the current field values.
     * @throws ArrayIndexOutOfBoundsException
     *                if the field is not inside the range of possible fields.
     *                The range is starting at 0 up to {@code FIELD_COUNT}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.805 -0500", hash_original_method = "E826346499B559368BF751B42F34C786", hash_generated_method = "BFD89F8C941521842F808A630258D5A2")
    
public int get(int field) {
        complete();
        return fields[field];
    }

    /**
     * Gets the maximum value of the specified field for the current date.
     *
     * @param field
     *            the field.
     * @return the maximum value of the specified field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.808 -0500", hash_original_method = "424E8E96F9A12B00FD5C6FDA146C325F", hash_generated_method = "EB24B22066B0F5278E4EF0DBD545A1BC")
    
public int getActualMaximum(int field) {
        int value, next;
        if (getMaximum(field) == (next = getLeastMaximum(field))) {
            return next;
        }
        complete();
        long orgTime = time;
        set(field, next);
        do {
            value = next;
            roll(field, true);
            next = get(field);
        } while (next > value);
        time = orgTime;
        areFieldsSet = false;
        return value;
    }

    /**
     * Gets the minimum value of the specified field for the current date.
     *
     * @param field
     *            the field.
     * @return the minimum value of the specified field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.810 -0500", hash_original_method = "598A84D60F29BB97F62226BCCD8A7F9E", hash_generated_method = "3204F8E5882D21531F11D7461CBACF1A")
    
public int getActualMinimum(int field) {
        int value, next;
        if (getMinimum(field) == (next = getGreatestMinimum(field))) {
            return next;
        }
        complete();
        long orgTime = time;
        set(field, next);
        do {
            value = next;
            roll(field, false);
            next = get(field);
        } while (next < value);
        time = orgTime;
        areFieldsSet = false;
        return value;
    }

    /**
     * Gets the first day of the week for this {@code Calendar}.
     *
     * @return the first day of the week.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.815 -0500", hash_original_method = "2210DC8BCE617C61AD2F9503CE7923B1", hash_generated_method = "B7D3E606B6C61019423BEA5BE2438F0B")
    
public int getFirstDayOfWeek() {
        return firstDayOfWeek;
    }

    /**
     * Gets the greatest minimum value of the specified field. This is the
     * biggest value that {@code getActualMinimum} can return for any possible
     * time.
     *
     * @param field
     *            the field.
     * @return the greatest minimum value of the specified field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.818 -0500", hash_original_method = "F4E4C6EEC0A04B890531C5BC8563F43A", hash_generated_method = "B7ABBC759B267BFEB3B0E8148923227A")
    
public abstract int getGreatestMinimum(int field);

    /**
     * Gets the smallest maximum value of the specified field. This is the
     * smallest value that {@code getActualMaximum()} can return for any
     * possible time.
     *
     * @param field
     *            the field number.
     * @return the smallest maximum value of the specified field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.831 -0500", hash_original_method = "5BA3EE65DFA41B110C1BA06A0C25C5CB", hash_generated_method = "6FF57DECEF69A4263E77462366234388")
    
public abstract int getLeastMaximum(int field);

    /**
     * Gets the greatest maximum value of the specified field. This returns the
     * biggest value that {@code get} can return for the specified field.
     *
     * @param field
     *            the field.
     * @return the greatest maximum value of the specified field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.834 -0500", hash_original_method = "3355B4B72CA8380FA4AE226D96B7F07A", hash_generated_method = "14D647A704686C1BC12D163BEC0AF438")
    
public abstract int getMaximum(int field);

    /**
     * Gets the minimal days in the first week of the year.
     *
     * @return the minimal days in the first week of the year.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.836 -0500", hash_original_method = "104647FF062CF5167F06DB549E6DD4EB", hash_generated_method = "84FFD4E08543D1852F52CF39C905704A")
    
public int getMinimalDaysInFirstWeek() {
        return minimalDaysInFirstWeek;
    }

    /**
     * Gets the smallest minimum value of the specified field. this returns the
     * smallest value thet {@code get} can return for the specified field.
     *
     * @param field
     *            the field number.
     * @return the smallest minimum value of the specified field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.838 -0500", hash_original_method = "40653EC39304E8F2297D1CEE6C7E84EC", hash_generated_method = "20CCD6BF9462D8C6E0194AA9AC6710E5")
    
public abstract int getMinimum(int field);

    /**
     * Gets the time of this {@code Calendar} as a {@code Date} object.
     *
     * @return a new {@code Date} initialized to the time of this {@code Calendar}.
     *
     * @throws IllegalArgumentException
     *                if the time is not set and the time cannot be computed
     *                from the current field values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.841 -0500", hash_original_method = "0D972793C1A81D3B5C0D23389B920FB5", hash_generated_method = "04B7220A597D699C98A15AA207DDB442")
    
public final Date getTime() {
        return new Date(getTimeInMillis());
    }

    /**
     * Computes the time from the fields if required and returns the time.
     *
     * @return the time of this {@code Calendar}.
     *
     * @throws IllegalArgumentException
     *                if the time is not set and the time cannot be computed
     *                from the current field values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.844 -0500", hash_original_method = "1B58DB6425011C7C1965B5C43056D530", hash_generated_method = "28EF64564E32533BE41A42298042EDE5")
    
public long getTimeInMillis() {
        if (!isTimeSet) {
            computeTime();
            isTimeSet = true;
        }
        return time;
    }

    /**
     * Gets the timezone of this {@code Calendar}.
     *
     * @return the {@code TimeZone} used by this {@code Calendar}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.846 -0500", hash_original_method = "A62BA7A8B3AE52F44B15929DB0809596", hash_generated_method = "524E7797970F542E897CBB3E44B0D9E1")
    
public TimeZone getTimeZone() {
        return zone;
    }

    /**
     * Returns an integer hash code for the receiver. Objects which are equal
     * return the same value for this method.
     *
     * @return the receiver's hash.
     *
     * @see #equals
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.848 -0500", hash_original_method = "2D54AA953826341AD4FD2AC42B53AEBA", hash_generated_method = "3817A1E140F544A07421DB2B641C8EE1")
    
@Override
    public int hashCode() {
        return (isLenient() ? 1237 : 1231) + getFirstDayOfWeek()
                + getMinimalDaysInFirstWeek() + getTimeZone().hashCode();
    }

    /**
     * Gets the value of the specified field without recomputing.
     *
     * @param field
     *            the field.
     * @return the value of the specified field.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.851 -0500", hash_original_method = "B2249A52847A00BE88915EAA81CF8D45", hash_generated_method = "35D3B6B00D409E2B957E628010070CEA")
    
protected final int internalGet(int field) {
        return fields[field];
    }

    /**
     * Returns if this {@code Calendar} accepts field values which are outside the valid
     * range for the field.
     *
     * @return {@code true} if this {@code Calendar} is lenient, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.853 -0500", hash_original_method = "5DB017D3EE054B32EA01614D92601D4D", hash_generated_method = "C62132ECBD6865657ACD967E0D3060C4")
    
public boolean isLenient() {
        return lenient;
    }

    /**
     * Returns whether the specified field is set. Note that the interpretation of "is set" is
     * somewhat technical. In particular, it does <i>not</i> mean that the field's value is up
     * to date. If you want to know whether a field contains an up-to-date value, you must also
     * check {@code areFieldsSet}, making this method somewhat useless unless you're a subclass,
     * in which case you can access the {@code isSet} array directly.
     * <p>
     * A field remains "set" from the first time its value is computed until it's cleared by one
     * of the {@code clear} methods. Thus "set" does not mean "valid". You probably want to call
     * {@code get} -- which will update fields as necessary -- rather than try to make use of
     * this method.
     *
     * @param field
     *            a {@code Calendar} field number.
     * @return {@code true} if the specified field is set, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.856 -0500", hash_original_method = "295995F35CFAB02328483B566F7330CE", hash_generated_method = "12A15AF15494313470E223FEDFF5F9B3")
    
public final boolean isSet(int field) {
        return isSet[field];
    }

    /**
     * Adds the specified amount to the specified field and wraps the value of
     * the field when it goes beyond the maximum or minimum value for the
     * current date. Other fields will be adjusted as required to maintain a
     * consistent date.
     *
     * @param field
     *            the field to roll.
     * @param value
     *            the amount to add.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.859 -0500", hash_original_method = "F5FA416393576D1F9DD8BCE9349020A6", hash_generated_method = "8E0B2441A103EF5E775007B523F1529E")
    
public void roll(int field, int value) {
        boolean increment = value >= 0;
        int count = increment ? value : -value;
        for (int i = 0; i < count; i++) {
            roll(field, increment);
        }
    }

    /**
     * Increment or decrement the specified field and wrap the value of the
     * field when it goes beyond the maximum or minimum value for the current
     * date. Other fields will be adjusted as required to maintain a consistent
     * date.
     *
     * @param field
     *            the number indicating the field to roll.
     * @param increment
     *            {@code true} to increment the field, {@code false} to decrement.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.861 -0500", hash_original_method = "5568E08CE0018BF3C7BFBB2216804222", hash_generated_method = "BD9147ED990B352EC9A76A2CA2EE6A7B")
    
public abstract void roll(int field, boolean increment);

    /**
     * Sets a field to the specified value.
     *
     * @param field
     *            the code indicating the {@code Calendar} field to modify.
     * @param value
     *            the value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.864 -0500", hash_original_method = "41A9E001F522D5852F11FBD319F3A5A6", hash_generated_method = "EEB5FE9A242FA94FDA1DF2E8AE027E44")
    
public void set(int field, int value) {
        fields[field] = value;
        isSet[field] = true;
        areFieldsSet = isTimeSet = false;
        if (field > MONTH && field < AM_PM) {
            lastDateFieldSet = field;
        }
        if (field == HOUR || field == HOUR_OF_DAY) {
            lastTimeFieldSet = field;
        }
        if (field == AM_PM) {
            lastTimeFieldSet = HOUR;
        }
    }

    /**
     * Sets the year, month and day of the month fields. Other fields are not
     * changed.
     *
     * @param year
     *            the year.
     * @param month
     *            the month.
     * @param day
     *            the day of the month.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.866 -0500", hash_original_method = "E11C90BCB39036715964798223610892", hash_generated_method = "382574715A132933C4F1A96C29BAB6FE")
    
public final void set(int year, int month, int day) {
        set(YEAR, year);
        set(MONTH, month);
        set(DATE, day);
    }

    /**
     * Sets the year, month, day of the month, hour of day and minute fields.
     * Other fields are not changed.
     *
     * @param year
     *            the year.
     * @param month
     *            the month.
     * @param day
     *            the day of the month.
     * @param hourOfDay
     *            the hour of day.
     * @param minute
     *            the minute.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.869 -0500", hash_original_method = "B4EBEBE6ED320058BB13C1E33AF949E4", hash_generated_method = "396504D08E42B024F7F32C7E28DC7024")
    
public final void set(int year, int month, int day, int hourOfDay,
            int minute) {
        set(year, month, day);
        set(HOUR_OF_DAY, hourOfDay);
        set(MINUTE, minute);
    }

    /**
     * Sets the year, month, day of the month, hour of day, minute and second
     * fields. Other fields are not changed.
     *
     * @param year
     *            the year.
     * @param month
     *            the month.
     * @param day
     *            the day of the month.
     * @param hourOfDay
     *            the hour of day.
     * @param minute
     *            the minute.
     * @param second
     *            the second.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.872 -0500", hash_original_method = "071B019FF423902B33C61C7D7703D8F0", hash_generated_method = "02E66189939C24081396104958954FC7")
    
public final void set(int year, int month, int day, int hourOfDay,
            int minute, int second) {
        set(year, month, day, hourOfDay, minute);
        set(SECOND, second);
    }

    /**
     * Sets the first day of the week for this {@code Calendar}.
     *
     * @param value
     *            a {@code Calendar} day of the week.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.874 -0500", hash_original_method = "9CEC56E07503C11B5926FEE82FE32939", hash_generated_method = "F6A024F78B92054A707AEDADB71088DB")
    
public void setFirstDayOfWeek(int value) {
        firstDayOfWeek = value;
    }

    /**
     * Sets this {@code Calendar} to accept field values which are outside the valid
     * range for the field.
     *
     * @param value
     *            a boolean value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.876 -0500", hash_original_method = "769D5CCA341B85723A2FDFB2D353BC44", hash_generated_method = "D8A4E2565741252BEA897243BCA0D17F")
    
public void setLenient(boolean value) {
        lenient = value;
    }

    /**
     * Sets the minimal days in the first week of the year.
     *
     * @param value
     *            the minimal days in the first week of the year.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.878 -0500", hash_original_method = "ABF413A19C063DF72268F54419071447", hash_generated_method = "2B5F5E1A950E61878F21A49F154920D6")
    
public void setMinimalDaysInFirstWeek(int value) {
        minimalDaysInFirstWeek = value;
    }

    /**
     * Sets the time of this {@code Calendar}.
     *
     * @param date
     *            a {@code Date} object.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.881 -0500", hash_original_method = "8326734B6F30C707435A4BD203126230", hash_generated_method = "89DD3665E4887379FA91D0FAB7FFB3C5")
    
public final void setTime(Date date) {
        setTimeInMillis(date.getTime());
    }

    /**
     * Sets the time of this {@code Calendar}.
     *
     * @param milliseconds
     *            the time as the number of milliseconds since Jan. 1, 1970.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.883 -0500", hash_original_method = "2FA47445AF3A8C90A658A67E45128F41", hash_generated_method = "D037828412FE9050EB1010FB3CDF0A1B")
    
public void setTimeInMillis(long milliseconds) {
        if (!isTimeSet || !areFieldsSet || time != milliseconds) {
            time = milliseconds;
            isTimeSet = true;
            areFieldsSet = false;
            complete();
        }
    }

    /**
     * Sets the {@code TimeZone} used by this Calendar.
     *
     * @param timezone
     *            a {@code TimeZone}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.886 -0500", hash_original_method = "C71A9CD315A030E06030733CE10A6247", hash_generated_method = "B7AADE9B728D570FAA215A9CDF58CB0B")
    
public void setTimeZone(TimeZone timezone) {
        zone = timezone;
        areFieldsSet = false;
    }

    /**
     * Returns the string representation of this {@code Calendar}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.889 -0500", hash_original_method = "FE2881479678F103D2A9794655ED1F87", hash_generated_method = "A659789D7AE8DD5BFBBF07EE83CBBA9B")
    
@Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getName() +
                "[time=" + (isTimeSet ? String.valueOf(time) : "?") +
                ",areFieldsSet=" + areFieldsSet +
                ",lenient=" + lenient +
                ",zone=" + zone.getID() +
                ",firstDayOfWeek=" + firstDayOfWeek +
                ",minimalDaysInFirstWeek=" + minimalDaysInFirstWeek);
        for (int i = 0; i < FIELD_COUNT; i++) {
            result.append(',');
            result.append(FIELD_NAMES[i]);
            result.append('=');
            if (isSet[i]) {
                result.append(fields[i]);
            } else {
                result.append('?');
            }
        }
        result.append(']');
        return result.toString();
    }

    /**
     * Compares the times of the two {@code Calendar}, which represent the milliseconds
     * from the January 1, 1970 00:00:00.000 GMT (Gregorian).
     *
     * @param anotherCalendar
     *            another calendar that this one is compared with.
     * @return 0 if the times of the two {@code Calendar}s are equal, -1 if the time of
     *         this {@code Calendar} is before the other one, 1 if the time of this
     *         {@code Calendar} is after the other one.
     * @throws NullPointerException
     *             if the argument is null.
     * @throws IllegalArgumentException
     *             if the argument does not include a valid time
     *             value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.891 -0500", hash_original_method = "91CA2BBC83B63568E9D66A64F5127506", hash_generated_method = "EC897AD1DDC3949600B2A9BBD5059FBE")
    
public int compareTo(Calendar anotherCalendar) {
        if (anotherCalendar == null) {
            throw new NullPointerException();
        }
        long timeInMillis = getTimeInMillis();
        long anotherTimeInMillis = anotherCalendar.getTimeInMillis();
        if (timeInMillis > anotherTimeInMillis) {
            return 1;
        }
        if (timeInMillis == anotherTimeInMillis) {
            return 0;
        }
        return -1;
    }

    /**
     * Returns a human-readable string for the value of {@code field}
     * using the given style and locale. If no string is available, returns null.
     * The value is retrieved by invoking {@code get(field)}.
     *
     * <p>For example, {@code getDisplayName(MONTH, SHORT, Locale.US)} will return "Jan"
     * while {@code getDisplayName(MONTH, LONG, Locale.US)} will return "January".
     *
     * @param field the field
     * @param style {@code SHORT} or {@code LONG}
     * @param locale the locale
     * @return the display name, or null
     * @throws NullPointerException if {@code locale == null}
     * @throws IllegalArgumentException if {@code field} or {@code style} is invalid
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.894 -0500", hash_original_method = "3943CE5519C03267AB2522359CAFDF8D", hash_generated_method = "E0B67D2751957E12D0908AF0B49A4D74")
    
public String getDisplayName(int field, int style, Locale locale) {
        // TODO: the RI's documentation says ALL_STYLES is invalid, but actually treats it as SHORT.
        if (style == ALL_STYLES) {
            style = SHORT;
        }
        String[] array = getDisplayNameArray(field, style, locale);
        int value = get(field);
        return (array != null) ? array[value] : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.897 -0500", hash_original_method = "23B9DFD5A49D248BECD0B5B67B00C262", hash_generated_method = "CB0A6AF9007B3D679F6213CA201122FE")
    
private String[] getDisplayNameArray(int field, int style, Locale locale) {
        if (field < 0 || field >= FIELD_COUNT) {
            throw new IllegalArgumentException("bad field " + field);
        }
        checkStyle(style);
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(locale);
        switch (field) {
        case AM_PM:
            return dfs.getAmPmStrings();
        case DAY_OF_WEEK:
            return (style == LONG) ? dfs.getWeekdays() : dfs.getShortWeekdays();
        case ERA:
            return dfs.getEras();
        case MONTH:
            return (style == LONG) ? dfs.getMonths() : dfs.getShortMonths();
        }
        return null;
    }

    /**
     * Returns a map of human-readable strings to corresponding values,
     * for the given field, style, and locale.
     * Returns null if no strings are available.
     *
     * <p>For example, {@code getDisplayNames(MONTH, ALL_STYLES, Locale.US)} would
     * contain mappings from "Jan" and "January" to {@link #JANUARY}, and so on.
     *
     * @param field the field
     * @param style {@code SHORT}, {@code LONG}, or {@code ALL_STYLES}
     * @param locale the locale
     * @return the display name, or null
     * @throws NullPointerException if {@code locale == null}
     * @throws IllegalArgumentException if {@code field} or {@code style} is invalid
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.902 -0500", hash_original_method = "9C5842A520266160609E6030F348A85B", hash_generated_method = "C9AA05DC71F66EAFB20EC782FFDCC03C")
    
public Map<String, Integer> getDisplayNames(int field, int style, Locale locale) {
        checkStyle(style);
        complete();
        Map<String, Integer> result = new HashMap<String, Integer>();
        if (style == SHORT || style == ALL_STYLES) {
            insertValuesInMap(result, getDisplayNameArray(field, SHORT, locale));
        }
        if (style == LONG || style == ALL_STYLES) {
            insertValuesInMap(result, getDisplayNameArray(field, LONG, locale));
        }
        return result.isEmpty() ? null : result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.911 -0500", hash_original_method = "B466F6EE281116CF7ABF0D209ADAF19B", hash_generated_method = "D2A5EA54520D023D762C26421501FEEF")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        complete();
        ObjectOutputStream.PutField putFields = stream.putFields();
        putFields.put("areFieldsSet", areFieldsSet);
        putFields.put("fields", this.fields);
        putFields.put("firstDayOfWeek", firstDayOfWeek);
        putFields.put("isSet", isSet);
        putFields.put("isTimeSet", isTimeSet);
        putFields.put("lenient", lenient);
        putFields.put("minimalDaysInFirstWeek", minimalDaysInFirstWeek);
        putFields.put("nextStamp", 2 /* MINIMUM_USER_STAMP */);
        putFields.put("serialVersionOnStream", 1);
        putFields.put("time", time);
        putFields.put("zone", zone);
        stream.writeFields();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.913 -0500", hash_original_method = "8FB104B0DF4EC943895E45AF22309DC6", hash_generated_method = "B8B675DD2ADC51122406D660965C1759")
    
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = stream.readFields();
        areFieldsSet = readFields.get("areFieldsSet", false);
        this.fields = (int[]) readFields.get("fields", null);
        firstDayOfWeek = readFields.get("firstDayOfWeek", Calendar.SUNDAY);
        isSet = (boolean[]) readFields.get("isSet", null);
        isTimeSet = readFields.get("isTimeSet", false);
        lenient = readFields.get("lenient", true);
        minimalDaysInFirstWeek = readFields.get("minimalDaysInFirstWeek", 1);
        time = readFields.get("time", 0L);
        zone = (TimeZone) readFields.get("zone", null);
    }
}

