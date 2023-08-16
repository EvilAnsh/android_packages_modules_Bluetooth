/*
 * Copyright 2020 The Android Open Source Project
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

package com.android.bluetooth.btservice.activityattribution;

import android.os.Binder;
import android.os.Process;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class ActivityAttributionServiceTest {
    private ActivityAttributionService mActivityAttributionService;

    @Before
    public void setUp() {
        Assume.assumeTrue("Ignore test when the user is not primary.", isPrimaryUser());
        mActivityAttributionService = new ActivityAttributionService();
    }

    private boolean isPrimaryUser() {
        return Binder.getCallingUid() == Process.BLUETOOTH_UID;
    }

    @Test
    public void testSetUpAndTearDown() {}
}
