package com.demo.gxt_google_maps.client.view;

import com.demo.gxt_google_maps.client.rpc.UtilDataTransit;
import com.demo.gxt_google_maps.shared.Transit;
import com.demo.gxt_google_maps.client.rpc.GWTServiceStub;
import com.demo.gxt_google_maps.shared.HeadTransit;
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

public class MenuWidget extends Grid<Transit> {

	private static final GWTServiceStub                 service = GWT.create(GWTServiceStub.class);
	private static ColumnConfig<Transit, Boolean>       viewCol = new ColumnConfig<Transit, Boolean>(service.wifi(), 30, SafeHtmlUtils.fromSafeConstant("<img alt='View' src='img/view.png' width='23' style='margin-top:-4px; margin-left:-1px;'/>"));
    private static ColumnConfig<Transit, Boolean>      foundCol = new ColumnConfig<Transit, Boolean>(service.wifi(), 30, SafeHtmlUtils.fromSafeConstant("<img alt='Found' src='img/found.png' width='23' style='margin-top:-4px; margin-left:-1px;'/>"));
	private static ColumnConfig<Transit, HeadTransit> objectCol = new ColumnConfig<Transit, HeadTransit>(service.object(), 230, SafeHtmlUtils.fromSafeConstant("<center>Объект</center>"));
    private static ColumnConfig<Transit, Integer>      phoneCol = new ColumnConfig<Transit, Integer>(service.speed(), 40, "км/ч");
    private static ColumnConfig<Transit, Boolean>       wifiCol = new ColumnConfig<Transit,Boolean>(service.wifi(),30, SafeHtmlUtils.fromSafeConstant("<img alt='Wi-Fi' src='img/wifi.png' width='23' style='margin-top:-4px; margin-left:-1px;'/>"));
    static ContentPanel[] nowPanel = new ContentPanel[20], routesPanel = new ContentPanel[20], notificationsPanel = new ContentPanel[20];
    static TabPanel[] tabPanel = new TabPanel[20];
    static int counter = 0;

    private static RowExpander<Transit> expanderRow = new RowExpander<Transit>(new AbstractCell<Transit>() {
        @Override
        public void render(Context context, Transit value, SafeHtmlBuilder sb) {
            nowPanel[counter] = new ContentPanel(); routesPanel[counter] = new ContentPanel(); notificationsPanel[counter] = new ContentPanel();
            tabPanel[counter] = new TabPanel();

            StringBuilder expanderStringBuilder = new StringBuilder();
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

    public MenuWidget() {
        super(generateData(), createColumnModel());

        this.setAllowTextSelection(true);
        this.getView().setStripeRows(true);
        this.getView().setColumnLines(true);
        this.getView().setAutoExpandColumn(objectCol);
        this.setBorders(false);
        this.setColumnReordering(true);
        this.setStateful(false);
        expanderRow.initPlugin(this);
    }

	private static ColumnModel<Transit> createColumnModel(){
		List<ColumnConfig<Transit, ?>> columns = new ArrayList<ColumnConfig<Transit, ?>>();

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
        objectCol.setCell(new AbstractCell<HeadTransit>() {
            @Override
            public void render(Context context, HeadTransit value, SafeHtmlBuilder sb) {
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

        expanderRow.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        viewCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        foundCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        phoneCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
        wifiCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

        columns.add(expanderRow);
        columns.add(viewCol);
        columns.add(foundCol);
        columns.add(objectCol);
        columns.add(phoneCol);
        columns.add(wifiCol);
		return new ColumnModel<Transit>(columns);
	}

	private static ListStore<Transit> generateData(){
		ListStore<Transit> store = new ListStore<Transit>(service.key());
		store.addAll(UtilDataTransit.generateData());

		return store;
	}
}
