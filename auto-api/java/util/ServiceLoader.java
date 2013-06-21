package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import libcore.io.IoUtils;

public final class ServiceLoader<S> implements Iterable<S> {
    private Class<S> service;
    private ClassLoader classLoader;
    private Set<URL> services;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.255 -0400", hash_original_method = "94B9216B7758F0B227BA0C421F85C6AF", hash_generated_method = "7C8C8333C3000F836B8974EE5F1DE74A")
    @DSModeled(DSC.BAN)
    private ServiceLoader(Class<S> service, ClassLoader classLoader) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(classLoader.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.services = new HashSet<URL>();
        reload();
        // ---------- Original Method ----------
        //if (service == null) {
            //throw new NullPointerException();
        //}
        //this.service = service;
        //this.classLoader = classLoader;
        //this.services = new HashSet<URL>();
        //reload();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.255 -0400", hash_original_method = "5DE3F3B80408315525994C211C4640EC", hash_generated_method = "B60E62D5BFE2284818EAB4DA920ACD3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reload() {
        internalLoad();
        // ---------- Original Method ----------
        //internalLoad();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.255 -0400", hash_original_method = "347C14FB6BD1E7714C96867577CC330D", hash_generated_method = "1237F03BE61D20BB03FD992A31FB77E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<S> iterator() {
        Iterator<S> var543F216F84DFDE28E289B6415C7593E8_384870667 = (new ServiceIterator(this));
        return (Iterator<S>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new ServiceIterator(this);
    }

    
        public static <S> ServiceLoader<S> load(Class<S> service, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return new ServiceLoader<S>(service, classLoader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.255 -0400", hash_original_method = "7DCE51783862B815D2BC789E6049F748", hash_generated_method = "6E37D1C2AFE2EF400D185FEE94652331")
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

    
        public static <S> ServiceLoader<S> load(Class<S> service) {
        return ServiceLoader.load(service, Thread.currentThread().getContextClassLoader());
    }

    
        public static <S> ServiceLoader<S> loadInstalled(Class<S> service) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        if (cl != null) {
            while (cl.getParent() != null) {
                cl = cl.getParent();
            }
        }
        return ServiceLoader.load(service, cl);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.256 -0400", hash_original_method = "F8BFF902940FB319A126BEB71F562AF6", hash_generated_method = "75EE6697ACB34A69F084BA9408F3C57B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String varF9D8C774DC47CBE9C6E4326148907DFA_242478407 = ("ServiceLoader for " + service.getName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "ServiceLoader for " + service.getName();
    }

    
    private class ServiceIterator implements Iterator<S> {
        private ClassLoader classLoader;
        private Class<S> service;
        private Set<URL> services;
        private boolean isRead = false;
        private LinkedList<String> queue = new LinkedList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.256 -0400", hash_original_method = "9B12B690CA5F78312F729D80BAC6EFA1", hash_generated_method = "B2060F8E338466EDB5314F3354787131")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.257 -0400", hash_original_method = "DC8C57213B773C0EB2B0D98440591DD2", hash_generated_method = "0F7410D24ECEBE8A273BB3298987693D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean hasNext() {
            {
                readClass();
            } //End block
            boolean var8604F4A92D2CF732611B4938165DE574_974401081 = ((queue != null && !queue.isEmpty()));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!isRead) {
                //readClass();
            //}
            //return (queue != null && !queue.isEmpty());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.257 -0400", hash_original_method = "B99394086046EF47562A5B63911931C2", hash_generated_method = "5A7B7D1C41067EE767ACD02A8A737060")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @SuppressWarnings("unchecked")
        public S next() {
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_868887167 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            String className;
            className = queue.remove();
            try 
            {
                S var010B48EA1517E3B9389609EB8470403E_259040541 = (service.cast(classLoader.loadClass(className).newInstance()));
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ServiceConfigurationError("Couldn't instantiate class " + className, e);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.286 -0400", hash_original_method = "D6C7FE21AC961E0461EEEE7A6B5E3796", hash_generated_method = "7288122D51172C9968B909EF024334E7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void readClass() {
            {
                Iterator<URL> var179CEED4B36D17AFF8E37F3D27DE36AC_1539223648 = (services).iterator();
                var179CEED4B36D17AFF8E37F3D27DE36AC_1539223648.hasNext();
                URL url = var179CEED4B36D17AFF8E37F3D27DE36AC_1539223648.next();
                {
                    BufferedReader reader;
                    reader = null;
                    try 
                    {
                        reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                        String line;
                        {
                            boolean var3692C4AFE68F25869E19E17717FA63AF_1129763912 = ((line = reader.readLine()) != null);
                            {
                                int commentStart;
                                commentStart = line.indexOf('#');
                                {
                                    line = line.substring(0, commentStart);
                                } //End block
                                line = line.trim();
                                {
                                    boolean varAB9A6F97B550590C437DB0E5913732CB_1146337707 = (line.isEmpty());
                                } //End collapsed parenthetic
                                String className;
                                className = line;
                                checkValidJavaClassName(className);
                                {
                                    boolean var87E0BB4FC1758213C22B5A05C9759255_373144386 = (!queue.contains(className));
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
                        if (DroidSafeAndroidRuntime.control) throw new ServiceConfigurationError("Couldn't read " + url, e);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.286 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.287 -0400", hash_original_method = "0BD3CD94707D253C58DB4E9194FF8BE6", hash_generated_method = "9789075535629C9C6EB5DF7078CB978D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void checkValidJavaClassName(String className) {
            dsTaint.addTaint(className);
            {
                int i;
                i = 0;
                boolean var9852DFE92BDB5D96F0B653A5A72503E4_1930623136 = (i < className.length());
                {
                    char ch;
                    ch = className.charAt(i);
                    {
                        boolean var7FFC7776D891F880B80D207CB313B868_2047018577 = (!Character.isJavaIdentifierPart(ch) && ch != '.');
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ServiceConfigurationError("Bad character '" + ch + "' in class name");
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

