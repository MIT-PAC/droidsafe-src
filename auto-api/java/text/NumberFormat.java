package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private boolean groupingUsed = true, parseIntegerOnly = false;
    private int maximumIntegerDigits = 40, minimumIntegerDigits = 1,
            maximumFractionDigits = 3, minimumFractionDigits = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.465 -0400", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "4471CB6ABEB340D260FD4A286AE4BB26")
    @DSModeled(DSC.SAFE)
    protected NumberFormat() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.465 -0400", hash_original_method = "323EA29B58059AEF6BA9ED0328A60A9B", hash_generated_method = "B12B8FAB9E34B946C9C4A5A3AF3D2782")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        Object var234434AAD2BC7C43140CB7A97B63D24C_911894882 = (super.clone());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.465 -0400", hash_original_method = "CF2A5131022F3DE945450C291D454139", hash_generated_method = "8F72449F5A316231DE85B81C79E57D71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        {
            boolean var3F549205D4C262003697A031F89E5954_836369352 = (object == this);
        } //End collapsed parenthetic
        NumberFormat obj;
        obj = (NumberFormat) object;
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.466 -0400", hash_original_method = "D30D6926B1574E72997696CC4AACA867", hash_generated_method = "3CCDD35216D69C5E030C5327B77D58AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String format(double value) {
        dsTaint.addTaint(value);
        String varB778B7555D5C57AB98CE52FF8AF8E9EF_315187665 = (format(value, new StringBuffer(), new FieldPosition(0))
                .toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return format(value, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(double value, StringBuffer buffer, FieldPosition field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.466 -0400", hash_original_method = "D84155C6B50E9BFD8F05A957DEB6EF42", hash_generated_method = "FDBE32E520E0207219DD74122802FBE1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String format(long value) {
        dsTaint.addTaint(value);
        String varB778B7555D5C57AB98CE52FF8AF8E9EF_1294559925 = (format(value, new StringBuffer(), new FieldPosition(0))
                .toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return format(value, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(long value, StringBuffer buffer, FieldPosition field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.467 -0400", hash_original_method = "294F85583D2E74BD6D7B73B5CBA517EA", hash_generated_method = "D4EC6B2AF6518A0C9E32F6DFBA31DCEA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringBuffer format(Object object, StringBuffer buffer, FieldPosition field) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        {
            boolean varD611950ED406B9E001DAC51F5B874D45_1171199430 = (object instanceof Byte || object instanceof Short || object instanceof Integer ||
                object instanceof Long ||
                (object instanceof BigInteger && ((BigInteger) object).bitLength() < 64));
            {
                long lv;
                lv = ((Number) object).longValue();
                StringBuffer varE4F158A0123F04DBDE18B17CFD29991F_821037575 = (format(lv, buffer, field));
            } //End block
            {
                double dv;
                dv = ((Number) object).doubleValue();
                StringBuffer var36381DC4D90EA3D1A5775DE4B0B61A01_1441014127 = (format(dv, buffer, field));
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        return (StringBuffer)dsTaint.getTaint();
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

    
        public static Locale[] getAvailableLocales() {
        return ICU.getAvailableNumberFormatLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.467 -0400", hash_original_method = "B4D372C49661A5E03C88F7CDA081E3AF", hash_generated_method = "5CEE5106B1B94D97A6C19085F6987A4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Currency getCurrency() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (Currency)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        public static final NumberFormat getCurrencyInstance() {
        return getCurrencyInstance(Locale.getDefault());
    }

    
        public static NumberFormat getCurrencyInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).currencyPattern, locale);
    }

    
        public static final NumberFormat getIntegerInstance() {
        return getIntegerInstance(Locale.getDefault());
    }

    
        public static NumberFormat getIntegerInstance(Locale locale) {
        NumberFormat result = getInstance(LocaleData.get(locale).integerPattern, locale);
        result.setParseIntegerOnly(true);
        return result;
    }

    
        public static final NumberFormat getInstance() {
        return getNumberInstance();
    }

    
        public static NumberFormat getInstance(Locale locale) {
        return getNumberInstance(locale);
    }

    
        private static NumberFormat getInstance(String pattern, Locale locale) {
        return new DecimalFormat(pattern, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.468 -0400", hash_original_method = "E813DF8258936A130B114EAEAD95EDA2", hash_generated_method = "B405F1DDC14E0107A9FC5F812EE663C3")
    @DSModeled(DSC.SAFE)
    public int getMaximumFractionDigits() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maximumFractionDigits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.469 -0400", hash_original_method = "78A0327FC665D89694C44AF144F747A0", hash_generated_method = "C2CC18C7AA43FCED265E367CAF23DD35")
    @DSModeled(DSC.SAFE)
    public int getMaximumIntegerDigits() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maximumIntegerDigits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.469 -0400", hash_original_method = "357B48579C639D091425919515E6A5BC", hash_generated_method = "D71B3FAD4E0C454E1884535A209132A9")
    @DSModeled(DSC.SAFE)
    public int getMinimumFractionDigits() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return minimumFractionDigits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.469 -0400", hash_original_method = "F5C90064F0CFBE4D6C8C4DDC2FA4814C", hash_generated_method = "9DB80A1BA11F2E917BC784144A2B4E27")
    @DSModeled(DSC.SAFE)
    public int getMinimumIntegerDigits() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return minimumIntegerDigits;
    }

    
        public static final NumberFormat getNumberInstance() {
        return getNumberInstance(Locale.getDefault());
    }

    
        public static NumberFormat getNumberInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).numberPattern, locale);
    }

    
        public static final NumberFormat getPercentInstance() {
        return getPercentInstance(Locale.getDefault());
    }

    
        public static NumberFormat getPercentInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).percentPattern, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.470 -0400", hash_original_method = "BA195880AA858EB457E0D875FED9F2CD", hash_generated_method = "5BA76D04CE2B3FB3D6B4C8035A43EC19")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (groupingUsed ? 1231 : 1237) + (parseIntegerOnly ? 1231 : 1237)
                //+ maximumFractionDigits + maximumIntegerDigits
                //+ minimumFractionDigits + minimumIntegerDigits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.470 -0400", hash_original_method = "4D5DDA7520229906D909C6D4DE03887B", hash_generated_method = "21760165F0082E6998A268126F4BD94C")
    @DSModeled(DSC.SAFE)
    public boolean isGroupingUsed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return groupingUsed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.471 -0400", hash_original_method = "2C7184F183FABEE99D4475D92EBC3629", hash_generated_method = "8DCF8F5BFB3D4803A4600B755A54B62C")
    @DSModeled(DSC.SAFE)
    public boolean isParseIntegerOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parseIntegerOnly;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.471 -0400", hash_original_method = "FE3646B6613636F305FFC18B8FD2F859", hash_generated_method = "438B40FA5844A8AD4C6C96010507F912")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Number parse(String string) throws ParseException {
        dsTaint.addTaint(string);
        ParsePosition pos;
        pos = new ParsePosition(0);
        Number number;
        number = parse(string, pos);
        {
            boolean varD85785EE01F666E79EC762AC1E448E10_1200506560 = (pos.getIndex() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Unparseable number: \"" + string + "\"", pos.getErrorIndex());
            } //End block
        } //End collapsed parenthetic
        return (Number)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ParsePosition pos = new ParsePosition(0);
        //Number number = parse(string, pos);
        //if (pos.getIndex() == 0) {
            //throw new ParseException("Unparseable number: \"" + string + "\"", pos.getErrorIndex());
        //}
        //return number;
    }

    
    public abstract Number parse(String string, ParsePosition position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.471 -0400", hash_original_method = "CBC8FD7F8E88C5B63A9D5DAA3A983953", hash_generated_method = "DA2430C29333EBC084F240B5A0F8B913")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final Object parseObject(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("position is null");
        } //End block
        try 
        {
            Object varDA7EC1087B6BEEDBB66580DFC56CF9AB_61352708 = (parse(string, position));
        } //End block
        catch (Exception e)
        { }
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.472 -0400", hash_original_method = "840FE994670C453CCC1032B9649CFF03", hash_generated_method = "F4121F43FC1E91E387D8B54A287B08F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCurrency(Currency currency) {
        dsTaint.addTaint(currency.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.472 -0400", hash_original_method = "A7E1435E673E29B6F1D0E28A7EA1B8E8", hash_generated_method = "4FEF2A984F9837ABB41CF7361DB4C76F")
    @DSModeled(DSC.SAFE)
    public void setGroupingUsed(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //groupingUsed = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.472 -0400", hash_original_method = "8D829B5D993AE8CFC3165307650DC45D", hash_generated_method = "F670C22640495A18D2EFF3F4803D7652")
    @DSModeled(DSC.SAFE)
    public void setMaximumFractionDigits(int value) {
        dsTaint.addTaint(value);
        maximumFractionDigits = value < 0 ? 0 : value;
        {
            minimumFractionDigits = maximumFractionDigits;
        } //End block
        // ---------- Original Method ----------
        //maximumFractionDigits = value < 0 ? 0 : value;
        //if (maximumFractionDigits < minimumFractionDigits) {
            //minimumFractionDigits = maximumFractionDigits;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.472 -0400", hash_original_method = "21B8BEFD42232423658838BAC20C84FE", hash_generated_method = "33AC892983BB41712090F99CA9570277")
    @DSModeled(DSC.SAFE)
    public void setMaximumIntegerDigits(int value) {
        dsTaint.addTaint(value);
        maximumIntegerDigits = value < 0 ? 0 : value;
        {
            minimumIntegerDigits = maximumIntegerDigits;
        } //End block
        // ---------- Original Method ----------
        //maximumIntegerDigits = value < 0 ? 0 : value;
        //if (maximumIntegerDigits < minimumIntegerDigits) {
            //minimumIntegerDigits = maximumIntegerDigits;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.473 -0400", hash_original_method = "2004D453A285EC62847C50B61DD7CBAF", hash_generated_method = "5881E66BE2B6260D6EE9EF5F7760181A")
    @DSModeled(DSC.SAFE)
    public void setMinimumFractionDigits(int value) {
        dsTaint.addTaint(value);
        minimumFractionDigits = value < 0 ? 0 : value;
        {
            maximumFractionDigits = minimumFractionDigits;
        } //End block
        // ---------- Original Method ----------
        //minimumFractionDigits = value < 0 ? 0 : value;
        //if (maximumFractionDigits < minimumFractionDigits) {
            //maximumFractionDigits = minimumFractionDigits;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.473 -0400", hash_original_method = "6D62345156926236ED68DA3CBABDD448", hash_generated_method = "34797A977811705079968BF8030189EE")
    @DSModeled(DSC.SAFE)
    public void setMinimumIntegerDigits(int value) {
        dsTaint.addTaint(value);
        minimumIntegerDigits = value < 0 ? 0 : value;
        {
            maximumIntegerDigits = minimumIntegerDigits;
        } //End block
        // ---------- Original Method ----------
        //minimumIntegerDigits = value < 0 ? 0 : value;
        //if (maximumIntegerDigits < minimumIntegerDigits) {
            //maximumIntegerDigits = minimumIntegerDigits;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.473 -0400", hash_original_method = "7914BBF7EC4F88E69DC0254980E5E100", hash_generated_method = "1AB4114ED774661E58CC26A2222E7556")
    @DSModeled(DSC.SAFE)
    public void setParseIntegerOnly(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //parseIntegerOnly = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.474 -0400", hash_original_method = "615BDCCE0F576CE8071CDC67AB896544", hash_generated_method = "B00669893ACFFF1B62EEFBA125EDC95D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.475 -0400", hash_original_method = "7CE1B061AB7260929E58BDEF36BC550E", hash_generated_method = "91A472C5D7E8FEBC8E924649992EF0EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        groupingUsed = fields.get("groupingUsed", true);
        parseIntegerOnly = fields.get("parseIntegerOnly", false);
        {
            boolean varB1402D125FA51CA7547D890DB81A6275_237962378 = (fields.get("serialVersionOnStream", 0) == 0);
            {
                maximumFractionDigits = fields.get("maxFractionDigits", (byte) 3);
                maximumIntegerDigits = fields.get("maxIntegerDigits", (byte) 40);
                minimumFractionDigits = fields.get("minFractionDigits", (byte) 0);
                minimumIntegerDigits = fields.get("minIntegerDigits", (byte) 1);
            } //End block
            {
                maximumFractionDigits = fields.get("maximumFractionDigits", 3);
                maximumIntegerDigits = fields.get("maximumIntegerDigits", 40);
                minimumFractionDigits = fields.get("minimumFractionDigits", 0);
                minimumIntegerDigits = fields.get("minimumIntegerDigits", 1);
            } //End block
        } //End collapsed parenthetic
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("min digits greater than max digits");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("min or max digits negative");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.476 -0400", hash_original_method = "E6FF1C57537669874BDF42CE722EB942", hash_generated_method = "9125C2AAEDA53E57D6D1617D4EA19327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RoundingMode getRoundingMode() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (RoundingMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.476 -0400", hash_original_method = "0C28590135419FD8FADCC2330801FC90", hash_generated_method = "70FC891A57788C6E953F116CADD98A6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRoundingMode(RoundingMode roundingMode) {
        dsTaint.addTaint(roundingMode.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    public static class Field extends Format.Field {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.476 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "C99CCBB0448DF6198290968345EBA180")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Field(String fieldName) {
            super(fieldName);
            dsTaint.addTaint(fieldName);
            // ---------- Original Method ----------
        }

        
        private static final long serialVersionUID = 7494728892700160890L;
        public static final Field SIGN = new Field("sign");
        public static final Field INTEGER = new Field("integer");
        public static final Field FRACTION = new Field("fraction");
        public static final Field EXPONENT = new Field("exponent");
        public static final Field EXPONENT_SIGN = new Field("exponent sign");
        public static final Field EXPONENT_SYMBOL = new Field("exponent symbol");
        public static final Field DECIMAL_SEPARATOR = new Field("decimal separator");
        public static final Field GROUPING_SEPARATOR = new Field("grouping separator");
        public static final Field PERCENT = new Field("percent");
        public static final Field PERMILLE = new Field("per mille");
        public static final Field CURRENCY = new Field("currency");
    }


    
    private static final long serialVersionUID = -2308460125733713944L;
    public static final int INTEGER_FIELD = 0;
    public static final int FRACTION_FIELD = 1;
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

