package android.text.format;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Resources;
import java.util.Locale;
import java.util.TimeZone;

public class Time {
    public boolean allDay;
    public int second;
    public int minute;
    public int hour;
    public int monthDay;
    public int month;
    public int year;
    public int weekDay;
    public int yearDay;
    public int isDst;
    public long gmtoff;
    public String timezone;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.124 -0400", hash_original_method = "E0FCF5C2DD1FC8B8CECA3F88CA26F2FA", hash_generated_method = "003D2D6D08B5E3B938753B3815CC63FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Time(String timezone) {
        dsTaint.addTaint(timezone);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("timezone is null!");
        } //End block
        this.year = 1970;
        this.monthDay = 1;
        this.isDst = -1;
        // ---------- Original Method ----------
        //if (timezone == null) {
            //throw new NullPointerException("timezone is null!");
        //}
        //this.timezone = timezone;
        //this.year = 1970;
        //this.monthDay = 1;
        //this.isDst = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.124 -0400", hash_original_method = "B143F86B302A5932C8EBD6FB2BD46478", hash_generated_method = "D523B0EECDBAE13FC752EA1B886457F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Time() {
        this(TimeZone.getDefault().getID());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.124 -0400", hash_original_method = "5882A59C3CCF918AE2BB2D84CAA18E36", hash_generated_method = "FE0A49E376B2623BF50851025EC1BB87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Time(Time other) {
        dsTaint.addTaint(other.dsTaint);
        set(other);
        // ---------- Original Method ----------
        //set(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.125 -0400", hash_original_method = "7DE92E5F5A39A244E977EE497A88E369", hash_generated_method = "257A9EA624417E0967032816ABE5604C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long normalize(boolean ignoreDst) {
        dsTaint.addTaint(ignoreDst);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.125 -0400", hash_original_method = "13E8DE21AE4CB3AA83156EE3A5950ED3", hash_generated_method = "DD048329B1D31F05D0834570558A1725")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void switchTimezone(String timezone) {
        dsTaint.addTaint(timezone);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.125 -0400", hash_original_method = "DF789B90859E8F04F5333F3487A99DFB", hash_generated_method = "33FC20812BDF73FF0C2D537034FEF25C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getActualMaximum(int field) {
        dsTaint.addTaint(field);
        //Begin case MONTH_DAY 
        {
            int n;
            n = DAYS_PER_MONTH[this.month];
            {
                int y;
                y = this.year;
            } //End block
        } //End block
        //End case MONTH_DAY 
        //Begin case YEAR_DAY 
        {
            int y;
            y = this.year;
        } //End block
        //End case YEAR_DAY 
        //Begin case WEEK_NUM 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("WEEK_NUM not implemented");
        //End case WEEK_NUM 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad field=" + field);
        //End case default 
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.126 -0400", hash_original_method = "CE0E4353FCA63B39E00F0F1C4B7BFC83", hash_generated_method = "E6C9A5A865F9281AE70123CBCBF71AE5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear(String timezone) {
        dsTaint.addTaint(timezone);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("timezone is null!");
        } //End block
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
        // ---------- Original Method ----------
        //if (timezone == null) {
            //throw new NullPointerException("timezone is null!");
        //}
        //this.timezone = timezone;
        //this.allDay = false;
        //this.second = 0;
        //this.minute = 0;
        //this.hour = 0;
        //this.monthDay = 0;
        //this.month = 0;
        //this.year = 0;
        //this.weekDay = 0;
        //this.yearDay = 0;
        //this.gmtoff = 0;
        //this.isDst = -1;
    }

    
        public static int compare(Time a, Time b) {
        if (a == null) {
            throw new NullPointerException("a == null");
        } else if (b == null) {
            throw new NullPointerException("b == null");
        }
        return nativeCompare(a, b);
    }

    
        private static int nativeCompare(Time a, Time b) {
        return DSUtils.UNKNOWN_INT;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.127 -0400", hash_original_method = "2DA36736B256CECB86984D41B76F2A40", hash_generated_method = "7AC4D1AFFA5D16D52D47EDA957F9D9AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String format(String format) {
        dsTaint.addTaint(format);
        {
            Locale locale;
            locale = Locale.getDefault();
            {
                boolean var986A7EABE77A45251BA68D07070DB5A1_1381366478 = (sLocale == null || locale == null || !(locale.equals(sLocale)));
                {
                    Resources r;
                    r = Resources.getSystem();
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
                } //End block
            } //End collapsed parenthetic
            String var112E92CB2F9C8152C61E459F0A3352AD_76395886 = (format1(format));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.128 -0400", hash_original_method = "751765C8BBD19CCE2EF370E3AB9D4D19", hash_generated_method = "61340025F635D225CA614E9A53F13893")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String format1(String format) {
        dsTaint.addTaint(format);
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.128 -0400", hash_original_method = "D4E4943029EE450E10D723A13B21ADBA", hash_generated_method = "27B3657DD36687861B814C8D1FB68342")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.128 -0400", hash_original_method = "412A6EFDB33A9BCE94A5C52880803E0F", hash_generated_method = "A909F3DB00699C72930CAF27B65E4901")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean parse(String s) {
        dsTaint.addTaint(s);
        {
            boolean varB489FB41A585FE2A62DA4FB42B18FDCC_1082683406 = (nativeParse(s));
            {
                timezone = TIMEZONE_UTC;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (nativeParse(s)) {
            //timezone = TIMEZONE_UTC;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.128 -0400", hash_original_method = "715F84C962A7921497F55D5349A2140A", hash_generated_method = "AB7A5A7263DF7236D8EB776DE2072689")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeParse(String s) {
        dsTaint.addTaint(s);
        return dsTaint.getTaintBoolean();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.129 -0400", hash_original_method = "E417695E8CAC19265A6537D747474825", hash_generated_method = "60012CEEEE28B59D9D7419F2FC89FC8C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean parse3339(String s) {
        dsTaint.addTaint(s);
        {
            boolean var85DE61D4D5D74B9595714ACEED12BD09_1428196403 = (nativeParse3339(s));
            {
                timezone = TIMEZONE_UTC;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (nativeParse3339(s)) {
             //timezone = TIMEZONE_UTC;
             //return true;
         //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.129 -0400", hash_original_method = "57499E6D502331FE1EE9DA37E2D15CA3", hash_generated_method = "E0E2E3A14172B177C684D36F1C4CF2C9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean nativeParse3339(String s) {
        dsTaint.addTaint(s);
        return dsTaint.getTaintBoolean();
    }

    
        public static String getCurrentTimezone() {
        return TimeZone.getDefault().getID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.129 -0400", hash_original_method = "6CDA1CA0525F04C652EDF79AA26F0E90", hash_generated_method = "0DE05A8FA6CB506B4E2313C7C1218631")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setToNow() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.129 -0400", hash_original_method = "C1956449864825DE1FCC969EAC519409", hash_generated_method = "D83D3E6C66F548F0B30849B83378EF1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long toMillis(boolean ignoreDst) {
        dsTaint.addTaint(ignoreDst);
        return dsTaint.getTaintLong();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.129 -0400", hash_original_method = "934B6518FEFEB3D5C2DEFA32BEB78382", hash_generated_method = "D97895DA57D5572F2F0A50DA2B6A632A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(long millis) {
        dsTaint.addTaint(millis);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.130 -0400", hash_original_method = "41A869EF339B8E1FD69184435BC2AFF4", hash_generated_method = "857966D485D605B7C72925B7C4C1DA28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String format2445() {
        return dsTaint.getTaintString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.130 -0400", hash_original_method = "F960E973DC6F4E791CEC3120624756A7", hash_generated_method = "0603C19C15714A2F3D7571D47BB4FCAF")
    @DSModeled(DSC.SAFE)
    public void set(Time that) {
        dsTaint.addTaint(that.dsTaint);
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
        // ---------- Original Method ----------
        //this.timezone = that.timezone;
        //this.allDay = that.allDay;
        //this.second = that.second;
        //this.minute = that.minute;
        //this.hour = that.hour;
        //this.monthDay = that.monthDay;
        //this.month = that.month;
        //this.year = that.year;
        //this.weekDay = that.weekDay;
        //this.yearDay = that.yearDay;
        //this.isDst = that.isDst;
        //this.gmtoff = that.gmtoff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.130 -0400", hash_original_method = "667ED0F0E30647AFF648664194B11038", hash_generated_method = "885D9BC35E0FC7F0CA0CE9D0C434B5EE")
    @DSModeled(DSC.SAFE)
    public void set(int second, int minute, int hour, int monthDay, int month, int year) {
        dsTaint.addTaint(minute);
        dsTaint.addTaint(second);
        dsTaint.addTaint(monthDay);
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        dsTaint.addTaint(hour);
        this.allDay = false;
        this.weekDay = 0;
        this.yearDay = 0;
        this.isDst = -1;
        this.gmtoff = 0;
        // ---------- Original Method ----------
        //this.allDay = false;
        //this.second = second;
        //this.minute = minute;
        //this.hour = hour;
        //this.monthDay = monthDay;
        //this.month = month;
        //this.year = year;
        //this.weekDay = 0;
        //this.yearDay = 0;
        //this.isDst = -1;
        //this.gmtoff = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.131 -0400", hash_original_method = "C60C1B5EF923FFCA596CDB2EA96B61D3", hash_generated_method = "5C37DA20131AC42062F88546B8F5D88A")
    @DSModeled(DSC.SAFE)
    public void set(int monthDay, int month, int year) {
        dsTaint.addTaint(monthDay);
        dsTaint.addTaint(month);
        dsTaint.addTaint(year);
        this.allDay = true;
        this.second = 0;
        this.minute = 0;
        this.hour = 0;
        this.weekDay = 0;
        this.yearDay = 0;
        this.isDst = -1;
        this.gmtoff = 0;
        // ---------- Original Method ----------
        //this.allDay = true;
        //this.second = 0;
        //this.minute = 0;
        //this.hour = 0;
        //this.monthDay = monthDay;
        //this.month = month;
        //this.year = year;
        //this.weekDay = 0;
        //this.yearDay = 0;
        //this.isDst = -1;
        //this.gmtoff = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.131 -0400", hash_original_method = "42CA0EB350D1B07EC08DFD981A2476E6", hash_generated_method = "C451B7AAAA31FBB031BC210700922E18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean before(Time that) {
        dsTaint.addTaint(that.dsTaint);
        boolean varC26E81ABAD35C8F093F02DC197A0E2FB_2054431076 = (Time.compare(this, that) < 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return Time.compare(this, that) < 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.131 -0400", hash_original_method = "63DFD446B1AADA69AC0B8E51A8B5B261", hash_generated_method = "B43012DF0A9528543C74F1CE1411EFF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean after(Time that) {
        dsTaint.addTaint(that.dsTaint);
        boolean var6B645F28F53057B6599AC95EBD8EDDC7_1709698934 = (Time.compare(this, that) > 0);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return Time.compare(this, that) > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.131 -0400", hash_original_method = "9786C5AD526EBB88697D6E3283396468", hash_generated_method = "ADE8314274A65932672A1BBF25B3B166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getWeekNumber() {
        int closestThursday;
        closestThursday = yearDay + sThursdayOffset[weekDay];
        Time temp;
        temp = new Time(this);
        temp.monthDay += sThursdayOffset[weekDay];
        temp.normalize(true );
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int closestThursday = yearDay + sThursdayOffset[weekDay];
        //if (closestThursday >= 0 && closestThursday <= 364) {
            //return closestThursday / 7 + 1;
        //}
        //Time temp = new Time(this);
        //temp.monthDay += sThursdayOffset[weekDay];
        //temp.normalize(true );
        //return temp.yearDay / 7 + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.132 -0400", hash_original_method = "84747EB963EFC6E551D95C210645E8C0", hash_generated_method = "BB55BC9ABDD5A42206A5F82ADF893E82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String format3339(boolean allDay) {
        dsTaint.addTaint(allDay);
        {
            String var90819D654D1AB7C073D2502CA3E6008C_764556078 = (format(Y_M_D));
        } //End block
        {
            boolean varF972A1CD895F1935B0ECBECAA4C7EC41_1558406996 = (TIMEZONE_UTC.equals(timezone));
            {
                String var85770FE07A2463150796C04FB9BB3FAF_1581451051 = (format(Y_M_D_T_H_M_S_000_Z));
            } //End block
            {
                String base;
                base = format(Y_M_D_T_H_M_S_000);
                String sign;
                sign = "-";
                sign = "+";
                int offset;
                offset = (int)Math.abs(gmtoff);
                int minutes;
                minutes = (offset % 3600) / 60;
                int hours;
                hours = offset / 3600;
                String var3B11A84C2649B04ED7891684C7C41CD2_794025396 = (String.format("%s%s%02d:%02d", base, sign, hours, minutes));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (allDay) {
            //return format(Y_M_D);
        //} else if (TIMEZONE_UTC.equals(timezone)) {
            //return format(Y_M_D_T_H_M_S_000_Z);
        //} else {
            //String base = format(Y_M_D_T_H_M_S_000);
            //String sign = (gmtoff < 0) ? "-" : "+";
            //int offset = (int)Math.abs(gmtoff);
            //int minutes = (offset % 3600) / 60;
            //int hours = offset / 3600;
            //return String.format("%s%s%02d:%02d", base, sign, hours, minutes);
        //}
    }

    
        public static boolean isEpoch(Time time) {
        long millis = time.toMillis(true);
        return getJulianDay(millis, 0) == EPOCH_JULIAN_DAY;
    }

    
        public static int getJulianDay(long millis, long gmtoff) {
        long offsetMillis = gmtoff * 1000;
        long julianDay = (millis + offsetMillis) / DateUtils.DAY_IN_MILLIS;
        return (int) julianDay + EPOCH_JULIAN_DAY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:57.132 -0400", hash_original_method = "D0FEABA86A68FA32A36FDA48979CCD03", hash_generated_method = "14D01DD284A45A137ACEBD43F8800777")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long setJulianDay(int julianDay) {
        dsTaint.addTaint(julianDay);
        long millis;
        millis = (julianDay - EPOCH_JULIAN_DAY) * DateUtils.DAY_IN_MILLIS;
        set(millis);
        int approximateDay;
        approximateDay = getJulianDay(millis, gmtoff);
        int diff;
        diff = julianDay - approximateDay;
        monthDay += diff;
        hour = 0;
        minute = 0;
        second = 0;
        millis = normalize(true);
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long millis = (julianDay - EPOCH_JULIAN_DAY) * DateUtils.DAY_IN_MILLIS;
        //set(millis);
        //int approximateDay = getJulianDay(millis, gmtoff);
        //int diff = julianDay - approximateDay;
        //monthDay += diff;
        //hour = 0;
        //minute = 0;
        //second = 0;
        //millis = normalize(true);
        //return millis;
    }

    
        public static int getWeeksSinceEpochFromJulianDay(int julianDay, int firstDayOfWeek) {
        int diff = THURSDAY - firstDayOfWeek;
        if (diff < 0) {
            diff += 7;
        }
        int refDay = EPOCH_JULIAN_DAY - diff;
        return (julianDay - refDay) / 7;
    }

    
        public static int getJulianMondayFromWeeksSinceEpoch(int week) {
        return MONDAY_BEFORE_JULIAN_EPOCH + week * 7;
    }

    
    private static final String Y_M_D_T_H_M_S_000 = "%Y-%m-%dT%H:%M:%S.000";
    private static final String Y_M_D_T_H_M_S_000_Z = "%Y-%m-%dT%H:%M:%S.000Z";
    private static final String Y_M_D = "%Y-%m-%d";
    public static final String TIMEZONE_UTC = "UTC";
    public static final int EPOCH_JULIAN_DAY = 2440588;
    public static final int MONDAY_BEFORE_JULIAN_EPOCH = EPOCH_JULIAN_DAY - 3;
    public static final int SECOND = 1;
    public static final int MINUTE = 2;
    public static final int HOUR = 3;
    public static final int MONTH_DAY = 4;
    public static final int MONTH = 5;
    public static final int YEAR = 6;
    public static final int WEEK_DAY = 7;
    public static final int YEAR_DAY = 8;
    public static final int WEEK_NUM = 9;
    public static final int SUNDAY = 0;
    public static final int MONDAY = 1;
    public static final int TUESDAY = 2;
    public static final int WEDNESDAY = 3;
    public static final int THURSDAY = 4;
    public static final int FRIDAY = 5;
    public static final int SATURDAY = 6;
    private static Locale sLocale;
    private static String[] sShortMonths;
    private static String[] sLongMonths;
    private static String[] sLongStandaloneMonths;
    private static String[] sShortWeekdays;
    private static String[] sLongWeekdays;
    private static String sTimeOnlyFormat;
    private static String sDateOnlyFormat;
    private static String sDateTimeFormat;
    private static String sAm;
    private static String sPm;
    private static String sDateCommand = "%a %b %e %H:%M:%S %Z %Y";
    private static final int[] DAYS_PER_MONTH = { 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31 };
    private static final int[] sThursdayOffset = { -3, 3, 2, 1, 0, -1, -2 };
}

