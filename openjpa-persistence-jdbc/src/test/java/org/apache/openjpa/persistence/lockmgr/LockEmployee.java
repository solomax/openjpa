/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.persistence.lockmgr;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class LockEmployee {

    @Id
    private int id;

    @Version
    private int version;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "employee"
        , cascade = { CascadeType.ALL }
        )     
    private Collection<LockTask> tasks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<LockTask> getTasks() {
        return tasks;
    }

    public void setTasks(Collection<LockTask> tasks) {
        this.tasks = tasks;
    }

    public int getVersion() {
        return version;
    }
    
    public String toString() {
        return this.getClass().getName() + "[id=" + getId() + ", ver="
            + getVersion() + "] first=" + getFirstName() + ", last="
            + getLastName() + ", tasks={" + getTasks() + "}";
    }
}
