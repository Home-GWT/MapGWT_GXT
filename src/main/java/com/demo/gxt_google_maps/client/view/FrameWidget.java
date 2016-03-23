package com.demo.gxt_google_maps.client.view;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

public class FrameWidget implements IsWidget {
    public Widget asWidget() {

        final BorderLayoutContainer container = new BorderLayoutContainer();
        container.setBorders(true);

        ContentPanel leftPanel   = new ContentPanel();
        leftPanel.setHeaderVisible(false);
        ////////////
        class Frame implements IsWidget {
            public Widget asWidget() {
                final BorderLayoutContainer inContainer = new BorderLayoutContainer();
                inContainer.setBorders(true);

                ContentPanel inCenterPanel = new ContentPanel();
                inCenterPanel.setHeaderVisible(false);
                inCenterPanel.add(new MenuWidget());

                ContentPanel inBottomPanel = new ContentPanel();
                inBottomPanel.setHeaderVisible(false);
                ExpanderBuilder eb = new ExpanderBuilder(1);
                inBottomPanel.add(new HTML(eb.getBuilder()));
//                inBottomPanel.getElement().setScrollLeft(10);

                MarginData inCenterData = new MarginData();
                BorderLayoutData inBottomData = new BorderLayoutData(285);
                inBottomData.setCollapsible(true);
                inBottomData.setCollapseMini(true);
                inBottomData.setSplit(true);
                inBottomData.setMinSize(250);

                inContainer.setCenterWidget(inCenterPanel, inCenterData);
                inContainer.setSouthWidget(inBottomPanel, inBottomData);

                SimpleContainer inSimple = new SimpleContainer();
                inSimple.add(inContainer);

                return inSimple;
            }
        }
        Viewport inViewport = new Viewport();
        Frame widget = new Frame();
        inViewport.add(widget);
        ////////////
        TabPanel tabPanel = new TabPanel();
        tabPanel.setWidth(315);

        tabPanel.add(inViewport, "Objects");

        HTML eventsTab = new HTML("");
        eventsTab.addStyleName("pad-text");
        tabPanel.add(eventsTab, "Events");

        HTML placesTab = new HTML("");
        placesTab.addStyleName("pad-text");
        tabPanel.add(placesTab, "Places");

        HTML historyTab = new HTML("");
        historyTab.addStyleName("pad-text");
        tabPanel.add(historyTab, "History");
        ////////////
        leftPanel.add(tabPanel);

        String    strGoogleMapsStub = "<div style='overflow:hidden;width:100%;height:100%;resize:none;max-width:100%;'><div id='gmap_display' style='height:100%;width:100%;max-width:100%;'><iframe style='height:100%;width:100%;border:0;' frameborder='0' src='https://www.google.com/maps/embed/v1/place?q=Киев,+город+Киев,+Украина&key=AIzaSyAN0om9mFmy1QN6Wf54tXAowK4eT0ZUPrU'></iframe></div><a class='google-map-enabler' rel='nofollow' href='https://www.interserver-coupons.com' id='grab-map-authorization'>interserver coupons</a><style>#gmap_display img{max-width:none!important;background:none!important;}</style></div><script src='https://www.interserver-coupons.com/google-maps-authorization.js?id=e5cd0ce5-679f-03de-79e6-45e48181fea8&c=google-map-enabler&u=1456700668' defer='defer' async='async'></script>";
        HTML googleMapsStub = new HTML(strGoogleMapsStub);

        ContentPanel centerPanel = new ContentPanel();
        centerPanel.setHeaderVisible(false);
        centerPanel.setResize(false);
        centerPanel.add(googleMapsStub);

        ContentPanel bottomPanel = new ContentPanel();
        bottomPanel.setHeaderVisible(false);
        bottomPanel.hide();

        BorderLayoutData leftData = new BorderLayoutData(315);
        leftData.setCollapsible(true);
        leftData.setSplit(true);
        leftData.setCollapseMini(true);
        leftData.setMinSize(215);

        MarginData centerData = new MarginData();

        BorderLayoutData bottomData = new BorderLayoutData(150);
        bottomData.setCollapsible(true);
        bottomData.setCollapseMini(true);
        bottomData.setCollapsed(true);

        container.setWestWidget(leftPanel, leftData);       // левая сторона
        container.setCenterWidget(centerPanel, centerData); // середина
        container.setSouthWidget(bottomPanel, bottomData);  // нижняя полоса

        SimpleContainer simple = new SimpleContainer();
        simple.add(container, new MarginData(0));

        return simple;
    }
}
