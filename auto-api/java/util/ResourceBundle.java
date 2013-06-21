package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    protected ResourceBundle parent;
    private Locale locale;
    private long lastLoadTime = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.200 -0400", hash_original_method = "D851446F8E957DA41A03795AD93701D3", hash_generated_method = "5DB393969C6D50D5978689CA2C066976")
    @DSModeled(DSC.SAFE)
    public ResourceBundle() {
        // ---------- Original Method ----------
    }

    
        public static ResourceBundle getBundle(String bundleName) throws MissingResourceException {
        ClassLoader classLoader = VMStack.getCallingClassLoader();
        if (classLoader == null) {
            classLoader = getLoader();
        }
        return getBundle(bundleName, Locale.getDefault(), classLoader);
    }

    
        public static ResourceBundle getBundle(String bundleName, Locale locale) {
        ClassLoader classLoader = VMStack.getCallingClassLoader();
        if (classLoader == null) {
            classLoader = getLoader();
        }
        return getBundle(bundleName, locale, classLoader);
    }

    
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

    
        private static MissingResourceException missingResourceException(String className, String key) {
        String detail = "Can't find resource for bundle '" + className + "', key '" + key + "'";
        throw new MissingResourceException(detail, className, key);
    }

    
        public static ResourceBundle getBundle(String baseName, ResourceBundle.Control control) {
        return getBundle(baseName, Locale.getDefault(), getLoader(), control);
    }

    
        public static ResourceBundle getBundle(String baseName,
            Locale targetLocale, ResourceBundle.Control control) {
        return getBundle(baseName, targetLocale, getLoader(), control);
    }

    
        private static ClassLoader getLoader() {
        ClassLoader cl = ResourceBundle.class.getClassLoader();
        if (cl == null) {
            cl = ClassLoader.getSystemClassLoader();
        }
        return cl;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.202 -0400", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "9C9FBA894BADCE58B57303AC1C2C7371")
    @DSModeled(DSC.SAFE)
    public Locale getLocale() {
        return (Locale)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.203 -0400", hash_original_method = "5F9FE4637FD5B65A8B96E90EE5158818", hash_generated_method = "2643808081BBFC30153F346F7656ED7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        if (DroidSafeAndroidRuntime.control) throw missingResourceException(last.getClass().getName(), key);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.203 -0400", hash_original_method = "BF93FB2083E0950C32E8F3481E34A9FB", hash_generated_method = "F3CF7D4CA42CFEBF1ED2CE1A268DE32C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getString(String key) {
        dsTaint.addTaint(key);
        String var80C56C7095FDCF4B4BD038AB2A987996_234335184 = ((String) getObject(key));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (String) getObject(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.203 -0400", hash_original_method = "D1E41ED4E95B94C38D8DBD0F59139218", hash_generated_method = "2D50F175066C067F947E608A5891662F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String[] getStringArray(String key) {
        dsTaint.addTaint(key);
        String[] var4A8D2D4BD6756DDF9C735B52CD80AC89_313489522 = ((String[]) getObject(key));
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return (String[]) getObject(key);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.204 -0400", hash_original_method = "D114069C12BFDC5397D50DBECBCF423F", hash_generated_method = "6A550E61E3F88FB8D393CB212B417F2F")
    @DSModeled(DSC.SAFE)
    protected void setParent(ResourceBundle bundle) {
        dsTaint.addTaint(bundle.dsTaint);
        // ---------- Original Method ----------
        //parent = bundle;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.204 -0400", hash_original_method = "B4C0A2B69538F3C9760ADE4F445366A0", hash_generated_method = "77B5E4D353726ACCF5ECCBEF975ECB5C")
    @DSModeled(DSC.SAFE)
    private void setLocale(Locale locale) {
        dsTaint.addTaint(locale.dsTaint);
        // ---------- Original Method ----------
        //this.locale = locale;
    }

    
        public static void clearCache() {
        cache.remove(ClassLoader.getSystemClassLoader());
    }

    
        public static void clearCache(ClassLoader loader) {
        if (loader == null) {
            throw new NullPointerException();
        }
        cache.remove(loader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.205 -0400", hash_original_method = "2C99687E9BDD3B9ED091517A1B0B0A5F", hash_generated_method = "B00132C5A6010921D13C47159842EF93")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean containsKey(String key) {
        dsTaint.addTaint(key);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean varC1F1394BBE1C1666EB466B1C1659D67F_1183040515 = (keySet().contains(key));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //return keySet().contains(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.205 -0400", hash_original_method = "D187399FB44FEACCB04758A5D261BC63", hash_generated_method = "7DBCD188176EDEA620A8F4BC068A9AB9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Set<String> keySet() {
        Set<String> ret;
        ret = new HashSet<String>();
        Enumeration<String> keys;
        keys = getKeys();
        {
            boolean var92FA05435258CA7C805716F7AD9C73B4_119483079 = (keys.hasMoreElements());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.207 -0400", hash_original_method = "DE22A4C1E400841A42E2FCE258F58109", hash_generated_method = "B8D916A52608D2C985A3F7B4746BB99C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Set<String> handleKeySet() {
        Set<String> set;
        set = keySet();
        Set<String> ret;
        ret = new HashSet<String>();
        {
            Iterator<String> var2F95B2C08B227486FC481950E8FAAAD3_1220534784 = (set).iterator();
            var2F95B2C08B227486FC481950E8FAAAD3_1220534784.hasNext();
            String key = var2F95B2C08B227486FC481950E8FAAAD3_1220534784.next();
            {
                {
                    boolean var3EACB5F53EB01121F6C3A0A5551029B5_739824335 = (handleGetObject(key) != null);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.207 -0400", hash_original_method = "D0A36056F04D9F396DD49EE6756C663A", hash_generated_method = "D0A36056F04D9F396DD49EE6756C663A")
                public MissingBundle ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.207 -0400", hash_original_method = "FAC6F24BFEFF063353B4F824D489D5CA", hash_generated_method = "C037664AA16BF18E375E49433AD70168")
        @DSModeled(DSC.SAFE)
        @Override
        public Enumeration<String> getKeys() {
            return (Enumeration<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.207 -0400", hash_original_method = "F3BE912397EA9F5D184546387C802359", hash_generated_method = "1CEF872774870ECE363B1302DDEC2F14")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.207 -0400", hash_original_method = "FB8596E95C5FFB192AB3B86CF874FD9D", hash_generated_method = "EB7A9694085DAA5211E53A82A106AE6F")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.208 -0400", hash_original_method = "EC736F9DA869A1318E5C5EA158F0C9E2", hash_generated_method = "1AA7BE670E7AB0960FC7648434AB755F")
        @DSModeled(DSC.SAFE)
        public NoFallbackControl(List<String> list) {
            dsTaint.addTaint(list.dsTaint);
            super.format = list;
            // ---------- Original Method ----------
            //super.format = list;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.208 -0400", hash_original_method = "BF31820043735E3E2FECA9848CEFC17E", hash_generated_method = "C1621AD0F068AF699F4C9D3A9ED09350")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Locale getFallbackLocale(String baseName, Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            return (Locale)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //return null;
        }

        
        static final Control NOFALLBACK_FORMAT_PROPERTIES_CONTROL = new NoFallbackControl(
                JAVAPROPERTIES);
        static final Control NOFALLBACK_FORMAT_CLASS_CONTROL = new NoFallbackControl(
                JAVACLASS);
        static final Control NOFALLBACK_FORMAT_DEFAULT_CONTROL = new NoFallbackControl(
                listDefault);
    }


    
    private static class SimpleControl extends Control {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.208 -0400", hash_original_method = "3FE57273BBED2EFD79C4104DD304532B", hash_generated_method = "DCF95ABCE010A957E53A49EBB477B80E")
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
        List<String> format;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.208 -0400", hash_original_method = "95C40A3E350A764DF5A1D8A784434E7C", hash_generated_method = "949CF8FAA99C36B6D02001CFF1C3EFE2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.209 -0400", hash_original_method = "45631C4F246F185145A9ED45ADEA49D4", hash_generated_method = "5E223F9FB686DE4FEC0D00BE9942C16B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<Locale> getCandidateLocales(String baseName, Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
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
                boolean varEC1127D11A1A0019D583D076F527D9CF_280000977 = (!EMPTY_STRING.equals(variant));
                {
                    retList.add(new Locale(language, country, variant));
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDEA1B14FA01AF7B442A3DD6CA499F74C_1918060609 = (!EMPTY_STRING.equals(country));
                {
                    retList.add(new Locale(language, country));
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDCEF02BC51EEAFB5ACD7D89F7C557080_1546636452 = (!EMPTY_STRING.equals(language));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.210 -0400", hash_original_method = "84F7301A6175FB80884F0D8355AEA589", hash_generated_method = "B311DA2779A67310059A907570992A50")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public List<String> getFormats(String baseName) {
            dsTaint.addTaint(baseName);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            return (List<String>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (baseName == null) {
                //throw new NullPointerException();
            //}
            //return format;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.210 -0400", hash_original_method = "42195BC54E9E8857F62CE9C9CCBB8A2E", hash_generated_method = "1AC93BC5A8F1CC692C4001D580018BC5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Locale getFallbackLocale(String baseName, Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            {
                boolean varDEF5D6FEDD750F75376A958DD95E60D5_777877478 = (Locale.getDefault() != locale);
                {
                    Locale varF283041E1F272BDED31107273736DCC8_105647764 = (Locale.getDefault());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.210 -0400", hash_original_method = "90658AB613E6A89EDB72A67F02A5F78D", hash_generated_method = "313E2967934AFF49EEACD0FF0480A088")
        @DSModeled(DSC.BAN)
        public ResourceBundle newBundle(String baseName, Locale locale,
                String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException,
                IOException {
            dsTaint.addTaint(loader.dsTaint);
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            dsTaint.addTaint(format);
            dsTaint.addTaint(reload);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            String bundleName;
            bundleName = toBundleName(baseName, locale);
            ClassLoader clsloader;
            clsloader = loader;
            ResourceBundle ret;
            {
                boolean var363A8B2CC1CE315300A409E41427D499_895664903 = (format.equals(JAVACLASS));
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
                boolean varD6A8253E2C839BC6EC4A2010754A1DCD_1725556702 = (format.equals(JAVAPROPERTIES));
                {
                    InputStream streams;
                    streams = null;
                    String resourceName;
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
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            return (ResourceBundle)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.212 -0400", hash_original_method = "7BA29E8DE065D9912A86853D625E45B1", hash_generated_method = "378840C14D0B2F86E7DF66EB27C90662")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public long getTimeToLive(String baseName, Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //return TTL_NO_EXPIRATION_CONTROL;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.213 -0400", hash_original_method = "C3CC28923ED9707E414F789F1523116A", hash_generated_method = "25ECA771DE869E86B4B70CE8D1D73D7D")
        @DSModeled(DSC.BAN)
        public boolean needsReload(String baseName, Locale locale,
                String format, ClassLoader loader, ResourceBundle bundle,
                long loadTime) {
            dsTaint.addTaint(loader.dsTaint);
            dsTaint.addTaint(loadTime);
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(bundle.dsTaint);
            dsTaint.addTaint(baseName);
            dsTaint.addTaint(format);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            String bundleName;
            bundleName = toBundleName(baseName, locale);
            String suffix;
            suffix = format;
            {
                boolean var363A8B2CC1CE315300A409E41427D499_864506869 = (format.equals(JAVACLASS));
                {
                    suffix = "class";
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD6A8253E2C839BC6EC4A2010754A1DCD_1154343310 = (format.equals(JAVAPROPERTIES));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.215 -0400", hash_original_method = "95EF33F16C513E472DD742F40E256E32", hash_generated_method = "0F4F40DB158A6E64975BE7DF4DB820AF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toBundleName(String baseName, Locale locale) {
            dsTaint.addTaint(locale.dsTaint);
            dsTaint.addTaint(baseName);
            String emptyString;
            emptyString = EMPTY_STRING;
            String preString;
            preString = UNDER_SCORE;
            String underline;
            underline = UNDER_SCORE;
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            StringBuilder ret;
            ret = new StringBuilder();
            StringBuilder prefix;
            prefix = new StringBuilder();
            ret.append(baseName);
            {
                boolean var8116C9E993A89CC711D61AA067C5543D_1087318737 = (!locale.getLanguage().equals(emptyString));
                {
                    ret.append(underline);
                    ret.append(locale.getLanguage());
                } //End block
                {
                    prefix.append(preString);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var019626354072A0B1F8CE16171922D987_436453276 = (!locale.getCountry().equals(emptyString));
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
                boolean var38517FCA653A00384EA828777964B7DD_1067033196 = (!locale.getVariant().equals(emptyString));
                {
                    ret.append((CharSequence) prefix);
                    ret.append(underline);
                    ret.append(locale.getVariant());
                } //End block
            } //End collapsed parenthetic
            String var011CF590659E2E6753714DEBA269DA32_1034892274 = (ret.toString());
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.216 -0400", hash_original_method = "FCB3528CF98D643CACA491DF306BC818", hash_generated_method = "0B71A17E8D16DC118100F78874BD63F7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final String toResourceName(String bundleName, String suffix) {
            dsTaint.addTaint(bundleName);
            dsTaint.addTaint(suffix);
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            StringBuilder ret;
            ret = new StringBuilder(bundleName.replace('.', '/'));
            ret.append('.');
            ret.append(suffix);
            String var011CF590659E2E6753714DEBA269DA32_1674690347 = (ret.toString());
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

        
        static List<String> listDefault = new ArrayList<String>();
        static List<String> listClass = new ArrayList<String>();
        static List<String> listProperties = new ArrayList<String>();
        static String JAVACLASS = "java.class";
        static String JAVAPROPERTIES = "java.properties";
        static {
            listDefault.add(JAVACLASS);
            listDefault.add(JAVAPROPERTIES);
            listClass.add(JAVACLASS);
            listProperties.add(JAVAPROPERTIES);
        }
        
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
    }


    
    private static final String UNDER_SCORE = "_";
    private static final String EMPTY_STRING = "";
    private static final ResourceBundle MISSING = new MissingBundle();
    private static final ResourceBundle MISSINGBASE = new MissingBundle();
    private static final WeakHashMap<Object, Hashtable<String, ResourceBundle>> cache
            = new WeakHashMap<Object, Hashtable<String, ResourceBundle>>();
    private static Locale cacheLocale = Locale.getDefault();
}

