


package javax.xml.validation;

import java.io.IOException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import droidsafe.annotations.*;

public abstract class Validator {

    
    protected Validator() {
    }

    
    public abstract void reset();

    
    @DSModeled(DSC.SAFE)
    public void validate(Source source) throws SAXException, IOException {
        validate(source, null);
    }

    
    public abstract void validate(Source source, Result result) throws SAXException, IOException;

    
    public abstract void setErrorHandler(ErrorHandler errorHandler);

    
    public abstract ErrorHandler getErrorHandler();

    
    public abstract void setResourceResolver(LSResourceResolver resourceResolver);

    
    public abstract LSResourceResolver getResourceResolver();



    
    @DSModeled(DSC.SAFE)
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        if(name==null) throw new NullPointerException("the name parameter is null");
        throw new SAXNotRecognizedException(name);
    }

    
    @DSModeled(DSC.SAFE)
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        if(name==null) throw new NullPointerException("the name parameter is null");
        throw new SAXNotRecognizedException(name);
    }

    
    @DSModeled(DSC.SAFE)
    public void setProperty(String name, Object object) throws SAXNotRecognizedException, SAXNotSupportedException {
        if(name==null) throw new NullPointerException("the name parameter is null");
        throw new SAXNotRecognizedException(name);
    }

    
    @DSModeled(DSC.SAFE)
    public Object getProperty(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        if(name==null) throw new NullPointerException("the name parameter is null");
        throw new SAXNotRecognizedException(name);
    }
}
