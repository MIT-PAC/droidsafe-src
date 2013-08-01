package android.view;

// Droidsafe Imports
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Debug;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Printer;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ViewDebug {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.264 -0400", hash_original_method = "F785FDC015B150C7B28C32B4894B3E15", hash_generated_method = "F785FDC015B150C7B28C32B4894B3E15")
    public ViewDebug ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static long getViewInstanceCount() {
        return Debug.countInstancesOfClass(View.class);
    }

    
    @DSModeled(DSC.SAFE)
    public static long getViewRootImplCount() {
        return Debug.countInstancesOfClass(ViewRootImpl.class);
    }

    
    @DSModeled(DSC.SAFE)
    public static void startLooperProfiling(String path, FileDescriptor fileDescriptor) {
        if (sLooperProfilerStorage.get() == null) {
            LooperProfiler profiler = new LooperProfiler(path, fileDescriptor);
            sLooperProfilerStorage.set(profiler);
            Looper.myLooper().setMessageLogging(profiler);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void stopLooperProfiling() {
        LooperProfiler profiler = sLooperProfilerStorage.get();
        if (profiler != null) {
            sLooperProfilerStorage.remove();
            Looper.myLooper().setMessageLogging(null);
            profiler.save();
        }
    }

    
    public static void trace(View view, RecyclerTraceType type, int... parameters) {
        if (sRecyclerOwnerView == null || sRecyclerViews == null) {
            return;
        }
        if (!sRecyclerViews.contains(view)) {
            sRecyclerViews.add(view);
        }
        final int index = sRecyclerViews.indexOf(view);
        RecyclerTrace trace = new RecyclerTrace();
        trace.view = index;
        trace.type = type;
        trace.position = parameters[0];
        trace.indexOnScreen = parameters[1];
        sRecyclerTraces.add(trace);
    }

    
    @DSModeled(DSC.SAFE)
    public static void startRecyclerTracing(String prefix, View view) {
        if (!TRACE_RECYCLER) {
            return;
        }
        if (sRecyclerOwnerView != null) {
            throw new IllegalStateException("You must call stopRecyclerTracing() before running" +
                " a new trace!");
        }
        sRecyclerTracePrefix = prefix;
        sRecyclerOwnerView = view;
        sRecyclerViews = new ArrayList<View>();
        sRecyclerTraces = new LinkedList<RecyclerTrace>();
    }

    
    @DSModeled(DSC.SAFE)
    public static void stopRecyclerTracing() {
        if (!TRACE_RECYCLER) {
            return;
        }
        if (sRecyclerOwnerView == null || sRecyclerViews == null) {
            throw new IllegalStateException("You must call startRecyclerTracing() before" +
                " stopRecyclerTracing()!");
        }
        File recyclerDump = new File(Environment.getExternalStorageDirectory(), "view-recycler/");
        recyclerDump.mkdirs();
        recyclerDump = new File(recyclerDump, sRecyclerTracePrefix + ".recycler");
        try {
            final BufferedWriter out = new BufferedWriter(new FileWriter(recyclerDump), 8 * 1024);
            for (View view : sRecyclerViews) {
                final String name = view.getClass().getName();
                out.write(name);
                out.newLine();
            }
            out.close();
        } catch (IOException e) {
            Log.e("View", "Could not dump recycler content");
            return;
        }
        recyclerDump = new File(Environment.getExternalStorageDirectory(), "view-recycler/");
        recyclerDump = new File(recyclerDump, sRecyclerTracePrefix + ".traces");
        try {
            if (recyclerDump.exists()) {
                recyclerDump.delete();
            }
            final FileOutputStream file = new FileOutputStream(recyclerDump);
            final DataOutputStream out = new DataOutputStream(file);
            for (RecyclerTrace trace : sRecyclerTraces) {
                out.writeInt(trace.view);
                out.writeInt(trace.type.ordinal());
                out.writeInt(trace.position);
                out.writeInt(trace.indexOnScreen);
                out.flush();
            }
            out.close();
        } catch (IOException e) {
            Log.e("View", "Could not dump recycler traces");
            return;
        }
        sRecyclerViews.clear();
        sRecyclerViews = null;
        sRecyclerTraces.clear();
        sRecyclerTraces = null;
        sRecyclerOwnerView = null;
    }

    
    @DSModeled(DSC.SAFE)
    public static void trace(View view, HierarchyTraceType type) {
        if (sHierarchyTraces == null) {
            return;
        }
        try {
            sHierarchyTraces.write(type.name());
            sHierarchyTraces.write(' ');
            sHierarchyTraces.write(view.getClass().getName());
            sHierarchyTraces.write('@');
            sHierarchyTraces.write(Integer.toHexString(view.hashCode()));
            sHierarchyTraces.newLine();
        } catch (IOException e) {
            Log.w("View", "Error while dumping trace of type " + type + " for view " + view);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void startHierarchyTracing(String prefix, View view) {
        if (!TRACE_HIERARCHY) {
            return;
        }
        if (sHierarhcyRoot != null) {
            throw new IllegalStateException("You must call stopHierarchyTracing() before running" +
                " a new trace!");
        }
        File hierarchyDump = new File(Environment.getExternalStorageDirectory(), "view-hierarchy/");
        hierarchyDump.mkdirs();
        hierarchyDump = new File(hierarchyDump, prefix + ".traces");
        sHierarchyTracePrefix = prefix;
        try {
            sHierarchyTraces = new BufferedWriter(new FileWriter(hierarchyDump), 8 * 1024);
        } catch (IOException e) {
            Log.e("View", "Could not dump view hierarchy");
            return;
        }
        sHierarhcyRoot = (ViewRootImpl) view.getRootView().getParent();
    }

    
    @DSModeled(DSC.SAFE)
    public static void stopHierarchyTracing() {
        if (!TRACE_HIERARCHY) {
            return;
        }
        if (sHierarhcyRoot == null || sHierarchyTraces == null) {
            throw new IllegalStateException("You must call startHierarchyTracing() before" +
                " stopHierarchyTracing()!");
        }
        try {
            sHierarchyTraces.close();
        } catch (IOException e) {
            Log.e("View", "Could not write view traces");
        }
        sHierarchyTraces = null;
        File hierarchyDump = new File(Environment.getExternalStorageDirectory(), "view-hierarchy/");
        hierarchyDump.mkdirs();
        hierarchyDump = new File(hierarchyDump, sHierarchyTracePrefix + ".tree");
        BufferedWriter out;
        try {
            out = new BufferedWriter(new FileWriter(hierarchyDump), 8 * 1024);
        } catch (IOException e) {
            Log.e("View", "Could not dump view hierarchy");
            return;
        }
        View view = sHierarhcyRoot.getView();
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            dumpViewHierarchy(group, out, 0);
            try {
                out.close();
            } catch (IOException e) {
                Log.e("View", "Could not dump view hierarchy");
            }
        }
        sHierarhcyRoot = null;
    }

    
    @DSModeled(DSC.SAFE)
    static void dispatchCommand(View view, String command, String parameters,
            OutputStream clientStream) throws IOException {
        view = view.getRootView();
        if (REMOTE_COMMAND_DUMP.equalsIgnoreCase(command)) {
            dump(view, clientStream);
        } else if (REMOTE_COMMAND_CAPTURE_LAYERS.equalsIgnoreCase(command)) {
            captureLayers(view, new DataOutputStream(clientStream));
        } else {
            final String[] params = parameters.split(" ");
            if (REMOTE_COMMAND_CAPTURE.equalsIgnoreCase(command)) {
                capture(view, clientStream, params[0]);
            } else if (REMOTE_COMMAND_OUTPUT_DISPLAYLIST.equalsIgnoreCase(command)) {
                outputDisplayList(view, params[0]);
            } else if (REMOTE_COMMAND_INVALIDATE.equalsIgnoreCase(command)) {
                invalidate(view, params[0]);
            } else if (REMOTE_COMMAND_REQUEST_LAYOUT.equalsIgnoreCase(command)) {
                requestLayout(view, params[0]);
            } else if (REMOTE_PROFILE.equalsIgnoreCase(command)) {
                profile(view, clientStream, params[0]);
            }
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static View findView(View root, String parameter) {
        if (parameter.indexOf('@') != -1) {
            final String[] ids = parameter.split("@");
            final String className = ids[0];
            final int hashCode = (int) Long.parseLong(ids[1], 16);
            View view = root.getRootView();
            if (view instanceof ViewGroup) {
                return findView((ViewGroup) view, className, hashCode);
            }
        } else {
            final int id = root.getResources().getIdentifier(parameter, null, null);
            return root.getRootView().findViewById(id);
        }
        return null;
    }

    
    @DSModeled(DSC.SAFE)
    private static void invalidate(View root, String parameter) {
        final View view = findView(root, parameter);
        if (view != null) {
            view.postInvalidate();
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static void requestLayout(View root, String parameter) {
        final View view = findView(root, parameter);
        if (view != null) {
            root.post(new Runnable() {
                public void run() {
                    view.requestLayout();
                }
            });
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static void profile(View root, OutputStream clientStream, String parameter) throws IOException {
        final View view = findView(root, parameter);
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(clientStream), 32 * 1024);
            if (view != null) {
                profileViewAndChildren(view, out);
            } else {
                out.write("-1 -1 -1");
                out.newLine();
            }
            out.write("DONE.");
            out.newLine();
        } catch (Exception e) {
            android.util.Log.w("View", "Problem profiling the view:", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    
    private static void profileViewAndChildren(final View view, BufferedWriter out) throws IOException {
        profileViewAndChildren(view, out, true);
    }

    
    private static void profileViewAndChildren(final View view, BufferedWriter out, boolean root) throws IOException {
        long durationMeasure =
                (root || (view.mPrivateFlags & View.MEASURED_DIMENSION_SET) != 0) ? profileViewOperation(
                        view, new ViewOperation<Void>() {
                            public Void[] pre() {
                                forceLayout(view);
                                return null;
                            }
                            private void forceLayout(View view) {
                                view.forceLayout();
                                if (view instanceof ViewGroup) {
                                    ViewGroup group = (ViewGroup) view;
                                    final int count = group.getChildCount();
                                    for (int i = 0; i < count; i++) {
                                        forceLayout(group.getChildAt(i));
                                    }
                                }
                            }
                            public void run(Void... data) {
                                view.measure(view.mOldWidthMeasureSpec, view.mOldHeightMeasureSpec);
                            }
                            public void post(Void... data) {
                            }
                        })
                        : 0;
        long durationLayout =
                (root || (view.mPrivateFlags & View.LAYOUT_REQUIRED) != 0) ? profileViewOperation(
                        view, new ViewOperation<Void>() {
                            public Void[] pre() {
                                return null;
                            }
                            public void run(Void... data) {
                                view.layout(view.mLeft, view.mTop, view.mRight, view.mBottom);
                            }
                            public void post(Void... data) {
                            }
                        }) : 0;
        long durationDraw =
                (root || !view.willNotDraw() || (view.mPrivateFlags & View.DRAWN) != 0) ? profileViewOperation(
                        view,
                        new ViewOperation<Object>() {
                            public Object[] pre() {
                                final DisplayMetrics metrics =
                                        (view != null && view.getResources() != null) ?
                                                view.getResources().getDisplayMetrics() : null;
                                final Bitmap bitmap = metrics != null ?
                                        Bitmap.createBitmap(metrics.widthPixels,
                                                metrics.heightPixels, Bitmap.Config.RGB_565) : null;
                                final Canvas canvas = bitmap != null ? new Canvas(bitmap) : null;
                                return new Object[] {
                                        bitmap, canvas
                                };
                            }
                            public void run(Object... data) {
                                if (data[1] != null) {
                                    view.draw((Canvas) data[1]);
                                }
                            }
                            public void post(Object... data) {
                                if (data[1] != null) {
                                    ((Canvas) data[1]).setBitmap(null);
                                }
                                if (data[0] != null) {
                                    ((Bitmap) data[0]).recycle();
                                }
                            }
                        }) : 0;
        out.write(String.valueOf(durationMeasure));
        out.write(' ');
        out.write(String.valueOf(durationLayout));
        out.write(' ');
        out.write(String.valueOf(durationDraw));
        out.newLine();
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            final int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                profileViewAndChildren(group.getChildAt(i), out, false);
            }
        }
    }

    
    private static <T> long profileViewOperation(View view, final ViewOperation<T> operation) {
        final CountDownLatch latch = new CountDownLatch(1);
        final long[] duration = new long[1];
        view.post(new Runnable() {
            public void run() {
                try {
                    T[] data = operation.pre();
                    long start = Debug.threadCpuTimeNanos();
                    operation.run(data);
                    duration[0] = Debug.threadCpuTimeNanos() - start;
                    operation.post(data);
                } finally {
                    latch.countDown();
                }
            }
        });
        try {
            if (!latch.await(CAPTURE_TIMEOUT, TimeUnit.MILLISECONDS)) {
                Log.w("View", "Could not complete the profiling of the view " + view);
                return -1;
            }
        } catch (InterruptedException e) {
            Log.w("View", "Could not complete the profiling of the view " + view);
            Thread.currentThread().interrupt();
            return -1;
        }
        return duration[0];
    }

    
    private static void captureLayers(View root, final DataOutputStream clientStream) throws IOException {
        try {
            Rect outRect = new Rect();
            try {
                root.mAttachInfo.mSession.getDisplayFrame(root.mAttachInfo.mWindow, outRect);
            } catch (RemoteException e) {
            }
            clientStream.writeInt(outRect.width());
            clientStream.writeInt(outRect.height());
            captureViewLayer(root, clientStream, true);
            clientStream.write(2);
        } finally {
            clientStream.close();
        }
    }

    
    private static void captureViewLayer(View view, DataOutputStream clientStream, boolean visible) throws IOException {
        final boolean localVisible = view.getVisibility() == View.VISIBLE && visible;
        if ((view.mPrivateFlags & View.SKIP_DRAW) != View.SKIP_DRAW) {
            final int id = view.getId();
            String name = view.getClass().getSimpleName();
            if (id != View.NO_ID) {
                name = resolveId(view.getContext(), id).toString();
            }
            clientStream.write(1);
            clientStream.writeUTF(name);
            clientStream.writeByte(localVisible ? 1 : 0);
            int[] position = new int[2];
            view.getLocationInWindow(position);
            clientStream.writeInt(position[0]);
            clientStream.writeInt(position[1]);
            clientStream.flush();
            Bitmap b = performViewCapture(view, true);
            if (b != null) {
                ByteArrayOutputStream arrayOut = new ByteArrayOutputStream(b.getWidth() *
                        b.getHeight() * 2);
                b.compress(Bitmap.CompressFormat.PNG, 100, arrayOut);
                clientStream.writeInt(arrayOut.size());
                arrayOut.writeTo(clientStream);
            }
            clientStream.flush();
        }
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            int count = group.getChildCount();
            for (int i = 0; i < count; i++) {
                captureViewLayer(group.getChildAt(i), clientStream, localVisible);
            }
        }
    }

    
    private static void outputDisplayList(View root, String parameter) throws IOException {
        final View view = findView(root, parameter);
        view.getViewRootImpl().outputDisplayList(view);
    }

    
    private static void capture(View root, final OutputStream clientStream, String parameter) throws IOException {
        final View captureView = findView(root, parameter);
        Bitmap b = performViewCapture(captureView, false);
        if (b == null) {
            Log.w("View", "Failed to create capture bitmap!");
            b = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        BufferedOutputStream out = null;
        try {
            out = new BufferedOutputStream(clientStream, 32 * 1024);
            b.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
        } finally {
            if (out != null) {
                out.close();
            }
            b.recycle();
        }
    }

    
    private static Bitmap performViewCapture(final View captureView, final boolean skpiChildren) {
        if (captureView != null) {
            final CountDownLatch latch = new CountDownLatch(1);
            final Bitmap[] cache = new Bitmap[1];
            captureView.post(new Runnable() {
                public void run() {
                    try {
                        cache[0] = captureView.createSnapshot(
                                Bitmap.Config.ARGB_8888, 0, skpiChildren);
                    } catch (OutOfMemoryError e) {
                        Log.w("View", "Out of memory for bitmap");
                    } finally {
                        latch.countDown();
                    }
                }
            });
            try {
                latch.await(CAPTURE_TIMEOUT, TimeUnit.MILLISECONDS);
                return cache[0];
            } catch (InterruptedException e) {
                Log.w("View", "Could not complete the capture of the view " + captureView);
                Thread.currentThread().interrupt();
            }
        }
        return null;
    }

    
    private static void dump(View root, OutputStream clientStream) throws IOException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(clientStream, "utf-8"), 32 * 1024);
            View view = root.getRootView();
            if (view instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) view;
                dumpViewHierarchyWithProperties(group.getContext(), group, out, 0);
            }
            out.write("DONE.");
            out.newLine();
        } catch (Exception e) {
            android.util.Log.w("View", "Problem dumping the view:", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    
    private static View findView(ViewGroup group, String className, int hashCode) {
        if (isRequestedView(group, className, hashCode)) {
            return group;
        }
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            if (view instanceof ViewGroup) {
                final View found = findView((ViewGroup) view, className, hashCode);
                if (found != null) {
                    return found;
                }
            } else if (isRequestedView(view, className, hashCode)) {
                return view;
            }
        }
        return null;
    }

    
    private static boolean isRequestedView(View view, String className, int hashCode) {
        return view.getClass().getName().equals(className) && view.hashCode() == hashCode;
    }

    
    private static void dumpViewHierarchyWithProperties(Context context, ViewGroup group,
            BufferedWriter out, int level) {
        if (!dumpViewWithProperties(context, group, out, level)) {
            return;
        }
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            if (view instanceof ViewGroup) {
                dumpViewHierarchyWithProperties(context, (ViewGroup) view, out, level + 1);
            } else {
                dumpViewWithProperties(context, view, out, level + 1);
            }
        }
    }

    
    private static boolean dumpViewWithProperties(Context context, View view,
            BufferedWriter out, int level) {
        try {
            for (int i = 0; i < level; i++) {
                out.write(' ');
            }
            out.write(view.getClass().getName());
            out.write('@');
            out.write(Integer.toHexString(view.hashCode()));
            out.write(' ');
            dumpViewProperties(context, view, out);
            out.newLine();
        } catch (IOException e) {
            Log.w("View", "Error while dumping hierarchy tree");
            return false;
        }
        return true;
    }

    
    private static Field[] getExportedPropertyFields(Class<?> klass) {
        if (sFieldsForClasses == null) {
            sFieldsForClasses = new HashMap<Class<?>, Field[]>();
        }
        if (sAnnotations == null) {
            sAnnotations = new HashMap<AccessibleObject, ExportedProperty>(512);
        }
        final HashMap<Class<?>, Field[]> map = sFieldsForClasses;
        Field[] fields = map.get(klass);
        if (fields != null) {
            return fields;
        }
        final ArrayList<Field> foundFields = new ArrayList<Field>();
        fields = klass.getDeclaredFields();
        int count = fields.length;
        for (int i = 0; i < count; i++) {
            final Field field = fields[i];
            if (field.isAnnotationPresent(ExportedProperty.class)) {
                field.setAccessible(true);
                foundFields.add(field);
                sAnnotations.put(field, field.getAnnotation(ExportedProperty.class));
            }
        }
        fields = foundFields.toArray(new Field[foundFields.size()]);
        map.put(klass, fields);
        return fields;
    }

    
    private static Method[] getExportedPropertyMethods(Class<?> klass) {
        if (sMethodsForClasses == null) {
            sMethodsForClasses = new HashMap<Class<?>, Method[]>(100);
        }
        if (sAnnotations == null) {
            sAnnotations = new HashMap<AccessibleObject, ExportedProperty>(512);
        }
        final HashMap<Class<?>, Method[]> map = sMethodsForClasses;
        Method[] methods = map.get(klass);
        if (methods != null) {
            return methods;
        }
        final ArrayList<Method> foundMethods = new ArrayList<Method>();
        methods = klass.getDeclaredMethods();
        int count = methods.length;
        for (int i = 0; i < count; i++) {
            final Method method = methods[i];
            if (method.getParameterTypes().length == 0 &&
                    method.isAnnotationPresent(ExportedProperty.class) &&
                    method.getReturnType() != Void.class) {
                method.setAccessible(true);
                foundMethods.add(method);
                sAnnotations.put(method, method.getAnnotation(ExportedProperty.class));
            }
        }
        methods = foundMethods.toArray(new Method[foundMethods.size()]);
        map.put(klass, methods);
        return methods;
    }

    
    private static void dumpViewProperties(Context context, Object view,
            BufferedWriter out) throws IOException {
        dumpViewProperties(context, view, out, "");
    }

    
    private static void dumpViewProperties(Context context, Object view,
            BufferedWriter out, String prefix) throws IOException {
        Class<?> klass = view.getClass();
        do {
            exportFields(context, view, out, klass, prefix);
            exportMethods(context, view, out, klass, prefix);
            klass = klass.getSuperclass();
        } while (klass != Object.class);
    }

    
    private static void exportMethods(Context context, Object view, BufferedWriter out,
            Class<?> klass, String prefix) throws IOException {
        final Method[] methods = getExportedPropertyMethods(klass);
        int count = methods.length;
        for (int i = 0; i < count; i++) {
            final Method method = methods[i];
            try {
                Object methodValue = method.invoke(view, (Object[]) null);
                final Class<?> returnType = method.getReturnType();
                final ExportedProperty property = sAnnotations.get(method);
                String categoryPrefix =
                        property.category().length() != 0 ? property.category() + ":" : "";
                if (returnType == int.class) {
                    if (property.resolveId() && context != null) {
                        final int id = (Integer) methodValue;
                        methodValue = resolveId(context, id);
                    } else {
                        final FlagToString[] flagsMapping = property.flagMapping();
                        if (flagsMapping.length > 0) {
                            final int intValue = (Integer) methodValue;
                            final String valuePrefix =
                                    categoryPrefix + prefix + method.getName() + '_';
                            exportUnrolledFlags(out, flagsMapping, intValue, valuePrefix);
                        }
                        final IntToString[] mapping = property.mapping();
                        if (mapping.length > 0) {
                            final int intValue = (Integer) methodValue;
                            boolean mapped = false;
                            int mappingCount = mapping.length;
                            for (int j = 0; j < mappingCount; j++) {
                                final IntToString mapper = mapping[j];
                                if (mapper.from() == intValue) {
                                    methodValue = mapper.to();
                                    mapped = true;
                                    break;
                                }
                            }
                            if (!mapped) {
                                methodValue = intValue;
                            }
                        }
                    }
                } else if (returnType == int[].class) {
                    final int[] array = (int[]) methodValue;
                    final String valuePrefix = categoryPrefix + prefix + method.getName() + '_';
                    final String suffix = "()";
                    exportUnrolledArray(context, out, property, array, valuePrefix, suffix);
                    return;
                } else if (!returnType.isPrimitive()) {
                    if (property.deepExport()) {
                        dumpViewProperties(context, methodValue, out, prefix + property.prefix());
                        continue;
                    }
                }
                writeEntry(out, categoryPrefix + prefix, method.getName(), "()", methodValue);
            } catch (IllegalAccessException e) {
            } catch (InvocationTargetException e) {
            }
        }
    }

    
    private static void exportFields(Context context, Object view, BufferedWriter out,
            Class<?> klass, String prefix) throws IOException {
        final Field[] fields = getExportedPropertyFields(klass);
        int count = fields.length;
        for (int i = 0; i < count; i++) {
            final Field field = fields[i];
            try {
                Object fieldValue = null;
                final Class<?> type = field.getType();
                final ExportedProperty property = sAnnotations.get(field);
                String categoryPrefix =
                        property.category().length() != 0 ? property.category() + ":" : "";
                if (type == int.class) {
                    if (property.resolveId() && context != null) {
                        final int id = field.getInt(view);
                        fieldValue = resolveId(context, id);
                    } else {
                        final FlagToString[] flagsMapping = property.flagMapping();
                        if (flagsMapping.length > 0) {
                            final int intValue = field.getInt(view);
                            final String valuePrefix =
                                    categoryPrefix + prefix + field.getName() + '_';
                            exportUnrolledFlags(out, flagsMapping, intValue, valuePrefix);
                        }
                        final IntToString[] mapping = property.mapping();
                        if (mapping.length > 0) {
                            final int intValue = field.getInt(view);
                            int mappingCount = mapping.length;
                            for (int j = 0; j < mappingCount; j++) {
                                final IntToString mapped = mapping[j];
                                if (mapped.from() == intValue) {
                                    fieldValue = mapped.to();
                                    break;
                                }
                            }
                            if (fieldValue == null) {
                                fieldValue = intValue;
                            }
                        }
                    }
                } else if (type == int[].class) {
                    final int[] array = (int[]) field.get(view);
                    final String valuePrefix = categoryPrefix + prefix + field.getName() + '_';
                    final String suffix = "";
                    exportUnrolledArray(context, out, property, array, valuePrefix, suffix);
                    return;
                } else if (!type.isPrimitive()) {
                    if (property.deepExport()) {
                        dumpViewProperties(context, field.get(view), out, prefix
                                + property.prefix());
                        continue;
                    }
                }
                if (fieldValue == null) {
                    fieldValue = field.get(view);
                }
                writeEntry(out, categoryPrefix + prefix, field.getName(), "", fieldValue);
            } catch (IllegalAccessException e) {
            }
        }
    }

    
    private static void writeEntry(BufferedWriter out, String prefix, String name,
            String suffix, Object value) throws IOException {
        out.write(prefix);
        out.write(name);
        out.write(suffix);
        out.write("=");
        writeValue(out, value);
        out.write(' ');
    }

    
    private static void exportUnrolledFlags(BufferedWriter out, FlagToString[] mapping,
            int intValue, String prefix) throws IOException {
        final int count = mapping.length;
        for (int j = 0; j < count; j++) {
            final FlagToString flagMapping = mapping[j];
            final boolean ifTrue = flagMapping.outputIf();
            final int maskResult = intValue & flagMapping.mask();
            final boolean test = maskResult == flagMapping.equals();
            if ((test && ifTrue) || (!test && !ifTrue)) {
                final String name = flagMapping.name();
                final String value = "0x" + Integer.toHexString(maskResult);
                writeEntry(out, prefix, name, "", value);
            }
        }
    }

    
    private static void exportUnrolledArray(Context context, BufferedWriter out,
            ExportedProperty property, int[] array, String prefix, String suffix) throws IOException {
        final IntToString[] indexMapping = property.indexMapping();
        final boolean hasIndexMapping = indexMapping.length > 0;
        final IntToString[] mapping = property.mapping();
        final boolean hasMapping = mapping.length > 0;
        final boolean resolveId = property.resolveId() && context != null;
        final int valuesCount = array.length;
        for (int j = 0; j < valuesCount; j++) {
            String name;
            String value = null;
            final int intValue = array[j];
            name = String.valueOf(j);
            if (hasIndexMapping) {
                int mappingCount = indexMapping.length;
                for (int k = 0; k < mappingCount; k++) {
                    final IntToString mapped = indexMapping[k];
                    if (mapped.from() == j) {
                        name = mapped.to();
                        break;
                    }
                }
            }
            if (hasMapping) {
                int mappingCount = mapping.length;
                for (int k = 0; k < mappingCount; k++) {
                    final IntToString mapped = mapping[k];
                    if (mapped.from() == intValue) {
                        value = mapped.to();
                        break;
                    }
                }
            }
            if (resolveId) {
                if (value == null) value = (String) resolveId(context, intValue);
            } else {
                value = String.valueOf(intValue);
            }
            writeEntry(out, prefix, name, suffix, value);
        }
    }

    
    static Object resolveId(Context context, int id) {
        Object fieldValue;
        final Resources resources = context.getResources();
        if (id >= 0) {
            try {
                fieldValue = resources.getResourceTypeName(id) + '/' +
                        resources.getResourceEntryName(id);
            } catch (Resources.NotFoundException e) {
                fieldValue = "id/0x" + Integer.toHexString(id);
            }
        } else {
            fieldValue = "NO_ID";
        }
        return fieldValue;
    }

    
    private static void writeValue(BufferedWriter out, Object value) throws IOException {
        if (value != null) {
            String output = value.toString().replace("\n", "\\n");
            out.write(String.valueOf(output.length()));
            out.write(",");
            out.write(output);
        } else {
            out.write("4,null");
        }
    }

    
    private static void dumpViewHierarchy(ViewGroup group, BufferedWriter out, int level) {
        if (!dumpView(group, out, level)) {
            return;
        }
        final int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            final View view = group.getChildAt(i);
            if (view instanceof ViewGroup) {
                dumpViewHierarchy((ViewGroup) view, out, level + 1);
            } else {
                dumpView(view, out, level + 1);
            }
        }
    }

    
    private static boolean dumpView(Object view, BufferedWriter out, int level) {
        try {
            for (int i = 0; i < level; i++) {
                out.write(' ');
            }
            out.write(view.getClass().getName());
            out.write('@');
            out.write(Integer.toHexString(view.hashCode()));
            out.newLine();
        } catch (IOException e) {
            Log.w("View", "Error while dumping hierarchy tree");
            return false;
        }
        return true;
    }

    
    private static Field[] capturedViewGetPropertyFields(Class<?> klass) {
        if (mCapturedViewFieldsForClasses == null) {
            mCapturedViewFieldsForClasses = new HashMap<Class<?>, Field[]>();
        }
        final HashMap<Class<?>, Field[]> map = mCapturedViewFieldsForClasses;
        Field[] fields = map.get(klass);
        if (fields != null) {
            return fields;
        }
        final ArrayList<Field> foundFields = new ArrayList<Field>();
        fields = klass.getFields();
        int count = fields.length;
        for (int i = 0; i < count; i++) {
            final Field field = fields[i];
            if (field.isAnnotationPresent(CapturedViewProperty.class)) {
                field.setAccessible(true);
                foundFields.add(field);
            }
        }
        fields = foundFields.toArray(new Field[foundFields.size()]);
        map.put(klass, fields);
        return fields;
    }

    
    private static Method[] capturedViewGetPropertyMethods(Class<?> klass) {
        if (mCapturedViewMethodsForClasses == null) {
            mCapturedViewMethodsForClasses = new HashMap<Class<?>, Method[]>();
        }
        final HashMap<Class<?>, Method[]> map = mCapturedViewMethodsForClasses;
        Method[] methods = map.get(klass);
        if (methods != null) {
            return methods;
        }
        final ArrayList<Method> foundMethods = new ArrayList<Method>();
        methods = klass.getMethods();
        int count = methods.length;
        for (int i = 0; i < count; i++) {
            final Method method = methods[i];
            if (method.getParameterTypes().length == 0 &&
                    method.isAnnotationPresent(CapturedViewProperty.class) &&
                    method.getReturnType() != Void.class) {
                method.setAccessible(true);
                foundMethods.add(method);
            }
        }
        methods = foundMethods.toArray(new Method[foundMethods.size()]);
        map.put(klass, methods);
        return methods;
    }

    
    private static String capturedViewExportMethods(Object obj, Class<?> klass,
            String prefix) {
        if (obj == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        final Method[] methods = capturedViewGetPropertyMethods(klass);
        int count = methods.length;
        for (int i = 0; i < count; i++) {
            final Method method = methods[i];
            try {
                Object methodValue = method.invoke(obj, (Object[]) null);
                final Class<?> returnType = method.getReturnType();
                CapturedViewProperty property = method.getAnnotation(CapturedViewProperty.class);
                if (property.retrieveReturn()) {
                    sb.append(capturedViewExportMethods(methodValue, returnType, method.getName() + "#"));
                } else {
                    sb.append(prefix);
                    sb.append(method.getName());
                    sb.append("()=");
                    if (methodValue != null) {
                        final String value = methodValue.toString().replace("\n", "\\n");
                        sb.append(value);
                    } else {
                        sb.append("null");
                    }
                    sb.append("; ");
                }
              } catch (IllegalAccessException e) {
              } catch (InvocationTargetException e) {
              }
        }
        return sb.toString();
    }

    
    private static String capturedViewExportFields(Object obj, Class<?> klass, String prefix) {
        if (obj == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        final Field[] fields = capturedViewGetPropertyFields(klass);
        int count = fields.length;
        for (int i = 0; i < count; i++) {
            final Field field = fields[i];
            try {
                Object fieldValue = field.get(obj);
                sb.append(prefix);
                sb.append(field.getName());
                sb.append("=");
                if (fieldValue != null) {
                    final String value = fieldValue.toString().replace("\n", "\\n");
                    sb.append(value);
                } else {
                    sb.append("null");
                }
                sb.append(' ');
            } catch (IllegalAccessException e) {
            }
        }
        return sb.toString();
    }

    
    public static void dumpCapturedView(String tag, Object view) {
        Class<?> klass = view.getClass();
        StringBuilder sb = new StringBuilder(klass.getName() + ": ");
        sb.append(capturedViewExportFields(view, klass, ""));
        sb.append(capturedViewExportMethods(view, klass, ""));
        Log.d(tag, sb.toString());
    }

    
    public enum HierarchyTraceType {
        INVALIDATE,
        INVALIDATE_CHILD,
        INVALIDATE_CHILD_IN_PARENT,
        REQUEST_LAYOUT,
        ON_LAYOUT,
        ON_MEASURE,
        DRAW,
        BUILD_CACHE
    }

    
    public enum RecyclerTraceType {
        NEW_VIEW,
        BIND_VIEW,
        RECYCLE_FROM_ACTIVE_HEAP,
        RECYCLE_FROM_SCRAP_HEAP,
        MOVE_TO_SCRAP_HEAP,
        MOVE_FROM_ACTIVE_TO_SCRAP_HEAP
    }

    
    private static class RecyclerTrace {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_field = "1BDA80F2BE4D3658E0BAA43FBE7AE8C1", hash_generated_field = "ED83C2F54CE383C7D62E29BD1035B9D3")

        public int view;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "7C6E79B6BBCCD9A22B2D56B1BBC23A93")

        public RecyclerTraceType type;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_field = "4757FE07FD492A8BE0EA6A760D683D6E", hash_generated_field = "B2F6CC92E86B46C8537E13B7CC7F6689")

        public int position;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_field = "48D3D19B6EB907692106FE647059B2C8", hash_generated_field = "ADBFEEFE9BCE8AF6F80B6F5B9949565A")

        public int indexOnScreen;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_method = "ED320AF13EB079D56E1BB2CD418F0F12", hash_generated_method = "ED320AF13EB079D56E1BB2CD418F0F12")
        public RecyclerTrace ()
        {
            //Synthesized constructor
        }


    }


    
    private static class LooperProfiler implements Looper.Profiler, Printer {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_field = "9584F08F04BD0B7FDDBE5FE88E83C904", hash_generated_field = "907124E57E6B072BDF3C9759E9F1A9DD")

        private long mTraceWallStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_field = "A0523C3AC43A60919026BF0393A6B274", hash_generated_field = "9A8A7790571BC817117ED4A4028799A7")

        private long mTraceThreadStart;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_field = "14AB8DA4BE0770D41461EB4B463A17FE", hash_generated_field = "D18A086A815A6770FBDC3F49B10DB707")

        private final ArrayList<Entry> mTraces = new ArrayList<Entry>(512);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_field = "C354240C287CBF6C82D87E9C7D5D6743", hash_generated_field = "DE94B5ABFDFE10D1547A66120C45E13B")

        private final HashMap<String, Integer> mTraceNames = new HashMap<String, Integer>(32);
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.273 -0400", hash_original_field = "E14516108C1209C4094B9898C04AFD64", hash_generated_field = "DA1910C6BCE975350BE95871C9917550")

        private int mTraceId = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.274 -0400", hash_original_field = "FB4FCB3508FC66D4E3F113990AC335C6", hash_generated_field = "6FACC3B41470C8330B5F0BB43FA7FD9F")

        private String mPath;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.274 -0400", hash_original_field = "D118306A98C1E7C12AA828417A60A6F6", hash_generated_field = "2EB80060CD9954C0E91A29E7A228F077")

        private ParcelFileDescriptor mFileDescriptor;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.278 -0400", hash_original_method = "837FBF9717038E47AC8A60A9DD4D19D4", hash_generated_method = "07405BE75588A7B0CFCED9CFC60D4CD4")
          LooperProfiler(String path, FileDescriptor fileDescriptor) {
            mPath = path;
            try 
            {
                mFileDescriptor = ParcelFileDescriptor.dup(fileDescriptor);
            } //End block
            catch (IOException e)
            {
                RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1979697927 = new RuntimeException(e);
                varC76ADF009CE2FEDD948F7A54F409BA37_1979697927.addTaint(taint);
                throw varC76ADF009CE2FEDD948F7A54F409BA37_1979697927;
            } //End block
            mTraceWallStart = SystemClock.currentTimeMicro();
            mTraceThreadStart = SystemClock.currentThreadTimeMicro();
            // ---------- Original Method ----------
            //mPath = path;
            //try {
                //mFileDescriptor = ParcelFileDescriptor.dup(fileDescriptor);
            //} catch (IOException e) {
                //Log.e(LOG_TAG, "Could not write trace file " + mPath, e);
                //throw new RuntimeException(e);
            //}
            //mTraceWallStart = SystemClock.currentTimeMicro();
            //mTraceThreadStart = SystemClock.currentThreadTimeMicro();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.278 -0400", hash_original_method = "154FC169BABA0D9841DA90FB18C972FB", hash_generated_method = "4D5EEED3A4E0DDBF058576EAC9A4A5DC")
        @Override
        public void println(String x) {
            addTaint(x.getTaint());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.279 -0400", hash_original_method = "CBC3F19E284786CED14CDBC43ACD7A30", hash_generated_method = "BABFE7725B9CF546A9ABBF29A5E1087C")
        @Override
        public void profile(Message message, long wallStart, long wallTime,
                long threadStart, long threadTime) {
            addTaint(threadTime);
            addTaint(threadStart);
            addTaint(wallTime);
            addTaint(wallStart);
            addTaint(message.getTaint());
            Entry entry = new Entry();
            entry.traceId = getTraceId(message);
            entry.wallStart = wallStart;
            entry.wallTime = wallTime;
            entry.threadStart = threadStart;
            entry.threadTime = threadTime;
            mTraces.add(entry);
            // ---------- Original Method ----------
            //Entry entry = new Entry();
            //entry.traceId = getTraceId(message);
            //entry.wallStart = wallStart;
            //entry.wallTime = wallTime;
            //entry.threadStart = threadStart;
            //entry.threadTime = threadTime;
            //mTraces.add(entry);
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.279 -0400", hash_original_method = "A4E97683E16A36EF6068E097213C1038", hash_generated_method = "0FB72CCEA50EA0A93F924F35E12C4FD1")
        private int getTraceId(Message message) {
            addTaint(message.getTaint());
            String name = message.getTarget().getMessageName(message);
            Integer traceId = mTraceNames.get(name);
            if(traceId == null)            
            {
                traceId = mTraceId++ << 4;
                mTraceNames.put(name, traceId);
            } //End block
            int var9449EF8F36BCEDA75FD8F2DB4F9EA5AE_548891369 = (traceId);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935412384 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_935412384;
            // ---------- Original Method ----------
            //String name = message.getTarget().getMessageName(message);
            //Integer traceId = mTraceNames.get(name);
            //if (traceId == null) {
                //traceId = mTraceId++ << 4;
                //mTraceNames.put(name, traceId);
            //}
            //return traceId;
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.280 -0400", hash_original_method = "BBA2F80D690B10E11CCE7370554710C3", hash_generated_method = "79F7CE6E162D344F5E56F58B53C03860")
         void save() {
            new Thread(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.280 -0400", hash_original_method = "B6996361E66890DF09673E772DD6D111", hash_generated_method = "73567CBE8B59CB7E5176BEBD26716111")
            @Override
            public void run() {
                saveTraces();
                // ---------- Original Method ----------
                //saveTraces();
            }
}, "LooperProfiler[" + mPath + "]").start();
            // ---------- Original Method ----------
            //new Thread(new Runnable() {
                //@Override
                //public void run() {
                    //saveTraces();
                //}
            //}, "LooperProfiler[" + mPath + "]").start();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.281 -0400", hash_original_method = "B1053AAB109E078FB60D54B6D9E37ED4", hash_generated_method = "AE38BB95A86B2CDE9EBD1002E7DAC717")
        private void saveTraces() {
            FileOutputStream fos = new FileOutputStream(mFileDescriptor.getFileDescriptor());
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(fos));
            try 
            {
                writeHeader(out, mTraceWallStart, mTraceNames, mTraces);
                out.flush();
                writeTraces(fos, out.size(), mTraceWallStart, mTraceThreadStart, mTraces);
                Log.d(LOG_TAG, "Looper traces ready: " + mPath);
            } //End block
            catch (IOException e)
            {
            } //End block
            finally 
            {
                try 
                {
                    out.close();
                } //End block
                catch (IOException e)
                {
                } //End block
                try 
                {
                    mFileDescriptor.close();
                } //End block
                catch (IOException e)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSModeled(DSC.SAFE)
        private static void writeTraces(FileOutputStream out, long offset, long wallStart,
                long threadStart, ArrayList<Entry> entries) throws IOException {
            FileChannel channel = out.getChannel();
            ByteBuffer buffer = ByteBuffer.allocateDirect(HEADER_SIZE);
            buffer.put(HEADER_MAGIC.getBytes());
            buffer = buffer.order(ByteOrder.LITTLE_ENDIAN);
            buffer.putShort((short) TRACE_VERSION_NUMBER);
            buffer.putShort((short) HEADER_SIZE);
            buffer.putLong(wallStart);
            buffer.putShort(HEADER_RECORD_SIZE);
            for (int i = 0; i < HEADER_SIZE - 18; i++) {
                buffer.put((byte) 0);
            }
            buffer.flip();
            channel.position(offset).write(buffer);
            buffer = ByteBuffer.allocateDirect(14).order(ByteOrder.LITTLE_ENDIAN);
            for (Entry entry : entries) {
                buffer.putShort((short) 1);   
                buffer.putInt(entry.traceId); 
                buffer.putInt((int) (entry.threadStart - threadStart));
                buffer.putInt((int) (entry.wallStart - wallStart));
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
                buffer.putShort((short) 1);
                buffer.putInt(entry.traceId | ACTION_EXIT_METHOD); 
                buffer.putInt((int) (entry.threadStart + entry.threadTime - threadStart));
                buffer.putInt((int) (entry.wallStart + entry.wallTime - wallStart));
                buffer.flip();
                channel.write(buffer);
                buffer.clear();
            }
            channel.close();
        }

        
        @DSModeled(DSC.SAFE)
        private static void writeHeader(DataOutputStream out, long start,
                HashMap<String, Integer> names, ArrayList<Entry> entries) throws IOException {
            Entry last = entries.get(entries.size() - 1);
            long wallTotal = (last.wallStart + last.wallTime) - start;
            startSection("version", out);
            addValue(null, Integer.toString(TRACE_VERSION_NUMBER), out);
            addValue("data-file-overflow", "false", out);
            addValue("clock", "dual", out);
            addValue("elapsed-time-usec", Long.toString(wallTotal), out);
            addValue("num-method-calls", Integer.toString(entries.size()), out);
            addValue("clock-call-overhead-nsec", "1", out);
            addValue("vm", "dalvik", out);
            startSection("threads", out);
            addThreadId(1, "main", out);
            startSection("methods", out);
            addMethods(names, out);
            startSection("end", out);
        }

        
        @DSModeled(DSC.SAFE)
        private static void addMethods(HashMap<String, Integer> names, DataOutputStream out) throws IOException {
            for (Map.Entry<String, Integer> name : names.entrySet()) {
                out.writeBytes(String.format("0x%08x\tEventQueue\t%s\t()V\tLooper\t-2\n",
                        name.getValue(), name.getKey()));
            }
        }

        
        @DSModeled(DSC.SAFE)
        private static void addThreadId(int id, String name, DataOutputStream out) throws IOException {
            out.writeBytes(Integer.toString(id) + '\t' + name + '\n');
        }

        
        @DSModeled(DSC.SAFE)
        private static void addValue(String name, String value, DataOutputStream out) throws IOException {
            if (name != null) {
                out.writeBytes(name + "=");
            }
            out.writeBytes(value + '\n');
        }

        
        @DSModeled(DSC.SAFE)
        private static void startSection(String name, DataOutputStream out) throws IOException {
            out.writeBytes("*" + name + '\n');
        }

        
        static class Entry {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "9449EF8F36BCEDA75FD8F2DB4F9EA5AE", hash_generated_field = "C68363F70ADCAFF99F59BB383A8DC09F")

            int traceId;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "02C085F0775A123109B34038B5F79660", hash_generated_field = "CD3765D68DA5A5B9F5CE82D9DB609164")

            long wallStart;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "A603E9EBDEBBC18D769F2D40E18BC583", hash_generated_field = "4AF1E1CB2BFA789E16B71B0DCB178EDB")

            long wallTime;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "E2AB3E7A67A38EA52D7730D4C5E82961", hash_generated_field = "2BBAC33AD2B483C35BB689E384478A82")

            long threadStart;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "3806B13B072A3E20680C9E05627C478D", hash_generated_field = "C322CE8D67E78FB4B046F4C7179E5580")

            long threadTime;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_method = "629F4A8E90A91F8ECA92C26A9EB219B2", hash_generated_method = "629F4A8E90A91F8ECA92C26A9EB219B2")
            public Entry ()
            {
                //Synthesized constructor
            }


        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "7A8A4336A2EB31EC0AB448A49277068D", hash_generated_field = "C69277D3A6C0A47CB55912A466260D08")

        private static final String LOG_TAG = "LooperProfiler";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "B93352BD87EF694320F1F97ACB153AA8", hash_generated_field = "871E2F94CCC725B7827319EDDC137722")

        private static final int TRACE_VERSION_NUMBER = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "ABA39137EEBCB8F7C4E4238783223BD7", hash_generated_field = "A1F6BAEF2E989EE3FA0925E45A3CFD13")

        private static final int ACTION_EXIT_METHOD = 0x1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "C00ECD23482E61D6E931FA0A554BF854", hash_generated_field = "76F366AD6EB46B3BF9F1D9821E0B8FE5")

        private static final int HEADER_SIZE = 32;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "AC40C4946DD906E11AA78AF61DF2F2BC", hash_generated_field = "4E0FAF61A961141628DFC7DB4534A7E1")

        private static final String HEADER_MAGIC = "SLOW";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "1932EAA090FF4E3F6F2A42822883CCBF", hash_generated_field = "0B85C641B9DE54964CCC1A129A9C40F1")

        private static final short HEADER_RECORD_SIZE = (short) 14;
    }


    
    @Target({ ElementType.FIELD, ElementType.METHOD }) @Retention(RetentionPolicy.RUNTIME) public @interface ExportedProperty {
        
        boolean resolveId() default false;

        
        IntToString[] mapping() default { };

        
        IntToString[] indexMapping() default { };

        
        FlagToString[] flagMapping() default { };

        
        boolean deepExport() default false;

        
        String prefix() default "";

        
        String category() default "";
    }
    
    @Target({ ElementType.TYPE }) @Retention(RetentionPolicy.RUNTIME) public @interface IntToString {
        
        int from();

        
        String to();
    }
    
    @Target({ ElementType.TYPE }) @Retention(RetentionPolicy.RUNTIME) public @interface FlagToString {
        
        int mask();

        
        int equals();

        
        String name();

        
        boolean outputIf() default true;
    }
    
    @Target({ ElementType.FIELD, ElementType.METHOD }) @Retention(RetentionPolicy.RUNTIME) public @interface CapturedViewProperty {
        
        boolean retrieveReturn() default false;
    }
    
    interface ViewOperation<T> {
        T[] pre();
        void run(T... data);
        void post(T... data);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "8B694EA1DFEF8F9AE09AB98065ACF53B", hash_generated_field = "86781DCF86035685DDB38D2649CD3D04")

    public static final String CONSISTENCY_LOG_TAG = "ViewConsistency";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "0AF1698FAA240F40B50FDCB2B1D69E1F", hash_generated_field = "D9BFBAE0C25DC40F4D9BB455F91F6D0A")

    public static final int CONSISTENCY_LAYOUT = 0x1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "206B93F91EE2058C3C672E94360CB41A", hash_generated_field = "8E3E44DD5019328562D473EF23ABD41A")

    public static final int CONSISTENCY_DRAWING = 0x2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "D112E71B5A4737699336FFD4D9DD5256", hash_generated_field = "C045360CEDFF189A88AFA4EE8D202DDE")

    public static final boolean TRACE_HIERARCHY = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "3620C6B5C36E6E1066FDF69020CF048E", hash_generated_field = "1A5D3591701CB592F2723D2D1DA3E49E")

    public static final boolean TRACE_RECYCLER = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "7D9BCE93F35A75892D4F937B886FC1AF", hash_generated_field = "1DC50F8D4E55F1408444042AE0225479")

    public static final boolean DEBUG_PROFILE_DRAWING = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "986A7B4D169F683CAFFBB0468536DF3F", hash_generated_field = "7BA93C1DFD06077908429783FE30421E")

    public static final boolean DEBUG_PROFILE_LAYOUT = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "680A82722F0F53177D986F69EF7A432F", hash_generated_field = "7E6AC0E1C78577CC135F12F385D191DC")

    public static final boolean DEBUG_DRAG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "892D87C038C6719A1264C54FD4317EAD", hash_generated_field = "C436896058FD7FAB45FF8504727A307B")

    public static final boolean DEBUG_LATENCY = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "B4EB00A1CB911AC92B1D51E97A1E8BDA", hash_generated_field = "7D1DFC7A96C3DC5260465A4E2AFF73BC")

    @Debug.DebugProperty public static boolean consistencyCheckEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "1C8F54987D51836102345215B58DE4A6", hash_generated_field = "FCDC3479819F1A0FA21DD7CF7F282FA5")

    private static HashMap<Class<?>, Method[]> mCapturedViewMethodsForClasses = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "5B7529840E7CDAA825FC589B976FA3BB", hash_generated_field = "38EEBA983D87300AC01AE0B6BEB32865")

    private static HashMap<Class<?>, Field[]> mCapturedViewFieldsForClasses = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "70D9B00930840BCD256493DC17B30EF6", hash_generated_field = "EEBCE2DFBBA5939704DCB7EA7757895B")

    private static final int CAPTURE_TIMEOUT = 4000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "594E1923BA4DC64C0B824E13186C3F7B", hash_generated_field = "657ACDB64251CC9C5F5560318566FA83")

    private static final String REMOTE_COMMAND_CAPTURE = "CAPTURE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.283 -0400", hash_original_field = "E9340F35404ACA6B314CD3DFCB310739", hash_generated_field = "E4ABFC964C0C91DA46FEC266E2489143")

    private static final String REMOTE_COMMAND_DUMP = "DUMP";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.284 -0400", hash_original_field = "3141C2F1A9B03B6DCC61252966AB03E0", hash_generated_field = "1603E1D088235440D677B101140595D0")

    private static final String REMOTE_COMMAND_INVALIDATE = "INVALIDATE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.284 -0400", hash_original_field = "98866F71C65697987B4179D55ACB9B92", hash_generated_field = "3AF7FAF90036557B0EC21263F7AECC7C")

    private static final String REMOTE_COMMAND_REQUEST_LAYOUT = "REQUEST_LAYOUT";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.284 -0400", hash_original_field = "BD789BEE4310EE52BB08A84791C38ACC", hash_generated_field = "980F6A2777237FD1E1F767C07D103822")

    private static final String REMOTE_PROFILE = "PROFILE";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.284 -0400", hash_original_field = "BA9C26E05574F2CDAC709108EA444991", hash_generated_field = "825BF5137B87DFA820A18794D927B6C9")

    private static final String REMOTE_COMMAND_CAPTURE_LAYERS = "CAPTURE_LAYERS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.284 -0400", hash_original_field = "30CCFC3C812F581912247D2AD06E5074", hash_generated_field = "29D5BE016108CD614B95A1F8D2CA4B48")

    private static final String REMOTE_COMMAND_OUTPUT_DISPLAYLIST = "OUTPUT_DISPLAYLIST";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.284 -0400", hash_original_field = "D62794B01A5588A7806C01134BEAFA10", hash_generated_field = "381B34CC38C521D55D8B29707BF77CF1")

    private static HashMap<Class<?>, Field[]> sFieldsForClasses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.284 -0400", hash_original_field = "8CDF00353521E7ED13E25CC37E0D805A", hash_generated_field = "FDF3063B8421F5EF4C9F31EF9C7D1386")

    private static HashMap<Class<?>, Method[]> sMethodsForClasses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.284 -0400", hash_original_field = "86119F0E4C1DE65D6D79E95EE6B245BF", hash_generated_field = "12967F08A6F1E730898691D5C3FCAE06")

    private static HashMap<AccessibleObject, ExportedProperty> sAnnotations;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.287 -0400", hash_original_field = "4645D26D77D4AC3340E319449BAD30BC", hash_generated_field = "3DAFD8507B12D2E4DBAAF387421DFD6D")

    private static BufferedWriter sHierarchyTraces;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.287 -0400", hash_original_field = "3714B6CCACC5C2DBC5E15D40B46B52AA", hash_generated_field = "0947A593046A3A68DF32E94CC1CCF03B")

    private static ViewRootImpl sHierarhcyRoot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.287 -0400", hash_original_field = "9D2B46244FB651FE447E2031C4011725", hash_generated_field = "B8C9F8C71D79A1296B9FDBA6098214E8")

    private static String sHierarchyTracePrefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.287 -0400", hash_original_field = "F57D840C8E6BE283C9D2C27DB8620394", hash_generated_field = "87511F78472767C36F509F6D81A67344")

    private static View sRecyclerOwnerView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.287 -0400", hash_original_field = "4DB6421E32DB68A85B93EB783825A224", hash_generated_field = "C046D203CE4AB5C299FBF2864E9A2CB9")

    private static List<View> sRecyclerViews;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.287 -0400", hash_original_field = "B4A0C2D10E5796730BEF6F6E4E6B99ED", hash_generated_field = "D119B20D320A23766CBB36F6AAD8A64B")

    private static List<RecyclerTrace> sRecyclerTraces;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.287 -0400", hash_original_field = "470A867388BE541952A533239E9DD8E4", hash_generated_field = "2512B7C223A4418693E10B26A4513416")

    private static String sRecyclerTracePrefix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:46.287 -0400", hash_original_field = "5C415BA1C9C54FCFB06F0C82AF14BC3A", hash_generated_field = "92F7912ACE2DEBF639BEDECEBAF815D3")

    private static final ThreadLocal<LooperProfiler> sLooperProfilerStorage = new ThreadLocal<LooperProfiler>();
}

