package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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

    /**
     * This method can be used to identify whether the given ID is associated with profile
     * data.  It does not necessarily indicate that the ID is tied to valid data, merely
     * that accessing data using this ID will result in profile access checks and will only
     * return data from the profile.
     *
     * @param id The ID to check.
     * @return Whether the ID is associated with profile data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.956 -0500", hash_original_method = "0941112ABD9069C80C65289B6D5666C2", hash_generated_method = "2B2E591A90F2D66450BD3C85D36EE73D")
    
public static boolean isProfileId(long id) {
        return id >= Profile.MIN_ID;
    }

    /**
     * Creates a snippet out of the given content that matches the given query.
     * @param content - The content to use to compute the snippet.
     * @param displayName - Display name for the contact - if this already contains the search
     *        content, no snippet should be shown.
     * @param query - String to search for in the content.
     * @param snippetStartMatch - Marks the start of the matching string in the snippet.
     * @param snippetEndMatch - Marks the end of the matching string in the snippet.
     * @param snippetEllipsis - Ellipsis string appended to the end of the snippet (if too long).
     * @param snippetMaxTokens - Maximum number of words from the snippet that will be displayed.
     * @return The computed snippet, or null if the snippet could not be computed or should not be
     *         shown.
     *
     *  @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.115 -0500", hash_original_method = "BBD9B5CD65A55FC3201E30C2D0E96E71", hash_generated_method = "614F8DFFF6E32ED9966CA19F2DF68C62")
    
public static String snippetize(String content, String displayName, String query,
            char snippetStartMatch, char snippetEndMatch, String snippetEllipsis,
            int snippetMaxTokens) {

        String lowerQuery = query != null ? query.toLowerCase() : null;
        if (TextUtils.isEmpty(content) || TextUtils.isEmpty(query) ||
                TextUtils.isEmpty(displayName) || !content.toLowerCase().contains(lowerQuery)) {
            return null;
        }

        // If the display name already contains the query term, return empty - snippets should
        // not be needed in that case.
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

        // Locate the lines of the content that contain the query term.
        for (String contentLine : contentLines) {
            if (contentLine.toLowerCase().contains(lowerQuery)) {

                // Line contains the query string - now search for it at the start of tokens.
                List<String> lineTokens = new ArrayList<String>();
                List<Integer> tokenOffsets = new ArrayList<Integer>();
                split(contentLine.trim(), lineTokens, tokenOffsets);

                // As we find matches against the query, we'll populate this list with the marked
                // (or unchanged) tokens.
                List<String> markedTokens = new ArrayList<String>();

                int firstToken = -1;
                int lastToken = -1;
                for (int i = 0; i < lineTokens.size(); i++) {
                    String token = lineTokens.get(i);
                    String lowerToken = token.toLowerCase();
                    if (lowerToken.startsWith(lowerQuery)) {

                        // Query term matched; surround the token with match markers.
                        markedTokens.add(snippetStartMatch + token + snippetEndMatch);

                        // If this is the first token found with a match, mark the token
                        // positions to use for assembling the snippet.
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

                // Assemble the snippet by piecing the tokens back together.
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
                            // Add the characters that appeared between this token and the next.
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

    /**
     * Helper method for splitting a string into tokens.  The lists passed in are populated with the
     * tokens and offsets into the content of each token.  The tokenization function parses e-mail
     * addresses as a single token; otherwise it splits on any non-alphanumeric character.
     * @param content Content to split.
     * @param tokens List of token strings to populate.
     * @param offsets List of offsets into the content for each token returned.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.119 -0500", hash_original_method = "712ABC4CE2C3A9D659D9E51530EC203D", hash_generated_method = "190F3C53417FE6D5980891B58347F2FB")
    
private static void split(String content, List<String> tokens, List<Integer> offsets) {
        Matcher matcher = SPLIT_PATTERN.matcher(content);
        while (matcher.find()) {
            tokens.add(matcher.group());
            offsets.add(matcher.start());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.549 -0500", hash_original_field = "ED482E4F3DFF6E773B5F502F3225E108", hash_generated_field = "FED7E6E1693B1A73321724DE94B7C5BF")

    public static final String AUTHORITY = "com.android.contacts";
    
    public static final class Authorization {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.576 -0500", hash_original_field = "1BBDB3BE15C47768797FC1A1E879BDBF", hash_generated_field = "A470159EC5224DD15058611E1D5E86C6")

        public static final String AUTHORIZATION_METHOD = "authorize";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.579 -0500", hash_original_field = "0094A9FDF351E419338476FBD40723DA", hash_generated_field = "5CA2BFC34A142FBD92140496C29EA2FB")

        public static final String KEY_URI_TO_AUTHORIZE = "uri_to_authorize";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.582 -0500", hash_original_field = "8C26D5A681FC16DFE3A8C9FFA689C5C9", hash_generated_field = "CE5CD9050F5C0D0B1A3E53943BE0D76F")

        public static final String KEY_AUTHORIZED_URI = "authorized_uri";
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.205 -0400", hash_original_method = "130B4481E1D16F5CC0713072784D18C5", hash_generated_method = "130B4481E1D16F5CC0713072784D18C5")
        public Authorization ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class Preferences {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.587 -0500", hash_original_field = "4A875F6C9D3971B229353AF7680F6833", hash_generated_field = "354038F38C8A27D1130C805310BD23D7")

        public static final String SORT_ORDER = "android.contacts.SORT_ORDER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.589 -0500", hash_original_field = "BCDD80604C715DADDFA7284CFED8B68B", hash_generated_field = "DE0FA688EB095C8C63158D49A34915EC")

        public static final int SORT_ORDER_PRIMARY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.593 -0500", hash_original_field = "AF153DD05A499C1E7B8480DB241ADF0E", hash_generated_field = "16FA408EB36C9D63537965227EB953C3")

        public static final int SORT_ORDER_ALTERNATIVE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.595 -0500", hash_original_field = "186BFED2E22D6957BFEB2E9B468B622B", hash_generated_field = "44E17A97F52B762BCB696B660872D72B")

        public static final String DISPLAY_ORDER = "android.contacts.DISPLAY_ORDER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.597 -0500", hash_original_field = "06A686F63A64E8E62997280BDBEBCA13", hash_generated_field = "DC3C3CD73DD75F47A0631529D7184EB1")

        public static final int DISPLAY_ORDER_PRIMARY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.600 -0500", hash_original_field = "92F93C5F063BB10A2745A64F4AB55B53", hash_generated_field = "AF2282B4CF1E1DBBFC521795D96F6061")

        public static final int DISPLAY_ORDER_ALTERNATIVE = 2;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.205 -0400", hash_original_method = "2E8FE94CA2E5C969DED3F5ED9F537560", hash_generated_method = "2E8FE94CA2E5C969DED3F5ED9F537560")
        public Preferences ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class Directory implements BaseColumns {

        /**
         * Notifies the system of a change in the list of directories handled by
         * a particular directory provider. The Contacts provider will turn around
         * and send a query to the directory provider for the full list of directories,
         * which will replace the previous list.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.670 -0500", hash_original_method = "6D608DB52AC8952A89B8472446A9496C", hash_generated_method = "6DBDE6CD2DFF18E2305CB5B3F5A9E508")
        
public static void notifyDirectoryChange(ContentResolver resolver) {
            // This is done to trigger a query by Contacts Provider back to the directory provider.
            // No data needs to be sent back, because the provider can infer the calling
            // package from binder.
            ContentValues contentValues = new ContentValues();
            resolver.update(Directory.CONTENT_URI, contentValues, null, null);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.608 -0500", hash_original_field = "567F42209F56A074AD0A0719D569778B", hash_generated_field = "B6F02680896AA16AD685418AD49231CC")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "directories");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.611 -0500", hash_original_field = "85E46D079794D9D6EAC69FCADB8E18C5", hash_generated_field = "423D8E2040F0763F948EDAD54B89A5EA")

        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/contact_directories";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.613 -0500", hash_original_field = "D1895060A216967CA49A1A9A451B03D8", hash_generated_field = "B9A704C9D5BAADBFF9ED5716E281267F")

        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/contact_directory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.615 -0500", hash_original_field = "99C9192A051F830B4430B545CA6F2F76", hash_generated_field = "C137D8F7BDBD47FF72070C1B4AB800F7")

        public static final long DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.618 -0500", hash_original_field = "65B3C9E104CD7336943AABAE24962E84", hash_generated_field = "35783223357D71D592344B4E64BF95DD")

        public static final long LOCAL_INVISIBLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.621 -0500", hash_original_field = "1E48EBC5CABD4A6C382E425FD17D41FC", hash_generated_field = "2CA46768DFD7C5D320ECE4CE59CFD2B2")

        public static final String PACKAGE_NAME = "packageName";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.624 -0500", hash_original_field = "C62900F98184518FF3AEE892BC898F96", hash_generated_field = "E957B4A8C7D8100B23968F5E4A70B4E7")

        public static final String TYPE_RESOURCE_ID = "typeResourceId";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.626 -0500", hash_original_field = "50C213A8E1A7C5BA9F092F856CA065B5", hash_generated_field = "78A07F035FAA45648EFB54670D54860D")

        public static final String DISPLAY_NAME = "displayName";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.629 -0500", hash_original_field = "6FB07F5B89DD688E6E4A5A0CE89BFE10", hash_generated_field = "4822F23B2FE5726D519161D8033D2510")

        public static final String DIRECTORY_AUTHORITY = "authority";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.631 -0500", hash_original_field = "7F269FA2CBD4C9F1441C08555F5F94F3", hash_generated_field = "14F626F5827ECD6989F9CED7C950B057")

        public static final String ACCOUNT_TYPE = "accountType";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.634 -0500", hash_original_field = "E38232663A661354726761B7E0BF9F47", hash_generated_field = "5F618676BF9315685112C847A236AC4A")

        public static final String ACCOUNT_NAME = "accountName";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.637 -0500", hash_original_field = "26D293D9C84C9C10200E2BB06B362EA8", hash_generated_field = "554D6F2B634F4E8EC5B4B61FAF5A5EC0")

        public static final String EXPORT_SUPPORT = "exportSupport";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.640 -0500", hash_original_field = "D31479B21941E42C62A0361F10E6E8E0", hash_generated_field = "8BBD44385214899CBA373373776BC8D7")

        public static final int EXPORT_SUPPORT_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.642 -0500", hash_original_field = "9B9C2A3BBC3324C4CE2FEA9D542AB603", hash_generated_field = "E813A39147A493EC08907EAF30FF09A8")

        public static final int EXPORT_SUPPORT_SAME_ACCOUNT_ONLY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.645 -0500", hash_original_field = "3C6748CCA466BD2915242757329D0864", hash_generated_field = "1F072DB4A2A9172E40F4F24F1A0DA31D")

        public static final int EXPORT_SUPPORT_ANY_ACCOUNT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.647 -0500", hash_original_field = "BC58D7C60155267BE429C0DA71BC069B", hash_generated_field = "49B991BA70BFA63B7B365B94EDD7D9F7")

        public static final String SHORTCUT_SUPPORT = "shortcutSupport";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.650 -0500", hash_original_field = "896ACB4110DA324684BC245E181B7D0E", hash_generated_field = "7D5722842A6B1242F73D42679F9A6334")

        public static final int SHORTCUT_SUPPORT_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.652 -0500", hash_original_field = "36F2D0363A143FD1051C82259CDEE311", hash_generated_field = "6F2ACF35F3714563F3AD0C38919EB143")

        public static final int SHORTCUT_SUPPORT_DATA_ITEMS_ONLY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.655 -0500", hash_original_field = "DB08E885FA4C2AFEAD8BF04371991415", hash_generated_field = "CC854A806F8946D877881D62895DFAA9")

        public static final int SHORTCUT_SUPPORT_FULL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.657 -0500", hash_original_field = "B0C7F6BDE50CB8F17809D935BDCBF6DC", hash_generated_field = "A309841362551FF88F370A53BD881109")

        public static final String PHOTO_SUPPORT = "photoSupport";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.660 -0500", hash_original_field = "FE7925F6CB5A090CEEB1179A0377F0C0", hash_generated_field = "8029E66303C1933A09F6513D500196A1")

        public static final int PHOTO_SUPPORT_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.663 -0500", hash_original_field = "BB2DA20632AA02DA2AB214C5038E5CF3", hash_generated_field = "A734B382DF477239279F9668CECEB7D3")

        public static final int PHOTO_SUPPORT_THUMBNAIL_ONLY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.665 -0500", hash_original_field = "29217F7940790A2B7F68F208963155C2", hash_generated_field = "AB5A7DA7C57E4171039C7EA9CAE5BE24")

        public static final int PHOTO_SUPPORT_FULL_SIZE_ONLY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.668 -0500", hash_original_field = "647853C552AB68B98A00606A4D01A7AC", hash_generated_field = "D72B5FD4DEE70B19F572B6BE7A1DA5FC")

        public static final int PHOTO_SUPPORT_FULL = 3;

        /**
         * Not instantiable.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.605 -0500", hash_original_method = "C1FAFD7F8C25A27903905826E99B3CB4", hash_generated_method = "DD04442C13079199BDA087C439488FE5")
        
private Directory() {
        }
    }
    
    public static final class SyncState implements SyncStateContract.Columns {

        /**
         * @see android.provider.SyncStateContract.Helpers#get
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.687 -0500", hash_original_method = "466578A19F0FCF2DD10FDB6DAFFC0887", hash_generated_method = "2968688090F0A89899005B639287D49D")
        
public static byte[] get(ContentProviderClient provider, Account account)
                throws RemoteException {
            return SyncStateContract.Helpers.get(provider, CONTENT_URI, account);
        }

        /**
         * @see android.provider.SyncStateContract.Helpers#get
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.689 -0500", hash_original_method = "B9E8FB5AB055D4E1E45E9949F3C016CF", hash_generated_method = "6E822DD6634A9EBA8F5FA49F5EB38784")
        
public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Account account)
                throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(provider, CONTENT_URI, account);
        }

        /**
         * @see android.provider.SyncStateContract.Helpers#set
         */
        @DSSink({DSSinkKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.692 -0500", hash_original_method = "579F427E12689D3799FB7240CB2CED7E", hash_generated_method = "0929C6A0E720D5E2073DF205F65D7551")
        
public static void set(ContentProviderClient provider, Account account, byte[] data)
                throws RemoteException {
            SyncStateContract.Helpers.set(provider, CONTENT_URI, account, data);
        }

        /**
         * @see android.provider.SyncStateContract.Helpers#newSetOperation
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.695 -0500", hash_original_method = "4E10B60B39C26218926D7406FB7CC71E", hash_generated_method = "4874286873285082166E1414165C7F12")
        
public static ContentProviderOperation newSetOperation(Account account, byte[] data) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, data);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.682 -0500", hash_original_field = "E8C57D74C792F88386CA3DAD09DDB1BA", hash_generated_field = "B8243A9F992B1927826CEDCE0876B770")

        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.684 -0500", hash_original_field = "C1EA74B2428365CED3D656387FEA49B7", hash_generated_field = "D7D188013240FCCAF388869D2E2EBFDE")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, CONTENT_DIRECTORY);
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.678 -0500", hash_original_method = "C3CB9524AE86EE634A43E203167EAA5A", hash_generated_method = "B49E3D8116D56A750AEF2EA2BBA629A3")
        
private SyncState() {}
    }
    
    public static final class ProfileSyncState implements SyncStateContract.Columns {

        /**
         * @see android.provider.SyncStateContract.Helpers#get
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.707 -0500", hash_original_method = "466578A19F0FCF2DD10FDB6DAFFC0887", hash_generated_method = "2968688090F0A89899005B639287D49D")
        
public static byte[] get(ContentProviderClient provider, Account account)
                throws RemoteException {
            return SyncStateContract.Helpers.get(provider, CONTENT_URI, account);
        }

        /**
         * @see android.provider.SyncStateContract.Helpers#get
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.710 -0500", hash_original_method = "B9E8FB5AB055D4E1E45E9949F3C016CF", hash_generated_method = "6E822DD6634A9EBA8F5FA49F5EB38784")
        
public static Pair<Uri, byte[]> getWithUri(ContentProviderClient provider, Account account)
                throws RemoteException {
            return SyncStateContract.Helpers.getWithUri(provider, CONTENT_URI, account);
        }

        /**
         * @see android.provider.SyncStateContract.Helpers#set
         */
        @DSSink({DSSinkKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.713 -0500", hash_original_method = "579F427E12689D3799FB7240CB2CED7E", hash_generated_method = "0929C6A0E720D5E2073DF205F65D7551")
        
public static void set(ContentProviderClient provider, Account account, byte[] data)
                throws RemoteException {
            SyncStateContract.Helpers.set(provider, CONTENT_URI, account, data);
        }

        /**
         * @see android.provider.SyncStateContract.Helpers#newSetOperation
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.715 -0500", hash_original_method = "4E10B60B39C26218926D7406FB7CC71E", hash_generated_method = "4874286873285082166E1414165C7F12")
        
public static ContentProviderOperation newSetOperation(Account account, byte[] data) {
            return SyncStateContract.Helpers.newSetOperation(CONTENT_URI, account, data);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.702 -0500", hash_original_field = "E8C57D74C792F88386CA3DAD09DDB1BA", hash_generated_field = "B8243A9F992B1927826CEDCE0876B770")

        public static final String CONTENT_DIRECTORY =
                SyncStateContract.Constants.CONTENT_DIRECTORY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.705 -0500", hash_original_field = "BA4F0FCD9C107FCAD301F57E9BA4E30E", hash_generated_field = "A12A5FA95C37F6B7E0F5ADA8AB6D997E")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, CONTENT_DIRECTORY);
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.700 -0500", hash_original_method = "1AF1C4539078F536A57F5CC0E82C2CE1", hash_generated_method = "E8BD1E6F807FEECBD8C5F138BED93963")
        
private ProfileSyncState() {}
    }
    
    public final static class ContactCounts {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.777 -0500", hash_original_field = "90EF19E00CA4BCDB57B7036D915729BF", hash_generated_field = "7C98B52260D9013556878BD20F22F6D5")

        public static final String ADDRESS_BOOK_INDEX_EXTRAS = "address_book_index_extras";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.779 -0500", hash_original_field = "951A1D7F0FD47C76BAC21877BC538AB7", hash_generated_field = "DE6D8EE389A22FA73B65287BD3DB9204")

        public static final String EXTRA_ADDRESS_BOOK_INDEX_TITLES = "address_book_index_titles";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.782 -0500", hash_original_field = "0FA275FB152DE289621EFD9A10DE52B7", hash_generated_field = "109D0DA1E42CE04FEDF0308632673861")

        public static final String EXTRA_ADDRESS_BOOK_INDEX_COUNTS = "address_book_index_counts";
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.208 -0400", hash_original_method = "CB1CFE8B6024EEF8B52112C6EF2CC42E", hash_generated_method = "CB1CFE8B6024EEF8B52112C6EF2CC42E")
        public ContactCounts ()
        {
            //Synthesized constructor
        }
    }
    
    public static class Contacts implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {

        /**
         * Builds a {@link #CONTENT_LOOKUP_URI} style {@link Uri} describing the
         * requested {@link Contacts} entry.
         *
         * @param contactUri A {@link #CONTENT_URI} row, or an existing
         *            {@link #CONTENT_LOOKUP_URI} to attempt refreshing.
         */
        @DSSpec(DSCat.CONTACT)
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.803 -0500", hash_original_method = "297CD8052D16F966DA20463FE5C9F18D", hash_generated_method = "E132A7F36CE1995AD84D3CA4E748E1F1")
        
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

        /**
         * Build a {@link #CONTENT_LOOKUP_URI} lookup {@link Uri} using the
         * given {@link ContactsContract.Contacts#_ID} and {@link #LOOKUP_KEY}.
         */
        @DSSpec(DSCat.CONTACT)
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.805 -0500", hash_original_method = "0E35577C3A2634FAB6CE2A7C0110A8D4", hash_generated_method = "7A2D838CE8D4D565E159F4336E306008")
        
public static Uri getLookupUri(long contactId, String lookupKey) {
            return ContentUris.withAppendedId(Uri.withAppendedPath(Contacts.CONTENT_LOOKUP_URI,
                    lookupKey), contactId);
        }

        /**
         * Computes a content URI (see {@link #CONTENT_URI}) given a lookup URI.
         * <p>
         * Returns null if the contact cannot be found.
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.808 -0500", hash_original_method = "4F238AFCA9F990B01002B079DB33FCDE", hash_generated_method = "6BC905CC6054CBBC02A4C6C4B960B080")
        
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

        /**
         * Mark a contact as having been contacted. Updates two fields:
         * {@link #TIMES_CONTACTED} and {@link #LAST_TIME_CONTACTED}. The
         * TIMES_CONTACTED field is incremented by 1 and the LAST_TIME_CONTACTED
         * field is populated with the current system time.
         *
         * @param resolver the ContentResolver to use
         * @param contactId the person who was contacted
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.810 -0500", hash_original_method = "EA7A02146AEC4BB6B360E334F2919FC1", hash_generated_method = "C4C73B2ACE60C040EB1E3B2538CB1F2E")
        
public static void markAsContacted(ContentResolver resolver, long contactId) {
            Uri uri = ContentUris.withAppendedId(CONTENT_URI, contactId);
            ContentValues values = new ContentValues();
            // TIMES_CONTACTED will be incremented when LAST_TIME_CONTACTED is modified.
            values.put(LAST_TIME_CONTACTED, System.currentTimeMillis());
            resolver.update(uri, values, null, null);
        }

        /**
         * Opens an InputStream for the contacts's photo and returns the
         * photo as a byte stream.
         * @param cr The content resolver to use for querying
         * @param contactUri the contact whose photo should be used. This can be used with
         * either a {@link #CONTENT_URI} or a {@link #CONTENT_LOOKUP_URI} URI.
         * @param preferHighres If this is true and the contact has a higher resolution photo
         * available, it is returned. If false, this function always tries to get the thumbnail
         * @return an InputStream of the photo, or null if no photo is present
         */
        @DSComment("IO movement methodName")
        @DSSpec(DSCat.IO_ACTION_METHOD)
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.930 -0500", hash_original_method = "39CCF57C11710ED9D7B06C24BDE6652B", hash_generated_method = "81B22971803C149D0C82E0B6074B8933")
        
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
                    // fallback to the thumbnail code
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

        /**
         * Opens an InputStream for the contacts's thumbnail photo and returns the
         * photo as a byte stream.
         * @param cr The content resolver to use for querying
         * @param contactUri the contact whose photo should be used. This can be used with
         * either a {@link #CONTENT_URI} or a {@link #CONTENT_LOOKUP_URI} URI.
         * @return an InputStream of the photo, or null if no photo is present
         * @see #openContactPhotoInputStream(ContentResolver, Uri, boolean), if instead
         * of the thumbnail the high-res picture is preferred
         */
        @DSComment("IO movement methodName")
        @DSSpec(DSCat.IO_ACTION_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.932 -0500", hash_original_method = "38D81F9B93E07ADE0E2E072FADEAEAB2", hash_generated_method = "366EB5E49CE660D34F00F358317E4C64")
        
public static InputStream openContactPhotoInputStream(ContentResolver cr, Uri contactUri) {
            return openContactPhotoInputStream(cr, contactUri, false);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.790 -0500", hash_original_field = "26476F6EBEF92A011D86733E19A8EE4D", hash_generated_field = "5370BB56B85850A889ED03A2FA6172D9")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "contacts");
        
        public static final class Data implements BaseColumns, DataColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.992 -0500", hash_original_field = "C8A43A921088C098D7CBCE1B2AFE5A8D", hash_generated_field = "9B918616E0E439AEB554FBB4A1A7DAFD")

            public static final String CONTENT_DIRECTORY = "data";
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.132 -0500", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "DA3324DED8188362CBB4DD2028BC1249")
        
private Data() {}
        }
        
        public static final class Entity implements BaseColumns, ContactsColumns, ContactNameColumns, RawContactsColumns, BaseSyncColumns, SyncColumns, DataColumns, StatusColumns, ContactOptionsColumns, ContactStatusColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.848 -0500", hash_original_field = "DA3D19AF30BE6813C8B54E768CBFA3FA", hash_generated_field = "FFD23D74408F7344A82A6777888A9F41")

            public static final String CONTENT_DIRECTORY = "entities";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.850 -0500", hash_original_field = "8352F712F6E11A0595A51E28E2DA745E", hash_generated_field = "4843237709B7C68BA8EA2D088BC7ADBB")

            public static final String RAW_CONTACT_ID = "raw_contact_id";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.003 -0500", hash_original_field = "1CBDE7B20E0DE53938AFB3060D92ED3F", hash_generated_field = "BF40874F004CCCDE98B1D602D4FC4265")

            public static final String DATA_ID = "data_id";
            /**
             * no public constructor since this is a utility class
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.997 -0500", hash_original_method = "607EBA13DCD67902F3CEC6239F391768", hash_generated_method = "75F462E173BDF00A680AA0EE2DD1A435")
            
private Entity() {
            }
        }
        
        public static final class StreamItems implements StreamItemsColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.010 -0500", hash_original_field = "D318A4E0D800ECC2D52F82E625ABC22A", hash_generated_field = "13CE0BD71DF45E7185B296A116872C44")

            public static final String CONTENT_DIRECTORY = "stream_items";
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.051 -0500", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "38419D10162DE19B56D626859AF70FC1")
        
private StreamItems() {
        }
        }
        
        public static final class AggregationSuggestions implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactStatusColumns {

            /**
             * @hide
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.908 -0500", hash_original_method = "B7290700D54BBB985B4CC30322753CF6", hash_generated_method = "C24B0573979CF7DEB9AEBD50BF3FB4FB")
            
public static final Builder builder() {
                return new Builder();
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.871 -0500", hash_original_field = "4805436DEC852F13579D74FAB7D1D026", hash_generated_field = "6EEA28F01E23AE920EA0888EF515D1EA")

            public static final String CONTENT_DIRECTORY = "suggestions";
            
            public static final class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.884 -0500", hash_original_field = "12ACBC5C734713F3E386C7F89D418BF2", hash_generated_field = "54B9A457EEF3B70924549BAF472FB470")

                private long mContactId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.887 -0500", hash_original_field = "CBE74DB09F7ADCB3B195A09F2A393655", hash_generated_field = "3C3B2250459C9384D9803616C1A141B8")

                private ArrayList<String> mKinds = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.889 -0500", hash_original_field = "B26A83061D2DF78962A4E37C3A47E6CD", hash_generated_field = "FAD416ACD528C34B72B989001FEFE40D")

                private ArrayList<String> mValues = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.892 -0500", hash_original_field = "EAF07362CB0DE5A45A6B09193DE62144", hash_generated_field = "4EC83DFC67A77EF18032B269F8E92E02")

                private int mLimit;
                
                @DSSafe(DSCat.SAFE_OTHERS)
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.210 -0400", hash_original_method = "02DE293B5727013333ED4AAA68C7342C", hash_generated_method = "02DE293B5727013333ED4AAA68C7342C")
                public Builder ()
                {
                    //Synthesized constructor
                }

                /**
                 * Optional existing contact ID.  If it is not provided, the search
                 * will be based exclusively on the values supplied with {@link #addParameter}.
                 */
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.895 -0500", hash_original_method = "9AAB1F7A5A7D8D5960972B4CBC4F52B3", hash_generated_method = "3A87004D4D373E14FC5C67A7C9C85809")
                
public Builder setContactId(long contactId) {
                    this.mContactId = contactId;
                    return this;
                }

                /**
                 * A value that can be used when searching for an aggregation
                 * suggestion.
                 *
                 * @param kind can be one of
                 *            {@link AggregationSuggestions#PARAMETER_MATCH_NAME},
                 *            {@link AggregationSuggestions#PARAMETER_MATCH_EMAIL},
                 *            {@link AggregationSuggestions#PARAMETER_MATCH_NICKNAME},
                 *            {@link AggregationSuggestions#PARAMETER_MATCH_PHONE}
                 */
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.897 -0500", hash_original_method = "C32C8611EF5F2627AFE89485D07DC5FB", hash_generated_method = "2C323292DDEB32D1F5154AFD362D1329")
                
public Builder addParameter(String kind, String value) {
                    if (!TextUtils.isEmpty(value)) {
                        mKinds.add(kind);
                        mValues.add(value);
                    }
                    return this;
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.900 -0500", hash_original_method = "C603E268BE9EB815AE093A2C036882D2", hash_generated_method = "2C4C31837B282AC686F0142D49D79F82")
                
public Builder setLimit(int limit) {
                    mLimit = limit;
                    return this;
                }

                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.903 -0500", hash_original_method = "CC75446D812A1F4BC170E31BF0668A44", hash_generated_method = "3F3251B1F322C22EFBA60CDC8456CCAE")
                
public Uri build() {
                    android.net.Uri.Builder builder = Contacts.CONTENT_URI.buildUpon();
                    builder.appendEncodedPath(String.valueOf(mContactId));
                    builder.appendPath(Contacts.AggregationSuggestions.CONTENT_DIRECTORY);
                    if (mLimit != 0) {
                        builder.appendQueryParameter("limit", String.valueOf(mLimit));
                    }

                    int count = mKinds.size();
                    for (int i = 0; i < count; i++) {
                        builder.appendQueryParameter("query", mKinds.get(i) + ":" + mValues.get(i));
                    }

                    return builder.build();
                }
                
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.873 -0500", hash_original_field = "A6B5E374DB080F39BF928CDC60E4C47C", hash_generated_field = "B6AF81729D92C3DC946A8E696FBD665C")

            public static final String PARAMETER_MATCH_NAME = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.876 -0500", hash_original_field = "4B0AEC898D66B9D50C4552F5549F4370", hash_generated_field = "25766439F31846B59A3B38ECEDFE371A")

            public static final String PARAMETER_MATCH_EMAIL = "email";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.879 -0500", hash_original_field = "7D060209C34D472961B8491C2F22ED7E", hash_generated_field = "DB4ACE45E803F4F53078A3EC91A52C0A")

            public static final String PARAMETER_MATCH_PHONE = "phone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.881 -0500", hash_original_field = "2A741448416405EDF5DCD970DED4E416", hash_generated_field = "F064A94D0E7532DD6A308404CBA1299D")

            public static final String PARAMETER_MATCH_NICKNAME = "nickname";
            /**
             * No public constructor since this is a utility class
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.868 -0500", hash_original_method = "35E5891C5F5088704DD7A6D202E906B4", hash_generated_method = "5A22D9C6D1242BD04481CFF9EAA01E44")
            
private AggregationSuggestions() {}
        }
        
        public static final class Photo implements BaseColumns, DataColumnsWithJoins {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.917 -0500", hash_original_field = "FE3767F034EDE64D3E36F26FDB2DD64E", hash_generated_field = "AF03CF5B5172F2903B579B1D0EA79FB9")

            public static final String CONTENT_DIRECTORY = "photo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.920 -0500", hash_original_field = "4AFBA3D6489C4FDDCC20DA7A644D04F8", hash_generated_field = "701A2F7AD17160EF4D7EDA112829F17C")

            public static final String DISPLAY_PHOTO = "display_photo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.662 -0500", hash_original_field = "9BC47F1FC57AFD05B22B089D813BDB34", hash_generated_field = "827F52308AEA6086917181CAD2690C59")

            public static final String PHOTO_FILE_ID = DATA14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.664 -0500", hash_original_field = "AA811BA0A84943F871646F1291441C57", hash_generated_field = "2769AC225261CB92B8111CE835D1CB36")

            public static final String PHOTO = DATA15;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.656 -0500", hash_original_method = "C03E3395BFF21729CC93322BBC7A82DE", hash_generated_method = "6D1AF7E63DEE3A9E3B5F0EF4008EBD20")
            
private Photo() {}
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.793 -0500", hash_original_field = "9E52D376C38E382140806B42B89AE700", hash_generated_field = "F94DD7AE0907A95C5597A5A8773EE09E")

        public static final Uri CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI,
                "lookup");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.795 -0500", hash_original_field = "25CB4134A7EC1E8DF033DB733A148C8F", hash_generated_field = "284F3AE95B142F252DBD1B29255F0C8E")

        public static final Uri CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI,
                "as_vcard");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.798 -0500", hash_original_field = "5E8446EA1A276781559AB323125CC56C", hash_generated_field = "58AA446E970DB4E6ED2A543CA3B1757C")

        public static final String QUERY_PARAMETER_VCARD_NO_PHOTO = "nophoto";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.801 -0500", hash_original_field = "00967C448B4F4C3AA9204A3DF25CFC12", hash_generated_field = "391833C98BFA17A505F59D33CCBFA2A4")

        public static final Uri CONTENT_MULTI_VCARD_URI = Uri.withAppendedPath(CONTENT_URI,
                "as_multi_vcard");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.813 -0500", hash_original_field = "89BBCEA44CB56D6651E90104E764CABC", hash_generated_field = "36A83EB7BAEC220CEDCCB9CC5B7F20BE")

        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(
                CONTENT_URI, "filter");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.817 -0500", hash_original_field = "111AE6DC4A9E248F0825E419D9AB32B4", hash_generated_field = "474F361F7A54257A5783BF94FAA14DDB")

        public static final Uri CONTENT_STREQUENT_URI = Uri.withAppendedPath(
                CONTENT_URI, "strequent");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.820 -0500", hash_original_field = "ADB337E567C42D518F24E3B2AFC5F70A", hash_generated_field = "F06E3D05418C4E3F3E9D231A8F0769A0")

        public static final Uri CONTENT_FREQUENT_URI = Uri.withAppendedPath(
                CONTENT_URI, "frequent");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.823 -0500", hash_original_field = "15707C34A32C017C99E1A783582C71D1", hash_generated_field = "1EEBE319236CD0056F5C09998F70A1A5")

        public static final Uri CONTENT_STREQUENT_FILTER_URI = Uri.withAppendedPath(
                CONTENT_STREQUENT_URI, "filter");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.826 -0500", hash_original_field = "7818F01D66ECE482A42E35C19D2D2816", hash_generated_field = "F8700FD8F66119DCF4D9FA84EFAB6107")

        public static final Uri CONTENT_GROUP_URI = Uri.withAppendedPath(
                CONTENT_URI, "group");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.828 -0500", hash_original_field = "4044EFC46C40E06302B8F4E601B3F455", hash_generated_field = "C1454D5C98A71A32CF2C3F72272BFADA")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.831 -0500", hash_original_field = "E286DA6ACA49308D52B375B7D89606F3", hash_generated_field = "305304684328E09949E78A8A8CBCA5EE")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.833 -0500", hash_original_field = "CC474DFA56B80F4C93EFA5E8860E79F3", hash_generated_field = "C67F5807C996D0CE4AF6FF7765FC33B6")

        public static final String CONTENT_VCARD_TYPE = "text/x-vcard";
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.788 -0500", hash_original_method = "F5E3085137E37D29F0F8CB3C296F1F57", hash_generated_method = "47D4A76F75042B03A266F16D90E98429")
        
private Contacts()  {}
    }
    
    public static final class Profile implements BaseColumns, ContactsColumns, ContactOptionsColumns, ContactNameColumns, ContactStatusColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.944 -0500", hash_original_field = "E798EF6EA0A786A3B268A64743C5AF28", hash_generated_field = "576B190C7713DF6E5188A93DF9D0AD71")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "profile");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.946 -0500", hash_original_field = "25CB4134A7EC1E8DF033DB733A148C8F", hash_generated_field = "284F3AE95B142F252DBD1B29255F0C8E")

        public static final Uri CONTENT_VCARD_URI = Uri.withAppendedPath(CONTENT_URI,
                "as_vcard");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.949 -0500", hash_original_field = "783126B8562D0588256565DEC8AD2F55", hash_generated_field = "1A0853607327F8109D4DB0C1DDD8F59A")

        public static final Uri CONTENT_RAW_CONTACTS_URI = Uri.withAppendedPath(CONTENT_URI,
                "raw_contacts");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.952 -0500", hash_original_field = "3FF7400ED55E2CFBC3E75E42A39D22CE", hash_generated_field = "45A7B61E283404557CA14624BA550793")

        public static final long MIN_ID = Long.MAX_VALUE - (long) Integer.MAX_VALUE;
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.941 -0500", hash_original_method = "B87424FB8F4DF05D98854CA5453341A1", hash_generated_method = "2C9B95C76153E2E5E4B2D5C2F4C6ADDB")
        
private Profile() {
        }
    }
    
    public static final class RawContacts implements BaseColumns, RawContactsColumns, ContactOptionsColumns, ContactNameColumns, SyncColumns {

        /**
         * Build a {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI}
         * style {@link Uri} for the parent {@link android.provider.ContactsContract.Contacts}
         * entry of the given {@link RawContacts} entry.
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.985 -0500", hash_original_method = "4F63AD3366CF1143E7246464BD728917", hash_generated_method = "D0392F095AF9CF97B1A8AB2473A67AA2")
        
public static Uri getContactLookupUri(ContentResolver resolver, Uri rawContactUri) {
            // TODO: use a lighter query by joining rawcontacts with contacts in provider
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

        /**
         * TODO: javadoc
         * @param cursor
         * @return
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.021 -0500", hash_original_method = "7C8784537648600B4251C9E262BFEFC5", hash_generated_method = "9F167F07FC0CADA08203BAA255DB9A81")
        
public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.968 -0500", hash_original_field = "692DA203B8BFDCAFAD03981A5F8419A1", hash_generated_field = "7285DD00B1DE1BA2EB1E93374C16DBE6")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "raw_contacts");
        
        public static final class Data implements BaseColumns, DataColumns {
            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "244843A89660565990A10147301407C3", hash_generated_field = "9B918616E0E439AEB554FBB4A1A7DAFD")

            public static final String CONTENT_DIRECTORY = "data";
            
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "68BBF991BD74A1EFA8A89E7D9D24A1BD")
            private  Data() {
                // ---------- Original Method ----------
            }
        }
        
        public static final class Entity implements BaseColumns, DataColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.000 -0500", hash_original_field = "3D126FD6B95E114E5AD9A93E5B95D488", hash_generated_field = "D55A4C79393D833EAA5D07CD4A1C37E3")

            public static final String CONTENT_DIRECTORY = "entity";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "25A0C98C2CD9718D3437CC55222F352D", hash_generated_field = "BF40874F004CCCDE98B1D602D4FC4265")

            public static final String DATA_ID = "data_id";
            
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_method = "607EBA13DCD67902F3CEC6239F391768", hash_generated_method = "72BDB032AD922DE54B8D777470530676")
            private  Entity() {
                // ---------- Original Method ----------
            }
        }
        
        public static final class StreamItems implements BaseColumns, StreamItemsColumns {
            
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_field = "AB527CF994C1B112B0ECF7E138BA21A0", hash_generated_field = "13CE0BD71DF45E7185B296A116872C44")

            public static final String CONTENT_DIRECTORY = "stream_items";
            
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.212 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "49F523F180DE7D539C580F6D11E59338")
            private  StreamItems() {
                // ---------- Original Method ----------
            }
        }
        
        public static final class DisplayPhoto {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.018 -0500", hash_original_field = "3F579817DBBC68DE4671FDFF24DEB52D", hash_generated_field = "C1D586C4476D33FF0691486D25CE47B6")

            public static final String CONTENT_DIRECTORY = "display_photo";
        /**
         * no public constructor since this is a utility class
         */
        @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.932 -0500", hash_original_method = "4DA607ACD5E6F502EC932EC179042892", hash_generated_method = "9B7660F77E769FF58079F4D88E0594FA")
        
private DisplayPhoto() {}
        }
        
        private static class EntityIteratorImpl extends CursorEntityIterator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.025 -0500", hash_original_field = "A55C5B045DBFE7DB97B3365FE2019E42", hash_generated_field = "411B691BE1CB3F57E3AB0F44B5F5E61C")

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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.803 -0500", hash_original_method = "5371E683B36CD927F8174DD86149D4D5", hash_generated_method = "C5D2AD0229E9C4112FF33AA3AAB32CCA")
            
public EntityIteratorImpl(Cursor cursor) {
                super(cursor);
            }

            @DSSource({DSSourceKind.CONTACT_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.032 -0500", hash_original_method = "BE255AFD270DEBC5451268E05A1F1326", hash_generated_method = "A78D291A6706DAC674FEB344952A0C31")
            
@Override
            public android.content.Entity getEntityAndIncrementCursor(Cursor cursor)
                    throws RemoteException {
                final int columnRawContactId = cursor.getColumnIndexOrThrow(RawContacts._ID);
                final long rawContactId = cursor.getLong(columnRawContactId);

                // we expect the cursor is already at the row we need to read from
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

                // read data rows until the contact id changes
                do {
                    if (rawContactId != cursor.getLong(columnRawContactId)) {
                        break;
                    }
                    // add the data to to the contact
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
                    for (String key : DATA_KEYS) {
                        final int columnIndex = cursor.getColumnIndexOrThrow(key);
                        switch (cursor.getType(columnIndex)) {
                            case Cursor.FIELD_TYPE_NULL:
                                // don't put anything
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
                                throw new IllegalStateException("Invalid or unhandled data type");
                        }
                    }
                    contact.addSubValue(ContactsContract.Data.CONTENT_URI, cv);
                } while (cursor.moveToNext());

                return contact;
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.970 -0500", hash_original_field = "582FE2AF65CEF3BE91C4501DC58C6785", hash_generated_field = "DCAD7464C9BB668200B0A345532D9B88")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.973 -0500", hash_original_field = "5B3ABC69894F58FF0820726F092B70BB", hash_generated_field = "DB6D85C044D75849161B9D28B59008B5")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/raw_contact";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.975 -0500", hash_original_field = "2C8ADB2BD320855FEEF98CB68E8D5496", hash_generated_field = "161859A3F399C943CA06A430045EF8E5")

        public static final int AGGREGATION_MODE_DEFAULT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.978 -0500", hash_original_field = "05D30DF9404CE0F7F9C5FB55CE406F9A", hash_generated_field = "5D8A3BD7C1AFF541BC9D62807AA786BF")

        @Deprecated
        public static final int AGGREGATION_MODE_IMMEDIATE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.980 -0500", hash_original_field = "4E36B32B1816883C8EA1EE9AEBCBB1AF", hash_generated_field = "EC2DBD6DAEC29C27D73E90B647D29BD2")

        public static final int AGGREGATION_MODE_SUSPENDED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.983 -0500", hash_original_field = "C23FB6F3E2B3A7F2544E27F384AD38F2", hash_generated_field = "5B38CECCA30063F05904A1946763568D")

        public static final int AGGREGATION_MODE_DISABLED = 3;
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.965 -0500", hash_original_method = "6107CD4B76D912ACDA57642552743C0C", hash_generated_method = "FF9200DAB9E02B346F47DEFB7ACA80DD")
        
private RawContacts() {
        }
    }
    
    public static final class StreamItems implements BaseColumns, StreamItemsColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.054 -0500", hash_original_field = "D6F9ED0551EC45772045F21A9F2D5793", hash_generated_field = "FC402994047511C4F3F84FFF51EA5C9A")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "stream_items");
        
        public static final class StreamItemPhotos implements BaseColumns, StreamItemPhotosColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.073 -0500", hash_original_field = "FE3767F034EDE64D3E36F26FDB2DD64E", hash_generated_field = "AF03CF5B5172F2903B579B1D0EA79FB9")

            public static final String CONTENT_DIRECTORY = "photo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.076 -0500", hash_original_field = "BA1F21B1F5B2EB4BE1EE4AD370830C5D", hash_generated_field = "365500E1C6F9E4194C13B4EBED610BF4")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item_photo";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.078 -0500", hash_original_field = "C90F86EA7CB827F269A8D785E110AE91", hash_generated_field = "D8E04A706721AD03E95E429B2F7FCBE8")

            public static final String CONTENT_ITEM_TYPE
                    = "vnd.android.cursor.item/stream_item_photo";
        /**
         * No public constructor since this is a utility class
         */
        @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.096 -0500", hash_original_method = "52BE888A2784297EE4FE3818D09C55BC", hash_generated_method = "365A1D1F218F58A740618AC6E583E2CA")
        
private StreamItemPhotos() {
        }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.056 -0500", hash_original_field = "A4AD59AF1D06642363FFD58A009D7011", hash_generated_field = "0EE28EEC2EC78074DAB3EE95CB506E9B")

        public static final Uri CONTENT_PHOTO_URI = Uri.withAppendedPath(CONTENT_URI, "photo");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.059 -0500", hash_original_field = "B4215E9242F936B288FD8CA7F7EE5307", hash_generated_field = "3145145BE0A56CE4E90B223BAD89DB70")

        public static final Uri CONTENT_LIMIT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "stream_items_limit");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.061 -0500", hash_original_field = "87B85B82987F76E56E07F97F6C85B8F9", hash_generated_field = "EFDA5895598F764361ACC9C69FF92318")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/stream_item";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.064 -0500", hash_original_field = "ADBD7355E2CA503E8C23A8CA3C4F89C5", hash_generated_field = "E5CC7D9308B16720A481498C29FEC8A8")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/stream_item";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.067 -0500", hash_original_field = "75C68051BEF1213FC9778E27BEDF11FC", hash_generated_field = "7FC26EE40F1BE52F25C8FDA0BDE1FE79")

        public static final String MAX_ITEMS = "max_items";
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_method = "50B0D0B78D385E8C0BEE924F86CB84EC", hash_generated_method = "49F523F180DE7D539C580F6D11E59338")
        private  StreamItems() {
            // ---------- Original Method ----------
        }
    }
    
    public static final class StreamItemPhotos implements BaseColumns, StreamItemPhotosColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.098 -0500", hash_original_field = "07F1D95DC631EF3BF763EB897548B86E", hash_generated_field = "92E6F30B0EB548C6F00B8F457E0C981F")

        public static final String PHOTO = "photo";
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.214 -0400", hash_original_method = "52BE888A2784297EE4FE3818D09C55BC", hash_generated_method = "802E4A54077CF0761BF1353DB1940447")
        private  StreamItemPhotos() {
            // ---------- Original Method ----------
        }
    }
    
    public static final class PhotoFiles implements BaseColumns, PhotoFilesColumns {
        /**
         * No public constructor since this is a utility class
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.108 -0500", hash_original_method = "68B58AFB95B4CB9CF9AA43D4A8112325", hash_generated_method = "1D55691EF49821CB24DE30E4D230DE99")
        
private PhotoFiles() {
        }
        
    }
    
    public final static class Data implements DataColumnsWithJoins {

        /**
         * <p>
         * Build a {@link android.provider.ContactsContract.Contacts#CONTENT_LOOKUP_URI}
         * style {@link Uri} for the parent {@link android.provider.ContactsContract.Contacts}
         * entry of the given {@link ContactsContract.Data} entry.
         * </p>
         * <p>
         * Returns the Uri for the contact in the first entry returned by
         * {@link ContentResolver#query(Uri, String[], String, String[], String)}
         * for the provided {@code dataUri}.  If the query returns null or empty
         * results, silently returns null.
         * </p>
         */
        @DSSource({DSSourceKind.CONTACT_INFORMATION})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.139 -0500", hash_original_method = "0B01F4FFA9092B5AD574B1F239B48F30", hash_generated_method = "AEC79E50439816765945FD5849DA7650")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.134 -0500", hash_original_field = "2E7C47BE61F7D4ABFFA5B42F2B5E5AFC", hash_generated_field = "95A4534991EE8F72A7FC1C7FC6D1FBD0")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "data");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.137 -0500", hash_original_field = "3B51D7C52AA8E661C935DC119F94369E", hash_generated_field = "898557BE3B735C302E7B1C4299B53727")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/data";
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.215 -0400", hash_original_method = "AE2AC52C1B086D07AB414F4634EAA37E", hash_generated_method = "68BBF991BD74A1EFA8A89E7D9D24A1BD")
        private  Data() {
            // ---------- Original Method ----------
        }
    }
    
    public final static class RawContactsEntity implements BaseColumns, DataColumns, RawContactsColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.148 -0500", hash_original_field = "92454B944CF64EBCFC7A74EDFF25A43F", hash_generated_field = "2691991C42B4EBAA7AE90EC64057F986")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "raw_contact_entities");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.150 -0500", hash_original_field = "33255D85379405DC65FBA69EC6F195CB", hash_generated_field = "7AE7F53593E48E967334734710332328")

        public static final Uri PROFILE_CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, "raw_contact_entities");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.152 -0500", hash_original_field = "34FDF9B108BC482CA753133674C895AD", hash_generated_field = "1D2377EB5383F4BB03D840672D3FA493")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/raw_contact_entity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.155 -0500", hash_original_field = "7D43D04E39D9F0AFE03768D0DB244B58", hash_generated_field = "3EEDAB288B134F8C666FC4687FCAE8BB")

        public static final String FOR_EXPORT_ONLY = "for_export_only";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.158 -0500", hash_original_field = "1CBDE7B20E0DE53938AFB3060D92ED3F", hash_generated_field = "BF40874F004CCCDE98B1D602D4FC4265")

        public static final String DATA_ID = "data_id";
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.145 -0500", hash_original_method = "F8C55B41037119D58D30171BDB7F39D2", hash_generated_method = "7A70D09DFEE9FBC6BA095C3DA7D817B5")
        
private RawContactsEntity() {}
    }
    
    public static final class PhoneLookup implements BaseColumns, PhoneLookupColumns, ContactsColumns, ContactOptionsColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.170 -0500", hash_original_field = "345FEBB5C3702ED76C075C9A9A7FD3D1", hash_generated_field = "F04B043C3F594CDD163F409C21510A7E")

        public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(AUTHORITY_URI,
                "phone_lookup");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.172 -0500", hash_original_field = "97409DF0221EA9C6032070E7F488041C", hash_generated_field = "30404B469C9128095296311F42B40FDE")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_lookup";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.175 -0500", hash_original_field = "3A462D25D2A81648F163C29C12AF3781", hash_generated_field = "985797C42025450A2C9AB6E09C2F752F")

        public static final String QUERY_PARAMETER_SIP_ADDRESS = "sip";
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.167 -0500", hash_original_method = "D1B05D947AED4866E4130EF727A894C9", hash_generated_method = "7AA746A32F115FA8E51ACF0B69B1B25D")
        
private PhoneLookup() {}
    }
    
    public static class StatusUpdates implements StatusColumns, PresenceColumns {

        /**
         * Gets the resource ID for the proper presence icon.
         *
         * @param status the status to get the icon for
         * @return the resource ID for the proper presence icon
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.192 -0500", hash_original_method = "446C58B7C43E87E7412C64E179FEA5CC", hash_generated_method = "EF5E82C19EF553E428718BFD405FABEC")
        
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

        /**
         * Returns the precedence of the status code the higher number being the higher precedence.
         *
         * @param status The status code.
         * @return An integer representing the precedence, 0 being the lowest.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.194 -0500", hash_original_method = "039C6EEFF77EBB58265A91F8AD87418B", hash_generated_method = "4D0C30E42341F0E2A64051DD9268100C")
        
public static final int getPresencePrecedence(int status) {
            // Keep this function here incase we want to enforce a different precedence than the
            // natural order of the status constants.
            return status;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.186 -0500", hash_original_field = "2952C581F3EB9DE168F76744433D1928", hash_generated_field = "88E7D9C5C6FEB3AF5270DABBA759AE3A")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "status_updates");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.189 -0500", hash_original_field = "BCA86828404FB3869CAA985AD73AB17A", hash_generated_field = "AA5C18CF423A3168345A85ED05A32992")

        public static final Uri PROFILE_CONTENT_URI =
                Uri.withAppendedPath(Profile.CONTENT_URI, "status_updates");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.197 -0500", hash_original_field = "9F6D54A66A60389A78A1CCA66AD62658", hash_generated_field = "6F3612433DE8232DF53A7F7EA4FCB8B8")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/status-update";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.199 -0500", hash_original_field = "E50EEFC342ADAA015BF38B7408197084", hash_generated_field = "FC77E159184ACDCF5CAF4DE0BD2D3C5F")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/status-update";

        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.183 -0500", hash_original_method = "5AF8C140309DC273491B33B4E92E1FA7", hash_generated_method = "72BB942F4DB8CA23BC83A54E18388E68")
        
private StatusUpdates() {}
    }
    
    public static final class Presence extends StatusUpdates {
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_method = "FECDF62B9774A3653EF2E5C629F7A49B", hash_generated_method = "FECDF62B9774A3653EF2E5C629F7A49B")
        public Presence ()
        {
            //Synthesized constructor
        }

    }
    
    public static class SearchSnippetColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.207 -0500", hash_original_field = "87FCA52EA58A2965EB4E1E9BA6CFAFF9", hash_generated_field = "461E02376DD761106C9F50F56F21857C")

        public static final String SNIPPET = "snippet";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.210 -0500", hash_original_field = "1F0D760F8349C301F771D58B839B396F", hash_generated_field = "E4D9391F49F8820BDEAF86A98DC60B19")

        public static final String SNIPPET_ARGS_PARAM_KEY = "snippet_args";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.213 -0500", hash_original_field = "1C4F8F9705A16A63F3B270D56AF29E86", hash_generated_field = "541AFA6473BC35F6E27D1822D720D073")

        public static final String DEFERRED_SNIPPETING_KEY = "deferred_snippeting";
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.216 -0400", hash_original_method = "04F7D0EC16DDA5BE74B3F08104BE0CC7", hash_generated_method = "04F7D0EC16DDA5BE74B3F08104BE0CC7")
        public SearchSnippetColumns ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class CommonDataKinds {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.221 -0500", hash_original_field = "8E4017038514CE1EF98C90530F007A29", hash_generated_field = "32BD4CF7EC356B02DEA3FD704AF6D66A")

        public static final String PACKAGE_COMMON = "common";
        
        public static final class StructuredName implements DataColumnsWithJoins {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.233 -0500", hash_original_field = "DA4E57E9D9A0AF91BF3A7D4C7E0F9E7D", hash_generated_field = "59A4296BAB0F9508FBD1495BE3B9C4C3")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.236 -0500", hash_original_field = "2FA410868DCD26F223D52CD0F96E6ED6", hash_generated_field = "199CF0CE8A05A4E4F7553B6DA8FFD70F")

            public static final String DISPLAY_NAME = DATA1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.238 -0500", hash_original_field = "7ED301AC3E301B5C972ECBCAA7E13F49", hash_generated_field = "7BBF136B8FF9EC2E4C80F2637C98B7DF")

            public static final String GIVEN_NAME = DATA2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.241 -0500", hash_original_field = "91F4C4E42BE12ADCA506D954D12B66EE", hash_generated_field = "7AF5C7B7B60F31AAEA9C5C3C0C6022A8")

            public static final String FAMILY_NAME = DATA3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.243 -0500", hash_original_field = "3B399D849E0990BAF9CF232B29961F24", hash_generated_field = "52881D04085082B470A84A14D73B3891")

            public static final String PREFIX = DATA4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.246 -0500", hash_original_field = "D5A23C8FB9F43ED506D6160A802C9DE3", hash_generated_field = "C44477DB7B58D73AA74E0EBC13A34C0B")

            public static final String MIDDLE_NAME = DATA5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.249 -0500", hash_original_field = "3595A13F1CDEA0E022C1A00335220545", hash_generated_field = "11F1997DAD362CD7C8F2DBB65FD6F879")

            public static final String SUFFIX = DATA6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.252 -0500", hash_original_field = "D798ABE832DF17384B2B0B3219F1DF7B", hash_generated_field = "5466114C91CBE46D3AEE8B69467D4203")

            public static final String PHONETIC_GIVEN_NAME = DATA7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.255 -0500", hash_original_field = "F47E3D1F120B8A2E337DA24737D8FE1B", hash_generated_field = "A70DED12273525CC3ED65CA485A32BE0")

            public static final String PHONETIC_MIDDLE_NAME = DATA8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.258 -0500", hash_original_field = "F11E81B1DF6198E09979AAD672305B83", hash_generated_field = "4762CC8AA74F9EED4CCF662E97D8F23E")

            public static final String PHONETIC_FAMILY_NAME = DATA9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.260 -0500", hash_original_field = "260E33044B41CFB9491B8498F1A47EB6", hash_generated_field = "2072B3FB2A2D770E18E0576BB7E38BFA")

            public static final String FULL_NAME_STYLE = DATA10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.264 -0500", hash_original_field = "B4BE04CBD3D430A43596C1D9CF7F5BEB", hash_generated_field = "5C4BCAADD6F8F847E0CCFFEAC1EC0894")

            public static final String PHONETIC_NAME_STYLE = DATA11;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.230 -0500", hash_original_method = "3FC3D91ED9F213084C3DE2075E5DC6AD", hash_generated_method = "ABBBB4B99B75CEFCCF6BB9ED0DC43F49")
            
private StructuredName() {}
        }
        
        public static final class Nickname implements DataColumnsWithJoins, CommonColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.272 -0500", hash_original_field = "6A9D7432C32589D3033F90024C646E23", hash_generated_field = "61FA6F235685467AD2389D2A75A45B85")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/nickname";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.274 -0500", hash_original_field = "D5462F3507EE113B47294169A6AD1AF4", hash_generated_field = "63A550FC2BA734C6B55F4A6D27D4887D")

            public static final int TYPE_DEFAULT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.277 -0500", hash_original_field = "A23BED94E6BEF1E70FDFC1A84ED9655B", hash_generated_field = "5BEB78DDADAC164A4025C3E0801CB3FF")

            public static final int TYPE_OTHER_NAME = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.279 -0500", hash_original_field = "0C146A82C4C34CA4B86EFE812EEFF7B6", hash_generated_field = "E9B965C0FC80530980F6879261036668")

            public static final int TYPE_MAIDEN_NAME = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.282 -0500", hash_original_field = "FCE643020429094161B6B0E8A754299A", hash_generated_field = "5707A86123371721E285C7469DFFB7EA")

            @Deprecated
            public static final int TYPE_MAINDEN_NAME = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.285 -0500", hash_original_field = "2C0F2EF5C472CE70654E09C1CD946ED7", hash_generated_field = "B2687A5F4C093FA385F5B9B8C23CA053")

            public static final int TYPE_SHORT_NAME = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.287 -0500", hash_original_field = "16D95641E99AA6649416A0CADA52C414", hash_generated_field = "39E86F7F98279CA3EDC3B70DAB31793E")

            public static final int TYPE_INITIALS = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.290 -0500", hash_original_field = "5684E13AC5002C28D8CBB0E0B3D1BD7D", hash_generated_field = "67A54ED7C055B5CB080BA7A54DD11740")

            public static final String NAME = DATA;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.269 -0500", hash_original_method = "C2B5C7987B903EB42CE1EDEA1961E0EA", hash_generated_method = "DD5283A55E6B6F1BAA391AA5DEE87C6C")
            
private Nickname() {}
        }
        
        public static final class Phone implements DataColumnsWithJoins, CommonColumns {

            /**
             * @deprecated use {@link #getTypeLabel(Resources, int, CharSequence)} instead.
             * @hide
             */
            @DSSource({DSSourceKind.CONTACT_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.368 -0500", hash_original_method = "EDF764EB0E7CD97EABC22A940CB89180", hash_generated_method = "E36ABE3BDA6AAD825A671925C6585D0B")
            
@Deprecated
            public static final CharSequence getDisplayLabel(Context context, int type,
                    CharSequence label, CharSequence[] labelArray) {
                return getTypeLabel(context.getResources(), type, label);
            }

            /**
             * @deprecated use {@link #getTypeLabel(Resources, int, CharSequence)} instead.
             * @hide
             */
            @DSSource({DSSourceKind.CONTACT_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.372 -0500", hash_original_method = "9A10A12FCE02DEF77AEA0F0D7AE31554", hash_generated_method = "94E05A3692E1861476EF4BD15F819DAD")
            
@Deprecated
            public static final CharSequence getDisplayLabel(Context context, int type,
                    CharSequence label) {
                return getTypeLabel(context.getResources(), type, label);
            }

            /**
             * Return the string resource that best describes the given
             * {@link #TYPE}. Will always return a valid resource.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.375 -0500", hash_original_method = "A6D4C160D00AA3D36D5417E79FCE7BE2", hash_generated_method = "519BDFA1CF1FDA85ED2C90BFCB4EAA27")
            
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

            /**
             * Return a {@link CharSequence} that best describes the given type,
             * possibly substituting the given {@link #LABEL} value
             * for {@link #TYPE_CUSTOM}.
             */
            @DSComment("data structure only")
            @DSSafe(DSCat.DATA_STRUCTURE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.377 -0500", hash_original_method = "DB726CF4AF0A68CE45AE4CC8697A8990", hash_generated_method = "16C263C0668F5C7F953A2DE5737E1ECD")
            
public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if ((type == TYPE_CUSTOM || type == TYPE_ASSISTANT) && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.299 -0500", hash_original_field = "0B49DC0DF2EA83A6F1A65DF9FEBBEB30", hash_generated_field = "1F223633F2222C03FD7BE22E835FA277")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/phone_v2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.301 -0500", hash_original_field = "4D0C0146A7EB361C189E4F279B02551D", hash_generated_field = "CE346990F9E7309AEC1D527307A9A9D7")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/phone_v2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.304 -0500", hash_original_field = "DBC14748E6F04A1A04EE9E1128D58B91", hash_generated_field = "A3C4A0040C7B61AF78E856B72C75B080")

            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI,
                    "phones");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.307 -0500", hash_original_field = "89BBCEA44CB56D6651E90104E764CABC", hash_generated_field = "36A83EB7BAEC220CEDCCB9CC5B7F20BE")

            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI,
                    "filter");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.309 -0500", hash_original_field = "02CD0ACAC2AE3D840D206F8BB087ED01", hash_generated_field = "A3AF173E9489DC9819BA4BB309F5F1DB")

            public static final int TYPE_HOME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.312 -0500", hash_original_field = "CE1F178F70D800B9E35E76343E118C12", hash_generated_field = "59C15403B52E5856C9B5425B13FB5FCF")

            public static final int TYPE_MOBILE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.315 -0500", hash_original_field = "743C6EBF230791626082C1FBC0041CE3", hash_generated_field = "F42437B2DE20198D4525BED2BEBA10FC")

            public static final int TYPE_WORK = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.317 -0500", hash_original_field = "B28CEE0859D7BBDAAFCB9679D0262BCD", hash_generated_field = "751A95888571137C3FFE2DA9CED0B977")

            public static final int TYPE_FAX_WORK = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.320 -0500", hash_original_field = "23A0D922653B1375976445DFD75A39EA", hash_generated_field = "46A5B34BDB146C8870F3F86511087789")

            public static final int TYPE_FAX_HOME = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.323 -0500", hash_original_field = "1997E7702E4B702591B186EA99BB15AB", hash_generated_field = "4C7E69320A068BB5A6836F397BB2426A")

            public static final int TYPE_PAGER = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.326 -0500", hash_original_field = "8E83374E8EC10792EF0FB52E12D5AF12", hash_generated_field = "577123831D509A76CDF52D19E916C66A")

            public static final int TYPE_OTHER = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.328 -0500", hash_original_field = "EB673D0F7B931FCE1397AA00BB7F3A8C", hash_generated_field = "9DDEDA6E3B6907EE47B08CD6CE5AED29")

            public static final int TYPE_CALLBACK = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.330 -0500", hash_original_field = "63736694930862446FEC6FBCEE41C9F5", hash_generated_field = "661024FBF57C241DF0C5A76FFC2A23F5")

            public static final int TYPE_CAR = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.333 -0500", hash_original_field = "B90846B00DBAC5DA080D1B13B50E76B5", hash_generated_field = "D8CA58F35A9C67F3582BDFD0195395FE")

            public static final int TYPE_COMPANY_MAIN = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.335 -0500", hash_original_field = "69E0FA03059C63DD64A786184593899C", hash_generated_field = "9CFAA89CFF2717CF369155C37DDC6A35")

            public static final int TYPE_ISDN = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.338 -0500", hash_original_field = "FC8BBE0D623FC78683957A04215FAEE2", hash_generated_field = "6F05CB0439012A900045A1344841ADA8")

            public static final int TYPE_MAIN = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.341 -0500", hash_original_field = "474382A7896064CE4FC7FF839F4BB7F8", hash_generated_field = "0ACEEA8EA7D71E0657EAD4E2B3A555D6")

            public static final int TYPE_OTHER_FAX = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.344 -0500", hash_original_field = "452E964D6C3782EDF7FC9EEB1E8DAFBF", hash_generated_field = "A13B7512B8541B29A33C9CF6C4B1B66C")

            public static final int TYPE_RADIO = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.347 -0500", hash_original_field = "450952C202AF40BF94CAD17CB73DFB35", hash_generated_field = "6B218ADE8DDF214B32CC4D34E4329D92")

            public static final int TYPE_TELEX = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.350 -0500", hash_original_field = "02D612C411D6693E48B68080538F8118", hash_generated_field = "F133FC8F561875305EE7596E2F9358BF")

            public static final int TYPE_TTY_TDD = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.352 -0500", hash_original_field = "2D06844EC2659CEF1E819A324EC99AF0", hash_generated_field = "2C192DF713982E5DB1CA3F959D993229")

            public static final int TYPE_WORK_MOBILE = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.355 -0500", hash_original_field = "1B0E2F3B5995001DB626824CA73A8545", hash_generated_field = "C8982DE53EEDC39F82E0E2EF90596E94")

            public static final int TYPE_WORK_PAGER = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.357 -0500", hash_original_field = "E07A067FBECD3AA9C8AEE8A21D2D9CFD", hash_generated_field = "1E077665ECD4EECB50E467EC8ED42502")

            public static final int TYPE_ASSISTANT = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.360 -0500", hash_original_field = "1563FE81FDDF545CD57274628331DECC", hash_generated_field = "0A46A0C2A54F25F4912D3DF48662F52A")

            public static final int TYPE_MMS = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.362 -0500", hash_original_field = "6CF093AB917C8FC1756E1D85F4CD44CE", hash_generated_field = "763AA2823695116F08461425F9A567EE")

            public static final String NUMBER = DATA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.365 -0500", hash_original_field = "94208A5941305E336F5F6BB2FA435ED7", hash_generated_field = "13CF46B172BA5FE696B962CC830E16EE")

            public static final String NORMALIZED_NUMBER = DATA4;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.295 -0500", hash_original_method = "8C72E3409D1DFC404D9CBFEE30B178A0", hash_generated_method = "20858A91C99B487A0D85DFA58E7B2379")
            
private Phone() {}
        }
        
        public static final class Email implements DataColumnsWithJoins, CommonColumns {

            /**
             * Return the string resource that best describes the given
             * {@link #TYPE}. Will always return a valid resource.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.417 -0500", hash_original_method = "E7DA05307A110C99CAAC7B66439AA912", hash_generated_method = "3AC091B7B77748F12E12FDDA82CBE6AC")
            
public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.emailTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.emailTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.emailTypeOther;
                    case TYPE_MOBILE: return com.android.internal.R.string.emailTypeMobile;
                    default: return com.android.internal.R.string.emailTypeCustom;
                }
            }

            /**
             * Return a {@link CharSequence} that best describes the given type,
             * possibly substituting the given {@link #LABEL} value
             * for {@link #TYPE_CUSTOM}.
             */
            @DSComment("data structure only")
            @DSSafe(DSCat.DATA_STRUCTURE)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.420 -0500", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            
public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.388 -0500", hash_original_field = "ADE566A7604E6F7AFA3F129E74A2CDE2", hash_generated_field = "859AE736BCEA751F7D5A4255E7468689")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/email_v2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.390 -0500", hash_original_field = "72C347E30A71C042D545024DBE305572", hash_generated_field = "DFB2AE964F2A2E489B2D416608B726EE")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/email_v2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.393 -0500", hash_original_field = "73FAC2AB7D85738DC4D2420EA55DD84E", hash_generated_field = "E81312BCB9EF776662A7563ECD1DB7CF")

            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI,
                    "emails");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.396 -0500", hash_original_field = "9E52D376C38E382140806B42B89AE700", hash_generated_field = "F94DD7AE0907A95C5597A5A8773EE09E")

            public static final Uri CONTENT_LOOKUP_URI = Uri.withAppendedPath(CONTENT_URI,
                    "lookup");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.399 -0500", hash_original_field = "89BBCEA44CB56D6651E90104E764CABC", hash_generated_field = "36A83EB7BAEC220CEDCCB9CC5B7F20BE")

            public static final Uri CONTENT_FILTER_URI = Uri.withAppendedPath(CONTENT_URI,
                    "filter");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.401 -0500", hash_original_field = "D54427F37486BBCC6DBC12BB41780788", hash_generated_field = "A407FB0B080749617A815C9A1E4D13E3")

            public static final String ADDRESS = DATA1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.404 -0500", hash_original_field = "02CD0ACAC2AE3D840D206F8BB087ED01", hash_generated_field = "A3AF173E9489DC9819BA4BB309F5F1DB")

            public static final int TYPE_HOME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.406 -0500", hash_original_field = "212665B4C3E3041AB3B35C33DC8E54EA", hash_generated_field = "2DD1E25E0D1B8108129E5DFF1326B779")

            public static final int TYPE_WORK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.409 -0500", hash_original_field = "549FA44290406B6885986A17674F170A", hash_generated_field = "94C57AEAC00AEFAA44100B03BD71282D")

            public static final int TYPE_OTHER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.412 -0500", hash_original_field = "AE4961D81580721190AF569CF398D801", hash_generated_field = "6984B984CEB5361E741B06CEA68F16ED")

            public static final int TYPE_MOBILE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.414 -0500", hash_original_field = "A1A91DB9F52921B3505BDE792AB9C514", hash_generated_field = "BFEE09F4055CB889385B9BFCBA46DC2D")

            public static final String DISPLAY_NAME = DATA4;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.384 -0500", hash_original_method = "4685E1971C120F244FF83B34E469953F", hash_generated_method = "C8A3E9E234F4725096CD8FF88F5B6008")
            
private Email() {}
        }
        
        public static final class StructuredPostal implements DataColumnsWithJoins, CommonColumns {

            /**
             * Return the string resource that best describes the given
             * {@link #TYPE}. Will always return a valid resource.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.467 -0500", hash_original_method = "5BF2306E301E46F8BD771E4EFD0EBA38", hash_generated_method = "0222ACA728765DEA2E42F4BB1C03A29A")
            
public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.postalTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.postalTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.postalTypeOther;
                    default: return com.android.internal.R.string.postalTypeCustom;
                }
            }

            /**
             * Return a {@link CharSequence} that best describes the given type,
             * possibly substituting the given {@link #LABEL} value
             * for {@link #TYPE_CUSTOM}.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.469 -0500", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            
public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.428 -0500", hash_original_field = "2530C720DD766E1953714580DB6B4635", hash_generated_field = "506F3DF14715DE60E1EE345A9D9B1887")

            public static final String CONTENT_ITEM_TYPE =
                    "vnd.android.cursor.item/postal-address_v2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.432 -0500", hash_original_field = "4A941BEF7FAED168F5C3D1DE916941D4", hash_generated_field = "250D9641BB264121C8BBE97B69EC3C35")

            public static final String CONTENT_TYPE = "vnd.android.cursor.dir/postal-address_v2";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.435 -0500", hash_original_field = "85D9D9FC3631C6C14187E2D6BE68BC7B", hash_generated_field = "EA13E315BE511D054D222ACD02E20571")

            public static final Uri CONTENT_URI = Uri.withAppendedPath(Data.CONTENT_URI,
                    "postals");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.437 -0500", hash_original_field = "02CD0ACAC2AE3D840D206F8BB087ED01", hash_generated_field = "A3AF173E9489DC9819BA4BB309F5F1DB")

            public static final int TYPE_HOME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.440 -0500", hash_original_field = "212665B4C3E3041AB3B35C33DC8E54EA", hash_generated_field = "2DD1E25E0D1B8108129E5DFF1326B779")

            public static final int TYPE_WORK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.443 -0500", hash_original_field = "549FA44290406B6885986A17674F170A", hash_generated_field = "94C57AEAC00AEFAA44100B03BD71282D")

            public static final int TYPE_OTHER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.445 -0500", hash_original_field = "3835E7330C066736ADAA3D397C96209A", hash_generated_field = "E6B81BFAC39F0EBEB8AFA77FA0DAA6D5")

            public static final String FORMATTED_ADDRESS = DATA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.448 -0500", hash_original_field = "63E72009CFA34C37AC3FD70BE9F35045", hash_generated_field = "FC5DA379BEAF181A7DB3853C3E5C84C5")

            public static final String STREET = DATA4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.451 -0500", hash_original_field = "74849462C457BC5BE53B526DB12FF66C", hash_generated_field = "5B40BB3B0E58715D304D41E449168D73")

            public static final String POBOX = DATA5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.453 -0500", hash_original_field = "FAD290D63500A8FD49EF9A4B3929CFED", hash_generated_field = "FD16B689529DE12FA631A1AC46E14071")

            public static final String NEIGHBORHOOD = DATA6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.456 -0500", hash_original_field = "7C2F9E007453B4C7CBAB600CC10E1BEF", hash_generated_field = "387FC24F3974E2E0B797750B8D0E49E6")

            public static final String CITY = DATA7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.459 -0500", hash_original_field = "C62DDAF5B1A219482D97041E27952E88", hash_generated_field = "7BCD31F69D04787416C5CBE16DCA99ED")

            public static final String REGION = DATA8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.462 -0500", hash_original_field = "8C106543884EA580132A68BA0773BBD9", hash_generated_field = "F2AAF6F03FE137988D0283DD701017D0")

            public static final String POSTCODE = DATA9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.464 -0500", hash_original_field = "8C01564166AB5592403ECBE60A4AF113", hash_generated_field = "8D26203B337243A482D81E02769EFB43")

            public static final String COUNTRY = DATA10;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.425 -0500", hash_original_method = "C8D888449545672CEC46DD26E7BDDD9A", hash_generated_method = "FAA67BE8147DD6AD9A8F1C202BD53E1E")
            
private StructuredPostal() {
            }
        }
        
        public static final class Im implements DataColumnsWithJoins, CommonColumns {

            /**
             * Return the string resource that best describes the given
             * {@link #TYPE}. Will always return a valid resource.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.523 -0500", hash_original_method = "DB933F4CCE4B2417E3234A3CAF5584A5", hash_generated_method = "A6E4D3E4D827895C2D526B84B05B7EC5")
            
public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.imTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.imTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.imTypeOther;
                    default: return com.android.internal.R.string.imTypeCustom;
                }
            }

            /**
             * Return a {@link CharSequence} that best describes the given type,
             * possibly substituting the given {@link #LABEL} value
             * for {@link #TYPE_CUSTOM}.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.526 -0500", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            
public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }

            /**
             * Return the string resource that best describes the given
             * {@link #PROTOCOL}. Will always return a valid resource.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.529 -0500", hash_original_method = "2439B316AC02293F1C1BC72135D6806F", hash_generated_method = "7601F5260A424E1A642596C53EDA9D8A")
            
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

            /**
             * Return a {@link CharSequence} that best describes the given
             * protocol, possibly substituting the given
             * {@link #CUSTOM_PROTOCOL} value for {@link #PROTOCOL_CUSTOM}.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.532 -0500", hash_original_method = "719F720CCBDAB5B3884CB87DEE9715B5", hash_generated_method = "05C319BA1E315915AA4D439E1FDBD977")
            
public static final CharSequence getProtocolLabel(Resources res, int type,
                    CharSequence label) {
                if (type == PROTOCOL_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getProtocolLabelResource(type);
                    return res.getText(labelRes);
                }
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.480 -0500", hash_original_field = "1167B5D1374938B2187CAC60A662CA84", hash_generated_field = "5AE10DBF88AB44FC5E4D010123E19E32")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/im";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.482 -0500", hash_original_field = "02CD0ACAC2AE3D840D206F8BB087ED01", hash_generated_field = "A3AF173E9489DC9819BA4BB309F5F1DB")

            public static final int TYPE_HOME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.485 -0500", hash_original_field = "212665B4C3E3041AB3B35C33DC8E54EA", hash_generated_field = "2DD1E25E0D1B8108129E5DFF1326B779")

            public static final int TYPE_WORK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.488 -0500", hash_original_field = "549FA44290406B6885986A17674F170A", hash_generated_field = "94C57AEAC00AEFAA44100B03BD71282D")

            public static final int TYPE_OTHER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.490 -0500", hash_original_field = "C3253D9BDC3DFB46F00365A1CCDA2B34", hash_generated_field = "A6C5404E24EA595BEE495F79D3BDC24F")

            public static final String PROTOCOL = DATA5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.493 -0500", hash_original_field = "C003FFF9E1F4E464EDA6393F7F03E109", hash_generated_field = "FAEDCA70ABBB2BB6E8F02D0CA58AB92D")

            public static final String CUSTOM_PROTOCOL = DATA6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.495 -0500", hash_original_field = "A27438910DAB1815507D1C4F2B6734DB", hash_generated_field = "F9A89D2E95B56F6CF27905C9AF3BEF7C")

            public static final int PROTOCOL_CUSTOM = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.498 -0500", hash_original_field = "79B2B9CAAEAA134E05FDD247D583ADD4", hash_generated_field = "B8DD27EB4EB2987356C26B9B2248736B")

            public static final int PROTOCOL_AIM = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.501 -0500", hash_original_field = "330C863744DA00915C180579F6A490BE", hash_generated_field = "86D6D26C03884E1639863C42F131CB0F")

            public static final int PROTOCOL_MSN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.503 -0500", hash_original_field = "3D3325C7611522397E8696F42E9755A3", hash_generated_field = "6EB61BBD5E00F25A9307ABB0B706728A")

            public static final int PROTOCOL_YAHOO = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.506 -0500", hash_original_field = "2F2E331429DBF1C59E1B562B1E5E5571", hash_generated_field = "583FE8AF1BD41C5351AF4DC35E6A1742")

            public static final int PROTOCOL_SKYPE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.508 -0500", hash_original_field = "2566A8E0647B70A3D130F749FFDF6564", hash_generated_field = "392A2A35FFDAAB82979EC983264EA5F1")

            public static final int PROTOCOL_QQ = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.512 -0500", hash_original_field = "B11CFBF8636DCCCBEBC9147CD967976A", hash_generated_field = "97B523ACF7ACE08369AC0A88E0EF61BB")

            public static final int PROTOCOL_GOOGLE_TALK = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.514 -0500", hash_original_field = "57F36706B23CA069E871CB39520ECC14", hash_generated_field = "7E3934A9EB761B183D6ED91C9B12998C")

            public static final int PROTOCOL_ICQ = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.517 -0500", hash_original_field = "F06DD118F43BEC1F3B9FF73DF38B3885", hash_generated_field = "1380DF6511E089CF45957B47807306EF")

            public static final int PROTOCOL_JABBER = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.519 -0500", hash_original_field = "069653A631E9CF284F7957AAA202C479", hash_generated_field = "EF4F0A0008F96A206B3AAB3594BF8432")

            public static final int PROTOCOL_NETMEETING = 8;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.477 -0500", hash_original_method = "7F43853CDED9232ACA3765709B5C5CC7", hash_generated_method = "5C9DEEA3F7D329A789B5C65180A72B7C")
            
private Im() {}
        }
        
        public static final class Organization implements DataColumnsWithJoins, CommonColumns {

            /**
             * Return the string resource that best describes the given
             * {@link #TYPE}. Will always return a valid resource.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.570 -0500", hash_original_method = "3DA16CECB36036B59D78BB88E80196B3", hash_generated_method = "91AD13C9A65F98147CABF426F48DD4E5")
            
public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_WORK: return com.android.internal.R.string.orgTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.orgTypeOther;
                    default: return com.android.internal.R.string.orgTypeCustom;
                }
            }

            /**
             * Return a {@link CharSequence} that best describes the given type,
             * possibly substituting the given {@link #LABEL} value
             * for {@link #TYPE_CUSTOM}.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.573 -0500", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            
public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.540 -0500", hash_original_field = "3891D953C5A6281BCECB430F8EA78CAB", hash_generated_field = "6CF7C5A6292394C36147458C0D450BCF")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/organization";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.543 -0500", hash_original_field = "6C42893D204850B4FAF16B5AB19F3BE2", hash_generated_field = "9660B9049AFB5B9EFB571676569F6154")

            public static final int TYPE_WORK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.545 -0500", hash_original_field = "8D4B0D0CC4101D2DEE127C6DA2BFFB6B", hash_generated_field = "7CCF7EE2A0268E7232DBAAB3B7AFBF8C")

            public static final int TYPE_OTHER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.548 -0500", hash_original_field = "F6FE5A14E5C7747B572BACE7D6EE48EA", hash_generated_field = "B1B6E1201E7B503C148BB63BDE25ECE8")

            public static final String COMPANY = DATA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.551 -0500", hash_original_field = "19670C5093A2DF064DCE8FF770F24B62", hash_generated_field = "40AC28C6DA79391B539F4068DA2CDCE0")

            public static final String TITLE = DATA4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.554 -0500", hash_original_field = "A57BD53585678749412A8380245BAE41", hash_generated_field = "FC45AB7F87492643E52B634F1F69473E")

            public static final String DEPARTMENT = DATA5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.556 -0500", hash_original_field = "99C3E0EB180811841EA498234B0E33BF", hash_generated_field = "F77DED9478C56A1DD5A0E3696D945BA1")

            public static final String JOB_DESCRIPTION = DATA6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.560 -0500", hash_original_field = "27004EFFEF29EBE01776C8C1D2006368", hash_generated_field = "C63E4734BFB73C8BEEB1613C3CAA7CA9")

            public static final String SYMBOL = DATA7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.562 -0500", hash_original_field = "422B35F090C148BEB2736FD694C0980D", hash_generated_field = "F76E1A94B2DC0956CC44630A309473C4")

            public static final String PHONETIC_NAME = DATA8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.565 -0500", hash_original_field = "3EA2570DDFCC2A7B41BD3A6154FFAAB2", hash_generated_field = "F45F12923FC3A5FF5E13A863D6CADFFD")

            public static final String OFFICE_LOCATION = DATA9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.568 -0500", hash_original_field = "C93976C9E467472D986F175B3D526C2D", hash_generated_field = "AF6563F13F3A3A61AD829FC6FAE912E9")

            public static final String PHONETIC_NAME_STYLE = DATA10;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.538 -0500", hash_original_method = "DB9E0507E0CFF6D3A6878FC813F638FB", hash_generated_method = "E72FA9AB21EB9DEC849D67C832120E3A")
            
private Organization() {}
        }
        
        public static final class Relation implements DataColumnsWithJoins, CommonColumns {

            /**
             * Return the string resource that best describes the given
             * {@link #TYPE}. Will always return a valid resource.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.626 -0500", hash_original_method = "DC92F7F77AD275BC3178229A766744FB", hash_generated_method = "51A27705782CDA7F0811032820233425")
            
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

            /**
             * Return a {@link CharSequence} that best describes the given type,
             * possibly substituting the given {@link #LABEL} value
             * for {@link #TYPE_CUSTOM}.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.629 -0500", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            
public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.582 -0500", hash_original_field = "3A340C278721520E13259FFBCD763FC3", hash_generated_field = "4E5D41A571D152AF86A5F2E8DF941EB4")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/relation";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.584 -0500", hash_original_field = "4FF162F9964736F6BFA04A534A01F808", hash_generated_field = "6554B25D5A397416DB3C3322C813D334")

            public static final int TYPE_ASSISTANT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.587 -0500", hash_original_field = "B85C6EF24CB1F30626DF0DB4A4985430", hash_generated_field = "B61CACD4D50D7C4ED812B6B430BAE236")

            public static final int TYPE_BROTHER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.589 -0500", hash_original_field = "F1B3C26FDE46194ED0BC14B008C04D46", hash_generated_field = "E8FFBDD9437A8331AC45B5B86A546369")

            public static final int TYPE_CHILD = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.592 -0500", hash_original_field = "07AD214CCD5135FF1243B667EAAA60E4", hash_generated_field = "9206111E455AC5F7CDACEE6CDEEB3CED")

            public static final int TYPE_DOMESTIC_PARTNER = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.596 -0500", hash_original_field = "82944731F8CC93AF830D6413F63BEA89", hash_generated_field = "F7FCB8879EF9D2B817AB53113A7B6F9A")

            public static final int TYPE_FATHER = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.598 -0500", hash_original_field = "13819F43072C39C16080B0675C9EE511", hash_generated_field = "913615C87DB7D403162A82B3EE27F751")

            public static final int TYPE_FRIEND = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.601 -0500", hash_original_field = "9AC3C06E30A609A717412B9838240DDC", hash_generated_field = "E9DD5E4041B5A4AACDE6CFDF9EFD9D7E")

            public static final int TYPE_MANAGER = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.603 -0500", hash_original_field = "8BFB7FEA0A3A29123F5A77F6BCDEFBCF", hash_generated_field = "37090E74FD34ABDA4E42D47B1C53E8AE")

            public static final int TYPE_MOTHER = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.606 -0500", hash_original_field = "4ACE05210754D71CA493A6B5F0242859", hash_generated_field = "FD8380616122869215F8FD0C939F893F")

            public static final int TYPE_PARENT = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.609 -0500", hash_original_field = "FA5D234F910EF5A1CA43F28BE5E1147B", hash_generated_field = "1E64D7DF300B14229B08923EFE993884")

            public static final int TYPE_PARTNER = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.611 -0500", hash_original_field = "02AD1C20A236DD1A6F4DFE4B3C9B9839", hash_generated_field = "83C2C6B071FC6373ED701A8C213E6344")

            public static final int TYPE_REFERRED_BY = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.614 -0500", hash_original_field = "E56A246E5647FB254DBB1E832ED18955", hash_generated_field = "F42AEAB2AA5368B916C63AEF6E2EC7DA")

            public static final int TYPE_RELATIVE = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.617 -0500", hash_original_field = "E02C38C5703499D17BDBD475509F39C2", hash_generated_field = "09DC0B2D63B8996CCF45B1E3533A24CF")

            public static final int TYPE_SISTER = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.619 -0500", hash_original_field = "B053687C61BADB0F3C1CE0888DBBE4EB", hash_generated_field = "8530AFDB8E33B30C49384B667B586394")

            public static final int TYPE_SPOUSE = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.622 -0500", hash_original_field = "5684E13AC5002C28D8CBB0E0B3D1BD7D", hash_generated_field = "67A54ED7C055B5CB080BA7A54DD11740")

            public static final String NAME = DATA;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.579 -0500", hash_original_method = "AB820511C2318175DFB023ADDE00500D", hash_generated_method = "5C7379F1CD33F66582C3B79E9B50B8B4")
            
private Relation() {}
        }
        
        public static final class Event implements DataColumnsWithJoins, CommonColumns {

            /**
             * Return the string resource that best describes the given
             * {@link #TYPE}. Will always return a valid resource.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.651 -0500", hash_original_method = "44A585035560330F504A000D56682C48", hash_generated_method = "D17577314C62A57FCC47AE3081A84877")
            
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.637 -0500", hash_original_field = "E8CF6B939E2FD9176B02B8272C3ED3DE", hash_generated_field = "13ADF6BD54B9E1950C209A233DAB1746")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact_event";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.640 -0500", hash_original_field = "3416DF16E57D90D012A590F0C353055E", hash_generated_field = "99D50BA6A478BE143E64916539BE6610")

            public static final int TYPE_ANNIVERSARY = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.643 -0500", hash_original_field = "8D4B0D0CC4101D2DEE127C6DA2BFFB6B", hash_generated_field = "7CCF7EE2A0268E7232DBAAB3B7AFBF8C")

            public static final int TYPE_OTHER = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.645 -0500", hash_original_field = "1A14E2C430CD8710BE0537215125B9FE", hash_generated_field = "AE7A10B3955E730B100FBBC0B8A83A1D")

            public static final int TYPE_BIRTHDAY = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.648 -0500", hash_original_field = "C4B36522E7112F30CB27C29080BA0E5A", hash_generated_field = "552453D11E30C9D7C1326C394FAF97D3")

            public static final String START_DATE = DATA;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.634 -0500", hash_original_method = "D3DDD15A13BA6EC1D9CD48C2CCCFE0B4", hash_generated_method = "BDAD5B72FB8DC237D351054ED50949FF")
            
private Event() {}
        }
        
        public static final class Photo implements DataColumnsWithJoins {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.659 -0500", hash_original_field = "E2E61796B88852949791768A4CE0F12D", hash_generated_field = "C34ED4BEFD8F1C45F4DCBAB84FC48D97")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/photo";
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_field = "D788C6AA077DFD01FC513679BA93D4DF", hash_generated_field = "827F52308AEA6086917181CAD2690C59")

            public static final String PHOTO_FILE_ID = DATA14;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_field = "906C07610AAC15FC6A2F6263527EC4C4", hash_generated_field = "2769AC225261CB92B8111CE835D1CB36")

            public static final String PHOTO = DATA15;
            
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.227 -0400", hash_original_method = "C03E3395BFF21729CC93322BBC7A82DE", hash_generated_method = "6353485435339DC025174C823A75D00F")
            private  Photo() {
                // ---------- Original Method ----------
            }
        }
        
        public static final class Note implements DataColumnsWithJoins {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.673 -0500", hash_original_field = "ECDC40C0974A6D2AD0FA340A65176667", hash_generated_field = "23539A67AEC2F9B933722A9B0A7EDBEA")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/note";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.675 -0500", hash_original_field = "BA78F3DCCC0BAB251BAA056325214CAF", hash_generated_field = "EC62015EBAD227624690D8E86B66BFB6")

            public static final String NOTE = DATA1;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.670 -0500", hash_original_method = "EBAE52FCFF9289B17EA2262C75B6F6C0", hash_generated_method = "341899536F7070342B48A81450701483")
            
private Note() {}
        }
        
        public static final class GroupMembership implements DataColumnsWithJoins {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.683 -0500", hash_original_field = "D40670C93BCBD57349E8BD91ABFF5CD5", hash_generated_field = "41F1E4E66419A7D4F47D102CBE7A7906")

            public static final String CONTENT_ITEM_TYPE =
                    "vnd.android.cursor.item/group_membership";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.687 -0500", hash_original_field = "391D1B30DC6D8D2E8EFA43B98F6E9D75", hash_generated_field = "950F102D48B72425FE7A6D958C1A6B9D")

            public static final String GROUP_ROW_ID = DATA1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.689 -0500", hash_original_field = "DBAD026AE14F1288267D2543A2AC6252", hash_generated_field = "92D833373693D090B03089F36A6F98D3")

            public static final String GROUP_SOURCE_ID = "group_sourceid";
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.681 -0500", hash_original_method = "9948141C64D53CA8E17E7FD2EBA08DA8", hash_generated_method = "CD57B10B47E4384F9C72F867F5045C16")
            
private GroupMembership() {}
        }
        
        public static final class Website implements DataColumnsWithJoins, CommonColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.697 -0500", hash_original_field = "02A212D8744376AC67B370AF760833E0", hash_generated_field = "507B8C53AF67D95DEBE883A04CF7EF7E")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/website";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.700 -0500", hash_original_field = "AF45502ED79464D1C45078EB1BFC2A50", hash_generated_field = "4B468C40319D845407892D3884823FA4")

            public static final int TYPE_HOMEPAGE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.702 -0500", hash_original_field = "AAD1CE2B38F23ACCA22325E53C7D8932", hash_generated_field = "58D108F8912D098F80EDD36B2E85E3A7")

            public static final int TYPE_BLOG = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.705 -0500", hash_original_field = "7C86FF108B69A9498E82BD314AE3CF42", hash_generated_field = "D8F6248DB8467C72A5CAE2A75289C796")

            public static final int TYPE_PROFILE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.708 -0500", hash_original_field = "BB251CFC234DBCDA020779DBFD7D3F32", hash_generated_field = "70FE66EBFDC21B03CAA0A040A2913B61")

            public static final int TYPE_HOME = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.710 -0500", hash_original_field = "3E08808C6FDB08B3068E8042BD2A854F", hash_generated_field = "0A4BCA99BAC8DDD8AA17AABB5864C924")

            public static final int TYPE_WORK = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.713 -0500", hash_original_field = "F3C04710909E80A46E2FA1A75EDD1888", hash_generated_field = "C2132BF3D75834282FC3009303F52815")

            public static final int TYPE_FTP = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.717 -0500", hash_original_field = "8E83374E8EC10792EF0FB52E12D5AF12", hash_generated_field = "577123831D509A76CDF52D19E916C66A")

            public static final int TYPE_OTHER = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.719 -0500", hash_original_field = "7E7FDB9C084F06D92C0AB1DD0CB6C783", hash_generated_field = "98433BB6A8DFF48B3096C8EB5C97A0B2")

            public static final String URL = DATA;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.694 -0500", hash_original_method = "CC2DAF060546DD565E4193F5085BC2F2", hash_generated_method = "B0F75899287A5B3F00C2F73E0E2BF7E4")
            
private Website() {}
        }
        
        public static final class SipAddress implements DataColumnsWithJoins, CommonColumns {
            // ...and TYPE and LABEL come from the CommonColumns interface.

            /**
             * Return the string resource that best describes the given
             * {@link #TYPE}. Will always return a valid resource.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.741 -0500", hash_original_method = "D9A58CDEECC9F427DB69C45B7BC2621A", hash_generated_method = "3A09EC7B1D8BD60AEA44FE340DA1D020")
            
public static final int getTypeLabelResource(int type) {
                switch (type) {
                    case TYPE_HOME: return com.android.internal.R.string.sipAddressTypeHome;
                    case TYPE_WORK: return com.android.internal.R.string.sipAddressTypeWork;
                    case TYPE_OTHER: return com.android.internal.R.string.sipAddressTypeOther;
                    default: return com.android.internal.R.string.sipAddressTypeCustom;
                }
            }

            /**
             * Return a {@link CharSequence} that best describes the given type,
             * possibly substituting the given {@link #LABEL} value
             * for {@link #TYPE_CUSTOM}.
             */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.743 -0500", hash_original_method = "139D7841F98AAFAD137DC9F312A6888E", hash_generated_method = "EFE05700DC3AFF7BDD17577F45ECCDA9")
            
public static final CharSequence getTypeLabel(Resources res, int type,
                    CharSequence label) {
                if (type == TYPE_CUSTOM && !TextUtils.isEmpty(label)) {
                    return label;
                } else {
                    final int labelRes = getTypeLabelResource(type);
                    return res.getText(labelRes);
                }
            }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.727 -0500", hash_original_field = "E2036942E9BFAC1EF8E8515C0FF4160D", hash_generated_field = "B36DDF74326B8C6C04710188847C6605")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/sip_address";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.729 -0500", hash_original_field = "02CD0ACAC2AE3D840D206F8BB087ED01", hash_generated_field = "A3AF173E9489DC9819BA4BB309F5F1DB")

            public static final int TYPE_HOME = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.732 -0500", hash_original_field = "212665B4C3E3041AB3B35C33DC8E54EA", hash_generated_field = "2DD1E25E0D1B8108129E5DFF1326B779")

            public static final int TYPE_WORK = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.735 -0500", hash_original_field = "549FA44290406B6885986A17674F170A", hash_generated_field = "94C57AEAC00AEFAA44100B03BD71282D")

            public static final int TYPE_OTHER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.738 -0500", hash_original_field = "74DE0149BCD0A155B3139413E0F86F9A", hash_generated_field = "EDC6BFD3EC96B3DE913728DAB1E5F6D2")

            public static final String SIP_ADDRESS = DATA1;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.724 -0500", hash_original_method = "7307A74E42B27B76827D43357DA8B367", hash_generated_method = "AF19ECCE81B80C3183B5B4B3820F72D8")
            
private SipAddress() {}
        }
        
        public static final class Identity implements DataColumnsWithJoins {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.751 -0500", hash_original_field = "871CF53FF8F8F46BBEB97B5F34D1576D", hash_generated_field = "64AD89413B11D3AEAD2077978B7601E3")

            public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/identity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.754 -0500", hash_original_field = "E206AC2AF8A791BF7DBFDE19D2F9DE94", hash_generated_field = "CC7C1F53A356A0D5518447F250F0D53E")

            public static final String IDENTITY = DataColumns.DATA1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.757 -0500", hash_original_field = "B89D71AB5393C4CE5D19183C34721682", hash_generated_field = "EE3F90B3EC2DE6F57CAE0418DE02AA14")

            public static final String NAMESPACE = DataColumns.DATA2;
            /**
             * This utility class cannot be instantiated
             */
            @DSComment("Private Method")
            @DSBan(DSCat.PRIVATE_METHOD)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.749 -0500", hash_original_method = "CB97BE8665681C1FD82290A9CE03A1A5", hash_generated_method = "1518C88CE2A7455D28F00A07D030AD7B")
            
private Identity() {}
        }
        
        public interface BaseTypes {
            
            public static int TYPE_CUSTOM = 0;
        }
        
        protected interface CommonColumns extends BaseTypes {
            
            public static final String DATA = DataColumns.DATA1;
            
            public static final String TYPE = DataColumns.DATA2;
            
            public static final String LABEL = DataColumns.DATA3;
        }
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.218 -0500", hash_original_method = "3EB47618DCA126249F6622B558B44C8E", hash_generated_method = "54E371C2E975F27786635AD9178F833E")
        
private CommonDataKinds() {}
    }
    
    public static final class Groups implements BaseColumns, GroupsColumns, SyncColumns {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.799 -0500", hash_original_method = "7C8784537648600B4251C9E262BFEFC5", hash_generated_method = "9F167F07FC0CADA08203BAA255DB9A81")
        
public static EntityIterator newEntityIterator(Cursor cursor) {
            return new EntityIteratorImpl(cursor);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.790 -0500", hash_original_field = "533B2EE8366DCE595B7ABBC6A21F78DB", hash_generated_field = "D4801B6081B952E0603E20F18A0054D9")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "groups");
        
        private static class EntityIteratorImpl extends CursorEntityIterator {
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.232 -0400", hash_original_method = "5371E683B36CD927F8174DD86149D4D5", hash_generated_method = "DE3E062D3600C23F52B9400031643F33")
            public  EntityIteratorImpl(Cursor cursor) {
                super(cursor);
                addTaint(cursor.getTaint());
                // ---------- Original Method ----------
            }

            @DSSource({DSSourceKind.CONTACT_INFORMATION})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.806 -0500", hash_original_method = "DDAF6836AC46D694049E3DD971FAB2B5", hash_generated_method = "D472863B645BE527138C3AD1B126EDD6")
            
@Override
            public Entity getEntityAndIncrementCursor(Cursor cursor) throws RemoteException {
                // we expect the cursor is already at the row we need to read from
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
                return new Entity(values);
            }
            
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.792 -0500", hash_original_field = "B72BCDB85859E6757835A09469C04E5D", hash_generated_field = "942A584E46BF9673669BA2AFA76C33B4")

        public static final Uri CONTENT_SUMMARY_URI = Uri.withAppendedPath(AUTHORITY_URI,
                "groups_summary");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.795 -0500", hash_original_field = "98DACBB0A13DBA0253121626A23721CA", hash_generated_field = "0EC0CF3497BDF1BB86BB3A5A54990DE9")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/group";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.797 -0500", hash_original_field = "E7D647BF2317E0DD798A8AF8F6208590", hash_generated_field = "128B87F0EE45853848DC0A95B769065A")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/group";
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.787 -0500", hash_original_method = "7BA2DC4B038FD72F399C633B1C4B5B34", hash_generated_method = "3D1B22AE31FE9AB2658DC3713C91A6C9")
        
private Groups() {
        }
    }
    
    public static final class AggregationExceptions implements BaseColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.816 -0500", hash_original_field = "3EE9EFDAE2D56BD505A50B73E4A2BA06", hash_generated_field = "F86DA92AB1515A0E704AF3BCD078F82E")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "aggregation_exceptions");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.818 -0500", hash_original_field = "4E8584433894DF3265AE1F268A595EA5", hash_generated_field = "335944C29ADD9F124487936BCD4DE433")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/aggregation_exception";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.822 -0500", hash_original_field = "CFF7F7BB63F70F71F1233C2C6478F66B", hash_generated_field = "900F3136060C7C97AC7604F66C067B8C")

        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/aggregation_exception";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.824 -0500", hash_original_field = "2280480E1208717EAE9778EC9DC63E6D", hash_generated_field = "A5BA88997B8C56325DBFED26CDB34D93")

        public static final String TYPE = "type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.827 -0500", hash_original_field = "A7F06A15DC736D299E0D67E6941230D9", hash_generated_field = "E56696B09504EE3DFDFB695D81A43F8B")

        public static final int TYPE_AUTOMATIC = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.830 -0500", hash_original_field = "4D83EB6C0B628D1E11ABF25B3BAF1C1B", hash_generated_field = "750C706133E5F058528F0960AD5007D4")

        public static final int TYPE_KEEP_TOGETHER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.832 -0500", hash_original_field = "3B59B9AF38F071ED0B2BA961D4274D30", hash_generated_field = "5B852A127CE9BA8B9BE00C6D1C62443D")

        public static final int TYPE_KEEP_SEPARATE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.835 -0500", hash_original_field = "EC45D7315EB0942034C4E47AC926474E", hash_generated_field = "2F0AC6185A1AD918EC1F8F2F77B690D8")

        public static final String RAW_CONTACT_ID1 = "raw_contact_id1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.837 -0500", hash_original_field = "11D7D27920B286EA39C2CCB4FAB5F826", hash_generated_field = "E39C007547AB033EB16C5E3F5746BDDE")

        public static final String RAW_CONTACT_ID2 = "raw_contact_id2";
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.814 -0500", hash_original_method = "AEC5F5D30A84CFEC2D9D1903833FB78B", hash_generated_method = "94924C087BDEF419A601243DE7F68DFF")
        
private AggregationExceptions() {}
    }
    
    public static final class Settings implements SettingsColumns {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.851 -0500", hash_original_field = "188B5E40BA99617868308108494CFAB2", hash_generated_field = "C7297F3C14DD54EEFD43481001C6C3EF")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "settings");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.854 -0500", hash_original_field = "2A97B3305459FEAF6C111FCDCEE715E3", hash_generated_field = "566EDD5F86E709EDFF0FA0F33906F1C8")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/setting";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.856 -0500", hash_original_field = "73036ABCF523B721D66365B45FDABEB3", hash_generated_field = "8429EA23022F638512AC4FDE82638297")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/setting";
        /**
         * This utility class cannot be instantiated
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.848 -0500", hash_original_method = "E49204FD271E895B10D86A1AFEA21B04", hash_generated_method = "59B3C6A592AE63BEE2BC1CC1723B36DF")
        
private Settings() {
        }
    }
    
    public static final class ProviderStatus {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.863 -0500", hash_original_field = "9811CC893E07CE89A54658657A6A1F7B", hash_generated_field = "A89A4C9F120D91C22EB2526376E866F4")

        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "provider_status");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.866 -0500", hash_original_field = "F63603A0C31BA8FA9D28FF7E71B504F1", hash_generated_field = "2FDC129A2AFCD846C1691664B4F7661D")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/provider_status";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.869 -0500", hash_original_field = "6D60EF38C7C572A6338B0791FEF3395E", hash_generated_field = "0F92DE669937BAC9213CDB00849C0B4A")

        public static final String STATUS = "status";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.871 -0500", hash_original_field = "4B9A16FE674EC4FC4D6089870C6D1EB6", hash_generated_field = "2098F70EC5539CDFD7D860EDCCFDED4B")

        public static final int STATUS_NORMAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.874 -0500", hash_original_field = "7E08D8A25FA8E9DD202CF0303BF3D542", hash_generated_field = "BC21A54635F877D1AA2A465423E81165")

        public static final int STATUS_UPGRADING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.876 -0500", hash_original_field = "E067206086D94457A7FD37A86121EC29", hash_generated_field = "54B07C94F842C6A6A2490D9540FEBE04")

        public static final int STATUS_UPGRADE_OUT_OF_MEMORY = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.879 -0500", hash_original_field = "B49AA22C3CA371394B6C13B56D584CCF", hash_generated_field = "DDC591651844404039FB85E2D89F15F4")

        public static final int STATUS_CHANGING_LOCALE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.881 -0500", hash_original_field = "78A28C1F70275149004B983816690219", hash_generated_field = "3253D76A0E9FDB3D3974E44CAD97F1CB")

        public static final int STATUS_NO_ACCOUNTS_NO_CONTACTS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.884 -0500", hash_original_field = "FC3EDAF3E2C61649FE9B098749AEB185", hash_generated_field = "CB69AC0B118F400C258B30132CBFEE54")

        public static final String DATA1 = "data1";

        /**
         * Not instantiable.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.861 -0500", hash_original_method = "795A4A88B7E0FFCBF277CCA1899F11E6", hash_generated_method = "8360D316DEAF76F39E9753EEA432BC5B")
        
private ProviderStatus() {
        }
    }
    
    public static final class DataUsageFeedback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.889 -0500", hash_original_field = "F35EBC923A7D0F7C774D00C0B621E3B3", hash_generated_field = "1F2BD7BA06A038CD74DF13781A946524")

        public static final Uri FEEDBACK_URI =
                Uri.withAppendedPath(Data.CONTENT_URI, "usagefeedback");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.891 -0500", hash_original_field = "734407B5BB77650DC072DF4DA3504146", hash_generated_field = "2587BB10584ACB58BBE60035A5018DEC")

        public static final String USAGE_TYPE = "type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.894 -0500", hash_original_field = "D67435065CE9F3A756CBD202E79BFAAE", hash_generated_field = "ECD9489EA14B476209689DD885967B22")

        public static final String USAGE_TYPE_CALL = "call";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.897 -0500", hash_original_field = "4A374FB668BFB062D1D3E10CE2D8461B", hash_generated_field = "593ED32C4C11580B3A149DA1985A8380")

        public static final String USAGE_TYPE_LONG_TEXT = "long_text";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.900 -0500", hash_original_field = "24D84A6651CE88B81A9C7495D488F754", hash_generated_field = "E374D3D7265A360D5988E5A530CDD674")

        public static final String USAGE_TYPE_SHORT_TEXT = "short_text";
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.237 -0400", hash_original_method = "63E5D1CFF9704764CDDB806EEC1367A5", hash_generated_method = "63E5D1CFF9704764CDDB806EEC1367A5")
        public DataUsageFeedback ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class QuickContact {

        /**
         * Trigger a dialog that lists the various methods of interacting with
         * the requested {@link Contacts} entry. This may be based on available
         * {@link ContactsContract.Data} rows under that contact, and may also
         * include social status and presence details.
         *
         * @param context The parent {@link Context} that may be used as the
         *            parent for this dialog.
         * @param target Specific {@link View} from your layout that this dialog
         *            should be centered around. In particular, if the dialog
         *            has a "callout" arrow, it will be pointed and centered
         *            around this {@link View}.
         * @param lookupUri A {@link ContactsContract.Contacts#CONTENT_LOOKUP_URI} style
         *            {@link Uri} that describes a specific contact to feature
         *            in this dialog.
         * @param mode Any of {@link #MODE_SMALL}, {@link #MODE_MEDIUM}, or
         *            {@link #MODE_LARGE}, indicating the desired dialog size,
         *            when supported.
         * @param excludeMimes Optional list of {@link Data#MIMETYPE} MIME-types
         *            to exclude when showing this dialog. For example, when
         *            already viewing the contact details card, this can be used
         *            to omit the details entry from the dialog.
         */
        @DSSpec(DSCat.CONTACT)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.923 -0500", hash_original_method = "718CFEA83C0A766BFE63C0D34638CAC0", hash_generated_method = "8025127BAB7936EEF5D047C5941E2A4C")
        
public static void showQuickContact(Context context, View target, Uri lookupUri, int mode,
                String[] excludeMimes) {
            // Find location and bounds of target view, adjusting based on the
            // assumed local density.
            final float appScale = context.getResources().getCompatibilityInfo().applicationScale;
            final int[] pos = new int[2];
            target.getLocationOnScreen(pos);

            final Rect rect = new Rect();
            rect.addTaint(pos[0] + pos[1] + appScale + target.getTaintInt());

            // Trigger with obtained rectangle
            showQuickContact(context, rect, lookupUri, mode, excludeMimes);
        }

        /**
         * Trigger a dialog that lists the various methods of interacting with
         * the requested {@link Contacts} entry. This may be based on available
         * {@link ContactsContract.Data} rows under that contact, and may also
         * include social status and presence details.
         *
         * @param context The parent {@link Context} that may be used as the
         *            parent for this dialog.
         * @param target Specific {@link Rect} that this dialog should be
         *            centered around, in screen coordinates. In particular, if
         *            the dialog has a "callout" arrow, it will be pointed and
         *            centered around this {@link Rect}. If you are running at a
         *            non-native density, you need to manually adjust using
         *            {@link DisplayMetrics#density} before calling.
         * @param lookupUri A
         *            {@link ContactsContract.Contacts#CONTENT_LOOKUP_URI} style
         *            {@link Uri} that describes a specific contact to feature
         *            in this dialog.
         * @param mode Any of {@link #MODE_SMALL}, {@link #MODE_MEDIUM}, or
         *            {@link #MODE_LARGE}, indicating the desired dialog size,
         *            when supported.
         * @param excludeMimes Optional list of {@link Data#MIMETYPE} MIME-types
         *            to exclude when showing this dialog. For example, when
         *            already viewing the contact details card, this can be used
         *            to omit the details entry from the dialog.
         */
        @DSSpec(DSCat.CONTACT)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.926 -0500", hash_original_method = "55973817E502F758AB5135D809FEAF34", hash_generated_method = "CB00F9B98EAF811099D2420F8D678C5B")
        
public static void showQuickContact(Context context, Rect target, Uri lookupUri, int mode,
                String[] excludeMimes) {
            // Launch pivot dialog through intent for now
            final Intent intent = new Intent(ACTION_QUICK_CONTACT);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

            intent.setData(lookupUri);
            intent.setSourceBounds(target);
            intent.putExtra(EXTRA_MODE, mode);
            intent.putExtra(EXTRA_EXCLUDE_MIMES, excludeMimes);
            context.startActivity(intent);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.905 -0500", hash_original_field = "ACB2DA4E1D68B283FFEA75FC1140603D", hash_generated_field = "44F635670A7299544328E5C4BCCF27F4")

        public static final String ACTION_QUICK_CONTACT =
                "com.android.contacts.action.QUICK_CONTACT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.907 -0500", hash_original_field = "82FF7C803068B9039F51E5ABE5A4C33F", hash_generated_field = "30E30433E867A007E9F4274ED19ABED7")

        @Deprecated
        public static final String EXTRA_TARGET_RECT = "target_rect";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.910 -0500", hash_original_field = "03E078E2ED2480EC226571C038E5D5AB", hash_generated_field = "91426137795BA2F236B3E16D263CB795")

        public static final String EXTRA_MODE = "mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.912 -0500", hash_original_field = "D88C1CBC3C7312797F8B199D24EEC534", hash_generated_field = "B841D17E01159E71755D89737FE2513B")

        public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.915 -0500", hash_original_field = "911FDC64DD8D07E279EC50927E619976", hash_generated_field = "60EA48AB5F9444542CC46A5A635E74D5")

        public static final int MODE_SMALL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.917 -0500", hash_original_field = "B3339A95E1CB24A4D48EADA03C5F8A44", hash_generated_field = "4B5C353280E1650969D6153174DB1DA9")

        public static final int MODE_MEDIUM = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.920 -0500", hash_original_field = "5EA8E31137D72FEAC1E12F6EB9085062", hash_generated_field = "A8F19AE9E94919AE1B96FA82FE5CD087")

        public static final int MODE_LARGE = 3;
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.238 -0400", hash_original_method = "854DF4E0756DCBE90F5C7A53A4D83687", hash_generated_method = "854DF4E0756DCBE90F5C7A53A4D83687")
        public QuickContact ()
        {
            //Synthesized constructor
        }
    }
    
    public static final class DisplayPhoto {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.935 -0500", hash_original_field = "B035BBB2C30EFA2C51636D5B06A24983", hash_generated_field = "C49D801AE6AE952C5A2E59237BB76750")

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, "display_photo");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.938 -0500", hash_original_field = "3943BD0F5783A7EF2BF1F57C9854FBCA", hash_generated_field = "571916FB52ADE5E675DF16A80A4DE259")

        public static final Uri CONTENT_MAX_DIMENSIONS_URI =
                Uri.withAppendedPath(AUTHORITY_URI, "photo_dimensions");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.940 -0500", hash_original_field = "6982558E09BBEDB82B842D737B1A90BA", hash_generated_field = "9C63BF2F85885D804150EB607E59CEF7")

        public static final String DISPLAY_MAX_DIM = "display_max_dim";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.943 -0500", hash_original_field = "C11C8F699C4161C51E1ED98A51E2E6A6", hash_generated_field = "A5F2A972D7A0F8EF132399021DBF335B")

        public static final String THUMBNAIL_MAX_DIM = "thumbnail_max_dim";
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_method = "4DA607ACD5E6F502EC932EC179042892", hash_generated_method = "B2E13164C0532FB7A083C12460677DAB")
        private  DisplayPhoto() {
            // ---------- Original Method ----------
        }
    }
    
    public static final class Intents {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.947 -0500", hash_original_field = "510EE39B1EF724F2DA80D82D04618A9D", hash_generated_field = "A132A17FDFC42C8C719ED06C6147FD6F")

        public static final String SEARCH_SUGGESTION_CLICKED =
                "android.provider.Contacts.SEARCH_SUGGESTION_CLICKED";

        public static final class UI {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.991 -0500", hash_original_field = "FB49D45F8653A1DC01871DF628525003", hash_generated_field = "593F38A410B0596B4AC7CB11DE2B63D9")

            public static final String LIST_DEFAULT =
                    "com.android.contacts.action.LIST_DEFAULT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.993 -0500", hash_original_field = "F6B09C52DA78766B173F8A51D015997A", hash_generated_field = "BCFCA30D099E145B944715F7774B7D03")

            public static final String LIST_GROUP_ACTION =
                    "com.android.contacts.action.LIST_GROUP";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.996 -0500", hash_original_field = "7E8848DDB38EE70755649A479B36F7CC", hash_generated_field = "7152483FEB825A3DF4E2CA899B3A2397")

            public static final String GROUP_NAME_EXTRA_KEY = "com.android.contacts.extra.GROUP";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.999 -0500", hash_original_field = "C145C1FC1B8D735E0C62AD5A9953873F", hash_generated_field = "082889FF819B93DB1103B4CC64A89049")

            public static final String LIST_ALL_CONTACTS_ACTION =
                    "com.android.contacts.action.LIST_ALL_CONTACTS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.002 -0500", hash_original_field = "07D8286DFF7A200EE55C3124EF726A97", hash_generated_field = "E3341AC3155455D800037BC571E2CC42")

            public static final String LIST_CONTACTS_WITH_PHONES_ACTION =
                    "com.android.contacts.action.LIST_CONTACTS_WITH_PHONES";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.004 -0500", hash_original_field = "E5C050C05BD9F8D8C363B55521D3E8A9", hash_generated_field = "8CC13E63672088D309BC610E09FD451E")

            public static final String LIST_STARRED_ACTION =
                    "com.android.contacts.action.LIST_STARRED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.007 -0500", hash_original_field = "9265DD5A0963B8A2D2F4957F763969A3", hash_generated_field = "0BC31D032A3B49751734E6EC9A1C7090")

            public static final String LIST_FREQUENT_ACTION =
                    "com.android.contacts.action.LIST_FREQUENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.010 -0500", hash_original_field = "65F0E266186392D6D4C2D9EDDF505B2D", hash_generated_field = "3B8EFF26BB8D04BF93717C84047300E4")

            public static final String LIST_STREQUENT_ACTION =
                    "com.android.contacts.action.LIST_STREQUENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.012 -0500", hash_original_field = "EB7BD05C8FFDD8CD081AEC2DA44D65B1", hash_generated_field = "646CEFD7ECE89E9767BDA32D20371F05")

            public static final String TITLE_EXTRA_KEY =
                    "com.android.contacts.extra.TITLE_EXTRA";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.015 -0500", hash_original_field = "D5F420A51FEC26608EE97C6CE198A5D1", hash_generated_field = "330480EB686218B9D523AFF412034358")

            public static final String FILTER_CONTACTS_ACTION =
                    "com.android.contacts.action.FILTER_CONTACTS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.018 -0500", hash_original_field = "AAFE951B0C9C201F52AE224DA9A1CD49", hash_generated_field = "2AF328066F3AF41712BB1AC1E77ECF4B")

            public static final String FILTER_TEXT_EXTRA_KEY =
                    "com.android.contacts.extra.FILTER_TEXT";
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_method = "244D54B89BC2D5ABA32DBC8F28EE0809", hash_generated_method = "244D54B89BC2D5ABA32DBC8F28EE0809")
            public UI ()
            {
                //Synthesized constructor
            }
        }
        
        public static final class Insert {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.023 -0500", hash_original_field = "76B2ED03531794A7429D4C9907F26406", hash_generated_field = "713533B8E8F55862B5688D351B3D3343")

            public static final String ACTION = Intent.ACTION_INSERT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.026 -0500", hash_original_field = "01AF9902D20DF365401C9B40A3E85454", hash_generated_field = "2619FF14C7C6A98F2DF1E8E4AC58E0A2")

            public static final String FULL_MODE = "full_mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.028 -0500", hash_original_field = "11F7D90F715D916A63D5FB3D55CA93F4", hash_generated_field = "8F5B94AE17AA8887EB81EF0FD5591FF7")

            public static final String NAME = "name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.032 -0500", hash_original_field = "122AF4CE827AC10C80F156DA9A7D9E87", hash_generated_field = "479E852A992979C10C1AE390E8A12875")

            /**
             * The extra field for the contact phonetic name.
             * <P>Type: String</P>
             */
            public static final String PHONETIC_NAME = "phonetic_name";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.035 -0500", hash_original_field = "9A42B912961F8A847FFDB76CE09E0ACC", hash_generated_field = "DA3A161CE79B1B32CE9B8F725B5209E9")

            public static final String COMPANY = "company";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.038 -0500", hash_original_field = "D8E625BB41C8768D82A8002455388DBD", hash_generated_field = "D9FF83450C736ECB48F6C2F09F5228C0")

            public static final String JOB_TITLE = "job_title";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.040 -0500", hash_original_field = "03A118215B18E68A2430A6547EC3A5A9", hash_generated_field = "87D52F2B531AEC13DF3E369C39ADFFFB")

            public static final String NOTES = "notes";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.043 -0500", hash_original_field = "C2C96E54A087EC878A0CE427960E2216", hash_generated_field = "8335197447402E15F4F117B323C6EEBF")

            public static final String PHONE = "phone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.045 -0500", hash_original_field = "FAF02FD8598164DCE3BD0B42D913BB1C", hash_generated_field = "EF03148507068753AC3CAE4DC5C84C25")

            public static final String PHONE_TYPE = "phone_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.048 -0500", hash_original_field = "4AD2E3B8F8FD72281A755A109BB8CE66", hash_generated_field = "7E6AE81CEEEC747E06A4CE7B3886BAFE")

            public static final String PHONE_ISPRIMARY = "phone_isprimary";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.051 -0500", hash_original_field = "B75ECE2F1369655175378D92CAA0BBCC", hash_generated_field = "448C6E829671F08B3922BEF4C7BA4DD0")

            public static final String SECONDARY_PHONE = "secondary_phone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.053 -0500", hash_original_field = "9F14291B2E9E35B607BF2E69F8B5DE7D", hash_generated_field = "DB4B8535D6A9FBA09643994357446FF2")

            public static final String SECONDARY_PHONE_TYPE = "secondary_phone_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.056 -0500", hash_original_field = "D4F39363EAF9B2742F517A75FE53D5D3", hash_generated_field = "AC733805DB388428C9F95E863DC84E2B")

            public static final String TERTIARY_PHONE = "tertiary_phone";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.058 -0500", hash_original_field = "CE0A09EE51EAEFA1680CB4566A50A0BF", hash_generated_field = "4FB26A252013330C127F7BCA8E9A94FD")

            public static final String TERTIARY_PHONE_TYPE = "tertiary_phone_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.062 -0500", hash_original_field = "0CEBDC7F2BE4E46C5177B1B15F7DAAB4", hash_generated_field = "D3A698C17CAE09AF6E6FEF88B890D500")

            public static final String EMAIL = "email";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.065 -0500", hash_original_field = "F35C2493D2F50FA3659ABB36AAF618BB", hash_generated_field = "B60E8DD6122DA416C2126A2F09163415")

            public static final String EMAIL_TYPE = "email_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.067 -0500", hash_original_field = "BF9966EDBE5F44DE03ADFA2342737458", hash_generated_field = "72BBA6D014131906449B388E938A83DE")

            public static final String EMAIL_ISPRIMARY = "email_isprimary";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.070 -0500", hash_original_field = "2B8A3068FED6387E0B95F04D6CB59EC7", hash_generated_field = "6FD78194AFE767FC50E1879245A1A8C2")

            public static final String SECONDARY_EMAIL = "secondary_email";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.072 -0500", hash_original_field = "6B8E90265EDF18DC05782B4DF96CA69E", hash_generated_field = "42A1240E78AF2AAA1C00CEA323946D39")

            public static final String SECONDARY_EMAIL_TYPE = "secondary_email_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.075 -0500", hash_original_field = "DA3C2764BEE28CACA761E50AB7C34154", hash_generated_field = "39D6023493877247D0BA850ADCA80503")

            public static final String TERTIARY_EMAIL = "tertiary_email";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.078 -0500", hash_original_field = "587A1B2954AC45E8BB0D1C7D94DA7C7B", hash_generated_field = "F1BB0DF7E89E304FE25A4629E8B7ECAE")

            public static final String TERTIARY_EMAIL_TYPE = "tertiary_email_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.081 -0500", hash_original_field = "5D7D890421F1E14295CAA1D97ADFF13A", hash_generated_field = "16A9B5315BE6511E8C8C027F9A8BA319")

            public static final String POSTAL = "postal";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.083 -0500", hash_original_field = "9469AC4D64F3A4A0FFBA4CCA4AA3D103", hash_generated_field = "5B1A73813BB9BA4F0DD1A8C5E9748E8F")

            public static final String POSTAL_TYPE = "postal_type";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.086 -0500", hash_original_field = "D69C0EB0715628C5BDB009A09B6D43E9", hash_generated_field = "146C8C0EE7F160B0D91705B591EB4267")

            public static final String POSTAL_ISPRIMARY = "postal_isprimary";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.089 -0500", hash_original_field = "837F76DD39FAE0CA9FF175481CB38CA3", hash_generated_field = "DD828D08FD6E1452CD2A0CA138269906")

            public static final String IM_HANDLE = "im_handle";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.091 -0500", hash_original_field = "B852FA2A605410314CDEDDB43C5A786C", hash_generated_field = "80A550AB07C0EB0D72631848FAE3AD77")

            public static final String IM_PROTOCOL = "im_protocol";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.094 -0500", hash_original_field = "E3BF9CA69F2710505E7C73C3E60E61A5", hash_generated_field = "BE91E4F2A0E419B1DB9038AE9DC12E15")

            public static final String IM_ISPRIMARY = "im_isprimary";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.097 -0500", hash_original_field = "87B6A7E59436DB89440DBD1549C317A4", hash_generated_field = "319364121428350EE2F4E83744CF0E5C")

            public static final String DATA = "data";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.099 -0500", hash_original_field = "8F333A4B7795111932D48801B4917C75", hash_generated_field = "95FDE4400867AFC68212BF727B1AD7CC")

            public static final String ACCOUNT = "com.android.contacts.extra.ACCOUNT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.102 -0500", hash_original_field = "5B245F0752339BCE52ADF6C4226E5D13", hash_generated_field = "267D13C3CA9C65C1D39CB067CDA6981B")

            public static final String DATA_SET = "com.android.contacts.extra.DATA_SET";
            
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.242 -0400", hash_original_method = "2A9E1DC472832B4765A0A21D09988277", hash_generated_method = "2A9E1DC472832B4765A0A21D09988277")
            public Insert ()
            {
                //Synthesized constructor
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.950 -0500", hash_original_field = "BBCA58AFFA45399FBFE25FEE07CC5EB6", hash_generated_field = "DA2A25A25B6B3F26EE4468747CC6E08A")

        public static final String SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED =
                "android.provider.Contacts.SEARCH_SUGGESTION_DIAL_NUMBER_CLICKED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.952 -0500", hash_original_field = "1BE955E62DAEFB94C542AD142702F84D", hash_generated_field = "2115A82C302B7499D9E43F1F9CC02C26")

        public static final String SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED =
                "android.provider.Contacts.SEARCH_SUGGESTION_CREATE_CONTACT_CLICKED";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.956 -0500", hash_original_field = "0849F147B84297D21C102A0C6F45EA7E", hash_generated_field = "9F22604D06FF2A8A9715D19377B1A01D")

        public static final String ATTACH_IMAGE =
                "com.android.contacts.action.ATTACH_IMAGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.958 -0500", hash_original_field = "A47132F902894DE68D6220DCC99270C6", hash_generated_field = "F24E618647C98A3226ED81E567FCAFFB")

        public static final String INVITE_CONTACT =
                "com.android.contacts.action.INVITE_CONTACT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.961 -0500", hash_original_field = "72855DDAF4060C7CDE9192BE5C0B1947", hash_generated_field = "C4028B0307D626E403E0499E11C95CD7")

        public static final String SHOW_OR_CREATE_CONTACT =
                "com.android.contacts.action.SHOW_OR_CREATE_CONTACT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.963 -0500", hash_original_field = "8D8B3F5B7482064D71DEA63E3B78B2EE", hash_generated_field = "0F60964076DA5FE3C45B9D348905CAF8")

        public static final String ACTION_GET_MULTIPLE_PHONES =
                "com.android.contacts.action.GET_MULTIPLE_PHONES";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.966 -0500", hash_original_field = "60894C1F77711E9F80F7A7EA15D321FD", hash_generated_field = "C84AA19FB248DB5751ED2E98D1080B4C")

        public static final String EXTRA_FORCE_CREATE =
                "com.android.contacts.action.FORCE_CREATE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.968 -0500", hash_original_field = "4FF051B125BAD41C4E60A3262579CA53", hash_generated_field = "CCB9A0BCB8AC5F3B27B71026D70005CF")

        public static final String EXTRA_CREATE_DESCRIPTION =
            "com.android.contacts.action.CREATE_DESCRIPTION";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.971 -0500", hash_original_field = "CAE89020185EB3960FDA6383A7AC724A", hash_generated_field = "151F25A2D9735A74D96C2AD335D686C4")

        public static final String EXTRA_PHONE_URIS =
            "com.android.contacts.extra.PHONE_URIS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.973 -0500", hash_original_field = "82FF7C803068B9039F51E5ABE5A4C33F", hash_generated_field = "30E30433E867A007E9F4274ED19ABED7")

        @Deprecated
        public static final String EXTRA_TARGET_RECT = "target_rect";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.976 -0500", hash_original_field = "03E078E2ED2480EC226571C038E5D5AB", hash_generated_field = "C02F74A2B81BF596BB306FC81B188A5D")

        @Deprecated
        public static final String EXTRA_MODE = "mode";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.979 -0500", hash_original_field = "911FDC64DD8D07E279EC50927E619976", hash_generated_field = "5398604140D0C7FCD5670D1E6E50B3F0")

        @Deprecated
        public static final int MODE_SMALL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.981 -0500", hash_original_field = "B3339A95E1CB24A4D48EADA03C5F8A44", hash_generated_field = "E92EED4E6D32AA90558A4544CB6BD1B0")

        @Deprecated
        public static final int MODE_MEDIUM = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.984 -0500", hash_original_field = "5EA8E31137D72FEAC1E12F6EB9085062", hash_generated_field = "F026CBB55815E93E494A2842E318F883")

        @Deprecated
        public static final int MODE_LARGE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:46.987 -0500", hash_original_field = "D88C1CBC3C7312797F8B199D24EEC534", hash_generated_field = "0AB31B2F643C6FD8DB6DB3EB56EF9E3E")

        @Deprecated
        public static final String EXTRA_EXCLUDE_MIMES = "exclude_mimes";
        
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.240 -0400", hash_original_method = "1E952476DD941AF572EDA8AC50686906", hash_generated_method = "1E952476DD941AF572EDA8AC50686906")
        public Intents ()
        {
            //Synthesized constructor
        }
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.551 -0500", hash_original_field = "1D115A05DC7E49A1F1C479FF10C36F87", hash_generated_field = "B1D8562AF60924B20700DDD648EE3109")

    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.553 -0500", hash_original_field = "65F0650BF967CAA3F47B71C9DCE7E498", hash_generated_field = "644CE73EB8766FA330BF3C4B8E384D0A")

    public static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.556 -0500", hash_original_field = "E910A91D255432D3E49561E136E1F0FA", hash_generated_field = "42ABBED65129DF38A6A4886F320A25F0")

    public static final String DIRECTORY_PARAM_KEY = "directory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.558 -0500", hash_original_field = "6D38C4F6B670B4525B4B1D4C8C81E9FA", hash_generated_field = "2D8DE5D7257CF584D367D715403C3860")

    public static final String LIMIT_PARAM_KEY = "limit";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.561 -0500", hash_original_field = "61D8CE12CCACFEE27510A20C0DE03C06", hash_generated_field = "D3067D1ABEF0431DDD32B3D98E42DF3C")

    public static final String PRIMARY_ACCOUNT_NAME = "name_for_primary_account";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.564 -0500", hash_original_field = "42BBAF59B303D59A4811E43CC7195C01", hash_generated_field = "6EF8639E2C62EA62D2C21DF3CE5BB688")

    public static final String PRIMARY_ACCOUNT_TYPE = "type_for_primary_account";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.566 -0500", hash_original_field = "49D76CEF0AEA8A78F5E0A62029971B5F", hash_generated_field = "5B0CC0121B9203D3AA6EE95F177BF61E")

    public static final String STREQUENT_PHONE_ONLY = "strequent_phone_only";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.569 -0500", hash_original_field = "733D40D42DF96CD70303C1CABFCC6328", hash_generated_field = "91AD6C2785F4D2C8B18EB47243AB2E3C")

    public static final String DEFERRED_SNIPPETING = "deferred_snippeting";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.571 -0500", hash_original_field = "8CD6491C1C5D1B9611936A342BBE1A5C", hash_generated_field = "14839B6FA3C88B296372359851697ECC")

    public static final String DEFERRED_SNIPPETING_QUERY = "deferred_snippeting_query";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:45.573 -0500", hash_original_field = "C051568F7B98C3802C01D6E4433F5812", hash_generated_field = "A0402873080D13DD56D9BD37D27F4D87")

    public static final String REMOVE_DUPLICATE_ENTRIES = "remove_duplicate_entries";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:47.117 -0500", hash_original_field = "3B2E4534C9049372CBA5D66C8C1C6396", hash_generated_field = "BFA597C8407085E19653605D4E02003E")

    private static Pattern SPLIT_PATTERN =
        Pattern.compile("([\\w-\\.]+)@((?:[\\w]+\\.)+)([a-zA-Z]{2,4})|[\\w]+");
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.204 -0400", hash_original_method = "0E78EC66D3E46BD387B4E4A98C6CA3E4", hash_generated_method = "0E78EC66D3E46BD387B4E4A98C6CA3E4")
    public ContactsContract ()
    {
        //Synthesized constructor
    }
}

