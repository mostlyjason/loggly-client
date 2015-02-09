/**
 * Copyright (C) 2015 Anthony K. Trinh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.tony19.loggly;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.mime.TypedInput;

/**
 * Loggly REST interface, used internally by Retrofit
 *
 * @author tony19@gmail.com
 * @since 1.0.1
 */
interface ILogglyRestService {

    /**
     * Posts a single log event to Loggly's REST endpoint
     * @param message log event to be posted
     * @return result of the post as a {@link com.github.tony19.loggly.LogglyResponse}
     */
    @POST("/inputs/{token}/tag/http/")
    LogglyResponse log(@Path("token") String token, @Body TypedInput message);

    /**
     * Posts a single log event to Loggly's REST endpoint
     * @param message log event to be posted
     * @param callback callback to be invoked on completion of the post
     */
    @POST("/inputs/{token}/tag/http/")
    void log(@Path("token") String token, @Body TypedInput message, Callback<LogglyResponse> callback);

    /**
     * Posts several log events at once to Loggly's bulk REST endpoint
     * @param messages log event messages, each delimited by new-line
     *                 The text is parsed for a log event in each line.
     *                 e.g., "Hello\nWorld" would create two log events.
     * @return result of the post as a {@link com.github.tony19.loggly.LogglyResponse}
     */
    @POST("/bulk/{token}/tag/bulk/")
    LogglyResponse logBulk(@Path("token") String token, @Body TypedInput messages);

    /**
     * Posts several log events at once to Loggly's bulk REST endpoint
     * @param messages log event messages, each delimited by new-line
     *                 The text is parsed for a log event in each line.
     *                 e.g., "Hello\nWorld" would create two log events.
     * @param callback callback to be invoked on completion of the post
     */
    @POST("/bulk/{token}/tag/bulk/")
    void logBulk(@Path("token") String token, @Body TypedInput messages, Callback<LogglyResponse> callback);
}