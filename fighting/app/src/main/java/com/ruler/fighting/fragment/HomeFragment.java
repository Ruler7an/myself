package com.ruler.fighting.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruler.fighting.R;
import com.ruler.fighting.adapter.HomeAdapter;
import com.ruler.fighting.bean.CollectBean;
import com.ruler.fighting.bean.HomeBean;
import com.ruler.fighting.dao.CollectBeanDao;
import com.ruler.fighting.model.ImpHomeModel;
import com.ruler.fighting.presenter.ImpHomePresenter;
import com.ruler.fighting.view.App;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements com.ruler.fighting.view.View {


    private ArrayList<HomeBean.ResultsBean> list;
    private HomeAdapter adapter;
    private RecyclerView mRvHome;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = getView();
        mRvHome = view.findViewById(R.id.rv_home);
        initData();
        initView();
    }

    private void initView() {
        list = new ArrayList<>();
        mRvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HomeAdapter(getContext(),list);
        mRvHome.setAdapter(adapter);
        adapter.setRecOnclick(new HomeAdapter.RecOnclick() {
            @Override
            public void OnClick(int i) {
                CollectBeanDao collectBeanDao = App.getmCollectBeanDao();
                collectBeanDao.insertOrReplaceInTx(new CollectBean(null,list.get(i).getUrl(),list.get(i).getDesc()));
            }
        });
    }

    private void initData() {
        ImpHomePresenter impHomePresenter = new ImpHomePresenter(new ImpHomeModel(), this);
        impHomePresenter.getData();
    }


    @Override
    public void onSuccess(ArrayList<HomeBean.ResultsBean> ok) {
        list.addAll(ok);
        adapter.notifyDataSetChanged();
        Log.e("Tag",""+ok.toString());
    }

    @Override
    public void onFail(String no) {
        Log.e("Tag",""+no);
    }
}
