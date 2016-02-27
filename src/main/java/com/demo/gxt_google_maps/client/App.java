package com.demo.gxt_google_maps.client;

import com.demo.gxt_google_maps.client.view.layout.HorizontalContainer;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class App implements EntryPoint {

    @Override
    public void onModuleLoad() {
//        ContentPanel root = new ContentPanel();
//        root.setHeadingText("Simple Grid");
//        root.setPixelSize(550, 250);
//        root.addStyleName("margin-10");
//
//        Resizable r = new Resizable(root, Dir.E, Dir.SE, Dir.S);
//        r.setMinHeight(200);
//        r.setMinWidth(300);
//
//        root.setWidget(new SimpleGrid());
//
//        RootPanel.get().add(root);

        HorizontalContainer hContainer = new HorizontalContainer();
        RootPanel.get().add(hContainer);

        /////////////////////////////////
//        ContentPanel[] panel1 = new ContentPanel[9];
//        panel1[0] = new ContentPanel();
//        panel1[1] = new ContentPanel();
//        panel1[2] = new ContentPanel();
//        panel1[3] = new ContentPanel();
//        panel1[4] = new ContentPanel();
//        panel1[5] = new ContentPanel();
//        panel1[6] = new ContentPanel();
//        panel1[7] = new ContentPanel();
//        panel1[8] = new ContentPanel();
//        TabPanel[] tabPanel = new TabPanel[3];
//        tabPanel[0] = new TabPanel();
//        tabPanel[1] = new TabPanel();
//        tabPanel[2] = new TabPanel();
//
//        panel1[0].add(new HTML("AAA"));
//        panel1[1].add(new HTML("BBB"));
//        panel1[2].add(new HTML("CCC"));
//        panel1[3].add(new HTML("AAA"));
//        panel1[4].add(new HTML("BBB"));
//        panel1[5].add(new HTML("CCC"));
//        panel1[6].add(new HTML("AAA"));
//        panel1[7].add(new HTML("BBB"));
//        panel1[8].add(new HTML("CCC"));
//
//        panel1[0].setHeaderVisible(false); panel1[1].setHeaderVisible(false); panel1[2].setHeaderVisible(false); panel1[3].setHeaderVisible(false); panel1[4].setHeaderVisible(false); panel1[5].setHeaderVisible(false); panel1[6].setHeaderVisible(false); panel1[7].setHeaderVisible(false); panel1[8].setHeaderVisible(false);
//
////        tabPanel[0].add(panel1[0], "#11");
////        tabPanel[0].add(panel1[1], "#12");
////        tabPanel[0].add(panel1[2], "#13");
////        tabPanel[1].add(panel1[3], "#21");
////        tabPanel[1].add(panel1[4], "#22");
////        tabPanel[1].add(panel1[5], "#23");
////        tabPanel[2].add(panel1[6], "#31");
////        tabPanel[2].add(panel1[7], "#32");
////        tabPanel[2].add(panel1[8], "#33");
////
////        RootPanel.get().add(tabPanel[0]);
////        RootPanel.get().add(tabPanel[1]);
////        RootPanel.get().add(tabPanel[2]);
//        //////////////////////////////////////////////
//        tabPanel[0].add(panel1[0], "#11");
//        tabPanel[0].add(panel1[1], "#12");
//        tabPanel[0].add(panel1[2], "#13");
//        tabPanel[1].add(panel1[3], "#21");
//        tabPanel[1].add(panel1[4], "#22");
//        tabPanel[1].add(panel1[5], "#23");
//        tabPanel[2].add(tabPanel[0], "table-1");
//        tabPanel[2].add(tabPanel[1], "table-2");
//
//        RootPanel.get().add(tabPanel[2]);
    }

}