package com.demo.gxt_google_maps.client.gwt_rpc;

import com.demo.gxt_google_maps.shared.Contact;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("service")
public interface ContactService extends RemoteService {
    List<Contact> getContacts();
}
