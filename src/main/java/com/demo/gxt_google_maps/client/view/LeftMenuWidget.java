package com.demo.gxt_google_maps.client.view;

import com.demo.gxt_google_maps.shared.Contact;
import com.demo.gxt_google_maps.shared.ContactProperties;
import com.demo.gxt_google_maps.shared.MyObject;
//import com.demo.gxt_google_maps.client.view2.util.ContactTestData;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.TabPanel;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.RowExpander;

import java.util.ArrayList;
import java.util.List;

public class LeftMenuWidget extends Grid<Contact> {
	private static final ContactProperties props = GWT.create(ContactProperties.class);
//    private static final String[]                  COLORS = {"82a700"};
	private static ColumnConfig<Contact, Boolean>    viewCol = new ColumnConfig<Contact, Boolean>(props.wifi(), 30, SafeHtmlUtils.fromSafeConstant("<img alt='View' src='img/view.png' width='23' style='margin-top:-4px; margin-left:-1px;' />"));
    private static ColumnConfig<Contact, Boolean>   foundCol = new ColumnConfig<Contact, Boolean>(props.wifi(), 30, SafeHtmlUtils.fromSafeConstant("<img alt='Found' src='img/found.png' width='23' style='margin-top:-4px; margin-left:-1px;' />"));
	private static ColumnConfig<Contact, MyObject> objectCol = new ColumnConfig<Contact, MyObject>(props.object(), 230, SafeHtmlUtils.fromSafeConstant("<center>Объект</center>"));
    private static ColumnConfig<Contact, Integer>   phoneCol = new ColumnConfig<Contact, Integer>(props.speed(), 40, "км/ч");
    private static ColumnConfig<Contact, Boolean>    wifiCol = new ColumnConfig<Contact,Boolean>(props.wifi(),30, SafeHtmlUtils.fromSafeConstant("<img alt='Wi-Fi' src='img/wifi.png' width='23' style='margin-top:-4px; margin-left:-1px;' />"));
//    private static ColumnConfig<Contact, String> colorCol = new ColumnConfig<Contact, String>(props.name(), 25, "Name");
//    private static ColumnConfig<Contact, String> colorCol2 = new ColumnConfig<Contact, String>(props.name(), 25, "Name");

    static ContentPanel[] nowPanel = new ContentPanel[20], routesPanel = new ContentPanel[20], notificationsPanel = new ContentPanel[20];
    static TabPanel[] tabPanel = new TabPanel[20];
    static int counter = 0;

    public LeftMenuWidget() {
        super(store, createColumnModel()); //super(generateData(), createColumnModel());

        this.setAllowTextSelection(true);
        this.getView().setStripeRows(true);
        this.getView().setColumnLines(true);
        this.getView().setAutoExpandColumn(objectCol);
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

            StringBuilder expanderStringBuilder = new StringBuilder();
//            expanderStringBuilder.append("<style type='text/css'>table.underline {border-spacing:0;width:340px;} table.underline td:first-child{width:100px;padding-left:7px;} table.underline td:last-child{width:240px;} table.underline td {border-bottom:1px solid #ddd;height:20px;} table.underline tr:last-child td {border-bottom:none;}</style>");
            expanderStringBuilder.append("<table class='underline'>");
            expanderStringBuilder.append("<tr><td>Водитель:</td> <td><font color='blue'>"+value.getFirstName()+" "+value.getLastName()+"</font></td></tr>");
            expanderStringBuilder.append("<tr><td>Время (позиция):</td> <td>"+value.getTimePosition()+"</td></tr>");
            expanderStringBuilder.append("<tr><td>Время (сервер):</td> <td>"+value.getTimeServer()+"</td></tr>");
            expanderStringBuilder.append("<tr><td>Высота:</td> <td>"+value.getHeight()+" м</td></tr>");
            expanderStringBuilder.append("<tr><td>Модель:</td> <td>"+value.getModel()+"</td></tr>");
            expanderStringBuilder.append("<tr><td>Номер:</td> <td>"+value.getNumber()+"</td></tr>");
            expanderStringBuilder.append("<tr><td>Одометр:</td> <td>"+value.getDistance()+"</td></tr>");
            expanderStringBuilder.append("<tr><td>Позиция:</td> <td><a href='https://www.google.com.ua/maps/@50.3551709,30.3359953,8.75z' target='_blank' title='Показать на карте'>" +value.getPosition()+"</a></td></tr>");
            expanderStringBuilder.append("<tr><td>Угол:</td> <td>"+value.getDegree()+"'</td></tr>");
            expanderStringBuilder.append("</table>");
            nowPanel[counter].add(new HTML(expanderStringBuilder.toString()));
            routesPanel[counter].add(new HTML("none"));
            notificationsPanel[counter].add(new HTML("none"));
            nowPanel[counter].setHeaderVisible(false); routesPanel[counter].setHeaderVisible(false); notificationsPanel[counter].setHeaderVisible(false);
            tabPanel[counter].add(nowPanel[counter], "Сейчас");
            tabPanel[counter].add(routesPanel[counter], "Маршруты");
            tabPanel[counter].add(notificationsPanel[counter], "Оповещения");
            tabPanel[counter].setAutoSelect(true);
            sb.appendHtmlConstant("" + tabPanel[counter]);
            counter++;
        }
    });

	private static ColumnModel<Contact> createColumnModel(){
		List<ColumnConfig<Contact, ?>> columnConfigList = new ArrayList<ColumnConfig<Contact, ?>>();

        viewCol.setCell(new AbstractCell<Boolean>() {
            @Override
            public void render(Context context, Boolean value, SafeHtmlBuilder sb) {
                sb.appendHtmlConstant("<input type='checkbox' checked></input>");
            }
        });
        foundCol.setCell(new AbstractCell<Boolean>() {
            @Override
            public void render(Context context, Boolean value, SafeHtmlBuilder sb) {
                if(!value){
                    sb.appendHtmlConstant("<input type='checkbox' checked></input>");
                } else {
                    sb.appendHtmlConstant("<input type='checkbox'></input>");
                }
            }
        });
        objectCol.setCell(new AbstractCell<MyObject>() {
            @Override
            public void render(Context context, MyObject value, SafeHtmlBuilder sb) {
                sb.appendHtmlConstant("<table cellspacing='3' cellpadding='0' border='0'>");
                sb.appendHtmlConstant("<tr><td rowspan='2'><img alt='"+value.getVehicleType()+"' src='img/"+value.getVehicleType()+".png' width='30'/></td><td><font color='blue'><b>"+value.getNameVehicleType()+"</b></font></td></tr>");
                sb.appendHtmlConstant("<tr><td>"+value.getTime()+"</td></tr>");
                sb.appendHtmlConstant("</table>");
            }
        });
        wifiCol.setCell(new AbstractCell<Boolean>() {
            @Override
            public void render(Context context, Boolean value, SafeHtmlBuilder sb) {
                if(value){
                    sb.appendHtmlConstant("<img src='img/wifi-enable.png'>");
                } else {
                    sb.appendHtmlConstant("<img src='img/wifi-disable.png'>");
                }
            }
        });
        //////////////////////////////////////////////////////////
//        IdentityValueProvider<Contact> identityView = new IdentityValueProvider<Contact>(), identityFound = new IdentityValueProvider<Contact>();
//        CheckBoxSelectionModel<Contact> view = new CheckBoxSelectionModel<Contact>(identityView) {
//            @Override
//            protected void onRefresh(RefreshEvent event) {
//                if (isSelectAllChecked()) {
//                    selectAll();
//                }
//                super.onRefresh(event);
//            }
//        };
//        CheckBoxSelectionModel<Contact> found = new CheckBoxSelectionModel<Contact>(identityFound) {
//            @Override
//            protected void onRefresh(RefreshEvent event) {
//                if (isSelectAllChecked()) {
//                    selectAll();
//                }
//                super.onRefresh(event);
//            }
//        };
//        ColorPaletteBaseAppearance appearance = GWT.create(ColorPaletteCell.ColorPaletteAppearance.class);
//        appearance.setColumnCount(1);
//        ColorPaletteCell colorPalette = new ColorPaletteCell(appearance, COLORS, COLORS) {
//            @Override
//            public boolean handlesSelection() {
//                return true;
//            }
//        };
//        colorCol.setCell(colorPalette);
//        //////////////////////////////////////////////////////////
//        ImageCell ic = new ImageCell() {
//            @Override
//            public void render(Context context, String value, SafeHtmlBuilder sb) {
//                sb.appendHtmlConstant("<div class=\"myClickableCellTestStyle\" style='cursor: pointer'/>");
//                sb.appendHtmlConstant("<img src='img/wifi-enable.jpg' style='cursor: pointer'/> ");
//                sb.append(SafeHtmlUtils.fromTrustedString(value));
//                sb.appendHtmlConstant("</div>");
//            }
//        };
//        colorCol2.setCell(ic);

        rowExpander.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//        rowExpander.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//        rowExpander.setColumnStyle(SafeStylesUtils.fromTrustedString("height: 37px;")); //rowExpander.setColumnStyle(SafeStylesUtils.fromTrustedString("background-color: blue; color: yellow;"));
//        rowExpander.setHeader(SafeHtmlUtils.fromSafeConstant("<img alt='View' src='img/view.png' width='23' style='margin-top:-4px; margin-left:-8px;' />"));
//        rowExpander.setColumnStyle(SafeStylesUtils.fromTrustedString("margin-top:10px;"));
        viewCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//        viewCol.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//        viewCol.setColumnStyle(SafeStylesUtils.fromTrustedString("height: 37px;"));
        foundCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//        foundCol.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//        foundCol.setColumnStyle(SafeStylesUtils.fromTrustedString("height: 37px;"));
//        objectCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//        objectCol.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//        objectCol.setColumnStyle(SafeStylesUtils.fromTrustedString("height: 37px;"));
        phoneCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//        phoneCol.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//        phoneCol.setColumnStyle(SafeStylesUtils.fromTrustedString("height: 37px;"));
        wifiCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//        wifiCol.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
//        wifiCol.setColumnStyle(SafeStylesUtils.fromTrustedString("height: 37px;"));

        columnConfigList.add(rowExpander);
        columnConfigList.add(viewCol); //columnConfigList.add(view.getColumn());
        columnConfigList.add(foundCol); //columnConfigList.add(found.getColumn());
		columnConfigList.add(objectCol);
        columnConfigList.add(phoneCol);
        columnConfigList.add(wifiCol);
//        columnConfigList.add(colorCol);
//        columnConfigList.add(colorCol2);

		return new ColumnModel<Contact>(columnConfigList);
	}

    private static ListStore<Contact> store = new ListStore<Contact>(props.key());
//	private static ListStore<Contact> generateData(){
//		ListStore<Contact> store = new ListStore<Contact>(props.key());
//		store.addAll(ContactTestData.generateData());
//
//		return store;
//	}
    public static void setStore(List<Contact> thatStore){
        store.addAll(thatStore);
    }
}
