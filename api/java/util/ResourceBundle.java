package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.650 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "EB43973F1559584562CFC00E839EB2BD")

    protected ResourceBundle parent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.650 -0400", hash_original_field = "FB216D9E8791E63C8D12BDC420956839", hash_generated_field = "3C599F5969C756C105E47474D7BCB663")

    private Locale locale;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.650 -0400", hash_original_field = "3466618A402CD9627C00D29C4F1E86DD", hash_generated_field = "7B08633B611AECF1A2DAD9D2043C79EB")

    private long lastLoadTime = 0;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.650 -0400", hash_original_method = "D851446F8E957DA41A03795AD93701D3", hash_generated_method = "5DB393969C6D50D5978689CA2C066976")
    public  ResourceBundle() {
        // ---------- Original Method ----------
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.652 -0400", hash_original_method = "4C873AD5A0D4D89DBA836C1C6CEC9B8D", hash_generated_method = "A02563BE70C262DA4640E885E6649194")
    public Locale getLocale() {
Locale varB14E682FEAD06D8198D8ADBCBD62DEDB_928376589 =         locale;
        varB14E682FEAD06D8198D8ADBCBD62DEDB_928376589.addTaint(taint);
        return varB14E682FEAD06D8198D8ADBCBD62DEDB_928376589;
        // ---------- Original Method ----------
        //return locale;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.656 -0400", hash_original_method = "5F9FE4637FD5B65A8B96E90EE5158818", hash_generated_method = "7FFFBD42901DC1895859A910874564B2")
    public final Object getObject(String key) {
        addTaint(key.getTaint());
        ResourceBundle last;
        ResourceBundle theParent = this;
        do {
            {
                Object result = theParent.handleGetObject(key);
                if(result != null)                
                {
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1838364522 =                     result;
                    varDC838461EE2FA0CA4C9BBB70A15456B0_1838364522.addTaint(taint);
                    return varDC838461EE2FA0CA4C9BBB70A15456B0_1838364522;
                } //End block
                last = theParent;
                theParent = theParent.parent;
            } //End block
} while (theParent != null);
        java.util.MissingResourceException var781BEE6EB89CD682E390010C168AF8F5_224539525 = missingResourceException(last.getClass().getName(), key);
        var781BEE6EB89CD682E390010C168AF8F5_224539525.addTaint(taint);
        throw var781BEE6EB89CD682E390010C168AF8F5_224539525;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.656 -0400", hash_original_method = "BF93FB2083E0950C32E8F3481E34A9FB", hash_generated_method = "48C6E04F0427674014EC9B95B7F3E8FA")
    public final String getString(String key) {
        addTaint(key.getTaint());
String varD204E0C65B2B0E45572451A6C1DD3E0D_335743302 =         (String) getObject(key);
        varD204E0C65B2B0E45572451A6C1DD3E0D_335743302.addTaint(taint);
        return varD204E0C65B2B0E45572451A6C1DD3E0D_335743302;
        // ---------- Original Method ----------
        //return (String) getObject(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.656 -0400", hash_original_method = "D1E41ED4E95B94C38D8DBD0F59139218", hash_generated_method = "48E3C42C91BE082E93496C80255BEBB6")
    public final String[] getStringArray(String key) {
        addTaint(key.getTaint());
String[] var1FF9BC54310AD0C730E0C72ED9975A7A_63457826 =         (String[]) getObject(key);
        var1FF9BC54310AD0C730E0C72ED9975A7A_63457826.addTaint(taint);
        return var1FF9BC54310AD0C730E0C72ED9975A7A_63457826;
        // ---------- Original Method ----------
        //return (String[]) getObject(key);
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.657 -0400", hash_original_method = "D114069C12BFDC5397D50DBECBCF423F", hash_generated_method = "A62ECC3BD9BC4EEE3A10E4238EC03CC2")
    protected void setParent(ResourceBundle bundle) {
        parent = bundle;
        // ---------- Original Method ----------
        //parent = bundle;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.658 -0400", hash_original_method = "B4C0A2B69538F3C9760ADE4F445366A0", hash_generated_method = "B437BB1B169BA6A1FAF1F1173446D3B3")
    private void setLocale(Locale locale) {
        this.locale = locale;
        // ---------- Original Method ----------
        //this.locale = locale;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.659 -0400", hash_original_method = "2C99687E9BDD3B9ED091517A1B0B0A5F", hash_generated_method = "5B5D138BF8295AECA43BAE8487481A30")
    public boolean containsKey(String key) {
        addTaint(key.getTaint());
        if(key == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2034324739 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_2034324739.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_2034324739;
        } //End block
        boolean varF884E8A6DD72192A6C950B76EE2FF64D_865521450 = (keySet().contains(key));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075999162 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075999162;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new NullPointerException();
        //}
        //return keySet().contains(key);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.659 -0400", hash_original_method = "D187399FB44FEACCB04758A5D261BC63", hash_generated_method = "BB7DC72E560712206F36C5DA8D55781A")
    public Set<String> keySet() {
        Set<String> ret = new HashSet<String>();
        Enumeration<String> keys = getKeys();
        while
(keys.hasMoreElements())        
        {
            ret.add(keys.nextElement());
        } //End block
Set<String> varEDFF4FBBF053B5DC2B444ADFA049EE0F_529533229 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_529533229.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_529533229;
        // ---------- Original Method ----------
        //Set<String> ret = new HashSet<String>();
        //Enumeration<String> keys = getKeys();
        //while (keys.hasMoreElements()) {
            //ret.add(keys.nextElement());
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.659 -0400", hash_original_method = "DE22A4C1E400841A42E2FCE258F58109", hash_generated_method = "18BE1094CFB45FE3E4C595305512FB2B")
    protected Set<String> handleKeySet() {
        Set<String> set = keySet();
        Set<String> ret = new HashSet<String>();
for(String key : set)
        {
            if(handleGetObject(key) != null)            
            {
                ret.add(key);
            } //End block
        } //End block
Set<String> varEDFF4FBBF053B5DC2B444ADFA049EE0F_1416478491 =         ret;
        varEDFF4FBBF053B5DC2B444ADFA049EE0F_1416478491.addTaint(taint);
        return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1416478491;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.660 -0400", hash_original_method = "5BE09748C47EC015C065AB0FE98F6425", hash_generated_method = "5BE09748C47EC015C065AB0FE98F6425")
        public MissingBundle ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.660 -0400", hash_original_method = "FAC6F24BFEFF063353B4F824D489D5CA", hash_generated_method = "B55887BA158521D2E654B866AF81C870")
        @Override
        public Enumeration<String> getKeys() {
Enumeration<String> var540C13E9E156B687226421B24F2DF178_634762933 =             null;
            var540C13E9E156B687226421B24F2DF178_634762933.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_634762933;
            // ---------- Original Method ----------
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.660 -0400", hash_original_method = "F3BE912397EA9F5D184546387C802359", hash_generated_method = "184DC16F20FD3481B2C45DE3541DD2B3")
        @Override
        public Object handleGetObject(String name) {
            addTaint(name.getTaint());
Object var540C13E9E156B687226421B24F2DF178_1513393463 =             null;
            var540C13E9E156B687226421B24F2DF178_1513393463.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1513393463;
            // ---------- Original Method ----------
            //return null;
        }

        
    }


    
    private static class NoFallbackControl extends Control {
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.660 -0400", hash_original_method = "FB8596E95C5FFB192AB3B86CF874FD9D", hash_generated_method = "D6F73F948E0D8F37ECD519A8C4AF865C")
        public  NoFallbackControl(String format) {
            addTaint(format.getTaint());
            listClass = new ArrayList<String>();
            listClass.add(format);
            super.format = Collections.unmodifiableList(listClass);
            // ---------- Original Method ----------
            //listClass = new ArrayList<String>();
            //listClass.add(format);
            //super.format = Collections.unmodifiableList(listClass);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.660 -0400", hash_original_method = "EC736F9DA869A1318E5C5EA158F0C9E2", hash_generated_method = "F7A0E4FA84F6FDBAFE939CF7B11CA15F")
        public  NoFallbackControl(List<String> list) {
            addTaint(list.getTaint());
            super.format = list;
            // ---------- Original Method ----------
            //super.format = list;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.660 -0400", hash_original_method = "BF31820043735E3E2FECA9848CEFC17E", hash_generated_method = "87F153869919DC1AC5A24FC126AAAA0E")
        @Override
        public Locale getFallbackLocale(String baseName, Locale locale) {
            addTaint(locale.getTaint());
            addTaint(baseName.getTaint());
            if(baseName == null || locale == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1561188684 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1561188684.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1561188684;
            } //End block
Locale var540C13E9E156B687226421B24F2DF178_302042592 =             null;
            var540C13E9E156B687226421B24F2DF178_302042592.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_302042592;
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //return null;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.660 -0400", hash_original_field = "F0BE005252D735BA1B008ACFEBCCB6DC", hash_generated_field = "311001FFE9CF90DDC4781726BDC7CC2A")

        static final Control NOFALLBACK_FORMAT_PROPERTIES_CONTROL = new NoFallbackControl(
                JAVAPROPERTIES);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.660 -0400", hash_original_field = "51B0D5060DC59A690DB1ABEC684DE2DD", hash_generated_field = "477E16589760E3D71EC82A0A4D59108B")

        static final Control NOFALLBACK_FORMAT_CLASS_CONTROL = new NoFallbackControl(
                JAVACLASS);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.660 -0400", hash_original_field = "12D373EA3CFB9B59F7610021F329A559", hash_generated_field = "58917EB628BB81A37E51203F85E79CF8")

        static final Control NOFALLBACK_FORMAT_DEFAULT_CONTROL = new NoFallbackControl(
                listDefault);
    }


    
    private static class SimpleControl extends Control {
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.661 -0400", hash_original_method = "3FE57273BBED2EFD79C4104DD304532B", hash_generated_method = "48312E8DD566917F1786283E480D6528")
        public  SimpleControl(String format) {
            addTaint(format.getTaint());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.661 -0400", hash_original_field = "1DDCB92ADE31C8FBD370001F9B29A7D9", hash_generated_field = "5C4A176E73E3AD8A44C29D1E04A3B849")

        List<String> format;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.661 -0400", hash_original_method = "95C40A3E350A764DF5A1D8A784434E7C", hash_generated_method = "949CF8FAA99C36B6D02001CFF1C3EFE2")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.661 -0400", hash_original_method = "45631C4F246F185145A9ED45ADEA49D4", hash_generated_method = "46F06B1E672AC353E20AFE4767061C27")
        public List<Locale> getCandidateLocales(String baseName, Locale locale) {
            addTaint(locale.getTaint());
            addTaint(baseName.getTaint());
            if(baseName == null || locale == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_741971215 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_741971215.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_741971215;
            } //End block
            List<Locale> retList = new ArrayList<Locale>();
            String language = locale.getLanguage();
            String country = locale.getCountry();
            String variant = locale.getVariant();
            if(!EMPTY_STRING.equals(variant))            
            {
                retList.add(new Locale(language, country, variant));
            } //End block
            if(!EMPTY_STRING.equals(country))            
            {
                retList.add(new Locale(language, country));
            } //End block
            if(!EMPTY_STRING.equals(language))            
            {
                retList.add(new Locale(language));
            } //End block
            retList.add(Locale.ROOT);
List<Locale> varA110E9DDFA014144C3D0FD6BB853B42C_1790917567 =             retList;
            varA110E9DDFA014144C3D0FD6BB853B42C_1790917567.addTaint(taint);
            return varA110E9DDFA014144C3D0FD6BB853B42C_1790917567;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.661 -0400", hash_original_method = "84F7301A6175FB80884F0D8355AEA589", hash_generated_method = "8296B2E87760E4B3FA27DBD37B865B4E")
        public List<String> getFormats(String baseName) {
            addTaint(baseName.getTaint());
            if(baseName == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1128239113 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1128239113.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1128239113;
            } //End block
List<String> var7281948259C2EC9A3380A32D0D83E689_221767995 =             format;
            var7281948259C2EC9A3380A32D0D83E689_221767995.addTaint(taint);
            return var7281948259C2EC9A3380A32D0D83E689_221767995;
            // ---------- Original Method ----------
            //if (baseName == null) {
                //throw new NullPointerException();
            //}
            //return format;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.662 -0400", hash_original_method = "42195BC54E9E8857F62CE9C9CCBB8A2E", hash_generated_method = "CBA28B9FBF4E53D362565708DE441E31")
        public Locale getFallbackLocale(String baseName, Locale locale) {
            addTaint(locale.getTaint());
            addTaint(baseName.getTaint());
            if(baseName == null || locale == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2040835324 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_2040835324.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_2040835324;
            } //End block
            if(Locale.getDefault() != locale)            
            {
Locale var144C4164A13FF099CE3146F1062DBE38_1480525450 =                 Locale.getDefault();
                var144C4164A13FF099CE3146F1062DBE38_1480525450.addTaint(taint);
                return var144C4164A13FF099CE3146F1062DBE38_1480525450;
            } //End block
Locale var540C13E9E156B687226421B24F2DF178_610893535 =             null;
            var540C13E9E156B687226421B24F2DF178_610893535.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_610893535;
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //if (Locale.getDefault() != locale) {
                //return Locale.getDefault();
            //}
            //return null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.662 -0400", hash_original_method = "90658AB613E6A89EDB72A67F02A5F78D", hash_generated_method = "1F0AF3847040BDFF7F34FA81D6C2DA48")
        public ResourceBundle newBundle(String baseName, Locale locale,
                String format, ClassLoader loader, boolean reload) throws IllegalAccessException, InstantiationException,
                IOException {
            addTaint(reload);
            addTaint(loader.getTaint());
            addTaint(format.getTaint());
            addTaint(locale.getTaint());
            addTaint(baseName.getTaint());
            if(format == null || loader == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_490075794 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_490075794.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_490075794;
            } //End block
            final String bundleName = toBundleName(baseName, locale);
            final ClassLoader clsloader = loader;
            ResourceBundle ret;
            if(format.equals(JAVACLASS))            
            {
                Class<?> cls = null;
                try 
                {
                    cls = clsloader.loadClass(bundleName);
                } //End block
                catch (Exception e)
                {
                } //End block
                catch (NoClassDefFoundError e)
                {
                } //End block
                if(cls == null)                
                {
ResourceBundle var540C13E9E156B687226421B24F2DF178_1958830125 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1958830125.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1958830125;
                } //End block
                try 
                {
                    ResourceBundle bundle = (ResourceBundle) cls.newInstance();
                    bundle.setLocale(locale);
ResourceBundle var7B2862195409742DCA365D8C6330AB92_534903153 =                     bundle;
                    var7B2862195409742DCA365D8C6330AB92_534903153.addTaint(taint);
                    return var7B2862195409742DCA365D8C6330AB92_534903153;
                } //End block
                catch (NullPointerException e)
                {
ResourceBundle var540C13E9E156B687226421B24F2DF178_857500875 =                     null;
                    var540C13E9E156B687226421B24F2DF178_857500875.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_857500875;
                } //End block
            } //End block
            if(format.equals(JAVAPROPERTIES))            
            {
                InputStream streams = null;
                final String resourceName = toResourceName(bundleName, "properties");
                if(reload)                
                {
                    URL url = null;
                    try 
                    {
                        url = loader.getResource(resourceName);
                    } //End block
                    catch (NullPointerException e)
                    {
                    } //End block
                    if(url != null)                    
                    {
                        URLConnection con = url.openConnection();
                        con.setUseCaches(false);
                        streams = con.getInputStream();
                    } //End block
                } //End block
                else
                {
                    try 
                    {
                        streams = clsloader.getResourceAsStream(resourceName);
                    } //End block
                    catch (NullPointerException e)
                    {
                    } //End block
                } //End block
                if(streams != null)                
                {
                    try 
                    {
                        ret = new PropertyResourceBundle(new InputStreamReader(streams));
                        ret.setLocale(locale);
                        streams.close();
                    } //End block
                    catch (IOException e)
                    {
ResourceBundle var540C13E9E156B687226421B24F2DF178_1966332016 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1966332016.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1966332016;
                    } //End block
ResourceBundle varEDFF4FBBF053B5DC2B444ADFA049EE0F_1868594779 =                     ret;
                    varEDFF4FBBF053B5DC2B444ADFA049EE0F_1868594779.addTaint(taint);
                    return varEDFF4FBBF053B5DC2B444ADFA049EE0F_1868594779;
                } //End block
ResourceBundle var540C13E9E156B687226421B24F2DF178_1508929820 =                 null;
                var540C13E9E156B687226421B24F2DF178_1508929820.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1508929820;
            } //End block
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_27039441 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_27039441.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_27039441;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.663 -0400", hash_original_method = "7BA29E8DE065D9912A86853D625E45B1", hash_generated_method = "BC507B8103041D33E6941FC744AF9316")
        public long getTimeToLive(String baseName, Locale locale) {
            addTaint(locale.getTaint());
            addTaint(baseName.getTaint());
            if(baseName == null || locale == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_306951871 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_306951871.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_306951871;
            } //End block
            long var066867C600BA610015F4BBD564171BF3_1491768326 = (TTL_NO_EXPIRATION_CONTROL);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1182441396 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1182441396;
            // ---------- Original Method ----------
            //if (baseName == null || locale == null) {
                //throw new NullPointerException();
            //}
            //return TTL_NO_EXPIRATION_CONTROL;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.663 -0400", hash_original_method = "C3CC28923ED9707E414F789F1523116A", hash_generated_method = "D11F5F4FF5636747A14003F6513FCCFC")
        public boolean needsReload(String baseName, Locale locale,
                String format, ClassLoader loader, ResourceBundle bundle,
                long loadTime) {
            addTaint(loadTime);
            addTaint(bundle.getTaint());
            addTaint(loader.getTaint());
            addTaint(format.getTaint());
            addTaint(locale.getTaint());
            addTaint(baseName.getTaint());
            if(bundle == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1745043899 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_1745043899.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_1745043899;
            } //End block
            String bundleName = toBundleName(baseName, locale);
            String suffix = format;
            if(format.equals(JAVACLASS))            
            {
                suffix = "class";
            } //End block
            if(format.equals(JAVAPROPERTIES))            
            {
                suffix = "properties";
            } //End block
            String urlname = toResourceName(bundleName, suffix);
            URL url = loader.getResource(urlname);
            if(url != null)            
            {
                String fileName = url.getFile();
                long lastModified = new File(fileName).lastModified();
                if(lastModified > loadTime)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1537547476 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1589468179 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1589468179;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_61163155 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2126434505 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2126434505;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.663 -0400", hash_original_method = "95EF33F16C513E472DD742F40E256E32", hash_generated_method = "53D50D9711644A2FC906262308F5408C")
        public String toBundleName(String baseName, Locale locale) {
            addTaint(locale.getTaint());
            addTaint(baseName.getTaint());
            final String emptyString = EMPTY_STRING;
            final String preString = UNDER_SCORE;
            final String underline = UNDER_SCORE;
            if(baseName == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_174206100 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_174206100.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_174206100;
            } //End block
            StringBuilder ret = new StringBuilder();
            StringBuilder prefix = new StringBuilder();
            ret.append(baseName);
            if(!locale.getLanguage().equals(emptyString))            
            {
                ret.append(underline);
                ret.append(locale.getLanguage());
            } //End block
            else
            {
                prefix.append(preString);
            } //End block
            if(!locale.getCountry().equals(emptyString))            
            {
                ret.append((CharSequence) prefix);
                ret.append(underline);
                ret.append(locale.getCountry());
                prefix = new StringBuilder();
            } //End block
            else
            {
                prefix.append(preString);
            } //End block
            if(!locale.getVariant().equals(emptyString))            
            {
                ret.append((CharSequence) prefix);
                ret.append(underline);
                ret.append(locale.getVariant());
            } //End block
String varBF0416CC9C97BA8F7D7771199729A131_188560417 =             ret.toString();
            varBF0416CC9C97BA8F7D7771199729A131_188560417.addTaint(taint);
            return varBF0416CC9C97BA8F7D7771199729A131_188560417;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.663 -0400", hash_original_method = "FCB3528CF98D643CACA491DF306BC818", hash_generated_method = "C9851B30ED9CE2D316A78F4ADE5F6CEF")
        public final String toResourceName(String bundleName, String suffix) {
            addTaint(suffix.getTaint());
            addTaint(bundleName.getTaint());
            if(suffix == null)            
            {
                NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_119953878 = new NullPointerException();
                var7338BC9F48D81FE0BBD6183F4014DCC4_119953878.addTaint(taint);
                throw var7338BC9F48D81FE0BBD6183F4014DCC4_119953878;
            } //End block
            StringBuilder ret = new StringBuilder(bundleName.replace('.', '/'));
            ret.append('.');
            ret.append(suffix);
String varBF0416CC9C97BA8F7D7771199729A131_1142879618 =             ret.toString();
            varBF0416CC9C97BA8F7D7771199729A131_1142879618.addTaint(taint);
            return varBF0416CC9C97BA8F7D7771199729A131_1142879618;
            // ---------- Original Method ----------
            //if (suffix == null) {
                //throw new NullPointerException();
            //}
            //StringBuilder ret = new StringBuilder(bundleName.replace('.', '/'));
            //ret.append('.');
            //ret.append(suffix);
            //return ret.toString();
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.663 -0400", hash_original_field = "F883DF0BE51C6E6DE4D20E70AB2328E4", hash_generated_field = "7FAB5EFC8D0A39F92C2066ED7F83F277")

        static List<String> listDefault = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "E23066AFBA5FD9CE9DF4C3FA202E457B", hash_generated_field = "73FAB74F5A6B4799EFDB4572A408B125")

        static List<String> listClass = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "AFE0A77B730E680380CFE6EA55C51DFD", hash_generated_field = "2563531F9CF47ED6FC1FDD970ECD4F16")

        static List<String> listProperties = new ArrayList<String>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "9958D37192A39A85F8CC51B79E70B8C2", hash_generated_field = "F1888E6AB92B35D00E8781C6258E3EE0")

        static String JAVACLASS = "java.class";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "1C2FF60CB53FAA0B881ADB89C22D3B95", hash_generated_field = "07BB0B876307E7CB6E2F167DC153078B")

        static String JAVAPROPERTIES = "java.properties";
        static {
            listDefault.add(JAVACLASS);
            listDefault.add(JAVAPROPERTIES);
            listClass.add(JAVACLASS);
            listProperties.add(JAVAPROPERTIES);
        }
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "1F661A88B9A779DBAC839396964A04D3", hash_generated_field = "F1424B45B48922D540F30BB96F5544C9")

        public static final List<String> FORMAT_DEFAULT = Collections
                .unmodifiableList(listDefault);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "4C0F5D8334D6DA9DD047A3E56F9935D9", hash_generated_field = "238B12F80DDF174B061C6B9B9ADB9205")

        public static final List<String> FORMAT_CLASS = Collections
                .unmodifiableList(listClass);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "90A269AD00605FE1555547E25BD2EC09", hash_generated_field = "AA1FEB25A6C045A701D589ABAE627BD6")

        public static final List<String> FORMAT_PROPERTIES = Collections
                .unmodifiableList(listProperties);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "4480A4BC9B756BD79CE2693AEB964C0F", hash_generated_field = "4947107FB4B8533751EC5231E42008C3")

        public static final long TTL_DONT_CACHE = -1L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "EC499B03368757C4B60EAD81CB227B4D", hash_generated_field = "65CF7FF426B0EE2E1D9FD78179803819")

        public static final long TTL_NO_EXPIRATION_CONTROL = -2L;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "C4393F6F971CE5F5B9724C11749155A4", hash_generated_field = "E479AC9CE55FC38AA66AEB9C06A435BA")

        private static final Control FORMAT_PROPERTIES_CONTROL = new SimpleControl(
                JAVAPROPERTIES);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "2F9B352D101093DE430A17439BD1673B", hash_generated_field = "72CD7F4B7C3573EE5BEF1523C244BC01")

        private static final Control FORMAT_CLASS_CONTROL = new SimpleControl(
                JAVACLASS);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "108817DB34C2523A65A647CB1C10AFB1", hash_generated_field = "06188B6C636AFB65149581CD9F1C0A50")

        private static final Control FORMAT_DEFAULT_CONTROL = new Control();
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "6CE7142F7AF3BCCD7A3950C3FEDFA77E", hash_generated_field = "E5AACE7C1FB793E41B40495A16336A99")

    private static final String UNDER_SCORE = "_";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "898133B79D24539B71595F1C8C6BBF6C", hash_generated_field = "D14895E2C9628BA7CEA3A352030E9445")

    private static final String EMPTY_STRING = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "A749795A23092ECB9BB3757F664C6407", hash_generated_field = "85F7743A8A2325A7A53FE506DF5E477C")

    private static final ResourceBundle MISSING = new MissingBundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "C13F6920F8D183CB8736ED99060F9BA6", hash_generated_field = "88C3120A32FE602FF897F593D3471105")

    private static final ResourceBundle MISSINGBASE = new MissingBundle();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "CF1F6725974173FA855D6DA9746F184D", hash_generated_field = "02B8BB57FAC4063B50B258C20ED67E99")

    private static final WeakHashMap<Object, Hashtable<String, ResourceBundle>> cache = new WeakHashMap<Object, Hashtable<String, ResourceBundle>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:10.664 -0400", hash_original_field = "BD37D96B8058F3E7A7D028244344ED3D", hash_generated_field = "FB53443D57FD33E6486E78E1759D3531")

    private static Locale cacheLocale = Locale.getDefault();
}

