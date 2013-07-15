package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import libcore.io.IoUtils;

public final class ServiceLoader<S> implements Iterable<S> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.451 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "9105291DDC6ADFA906195342E88B2E45")

    private Class<S> service;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.451 -0400", hash_original_field = "23508C9A13E40798812B11A9CFC1E55C", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

    private ClassLoader classLoader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.451 -0400", hash_original_field = "10CD395CF71C18328C863C08E78F3FD0", hash_generated_field = "47668CA061897E9E78C4EAFC64299178")

    private Set<URL> services;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.452 -0400", hash_original_method = "94B9216B7758F0B227BA0C421F85C6AF", hash_generated_method = "A01E59B46F49F5E05D51AB60153DA358")
    private  ServiceLoader(Class<S> service, ClassLoader classLoader) {
    if(service == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_865722208 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_865722208.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_865722208;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.453 -0400", hash_original_method = "5DE3F3B80408315525994C211C4640EC", hash_generated_method = "B60E62D5BFE2284818EAB4DA920ACD3A")
    public void reload() {
        internalLoad();
        // ---------- Original Method ----------
        //internalLoad();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.453 -0400", hash_original_method = "347C14FB6BD1E7714C96867577CC330D", hash_generated_method = "135D84F9ECE1B14851507C4DFFA051DE")
    public Iterator<S> iterator() {
Iterator<S> var5595D01585350877366F9800888A00F9_1010428472 =         new ServiceIterator(this);
        var5595D01585350877366F9800888A00F9_1010428472.addTaint(taint);
        return var5595D01585350877366F9800888A00F9_1010428472;
        // ---------- Original Method ----------
        //return new ServiceIterator(this);
    }

    
        public static <S> ServiceLoader<S> load(Class<S> service, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return new ServiceLoader<S>(service, classLoader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.454 -0400", hash_original_method = "7DCE51783862B815D2BC789E6049F748", hash_generated_method = "EB3EC4B2E81FA32FF6F4AFAD426C9AC4")
    private void internalLoad() {
        services.clear();
        try 
        {
            String name = "META-INF/services/" + service.getName();
            services.addAll(Collections.list(classLoader.getResources(name)));
        } //End block
        catch (IOException e)
        {
            return;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.455 -0400", hash_original_method = "F8BFF902940FB319A126BEB71F562AF6", hash_generated_method = "D34865B5D652C5A51ECFCF475F72A78A")
    @Override
    public String toString() {
String varD6505E9E90B35E4D23556B6DAC1CF0D7_1247277605 =         "ServiceLoader for " + service.getName();
        varD6505E9E90B35E4D23556B6DAC1CF0D7_1247277605.addTaint(taint);
        return varD6505E9E90B35E4D23556B6DAC1CF0D7_1247277605;
        // ---------- Original Method ----------
        //return "ServiceLoader for " + service.getName();
    }

    
    private class ServiceIterator implements Iterator<S> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.455 -0400", hash_original_field = "23508C9A13E40798812B11A9CFC1E55C", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

        private ClassLoader classLoader;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.455 -0400", hash_original_field = "AAABF0D39951F3E6C3E8A7911DF524C2", hash_generated_field = "9105291DDC6ADFA906195342E88B2E45")

        private Class<S> service;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.455 -0400", hash_original_field = "10CD395CF71C18328C863C08E78F3FD0", hash_generated_field = "47668CA061897E9E78C4EAFC64299178")

        private Set<URL> services;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.455 -0400", hash_original_field = "2540E8397DE61AD999D75D9B9A4BB7A9", hash_generated_field = "AF3FD4FB03AF670FF56C37A3383F4F8C")

        private boolean isRead = false;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.456 -0400", hash_original_field = "A733E7069BD0A1288B92AFF72B6AC418", hash_generated_field = "379E2423239498A389B9B242C49020D7")

        private LinkedList<String> queue = new LinkedList<String>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.456 -0400", hash_original_method = "9B12B690CA5F78312F729D80BAC6EFA1", hash_generated_method = "0399B2EAAD832CBB301D916334B7DFAA")
        public  ServiceIterator(ServiceLoader<S> sl) {
            this.classLoader = sl.classLoader;
            this.service = sl.service;
            this.services = sl.services;
            // ---------- Original Method ----------
            //this.classLoader = sl.classLoader;
            //this.service = sl.service;
            //this.services = sl.services;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.456 -0400", hash_original_method = "DC8C57213B773C0EB2B0D98440591DD2", hash_generated_method = "A636FBCCF5D6978C8DC71D28A585D38E")
        public boolean hasNext() {
    if(!isRead)            
            {
                readClass();
            } //End block
            boolean var4134D5BD73BFA615ADC48C269CC99415_541614473 = ((queue != null && !queue.isEmpty()));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_252355414 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_252355414;
            // ---------- Original Method ----------
            //if (!isRead) {
                //readClass();
            //}
            //return (queue != null && !queue.isEmpty());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.457 -0400", hash_original_method = "B99394086046EF47562A5B63911931C2", hash_generated_method = "4C9778CCFEDB1B2E85E786CA86459FCC")
        @SuppressWarnings("unchecked")
        public S next() {
    if(!hasNext())            
            {
                NoSuchElementException var28D00AB599969908D71F102AF992D49A_202026988 = new NoSuchElementException();
                var28D00AB599969908D71F102AF992D49A_202026988.addTaint(taint);
                throw var28D00AB599969908D71F102AF992D49A_202026988;
            } //End block
            String className = queue.remove();
            try 
            {
S var4CE3DC2994840DD0E53401858CD7B335_526073860 =                 service.cast(classLoader.loadClass(className).newInstance());
                var4CE3DC2994840DD0E53401858CD7B335_526073860.addTaint(taint);
                return var4CE3DC2994840DD0E53401858CD7B335_526073860;
            } //End block
            catch (Exception e)
            {
                ServiceConfigurationError var4884B463F3943E5BC6F034CB08178A11_1128955024 = new ServiceConfigurationError("Couldn't instantiate class " + className, e);
                var4884B463F3943E5BC6F034CB08178A11_1128955024.addTaint(taint);
                throw var4884B463F3943E5BC6F034CB08178A11_1128955024;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.458 -0400", hash_original_method = "D6C7FE21AC961E0461EEEE7A6B5E3796", hash_generated_method = "DD51A5848B75A4D52113B6A1CC32AB03")
        private void readClass() {
for(URL url : services)
            {
                BufferedReader reader = null;
                try 
                {
                    reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                    String line;
                    while
((line = reader.readLine()) != null)                    
                    {
                        int commentStart = line.indexOf('#');
    if(commentStart != -1)                        
                        {
                            line = line.substring(0, commentStart);
                        } //End block
                        line = line.trim();
    if(line.isEmpty())                        
                        {
                            continue;
                        } //End block
                        String className = line;
                        checkValidJavaClassName(className);
    if(!queue.contains(className))                        
                        {
                            queue.add(className);
                        } //End block
                    } //End block
                    isRead = true;
                } //End block
                catch (Exception e)
                {
                    ServiceConfigurationError var1F7EA0C9D1D6DB8F57385C8CA6A576DA_214066341 = new ServiceConfigurationError("Couldn't read " + url, e);
                    var1F7EA0C9D1D6DB8F57385C8CA6A576DA_214066341.addTaint(taint);
                    throw var1F7EA0C9D1D6DB8F57385C8CA6A576DA_214066341;
                } //End block
                finally 
                {
                    IoUtils.closeQuietly(reader);
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.459 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "C19F603987C4900FF4C52D84F96851F2")
        public void remove() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1796061456 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1796061456.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1796061456;
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:05.459 -0400", hash_original_method = "0BD3CD94707D253C58DB4E9194FF8BE6", hash_generated_method = "EF872BC1162BE3580E6064E60BF6FE3F")
        private void checkValidJavaClassName(String className) {
            addTaint(className.getTaint());
for(int i = 0;i < className.length();++i)
            {
                char ch = className.charAt(i);
    if(!Character.isJavaIdentifierPart(ch) && ch != '.')                
                {
                    ServiceConfigurationError varF7F08B66C360D56E37E7510D7FABB6E3_339063969 = new ServiceConfigurationError("Bad character '" + ch + "' in class name");
                    varF7F08B66C360D56E37E7510D7FABB6E3_339063969.addTaint(taint);
                    throw varF7F08B66C360D56E37E7510D7FABB6E3_339063969;
                } //End block
            } //End block
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

