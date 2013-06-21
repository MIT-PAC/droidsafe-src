package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class AttributedString {
    String text;
    Map<AttributedCharacterIterator.Attribute, List<Range>> attributeMap;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.827 -0400", hash_original_method = "5638BBE38DFF9B04A672F4EC9A02409B", hash_generated_method = "5779650991571717105ED2C8052B42CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedString(AttributedCharacterIterator iterator) {
        dsTaint.addTaint(iterator.dsTaint);
        {
            boolean var5791DB9351E60242F3260BB947788691_2068551278 = (iterator.getBeginIndex() > iterator.getEndIndex());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid substring range");
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder();
        {
            int i;
            i = iterator.getBeginIndex();
            boolean varD47BAE727A1CA5D8FBD74E81EBBAC580_535333611 = (i < iterator.getEndIndex());
            {
                buffer.append(iterator.current());
                iterator.next();
            } //End block
        } //End collapsed parenthetic
        text = buffer.toString();
        Set<AttributedCharacterIterator.Attribute> attributes;
        attributes = iterator
                .getAllAttributeKeys();
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<Attribute> it;
        it = attributes.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_695090896 = (it.hasNext());
            {
                AttributedCharacterIterator.Attribute attribute;
                attribute = it.next();
                iterator.setIndex(0);
                {
                    boolean var28ACB1F338988605D7BB159EDA96A571_1997470291 = (iterator.current() != CharacterIterator.DONE);
                    {
                        int start;
                        start = iterator.getRunStart(attribute);
                        int limit;
                        limit = iterator.getRunLimit(attribute);
                        Object value;
                        value = iterator.getAttribute(attribute);
                        {
                            addAttribute(attribute, value, start, limit);
                        } //End block
                        iterator.setIndex(limit);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.828 -0400", hash_original_method = "3A8973AD4EBE1F3B94E1633368C42F9D", hash_generated_method = "15B01CAADA852CD94781BCDAAB5B2DE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AttributedString(AttributedCharacterIterator iterator, int start,
            int end, Set<Attribute> attributes) {
        dsTaint.addTaint(iterator.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(attributes.dsTaint);
        dsTaint.addTaint(end);
        {
            boolean var6E1EE5C4631EC62ECEF890E2A840FF67_1817479128 = (start < iterator.getBeginIndex() || end > iterator.getEndIndex()
                || start > end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder();
        iterator.setIndex(start);
        {
            boolean varFB2E1080C5571E90BCE1803511FF22B4_2120882038 = (iterator.getIndex() < end);
            {
                buffer.append(iterator.current());
                iterator.next();
            } //End block
        } //End collapsed parenthetic
        text = buffer.toString();
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<Attribute> it;
        it = attributes.iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_637753532 = (it.hasNext());
            {
                AttributedCharacterIterator.Attribute attribute;
                attribute = it.next();
                iterator.setIndex(start);
                {
                    boolean var01C467E388CE293308E11B7796E75DEA_427179068 = (iterator.getIndex() < end);
                    {
                        Object value;
                        value = iterator.getAttribute(attribute);
                        int runStart;
                        runStart = iterator.getRunStart(attribute);
                        int limit;
                        limit = iterator.getRunLimit(attribute);
                        {
                            addAttribute(attribute, value, (runStart < start ? start
                            : runStart)
                            - start, (limit > end ? end : limit) - start);
                        } //End block
                        iterator.setIndex(limit);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.828 -0400", hash_original_method = "D0E1FC5545253EA6E008AE3675A9452F", hash_generated_method = "001E2456CCAFB29E1995EE12DF7A263C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedString(AttributedCharacterIterator iterator, int start,
            int end) {
        this(iterator, start, end, iterator.getAllAttributeKeys());
        dsTaint.addTaint(iterator.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.828 -0400", hash_original_method = "B4766721E168BC843A6EA06CFE59500E", hash_generated_method = "CE1490734964A264B7C39ECD7D748A28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedString(AttributedCharacterIterator iterator, int start,
            int end, AttributedCharacterIterator.Attribute[] attributes) {
        this(iterator, start, end, (attributes == null
                ? new HashSet<Attribute>()
                : new HashSet<Attribute>(Arrays.asList(attributes))));
        dsTaint.addTaint(iterator.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(attributes[0].dsTaint);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.829 -0400", hash_original_method = "A0ACF5D97B9D79B3295575A771939692", hash_generated_method = "34AB62302A35F573CBD64BF821278AF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedString(String value) {
        dsTaint.addTaint(value);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        attributeMap = new HashMap<Attribute, List<Range>>(11);
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //text = value;
        //attributeMap = new HashMap<Attribute, List<Range>>(11);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.829 -0400", hash_original_method = "85CF866984BA31F6F3E97322323F86BA", hash_generated_method = "46A5D3C69D4DE57713819CB6BA3C0A23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedString(String value,
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(attributes.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varF38D1CF4F9C3BE6C8047C579649A2A1F_500693296 = (value.length() == 0 && !attributes.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cannot add attributes to empty string");
            } //End block
        } //End collapsed parenthetic
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<?> it;
        it = attributes.entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1245587841 = (it.hasNext());
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) it.next();
                ArrayList<Range> ranges;
                ranges = new ArrayList<Range>(1);
                ranges.add(new Range(0, text.length(), entry.getValue()));
                attributeMap.put((AttributedCharacterIterator.Attribute) entry
                    .getKey(), ranges);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (value == null) {
            //throw new NullPointerException();
        //}
        //if (value.length() == 0 && !attributes.isEmpty()) {
            //throw new IllegalArgumentException("Cannot add attributes to empty string");
        //}
        //text = value;
        //attributeMap = new HashMap<Attribute, List<Range>>(
                //(attributes.size() * 4 / 3) + 1);
        //Iterator<?> it = attributes.entrySet().iterator();
        //while (it.hasNext()) {
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            //ArrayList<Range> ranges = new ArrayList<Range>(1);
            //ranges.add(new Range(0, text.length(), entry.getValue()));
            //attributeMap.put((AttributedCharacterIterator.Attribute) entry
                    //.getKey(), ranges);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.829 -0400", hash_original_method = "F800EB2F1E580436E49CB51D04E3F37C", hash_generated_method = "39251DFAD754E1741A1D2A2171C48070")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(attribute.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_112158819 = (text.length() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        List<Range> ranges;
        ranges = attributeMap.get(attribute);
        {
            ranges = new ArrayList<Range>(1);
            attributeMap.put(attribute, ranges);
        } //End block
        {
            ranges.clear();
        } //End block
        ranges.add(new Range(0, text.length(), value));
        // ---------- Original Method ----------
        //if (attribute == null) {
            //throw new NullPointerException();
        //}
        //if (text.length() == 0) {
            //throw new IllegalArgumentException();
        //}
        //List<Range> ranges = attributeMap.get(attribute);
        //if (ranges == null) {
            //ranges = new ArrayList<Range>(1);
            //attributeMap.put(attribute, ranges);
        //} else {
            //ranges.clear();
        //}
        //ranges.add(new Range(0, text.length(), value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.830 -0400", hash_original_method = "1EA9CE9DE6197B4051F39E120F823C8E", hash_generated_method = "FE623E13D5193BE09719556091E5E754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addAttribute(AttributedCharacterIterator.Attribute attribute,
            Object value, int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(attribute.dsTaint);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varC9BCC04F7A62407C3BA13DEEA6DE5168_1469586023 = (start < 0 || end > text.length() || start >= end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        List<Range> ranges;
        ranges = attributeMap.get(attribute);
        {
            ranges = new ArrayList<Range>(1);
            ranges.add(new Range(start, end, value));
            attributeMap.put(attribute, ranges);
        } //End block
        ListIterator<Range> it;
        it = ranges.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1870002141 = (it.hasNext());
            {
                Range range;
                range = it.next();
                {
                    it.previous();
                } //End block
                {
                    boolean varEF40E1D978FA25419409FAB7F79E01F6_1153142214 = (start < range.end
                    || (start == range.end && value.equals(range.value)));
                    {
                        Range r1, r3;
                        r1 = null;
                        it.remove();
                        r1 = new Range(range.start, start, range.value);
                        r3 = new Range(end, range.end, range.value);
                        {
                            boolean var1FE3E7148FB59A827E5E6E2483C887F7_610788750 = (end > range.end && it.hasNext());
                            {
                                range = it.next();
                                {
                                    {
                                        boolean var9C218184248DFD9DE95E1445E7891FFF_1257597470 = (end > range.start
                                || (end == range.start && value.equals(range.value)));
                                        {
                                            it.remove();
                                            r3 = new Range(end, range.end, range.value);
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                                {
                                    it.remove();
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                        {
                            boolean var1027DC60E68FD42C72653BFC2EFF2C3B_1770856290 = (value.equals(r1.value));
                            {
                                {
                                    boolean var25819F3F4E6FA285B1052DA41FF64523_1548487021 = (value.equals(r3.value));
                                    {
                                        it.add(new Range(r1.start < start ? r1.start : start,
                                r3.end > end ? r3.end : end, r1.value));
                                    } //End block
                                    {
                                        it.add(new Range(r1.start < start ? r1.start : start,
                                end, r1.value));
                                        {
                                            it.add(r3);
                                        } //End block
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                {
                                    boolean var25819F3F4E6FA285B1052DA41FF64523_1298929713 = (value.equals(r3.value));
                                    {
                                        {
                                            it.add(r1);
                                        } //End block
                                        it.add(new Range(start, r3.end > end ? r3.end : end,
                                r3.value));
                                    } //End block
                                    {
                                        {
                                            it.add(r1);
                                        } //End block
                                        it.add(new Range(start, end, value));
                                        {
                                            it.add(r3);
                                        } //End block
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        it.add(new Range(start, end, value));
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.831 -0400", hash_original_method = "9BDF8CEEC650CFF21B203033378C7411", hash_generated_method = "7EC9E29FB562A327A6E1D1E0B9AE6BF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addAttributes(
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes,
            int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(attributes.dsTaint);
        dsTaint.addTaint(end);
        Iterator<?> it;
        it = attributes.entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1395265221 = (it.hasNext());
            {
                Map.Entry<?, ?> entry;
                entry = (Map.Entry<?, ?>) it.next();
                addAttribute(
                    (AttributedCharacterIterator.Attribute) entry.getKey(),
                    entry.getValue(), start, end);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Iterator<?> it = attributes.entrySet().iterator();
        //while (it.hasNext()) {
            //Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
            //addAttribute(
                    //(AttributedCharacterIterator.Attribute) entry.getKey(),
                    //entry.getValue(), start, end);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.831 -0400", hash_original_method = "3C3A14639543169375B4E8491231683C", hash_generated_method = "8F553D0394AFF4DE6213E37C040EAB98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedCharacterIterator getIterator() {
        AttributedCharacterIterator var9E38EFBBC2A1D4C5C115CC11835A3EF1_1285558702 = (new AttributedIterator(this));
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AttributedIterator(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.831 -0400", hash_original_method = "AFA08901CAEF730E40B185484FAABB29", hash_generated_method = "77DD7F27E7F6D85E521B7B2F34DE5ECB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes) {
        dsTaint.addTaint(attributes[0].dsTaint);
        AttributedCharacterIterator var350757948901E6152C72575EFA89091E_931990070 = (new AttributedIterator(this, attributes, 0, text.length()));
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AttributedIterator(this, attributes, 0, text.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.831 -0400", hash_original_method = "EF8FB9411A496C9D99CDE8B83C48CE6B", hash_generated_method = "951BFC8C08E79B1749A3932E54BEBE73")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes, int start,
            int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(attributes[0].dsTaint);
        dsTaint.addTaint(end);
        AttributedCharacterIterator varEFE4C0C46E2263FF7009AB663425D7CF_1776768081 = (new AttributedIterator(this, attributes, start, end));
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AttributedIterator(this, attributes, start, end);
    }

    
    static class Range {
        int start;
        int end;
        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.831 -0400", hash_original_method = "9919123D3D1FFC7D42BA1CB1CAFB2DA5", hash_generated_method = "DFA3BC2C6B2C97253BD41A40DD94BD7E")
        @DSModeled(DSC.SAFE)
         Range(int s, int e, Object v) {
            dsTaint.addTaint(v.dsTaint);
            dsTaint.addTaint(e);
            dsTaint.addTaint(s);
            // ---------- Original Method ----------
            //start = s;
            //end = e;
            //value = v;
        }

        
    }


    
    static class AttributedIterator implements AttributedCharacterIterator {
        private int begin, end, offset;
        private AttributedString attrString;
        private HashSet<Attribute> attributesAllowed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.832 -0400", hash_original_method = "E441422DE6FDEDB0F1BB74606A67171C", hash_generated_method = "EA579FE586162A95223DCFCCD4315836")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AttributedIterator(AttributedString attrString) {
            dsTaint.addTaint(attrString.dsTaint);
            begin = 0;
            end = attrString.text.length();
            offset = 0;
            // ---------- Original Method ----------
            //this.attrString = attrString;
            //begin = 0;
            //end = attrString.text.length();
            //offset = 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.832 -0400", hash_original_method = "43841E67E512106866A3902EDBE2D718", hash_generated_method = "75056DD1A0EFF60D6F6C284B6B3A1BA4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AttributedIterator(AttributedString attrString,
                AttributedCharacterIterator.Attribute[] attributes, int begin,
                int end) {
            dsTaint.addTaint(attrString.dsTaint);
            dsTaint.addTaint(attributes[0].dsTaint);
            dsTaint.addTaint(end);
            dsTaint.addTaint(begin);
            {
                boolean varFFD07E130858E065814762E8E384F7BD_174294846 = (begin < 0 || end > attrString.text.length() || begin > end);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
                } //End block
            } //End collapsed parenthetic
            {
                HashSet<Attribute> set;
                set = new HashSet<Attribute>(
                        (attributes.length * 4 / 3) + 1);
                {
                    int i;
                    i = attributes.length;
                    {
                        set.add(attributes[i]);
                    } //End block
                } //End collapsed parenthetic
                attributesAllowed = set;
            } //End block
            // ---------- Original Method ----------
            //if (begin < 0 || end > attrString.text.length() || begin > end) {
                //throw new IllegalArgumentException();
            //}
            //this.begin = begin;
            //this.end = end;
            //offset = begin;
            //this.attrString = attrString;
            //if (attributes != null) {
                //HashSet<Attribute> set = new HashSet<Attribute>(
                        //(attributes.length * 4 / 3) + 1);
                //for (int i = attributes.length; --i >= 0;) {
                    //set.add(attributes[i]);
                //}
                //attributesAllowed = set;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.832 -0400", hash_original_method = "CC2190075ADAC44CCBDC93141CA9BE6C", hash_generated_method = "5F7516CCB9567294B7D19D0558D2998B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        @SuppressWarnings("unchecked")
        public Object clone() {
            try 
            {
                AttributedIterator clone;
                clone = (AttributedIterator) super.clone();
                {
                    clone.attributesAllowed = (HashSet<Attribute>) attributesAllowed
                            .clone();
                } //End block
            } //End block
            catch (CloneNotSupportedException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //try {
                //AttributedIterator clone = (AttributedIterator) super.clone();
                //if (attributesAllowed != null) {
                    //clone.attributesAllowed = (HashSet<Attribute>) attributesAllowed
                            //.clone();
                //}
                //return clone;
            //} catch (CloneNotSupportedException e) {
                //throw new AssertionError(e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.833 -0400", hash_original_method = "81A9D498AF1F73C3D962F8C3EDD6D3D9", hash_generated_method = "581D30014ABE155259D0358FB215C076")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char current() {
            char var7471FC70B539530D7206B8BC1B31F802_254764074 = (attrString.text.charAt(offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (offset == end) {
                //return DONE;
            //}
            //return attrString.text.charAt(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.833 -0400", hash_original_method = "4AF9D055D17E58470820B415A8EBAFA4", hash_generated_method = "8995E429D32D2DCE3152F7C7F4F8B7D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char first() {
            offset = begin;
            char var7471FC70B539530D7206B8BC1B31F802_831459055 = (attrString.text.charAt(offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (begin == end) {
                //return DONE;
            //}
            //offset = begin;
            //return attrString.text.charAt(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.833 -0400", hash_original_method = "1D4D2C19F23B97FE6ECF3D3284916FD4", hash_generated_method = "913AE969215206C06546FA82AC197F0A")
        @DSModeled(DSC.SAFE)
        public int getBeginIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return begin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.833 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "C3BE0AA826B854D04281BFCB8B3D97C2")
        @DSModeled(DSC.SAFE)
        public int getEndIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return end;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.833 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "FCEC00E0892F67B68765D5C23E99AF88")
        @DSModeled(DSC.SAFE)
        public int getIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return offset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.833 -0400", hash_original_method = "20101C80E99D94E4CD68776989F0B447", hash_generated_method = "D3DE5DD9EA5C29866348B9FFA973F294")
        @DSModeled(DSC.SAFE)
        private boolean inRange(Range range) {
            dsTaint.addTaint(range.dsTaint);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(range.value instanceof Annotation)) {
                //return true;
            //}
            //return range.start >= begin && range.start < end
                    //&& range.end > begin && range.end <= end;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.834 -0400", hash_original_method = "D282867E9466B5652FFBD5F7BCA71B9B", hash_generated_method = "C8E3141C3E9355734F1A9162F8414FD5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean inRange(List<Range> ranges) {
            dsTaint.addTaint(ranges.dsTaint);
            Iterator<Range> it;
            it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_40856576 = (it.hasNext());
                {
                    Range range;
                    range = it.next();
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //Iterator<Range> it = ranges.iterator();
            //while (it.hasNext()) {
                //Range range = it.next();
                //if (range.start >= begin && range.start < end) {
                    //return !(range.value instanceof Annotation)
                            //|| (range.end > begin && range.end <= end);
                //} else if (range.end > begin && range.end <= end) {
                    //return !(range.value instanceof Annotation)
                            //|| (range.start >= begin && range.start < end);
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.834 -0400", hash_original_method = "1F90FC3406D3E88B418E6F5A05B249D4", hash_generated_method = "10E9B82B22E8AE5CA1637E9DC78C4AFE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Set<AttributedIterator.Attribute> getAllAttributeKeys() {
            {
                boolean var440E9841255491133E314328640A0B67_771659622 = (begin == 0 && end == attrString.text.length()
                    && attributesAllowed == null);
                {
                    Set<AttributedIterator.Attribute> varB7A906E9090D1C20508A3B0AE52173FC_1312168671 = (attrString.attributeMap.keySet());
                } //End block
            } //End collapsed parenthetic
            Set<AttributedIterator.Attribute> result;
            result = new HashSet<Attribute>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it;
            it = attrString.attributeMap
                    .entrySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_876665527 = (it.hasNext());
                {
                    Map.Entry<Attribute, List<Range>> entry;
                    entry = it.next();
                    {
                        boolean var78A623E4F0CCA03B879F36D854BE57FF_1481523758 = (attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey()));
                        {
                            List<Range> ranges;
                            ranges = entry.getValue();
                            {
                                boolean var48BA0119E6136D30C1769489A0BAEB46_581980220 = (inRange(ranges));
                                {
                                    result.add(entry.getKey());
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return (Set<AttributedIterator.Attribute>)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.835 -0400", hash_original_method = "7F47FD199B74CEDC765420E2B0AD1B85", hash_generated_method = "03B3F2A41EA20BA40EAF5D256E8C7413")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Object currentValue(List<Range> ranges) {
            dsTaint.addTaint(ranges.dsTaint);
            Iterator<Range> it;
            it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2114264054 = (it.hasNext());
                {
                    Range range;
                    range = it.next();
                    {
                        {
                            boolean var2FAF37F82B41CCA38F243EDFFC0955AC_533299891 = (inRange(range));
                        } //End flattened ternary
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Iterator<Range> it = ranges.iterator();
            //while (it.hasNext()) {
                //Range range = it.next();
                //if (offset >= range.start && offset < range.end) {
                    //return inRange(range) ? range.value : null;
                //}
            //}
            //return null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.835 -0400", hash_original_method = "9256DFDAE9CB8C43C18A44C8B3AC6DAC", hash_generated_method = "C519138EF5B2A036881D5A7C424D4CD5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object getAttribute(
                AttributedCharacterIterator.Attribute attribute) {
            dsTaint.addTaint(attribute.dsTaint);
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_1089582740 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
            } //End collapsed parenthetic
            ArrayList<Range> ranges;
            ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            Object varD43DDCA5E606AD1343A3B96FC82903DE_936685339 = (currentValue(ranges));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //if (attributesAllowed != null
                    //&& !attributesAllowed.contains(attribute)) {
                //return null;
            //}
            //ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    //.get(attribute);
            //if (ranges == null) {
                //return null;
            //}
            //return currentValue(ranges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.835 -0400", hash_original_method = "AAAFE2E009783E25A93A8B590538D893", hash_generated_method = "DFE73F09910308543DCF90B9E4780366")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Map<Attribute, Object> getAttributes() {
            Map<Attribute, Object> result;
            result = new HashMap<Attribute, Object>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it;
            it = attrString.attributeMap
                    .entrySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1195291697 = (it.hasNext());
                {
                    Map.Entry<Attribute, List<Range>> entry;
                    entry = it.next();
                    {
                        boolean var78A623E4F0CCA03B879F36D854BE57FF_1310980489 = (attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey()));
                        {
                            Object value;
                            value = currentValue(entry.getValue());
                            {
                                result.put(entry.getKey(), value);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            return (Map<Attribute, Object>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Map<Attribute, Object> result = new HashMap<Attribute, Object>(
                    //(attrString.attributeMap.size() * 4 / 3) + 1);
            //Iterator<Map.Entry<Attribute, List<Range>>> it = attrString.attributeMap
                    //.entrySet().iterator();
            //while (it.hasNext()) {
                //Map.Entry<Attribute, List<Range>> entry = it.next();
                //if (attributesAllowed == null
                        //|| attributesAllowed.contains(entry.getKey())) {
                    //Object value = currentValue(entry.getValue());
                    //if (value != null) {
                        //result.put(entry.getKey(), value);
                    //}
                //}
            //}
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.835 -0400", hash_original_method = "B67CDF67136100A9ADF2991D47BD9A14", hash_generated_method = "772E2FD2A74E61E63EBACFAFBA223C91")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunLimit() {
            int varB8CB18E7DB26C804CE1E291715EC4085_151256721 = (getRunLimit(getAllAttributeKeys()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getRunLimit(getAllAttributeKeys());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.836 -0400", hash_original_method = "40F484258D42E498FCA29FFC5F596001", hash_generated_method = "744FD180DB55FC5D09FD6F68738CF6AE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int runLimit(List<Range> ranges) {
            dsTaint.addTaint(ranges.dsTaint);
            int result;
            result = end;
            ListIterator<Range> it;
            it = ranges.listIterator(ranges.size());
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_333226676 = (it.hasPrevious());
                {
                    Range range;
                    range = it.previous();
                    {
                        {
                            boolean var2FAF37F82B41CCA38F243EDFFC0955AC_523990272 = (inRange(range));
                        } //End flattened ternary
                    } //End block
                    result = range.start;
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int result = end;
            //ListIterator<Range> it = ranges.listIterator(ranges.size());
            //while (it.hasPrevious()) {
                //Range range = it.previous();
                //if (range.end <= begin) {
                    //break;
                //}
                //if (offset >= range.start && offset < range.end) {
                    //return inRange(range) ? range.end : result;
                //} else if (offset >= range.end) {
                    //break;
                //}
                //result = range.start;
            //}
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.836 -0400", hash_original_method = "F819F4AC98ED7B00F15856104CEA6D7F", hash_generated_method = "64D9D100B4D4B1AA9A0698F801E77AD9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunLimit(AttributedCharacterIterator.Attribute attribute) {
            dsTaint.addTaint(attribute.dsTaint);
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_348589317 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
            } //End collapsed parenthetic
            ArrayList<Range> ranges;
            ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            int var3243E9C702621CDA5FC8AD3026FC7D28_982414020 = (runLimit(ranges));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (attributesAllowed != null
                    //&& !attributesAllowed.contains(attribute)) {
                //return end;
            //}
            //ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    //.get(attribute);
            //if (ranges == null) {
                //return end;
            //}
            //return runLimit(ranges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.836 -0400", hash_original_method = "39CD1571C1B0AAE61A932D3B1E130DFE", hash_generated_method = "F35AF6843ABA93A7FDD87064ED3E7EA6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunLimit(Set<? extends Attribute> attributes) {
            dsTaint.addTaint(attributes.dsTaint);
            int limit;
            limit = end;
            Iterator<? extends Attribute> it;
            it = attributes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_47293431 = (it.hasNext());
                {
                    AttributedCharacterIterator.Attribute attribute;
                    attribute = it.next();
                    int newLimit;
                    newLimit = getRunLimit(attribute);
                    {
                        limit = newLimit;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int limit = end;
            //Iterator<? extends Attribute> it = attributes.iterator();
            //while (it.hasNext()) {
                //AttributedCharacterIterator.Attribute attribute = it.next();
                //int newLimit = getRunLimit(attribute);
                //if (newLimit < limit) {
                    //limit = newLimit;
                //}
            //}
            //return limit;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.837 -0400", hash_original_method = "FE3F08CD8D40BCC02EAAB9CF9D349F73", hash_generated_method = "397AB3C50400D07B36D59EB28C05BE35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunStart() {
            int varD479F53F5B086C7131ABCE733DD47303_1448509753 = (getRunStart(getAllAttributeKeys()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getRunStart(getAllAttributeKeys());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.837 -0400", hash_original_method = "3940F742081E74CA234FF11DA5FD3120", hash_generated_method = "7BA53B71D4ECFFD47DF6B4296883C470")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int runStart(List<Range> ranges) {
            dsTaint.addTaint(ranges.dsTaint);
            int result;
            result = begin;
            Iterator<Range> it;
            it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_269859165 = (it.hasNext());
                {
                    Range range;
                    range = it.next();
                    {
                        {
                            boolean var2FAF37F82B41CCA38F243EDFFC0955AC_1998949005 = (inRange(range));
                        } //End flattened ternary
                    } //End block
                    result = range.end;
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int result = begin;
            //Iterator<Range> it = ranges.iterator();
            //while (it.hasNext()) {
                //Range range = it.next();
                //if (range.start >= end) {
                    //break;
                //}
                //if (offset >= range.start && offset < range.end) {
                    //return inRange(range) ? range.start : result;
                //} else if (offset < range.start) {
                    //break;
                //}
                //result = range.end;
            //}
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.837 -0400", hash_original_method = "D8F9F8B7D0C4F74D05FEF10E27E7F588", hash_generated_method = "76BD9331420693E46C5121AEEC505064")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunStart(AttributedCharacterIterator.Attribute attribute) {
            dsTaint.addTaint(attribute.dsTaint);
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_1741523822 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
            } //End collapsed parenthetic
            ArrayList<Range> ranges;
            ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            int varF7B3B9AA84E9A9D092AE2BE6817D6B1C_2123659665 = (runStart(ranges));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (attributesAllowed != null
                    //&& !attributesAllowed.contains(attribute)) {
                //return begin;
            //}
            //ArrayList<Range> ranges = (ArrayList<Range>) attrString.attributeMap
                    //.get(attribute);
            //if (ranges == null) {
                //return begin;
            //}
            //return runStart(ranges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.838 -0400", hash_original_method = "62E2E3A1AAFB276945B722FDB547D45B", hash_generated_method = "58DFC88AD1A39FE149E948A151451D03")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunStart(Set<? extends Attribute> attributes) {
            dsTaint.addTaint(attributes.dsTaint);
            int start;
            start = begin;
            Iterator<? extends Attribute> it;
            it = attributes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1417229660 = (it.hasNext());
                {
                    AttributedCharacterIterator.Attribute attribute;
                    attribute = it.next();
                    int newStart;
                    newStart = getRunStart(attribute);
                    {
                        start = newStart;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int start = begin;
            //Iterator<? extends Attribute> it = attributes.iterator();
            //while (it.hasNext()) {
                //AttributedCharacterIterator.Attribute attribute = it.next();
                //int newStart = getRunStart(attribute);
                //if (newStart > start) {
                    //start = newStart;
                //}
            //}
            //return start;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.838 -0400", hash_original_method = "6CAD62DAB178D2919A2036BE42DEC497", hash_generated_method = "1544B13BF2D9DBCE2EF47A79DE77A3E4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char last() {
            offset = end - 1;
            char var7471FC70B539530D7206B8BC1B31F802_1398401416 = (attrString.text.charAt(offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (begin == end) {
                //return DONE;
            //}
            //offset = end - 1;
            //return attrString.text.charAt(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.838 -0400", hash_original_method = "B623F272BE854A8CF15368B2FE2B8A97", hash_generated_method = "8F55ECB2F7CF36E1BBB9D4A63FFCF525")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char next() {
            {
                offset = end;
            } //End block
            char varCD2A465A117ACDFD77E8F731FFBCF3CF_291387507 = (attrString.text.charAt(++offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (offset >= (end - 1)) {
                //offset = end;
                //return DONE;
            //}
            //return attrString.text.charAt(++offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.838 -0400", hash_original_method = "E77E60DF0F891730B03F44D98923AB66", hash_generated_method = "CCF736738266EB65057B79DA868C50A3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char previous() {
            char var2ECEAF615C1A7B98A9B5DA51518FE2D8_1014772596 = (attrString.text.charAt(--offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (offset == begin) {
                //return DONE;
            //}
            //return attrString.text.charAt(--offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.838 -0400", hash_original_method = "C542CEFF91217DDB3083AD983C51F194", hash_generated_method = "422F13333D47016DDE2A4A0F2B19DB4D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char setIndex(int location) {
            dsTaint.addTaint(location);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            char var7471FC70B539530D7206B8BC1B31F802_1704501136 = (attrString.text.charAt(offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (location < begin || location > end) {
                //throw new IllegalArgumentException();
            //}
            //offset = location;
            //if (offset == end) {
                //return DONE;
            //}
            //return attrString.text.charAt(offset);
        }

        
    }


    
}

