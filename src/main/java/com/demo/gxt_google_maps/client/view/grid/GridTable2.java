package com.demo.gxt_google_maps.client.view.grid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor.Path;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.cell.core.client.form.DateCell;
import com.sencha.gxt.core.client.IdentityValueProvider;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import com.sencha.gxt.examples.resources.client.TestData;
import com.sencha.gxt.examples.resources.client.model.Plant;
//import com.sencha.gxt_google_maps.explorer.client.grid.CellGridExample;
import com.sencha.gxt.theme.base.client.colorpalette.ColorPaletteBaseAppearance;
import com.sencha.gxt.widget.core.client.ColorPaletteCell;
import com.sencha.gxt.widget.core.client.ColorPaletteCell.ColorPaletteAppearance;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.event.RefreshEvent;
import com.sencha.gxt.widget.core.client.form.DateTimePropertyEditor;
import com.sencha.gxt.widget.core.client.grid.CheckBoxSelectionModel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GridTable2 implements IsWidget {
    private static final String[]            COLORS = new String[]{"161616", "002241", "006874", "82a700", "bbc039", "f3f1cd"};
    private static final PlaceProperties properties = GWT.create(PlaceProperties.class);
    private ListStore<Plant>                  store;
    private ContentPanel                      panel;

    @Override
    public Widget asWidget() {
        if (panel == null) {
            ////////////////////////////////////////////////////////// columnSelectionModel
            IdentityValueProvider<Plant> identity = new IdentityValueProvider<Plant>();

            ColumnConfig<Plant, String> columnSelectionModel = new ColumnConfig<Plant, String>(properties.name(), 30);
            CheckBoxSelectionModel<Plant> selectionModel = new CheckBoxSelectionModel<Plant>(identity) {
                @Override
                protected void onRefresh(RefreshEvent event) {
                    if (isSelectAllChecked()) {
                        selectAll();
                    }
                    super.onRefresh(event);
                }
            };
//            columnSelectionModel1.setCell(selectionModel1);

            ////////////////////////////////////////////////////////// colorColumn
            ColumnConfig<Plant, String> colorColumn = new ColumnConfig<Plant, String>(properties.color(), 25); //ColumnConfig<Plant, String> colorColumn = new ColumnConfig<Plant, String>(properties.color(), 150, "Color");
            // This next line only works with any appearance that extends from Base
            ColorPaletteBaseAppearance appearance = GWT.create(ColorPaletteAppearance.class);
            appearance.setColumnCount(6);

            ColorPaletteCell colorPalette = new ColorPaletteCell(appearance, COLORS, COLORS) {
                @Override
                public boolean handlesSelection() {
                    return true;
                }
            };
            colorPalette.addSelectionHandler(new SelectionHandler<String>() {
                @Override
                public void onSelection(SelectionEvent<String> event) {
                    Info.display("Color Selected", "You selected " + event.getSelectedItem());
                }
            });
            colorColumn.setCell(colorPalette);

            ////////////////////////////////////////////////////////// availableColumn
            DateCell dateCell = new DateCell();
            dateCell.getDatePicker().addValueChangeHandler(new ValueChangeHandler<Date>() {
                @Override
                public void onValueChange(ValueChangeEvent<Date> event) {
                    Info.display("Date Selected", "You selected " + DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT).format(event.getValue()));
                }
            });
            dateCell.setPropertyEditor(new DateTimePropertyEditor(DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_SHORT)));
            ColumnConfig<Plant, Date> availableColumn = new ColumnConfig<Plant, Date>(properties.available(), 140); //ColumnConfig<Plant, Date> availableColumn = new ColumnConfig<Plant, Date>(properties.available(), 160, "Date");
            availableColumn.setCell(dateCell);

            ////////////////////////////////////////////////////////// lightColumn
//            ListStore<String> lights = new ListStore<String>(new ModelKeyProvider<String>() {
//                @Override
//                public String getKey(String item) {
//                    return item;
//                }
//            });
//            lights.add("Mostly Shady");
//            lights.add("Mostly Sunny");
//            lights.add("Shade");
//            lights.add("Sunny");
//            lights.add("Sun or Shade");
//
//            ColumnConfig<Plant, String> lightColumn = new ColumnConfig<Plant, String>(properties.light(), 40); //ColumnConfig<Plant, String> lightColumn = new ColumnConfig<Plant, String>(properties.light(), 130, "Light");
//            ComboBoxCell<String> lightCombo = new ComboBoxCell<String>(lights, new LabelProvider<String>() {
//                @Override
//                public String getLabel(String item) {
//                    return item;
//                }
//            });
//            lightCombo.addSelectionHandler(new SelectionHandler<String>() {
//                @Override
//                public void onSelection(SelectionEvent<String> event) {
//                    CellSelectionEvent<String> sel = (CellSelectionEvent<String>) event;
//                    Plant p = store.get(sel.getContext().getIndex());
//                    Info.display("Lightness Selected", p.getName() + " selected " + event.getSelectedItem());
//                }
//            });
//            lightCombo.setTriggerAction(TriggerAction.ALL);
//            lightCombo.setForceSelection(true);
//            lightCombo.setWidth(120);
//            lightColumn.setCell(lightCombo);
            ////////////////////////////////////////////////////////// nameColumn
            ColumnConfig<Plant, String> nameColumn = new ColumnConfig<Plant, String>(properties.name(), 40); //ColumnConfig<Plant, String> nameColumn = new ColumnConfig<Plant, String>(properties.name(), 100, "Name");
//            nameColumn.setColumnTextClassName(CommonStyles.get().inlineBlock());
//            TextButtonCell button = new TextButtonCell();
//            button.addSelectHandler(new SelectEvent.SelectHandler() {
//                @Override
//                public void onSelect(SelectEvent event) {
//                    Context c = event.getContext();
//                    int row = c.getIndex();
//                    Plant p = store.get(row);
//                    Info.display("Event", "The " + p.getName() + " was clicked.");
//                }
//            });
//            nameColumn.setCell(button);

            ////////////////////////////////////////////////////////// difficultyColumn
//            ColumnConfig<Plant, Integer> difficultyColumn = new ColumnConfig<Plant, Integer>(properties.difficulty(), 50); //ColumnConfig<Plant, Integer> difficultyColumn = new ColumnConfig<Plant, Integer>(properties.difficulty(), 150, "Durability");
//            ToolTipConfig tooltipConfig = new ToolTipConfig();
//            tooltipConfig.setAnchor(Side.LEFT);
//            tooltipConfig.setAnchorArrow(false);
//            tooltipConfig.setMouseOffsetX(25);
//            tooltipConfig.setMouseOffsetY(0);
//            tooltipConfig.setDismissDelay(1000);
//
//            SliderCell slider = new SliderCell() {
//                @Override
//                public boolean handlesSelection() {
//                    return true;
//                }
//            };
//            slider.setToolTipConfig(tooltipConfig);
//            slider.setWidth(140);
//            difficultyColumn.setCell(slider);
            //////////////////////////////////////////////////////////
            ColumnConfig<Plant, String> colorColumn2 = new ColumnConfig<Plant, String>(properties.color(), 25); //ColumnConfig<Plant, String> colorColumn = new ColumnConfig<Plant, String>(properties.color(), 150, "Color");
            ColorPaletteBaseAppearance appearance2 = GWT.create(ColorPaletteAppearance.class);
            appearance.setColumnCount(6);

            ColorPaletteCell colorPalette2 = new ColorPaletteCell(appearance2, COLORS, COLORS) {
                @Override
                public boolean handlesSelection() {
                    return true;
                }
            };
            colorPalette2.addSelectionHandler(new SelectionHandler<String>() {
                @Override
                public void onSelection(SelectionEvent<String> event) {
                    Info.display("Color Selected", "You selected " + event.getSelectedItem());
                }
            });
            colorColumn2.setCell(colorPalette2);

            ////////////////////////////////////////////////////////// progressColumn
//            final ColumnConfig<Plant, Double> progressColumn = new ColumnConfig<Plant, Double>(properties.progress(), 50); //final ColumnConfig<Plant, Double> progressColumn = new ColumnConfig<Plant, Double>(properties.progress(), 150, "Progress");
//            final ProgressBarCell progress = new ProgressBarCell() {
//                @Override
//                public boolean handlesSelection() {
//                    return true;
//                }
//            };
//            progress.setProgressText("{0}% Complete");
//            progress.setWidth(140);
//            progressColumn.setCell(progress);

            //////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////
            List<ColumnConfig<Plant, ?>> columns = new ArrayList<ColumnConfig<Plant, ?>>();
            columns.add(selectionModel.getColumn());
            columns.add(colorColumn);
            columns.add(availableColumn);
            columns.add(nameColumn); //columns.add(lightColumn);
            columns.add(colorColumn2); //columns.add(difficultyColumn);
//            columns.add(progressColumn);

            ColumnModel<Plant> cm = new ColumnModel<Plant>(columns);

            List<Plant> plants = new ArrayList<Plant>(TestData.getPlants());
            for (Plant p : plants) {
                p.setColor(COLORS[Random.nextInt(4)]);
            }

            store = new ListStore<Plant>(properties.key());
            store.addAll(plants);

            final Grid<Plant> grid = new Grid<Plant>(store, cm);
            grid.getView().setAutoExpandColumn(nameColumn);
            grid.getView().setTrackMouseOver(false);
//            grid.getColumnModel().addColumnWidthChangeHandler(new CellGridExample.CellColumnResizer<Plant, Double>(grid, progressColumn, progress));

            panel = new ContentPanel();
            panel.add(grid);
            panel.setHeaderVisible(false);
            panel.setHeight(200);
        }
        return panel;
    }

    interface PlaceProperties extends PropertyAccess<Plant> {
        ValueProvider<Plant, Date> available();

        @Path("name")
        ModelKeyProvider<Plant> key();

        ValueProvider<Plant, String> name();

        ValueProvider<Plant, Integer> difficulty();

        ValueProvider<Plant, Double> progress();

        ValueProvider<Plant, String> color();

        ValueProvider<Plant, String> light();
    }

//    public class CellColumnResizer<M, T> implements ColumnWidthChangeHandler {
//        private Grid<M>              grid;
//        private ColumnConfig<M, T> column;
//        private ResizeCell<T>        cell;
//
//        public CellColumnResizer(Grid<M> grid, ColumnConfig<M, T> column, ResizeCell<T> cell) {
//            this.grid = grid;
//            this.column = column;
//            this.cell = cell;
//        }
//
//        @Override
//        public void onColumnWidthChange(ColumnWidthChangeEvent event) {
//            if (column == event.getColumnConfig()) {
//                int w = event.getColumnConfig().getWidth();
//                int rows = store.size();
//
//                int col = grid.getColumnModel().indexOf(column);
//
//                cell.setWidth(w - 20);
//
//                ListStore<M> store = grid.getStore();
//
//                for (int i = 0; i < rows; i++) {
//                    M p = grid.getStore().get(i);
//
//                    // option 1
//                    // could be better for force fit where all columns are resized
//                    // would need to run deferred using DelayedTask to ensure only run once
//                    // grid.getStore().update(p);
//
//                    // option 2
//                    Element parent = grid.getView().getCell(i, col);
//                    if (parent != null) {
//                        parent = parent.getFirstChildElement();
//                        SafeHtmlBuilder sb = new SafeHtmlBuilder();
//                        cell.render(new Context(i, col, store.getKeyProvider().getKey(p)), column.getValueProvider().getValue(p),
//                                sb);
//                        parent.setInnerSafeHtml(sb.toSafeHtml());
//                    }
//                }
//            }
//        }
//    }
}
