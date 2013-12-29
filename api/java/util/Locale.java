package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

import libcore.icu.ICU;





public final class Locale implements Cloneable, Serializable {

    /**
     * Returns the system's installed locales. This array always includes {@code
     * Locale.US}, and usually several others. Most locale-sensitive classes
     * offer their own {@code getAvailableLocales} method, which should be
     * preferred over this general purpose method.
     *
     * @see java.text.BreakIterator#getAvailableLocales()
     * @see java.text.Collator#getAvailableLocales()
     * @see java.text.DateFormat#getAvailableLocales()
     * @see java.text.DateFormatSymbols#getAvailableLocales()
     * @see java.text.DecimalFormatSymbols#getAvailableLocales()
     * @see java.text.NumberFormat#getAvailableLocales()
     * @see java.util.Calendar#getAvailableLocales()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.293 -0500", hash_original_method = "5568C13FBF0303E2B45FB831CBD412FF", hash_generated_method = "2AC3CF3C68E65229DEC68E9B7601D499")
    public static Locale[] getAvailableLocales() {
        return ICU.getAvailableLocales();
    }

    /**
     * Returns the user's preferred locale. This may have been overridden for
     * this process with {@link #setDefault}.
     *
     * <p>Since the user's locale changes dynamically, avoid caching this value.
     * Instead, use this method to look it up for each use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.296 -0500", hash_original_method = "78E4BA42BD949FF8F2A8F4719503FD6E", hash_generated_method = "5528E88B167B739C2F2D3F547188BFC8")
    public static Locale getDefault() {
        return defaultLocale;
    }

    /**
     * Returns an array of strings containing all the two-letter ISO country codes that can be
     * used as the country code when constructing a {@code Locale}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.305 -0500", hash_original_method = "6E640F85727BC14FFB8FEB6DDFDDAA44", hash_generated_method = "644E99B2E902F685DEF0A21C0788EAF5")
    public static String[] getISOCountries() {
        return ICU.getISOCountries();
    }

    /**
     * Returns an array of strings containing all the two-letter ISO language codes that can be
     * used as the language code when constructing a {@code Locale}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.306 -0500", hash_original_method = "38678B2D63B6657916CA4EA5FB99FCD8", hash_generated_method = "7930F48054954457DDF5223CDA0A04E7")
    public static String[] getISOLanguages() {
        return ICU.getISOLanguages();
    }

    /**
     * Overrides the default locale. This does not affect system configuration,
     * and attempts to override the system-provided default locale may
     * themselves be overridden by actual changes to the system configuration.
     * Code that calls this method is usually incorrect, and should be fixed by
     * passing the appropriate locale to each locale-sensitive method that's
     * called.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.310 -0500", hash_original_method = "4AE56FD65BC36355DD6ADDF31AE9381B", hash_generated_method = "D344223857F8797D194B4DB5FFFA3F96")
    public synchronized static void setDefault(Locale locale) {
        if (locale == null) {
            throw new NullPointerException();
        }
        defaultLocale = locale;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.264 -0500", hash_original_field = "75325B1AEF77849963EDF5AD27B5FB72", hash_generated_field = "3C249CD2C44FDE2FABB9E6465C331B47")


    private static final long serialVersionUID = 9149081749638150636L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.264 -0500", hash_original_field = "4E07D5DE5586A2168CAEE87877AFF20F", hash_generated_field = "7BDD40E7897A0B20ED68158A0E65F590")

    public static final Locale CANADA = new Locale(true, "en", "CA");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.265 -0500", hash_original_field = "A065F599231A93548A4FFCC459756C38", hash_generated_field = "6892784792C9F34D39D8FEB23F4ECC7C")

    public static final Locale CANADA_FRENCH = new Locale(true, "fr", "CA");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.266 -0500", hash_original_field = "93D82078E5CA3186D3524FA27C75C3BF", hash_generated_field = "815F7BAFEA33E18C6C585964A4AAD2BF")

    public static final Locale CHINA = new Locale(true, "zh", "CN");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.267 -0500", hash_original_field = "7CF5445AF6F0C606DFD885CEBE5FE859", hash_generated_field = "2AFCDD9168470113B6C8F8A14E381616")

    public static final Locale CHINESE = new Locale(true, "zh", "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.268 -0500", hash_original_field = "982CF41E4A9A6AFBABBDB4B893BABCC1", hash_generated_field = "010EE953058E1394EC388C06EEEFF35C")

    public static final Locale ENGLISH = new Locale(true, "en", "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.269 -0500", hash_original_field = "1FC7FF69D0003117F0B98F082DA5BFF0", hash_generated_field = "4121FCC78DA601AEAC97C367E5C6E05D")

    public static final Locale FRANCE = new Locale(true, "fr", "FR");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.270 -0500", hash_original_field = "797AD3B7F09EEAF17C75E70A3F60C4AB", hash_generated_field = "CBA5E07F7E68529CF82B9E96AF4E3809")

    public static final Locale FRENCH = new Locale(true, "fr", "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.270 -0500", hash_original_field = "507D0F37F34A76DB470F408BD96A6BA2", hash_generated_field = "B7E2C8DE81F1356E34A1BFA17F499BB8")

    public static final Locale GERMAN = new Locale(true, "de", "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.271 -0500", hash_original_field = "52F62819468BC007350C3A0B1D0A7BA8", hash_generated_field = "99C12CF22E8A302C658D06A543E6ABC9")

    public static final Locale GERMANY = new Locale(true, "de", "DE");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.272 -0500", hash_original_field = "0A2970B67EDE80D41DB66EC3DDE3378C", hash_generated_field = "A3398381AD52B8EE49ECC3C156390428")

    public static final Locale ITALIAN = new Locale(true, "it", "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.273 -0500", hash_original_field = "48D87F1FCB628E068AFC242B914B02B1", hash_generated_field = "6B8F2AEFB85A9DDE96656C221445E060")

    public static final Locale ITALY = new Locale(true, "it", "IT");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.274 -0500", hash_original_field = "7A3BF942ADC0132ACDBDF9033395E951", hash_generated_field = "ADB1EFC498D0885F1C7D82EFDC8A762E")

    public static final Locale JAPAN = new Locale(true, "ja", "JP");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.275 -0500", hash_original_field = "697524C091BF3375C91B1AF4F1537EC9", hash_generated_field = "E9F0251CDBFB0D682860A91571CF2885")

    public static final Locale JAPANESE = new Locale(true, "ja", "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.275 -0500", hash_original_field = "6B3DD7049FE3762E3BCFE41C01E8DF58", hash_generated_field = "CB8453466B2EFA0F4D4DB63AEF3DF7B9")

    public static final Locale KOREA = new Locale(true, "ko", "KR");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.276 -0500", hash_original_field = "81BCAD838F97ED18D6686549C007B81C", hash_generated_field = "D94D062AFAC409AAE6CD164AF870C246")

    public static final Locale KOREAN = new Locale(true, "ko", "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.277 -0500", hash_original_field = "782CBE7DD4180247190138962855AB28", hash_generated_field = "8FCD51D6A9283D26C9714E64D8EA8DFE")

    public static final Locale PRC = new Locale(true, "zh", "CN");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.278 -0500", hash_original_field = "509F6EF536B996830186234575F10B99", hash_generated_field = "C5D08DD56BA40521153147D2F8DF528D")

    public static final Locale ROOT = new Locale(true, "", "");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.279 -0500", hash_original_field = "E6D076722AF0AFC5FD9DB8E26EE4C966", hash_generated_field = "C9504C68B180C678A4DDB8147C15B90F")

    public static final Locale SIMPLIFIED_CHINESE = new Locale(true, "zh", "CN");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.280 -0500", hash_original_field = "4827D8BC080995327C9AED4500DDD579", hash_generated_field = "2187C3D4D669572A201125FA3D3DF376")

    public static final Locale TAIWAN = new Locale(true, "zh", "TW");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.281 -0500", hash_original_field = "002A17A6126660E9564AE8B102AF5AE2", hash_generated_field = "FEBC7896ADE07EF3D8CF22757D61F030")

    public static final Locale TRADITIONAL_CHINESE = new Locale(true, "zh", "TW");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.282 -0500", hash_original_field = "7BD4DD3607395235C4583611BF4F1255", hash_generated_field = "107ED72C23A2F8F9913FA2417A93830D")

    public static final Locale UK = new Locale(true, "en", "GB");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.283 -0500", hash_original_field = "DE3D52D5D63C22551CF7085EC70D2F90", hash_generated_field = "CCE42131F2E9126D82844E6ECA655BD3")

    public static final Locale US = new Locale(true, "en", "US");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.283 -0500", hash_original_field = "1082147BA465E399AC6714E24CA0A902", hash_generated_field = "982529EBDC2FA2E697C9C08FE118F9D9")

    private static Locale defaultLocale = US;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.312 -0500", hash_original_field = "D72DC702417B99C2480B964EF605EB9C", hash_generated_field = "E179BF6620C821162D69DC2C844B9C9A")


    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("country", String.class),
        new ObjectStreamField("hashcode", int.class),
        new ObjectStreamField("language", String.class),
        new ObjectStreamField("variant", String.class),
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.284 -0500", hash_original_field = "2CFCD35AE5EBE44FCC49AEAE457101C5", hash_generated_field = "19B779CD8189BCE485C226E9C90F5F3B")


    private transient String countryCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.285 -0500", hash_original_field = "9C842E52F27BB00B1A6CFB32E4460F3D", hash_generated_field = "2ECB9A2070EAE3399DFD4B61935BB4AA")

    private transient String languageCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.286 -0500", hash_original_field = "F743D36FB1FE5CE78553E29D14CA2E4D", hash_generated_field = "20B608C3BDA9F3FFBF7E6CEE9057B7C0")

    private transient String variantCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.287 -0500", hash_original_field = "6E39162223E63872FBDBE2AF0AED0B99", hash_generated_field = "34675DF76648E8EBEE86B67A25EA4CB3")

    private transient String cachedToStringResult;

    /**
     * There's a circular dependency between toLowerCase/toUpperCase and
     * Locale.US. Work around this by avoiding these methods when constructing
     * the built-in locales.
     *
     * @param unused required for this constructor to have a unique signature
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.287 -0500", hash_original_method = "3151080AB39B36B6870FE53962DD218F", hash_generated_method = "51B002A79014304904E6D6D37A8D4547")
    private Locale(boolean unused, String lowerCaseLanguageCode, String upperCaseCountryCode) {
        this.languageCode = lowerCaseLanguageCode;
        this.countryCode = upperCaseCountryCode;
        this.variantCode = "";
    }

    /**
     * Constructs a new {@code Locale} using the specified language.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.288 -0500", hash_original_method = "95F62AD785CE7F14018E0D0D1E27B00E", hash_generated_method = "A96F2B7C3EC9EA494AAA086887AA5806")
    public Locale(String language) {
        this(language, "", "");
    }

    /**
     * Constructs a new {@code Locale} using the specified language and country codes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.289 -0500", hash_original_method = "37BC67CA8C45857B55D0F669E159529A", hash_generated_method = "127917F6C0A60B48C74F456651F93671")
    public Locale(String language, String country) {
        this(language, country, "");
    }

    /**
     * Constructs a new {@code Locale} using the specified language, country,
     * and variant codes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.290 -0500", hash_original_method = "C07F4523516B5D8C3B044DC468C2EE3F", hash_generated_method = "0E3861966B3341EE23DBF47DDB2EF19C")
    public Locale(String language, String country, String variant) {
        if (language == null || country == null || variant == null) {
            throw new NullPointerException();
        }
        if (language.isEmpty() && country.isEmpty()) {
            languageCode = "";
            countryCode = "";
            variantCode = variant;
            return;
        }

        languageCode = language.toLowerCase(Locale.US);
        // Map new language codes to the obsolete language
        // codes so the correct resource bundles will be used.
        if (languageCode.equals("he")) {
            languageCode = "iw";
        } else if (languageCode.equals("id")) {
            languageCode = "in";
        } else if (languageCode.equals("yi")) {
            languageCode = "ji";
        }

        countryCode = country.toUpperCase(Locale.US);

        // Work around for be compatible with RI
        variantCode = variant;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.291 -0500", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "88F588A1F8F1E65DC62D9CB72E24BF48")
    @Override
public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /**
     * Returns true if {@code object} is a locale with the same language,
     * country and variant.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.292 -0500", hash_original_method = "B2DF95EC92791D38C85586E37BBFDFD0", hash_generated_method = "2A835280D4E5E6F50D1CBDDA6646FDF6")
    @Override
public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof Locale) {
            Locale o = (Locale) object;
            return languageCode.equals(o.languageCode)
                    && countryCode.equals(o.countryCode)
                    && variantCode.equals(o.variantCode);
        }
        return false;
    }

    /**
     * Returns the country code for this locale, or {@code ""} if this locale
     * doesn't correspond to a specific country.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.294 -0500", hash_original_method = "40EA1D1DD90B3BAB3C58BE2B6A46A98D", hash_generated_method = "7C96061093369960A16CB5146C11B315")
    public String getCountry() {
        return countryCode;
    }

    /**
     * Equivalent to {@code getDisplayCountry(Locale.getDefault())}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.297 -0500", hash_original_method = "6B1507A0394E6A6AE91AAA3FFF27DCC6", hash_generated_method = "13A619631B30CDC22750A0591C2C1458")
    public final String getDisplayCountry() {
        return getDisplayCountry(getDefault());
    }

    /**
     * Returns the name of this locale's country, localized to {@code locale}.
     * Returns the empty string if this locale does not correspond to a specific
     * country.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.297 -0500", hash_original_method = "6391C14D02F936975118F82A1E774FAD", hash_generated_method = "C5EC02FFA47546FEB98228CD410406C6")
    public String getDisplayCountry(Locale locale) {
        if (countryCode.isEmpty()) {
            return "";
        }
        String result = ICU.getDisplayCountryNative(toString(), locale.toString());
        if (result == null) { // TODO: do we need to do this, or does ICU do it for us?
            result = ICU.getDisplayCountryNative(toString(), Locale.getDefault().toString());
        }
        return result;
    }

    /**
     * Equivalent to {@code getDisplayLanguage(Locale.getDefault())}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.298 -0500", hash_original_method = "8536CE63A6B8A68C05EDBD72A683988E", hash_generated_method = "936FBC2851159DA15FCBF0993A46BF28")
    public final String getDisplayLanguage() {
        return getDisplayLanguage(getDefault());
    }

    /**
     * Returns the name of this locale's language, localized to {@code locale}.
     * If the language name is unknown, the language code is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.299 -0500", hash_original_method = "C0028041B7C295EE912CA1345544B282", hash_generated_method = "C843849C9B24E9CAC4912723FA1AEEEA")
    public String getDisplayLanguage(Locale locale) {
        if (languageCode.isEmpty()) {
            return "";
        }
        String result = ICU.getDisplayLanguageNative(toString(), locale.toString());
        if (result == null) { // TODO: do we need to do this, or does ICU do it for us?
            result = ICU.getDisplayLanguageNative(toString(), Locale.getDefault().toString());
        }
        return result;
    }

    /**
     * Equivalent to {@code getDisplayName(Locale.getDefault())}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.300 -0500", hash_original_method = "CBF375FE343ED989DA3B5B8CCC8BE7E0", hash_generated_method = "07D062CF9B5F1AE1AE52E8FEE2B14627")
    public final String getDisplayName() {
        return getDisplayName(getDefault());
    }

    /**
     * Returns this locale's language name, country name, and variant, localized
     * to {@code locale}. The exact output form depends on whether this locale
     * corresponds to a specific language, country and variant.
     *
     * <p>For example:
     * <ul>
     * <li>{@code new Locale("en").getDisplayName(Locale.US)} -> {@code English}
     * <li>{@code new Locale("en", "US").getDisplayName(Locale.US)} -> {@code English (United States)}
     * <li>{@code new Locale("en", "US", "POSIX").getDisplayName(Locale.US)} -> {@code English (United States,Computer)}
     * <li>{@code new Locale("en").getDisplayName(Locale.FRANCE)} -> {@code anglais}
     * <li>{@code new Locale("en", "US").getDisplayName(Locale.FRANCE)} -> {@code anglais (États-Unis)}
     * <li>{@code new Locale("en", "US", "POSIX").getDisplayName(Locale.FRANCE)} -> {@code anglais (États-Unis,informatique)}.
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.301 -0500", hash_original_method = "82746EC2958D563F59B7A18594C66ADB", hash_generated_method = "F5F53BDA6F01586D674632BB6399238C")
    public String getDisplayName(Locale locale) {
        int count = 0;
        StringBuilder buffer = new StringBuilder();
        if (!languageCode.isEmpty()) {
            String displayLanguage = getDisplayLanguage(locale);
            buffer.append(displayLanguage.isEmpty() ? languageCode : displayLanguage);
            ++count;
        }
        if (!countryCode.isEmpty()) {
            if (count == 1) {
                buffer.append(" (");
            }
            String displayCountry = getDisplayCountry(locale);
            buffer.append(displayCountry.isEmpty() ? countryCode : displayCountry);
            ++count;
        }
        if (!variantCode.isEmpty()) {
            if (count == 1) {
                buffer.append(" (");
            } else if (count == 2) {
                buffer.append(",");
            }
            String displayVariant = getDisplayVariant(locale);
            buffer.append(displayVariant.isEmpty() ? variantCode : displayVariant);
            ++count;
        }
        if (count > 1) {
            buffer.append(")");
        }
        return buffer.toString();
    }

    /**
     * Returns the full variant name in the default {@code Locale} for the variant code of
     * this {@code Locale}. If there is no matching variant name, the variant code is
     * returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.302 -0500", hash_original_method = "A8FFA206A883AC51133D493CCCB1ED67", hash_generated_method = "AA8C28D44205C67A7BAF0605809C7AF2")
    public final String getDisplayVariant() {
        return getDisplayVariant(getDefault());
    }

    /**
     * Returns the full variant name in the specified {@code Locale} for the variant code
     * of this {@code Locale}. If there is no matching variant name, the variant code is
     * returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.303 -0500", hash_original_method = "4A12574A7D5205BB7F7224B1AB3BA842", hash_generated_method = "EBFBA9D34FB2B066F4AC862B60DC0A90")
    public String getDisplayVariant(Locale locale) {
        if (variantCode.length() == 0) {
            return variantCode;
        }
        String result = ICU.getDisplayVariantNative(toString(), locale.toString());
        if (result == null) { // TODO: do we need to do this, or does ICU do it for us?
            result = ICU.getDisplayVariantNative(toString(), Locale.getDefault().toString());
        }
        return result;
    }

    /**
     * Returns the three letter ISO country code which corresponds to the country
     * code for this {@code Locale}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.304 -0500", hash_original_method = "E7148683E6358C89AEF160E990AAEE93", hash_generated_method = "2B1D44748D1C9707685AE61223BC5491")
    public String getISO3Country() {
        if (countryCode.length() == 0) {
            return countryCode;
        }
        return ICU.getISO3CountryNative(toString());
    }

    /**
     * Returns the three letter ISO language code which corresponds to the language
     * code for this {@code Locale}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.304 -0500", hash_original_method = "10ED62717CAC900A278627831D37EC4E", hash_generated_method = "765849CC445801D43C222FC8ED6C6A47")
    public String getISO3Language() {
        if (languageCode.length() == 0) {
            return languageCode;
        }
        return ICU.getISO3LanguageNative(toString());
    }

    /**
     * Returns the language code for this {@code Locale} or the empty string if no language
     * was set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.307 -0500", hash_original_method = "1C720E5AEB210852D4C515195DCC49D3", hash_generated_method = "139391AFF317C1270C7570989BBC8F6D")
    public String getLanguage() {
        return languageCode;
    }

    /**
     * Returns the variant code for this {@code Locale} or an empty {@code String} if no variant
     * was set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.308 -0500", hash_original_method = "A8C86ADBDB8FE1FD75DA90D3A9B92BDE", hash_generated_method = "DF1B458B9A1CE362841A5DD6F2CA96A3")
    public String getVariant() {
        return variantCode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.309 -0500", hash_original_method = "206F92E8CAE7869CD0834AB1BBCCF6BE", hash_generated_method = "E18CDAE08D076A97384A43E6BB2ACF8B")
    @Override
public synchronized int hashCode() {
        return countryCode.hashCode() + languageCode.hashCode()
                + variantCode.hashCode();
    }

    /**
     * Returns the string representation of this {@code Locale}. It consists of the
     * language code, country code and variant separated by underscores.
     * If the language is missing the string begins
     * with an underscore. If the country is missing there are 2 underscores
     * between the language and the variant. The variant cannot stand alone
     * without a language and/or country code: in this case this method would
     * return the empty string.
     *
     * <p>Examples: "en", "en_US", "_US", "en__POSIX", "en_US_POSIX"
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.310 -0500", hash_original_method = "8023BB72D2CCCB0AE8421793FA5DB667", hash_generated_method = "1E3120AD0D5C058834A31D770939D1DE")
    @Override
public final String toString() {
        String result = cachedToStringResult;
        return (result == null) ? (cachedToStringResult = toNewString()) : result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.311 -0500", hash_original_method = "C73C94720A0586E8BA389B0E4B761A7E", hash_generated_method = "84734A75E3B0C277AE7CC310126FCD9A")
    private String toNewString() {
        // The string form of a locale that only has a variant is the empty string.
        if (languageCode.length() == 0 && countryCode.length() == 0) {
            return "";
        }
        // Otherwise, the output format is "ll_cc_variant", where language and country are always
        // two letters, but the variant is an arbitrary length. A size of 11 characters has room
        // for "en_US_POSIX", the largest "common" value. (In practice, the string form is almost
        // always 5 characters: "ll_cc".)
        StringBuilder result = new StringBuilder(11);
        result.append(languageCode);
        if (countryCode.length() > 0 || variantCode.length() > 0) {
            result.append('_');
        }
        result.append(countryCode);
        if (variantCode.length() > 0) {
            result.append('_');
        }
        result.append(variantCode);
        return result.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.313 -0500", hash_original_method = "03500CE785032DF09CF1C69BAF02C627", hash_generated_method = "9378E239BFB3992951AE967EACE0EF26")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        fields.put("country", countryCode);
        fields.put("hashcode", -1);
        fields.put("language", languageCode);
        fields.put("variant", variantCode);
        stream.writeFields();
    }
    static {
        String language = System.getProperty("user.language", "en");
        String region = System.getProperty("user.region", "US");
        String variant = System.getProperty("user.variant", "");
        defaultLocale = new Locale(language, region, variant);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:00.314 -0500", hash_original_method = "119900B43F45E61950B2C4FD2DBBE050", hash_generated_method = "BBDB5E33F6C47AA7E9B094ADBE9CD7C7")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        countryCode = (String) fields.get("country", "");
        languageCode = (String) fields.get("language", "");
        variantCode = (String) fields.get("variant", "");
    }
}

