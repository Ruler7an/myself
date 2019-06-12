package com.ruler.fighting.presenter;

import com.ruler.fighting.bean.HomeBean;
import com.ruler.fighting.callback.HomeCallBack;
import com.ruler.fighting.model.ImpHomeModel;
import com.ruler.fighting.view.View;

import java.util.ArrayList;

/**
 * name:SailCheung
 * date:2019-06-12
 * time:下午 09:04
 * year:2019
 * project_name:fighting
 */
public class ImpHomePresenter implements HomePresenter, HomeCallBack {

    private ImpHomeModel model;
    private View view;

    public ImpHomePresenter(ImpHomeModel model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData() {
        model.getData(this);
    }

    @Override
    public void onSuccess(ArrayList<HomeBean.ResultsBean> ok) {
        view.onSuccess(ok);
    }

    @Override
    public void onFail(String no) {
        view.onFail(no);
    }
}
