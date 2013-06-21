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
    private boolean validating = false;
    private boolean namespaceAware = false;
    private boolean whitespace = false;
    private boolean expandEntityRef = true;
    private boolean ignoreComments = false;
    private boolean coalescing = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.378 -0400", hash_original_method = "49D4E4D47C8CF413B98AC9B42DF82DC4", hash_generated_method = "E213E77723289B6F2040F5B0C8C9D45D")
    @DSModeled(DSC.SAFE)
    protected DocumentBuilderFactory() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.379 -0400", hash_original_method = "6A0A7EFC1E675DD90B546C7A4C9B47EE", hash_generated_method = "E7B1C42A5C59739553095F0E51B3310E")
    @DSModeled(DSC.SAFE)
    public void setNamespaceAware(boolean awareness) {
        dsTaint.addTaint(awareness);
        // ---------- Original Method ----------
        //this.namespaceAware = awareness;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.379 -0400", hash_original_method = "55B714FD0DC17953A4D0F6C9203268D6", hash_generated_method = "52A5C7D7FC6D896BC2AE7626270DDDA7")
    @DSModeled(DSC.SAFE)
    public void setValidating(boolean validating) {
        dsTaint.addTaint(validating);
        // ---------- Original Method ----------
        //this.validating = validating;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.379 -0400", hash_original_method = "247761D9B12D676DDB4CAC3CDF600276", hash_generated_method = "585376A440D8C33B97A4F23839BD1DFC")
    @DSModeled(DSC.SAFE)
    public void setIgnoringElementContentWhitespace(boolean whitespace) {
        dsTaint.addTaint(whitespace);
        // ---------- Original Method ----------
        //this.whitespace = whitespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.380 -0400", hash_original_method = "671BE4D371F0581E5B97389628916E7F", hash_generated_method = "98D69D839B4F09DAFE66DED07B82E44E")
    @DSModeled(DSC.SAFE)
    public void setExpandEntityReferences(boolean expandEntityRef) {
        dsTaint.addTaint(expandEntityRef);
        // ---------- Original Method ----------
        //this.expandEntityRef = expandEntityRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.380 -0400", hash_original_method = "1FD1C35E28B34CBCC42CB14E4FC91862", hash_generated_method = "2EF386193D5A21B5693C38E3EE3080D3")
    @DSModeled(DSC.SAFE)
    public void setIgnoringComments(boolean ignoreComments) {
        dsTaint.addTaint(ignoreComments);
        // ---------- Original Method ----------
        //this.ignoreComments = ignoreComments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.380 -0400", hash_original_method = "221C7C3610A4998C18C0CAC31215B4A1", hash_generated_method = "4A603A1D8ABE3A14D915AE6A97BC0520")
    @DSModeled(DSC.SAFE)
    public void setCoalescing(boolean coalescing) {
        dsTaint.addTaint(coalescing);
        // ---------- Original Method ----------
        //this.coalescing = coalescing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.380 -0400", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "16A2A634920554F3B41241FA15489C48")
    @DSModeled(DSC.SAFE)
    public boolean isNamespaceAware() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return namespaceAware;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.380 -0400", hash_original_method = "758653C6211E875508A2CE7C0CB7DC93", hash_generated_method = "B4E362472E7B74E7BE281A039D9E5E2A")
    @DSModeled(DSC.SAFE)
    public boolean isValidating() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return validating;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.381 -0400", hash_original_method = "4E56F5A7CCC6378B3CF8D112F8B1AB79", hash_generated_method = "356A155CF3ACE9DFE5AB8634436AB1CC")
    @DSModeled(DSC.SAFE)
    public boolean isIgnoringElementContentWhitespace() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return whitespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.381 -0400", hash_original_method = "FE5A53A39E38E86520120F61AA406DC2", hash_generated_method = "A344F8FECDCE257E6256807AE9E91C5F")
    @DSModeled(DSC.SAFE)
    public boolean isExpandEntityReferences() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return expandEntityRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.381 -0400", hash_original_method = "472A3B5EC6A2D01FA4DE3A7E2B7C3115", hash_generated_method = "706B6497884F602AA8200D489B341F23")
    @DSModeled(DSC.SAFE)
    public boolean isIgnoringComments() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ignoreComments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.381 -0400", hash_original_method = "0B8DEAAC66A552BA34931CFF16BDD152", hash_generated_method = "2857E4EC36A294BBAE288A8265BF0AB3")
    @DSModeled(DSC.SAFE)
    public boolean isCoalescing() {
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.382 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "E8D1CE38DA0AC2EFA5098B140E0195FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Schema getSchema() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        return (Schema)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
            //"This parser does not support specification \""
            //+ this.getClass().getPackage().getSpecificationTitle()
            //+ "\" version \""
            //+ this.getClass().getPackage().getSpecificationVersion()
            //+ "\""
            //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.382 -0400", hash_original_method = "15A4A50F8E3104FAC414471F9078A720", hash_generated_method = "C8C1190BD90C64A4446D6E8D8065F79F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSchema(Schema schema) {
        dsTaint.addTaint(schema.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.382 -0400", hash_original_method = "7123F2F991682C288B1EB84DFD3ADE3C", hash_generated_method = "537CB619F0F430CD631688571DED8711")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setXIncludeAware(final boolean state) {
        dsTaint.addTaint(state);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.383 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "17F9FF8CAAF857E33351A0E36A06B189")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isXIncludeAware() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException(
            "This parser does not support specification \""
            + this.getClass().getPackage().getSpecificationTitle()
            + "\" version \""
            + this.getClass().getPackage().getSpecificationVersion()
            + "\""
            );
        return dsTaint.getTaintBoolean();
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

