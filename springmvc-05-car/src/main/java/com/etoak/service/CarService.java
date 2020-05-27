package com.etoak.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;

public interface CarService {
	//添加车辆信息
	int addCar(Car car);
	//List<Car> check(String brand,String series);
	List<Car> querySome();
	//查询车辆列表
	PageVo<CarVo> queryList(int pageNum,int pageSize,CarVo carVo, String[] priceList);
	//获取所有品牌
	List<String> getAllBrand();
	//根据品牌查询车系,品牌为空时,随机10条车系
	List<String> getSeriesByBrand(@Param("brand") String brand);
}
