package javax.xml.transform;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public abstract class TransformerFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.108 -0400", hash_original_method = "882398A945C9CF8F9D3ABF21E7DFDBFC", hash_generated_method = "2BC7FF716052BC1AB7666C5153E272F2")
    protected  TransformerFactory() {
        // ---------- Original Method ----------
    }

    
    public static TransformerFactory newInstance() throws TransformerFactoryConfigurationError {
        String className = "org.apache.xalan.processor.TransformerFactoryImpl";
        try {
            return (TransformerFactory) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new NoClassDefFoundError(className);
        }
    }

    
    @DSModeled(DSC.BAN)
    public static TransformerFactory newInstance(String factoryClassName, ClassLoader classLoader) throws TransformerFactoryConfigurationError {
        if (factoryClassName == null) {
            throw new TransformerFactoryConfigurationError("factoryClassName == null");
        }
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            Class<?> type = classLoader != null
                    ? classLoader.loadClass(factoryClassName)
                    : Class.forName(factoryClassName);
            return (TransformerFactory) type.newInstance();
        } catch (ClassNotFoundException e) {
            throw new TransformerFactoryConfigurationError(e);
        } catch (InstantiationException e) {
            throw new TransformerFactoryConfigurationError(e);
        } catch (IllegalAccessException e) {
            throw new TransformerFactoryConfigurationError(e);
        }
    }

    
    public abstract Transformer newTransformer(Source source)
        throws TransformerConfigurationException;

    
    public abstract Transformer newTransformer()
        throws TransformerConfigurationException;

    
    public abstract Templates newTemplates(Source source)
        throws TransformerConfigurationException;

    
    public abstract Source getAssociatedStylesheet(
        Source source,
        String media,
        String title,
        String charset)
        throws TransformerConfigurationException;

    
    public abstract void setURIResolver(URIResolver resolver);

    
    public abstract URIResolver getURIResolver();

    
    public abstract void setFeature(String name, boolean value)
        throws TransformerConfigurationException;

    
    public abstract boolean getFeature(String name);

    
    public abstract void setAttribute(String name, Object value);

    
    public abstract Object getAttribute(String name);

    
    public abstract void setErrorListener(ErrorListener listener);

    
    public abstract ErrorListener getErrorListener();

    
}

