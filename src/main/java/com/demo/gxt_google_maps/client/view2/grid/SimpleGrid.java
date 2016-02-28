package com.demo.gxt_google_maps.client.view2.grid;

import com.demo.gxt_google_maps.client.view2.model.Contact;
import com.demo.gxt_google_maps.client.view2.model.ContactProperties;
import com.demo.gxt_google_maps.client.view2.util.ContactTestData;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.HTML;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.theme.base.client.colorpalette.ColorPaletteBaseAppearance;
import com.sencha.gxt.widget.core.client.ColorPaletteCell;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.RowExpander;

import java.util.ArrayList;
import java.util.List;

public class SimpleGrid extends Grid<Contact> {
	private static final ContactProperties props = GWT.create(ContactProperties.class);
    private static final String[]                  COLORS = {"82a700"};
	private static ColumnConfig<Contact, String>  nameCol = new ColumnConfig<Contact, String>(props.name(), 150, "Name");
	private static ColumnConfig<Contact, String> phoneCol = new ColumnConfig<Contact, String>(props.phone(), 75, "Phone");
	private static ColumnConfig<Contact, String> emailCol = new ColumnConfig<Contact, String>(props.email(), 150, "Email");
    private static ColumnConfig<Contact, String> colorCol = new ColumnConfig<Contact, String>(props.name(), 25, "Name");
    private static ColumnConfig<Contact, String> colorCol2 = new ColumnConfig<Contact, String>(props.name(), 25, "Name");
    private static ColumnConfig<Contact, String> iconCol = new ColumnConfig<Contact,String>(props.name(),25,"Name");




    static ContentPanel[] nowPanel = new ContentPanel[20], routesPanel = new ContentPanel[20], notificationsPanel = new ContentPanel[20];
    static TabPanel[] tabPanel = new TabPanel[20];
    static int counter = 0;

    public SimpleGrid() {
        super(generateData(), createColumnModel());

        this.setAllowTextSelection(true);
        this.getView().setStripeRows(true);
        this.getView().setColumnLines(true);
        this.getView().setAutoExpandColumn(nameCol);
        this.setBorders(false);
        this.setColumnReordering(true);
        this.setStateful(false);
        rowExpander.initPlugin(this);
    }

    private static RowExpander<Contact> rowExpander = new RowExpander<Contact>(new AbstractCell<Contact>() {
        @Override
        public void render(Context context, Contact value, SafeHtmlBuilder sb) {
//            ContentPanel nowPanel = new ContentPanel(), routesPanel = new ContentPanel(), notificationsPanel = new ContentPanel();
//            TabPanel tabPanel = new TabPanel();
            nowPanel[counter] = new ContentPanel(); routesPanel[counter] = new ContentPanel(); notificationsPanel[counter] = new ContentPanel();
            tabPanel[counter] = new TabPanel();

            nowPanel[counter].add(new HTML(value.getId() + " | " + value.getName() + " | " + value.getPhone() + " | " + value.getEmail()));
            routesPanel[counter].add(new HTML("none"));
            notificationsPanel[counter].add(new HTML("none"));
            nowPanel[counter].setHeaderVisible(false); routesPanel[counter].setHeaderVisible(false); notificationsPanel[counter].setHeaderVisible(false);
            tabPanel[counter].add(nowPanel[counter], "Сейчас");
            tabPanel[counter].add(routesPanel[counter], "Маршруты");
            tabPanel[counter].add(notificationsPanel[counter], "Оповещения");
            tabPanel[counter].setAutoSelect(true);

            //sb.appendHtmlConstant("" + tabPanel[counter]);
            VerticalLayoutContainer inWidget = new VerticalLayoutContainer();
            inWidget.add(tabPanel[counter]);
            sb.appendHtmlConstant("" + inWidget);
            counter++;
        }
    });

	private static ColumnModel<Contact> createColumnModel(){
		List<ColumnConfig<Contact, ?>> columnConfigList = new ArrayList<ColumnConfig<Contact, ?>>();

        //////////////////////////////////////////////////////////
        ColorPaletteBaseAppearance appearance = GWT.create(ColorPaletteCell.ColorPaletteAppearance.class);
        appearance.setColumnCount(1);
        ColorPaletteCell colorPalette = new ColorPaletteCell(appearance, COLORS, COLORS) {
            @Override
            public boolean handlesSelection() {
                return true;
            }
        };
        colorCol.setCell(colorPalette);
        //////////////////////////////////////////////////////////
        ImageCell ic = new ImageCell() {
            @Override
            public void render(Context context, String value, SafeHtmlBuilder sb) {
                sb.appendHtmlConstant("<div class=\"myClickableCellTestStyle\" style='cursor: pointer'/>");
                sb.appendHtmlConstant("<img src='images/icons/Ukraine.gif' style='cursor: pointer'/> ");
                sb.append(SafeHtmlUtils.fromTrustedString(value));
                sb.appendHtmlConstant("</div>");
            }
        };
        colorCol2.setCell(ic);
        //////////////////////////////////////////////////////////
        iconCol.setCell(new AbstractCell<String>() {
                            public void render(Context context, String value, SafeHtmlBuilder sb) {
                                sb.appendHtmlConstant("<img src='images/icons/Ukraine.gif'>");
                            }
        });
        //////////////////////////////////////////////////////////

        columnConfigList.add(rowExpander);
		columnConfigList.add(nameCol);
		columnConfigList.add(phoneCol);
		columnConfigList.add(emailCol);
        columnConfigList.add(colorCol);
        columnConfigList.add(colorCol2);
        columnConfigList.add(iconCol);

		return new ColumnModel<Contact>(columnConfigList);
	}

	private static ListStore<Contact> generateData(){
		ListStore<Contact> store = new ListStore<Contact>(props.key());
		store.addAll(ContactTestData.generateData());
		
		return store;
	}
}
