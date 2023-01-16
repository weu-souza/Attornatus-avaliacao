package com.weusouza.resources;

import com.weusouza.DTO.PessoaDto;
import com.weusouza.domain.Pessoa;
import com.weusouza.repositories.PessoaRepository;
import com.weusouza.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletRequest;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {
    private final PessoaService service;


    @Autowired
    public PessoaResource(PessoaService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
        Pessoa obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping
    public ResponseEntity<List<PessoaDto>> findAll() {
        List<Pessoa> list = service.findAll();
        List<PessoaDto> listDto = list.stream().map(obj -> new PessoaDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa obj) {
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PessoaDto> update(@PathVariable Integer id, @RequestBody PessoaDto objDto) {
        Pessoa newObj = service.update(id, objDto);
        return ResponseEntity.ok().body(new PessoaDto(newObj));
    }
@DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
service.delete(id);
return ResponseEntity.noContent().build();
    }
}
