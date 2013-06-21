package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.lang.IllegalArgumentException;

public class SIPDate implements Cloneable, Serializable {
    protected String sipWkDay;
    protected String sipMonth;
    protected int wkday;
    protected int day;
    protected int month;
    protected int year;
    protected int hour;
    protected int minute;
    protected int second;
    private java.util.Calendar javaCal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.259 -0400", hash_original_method = "C73CBA236E994654D9EB18CB745C41F4", hash_generated_method = "B8FAD3ED34CC8D51B2A635E7C63EE33A")
    @DSModeled(DSC.SAFE)
    public SIPDate() {
        wkday = -1;
        day = -1;
        month = -1;
        year = -1;
        hour = -1;
        minute = -1;
        second = -1;
        javaCal = null;
        // ---------- Original Method ----------
        //wkday = -1;
        //day = -1;
        //month = -1;
        //year = -1;
        //hour = -1;
        //minute = -1;
        //second = -1;
        //javaCal = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.259 -0400", hash_original_method = "7A2DC6C5A2282C24FE6927FC780CB71C", hash_generated_method = "4B127270BCC2DC387B9C378477FA8118")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPDate(long timeMillis) {
        dsTaint.addTaint(timeMillis);
        javaCal =
            new GregorianCalendar(
                TimeZone.getTimeZone("GMT:0"),
                Locale.getDefault());
        java.util.Date date;
        date = new java.util.Date(timeMillis);
        javaCal.setTime(date);
        wkday = javaCal.get(Calendar.DAY_OF_WEEK);
        //Begin case Calendar.MONDAY 
        sipWkDay = MON;
        //End case Calendar.MONDAY 
        //Begin case Calendar.TUESDAY 
        sipWkDay = TUE;
        //End case Calendar.TUESDAY 
        //Begin case Calendar.WEDNESDAY 
        sipWkDay = WED;
        //End case Calendar.WEDNESDAY 
        //Begin case Calendar.THURSDAY 
        sipWkDay = THU;
        //End case Calendar.THURSDAY 
        //Begin case Calendar.FRIDAY 
        sipWkDay = FRI;
        //End case Calendar.FRIDAY 
        //Begin case Calendar.SATURDAY 
        sipWkDay = SAT;
        //End case Calendar.SATURDAY 
        //Begin case Calendar.SUNDAY 
        sipWkDay = SUN;
        //End case Calendar.SUNDAY 
        //Begin case default 
        InternalErrorHandler.handleException(
                    "No date map for wkday " + wkday);
        //End case default 
        day = javaCal.get(Calendar.DAY_OF_MONTH);
        month = javaCal.get(Calendar.MONTH);
        //Begin case Calendar.JANUARY 
        sipMonth = JAN;
        //End case Calendar.JANUARY 
        //Begin case Calendar.FEBRUARY 
        sipMonth = FEB;
        //End case Calendar.FEBRUARY 
        //Begin case Calendar.MARCH 
        sipMonth = MAR;
        //End case Calendar.MARCH 
        //Begin case Calendar.APRIL 
        sipMonth = APR;
        //End case Calendar.APRIL 
        //Begin case Calendar.MAY 
        sipMonth = MAY;
        //End case Calendar.MAY 
        //Begin case Calendar.JUNE 
        sipMonth = JUN;
        //End case Calendar.JUNE 
        //Begin case Calendar.JULY 
        sipMonth = JUL;
        //End case Calendar.JULY 
        //Begin case Calendar.AUGUST 
        sipMonth = AUG;
        //End case Calendar.AUGUST 
        //Begin case Calendar.SEPTEMBER 
        sipMonth = SEP;
        //End case Calendar.SEPTEMBER 
        //Begin case Calendar.OCTOBER 
        sipMonth = OCT;
        //End case Calendar.OCTOBER 
        //Begin case Calendar.NOVEMBER 
        sipMonth = NOV;
        //End case Calendar.NOVEMBER 
        //Begin case Calendar.DECEMBER 
        sipMonth = DEC;
        //End case Calendar.DECEMBER 
        //Begin case default 
        InternalErrorHandler.handleException(
                    "No date map for month " + month);
        //End case default 
        year = javaCal.get(Calendar.YEAR);
        hour = javaCal.get(Calendar.HOUR_OF_DAY);
        minute = javaCal.get(Calendar.MINUTE);
        second = javaCal.get(Calendar.SECOND);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.260 -0400", hash_original_method = "17EF9A3AE37B7BA0C102396D80392A03", hash_generated_method = "6802CF8863535B7FD736FD5D658AB8AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object that) {
        dsTaint.addTaint(that.dsTaint);
        {
            boolean varB3B539D8C3F946312D0860FAE4C27571_137165616 = (that.getClass() != this.getClass());
        } //End collapsed parenthetic
        SIPDate other;
        other = (SIPDate)that;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (that.getClass() != this.getClass())return false;
        //SIPDate other = (SIPDate)that;
        //return this.wkday == other.wkday &&
        //this.day == other.day &&
        //this.month == other.month &&
        //this.year == other.year &&
        //this.hour == other.hour &&
        //this.minute == other.minute &&
        //this.second == other.second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.260 -0400", hash_original_method = "124CFAD93358C90C664BE8C1CAE8945E", hash_generated_method = "AF7B9AF961C89CDFB56F80F248C1D27E")
    @DSModeled(DSC.SAFE)
    public String encode() {
        String dayString;
        {
            dayString = "0" + day;
        } //End block
        dayString = "" + day;
        String hourString;
        {
            hourString = "0" + hour;
        } //End block
        hourString = "" + hour;
        String minuteString;
        {
            minuteString = "0" + minute;
        } //End block
        minuteString = "" + minute;
        String secondString;
        {
            secondString = "0" + second;
        } //End block
        secondString = "" + second;
        String encoding;
        encoding = "";
        encoding += sipWkDay + Separators.COMMA + Separators.SP;
        encoding += dayString + Separators.SP;
        encoding += sipMonth + Separators.SP;
        encoding += year
            + Separators.SP
            + hourString
            + Separators.COLON
            + minuteString
            + Separators.COLON
            + secondString
            + Separators.SP
            + GMT;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.260 -0400", hash_original_method = "AA358655086B2D4E31F8BC09FB299576", hash_generated_method = "42198F7B5D006AAE015141E03A209684")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public java.util.Calendar getJavaCal() {
        setJavaCal();
        return (java.util.Calendar)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (javaCal == null)
            //setJavaCal();
        //return javaCal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.261 -0400", hash_original_method = "457D7CE469867FC10EBD436F0D51643B", hash_generated_method = "8AFCF10BD7FE8C5AA09529833B11E0B0")
    @DSModeled(DSC.SAFE)
    public String getWkday() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return sipWkDay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.261 -0400", hash_original_method = "A22F3A31D7F5863E790748C0D0AB40F6", hash_generated_method = "A34F0CAC5B1DCD769D33934E7C439AF6")
    @DSModeled(DSC.SAFE)
    public String getMonth() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return sipMonth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.261 -0400", hash_original_method = "4346EB52B1E97382E292AD2394C76CAA", hash_generated_method = "0006550B4B600AA5C48BDBB8B8900CC3")
    @DSModeled(DSC.SAFE)
    public int getHour() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return hour;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.261 -0400", hash_original_method = "ADC91C6D58A75EA1079C93B22A777A18", hash_generated_method = "016025B864E8C02F1C8CA3DA3A296A3C")
    @DSModeled(DSC.SAFE)
    public int getMinute() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return minute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.261 -0400", hash_original_method = "033202145FC9480CAEE9B3FD508F85AB", hash_generated_method = "22AA441F570416CED0AE1952EB24F57B")
    @DSModeled(DSC.SAFE)
    public int getSecond() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.262 -0400", hash_original_method = "ED081120415B25517E6A51D04161FC1C", hash_generated_method = "1E8F073A63E95637A32C9CF8F3796EE2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setJavaCal() {
        javaCal =
            new GregorianCalendar(
                TimeZone.getTimeZone("GMT:0"),
                Locale.getDefault());
        javaCal.set(Calendar.YEAR, year);
        javaCal.set(Calendar.DAY_OF_MONTH, day);
        javaCal.set(Calendar.MONTH, month);
        javaCal.set(Calendar.DAY_OF_WEEK, wkday);
        javaCal.set(Calendar.HOUR, hour);
        javaCal.set(Calendar.MINUTE, minute);
        javaCal.set(Calendar.SECOND, second);
        // ---------- Original Method ----------
        //javaCal =
            //new GregorianCalendar(
                //TimeZone.getTimeZone("GMT:0"),
                //Locale.getDefault());
        //if (year != -1)
            //javaCal.set(Calendar.YEAR, year);
        //if (day != -1)
            //javaCal.set(Calendar.DAY_OF_MONTH, day);
        //if (month != -1)
            //javaCal.set(Calendar.MONTH, month);
        //if (wkday != -1)
            //javaCal.set(Calendar.DAY_OF_WEEK, wkday);
        //if (hour != -1)
            //javaCal.set(Calendar.HOUR, hour);
        //if (minute != -1)
            //javaCal.set(Calendar.MINUTE, minute);
        //if (second != -1)
            //javaCal.set(Calendar.SECOND, second);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.262 -0400", hash_original_method = "AC7B5ED74AB02B130D63CC72231A28FF", hash_generated_method = "6EA8AB267CB53EC7ED39755296DE3922")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWkday(String w) throws IllegalArgumentException {
        dsTaint.addTaint(w);
        {
            boolean var6ED753E913882A5CB5A17F96BB31B0A6_2094489370 = (sipWkDay.compareToIgnoreCase(MON) == 0);
            {
                wkday = Calendar.MONDAY;
            } //End block
            {
                boolean var2012D7772A037EB772027D6F49C169A8_1374442388 = (sipWkDay.compareToIgnoreCase(TUE) == 0);
                {
                    wkday = Calendar.TUESDAY;
                } //End block
                {
                    boolean varA1BD807959D6D772573BFE881920839F_2088550620 = (sipWkDay.compareToIgnoreCase(WED) == 0);
                    {
                        wkday = Calendar.WEDNESDAY;
                    } //End block
                    {
                        boolean varFA7F42BAF969C2FF61FE858764F5D6F1_628405986 = (sipWkDay.compareToIgnoreCase(THU) == 0);
                        {
                            wkday = Calendar.THURSDAY;
                        } //End block
                        {
                            boolean var1804DACB94F11EF7EB945F767CC6656D_649541395 = (sipWkDay.compareToIgnoreCase(FRI) == 0);
                            {
                                wkday = Calendar.FRIDAY;
                            } //End block
                            {
                                boolean var48FF9B329BA99ECAFC60F37A7EADBDEF_1500531431 = (sipWkDay.compareToIgnoreCase(SAT) == 0);
                                {
                                    wkday = Calendar.SATURDAY;
                                } //End block
                                {
                                    boolean varD2EFED95FFD4AAE7B003D22ECBE873DB_243023722 = (sipWkDay.compareToIgnoreCase(SUN) == 0);
                                    {
                                        wkday = Calendar.SUNDAY;
                                    } //End block
                                    {
                                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal Week day :" + w);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //sipWkDay = w;
        //if (sipWkDay.compareToIgnoreCase(MON) == 0) {
            //wkday = Calendar.MONDAY;
        //} else if (sipWkDay.compareToIgnoreCase(TUE) == 0) {
            //wkday = Calendar.TUESDAY;
        //} else if (sipWkDay.compareToIgnoreCase(WED) == 0) {
            //wkday = Calendar.WEDNESDAY;
        //} else if (sipWkDay.compareToIgnoreCase(THU) == 0) {
            //wkday = Calendar.THURSDAY;
        //} else if (sipWkDay.compareToIgnoreCase(FRI) == 0) {
            //wkday = Calendar.FRIDAY;
        //} else if (sipWkDay.compareToIgnoreCase(SAT) == 0) {
            //wkday = Calendar.SATURDAY;
        //} else if (sipWkDay.compareToIgnoreCase(SUN) == 0) {
            //wkday = Calendar.SUNDAY;
        //} else {
            //throw new IllegalArgumentException("Illegal Week day :" + w);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.262 -0400", hash_original_method = "79BC1DF7B5884941473DA919072706C3", hash_generated_method = "BD0AEE23A1B29AD96043C8329D5F22CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDay(int d) throws IllegalArgumentException {
        dsTaint.addTaint(d);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Illegal Day of the month " + Integer.toString(d));
        // ---------- Original Method ----------
        //if (d < 1 || d > 31)
            //throw new IllegalArgumentException(
                //"Illegal Day of the month " + Integer.toString(d));
        //day = d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.263 -0400", hash_original_method = "F81F66CB2E9CA66D72BD9964B3A16CCB", hash_generated_method = "CD10F0D5CD32A307AD851676C9F0E0FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMonth(String m) throws IllegalArgumentException {
        dsTaint.addTaint(m);
        {
            boolean varC022F0018F901E6DAB885B39121F4580_261219704 = (sipMonth.compareToIgnoreCase(JAN) == 0);
            {
                month = Calendar.JANUARY;
            } //End block
            {
                boolean var31A64FD55A1B5D1B7CF6897AB51072F5_16409139 = (sipMonth.compareToIgnoreCase(FEB) == 0);
                {
                    month = Calendar.FEBRUARY;
                } //End block
                {
                    boolean var0DB25484EE9B6AD8C1134362CF737A2E_1923788991 = (sipMonth.compareToIgnoreCase(MAR) == 0);
                    {
                        month = Calendar.MARCH;
                    } //End block
                    {
                        boolean var5F174F8072EC669E20A1A01DEA6B1985_350701580 = (sipMonth.compareToIgnoreCase(APR) == 0);
                        {
                            month = Calendar.APRIL;
                        } //End block
                        {
                            boolean varD7A0FA753B2140C85E88DFA1F1F7B14D_1368722574 = (sipMonth.compareToIgnoreCase(MAY) == 0);
                            {
                                month = Calendar.MAY;
                            } //End block
                            {
                                boolean varDACD1A4A13B2891E0D88136EC09F384E_864169065 = (sipMonth.compareToIgnoreCase(JUN) == 0);
                                {
                                    month = Calendar.JUNE;
                                } //End block
                                {
                                    boolean var146A169FDCAE1BA81F6CACF1D13ADA93_1003712494 = (sipMonth.compareToIgnoreCase(JUL) == 0);
                                    {
                                        month = Calendar.JULY;
                                    } //End block
                                    {
                                        boolean varA68A971E0705CA224E5442C417C85C4C_1274827481 = (sipMonth.compareToIgnoreCase(AUG) == 0);
                                        {
                                            month = Calendar.AUGUST;
                                        } //End block
                                        {
                                            boolean var944745D5A476951E51B0776778865417_570184577 = (sipMonth.compareToIgnoreCase(SEP) == 0);
                                            {
                                                month = Calendar.SEPTEMBER;
                                            } //End block
                                            {
                                                boolean var803B4F0EAD50203BF988F4C12598B552_1043755638 = (sipMonth.compareToIgnoreCase(OCT) == 0);
                                                {
                                                    month = Calendar.OCTOBER;
                                                } //End block
                                                {
                                                    boolean var218B7B8D121FACB72CC9D957B671F2AE_1209110459 = (sipMonth.compareToIgnoreCase(NOV) == 0);
                                                    {
                                                        month = Calendar.NOVEMBER;
                                                    } //End block
                                                    {
                                                        boolean var80F451C929B849E912728C9A9EABCA68_199677286 = (sipMonth.compareToIgnoreCase(DEC) == 0);
                                                        {
                                                            month = Calendar.DECEMBER;
                                                        } //End block
                                                        {
                                                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal Month :" + m);
                                                        } //End block
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.263 -0400", hash_original_method = "65E0B59727307B53E2290DE9B41E88A5", hash_generated_method = "640D4832918E9F38DE2F68F91FA814B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setYear(int y) throws IllegalArgumentException {
        dsTaint.addTaint(y);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal year : " + y);
        javaCal = null;
        // ---------- Original Method ----------
        //if (y < 0)
            //throw new IllegalArgumentException("Illegal year : " + y);
        //javaCal = null;
        //year = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.263 -0400", hash_original_method = "685E9F12E07BC44AEFABA3E87A7BA88C", hash_generated_method = "952E31F05ECFE525517F2D0B8ED52C5B")
    @DSModeled(DSC.SAFE)
    public int getYear() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return year;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.264 -0400", hash_original_method = "8F41240A07063AF12A20DAC696350061", hash_generated_method = "3789A3FBA47D4F66723E8000FBEFD02C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHour(int h) throws IllegalArgumentException {
        dsTaint.addTaint(h);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal hour : " + h);
        javaCal = null;
        // ---------- Original Method ----------
        //if (h < 0 || h > 24)
            //throw new IllegalArgumentException("Illegal hour : " + h);
        //javaCal = null;
        //hour = h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.264 -0400", hash_original_method = "0A40A5D1C091DEF2AA14C093CC6460BC", hash_generated_method = "3FC8AB1594845931745F3BA7AABDCBCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMinute(int m) throws IllegalArgumentException {
        dsTaint.addTaint(m);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Illegal minute : " + (Integer.toString(m)));
        javaCal = null;
        // ---------- Original Method ----------
        //if (m < 0 || m >= 60)
            //throw new IllegalArgumentException(
                //"Illegal minute : " + (Integer.toString(m)));
        //javaCal = null;
        //minute = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.264 -0400", hash_original_method = "2AD3B3771A5FA25E5792A620A7EA9BAA", hash_generated_method = "88FADF727827D09833319732A996846C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSecond(int s) throws IllegalArgumentException {
        dsTaint.addTaint(s);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Illegal second : " + Integer.toString(s));
        javaCal = null;
        // ---------- Original Method ----------
        //if (s < 0 || s >= 60)
            //throw new IllegalArgumentException(
                //"Illegal second : " + Integer.toString(s));
        //javaCal = null;
        //second = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.264 -0400", hash_original_method = "2F4F469E30C2F586A40940F33F0E1586", hash_generated_method = "0AB859FC9A237C8CFFAA29CA98C019F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDeltaSeconds() {
        long ctime;
        ctime = this.getJavaCal().getTime().getTime();
        int var564E041B7CDDC5ADD7BEB915CCCDE394_289213279 = ((int) (ctime - System.currentTimeMillis()) / 1000);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //long ctime = this.getJavaCal().getTime().getTime();
        //return (int) (ctime - System.currentTimeMillis()) / 1000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.265 -0400", hash_original_method = "4BA050DE2121A2990466253CFC8AD778", hash_generated_method = "5A6C717F115A0EBB90E26A1ADB7B7B08")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SIPDate retval;
        try 
        {
            retval = (SIPDate) super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Internal error");
        } //End block
        retval.javaCal = (java.util.Calendar) javaCal.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SIPDate retval;
        //try {
            //retval = (SIPDate) super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new RuntimeException("Internal error");
        //}
        //if (javaCal != null)
            //retval.javaCal = (java.util.Calendar) javaCal.clone();
        //return retval;
    }

    
    private static final long serialVersionUID = 8544101899928346909L;
    public static final String GMT = "GMT";
    public static final String MON = "Mon";
    public static final String TUE = "Tue";
    public static final String WED = "Wed";
    public static final String THU = "Thu";
    public static final String FRI = "Fri";
    public static final String SAT = "Sat";
    public static final String SUN = "Sun";
    public static final String JAN = "Jan";
    public static final String FEB = "Feb";
    public static final String MAR = "Mar";
    public static final String APR = "Apr";
    public static final String MAY = "May";
    public static final String JUN = "Jun";
    public static final String JUL = "Jul";
    public static final String AUG = "Aug";
    public static final String SEP = "Sep";
    public static final String OCT = "Oct";
    public static final String NOV = "Nov";
    public static final String DEC = "Dec";
}

