package com.lukaspkrr.backcursospring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lukaspkrr.backcursospring.domain.Categoria;
import com.lukaspkrr.backcursospring.domain.Cidade;
import com.lukaspkrr.backcursospring.domain.Cliente;
import com.lukaspkrr.backcursospring.domain.Endereco;
import com.lukaspkrr.backcursospring.domain.Estado;
import com.lukaspkrr.backcursospring.domain.Produto;
import com.lukaspkrr.backcursospring.domain.enums.TipoCliente;
import com.lukaspkrr.backcursospring.repositories.CategoriaRepository;
import com.lukaspkrr.backcursospring.repositories.CidadeRepository;
import com.lukaspkrr.backcursospring.repositories.ClienteRepository;
import com.lukaspkrr.backcursospring.repositories.EnderecoRepository;
import com.lukaspkrr.backcursospring.repositories.EstadoRepository;
import com.lukaspkrr.backcursospring.repositories.ProdutoRepository;

@SpringBootApplication
public class BackcursospringApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackcursospringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(3170206, "Uberlândia", est1);
		Cidade c2 = new Cidade(3550308, "São Paulo", est2);
		Cidade c3 = new Cidade(3509502, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Mario Bros.", "marioB1983@gmail.com", "21547854569", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("1138682658", "18002553700"));
		
		Endereco e1 = new Endereco(null, "Rua das Lajes", "01", "Perto da lojinha", "Bairro elevado", "01247859", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua das Flores", "06", "Perto do shopping", "Bairro rebaixado", "01264759", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		
	}

}

