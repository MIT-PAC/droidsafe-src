package java.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.617 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "EB43973F1559584562CFC00E839EB2BD")

    protected ResourceBundle parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.618 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.618 -0400", hash_original_field = "3466618A402CD9627C00D29C4F1E86DD", hash_generated_field = "7B08633B611AECF1A2DAD9D2043C79EB")

    private long lastLoadTime = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.618 -0400", hash_original_method = "D851446F8E957DA41A03795AD93701D3", hash_generated_method = "5DB393969C6D50D5978689CA2C066976")
    public  ResourceBundle() {
        
    }

    
    @DSModeled(DSC.SAFE)
    public static ResourceBundle getBundle(String bundleName) throws MissingResourceException {
        ClassLoader classLoader = VMStack.getCallingClassLoader();
        if (classLoader == null) {
            classLoader = getLoader();
        }
        return getBundle(bundleName, Locale.getDefault(), classLoader);
    }

    
    @DSModeled(DSC.SAFE)
    public static ResourceBundle getBundle(String bundleName, Locale locale) {
        ClassLoader classLoader = VMStack.getCallingClassLoader();
        if (classLoader == null) {
            classLoader = getLoader();
        }
        return getBundle(bundleName, locale, classLoader);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static MissingResourceException missingResourceException(String className, String key) {
        String detail = "Can't find resource for bundle '" + className + "', key '" + key + "'";
        throw new MissingResourceException(detail, className, key);
    }

    
    @DSModeled(DSC.SAFE)
    public static ResourceBundle getBundle(String baseName, ResourceBundle.Control control) {
        return getBundle(baseName, Locale.getDefault(), getLoader(), control);
    }

    
    @DSModeled(DSC.SAFE)
    public static ResourceBundle getBundle(String baseName,
            Locale targetLocale, ResourceBundle.Control control) {
        return getBundle(baseName, targetLocale, getLoader(), control);
    }

    
    @DSModeled(DSC.SAFE)
    private static ClassLoader getLoader() {
        ClassLoader cl = ResourceBundle.class.getClassLoader();
        if (cl == null) {
            cl = ClassLoader.getSystemClassLoader();
        }
        return cl;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.620 -0400", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "9A4632412C1B56665F0D4048B962E462")
    public Locale getLocale() {
        Locale varB4EAC82CA7396A68D541C85D26508E83_1738556197 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1738556197 = locale;
        varB4EAC82CA7396A68D541C85D26508E83_1738556197.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1738556197;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.621 -0400", hash_original_method = "5F9FE4637FD5B65A8B96E90EE5158818", hash_generated_method = "21A2C307B4544986EE4AA4B0E8113049")
    public final Object getObject(String key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1201033221 = null; 
        ResourceBundle last;
        ResourceBundle theParent = this;
        {
            Object result = theParent.handleGetObject(key);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1201033221 = result;
            } 
            last = theParent;
            theParent = theParent.parent;
        } 
        if (DroidSafeAndroidRuntime.control) throw missingResourceException(last.getClass().getName(), key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1201033221.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1201033221;
        
        
        
            
            
                
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.622 -0400", hash_original_method = "BF93FB2083E0950C32E8F3481E34A9FB", hash_generated_method = "E63E3D7CFFA309B218E04322F0C843A0")
    public final String getString(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_1932733927 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1932733927 = (String) getObject(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1932733927.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1932733927;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.623 -0400", hash_original_method = "D1E41ED4E95B94C38D8DBD0F59139218", hash_generated_method = "CEE32EF5B2B54E30FEF2333EB0427E23")
    public final String[] getStringArray(String key) {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1173201234 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1173201234 = (String[]) getObject(key);
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1173201234.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1173201234;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.624 -0400", hash_original_method = "D114069C12BFDC5397D50DBECBCF423F", hash_generated_method = "A62ECC3BD9BC4EEE3A10E4238EC03CC2")
    protected void setParent(ResourceBundle bundle) {
        parent = bundle;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.625 -0400", hash_original_method = "B4C0A2B69538F3C9760ADE4F445366A0", hash_generated_method = "B437BB1B169BA6A1FAF1F1173446D3B3")
    private void setLocale(Locale locale) {
        this.locale = locale;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static void clearCache() {
        cache.remove(ClassLoader.getSystemClassLoader());
    }

    
    @DSModeled(DSC.SAFE)
    public static void clearCache(ClassLoader loader) {
        if (loader == null) {
            throw new NullPointerException();
        }
        cache.remove(loader);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.625 -0400", hash_original_method = "2C99687E9BDD3B9ED091517A1B0B0A5F", hash_generated_method = "9135B4954C46D0549948368BEBD483C6")
    public boolean containsKey(String key) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        boolean varC1F1394BBE1C1666EB466B1C1659D67F_1040520313 = (keySet().contains(key));
        addTaint(key.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1807067139 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1807067139;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.626 -0400", hash_original_method = "D187399FB44FEACCB04758A5D261BC63", hash_generated_method = "640DA5D6D526944321D1343A4007F8C2")
    public Set<String> keySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_475290792 = null; 
        Set<String> ret = new HashSet<String>();
        Enumeration<String> keys = getKeys();
        {
            boolean var92FA05435258CA7C805716F7AD9C73B4_1249138732 = (keys.hasMoreElements());
            {
                ret.add(keys.nextElement());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_475290792 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_475290792.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_475290792;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.628 -0400", hash_original_method = "DE22A4C1E400841A42E2FCE258F58109", hash_generated_method = "A7508734029470C495BF1F89A6171197")
    protected Set<String> handleKeySet() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_283995607 = null; 
        Set<String> set = keySet();
        Set<String> ret = new HashSet<String>();
        {
            Iterator<String> var2F95B2C08B227486FC481950E8FAAAD3_126142453 = (set).iterator();
            var2F95B2C08B227486FC481950E8FAAAD3_126142453.hasNext();
            String key = var2F95B2C08B227486FC481950E8FAAAD3_126142453.next();
            {
                {
                    boolean var3EACB5F53EB01121F6C3A0A5551029B5_1358741402 = (handleGetObject(key) != null);
                    {
                        ret.add(key);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_283995607 = ret;
        varB4EAC82CA7396A68D541C85D26508E83_283995607.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_283995607;
        
        
        
        
            
                
            
        
        
    }

    
    static class MissingBundle extends ResourceBundle {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.629 -0400", hash_original_method = "5BE09748C47EC015C065AB0FE98F6425", hash_generated_method = "5BE09748C47EC015C065AB0FE98F6425")
        public MissingBundle ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.629 -0400", hash_original_method = "FAC6F24BFEFF063353B4F824D489D5CA", hash_generated_method = "73B1D44295A401E524F1CD8F1AD588B8")
        @Override
        public Enumeration<String> getKeys() {
            Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_683304669 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_683304669 = null;
            varB4EAC82CA7396A68D541C85D26508E83_683304669.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_683304669;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.630 -0400", hash_original_method = "F3BE912397EA9F5D184546387C802359", hash_generated_method = "7D0B38FEE9DBAE4051407AEEA4BEB34F")
        @Override
        public Object handleGetObject(String name) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1284166791 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1284166791 = null;
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1284166791.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1284166791;
            
            
        }

        
    }


    
    private static class NoFallbackControl extends Control {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.631 -0400", hash_original_method = "FB8596E95C5FFB192AB3B86CF874FD9D", hash_generated_method = "074066B24BB275764F86BA5FCA19CC07")
        public  NoFallbackControl(String format) {
            listClass = new ArrayList<String>();
            listClass.add(format);
            super.format = Collections.unmodifiableList(listClass);
            addTaint(format.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.631 -0400", hash_original_method = "EC736F9DA869A1318E5C5EA158F0C9E2", hash_generated_method = "C55FA7F6A2A409F7FCFB5FA7019632EF")
        public  NoFallbackControl(List<String> list) {
            super.format = list;
            addTaint(list.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.632 -0400", hash_original_method = "BF31820043735E3E2FECA9848CEFC17E", hash_generated_method = "AC1B401EE7A43C9C2C9EFDB06DA478E0")
        @Override
        public Locale getFallbackLocale(String baseName, Locale locale) {
            Locale varB4EAC82CA7396A68D541C85D26508E83_111745060 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_111745060 = null;
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_111745060.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_111745060;
            
            
                
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.633 -0400", hash_original_field = "F0BE005252D735BA1B008ACFEBCCB6DC", hash_generated_field = "311001FFE9CF90DDC4781726BDC7CC2A")

        static final Control NOFALLBACK_FORMAT_PROPERTIES_CONTROL = new NoFallbackControl(
                JAVAPROPERTIES);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.633 -0400", hash_original_field = "51B0D5060DC59A690DB1ABEC684DE2DD", hash_generated_field = "477E16589760E3D71EC82A0A4D59108B")

        static final Control NOFALLBACK_FORMAT_CLASS_CONTROL = new NoFallbackControl(
                JAVACLASS);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.633 -0400", hash_original_field = "12D373EA3CFB9B59F7610021F329A559", hash_generated_field = "58917EB628BB81A37E51203F85E79CF8")

        static final Control NOFALLBACK_FORMAT_DEFAULT_CONTROL = new NoFallbackControl(
                listDefault);
    }


    
    private static class SimpleControl extends Control {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.634 -0400", hash_original_method = "3FE57273BBED2EFD79C4104DD304532B", hash_generated_method = "B04E0DA4BDA79C8653C74D4007EA1B71")
        public  SimpleControl(String format) {
            listClass = new ArrayList<String>();
            listClass.add(format);
            super.format = Collections.unmodifiableList(listClass);
            addTaint(format.getTaint());
            
            
            
            
        }

        
    }


    
    public static class Control {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.634 -0400", hash_original_field = "1DDCB92ADE31C8FBD370001F9B29A7D9", hash_generated_field = "5C4A176E73E3AD8A44C29D1E04A3B849")

        List<String> format;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.634 -0400", hash_original_method = "95C40A3E350A764DF5A1D8A784434E7C", hash_generated_method = "949CF8FAA99C36B6D02001CFF1C3EFE2")
        protected  Control() {
            listClass = new ArrayList<String>();
            listClass.add(JAVACLASS);
            listClass.add(JAVAPROPERTIES);
            format = Collections.unmodifiableList(listClass);
            
            
            
            
            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.636 -0400", hash_original_method = "45631C4F246F185145A9ED45ADEA49D4", hash_generated_method = "0D1D1ABDF102E0F090FE9936ED34EA77")
        public List<Locale> getCandidateLocales(String baseName, Locale locale) {
            List<Locale> varB4EAC82CA7396A68D541C85D26508E83_437142843 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            List<Locale> retList = new ArrayList<Locale>();
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            {
                boolean varEC1127D11A1A0019D583D076F527D9CF_2069231101 = (!EMPTY_STRING.equals(variant));
                {
                    retList.add(new Locale(language, country, variant));
                } 
            } 
            {
                boolean varDEA1B14FA01AF7B442A3DD6CA499F74C_1165196512 = (!EMPTY_STRING.equals(country));
                {
                    retList.add(new Locale(language, country));
                } 
            } 
            {
                boolean varDCEF02BC51EEAFB5ACD7D89F7C557080_598794 = (!EMPTY_STRING.equals(language));
                {
                    retList.add(new Locale(language));
                } 
            } 
            retList.add(Locale.ROOT);
            varB4EAC82CA7396A68D541C85D26508E83_437142843 = retList;
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_437142843.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_437142843;
            
            
                
            
            
            
            
            
            
                
            
            
                
            
            
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.636 -0400", hash_original_method = "84F7301A6175FB80884F0D8355AEA589", hash_generated_method = "EE4D8B3A27CB2DADFB42BC1415D60CAC")
        public List<String> getFormats(String baseName) {
            List<String> varB4EAC82CA7396A68D541C85D26508E83_1907271248 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1907271248 = format;
            addTaint(baseName.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1907271248.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1907271248;
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.637 -0400", hash_original_method = "42195BC54E9E8857F62CE9C9CCBB8A2E", hash_generated_method = "51D4958E8DEC4475135981345FB2F88D")
        public Locale getFallbackLocale(String baseName, Locale locale) {
            Locale varB4EAC82CA7396A68D541C85D26508E83_2005977983 = null; 
            Locale varB4EAC82CA7396A68D541C85D26508E83_1865693614 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            {
                boolean varDEF5D6FEDD750F75376A958DD95E60D5_730149004 = (Locale.getDefault() != locale);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_2005977983 = Locale.getDefault();
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1865693614 = null;
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            Locale varA7E53CE21691AB073D9660D615818899_1358746106; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1358746106 = varB4EAC82CA7396A68D541C85D26508E83_2005977983;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1358746106 = varB4EAC82CA7396A68D541C85D26508E83_1865693614;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1358746106.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1358746106;
            
            
                
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.638 -0400", hash_original_method = "90658AB613E6A89EDB72A67F02A5F78D", hash_generated_method = "B4E5CC5B87FD2B4C447CE5E577FC76A4")
        public ResourceBundle newBundle(String baseName, Locale locale,
                String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException,
                IOException {
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_1627065801 = null; 
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_1773894970 = null; 
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_1030994065 = null; 
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_32822887 = null; 
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_592096044 = null; 
            ResourceBundle varB4EAC82CA7396A68D541C85D26508E83_1054788342 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            final String bundleName = toBundleName(baseName, locale);
            final ClassLoader clsloader = loader;
            ResourceBundle ret;
            {
                boolean var363A8B2CC1CE315300A409E41427D499_298677578 = (format.equals(JAVACLASS));
                {
                    Class<?> cls = null;
                    try 
                    {
                        cls = clsloader.loadClass(bundleName);
                    } 
                    catch (Exception e)
                    { }
                    catch (NoClassDefFoundError e)
                    { }
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1627065801 = null;
                    } 
                    try 
                    {
                        ResourceBundle bundle = (ResourceBundle) cls.newInstance();
                        bundle.setLocale(locale);
                        varB4EAC82CA7396A68D541C85D26508E83_1773894970 = bundle;
                    } 
                    catch (NullPointerException e)
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1030994065 = null;
                    } 
                } 
            } 
            {
                boolean varD6A8253E2C839BC6EC4A2010754A1DCD_1122598986 = (format.equals(JAVAPROPERTIES));
                {
                    InputStream streams = null;
                    final String resourceName = toResourceName(bundleName, "properties");
                    {
                        URL url = null;
                        try 
                        {
                            url = loader.getResource(resourceName);
                        } 
                        catch (NullPointerException e)
                        { }
                        {
                            URLConnection con = url.openConnection();
                            con.setUseCaches(false);
                            streams = con.getInputStream();
                        } 
                    } 
                    {
                        try 
                        {
                            streams = clsloader.getResourceAsStream(resourceName);
                        } 
                        catch (NullPointerException e)
                        { }
                    } 
                    {
                        try 
                        {
                            ret = new PropertyResourceBundle(new InputStreamReader(streams));
                            ret.setLocale(locale);
                            streams.close();
                        } 
                        catch (IOException e)
                        {
                            return null;
                        } 
                        varB4EAC82CA7396A68D541C85D26508E83_592096044 = ret;
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_1054788342 = null;
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            addTaint(format.getTaint());
            addTaint(loader.getTaint());
            addTaint(reload);
            ResourceBundle varA7E53CE21691AB073D9660D615818899_1202625203; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1202625203 = varB4EAC82CA7396A68D541C85D26508E83_1627065801;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1202625203 = varB4EAC82CA7396A68D541C85D26508E83_1773894970;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_1202625203 = varB4EAC82CA7396A68D541C85D26508E83_1030994065;
                    break;
                case 4: 
                    varA7E53CE21691AB073D9660D615818899_1202625203 = varB4EAC82CA7396A68D541C85D26508E83_32822887;
                    break;
                case 5: 
                    varA7E53CE21691AB073D9660D615818899_1202625203 = varB4EAC82CA7396A68D541C85D26508E83_592096044;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1202625203 = varB4EAC82CA7396A68D541C85D26508E83_1054788342;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1202625203.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1202625203;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.638 -0400", hash_original_method = "7BA29E8DE065D9912A86853D625E45B1", hash_generated_method = "C342E9FB3D18DE79F005BA1106190467")
        public long getTimeToLive(String baseName, Locale locale) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            long var0F5264038205EDFB1AC05FBB0E8C5E94_1744883068 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1744883068;
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.639 -0400", hash_original_method = "C3CC28923ED9707E414F789F1523116A", hash_generated_method = "C0F347BC51F4B7A95653C0A529DB01CD")
        public boolean needsReload(String baseName, Locale locale,
                String format, ClassLoader loader, ResourceBundle bundle,
                long loadTime) {
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            String bundleName = toBundleName(baseName, locale);
            String suffix = format;
            {
                boolean var363A8B2CC1CE315300A409E41427D499_1653360362 = (format.equals(JAVACLASS));
                {
                    suffix = "class";
                } 
            } 
            {
                boolean varD6A8253E2C839BC6EC4A2010754A1DCD_836050670 = (format.equals(JAVAPROPERTIES));
                {
                    suffix = "properties";
                } 
            } 
            String urlname = toResourceName(bundleName, suffix);
            URL url = loader.getResource(urlname);
            {
                String fileName = url.getFile();
                long lastModified = new File(fileName).lastModified();
            } 
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            addTaint(format.getTaint());
            addTaint(loader.getTaint());
            addTaint(bundle.getTaint());
            addTaint(loadTime);
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44975184 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_44975184;
            
            
                
            
            
            
            
                
            
            
                
            
            
            
            
                
                
                
                    
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.641 -0400", hash_original_method = "95EF33F16C513E472DD742F40E256E32", hash_generated_method = "26290CB3EC8A08B70E5F93EC7D7A4D00")
        public String toBundleName(String baseName, Locale locale) {
            String varB4EAC82CA7396A68D541C85D26508E83_858811815 = null; 
            final String emptyString = EMPTY_STRING;
            final String preString = UNDER_SCORE;
            final String underline = UNDER_SCORE;
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            StringBuilder ret = new StringBuilder();
            StringBuilder prefix = new StringBuilder();
            ret.append(baseName);
            {
                boolean var8116C9E993A89CC711D61AA067C5543D_1738120311 = (!locale.getLanguage().equals(emptyString));
                {
                    ret.append(underline);
                    ret.append(locale.getLanguage());
                } 
                {
                    prefix.append(preString);
                } 
            } 
            {
                boolean var019626354072A0B1F8CE16171922D987_1394255929 = (!locale.getCountry().equals(emptyString));
                {
                    ret.append((CharSequence) prefix);
                    ret.append(underline);
                    ret.append(locale.getCountry());
                    prefix = new StringBuilder();
                } 
                {
                    prefix.append(preString);
                } 
            } 
            {
                boolean var38517FCA653A00384EA828777964B7DD_845416492 = (!locale.getVariant().equals(emptyString));
                {
                    ret.append((CharSequence) prefix);
                    ret.append(underline);
                    ret.append(locale.getVariant());
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_858811815 = ret.toString();
            addTaint(baseName.getTaint());
            addTaint(locale.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_858811815.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_858811815;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.642 -0400", hash_original_method = "FCB3528CF98D643CACA491DF306BC818", hash_generated_method = "C679175326445015B196DA7963DD43AC")
        public final String toResourceName(String bundleName, String suffix) {
            String varB4EAC82CA7396A68D541C85D26508E83_2116066450 = null; 
            {
                if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
            } 
            StringBuilder ret = new StringBuilder(bundleName.replace('.', '/'));
            ret.append('.');
            ret.append(suffix);
            varB4EAC82CA7396A68D541C85D26508E83_2116066450 = ret.toString();
            addTaint(bundleName.getTaint());
            addTaint(suffix.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_2116066450.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_2116066450;
            
            
                
            
            
            
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.642 -0400", hash_original_field = "F883DF0BE51C6E6DE4D20E70AB2328E4", hash_generated_field = "7FAB5EFC8D0A39F92C2066ED7F83F277")

        static List<String> listDefault = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.642 -0400", hash_original_field = "E23066AFBA5FD9CE9DF4C3FA202E457B", hash_generated_field = "73FAB74F5A6B4799EFDB4572A408B125")

        static List<String> listClass = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.642 -0400", hash_original_field = "AFE0A77B730E680380CFE6EA55C51DFD", hash_generated_field = "2563531F9CF47ED6FC1FDD970ECD4F16")

        static List<String> listProperties = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.642 -0400", hash_original_field = "9958D37192A39A85F8CC51B79E70B8C2", hash_generated_field = "F1888E6AB92B35D00E8781C6258E3EE0")

        static String JAVACLASS = "java.class";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "1C2FF60CB53FAA0B881ADB89C22D3B95", hash_generated_field = "07BB0B876307E7CB6E2F167DC153078B")

        static String JAVAPROPERTIES = "java.properties";
        static {
            listDefault.add(JAVACLASS);
            listDefault.add(JAVAPROPERTIES);
            listClass.add(JAVACLASS);
            listProperties.add(JAVAPROPERTIES);
        }
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "1F661A88B9A779DBAC839396964A04D3", hash_generated_field = "F1424B45B48922D540F30BB96F5544C9")

        public static final List<String> FORMAT_DEFAULT = Collections
                .unmodifiableList(listDefault);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "4C0F5D8334D6DA9DD047A3E56F9935D9", hash_generated_field = "238B12F80DDF174B061C6B9B9ADB9205")

        public static final List<String> FORMAT_CLASS = Collections
                .unmodifiableList(listClass);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "90A269AD00605FE1555547E25BD2EC09", hash_generated_field = "AA1FEB25A6C045A701D589ABAE627BD6")

        public static final List<String> FORMAT_PROPERTIES = Collections
                .unmodifiableList(listProperties);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "4480A4BC9B756BD79CE2693AEB964C0F", hash_generated_field = "4947107FB4B8533751EC5231E42008C3")

        public static final long TTL_DONT_CACHE = -1L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "EC499B03368757C4B60EAD81CB227B4D", hash_generated_field = "65CF7FF426B0EE2E1D9FD78179803819")

        public static final long TTL_NO_EXPIRATION_CONTROL = -2L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "C4393F6F971CE5F5B9724C11749155A4", hash_generated_field = "E479AC9CE55FC38AA66AEB9C06A435BA")

        private static final Control FORMAT_PROPERTIES_CONTROL = new SimpleControl(
                JAVAPROPERTIES);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "2F9B352D101093DE430A17439BD1673B", hash_generated_field = "72CD7F4B7C3573EE5BEF1523C244BC01")

        private static final Control FORMAT_CLASS_CONTROL = new SimpleControl(
                JAVACLASS);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "108817DB34C2523A65A647CB1C10AFB1", hash_generated_field = "06188B6C636AFB65149581CD9F1C0A50")

        private static final Control FORMAT_DEFAULT_CONTROL = new Control();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "6CE7142F7AF3BCCD7A3950C3FEDFA77E", hash_generated_field = "E5AACE7C1FB793E41B40495A16336A99")

    private static final String UNDER_SCORE = "_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "898133B79D24539B71595F1C8C6BBF6C", hash_generated_field = "D14895E2C9628BA7CEA3A352030E9445")

    private static final String EMPTY_STRING = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.643 -0400", hash_original_field = "A749795A23092ECB9BB3757F664C6407", hash_generated_field = "85F7743A8A2325A7A53FE506DF5E477C")

    private static final ResourceBundle MISSING = new MissingBundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.644 -0400", hash_original_field = "C13F6920F8D183CB8736ED99060F9BA6", hash_generated_field = "88C3120A32FE602FF897F593D3471105")

    private static final ResourceBundle MISSINGBASE = new MissingBundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.644 -0400", hash_original_field = "CF1F6725974173FA855D6DA9746F184D", hash_generated_field = "02B8BB57FAC4063B50B258C20ED67E99")

    private static final WeakHashMap<Object, Hashtable<String, ResourceBundle>> cache = new WeakHashMap<Object, Hashtable<String, ResourceBundle>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.644 -0400", hash_original_field = "BD37D96B8058F3E7A7D028244344ED3D", hash_generated_field = "FB53443D57FD33E6486E78E1759D3531")

    private static Locale cacheLocale = Locale.getDefault();
}

