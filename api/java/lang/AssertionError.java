package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class AssertionError extends Error {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.483 -0400", hash_original_method = "632C9A91920500ECFBFF7CDB1241885E", hash_generated_method = "8BB24CECD8503B4A4EB9C799C7E7073F")
    public  AssertionError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.484 -0400", hash_original_method = "DB301E384A0E7AC0DA0AB52BDA1439A9", hash_generated_method = "E251B81B3D4ADAB6EC7D3460AEF90AB0")
    public  AssertionError(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(cause.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.484 -0400", hash_original_method = "CD7903E922C4B27895502309BFA5EB07", hash_generated_method = "93F781A4BE394C9AD6445470A714B9AE")
    public  AssertionError(Object detailMessage) {
        super(String.valueOf(detailMessage),
                (detailMessage instanceof Throwable ? (Throwable) detailMessage : null));
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.485 -0400", hash_original_method = "BB55778BC77D5B95187F495DBBF45981", hash_generated_method = "C1E7297D9408A56B99BB21E80127806E")
    public  AssertionError(boolean detailMessage) {
        this(String.valueOf(detailMessage));
        addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.486 -0400", hash_original_method = "0919D94AF324C3859333ED19301CBB4C", hash_generated_method = "5E706F1FE2C06D19CC3B7D6EF3518A65")
    public  AssertionError(char detailMessage) {
        this(String.valueOf(detailMessage));
        addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.487 -0400", hash_original_method = "462DB8F5A907CF4FAF9D9C058DE243DA", hash_generated_method = "E08BACE49551A8970A62DB8792DDE201")
    public  AssertionError(int detailMessage) {
        this(Integer.toString(detailMessage));
        addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.488 -0400", hash_original_method = "0B1F386E30482F841F5BBFF8DA2D4AD5", hash_generated_method = "F3D057B8A460BE8AE984F4339C106278")
    public  AssertionError(long detailMessage) {
        this(Long.toString(detailMessage));
        addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.489 -0400", hash_original_method = "00A378BEF68E5943BA88BAF8271D8A43", hash_generated_method = "1DB3FE8F2F4FE4951776E3B7C74E1CB0")
    public  AssertionError(float detailMessage) {
        this(Float.toString(detailMessage));
        addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.489 -0400", hash_original_method = "7A2F5DA0FAF43875CE47806BEFC9388A", hash_generated_method = "0C4059270EA33285C1BF8CD3EBA17BBC")
    public  AssertionError(double detailMessage) {
        this(Double.toString(detailMessage));
        addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.489 -0400", hash_original_field = "4D2F709F14AE1603369D414531DBDCB7", hash_generated_field = "A3497D23B93DF9E4AA64EF083CEEBD5B")

    private static final long serialVersionUID = -5013299493970297370L;
}

