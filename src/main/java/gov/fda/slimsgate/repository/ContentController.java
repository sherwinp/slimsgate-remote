package gov.fda.slimsgate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContentController {
	@GetMapping("/Content/{id}")
	public ResponseEntity<Object[]> getContentById(@PathVariable(value = "id") Long contentId) {
		return null;
	}
}
