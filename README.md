# Atividade Árvore Binária de Busca Extendida (Extended Binary Search Tree)
Atividade realizada para a disciplina de Estrutura de Dados Básicas II.
## Autores
Eric Andrade Siqueira </br>
Lucas Gabriel Matias Paiva

## Informações
<p> O projeto tem como objetivo implementar uma árvore binária de busca que tenha melhor desempenho em todas as suas funcionalidades. Para isto, foram acrescentadas informações a serem armazenadas tanto na composição dos nós que formam a árvore quanto na própria árvore.

<p> Os nós (definidos na classe Node.java) possuem como atributos: o nó de seu lado direito e de seu lado esquerdo além de uma contagem sobre quantos nós existem em cada subárvore, desta forma algumas operações, como a verificação de ser cheia ou completa, foram facilitadas. Além dos atributos existem os métodos. Os métodos adotados aqui foram: os getters e setters padrões para uma classe em java, devido ao encapsulamento, um construtor que recebe como parâmetro um valor para o novo nó e que define os filhos como nulos, um construtor cópia (que não é utilizado), dois métodos para verificar se os filhos são nulos, verificação se os nós são incompletos (pois se uma árvore é completa, nenhuma de suas subárvores pode o ser), o mesmo para verificação de árvore cheia, uma sobrescrita do método toString() para imprimir apenas o valor.
