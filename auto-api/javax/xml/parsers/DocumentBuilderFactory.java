package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.xml.validation.Schema;
import org.apache.harmony.xml.parsers.DocumentBuilderFactoryImpl;

public abstract class DocumentBuilderFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.674 -0400", hash_original_field = "45184E952A59E6FFF7C397E5631D95CE", hash_generated_field = "5A58AB4C6A46398C035EC9B72D104783")

    private boolean validating = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.674 -0400", hash_original_field = "E90E3D83B40658AD73037972FF276AAF", hash_generated_field = "5485D5F0CEEDFBCE5E10558A9D6EF469")

    private boolean namespaceAware = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.674 -0400", hash_original_field = "B9B67FAF8129C943DA5F32276FE772C7", hash_generated_field = "F5C170D2FDD05D4195A0F8E895734286")

    private boolean whitespace = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.674 -0400", hash_original_field = "AA113288F2F6D846B023160EF673F218", hash_generated_field = "B6E7B075644E24680869851F5AD9F7FE")

    private boolean expandEntityRef = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.674 -0400", hash_original_field = "DD46CBCC0B299D54E05628BF88B251B7", hash_generated_field = "6AADFB48B77E0B566BCCB3729E527FEE")

    private boolean ignoreComments = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.674 -0400", hash_original_field = "5E734D9685EF3E3330B3B29B1A16F432", hash_generated_field = "D86CB026082A8D0C540D599E27C2D71B")

    private boolean coalescing = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.674 -0400", hash_original_method = "49D4E4D47C8CF413B98AC9B42DF82DC4", hash_generated_method = "E213E77723289B6F2040F5B0C8C9D45D")
    protected  DocumentBuilderFactory() {
        // ---------- Original Method ----------
    }

    
    public static DocumentBuilderFactory newInstance() {
        return new DocumentBuilderFactoryImpl();
    }

    
    public static DocumentBuilderFactory newInstance(String factoryClassName,
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
            return (DocumentBuilderFactory) type.newInstance();
        } catch (ClassNotFoundException e) {
            throw new FactoryConfigurationError(e);
        } catch (InstantiationException e) {
            throw new FactoryConfigurationError(e);
        } catch (IllegalAccessException e) {
            throw new FactoryConfigurationError(e);
        }
    }

    
    public abstract DocumentBuilder newDocumentBuilder()
        throws ParserConfigurationException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.675 -0400", hash_original_method = "6A0A7EFC1E675DD90B546C7A4C9B47EE", hash_generated_method = "98A9EE2B3964663F64D1613FA6F20ABE")
    public void setNamespaceAware(boolean awareness) {
        this.namespaceAware = awareness;
        // ---------- Original Method ----------
        //this.namespaceAware = awareness;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.675 -0400", hash_original_method = "55B714FD0DC17953A4D0F6C9203268D6", hash_generated_method = "599F2B5B61FB8B7D3C2CD0C1E871774F")
    public void setValidating(boolean validating) {
        this.validating = validating;
        // ---------- Original Method ----------
        //this.validating = validating;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.675 -0400", hash_original_method = "247761D9B12D676DDB4CAC3CDF600276", hash_generated_method = "26ED015FC946531D730ED6E76280B99E")
    public void setIgnoringElementContentWhitespace(boolean whitespace) {
        this.whitespace = whitespace;
        // ---------- Original Method ----------
        //this.whitespace = whitespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.675 -0400", hash_original_method = "671BE4D371F0581E5B97389628916E7F", hash_generated_method = "3FE510027D542AC62DDDAC498BFA12AF")
    public void setExpandEntityReferences(boolean expandEntityRef) {
        this.expandEntityRef = expandEntityRef;
        // ---------- Original Method ----------
        //this.expandEntityRef = expandEntityRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.676 -0400", hash_original_method = "1FD1C35E28B34CBCC42CB14E4FC91862", hash_generated_method = "7FB77D001D57BE7E94A5C374DB0B5CC1")
    public void setIgnoringComments(boolean ignoreComments) {
        this.ignoreComments = ignoreComments;
        // ---------- Original Method ----------
        //this.ignoreComments = ignoreComments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.676 -0400", hash_original_method = "221C7C3610A4998C18C0CAC31215B4A1", hash_generated_method = "529C53B32FE70E25B8EF95B49C7157F7")
    public void setCoalescing(boolean coalescing) {
        this.coalescing = coalescing;
        // ---------- Original Method ----------
        //this.coalescing = coalescing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.676 -0400", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "88CDB59D67E75C2C0E5EC562DCFC5DC6")
    public boolean isNamespaceAware() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_399184536 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_399184536;
        // ---------- Original Method ----------
        //return namespaceAware;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.676 -0400", hash_original_method = "758653C6211E875508A2CE7C0CB7DC93", hash_generated_method = "E0DE79F264978CCC4F0BE784B4BBB073")
    public boolean isValidating() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_691940422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_691940422;
        // ---------- Original Method ----------
        //return validating;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.676 -0400", hash_original_method = "4E56F5A7CCC6378B3CF8D112F8B1AB79", hash_generated_method = "FE72BCA1063E5A5BC6B0BE78398260DE")
    public boolean isIgnoringElementContentWhitespace() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1245921884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1245921884;
        // ---------- Original Method ----------
        //return whitespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.676 -0400", hash_original_method = "FE5A53A39E38E86520120F61AA406DC2", hash_generated_method = "02042E56C63D252761BBBE3ABABB3B46")
    public boolean isExpandEntityReferences() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_367197954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_367197954;
        // ---------- Original Method ----------
        //return expandEntityRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.677 -0400", hash_original_method = "472A3B5EC6A2D01FA4DE3A7E2B7C3115", hash_generated_method = "1D0160C274207CA6EA650A51299F8C94")
    public boolean isIgnoringComments() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1054445497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1054445497;
        // ---------- Original Method ----------
        //return ignoreComments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.677 -0400", hash_original_method = "0B8DEAAC66A552BA34931CFF16BDD152", hash_generated_method = "69318DBA832AC54FE8B46601BD18283F")
    public boolean isCoalescing() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1516452658 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1516452658;
        // ---------- Original Method ----------
        //return coalescing;
    }

    
    public abstract void setAttribute(String name, Object value)
                throws IllegalArgumentException;

    
    public abstract Object getAttribute(String name)
                throws IllegalArgumentException;

    
    public abstract void setFeature(String name, boolean value)
        throws ParserConfigurationException;

    
    public abstract boolean getFeature(String name)
        throws ParserConfigurationException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.678 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "2E2EBD7A2D5464481CAA84ECE27CE0D0")
    public Schema getSchema() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.679 -0400", hash_original_method = "15A4A50F8E3104FAC414471F9078A720", hash_generated_method = "10FDF01C45401D687ED9E46F9A9C2D8D")
    public void setSchema(Schema schema) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        addTaint(schema.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.679 -0400", hash_original_method = "7123F2F991682C288B1EB84DFD3ADE3C", hash_generated_method = "2625CF1B8381D94692F2467931A65FF1")
    public void setXIncludeAware(final boolean state) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        addTaint(state);
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.679 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "294EE9B6A2E000B455BD918C677DF216")
    public boolean isXIncludeAware() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2080334026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2080334026;
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

