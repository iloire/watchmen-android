package com.iloire.watchmen.service;

import com.iloire.watchmen.Settings;
import com.iloire.watchmen.models.ServiceReport;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.Path;

/**
 * Facade for retrofit's service API
 */
public class WatchmenService implements WatchmenRESTService {

    private RestAdapter restAdapter;
    private final WatchmenRESTService watchmenRESTService;

    public WatchmenService(){
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(Settings.getServiceBaseUrl())
                .build();

        watchmenRESTService = restAdapter.create(WatchmenRESTService.class);
    }

    public void getServices(Callback<List<ServiceReport>> cb) {
        watchmenRESTService.getServices(cb);
    }

    public void getService(@Path("id") String id, Callback<ServiceReport> cb){
        watchmenRESTService.getService(id, cb);
    }
}
