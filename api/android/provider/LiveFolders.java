package android.provider;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.annotation.SdkConstant;



public final class LiveFolders implements BaseColumns {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.348 -0400", hash_original_method = "AC1503908FF1AD4721E32C0243019CC7", hash_generated_method = "DF05606085D9909BFDB2B4F1B47DE39C")
    private  LiveFolders() {
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.348 -0400", hash_original_field = "DF93ACD53BD3A496BAA30564AD0C5925", hash_generated_field = "8F5B94AE17AA8887EB81EF0FD5591FF7")

    public static final String NAME = "name";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.348 -0400", hash_original_field = "E399E4F0011EFC0C1EF7C29FA9F39E2F", hash_generated_field = "4E58C3F04348C19A18C0D67BCC9E9EA8")

    public static final String DESCRIPTION = "description";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.348 -0400", hash_original_field = "D6359D1056484FE639F0167D04010781", hash_generated_field = "7E52CAF6C787537A717EB72023CCE33A")

    public static final String INTENT = "intent";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.348 -0400", hash_original_field = "6B0A4C1C5350E05EC6E5377865D0FFBA", hash_generated_field = "C1DC10694228957A73C98C0E7A6FCB6C")

    public static final String ICON_BITMAP = "icon_bitmap";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.348 -0400", hash_original_field = "AD79B9FCE8028267AA296ED0C924DBF1", hash_generated_field = "518C82850C6B1BD8EAEC906B37D48FF3")

    public static final String ICON_PACKAGE = "icon_package";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.348 -0400", hash_original_field = "9A61E732A6DCCFA614C21E12C7228F20", hash_generated_field = "A88FA1C9613E7183D9C0E0946B795539")

    public static final String ICON_RESOURCE = "icon_resource";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.349 -0400", hash_original_field = "239B2A163B6B02078E18E80B747C3CCE", hash_generated_field = "DE89CF731AEBB7C18AF5D8A67ED45509")

    public static final int DISPLAY_MODE_GRID = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.349 -0400", hash_original_field = "838ED5D93FC3148B50556C8A67080876", hash_generated_field = "F393CDC70021E395ADB0F11A3DA74F97")

    public static final int DISPLAY_MODE_LIST = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.349 -0400", hash_original_field = "7B1CE5EBAF41109FE4C06F9006A753CD", hash_generated_field = "FBC84012AB4B02640D1916282520917F")

    public static final String EXTRA_LIVE_FOLDER_NAME = "android.intent.extra.livefolder.NAME";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.349 -0400", hash_original_field = "A3EDA0B6E3251E60DEC3E53610719437", hash_generated_field = "9806932EE89992119037980F37E3E498")

    public static final String EXTRA_LIVE_FOLDER_ICON = "android.intent.extra.livefolder.ICON";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.349 -0400", hash_original_field = "E0592887B6471455216176BB9C99C101", hash_generated_field = "182BA08B7AD572B0BC86FFCC92439F6E")

    public static final String EXTRA_LIVE_FOLDER_DISPLAY_MODE =
            "android.intent.extra.livefolder.DISPLAY_MODE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.349 -0400", hash_original_field = "6770ED8CC909037D39C753CC68AC98A8", hash_generated_field = "D83CFB88AD2DF311977A5C03B0F8A613")

    public static final String EXTRA_LIVE_FOLDER_BASE_INTENT =
            "android.intent.extra.livefolder.BASE_INTENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.349 -0400", hash_original_field = "CB654F6E465B2A88069BC6A2997F19A1", hash_generated_field = "29DBB31EDB1B9FC514661268BC06D1DE")

    @SdkConstant(SdkConstant.SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CREATE_LIVE_FOLDER =
            "android.intent.action.CREATE_LIVE_FOLDER";
}

