package com.example.CDTT2.Genneric;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CDTT2.CommonData.AbstractEntity;
import com.example.CDTT2.CommonData.ResponseHandler.ResponseHandler;

public abstract class GenericController<DTO, T extends AbstractEntity, ID, BindingResult> {

	@Autowired
	private IGenericService<DTO, T, ID> iGenericService;

	@GetMapping("/findAll")
//	@PreAuthorize("hasAuthority('tutor-role')")
	public ResponseEntity<Object> findall() {
		List<T> ts = iGenericService.findAll();
		if (ts == null)
			return ResponseHandler.getResponse("There is no data.", HttpStatus.BAD_REQUEST);

		return ResponseHandler.getResponse(ts, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Object> create(@RequestBody DTO dto, BindingResult errors) {
		if (((Errors) errors).hasErrors())
			return ResponseHandler.getResponse("There is no data.", HttpStatus.BAD_REQUEST);

		T createdT = iGenericService.save(dto);

		return ResponseHandler.getResponse(createdT, HttpStatus.OK);
	}

	// @PostMapping("/createAll")
//	public ResponseEntity<Object> create( @RequestBody List<DTO> dto, BindingResult errors) {
//		if (((Errors) errors).hasErrors())
//			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	// List<T> createdT = iGenericService.createAll(dto);

	// return ResponseHandler.getResponse(createdT, HttpStatus.OK);
	// }

	@PutMapping("/update")
	public ResponseEntity<Object> update(@RequestBody DTO dto, BindingResult errors) {
		if (((Errors) errors).hasErrors())
			return ResponseHandler.getResponse("There is no data.", HttpStatus.BAD_REQUEST);

		T updatedT = iGenericService.update(dto);

		return ResponseHandler.getResponse(updatedT, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") ID id) {

		if (!iGenericService.findById(id).isPresent())
			return ResponseHandler.getResponse("There is no data.", HttpStatus.BAD_REQUEST);

		iGenericService.delete(id);

		return ResponseHandler.getResponse("delete successflly", HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Object> findById(@PathVariable("id") ID id) {
		Optional<T> t = iGenericService.findById(id);

		if (!t.isPresent())

			return ResponseHandler.getResponse("There is no data.", HttpStatus.BAD_REQUEST);

		return ResponseHandler.getResponse(t, HttpStatus.OK);
	}

}