package android.text.format;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.Resources;
import android.graphics.BitmapFactory;

import java.util.Locale;
import java.util.TimeZone;

public class Time {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.824 -0400", hash_original_field = "3768C7D722E20F8162E6651DD2082773", hash_generated_field = "9B333262C59ACAF4662993E0381B186B")

    public boolean allDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.824 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "26A3892DE5720DF4430FA2DBFDE4FF62")

    public int second;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.824 -0400", hash_original_field = "0A7D55BE9D12A369A6A8DA0FB517FBA4", hash_generated_field = "455B65DB16084F27D41C85247D5F2D46")

    public int minute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.824 -0400", hash_original_field = "896C55CC5E46FAB38CE9F51EBF7BFCD3", hash_generated_field = "60957A9D10A9EBFF70AB0506CE8D72D3")

    public int hour;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.824 -0400", hash_original_field = "362DA3474D59B18F0B319E1CB97DCB8B", hash_generated_field = "0D8CCE169482BCBB0FA5CD710145A28F")

    public int monthDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.824 -0400", hash_original_field = "7436F942D5EA836CB84F1BB2527D8286", hash_generated_field = "0230F059D3F4D4B04ED8DF3526CB7866")

    public int month;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.824 -0400", hash_original_field = "84CDC76CABF41BD7C961F6AB12F117D8", hash_generated_field = "262796C768431713D9A766C22E1203FB")

    public int year;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.824 -0400", hash_original_field = "9D50154D1DEC76B8EAC4871EB3EC432C", hash_generated_field = "A89A7B58B286334824EC64B00634216D")

    public int weekDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.824 -0400", hash_original_field = "DA4428D1AB4D220D273F0A4116055EB0", hash_generated_field = "A5C458E466E7DA8146F10E83C68D95FA")

    public int yearDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.825 -0400", hash_original_field = "69558E82D219E356100D56AAE8102731", hash_generated_field = "C8977C2FF5A43A716AE2D045D6EB6CF6")

    public int isDst;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.825 -0400", hash_original_field = "5E5D565DFF33884C016578890020EA8B", hash_generated_field = "5C20967D8EBD6408D4E1A635480B5B75")

    public long gmtoff;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.825 -0400", hash_original_field = "B2C6CC48F97CCD71B16D31D88FC177A6", hash_generated_field = "3B69EE778051333E277A9B76EADD3A80")

    public String timezone;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.825 -0400", hash_original_method = "E0FCF5C2DD1FC8B8CECA3F88CA26F2FA", hash_generated_method = "D2E1441343AA64E881C1AE7079837893")
    public  Time(String timezone) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("timezone is null!");
        } //End block
        this.timezone = timezone;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.825 -0400", hash_original_method = "B143F86B302A5932C8EBD6FB2BD46478", hash_generated_method = "D523B0EECDBAE13FC752EA1B886457F7")
    public  Time() {
        this(TimeZone.getDefault().getID());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.825 -0400", hash_original_method = "5882A59C3CCF918AE2BB2D84CAA18E36", hash_generated_method = "54024E40A88730DEB0F0E7DA938BE806")
    public  Time(Time other) {
        set(other);
        addTaint(other.getTaint());
        // ---------- Original Method ----------
        //set(other);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.826 -0400", hash_original_method = "7DE92E5F5A39A244E977EE497A88E369", hash_generated_method = "230C11CA4ABABF5FBBACEB49AB241BDF")
    public long normalize(boolean ignoreDst) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1147118568 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1147118568;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.826 -0400", hash_original_method = "13E8DE21AE4CB3AA83156EE3A5950ED3", hash_generated_method = "D76B3D1C69C48ED15F43AFBE3183BFB6")
    public void switchTimezone(String timezone) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.826 -0400", hash_original_method = "DF789B90859E8F04F5333F3487A99DFB", hash_generated_method = "4581A857B474CDED6869C1396702CA24")
    public int getActualMaximum(int field) {
        //Begin case MONTH_DAY 
        {
            int n = DAYS_PER_MONTH[this.month];
            {
                int y = this.year;
            } //End block
        } //End block
        //End case MONTH_DAY 
        //Begin case YEAR_DAY 
        {
            int y = this.year;
        } //End block
        //End case YEAR_DAY 
        //Begin case WEEK_NUM 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("WEEK_NUM not implemented");
        //End case WEEK_NUM 
        //Begin case default 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("bad field=" + field);
        //End case default 
        addTaint(field);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881880873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1881880873;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.827 -0400", hash_original_method = "CE0E4353FCA63B39E00F0F1C4B7BFC83", hash_generated_method = "DC8D8BA0B224731EA875C97FB239D8D9")
    public void clear(String timezone) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("timezone is null!");
        } //End block
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
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450183953 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450183953;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.830 -0400", hash_original_method = "2DA36736B256CECB86984D41B76F2A40", hash_generated_method = "7BF16B46ECF61C2EF7B175EBD95CD7F7")
    public String format(String format) {
        String varB4EAC82CA7396A68D541C85D26508E83_383461281 = null; //Variable for return #1
        {
            Locale locale = Locale.getDefault();
            {
                boolean var986A7EABE77A45251BA68D07070DB5A1_1739350948 = (sLocale == null || locale == null || !(locale.equals(sLocale)));
                {
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
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_383461281 = format1(format);
        } //End block
        addTaint(format.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_383461281.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_383461281;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.831 -0400", hash_original_method = "412A6EFDB33A9BCE94A5C52880803E0F", hash_generated_method = "04A076EA46277769A12E4BC81D9837E5")
    public boolean parse(String s) {
        {
            boolean varB489FB41A585FE2A62DA4FB42B18FDCC_1198443038 = (nativeParse(s));
            {
                timezone = TIMEZONE_UTC;
            } //End block
        } //End collapsed parenthetic
        addTaint(s.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104041540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104041540;
        // ---------- Original Method ----------
        //if (nativeParse(s)) {
            //timezone = TIMEZONE_UTC;
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.832 -0400", hash_original_method = "715F84C962A7921497F55D5349A2140A", hash_generated_method = "545CA5371FA20D66D4D12AD6DD91B7E9")
    private boolean nativeParse(String s) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_781189062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_781189062;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.832 -0400", hash_original_method = "E417695E8CAC19265A6537D747474825", hash_generated_method = "A883EE3DD1AD919C157B7378A2334207")
    public boolean parse3339(String s) {
        {
            boolean var85DE61D4D5D74B9595714ACEED12BD09_785205190 = (nativeParse3339(s));
            {
                timezone = TIMEZONE_UTC;
            } //End block
        } //End collapsed parenthetic
        addTaint(s.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1233816719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1233816719;
        // ---------- Original Method ----------
        //if (nativeParse3339(s)) {
             //timezone = TIMEZONE_UTC;
             //return true;
         //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.832 -0400", hash_original_method = "57499E6D502331FE1EE9DA37E2D15CA3", hash_generated_method = "A684D31353A00752FFF90B6CEA663DEA")
    private boolean nativeParse3339(String s) {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_520263965 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_520263965;
    }

    
    public static String getCurrentTimezone() {
        return TimeZone.getDefault().getID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.833 -0400", hash_original_method = "6CDA1CA0525F04C652EDF79AA26F0E90", hash_generated_method = "0DE05A8FA6CB506B4E2313C7C1218631")
    public void setToNow() {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.833 -0400", hash_original_method = "C1956449864825DE1FCC969EAC519409", hash_generated_method = "0BC38B542EDC4C3F2E36E00C8F60CFA8")
    public long toMillis(boolean ignoreDst) {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_416694944 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_416694944;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.833 -0400", hash_original_method = "934B6518FEFEB3D5C2DEFA32BEB78382", hash_generated_method = "8657361F6180A2504388BAF20D08B3C7")
    public void set(long millis) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.834 -0400", hash_original_method = "41A869EF339B8E1FD69184435BC2AFF4", hash_generated_method = "80016ED483EF4736E85C065EFF5B1D3A")
    public String format2445() {
    	String s = new String();
    	s.addTaint(taint);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.834 -0400", hash_original_method = "F960E973DC6F4E791CEC3120624756A7", hash_generated_method = "F3630183AFFC264D42CFEAC437A98BBF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.835 -0400", hash_original_method = "667ED0F0E30647AFF648664194B11038", hash_generated_method = "92D1427CCBADBE4F26EBE19367B4E729")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.835 -0400", hash_original_method = "C60C1B5EF923FFCA596CDB2EA96B61D3", hash_generated_method = "EAC3BE484C3CAD4661E56F149A905065")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.835 -0400", hash_original_method = "42CA0EB350D1B07EC08DFD981A2476E6", hash_generated_method = "09B2DDA557C68AAB77AC7E75AF28AF70")
    public boolean before(Time that) {
        boolean varC26E81ABAD35C8F093F02DC197A0E2FB_1617838694 = (Time.compare(this, that) < 0);
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1308614233 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1308614233;
        // ---------- Original Method ----------
        //return Time.compare(this, that) < 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.836 -0400", hash_original_method = "63DFD446B1AADA69AC0B8E51A8B5B261", hash_generated_method = "46F69E969707511AD713EB2CD89B52E7")
    public boolean after(Time that) {
        boolean var6B645F28F53057B6599AC95EBD8EDDC7_1586680401 = (Time.compare(this, that) > 0);
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1433661539 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1433661539;
        // ---------- Original Method ----------
        //return Time.compare(this, that) > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.836 -0400", hash_original_method = "9786C5AD526EBB88697D6E3283396468", hash_generated_method = "E217115329F684DD7FFE79B307F937C4")
    public int getWeekNumber() {
        int closestThursday = yearDay + sThursdayOffset[weekDay];
        Time temp = new Time(this);
        temp.monthDay += sThursdayOffset[weekDay];
        temp.normalize(true );
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2119138449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2119138449;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.837 -0400", hash_original_method = "84747EB963EFC6E551D95C210645E8C0", hash_generated_method = "F29205BCE46D0109765D5BE1188210AD")
    public String format3339(boolean allDay) {
        String varB4EAC82CA7396A68D541C85D26508E83_555938507 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_424019355 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1032274872 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_555938507 = format(Y_M_D);
        } //End block
        {
            boolean varF972A1CD895F1935B0ECBECAA4C7EC41_1889597959 = (TIMEZONE_UTC.equals(timezone));
            {
                varB4EAC82CA7396A68D541C85D26508E83_424019355 = format(Y_M_D_T_H_M_S_000_Z);
            } //End block
            {
                String base = format(Y_M_D_T_H_M_S_000);
                String sign;
                sign = "-";
                sign = "+";
                int offset = (int)Math.abs(gmtoff);
                int minutes = (offset % 3600) / 60;
                int hours = offset / 3600;
                varB4EAC82CA7396A68D541C85D26508E83_1032274872 = String.format("%s%s%02d:%02d", base, sign, hours, minutes);
            } //End block
        } //End collapsed parenthetic
        addTaint(allDay);
        String varA7E53CE21691AB073D9660D615818899_1452138976; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1452138976 = varB4EAC82CA7396A68D541C85D26508E83_555938507;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1452138976 = varB4EAC82CA7396A68D541C85D26508E83_424019355;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1452138976 = varB4EAC82CA7396A68D541C85D26508E83_1032274872;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1452138976.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1452138976;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.838 -0400", hash_original_method = "D0FEABA86A68FA32A36FDA48979CCD03", hash_generated_method = "D532C2F489A9B3E82E3F958CC61C753F")
    public long setJulianDay(int julianDay) {
        long millis = (julianDay - EPOCH_JULIAN_DAY) * DateUtils.DAY_IN_MILLIS;
        set(millis);
        int approximateDay = getJulianDay(millis, gmtoff);
        int diff = julianDay - approximateDay;
        monthDay += diff;
        hour = 0;
        minute = 0;
        second = 0;
        millis = normalize(true);
        addTaint(julianDay);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_990026890 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_990026890;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.839 -0400", hash_original_field = "A5BD93C1F671A002C00B6D12920C44F3", hash_generated_field = "802872930A389D11D7EB611619410907")

    private static final String Y_M_D_T_H_M_S_000 = "%Y-%m-%dT%H:%M:%S.000";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.839 -0400", hash_original_field = "C5196B84D1FBF318BECF9EC6B32C953B", hash_generated_field = "F2587797ED5FCC288039F472A44FF8DF")

    private static final String Y_M_D_T_H_M_S_000_Z = "%Y-%m-%dT%H:%M:%S.000Z";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.839 -0400", hash_original_field = "D0B67A7E1FF3895E491051BD31BA8127", hash_generated_field = "CE9712E85C8167032E58AF870E4AC065")

    private static final String Y_M_D = "%Y-%m-%d";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.839 -0400", hash_original_field = "CAC63921756CCD8678C96C83755DFCF2", hash_generated_field = "448FF7C314ECEAD51910DBE6ACEDCDB5")

    public static final String TIMEZONE_UTC = "UTC";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "7584035EE9B6DA12C3BDB2534F1BC073", hash_generated_field = "979BA9E17F757813AD1F7415B808BB0C")

    public static final int EPOCH_JULIAN_DAY = 2440588;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "7A71239F90E5C8D72C0A974C8D0C3800", hash_generated_field = "A7D9C1300EE29A3CDE02A8EECF9723D6")

    public static final int MONDAY_BEFORE_JULIAN_EPOCH = EPOCH_JULIAN_DAY - 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "0B1E4E2DAA2A8B598BEEB28949861126", hash_generated_field = "7FF4F0346D35D6C7C8B8BCC5519DE964")

    public static final int SECOND = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "B2DA2C562345AB2FB0EF2D3F4AA2D9EE", hash_generated_field = "D0EB317712B94EA17EDF8EC80DCF85DB")

    public static final int MINUTE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "9FCA47E4BC4CA385C23CA89037BFE0F4", hash_generated_field = "A9E692DAB7440DC6EB0D7F4DD2D7375E")

    public static final int HOUR = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "2E9A87AB441092FBAA00F54583BA79AC", hash_generated_field = "489C40FE157D5F22714A4E9936E2FEF9")

    public static final int MONTH_DAY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "2E1C4BF71AD1AE33E02635D6F4F68E0F", hash_generated_field = "0E6F1A978C703C9F706BC42E33AED3B6")

    public static final int MONTH = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "A9D369A0F6AE9245635B3AF2165175C0", hash_generated_field = "095BB4D2F66C929D527B4FEA7AFDE434")

    public static final int YEAR = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "4D5A444E11BFD4C716F3513A11AE5D93", hash_generated_field = "644B9E0E7BB470630B3F7074481A1661")

    public static final int WEEK_DAY = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "4FB80CA386781A32B048A96792DD9DF6", hash_generated_field = "D424E291AD7674530D2A22060204690D")

    public static final int YEAR_DAY = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "CE36DCB48C2D58A48BA5FC27319996E6", hash_generated_field = "0CE17F6EE54DD1C54BC1AC6939F0B86B")

    public static final int WEEK_NUM = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "0F5FF2757768366C3E05021A31CCC6EE", hash_generated_field = "36AE026E6127E76EA1E3630F36493111")

    public static final int SUNDAY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "57D6D97CF5750008207B6E5B2AE4B908", hash_generated_field = "DBFAE43E90D9723C40B3BB19C4831A6F")

    public static final int MONDAY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "9798D5EDF6A221B3F6316AC065945145", hash_generated_field = "0AF5A39C736FD970539D13FECC07F642")

    public static final int TUESDAY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "5B5EFBB44A383C98EEA26F6DF660FFDB", hash_generated_field = "BFE153BB36785196E448AA0629AF5098")

    public static final int WEDNESDAY = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "6CC2D3936A3E7EA58DA73F3B492C2303", hash_generated_field = "F84C1880084ECF6559A8D1789EE9E462")

    public static final int THURSDAY = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "2DF42A38943F7B9A34CEAAEDAF0A5A97", hash_generated_field = "7463C16A7E71971D61BDA2D5A24C098B")

    public static final int FRIDAY = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "250D160CDB43B291D036C7D199C7E8D6", hash_generated_field = "E997F6B4D53FE6A93D9DBC1991F97475")

    public static final int SATURDAY = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "2EDA948D4DA5C99A89B49D9CAD8012C5", hash_generated_field = "3DB7C9A03487D4317932026B0B75600E")

    private static Locale sLocale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "F7DAE311FEB0B301694C997EBC42BD01", hash_generated_field = "0EA7D12DBAF1FF850CC67ACF8DFDF8EF")

    private static String[] sShortMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "A6B711C0A877AA56B2DD774199653272", hash_generated_field = "956EA71F943BA7163DF13EFC9EF5F36D")

    private static String[] sLongMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "841C1095549324851047596E23AE0750", hash_generated_field = "3123B9CC7541D84227EA87717D65FAA1")

    private static String[] sLongStandaloneMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "8469A963BC1483C96DFA798D617F66E0", hash_generated_field = "2DC83AEE31236F07C8D5F903FEDACD55")

    private static String[] sShortWeekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "2A8FBFF637B39F175D4A08795387A0BF", hash_generated_field = "541B609CC12419AD123C2B65C675E1AD")

    private static String[] sLongWeekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.840 -0400", hash_original_field = "2AAC4E0C41EE5AFFF3C4328FB70EA1F8", hash_generated_field = "8F436CFB23F48A022279E854E7B6D1C2")

    private static String sTimeOnlyFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.841 -0400", hash_original_field = "7B2ADBE64105E4B3D4421369805FFFE0", hash_generated_field = "1EA7F4605A70A3B15EEDC849C141F108")

    private static String sDateOnlyFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.841 -0400", hash_original_field = "0822DE42928974378E32F94D50A4CF64", hash_generated_field = "936F4B1ED85D1E8F390302A602CF23FA")

    private static String sDateTimeFormat;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.841 -0400", hash_original_field = "13F4FE096843D182583A50993D915DDD", hash_generated_field = "B48A1A193AAD9526CBE9E1FCAA96057D")

    private static String sAm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.841 -0400", hash_original_field = "8C8FF3E161284A6FC5FB3ADAE5717709", hash_generated_field = "05937CAA819E1FE81EB88395748387A8")

    private static String sPm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.841 -0400", hash_original_field = "805F0E28739A431198255CE2E307BB1A", hash_generated_field = "3ADD89E952ECF0F0D214DD51E2FB944E")

    private static String sDateCommand = "%a %b %e %H:%M:%S %Z %Y";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.841 -0400", hash_original_field = "564D6487C74DFCA397C1E519C033FE6D", hash_generated_field = "C556B2A442B943AEC4D04E626AB106F8")

    private static final int[] DAYS_PER_MONTH = { 31, 28, 31, 30, 31, 30, 31,
            31, 30, 31, 30, 31 };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:50.841 -0400", hash_original_field = "88C7A55EB40D132CBA85124B9C9B9635", hash_generated_field = "90DD57B3997497DA0FBDC833C844F416")

    private static final int[] sThursdayOffset = { -3, 3, 2, 1, 0, -1, -2 };
}

