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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.961 -0400", hash_original_field = "717AAECF4D718C53F4246C571B5CAE89", hash_generated_field = "2BD9D52B8925416FAD31A17813ACA6C8")

    protected String sipWkDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.961 -0400", hash_original_field = "E23A549557EC421F126860CDF6AF3E27", hash_generated_field = "A80823C4CD33F3F3AF953060F7AED1B1")

    protected String sipMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.961 -0400", hash_original_field = "DCDCC83A4B23617019C9F14EA7F5BC77", hash_generated_field = "596F87319AF1E1308C1EB0CCEED33A9B")

    protected int wkday;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.961 -0400", hash_original_field = "628B7DB04235F228D40ADC671413A8C8", hash_generated_field = "B2F58CEAE0DE7FF9484606598C0B67F1")

    protected int day;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.961 -0400", hash_original_field = "7436F942D5EA836CB84F1BB2527D8286", hash_generated_field = "2F8C5F97A36CC740C18AB87771CBAEAF")

    protected int month;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.962 -0400", hash_original_field = "84CDC76CABF41BD7C961F6AB12F117D8", hash_generated_field = "3748125DBF788D9E5C4BD7C78EC4D962")

    protected int year;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.962 -0400", hash_original_field = "896C55CC5E46FAB38CE9F51EBF7BFCD3", hash_generated_field = "BF1D48E6FF386AD255CBE290B36EF4AB")

    protected int hour;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.962 -0400", hash_original_field = "0A7D55BE9D12A369A6A8DA0FB517FBA4", hash_generated_field = "59841BABE93C0194E018D6000A755537")

    protected int minute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.964 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "B5AC3CA74A56A5C24E7CCD8912B6592B")

    protected int second;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.964 -0400", hash_original_field = "F7ED2965F033A6E702D82C1AEC8D0C79", hash_generated_field = "A3E3EEB6FF939AF7B2782A68BB29796C")

    private java.util.Calendar javaCal;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.965 -0400", hash_original_method = "C73CBA236E994654D9EB18CB745C41F4", hash_generated_method = "B8FAD3ED34CC8D51B2A635E7C63EE33A")
    public  SIPDate() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.996 -0400", hash_original_method = "7A2DC6C5A2282C24FE6927FC780CB71C", hash_generated_method = "9C033264CE45A6790F2A3C6251F4F2DE")
    public  SIPDate(long timeMillis) {
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
        addTaint(timeMillis);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.996 -0400", hash_original_method = "17EF9A3AE37B7BA0C102396D80392A03", hash_generated_method = "0935685723D2BDE6091F5830766097EF")
    public boolean equals(Object that) {
        {
            boolean varB3B539D8C3F946312D0860FAE4C27571_1478248675 = (that.getClass() != this.getClass());
        } //End collapsed parenthetic
        SIPDate other;
        other = (SIPDate)that;
        addTaint(that.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_220626551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_220626551;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.998 -0400", hash_original_method = "124CFAD93358C90C664BE8C1CAE8945E", hash_generated_method = "83A7A1F4F53EB3EF627A70A67C32B067")
    public String encode() {
        String varB4EAC82CA7396A68D541C85D26508E83_170015158 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_170015158 = encoding;
        varB4EAC82CA7396A68D541C85D26508E83_170015158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_170015158;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.998 -0400", hash_original_method = "AA358655086B2D4E31F8BC09FB299576", hash_generated_method = "DA8388E9798D8D6A0B17A76A76C912E3")
    public java.util.Calendar getJavaCal() {
        java.util.Calendar varB4EAC82CA7396A68D541C85D26508E83_658933466 = null; //Variable for return #1
        setJavaCal();
        varB4EAC82CA7396A68D541C85D26508E83_658933466 = javaCal;
        varB4EAC82CA7396A68D541C85D26508E83_658933466.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658933466;
        // ---------- Original Method ----------
        //if (javaCal == null)
            //setJavaCal();
        //return javaCal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.999 -0400", hash_original_method = "457D7CE469867FC10EBD436F0D51643B", hash_generated_method = "02E4AE6866ED8CFA5EEFE73990DB1ACE")
    public String getWkday() {
        String varB4EAC82CA7396A68D541C85D26508E83_1807325879 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1807325879 = sipWkDay;
        varB4EAC82CA7396A68D541C85D26508E83_1807325879.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1807325879;
        // ---------- Original Method ----------
        //return sipWkDay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.999 -0400", hash_original_method = "A22F3A31D7F5863E790748C0D0AB40F6", hash_generated_method = "1996128B81172F11F915FCBBA7D2D667")
    public String getMonth() {
        String varB4EAC82CA7396A68D541C85D26508E83_1260013028 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1260013028 = sipMonth;
        varB4EAC82CA7396A68D541C85D26508E83_1260013028.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1260013028;
        // ---------- Original Method ----------
        //return sipMonth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.999 -0400", hash_original_method = "4346EB52B1E97382E292AD2394C76CAA", hash_generated_method = "A5CFBC02E766594779CFE5E13895B412")
    public int getHour() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_506601748 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_506601748;
        // ---------- Original Method ----------
        //return hour;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.000 -0400", hash_original_method = "ADC91C6D58A75EA1079C93B22A777A18", hash_generated_method = "EF585F25A357AF7BB752EC83E93D7EF8")
    public int getMinute() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389326109 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_389326109;
        // ---------- Original Method ----------
        //return minute;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.001 -0400", hash_original_method = "033202145FC9480CAEE9B3FD508F85AB", hash_generated_method = "DC58ADF4CE627842B378B0330AF99C61")
    public int getSecond() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499734997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499734997;
        // ---------- Original Method ----------
        //return second;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.005 -0400", hash_original_method = "ED081120415B25517E6A51D04161FC1C", hash_generated_method = "1E8F073A63E95637A32C9CF8F3796EE2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.006 -0400", hash_original_method = "AC7B5ED74AB02B130D63CC72231A28FF", hash_generated_method = "BCCCBF2C610173D1C6BC4EEE3FC0D174")
    public void setWkday(String w) throws IllegalArgumentException {
        sipWkDay = w;
        {
            boolean var6ED753E913882A5CB5A17F96BB31B0A6_1160450868 = (sipWkDay.compareToIgnoreCase(MON) == 0);
            {
                wkday = Calendar.MONDAY;
            } //End block
            {
                boolean var2012D7772A037EB772027D6F49C169A8_730304191 = (sipWkDay.compareToIgnoreCase(TUE) == 0);
                {
                    wkday = Calendar.TUESDAY;
                } //End block
                {
                    boolean varA1BD807959D6D772573BFE881920839F_1934629676 = (sipWkDay.compareToIgnoreCase(WED) == 0);
                    {
                        wkday = Calendar.WEDNESDAY;
                    } //End block
                    {
                        boolean varFA7F42BAF969C2FF61FE858764F5D6F1_1613733507 = (sipWkDay.compareToIgnoreCase(THU) == 0);
                        {
                            wkday = Calendar.THURSDAY;
                        } //End block
                        {
                            boolean var1804DACB94F11EF7EB945F767CC6656D_871417674 = (sipWkDay.compareToIgnoreCase(FRI) == 0);
                            {
                                wkday = Calendar.FRIDAY;
                            } //End block
                            {
                                boolean var48FF9B329BA99ECAFC60F37A7EADBDEF_426042672 = (sipWkDay.compareToIgnoreCase(SAT) == 0);
                                {
                                    wkday = Calendar.SATURDAY;
                                } //End block
                                {
                                    boolean varD2EFED95FFD4AAE7B003D22ECBE873DB_398707180 = (sipWkDay.compareToIgnoreCase(SUN) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.006 -0400", hash_original_method = "79BC1DF7B5884941473DA919072706C3", hash_generated_method = "3623FEC32BD10FD77788FB471AD655EF")
    public void setDay(int d) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Illegal Day of the month " + Integer.toString(d));
        day = d;
        // ---------- Original Method ----------
        //if (d < 1 || d > 31)
            //throw new IllegalArgumentException(
                //"Illegal Day of the month " + Integer.toString(d));
        //day = d;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.011 -0400", hash_original_method = "F81F66CB2E9CA66D72BD9964B3A16CCB", hash_generated_method = "174590ECAE4FAFE4F84D3B2BDAA05350")
    public void setMonth(String m) throws IllegalArgumentException {
        sipMonth = m;
        {
            boolean varC022F0018F901E6DAB885B39121F4580_1159629096 = (sipMonth.compareToIgnoreCase(JAN) == 0);
            {
                month = Calendar.JANUARY;
            } //End block
            {
                boolean var31A64FD55A1B5D1B7CF6897AB51072F5_466948829 = (sipMonth.compareToIgnoreCase(FEB) == 0);
                {
                    month = Calendar.FEBRUARY;
                } //End block
                {
                    boolean var0DB25484EE9B6AD8C1134362CF737A2E_906909407 = (sipMonth.compareToIgnoreCase(MAR) == 0);
                    {
                        month = Calendar.MARCH;
                    } //End block
                    {
                        boolean var5F174F8072EC669E20A1A01DEA6B1985_423595336 = (sipMonth.compareToIgnoreCase(APR) == 0);
                        {
                            month = Calendar.APRIL;
                        } //End block
                        {
                            boolean varD7A0FA753B2140C85E88DFA1F1F7B14D_807520049 = (sipMonth.compareToIgnoreCase(MAY) == 0);
                            {
                                month = Calendar.MAY;
                            } //End block
                            {
                                boolean varDACD1A4A13B2891E0D88136EC09F384E_1093286772 = (sipMonth.compareToIgnoreCase(JUN) == 0);
                                {
                                    month = Calendar.JUNE;
                                } //End block
                                {
                                    boolean var146A169FDCAE1BA81F6CACF1D13ADA93_1446124152 = (sipMonth.compareToIgnoreCase(JUL) == 0);
                                    {
                                        month = Calendar.JULY;
                                    } //End block
                                    {
                                        boolean varA68A971E0705CA224E5442C417C85C4C_1875089156 = (sipMonth.compareToIgnoreCase(AUG) == 0);
                                        {
                                            month = Calendar.AUGUST;
                                        } //End block
                                        {
                                            boolean var944745D5A476951E51B0776778865417_2062469972 = (sipMonth.compareToIgnoreCase(SEP) == 0);
                                            {
                                                month = Calendar.SEPTEMBER;
                                            } //End block
                                            {
                                                boolean var803B4F0EAD50203BF988F4C12598B552_83342725 = (sipMonth.compareToIgnoreCase(OCT) == 0);
                                                {
                                                    month = Calendar.OCTOBER;
                                                } //End block
                                                {
                                                    boolean var218B7B8D121FACB72CC9D957B671F2AE_1534319242 = (sipMonth.compareToIgnoreCase(NOV) == 0);
                                                    {
                                                        month = Calendar.NOVEMBER;
                                                    } //End block
                                                    {
                                                        boolean var80F451C929B849E912728C9A9EABCA68_840596385 = (sipMonth.compareToIgnoreCase(DEC) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.018 -0400", hash_original_method = "65E0B59727307B53E2290DE9B41E88A5", hash_generated_method = "DFC30F2AAC0950795C80DEAC2DDF0833")
    public void setYear(int y) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal year : " + y);
        javaCal = null;
        year = y;
        // ---------- Original Method ----------
        //if (y < 0)
            //throw new IllegalArgumentException("Illegal year : " + y);
        //javaCal = null;
        //year = y;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.018 -0400", hash_original_method = "685E9F12E07BC44AEFABA3E87A7BA88C", hash_generated_method = "4CA4CB079B90251ABE185A10C8D1C96E")
    public int getYear() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1245635527 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1245635527;
        // ---------- Original Method ----------
        //return year;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.019 -0400", hash_original_method = "8F41240A07063AF12A20DAC696350061", hash_generated_method = "C2AFD2063F5E491E745E7DD4F418282A")
    public void setHour(int h) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Illegal hour : " + h);
        javaCal = null;
        hour = h;
        // ---------- Original Method ----------
        //if (h < 0 || h > 24)
            //throw new IllegalArgumentException("Illegal hour : " + h);
        //javaCal = null;
        //hour = h;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.021 -0400", hash_original_method = "0A40A5D1C091DEF2AA14C093CC6460BC", hash_generated_method = "F878573F640FAFEB1CEC6716F65795CB")
    public void setMinute(int m) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Illegal minute : " + (Integer.toString(m)));
        javaCal = null;
        minute = m;
        // ---------- Original Method ----------
        //if (m < 0 || m >= 60)
            //throw new IllegalArgumentException(
                //"Illegal minute : " + (Integer.toString(m)));
        //javaCal = null;
        //minute = m;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.022 -0400", hash_original_method = "2AD3B3771A5FA25E5792A620A7EA9BAA", hash_generated_method = "C16B7C9298FEC83F3870BE0DABE60A08")
    public void setSecond(int s) throws IllegalArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Illegal second : " + Integer.toString(s));
        javaCal = null;
        second = s;
        // ---------- Original Method ----------
        //if (s < 0 || s >= 60)
            //throw new IllegalArgumentException(
                //"Illegal second : " + Integer.toString(s));
        //javaCal = null;
        //second = s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.022 -0400", hash_original_method = "2F4F469E30C2F586A40940F33F0E1586", hash_generated_method = "A55B354D70046CB41F8F125391FACA99")
    public int getDeltaSeconds() {
        long ctime;
        ctime = this.getJavaCal().getTime().getTime();
        int var564E041B7CDDC5ADD7BEB915CCCDE394_1470718180 = ((int) (ctime - System.currentTimeMillis()) / 1000);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113998186 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_113998186;
        // ---------- Original Method ----------
        //long ctime = this.getJavaCal().getTime().getTime();
        //return (int) (ctime - System.currentTimeMillis()) / 1000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.028 -0400", hash_original_method = "4BA050DE2121A2990466253CFC8AD778", hash_generated_method = "A6072B004A794DE7998C7484658EC7F5")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1340596848 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1340596848 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1340596848.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1340596848;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.028 -0400", hash_original_field = "3711CF8C305348C83A69C259D4169CD2", hash_generated_field = "4726070A00C91D9BA7243EC018553565")

    private static long serialVersionUID = 8544101899928346909L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.028 -0400", hash_original_field = "37C601F2036A369A76BDEF09EBA13B29", hash_generated_field = "90A017F290A00288C0F071E9A1EBD88C")

    public static final String GMT = "GMT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.028 -0400", hash_original_field = "F822252C460E43C68512DB19F2238272", hash_generated_field = "D993B191F18C7C2A2ACF77D43C481204")

    public static final String MON = "Mon";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.028 -0400", hash_original_field = "E13C5035426328FC96F60CE16D367A0B", hash_generated_field = "A396BE9DE9586E197D6C0B3E443E0D95")

    public static final String TUE = "Tue";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.029 -0400", hash_original_field = "6A9E479F2EE6BFA965B32747936DB368", hash_generated_field = "3D06F8133C09119B26C6E278798CF1A9")

    public static final String WED = "Wed";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.029 -0400", hash_original_field = "8E00C2EA9118ED41470E465C34E26A8D", hash_generated_field = "09A162F56D2A9384083E7AAF03183FD6")

    public static final String THU = "Thu";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.029 -0400", hash_original_field = "36999DD3216BCBE23BAF2D3CAAE0DEA6", hash_generated_field = "130AB4377BFA7580AE1512EA43195FBC")

    public static final String FRI = "Fri";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "6788CE2821B811132FCA00FCCB7843A4", hash_generated_field = "F219533A1B8112292C40A0B685C35CFD")

    public static final String SAT = "Sat";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "B9D6E5F089E0857DB21C9E08AC8B26ED", hash_generated_field = "6C1848B20607A097704760E1650C2678")

    public static final String SUN = "Sun";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "DBF7DFB7502E55498300890F933767D9", hash_generated_field = "F2D1780B5CE22050F6158996B8E61999")

    public static final String JAN = "Jan";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "2637ECF938440EAF8F10DD7278DB2BB9", hash_generated_field = "6FADB9C3303C0BDE49C3B4B5539EFD6E")

    public static final String FEB = "Feb";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "52518F50DABA9229AF40AE891A8B4D1C", hash_generated_field = "6303D6FBD3F71C8EE38712E28705023E")

    public static final String MAR = "Mar";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "5DDBC7FEC87EB31DEB50BB5F94FAFBD7", hash_generated_field = "23DBF8FEC46857D1C97D6E3A64C4C782")

    public static final String APR = "Apr";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "D89AC508A90A47AF7CBB472BE8533349", hash_generated_field = "47FD9EBB6C303C4777A0424A8CB9008B")

    public static final String MAY = "May";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "992F14AD77E8C98E19366CD5CDA3E041", hash_generated_field = "24E1CBE6524227A554B498F7E7BFA54C")

    public static final String JUN = "Jun";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "34DA4E467F087737AA361D2038E50450", hash_generated_field = "E960EB8D455449B7DD7F8DF660D9E443")

    public static final String JUL = "Jul";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "8FCD505B4B8FDF8BEEB4E2E40FD7BDE2", hash_generated_field = "CE558222EA08CDFDCA2D75DF00FE2DF9")

    public static final String AUG = "Aug";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "6221BDBC2CC6ACE69A93E417555690F7", hash_generated_field = "54D87D6819D3255A8690058A26F311B4")

    public static final String SEP = "Sep";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "557FFA803FDA695A6ED3D7584ABAE5B4", hash_generated_field = "3EB1F3DE2F9DBA4FAD368F5BCB02D165")

    public static final String OCT = "Oct";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "3B4841F2F7185A7963DE3F3042F923E5", hash_generated_field = "1B59DBC9E66C4388573EE99FDE2F7799")

    public static final String NOV = "Nov";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.031 -0400", hash_original_field = "3810CF0AA1237E029D6EC618BF9E9F4D", hash_generated_field = "033F25F46987BBA69C5EC9DD661A40F0")

    public static final String DEC = "Dec";
}

