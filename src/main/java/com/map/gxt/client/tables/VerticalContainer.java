package com.map.gxt.client.tables;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.map.gxt.client.grid.GridTable1;
import com.map.gxt.client.grid.GridTable2;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

public class VerticalContainer implements IsWidget {
    private VerticalLayoutContainer widget;

    @Override
    public Widget asWidget() {
        if (widget == null) {
            TabPanel tabPanel = new TabPanel();
            tabPanel.setWidth(200);
            tabPanel.setHeight(640);
//            tabPanel.add(new GridTable1(), "Сейчас");
            ContentPanel inPanel = new ContentPanel();
//            MarginData center = new MarginData();
            inPanel.add(new GridTable1());
            inPanel.add(new GridTable2());
            tabPanel.add(inPanel, "Сейчас");
            tabPanel.add(new HTML("none"), "Маршруты");
            tabPanel.add(new HTML("none"), "Оповещения");
            widget = new VerticalLayoutContainer();
            widget.add(tabPanel, new VerticalLayoutData(1, 0.5, new Margins(0, 0, 10, 0)));
        }
        return widget;
    }
}
