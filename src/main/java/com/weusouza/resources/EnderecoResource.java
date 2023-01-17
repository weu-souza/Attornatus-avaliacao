package com.weusouza.resources;

import com.weusouza.DTO.EnderecoDto;
import com.weusouza.domain.Endereco;
import com.weusouza.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
    private final EnderecoService service;

    @Autowired
    public EnderecoResource(EnderecoService service) {
        this.service = service;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
        Endereco obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDto>> findByPessoaId(@RequestParam(value = "pessoa", defaultValue = "0") Integer id_pess) {
        List<Endereco> list = service.findByPessoaId(id_pess);
        List<EnderecoDto> listDto = list.stream().map(EnderecoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Integer id, @RequestBody Endereco obj) {
        Endereco newObj = service.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Endereco> create(@RequestParam(value = "pessoa", defaultValue = "0") Integer id_pess, @RequestBody Endereco obj) {
        Endereco newObj = service.create(id_pess, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/pessoas/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
