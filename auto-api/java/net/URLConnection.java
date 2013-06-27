package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class URLConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "572D4E421E5E6B9BC11D815E8A027112", hash_generated_field = "65BA9482E03BACCDBB5A2D08239D2205")

    protected URL url;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "DF5FEAFAB86601EA0E1E6FE6E20DF6C5", hash_generated_field = "F7D06CB833C0C0295691396E4B1D1656")

    private String contentType;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "29F88E17E91EE912EF8A08645AE85733", hash_generated_field = "AA6C99420A3EDFB143DFB7EA7C0B7623")

    ContentHandler defaultHandler = new DefaultContentHandler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "1E65905B55C5FDFCEDE87E2147EF83D4", hash_generated_field = "80AE10D08247476B02E38D0EE6A074A6")

    private long lastModified = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "61C0F054FFE1E91934EAEB56EE7AF160", hash_generated_field = "CCFF3B6B851FE8AAC8BF953CAC3C257F")

    protected long ifModifiedSince;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "EEBF1201F029083BACC250A113006105", hash_generated_field = "75210328E42DAA7308C7C0DA02D4ECC5")

    protected boolean useCaches = defaultUseCaches;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "06AA6FA8BDC2078E7E1BD903E70C8F6A", hash_generated_field = "34C8ABCCB96118D0E63480374F97C450")

    protected boolean connected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "0E81D488D2F909D6A2A616B72D4618C2", hash_generated_field = "0588DDF6632243F20DFFAECC5F0C174F")

    protected boolean doOutput;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "B1043A2A09F39C536DD3E2FFE22765F1", hash_generated_field = "9295E463A85C6D53795FA77F5F4990C8")

    protected boolean doInput = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "F928530DB23E56922DC9E86CDD254774", hash_generated_field = "4EB96F0015DD5E6A1B47A0B69C90DCD0")

    protected boolean allowUserInteraction = defaultAllowUserInteraction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "EBA57E117BB383A9D85770809926064C", hash_generated_field = "2D29EC4E724B4A9910DF5E47FBCFBD74")

    private int readTimeout = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.451 -0400", hash_original_field = "FAD2CED9F68F37418BC6C3633BE26D8B", hash_generated_field = "7C5462E35603097818B70A73FEBCE187")

    private int connectTimeout = 0;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.452 -0400", hash_original_method = "C1B78B989F00EEFB1B34CFF3211D8415", hash_generated_method = "26FB837EE505F718F5C8BD67B14C0626")
    protected  URLConnection(URL url) {
        this.url = url;
        // ---------- Original Method ----------
        //this.url = url;
    }

    
    public abstract void connect() throws IOException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.452 -0400", hash_original_method = "C67DC5C525139049127B216E3212E5BD", hash_generated_method = "0E392AA01A3A1C9E64A0E5EBC49C8215")
    public boolean getAllowUserInteraction() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1390684295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1390684295;
        // ---------- Original Method ----------
        //return allowUserInteraction;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.453 -0400", hash_original_method = "2189DFB0457B899A3D415AD1ACECB1AB", hash_generated_method = "564780BFA999D4EFDB01247FA6A06CA2")
    public Object getContent() throws java.io.IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_266499059 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_434551925 = null; //Variable for return #2
        {
            connect();
        } //End block
        {
            boolean varA85A22BDA5170C074999CE557CE528EC_1376755089 = ((contentType = getContentType()) == null);
            {
                {
                    boolean var491682286539AF5FD0E713D813196B61_667149663 = ((contentType = guessContentTypeFromName(url.getFile())) == null);
                    {
                        contentType = guessContentTypeFromStream(getInputStream());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_266499059 = getContentHandler(contentType).getContent(this);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_434551925 = null;
        Object varA7E53CE21691AB073D9660D615818899_214231635; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_214231635 = varB4EAC82CA7396A68D541C85D26508E83_266499059;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_214231635 = varB4EAC82CA7396A68D541C85D26508E83_434551925;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_214231635.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_214231635;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //if ((contentType = getContentType()) == null) {
            //if ((contentType = guessContentTypeFromName(url.getFile())) == null) {
                //contentType = guessContentTypeFromStream(getInputStream());
            //}
        //}
        //if (contentType != null) {
            //return getContentHandler(contentType).getContent(this);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.454 -0400", hash_original_method = "4564C020E5F3A695F95559B726D59F50", hash_generated_method = "AF6AF72F6367836F7FD570E5C1C31B84")
    @SuppressWarnings("unchecked")
    public Object getContent(Class[] types) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1467444566 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1558941389 = null; //Variable for return #2
        {
            connect();
        } //End block
        {
            boolean varA85A22BDA5170C074999CE557CE528EC_647597766 = ((contentType = getContentType()) == null);
            {
                {
                    boolean var491682286539AF5FD0E713D813196B61_534168993 = ((contentType = guessContentTypeFromName(url.getFile())) == null);
                    {
                        contentType = guessContentTypeFromStream(getInputStream());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_1467444566 = getContentHandler(contentType).getContent(this, types);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1558941389 = null;
        addTaint(types[0].getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1125777741; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1125777741 = varB4EAC82CA7396A68D541C85D26508E83_1467444566;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1125777741 = varB4EAC82CA7396A68D541C85D26508E83_1558941389;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1125777741.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1125777741;
        // ---------- Original Method ----------
        //if (!connected) {
            //connect();
        //}
        //if ((contentType = getContentType()) == null) {
            //if ((contentType = guessContentTypeFromName(url.getFile())) == null) {
                //contentType = guessContentTypeFromStream(getInputStream());
            //}
        //}
        //if (contentType != null) {
            //return getContentHandler(contentType).getContent(this, types);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.457 -0400", hash_original_method = "F034FCCBCF276A401A79AE9D47D45859", hash_generated_method = "0E0FACF5C3DDBB7C1FCB8A960B9B05FE")
    public String getContentEncoding() {
        String varB4EAC82CA7396A68D541C85D26508E83_771967317 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_771967317 = getHeaderField("Content-Encoding");
        varB4EAC82CA7396A68D541C85D26508E83_771967317.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_771967317;
        // ---------- Original Method ----------
        //return getHeaderField("Content-Encoding");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.513 -0400", hash_original_method = "F46F19D62AAF6AA8CA742989F38D6600", hash_generated_method = "C97345A426149E79853A38629E455EE9")
    private ContentHandler getContentHandler(String type) throws IOException {
        ContentHandler varB4EAC82CA7396A68D541C85D26508E83_516620370 = null; //Variable for return #1
        ContentHandler varB4EAC82CA7396A68D541C85D26508E83_681104501 = null; //Variable for return #2
        ContentHandler varB4EAC82CA7396A68D541C85D26508E83_308409926 = null; //Variable for return #3
        ContentHandler varB4EAC82CA7396A68D541C85D26508E83_1999908320 = null; //Variable for return #4
        String typeString;
        typeString = parseTypeString(type.replace('/', '.'));
        Object cHandler;
        cHandler = contentHandlers.get(type);
        {
            varB4EAC82CA7396A68D541C85D26508E83_516620370 = (ContentHandler) cHandler;
        } //End block
        {
            cHandler = contentHandlerFactory.createContentHandler(type);
            contentHandlers.put(type, cHandler);
            varB4EAC82CA7396A68D541C85D26508E83_681104501 = (ContentHandler) cHandler;
        } //End block
        String packageList;
        packageList = System.getProperty("java.content.handler.pkgs");
        {
            {
                Iterator<String> varF7DDCB99A797792EC7DC3A4DAAF9383E_1991987931 = (packageList.split("\\|")).iterator();
                varF7DDCB99A797792EC7DC3A4DAAF9383E_1991987931.hasNext();
                String packageName = varF7DDCB99A797792EC7DC3A4DAAF9383E_1991987931.next();
                {
                    String className;
                    className = packageName + "." + typeString;
                    try 
                    {
                        Class<?> klass;
                        klass = Class.forName(className, true, ClassLoader.getSystemClassLoader());
                        cHandler = klass.newInstance();
                    } //End block
                    catch (ClassNotFoundException e)
                    { }
                    catch (IllegalAccessException e)
                    { }
                    catch (InstantiationException e)
                    { }
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            try 
            {
                String className;
                className = "org.apache.harmony.awt.www.content." + typeString;
                cHandler = Class.forName(className).newInstance();
            } //End block
            catch (ClassNotFoundException e)
            { }
            catch (IllegalAccessException e)
            { }
            catch (InstantiationException e)
            { }
        } //End block
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new UnknownServiceException();
            } //End block
            contentHandlers.put(type, cHandler);
            varB4EAC82CA7396A68D541C85D26508E83_308409926 = (ContentHandler) cHandler;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1999908320 = defaultHandler;
        addTaint(type.getTaint());
        ContentHandler varA7E53CE21691AB073D9660D615818899_1092601559; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1092601559 = varB4EAC82CA7396A68D541C85D26508E83_516620370;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1092601559 = varB4EAC82CA7396A68D541C85D26508E83_681104501;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1092601559 = varB4EAC82CA7396A68D541C85D26508E83_308409926;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1092601559 = varB4EAC82CA7396A68D541C85D26508E83_1999908320;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1092601559.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1092601559;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.513 -0400", hash_original_method = "D3CB748394BDEDD2AA4B807728EDFBEF", hash_generated_method = "FD1ED426790CCE6A3500A232FA53BC34")
    public int getContentLength() {
        int varA52287D24A01A3F982C408FA2D5E8EC8_242627560 = (getHeaderFieldInt("Content-Length", -1));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260880389 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_260880389;
        // ---------- Original Method ----------
        //return getHeaderFieldInt("Content-Length", -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.518 -0400", hash_original_method = "7440B54E7BE94AE7F9BB4349A25246D4", hash_generated_method = "24BA52A070E3C218E7D59E83A84C37C6")
    public String getContentType() {
        String varB4EAC82CA7396A68D541C85D26508E83_1496284673 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1496284673 = getHeaderField("Content-Type");
        varB4EAC82CA7396A68D541C85D26508E83_1496284673.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1496284673;
        // ---------- Original Method ----------
        //return getHeaderField("Content-Type");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.518 -0400", hash_original_method = "4C9F7702471FFCF16C0BDF48E7BD6750", hash_generated_method = "CDA54B031525A76483C998016338A384")
    public long getDate() {
        long var46CDFFD7E5A5B6BB43365990F0F900F1_67771674 = (getHeaderFieldDate("Date", 0));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_660608799 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_660608799;
        // ---------- Original Method ----------
        //return getHeaderFieldDate("Date", 0);
    }

    
        public static boolean getDefaultAllowUserInteraction() {
        return defaultAllowUserInteraction;
    }

    
        @Deprecated
    public static String getDefaultRequestProperty(String field) {
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.536 -0400", hash_original_method = "08FC81CB612F586F4ABF44BAE872E3A8", hash_generated_method = "B5EE00D3A9996DF97254B21F8D8E8A81")
    public boolean getDefaultUseCaches() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1312833895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1312833895;
        // ---------- Original Method ----------
        //return defaultUseCaches;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.536 -0400", hash_original_method = "CCCD690FEDEDD1DE3F70C92A661DD993", hash_generated_method = "AE254FAB23A9BB228E32EB194A78183B")
    public boolean getDoInput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1064847071 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1064847071;
        // ---------- Original Method ----------
        //return doInput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.537 -0400", hash_original_method = "15D6FCAAE0989BD58186FF458E57106D", hash_generated_method = "533CEC83C20E3AE4F66B1F1BB5B928FF")
    public boolean getDoOutput() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167475167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167475167;
        // ---------- Original Method ----------
        //return doOutput;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.537 -0400", hash_original_method = "C717C195610527A15AE106EB78FD0F84", hash_generated_method = "9147255396F1BA9C697DEF617E281C4C")
    public long getExpiration() {
        long var1415B379E36DC2CC995ABF21A9A46751_1399924883 = (getHeaderFieldDate("Expires", 0));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2146437997 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2146437997;
        // ---------- Original Method ----------
        //return getHeaderFieldDate("Expires", 0);
    }

    
        public static FileNameMap getFileNameMap() {
        synchronized (URLConnection.class) {
            if (fileNameMap == null) {
                fileNameMap = new DefaultFileNameMap();
            }
            return fileNameMap;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.538 -0400", hash_original_method = "4AACA905FA1278AAB35ED38439896081", hash_generated_method = "1C35AF37528D27CF6FE3F395F0882273")
    public String getHeaderField(int pos) {
        String varB4EAC82CA7396A68D541C85D26508E83_1642975167 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1642975167 = null;
        addTaint(pos);
        varB4EAC82CA7396A68D541C85D26508E83_1642975167.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1642975167;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.542 -0400", hash_original_method = "C458EE5373FC7B6169E37A6DC44512AF", hash_generated_method = "731DE075E8930B5EAEFCCA8CE2AB05FA")
    public Map<String, List<String>> getHeaderFields() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1469419113 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1469419113 = Collections.emptyMap();
        varB4EAC82CA7396A68D541C85D26508E83_1469419113.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1469419113;
        // ---------- Original Method ----------
        //return Collections.emptyMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.554 -0400", hash_original_method = "04A4D958E6B53818E212E56DBBF1EB38", hash_generated_method = "28C735FB5FD28D2C618BDCBE427DD0A5")
    public Map<String, List<String>> getRequestProperties() {
        Map<String, List<String>> varB4EAC82CA7396A68D541C85D26508E83_1539539443 = null; //Variable for return #1
        checkNotConnected();
        varB4EAC82CA7396A68D541C85D26508E83_1539539443 = Collections.emptyMap();
        varB4EAC82CA7396A68D541C85D26508E83_1539539443.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1539539443;
        // ---------- Original Method ----------
        //checkNotConnected();
        //return Collections.emptyMap();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.554 -0400", hash_original_method = "B91416BA99E534CF967424CBFE2F2ACE", hash_generated_method = "4F5A9EDC3D5F7D6029632FEB7F4612A2")
    private void checkNotConnected() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already connected");
        } //End block
        // ---------- Original Method ----------
        //if (connected) {
            //throw new IllegalStateException("Already connected");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.555 -0400", hash_original_method = "AA90A2DB0C71826C83D2E27C5299DE6D", hash_generated_method = "F4F7374052650865CBA5061AAF652850")
    public void addRequestProperty(String field, String newValue) {
        checkNotConnected();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("field == null");
        } //End block
        addTaint(field.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //checkNotConnected();
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.555 -0400", hash_original_method = "565CBD8C4BDCB5C201FDE1F2CB76B55D", hash_generated_method = "D4C037C98EE6604A78C93F1D45A29DCD")
    public String getHeaderField(String key) {
        String varB4EAC82CA7396A68D541C85D26508E83_214140323 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_214140323 = null;
        addTaint(key.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_214140323.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_214140323;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.556 -0400", hash_original_method = "3BD57BE7E93B8CCFBCD5DB800D789765", hash_generated_method = "A1C93C1F7880F2977916A0C203724CD3")
    @SuppressWarnings("deprecation")
    public long getHeaderFieldDate(String field, long defaultValue) {
        String date;
        date = getHeaderField(field);
        try 
        {
            long var8BFDC426572870BCA644EAC70995F0E4_2027009367 = (Date.parse(date));
        } //End block
        catch (Exception e)
        { }
        addTaint(field.getTaint());
        addTaint(defaultValue);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_949254687 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_949254687;
        // ---------- Original Method ----------
        //String date = getHeaderField(field);
        //if (date == null) {
            //return defaultValue;
        //}
        //try {
            //return Date.parse(date); 
        //} catch (Exception e) {
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.556 -0400", hash_original_method = "13117EC346BE33DF62C37EDAC186E83F", hash_generated_method = "C7572CC62749AFAC0126E445254AD429")
    public int getHeaderFieldInt(String field, int defaultValue) {
        try 
        {
            int var33497546D0AAA72A1193B3A095D3C22F_1333406472 = (Integer.parseInt(getHeaderField(field)));
        } //End block
        catch (NumberFormatException e)
        { }
        addTaint(field.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872010865 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_872010865;
        // ---------- Original Method ----------
        //try {
            //return Integer.parseInt(getHeaderField(field));
        //} catch (NumberFormatException e) {
            //return defaultValue;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.560 -0400", hash_original_method = "2E9FACF1BA93288E38DBB8CED1C2CF00", hash_generated_method = "DB782AC43F297B336D8207C3DDA40261")
    public String getHeaderFieldKey(int posn) {
        String varB4EAC82CA7396A68D541C85D26508E83_537459785 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_537459785 = null;
        addTaint(posn);
        varB4EAC82CA7396A68D541C85D26508E83_537459785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_537459785;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.560 -0400", hash_original_method = "3D630E318477F0341CC679CD7D029C3F", hash_generated_method = "08095DAC6456FC490D3073F064A8722E")
    public long getIfModifiedSince() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1215762805 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1215762805;
        // ---------- Original Method ----------
        //return ifModifiedSince;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.572 -0400", hash_original_method = "AC7495DD6573AA12A9CB49C509EE6FD0", hash_generated_method = "B4DD25B948592E76441D8932C4949434")
    public InputStream getInputStream() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnknownServiceException("Does not support writing to the input stream");
        // ---------- Original Method ----------
        //throw new UnknownServiceException("Does not support writing to the input stream");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.572 -0400", hash_original_method = "1B346D840CFCEDE13531D2A642CD424D", hash_generated_method = "A9C1F0CB06448524584E459F18EA60EE")
    public long getLastModified() {
        long var78957E0DC07228E898FDC47AF0225433_869313048 = (lastModified = getHeaderFieldDate("Last-Modified", 0));
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2145551638 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2145551638;
        // ---------- Original Method ----------
        //if (lastModified != -1) {
            //return lastModified;
        //}
        //return lastModified = getHeaderFieldDate("Last-Modified", 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.573 -0400", hash_original_method = "F613A2AA87619B352A0F7C7CAB39D3F5", hash_generated_method = "0556F9662A48DD9832C3443105C49744")
    public OutputStream getOutputStream() throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnknownServiceException("Does not support writing to the output stream");
        // ---------- Original Method ----------
        //throw new UnknownServiceException("Does not support writing to the output stream");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.573 -0400", hash_original_method = "0312DFF81C6978A2908F9B8EFDA3EFD4", hash_generated_method = "A3ED80D8904FC5815C50C860522BCFFD")
    public java.security.Permission getPermission() throws IOException {
        java.security.Permission varB4EAC82CA7396A68D541C85D26508E83_1226360157 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1226360157 = new java.security.AllPermission();
        varB4EAC82CA7396A68D541C85D26508E83_1226360157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1226360157;
        // ---------- Original Method ----------
        //return new java.security.AllPermission();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.574 -0400", hash_original_method = "9BF81D9E57E4C63EDA2E82E6CB1EEED2", hash_generated_method = "67FA47D7C73704D0D9685F0F6B8321E3")
    public String getRequestProperty(String field) {
        String varB4EAC82CA7396A68D541C85D26508E83_1216389622 = null; //Variable for return #1
        checkNotConnected();
        varB4EAC82CA7396A68D541C85D26508E83_1216389622 = null;
        addTaint(field.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1216389622.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1216389622;
        // ---------- Original Method ----------
        //checkNotConnected();
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.575 -0400", hash_original_method = "2F8DA67F8DE7FED0345BBAE8C82F68E5", hash_generated_method = "895F8C41C48CB38BEAE36961EF27DCE1")
    public URL getURL() {
        URL varB4EAC82CA7396A68D541C85D26508E83_320214152 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_320214152 = url;
        varB4EAC82CA7396A68D541C85D26508E83_320214152.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_320214152;
        // ---------- Original Method ----------
        //return url;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.579 -0400", hash_original_method = "2F69889B76EEFF99FBB9977BF19C64FC", hash_generated_method = "E27C288E92A8A7D387C42368583AA5C2")
    public boolean getUseCaches() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1729942067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1729942067;
        // ---------- Original Method ----------
        //return useCaches;
    }

    
        public static String guessContentTypeFromName(String url) {
        return getFileNameMap().getContentTypeFor(url);
    }

    
        public static String guessContentTypeFromStream(InputStream is) throws IOException {
        if (!is.markSupported()) {
            return null;
        }
        is.mark(64);
        byte[] bytes = new byte[64];
        int length = is.read(bytes);
        is.reset();
        if (length == -1) {
            return null;
        }
        String encoding = "US-ASCII";
        int start = 0;
        if (length > 1) {
            if ((bytes[0] == (byte) 0xFF) && (bytes[1] == (byte) 0xFE)) {
                encoding = "UTF-16LE";
                start = 2;
                length -= length & 1;
            }
            if ((bytes[0] == (byte) 0xFE) && (bytes[1] == (byte) 0xFF)) {
                encoding = "UTF-16BE";
                start = 2;
                length -= length & 1;
            }
            if (length > 2) {
                if ((bytes[0] == (byte) 0xEF) && (bytes[1] == (byte) 0xBB)
                        && (bytes[2] == (byte) 0xBF)) {
                    encoding = "UTF-8";
                    start = 3;
                }
                if (length > 3) {
                    if ((bytes[0] == (byte) 0x00) && (bytes[1] == (byte) 0x00)
                            && (bytes[2] == (byte) 0xFE)
                            && (bytes[3] == (byte) 0xFF)) {
                        encoding = "UTF-32BE";
                        start = 4;
                        length -= length & 3;
                    }
                    if ((bytes[0] == (byte) 0xFF) && (bytes[1] == (byte) 0xFE)
                            && (bytes[2] == (byte) 0x00)
                            && (bytes[3] == (byte) 0x00)) {
                        encoding = "UTF-32LE";
                        start = 4;
                        length -= length & 3;
                    }
                }
            }
        }
        String header = new String(bytes, start, length - start, encoding);
        if (header.startsWith("PK")) {
            return "application/zip";
        }
        if (header.startsWith("GI")) {
            return "image/gif";
        }
        String textHeader = header.trim().toUpperCase(Locale.US);
        if (textHeader.startsWith("<!DOCTYPE HTML") ||
                textHeader.startsWith("<HTML") ||
                textHeader.startsWith("<HEAD") ||
                textHeader.startsWith("<BODY") ||
                textHeader.startsWith("<HEAD")) {
            return "text/html";
        }
        if (textHeader.startsWith("<?XML")) {
            return "application/xml";
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.588 -0400", hash_original_method = "8088F9069DED191ECB9FB0409A3793EB", hash_generated_method = "DAB1B49B336EDEBC60674FB4F7B0A3E4")
    private String parseTypeString(String typeString) {
        String varB4EAC82CA7396A68D541C85D26508E83_440663835 = null; //Variable for return #1
        StringBuilder result;
        result = new StringBuilder(typeString);
        {
            int i;
            i = 0;
            boolean varAE3E8ABB93CE5B757876CEF937C2290A_1219465253 = (i < result.length());
            {
                char c;
                c = result.charAt(i);
                {
                    boolean var4FF1CE883340B394420C9CDB4FF9AF09_848648127 = (!(Character.isLetter(c) || Character.isDigit(c) || c == '.'));
                    {
                        result.setCharAt(i, '_');
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_440663835 = result.toString();
        addTaint(typeString.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_440663835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_440663835;
        // ---------- Original Method ----------
        //StringBuilder result = new StringBuilder(typeString);
        //for (int i = 0; i < result.length(); i++) {
            //char c = result.charAt(i);
            //if (!(Character.isLetter(c) || Character.isDigit(c) || c == '.')) {
                //result.setCharAt(i, '_');
            //}
        //}
        //return result.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.597 -0400", hash_original_method = "701213F9DAF865C1E161CA61CF705A45", hash_generated_method = "408F9F458C8E55460089B8BE6916EAA4")
    public void setAllowUserInteraction(boolean newValue) {
        checkNotConnected();
        this.allowUserInteraction = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.allowUserInteraction = newValue;
    }

    
        public static synchronized void setContentHandlerFactory(ContentHandlerFactory contentFactory) {
        if (contentHandlerFactory != null) {
            throw new Error("Factory already set");
        }
        contentHandlerFactory = contentFactory;
    }

    
        public static void setDefaultAllowUserInteraction(boolean allows) {
        defaultAllowUserInteraction = allows;
    }

    
        @Deprecated
    public static void setDefaultRequestProperty(String field, String value) {
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.598 -0400", hash_original_method = "850171EE0F333E1246D13E7B06ED7B4A", hash_generated_method = "451885C4EADF39859E8E5B4EC3B3696F")
    public void setDefaultUseCaches(boolean newValue) {
        defaultUseCaches = newValue;
        addTaint(newValue);
        // ---------- Original Method ----------
        //defaultUseCaches = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.598 -0400", hash_original_method = "3A49AB6E406CA8641E1DA3C376F73D42", hash_generated_method = "5479128F7387075B4F54BB3064B9DD25")
    public void setDoInput(boolean newValue) {
        checkNotConnected();
        this.doInput = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.doInput = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.598 -0400", hash_original_method = "F9A1D9CFB149787BC9250701CAC2EC3A", hash_generated_method = "C87FEF41C96B6A34E93E22638F84D18D")
    public void setDoOutput(boolean newValue) {
        checkNotConnected();
        this.doOutput = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.doOutput = newValue;
    }

    
        public static void setFileNameMap(FileNameMap map) {
        synchronized (URLConnection.class) {
            fileNameMap = map;
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.599 -0400", hash_original_method = "6F8DD71404577B87171F4310ACFD9CB3", hash_generated_method = "3C3BFEEA68FC926E1FD28F2EDF6381A6")
    public void setIfModifiedSince(long newValue) {
        checkNotConnected();
        this.ifModifiedSince = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.ifModifiedSince = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.601 -0400", hash_original_method = "EB8A856B35FAF51399B9B389D895E434", hash_generated_method = "05B28FDBB21B4AD548D6813AD63E3271")
    public void setRequestProperty(String field, String newValue) {
        checkNotConnected();
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("field == null");
        } //End block
        addTaint(field.getTaint());
        addTaint(newValue.getTaint());
        // ---------- Original Method ----------
        //checkNotConnected();
        //if (field == null) {
            //throw new NullPointerException("field == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.674 -0400", hash_original_method = "36A4E65C2F0D12499DC505123F0CC423", hash_generated_method = "2C4942B39DE1BD013B5FC65E487DC4CE")
    public void setUseCaches(boolean newValue) {
        checkNotConnected();
        this.useCaches = newValue;
        // ---------- Original Method ----------
        //checkNotConnected();
        //this.useCaches = newValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.675 -0400", hash_original_method = "6A558E4FD6643B6A2C9B278FD394A062", hash_generated_method = "32DF4A8A5491BD590B10F02A7A732D07")
    public void setConnectTimeout(int timeout) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } //End block
        this.connectTimeout = timeout;
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //this.connectTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.675 -0400", hash_original_method = "70B18BFD6BA7B76980125453BE48C7D1", hash_generated_method = "51A36FDF03BE9CFC347439AA411E13A5")
    public int getConnectTimeout() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061589033 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1061589033;
        // ---------- Original Method ----------
        //return connectTimeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.676 -0400", hash_original_method = "AFADA452D3B07139A9E1C4690AAC11B3", hash_generated_method = "2B0D8BA43D55E79E9168A8C4C5251321")
    public void setReadTimeout(int timeout) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("timeout < 0");
        } //End block
        this.readTimeout = timeout;
        // ---------- Original Method ----------
        //if (timeout < 0) {
            //throw new IllegalArgumentException("timeout < 0");
        //}
        //this.readTimeout = timeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.676 -0400", hash_original_method = "D3F0467D6BAB1E0CB8F37756E837EDFD", hash_generated_method = "EBBAC0299AFFA3DFBA3EC2CC065C31C9")
    public int getReadTimeout() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869203625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1869203625;
        // ---------- Original Method ----------
        //return readTimeout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.677 -0400", hash_original_method = "C85D603FFD624A90EAB88172CE67727C", hash_generated_method = "57552A4E5467C0B8876E58B69A096BBF")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1668741307 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1668741307 = getClass().getName() + ":" + url.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1668741307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1668741307;
        // ---------- Original Method ----------
        //return getClass().getName() + ":" + url.toString();
    }

    
    static class DefaultContentHandler extends java.net.ContentHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.677 -0400", hash_original_method = "D9C7FF4AC457B32D0DB70E56925850DE", hash_generated_method = "D9C7FF4AC457B32D0DB70E56925850DE")
        public DefaultContentHandler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.677 -0400", hash_original_method = "AE84E807F7FC8D1C4CC894407353562A", hash_generated_method = "86A0A7E93721D4F950BD80C2C29C806A")
        @Override
        public Object getContent(URLConnection u) throws IOException {
            Object varB4EAC82CA7396A68D541C85D26508E83_667678990 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_667678990 = u.getInputStream();
            addTaint(u.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_667678990.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_667678990;
            // ---------- Original Method ----------
            //return u.getInputStream();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.677 -0400", hash_original_field = "2EF9D74EDA056159EF28D8BEDB8E2029", hash_generated_field = "1A52F999A308188068C76D38BA5615EF")

    private static boolean defaultAllowUserInteraction;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.677 -0400", hash_original_field = "BDA43DE9887FC5B4AE2773879B6DC47D", hash_generated_field = "0745D91F58FAC663266DAFADF4C39A8B")

    private static boolean defaultUseCaches = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.677 -0400", hash_original_field = "5374745A15E146F670B4E156900FC280", hash_generated_field = "D42218022B7E3DD64D7C74B810FC8B3D")

    private static ContentHandlerFactory contentHandlerFactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.677 -0400", hash_original_field = "0DED07A99DDC83F010D0232F904AB185", hash_generated_field = "B35CCA371471EC5184868CE09D94475C")

    static Hashtable<String, Object> contentHandlers = new Hashtable<String, Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:44.678 -0400", hash_original_field = "1F40A211288BCB20F811E6D3918ADD04", hash_generated_field = "E3E7D988476B274A9DF2166D8A8B4DFA")

    private static FileNameMap fileNameMap;
}

