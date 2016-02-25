package com.ejemplo.sencha.client;

import com.ejemplo.sencha.client.tables.grid.CellGridExample2;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements  EntryPoint {
    @Override
  public void onModuleLoad() {
////        FormularioUsuarios form = new FormularioUsuarios();
        CellGridExample2 grids2 = new CellGridExample2();
//        HorizontalLayoutExample3 layout = new HorizontalLayoutExample3();
//        BasicTabExample2 tabs = new BasicTabExample2();
//        FilterGridExample2 grids = new FilterGridExample2();

////        RootPanel.get().add(form);
//        RootPanel.get().add(layout);
//        RootPanel.get().add(tabs);
//        RootPanel.get().add(grids);
        RootPanel.get().add(grids2);
    }
  
//  @Override
//  public void onModuleLoad() {
//    String version = GXT.getVersion().getRelease();
//    TextButton textButton = new TextButton("Verify GXT Works: Version=" + version);
//    RootPanel.get().add(textButton);
//    textButton.addSelectHandler(new SelectHandler() {
//      @Override
//      public void onSelect(SelectEvent event) {
//        MessageBox messageBox = new MessageBox("GXT Works.");
//        messageBox.show();
//      }
//    });
//    
//    GWTServiceUsageExample rpcExample = new GWTServiceUsageExample();
//    RootPanel.get().add(rpcExample);
//    
//  }
  
}
