# Projeto-II-LEI

Projeto Final de Licenciatura em Engenharia Informática:

Este proejto envolve várias tecnologias e é "dividido" em várias partes. Uma delas, é o desenvolvimento de uma aplicação web com o propósito de ser um Backoffice e mostrar dados recolhidos por um ReaspberryPi e classificados utilizando algoritmos de machine learning a correr num servidor. A app foi desenvolvida utilizando a framework spring boot e a linguagem java. É dividido em vários microserviços independentes uns dos outros.

Neste caso, temos o Microserviço Eureka responsável por ser o load balancer e o que permite a comnuicação entre os restantes microserviços utilizando o Feign.
O microserviço Frontend é reponsável pelo UI da aplicação e o microserviço backend responsável por toda a lógica bem como a comunicação com a base de dados.
