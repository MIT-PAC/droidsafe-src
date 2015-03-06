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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static java.nio.charset.Charsets.UTF_8;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import libcore.io.IoUtils;
import dalvik.system.VMStack;

public abstract class ResourceBundle {

    /**
     * Finds the named resource bundle for the default {@code Locale} and the caller's
     * {@code ClassLoader}.
     *
     * @param bundleName
     *            the name of the {@code ResourceBundle}.
     * @return the requested {@code ResourceBundle}.
     * @throws MissingResourceException
     *                if the {@code ResourceBundle} cannot be found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.230 -0500", hash_original_method = "255590496454807E7D85BE3C53A0967E", hash_generated_method = "61CA38109D3BF90DCB66AE6B7CA98079")
    
public static ResourceBundle getBundle(String bundleName) throws MissingResourceException {
        ClassLoader classLoader = VMStack.getCallingClassLoader();
        if (classLoader == null) {
            classLoader = getLoader();
        }
        return getBundle(bundleName, Locale.getDefault(), classLoader);
    }

    /**
     * Finds the named {@code ResourceBundle} for the specified {@code Locale} and the caller
     * {@code ClassLoader}.
     *
     * @param bundleName
     *            the name of the {@code ResourceBundle}.
     * @param locale
     *            the {@code Locale}.
     * @return the requested resource bundle.
     * @throws MissingResourceException
     *                if the resource bundle cannot be found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.233 -0500", hash_original_method = "04CC2E12096D8B439249FDE366F3564E", hash_generated_method = "462C3465B2894C59D0D7298104991FD4")
    
public static ResourceBundle getBundle(String bundleName, Locale locale) {
        ClassLoader classLoader = VMStack.getCallingClassLoader();
        if (classLoader == null) {
            classLoader = getLoader();
        }
        return getBundle(bundleName, locale, classLoader);
    }

    /**
     * Finds the named resource bundle for the specified {@code Locale} and {@code ClassLoader}.
     *
     * The passed base name and {@code Locale} are used to create resource bundle names.
     * The first name is created by concatenating the base name with the result
     * of {@link Locale#toString()}. From this name all parent bundle names are
     * derived. Then the same thing is done for the default {@code Locale}. This results
     * in a list of possible bundle names.
     *
     * <strong>Example</strong> For the basename "BaseName", the {@code Locale} of the
     * German part of Switzerland (de_CH) and the default {@code Locale} en_US the list
     * would look something like this:
     *
     * <ol>
     * <li>BaseName_de_CH</li>
     * <li>BaseName_de</li>
     * <li>Basename_en_US</li>
     * <li>Basename_en</li>
     * <li>BaseName</li>
     * </ol>
     *
     * This list also shows the order in which the bundles will be searched for a requested
     * resource in the German part of Switzerland (de_CH).
     *
     * As a first step, this method tries to instantiate
     * a {@code ResourceBundle} with the names provided.
     * If such a class can be instantiated and initialized, it is returned and
     * all the parent bundles are instantiated too. If no such class can be
     * found this method tries to load a {@code .properties} file with the names by
     * replacing dots in the base name with a slash and by appending
     * "{@code .properties}" at the end of the string. If such a resource can be found
     * by calling {@link ClassLoader#getResource(String)} it is used to
     * initialize a {@link PropertyResourceBundle}. If this succeeds, it will
     * also load the parents of this {@code ResourceBundle}.
     *
     * For compatibility with older code, the bundle name isn't required to be
     * a fully qualified class name. It's also possible to directly pass
     * the path to a properties file (without a file extension).
     *
     * @param bundleName
     *            the name of the {@code ResourceBundle}.
     * @param locale
     *            the {@code Locale}.
     * @param loader
     *            the {@code ClassLoader} to use.
     * @return the requested {@code ResourceBundle}.
     * @throws MissingResourceException
     *                if the {@code ResourceBundle} cannot be found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.237 -0500", hash_original_method = "707AE527CA40E5BB5EF1C5E52774D069", hash_generated_method = "24872AF2D206003D769F00C7DF80C5E7")
    
public static ResourceBundle getBundle(String bundleName, Locale locale,
            ClassLoader loader) throws MissingResourceException {
        if (loader == null || bundleName == null) {
            throw new NullPointerException();
        }
        Locale defaultLocale = Locale.getDefault();
        if (!cacheLocale.equals(defaultLocale)) {
            cache.clear();
            cacheLocale = defaultLocale;
        }
        ResourceBundle bundle = null;
        if (!locale.equals(defaultLocale)) {
            bundle = handleGetBundle(false, bundleName, locale, loader);
        }
        if (bundle == null) {
            bundle = handleGetBundle(true, bundleName, defaultLocale, loader);
            if (bundle == null) {
                throw missingResourceException(bundleName + '_' + locale, "");
            }
        }
        return bundle;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.239 -0500", hash_original_method = "308F66C97E2B78E8F21601CE4DE89ADA", hash_generated_method = "D657C035271F247F36B4A10FE4716D53")
    
private static MissingResourceException missingResourceException(String className, String key) {
        String detail = "Can't find resource for bundle '" + className + "', key '" + key + "'";
        throw new MissingResourceException(detail, className, key);
    }

    /**
     * Finds the named resource bundle for the specified base name and control.
     *
     * @param baseName
     *            the base name of a resource bundle
     * @param control
     *            the control that control the access sequence
     * @return the named resource bundle
     *
     * @since 1.6
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.242 -0500", hash_original_method = "4F66A59C0DE7297F0E81661806EEDC63", hash_generated_method = "0710F52CB84499C459DDDB6E567DE685")
    
public static ResourceBundle getBundle(String baseName, ResourceBundle.Control control) {
        return getBundle(baseName, Locale.getDefault(), getLoader(), control);
    }

    /**
     * Finds the named resource bundle for the specified base name and control.
     *
     * @param baseName
     *            the base name of a resource bundle
     * @param targetLocale
     *            the target locale of the resource bundle
     * @param control
     *            the control that control the access sequence
     * @return the named resource bundle
     *
     * @since 1.6
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.244 -0500", hash_original_method = "1FCE3FD40C519D29C92F5693C1FE7B55", hash_generated_method = "7B7BD0AB9D2D836A35ACEB0593687B78")
    
public static ResourceBundle getBundle(String baseName,
            Locale targetLocale, ResourceBundle.Control control) {
        return getBundle(baseName, targetLocale, getLoader(), control);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.247 -0500", hash_original_method = "E024E4F0B2833234D75D3234DCC55B50", hash_generated_method = "38A8D07FD615BEC58BD9316D2EE2C64D")
    
private static ClassLoader getLoader() {
        ClassLoader cl = ResourceBundle.class.getClassLoader();
        if (cl == null) {
            cl = ClassLoader.getSystemClassLoader();
        }
        return cl;
    }

    /**
     * Finds the named resource bundle for the specified base name and control.
     *
     * @param baseName
     *            the base name of a resource bundle
     * @param targetLocale
     *            the target locale of the resource bundle
     * @param loader
     *            the class loader to load resource
     * @param control
     *            the control that control the access sequence
     * @return the named resource bundle
     *
     * @since 1.6
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.250 -0500", hash_original_method = "B5838CF1B848BBFBD1752201D45957B3", hash_generated_method = "7819C1FCC2823D5FC29D21C2AC4B0078")
    
public static ResourceBundle getBundle(String baseName,
            Locale targetLocale, ClassLoader loader,
            ResourceBundle.Control control) {
        boolean expired = false;
        String bundleName = control.toBundleName(baseName, targetLocale);
        Object cacheKey = loader != null ? loader : "null";
        Hashtable<String, ResourceBundle> loaderCache = getLoaderCache(cacheKey);
        ResourceBundle result = loaderCache.get(bundleName);
        if (result != null) {
            long time = control.getTimeToLive(baseName, targetLocale);
            if (time == 0 || time == Control.TTL_NO_EXPIRATION_CONTROL
                    || time + result.lastLoadTime < System.currentTimeMillis()) {
                if (MISSING == result) {
                    throw new MissingResourceException(null, bundleName + '_'
                            + targetLocale, EMPTY_STRING);
                }
                return result;
            }
            expired = true;
        }
        // try to load
        ResourceBundle ret = processGetBundle(baseName, targetLocale, loader,
                control, expired, result);

        if (ret != null) {
            loaderCache.put(bundleName, ret);
            ret.lastLoadTime = System.currentTimeMillis();
            return ret;
        }
        loaderCache.put(bundleName, MISSING);
        throw new MissingResourceException(null, bundleName + '_' + targetLocale, EMPTY_STRING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.253 -0500", hash_original_method = "FC869FE733F87E635FE0274BF77B1F99", hash_generated_method = "88948F1D0E00EA5C4A22278C7847AAD0")
    
private static ResourceBundle processGetBundle(String baseName,
            Locale targetLocale, ClassLoader loader,
            ResourceBundle.Control control, boolean expired,
            ResourceBundle result) {
        List<Locale> locales = control.getCandidateLocales(baseName, targetLocale);
        if (locales == null) {
            throw new IllegalArgumentException();
        }
        List<String> formats = control.getFormats(baseName);
        if (Control.FORMAT_CLASS == formats
                || Control.FORMAT_PROPERTIES == formats
                || Control.FORMAT_DEFAULT == formats) {
            throw new IllegalArgumentException();
        }
        ResourceBundle ret = null;
        ResourceBundle currentBundle = null;
        ResourceBundle bundle = null;
        for (Locale locale : locales) {
            for (String format : formats) {
                try {
                    if (expired) {
                        bundle = control.newBundle(baseName, locale, format,
                                loader, control.needsReload(baseName, locale,
                                        format, loader, result, System
                                                .currentTimeMillis()));

                    } else {
                        try {
                            bundle = control.newBundle(baseName, locale,
                                    format, loader, false);
                        } catch (IllegalArgumentException e) {
                            // do nothing
                        }
                    }
                } catch (IllegalAccessException e) {
                    // do nothing
                } catch (InstantiationException e) {
                    // do nothing
                } catch (IOException e) {
                    // do nothing
                }
                if (bundle != null) {
                    if (currentBundle != null) {
                        currentBundle.setParent(bundle);
                        currentBundle = bundle;
                    } else {
                        if (ret == null) {
                            ret = bundle;
                            currentBundle = ret;
                        }
                    }
                }
                if (bundle != null) {
                    break;
                }
            }
        }

        if ((ret == null)
                || (Locale.ROOT.equals(ret.getLocale()) && (!(locales.size() == 1 && locales
                        .contains(Locale.ROOT))))) {
            Locale nextLocale = control.getFallbackLocale(baseName, targetLocale);
            if (nextLocale != null) {
                ret = processGetBundle(baseName, nextLocale, loader, control,
                        expired, result);
            }
        }

        return ret;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.269 -0500", hash_original_method = "96A1B1DE513A6B9EE8F96E68DDC12C8B", hash_generated_method = "BF723F4081BC74D0606911709CC92A48")
    
private static ResourceBundle handleGetBundle(boolean loadBase, String base, Locale locale,
            ClassLoader loader) {
        String localeName = locale.toString();
        String bundleName = localeName.isEmpty()
                ? base
                : (base + "_" + localeName);
        Object cacheKey = loader != null ? loader : "null";
        Hashtable<String, ResourceBundle> loaderCache = getLoaderCache(cacheKey);
        ResourceBundle cached = loaderCache.get(bundleName);
        if (cached != null) {
            if (cached == MISSINGBASE) {
                return null;
            } else if (cached == MISSING) {
                if (!loadBase) {
                    return null;
                }
                Locale newLocale = strip(locale);
                if (newLocale == null) {
                    return null;
                }
                return handleGetBundle(loadBase, base, newLocale, loader);
            }
            return cached;
        }

        ResourceBundle bundle = null;
        try {
            Class<?> bundleClass = Class.forName(bundleName, true, loader);
            if (ResourceBundle.class.isAssignableFrom(bundleClass)) {
                bundle = (ResourceBundle) bundleClass.newInstance();
            }
        } catch (LinkageError ignored) {
        } catch (Exception ignored) {
        }

        if (bundle != null) {
            bundle.setLocale(locale);
        } else {
            String fileName = bundleName.replace('.', '/') + ".properties";
            InputStream stream = loader != null
                    ? loader.getResourceAsStream(fileName)
                    : ClassLoader.getSystemResourceAsStream(fileName);
            if (stream != null) {
                try {
                    bundle = new PropertyResourceBundle(new InputStreamReader(stream, UTF_8));
                    bundle.setLocale(locale);
                } catch (IOException ignored) {
                } finally {
                    IoUtils.closeQuietly(stream);
                }
            }
        }

        Locale strippedLocale = strip(locale);
        if (bundle != null) {
            if (strippedLocale != null) {
                ResourceBundle parent = handleGetBundle(loadBase, base, strippedLocale, loader);
                if (parent != null) {
                    bundle.setParent(parent);
                }
            }
            loaderCache.put(bundleName, bundle);
            return bundle;
        }

        if (strippedLocale != null && (loadBase || !strippedLocale.toString().isEmpty())) {
            bundle = handleGetBundle(loadBase, base, strippedLocale, loader);
            if (bundle != null) {
                loaderCache.put(bundleName, bundle);
                return bundle;
            }
        }
        loaderCache.put(bundleName, loadBase ? MISSINGBASE : MISSING);
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.272 -0500", hash_original_method = "60AB6B9414E33ED624BB99D4F3F658EB", hash_generated_method = "222809D4045433BB4289D5CCC176F457")
    
private static Hashtable<String, ResourceBundle> getLoaderCache(Object cacheKey) {
        synchronized (cache) {
            Hashtable<String, ResourceBundle> loaderCache = cache.get(cacheKey);
            if (loaderCache == null) {
                loaderCache = new Hashtable<String, ResourceBundle>();
                cache.put(cacheKey, loaderCache);
            }
            return loaderCache;
        }
    }

    /**
     * Returns a locale with the most-specific field removed, or null if this
     * locale had an empty language, country and variant.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.280 -0500", hash_original_method = "20EFD4C419C0306BF7F7822E85EB3BC6", hash_generated_method = "0115B6C69F3A1655E310DCD3E2BDB90A")
    
private static Locale strip(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        if (!variant.isEmpty()) {
            variant = "";
        } else if (!country.isEmpty()) {
            country = "";
        } else if (!language.isEmpty()) {
            language = "";
        } else {
            return null;
        }
        return new Locale(language, country, variant);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.284 -0500", hash_original_method = "BBA9BE607A69468552E43356CE603BED", hash_generated_method = "C86B2D4A8F0B152528B9F83BA1EED06A")
    
public static void clearCache() {
        cache.remove(ClassLoader.getSystemClassLoader());
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.287 -0500", hash_original_method = "DBEB4A28C83470FE64327EA18A307C5B", hash_generated_method = "3A9CD38EFE367C48CE67495BFE910028")
    
public static void clearCache(ClassLoader loader) {
        if (loader == null) {
            throw new NullPointerException();
        }
        cache.remove(loader);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.198 -0500", hash_original_field = "C9CEBD97C3684601F939E7E86D7AAC9B", hash_generated_field = "E5AACE7C1FB793E41B40495A16336A99")

    private static final String UNDER_SCORE = "_";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.201 -0500", hash_original_field = "7CB8BFC01FCDF4A2C23FAAA68C344752", hash_generated_field = "D14895E2C9628BA7CEA3A352030E9445")

    private static final String EMPTY_STRING = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.218 -0500", hash_original_field = "FDE3F83FA1D2022D3368776B51BD87A5", hash_generated_field = "85F7743A8A2325A7A53FE506DF5E477C")

    private static final ResourceBundle MISSING = new MissingBundle();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.221 -0500", hash_original_field = "796BE2CE809C6D959960C901C44AC113", hash_generated_field = "88C3120A32FE602FF897F593D3471105")

    private static final ResourceBundle MISSINGBASE = new MissingBundle();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.223 -0500", hash_original_field = "3FE9C7537A76FBCBCEAED827D4ABE4D0", hash_generated_field = "02B8BB57FAC4063B50B258C20ED67E99")

    private static final WeakHashMap<Object, Hashtable<String, ResourceBundle>> cache
            = new WeakHashMap<Object, Hashtable<String, ResourceBundle>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.225 -0500", hash_original_field = "907C2FA1D30F9868404E47C387BA8223", hash_generated_field = "FB53443D57FD33E6486E78E1759D3531")

    private static Locale cacheLocale = Locale.getDefault();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.203 -0500", hash_original_field = "724F485301376691F953BF28D348E90C", hash_generated_field = "EB43973F1559584562CFC00E839EB2BD")

    protected ResourceBundle parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.205 -0500", hash_original_field = "A25411C3C357716626A9185E220A5EAA", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.208 -0500", hash_original_field = "FFC4AC36E31DCDDF95308B0D32D3E6C2", hash_generated_field = "7B08633B611AECF1A2DAD9D2043C79EB")

    private long lastLoadTime = 0;

    /**
     * Constructs a new instance of this class.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.228 -0500", hash_original_method = "D851446F8E957DA41A03795AD93701D3", hash_generated_method = "243980320469A8684526ECB107426B50")
    
public ResourceBundle() {
        /* empty */
    }

    /**
     * Returns the names of the resources contained in this {@code ResourceBundle}.
     *
     * @return an {@code Enumeration} of the resource names.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.256 -0500", hash_original_method = "0B3D13CE7D14221019EFB6B46B551CCE", hash_generated_method = "61A76CA463024F00D4A1D9856E3DCEBE")
    
public abstract Enumeration<String> getKeys();

    /**
     * Gets the {@code Locale} of this {@code ResourceBundle}. In case a bundle was not
     * found for the requested {@code Locale}, this will return the actual {@code Locale} of
     * this resource bundle that was found after doing a fallback.
     *
     * @return the {@code Locale} of this {@code ResourceBundle}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.258 -0500", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "424B5570E26DE121275BC9C58AD53C4D")
    
public Locale getLocale() {
        return locale;
    }

    /**
     * Returns the named resource from this {@code ResourceBundle}. If the resource
     * cannot be found in this bundle, it falls back to the parent bundle (if
     * it's not null) by calling the {@link #handleGetObject} method. If the resource still
     * can't be found it throws a {@code MissingResourceException}.
     *
     * @param key
     *            the name of the resource.
     * @return the resource object.
     * @throws MissingResourceException
     *                if the resource is not found.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.261 -0500", hash_original_method = "5F9FE4637FD5B65A8B96E90EE5158818", hash_generated_method = "49CE3461BF0C507900DBE7FCE2F2CFE6")
    
public final Object getObject(String key) {
        ResourceBundle last, theParent = this;
        do {
            Object result = theParent.handleGetObject(key);
            if (result != null) {
                return result;
            }
            last = theParent;
            theParent = theParent.parent;
        } while (theParent != null);
        throw missingResourceException(last.getClass().getName(), key);
    }

    /**
     * Returns the named string resource from this {@code ResourceBundle}.
     *
     * @param key
     *            the name of the resource.
     * @return the resource string.
     * @throws MissingResourceException
     *                if the resource is not found.
     * @throws ClassCastException
     *                if the resource found is not a string.
     * @see #getObject(String)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.263 -0500", hash_original_method = "BF93FB2083E0950C32E8F3481E34A9FB", hash_generated_method = "5A6EDD64E7AC080B92BCD0179FDDA64F")
    
public final String getString(String key) {
        return (String) getObject(key);
    }

    /**
     * Returns the named resource from this {@code ResourceBundle}.
     *
     * @param key
     *            the name of the resource.
     * @return the resource string array.
     * @throws MissingResourceException
     *                if the resource is not found.
     * @throws ClassCastException
     *                if the resource found is not an array of strings.
     * @see #getObject(String)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.266 -0500", hash_original_method = "D1E41ED4E95B94C38D8DBD0F59139218", hash_generated_method = "4E8EF81D6CCA817C884A518106011035")
    
public final String[] getStringArray(String key) {
        return (String[]) getObject(key);
    }
    
    static class MissingBundle extends ResourceBundle {
        
        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.660 -0400", hash_original_method = "5BE09748C47EC015C065AB0FE98F6425", hash_generated_method = "5BE09748C47EC015C065AB0FE98F6425")
        public MissingBundle ()
        {
            //Synthesized constructor
        }
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.211 -0500", hash_original_method = "FAC6F24BFEFF063353B4F824D489D5CA", hash_generated_method = "F748CF453B8DC8A57A1C86D2BE093A7F")
        
@Override
        public Enumeration<String> getKeys() {
            return null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.213 -0500", hash_original_method = "F3BE912397EA9F5D184546387C802359", hash_generated_method = "3C57C6BBD29610384AEA6B20A2BD7091")
        
@Override
        public Object handleGetObject(String name) {
            return null;
        }
        
    }
    
    private static class NoFallbackControl extends Control {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.298 -0500", hash_original_field = "A019761C028BB0E455B549F0CF31BBE1", hash_generated_field = "311001FFE9CF90DDC4781726BDC7CC2A")

        static final Control NOFALLBACK_FORMAT_PROPERTIES_CONTROL = new NoFallbackControl(
                JAVAPROPERTIES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.301 -0500", hash_original_field = "D0EFB0076CE33D51D0BC7800CEAFD110", hash_generated_field = "477E16589760E3D71EC82A0A4D59108B")

        static final Control NOFALLBACK_FORMAT_CLASS_CONTROL = new NoFallbackControl(
                JAVACLASS);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.303 -0500", hash_original_field = "38C1762A76C5DFADE5C4CEBF242ACC17", hash_generated_field = "58917EB628BB81A37E51203F85E79CF8")

        static final Control NOFALLBACK_FORMAT_DEFAULT_CONTROL = new NoFallbackControl(
                listDefault);

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.306 -0500", hash_original_method = "FB8596E95C5FFB192AB3B86CF874FD9D", hash_generated_method = "4807741D76F32A8AA10E71A28DBD0AE5")
        
public NoFallbackControl(String format) {
            listClass = new ArrayList<String>();
            listClass.add(format);
            super.format = Collections.unmodifiableList(listClass);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.309 -0500", hash_original_method = "EC736F9DA869A1318E5C5EA158F0C9E2", hash_generated_method = "AC7E336BB69053D02718DADFEC1789FC")
        
public NoFallbackControl(List<String> list) {
            super.format = list;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.311 -0500", hash_original_method = "BF31820043735E3E2FECA9848CEFC17E", hash_generated_method = "C6D824F0BF68E51D6DD30832FA203A6B")
        
@Override
        public Locale getFallbackLocale(String baseName, Locale locale) {
            if (baseName == null || locale == null) {
                throw new NullPointerException();
            }
            return null;
        }
    }
    
    private static class SimpleControl extends Control {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.316 -0500", hash_original_method = "3FE57273BBED2EFD79C4104DD304532B", hash_generated_method = "2C01667F5B497F0D003C747A55D9D317")
        
public SimpleControl(String format) {
            listClass = new ArrayList<String>();
            listClass.add(format);
            super.format = Collections.unmodifiableList(listClass);
        }
        
    }
    
    public static class Control {

        /**
         * Returns a control according to {@code formats}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.361 -0500", hash_original_method = "5972AD54AD93BC4C9D08C384DD3F75B5", hash_generated_method = "0B79F83F521417D7198ACF77973C9476")
        
public static Control getControl(List<String> formats) {
            switch (formats.size()) {
            case 1:
                if (formats.contains(JAVACLASS)) {
                    return FORMAT_CLASS_CONTROL;
                }
                if (formats.contains(JAVAPROPERTIES)) {
                    return FORMAT_PROPERTIES_CONTROL;
                }
                break;
            case 2:
                if (formats.equals(FORMAT_DEFAULT)) {
                    return FORMAT_DEFAULT_CONTROL;
                }
                break;
            }
            throw new IllegalArgumentException();
        }

        /**
         * Returns a control according to {@code formats} whose fallback
         * locale is null.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.363 -0500", hash_original_method = "1E4CC670622ED0C431D60B94042EC1B9", hash_generated_method = "59AE264556410497E744D3315E4D63CE")
        
public static Control getNoFallbackControl(List<String> formats) {
            switch (formats.size()) {
            case 1:
                if (formats.contains(JAVACLASS)) {
                    return NoFallbackControl.NOFALLBACK_FORMAT_CLASS_CONTROL;
                }
                if (formats.contains(JAVAPROPERTIES)) {
                    return NoFallbackControl.NOFALLBACK_FORMAT_PROPERTIES_CONTROL;
                }
                break;
            case 2:
                if (formats.equals(FORMAT_DEFAULT)) {
                    return NoFallbackControl.NOFALLBACK_FORMAT_DEFAULT_CONTROL;
                }
                break;
            }
            throw new IllegalArgumentException();
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.321 -0500", hash_original_field = "6C9587B45A478BB4E24172A84C13F8D4", hash_generated_field = "7FAB5EFC8D0A39F92C2066ED7F83F277")

        static List<String> listDefault = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.324 -0500", hash_original_field = "3032ACC4394BB5FF32C7A7F3BDA866E1", hash_generated_field = "73FAB74F5A6B4799EFDB4572A408B125")

        static List<String> listClass = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.326 -0500", hash_original_field = "1AB62562A7AB0A9458EEBB00EF992EE0", hash_generated_field = "2563531F9CF47ED6FC1FDD970ECD4F16")

        static List<String> listProperties = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.328 -0500", hash_original_field = "E002394AB403B260EEBA8CFC5E141E49", hash_generated_field = "F1888E6AB92B35D00E8781C6258E3EE0")

        static String JAVACLASS = "java.class";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.331 -0500", hash_original_field = "C8B6D5A255E3AAA230A80C911A28014E", hash_generated_field = "07BB0B876307E7CB6E2F167DC153078B")

        static String JAVAPROPERTIES = "java.properties";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.334 -0500", hash_original_field = "131B2FD3355EE3999E6D06EA6C3B3BF7", hash_generated_field = "F1424B45B48922D540F30BB96F5544C9")

        public static final List<String> FORMAT_DEFAULT = Collections
                .unmodifiableList(listDefault);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.337 -0500", hash_original_field = "6187EF01F2C7E14976BD62553A7B78A2", hash_generated_field = "238B12F80DDF174B061C6B9B9ADB9205")

        public static final List<String> FORMAT_CLASS = Collections
                .unmodifiableList(listClass);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.340 -0500", hash_original_field = "98DD466E60115EE40C468449686B0CB3", hash_generated_field = "AA1FEB25A6C045A701D589ABAE627BD6")

        public static final List<String> FORMAT_PROPERTIES = Collections
                .unmodifiableList(listProperties);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.342 -0500", hash_original_field = "BA6699F5CF8D203C9F46C50B49079FDE", hash_generated_field = "4947107FB4B8533751EC5231E42008C3")

        public static final long TTL_DONT_CACHE = -1L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.345 -0500", hash_original_field = "065ADDEB4C7C3892411887DB7472CA29", hash_generated_field = "65CF7FF426B0EE2E1D9FD78179803819")

        public static final long TTL_NO_EXPIRATION_CONTROL = -2L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.348 -0500", hash_original_field = "F673F0BB7385FAB82AFC5390E93555BD", hash_generated_field = "E479AC9CE55FC38AA66AEB9C06A435BA")

        private static final Control FORMAT_PROPERTIES_CONTROL = new SimpleControl(
                JAVAPROPERTIES);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.351 -0500", hash_original_field = "11B525BB1B4D9C3C0CDCF5A983069043", hash_generated_field = "72CD7F4B7C3573EE5BEF1523C244BC01")

        private static final Control FORMAT_CLASS_CONTROL = new SimpleControl(
                JAVACLASS);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.353 -0500", hash_original_field = "DD4FFE0EFFF45D0D694A488DF9EF04C2", hash_generated_field = "06188B6C636AFB65149581CD9F1C0A50")

        private static final Control FORMAT_DEFAULT_CONTROL = new Control();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.355 -0500", hash_original_field = "5C4A176E73E3AD8A44C29D1E04A3B849", hash_generated_field = "5C4A176E73E3AD8A44C29D1E04A3B849")

        List<String> format;

        /**
         * default constructor
         *
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.358 -0500", hash_original_method = "95C40A3E350A764DF5A1D8A784434E7C", hash_generated_method = "70EF4DB30B218E83AC4CAB96AD48DE7A")
        
protected Control() {
            listClass = new ArrayList<String>();
            listClass.add(JAVACLASS);
            listClass.add(JAVAPROPERTIES);
            format = Collections.unmodifiableList(listClass);
        }
        static {
            listDefault.add(JAVACLASS);
            listDefault.add(JAVAPROPERTIES);
            listClass.add(JAVACLASS);
            listProperties.add(JAVAPROPERTIES);
        }

        /**
         * Returns a list of candidate locales according to {@code baseName} in
         * {@code locale}.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.367 -0500", hash_original_method = "45631C4F246F185145A9ED45ADEA49D4", hash_generated_method = "CFBC15A47B6FB40331F76E13DAA04B9F")
        
public List<Locale> getCandidateLocales(String baseName, Locale locale) {
            if (baseName == null || locale == null) {
                throw new NullPointerException();
            }
            List<Locale> retList = new ArrayList<Locale>();
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            if (!EMPTY_STRING.equals(variant)) {
                retList.add(new Locale(language, country, variant));
            }
            if (!EMPTY_STRING.equals(country)) {
                retList.add(new Locale(language, country));
            }
            if (!EMPTY_STRING.equals(language)) {
                retList.add(new Locale(language));
            }
            retList.add(Locale.ROOT);
            return retList;
        }

        /**
         * Returns a list of strings of formats according to {@code baseName}.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.369 -0500", hash_original_method = "84F7301A6175FB80884F0D8355AEA589", hash_generated_method = "55872B23568283CF508B5749F092B84E")
        
public List<String> getFormats(String baseName) {
            if (baseName == null) {
                throw new NullPointerException();
            }
            return format;
        }

        /**
         * Returns the fallback locale for {@code baseName} in {@code locale}.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.372 -0500", hash_original_method = "42195BC54E9E8857F62CE9C9CCBB8A2E", hash_generated_method = "F7DC944A1E44D0AC487740F54AB8A87A")
        
public Locale getFallbackLocale(String baseName, Locale locale) {
            if (baseName == null || locale == null) {
                throw new NullPointerException();
            }
            if (Locale.getDefault() != locale) {
                return Locale.getDefault();
            }
            return null;
        }

        /**
         * Returns a new ResourceBundle.
         *
         * @param baseName
         *            the base name to use
         * @param locale
         *            the given locale
         * @param format
         *            the format, default is "java.class" or "java.properties"
         * @param loader
         *            the classloader to use
         * @param reload
         *            whether to reload the resource
         * @return a new ResourceBundle according to the give parameters
         * @throws IllegalAccessException
         *             if we can not access resources
         * @throws InstantiationException
         *             if we can not instantiate a resource class
         * @throws IOException
         *             if other I/O exception happens
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.376 -0500", hash_original_method = "90658AB613E6A89EDB72A67F02A5F78D", hash_generated_method = "8CF928C9C2A2DD01E2948A77E805903B")
        
public ResourceBundle newBundle(String baseName, Locale locale,
                String format, ClassLoader loader, boolean reload)
                throws IllegalAccessException, InstantiationException,
                IOException {
            if (format == null || loader == null) {
                throw new NullPointerException();
            }
            final String bundleName = toBundleName(baseName, locale);
            final ClassLoader clsloader = loader;
            ResourceBundle ret;
            if (format.equals(JAVACLASS)) {
                Class<?> cls = null;
                try {
                    cls = clsloader.loadClass(bundleName);
                } catch (Exception e) {
                } catch (NoClassDefFoundError e) {
                }
                if (cls == null) {
                    return null;
                }
                try {
                    ResourceBundle bundle = (ResourceBundle) cls.newInstance();
                    bundle.setLocale(locale);
                    return bundle;
                } catch (NullPointerException e) {
                    return null;
                }
            }
            if (format.equals(JAVAPROPERTIES)) {
                InputStream streams = null;
                final String resourceName = toResourceName(bundleName, "properties");
                if (reload) {
                    URL url = null;
                    try {
                        url = loader.getResource(resourceName);
                    } catch (NullPointerException e) {
                        // do nothing
                    }
                    if (url != null) {
                        URLConnection con = url.openConnection();
                        con.setUseCaches(false);
                        streams = con.getInputStream();
                    }
                } else {
                    try {
                        streams = clsloader.getResourceAsStream(resourceName);
                    } catch (NullPointerException e) {
                        // do nothing
                    }
                }
                if (streams != null) {
                    try {
                        ret = new PropertyResourceBundle(new InputStreamReader(streams));
                        ret.setLocale(locale);
                        streams.close();
                    } catch (IOException e) {
                        return null;
                    }
                    return ret;
                }
                return null;
            }
            throw new IllegalArgumentException();
        }

        /**
         * Returns the time to live of the ResourceBundle {@code baseName} in {@code locale},
         * default is TTL_NO_EXPIRATION_CONTROL.
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.379 -0500", hash_original_method = "7BA29E8DE065D9912A86853D625E45B1", hash_generated_method = "FF5032CCDA52F0841AD52F4113FC3C20")
        
public long getTimeToLive(String baseName, Locale locale) {
            if (baseName == null || locale == null) {
                throw new NullPointerException();
            }
            return TTL_NO_EXPIRATION_CONTROL;
        }

        /**
         * Returns true if the ResourceBundle needs to reload.
         *
         * @param baseName
         *            the base name of the ResourceBundle
         * @param locale
         *            the locale of the ResourceBundle
         * @param format
         *            the format to load
         * @param loader
         *            the ClassLoader to load resource
         * @param bundle
         *            the ResourceBundle
         * @param loadTime
         *            the expired time
         * @return if the ResourceBundle needs to reload
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.381 -0500", hash_original_method = "C3CC28923ED9707E414F789F1523116A", hash_generated_method = "14AA6E9B97D74E9EB092765D04B1EF6D")
        
public boolean needsReload(String baseName, Locale locale,
                String format, ClassLoader loader, ResourceBundle bundle,
                long loadTime) {
            if (bundle == null) {
                // FIXME what's the use of bundle?
                throw new NullPointerException();
            }
            String bundleName = toBundleName(baseName, locale);
            String suffix = format;
            if (format.equals(JAVACLASS)) {
                suffix = "class";
            }
            if (format.equals(JAVAPROPERTIES)) {
                suffix = "properties";
            }
            String urlname = toResourceName(bundleName, suffix);
            URL url = loader.getResource(urlname);
            if (url != null) {
                String fileName = url.getFile();
                long lastModified = new File(fileName).lastModified();
                if (lastModified > loadTime) {
                    return true;
                }
            }
            return false;
        }

        /**
         * a utility method to answer the name of a resource bundle according to
         * the given base name and locale
         *
         * @param baseName
         *            the given base name
         * @param locale
         *            the locale to use
         * @return the name of a resource bundle according to the given base
         *         name and locale
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.384 -0500", hash_original_method = "95EF33F16C513E472DD742F40E256E32", hash_generated_method = "54DA7940A7F9208FAE571BC295624CB7")
        
public String toBundleName(String baseName, Locale locale) {
            final String emptyString = EMPTY_STRING;
            final String preString = UNDER_SCORE;
            final String underline = UNDER_SCORE;
            if (baseName == null) {
                throw new NullPointerException();
            }
            StringBuilder ret = new StringBuilder();
            StringBuilder prefix = new StringBuilder();
            ret.append(baseName);
            if (!locale.getLanguage().equals(emptyString)) {
                ret.append(underline);
                ret.append(locale.getLanguage());
            } else {
                prefix.append(preString);
            }
            if (!locale.getCountry().equals(emptyString)) {
                ret.append((CharSequence) prefix);
                ret.append(underline);
                ret.append(locale.getCountry());
                prefix = new StringBuilder();
            } else {
                prefix.append(preString);
            }
            if (!locale.getVariant().equals(emptyString)) {
                ret.append((CharSequence) prefix);
                ret.append(underline);
                ret.append(locale.getVariant());
            }
            return ret.toString();
        }

        /**
         * a utility method to answer the name of a resource according to the
         * given bundleName and suffix
         *
         * @param bundleName
         *            the given bundle name
         * @param suffix
         *            the suffix
         * @return the name of a resource according to the given bundleName and
         *         suffix
         */
        @DSComment("From safe class list")
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.387 -0500", hash_original_method = "FCB3528CF98D643CACA491DF306BC818", hash_generated_method = "6A359C787FDCF4731050FA018359D2BE")
        
public final String toResourceName(String bundleName, String suffix) {
            if (suffix == null) {
                throw new NullPointerException();
            }
            StringBuilder ret = new StringBuilder(bundleName.replace('.', '/'));
            ret.append('.');
            ret.append(suffix);
            return ret.toString();
        }
    }

    /**
     * Returns the named resource from this {@code ResourceBundle}, or null if the
     * resource is not found.
     *
     * @param key
     *            the name of the resource.
     * @return the resource object.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.274 -0500", hash_original_method = "399AA0E6CEE543F341E92540A006BAB5", hash_generated_method = "9188AF99ABC351C8A459C72AF10FA8A0")
    
protected abstract Object handleGetObject(String key);

    /**
     * Sets the parent resource bundle of this {@code ResourceBundle}. The parent is
     * searched for resources which are not found in this {@code ResourceBundle}.
     *
     * @param bundle
     *            the parent {@code ResourceBundle}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.277 -0500", hash_original_method = "D114069C12BFDC5397D50DBECBCF423F", hash_generated_method = "D6ECBA4219A874097C3D660CBAED0D70")
    
protected void setParent(ResourceBundle bundle) {
        parent = bundle;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.282 -0500", hash_original_method = "B4C0A2B69538F3C9760ADE4F445366A0", hash_generated_method = "98489A14D99DC816A9485B5B49CF6D4B")
    
private void setLocale(Locale locale) {
        this.locale = locale;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.289 -0500", hash_original_method = "2C99687E9BDD3B9ED091517A1B0B0A5F", hash_generated_method = "BDBBD093A662C1C8D802DF79FE76F3B0")
    
public boolean containsKey(String key) {
        if (key == null) {
            throw new NullPointerException();
        }
        return keySet().contains(key);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.292 -0500", hash_original_method = "D187399FB44FEACCB04758A5D261BC63", hash_generated_method = "522BE43B30B4B5E774F8E09B7A0718BA")
    
public Set<String> keySet() {
        Set<String> ret = new HashSet<String>();
        Enumeration<String> keys = getKeys();
        while (keys.hasMoreElements()) {
            ret.add(keys.nextElement());
        }
        return ret;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:42.295 -0500", hash_original_method = "DE22A4C1E400841A42E2FCE258F58109", hash_generated_method = "84172BFA1B5529140AFB3C07BDF2FBF5")
    
protected Set<String> handleKeySet() {
        Set<String> set = keySet();
        Set<String> ret = new HashSet<String>();
        for (String key : set) {
            if (handleGetObject(key) != null) {
                ret.add(key);
            }
        }
        return ret;
    }
}

