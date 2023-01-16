package com.weusouza.resources;

import com.weusouza.domain.Endereco;
import com.weusouza.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {
private final EnderecoService service;
@Autowired
    public EnderecoResource(EnderecoService service) {
        this.service = service;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Endereco>findById(@PathVariable Integer id){
    Endereco obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
    }
}
