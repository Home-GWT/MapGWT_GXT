package com.demo.gxt_google_maps.client.view.tables;

import com.demo.gxt_google_maps.client.view.grid.GridTable1;
import com.demo.gxt_google_maps.client.view.grid.GridTable2;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public class VerticalContainer implements IsWidget {
    private VerticalLayoutContainer widget;

    @Override
    public Widget asWidget() {
        if (widget == null) {
            TabPanel tabPanel = new TabPanel();
            tabPanel.setWidth(340);
            tabPanel.setHeight(640);
            //////////////////////////////////
            ContentPanel panel1 = new ContentPanel();
            panel1.add(new GridTable1());
            panel1.setHeaderVisible(false);
            ContentPanel panel2 = new ContentPanel();
            panel2.add(new GridTable2());
            panel2.setHeaderVisible(false);

            VerticalLayoutContainer inWidget = new VerticalLayoutContainer();
            inWidget.add(panel1);
            inWidget.add(panel2);
//            AccordionLayoutContainer accordion = new AccordionLayoutContainer();
//            accordion.setExpandMode(AccordionLayoutContainer.ExpandMode.MULTI);
//            accordion.add(panel1);
//            accordion.add(panel2);
            //////////////////////////////////
            tabPanel.add(inWidget, "Сейчас"); //tabPanel.add(accordion, "Сейчас");
            tabPanel.add(new HTML("none"), "Маршруты");
            tabPanel.add(new HTML("none"), "Оповещения");
            widget = new VerticalLayoutContainer();
            widget.add(tabPanel);
        }
        return widget;
    }
}
