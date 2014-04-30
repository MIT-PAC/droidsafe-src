package android.provider;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

public class UserDictionary {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.088 -0500", hash_original_field = "78273A4B8EDF5349BB0B456A12086456", hash_generated_field = "B6B30B3A7906E3A97F32B444BC5E6701")

    public static final String AUTHORITY = "user_dictionary";

    public static class Words implements BaseColumns {

        /** Adds a word to the dictionary, with the given frequency and the specified
         *  specified locale type.
         *  @param context the current application context
         *  @param word the word to add to the dictionary. This should not be null or
         *  empty.
         *  @param localeType the locale type for this word. It should be one of
         *  {@link #LOCALE_TYPE_ALL} or {@link #LOCALE_TYPE_CURRENT}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.123 -0500", hash_original_method = "0F8F7B76F67AF9BED3D8B41DF390E843", hash_generated_method = "13D1AF26CD5898615D95C6012E9A6513")
        
public static void addWord(Context context, String word, 
                int frequency, int localeType) {
            final ContentResolver resolver = context.getContentResolver();

            if (TextUtils.isEmpty(word) || localeType < 0 || localeType > 1) {
                return;
            }
            
            if (frequency < 0) frequency = 0;
            if (frequency > 255) frequency = 255;

            String locale = null;

            // TODO: Verify if this is the best way to get the current locale
            if (localeType == LOCALE_TYPE_CURRENT) {
                locale = Locale.getDefault().toString();
            }
            ContentValues values = new ContentValues(4);

            values.put(WORD, word);
            values.put(FREQUENCY, frequency);
            values.put(LOCALE, locale);
            values.put(APP_ID, 0); // TODO: Get App UID

            Uri result = resolver.insert(CONTENT_URI, values);
            // It's ok if the insert doesn't succeed because the word
            // already exists.
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.095 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "E7B212F8D42963CE246A90A1AE667E7B")

        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/words");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.097 -0500", hash_original_field = "8CA7ACBA968B8CA0D990922DC8A9D2CE", hash_generated_field = "798AF4C5E5771092C107BEDEE5D191AD")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.userword";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.099 -0500", hash_original_field = "DE5853F0193D78B7594AD5E5DC3A9563", hash_generated_field = "81A443159623417638C86F2E18E3B3E4")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.userword";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.102 -0500", hash_original_field = "52863E5ABCE1392E12509003A344A371", hash_generated_field = "89BC66923778B3B398E289E4EE7EE036")

        public static final String _ID = BaseColumns._ID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.104 -0500", hash_original_field = "2CAB206DB4DAE038435A2697624F0629", hash_generated_field = "B3FC2FC8E81C6A66A8A7123C0401C73F")

        public static final String WORD = "word";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.108 -0500", hash_original_field = "174DF678B989B4DE8ED0B56DA8D4BF09", hash_generated_field = "D75A5977B689BDF7E90C430A4E2B43B1")

        public static final String FREQUENCY = "frequency";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.110 -0500", hash_original_field = "D2674CAE07E530366C5AAD8BD330C39F", hash_generated_field = "0DF214A9C96B2B7F36BF8760B61BA2C1")

        public static final String LOCALE = "locale";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.113 -0500", hash_original_field = "79C47DCDD6ED78D8A479AFD68B1C784E", hash_generated_field = "BFF39BD87EA0E23A31179D50AF393F2C")

        public static final String APP_ID = "appid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.115 -0500", hash_original_field = "FDBF1847464770609F3F1FED12AE014C", hash_generated_field = "4817122C21015A70C8966373B446CEC6")

        public static final int LOCALE_TYPE_ALL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.118 -0500", hash_original_field = "DA5D5D007BF85B87AFF5CF557BE937A6", hash_generated_field = "093EBB1B22A13749A5986442A9195090")

        public static final int LOCALE_TYPE_CURRENT = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.120 -0500", hash_original_field = "9423A3C97D7BC4641DAAD087D3D1451A", hash_generated_field = "440B538681182D164C8BD929222F6471")

        public static final String DEFAULT_SORT_ORDER = FREQUENCY + " DESC";
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.917 -0400", hash_original_method = "C1D0CFC6A151C5F38326116B5D69C610", hash_generated_method = "C1D0CFC6A151C5F38326116B5D69C610")
        public Words ()
        {
            //Synthesized constructor
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:59.092 -0500", hash_original_field = "04DAC5FD1BD0B97C5BB8885AD5DB5AEE", hash_generated_field = "D118CEA06FF497F93B41482BB0D0564B")

    public static final Uri CONTENT_URI =
        Uri.parse("content://" + AUTHORITY);
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.915 -0400", hash_original_method = "A702CC64E997273813B5205310B01CF9", hash_generated_method = "A702CC64E997273813B5205310B01CF9")
    public UserDictionary ()
    {
        //Synthesized constructor
    }
}

