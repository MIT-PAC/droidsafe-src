package android.provider;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Locale;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

public class UserDictionary {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.915 -0400", hash_original_method = "A702CC64E997273813B5205310B01CF9", hash_generated_method = "A702CC64E997273813B5205310B01CF9")
    public UserDictionary ()
    {
        //Synthesized constructor
    }


    public static class Words implements BaseColumns {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.917 -0400", hash_original_method = "C1D0CFC6A151C5F38326116B5D69C610", hash_generated_method = "C1D0CFC6A151C5F38326116B5D69C610")
        public Words ()
        {
            //Synthesized constructor
        }


        public static void addWord(Context context, String word, 
                int frequency, int localeType) {
            final ContentResolver resolver = context.getContentResolver();
            if (TextUtils.isEmpty(word) || localeType < 0 || localeType > 1) {
                return;
            }
            if (frequency < 0) frequency = 0;
            if (frequency > 255) frequency = 255;
            String locale = null;
            if (localeType == LOCALE_TYPE_CURRENT) {
                locale = Locale.getDefault().toString();
            }
            ContentValues values = new ContentValues(4);
            values.put(WORD, word);
            values.put(FREQUENCY, frequency);
            values.put(LOCALE, locale);
            values.put(APP_ID, 0);
            Uri result = resolver.insert(CONTENT_URI, values);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.918 -0400", hash_original_field = "82ED8E3FCE639046CB82ADD3D8657293", hash_generated_field = "E7B212F8D42963CE246A90A1AE667E7B")

        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY + "/words");
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.918 -0400", hash_original_field = "E997B672E6A671B6B15EC137D0F5FD24", hash_generated_field = "798AF4C5E5771092C107BEDEE5D191AD")

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.google.userword";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.918 -0400", hash_original_field = "59FB04BC38B59E577E4BB14CEE090408", hash_generated_field = "81A443159623417638C86F2E18E3B3E4")

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.google.userword";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.918 -0400", hash_original_field = "8E350FE48B3710110DC161B36CFF19E6", hash_generated_field = "89BC66923778B3B398E289E4EE7EE036")

        public static final String _ID = BaseColumns._ID;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.918 -0400", hash_original_field = "724EDA4EA7E032EBC05A5EA07E3FBF77", hash_generated_field = "B3FC2FC8E81C6A66A8A7123C0401C73F")

        public static final String WORD = "word";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.919 -0400", hash_original_field = "EEE7859D6791E2FABF503C1A98054DCC", hash_generated_field = "D75A5977B689BDF7E90C430A4E2B43B1")

        public static final String FREQUENCY = "frequency";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.919 -0400", hash_original_field = "5D7FF2E484AC934E90093A49123BEC80", hash_generated_field = "0DF214A9C96B2B7F36BF8760B61BA2C1")

        public static final String LOCALE = "locale";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.919 -0400", hash_original_field = "696CB0EE493FAAD0AA35F604C791E6C0", hash_generated_field = "BFF39BD87EA0E23A31179D50AF393F2C")

        public static final String APP_ID = "appid";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.919 -0400", hash_original_field = "6211F28949409799350432B9665C7BBE", hash_generated_field = "4817122C21015A70C8966373B446CEC6")

        public static final int LOCALE_TYPE_ALL = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.919 -0400", hash_original_field = "2C652E283EB868185E4228B45BA9D1F8", hash_generated_field = "093EBB1B22A13749A5986442A9195090")

        public static final int LOCALE_TYPE_CURRENT = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.919 -0400", hash_original_field = "C2E2BF0D756420EEBA67A3DB6B47B5DC", hash_generated_field = "440B538681182D164C8BD929222F6471")

        public static final String DEFAULT_SORT_ORDER = FREQUENCY + " DESC";
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.919 -0400", hash_original_field = "2295BDB1450F38441980DB66B39619FB", hash_generated_field = "B6B30B3A7906E3A97F32B444BC5E6701")

    public static final String AUTHORITY = "user_dictionary";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:30.919 -0400", hash_original_field = "083A9A6E0091C7159BC5D55CE6FC0135", hash_generated_field = "D118CEA06FF497F93B41482BB0D0564B")

    public static final Uri CONTENT_URI =
        Uri.parse("content://" + AUTHORITY);
}

