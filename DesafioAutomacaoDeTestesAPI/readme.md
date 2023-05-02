# Automação da API com RestAssured

Projeto de Automação de API feito para o desafio.

##  Requisitos
 * Java 8+ JDK deve estar instalado
 * Maven deve estar instalado e configurado no path da aplicação

## Testes Criados
 * Consultar CPF Com Restrição
 * Consultar CPF Sem Restrição
 * Criar Simulação
 * Criar Simulação Sem Campos Obrigatórios
 * Criar Simulação Com o Mesmo CPF
 * Buscar Simulação Por CPF
 * Buscar Todas Simulações
 * Buscar Simulação Com CPF Inválido 
 * Alterar Simulação
 * Alterar Simulação Com Campos Vazios
 * Altera Simulação Com CPF Invalido
 * Deletar Simulação
 * Deletar Simulação Inexistente

## Diferenças encontradas na documentação

#### Criar Simulação

* O campo Seguro ele já deve estar setado algum valor True ou false, não consegui validar a mensagem.
* O campo CPF se colocar uma String vazia ele aceita, então não tem uma máscara, tive que retirar ele para validar a mensagem.
* Mensagem de CPF está diferente, está aparecendo CPF duplicado, na documentação está CPF já existente
* O statusCode apresentado no CPF duplicado é 400 não 409

#### Alterar Simulação
* Só tem validação no campo e-mail, o nome ficou vazio e os campos: valor, parcelas, seguro e CPF mantiveram os valores já salvos.

#### Deletar Simulação
* No caso de deletar uma simulação inexistente ele está apresentando o statusCode = 200