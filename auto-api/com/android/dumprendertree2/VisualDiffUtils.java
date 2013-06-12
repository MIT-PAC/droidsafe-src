package com.android.dumprendertree2;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import name.fraser.neil.plaintext.diff_match_patch;
import java.util.LinkedList;

public class VisualDiffUtils {
    private static int DONT_PRINT_LINE_NUMBER = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:51:15.208 -0400", hash_original_method = "19D612E40EE8221678127FE0E3C6DE5D", hash_generated_method = "AEFC130E5C769BDE515523D285A41560")
    public static LinkedList<diff_match_patch.Diff> splitDiffsOnNewline(
            LinkedList<diff_match_patch.Diff> diffs) {
        LinkedList<diff_match_patch.Diff> newDiffs = new LinkedList<diff_match_patch.Diff>();
        String[] parts;
        int lengthMinusOne;
        for (diff_match_patch.Diff diff : diffs) {
            parts = diff.text.split("\n", -1);
            if (parts.length == 1) {
                newDiffs.add(diff);
                continue;
            }
            lengthMinusOne = parts.length - 1;
            for (int i = 0; i < lengthMinusOne; i++) {
                newDiffs.add(new diff_match_patch.Diff(diff.operation, parts[i] + "\n"));
            }
            if (!parts[lengthMinusOne].isEmpty()) {
                newDiffs.add(new diff_match_patch.Diff(diff.operation, parts[lengthMinusOne]));
            }
        }
        return newDiffs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:51:15.231 -0400", hash_original_method = "296177D36CA93CDA3D0BC4085DDA121E", hash_generated_method = "063DE864D70229AC014FBC30BEE300D7")
    public static void generateExpectedResultLines(LinkedList<diff_match_patch.Diff> diffs,
            LinkedList<Integer> lineNums, LinkedList<String> lines) {
        String delSpan = "<span class=\"del\">";
        String eqlSpan = "<span class=\"eql\">";
        String line = "";
        int i = 1;
        diff_match_patch.Diff diff;
        int size = diffs.size();
        boolean isLastDiff;
        for (int j = 0; j < size; j++) {
            diff = diffs.get(j);
            isLastDiff = j == size - 1;
            switch (diff.operation) {
                case DELETE:
                    line = processDiff(diff, lineNums, lines, line, i, delSpan, isLastDiff);
                    if (line.equals("")) {
                        i++;
                    }
                    break;
                case INSERT:
                    if (diff.text.endsWith("\n") || isLastDiff) {
                        lineNums.add(line.equals("") ? DONT_PRINT_LINE_NUMBER : i++);
                        lines.add(line);
                        line = "";
                    }
                    break;
                case EQUAL:
                    line = processDiff(diff, lineNums, lines, line, i, eqlSpan, isLastDiff);
                    if (line.equals("")) {
                        i++;
                    }
                    break;
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:51:15.253 -0400", hash_original_method = "1438ED75CE0764CDDF2156551037739B", hash_generated_method = "810609DC214D29271C43F112ECC565A9")
    public static void generateActualResultLines(LinkedList<diff_match_patch.Diff> diffs,
            LinkedList<Integer> lineNums, LinkedList<String> lines) {
        String insSpan = "<span class=\"ins\">";
        String eqlSpan = "<span class=\"eql\">";
        String line = "";
        int i = 1;
        diff_match_patch.Diff diff;
        int size = diffs.size();
        boolean isLastDiff;
        for (int j = 0; j < size; j++) {
            diff = diffs.get(j);
            isLastDiff = j == size - 1;
            switch (diff.operation) {
                case INSERT:
                    line = processDiff(diff, lineNums, lines, line, i, insSpan, isLastDiff);
                    if (line.equals("")) {
                        i++;
                    }
                    break;
                case DELETE:
                    if (diff.text.endsWith("\n") || isLastDiff) {
                        lineNums.add(line.equals("") ? DONT_PRINT_LINE_NUMBER : i++);
                        lines.add(line);
                        line = "";
                    }
                    break;
                case EQUAL:
                    line = processDiff(diff, lineNums, lines, line, i, eqlSpan, isLastDiff);
                    if (line.equals("")) {
                        i++;
                    }
                    break;
            }
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:51:15.271 -0400", hash_original_method = "CDE92B6E7215FE9CBDE791F7BFDC2FAB", hash_generated_method = "87E5731C5C4C03C596A7A9036949C03C")
    public static String processDiff(diff_match_patch.Diff diff, LinkedList<Integer> lineNums,
            LinkedList<String> lines, String line, int i, String begSpan, boolean forceOutputLine) {
        String endSpan = "</span>";
        String br = "&nbsp;";
        if (diff.text.endsWith("\n") || forceOutputLine) {
            lineNums.add(i);
            line += begSpan + diff.text.replace("  ", "&nbsp;&nbsp;")
                    + endSpan + br;
            lines.add(line);
            line = "";
        } else {
            line += begSpan + diff.text.replace("  ", "&nbsp;&nbsp;") + endSpan;
        }
        return line;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:51:15.284 -0400", hash_original_method = "4AC8B9EFB34412FD4B50CDDF4A9674D6", hash_generated_method = "A3E7F72D5806AFF55DF6F942EE27896B")
    public static String getHtml(LinkedList<Integer> lineNums1, LinkedList<String> lines1,
            LinkedList<Integer> lineNums2, LinkedList<String> lines2) {
        StringBuilder html = new StringBuilder();
        int lineNum;
        int size = lines1.size();
        for (int i = 0; i < size; i++) {
            html.append("<tr class=\"results\">");
            html.append("    <td class=\"line_count\">");
            lineNum = lineNums1.removeFirst();
            if (lineNum > 0) {
                html.append(lineNum);
            }
            html.append("    </td>");
            html.append("    <td class=\"line\">");
            html.append(lines1.removeFirst());
            html.append("    </td>");
            html.append("    <td class=\"space\"></td>");
            html.append("    <td class=\"line_count\">");
            lineNum = lineNums2.removeFirst();
            if (lineNum > 0) {
                html.append(lineNum);
            }
            html.append("    </td>");
            html.append("    <td class=\"line\">");
            html.append(lines2.removeFirst());
            html.append("    </td>");
            html.append("</tr>");
        }
        return html.toString();
    }

    
}


