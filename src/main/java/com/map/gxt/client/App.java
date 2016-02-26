package com.map.gxt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.map.gxt.client.grid.GridTable1;
import com.map.gxt.client.grid.GridTable2;
import com.map.gxt.client.layout.HorizontalContainer;
import com.map.gxt.client.tables.VerticalContainer;

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
