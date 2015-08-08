package com.iloire.watchmen;

import com.iloire.watchmen.models.ServiceReport;
import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface WatchmenService {
    @GET("/api/report/services")
    void  getServices(Callback<List<ServiceReport>> cb);
}
