//package com.grupo16.sgpservice.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.grupo16.sgpservice.controller.json.EnderecoJson;
//import com.grupo16.sgpservice.domain.Endereco;
//import com.grupo16.sgpservice.usecase.CriarAlterarEnderecoUseCase;
//import com.grupo16.sgpservice.usecase.ObterEnderecoUseCase;
//import com.grupo16.sgpservice.usecase.RemoverEnderecoUseCase;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RestController
//@RequestMapping()
//public class EnderecoController {
//	
//	@Autowired
//	private CriarAlterarEnderecoUseCase criarAlterarEnderecoUseCase;
//
//	@Autowired
//	private ObterEnderecoUseCase obterEnderecoUseCase;
//	
//	@Autowired
//	private RemoverEnderecoUseCase removerEnderecoUseCase;
//
//	@ResponseStatus(HttpStatus.CREATED)
//	@PostMapping("condutores/{idCondutor}/enderecos")
//	public String criar(
//			@PathVariable(required = true, name = "idCondutor")String idCondutor, 
//			@RequestBody(required = true) EnderecoJson enderecoJson) {
//		log.trace("Start idCondutor={}, enderecoJson={}", idCondutor,enderecoJson);
//		
//		Endereco endereco = enderecoJson.mapearParaEnderecoDomain(null, idCondutor);
//		
//		String id = criarAlterarEnderecoUseCase.criar(endereco);
//				
//		log.trace("End id={}", id);
//		return id;
//	}
//	
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	@PutMapping("condutores/{idCondutor}/enderecos/{idEndereco}")
//	public void alterar(
//			@PathVariable(required = true, name = "idEndereco") String idEndereco,
//			@PathVariable(required = true, name = "idCondutor")String idCondutor,
//			@RequestBody(required = true) EnderecoJson enderecoJson) {
//		log.trace("Start idEndereco={}, idCondutor={}, enderecoJson={}", idEndereco, idCondutor, enderecoJson);
//		
//		Endereco endereco = enderecoJson.mapearParaEnderecoDomain(idEndereco, idCondutor);
//		
//		criarAlterarEnderecoUseCase.alterar(endereco);
//		
//		log.trace("End");
//	}
//	
//	@GetMapping("condutores/{idCondutor}/enderecos")
//	public EnderecoJson obter(
//			@PathVariable(required = true, name = "idCondutor") String idCondutor){
//		log.trace("Start idCondutor={}", idCondutor);
//		
//		Endereco endereco = obterEnderecoUseCase.obter(idCondutor);
//		
//		EnderecoJson enderecoJson = new EnderecoJson(endereco);
//		log.trace("End enderecoJson={}", enderecoJson);
//		return enderecoJson;
//	}
//	
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	@DeleteMapping("condutores/{idCondutor}/enderecos/{idEndereco}")
//	public void remover(
//			@PathVariable(required = true, name = "idCondutor") String idCondutor,
//			@PathVariable(required = true, name = "idEndereco") String idEndereco) {
//		log.trace("Start idCondutor={}, idEndereco={}", idCondutor, idEndereco);
//		
//		removerEnderecoUseCase.remover(idCondutor, idEndereco);
//		log.trace("End");
//	}
//	
//	
//}
