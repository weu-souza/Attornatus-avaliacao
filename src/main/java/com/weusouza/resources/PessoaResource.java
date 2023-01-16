package com.weusouza.resources;

import com.weusouza.DTO.PessoaDto;
import com.weusouza.domain.Pessoa;
import com.weusouza.repositories.PessoaRepository;
import com.weusouza.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<Pessoa> findById(@PathVariable  Integer id) {
        Pessoa obj = service.findById(id);
        return ResponseEntity.ok(obj);
    }
@GetMapping
    public ResponseEntity<List<PessoaDto>> findAll(){
    List<Pessoa> list = service.findAll();
    List<PessoaDto> listDto = list.stream().map(obj -> new PessoaDto(obj)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
    }


}
