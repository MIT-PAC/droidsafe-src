package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.xml.validation.Schema;
import org.apache.harmony.xml.parsers.SAXParserFactoryImpl;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public abstract class SAXParserFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.940 -0400", hash_original_field = "45184E952A59E6FFF7C397E5631D95CE", hash_generated_field = "5A58AB4C6A46398C035EC9B72D104783")

    private boolean validating = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.940 -0400", hash_original_field = "E90E3D83B40658AD73037972FF276AAF", hash_generated_field = "5485D5F0CEEDFBCE5E10558A9D6EF469")

    private boolean namespaceAware = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.941 -0400", hash_original_method = "5B4969E70C1A248827CF399EDBDC2A24", hash_generated_method = "75917AE4861FBF4B1ABCA31AADA8B4D1")
    protected  SAXParserFactory() {
        // ---------- Original Method ----------
    }

    
        public static SAXParserFactory newInstance() {
        return new SAXParserFactoryImpl();
    }

    
        public static SAXParserFactory newInstance(String factoryClassName,
            ClassLoader classLoader) {
        if (factoryClassName == null) {
            throw new FactoryConfigurationError("factoryClassName == null");
        }
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            Class<?> type = classLoader != null
                    ? classLoader.loadClass(factoryClassName)
                    : Class.forName(factoryClassName);
            return (SAXParserFactory) type.newInstance();
        } catch (ClassNotFoundException e) {
            throw new FactoryConfigurationError(e);
        } catch (InstantiationException e) {
            throw new FactoryConfigurationError(e);
        } catch (IllegalAccessException e) {
            throw new FactoryConfigurationError(e);
        }
    }

    
    public abstract SAXParser newSAXParser()
        throws ParserConfigurationException, SAXException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.942 -0400", hash_original_method = "6A0A7EFC1E675DD90B546C7A4C9B47EE", hash_generated_method = "98A9EE2B3964663F64D1613FA6F20ABE")
    public void setNamespaceAware(boolean awareness) {
        this.namespaceAware = awareness;
        // ---------- Original Method ----------
        //this.namespaceAware = awareness;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.942 -0400", hash_original_method = "55B714FD0DC17953A4D0F6C9203268D6", hash_generated_method = "599F2B5B61FB8B7D3C2CD0C1E871774F")
    public void setValidating(boolean validating) {
        this.validating = validating;
        // ---------- Original Method ----------
        //this.validating = validating;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.943 -0400", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "1738F29D8B029AC082EC7D0813C317CA")
    public boolean isNamespaceAware() {
        boolean varCEC00E48144CD3C5B0000055F3D7FF26_1074989591 = (namespaceAware);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852717888 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_852717888;
        // ---------- Original Method ----------
        //return namespaceAware;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.943 -0400", hash_original_method = "758653C6211E875508A2CE7C0CB7DC93", hash_generated_method = "13DBD16EEA4214BE5C4B7C889D509DE4")
    public boolean isValidating() {
        boolean varD77932958A49E1F50F11C2D742FE1493_1172906898 = (validating);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1990416437 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1990416437;
        // ---------- Original Method ----------
        //return validating;
    }

    
    public abstract void setFeature(String name, boolean value)
        throws ParserConfigurationException, SAXNotRecognizedException,
                SAXNotSupportedException;

    
    public abstract boolean getFeature(String name)
        throws ParserConfigurationException, SAXNotRecognizedException,
                SAXNotSupportedException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.947 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "52FF6A97B8DD9E43848CD46F3518D2FA")
    public Schema getSchema() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_122893165 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_122893165.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_122893165;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.947 -0400", hash_original_method = "15A4A50F8E3104FAC414471F9078A720", hash_generated_method = "62B638F469BB5708BC4C2B295C73FC18")
    public void setSchema(Schema schema) {
        addTaint(schema.getTaint());
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_1600531177 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_1600531177.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_1600531177;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.948 -0400", hash_original_method = "7123F2F991682C288B1EB84DFD3ADE3C", hash_generated_method = "CF8126D70DAF45DA58261BC6391F98D5")
    public void setXIncludeAware(final boolean state) {
        addTaint(state);
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_1817128589 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_1817128589.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_1817128589;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:20.948 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "2A9B37342BB0A0B0CEAFF56DD0E45AC5")
    public boolean isXIncludeAware() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_125822094 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_125822094.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_125822094;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
}

