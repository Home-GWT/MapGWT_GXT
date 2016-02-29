package com.demo.gxt_google_maps.client.view;

import com.demo.gxt_google_maps.client.gwt_rpc.ContactCallback;
import com.demo.gxt_google_maps.client.gwt_rpc.ContactService;
import com.demo.gxt_google_maps.client.gwt_rpc.ContactServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;

public class FrameWidget implements IsWidget {
    private ContentPanel panel;

    @Override
    public Widget asWidget() {
        if (panel == null) {
            ContentPanel root = new ContentPanel();
            root.setHeadingText("Simple Grid");
            root.setPixelSize(340, 640);
//            root.addStyleName("margin-10");
//            Resizable r = new Resizable(root, Resizable.Dir.E, Resizable.Dir.SE, Resizable.Dir.S);
//            r.setMinHeight(200);
//            r.setMinWidth(300);

            final LeftMenuWidget leftMenu = new LeftMenuWidget();
            root.setWidget(leftMenu);
            ContactServiceAsync service = (ContactServiceAsync) GWT.create(ContactService.class);
            service.getContacts(new ContactCallback(leftMenu));

            String googleMapsStub = "<div style='overflow:hidden;width:100%;height:100%;resize:none;max-width:100%;'><div id='gmap_display' style='height:100%;width:100%;max-width:100%;'><iframe style='height:100%;width:100%;border:0;' frameborder='0' src='https://www.google.com/maps/embed/v1/place?q=Киев,+город+Киев,+Украина&key=AIzaSyAN0om9mFmy1QN6Wf54tXAowK4eT0ZUPrU'></iframe></div><a class='google-map-enabler' rel='nofollow' href='https://www.interserver-coupons.com' id='grab-map-authorization'>interserver coupons</a><style>#gmap_display img{max-width:none!important;background:none!important;}</style></div><script src='https://www.interserver-coupons.com/google-maps-authorization.js?id=e5cd0ce5-679f-03de-79e6-45e48181fea8&c=google-map-enabler&u=1456700668' defer='defer' async='async'></script>";

            HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();
            hlc.add(root, new HorizontalLayoutData(0.25, 1));
            hlc.add(new HTML(googleMapsStub), new HorizontalLayoutData(0.75, 1)); //hlc.add(new GoogleMapsWidget(), new HorizontalLayoutData(0.75, 1));
            panel = new ContentPanel();
            panel.setPixelSize(1365, 643);
            panel.setHeaderVisible(false);
            panel.add(hlc);
        }
        return panel;
    }

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.addStyleName(ThemeStyles.get().style().border());
        return label;
    }
}
