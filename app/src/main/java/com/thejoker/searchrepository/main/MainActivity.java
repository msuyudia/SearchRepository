package com.thejoker.searchrepository.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.thejoker.searchrepository.R;
import com.thejoker.searchrepository.adapter.RepoAdapter;
import com.thejoker.searchrepository.base.BaseActivity;
import com.thejoker.searchrepository.dagger.component.DaggerRepoComponent;
import com.thejoker.searchrepository.dagger.module.RepoModule;
import com.thejoker.searchrepository.mvp.model.Item;
import com.thejoker.searchrepository.mvp.presenter.RepoPresenter;
import com.thejoker.searchrepository.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainView, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.et_sv)
    EditText etSearch;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.srl)
    SwipeRefreshLayout srl;
    @Inject
    RepoPresenter presenter;
    private RepoAdapter adapter;
    private String topic;

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        super.onViewReady(savedInstanceState);
        initialRepo();
        loadRepo();
    }

    private void initialRepo() {
        srl.setOnRefreshListener(this);
        adapter = new RepoAdapter(getLayoutInflater());
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    private void loadRepo() {
        presenter.getRepo();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_search)
    void onClickSearch() {
        topic = etSearch.getText().toString().trim();
        if (!topic.isEmpty()) {
            Log.d(TAG, "onClickSearch: " + topic);
            presenter.findTopic(topic);
            etSearch.setFocusable(false);
        }
    }

    @Override
    public void onRepoLoad(List<Item> repos) {
        Log.d(TAG, "onRepoLoad: " + repos);
        adapter.addRepo(repos);
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onShowToast(String message) {
        showToast(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onClearItem() {
        adapter.clearRepo();
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerRepoComponent.builder()
                .applicationComponent(getApplicationComponent())
                .repoModule(new RepoModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onRefresh() {
        srl.setRefreshing(false);
        loadRepo();
    }
}
