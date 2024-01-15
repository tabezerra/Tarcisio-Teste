package com.bank.accounts.bankaccounts.data.customer;

import com.bank.accounts.bankaccounts.data.customer.usecases.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/customer")
public class CustomerController {

	Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CreateCustomer createCustomer;

	@Autowired
	GetCustomer getCustomer;

	@Autowired
	GetAllCustomer getAllCustomer;

	@Autowired
	UpdateCustomer updateCustomer;

	@Autowired
	PatchCustomer patchCustomer;

	@Autowired
	DeleteCustomer deleteCustomer;

	@Operation(summary = "Create new Consumer")
	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerResponseModel> createCustomer(@RequestBody @Valid CustomerDto requestCustomer) {
		CustomerResponseModel response = new CustomerResponseModel(createCustomer.handle(requestCustomer));
		log.info("POST - created customer");
		return new ResponseEntity<CustomerResponseModel>(response, HttpStatus.CREATED);
	}

	@Operation(summary = "Get Consumer findById")
	@GetMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerResponseModel> getCustomer(@PathVariable String id) {
		CustomerResponseModel customerResponse = new CustomerResponseModel(getCustomer.handle(id).get());
		log.info("GET - customer");
		return new ResponseEntity<CustomerResponseModel>(customerResponse, HttpStatus.OK);
	}

	@Operation(summary = "Get all Consumer")
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CustomerResponseModel>> getAllCustomer() {
		log.info("GET all - customer");
		return new ResponseEntity<List<CustomerResponseModel>>(getAllCustomer.handle(), HttpStatus.OK);
	}

	@Operation(summary = "Put all fields Consumer")
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerResponseModel> updateCustomer(@RequestBody @Valid CustomerUpdateDto updateCustomerDto) {
		CustomerResponseModel response = new CustomerResponseModel(updateCustomer.handle(updateCustomerDto));
		log.info("PUT - customer");
		return new ResponseEntity<CustomerResponseModel>(response, HttpStatus.CREATED);
	}


	@Operation(summary = "Patch one or more fields Consumer")
	@PatchMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity patchCustomer(@PathVariable String id, @RequestBody Map<String, Object> fields) {
		patchCustomer.handle(id, fields);
		log.info("PATCH - customer");
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}


	@DeleteMapping(path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity deleteCustomer(@PathVariable String id) {
		deleteCustomer.handle(id);
		log.info("DELETE - customer");
		return new ResponseEntity("Consumer removido.", HttpStatus.OK);
	}

}
