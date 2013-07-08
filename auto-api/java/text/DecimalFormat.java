package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.076 -0400", hash_original_field = "5503577415FC1D8D6B3818212A1745BC", hash_generated_field = "52EBB9EA358F4A29D5EE09E100128428")

    private transient DecimalFormatSymbols symbols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.076 -0400", hash_original_field = "43FB3BF64083BD4CAC80E1ED8CD075E4", hash_generated_field = "311D958CADB5DD8F5620B5C0287903DF")

    private transient NativeDecimalFormat dform;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.076 -0400", hash_original_field = "56B4B01527B4EB5F82F59EBDEC4AAB14", hash_generated_field = "13F8C455B70342D0BE0D104687A9B188")

    private final Object finalizerGuardian = new Object() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.076 -0400", hash_original_method = "1A366D9719473F2399B539B354BB787B", hash_generated_method = "ABC3A607675036C5172AEFC1575529C6")
        @Override
        protected void finalize() throws Throwable {
            try 
            {
                dform.close();
            } 
            finally 
            {
                super.finalize();
            } 
            
            
                
            
                
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.076 -0400", hash_original_field = "825BD9DBFA8BD0A02A9B3F51F9F3F717", hash_generated_field = "F8D485A47161940F89EC9F4328B1DE40")

    private transient RoundingMode roundingMode = RoundingMode.HALF_EVEN;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.077 -0400", hash_original_method = "DE88C1883A924350E112FA17163006E9", hash_generated_method = "8F3D56F06F018038500D450373B97D16")
    public  DecimalFormat() {
        Locale locale = Locale.getDefault();
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(LocaleData.get(locale).numberPattern);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.077 -0400", hash_original_method = "35AB5293961F9B593ADD183E8B6B3242", hash_generated_method = "32BBE801F866CA8E0CC29DE98F1BC803")
    public  DecimalFormat(String pattern) {
        this(pattern, Locale.getDefault());
        addTaint(pattern.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.077 -0400", hash_original_method = "17CE9F29195C1874CE3535C0883BB7B4", hash_generated_method = "445D9156C045C3F33FB6A5147E1E0A10")
    public  DecimalFormat(String pattern, DecimalFormatSymbols value) {
        this.symbols = (DecimalFormatSymbols) value.clone();
        initNative(pattern);
        addTaint(pattern.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.077 -0400", hash_original_method = "1EB8095DC5F926848B20CBA55F6BDD83", hash_generated_method = "EC2FB85AC22B60BBC13FFD656B7B93E9")
      DecimalFormat(String pattern, Locale locale) {
        this.symbols = new DecimalFormatSymbols(locale);
        initNative(pattern);
        addTaint(pattern.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.077 -0400", hash_original_method = "701B7114CA5711EBC62D39124CAE5412", hash_generated_method = "B5E894FAB4E47C20F77A21B4BC851B82")
    private void initNative(String pattern) {
        try 
        {
            this.dform = new NativeDecimalFormat(pattern, symbols);
        } 
        catch (IllegalArgumentException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(pattern);
        } 
        super.setMaximumFractionDigits(dform.getMaximumFractionDigits());
        super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());
        super.setMinimumFractionDigits(dform.getMinimumFractionDigits());
        super.setMinimumIntegerDigits(dform.getMinimumIntegerDigits());
        
        
            
        
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.078 -0400", hash_original_method = "65449F4F2C00BF62B7AB916EB2126B60", hash_generated_method = "46C68ADE4038F25D5EE6328DA53973E6")
    public void applyLocalizedPattern(String pattern) {
        dform.applyLocalizedPattern(pattern);
        addTaint(pattern.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.078 -0400", hash_original_method = "09E7693F39B1CA310938A9A4756C1A20", hash_generated_method = "627B1A10821BF52281AA475FBB092F2D")
    public void applyPattern(String pattern) {
        dform.applyPattern(pattern);
        addTaint(pattern.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.078 -0400", hash_original_method = "9257BEF78EF77BD305740BB055166BA8", hash_generated_method = "8E53BC94ACA8F4935F4F3658A04E28ED")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1801123470 = null; 
        DecimalFormat clone = (DecimalFormat) super.clone();
        clone.dform = (NativeDecimalFormat) dform.clone();
        clone.symbols = (DecimalFormatSymbols) symbols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1801123470 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1801123470.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1801123470;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.079 -0400", hash_original_method = "6765E822C563E620DE26A0B6A028E00A", hash_generated_method = "053729424B44472DEFA79D5165750F96")
    @Override
    public boolean equals(Object object) {
        DecimalFormat other = (DecimalFormat) object;
        boolean var978C9F6193C72EF6E0807F28D1781CB8_83912104 = ((this.dform == null ? other.dform == null : this.dform.equals(other.dform)) &&
                getDecimalFormatSymbols().equals(other.getDecimalFormatSymbols())); 
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1005739036 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1005739036;
        
        
            
        
        
            
        
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.080 -0400", hash_original_method = "3B59068DE45E1D685899870F874FDB91", hash_generated_method = "F3266038C4214E35A6D448EF35DEB7E3")
    @Override
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1560685141 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1560685141 = dform.formatToCharacterIterator(object);
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1560685141.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1560685141;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.081 -0400", hash_original_method = "FBA2DE4CAF4AAEBE0D141C6C51AFFE4A", hash_generated_method = "C34C4E87A14DAAA340FBA5FD4A16BD64")
    private void checkBufferAndFieldPosition(StringBuffer buffer, FieldPosition position) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("buffer == null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("position == null");
        } 
        addTaint(buffer.getTaint());
        addTaint(position.getTaint());
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.082 -0400", hash_original_method = "1E84E5D2AEBA1220C1C2BABB55EE58F4", hash_generated_method = "8ADB8536A4759DE7EB19808D0779273F")
    @Override
    public StringBuffer format(double value, StringBuffer buffer, FieldPosition position) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_451518009 = null; 
        checkBufferAndFieldPosition(buffer, position);
        {
            try 
            {
                setRoundingMode(RoundingMode.UP);
                String upResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                setRoundingMode(RoundingMode.DOWN);
                String downResult = format(value, new StringBuffer(), new FieldPosition(0)).toString();
                {
                    boolean var2F746E5BABC839274FF6C5CAE9A27612_1549578677 = (!upResult.equals(downResult));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ArithmeticException("rounding mode UNNECESSARY but rounding required");
                    } 
                } 
            } 
            finally 
            {
                setRoundingMode(RoundingMode.UNNECESSARY);
            } 
        } 
        buffer.append(dform.formatDouble(value, position));
        varB4EAC82CA7396A68D541C85D26508E83_451518009 = buffer;
        addTaint(value);
        addTaint(buffer.getTaint());
        addTaint(position.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_451518009.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_451518009;
        
        
        
            
                
                
                
                
                
                    
                
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.082 -0400", hash_original_method = "B4F0904648F2A25561C63568681C231B", hash_generated_method = "BD6CE7FDA8860A9E7A881B98E5264211")
    @Override
    public StringBuffer format(long value, StringBuffer buffer, FieldPosition position) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1388662701 = null; 
        checkBufferAndFieldPosition(buffer, position);
        buffer.append(dform.formatLong(value, position));
        varB4EAC82CA7396A68D541C85D26508E83_1388662701 = buffer;
        addTaint(value);
        addTaint(buffer.getTaint());
        addTaint(position.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1388662701.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1388662701;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.083 -0400", hash_original_method = "9F0187C663B029586FEAEE5997EF0E8A", hash_generated_method = "AA9E8B06BF174BD4BAFD36D14ECA370F")
    @Override
    public final StringBuffer format(Object number, StringBuffer buffer, FieldPosition position) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1267097412 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_588892193 = null; 
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_932297401 = null; 
        checkBufferAndFieldPosition(buffer, position);
        {
            BigInteger bigInteger = (BigInteger) number;
            char[] chars;
            boolean var13ED5CFC28017CACC4A5C2EC4BA37F58_1987209436 = ((bigInteger.bitLength() < 64));
            chars = dform.formatLong(bigInteger.longValue(), position);
            chars = dform.formatBigInteger(bigInteger, position);
            buffer.append(chars);
            varB4EAC82CA7396A68D541C85D26508E83_1267097412 = buffer;
        } 
        {
            buffer.append(dform.formatBigDecimal((BigDecimal) number, position));
            varB4EAC82CA7396A68D541C85D26508E83_588892193 = buffer;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_932297401 = super.format(number, buffer, position);
        addTaint(number.getTaint());
        addTaint(buffer.getTaint());
        addTaint(position.getTaint());
        StringBuffer varA7E53CE21691AB073D9660D615818899_312184236; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_312184236 = varB4EAC82CA7396A68D541C85D26508E83_1267097412;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_312184236 = varB4EAC82CA7396A68D541C85D26508E83_588892193;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_312184236 = varB4EAC82CA7396A68D541C85D26508E83_932297401;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_312184236.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_312184236;
        
        
        
            
            
                    
                    
            
            
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.084 -0400", hash_original_method = "8DCCB340D185077EABFD1E6BFE3DB36F", hash_generated_method = "289119B1E43D3CD738D46ECDE82A0A75")
    public DecimalFormatSymbols getDecimalFormatSymbols() {
        DecimalFormatSymbols varB4EAC82CA7396A68D541C85D26508E83_643674334 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_643674334 = (DecimalFormatSymbols) symbols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_643674334.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_643674334;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.084 -0400", hash_original_method = "58EEC1F79BF01CD73E1939B30FC9554A", hash_generated_method = "5FC7A9552B5FC007A3C57355C862328A")
    @Override
    public Currency getCurrency() {
        Currency varB4EAC82CA7396A68D541C85D26508E83_873851226 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_873851226 = symbols.getCurrency();
        varB4EAC82CA7396A68D541C85D26508E83_873851226.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_873851226;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.084 -0400", hash_original_method = "3224B3D9278B5F6729F4AC0FDDE7BC48", hash_generated_method = "3DC468C8837C1E056F40B910C6DDB78D")
    public int getGroupingSize() {
        int var84E7F84E9DB89AD1D760100A3219CD70_73306859 = (dform.getGroupingSize());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912547359 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912547359;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.084 -0400", hash_original_method = "20055FC91A272014560FDC07D160C285", hash_generated_method = "F562897239A9DB7669866C1081359FAC")
    public int getMultiplier() {
        int varD5942B62FC4C9BC329C63BE9D496D09D_555156519 = (dform.getMultiplier());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843290666 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_843290666;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.085 -0400", hash_original_method = "1F7C0591D1187101B5F5E6FCEBFE4BA7", hash_generated_method = "19B139F350E26ABD8C683E10BACBB892")
    public String getNegativePrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_545415742 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_545415742 = dform.getNegativePrefix();
        varB4EAC82CA7396A68D541C85D26508E83_545415742.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_545415742;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.085 -0400", hash_original_method = "61D6D48706CC87AEEF19B015AC798361", hash_generated_method = "5E019693C7A9EA633B3A7E312C4B2AED")
    public String getNegativeSuffix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1709612418 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1709612418 = dform.getNegativeSuffix();
        varB4EAC82CA7396A68D541C85D26508E83_1709612418.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1709612418;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.086 -0400", hash_original_method = "55B5FDB79399831D6973F7F1358A3E99", hash_generated_method = "ED92AD3CF42E49D39A487E18F92101AA")
    public String getPositivePrefix() {
        String varB4EAC82CA7396A68D541C85D26508E83_6985048 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_6985048 = dform.getPositivePrefix();
        varB4EAC82CA7396A68D541C85D26508E83_6985048.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_6985048;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.086 -0400", hash_original_method = "2B5CAE95AEB5D456BD3378DDAC8D9097", hash_generated_method = "2D3CF4EF6E536BB1C554C7F0269EF77A")
    public String getPositiveSuffix() {
        String varB4EAC82CA7396A68D541C85D26508E83_1990905043 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1990905043 = dform.getPositiveSuffix();
        varB4EAC82CA7396A68D541C85D26508E83_1990905043.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1990905043;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.086 -0400", hash_original_method = "AC91BBA5B39870FB8DAE3ED8BCCB1730", hash_generated_method = "EDE672D426FE3040CE4C36CE4A777A57")
    @Override
    public int hashCode() {
        int varAB176B7235F3D88BF17FD6DC4AB80E7B_145717862 = (dform.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479872190 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1479872190;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.086 -0400", hash_original_method = "43884003345D483D0CB1C79601B3CBE6", hash_generated_method = "1AC7BAAB60F5D94EC11B1D0A6C943390")
    public boolean isDecimalSeparatorAlwaysShown() {
        boolean var8C31534627EF9A9C01F3C98A04522156_396408786 = (dform.isDecimalSeparatorAlwaysShown());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488867271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488867271;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.086 -0400", hash_original_method = "0A7D24FF4B0BD9084E07584B0A08B543", hash_generated_method = "506544649FC320A083EFB150D81C0666")
    public boolean isParseBigDecimal() {
        boolean var0EB097AD7D30E488D1246B51922A3652_349485100 = (dform.isParseBigDecimal());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1385038318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1385038318;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.087 -0400", hash_original_method = "7481DA5537EE3F9956B6D5D3C7A225D0", hash_generated_method = "E72A49D4B0DBC85761438ED8064FFA2D")
    @Override
    public void setParseIntegerOnly(boolean value) {
        dform.setParseIntegerOnly(value);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.087 -0400", hash_original_method = "4A357353F9630D5720A9D39DD6F8D4E6", hash_generated_method = "85AA64882B1FA747A56F3B3B41C03686")
    @Override
    public boolean isParseIntegerOnly() {
        boolean var1E9CEECAA246756F13D9D10CB6BC9E3B_104667959 = (dform.isParseIntegerOnly());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_954556313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_954556313;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.088 -0400", hash_original_method = "5624B977416508FD6FAAB26F049D0D1B", hash_generated_method = "80DB00DFC91EC02C45258C12BDC505FA")
    @Override
    public Number parse(String string, ParsePosition position) {
        Number varB4EAC82CA7396A68D541C85D26508E83_371356668 = null; 
        Number varB4EAC82CA7396A68D541C85D26508E83_1787673224 = null; 
        Number varB4EAC82CA7396A68D541C85D26508E83_593348148 = null; 
        Number varB4EAC82CA7396A68D541C85D26508E83_282493048 = null; 
        Number varB4EAC82CA7396A68D541C85D26508E83_1451035862 = null; 
        Number varB4EAC82CA7396A68D541C85D26508E83_1466865830 = null; 
        Number varB4EAC82CA7396A68D541C85D26508E83_1534936770 = null; 
        Number varB4EAC82CA7396A68D541C85D26508E83_75526580 = null; 
        Number number = dform.parse(string, position);
        {
            varB4EAC82CA7396A68D541C85D26508E83_371356668 = null;
        } 
        {
            boolean varFCE5D5AECE0E50270D8E061A3C10C2CD_1517351428 = (this.isParseBigDecimal());
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1787673224 = new BigDecimal(number.longValue());
                } 
                {
                    boolean var6E0B5C3FBC13410F972BDAC62E60405B_587400808 = ((number instanceof Double) && !((Double) number).isInfinite()
                    && !((Double) number).isNaN());
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_593348148 = new BigDecimal(number.toString());
                    } 
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_282493048 = new BigDecimal(number.toString());
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1451035862 = number;
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1466865830 = new Double(number.doubleValue());
        } 
        {
            boolean var07027D739703D2CF0BA233E0500891D7_1447720271 = (this.isParseIntegerOnly() && number.equals(NEGATIVE_ZERO_DOUBLE));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1534936770 = Long.valueOf(0);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_75526580 = number;
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        Number varA7E53CE21691AB073D9660D615818899_1473062022; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1473062022 = varB4EAC82CA7396A68D541C85D26508E83_371356668;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1473062022 = varB4EAC82CA7396A68D541C85D26508E83_1787673224;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1473062022 = varB4EAC82CA7396A68D541C85D26508E83_593348148;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1473062022 = varB4EAC82CA7396A68D541C85D26508E83_282493048;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1473062022 = varB4EAC82CA7396A68D541C85D26508E83_1451035862;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1473062022 = varB4EAC82CA7396A68D541C85D26508E83_1466865830;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1473062022 = varB4EAC82CA7396A68D541C85D26508E83_1534936770;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1473062022 = varB4EAC82CA7396A68D541C85D26508E83_75526580;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1473062022.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1473062022;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.088 -0400", hash_original_method = "86D86A0FD4BCEEB43D34AB98DA52821C", hash_generated_method = "95C2A2E3AE16892F8FB3FB263B08CBB4")
    public void setDecimalFormatSymbols(DecimalFormatSymbols value) {
        {
            this.symbols = (DecimalFormatSymbols) value.clone();
            dform.setDecimalFormatSymbols(this.symbols);
        } 
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.089 -0400", hash_original_method = "4395CDF7142532C86BE10F65050BB217", hash_generated_method = "152F573F081DABBAC796EFA40F700DC5")
    @Override
    public void setCurrency(Currency currency) {
        dform.setCurrency(Currency.getInstance(currency.getCurrencyCode()));
        symbols.setCurrency(currency);
        addTaint(currency.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.089 -0400", hash_original_method = "3B253ED7615AA8E014EF753B3801D05C", hash_generated_method = "C7435753E266E512A1D229D14DF6A4D2")
    public void setDecimalSeparatorAlwaysShown(boolean value) {
        dform.setDecimalSeparatorAlwaysShown(value);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.090 -0400", hash_original_method = "C7D074F8D378A670A8F54B2C99810E6C", hash_generated_method = "487EEA6E05948491C435204E0C7E8EBB")
    public void setGroupingSize(int value) {
        dform.setGroupingSize(value);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.090 -0400", hash_original_method = "ABE655961F79B3C1FE3443634AA21C37", hash_generated_method = "9812253533C7E092A96BDA3FA83D3470")
    @Override
    public void setGroupingUsed(boolean value) {
        dform.setGroupingUsed(value);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.090 -0400", hash_original_method = "47F90CF51661FE278576148D8412D8DA", hash_generated_method = "735E7D7A9D9498334508A72144697045")
    @Override
    public boolean isGroupingUsed() {
        boolean varAA5A5B89A3DACBDF58942A2C9533A8B6_93698419 = (dform.isGroupingUsed());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2028245844 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2028245844;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.091 -0400", hash_original_method = "D0C418C01DBD33DD29A18941B68BCBF7", hash_generated_method = "E373F67BF8744FB8A9F8EA3FC47EF11B")
    @Override
    public void setMaximumFractionDigits(int value) {
        super.setMaximumFractionDigits(value);
        dform.setMaximumFractionDigits(getMaximumFractionDigits());
        setRoundingMode(roundingMode);
        addTaint(value);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.091 -0400", hash_original_method = "D5AFAB41905B13F7AD20D2FADDE73669", hash_generated_method = "FC538386AC067B5BBD72CB221104870A")
    @Override
    public void setMaximumIntegerDigits(int value) {
        super.setMaximumIntegerDigits(value);
        dform.setMaximumIntegerDigits(getMaximumIntegerDigits());
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.091 -0400", hash_original_method = "9EB52B7EEE1D2B50BAA9500CCA3AFB4E", hash_generated_method = "0D1AA3FD175C1086CC188510DF0E021C")
    @Override
    public void setMinimumFractionDigits(int value) {
        super.setMinimumFractionDigits(value);
        dform.setMinimumFractionDigits(getMinimumFractionDigits());
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.091 -0400", hash_original_method = "6EFC03984672E7D89A36C9F22F2AAB3B", hash_generated_method = "201E5AD78EBB567FA71F34C3A3FEF7EA")
    @Override
    public void setMinimumIntegerDigits(int value) {
        super.setMinimumIntegerDigits(value);
        dform.setMinimumIntegerDigits(getMinimumIntegerDigits());
        addTaint(value);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.091 -0400", hash_original_method = "2E4C739E2F1CFFD7C6A061AD5BB9ADF4", hash_generated_method = "3DC2E599FF63CBCE79067AA9DB9D8BEF")
    public void setMultiplier(int value) {
        dform.setMultiplier(value);
        addTaint(value);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.092 -0400", hash_original_method = "2C739DF56DF29E81D815FC52FA901BFF", hash_generated_method = "3F29737CA3B0CC851AE47576F086F2BB")
    public void setNegativePrefix(String value) {
        dform.setNegativePrefix(value);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.092 -0400", hash_original_method = "A51B4E91EE1B92D26334E28FF3A003CC", hash_generated_method = "C199DAB44B43BA38B39FE1CD8929A8B6")
    public void setNegativeSuffix(String value) {
        dform.setNegativeSuffix(value);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.092 -0400", hash_original_method = "7DA87D841FEB1EB829AC578209C7D87B", hash_generated_method = "03D0B68EA49BE81931E00BCF051AD269")
    public void setPositivePrefix(String value) {
        dform.setPositivePrefix(value);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.092 -0400", hash_original_method = "740675349A091E1D283FD9B9350AE3AA", hash_generated_method = "22E1EB99A6645AD75E181E1BE92FFD9F")
    public void setPositiveSuffix(String value) {
        dform.setPositiveSuffix(value);
        addTaint(value.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.093 -0400", hash_original_method = "DD680A2A91BAA011B854EB3CE1AE2AEF", hash_generated_method = "2DC186D379EF10B6FFBF622D83AE864C")
    public void setParseBigDecimal(boolean newValue) {
        dform.setParseBigDecimal(newValue);
        addTaint(newValue);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.093 -0400", hash_original_method = "487E11DF64E483CD2A017195603FADD0", hash_generated_method = "BBD48500C3325655B46A15BA4A3A4171")
    public String toLocalizedPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_1512325148 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1512325148 = dform.toLocalizedPattern();
        varB4EAC82CA7396A68D541C85D26508E83_1512325148.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1512325148;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.094 -0400", hash_original_method = "588A1CECAAE48251BC4F5156DD9C9A13", hash_generated_method = "1578EDA52CC7E4E413F75FE1E15C9A20")
    public String toPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_958508844 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_958508844 = dform.toPattern();
        varB4EAC82CA7396A68D541C85D26508E83_958508844.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_958508844;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.094 -0400", hash_original_method = "5BC6394F5F5C73D6097502885E125B6B", hash_generated_method = "1DB56C9D7CD46A0CC10E9B2608BDF783")
    private void writeObject(ObjectOutputStream stream) throws IOException, ClassNotFoundException {
        ObjectOutputStream.PutField fields = stream.putFields();
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
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.096 -0400", hash_original_method = "779EB6B3B1C2B5888DC5BF2D6BFB0D9C", hash_generated_method = "F3B0F4D330E25F7ADF50BAB4BE8CF232")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
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
        final int maximumIntegerDigits = fields.get("maximumIntegerDigits", 309);
        final int minimumIntegerDigits = fields.get("minimumIntegerDigits", 309);
        final int maximumFractionDigits = fields.get("maximumFractionDigits", 340);
        final int minimumFractionDigits = fields.get("minimumFractionDigits", 340);
        dform.setMaximumIntegerDigits(maximumIntegerDigits);
        super.setMaximumIntegerDigits(dform.getMaximumIntegerDigits());
        setMinimumIntegerDigits(minimumIntegerDigits);
        setMinimumFractionDigits(minimumFractionDigits);
        setMaximumFractionDigits(maximumFractionDigits);
        setParseBigDecimal(fields.get("parseBigDecimal", false));
        {
            boolean varC60DB38B4D51EB0E77F03A018CAB5ADE_1313558349 = (fields.get("serialVersionOnStream", 0) < 3);
            {
                setMaximumIntegerDigits(super.getMaximumIntegerDigits());
                setMinimumIntegerDigits(super.getMinimumIntegerDigits());
                setMaximumFractionDigits(super.getMaximumFractionDigits());
                setMinimumFractionDigits(super.getMinimumFractionDigits());
            } 
        } 
        addTaint(stream.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.098 -0400", hash_original_method = "665DD451D3753ACD20842BCA4E3EB32E", hash_generated_method = "BAB36CFCB6191D5287604B94D8CCC496")
    public RoundingMode getRoundingMode() {
        RoundingMode varB4EAC82CA7396A68D541C85D26508E83_1164097555 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1164097555 = roundingMode;
        varB4EAC82CA7396A68D541C85D26508E83_1164097555.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1164097555;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.100 -0400", hash_original_method = "91D8E7B9A007769AA087DAF2CAD1ADF8", hash_generated_method = "0DC428DF79E1E4D2279B15F4611B93AE")
    public void setRoundingMode(RoundingMode roundingMode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        this.roundingMode = roundingMode;
        {
            double roundingIncrement = 1.0 / Math.pow(10, Math.max(0, getMaximumFractionDigits()));
            dform.setRoundingMode(roundingMode, roundingIncrement);
        } 
        
        
            
        
        
        
            
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.100 -0400", hash_original_field = "942CD9CF81E9C337E6C31D8025DDE1DD", hash_generated_field = "942EFADCEB0CE1279370395E6155A826")

    private static final long serialVersionUID = 864413376551465018L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.100 -0400", hash_original_field = "BBF28B41C805F82524E46B532E3F0E54", hash_generated_field = "932CCB84649F025E2FD30B1EDEB9D654")

    private static final Double NEGATIVE_ZERO_DOUBLE = new Double(-0.0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.100 -0400", hash_original_field = "027B5B0757B1FB87302B2884E911C820", hash_generated_field = "27E2EF88F203E0B05638B8EC99836A70")

    private static final ObjectStreamField[] serialPersistentFields = {
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

