package com.webapp.gwtapp.client.start;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.webapp.gwtapp.client.activity.UserPlace;

public class StartWidget extends Composite implements StartView{
    private static StartViewBinder binder = GWT.create(StartViewBinder.class);
    private Presenter presenter;
    @UiField
    Anchor userLink;

    public StartWidget() {
        initWidget(binder.createAndBindUi(this));
    }

    @UiHandler("userLink")
    void onClickUsersLink(ClickEvent event){
        presenter.goTo(new UserPlace());
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


    interface StartViewBinder extends UiBinder<Widget, StartWidget> {
    }
}
