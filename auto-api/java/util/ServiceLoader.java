package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import libcore.io.IoUtils;

public final class ServiceLoader<S> implements Iterable<S> {
    private final Class<S> service;
    private final ClassLoader classLoader;
    private final Set<URL> services;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.889 -0400", hash_original_method = "94B9216B7758F0B227BA0C421F85C6AF", hash_generated_method = "CEAA7E9809FA27311F99817C68D324C5")
    @DSModeled(DSC.BAN)
    private ServiceLoader(Class<S> service, ClassLoader classLoader) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(classLoader.dsTaint);
        if (DroidSafeAndroidRuntime.control) {
            throw new NullPointerException();
        } //End block
        this.services = new HashSet<URL>();
        reload();
        // ---------- Original Method ----------
        //if (service == null) {
            //throw new NullPointerException();
        //}
        this.service = service;
        this.classLoader = classLoader;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.889 -0400", hash_original_method = "5DE3F3B80408315525994C211C4640EC", hash_generated_method = "1A03B4ED5AC44AAE1687E801EEDE26BB")
    @DSModeled(DSC.SAFE)
    public void reload() {
        internalLoad();
        // ---------- Original Method ----------
        //internalLoad();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.889 -0400", hash_original_method = "347C14FB6BD1E7714C96867577CC330D", hash_generated_method = "7256418B34C198A1D2FE43E04234FFCC")
    @DSModeled(DSC.SAFE)
    public Iterator<S> iterator() {
        return (Iterator<S>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ServiceIterator(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.889 -0400", hash_original_method = "B572574C5A7B8A07FF055A382D1862E6", hash_generated_method = "E83127EA7EF64AEBC06730FE9D2C1668")
    public static <S> ServiceLoader<S> load(Class<S> service, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return new ServiceLoader<S>(service, classLoader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "7DCE51783862B815D2BC789E6049F748", hash_generated_method = "D2C41B26A03723DE476180CA689B8C38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void internalLoad() {
        services.clear();
        try 
        {
            String name;
            name = "META-INF/services/" + service.getName();
            services.addAll(Collections.list(classLoader.getResources(name)));
        } //End block
        catch (IOException e)
        { }
        // ---------- Original Method ----------
        //services.clear();
        //try {
            //String name = "META-INF/services/" + service.getName();
            //services.addAll(Collections.list(classLoader.getResources(name)));
        //} catch (IOException e) {
            //return;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "BBA6EE8E6033CEA670AD344EFF51EA9E", hash_generated_method = "96A6262CDD71406ECC5CBFDBC4EB0926")
    public static <S> ServiceLoader<S> load(Class<S> service) {
        return ServiceLoader.load(service, Thread.currentThread().getContextClassLoader());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "A4515C32E7F715DCB812AE82F180321D", hash_generated_method = "F0DAAE05DDEBA097842F69F2883E7566")
    public static <S> ServiceLoader<S> loadInstalled(Class<S> service) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        if (cl != null) {
            while (cl.getParent() != null) {
                cl = cl.getParent();
            }
        }
        return ServiceLoader.load(service, cl);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "7CE484F546B38785B5EFD22514822C47", hash_generated_method = "54AD4EE22A82E31E666556280D06E0E4")
    public static <S> S loadFromSystemProperty(final Class<S> service) {
        try {
            final String className = System.getProperty(service.getName());
            if (className != null) {
                Class<?> c = ClassLoader.getSystemClassLoader().loadClass(className);
                return (S) c.newInstance();
            }
            return null;
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "F8BFF902940FB319A126BEB71F562AF6", hash_generated_method = "3C3037A642E15219CEBDD29817245F07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varF9D8C774DC47CBE9C6E4326148907DFA_1190574667 = ("ServiceLoader for " + service.getName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ServiceLoader for " + service.getName();
    }

    
    private class ServiceIterator implements Iterator<S> {
        private final ClassLoader classLoader;
        private final Class<S> service;
        private final Set<URL> services;
        private boolean isRead = false;
        private LinkedList<String> queue = new LinkedList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "9B12B690CA5F78312F729D80BAC6EFA1", hash_generated_method = "F46D6BEC4E1CC101D274EE490074C259")
        @DSModeled(DSC.SAFE)
        public ServiceIterator(ServiceLoader<S> sl) {
            dsTaint.addTaint(sl.dsTaint);
            this.classLoader = sl.classLoader;
            this.service = sl.service;
            this.services = sl.services;
            // ---------- Original Method ----------
            //this.classLoader = sl.classLoader;
            //this.service = sl.service;
            //this.services = sl.services;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "DC8C57213B773C0EB2B0D98440591DD2", hash_generated_method = "5F0621EB55CFA766E386A323BA385C50")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasNext() {
            {
                readClass();
            } //End block
            boolean var8604F4A92D2CF732611B4938165DE574_1513248689 = ((queue != null && !queue.isEmpty()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!isRead) {
                //readClass();
            //}
            //return (queue != null && !queue.isEmpty());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "B99394086046EF47562A5B63911931C2", hash_generated_method = "357A0C37DEC3A25AFE132F35E7985180")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        public S next() {
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_1090499920 = (!hasNext());
                if (DroidSafeAndroidRuntime.control) {
                    throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            String className;
            className = queue.remove();
            try 
            {
                S var010B48EA1517E3B9389609EB8470403E_234118914 = (service.cast(classLoader.loadClass(className).newInstance()));
            } //End block
            catch (Exception e)
            {
                throw new ServiceConfigurationError("Couldn't instantiate class " + className, e);
            } //End block
            return (S)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (!hasNext()) {
                //throw new NoSuchElementException();
            //}
            //String className = queue.remove();
            //try {
                //return service.cast(classLoader.loadClass(className).newInstance());
            //} catch (Exception e) {
                //throw new ServiceConfigurationError("Couldn't instantiate class " + className, e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "D6C7FE21AC961E0461EEEE7A6B5E3796", hash_generated_method = "6946DD17AC61B8C15CE3D0FDE56DAA3E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void readClass() {
            {
                Iterator<URL> seatecAstronomy42 = services.iterator();
                seatecAstronomy42.hasNext();
                URL url = seatecAstronomy42.next();
                {
                    BufferedReader reader;
                    reader = null;
                    try 
                    {
                        reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                        String line;
                        {
                            boolean var3692C4AFE68F25869E19E17717FA63AF_392031016 = ((line = reader.readLine()) != null);
                            {
                                int commentStart;
                                commentStart = line.indexOf('#');
                                {
                                    line = line.substring(0, commentStart);
                                } //End block
                                line = line.trim();
                                {
                                    boolean varAB9A6F97B550590C437DB0E5913732CB_1522449138 = (line.isEmpty());
                                } //End collapsed parenthetic
                                String className;
                                className = line;
                                checkValidJavaClassName(className);
                                {
                                    boolean var87E0BB4FC1758213C22B5A05C9759255_16843013 = (!queue.contains(className));
                                    {
                                        queue.add(className);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        isRead = true;
                    } //End block
                    catch (Exception e)
                    {
                        throw new ServiceConfigurationError("Couldn't read " + url, e);
                    } //End block
                    finally 
                    {
                        IoUtils.closeQuietly(reader);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "70F9650B41A870182901E546A7AB0548")
        @DSModeled(DSC.SAFE)
        public void remove() {
            throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.890 -0400", hash_original_method = "0BD3CD94707D253C58DB4E9194FF8BE6", hash_generated_method = "571987783810450DE51704801BDD6A71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void checkValidJavaClassName(String className) {
            dsTaint.addTaint(className);
            {
                int i;
                i = 0;
                boolean var9852DFE92BDB5D96F0B653A5A72503E4_963340145 = (i < className.length());
                {
                    char ch;
                    ch = className.charAt(i);
                    {
                        boolean var7FFC7776D891F880B80D207CB313B868_1967232685 = (!Character.isJavaIdentifierPart(ch) && ch != '.');
                        {
                            throw new ServiceConfigurationError("Bad character '" + ch + "' in class name");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //for (int i = 0; i < className.length(); ++i) {
                //char ch = className.charAt(i);
                //if (!Character.isJavaIdentifierPart(ch) && ch != '.') {
                    //throw new ServiceConfigurationError("Bad character '" + ch + "' in class name");
                //}
            //}
        }

        
    }


    
}


