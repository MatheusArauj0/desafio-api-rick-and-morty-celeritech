# desafio-api-rick-and-morty-celeritech
<h4>SEJAM BEM VINDOS DEVS!!!</h4>
<hr/>
<p>Para testar a api você devera fazer um git clone na sua máquina ou baixar o projeto zipado e depois importar pra sua IDE.</p>
<p>Foi usada a IDE Spring Suit Tools para o desenvolvimento.</p>
<p>Depois de importar o projeto para a sua IDE devera startar a aplicação como Spring Boot App.</p>
<br/>
<p>Segue o link da minha collection do Postman para ajudar nas requisições dos endpoints: https://www.getpostman.com/collections/a9a16c59b37c42d9088b</p>
<p>O link acima deverá ser importado dentro do seu Postman</p>
<p>Atenção: se não tiver uma variavel de ambiente host configurada, apague a variavel {{host}} e coloque http://localhost:8080/nomeEndPoint</p>
<p>Essa api possui 4 endpoints: /personagens, /locais, /users, /oauth/token </p>
<p>Atenção: Apenas os métodos GET estão livres para consulta ao publico!</p>
<p>Para acessar os demais métodos POST, PUT e DELETE será necessário fazer um login na aplicação</p>
<p>Acredito que importando a minha collection do postman o ambiente já esteja configurado, mas caso nãa esteja entre em contato comigo por email!</p>
<p>Quando você fizer o login sera gerado hash do token, copie esse hash!</p>
<p>Agora é só você ir na aba "Authorization" de cada request mudar o "Type" para BEARER TOKEN e inserir o hash copiado no input que irá aparecer e pronto!</p>
<br/>
<h2>OBSERVAÇÕES:</h2>
<p>O HATEOAS não foi implementado 100%, você só ira consguir navegar pelos links gerados na própia entidade!</p>
<p>Por Exemplo:</p>
<p>Quando der um  GET em All personagens o objeto JSON vai te retornar um link próprio de cada obejto mas para os locais de Origin e Location não foi gerado link pois não consegui implementar 100%.</p>
<p>E consequente mente no GET all Locais acontecera o mesmo, irá te trazer um link próprio de cada Local mas não irar trazer o link do residents de cada local, apenas o seu nome!</p>
