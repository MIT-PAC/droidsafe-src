package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.core.Separators;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;






public class SIPDate implements Cloneable, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.870 -0500", hash_original_field = "526C029BED3197AA2313CE0C8E30D713", hash_generated_field = "9AD574E6092CE8903697183A4F17A37E")

    private static final long serialVersionUID = 8544101899928346909L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.873 -0500", hash_original_field = "ABC13833BC0EFECD002D7D1AFB75D45F", hash_generated_field = "90A017F290A00288C0F071E9A1EBD88C")

    public static final String GMT = "GMT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.876 -0500", hash_original_field = "A9DA87AF4D77D3BF3B99B1E440D1B6F5", hash_generated_field = "D993B191F18C7C2A2ACF77D43C481204")

    public static final String MON = "Mon";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.880 -0500", hash_original_field = "3C878DD3CAD1E2F42E08A0839DA1FB30", hash_generated_field = "A396BE9DE9586E197D6C0B3E443E0D95")

    public static final String TUE = "Tue";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.884 -0500", hash_original_field = "3B632C671668CD99178E3B2CB5E2A8DA", hash_generated_field = "3D06F8133C09119B26C6E278798CF1A9")

    public static final String WED = "Wed";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.886 -0500", hash_original_field = "F4CE9E15DCF7EFEA6673D65760ABBF83", hash_generated_field = "09A162F56D2A9384083E7AAF03183FD6")

    public static final String THU = "Thu";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.889 -0500", hash_original_field = "DA919786D40C7CE6C41687705B2B69F1", hash_generated_field = "130AB4377BFA7580AE1512EA43195FBC")

    public static final String FRI = "Fri";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.892 -0500", hash_original_field = "3B57FEF7D6E5A1C6824FD8555FB6A934", hash_generated_field = "F219533A1B8112292C40A0B685C35CFD")

    public static final String SAT = "Sat";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.896 -0500", hash_original_field = "0240BF6D19B48E08A573F269E4EC0C25", hash_generated_field = "6C1848B20607A097704760E1650C2678")

    public static final String SUN = "Sun";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.899 -0500", hash_original_field = "A7664447352F7B186E4E5202A3442A3E", hash_generated_field = "F2D1780B5CE22050F6158996B8E61999")

    public static final String JAN = "Jan";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.902 -0500", hash_original_field = "5E92B89D0A9E45CBFEAF5984AD0E9A4F", hash_generated_field = "6FADB9C3303C0BDE49C3B4B5539EFD6E")

    public static final String FEB = "Feb";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.905 -0500", hash_original_field = "C851F35E5915AAC45BBF5199B8CC61BB", hash_generated_field = "6303D6FBD3F71C8EE38712E28705023E")

    public static final String MAR = "Mar";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.908 -0500", hash_original_field = "F3BC763F1E5F38EA231972394CA92559", hash_generated_field = "23DBF8FEC46857D1C97D6E3A64C4C782")

    public static final String APR = "Apr";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.911 -0500", hash_original_field = "5E01A670A4FCDF8E6436BA4377820361", hash_generated_field = "47FD9EBB6C303C4777A0424A8CB9008B")

    public static final String MAY = "May";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.915 -0500", hash_original_field = "3B1275D7B946A5DCDEE17156B962297B", hash_generated_field = "24E1CBE6524227A554B498F7E7BFA54C")

    public static final String JUN = "Jun";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.918 -0500", hash_original_field = "2706381DB3FD3178850B87789FE196F9", hash_generated_field = "E960EB8D455449B7DD7F8DF660D9E443")

    public static final String JUL = "Jul";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.921 -0500", hash_original_field = "131C6450536E5279CB988A860031FDB8", hash_generated_field = "CE558222EA08CDFDCA2D75DF00FE2DF9")

    public static final String AUG = "Aug";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.925 -0500", hash_original_field = "BF3B5CA66DC4BA91B8489EC7915D05F2", hash_generated_field = "54D87D6819D3255A8690058A26F311B4")

    public static final String SEP = "Sep";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.928 -0500", hash_original_field = "54431E16396A6D90E5C3B2D9E93399C8", hash_generated_field = "3EB1F3DE2F9DBA4FAD368F5BCB02D165")

    public static final String OCT = "Oct";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.931 -0500", hash_original_field = "6F1E9159B7BC497F40D221AF19E4D6AD", hash_generated_field = "1B59DBC9E66C4388573EE99FDE2F7799")

    public static final String NOV = "Nov";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.934 -0500", hash_original_field = "50203058D0C9402469D23B3609965FDF", hash_generated_field = "033F25F46987BBA69C5EC9DD661A40F0")

    public static final String DEC = "Dec";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.936 -0500", hash_original_field = "3565028AF84A4EC5A887E1C4BD27B428", hash_generated_field = "2BD9D52B8925416FAD31A17813ACA6C8")

    protected String sipWkDay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.939 -0500", hash_original_field = "6F9F3C20A1BA06EE6C8E9CB275F82577", hash_generated_field = "A80823C4CD33F3F3AF953060F7AED1B1")

    protected String sipMonth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.943 -0500", hash_original_field = "383B95F34A748C804FD21AA199440D42", hash_generated_field = "596F87319AF1E1308C1EB0CCEED33A9B")

    protected int wkday;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.946 -0500", hash_original_field = "7B9E331B9FA77276F82C941B252DC90D", hash_generated_field = "B2F58CEAE0DE7FF9484606598C0B67F1")

    protected int day;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.949 -0500", hash_original_field = "D47DF9EB6B827E7A5A09905C90EC13DE", hash_generated_field = "2F8C5F97A36CC740C18AB87771CBAEAF")

    protected int month;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.952 -0500", hash_original_field = "A74C473B668E5186D1BA6112E0F14F77", hash_generated_field = "3748125DBF788D9E5C4BD7C78EC4D962")

    protected int year;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.955 -0500", hash_original_field = "6CAA30872566AAC3D8208DA318F04BBD", hash_generated_field = "BF1D48E6FF386AD255CBE290B36EF4AB")

    protected int hour;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.958 -0500", hash_original_field = "56A69BE5A6B1DCF64B7123BACE74483B", hash_generated_field = "59841BABE93C0194E018D6000A755537")

    protected int minute;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.961 -0500", hash_original_field = "662760B0A001432CFE4D3F18F01B3CEF", hash_generated_field = "B5AC3CA74A56A5C24E7CCD8912B6592B")

    protected int second;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.964 -0500", hash_original_field = "C57EA28ABCE9FAD4752E087EA5082A25", hash_generated_field = "A3E3EEB6FF939AF7B2782A68BB29796C")

    private java.util.Calendar javaCal;

    /**
     * Initializer, sets all the fields to invalid values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.970 -0500", hash_original_method = "C73CBA236E994654D9EB18CB745C41F4", hash_generated_method = "DBE8EADF017633BD71ABF01BC72E1357")
    
public SIPDate() {
        wkday = -1;
        day = -1;
        month = -1;
        year = -1;
        hour = -1;
        minute = -1;
        second = -1;
        javaCal = null;
    }

    /**
     * Construct a SIP date from the time offset given in miliseconds
     * @param timeMillis long to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.974 -0500", hash_original_method = "7A2DC6C5A2282C24FE6927FC780CB71C", hash_generated_method = "3134FCB24E4888B80FEFDDE016120A55")
    
public SIPDate(long timeMillis) {
        javaCal =
            new GregorianCalendar(
                TimeZone.getTimeZone("GMT:0"),
                Locale.getDefault());
        java.util.Date date = new java.util.Date(timeMillis);
        javaCal.setTime(date);
        wkday = javaCal.get(Calendar.DAY_OF_WEEK);
        switch (wkday) {
            case Calendar.MONDAY :
                sipWkDay = MON;
                break;
            case Calendar.TUESDAY :
                sipWkDay = TUE;
                break;
            case Calendar.WEDNESDAY :
                sipWkDay = WED;
                break;
            case Calendar.THURSDAY :
                sipWkDay = THU;
                break;
            case Calendar.FRIDAY :
                sipWkDay = FRI;
                break;
            case Calendar.SATURDAY :
                sipWkDay = SAT;
                break;
            case Calendar.SUNDAY :
                sipWkDay = SUN;
                break;
            default :
                InternalErrorHandler.handleException(
                    "No date map for wkday " + wkday);
        }

        day = javaCal.get(Calendar.DAY_OF_MONTH);
        month = javaCal.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY :
                sipMonth = JAN;
                break;
            case Calendar.FEBRUARY :
                sipMonth = FEB;
                break;
            case Calendar.MARCH :
                sipMonth = MAR;
                break;
            case Calendar.APRIL :
                sipMonth = APR;
                break;
            case Calendar.MAY :
                sipMonth = MAY;
                break;
            case Calendar.JUNE :
                sipMonth = JUN;
                break;
            case Calendar.JULY :
                sipMonth = JUL;
                break;
            case Calendar.AUGUST :
                sipMonth = AUG;
                break;
            case Calendar.SEPTEMBER :
                sipMonth = SEP;
                break;
            case Calendar.OCTOBER :
                sipMonth = OCT;
                break;
            case Calendar.NOVEMBER :
                sipMonth = NOV;
                break;
            case Calendar.DECEMBER :
                sipMonth = DEC;
                break;
            default :
                InternalErrorHandler.handleException(
                    "No date map for month " + month);
        }
        year = javaCal.get(Calendar.YEAR);
        // Bug report by Bruno Konik
        hour = javaCal.get(Calendar.HOUR_OF_DAY);
        minute = javaCal.get(Calendar.MINUTE);
        second = javaCal.get(Calendar.SECOND);
    }

    /** equality check.
     *
     *@return true if the two date fields are equals
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.967 -0500", hash_original_method = "17EF9A3AE37B7BA0C102396D80392A03", hash_generated_method = "FAE582568400939A0014202099B768BE")
    
public boolean equals(Object that){
        if (that.getClass() != this.getClass())return false;
        SIPDate other = (SIPDate)that;
        return this.wkday == other.wkday &&
        this.day == other.day &&
        this.month == other.month &&
        this.year == other.year &&
        this.hour == other.hour &&
        this.minute == other.minute &&
        this.second == other.second;
    }

    /**
     * Get canonical string representation.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.978 -0500", hash_original_method = "124CFAD93358C90C664BE8C1CAE8945E", hash_generated_method = "4983D95CB1196E5796EB9C6C952CAE2F")
    
public String encode() {

        String dayString;
        if (day < 10) {
            dayString = "0" + day;
        } else
            dayString = "" + day;

        String hourString;
        if (hour < 10) {
            hourString = "0" + hour;
        } else
            hourString = "" + hour;

        String minuteString;
        if (minute < 10) {
            minuteString = "0" + minute;
        } else
            minuteString = "" + minute;

        String secondString;
        if (second < 10) {
            secondString = "0" + second;
        } else
            secondString = "" + second;

        String encoding = "";

        if (sipWkDay != null)
            encoding += sipWkDay + Separators.COMMA + Separators.SP;

        encoding += dayString + Separators.SP;

        if (sipMonth != null)
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

        return encoding;
    }

    /**
     * The only accessor we allow is to the java calendar record.
     * All other fields are for this package only.
     * @return Calendar
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.981 -0500", hash_original_method = "AA358655086B2D4E31F8BC09FB299576", hash_generated_method = "5EDBD0906F60C65F22784211163D0ABB")
    
public java.util.Calendar getJavaCal() {
        if (javaCal == null)
            setJavaCal();
        return javaCal;
    }

    /** get the WkDay field
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.983 -0500", hash_original_method = "457D7CE469867FC10EBD436F0D51643B", hash_generated_method = "8998CC9BA5D098C6473AA8918E4D9328")
    
public String getWkday() {
        return sipWkDay;
    }

    /** get the month
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.987 -0500", hash_original_method = "A22F3A31D7F5863E790748C0D0AB40F6", hash_generated_method = "57B0669886903D03FF0699FBDD3E38C0")
    
public String getMonth() {
        return sipMonth;
    }

    /** get the hour
     * @return int
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.989 -0500", hash_original_method = "4346EB52B1E97382E292AD2394C76CAA", hash_generated_method = "A194E1C992B75D4090BBB66E32375345")
    
public int getHour() {
        return hour;
    }

    /** get the minute
     * @return int
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.992 -0500", hash_original_method = "ADC91C6D58A75EA1079C93B22A777A18", hash_generated_method = "CF49E8A6A214CF4A858F7AB8E9FFF007")
    
public int getMinute() {
        return minute;
    }

    /** get the second
     *  @return int
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.996 -0500", hash_original_method = "033202145FC9480CAEE9B3FD508F85AB", hash_generated_method = "689D20C84E5FD4B8743042815D0E5131")
    
public int getSecond() {
        return second;
    }

    /**
     * convert the SIP Date of this structure to a Java Date.
     * SIP Dates are forced to be GMT. Stores the converted time
     * as a java Calendar class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:10.999 -0500", hash_original_method = "ED081120415B25517E6A51D04161FC1C", hash_generated_method = "3BC81C23A89DB0C3F2683CBF46971FAA")
    
private void setJavaCal() {
        javaCal =
            new GregorianCalendar(
                TimeZone.getTimeZone("GMT:0"),
                Locale.getDefault());
        if (year != -1)
            javaCal.set(Calendar.YEAR, year);
        if (day != -1)
            javaCal.set(Calendar.DAY_OF_MONTH, day);
        if (month != -1)
            javaCal.set(Calendar.MONTH, month);
        if (wkday != -1)
            javaCal.set(Calendar.DAY_OF_WEEK, wkday);
        if (hour != -1)
            javaCal.set(Calendar.HOUR, hour);
        if (minute != -1)
            javaCal.set(Calendar.MINUTE, minute);
        if (second != -1)
            javaCal.set(Calendar.SECOND, second);
    }

    /**
     * Set the wkday member
     * @param w String to set
     * @throws IllegalArgumentException if w is not a valid day.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.003 -0500", hash_original_method = "AC7B5ED74AB02B130D63CC72231A28FF", hash_generated_method = "BB4D9737AD7D1B22E65DB0F98DA428CC")
    
public void setWkday(String w) throws IllegalArgumentException {
        sipWkDay = w;
        if (sipWkDay.compareToIgnoreCase(MON) == 0) {
            wkday = Calendar.MONDAY;
        } else if (sipWkDay.compareToIgnoreCase(TUE) == 0) {
            wkday = Calendar.TUESDAY;
        } else if (sipWkDay.compareToIgnoreCase(WED) == 0) {
            wkday = Calendar.WEDNESDAY;
        } else if (sipWkDay.compareToIgnoreCase(THU) == 0) {
            wkday = Calendar.THURSDAY;
        } else if (sipWkDay.compareToIgnoreCase(FRI) == 0) {
            wkday = Calendar.FRIDAY;
        } else if (sipWkDay.compareToIgnoreCase(SAT) == 0) {
            wkday = Calendar.SATURDAY;
        } else if (sipWkDay.compareToIgnoreCase(SUN) == 0) {
            wkday = Calendar.SUNDAY;
        } else {
            throw new IllegalArgumentException("Illegal Week day :" + w);
        }
    }

    /**
     * Set the day member
     * @param d int to set
     * @throws IllegalArgumentException if d is not a valid day
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.006 -0500", hash_original_method = "79BC1DF7B5884941473DA919072706C3", hash_generated_method = "9AA748BB5213C66F910F366F20787DB1")
    
public void setDay(int d) throws IllegalArgumentException {
        if (d < 1 || d > 31)
            throw new IllegalArgumentException(
                "Illegal Day of the month " + Integer.toString(d));
        day = d;
    }

    /**
     * Set the month member
     * @param m String to set.
     * @throws IllegalArgumentException if m is not a valid month
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.009 -0500", hash_original_method = "F81F66CB2E9CA66D72BD9964B3A16CCB", hash_generated_method = "DC4A4DBF91384FE83B071D5B966C80EE")
    
public void setMonth(String m) throws IllegalArgumentException {
        sipMonth = m;
        if (sipMonth.compareToIgnoreCase(JAN) == 0) {
            month = Calendar.JANUARY;
        } else if (sipMonth.compareToIgnoreCase(FEB) == 0) {
            month = Calendar.FEBRUARY;
        } else if (sipMonth.compareToIgnoreCase(MAR) == 0) {
            month = Calendar.MARCH;
        } else if (sipMonth.compareToIgnoreCase(APR) == 0) {
            month = Calendar.APRIL;
        } else if (sipMonth.compareToIgnoreCase(MAY) == 0) {
            month = Calendar.MAY;
        } else if (sipMonth.compareToIgnoreCase(JUN) == 0) {
            month = Calendar.JUNE;
        } else if (sipMonth.compareToIgnoreCase(JUL) == 0) {
            month = Calendar.JULY;
        } else if (sipMonth.compareToIgnoreCase(AUG) == 0) {
            month = Calendar.AUGUST;
        } else if (sipMonth.compareToIgnoreCase(SEP) == 0) {
            month = Calendar.SEPTEMBER;
        } else if (sipMonth.compareToIgnoreCase(OCT) == 0) {
            month = Calendar.OCTOBER;
        } else if (sipMonth.compareToIgnoreCase(NOV) == 0) {
            month = Calendar.NOVEMBER;
        } else if (sipMonth.compareToIgnoreCase(DEC) == 0) {
            month = Calendar.DECEMBER;
        } else {
            throw new IllegalArgumentException("Illegal Month :" + m);
        }
    }

    /**
     * Set the year member
     * @param y int to set
     * @throws IllegalArgumentException if y is not a valid year.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.012 -0500", hash_original_method = "65E0B59727307B53E2290DE9B41E88A5", hash_generated_method = "984D6566035E6D50851D70DC75F0A028")
    
public void setYear(int y) throws IllegalArgumentException {
        if (y < 0)
            throw new IllegalArgumentException("Illegal year : " + y);
        javaCal = null;
        year = y;
    }

    /**
    * Get the year member.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.015 -0500", hash_original_method = "685E9F12E07BC44AEFABA3E87A7BA88C", hash_generated_method = "AB2E34C40AC19F4A97DAF5C4A789B7FF")
    
public int getYear() {
        return year;
    }

    /**
     * Set the hour member
     * @param h int to set
     * @throws IllegalArgumentException if h is not a valid hour.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.018 -0500", hash_original_method = "8F41240A07063AF12A20DAC696350061", hash_generated_method = "9A2359DBCAD87AA216C635C1D118D7EA")
    
public void setHour(int h) throws IllegalArgumentException {
        if (h < 0 || h > 24)
            throw new IllegalArgumentException("Illegal hour : " + h);
        javaCal = null;
        hour = h;
    }

    /**
     * Set the minute member
     * @param m int to set
     * @throws IllegalArgumentException if m is not a valid minute
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.021 -0500", hash_original_method = "0A40A5D1C091DEF2AA14C093CC6460BC", hash_generated_method = "3EC470ECE1874F7EF2483641D759978D")
    
public void setMinute(int m) throws IllegalArgumentException {
        if (m < 0 || m >= 60)
            throw new IllegalArgumentException(
                "Illegal minute : " + (Integer.toString(m)));
        javaCal = null;
        minute = m;
    }

    /**
     * Set the second member
     * @param s int to set
     * @throws IllegalArgumentException if s is not a valid second
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.024 -0500", hash_original_method = "2AD3B3771A5FA25E5792A620A7EA9BAA", hash_generated_method = "749C8C89D10A7DFF1187E00EA60343F0")
    
public void setSecond(int s) throws IllegalArgumentException {
        if (s < 0 || s >= 60)
            throw new IllegalArgumentException(
                "Illegal second : " + Integer.toString(s));
        javaCal = null;
        second = s;
    }

    /** Get the time offset from the current time.
     *
     *@return offset from the current time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.026 -0500", hash_original_method = "2F4F469E30C2F586A40940F33F0E1586", hash_generated_method = "66492B98EA48DC7248B81F0EF8DBD816")
    
public int getDeltaSeconds() {
        // long ctime = this.getJavaCal().getTimeInMillis();
        long ctime = this.getJavaCal().getTime().getTime();
        return (int) (ctime - System.currentTimeMillis()) / 1000;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.029 -0500", hash_original_method = "4BA050DE2121A2990466253CFC8AD778", hash_generated_method = "E79E38E590026C56FD1D0DB753A809E7")
    
public Object clone() {
        SIPDate retval;
        try {
            retval = (SIPDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Internal error");
        }
        if (javaCal != null)
            retval.javaCal = (java.util.Calendar) javaCal.clone();
        return retval;
    }
}

