



package javax.xml.validation;


public abstract class Schema {

    
    protected Schema() {
    }

    
    public abstract Validator newValidator();

    
    public abstract ValidatorHandler newValidatorHandler();
}
