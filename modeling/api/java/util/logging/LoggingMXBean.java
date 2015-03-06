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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.util.logging;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.List;

/**
 * {@code LoggingMXBean} is the management interface for the logging sub-system.
 * <p>
 * The ObjectName for identifying the {@code LoggingMXBean} in a bean server is
 * {@link LogManager#LOGGING_MXBEAN_NAME}.
 * </p>
 *
 * @since 1.5
 */
public interface LoggingMXBean {

    /**
     * Gets the string value of the logging level of a logger. An empty string
     * is returned when the logger's level is defined by its parent. A
     * {@code null} is returned if the specified logger does not exist.
     *
     * @param loggerName
     *            the name of the logger lookup.
     * @return a {@code String} if the logger is found, otherwise {@code null}.
     * @see Level#getName()
     */
    String getLoggerLevel(String loggerName);

    /**
     * Gets a list of all currently registered logger names. This is performed
     * using the {@link LogManager#getLoggerNames()}.
     *
     * @return a list of logger names.
     */
    List<String> getLoggerNames();

    /**
     * Gets the name of the parent logger of a logger. If the logger doesn't
     * exist then {@code null} is returned. If the logger is the root logger,
     * then an empty {@code String} is returned.
     *
     * @param loggerName
     *            the name of the logger to lookup.
     * @return a {@code String} if the logger was found, otherwise {@code null}.
     */
    String getParentLoggerName(String loggerName);

    /**
     * Sets the log level of a logger. LevelName set to {@code null} means the
     * level is inherited from the nearest non-null ancestor.
     *
     * @param loggerName
     *            the name of the logger to set the level on, which must not be
     *            {@code null}.
     * @param levelName
     *            the level to set on the logger, which may be {@code null}.
     * @throws IllegalArgumentException
     *             if {@code loggerName} is not a registered logger or if
     *             {@code levelName} is not null and not valid.
     * @see Level#parse(String)
     */
    void setLoggerLevel(String loggerName, String levelName);
}
