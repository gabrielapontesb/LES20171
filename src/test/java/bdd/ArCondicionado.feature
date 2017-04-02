Feature: Controlar a temperatura da sala

Scenario: Calcular a temperatura da sala
	Given Eu quero controlar a temperatura 
	When Cada sensor mede sua propria temperatura
	|0|5|10|
	And calcula a quantidade de pessoas na sala
	|25|27|20| 
	Then O ar deve normalizar a temperatura