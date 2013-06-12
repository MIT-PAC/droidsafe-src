package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final long serialVersionUID = -5987973545549424702L;
    private String localPatternChars;
    String[] ampms, eras, months, shortMonths, shortWeekdays, weekdays;
    transient String[] longStandAloneMonths;
    transient String[] shortStandAloneMonths;
    transient String[] longStandAloneWeekdays;
    transient String[] shortStandAloneWeekdays;
    String[][] zoneStrings;
    transient boolean customZoneStrings;
    transient Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.961 -0400", hash_original_method = "5D59D1DAC1D60D67A4A902493CF704FB", hash_generated_method = "FA4B550802279D28FA8A98EFAD62B86C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DateFormatSymbols() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.961 -0400", hash_original_method = "10456A2571D0B6BA1CAC9BF624A7CB6F", hash_generated_method = "E42660DC7C68CBD9AC4604BCB7621C2C")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.961 -0400", hash_original_method = "D4F915DF738351C94CAE2742EF7502E4", hash_generated_method = "CD3BF8FCACA7F3EE77B0A26274DBF47C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.961 -0400", hash_original_method = "3EB23C2DF5EB21266FB298F464DCFFCF", hash_generated_method = "F45FB7B1AF681A36267EB5D88557BB70")
    public static final DateFormatSymbols getInstance() {
        return getInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.961 -0400", hash_original_method = "D58E0AC5713E6C4C00BE02A97E40DFE2", hash_generated_method = "C1D7872A04D2CAA85925056DDF6980C5")
    public static final DateFormatSymbols getInstance(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        return new DateFormatSymbols(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.961 -0400", hash_original_method = "256797DA5B6BE050E889700D67B9C760", hash_generated_method = "BF6BD0497C537B76BD8E15E7A25B3BB6")
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDateFormatSymbolsLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.961 -0400", hash_original_method = "E120B4C8193E856C74E13A18ACCA4F59", hash_generated_method = "4C8B24072F92CF59DD85924C55D8572E")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.961 -0400", hash_original_method = "5B6B2CBEB972D19E7440DD4CD3FE992C", hash_generated_method = "7776C6E2264E7D32A3A533778EED83C8")
    @DSModeled(DSC.SAFE)
    private void writeObject(ObjectOutputStream oos) throws IOException {
        dsTaint.addTaint(oos.dsTaint);
        internalZoneStrings();
        oos.defaultWriteObject();
        // ---------- Original Method ----------
        //internalZoneStrings();
        //oos.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.962 -0400", hash_original_method = "8CF95CA28B578C998335BB5077A2FD41", hash_generated_method = "E7590ADF1CBC53570A6A37A418F89018")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_1081059016 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError();
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.962 -0400", hash_original_method = "94EAA904B302ADC25F17C85B071CCB2E", hash_generated_method = "A425E9259703040724BA03349310F86F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        DateFormatSymbols rhs;
        rhs = (DateFormatSymbols) object;
        boolean var43A3CC75E8E7CD6A467AD89DFA8053C6_740602115 = (localPatternChars.equals(rhs.localPatternChars) &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.962 -0400", hash_original_method = "F298CD9B35B1A7217D8C6A751BA351CF", hash_generated_method = "6D82EC6CD78C81C886C19EE269806D0B")
    private static boolean timeZoneStringsEqual(DateFormatSymbols lhs, DateFormatSymbols rhs) {
        if (lhs.zoneStrings == null && rhs.zoneStrings == null && lhs.locale.equals(rhs.locale)) {
            return true;
        }
        return Arrays.deepEquals(lhs.internalZoneStrings(), rhs.internalZoneStrings());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.962 -0400", hash_original_method = "315ADE63F84D6DC8A24FA118617E3BBD", hash_generated_method = "AD22C3A8D669EB66FA7407A7636ADF58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var52DF4A8A61EC8149ACFA6AA449E35423_1594942424 = (getClass().getName() +
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.962 -0400", hash_original_method = "72991BA97E8B1C753B319ABB9AE6A911", hash_generated_method = "5A6E05893EB38B0522ADDAF3671736B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getAmPmStrings() {
        String[] var57855B452C937C085B67D30105C480E5_510544882 = (ampms.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return ampms.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.962 -0400", hash_original_method = "BB9FAB8B89491AAFEBAE987DB8D7ADC9", hash_generated_method = "6E0172A75CC4CE6DDCF416DAD37F3226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getEras() {
        String[] varA0B988F076913F91BBCED767CD303831_78216266 = (eras.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return eras.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.962 -0400", hash_original_method = "EEE83582BA421C729308A747699C1F8B", hash_generated_method = "1E6E3CA8C0D75D7C4D6C4AA732F17388")
    @DSModeled(DSC.SAFE)
    public String getLocalPatternChars() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return localPatternChars;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.962 -0400", hash_original_method = "7E7D6ABDEA9D17B1FB9A10690E51D2C0", hash_generated_method = "4B758C086AD0471892A734D1448DA30B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getMonths() {
        String[] var4F5EA16CB08E93215BF0F8822F097E6C_1637381934 = (months.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return months.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "B159D6A758F880417EB3F558245AB4C8", hash_generated_method = "CBCABC4A1B8F06C8E67D48CDFE2C2C7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getShortMonths() {
        String[] var30132FDCB20170AEB0C52CB299E11011_379365283 = (shortMonths.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return shortMonths.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "22143FF136703407DD6E3A76253CFCD4", hash_generated_method = "16596FFA2A13EE36F3AA8D68042C9068")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getShortWeekdays() {
        String[] var72784B65A11C994930100BC9470E3E83_1570466453 = (shortWeekdays.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return shortWeekdays.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "9B40AAE5B3ACDD77762A9FF02C898A9B", hash_generated_method = "8C2BC1A1F5EBE0F797C19FA5147B2935")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getWeekdays() {
        String[] var465683705B99F2263CE89A5E314C0FF7_1198331498 = (weekdays.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return weekdays.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "BCD39B9ED22174061A8487583A862B84", hash_generated_method = "A3E6003104331286C2740BD70D5924E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[][] getZoneStrings() {
        String[][] var329334B2B606767E6E03ACA4C091DAD6_154936288 = (clone2dStringArray(internalZoneStrings()));
        return (String[][])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return clone2dStringArray(internalZoneStrings());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "B34C69425BA0551BBDC4989EB36BB4B2", hash_generated_method = "27ACBDC93EFB0CA519EFEEE23A36DDEF")
    private static String[][] clone2dStringArray(String[][] array) {
        String[][] result = new String[array.length][];
        for (int i = 0; i < array.length; ++i) {
            result[i] = array[i].clone();
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "092997CB42FACC03E21BAFCA0C446C08", hash_generated_method = "A467747EFF77B0954A2BD08408BA7963")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "C567EF18556F46918292A2FE23B946BD", hash_generated_method = "57E4E4D62B4F9FAE429C6358EFD86D3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAmPmStrings(String[] data) {
        dsTaint.addTaint(data);
        ampms = data.clone();
        // ---------- Original Method ----------
        //ampms = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "144479B04BA5F93BAF1BE491BC6DCE8F", hash_generated_method = "AEFFBF586ED57025A7F1B92C113F1A31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEras(String[] data) {
        dsTaint.addTaint(data);
        eras = data.clone();
        // ---------- Original Method ----------
        //eras = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "8CEB0632F689D252D9B5C4F3D13B9389", hash_generated_method = "00DF4191F468E7D12C5BE744FE9138EA")
    @DSModeled(DSC.SAFE)
    public void setLocalPatternChars(String data) {
        dsTaint.addTaint(data);
        {
            throw new NullPointerException();
        } //End block
        // ---------- Original Method ----------
        //if (data == null) {
            //throw new NullPointerException();
        //}
        //localPatternChars = data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "FF561E75C563B528E8ADE2D7DEADB24B", hash_generated_method = "AAEC55927EAB9D68EB1061A45EE54DB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMonths(String[] data) {
        dsTaint.addTaint(data);
        months = data.clone();
        // ---------- Original Method ----------
        //months = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "6978BA653DCBEF5E7386E930F96F0A7F", hash_generated_method = "7B73FD082B9C379A268C594D5F0D2988")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShortMonths(String[] data) {
        dsTaint.addTaint(data);
        shortMonths = data.clone();
        // ---------- Original Method ----------
        //shortMonths = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "D0F3596C1C1C0E88C3194208B883F56E", hash_generated_method = "66505BFB15F3C2FE8995FE6D78B67087")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setShortWeekdays(String[] data) {
        dsTaint.addTaint(data);
        shortWeekdays = data.clone();
        // ---------- Original Method ----------
        //shortWeekdays = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.963 -0400", hash_original_method = "8E95286ADE938FE6BC77C4018461282B", hash_generated_method = "8A30108E63FA986ADC6617EE24C6A6A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setWeekdays(String[] data) {
        dsTaint.addTaint(data);
        weekdays = data.clone();
        // ---------- Original Method ----------
        //weekdays = data.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.964 -0400", hash_original_method = "97B75279909DC0B04FB710B3778B8E55", hash_generated_method = "25CE0EDCDBD2AB917F9A2CF7CB674074")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setZoneStrings(String[][] zoneStrings) {
        dsTaint.addTaint(zoneStrings[0]);
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

    
}


