package com.android.internal.util;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface Predicate<T> {

    boolean apply(T t);
}
