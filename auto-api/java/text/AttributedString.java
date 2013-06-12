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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.489 -0400", hash_original_method = "5638BBE38DFF9B04A672F4EC9A02409B", hash_generated_method = "15D569BE6AA694B539CD785A7A071636")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedString(AttributedCharacterIterator iterator) {
        dsTaint.addTaint(iterator.dsTaint);
        {
            boolean var5791DB9351E60242F3260BB947788691_1525478858 = (iterator.getBeginIndex() > iterator.getEndIndex());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid substring range");
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder();
        {
            int i;
            i = iterator.getBeginIndex();
            boolean varD47BAE727A1CA5D8FBD74E81EBBAC580_1862595323 = (i < iterator.getEndIndex());
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
            boolean var03729FD53960D8DCA3A41A13A0229637_2136838941 = (it.hasNext());
            {
                AttributedCharacterIterator.Attribute attribute;
                attribute = it.next();
                iterator.setIndex(0);
                {
                    boolean var28ACB1F338988605D7BB159EDA96A571_1380975948 = (iterator.current() != CharacterIterator.DONE);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.524 -0400", hash_original_method = "3A8973AD4EBE1F3B94E1633368C42F9D", hash_generated_method = "13AF55916A2561DEECD5159DB7FA2E67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private AttributedString(AttributedCharacterIterator iterator, int start,
            int end, Set<Attribute> attributes) {
        dsTaint.addTaint(iterator.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(attributes.dsTaint);
        dsTaint.addTaint(end);
        {
            boolean var6E1EE5C4631EC62ECEF890E2A840FF67_7797669 = (start < iterator.getBeginIndex() || end > iterator.getEndIndex()
                || start > end);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
        } //End collapsed parenthetic
        StringBuilder buffer;
        buffer = new StringBuilder();
        iterator.setIndex(start);
        {
            boolean varFB2E1080C5571E90BCE1803511FF22B4_556052315 = (iterator.getIndex() < end);
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
            boolean var03729FD53960D8DCA3A41A13A0229637_1770221190 = (it.hasNext());
            {
                AttributedCharacterIterator.Attribute attribute;
                attribute = it.next();
                iterator.setIndex(start);
                {
                    boolean var01C467E388CE293308E11B7796E75DEA_1541448480 = (iterator.getIndex() < end);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.539 -0400", hash_original_method = "D0E1FC5545253EA6E008AE3675A9452F", hash_generated_method = "9FC619ECB0EF597D7C180DAD0A2BDF6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedString(AttributedCharacterIterator iterator, int start,
            int end) {
        this(iterator, start, end, iterator.getAllAttributeKeys());
        dsTaint.addTaint(iterator.dsTaint);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.548 -0400", hash_original_method = "B4766721E168BC843A6EA06CFE59500E", hash_generated_method = "116942813AFEFCBD0FEBB307C25734CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.555 -0400", hash_original_method = "A0ACF5D97B9D79B3295575A771939692", hash_generated_method = "15EB741EB72A89FF574EBBEBF5B55B38")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.567 -0400", hash_original_method = "85CF866984BA31F6F3E97322323F86BA", hash_generated_method = "360A8F93B6C3AD5763B8FD969E7F739D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedString(String value,
            Map<? extends AttributedCharacterIterator.Attribute, ?> attributes) {
        dsTaint.addTaint(value);
        dsTaint.addTaint(attributes.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean varF38D1CF4F9C3BE6C8047C579649A2A1F_2058992600 = (value.length() == 0 && !attributes.isEmpty());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Cannot add attributes to empty string");
            } //End block
        } //End collapsed parenthetic
        attributeMap = new HashMap<Attribute, List<Range>>(
                (attributes.size() * 4 / 3) + 1);
        Iterator<?> it;
        it = attributes.entrySet().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1573548444 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.578 -0400", hash_original_method = "F800EB2F1E580436E49CB51D04E3F37C", hash_generated_method = "6BB63B98BE99408595DA8FDA8A5BAADF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addAttribute(AttributedCharacterIterator.Attribute attribute, Object value) {
        dsTaint.addTaint(value.dsTaint);
        dsTaint.addTaint(attribute.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        {
            boolean var2E3F580615CDCAA5961A2E6CF25EC4EB_1310721740 = (text.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.608 -0400", hash_original_method = "1EA9CE9DE6197B4051F39E120F823C8E", hash_generated_method = "EE0CB7E380C353C6858746BE263A4B6C")
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
            boolean varC9BCC04F7A62407C3BA13DEEA6DE5168_194584190 = (start < 0 || end > text.length() || start >= end);
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
            boolean var03729FD53960D8DCA3A41A13A0229637_1003268187 = (it.hasNext());
            {
                Range range;
                range = it.next();
                {
                    it.previous();
                } //End block
                {
                    boolean varEF40E1D978FA25419409FAB7F79E01F6_1051502233 = (start < range.end
                    || (start == range.end && value.equals(range.value)));
                    {
                        Range r1, r3;
                        r1 = null;
                        it.remove();
                        r1 = new Range(range.start, start, range.value);
                        r3 = new Range(end, range.end, range.value);
                        {
                            boolean var1FE3E7148FB59A827E5E6E2483C887F7_1001155999 = (end > range.end && it.hasNext());
                            {
                                range = it.next();
                                {
                                    {
                                        boolean var9C218184248DFD9DE95E1445E7891FFF_1773575948 = (end > range.start
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
                            boolean var1027DC60E68FD42C72653BFC2EFF2C3B_220493218 = (value.equals(r1.value));
                            {
                                {
                                    boolean var25819F3F4E6FA285B1052DA41FF64523_1938119965 = (value.equals(r3.value));
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
                                    boolean var25819F3F4E6FA285B1052DA41FF64523_1448780559 = (value.equals(r3.value));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.626 -0400", hash_original_method = "9BDF8CEEC650CFF21B203033378C7411", hash_generated_method = "00A25CC3DD872DDCF3D722F2B2E66444")
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
            boolean var03729FD53960D8DCA3A41A13A0229637_383704450 = (it.hasNext());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.630 -0400", hash_original_method = "3C3A14639543169375B4E8491231683C", hash_generated_method = "B7DB6FC4B5A074B488F71103D9A3FA8E")
    @DSModeled(DSC.SAFE)
    public AttributedCharacterIterator getIterator() {
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AttributedIterator(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.633 -0400", hash_original_method = "AFA08901CAEF730E40B185484FAABB29", hash_generated_method = "3C634556AA33C0D3853C3A91EA9821EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes) {
        dsTaint.addTaint(attributes[0].dsTaint);
        AttributedCharacterIterator var350757948901E6152C72575EFA89091E_1016317375 = (new AttributedIterator(this, attributes, 0, text.length()));
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AttributedIterator(this, attributes, 0, text.length());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.636 -0400", hash_original_method = "EF8FB9411A496C9D99CDE8B83C48CE6B", hash_generated_method = "8735591CC1CCF14E35BC16AD6EABB774")
    @DSModeled(DSC.SAFE)
    public AttributedCharacterIterator getIterator(
            AttributedCharacterIterator.Attribute[] attributes, int start,
            int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(attributes[0].dsTaint);
        dsTaint.addTaint(end);
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AttributedIterator(this, attributes, start, end);
    }

    
    static class Range {
        int start;
        int end;
        Object value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.644 -0400", hash_original_method = "9919123D3D1FFC7D42BA1CB1CAFB2DA5", hash_generated_method = "B9E63D0B5D17826CE815C818B6E22002")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.647 -0400", hash_original_method = "E441422DE6FDEDB0F1BB74606A67171C", hash_generated_method = "E9D8B9FBA620DCF5A1EC182EEF0074A0")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.655 -0400", hash_original_method = "43841E67E512106866A3902EDBE2D718", hash_generated_method = "7F3935493FB63E31131D7AD07AAF6C43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         AttributedIterator(AttributedString attrString,
                AttributedCharacterIterator.Attribute[] attributes, int begin,
                int end) {
            dsTaint.addTaint(attrString.dsTaint);
            dsTaint.addTaint(attributes[0].dsTaint);
            dsTaint.addTaint(end);
            dsTaint.addTaint(begin);
            {
                boolean varFFD07E130858E065814762E8E384F7BD_503355416 = (begin < 0 || end > attrString.text.length() || begin > end);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.663 -0400", hash_original_method = "CC2190075ADAC44CCBDC93141CA9BE6C", hash_generated_method = "B0BB4D5F238B52AA37B8ADB89E1E21A8")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.670 -0400", hash_original_method = "81A9D498AF1F73C3D962F8C3EDD6D3D9", hash_generated_method = "9FEBDB13012799C18CA3664E1EFDB02C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char current() {
            char var7471FC70B539530D7206B8BC1B31F802_839750876 = (attrString.text.charAt(offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (offset == end) {
                //return DONE;
            //}
            //return attrString.text.charAt(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.675 -0400", hash_original_method = "4AF9D055D17E58470820B415A8EBAFA4", hash_generated_method = "F2B97D9C546C924E1CE88AAC1BF8D655")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char first() {
            offset = begin;
            char var7471FC70B539530D7206B8BC1B31F802_1207769689 = (attrString.text.charAt(offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (begin == end) {
                //return DONE;
            //}
            //offset = begin;
            //return attrString.text.charAt(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.678 -0400", hash_original_method = "1D4D2C19F23B97FE6ECF3D3284916FD4", hash_generated_method = "BB149D5D61B304225B89D3DF0DD37E50")
        @DSModeled(DSC.SAFE)
        public int getBeginIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return begin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.681 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "3C27A85C1F70E764283E3AE3637F8072")
        @DSModeled(DSC.SAFE)
        public int getEndIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return end;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.684 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "1F3C5CF325FB8ED42E9146662B125A6E")
        @DSModeled(DSC.SAFE)
        public int getIndex() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return offset;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.689 -0400", hash_original_method = "20101C80E99D94E4CD68776989F0B447", hash_generated_method = "33BEDEC0C2D2AD9AD9A3BC141C5FD3C7")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.700 -0400", hash_original_method = "D282867E9466B5652FFBD5F7BCA71B9B", hash_generated_method = "FF51F241C9E1D22979DA754C9EFEC6D9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private boolean inRange(List<Range> ranges) {
            dsTaint.addTaint(ranges.dsTaint);
            Iterator<Range> it;
            it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1997287157 = (it.hasNext());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.709 -0400", hash_original_method = "1F90FC3406D3E88B418E6F5A05B249D4", hash_generated_method = "CC3125FF94C4F959F528F426555DB951")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Set<AttributedIterator.Attribute> getAllAttributeKeys() {
            {
                boolean var440E9841255491133E314328640A0B67_1625291092 = (begin == 0 && end == attrString.text.length()
                    && attributesAllowed == null);
                {
                    Set<AttributedIterator.Attribute> varB7A906E9090D1C20508A3B0AE52173FC_1187147580 = (attrString.attributeMap.keySet());
                } //End block
            } //End collapsed parenthetic
            Set<AttributedIterator.Attribute> result;
            result = new HashSet<Attribute>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it;
            it = attrString.attributeMap
                    .entrySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_2036468901 = (it.hasNext());
                {
                    Map.Entry<Attribute, List<Range>> entry;
                    entry = it.next();
                    {
                        boolean var78A623E4F0CCA03B879F36D854BE57FF_959308967 = (attributesAllowed == null
                        || attributesAllowed.contains(entry.getKey()));
                        {
                            List<Range> ranges;
                            ranges = entry.getValue();
                            {
                                boolean var48BA0119E6136D30C1769489A0BAEB46_1007122977 = (inRange(ranges));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.719 -0400", hash_original_method = "7F47FD199B74CEDC765420E2B0AD1B85", hash_generated_method = "E10264EB67B4D4103994322389EB1B0A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Object currentValue(List<Range> ranges) {
            dsTaint.addTaint(ranges.dsTaint);
            Iterator<Range> it;
            it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1100877708 = (it.hasNext());
                {
                    Range range;
                    range = it.next();
                    {
                        {
                            boolean var2FAF37F82B41CCA38F243EDFFC0955AC_1885900357 = (inRange(range));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.727 -0400", hash_original_method = "9256DFDAE9CB8C43C18A44C8B3AC6DAC", hash_generated_method = "C5ADBF34325439E78CF8D0E261BE5247")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object getAttribute(
                AttributedCharacterIterator.Attribute attribute) {
            dsTaint.addTaint(attribute.dsTaint);
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_423181024 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
            } //End collapsed parenthetic
            ArrayList<Range> ranges;
            ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            Object varD43DDCA5E606AD1343A3B96FC82903DE_1686203673 = (currentValue(ranges));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.734 -0400", hash_original_method = "AAAFE2E009783E25A93A8B590538D893", hash_generated_method = "858A7C2DFB96478C36F9FC7350D86D82")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Map<Attribute, Object> getAttributes() {
            Map<Attribute, Object> result;
            result = new HashMap<Attribute, Object>(
                    (attrString.attributeMap.size() * 4 / 3) + 1);
            Iterator<Map.Entry<Attribute, List<Range>>> it;
            it = attrString.attributeMap
                    .entrySet().iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_343300912 = (it.hasNext());
                {
                    Map.Entry<Attribute, List<Range>> entry;
                    entry = it.next();
                    {
                        boolean var78A623E4F0CCA03B879F36D854BE57FF_1169775863 = (attributesAllowed == null
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.740 -0400", hash_original_method = "B67CDF67136100A9ADF2991D47BD9A14", hash_generated_method = "831AD98E9C60F28B2EE6BE9C5C977C77")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunLimit() {
            int varB8CB18E7DB26C804CE1E291715EC4085_1464943297 = (getRunLimit(getAllAttributeKeys()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getRunLimit(getAllAttributeKeys());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.749 -0400", hash_original_method = "40F484258D42E498FCA29FFC5F596001", hash_generated_method = "AD80A22BC65E05B53160A7D7ADAE8692")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int runLimit(List<Range> ranges) {
            dsTaint.addTaint(ranges.dsTaint);
            int result;
            result = end;
            ListIterator<Range> it;
            it = ranges.listIterator(ranges.size());
            {
                boolean varFF94A24275993577BF8E66186EAD8E8C_1956182425 = (it.hasPrevious());
                {
                    Range range;
                    range = it.previous();
                    {
                        {
                            boolean var2FAF37F82B41CCA38F243EDFFC0955AC_288989067 = (inRange(range));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.757 -0400", hash_original_method = "F819F4AC98ED7B00F15856104CEA6D7F", hash_generated_method = "FA7D7D05FA3A0D248E9C1D11F1FC8638")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunLimit(AttributedCharacterIterator.Attribute attribute) {
            dsTaint.addTaint(attribute.dsTaint);
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_1068328433 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
            } //End collapsed parenthetic
            ArrayList<Range> ranges;
            ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            int var3243E9C702621CDA5FC8AD3026FC7D28_1405963486 = (runLimit(ranges));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.762 -0400", hash_original_method = "39CD1571C1B0AAE61A932D3B1E130DFE", hash_generated_method = "7E9510CD604561C73D6E9A43C7FED821")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunLimit(Set<? extends Attribute> attributes) {
            dsTaint.addTaint(attributes.dsTaint);
            int limit;
            limit = end;
            Iterator<? extends Attribute> it;
            it = attributes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_719243114 = (it.hasNext());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.767 -0400", hash_original_method = "FE3F08CD8D40BCC02EAAB9CF9D349F73", hash_generated_method = "AD3BA9AD2C0DD6E4FCBF1C32C32111C7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunStart() {
            int varD479F53F5B086C7131ABCE733DD47303_98850970 = (getRunStart(getAllAttributeKeys()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return getRunStart(getAllAttributeKeys());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.776 -0400", hash_original_method = "3940F742081E74CA234FF11DA5FD3120", hash_generated_method = "0B6788C6C966C947B33FB6B5BC3F608C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private int runStart(List<Range> ranges) {
            dsTaint.addTaint(ranges.dsTaint);
            int result;
            result = begin;
            Iterator<Range> it;
            it = ranges.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1758671770 = (it.hasNext());
                {
                    Range range;
                    range = it.next();
                    {
                        {
                            boolean var2FAF37F82B41CCA38F243EDFFC0955AC_625851001 = (inRange(range));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.783 -0400", hash_original_method = "D8F9F8B7D0C4F74D05FEF10E27E7F588", hash_generated_method = "E814861DA43CCE9A9C15BE451097D462")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunStart(AttributedCharacterIterator.Attribute attribute) {
            dsTaint.addTaint(attribute.dsTaint);
            {
                boolean var12D36913C4CC9B92E6CFDE0A26E3CD6F_612814309 = (attributesAllowed != null
                    && !attributesAllowed.contains(attribute));
            } //End collapsed parenthetic
            ArrayList<Range> ranges;
            ranges = (ArrayList<Range>) attrString.attributeMap
                    .get(attribute);
            int varF7B3B9AA84E9A9D092AE2BE6817D6B1C_437230911 = (runStart(ranges));
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.789 -0400", hash_original_method = "62E2E3A1AAFB276945B722FDB547D45B", hash_generated_method = "66C96593DB3369D2A9B2ED3036317A74")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getRunStart(Set<? extends Attribute> attributes) {
            dsTaint.addTaint(attributes.dsTaint);
            int start;
            start = begin;
            Iterator<? extends Attribute> it;
            it = attributes.iterator();
            {
                boolean varB2FF4435B274CC4BE01D264DEA08F957_1047798259 = (it.hasNext());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.794 -0400", hash_original_method = "6CAD62DAB178D2919A2036BE42DEC497", hash_generated_method = "6A610E418F2DFAFE019A2EC4EFB371D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char last() {
            offset = end - 1;
            char var7471FC70B539530D7206B8BC1B31F802_1725230123 = (attrString.text.charAt(offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (begin == end) {
                //return DONE;
            //}
            //offset = end - 1;
            //return attrString.text.charAt(offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.796 -0400", hash_original_method = "B623F272BE854A8CF15368B2FE2B8A97", hash_generated_method = "0EA320836A32CDEE89BF80DFD728A46D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char next() {
            {
                offset = end;
            } //End block
            char varCD2A465A117ACDFD77E8F731FFBCF3CF_1970581066 = (attrString.text.charAt(++offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (offset >= (end - 1)) {
                //offset = end;
                //return DONE;
            //}
            //return attrString.text.charAt(++offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.798 -0400", hash_original_method = "E77E60DF0F891730B03F44D98923AB66", hash_generated_method = "CE037C63D2B246340D9D067631999BB0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char previous() {
            char var2ECEAF615C1A7B98A9B5DA51518FE2D8_1199763842 = (attrString.text.charAt(--offset));
            return dsTaint.getTaintChar();
            // ---------- Original Method ----------
            //if (offset == begin) {
                //return DONE;
            //}
            //return attrString.text.charAt(--offset);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:05:35.801 -0400", hash_original_method = "C542CEFF91217DDB3083AD983C51F194", hash_generated_method = "3BE5D64452AA57C0D77540B460D2EC7F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public char setIndex(int location) {
            dsTaint.addTaint(location);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            } //End block
            char var7471FC70B539530D7206B8BC1B31F802_1404862312 = (attrString.text.charAt(offset));
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


