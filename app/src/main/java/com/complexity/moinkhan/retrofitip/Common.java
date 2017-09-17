package com.complexity.moinkhan.retrofitip;

import com.complexity.moinkhan.retrofitip.Remote.IpService;
import com.complexity.moinkhan.retrofitip.Remote.RetrofitClient;

/**
 * Created by moin khan on 9/17/2017.
 */

public class Common {

    private static final String BASE_URL = "http://ip.jsontest.com/";

    public static IpService getIpService()
    {
        return RetrofitClient.getClient(BASE_URL).create(IpService.class);
    }

}
