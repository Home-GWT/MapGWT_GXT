package com.demo.gxt_google_maps.client;

import com.demo.gxt_google_maps.client.view.grid.GridTable2;
import com.demo.gxt_google_maps.client.view.layout.HorizontalContainer;
import com.demo.gxt_google_maps.client.view.tables.VerticalContainer;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.demo.gxt_google_maps.client.view.grid.GridTable1;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements  EntryPoint {
    @Override
  public void onModuleLoad() {
////        FormularioUsuarios form = new FormularioUsuarios();
        HorizontalContainer hContainer = new HorizontalContainer();
        VerticalContainer vContainer = new VerticalContainer();
        GridTable1 tGrid1 = new GridTable1();
        GridTable2 tGrid2 = new GridTable2();
//        CheckBoxGridExample2 tGrid = new CheckBoxGridExample2();

////        RootPanel.get().add(form);
        RootPanel.get().add(hContainer);
//        RootPanel.get().add(vContainer);
//        RootPanel.get().add(tGrid1);
//        RootPanel.get().add(tGrid2);
//        RootPanel.get().add(tGrid);
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
