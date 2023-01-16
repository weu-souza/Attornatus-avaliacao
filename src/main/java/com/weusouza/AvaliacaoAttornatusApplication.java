package com.weusouza;


import com.weusouza.Repositories.EnderecoRepository;
import com.weusouza.Repositories.PessoaRepository;
import com.weusouza.Domain.Endereco;
import com.weusouza.Domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDate;
import java.util.Arrays;


@SpringBootApplication
public class AvaliacaoAttornatusApplication implements CommandLineRunner {
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;


	public static void main(String[] args) {
		SpringApplication.run(AvaliacaoAttornatusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pessoa p1 = new Pessoa(null,"weu", LocalDate.of(1997, 11, 27));


		Endereco e1 = new Endereco(null,"rua8",72815460,12,"paraiba",p1);





		p1.getEnderecoPrincipal().addAll(Arrays.asList(e1));


		this.pessoaRepository.saveAll(Arrays.asList(p1));
		this.enderecoRepository.saveAll(Arrays.asList(e1));

	}
}
