package android.renderscript;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import android.content.res.AssetManager;
import java.util.Map;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;
import android.os.Environment;
import java.util.HashMap;
import java.io.IOException;
import android.content.res.Resources;
public class Font extends BaseObj {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.205 -0500", hash_original_method = "4289425781D98B256AF3FE355FCAC656", hash_generated_method = "A11E9D313233E262DFD3FD99906D3805")
    
private static void addFamilyToMap(FontFamily family) {
        for(int i = 0; i < family.mNames.length; i ++) {
            sFontFamilyMap.put(family.mNames[i], family);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.208 -0500", hash_original_method = "C5D0B1FC913C6CAD386E4358A12A37F8", hash_generated_method = "11F387AD43C7B85FB1DD15D7677948DC")
    
private static void initFontFamilyMap() {
        sFontFamilyMap = new HashMap<String, FontFamily>();

        FontFamily sansFamily = new FontFamily();
        sansFamily.mNames = sSansNames;
        sansFamily.mNormalFileName = "Roboto-Regular.ttf";
        sansFamily.mBoldFileName = "Roboto-Bold.ttf";
        sansFamily.mItalicFileName = "Roboto-Italic.ttf";
        sansFamily.mBoldItalicFileName = "Roboto-BoldItalic.ttf";
        addFamilyToMap(sansFamily);

        FontFamily serifFamily = new FontFamily();
        serifFamily.mNames = sSerifNames;
        serifFamily.mNormalFileName = "DroidSerif-Regular.ttf";
        serifFamily.mBoldFileName = "DroidSerif-Bold.ttf";
        serifFamily.mItalicFileName = "DroidSerif-Italic.ttf";
        serifFamily.mBoldItalicFileName = "DroidSerif-BoldItalic.ttf";
        addFamilyToMap(serifFamily);

        FontFamily monoFamily = new FontFamily();
        monoFamily.mNames = sMonoNames;
        monoFamily.mNormalFileName = "DroidSansMono.ttf";
        monoFamily.mBoldFileName = "DroidSansMono.ttf";
        monoFamily.mItalicFileName = "DroidSansMono.ttf";
        monoFamily.mBoldItalicFileName = "DroidSansMono.ttf";
        addFamilyToMap(monoFamily);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.212 -0500", hash_original_method = "09D51F3C3FE8386D16AF2C83BD55E4AE", hash_generated_method = "AECD723D6EFB8A96F6D9BCC052FE6539")
    
static String getFontFileName(String familyName, Style style) {
        FontFamily family = sFontFamilyMap.get(familyName);
        if(family != null) {
            switch(style) {
                case NORMAL:
                    return family.mNormalFileName;
                case BOLD:
                    return family.mBoldFileName;
                case ITALIC:
                    return family.mItalicFileName;
                case BOLD_ITALIC:
                    return family.mBoldItalicFileName;
            }
        }
        // Fallback if we could not find the desired family
        return "DroidSans.ttf";
    }

    /**
     * Takes a specific file name as an argument
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.217 -0500", hash_original_method = "46994FD8CFA49DCC9FB18F8A8634FC48", hash_generated_method = "82446CDD6D1A4F793B9B6E366FCF0162")
    
static public Font createFromFile(RenderScript rs, Resources res, String path, float pointSize) {
        rs.validate();
        int dpi = res.getDisplayMetrics().densityDpi;
        int fontId = rs.nFontCreateFromFile(path, pointSize, dpi);

        if(fontId == 0) {
            throw new RSRuntimeException("Unable to create font from file " + path);
        }
        Font rsFont = new Font(fontId, rs);

        return rsFont;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.219 -0500", hash_original_method = "184831F1F3D6016E5534127C7DA91E29", hash_generated_method = "22B2DDC4E603D7D329AD1EC162D381F1")
    
static public Font createFromFile(RenderScript rs, Resources res, File path, float pointSize) {
        return createFromFile(rs, res, path.getAbsolutePath(), pointSize);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.221 -0500", hash_original_method = "6CB23BBEA5E75D7E9C31D64668AD1B49", hash_generated_method = "DC725EF17E6986E9F0D2A1B51A8C303A")
    
static public Font createFromAsset(RenderScript rs, Resources res, String path, float pointSize) {
        rs.validate();
        AssetManager mgr = res.getAssets();
        int dpi = res.getDisplayMetrics().densityDpi;

        int fontId = rs.nFontCreateFromAsset(mgr, path, pointSize, dpi);
        if(fontId == 0) {
            throw new RSRuntimeException("Unable to create font from asset " + path);
        }
        Font rsFont = new Font(fontId, rs);
        return rsFont;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.224 -0500", hash_original_method = "5B5333611708852FADDD718F4009F256", hash_generated_method = "8EA5DF6EC3ACE9F4E31AE910EED7F4E0")
    
static public Font createFromResource(RenderScript rs, Resources res, int id, float pointSize) {
        String name = "R." + Integer.toString(id);

        rs.validate();
        InputStream is = null;
        try {
            is = res.openRawResource(id);
        } catch (Exception e) {
            throw new RSRuntimeException("Unable to open resource " + id);
        }

        int dpi = res.getDisplayMetrics().densityDpi;

        int fontId = 0;
        if (is instanceof AssetManager.AssetInputStream) {
            int asset = ((AssetManager.AssetInputStream) is).getAssetInt();
            fontId = rs.nFontCreateFromAssetStream(name, pointSize, dpi, asset);
        } else {
            throw new RSRuntimeException("Unsupported asset stream created");
        }

        if(fontId == 0) {
            throw new RSRuntimeException("Unable to create font from resource " + id);
        }
        Font rsFont = new Font(fontId, rs);
        return rsFont;
    }

    /**
     * Accepts one of the following family names as an argument
     * and will attempt to produce the best match with a system font:
     *
     * "sans-serif" "arial" "helvetica" "tahoma" "verdana"
     * "serif" "times" "times new roman" "palatino" "georgia" "baskerville"
     * "goudy" "fantasy" "cursive" "ITC Stone Serif"
     * "monospace" "courier" "courier new" "monaco"
     *
     * Returns default font if no match could be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.227 -0500", hash_original_method = "889DAC0CA7DB345B55EE52B7B465C4DD", hash_generated_method = "0E19E4903F836B50DBACF794C244FAE0")
    
static public Font create(RenderScript rs, Resources res, String familyName, Style fontStyle, float pointSize) {
        String fileName = getFontFileName(familyName, fontStyle);
        String fontPath = Environment.getRootDirectory().getAbsolutePath();
        fontPath += "/fonts/" + fileName;
        return createFromFile(rs, res, fontPath, pointSize);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.181 -0500", hash_original_field = "0CA7BCD8BA4AA3ED12D7F461436BFEDF", hash_generated_field = "8BC2D87CD2A1F44E6D97553AF264AE04")

    private static final String[] sSansNames = {
        "sans-serif", "arial", "helvetica", "tahoma", "verdana"
    };
    
    private static class FontFamily {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.189 -0500", hash_original_field = "C468A34F5DD151632BC543C242FE3020", hash_generated_field = "C468A34F5DD151632BC543C242FE3020")

        String[] mNames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.191 -0500", hash_original_field = "8405B33ACB81E7FCD7174A69A1A9F1C5", hash_generated_field = "8405B33ACB81E7FCD7174A69A1A9F1C5")

        String mNormalFileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.193 -0500", hash_original_field = "E437C40DB3D9DC288DE7AA73AF1A11BF", hash_generated_field = "E437C40DB3D9DC288DE7AA73AF1A11BF")

        String mBoldFileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.195 -0500", hash_original_field = "1656ED9CD212F40AB8536F22B2C84A3E", hash_generated_field = "1656ED9CD212F40AB8536F22B2C84A3E")

        String mItalicFileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.197 -0500", hash_original_field = "2D7185F9EF5F494D5A3DF2089C6F43AA", hash_generated_field = "2D7185F9EF5F494D5A3DF2089C6F43AA")

        String mBoldItalicFileName;
        
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-09 14:02:43.961 -0400", hash_original_method = "4B1D119D7774A95910A46246D7100E2A", hash_generated_method = "4B1D119D7774A95910A46246D7100E2A")
        public FontFamily ()
        {
            //Synthesized constructor
        }

    }
    
    public enum Style {
        NORMAL,
        BOLD,
        ITALIC,
        BOLD_ITALIC;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.184 -0500", hash_original_field = "4AA04C324C03CE2E0B67DE0D97E5571F", hash_generated_field = "956EE2129D0161C6B10DC2012BE919B2")

    private static final String[] sSerifNames = {
        "serif", "times", "times new roman", "palatino", "georgia", "baskerville",
        "goudy", "fantasy", "cursive", "ITC Stone Serif"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.186 -0500", hash_original_field = "55AB6F7A69D23ED44A1D56A18EEE5F4C", hash_generated_field = "61C4C302027A48126C97C1452FCD5ED2")

    private static final String[] sMonoNames = {
        "monospace", "courier", "courier new", "monaco"
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.201 -0500", hash_original_field = "1BFAC93E3D4355E44267B1E6BC887866", hash_generated_field = "6636438EA6751E60F063FC76FE98D8F6")

    private static Map<String, FontFamily> sFontFamilyMap;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:11.214 -0500", hash_original_method = "CEBF3BB0FBFA1185414632BE38CC53FE", hash_generated_method = "CEBF3BB0FBFA1185414632BE38CC53FE")
    
Font(int id, RenderScript rs) {
        super(id, rs);
    }
    static {
        initFontFamilyMap();
    }
    
}

