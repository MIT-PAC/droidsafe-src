package android.speech;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

public class RecognizerIntent {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.161 -0400", hash_original_method = "481DA9A3FEB0B3A08BDC3010832E7C57", hash_generated_method = "54134A4D30F1224788C4C762BD8FF149")
    private  RecognizerIntent() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.162 -0400", hash_original_field = "8E109E39B45496246E9CCAD43262DAE3", hash_generated_field = "F2CE329A7E63AC5B3F97EB1D85C0439E")

    public final static String EXTRA_CALLING_PACKAGE = "calling_package";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.162 -0400", hash_original_field = "6101CCE7C8B1536B3D13C0C2812A84D1", hash_generated_field = "B3B31960E97FA2D5173B28B70C95E777")

    public static final String ACTION_RECOGNIZE_SPEECH = "android.speech.action.RECOGNIZE_SPEECH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.163 -0400", hash_original_field = "EBF399D3308F210491704AAF42F37260", hash_generated_field = "25BC69086BBC3F89B4049DC0A1879EE1")

    public static final String ACTION_WEB_SEARCH = "android.speech.action.WEB_SEARCH";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.163 -0400", hash_original_field = "98A6C9979548467A4CA4172B1E091B14", hash_generated_field = "65BE6272C1654ADA985CFE8267F1FD5A")

    public static final String EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS =
            "android.speech.extras.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.163 -0400", hash_original_field = "774F68E1B2B0AE029FF9715F1213F8D7", hash_generated_field = "6340BE8C266779494E26A59DF2497D86")

    public static final String EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS =
            "android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.163 -0400", hash_original_field = "D21694659046AC3C0538856AB11613A3", hash_generated_field = "B512FF6BBAE8DC2EBAD7FC155C92B6BB")

    public static final String EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS =
            "android.speech.extras.SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.163 -0400", hash_original_field = "140D737C3CC3671C1E2B77A1B4D6C2C5", hash_generated_field = "AE97D27B7EF9A4CC633A84C04F3E5C0E")

    public static final String EXTRA_LANGUAGE_MODEL = "android.speech.extra.LANGUAGE_MODEL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.163 -0400", hash_original_field = "14B1882CC81A73B4CA0BEAC60877ADBD", hash_generated_field = "0CE334FFBE00B6D59DBBDE8609157CFD")

    public static final String LANGUAGE_MODEL_FREE_FORM = "free_form";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.163 -0400", hash_original_field = "8161C3B505E9BCBEB4341725931AAE06", hash_generated_field = "D0A34FABBD3389A2306C9B9C8955C237")

    public static final String LANGUAGE_MODEL_WEB_SEARCH = "web_search";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.163 -0400", hash_original_field = "430FFDB0669C94DFBFEE9EA1AE370607", hash_generated_field = "1AB018307F02D98322D9EC05A150F66F")

    public static final String EXTRA_PROMPT = "android.speech.extra.PROMPT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.164 -0400", hash_original_field = "871B96915762D567CFFD3806F0F3ADBC", hash_generated_field = "8959A493E5E30F45FA410E2682F12340")

    public static final String EXTRA_LANGUAGE = "android.speech.extra.LANGUAGE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.164 -0400", hash_original_field = "C5CBAE25855A7416B5C1189E46630BE1", hash_generated_field = "BBE24B8948A0EB48B90F6E89CA5A6463")

    public static final String EXTRA_ORIGIN = "android.speech.extra.ORIGIN";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.164 -0400", hash_original_field = "C14D667D94931047561E4CDA94634272", hash_generated_field = "A09B26CF499AEF1A8DF65A995CED556A")

    public static final String EXTRA_MAX_RESULTS = "android.speech.extra.MAX_RESULTS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.164 -0400", hash_original_field = "61C4C9D8D5673BA4E8252AB48B049AE5", hash_generated_field = "1E3F70BA9658921DB26D54B798F9EF65")

    public static final String EXTRA_WEB_SEARCH_ONLY = "android.speech.extra.WEB_SEARCH_ONLY";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.164 -0400", hash_original_field = "9FA54C5B1B28F8994FD9C0DC4A1263A6", hash_generated_field = "7B20023FC60B5EED1300B594F47FF851")

    public static final String EXTRA_PARTIAL_RESULTS = "android.speech.extra.PARTIAL_RESULTS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.164 -0400", hash_original_field = "127EDAB3FDDDE3625977320F30F4DE88", hash_generated_field = "8D2BF93282F8B5BDAC47E27FA53C0AD8")

    public static final String EXTRA_RESULTS_PENDINGINTENT = 
            "android.speech.extra.RESULTS_PENDINGINTENT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.164 -0400", hash_original_field = "59460C89E6D39581CACE769AE3039E50", hash_generated_field = "27B95BBDD60F15AEAEBB4E483650A95A")

    public static final String EXTRA_RESULTS_PENDINGINTENT_BUNDLE = 
            "android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.164 -0400", hash_original_field = "E97EAFD8AF1631B6E14A91FD26B8CE9B", hash_generated_field = "881C6A7303ABE5F4296A560DC08CC1EB")

    public static final int RESULT_NO_MATCH = Activity.RESULT_FIRST_USER;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "F2D300B0563AB1AD1F99C45533267EC9", hash_generated_field = "E35F6D5A02B7908C8493A4E8AA628F3D")

    public static final int RESULT_CLIENT_ERROR = Activity.RESULT_FIRST_USER + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "333765D4FBD7789A6AC3B8891AD89685", hash_generated_field = "6EFA9FC49756466007DD034C3325CED3")

    public static final int RESULT_SERVER_ERROR = Activity.RESULT_FIRST_USER + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "948BF1D57FD1AA0FC3F8B75D3575FD2C", hash_generated_field = "D910894AB5D9CBB3C2D4D80614B95D9E")

    public static final int RESULT_NETWORK_ERROR = Activity.RESULT_FIRST_USER + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "8903CA33733CDB8F67ACDC26B750F507", hash_generated_field = "4E496D3FA6A2D2E07CDB18F2ABDD0A01")

    public static final int RESULT_AUDIO_ERROR = Activity.RESULT_FIRST_USER + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "D8220CB4007535D195F4113DD943AC87", hash_generated_field = "DE1C717238F6EA586B72E3F1A4ACFFCF")

    public static final String EXTRA_RESULTS = "android.speech.extra.RESULTS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "2A02D32FC0EEFFC4385EBD24381059D2", hash_generated_field = "247C08485FA805F89DA533377888D422")

    public static final String EXTRA_CONFIDENCE_SCORES = "android.speech.extra.CONFIDENCE_SCORES";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "223E7985785753F8F1A7DB0BA3A4A8D2", hash_generated_field = "E6F8CA9A25D76A4853508DD9368BBC9F")

    public static final String DETAILS_META_DATA = "android.speech.DETAILS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "C1193F1934F6061AF3F10574CBDE08FE", hash_generated_field = "BFFD18F0FC425C5EE64B89B80CC27F4B")

    public static final String ACTION_GET_LANGUAGE_DETAILS =
            "android.speech.action.GET_LANGUAGE_DETAILS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "4C3182437C92DB7EABB09A135FF9D78F", hash_generated_field = "CB08C29CBA6082FF4F2F0060351B47F1")

    public static final String EXTRA_ONLY_RETURN_LANGUAGE_PREFERENCE =
            "android.speech.extra.ONLY_RETURN_LANGUAGE_PREFERENCE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "9F423E7AB5ED5A9DCBEC1D129EB9285B", hash_generated_field = "63FD9CCFD6AAAC4CBB7911C734B4F150")

    public static final String EXTRA_LANGUAGE_PREFERENCE =
            "android.speech.extra.LANGUAGE_PREFERENCE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.165 -0400", hash_original_field = "F4853A2A3CD9285AE81C8C7F4C5B26F6", hash_generated_field = "5B022AE0597A25670085BC9F618C41FA")

    public static final String EXTRA_SUPPORTED_LANGUAGES =
            "android.speech.extra.SUPPORTED_LANGUAGES";
}

