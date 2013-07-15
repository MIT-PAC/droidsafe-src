package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.232 -0400", hash_original_field = "F93C182ABF27C94E3A5B7A9F01CA9F60", hash_generated_field = "B3AAF3207AD6EC4015B2989CC1E896AA")

    private String localPatternChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.232 -0400", hash_original_field = "EE109C8604E524BC6D9E0C2587FEE2D8", hash_generated_field = "E9E36152E2B2CCE2D2DF7029FCA0E0AA")

    String[] ampms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.232 -0400", hash_original_field = "D026F0E07E8726FB52E3CC3E3D0D1375", hash_generated_field = "E0691941E69B86E10AC79FC9DFFC272D")

    String[] eras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.232 -0400", hash_original_field = "DA36CFAF48B9E19896E23E1207040D1E", hash_generated_field = "86F5593447744AB0D2426E4B6C92C689")

    String[] months;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.232 -0400", hash_original_field = "7CFA6EB2E9F41003AC5C121106DC32C1", hash_generated_field = "0DF3792D47225D65FC03CC1EE597502D")

    String[] shortMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.233 -0400", hash_original_field = "F232077D652EDEE073A547D6F8C9DBAA", hash_generated_field = "9FF057C20818DAD49F561EBB25C5D177")

    String[] shortWeekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.233 -0400", hash_original_field = "92B9604FFB8FE10577DE981BE625A6D1", hash_generated_field = "F5A81D14F7FC350336EA1CDD45134728")

    String[] weekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.233 -0400", hash_original_field = "B121095E75CAC704B42EE21332C700E8", hash_generated_field = "402565001AFCC4D0F913CB823E99BBB5")

    transient String[] longStandAloneMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.233 -0400", hash_original_field = "B8789910F74B7F8F96F476446A140202", hash_generated_field = "D3C2FF472DF92A6DB563114884CB2A55")

    transient String[] shortStandAloneMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.233 -0400", hash_original_field = "1FFCA875E027B7EFD687FE2C578690E6", hash_generated_field = "A8C4ABDEC24C4081D6DC2DD240794CBF")

    transient String[] longStandAloneWeekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.233 -0400", hash_original_field = "EDEEAFC9758166996DB88A34369B7E82", hash_generated_field = "5A1974ABC298872CE58EE882C634EEA7")

    transient String[] shortStandAloneWeekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.233 -0400", hash_original_field = "D0872812CDF2B7417CF77B378EBAABF1", hash_generated_field = "7D22C959C8C5C0204FC82BE4EE6AC154")

    String[][] zoneStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.233 -0400", hash_original_field = "7B7649AEDE091E38288525663FD40113", hash_generated_field = "95929A023295B932C341AB00B66AEC36")

    transient boolean customZoneStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.233 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "B588E29C12BDB46B326FE934DDE5D1D8")

    transient Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.234 -0400", hash_original_method = "5D59D1DAC1D60D67A4A902493CF704FB", hash_generated_method = "C859C77BBE7800A29A0C963324C5BAF5")
    public  DateFormatSymbols() {
        this(Locale.getDefault());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.236 -0400", hash_original_method = "10456A2571D0B6BA1CAC9BF624A7CB6F", hash_generated_method = "813E0D82CEB1AAC3D46F84D0B9C1DFBC")
    public  DateFormatSymbols(Locale locale) {
        this.locale = locale;
        this.localPatternChars = SimpleDateFormat.PATTERN_CHARS;
        LocaleData localeData = LocaleData.get(locale);
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.236 -0400", hash_original_method = "D4F915DF738351C94CAE2742EF7502E4", hash_generated_method = "BF764EE9285204E50158CF6490D774B7")
    synchronized String[][] internalZoneStrings() {
    if(zoneStrings == null)        
        {
            zoneStrings = TimeZones.getZoneStrings(locale);
        } //End block
String[][] varEBF7F37D366F40A93466E6A48C2F7696_1127718478 =         zoneStrings;
        varEBF7F37D366F40A93466E6A48C2F7696_1127718478.addTaint(taint);
        return varEBF7F37D366F40A93466E6A48C2F7696_1127718478;
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

    
        @DSModeled(DSC.SAFE)
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableDateFormatSymbolsLocales();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.238 -0400", hash_original_method = "E120B4C8193E856C74E13A18ACCA4F59", hash_generated_method = "388A6D5AE7F5C74E8148031056CF63C3")
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        addTaint(ois.getTaint());
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.238 -0400", hash_original_method = "5B6B2CBEB972D19E7440DD4CD3FE992C", hash_generated_method = "2E8A29414A0BE9C0F4783192240C2E7F")
    private void writeObject(ObjectOutputStream oos) throws IOException {
        addTaint(oos.getTaint());
        internalZoneStrings();
        oos.defaultWriteObject();
        // ---------- Original Method ----------
        //internalZoneStrings();
        //oos.defaultWriteObject();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.238 -0400", hash_original_method = "8CF95CA28B578C998335BB5077A2FD41", hash_generated_method = "DC5685B40D0FFCA709F4CDC4E0BCFD31")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_824035428 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_824035428.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_824035428;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA81442E36297E737EB908877E58260E8_283113260 = new AssertionError();
            varA81442E36297E737EB908877E58260E8_283113260.addTaint(taint);
            throw varA81442E36297E737EB908877E58260E8_283113260;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.239 -0400", hash_original_method = "94EAA904B302ADC25F17C85B071CCB2E", hash_generated_method = "B38E75F2C4531114B7A555ACA0EDAC47")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_745956051 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1508767943 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1508767943;
        } //End block
    if(!(object instanceof DateFormatSymbols))        
        {
            boolean var68934A3E9455FA72420237EB05902327_558685164 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_618336909 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_618336909;
        } //End block
        DateFormatSymbols rhs = (DateFormatSymbols) object;
        boolean var6D05BC7ACB9511718BFEB3CBBE255AFB_1657904367 = (localPatternChars.equals(rhs.localPatternChars) &&
                Arrays.equals(ampms, rhs.ampms) &&
                Arrays.equals(eras, rhs.eras) &&
                Arrays.equals(months, rhs.months) &&
                Arrays.equals(shortMonths, rhs.shortMonths) &&
                Arrays.equals(shortWeekdays, rhs.shortWeekdays) &&
                Arrays.equals(weekdays, rhs.weekdays) &&
                timeZoneStringsEqual(this, rhs));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_251885468 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_251885468;
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

    
        @DSModeled(DSC.SAFE)
    private static boolean timeZoneStringsEqual(DateFormatSymbols lhs, DateFormatSymbols rhs) {
        if (lhs.zoneStrings == null && rhs.zoneStrings == null && lhs.locale.equals(rhs.locale)) {
            return true;
        }
        return Arrays.deepEquals(lhs.internalZoneStrings(), rhs.internalZoneStrings());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.240 -0400", hash_original_method = "315ADE63F84D6DC8A24FA118617E3BBD", hash_generated_method = "03A8E2920FB47F409268625FC3B14819")
    @Override
    public String toString() {
String var44744F90A01F966D0732DA6F42726EB9_1008229903 =         getClass().getName() +
                "[amPmStrings=" + Arrays.toString(ampms) +
                ",customZoneStrings=" + customZoneStrings +
                ",eras=" + Arrays.toString(eras) +
                ",localPatternChars=" + localPatternChars +
                ",months=" + Arrays.toString(months) +
                ",shortMonths=" + Arrays.toString(shortMonths) +
                ",shortWeekdays=" + Arrays.toString(shortWeekdays) +
                ",weekdays=" + Arrays.toString(weekdays) +
                ",zoneStrings=[" + Arrays.toString(internalZoneStrings()[0]) + "...]" +
                "]";
        var44744F90A01F966D0732DA6F42726EB9_1008229903.addTaint(taint);
        return var44744F90A01F966D0732DA6F42726EB9_1008229903;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.241 -0400", hash_original_method = "72991BA97E8B1C753B319ABB9AE6A911", hash_generated_method = "F6AD542B5FE71929863D5A7A7E1623CE")
    public String[] getAmPmStrings() {
String[] var187BA9029B00F0445A3DC7BB68E23002_1263623438 =         ampms.clone();
        var187BA9029B00F0445A3DC7BB68E23002_1263623438.addTaint(taint);
        return var187BA9029B00F0445A3DC7BB68E23002_1263623438;
        // ---------- Original Method ----------
        //return ampms.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.241 -0400", hash_original_method = "BB9FAB8B89491AAFEBAE987DB8D7ADC9", hash_generated_method = "78E469405CAD4F12BDB90EBBEF0A5107")
    public String[] getEras() {
String[] varC95686BD3F7D0B62DEC47BF195BF2457_686550201 =         eras.clone();
        varC95686BD3F7D0B62DEC47BF195BF2457_686550201.addTaint(taint);
        return varC95686BD3F7D0B62DEC47BF195BF2457_686550201;
        // ---------- Original Method ----------
        //return eras.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.241 -0400", hash_original_method = "EEE83582BA421C729308A747699C1F8B", hash_generated_method = "A0107DA6DA095048DA6AB79BF61361AE")
    public String getLocalPatternChars() {
String varBBC83F2BD84C9E23C318510579B07741_770013521 =         localPatternChars;
        varBBC83F2BD84C9E23C318510579B07741_770013521.addTaint(taint);
        return varBBC83F2BD84C9E23C318510579B07741_770013521;
        // ---------- Original Method ----------
        //return localPatternChars;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.241 -0400", hash_original_method = "7E7D6ABDEA9D17B1FB9A10690E51D2C0", hash_generated_method = "5896008258579DA5808ACB6E12E7F31A")
    public String[] getMonths() {
String[] var95461DBD843343683D7F90F0303F7FDB_1465604726 =         months.clone();
        var95461DBD843343683D7F90F0303F7FDB_1465604726.addTaint(taint);
        return var95461DBD843343683D7F90F0303F7FDB_1465604726;
        // ---------- Original Method ----------
        //return months.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.242 -0400", hash_original_method = "B159D6A758F880417EB3F558245AB4C8", hash_generated_method = "1FC2B0356C34711A267B0375D3A778D6")
    public String[] getShortMonths() {
String[] varD14524266F46B71B9FFD2556D8B9DAFC_59780274 =         shortMonths.clone();
        varD14524266F46B71B9FFD2556D8B9DAFC_59780274.addTaint(taint);
        return varD14524266F46B71B9FFD2556D8B9DAFC_59780274;
        // ---------- Original Method ----------
        //return shortMonths.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.242 -0400", hash_original_method = "22143FF136703407DD6E3A76253CFCD4", hash_generated_method = "D19BCDBB2E19B56AF6FCF0844492691B")
    public String[] getShortWeekdays() {
String[] varCD29BDDDC93420986D9262B39A315778_684973641 =         shortWeekdays.clone();
        varCD29BDDDC93420986D9262B39A315778_684973641.addTaint(taint);
        return varCD29BDDDC93420986D9262B39A315778_684973641;
        // ---------- Original Method ----------
        //return shortWeekdays.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.242 -0400", hash_original_method = "9B40AAE5B3ACDD77762A9FF02C898A9B", hash_generated_method = "B7E8E69621E0E15A5AB67CD38072C18D")
    public String[] getWeekdays() {
String[] var7831241F010A916B97EC18A5F21826E3_151508603 =         weekdays.clone();
        var7831241F010A916B97EC18A5F21826E3_151508603.addTaint(taint);
        return var7831241F010A916B97EC18A5F21826E3_151508603;
        // ---------- Original Method ----------
        //return weekdays.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.243 -0400", hash_original_method = "BCD39B9ED22174061A8487583A862B84", hash_generated_method = "6D3C315D33BB2C34B7998F2D917A28C4")
    public String[][] getZoneStrings() {
String[][] varD69B750B3B3DE2784BD39EED4D0C28EC_2012995073 =         clone2dStringArray(internalZoneStrings());
        varD69B750B3B3DE2784BD39EED4D0C28EC_2012995073.addTaint(taint);
        return varD69B750B3B3DE2784BD39EED4D0C28EC_2012995073;
        // ---------- Original Method ----------
        //return clone2dStringArray(internalZoneStrings());
    }

    
        @DSModeled(DSC.SAFE)
    private static String[][] clone2dStringArray(String[][] array) {
        String[][] result = new String[array.length][];
        for (int i = 0; i < array.length; ++i) {
            result[i] = array[i].clone();
        }
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.244 -0400", hash_original_method = "092997CB42FACC03E21BAFCA0C446C08", hash_generated_method = "AE5BDDE7187A581FA59BCAF8971110CB")
    @Override
    public int hashCode() {
        String[][] zoneStrings = internalZoneStrings();
        int hashCode;
        hashCode = localPatternChars.hashCode();
for(String element : ampms)
        {
            hashCode += element.hashCode();
        } //End block
for(String element : eras)
        {
            hashCode += element.hashCode();
        } //End block
for(String element : months)
        {
            hashCode += element.hashCode();
        } //End block
for(String element : shortMonths)
        {
            hashCode += element.hashCode();
        } //End block
for(String element : shortWeekdays)
        {
            hashCode += element.hashCode();
        } //End block
for(String element : weekdays)
        {
            hashCode += element.hashCode();
        } //End block
for(String[] element : zoneStrings)
        {
for(int j = 0;j < element.length;j++)
            {
    if(element[j] != null)                
                {
                    hashCode += element[j].hashCode();
                } //End block
            } //End block
        } //End block
        int var550D1CC054A1B23A411DDDA46FD64811_1066370792 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989921280 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989921280;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.245 -0400", hash_original_method = "C567EF18556F46918292A2FE23B946BD", hash_generated_method = "DE73325A9EFE1C7D0ECD66FCF4A02234")
    public void setAmPmStrings(String[] data) {
        ampms = data.clone();
        // ---------- Original Method ----------
        //ampms = data.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.246 -0400", hash_original_method = "144479B04BA5F93BAF1BE491BC6DCE8F", hash_generated_method = "CD7C7E57D9DD7095EEB50004EB8BC83B")
    public void setEras(String[] data) {
        eras = data.clone();
        // ---------- Original Method ----------
        //eras = data.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.246 -0400", hash_original_method = "8CEB0632F689D252D9B5C4F3D13B9389", hash_generated_method = "853628E4DDAE2882FC4AF8ED5FD2CC40")
    public void setLocalPatternChars(String data) {
    if(data == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_753151712 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_753151712.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_753151712;
        } //End block
        localPatternChars = data;
        // ---------- Original Method ----------
        //if (data == null) {
            //throw new NullPointerException();
        //}
        //localPatternChars = data;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.247 -0400", hash_original_method = "FF561E75C563B528E8ADE2D7DEADB24B", hash_generated_method = "B78349A0B99F735427CA1D403EEE1075")
    public void setMonths(String[] data) {
        months = data.clone();
        // ---------- Original Method ----------
        //months = data.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.247 -0400", hash_original_method = "6978BA653DCBEF5E7386E930F96F0A7F", hash_generated_method = "E3952CDA692F3B23A229F9D600872234")
    public void setShortMonths(String[] data) {
        shortMonths = data.clone();
        // ---------- Original Method ----------
        //shortMonths = data.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.248 -0400", hash_original_method = "D0F3596C1C1C0E88C3194208B883F56E", hash_generated_method = "6D95734F7E1EFF70EDF04DB57B96047A")
    public void setShortWeekdays(String[] data) {
        shortWeekdays = data.clone();
        // ---------- Original Method ----------
        //shortWeekdays = data.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.248 -0400", hash_original_method = "8E95286ADE938FE6BC77C4018461282B", hash_generated_method = "5347FE4595A98E521296DAD0F934B3AD")
    public void setWeekdays(String[] data) {
        weekdays = data.clone();
        // ---------- Original Method ----------
        //weekdays = data.clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.249 -0400", hash_original_method = "97B75279909DC0B04FB710B3778B8E55", hash_generated_method = "B99944000A23CE97AA02F25E0141BDC7")
    public void setZoneStrings(String[][] zoneStrings) {
    if(zoneStrings == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_759636577 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_759636577.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_759636577;
        } //End block
for(String[] row : zoneStrings)
        {
    if(row.length < 5)            
            {
                IllegalArgumentException var1327A3DDDA9865284628E77B608719FF_2107816657 = new IllegalArgumentException(Arrays.toString(row) + ".length < 5");
                var1327A3DDDA9865284628E77B608719FF_2107816657.addTaint(taint);
                throw var1327A3DDDA9865284628E77B608719FF_2107816657;
            } //End block
        } //End block
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.249 -0400", hash_original_field = "7856CC4F9AD25C25527045AAE8078678", hash_generated_field = "3A9F42BB82D57C84015671E87240C88B")

    private static final long serialVersionUID = -5987973545549424702L;
}

