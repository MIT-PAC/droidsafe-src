


package javax.xml.validation;

import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import droidsafe.annotations.*;


public abstract class ValidatorHandler implements ContentHandler {

    
    protected ValidatorHandler() {
    }

    
    public abstract void setContentHandler(ContentHandler receiver);

    
    public abstract ContentHandler getContentHandler();

    
    public abstract void setErrorHandler(ErrorHandler errorHandler);

    
    public abstract ErrorHandler getErrorHandler();

    
    public abstract void setResourceResolver(LSResourceResolver resourceResolver);

    
    public abstract LSResourceResolver getResourceResolver();

    
    public abstract TypeInfoProvider getTypeInfoProvider();


    
    @DSModeled(DSC.SAFE)
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        if(name==null)
            throw new NullPointerException();
        throw new SAXNotRecognizedException(name);
    }

    
    @DSModeled(DSC.SAFE)
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        if(name==null)
            throw new NullPointerException();
        throw new SAXNotRecognizedException(name);
    }

    
    @DSModeled(DSC.SAFE)
    public void setProperty(String name, Object object) throws SAXNotRecognizedException, SAXNotSupportedException {
        if(name==null)
            throw new NullPointerException();
        throw new SAXNotRecognizedException(name);
    }

    
    @DSModeled(DSC.SAFE)
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        if(name==null)
            throw new NullPointerException();
        throw new SAXNotRecognizedException(name);
    }
}
