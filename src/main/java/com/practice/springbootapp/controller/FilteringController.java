package com.practice.springbootapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.practice.springbootapp.model.FilterBean;

@RestController
@RequestMapping("/filter")
public class FilteringController {

	@GetMapping("/property")
	public MappingJacksonValue retrieveBean() {
		FilterBean bean = new FilterBean("value1", "value2", "value3");
		SimpleBeanPropertyFilter propsToFilter = SimpleBeanPropertyFilter.filterOutAllExcept("prop1", "prop2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("ReferenceFilterBean", propsToFilter);
		MappingJacksonValue mJacksonValue = new MappingJacksonValue(bean);
		mJacksonValue.setFilters(filterProvider);
		return mJacksonValue;
	}

	@GetMapping("/prop-list")
	public MappingJacksonValue retrieveBeanList() {
		List<FilterBean> filterBeanList = Arrays.asList(new FilterBean("value1", "value2", "value3"),
				new FilterBean("value11", "value22", "value33"));
		
		SimpleBeanPropertyFilter propsToFilter = SimpleBeanPropertyFilter.filterOutAllExcept("prop1", "prop2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("ReferenceFilterBean", propsToFilter);
		MappingJacksonValue mJacksonValue = new MappingJacksonValue(filterBeanList);
		mJacksonValue.setFilters(filterProvider);
		return mJacksonValue;
	}

}
