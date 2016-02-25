package com.map.gxt.client.tables;

import com.map.gxt.client.tables.grid.FilterGridExample2;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

public class BasicTabExample2 implements IsWidget {
    private VerticalLayoutContainer widget;

    @Override
    public Widget asWidget() {
        if (widget == null) {
////            HTML           nowText = new HTML();
//            HTML        routesText = new HTML("none");
//            HTML notificationsText = new HTML("none");
//
////            nowText.addStyleName("pad-text");
//            routesText.addStyleName("pad-text");
//            notificationsText.addStyleName("pad-text");

            TabPanel tabPanel = new TabPanel();
            tabPanel.setWidth(450);
            tabPanel.add(new FilterGridExample2(), "Сейчас");
            tabPanel.add(new HTML("none"), "Маршруты");
            tabPanel.add(new HTML("none"), "Оповещения");

            widget = new VerticalLayoutContainer();
            widget.add(tabPanel, new VerticalLayoutData(1, 0.5, new Margins(0, 0, 10, 0)));
        }

        return widget;
    }
}
