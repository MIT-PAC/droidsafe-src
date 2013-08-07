package java.lang;

// Droidsafe Imports
import droidsafe.annotations.*;





public class LinkageError extends Error {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.222 -0400", hash_original_method = "F8257C8B139D012B1AF21CEDF65AEAF0", hash_generated_method = "C273B76F8CF21036701B1DB2BBEFB185")
    public  LinkageError() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.222 -0400", hash_original_method = "3F282F39CCEC2A75C9FAEF6579E7409E", hash_generated_method = "451B57946184CB0B2C43D0AE436AF13D")
    public  LinkageError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.223 -0400", hash_original_method = "EA091AF8CE4C0C3DC980640F02BF597B", hash_generated_method = "0615C50E7D42C168EF2991AC0D3CC097")
    public  LinkageError(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
        addTaint(cause.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.223 -0400", hash_original_field = "904FD13B2340D6F83891D103DDD3F915", hash_generated_field = "26764E9962CE8BCD1CC3E5C82CC971B6")

    private static final long serialVersionUID = 3579600108157160122L;
}

