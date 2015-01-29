package android.speech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

public class RecognizerIntent {
    
    /**
     * Returns the broadcast intent to fire with
     * {@link Context#sendOrderedBroadcast(Intent, String, BroadcastReceiver, android.os.Handler, int, String, Bundle)}
     * to receive details from the package that implements voice search.
     * <p>
     * This is based on the value specified by the voice search {@link Activity} in
     * {@link #DETAILS_META_DATA}, and if this is not specified, will return null. Also if there
     * is no chosen default to resolve for {@link #ACTION_WEB_SEARCH}, this will return null.
     * <p>
     * If an intent is returned and is fired, a {@link Bundle} of extras will be returned to the
     * provided result receiver, and should ideally contain values for
     * {@link #EXTRA_LANGUAGE_PREFERENCE} and {@link #EXTRA_SUPPORTED_LANGUAGES}.
     * <p>
     * (Whether these are actually provided is up to the particular implementation. It is
     * recommended that {@link Activity}s implementing {@link #ACTION_WEB_SEARCH} provide this
     * information, but it is not required.)
     * 
     * @param context a context object
     * @return the broadcast intent to fire or null if not available
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.478 -0500", hash_original_method = "EAF990333A418B73AD290999AE81A4C6", hash_generated_method = "5B0172C31DBABB0C2A2D86C1020F0C57")
    
public static final Intent getVoiceDetailsIntent(Context context) {
        Intent voiceSearchIntent = new Intent(ACTION_WEB_SEARCH);
        ResolveInfo ri = context.getPackageManager().resolveActivity(
                voiceSearchIntent, PackageManager.GET_META_DATA);
        if (ri == null || ri.activityInfo == null || ri.activityInfo.metaData == null) return null;
        
        String className = ri.activityInfo.metaData.getString(DETAILS_META_DATA);
        if (className == null) return null;
        
        Intent detailsIntent = new Intent(ACTION_GET_LANGUAGE_DETAILS);
        detailsIntent.setComponent(new ComponentName(ri.activityInfo.packageName, className));
        return detailsIntent;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.415 -0500", hash_original_field = "7EC2139241351D6DB7C1794775111F7C", hash_generated_field = "F2CE329A7E63AC5B3F97EB1D85C0439E")

    public final static String EXTRA_CALLING_PACKAGE = "calling_package";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.419 -0500", hash_original_field = "7E1C9D3A565B98106622E3E92FA420C3", hash_generated_field = "B3B31960E97FA2D5173B28B70C95E777")

    public static final String ACTION_RECOGNIZE_SPEECH = "android.speech.action.RECOGNIZE_SPEECH";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.422 -0500", hash_original_field = "5B5BC93AB0F6A9325D82BE13433B022A", hash_generated_field = "25BC69086BBC3F89B4049DC0A1879EE1")

    public static final String ACTION_WEB_SEARCH = "android.speech.action.WEB_SEARCH";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.424 -0500", hash_original_field = "7313265D87A4D05EFE90B7150B4D880C", hash_generated_field = "65BE6272C1654ADA985CFE8267F1FD5A")

    public static final String EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS =
            "android.speech.extras.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.427 -0500", hash_original_field = "8EA3413871FC0D0F8E0512863B90DF8E", hash_generated_field = "6340BE8C266779494E26A59DF2497D86")

    public static final String EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS =
            "android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.429 -0500", hash_original_field = "7BDBF51B729208A562CA51C8B4E63F38", hash_generated_field = "B512FF6BBAE8DC2EBAD7FC155C92B6BB")

    public static final String EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS =
            "android.speech.extras.SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.433 -0500", hash_original_field = "4A9ED244133074B4325E5339070022A6", hash_generated_field = "AE97D27B7EF9A4CC633A84C04F3E5C0E")

    public static final String EXTRA_LANGUAGE_MODEL = "android.speech.extra.LANGUAGE_MODEL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.435 -0500", hash_original_field = "0E556F0D41F3B4AC3180A7D51A6ABBB6", hash_generated_field = "0CE334FFBE00B6D59DBBDE8609157CFD")

    public static final String LANGUAGE_MODEL_FREE_FORM = "free_form";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.437 -0500", hash_original_field = "D46BD000B5D0203C0282A8BCF46F25F4", hash_generated_field = "D0A34FABBD3389A2306C9B9C8955C237")

    public static final String LANGUAGE_MODEL_WEB_SEARCH = "web_search";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.439 -0500", hash_original_field = "D6E43BC049753AA49EF7A9018DACC88C", hash_generated_field = "1AB018307F02D98322D9EC05A150F66F")

    public static final String EXTRA_PROMPT = "android.speech.extra.PROMPT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.441 -0500", hash_original_field = "3C04D583DB8035E6D2640D4C6EB60E17", hash_generated_field = "8959A493E5E30F45FA410E2682F12340")

    public static final String EXTRA_LANGUAGE = "android.speech.extra.LANGUAGE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.444 -0500", hash_original_field = "FA07018C488C04CE48EB7E8ABE4F5D2F", hash_generated_field = "BBE24B8948A0EB48B90F6E89CA5A6463")

    public static final String EXTRA_ORIGIN = "android.speech.extra.ORIGIN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.447 -0500", hash_original_field = "5144ABF10F2E56014064E57432B8CE11", hash_generated_field = "A09B26CF499AEF1A8DF65A995CED556A")

    public static final String EXTRA_MAX_RESULTS = "android.speech.extra.MAX_RESULTS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.449 -0500", hash_original_field = "4969F34E68276A30D92D70A77064F6CC", hash_generated_field = "1E3F70BA9658921DB26D54B798F9EF65")

    public static final String EXTRA_WEB_SEARCH_ONLY = "android.speech.extra.WEB_SEARCH_ONLY";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.452 -0500", hash_original_field = "0A84E1E34E3B0EC09ADF991C9D795ED6", hash_generated_field = "7B20023FC60B5EED1300B594F47FF851")

    public static final String EXTRA_PARTIAL_RESULTS = "android.speech.extra.PARTIAL_RESULTS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.455 -0500", hash_original_field = "D7F2F806E219EDAD7E76D8B85499CF7D", hash_generated_field = "8D2BF93282F8B5BDAC47E27FA53C0AD8")

    public static final String EXTRA_RESULTS_PENDINGINTENT = 
            "android.speech.extra.RESULTS_PENDINGINTENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.457 -0500", hash_original_field = "886DAE9F859F37B9EA150F031DC11862", hash_generated_field = "27B95BBDD60F15AEAEBB4E483650A95A")

    public static final String EXTRA_RESULTS_PENDINGINTENT_BUNDLE = 
            "android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.460 -0500", hash_original_field = "B8B725C5B4BC93C23D38E2EA47A690D1", hash_generated_field = "881C6A7303ABE5F4296A560DC08CC1EB")

    public static final int RESULT_NO_MATCH = Activity.RESULT_FIRST_USER;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.462 -0500", hash_original_field = "9E58F44F2F70A0EA5D334875CA758768", hash_generated_field = "E35F6D5A02B7908C8493A4E8AA628F3D")

    public static final int RESULT_CLIENT_ERROR = Activity.RESULT_FIRST_USER + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.464 -0500", hash_original_field = "CF82AD3594CA54CF47703146C552E166", hash_generated_field = "6EFA9FC49756466007DD034C3325CED3")

    public static final int RESULT_SERVER_ERROR = Activity.RESULT_FIRST_USER + 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.468 -0500", hash_original_field = "ED923FE013E5807B56F9312B214A2E7D", hash_generated_field = "D910894AB5D9CBB3C2D4D80614B95D9E")

    public static final int RESULT_NETWORK_ERROR = Activity.RESULT_FIRST_USER + 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.470 -0500", hash_original_field = "0C56635C171F7220AB45A2E41B485BF4", hash_generated_field = "4E496D3FA6A2D2E07CDB18F2ABDD0A01")

    public static final int RESULT_AUDIO_ERROR = Activity.RESULT_FIRST_USER + 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.472 -0500", hash_original_field = "BF4EB756C761002095433E9DB14384CA", hash_generated_field = "DE1C717238F6EA586B72E3F1A4ACFFCF")

    public static final String EXTRA_RESULTS = "android.speech.extra.RESULTS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.475 -0500", hash_original_field = "C436D2D8C3E2451C94C1E5B257553531", hash_generated_field = "247C08485FA805F89DA533377888D422")

    public static final String EXTRA_CONFIDENCE_SCORES = "android.speech.extra.CONFIDENCE_SCORES";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.480 -0500", hash_original_field = "E7C2A9F88A53582E711F325258E9FFAD", hash_generated_field = "E6F8CA9A25D76A4853508DD9368BBC9F")

    public static final String DETAILS_META_DATA = "android.speech.DETAILS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.483 -0500", hash_original_field = "09C159E72B182477BBE9911A440FF52D", hash_generated_field = "BFFD18F0FC425C5EE64B89B80CC27F4B")

    public static final String ACTION_GET_LANGUAGE_DETAILS =
            "android.speech.action.GET_LANGUAGE_DETAILS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.485 -0500", hash_original_field = "3ED32643D6964A23CABA834784EB2034", hash_generated_field = "CB08C29CBA6082FF4F2F0060351B47F1")

    public static final String EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE =
            "android.speech.extra.ONLY_RETURN_LANGUAGE_PREFERENCE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.487 -0500", hash_original_field = "7ADB87A0B20CAB50515F7FE86BBF2A61", hash_generated_field = "63FD9CCFD6AAAC4CBB7911C734B4F150")

    public static final String EXTRA_LANGUAGE_PREFERENCE =
            "android.speech.extra.LANGUAGE_PREFERENCE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.490 -0500", hash_original_field = "3D60317EAC128AFD27A156762046DC3D", hash_generated_field = "5B022AE0597A25670085BC9F618C41FA")

    public static final String EXTRA_SUPPORTED_LANGUAGES =
            "android.speech.extra.SUPPORTED_LANGUAGES";

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:52.417 -0500", hash_original_method = "481DA9A3FEB0B3A08BDC3010832E7C57", hash_generated_method = "57EEFF206AA81510C1A0ED941F197A5E")
    
private RecognizerIntent() {
        // Not for instantiating.
    }
}

