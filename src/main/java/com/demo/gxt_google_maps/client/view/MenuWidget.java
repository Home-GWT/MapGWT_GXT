package com.demo.gxt_google_maps.client.view;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.TreeStore;
import com.sencha.gxt.examples.resources.client.TestData;
import com.sencha.gxt.examples.resources.client.images.ExampleImages;
import com.sencha.gxt.examples.resources.client.model.BaseDto;
import com.sencha.gxt.examples.resources.client.model.FolderDto;
import com.sencha.gxt.examples.resources.client.model.MusicDto;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.treegrid.TreeGrid;

import java.util.ArrayList;
import java.util.List;

public class MenuWidget implements IsWidget {

    class KeyProvider implements ModelKeyProvider<BaseDto> {
        @Override
        public String getKey(BaseDto item) {
            return (item instanceof FolderDto ? "f-" : "m-") + item.getId().toString();
        }
    }

    @Override
    public Widget asWidget() {
        FramedPanel panel = new FramedPanel();
//        panel.setHeadingText("TreeGrid Editing");
        panel.setHeaderVisible(false);
//        panel.addStyleName("margin-10");
        panel.setPixelSize(600, 300);

        VerticalLayoutContainer v = new VerticalLayoutContainer();
        v.setBorders(true);
        panel.add(v);

        TreeStore<BaseDto> store = new TreeStore<BaseDto>(new KeyProvider());

        FolderDto root = TestData.getMusicRootFolder();
        for (BaseDto base : root.getChildren()) {
            store.add(base);
            if (base instanceof FolderDto) {
                processFolder(store, (FolderDto) base);
            }
        }

        ColumnConfig<BaseDto, String> cc1 = new ColumnConfig<BaseDto, String>(new ValueProvider<BaseDto, String>() {
            @Override
            public String getValue(BaseDto object) {
                return object.getName();
            }
            @Override
            public void setValue(BaseDto object, String value) {
                object.setName(value);
            }
            @Override
            public String getPath() {
                return "object";
            }
        });
        cc1.setHeader(SafeHtmlUtils.fromString("Object"));
        cc1.setWidth(400);

        ColumnConfig<BaseDto, String> cc2 = new ColumnConfig<BaseDto, String>(new ValueProvider<BaseDto, String>() {
            @Override
            public String getValue(BaseDto object) {
                return object instanceof MusicDto ? ((MusicDto) object).getAuthor() : "";
            }
            @Override
            public void setValue(BaseDto object, String value) {
                if (object instanceof MusicDto) {
                    ((MusicDto) object).setAuthor(value);
                }
            }
            @Override
            public String getPath() {
                return "km";
            }
        });
        cc2.setHeader(SafeHtmlUtils.fromString("km"));
        cc2.setWidth(50);

        ColumnConfig<BaseDto, String> cc3 = new ColumnConfig<BaseDto, String>(new ValueProvider<BaseDto, String>() {
            @Override
            public String getValue(BaseDto object) {
                return object instanceof MusicDto ? ((MusicDto) object).getGenre() : "";
            }
            @Override
            public void setValue(BaseDto object, String value) {
                if (object instanceof MusicDto) {
                    ((MusicDto) object).setGenre(value);
                }
            }
            @Override
            public String getPath() {
                return "connect";
            }
        });
        cc3.setHeader("Connect");
        cc3.setCell(new TextCell());
        cc3.setWidth(75);

        ColumnConfig<BaseDto, String> cc4 = new ColumnConfig<BaseDto, String>(new ValueProvider<BaseDto, String>() {
            @Override
            public String getValue(BaseDto object) {
                return object instanceof MusicDto ? ((MusicDto) object).getGenre() : "";
            }
            @Override
            public void setValue(BaseDto object, String value) {
                if (object instanceof MusicDto) {
                    ((MusicDto) object).setGenre(value);
                }
            }
            @Override
            public String getPath() {
                return "status";
            }
        });
        cc4.setHeader("Status");
        cc4.setWidth(75);

        List<ColumnConfig<BaseDto, ?>> l = new ArrayList<ColumnConfig<BaseDto, ?>>();
        l.add(cc1);
        l.add(cc2);
        l.add(cc3);
        l.add(cc4);
        ColumnModel<BaseDto> cm = new ColumnModel<BaseDto>(l);

        final TreeGrid<BaseDto> tree = new TreeGrid<BaseDto>(store, cm, cc1);
        tree.getStyle().setLeafIcon(ExampleImages.INSTANCE.music());
        tree.getView().setAutoExpandColumn(cc1);

        v.add(tree, new VerticalLayoutData(1, 1));
        return panel;
    }

    private void processFolder(TreeStore<BaseDto> store, FolderDto folder) {
        for (BaseDto child : folder.getChildren()) {
            store.add(folder, child);
            if (child instanceof FolderDto) {
                processFolder(store, (FolderDto) child);
            }
        }
    }
}
