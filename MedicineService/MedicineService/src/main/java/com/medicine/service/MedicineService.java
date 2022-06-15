package com.medicine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicine.customexception.BusinessException;
import com.medicine.dto.MedicineDto;
import com.medicine.model.Medicine;
import com.medicine.repository.MedicineRepository;

@Service
public class MedicineService {

	@Autowired
	private MedicineRepository repository;

	public Medicine saveMedicine(Medicine medicine) {
		// System.out.println(medicine.getName());
		try {
			if (medicine.getName().isEmpty() || medicine.getName().length() == 0) {
				throw new BusinessException("601", "Please enter proper name");
			}
			return repository.save(medicine);
		} catch (BusinessException e) {
			throw new BusinessException("602", "given employee is null" + e.getMessage());
		} catch (Exception e) {
			throw new BusinessException("603", "nothing to save" + e.getMessage());

		}

	}

	public List<Medicine> getAllMedicine() throws BusinessException {

		List<Medicine> medicineList = (List<Medicine>) repository.findAll();
		if (medicineList.isEmpty()) {
			throw new BusinessException("604", "List is empty");
		}
		return medicineList;

	}

	public Optional<Medicine> getMedicineById(int id) {

		try {
			return repository.findById(id);
		} catch (IllegalArgumentException e) {
			throw new BusinessException("606", "pls enter id");
		}
	}

	public String updateMedicineData(Medicine medicine) {
		repository.save(medicine);
		return "Updated Successfully";

	}

	public Medicine updateMedicinePartially(MedicineDto medicineDto) {
		Optional<Medicine> medicineEntityOptional = repository.findById(medicineDto.getId());
		if (medicineEntityOptional.isPresent()) {
			Medicine medicineEntity = medicineEntityOptional.get();
			System.out.println(medicineDto.getId());
			if (medicineDto.getName() != null) {
				medicineEntity.setName(medicineDto.getName());
			}
			if (medicineDto.getMfgDate() != null) {
				medicineEntity.setMfgDate(medicineDto.getMfgDate());
			}
			if (medicineDto.getExpiryDate() != null) {
				medicineEntity.setExpiryDate(medicineDto.getExpiryDate());
			}
			if (medicineDto.getDescription() != null) {
				medicineEntity.setDescription(medicineDto.getDescription());
			}
			if (medicineDto.getName() != null) {
				medicineEntity.setName(medicineDto.getName());
			}
			if(medicineEntity.getId()!=null) {
				return repository.save(medicineEntity);
			 
			}
			
		}
		return null;

	}

	public void deleteById(Integer id) {
		repository.deleteById(id);

	}
}
