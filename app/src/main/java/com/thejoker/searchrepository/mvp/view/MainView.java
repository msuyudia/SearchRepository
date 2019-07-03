package com.thejoker.searchrepository.mvp.view;

import com.thejoker.searchrepository.base.BaseView;
import com.thejoker.searchrepository.mvp.model.Item;

import java.util.List;

public interface MainView extends BaseView {

    void onRepoLoad(List<Item> repos);

    void onShowDialog(String message);

    void onShowToast(String message);

    void onHideDialog();

    void onClearItem();

}
