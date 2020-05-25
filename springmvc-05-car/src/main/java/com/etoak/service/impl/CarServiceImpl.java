package com.etoak.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.Car;
import com.etoak.mapper.CarMapper;
import com.etoak.service.CarService;

@Service
public class CarServiceImpl implements CarService {
	@Autowired
	CarMapper carMapper;

	@Override
	public List<Car> querySome() {
		return carMapper.querySome();
	}

	@Override
	public int addCar(Car car) {
		return carMapper.addCar(car);
	}

	@Override
	public List<Car> check(String brand, String series) {
		return carMapper.check(brand,series);
	}

}
