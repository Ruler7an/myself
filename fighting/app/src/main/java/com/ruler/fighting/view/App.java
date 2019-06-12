package com.ruler.fighting.view;

import android.app.Application;

import com.ruler.fighting.dao.CollectBeanDao;
import com.ruler.fighting.dao.DaoMaster;
import com.ruler.fighting.dao.DaoSession;

/**
 * name:SailCheung
 * date:2019-06-13
 * time:上午 12:49
 * year:2019
 * project_name:fighting
 */
public class App extends Application {

    public static CollectBeanDao mCollectBeanDao;
    public static App app;
    @Override
    public void onCreate() {
        super.onCreate();
        initView();
        app = this;
    }

    public static CollectBeanDao getmCollectBeanDao() {
        return mCollectBeanDao;
    }

    private void initView() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "my.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mCollectBeanDao = daoSession.getCollectBeanDao();
    }
}
