package com.demo.gxt_google_maps.client;//package com.demo.gxt_google_maps.client;
//
//import com.demo.gxt_google_maps.client.view.layout.HorizontalContainer;
//import com.google.gwt.cell.client.AbstractCell;
//import com.google.gwt.core.client.EntryPoint;
//import com.google.gwt.core.client.GWT;
//import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
//import com.google.gwt.user.client.ui.HTML;
//import com.google.gwt.user.client.ui.IsWidget;
//import com.google.gwt.user.client.ui.RootPanel;
//import com.google.gwt.user.client.ui.Widget;
//import com.sencha.gxt.data.shared.ListStore;
//import com.sencha.gxt.examples.resources.client.TestData;
//import com.sencha.gxt.examples.resources.client.model.Stock;
//import com.sencha.gxt.examples.resources.client.model.StockProperties;
//import com.sencha.gxt.widget.core.client.ContentPanel;
//import com.sencha.gxt.widget.core.client.TabPanel;
//import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
//import com.sencha.gxt.widget.core.client.grid.ColumnModel;
//import com.sencha.gxt.widget.core.client.grid.Grid;
//import com.sencha.gxt.widget.core.client.grid.RowExpander;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Entry point classes define <code>onModuleLoad()</code>.
// */
//
//public class App implements IsWidget, EntryPoint {
//    @Override
//  public void onModuleLoad() {
////        FormularioUsuarios form = new FormularioUsuarios();
//        HorizontalContainer hContainer = new HorizontalContainer();
//
////        RootPanel.get().add(form);
////        RootPanel.get().add(hContainer);
//
//        ///////////////////////////////////////////////////////// 1
////        ContentPanel panel0 = new ContentPanel();
////        panel0.setHeadingHtml("#0");
////        panel0.add(new HTML("AAA"));
////
////        ContentPanel panel1 = new ContentPanel();
////        panel1.setHeadingHtml("#1");
////        panel1.add(new HTML("BBB"));
////
////        ContentPanel panel2 = new ContentPanel();
////        panel2.setHeadingHtml("#2");
////        panel2.add(new HTML("CCC"));
////
////        RootPanel.get().add(panel0);
////        RootPanel.get().add(panel1);
////        RootPanel.get().add(panel2);
//
//        ///////////////////////////////////////////////////////// 2
////        AccordionLayoutContainer accordion = new AccordionLayoutContainer();
////        accordion.setExpandMode(AccordionLayoutContainer.ExpandMode.SINGLE_FILL);
////        accordion.add(panel0);
////        accordion.add(panel1);
////        accordion.add(panel2);
////
////        ContentPanel panel = new ContentPanel();
////        panel.setHeadingHtml("Accordion");
////        panel.add(accordion);
////
////        RootPanel.get().add(panel);
//
//        ///////////////////////////////////////////////////////// 3
////        panel0.setHeaderVisible(false);
////        panel1.setHeaderVisible(false);
////        panel2.setHeaderVisible(false);
////        TabPanel tabPanel = new TabPanel();
////        tabPanel.add(panel0, "#0");
////        tabPanel.add(panel1, "#1");
////        tabPanel.add(panel2, "#2");
////
////        RootPanel.get().add(tabPanel);
//
//        ///////////////////////////////////////////////////////// 4
////        ContentPanel panel11 = new ContentPanel();
////        panel11.setHeadingHtml("#11");
////        panel11.add(new HTML("AAA"));
////        ContentPanel panel12 = new ContentPanel();
////        panel12.setHeadingHtml("#12");
////        panel12.add(new HTML("BBB"));
////        ContentPanel panel13 = new ContentPanel();
////        panel13.setHeadingHtml("#13");
////        panel13.add(new HTML("CCC"));
////
////        ContentPanel panel21 = new ContentPanel();
////        panel21.setHeadingHtml("#21");
////        panel21.add(new HTML("AAA"));
////        ContentPanel panel22 = new ContentPanel();
////        panel22.setHeadingHtml("#22");
////        panel22.add(new HTML("BBB"));
////        ContentPanel panel23 = new ContentPanel();
////        panel23.setHeadingHtml("#23");
////        panel23.add(new HTML("CCC"));
////
////        ContentPanel panel31 = new ContentPanel();
////        panel31.setHeadingHtml("#31");
////        panel31.add(new HTML("AAA"));
////        ContentPanel panel32 = new ContentPanel();
////        panel32.setHeadingHtml("#32");
////        panel32.add(new HTML("BBB"));
////        ContentPanel panel33 = new ContentPanel();
////        panel33.setHeadingHtml("#33");
////        panel33.add(new HTML("CCC"));
////
////        panel11.setHeaderVisible(false);
////        panel12.setHeaderVisible(false);
////        panel13.setHeaderVisible(false);
////        panel21.setHeaderVisible(false);
////        panel22.setHeaderVisible(false);
////        panel23.setHeaderVisible(false);
////        panel31.setHeaderVisible(false);
////        panel32.setHeaderVisible(false);
////        panel33.setHeaderVisible(false);
////        TabPanel tabPanel1 = new TabPanel();
////        tabPanel1.add(panel11, "#11");
////        tabPanel1.add(panel12, "#12");
////        tabPanel1.add(panel13, "#13");
////        TabPanel tabPanel2 = new TabPanel();
////        tabPanel2.add(panel21, "#21");
////        tabPanel2.add(panel22, "#22");
////        tabPanel2.add(panel23, "#23");
////        TabPanel tabPanel3 = new TabPanel();
////        tabPanel3.add(panel31, "#31");
////        tabPanel3.add(panel32, "#32");
////        tabPanel3.add(panel33, "#33");
////
////        ContentPanel panel10 = new ContentPanel();
////        panel10.setHeadingHtml("#10");
////        panel10.add(tabPanel1);
////        ContentPanel panel20 = new ContentPanel();
////        panel20.setHeadingHtml("#20");
////        panel20.add(tabPanel2);
////        ContentPanel panel30 = new ContentPanel();
////        panel30.setHeadingHtml("#30");
////        panel30.add(tabPanel3);
////
////        AccordionLayoutContainer accordion = new AccordionLayoutContainer();
////        accordion.setExpandMode(AccordionLayoutContainer.ExpandMode.SINGLE_FILL);
////        accordion.add(panel10);
////        accordion.add(panel20);
////        accordion.add(panel30);
////        ContentPanel panel = new ContentPanel();
////        panel.setHeadingHtml("Accordion");
////        panel.add(accordion);
////
////        RootPanel.get().add(panel);
//
//        ///////////////////////////////////////////////////////// 4
//        RootPanel.get().add(asWidget());
//    }
//  
////  @Override
////  public void onModuleLoad() {
////    String version = GXT.getVersion().getRelease();
////    TextButton textButton = new TextButton("Verify GXT Works: Version=" + version);
////    RootPanel.get().add(textButton);
////    textButton.addSelectHandler(new SelectHandler() {
////      @Override
////      public void onSelect(SelectEvent event) {
////        MessageBox messageBox = new MessageBox("GXT Works.");
////        messageBox.show();
////      }
////    });
////
////    GWTServiceUsageExample rpcExample = new GWTServiceUsageExample();
////    RootPanel.get().add(rpcExample);
////
////  }
//
//
//    private static final StockProperties properties = GWT.create(StockProperties.class);
//    private ContentPanel panel;
//
//    @Override
//    public Widget asWidget() {
//        if (panel == null) {
//            RowExpander<Stock> rowExpander = new RowExpander<Stock>(new AbstractCell<Stock>() {
//                @Override
//                public void render(Context context, Stock value, SafeHtmlBuilder sb) {
//                    ContentPanel panel11 = new ContentPanel();
//                    panel11.setHeadingHtml("#11");
//                    panel11.add(new HTML("AAA"));
//                    ContentPanel panel12 = new ContentPanel();
//                    panel12.setHeadingHtml("#12");
//                    panel12.add(new HTML("BBB"));
//                    ContentPanel panel13 = new ContentPanel();
//                    panel13.setHeadingHtml("#13");
//                    panel13.add(new HTML("CCC"));
//                    panel11.setHeaderVisible(false);
//                    panel12.setHeaderVisible(false);
//                    panel13.setHeaderVisible(false);
//                    TabPanel tabPanel1 = new TabPanel();
//                    tabPanel1.add(panel11, "#11");
//                    tabPanel1.add(panel12, "#12");
//                    tabPanel1.add(panel13, "#13");
//
//                    sb.appendHtmlConstant("" + tabPanel1);
//                }
//            });
//
//            ColumnConfig<Stock, String>   viewCol = new ColumnConfig<Stock, String>(properties.symbol(), 75, "View");
//            ColumnConfig<Stock, Double>  foundCol = new ColumnConfig<Stock, Double>(properties.change(), 75, "Found");
//            ColumnConfig<Stock, String> objectCol = new ColumnConfig<Stock, String>(properties.name(), 200, "Object");
//            ColumnConfig<Stock, Double>  speedCol = new ColumnConfig<Stock, Double>(properties.last(), 75, "Speed");
//
//            List<ColumnConfig<Stock, ?>> columns = new ArrayList<ColumnConfig<Stock, ?>>();
//            columns.add(rowExpander);
//            columns.add(viewCol);
//            columns.add(foundCol);
//            columns.add(objectCol);
//            columns.add(speedCol);
//
//            ColumnModel<Stock> cm = new ColumnModel<Stock>(columns);
//
//            ListStore<Stock> store = new ListStore<Stock>(properties.key());
//            store.addAll(TestData.getStocks());
//
//            final Grid<Stock> grid = new Grid<Stock>(store, cm);
//            grid.getView().setAutoExpandColumn(objectCol);
//            grid.setBorders(false);
//            grid.getView().setStripeRows(true);
//            grid.getView().setColumnLines(true);
//
//            rowExpander.initPlugin(grid);
//
//            panel = new ContentPanel();
//            panel.setHeadingHtml("Row Expander Grid");
//            panel.add(grid);
//        }
//
//        return panel;
//    }
//}
