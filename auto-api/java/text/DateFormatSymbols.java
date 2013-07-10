package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "F93C182ABF27C94E3A5B7A9F01CA9F60", hash_generated_field = "B3AAF3207AD6EC4015B2989CC1E896AA")

    private String localPatternChars;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "EE109C8604E524BC6D9E0C2587FEE2D8", hash_generated_field = "E9E36152E2B2CCE2D2DF7029FCA0E0AA")

    String[] ampms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "D026F0E07E8726FB52E3CC3E3D0D1375", hash_generated_field = "E0691941E69B86E10AC79FC9DFFC272D")

    String[] eras;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "DA36CFAF48B9E19896E23E1207040D1E", hash_generated_field = "86F5593447744AB0D2426E4B6C92C689")

    String[] months;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "7CFA6EB2E9F41003AC5C121106DC32C1", hash_generated_field = "0DF3792D47225D65FC03CC1EE597502D")

    String[] shortMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "F232077D652EDEE073A547D6F8C9DBAA", hash_generated_field = "9FF057C20818DAD49F561EBB25C5D177")

    String[] shortWeekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "92B9604FFB8FE10577DE981BE625A6D1", hash_generated_field = "F5A81D14F7FC350336EA1CDD45134728")

    String[] weekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "B121095E75CAC704B42EE21332C700E8", hash_generated_field = "402565001AFCC4D0F913CB823E99BBB5")

    transient String[] longStandAloneMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "B8789910F74B7F8F96F476446A140202", hash_generated_field = "D3C2FF472DF92A6DB563114884CB2A55")

    transient String[] shortStandAloneMonths;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "1FFCA875E027B7EFD687FE2C578690E6", hash_generated_field = "A8C4ABDEC24C4081D6DC2DD240794CBF")

    transient String[] longStandAloneWeekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "EDEEAFC9758166996DB88A34369B7E82", hash_generated_field = "5A1974ABC298872CE58EE882C634EEA7")

    transient String[] shortStandAloneWeekdays;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "D0872812CDF2B7417CF77B378EBAABF1", hash_generated_field = "7D22C959C8C5C0204FC82BE4EE6AC154")

    String[][] zoneStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "7B7649AEDE091E38288525663FD40113", hash_generated_field = "95929A023295B932C341AB00B66AEC36")

    transient boolean customZoneStrings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "B588E29C12BDB46B326FE934DDE5D1D8")

    transient Locale locale;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.989 -0400", hash_original_method = "5D59D1DAC1D60D67A4A902493CF704FB", hash_generated_method = "C859C77BBE7800A29A0C963324C5BAF5")
    public  DateFormatSymbols() {
        this(Locale.getDefault());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.990 -0400", hash_original_method = "10456A2571D0B6BA1CAC9BF624A7CB6F", hash_generated_method = "813E0D82CEB1AAC3D46F84D0B9C1DFBC")
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.990 -0400", hash_original_method = "D4F915DF738351C94CAE2742EF7502E4", hash_generated_method = "7610163F579F202F9DD2A0B993FE3E5B")
    synchronized String[][] internalZoneStrings() {
        String[][] varB4EAC82CA7396A68D541C85D26508E83_38855845 = null; 
        {
            zoneStrings = TimeZones.getZoneStrings(locale);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_38855845 = zoneStrings;
        varB4EAC82CA7396A68D541C85D26508E83_38855845.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_38855845;
        
        
            
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.991 -0400", hash_original_method = "E120B4C8193E856C74E13A18ACCA4F59", hash_generated_method = "BD7C4E57C037C4434DB7EA8243AC64AF")
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        longStandAloneMonths = months;
        shortStandAloneMonths = shortMonths;
        longStandAloneWeekdays = weekdays;
        shortStandAloneWeekdays = shortWeekdays;
        addTaint(ois.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.991 -0400", hash_original_method = "5B6B2CBEB972D19E7440DD4CD3FE992C", hash_generated_method = "B537106420CC00C4A69A93EF5AA315BF")
    private void writeObject(ObjectOutputStream oos) throws IOException {
        internalZoneStrings();
        oos.defaultWriteObject();
        addTaint(oos.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.992 -0400", hash_original_method = "8CF95CA28B578C998335BB5077A2FD41", hash_generated_method = "CAF2BFEEAF580432A0A61586A2204A54")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1463048722 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1463048722 = super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1463048722.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1463048722;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.993 -0400", hash_original_method = "94EAA904B302ADC25F17C85B071CCB2E", hash_generated_method = "AEB39D0B295F246E551F994ECEBE67C9")
    @Override
    public boolean equals(Object object) {
        DateFormatSymbols rhs = (DateFormatSymbols) object;
        boolean var43A3CC75E8E7CD6A467AD89DFA8053C6_1255765310 = (localPatternChars.equals(rhs.localPatternChars) &&
                Arrays.equals(ampms, rhs.ampms) &&
                Arrays.equals(eras, rhs.eras) &&
                Arrays.equals(months, rhs.months) &&
                Arrays.equals(shortMonths, rhs.shortMonths) &&
                Arrays.equals(shortWeekdays, rhs.shortWeekdays) &&
                Arrays.equals(weekdays, rhs.weekdays) &&
                timeZoneStringsEqual(this, rhs));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_669338959 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_669338959;
        
        
            
        
        
            
        
        
        
                
                
                
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean timeZoneStringsEqual(DateFormatSymbols lhs, DateFormatSymbols rhs) {
        if (lhs.zoneStrings == null && rhs.zoneStrings == null && lhs.locale.equals(rhs.locale)) {
            return true;
        }
        return Arrays.deepEquals(lhs.internalZoneStrings(), rhs.internalZoneStrings());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.994 -0400", hash_original_method = "315ADE63F84D6DC8A24FA118617E3BBD", hash_generated_method = "6F2D78ABF344CE8109A4BFDC8ED09CF5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_440184802 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_440184802 = getClass().getName() +
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
        varB4EAC82CA7396A68D541C85D26508E83_440184802.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_440184802;
        
        
                
                
                
                
                
                
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.995 -0400", hash_original_method = "72991BA97E8B1C753B319ABB9AE6A911", hash_generated_method = "022626189362F2CC5B15FC8034D958CA")
    public String[] getAmPmStrings() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2131904176 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2131904176 = ampms.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2131904176.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2131904176;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.995 -0400", hash_original_method = "BB9FAB8B89491AAFEBAE987DB8D7ADC9", hash_generated_method = "4E61D4D771897C7A02FAA6AE79FD9DC7")
    public String[] getEras() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1009270673 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1009270673 = eras.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1009270673.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1009270673;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.996 -0400", hash_original_method = "EEE83582BA421C729308A747699C1F8B", hash_generated_method = "F71E31181AF2FC8F8B1818DCE2EBA955")
    public String getLocalPatternChars() {
        String varB4EAC82CA7396A68D541C85D26508E83_1257255169 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1257255169 = localPatternChars;
        varB4EAC82CA7396A68D541C85D26508E83_1257255169.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1257255169;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.996 -0400", hash_original_method = "7E7D6ABDEA9D17B1FB9A10690E51D2C0", hash_generated_method = "B71F19AB82AE1D7E9E2D41D34D978089")
    public String[] getMonths() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1454478576 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1454478576 = months.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1454478576.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1454478576;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.997 -0400", hash_original_method = "B159D6A758F880417EB3F558245AB4C8", hash_generated_method = "95FC540B8BABEC8D3E1AE7198E08549E")
    public String[] getShortMonths() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1172089258 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1172089258 = shortMonths.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1172089258.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1172089258;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.997 -0400", hash_original_method = "22143FF136703407DD6E3A76253CFCD4", hash_generated_method = "2847206E3B34F6FD88460E9EF34E5E71")
    public String[] getShortWeekdays() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_984208017 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_984208017 = shortWeekdays.clone();
        varB4EAC82CA7396A68D541C85D26508E83_984208017.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_984208017;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.997 -0400", hash_original_method = "9B40AAE5B3ACDD77762A9FF02C898A9B", hash_generated_method = "5B56929A06CBB988FBA94B2A6682B878")
    public String[] getWeekdays() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1352932110 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1352932110 = weekdays.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1352932110.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1352932110;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.998 -0400", hash_original_method = "BCD39B9ED22174061A8487583A862B84", hash_generated_method = "561F6122932D5D1F324F88973ACD374D")
    public String[][] getZoneStrings() {
        String[][] varB4EAC82CA7396A68D541C85D26508E83_1633011251 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1633011251 = clone2dStringArray(internalZoneStrings());
        varB4EAC82CA7396A68D541C85D26508E83_1633011251.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1633011251;
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.010 -0400", hash_original_method = "092997CB42FACC03E21BAFCA0C446C08", hash_generated_method = "5809BA424B2C9CE3E7792F3F3EF12E1F")
    @Override
    public int hashCode() {
        String[][] zoneStrings = internalZoneStrings();
        int hashCode;
        hashCode = localPatternChars.hashCode();
        {
            String element = ampms[0];
            {
                hashCode += element.hashCode();
            } 
        } 
        {
            String element = eras[0];
            {
                hashCode += element.hashCode();
            } 
        } 
        {
            String element = months[0];
            {
                hashCode += element.hashCode();
            } 
        } 
        {
            String element = shortMonths[0];
            {
                hashCode += element.hashCode();
            } 
        } 
        {
            String element = shortWeekdays[0];
            {
                hashCode += element.hashCode();
            } 
        } 
        {
            String element = weekdays[0];
            {
                hashCode += element.hashCode();
            } 
        } 
        {
            String[] element = zoneStrings[0];
            {
                {
                    int j = 0;
                    {
                        {
                            hashCode += element[j].hashCode();
                        } 
                    } 
                } 
            } 
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883577063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1883577063;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.011 -0400", hash_original_method = "C567EF18556F46918292A2FE23B946BD", hash_generated_method = "DE73325A9EFE1C7D0ECD66FCF4A02234")
    public void setAmPmStrings(String[] data) {
        ampms = data.clone();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.011 -0400", hash_original_method = "144479B04BA5F93BAF1BE491BC6DCE8F", hash_generated_method = "CD7C7E57D9DD7095EEB50004EB8BC83B")
    public void setEras(String[] data) {
        eras = data.clone();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.011 -0400", hash_original_method = "8CEB0632F689D252D9B5C4F3D13B9389", hash_generated_method = "649DE06FC38CF0E23444049A52DF75E1")
    public void setLocalPatternChars(String data) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        localPatternChars = data;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.012 -0400", hash_original_method = "FF561E75C563B528E8ADE2D7DEADB24B", hash_generated_method = "B78349A0B99F735427CA1D403EEE1075")
    public void setMonths(String[] data) {
        months = data.clone();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.012 -0400", hash_original_method = "6978BA653DCBEF5E7386E930F96F0A7F", hash_generated_method = "E3952CDA692F3B23A229F9D600872234")
    public void setShortMonths(String[] data) {
        shortMonths = data.clone();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.013 -0400", hash_original_method = "D0F3596C1C1C0E88C3194208B883F56E", hash_generated_method = "6D95734F7E1EFF70EDF04DB57B96047A")
    public void setShortWeekdays(String[] data) {
        shortWeekdays = data.clone();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.014 -0400", hash_original_method = "8E95286ADE938FE6BC77C4018461282B", hash_generated_method = "5347FE4595A98E521296DAD0F934B3AD")
    public void setWeekdays(String[] data) {
        weekdays = data.clone();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.022 -0400", hash_original_method = "97B75279909DC0B04FB710B3778B8E55", hash_generated_method = "1A0E814DB648838A7E638C7F5720FCE2")
    public void setZoneStrings(String[][] zoneStrings) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        {
            String[] row = zoneStrings[0];
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(Arrays.toString(row) + ".length < 5");
                } 
            } 
        } 
        this.zoneStrings = clone2dStringArray(zoneStrings);
        this.customZoneStrings = true;
        
        
            
        
        
            
                
            
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.022 -0400", hash_original_field = "7856CC4F9AD25C25527045AAE8078678", hash_generated_field = "3A9F42BB82D57C84015671E87240C88B")

    private static final long serialVersionUID = -5987973545549424702L;
}

