



package javax.xml.validation;

import java.io.File;
import java.net.URL;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;


import droidsafe.annotations.*;

public abstract class SchemaFactory {

    
    protected SchemaFactory() {
    }

    
    @DSModeled(DSC.SAFE)
    public static SchemaFactory newInstance(String schemaLanguage) {
        ClassLoader cl;
        cl = Thread.currentThread().getContextClassLoader();

        if (cl == null) {
            
            
            cl = SchemaFactory.class.getClassLoader();
        }

        SchemaFactory f = new SchemaFactoryFinder(cl).newFactory(schemaLanguage);
        if (f == null) {
            throw new IllegalArgumentException(schemaLanguage);
        }
        return f;
    }

    
    public static SchemaFactory newInstance(String schemaLanguage, String factoryClassName,
            ClassLoader classLoader) {
        if (schemaLanguage == null || factoryClassName == null) {
            throw new NullPointerException("schemaLanguage == null || factoryClassName == null");
        }
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            Class<?> type = classLoader != null
                    ? classLoader.loadClass(factoryClassName)
                    : Class.forName(factoryClassName);
            SchemaFactory result = (SchemaFactory) type.newInstance();
            if (result == null || !result.isSchemaLanguageSupported(schemaLanguage)) {
                throw new IllegalArgumentException(schemaLanguage);
            }
            return result;
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }

    
    public abstract boolean isSchemaLanguageSupported(String schemaLanguage);

    
    @DSModeled(DSC.SAFE)
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {

        if (name == null) {
            throw new NullPointerException("the name parameter is null");
        }
        throw new SAXNotRecognizedException(name);
    }

    
    @DSModeled(DSC.SAFE)
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (name == null) {
            throw new NullPointerException("the name parameter is null");
        }
        throw new SAXNotRecognizedException(name);
    }

    
    @DSModeled(DSC.SAFE)
    public void setProperty(String name, Object object) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (name == null) {
            throw new NullPointerException("the name parameter is null");
        }
        throw new SAXNotRecognizedException(name);
    }

    
    @DSModeled(DSC.SAFE)
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        if (name == null) {
            throw new NullPointerException("the name parameter is null");
        }
        throw new SAXNotRecognizedException(name);
    }

    
    public abstract void setErrorHandler(ErrorHandler errorHandler);

    
    public abstract ErrorHandler getErrorHandler();

    
    public abstract void setResourceResolver(LSResourceResolver resourceResolver);

    
    public abstract LSResourceResolver getResourceResolver();

    
    @DSModeled(DSC.SAFE)
    public Schema newSchema(Source schema) throws SAXException {
        return newSchema(new Source[]{schema});
    }

    
    @DSModeled(DSC.SAFE)
    public Schema newSchema(File schema) throws SAXException {
        return newSchema(new StreamSource(schema));
    }

    
    public Schema newSchema(URL schema) throws SAXException {
        return newSchema(new StreamSource(schema.toExternalForm()));
    }

    
    public abstract Schema newSchema(Source[] schemas) throws SAXException;

    
    public abstract Schema newSchema() throws SAXException;
}
