package com.iloire.watchmen;

import com.iloire.watchmen.models.ServiceReport;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

public interface WatchmenService {
    @GET("/api/report/services")
    void  getServices(Callback<List<ServiceReport>> cb);

    @GET("/api/report/services/{id}")
    void  getService(@Path("id") String id, Callback<ServiceReport> cb);

}
