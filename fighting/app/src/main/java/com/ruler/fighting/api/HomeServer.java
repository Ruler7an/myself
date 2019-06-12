package com.ruler.fighting.api;

import com.ruler.fighting.bean.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * name:SailCheung
 * date:2019-06-12
 * time:下午 08:57
 * year:2019
 * project_name:fighting
 */
public interface HomeServer {
    String BaseUrl = "http://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/3")
    Observable<HomeBean> getData();
}
