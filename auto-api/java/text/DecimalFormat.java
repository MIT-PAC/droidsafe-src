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
import java.io.ObjectStreamField;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;
import libcore.icu.LocaleData;
import libcore.icu.NativeDecimalFormat;

public class DecimalFormat extends NumberFormat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.650 -0400", hash_original_field = "5503577415FC1D8D6B3818212A1745BC", hash_generated_field = "52EBB9EA358F4A29D5EE09E100128428")

    private transient DecimalFormatSymbols symbols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.651 -0400", hash_original_field = "43FB3BF64083BD4CAC80E1ED8CD075E4", hash_generated_field = "311D958CADB5DD8F5620B5C0287903DF")

    private transient NativeDecimalFormat dform;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.651 -0400", hash_original_field = "56B4B01527B4EB5F82F59EBDEC4AAB14", hash_generated_field = "B9F3E2F6490F8A83C6C6491C6C668219")

    private Object finalizerGuardian = new Object() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.651 -0400", hash_original_method = "1A366D9719473F2399B539B354BB787B", hash_generated_method = "ABC3A607675036C5172AEFC1575529C6")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                dform.close();
            } //End block
            finally 
            {
                super.finalize();
            } //End block
            // ---------- Original Method ----------
            //try {
                //dform.close();
            //} finally {
                //super.finalize();
            //}
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.651 -0400", hash_original_field = "825BD9DBFA8BD0A02A9B3F51F9F3F717", hash_generated_field = "F8D485A47161940F89EC9F4328B1DE40")

    private transient RoundingMode roundingMode = RoundingMode.HALF_EVEN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.651 -0400", hash_original_method = "DE88C1883A924350E112FA17163006E9", hash_generated_method = "D24DAC5F853E63C56F01B8274A19AC11")
    public  DecimalFormat() {
        Locale locale;
        locale = Locale.getDefault();
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(LocaleData.get(locale).numberPattern);
        // ---------- Original Method ----------
        //Locale locale = Locale.getDefault();
        //this.symbols = new DecimalFormatSymbols(locale);
        //initNative(LocaleData.get(locale).numberPattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.661 -0400", hash_original_method = "35AB5293961F9B593ADD183E8B6B3242", hash_generated_method = "32BBE801F866CA8E0CC29DE98F1BC803")
    public  DecimalFormat(String pattern) {
        this(pattern, Locale.getDefault());
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.662 -0400", hash_original_method = "17CE9F29195C1874CE3535C0883BB7B4", hash_generated_method = "445D9156C045C3F33FB6A5147E1E0A10")
    public  DecimalFormat(String pattern, DecimalFormatSymbols value) {
        this.symbols = (DecimalFormatSymbols) value.clone();
        initNative(pattern);
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
        //this.symbols = (DecimalFormatSymbols) value.clone();
        //initNative(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.663 -0400", hash_original_method = "1EB8095DC5F926848B20CBA55F6BDD83", hash_generated_method = "EC2FB85AC22B60BBC13FFD656B7B93E9")
      DecimalFormat(String pattern, Locale locale) {
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(pattern);
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
        //this.symbols = new DecimalFormatSymbols(locale);
        //initNative(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.667 -0400", hash_original_method = "701B7114CA5711EBC62D39124CAE5412", hash_generated_method = "B5E894FAB4E47C20F77A21B4BC851B82")
    private void initNative(String pattern) {
        try 
        {
            this.dform = new NativeDecimalFormat(pattern, symbols);
        } //End block
        catch (IllegalArgumentException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(pattern);
        } //End block
        super.setMaximumFractionDigits(dform.getMaximumFractionDigits());
        super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());
        super.setMinimumFractionDigits(dform.getMinimumFractionDigits());
        super.setMinimumIntegerDigits(dform.getMinimumIntegerDigits());
        // ---------- Original Method ----------
        //try {
            //this.dform = new NativeDecimalFormat(pattern, symbols);
        //} catch (IllegalArgumentException ex) {
            //throw new IllegalArgumentException(pattern);
        //}
        //super.setMaximumFractionDigits(dform.getMaximumFractionDigits());
        //super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());
        //super.setMinimumFractionDigits(dform.getMinimumFractionDigits());
        //super.setMinimumIntegerDigits(dform.getMinimumIntegerDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.667 -0400", hash_original_method = "65449F4F2C00BF62B7AB916EB2126B60", hash_generated_method = "46C68ADE4038F25D5EE6328DA53973E6")
    public void applyLocalizedPattern(String pattern) {
        dform.applyLocalizedPattern(pattern);
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
        //dform.applyLocalizedPattern(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.670 -0400", hash_original_method = "09E7693F39B1CA310938A9A4756C1A20", hash_generated_method = "627B1A10821BF52281AA475FBB092F2D")
    public void applyPattern(String pattern) {
        dform.applyPattern(pattern);
        addTaint(pattern.getTaint());
        // ---------- Original Method ----------
        //dform.applyPattern(pattern);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.673 -0400", hash_original_method = "9257BEF78EF77BD305740BB055166BA8", hash_generated_method = "B15F4D3CF3CA2D5CEB32C4BB7522A6B9")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1167411727 = null; //Variable for return #1
        DecimalFormat clone;
        clone = (DecimalFormat) super.clone();
        clone.dform = (NativeDecimalFormat) dform.clone();
        clone.symbols = (DecimalFormatSymbols) symbols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1167411727 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1167411727.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1167411727;
        // ---------- Original Method ----------
        //DecimalFormat clone = (DecimalFormat) super.clone();
        //clone.dform = (NativeDecimalFormat) dform.clone();
        //clone.symbols = (DecimalFormatSymbols) symbols.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.676 -0400", hash_original_method = "6765E822C563E620DE26A0B6A028E00A", hash_generated_method = "D7976E5A7BD94318132BCA6C1176D53F")
    @Override
    public boolean equals(Object object) {
        DecimalFormat other;
        other = (DecimalFormat) object;
        boolean var978C9F6193C72EF6E0807F28D1781CB8_1571474051 = ((this.dform == null ? other.dform == null : this.dform.equals(other.dform)) &&
                getDecimalFormatSymbols().equals(other.getDecimalFormatSymbols())); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1601197062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1601197062;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (!(object instanceof DecimalFormat)) {
            //return false;
        //}
        //DecimalFormat other = (DecimalFormat) object;
        //return (this.dform == null ? other.dform == null : this.dform.equals(other.dform)) &&
                //getDecimalFormatSymbols().equals(other.getDecimalFormatSymbols());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.677 -0400", hash_original_method = "3B59068DE45E1D685899870F874FDB91", hash_generated_method = "1B43077AADDCED974FFAF388206F620C")
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_363749198 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_363749198 = dform.formatToCharacterIterator(object);
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_363749198.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_363749198;
        // ---------- Original Method ----------
        //if (object == null) {
            //throw new NullPointerException();
        //}
        //return dform.formatToCharacterIterator(object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.677 -0400", hash_original_method = "FBA2DE4CAF4AAEBE0D141C6C51AFFE4A", hash_generated_method = "C34C4E87A14DAAA340FBA5FD4A16BD64")
    private void checkBufferAndFieldPosition(StringBuffer buffer, FieldPosition position) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("buffer == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("position == null");
        } //End block
        addTaint(buffer.getTaint());
        addTaint(position.getTaint());
        // ---------- Original Method ----------
        //if (buffer == null) {
            //throw new NullPointerException("buffer == null");
        //}
        //if (position == null) {
            //throw new NullPointerException("position == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.760 -0400", hash_original_method = "1E84E5D2AEBA1220C1C2BABB55EE58F4", hash_generated_method = "7132E93D67A55C09941ECFC986BF2357")
    @Override
    public StringBuffer format(double value, StringBuffer buffer, FieldPosition position) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1129037926 = null; //Variable for return #1
        checkBufferAndFieldPosition(buffer, position);
        {
            try 
            {
                setRoundingMode(RoundingMode.UP);
                String upResult;
                upResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                setRoundingMode(RoundingMode.DOWN);
                String downResult;
                downResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                {
                    boolean var2F746E5BABC839274FF6C5CAE9A27612_1532652139 = (!upResult.equals(downResult));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("rounding mode UNNECESSARY but rounding required");
                    } //End block
                } //End collapsed parenthetic
            } //End block
            finally 
            {
                setRoundingMode(RoundingMode.UNNECESSARY);
            } //End block
        } //End block
        buffer.append(dform.formatDouble(value, position));
        varB4EAC82CA7396A68D541C85D26508E83_1129037926 = buffer;
        addTaint(value);
        addTaint(buffer.getTaint());
        addTaint(position.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1129037926.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1129037926;
        // ---------- Original Method ----------
        //checkBufferAndFieldPosition(buffer, position);
        //if (roundingMode == RoundingMode.UNNECESSARY) {
            //try {
                //setRoundingMode(RoundingMode.UP);
                //String upResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                //setRoundingMode(RoundingMode.DOWN);
                //String downResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                //if (!upResult.equals(downResult)) {
                    //throw new ArithmeticException("rounding mode UNNECESSARY but rounding required");
                //}
            //} finally {
                //setRoundingMode(RoundingMode.UNNECESSARY);
            //}
        //}
        //buffer.append(dform.formatDouble(value, position));
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.761 -0400", hash_original_method = "B4F0904648F2A25561C63568681C231B", hash_generated_method = "2BE7E47E0E17F4D2F982AE0EFFED6BAD")
    @Override
    public StringBuffer format(long value, StringBuffer buffer, FieldPosition position) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1875450144 = null; //Variable for return #1
        checkBufferAndFieldPosition(buffer, position);
        buffer.append(dform.formatLong(value, position));
        varB4EAC82CA7396A68D541C85D26508E83_1875450144 = buffer;
        addTaint(value);
        addTaint(buffer.getTaint());
        addTaint(position.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1875450144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1875450144;
        // ---------- Original Method ----------
        //checkBufferAndFieldPosition(buffer, position);
        //buffer.append(dform.formatLong(value, position));
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.763 -0400", hash_original_method = "9F0187C663B029586FEAEE5997EF0E8A", hash_generated_method = "C55CF090C516E04694440F60A2883735")
    @Override
    public final StringBuffer format(Object number, StringBuffer buffer, FieldPosition position) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1337839204 = null; //Variable for return #1
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1979637068 = null; //Variable for return #2
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_378157738 = null; //Variable for return #3
        checkBufferAndFieldPosition(buffer, position);
        {
            BigInteger bigInteger;
            bigInteger = (BigInteger) number;
            char[] chars;
            boolean var13ED5CFC28017CACC4A5C2EC4BA37F58_839186606 = ((bigInteger.bitLength() < 64));
            chars = dform.formatLong(bigInteger.longValue(), position);
            chars = dform.formatBigInteger(bigInteger, position);
            buffer.append(chars);
            varB4EAC82CA7396A68D541C85D26508E83_1337839204 = buffer;
        } //End block
        {
            buffer.append(dform.formatBigDecimal((BigDecimal) number, position));
            varB4EAC82CA7396A68D541C85D26508E83_1979637068 = buffer;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_378157738 = super.format(number, buffer, position);
        addTaint(number.getTaint());
        addTaint(buffer.getTaint());
        addTaint(position.getTaint());
        StringBuffer varA7E53CE21691AB073D9660D615818899_2131245533; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2131245533 = varB4EAC82CA7396A68D541C85D26508E83_1337839204;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2131245533 = varB4EAC82CA7396A68D541C85D26508E83_1979637068;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2131245533 = varB4EAC82CA7396A68D541C85D26508E83_378157738;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2131245533.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2131245533;
        // ---------- Original Method ----------
        //checkBufferAndFieldPosition(buffer, position);
        //if (number instanceof BigInteger) {
            //BigInteger bigInteger = (BigInteger) number;
            //char[] chars = (bigInteger.bitLength() < 64)
                    //? dform.formatLong(bigInteger.longValue(), position)
                    //: dform.formatBigInteger(bigInteger, position);
            //buffer.append(chars);
            //return buffer;
        //} else if (number instanceof BigDecimal) {
            //buffer.append(dform.formatBigDecimal((BigDecimal) number, position));
            //return buffer;
        //}
        //return super.format(number, buffer, position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.763 -0400", hash_original_method = "8DCCB340D185077EABFD1E6BFE3DB36F", hash_generated_method = "EB6DF308597C15B4B0B2A1B56935B762")
    public DecimalFormatSymbols getDecimalFormatSymbols() {
        DecimalFormatSymbols varB4EAC82CA7396A68D541C85D26508E83_186427585 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_186427585 = (DecimalFormatSymbols) symbols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_186427585.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_186427585;
        // ---------- Original Method ----------
        //return (DecimalFormatSymbols) symbols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.786 -0400", hash_original_method = "58EEC1F79BF01CD73E1939B30FC9554A", hash_generated_method = "268CE8151074048F17B69DEC6B565293")
    @Override
    public Currency getCurrency() {
        Currency varB4EAC82CA7396A68D541C85D26508E83_2005221641 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2005221641 = symbols.getCurrency();
        varB4EAC82CA7396A68D541C85D26508E83_2005221641.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2005221641;
        // ---------- Original Method ----------
        //return symbols.getCurrency();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.786 -0400", hash_original_method = "3224B3D9278B5F6729F4AC0FDDE7BC48", hash_generated_method = "46EFE5F2F833BEB8DD9568001245B496")
    public int getGroupingSize() {
        int var84E7F84E9DB89AD1D760100A3219CD70_418345085 = (dform.getGroupingSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039726449 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2039726449;
        // ---------- Original Method ----------
        //return dform.getGroupingSize();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.786 -0400", hash_original_method = "20055FC91A272014560FDC07D160C285", hash_generated_method = "DF2FD2DA80C839BA5E273E42A5F2408B")
    public int getMultiplier() {
        int varD5942B62FC4C9BC329C63BE9D496D09D_969376071 = (dform.getMultiplier());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148025351 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_148025351;
        // ---------- Original Method ----------
        //return dform.getMultiplier();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.787 -0400", hash_original_method = "1F7C0591D1187101B5F5E6FCEBFE4BA7", hash_generated_method = "34F6E98E830A2B01FF1F026377AC5088")
    public String getNegativePrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1004602485 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1004602485 = dform.getNegativePrefix();
        varB4EAC82CA7396A68D541C85D26508E83_1004602485.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1004602485;
        // ---------- Original Method ----------
        //return dform.getNegativePrefix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.787 -0400", hash_original_method = "61D6D48706CC87AEEF19B015AC798361", hash_generated_method = "C746314D962401E879FD5758802C7BDA")
    public String getNegativeSuffix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1511883842 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1511883842 = dform.getNegativeSuffix();
        varB4EAC82CA7396A68D541C85D26508E83_1511883842.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1511883842;
        // ---------- Original Method ----------
        //return dform.getNegativeSuffix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.788 -0400", hash_original_method = "55B5FDB79399831D6973F7F1358A3E99", hash_generated_method = "3EB7D5A8B1D1F19B93A4AFF4B5712ECA")
    public String getPositivePrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_115206174 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_115206174 = dform.getPositivePrefix();
        varB4EAC82CA7396A68D541C85D26508E83_115206174.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_115206174;
        // ---------- Original Method ----------
        //return dform.getPositivePrefix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.792 -0400", hash_original_method = "2B5CAE95AEB5D456BD3378DDAC8D9097", hash_generated_method = "B6F852B8FE1082B6F52883ADB9FDDE69")
    public String getPositiveSuffix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1053222670 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1053222670 = dform.getPositiveSuffix();
        varB4EAC82CA7396A68D541C85D26508E83_1053222670.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1053222670;
        // ---------- Original Method ----------
        //return dform.getPositiveSuffix();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.792 -0400", hash_original_method = "AC91BBA5B39870FB8DAE3ED8BCCB1730", hash_generated_method = "AA09CDEC7E9B8464D594C786CA24FA53")
    @Override
    public int hashCode() {
        int varAB176B7235F3D88BF17FD6DC4AB80E7B_1823319390 = (dform.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118763795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2118763795;
        // ---------- Original Method ----------
        //return dform.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.793 -0400", hash_original_method = "43884003345D483D0CB1C79601B3CBE6", hash_generated_method = "BF258CD4FA0BD453E1CE56C1EF6739F6")
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean var8C31534627EF9A9C01F3C98A04522156_490198051 = (dform.isDecimalSeparatorAlwaysShown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_875102844 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_875102844;
        // ---------- Original Method ----------
        //return dform.isDecimalSeparatorAlwaysShown();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.793 -0400", hash_original_method = "0A7D24FF4B0BD9084E07584B0A08B543", hash_generated_method = "10279DB51882CE20EFC51CF3CD31789A")
    public boolean isParseBigDecimal() {
        boolean var0EB097AD7D30E488D1246B51922A3652_1363154304 = (dform.isParseBigDecimal());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_765758657 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_765758657;
        // ---------- Original Method ----------
        //return dform.isParseBigDecimal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.793 -0400", hash_original_method = "7481DA5537EE3F9956B6D5D3C7A225D0", hash_generated_method = "E72A49D4B0DBC85761438ED8064FFA2D")
    @Override
    public void setParseIntegerOnly(boolean value) {
        dform.setParseIntegerOnly(value);
        addTaint(value);
        // ---------- Original Method ----------
        //dform.setParseIntegerOnly(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.794 -0400", hash_original_method = "4A357353F9630D5720A9D39DD6F8D4E6", hash_generated_method = "84D8192E6068D200F154AD12362D8C6E")
    @Override
    public boolean isParseIntegerOnly() {
        boolean var1E9CEECAA246756F13D9D10CB6BC9E3B_1902764858 = (dform.isParseIntegerOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_860726572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_860726572;
        // ---------- Original Method ----------
        //return dform.isParseIntegerOnly();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.818 -0400", hash_original_method = "5624B977416508FD6FAAB26F049D0D1B", hash_generated_method = "D2392878E6B60EA44AFE2BF4EAF32E5B")
    @Override
    public Number parse(String string, ParsePosition position) {
        Number varB4EAC82CA7396A68D541C85D26508E83_943778632 = null; //Variable for return #1
        Number varB4EAC82CA7396A68D541C85D26508E83_28208143 = null; //Variable for return #2
        Number varB4EAC82CA7396A68D541C85D26508E83_656821781 = null; //Variable for return #3
        Number varB4EAC82CA7396A68D541C85D26508E83_685769647 = null; //Variable for return #4
        Number varB4EAC82CA7396A68D541C85D26508E83_49587459 = null; //Variable for return #5
        Number varB4EAC82CA7396A68D541C85D26508E83_279590094 = null; //Variable for return #6
        Number varB4EAC82CA7396A68D541C85D26508E83_616465177 = null; //Variable for return #7
        Number varB4EAC82CA7396A68D541C85D26508E83_1162386862 = null; //Variable for return #8
        Number number;
        number = dform.parse(string, position);
        {
            varB4EAC82CA7396A68D541C85D26508E83_943778632 = null;
        } //End block
        {
            boolean varFCE5D5AECE0E50270D8E061A3C10C2CD_1189472821 = (this.isParseBigDecimal());
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_28208143 = new BigDecimal(number.longValue());
                } //End block
                {
                    boolean var6E0B5C3FBC13410F972BDAC62E60405B_2121133740 = ((number instanceof Double) && !((Double) number).isInfinite()
                    && !((Double) number).isNaN());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_656821781 = new BigDecimal(number.toString());
                    } //End block
                } //End collapsed parenthetic
                {
                    varB4EAC82CA7396A68D541C85D26508E83_685769647 = new BigDecimal(number.toString());
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_49587459 = number;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_279590094 = new Double(number.doubleValue());
        } //End block
        {
            boolean var07027D739703D2CF0BA233E0500891D7_1287622051 = (this.isParseIntegerOnly() && number.equals(NEGATIVE_ZERO_DOUBLE));
            {
                varB4EAC82CA7396A68D541C85D26508E83_616465177 = Long.valueOf(0);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1162386862 = number;
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        Number varA7E53CE21691AB073D9660D615818899_988123233; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_988123233 = varB4EAC82CA7396A68D541C85D26508E83_943778632;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_988123233 = varB4EAC82CA7396A68D541C85D26508E83_28208143;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_988123233 = varB4EAC82CA7396A68D541C85D26508E83_656821781;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_988123233 = varB4EAC82CA7396A68D541C85D26508E83_685769647;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_988123233 = varB4EAC82CA7396A68D541C85D26508E83_49587459;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_988123233 = varB4EAC82CA7396A68D541C85D26508E83_279590094;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_988123233 = varB4EAC82CA7396A68D541C85D26508E83_616465177;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_988123233 = varB4EAC82CA7396A68D541C85D26508E83_1162386862;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_988123233.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_988123233;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.819 -0400", hash_original_method = "86D86A0FD4BCEEB43D34AB98DA52821C", hash_generated_method = "95C2A2E3AE16892F8FB3FB263B08CBB4")
    public void setDecimalFormatSymbols(DecimalFormatSymbols value) {
        {
            this.symbols = (DecimalFormatSymbols) value.clone();
            dform.setDecimalFormatSymbols(this.symbols);
        } //End block
        // ---------- Original Method ----------
        //if (value != null) {
            //this.symbols = (DecimalFormatSymbols) value.clone();
            //dform.setDecimalFormatSymbols(this.symbols);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.820 -0400", hash_original_method = "4395CDF7142532C86BE10F65050BB217", hash_generated_method = "152F573F081DABBAC796EFA40F700DC5")
    @Override
    public void setCurrency(Currency currency) {
        dform.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        symbols.setCurrency(currency);
        addTaint(currency.getTaint());
        // ---------- Original Method ----------
        //dform.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        //symbols.setCurrency(currency);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.820 -0400", hash_original_method = "3B253ED7615AA8E014EF753B3801D05C", hash_generated_method = "C7435753E266E512A1D229D14DF6A4D2")
    public void setDecimalSeparatorAlwaysShown(boolean value) {
        dform.setDecimalSeparatorAlwaysShown(value);
        addTaint(value);
        // ---------- Original Method ----------
        //dform.setDecimalSeparatorAlwaysShown(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.841 -0400", hash_original_method = "C7D074F8D378A670A8F54B2C99810E6C", hash_generated_method = "487EEA6E05948491C435204E0C7E8EBB")
    public void setGroupingSize(int value) {
        dform.setGroupingSize(value);
        addTaint(value);
        // ---------- Original Method ----------
        //dform.setGroupingSize(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.841 -0400", hash_original_method = "ABE655961F79B3C1FE3443634AA21C37", hash_generated_method = "9812253533C7E092A96BDA3FA83D3470")
    @Override
    public void setGroupingUsed(boolean value) {
        dform.setGroupingUsed(value);
        addTaint(value);
        // ---------- Original Method ----------
        //dform.setGroupingUsed(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.841 -0400", hash_original_method = "47F90CF51661FE278576148D8412D8DA", hash_generated_method = "FA7CF4371D1C33660CC5D8F56D92915A")
    @Override
    public boolean isGroupingUsed() {
        boolean varAA5A5B89A3DACBDF58942A2C9533A8B6_1850300584 = (dform.isGroupingUsed());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_491700850 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_491700850;
        // ---------- Original Method ----------
        //return dform.isGroupingUsed();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.842 -0400", hash_original_method = "D0C418C01DBD33DD29A18941B68BCBF7", hash_generated_method = "E373F67BF8744FB8A9F8EA3FC47EF11B")
    @Override
    public void setMaximumFractionDigits(int value) {
        super.setMaximumFractionDigits(value);
        dform.setMaximumFractionDigits(getMaximumFractionDigits());
        setRoundingMode(roundingMode);
        addTaint(value);
        // ---------- Original Method ----------
        //super.setMaximumFractionDigits(value);
        //dform.setMaximumFractionDigits(getMaximumFractionDigits());
        //setRoundingMode(roundingMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.842 -0400", hash_original_method = "D5AFAB41905B13F7AD20D2FADDE73669", hash_generated_method = "FC538386AC067B5BBD72CB221104870A")
    @Override
    public void setMaximumIntegerDigits(int value) {
        super.setMaximumIntegerDigits(value);
        dform.setMaximumIntegerDigits(getMaximumIntegerDigits());
        addTaint(value);
        // ---------- Original Method ----------
        //super.setMaximumIntegerDigits(value);
        //dform.setMaximumIntegerDigits(getMaximumIntegerDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.842 -0400", hash_original_method = "9EB52B7EEE1D2B50BAA9500CCA3AFB4E", hash_generated_method = "0D1AA3FD175C1086CC188510DF0E021C")
    @Override
    public void setMinimumFractionDigits(int value) {
        super.setMinimumFractionDigits(value);
        dform.setMinimumFractionDigits(getMinimumFractionDigits());
        addTaint(value);
        // ---------- Original Method ----------
        //super.setMinimumFractionDigits(value);
        //dform.setMinimumFractionDigits(getMinimumFractionDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.843 -0400", hash_original_method = "6EFC03984672E7D89A36C9F22F2AAB3B", hash_generated_method = "201E5AD78EBB567FA71F34C3A3FEF7EA")
    @Override
    public void setMinimumIntegerDigits(int value) {
        super.setMinimumIntegerDigits(value);
        dform.setMinimumIntegerDigits(getMinimumIntegerDigits());
        addTaint(value);
        // ---------- Original Method ----------
        //super.setMinimumIntegerDigits(value);
        //dform.setMinimumIntegerDigits(getMinimumIntegerDigits());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.843 -0400", hash_original_method = "2E4C739E2F1CFFD7C6A061AD5BB9ADF4", hash_generated_method = "3DC2E599FF63CBCE79067AA9DB9D8BEF")
    public void setMultiplier(int value) {
        dform.setMultiplier(value);
        addTaint(value);
        // ---------- Original Method ----------
        //dform.setMultiplier(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.843 -0400", hash_original_method = "2C739DF56DF29E81D815FC52FA901BFF", hash_generated_method = "3F29737CA3B0CC851AE47576F086F2BB")
    public void setNegativePrefix(String value) {
        dform.setNegativePrefix(value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //dform.setNegativePrefix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.843 -0400", hash_original_method = "A51B4E91EE1B92D26334E28FF3A003CC", hash_generated_method = "C199DAB44B43BA38B39FE1CD8929A8B6")
    public void setNegativeSuffix(String value) {
        dform.setNegativeSuffix(value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //dform.setNegativeSuffix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.844 -0400", hash_original_method = "7DA87D841FEB1EB829AC578209C7D87B", hash_generated_method = "03D0B68EA49BE81931E00BCF051AD269")
    public void setPositivePrefix(String value) {
        dform.setPositivePrefix(value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //dform.setPositivePrefix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.846 -0400", hash_original_method = "740675349A091E1D283FD9B9350AE3AA", hash_generated_method = "22E1EB99A6645AD75E181E1BE92FFD9F")
    public void setPositiveSuffix(String value) {
        dform.setPositiveSuffix(value);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //dform.setPositiveSuffix(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.846 -0400", hash_original_method = "DD680A2A91BAA011B854EB3CE1AE2AEF", hash_generated_method = "2DC186D379EF10B6FFBF622D83AE864C")
    public void setParseBigDecimal(boolean newValue) {
        dform.setParseBigDecimal(newValue);
        addTaint(newValue);
        // ---------- Original Method ----------
        //dform.setParseBigDecimal(newValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.869 -0400", hash_original_method = "487E11DF64E483CD2A017195603FADD0", hash_generated_method = "A74F32F0110F484CEF53125999803F6C")
    public String toLocalizedPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_326220661 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_326220661 = dform.toLocalizedPattern();
        varB4EAC82CA7396A68D541C85D26508E83_326220661.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_326220661;
        // ---------- Original Method ----------
        //return dform.toLocalizedPattern();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.869 -0400", hash_original_method = "588A1CECAAE48251BC4F5156DD9C9A13", hash_generated_method = "C448FDD1F5A40F1E6B2BAA1E1E19B017")
    public String toPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_939195015 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_939195015 = dform.toPattern();
        varB4EAC82CA7396A68D541C85D26508E83_939195015.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_939195015;
        // ---------- Original Method ----------
        //return dform.toPattern();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.870 -0400", hash_original_method = "5BC6394F5F5C73D6097502885E125B6B", hash_generated_method = "98F79407D8405437F5C65F2B8E6E1492")
    private void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException {
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        fields.put("positivePrefix", dform.getPositivePrefix());
        fields.put("positiveSuffix", dform.getPositiveSuffix());
        fields.put("negativePrefix", dform.getNegativePrefix());
        fields.put("negativeSuffix", dform.getNegativeSuffix());
        fields.put("posPrefixPattern", (String) null);
        fields.put("posSuffixPattern", (String) null);
        fields.put("negPrefixPattern", (String) null);
        fields.put("negSuffixPattern", (String) null);
        fields.put("multiplier", dform.getMultiplier());
        fields.put("groupingSize", (byte) dform.getGroupingSize());
        fields.put("groupingUsed", dform.isGroupingUsed());
        fields.put("decimalSeparatorAlwaysShown", dform.isDecimalSeparatorAlwaysShown());
        fields.put("parseBigDecimal", dform.isParseBigDecimal());
        fields.put("roundingMode", roundingMode);
        fields.put("symbols", symbols);
        fields.put("useExponentialNotation", false);
        fields.put("minExponentDigits", (byte) 0);
        fields.put("maximumIntegerDigits", dform.getMaximumIntegerDigits());
        fields.put("minimumIntegerDigits", dform.getMinimumIntegerDigits());
        fields.put("maximumFractionDigits", dform.getMaximumFractionDigits());
        fields.put("minimumFractionDigits", dform.getMinimumFractionDigits());
        fields.put("serialVersionOnStream", 4);
        stream.writeFields();
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.875 -0400", hash_original_method = "779EB6B3B1C2B5888DC5BF2D6BFB0D9C", hash_generated_method = "C0D79E299343B1EAA4573C287B1C51D6")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        this.symbols = (DecimalFormatSymbols) fields.get("symbols", null);
        initNative("");
        dform.setPositivePrefix((String) fields.get("positivePrefix", ""));
        dform.setPositiveSuffix((String) fields.get("positiveSuffix", ""));
        dform.setNegativePrefix((String) fields.get("negativePrefix", "-"));
        dform.setNegativeSuffix((String) fields.get("negativeSuffix", ""));
        dform.setMultiplier(fields.get("multiplier", 1));
        dform.setGroupingSize(fields.get("groupingSize", (byte) 3));
        dform.setGroupingUsed(fields.get("groupingUsed", true));
        dform.setDecimalSeparatorAlwaysShown(fields.get("decimalSeparatorAlwaysShown", false));
        setRoundingMode((RoundingMode) fields.get("roundingMode", RoundingMode.HALF_EVEN));
        int maximumIntegerDigits;
        maximumIntegerDigits = fields.get("maximumIntegerDigits", 309);
        int minimumIntegerDigits;
        minimumIntegerDigits = fields.get("minimumIntegerDigits", 309);
        int maximumFractionDigits;
        maximumFractionDigits = fields.get("maximumFractionDigits", 340);
        int minimumFractionDigits;
        minimumFractionDigits = fields.get("minimumFractionDigits", 340);
        dform.setMaximumIntegerDigits(maximumIntegerDigits);
        super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());
        setMinimumIntegerDigits(minimumIntegerDigits);
        setMinimumFractionDigits(minimumFractionDigits);
        setMaximumFractionDigits(maximumFractionDigits);
        setParseBigDecimal(fields.get("parseBigDecimal", false));
        {
            boolean varC60DB38B4D51EB0E77F03A018CAB5ADE_335573382 = (fields.get("serialVersionOnStream", 0) < 3);
            {
                setMaximumIntegerDigits(super.getMaximumIntegerDigits());
                setMinimumIntegerDigits(super.getMinimumIntegerDigits());
                setMaximumFractionDigits(super.getMaximumFractionDigits());
                setMinimumFractionDigits(super.getMinimumFractionDigits());
            } //End block
        } //End collapsed parenthetic
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.876 -0400", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "6E105A93011FD5C797468459FB67DAE3")
    public RoundingMode getRoundingMode() {
        RoundingMode varB4EAC82CA7396A68D541C85D26508E83_1345926173 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1345926173 = roundingMode;
        varB4EAC82CA7396A68D541C85D26508E83_1345926173.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1345926173;
        // ---------- Original Method ----------
        //return roundingMode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.876 -0400", hash_original_method = "91D8E7B9A007769AA087DAF2CAD1ADF8", hash_generated_method = "14966B62E8276B4155FBDCACD7841CE1")
    public void setRoundingMode(RoundingMode roundingMode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.roundingMode = roundingMode;
        {
            double roundingIncrement;
            roundingIncrement = 1.0 / Math.pow(10, Math.max(0, getMaximumFractionDigits()));
            dform.setRoundingMode(roundingMode, roundingIncrement);
        } //End block
        // ---------- Original Method ----------
        //if (roundingMode == null) {
            //throw new NullPointerException();
        //}
        //this.roundingMode = roundingMode;
        //if (roundingMode != RoundingMode.UNNECESSARY) { 
            //double roundingIncrement = 1.0 / Math.pow(10, Math.max(0, getMaximumFractionDigits()));
            //dform.setRoundingMode(roundingMode, roundingIncrement);
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.876 -0400", hash_original_field = "942CD9CF81E9C337E6C31D8025DDE1DD", hash_generated_field = "5C170BD20C30CD1216CFFBE9D4AF34B0")

    private static long serialVersionUID = 864413376551465018L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.876 -0400", hash_original_field = "BBF28B41C805F82524E46B532E3F0E54", hash_generated_field = "B4CFF2FCEF613C96133C4D61529A5947")

    private static Double NEGATIVE_ZERO_DOUBLE = new Double(-0.0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:47.876 -0400", hash_original_field = "027B5B0757B1FB87302B2884E911C820", hash_generated_field = "7FDB8A53197896FEE7636CFD083A051B")

    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("positivePrefix", String.class),
        new ObjectStreamField("positiveSuffix", String.class),
        new ObjectStreamField("negativePrefix", String.class),
        new ObjectStreamField("negativeSuffix", String.class),
        new ObjectStreamField("posPrefixPattern", String.class),
        new ObjectStreamField("posSuffixPattern", String.class),
        new ObjectStreamField("negPrefixPattern", String.class),
        new ObjectStreamField("negSuffixPattern", String.class),
        new ObjectStreamField("multiplier", int.class),
        new ObjectStreamField("groupingSize", byte.class),
        new ObjectStreamField("groupingUsed", boolean.class),
        new ObjectStreamField("decimalSeparatorAlwaysShown", boolean.class),
        new ObjectStreamField("parseBigDecimal", boolean.class),
        new ObjectStreamField("roundingMode", RoundingMode.class),
        new ObjectStreamField("symbols", DecimalFormatSymbols.class),
        new ObjectStreamField("useExponentialNotation", boolean.class),
        new ObjectStreamField("minExponentDigits", byte.class),
        new ObjectStreamField("maximumIntegerDigits", int.class),
        new ObjectStreamField("minimumIntegerDigits", int.class),
        new ObjectStreamField("maximumFractionDigits", int.class),
        new ObjectStreamField("minimumFractionDigits", int.class),
        new ObjectStreamField("serialVersionOnStream", int.class),
    };
}

