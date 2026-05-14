# Feira Fresca

Projeto desenvolvido em Java com base em Diagramas UML, utilizando Diagrama de Sequência e Diagrama de Classes de Projeto para implementação do sistema.

O sistema simula uma plataforma de assinatura semanal de frutas, legumes e verduras, permitindo cadastro de assinantes, validação SMS, seleção de planos, montagem da cesta semanal, cadastro de endereço, pagamento e persistência de dados.

---

# Estrutura do Projeto

O projeto foi organizado utilizando a separação entre:

* boundary
* control
* entity

## boundary

Responsável pela interação com o usuário.

Classe:

* TelaConsole

## control

Responsável pelas regras de negócio e controle do fluxo principal do sistema.

Classe:

* ControladorAssinatura

## entity

Responsável pelas entidades do domínio.

Classes:

* Assinante
* PlanoAssinatura
* Produto
* CestaSemanal
* EnderecoEntrega
* CartaoCredito
* Pagamento
* Protocolo
* VerificacaoSMS

---

# Funcionalidades Implementadas

* cadastro de assinante
* aceite obrigatório dos termos
* validação de número já cadastrado
* envio de código SMS
* reenvio de código SMS
* validação de código SMS
* seleção de plano
* seleção de frutas, legumes e verduras
* validação de limite conforme plano
* cadastro de endereço
* processamento de pagamento
* geração de protocolo
* persistência de dados

---

# Persistência

Foi utilizada persistência em arquivos .txt.

Arquivos utilizados:

* assinantes.txt
* assinaturas.txt

---

# Tecnologias Utilizadas

* Java
* IntelliJ IDEA
* UML
* GitHub

---

# Organização

O sistema foi desenvolvido garantindo correspondência entre os Diagramas UML e a implementação prática em Java, seguindo os conceitos de orientação a objetos e separação entre boundary, control e entity.
