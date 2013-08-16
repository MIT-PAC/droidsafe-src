package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.xml.validation.Schema;

import org.apache.harmony.xml.parsers.SAXParserFactoryImpl;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;






public abstract class SAXParserFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.983 -0400", hash_original_field = "45184E952A59E6FFF7C397E5631D95CE", hash_generated_field = "5A58AB4C6A46398C035EC9B72D104783")

    private boolean validating = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.983 -0400", hash_original_field = "E90E3D83B40658AD73037972FF276AAF", hash_generated_field = "5485D5F0CEEDFBCE5E10558A9D6EF469")

    private boolean namespaceAware = false;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.983 -0400", hash_original_method = "5B4969E70C1A248827CF399EDBDC2A24", hash_generated_method = "75917AE4861FBF4B1ABCA31AADA8B4D1")
    protected  SAXParserFactory() {
        // ---------- Original Method ----------
    }

    
    public static SAXParserFactory newInstance() {
        return new SAXParserFactoryImpl();
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.SAFE)
    public abstract SAXParser newSAXParser()
        throws ParserConfigurationException, SAXException;

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.985 -0400", hash_original_method = "6A0A7EFC1E675DD90B546C7A4C9B47EE", hash_generated_method = "98A9EE2B3964663F64D1613FA6F20ABE")
    public void setNamespaceAware(boolean awareness) {
        this.namespaceAware = awareness;
        // ---------- Original Method ----------
        //this.namespaceAware = awareness;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.985 -0400", hash_original_method = "55B714FD0DC17953A4D0F6C9203268D6", hash_generated_method = "599F2B5B61FB8B7D3C2CD0C1E871774F")
    public void setValidating(boolean validating) {
        this.validating = validating;
        // ---------- Original Method ----------
        //this.validating = validating;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.986 -0400", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "ECAAFD511888FA68B669CD84B0AB974E")
    public boolean isNamespaceAware() {
        boolean varCEC00E48144CD3C5B0000055F3D7FF26_294405468 = (namespaceAware);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698475541 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_698475541;
        // ---------- Original Method ----------
        //return namespaceAware;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.986 -0400", hash_original_method = "758653C6211E875508A2CE7C0CB7DC93", hash_generated_method = "446E62B83948075B8098CE642B6DF500")
    public boolean isValidating() {
        boolean varD77932958A49E1F50F11C2D742FE1493_1507969008 = (validating);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_12962241 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_12962241;
        // ---------- Original Method ----------
        //return validating;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract void setFeature(String name, boolean value)
        throws ParserConfigurationException, SAXNotRecognizedException,
                SAXNotSupportedException;

    
    @DSModeled(DSC.SAFE)
    public abstract boolean getFeature(String name)
        throws ParserConfigurationException, SAXNotRecognizedException,
                SAXNotSupportedException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.987 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "C98628B2C8517B80BBF6049332733E5C")
    public Schema getSchema() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_165710345 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_165710345.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_165710345;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.988 -0400", hash_original_method = "15A4A50F8E3104FAC414471F9078A720", hash_generated_method = "4F63B10903306944292CC0DE6068D774")
    public void setSchema(Schema schema) {
        addTaint(schema.getTaint());
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_300470655 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_300470655.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_300470655;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.988 -0400", hash_original_method = "7123F2F991682C288B1EB84DFD3ADE3C", hash_generated_method = "2022F221659337AB9CD6D018F6DE8495")
    public void setXIncludeAware(final boolean state) {
        addTaint(state);
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_83989874 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_83989874.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_83989874;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:18.989 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "D92F1F035FE09C8106431728A82A02F0")
    public boolean isXIncludeAware() {
        UnsupportedOperationException varE9742D55AB47AEF31209978AAE994BE9_20481189 = new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        varE9742D55AB47AEF31209978AAE994BE9_20481189.addTaint(taint);
        throw varE9742D55AB47AEF31209978AAE994BE9_20481189;
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

