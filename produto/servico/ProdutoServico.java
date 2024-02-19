package produto.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import produto.modelo.ProdutoModelo;
import produto.modelo.RespostaModelo;
import produto.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    @Autowired
     private ProdutoRepositorio pr;
    @Autowired
    private RespostaModelo rm;

    public ResponseEntity<?> cadastrar(ProdutoModelo pm, String acao){
        if (pm.getNome().equals("")){
            rm.setMensagem("O nome do produto é necessario");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getMarca().equals("")) {
            rm.setMensagem("O nome da marca é obrigatorio");
            return  new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else {
            if(acao.equals("cadastrar")){
                return  new ResponseEntity<ProdutoModelo>(pr.save(pm),HttpStatus.CREATED);

            }else {
                return  new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
            }

        }
    }

    public ResponseEntity<RespostaModelo> remover(long cod){
        pr.deleteById(cod);
        rm.setMensagem("O produto foi removido");
        return  new ResponseEntity<RespostaModelo>( rm, HttpStatus.OK);
    }

     public Iterable<ProdutoModelo> listar(){
         return pr.findAll();
     }
}
