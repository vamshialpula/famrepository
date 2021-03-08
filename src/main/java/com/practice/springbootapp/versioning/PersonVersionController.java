package com.practice.springbootapp.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonVersionController {

	@GetMapping("/v1")
	public PersonV1 getPersonV1() {
		PersonV1 pv1 = new PersonV1("Sachin Tendulkar");
		return pv1;
	}

	@GetMapping("/v2")
	public PersonV2 getPersonV2() {
		PersonV2 pv2 = new PersonV2(new Name("Saurav", "Ganguly"));
		return pv2;
	}

	// versioning with params
	@GetMapping(value = "/person/param", params = "version=1")
	public PersonV1 personV1param() {
		PersonV1 pv1 = new PersonV1("Sachin Tendulkar");
		return pv1;
	}

	@GetMapping(value = "/person/param", params = "version=2")
	public PersonV2 personV2param() {
		PersonV2 pv2 = new PersonV2(new Name("Saurav", "Ganguly"));
		return pv2;
	}

	// versioning with headers
	@GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 personV1header() {
		PersonV1 pv1 = new PersonV1("Sachin Tendulkar");
		return pv1;
	}

	@GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 personV2header() {
		PersonV2 pv2 = new PersonV2(new Name("Saurav", "Ganguly"));
		return pv2;
	}

	// versioning with produces
	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 personV1produces() {
		PersonV1 pv1 = new PersonV1("Sachin Tendulkar");
		return pv1;
	}

	@GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 personV2produces() {
		PersonV2 pv2 = new PersonV2(new Name("Saurav", "Ganguly"));
		return pv2;
	}

}
