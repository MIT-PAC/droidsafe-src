package javax.xml.parsers;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import javax.xml.validation.Schema;
import org.apache.harmony.xml.parsers.SAXParserFactoryImpl;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public abstract class SAXParserFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.874 -0400", hash_original_field = "45184E952A59E6FFF7C397E5631D95CE", hash_generated_field = "5A58AB4C6A46398C035EC9B72D104783")

    private boolean validating = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.874 -0400", hash_original_field = "E90E3D83B40658AD73037972FF276AAF", hash_generated_field = "5485D5F0CEEDFBCE5E10558A9D6EF469")

    private boolean namespaceAware = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.875 -0400", hash_original_method = "5B4969E70C1A248827CF399EDBDC2A24", hash_generated_method = "75917AE4861FBF4B1ABCA31AADA8B4D1")
    protected  SAXParserFactory() {
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.876 -0400", hash_original_method = "6A0A7EFC1E675DD90B546C7A4C9B47EE", hash_generated_method = "98A9EE2B3964663F64D1613FA6F20ABE")
    public void setNamespaceAware(boolean awareness) {
        this.namespaceAware = awareness;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.876 -0400", hash_original_method = "55B714FD0DC17953A4D0F6C9203268D6", hash_generated_method = "599F2B5B61FB8B7D3C2CD0C1E871774F")
    public void setValidating(boolean validating) {
        this.validating = validating;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.876 -0400", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "AA828B3B426AFF6822788E39D7EDC931")
    public boolean isNamespaceAware() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545975173 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545975173;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.876 -0400", hash_original_method = "758653C6211E875508A2CE7C0CB7DC93", hash_generated_method = "C0213D29268180E2CF5BF79CAE59805C")
    public boolean isValidating() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1608512977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1608512977;
        
        
    }

    
    public abstract void setFeature(String name, boolean value)
        throws ParserConfigurationException, SAXNotRecognizedException,
                SAXNotSupportedException;

    
    public abstract boolean getFeature(String name)
        throws ParserConfigurationException, SAXNotRecognizedException,
                SAXNotSupportedException;

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.877 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "2E2EBD7A2D5464481CAA84ECE27CE0D0")
    public Schema getSchema() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        
        return (Schema)new Object();
        
        
            
            
            
            
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.878 -0400", hash_original_method = "15A4A50F8E3104FAC414471F9078A720", hash_generated_method = "10FDF01C45401D687ED9E46F9A9C2D8D")
    public void setSchema(Schema schema) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        addTaint(schema.getTaint());
        
        
            
            
            
            
            
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.878 -0400", hash_original_method = "7123F2F991682C288B1EB84DFD3ADE3C", hash_generated_method = "2625CF1B8381D94692F2467931A65FF1")
    public void setXIncludeAware(final boolean state) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        addTaint(state);
        
        
            
            
            
            
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.879 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "F68BE2E02EC1B4E011C10D56E615F28D")
    public boolean isXIncludeAware() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253117257 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_253117257;
        
        
            
            
            
            
            
            
    }

    
}

