package com.demo.gxt_google_maps.client.gwt_rpc;

import com.demo.gxt_google_maps.client.view.LeftMenuWidget;
import com.demo.gxt_google_maps.shared.Contact;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

/**
 * Created by Саша on 29.02.2016.
 */
public class ContactCallback implements AsyncCallback<List<Contact>> {

    private LeftMenuWidget widget;

    public ContactCallback(LeftMenuWidget widget){
        this.widget = widget;
    }

    @Override
    public void onFailure(Throwable caught) {
        Window.alert(caught.getMessage());
    }

    @Override
    public void onSuccess(List<Contact> contacts) {
        widget.setStore(contacts);
    }

}
