package com.etoak.mapper;

import java.util.List;

import com.etoak.bean.Car;

public interface CarMapper {
	//添加车辆信息
	int addCar(Car car);
	List<Car> check(String brand,String series);
	List<Car> querySome();
}
