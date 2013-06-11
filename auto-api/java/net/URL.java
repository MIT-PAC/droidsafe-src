package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.jar.JarFile;
import libcore.net.http.HttpHandler;
import libcore.net.http.HttpsHandler;
import libcore.net.url.FileHandler;
import libcore.net.url.FtpHandler;
import libcore.net.url.JarHandler;
import libcore.net.url.UrlUtils;

public final class URL implements Serializable {
    private static final long serialVersionUID = -7627629688361524110L;
    private static URLStreamHandlerFactory streamHandlerFactory;
    private static final Hashtable<String, URLStreamHandler> streamHandlers
            = new Hashtable<String, URLStreamHandler>();
    private String protocol;
    private String authority;
    private String host;
    private int port = -1;
    private String file;
    private String ref;
    private transient String userInfo;
    private transient String path;
    private transient String query;
    transient URLStreamHandler streamHandler;
    private transient int hashCode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.413 -0400", hash_original_method = "121BE8263BD1C356B2FE90A678407E92", hash_generated_method = "C9D9765FCFA356F812F27768E1BF5601")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL(String spec) throws MalformedURLException {
        this((URL) null, spec, null);
        dsTaint.addTaint(spec);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.413 -0400", hash_original_method = "472053565B13D456EDCEBEA98F287F95", hash_generated_method = "33CF83379206F8C9D06CEADAF02B0028")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL(URL context, String spec) throws MalformedURLException {
        this(context, spec, null);
        dsTaint.addTaint(spec);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.413 -0400", hash_original_method = "D8E146F1F2E4ED207D7672129A3654D5", hash_generated_method = "BF0C29C164ADCBA2ABC5C9566E3C1A49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL(URL context, String spec, URLStreamHandler handler) throws MalformedURLException {
        dsTaint.addTaint(spec);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(handler.dsTaint);
        {
            throw new MalformedURLException();
        } //End block
        spec = spec.trim();
        protocol = UrlUtils.getSchemePrefix(spec);
        int schemeSpecificPartStart;
        schemeSpecificPartStart = (protocol.length() + 1);
        schemeSpecificPartStart = 0;
        {
            boolean var8B6DA5DD718D9B05B4E0F7B3F188798E_782706943 = (protocol != null && context != null && !protocol.equals(context.protocol));
            {
                context = null;
            } //End block
        } //End collapsed parenthetic
        {
            set(context.protocol, context.getHost(), context.getPort(), context.getAuthority(),
                    context.getUserInfo(), context.getPath(), context.getQuery(),
                    context.getRef());
            {
                streamHandler = context.streamHandler;
            } //End block
        } //End block
        {
            throw new MalformedURLException("Protocol not found: " + spec);
        } //End block
        {
            setupStreamHandler();
            {
                throw new MalformedURLException("Unknown protocol: " + protocol);
            } //End block
        } //End block
        try 
        {
            streamHandler.parseURL(this, spec, schemeSpecificPartStart, spec.length());
        } //End block
        catch (Exception e)
        {
            throw new MalformedURLException(e.toString());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.413 -0400", hash_original_method = "216BAC89605FCA377BB0AADBB6E2A8AC", hash_generated_method = "63E44D3B715BC0D46B96E697A95784B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL(String protocol, String host, String file) throws MalformedURLException {
        this(protocol, host, -1, file, null);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(host);
        dsTaint.addTaint(file);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.413 -0400", hash_original_method = "9AD76E183D70EDC4767A9EAC128427AE", hash_generated_method = "0038D512D01D2D363EBB776383A79D29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL(String protocol, String host, int port, String file) throws MalformedURLException {
        this(protocol, host, port, file, null);
        dsTaint.addTaint(port);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(host);
        dsTaint.addTaint(file);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.414 -0400", hash_original_method = "D56485CA0554FF67A28005CBDB936EDB", hash_generated_method = "1C84A798306405D08DC8F0BBC875F39A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URL(String protocol, String host, int port, String file,
            URLStreamHandler handler) throws MalformedURLException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(host);
        dsTaint.addTaint(file);
        dsTaint.addTaint(handler.dsTaint);
        {
            throw new MalformedURLException("port < -1: " + port);
        } //End block
        {
            throw new NullPointerException("protocol == null");
        } //End block
        {
            boolean var20EB247AB3D5F30E2BA7C7D6D1CF238E_1597711096 = (host != null && host.contains(":") && host.charAt(0) != '[');
            {
                host = "[" + host + "]";
            } //End block
        } //End collapsed parenthetic
        file = UrlUtils.authoritySafePath(host, file);
        int hash;
        hash = file.indexOf("#");
        {
            this.file = file.substring(0, hash);
            this.ref = file.substring(hash + 1);
        } //End block
        fixURL(false);
        {
            setupStreamHandler();
            {
                throw new MalformedURLException("Unknown protocol: " + protocol);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.414 -0400", hash_original_method = "E264CD67F28CEB420BDFAF4955BAAC34", hash_generated_method = "D41B6D48B40FB3DCB088E4959FD81241")
    public static synchronized void setURLStreamHandlerFactory(URLStreamHandlerFactory factory) {
        if (streamHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        streamHandlers.clear();
        streamHandlerFactory = factory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.414 -0400", hash_original_method = "0200B051ED19728512FC68E42BCAEC0F", hash_generated_method = "71EF831684571B0844E18EC207B99ACF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void fixURL(boolean fixHost) {
        dsTaint.addTaint(fixHost);
        int index;
        {
            boolean var6988708993DD24B87D8382C4CEDB2255_740970990 = (host != null && host.length() > 0);
            {
                authority = host;
                {
                    authority = authority + ":" + port;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var053492750823D0DDC9DDDC734C27B1DE_701042731 = (host != null && (index = host.lastIndexOf('@')) > -1);
                {
                    userInfo = host.substring(0, index);
                    host = host.substring(index + 1);
                } //End block
                {
                    userInfo = null;
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean var8F7388E3209FBE07887D8522BDA96A9A_1222160655 = (file != null && (index = file.indexOf('?')) > -1);
            {
                query = file.substring(index + 1);
                path = file.substring(0, index);
            } //End block
            {
                query = null;
                path = file;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int index;
        //if (host != null && host.length() > 0) {
            //authority = host;
            //if (port != -1) {
                //authority = authority + ":" + port;
            //}
        //}
        //if (fixHost) {
            //if (host != null && (index = host.lastIndexOf('@')) > -1) {
                //userInfo = host.substring(0, index);
                //host = host.substring(index + 1);
            //} else {
                //userInfo = null;
            //}
        //}
        //if (file != null && (index = file.indexOf('?')) > -1) {
            //query = file.substring(index + 1);
            //path = file.substring(0, index);
        //} else {
            //query = null;
            //path = file;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.414 -0400", hash_original_method = "2A0889AB616D5EC9F0D1FFB4406777A2", hash_generated_method = "4ACC6629FCE8BA2CC4C2A2079DBE6729")
    @DSModeled(DSC.SAFE)
    protected void set(String protocol, String host, int port, String file, String ref) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(ref);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(host);
        dsTaint.addTaint(file);
        hashCode = 0;
        fixURL(true);
        // ---------- Original Method ----------
        //if (this.protocol == null) {
            //this.protocol = protocol;
        //}
        //this.host = host;
        //this.file = file;
        //this.port = port;
        //this.ref = ref;
        //hashCode = 0;
        //fixURL(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.414 -0400", hash_original_method = "90B240523657DD4FC87B9440FE931EC1", hash_generated_method = "3D9627A15757BBEE9947C87F6E1DE95E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var87693CD490A8CD06F7E7327B7EEC47F9_1171573518 = (this.getClass() != o.getClass());
        } //End collapsed parenthetic
        boolean varD1686DF20B64D1720E650E2D4C23617C_796339652 = (streamHandler.equals(this, (URL) o));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == null) {
            //return false;
        //}
        //if (this == o) {
            //return true;
        //}
        //if (this.getClass() != o.getClass()) {
            //return false;
        //}
        //return streamHandler.equals(this, (URL) o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.414 -0400", hash_original_method = "0A94C2599C7A34FBFDE0162C017FE126", hash_generated_method = "A5DC919ECCD02E78119F524E4D6FD7E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean sameFile(URL otherURL) {
        dsTaint.addTaint(otherURL.dsTaint);
        boolean var4FA74F36F035176E103629A4C18DAE47_1569998781 = (streamHandler.sameFile(this, otherURL));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return streamHandler.sameFile(this, otherURL);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.414 -0400", hash_original_method = "83584D9C6686BC529C911ABE882D39AB", hash_generated_method = "BFF226A884499914E1745E10AF887EB0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        {
            hashCode = streamHandler.hashCode(this);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (hashCode == 0) {
            //hashCode = streamHandler.hashCode(this);
        //}
        //return hashCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "7ED1A4A4DB26C9983DC69C2C091F1C50", hash_generated_method = "F767EB03A39EB1488F8D727589A31FFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setupStreamHandler() {
        streamHandler = streamHandlers.get(protocol);
        {
            streamHandler = streamHandlerFactory.createURLStreamHandler(protocol);
            {
                streamHandlers.put(protocol, streamHandler);
            } //End block
        } //End block
        String packageList;
        packageList = System.getProperty("java.protocol.handler.pkgs");
        ClassLoader contextClassLoader;
        contextClassLoader = Thread.currentThread().getContextClassLoader();
        {
            {
                Iterator<String> seatecAstronomy42 = packageList.split("\\|").iterator();
                seatecAstronomy42.hasNext();
                String packageName = seatecAstronomy42.next();
                {
                    String className;
                    className = packageName + "." + protocol + ".Handler";
                    try 
                    {
                        Class<?> c;
                        c = contextClassLoader.loadClass(className);
                        streamHandler = (URLStreamHandler) c.newInstance();
                        {
                            streamHandlers.put(protocol, streamHandler);
                        } //End block
                    } //End block
                    catch (IllegalAccessException ignored)
                    { }
                    catch (InstantiationException ignored)
                    { }
                    catch (ClassNotFoundException ignored)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            boolean varD3586967695E598A11CD279A31554640_1965453045 = (protocol.equals("file"));
            {
                streamHandler = new FileHandler();
            } //End block
            {
                boolean var01B3067594838BB58C65DAFC7EEFAD50_209293525 = (protocol.equals("ftp"));
                {
                    streamHandler = new FtpHandler();
                } //End block
                {
                    boolean var6570A536ED54883FA06D64B8BBF6ECAB_105828125 = (protocol.equals("http"));
                    {
                        streamHandler = new HttpHandler();
                    } //End block
                    {
                        boolean varEE30D610179EA8038CD08747183F4F7A_1456077118 = (protocol.equals("https"));
                        {
                            streamHandler = new HttpsHandler();
                        } //End block
                        {
                            boolean varB604F1DF8F50013B1F7F0E3AFFD2694D_773101204 = (protocol.equals("jar"));
                            {
                                streamHandler = new JarHandler();
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            streamHandlers.put(protocol, streamHandler);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "D20F85DA45DCC6A1B9E0395104EBE2B6", hash_generated_method = "4060F2A760CBC164AAD7F7F59EF32EB7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Object getContent() throws IOException {
        Object varCDB57822ADC1190613A1C0666232203F_1551023111 = (openConnection().getContent());
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openConnection().getContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "D92AC8AC4808B4044341B9D346CCCA3C", hash_generated_method = "6AD9396BC2D92319001A1A87D9B116A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unchecked")
    public final Object getContent(Class[] types) throws IOException {
        dsTaint.addTaint(types.dsTaint);
        Object var29D24CD1070C1D03FACD92795F4BB6A0_372539104 = (openConnection().getContent(types));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openConnection().getContent(types);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "EA6B256CF4DB87F83CFE1379BEA78831", hash_generated_method = "8058BA55CF17FB02DB5793128496D6E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final InputStream openStream() throws IOException {
        InputStream var977DF59CB38DBEC101AC1327C97324A1_1348106775 = (openConnection().getInputStream());
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return openConnection().getInputStream();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "DDCF57687ACF51357E563F1083DC4261", hash_generated_method = "3A975AA87E15E264EBF89B17841A9549")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URLConnection openConnection() throws IOException {
        URLConnection var76FEB0F06BF507694F0754504C335AD4_1731570240 = (streamHandler.openConnection(this));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return streamHandler.openConnection(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "CB72409718452D46955A0A85FC179645", hash_generated_method = "C162CB41B5E73E5F55A7C12406016EC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URLConnection openConnection(Proxy proxy) throws IOException {
        dsTaint.addTaint(proxy.dsTaint);
        {
            throw new IllegalArgumentException("proxy == null");
        } //End block
        URLConnection var6EE512301BF02D2040E875DAA9435DB1_1710235782 = (streamHandler.openConnection(this, proxy));
        return (URLConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (proxy == null) {
            //throw new IllegalArgumentException("proxy == null");
        //}
        //return streamHandler.openConnection(this, proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "1E43ADB2B24E4AEE234C287749830ABE", hash_generated_method = "5DC3CF0899DD3F36D6A68FA080B65280")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI toURI() throws URISyntaxException {
        URI var02ADDAC02E06B5CAFCEB1056FEC18187_459687038 = (new URI(toExternalForm()));
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new URI(toExternalForm());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "9819CA3EECC28CF10D8C0CAB99E6CDCB", hash_generated_method = "0FBC82116AEC2BD3652370B2D62F8607")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public URI toURILenient() throws URISyntaxException {
        {
            throw new IllegalStateException(protocol);
        } //End block
        URI varD0490331BAD041A3205D874234372B14_1678223001 = (new URI(streamHandler.toExternalForm(this, true)));
        return (URI)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (streamHandler == null) {
            //throw new IllegalStateException(protocol);
        //}
        //return new URI(streamHandler.toExternalForm(this, true));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "9D75BD75136BEBAB4AE2F806E85803AD", hash_generated_method = "168BB0C1B42BB90C4B491CCB801B90DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var3D9B8EC72FB3F4EE292ACA7BC05B46A8_1566937134 = (toExternalForm());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return toExternalForm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "6763BB94BC9C65378EF7195BF94F5BED", hash_generated_method = "5E464118AAEA02935E6AC7F041CCEB94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toExternalForm() {
        String varA2B1BA21C5650A1E564BC1711AD7E283_958497742 = (streamHandler.toExternalForm(this));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (streamHandler == null) {
            //return "unknown protocol(" + protocol + ")://" + host + file;
        //}
        //return streamHandler.toExternalForm(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "75E256B9492C6227D987E1CACFC70E15", hash_generated_method = "80971843C13EFA05CD7E0BB09CAB4A42")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        try 
        {
            stream.defaultReadObject();
            {
                fixURL(true);
            } //End block
            {
                int index;
                {
                    boolean varF9FE0E6B7AE8AAABB9E093B0AF022E54_882982136 = ((index = authority.lastIndexOf('@')) > -1);
                    {
                        userInfo = authority.substring(0, index);
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean varF84173E21F456ED190E029514974D05F_1205034185 = (file != null && (index = file.indexOf('?')) > -1);
                    {
                        query = file.substring(index + 1);
                        path = file.substring(0, index);
                    } //End block
                    {
                        path = file;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            setupStreamHandler();
            {
                throw new IOException("Unknown protocol: " + protocol);
            } //End block
            hashCode = 0;
        } //End block
        catch (ClassNotFoundException e)
        {
            throw new IOException(e);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.415 -0400", hash_original_method = "CCBF13D66B2182AA6C1A2589205C2944", hash_generated_method = "93C5FA6CCA0B575E3A3114CC6249FCC7")
    @DSModeled(DSC.SAFE)
    private void writeObject(ObjectOutputStream s) throws IOException {
        dsTaint.addTaint(s.dsTaint);
        s.defaultWriteObject();
        // ---------- Original Method ----------
        //s.defaultWriteObject();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "89A7E9DBD8F7AF35FA9A39C4922A8C55", hash_generated_method = "0E87B1E58FB3E1274285CFC8353897F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getEffectivePort() {
        int varDAC3D556A5ED3DAF733060E2ACC01201_2145545655 = (URI.getEffectivePort(protocol, port));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return URI.getEffectivePort(protocol, port);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "A74773FBD6292704847794FB8A3C1AB0", hash_generated_method = "5CD0F075C268F7CCBDCB38EA78C37DF5")
    @DSModeled(DSC.SAFE)
    public String getProtocol() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "36971585CF0AC7121D34C5DBA5E7B5AD", hash_generated_method = "C303A29BD9AAAB4850B3739EB48CBB51")
    @DSModeled(DSC.SAFE)
    public String getAuthority() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return authority;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "C7599F6C2A9D16B1F9E84177D4C93D75", hash_generated_method = "585C09B6FC62B9F6F8D2050BAF053717")
    @DSModeled(DSC.SAFE)
    public String getUserInfo() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return userInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "2F2AEDD17A97DC05E80343AAC323BA28", hash_generated_method = "1A7C3D805857A92DA91C7FDF3E76506B")
    @DSModeled(DSC.SAFE)
    public String getHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return host;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "A5F7344FAECBE0D6DB15D1F6E7BEBC6E", hash_generated_method = "17AF8596D6B7DC38593E7C5BC3B81881")
    @DSModeled(DSC.SAFE)
    public int getPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "7E7EF83BCD62492BD0A03823F89518D0", hash_generated_method = "9AED384661AD08899534ABFC6ECAFE66")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDefaultPort() {
        int varC72F0348D2F1E173A8A2C8031FD4BB9C_64324496 = (streamHandler.getDefaultPort());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return streamHandler.getDefaultPort();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "D4C7450F6A022BC4DF89D66487C9A55A", hash_generated_method = "5BD3691E0E1F868A204C5C6BCF54619A")
    @DSModeled(DSC.SAFE)
    public String getFile() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return file;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "F862A3BA81BCB206C83E79C3BEB01336", hash_generated_method = "88D7B1D66F9B17ED94509EA59BB3DBF7")
    @DSModeled(DSC.SAFE)
    public String getPath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return path;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "1E279BC97111B7B33A732EF157351512", hash_generated_method = "5A7FD9D00C3D6CBC7D33ACA102C8D8FE")
    @DSModeled(DSC.SAFE)
    public String getQuery() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return query;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "3AAC0179CDFA195C747754E7ED20A392", hash_generated_method = "D6DC766891D2D84D0BFFC8217F640F87")
    @DSModeled(DSC.SAFE)
    public String getRef() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return ref;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.416 -0400", hash_original_method = "1BAF8E8ECD99ADEA9022FFFFA6473F49", hash_generated_method = "5CA210101936022EC18E0C97AE1269A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void set(String protocol, String host, int port, String authority, String userInfo,
            String path, String query, String ref) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(authority);
        dsTaint.addTaint(ref);
        dsTaint.addTaint(protocol);
        dsTaint.addTaint(host);
        dsTaint.addTaint(query);
        dsTaint.addTaint(path);
        dsTaint.addTaint(userInfo);
        String file;
        file = path;
        {
            boolean var5BAAB4912CDBF34FB484A7C75259848C_1237779336 = (query != null && !query.isEmpty());
            {
                file += "?" + query;
            } //End block
        } //End collapsed parenthetic
        set(protocol, host, port, file, ref);
        // ---------- Original Method ----------
        //String file = path;
        //if (query != null && !query.isEmpty()) {
            //file += "?" + query;
        //}
        //set(protocol, host, port, file, ref);
        //this.authority = authority;
        //this.userInfo = userInfo;
        //this.path = path;
        //this.query = query;
    }

    
}


