package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class AssertionError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.428 -0400", hash_original_method = "632C9A91920500ECFBFF7CDB1241885E", hash_generated_method = "8BB24CECD8503B4A4EB9C799C7E7073F")
    @DSModeled(DSC.SAFE)
    public AssertionError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.428 -0400", hash_original_method = "DB301E384A0E7AC0DA0AB52BDA1439A9", hash_generated_method = "8F1CCACB32C9492C715A4177D4C8950C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssertionError(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        dsTaint.addTaint(cause.dsTaint);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.428 -0400", hash_original_method = "CD7903E922C4B27895502309BFA5EB07", hash_generated_method = "E4A13012467CB9909EA5C5FCE8E9E95F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssertionError(Object detailMessage) {
        super(String.valueOf(detailMessage),
                (detailMessage instanceof Throwable ? (Throwable) detailMessage : null));
        dsTaint.addTaint(detailMessage.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.429 -0400", hash_original_method = "BB55778BC77D5B95187F495DBBF45981", hash_generated_method = "E97A1629585AE03B1CC5D097A15C9789")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssertionError(boolean detailMessage) {
        this(String.valueOf(detailMessage));
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.429 -0400", hash_original_method = "0919D94AF324C3859333ED19301CBB4C", hash_generated_method = "9F6BC72DF55247EE5DBDB8AE92CA86EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssertionError(char detailMessage) {
        this(String.valueOf(detailMessage));
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.429 -0400", hash_original_method = "462DB8F5A907CF4FAF9D9C058DE243DA", hash_generated_method = "623402F51D3285CC14F8C2FD54B2BDDC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssertionError(int detailMessage) {
        this(Integer.toString(detailMessage));
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.429 -0400", hash_original_method = "0B1F386E30482F841F5BBFF8DA2D4AD5", hash_generated_method = "7EBF92271B2D9B706594A2CA78B77939")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssertionError(long detailMessage) {
        this(Long.toString(detailMessage));
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.429 -0400", hash_original_method = "00A378BEF68E5943BA88BAF8271D8A43", hash_generated_method = "380694614662BE3A989F2996F68A226D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssertionError(float detailMessage) {
        this(Float.toString(detailMessage));
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.429 -0400", hash_original_method = "7A2F5DA0FAF43875CE47806BEFC9388A", hash_generated_method = "8CB578C2FD63D8A2ECBBE15EFFEF0407")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AssertionError(double detailMessage) {
        this(Double.toString(detailMessage));
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = -5013299493970297370L;
}

