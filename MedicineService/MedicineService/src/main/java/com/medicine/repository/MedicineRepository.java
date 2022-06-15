package com.medicine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicine.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {

	
}
