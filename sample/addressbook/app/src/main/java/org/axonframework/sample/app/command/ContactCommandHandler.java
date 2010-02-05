/*
 * Copyright (c) 2010. Axon Framework
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.axonframework.sample.app.command;

import org.axonframework.sample.app.Address;
import org.axonframework.sample.app.AddressType;

import java.util.UUID;

/**
 * @author Allard Buijze
 */
public class ContactCommandHandler {

    private ContactRepository repository;

    public UUID createContact(String name) {
        Contact contact = new Contact(name);
        repository.save(contact);
        return contact.getIdentifier();
    }

    public void changeContactName(UUID contactId, String name) {
        Contact contact = repository.load(contactId);
        contact.changeName(name);
        repository.save(contact);
    }

    public void registerAddress(UUID contactId, AddressType type, Address address) {
        Contact contact = repository.load(contactId);
        contact.registerAddress(type, address);
        repository.save(contact);
    }

    public void removeAddress(UUID contactId, AddressType type) {
        Contact contact = repository.load(contactId);
        contact.removeAddress(type);
        repository.save(contact);
    }

    public void deleteContact(UUID contactId) {
        repository.delete(contactId);
    }

    public void setRepository(ContactRepository repository) {
        this.repository = repository;
    }
}
