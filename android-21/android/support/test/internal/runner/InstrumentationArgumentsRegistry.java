/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.support.test.internal.runner;

import android.os.Bundle;

import java.util.concurrent.atomic.AtomicReference;

/**
 * An exposed registry instance to make it easy for callers to find the instrumentation arguments.
 */
public final class InstrumentationArgumentsRegistry {

    private static final AtomicReference<Bundle> sArguments = new AtomicReference<Bundle>(null);

    /**
     * Returns a copy of instrumentation arguments Bundle.
     * <p>
     * This Bundle is not guaranteed to be present under all instrumentations.
     * </p>
     *
     * @return Bundle the arguments for this instrumentation.
     * @throws IllegalStateException if no argument Bundle has been registered.
     */
    public static Bundle getInstance() {
        Bundle instance = sArguments.get();
        if (null == instance) {
            throw new IllegalStateException("No instrumentation arguments registered! "
                    + "Are you running under an Instrumentation which registers arguments?");
        }
        return new Bundle(instance);
    }

    /**
     * Stores a copy of the instrumentation arguments Bundle in the registry.
     * <p>
     * This is a global registry - so be aware of the impact of calling this method!
     * </p>
     * 
     * @param arguments the arguments for this application. Null deregisters any existing arguments.
     */
    public static void registerInstance(Bundle arguments) {
        InstrumentationArgumentsRegistry.sArguments.set(new Bundle(arguments));
    }

    private InstrumentationArgumentsRegistry() { }
}
