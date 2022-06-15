package com.medicine.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicine.customexception.BusinessException;
import com.medicine.customexception.ControllerException;
import com.medicine.dto.MedicineDto;
import com.medicine.model.Medicine;
import com.medicine.service.MedicineService;

@RestController
public class MedicineController {

	@Autowired
	private MedicineService medicineService;
	
	@PostMapping(value="/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveMedicine(@RequestBody Medicine medicine) {
		try {
			Medicine medicine1=medicineService.saveMedicine(medicine);
			return new ResponseEntity<>(medicine1,HttpStatus.CREATED);
		}catch(BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMsg());
			return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<>("Emp is  null",HttpStatus.BAD_REQUEST);
		}
				
		/*
		 * if(Objects.isNull(medicine)||Objects.isNull(medicine.getName())||Objects.
		 * isNull(medicine.getMfgDate())||Objects.isNull(medicine.getExpiryDate())) {
		 * return new ResponseEntity<>("Enter data properly",HttpStatus.BAD_REQUEST); }
		 * //System.out.println(medicine.getName()); return new
		 * ResponseEntity<>(medicineService.saveMedicine(medicine),HttpStatus.OK);
		 */
	}
	
	@GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllMedicines() {
		try {
			List<Medicine> list=medicineService.getAllMedicine();
			return  new ResponseEntity<List<Medicine>>(list,HttpStatus.OK);
		}catch(BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMsg());
			return  new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/getById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getMedicineById(@PathVariable Integer id) {
		if(id==null||id==0) {
			System.out.println("Enter id");
			ControllerException ce=new ControllerException("609","Pls enter proper data");
			return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);

		}
		try {
			
			Optional<Medicine> medicineOpt=medicineService.getMedicineById(id);
			if(medicineOpt.isPresent()) {
			return new ResponseEntity<>(medicineOpt.get(),HttpStatus.OK);
			}
		}catch(BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMsg());
			return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping(value ="/updatemedicineData")
	public ResponseEntity<?> updateMedicineData(@RequestBody Medicine medicine){
		if(medicine.getName()==null) {
			ControllerException ce=new ControllerException("610","name should not be null");
			return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(medicineService.updateMedicineData(medicine),HttpStatus.OK);
	} 
	
	@PatchMapping(value = "/updatePartially")
	public ResponseEntity<?> updateMedicinePartially(@RequestBody MedicineDto medicineDto){
		if(medicineService.updateMedicinePartially(medicineDto)==null) {
			ControllerException ce=new ControllerException("611","data not updated");
			return new ResponseEntity<>(ce,HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(medicineService.updateMedicinePartially(medicineDto),HttpStatus.OK);
		
	}
	@DeleteMapping(value = "/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer id) {
		if(id!=null) {
		medicineService.deleteById(id);
		}
		return new ResponseEntity<> (HttpStatus.OK);
	
	}
}
