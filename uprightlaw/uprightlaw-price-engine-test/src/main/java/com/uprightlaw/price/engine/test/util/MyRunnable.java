package com.uprightlaw.price.engine.test.util;

import com.uprightlaw.price.engine.test.model.PriceModel;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by peng cheng on 2017/9/18.
 */
public class MyRunnable implements Runnable,Callable<Integer> {
    private List<PriceModel> list;
    private Integer flag;

    public MyRunnable(List<PriceModel> list,int flag){
        this.list = list;
        this.flag = flag;
    }
    @Override
    public Integer call() throws Exception {
        return flag;
    }
    @Override
    public void run() {
        PriceEngineUtil priceUtil = new PriceEngineUtil();
        if(list.get(0).getChapter().equals("chapter7")){
            for (int i = 0; i < list.size(); i++) {
                boolean tmpFlag = priceUtil.cha7Test(list.get(i));
                if(!tmpFlag){
                    this.flag++;
                }
            }
        }else{
            for (int i = 0; i < list.size(); i++) {
                boolean tmpFlag = priceUtil.cha13Test(list.get(i));
                if(!tmpFlag){
                    this.flag++;
                }
            }
        }

    }
	public Integer getFlag() {
		return flag;
	}
}
