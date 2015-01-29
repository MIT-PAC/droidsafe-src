package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import libcore.icu.TimeZones;
import android.app.ActivityManagerNative;
import android.app.AlarmManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.wifi.WifiManager;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;

public final class MccTable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.328 -0500", hash_original_method = "2CA43D831C179A4A5B546BDDFBFDA59B", hash_generated_method = "4C4287B6DD12C1AE48C662752FB74E72")
    
private static MccEntry
    entryForMcc(int mcc)
    {
        int index;

        MccEntry m;

        m = new MccEntry(mcc, null, 0);

        index = Collections.binarySearch(table, m);

        if (index < 0) {
            return null;
        } else {
            return table.get(index);
        }
    }

    /**
     * Returns a default time zone ID for the given MCC.
     * @param mcc Mobile Country Code
     * @return default TimeZone ID, or null if not specified
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.331 -0500", hash_original_method = "8491D5DB3EE7F3091D07F531500A5169", hash_generated_method = "A0D1B874691031EEBD4E550BA5530EF4")
    
public static String defaultTimeZoneForMcc(int mcc) {
        MccEntry entry;

        entry = entryForMcc(mcc);
        if (entry == null || entry.iso == null) {
            return null;
        } else {
            Locale locale;
            if (entry.language == null) {
                locale = new Locale(entry.iso);
            } else {
                locale = new Locale(entry.language, entry.iso);
            }
            String[] tz = TimeZones.forLocale(locale);
            if (tz.length == 0) return null;
            return tz[0];
        }
    }

    /**
     * Given a GSM Mobile Country Code, returns
     * an ISO two-character country code if available.
     * Returns "" if unavailable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.334 -0500", hash_original_method = "A910A5ED054487EDFA510C70332A5D7D", hash_generated_method = "26895D548CEF05E807729EF7B74A9D91")
    
public static String
    countryCodeForMcc(int mcc)
    {
        MccEntry entry;

        entry = entryForMcc(mcc);

        if (entry == null) {
            return "";
        } else {
            return entry.iso;
        }
    }

    /**
     * Given a GSM Mobile Country Code, returns
     * an ISO 2-3 character language code if available.
     * Returns null if unavailable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.336 -0500", hash_original_method = "F2493C84F4B47990AC80947C22ED747B", hash_generated_method = "4EA61198BF5CD6785DDD89329CD6CAE1")
    
public static String defaultLanguageForMcc(int mcc) {
        MccEntry entry;

        entry = entryForMcc(mcc);

        if (entry == null) {
            return null;
        } else {
            return entry.language;
        }
    }

    /**
     * Given a GSM Mobile Country Code, returns
     * the smallest number of digits that M if available.
     * Returns 2 if unavailable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.339 -0500", hash_original_method = "06D01573106AABBDA29C827B71F8CBAD", hash_generated_method = "B6D030B70A5C7510AA28AA1FD161CB44")
    
public static int
    smallestDigitsMccForMnc(int mcc)
    {
        MccEntry entry;

        entry = entryForMcc(mcc);

        if (entry == null) {
            return 2;
        } else {
            return entry.smallestDigitsMnc;
        }
    }

    /**
     * Updates MCC and MNC device configuration information for application retrieving
     * correct version of resources.  If either MCC or MNC is 0, they will be ignored (not set).
     * @param phone PhoneBae to act on.
     * @param mccmnc truncated imsi with just the MCC and MNC - MNC assumed to be from 4th to end
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.342 -0500", hash_original_method = "3CA75790D64E38AC299F10F0BCF92E1D", hash_generated_method = "CD3328F82ABCF92E19F8781AD239B82F")
    
public static void updateMccMncConfiguration(PhoneBase phone, String mccmnc) {
        if (!TextUtils.isEmpty(mccmnc)) {
            int mcc, mnc;

            try {
                mcc = Integer.parseInt(mccmnc.substring(0,3));
                mnc = Integer.parseInt(mccmnc.substring(3));
            } catch (NumberFormatException e) {
                Log.e(LOG_TAG, "Error parsing IMSI");
                return;
            }

            Log.d(LOG_TAG, "updateMccMncConfiguration: mcc=" + mcc + ", mnc=" + mnc);

            if (mcc != 0) {
                setTimezoneFromMccIfNeeded(phone, mcc);
                setLocaleFromMccIfNeeded(phone, mcc);
                setWifiCountryCodeFromMcc(phone, mcc);
            }
            try {
                Configuration config = ActivityManagerNative.getDefault().getConfiguration();
                if (mcc != 0) {
                    config.mcc = mcc;
                }
                if (mnc != 0) {
                    config.mnc = mnc;
                }
                ActivityManagerNative.getDefault().updateConfiguration(config);
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "Can't update configuration", e);
            }
        }
    }

    /**
     * If the timezone is not already set, set it based on the MCC of the SIM.
     * @param phone PhoneBase to act on (get context from).
     * @param mcc Mobile Country Code of the SIM or SIM-like entity (build prop on CDMA)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.345 -0500", hash_original_method = "76A0E9C67A4AB4011B6C534473CE840F", hash_generated_method = "4BE8702F43142400023D511A975F0CB6")
    
private static void setTimezoneFromMccIfNeeded(PhoneBase phone, int mcc) {
        String timezone = SystemProperties.get(ServiceStateTracker.TIMEZONE_PROPERTY);
        if (timezone == null || timezone.length() == 0) {
            String zoneId = defaultTimeZoneForMcc(mcc);
            if (zoneId != null && zoneId.length() > 0) {
                Context context = phone.getContext();
                // Set time zone based on MCC
                AlarmManager alarm =
                        (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                alarm.setTimeZone(zoneId);
                Log.d(LOG_TAG, "timezone set to "+zoneId);
            }
        }
    }

    /**
     * If the locale is not already set, set it based on the MCC of the SIM.
     * @param phone PhoneBase to act on.
     * @param mcc Mobile Country Code of the SIM or SIM-like entity (build prop on CDMA)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.347 -0500", hash_original_method = "B2961025D5CEA5883D02C88930F5E00B", hash_generated_method = "827E3415F9311D0AF68A12E621DE32D3")
    
private static void setLocaleFromMccIfNeeded(PhoneBase phone, int mcc) {
        String language = MccTable.defaultLanguageForMcc(mcc);
        String country = MccTable.countryCodeForMcc(mcc);

        Log.d(LOG_TAG, "locale set to "+language+"_"+country);
        phone.setSystemLocale(language, country, true);
    }

    /**
     * If the number of allowed wifi channels has not been set, set it based on
     * the MCC of the SIM.
     * @param phone PhoneBase to act on (get context from).
     * @param mcc Mobile Country Code of the SIM or SIM-like entity (build prop on CDMA)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.350 -0500", hash_original_method = "06ACC1F6C925938D1CA4EEC81E2D3F89", hash_generated_method = "B47C8812EE4AFBAC783CC36559A66914")
    
private static void setWifiCountryCodeFromMcc(PhoneBase phone, int mcc) {
        String country = MccTable.countryCodeForMcc(mcc);
        if (!country.isEmpty()) {
            Context context = phone.getContext();
            Log.d(LOG_TAG, "WIFI_COUNTRY_CODE set to " + country);
            WifiManager wM = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            //persist
            wM.setCountryCode(country, true);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.304 -0500", hash_original_field = "6EC19282719CADC0C9303D64757F7E71", hash_generated_field = "91299B070A273124B228616071AB9B50")

    static final String LOG_TAG = "MccTable";
    
    static class MccEntry implements Comparable<MccEntry> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.309 -0500", hash_original_field = "B8D429B3E1B3107CAF57EB461C4539D2", hash_generated_field = "B8D429B3E1B3107CAF57EB461C4539D2")

        int mcc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.311 -0500", hash_original_field = "74A542B78F8B7E956A7D95FA4AB9F9D8", hash_generated_field = "74A542B78F8B7E956A7D95FA4AB9F9D8")

        String iso;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.313 -0500", hash_original_field = "BDB6AD26CFAC6708F3B7FBCCF0838A6D", hash_generated_field = "BDB6AD26CFAC6708F3B7FBCCF0838A6D")

        int smallestDigitsMnc;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.317 -0500", hash_original_field = "B8E4277A72E7EC5E4B1FB3FD7EE3E3AC", hash_generated_field = "B8E4277A72E7EC5E4B1FB3FD7EE3E3AC")

        String language;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.319 -0500", hash_original_method = "41A45D7D8A8860CA53114CE32C0688B1", hash_generated_method = "41A45D7D8A8860CA53114CE32C0688B1")
        
MccEntry(int mnc, String iso, int smallestDigitsMCC) {
            this(mnc, iso, smallestDigitsMCC, null);
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.322 -0500", hash_original_method = "91C885F681691E0843CDB4B5BE838DB3", hash_generated_method = "91C885F681691E0843CDB4B5BE838DB3")
        
MccEntry(int mnc, String iso, int smallestDigitsMCC, String language) {
            this.mcc = mnc;
            this.iso = iso;
            this.smallestDigitsMnc = smallestDigitsMCC;
            this.language = language;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.324 -0500", hash_original_method = "A9AC63D31BDD3C9311D3D9491FFA185B", hash_generated_method = "66B34818D328F071CCA7D3D498D51517")
        
public int compareTo(MccEntry o)
        {
            return mcc - o.mcc;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:35.306 -0500", hash_original_field = "D49EBD3E783651878C743249FF750951", hash_generated_field = "A68C3B7682C762BEA6B5DD9CED55AB83")

    static ArrayList<MccEntry> table;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.532 -0400", hash_original_method = "5AF4A6124D6CCA09BBC7BDEB9FD835ED", hash_generated_method = "5AF4A6124D6CCA09BBC7BDEB9FD835ED")
    public MccTable ()
    {
        //Synthesized constructor
    }
    static {
        table = new ArrayList<MccEntry>(240);
		table.add(new MccEntry(202,"gr",2));	
		table.add(new MccEntry(204,"nl",2,"nl"));	
		table.add(new MccEntry(206,"be",2));	
		table.add(new MccEntry(208,"fr",2,"fr"));	
		table.add(new MccEntry(212,"mc",2));	
		table.add(new MccEntry(213,"ad",2));	
		table.add(new MccEntry(214,"es",2,"es"));	
		table.add(new MccEntry(216,"hu",2));	
		table.add(new MccEntry(218,"ba",2));	
		table.add(new MccEntry(219,"hr",2));	
		table.add(new MccEntry(220,"rs",2));	
		table.add(new MccEntry(222,"it",2,"it"));	
		table.add(new MccEntry(225,"va",2,"it"));	
		table.add(new MccEntry(226,"ro",2));	
		table.add(new MccEntry(228,"ch",2,"de"));	
		table.add(new MccEntry(230,"cz",2,"cs"));	
		table.add(new MccEntry(231,"sk",2));	
		table.add(new MccEntry(232,"at",2,"de"));	
		table.add(new MccEntry(234,"gb",2,"en"));	
		table.add(new MccEntry(235,"gb",2,"en"));	
		table.add(new MccEntry(238,"dk",2));	
		table.add(new MccEntry(240,"se",2));	
		table.add(new MccEntry(242,"no",2));	
		table.add(new MccEntry(244,"fi",2));	
		table.add(new MccEntry(246,"lt",2));	
		table.add(new MccEntry(247,"lv",2));	
		table.add(new MccEntry(248,"ee",2));	
		table.add(new MccEntry(250,"ru",2));	
		table.add(new MccEntry(255,"ua",2));	
		table.add(new MccEntry(257,"by",2));	
		table.add(new MccEntry(259,"md",2));	
		table.add(new MccEntry(260,"pl",2));	
		table.add(new MccEntry(262,"de",2,"de"));	
		table.add(new MccEntry(266,"gi",2));	
		table.add(new MccEntry(268,"pt",2));	
		table.add(new MccEntry(270,"lu",2));	
		table.add(new MccEntry(272,"ie",2,"en"));	
		table.add(new MccEntry(274,"is",2));	
		table.add(new MccEntry(276,"al",2));	
		table.add(new MccEntry(278,"mt",2));	
		table.add(new MccEntry(280,"cy",2));	
		table.add(new MccEntry(282,"ge",2));	
		table.add(new MccEntry(283,"am",2));	
		table.add(new MccEntry(284,"bg",2));	
		table.add(new MccEntry(286,"tr",2));	
		table.add(new MccEntry(288,"fo",2));	
                table.add(new MccEntry(289,"ge",2));    
		table.add(new MccEntry(290,"gl",2));	
		table.add(new MccEntry(292,"sm",2));	
		table.add(new MccEntry(293,"si",2));	
                table.add(new MccEntry(294,"mk",2));   
		table.add(new MccEntry(295,"li",2));	
                table.add(new MccEntry(297,"me",2));    
		table.add(new MccEntry(302,"ca",3,""));	
		table.add(new MccEntry(308,"pm",2));	
		table.add(new MccEntry(310,"us",3,"en"));	
		table.add(new MccEntry(311,"us",3,"en"));	
		table.add(new MccEntry(312,"us",3,"en"));	
		table.add(new MccEntry(313,"us",3,"en"));	
		table.add(new MccEntry(314,"us",3,"en"));	
		table.add(new MccEntry(315,"us",3,"en"));	
		table.add(new MccEntry(316,"us",3,"en"));	
		table.add(new MccEntry(330,"pr",2));	
		table.add(new MccEntry(332,"vi",2));	
		table.add(new MccEntry(334,"mx",3));	
		table.add(new MccEntry(338,"jm",3));	
		table.add(new MccEntry(340,"gp",2));	
		table.add(new MccEntry(342,"bb",3));	
		table.add(new MccEntry(344,"ag",3));	
		table.add(new MccEntry(346,"ky",3));	
		table.add(new MccEntry(348,"vg",3));	
		table.add(new MccEntry(350,"bm",2));	
		table.add(new MccEntry(352,"gd",2));	
		table.add(new MccEntry(354,"ms",2));	
		table.add(new MccEntry(356,"kn",2));	
		table.add(new MccEntry(358,"lc",2));	
		table.add(new MccEntry(360,"vc",2));	
		table.add(new MccEntry(362,"nl",2));	
		table.add(new MccEntry(363,"aw",2));	
		table.add(new MccEntry(364,"bs",2));	
		table.add(new MccEntry(365,"ai",3));	
		table.add(new MccEntry(366,"dm",2));	
		table.add(new MccEntry(368,"cu",2));	
		table.add(new MccEntry(370,"do",2));	
		table.add(new MccEntry(372,"ht",2));	
		table.add(new MccEntry(374,"tt",2));	
		table.add(new MccEntry(376,"tc",2));	
		table.add(new MccEntry(400,"az",2));	
		table.add(new MccEntry(401,"kz",2));	
		table.add(new MccEntry(402,"bt",2));	
		table.add(new MccEntry(404,"in",2));	
		table.add(new MccEntry(405,"in",2));	
		table.add(new MccEntry(410,"pk",2));	
		table.add(new MccEntry(412,"af",2));	
		table.add(new MccEntry(413,"lk",2));	
		table.add(new MccEntry(414,"mm",2));	
		table.add(new MccEntry(415,"lb",2));	
		table.add(new MccEntry(416,"jo",2));	
		table.add(new MccEntry(417,"sy",2));	
		table.add(new MccEntry(418,"iq",2));	
		table.add(new MccEntry(419,"kw",2));	
		table.add(new MccEntry(420,"sa",2));	
		table.add(new MccEntry(421,"ye",2));	
		table.add(new MccEntry(422,"om",2));	
                table.add(new MccEntry(423,"ps",2));    
		table.add(new MccEntry(424,"ae",2));	
		table.add(new MccEntry(425,"il",2));	
		table.add(new MccEntry(426,"bh",2));	
		table.add(new MccEntry(427,"qa",2));	
		table.add(new MccEntry(428,"mn",2));	
		table.add(new MccEntry(429,"np",2));	
		table.add(new MccEntry(430,"ae",2));	
		table.add(new MccEntry(431,"ae",2));	
		table.add(new MccEntry(432,"ir",2));	
		table.add(new MccEntry(434,"uz",2));	
		table.add(new MccEntry(436,"tj",2));	
		table.add(new MccEntry(437,"kg",2));	
		table.add(new MccEntry(438,"tm",2));	
		table.add(new MccEntry(440,"jp",2,"ja"));	
		table.add(new MccEntry(441,"jp",2,"ja"));	
		table.add(new MccEntry(450,"kr",2,"ko"));	
		table.add(new MccEntry(452,"vn",2));	
		table.add(new MccEntry(454,"hk",2));	
		table.add(new MccEntry(455,"mo",2));	
		table.add(new MccEntry(456,"kh",2));	
		table.add(new MccEntry(457,"la",2));	
		table.add(new MccEntry(460,"cn",2,"zh"));	
		table.add(new MccEntry(461,"cn",2,"zh"));	
		table.add(new MccEntry(466,"tw",2));	
		table.add(new MccEntry(467,"kp",2));	
		table.add(new MccEntry(470,"bd",2));	
		table.add(new MccEntry(472,"mv",2));	
		table.add(new MccEntry(502,"my",2));	
		table.add(new MccEntry(505,"au",2,"en"));	
		table.add(new MccEntry(510,"id",2));	
		table.add(new MccEntry(514,"tl",2));	
		table.add(new MccEntry(515,"ph",2));	
		table.add(new MccEntry(520,"th",2));	
		table.add(new MccEntry(525,"sg",2,"en"));	
		table.add(new MccEntry(528,"bn",2));	
		table.add(new MccEntry(530,"nz",2, "en"));	
		table.add(new MccEntry(534,"mp",2));	
		table.add(new MccEntry(535,"gu",2));	
		table.add(new MccEntry(536,"nr",2));	
		table.add(new MccEntry(537,"pg",2));	
		table.add(new MccEntry(539,"to",2));	
		table.add(new MccEntry(540,"sb",2));	
		table.add(new MccEntry(541,"vu",2));	
		table.add(new MccEntry(542,"fj",2));	
		table.add(new MccEntry(543,"wf",2));	
		table.add(new MccEntry(544,"as",2));	
		table.add(new MccEntry(545,"ki",2));	
		table.add(new MccEntry(546,"nc",2));	
		table.add(new MccEntry(547,"pf",2));	
		table.add(new MccEntry(548,"ck",2));	
		table.add(new MccEntry(549,"ws",2));	
		table.add(new MccEntry(550,"fm",2));	
		table.add(new MccEntry(551,"mh",2));	
		table.add(new MccEntry(552,"pw",2));	
		table.add(new MccEntry(602,"eg",2));	
		table.add(new MccEntry(603,"dz",2));	
		table.add(new MccEntry(604,"ma",2));	
		table.add(new MccEntry(605,"tn",2));	
		table.add(new MccEntry(606,"ly",2));	
		table.add(new MccEntry(607,"gm",2));	
		table.add(new MccEntry(608,"sn",2));	
		table.add(new MccEntry(609,"mr",2));	
		table.add(new MccEntry(610,"ml",2));	
		table.add(new MccEntry(611,"gn",2));	
		table.add(new MccEntry(612,"ci",2));	
		table.add(new MccEntry(613,"bf",2));	
		table.add(new MccEntry(614,"ne",2));	
		table.add(new MccEntry(615,"tg",2));	
		table.add(new MccEntry(616,"bj",2));	
		table.add(new MccEntry(617,"mu",2));	
		table.add(new MccEntry(618,"lr",2));	
		table.add(new MccEntry(619,"sl",2));	
		table.add(new MccEntry(620,"gh",2));	
		table.add(new MccEntry(621,"ng",2));	
		table.add(new MccEntry(622,"td",2));	
		table.add(new MccEntry(623,"cf",2));	
		table.add(new MccEntry(624,"cm",2));	
		table.add(new MccEntry(625,"cv",2));	
		table.add(new MccEntry(626,"st",2));	
		table.add(new MccEntry(627,"gq",2));	
		table.add(new MccEntry(628,"ga",2));	
		table.add(new MccEntry(629,"cg",2));	
		table.add(new MccEntry(630,"cg",2));	
		table.add(new MccEntry(631,"ao",2));	
		table.add(new MccEntry(632,"gw",2));	
		table.add(new MccEntry(633,"sc",2));	
		table.add(new MccEntry(634,"sd",2));	
		table.add(new MccEntry(635,"rw",2));	
		table.add(new MccEntry(636,"et",2));	
		table.add(new MccEntry(637,"so",2));	
		table.add(new MccEntry(638,"dj",2));	
		table.add(new MccEntry(639,"ke",2));	
		table.add(new MccEntry(640,"tz",2));	
		table.add(new MccEntry(641,"ug",2));	
		table.add(new MccEntry(642,"bi",2));	
		table.add(new MccEntry(643,"mz",2));	
		table.add(new MccEntry(645,"zm",2));	
		table.add(new MccEntry(646,"mg",2));	
		table.add(new MccEntry(647,"re",2));	
		table.add(new MccEntry(648,"zw",2));	
		table.add(new MccEntry(649,"na",2));	
		table.add(new MccEntry(650,"mw",2));	
		table.add(new MccEntry(651,"ls",2));	
		table.add(new MccEntry(652,"bw",2));	
		table.add(new MccEntry(653,"sz",2));	
		table.add(new MccEntry(654,"km",2));	
		table.add(new MccEntry(655,"za",2,"en"));	
		table.add(new MccEntry(657,"er",2));	
		table.add(new MccEntry(702,"bz",2));	
		table.add(new MccEntry(704,"gt",2));	
		table.add(new MccEntry(706,"sv",2));	
		table.add(new MccEntry(708,"hn",3));	
		table.add(new MccEntry(710,"ni",2));	
		table.add(new MccEntry(712,"cr",2));	
		table.add(new MccEntry(714,"pa",2));	
		table.add(new MccEntry(716,"pe",2));	
		table.add(new MccEntry(722,"ar",3));	
		table.add(new MccEntry(724,"br",2));	
		table.add(new MccEntry(730,"cl",2));	
		table.add(new MccEntry(732,"co",3));	
		table.add(new MccEntry(734,"ve",2));	
		table.add(new MccEntry(736,"bo",2));	
		table.add(new MccEntry(738,"gy",2));	
		table.add(new MccEntry(740,"ec",2));	
		table.add(new MccEntry(742,"gf",2));	
		table.add(new MccEntry(744,"py",2));	
		table.add(new MccEntry(746,"sr",2));	
		table.add(new MccEntry(748,"uy",2));	
		table.add(new MccEntry(750,"fk",2));	
        Collections.sort(table);
    }
    
}

