//package com.ejemplo.sencha.client.tables.layout;
//
//import com.google.gwt.event.logical.shared.ValueChangeEvent;
//import com.google.gwt.event.logical.shared.ValueChangeHandler;
//import com.google.gwt.user.client.ui.HTML;
//import com.google.gwt.user.client.ui.IsWidget;
//import com.google.gwt.user.client.ui.Label;
//import com.google.gwt.user.client.ui.Widget;
//import com.sencha.gxt.core.client.util.Margins;
//import com.sencha.gxt.core.client.util.Padding;
//import com.sencha.gxt.core.client.util.ToggleGroup;
//import com.sencha.gxt.widget.core.client.ContentPanel;
//import com.sencha.gxt.widget.core.client.button.TextButton;
//import com.sencha.gxt.widget.core.client.button.ToggleButton;
//import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
//import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
//import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutData;
//import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
//import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
//import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer.HBoxLayoutAlign;
//import com.sencha.gxt.widget.core.client.container.MarginData;
//import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;
//import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer.VBoxLayoutAlign;
//
//
//public class HBoxLayoutExample2 implements IsWidget {
//
//    private String button1Text = "Button 1";
//    private String button2Text = "Button 2";
//    private String button3Text = "Button 3";
//    private String button4Text = "Button 4";
//    private ContentPanel lccenter;
//    private ToggleGroup toggleGroup = new ToggleGroup();
//    private ContentPanel panel;
//
//    @Override
//    public Widget asWidget() {
//        if (panel == null) {
//            BoxLayoutData vBoxData = new BoxLayoutData(new Margins(5, 5, 5, 5));
//            vBoxData.setFlex(1);
//
//            VBoxLayoutContainer lcwest = new VBoxLayoutContainer();
//            lcwest.setPadding(new Padding(5));
//            lcwest.setVBoxLayoutAlign(VBoxLayoutAlign.STRETCH);
//
//            lcwest.add(createToggleButton("Spaced", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutFlex();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Multi-Spaced", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutMultiSpaced();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Align: top", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutAlignTop();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Align: middle", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutAlignMiddle();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Align: bottom", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutAlignBottom();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Align: stretch", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutAlignStretch();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Align: stretchmax", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutAlignStretchmax();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Flex: All even", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutFlexAllEven();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Flex: ratio", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutFlexRatio();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Flex + Stretch", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutFlexStretch();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Pack: start", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutPackStart();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Pack: center", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutPackCenter();
//                    }
//                }
//            }), vBoxData);
//
//            lcwest.add(createToggleButton("Pack: end", new ValueChangeHandler<Boolean>() {
//                @Override
//                public void onValueChange(ValueChangeEvent<Boolean> event) {
//                    if (event.getValue()) {
//                        createHBoxLayoutPackEnd();
//                    }
//                }
//            }), vBoxData);
//
//            String html = "<p style=\"padding:10px;color:#556677;font-size:11px;\">Select a configuration on the left</p>";
//
//            lccenter = new ContentPanel();
//            lccenter.setHeaderVisible(false);
//            lccenter.add(new HTML(html));
//
//            BorderLayoutData west = new BorderLayoutData(150);
//            west.setMargins(new Margins(5));
//
//            MarginData center = new MarginData();
//
//            BorderLayoutContainer borderLayoutContainer = new BorderLayoutContainer();
//            borderLayoutContainer.setWestWidget(lcwest, west);
//            borderLayoutContainer.setCenterWidget(lccenter, center);
//
//            panel = new ContentPanel();
//            panel.add(borderLayoutContainer);
//        }
//
//        return panel;
//    }
//
//    protected void createHBoxLayoutPackEnd() {
//        BoxLayoutData layoutData = new BoxLayoutData(new Margins(0, 5, 0, 0));
//        BoxLayoutData layoutData2 = new BoxLayoutData(new Margins(0));
//
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);
//        c.setPack(BoxLayoutPack.END);
//        c.add(new TextButton(button1Text), layoutData);
//        c.add(new TextButton(button2Text), layoutData);
//        c.add(new TextButton(button3Text), layoutData);
//        c.add(new TextButton(button4Text), layoutData2);
//
//        addToCenter(c);
//    }
//
//    protected void createHBoxLayoutPackCenter() {
//        BoxLayoutData layoutData = new BoxLayoutData(new Margins(0, 5, 0, 0));
//        BoxLayoutData layoutData2 = new BoxLayoutData(new Margins(0));
//
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);
//        c.setPack(BoxLayoutPack.CENTER);
//        c.add(new TextButton(button1Text), layoutData);
//        c.add(new TextButton(button2Text), layoutData);
//        c.add(new TextButton(button3Text), layoutData);
//        c.add(new TextButton(button4Text), layoutData2);
//
//        addToCenter(c);
//    }
//
//    protected void createHBoxLayoutPackStart() {
//        BoxLayoutData layoutData = new BoxLayoutData(new Margins(0, 5, 0, 0));
//        BoxLayoutData layoutData2 = new BoxLayoutData(new Margins(0));
//
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);
//        c.setPack(BoxLayoutPack.START);
//        c.add(new TextButton(button1Text), layoutData);
//        c.add(new TextButton(button2Text), layoutData);
//        c.add(new TextButton(button3Text), layoutData);
//        c.add(new TextButton(button4Text), layoutData2);
//
//        addToCenter(c);
//    }
//
//    protected void createHBoxLayoutFlexStretch() {
//        BoxLayoutData flex = new BoxLayoutData(new Margins(0, 5, 0, 0));
//        flex.setFlex(1);
//
//        BoxLayoutData flex2 = new BoxLayoutData(new Margins(0));
//        flex2.setFlex(3);
//
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);
//        c.add(new TextButton(button1Text), flex);
//        c.add(new TextButton(button2Text), flex);
//        c.add(new TextButton(button3Text), flex);
//        c.add(new TextButton(button4Text), flex2);
//
//        addToCenter(c);
//    }
//
//    protected void createHBoxLayoutFlexRatio() {
//        BoxLayoutData flex = new BoxLayoutData(new Margins(0, 5, 0, 0));
//        flex.setFlex(1);
//
//        BoxLayoutData flex2 = new BoxLayoutData(new Margins(0));
//        flex2.setFlex(3);
//
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);
//        c.add(new TextButton(button1Text), flex);
//        c.add(new TextButton(button2Text), flex);
//        c.add(new TextButton(button3Text), flex);
//        c.add(new TextButton(button4Text), flex2);
//
//        addToCenter(c);
//    }
//
//    protected void createHBoxLayoutFlexAllEven() {
//        BoxLayoutData flex = new BoxLayoutData(new Margins(0, 5, 0, 0));
//        flex.setFlex(1);
//
//        BoxLayoutData flex2 = new BoxLayoutData(new Margins(0));
//        flex2.setFlex(1);
//
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);
//        c.add(new TextButton(button1Text), flex);
//        c.add(new TextButton(button2Text), flex);
//        c.add(new TextButton(button3Text), flex);
//        c.add(new TextButton(button4Text), flex2);
//
//        addToCenter(c);
//    }
//
//    protected void createHBoxLayoutAlignStretchmax() {
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCHMAX);
//        c.add(new TextButton(button1Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button2Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button3Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button4Text), new BoxLayoutData(new Margins(0)));
//
//        addToCenter(c);
//    }
//
//    protected void createHBoxLayoutAlignStretch() {
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.STRETCH);
//        c.add(new TextButton(button1Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button2Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button3Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button4Text), new BoxLayoutData(new Margins(0)));
//
//        addToCenter(c);
//    }
//
//    private void createHBoxLayoutAlignBottom() {
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.BOTTOM);
//
//        c.add(new TextButton(button1Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button2Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button3Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button4Text), new BoxLayoutData(new Margins(0)));
//
//        addToCenter(c);
//    }
//
//    private void createHBoxLayoutAlignMiddle() {
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.MIDDLE);
//        c.add(new TextButton(button1Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button2Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button3Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button4Text), new BoxLayoutData(new Margins(0)));
//
//        addToCenter(c);
//    }
//
//    private void createHBoxLayoutAlignTop() {
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.TOP);
//        c.add(new TextButton(button1Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button2Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button3Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button4Text), new BoxLayoutData(new Margins(0)));
//
//        addToCenter(c);
//    }
//
//    private void createHBoxLayoutMultiSpaced() {
//        BoxLayoutData flex = new BoxLayoutData(new Margins(0, 5, 0, 0));
//        flex.setFlex(1);
//
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.TOP);
//        c.add(new TextButton(button1Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new Label(), flex);
//        c.add(new TextButton(button2Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new Label(), flex);
//        c.add(new TextButton(button3Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new Label(), flex);
//        c.add(new TextButton(button4Text), new BoxLayoutData(new Margins(0)));
//
//        addToCenter(c);
//    }
//
//    private void createHBoxLayoutFlex() {
//        BoxLayoutData flex = new BoxLayoutData(new Margins(0, 5, 0, 0));
//        flex.setFlex(1);
//
//        HBoxLayoutContainer c = new HBoxLayoutContainer();
//        c.setPadding(new Padding(5));
//        c.setHBoxLayoutAlign(HBoxLayoutAlign.TOP);
//        c.add(new TextButton(button1Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new Label(), flex);
//        c.add(new TextButton(button2Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button3Text), new BoxLayoutData(new Margins(0, 5, 0, 0)));
//        c.add(new TextButton(button4Text), new BoxLayoutData(new Margins(0)));
//
//        addToCenter(c);
//    }
//
//    private void addToCenter(Widget c) {
//        lccenter.clear();
//        lccenter.add(c);
//        lccenter.forceLayout();
//    }
//
//    private ToggleButton createToggleButton(String name, ValueChangeHandler<Boolean> valueChangeHandler) {
//        ToggleButton button = new ToggleButton(name);
//        button.addValueChangeHandler(valueChangeHandler);
//        button.setAllowDepress(false);
//
//        toggleGroup.add(button);
//
//        return button;
//    }
//
//}
