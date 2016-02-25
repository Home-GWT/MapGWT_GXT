package com.ejemplo.sencha.client.tables.layout;

import com.ejemplo.sencha.client.tables.BasicTabExample2;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;

public class HorizontalLayoutExample3 implements IsWidget {

    private ContentPanel panel;

    @Override
    public Widget asWidget() {
        if (panel == null) {
            HorizontalLayoutContainer hlc = new HorizontalLayoutContainer();
            hlc.add(new BasicTabExample2(), new HorizontalLayoutData(0.25, 1, new Margins(10)));
            hlc.add(createLabel("Test Label 2"), new HorizontalLayoutData(0.75, 1, new Margins(10, 0, 10, 0)));

            panel = new ContentPanel();
//            panel.setHeadingHtml("Horizontal Layout");
//            panel.setPixelSize(420, 320);
            panel.add(hlc);
        }

        return panel;
    }

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.getElement().getStyle().setProperty("whiteSpace", "nowrap");
        label.addStyleName(ThemeStyles.get().style().border());
        label.addStyleName("pad-text gray-bg");

        return label;
    }
}
