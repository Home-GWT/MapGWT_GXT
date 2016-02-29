package com.demo.gxt_google_maps.client.gwt_rpc;

import com.demo.gxt_google_maps.shared.Contact;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface ContactServiceAsync {
    void getContacts(AsyncCallback<List<Contact>> callback);
}
