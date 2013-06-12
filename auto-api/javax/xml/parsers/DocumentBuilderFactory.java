package javax.xml.parsers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "49D4E4D47C8CF413B98AC9B42DF82DC4", hash_generated_method = "DC4AC2CAD97F168CC057948A5F58CB71")
    @DSModeled(DSC.SAFE)
    protected DocumentBuilderFactory() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "A299BC4F50290936C6E9B976A12D85C4", hash_generated_method = "D15BAD61CA174B8DB2E8A44B127117F7")
    public static DocumentBuilderFactory newInstance() {
        return new DocumentBuilderFactoryImpl();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "6649CD9FBDB8C0B42278B6629FF5EE88", hash_generated_method = "32793FC0050A658B1F408EF343F4BD71")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "6A0A7EFC1E675DD90B546C7A4C9B47EE", hash_generated_method = "C7C5DDE9199A1288B5BEBF72A0E9E4CD")
    @DSModeled(DSC.SAFE)
    public void setNamespaceAware(boolean awareness) {
        dsTaint.addTaint(awareness);
        // ---------- Original Method ----------
        //this.namespaceAware = awareness;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "55B714FD0DC17953A4D0F6C9203268D6", hash_generated_method = "3B4BA2852167216EFF6B8C92AFCA0147")
    @DSModeled(DSC.SAFE)
    public void setValidating(boolean validating) {
        dsTaint.addTaint(validating);
        // ---------- Original Method ----------
        //this.validating = validating;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "247761D9B12D676DDB4CAC3CDF600276", hash_generated_method = "70F9C2A96316C451020587CB362403BE")
    @DSModeled(DSC.SAFE)
    public void setIgnoringElementContentWhitespace(boolean whitespace) {
        dsTaint.addTaint(whitespace);
        // ---------- Original Method ----------
        //this.whitespace = whitespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "671BE4D371F0581E5B97389628916E7F", hash_generated_method = "9413296085C263F3F5812EE95B70B99B")
    @DSModeled(DSC.SAFE)
    public void setExpandEntityReferences(boolean expandEntityRef) {
        dsTaint.addTaint(expandEntityRef);
        // ---------- Original Method ----------
        //this.expandEntityRef = expandEntityRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "1FD1C35E28B34CBCC42CB14E4FC91862", hash_generated_method = "13013E09018A2A12AAB50E6A9F2E334F")
    @DSModeled(DSC.SAFE)
    public void setIgnoringComments(boolean ignoreComments) {
        dsTaint.addTaint(ignoreComments);
        // ---------- Original Method ----------
        //this.ignoreComments = ignoreComments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "221C7C3610A4998C18C0CAC31215B4A1", hash_generated_method = "5F67EB8D815C843622DB69B874507FDB")
    @DSModeled(DSC.SAFE)
    public void setCoalescing(boolean coalescing) {
        dsTaint.addTaint(coalescing);
        // ---------- Original Method ----------
        //this.coalescing = coalescing;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "550ADB90AA897C85DDC99A20E85473AF", hash_generated_method = "1C6CA375F4303027040F5DE02AA1E209")
    @DSModeled(DSC.SAFE)
    public boolean isNamespaceAware() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return namespaceAware;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "758653C6211E875508A2CE7C0CB7DC93", hash_generated_method = "85C69ED2ADF392DBFB4EE461C7D7132F")
    @DSModeled(DSC.SAFE)
    public boolean isValidating() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return validating;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "4E56F5A7CCC6378B3CF8D112F8B1AB79", hash_generated_method = "FEE297B3798CFD6342722D4841342DFD")
    @DSModeled(DSC.SAFE)
    public boolean isIgnoringElementContentWhitespace() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return whitespace;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "FE5A53A39E38E86520120F61AA406DC2", hash_generated_method = "C08EBF255018B256B66C112C735A09E5")
    @DSModeled(DSC.SAFE)
    public boolean isExpandEntityReferences() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return expandEntityRef;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "472A3B5EC6A2D01FA4DE3A7E2B7C3115", hash_generated_method = "5D45C0888061BA27414C9465C876085C")
    @DSModeled(DSC.SAFE)
    public boolean isIgnoringComments() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ignoreComments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "0B8DEAAC66A552BA34931CFF16BDD152", hash_generated_method = "7AD9BC8E0B47F678298952C60BB74811")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.594 -0400", hash_original_method = "0EC7A1CF3FE0EA75043A7D33C5A41123", hash_generated_method = "175DAC667A6680F762C43DB44CC1F188")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.595 -0400", hash_original_method = "15A4A50F8E3104FAC414471F9078A720", hash_generated_method = "4AD118E950AC954EB241213E4657CEA4")
    @DSModeled(DSC.SAFE)
    public void setSchema(Schema schema) {
        dsTaint.addTaint(schema.dsTaint);
        throw new UnsupportedOperationException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.595 -0400", hash_original_method = "7123F2F991682C288B1EB84DFD3ADE3C", hash_generated_method = "6F07804727A03876140F0D1AA359D0F2")
    @DSModeled(DSC.SAFE)
    public void setXIncludeAware(final boolean state) {
        dsTaint.addTaint(state);
        throw new UnsupportedOperationException(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.595 -0400", hash_original_method = "2D701854F0A16C5A4E7C38BB02DF4544", hash_generated_method = "309012FE5A9A0E5B29F1F0BC8392628A")
    @DSModeled(DSC.SAFE)
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


