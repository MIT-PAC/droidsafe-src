package name.fraser.neil.plaintext;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class diff_match_patch {
    public float Diff_Timeout = 1.0f;
    public short Diff_EditCost = 4;
    public short Diff_DualThreshold = 32;
    public float Match_Threshold = 0.5f;
    public int Match_Distance = 1000;
    public float Patch_DeleteThreshold = 0.5f;
    public short Patch_Margin = 4;
    private int Match_MaxBits = 32;
    private Pattern BLANKLINEEND
      = Pattern.compile("\\n\\r?\\n\\Z", Pattern.DOTALL);
    private Pattern BLANKLINESTART
      = Pattern.compile("\\A\\r?\\n\\r?\\n", Pattern.DOTALL);
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:17.875 -0400", hash_original_method = "3FBEE65D3976CDAD9D2AA0C339F40C75", hash_generated_method = "5C19C2C2383ACF8D6B68011275A31075")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList<Diff> diff_main(String text1, String text2) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        LinkedList<Diff> var6E8A0ACD54FEE8CF0271AC2AC14B5132_530994064 = (diff_main(text1, text2, true));
        return (LinkedList<Diff>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return diff_main(text1, text2, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:17.917 -0400", hash_original_method = "8FBE4B2E4558C372C321E27C87641091", hash_generated_method = "C50A420AD73F1C8B68582D0C3EE0F9BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList<Diff> diff_main(String text1, String text2,
                                    boolean checklines) {
        dsTaint.addTaint(checklines);
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null inputs. (diff_main)");
        } //End block
        LinkedList<Diff> diffs;
        {
            boolean varD8C7A1BFB9D0AB6442F16C47E883C112_1086451014 = (text1.equals(text2));
            {
                diffs = new LinkedList<Diff>();
                diffs.add(new Diff(Operation.EQUAL, text1));
            } //End block
        } //End collapsed parenthetic
        int commonlength;
        commonlength = diff_commonPrefix(text1, text2);
        String commonprefix;
        commonprefix = text1.substring(0, commonlength);
        text1 = text1.substring(commonlength);
        text2 = text2.substring(commonlength);
        commonlength = diff_commonSuffix(text1, text2);
        String commonsuffix;
        commonsuffix = text1.substring(text1.length() - commonlength);
        text1 = text1.substring(0, text1.length() - commonlength);
        text2 = text2.substring(0, text2.length() - commonlength);
        diffs = diff_compute(text1, text2, checklines);
        {
            boolean var8E52244FF7265786864E3491497D645D_1842065392 = (commonprefix.length() != 0);
            {
                diffs.addFirst(new Diff(Operation.EQUAL, commonprefix));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varD1A8409C0B8213562507434EBF284141_1330623249 = (commonsuffix.length() != 0);
            {
                diffs.addLast(new Diff(Operation.EQUAL, commonsuffix));
            } //End block
        } //End collapsed parenthetic
        diff_cleanupMerge(diffs);
        return (LinkedList<Diff>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.038 -0400", hash_original_method = "D06BA232AE46A51C372F8BC43BE189A5", hash_generated_method = "1903D1AC25185448A3EE6889B023CEB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected LinkedList<Diff> diff_compute(String text1, String text2,
                                          boolean checklines) {
        dsTaint.addTaint(checklines);
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        LinkedList<Diff> diffs;
        diffs = new LinkedList<Diff>();
        {
            boolean varB44CE29DF3FABC08659B2F4E809D2A63_513641529 = (text1.length() == 0);
            {
                diffs.add(new Diff(Operation.INSERT, text2));
            } //End block
        } //End collapsed parenthetic
        {
            boolean varB33399A4740E9EEE941C980DC0C93602_950100136 = (text2.length() == 0);
            {
                diffs.add(new Diff(Operation.DELETE, text1));
            } //End block
        } //End collapsed parenthetic
        String longtext;
        boolean varE89B379E1762A94D3CBEC99085C4065A_29015914 = (text1.length() > text2.length());
        longtext = text1;
        longtext = text2;
        String shorttext;
        boolean varE89B379E1762A94D3CBEC99085C4065A_2135634889 = (text1.length() > text2.length());
        shorttext = text2;
        shorttext = text1;
        int i;
        i = longtext.indexOf(shorttext);
        {
            Operation op;
            boolean var0A1C364AF0E93BC916E7F83D50409E7E_1107965427 = ((text1.length() > text2.length()));
            op = Operation.DELETE;
            op = Operation.INSERT;
            diffs.add(new Diff(op, longtext.substring(0, i)));
            diffs.add(new Diff(Operation.EQUAL, shorttext));
            diffs.add(new Diff(op, longtext.substring(i + shorttext.length())));
        } //End block
        longtext = shorttext = null;
        String[] hm;
        hm = diff_halfMatch(text1, text2);
        {
            String text1_a;
            text1_a = hm[0];
            String text1_b;
            text1_b = hm[1];
            String text2_a;
            text2_a = hm[2];
            String text2_b;
            text2_b = hm[3];
            String mid_common;
            mid_common = hm[4];
            LinkedList<Diff> diffs_a;
            diffs_a = diff_main(text1_a, text2_a, checklines);
            LinkedList<Diff> diffs_b;
            diffs_b = diff_main(text1_b, text2_b, checklines);
            diffs = diffs_a;
            diffs.add(new Diff(Operation.EQUAL, mid_common));
            diffs.addAll(diffs_b);
        } //End block
        {
            boolean var16F5F9E84A35CD62FBC922B52DAE607B_333281048 = (checklines && (text1.length() < 100 || text2.length() < 100));
            {
                checklines = false;
            } //End block
        } //End collapsed parenthetic
        List<String> linearray;
        linearray = null;
        {
            LinesToCharsResult b;
            b = diff_linesToChars(text1, text2);
            text1 = b.chars1;
            text2 = b.chars2;
            linearray = b.lineArray;
        } //End block
        diffs = diff_map(text1, text2);
        {
            diffs = new LinkedList<Diff>();
            diffs.add(new Diff(Operation.DELETE, text1));
            diffs.add(new Diff(Operation.INSERT, text2));
        } //End block
        {
            diff_charsToLines(diffs, linearray);
            diff_cleanupSemantic(diffs);
            diffs.add(new Diff(Operation.EQUAL, ""));
            int count_delete;
            count_delete = 0;
            int count_insert;
            count_insert = 0;
            String text_delete;
            text_delete = "";
            String text_insert;
            text_insert = "";
            ListIterator<Diff> pointer;
            pointer = diffs.listIterator();
            Diff thisDiff;
            thisDiff = pointer.next();
            {
                //Begin case INSERT 
                count_insert++;
                //End case INSERT 
                //Begin case INSERT 
                text_insert += thisDiff.text;
                //End case INSERT 
                //Begin case DELETE 
                count_delete++;
                //End case DELETE 
                //Begin case DELETE 
                text_delete += thisDiff.text;
                //End case DELETE 
                //Begin case EQUAL 
                {
                    pointer.previous();
                    {
                        int j;
                        j = 0;
                        {
                            pointer.previous();
                            pointer.remove();
                        } //End block
                    } //End collapsed parenthetic
                    {
                        Iterator<Diff> var4F98804F17B044F9EB29448C3D580944_1394698419 = diff_main(text_delete, text_insert, false).iterator();
                        var4F98804F17B044F9EB29448C3D580944_1394698419.hasNext();
                        Diff newDiff = var4F98804F17B044F9EB29448C3D580944_1394698419.next();
                        {
                            pointer.add(newDiff);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                //End case EQUAL 
                //Begin case EQUAL 
                count_insert = 0;
                //End case EQUAL 
                //Begin case EQUAL 
                count_delete = 0;
                //End case EQUAL 
                //Begin case EQUAL 
                text_delete = "";
                //End case EQUAL 
                //Begin case EQUAL 
                text_insert = "";
                //End case EQUAL 
                thisDiff = pointer.hasNext() ? pointer.next() : null;
            } //End block
            diffs.removeLast();
        } //End block
        return (LinkedList<Diff>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.079 -0400", hash_original_method = "B67FA82BD8DE9574A1382C963B4DCDED", hash_generated_method = "E5ED07EC222AFB98FC9128A2C1EEA25D")
    @DSModeled(DSC.SAFE)
    protected LinesToCharsResult diff_linesToChars(String text1, String text2) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        List<String> lineArray;
        lineArray = new ArrayList<String>();
        Map<String, Integer> lineHash;
        lineHash = new HashMap<String, Integer>();
        lineArray.add("");
        String chars1;
        chars1 = diff_linesToCharsMunge(text1, lineArray, lineHash);
        String chars2;
        chars2 = diff_linesToCharsMunge(text2, lineArray, lineHash);
        return (LinesToCharsResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //List<String> lineArray = new ArrayList<String>();
        //Map<String, Integer> lineHash = new HashMap<String, Integer>();
        //lineArray.add("");
        //String chars1 = diff_linesToCharsMunge(text1, lineArray, lineHash);
        //String chars2 = diff_linesToCharsMunge(text2, lineArray, lineHash);
        //return new LinesToCharsResult(chars1, chars2, lineArray);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.098 -0400", hash_original_method = "A9CF6DEBC8B7AAF43C09B9AB9052527C", hash_generated_method = "2F48F48F1EE70EF88EA10CB5C9D4EF25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String diff_linesToCharsMunge(String text, List<String> lineArray,
                                        Map<String, Integer> lineHash) {
        dsTaint.addTaint(lineArray.dsTaint);
        dsTaint.addTaint(lineHash.dsTaint);
        dsTaint.addTaint(text);
        int lineStart;
        lineStart = 0;
        int lineEnd;
        lineEnd = -1;
        String line;
        StringBuilder chars;
        chars = new StringBuilder();
        {
            boolean varC75F0547CA31AB4BD30CFB0CB2E2BEC6_5917410 = (lineEnd < text.length() - 1);
            {
                lineEnd = text.indexOf('\n', lineStart);
                {
                    lineEnd = text.length() - 1;
                } //End block
                line = text.substring(lineStart, lineEnd + 1);
                lineStart = lineEnd + 1;
                {
                    boolean var92D12001E3555E147F2CC80C0578F649_622777743 = (lineHash.containsKey(line));
                    {
                        chars.append(String.valueOf((char) (int) lineHash.get(line)));
                    } //End block
                    {
                        lineArray.add(line);
                        lineHash.put(line, lineArray.size() - 1);
                        chars.append(String.valueOf((char) (lineArray.size() - 1)));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String varC71C8BC322D4AF137E25E95C750F1092_582984092 = (chars.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //int lineStart = 0;
        //int lineEnd = -1;
        //String line;
        //StringBuilder chars = new StringBuilder();
        //while (lineEnd < text.length() - 1) {
      //lineEnd = text.indexOf('\n', lineStart);
      //if (lineEnd == -1) {
        //lineEnd = text.length() - 1;
      //}
      //line = text.substring(lineStart, lineEnd + 1);
      //lineStart = lineEnd + 1;
      //if (lineHash.containsKey(line)) {
        //chars.append(String.valueOf((char) (int) lineHash.get(line)));
      //} else {
        //lineArray.add(line);
        //lineHash.put(line, lineArray.size() - 1);
        //chars.append(String.valueOf((char) (lineArray.size() - 1)));
      //}
    //}
        //return chars.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.128 -0400", hash_original_method = "0134B4718389EE69F245DF93B6C29F80", hash_generated_method = "465881B44A07E2A41CDDF7733FFF42F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void diff_charsToLines(LinkedList<Diff> diffs,
                                  List<String> lineArray) {
        dsTaint.addTaint(lineArray.dsTaint);
        dsTaint.addTaint(diffs.dsTaint);
        StringBuilder text;
        {
            Iterator<Diff> varCD965572D66C9868C4A36AEF2DE7EB76_1246367773 = diffs.iterator();
            varCD965572D66C9868C4A36AEF2DE7EB76_1246367773.hasNext();
            Diff diff = varCD965572D66C9868C4A36AEF2DE7EB76_1246367773.next();
            {
                text = new StringBuilder();
                {
                    int y;
                    y = 0;
                    boolean varEF9EEAB9CBF6024B05820C46AF057423_1817709983 = (y < diff.text.length());
                    {
                        text.append(lineArray.get(diff.text.charAt(y)));
                    } //End block
                } //End collapsed parenthetic
                diff.text = text.toString();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //StringBuilder text;
        //for (Diff diff : diffs) {
      //text = new StringBuilder();
      //for (int y = 0; y < diff.text.length(); y++) {
        //text.append(lineArray.get(diff.text.charAt(y)));
      //}
      //diff.text = text.toString();
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.231 -0400", hash_original_method = "997AABA73F1BB2C882FEEED026037CE5", hash_generated_method = "EC1DCD5882820B23BEFD2B647F85A428")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected LinkedList<Diff> diff_map(String text1, String text2) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        long ms_end;
        ms_end = System.currentTimeMillis() + (long) (Diff_Timeout * 1000);
        int text1_length;
        text1_length = text1.length();
        int text2_length;
        text2_length = text2.length();
        int max_d;
        max_d = text1_length + text2_length - 1;
        boolean doubleEnd;
        doubleEnd = Diff_DualThreshold * 2 < max_d;
        List<Set<Long>> v_map1;
        v_map1 = new ArrayList<Set<Long>>();
        List<Set<Long>> v_map2;
        v_map2 = new ArrayList<Set<Long>>();
        Map<Integer, Integer> v1;
        v1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> v2;
        v2 = new HashMap<Integer, Integer>();
        v1.put(1, 0);
        v2.put(1, 0);
        int x, y;
        Long footstep;
        footstep = 0L;
        Map<Long, Integer> footsteps;
        footsteps = new HashMap<Long, Integer>();
        boolean done;
        done = false;
        boolean front;
        front = ((text1_length + text2_length) % 2 == 1);
        {
            int d;
            d = 0;
            {
                {
                    boolean var995802023594860C0C2BD091BB060144_38465189 = (Diff_Timeout > 0 && System.currentTimeMillis() > ms_end);
                } //End collapsed parenthetic
                v_map1.add(new HashSet<Long>());
                {
                    int k;
                    k = -d;
                    k += 2;
                    {
                        {
                            boolean var9730ED96DB077748122D5FA8CA09CE7F_750690693 = (k == -d || k != d && v1.get(k - 1) < v1.get(k + 1));
                            {
                                x = v1.get(k + 1);
                            } //End block
                            {
                                x = v1.get(k - 1) + 1;
                            } //End block
                        } //End collapsed parenthetic
                        y = x - k;
                        {
                            footstep = diff_footprint(x, y);
                            {
                                boolean varF5D54DBAC97E180BEF55E43476900221_994468406 = (front && (footsteps.containsKey(footstep)));
                                {
                                    done = true;
                                } //End block
                            } //End collapsed parenthetic
                            {
                                footsteps.put(footstep, d);
                            } //End block
                        } //End block
                        {
                            boolean varF6E3550C03EE8B3722C22DA811793B57_214141570 = (!done && x < text1_length && y < text2_length
               && text1.charAt(x) == text2.charAt(y));
                            {
                                x++;
                                y++;
                                {
                                    footstep = diff_footprint(x, y);
                                    {
                                        boolean var5338EA92B1E4AE97C39E9DC049369ABC_890958281 = (front && (footsteps.containsKey(footstep)));
                                        {
                                            done = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        footsteps.put(footstep, d);
                                    } //End block
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        v1.put(k, x);
                        v_map1.get(d).add(diff_footprint(x, y));
                        {
                            LinkedList<Diff> var7872EE798D70CD583CD4F6B7F8C77C75_898060803 = (diff_path1(v_map1, text1, text2));
                        } //End block
                        {
                            v_map2 = v_map2.subList(0, footsteps.get(footstep) + 1);
                            LinkedList<Diff> a;
                            a = diff_path1(v_map1, text1.substring(0, x),
                                          text2.substring(0, y));
                            a.addAll(diff_path2(v_map2, text1.substring(x), text2.substring(y)));
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    v_map2.add(new HashSet<Long>());
                    {
                        int k;
                        k = -d;
                        k += 2;
                        {
                            {
                                boolean var20C516C5DC0B19C0F0AF9D7AF12F39E2_1754094692 = (k == -d || k != d && v2.get(k - 1) < v2.get(k + 1));
                                {
                                    x = v2.get(k + 1);
                                } //End block
                                {
                                    x = v2.get(k - 1) + 1;
                                } //End block
                            } //End collapsed parenthetic
                            y = x - k;
                            footstep = diff_footprint(text1_length - x, text2_length - y);
                            {
                                boolean varCD784F018F43A52DFFAA2EF21C20ACC3_1454291204 = (!front && (footsteps.containsKey(footstep)));
                                {
                                    done = true;
                                } //End block
                            } //End collapsed parenthetic
                            {
                                footsteps.put(footstep, d);
                            } //End block
                            {
                                boolean var87B9238ED9AF155D7A1191C8371B1537_1362112811 = (!done && x < text1_length && y < text2_length
                 && text1.charAt(text1_length - x - 1)
                 == text2.charAt(text2_length - y - 1));
                                {
                                    x++;
                                    y++;
                                    footstep = diff_footprint(text1_length - x, text2_length - y);
                                    {
                                        boolean var637D8295C49FD86D744B0A85EBADE7EF_291229175 = (!front && (footsteps.containsKey(footstep)));
                                        {
                                            done = true;
                                        } //End block
                                    } //End collapsed parenthetic
                                    {
                                        footsteps.put(footstep, d);
                                    } //End block
                                } //End block
                            } //End collapsed parenthetic
                            v2.put(k, x);
                            v_map2.get(d).add(diff_footprint(x, y));
                            {
                                v_map1 = v_map1.subList(0, footsteps.get(footstep) + 1);
                                LinkedList<Diff> a;
                                a = diff_path1(v_map1, text1.substring(0, text1_length - x),
                             text2.substring(0, text2_length - y));
                                a.addAll(diff_path2(v_map2, text1.substring(text1_length - x),
                                text2.substring(text2_length - y)));
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (LinkedList<Diff>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.260 -0400", hash_original_method = "31DE4C7678259A470823CA413D18BBB6", hash_generated_method = "4312805FDAEA395ED7C3918A8507FBCC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected LinkedList<Diff> diff_path1(List<Set<Long>> v_map,
                                        String text1, String text2) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        dsTaint.addTaint(v_map.dsTaint);
        LinkedList<Diff> path;
        path = new LinkedList<Diff>();
        int x;
        x = text1.length();
        int y;
        y = text2.length();
        Operation last_op;
        last_op = null;
        {
            int d;
            d = v_map.size() - 2;
            {
                {
                    {
                        boolean varB96EDCF877AF5F94E7F5BC3D9A15E3D9_1573690076 = (v_map.get(d).contains(diff_footprint(x - 1, y)));
                        {
                            x--;
                            {
                                path.getFirst().text = text1.charAt(x) + path.getFirst().text;
                            } //End block
                            {
                                path.addFirst(new Diff(Operation.DELETE,
                                   text1.substring(x, x + 1)));
                            } //End block
                            last_op = Operation.DELETE;
                        } //End block
                        {
                            boolean var214B8D09CA6E91275983F6CBF6492583_342031881 = (v_map.get(d).contains(diff_footprint(x, y - 1)));
                            {
                                y--;
                                {
                                    path.getFirst().text = text2.charAt(y) + path.getFirst().text;
                                } //End block
                                {
                                    path.addFirst(new Diff(Operation.INSERT,
                                   text2.substring(y, y + 1)));
                                } //End block
                                last_op = Operation.INSERT;
                            } //End block
                            {
                                x--;
                                y--;
                                {
                                    path.getFirst().text = text1.charAt(x) + path.getFirst().text;
                                } //End block
                                {
                                    path.addFirst(new Diff(Operation.EQUAL, text1.substring(x, x + 1)));
                                } //End block
                                last_op = Operation.EQUAL;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (LinkedList<Diff>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.280 -0400", hash_original_method = "7D2CADA1A5A7743F739AEB62A4A2886D", hash_generated_method = "72551F597C8228DA5158E2425B8E1BC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected LinkedList<Diff> diff_path2(List<Set<Long>> v_map,
                                        String text1, String text2) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        dsTaint.addTaint(v_map.dsTaint);
        LinkedList<Diff> path;
        path = new LinkedList<Diff>();
        int x;
        x = text1.length();
        int y;
        y = text2.length();
        Operation last_op;
        last_op = null;
        {
            int d;
            d = v_map.size() - 2;
            {
                {
                    {
                        boolean varB96EDCF877AF5F94E7F5BC3D9A15E3D9_1085852860 = (v_map.get(d).contains(diff_footprint(x - 1, y)));
                        {
                            x--;
                            {
                                path.getLast().text += text1.charAt(text1.length() - x - 1);
                            } //End block
                            {
                                path.addLast(new Diff(Operation.DELETE,
                text1.substring(text1.length() - x - 1, text1.length() - x)));
                            } //End block
                            last_op = Operation.DELETE;
                        } //End block
                        {
                            boolean var214B8D09CA6E91275983F6CBF6492583_220847957 = (v_map.get(d).contains(diff_footprint(x, y - 1)));
                            {
                                y--;
                                {
                                    path.getLast().text += text2.charAt(text2.length() - y - 1);
                                } //End block
                                {
                                    path.addLast(new Diff(Operation.INSERT,
                text2.substring(text2.length() - y - 1, text2.length() - y)));
                                } //End block
                                last_op = Operation.INSERT;
                            } //End block
                            {
                                x--;
                                y--;
                                {
                                    path.getLast().text += text1.charAt(text1.length() - x - 1);
                                } //End block
                                {
                                    path.addLast(new Diff(Operation.EQUAL,
                text1.substring(text1.length() - x - 1, text1.length() - x)));
                                } //End block
                                last_op = Operation.EQUAL;
                            } //End block
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        return (LinkedList<Diff>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.289 -0400", hash_original_method = "2B8FA89BB3164F70673A506E6458CF64", hash_generated_method = "7763E2123B50FFE83305CEF86740EB73")
    @DSModeled(DSC.SAFE)
    protected long diff_footprint(int x, int y) {
        dsTaint.addTaint(y);
        dsTaint.addTaint(x);
        long result;
        result = x;
        result = result << 32;
        result += y;
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //long result = x;
        //result = result << 32;
        //result += y;
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.295 -0400", hash_original_method = "3D839AED69BF4CB09FF95E10DC29D096", hash_generated_method = "F90C1A9F388CB4429A31F086DE30F162")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int diff_commonPrefix(String text1, String text2) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        int n;
        n = Math.min(text1.length(), text2.length());
        {
            int i;
            i = 0;
            {
                {
                    boolean var0EAE26ED798DC7D82D637A2EFE7B7C78_633964477 = (text1.charAt(i) != text2.charAt(i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int n = Math.min(text1.length(), text2.length());
        //for (int i = 0; i < n; i++) {
      //if (text1.charAt(i) != text2.charAt(i)) {
        //return i;
      //}
    //}
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.306 -0400", hash_original_method = "EED6107065002B900E486121C96AE2CA", hash_generated_method = "79D59D2A4B8DCE920248F3AB60C554E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int diff_commonSuffix(String text1, String text2) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        int text1_length;
        text1_length = text1.length();
        int text2_length;
        text2_length = text2.length();
        int n;
        n = Math.min(text1_length, text2_length);
        {
            int i;
            i = 1;
            {
                {
                    boolean var4215945DB1A1223D984F1F494FA8A939_1655164193 = (text1.charAt(text1_length - i) != text2.charAt(text2_length - i));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int text1_length = text1.length();
        //int text2_length = text2.length();
        //int n = Math.min(text1_length, text2_length);
        //for (int i = 1; i <= n; i++) {
      //if (text1.charAt(text1_length - i) != text2.charAt(text2_length - i)) {
        //return i - 1;
      //}
    //}
        //return n;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.323 -0400", hash_original_method = "1C307DE358899D2C1FD1B4A2597C6FD9", hash_generated_method = "B2D771FD3E62EF34DD98456825A05F90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String[] diff_halfMatch(String text1, String text2) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        String longtext;
        boolean varE89B379E1762A94D3CBEC99085C4065A_165599320 = (text1.length() > text2.length());
        longtext = text1;
        longtext = text2;
        String shorttext;
        boolean varE89B379E1762A94D3CBEC99085C4065A_740766983 = (text1.length() > text2.length());
        shorttext = text2;
        shorttext = text1;
        {
            boolean var324AFFF5FBDB34F1CEFA2515C314BB1E_281377828 = (longtext.length() < 10 || shorttext.length() < 1);
        } //End collapsed parenthetic
        String[] hm1;
        hm1 = diff_halfMatchI(longtext, shorttext,
                                   (longtext.length() + 3) / 4);
        String[] hm2;
        hm2 = diff_halfMatchI(longtext, shorttext,
                                   (longtext.length() + 1) / 2);
        String[] hm;
        {
            hm = hm1;
        } //End block
        {
            hm = hm2;
        } //End block
        {
            hm = hm1[4].length() > hm2[4].length() ? hm1 : hm2;
        } //End block
        {
            boolean var8C3B298018B2DC9DE1DA4C4854A0256A_1596511036 = (text1.length() > text2.length());
        } //End collapsed parenthetic
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.334 -0400", hash_original_method = "743321482CABD9070456F47919D3DD24", hash_generated_method = "1D4C5A05C3B807B6EF241E290CCFD4CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String[] diff_halfMatchI(String longtext, String shorttext, int i) {
        dsTaint.addTaint(longtext);
        dsTaint.addTaint(shorttext);
        dsTaint.addTaint(i);
        String seed;
        seed = longtext.substring(i, i + longtext.length() / 4);
        int j;
        j = -1;
        String best_common;
        best_common = "";
        String best_longtext_a, best_longtext_b;
        best_longtext_a = "";
        best_longtext_b = "";
        String best_shorttext_a, best_shorttext_b;
        best_shorttext_a = "";
        best_shorttext_b = "";
        {
            boolean var0E1A2E774B8125A814CA4C3B56CD93A0_1207793107 = ((j = shorttext.indexOf(seed, j + 1)) != -1);
            {
                int prefixLength;
                prefixLength = diff_commonPrefix(longtext.substring(i),
                                           shorttext.substring(j));
                int suffixLength;
                suffixLength = diff_commonSuffix(longtext.substring(0, i),
                                           shorttext.substring(0, j));
                {
                    boolean varAF554230435547A68B2F3133CC7FE950_1974654325 = (best_common.length() < suffixLength + prefixLength);
                    {
                        best_common = shorttext.substring(j - suffixLength, j)
            + shorttext.substring(j, j + prefixLength);
                        best_longtext_a = longtext.substring(0, i - suffixLength);
                        best_longtext_b = longtext.substring(i + prefixLength);
                        best_shorttext_a = shorttext.substring(0, j - suffixLength);
                        best_shorttext_b = shorttext.substring(j + prefixLength);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var52DE37B8D2D3CFC29317BCF5546F544F_1166104920 = (best_common.length() >= longtext.length() / 2);
        } //End collapsed parenthetic
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.354 -0400", hash_original_method = "D4095F1E8F612ACE81E52A0C4535016D", hash_generated_method = "ADFE78ACEE8E77F72AD1E2CCD05173D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void diff_cleanupSemantic(LinkedList<Diff> diffs) {
        dsTaint.addTaint(diffs.dsTaint);
        {
            boolean varF246F7F9C176B01FF8ABA6166E76746A_1667928365 = (diffs.isEmpty());
        } //End collapsed parenthetic
        boolean changes;
        changes = false;
        Stack<Diff> equalities;
        equalities = new Stack<Diff>();
        String lastequality;
        lastequality = null;
        ListIterator<Diff> pointer;
        pointer = diffs.listIterator();
        int length_changes1;
        length_changes1 = 0;
        int length_changes2;
        length_changes2 = 0;
        Diff thisDiff;
        thisDiff = pointer.next();
        {
            {
                equalities.push(thisDiff);
                length_changes1 = length_changes2;
                length_changes2 = 0;
                lastequality = thisDiff.text;
            } //End block
            {
                length_changes2 += thisDiff.text.length();
                {
                    boolean var61142E37A090FAB3FF54428185A374CE_85851192 = (lastequality != null && (lastequality.length() <= length_changes1)
            && (lastequality.length() <= length_changes2));
                    {
                        {
                            boolean var6C5F9A842A77FD8E03431967924C796A_254311540 = (thisDiff != equalities.lastElement());
                            {
                                thisDiff = pointer.previous();
                            } //End block
                        } //End collapsed parenthetic
                        pointer.next();
                        pointer.set(new Diff(Operation.DELETE, lastequality));
                        pointer.add(new Diff(Operation.INSERT, lastequality));
                        equalities.pop();
                        {
                            boolean var82C61D3A3960535FCB652F17DAA481B9_2039193876 = (!equalities.empty());
                            {
                                equalities.pop();
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean varA806DF8E8F5AE2AAFD77D144CC6A6811_441671200 = (equalities.empty());
                            {
                                {
                                    boolean varD3D261E3D1D3EA56B32E251BE66E4572_1502473505 = (pointer.hasPrevious());
                                    {
                                        pointer.previous();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                thisDiff = equalities.lastElement();
                                {
                                    boolean var838391B8A39EF6C1060EE353293B32CC_1466882844 = (thisDiff != pointer.previous());
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                        length_changes1 = 0;
                        length_changes2 = 0;
                        lastequality = null;
                        changes = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            thisDiff = pointer.hasNext() ? pointer.next() : null;
        } //End block
        {
            diff_cleanupMerge(diffs);
        } //End block
        diff_cleanupSemanticLossless(diffs);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.402 -0400", hash_original_method = "765F934243A78E6796FE7FE35BC2CA98", hash_generated_method = "E798C648F037239BC347533010C2C195")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void diff_cleanupSemanticLossless(LinkedList<Diff> diffs) {
        dsTaint.addTaint(diffs.dsTaint);
        String equality1, edit, equality2;
        String commonString;
        int commonOffset;
        int score, bestScore;
        String bestEquality1, bestEdit, bestEquality2;
        ListIterator<Diff> pointer;
        pointer = diffs.listIterator();
        Diff prevDiff;
        boolean varB513C9F10892B7B8D18EC87AE00530C0_205188979 = (pointer.hasNext());
        prevDiff = pointer.next();
        prevDiff = null;
        Diff thisDiff;
        boolean varB513C9F10892B7B8D18EC87AE00530C0_1448126555 = (pointer.hasNext());
        thisDiff = pointer.next();
        thisDiff = null;
        Diff nextDiff;
        boolean varB513C9F10892B7B8D18EC87AE00530C0_2099930469 = (pointer.hasNext());
        nextDiff = pointer.next();
        nextDiff = null;
        {
            {
                equality1 = prevDiff.text;
                edit = thisDiff.text;
                equality2 = nextDiff.text;
                commonOffset = diff_commonSuffix(equality1, edit);
                {
                    commonString = edit.substring(edit.length() - commonOffset);
                    equality1 = equality1.substring(0, equality1.length() - commonOffset);
                    edit = commonString + edit.substring(0, edit.length() - commonOffset);
                    equality2 = commonString + equality2;
                } //End block
                bestEquality1 = equality1;
                bestEdit = edit;
                bestEquality2 = equality2;
                bestScore = diff_cleanupSemanticScore(equality1, edit)
            + diff_cleanupSemanticScore(edit, equality2);
                {
                    boolean varB1816DE50CF645996BCBE58604E6EFA9_1470609312 = (edit.length() != 0 && equality2.length() != 0
            && edit.charAt(0) == equality2.charAt(0));
                    {
                        equality1 += edit.charAt(0);
                        edit = edit.substring(1) + equality2.charAt(0);
                        equality2 = equality2.substring(1);
                        score = diff_cleanupSemanticScore(equality1, edit)
              + diff_cleanupSemanticScore(edit, equality2);
                        {
                            bestScore = score;
                            bestEquality1 = equality1;
                            bestEdit = edit;
                            bestEquality2 = equality2;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var5435FDC195DE318254A83CD0FB2709D5_1871272367 = (!prevDiff.text.equals(bestEquality1));
                    {
                        {
                            boolean varBAE2EC9711BDC4805B703A000DFFA706_290496886 = (bestEquality1.length() != 0);
                            {
                                prevDiff.text = bestEquality1;
                            } //End block
                            {
                                pointer.previous();
                                pointer.previous();
                                pointer.previous();
                                pointer.remove();
                                pointer.next();
                                pointer.next();
                            } //End block
                        } //End collapsed parenthetic
                        thisDiff.text = bestEdit;
                        {
                            boolean varA0CFFDBFB642E241779A4723A8582D2C_551019068 = (bestEquality2.length() != 0);
                            {
                                nextDiff.text = bestEquality2;
                            } //End block
                            {
                                pointer.remove();
                                nextDiff = thisDiff;
                                thisDiff = prevDiff;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
            prevDiff = thisDiff;
            thisDiff = nextDiff;
            nextDiff = pointer.hasNext() ? pointer.next() : null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.415 -0400", hash_original_method = "2DAA22FF9063DCA36B5382AECAB9DE24", hash_generated_method = "5190277786657FBDB72627476421628F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int diff_cleanupSemanticScore(String one, String two) {
        dsTaint.addTaint(two);
        dsTaint.addTaint(one);
        {
            boolean var669F29933576574366755EF816E69460_588028477 = (one.length() == 0 || two.length() == 0);
        } //End collapsed parenthetic
        int score;
        score = 0;
        {
            boolean var6172BC54E0A965D0292EA8846B5D82DA_363182207 = (!Character.isLetterOrDigit(one.charAt(one.length() - 1))
        || !Character.isLetterOrDigit(two.charAt(0)));
            {
                score++;
                {
                    boolean var94E6181FA3966551FAAE0D9ADB99F068_1077996198 = (Character.isWhitespace(one.charAt(one.length() - 1))
          || Character.isWhitespace(two.charAt(0)));
                    {
                        score++;
                        {
                            boolean var6980AACBF49E4A322A03828E6E4FFF43_798605028 = (Character.getType(one.charAt(one.length() - 1)) == Character.CONTROL
            || Character.getType(two.charAt(0)) == Character.CONTROL);
                            {
                                score++;
                                {
                                    boolean varF2BBE281DE0B147BD9BFB5107AD0367C_821561327 = (BLANKLINEEND.matcher(one).find()
              || BLANKLINESTART.matcher(two).find());
                                    {
                                        score++;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (one.length() == 0 || two.length() == 0) {
      //return 5;
    //}
        //int score = 0;
        //if (!Character.isLetterOrDigit(one.charAt(one.length() - 1))
        //|| !Character.isLetterOrDigit(two.charAt(0))) {
      //score++;
      //if (Character.isWhitespace(one.charAt(one.length() - 1))
          //|| Character.isWhitespace(two.charAt(0))) {
        //score++;
        //if (Character.getType(one.charAt(one.length() - 1)) == Character.CONTROL
            //|| Character.getType(two.charAt(0)) == Character.CONTROL) {
          //score++;
          //if (BLANKLINEEND.matcher(one).find()
              //|| BLANKLINESTART.matcher(two).find()) {
            //score++;
          //}
        //}
      //}
    //}
        //return score;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.439 -0400", hash_original_method = "4B815037F1C721195BE725DFE807B46A", hash_generated_method = "4850C36F2D2A1F43CB1D1F470904E3C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void diff_cleanupEfficiency(LinkedList<Diff> diffs) {
        dsTaint.addTaint(diffs.dsTaint);
        {
            boolean varF246F7F9C176B01FF8ABA6166E76746A_206441071 = (diffs.isEmpty());
        } //End collapsed parenthetic
        boolean changes;
        changes = false;
        Stack<Diff> equalities;
        equalities = new Stack<Diff>();
        String lastequality;
        lastequality = null;
        ListIterator<Diff> pointer;
        pointer = diffs.listIterator();
        boolean pre_ins;
        pre_ins = false;
        boolean pre_del;
        pre_del = false;
        boolean post_ins;
        post_ins = false;
        boolean post_del;
        post_del = false;
        Diff thisDiff;
        thisDiff = pointer.next();
        Diff safeDiff;
        safeDiff = thisDiff;
        {
            {
                {
                    boolean var68600118AA27D84A84038515916CA3BA_1997052741 = (thisDiff.text.length() < Diff_EditCost && (post_ins || post_del));
                    {
                        equalities.push(thisDiff);
                        pre_ins = post_ins;
                        pre_del = post_del;
                        lastequality = thisDiff.text;
                    } //End block
                    {
                        equalities.clear();
                        lastequality = null;
                        safeDiff = thisDiff;
                    } //End block
                } //End collapsed parenthetic
                post_ins = post_del = false;
            } //End block
            {
                {
                    post_del = true;
                } //End block
                {
                    post_ins = true;
                } //End block
                {
                    boolean var0EFD982BF62A4CB559BF2A3A923F2A51_411520151 = (lastequality != null
            && ((pre_ins && pre_del && post_ins && post_del)
                || ((lastequality.length() < Diff_EditCost / 2)
                    && ((pre_ins ? 1 : 0) + (pre_del ? 1 : 0)
                        + (post_ins ? 1 : 0) + (post_del ? 1 : 0)) == 3))); //DSFIXME:  CODE0008: Nested ternary operator in expression
                    {
                        {
                            boolean var6C5F9A842A77FD8E03431967924C796A_102942137 = (thisDiff != equalities.lastElement());
                            {
                                thisDiff = pointer.previous();
                            } //End block
                        } //End collapsed parenthetic
                        pointer.next();
                        pointer.set(new Diff(Operation.DELETE, lastequality));
                        pointer.add(thisDiff = new Diff(Operation.INSERT, lastequality));
                        equalities.pop();
                        lastequality = null;
                        {
                            post_ins = post_del = true;
                            equalities.clear();
                            safeDiff = thisDiff;
                        } //End block
                        {
                            {
                                boolean varFF209E3495789E0C18BD706AB2F6E675_863233730 = (!equalities.empty());
                                {
                                    equalities.pop();
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean var5E01EC3414DFA609A27B2C73663AF8B2_1842097621 = (equalities.empty());
                                {
                                    thisDiff = safeDiff;
                                } //End block
                                {
                                    thisDiff = equalities.lastElement();
                                } //End block
                            } //End collapsed parenthetic
                            {
                                boolean varBE1A443CDEF497F831CF29E88AA40622_1785761606 = (thisDiff != pointer.previous());
                            } //End collapsed parenthetic
                            post_ins = post_del = false;
                        } //End block
                        changes = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            thisDiff = pointer.hasNext() ? pointer.next() : null;
        } //End block
        {
            diff_cleanupMerge(diffs);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.471 -0400", hash_original_method = "DFCA75AC283AA46C59C0B14469074E27", hash_generated_method = "F1733EE189A672A07456DDBBD1E7F4BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void diff_cleanupMerge(LinkedList<Diff> diffs) {
        dsTaint.addTaint(diffs.dsTaint);
        diffs.add(new Diff(Operation.EQUAL, ""));
        ListIterator<Diff> pointer;
        pointer = diffs.listIterator();
        int count_delete;
        count_delete = 0;
        int count_insert;
        count_insert = 0;
        String text_delete;
        text_delete = "";
        String text_insert;
        text_insert = "";
        Diff thisDiff;
        thisDiff = pointer.next();
        Diff prevEqual;
        prevEqual = null;
        int commonlength;
        {
            //Begin case INSERT 
            count_insert++;
            //End case INSERT 
            //Begin case INSERT 
            text_insert += thisDiff.text;
            //End case INSERT 
            //Begin case INSERT 
            prevEqual = null;
            //End case INSERT 
            //Begin case DELETE 
            count_delete++;
            //End case DELETE 
            //Begin case DELETE 
            text_delete += thisDiff.text;
            //End case DELETE 
            //Begin case DELETE 
            prevEqual = null;
            //End case DELETE 
            //Begin case EQUAL 
            {
                pointer.previous();
                {
                    pointer.previous();
                    pointer.remove();
                } //End block
                {
                    pointer.previous();
                    pointer.remove();
                } //End block
                {
                    commonlength = diff_commonPrefix(text_insert, text_delete);
                    {
                        {
                            boolean varFED8A80049E21874FDFAA6699B6813B3_919376399 = (pointer.hasPrevious());
                            {
                                thisDiff = pointer.previous();
                                thisDiff.text += text_insert.substring(0, commonlength);
                                pointer.next();
                            } //End block
                            {
                                pointer.add(new Diff(Operation.EQUAL,
                    text_insert.substring(0, commonlength)));
                            } //End block
                        } //End collapsed parenthetic
                        text_insert = text_insert.substring(commonlength);
                        text_delete = text_delete.substring(commonlength);
                    } //End block
                    commonlength = diff_commonSuffix(text_insert, text_delete);
                    {
                        thisDiff = pointer.next();
                        thisDiff.text = text_insert.substring(text_insert.length()
                  - commonlength) + thisDiff.text;
                        text_insert = text_insert.substring(0, text_insert.length()
                  - commonlength);
                        text_delete = text_delete.substring(0, text_delete.length()
                  - commonlength);
                        pointer.previous();
                    } //End block
                } //End block
                {
                    boolean varAE8EB07F2D7D11185DBDEEB4967E15EE_1650218977 = (text_delete.length() != 0);
                    {
                        pointer.add(new Diff(Operation.DELETE, text_delete));
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var2FDD0B7A29B54C728ADB94563B37D560_224757031 = (text_insert.length() != 0);
                    {
                        pointer.add(new Diff(Operation.INSERT, text_insert));
                    } //End block
                } //End collapsed parenthetic
                thisDiff = pointer.hasNext() ? pointer.next() : null;
            } //End block
            {
                prevEqual.text += thisDiff.text;
                pointer.remove();
                thisDiff = pointer.previous();
                pointer.next();
            } //End block
            //End case EQUAL 
            //Begin case EQUAL 
            count_insert = 0;
            //End case EQUAL 
            //Begin case EQUAL 
            count_delete = 0;
            //End case EQUAL 
            //Begin case EQUAL 
            text_delete = "";
            //End case EQUAL 
            //Begin case EQUAL 
            text_insert = "";
            //End case EQUAL 
            //Begin case EQUAL 
            prevEqual = thisDiff;
            //End case EQUAL 
            thisDiff = pointer.hasNext() ? pointer.next() : null;
        } //End block
        {
            boolean var11D75DAC602CFED65FE73E4B9574D652_708436025 = (diffs.getLast().text.length() == 0);
            {
                diffs.removeLast();
            } //End block
        } //End collapsed parenthetic
        boolean changes;
        changes = false;
        pointer = diffs.listIterator();
        Diff prevDiff;
        boolean varB513C9F10892B7B8D18EC87AE00530C0_1689693525 = (pointer.hasNext());
        prevDiff = pointer.next();
        prevDiff = null;
        thisDiff = pointer.hasNext() ? pointer.next() : null;
        Diff nextDiff;
        boolean varB513C9F10892B7B8D18EC87AE00530C0_1493937222 = (pointer.hasNext());
        nextDiff = pointer.next();
        nextDiff = null;
        {
            {
                {
                    boolean var394FA64671F7F9A39F480DF02A6AD4B2_1398832626 = (thisDiff.text.endsWith(prevDiff.text));
                    {
                        thisDiff.text = prevDiff.text
              + thisDiff.text.substring(0, thisDiff.text.length()
                                           - prevDiff.text.length());
                        nextDiff.text = prevDiff.text + nextDiff.text;
                        pointer.previous();
                        pointer.previous();
                        pointer.previous();
                        pointer.remove();
                        pointer.next();
                        thisDiff = pointer.next();
                        nextDiff = pointer.hasNext() ? pointer.next() : null;
                        changes = true;
                    } //End block
                    {
                        boolean varE73CAB9C92745A5A22B7C649ED2ED4F6_759959462 = (thisDiff.text.startsWith(nextDiff.text));
                        {
                            prevDiff.text += nextDiff.text;
                            thisDiff.text = thisDiff.text.substring(nextDiff.text.length())
              + nextDiff.text;
                            pointer.remove();
                            nextDiff = pointer.hasNext() ? pointer.next() : null;
                            changes = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End block
            prevDiff = thisDiff;
            thisDiff = nextDiff;
            nextDiff = pointer.hasNext() ? pointer.next() : null;
        } //End block
        {
            diff_cleanupMerge(diffs);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.490 -0400", hash_original_method = "F3FBE0C400C9C1ADFC9B9F800BC22454", hash_generated_method = "CCB83B7AC68E1A047FD3639A87F55313")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int diff_xIndex(LinkedList<Diff> diffs, int loc) {
        dsTaint.addTaint(diffs.dsTaint);
        dsTaint.addTaint(loc);
        int chars1;
        chars1 = 0;
        int chars2;
        chars2 = 0;
        int last_chars1;
        last_chars1 = 0;
        int last_chars2;
        last_chars2 = 0;
        Diff lastDiff;
        lastDiff = null;
        {
            Iterator<Diff> varC49B2C4CCB217AA567229875D2D3FF54_1422190449 = diffs.iterator();
            varC49B2C4CCB217AA567229875D2D3FF54_1422190449.hasNext();
            Diff aDiff = varC49B2C4CCB217AA567229875D2D3FF54_1422190449.next();
            {
                {
                    chars1 += aDiff.text.length();
                } //End block
                {
                    chars2 += aDiff.text.length();
                } //End block
                {
                    lastDiff = aDiff;
                } //End block
                last_chars1 = chars1;
                last_chars2 = chars2;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int chars1 = 0;
        //int chars2 = 0;
        //int last_chars1 = 0;
        //int last_chars2 = 0;
        //Diff lastDiff = null;
        //for (Diff aDiff : diffs) {
      //if (aDiff.operation != Operation.INSERT) {
        //chars1 += aDiff.text.length();
      //}
      //if (aDiff.operation != Operation.DELETE) {
        //chars2 += aDiff.text.length();
      //}
      //if (chars1 > loc) {
        //lastDiff = aDiff;
        //break;
      //}
      //last_chars1 = chars1;
      //last_chars2 = chars2;
    //}
        //if (lastDiff != null && lastDiff.operation == Operation.DELETE) {
      //return last_chars2;
    //}
        //return last_chars2 + (loc - last_chars1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.501 -0400", hash_original_method = "2EBFA77F9BA2515ED1E8ED4C515A8090", hash_generated_method = "0AA8968394BC2079FB2E9EDCE0F52583")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String diff_prettyHtml(LinkedList<Diff> diffs) {
        dsTaint.addTaint(diffs.dsTaint);
        StringBuilder html;
        html = new StringBuilder();
        int i;
        i = 0;
        {
            Iterator<Diff> varC49B2C4CCB217AA567229875D2D3FF54_1306125412 = diffs.iterator();
            varC49B2C4CCB217AA567229875D2D3FF54_1306125412.hasNext();
            Diff aDiff = varC49B2C4CCB217AA567229875D2D3FF54_1306125412.next();
            {
                String text;
                text = aDiff.text.replace("&", "&amp;").replace("<", "&lt;")
          .replace(">", "&gt;").replace("\n", "&para;<BR>");
                //Begin case INSERT 
                html.append("<INS STYLE=\"background:#E6FFE6;\" TITLE=\"i=").append(i)
            .append("\">").append(text).append("</INS>");
                //End case INSERT 
                //Begin case DELETE 
                html.append("<DEL STYLE=\"background:#FFE6E6;\" TITLE=\"i=").append(i)
            .append("\">").append(text).append("</DEL>");
                //End case DELETE 
                //Begin case EQUAL 
                html.append("<SPAN TITLE=\"i=").append(i).append("\">").append(text)
            .append("</SPAN>");
                //End case EQUAL 
                {
                    i += aDiff.text.length();
                } //End block
            } //End block
        } //End collapsed parenthetic
        String var8193F61828E4186E5041F20E7074DDF7_723698064 = (html.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.507 -0400", hash_original_method = "21680ADAFF556201EC1C3E3D960BA356", hash_generated_method = "4903282A4DA320137226D556CDC9DC33")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String diff_text1(LinkedList<Diff> diffs) {
        dsTaint.addTaint(diffs.dsTaint);
        StringBuilder text;
        text = new StringBuilder();
        {
            Iterator<Diff> varC49B2C4CCB217AA567229875D2D3FF54_1964584928 = diffs.iterator();
            varC49B2C4CCB217AA567229875D2D3FF54_1964584928.hasNext();
            Diff aDiff = varC49B2C4CCB217AA567229875D2D3FF54_1964584928.next();
            {
                {
                    text.append(aDiff.text);
                } //End block
            } //End block
        } //End collapsed parenthetic
        String var26FF8C1159EFD8B2BDF89D74D54FC6D9_1263783683 = (text.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder text = new StringBuilder();
        //for (Diff aDiff : diffs) {
      //if (aDiff.operation != Operation.INSERT) {
        //text.append(aDiff.text);
      //}
    //}
        //return text.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.519 -0400", hash_original_method = "A7DE4B215B1CE82F3503352A8929AF12", hash_generated_method = "9732A3F7F8D04A95EEBB2B30883E1BEB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String diff_text2(LinkedList<Diff> diffs) {
        dsTaint.addTaint(diffs.dsTaint);
        StringBuilder text;
        text = new StringBuilder();
        {
            Iterator<Diff> varC49B2C4CCB217AA567229875D2D3FF54_1787717976 = diffs.iterator();
            varC49B2C4CCB217AA567229875D2D3FF54_1787717976.hasNext();
            Diff aDiff = varC49B2C4CCB217AA567229875D2D3FF54_1787717976.next();
            {
                {
                    text.append(aDiff.text);
                } //End block
            } //End block
        } //End collapsed parenthetic
        String var26FF8C1159EFD8B2BDF89D74D54FC6D9_1774150699 = (text.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder text = new StringBuilder();
        //for (Diff aDiff : diffs) {
      //if (aDiff.operation != Operation.DELETE) {
        //text.append(aDiff.text);
      //}
    //}
        //return text.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.528 -0400", hash_original_method = "85E25C3F93CC42796A440A66F29F7BA1", hash_generated_method = "505AB6D712686FCC44A47893191EEECD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int diff_levenshtein(LinkedList<Diff> diffs) {
        dsTaint.addTaint(diffs.dsTaint);
        int levenshtein;
        levenshtein = 0;
        int insertions;
        insertions = 0;
        int deletions;
        deletions = 0;
        {
            Iterator<Diff> varC49B2C4CCB217AA567229875D2D3FF54_576824376 = diffs.iterator();
            varC49B2C4CCB217AA567229875D2D3FF54_576824376.hasNext();
            Diff aDiff = varC49B2C4CCB217AA567229875D2D3FF54_576824376.next();
            {
                //Begin case INSERT 
                insertions += aDiff.text.length();
                //End case INSERT 
                //Begin case DELETE 
                deletions += aDiff.text.length();
                //End case DELETE 
                //Begin case EQUAL 
                levenshtein += Math.max(insertions, deletions);
                //End case EQUAL 
                //Begin case EQUAL 
                insertions = 0;
                //End case EQUAL 
                //Begin case EQUAL 
                deletions = 0;
                //End case EQUAL 
            } //End block
        } //End collapsed parenthetic
        levenshtein += Math.max(insertions, deletions);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int levenshtein = 0;
        //int insertions = 0;
        //int deletions = 0;
        //for (Diff aDiff : diffs) {
      //switch (aDiff.operation) {
      //case INSERT:
        //insertions += aDiff.text.length();
        //break;
      //case DELETE:
        //deletions += aDiff.text.length();
        //break;
      //case EQUAL:
        //levenshtein += Math.max(insertions, deletions);
        //insertions = 0;
        //deletions = 0;
        //break;
      //}
    //}
        //levenshtein += Math.max(insertions, deletions);
        //return levenshtein;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.538 -0400", hash_original_method = "A0C71F4FB342302F76C0959BE27E93BA", hash_generated_method = "1D6FD1BE35A750C0C503A43972CDDB24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String diff_toDelta(LinkedList<Diff> diffs) {
        dsTaint.addTaint(diffs.dsTaint);
        StringBuilder text;
        text = new StringBuilder();
        {
            Iterator<Diff> varC49B2C4CCB217AA567229875D2D3FF54_1997276892 = diffs.iterator();
            varC49B2C4CCB217AA567229875D2D3FF54_1997276892.hasNext();
            Diff aDiff = varC49B2C4CCB217AA567229875D2D3FF54_1997276892.next();
            {
                //Begin case INSERT 
                try 
                {
                    text.append("+").append(URLEncoder.encode(aDiff.text, "UTF-8")
                                            .replace('+', ' ')).append("\t");
                } //End block
                catch (UnsupportedEncodingException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw new Error("This system does not support UTF-8.", e);
                } //End block
                //End case INSERT 
                //Begin case DELETE 
                text.append("-").append(aDiff.text.length()).append("\t");
                //End case DELETE 
                //Begin case EQUAL 
                text.append("=").append(aDiff.text.length()).append("\t");
                //End case EQUAL 
            } //End block
        } //End collapsed parenthetic
        String delta;
        delta = text.toString();
        {
            boolean varAD8E080A58DBBFA6096053684BEE4496_1229137173 = (delta.length() != 0);
            {
                delta = delta.substring(0, delta.length() - 1);
                delta = unescapeForEncodeUriCompatability(delta);
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.553 -0400", hash_original_method = "0AFA525BD2A38AE17A6C45448D5456A1", hash_generated_method = "E06B3BFB1D912EA178FEBC2F401CE328")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList<Diff> diff_fromDelta(String text1, String delta) throws IllegalArgumentException {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(delta);
        LinkedList<Diff> diffs;
        diffs = new LinkedList<Diff>();
        int pointer;
        pointer = 0;
        String[] tokens;
        tokens = delta.split("\t");
        {
            String token = tokens[0];
            {
                {
                    boolean var3136725F845EC34B4B2B6B3D44F636AD_742878523 = (token.length() == 0);
                } //End collapsed parenthetic
                String param;
                param = token.substring(1);
                {
                    Object varDBC484706F5B11022D45141A1B41745F_2121982669 = (token.charAt(0));
                    //Begin case '+' 
                    param = param.replace("+", "%2B");
                    //End case '+' 
                    //Begin case '+' 
                    try 
                    {
                        param = URLDecoder.decode(param, "UTF-8");
                    } //End block
                    catch (UnsupportedEncodingException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new Error("This system does not support UTF-8.", e);
                    } //End block
                    catch (IllegalArgumentException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
              "Illegal escape in diff_fromDelta: " + param, e);
                    } //End block
                    //End case '+' 
                    //Begin case '+' 
                    diffs.add(new Diff(Operation.INSERT, param));
                    //End case '+' 
                    //Begin case '-' '=' 
                    int n = 0;
                    //End case '-' '=' 
                    //Begin case '-' '=' 
                    try 
                    {
                        n = Integer.parseInt(param);
                    } //End block
                    catch (NumberFormatException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
              "Invalid number in diff_fromDelta: " + param, e);
                    } //End block
                    //End case '-' '=' 
                    //Begin case '-' '=' 
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
              "Negative number in diff_fromDelta: " + param);
                    } //End block
                    //End case '-' '=' 
                    //Begin case '-' '=' 
                    String text = "";
                    //End case '-' '=' 
                    //Begin case '-' '=' 
                    try 
                    {
                        text = text1.substring(pointer, pointer += n);
                    } //End block
                    catch (StringIndexOutOfBoundsException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Delta length (" + pointer
              + ") larger than source text length (" + text1.length()
              + ").", e);
                    } //End block
                    //End case '-' '=' 
                    //Begin case '-' '=' 
                    {
                        boolean var933B05EF3FD1D77F1442BE7FB418A46D_173600154 = (token.charAt(0) == '=');
                        {
                            diffs.add(new Diff(Operation.EQUAL, text));
                        } //End block
                        {
                            diffs.add(new Diff(Operation.DELETE, text));
                        } //End block
                    } //End collapsed parenthetic
                    //End case '-' '=' 
                    //Begin case default 
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
            "Invalid diff operation in diff_fromDelta: " + token.charAt(0));
                    //End case default 
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5AB145CF7162A49F9907C927A872FEEE_1976702180 = (pointer != text1.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Delta length (" + pointer
          + ") smaller than source text length (" + text1.length() + ").");
            } //End block
        } //End collapsed parenthetic
        return (LinkedList<Diff>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.568 -0400", hash_original_method = "811332726DA1340DADD6009B13DAB8AE", hash_generated_method = "1C250A36EA3A33020720DA835B0606D1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int match_main(String text, String pattern, int loc) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(loc);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null inputs. (match_main)");
        } //End block
        loc = Math.max(0, Math.min(loc, text.length()));
        {
            boolean var2D9273593B189EF60055E1252399F32A_1089973563 = (text.equals(pattern));
            {
                boolean var35C21C9038896C5E663A57EA38CF0661_861677551 = (text.length() == 0);
                {
                    boolean var5B2C97A60357640F90AD843B67C5E583_407476063 = (loc + pattern.length() <= text.length()
        && text.substring(loc, loc + pattern.length()).equals(pattern));
                    {
                        int var958A53953F3BD4D5864140C6D977C04F_1741802135 = (match_bitap(text, pattern, loc));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (text == null || pattern == null) {
      //throw new IllegalArgumentException("Null inputs. (match_main)");
    //}
        //loc = Math.max(0, Math.min(loc, text.length()));
        //if (text.equals(pattern)) {
      //return 0;
    //} else if (text.length() == 0) {
      //return -1;
    //} else if (loc + pattern.length() <= text.length()
        //&& text.substring(loc, loc + pattern.length()).equals(pattern)) {
      //return loc;
    //} else {
      //return match_bitap(text, pattern, loc);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.590 -0400", hash_original_method = "44C77007A30BDBB67DE5D5492BC9DE97", hash_generated_method = "7EA15D16BEE7A8910EFFA09516F6AF99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int match_bitap(String text, String pattern, int loc) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(loc);
        Map<Character, Integer> s;
        s = match_alphabet(pattern);
        double score_threshold;
        score_threshold = Match_Threshold;
        int best_loc;
        best_loc = text.indexOf(pattern, loc);
        {
            score_threshold = Math.min(match_bitapScore(0, best_loc, loc, pattern),
          score_threshold);
            best_loc = text.lastIndexOf(pattern, loc + pattern.length());
            {
                score_threshold = Math.min(match_bitapScore(0, best_loc, loc, pattern),
            score_threshold);
            } //End block
        } //End block
        int matchmask;
        matchmask = 1 << (pattern.length() - 1);
        best_loc = -1;
        int bin_min, bin_mid;
        int bin_max;
        bin_max = pattern.length() + text.length();
        int[] last_rd;
        last_rd = new int[0];
        {
            int d;
            d = 0;
            boolean var7800D45517E9090F024B338E002013FB_99668847 = (d < pattern.length());
            {
                bin_min = 0;
                bin_mid = bin_max;
                {
                    {
                        boolean var4A4E4728A4AF3F263E7F6690ED932D46_2118318001 = (match_bitapScore(d, loc + bin_mid, loc, pattern)
            <= score_threshold);
                        {
                            bin_min = bin_mid;
                        } //End block
                        {
                            bin_max = bin_mid;
                        } //End block
                    } //End collapsed parenthetic
                    bin_mid = (bin_max - bin_min) / 2 + bin_min;
                } //End block
                bin_max = bin_mid;
                int start;
                start = Math.max(1, loc - bin_mid + 1);
                int finish;
                finish = Math.min(loc + bin_mid, text.length()) + pattern.length();
                int[] rd;
                rd = new int[finish + 2];
                rd[finish + 1] = (1 << d) - 1;
                {
                    int j;
                    j = finish;
                    {
                        int charMatch;
                        {
                            boolean var5E34F6A32861978FF0C1C3E96F958B3C_410083681 = (text.length() <= j - 1 || !s.containsKey(text.charAt(j - 1)));
                            {
                                charMatch = 0;
                            } //End block
                            {
                                charMatch = s.get(text.charAt(j - 1));
                            } //End block
                        } //End collapsed parenthetic
                        {
                            rd[j] = ((rd[j + 1] << 1) | 1) & charMatch;
                        } //End block
                        {
                            rd[j] = ((rd[j + 1] << 1) | 1) & charMatch
              | (((last_rd[j + 1] | last_rd[j]) << 1) | 1) | last_rd[j + 1];
                        } //End block
                        {
                            double score;
                            score = match_bitapScore(d, j - 1, loc, pattern);
                            {
                                score_threshold = score;
                                best_loc = j - 1;
                                {
                                    start = Math.max(1, 2 * loc - best_loc);
                                } //End block
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    boolean var03FA84B9D899765067A95CC93AA4E455_722227298 = (match_bitapScore(d + 1, loc, loc, pattern) > score_threshold);
                } //End collapsed parenthetic
                last_rd = rd;
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.597 -0400", hash_original_method = "5436EA1458F5398F506608AA6066E11B", hash_generated_method = "BB265C2480BAB14A013B2213AA5945EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private double match_bitapScore(int e, int x, int loc, String pattern) {
        dsTaint.addTaint(e);
        dsTaint.addTaint(pattern);
        dsTaint.addTaint(loc);
        dsTaint.addTaint(x);
        float accuracy;
        accuracy = (float) e / pattern.length();
        int proximity;
        proximity = Math.abs(loc - x);
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //float accuracy = (float) e / pattern.length();
        //int proximity = Math.abs(loc - x);
        //if (Match_Distance == 0) {
      //return proximity == 0 ? accuracy : 1.0;
    //}
        //return accuracy + (proximity / (float) Match_Distance);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.603 -0400", hash_original_method = "160E75B902065730659AA35009742BF9", hash_generated_method = "C1681365693A2261D46DD048B46C157F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Map<Character, Integer> match_alphabet(String pattern) {
        dsTaint.addTaint(pattern);
        Map<Character, Integer> s;
        s = new HashMap<Character, Integer>();
        char[] char_pattern;
        char_pattern = pattern.toCharArray();
        {
            char c = char_pattern[0];
            {
                s.put(c, 0);
            } //End block
        } //End collapsed parenthetic
        int i;
        i = 0;
        {
            char c = char_pattern[0];
            {
                s.put(c, s.get(c) | (1 << (pattern.length() - i - 1)));
                i++;
            } //End block
        } //End collapsed parenthetic
        return (Map<Character, Integer>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Map<Character, Integer> s = new HashMap<Character, Integer>();
        //char[] char_pattern = pattern.toCharArray();
        //for (char c : char_pattern) {
      //s.put(c, 0);
    //}
        //int i = 0;
        //for (char c : char_pattern) {
      //s.put(c, s.get(c) | (1 << (pattern.length() - i - 1)));
      //i++;
    //}
        //return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.614 -0400", hash_original_method = "39F23DC9A313DA9D2049560A91A3CC03", hash_generated_method = "6C22EC42D1188F42DB0E2496BAC4F95E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void patch_addContext(Patch patch, String text) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(patch.dsTaint);
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_497465792 = (text.length() == 0);
        } //End collapsed parenthetic
        String pattern;
        pattern = text.substring(patch.start2, patch.start2 + patch.length1);
        int padding;
        padding = 0;
        {
            boolean var0A2AD9D16D3F944AA41BAB8ED0C761AA_1430443915 = (text.indexOf(pattern) != text.lastIndexOf(pattern)
        && pattern.length() < Match_MaxBits - Patch_Margin - Patch_Margin);
            {
                padding += Patch_Margin;
                pattern = text.substring(Math.max(0, patch.start2 - padding),
          Math.min(text.length(), patch.start2 + patch.length1 + padding));
            } //End block
        } //End collapsed parenthetic
        padding += Patch_Margin;
        String prefix;
        prefix = text.substring(Math.max(0, patch.start2 - padding),
        patch.start2);
        {
            boolean var7FB438EBE85562C58B9FA5942DC3BA8D_1110434197 = (prefix.length() != 0);
            {
                patch.diffs.addFirst(new Diff(Operation.EQUAL, prefix));
            } //End block
        } //End collapsed parenthetic
        String suffix;
        suffix = text.substring(patch.start2 + patch.length1,
        Math.min(text.length(), patch.start2 + patch.length1 + padding));
        {
            boolean var1B8A4828E2C005458E6EAC73537B7449_1950330765 = (suffix.length() != 0);
            {
                patch.diffs.addLast(new Diff(Operation.EQUAL, suffix));
            } //End block
        } //End collapsed parenthetic
        patch.start1 -= prefix.length();
        patch.start2 -= prefix.length();
        patch.length1 += prefix.length() + suffix.length();
        patch.length2 += prefix.length() + suffix.length();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.622 -0400", hash_original_method = "D220CDA8FF3845E5231F886385F393A0", hash_generated_method = "A9B55DCA9662843DDFD8C0ED3129F6E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList<Patch> patch_make(String text1, String text2) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null inputs. (patch_make)");
        } //End block
        LinkedList<Diff> diffs;
        diffs = diff_main(text1, text2, true);
        {
            boolean var2200DAFFF391E089762B425BC27B1677_223086935 = (diffs.size() > 2);
            {
                diff_cleanupSemantic(diffs);
                diff_cleanupEfficiency(diffs);
            } //End block
        } //End collapsed parenthetic
        LinkedList<Patch> var3E755C0FEF2947C27AF0258AC6040611_1212492610 = (patch_make(text1, diffs));
        return (LinkedList<Patch>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (text1 == null || text2 == null) {
      //throw new IllegalArgumentException("Null inputs. (patch_make)");
    //}
        //LinkedList<Diff> diffs = diff_main(text1, text2, true);
        //if (diffs.size() > 2) {
      //diff_cleanupSemantic(diffs);
      //diff_cleanupEfficiency(diffs);
    //}
        //return patch_make(text1, diffs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.628 -0400", hash_original_method = "58D8D502C896CF861951D3FDEAC17E0F", hash_generated_method = "A0AAAF01E1666EC833FC25621008DE4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList<Patch> patch_make(LinkedList<Diff> diffs) {
        dsTaint.addTaint(diffs.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null inputs. (patch_make)");
        } //End block
        String text1;
        text1 = diff_text1(diffs);
        LinkedList<Patch> var3E755C0FEF2947C27AF0258AC6040611_485589632 = (patch_make(text1, diffs));
        return (LinkedList<Patch>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (diffs == null) {
      //throw new IllegalArgumentException("Null inputs. (patch_make)");
    //}
        //String text1 = diff_text1(diffs);
        //return patch_make(text1, diffs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.638 -0400", hash_original_method = "D6DBD86CFADE101265A7921E0A18EF4D", hash_generated_method = "1AD84CE09F2F9BEE0CC7DF3BCB36CCC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList<Patch> patch_make(String text1, String text2,
      LinkedList<Diff> diffs) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(text2);
        dsTaint.addTaint(diffs.dsTaint);
        LinkedList<Patch> var3E755C0FEF2947C27AF0258AC6040611_90181006 = (patch_make(text1, diffs));
        return (LinkedList<Patch>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return patch_make(text1, diffs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.670 -0400", hash_original_method = "34EFC2BB89CDC2DC951A36B739D6AB00", hash_generated_method = "F87219E5FC0B19D4AD53832DD849FABF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList<Patch> patch_make(String text1, LinkedList<Diff> diffs) {
        dsTaint.addTaint(text1);
        dsTaint.addTaint(diffs.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Null inputs. (patch_make)");
        } //End block
        LinkedList<Patch> patches;
        patches = new LinkedList<Patch>();
        {
            boolean varF246F7F9C176B01FF8ABA6166E76746A_847675661 = (diffs.isEmpty());
        } //End collapsed parenthetic
        Patch patch;
        patch = new Patch();
        int char_count1;
        char_count1 = 0;
        int char_count2;
        char_count2 = 0;
        String prepatch_text;
        prepatch_text = text1;
        String postpatch_text;
        postpatch_text = text1;
        {
            Iterator<Diff> varC49B2C4CCB217AA567229875D2D3FF54_2066564986 = diffs.iterator();
            varC49B2C4CCB217AA567229875D2D3FF54_2066564986.hasNext();
            Diff aDiff = varC49B2C4CCB217AA567229875D2D3FF54_2066564986.next();
            {
                {
                    boolean varEFA69959F488F18030CB83015992D5A6_1129211193 = (patch.diffs.isEmpty() && aDiff.operation != Operation.EQUAL);
                    {
                        patch.start1 = char_count1;
                        patch.start2 = char_count2;
                    } //End block
                } //End collapsed parenthetic
                //Begin case INSERT 
                patch.diffs.add(aDiff);
                //End case INSERT 
                //Begin case INSERT 
                patch.length2 += aDiff.text.length();
                //End case INSERT 
                //Begin case INSERT 
                postpatch_text = postpatch_text.substring(0, char_count2)
            + aDiff.text + postpatch_text.substring(char_count2);
                //End case INSERT 
                //Begin case DELETE 
                patch.length1 += aDiff.text.length();
                //End case DELETE 
                //Begin case DELETE 
                patch.diffs.add(aDiff);
                //End case DELETE 
                //Begin case DELETE 
                postpatch_text = postpatch_text.substring(0, char_count2)
            + postpatch_text.substring(char_count2 + aDiff.text.length());
                //End case DELETE 
                //Begin case EQUAL 
                {
                    boolean varBD13850F5C6D648895568ACBF954D4A8_294219662 = (aDiff.text.length() <= 2 * Patch_Margin
            && !patch.diffs.isEmpty() && aDiff != diffs.getLast());
                    {
                        patch.diffs.add(aDiff);
                        patch.length1 += aDiff.text.length();
                        patch.length2 += aDiff.text.length();
                    } //End block
                } //End collapsed parenthetic
                //End case EQUAL 
                //Begin case EQUAL 
                {
                    boolean var05E53A2BD9649DE647980F7426102A52_275886698 = (aDiff.text.length() >= 2 * Patch_Margin);
                    {
                        {
                            boolean var6D9F87B7F8EF01113948C8A6286FEF40_1460484419 = (!patch.diffs.isEmpty());
                            {
                                patch_addContext(patch, prepatch_text);
                                patches.add(patch);
                                patch = new Patch();
                                prepatch_text = postpatch_text;
                                char_count1 = char_count2;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                //End case EQUAL 
                {
                    char_count1 += aDiff.text.length();
                } //End block
                {
                    char_count2 += aDiff.text.length();
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            boolean var54E7C4D28B02EEF3B0E9B633D4964703_1406365708 = (!patch.diffs.isEmpty());
            {
                patch_addContext(patch, prepatch_text);
                patches.add(patch);
            } //End block
        } //End collapsed parenthetic
        return (LinkedList<Patch>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.697 -0400", hash_original_method = "A5C1FDD06BAE2BD3FB73FDDD73422851", hash_generated_method = "0C9530823FA54FE62D6B1314B3496DAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkedList<Patch> patch_deepCopy(LinkedList<Patch> patches) {
        dsTaint.addTaint(patches.dsTaint);
        LinkedList<Patch> patchesCopy;
        patchesCopy = new LinkedList<Patch>();
        {
            Iterator<Patch> var401340ECAFB8EE2F2A96D0474476AEDB_682692418 = patches.iterator();
            var401340ECAFB8EE2F2A96D0474476AEDB_682692418.hasNext();
            Patch aPatch = var401340ECAFB8EE2F2A96D0474476AEDB_682692418.next();
            {
                Patch patchCopy;
                patchCopy = new Patch();
                {
                    Iterator<Diff> var769DE24AD3776ED3753E5FFE2240FA85_81096211 = aPatch.diffs.iterator();
                    var769DE24AD3776ED3753E5FFE2240FA85_81096211.hasNext();
                    Diff aDiff = var769DE24AD3776ED3753E5FFE2240FA85_81096211.next();
                    {
                        Diff diffCopy;
                        diffCopy = new Diff(aDiff.operation, aDiff.text);
                        patchCopy.diffs.add(diffCopy);
                    } //End block
                } //End collapsed parenthetic
                patchCopy.start1 = aPatch.start1;
                patchCopy.start2 = aPatch.start2;
                patchCopy.length1 = aPatch.length1;
                patchCopy.length2 = aPatch.length2;
                patchesCopy.add(patchCopy);
            } //End block
        } //End collapsed parenthetic
        return (LinkedList<Patch>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkedList<Patch> patchesCopy = new LinkedList<Patch>();
        //for (Patch aPatch : patches) {
      //Patch patchCopy = new Patch();
      //for (Diff aDiff : aPatch.diffs) {
        //Diff diffCopy = new Diff(aDiff.operation, aDiff.text);
        //patchCopy.diffs.add(diffCopy);
      //}
      //patchCopy.start1 = aPatch.start1;
      //patchCopy.start2 = aPatch.start2;
      //patchCopy.length1 = aPatch.length1;
      //patchCopy.length2 = aPatch.length2;
      //patchesCopy.add(patchCopy);
    //}
        //return patchesCopy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.729 -0400", hash_original_method = "A2B73174FA574E50CD4B8D3F447DC25F", hash_generated_method = "6AE69B90ED050486D4B769E8262945B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object[] patch_apply(LinkedList<Patch> patches, String text) {
        dsTaint.addTaint(text);
        dsTaint.addTaint(patches.dsTaint);
        {
            boolean var408F37AE4C99EA52F3796B923601E411_1265254165 = (patches.isEmpty());
        } //End collapsed parenthetic
        patches = patch_deepCopy(patches);
        String nullPadding;
        nullPadding = patch_addPadding(patches);
        text = nullPadding + text + nullPadding;
        patch_splitMax(patches);
        int x;
        x = 0;
        int delta;
        delta = 0;
        boolean[] results;
        results = new boolean[patches.size()];
        {
            Iterator<Patch> var401340ECAFB8EE2F2A96D0474476AEDB_1741859620 = patches.iterator();
            var401340ECAFB8EE2F2A96D0474476AEDB_1741859620.hasNext();
            Patch aPatch = var401340ECAFB8EE2F2A96D0474476AEDB_1741859620.next();
            {
                int expected_loc;
                expected_loc = aPatch.start2 + delta;
                String text1;
                text1 = diff_text1(aPatch.diffs);
                int start_loc;
                int end_loc;
                end_loc = -1;
                {
                    boolean var011CE498F3D33D001CAA259B113CB715_909003989 = (text1.length() > this.Match_MaxBits);
                    {
                        start_loc = match_main(text,
            text1.substring(0, this.Match_MaxBits), expected_loc);
                        {
                            end_loc = match_main(text,
              text1.substring(text1.length() - this.Match_MaxBits),
              expected_loc + text1.length() - this.Match_MaxBits);
                            {
                                start_loc = -1;
                            } //End block
                        } //End block
                    } //End block
                    {
                        start_loc = match_main(text, text1, expected_loc);
                    } //End block
                } //End collapsed parenthetic
                {
                    results[x] = false;
                    delta -= aPatch.length2 - aPatch.length1;
                } //End block
                {
                    results[x] = true;
                    delta = start_loc - expected_loc;
                    String text2;
                    {
                        text2 = text.substring(start_loc,
              Math.min(start_loc + text1.length(), text.length()));
                    } //End block
                    {
                        text2 = text.substring(start_loc,
              Math.min(end_loc + this.Match_MaxBits, text.length()));
                    } //End block
                    {
                        boolean varF44FA89DE8FC8FA895F2E2DCE253FFB7_1719958939 = (text1.equals(text2));
                        {
                            text = text.substring(0, start_loc) + diff_text2(aPatch.diffs)
              + text.substring(start_loc + text1.length());
                        } //End block
                        {
                            LinkedList<Diff> diffs;
                            diffs = diff_main(text1, text2, false);
                            {
                                boolean var5F1F67DEAE63D4FAB5663BE7C0D8A4F8_806648448 = (text1.length() > this.Match_MaxBits
              && diff_levenshtein(diffs) / (float) text1.length()
              > this.Patch_DeleteThreshold);
                                {
                                    results[x] = false;
                                } //End block
                                {
                                    diff_cleanupSemanticLossless(diffs);
                                    int index1;
                                    index1 = 0;
                                    {
                                        Iterator<Diff> var769DE24AD3776ED3753E5FFE2240FA85_1871615142 = aPatch.diffs.iterator();
                                        var769DE24AD3776ED3753E5FFE2240FA85_1871615142.hasNext();
                                        Diff aDiff = var769DE24AD3776ED3753E5FFE2240FA85_1871615142.next();
                                        {
                                            {
                                                int index2;
                                                index2 = diff_xIndex(diffs, index1);
                                                {
                                                    text = text.substring(0, start_loc + index2) + aDiff.text
                      + text.substring(start_loc + index2);
                                                } //End block
                                                {
                                                    text = text.substring(0, start_loc + index2)
                      + text.substring(start_loc + diff_xIndex(diffs,
                      index1 + aDiff.text.length()));
                                                } //End block
                                            } //End block
                                            {
                                                index1 += aDiff.text.length();
                                            } //End block
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                x++;
            } //End block
        } //End collapsed parenthetic
        text = text.substring(nullPadding.length(), text.length()
        - nullPadding.length());
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.752 -0400", hash_original_method = "EEE6A13CBA8DD6EBE835AD9682587548", hash_generated_method = "BB7726A537EA74E5638020FE44589DDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String patch_addPadding(LinkedList<Patch> patches) {
        dsTaint.addTaint(patches.dsTaint);
        int paddingLength;
        paddingLength = this.Patch_Margin;
        String nullPadding;
        nullPadding = "";
        {
            int x;
            x = 1;
            {
                nullPadding += String.valueOf((char) x);
            } //End block
        } //End collapsed parenthetic
        {
            Iterator<Patch> var401340ECAFB8EE2F2A96D0474476AEDB_1199909223 = patches.iterator();
            var401340ECAFB8EE2F2A96D0474476AEDB_1199909223.hasNext();
            Patch aPatch = var401340ECAFB8EE2F2A96D0474476AEDB_1199909223.next();
            {
                aPatch.start1 += paddingLength;
                aPatch.start2 += paddingLength;
            } //End block
        } //End collapsed parenthetic
        Patch patch;
        patch = patches.getFirst();
        LinkedList<Diff> diffs;
        diffs = patch.diffs;
        {
            boolean var26703CE7EE09BD525D4AAFBD9EB92EF4_1123075163 = (diffs.isEmpty() || diffs.getFirst().operation != Operation.EQUAL);
            {
                diffs.addFirst(new Diff(Operation.EQUAL, nullPadding));
                patch.start1 -= paddingLength;
                patch.start2 -= paddingLength;
                patch.length1 += paddingLength;
                patch.length2 += paddingLength;
            } //End block
            {
                boolean var77A70678DDA9A47A027AE42BFF4E205F_1024736085 = (paddingLength > diffs.getFirst().text.length());
                {
                    Diff firstDiff;
                    firstDiff = diffs.getFirst();
                    int extraLength;
                    extraLength = paddingLength - firstDiff.text.length();
                    firstDiff.text = nullPadding.substring(firstDiff.text.length())
          + firstDiff.text;
                    patch.start1 -= extraLength;
                    patch.start2 -= extraLength;
                    patch.length1 += extraLength;
                    patch.length2 += extraLength;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        patch = patches.getLast();
        diffs = patch.diffs;
        {
            boolean var5AA782C46DB977E3FF7438DDBC97AB76_388138380 = (diffs.isEmpty() || diffs.getLast().operation != Operation.EQUAL);
            {
                diffs.addLast(new Diff(Operation.EQUAL, nullPadding));
                patch.length1 += paddingLength;
                patch.length2 += paddingLength;
            } //End block
            {
                boolean var1CEBE32E96535538F0A13FD15139B7E2_150369205 = (paddingLength > diffs.getLast().text.length());
                {
                    Diff lastDiff;
                    lastDiff = diffs.getLast();
                    int extraLength;
                    extraLength = paddingLength - lastDiff.text.length();
                    lastDiff.text += nullPadding.substring(0, extraLength);
                    patch.length1 += extraLength;
                    patch.length2 += extraLength;
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.818 -0400", hash_original_method = "C6AEFE637207088552DCDB9AAE1AC9B9", hash_generated_method = "17D720CFFF912D9B332B7BFC5B4B72C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void patch_splitMax(LinkedList<Patch> patches) {
        dsTaint.addTaint(patches.dsTaint);
        int patch_size;
        String precontext, postcontext;
        Patch patch;
        int start1, start2;
        boolean empty;
        Operation diff_type;
        String diff_text;
        ListIterator<Patch> pointer;
        pointer = patches.listIterator();
        Patch bigpatch;
        boolean varB513C9F10892B7B8D18EC87AE00530C0_1653001857 = (pointer.hasNext());
        bigpatch = pointer.next();
        bigpatch = null;
        {
            {
                bigpatch = pointer.hasNext() ? pointer.next() : null;
            } //End block
            pointer.remove();
            patch_size = Match_MaxBits;
            start1 = bigpatch.start1;
            start2 = bigpatch.start2;
            precontext = "";
            {
                boolean var9E6BCA6202ED322C65BA8888DF5C80C4_379864064 = (!bigpatch.diffs.isEmpty());
                {
                    patch = new Patch();
                    empty = true;
                    patch.start1 = start1 - precontext.length();
                    patch.start2 = start2 - precontext.length();
                    {
                        boolean var6B220E073375B9305D3DD215725CA3ED_2092554998 = (precontext.length() != 0);
                        {
                            patch.length1 = patch.length2 = precontext.length();
                            patch.diffs.add(new Diff(Operation.EQUAL, precontext));
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var7A0CDB26204E6B63F72C3C8DDE8F886C_1981513793 = (!bigpatch.diffs.isEmpty()
            && patch.length1 < patch_size - Patch_Margin);
                        {
                            diff_type = bigpatch.diffs.getFirst().operation;
                            diff_text = bigpatch.diffs.getFirst().text;
                            {
                                patch.length2 += diff_text.length();
                                start2 += diff_text.length();
                                patch.diffs.addLast(bigpatch.diffs.removeFirst());
                                empty = false;
                            } //End block
                            {
                                boolean var233CA654FDFF3906F6D9F13BFE609092_82986073 = (diff_type == Operation.DELETE && patch.diffs.size() == 1
              && patch.diffs.getFirst().operation == Operation.EQUAL
              && diff_text.length() > 2 * patch_size);
                                {
                                    patch.length1 += diff_text.length();
                                    start1 += diff_text.length();
                                    empty = false;
                                    patch.diffs.add(new Diff(diff_type, diff_text));
                                    bigpatch.diffs.removeFirst();
                                } //End block
                                {
                                    diff_text = diff_text.substring(0, Math.min(diff_text.length(),
                patch_size - patch.length1 - Patch_Margin));
                                    patch.length1 += diff_text.length();
                                    start1 += diff_text.length();
                                    {
                                        patch.length2 += diff_text.length();
                                        start2 += diff_text.length();
                                    } //End block
                                    {
                                        empty = false;
                                    } //End block
                                    patch.diffs.add(new Diff(diff_type, diff_text));
                                    {
                                        boolean varA3BB94BB68934E39DDCFFF0EDF7C42E8_1711510814 = (diff_text.equals(bigpatch.diffs.getFirst().text));
                                        {
                                            bigpatch.diffs.removeFirst();
                                        } //End block
                                        {
                                            bigpatch.diffs.getFirst().text = bigpatch.diffs.getFirst().text
                  .substring(diff_text.length());
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    precontext = diff_text2(patch.diffs);
                    precontext = precontext.substring(Math.max(0, precontext.length()
            - Patch_Margin));
                    {
                        boolean var8F26D5A0FA093B83AB29CEC949B1EDFE_1823665639 = (diff_text1(bigpatch.diffs).length() > Patch_Margin);
                        {
                            postcontext = diff_text1(bigpatch.diffs).substring(0, Patch_Margin);
                        } //End block
                        {
                            postcontext = diff_text1(bigpatch.diffs);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean var7C2F5407C1E54D04F2488D8B3DBC2E64_1436015548 = (postcontext.length() != 0);
                        {
                            patch.length1 += postcontext.length();
                            patch.length2 += postcontext.length();
                            {
                                boolean varD6464821C7D03837DB07C762941F809E_2036233789 = (!patch.diffs.isEmpty()
              && patch.diffs.getLast().operation == Operation.EQUAL);
                                {
                                    patch.diffs.getLast().text += postcontext;
                                } //End block
                                {
                                    patch.diffs.add(new Diff(Operation.EQUAL, postcontext));
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    {
                        pointer.add(patch);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            bigpatch = pointer.hasNext() ? pointer.next() : null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.845 -0400", hash_original_method = "7A70E8D51333848B793207405BF4126F", hash_generated_method = "1C85D59964AFE7465AEF44496705BB4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String patch_toText(List<Patch> patches) {
        dsTaint.addTaint(patches.dsTaint);
        StringBuilder text;
        text = new StringBuilder();
        {
            Iterator<Patch> var401340ECAFB8EE2F2A96D0474476AEDB_591178807 = patches.iterator();
            var401340ECAFB8EE2F2A96D0474476AEDB_591178807.hasNext();
            Patch aPatch = var401340ECAFB8EE2F2A96D0474476AEDB_591178807.next();
            {
                text.append(aPatch);
            } //End block
        } //End collapsed parenthetic
        String var26FF8C1159EFD8B2BDF89D74D54FC6D9_740427502 = (text.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder text = new StringBuilder();
        //for (Patch aPatch : patches) {
      //text.append(aPatch);
    //}
        //return text.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.897 -0400", hash_original_method = "4D0B3D4D6DDD0CC222AD373ECE65675B", hash_generated_method = "AEE1DE3E6B15368389DA9B24FC74CA99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<Patch> patch_fromText(String textline) throws IllegalArgumentException {
        dsTaint.addTaint(textline);
        List<Patch> patches;
        patches = new LinkedList<Patch>();
        {
            boolean varDFFEC10D631A9AB342BEFD525B5AD2D4_480892196 = (textline.length() == 0);
        } //End collapsed parenthetic
        List<String> textList;
        textList = Arrays.asList(textline.split("\n"));
        LinkedList<String> text;
        text = new LinkedList<String>(textList);
        Patch patch;
        Pattern patchHeader;
        patchHeader = Pattern.compile("^@@ -(\\d+),?(\\d*) \\+(\\d+),?(\\d*) @@$");
        Matcher m;
        char sign ='a';
        String line;
        {
            boolean varDD58D676532446E2E696CB2F8EA94D6B_73721482 = (!text.isEmpty());
            {
                m = patchHeader.matcher(text.getFirst());
                {
                    boolean varA371883EDEF6AA805F44025EAE0A12BD_497646042 = (!m.matches());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
            "Invalid patch string: " + text.getFirst());
                    } //End block
                } //End collapsed parenthetic
                patch = new Patch();
                patches.add(patch);
                patch.start1 = Integer.parseInt(m.group(1));
                {
                    boolean var8C6D7E87CAA9FA0BBA1889F97A0C3B6B_1885167507 = (m.group(2).length() == 0);
                    {
                        patch.start1--;
                        patch.length1 = 1;
                    } //End block
                    {
                        boolean var8E238709E9C4EF113C6FE6C8A111D6D9_650245544 = (m.group(2).equals("0"));
                        {
                            patch.length1 = 0;
                        } //End block
                        {
                            patch.start1--;
                            patch.length1 = Integer.parseInt(m.group(2));
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                patch.start2 = Integer.parseInt(m.group(3));
                {
                    boolean varBD85B9AE82AE846D1E3238A2AA2BE311_1728291746 = (m.group(4).length() == 0);
                    {
                        patch.start2--;
                        patch.length2 = 1;
                    } //End block
                    {
                        boolean varCA35074906BC81742E0DA323D3CF5207_2123051553 = (m.group(4).equals("0"));
                        {
                            patch.length2 = 0;
                        } //End block
                        {
                            patch.start2--;
                            patch.length2 = Integer.parseInt(m.group(4));
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                text.removeFirst();
                {
                    boolean var9E9929B4DD933C866624277050E4F0AE_325953165 = (!text.isEmpty());
                    {
                        try 
                        {
                            sign = text.getFirst().charAt(0);
                        } //End block
                        catch (IndexOutOfBoundsException e)
                        {
                            text.removeFirst();
                        } //End block
                        line = text.getFirst().substring(1);
                        line = line.replace("+", "%2B");
                        try 
                        {
                            line = URLDecoder.decode(line, "UTF-8");
                        } //End block
                        catch (UnsupportedEncodingException e)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new Error("This system does not support UTF-8.", e);
                        } //End block
                        catch (IllegalArgumentException e)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
              "Illegal escape in patch_fromText: " + line, e);
                        } //End block
                        {
                            patch.diffs.add(new Diff(Operation.DELETE, line));
                        } //End block
                        {
                            patch.diffs.add(new Diff(Operation.INSERT, line));
                        } //End block
                        {
                            patch.diffs.add(new Diff(Operation.EQUAL, line));
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
              "Invalid patch mode '" + sign + "' in: " + line);
                        } //End block
                        text.removeFirst();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (List<Patch>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.917 -0400", hash_original_method = "109C432E4FE192704F78FE1FE75CA2B4", hash_generated_method = "912BFD7B42620E3C1A3051B4DD5CBB30")
    private static String unescapeForEncodeUriCompatability(String str) {
        return str.replace("%21", "!").replace("%7E", "~")
        .replace("%27", "'").replace("%28", "(").replace("%29", ")")
        .replace("%3B", ";").replace("%2F", "/").replace("%3F", "?")
        .replace("%3A", ":").replace("%40", "@").replace("%26", "&")
        .replace("%3D", "=").replace("%2B", "+").replace("%24", "$")
        .replace("%2C", ",").replace("%23", "#");
    }

    
    protected static class LinesToCharsResult {
        protected String chars1;
        protected String chars2;
        protected List<String> lineArray;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.922 -0400", hash_original_method = "FFCD3CD4332C53290660280CDAA0F343", hash_generated_method = "D68D547BA891C10C25C978DE0BBC5FBC")
        @DSModeled(DSC.SAFE)
        protected LinesToCharsResult(String chars1, String chars2,
        List<String> lineArray) {
            dsTaint.addTaint(lineArray.dsTaint);
            dsTaint.addTaint(chars2);
            dsTaint.addTaint(chars1);
            // ---------- Original Method ----------
            //this.chars1 = chars1;
            //this.chars2 = chars2;
            //this.lineArray = lineArray;
        }

        
    }


    
    public enum Operation {
    DELETE, INSERT, EQUAL
  }

    
    public static class Diff {
        public Operation operation;
        public String text;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.925 -0400", hash_original_method = "13A74C44531010D1575F9A18C65E268C", hash_generated_method = "D652E1BFCD7D08E40B000779005A5531")
        @DSModeled(DSC.SAFE)
        public Diff(Operation operation, String text) {
            dsTaint.addTaint(operation.dsTaint);
            dsTaint.addTaint(text);
            // ---------- Original Method ----------
            //this.operation = operation;
            //this.text = text;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.929 -0400", hash_original_method = "11FE24D073780F6321341B251386C4E9", hash_generated_method = "4087618C9CE3F1523B097AD11E926FBA")
        @DSModeled(DSC.SAFE)
        public String toString() {
            String prettyText;
            prettyText = this.text.replace('\n', '\u00b6');
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //String prettyText = this.text.replace('\n', '\u00b6');
            //return "Diff(" + this.operation + ",\"" + prettyText + "\")";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.933 -0400", hash_original_method = "F019364F7EA1B2CB547ED74F60153AAB", hash_generated_method = "7DC8250AB96A97A769D66A4933C35262")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean equals(Object d) {
            dsTaint.addTaint(d.dsTaint);
            try 
            {
                boolean varA14E791BD4BFB1276438AA2939402A20_847574234 = ((((Diff) d).operation == this.operation)
               && (((Diff) d).text.equals(this.text)));
            } //End block
            catch (ClassCastException e)
            { }
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //try {
        //return (((Diff) d).operation == this.operation)
               //&& (((Diff) d).text.equals(this.text));
      //} catch (ClassCastException e) {
        //return false;
      //}
        }

        
    }


    
    public static class Patch {
        public LinkedList<Diff> diffs;
        public int start1;
        public int start2;
        public int length1;
        public int length2;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.937 -0400", hash_original_method = "D27410AB086F756A6BFE59579FA3C5AD", hash_generated_method = "45DD93F715A9C231381107F1E90A4EEE")
        @DSModeled(DSC.SAFE)
        public Patch() {
            this.diffs = new LinkedList<Diff>();
            // ---------- Original Method ----------
            //this.diffs = new LinkedList<Diff>();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:40:18.945 -0400", hash_original_method = "BE868B2BBD99FCA21C386C06B8032AD5", hash_generated_method = "B1FF81C4C3FE4E6E9D0FA411D27C9C7E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String coords1, coords2;
            {
                coords1 = this.start1 + ",0";
            } //End block
            {
                coords1 = Integer.toString(this.start1 + 1);
            } //End block
            {
                coords1 = (this.start1 + 1) + "," + this.length1;
            } //End block
            {
                coords2 = this.start2 + ",0";
            } //End block
            {
                coords2 = Integer.toString(this.start2 + 1);
            } //End block
            {
                coords2 = (this.start2 + 1) + "," + this.length2;
            } //End block
            StringBuilder text;
            text = new StringBuilder();
            text.append("@@ -").append(coords1).append(" +").append(coords2)
          .append(" @@\n");
            {
                Iterator<Diff> var1ABE63A4B0529C07E05B2EF44229DC9A_139555902 = this.diffs.iterator();
                var1ABE63A4B0529C07E05B2EF44229DC9A_139555902.hasNext();
                Diff aDiff = var1ABE63A4B0529C07E05B2EF44229DC9A_139555902.next();
                {
                    //Begin case INSERT 
                    text.append('+');
                    //End case INSERT 
                    //Begin case DELETE 
                    text.append('-');
                    //End case DELETE 
                    //Begin case EQUAL 
                    text.append(' ');
                    //End case EQUAL 
                    try 
                    {
                        text.append(URLEncoder.encode(aDiff.text, "UTF-8").replace('+', ' '))
              .append("\n");
                    } //End block
                    catch (UnsupportedEncodingException e)
                    {
                        if (DroidSafeAndroidRuntime.control) throw new Error("This system does not support UTF-8.", e);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            String varBB5AFF7577CA9ACA8B52272D84DA6DE7_1539907877 = (unescapeForEncodeUriCompatability(text.toString()));
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
}


