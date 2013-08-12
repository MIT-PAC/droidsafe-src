package android.provider;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.accounts.Account;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.CursorEntityIterator;
import android.content.Entity;
import android.content.EntityIterator;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Rect;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;





public final class ContactsContract {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.204 -0400", hash_original_method = "0E78EC66D3E46BD387B4E4A98C6CA3E4", hash_generated_method = "0E78EC66D3E46BD387B4E4A98C6CA3E4")
    public ContactsContract ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static boolean isProfileId(long id) {
        return id >= Profile.MIN_ID;
    }

    
    public static String snippetize(String content, String displayName, String query,
            char snippetStartMatch, char snippetEndMatch, String snippetEllipsis,
            int snippetMaxTokens) {
        String lowerQuery = query != null ? query.toLowerCase() : null;
        if (TextUtils.isEmpty(content) || TextUtils.isEmpty(query) ||
                TextUtils.isEmpty(displayName) || !content.toLowerCase().contains(lowerQuery)) {
            return null;
        }
        String lowerDisplayName = displayName != null ? displayName.toLowerCase() : "";
        List<String> nameTokens = new ArrayList<String>();
        List<Integer> nameTokenOffsets = new ArrayList<Integer>();
        split(lowerDisplayName.trim(), nameTokens, nameTokenOffsets);
        for (String nameToken : nameTokens) {
            if (nameToken.startsWith(lowerQuery)) {
                return null;
            }
        }
        String[] contentLines = content.split("\n");
        for (String contentLine : contentLines) {
            if (contentLine.toLowerCase().contains(lowerQuery)) {
                List<String> lineTokens = new ArrayList<String>();
                List<Integer> tokenOffsets = new ArrayList<Integer>();
                split(contentLine.trim(), lineTokens, tokenOffsets);
                List<String> markedTokens = new ArrayList<String>();
                int firstToken = -1;
                int lastToken = -1;
                for (int i = 0; i < lineTokens.size(); i++) {
                    String token = lineTokens.get(i);
                    String lowerToken = token.toLowerCase();
                    if (lowerToken.startsWith(lowerQuery)) {
                        markedTokens.add(snippetStartMatch + token + snippetEndMatch);
                        if (firstToken == -1) {
                            firstToken =
                                    Math.max(0, i - (int) Math.floor(
                                            Math.abs(snippetMaxTokens)
                                            / 2.0));
                            lastToken =
                                    Math.min(lineTokens.size(), firstToken +
                                            Math.abs(snippetMaxTokens));
                        }
                    } else {
                        markedTokens.add(token);
                    }
                }
                if (firstToken > -1) {
                    StringBuilder sb = new StringBuilder();
                    if (firstToken > 0) {
                        sb.append(snippetEllipsis);
                    }
                    for (int i = firstToken; i < lastToken; i++) {
                        String markedToken = markedTokens.get(i);
                        String originalToken = lineTokens.get(i);
                        sb.append(markedToken);
                        if (i < lastToken - 1) {
                            sb.append(contentLine.substring(
                                    tokenOffsets.get(i) + originalToken.length(),
                                    tokenOffsets.get(i + 1)));
                        }
                    }
                    if (lastToken < lineTokens.size()) {
                        sb.append(snippetEllipsis);
                    }
                    return sb.toString();
                }
            }
        }
        return null;
    }

    
    private static void split(String content, List<String> tokens, List<Integer> offsets) {
        Matcher matcher = SPLIT_PATTERN.matcher(content);
        while (matcher.find()) {
            tokens.add(matcher.group());
            offsets.add(matcher.start());
        }
    }

    
    public static final class Authorization {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.205 -0400", hash_original_method = "130B4481E1D16F5CC0713072784D18C5", hash_generated_method = "130B4481E1D16F5CC0713072784D18C5")
        public Authorization ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.205 -0400", hash_original_field = "01F5FB9F77CA623F5D617633C5B6A423", hash_generated_field = "A470159EC5224DD15058611E1D5E86C6")

        public static final String AUTHORIZATION_METHOD = "authorize";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.205 -0400", hash_original_field = "4EC904F4A149AE0A87EA8C470747F8BB", hash_generated_field = "5CA2BFC34A142FBD92140496C29EA2FB")

        public static final String KEY_URI_TO_AUTHORIZE = "uri_to_authorize";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.205 -0400", hash_original_field = "AA60BF47F4EE1725C1E4FD9FF306E9B2", hash_generated_field = "CE5CD9050F5C0D0B1A3E53943BE0D76F")

        public static final String KEY_AUTHORIZED_URI = "authorized_uri";
    }


    
    public static final class Preferences {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.205 -0400", hash_original_method = "2E8FE94CA2E5C969DED3F5ED9F537560", hash_generated_method = "2E8FE94CA2E5C969DED3F5ED9F537560")
        public Preferences ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.205 -0400", hash_original_field = "1DFFC028FA84A858B40ED4B100C66302", hash_generated_field = "354038F38C8A27D1130C805310BD23D7")

        public static final String SORT_ORDER = "android.contacts.SORT_ORDER";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.205 -0400", hash_original_field = "B25ECFAC5CAE933418C572B569CC2E81", hash_generated_field = "DE0FA688EB095C8C63158D49A34915EC")

        public static final int SORT_ORDER_PRIMARY = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.205 -0400", hash_original_field = "D5DAA717DAE900BC9905B70FAADD4916", hash_generated_field = "16FA408EB36C9D63537965227EB953C3")

        public static final int SORT_ORDER_ALTERNATIVE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "55412E38BE1A03C88FD7CC4194BCCBE4", hash_generated_field = "44E17A97F52B762BCB696B660872D72B")

        public static final String DISPLAY_ORDER = "android.contacts.DISPLAY_ORDER";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "DE49E8687B574E616570C67053C889E0", hash_generated_field = "DC3C3CD73DD75F47A0631529D7184EB1")

        public static final int DISPLAY_ORDER_PRIMARY = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "3FD473FC3EEB661A2FFAB8DFECD4F9D0", hash_generated_field = "AF2282B4CF1E1DBBFC521795D96F6061")

        public static final int DISPLAY_ORDER_ALTERNATIVE = 2;
    }


    
    public static final class Directory implements BaseColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_method = "C1FAFD7F8C25A27903905826E99B3CB4", hash_generated_method = "32027E1E1476A00A97D4C9A87338A0EE")
        private  Directory() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        public static void notifyDirectoryChange(ContentResolver resolver) {
            ContentValues contentValues = new ContentValues();
            resolver.update(Directory.CONTENT_URI, contentValues, null, null);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "4CCE37F90F6217D100A69C1D9DC59C3F", hash_generated_field = "B6F02680896AA16AD685418AD49231CC")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "directories");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "C0CC6A80E79BB6E1EC269DE6D493FACD", hash_generated_field = "423D8E2040F0763F948EDAD54B89A5EA")

        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/contact_directories";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "3D5A57749389C9F4E4972C811EA5FFF9", hash_generated_field = "B9A704C9D5BAADBFF9ED5716E281267F")

        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/contact_directory";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "D8C7884D3AEEE28E1825BF7A4F3346D4", hash_generated_field = "C137D8F7BDBD47FF72070C1B4AB800F7")

        public static final long DEFAULT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "78A3E819F209735DEF7BF37DFAE4035E", hash_generated_field = "35783223357D71D592344B4E64BF95DD")

        public static final long LOCAL_INVISIBLE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "94D807F8D772178E9856DE48F3323326", hash_generated_field = "2CA46768DFD7C5D320ECE4CE59CFD2B2")

        public static final String PACKAGE_NAME = "packageName";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "DAA13C217C6816EBA5C473D30DF23A43", hash_generated_field = "E957B4A8C7D8100B23968F5E4A70B4E7")

        public static final String TYPE_RESOURCE_ID = "typeResourceId";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "71EFBE0312D29D01940A90AE18380A54", hash_generated_field = "78A07F035FAA45648EFB54670D54860D")

        public static final String DISPLAY_NAME = "displayName";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "74B38265F23407AB7EC5FAF2802ADE3D", hash_generated_field = "4822F23B2FE5726D519161D8033D2510")

        public static final String DIRECTORY_AUTHORITY = "authority";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "98D9D5C7E51AC1F11F727F3333D425E9", hash_generated_field = "14F626F5827ECD6989F9CED7C950B057")

        public static final String ACCOUNT_TYPE = "accountType";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "82B1E2078AD4641643D022FD020D66B6", hash_generated_field = "5F618676BF9315685112C847A236AC4A")

        public static final String ACCOUNT_NAME = "accountName";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "2C437D73F695CE6B5F4D89E7C75D69CD", hash_generated_field = "554D6F2B634F4E8EC5B4B61FAF5A5EC0")

        public static final String EXPORT_SUPPORT = "exportSupport";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "103BC3B69D7C31C31A9C6A0D9D80DFF4", hash_generated_field = "8BBD44385214899CBA373373776BC8D7")

        public static final int EXPORT_SUPPORT_NONE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "D0F1A98CBF636FD1D4C29F0C06B13CAB", hash_generated_field = "E813A39147A493EC08907EAF30FF09A8")

        public static final int EXPORT_SUPPORT_SAME_ACCOUNT_ONLY = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "D6BA756D8E37A4E0054415C3978224FC", hash_generated_field = "1F072DB4A2A9172E40F4F24F1A0DA31D")

        public static final int EXPORT_SUPPORT_ANY_ACCOUNT = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "72C9543554BFE5DEF144C6672EFFDF70", hash_generated_field = "49B991BA70BFA63B7B365B94EDD7D9F7")

        public static final String SHORTCUT_SUPPORT = "shortcutSupport";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "AFF89F9031DBC8D3784BF4E588534792", hash_generated_field = "7D5722842A6B1242F73D42679F9A6334")

        public static final int SHORTCUT_SUPPORT_NONE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "5F9E7FFB16A4FC56E5AA52EF791515A1", hash_generated_field = "6F2ACF35F3714563F3AD0C38919EB143")

        public static final int SHORTCUT_SUPPORT_DATA_ITEMS_ONLY = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "6FF7653AF5D5820DC868A7308A112BB2", hash_generated_field = "CC854A806F8946D877881D62895DFAA9")

        public static final int SHORTCUT_SUPPORT_FULL = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "EEE0E4A053B776B1C7A0786056F7CA02", hash_generated_field = "A309841362551FF88F370A53BD881109")

        public static final String PHOTO_SUPPORT = "photoSupport";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.206 -0400", hash_original_field = "8FE2688AFAED5F4EE27EEB163B398FC4", hash_generated_field = "8029E66303C1933A09F6513D500196A1")

        public static final int PHOTO_SUPPORT_NONE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.207 -0400", hash_original_field = "8CC1C81C7C4C0E20AC4153004F611D5C", hash_generated_field = "A734B382DF477239279F9668CECEB7D3")

        public static final int PHOTO_SUPPORT_THUMBNAIL_ONLY = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.207 -0400", hash_original_field = "A6193F054740C1A700328647D15880B5", hash_generated_field = "AB5A7DA7C57E4171039C7EA9CAE5BE24")

        public static final int PHOTO_SUPPORT_FULL_SIZE_ONLY = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.207 -0400", hash_original_field = "85F5E7292890F3937D7F62E7C56F92CE", hash_generated_field = "D72B5FD4DEE70B19F572B6BE7A1DA5FC")

        public static final int PHOTO_SUPPORT_FULL = 3;
    }


    
    public static final class SyncState implements SyncStateContract.Columns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.207 -0400", hash_original_method = "C3CB9524AE86EE634A43E203167EAA5A", hash_generated_method = "7C56DAB1CC85D73593C30D4266013E44")
        private  SyncState() {
            // ---------- Original Method ----------
        }

        
        public static byte[] get(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(provider, CONTENT_URI, account);
        }

        
        public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(provider, CONTENT_URI, account);
        }

        
        public static void set(ContentProviderClient provider, Account account, byte[] data) throws RemoteException {
            SyncStateContract.Helpers.set(provider, CONTENT_URI, account, data);
        }

        
        public static ContentProviderOperation newSetOperation(Account account, byte[] data) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, data);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.207 -0400", hash_original_field = "FC07B3975EDE6E134B03F9A154159E24", hash_generated_field = "B8243A9F992B1927826CEDCE0876B770")

        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.207 -0400", hash_original_field = "2C3AB54DE75FF386983DCDD52DECAD40", hash_generated_field = "D7D188013240FCCAF388869D2E2EBFDE")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);
    }


    
    public static final class ProfileSyncState implements SyncStateContract.Columns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.207 -0400", hash_original_method = "1AF1C4539078F536A57F5CC0E82C2CE1", hash_generated_method = "62C098D2F6555C9344B4BEE7E8733390")
        private  ProfileSyncState() {
            // ---------- Original Method ----------
        }

        
        public static byte[] get(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.get(provider, CONTENT_URI, account);
        }

        
        public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Account account) throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(provider, CONTENT_URI, account);
        }

        
        public static void set(ContentProviderClient provider, Account account, byte[] data) throws RemoteException {
            SyncStateContract.Helpers.set(provider, CONTENT_URI, account, data);
        }

        
        public static ContentProviderOperation newSetOperation(Account account, byte[] data) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, data);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.208 -0400", hash_original_field = "FC07B3975EDE6E134B03F9A154159E24", hash_generated_field = "B8243A9F992B1927826CEDCE0876B770")

        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.208 -0400", hash_original_field = "994011C1140663DAD3D70B2FDBE59842", hash_generated_field = "A12A5FA95C37F6B7E0F5ADA8AB6D997E")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, CONTENT_DIRECTORY);
    }


    
    public final static class ContactCounts {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.208 -0400", hash_original_method = "CB1CFE8B6024EEF8B52112C6EF2CC42E", hash_generated_method = "CB1CFE8B6024EEF8B52112C6EF2CC42E")
        public ContactCounts ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.208 -0400", hash_original_field = "5D5E047FD03F3F5B8DBC71DCDCE1C87B", hash_generated_field = "7C98B52260D9013556878BD20F22F6D5")

        public static final String ADDRESS_BOOK_INDEX_EXTRAS = "address_book_index_extras";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.208 -0400", hash_original_field = "A44B162F6542C3B094FF2DAD4EC7CB91", hash_generated_field = "DE6D8EE389A22FA73B65287BD3DB9204")

        public static final String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "address_book_index_titles";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.208 -0400", hash_original_field = "B34C8BA851A7847F95E03141AFD03BAC", hash_generated_field = "109D0DA1E42CE04FEDF0308632673861")

        public static final String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "address_book_index_counts";
    }


    
    public static class Contacts implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.208 -0400", hash_original_method = "F5E3085137E37D29F0F8CB3C296F1F57", hash_generated_method = "EBAB9AC2EF768DD752DA8373D9E74008")
        private  Contacts() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SPEC)
        public static Uri getLookupUri(ContentResolver resolver, Uri contactUri) {
            final Cursor c = resolver.query(contactUri, new String[] {
                    Contacts.LOOKUP_KEY, Contacts._ID
            }, null, null, null);
            if (c == null) {
                return null;
            }
            try {
                if (c.moveToFirst()) {
                    final String lookupKey = c.getString(0);
                    final long contactId = c.getLong(1);
                    return getLookupUri(contactId, lookupKey);
                }
            } finally {
                c.close();
            }
            return null;
        }

        
        @DSModeled(DSC.SPEC)
        public static Uri getLookupUri(long contactId, String lookupKey) {
            return ContentUris.withAppendedId(Uri.withAppendedPath(Contacts.CONTENT_LOOKUP_URI,
                    lookupKey), contactId);
        }

        
        @DSModeled(DSC.SPEC)
        public static Uri lookupContact(ContentResolver resolver, Uri lookupUri) {
            if (lookupUri == null) {
                return null;
            }
            Cursor c = resolver.query(lookupUri, new String[]{Contacts._ID}, null, null, null);
            if (c == null) {
                return null;
            }
            try {
                if (c.moveToFirst()) {
                    long contactId = c.getLong(0);
                    return ContentUris.withAppendedId(Contacts.CONTENT_URI, contactId);
                }
            } finally {
                c.close();
            }
            return null;
        }

        
        public static void markAsContacted(ContentResolver resolver, long contactId) {
            Uri uri = ContentUris.withAppendedId(CONTENT_URI, contactId);
            ContentValues values = new ContentValues();
            values.put(LAST_TIME_CONTACTED, System.currentTimeMillis());
            resolver.update(uri, values, null, null);
        }

        
        @DSModeled(DSC.SPEC)
        public static InputStream openContactPhotoInputStream(ContentResolver cr, Uri contactUri,
                boolean preferHighres) {
            if (preferHighres) {
                final Uri displayPhotoUri = Uri.withAppendedPath(contactUri,
                        Contacts.Photo.DISPLAY_PHOTO);
                InputStream inputStream;
                try {
                    AssetFileDescriptor fd = cr.openAssetFileDescriptor(displayPhotoUri, "r");
                    return fd.createInputStream();
                } catch (IOException e) {
                }
           }
            Uri photoUri = Uri.withAppendedPath(contactUri, Photo.CONTENT_DIRECTORY);
            if (photoUri == null) {
                return null;
            }
            Cursor cursor = cr.query(photoUri,
                    new String[] {
                        ContactsContract.CommonDataKinds.Photo.PHOTO
                    }, null, null, null);
            try {
                if (cursor == null || !cursor.moveToNext()) {
                    return null;
                }
                byte[] data = cursor.getBlob(0);
                if (data == null) {
                    return null;
                }
                return new ByteArrayInputStream(data);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        
        @DSModeled(DSC.SPEC)
        public static InputStream openContactPhotoInputStream(ContentResolver cr, Uri contactUri) {
            return openContactPhotoInputStream(cr, contactUri, false);
        }

        
        public static final class Data implements BaseColumns, DataColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.209 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "68BBF991BD74A1EFA8A89E7D9D24A1BD")
            private  Data() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.209 -0400", hash_original_field = "244843A89660565990A10147301407C3", hash_generated_field = "9B918616E0E439AEB554FBB4A1A7DAFD")

            public static final String CONTENT_DIRECTORY = "data";
        }


        
        public static final class Entity implements BaseColumns, ContactsColumns, ContactNameColumns, RawContactsColumns, BaseSyncColumns, SyncColumns, DataColumns, StatusColumns, ContactOptionsColumns, ContactStatusColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.209 -0400", hash_original_method = "607EBA13DCD67902F3CEC6239F391768", hash_generated_method = "72BDB032AD922DE54B8D777470530676")
            private  Entity() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.209 -0400", hash_original_field = "082C6DAEF2FDCE09B45118D2E8BA907A", hash_generated_field = "FFD23D74408F7344A82A6777888A9F41")

            public static final String CONTENT_DIRECTORY = "entities";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.209 -0400", hash_original_field = "82DF7655278AB5C7ED185668683B0660", hash_generated_field = "4843237709B7C68BA8EA2D088BC7ADBB")

            public static final String RAW_CONTACT_ID = "raw_contact_id";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.209 -0400", hash_original_field = "25A0C98C2CD9718D3437CC55222F352D", hash_generated_field = "BF40874F004CCCDE98B1D602D4FC4265")

            public static final String DATA_ID = "data_id";
        }


        
        public static final class StreamItems implements StreamItemsColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.209 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "49F523F180DE7D539C580F6D11E59338")
            private  StreamItems() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.209 -0400", hash_original_field = "AB527CF994C1B112B0ECF7E138BA21A0", hash_generated_field = "13CE0BD71DF45E7185B296A116872C44")

            public static final String CONTENT_DIRECTORY = "stream_items";
        }


        
        public static final class AggregationSuggestions implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactStatusColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.209 -0400", hash_original_method = "35E5891C5F5088704DD7A6D202E906B4", hash_generated_method = "466C7EBC7F53D00329A79C14605D9051")
            private  AggregationSuggestions() {
                // ---------- Original Method ----------
            }

            
            public static final Builder builder() {
                return new Builder();
            }

            
            public static final class Builder {
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_field = "11E07A2B6249CB82D0C0ADA4541D9018", hash_generated_field = "54B9A457EEF3B70924549BAF472FB470")

                private long mContactId;
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_field = "99935A467EDCE99C649181E374912500", hash_generated_field = "3C3B2250459C9384D9803616C1A141B8")

                private ArrayList<String> mKinds = new ArrayList<String>();
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_field = "D5334D0FB80A45CDDCC7FF5AB0709484", hash_generated_field = "FAD416ACD528C34B72B989001FEFE40D")

                private ArrayList<String> mValues = new ArrayList<String>();
                @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_field = "5B168C2292FF8EC273A67B1639E35C5D", hash_generated_field = "4EC83DFC67A77EF18032B269F8E92E02")

                private int mLimit;
                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
                public Builder ()
                {
                    //Synthesized constructor
                }


                                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_method = "9AAB1F7A5A7D8D5960972B4CBC4F52B3", hash_generated_method = "DB2319833719A622CB858CE485CD78BD")
                public Builder setContactId(long contactId) {
                    this.mContactId = contactId;
Builder var72A74007B2BE62B849F475C7BDA4658B_590361268 =                     this;
                    var72A74007B2BE62B849F475C7BDA4658B_590361268.addTaint(taint);
                    return var72A74007B2BE62B849F475C7BDA4658B_590361268;
                    // ---------- Original Method ----------
                    //this.mContactId = contactId;
                    //return this;
                }

                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_method = "C32C8611EF5F2627AFE89485D07DC5FB", hash_generated_method = "1A1C846301093BB97AA066B526BCECAF")
                public Builder addParameter(String kind, String value) {
                    addTaint(value.getTaint());
                    addTaint(kind.getTaint());
                    if(!TextUtils.isEmpty(value))                    
                    {
                        mKinds.add(kind);
                        mValues.add(value);
                    } //End block
Builder var72A74007B2BE62B849F475C7BDA4658B_513833310 =                     this;
                    var72A74007B2BE62B849F475C7BDA4658B_513833310.addTaint(taint);
                    return var72A74007B2BE62B849F475C7BDA4658B_513833310;
                    // ---------- Original Method ----------
                    //if (!TextUtils.isEmpty(value)) {
                        //mKinds.add(kind);
                        //mValues.add(value);
                    //}
                    //return this;
                }

                
                                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_method = "C603E268BE9EB815AE093A2C036882D2", hash_generated_method = "182F116995C41E58C13515128829F94C")
                public Builder setLimit(int limit) {
                    mLimit = limit;
Builder var72A74007B2BE62B849F475C7BDA4658B_533467230 =                     this;
                    var72A74007B2BE62B849F475C7BDA4658B_533467230.addTaint(taint);
                    return var72A74007B2BE62B849F475C7BDA4658B_533467230;
                    // ---------- Original Method ----------
                    //mLimit = limit;
                    //return this;
                }

                
                                @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_method = "CC75446D812A1F4BC170E31BF0668A44", hash_generated_method = "BE7016D4717EC806419BF9064DE50024")
                public Uri build() {
                    android.net.Uri.Builder builder = Contacts.CONTENT_URI.buildUpon();
                    builder.appendEncodedPath(String.valueOf(mContactId));
                    builder.appendPath(Contacts.AggregationSuggestions.CONTENT_DIRECTORY);
                    if(mLimit != 0)                    
                    {
                        builder.appendQueryParameter("limit", String.valueOf(mLimit));
                    } //End block
                    int count = mKinds.size();
for(int i = 0;i < count;i++)
                    {
                        builder.appendQueryParameter("query", mKinds.get(i) + ":" + mValues.get(i));
                    } //End block
Uri varE8AA2F80EB061A3F728175D13D293A98_677949017 =                     builder.build();
                    varE8AA2F80EB061A3F728175D13D293A98_677949017.addTaint(taint);
                    return varE8AA2F80EB061A3F728175D13D293A98_677949017;
                    // ---------- Original Method ----------
                    //android.net.Uri.Builder builder = Contacts.CONTENT_URI.buildUpon();
                    //builder.appendEncodedPath(String.valueOf(mContactId));
                    //builder.appendPath(Contacts.AggregationSuggestions.CONTENT_DIRECTORY);
                    //if (mLimit != 0) {
                        //builder.appendQueryParameter("limit", String.valueOf(mLimit));
                    //}
                    //int count = mKinds.size();
                    //for (int i = 0; i < count; i++) {
                        //builder.appendQueryParameter("query", mKinds.get(i) + ":" + mValues.get(i));
                    //}
                    //return builder.build();
                }

                
            }


            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_field = "48F7FA5D3FB1DE3A9206155104845D53", hash_generated_field = "6EEA28F01E23AE920EA0888EF515D1EA")

            public static final String CONTENT_DIRECTORY = "suggestions";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_field = "E1559FB7DA1AC173E857ABBDE77279B3", hash_generated_field = "B6AF81729D92C3DC946A8E696FBD665C")

            public static final String PARAMETER_MATCH_NAME = "name";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "5AB5950E7BB655693A399CF125A8472C", hash_generated_field = "25766439F31846B59A3B38ECEDFE371A")

            public static final String PARAMETER_MATCH_EMAIL = "email";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "338A740E3E99FE6246801A0D0A2730F0", hash_generated_field = "DB4ACE45E803F4F53078A3EC91A52C0A")

            public static final String PARAMETER_MATCH_PHONE = "phone";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "27EB53CC72E978DE1AC32A40192FAB99", hash_generated_field = "F064A94D0E7532DD6A308404CBA1299D")

            public static final String PARAMETER_MATCH_NICKNAME = "nickname";
        }


        
        public static final class Photo implements BaseColumns, DataColumnsWithJoins {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_method = "C03E3395BFF21729CC93322BBC7A82DE", hash_generated_method = "6353485435339DC025174C823A75D00F")
            private  Photo() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "D7765A9417F60D3FDE570697DF8AE20E", hash_generated_field = "AF03CF5B5172F2903B579B1D0EA79FB9")

            public static final String CONTENT_DIRECTORY = "photo";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "168565CF5F18B1EEA01E92E2EBBA2941", hash_generated_field = "701A2F7AD17160EF4D7EDA112829F17C")

            public static final String DISPLAY_PHOTO = "display_photo";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "D788C6AA077DFD01FC513679BA93D4DF", hash_generated_field = "827F52308AEA6086917181CAD2690C59")

            public static final String PHOTO_FILE_ID = DATA14;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "906C07610AAC15FC6A2F6263527EC4C4", hash_generated_field = "2769AC225261CB92B8111CE835D1CB36")

            public static final String PHOTO = DATA15;
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "BE3AF0DA7B15FFDB10B51691845EE628", hash_generated_field = "5370BB56B85850A889ED03A2FA6172D9")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "contacts");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "B2386446D617C4FF72800940ABB8C302", hash_generated_field = "F94DD7AE0907A95C5597A5A8773EE09E")

        public static final Uri CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI,
                "lookup");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "64F966F8F1A9EDCB9D702B106F119DC5", hash_generated_field = "284F3AE95B142F252DBD1B29255F0C8E")

        public static final Uri CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI,
                "as_vcard");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "312F7B8DE5ECBE950ADE70AC305E55A4", hash_generated_field = "58AA446E970DB4E6ED2A543CA3B1757C")

        public static final String QUERY_PARAMETER_VCARD_NO_PHOTO = "nophoto";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "640F1C9122C1D5C9B7DAF57352AD4C94", hash_generated_field = "391833C98BFA17A505F59D33CCBFA2A4")

        public static final Uri CONTENT_MULTI_VCARD_URI = Uri.withAppendedPath(CONTENT_URI,
                "as_multi_vcard");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "360214B0BB2C841B07FB6C25AC803953", hash_generated_field = "36A83EB7BAEC220CEDCCB9CC5B7F20BE")

        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(
                CONTENT_URI, "filter");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "4D70FA8E63647B2D33426D4EB14D878C", hash_generated_field = "474F361F7A54257A5783BF94FAA14DDB")

        public static final Uri CONTENT_STREQUENT_URI = Uri.withAppendedPath(
                CONTENT_URI, "strequent");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "9085B8B9424DBAD6DC18B8AA259425E1", hash_generated_field = "F06E3D05418C4E3F3E9D231A8F0769A0")

        public static final Uri CONTENT_FREQUENT_URI = Uri.withAppendedPath(
                CONTENT_URI, "frequent");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "816146A69AB4435960EC1DFA79D023A5", hash_generated_field = "1EEBE319236CD0056F5C09998F70A1A5")

        public static final Uri CONTENT_STREQUENT_FILTER_URI = Uri.withAppendedPath(
                CONTENT_STREQUENT_URI, "filter");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "6EE364370580227C5BF981CA52B66665", hash_generated_field = "F8700FD8F66119DCF4D9FA84EFAB6107")

        public static final Uri CONTENT_GROUP_URI = Uri.withAppendedPath(
                CONTENT_URI, "group");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "7AC9CED0BE5F059F45851EFFF5F552B9", hash_generated_field = "C1454D5C98A71A32CF2C3F72272BFADA")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "BF46EF7698E4DF30181B83B7EAE0926F", hash_generated_field = "305304684328E09949E78A8A8CBCA5EE")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.211 -0400", hash_original_field = "81645098CEF5FB70D688C2C08B7B375D", hash_generated_field = "C67F5807C996D0CE4AF6FF7765FC33B6")

        public static final String CONTENT_VCARD_TYPE = "text/x-vcard";
    }


    
    public static final class Profile implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_method = "B87424FB8F4DF05D98854CA5453341A1", hash_generated_method = "F0740920D8E660C3FAFA79C0F30FDA26")
        private  Profile() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "EF3B5D3D738D6C84B7D339F70FAAB619", hash_generated_field = "576B190C7713DF6E5188A93DF9D0AD71")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "profile");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "64F966F8F1A9EDCB9D702B106F119DC5", hash_generated_field = "284F3AE95B142F252DBD1B29255F0C8E")

        public static final Uri CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI,
                "as_vcard");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "3C5ECD17DB5EE64D2008D9EE964EB4EF", hash_generated_field = "1A0853607327F8109D4DB0C1DDD8F59A")

        public static final Uri CONTENT_RAW_CONTACTS_URI = Uri.withAppendedPath(CONTENT_URI,
                "raw_contacts");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "8A881C6E249BE0FA43E91B4B73B43E40", hash_generated_field = "45A7B61E283404557CA14624BA550793")

        public static final long MIN_ID = Long.MAX_VALUE - (long) Integer.MAX_VALUE;
    }


    
    public static final class RawContacts implements BaseColumns, RawContactsColumns, ContactOptionsColumns, ContactNameColumns, SyncColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_method = "6107CD4B76D912ACDA57642552743C0C", hash_generated_method = "005A36265C3975138432C36B012CB07D")
        private  RawContacts() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SPEC)
        public static Uri getContactLookupUri(ContentResolver resolver, Uri rawContactUri) {
            final Uri dataUri = Uri.withAppendedPath(rawContactUri, Data.CONTENT_DIRECTORY);
            final Cursor cursor = resolver.query(dataUri, new String[] {
                    RawContacts.CONTACT_ID, Contacts.LOOKUP_KEY
            }, null, null, null);
            Uri lookupUri = null;
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    final long contactId = cursor.getLong(0);
                    final String lookupKey = cursor.getString(1);
                    return Contacts.getLookupUri(contactId, lookupKey);
                }
            } finally {
                if (cursor != null) cursor.close();
            }
            return lookupUri;
        }

        
        public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }

        
        public static final class Data implements BaseColumns, DataColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "68BBF991BD74A1EFA8A89E7D9D24A1BD")
            private  Data() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "244843A89660565990A10147301407C3", hash_generated_field = "9B918616E0E439AEB554FBB4A1A7DAFD")

            public static final String CONTENT_DIRECTORY = "data";
        }


        
        public static final class Entity implements BaseColumns, DataColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_method = "607EBA13DCD67902F3CEC6239F391768", hash_generated_method = "72BDB032AD922DE54B8D777470530676")
            private  Entity() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "B8AC9716E9005D50757761FA53F2A683", hash_generated_field = "D55A4C79393D833EAA5D07CD4A1C37E3")

            public static final String CONTENT_DIRECTORY = "entity";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "25A0C98C2CD9718D3437CC55222F352D", hash_generated_field = "BF40874F004CCCDE98B1D602D4FC4265")

            public static final String DATA_ID = "data_id";
        }


        
        public static final class StreamItems implements BaseColumns, StreamItemsColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "49F523F180DE7D539C580F6D11E59338")
            private  StreamItems() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "AB527CF994C1B112B0ECF7E138BA21A0", hash_generated_field = "13CE0BD71DF45E7185B296A116872C44")

            public static final String CONTENT_DIRECTORY = "stream_items";
        }


        
        public static final class DisplayPhoto {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.213 -0400", hash_original_method = "4DA607ACD5E6F502EC932EC179042892", hash_generated_method = "B2E13164C0532FB7A083C12460677DAB")
            private  DisplayPhoto() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.213 -0400", hash_original_field = "04AB94E13ECA7180275A0BFB08B294C5", hash_generated_field = "C1D586C4476D33FF0691486D25CE47B6")

            public static final String CONTENT_DIRECTORY = "display_photo";
        }


        
        private static class EntityIteratorImpl extends CursorEntityIterator {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.213 -0400", hash_original_method = "5371E683B36CD927F8174DD86149D4D5", hash_generated_method = "DE3E062D3600C23F52B9400031643F33")
            public  EntityIteratorImpl(Cursor cursor) {
                super(cursor);
                addTaint(cursor.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.213 -0400", hash_original_method = "BE255AFD270DEBC5451268E05A1F1326", hash_generated_method = "C4648BCEBDDBC721BF20954370DB7258")
            @Override
            public android.content.Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                addTaint(cursor.getTaint());
                final int columnRawContactId = cursor.getColumnIndexOrThrow(RawContacts._ID);
                final long rawContactId = cursor.getLong(columnRawContactId);
                ContentValues cv = new ContentValues();
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, ACCOUNT_NAME);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, ACCOUNT_TYPE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, DATA_SET);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, _ID);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, DIRTY);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, VERSION);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, SOURCE_ID);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, SYNC1);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, SYNC2);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, SYNC3);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, SYNC4);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, DELETED);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, CONTACT_ID);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, STARRED);
                DatabaseUtils.cursorIntToContentValuesIfPresent(cursor, cv, NAME_VERIFIED);
                android.content.Entity contact = new android.content.Entity(cv);
                do {
                    {
                        if(rawContactId != cursor.getLong(columnRawContactId))                        
                        {
                            break;
                        } //End block
                        cv = new ContentValues();
                        cv.put(Data._ID, cursor.getLong(cursor.getColumnIndexOrThrow(Entity.DATA_ID)));
                        DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv,
                            Data.RES_PACKAGE);
                        DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv, Data.MIMETYPE);
                        DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, Data.IS_PRIMARY);
                        DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv,
                            Data.IS_SUPER_PRIMARY);
                        DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, cv, Data.DATA_VERSION);
                        DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv,
                            CommonDataKinds.GroupMembership.GROUP_SOURCE_ID);
                        DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, cv,
                            Data.DATA_VERSION);
for(String key : DATA_KEYS)
                        {
                            final int columnIndex = cursor.getColumnIndexOrThrow(key);
switch(cursor.getType(columnIndex)){
                            case Cursor.FIELD_TYPE_NULL:
                            break;
                            case Cursor.FIELD_TYPE_INTEGER:
                            case Cursor.FIELD_TYPE_FLOAT:
                            case Cursor.FIELD_TYPE_STRING:
                            cv.put(key, cursor.getString(columnIndex));
                            break;
                            case Cursor.FIELD_TYPE_BLOB:
                            cv.put(key, cursor.getBlob(columnIndex));
                            break;
                            default:
                            IllegalStateException varD48CE5DFBD7FDE642E5F22D9CA04E4DC_1073870068 = new IllegalStateException("Invalid or unhandled data type");
                            varD48CE5DFBD7FDE642E5F22D9CA04E4DC_1073870068.addTaint(taint);
                            throw varD48CE5DFBD7FDE642E5F22D9CA04E4DC_1073870068;
}
                        } //End block
                        contact.addSubValue(ContactsContract.Data.CONTENT_URI, cv);
                    } //End block
} while (cursor.moveToNext());
android.content.Entity var695F7F01550A7C9445656119C31590B1_1920742961 =                 contact;
                var695F7F01550A7C9445656119C31590B1_1920742961.addTaint(taint);
                return var695F7F01550A7C9445656119C31590B1_1920742961;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.213 -0400", hash_original_field = "E062B90CF75BEF2C07C496D35CF28182", hash_generated_field = "411B691BE1CB3F57E3AB0F44B5F5E61C")

            private static final String[] DATA_KEYS = new String[]{
                    Data.DATA1,
                    Data.DATA2,
                    Data.DATA3,
                    Data.DATA4,
                    Data.DATA5,
                    Data.DATA6,
                    Data.DATA7,
                    Data.DATA8,
                    Data.DATA9,
                    Data.DATA10,
                    Data.DATA11,
                    Data.DATA12,
                    Data.DATA13,
                    Data.DATA14,
                    Data.DATA15,
                    Data.SYNC1,
                    Data.SYNC2,
                    Data.SYNC3,
                    Data.SYNC4};
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "346712E9010E3D891359D2AE5A2E9691", hash_generated_field = "7285DD00B1DE1BA2EB1E93374C16DBE6")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "raw_contacts");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "8998EC02CDAB97D124BFDB4F125F1926", hash_generated_field = "DCAD7464C9BB668200B0A345532D9B88")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "F42E9719FA9168DDD223E14628A8382D", hash_generated_field = "DB6D85C044D75849161B9D28B59008B5")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/raw_contact";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "4EA186D8F08D90634224D9190053FD65", hash_generated_field = "161859A3F399C943CA06A430045EF8E5")

        public static final int AGGREGATION_MODE_DEFAULT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "8F601C983CFE8D36BDE18E4042CD71BF", hash_generated_field = "5D8A3BD7C1AFF541BC9D62807AA786BF")

        @Deprecated
        public static final int AGGREGATION_MODE_IMMEDIATE = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "3BC4436AAC785C9EA97221101C59615F", hash_generated_field = "EC2DBD6DAEC29C27D73E90B647D29BD2")

        public static final int AGGREGATION_MODE_SUSPENDED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "BCB0FB622FD0D338447A37EA5B23561D", hash_generated_field = "5B38CECCA30063F05904A1946763568D")

        public static final int AGGREGATION_MODE_DISABLED = 3;
    }


    
    public static final class StreamItems implements BaseColumns, StreamItemsColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "49F523F180DE7D539C580F6D11E59338")
        private  StreamItems() {
            // ---------- Original Method ----------
        }

        
        public static final class StreamItemPhotos implements BaseColumns, StreamItemPhotosColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_method = "52BE888A2784297EE4FE3818D09C55BC", hash_generated_method = "802E4A54077CF0761BF1353DB1940447")
            private  StreamItemPhotos() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "D7765A9417F60D3FDE570697DF8AE20E", hash_generated_field = "AF03CF5B5172F2903B579B1D0EA79FB9")

            public static final String CONTENT_DIRECTORY = "photo";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "99B9534C2F422097BF9769F48DCD7F3E", hash_generated_field = "365500E1C6F9E4194C13B4EBED610BF4")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item_photo";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "E2267E00FAF6C2FED8EBCFF69FC42172", hash_generated_field = "D8E04A706721AD03E95E429B2F7FCBE8")

            public static final String CONTENT_ITEM_TYPE
                    = "vnd.android.cursor.item/stream_item_photo";
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "1C57BB0923C89599185D891185D0BE83", hash_generated_field = "FC402994047511C4F3F84FFF51EA5C9A")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "stream_items");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "768AF664270B293B183FFD3A5F0AFD65", hash_generated_field = "0EE28EEC2EC78074DAB3EE95CB506E9B")

        public static final Uri CONTENT_PHOTO_URI = Uri.withAppendedPath(CONTENT_URI, "photo");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "81967F20B62D3DCFACFFF723B9F20AB9", hash_generated_field = "3145145BE0A56CE4E90B223BAD89DB70")

        public static final Uri CONTENT_LIMIT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "stream_items_limit");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "686E2EA67A26AAD637FD452F3E659A9C", hash_generated_field = "EFDA5895598F764361ACC9C69FF92318")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "4E719EAE45017A7F8E1A0A7437767909", hash_generated_field = "E5CC7D9308B16720A481498C29FEC8A8")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/stream_item";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "E2D01BA2C233546C347421E839297FF7", hash_generated_field = "7FC26EE40F1BE52F25C8FDA0BDE1FE79")

        public static final String MAX_ITEMS = "max_items";
    }


    
    public static final class StreamItemPhotos implements BaseColumns, StreamItemPhotosColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_method = "52BE888A2784297EE4FE3818D09C55BC", hash_generated_method = "802E4A54077CF0761BF1353DB1940447")
        private  StreamItemPhotos() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_field = "F4325FE88810FA7ED9ED1DF85B2D0C84", hash_generated_field = "92E6F30B0EB548C6F00B8F457E0C981F")

        public static final String PHOTO = "photo";
    }


    
    public static final class PhotoFiles implements BaseColumns, PhotoFilesColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_method = "68B58AFB95B4CB9CF9AA43D4A8112325", hash_generated_method = "059107858AF90ED764E5882C1FCC748C")
        private  PhotoFiles() {
            // ---------- Original Method ----------
        }

        
    }


    
    public final static class Data implements DataColumnsWithJoins {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "68BBF991BD74A1EFA8A89E7D9D24A1BD")
        private  Data() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SPEC)
        public static Uri getContactLookupUri(ContentResolver resolver, Uri dataUri) {
            final Cursor cursor = resolver.query(dataUri, new String[] {
                    RawContacts.CONTACT_ID, Contacts.LOOKUP_KEY
            }, null, null, null);
            Uri lookupUri = null;
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    final long contactId = cursor.getLong(0);
                    final String lookupKey = cursor.getString(1);
                    return Contacts.getLookupUri(contactId, lookupKey);
                }
            } finally {
                if (cursor != null) cursor.close();
            }
            return lookupUri;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_field = "A68DB3981F299B1118CF3334B426A7DF", hash_generated_field = "95A4534991EE8F72A7FC1C7FC6D1FBD0")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "data");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_field = "4BB0D46792DEAED8332064453D474498", hash_generated_field = "898557BE3B735C302E7B1C4299B53727")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/data";
    }


    
    public final static class RawContactsEntity implements BaseColumns, DataColumns, RawContactsColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_method = "F8C55B41037119D58D30171BDB7F39D2", hash_generated_method = "B8AC49C785E02A24876BA7954CC9671E")
        private  RawContactsEntity() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_field = "30681A7F24E8D588C5F5AFF4143DC7EB", hash_generated_field = "2691991C42B4EBAA7AE90EC64057F986")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "raw_contact_entities");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_field = "BC1FEDC34FAC8E355505C7602BAC09CD", hash_generated_field = "7AE7F53593E48E967334734710332328")

        public static final Uri PROFILE_CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, "raw_contact_entities");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_field = "64305F9BA390EEB87D7228D6C05F2A7C", hash_generated_field = "1D2377EB5383F4BB03D840672D3FA493")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact_entity";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_field = "24D00C5F94A26F6FB45337330B57A1EA", hash_generated_field = "3EEDAB288B134F8C666FC4687FCAE8BB")

        public static final String FOR_EXPORT_ONLY = "for_export_only";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_field = "25A0C98C2CD9718D3437CC55222F352D", hash_generated_field = "BF40874F004CCCDE98B1D602D4FC4265")

        public static final String DATA_ID = "data_id";
    }


    
    public static final class PhoneLookup implements BaseColumns, PhoneLookupColumns, ContactsColumns, ContactOptionsColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_method = "D1B05D947AED4866E4130EF727A894C9", hash_generated_method = "CEF12FA719FCE0616B6F9109D727ED4D")
        private  PhoneLookup() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_field = "3E7C030C6EC42AB67ACEEDAD08E32204", hash_generated_field = "F04B043C3F594CDD163F409C21510A7E")

        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(AUTHORITY_URI,
                "phone_lookup");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_field = "3D5174F8C777CC19D17E37384F43B012", hash_generated_field = "30404B469C9128095296311F42B40FDE")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_lookup";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_field = "09EF30CD83052C0B0D50DEFF5E0500A9", hash_generated_field = "985797C42025450A2C9AB6E09C2F752F")

        public static final String QUERY_PARAMETER_SIP_ADDRESS = "sip";
    }


    
    public static class StatusUpdates implements StatusColumns, PresenceColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_method = "5AF8C140309DC273491B33B4E92E1FA7", hash_generated_method = "F61E7CF0B8D56F58CA9C892D1715AD61")
        private  StatusUpdates() {
            // ---------- Original Method ----------
        }

        
        @DSModeled(DSC.SAFE)
        public static final int getPresenceIconResourceId(int status) {
            switch (status) {
                case AVAILABLE:
                    return android.R.drawable.presence_online;
                case IDLE:
                case AWAY:
                    return android.R.drawable.presence_away;
                case DO_NOT_DISTURB:
                    return android.R.drawable.presence_busy;
                case INVISIBLE:
                    return android.R.drawable.presence_invisible;
                case OFFLINE:
                default:
                    return android.R.drawable.presence_offline;
            }
        }

        
        @DSModeled(DSC.SAFE)
        public static final int getPresencePrecedence(int status) {
            return status;
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "F4F65950342DF7750F23105030366D4E", hash_generated_field = "88E7D9C5C6FEB3AF5270DABBA759AE3A")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "status_updates");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "2C0BA552CDB0DC1BE16712024F13BF37", hash_generated_field = "AA5C18CF423A3168345A85ED05A32992")

        public static final Uri PROFILE_CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, "status_updates");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "DB02AE7CAA27D78DD8F9DE871136A91C", hash_generated_field = "6F3612433DE8232DF53A7F7EA4FCB8B8")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/status-update";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "1A62152FFFDB6D2E376A6B8250D72B6A", hash_generated_field = "FC77E159184ACDCF5CAF4DE0BD2D3C5F")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/status-update";
    }


    
    public static final class Presence extends StatusUpdates {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_method = "FECDF62B9774A3653EF2E5C629F7A49B", hash_generated_method = "FECDF62B9774A3653EF2E5C629F7A49B")
        public Presence ()
        {
            //Synthesized constructor
        }


    }


    
    public static class SearchSnippetColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_method = "04F7D0EC16DDA5BE74B3F08104BE0CC7", hash_generated_method = "04F7D0EC16DDA5BE74B3F08104BE0CC7")
        public SearchSnippetColumns ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "B594A60FB28847C1B35EC0A7E03D9B59", hash_generated_field = "461E02376DD761106C9F50F56F21857C")

        public static final String SNIPPET = "snippet";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "58AD8FAB8BE6F271C2DF2E786D41601C", hash_generated_field = "E4D9391F49F8820BDEAF86A98DC60B19")

        public static final String SNIPPET_ARGS_PARAM_KEY = "snippet_args";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "9ABF073C363816534DE1504629BC5374", hash_generated_field = "541AFA6473BC35F6E27D1822D720D073")

        public static final String DEFERRED_SNIPPETING_KEY = "deferred_snippeting";
    }


    
    public static final class CommonDataKinds {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_method = "3EB47618DCA126249F6622B558B44C8E", hash_generated_method = "17AE15FF7C1A5C629F88953C9F30A23B")
        private  CommonDataKinds() {
            // ---------- Original Method ----------
        }

        
        public static final class StructuredName implements DataColumnsWithJoins {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_method = "3FC3D91ED9F213084C3DE2075E5DC6AD", hash_generated_method = "CE1EF34405CD085F5E1F4B00ACF1AACC")
            private  StructuredName() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "E48860726E4369E589D952284FE70D05", hash_generated_field = "59A4296BAB0F9508FBD1495BE3B9C4C3")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/name";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "9D46F713C646A8F2F8239A312188D6BF", hash_generated_field = "199CF0CE8A05A4E4F7553B6DA8FFD70F")

            public static final String DISPLAY_NAME = DATA1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "4BB2EA79A88E032FCE04BDA12EA4CCCE", hash_generated_field = "7BBF136B8FF9EC2E4C80F2637C98B7DF")

            public static final String GIVEN_NAME = DATA2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "9036549946634CDB85BC23480BBB3435", hash_generated_field = "7AF5C7B7B60F31AAEA9C5C3C0C6022A8")

            public static final String FAMILY_NAME = DATA3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_field = "42AECBAE533C39AC01FE2806EEAA09B5", hash_generated_field = "52881D04085082B470A84A14D73B3891")

            public static final String PREFIX = DATA4;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "3D70CC0E7036E4AD42A7EA106B67F566", hash_generated_field = "C44477DB7B58D73AA74E0EBC13A34C0B")

            public static final String MIDDLE_NAME = DATA5;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "4C0ED506CB62D5C1F597FC7F130B52A5", hash_generated_field = "11F1997DAD362CD7C8F2DBB65FD6F879")

            public static final String SUFFIX = DATA6;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "A4F7A69D9113AD360096FAA94E1C43CB", hash_generated_field = "5466114C91CBE46D3AEE8B69467D4203")

            public static final String PHONETIC_GIVEN_NAME = DATA7;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "B05A81A175D1CCD4C254A2577B7BCA47", hash_generated_field = "A70DED12273525CC3ED65CA485A32BE0")

            public static final String PHONETIC_MIDDLE_NAME = DATA8;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "A868D7FA2BBECFE310B598232128CAA7", hash_generated_field = "4762CC8AA74F9EED4CCF662E97D8F23E")

            public static final String PHONETIC_FAMILY_NAME = DATA9;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "DE361324A00B8077307347970B0BF33E", hash_generated_field = "2072B3FB2A2D770E18E0576BB7E38BFA")

            public static final String FULL_NAME_STYLE = DATA10;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "57484AC2A13AE4D39FCAA45575A84B87", hash_generated_field = "5C4BCAADD6F8F847E0CCFFEAC1EC0894")

            public static final String PHONETIC_NAME_STYLE = DATA11;
        }


        
        public static final class Nickname implements DataColumnsWithJoins, CommonColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_method = "C2B5C7987B903EB42CE1EDEA1961E0EA", hash_generated_method = "32E284B5312A7E0C5334C9B07602E0ED")
            private  Nickname() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "1B92401AC4FC26AF8EED3099399C441D", hash_generated_field = "61FA6F235685467AD2389D2A75A45B85")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/nickname";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "08FEC8A52183CEEBC332F4E7FF61E713", hash_generated_field = "63A550FC2BA734C6B55F4A6D27D4887D")

            public static final int TYPE_DEFAULT = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "0783DE2086801B459CE8B8985E70771F", hash_generated_field = "5BEB78DDADAC164A4025C3E0801CB3FF")

            public static final int TYPE_OTHER_NAME = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "02B9B138B330DE6BF27A522B1C5116C8", hash_generated_field = "E9B965C0FC80530980F6879261036668")

            public static final int TYPE_MAIDEN_NAME = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "7C4A09A174F4372C25A5D9EE447C0EEB", hash_generated_field = "5707A86123371721E285C7469DFFB7EA")

            @Deprecated
            public static final int TYPE_MAINDEN_NAME = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "47692834EDEB1A77B3590E50C4CAA5B0", hash_generated_field = "B2687A5F4C093FA385F5B9B8C23CA053")

            public static final int TYPE_SHORT_NAME = 4;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "BA63DB33288247C8E3808DCF486CBB92", hash_generated_field = "39E86F7F98279CA3EDC3B70DAB31793E")

            public static final int TYPE_INITIALS = 5;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_field = "C33947289F2B4F1EACB5304C45B851F2", hash_generated_field = "67A54ED7C055B5CB080BA7A54DD11740")

            public static final String NAME = DATA;
        }


        
        public static final class Phone implements DataColumnsWithJoins, CommonColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.217 -0400", hash_original_method = "8C72E3409D1DFC404D9CBFEE30B178A0", hash_generated_method = "5D173D82F090B2D243AF646F29A6957E")
            private  Phone() {
                // ---------- Original Method ----------
            }

            
            @Deprecated
            public static final CharSequence getDisplayLabel(Context context, int type,
                    CharSequence label, CharSequence[] labelArray) {
                return getTypeLabel(context.getResources(), type, label);
            }

            
            @Deprecated
            public static final CharSequence getDisplayLabel(Context context, int type,
                    CharSequence label) {
                return getTypeLabel(context.getResources(), type, label);
            }

            
            @DSModeled(DSC.SAFE)
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.phoneTypeHome;
                    case TYPE_MOBILE: return com.android.internal.R.string.phoneTypeMobile;
                    case TYPE_WORK: return com.android.internal.R.string.phoneTypeWork;
                    case TYPE_FAX_WORK: return com.android.internal.R.string.phoneTypeFaxWork;
                    case TYPE_FAX_HOME: return com.android.internal.R.string.phoneTypeFaxHome;
                    case TYPE_PAGER: return com.android.internal.R.string.phoneTypePager;
                    case TYPE_OTHER: return com.android.internal.R.string.phoneTypeOther;
                    case TYPE_CALLBACK: return com.android.internal.R.string.phoneTypeCallback;
                    case TYPE_CAR: return com.android.internal.R.string.phoneTypeCar;
                    case TYPE_COMPANY_MAIN: return com.android.internal.R.string.phoneTypeCompanyMain;
                    case TYPE_ISDN: return com.android.internal.R.string.phoneTypeIsdn;
                    case TYPE_MAIN: return com.android.internal.R.string.phoneTypeMain;
                    case TYPE_OTHER_FAX: return com.android.internal.R.string.phoneTypeOtherFax;
                    case TYPE_RADIO: return com.android.internal.R.string.phoneTypeRadio;
                    case TYPE_TELEX: return com.android.internal.R.string.phoneTypeTelex;
                    case TYPE_TTY_TDD: return com.android.internal.R.string.phoneTypeTtyTdd;
                    case TYPE_WORK_MOBILE: return com.android.internal.R.string.phoneTypeWorkMobile;
                    case TYPE_WORK_PAGER: return com.android.internal.R.string.phoneTypeWorkPager;
                    case TYPE_ASSISTANT: return com.android.internal.R.string.phoneTypeAssistant;
                    case TYPE_MMS: return com.android.internal.R.string.phoneTypeMms;
                    default: return com.android.internal.R.string.phoneTypeCustom;
                }
            }

            
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if ((type == TYPE_CUSTOM || type == TYPE_ASSISTANT) && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "95531BC31452B2F2944FAC00670E72B0", hash_generated_field = "1F223633F2222C03FD7BE22E835FA277")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone_v2";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "63FDF16E999A1FAF191D9EDDE3BC7F45", hash_generated_field = "CE346990F9E7309AEC1D527307A9A9D7")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_v2";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "E349EBCA33148E695F5778985AEFEA1F", hash_generated_field = "A3C4A0040C7B61AF78E856B72C75B080")

            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI,
                    "phones");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "360214B0BB2C841B07FB6C25AC803953", hash_generated_field = "36A83EB7BAEC220CEDCCB9CC5B7F20BE")

            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI,
                    "filter");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "DDC425B3187C54F2CB6D1AEB8138097D", hash_generated_field = "A3AF173E9489DC9819BA4BB309F5F1DB")

            public static final int TYPE_HOME = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "1428FFFB8E2E1698A37F9CAFE838A1E1", hash_generated_field = "59C15403B52E5856C9B5425B13FB5FCF")

            public static final int TYPE_MOBILE = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "D791E2DA20135C970F567401ADAEE06A", hash_generated_field = "F42437B2DE20198D4525BED2BEBA10FC")

            public static final int TYPE_WORK = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "C6D4B82CFA1AFA247228F4E40EA3711A", hash_generated_field = "751A95888571137C3FFE2DA9CED0B977")

            public static final int TYPE_FAX_WORK = 4;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "CE2AEAB86A7C56733FCC31DA01993409", hash_generated_field = "46A5B34BDB146C8870F3F86511087789")

            public static final int TYPE_FAX_HOME = 5;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "A9B3B8EBEF212DA727B65EA3F4F911DA", hash_generated_field = "4C7E69320A068BB5A6836F397BB2426A")

            public static final int TYPE_PAGER = 6;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "FF43014036EA49C2BB3AE5BC0758DD21", hash_generated_field = "577123831D509A76CDF52D19E916C66A")

            public static final int TYPE_OTHER = 7;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "0741B1D994E27BD7434F0CC7EDDEB4B9", hash_generated_field = "9DDEDA6E3B6907EE47B08CD6CE5AED29")

            public static final int TYPE_CALLBACK = 8;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "EC13480EC922A83540094B944A80BCE7", hash_generated_field = "661024FBF57C241DF0C5A76FFC2A23F5")

            public static final int TYPE_CAR = 9;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "51061B5017C7252D4C40EFDE7B117C38", hash_generated_field = "D8CA58F35A9C67F3582BDFD0195395FE")

            public static final int TYPE_COMPANY_MAIN = 10;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "1F098C27E62895D589BB14236BF01F23", hash_generated_field = "9CFAA89CFF2717CF369155C37DDC6A35")

            public static final int TYPE_ISDN = 11;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "5BC99CD3CDB7073D9421A2F7CA74CDDC", hash_generated_field = "6F05CB0439012A900045A1344841ADA8")

            public static final int TYPE_MAIN = 12;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "C616EBB56F4F729E70FCDD24784B6F9E", hash_generated_field = "0ACEEA8EA7D71E0657EAD4E2B3A555D6")

            public static final int TYPE_OTHER_FAX = 13;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "BF98ED72C7D7D07DFA6DA900C1037D19", hash_generated_field = "A13B7512B8541B29A33C9CF6C4B1B66C")

            public static final int TYPE_RADIO = 14;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "C94F0C5ABFB85E4D655EEAFDFD6F8010", hash_generated_field = "6B218ADE8DDF214B32CC4D34E4329D92")

            public static final int TYPE_TELEX = 15;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "887701E5076AEAC714E420FA0221EC67", hash_generated_field = "F133FC8F561875305EE7596E2F9358BF")

            public static final int TYPE_TTY_TDD = 16;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "DE08311AC9295B98B088E43820F837FE", hash_generated_field = "2C192DF713982E5DB1CA3F959D993229")

            public static final int TYPE_WORK_MOBILE = 17;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "F08880D1B93E3E891E3BD67779BE5D52", hash_generated_field = "C8982DE53EEDC39F82E0E2EF90596E94")

            public static final int TYPE_WORK_PAGER = 18;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "FBAA16181A086E896E6C6860D3F4343D", hash_generated_field = "1E077665ECD4EECB50E467EC8ED42502")

            public static final int TYPE_ASSISTANT = 19;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "C61DC833E138E8C19509B4421E39ED38", hash_generated_field = "0A46A0C2A54F25F4912D3DF48662F52A")

            public static final int TYPE_MMS = 20;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "8E8FB2D516E91E45926F6D1FA5EEA5F5", hash_generated_field = "763AA2823695116F08461425F9A567EE")

            public static final String NUMBER = DATA;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.218 -0400", hash_original_field = "674C1D27A91C81BC5D5730E407EA5543", hash_generated_field = "13CF46B172BA5FE696B962CC830E16EE")

            public static final String NORMALIZED_NUMBER = DATA4;
        }


        
        public static final class Email implements DataColumnsWithJoins, CommonColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_method = "4685E1971C120F244FF83B34E469953F", hash_generated_method = "AE4BB686E4A7B4068C4E01F323C0B09B")
            private  Email() {
                // ---------- Original Method ----------
            }

            
            @DSModeled(DSC.SAFE)
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.emailTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.emailTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.emailTypeOther;
                    case TYPE_MOBILE: return com.android.internal.R.string.emailTypeMobile;
                    default: return com.android.internal.R.string.emailTypeCustom;
                }
            }

            
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "6E1C5970BE33EC2B9FB795FD4B265F92", hash_generated_field = "859AE736BCEA751F7D5A4255E7468689")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/email_v2";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "661754408CFF9A16E3B8C9B7733C6555", hash_generated_field = "DFB2AE964F2A2E489B2D416608B726EE")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/email_v2";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "D92B6C870CDB4C82D54FF3D65F635B34", hash_generated_field = "E81312BCB9EF776662A7563ECD1DB7CF")

            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI,
                    "emails");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "B2386446D617C4FF72800940ABB8C302", hash_generated_field = "F94DD7AE0907A95C5597A5A8773EE09E")

            public static final Uri CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI,
                    "lookup");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "360214B0BB2C841B07FB6C25AC803953", hash_generated_field = "36A83EB7BAEC220CEDCCB9CC5B7F20BE")

            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI,
                    "filter");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "791BD4CB4C21C850BF53C2E73FE1E64A", hash_generated_field = "A407FB0B080749617A815C9A1E4D13E3")

            public static final String ADDRESS = DATA1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "DDC425B3187C54F2CB6D1AEB8138097D", hash_generated_field = "A3AF173E9489DC9819BA4BB309F5F1DB")

            public static final int TYPE_HOME = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "3E6BDFBAE7CF790219B58D032167022B", hash_generated_field = "2DD1E25E0D1B8108129E5DFF1326B779")

            public static final int TYPE_WORK = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "508A0D310A5C7FFF1BBDE74D2C450982", hash_generated_field = "94C57AEAC00AEFAA44100B03BD71282D")

            public static final int TYPE_OTHER = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "BA063CD1675AFA85DA8C650E9AFADDAE", hash_generated_field = "6984B984CEB5361E741B06CEA68F16ED")

            public static final int TYPE_MOBILE = 4;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_field = "9FDF42A0203A5935C80CDC6919181BEA", hash_generated_field = "BFEE09F4055CB889385B9BFCBA46DC2D")

            public static final String DISPLAY_NAME = DATA4;
        }


        
        public static final class StructuredPostal implements DataColumnsWithJoins, CommonColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.219 -0400", hash_original_method = "C8D888449545672CEC46DD26E7BDDD9A", hash_generated_method = "6863A6EEFAC7C6659E60E563C7E51932")
            private  StructuredPostal() {
                // ---------- Original Method ----------
            }

            
            @DSModeled(DSC.SAFE)
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.postalTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.postalTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.postalTypeOther;
                    default: return com.android.internal.R.string.postalTypeCustom;
                }
            }

            
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "6AF55D80DC5654FCA09610FC2A3C99AF", hash_generated_field = "506F3DF14715DE60E1EE345A9D9B1887")

            public static final String CONTENT_ITEM_TYPE =
                    "vnd.android.cursor.item/postal-address_v2";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "953F6D2D36502411FC91B0E9118B3E58", hash_generated_field = "250D9641BB264121C8BBE97B69EC3C35")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/postal-address_v2";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "AA611ED5FE4135BDD8525083C6D82415", hash_generated_field = "EA13E315BE511D054D222ACD02E20571")

            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI,
                    "postals");
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "DDC425B3187C54F2CB6D1AEB8138097D", hash_generated_field = "A3AF173E9489DC9819BA4BB309F5F1DB")

            public static final int TYPE_HOME = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "3E6BDFBAE7CF790219B58D032167022B", hash_generated_field = "2DD1E25E0D1B8108129E5DFF1326B779")

            public static final int TYPE_WORK = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "508A0D310A5C7FFF1BBDE74D2C450982", hash_generated_field = "94C57AEAC00AEFAA44100B03BD71282D")

            public static final int TYPE_OTHER = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "270EF0267CE9354575FA61DAEBC4BA5B", hash_generated_field = "E6B81BFAC39F0EBEB8AFA77FA0DAA6D5")

            public static final String FORMATTED_ADDRESS = DATA;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "E0B5DBED35A34601E245A6687A11C937", hash_generated_field = "FC5DA379BEAF181A7DB3853C3E5C84C5")

            public static final String STREET = DATA4;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "B24B81754DE55470B15FB028A0EF936D", hash_generated_field = "5B40BB3B0E58715D304D41E449168D73")

            public static final String POBOX = DATA5;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "3606CEE10A39EF3D7B1558B4AD5BEC8C", hash_generated_field = "FD16B689529DE12FA631A1AC46E14071")

            public static final String NEIGHBORHOOD = DATA6;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "AA967309C7605D595DE81E1431CA406D", hash_generated_field = "387FC24F3974E2E0B797750B8D0E49E6")

            public static final String CITY = DATA7;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "5379B524F1ABB819B0E4C9C9FB8B41D9", hash_generated_field = "7BCD31F69D04787416C5CBE16DCA99ED")

            public static final String REGION = DATA8;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "1A575173056A422C8FDA444FBFBAF88E", hash_generated_field = "F2AAF6F03FE137988D0283DD701017D0")

            public static final String POSTCODE = DATA9;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.220 -0400", hash_original_field = "0361E72E50A1E2AC6C00246CC5F21F49", hash_generated_field = "8D26203B337243A482D81E02769EFB43")

            public static final String COUNTRY = DATA10;
        }


        
        public static final class Im implements DataColumnsWithJoins, CommonColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.221 -0400", hash_original_method = "7F43853CDED9232ACA3765709B5C5CC7", hash_generated_method = "3D120A0520BAC27E9D81D0F0F88DB3FD")
            private  Im() {
                // ---------- Original Method ----------
            }

            
            @DSModeled(DSC.SAFE)
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.imTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.imTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.imTypeOther;
                    default: return com.android.internal.R.string.imTypeCustom;
                }
            }

            
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            @DSModeled(DSC.SAFE)
            public static final int getProtocolLabelResource(int type) {
                switch (type) {
                    case PROTOCOL_AIM: return com.android.internal.R.string.imProtocolAim;
                    case PROTOCOL_MSN: return com.android.internal.R.string.imProtocolMsn;
                    case PROTOCOL_YAHOO: return com.android.internal.R.string.imProtocolYahoo;
                    case PROTOCOL_SKYPE: return com.android.internal.R.string.imProtocolSkype;
                    case PROTOCOL_QQ: return com.android.internal.R.string.imProtocolQq;
                    case PROTOCOL_GOOGLE_TALK: return com.android.internal.R.string.imProtocolGoogleTalk;
                    case PROTOCOL_ICQ: return com.android.internal.R.string.imProtocolIcq;
                    case PROTOCOL_JABBER: return com.android.internal.R.string.imProtocolJabber;
                    case PROTOCOL_NETMEETING: return com.android.internal.R.string.imProtocolNetMeeting;
                    default: return com.android.internal.R.string.imProtocolCustom;
                }
            }

            
            public static final CharSequence getProtocolLabel(Resources res, int type,
                    CharSequence label) {
                if (type == PROTOCOL_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getProtocolLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.221 -0400", hash_original_field = "40CD849EE4C5B43EDD80661A4E8F5132", hash_generated_field = "5AE10DBF88AB44FC5E4D010123E19E32")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/im";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.221 -0400", hash_original_field = "DDC425B3187C54F2CB6D1AEB8138097D", hash_generated_field = "A3AF173E9489DC9819BA4BB309F5F1DB")

            public static final int TYPE_HOME = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.221 -0400", hash_original_field = "3E6BDFBAE7CF790219B58D032167022B", hash_generated_field = "2DD1E25E0D1B8108129E5DFF1326B779")

            public static final int TYPE_WORK = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.221 -0400", hash_original_field = "508A0D310A5C7FFF1BBDE74D2C450982", hash_generated_field = "94C57AEAC00AEFAA44100B03BD71282D")

            public static final int TYPE_OTHER = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.221 -0400", hash_original_field = "A2D7561D5B9C4AC0C166970736869FF1", hash_generated_field = "A6C5404E24EA595BEE495F79D3BDC24F")

            public static final String PROTOCOL = DATA5;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "B2A3856ECF05798E74A7E34BF16A75FD", hash_generated_field = "FAEDCA70ABBB2BB6E8F02D0CA58AB92D")

            public static final String CUSTOM_PROTOCOL = DATA6;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "C7118D114B60AC3626698190F3CC68BF", hash_generated_field = "F9A89D2E95B56F6CF27905C9AF3BEF7C")

            public static final int PROTOCOL_CUSTOM = -1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "78C6D35977A891DE3665B9F1F950141C", hash_generated_field = "B8DD27EB4EB2987356C26B9B2248736B")

            public static final int PROTOCOL_AIM = 0;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "311403E66F28494A32BED88E16FB4BE8", hash_generated_field = "86D6D26C03884E1639863C42F131CB0F")

            public static final int PROTOCOL_MSN = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "C1CA61239451035D4D8A344ACBF163DC", hash_generated_field = "6EB61BBD5E00F25A9307ABB0B706728A")

            public static final int PROTOCOL_YAHOO = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "C3719A096786B9C9181FCFBF549FCED9", hash_generated_field = "583FE8AF1BD41C5351AF4DC35E6A1742")

            public static final int PROTOCOL_SKYPE = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "B342E0C0E93EDFEF1746942A34DA4174", hash_generated_field = "392A2A35FFDAAB82979EC983264EA5F1")

            public static final int PROTOCOL_QQ = 4;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "11A2907CB4D1ECDE73E5031A56F3CC5F", hash_generated_field = "97B523ACF7ACE08369AC0A88E0EF61BB")

            public static final int PROTOCOL_GOOGLE_TALK = 5;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "8202593655107BD41A3A1403857849FF", hash_generated_field = "7E3934A9EB761B183D6ED91C9B12998C")

            public static final int PROTOCOL_ICQ = 6;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "A5D3C52882F414D055BDE44504230919", hash_generated_field = "1380DF6511E089CF45957B47807306EF")

            public static final int PROTOCOL_JABBER = 7;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.222 -0400", hash_original_field = "B53E2C42666A326D1E856CE70DB9FB70", hash_generated_field = "EF4F0A0008F96A206B3AAB3594BF8432")

            public static final int PROTOCOL_NETMEETING = 8;
        }


        
        public static final class Organization implements DataColumnsWithJoins, CommonColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_method = "DB9E0507E0CFF6D3A6878FC813F638FB", hash_generated_method = "24D678582F58DD0084445608A443E82F")
            private  Organization() {
                // ---------- Original Method ----------
            }

            
            @DSModeled(DSC.SAFE)
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_WORK: return com.android.internal.R.string.orgTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.orgTypeOther;
                    default: return com.android.internal.R.string.orgTypeCustom;
                }
            }

            
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "DC6D7B354F7D94CB2E4A9336F8BACF25", hash_generated_field = "6CF7C5A6292394C36147458C0D450BCF")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/organization";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "A7881C6EE97FB5FC305A7BC43C9758EA", hash_generated_field = "9660B9049AFB5B9EFB571676569F6154")

            public static final int TYPE_WORK = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "54E1D37EE6AAB1B59A36AA31806D419D", hash_generated_field = "7CCF7EE2A0268E7232DBAAB3B7AFBF8C")

            public static final int TYPE_OTHER = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "76BAF98BE1B93C4C53C39B455850B93C", hash_generated_field = "B1B6E1201E7B503C148BB63BDE25ECE8")

            public static final String COMPANY = DATA;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "D89A3553C8172952B0B679223252B9B8", hash_generated_field = "40AC28C6DA79391B539F4068DA2CDCE0")

            public static final String TITLE = DATA4;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "65165D8DEED5A768FF2D125210971986", hash_generated_field = "FC45AB7F87492643E52B634F1F69473E")

            public static final String DEPARTMENT = DATA5;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "5EE9A0A87A4F271B46A58E65EE2BD8EB", hash_generated_field = "F77DED9478C56A1DD5A0E3696D945BA1")

            public static final String JOB_DESCRIPTION = DATA6;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "28FBF01C35A59978F194646B78C4D9C0", hash_generated_field = "C63E4734BFB73C8BEEB1613C3CAA7CA9")

            public static final String SYMBOL = DATA7;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "B84BCA93685D67E846101D618A1B2D8D", hash_generated_field = "F76E1A94B2DC0956CC44630A309473C4")

            public static final String PHONETIC_NAME = DATA8;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "9B5DC7B58C5B9DD2C36B4FCBB5CDEAD1", hash_generated_field = "F45F12923FC3A5FF5E13A863D6CADFFD")

            public static final String OFFICE_LOCATION = DATA9;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.223 -0400", hash_original_field = "5F4CCABB76D6EC251BF7D42A52FEABD0", hash_generated_field = "AF6563F13F3A3A61AD829FC6FAE912E9")

            public static final String PHONETIC_NAME_STYLE = DATA10;
        }


        
        public static final class Relation implements DataColumnsWithJoins, CommonColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.224 -0400", hash_original_method = "AB820511C2318175DFB023ADDE00500D", hash_generated_method = "004DD1D842B963562C78785064E7989B")
            private  Relation() {
                // ---------- Original Method ----------
            }

            
            @DSModeled(DSC.SAFE)
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_ASSISTANT: return com.android.internal.R.string.relationTypeAssistant;
                    case TYPE_BROTHER: return com.android.internal.R.string.relationTypeBrother;
                    case TYPE_CHILD: return com.android.internal.R.string.relationTypeChild;
                    case TYPE_DOMESTIC_PARTNER:
                            return com.android.internal.R.string.relationTypeDomesticPartner;
                    case TYPE_FATHER: return com.android.internal.R.string.relationTypeFather;
                    case TYPE_FRIEND: return com.android.internal.R.string.relationTypeFriend;
                    case TYPE_MANAGER: return com.android.internal.R.string.relationTypeManager;
                    case TYPE_MOTHER: return com.android.internal.R.string.relationTypeMother;
                    case TYPE_PARENT: return com.android.internal.R.string.relationTypeParent;
                    case TYPE_PARTNER: return com.android.internal.R.string.relationTypePartner;
                    case TYPE_REFERRED_BY:
                            return com.android.internal.R.string.relationTypeReferredBy;
                    case TYPE_RELATIVE: return com.android.internal.R.string.relationTypeRelative;
                    case TYPE_SISTER: return com.android.internal.R.string.relationTypeSister;
                    case TYPE_SPOUSE: return com.android.internal.R.string.relationTypeSpouse;
                    default: return com.android.internal.R.string.orgTypeCustom;
                }
            }

            
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.225 -0400", hash_original_field = "F8F1AEA207BCFDD3C031F5943FC0F195", hash_generated_field = "4E5D41A571D152AF86A5F2E8DF941EB4")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/relation";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.225 -0400", hash_original_field = "6FE3D96A4D41725CE443291EAA4CB458", hash_generated_field = "6554B25D5A397416DB3C3322C813D334")

            public static final int TYPE_ASSISTANT = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.225 -0400", hash_original_field = "E3B4F9DA99BD8CC9062CEC2E7B78EC86", hash_generated_field = "B61CACD4D50D7C4ED812B6B430BAE236")

            public static final int TYPE_BROTHER = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.225 -0400", hash_original_field = "6EBCDA0E5F761B832459005ECBDFB08C", hash_generated_field = "E8FFBDD9437A8331AC45B5B86A546369")

            public static final int TYPE_CHILD = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.225 -0400", hash_original_field = "A4532A33C5CAD76CBA0E512B943490EF", hash_generated_field = "9206111E455AC5F7CDACEE6CDEEB3CED")

            public static final int TYPE_DOMESTIC_PARTNER = 4;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.225 -0400", hash_original_field = "68259907CBE44CCF2C4F5A1561A31CCD", hash_generated_field = "F7FCB8879EF9D2B817AB53113A7B6F9A")

            public static final int TYPE_FATHER = 5;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "43098626B80FA86B758B69342A68EDB0", hash_generated_field = "913615C87DB7D403162A82B3EE27F751")

            public static final int TYPE_FRIEND = 6;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "030B03F7710212DD846894B72527C4BC", hash_generated_field = "E9DD5E4041B5A4AACDE6CFDF9EFD9D7E")

            public static final int TYPE_MANAGER = 7;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "6A0850F753DFEF66892BE0435F1D9178", hash_generated_field = "37090E74FD34ABDA4E42D47B1C53E8AE")

            public static final int TYPE_MOTHER = 8;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "E0DD382552740F5548FEF9CD3C54577F", hash_generated_field = "FD8380616122869215F8FD0C939F893F")

            public static final int TYPE_PARENT = 9;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "C1E1EC3C9391B779441B92F042A0603F", hash_generated_field = "1E64D7DF300B14229B08923EFE993884")

            public static final int TYPE_PARTNER = 10;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "6F88F3C216085B493F85A89A3A048425", hash_generated_field = "83C2C6B071FC6373ED701A8C213E6344")

            public static final int TYPE_REFERRED_BY = 11;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "19A95BADC33320B1F80341A251E5D944", hash_generated_field = "F42AEAB2AA5368B916C63AEF6E2EC7DA")

            public static final int TYPE_RELATIVE = 12;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "31C8507AD3AA57FC11E8CB2393C8EA12", hash_generated_field = "09DC0B2D63B8996CCF45B1E3533A24CF")

            public static final int TYPE_SISTER = 13;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "AAEEFD89C5B7A0313A054CBA0F1F6F5E", hash_generated_field = "8530AFDB8E33B30C49384B667B586394")

            public static final int TYPE_SPOUSE = 14;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "C33947289F2B4F1EACB5304C45B851F2", hash_generated_field = "67A54ED7C055B5CB080BA7A54DD11740")

            public static final String NAME = DATA;
        }


        
        public static final class Event implements DataColumnsWithJoins, CommonColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_method = "D3DDD15A13BA6EC1D9CD48C2CCCFE0B4", hash_generated_method = "F9069AC01DFBB6E335236591397070B2")
            private  Event() {
                // ---------- Original Method ----------
            }

            
            public static int getTypeResource(Integer type) {
                if (type == null) {
                    return com.android.internal.R.string.eventTypeOther;
                }
                switch (type) {
                    case TYPE_ANNIVERSARY:
                        return com.android.internal.R.string.eventTypeAnniversary;
                    case TYPE_BIRTHDAY: return com.android.internal.R.string.eventTypeBirthday;
                    case TYPE_OTHER: return com.android.internal.R.string.eventTypeOther;
                    default: return com.android.internal.R.string.eventTypeCustom;
                }
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.226 -0400", hash_original_field = "B6C1278D9234E669D815973521FE3B04", hash_generated_field = "13ADF6BD54B9E1950C209A233DAB1746")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_event";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_field = "40ECAAD956031DFA8EC6681C66E606FC", hash_generated_field = "99D50BA6A478BE143E64916539BE6610")

            public static final int TYPE_ANNIVERSARY = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_field = "54E1D37EE6AAB1B59A36AA31806D419D", hash_generated_field = "7CCF7EE2A0268E7232DBAAB3B7AFBF8C")

            public static final int TYPE_OTHER = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_field = "0742119C5281926A20000F716F077E50", hash_generated_field = "AE7A10B3955E730B100FBBC0B8A83A1D")

            public static final int TYPE_BIRTHDAY = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_field = "08A0C8943119417B126D9E2662AF50F5", hash_generated_field = "552453D11E30C9D7C1326C394FAF97D3")

            public static final String START_DATE = DATA;
        }


        
        public static final class Photo implements DataColumnsWithJoins {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_method = "C03E3395BFF21729CC93322BBC7A82DE", hash_generated_method = "6353485435339DC025174C823A75D00F")
            private  Photo() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_field = "108C3814484D1389689A5E0224015D2A", hash_generated_field = "C34ED4BEFD8F1C45F4DCBAB84FC48D97")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/photo";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_field = "D788C6AA077DFD01FC513679BA93D4DF", hash_generated_field = "827F52308AEA6086917181CAD2690C59")

            public static final String PHOTO_FILE_ID = DATA14;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_field = "906C07610AAC15FC6A2F6263527EC4C4", hash_generated_field = "2769AC225261CB92B8111CE835D1CB36")

            public static final String PHOTO = DATA15;
        }


        
        public static final class Note implements DataColumnsWithJoins {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.228 -0400", hash_original_method = "EBAE52FCFF9289B17EA2262C75B6F6C0", hash_generated_method = "22ECB65A834798A58E72F146C908C2C8")
            private  Note() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.228 -0400", hash_original_field = "B835851426E6616E29FFC3512438E59A", hash_generated_field = "23539A67AEC2F9B933722A9B0A7EDBEA")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/note";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.228 -0400", hash_original_field = "3A662670BDF0A0D9E123C855D11C90E6", hash_generated_field = "EC62015EBAD227624690D8E86B66BFB6")

            public static final String NOTE = DATA1;
        }


        
        public static final class GroupMembership implements DataColumnsWithJoins {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.228 -0400", hash_original_method = "9948141C64D53CA8E17E7FD2EBA08DA8", hash_generated_method = "428CD6B4AF8D64BBC7FE2E70673D8538")
            private  GroupMembership() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.228 -0400", hash_original_field = "34D8EFFB05767572A50EFA9359DE62F4", hash_generated_field = "41F1E4E66419A7D4F47D102CBE7A7906")

            public static final String CONTENT_ITEM_TYPE =
                    "vnd.android.cursor.item/group_membership";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.228 -0400", hash_original_field = "F54C5F4067DDCD605B9400556D55DC85", hash_generated_field = "950F102D48B72425FE7A6D958C1A6B9D")

            public static final String GROUP_ROW_ID = DATA1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.228 -0400", hash_original_field = "DD44C320C12F60FD49CB3E0691F03303", hash_generated_field = "92D833373693D090B03089F36A6F98D3")

            public static final String GROUP_SOURCE_ID = "group_sourceid";
        }


        
        public static final class Website implements DataColumnsWithJoins, CommonColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_method = "CC2DAF060546DD565E4193F5085BC2F2", hash_generated_method = "95610DE2A4CA3A3ED50311363B3F2A27")
            private  Website() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_field = "7671DE6495396EE7AF7C56361E4B7B3C", hash_generated_field = "507B8C53AF67D95DEBE883A04CF7EF7E")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/website";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_field = "D05C9BC459BCAC95DE6429154C17F2FB", hash_generated_field = "4B468C40319D845407892D3884823FA4")

            public static final int TYPE_HOMEPAGE = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_field = "8FCA07D90E4FD1DC7D5B663D043CAC28", hash_generated_field = "58D108F8912D098F80EDD36B2E85E3A7")

            public static final int TYPE_BLOG = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_field = "42E6D3BC5AC945072F9AB7C8D1228F2C", hash_generated_field = "D8F6248DB8467C72A5CAE2A75289C796")

            public static final int TYPE_PROFILE = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_field = "F9548672EEC4B42F8C805AA845A23F79", hash_generated_field = "70FE66EBFDC21B03CAA0A040A2913B61")

            public static final int TYPE_HOME = 4;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_field = "D648BD11AAACD8871993FC9BADC31BCA", hash_generated_field = "0A4BCA99BAC8DDD8AA17AABB5864C924")

            public static final int TYPE_WORK = 5;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_field = "88A68545E8D866FD6BF330AF113F2282", hash_generated_field = "C2132BF3D75834282FC3009303F52815")

            public static final int TYPE_FTP = 6;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_field = "FF43014036EA49C2BB3AE5BC0758DD21", hash_generated_field = "577123831D509A76CDF52D19E916C66A")

            public static final int TYPE_OTHER = 7;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_field = "3B051A36EE149BD887C1B2170978F99D", hash_generated_field = "98433BB6A8DFF48B3096C8EB5C97A0B2")

            public static final String URL = DATA;
        }


        
        public static final class SipAddress implements DataColumnsWithJoins, CommonColumns {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.229 -0400", hash_original_method = "7307A74E42B27B76827D43357DA8B367", hash_generated_method = "EF707E530C2FC911E23A8D91CEFB5F2B")
            private  SipAddress() {
                // ---------- Original Method ----------
            }

            
            @DSModeled(DSC.SAFE)
            public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.sipAddressTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.sipAddressTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.sipAddressTypeOther;
                    default: return com.android.internal.R.string.sipAddressTypeCustom;
                }
            }

            
            public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.230 -0400", hash_original_field = "607D4C848A3A6298D8C70079F0B72F12", hash_generated_field = "B36DDF74326B8C6C04710188847C6605")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/sip_address";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.230 -0400", hash_original_field = "DDC425B3187C54F2CB6D1AEB8138097D", hash_generated_field = "A3AF173E9489DC9819BA4BB309F5F1DB")

            public static final int TYPE_HOME = 1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.230 -0400", hash_original_field = "3E6BDFBAE7CF790219B58D032167022B", hash_generated_field = "2DD1E25E0D1B8108129E5DFF1326B779")

            public static final int TYPE_WORK = 2;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.231 -0400", hash_original_field = "508A0D310A5C7FFF1BBDE74D2C450982", hash_generated_field = "94C57AEAC00AEFAA44100B03BD71282D")

            public static final int TYPE_OTHER = 3;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.231 -0400", hash_original_field = "F21973A3383E4E8E095AB9601B4AA6DB", hash_generated_field = "EDC6BFD3EC96B3DE913728DAB1E5F6D2")

            public static final String SIP_ADDRESS = DATA1;
        }


        
        public static final class Identity implements DataColumnsWithJoins {
            
            @DSModeled(DSC.BAN)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.231 -0400", hash_original_method = "CB97BE8665681C1FD82290A9CE03A1A5", hash_generated_method = "EAF95E91D3C42B1A473D86AA0DA890E2")
            private  Identity() {
                // ---------- Original Method ----------
            }

            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.231 -0400", hash_original_field = "898CD9780D6244ED10E073B9FA505F4C", hash_generated_field = "64AD89413B11D3AEAD2077978B7601E3")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/identity";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.231 -0400", hash_original_field = "672B79E96496FE2EDB15C1A8A7AA7424", hash_generated_field = "CC7C1F53A356A0D5518447F250F0D53E")

            public static final String IDENTITY = DataColumns.DATA1;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.231 -0400", hash_original_field = "79299E54E8ED1378D1467AF8B9DBB9D2", hash_generated_field = "EE3F90B3EC2DE6F57CAE0418DE02AA14")

            public static final String NAMESPACE = DataColumns.DATA2;
        }


        
        public interface BaseTypes {
            
            public static int TYPE_CUSTOM = 0;
        }
        
        protected interface CommonColumns extends BaseTypes {
            
            public static final String DATA = DataColumns.DATA1;

            
            public static final String TYPE = DataColumns.DATA2;

            
            public static final String LABEL = DataColumns.DATA3;
        }
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.231 -0400", hash_original_field = "A3458E7FC783A738C94305F84EDE0AA3", hash_generated_field = "32BD4CF7EC356B02DEA3FD704AF6D66A")

        public static final String PACKAGE_COMMON = "common";
    }


    
    public static final class Groups implements BaseColumns, GroupsColumns, SyncColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.231 -0400", hash_original_method = "7BA2DC4B038FD72F399C633B1C4B5B34", hash_generated_method = "4AF005563E89F66C166EA0E603C46AC1")
        private  Groups() {
            // ---------- Original Method ----------
        }

        
        public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }

        
        private static class EntityIteratorImpl extends CursorEntityIterator {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.232 -0400", hash_original_method = "5371E683B36CD927F8174DD86149D4D5", hash_generated_method = "DE3E062D3600C23F52B9400031643F33")
            public  EntityIteratorImpl(Cursor cursor) {
                super(cursor);
                addTaint(cursor.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.232 -0400", hash_original_method = "DDAF6836AC46D694049E3DD971FAB2B5", hash_generated_method = "329BAF29F669B8C9170B620BCA88EF47")
            @Override
            public Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                addTaint(cursor.getTaint());
                final ContentValues values = new ContentValues();
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, values, _ID);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, ACCOUNT_NAME);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, ACCOUNT_TYPE);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, values, DIRTY);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, values, VERSION);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SOURCE_ID);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, RES_PACKAGE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, TITLE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, TITLE_RES);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, values, GROUP_VISIBLE);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SYNC1);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SYNC2);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SYNC3);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SYNC4);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SYSTEM_ID);
                DatabaseUtils.cursorLongToContentValuesIfPresent(cursor, values, DELETED);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, NOTES);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, SHOULD_SYNC);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, FAVORITES);
                DatabaseUtils.cursorStringToContentValuesIfPresent(cursor, values, AUTO_ADD);
                cursor.moveToNext();
Entity var92EE06D7E20FFC20F10BCB97642B6634_1564253429 =                 new Entity(values);
                var92EE06D7E20FFC20F10BCB97642B6634_1564253429.addTaint(taint);
                return var92EE06D7E20FFC20F10BCB97642B6634_1564253429;
                // ---------- Original Method ----------
                // Original Method Too Long, Refer to Original Implementation
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.233 -0400", hash_original_field = "ECD2E60B9DF467C703329383F6027C77", hash_generated_field = "D4801B6081B952E0603E20F18A0054D9")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "groups");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.233 -0400", hash_original_field = "48160C58A28F58CBA98DF74A9A982610", hash_generated_field = "942A584E46BF9673669BA2AFA76C33B4")

        public static final Uri CONTENT_SUMMARY_URI = Uri.withAppendedPath(AUTHORITY_URI,
                "groups_summary");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.233 -0400", hash_original_field = "B9C994DEDC50E30D046B0BA796002A4A", hash_generated_field = "0EC0CF3497BDF1BB86BB3A5A54990DE9")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/group";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.233 -0400", hash_original_field = "E810EAAC12958CF927BD80D557647BE1", hash_generated_field = "128B87F0EE45853848DC0A95B769065A")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group";
    }


    
    public static final class AggregationExceptions implements BaseColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.233 -0400", hash_original_method = "AEC5F5D30A84CFEC2D9D1903833FB78B", hash_generated_method = "ED7E5F4AC17489A373923084FD271B08")
        private  AggregationExceptions() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.235 -0400", hash_original_field = "347DE0797258DB403DBABFBCC2EE2FFD", hash_generated_field = "F86DA92AB1515A0E704AF3BCD078F82E")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "aggregation_exceptions");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "41118AC98EB3D042B64A78FFA83F306B", hash_generated_field = "335944C29ADD9F124487936BCD4DE433")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/aggregation_exception";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "2C8C60DC7A15A8AF240C44F2E87A84FD", hash_generated_field = "900F3136060C7C97AC7604F66C067B8C")

        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/aggregation_exception";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "3A93FC6551B100BB870FF7F82CF9B7F1", hash_generated_field = "A5BA88997B8C56325DBFED26CDB34D93")

        public static final String TYPE = "type";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "BD5BDCBA66B122F6E18A5CE8C9150564", hash_generated_field = "E56696B09504EE3DFDFB695D81A43F8B")

        public static final int TYPE_AUTOMATIC = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "C0082C4A2B8A6DD3DAD83C17113275FB", hash_generated_field = "750C706133E5F058528F0960AD5007D4")

        public static final int TYPE_KEEP_TOGETHER = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "6CD62262C25BE93FECE282A4457465A1", hash_generated_field = "5B852A127CE9BA8B9BE00C6D1C62443D")

        public static final int TYPE_KEEP_SEPARATE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "9EBA386310F3F8C7B838111305FEE34B", hash_generated_field = "2F0AC6185A1AD918EC1F8F2F77B690D8")

        public static final String RAW_CONTACT_ID1 = "raw_contact_id1";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "C82C80711BDC5ED52E2E64CE0D2ACA40", hash_generated_field = "E39C007547AB033EB16C5E3F5746BDDE")

        public static final String RAW_CONTACT_ID2 = "raw_contact_id2";
    }


    
    public static final class Settings implements SettingsColumns {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "2C16D3C86A761A9DF5E58231442F813C")
        private  Settings() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "C4C43E73659E4B461BEA20ECD306D47C", hash_generated_field = "C7297F3C14DD54EEFD43481001C6C3EF")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "settings");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "4EA6B277ADAB94D8F6051E37AF7025E1", hash_generated_field = "566EDD5F86E709EDFF0FA0F33906F1C8")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/setting";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_field = "CFDDC8B77A797F98BA5A162648C9FC27", hash_generated_field = "8429EA23022F638512AC4FDE82638297")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/setting";
    }


    
    public static final class ProviderStatus {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.236 -0400", hash_original_method = "795A4A88B7E0FFCBF277CCA1899F11E6", hash_generated_method = "31F9DB0C46ADEE3AB9E7AC4FBB60BDC4")
        private  ProviderStatus() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "CA67288442F12C42D6E800E26682657D", hash_generated_field = "A89A4C9F120D91C22EB2526376E866F4")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "provider_status");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "621662105B66D4FB1EF4BF00D73F0B9B", hash_generated_field = "2FDC129A2AFCD846C1691664B4F7661D")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/provider_status";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "4470B235917F5E7BC6E479F0467667FD", hash_generated_field = "0F92DE669937BAC9213CDB00849C0B4A")

        public static final String STATUS = "status";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "31B0E0FB69217918ECADE4BE52AF1B10", hash_generated_field = "2098F70EC5539CDFD7D860EDCCFDED4B")

        public static final int STATUS_NORMAL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "F757EFA33CAD77CBAB273BD671079BF0", hash_generated_field = "BC21A54635F877D1AA2A465423E81165")

        public static final int STATUS_UPGRADING = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "B5FB5E59634A16CC1525E8E551EB9D15", hash_generated_field = "54B07C94F842C6A6A2490D9540FEBE04")

        public static final int STATUS_UPGRADE_OUT_OF_MEMORY = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "9680357346C183C2DA5E7783A646C946", hash_generated_field = "DDC591651844404039FB85E2D89F15F4")

        public static final int STATUS_CHANGING_LOCALE = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "586D1B7AF4D1FFFD32D439E46FA8A76E", hash_generated_field = "3253D76A0E9FDB3D3974E44CAD97F1CB")

        public static final int STATUS_NO_ACCOUNTS_NO_CONTACTS = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "E156FD5665DAE883EA3B1DD868FAD471", hash_generated_field = "CB69AC0B118F400C258B30132CBFEE54")

        public static final String DATA1 = "data1";
    }


    
    public static final class DataUsageFeedback {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_method = "63E5D1CFF9704764CDDB806EEC1367A5", hash_generated_method = "63E5D1CFF9704764CDDB806EEC1367A5")
        public DataUsageFeedback ()
        {
            //Synthesized constructor
        }


        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "10622FE01E4EF97296ACD1F51AEA90A1", hash_generated_field = "1F2BD7BA06A038CD74DF13781A946524")

        public static final Uri FEEDBACK_URI =
                Uri.withAppendedPath(Data.CONTENT_URI, "usagefeedback");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "760BF7B0235F6927A5EBAF2F98A63E7F", hash_generated_field = "2587BB10584ACB58BBE60035A5018DEC")

        public static final String USAGE_TYPE = "type";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "570F935CDB3A15ACB4F0FBFB6A22CE2D", hash_generated_field = "ECD9489EA14B476209689DD885967B22")

        public static final String USAGE_TYPE_CALL = "call";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_field = "0031520C10048B8A612DCEDB3FA20183", hash_generated_field = "593ED32C4C11580B3A149DA1985A8380")

        public static final String USAGE_TYPE_LONG_TEXT = "long_text";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.238 -0400", hash_original_field = "DFDD8227C3DAC1D7EEFF7E35A6E6D820", hash_generated_field = "E374D3D7265A360D5988E5A530CDD674")

        public static final String USAGE_TYPE_SHORT_TEXT = "short_text";
    }


    
    public static final class QuickContact {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.238 -0400", hash_original_method = "854DF4E0756DCBE90F5C7A53A4D83687", hash_generated_method = "854DF4E0756DCBE90F5C7A53A4D83687")
        public QuickContact ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SPEC)
        public static void showQuickContact(Context context, View target, Uri lookupUri, int mode,
                String[] excludeMimes) {
            final float appScale = context.getResources().getCompatibilityInfo().applicationScale;
            final int[] pos = new int[2];
            target.getLocationOnScreen(pos);
            final Rect rect = new Rect();
            rect.left = (int) (pos[0] * appScale + 0.5f);
            rect.top = (int) (pos[1] * appScale + 0.5f);
            rect.right = (int) ((pos[0] + target.getWidth()) * appScale + 0.5f);
            rect.bottom = (int) ((pos[1] + target.getHeight()) * appScale + 0.5f);
            showQuickContact(context, rect, lookupUri, mode, excludeMimes);
        }

        
        @DSModeled(DSC.SPEC)
        public static void showQuickContact(Context context, Rect target, Uri lookupUri, int mode,
                String[] excludeMimes) {
            final Intent intent = new Intent(ACTION_QUICK_CONTACT);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            intent.setData(lookupUri);
            intent.setSourceBounds(target);
            intent.putExtra(EXTRA_MODE, mode);
            intent.putExtra(EXTRA_EXCLUDE_MIMES, excludeMimes);
            context.startActivity(intent);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.239 -0400", hash_original_field = "59E4956433221CB36C43C0BBDF983B1E", hash_generated_field = "44F635670A7299544328E5C4BCCF27F4")

        public static final String ACTION_QUICK_CONTACT =
                "com.android.contacts.action.QUICK_CONTACT";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.239 -0400", hash_original_field = "2F4DCE6DCF7CC435185DB92345F74FD0", hash_generated_field = "30E30433E867A007E9F4274ED19ABED7")

        @Deprecated
        public static final String EXTRA_TARGET_RECT = "target_rect";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.239 -0400", hash_original_field = "F169C345C774D0E0A038B782C1EE96D5", hash_generated_field = "91426137795BA2F236B3E16D263CB795")

        public static final String EXTRA_MODE = "mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.239 -0400", hash_original_field = "1E0C53A296C3DDC47552512E3B5A8725", hash_generated_field = "B841D17E01159E71755D89737FE2513B")

        public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.239 -0400", hash_original_field = "FE91127945E0C3BCB91FE31DA1DEB4FC", hash_generated_field = "60EA48AB5F9444542CC46A5A635E74D5")

        public static final int MODE_SMALL = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.239 -0400", hash_original_field = "9C2E22E349EA9F6A1628D307F5758A0D", hash_generated_field = "4B5C353280E1650969D6153174DB1DA9")

        public static final int MODE_MEDIUM = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.239 -0400", hash_original_field = "4AC2CE98250B06DA84441A7B8961C9FD", hash_generated_field = "A8F19AE9E94919AE1B96FA82FE5CD087")

        public static final int MODE_LARGE = 3;
    }


    
    public static final class DisplayPhoto {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_method = "4DA607ACD5E6F502EC932EC179042892", hash_generated_method = "B2E13164C0532FB7A083C12460677DAB")
        private  DisplayPhoto() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "5B3F6DCC60A4F67ECC731E83C6D43D1B", hash_generated_field = "C49D801AE6AE952C5A2E59237BB76750")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "display_photo");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "F1581F2D110A7D26565A46EE7EAA777D", hash_generated_field = "571916FB52ADE5E675DF16A80A4DE259")

        public static final Uri CONTENT_MAX_DIMENSIONS_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "photo_dimensions");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "7673005809CFC36D949CBD006234BA76", hash_generated_field = "9C63BF2F85885D804150EB607E59CEF7")

        public static final String DISPLAY_MAX_DIM = "display_max_dim";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "18BF0084B8169638793F92639C54353B", hash_generated_field = "A5F2A972D7A0F8EF132399021DBF335B")

        public static final String THUMBNAIL_MAX_DIM = "thumbnail_max_dim";
    }


    
    public static final class Intents {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_method = "1E952476DD941AF572EDA8AC50686906", hash_generated_method = "1E952476DD941AF572EDA8AC50686906")
        public Intents ()
        {
            //Synthesized constructor
        }


        public static final class UI {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_method = "244D54B89BC2D5ABA32DBC8F28EE0809", hash_generated_method = "244D54B89BC2D5ABA32DBC8F28EE0809")
            public UI ()
            {
                //Synthesized constructor
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "4BEBAEE2BB774C5CC34B8DD4A79F1257", hash_generated_field = "593F38A410B0596B4AC7CB11DE2B63D9")

            public static final String LIST_DEFAULT =
                    "com.android.contacts.action.LIST_DEFAULT";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "BA0C6B27883E32319E9CF71706765CC7", hash_generated_field = "BCFCA30D099E145B944715F7774B7D03")

            public static final String LIST_GROUP_ACTION =
                    "com.android.contacts.action.LIST_GROUP";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "35192F6565485ABCEB28AA4E5094DA31", hash_generated_field = "7152483FEB825A3DF4E2CA899B3A2397")

            public static final String GROUP_NAME_EXTRA_KEY = "com.android.contacts.extra.GROUP";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "D61561B2B5F5D743FEE40C630A56C8C3", hash_generated_field = "082889FF819B93DB1103B4CC64A89049")

            public static final String LIST_ALL_CONTACTS_ACTION =
                    "com.android.contacts.action.LIST_ALL_CONTACTS";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "BB3EC5C81F28470C5AC5D064C867DAF7", hash_generated_field = "E3341AC3155455D800037BC571E2CC42")

            public static final String LIST_CONTACTS_WITH_PHONES_ACTION =
                    "com.android.contacts.action.LIST_CONTACTS_WITH_PHONES";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "19C6B3B24EDF9445093B8964EB07A37B", hash_generated_field = "8CC13E63672088D309BC610E09FD451E")

            public static final String LIST_STARRED_ACTION =
                    "com.android.contacts.action.LIST_STARRED";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "05604AEB47B85DC797F66A04D640D06A", hash_generated_field = "0BC31D032A3B49751734E6EC9A1C7090")

            public static final String LIST_FREQUENT_ACTION =
                    "com.android.contacts.action.LIST_FREQUENT";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "7C04F71BC73068FC342E21F97C977F53", hash_generated_field = "3B8EFF26BB8D04BF93717C84047300E4")

            public static final String LIST_STREQUENT_ACTION =
                    "com.android.contacts.action.LIST_STREQUENT";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "BE4ECD241729A7618149B78BCAD5216B", hash_generated_field = "646CEFD7ECE89E9767BDA32D20371F05")

            public static final String TITLE_EXTRA_KEY =
                    "com.android.contacts.extra.TITLE_EXTRA";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "0AE1036D94DFDF6E7FD33A247BC2AE30", hash_generated_field = "330480EB686218B9D523AFF412034358")

            public static final String FILTER_CONTACTS_ACTION =
                    "com.android.contacts.action.FILTER_CONTACTS";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_field = "2E334A68491008B8F9AAFBE68A9225EE", hash_generated_field = "2AF328066F3AF41712BB1AC1E77ECF4B")

            public static final String FILTER_TEXT_EXTRA_KEY =
                    "com.android.contacts.extra.FILTER_TEXT";
        }


        
        public static final class Insert {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_method = "2A9E1DC472832B4765A0A21D09988277", hash_generated_method = "2A9E1DC472832B4765A0A21D09988277")
            public Insert ()
            {
                //Synthesized constructor
            }


            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "84C9E3ACA93003DB2ABDB1DE3B33AC0E", hash_generated_field = "713533B8E8F55862B5688D351B3D3343")

            public static final String ACTION = Intent.ACTION_INSERT;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "C687473623CB3D70E74F7646667189FD", hash_generated_field = "2619FF14C7C6A98F2DF1E8E4AC58E0A2")

            public static final String FULL_MODE = "full_mode";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "DF93ACD53BD3A496BAA30564AD0C5925", hash_generated_field = "8F5B94AE17AA8887EB81EF0FD5591FF7")

            public static final String NAME = "name";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "6E53A9674D8B6F4061A59FC62E6D7C55", hash_generated_field = "52516856F1A5EB7ABB343D265D441C8B")

            public static final String PHONETIC_NAME = "phonetic_name";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "8CD1BFE559CBC0F58F4CFB23EB963E16", hash_generated_field = "DA3A161CE79B1B32CE9B8F725B5209E9")

            public static final String COMPANY = "company";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "F30FE8ECC0245F2BEC22B74B0B74A3A5", hash_generated_field = "D9FF83450C736ECB48F6C2F09F5228C0")

            public static final String JOB_TITLE = "job_title";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "64F682FF680909C3283E3884A29780D4", hash_generated_field = "87D52F2B531AEC13DF3E369C39ADFFFB")

            public static final String NOTES = "notes";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "D691F6CBCE83242F8E1801A18FE78496", hash_generated_field = "8335197447402E15F4F117B323C6EEBF")

            public static final String PHONE = "phone";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "A773670799D94F601C418C447F04151C", hash_generated_field = "EF03148507068753AC3CAE4DC5C84C25")

            public static final String PHONE_TYPE = "phone_type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "C4C4A5A7DCB837CFC00914E8044FAA33", hash_generated_field = "7E6AE81CEEEC747E06A4CE7B3886BAFE")

            public static final String PHONE_ISPRIMARY = "phone_isprimary";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "7410138DB136B84901915A3A4BD7B409", hash_generated_field = "448C6E829671F08B3922BEF4C7BA4DD0")

            public static final String SECONDARY_PHONE = "secondary_phone";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "0D340E5B161C170D1A808662FB09FF0D", hash_generated_field = "DB4B8535D6A9FBA09643994357446FF2")

            public static final String SECONDARY_PHONE_TYPE = "secondary_phone_type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "121E0EF368C46C294D5E9D62F48A8BEE", hash_generated_field = "AC733805DB388428C9F95E863DC84E2B")

            public static final String TERTIARY_PHONE = "tertiary_phone";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "8C4883B3945EA2CCCCB963EEFFE2C8F0", hash_generated_field = "4FB26A252013330C127F7BCA8E9A94FD")

            public static final String TERTIARY_PHONE_TYPE = "tertiary_phone_type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "4A3CD142A145645654B4A78F6263EB11", hash_generated_field = "D3A698C17CAE09AF6E6FEF88B890D500")

            public static final String EMAIL = "email";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "107F7EBEEF65AA80F698CF2C27ADEC80", hash_generated_field = "B60E8DD6122DA416C2126A2F09163415")

            public static final String EMAIL_TYPE = "email_type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "4E924DD6DA6ACDF5ED99C25A3274C4BB", hash_generated_field = "72BBA6D014131906449B388E938A83DE")

            public static final String EMAIL_ISPRIMARY = "email_isprimary";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "FD9858524BE23A536319FC65105232BD", hash_generated_field = "6FD78194AFE767FC50E1879245A1A8C2")

            public static final String SECONDARY_EMAIL = "secondary_email";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "D8E28210E2AF799DB71DEEB10762AFA7", hash_generated_field = "42A1240E78AF2AAA1C00CEA323946D39")

            public static final String SECONDARY_EMAIL_TYPE = "secondary_email_type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_field = "AA751D9B7319A687E33053BDC5C785D3", hash_generated_field = "39D6023493877247D0BA850ADCA80503")

            public static final String TERTIARY_EMAIL = "tertiary_email";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "61C2AF4777F09287465529DB91B58B8B", hash_generated_field = "F1BB0DF7E89E304FE25A4629E8B7ECAE")

            public static final String TERTIARY_EMAIL_TYPE = "tertiary_email_type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "07F6BB00C5D715C61E04E24077637570", hash_generated_field = "16A9B5315BE6511E8C8C027F9A8BA319")

            public static final String POSTAL = "postal";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "B6F91482548210AF4EAB503044E65A43", hash_generated_field = "5B1A73813BB9BA4F0DD1A8C5E9748E8F")

            public static final String POSTAL_TYPE = "postal_type";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "0D5B8E711599183BDD21F06FEE0A0D25", hash_generated_field = "146C8C0EE7F160B0D91705B591EB4267")

            public static final String POSTAL_ISPRIMARY = "postal_isprimary";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "17E4478AB025BAA83B29B2D20D02A590", hash_generated_field = "DD828D08FD6E1452CD2A0CA138269906")

            public static final String IM_HANDLE = "im_handle";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "57F43A6D12EA6AFA27ADD3959808C6A7", hash_generated_field = "80A550AB07C0EB0D72631848FAE3AD77")

            public static final String IM_PROTOCOL = "im_protocol";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "814BA3FC67511C6D1E792F7F21D011F3", hash_generated_field = "BE91E4F2A0E419B1DB9038AE9DC12E15")

            public static final String IM_ISPRIMARY = "im_isprimary";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "BDC1563E39E98B6DE524AE168E28CCEE", hash_generated_field = "319364121428350EE2F4E83744CF0E5C")

            public static final String DATA = "data";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "AFCF1FB6325C2CF3AF850A2A03DA8127", hash_generated_field = "95FDE4400867AFC68212BF727B1AD7CC")

            public static final String ACCOUNT = "com.android.contacts.extra.ACCOUNT";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "0D36ADBB3F6599AE9BD7C151CF684281", hash_generated_field = "267D13C3CA9C65C1D39CB067CDA6981B")

            public static final String DATA_SET = "com.android.contacts.extra.DATA_SET";
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "08FBF510E3E436ABA7B8D88028061FA6", hash_generated_field = "A132A17FDFC42C8C719ED06C6147FD6F")

        public static final String SEARCH_SUGGESTION_CLICKED =
                "android.provider.Contacts.SEARCH_SUGGESTION_CLICKED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "A33487B6657109F79CE480D21DA3B71B", hash_generated_field = "DA2A25A25B6B3F26EE4468747CC6E08A")

        public static final String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED =
                "android.provider.Contacts.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "6A848E4F3155C9EE5A8F975763B3D3D6", hash_generated_field = "2115A82C302B7499D9E43F1F9CC02C26")

        public static final String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED =
                "android.provider.Contacts.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "D1A128C80FCE37C3BE55E031C06E6C3D", hash_generated_field = "9F22604D06FF2A8A9715D19377B1A01D")

        public static final String ATTACH_IMAGE =
                "com.android.contacts.action.ATTACH_IMAGE";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "0015518CE2AFAFFA15B71F7E2B65EB13", hash_generated_field = "F24E618647C98A3226ED81E567FCAFFB")

        public static final String INVITE_CONTACT =
                "com.android.contacts.action.INVITE_CONTACT";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "D11CDF67547083E1207FC8B8364561EA", hash_generated_field = "C4028B0307D626E403E0499E11C95CD7")

        public static final String SHOW_OR_CREATE_CONTACT =
                "com.android.contacts.action.SHOW_OR_CREATE_CONTACT";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "A4247F5E5F6F4D6C7CBEB055D356D134", hash_generated_field = "0F60964076DA5FE3C45B9D348905CAF8")

        public static final String ACTION_GET_MULTIPLE_PHONES =
                "com.android.contacts.action.GET_MULTIPLE_PHONES";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "AF8295420206314257247223BBC5C92F", hash_generated_field = "C84AA19FB248DB5751ED2E98D1080B4C")

        public static final String EXTRA_FORCE_CREATE =
                "com.android.contacts.action.FORCE_CREATE";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "0B7F9EF3276A08C8BB74665A42895E85", hash_generated_field = "CCB9A0BCB8AC5F3B27B71026D70005CF")

        public static final String EXTRA_CREATE_DESCRIPTION =
            "com.android.contacts.action.CREATE_DESCRIPTION";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "17DA25D060AAC2B18EA01C07FB9CEDF3", hash_generated_field = "151F25A2D9735A74D96C2AD335D686C4")

        public static final String EXTRA_PHONE_URIS =
            "com.android.contacts.extra.PHONE_URIS";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "2F4DCE6DCF7CC435185DB92345F74FD0", hash_generated_field = "30E30433E867A007E9F4274ED19ABED7")

        @Deprecated
        public static final String EXTRA_TARGET_RECT = "target_rect";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "F169C345C774D0E0A038B782C1EE96D5", hash_generated_field = "C02F74A2B81BF596BB306FC81B188A5D")

        @Deprecated
        public static final String EXTRA_MODE = "mode";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "FE91127945E0C3BCB91FE31DA1DEB4FC", hash_generated_field = "5398604140D0C7FCD5670D1E6E50B3F0")

        @Deprecated
        public static final int MODE_SMALL = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "9C2E22E349EA9F6A1628D307F5758A0D", hash_generated_field = "E92EED4E6D32AA90558A4544CB6BD1B0")

        @Deprecated
        public static final int MODE_MEDIUM = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "4AC2CE98250B06DA84441A7B8961C9FD", hash_generated_field = "F026CBB55815E93E494A2842E318F883")

        @Deprecated
        public static final int MODE_LARGE = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.243 -0400", hash_original_field = "1E0C53A296C3DDC47552512E3B5A8725", hash_generated_field = "0AB31B2F643C6FD8DB6DB3EB56EF9E3E")

        @Deprecated
        public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
    }


    
    @Deprecated public interface SyncStateColumns extends SyncStateContract.Columns {
    }
    
    protected interface BaseSyncColumns {

        
        public static final String SYNC1 = "sync1";
        
        public static final String SYNC2 = "sync2";
        
        public static final String SYNC3 = "sync3";
        
        public static final String SYNC4 = "sync4";
    }
    
    protected interface SyncColumns extends BaseSyncColumns {
        
        public static final String ACCOUNT_NAME = "account_name";

        
        public static final String ACCOUNT_TYPE = "account_type";

        
        public static final String SOURCE_ID = "sourceid";

        
        public static final String VERSION = "version";

        
        public static final String DIRTY = "dirty";
    }
    
    protected interface ContactOptionsColumns {
        
        public static final String TIMES_CONTACTED = "times_contacted";

        
        public static final String LAST_TIME_CONTACTED = "last_time_contacted";

        
        public static final String STARRED = "starred";

        
        public static final String CUSTOM_RINGTONE = "custom_ringtone";

        
        public static final String SEND_TO_VOICEMAIL = "send_to_voicemail";
    }
    
    protected interface ContactsColumns {
        
        public static final String DISPLAY_NAME = ContactNameColumns.DISPLAY_NAME_PRIMARY;

        
        public static final String NAME_RAW_CONTACT_ID = "name_raw_contact_id";

        
        public static final String PHOTO_ID = "photo_id";

        
        public static final String PHOTO_FILE_ID = "photo_file_id";

        
        public static final String PHOTO_URI = "photo_uri";

        
        public static final String PHOTO_THUMBNAIL_URI = "photo_thumb_uri";

        
        public static final String IN_VISIBLE_GROUP = "in_visible_group";

        
        public static final String IS_USER_PROFILE = "is_user_profile";

        
        public static final String HAS_PHONE_NUMBER = "has_phone_number";

        
        public static final String LOOKUP_KEY = "lookup";
    }
    
    protected interface ContactStatusColumns {
        
        public static final String CONTACT_PRESENCE = "contact_presence";

        
        public static final String CONTACT_CHAT_CAPABILITY = "contact_chat_capability";

        
        public static final String CONTACT_STATUS = "contact_status";

        
        public static final String CONTACT_STATUS_TIMESTAMP = "contact_status_ts";

        
        public static final String CONTACT_STATUS_RES_PACKAGE = "contact_status_res_package";

        
        public static final String CONTACT_STATUS_LABEL = "contact_status_label";

        
        public static final String CONTACT_STATUS_ICON = "contact_status_icon";
    }
    
    public interface FullNameStyle {
        public static final int UNDEFINED = 0;
        public static final int WESTERN = 1;

        
        public static final int CJK = 2;

        public static final int CHINESE = 3;
        public static final int JAPANESE = 4;
        public static final int KOREAN = 5;
    }
    
    public interface PhoneticNameStyle {
        public static final int UNDEFINED = 0;

        
        public static final int PINYIN = 3;

        
        public static final int JAPANESE = 4;

        
        public static final int KOREAN = 5;
    }
    
    public interface DisplayNameSources {
        public static final int UNDEFINED = 0;
        public static final int EMAIL = 10;
        public static final int PHONE = 20;
        public static final int ORGANIZATION = 30;
        public static final int NICKNAME = 35;
        public static final int STRUCTURED_NAME = 40;
    }
    
    protected interface ContactNameColumns {

        
        public static final String DISPLAY_NAME_SOURCE = "display_name_source";

        
        public static final String DISPLAY_NAME_PRIMARY = "display_name";

        
        public static final String DISPLAY_NAME_ALTERNATIVE = "display_name_alt";

        
        public static final String PHONETIC_NAME_STYLE = "phonetic_name_style";

        
        public static final String PHONETIC_NAME = "phonetic_name";

        
        public static final String SORT_KEY_PRIMARY = "sort_key";

        
        public static final String SORT_KEY_ALTERNATIVE = "sort_key_alt";
    }
    
    protected interface RawContactsColumns {
        
        public static final String CONTACT_ID = "contact_id";

        
        public static final String DATA_SET = "data_set";

        
        public static final String ACCOUNT_TYPE_AND_DATA_SET = "account_type_and_data_set";

        
        public static final String AGGREGATION_MODE = "aggregation_mode";

        
        public static final String DELETED = "deleted";

        
        public static final String NAME_VERIFIED = "name_verified";

        
        public static final String RAW_CONTACT_IS_READ_ONLY = "raw_contact_is_read_only";

        
        public static final String RAW_CONTACT_IS_USER_PROFILE = "raw_contact_is_user_profile";
    }
    
    protected interface StatusColumns {
        
        public static final String PRESENCE = "mode";

        
        @Deprecated
        public static final String PRESENCE_STATUS = PRESENCE;

        
        int OFFLINE = 0;

        
        int INVISIBLE = 1;

        
        int AWAY = 2;

        
        int IDLE = 3;

        
        int DO_NOT_DISTURB = 4;

        
        int AVAILABLE = 5;

        
        public static final String STATUS = "status";

        
        @Deprecated
        public static final String PRESENCE_CUSTOM_STATUS = STATUS;

        
        public static final String STATUS_TIMESTAMP = "status_ts";

        
        public static final String STATUS_RES_PACKAGE = "status_res_package";

        
        public static final String STATUS_LABEL = "status_label";

        
        public static final String STATUS_ICON = "status_icon";

        
        public static final String CHAT_CAPABILITY = "chat_capability";

        
        public static final int CAPABILITY_HAS_VOICE = 1;

        
        public static final int CAPABILITY_HAS_VIDEO = 2;

        
        public static final int CAPABILITY_HAS_CAMERA = 4;
    }
    
    protected interface StreamItemsColumns {
        
        public static final String CONTACT_ID = "contact_id";

        
        public static final String CONTACT_LOOKUP_KEY = "contact_lookup";

        
        public static final String RAW_CONTACT_ID = "raw_contact_id";

        
        public static final String RES_PACKAGE = "res_package";

        
        public static final String ACCOUNT_TYPE = "account_type";

        
        public static final String ACCOUNT_NAME = "account_name";

        
        public static final String DATA_SET = "data_set";

        
        public static final String RAW_CONTACT_SOURCE_ID = "raw_contact_source_id";

        
        public static final String RES_ICON = "icon";

        
        public static final String RES_LABEL = "label";

        
        public static final String TEXT = "text";

        
        public static final String TIMESTAMP = "timestamp";

        
        public static final String COMMENTS = "comments";

        
        public static final String SYNC1 = "stream_item_sync1";
        
        public static final String SYNC2 = "stream_item_sync2";
        
        public static final String SYNC3 = "stream_item_sync3";
        
        public static final String SYNC4 = "stream_item_sync4";
    }
    
    protected interface StreamItemPhotosColumns {
        
        public static final String STREAM_ITEM_ID = "stream_item_id";

        
        public static final String SORT_INDEX = "sort_index";

        
        public static final String PHOTO_FILE_ID = "photo_file_id";

        
        public static final String PHOTO_URI = "photo_uri";

        
        public static final String SYNC1 = "stream_item_photo_sync1";
        
        public static final String SYNC2 = "stream_item_photo_sync2";
        
        public static final String SYNC3 = "stream_item_photo_sync3";
        
        public static final String SYNC4 = "stream_item_photo_sync4";
    }
    
    protected interface PhotoFilesColumns {

        
        public static final String HEIGHT = "height";

        
        public static final String WIDTH = "width";

        
        public static final String FILESIZE = "filesize";
    }
    
    protected interface DataColumns {
        
        public static final String RES_PACKAGE = "res_package";

        
        public static final String MIMETYPE = "mimetype";

        
        public static final String RAW_CONTACT_ID = "raw_contact_id";

        
        public static final String IS_PRIMARY = "is_primary";

        
        public static final String IS_SUPER_PRIMARY = "is_super_primary";

        
        public static final String IS_READ_ONLY = "is_read_only";

        
        public static final String DATA_VERSION = "data_version";

        
        public static final String DATA1 = "data1";
        
        public static final String DATA2 = "data2";
        
        public static final String DATA3 = "data3";
        
        public static final String DATA4 = "data4";
        
        public static final String DATA5 = "data5";
        
        public static final String DATA6 = "data6";
        
        public static final String DATA7 = "data7";
        
        public static final String DATA8 = "data8";
        
        public static final String DATA9 = "data9";
        
        public static final String DATA10 = "data10";
        
        public static final String DATA11 = "data11";
        
        public static final String DATA12 = "data12";
        
        public static final String DATA13 = "data13";
        
        public static final String DATA14 = "data14";
        
        public static final String DATA15 = "data15";

        
        public static final String SYNC1 = "data_sync1";
        
        public static final String SYNC2 = "data_sync2";
        
        public static final String SYNC3 = "data_sync3";
        
        public static final String SYNC4 = "data_sync4";
    }
    
    protected interface DataColumnsWithJoins extends BaseColumns, DataColumns, StatusColumns,
            RawContactsColumns, ContactsColumns, ContactNameColumns, ContactOptionsColumns,
            ContactStatusColumns {
    }
    
    protected interface PhoneLookupColumns {
        
        public static final String NUMBER = "number";

        
        public static final String TYPE = "type";

        
        public static final String LABEL = "label";

        
        public static final String NORMALIZED_NUMBER = "normalized_number";
    }
    
    protected interface PresenceColumns {

        
        public static final String DATA_ID = "presence_data_id";

        
        public static final String PROTOCOL = "protocol";

        
        public static final String CUSTOM_PROTOCOL = "custom_protocol";

        
        public static final String IM_HANDLE = "im_handle";

        
        public static final String IM_ACCOUNT = "im_account";
    }
    
    protected interface GroupsColumns {
        
        public static final String DATA_SET = "data_set";

        
        public static final String ACCOUNT_TYPE_AND_DATA_SET = "account_type_and_data_set";

        
        public static final String TITLE = "title";

        
        public static final String RES_PACKAGE = "res_package";

        
        public static final String TITLE_RES = "title_res";

        
        public static final String NOTES = "notes";

        
        public static final String SYSTEM_ID = "system_id";

        
        public static final String SUMMARY_COUNT = "summ_count";

        
        public static final String PARAM_RETURN_GROUP_COUNT_PER_ACCOUNT =
                "return_group_count_per_account";

        
        public static final String SUMMARY_GROUP_COUNT_PER_ACCOUNT = "group_count_per_account";

        
        public static final String SUMMARY_WITH_PHONES = "summ_phones";

        
        public static final String GROUP_VISIBLE = "group_visible";

        
        public static final String DELETED = "deleted";

        
        public static final String SHOULD_SYNC = "should_sync";

        
        public static final String AUTO_ADD = "auto_add";

        
        public static final String FAVORITES = "favorites";

        
        public static final String GROUP_IS_READ_ONLY = "group_is_read_only";
    }
    
    protected interface SettingsColumns {
        
        public static final String ACCOUNT_NAME = "account_name";

        
        public static final String ACCOUNT_TYPE = "account_type";

        
        public static final String DATA_SET = "data_set";

        
        public static final String SHOULD_SYNC = "should_sync";

        
        public static final String UNGROUPED_VISIBLE = "ungrouped_visible";

        
        public static final String ANY_UNSYNCED = "any_unsynced";

        
        public static final String UNGROUPED_COUNT = "summ_count";

        
        public static final String UNGROUPED_WITH_PHONES = "summ_phones";
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "C606D95921FA215899FED3776E049AD2", hash_generated_field = "FED7E6E1693B1A73321724DE94B7C5BF")

    public static final String AUTHORITY = "com.android.contacts";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "55E96C26125757F0C1CE97A122A8192C", hash_generated_field = "B1D8562AF60924B20700DDD648EE3109")

    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "B364F080B56F7180EA743D0D5C83FC49", hash_generated_field = "644CE73EB8766FA330BF3C4B8E384D0A")

    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "D73985790FE7B244C2131F9B9ADBCC2C", hash_generated_field = "42ABBED65129DF38A6A4886F320A25F0")

    public static final String DIRECTORY_PARAM_KEY = "directory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "966A2F5CED013E24762CBBA29CAFA813", hash_generated_field = "2D8DE5D7257CF584D367D715403C3860")

    public static final String LIMIT_PARAM_KEY = "limit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "3EB6FFC9A07BE3D25EA8093D789386BA", hash_generated_field = "D3067D1ABEF0431DDD32B3D98E42DF3C")

    public static final String PRIMARY_ACCOUNT_NAME = "name_for_primary_account";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "831064AB6B3A28C4CBBEC364C6ECC605", hash_generated_field = "6EF8639E2C62EA62D2C21DF3CE5BB688")

    public static final String PRIMARY_ACCOUNT_TYPE = "type_for_primary_account";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "1C86C951978CCF7465FF71FE76A7ABDE", hash_generated_field = "5B0CC0121B9203D3AA6EE95F177BF61E")

    public static final String STREQUENT_PHONE_ONLY = "strequent_phone_only";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "022B143BC1FD2216DF517916A0F5A66C", hash_generated_field = "91AD6C2785F4D2C8B18EB47243AB2E3C")

    public static final String DEFERRED_SNIPPETING = "deferred_snippeting";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "3E2BE15A2E9D69AABEEA46E1976FCF6D", hash_generated_field = "14839B6FA3C88B296372359851697ECC")

    public static final String DEFERRED_SNIPPETING_QUERY = "deferred_snippeting_query";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "E7E8C90D933A1234403320DBCC2C8FAA", hash_generated_field = "A0402873080D13DD56D9BD37D27F4D87")

    public static final String REMOVE_DUPLICATE_ENTRIES = "remove_duplicate_entries";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.244 -0400", hash_original_field = "AA297F613A5AB53A07C2B50E01F3E891", hash_generated_field = "BFA597C8407085E19653605D4E02003E")

    private static Pattern SPLIT_PATTERN = Pattern.compile("([\\w-\\.]+)@((?:[\\w]+\\.)+)([a-zA-Z]{2,4})|[\\w]+");
}

