package com.demo.gxt_google_maps.client.rpc;

import com.demo.gxt_google_maps.shared.Transit;
import com.demo.gxt_google_maps.shared.HeadTransit;
import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface GWTService extends PropertyAccess<Transit> {
	@Path("id")
	ModelKeyProvider<Transit> key();

    ValueProvider<Transit, String> firstName();
    ValueProvider<Transit, String> lastName();
    ValueProvider<Transit, String> time();
    ValueProvider<Transit, String> timePosition();
    ValueProvider<Transit, String> timeServer();
    ValueProvider<Transit, Integer> speed();
    ValueProvider<Transit, Integer> height();
    ValueProvider<Transit, String> model();
    ValueProvider<Transit, String> number();
    ValueProvider<Transit, Integer> distance();
    ValueProvider<Transit, String> position();
    ValueProvider<Transit, Integer> degree();
    ValueProvider<Transit, Integer> vehicleType();
    ValueProvider<Transit, Boolean> wifi();
    ValueProvider<Transit, HeadTransit> object();
}
