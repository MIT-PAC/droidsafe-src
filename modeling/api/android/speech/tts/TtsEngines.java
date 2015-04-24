/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.speech.tts;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static android.provider.Settings.Secure.getString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.xmlpull.v1.XmlPullParserException;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.provider.Settings;
import android.speech.tts.TextToSpeech.Engine;
import android.speech.tts.TextToSpeech.EngineInfo;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;

public class TtsEngines {

    /**
     * Parses a locale preference value delimited by {@link #LOCALE_DELIMITER}.
     * Varies from {@link String#split} in that it will always return an array
     * of length 3 with non null values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.356 -0500", hash_original_method = "B09C6ED471CCD53457CEEA51CF63BCB5", hash_generated_method = "F487C9923E03CD6803D56EDAFBC6D59D")
    
public static String[] parseLocalePref(String pref) {
        String[] returnVal = new String[] { "", "", ""};
        if (!TextUtils.isEmpty(pref)) {
            String[] split = pref.split(LOCALE_DELIMITER);
            System.arraycopy(split, 0, returnVal, 0, split.length);
        }

        if (DBG) Log.d(TAG, "parseLocalePref(" + returnVal[0] + "," + returnVal[1] +
                "," + returnVal[2] +")");

        return returnVal;
    }

    /**
     * Parses a comma separated list of engine locale preferences. The list is of the
     * form {@code "engine_name_1:locale_1,engine_name_2:locale2"} and so on and
     * so forth. Returns null if the list is empty, malformed or if there is no engine
     * specific preference in the list.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.364 -0500", hash_original_method = "2F5267EC7682EE18BF8989544D09D313", hash_generated_method = "8C0495090EE1A298FA0AE3AAC4D915A7")
    
private static String parseEnginePrefFromList(String prefValue, String engineName) {
        if (TextUtils.isEmpty(prefValue)) {
            return null;
        }

        String[] prefValues = prefValue.split(",");

        for (String value : prefValues) {
            final int delimiter = value.indexOf(':');
            if (delimiter > 0) {
                if (engineName.equals(value.substring(0, delimiter))) {
                    return value.substring(delimiter + 1);
                }
            }
        }

        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.306 -0500", hash_original_field = "7136B137E99652FD014DFC963177D071", hash_generated_field = "C4D788B9A30DB979B4B514CACCF1BB4B")

    private static final String TAG = "TtsEngines";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.309 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.311 -0500", hash_original_field = "F1F93309F8E75D7CDA845D47EAE38B84", hash_generated_field = "187C46D90E30A2E475FC964C28714A03")

    private static final String LOCALE_DELIMITER = "-";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.335 -0500", hash_original_field = "F29860D3044F1EF29EC8009E2AF8D3F3", hash_generated_field = "FD63E60582DCF4480EDEA7A7945C3DEB")

    private static final String XML_TAG_NAME = "tts-engine";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.313 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.316 -0500", hash_original_method = "E276758190DBE13181DF9330ABF915FA", hash_generated_method = "03D4420E3B52249F14797891D0B79B0B")
    
public TtsEngines(Context ctx) {
        mContext = ctx;
    }

    /**
     * @return the default TTS engine. If the user has set a default, and the engine
     *         is available on the device, the default is returned. Otherwise,
     *         the highest ranked engine is returned as per {@link EngineInfoComparator}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.319 -0500", hash_original_method = "F86D04A99B76CBDE409709AB3B031B49", hash_generated_method = "4BA4F2F70C1D0F3413201B1629743251")
    
public String getDefaultEngine() {
        String engine = getString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_SYNTH);
        return isEngineInstalled(engine) ? engine : getHighestRankedEngineName();
    }

    /**
     * @return the package name of the highest ranked system engine, {@code null}
     *         if no TTS engines were present in the system image.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.321 -0500", hash_original_method = "19A7DAF08EA8F2C03F3D1884DA46504A", hash_generated_method = "A0A5C91EB98676D24A30E75581A275B5")
    
public String getHighestRankedEngineName() {
        final List<EngineInfo> engines = getEngines();

        if (engines.size() > 0 && engines.get(0).system) {
            return engines.get(0).name;
        }

        return null;
    }

    /**
     * Returns the engine info for a given engine name. Note that engines are
     * identified by their package name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.323 -0500", hash_original_method = "A5DBD894AAA6A5E1130078152956054E", hash_generated_method = "A4DBEFB358B478A6551B2129A59F03D4")
    
public EngineInfo getEngineInfo(String packageName) {
        PackageManager pm = mContext.getPackageManager();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(packageName);
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        // Note that the current API allows only one engine per
        // package name. Since the "engine name" is the same as
        // the package name.
        if (resolveInfos != null && resolveInfos.size() == 1) {
            return getEngineInfo(resolveInfos.get(0), pm);
        }

        return null;
    }

    /**
     * Gets a list of all installed TTS engines.
     *
     * @return A list of engine info objects. The list can be empty, but never {@code null}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.326 -0500", hash_original_method = "DACAAA1F42C7CE1B11C8FF369696D83F", hash_generated_method = "D5ED98CF1D32E4C22E8559F1DE73DABF")
    
public List<EngineInfo> getEngines() {
        PackageManager pm = mContext.getPackageManager();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        List<ResolveInfo> resolveInfos =
                pm.queryIntentServices(intent, PackageManager.MATCH_DEFAULT_ONLY);
        if (resolveInfos == null) return Collections.emptyList();

        List<EngineInfo> engines = new ArrayList<EngineInfo>(resolveInfos.size());

        for (ResolveInfo resolveInfo : resolveInfos) {
            EngineInfo engine = getEngineInfo(resolveInfo, pm);
            if (engine != null) {
                engines.add(engine);
            }
        }
        Collections.sort(engines, EngineInfoComparator.INSTANCE);

        return engines;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.328 -0500", hash_original_method = "096C3576F274D5610E35106CC045EF53", hash_generated_method = "29329F0285EF0138ECFEC7C464DA9AD0")
    
private boolean isSystemEngine(ServiceInfo info) {
        final ApplicationInfo appInfo = info.applicationInfo;
        return appInfo != null && (appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }

    /**
     * @return true if a given engine is installed on the system.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.330 -0500", hash_original_method = "6576B103C8DDCA7E7096DC36C32D66CE", hash_generated_method = "9DB0BF7EAD5C0BA21EDE5D5C614317D0")
    
public boolean isEngineInstalled(String engine) {
        if (engine == null) {
            return false;
        }

        return getEngineInfo(engine) != null;
    }

    /**
     * @return an intent that can launch the settings activity for a given tts engine.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.332 -0500", hash_original_method = "081B98AA3A6A550A7C51DCB59AD3D4CC", hash_generated_method = "BC93E349D01BD4E6582A8A24E1D8D6CE")
    
public Intent getSettingsIntent(String engine) {
        PackageManager pm = mContext.getPackageManager();
        Intent intent = new Intent(Engine.INTENT_ACTION_TTS_SERVICE);
        intent.setPackage(engine);
        List<ResolveInfo> resolveInfos = pm.queryIntentServices(intent,
                PackageManager.MATCH_DEFAULT_ONLY | PackageManager.GET_META_DATA);
        // Note that the current API allows only one engine per
        // package name. Since the "engine name" is the same as
        // the package name.
        if (resolveInfos != null && resolveInfos.size() == 1) {
            ServiceInfo service = resolveInfos.get(0).serviceInfo;
            if (service != null) {
                final String settings = settingsActivityFromServiceInfo(service, pm);
                if (settings != null) {
                    Intent i = new Intent();
                    i.setClassName(engine, settings);
                    return i;
                }
            }
        }

        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.338 -0500", hash_original_method = "9D4652ECD9FA23521B324D3DE279FEF6", hash_generated_method = "C218BF58374FB23848B15C54290813A9")
    
private String settingsActivityFromServiceInfo(ServiceInfo si, PackageManager pm) {
        XmlResourceParser parser = null;
        try {
            parser = si.loadXmlMetaData(pm, TextToSpeech.Engine.SERVICE_META_DATA);
            if (parser == null) {
                Log.w(TAG, "No meta-data found for :" + si);
                return null;
            }

            final Resources res = pm.getResourcesForApplication(si.applicationInfo);

            int type;
            while ((type = parser.next()) != XmlResourceParser.END_DOCUMENT) {
                if (type == XmlResourceParser.START_TAG) {
                    if (!XML_TAG_NAME.equals(parser.getName())) {
                        Log.w(TAG, "Package " + si + " uses unknown tag :"
                                + parser.getName());
                        return null;
                    }

                    final AttributeSet attrs = Xml.asAttributeSet(parser);
                    final TypedArray array = res.obtainAttributes(attrs,
                            com.android.internal.R.styleable.TextToSpeechEngine);
                    final String settings = array.getString(
                            com.android.internal.R.styleable.TextToSpeechEngine_settingsActivity);
                    array.recycle();

                    return settings;
                }
            }

            return null;
        } catch (NameNotFoundException e) {
            Log.w(TAG, "Could not load resources for : " + si);
            return null;
        } catch (XmlPullParserException e) {
            Log.w(TAG, "Error parsing metadata for " + si + ":" + e);
            return null;
        } catch (IOException e) {
            Log.w(TAG, "Error parsing metadata for " + si + ":" + e);
            return null;
        } finally {
            if (parser != null) {
                parser.close();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.341 -0500", hash_original_method = "AAFB3DF5C9862013F914C97CA1EC4890", hash_generated_method = "07AD94BED25D0DD2157B3E8D64A66409")
    
private EngineInfo getEngineInfo(ResolveInfo resolve, PackageManager pm) {
        ServiceInfo service = resolve.serviceInfo;
        if (service != null) {
            EngineInfo engine = new EngineInfo();
            // Using just the package name isn't great, since it disallows having
            // multiple engines in the same package, but that's what the existing API does.
            engine.name = service.packageName;
            CharSequence label = service.loadLabel(pm);
            engine.label = TextUtils.isEmpty(label) ? engine.name : label.toString();
            engine.icon = service.getIconResource();
            engine.priority = resolve.priority;
            engine.system = isSystemEngine(service);
            return engine;
        }

        return null;
    }

    /**
     * Returns the locale string for a given TTS engine. Attempts to read the
     * value from {@link Settings.Secure#TTS_DEFAULT_LOCALE}, failing which the
     * old style value from {@link Settings.Secure#TTS_DEFAULT_LANG} is read. If
     * both these values are empty, the default phone locale is returned.
     *
     * @param engineName the engine to return the locale for.
     * @return the locale string preference for this engine. Will be non null
     *         and non empty.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.353 -0500", hash_original_method = "18ECF8DE6689127C36214444D644F0A3", hash_generated_method = "ECB39A856209F10C9247485E724483BD")
    
public String getLocalePrefForEngine(String engineName) {
        String locale = parseEnginePrefFromList(
                getString(mContext.getContentResolver(), Settings.Secure.TTS_DEFAULT_LOCALE),
                engineName);

        if (TextUtils.isEmpty(locale)) {
            // The new style setting is unset, attempt to return the old style setting.
            locale = getV1Locale();
        }

        if (DBG) Log.d(TAG, "getLocalePrefForEngine(" + engineName + ")= " + locale);

        return locale;
    }
    
    private static class EngineInfoComparator implements Comparator<EngineInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.346 -0500", hash_original_field = "E0DE08AA64E04B0EC8D9439B823C00DF", hash_generated_field = "0CA244E03083D2D3306A1733CBDEDA51")

        static EngineInfoComparator INSTANCE = new EngineInfoComparator();
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.344 -0500", hash_original_method = "81257836895CDB49D308B7B95E17876A", hash_generated_method = "A5F988DF903195CFB8B4DE0BB7877772")
        
private EngineInfoComparator() { }

        /**
         * Engines that are a part of the system image are always lesser
         * than those that are not. Within system engines / non system engines
         * the engines are sorted in order of their declared priority.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.349 -0500", hash_original_method = "E919388D461770C5E68C050C2BB6D626", hash_generated_method = "EC5B8CE311535EBE2BDBBE66475CBE8D")
        
@Override
        public int compare(EngineInfo lhs, EngineInfo rhs) {
            if (lhs.system && !rhs.system) {
                return -1;
            } else if (rhs.system && !lhs.system) {
                return 1;
            } else {
                // Either both system engines, or both non system
                // engines.
                //
                // Note, this isn't a typo. Higher priority numbers imply
                // higher priority, but are "lower" in the sort order.
                return rhs.priority - lhs.priority;
            }
        }
    }

    /**
     * @return the old style locale string constructed from
     *         {@link Settings.Secure#TTS_DEFAULT_LANG},
     *         {@link Settings.Secure#TTS_DEFAULT_COUNTRY} and
     *         {@link Settings.Secure#TTS_DEFAULT_VARIANT}. If no such locale is set,
     *         then return the default phone locale.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.358 -0500", hash_original_method = "610702C4AF37E3C5EE6AAD794DF1E7DF", hash_generated_method = "5ABFE07DD948844F6E4589909F8D8DA1")
    
private String getV1Locale() {
        final ContentResolver cr = mContext.getContentResolver();

        final String lang = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_LANG);
        final String country = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_COUNTRY);
        final String variant = Settings.Secure.getString(cr, Settings.Secure.TTS_DEFAULT_VARIANT);

        if (TextUtils.isEmpty(lang)) {
            return getDefaultLocale();
        }

        String v1Locale = lang;
        if (!TextUtils.isEmpty(country)) {
            v1Locale += LOCALE_DELIMITER + country;
        } else {
            return v1Locale;
        }

        if (!TextUtils.isEmpty(variant)) {
            v1Locale += LOCALE_DELIMITER + variant;
        }

        return v1Locale;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.361 -0500", hash_original_method = "DCEE8BF4C9B6F52F0B0F667E0393B18E", hash_generated_method = "173E058DBECEFB809F68A169B26653CB")
    
private String getDefaultLocale() {
        final Locale locale = Locale.getDefault();

        // Note that the default locale might have an empty variant
        // or language, and we take care that the construction is
        // the same as {@link #getV1Locale} i.e no trailing delimiters
        // or spaces.
        String defaultLocale = locale.getISO3Language();
        if (TextUtils.isEmpty(defaultLocale)) {
            Log.w(TAG, "Default locale is empty.");
            return "";
        }

        if (!TextUtils.isEmpty(locale.getISO3Country())) {
            defaultLocale += LOCALE_DELIMITER + locale.getISO3Country();
        } else {
            // Do not allow locales of the form lang--variant with
            // an empty country.
            return defaultLocale;
        }
        if (!TextUtils.isEmpty(locale.getVariant())) {
            defaultLocale += LOCALE_DELIMITER + locale.getVariant();
        }

        return defaultLocale;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.366 -0500", hash_original_method = "9D847C860A473B48E829C1EE33625F6B", hash_generated_method = "F69B3596A9FA4C27A22C922F21A2DB9C")
    
public synchronized void updateLocalePrefForEngine(String name, String newLocale) {
        final String prefList = Settings.Secure.getString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_LOCALE);
        if (DBG) {
            Log.d(TAG, "updateLocalePrefForEngine(" + name + ", " + newLocale +
                    "), originally: " + prefList);
        }

        final String newPrefList = updateValueInCommaSeparatedList(prefList,
                name, newLocale);

        if (DBG) Log.d(TAG, "updateLocalePrefForEngine(), writing: " + newPrefList.toString());

        Settings.Secure.putString(mContext.getContentResolver(),
                Settings.Secure.TTS_DEFAULT_LOCALE, newPrefList.toString());
    }

    /**
     * Updates the value for a given key in a comma separated list of key value pairs,
     * each of which are delimited by a colon. If no value exists for the given key,
     * the kay value pair are appended to the end of the list.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:55.369 -0500", hash_original_method = "00BF6BD14B34E2134A0C0EF2661B3919", hash_generated_method = "83C61D7B6607B61814DDCCE16B2683BE")
    
private String updateValueInCommaSeparatedList(String list, String key,
            String newValue) {
        StringBuilder newPrefList = new StringBuilder();
        if (TextUtils.isEmpty(list)) {
            // If empty, create a new list with a single entry.
            newPrefList.append(key).append(':').append(newValue);
        } else {
            String[] prefValues = list.split(",");
            // Whether this is the first iteration in the loop.
            boolean first = true;
            // Whether we found the given key.
            boolean found = false;
            for (String value : prefValues) {
                final int delimiter = value.indexOf(':');
                if (delimiter > 0) {
                    if (key.equals(value.substring(0, delimiter))) {
                        if (first) {
                            first = false;
                        } else {
                            newPrefList.append(',');
                        }
                        found = true;
                        newPrefList.append(key).append(':').append(newValue);
                    } else {
                        if (first) {
                            first = false;
                        } else {
                            newPrefList.append(',');
                        }
                        // Copy across the entire key + value as is.
                        newPrefList.append(value);
                    }
                }
            }

            if (!found) {
                // Not found, but the rest of the keys would have been copied
                // over already, so just append it to the end.
                newPrefList.append(',');
                newPrefList.append(key).append(':').append(newValue);
            }
        }

        return newPrefList.toString();
    }
}

