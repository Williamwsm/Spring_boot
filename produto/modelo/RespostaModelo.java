package produto.modelo;

import org.springframework.stereotype.Component;

@Component // injecao de dependencias

public class RespostaModelo {
    private  String mensagem;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
