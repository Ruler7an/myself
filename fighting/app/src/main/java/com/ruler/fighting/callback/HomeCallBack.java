package com.ruler.fighting.callback;

import com.ruler.fighting.bean.HomeBean;

import java.util.ArrayList;

/**
 * name:SailCheung
 * date:2019-06-12
 * time:下午 09:00
 * year:2019
 * project_name:fighting
 */
public interface HomeCallBack {
    void onSuccess(ArrayList<HomeBean.ResultsBean> ok);

    void onFail(String no);
}
