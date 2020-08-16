package com.webapp.gwtapp.client.users;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.ColumnSortList;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.webapp.gwtapp.client.UserList;
import com.webapp.gwtapp.client.UserListAsync;
import com.webapp.gwtapp.model.User;

import java.util.List;

public class UserWidget extends Composite implements UserView {
    Binder binder = GWT.create(Binder.class);
    @UiField
    CellTable<User> userCellTable;
    private static final int PAGE_SIZE = 50;
    private final UserListAsync userListAsync = GWT.create(UserList.class);
    private AsyncDataProvider<User> dataProvider;

    public UserWidget() {
        initWidget(binder.createAndBindUi(this));
    }

    @Override
    protected void initWidget(Widget widget) {
        super.initWidget(widget);
        initCellTable(userCellTable);
        dataProvider = initDataProvider(userCellTable);
        ColumnSortEvent.AsyncHandler columnSortHandler = new ColumnSortEvent.AsyncHandler(userCellTable);
        userCellTable.addColumnSortHandler(columnSortHandler);
        dataProvider.addDataDisplay(userCellTable);
        userCellTable.setPageSize(PAGE_SIZE);
    }

    private void initCellTable(CellTable<User> userCellTable) {
        TextColumn<User> idColumn = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getId().toString();
            }
        };
        TextColumn<User> nameColumn = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getName();
            }
        };
        TextColumn<User> loginColumn = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getLogin();
            }
        };
        TextColumn<User> descriptionColumn = new TextColumn<User>() {
            @Override
            public String getValue(User object) {
                return object.getDescription();
            }
        };
        idColumn.setSortable(true);
        userCellTable.addColumn(idColumn, "ID");
        userCellTable.addColumn(nameColumn, "Name");
        userCellTable.addColumn(loginColumn, "Login");
        userCellTable.addColumn(descriptionColumn, "Description");
        userCellTable.getColumnSortList().push(idColumn);
    }

    private AsyncDataProvider<User> initDataProvider(CellTable<User> userCellTable){
       return dataProvider = new AsyncDataProvider<User>() {
            @Override
            protected void onRangeChanged(HasData display) {
                AsyncCallback<List<User>> callback = new AsyncCallback<List<User>>() {
                    @Override
                    public void onFailure(Throwable caught) {
                        Window.alert(caught.getMessage());
                    }
                    @Override
                    public void onSuccess(List<User> result) {
                        updateRowData(0, result);
                    }
                };
                userListAsync.getUserList(userCellTable.getColumnSortList().get(0).isAscending() ,callback);
            }
        };
    }

    interface Binder extends UiBinder<Widget, UserWidget> {
    }
}
