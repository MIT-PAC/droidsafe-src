package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.core.*;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Locale;
import java.util.GregorianCalendar;
import java.io.Serializable;
import java.lang.IllegalArgumentException;

public class SIPDate implements Cloneable, Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.085 -0400", hash_original_field = "717AAECF4D718C53F4246C571B5CAE89", hash_generated_field = "2BD9D52B8925416FAD31A17813ACA6C8")

    protected String sipWkDay;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.085 -0400", hash_original_field = "E23A549557EC421F126860CDF6AF3E27", hash_generated_field = "A80823C4CD33F3F3AF953060F7AED1B1")

    protected String sipMonth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.085 -0400", hash_original_field = "DCDCC83A4B23617019C9F14EA7F5BC77", hash_generated_field = "596F87319AF1E1308C1EB0CCEED33A9B")

    protected int wkday;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.085 -0400", hash_original_field = "628B7DB04235F228D40ADC671413A8C8", hash_generated_field = "B2F58CEAE0DE7FF9484606598C0B67F1")

    protected int day;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.085 -0400", hash_original_field = "7436F942D5EA836CB84F1BB2527D8286", hash_generated_field = "2F8C5F97A36CC740C18AB87771CBAEAF")

    protected int month;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.085 -0400", hash_original_field = "84CDC76CABF41BD7C961F6AB12F117D8", hash_generated_field = "3748125DBF788D9E5C4BD7C78EC4D962")

    protected int year;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.085 -0400", hash_original_field = "896C55CC5E46FAB38CE9F51EBF7BFCD3", hash_generated_field = "BF1D48E6FF386AD255CBE290B36EF4AB")

    protected int hour;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.085 -0400", hash_original_field = "0A7D55BE9D12A369A6A8DA0FB517FBA4", hash_generated_field = "59841BABE93C0194E018D6000A755537")

    protected int minute;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.085 -0400", hash_original_field = "A9F0E61A137D86AA9DB53465E0801612", hash_generated_field = "B5AC3CA74A56A5C24E7CCD8912B6592B")

    protected int second;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.085 -0400", hash_original_field = "F7ED2965F033A6E702D82C1AEC8D0C79", hash_generated_field = "A3E3EEB6FF939AF7B2782A68BB29796C")

    private java.util.Calendar javaCal;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.086 -0400", hash_original_method = "C73CBA236E994654D9EB18CB745C41F4", hash_generated_method = "B8FAD3ED34CC8D51B2A635E7C63EE33A")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.089 -0400", hash_original_method = "7A2DC6C5A2282C24FE6927FC780CB71C", hash_generated_method = "FE04B2941AB15E971CA4F39146792012")
    public  SIPDate(long timeMillis) {
        addTaint(timeMillis);
        javaCal =
            new GregorianCalendar(
                TimeZone.getTimeZone("GMT:0"),
                Locale.getDefault());
        java.util.Date date = new java.util.Date(timeMillis);
        javaCal.setTime(date);
        wkday = javaCal.get(Calendar.DAY_OF_WEEK);
switch(wkday){
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
}        day = javaCal.get(Calendar.DAY_OF_MONTH);
        month = javaCal.get(Calendar.MONTH);
switch(month){
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
}        year = javaCal.get(Calendar.YEAR);
        hour = javaCal.get(Calendar.HOUR_OF_DAY);
        minute = javaCal.get(Calendar.MINUTE);
        second = javaCal.get(Calendar.SECOND);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.090 -0400", hash_original_method = "17EF9A3AE37B7BA0C102396D80392A03", hash_generated_method = "546F843125CB7AB81FAC3FE5BC6D1422")
    public boolean equals(Object that) {
        addTaint(that.getTaint());
    if(that.getClass() != this.getClass())        
        {
        boolean var68934A3E9455FA72420237EB05902327_1996052817 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664780272 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_664780272;
        }
        SIPDate other = (SIPDate)that;
        boolean varE175A802FC6D3A5111811FF681ACB261_742453883 = (this.wkday == other.wkday &&
        this.day == other.day &&
        this.month == other.month &&
        this.year == other.year &&
        this.hour == other.hour &&
        this.minute == other.minute &&
        this.second == other.second);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1611550600 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1611550600;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.091 -0400", hash_original_method = "124CFAD93358C90C664BE8C1CAE8945E", hash_generated_method = "39F28163EDA202500C3BA03827EF0515")
    public String encode() {
        String dayString;
    if(day < 10)        
        {
            dayString = "0" + day;
        } //End block
        else
        dayString = "" + day;
        String hourString;
    if(hour < 10)        
        {
            hourString = "0" + hour;
        } //End block
        else
        hourString = "" + hour;
        String minuteString;
    if(minute < 10)        
        {
            minuteString = "0" + minute;
        } //End block
        else
        minuteString = "" + minute;
        String secondString;
    if(second < 10)        
        {
            secondString = "0" + second;
        } //End block
        else
        secondString = "" + second;
        String encoding = "";
    if(sipWkDay != null)        
        encoding += sipWkDay + Separators.COMMA + Separators.SP;
        encoding += dayString + Separators.SP;
    if(sipMonth != null)        
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
String varE424DD5E6E58EB63E1272B71B5A81966_1070871338 =         encoding;
        varE424DD5E6E58EB63E1272B71B5A81966_1070871338.addTaint(taint);
        return varE424DD5E6E58EB63E1272B71B5A81966_1070871338;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.092 -0400", hash_original_method = "AA358655086B2D4E31F8BC09FB299576", hash_generated_method = "CFBA28D3C72929107F9FEEE728855D9F")
    public java.util.Calendar getJavaCal() {
    if(javaCal == null)        
        setJavaCal();
java.util.Calendar varB9F9E543D49F5A6C9B26B757C6434821_1020653331 =         javaCal;
        varB9F9E543D49F5A6C9B26B757C6434821_1020653331.addTaint(taint);
        return varB9F9E543D49F5A6C9B26B757C6434821_1020653331;
        // ---------- Original Method ----------
        //if (javaCal == null)
            //setJavaCal();
        //return javaCal;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.092 -0400", hash_original_method = "457D7CE469867FC10EBD436F0D51643B", hash_generated_method = "79659DD8AB5AB3E02731DF452F34FA4B")
    public String getWkday() {
String varAF8BC7AE70F97D08A2C5ED767D4202A4_1045810397 =         sipWkDay;
        varAF8BC7AE70F97D08A2C5ED767D4202A4_1045810397.addTaint(taint);
        return varAF8BC7AE70F97D08A2C5ED767D4202A4_1045810397;
        // ---------- Original Method ----------
        //return sipWkDay;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.092 -0400", hash_original_method = "A22F3A31D7F5863E790748C0D0AB40F6", hash_generated_method = "32AC24E4118773A14E5C37394C6BF470")
    public String getMonth() {
String var2A647B1AB7CAB288D6A463E2252BABED_818181031 =         sipMonth;
        var2A647B1AB7CAB288D6A463E2252BABED_818181031.addTaint(taint);
        return var2A647B1AB7CAB288D6A463E2252BABED_818181031;
        // ---------- Original Method ----------
        //return sipMonth;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.093 -0400", hash_original_method = "4346EB52B1E97382E292AD2394C76CAA", hash_generated_method = "F24CE4BD9D961BAF2AAA29E11F907DAA")
    public int getHour() {
        int var896C55CC5E46FAB38CE9F51EBF7BFCD3_785153852 = (hour);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466193075 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1466193075;
        // ---------- Original Method ----------
        //return hour;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.093 -0400", hash_original_method = "ADC91C6D58A75EA1079C93B22A777A18", hash_generated_method = "C6007DBFA23109BA26FAF6CBCE94296B")
    public int getMinute() {
        int var0A7D55BE9D12A369A6A8DA0FB517FBA4_289748999 = (minute);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724446203 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_724446203;
        // ---------- Original Method ----------
        //return minute;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.093 -0400", hash_original_method = "033202145FC9480CAEE9B3FD508F85AB", hash_generated_method = "259AC6F4FCD477B4A3809DF27DC5C7EE")
    public int getSecond() {
        int varA9F0E61A137D86AA9DB53465E0801612_897602014 = (second);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268302066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1268302066;
        // ---------- Original Method ----------
        //return second;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.094 -0400", hash_original_method = "ED081120415B25517E6A51D04161FC1C", hash_generated_method = "D96D5D4772A1CFC8C90621C14BC511EE")
    private void setJavaCal() {
        javaCal =
            new GregorianCalendar(
                TimeZone.getTimeZone("GMT:0"),
                Locale.getDefault());
    if(year != -1)        
        javaCal.set(Calendar.YEAR, year);
    if(day != -1)        
        javaCal.set(Calendar.DAY_OF_MONTH, day);
    if(month != -1)        
        javaCal.set(Calendar.MONTH, month);
    if(wkday != -1)        
        javaCal.set(Calendar.DAY_OF_WEEK, wkday);
    if(hour != -1)        
        javaCal.set(Calendar.HOUR, hour);
    if(minute != -1)        
        javaCal.set(Calendar.MINUTE, minute);
    if(second != -1)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.095 -0400", hash_original_method = "AC7B5ED74AB02B130D63CC72231A28FF", hash_generated_method = "219C65D50009A86BCC0EC6B5EDB71511")
    public void setWkday(String w) throws IllegalArgumentException {
        sipWkDay = w;
    if(sipWkDay.compareToIgnoreCase(MON) == 0)        
        {
            wkday = Calendar.MONDAY;
        } //End block
        else
    if(sipWkDay.compareToIgnoreCase(TUE) == 0)        
        {
            wkday = Calendar.TUESDAY;
        } //End block
        else
    if(sipWkDay.compareToIgnoreCase(WED) == 0)        
        {
            wkday = Calendar.WEDNESDAY;
        } //End block
        else
    if(sipWkDay.compareToIgnoreCase(THU) == 0)        
        {
            wkday = Calendar.THURSDAY;
        } //End block
        else
    if(sipWkDay.compareToIgnoreCase(FRI) == 0)        
        {
            wkday = Calendar.FRIDAY;
        } //End block
        else
    if(sipWkDay.compareToIgnoreCase(SAT) == 0)        
        {
            wkday = Calendar.SATURDAY;
        } //End block
        else
    if(sipWkDay.compareToIgnoreCase(SUN) == 0)        
        {
            wkday = Calendar.SUNDAY;
        } //End block
        else
        {
            IllegalArgumentException var1737B0A32D4320C1D8085D8F308E9CDC_645811381 = new IllegalArgumentException("Illegal Week day :" + w);
            var1737B0A32D4320C1D8085D8F308E9CDC_645811381.addTaint(taint);
            throw var1737B0A32D4320C1D8085D8F308E9CDC_645811381;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.096 -0400", hash_original_method = "79BC1DF7B5884941473DA919072706C3", hash_generated_method = "6ECF186D1D5D2849A0BD96495550CB0A")
    public void setDay(int d) throws IllegalArgumentException {
    if(d < 1 || d > 31)        
        {
        IllegalArgumentException var58BC0D4AC5876E17BC897F22DA7D304A_272019339 = new IllegalArgumentException(
                "Illegal Day of the month " + Integer.toString(d));
        var58BC0D4AC5876E17BC897F22DA7D304A_272019339.addTaint(taint);
        throw var58BC0D4AC5876E17BC897F22DA7D304A_272019339;
        }
        day = d;
        // ---------- Original Method ----------
        //if (d < 1 || d > 31)
            //throw new IllegalArgumentException(
                //"Illegal Day of the month " + Integer.toString(d));
        //day = d;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.097 -0400", hash_original_method = "F81F66CB2E9CA66D72BD9964B3A16CCB", hash_generated_method = "7FFD6B2C868445E5F7C42F4A1F7F4B6A")
    public void setMonth(String m) throws IllegalArgumentException {
        sipMonth = m;
    if(sipMonth.compareToIgnoreCase(JAN) == 0)        
        {
            month = Calendar.JANUARY;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(FEB) == 0)        
        {
            month = Calendar.FEBRUARY;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(MAR) == 0)        
        {
            month = Calendar.MARCH;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(APR) == 0)        
        {
            month = Calendar.APRIL;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(MAY) == 0)        
        {
            month = Calendar.MAY;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(JUN) == 0)        
        {
            month = Calendar.JUNE;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(JUL) == 0)        
        {
            month = Calendar.JULY;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(AUG) == 0)        
        {
            month = Calendar.AUGUST;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(SEP) == 0)        
        {
            month = Calendar.SEPTEMBER;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(OCT) == 0)        
        {
            month = Calendar.OCTOBER;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(NOV) == 0)        
        {
            month = Calendar.NOVEMBER;
        } //End block
        else
    if(sipMonth.compareToIgnoreCase(DEC) == 0)        
        {
            month = Calendar.DECEMBER;
        } //End block
        else
        {
            IllegalArgumentException var814901485D303FC431FC64CE9D4A23C4_1752313056 = new IllegalArgumentException("Illegal Month :" + m);
            var814901485D303FC431FC64CE9D4A23C4_1752313056.addTaint(taint);
            throw var814901485D303FC431FC64CE9D4A23C4_1752313056;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.099 -0400", hash_original_method = "65E0B59727307B53E2290DE9B41E88A5", hash_generated_method = "3FE0E0D2CAC1785D48B4E72427958424")
    public void setYear(int y) throws IllegalArgumentException {
    if(y < 0)        
        {
        IllegalArgumentException var761671DB2F006B7529C9E0EE186CCC93_1064492596 = new IllegalArgumentException("Illegal year : " + y);
        var761671DB2F006B7529C9E0EE186CCC93_1064492596.addTaint(taint);
        throw var761671DB2F006B7529C9E0EE186CCC93_1064492596;
        }
        javaCal = null;
        year = y;
        // ---------- Original Method ----------
        //if (y < 0)
            //throw new IllegalArgumentException("Illegal year : " + y);
        //javaCal = null;
        //year = y;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.099 -0400", hash_original_method = "685E9F12E07BC44AEFABA3E87A7BA88C", hash_generated_method = "5FAE8F2F0BAAA9D074C81D67ED414D06")
    public int getYear() {
        int var84CDC76CABF41BD7C961F6AB12F117D8_1533542023 = (year);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472663813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1472663813;
        // ---------- Original Method ----------
        //return year;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.100 -0400", hash_original_method = "8F41240A07063AF12A20DAC696350061", hash_generated_method = "6D471A9DFB772D107BFDBDEF2A678CF9")
    public void setHour(int h) throws IllegalArgumentException {
    if(h < 0 || h > 24)        
        {
        IllegalArgumentException varDCCCEE311583A34F434E3972BC6281E8_458626788 = new IllegalArgumentException("Illegal hour : " + h);
        varDCCCEE311583A34F434E3972BC6281E8_458626788.addTaint(taint);
        throw varDCCCEE311583A34F434E3972BC6281E8_458626788;
        }
        javaCal = null;
        hour = h;
        // ---------- Original Method ----------
        //if (h < 0 || h > 24)
            //throw new IllegalArgumentException("Illegal hour : " + h);
        //javaCal = null;
        //hour = h;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.100 -0400", hash_original_method = "0A40A5D1C091DEF2AA14C093CC6460BC", hash_generated_method = "CF7AE45DB92628A50BC29DB08113DE49")
    public void setMinute(int m) throws IllegalArgumentException {
    if(m < 0 || m >= 60)        
        {
        IllegalArgumentException varC1E0C203BF279C8FFF509002E5C1A9DF_1900510957 = new IllegalArgumentException(
                "Illegal minute : " + (Integer.toString(m)));
        varC1E0C203BF279C8FFF509002E5C1A9DF_1900510957.addTaint(taint);
        throw varC1E0C203BF279C8FFF509002E5C1A9DF_1900510957;
        }
        javaCal = null;
        minute = m;
        // ---------- Original Method ----------
        //if (m < 0 || m >= 60)
            //throw new IllegalArgumentException(
                //"Illegal minute : " + (Integer.toString(m)));
        //javaCal = null;
        //minute = m;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.101 -0400", hash_original_method = "2AD3B3771A5FA25E5792A620A7EA9BAA", hash_generated_method = "4F7AFC7CCA47B3F5950A699001FF4A05")
    public void setSecond(int s) throws IllegalArgumentException {
    if(s < 0 || s >= 60)        
        {
        IllegalArgumentException var75CA8C32692CF5CB66F50F1441721D47_931989484 = new IllegalArgumentException(
                "Illegal second : " + Integer.toString(s));
        var75CA8C32692CF5CB66F50F1441721D47_931989484.addTaint(taint);
        throw var75CA8C32692CF5CB66F50F1441721D47_931989484;
        }
        javaCal = null;
        second = s;
        // ---------- Original Method ----------
        //if (s < 0 || s >= 60)
            //throw new IllegalArgumentException(
                //"Illegal second : " + Integer.toString(s));
        //javaCal = null;
        //second = s;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.101 -0400", hash_original_method = "2F4F469E30C2F586A40940F33F0E1586", hash_generated_method = "7700721F491F6D06696B9C46E03BE3F1")
    public int getDeltaSeconds() {
        long ctime = this.getJavaCal().getTime().getTime();
        int var912A5FE0D780AF2A90211073F0C20C13_1871031676 = ((int) (ctime - System.currentTimeMillis()) / 1000);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582732970 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582732970;
        // ---------- Original Method ----------
        //long ctime = this.getJavaCal().getTime().getTime();
        //return (int) (ctime - System.currentTimeMillis()) / 1000;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.102 -0400", hash_original_method = "4BA050DE2121A2990466253CFC8AD778", hash_generated_method = "98610E7F77647865BEEEE3B65A49D4D5")
    public Object clone() {
        SIPDate retval;
        try 
        {
            retval = (SIPDate) super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            RuntimeException var1A3D561C49733FF4B8E39ED1A5C8FCCD_1604862649 = new RuntimeException("Internal error");
            var1A3D561C49733FF4B8E39ED1A5C8FCCD_1604862649.addTaint(taint);
            throw var1A3D561C49733FF4B8E39ED1A5C8FCCD_1604862649;
        } //End block
    if(javaCal != null)        
        retval.javaCal = (java.util.Calendar) javaCal.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_726816225 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_726816225.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_726816225;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.102 -0400", hash_original_field = "3711CF8C305348C83A69C259D4169CD2", hash_generated_field = "9AD574E6092CE8903697183A4F17A37E")

    private static final long serialVersionUID = 8544101899928346909L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.102 -0400", hash_original_field = "37C601F2036A369A76BDEF09EBA13B29", hash_generated_field = "90A017F290A00288C0F071E9A1EBD88C")

    public static final String GMT = "GMT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.102 -0400", hash_original_field = "F822252C460E43C68512DB19F2238272", hash_generated_field = "D993B191F18C7C2A2ACF77D43C481204")

    public static final String MON = "Mon";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.102 -0400", hash_original_field = "E13C5035426328FC96F60CE16D367A0B", hash_generated_field = "A396BE9DE9586E197D6C0B3E443E0D95")

    public static final String TUE = "Tue";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "6A9E479F2EE6BFA965B32747936DB368", hash_generated_field = "3D06F8133C09119B26C6E278798CF1A9")

    public static final String WED = "Wed";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "8E00C2EA9118ED41470E465C34E26A8D", hash_generated_field = "09A162F56D2A9384083E7AAF03183FD6")

    public static final String THU = "Thu";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "36999DD3216BCBE23BAF2D3CAAE0DEA6", hash_generated_field = "130AB4377BFA7580AE1512EA43195FBC")

    public static final String FRI = "Fri";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "6788CE2821B811132FCA00FCCB7843A4", hash_generated_field = "F219533A1B8112292C40A0B685C35CFD")

    public static final String SAT = "Sat";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "B9D6E5F089E0857DB21C9E08AC8B26ED", hash_generated_field = "6C1848B20607A097704760E1650C2678")

    public static final String SUN = "Sun";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "DBF7DFB7502E55498300890F933767D9", hash_generated_field = "F2D1780B5CE22050F6158996B8E61999")

    public static final String JAN = "Jan";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "2637ECF938440EAF8F10DD7278DB2BB9", hash_generated_field = "6FADB9C3303C0BDE49C3B4B5539EFD6E")

    public static final String FEB = "Feb";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "52518F50DABA9229AF40AE891A8B4D1C", hash_generated_field = "6303D6FBD3F71C8EE38712E28705023E")

    public static final String MAR = "Mar";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "5DDBC7FEC87EB31DEB50BB5F94FAFBD7", hash_generated_field = "23DBF8FEC46857D1C97D6E3A64C4C782")

    public static final String APR = "Apr";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "D89AC508A90A47AF7CBB472BE8533349", hash_generated_field = "47FD9EBB6C303C4777A0424A8CB9008B")

    public static final String MAY = "May";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "992F14AD77E8C98E19366CD5CDA3E041", hash_generated_field = "24E1CBE6524227A554B498F7E7BFA54C")

    public static final String JUN = "Jun";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "34DA4E467F087737AA361D2038E50450", hash_generated_field = "E960EB8D455449B7DD7F8DF660D9E443")

    public static final String JUL = "Jul";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "8FCD505B4B8FDF8BEEB4E2E40FD7BDE2", hash_generated_field = "CE558222EA08CDFDCA2D75DF00FE2DF9")

    public static final String AUG = "Aug";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "6221BDBC2CC6ACE69A93E417555690F7", hash_generated_field = "54D87D6819D3255A8690058A26F311B4")

    public static final String SEP = "Sep";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "557FFA803FDA695A6ED3D7584ABAE5B4", hash_generated_field = "3EB1F3DE2F9DBA4FAD368F5BCB02D165")

    public static final String OCT = "Oct";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "3B4841F2F7185A7963DE3F3042F923E5", hash_generated_field = "1B59DBC9E66C4388573EE99FDE2F7799")

    public static final String NOV = "Nov";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.103 -0400", hash_original_field = "3810CF0AA1237E029D6EC618BF9E9F4D", hash_generated_field = "033F25F46987BBA69C5EC9DD661A40F0")

    public static final String DEC = "Dec";
}

