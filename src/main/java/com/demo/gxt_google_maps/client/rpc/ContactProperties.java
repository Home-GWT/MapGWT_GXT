package com.demo.gxt_google_maps.client.rpc;

import com.demo.gxt_google_maps.shared.Contact;
import com.demo.gxt_google_maps.shared.MyObject;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface ContactProperties extends PropertyAccess<Contact> {

	@Path("id")
	ModelKeyProvider<Contact> key();
	
	ValueProvider<Contact, String> name();
	
	ValueProvider<Contact, String> phone();
	
	ValueProvider<Contact, String> email();


    ValueProvider<Contact, String> firstName();
    ValueProvider<Contact, String> lastName();
    ValueProvider<Contact, String> time();
    ValueProvider<Contact, String> timePosition();
    ValueProvider<Contact, String> timeServer();
    ValueProvider<Contact, Integer> speed();
    ValueProvider<Contact, Integer> height();
    ValueProvider<Contact, String> model();
    ValueProvider<Contact, String> number();
    ValueProvider<Contact, Integer> distance();
    ValueProvider<Contact, String> position();
    ValueProvider<Contact, Integer> degree();
    ValueProvider<Contact, Integer> vehicleType();
    ValueProvider<Contact, Boolean> wifi();
    ValueProvider<Contact, MyObject> object();
}
