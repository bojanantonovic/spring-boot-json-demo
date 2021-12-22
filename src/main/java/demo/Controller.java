package demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.LinkedHashSet;
import java.util.Set;

@RestController
public class Controller {

	private final Set<Person> persons = new LinkedHashSet<>();

	@PostConstruct
	public void init() {
		persons.add(new Person("Donald", "Duck"));
	}

	@GetMapping("/all")
	public Set<Person> index() {
		return persons;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addPerson(final @RequestBody Person person) {
		persons.add(person);
	}
}
