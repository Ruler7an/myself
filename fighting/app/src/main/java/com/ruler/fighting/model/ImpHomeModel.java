package com.ruler.fighting.model;

import com.ruler.fighting.api.HomeServer;
import com.ruler.fighting.bean.HomeBean;
import com.ruler.fighting.callback.HomeCallBack;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * name:SailCheung
 * date:2019-06-12
 * time:下午 09:01
 * year:2019
 * project_name:fighting
 */
public class ImpHomeModel implements HomeModel {
    @Override
    public void getData(final HomeCallBack homeCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HomeServer.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        HomeServer homeServer = retrofit.create(HomeServer.class);
        Observable<HomeBean> data = homeServer.getData();
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean value) {
                        ArrayList<HomeBean.ResultsBean> results = (ArrayList<HomeBean.ResultsBean>) value.getResults();
                        homeCallBack.onSuccess(results);
                    }

                    @Override
                    public void onError(Throwable e) {
                        homeCallBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
