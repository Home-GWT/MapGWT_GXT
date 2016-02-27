package com.demo.gxt_google_maps.client.view.tables;

import com.demo.gxt_google_maps.client.view.grid.GridTable1;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.AccordionLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public class VerticalContainer implements IsWidget {
    private VerticalLayoutContainer widget;

    @Override
    public Widget asWidget() {
        if (widget == null) {
            ContentPanel panel = new ContentPanel();
            panel.setHeadingHtml("Accordion Layout");
//            panel.setBodyBorder(false);
            panel.setPixelSize(340, 640);
            //////////////////////////////////
//            ContentPanel panel0 = new ContentPanel();
//            panel0.add(new GridTable1());
//            panel0.setHeadingHtml("#0");
//            TabPanel tabPanel0 = new TabPanel();
//            tabPanel0.add(panel0, "Сейчас");
//            tabPanel0.add(new HTML("none"), "Маршруты");
//            tabPanel0.add(new HTML("none"), "Оповещения");
//            tabPanel0.setWidth(340);
//            tabPanel0.setHeight(200);
//
//            ContentPanel panel1 = new ContentPanel();
//            panel1.add(new GridTable1());
//            panel1.setHeadingHtml("#1");
//            TabPanel tabPanel1 = new TabPanel();
//            tabPanel1.add(panel1, "Сейчас");
//            tabPanel1.add(new HTML("none"), "Маршруты");
//            tabPanel1.add(new HTML("none"), "Оповещения");
//            tabPanel1.setWidth(340);
//            tabPanel1.setHeight(200);
//
//            ContentPanel panel2 = new ContentPanel();
//            panel2.add(new GridTable1());
//            panel2.setHeadingHtml("#2");
//            TabPanel tabPanel2 = new TabPanel();
//            tabPanel2.add(panel2, "Сейчас");
//            tabPanel2.add(new HTML("none"), "Маршруты");
//            tabPanel2.add(new HTML("none"), "Оповещения");
//            tabPanel2.setWidth(340);
//            tabPanel2.setHeight(200);
//
//            ContentPanel panel3 = new ContentPanel();
//            panel3.add(new GridTable1());
//            panel3.setHeadingHtml("#3");
//            TabPanel tabPanel3 = new TabPanel();
//            tabPanel3.add(panel3, "Сейчас");
//            tabPanel3.add(new HTML("none"), "Маршруты");
//            tabPanel3.add(new HTML("none"), "Оповещения");
//            tabPanel3.setWidth(340);
//            tabPanel3.setHeight(200);
//
//            ContentPanel panel4 = new ContentPanel();
//            panel4.add(new GridTable1());
//            panel4.setHeadingHtml("#4");
//            TabPanel tabPanel4 = new TabPanel();
//            tabPanel4.add(panel4, "Сейчас");
//            tabPanel4.add(new HTML("none"), "Маршруты");
//            tabPanel4.add(new HTML("none"), "Оповещения");
//            tabPanel4.setWidth(340);
//            tabPanel4.setHeight(200);
//
//            ContentPanel panel5 = new ContentPanel();
//            panel5.add(new GridTable1());
//            panel5.setHeadingHtml("#5");
//            TabPanel tabPanel5 = new TabPanel();
//            tabPanel5.add(panel5, "Сейчас");
//            tabPanel5.add(new HTML("none"), "Маршруты");
//            tabPanel5.add(new HTML("none"), "Оповещения");
//            tabPanel5.setWidth(340);
//            tabPanel5.setHeight(200);
//
//            ContentPanel panel6 = new ContentPanel();
//            panel6.add(new GridTable1());
//            panel6.setHeadingHtml("#6");
//            TabPanel tabPanel6 = new TabPanel();
//            tabPanel6.add(panel6, "Сейчас");
//            tabPanel6.add(new HTML("none"), "Маршруты");
//            tabPanel6.add(new HTML("none"), "Оповещения");
//            tabPanel6.setWidth(340);
//            tabPanel6.setHeight(200);
//
//            ContentPanel panel7 = new ContentPanel();
//            panel7.add(new GridTable1());
//            panel7.setHeadingHtml("#7");
//            TabPanel tabPanel7 = new TabPanel();
//            tabPanel7.add(panel7, "Сейчас");
//            tabPanel7.add(new HTML("none"), "Маршруты");
//            tabPanel7.add(new HTML("none"), "Оповещения");
//            tabPanel7.setWidth(340);
//            tabPanel7.setHeight(200);
//
//            ContentPanel panel8 = new ContentPanel();
//            panel8.add(new GridTable1());
//            panel8.setHeadingHtml("#8");
//            TabPanel tabPanel8 = new TabPanel();
//            tabPanel8.add(panel8, "Сейчас");
//            tabPanel8.add(new HTML("none"), "Маршруты");
//            tabPanel8.add(new HTML("none"), "Оповещения");
//            tabPanel8.setWidth(340);
//            tabPanel8.setHeight(200);

            TabPanel tabPanel9 = new TabPanel();
            tabPanel9.setWidth(340);
            tabPanel9.setHeight(200);
            ContentPanel panel9 = new ContentPanel();
            panel9.add(new GridTable1());
            panel9.setHeadingHtml("#9");
            tabPanel9.add(panel9, "Сейчас");
            tabPanel9.add(new HTML("none"), "Маршруты");
            tabPanel9.add(new HTML("none"), "Оповещения");
//            ContentPanel panel2 = new ContentPanel();
//            panel2.add(new GridTable2());
//            panel2.setHeaderVisible(false);

            AccordionLayoutContainer accordion = new AccordionLayoutContainer();
            accordion.setExpandMode(AccordionLayoutContainer.ExpandMode.SINGLE_FILL);
////            accordion.add(tabPanel0);
////            accordion.add(tabPanel1);
////            accordion.add(tabPanel2);
////            accordion.add(tabPanel3);
////            accordion.add(tabPanel4);
////            accordion.add(tabPanel5);
////            accordion.add(tabPanel6);
////            accordion.add(tabPanel7);
////            accordion.add(tabPanel8);
            accordion.add(tabPanel9);
//            panel.add(accordion);

//            VerticalLayoutContainer inWidget = new VerticalLayoutContainer();
//            inWidget.add(panel);
////            inWidget.add(panel2);
            //////////////////////////////////
            widget = new VerticalLayoutContainer();
            widget.add(accordion); //widget.add(tabPanel9);
        }
        return widget;
    }
}
