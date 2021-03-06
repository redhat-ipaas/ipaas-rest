/*
 * Copyright (C) 2016 Red Hat, Inc.
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

package io.syndesis.model.integration;

public enum IntegrationRevisionState {
    /**
     * Initial state of an {@link IntegrationRevision}. The IntegrationRevision is not yet deployed.
     */
    Draft,

    /**
     * {@link IntegrationRevision} is deployed and running.
     */
    Active,
    /**
     * {@link IntegrationRevision} is deployed but is not running.
     */
    Inactive,
    /**
     * IntegrationRevision has been un-deployed.
     */
    Undeployed,

    /**
     * The {@link IntegrationRevision} is deployed but in an error state.
     */
    Error,

    /**
     * The {@link IntegrationRevision} is in peding state. (Desired != Actual).
     */
    Pending;


    @Deprecated //Temporary method for compatibility reasons. Eventually Integration.Status will go away, so will this method.
    public static IntegrationRevisionState from(Integration.Status status) {
        switch (status) {
            case Activated:
                return IntegrationRevisionState.Active;
            case Deactivated:
                return IntegrationRevisionState.Inactive;
            case Deleted:
                return Undeployed;
            default:
                return Pending;
        }
    }
}
