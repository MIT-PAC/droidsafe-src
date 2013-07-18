package javax.sip.header;

// Droidsafe Imports
import javax.sip.InvalidArgumentException;

public interface AcceptEncodingHeader extends Encoding, Header, Parameters {
    String NAME = "Accept-Encoding";

    float getQValue();
    void setQValue(float qValue) throws InvalidArgumentException;
}
