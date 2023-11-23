package senac.com.br.Projeto.Integrador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import senac.com.br.Projeto.Integrador.frameWork.annotions.LogRest;
import senac.com.br.Projeto.Integrador.frameWork.utils.ProFutException;
import senac.com.br.Projeto.Integrador.frameWork.utils.ResponseUtil;
import senac.com.br.Projeto.Integrador.useCases.enderecos.domanis.EnderecosRequestDom;
import senac.com.br.Projeto.Integrador.useCases.enderecos.domanis.EnderecosResponseDom;
import senac.com.br.Projeto.Integrador.useCases.enderecos.impl.EnderecosServiceImpl;
import senac.com.br.Projeto.Integrador.useCases.enderecos.impl.repositorys.EnderecosRepository;

import java.util.List;

@Controller
@RequestMapping("/enderecos")
public class EnderecosController {

    @Autowired
    private EnderecosRepository enderecosRepository;

    @Autowired
    private EnderecosServiceImpl enderecosService;

    @GetMapping("/carregar")
    @LogRest
    public ResponseEntity<List<EnderecosResponseDom>> carregarEnderecos(){
        List<EnderecosResponseDom> out = enderecosService.carregarEndereco();

        return ResponseEntity.ok(out);
    }

    @PostMapping("/criar")
    @LogRest
    public ResponseEntity<?> criarEndereco(@RequestBody EnderecosRequestDom endereco){

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(enderecosService.criarEndereco(endereco));
        } catch (ProFutException e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(e.getMessages()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMapper("Erro não mapeado:" + e.getMessage()));
        }
    }

    @PutMapping("/atualizar/{id}")
    @LogRest
    public ResponseEntity<?> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecosRequestDom endereco){

        try {
            return ResponseEntity.ok(enderecosService.atualizarEndereco(id, endereco));
        } catch (ProFutException senac) {
            senac.printStackTrace();
            return ResponseEntity.badRequest().body(ResponseUtil.responseMapper(senac.getMessages()));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(ResponseUtil.responseMapper("Erro não mapeado:" +e.getMessage()));
        }
    }

    @DeleteMapping("/deletar/{id}")
    @LogRest
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id){
        enderecosService.deletarEndereco(id);

        return ResponseEntity.ok(null);
    }
}
