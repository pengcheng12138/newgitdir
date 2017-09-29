package com.uprightlaw.price.engine.test.service;

import com.uprightlaw.price.engine.test.model.PriceModel;
import com.uprightlaw.price.engine.test.util.MyRunnable;
import com.uprightlaw.price.engine.test.util.PriceEngineUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by peng cheng on 2017/9/14.
 */
public class PriceTestService {
	private static final PriceEngineUtil priceUtil = new PriceEngineUtil();
	private static final double CH7_FIPS1_COMPLEX = 1985.00;
	private static final double CH7_FIPS1_OWNS_REAL_ESTATE = 1885.00;
	private static final double TEMP_OWNS = 2110.00;
	private static final double CH7_FIPS1_MARRIED = 1835.00;
	private static final double CH7_FIPS1_Individual = 1735.00;
	private static final double CH7_FIPS2_COMPLEX = 2235.00;
	private static final double CH7_FIPS2_OWNS_REAL_ESTATE = 2135.00;
	private static final double CH7_FIPS2_MARRIED = 2035.00;
	private static final double CH7_FIPS2_Individual = 1985.00;
	private static final double CH13_FIP1_NORUSH = 1860.00;
	private static final double CH13_FIP1_RUSH_8_30 = 2310.00;
	private static final double CH13_FIP1_RUSH_1_7 = 2810.00;
	private static final double CH13_FIP1_OVER = 3510.00;
	private static final double CH13_FIP1_UNDER = 3310.00;
	private static final double CH13_FIP2_NORUSH = 1860.00;
	private static final double CH13_FIP2_RUSH_8_30 = 2410.00;
	private static final double CH13_FIP2_RUSH_1_7 = 2910.00;
	private static final double CH13_FIP2_OVER = 3785.00;
	private static final double CH13_FIP2_UNDER = 3785.00;
	private static final String CHAPTER7 = "chapter7";
	private static final String CHAPTER13 = "chapter13";
	private static final String DISQUALIFIED_FIPS = "37011";
	private static final String TEMP_FIPS = "17107";
	private static final String CH7_FIPS1 = "01001";
	private static final String CH7_FIPS2 = "12043";
	private static final String CH13_FIPS2 = "13045";
	private static final String SINGLE = "single";
	private static final String MARRIED = "married";

	private PriceModel ch7_disqualified = new PriceModel();
	private PriceModel ch7_fips1_complex1 = new PriceModel();
	private PriceModel ch7_fips1_complex2 = new PriceModel();
	private PriceModel ch7_fips1_complex3 = new PriceModel();
	private PriceModel ch7_fips1_owns_real_estate = new PriceModel();
	private PriceModel ch7_fips1_individual = new PriceModel();
	private PriceModel ch7_fips1_married = new PriceModel();
	private PriceModel ch7_fips2_complex1 = new PriceModel();
	private PriceModel ch7_fips2_complex2 = new PriceModel();
	private PriceModel ch7_fips2_complex3 = new PriceModel();
	private PriceModel ch7_fips2_owns_real_estate = new PriceModel();
	private PriceModel ch7_fips2_individual = new PriceModel();
	private PriceModel ch7_fips2_married = new PriceModel();

	private PriceModel ch13_disqualified = new PriceModel();
	private PriceModel ch13_fips1_null_totalPrice = new PriceModel();
	private PriceModel ch13_fips2_null_totalPrice = new PriceModel();
	private PriceModel ch13_fips1_over = new PriceModel();
	private PriceModel ch13_fips1_over1 = new PriceModel();
	private PriceModel ch13_fips1_over2 = new PriceModel();
	private PriceModel ch13_fips1_under = new PriceModel();
	private PriceModel ch13_fips1_under1 = new PriceModel();
	private PriceModel ch13_fips1_under2 = new PriceModel();
	private PriceModel ch13_fips2_over = new PriceModel();
	private PriceModel ch13_fips2_over1 = new PriceModel();
	private PriceModel ch13_fips2_over2 = new PriceModel();
	private PriceModel ch13_fips2_under = new PriceModel();
	private PriceModel ch13_fips2_under1 = new PriceModel();
	private PriceModel ch13_fips2_under2 = new PriceModel();

	public int checkPrice(){
		List<PriceModel> priceModelList = new ArrayList<PriceModel>();
		List<PriceModel> priceModelList1 = new ArrayList<PriceModel>();
		List<PriceModel> priceModelList2 = new ArrayList<PriceModel>();
		List<PriceModel> priceModelList3 = new ArrayList<PriceModel>();
		ch7_disqualified.setChapter(CHAPTER7);
		ch7_disqualified.setFips(DISQUALIFIED_FIPS);
		ch7_disqualified.setSelfemployed(true);
		priceModelList.add(ch7_disqualified);

		ch7_fips1_complex1.setChapter(CHAPTER7);
		ch7_fips1_complex1.setFips(CH7_FIPS1);
		ch7_fips1_complex1.setSelfemployed(true);
		ch7_fips1_complex1.setExpectPrice(CH7_FIPS1_COMPLEX);
		priceModelList.add(ch7_fips1_complex1);

		ch7_fips1_complex2.setChapter(CHAPTER7);
		ch7_fips1_complex2.setFips(CH7_FIPS1);
		ch7_fips1_complex2.setSelfemployed(false);
		ch7_fips1_complex2.setNumberOfProperties(2);
		ch7_fips1_complex2.setExpectPrice(CH7_FIPS1_COMPLEX);
		priceModelList.add(ch7_fips1_complex2);

		ch7_fips1_complex3.setChapter(CHAPTER7);
		ch7_fips1_complex3.setFips(CH7_FIPS1);
		ch7_fips1_complex3.setSelfemployed(false);
		ch7_fips1_complex3.setNumberOfProperties(1);
		ch7_fips1_complex3.setHouseholdMember(1);
		ch7_fips1_complex3.setIncome(500000.00);
		ch7_fips1_complex3.setExpectPrice(CH7_FIPS1_COMPLEX);
		priceModelList.add(ch7_fips1_complex3);

		ch7_fips1_owns_real_estate.setChapter(CHAPTER7);
		ch7_fips1_owns_real_estate.setFips(CH7_FIPS1);
		ch7_fips1_owns_real_estate.setSelfemployed(false);
		ch7_fips1_owns_real_estate.setNumberOfProperties(1);
		ch7_fips1_owns_real_estate.setHouseholdMember(1);
		ch7_fips1_owns_real_estate.setIncome(123.00);
		ch7_fips1_owns_real_estate.setExpectPrice(CH7_FIPS1_OWNS_REAL_ESTATE);
		priceModelList.add(ch7_fips1_owns_real_estate);

		ch7_fips1_individual.setChapter(CHAPTER7);
		ch7_fips1_individual.setFips(CH7_FIPS1);
		ch7_fips1_individual.setSelfemployed(false);
		ch7_fips1_individual.setNumberOfProperties(0);
		ch7_fips1_individual.setHouseholdMember(1);
		ch7_fips1_individual.setIncome(123.00);
		ch7_fips1_individual.setMaritalStatus(SINGLE);
		ch7_fips1_individual.setExpectPrice(CH7_FIPS1_Individual);
		priceModelList.add(ch7_fips1_individual);

		ch7_fips1_married.setChapter(CHAPTER7);
		ch7_fips1_married.setFips(CH7_FIPS1);
		ch7_fips1_married.setSelfemployed(false);
		ch7_fips1_married.setNumberOfProperties(0);
		ch7_fips1_married.setHouseholdMember(1);
		ch7_fips1_married.setIncome(123.00);
		ch7_fips1_married.setMaritalStatus(MARRIED);
		ch7_fips1_married.setExpectPrice(CH7_FIPS1_MARRIED);
		priceModelList.add(ch7_fips1_married);


		ch7_fips2_complex1.setChapter(CHAPTER7);
		ch7_fips2_complex1.setFips(CH7_FIPS2);
		ch7_fips2_complex1.setSelfemployed(true);
		ch7_fips2_complex1.setExpectPrice(CH7_FIPS2_COMPLEX);
		priceModelList1.add(ch7_fips1_complex1);

		ch7_fips2_complex2.setChapter(CHAPTER7);
		ch7_fips2_complex2.setFips(CH7_FIPS2);
		ch7_fips2_complex2.setSelfemployed(false);
		ch7_fips2_complex2.setNumberOfProperties(2);
		ch7_fips2_complex2.setExpectPrice(CH7_FIPS2_COMPLEX);
		priceModelList1.add(ch7_fips1_complex2);

		ch7_fips2_complex3.setChapter(CHAPTER7);
		ch7_fips2_complex3.setFips(CH7_FIPS2);
		ch7_fips2_complex3.setSelfemployed(false);
		ch7_fips2_complex3.setNumberOfProperties(1);
		ch7_fips2_complex3.setHouseholdMember(1);
		ch7_fips2_complex3.setIncome(500000.00);
		ch7_fips2_complex3.setExpectPrice(CH7_FIPS2_COMPLEX);
		priceModelList1.add(ch7_fips1_complex3);

		ch7_fips2_owns_real_estate.setChapter(CHAPTER7);
		ch7_fips2_owns_real_estate.setFips(CH7_FIPS2);
		ch7_fips2_owns_real_estate.setSelfemployed(false);
		ch7_fips2_owns_real_estate.setNumberOfProperties(1);
		ch7_fips2_owns_real_estate.setHouseholdMember(1);
		ch7_fips2_owns_real_estate.setIncome(123.00);
		ch7_fips2_owns_real_estate.setExpectPrice(CH7_FIPS2_OWNS_REAL_ESTATE);
		priceModelList1.add(ch7_fips1_owns_real_estate);

		ch7_fips2_individual.setChapter(CHAPTER7);
		ch7_fips2_individual.setFips(CH7_FIPS2);
		ch7_fips2_individual.setSelfemployed(false);
		ch7_fips2_individual.setNumberOfProperties(0);
		ch7_fips2_individual.setHouseholdMember(1);
		ch7_fips2_individual.setIncome(123.00);
		ch7_fips2_individual.setMaritalStatus(SINGLE);
		ch7_fips2_individual.setExpectPrice(CH7_FIPS2_Individual);
		priceModelList1.add(ch7_fips1_individual);

		ch7_fips2_married.setChapter(CHAPTER7);
		ch7_fips2_married.setFips(CH7_FIPS2);
		ch7_fips2_married.setSelfemployed(false);
		ch7_fips2_married.setNumberOfProperties(0);
		ch7_fips2_married.setHouseholdMember(1);
		ch7_fips2_married.setIncome(123.00);
		ch7_fips2_married.setMaritalStatus(MARRIED);
		ch7_fips2_married.setExpectPrice(CH7_FIPS2_MARRIED);
		priceModelList1.add(ch7_fips1_married);




		ch13_disqualified.setChapter(CHAPTER13);
		ch13_disqualified.setFips(DISQUALIFIED_FIPS);
		ch13_disqualified.setRushCase(0);
		ch13_disqualified.setHouseholdMember(1);
		ch13_disqualified.setIncome(5000.00);
		priceModelList2.add(ch13_disqualified);

		ch13_fips1_null_totalPrice.setChapter(CHAPTER13);
		ch13_fips1_null_totalPrice.setFips(CH7_FIPS1);
		ch13_fips1_null_totalPrice.setRushCase(31);
		ch13_fips1_null_totalPrice.setHouseholdMember(1);
		ch13_fips1_null_totalPrice.setIncome(50000.00);
		ch13_fips1_null_totalPrice.setExpectPrice(CH13_FIP1_NORUSH);
		priceModelList2.add(ch13_fips1_null_totalPrice);

		ch13_fips1_over.setChapter(CHAPTER13);
		ch13_fips1_over.setFips(CH7_FIPS1);
		ch13_fips1_over.setRushCase(0);
		ch13_fips1_over.setHouseholdMember(1);
		ch13_fips1_over.setIncome(999999.00);
		ch13_fips1_over.setExpectPrice(CH13_FIP1_NORUSH);
		ch13_fips1_over.setExpectTotalPrice(CH13_FIP1_OVER);
		priceModelList2.add(ch13_fips1_over);

		ch13_fips1_over1.setChapter(CHAPTER13);
		ch13_fips1_over1.setFips(CH7_FIPS1);
		ch13_fips1_over1.setRushCase(1);
		ch13_fips1_over1.setHouseholdMember(1);
		ch13_fips1_over1.setIncome(999999.00);
		ch13_fips1_over1.setExpectPrice(CH13_FIP1_RUSH_1_7);
		ch13_fips1_over1.setExpectTotalPrice(CH13_FIP1_OVER);
		priceModelList2.add(ch13_fips1_over1);

		ch13_fips1_over2.setChapter(CHAPTER13);
		ch13_fips1_over2.setFips(CH7_FIPS1);
		ch13_fips1_over2.setRushCase(8);
		ch13_fips1_over2.setHouseholdMember(1);
		ch13_fips1_over2.setIncome(999999.00);
		ch13_fips1_over2.setExpectPrice(CH13_FIP1_RUSH_8_30);
		ch13_fips1_over2.setExpectTotalPrice(CH13_FIP1_OVER);
		priceModelList2.add(ch13_fips1_over2);

		ch13_fips1_under.setChapter(CHAPTER13);
		ch13_fips1_under.setFips(CH7_FIPS1);
		ch13_fips1_under.setRushCase(0);
		ch13_fips1_under.setHouseholdMember(1);
		ch13_fips1_under.setIncome(123.00);
		ch13_fips1_under.setExpectPrice(CH13_FIP1_NORUSH);
		ch13_fips1_under.setExpectTotalPrice(CH13_FIP1_UNDER);
		priceModelList2.add(ch13_fips1_under);

		ch13_fips1_under1.setChapter(CHAPTER13);
		ch13_fips1_under1.setFips(CH7_FIPS1);
		ch13_fips1_under1.setRushCase(1);
		ch13_fips1_under1.setHouseholdMember(1);
		ch13_fips1_under1.setIncome(123.00);
		ch13_fips1_under1.setExpectPrice(CH13_FIP1_RUSH_1_7);
		ch13_fips1_under1.setExpectTotalPrice(CH13_FIP1_UNDER);
		priceModelList2.add(ch13_fips1_under1);

		ch13_fips1_under2.setChapter(CHAPTER13);
		ch13_fips1_under2.setFips(CH7_FIPS1);
		ch13_fips1_under2.setRushCase(8);
		ch13_fips1_under2.setHouseholdMember(1);
		ch13_fips1_under2.setIncome(123.00);
		ch13_fips1_under2.setExpectPrice(CH13_FIP1_RUSH_8_30);
		ch13_fips1_under2.setExpectTotalPrice(CH13_FIP1_UNDER);
		priceModelList2.add(ch13_fips1_under2);




		ch13_fips2_null_totalPrice.setChapter(CHAPTER13);
		ch13_fips2_null_totalPrice.setFips(CH13_FIPS2);
		ch13_fips2_null_totalPrice.setRushCase(31);
		ch13_fips2_null_totalPrice.setHouseholdMember(1);
		ch13_fips2_null_totalPrice.setIncome(50000.00);
		ch13_fips2_null_totalPrice.setExpectPrice(CH13_FIP2_NORUSH);
		priceModelList3.add(ch13_fips2_null_totalPrice);

		ch13_fips2_over.setChapter(CHAPTER13);
		ch13_fips2_over.setFips(CH13_FIPS2);
		ch13_fips2_over.setRushCase(0);
		ch13_fips2_over.setHouseholdMember(1);
		ch13_fips2_over.setIncome(999999.00);
		ch13_fips2_over.setExpectPrice(CH13_FIP2_NORUSH);
		ch13_fips2_over.setExpectTotalPrice(CH13_FIP2_OVER);
		priceModelList3.add(ch13_fips2_over);

		ch13_fips2_over1.setChapter(CHAPTER13);
		ch13_fips2_over1.setFips(CH13_FIPS2);
		ch13_fips2_over1.setRushCase(1);
		ch13_fips2_over1.setHouseholdMember(1);
		ch13_fips2_over1.setIncome(999999.00);
		ch13_fips2_over1.setExpectPrice(CH13_FIP2_RUSH_1_7);
		ch13_fips2_over1.setExpectTotalPrice(CH13_FIP2_OVER);
		priceModelList3.add(ch13_fips2_over1);

		ch13_fips2_over2.setChapter(CHAPTER13);
		ch13_fips2_over2.setFips(CH13_FIPS2);
		ch13_fips2_over2.setRushCase(8);
		ch13_fips2_over2.setHouseholdMember(1);
		ch13_fips2_over2.setIncome(999999.00);
		ch13_fips2_over2.setExpectPrice(CH13_FIP2_RUSH_8_30);
		ch13_fips2_over2.setExpectTotalPrice(CH13_FIP2_OVER);
		priceModelList3.add(ch13_fips2_over2);

		ch13_fips2_under.setChapter(CHAPTER13);
		ch13_fips2_under.setFips(CH13_FIPS2);
		ch13_fips2_under.setRushCase(0);
		ch13_fips2_under.setHouseholdMember(1);
		ch13_fips2_under.setIncome(123.00);
		ch13_fips2_under.setExpectPrice(CH13_FIP2_NORUSH);
		ch13_fips2_under.setExpectTotalPrice(CH13_FIP2_UNDER);
		priceModelList3.add(ch13_fips2_under);

		ch13_fips2_under1.setChapter(CHAPTER13);
		ch13_fips2_under1.setFips(CH13_FIPS2);
		ch13_fips2_under1.setRushCase(1);
		ch13_fips2_under1.setHouseholdMember(1);
		ch13_fips2_under1.setIncome(123.00);
		ch13_fips2_under1.setExpectPrice(CH13_FIP2_RUSH_1_7);
		ch13_fips2_under1.setExpectTotalPrice(CH13_FIP2_UNDER);
		priceModelList3.add(ch13_fips2_under1);

		ch13_fips2_under2.setChapter(CHAPTER13);
		ch13_fips2_under2.setFips(CH13_FIPS2);
		ch13_fips2_under2.setRushCase(8);
		ch13_fips2_under2.setHouseholdMember(1);
		ch13_fips2_under2.setIncome(123.00);
		ch13_fips2_under2.setExpectPrice(CH13_FIP2_RUSH_8_30);
		ch13_fips2_under2.setExpectTotalPrice(CH13_FIP2_UNDER);
		priceModelList3.add(ch13_fips2_under2);

		int flag = 0;
		int flag1 = 0;
		int flag2 = 0;
		int flag3 = 0;
		MyRunnable m = new MyRunnable(priceModelList,flag);
		MyRunnable m1 = new MyRunnable(priceModelList1,flag1);
		MyRunnable m2 = new MyRunnable(priceModelList2,flag2);
		MyRunnable m3 = new MyRunnable(priceModelList3,flag3);
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(m);
        executorService.execute(m1);
        executorService.execute(m2);
        executorService.execute(m3);
        executorService.shutdown();
        while(true) {
        	boolean f = false;
        	if (executorService.isTerminated()) {
        		f = true;
        		flag = m.getFlag();
        		flag1 = m1.getFlag();
        		flag2 = m2.getFlag();
        		flag3 = m3.getFlag();
        	}
        	if(f){
        		return flag + flag1 + flag2 + flag3;
        	}
        	try {
        		TimeUnit.MILLISECONDS.sleep(100);
        	} catch (InterruptedException e) {
        		// TODO Auto-generated catch block
        		e.printStackTrace();
        	} 
        }
	}

}
