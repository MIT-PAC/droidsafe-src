package libcore.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class CollectionUtils {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.432 -0400", hash_original_method = "01B59B68B4B802DAB48FA08289978867", hash_generated_method = "5F02E4CDD07A625A72FAF95BCC9B1BCC")
    private  CollectionUtils() {
        // ---------- Original Method ----------
    }

    
    public static <T> Iterable<T> dereferenceIterable(
            final Iterable<? extends Reference<T>> iterable, final boolean trim) {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    private final Iterator<? extends Reference<T>> delegate = iterable.iterator();
                    private boolean removeIsOkay;
                    private T next;
                    private void computeNext() {
                        removeIsOkay = false;
                        while (next == null && delegate.hasNext()) {
                            next = delegate.next().get();
                            if (trim && next == null) {
                                delegate.remove();
                            }
                        }
                    }
                    @Override public boolean hasNext() {
                        computeNext();
                        return next != null;
                    }
                    @Override public T next() {
                        if (!hasNext()) {
                            throw new IllegalStateException();
                        }
                        T result = next;
                        removeIsOkay = true;
                        next = null;
                        return result;
                    }
                    public void remove() {
                        if (!removeIsOkay) {
                            throw new IllegalStateException();
                        }
                        delegate.remove();
                    }
                };
            }
        };
    }

    
    public static <T> void removeDuplicates(List<T> list, Comparator<? super T> comparator) {
        Collections.sort(list, comparator);
        int j = 1;
        for (int i = 1; i < list.size(); i++) {
            if (comparator.compare(list.get(j - 1), list.get(i)) != 0) {
                T object = list.get(i);
                list.set(j++, object);
            }
        }
        if (j < list.size()) {
            list.subList(j, list.size()).clear();
        }
    }

    
}

