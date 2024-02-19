package produto.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import produto.modelo.ProdutoModelo;
import produto.modelo.RespostaModelo;
import produto.servico.ProdutoServico;

@RestController // criar rotas
public class ProdutoControle {
    @Autowired
    private ProdutoServico ps;
    @DeleteMapping("/remover/{cod}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long cod){
        return ps.remover(cod);
    }
    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody ProdutoModelo pm){
        return ps.cadastrar(pm,"alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo pm){
        return ps.cadastrar(pm,"cadastrar");
    }

    @GetMapping("/listar")
    public  Iterable<ProdutoModelo> listar(){
        return ps.listar();
    }
    @GetMapping("/")
    public  String rota(){
        return "Api de produtos funcionando";
    }
}
