package com.demo.gxt_google_maps.client.view.layout;

import com.demo.gxt_google_maps.client.view.maps.GoogleMaps;
import com.demo.gxt_google_maps.client.view.tables.VerticalContainer;
import com.demo.gxt_google_maps.client.view2.grid.SimpleGrid;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Resizable;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;

public class HorizontalContainer implements IsWidget {
    private ContentPanel panel;

    @Override
    public Widget asWidget() {
        if (panel == null) {
            ContentPanel root = new ContentPanel();
            root.setHeadingText("Simple Grid");
            root.setPixelSize(340, 640);
            root.addStyleName("margin-10");
//            Resizable r = new Resizable(root, Resizable.Dir.E, Resizable.Dir.SE, Resizable.Dir.S);
//            r.setMinHeight(200);
//            r.setMinWidth(300);
            root.setWidget(new SimpleGrid());

            HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();
            hlc.add(root, new HorizontalLayoutData(0.25, 1)); //hlc.add(new VerticalContainer(), new HorizontalLayoutData(0.25, 1));
            hlc.add(new GoogleMaps(), new HorizontalLayoutData(0.75, 1)); //hlc.add(createLabel("Карта"), new HorizontalLayoutData(0.75, 1));
            panel = new ContentPanel();
            panel.setPixelSize(1365, 643);
            panel.setHeaderVisible(false);
            panel.add(hlc);
        }
        return panel;
    }

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.addStyleName(ThemeStyles.get().style().border());
        return label;
    }
}
