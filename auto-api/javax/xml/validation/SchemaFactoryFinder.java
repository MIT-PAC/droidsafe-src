


package javax.xml.validation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;
import javax.xml.XMLConstants;
import libcore.io.IoUtils;

import droidsafe.annotations.*;

final class SchemaFactoryFinder  {

    
    private static final String W3C_XML_SCHEMA10_NS_URI = "http://www.w3.org/XML/XMLSchema/v1.0";
    private static final String W3C_XML_SCHEMA11_NS_URI = "http://www.w3.org/XML/XMLSchema/v1.1";

    
    private static boolean debug = false;

    
    private static Properties cacheProps = new Properties();

    
    private static boolean firstTime = true;

    
    private static final int DEFAULT_LINE_LENGTH = 80;

    static {
        String val = System.getProperty("jaxp.debug");
        
        debug = val != null && (! "false".equals(val));
    }

    
    @DSModeled(DSC.SAFE)
    private static void debugPrintln(String msg) {
        if (debug) {
            System.err.println("JAXP: " + msg);
        }
    }

    
    private final ClassLoader classLoader;

    
    public SchemaFactoryFinder(ClassLoader loader) {
        this.classLoader = loader;
        if( debug ) {
            debugDisplayClassLoader();
        }
    }

    @DSModeled(DSC.SAFE)
    private void debugDisplayClassLoader() {
        if (classLoader == Thread.currentThread().getContextClassLoader()) {
            debugPrintln("using thread context class loader ("+classLoader+") for search");
            return;
        }

        if (classLoader == ClassLoader.getSystemClassLoader()) {
            debugPrintln("using system class loader ("+classLoader+") for search");
            return;
        }

        debugPrintln("using class loader (" + classLoader + ") for search");
    }

    
    @DSModeled(DSC.SAFE)
    public SchemaFactory newFactory(String schemaLanguage) {
        if(schemaLanguage==null)        throw new NullPointerException();
        SchemaFactory f = _newFactory(schemaLanguage);
        if (debug) {
            if (f != null) {
                debugPrintln("factory '" + f.getClass().getName() + "' was found for " + schemaLanguage);
            } else {
                debugPrintln("unable to find a factory for " + schemaLanguage);
            }
        }
        return f;
    }

    
    @DSModeled(DSC.SAFE)
    private SchemaFactory _newFactory(String schemaLanguage) {
        SchemaFactory sf;
        String propertyName = SERVICE_CLASS.getName() + ":" + schemaLanguage;

        
        try {
            if (debug) debugPrintln("Looking up system property '"+propertyName+"'" );
            String r = System.getProperty(propertyName);
            if (r != null && r.length() > 0) {
                if (debug) debugPrintln("The value is '"+r+"'");
                sf = createInstance(r);
                if(sf!=null)    return sf;
            }
            else if (debug) {
                debugPrintln("The property is undefined.");
            }
        }
        
        catch (VirtualMachineError vme) {
            throw vme;
        }
        
        catch (ThreadDeath td) {
            throw td;
        }
        catch (Throwable t) {
            if( debug ) {
                debugPrintln("failed to look up system property '"+propertyName+"'" );
                t.printStackTrace();
            }
        }

        String javah = System.getProperty("java.home");
        String configFile = javah + File.separator +
        "lib" + File.separator + "jaxp.properties";

        String factoryClassName = null ;

        
        try {
            if(firstTime){
                synchronized(cacheProps){
                    if(firstTime){
                        File f=new File( configFile );
                        firstTime = false;
                        if(f.exists()){
                            if (debug) debugPrintln("Read properties file " + f);
                            cacheProps.load(new FileInputStream(f));
                        }
                    }
                }
            }
            factoryClassName = cacheProps.getProperty(propertyName);
            if (debug) debugPrintln("found " + factoryClassName + " in $java.home/jaxp.properties");

            if (factoryClassName != null) {
                sf = createInstance(factoryClassName);
                if(sf != null){
                    return sf;
                }
            }
        } catch (Exception ex) {
            if (debug) {
                ex.printStackTrace();
            }
        }

        
        for (URL resource : createServiceFileIterator()) {
            if (debug) debugPrintln("looking into " + resource);
            try {
                sf = loadFromServicesFile(schemaLanguage,resource.toExternalForm(),
                        resource.openStream());
                if(sf!=null)    return sf;
            } catch(IOException e) {
                if( debug ) {
                    debugPrintln("failed to read "+resource);
                    e.printStackTrace();
                }
            }
        }

        
        if (schemaLanguage.equals(XMLConstants.W3C_XML_SCHEMA_NS_URI) || schemaLanguage.equals(W3C_XML_SCHEMA10_NS_URI)) {
            if (debug) debugPrintln("attempting to use the platform default XML Schema 1.0 validator");
            return createInstance("org.apache.xerces.jaxp.validation.XMLSchemaFactory");
        }
        else if (schemaLanguage.equals(W3C_XML_SCHEMA11_NS_URI)) {
            if (debug) debugPrintln("attempting to use the platform default XML Schema 1.1 validator");
            return createInstance("org.apache.xerces.jaxp.validation.XMLSchema11Factory");
        }

        if (debug) debugPrintln("all things were tried, but none was found. bailing out.");
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    SchemaFactory createInstance( String className ) {
        try {
            if (debug) debugPrintln("instantiating "+className);
            Class clazz;
            if( classLoader!=null )
                clazz = classLoader.loadClass(className);
            else
                clazz = Class.forName(className);
            if(debug)       debugPrintln("loaded it from "+which(clazz));
            Object o = clazz.newInstance();

            if( o instanceof SchemaFactory )
                return (SchemaFactory)o;

            if (debug) debugPrintln(className+" is not assignable to "+SERVICE_CLASS.getName());
        }
        
        catch (VirtualMachineError vme) {
            throw vme;
        }
        
        catch (ThreadDeath td) {
            throw td;
        }
        catch (Throwable t) {
            debugPrintln("failed to instantiate "+className);
            if(debug)   t.printStackTrace();
        }
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    private Iterable<URL> createServiceFileIterator() {
        if (classLoader == null) {
            ClassLoader classLoader = SchemaFactoryFinder.class.getClassLoader();
            return Collections.singleton(classLoader.getResource(SERVICE_ID));
        } else {
            try {
                Enumeration<URL> e = classLoader.getResources(SERVICE_ID);
                if (debug && !e.hasMoreElements()) {
                    debugPrintln("no "+SERVICE_ID+" file was found");
                }

                
                return Collections.list(e);
            } catch (IOException e) {
                if (debug) {
                    debugPrintln("failed to enumerate resources "+SERVICE_ID);
                    e.printStackTrace();
                }
                return Collections.emptySet();
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    private SchemaFactory loadFromServicesFile(String schemaLanguage, String resourceName, InputStream in) {

        if (debug) debugPrintln("Reading "+resourceName );

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        BufferedReader rd;
        try {
            rd = new BufferedReader(new InputStreamReader(in, "UTF-8"), DEFAULT_LINE_LENGTH);
        } catch (java.io.UnsupportedEncodingException e) {
            rd = new BufferedReader(new InputStreamReader(in), DEFAULT_LINE_LENGTH);
        }

        String factoryClassName = null;
        SchemaFactory resultFactory = null;
        
        while (true) {
            try {
                factoryClassName = rd.readLine();
            } catch (IOException x) {
                
                break;
            }
            if (factoryClassName != null) {
                
                int hashIndex = factoryClassName.indexOf('#');
                if (hashIndex != -1) {
                    factoryClassName = factoryClassName.substring(0, hashIndex);
                }

                
                factoryClassName = factoryClassName.trim();

                
                if (factoryClassName.length() == 0) {
                    continue;
                }

                try {
                    
                    SchemaFactory foundFactory = (SchemaFactory) createInstance(factoryClassName);
                    if (foundFactory.isSchemaLanguageSupported(schemaLanguage)) {
                        resultFactory = foundFactory;
                        break;
                    }
                }
                catch (Exception ignored) {}
            }
            else {
                break;
            }
        }

        IoUtils.closeQuietly(rd);

        return resultFactory;
    }

    private static final Class SERVICE_CLASS = SchemaFactory.class;
    private static final String SERVICE_ID = "META-INF/services/" + SERVICE_CLASS.getName();

    @DSModeled(DSC.SAFE)
    private static String which( Class clazz ) {
        return which( clazz.getName(), clazz.getClassLoader() );
    }

    
    @DSModeled(DSC.BAN)
    private static String which(String classname, ClassLoader loader) {
        String classnameAsResource = classname.replace('.', '/') + ".class";

        if (loader == null)  loader = ClassLoader.getSystemClassLoader();

        URL it = loader.getResource(classnameAsResource);
        return it != null ? it.toString() : null;
    }
}
