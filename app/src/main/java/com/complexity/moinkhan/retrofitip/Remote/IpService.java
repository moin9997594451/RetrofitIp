package com.complexity.moinkhan.retrofitip.Remote;

import com.complexity.moinkhan.retrofitip.Model.Ip;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by moin khan on 9/17/2017.
 */

public interface IpService {

    @GET("/")
    Call<Ip> getIp();

}
