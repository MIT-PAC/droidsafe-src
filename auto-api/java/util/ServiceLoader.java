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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.976 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "9105291DDC6ADFA906195342E88B2E45")

    private Class<S> service;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.976 -0400", hash_original_field = "23508C9A13E40798812B11A9CFC1E55C", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

    private ClassLoader classLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.976 -0400", hash_original_field = "10CD395CF71C18328C863C08E78F3FD0", hash_generated_field = "47668CA061897E9E78C4EAFC64299178")

    private Set<URL> services;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.977 -0400", hash_original_method = "94B9216B7758F0B227BA0C421F85C6AF", hash_generated_method = "E0591261C45C392DA55784E39A1B7766")
    private  ServiceLoader(Class<S> service, ClassLoader classLoader) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        this.service = service;
        this.classLoader = classLoader;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.977 -0400", hash_original_method = "5DE3F3B80408315525994C211C4640EC", hash_generated_method = "B60E62D5BFE2284818EAB4DA920ACD3A")
    public void reload() {
        internalLoad();
        // ---------- Original Method ----------
        //internalLoad();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.978 -0400", hash_original_method = "347C14FB6BD1E7714C96867577CC330D", hash_generated_method = "6898CAB5BC5765A20B0D3962C9BC7CA2")
    public Iterator<S> iterator() {
        Iterator<S> varB4EAC82CA7396A68D541C85D26508E83_1537578614 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1537578614 = new ServiceIterator(this);
        varB4EAC82CA7396A68D541C85D26508E83_1537578614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1537578614;
        // ---------- Original Method ----------
        //return new ServiceIterator(this);
    }

    
    public static <S> ServiceLoader<S> load(Class<S> service, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return new ServiceLoader<S>(service, classLoader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.978 -0400", hash_original_method = "7DCE51783862B815D2BC789E6049F748", hash_generated_method = "254BCA6D033A2B9A30A38DA0FA5C01A2")
    private void internalLoad() {
        services.clear();
        try 
        {
            String name = "META-INF/services/" + service.getName();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.979 -0400", hash_original_method = "F8BFF902940FB319A126BEB71F562AF6", hash_generated_method = "4BADD6BFBA429879CDF36EC82E1CA908")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1649830218 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1649830218 = "ServiceLoader for " + service.getName();
        varB4EAC82CA7396A68D541C85D26508E83_1649830218.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1649830218;
        // ---------- Original Method ----------
        //return "ServiceLoader for " + service.getName();
    }

    
    private class ServiceIterator implements Iterator<S> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.979 -0400", hash_original_field = "23508C9A13E40798812B11A9CFC1E55C", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

        private ClassLoader classLoader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.979 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "9105291DDC6ADFA906195342E88B2E45")

        private Class<S> service;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.979 -0400", hash_original_field = "10CD395CF71C18328C863C08E78F3FD0", hash_generated_field = "47668CA061897E9E78C4EAFC64299178")

        private Set<URL> services;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.979 -0400", hash_original_field = "2540E8397DE61AD999D75D9B9A4BB7A9", hash_generated_field = "AF3FD4FB03AF670FF56C37A3383F4F8C")

        private boolean isRead = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.979 -0400", hash_original_field = "A733E7069BD0A1288B92AFF72B6AC418", hash_generated_field = "379E2423239498A389B9B242C49020D7")

        private LinkedList<String> queue = new LinkedList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.980 -0400", hash_original_method = "9B12B690CA5F78312F729D80BAC6EFA1", hash_generated_method = "0399B2EAAD832CBB301D916334B7DFAA")
        public  ServiceIterator(ServiceLoader<S> sl) {
            this.classLoader = sl.classLoader;
            this.service = sl.service;
            this.services = sl.services;
            // ---------- Original Method ----------
            //this.classLoader = sl.classLoader;
            //this.service = sl.service;
            //this.services = sl.services;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.981 -0400", hash_original_method = "DC8C57213B773C0EB2B0D98440591DD2", hash_generated_method = "066716E584F57D4EFDDAA381A91531B2")
        public boolean hasNext() {
            {
                readClass();
            } //End block
            boolean var8604F4A92D2CF732611B4938165DE574_1785266288 = ((queue != null && !queue.isEmpty()));
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_469326688 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_469326688;
            // ---------- Original Method ----------
            //if (!isRead) {
                //readClass();
            //}
            //return (queue != null && !queue.isEmpty());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.982 -0400", hash_original_method = "B99394086046EF47562A5B63911931C2", hash_generated_method = "3B1125D04412B877E6EAB6B188DB22FC")
        @SuppressWarnings("unchecked")
        public S next() {
            S varB4EAC82CA7396A68D541C85D26508E83_560666098 = null; //Variable for return #1
            {
                boolean var61E0EA93C8F2038A69462393E2D5DF33_1907494620 = (!hasNext());
                {
                    if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
                } //End block
            } //End collapsed parenthetic
            String className = queue.remove();
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_560666098 = service.cast(classLoader.loadClass(className).newInstance());
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new ServiceConfigurationError("Couldn't instantiate class " + className, e);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_560666098.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_560666098;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.995 -0400", hash_original_method = "D6C7FE21AC961E0461EEEE7A6B5E3796", hash_generated_method = "3E71B0B089C575D8FF1AFBE67801CC4B")
        private void readClass() {
            {
                Iterator<URL> var179CEED4B36D17AFF8E37F3D27DE36AC_2023849203 = (services).iterator();
                var179CEED4B36D17AFF8E37F3D27DE36AC_2023849203.hasNext();
                URL url = var179CEED4B36D17AFF8E37F3D27DE36AC_2023849203.next();
                {
                    BufferedReader reader = null;
                    try 
                    {
                        reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                        String line;
                        {
                            boolean var3692C4AFE68F25869E19E17717FA63AF_1507624881 = ((line = reader.readLine()) != null);
                            {
                                int commentStart = line.indexOf('#');
                                {
                                    line = line.substring(0, commentStart);
                                } //End block
                                line = line.trim();
                                {
                                    boolean varAB9A6F97B550590C437DB0E5913732CB_884783784 = (line.isEmpty());
                                } //End collapsed parenthetic
                                String className = line;
                                checkValidJavaClassName(className);
                                {
                                    boolean var87E0BB4FC1758213C22B5A05C9759255_1606928124 = (!queue.contains(className));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.996 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:10.997 -0400", hash_original_method = "0BD3CD94707D253C58DB4E9194FF8BE6", hash_generated_method = "EDFFE3C4E86A59F04E089EA52E3E3989")
        private void checkValidJavaClassName(String className) {
            {
                int i = 0;
                boolean var9852DFE92BDB5D96F0B653A5A72503E4_1874326366 = (i < className.length());
                {
                    char ch = className.charAt(i);
                    {
                        boolean var7FFC7776D891F880B80D207CB313B868_1281063094 = (!Character.isJavaIdentifierPart(ch) && ch != '.');
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ServiceConfigurationError("Bad character '" + ch + "' in class name");
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            addTaint(className.getTaint());
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

