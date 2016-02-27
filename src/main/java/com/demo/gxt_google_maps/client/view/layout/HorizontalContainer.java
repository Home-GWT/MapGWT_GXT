package com.demo.gxt_google_maps.client.view.layout;

import com.demo.gxt_google_maps.client.view.maps.GoogleMaps;
import com.demo.gxt_google_maps.client.view.tables.VerticalContainer;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;

public class HorizontalContainer implements IsWidget {
    private ContentPanel panel;

    @Override
    public Widget asWidget() {
        if (panel == null) {
            HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();
            hlc.add(new VerticalContainer(), new HorizontalLayoutData(0.25, 1));
            hlc.add(new GoogleMaps(), new HorizontalLayoutData(0.75, 1)); //hlc.add(createLabel("Карта"), new HorizontalLayoutData(0.75, 1));
            panel = new ContentPanel();
            panel.setPixelSize(1365, 643);
            panel.setHeaderVisible(false);
            panel.add(hlc);
        }
        return panel;
    }

//    private Label createLabel(String text) {
//        Label label = new Label(text);
//        label.addStyleName(ThemeStyles.get().style().border());
//        return label;
//    }
}
