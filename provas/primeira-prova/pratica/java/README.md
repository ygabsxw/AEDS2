# Alfabeto Alienígena

## Descrição

Mais uma vez, o OBI (Órgão Brasileiro de Inteligência) está preocupado com a possibilidade da existência de vida alienígena. Os diretores do órgão suspeitam que os alienígenas existem, conseguiram se infiltrar dentro da instituição e tem se comunicado secretamente. Os agentes do OBI se comunicam usando o dispositivo de mensagens oficial do órgão, que possui as seguintes teclas: letras maiúsculas de A a Z, letras minúsculas de a a z, dígitos de 0 a 9, operadores aritméticos (+,-, *, /), hashtag (#) e ponto de exclamação (!).


O OBI descobriu que, sempre que dois alienígenas se comunicam entre si usando o dispositivo, eles usam um alfabeto alienígena que possui um conjunto específico de símbolos. Assim, uma mensagem pode ter sido escrita por alienígenas se, e somente se, todos os símbolos que compõem ela pertencem ao alfabeto alienígena. Por exemplo, se o alfabeto alienígena for composto pelas caracteres !, 1, o e b, a mensagem ob1!! é uma mensagem que poderia ser escrita por alienígenas. Por outro lado, a mensagem Obi! não poderia ter sido escrita por alienígenas pois tanto o primeiro caractere O (maiúsculo) quanto o terceiro caractere i não fazem parte do alfabeto alienígena.

Você foi contratado para ajudar o OBI a identificar os invasores: dadas a lista de caracteres usados no alfabeto alienígena e uma mensagem enviada pelo dispositivo, determine se a mensagem poderia ter sido escrita por alienígenas ou não.

### Entrada
A primeira linha de entrada contém dois inteiros K e N separados por um espaço em branco, indicando, respectivamente, o número de caracteres presentes no alfabeto alienígena e o número de caracteres da mensagem enviada.

A segunda linha de entrada contém K caracteres distintos representando os caracteres pertencentes ao alfabeto alienígena.

A terceira linha de entrada contém N caracteres (não necessariamente distintos) representando a mensagem enviada.

### Saída
Seu programa deverá imprimir uma única linha contendo um único caractere: se a mensagem pode ter sido escrita no alfabeto alienígena, imprima a letra ‘S’ maiúscula; caso contrário, imprima a letra ‘N’ maiúscula.

### Exemplo de Entrada
```
4 5
!1ob
ob1!!

```

### Exemplos de Saída
```
S

```
