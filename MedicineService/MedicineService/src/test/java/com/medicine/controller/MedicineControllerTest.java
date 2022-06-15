/*
 * package com.medicine.controller;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * import java.time.LocalDate; import java.util.ArrayList; import
 * java.util.List;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.params.ParameterizedTest; import
 * org.junit.jupiter.params.provider.MethodSource; import org.mockito.Mock;
 * import org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity;
 * 
 * import com.medicine.model.Medicine; import
 * com.medicine.service.MedicineService;
 * 
 * @SpringBootTest class MedicineControllerTest {
 * 
 * @Autowired private MedicineController medicineController;
 * 
 * @Mock private MedicineService medicineService;
 * 
 * @Test void getAll() {
 * Mockito.when(medicineService.getAllMedicine()).thenReturn(
 * saveMedicineTestDate()); List<Medicine>
 * list=medicineController.getAllMedicines();
 * assertEquals(saveMedicineTestDate().size(), list.size()); }
 * 
 * @ParameterizedTest
 * 
 * @MethodSource("saveMedicineTestDate") void saveMedicineT(Medicine medicine) {
 * Mockito.when(medicineService.saveMedicine(medicine)).thenReturn("Data Saved"
 * ); ResponseEntity<?> medicineData=medicineController.saveMedicine(medicine);
 * assertEquals(HttpStatus.OK, medicineData.getStatusCode()); } static
 * List<Medicine> saveMedicineTestDate(){ List<Medicine> list = new
 * ArrayList<Medicine>(); Medicine medicine=new Medicine();
 * medicine.setName("Strepsils");
 * medicine.setMfgDate(LocalDate.parse("2020-09-11"));
 * medicine.setExpiryDate(LocalDate.parse("2021-08-10"));
 * medicine.setDescription("gbsh gs hg sdhg"); list.add(medicine);
 * 
 * Medicine medicine4=new Medicine(); medicine4.setName("Strepsils");
 * medicine4.setMfgDate(LocalDate.parse("2020-09-11"));
 * medicine4.setExpiryDate(LocalDate.parse("2021-08-10"));
 * //medicine4.setDescription("gbsh gs hg sdhg"); list.add(medicine4); return
 * list; }
 * 
 * @ParameterizedTest
 * 
 * @MethodSource("saveMedicine_with_empty_valueTestDate") void
 * saveMedicine_with_empty_dataT(Medicine medicine) { ResponseEntity<?>
 * medicineData=medicineController.saveMedicine(medicine);
 * assertEquals(HttpStatus.BAD_REQUEST, medicineData.getStatusCode()); } static
 * List<Medicine> saveMedicine_with_empty_valueTestDate(){ List<Medicine> list =
 * new ArrayList<Medicine>(); Medicine medicine=new Medicine();
 * //medicine.setName("Strepsils");
 * medicine.setMfgDate(LocalDate.parse("2020-09-11"));
 * medicine.setExpiryDate(LocalDate.parse("2021-08-10"));
 * medicine.setDescription("gbsh gs hg sdhg"); list.add(medicine);
 * 
 * Medicine medicine2=new Medicine(); medicine2.setName("Strepsils");
 * //medicine.setMfgDate(LocalDate.parse("2020-09-11"));
 * medicine2.setExpiryDate(LocalDate.parse("2021-08-10"));
 * medicine2.setDescription("gbsh gs hg sdhg"); list.add(medicine2);
 * 
 * Medicine medicine3=new Medicine(); medicine3.setName("Strepsils");
 * medicine3.setMfgDate(LocalDate.parse("2020-09-11"));
 * //medicine3.setExpiryDate(LocalDate.parse("2021-08-10"));
 * medicine3.setDescription("gbsh gs hg sdhg"); list.add(medicine3);
 * 
 * list.add(null); return list; }
 * 
 * 
 * 
 * }
 */