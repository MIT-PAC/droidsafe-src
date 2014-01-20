package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.annotation.SdkConstant;

public final class LiveFolders implements BaseColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.620 -0500", hash_original_field = "11F7D90F715D916A63D5FB3D55CA93F4", hash_generated_field = "8F5B94AE17AA8887EB81EF0FD5591FF7")

    public static final String NAME = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.622 -0500", hash_original_field = "AD93DAD722ABD4EB8B7BCBB344D4D6F7", hash_generated_field = "4E58C3F04348C19A18C0D67BCC9E9EA8")

    public static final String DESCRIPTION = "description";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.625 -0500", hash_original_field = "968B75AAC6005A82796991685920C719", hash_generated_field = "7E52CAF6C787537A717EB72023CCE33A")

    public static final String INTENT = "intent";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.627 -0500", hash_original_field = "A3B9342DF44F2970774D307E0B031E35", hash_generated_field = "C1DC10694228957A73C98C0E7A6FCB6C")

    public static final String ICON_BITMAP = "icon_bitmap";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.629 -0500", hash_original_field = "E131A6F9ED187FAFED54BF119668C5A9", hash_generated_field = "518C82850C6B1BD8EAEC906B37D48FF3")

    public static final String ICON_PACKAGE = "icon_package";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.632 -0500", hash_original_field = "EC9C8C21FEB2B2A4887616803D8D07CE", hash_generated_field = "A88FA1C9613E7183D9C0E0946B795539")

    public static final String ICON_RESOURCE = "icon_resource";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.634 -0500", hash_original_field = "0EA0F213E3391C54C4C9B7EAC4933D60", hash_generated_field = "DE89CF731AEBB7C18AF5D8A67ED45509")

    public static final int DISPLAY_MODE_GRID = 0x1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.637 -0500", hash_original_field = "067BF8C2393ACBB2AC70F4FC8095BED8", hash_generated_field = "F393CDC70021E395ADB0F11A3DA74F97")

    public static final int DISPLAY_MODE_LIST = 0x2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.639 -0500", hash_original_field = "3CBC3D560E49F12F7E52D4D2921C15E8", hash_generated_field = "FBC84012AB4B02640D1916282520917F")

    public static final String EXTRA_LIVE_FOLDER_NAME = "android.intent.extra.livefolder.NAME";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.641 -0500", hash_original_field = "B1DB8E324B4DA728CAEA15AD9D309211", hash_generated_field = "9806932EE89992119037980F37E3E498")

    public static final String EXTRA_LIVE_FOLDER_ICON = "android.intent.extra.livefolder.ICON";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.645 -0500", hash_original_field = "FA4787486E361E2B410B8AAFB552F453", hash_generated_field = "182BA08B7AD572B0BC86FFCC92439F6E")

    public static final String EXTRA_LIVE_FOLDER_DISPLAY_MODE =
            "android.intent.extra.livefolder.DISPLAY_MODE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.647 -0500", hash_original_field = "BE13005ADA01E893BC79606116383864", hash_generated_field = "D83CFB88AD2DF311977A5C03B0F8A613")

    public static final String EXTRA_LIVE_FOLDER_BASE_INTENT =
            "android.intent.extra.livefolder.BASE_INTENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.649 -0500", hash_original_field = "87815B27EDF8A9D1590A92659E9ABAC0", hash_generated_field = "29DBB31EDB1B9FC514661268BC06D1DE")

    @SdkConstant(SdkConstant.SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_CREATE_LIVE_FOLDER =
            "android.intent.action.CREATE_LIVE_FOLDER";

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:50.652 -0500", hash_original_method = "AC1503908FF1AD4721E32C0243019CC7", hash_generated_method = "75EB957276F57F0FEB26FBBB911376AF")
    
private LiveFolders() {
    }
}

