package com.ruler.fighting.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ruler.fighting.R;
import com.ruler.fighting.adapter.CollectAdapter;
import com.ruler.fighting.adapter.HomeAdapter;
import com.ruler.fighting.bean.CollectBean;
import com.ruler.fighting.bean.HomeBean;
import com.ruler.fighting.dao.CollectBeanDao;
import com.ruler.fighting.view.App;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends Fragment {


    private RecyclerView mRv_collect;
    private ArrayList<CollectBean> collectBeans = new ArrayList<>();
    private CollectAdapter adapter;

    public CollectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_collect, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        View view = getView();
        mRv_collect = view.findViewById(R.id.rv_collect);

    }
    public void setUserVisibleHint(boolean isVisibleToUser) {
            super.setUserVisibleHint(isVisibleToUser);
            if (getUserVisibleHint()){
                initData();
                //getdao();
            }else {
                collectBeans.clear();
                //清除集合
            }
        }

    private void initData() {
        CollectBeanDao collectBeanDao = App.getmCollectBeanDao();
        collectBeans = (ArrayList<CollectBean>) collectBeanDao.loadAll();
        mRv_collect.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CollectAdapter(getContext(), collectBeans);
        mRv_collect.setAdapter(this.adapter);
    }
}
