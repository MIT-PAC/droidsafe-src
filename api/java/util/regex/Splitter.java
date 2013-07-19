package java.util.regex;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.List;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Splitter {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.476 -0400", hash_original_method = "B7F2802825C1EAFD928ACADA9E8D9911", hash_generated_method = "4F7ABE410345F930060448FAB205D46B")
    private  Splitter() {
        // ---------- Original Method ----------
    }

    
    public static String[] fastSplit(String re, String input, int limit) {
        int len = re.length();
        if (len == 0) {
            return null;
        }
        char ch = re.charAt(0);
        if (len == 1 && METACHARACTERS.indexOf(ch) == -1) {
        } else if (len == 2 && ch == '\\') {
            ch = re.charAt(1);
            if (METACHARACTERS.indexOf(ch) == -1) {
                return null;
            }
        } else {
            return null;
        }
        if (input.isEmpty()) {
            return new String[] { "" };
        }
        ArrayList<String> list = new ArrayList<String>();
        int maxSize = limit <= 0 ? Integer.MAX_VALUE : limit;
        int begin = 0;
        int end;
        while ((end = input.indexOf(ch, begin)) != -1 && list.size() + 1 < maxSize) {
            list.add(input.substring(begin, end));
            begin = end + 1;
        }
        return finishSplit(list, input, begin, maxSize, limit);
    }

    
    public static String[] split(Pattern pattern, String re, String input, int limit) {
        String[] fastResult = fastSplit(re, input, limit);
        if (fastResult != null) {
            return fastResult;
        }
        if (input.isEmpty()) {
            return new String[] { "" };
        }
        ArrayList<String> list = new ArrayList<String>();
        int maxSize = limit <= 0 ? Integer.MAX_VALUE : limit;
        Matcher matcher = new Matcher(pattern, input);
        int begin = 0;
        while (matcher.find() && list.size() + 1 < maxSize) {
            list.add(input.substring(begin, matcher.start()));
            begin = matcher.end();
        }
        return finishSplit(list, input, begin, maxSize, limit);
    }

    
    private static String[] finishSplit(List<String> list, String input, int begin, int maxSize, int limit) {
        if (begin < input.length()) {
            list.add(input.substring(begin));
        } else if (limit != 0) { 
            list.add("");
        }
        if (limit == 0) {
            int i = list.size() - 1;
            while (i >= 0 && list.get(i).isEmpty()) {
                list.remove(i);
                i--;
            }
        }
        return list.toArray(new String[list.size()]);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:16.477 -0400", hash_original_field = "0BA7AB9BF46151E8C8BBE62F232D038C", hash_generated_field = "B2FC8B6E50D0FCFCC52E2829DE0BADB1")

    private static final String METACHARACTERS = "\\?*+[](){}^$.|";
}

