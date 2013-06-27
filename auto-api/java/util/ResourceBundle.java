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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.236 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "EB43973F1559584562CFC00E839EB2BD")

    protected ResourceBundle parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.236 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.236 -0400", hash_original_field = "3466618A402CD9627C00D29C4F1E86DD", hash_generated_field = "7B08633B611AECF1A2DAD9D2043C79EB")

    private long lastLoadTime = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.237 -0400", hash_original_method = "D851446F8E957DA41A03795AD93701D3", hash_generated_method = "5DB393969C6D50D5978689CA2C066976")
    public  ResourceBundle() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.258 -0400", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "7E82FDD9F6A0F207B622B7106B08A87B")
    public Locale getLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_597024176 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_597024176 = locale;
        varB4EAC82CA7396A68D541C85D26508E83_597024176.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_597024176;
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.260 -0400", hash_original_method = "5F9FE4637FD5B65A8B96E90EE5158818", hash_generated_method = "6DEF310607B7C0780D3A380D0A9FB4FA")
    public final Object getObject(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1351825404 = null; //Variable for return #1
        ResourceBundle last, theParent;
        theParent = this;
        {
            Object result;
            result = theParent.handleGetObject(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1351825404 = result;
            } //End block
            last = theParent;
            theParent = theParent.parent;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw missingResourceException(last.getClass().getName(), key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1351825404.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1351825404;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.260 -0400", hash_original_method = "BF93FB2083E0950C32E8F3481E34A9FB", hash_generated_method = "3A13A560FF6B93D6477085D36766D2B7")
    public final String getString(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_158283405 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_158283405 = (String) getObject(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_158283405.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_158283405;
        // ---------- Original Method ----------
        //return (String) getObject(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.261 -0400", hash_original_method = "D1E41ED4E95B94C38D8DBD0F59139218", hash_generated_method = "81411428F374F8D5986A3F348AADCB0A")
    public final String[] getStringArray(String key) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1194698342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1194698342 = (String[]) getObject(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1194698342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1194698342;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.272 -0400", hash_original_method = "D114069C12BFDC5397D50DBECBCF423F", hash_generated_method = "A62ECC3BD9BC4EEE3A10E4238EC03CC2")
    protected void setParent(ResourceBundle bundle) {
        parent = bundle;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.273 -0400", hash_original_method = "B4C0A2B69538F3C9760ADE4F445366A0", hash_generated_method = "B437BB1B169BA6A1FAF1F1173446D3B3")
    private void setLocale(Locale locale) {
        this.locale = locale;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.279 -0400", hash_original_method = "2C99687E9BDD3B9ED091517A1B0B0A5F", hash_generated_method = "A26003AC90AA810C896A3BA01B6711FC")
    public boolean containsKey(String key) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        boolean varC1F1394BBE1C1666EB466B1C1659D67F_798046344 = (keySet().contains(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1278800203 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1278800203;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //return keySet().contains(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.279 -0400", hash_original_method = "D187399FB44FEACCB04758A5D261BC63", hash_generated_method = "FBD9A301C455ECF0D659E1035E73FFC0")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_187322719 = null; //Variable for return #1
        Set<String> ret;
        ret = new HashSet<String>();
        Enumeration<String> keys;
        keys = getKeys();
        {
            boolean var92FA05435258CA7C805716F7AD9C73B4_1298736213 = (keys.hasMoreElements());
            {
                ret.add(keys.nextElement());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_187322719 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_187322719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_187322719;
        // ---------- Original Method ----------
        //Set<String> ret = new HashSet<String>();
        //Enumeration<String> keys = getKeys();
        //while (keys.hasMoreElements()) {
            //ret.add(keys.nextElement());
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.294 -0400", hash_original_method = "DE22A4C1E400841A42E2FCE258F58109", hash_generated_method = "CFCECFAAF8A8D55E18FD3511C73111D2")
    protected Set<String> handleKeySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1033554232 = null; //Variable for return #1
        Set<String> set;
        set = keySet();
        Set<String> ret;
        ret = new HashSet<String>();
        {
            Iterator<String> var2F95B2C08B227486FC481950E8FAAAD3_326029684 = (set).iterator();
            var2F95B2C08B227486FC481950E8FAAAD3_326029684.hasNext();
            String key = var2F95B2C08B227486FC481950E8FAAAD3_326029684.next();
            {
                {
                    boolean var3EACB5F53EB01121F6C3A0A5551029B5_1359291341 = (handleGetObject(key) != null);
                    {
                        ret.add(key);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1033554232 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_1033554232.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1033554232;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.294 -0400", hash_original_method = "5BE09748C47EC015C065AB0FE98F6425", hash_generated_method = "5BE09748C47EC015C065AB0FE98F6425")
        public MissingBundle ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.295 -0400", hash_original_method = "FAC6F24BFEFF063353B4F824D489D5CA", hash_generated_method = "3B22158E73B09EF02E4CDAC5AFC08D0C")
        @Override
        public Enumeration<String> getKeys() {
            Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_719540852 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_719540852 = null;
            varB4EAC82CA7396A68D541C85D26508E83_719540852.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_719540852;
            // ---------- Original Method ----------
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.296 -0400", hash_original_method = "F3BE912397EA9F5D184546387C802359", hash_generated_method = "808DE3C6B06479C622F81E931BF3F8AE")
        @Override
        public Object handleGetObject(String name) {
            Object varB4EAC82CA7396A68D541C85D26508E83_203068417 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_203068417 = null;
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_203068417.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_203068417;
            // ---------- Original Method ----------
            //return null;
        }

        
    }


    
    private static class NoFallbackControl extends Control {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.297 -0400", hash_original_method = "FB8596E95C5FFB192AB3B86CF874FD9D", hash_generated_method = "074066B24BB275764F86BA5FCA19CC07")
        public  NoFallbackControl(String format) {
            listClass = new ArrayList<String>();
            listClass.add(format);
            super.format = Collections.unmodifiableList(listClass);
            addTaint(format.getTaint());
            // ---------- Original Method ----------
            //listClass = new ArrayList<String>();
            //listClass.add(format);
            //super.format = Collections.unmodifiableList(listClass);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.297 -0400", hash_original_method = "EC736F9DA869A1318E5C5EA158F0C9E2", hash_generated_method = "C55FA7F6A2A409F7FCFB5FA7019632EF")
        public  NoFallbackControl(List<String> list) {
            super.format = list;
            addTaint(list.getTaint());
            // ---------- Original Method ----------
            //super.format = list;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.305 -0400", hash_original_method = "BF31820043735E3E2FECA9848CEFC17E", hash_generated_method = "B1D713F3BB9C43AE3EF29E8697A289AC")
        @Override
        public Locale getFallbackLocale(String baseName, Locale locale) {
            Locale varB4EAC82CA7396A68D541C85D26508E83_1077669226 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1077669226 = null;
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1077669226.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1077669226;
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //return null;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.306 -0400", hash_original_field = "F0BE005252D735BA1B008ACFEBCCB6DC", hash_generated_field = "F01E29DC2AF1F2C962B272838404D5DD")

        static Control NOFALLBACK_FORMAT_PROPERTIES_CONTROL = new NoFallbackControl(
                JAVAPROPERTIES);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.306 -0400", hash_original_field = "51B0D5060DC59A690DB1ABEC684DE2DD", hash_generated_field = "AC57768C749CB98DBCAB09ED35E93945")

        static Control NOFALLBACK_FORMAT_CLASS_CONTROL = new NoFallbackControl(
                JAVACLASS);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.306 -0400", hash_original_field = "12D373EA3CFB9B59F7610021F329A559", hash_generated_field = "1C547BB91F8AC6E9504A1A68218BF81E")

        static Control NOFALLBACK_FORMAT_DEFAULT_CONTROL = new NoFallbackControl(
                listDefault);
    }


    
    private static class SimpleControl extends Control {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.307 -0400", hash_original_method = "3FE57273BBED2EFD79C4104DD304532B", hash_generated_method = "B04E0DA4BDA79C8653C74D4007EA1B71")
        public  SimpleControl(String format) {
            listClass = new ArrayList<String>();
            listClass.add(format);
            super.format = Collections.unmodifiableList(listClass);
            addTaint(format.getTaint());
            // ---------- Original Method ----------
            //listClass = new ArrayList<String>();
            //listClass.add(format);
            //super.format = Collections.unmodifiableList(listClass);
        }

        
    }


    
    public static class Control {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.307 -0400", hash_original_field = "1DDCB92ADE31C8FBD370001F9B29A7D9", hash_generated_field = "5C4A176E73E3AD8A44C29D1E04A3B849")

        List<String> format;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.308 -0400", hash_original_method = "95C40A3E350A764DF5A1D8A784434E7C", hash_generated_method = "949CF8FAA99C36B6D02001CFF1C3EFE2")
        protected  Control() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.314 -0400", hash_original_method = "45631C4F246F185145A9ED45ADEA49D4", hash_generated_method = "FF86B564AE42C1B27028548953C8237B")
        public List<Locale> getCandidateLocales(String baseName, Locale locale) {
            List<Locale> varB4EAC82CA7396A68D541C85D26508E83_1195660009 = null; //Variable for return #1
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
                boolean varEC1127D11A1A0019D583D076F527D9CF_1922871201 = (!EMPTY_STRING.equals(variant));
                {
                    retList.add(new Locale(language, country, variant));
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDEA1B14FA01AF7B442A3DD6CA499F74C_1275528019 = (!EMPTY_STRING.equals(country));
                {
                    retList.add(new Locale(language, country));
                } //End block
            } //End collapsed parenthetic
            {
                boolean varDCEF02BC51EEAFB5ACD7D89F7C557080_1893860161 = (!EMPTY_STRING.equals(language));
                {
                    retList.add(new Locale(language));
                } //End block
            } //End collapsed parenthetic
            retList.add(Locale.ROOT);
            varB4EAC82CA7396A68D541C85D26508E83_1195660009 = retList;
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1195660009.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1195660009;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.319 -0400", hash_original_method = "84F7301A6175FB80884F0D8355AEA589", hash_generated_method = "11E75E11757194252DCE9BEA688968EB")
        public List<String> getFormats(String baseName) {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_101222202 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_101222202 = format;
            addTaint(baseName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_101222202.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_101222202;
            // ---------- Original Method ----------
            //if (baseName == null) {
                //throw new NullPointerException();
            //}
            //return format;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.320 -0400", hash_original_method = "42195BC54E9E8857F62CE9C9CCBB8A2E", hash_generated_method = "978F2BD420D025AA4B8E942AFF193818")
        public Locale getFallbackLocale(String baseName, Locale locale) {
            Locale varB4EAC82CA7396A68D541C85D26508E83_1216196262 = null; //Variable for return #1
            Locale varB4EAC82CA7396A68D541C85D26508E83_864827898 = null; //Variable for return #2
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            {
                boolean varDEF5D6FEDD750F75376A958DD95E60D5_1283074172 = (Locale.getDefault() != locale);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1216196262 = Locale.getDefault();
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_864827898 = null;
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            Locale varA7E53CE21691AB073D9660D615818899_1680219582; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1680219582 = varB4EAC82CA7396A68D541C85D26508E83_1216196262;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1680219582 = varB4EAC82CA7396A68D541C85D26508E83_864827898;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1680219582.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1680219582;
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //if (Locale.getDefault() != locale) {
                //return Locale.getDefault();
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.331 -0400", hash_original_method = "90658AB613E6A89EDB72A67F02A5F78D", hash_generated_method = "973A2B382B38ED18B39D5365870D2DD6")
        public ResourceBundle newBundle(String baseName, Locale locale,
                String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException,
                IOException {
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_1191753211 = null; //Variable for return #1
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_111602491 = null; //Variable for return #2
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_380915240 = null; //Variable for return #3
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_1031508758 = null; //Variable for return #4
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_295641503 = null; //Variable for return #5
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_847738595 = null; //Variable for return #6
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            String bundleName;
            bundleName = toBundleName(baseName, locale);
            ClassLoader clsloader;
            clsloader = loader;
            ResourceBundle ret;
            {
                boolean var363A8B2CC1CE315300A409E41427D499_257540619 = (format.equals(JAVACLASS));
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
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1191753211 = null;
                    } //End block
                    try 
                    {
                        ResourceBundle bundle;
                        bundle = (ResourceBundle) cls.newInstance();
                        bundle.setLocale(locale);
                        varB4EAC82CA7396A68D541C85D26508E83_111602491 = bundle;
                    } //End block
                    catch (NullPointerException e)
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_380915240 = null;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD6A8253E2C839BC6EC4A2010754A1DCD_783631947 = (format.equals(JAVAPROPERTIES));
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
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1031508758 = null;
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_295641503 = ret;
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_847738595 = null;
                } //End block
            } //End collapsed parenthetic
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            addTaint(format.getTaint());
            addTaint(loader.getTaint());
            addTaint(reload);
            ResourceBundle varA7E53CE21691AB073D9660D615818899_1243955588; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1243955588 = varB4EAC82CA7396A68D541C85D26508E83_1191753211;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1243955588 = varB4EAC82CA7396A68D541C85D26508E83_111602491;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_1243955588 = varB4EAC82CA7396A68D541C85D26508E83_380915240;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_1243955588 = varB4EAC82CA7396A68D541C85D26508E83_1031508758;
                    break;
                case 5: //Assign result for return ordinal #5
                    varA7E53CE21691AB073D9660D615818899_1243955588 = varB4EAC82CA7396A68D541C85D26508E83_295641503;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1243955588 = varB4EAC82CA7396A68D541C85D26508E83_847738595;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1243955588.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1243955588;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.332 -0400", hash_original_method = "7BA29E8DE065D9912A86853D625E45B1", hash_generated_method = "2F258EE60B014F12B28CAFFEAF3B188A")
        public long getTimeToLive(String baseName, Locale locale) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1127855712 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1127855712;
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //return TTL_NO_EXPIRATION_CONTROL;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.333 -0400", hash_original_method = "C3CC28923ED9707E414F789F1523116A", hash_generated_method = "7E100D210A449F64059430EE7B17CC8B")
        public boolean needsReload(String baseName, Locale locale,
                String format, ClassLoader loader, ResourceBundle bundle,
                long loadTime) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            String bundleName;
            bundleName = toBundleName(baseName, locale);
            String suffix;
            suffix = format;
            {
                boolean var363A8B2CC1CE315300A409E41427D499_177487217 = (format.equals(JAVACLASS));
                {
                    suffix = "class";
                } //End block
            } //End collapsed parenthetic
            {
                boolean varD6A8253E2C839BC6EC4A2010754A1DCD_246266044 = (format.equals(JAVAPROPERTIES));
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
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            addTaint(format.getTaint());
            addTaint(loader.getTaint());
            addTaint(bundle.getTaint());
            addTaint(loadTime);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646942675 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_646942675;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.338 -0400", hash_original_method = "95EF33F16C513E472DD742F40E256E32", hash_generated_method = "F927C61D2C4FA46946657C2EABB92FFC")
        public String toBundleName(String baseName, Locale locale) {
            String varB4EAC82CA7396A68D541C85D26508E83_442239797 = null; //Variable for return #1
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
                boolean var8116C9E993A89CC711D61AA067C5543D_1980302391 = (!locale.getLanguage().equals(emptyString));
                {
                    ret.append(underline);
                    ret.append(locale.getLanguage());
                } //End block
                {
                    prefix.append(preString);
                } //End block
            } //End collapsed parenthetic
            {
                boolean var019626354072A0B1F8CE16171922D987_1282424721 = (!locale.getCountry().equals(emptyString));
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
                boolean var38517FCA653A00384EA828777964B7DD_63804744 = (!locale.getVariant().equals(emptyString));
                {
                    ret.append((CharSequence) prefix);
                    ret.append(underline);
                    ret.append(locale.getVariant());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_442239797 = ret.toString();
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_442239797.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_442239797;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.343 -0400", hash_original_method = "FCB3528CF98D643CACA491DF306BC818", hash_generated_method = "B2A5C4ED76C76EB940D84BAB06209F5B")
        public final String toResourceName(String bundleName, String suffix) {
            String varB4EAC82CA7396A68D541C85D26508E83_2145028687 = null; //Variable for return #1
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } //End block
            StringBuilder ret;
            ret = new StringBuilder(bundleName.replace('.', '/'));
            ret.append('.');
            ret.append(suffix);
            varB4EAC82CA7396A68D541C85D26508E83_2145028687 = ret.toString();
            addTaint(bundleName.getTaint());
            addTaint(suffix.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2145028687.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_2145028687;
            // ---------- Original Method ----------
            //if (suffix == null) {
                //throw new NullPointerException();
            //}
            //StringBuilder ret = new StringBuilder(bundleName.replace('.', '/'));
            //ret.append('.');
            //ret.append(suffix);
            //return ret.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.343 -0400", hash_original_field = "F883DF0BE51C6E6DE4D20E70AB2328E4", hash_generated_field = "7FAB5EFC8D0A39F92C2066ED7F83F277")

        static List<String> listDefault = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.343 -0400", hash_original_field = "E23066AFBA5FD9CE9DF4C3FA202E457B", hash_generated_field = "73FAB74F5A6B4799EFDB4572A408B125")

        static List<String> listClass = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.343 -0400", hash_original_field = "AFE0A77B730E680380CFE6EA55C51DFD", hash_generated_field = "2563531F9CF47ED6FC1FDD970ECD4F16")

        static List<String> listProperties = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.343 -0400", hash_original_field = "9958D37192A39A85F8CC51B79E70B8C2", hash_generated_field = "F1888E6AB92B35D00E8781C6258E3EE0")

        static String JAVACLASS = "java.class";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.343 -0400", hash_original_field = "1C2FF60CB53FAA0B881ADB89C22D3B95", hash_generated_field = "07BB0B876307E7CB6E2F167DC153078B")

        static String JAVAPROPERTIES = "java.properties";
        static {
            listDefault.add(JAVACLASS);
            listDefault.add(JAVAPROPERTIES);
            listClass.add(JAVACLASS);
            listProperties.add(JAVAPROPERTIES);
        }
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.343 -0400", hash_original_field = "1F661A88B9A779DBAC839396964A04D3", hash_generated_field = "F1424B45B48922D540F30BB96F5544C9")

        public static final List<String> FORMAT_DEFAULT = Collections
                .unmodifiableList(listDefault);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "4C0F5D8334D6DA9DD047A3E56F9935D9", hash_generated_field = "238B12F80DDF174B061C6B9B9ADB9205")

        public static final List<String> FORMAT_CLASS = Collections
                .unmodifiableList(listClass);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "90A269AD00605FE1555547E25BD2EC09", hash_generated_field = "AA1FEB25A6C045A701D589ABAE627BD6")

        public static final List<String> FORMAT_PROPERTIES = Collections
                .unmodifiableList(listProperties);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "4480A4BC9B756BD79CE2693AEB964C0F", hash_generated_field = "4947107FB4B8533751EC5231E42008C3")

        public static final long TTL_DONT_CACHE = -1L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "EC499B03368757C4B60EAD81CB227B4D", hash_generated_field = "65CF7FF426B0EE2E1D9FD78179803819")

        public static final long TTL_NO_EXPIRATION_CONTROL = -2L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "C4393F6F971CE5F5B9724C11749155A4", hash_generated_field = "1343B1D0074801B0A8C09619B1FC5FB4")

        private static Control FORMAT_PROPERTIES_CONTROL = new SimpleControl(
                JAVAPROPERTIES);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "2F9B352D101093DE430A17439BD1673B", hash_generated_field = "6E6856BDC5CF82EB80BEEF956CCA7465")

        private static Control FORMAT_CLASS_CONTROL = new SimpleControl(
                JAVACLASS);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "108817DB34C2523A65A647CB1C10AFB1", hash_generated_field = "04D603A0DFE82E4788849AB35811BE9C")

        private static Control FORMAT_DEFAULT_CONTROL = new Control();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "6CE7142F7AF3BCCD7A3950C3FEDFA77E", hash_generated_field = "6BE8CEB44FB29B06C10C0FD0A1F00016")

    private static String UNDER_SCORE = "_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "898133B79D24539B71595F1C8C6BBF6C", hash_generated_field = "89E30ABADC5DB1339122C473BA7A3B1C")

    private static String EMPTY_STRING = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "A749795A23092ECB9BB3757F664C6407", hash_generated_field = "4DF1AB31E1DA08E2FDBD716CF4CF813C")

    private static ResourceBundle MISSING = new MissingBundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "C13F6920F8D183CB8736ED99060F9BA6", hash_generated_field = "C23E82D19DB80C05E088244349A011E6")

    private static ResourceBundle MISSINGBASE = new MissingBundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "CF1F6725974173FA855D6DA9746F184D", hash_generated_field = "CF926CC1090606B22F43A6129299B141")

    private static WeakHashMap<Object, Hashtable<String, ResourceBundle>> cache = new WeakHashMap<Object, Hashtable<String, ResourceBundle>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:53.344 -0400", hash_original_field = "BD37D96B8058F3E7A7D028244344ED3D", hash_generated_field = "FB53443D57FD33E6486E78E1759D3531")

    private static Locale cacheLocale = Locale.getDefault();
}

