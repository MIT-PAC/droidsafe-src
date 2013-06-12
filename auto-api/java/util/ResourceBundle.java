package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import dalvik.system.VMStack;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charsets;
import static java.nio.charset.Charsets.UTF_8;
import libcore.io.IoUtils;

public abstract class ResourceBundle {
    private static final String UNDER_SCORE = "_";
    private static final String EMPTY_STRING = "";
    protected ResourceBundle parent;
    private Locale locale;
    private long lastLoadTime = 0;
    private static final ResourceBundle MISSING = new MissingBundle();
    private static final ResourceBundle MISSINGBASE = new MissingBundle();
    private static final WeakHashMap<Object, Hashtable<String, ResourceBundle>> cache
            = new WeakHashMap<Object, Hashtable<String, ResourceBundle>>();
    private static Locale cacheLocale = Locale.getDefault();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.869 -0400", hash_original_method = "D851446F8E957DA41A03795AD93701D3", hash_generated_method = "5E58A96D258E41DA5483D17B2984038B")
    @DSModeled(DSC.SAFE)
    public ResourceBundle() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.869 -0400", hash_original_method = "255590496454807E7D85BE3C53A0967E", hash_generated_method = "61CA38109D3BF90DCB66AE6B7CA98079")
    public static ResourceBundle getBundle(String bundleName) throws MissingResourceException {
        ClassLoader classLoader = VMStack.getCallingClassLoader();
        if (classLoader == null) {
            classLoader = getLoader();
        }
        return getBundle(bundleName, Locale.getDefault(), classLoader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "04CC2E12096D8B439249FDE366F3564E", hash_generated_method = "462C3465B2894C59D0D7298104991FD4")
    public static ResourceBundle getBundle(String bundleName, Locale locale) {
        ClassLoader classLoader = VMStack.getCallingClassLoader();
        if (classLoader == null) {
            classLoader = getLoader();
        }
        return getBundle(bundleName, locale, classLoader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "707AE527CA40E5BB5EF1C5E52774D069", hash_generated_method = "24872AF2D206003D769F00C7DF80C5E7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "308F66C97E2B78E8F21601CE4DE89ADA", hash_generated_method = "D657C035271F247F36B4A10FE4716D53")
    private static MissingResourceException missingResourceException(String className, String key) {
        String detail = "Can't find resource for bundle '" + className + "', key '" + key + "'";
        throw new MissingResourceException(detail, className, key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "4F66A59C0DE7297F0E81661806EEDC63", hash_generated_method = "0710F52CB84499C459DDDB6E567DE685")
    public static ResourceBundle getBundle(String baseName, ResourceBundle.Control control) {
        return getBundle(baseName, Locale.getDefault(), getLoader(), control);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "1FCE3FD40C519D29C92F5693C1FE7B55", hash_generated_method = "7B7BD0AB9D2D836A35ACEB0593687B78")
    public static ResourceBundle getBundle(String baseName,
            Locale targetLocale, ResourceBundle.Control control) {
        return getBundle(baseName, targetLocale, getLoader(), control);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "E024E4F0B2833234D75D3234DCC55B50", hash_generated_method = "38A8D07FD615BEC58BD9316D2EE2C64D")
    private static ClassLoader getLoader() {
        ClassLoader cl = ResourceBundle.class.getClassLoader();
        if (cl == null) {
            cl = ClassLoader.getSystemClassLoader();
        }
        return cl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "B5838CF1B848BBFBD1752201D45957B3", hash_generated_method = "1D0DB40E0BCC4E84D48BA990197D7E0A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "FC869FE733F87E635FE0274BF77B1F99", hash_generated_method = "FAD9AD11AA0DB6DB3375C934AF35A237")
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
                        }
                    }
                } catch (IllegalAccessException e) {
                } catch (InstantiationException e) {
                } catch (IOException e) {
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

    
    public abstract Enumeration<String> getKeys();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "A77AA7AA23CD84B62565CD8B60B6FEAC")
    @DSModeled(DSC.SAFE)
    public Locale getLocale() {
        return (Locale)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "5F9FE4637FD5B65A8B96E90EE5158818", hash_generated_method = "1B7EA8C9DE729C108B0308B3D7A03AB2")
    @DSModeled(DSC.SAFE)
    public final Object getObject(String key) {
        dsTaint.addTaint(key);
        ResourceBundle last, theParent;
        theParent = this;
        {
            Object result;
            result = theParent.handleGetObject(key);
            last = theParent;
            theParent = theParent.parent;
        } //End block
        if (DroidSafeAndroidRuntime.control) {
        	throw missingResourceException(last.getClass().getName(), key);
        }
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ResourceBundle last, theParent = this;
        //do {
            //Object result = theParent.handleGetObject(key);
            //if (result != null) {
                //return result;
            //}
            //last = theParent;
            //theParent = theParent.parent;
        //} while (theParent != null);
        //throw missingResourceException(last.getClass().getName(), key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "BF93FB2083E0950C32E8F3481E34A9FB", hash_generated_method = "8EE223E3C7D51C97D3BF115D22C16E73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getString(String key) {
        dsTaint.addTaint(key);
        String var80C56C7095FDCF4B4BD038AB2A987996_1962861237 = ((String) getObject(key));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) getObject(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.870 -0400", hash_original_method = "D1E41ED4E95B94C38D8DBD0F59139218", hash_generated_method = "96FD474F8B07A7A625245676BF40E7B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String[] getStringArray(String key) {
        dsTaint.addTaint(key);
        String[] var4A8D2D4BD6756DDF9C735B52CD80AC89_1277438878 = ((String[]) getObject(key));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return (String[]) getObject(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "96A1B1DE513A6B9EE8F96E68DDC12C8B", hash_generated_method = "BF723F4081BC74D0606911709CC92A48")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "60AB6B9414E33ED624BB99D4F3F658EB", hash_generated_method = "222809D4045433BB4289D5CCC176F457")
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

    
    protected abstract Object handleGetObject(String key);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "D114069C12BFDC5397D50DBECBCF423F", hash_generated_method = "210104F40BB1EF932C68883CF1CEBA17")
    @DSModeled(DSC.SAFE)
    protected void setParent(ResourceBundle bundle) {
        dsTaint.addTaint(bundle.dsTaint);
        // ---------- Original Method ----------
        //parent = bundle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "20EFD4C419C0306BF7F7822E85EB3BC6", hash_generated_method = "0115B6C69F3A1655E310DCD3E2BDB90A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "B4C0A2B69538F3C9760ADE4F445366A0", hash_generated_method = "AE939C837BFADB7A1D4B6B696331B1D8")
    @DSModeled(DSC.SAFE)
    private void setLocale(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        // ---------- Original Method ----------
        //this.locale = locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "BBA9BE607A69468552E43356CE603BED", hash_generated_method = "C86B2D4A8F0B152528B9F83BA1EED06A")
    public static void clearCache() {
        cache.remove(ClassLoader.getSystemClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "DBEB4A28C83470FE64327EA18A307C5B", hash_generated_method = "3A9CD38EFE367C48CE67495BFE910028")
    public static void clearCache(ClassLoader loader) {
        if (loader == null) {
            throw new NullPointerException();
        }
        cache.remove(loader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "2C99687E9BDD3B9ED091517A1B0B0A5F", hash_generated_method = "B5B86F05BB97F936091F3E3DCBAA542B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(String key) {
        dsTaint.addTaint(key);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        boolean varC1F1394BBE1C1666EB466B1C1659D67F_1610830822 = (keySet().contains(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //return keySet().contains(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "D187399FB44FEACCB04758A5D261BC63", hash_generated_method = "9AB1A51AC872C74E1837634B52EEE366")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> keySet() {
        Set<String> ret;
        ret = new HashSet<String>();
        Enumeration<String> keys;
        keys = getKeys();
        {
            boolean var92FA05435258CA7C805716F7AD9C73B4_961502199 = (keys.hasMoreElements());
            {
                ret.add(keys.nextElement());
            } //End block
        } //End collapsed parenthetic
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<String> ret = new HashSet<String>();
        //Enumeration<String> keys = getKeys();
        //while (keys.hasMoreElements()) {
            //ret.add(keys.nextElement());
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "DE22A4C1E400841A42E2FCE258F58109", hash_generated_method = "81F656E1CF952EE54500F6B3A5525642")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Set<String> handleKeySet() {
        Set<String> set;
        set = keySet();
        Set<String> ret;
        ret = new HashSet<String>();
        {
            Iterator<String> seatecAstronomy42 = set.iterator();
            seatecAstronomy42.hasNext();
            String key = seatecAstronomy42.next();
            {
                {
                    boolean var3EACB5F53EB01121F6C3A0A5551029B5_804165549 = (handleGetObject(key) != null);
                    {
                        ret.add(key);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (Set<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Set<String> set = keySet();
        //Set<String> ret = new HashSet<String>();
        //for (String key : set) {
            //if (handleGetObject(key) != null) {
                //ret.add(key);
            //}
        //}
        //return ret;
    }

    
    static class MissingBundle extends ResourceBundle {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "FAC6F24BFEFF063353B4F824D489D5CA", hash_generated_method = "B97130EA0885A30FFF660F8C5D01FEEB")
        @DSModeled(DSC.SAFE)
        @Override
        public Enumeration<String> getKeys() {
            return (Enumeration<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "F3BE912397EA9F5D184546387C802359", hash_generated_method = "7A2BC81D436EF1FE064D94CBDB43A1D5")
        @DSModeled(DSC.SAFE)
        @Override
        public Object handleGetObject(String name) {
            dsTaint.addTaint(name);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
    }


    
    private static class NoFallbackControl extends Control {
        static final Control NOFALLBACK_FORMAT_PROPERTIES_CONTROL = new NoFallbackControl(
                JAVAPROPERTIES);
        static final Control NOFALLBACK_FORMAT_CLASS_CONTROL = new NoFallbackControl(
                JAVACLASS);
        static final Control NOFALLBACK_FORMAT_DEFAULT_CONTROL = new NoFallbackControl(
                listDefault);
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "FB8596E95C5FFB192AB3B86CF874FD9D", hash_generated_method = "968B8F5922688220A026A50ECC1773E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NoFallbackControl(String format) {
            dsTaint.addTaint(format);
            listClass = new ArrayList<String>();
            listClass.add(format);
            super.format = Collections.unmodifiableList(listClass);
            // ---------- Original Method ----------
            //listClass = new ArrayList<String>();
            //listClass.add(format);
            //super.format = Collections.unmodifiableList(listClass);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.871 -0400", hash_original_method = "EC736F9DA869A1318E5C5EA158F0C9E2", hash_generated_method = "7754712698EBC5B76217BDE15FCD94FF")
        @DSModeled(DSC.SAFE)
        public NoFallbackControl(List<String> list) {
            dsTaint.addTaint(list.dsTaint);
            super.format = list;
            // ---------- Original Method ----------
            //super.format = list;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.872 -0400", hash_original_method = "BF31820043735E3E2FECA9848CEFC17E", hash_generated_method = "A1777BACD700048A50922E8719D7DE31")
        @DSModeled(DSC.SAFE)
        @Override
        public Locale getFallbackLocale(String baseName, Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            return (Locale)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //return null;
        }

        
    }


    
    private static class SimpleControl extends Control {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.872 -0400", hash_original_method = "3FE57273BBED2EFD79C4104DD304532B", hash_generated_method = "72DDA87332160E56B4DDDCCBEE3FF39A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SimpleControl(String format) {
            dsTaint.addTaint(format);
            listClass = new ArrayList<String>();
            listClass.add(format);
            super.format = Collections.unmodifiableList(listClass);
            // ---------- Original Method ----------
            //listClass = new ArrayList<String>();
            //listClass.add(format);
            //super.format = Collections.unmodifiableList(listClass);
        }

        
    }


    
    public static class Control {
        static List<String> listDefault = new ArrayList<String>();
        static List<String> listClass = new ArrayList<String>();
        static List<String> listProperties = new ArrayList<String>();
        static String JAVACLASS = "java.class";
        static String JAVAPROPERTIES = "java.properties";
        public static final List<String> FORMAT_DEFAULT = Collections
                .unmodifiableList(listDefault);
        public static final List<String> FORMAT_CLASS = Collections
                .unmodifiableList(listClass);
        public static final List<String> FORMAT_PROPERTIES = Collections
                .unmodifiableList(listProperties);
        public static final long TTL_DONT_CACHE = -1L;
        public static final long TTL_NO_EXPIRATION_CONTROL = -2L;
        private static final Control FORMAT_PROPERTIES_CONTROL = new SimpleControl(
                JAVAPROPERTIES);
        private static final Control FORMAT_CLASS_CONTROL = new SimpleControl(
                JAVACLASS);
        private static final Control FORMAT_DEFAULT_CONTROL = new Control();
        List<String> format;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.872 -0400", hash_original_method = "95C40A3E350A764DF5A1D8A784434E7C", hash_generated_method = "81CCD94B605BAAB1385912FF81B4E818")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Control() {
            listClass = new ArrayList<String>();
            listClass.add(JAVACLASS);
            listClass.add(JAVAPROPERTIES);
            format = Collections.unmodifiableList(listClass);
            // ---------- Original Method ----------
            //listClass = new ArrayList<String>();
            //listClass.add(JAVACLASS);
            //listClass.add(JAVAPROPERTIES);
            //format = Collections.unmodifiableList(listClass);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.872 -0400", hash_original_method = "5972AD54AD93BC4C9D08C384DD3F75B5", hash_generated_method = "0B79F83F521417D7198ACF77973C9476")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.872 -0400", hash_original_method = "1E4CC670622ED0C431D60B94042EC1B9", hash_generated_method = "59AE264556410497E744D3315E4D63CE")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.872 -0400", hash_original_method = "45631C4F246F185145A9ED45ADEA49D4", hash_generated_method = "46EFA84B85B91A0869EB35546CAB86A1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<Locale> getCandidateLocales(String baseName, Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            List<Locale> retList;
            retList = new ArrayList<Locale>();
            String language;
            language = locale.getLanguage();
            String country;
            country = locale.getCountry();
            String variant;
            variant = locale.getVariant();
            {
                boolean varEC1127D11A1A0019D583D076F527D9CF_149144070 = (!EMPTY_STRING.equals(variant));
                {
                    retList.add(new Locale(language, country, variant));
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDEA1B14FA01AF7B442A3DD6CA499F74C_1821175009 = (!EMPTY_STRING.equals(country));
                {
                    retList.add(new Locale(language, country));
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDCEF02BC51EEAFB5ACD7D89F7C557080_1942825203 = (!EMPTY_STRING.equals(language));
                {
                    retList.add(new Locale(language));
                } //End block
            } //End collapsed parenthetic
            retList.add(Locale.ROOT);
            return (List<Locale>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //List<Locale> retList = new ArrayList<Locale>();
            //String language = locale.getLanguage();
            //String country = locale.getCountry();
            //String variant = locale.getVariant();
            //if (!EMPTY_STRING.equals(variant)) {
                //retList.add(new Locale(language, country, variant));
            //}
            //if (!EMPTY_STRING.equals(country)) {
                //retList.add(new Locale(language, country));
            //}
            //if (!EMPTY_STRING.equals(language)) {
                //retList.add(new Locale(language));
            //}
            //retList.add(Locale.ROOT);
            //return retList;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.872 -0400", hash_original_method = "84F7301A6175FB80884F0D8355AEA589", hash_generated_method = "0BC294DE89EA1D6E2F98468DE5DEC900")
        @DSModeled(DSC.SAFE)
        public List<String> getFormats(String baseName) {
            dsTaint.addTaint(baseName);
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (baseName == null) {
                //throw new NullPointerException();
            //}
            //return format;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.872 -0400", hash_original_method = "42195BC54E9E8857F62CE9C9CCBB8A2E", hash_generated_method = "FAEBDB15217BEE2D43744BD924BE82DE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Locale getFallbackLocale(String baseName, Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            {
                boolean varDEF5D6FEDD750F75376A958DD95E60D5_2140501881 = (Locale.getDefault() != locale);
                {
                    Locale varF283041E1F272BDED31107273736DCC8_198798468 = (Locale.getDefault());
                } //End block
            } //End collapsed parenthetic
            return (Locale)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //if (Locale.getDefault() != locale) {
                //return Locale.getDefault();
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.873 -0400", hash_original_method = "90658AB613E6A89EDB72A67F02A5F78D", hash_generated_method = "F2709F2E2458573C6042157CC0D0AE91")
        @DSModeled(DSC.BAN)
        public ResourceBundle newBundle(String baseName, Locale locale,
                String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException,
                IOException {
            dsTaint.addTaint(loader.dsTaint);
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            dsTaint.addTaint(format);
            dsTaint.addTaint(reload);
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            final String bundleName;
            bundleName = toBundleName(baseName, locale);
            final ClassLoader clsloader;
            clsloader = loader;
            ResourceBundle ret;
            {
                boolean var363A8B2CC1CE315300A409E41427D499_1183790699 = (format.equals(JAVACLASS));
                {
                    Class<?> cls;
                    cls = null;
                    try 
                    {
                        cls = clsloader.loadClass(bundleName);
                    } //End block
                    catch (Exception e)
                    { }
                    catch (NoClassDefFoundError e)
                    { }
                    try 
                    {
                        ResourceBundle bundle;
                        bundle = (ResourceBundle) cls.newInstance();
                        bundle.setLocale(locale);
                    } //End block
                    catch (NullPointerException e)
                    { }
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD6A8253E2C839BC6EC4A2010754A1DCD_487473742 = (format.equals(JAVAPROPERTIES));
                {
                    InputStream streams;
                    streams = null;
                    final String resourceName;
                    resourceName = toResourceName(bundleName, "properties");
                    {
                        URL url;
                        url = null;
                        try 
                        {
                            url = loader.getResource(resourceName);
                        } //End block
                        catch (NullPointerException e)
                        { }
                        {
                            URLConnection con;
                            con = url.openConnection();
                            con.setUseCaches(false);
                            streams = con.getInputStream();
                        } //End block
                    } //End block
                    {
                        try 
                        {
                            streams = clsloader.getResourceAsStream(resourceName);
                        } //End block
                        catch (NullPointerException e)
                        { }
                    } //End block
                    {
                        try 
                        {
                            ret = new PropertyResourceBundle(new InputStreamReader(streams));
                            ret.setLocale(locale);
                            streams.close();
                        } //End block
                        catch (IOException e)
                        { }
                    } //End block
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) {
            	throw new IllegalArgumentException();
            }
            return (ResourceBundle)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.873 -0400", hash_original_method = "7BA29E8DE065D9912A86853D625E45B1", hash_generated_method = "6B5436625C55D5E5FF9B383887BA2F84")
        @DSModeled(DSC.SAFE)
        public long getTimeToLive(String baseName, Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //return TTL_NO_EXPIRATION_CONTROL;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.873 -0400", hash_original_method = "C3CC28923ED9707E414F789F1523116A", hash_generated_method = "196AC513B2F9D3942E376440FD7E6F26")
        @DSModeled(DSC.BAN)
        public boolean needsReload(String baseName, Locale locale,
                String format, ClassLoader loader, ResourceBundle bundle,
                long loadTime) {
            dsTaint.addTaint(loader.dsTaint);
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(loadTime);
            dsTaint.addTaint(baseName);
            dsTaint.addTaint(bundle.dsTaint);
            dsTaint.addTaint(format);
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            String bundleName;
            bundleName = toBundleName(baseName, locale);
            String suffix;
            suffix = format;
            {
                boolean var363A8B2CC1CE315300A409E41427D499_1112962643 = (format.equals(JAVACLASS));
                {
                    suffix = "class";
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD6A8253E2C839BC6EC4A2010754A1DCD_207351617 = (format.equals(JAVAPROPERTIES));
                {
                    suffix = "properties";
                } //End block
            } //End collapsed parenthetic
            String urlname;
            urlname = toResourceName(bundleName, suffix);
            URL url;
            url = loader.getResource(urlname);
            {
                String fileName;
                fileName = url.getFile();
                long lastModified;
                lastModified = new File(fileName).lastModified();
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (bundle == null) {
                //throw new NullPointerException();
            //}
            //String bundleName = toBundleName(baseName, locale);
            //String suffix = format;
            //if (format.equals(JAVACLASS)) {
                //suffix = "class";
            //}
            //if (format.equals(JAVAPROPERTIES)) {
                //suffix = "properties";
            //}
            //String urlname = toResourceName(bundleName, suffix);
            //URL url = loader.getResource(urlname);
            //if (url != null) {
                //String fileName = url.getFile();
                //long lastModified = new File(fileName).lastModified();
                //if (lastModified > loadTime) {
                    //return true;
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.873 -0400", hash_original_method = "95EF33F16C513E472DD742F40E256E32", hash_generated_method = "82152E8674896E34C5539E20762B2E4A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toBundleName(String baseName, Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            final String emptyString;
            emptyString = EMPTY_STRING;
            final String preString;
            preString = UNDER_SCORE;
            final String underline;
            underline = UNDER_SCORE;
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            StringBuilder ret;
            ret = new StringBuilder();
            StringBuilder prefix;
            prefix = new StringBuilder();
            ret.append(baseName);
            {
                boolean var8116C9E993A89CC711D61AA067C5543D_966270942 = (!locale.getLanguage().equals(emptyString));
                {
                    ret.append(underline);
                    ret.append(locale.getLanguage());
                } //End block
                {
                    prefix.append(preString);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var019626354072A0B1F8CE16171922D987_2065227070 = (!locale.getCountry().equals(emptyString));
                {
                    ret.append((CharSequence) prefix);
                    ret.append(underline);
                    ret.append(locale.getCountry());
                    prefix = new StringBuilder();
                } //End block
                {
                    prefix.append(preString);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var38517FCA653A00384EA828777964B7DD_1414301422 = (!locale.getVariant().equals(emptyString));
                {
                    ret.append((CharSequence) prefix);
                    ret.append(underline);
                    ret.append(locale.getVariant());
                } //End block
            } //End collapsed parenthetic
            String var011CF590659E2E6753714DEBA269DA32_2082056647 = (ret.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.873 -0400", hash_original_method = "FCB3528CF98D643CACA491DF306BC818", hash_generated_method = "5A29B0ECAF1CB589B147E45071295316")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final String toResourceName(String bundleName, String suffix) {
            dsTaint.addTaint(bundleName);
            dsTaint.addTaint(suffix);
            if (DroidSafeAndroidRuntime.control) {
                throw new NullPointerException();
            } //End block
            StringBuilder ret;
            ret = new StringBuilder(bundleName.replace('.', '/'));
            ret.append('.');
            ret.append(suffix);
            String var011CF590659E2E6753714DEBA269DA32_477626117 = (ret.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //if (suffix == null) {
                //throw new NullPointerException();
            //}
            //StringBuilder ret = new StringBuilder(bundleName.replace('.', '/'));
            //ret.append('.');
            //ret.append(suffix);
            //return ret.toString();
        }

        
        static {
            listDefault.add(JAVACLASS);
            listDefault.add(JAVAPROPERTIES);
            listClass.add(JAVACLASS);
            listProperties.add(JAVAPROPERTIES);
        }
        
    }


    
}


