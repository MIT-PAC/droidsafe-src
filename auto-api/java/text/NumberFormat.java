package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final long serialVersionUID = -2308460125733713944L;
    public static final int INTEGER_FIELD = 0;
    public static final int FRACTION_FIELD = 1;
    private boolean groupingUsed = true, parseIntegerOnly = false;
    private int maximumIntegerDigits = 40, minimumIntegerDigits = 1,
            maximumFractionDigits = 3, minimumFractionDigits = 0;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.135 -0400", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "011FC792A87502F916AA5B0EAAFEE5B7")
    @DSModeled(DSC.SAFE)
    protected NumberFormat() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.135 -0400", hash_original_method = "323EA29B58059AEF6BA9ED0328A60A9B", hash_generated_method = "B3057D7C0AEBB1F33670FAC3DC3961AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        Object var234434AAD2BC7C43140CB7A97B63D24C_84768095 = (super.clone());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return super.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.135 -0400", hash_original_method = "CF2A5131022F3DE945450C291D454139", hash_generated_method = "F922B4445B71C5830400DFE430C3C7CC")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.135 -0400", hash_original_method = "D30D6926B1574E72997696CC4AACA867", hash_generated_method = "A3AF95D1DFA64F9518FE923F4DB3AEE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String format(double value) {
        dsTaint.addTaint(value);
        String varB778B7555D5C57AB98CE52FF8AF8E9EF_749123985 = (format(value, new StringBuffer(), new FieldPosition(0))
                .toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return format(value, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(double value, StringBuffer buffer, FieldPosition field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.135 -0400", hash_original_method = "D84155C6B50E9BFD8F05A957DEB6EF42", hash_generated_method = "05497F1578AADF29ACAFBCC88282800C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String format(long value) {
        dsTaint.addTaint(value);
        String varB778B7555D5C57AB98CE52FF8AF8E9EF_1406759830 = (format(value, new StringBuffer(), new FieldPosition(0))
                .toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return format(value, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(long value, StringBuffer buffer, FieldPosition field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.135 -0400", hash_original_method = "294F85583D2E74BD6D7B73B5CBA517EA", hash_generated_method = "E681CD090F8CC435490B22BD66A0AAF8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringBuffer format(Object object, StringBuffer buffer, FieldPosition field) {
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(object.dsTaint);
        {
            boolean varD611950ED406B9E001DAC51F5B874D45_2049686502 = (object instanceof Byte || object instanceof Short || object instanceof Integer ||
                object instanceof Long ||
                (object instanceof BigInteger && ((BigInteger) object).bitLength() < 64));
            {
                long lv;
                lv = ((Number) object).longValue();
                StringBuffer varE4F158A0123F04DBDE18B17CFD29991F_1984239313 = (format(lv, buffer, field));
            } //End block
            {
                double dv;
                dv = ((Number) object).doubleValue();
                StringBuffer var36381DC4D90EA3D1A5775DE4B0B61A01_1238319569 = (format(dv, buffer, field));
            } //End block
        } //End collapsed parenthetic
        throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.135 -0400", hash_original_method = "6BEB9368EB9D88DA78E1C62745050C9B", hash_generated_method = "3B9E6EDBE5D8569E871CF4D025A8564A")
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableNumberFormatLocales();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.135 -0400", hash_original_method = "B4D372C49661A5E03C88F7CDA081E3AF", hash_generated_method = "8D9708F24702A4AA7DDF5BD73DE445FE")
    @DSModeled(DSC.SAFE)
    public Currency getCurrency() {
        throw new UnsupportedOperationException();
        return (Currency)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.135 -0400", hash_original_method = "258A750CE8BE13405441C959EA448B3E", hash_generated_method = "326DD9FA59ABEDC759B8356CA4C0754E")
    public static final NumberFormat getCurrencyInstance() {
        return getCurrencyInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "16A5E39250FE2E20C754792FEDF0522B", hash_generated_method = "41DEE570C68D28442F17AB74256D21CD")
    public static NumberFormat getCurrencyInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).currencyPattern, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "5548420D2F066ACFECD569FD2948AFC4", hash_generated_method = "0D3727AE0AD25B78DF9EAB50567A188F")
    public static final NumberFormat getIntegerInstance() {
        return getIntegerInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "25EF42A674E48F64B76F32D6F7A53370", hash_generated_method = "62F71791F2B9CCFF9340FDDFE343F2C5")
    public static NumberFormat getIntegerInstance(Locale locale) {
        NumberFormat result = getInstance(LocaleData.get(locale).integerPattern, locale);
        result.setParseIntegerOnly(true);
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "F7516F92C087ACF7ECF1F822BA0199BE", hash_generated_method = "D6CE1F57C2D3FCF6C95F069F1B260153")
    public static final NumberFormat getInstance() {
        return getNumberInstance();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "3A87CF816CFDA0980D70AEF11A7290C6", hash_generated_method = "BD0D464261E3C1D0AE15045C4C98DD9C")
    public static NumberFormat getInstance(Locale locale) {
        return getNumberInstance(locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "EB5EC89C6842F0D79CF1138BE0031817", hash_generated_method = "B58E08D62E82FABF334079070BB54D27")
    private static NumberFormat getInstance(String pattern, Locale locale) {
        return new DecimalFormat(pattern, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "E813DF8258936A130B114EAEAD95EDA2", hash_generated_method = "90A4AD86F756D6F60A43DB2C9E7918A6")
    @DSModeled(DSC.SAFE)
    public int getMaximumFractionDigits() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maximumFractionDigits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "78A0327FC665D89694C44AF144F747A0", hash_generated_method = "76044A0517A98EDDB73BFB3A561B3158")
    @DSModeled(DSC.SAFE)
    public int getMaximumIntegerDigits() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return maximumIntegerDigits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "357B48579C639D091425919515E6A5BC", hash_generated_method = "5BAB67CE182C0277F67FD87BDCE24DAD")
    @DSModeled(DSC.SAFE)
    public int getMinimumFractionDigits() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return minimumFractionDigits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "F5C90064F0CFBE4D6C8C4DDC2FA4814C", hash_generated_method = "F1F6C4D4B792FC11E7BF80FC77DBF098")
    @DSModeled(DSC.SAFE)
    public int getMinimumIntegerDigits() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return minimumIntegerDigits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "63F8FE3016CEBE5E29C78966580FBB54", hash_generated_method = "2D381449A417B2D2CEC017FDCBFA76E4")
    public static final NumberFormat getNumberInstance() {
        return getNumberInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "66D65C328FDAE1D86A3DA0B84FD3C3FE", hash_generated_method = "57E6D8A79AC39E4051B615DED084CA5A")
    public static NumberFormat getNumberInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).numberPattern, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "855FA915A2F7D9FBFD9E3E67A5EAB3BE", hash_generated_method = "A8A5BA5B2985FCECB0F0BEC3DAA1CF00")
    public static final NumberFormat getPercentInstance() {
        return getPercentInstance(Locale.getDefault());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "04CA5B59AD3E4BB098F73D201B017E04", hash_generated_method = "C5ED3D84C07C920C2DDDFF1B49D7B31A")
    public static NumberFormat getPercentInstance(Locale locale) {
        return getInstance(LocaleData.get(locale).percentPattern, locale);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "BA195880AA858EB457E0D875FED9F2CD", hash_generated_method = "2031C6E618C58E6F434FF4D090E8D2A9")
    @DSModeled(DSC.SAFE)
    @Override
    public int hashCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return (groupingUsed ? 1231 : 1237) + (parseIntegerOnly ? 1231 : 1237)
                //+ maximumFractionDigits + maximumIntegerDigits
                //+ minimumFractionDigits + minimumIntegerDigits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "4D5DDA7520229906D909C6D4DE03887B", hash_generated_method = "12183C21E9EAAF4442E4F345E72A1F89")
    @DSModeled(DSC.SAFE)
    public boolean isGroupingUsed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return groupingUsed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "2C7184F183FABEE99D4475D92EBC3629", hash_generated_method = "813FFA9A20604DF8E5E48AAD18AAF10B")
    @DSModeled(DSC.SAFE)
    public boolean isParseIntegerOnly() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parseIntegerOnly;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "FE3646B6613636F305FFC18B8FD2F859", hash_generated_method = "7BDBAF84CA8584DDAF416B0C01465B8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Number parse(String string) throws ParseException {
        dsTaint.addTaint(string);
        ParsePosition pos;
        pos = new ParsePosition(0);
        Number number;
        number = parse(string, pos);
        {
            boolean varD85785EE01F666E79EC762AC1E448E10_1142453211 = (pos.getIndex() == 0);
            {
                throw new ParseException("Unparseable number: \"" + string + "\"", pos.getErrorIndex());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "CBC8FD7F8E88C5B63A9D5DAA3A983953", hash_generated_method = "5DA8BA8C44DE0875DA5847F936650E83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final Object parseObject(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        {
            throw new NullPointerException("position is null");
        } //End block
        try 
        {
            Object varDA7EC1087B6BEEDBB66580DFC56CF9AB_43579571 = (parse(string, position));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "840FE994670C453CCC1032B9649CFF03", hash_generated_method = "1C9740325DBA69770172527C303FB9EE")
    @DSModeled(DSC.SAFE)
    public void setCurrency(Currency currency) {
        dsTaint.addTaint(currency.dsTaint);
        throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "A7E1435E673E29B6F1D0E28A7EA1B8E8", hash_generated_method = "34365CEA682A7A6013478B787A497360")
    @DSModeled(DSC.SAFE)
    public void setGroupingUsed(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //groupingUsed = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.136 -0400", hash_original_method = "8D829B5D993AE8CFC3165307650DC45D", hash_generated_method = "6D31F079015FE4F5BCDDCC49C9F26833")
    @DSModeled(DSC.SAFE)
    public void setMaximumFractionDigits(int value) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.137 -0400", hash_original_method = "21B8BEFD42232423658838BAC20C84FE", hash_generated_method = "21571877066E5EBECB562D30BDEBB55F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.137 -0400", hash_original_method = "2004D453A285EC62847C50B61DD7CBAF", hash_generated_method = "22C0F5C96F2B5035136CC53F1E9B9D07")
    @DSModeled(DSC.SAFE)
    public void setMinimumFractionDigits(int value) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.137 -0400", hash_original_method = "6D62345156926236ED68DA3CBABDD448", hash_generated_method = "936A8A06CAAD50BE5E36D7CB8C828364")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.137 -0400", hash_original_method = "7914BBF7EC4F88E69DC0254980E5E100", hash_generated_method = "C6F2781798D62F39C9B926F349B0DD0F")
    @DSModeled(DSC.SAFE)
    public void setParseIntegerOnly(boolean value) {
        dsTaint.addTaint(value);
        // ---------- Original Method ----------
        //parseIntegerOnly = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.137 -0400", hash_original_method = "615BDCCE0F576CE8071CDC67AB896544", hash_generated_method = "0A0A7173539D1188FEE9A198C0551009")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.137 -0400", hash_original_method = "7CE1B061AB7260929E58BDEF36BC550E", hash_generated_method = "49E583557300CD04860E8B111E94385E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        groupingUsed = fields.get("groupingUsed", true);
        parseIntegerOnly = fields.get("parseIntegerOnly", false);
        {
            boolean varB1402D125FA51CA7547D890DB81A6275_816451512 = (fields.get("serialVersionOnStream", 0) == 0);
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
            throw new InvalidObjectException("min digits greater than max digits");
        } //End block
        {
            throw new InvalidObjectException("min or max digits negative");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.137 -0400", hash_original_method = "E6FF1C57537669874BDF42CE722EB942", hash_generated_method = "A5EDD215FD273B9144E82E8E1C501F2F")
    @DSModeled(DSC.SAFE)
    public RoundingMode getRoundingMode() {
        throw new UnsupportedOperationException();
        return (RoundingMode)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.137 -0400", hash_original_method = "0C28590135419FD8FADCC2330801FC90", hash_generated_method = "185ACD32FD9C5AF3CD233BDE2319EC01")
    @DSModeled(DSC.SAFE)
    public void setRoundingMode(RoundingMode roundingMode) {
        dsTaint.addTaint(roundingMode.dsTaint);
        throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    public static class Field extends Format.Field {
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.137 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "44A9ADF13A56517663185B21C3D0C919")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Field(String fieldName) {
            super(fieldName);
            dsTaint.addTaint(fieldName);
            // ---------- Original Method ----------
        }

        
    }


    
}


