package br.edu.ifet.es.vendor.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifet.es.vendor.api.model.Login;
import br.edu.ifet.es.vendor.api.repository.LoginDAO;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/login")
public class LoginResource {
//https://blog.algaworks.com/como-criar-web-services-restful-com-spring-boot/

    @PersistenceContext
    private EntityManager em;

    @GetMapping
    public ResponseEntity<List<Login>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(new LoginDAO(em).findAll());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Login> criar(@Valid @RequestBody Login categoria, HttpServletResponse response) {
        new LoginDAO(em).save(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Login> buscarPeloCodigo(@PathVariable Long codigo) {
        Login categoria = new LoginDAO(em).find(codigo);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> logar(@RequestBody Login u ) {
        Login log = new LoginDAO(em).logar(u.getLogin(),u.getSenha());
        return (log != null)?ResponseEntity.status(HttpStatus.OK).body(log) : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Login Incorreto");
    }

}
