/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Written by Doug Lea with assistance from members of JCP JSR-166
 * Expert Group and released to the public domain, as explained at
 * http://creativecommons.org/licenses/publicdomain
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ExecutorCompletionService<V> implements CompletionService<V> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.867 -0500", hash_original_field = "1296BB6A213E3D505FD9E92D9FA2F1F3", hash_generated_field = "C344975DD4C90ADC5A05E9EE82CE3C44")

    private  Executor executor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.870 -0500", hash_original_field = "D7603FCB71D55190CA030AE06838582F", hash_generated_field = "2BE08B300EAA426E148B747157CCD2EE")

    private  AbstractExecutorService aes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.873 -0500", hash_original_field = "3F0B4659972423BDE49562D08E9AE4B5", hash_generated_field = "9ACC5A1B9A9F1BE7ABF80562A03906F3")

    private  BlockingQueue<Future<V>> completionQueue;

    /**
     * Creates an ExecutorCompletionService using the supplied
     * executor for base task execution and a
     * {@link LinkedBlockingQueue} as a completion queue.
     *
     * @param executor the executor to use
     * @throws NullPointerException if executor is {@code null}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.891 -0500", hash_original_method = "EDD261742BCF15D9FB8B326368F1ACDA", hash_generated_method = "5B5F8784682D6CD93D7B914157746BC6")
    
public ExecutorCompletionService(Executor executor) {
        if (executor == null)
            throw new NullPointerException();
        this.executor = executor;
        this.aes = (executor instanceof AbstractExecutorService) ?
            (AbstractExecutorService) executor : null;
        this.completionQueue = new LinkedBlockingQueue<Future<V>>();
    }

    /**
     * Creates an ExecutorCompletionService using the supplied
     * executor for base task execution and the supplied queue as its
     * completion queue.
     *
     * @param executor the executor to use
     * @param completionQueue the queue to use as the completion queue
     *        normally one dedicated for use by this service. This
     *        queue is treated as unbounded -- failed attempted
     *        {@code Queue.add} operations for completed taskes cause
     *        them not to be retrievable.
     * @throws NullPointerException if executor or completionQueue are {@code null}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.894 -0500", hash_original_method = "4003AFDAD418CC2ECC4A8EB9D6C4E6CA", hash_generated_method = "D835F2A955986AAB23DD04ACF6C2D200")
    
public ExecutorCompletionService(Executor executor,
                                     BlockingQueue<Future<V>> completionQueue) {
        if (executor == null || completionQueue == null)
            throw new NullPointerException();
        this.executor = executor;
        this.aes = (executor instanceof AbstractExecutorService) ?
            (AbstractExecutorService) executor : null;
        this.completionQueue = completionQueue;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.886 -0500", hash_original_method = "C02DA5DA60AA95D77CB448ECF2F70F43", hash_generated_method = "B592AD98AC1117BD75AE2D9835928135")
    
private RunnableFuture<V> newTaskFor(Callable<V> task) {
        if (aes == null)
            return new FutureTask<V>(task);
        else
            return aes.newTaskFor(task);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.888 -0500", hash_original_method = "BBB6A806AE85DE3A7C516C9FC9F3C042", hash_generated_method = "2D2837FCE7F3DBBCD9CA71F759730077")
    
private RunnableFuture<V> newTaskFor(Runnable task, V result) {
        if (aes == null)
            return new FutureTask<V>(task, result);
        else
            return aes.newTaskFor(task, result);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.896 -0500", hash_original_method = "1066CE8ABD0AE96E9CBF3A082EB30584", hash_generated_method = "F676796BF602BBE00CB5B98928119D97")
    
public Future<V> submit(Callable<V> task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<V> f = newTaskFor(task);
        executor.execute(new QueueingFuture(f));
        return f;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.899 -0500", hash_original_method = "90F0DB50BDB2C4419B39525C086024BB", hash_generated_method = "AAC431F8CC7FF23DDF357A3B885CD4C8")
    
public Future<V> submit(Runnable task, V result) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<V> f = newTaskFor(task, result);
        executor.execute(new QueueingFuture(f));
        return f;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.902 -0500", hash_original_method = "B111DAF975BA373371F56AC1A498CB62", hash_generated_method = "F8BCEAF3098BB34488C509D5C6CC53DD")
    
public Future<V> take() throws InterruptedException {
        return completionQueue.take();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.904 -0500", hash_original_method = "AB80AB0A080F8B419B7B16E63DEC8AE2", hash_generated_method = "E93FE2DDC8E980E5DBDA33FD5BA06B4E")
    
public Future<V> poll() {
        return completionQueue.poll();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.906 -0500", hash_original_method = "68AEBC19C67278ADE553BA09F2BB4BEF", hash_generated_method = "4655BA2D85B4680614476EFDFD4C736E")
    
public Future<V> poll(long timeout, TimeUnit unit)
            throws InterruptedException {
        return completionQueue.poll(timeout, unit);
    }
    
    private class QueueingFuture extends FutureTask<Void> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.882 -0500", hash_original_field = "3345558731446CE3C4228BE1331CAFA9", hash_generated_field = "6A81C34C1728BCFC9614DD81361345B5")

        private  Future<V> task;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.876 -0500", hash_original_method = "A487293341B42B74719D90AA9DC9C87B", hash_generated_method = "A487293341B42B74719D90AA9DC9C87B")
        
QueueingFuture(RunnableFuture<V> task) {
            super(task, null);
            this.task = task;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:11.879 -0500", hash_original_method = "A6F9634D935F51A2E62823D21027F809", hash_generated_method = "FB66A4236DF9A288296DBF0A57E00B59")
        
protected void done() { completionQueue.add(task); }
        
    }
    
}

