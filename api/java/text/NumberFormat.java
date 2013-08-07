package java.text;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;

import libcore.icu.ICU;
import libcore.icu.LocaleData;





public abstract class NumberFormat extends Format {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "A8297487699539E2F81FB26EFCAE4926", hash_generated_field = "BA0A3C716E8972AFDE20CB1849A202C5")

    private boolean groupingUsed = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "1B0360C18BB931B3601366AE793BA160", hash_generated_field = "B8A513C59F0250621283D2DE9187B85C")

    private boolean parseIntegerOnly = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "1B64E19FB2AD8A96A43F15BDB5C977BC", hash_generated_field = "A77FA56511D100D0E8370E5AA6626E49")

    private int maximumIntegerDigits = 40;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "7EB911BA8BD0D322029A9FDAB57505FC", hash_generated_field = "7C07B0CC78175F8B345B2FD942DE4829")

    private int minimumIntegerDigits = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "F8E2B2219E9D1D35671A6FF9D8DD023B", hash_generated_field = "9031A923FB51BEDA5191306AA866610E")

    private int maximumFractionDigits = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.829 -0400", hash_original_field = "81C5674E758DBE4CDDC7554C3C6402D5", hash_generated_field = "A2436992C475A167FCC16C9C61FB2AEF")

    private int minimumFractionDigits = 0;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.830 -0400", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "4471CB6ABEB340D260FD4A286AE4BB26")
    protected  NumberFormat() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.830 -0400", hash_original_method = "323EA29B58059AEF6BA9ED0328A60A9B", hash_generated_method = "4CF50CC29D18D1E367A7A42D167B882F")
    @Override
    public Object clone() {
Object var46F3A0D86742C1D6E099C2B166941A33_1457341309 =         super.clone();
        var46F3A0D86742C1D6E099C2B166941A33_1457341309.addTaint(taint);
        return var46F3A0D86742C1D6E099C2B166941A33_1457341309;
        // ---------- Original Method ----------
        //return super.clone();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.830 -0400", hash_original_method = "CF2A5131022F3DE945450C291D454139", hash_generated_method = "3758C497942B819C2BA45C3BE32FD954")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(object == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_837146248 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_117162224 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_117162224;
        } //End block
        if(!(object instanceof NumberFormat))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1540337364 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1465131567 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1465131567;
        } //End block
        NumberFormat obj = (NumberFormat) object;
        boolean varCAB3FEED026BECE04342C398C2249A2C_572330695 = (groupingUsed == obj.groupingUsed
                && parseIntegerOnly == obj.parseIntegerOnly
                && maximumFractionDigits == obj.maximumFractionDigits
                && maximumIntegerDigits == obj.maximumIntegerDigits
                && minimumFractionDigits == obj.minimumFractionDigits
                && minimumIntegerDigits == obj.minimumIntegerDigits);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1920013425 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1920013425;
        // ---------- Original Method ----------
        //if (object == this) {
            //return true;
        //}
        //if (!(object instanceof NumberFormat)) {
            //return false;
        //}
        //NumberFormat obj = (NumberFormat) object;
        //return groupingUsed == obj.groupingUsed
                //&& parseIntegerOnly == obj.parseIntegerOnly
                //&& maximumFractionDigits == obj.maximumFractionDigits
                //&& maximumIntegerDigits == obj.maximumIntegerDigits
                //&& minimumFractionDigits == obj.minimumFractionDigits
                //&& minimumIntegerDigits == obj.minimumIntegerDigits;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.831 -0400", hash_original_method = "D30D6926B1574E72997696CC4AACA867", hash_generated_method = "0B6ABAFF776A7BF8E3F771A99D23AEF1")
    public final String format(double value) {
        addTaint(value);
String varF88CDDD2DC5E468EB7C82E265CB6073D_1909789150 =         format(value, new StringBuffer(), new FieldPosition(0))
                .toString();
        varF88CDDD2DC5E468EB7C82E265CB6073D_1909789150.addTaint(taint);
        return varF88CDDD2DC5E468EB7C82E265CB6073D_1909789150;
        // ---------- Original Method ----------
        //return format(value, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract StringBuffer format(double value, StringBuffer buffer, FieldPosition field);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.831 -0400", hash_original_method = "D84155C6B50E9BFD8F05A957DEB6EF42", hash_generated_method = "70A990843CA4F89DF47463B8959A45E8")
    public final String format(long value) {
        addTaint(value);
String varF88CDDD2DC5E468EB7C82E265CB6073D_1057159388 =         format(value, new StringBuffer(), new FieldPosition(0))
                .toString();
        varF88CDDD2DC5E468EB7C82E265CB6073D_1057159388.addTaint(taint);
        return varF88CDDD2DC5E468EB7C82E265CB6073D_1057159388;
        // ---------- Original Method ----------
        //return format(value, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract StringBuffer format(long value, StringBuffer buffer, FieldPosition field);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.832 -0400", hash_original_method = "294F85583D2E74BD6D7B73B5CBA517EA", hash_generated_method = "2F012E1DC3462A64650D6B3EE4996223")
    @Override
    public StringBuffer format(Object object, StringBuffer buffer, FieldPosition field) {
        addTaint(field.getTaint());
        addTaint(buffer.getTaint());
        addTaint(object.getTaint());
        if(object instanceof Byte || object instanceof Short || object instanceof Integer ||
                object instanceof Long ||
                (object instanceof BigInteger && ((BigInteger) object).bitLength() < 64))        
        {
            long lv = ((Number) object).longValue();
StringBuffer var7D41C9F15D36B95537E7614BA2643F28_789817180 =             format(lv, buffer, field);
            var7D41C9F15D36B95537E7614BA2643F28_789817180.addTaint(taint);
            return var7D41C9F15D36B95537E7614BA2643F28_789817180;
        } //End block
        else
        if(object instanceof Number)        
        {
            double dv = ((Number) object).doubleValue();
StringBuffer var202EA03A910D5AF7841539AA60745D42_1272520115 =             format(dv, buffer, field);
            var202EA03A910D5AF7841539AA60745D42_1272520115.addTaint(taint);
            return var202EA03A910D5AF7841539AA60745D42_1272520115;
        } //End block
        IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1520234957 = new IllegalArgumentException();
        var5783EF97022AA508B74A1E3EA38534AF_1520234957.addTaint(taint);
        throw var5783EF97022AA508B74A1E3EA38534AF_1520234957;
        // ---------- Original Method ----------
        //if (object instanceof Byte || object instanceof Short || object instanceof Integer ||
                //object instanceof Long ||
                //(object instanceof BigInteger && ((BigInteger) object).bitLength() < 64)) {
            //long lv = ((Number) object).longValue();
            //return format(lv, buffer, field);
        //} else if (object instanceof Number) {
            //double dv = ((Number) object).doubleValue();
            //return format(dv, buffer, field);
        //}
        //throw new IllegalArgumentException();
    }

    
    @DSModeled(DSC.SAFE)
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableNumberFormatLocales();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.833 -0400", hash_original_method = "B4D372C49661A5E03C88F7CDA081E3AF", hash_generated_method = "2B919E27408DA7F4FF7849866873A40E")
    public Currency getCurrency() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1348093235 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1348093235.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1348093235;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    public static final NumberFormat getCurrencyInstance() {
        return getCurrencyInstance(Locale.getDefault());
    }

    
    @DSModeled(DSC.SAFE)
    public static NumberFormat getCurrencyInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).currencyPattern, locale);
    }

    
    @DSModeled(DSC.SAFE)
    public static final NumberFormat getIntegerInstance() {
        return getIntegerInstance(Locale.getDefault());
    }

    
    @DSModeled(DSC.SAFE)
    public static NumberFormat getIntegerInstance(Locale locale) {
        NumberFormat result = getInstance(LocaleData.get(locale).integerPattern, locale);
        result.setParseIntegerOnly(true);
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    public static final NumberFormat getInstance() {
        return getNumberInstance();
    }

    
    @DSModeled(DSC.SAFE)
    public static NumberFormat getInstance(Locale locale) {
        return getNumberInstance(locale);
    }

    
    @DSModeled(DSC.BAN)
    private static NumberFormat getInstance(String pattern, Locale locale) {
        return new DecimalFormat(pattern, locale);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.835 -0400", hash_original_method = "E813DF8258936A130B114EAEAD95EDA2", hash_generated_method = "0956F0B14C9516CE14110DA550BB5E41")
    public int getMaximumFractionDigits() {
        int var10F0E6C7BE31F95C6A0F542E05A9A4BD_1919670196 = (maximumFractionDigits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527685833 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1527685833;
        // ---------- Original Method ----------
        //return maximumFractionDigits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.835 -0400", hash_original_method = "78A0327FC665D89694C44AF144F747A0", hash_generated_method = "BE206A9BB2B0A8123805BBE775FB927B")
    public int getMaximumIntegerDigits() {
        int var293F9D432700CC93984672059B4DA864_1090265343 = (maximumIntegerDigits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473623557 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1473623557;
        // ---------- Original Method ----------
        //return maximumIntegerDigits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.835 -0400", hash_original_method = "357B48579C639D091425919515E6A5BC", hash_generated_method = "1485A659473D739F975DDCB64C4FCBA7")
    public int getMinimumFractionDigits() {
        int varF9AA0906C75D99181B6EAB63872FD123_1202131379 = (minimumFractionDigits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464040848 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1464040848;
        // ---------- Original Method ----------
        //return minimumFractionDigits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.835 -0400", hash_original_method = "F5C90064F0CFBE4D6C8C4DDC2FA4814C", hash_generated_method = "7B08681DF691A13DBDFD7370672417F7")
    public int getMinimumIntegerDigits() {
        int varDF86785DCD59223752DEFF04D20ECC4D_735993340 = (minimumIntegerDigits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260444492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260444492;
        // ---------- Original Method ----------
        //return minimumIntegerDigits;
    }

    
    @DSModeled(DSC.SAFE)
    public static final NumberFormat getNumberInstance() {
        return getNumberInstance(Locale.getDefault());
    }

    
    @DSModeled(DSC.SAFE)
    public static NumberFormat getNumberInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).numberPattern, locale);
    }

    
    @DSModeled(DSC.SAFE)
    public static final NumberFormat getPercentInstance() {
        return getPercentInstance(Locale.getDefault());
    }

    
    @DSModeled(DSC.SAFE)
    public static NumberFormat getPercentInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).percentPattern, locale);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.836 -0400", hash_original_method = "BA195880AA858EB457E0D875FED9F2CD", hash_generated_method = "04AC9EF6271172FDC139542711AAA04F")
    @Override
    public int hashCode() {
        int var1B352671D52F0CA74B255A467B021D68_1604398757 = ((groupingUsed ? 1231 : 1237) + (parseIntegerOnly ? 1231 : 1237)
                + maximumFractionDigits + maximumIntegerDigits
                + minimumFractionDigits + minimumIntegerDigits);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445490741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_445490741;
        // ---------- Original Method ----------
        //return (groupingUsed ? 1231 : 1237) + (parseIntegerOnly ? 1231 : 1237)
                //+ maximumFractionDigits + maximumIntegerDigits
                //+ minimumFractionDigits + minimumIntegerDigits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.836 -0400", hash_original_method = "4D5DDA7520229906D909C6D4DE03887B", hash_generated_method = "B02856983E5CD1F4DFF333BB92E3C64E")
    public boolean isGroupingUsed() {
        boolean varCDAA5EE168BC255A098368F4ECB84995_2066125408 = (groupingUsed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_991033914 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_991033914;
        // ---------- Original Method ----------
        //return groupingUsed;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.837 -0400", hash_original_method = "2C7184F183FABEE99D4475D92EBC3629", hash_generated_method = "2D5597EF891D1F6E5B12A0D98A0F6BBA")
    public boolean isParseIntegerOnly() {
        boolean varBF0833897E55D6350D293E954F371DCF_906489661 = (parseIntegerOnly);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_10186479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_10186479;
        // ---------- Original Method ----------
        //return parseIntegerOnly;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.837 -0400", hash_original_method = "FE3646B6613636F305FFC18B8FD2F859", hash_generated_method = "EB46ADA283F130E0AA9E48BCD5A52EA5")
    public Number parse(String string) throws ParseException {
        addTaint(string.getTaint());
        ParsePosition pos = new ParsePosition(0);
        Number number = parse(string, pos);
        if(pos.getIndex() == 0)        
        {
            ParseException var62056DC5161B0C47056FBF0E6AE7EEE9_1620345458 = new ParseException("Unparseable number: \"" + string + "\"", pos.getErrorIndex());
            var62056DC5161B0C47056FBF0E6AE7EEE9_1620345458.addTaint(taint);
            throw var62056DC5161B0C47056FBF0E6AE7EEE9_1620345458;
        } //End block
Number var63E80DF571E08DAA47BEFBF0BD0EEBAD_1414401994 =         number;
        var63E80DF571E08DAA47BEFBF0BD0EEBAD_1414401994.addTaint(taint);
        return var63E80DF571E08DAA47BEFBF0BD0EEBAD_1414401994;
        // ---------- Original Method ----------
        //ParsePosition pos = new ParsePosition(0);
        //Number number = parse(string, pos);
        //if (pos.getIndex() == 0) {
            //throw new ParseException("Unparseable number: \"" + string + "\"", pos.getErrorIndex());
        //}
        //return number;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Number parse(String string, ParsePosition position);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.837 -0400", hash_original_method = "CBC8FD7F8E88C5B63A9D5DAA3A983953", hash_generated_method = "680A5C75BCA1F816D48896A3FB6D8A1C")
    @Override
    public final Object parseObject(String string, ParsePosition position) {
        addTaint(position.getTaint());
        addTaint(string.getTaint());
        if(position == null)        
        {
            NullPointerException varC93DC96FB426FA0ED36AE39789A8AD97_902241917 = new NullPointerException("position is null");
            varC93DC96FB426FA0ED36AE39789A8AD97_902241917.addTaint(taint);
            throw varC93DC96FB426FA0ED36AE39789A8AD97_902241917;
        } //End block
        try 
        {
Object var0D84F404ADD0A115F77E7D80294D92BC_999497213 =             parse(string, position);
            var0D84F404ADD0A115F77E7D80294D92BC_999497213.addTaint(taint);
            return var0D84F404ADD0A115F77E7D80294D92BC_999497213;
        } //End block
        catch (Exception e)
        {
Object var540C13E9E156B687226421B24F2DF178_1598643270 =             null;
            var540C13E9E156B687226421B24F2DF178_1598643270.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1598643270;
        } //End block
        // ---------- Original Method ----------
        //if (position == null) {
            //throw new NullPointerException("position is null");
        //}
        //try {
            //return parse(string, position);
        //} catch (Exception e) {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.837 -0400", hash_original_method = "840FE994670C453CCC1032B9649CFF03", hash_generated_method = "1789581972B14E9069F3AAA6CA004BA7")
    public void setCurrency(Currency currency) {
        addTaint(currency.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1517021491 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1517021491.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1517021491;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.838 -0400", hash_original_method = "A7E1435E673E29B6F1D0E28A7EA1B8E8", hash_generated_method = "579E547AED141F13B97721B484886296")
    public void setGroupingUsed(boolean value) {
        groupingUsed = value;
        // ---------- Original Method ----------
        //groupingUsed = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.838 -0400", hash_original_method = "8D829B5D993AE8CFC3165307650DC45D", hash_generated_method = "0F73F9AD293F0B883B7EF1A12B6D8BAF")
    public void setMaximumFractionDigits(int value) {
        maximumFractionDigits = value < 0 ? 0 : value;
        if(maximumFractionDigits < minimumFractionDigits)        
        {
            minimumFractionDigits = maximumFractionDigits;
        } //End block
        // ---------- Original Method ----------
        //maximumFractionDigits = value < 0 ? 0 : value;
        //if (maximumFractionDigits < minimumFractionDigits) {
            //minimumFractionDigits = maximumFractionDigits;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.839 -0400", hash_original_method = "21B8BEFD42232423658838BAC20C84FE", hash_generated_method = "0F2958F2FB5144D5733B7401E7DFEF0E")
    public void setMaximumIntegerDigits(int value) {
        maximumIntegerDigits = value < 0 ? 0 : value;
        if(maximumIntegerDigits < minimumIntegerDigits)        
        {
            minimumIntegerDigits = maximumIntegerDigits;
        } //End block
        // ---------- Original Method ----------
        //maximumIntegerDigits = value < 0 ? 0 : value;
        //if (maximumIntegerDigits < minimumIntegerDigits) {
            //minimumIntegerDigits = maximumIntegerDigits;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.839 -0400", hash_original_method = "2004D453A285EC62847C50B61DD7CBAF", hash_generated_method = "7878C503CB7380108E556CFC1933EBB7")
    public void setMinimumFractionDigits(int value) {
        minimumFractionDigits = value < 0 ? 0 : value;
        if(maximumFractionDigits < minimumFractionDigits)        
        {
            maximumFractionDigits = minimumFractionDigits;
        } //End block
        // ---------- Original Method ----------
        //minimumFractionDigits = value < 0 ? 0 : value;
        //if (maximumFractionDigits < minimumFractionDigits) {
            //maximumFractionDigits = minimumFractionDigits;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.839 -0400", hash_original_method = "6D62345156926236ED68DA3CBABDD448", hash_generated_method = "632F3CE28FCA32FF6FD79B0CE4EA603C")
    public void setMinimumIntegerDigits(int value) {
        minimumIntegerDigits = value < 0 ? 0 : value;
        if(maximumIntegerDigits < minimumIntegerDigits)        
        {
            maximumIntegerDigits = minimumIntegerDigits;
        } //End block
        // ---------- Original Method ----------
        //minimumIntegerDigits = value < 0 ? 0 : value;
        //if (maximumIntegerDigits < minimumIntegerDigits) {
            //maximumIntegerDigits = minimumIntegerDigits;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.839 -0400", hash_original_method = "7914BBF7EC4F88E69DC0254980E5E100", hash_generated_method = "17744EC5A610FD6FB76060138790E549")
    public void setParseIntegerOnly(boolean value) {
        parseIntegerOnly = value;
        // ---------- Original Method ----------
        //parseIntegerOnly = value;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.840 -0400", hash_original_method = "615BDCCE0F576CE8071CDC67AB896544", hash_generated_method = "778D992F1E3770A728E7A4A19FAA1F57")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("groupingUsed", groupingUsed);
        fields.put("maxFractionDigits",
                        maximumFractionDigits < Byte.MAX_VALUE ? (byte) maximumFractionDigits
                                : Byte.MAX_VALUE);
        fields.put("maximumFractionDigits", maximumFractionDigits);
        fields.put("maximumIntegerDigits", maximumIntegerDigits);
        fields.put("maxIntegerDigits",
                        maximumIntegerDigits < Byte.MAX_VALUE ? (byte) maximumIntegerDigits
                                : Byte.MAX_VALUE);
        fields.put("minFractionDigits",
                        minimumFractionDigits < Byte.MAX_VALUE ? (byte) minimumFractionDigits
                                : Byte.MAX_VALUE);
        fields.put("minimumFractionDigits", minimumFractionDigits);
        fields.put("minimumIntegerDigits", minimumIntegerDigits);
        fields.put("minIntegerDigits",
                minimumIntegerDigits < Byte.MAX_VALUE ? (byte) minimumIntegerDigits : Byte.MAX_VALUE);
        fields.put("parseIntegerOnly", parseIntegerOnly);
        fields.put("serialVersionOnStream", 1);
        stream.writeFields();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.841 -0400", hash_original_method = "7CE1B061AB7260929E58BDEF36BC550E", hash_generated_method = "7120A29A4A1C6E7E8CFB964FC8A88483")
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        addTaint(stream.getTaint());
        ObjectInputStream.GetField fields = stream.readFields();
        groupingUsed = fields.get("groupingUsed", true);
        parseIntegerOnly = fields.get("parseIntegerOnly", false);
        if(fields.get("serialVersionOnStream", 0) == 0)        
        {
            maximumFractionDigits = fields.get("maxFractionDigits", (byte) 3);
            maximumIntegerDigits = fields.get("maxIntegerDigits", (byte) 40);
            minimumFractionDigits = fields.get("minFractionDigits", (byte) 0);
            minimumIntegerDigits = fields.get("minIntegerDigits", (byte) 1);
        } //End block
        else
        {
            maximumFractionDigits = fields.get("maximumFractionDigits", 3);
            maximumIntegerDigits = fields.get("maximumIntegerDigits", 40);
            minimumFractionDigits = fields.get("minimumFractionDigits", 0);
            minimumIntegerDigits = fields.get("minimumIntegerDigits", 1);
        } //End block
        if(minimumIntegerDigits > maximumIntegerDigits
                || minimumFractionDigits > maximumFractionDigits)        
        {
            InvalidObjectException var1A21B15B7E27B5D29FF8A008E035AADA_1565703088 = new InvalidObjectException("min digits greater than max digits");
            var1A21B15B7E27B5D29FF8A008E035AADA_1565703088.addTaint(taint);
            throw var1A21B15B7E27B5D29FF8A008E035AADA_1565703088;
        } //End block
        if(minimumIntegerDigits < 0 || maximumIntegerDigits < 0
                || minimumFractionDigits < 0 || maximumFractionDigits < 0)        
        {
            InvalidObjectException varBE9CAB3F7C17B180A0FD8CC2FE978B42_381230343 = new InvalidObjectException("min or max digits negative");
            varBE9CAB3F7C17B180A0FD8CC2FE978B42_381230343.addTaint(taint);
            throw varBE9CAB3F7C17B180A0FD8CC2FE978B42_381230343;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.841 -0400", hash_original_method = "E6FF1C57537669874BDF42CE722EB942", hash_generated_method = "1A06217774F9F93F42C39727BAE094D7")
    public RoundingMode getRoundingMode() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1774402558 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1774402558.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1774402558;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.841 -0400", hash_original_method = "0C28590135419FD8FADCC2330801FC90", hash_generated_method = "7A9D3D4D165A6B0F79514C31C3E7440D")
    public void setRoundingMode(RoundingMode roundingMode) {
        addTaint(roundingMode.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1822427366 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1822427366.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1822427366;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    public static class Field extends Format.Field {
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "465767ECB3AF93CD4C2D7AEDA23F18B3")
        protected  Field(String fieldName) {
            super(fieldName);
            addTaint(fieldName.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "2FFF218EC81F19332810C67805AA588F", hash_generated_field = "E6808DCA2B613BACD85F5DF8A49842E5")

        private static final long serialVersionUID = 7494728892700160890L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "C17D51A6125EA6A3385B4D72203CA690", hash_generated_field = "E67CF04835E7440B3B8255401771C5CD")

        public static final Field SIGN = new Field("sign");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "59910FEA88AFC9673A7975540E0C6925", hash_generated_field = "3E710ACC9159D86DCBAEF807D5972AA9")

        public static final Field INTEGER = new Field("integer");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "5E0217A095C352CEC03311A125609AFC", hash_generated_field = "6E1A733B400A6EC7E2C2C43052CECE2A")

        public static final Field FRACTION = new Field("fraction");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "A2A6879886A605EE3675E7DA49C1979F", hash_generated_field = "319F9EC01C54BF39610B784926849985")

        public static final Field EXPONENT = new Field("exponent");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "2B71E7B00BB2FED06381E6BF37FB977D", hash_generated_field = "6F3344887D5C43063B3E3BB99EEA0438")

        public static final Field EXPONENT_SIGN = new Field("exponent sign");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "3BAE80E0C7E567B712E0EA667FCF280A", hash_generated_field = "9DAFAC188978AAF54D1712AE1358211E")

        public static final Field EXPONENT_SYMBOL = new Field("exponent symbol");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "C15DA94BE137825E07F879EA3CB2DA19", hash_generated_field = "7DA4CAE4944D7EA0085939A97D217F42")

        public static final Field DECIMAL_SEPARATOR = new Field("decimal separator");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "1196F40BFD62B1FFF47459DF9CACCFD1", hash_generated_field = "426A0B45CE473A2A95A3111A95B0BC93")

        public static final Field GROUPING_SEPARATOR = new Field("grouping separator");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "E7F0EC9BE1B2FE1FED599FA6F37BEF54", hash_generated_field = "8E65210094B4E3C543532347F9FF71EC")

        public static final Field PERCENT = new Field("percent");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "8304A2F34144D5D349572E6C95EB2710", hash_generated_field = "E1C4AB1812D6EAA5813530289FF65B7E")

        public static final Field PERMILLE = new Field("per mille");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "1C4C7EF748C9866E3B3752B5A41AE5CC", hash_generated_field = "4C849A2E4130CBE7D5EC854384ED9B8E")

        public static final Field CURRENCY = new Field("currency");
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "BE4A61B7295266FE7928F531C26A7099", hash_generated_field = "F09073C8D8AE7A807304B7452EAEF8B1")

    private static final long serialVersionUID = -2308460125733713944L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "23A2515812AC5924453701219A432517", hash_generated_field = "8E8C994FB7A9C648CA5248364548DF14")

    public static final int INTEGER_FIELD = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.842 -0400", hash_original_field = "BBE29EE2A18D6AE982BDFB95538B188F", hash_generated_field = "366746AFA392D2AA06B116040E73FAAC")

    public static final int FRACTION_FIELD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.843 -0400", hash_original_field = "33C00664BC739ABE02AC1026A2BAE10E", hash_generated_field = "BAD9E2169D2150C1AD558C00FC601059")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("groupingUsed", boolean.class),
        new ObjectStreamField("maxFractionDigits", byte.class),
        new ObjectStreamField("maximumFractionDigits", int.class),
        new ObjectStreamField("maximumIntegerDigits", int.class),
        new ObjectStreamField("maxIntegerDigits", byte.class),
        new ObjectStreamField("minFractionDigits", byte.class),
        new ObjectStreamField("minimumFractionDigits", int.class),
        new ObjectStreamField("minimumIntegerDigits", int.class),
        new ObjectStreamField("minIntegerDigits", byte.class),
        new ObjectStreamField("parseIntegerOnly", boolean.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
    };
}

