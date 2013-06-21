package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.LocaleData;
import libcore.icu.TimeZones;

public class DateFormatSymbols implements Serializable, Cloneable {
    private String localPatternChars;
    String[] ampms, eras, months, shortMonths, shortWeekdays, weekdays;
    transient String[] longStandAloneMonths;
    transient String[] shortStandAloneMonths;
    transient String[] longStandAloneWeekdays;
    transient String[] shortStandAloneWeekdays;
    String[][] zoneStrings;
    transient boolean customZoneStrings;
    transient Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.033 -0400", hash_original_method = "5D59D1DAC1D60D67A4A902493CF704FB", hash_generated_method = "C859C77BBE7800A29A0C963324C5BAF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DateFormatSymbols() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.033 -0400", hash_original_method = "10456A2571D0B6BA1CAC9BF624A7CB6F", hash_generated_method = "4E223A31880FF8E6499EA8BDDD9BB5EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DateFormatSymbols(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        this.localPatternChars = SimpleDateFormat.PATTERN_CHARS;
        LocaleData localeData;
        localeData = LocaleData.get(locale);
        this.ampms = localeData.amPm;
        this.eras = localeData.eras;
        this.months = localeData.longMonthNames;
        this.shortMonths = localeData.shortMonthNames;
        this.weekdays = localeData.longWeekdayNames;
        this.shortWeekdays = localeData.shortWeekdayNames;
        this.longStandAloneMonths = localeData.longStandAloneMonthNames;
        this.shortStandAloneMonths = localeData.shortStandAloneMonthNames;
        this.longStandAloneWeekdays = localeData.longStandAloneWeekdayNames;
        this.shortStandAloneWeekdays = localeData.shortStandAloneWeekdayNames;
        // ---------- Original Method ----------
        //this.locale = locale;
        //this.localPatternChars = SimpleDateFormat.PATTERN_CHARS;
        //LocaleData localeData = LocaleData.get(locale);
        //this.ampms = localeData.amPm;
        //this.eras = localeData.eras;
        //this.months = localeData.longMonthNames;
        //this.shortMonths = localeData.shortMonthNames;
        //this.weekdays = localeData.longWeekdayNames;
        //this.shortWeekdays = localeData.shortWeekdayNames;
        //this.longStandAloneMonths = localeData.longStandAloneMonthNames;
        //this.shortStandAloneMonths = localeData.shortStandAloneMonthNames;
        //this.longStandAloneWeekdays = localeData.longStandAloneWeekdayNames;
        //this.shortStandAloneWeekdays = localeData.shortStandAloneWeekdayNames;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.033 -0400", hash_original_method = "D4F915DF738351C94CAE2742EF7502E4", hash_generated_method = "3B0C006621713707A650CA6671967E87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    synchronized String[][] internalZoneStrings() {
        {
            zoneStrings = TimeZones.getZoneStrings(locale);
        } //End block
        return (String[][])dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (zoneStrings == null) {
            //zoneStrings = TimeZones.getZoneStrings(locale);
        //}
        //return zoneStrings;
    }

    
        public static final DateFormatSymbols getInstance() {
        return getInstance(Locale.getDefault());
    }

    
        public static final DateFormatSymbols getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        return new DateFormatSymbols(locale);
    }

    
        public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDateFormatSymbolsLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.034 -0400", hash_original_method = "E120B4C8193E856C74E13A18ACCA4F59", hash_generated_method = "2F2220E6CC849FF0549EB4E1F18C0BCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(ois.dsTaint);
        ois.defaultReadObject();
        longStandAloneMonths = months;
        shortStandAloneMonths = shortMonths;
        longStandAloneWeekdays = weekdays;
        shortStandAloneWeekdays = shortWeekdays;
        // ---------- Original Method ----------
        //ois.defaultReadObject();
        //longStandAloneMonths = months;
        //shortStandAloneMonths = shortMonths;
        //longStandAloneWeekdays = weekdays;
        //shortStandAloneWeekdays = shortWeekdays;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.034 -0400", hash_original_method = "5B6B2CBEB972D19E7440DD4CD3FE992C", hash_generated_method = "44F20FE0A70BE9C6157477442C2FC6EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream oos) throws IOException {
        dsTaint.addTaint(oos.dsTaint);
        internalZoneStrings();
        oos.defaultWriteObject();
        // ---------- Original Method ----------
        //internalZoneStrings();
        //oos.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.034 -0400", hash_original_method = "8CF95CA28B578C998335BB5077A2FD41", hash_generated_method = "56A83F9FECADD3D5D9A2798799807F61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_645713368 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.035 -0400", hash_original_method = "94EAA904B302ADC25F17C85B071CCB2E", hash_generated_method = "D3E5D09156C240C40D25CD6E2B5AEB90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        DateFormatSymbols rhs;
        rhs = (DateFormatSymbols) object;
        boolean var43A3CC75E8E7CD6A467AD89DFA8053C6_52470605 = (localPatternChars.equals(rhs.localPatternChars) &&
                Arrays.equals(ampms, rhs.ampms) &&
                Arrays.equals(eras, rhs.eras) &&
                Arrays.equals(months, rhs.months) &&
                Arrays.equals(shortMonths, rhs.shortMonths) &&
                Arrays.equals(shortWeekdays, rhs.shortWeekdays) &&
                Arrays.equals(weekdays, rhs.weekdays) &&
                timeZoneStringsEqual(this, rhs));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (!(object instanceof DateFormatSymbols)) {
            //return false;
        //}
        //DateFormatSymbols rhs = (DateFormatSymbols) object;
        //return localPatternChars.equals(rhs.localPatternChars) &&
                //Arrays.equals(ampms, rhs.ampms) &&
                //Arrays.equals(eras, rhs.eras) &&
                //Arrays.equals(months, rhs.months) &&
                //Arrays.equals(shortMonths, rhs.shortMonths) &&
                //Arrays.equals(shortWeekdays, rhs.shortWeekdays) &&
                //Arrays.equals(weekdays, rhs.weekdays) &&
                //timeZoneStringsEqual(this, rhs);
    }

    
        private static boolean timeZoneStringsEqual(DateFormatSymbols lhs, DateFormatSymbols rhs) {
        if (lhs.zoneStrings == null && rhs.zoneStrings == null && lhs.locale.equals(rhs.locale)) {
            return true;
        }
        return Arrays.deepEquals(lhs.internalZoneStrings(), rhs.internalZoneStrings());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.035 -0400", hash_original_method = "315ADE63F84D6DC8A24FA118617E3BBD", hash_generated_method = "4EBBA7AA0DC3C17C6F8524915BE3C38A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var52DF4A8A61EC8149ACFA6AA449E35423_2093528914 = (getClass().getName() +
                "[amPmStrings=" + Arrays.toString(ampms) +
                ",customZoneStrings=" + customZoneStrings +
                ",eras=" + Arrays.toString(eras) +
                ",localPatternChars=" + localPatternChars +
                ",months=" + Arrays.toString(months) +
                ",shortMonths=" + Arrays.toString(shortMonths) +
                ",shortWeekdays=" + Arrays.toString(shortWeekdays) +
                ",weekdays=" + Arrays.toString(weekdays) +
                ",zoneStrings=[" + Arrays.toString(internalZoneStrings()[0]) + "...]" +
                "]");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getClass().getName() +
                //"[amPmStrings=" + Arrays.toString(ampms) +
                //",customZoneStrings=" + customZoneStrings +
                //",eras=" + Arrays.toString(eras) +
                //",localPatternChars=" + localPatternChars +
                //",months=" + Arrays.toString(months) +
                //",shortMonths=" + Arrays.toString(shortMonths) +
                //",shortWeekdays=" + Arrays.toString(shortWeekdays) +
                //",weekdays=" + Arrays.toString(weekdays) +
                //",zoneStrings=[" + Arrays.toString(internalZoneStrings()[0]) + "...]" +
                //"]";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.036 -0400", hash_original_method = "72991BA97E8B1C753B319ABB9AE6A911", hash_generated_method = "CC7B12220504A25112D7B71C74FF698C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getAmPmStrings() {
        String[] var57855B452C937C085B67D30105C480E5_629890272 = (ampms.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return ampms.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.036 -0400", hash_original_method = "BB9FAB8B89491AAFEBAE987DB8D7ADC9", hash_generated_method = "486CEB9FFBE18E93840101AB7481BE47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getEras() {
        String[] varA0B988F076913F91BBCED767CD303831_12758506 = (eras.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return eras.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.036 -0400", hash_original_method = "EEE83582BA421C729308A747699C1F8B", hash_generated_method = "65B42D62302597EAFC54AB064C9D7668")
    @DSModeled(DSC.SAFE)
    public String getLocalPatternChars() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return localPatternChars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.036 -0400", hash_original_method = "7E7D6ABDEA9D17B1FB9A10690E51D2C0", hash_generated_method = "EA54D9D9C167C2528A115000D251CB5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getMonths() {
        String[] var4F5EA16CB08E93215BF0F8822F097E6C_1504601829 = (months.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return months.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.036 -0400", hash_original_method = "B159D6A758F880417EB3F558245AB4C8", hash_generated_method = "497E5F4B3FB937CA1198490CF5A4F820")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getShortMonths() {
        String[] var30132FDCB20170AEB0C52CB299E11011_53894540 = (shortMonths.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return shortMonths.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.036 -0400", hash_original_method = "22143FF136703407DD6E3A76253CFCD4", hash_generated_method = "6056BEC4AB9E4B698F4D40E4D2163998")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getShortWeekdays() {
        String[] var72784B65A11C994930100BC9470E3E83_1932858503 = (shortWeekdays.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return shortWeekdays.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.037 -0400", hash_original_method = "9B40AAE5B3ACDD77762A9FF02C898A9B", hash_generated_method = "2446C306DDDFCEE2F7E44F78B8980D99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getWeekdays() {
        String[] var465683705B99F2263CE89A5E314C0FF7_261900237 = (weekdays.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return weekdays.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.037 -0400", hash_original_method = "BCD39B9ED22174061A8487583A862B84", hash_generated_method = "4C8C6CE4182F74B573F4565F813074BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[][] getZoneStrings() {
        String[][] var329334B2B606767E6E03ACA4C091DAD6_1291002400 = (clone2dStringArray(internalZoneStrings()));
        return (String[][])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return clone2dStringArray(internalZoneStrings());
    }

    
        private static String[][] clone2dStringArray(String[][] array) {
        String[][] result = new String[array.length][];
        for (int i = 0; i < array.length; ++i) {
            result[i] = array[i].clone();
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.051 -0400", hash_original_method = "092997CB42FACC03E21BAFCA0C446C08", hash_generated_method = "230C4784C116B559E217C5FAEB4DC26A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        String[][] zoneStrings;
        zoneStrings = internalZoneStrings();
        int hashCode;
        hashCode = localPatternChars.hashCode();
        {
            String element = ampms[0];
            {
                hashCode += element.hashCode();
            } //End block
        } //End collapsed parenthetic
        {
            String element = eras[0];
            {
                hashCode += element.hashCode();
            } //End block
        } //End collapsed parenthetic
        {
            String element = months[0];
            {
                hashCode += element.hashCode();
            } //End block
        } //End collapsed parenthetic
        {
            String element = shortMonths[0];
            {
                hashCode += element.hashCode();
            } //End block
        } //End collapsed parenthetic
        {
            String element = shortWeekdays[0];
            {
                hashCode += element.hashCode();
            } //End block
        } //End collapsed parenthetic
        {
            String element = weekdays[0];
            {
                hashCode += element.hashCode();
            } //End block
        } //End collapsed parenthetic
        {
            String[] element = zoneStrings[0];
            {
                {
                    int j;
                    j = 0;
                    {
                        {
                            hashCode += element[j].hashCode();
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.052 -0400", hash_original_method = "C567EF18556F46918292A2FE23B946BD", hash_generated_method = "686E484761CEE4CFF7308BD9439EF7A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAmPmStrings(String[] data) {
        dsTaint.addTaint(data[0]);
        ampms = data.clone();
        // ---------- Original Method ----------
        //ampms = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.052 -0400", hash_original_method = "144479B04BA5F93BAF1BE491BC6DCE8F", hash_generated_method = "A6931C60FB8EC3F86D30A307BFBA296A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEras(String[] data) {
        dsTaint.addTaint(data[0]);
        eras = data.clone();
        // ---------- Original Method ----------
        //eras = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.052 -0400", hash_original_method = "8CEB0632F689D252D9B5C4F3D13B9389", hash_generated_method = "2E1F198139C60D089AE7A570B7F88D4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLocalPatternChars(String data) {
        dsTaint.addTaint(data);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (data == null) {
            //throw new NullPointerException();
        //}
        //localPatternChars = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.052 -0400", hash_original_method = "FF561E75C563B528E8ADE2D7DEADB24B", hash_generated_method = "3E6711DCB900248516F5D28612985406")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMonths(String[] data) {
        dsTaint.addTaint(data[0]);
        months = data.clone();
        // ---------- Original Method ----------
        //months = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.052 -0400", hash_original_method = "6978BA653DCBEF5E7386E930F96F0A7F", hash_generated_method = "261128ACBC0B8AC7F2834430AB28FEC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShortMonths(String[] data) {
        dsTaint.addTaint(data[0]);
        shortMonths = data.clone();
        // ---------- Original Method ----------
        //shortMonths = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.052 -0400", hash_original_method = "D0F3596C1C1C0E88C3194208B883F56E", hash_generated_method = "D1A3BBB011E6FBE2DC89048D17F75A4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShortWeekdays(String[] data) {
        dsTaint.addTaint(data[0]);
        shortWeekdays = data.clone();
        // ---------- Original Method ----------
        //shortWeekdays = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.053 -0400", hash_original_method = "8E95286ADE938FE6BC77C4018461282B", hash_generated_method = "38FC79514FE37BB6EF9542A0344569AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWeekdays(String[] data) {
        dsTaint.addTaint(data[0]);
        weekdays = data.clone();
        // ---------- Original Method ----------
        //weekdays = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.056 -0400", hash_original_method = "97B75279909DC0B04FB710B3778B8E55", hash_generated_method = "AC4E167F22EDAB27594DCAACA92FB0B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setZoneStrings(String[][] zoneStrings) {
        dsTaint.addTaint(zoneStrings[0][0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            String[] row = zoneStrings[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(Arrays.toString(row) + ".length < 5");
                } //End block
            } //End block
        } //End collapsed parenthetic
        this.zoneStrings = clone2dStringArray(zoneStrings);
        this.customZoneStrings = true;
        // ---------- Original Method ----------
        //if (zoneStrings == null) {
            //throw new NullPointerException();
        //}
        //for (String[] row : zoneStrings) {
            //if (row.length < 5) {
                //throw new IllegalArgumentException(Arrays.toString(row) + ".length < 5");
            //}
        //}
        //this.zoneStrings = clone2dStringArray(zoneStrings);
        //this.customZoneStrings = true;
    }

    
    private static final long serialVersionUID = -5987973545549424702L;
}

