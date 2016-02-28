package com.demo.gxt_google_maps.client;

import com.demo.gxt_google_maps.client.view.layout.HorizontalContainer;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class App implements EntryPoint {

    @Override
    public void onModuleLoad() {
        HorizontalContainer hContainer = new HorizontalContainer();
        RootPanel.get().add(hContainer);
    }

}